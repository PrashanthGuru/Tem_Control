package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Page FLT006 : Mark Flight Movements
 * 
 * @author a-7868
 * 
 */
public class FLT006 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "OPR_FLT.properties");
	public static String genObjPath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "Generic.properties");

	public static String FRAME = "iCargoContentFrameFLT006";

	By txt_carrier, txt_fltNum, txt_fltDt, btn_list, lnk_std, lnk_sta,lnk_std2, lnk_sta2,
			btn_save, info_footDiv, lnk_staSecondlg, link_stdSecondlg,
			info_msgClose, btn_close, yesBtn;

	WebDriver driver;
	String screenFrame;
	String dataFileName;

	public FLT006(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}

	/**
	 * Initializes the page objects required for the class a-7868 on 22/12/2017
	 */
	private void initElements() {
		txt_carrier = MiscUtility.getWebElement(objFilepath,
				"FLT006_txt_carrierCode");
		txt_fltNum = MiscUtility
				.getWebElement(objFilepath, "FLT006_txt_fltNum");
		txt_fltDt = MiscUtility
				.getWebElement(objFilepath, "FLT006_txt_fltDate");
		btn_list = MiscUtility.getWebElement(objFilepath, "FLT006_btn_list");
		lnk_std = MiscUtility.getWebElement(objFilepath, "FLT006_lnk_std");
		lnk_sta = MiscUtility.getWebElement(objFilepath, "FLT006_lnk_sta");
		lnk_std2 = MiscUtility.getWebElement(objFilepath, "FLT006_lnk_std2");
		lnk_sta2= MiscUtility.getWebElement(objFilepath, "FLT006_lnk_sta2");
		btn_save = MiscUtility.getWebElement(objFilepath, "FLT006_btn_save");
		btn_close = MiscUtility.getWebElement(objFilepath, "FLT006_btn_close");
		lnk_staSecondlg = MiscUtility.getWebElement(objFilepath,
				"FLT006_lnk_staSecondlg");
		link_stdSecondlg = MiscUtility.getWebElement(objFilepath,
				"FLT006_link_stdSecondlg");

		info_footDiv = MiscUtility.getWebElement(genObjPath,
				"Generic_foot_layer");
		info_msgClose = MiscUtility.getWebElement(genObjPath,
				"Generic_info_close");
		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
	}

	/**
	 * Method to mark flight departure(STD) / single leg on 22/12/2017
	 * 
	 * @param carrier
	 * @param fltNum
	 * @param fltDt
	 * @return
	 * @author a-7868
	 */
	public FLT006 markFltDeparture(String carrier, String fltNum, String fltDt) {

		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		list(carrier, fltNum, fltDt);

		Actions action = new Actions(driver);
		action.doubleClick(waitForElement(lnk_std)).perform();
		minWait();
		click(btn_save);
		captureAndAddScreenshot();
		driver.switchTo().defaultContent();
		Assert.assertTrue(
				waitForElement(info_footDiv).getText().contains(
						"Data Saved Successfully"),
				"ERROR : Unable to mark flight departure");
		waitForFrameAndSwitch(FRAME);
		// click(info_msgClose); //close the success message (green div)
		return this;
	}

	/**
	 * Method to mark flight arrival(STA) / single leg on 22/12/2017
	 * 
	 * @param carrier
	 * @param fltNum
	 * @param fltDt
	 * @return
	 * @author a-7868
	 */
	public FLT006 markFltArrival(String carrier, String fltNum, String fltDt) {

		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		InitialSetup.test.log(LogStatus.INFO, "Marking the flight movement");
		list(carrier, fltNum, fltDt);
		InitialSetup.test.log(LogStatus.INFO, "Listed the flight to be marked as arrived");
		Actions action = new Actions(driver);
//		action.doubleClick(waitForElement(lnk_sta)).build().perform();
		action.moveToElement(driver.findElement(By.xpath("(//table[@id='listMovementTable']//tbody/tr)[last()]/td[2]/a"))).doubleClick().perform();
		minWait();
		click(btn_save);
		captureAndAddScreenshot();
		driver.switchTo().defaultContent();
		Assert.assertTrue(
				waitForElement(info_footDiv).getText().contains(
						"Data Saved Successfully"),
				"ERROR : Unable to mark flight arrival");
		InitialSetup.test.log(LogStatus.INFO, "The flight : "+carrier+fltNum+" has been marked as arrived");
		waitForFrameAndSwitch(FRAME);
		// click(info_msgClose); //close the success message (green div)
		return this;
	}

	/**
	 * Method to mark both departure(STD) and arrival(STA) / single leg on
	 * 22/12/2017
	 * 
	 * @param carrier
	 * @param fltNum
	 * @param fltDt
	 * @return
	 * @author a-7868
	 */
	public FLT006 markFltMvmnt(String carrier, String fltNum, String fltDt) {

		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		String FlightNo = fltNum.replaceAll("[^0-9]", "");
		list(carrier, FlightNo, fltDt);

		Actions action = new Actions(driver);
		action.doubleClick(waitForElement(lnk_std)).perform();
		minWait();
		action.doubleClick(waitForElement(lnk_sta)).perform();
		minWait();
		click(btn_save);
		maxWait();
		waitForPageLoaded();
		driver.switchTo().defaultContent();
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions
					.textToBePresentInElement(waitForElement(info_footDiv),
							"Data Saved Successfully"));
			InitialSetup.test.log(LogStatus.INFO, "The flight : "+carrier+fltNum+" has been marked successfully");
		} catch (Throwable e) {
			Assert.fail("Unable to mark flight movement", e);
		}
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	
	public FLT006 markFltMvmntTestData(String carrier, String fltNum, String fltDt) {

		String FlightNo = fltNum.replaceAll("[^0-9]", "");
		list(carrier, FlightNo, fltDt);

		Actions action = new Actions(driver);
		action.doubleClick(waitForElement(lnk_std)).perform();
		minWait();
		action.doubleClick(waitForElement(lnk_sta)).perform();
		minWait();
		click(btn_save);
		maxWait();
		waitForPageLoaded();
		driver.switchTo().defaultContent();
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions
					.textToBePresentInElement(waitForElement(info_footDiv),
							"Data Saved Successfully"));
			InitialSetup.test.log(LogStatus.INFO, "The flight : "+carrier+fltNum+" has been marked successfully");
		} catch (Throwable e) {
			Assert.fail("Unable to mark flight movement", e);
		}
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	
	
	/**
	 * Method to mark both departure(STD) and arrival(STA) / single leg on
	 * 22/12/2017
	 * 
	 * @param carrier
	 * @param fltNum
	 * @param fltDt
	 * @return
	 * @author a-7868
	 */
	public FLT006 markFltMvmnt2ndRoute(String carrier, String fltNum, String fltDt) {

		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		String FlightNo = fltNum.replaceAll("[^0-9]", "");
		list(carrier, FlightNo, fltDt);

		Actions action = new Actions(driver);
		/*action.doubleClick(waitForElement(lnk_std2)).perform();
		minWait();*/
		action.doubleClick(waitForElement(lnk_sta2)).perform();
		minWait();
		click(btn_save);
		maxWait();
		waitForPageLoaded();
		driver.switchTo().defaultContent();
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions
					.textToBePresentInElement(waitForElement(info_footDiv),
							"Data Saved Successfully"));
			InitialSetup.test.log(LogStatus.INFO, "The flight : "+carrier+fltNum+" has been marked successfully");
		} catch (Throwable e) {
			Assert.fail("Unable to mark flight movement", e);
		}
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	
	/**
	 * Method to mark both departure(STD) / single leg on 22/12/2017
	 * 
	 * @param carrier
	 * @param fltNum
	 * @param fltDt
	 * @return
	 * @author a-6836
	 */
	public FLT006 markFltMvmntstd(String carrier, String fltNum, String fltDt) {

		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		list(carrier, fltNum, fltDt);

		Actions action = new Actions(driver);
		action.doubleClick(waitForElement(lnk_std)).perform();
		minWait();

		click(btn_save);
		driver.switchTo().defaultContent();
		Assert.assertTrue(
				waitForElement(info_footDiv).getText().contains(
						"Data Saved Successfully"),
				"ERROR : Unable to mark flight movement");
		waitForFrameAndSwitch(FRAME);
		// click(info_msgClose); //close the success message (green div)
		return this;
	}

	public FLT006 markFltMvmntMulti(String carrier, String fltNum, String fltDt) {

		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		list(carrier, fltNum, fltDt);

		Actions action = new Actions(driver);
		action.doubleClick(waitForElement(lnk_std)).perform();
		minWait();
		action.doubleClick(waitForElement(lnk_sta)).perform();
		minWait();
		/*action.doubleClick(waitForElement(link_stdSecondlg)).perform();
		minWait();
		action.doubleClick(waitForElement(lnk_staSecondlg)).perform();
		minWait();
*/
		click(btn_save);
		driver.switchTo().defaultContent();
		Assert.assertTrue(
				waitForElement(info_footDiv).getText().contains(
						"Data Saved Successfully"),
				"ERROR : Unable to mark flight movement");
		waitForFrameAndSwitch(FRAME);
		// click(info_msgClose); //close the success message (green div)
		return this;
	}

	/**
	 * Method to list flight on 22/12/2017
	 * 
	 * @param carrier
	 * @param fltNum
	 * @param fltDt
	 * @author a-7868
	 */
	public void list(String carrier, String fltNum, String fltDt) {

		enterKeys(txt_carrier, carrier);
		enterKeys(txt_fltNum, fltNum);
		enterKeys(txt_fltDt, fltDt);
		enterKeys(btn_list,Keys.F12 );
	}

	/**
	 * Method to close current page and return to Homepae returns the instance
	 * of Homepage
	 * 
	 * @return
	 * @author a-7868
	 */
	public HomePage close() {

		click(btn_close);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		return new HomePage(driver, dataFileName);
	}

	/**
	 * Method to Verify ETD and ETA not NUll
	 * 
	 * @param carrier
	 * @param fltNum
	 * @param fltDt
	 * @return
	 * @author Shalini
	 */
	public FLT006 verifyETDETA(String FlightNo,String fltDt) {
		// minWait();
		FlightNo = PropertyHandler.getPropValue(dataFilePath, FlightNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		enterKeys(txt_fltNum, FlightNo);
		enterKeys(txt_fltDt, fltDt+Keys.TAB);
		click(btn_list);
		minWait();

		if (driver.findElement(
				By.xpath("(//input[@name='expectedDateDeparture'])[1]"))
				.getAttribute("value") == "")

		{
			InitialSetup.test.log(LogStatus.FAIL, "TC failed");
		} else {
			InitialSetup.test.log(LogStatus.PASS, "ETD is Updated Passed");
		}
		String value1 = driver.findElement(
				By.xpath("(//input[@name='expectedDateArrival'])[2]"))
				.getAttribute("value");
		if (!(value1 == "")) {
			InitialSetup.test.log(LogStatus.FAIL, "TC failed");
		} else {
			InitialSetup.test.log(LogStatus.PASS, "ETD is Updated Passed");
		}
		click(btn_save);
		driver.switchTo().defaultContent();
		Assert.assertTrue(
				waitForElement(info_footDiv).getText().contains(
						"Data Saved Successfully"),
				"ERROR : Unable to mark flight departure");
		InitialSetup.test.log(LogStatus.PASS, "Data Saved Successfully");
		waitForFrameAndSwitch(FRAME);
		return this;

	}
	
	
}
