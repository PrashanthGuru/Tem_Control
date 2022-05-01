	package com.ibsplc.pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Screen MTK060 - Mail InBound
 * 
 * @author A-8680
 * 		Sharath
 * 
 * Date - 05Feb,2020
 */
public class MTK064 extends BasePage {

	public static String FRAME = "iCargoContentFrameMTK060";
	public static String screenFrame = "iCargoContentFrameMTK060";
	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"MTK.properties");
	private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"Generic.properties");
	WebDriver driver;
	String dataFileName;
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	private By yesBtn , noBtn  , btn_genericOk , okBtn;

	

	public MTK064(WebDriver driver, String dataFileName) {
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
	 * List And Do Carrier Acceptance
	 * Author - A-8680  Sharath
	 * @param Consignment Number
	 * @param PA
	 */

	public MTK064 ListMailbagCarrier(String flightNo, String flightDt) {

		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDt = PropertyHandler.getPropValue(dataFilePath, flightDt);
		maxWait();
		enterKeys(By.name("flightnumber.flightNumber"), flightNo.substring(2, 6));
		enterKeys(By.id("flightnumber_dateField"), flightDt);
		enterKeys(By.id("fromdatename"), "");
		enterKeys(By.id("toDateName"), "");
		click(By.xpath("//button[text()='List']"));
		minWait();
		click(By.xpath("//div[@aria-label='row']"));
		return this;
	}

	public MTK064 arriveAndDeliverMailbag(String flightNo, String flightDt) {
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDt = PropertyHandler.getPropValue(dataFilePath, flightDt);
		click(By.xpath("//h4[text()='Containers']/ancestor::div[7]//i[contains(@class,'ico-v-ellipsis')]"));
		click(By.xpath("(//button[contains(text(),'Arrive Mail')])[last()]"));
		maxWait();
	    String status=getText_JS(By.xpath("//div[@class='alert alert-info alert-dismissible fade show']"));
	    if(status.contains("Arrived Successfully")){
	    InitialSetup.test.log(LogStatus.PASS, "Arrival Status : "+status);
	    captureAndAddScreenshot();
	    }else{
	    	 InitialSetup.test.log(LogStatus.FAIL, "Arrival Status : "+status);	
	    }
		click(By.xpath("//h4[text()='Containers']/ancestor::div[7]//i[contains(@class,'ico-v-ellipsis')]"));
		click(By.xpath("(//button[contains(text(),'Deliver Mail')])[last()]"));
		minWait();
		click(By.xpath("//button[text()='Save']"));
		minWait();
		status = getText_JS(By.xpath("//div[@class='alert alert-info alert-dismissible fade show']"));
		if(status.contains("delivered successfully")){
		InitialSetup.test.log(LogStatus.PASS, "Delivery Status : "+status);
		captureAndAddScreenshot();
		}else{
			InitialSetup.test.log(LogStatus.FAIL, "Delivery Status : "+status);	
		}
		click(By.xpath("//button[text()='Close'][@formname='deliverMailDetails']"));
		return this;
	}
	
	
	public HomePage close() {
		click(By.xpath("//button[@id='BUT_MAIL_OPERATIONS_MAILINBOUND_CLOSE']"));
		logger.info("MTK060 screen closed");
		driver.switchTo().defaultContent();
		return new HomePage(driver, dataFileName);
	}

}
