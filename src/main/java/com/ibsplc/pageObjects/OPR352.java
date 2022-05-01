package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Screen OPR352 - AWN Enquiry screen Created on 31/05/2019
 * 
 * @author Sharath
 */
public class OPR352 extends BasePage {

	public static String FRAME = "iCargoContentFrameOPR352";
	public static String screenFrame = "iCargoContentFrameOPR352";
	private static String objFilepath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "OPR_FLT.properties");
	private static String genObjPath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "Generic.properties");
	WebDriver driver;
	String dataFileName;
	private String dataFilePath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "testDataDirectory");

	private By btn_genericYes, txt_prefix, txt_awbno, btn_list, btn_moreOptions, btn_FWB;


	public OPR352(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}

	/**
	 * Method to initialize page elements
	 */
	private void initElements() {
		
		btn_genericYes = MiscUtility.getWebElement(genObjPath,
				"Generic_btn_diaYes");
		txt_prefix = MiscUtility.getWebElement(objFilepath,
				"OPR352_txt_prefix");
		txt_awbno = MiscUtility.getWebElement(objFilepath,
				"OPR352_txt_awbno");
		btn_list = MiscUtility.getWebElement(objFilepath,
				"OPR352_btn_list");
		btn_moreOptions = MiscUtility.getWebElement(objFilepath, 
				"OPR352_btn_moreOptions");
		btn_FWB = MiscUtility.getWebElement(objFilepath, 
				"OPR352_btn_FWB");
		}

//	Sharath
	public OPR352 verifyIfFWBSent(String prefix, String awbno)
	 {
		
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		
		enterKeys(txt_prefix,prefix);
		enterKeys(txt_awbno,awbno);
		click(btn_list);
		maxWait();
		maxWait();
		
		click(btn_moreOptions);
		click(btn_FWB);
		
		try{
		scrollToView(btn_FWB);
		String msg = driver.findElement(By.xpath("(//div[text()='WASACCR~'])[1]")).getText();
		String status = driver.findElement(By.xpath("(//div[text()='WASACCR~'])[1]/parent::div/preceding-sibling::div//i/parent::div")).getText(); 
		if(driver.findElement(By.xpath("(//div[text()='WASACCR~'])[1]")).getText().contains("WASACCR")){
			InitialSetup.test.log(LogStatus.PASS, "FWB has been triggered to ACAS with message: "+msg+" and status being: "+status);
			captureAndAddScreenshot();
		}else{
			InitialSetup.test.log(LogStatus.FAIL, "FWB hasn't been triggered to ACAS with message: "+msg+" and status being: "+status);
			captureAndAddScreenshot();
		}
		}
		catch(Exception e){
			InitialSetup.test.log(LogStatus.FAIL, "FWB hasn't been triggered to ACAS");
			captureAndAddScreenshot();
		}
		return this;
	}
	
	public HomePage close() {

		click(By.id("CMP_Operations_Shipment_UX_AwbEnquiry_close"));
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {

			click(btn_genericYes);
		}
		return new HomePage(driver, dataFileName);
	}

	
}