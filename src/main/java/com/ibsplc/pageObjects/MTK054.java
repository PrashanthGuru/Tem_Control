package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Screen MTK054 - Maintain Consignment Screen
 * 
 * @author A-8457
 * 		Souvik
 * 
 * Date - 05Feb,2020
 */
public class MTK054 extends BasePage {

	public static String FRAME = "iCargoContentFrameMTK054";
	public static String screenFrame = "iCargoContentFrameMTK054";
	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"MTK.properties");
	private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"Generic.properties");
	WebDriver driver;
	String dataFileName;
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	private By yesBtn , noBtn  , btn_genericOk , okBtn;

	

	public MTK054(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}

	/**
	 * Initializes the page objects required for the class
	 */
	private void initElements() {

		
		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		okBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		
	}
	
	
	
	

	/*****
	 * 
	 * List Consignment and check for successful Cardit Load
	 * Author - A-8457  Souvik
	 * @param Consignment Number
	 * @param PA
	 */

	public MTK054 ListConsignment(String ConsignmentNumber, String PA) {

		ConsignmentNumber = PropertyHandler.getPropValue(dataFilePath, ConsignmentNumber);
		PA = PropertyHandler.getPropValue(dataFilePath, PA);
	
		minWait();
		enterKeys(By.xpath("//input[@name='conDocNo']"), ConsignmentNumber);
		enterKeys(By.xpath("//input[@name='paCode']"), PA);
		click(By.xpath("//button[@class='btn primary btn-primary iCargoButtonSmall btn btn-primary'][contains(text(),'List')]"));
		maxWait();
		click(By.xpath("//button[@class='btnbar btn btn-secondary']"));
		minWait();
		String MailbagID=driver.findElement(By.xpath("(//table[@class='htCore']//tr//td)[1]")).getText();
		if (MailbagID != null) {
			InitialSetup.test.log(LogStatus.PASS, "Cardit Message was succesfully uploaded");
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Cardit Message was not succesfully uploaded");
			Assert.fail("Error in Loading Cardit");
		}
		return this;
	}
	
	
	
	public HomePage close() {
		click(By.xpath("//button[@class='btn default btn-default iCargoButtonSmall btn btn-default'][contains(text(),'Close')]"));
		logger.info("MTK054 screen closed");
		driver.switchTo().defaultContent();
		return new HomePage(driver, dataFileName);
	}

}
