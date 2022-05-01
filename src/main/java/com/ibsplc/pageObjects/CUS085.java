package com.ibsplc.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * 
 * @author A-8452 Faizan
 * @date: 05-04-2019
 * @Screen: ACAS Message Progress
 *
 */
public class CUS085 extends BasePage{

	private static String objFilepath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "CAP_MSG.properties");
	private static String genObjPath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "Generic.properties");
	private String dataFilePath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "testDataDirectory");
	private final static Logger logger = Logger.getLogger(CAP018.class);

	private By btn_genericYes, info_msg, btn_noBtn,Generic_btn_ok,
	info_error,info_errormsg,footer_error,btn_generic_ok,btn_genericOk;;
	private String screenFrame;
	private String dataFileName;
	private WebDriver driver;

	private String reportFrame;

	public CUS085(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}

	/**
	 * Initializes all the webelements
	 * 
	 * @author A-8452 Faizan
	 */
	private void initElements() {

		screenFrame = "iCargoContentFrameCUS085";
		reportFrame = "reportFrame";

		Generic_btn_ok = MiscUtility
				.getWebElement(genObjPath, "Generic_btn_ok");

		btn_genericYes = MiscUtility.getWebElement(genObjPath,
				"Generic_btn_diaYes");
		btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		info_error = MiscUtility
				.getWebElement(genObjPath, "Generic_info_error");

		footer_error = MiscUtility.getWebElement(genObjPath,
				"Generic_footer_error");
		btn_generic_ok = MiscUtility
				.getWebElement(genObjPath, "Generic_btn_ok");

		btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");

		btn_genericYes = MiscUtility.getWebElement(genObjPath,
				"Generic_btn_diaYes");
		btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		footer_error = MiscUtility.getWebElement(genObjPath,
				"Generic_footer_error");

	}


	/**
	 * @author A-8452 Faizan
	 * @param PreAWB
	 * @param awbNo
	 * @param fromDt
	 * @param toDt
	 * @param Station
	 * @return
	 */
	public CUS085 ListAWB(String PreAWB, String awbNo, String fromDt, String toDt, String Station)
	{
		PreAWB=PropertyHandler.getPropValue(dataFilePath, PreAWB);
		awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
		fromDt=PropertyHandler.getPropValue(dataFilePath, fromDt);
		toDt=PropertyHandler.getPropValue(dataFilePath, toDt);
		Station=PropertyHandler.getPropValue(dataFilePath, Station);

		minWait();
		enterKeys(By.xpath("//*[@id='awb_p']"), PreAWB);
		enterKeys(By.xpath("//*[@id='awb_b']"), awbNo);
		enterKeys(By.xpath("//*[@id='fromDate']"), fromDt);
		enterKeys(By.xpath("//*[@id='toDate']"), toDt);
		enterKeys(By.xpath("//*[@name='stationCode']"), Station);
		click(By.xpath("//*[@name='btList']"));

		minWait();
		return this;
	}


/**
 * @author A-8452 Faizan
 * @param FWBStatusNeeded
 * @param ExpectedFWBStatus
 * @param FHLStatusNeeded
 * @param ExpectedFHLStatus
 * @return
 */
	public CUS085 VerifyFWBFHLStatus(boolean FWBStatusNeeded,String ExpectedFWBStatus,boolean FHLStatusNeeded, String ExpectedFHLStatus )
	{
		if(FWBStatusNeeded == true)
		{
			ExpectedFWBStatus=PropertyHandler.getPropValue(dataFilePath, ExpectedFWBStatus);
			String FWBStatus= driver.findElement(By.xpath("(//table[@class='fixed-header-table']//tbody//tr/td)[10]")).getText().trim();
			if(FWBStatus !=null && FWBStatus.equalsIgnoreCase(ExpectedFWBStatus))
			{
				InitialSetup.test.log(LogStatus.PASS, "FWB status is verified. FWB Status is: "+FWBStatus);
				captureAndAddScreenshot();
			}
			else
			{
				InitialSetup.test.log(LogStatus.FAIL, "FWB status is not matching. FWB Status displayed is: "+FWBStatus);
				captureAndAddScreenshot();
				//Assert.fail("FWB status is not matching with expected status");
			}
		}
		if(FHLStatusNeeded==true)
		{
			ExpectedFHLStatus=PropertyHandler.getPropValue(dataFilePath, ExpectedFHLStatus);
			String FHLStatus= driver.findElement(By.xpath("(//table[@class='fixed-header-table']//tbody//tr/td)[11]")).getText();
			if(FHLStatus !=null && FHLStatus.equalsIgnoreCase(ExpectedFWBStatus))
			{
				InitialSetup.test.log(LogStatus.PASS, "FHL status is verified. FWB Status is: "+FHLStatus);
			}
			else
			{
				InitialSetup.test.log(LogStatus.FAIL, "FWB status is not matching. FWB Status displayed is: "+FHLStatus);
//				Assertion.fail("FHL status is not matching with expected status");
			}
		}
		return this;
	}
	
	//Sharath
	public CUS085 VerifyPSNStatus()
	{
		String psnstatus= driver.findElement(By.xpath("//tbody//tr[1]//*[@fill]")).getAttribute("fill");
		if(psnstatus.equals("#008000")){
			InitialSetup.test.log(LogStatus.PASS, "PSN status is marked green indicating successful process");
			captureAndAddScreenshot();
		}
		else{
			InitialSetup.test.log(LogStatus.FAIL, "PSN status isn't marked green indicating unsuccessful process");
		}
			return this;
			}
	

	public HomePage close() {

		click(By.xpath("//*[@name='btClose']"));
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {

			click(btn_genericYes);
		}
		return new HomePage(driver, dataFileName);
	}

}
