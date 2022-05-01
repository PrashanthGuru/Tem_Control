package com.ibsplc.pageObjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Page FLT003 : Operational Flight
 * 
 * @author a-7868
 */
public class FLT003 extends BasePage {

	public static String objFilepath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "OPR_FLT.properties");
	public static String genFilepath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "Generic.properties");
	public static String FRAME = "iCargoContentFrameFLT003";
	public String filepath;
	WebDriver driver;
	String testDataFile;
	String browser;
	private By screenFrame, screenId, textcarrierCode, FlightNo, fltDate,
			button_list, btn_clear, yesBtn, noBtn, text_route, check_freq,
			list_schType, list_Ftype, text_effDate, chk_offrIndctr,
			btn_legDetails, text_depTime, text_arrTime, text_Atype,
			button_viewCap, txt_capWt, txt_capVol, button_legOk, button_save,
			button_diaOk, button_close, msg_success, info_msgClose,
			btn_capacityAdjust;
	private By txt_capAdjCapacityWt, txt_capAdjCapacityVol, btn_capAdjClose,
			table_segmentCapacity, info_dialogueContent,
			info_successMessageToast, chk_legCapactiy_retainCapacity;

	public FLT003(WebDriver driver, String testDataFile) {
		super(driver);
		this.driver = driver;
		this.testDataFile = testDataFile;
		PageFactory.initElements(this.driver, this);
		filepath = PropertyHandler.getPropValue(
				"resources\\EnvSetup.properties", "testDataDirectory")
				+ testDataFile;
		initPageElements();
	}

	/**
	 * Method to initialize page objects
	 * 
	 * @author a-7868
	 */
	private void initPageElements() {

		System.out.println("Going to capture all webElements..!");

		screenFrame = MiscUtility.getWebElement(objFilepath, "FLT003_frame");
		textcarrierCode = MiscUtility.getWebElement(objFilepath,
				"FLT003_txt_carrierCode");
		FlightNo = MiscUtility.getWebElement(objFilepath,
				"FLT003_txt_flightNum");
		fltDate = MiscUtility.getWebElement(objFilepath, "FLT003_txt_fltDate");
		button_list = MiscUtility.getWebElement(objFilepath,
				"FLT003_txt_listFlt");
		btn_clear = MiscUtility.getWebElement(objFilepath,
				"FLT003_txt_clearFlt");
		text_route = MiscUtility.getWebElement(objFilepath, "FLT003_txt_route");
		list_schType = MiscUtility.getWebElement(objFilepath,
				"FLT003_list_schType");
		list_Ftype = MiscUtility.getWebElement(objFilepath,
				"FLT003_list_FltType");
		chk_offrIndctr = MiscUtility.getWebElement(objFilepath,
				"FLT003_chk_offrIndicator");
		btn_legDetails = MiscUtility.getWebElement(objFilepath,
				"FLT003_btn_legDetails");
		button_save = MiscUtility.getWebElement(objFilepath,
				"FLT003_btn_saveFlt");
		button_close = MiscUtility.getWebElement(objFilepath,
				"FLT003_btn_close");
		btn_capacityAdjust = MiscUtility.getWebElement(objFilepath,
				"FLT003_btn_capacityAdjust");
		// window 2
		text_depTime = MiscUtility.getWebElement(objFilepath,
				"FLT003_txt_depTime");
		text_arrTime = MiscUtility.getWebElement(objFilepath,
				"FLT003_txt_arrTime");
		text_Atype = MiscUtility.getWebElement(objFilepath,
				"FLT003_txt_aircraftType");
		button_viewCap = MiscUtility.getWebElement(objFilepath,
				"FLT003_btn_viewCapacity");
		txt_capWt = MiscUtility.getWebElement(objFilepath, "FLT003_txt_capWt");
		txt_capVol = MiscUtility
				.getWebElement(objFilepath, "FLT003_txt_capVol");
		button_legOk = MiscUtility.getWebElement(objFilepath,
				"FLT003_btn_legOk");
		chk_legCapactiy_retainCapacity = MiscUtility.getWebElement(objFilepath,
				"FLT003_chk_legCapactiy_retainCapacity");
		// Capacity Adjustment screen
		txt_capAdjCapacityWt = MiscUtility.getWebElement(objFilepath,
				"FLT003_txt_capAdjCapacityWt");
		txt_capAdjCapacityVol = MiscUtility.getWebElement(objFilepath,
				"FLT003_txt_capAdjCapacityVol");
		btn_capAdjClose = MiscUtility.getWebElement(objFilepath,
				"FLT003_btn_capAdjClose");

		yesBtn = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
		noBtn = MiscUtility.getWebElement(genFilepath, "Generic_btn_noBtn");
		msg_success = MiscUtility.getWebElement(genFilepath,
				"Generic_foot_layer");
		info_msgClose = MiscUtility.getWebElement(genFilepath,
				"Generic_info_close");
		table_segmentCapacity = MiscUtility.getWebElement(objFilepath,
				"FLT003_table_segmentCapacity");
		info_dialogueContent = MiscUtility.getWebElement(genFilepath,
				"Generic_info_msg");
		info_successMessageToast = MiscUtility.getWebElement(genFilepath,
				"Info_successMessageToast");

		// System.out.println("Captured all webElements..!");
	}

	/**
	 * Method to create a scheduled flight - single leg
	 * 
	 * @param key_carrier_code
	 * @param key_route
	 * @param key_schType
	 * @param key_fltType
	 * @param key_depTime
	 * @param key_arrTime
	 * @param key_acType
	 * @param key_fltCapVol
	 * @param key_fltCapWt
	 * @param key_fltNum
	 * @param key_full_fltNum
	 * @param key_fltDate
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author a-7868
	 */
	public FLT003 createSingleLeg(String key_carrier_code, String key_route,
			String key_schType, String key_fltType, String key_depTime,
			String key_arrTime, String key_acType, String key_fltCapVol,
			String key_fltCapWt, String key_fltNum, String key_full_fltNum,
			String key_fltDate) throws InterruptedException, IOException {

		// fetch test data
		String data_carrierCode = PropertyHandler.getPropValue(filepath,
				key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath,
				key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath,
				key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath,
				key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath,
				key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType);
		String data_capVol = PropertyHandler.getPropValue(filepath,
				key_fltCapVol);
		String data_capWt = PropertyHandler
				.getPropValue(filepath, key_fltCapWt);

		enterKeys(textcarrierCode, data_carrierCode);

		String rand_fltnum;
		// to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(fltDate, ".");
			click(button_list);
			driver.switchTo().defaultContent();
			minWait();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			click(waitForElement(btn_clear));
		}

		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String fltDt = waitForElement(fltDate).getAttribute("value");
		// store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_full_fltNum,
				(data_carrierCode + fltNo).toString().replaceAll(" ", ""));
		PropertyHandler.setPropValue(filepath, key_fltDate, fltDt);

		click(waitForElement(text_route));
		enterKeys(text_route, data_route);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		check(chk_offrIndctr);
		click(btn_legDetails);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();
		waitForElement(text_depTime);
		enterKeys(text_depTime, data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);
		// screen refresh
		click(button_legOk);

		// switch back to main window
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);
		// System.out.println(waitForElement(msg_success).getText());
		// Assert.assertTrue(waitForElement(msg_success).getText().contains("Flight Saved Successfully"),
		// "ERROR : FLIGHT SAVED SUCCESSFULLY message not displayed");

		// click(info_msgClose);
		maxWait();
		return this;
	}

	/****
	 * For creating flight with prevous date author:A-6784
	 * 
	 * @param key_carrier_code
	 * @param key_route
	 * @param key_schType
	 * @param key_fltType
	 * @param key_depTime
	 * @param key_arrTime
	 * @param key_acType
	 * @param key_fltCapVol
	 * @param key_fltCapWt
	 * @param key_fltNum
	 * @param key_full_fltNum
	 * @param key_fltDate
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public FLT003 createSingleLegPreviousDate(String key_carrier_code,
			String key_route, String key_schType, String key_fltType,
			String key_depTime, String key_arrTime, String key_acType,
			String key_fltCapVol, String key_fltCapWt, String key_fltNum,
			String key_full_fltNum, String key_fltDate)
			throws InterruptedException, IOException {

		// fetch test data
		String data_carrierCode = PropertyHandler.getPropValue(filepath,
				key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath,
				key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath,
				key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath,
				key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath,
				key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType);
		String data_capVol = PropertyHandler.getPropValue(filepath,
				key_fltCapVol);
		String data_capWt = PropertyHandler
				.getPropValue(filepath, key_fltCapWt);

		enterKeys(textcarrierCode, data_carrierCode);

		String rand_fltnum;
		// to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);

			DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			Date date = new Date();

			String tmpdate = getPreviousMonthDate(date);
			enterKeys(fltDate, tmpdate);
			click(button_list);
			driver.switchTo().defaultContent();
			minWait();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			click(waitForElement(btn_clear));
		}

		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String fltDt = waitForElement(fltDate).getAttribute("value");
		// store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_full_fltNum,
				(data_carrierCode + fltNo).toString().replaceAll(" ", ""));
		PropertyHandler.setPropValue(filepath, key_fltDate, fltDt);

		click(waitForElement(text_route));
		enterKeys(text_route, data_route);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		check(chk_offrIndctr);
		click(btn_legDetails);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(text_depTime, data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);
		// screen refresh
		click(button_legOk);

		// switch back to main window
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		minWait();
		System.out.println(waitForElement(msg_success).getText());
		Assert.assertTrue(
				waitForElement(msg_success).getText().contains(
						"Flight Saved Successfully"),
				"ERROR : FLIGHT SAVED SUCCESSFULLY message not displayed");

		waitForFrameAndSwitch(FRAME);
		// click(info_msgClose);
		maxWait();
		return this;
	}

	/***
	 * Method to update a single leg flight (by editing the leg capacity)
	 * 
	 * @param key_carrier_code
	 * @param key_fltNum
	 * @param key_sDate
	 * @param key_capVol
	 * @param key_capWt
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author a-7868
	 */
	public FLT003 updateSingleLeg(String key_carrier_code, String key_fltNum,
			String key_sDate, String key_capVol, String key_capWt)
			throws InterruptedException, IOException {

		String data_carrierCode = PropertyHandler.getPropValue(filepath,
				key_carrier_code);
		String data_fltnum = PropertyHandler.getPropValue(filepath, key_fltNum);
		String data_capWt = PropertyHandler.getPropValue(filepath, key_capWt);
		String data_capVol = PropertyHandler.getPropValue(filepath, key_capVol);

		enterKeys(textcarrierCode, data_carrierCode);
		enterKeys(FlightNo, data_fltnum);
		enterKeys(fltDate, ".");
		click(waitForElement(button_list));
		click(btn_legDetails);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(txt_capVol, data_capVol);
		enterKeys(txt_capWt, data_capWt);
		click(button_legOk);
		minWait();
		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}// handle the case when no pop-up is displayed
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(button_save);
		driver.switchTo().defaultContent();
		// to handle the editing flt with booking
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		minWait();
		Assert.assertTrue(
				waitForElement(msg_success).getText().contains(
						"Flight Saved Successfully"),
				"ERROR : FLIGHT SAVED SUCCESSFULLY message not displayed");

		waitForFrameAndSwitch(FRAME);
		// click(info_msgClose);
		maxWait();

		return this;
	}

	/***
	 * Method to update a single leg flight (by editing the leg capacity)
	 * 
	 * @param key_capVol
	 * @param key_capWt
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author a-7868
	 */
	public FLT003 updateSingleLegFromFLT002(String key_capVol, String key_capWt)
			throws InterruptedException, IOException {

		String data_capWt = PropertyHandler.getPropValue(filepath, key_capWt);
		String data_capVol = PropertyHandler.getPropValue(filepath, key_capVol);

		click(btn_legDetails);
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(txt_capVol, data_capVol);
		enterKeys(txt_capWt, data_capWt);
		click(button_legOk);
		minWait();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}// handle the case when no pop-up is displayed
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch("iCargoContentFrameFLT002");
		click(button_save);
		driver.switchTo().defaultContent();
		// to handle the editing flt with booking
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		minWait();
		Assert.assertTrue(
				waitForElement(msg_success).getText().contains(
						"Flight Saved Successfully"),
				"ERROR : FLIGHT SAVED SUCCESSFULLY message not displayed");

		waitForFrameAndSwitch("iCargoContentFrameFLT002");
		// click(info_msgClose);
		maxWait();

		return this;
	}

	/**
	 * Checks the flights total capacity vs the given parameter
	 * 
	 * @param expTotWt
	 * @param expTotVol
	 * @return
	 * @author Arun A-7681
	 */
	public FLT003 checkFlightTotCapacity(String expTotWt, String expTotVol) {

		expTotWt = PropertyHandler.getPropValue(filepath, expTotWt);
		expTotVol = PropertyHandler.getPropValue(filepath, expTotVol);

		click(btn_capacityAdjust);
		waitForNewWindow(2);
		switchToSecondWindow();
		scrollToView(txt_capAdjCapacityWt);
		Assert.assertEquals(expTotWt, waitForElement(txt_capAdjCapacityWt)
				.getAttribute("value").trim(),
				"The total capacity volume is not matching");
		Assert.assertEquals(expTotVol, waitForElement(txt_capAdjCapacityVol)
				.getAttribute("value").trim(),
				"The total capacity volume is not matching");
		click(btn_capAdjClose);
		switchToFirstWindow();
		waitForFrameAndSwitch("iCargoContentFrameFLT002");
		return this;
	}

	/**
	 * Method to close current page and return to the FLT002 screen returns the
	 * Homepage instance
	 * 
	 * @return
	 * @author a-7681 Arun
	 */
	public FLT002 closeToFLT002() {

		click(button_close);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		waitForFrameAndSwitch("iCargoContentFrameFLT002");
		return new FLT002(driver, testDataFile);
	}

	/**
	 * Method to close current page and return to the homepage returns the
	 * Homepage instance
	 * 
	 * @return
	 * @author a-7868
	 */
	public HomePage close() {

		click(button_close);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		return new HomePage(driver, testDataFile);
	}

	/**
	 * Created by A-7605
	 * 
	 * @param carrierCode
	 * @param flightNo
	 * @param scheduleDate
	 * @param aircraftType
	 * @param defaultWeight
	 * @param defaultVolume
	 * @return
	 */

	public FLT003 updateAircraftType(String carrierCode, String flightNo,
			String scheduleDate, String aircraftType, String defaultWeight,
			String defaultVolume) {
		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		flightNo = PropertyHandler.getPropValue(filepath, flightNo);
		scheduleDate = PropertyHandler.getPropValue(filepath, scheduleDate);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
		defaultWeight = PropertyHandler.getPropValue(filepath, defaultWeight);
		defaultVolume = PropertyHandler.getPropValue(filepath, defaultVolume);
		String actualWeight;
		String actualVolume;
		String currentWeight;
		String currentVolume;

		enterKeys(textcarrierCode, carrierCode);
		enterKeys(FlightNo, flightNo);
		enterKeys(fltDate, scheduleDate);
		click(waitForElement(button_list));
		click(btn_legDetails);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(text_Atype, aircraftType);
		click(button_viewCap);
		actualWeight = waitForElement(txt_capWt).getAttribute("value");
		actualVolume = waitForElement(txt_capVol).getAttribute("value");
		click(button_legOk);
		switchToFirstWindow();
		driver.switchTo().defaultContent();
		minWait();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		minWait();
		enterKeys(textcarrierCode, carrierCode);
		enterKeys(FlightNo, flightNo);
		enterKeys(fltDate, scheduleDate + Keys.TAB);
		maxWait();
		maxWait();
		click(waitForElement(button_list));
		click(btn_legDetails);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		currentWeight = waitForElement(txt_capWt).getAttribute("value");
		currentVolume = waitForElement(txt_capVol).getAttribute("value");
		click(button_legOk);
		switchToFirstWindow();
		driver.switchTo().defaultContent();
		minWait();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		System.out.println("Actual Wt:" + actualWeight);
		System.out.println("currentWeight:" + currentWeight);
		System.out.println("defaultWeight:" + defaultWeight);
		System.out.println("defaultVolume:" + defaultVolume);
		System.out.println("actualVolume:" + actualVolume);
		Assert.assertTrue(currentWeight.equals(actualWeight));
		Assert.assertTrue(currentVolume.equals(actualVolume));
		Assert.assertTrue(defaultWeight.equals(actualWeight));
		Assert.assertTrue(defaultVolume.equals(actualVolume));
		return this;
	}

	public FLT003 verifyWeightAndVolume(String carrierCode, String flightNo,
			String flightDate, String weight, String volume) {
		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		flightNo = PropertyHandler.getPropValue(filepath, flightNo);
		flightDate = PropertyHandler.getPropValue(filepath, flightDate);
		weight = PropertyHandler.getPropValue(filepath, weight);
		volume = PropertyHandler.getPropValue(filepath, volume);

		enterKeys(textcarrierCode, carrierCode);
		enterKeys(FlightNo, flightNo);
		enterKeys(fltDate, flightDate);
		// enterKeys(fltDate, ".");
		click(waitForElement(button_list));
		minWait();
		Assert.assertEquals(getTableCellValue(table_segmentCapacity, 11, 1),
				weight);
		Assert.assertEquals(getTableCellValue(table_segmentCapacity, 12, 1),
				volume);
		return this;
	}

	public FLT003 updateFlightAircraftType(String carrierCode, String flightNo,
			String scheduleDate, String aircraftType) {
		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		flightNo = PropertyHandler.getPropValue(filepath, flightNo);
		scheduleDate = PropertyHandler.getPropValue(filepath, scheduleDate);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);

		enterKeys(textcarrierCode, carrierCode);
		enterKeys(FlightNo, flightNo);
		enterKeys(fltDate, scheduleDate);
		click(waitForElement(button_list));
		click(btn_legDetails);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(text_Atype, aircraftType);
		click(button_viewCap);
		Assert.assertEquals(
				waitForElement(info_dialogueContent).getText(),
				"Any Specific Capacity specified will be replaced by Default Capacity of new Aircraft Type. Do you want to continue?");
		click(yesBtn);
		String defaultWeight = waitForElement(txt_capWt).getAttribute("value");
		String defaultVol = waitForElement(txt_capVol).getAttribute("value");
		click(button_legOk);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		minWait();
		enterKeys(textcarrierCode, carrierCode);
		enterKeys(FlightNo, flightNo);
		enterKeys(fltDate, scheduleDate);
		waitForElementNotPresent(info_successMessageToast);
		click(waitForElement(button_list));
		minWait();
		click(btn_legDetails);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		Assert.assertEquals(waitForElement(txt_capWt).getAttribute("value"),
				defaultWeight);
		Assert.assertEquals(waitForElement(txt_capVol).getAttribute("value"),
				defaultVol);
		click(button_legOk);
		switchToFirstWindow();
		minWait();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		Assert.assertTrue(
				waitForElement(msg_success).getText().contains(
						"Flight Saved Successfully"),
				"ERROR : FLIGHT SAVED SUCCESSFULLY message not displayed");
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	public FLT003 createOALFlight(String key_carrier_code, String key_route,
			String key_schType, String key_fltType, String key_depTime,
			String key_arrTime, String key_acType, String key_fltNum,
			String key_full_fltNum, String key_fltDate)
			throws InterruptedException, IOException {

		// fetch test data
		String data_carrierCode = PropertyHandler.getPropValue(filepath,
				key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath,
				key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath,
				key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath,
				key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath,
				key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType);

		enterKeys(textcarrierCode, data_carrierCode);

		String rand_fltnum;
		// to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(fltDate, ".");
			click(button_list);
			driver.switchTo().defaultContent();
			minWait();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			click(waitForElement(btn_clear));
		}

		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String fltDt = waitForElement(fltDate).getAttribute("value");
		// store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_full_fltNum,
				(data_carrierCode + fltNo).toString().replaceAll(" ", ""));
		PropertyHandler.setPropValue(filepath, key_fltDate, fltDt);

		click(waitForElement(text_route));
		enterKeys(text_route, data_route);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		check(chk_offrIndctr);
		click(btn_legDetails);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();
		waitForElement(text_depTime);
		enterKeys(text_depTime, data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);
		// screen refresh
		click(button_legOk);

		// switch back to main window
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		minWait();
		click(waitForElement(yesBtn));
		minWait();
		Assert.assertTrue(
				waitForElement(msg_success).getText().contains(
						"Flight Saved Successfully"),
				"ERROR : FLIGHT SAVED SUCCESSFULLY message not displayed");

		waitForFrameAndSwitch(FRAME);
		// click(info_msgClose);
		maxWait();
		return this;
	}

	/**
	 * Method to chck whether a Flight exists
	 * 
	 * @param carrCode
	 * @param fltNum
	 * @param fltDt
	 * @return
	 * @author A-7868 Krishna <07/05/2018>
	 */
	public FLT003 verifyFlightListed(String carrCode, String fltNum,
			String fltDt) {

		carrCode = PropertyHandler.getPropValue(filepath, carrCode);
		fltNum = PropertyHandler.getPropValue(filepath, fltNum);
		fltDt = PropertyHandler.getPropValue(filepath, fltDt);

		enterKeys(textcarrierCode, carrCode);
		enterKeys(FlightNo, fltNum);
		enterKeys(fltDate, fltDt);
		click(button_list);
		minWait();

		Assert.assertFalse(waitForElement(text_route).getAttribute("value")
				.equals(""), "ERROR : Flight not listed.");
		return this;
	}

	/**
	 * Method to update leg capacity by selecting the Retain Capacity checkbox
	 * 
	 * @param key_carrier_code
	 * @param key_fltNum
	 * @param key_sDate
	 * @param key_capVol
	 * @param key_capWt
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author A-7868 Krishna <04/07/2018>
	 */
	public FLT003 updateSingleLegWithRetainCapacity(String key_carrier_code,
			String key_fltNum, String key_sDate, String key_capVol,
			String key_capWt) throws InterruptedException, IOException {

		String data_carrierCode = PropertyHandler.getPropValue(filepath,
				key_carrier_code);
		String data_fltnum = PropertyHandler.getPropValue(filepath, key_fltNum);
		String data_capWt = PropertyHandler.getPropValue(filepath, key_capWt);
		String data_capVol = PropertyHandler.getPropValue(filepath, key_capVol);

		enterKeys(textcarrierCode, data_carrierCode);
		enterKeys(FlightNo, data_fltnum);
		enterKeys(fltDate, ".");
		click(waitForElement(button_list));
		click(btn_legDetails);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(chk_legCapactiy_retainCapacity);
		enterKeys(txt_capVol, data_capVol);
		enterKeys(txt_capWt, data_capWt);
		click(button_legOk);
		minWait();
		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}// handle the case when no pop-up is displayed
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(button_save);
		driver.switchTo().defaultContent();
		// to handle the editing flt with booking
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		minWait();
		Assert.assertTrue(
				waitForElement(msg_success).getText().contains(
						"Flight Saved Successfully"),
				"ERROR : FLIGHT SAVED SUCCESSFULLY message not displayed");

		waitForFrameAndSwitch(FRAME);
		maxWait();

		return this;
	}

	/**
	 * Method to verify leg capacity wt and vol
	 * 
	 * @param carrcode
	 * @param fltNum
	 * @param sDate
	 * @param capVol
	 * @param capWt
	 * @return
	 * @author A-7868 Krishna <04/07/2018>
	 */
	public FLT003 verifyLegCapacityWtVol(String carrcode, String fltNum,
			String sDate, String capVol, String capWt) {

		carrcode = PropertyHandler.getPropValue(filepath, carrcode);
		fltNum = PropertyHandler.getPropValue(filepath, fltNum);
		sDate = PropertyHandler.getPropValue(filepath, sDate);
		capVol = PropertyHandler.getPropValue(filepath, capVol);
		capWt = PropertyHandler.getPropValue(filepath, capWt);

		enterKeys(textcarrierCode, carrcode);
		enterKeys(FlightNo, fltNum);
		enterKeys(fltDate, ".");
		click(waitForElement(button_list));
		click(btn_legDetails);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();

		Assert.assertTrue(waitForElement(txt_capVol).getAttribute("value")
				.equals(capVol), "Capacity Vol mismatch");
		Assert.assertTrue(waitForElement(txt_capWt).getAttribute("value")
				.equals(capWt), "Capacity Wt mismatch");

		click(button_legOk);
		minWait();
		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}// handle the case when no pop-up is displayed
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		return this;
	}
	 public String getAttributeFromText(String path,String pryKey) throws IOException{
			
    	 String deatils="";
			System.out.println();
    	 String sCurrentLine = "";
 		BufferedReader br = new BufferedReader(new FileReader(new File(path)));

 		while ((sCurrentLine = br.readLine()) != null) {
 			
 			
 			if(sCurrentLine.trim().contains(pryKey))
 			//sCurrentLine;
 			{	 deatils=sCurrentLine.replace(pryKey,"").replace("<", "").replace(">", "").replace(" ", "").replace("/", "");
 			
 			System.out.println(deatils);
 			
 			break;
 			}
 	}
		return deatils;
 			
 			}
	/**
	 * Created by Shalini
	 * 
	 * @return
	 * @throws IOException
	 */
	public FLT003 VerifyAircraftType(String FlightNumber, String path, String pryKey)
			throws IOException {
		boolean isFound = true;
		 FlightNumber = PropertyHandler.getPropValue(filepath, "FlightNo");
		//By fltNum=FlightNo;
		enterKeys(FlightNo,FlightNumber);
		enterKeys(fltDate, ".");
		click(button_list);
		minWait();
		String aircarfyType = getAttributeFromText(path, pryKey);
		String actualValue = driver.findElement(
				By.xpath("(//table[@id='flightLegTable']//tr//td[8])[2]")).getText();
		Assert.assertTrue(isFound, "Aircraft Type is matching"
				+ aircarfyType + actualValue);
		logger.info("Aircraft type is Matching");
		InitialSetup.test.log(LogStatus.PASS, "Aircraft type is Matching");
		return this;
	}
}
