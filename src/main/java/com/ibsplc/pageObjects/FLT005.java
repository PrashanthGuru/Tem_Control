package com.ibsplc.pageObjects;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.common.BaseSetup.Days;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * @author a-7868
 */
public class FLT005 extends BasePage {

	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	public static String filepath;

	public static String FRAME = "iCargoContentFrameFLT005";
	WebDriver driver;
	String testDataFile;
	private By textcarrierCode,
	FlightNo,
	StartDate,
	EndDate,
	button_list,
	btn_clear,
	leg2,
	yesBtn,
	noBtn,
	text_route,
	check_freq,
	list_schType,
	list_Ftype,
	text_effDate,
	btn_legCapacity,
	text_depTime,
	text_arrTime,
	text_Atype,
	button_viewCap,
	txt_capWt,
	txt_capVol,
	button_legOk,
	button_save,
	button_diaOk,
	button_close,
	msg_success,
	info_msgClose,
	txt_loadFactor,
	txt_ovrWt,
	txt_ovrVol,
	tab_segment,
	list_chkBxSeg,
	btn_segUpdtCapacity,
	chkBx_defineGSC,
	txt_GSC,
	txt_SCL,
	btn_segCapacityOk,
	ifo_status,
	chkbox_domesticFlights,
	txt_dayChangeAtOrigin,
	txt_dayChangeAtDestination,
	legCapacity_chkbox_mon,
	legCapacity_chkbox_tue,
	legCapacity_chkbox_sun,
	legCapacity_chkbox_wed,
	legCapacity_chkbox_thu,
	legCapacity_chkbox_fri,
	legCapacity_chkbox_sat,
	legCapacity_txt_loadFactor2,
	legCapacity_btn_changeCapacity,
	legCapacity_table_specificCapacity,
	dialogueText,
	txt_L3,
	txt_L7,
	txt_Q6,
	txt_Q7,
	txt_bup,
	chkbox_firstSegment,
	defaultCapacity_txt_GSC_Weight,
	defaultCapacity_txt_GSC_Volume,
	segmentCapacity_txt_GSC_L3,
	segmentCapacity_txt_GSC_L7,
	segmentCapacity_txt_GSC_Q6,
	segmentCapacity_txt_GSC_Q7,
	segmentCapacity_dropdown_TrafficRights,
	segmentCapacity_dropdown_BookingStatus,
	segmentCapacity_txt_capacityVolume,
	segmentCapacity_chkbox_mon,
	segmentCapacity_btn_ChangeCapacity,
	segmentCapacity_txt_defaultCapacityOverBookingWeight,
	segmentCapacity_txt_defaultCapacityOverBookingVolume,
	segmentCapacity_txt_defaultCapacityOverBookingL3,
	segmentCapacity_txt_defaultCapacityOverBookingL7,
	segmentCapacity_txt_defaultCapacityOverBookingQ6,
	segmentCapacity_txt_defaultCapacityOverBookingQ7,
	segmentCapacity_txt_capacityWeight,
	segmentCapacity_chkbox_tue,
	chkbox_secondSegment,
	footer_error,
	segmentCapacity_btn_close,
	dropdown_agreementType,
	chkbox_segment,
	tab_leg,
	segmentCapacity_txt_SCL_L3,
	segmentCapacity_txt_SCL_L7,
	segmentCapacity_txt_SCL_Q6,
	segmentCapacity_txt_SCL_Q7,
	defaultCapacity_txt_SCL_Weight,
	defaultCapacity_txt_SCL_Volume;

	
	
	
	private By txt_ovrBk_weigth;
	private By txt_ovrBk_vol;
	private By txt_ULD_L3;
	private By txt_ULD_L7;
	private By txt_ULD_Q6;
	private By txt_ULD_Q7;
	
	private By chk_segment2;
	private By chk_segment3;
	
	public FLT005(WebDriver driver, String testDataFile) {
		super(driver);
		this.driver = driver;
		this.testDataFile = testDataFile;
		PageFactory.initElements(this.driver, this);
		filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + testDataFile;
		initPageElements();
	}

	/**
	 * Method to initialize page objects
	 */
	private void initPageElements() {
		txt_bup = MiscUtility.getWebElement(objFilepath, "FLT005_txt_bup");

		textcarrierCode = MiscUtility.getWebElement(objFilepath, "FLT005_txt_carrierCode");
		FlightNo = MiscUtility.getWebElement(objFilepath, "FLT005_txt_flightNum");
		StartDate = MiscUtility.getWebElement(objFilepath, "FLT005_txt_sDate");
		EndDate = MiscUtility.getWebElement(objFilepath, "FLT005_txt_eDate");
		button_list = MiscUtility.getWebElement(objFilepath, "FLT005_txt_listFlt");
		btn_clear = MiscUtility.getWebElement(objFilepath, "FLT005_txt_clearFlt");
		text_route = MiscUtility.getWebElement(objFilepath, "FLT005_txt_route");
		check_freq = MiscUtility.getWebElement(objFilepath, "FLT005_chk_frequency");
		list_schType = MiscUtility.getWebElement(objFilepath, "FLT005_list_schType");
		list_Ftype = MiscUtility.getWebElement(objFilepath, "FLT005_list_FltType");
		text_effDate = MiscUtility.getWebElement(objFilepath, "FLT005_txt_effDate");
		leg2 = MiscUtility.getWebElement(objFilepath, "FLT005_chk_secondLeg");
		btn_legCapacity = MiscUtility.getWebElement(objFilepath, "FLT005_btn_legCapacity");
		button_save = MiscUtility.getWebElement(objFilepath, "FLT005_btn_saveFlt");
		button_close = MiscUtility.getWebElement(objFilepath, "FLT005_btn_close");
		tab_segment = MiscUtility.getWebElement(objFilepath, "FLT005_tab_segment");
		list_chkBxSeg = MiscUtility.getWebElement(objFilepath, "FLT005_list_chkBxSeg");
		btn_segUpdtCapacity = MiscUtility.getWebElement(objFilepath, "FLT005_btn_segUpdtCapacity");
		chkbox_firstSegment = MiscUtility.getWebElement(objFilepath, "FLT005_chkbox_firstSegment");
		chkbox_secondSegment = MiscUtility.getWebElement(objFilepath, "FLT005_chkbox_secondSegment");
		//window 2
		text_depTime = MiscUtility.getWebElement(objFilepath, "FLT005_txt_depTime");
		text_arrTime = MiscUtility.getWebElement(objFilepath, "FLT005_txt_arrTime");
		text_Atype = MiscUtility.getWebElement(objFilepath, "FLT005_txt_aircraftType");
		button_viewCap = MiscUtility.getWebElement(objFilepath, "FLT005_btn_viewCapacity");
		txt_capWt = MiscUtility.getWebElement(objFilepath, "FLT005_txt_capWt");
		txt_capVol = MiscUtility.getWebElement(objFilepath, "FLT005_txt_capVol");
		button_legOk = MiscUtility.getWebElement(objFilepath, "FLT005_btn_legOk");
		txt_loadFactor = MiscUtility.getWebElement(objFilepath, "FLT005_txt_loadFactor");
		txt_ovrWt = MiscUtility.getWebElement(objFilepath, "FLT005_txt_ovrWt");
		txt_ovrVol = MiscUtility.getWebElement(objFilepath, "FLT005_txt_ovrVol");

		//Seg Capacity
		chkBx_defineGSC = MiscUtility.getWebElement(objFilepath, "FLT005_chkBx_defineGSC");
		txt_GSC = MiscUtility.getWebElement(objFilepath, "FLT005_txt_GSC");
		txt_SCL = MiscUtility.getWebElement(objFilepath, "FLT005_txt_SCL");
		segmentCapacity_txt_GSC_L3 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_GSC_L3");
		segmentCapacity_txt_GSC_L7 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_GSC_L7");
		segmentCapacity_txt_GSC_Q6 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_GSC_Q6");
		segmentCapacity_txt_GSC_Q7 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_GSC_Q7");
		defaultCapacity_txt_GSC_Weight = MiscUtility.getWebElement(objFilepath, "FLT005_DefaultCapacity_txt_GSC_Weight");
		defaultCapacity_txt_GSC_Volume = MiscUtility.getWebElement(objFilepath, "FLT005_DefaultCapacity_txt_GSC_Volume");
		segmentCapacity_dropdown_TrafficRights = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_dropdown_TrafficRights");
		segmentCapacity_dropdown_BookingStatus = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_dropdown_BookingStatus");
		segmentCapacity_txt_capacityWeight = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_capacityWeight");
		segmentCapacity_txt_capacityVolume = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_capacityVolume");
		segmentCapacity_chkbox_mon = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_chkbox_mon");
		segmentCapacity_chkbox_tue = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_chkbox_tue");
		segmentCapacity_btn_ChangeCapacity = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_btn_ChangeCapacity");
		segmentCapacity_txt_defaultCapacityOverBookingWeight = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_defaultCapacityOverBookingWeight");
		segmentCapacity_txt_defaultCapacityOverBookingVolume = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_defaultCapacityOverBookingVolume");
		segmentCapacity_txt_defaultCapacityOverBookingL3 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_defaultCapacityOverBookingL3");
		segmentCapacity_txt_defaultCapacityOverBookingL7 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_defaultCapacityOverBookingL7");
		segmentCapacity_txt_defaultCapacityOverBookingQ6 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_defaultCapacityOverBookingQ6");
		segmentCapacity_txt_defaultCapacityOverBookingQ7 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_defaultCapacityOverBookingQ7");
		segmentCapacity_btn_close = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_btn_close");
		btn_segCapacityOk = MiscUtility.getWebElement(objFilepath, "FLT005_btn_segCapacityOk");
		chkbox_segment = MiscUtility.getWebElement(objFilepath, "FLT005_chkbox_segment");

		yesBtn = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
		noBtn = MiscUtility.getWebElement(genFilepath, "Generic_btn_noBtn");
		button_diaOk = MiscUtility.getWebElement(objFilepath, "FLT005_btn_ok");
		msg_success = MiscUtility.getWebElement(genFilepath, "Generic_foot_layer");
		info_msgClose = MiscUtility.getWebElement(genFilepath, "Generic_info_close");
		dialogueText = MiscUtility.getWebElement(genFilepath, "Generic_info_msg");
		footer_error = MiscUtility.getWebElement(genFilepath, "Generic_footer_error");


		chkbox_domesticFlights = MiscUtility.getWebElement(objFilepath, "FLT005_chkbox_domesticFlights");
		ifo_status = MiscUtility.getWebElement(objFilepath, "FLT005_ifo_status");
		txt_dayChangeAtOrigin = MiscUtility.getWebElement(objFilepath, "FLT005_txt_dayChangeAtOrigin");
		txt_dayChangeAtDestination = MiscUtility.getWebElement(objFilepath, "FLT005_txt_dayChangeAtDestination");
		txt_loadFactor = MiscUtility.getWebElement(objFilepath, "FLT005_txt_loadFactor");
		legCapacity_chkbox_mon = MiscUtility.getWebElement(objFilepath, "FLT005_LegCapacity_chkbox_mon");
		legCapacity_chkbox_tue = MiscUtility.getWebElement(objFilepath, "FLT005_LegCapacity_chkbox_tue");
		legCapacity_chkbox_sun = MiscUtility.getWebElement(objFilepath, "FLT005_LegCapacity_chkbox_sun");
		legCapacity_chkbox_wed = MiscUtility.getWebElement(objFilepath, "FLT005_LegCapacity_chkbox_wed");
		legCapacity_chkbox_thu = MiscUtility.getWebElement(objFilepath, "FLT005_LegCapacity_chkbox_thu");
		legCapacity_chkbox_fri = MiscUtility.getWebElement(objFilepath, "FLT005_LegCapacity_chkbox_fri");
		legCapacity_chkbox_sat = MiscUtility.getWebElement(objFilepath, "FLT005_LegCapacity_chkbox_sat");
		legCapacity_txt_loadFactor2 = MiscUtility.getWebElement(objFilepath, "FLT005_LegCapacity_txt_loadFactor2");
		legCapacity_btn_changeCapacity = MiscUtility.getWebElement(objFilepath, "FLT005_LegCapacity_btn_changeCapacity");
		legCapacity_table_specificCapacity = MiscUtility.getWebElement(objFilepath, "FLT005_LegCapacity_table_specificCapacity");

		txt_L3 = MiscUtility.getWebElement(objFilepath, "FLT005_txt_L3");
		txt_L7 = MiscUtility.getWebElement(objFilepath, "FLT005_txt_L7");
		txt_Q6 = MiscUtility.getWebElement(objFilepath, "FLT005_txt_Q6");
		txt_Q7 = MiscUtility.getWebElement(objFilepath, "FLT005_txt_Q7");

		dropdown_agreementType = MiscUtility.getWebElement(objFilepath, "FLT005_dropdown_agreementType");
		tab_leg = MiscUtility.getWebElement(objFilepath, "FLT005_tab_leg");
		
		txt_ULD_L3=MiscUtility.getWebElement(objFilepath, "FLT005_txt_L3");
		txt_ULD_L7=MiscUtility.getWebElement(objFilepath, "FLT005_txt_L7");
		txt_ULD_Q6=MiscUtility.getWebElement(objFilepath, "FLT005_txt_Q6");
		txt_ULD_Q7=MiscUtility.getWebElement(objFilepath, "FLT005_txt_Q7");
		chk_segment2=MiscUtility.getWebElement(objFilepath, "FLT005_chk_seg2");
		chk_segment3=MiscUtility.getWebElement(objFilepath, "FLT005_chk_seg3");
		
		defaultCapacity_txt_SCL_Weight = MiscUtility.getWebElement(objFilepath, "FLT005_DefaultCapacity_txt_SCL_Weight");
		defaultCapacity_txt_SCL_Volume = MiscUtility.getWebElement(objFilepath, "FLT005_DefaultCapacity_txt_SCL_Volume");
		segmentCapacity_txt_SCL_L3 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_SCL_L3");
		segmentCapacity_txt_SCL_L7 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_SCL_L7");
		segmentCapacity_txt_SCL_Q6 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_SCL_Q6");
		segmentCapacity_txt_SCL_Q7 = MiscUtility.getWebElement(objFilepath, "FLT005_SegmentCapacity_txt_SCL_Q7");
	}

	/**
	 * Method to create a Single leg schedule flight
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
	 * @param key_fullfltNum
	 * @param key_sDate
	 * @param key_eDate
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author a-7868
	 */
	public FLT005 createSingleLeg(String key_carrier_code, String key_route, String key_schType,
			String key_fltType, String key_depTime, String key_arrTime, String key_acType, String key_fltCapVol, String key_fltCapWt,
			String key_fltNum, String key_fullfltNum, String key_sDate, String key_eDate) throws InterruptedException, IOException {

		//fetch test data
		String data_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath, key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath, key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath, key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath, key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType);
		String data_capVol = PropertyHandler.getPropValue(filepath, key_fltCapVol);
		String data_capWt = PropertyHandler.getPropValue(filepath, key_fltCapWt);


		enterKeys(textcarrierCode, data_carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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

		//------------------------
		/*   rand_fltnum = BizUtility.createFlightNum();
        enterKeys(FlightNo, rand_fltnum);
        enterKeys(StartDate, ".");
        enterKeys(EndDate, "+7");
        click(button_list);
        minWait();
    //    driver.navigate().refresh();*/
		//----------------------------------------

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_fullfltNum, data_carrier_code + fltNo).replaceFirst(" ", "");
		PropertyHandler.setPropValue(filepath, key_sDate, startDt);
		PropertyHandler.setPropValue(filepath, key_eDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), data_route);
		click(check_freq);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);
		click(button_legOk);


		minWait();

		//switch back to main window

		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
			minWait();
		}
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		//click(waitForElement(button_diaYes));        
		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
		click(button_diaOk);
		if(verifyElementEnabled(button_diaOk))
			click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;

	}

	/**
	 * Method to create a flight in PUBLISHED status
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
	 * @param key_fullfltNum
	 * @param key_sDate
	 * @param key_eDate
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author A-7868 Krishna <29/06/2018>
	 */
	public FLT005 createFlightWithPublishedStatus(String key_carrier_code, String key_route, String key_schType,
			String key_fltType, String key_depTime, String key_arrTime, String key_acType, String key_fltCapVol, String key_fltCapWt,
			String key_fltNum, String key_fullfltNum, String key_sDate, String key_eDate) throws InterruptedException, IOException {

		//fetch test data
		String data_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath, key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath, key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath, key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath, key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType);
		

		enterKeys(textcarrierCode, data_carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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

		
		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_fullfltNum, data_carrier_code + fltNo).replaceFirst(" ", "");
		PropertyHandler.setPropValue(filepath, key_sDate, startDt);
		PropertyHandler.setPropValue(filepath, key_eDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), data_route);
		click(check_freq);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);
		click(button_legOk);

		minWait();

		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
			minWait();
		}
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(noBtn));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;

	}
	
	public FLT005 createSingleLegULDPieces(String key_carrier_code, String key_route, String key_schType,
			String key_fltType, String key_depTime, String key_arrTime, String key_acType, String key_fltCapVol, String key_fltCapWt,
			String key_fltNum, String key_fullfltNum, String key_sDate, String key_eDate,String L3) throws InterruptedException, IOException {

		//fetch test data
		String data_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath, key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath, key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath, key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath, key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType);
		String data_capVol = PropertyHandler.getPropValue(filepath, key_fltCapVol);
		String data_capWt = PropertyHandler.getPropValue(filepath, key_fltCapWt);
		L3=PropertyHandler.getPropValue(filepath, L3);

		enterKeys(textcarrierCode, data_carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) { 
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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



		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_fullfltNum, data_carrier_code + fltNo).replaceFirst(" ", "");
		PropertyHandler.setPropValue(filepath, key_sDate, startDt);
		PropertyHandler.setPropValue(filepath, key_eDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), data_route);
		click(check_freq);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);
		enterKeys(txt_L3, L3);
		click(button_legOk);
		if(verifyElementPresent(yesBtn))
			click(yesBtn);


		minWait();

		//switch back to main window

		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
			minWait();
		}
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		//click(waitForElement(button_diaYes));        
		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
		click(button_diaOk);
		if(verifyElementEnabled(button_diaOk))
			click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;

	}

	/**
	 * Method to create a Single leg schedule flight
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
	 * @param key_fullfltNum
	 * @param key_sDate
	 * @param key_eDate
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author a-7681 Arun
	 */
	public FLT005 createSingleLegWithWtandVol(String key_carrier_code, String key_route, String key_schType,
			String key_fltType, String key_depTime, String key_arrTime, String key_acType, String key_fltCapVol, String key_fltCapWt,
			String key_fltNum, String key_fullfltNum, String key_sDate, String key_eDate) throws InterruptedException, IOException {

		//fetch test data
		String data_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath, key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath, key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath, key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath, key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType);
		String data_capVol = PropertyHandler.getPropValue(filepath, key_fltCapVol);
		String data_capWt = PropertyHandler.getPropValue(filepath, key_fltCapWt);

		enterKeys(textcarrierCode, data_carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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

		//------------------------
		/*   rand_fltnum = BizUtility.createFlightNum();
        enterKeys(FlightNo, rand_fltnum);
        enterKeys(StartDate, ".");
        enterKeys(EndDate, "+7");
        click(button_list);
        minWait();
    //    driver.navigate().refresh();*/
		//----------------------------------------

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_fullfltNum, data_carrier_code + fltNo);
		PropertyHandler.setPropValue(filepath, key_sDate, startDt);
		PropertyHandler.setPropValue(filepath, key_eDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), data_route);
		click(check_freq);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);
		enterKeys(txt_capWt, data_capWt);
		enterKeys(txt_capVol, data_capVol);
		//screen refresh
		click(button_legOk);
		minWait();

		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		//click(waitForElement(button_diaYes));
		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}


	/**
	 * Creates a single leg flight with overboking weight and vol and  saves the current wt and vol to property file
	 *
	 * @param key_carrier_code
	 * @param key_route
	 * @param key_schType
	 * @param key_fltType
	 * @param key_depTime
	 * @param key_arrTime
	 * @param key_acType
	 * @param key_ovrWt
	 * @param key_ovrVol
	 * @param key_fltNum
	 * @param key_fullfltNum
	 * @param key_sDate
	 * @param key_eDate
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author Arun A-7681
	 */
	public FLT005 createSingleLegOverBooking(String key_carrier_code, String key_route, String key_schType,
			String key_fltType, String key_depTime, String key_arrTime, String key_acType, String key_ovrWt, String key_ovrVol,
			String key_fltNum, String key_fullfltNum, String key_sDate, String key_eDate, String key_totalWt, String key_totalVol) throws InterruptedException, IOException {

		//fetch test data
		String data_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath, key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath, key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath, key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath, key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType);
		//        String data_loadFactor = PropertyHandler.getPropValue(filepath, key_LoadFactor);
		String data_ovrWt = PropertyHandler.getPropValue(filepath, key_ovrWt);
		String data_ovrVol = PropertyHandler.getPropValue(filepath, key_ovrVol);

		enterKeys(textcarrierCode, data_carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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
		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_fullfltNum, data_carrier_code + fltNo);
		PropertyHandler.setPropValue(filepath, key_sDate, startDt);
		PropertyHandler.setPropValue(filepath, key_eDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), data_route);
		click(check_freq);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);

		//        enterKeys(txt_loadFactor, data_loadFactor);
		enterKeys(txt_ovrWt, data_ovrWt);
		enterKeys(txt_ovrVol, data_ovrVol);
		String tempValue = String.valueOf(Integer.parseInt(waitForElement(txt_capWt).getAttribute("value")) + Integer.parseInt(data_ovrWt));
		PropertyHandler.setPropValue(filepath, key_totalWt, tempValue);
		tempValue = String.valueOf(Integer.parseInt(waitForElement(txt_capVol).getAttribute("value")) + Integer.parseInt(data_ovrVol));
		PropertyHandler.setPropValue(filepath, key_totalVol, tempValue);
		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(button_save);
		driver.switchTo().defaultContent();

		//click(waitForElement(button_diaYes));
		click(yesBtn);

		Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		return this;
	}


	/**
	 * Method to update a single leg schedule flight
	 *
	 * @param key_carrier_code
	 * @param key_fltNum
	 * @param key_sDate
	 * @param key_eDate
	 * @param key_capVol
	 * @param key_capWt
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author a-7868
	 */
	public FLT005 updateSingleLeg(String key_carrier_code, String key_fltNum, String key_sDate, String key_eDate,
			String key_capVol, String key_capWt) throws InterruptedException, IOException {


		String data_carrierCode = PropertyHandler.getPropValue(filepath, key_carrier_code);
		String data_fltnum = PropertyHandler.getPropValue(filepath, key_fltNum);
		String data_capWt = PropertyHandler.getPropValue(filepath, key_capWt);
		String data_capVol = PropertyHandler.getPropValue(filepath, key_capVol);

		enterKeys(textcarrierCode, data_carrierCode);
		enterKeys(FlightNo, data_fltnum);
		enterKeys(StartDate, ".");
		enterKeys(EndDate, "+7");
		click(button_list);
		minWait();
		click(btn_legCapacity);
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
		}//handle the case when no pop-up is displayed
		//        minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		minWait();
		Assert.assertTrue(waitForElement(msg_success).getText().contains("Flight Schedule Saved Successfully."), "ERROR : FLIGHT SAVED SUCCESSFULLY message not displayed");

		waitForFrameAndSwitch(FRAME);
		//        click(info_msgClose);
		//maxWait();       

		return this;
	}

	/**
	 * Method to create a Multi-leg schedule flight
	 *
	 * @param key_carrier_code
	 * @param key_route
	 * @param key_schType
	 * @param key_fltType
	 * @param key_depTime
	 * @param key_arrTime
	 * @param key_acType1
	 * @param key_depTime_leg2
	 * @param key_arrTime_leg2
	 * @param key_acType2
	 * @param key_fltCapVol
	 * @param key_fltCapWt
	 * @param key_fltNum
	 * @param key_fullfltNum
	 * @param key_sDate
	 * @param key_eDate
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author a-7868
	 */
	public FLT005 createMultiLeg(String key_carrier_code, String key_route, String key_schType,
			String key_fltType, String key_depTime, String key_arrTime, String key_acType1, String key_depTime_leg2,
			String key_arrTime_leg2, String key_acType2, String key_fltCapVol, String key_fltCapWt,
			String key_fltNum, String key_fullfltNum, String key_sDate, String key_eDate) throws InterruptedException, IOException {

		//fetch test data
		String data_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath, key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath, key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath, key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath, key_arrTime);
		String data_acType1 = PropertyHandler.getPropValue(filepath, key_acType1);
		String data_depTimeLeg2 = PropertyHandler.getPropValue(filepath, key_depTime_leg2);
		String data_arrTimeLeg2 = PropertyHandler.getPropValue(filepath, key_arrTime_leg2);
		String data_acType2 = PropertyHandler.getPropValue(filepath, key_acType2);
		String data_capVol = PropertyHandler.getPropValue(filepath, key_fltCapVol);
		String data_capWt = PropertyHandler.getPropValue(filepath, key_fltCapWt);

		enterKeys(textcarrierCode, data_carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_fullfltNum, (data_carrier_code + fltNo).toString().replaceAll(" ", ""));
		PropertyHandler.setPropValue(filepath, key_sDate, startDt);
		PropertyHandler.setPropValue(filepath, key_eDate, endDt);

		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), data_route);
		click(check_freq);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType1);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		/*driver.switchTo().defaultContent();
        if(verifyElementPresent(yesBtn))
        	click(yesBtn);*/
		// waitForFrameAndSwitch(FRAME);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);

		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), data_depTimeLeg2);
		enterKeys(text_arrTime, data_arrTimeLeg2);
		enterKeys(text_Atype, data_acType2);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		/*driver.switchTo().defaultContent();
        if(verifyElementPresent(yesBtn))
        	click(yesBtn);*/
		// waitForFrameAndSwitch(FRAME);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/*  All combined in the below method

	 */
	/**
	 * Create a multi leg flight with GSC
	 * @param key_carrier_code
	 * @param key_route
	 * @param key_schType
	 * @param key_fltType
	 * @param key_depTime
	 * @param key_arrTime
	 * @param key_acType1
	 * @param key_depTime_leg2
	 * @param key_arrTime_leg2
	 * @param originalWt
	 * @param reducedWt
	 * @param key_GSC
	 * @param key_fltNum
	 * @param key_fullfltNum
	 * @param key_sDate
	 * @param key_eDate
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author Arun A-7681
	 *//*

    public FLT005 createMultiLegGSC(String key_carrier_code, String key_route, String key_schType,
                                    String key_fltType, String key_depTime, String key_arrTime, String key_acType1, String key_depTime_leg2,
                                    String key_arrTime_leg2, String originalWt, String reducedWt, String key_GSC,
                                    String key_fltNum, String key_fullfltNum, String key_sDate, String key_eDate) throws InterruptedException, IOException {

        //fetch test data
        String data_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
        String data_route = PropertyHandler.getPropValue(filepath, key_route);
        String data_schType = PropertyHandler.getPropValue(filepath, key_schType);
        String data_fltType = PropertyHandler.getPropValue(filepath, key_fltType);
        String data_depTime = PropertyHandler.getPropValue(filepath, key_depTime);
        String data_arrTime = PropertyHandler.getPropValue(filepath, key_arrTime);
        String data_acType = PropertyHandler.getPropValue(filepath, key_acType1);
        String data_depTimeLeg2 = PropertyHandler.getPropValue(filepath, key_depTime_leg2);
        String data_arrTimeLeg2 = PropertyHandler.getPropValue(filepath, key_arrTime_leg2);
        String data_GSC = PropertyHandler.getPropValue(filepath, key_GSC);
//        String data_capWt 			= PropertyHandler.getPropValue(filepath, key_fltCapWt);

        enterKeys(textcarrierCode, data_carrier_code);

        String rand_fltnum;
        //to execute till a non-existing flight num is listed
        while (true) {
            rand_fltnum = BizUtility.createFlightNum();
            enterKeys(FlightNo, rand_fltnum);
            enterKeys(StartDate, ".");
            enterKeys(EndDate, "+7");
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

        minWait();
        String fltNo = waitForElement(FlightNo).getAttribute("value");
        String startDt = waitForElement(StartDate).getAttribute("value");
        String endDt = waitForElement(EndDate).getAttribute("value");
        //store the flight num to SMOKETestData.properties
        PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
        PropertyHandler.setPropValue(filepath, key_fullfltNum, data_carrier_code + fltNo);
        PropertyHandler.setPropValue(filepath, key_sDate, startDt);
        PropertyHandler.setPropValue(filepath, key_eDate, endDt);

        click(waitForElement(text_route));
        enterKeys(waitForElement(text_route), data_route);
        click(check_freq);

        selectByText(list_schType, data_schType);
        selectByText(list_Ftype, data_fltType);
        enterKeys(text_effDate, "." + Keys.TAB);
        click(btn_legCapacity);
        minWait();
        driver.switchTo().defaultContent();
        waitForNewWindow(2);

        switchToSecondWindow();

        enterKeys(waitForElement(text_depTime), data_depTime);
        enterKeys(text_arrTime, data_arrTime);
        enterKeys(text_Atype, data_acType);
        click(button_viewCap);

        String tempValue = waitForElement(txt_capWt).getAttribute("value");
        PropertyHandler.setPropValue(dataFileName,originalWt,tempValue);
        tempValue = String.valueOf(Integer.parseInt(tempValue)-Integer.parseInt(data_GSC));
        PropertyHandler.setPropValue(dataFileName,reducedWt,tempValue);

        //screen refresh
        click(button_legOk);

        //switch back to main window
        minWait();
        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);

        //check 2nd leg
        check(leg2);

        click(btn_legCapacity);
        minWait();
        driver.switchTo().defaultContent();
        waitForNewWindow(2);

        switchToSecondWindow();

        enterKeys(text_depTime, data_depTimeLeg2);
        enterKeys(text_arrTime, data_arrTimeLeg2);
        enterKeys(text_Atype, data_acType);
        click(button_viewCap);
        //screen refresh
        click(button_legOk);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        click(tab_segment);
        check(getWebElements(list_chkBxSeg).get(1));
        click(btn_segUpdtCapacity);

        waitForNewWindow(2);

        switchToSecondWindow();
        check(chkBx_defineGSC);
        enterKeys(txt_GSC, data_GSC);
        click(btn_segCapacityOk);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        click(button_save);
        driver.switchTo().defaultContent();

        click(waitForElement(yesBtn));

        Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
        click(button_diaOk);

        waitForFrameAndSwitch(FRAME);
        minWait();
        return this;
    }
	  */


	/**
	 * Create a multi leg flight having GSC or SCL or both chenged
	 *
	 * @param key_carrier_code
	 * @param key_route
	 * @param key_schType
	 * @param key_fltType
	 * @param key_depTime
	 * @param key_arrTime
	 * @param key_acType1
	 * @param key_depTime_leg2
	 * @param key_arrTime_leg2
	 * @param wtOfOtherSeg
	 * @param wtOfChangedSeg
	 * @param key_newValue
	 * @param key_fltNum
	 * @param key_fullfltNum
	 * @param key_sDate
	 * @param key_eDate
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author Arun A-7681
	 */
	public FLT005 createMultiLegSCLorGSCChange(String key_carrier_code, String key_route, String key_schType,
			String key_fltType, String key_depTime, String key_arrTime, String key_acType1, String key_depTime_leg2,
			String key_arrTime_leg2, String wtOfOtherSeg, String wtOfChangedSeg, String key_newValue,
			String key_fltNum, String key_fullfltNum, String key_sDate, String key_eDate, String typeOfEdit) throws InterruptedException, IOException {

		//fetch test data
		String data_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath, key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath, key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath, key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath, key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType1);
		String data_depTimeLeg2 = PropertyHandler.getPropValue(filepath, key_depTime_leg2);
		String data_arrTimeLeg2 = PropertyHandler.getPropValue(filepath, key_arrTime_leg2);
		String data_newValue = PropertyHandler.getPropValue(filepath, key_newValue);
		//        String data_capWt 			= PropertyHandler.getPropValue(filepath, key_fltCapWt);
		String tempValue = null;

		enterKeys(textcarrierCode, data_carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_fullfltNum, data_carrier_code + fltNo);
		PropertyHandler.setPropValue(filepath, key_sDate, startDt);
		PropertyHandler.setPropValue(filepath, key_eDate, endDt);

		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), data_route);
		click(check_freq);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);

		//Get the capacity details

		if (typeOfEdit.equalsIgnoreCase("SCL")) {
			PropertyHandler.setPropValue(filepath, wtOfOtherSeg, waitForElement(txt_capWt).getAttribute("value"));
			PropertyHandler.setPropValue(filepath, wtOfChangedSeg, data_newValue);
		} else if (typeOfEdit.equalsIgnoreCase("GSC")) {
			tempValue = waitForElement(txt_capWt).getAttribute("value");
			PropertyHandler.setPropValue(filepath, wtOfChangedSeg, tempValue);
			tempValue = String.valueOf(Integer.parseInt(tempValue) - Integer.parseInt(data_newValue));
			PropertyHandler.setPropValue(filepath, wtOfOtherSeg, tempValue);
		} else {
			tempValue = waitForElement(txt_capWt).getAttribute("value");
			PropertyHandler.setPropValue(filepath, wtOfChangedSeg, data_newValue);
			tempValue = String.valueOf(Integer.parseInt(tempValue) - Integer.parseInt(data_newValue));
			PropertyHandler.setPropValue(filepath, wtOfOtherSeg, tempValue);
		}

		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);

		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(text_depTime, data_depTimeLeg2);
		enterKeys(text_arrTime, data_arrTimeLeg2);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//Enter segment capacity details
		click(tab_segment);
		check(getWebElements(list_chkBxSeg).get(1));
		click(btn_segUpdtCapacity);

		waitForNewWindow(2);

		switchToSecondWindow();
		check(chkBx_defineGSC);

		if (typeOfEdit.equalsIgnoreCase("SCL")) {
			enterKeys(txt_SCL, data_newValue);
		} else if (typeOfEdit.equalsIgnoreCase("GSC")) {
			enterKeys(txt_GSC, data_newValue);
		} else {
			enterKeys(txt_SCL, data_newValue);
			enterKeys(txt_GSC, data_newValue);
		}
		click(btn_segCapacityOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		click(button_save);
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/**
	 * Method to close current page and return to Homepae
	 * returns the instance of Homepage
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

	/*Created by A-7605
	 * 
	 */
	public FLT005 checkFunctionalityOfNoButtonInNewFlightCreateDialogue(String carrierCode, String scheduleStartDate, String scheduleEndDate) {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		String randomNumber;

		while (true) {
			randomNumber = BizUtility.createFlightNum();
			enterKeys(FlightNo, randomNumber);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
			click(button_list);
			driver.switchTo().defaultContent();
			minWait();

			if (verifyElementPresent(noBtn)) {
				click(noBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			click(waitForElement(btn_clear));
		}

		minWait();
		String tempdata = waitForElement(FlightNo).getText();
		System.out.println(tempdata);
		Assert.assertTrue(tempdata.isEmpty(), "The Flight No field is not cleared");
		Assert.assertTrue(waitForElement(StartDate).getText().isEmpty(), "The Start Date field is not cleared");
		Assert.assertTrue(waitForElement(EndDate).getText().isEmpty(), "The End Date field is not cleared");
		//  Assert.assertTrue(waitForElement(FlightNo).getText().trim().length()<0,"The Flight No field is not cleared");
		//  Assert.assertTrue(waitForElement(StartDate).getText().trim().length()<0,"The Start Date field is not cleared");
		//  Assert.assertTrue(waitForElement(EndDate).getText().trim().length()<0,"The End Date field is not cleared");
		return this;
	}


	/**
	 * Crated by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param dayChangeAtDestination
	 * @param departureTime
	 * @param dayChangeAtOrigin
	 * @param arrivalTime
	 * @param loadFactor
	 * @param aircraftType
	 * @param capacityVolume
	 * @param capacityWeight
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public FLT005 createDomesticFlightInPublishedStatus(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String dayChangeAtDestination, String departureTime, String dayChangeAtOrigin, String arrivalTime, String loadFactor, String aircraftType, String capacityVolume, String capacityWeight) throws InterruptedException, IOException {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		departureTime = PropertyHandler.getPropValue(filepath, departureTime);
		arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
		capacityVolume = PropertyHandler.getPropValue(filepath, capacityVolume);
		capacityWeight = PropertyHandler.getPropValue(filepath, capacityWeight);
		dayChangeAtDestination = PropertyHandler.getPropValue(filepath, dayChangeAtDestination);
		dayChangeAtOrigin = PropertyHandler.getPropValue(filepath, dayChangeAtOrigin);
		loadFactor = PropertyHandler.getPropValue(filepath, loadFactor);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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
		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		//        String startDt = waitForElement(StartDate).getAttribute("value");
		//        String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		//        PropertyHandler.setPropValue(filepath, scheduleStartDate, startDt);
		//        PropertyHandler.setPropValue(filepath, scheduleEndDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		check(chkbox_domesticFlights);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(txt_dayChangeAtDestination, dayChangeAtDestination);
		enterKeys(waitForElement(text_depTime), departureTime);
		enterKeys(text_arrTime, arrivalTime);
		enterKeys(txt_dayChangeAtOrigin, dayChangeAtOrigin);
		enterKeys(text_Atype, aircraftType);
		enterKeys(txt_loadFactor, loadFactor);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Do you want to burst the schedule?"), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(waitForElement(noBtn));

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param status
	 * @return
	 */

	public FLT005 verifyFlightStatus(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate, String status) {
		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		flightNo = PropertyHandler.getPropValue(filepath, flightNo);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);


		enterKeys(textcarrierCode, carrierCode);
		enterKeys(FlightNo, flightNo);
		enterKeys(StartDate, scheduleStartDate);
		enterKeys(EndDate, scheduleEndDate);
		click(button_list);
		System.out.println(waitForElement(ifo_status).getAttribute("value"));

		Assert.assertTrue(waitForElement(ifo_status).getAttribute("value").equalsIgnoreCase(status), "Actual status is '" + waitForElement(ifo_status).getAttribute("value").equalsIgnoreCase(status) + "'");
		return this;
	}


	/**
	 * Crated by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param dayChangeAtDestination
	 * @param departureTime
	 * @param dayChangeAtOrigin
	 * @param arrivalTime
	 * @param loadFactor
	 * @param aircraftType
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public FLT005 createDomesticFlightInLiveStatus(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String dayChangeAtDestination, String departureTime, String dayChangeAtOrigin, String arrivalTime, String loadFactor, String aircraftType) throws InterruptedException, IOException {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		departureTime = PropertyHandler.getPropValue(filepath, departureTime);
		arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
		dayChangeAtDestination = PropertyHandler.getPropValue(filepath, dayChangeAtDestination);
		dayChangeAtOrigin = PropertyHandler.getPropValue(filepath, dayChangeAtOrigin);
		loadFactor = PropertyHandler.getPropValue(filepath, loadFactor);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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
		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		//        String startDt = waitForElement(StartDate).getAttribute("value");
		//        String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		//        PropertyHandler.setPropValue(filepath, scheduleStartDate, startDt);
		//        PropertyHandler.setPropValue(filepath, scheduleEndDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		check(chkbox_domesticFlights);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), departureTime);
		enterKeys(txt_dayChangeAtDestination, dayChangeAtDestination);
		enterKeys(text_arrTime, arrivalTime);
		enterKeys(txt_dayChangeAtOrigin, dayChangeAtOrigin);
		enterKeys(text_Atype, aircraftType);
		enterKeys(txt_loadFactor, loadFactor);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}


	/**
	 * Crated by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param legOneDepartureTime
	 * @param legOneDayChangeAtOrigin
	 * @param legOneArrivalTime
	 * @param legOneDayChangeAtDestination
	 * @param legOneAircraftType
	 * @param legTwoDepartureTime
	 * @param legTwoDayChangeAtOrigin
	 * @param legTwoArrivalTime
	 * @param legTwoDayChangeAtDestination
	 * @param legTwoAircraftType
	 * @return
	 */
	public FLT005 createMultisegmentFlight(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneDayChangeAtOrigin, String legOneArrivalTime, String legOneDayChangeAtDestination, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoDayChangeAtOrigin, String legTwoArrivalTime, String legTwoDayChangeAtDestination, String legTwoAircraftType) {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		legOneDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legOneDayChangeAtOrigin);
		legOneDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legOneDayChangeAtDestination);
		legTwoDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtOrigin);
		legTwoDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtDestination);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);


		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		//        String startDt = waitForElement(StartDate).getAttribute("value");
		//        String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		//        PropertyHandler.setPropValue(filepath, scheduleStartDate, startDt);
		//        PropertyHandler.setPropValue(filepath, scheduleEndDate, endDt);

		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(txt_dayChangeAtOrigin, legOneDayChangeAtOrigin);
		enterKeys(text_Atype, legOneAircraftType);
		enterKeys(txt_dayChangeAtDestination, legOneDayChangeAtDestination);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);

		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(txt_dayChangeAtOrigin, legTwoDayChangeAtOrigin);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(txt_dayChangeAtDestination, legTwoDayChangeAtDestination);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}
	
	
	
	public FLT005 createMultisegmentFlightOverBookingWtVol(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneDayChangeAtOrigin, String legOneArrivalTime, String legOneDayChangeAtDestination, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoDayChangeAtOrigin, String legTwoArrivalTime, String legTwoDayChangeAtDestination, String legTwoAircraftType,String weight, String volume,String weight2, String volume2,String ovrWt1, String ovrVol1,String L3_1, String L7_1, String Q6_1, String Q7_1,String ovrWt2,String ovrVol2,String L3_2,String L7_2, String Q6_2, String Q7_2, String gscWeight,String gscWeight2,String gscWeight3,String gscVolume,String gscL3, String gscL7, String gscQ6, String gscQ7) {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		legOneDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legOneDayChangeAtOrigin);
		legOneDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legOneDayChangeAtDestination);
		legTwoDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtOrigin);
		legTwoDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtDestination);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		weight= PropertyHandler.getPropValue(filepath, weight);
		volume= PropertyHandler.getPropValue(filepath, volume);
		weight2=PropertyHandler.getPropValue(filepath, weight2);
	    volume2=PropertyHandler.getPropValue(filepath, volume2);
		ovrWt1=PropertyHandler.getPropValue(filepath,ovrWt1);
		ovrVol1=PropertyHandler.getPropValue(filepath, ovrVol1);
		ovrWt2=PropertyHandler.getPropValue(filepath, ovrWt2);
		ovrVol2=PropertyHandler.getPropValue(filepath, ovrVol2);
		L3_1=PropertyHandler.getPropValue(filepath, L3_1);
		L7_1=PropertyHandler.getPropValue(filepath, L7_1);
		Q6_1=PropertyHandler.getPropValue(filepath, Q6_1);
		Q7_1=PropertyHandler.getPropValue(filepath, Q7_1);
		L3_2=PropertyHandler.getPropValue(filepath, L3_2);
		L7_2=PropertyHandler.getPropValue(filepath, L7_2);
		Q6_2=PropertyHandler.getPropValue(filepath, Q6_2);
		Q7_2=PropertyHandler.getPropValue(filepath, Q7_2);
		gscWeight=PropertyHandler.getPropValue(filepath, gscWeight);
		gscWeight2=PropertyHandler.getPropValue(filepath, gscWeight2);
		gscWeight3=PropertyHandler.getPropValue(filepath, gscWeight3);
		gscVolume=PropertyHandler.getPropValue(filepath, gscVolume);
		gscL3=PropertyHandler.getPropValue(filepath, gscL3);
		gscL7=PropertyHandler.getPropValue(filepath, gscL7);
		gscQ6=PropertyHandler.getPropValue(filepath, gscQ6);
		gscQ7=PropertyHandler.getPropValue(filepath, gscQ7);
		
		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		//        String startDt = waitForElement(StartDate).getAttribute("value");
		//        String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		//        PropertyHandler.setPropValue(filepath, scheduleStartDate, startDt);
		//        PropertyHandler.setPropValue(filepath, scheduleEndDate, endDt);

		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(txt_dayChangeAtOrigin, legOneDayChangeAtOrigin);
		enterKeys(text_Atype, legOneAircraftType);
		enterKeys(txt_dayChangeAtDestination, legOneDayChangeAtDestination);
		click(button_viewCap);
		enterKeys(txt_capWt, weight);
		enterKeys(txt_capVol, volume);
		enterKeys(txt_ovrWt, ovrWt1);
		enterKeys(txt_ovrVol, ovrVol1);
		
		enterKeys(txt_L3,L3_1);
		enterKeys(txt_L7,L7_1);
		enterKeys(txt_Q6,Q6_1);
		enterKeys(txt_Q7,Q7_1);
		
		
		//screen refresh
		click(button_legOk);
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);

		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(txt_dayChangeAtOrigin, legTwoDayChangeAtOrigin);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(txt_dayChangeAtDestination, legTwoDayChangeAtDestination);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		enterKeys(txt_capWt, weight2);
		enterKeys(txt_capVol, volume2);
		enterKeys(txt_ovrWt, ovrWt2);
		enterKeys(txt_ovrVol, ovrVol2);
		
		enterKeys(txt_L3,L3_2);
		enterKeys(txt_L7,L7_2);
		enterKeys(txt_Q6,Q6_2);
		enterKeys(txt_Q7,Q7_2);
		//screen refresh
		click(button_legOk);
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		
		click(tab_segment);
		
		
		click(btn_segUpdtCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		check(chkBx_defineGSC);
		enterKeys(defaultCapacity_txt_GSC_Weight, gscWeight);
		enterKeys(defaultCapacity_txt_GSC_Volume, gscVolume);
		enterKeys(segmentCapacity_txt_GSC_L3, gscL3);
		enterKeys(segmentCapacity_txt_GSC_L7, gscL7);
		enterKeys(segmentCapacity_txt_GSC_Q6, gscQ6);
		enterKeys(segmentCapacity_txt_GSC_Q7, gscQ7);
		
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		
		click(chk_segment2);
		
		click(btn_segUpdtCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		check(chkBx_defineGSC);
		enterKeys(defaultCapacity_txt_GSC_Weight, gscWeight2);
		enterKeys(defaultCapacity_txt_GSC_Volume, gscVolume);
		enterKeys(segmentCapacity_txt_GSC_L3, gscL3);
		enterKeys(segmentCapacity_txt_GSC_L7, gscL7);
		enterKeys(segmentCapacity_txt_GSC_Q6, gscQ6);
		enterKeys(segmentCapacity_txt_GSC_Q7, gscQ7);
		
		click(btn_segCapacityOk);
		
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		
		click(chk_segment3);
		click(btn_segUpdtCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		check(chkBx_defineGSC);
		enterKeys(defaultCapacity_txt_GSC_Weight, gscWeight3);
		enterKeys(defaultCapacity_txt_GSC_Volume, gscVolume);
		enterKeys(segmentCapacity_txt_GSC_L3, gscL3);
		enterKeys(segmentCapacity_txt_GSC_L7, gscL7);
		enterKeys(segmentCapacity_txt_GSC_Q6, gscQ6);
		enterKeys(segmentCapacity_txt_GSC_Q7, gscQ7);
		
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		
		
		click(waitForElement(button_save));
		
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));
		
		

		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}


	/**
	 * Crated by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param legOneDepartureTime
	 * @param legOneDayChangeAtOrigin
	 * @param legOneArrivalTime
	 * @param legOneDayChangeAtDestination
	 * @param legOneAircraftType
	 * @param legTwoDepartureTime
	 * @param legTwoDayChangeAtOrigin
	 * @param legTwoArrivalTime
	 * @param legTwoDayChangeAtDestination
	 * @param legTwoAircraftType
	 * @param loadFactor
	 * @return
	 */

	public FLT005 createMultisegmentFlightWithDifferentLegCapacity(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneDayChangeAtOrigin, String legOneArrivalTime, String legOneDayChangeAtDestination, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoDayChangeAtOrigin, String legTwoArrivalTime, String legTwoDayChangeAtDestination, String legTwoAircraftType, String loadFactor, Days... daysWithSpecificLoadFactor) {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		legOneDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legOneDayChangeAtOrigin);
		legOneDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legOneDayChangeAtDestination);
		legTwoDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtOrigin);
		legTwoDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtDestination);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		loadFactor = PropertyHandler.getPropValue(filepath, loadFactor);

		Calendar calendar;
		Date date;
		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		//        String startDt = waitForElement(StartDate).getAttribute("value");
		//        String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		//        PropertyHandler.setPropValue(filepath, scheduleStartDate, startDt);
		//        PropertyHandler.setPropValue(filepath, scheduleEndDate, endDt);

		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(txt_dayChangeAtOrigin, legOneDayChangeAtOrigin);
		enterKeys(text_Atype, legOneAircraftType);
		enterKeys(txt_dayChangeAtDestination, legOneDayChangeAtDestination);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);

		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(txt_dayChangeAtOrigin, legTwoDayChangeAtOrigin);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(txt_dayChangeAtDestination, legTwoDayChangeAtDestination);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		minWait();
		for (Days day : daysWithSpecificLoadFactor) {
			if (day == Days.SUNDAY)
				check(legCapacity_chkbox_sun);
			else if (day == Days.MONDAY)
				check(legCapacity_chkbox_mon);
			else if (day == Days.TUESDAY)
				check(legCapacity_chkbox_tue);
			else if (day == Days.WEDNESDAY)
				check(legCapacity_chkbox_wed);
			else if (day == Days.THURSDAY)
				check(legCapacity_chkbox_thu);
			else if (day == Days.FRIDAY)
				check(legCapacity_chkbox_fri);
			else if (day == Days.SATURDAY)
				check(legCapacity_chkbox_sat);
		}
		//        calendar = Calendar.getInstance();
		//        date = calendar.getTime();
		//        String today = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
		//        if(today.contains("Mon")){
		//        	check(legCapacity_chkbox_mon);
		//        	check(legCapacity_chkbox_tue);
		//        }else if(today.contains("Tue")){
		//        	check(legCapacity_chkbox_tue);
		//        	check(legCapacity_chkbox_wed);
		//        }else if(today.contains("Wed")){
		//        	check(legCapacity_chkbox_wed);
		//        	check(legCapacity_chkbox_thu);
		//        }else if(today.contains("Thu")){
		//        	check(legCapacity_chkbox_thu);
		//        	check(legCapacity_chkbox_fri);
		//        }else if(today.contains("Fri")){
		//        	check(legCapacity_chkbox_fri);
		//        	check(legCapacity_chkbox_sat);
		//        }else if(today.contains("Sat")){
		//        	check(legCapacity_chkbox_sat);
		//        	check(legCapacity_chkbox_sun);
		//        }else {
		//        	check(legCapacity_chkbox_sun);
		//        	check(legCapacity_chkbox_mon);
		//        }

		enterKeys(legCapacity_txt_loadFactor2, loadFactor);
		click(legCapacity_btn_changeCapacity);
		minWait();
		click(button_legOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		minWait();
		enterKeys(FlightNo, fltNo);
		enterKeys(StartDate, scheduleStartDate);
		enterKeys(EndDate, scheduleEndDate);
		click(button_list);
		minWait();
		check(leg2);

		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();

		String day1LoadFactor = getTableCellValue(legCapacity_table_specificCapacity, 2, 1);
		String day2LoadFactor = getTableCellValue(legCapacity_table_specificCapacity, 2, 2);

		click(button_legOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(btn_clear));
		System.out.println(day1LoadFactor);
		System.out.println(day2LoadFactor);
		System.out.println(loadFactor);
		Assert.assertTrue(day1LoadFactor.contains(loadFactor));
		Assert.assertTrue(day2LoadFactor.contains(loadFactor));
		return this;
	}

	/**
	 * Method to create a Single leg schedule flight
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
	 * @param key_fullfltNum
	 * @param key_sDate
	 * @param key_eDate
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @author a-6545
	 */
	public FLT005 createSingleLeg_BUP(String key_carrier_code, String key_route, String key_schType,
			String key_fltType, String key_depTime, String key_arrTime, String key_acType, String key_fltCapVol, String key_fltCapWt,
			String key_fltNum, String key_fullfltNum, String key_sDate, String key_eDate) throws InterruptedException, IOException {

		//fetch test data
		String data_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath, key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath, key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath, key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath, key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType);
		String data_capVol = PropertyHandler.getPropValue(filepath, key_fltCapVol);
		String data_capWt = PropertyHandler.getPropValue(filepath, key_fltCapWt);

		enterKeys(textcarrierCode, data_carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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


		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_fullfltNum, data_carrier_code + fltNo);
		PropertyHandler.setPropValue(filepath, key_sDate, startDt);
		PropertyHandler.setPropValue(filepath, key_eDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), data_route);
		click(check_freq);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);

		click(button_viewCap);
		enterKeys(txt_bup, "1");
		//screen refresh

		click(button_legOk);
		click(waitForElement(yesBtn));
		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		//click(waitForElement(button_diaYes));        
		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param departureTime
	 * @param arrivalTime
	 * @param loadFactor
	 * @param aircraftType
	 * @param capacityVolume
	 * @param capacityWeight
	 * @param l3
	 * @param l7
	 * @param q6
	 * @param q7
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public FLT005 createFlightWithCustomCapacity(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String departureTime, String arrivalTime, String loadFactor, String aircraftType, String capacityVolume, String capacityWeight, String l3, String l7, String q6, String q7) throws InterruptedException, IOException {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		departureTime = PropertyHandler.getPropValue(filepath, departureTime);
		arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
		capacityVolume = PropertyHandler.getPropValue(filepath, capacityVolume);
		capacityWeight = PropertyHandler.getPropValue(filepath, capacityWeight);
		l3 = PropertyHandler.getPropValue(filepath, l3);
		l7 = PropertyHandler.getPropValue(filepath, l7);
		q6 = PropertyHandler.getPropValue(filepath, q6);
		q7 = PropertyHandler.getPropValue(filepath, q7);
		loadFactor = PropertyHandler.getPropValue(filepath, loadFactor);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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
		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);

		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		check(chkbox_domesticFlights);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), departureTime);
		enterKeys(text_arrTime, arrivalTime);
		enterKeys(text_Atype, aircraftType);
		enterKeys(txt_loadFactor, loadFactor);
		enterKeys(txt_capWt, capacityWeight);
		enterKeys(txt_capVol, capacityVolume);
		enterKeys(txt_L3, l3);
		enterKeys(txt_L7, l7);
		enterKeys(txt_Q6, q6);
		enterKeys(txt_Q7, q7);
		click(button_legOk);
		if (verifyElementPresent(yesBtn))
			click(yesBtn);
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param aircraftType
	 * @param defaultWeight
	 * @param defaultVolume
	 * @return
	 */

	public FLT005 updateAircraftType(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate, String aircraftType, String defaultWeight, String defaultVolume) {
		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		flightNo = PropertyHandler.getPropValue(filepath, flightNo);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
		defaultWeight = PropertyHandler.getPropValue(filepath, defaultWeight);
		defaultVolume = PropertyHandler.getPropValue(filepath, defaultVolume);

		String actualWeight;
		String actualVolume;
		String currentWeight;
		String currentVolume;
		enterKeys(textcarrierCode, carrierCode);
		enterKeys(FlightNo, flightNo);
		enterKeys(StartDate, scheduleStartDate);
		enterKeys(EndDate, scheduleEndDate);
		click(button_list);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		currentWeight = waitForElement(txt_capWt).getAttribute("value");
		currentVolume = waitForElement(txt_capVol).getAttribute("value");
		enterKeys(text_Atype, aircraftType);
		click(button_viewCap);
		minWait();


		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);

			minWait();

		}
		minWait();
		actualWeight = waitForElement(txt_capWt).getAttribute("value");
		actualVolume = waitForElement(txt_capVol).getAttribute("value");
		click(button_legOk);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		System.out.println(defaultWeight);
		System.out.println(actualWeight);
		Assert.assertTrue(actualWeight.equals(defaultWeight), "Actual weight is '" + actualWeight + "' and expected is '" + defaultWeight + "'");
		Assert.assertTrue(actualVolume.equals(defaultVolume), "Actual vol is '" + actualVolume + "' and expected is '" + defaultVolume + "'");
		enterKeys(textcarrierCode, carrierCode);
		enterKeys(FlightNo, flightNo);
		enterKeys(StartDate, scheduleStartDate);
		enterKeys(EndDate, scheduleEndDate);
		minWait();
		maxWait();
		click(button_list);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		Assert.assertTrue(getTableColumnValues(legCapacity_table_specificCapacity, 3).contains(defaultWeight));
		Assert.assertTrue(getTableColumnValues(legCapacity_table_specificCapacity, 4).contains(defaultVolume));
		Assert.assertTrue(!getTableColumnValues(legCapacity_table_specificCapacity, 3).contains(currentWeight));
		Assert.assertTrue(!getTableColumnValues(legCapacity_table_specificCapacity, 4).contains(currentVolume));
		click(button_legOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param legOneDepartureTime
	 * @param legOneArrivalTime
	 * @param legOneAircraftType
	 * @param legTwoDepartureTime
	 * @param legTwoArrivalTime
	 * @param legTwoAircraftType
	 * @param gscWeight
	 * @param gscVolume
	 * @param l3
	 * @param l7
	 * @param q6
	 * @param q7
	 * @param defaultWeight
	 * @param defaultVolume
	 * @return
	 */
	public FLT005 multisegmentFlightWithSegmentCapacity(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneArrivalTime, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoArrivalTime, String legTwoAircraftType, String gscWeight, String gscVolume, String l3, String l7,
			String q6, String q7, String defaultWeight, String defaultVolume) {

		String defWeight;
		String defVol;
		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		gscWeight = PropertyHandler.getPropValue(filepath, gscWeight);
		gscVolume = PropertyHandler.getPropValue(filepath, gscVolume);
		l3 = PropertyHandler.getPropValue(filepath, l3);
		l7 = PropertyHandler.getPropValue(filepath, l7);
		q6 = PropertyHandler.getPropValue(filepath, q6);
		q7 = PropertyHandler.getPropValue(filepath, q7);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);


		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;

		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(text_Atype, legOneAircraftType);
		click(button_viewCap);
		defWeight = waitForElement(txt_capWt).getAttribute("value");
		defVol = waitForElement(txt_capVol).getAttribute("value");
		PropertyHandler.setPropValue(filepath, defaultWeight, defWeight);
		PropertyHandler.setPropValue(filepath, defaultVolume, defVol);
		click(button_legOk);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		click(button_legOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(tab_segment);
		check(getWebElements(chkbox_segment).get(0));
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(waitForElement(chkBx_defineGSC));
		enterKeys(defaultCapacity_txt_GSC_Weight, gscWeight);
		enterKeys(defaultCapacity_txt_GSC_Volume, gscVolume);
		enterKeys(segmentCapacity_txt_GSC_L3, l3);
		enterKeys(segmentCapacity_txt_GSC_L7, l7);
		enterKeys(segmentCapacity_txt_GSC_Q6, q6);
		enterKeys(segmentCapacity_txt_GSC_Q7, q7);
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();

		check(getWebElements(chkbox_segment).get(2));
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(waitForElement(chkBx_defineGSC));
		enterKeys(defaultCapacity_txt_GSC_Weight, gscWeight);
		enterKeys(defaultCapacity_txt_GSC_Volume, gscVolume);
		enterKeys(segmentCapacity_txt_GSC_L3, l3);
		enterKeys(segmentCapacity_txt_GSC_L7, l7);
		enterKeys(segmentCapacity_txt_GSC_Q6, q6);
		enterKeys(segmentCapacity_txt_GSC_Q7, q7);
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		click(waitForElement(yesBtn));
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);
		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param legOneDepartureTime
	 * @param legOneDayChangeAtOrigin
	 * @param legOneArrivalTime
	 * @param legOneDayChangeAtDestination
	 * @param legOneAircraftType
	 * @param legTwoDepartureTime
	 * @param legTwoDayChangeAtOrigin
	 * @param legTwoArrivalTime
	 * @param legTwoDayChangeAtDestination
	 * @param legTwoAircraftType
	 * @param trafficRightStatus
	 * @return
	 */
	public FLT005 createMultisegmentFlightWithTrafficRightStatus(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneDayChangeAtOrigin, String legOneArrivalTime, String legOneDayChangeAtDestination, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoDayChangeAtOrigin, String legTwoArrivalTime, String legTwoDayChangeAtDestination, String legTwoAircraftType, String trafficRightStatus) {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		legOneDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legOneDayChangeAtOrigin);
		legOneDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legOneDayChangeAtDestination);
		legTwoDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtOrigin);
		legTwoDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtDestination);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		trafficRightStatus = PropertyHandler.getPropValue(filepath, trafficRightStatus);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(txt_dayChangeAtOrigin, legOneDayChangeAtOrigin);
		enterKeys(text_Atype, legOneAircraftType);
		enterKeys(txt_dayChangeAtDestination, legOneDayChangeAtDestination);
		click(button_viewCap);
		click(button_legOk);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(txt_dayChangeAtOrigin, legTwoDayChangeAtOrigin);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(txt_dayChangeAtDestination, legTwoDayChangeAtDestination);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(tab_segment);
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		selectByText(segmentCapacity_dropdown_TrafficRights, trafficRightStatus);
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		click(waitForElement(yesBtn));
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);
		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param legOneDepartureTime
	 * @param legOneDayChangeAtOrigin
	 * @param legOneArrivalTime
	 * @param legOneDayChangeAtDestination
	 * @param legOneAircraftType
	 * @param legTwoDepartureTime
	 * @param legTwoDayChangeAtOrigin
	 * @param legTwoArrivalTime
	 * @param legTwoDayChangeAtDestination
	 * @param legTwoAircraftType
	 * @param bookingStatus
	 * @return
	 */
	public FLT005 createMultisegmentFlightWithBookingStatus(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneDayChangeAtOrigin, String legOneArrivalTime, String legOneDayChangeAtDestination, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoDayChangeAtOrigin, String legTwoArrivalTime, String legTwoDayChangeAtDestination, String legTwoAircraftType, String bookingStatus) {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		legOneDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legOneDayChangeAtOrigin);
		legOneDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legOneDayChangeAtDestination);
		legTwoDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtOrigin);
		legTwoDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtDestination);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		bookingStatus = PropertyHandler.getPropValue(filepath, bookingStatus);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(txt_dayChangeAtOrigin, legOneDayChangeAtOrigin);
		enterKeys(text_Atype, legOneAircraftType);
		enterKeys(txt_dayChangeAtDestination, legOneDayChangeAtDestination);
		click(button_viewCap);
		click(button_legOk);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(txt_dayChangeAtOrigin, legTwoDayChangeAtOrigin);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(txt_dayChangeAtDestination, legTwoDayChangeAtDestination);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(tab_segment);
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		selectByText(segmentCapacity_dropdown_BookingStatus, bookingStatus);
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		click(waitForElement(yesBtn));
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);
		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param legOneDepartureTime
	 * @param legOneDayChangeAtOrigin
	 * @param legOneArrivalTime
	 * @param legOneDayChangeAtDestination
	 * @param legOneAircraftType
	 * @param legTwoDepartureTime
	 * @param legTwoDayChangeAtOrigin
	 * @param legTwoArrivalTime
	 * @param legTwoDayChangeAtDestination
	 * @param legTwoAircraftType
	 * @param segCapacityWeight
	 * @param segCapacityVolume
	 * @return
	 */
	public FLT005 createMultisegmentFlightWithSegmentCapacityForFirstLeg(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneDayChangeAtOrigin, String legOneArrivalTime, String legOneDayChangeAtDestination, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoDayChangeAtOrigin, String legTwoArrivalTime, String legTwoDayChangeAtDestination, String legTwoAircraftType, String segCapacityWeight,
			String segCapacityVolume) {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		legOneDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legOneDayChangeAtOrigin);
		legOneDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legOneDayChangeAtDestination);
		legTwoDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtOrigin);
		legTwoDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtDestination);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		segCapacityWeight = PropertyHandler.getPropValue(filepath, segCapacityWeight);
		segCapacityVolume = PropertyHandler.getPropValue(filepath, segCapacityVolume);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(txt_dayChangeAtOrigin, legOneDayChangeAtOrigin);
		enterKeys(text_Atype, legOneAircraftType);
		enterKeys(txt_dayChangeAtDestination, legOneDayChangeAtDestination);
		click(button_viewCap);
		click(button_legOk);
		/*driver.switchTo().defaultContent();
        if(verifyElementPresent(yesBtn))
        	click(yesBtn); */
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(txt_dayChangeAtOrigin, legTwoDayChangeAtOrigin);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(txt_dayChangeAtDestination, legTwoDayChangeAtDestination);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);
		/* driver.switchTo().defaultContent();
        if(verifyElementPresent(yesBtn))
        	click(yesBtn); */
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(tab_segment);
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(segmentCapacity_txt_capacityWeight, segCapacityWeight);
		enterKeys(segmentCapacity_txt_capacityVolume, segCapacityVolume);
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		click(waitForElement(yesBtn));
		waitForElement(button_diaOk);
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);
		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param legOneDepartureTime
	 * @param legOneDayChangeAtOrigin
	 * @param legOneArrivalTime
	 * @param legOneDayChangeAtDestination
	 * @param legOneAircraftType
	 * @param legTwoDepartureTime
	 * @param legTwoDayChangeAtOrigin
	 * @param legTwoArrivalTime
	 * @param legTwoDayChangeAtDestination
	 * @param legTwoAircraftType
	 * @param segCapacityWeight
	 * @param segCapacityVolume
	 * @return
	 */
	public FLT005 createMultisegmentFlightWithSegmentCapacityForSecondLeg(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneDayChangeAtOrigin, String legOneArrivalTime, String legOneDayChangeAtDestination, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoDayChangeAtOrigin, String legTwoArrivalTime, String legTwoDayChangeAtDestination, String legTwoAircraftType, String segCapacityWeight,
			String segCapacityVolume) {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		legOneDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legOneDayChangeAtOrigin);
		legOneDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legOneDayChangeAtDestination);
		legTwoDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtOrigin);
		legTwoDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtDestination);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		segCapacityWeight = PropertyHandler.getPropValue(filepath, segCapacityWeight);
		segCapacityVolume = PropertyHandler.getPropValue(filepath, segCapacityVolume);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(txt_dayChangeAtOrigin, legOneDayChangeAtOrigin);
		enterKeys(text_Atype, legOneAircraftType);
		enterKeys(txt_dayChangeAtDestination, legOneDayChangeAtDestination);
		click(button_viewCap);
		click(button_legOk);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(txt_dayChangeAtOrigin, legTwoDayChangeAtOrigin);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(txt_dayChangeAtDestination, legTwoDayChangeAtDestination);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(tab_segment);
		minWait();
		minWait();
		check(chkbox_secondSegment);
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(segmentCapacity_txt_capacityWeight, segCapacityWeight);
		enterKeys(segmentCapacity_txt_capacityVolume, segCapacityVolume);
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		click(waitForElement(yesBtn));
		waitForElement(button_diaOk);
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);
		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param legOneDepartureTime
	 * @param legOneDayChangeAtOrigin
	 * @param legOneArrivalTime
	 * @param legOneDayChangeAtDestination
	 * @param legOneAircraftType
	 * @param legTwoDepartureTime
	 * @param legTwoDayChangeAtOrigin
	 * @param legTwoArrivalTime
	 * @param legTwoDayChangeAtDestination
	 * @param legTwoAircraftType
	 * @param segCapacityWeightForFirstSeg
	 * @param segCapacityVolumeForFirstSeg
	 * @param segCapacityWeightForSecondSeg
	 * @param segCapacityVolumeForSecondSeg
	 * @return
	 */
	public FLT005 createMultisegmentFlightWithSegmentCapacityForSepcifcDaysForTwoSegments(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneDayChangeAtOrigin, String legOneArrivalTime, String legOneDayChangeAtDestination, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoDayChangeAtOrigin, String legTwoArrivalTime, String legTwoDayChangeAtDestination, String legTwoAircraftType, String segCapacityWeightForFirstSeg,
			String segCapacityVolumeForFirstSeg, String segCapacityWeightForSecondSeg, String segCapacityVolumeForSecondSeg) {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		legOneDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legOneDayChangeAtOrigin);
		legOneDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legOneDayChangeAtDestination);
		legTwoDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtOrigin);
		legTwoDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtDestination);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		segCapacityWeightForFirstSeg = PropertyHandler.getPropValue(filepath, segCapacityWeightForFirstSeg);
		segCapacityVolumeForFirstSeg = PropertyHandler.getPropValue(filepath, segCapacityVolumeForFirstSeg);
		segCapacityWeightForSecondSeg = PropertyHandler.getPropValue(filepath, segCapacityWeightForSecondSeg);
		segCapacityVolumeForSecondSeg = PropertyHandler.getPropValue(filepath, segCapacityVolumeForSecondSeg);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();
		minWait();
		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(txt_dayChangeAtOrigin, legOneDayChangeAtOrigin);
		enterKeys(text_Atype, legOneAircraftType);
		enterKeys(txt_dayChangeAtDestination, legOneDayChangeAtDestination);
		click(button_viewCap);
		click(button_legOk);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(txt_dayChangeAtOrigin, legTwoDayChangeAtOrigin);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(txt_dayChangeAtDestination, legTwoDayChangeAtDestination);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(tab_segment);
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		minWait();
		maxWait();
		check(segmentCapacity_chkbox_mon);
		check(segmentCapacity_chkbox_tue);
		enterKeys(segmentCapacity_txt_capacityWeight, segCapacityWeightForFirstSeg);
		enterKeys(segmentCapacity_txt_capacityVolume, segCapacityVolumeForFirstSeg);
		click(segmentCapacity_btn_ChangeCapacity);
		minWait();
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		check(getWebElements(chkbox_segment).get(1));
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		minWait();
		check(segmentCapacity_chkbox_mon);
		check(segmentCapacity_chkbox_tue);
		enterKeys(segmentCapacity_txt_capacityWeight, segCapacityWeightForSecondSeg);
		enterKeys(segmentCapacity_txt_capacityVolume, segCapacityVolumeForSecondSeg);
		click(segmentCapacity_btn_ChangeCapacity);
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		click(waitForElement(yesBtn));
		waitForElement(button_diaOk);
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);
		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param legOneDepartureTime
	 * @param legOneDayChangeAtOrigin
	 * @param legOneArrivalTime
	 * @param legOneDayChangeAtDestination
	 * @param legOneAircraftType
	 * @param legTwoDepartureTime
	 * @param legTwoDayChangeAtOrigin
	 * @param legTwoArrivalTime
	 * @param legTwoDayChangeAtDestination
	 * @param legTwoAircraftType
	 * @param segCapacityWeightForFirstSeg
	 * @param segCapacityVolumeForFirstSeg
	 * @param segCapacityWeightForSecondSeg
	 * @param segCapacityVolumeForSecondSeg
	 * @param segOneOverbookingWeight
	 * @param segOneOverbookingVolume
	 * @param segOneL3
	 * @param segOneL7
	 * @param segOneQ6
	 * @param segOneQ7
	 * @param segTwoOverbookingWeight
	 * @param segTwoOverbookingVolume
	 * @param segTwoL3
	 * @param segTwoL7
	 * @param segTwoQ6
	 * @param segTwoQ7
	 * @return
	 */
	public FLT005 createMultisegmentFlightWithSegmentCapacityAndOverbookingDetails(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneDayChangeAtOrigin, String legOneArrivalTime, String legOneDayChangeAtDestination, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoDayChangeAtOrigin, String legTwoArrivalTime, String legTwoDayChangeAtDestination, String legTwoAircraftType, String segCapacityWeightForFirstSeg,
			String segCapacityVolumeForFirstSeg, String segCapacityWeightForSecondSeg, String segCapacityVolumeForSecondSeg, String segOneOverbookingWeight, String segOneOverbookingVolume, String segOneL3, String segOneL7, String segOneQ6, String segOneQ7,
			String segTwoOverbookingWeight, String segTwoOverbookingVolume, String segTwoL3, String segTwoL7, String segTwoQ6, String segTwoQ7) {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		legOneDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legOneDayChangeAtOrigin);
		legOneDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legOneDayChangeAtDestination);
		legTwoDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtOrigin);
		legTwoDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtDestination);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		segCapacityWeightForFirstSeg = PropertyHandler.getPropValue(filepath, segCapacityWeightForFirstSeg);
		segCapacityVolumeForFirstSeg = PropertyHandler.getPropValue(filepath, segCapacityVolumeForFirstSeg);
		segCapacityWeightForSecondSeg = PropertyHandler.getPropValue(filepath, segCapacityWeightForSecondSeg);
		segCapacityVolumeForSecondSeg = PropertyHandler.getPropValue(filepath, segCapacityVolumeForSecondSeg);

		segTwoOverbookingWeight = PropertyHandler.getPropValue(filepath, segTwoOverbookingWeight);
		segTwoOverbookingVolume = PropertyHandler.getPropValue(filepath, segTwoOverbookingVolume);
		segTwoL3 = PropertyHandler.getPropValue(filepath, segTwoL3);
		segTwoL7 = PropertyHandler.getPropValue(filepath, segTwoL7);
		segTwoQ6 = PropertyHandler.getPropValue(filepath, segTwoQ6);
		segTwoQ7 = PropertyHandler.getPropValue(filepath, segTwoQ7);

		segOneOverbookingWeight = PropertyHandler.getPropValue(filepath, segOneOverbookingWeight);
		segOneOverbookingVolume = PropertyHandler.getPropValue(filepath, segOneOverbookingVolume);
		segOneL3 = PropertyHandler.getPropValue(filepath, segOneL3);
		segOneL7 = PropertyHandler.getPropValue(filepath, segOneL7);
		segOneQ6 = PropertyHandler.getPropValue(filepath, segOneQ6);
		segOneQ7 = PropertyHandler.getPropValue(filepath, segOneQ7);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(txt_dayChangeAtOrigin, legOneDayChangeAtOrigin);
		enterKeys(text_Atype, legOneAircraftType);
		enterKeys(txt_dayChangeAtDestination, legOneDayChangeAtDestination);
		click(button_viewCap);
		click(button_legOk);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(txt_dayChangeAtOrigin, legTwoDayChangeAtOrigin);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(txt_dayChangeAtDestination, legTwoDayChangeAtDestination);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(tab_segment);
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(segmentCapacity_chkbox_mon);
		check(segmentCapacity_chkbox_tue);
		enterKeys(segmentCapacity_txt_capacityWeight, segCapacityWeightForFirstSeg);
		enterKeys(segmentCapacity_txt_capacityVolume, segCapacityVolumeForFirstSeg);
		click(segmentCapacity_btn_ChangeCapacity);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingWeight, segOneOverbookingWeight);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingVolume, segOneOverbookingVolume);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingL3, segOneL3);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingL7, segOneL7);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingQ6, segOneQ6);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingQ7, segOneQ7);
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		check(getWebElements(chkbox_segment).get(1));
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(segmentCapacity_chkbox_mon);
		check(segmentCapacity_chkbox_tue);
		enterKeys(segmentCapacity_txt_capacityWeight, segCapacityWeightForSecondSeg);
		enterKeys(segmentCapacity_txt_capacityVolume, segCapacityVolumeForSecondSeg);
		click(segmentCapacity_btn_ChangeCapacity);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingWeight, segTwoOverbookingWeight);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingVolume, segTwoOverbookingVolume);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingL3, segTwoL3);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingL7, segTwoL7);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingQ6, segTwoQ6);
		enterKeys(segmentCapacity_txt_defaultCapacityOverBookingQ7, segTwoQ7);
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		click(waitForElement(yesBtn));
		waitForElement(button_diaOk);
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);
		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param legOneDepartureTime
	 * @param legOneDayChangeAtOrigin
	 * @param legOneArrivalTime
	 * @param legOneDayChangeAtDestination
	 * @param legOneAircraftType
	 * @param legTwoDepartureTime
	 * @param legTwoDayChangeAtOrigin
	 * @param legTwoArrivalTime
	 * @param legTwoDayChangeAtDestination
	 * @param legTwoAircraftType
	 * @param segCapacityWeight
	 * @param segCapacityVolume
	 * @param aircraftDefWeight
	 * @param aircraftDefVol
	 * @return
	 */
	public FLT005 checkValidationsForCapacity(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneDayChangeAtOrigin, String legOneArrivalTime, String legOneDayChangeAtDestination, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoDayChangeAtOrigin, String legTwoArrivalTime, String legTwoDayChangeAtDestination, String legTwoAircraftType, String segCapacityWeight,
			String segCapacityVolume, String aircraftDefWeight, String aircraftDefVol) {
		String defaultWeight, defaultVolume;
		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		legOneDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legOneDayChangeAtOrigin);
		legOneDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legOneDayChangeAtDestination);
		legTwoDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtOrigin);
		legTwoDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtDestination);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		segCapacityWeight = PropertyHandler.getPropValue(filepath, segCapacityWeight);
		segCapacityVolume = PropertyHandler.getPropValue(filepath, segCapacityVolume);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(txt_dayChangeAtOrigin, legOneDayChangeAtOrigin);
		enterKeys(text_Atype, legOneAircraftType);
		enterKeys(txt_dayChangeAtDestination, legOneDayChangeAtDestination);
		click(button_viewCap);
		minWait();
		defaultWeight = waitForElement(txt_capWt).getAttribute("value");
		defaultVolume = waitForElement(txt_capVol).getAttribute("value");
		click(button_legOk);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(txt_dayChangeAtOrigin, legTwoDayChangeAtOrigin);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(txt_dayChangeAtDestination, legTwoDayChangeAtDestination);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(tab_segment);
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(segmentCapacity_txt_capacityWeight, segCapacityWeight);
		enterKeys(segmentCapacity_txt_capacityVolume, segCapacityVolume);
		click(btn_segCapacityOk);
		Assert.assertTrue(waitForElement(footer_error).getText().contains("Segment capacity specified cannot exceed the capacity of the constraining leg."));
		click(segmentCapacity_btn_close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(waitForElement(list_chkBxSeg));
		click(tab_leg);
		minWait();
		click(waitForElement(btn_legCapacity));
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(txt_capWt, segCapacityWeight);
		enterKeys(txt_capVol, segCapacityVolume);
		click(button_legOk);
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Leg Capacity is greater than the capacity of the aircraft type specified.Do you want to continue?"), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(waitForElement(noBtn));
		minWait();
		click(button_viewCap);
		click(button_legOk);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		click(waitForElement(yesBtn));
		waitForElement(button_diaOk);
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);
		waitForFrameAndSwitch(FRAME);
		minWait();
		PropertyHandler.setPropValue(filepath, aircraftDefWeight, defaultWeight);
		PropertyHandler.setPropValue(filepath, aircraftDefVol, defaultVolume);
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param legOneDepartureTime
	 * @param legOneDayChangeAtOrigin
	 * @param legOneArrivalTime
	 * @param legOneDayChangeAtDestination
	 * @param legOneAircraftType
	 * @param legTwoDepartureTime
	 * @param legTwoDayChangeAtOrigin
	 * @param legTwoArrivalTime
	 * @param legTwoDayChangeAtDestination
	 * @param legTwoAircraftType
	 * @param segCapacityWeight
	 * @param segCapacityVolume
	 * @return
	 */
	public FLT005 createMultiSegWithCapacityGreaterThanAircraftDefault(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String legOneDepartureTime, String legOneDayChangeAtOrigin, String legOneArrivalTime, String legOneDayChangeAtDestination, String legOneAircraftType, String legTwoDepartureTime,
			String legTwoDayChangeAtOrigin, String legTwoArrivalTime, String legTwoDayChangeAtDestination, String legTwoAircraftType, String segCapacityWeight,
			String segCapacityVolume) {
		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		legOneDepartureTime = PropertyHandler.getPropValue(filepath, legOneDepartureTime);
		legOneArrivalTime = PropertyHandler.getPropValue(filepath, legOneArrivalTime);
		legOneAircraftType = PropertyHandler.getPropValue(filepath, legOneAircraftType);
		legTwoDepartureTime = PropertyHandler.getPropValue(filepath, legTwoDepartureTime);
		legTwoArrivalTime = PropertyHandler.getPropValue(filepath, legTwoArrivalTime);
		legTwoAircraftType = PropertyHandler.getPropValue(filepath, legTwoAircraftType);
		legOneDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legOneDayChangeAtOrigin);
		legOneDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legOneDayChangeAtDestination);
		legTwoDayChangeAtOrigin = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtOrigin);
		legTwoDayChangeAtDestination = PropertyHandler.getPropValue(filepath, legTwoDayChangeAtDestination);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
		segCapacityWeight = PropertyHandler.getPropValue(filepath, segCapacityWeight);
		segCapacityVolume = PropertyHandler.getPropValue(filepath, segCapacityVolume);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), legOneDepartureTime);
		enterKeys(text_arrTime, legOneArrivalTime);
		enterKeys(txt_dayChangeAtOrigin, legOneDayChangeAtOrigin);
		enterKeys(text_Atype, legOneAircraftType);
		enterKeys(txt_dayChangeAtDestination, legOneDayChangeAtDestination);
		click(button_viewCap);
		minWait();
		enterKeys(txt_capWt, segCapacityWeight);
		enterKeys(txt_capVol, segCapacityVolume);
		click(button_legOk);
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Leg Capacity is greater than the capacity of the aircraft type specified.Do you want to continue?"), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(waitForElement(yesBtn));

		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//check 2nd leg
		check(leg2);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(text_depTime), legTwoDepartureTime);
		enterKeys(txt_dayChangeAtOrigin, legTwoDayChangeAtOrigin);
		enterKeys(text_arrTime, legTwoArrivalTime);
		enterKeys(txt_dayChangeAtDestination, legTwoDayChangeAtDestination);
		enterKeys(text_Atype, legTwoAircraftType);
		click(button_viewCap);
		minWait();
		click(button_legOk);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		click(waitForElement(yesBtn));
		waitForElement(button_diaOk);
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);
		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param dayChangeAtDestination
	 * @param departureTime
	 * @param dayChangeAtOrigin
	 * @param arrivalTime
	 * @param loadFactor
	 * @param aircraftType
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public FLT005 createDomesticFlight(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String dayChangeAtDestination, String departureTime, String dayChangeAtOrigin, String arrivalTime, String loadFactor, String aircraftType, String startDate, String endDate) throws InterruptedException, IOException {
		String start;
		String end;
		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		departureTime = PropertyHandler.getPropValue(filepath, departureTime);
		arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
		dayChangeAtDestination = PropertyHandler.getPropValue(filepath, dayChangeAtDestination);
		dayChangeAtOrigin = PropertyHandler.getPropValue(filepath, dayChangeAtOrigin);
		loadFactor = PropertyHandler.getPropValue(filepath, loadFactor);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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
		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		start = waitForElement(StartDate).getAttribute("value");
		end = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		PropertyHandler.setPropValue(filepath, startDate, start);
		PropertyHandler.setPropValue(filepath, endDate, end);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		check(chkbox_domesticFlights);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), departureTime);
		enterKeys(txt_dayChangeAtDestination, dayChangeAtDestination);
		enterKeys(text_arrTime, arrivalTime);
		enterKeys(txt_dayChangeAtOrigin, dayChangeAtOrigin);
		enterKeys(text_Atype, aircraftType);
		if (loadFactor != null) {
			enterKeys(txt_loadFactor, loadFactor);
		}
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param flightStartDate
	 * @param flightEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param departureTime
	 * @param arrivalTime
	 * @param loadFactor
	 * @param aircraftType
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public FLT005 createFlightWithDefaultCapacity(String carrierCode, String flightNo, String fullFlightNo, String flightStartDate, String flightEndDate, String route, String scheduleType,
			String flightType, String departureTime, String arrivalTime, String loadFactor, String aircraftType) throws InterruptedException, IOException {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		departureTime = PropertyHandler.getPropValue(filepath, departureTime);
		arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
		loadFactor = PropertyHandler.getPropValue(filepath, loadFactor);
		flightStartDate = PropertyHandler.getPropValue(filepath, flightStartDate);
		flightEndDate = PropertyHandler.getPropValue(filepath, flightEndDate);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, flightStartDate);			
			enterKeys(EndDate, flightEndDate);			
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
		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");

		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		/*PropertyHandler.setPropValue(filepath, flightStartDate, startDt);
		PropertyHandler.setPropValue(filepath, flightEndDate, endDt);*/


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), departureTime);
		enterKeys(text_arrTime, arrivalTime);
		enterKeys(text_Atype, aircraftType);
		enterKeys(txt_loadFactor, loadFactor);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}


	public FLT005 createCharterFlight(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String dayChangeAtDestination, String departureTime, String dayChangeAtOrigin, String arrivalTime, String loadFactor, String aircraftType) throws InterruptedException, IOException {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		departureTime = PropertyHandler.getPropValue(filepath, departureTime);
		arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
		dayChangeAtDestination = PropertyHandler.getPropValue(filepath, dayChangeAtDestination);
		dayChangeAtOrigin = PropertyHandler.getPropValue(filepath, dayChangeAtOrigin);
		loadFactor = PropertyHandler.getPropValue(filepath, loadFactor);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);
			enterKeys(EndDate, scheduleEndDate);
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
		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);

		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		selectByText(dropdown_agreementType, "Charter Flight");
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), departureTime);
		enterKeys(txt_dayChangeAtDestination, dayChangeAtDestination);
		enterKeys(text_arrTime, arrivalTime);
		enterKeys(txt_dayChangeAtOrigin, dayChangeAtOrigin);
		enterKeys(text_Atype, aircraftType);
		enterKeys(txt_loadFactor, loadFactor);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}


	public FLT005 createFlightInLiveStatus(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String dayChangeAtDestination, String departureTime, String dayChangeAtOrigin, String arrivalTime, String loadFactor, String aircraftType) throws InterruptedException, IOException {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		departureTime = PropertyHandler.getPropValue(filepath, departureTime);
		arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
		dayChangeAtDestination = PropertyHandler.getPropValue(filepath, dayChangeAtDestination);
		dayChangeAtOrigin = PropertyHandler.getPropValue(filepath, dayChangeAtOrigin);
		loadFactor = PropertyHandler.getPropValue(filepath, loadFactor);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);

		String rand_fltnum;
		while (true) {
			enterKeys(textcarrierCode, carrierCode);
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, scheduleStartDate);		
			enterKeys(EndDate, scheduleEndDate);			
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
		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		//        String startDt = waitForElement(StartDate).getAttribute("value");
		//        String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		//        PropertyHandler.setPropValue(filepath, scheduleStartDate, startDt);
		//        PropertyHandler.setPropValue(filepath, scheduleEndDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), departureTime);
		enterKeys(txt_dayChangeAtDestination, dayChangeAtDestination);
		enterKeys(text_arrTime, arrivalTime);
		enterKeys(txt_dayChangeAtOrigin, dayChangeAtOrigin);
		enterKeys(text_Atype, aircraftType);
		enterKeys(txt_loadFactor, loadFactor);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}

	/**
	 * Created by A-7605
	 *
	 * @param key_carrier_code
	 * @param key_fltNum
	 * @param key_sDate
	 * @param key_eDate
	 * @param key_capVol
	 * @param key_capWt
	 * @param l3
	 * @param l7
	 * @param q6
	 * @param q7
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public FLT005 updateFlightCapacity(String key_carrier_code, String key_fltNum, String key_sDate, String key_eDate,
			String key_capVol, String key_capWt, String l3, String l7, String q6, String q7) throws InterruptedException, IOException {


		key_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
		key_fltNum = PropertyHandler.getPropValue(filepath, key_fltNum);
		key_capWt = PropertyHandler.getPropValue(filepath, key_capWt);
		key_capVol = PropertyHandler.getPropValue(filepath, key_capVol);
		l3 = PropertyHandler.getPropValue(filepath, l3);
		l7 = PropertyHandler.getPropValue(filepath, l7);
		q6 = PropertyHandler.getPropValue(filepath, q6);
		q7 = PropertyHandler.getPropValue(filepath, q7);
		key_sDate = PropertyHandler.getPropValue(filepath, key_sDate);
		key_eDate = PropertyHandler.getPropValue(filepath, key_eDate);

		enterKeys(textcarrierCode, key_carrier_code);
		enterKeys(FlightNo, key_fltNum);
		enterKeys(StartDate, key_sDate);
		enterKeys(EndDate, key_eDate);
		click(button_list);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(txt_capVol, key_capVol);
		enterKeys(txt_capWt, key_capWt);
		enterKeys(txt_L3, l3);
		enterKeys(txt_L7, l7);
		enterKeys(txt_Q6, q6);
		enterKeys(txt_Q7, q7);
		click(button_legOk);
		driver.switchTo().defaultContent();
		minWait();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}//handle the case when no pop-up is displayed
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		minWait();
		System.out.println(waitForElement(msg_success).getText());
		Assert.assertTrue(waitForElement(msg_success).getText().contains("Flight Schedule Saved Successfully."), "ERROR : FLIGHT SAVED SUCCESSFULLY message not displayed");

		waitForFrameAndSwitch(FRAME);
		//       click(info_msgClose);
		//maxWait();

		return this;
	}

	/**
	 * Created by A-7605 on 6-2-18
	 * This method will create flight schedule without bursting the sechedule
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param flightStartDate
	 * @param flightEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param departureTime
	 * @param arrivalTime
	 * @param loadFactor
	 * @param aircraftType
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public FLT005 createFlightWithDefaultCapacityWithoutBurst(String carrierCode, String flightNo, String fullFlightNo, String flightStartDate, String flightEndDate, String route, String scheduleType,
			String flightType, String departureTime, String arrivalTime, String loadFactor, String aircraftType) throws InterruptedException, IOException {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		departureTime = PropertyHandler.getPropValue(filepath, departureTime);
		arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
		loadFactor = PropertyHandler.getPropValue(filepath, loadFactor);
		flightStartDate = PropertyHandler.getPropValue(filepath, flightStartDate);
		flightEndDate = PropertyHandler.getPropValue(filepath, flightEndDate);

		enterKeys(textcarrierCode, carrierCode);

		String rand_fltnum;
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, flightStartDate);
			enterKeys(EndDate, flightEndDate);
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
		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");

		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		//        PropertyHandler.setPropValue(filepath, flightStartDate, startDt);
		//        PropertyHandler.setPropValue(filepath, flightEndDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), departureTime);
		enterKeys(text_arrTime, arrivalTime);
		enterKeys(text_Atype, aircraftType);
		enterKeys(txt_loadFactor, loadFactor);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(noBtn));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}

	/**
	 * Created by A-7605 on 7-2-18
	 * This method will create an OAL flight schedule
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param fullFlightNo
	 * @param scheduleStartDate
	 * @param scheduleEndDate
	 * @param route
	 * @param scheduleType
	 * @param flightType
	 * @param dayChangeAtDestination
	 * @param departureTime
	 * @param dayChangeAtOrigin
	 * @param arrivalTime
	 * @param loadFactor
	 * @param aircraftType
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public FLT005 createOALFlightInLiveStatus(String carrierCode, String flightNo, String fullFlightNo, String scheduleStartDate, String scheduleEndDate, String route, String scheduleType,
			String flightType, String dayChangeAtDestination, String departureTime, String dayChangeAtOrigin, String arrivalTime, String loadFactor, String aircraftType) throws InterruptedException, IOException {

		carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
		route = PropertyHandler.getPropValue(filepath, route);
		scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
		flightType = PropertyHandler.getPropValue(filepath, flightType);
		departureTime = PropertyHandler.getPropValue(filepath, departureTime);
		arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
		aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
		dayChangeAtDestination = PropertyHandler.getPropValue(filepath, dayChangeAtDestination);
		dayChangeAtOrigin = PropertyHandler.getPropValue(filepath, dayChangeAtOrigin);
		loadFactor = PropertyHandler.getPropValue(filepath, loadFactor);
		scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
		scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);

		String rand_fltnum;
		while (true) {
			enterKeys(textcarrierCode, carrierCode);
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			//enterKeys(StartDate, scheduleStartDate);
			enterKeys(StartDate, ".");
			//enterKeys(EndDate, scheduleEndDate);
			enterKeys(EndDate, "+6");
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
		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		//	        String startDt = waitForElement(StartDate).getAttribute("value");
		//	        String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, flightNo, fltNo);
		PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
		//	        PropertyHandler.setPropValue(filepath, scheduleStartDate, startDt);
		//	        PropertyHandler.setPropValue(filepath, scheduleEndDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, scheduleType);
		selectByText(list_Ftype, flightType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), departureTime);
		enterKeys(txt_dayChangeAtDestination, dayChangeAtDestination);
		enterKeys(text_arrTime, arrivalTime);
		enterKeys(txt_dayChangeAtOrigin, dayChangeAtOrigin);
		enterKeys(text_Atype, aircraftType);
		enterKeys(txt_loadFactor, loadFactor);
		click(button_viewCap);
		//screen refresh
		click(button_legOk);

		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn))
			click(yesBtn);
		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		click(waitForElement(yesBtn));
		minWait();
		click(waitForElement(yesBtn));
		Assert.assertTrue(waitForElement(dialogueText).getText().equals("Burst completed successfully."), "The actual message is '" + waitForElement(dialogueText).getText() + "'");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}



	public FLT005 createSingleLegOAL(String key_carrier_code, String key_route, String key_schType,
			String key_fltType, String key_depTime, String key_arrTime, String key_acType, String key_fltCapVol, String key_fltCapWt,
			String key_fltNum, String key_fullfltNum, String key_sDate, String key_eDate) throws InterruptedException, IOException {

		//fetch test data
		String data_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath, key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath, key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath, key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath, key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType);
		String data_capVol = PropertyHandler.getPropValue(filepath, key_fltCapVol);
		String data_capWt = PropertyHandler.getPropValue(filepath, key_fltCapWt);

		enterKeys(textcarrierCode, data_carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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

		//------------------------
		/*   rand_fltnum = BizUtility.createFlightNum();
enterKeys(FlightNo, rand_fltnum);
enterKeys(StartDate, ".");
enterKeys(EndDate, "+7");
click(button_list);
minWait();
//    driver.navigate().refresh();*/
		//----------------------------------------

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_fullfltNum, data_carrier_code + fltNo).replaceFirst(" ", "");
		PropertyHandler.setPropValue(filepath, key_sDate, startDt);
		PropertyHandler.setPropValue(filepath, key_eDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), data_route);
		click(check_freq);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);
		click(button_legOk);


		minWait();

		//switch back to main window

		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
			minWait();
		}
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		//click(waitForElement(button_diaYes));        
		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
		click(button_diaOk);
		click(button_diaOk);
		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;

	}





	public FLT005 createSingleLegLeasedAgreement(String key_carrier_code, String key_route, String key_schType,
			String key_fltType, String key_depTime, String key_arrTime, String key_acType, String key_fltCapVol, String key_fltCapWt,
			String key_fltNum, String key_fullfltNum, String key_sDate, String key_eDate) throws InterruptedException, IOException {

		//fetch test data
		String data_carrier_code = PropertyHandler.getPropValue(filepath, key_carrier_code);
		String data_route = PropertyHandler.getPropValue(filepath, key_route);
		String data_schType = PropertyHandler.getPropValue(filepath, key_schType);
		String data_fltType = PropertyHandler.getPropValue(filepath, key_fltType);
		String data_depTime = PropertyHandler.getPropValue(filepath, key_depTime);
		String data_arrTime = PropertyHandler.getPropValue(filepath, key_arrTime);
		String data_acType = PropertyHandler.getPropValue(filepath, key_acType);
		String data_capVol = PropertyHandler.getPropValue(filepath, key_fltCapVol);
		String data_capWt = PropertyHandler.getPropValue(filepath, key_fltCapWt);


		enterKeys(textcarrierCode, data_carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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

		//------------------------
		/*   rand_fltnum = BizUtility.createFlightNum();
enterKeys(FlightNo, rand_fltnum);
enterKeys(StartDate, ".");
enterKeys(EndDate, "+7");
click(button_list);
minWait();
//    driver.navigate().refresh();*/
		//----------------------------------------

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, key_fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, key_fullfltNum, data_carrier_code + fltNo).replaceFirst(" ", "");
		PropertyHandler.setPropValue(filepath, key_sDate, startDt);
		PropertyHandler.setPropValue(filepath, key_eDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), data_route);
		click(check_freq);

		selectByText(list_schType, data_schType);
		selectByText(list_Ftype, data_fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		selectByText(dropdown_agreementType, "Leased Flight");
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), data_depTime);
		enterKeys(text_arrTime, data_arrTime);
		enterKeys(text_Atype, data_acType);
		click(button_viewCap);
		click(button_legOk);


		minWait();

		//switch back to main window

		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
			minWait();
		}
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		//click(waitForElement(button_diaYes));        
		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
		click(button_diaOk);
		if(verifyElementEnabled(button_diaOk))
			click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;

	}


	public FLT005 createSingleLegWithAllCapacityDetails(String carrier_code, String route, String schType,
			String fltType, String depTime, String arrTime, String acType, String OVBWt, String OVBVol, 
			String L3, String L7, String Q6, String Q7, String fltCapVol, String fltCapWt,
			String fltNum, String fullfltNum, String sDate, String eDate) throws InterruptedException, IOException {

		//fetch test data
		carrier_code = PropertyHandler.getPropValue(filepath, carrier_code);
		route = PropertyHandler.getPropValue(filepath, route);
		schType = PropertyHandler.getPropValue(filepath, schType);
		fltType = PropertyHandler.getPropValue(filepath, fltType);
		depTime = PropertyHandler.getPropValue(filepath, depTime);
		arrTime = PropertyHandler.getPropValue(filepath, arrTime);
		acType = PropertyHandler.getPropValue(filepath, acType);
		fltCapVol = PropertyHandler.getPropValue(filepath, fltCapVol);
		fltCapWt = PropertyHandler.getPropValue(filepath, fltCapWt);
		OVBWt = PropertyHandler.getPropValue(filepath, OVBWt);
		OVBVol = PropertyHandler.getPropValue(filepath, OVBVol);
		L3 = PropertyHandler.getPropValue(filepath, L3);
		L7 = PropertyHandler.getPropValue(filepath, L7);
		Q6 = PropertyHandler.getPropValue(filepath, Q6);
		Q7 = PropertyHandler.getPropValue(filepath, Q7);
		
		enterKeys(textcarrierCode, carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		//store the flight num to SMOKETestData.properties
		PropertyHandler.setPropValue(filepath, fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, fullfltNum, carrier_code + fltNo);
		PropertyHandler.setPropValue(filepath, sDate, startDt);
		PropertyHandler.setPropValue(filepath, eDate, endDt);


		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, schType);
		selectByText(list_Ftype, fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), depTime);
		enterKeys(text_arrTime, arrTime);
		enterKeys(text_Atype, acType);
		click(button_viewCap);
		
		enterKeys(txt_ovrWt, OVBWt);
		enterKeys(txt_ovrVol, OVBVol);		
		enterKeys(txt_capWt, fltCapWt);
		enterKeys(txt_capVol, fltCapVol);
		enterKeys(txt_L3, L3);
		enterKeys(txt_L7, L7);
		enterKeys(txt_Q6, Q6);
		enterKeys(txt_Q7, Q7);
		
		
		//screen refresh
		click(button_legOk);
		minWait();

		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}

		//switch back to main window
		minWait();
		switchToFirstWindow();

		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		//click(waitForElement(button_diaYes));
		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}

	public FLT005 createMultiLegWithAllCapacityDetails(String carrier_code, String route, String schType,
			String fltType, String depTime, String arrTime, String acType1, String OVBWt1, 
			String OVBVol1, String leg1L3, String leg1L7, String leg1Q6, String leg1Q7, String fltCapVol, String fltCapWt,
			String depTime_leg2, String arrTime_leg2, String acType2, String OVBWt2, 
			String OVBVol2, String leg2L3, String leg2L7, String leg2Q6, String leg2Q7, String fltCapVol2, String fltCapWt2,
			String fltNum, String fullfltNum, String sDate, String eDate) throws InterruptedException, IOException {

		//fetch test data
		carrier_code = PropertyHandler.getPropValue(filepath, carrier_code);
		route = PropertyHandler.getPropValue(filepath, route);
		schType = PropertyHandler.getPropValue(filepath, schType);
		fltType = PropertyHandler.getPropValue(filepath, fltType);
		depTime = PropertyHandler.getPropValue(filepath, depTime);
		arrTime = PropertyHandler.getPropValue(filepath, arrTime);
		acType1 = PropertyHandler.getPropValue(filepath, acType1);
		depTime_leg2 = PropertyHandler.getPropValue(filepath, depTime_leg2);
		arrTime_leg2 = PropertyHandler.getPropValue(filepath, arrTime_leg2);
		acType2 = PropertyHandler.getPropValue(filepath, acType2);
		fltCapVol = PropertyHandler.getPropValue(filepath, fltCapVol);
		fltCapWt = PropertyHandler.getPropValue(filepath, fltCapWt);
		fltCapVol2 = PropertyHandler.getPropValue(filepath, fltCapVol2);
		fltCapWt2 = PropertyHandler.getPropValue(filepath, fltCapWt2);
		OVBWt1 = PropertyHandler.getPropValue(filepath, OVBWt1);
		OVBVol1= PropertyHandler.getPropValue(filepath, OVBVol1);
		leg1L3 = PropertyHandler.getPropValue(filepath, leg1L3);
		leg1L7= PropertyHandler.getPropValue(filepath, leg1L7);
		leg1Q6 = PropertyHandler.getPropValue(filepath, leg1Q6);
		leg1Q7= PropertyHandler.getPropValue(filepath, leg1Q7);
		OVBWt2 = PropertyHandler.getPropValue(filepath, OVBWt2);
		OVBVol2= PropertyHandler.getPropValue(filepath, OVBVol2);
		leg2L3 = PropertyHandler.getPropValue(filepath, leg2L3);
		leg2L7= PropertyHandler.getPropValue(filepath, leg2L7);
		leg2Q6 = PropertyHandler.getPropValue(filepath, leg2Q6);
		leg2Q7= PropertyHandler.getPropValue(filepath, leg2Q7);
		
		enterKeys(textcarrierCode, carrier_code);

		String rand_fltnum;
		//to execute till a non-existing flight num is listed
		while (true) {
			rand_fltnum = BizUtility.createFlightNum();
			enterKeys(FlightNo, rand_fltnum);
			enterKeys(StartDate, ".");
			enterKeys(EndDate, "+7");
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

		minWait();
		String fltNo = waitForElement(FlightNo).getAttribute("value");
		String startDt = waitForElement(StartDate).getAttribute("value");
		String endDt = waitForElement(EndDate).getAttribute("value");
		
		PropertyHandler.setPropValue(filepath, fltNum, fltNo);
		PropertyHandler.setPropValue(filepath, fullfltNum, (carrier_code + fltNo).toString().replaceAll(" ", ""));
		PropertyHandler.setPropValue(filepath, sDate, startDt);
		PropertyHandler.setPropValue(filepath, eDate, endDt);

		click(waitForElement(text_route));
		enterKeys(waitForElement(text_route), route);
		click(check_freq);

		selectByText(list_schType, schType);
		selectByText(list_Ftype, fltType);
		enterKeys(text_effDate, "." + Keys.TAB);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), depTime);
		enterKeys(text_arrTime, arrTime);
		enterKeys(text_Atype, acType1);
		click(button_viewCap);
		
		enterKeys(txt_ovrWt, OVBWt1);
		enterKeys(txt_ovrVol, OVBVol1);		
		enterKeys(txt_capWt, fltCapWt);
		enterKeys(txt_capVol, fltCapVol);
		enterKeys(txt_L3, leg1L3);
		enterKeys(txt_L7, leg1L7);
		enterKeys(txt_Q6, leg1Q6);
		enterKeys(txt_Q7, leg1Q7);
		
		click(button_legOk);
		minWait();
		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		check(leg2);
		click(btn_legCapacity);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();

		enterKeys(waitForElement(text_depTime), depTime_leg2);
		enterKeys(text_arrTime, arrTime_leg2);
		enterKeys(text_Atype, acType2);
		click(button_viewCap);
		
		enterKeys(txt_ovrWt, OVBWt2);
		enterKeys(txt_ovrVol, OVBVol2);		
		enterKeys(txt_capWt, fltCapWt2);
		enterKeys(txt_capVol, fltCapVol2);
		enterKeys(txt_L3, leg2L3);
		enterKeys(txt_L7, leg2L7);
		enterKeys(txt_Q6, leg2Q6);
		enterKeys(txt_Q7, leg2Q7);
		
		click(button_legOk);
		minWait();
		if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();

		click(waitForElement(yesBtn));

		Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
		click(button_diaOk);

		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}
	
	/**
	 * Method to list an existing flight and update the GSC details of its first segment
	 * @param carrier_code
	 * @param fltNo
	 * @param sDate
	 * @param eDate
	 * @param gscWt
	 * @param gscVol
	 * @param gscL3
	 * @param gscL7
	 * @param gscQ6
	 * @param gscQ7
	 * @return
	 * @author A-7868 Krishna <06/07/2018>
	 */
	public FLT005 updateFirstSegmentGSC(String carrier_code, String fltNo, String sDate, String eDate, String gscWt, String gscVol, String gscL3,
										String gscL7, String gscQ6, String gscQ7 ) {
		
		
		carrier_code = PropertyHandler.getPropValue(filepath, carrier_code);
		fltNo = PropertyHandler.getPropValue(filepath, fltNo);
		sDate = PropertyHandler.getPropValue(filepath, sDate);
		eDate = PropertyHandler.getPropValue(filepath, eDate);
		gscWt = PropertyHandler.getPropValue(filepath, gscWt);
		gscVol = PropertyHandler.getPropValue(filepath, gscVol);
		gscL3 = PropertyHandler.getPropValue(filepath, gscL3);
		gscL7 = PropertyHandler.getPropValue(filepath, gscL7);
		gscQ6 = PropertyHandler.getPropValue(filepath, gscQ6);
		gscQ7 = PropertyHandler.getPropValue(filepath, gscQ7);
		
		enterKeys(FlightNo, fltNo);
		enterKeys(StartDate, sDate);
		enterKeys(EndDate, eDate);
		click(button_list);
		minWait();
		
		click(tab_segment);
		check(getWebElements(chkbox_segment).get(0));
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(waitForElement(chkBx_defineGSC));
		enterKeys(defaultCapacity_txt_GSC_Weight, gscWt);
		enterKeys(defaultCapacity_txt_GSC_Volume, gscVol);
		enterKeys(segmentCapacity_txt_GSC_L3, gscL3);
		enterKeys(segmentCapacity_txt_GSC_L7, gscL7);
		enterKeys(segmentCapacity_txt_GSC_Q6, gscQ6);
		enterKeys(segmentCapacity_txt_GSC_Q7, gscQ7);
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		minWait();
		Assert.assertTrue(waitForElement(msg_success).getText().contains("Flight Schedule Saved Successfully."), "ERROR : FLIGHT SAVED SUCCESSFULLY message not displayed");
		waitForFrameAndSwitch(FRAME);
		
		return this;
	}
	
	/**
	 * Method to list an existing flight and update the SCL details of its first segment
	 * @param carrier_code
	 * @param fltNo
	 * @param sDate
	 * @param eDate
	 * @param sclWt
	 * @param sclVol
	 * @param sclL3
	 * @param sclL7
	 * @param sclQ6
	 * @param sclQ7
	 * @return
	 * @author a-7868 Krishna <09/07/2018>
	 */
	public FLT005 updateFirstSegmentSCL(String carrier_code, String fltNo, String sDate, String eDate, String sclWt, String sclVol, String sclL3,
			String sclL7, String sclQ6, String sclQ7 ) {


		carrier_code = PropertyHandler.getPropValue(filepath, carrier_code);
		fltNo = PropertyHandler.getPropValue(filepath, fltNo);
		sDate = PropertyHandler.getPropValue(filepath, sDate);
		eDate = PropertyHandler.getPropValue(filepath, eDate);
		sclWt = PropertyHandler.getPropValue(filepath, sclWt);
		sclVol = PropertyHandler.getPropValue(filepath, sclVol);
		sclL3 = PropertyHandler.getPropValue(filepath, sclL3);
		sclL7 = PropertyHandler.getPropValue(filepath, sclL7);
		sclQ6 = PropertyHandler.getPropValue(filepath, sclQ6);
		sclQ7 = PropertyHandler.getPropValue(filepath, sclQ7);
		
		enterKeys(FlightNo, fltNo);
		enterKeys(StartDate, sDate);
		enterKeys(EndDate, eDate);
		click(button_list);
		minWait();
		
		click(tab_segment);
		check(getWebElements(chkbox_segment).get(0));
		click(btn_segUpdtCapacity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		check(waitForElement(chkBx_defineGSC));
		enterKeys(defaultCapacity_txt_SCL_Weight, sclWt);
		enterKeys(defaultCapacity_txt_SCL_Volume, sclVol);
		enterKeys(segmentCapacity_txt_SCL_L3, sclL3);
		enterKeys(segmentCapacity_txt_SCL_L7, sclL7);
		enterKeys(segmentCapacity_txt_SCL_Q6, sclQ6);
		enterKeys(segmentCapacity_txt_SCL_Q7, sclQ7);
		click(btn_segCapacityOk);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		
		click(waitForElement(button_save));
		driver.switchTo().defaultContent();
		minWait();
		Assert.assertTrue(waitForElement(msg_success).getText().contains("Flight Schedule Saved Successfully."), "ERROR : FLIGHT SAVED SUCCESSFULLY message not displayed");
		waitForFrameAndSwitch(FRAME);
		
		return this;
	}
}


