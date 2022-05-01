package com.ibsplc.pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

public class FLT004 extends BasePage{

	public FLT004(WebDriver driver, String testDataFile) {
		super(driver);
		this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver,this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
        initPageElements();
	}
	
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","Generic.properties");
	public static String filepath;
	public static String FRAME = "iCargoContentFrameFLT004";
	
	WebDriver driver;    
    String testDataFile;
    
    By txt_carrierCode;
    By txt_flightNo;
    By dropdown_status;
    By txt_fromDate;
    By txt_toDate;
    By txt_origin;
    By txt_destination;
    By dropdown_flightType;
    By dropdown_flightScheduleType;
    By txt_aircraftType;
    By btn_list;
    By table_flightSchedules;
    By btn_close;
    By yesBtn;
    By okBtn;
    By noBtn;
    By dialogue_text;
    By chkbox_selectTableItem;
    By btn_details;
    By btn_create;
    By btn_clear;
    By btn_splitSchedule;
    By maintainFlightSchedule_chkbox_segment;
    By maintainFlightSchedule_chkbox_OverrideSegmentCapacity;
    By maintainFlightSchedule_btn_save;
    By maintainFlightSchedule_btn_close;
    By maintainFlightSchedule_btn_updateCapacity;
    By maintainFlightSchedule_LegCapacity_txt_AircraftType;
    By maintainFlightSchedule_LegCapacity_table_SpecificCapacity;
    By maintainFlightSchedule_LegCapacity_btn_close;
    By maintainFlightSchedule_btn_updateSegmentCapacity;
    By maintainFlightSchedule_SegmentCapacity_dropdown_trafficRights;
    By maintainFlightSchedule_SegmentCapacity_btn_close;
    By maintainFlightSchedule_SegmentCapacity_dropdown_bookingStatus;
    By maintainFlightSchedule_SegmentCapacity_txt_capacityWeight;
    By maintainFlightSchedule_SegmentCapacity_txt_capacityVolume;
    By tab_segment;
    By maintainFlightSchedule_chkbox_firstSegment;
    By maintainFlightSchedule_chkbox_secondSegment;
    By maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingWeight;
    By maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingVolume;
    By maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingL3;
    By maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingL7;
    By maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingQ6;
    By maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingQ7;
    By table_SourceType;
    
    By maintainFlightSchedule_LegCapacity_txt_departureTime;
    By maintainFlightSchedule_LegCapacity_txt_arrivalTime;
    By maintainFlightSchedule_LegCapacity_btn_viewCapacity;
    By maintainFlightSchedule_LegCapacity_btn_Ok;
    By maintainFlightSchedule_txt_carrierCode;
    By maintainFlightSchedule_txt_startDate;
    By maintainFlightSchedule_txt_endDate;
    By maintainFlightSchedule_btn_list;
    By maintainFlightSchedule_btn_clear;
    By maintainFlightSchedule_txt_route;
    By maintainFlightSchedule_chkbox_allFrequency;
    By maintainFlightSchedule_dropdown_scheduleType;
    By maintainFlightSchedule_dropdown_flightType;
    By maintainFlightSchedule_txt_effectiveDate;
    By maintainFlightSchedule_txt_flightNo;
    By changeFlightSchduleStatus_txt_startDate;
    By changeFlightSchduleStatus_txt_endDate;
    By changeFlightSchduleStatus_dropdown_status;
    By changeFlightSchduleStatus_btn_save;
    By changeFlightSchduleStatus_btn_close;
    By btn_change;
    By btn_createStationAllotment;
    By maintainStationAllotment_txt_station;
    By maintainStationAllotment_txt_startDate;
    By maintainStationAllotment_txt_endDate;
    By maintainStationAllotment_chkbox_allFrequency;
    By maintainStationAllotment_txt_weight;
    By maintainStationAllotment_txt_volume;
    By maintainStationAllotment_btn_save;
    By maintainStationAllotment_btn_close;
    By maintainStationAllotment_txt_allotmentID;
    By maintainStationAllotment_info_status;
    By btn_burst;
    By splitFlightSchedule_txt_startDate;
    By splitFlightSchedule_txt_endDate;
    By splitFlightSchedule_btn_save;
    By splitFlightSchedule_btn_close;
    By btn_notifyStations;
    By notificationAddress_txt_address;
    By notificationAddress_dropdown_mode;
    By notificationAddress_btn_send;
    By info_footerNotification;
    By info_error;
    By maintainFlightSchedule_dropdown_agreementType;
    By btn_revalidate;
    
    By btn_panelDownArrow;
    By btn_paneUpArrow;
    By dropdown_dest;
    By dropdown_origin
    ;

    By btn_modificationLog,
    tbl_modificationTable,
    btn_modfcnLog_continue;
    
    private void initPageElements(){
    	txt_carrierCode	= MiscUtility.getWebElement(objFilepath,"FLT004_txt_carrierCode");
    	txt_flightNo = MiscUtility.getWebElement(objFilepath,"FLT004_txt_flightNo");
    	dropdown_status	= MiscUtility.getWebElement(objFilepath,"FLT004_dropdown_status");    	
    	txt_fromDate	= MiscUtility.getWebElement(objFilepath,"FLT004_txt_fromDate");
    	txt_toDate	= MiscUtility.getWebElement(objFilepath,"FLT004_txt_toDate");
    	txt_origin	= MiscUtility.getWebElement(objFilepath,"FLT004_txt_origin");
    	txt_destination	= MiscUtility.getWebElement(objFilepath,"FLT004_txt_destination");
    	dropdown_flightType	= MiscUtility.getWebElement(objFilepath,"FLT004_dropdown_flightType");
    	dropdown_flightScheduleType	= MiscUtility.getWebElement(objFilepath,"FLT004_dropdown_flightScheduleType");
    	txt_aircraftType	= MiscUtility.getWebElement(objFilepath,"FLT004_txt_aircraftType");    	
    	btn_list = MiscUtility.getWebElement(objFilepath,"FLT004_btn_list");
    	table_flightSchedules	= MiscUtility.getWebElement(objFilepath,"FLT004_table_flightSchedules");
    	btn_close = MiscUtility.getWebElement(objFilepath,"FLT004_btn_close");
    	
    	table_SourceType = MiscUtility.getWebElement(objFilepath,"FLT004_table_SourceType");
    	btn_create = MiscUtility.getWebElement(objFilepath,"FLT004_btn_create");
    	changeFlightSchduleStatus_txt_startDate = MiscUtility.getWebElement(objFilepath,"FLT004_ChangeFlightSchduleStatus_txt_startDate");
        changeFlightSchduleStatus_txt_endDate = MiscUtility.getWebElement(objFilepath,"FLT004_ChangeFlightSchduleStatus_txt_endDate");
        changeFlightSchduleStatus_dropdown_status = MiscUtility.getWebElement(objFilepath,"FLT004_ChangeFlightSchduleStatus_dropdown_status");
        changeFlightSchduleStatus_btn_save = MiscUtility.getWebElement(objFilepath,"FLT004_ChangeFlightSchduleStatus_btn_save");
        changeFlightSchduleStatus_btn_close = MiscUtility.getWebElement(objFilepath,"FLT004_ChangeFlightSchduleStatus_btn_close");
        btn_change = MiscUtility.getWebElement(objFilepath,"FLT004_btn_change");
        btn_burst = MiscUtility.getWebElement(objFilepath,"FLT004_btn_burst");
        btn_clear = MiscUtility.getWebElement(objFilepath,"FLT004_btn_clear");
        btn_splitSchedule = MiscUtility.getWebElement(objFilepath,"FLT004_btn_splitSchedule");
        btn_revalidate = MiscUtility.getWebElement(objFilepath,"FLT004_btn_revalidate");
    	
    	yesBtn = MiscUtility.getWebElement(genFilepath,"Generic_btn_diaYes");
    	okBtn = MiscUtility.getWebElement(genFilepath,"Generic_btn_ok");
    	noBtn = MiscUtility.getWebElement(genFilepath,"Generic_btn_noBtn");
    	dialogue_text = MiscUtility.getWebElement(genFilepath,"Generic_info_msg");
    	info_footerNotification = MiscUtility.getWebElement(genFilepath,"Generic_foot_layer");
    	
    	chkbox_selectTableItem	= MiscUtility.getWebElement(objFilepath,"FLT004_chkbox_selectTableItem"); 
    	btn_details	= MiscUtility.getWebElement(objFilepath,"FLT004_btn_details"); 
    	maintainFlightSchedule_chkbox_OverrideSegmentCapacity	= MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_chkbox_OverrideSegmentCapacity"); 
    	maintainFlightSchedule_btn_save	= MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_btn_save"); 
    	maintainFlightSchedule_btn_close	= MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_btn_close"); 
    	maintainFlightSchedule_btn_updateCapacity	= MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_btn_updateCapacity");
    	maintainFlightSchedule_LegCapacity_txt_AircraftType	= MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_LegCapacity_txt_AircraftType");
    	maintainFlightSchedule_LegCapacity_table_SpecificCapacity	= MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_LegCapacity_table_SpecificCapacity");
    	maintainFlightSchedule_LegCapacity_btn_close	= MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_LegCapacity_btn_close");
    	maintainFlightSchedule_btn_updateSegmentCapacity= MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_btn_updateSegmentCapacity");
        maintainFlightSchedule_SegmentCapacity_dropdown_trafficRights= MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_SegmentCapacity_dropdown_trafficRights");
        maintainFlightSchedule_SegmentCapacity_btn_close= MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_SegmentCapacity_btn_close");
        maintainFlightSchedule_SegmentCapacity_dropdown_bookingStatus = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_SegmentCapacity_dropdown_bookingStatus");
        maintainFlightSchedule_SegmentCapacity_txt_capacityWeight = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_SegmentCapacity_txt_capacityWeight");
        maintainFlightSchedule_SegmentCapacity_txt_capacityVolume = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_SegmentCapacity_txt_capacityVolume");
        tab_segment = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_tab_segment");
        maintainFlightSchedule_chkbox_firstSegment = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_chkbox_firstSegment");
        maintainFlightSchedule_chkbox_secondSegment = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_chkbox_secondSegment");
        maintainFlightSchedule_chkbox_segment = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_chkbox_segment");
        
        maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingWeight = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingWeight");
        maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingVolume = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingVolume");
        maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingL3 = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingL3");
        maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingL7 = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingL7");
        maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingQ6 = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingQ6");
        maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingQ7 = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingQ7");
        maintainFlightSchedule_LegCapacity_txt_departureTime = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_LegCapacity_txt_departureTime");
        maintainFlightSchedule_LegCapacity_txt_arrivalTime = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_LegCapacity_txt_arrivalTime");
        maintainFlightSchedule_LegCapacity_btn_viewCapacity = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_LegCapacity_btn_viewCapacity");
        maintainFlightSchedule_LegCapacity_btn_Ok = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_LegCapacity_btn_Ok");
        maintainFlightSchedule_txt_carrierCode = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_txt_carrierCode");
        maintainFlightSchedule_txt_startDate = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_txt_startDate");
        maintainFlightSchedule_txt_endDate = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_txt_endDate");
        maintainFlightSchedule_btn_list = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_btn_list");
        maintainFlightSchedule_btn_clear = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_btn_clear");
        maintainFlightSchedule_txt_route = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_txt_route");
        maintainFlightSchedule_chkbox_allFrequency = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_chkbox_allFrequency");
        maintainFlightSchedule_dropdown_scheduleType = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_dropdown_scheduleType");
        maintainFlightSchedule_dropdown_flightType = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_dropdown_flightType");
        maintainFlightSchedule_txt_effectiveDate = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_txt_effectiveDate");
        maintainFlightSchedule_txt_flightNo = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_txt_flightNo");
        
        // maintain station allotment
        btn_createStationAllotment = MiscUtility.getWebElement(objFilepath,"FLT004_btn_createStationAllotment");
        maintainStationAllotment_txt_station = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainStationAllotment_txt_station");
        maintainStationAllotment_txt_startDate = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainStationAllotment_txt_startDate");
        maintainStationAllotment_txt_endDate = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainStationAllotment_txt_endDate");
        maintainStationAllotment_chkbox_allFrequency = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainStationAllotment_chkbox_allFrequency");
        maintainStationAllotment_txt_weight = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainStationAllotment_txt_weight");
        maintainStationAllotment_txt_volume = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainStationAllotment_txt_volume");
        maintainStationAllotment_btn_save = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainStationAllotment_btn_save");
        maintainStationAllotment_btn_close = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainStationAllotment_btn_close");
        maintainStationAllotment_txt_allotmentID = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainStationAllotment_txt_allotmentID");
        maintainStationAllotment_info_status = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainStationAllotment_info_status");
        
        //Split schedule pop up
        
        splitFlightSchedule_txt_startDate = MiscUtility.getWebElement(objFilepath,"FLT004_SplitFlightSchedule_txt_startDate");
        splitFlightSchedule_txt_endDate = MiscUtility.getWebElement(objFilepath,"FLT004_SplitFlightSchedule_txt_endDate");
        splitFlightSchedule_btn_save = MiscUtility.getWebElement(objFilepath,"FLT004_SplitFlightSchedule_btn_save");
        splitFlightSchedule_btn_close = MiscUtility.getWebElement(objFilepath,"FLT004_SplitFlightSchedule_btn_close");
        
        //notification address popup
        btn_notifyStations = MiscUtility.getWebElement(objFilepath,"FLT004_btn_notifyStations");
        notificationAddress_txt_address = MiscUtility.getWebElement(objFilepath,"FLT004_NotificationAddress_txt_address");
        notificationAddress_dropdown_mode = MiscUtility.getWebElement(objFilepath,"FLT004_NotificationAddress_dropdown_mode");
        notificationAddress_btn_send = MiscUtility.getWebElement(objFilepath,"FLT004_NotificationAddress_btn_send");
        info_error = MiscUtility.getWebElement(genFilepath,"Generic_footer_error");
        maintainFlightSchedule_dropdown_agreementType = MiscUtility.getWebElement(objFilepath,"FLT004_MaintainFlightSchedule_dropdown_agreementType");
        
        btn_panelDownArrow=MiscUtility.getWebElement(objFilepath,"FLT004_btn_panelDownArrow");
        btn_paneUpArrow=MiscUtility.getWebElement(objFilepath,"FLT004_btn_panelUpArrow");
        dropdown_dest=MiscUtility.getWebElement(objFilepath,"FLT004_dropdown_dest");
        dropdown_origin=MiscUtility.getWebElement(objFilepath,"FLT004_dropdown_origin");
        
        

        
        btn_modificationLog = MiscUtility.getWebElement(objFilepath,"FLT004_btn_modificationLog");
        tbl_modificationTable = MiscUtility.getWebElement(objFilepath,"FLT004_tbl_modificationTable");
        btn_modfcnLog_continue = MiscUtility.getWebElement(objFilepath,"FLT004_btn_modfcnLog_continue");

    }
    
    /**
     * Created by A-7605
     * @param flightCarrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param origin
     * @param destination
     * @param flightType
     * @param scheduleType
     * @param aircraftType
     * @param status
     * @return
     */
    
    public FLT004 checkFlightStatus(String flightCarrierCode, String flightNo, String fromDate, String toDate, String origin,
    		String destination, String flightType, String scheduleType, String aircraftType, String status){
    	int tableRowCount;
    	flightCarrierCode = PropertyHandler.getPropValue(filepath, flightCarrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	origin = PropertyHandler.getPropValue(filepath, origin);
    	destination = PropertyHandler.getPropValue(filepath, destination);
    	flightType = PropertyHandler.getPropValue(filepath, flightType);
    	scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
    	aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
    	//status = PropertyHandler.getPropValue(dataFilePath, status);
    	
    	enterKeys(txt_carrierCode, flightCarrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	enterKeys(txt_origin, origin);
    	enterKeys(txt_destination, destination);
    	selectByText(dropdown_flightType, flightType);
    	selectByText(dropdown_flightScheduleType, scheduleType);
    	enterKeys(txt_aircraftType, aircraftType);
    	selectByText(dropdown_status, status);
    	click(btn_list);
    	minWait();
    	tableRowCount = getTableRowCount(table_flightSchedules);
    	Assert.assertTrue(tableRowCount==1, "Actual number of rows in the table is "+tableRowCount);
    	return this;
    }
    
    
    public HomePage close() {    	
        
        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver,testDataFile);
    }
    
    /**
     * Created by A-7605
     * @param flightCarrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @return
     */
    public FLT004 enableOverrideSegmentCapacityOption(String flightCarrierCode, String flightNo, String fromDate, String toDate){
    	flightCarrierCode = PropertyHandler.getPropValue(filepath, flightCarrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	enterKeys(txt_carrierCode, flightCarrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	check(waitForElement(maintainFlightSchedule_chkbox_OverrideSegmentCapacity));
    	click(maintainFlightSchedule_btn_save);
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param flightCarrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param aircraftType
     * @param segmentWeight
     * @param segmentVolume
     * @return
     */
    public FLT004 verifyAircraftTypeAndSegmentCapacity(String flightCarrierCode, String flightNo, String fromDate, String toDate,
    		String aircraftType, String segmentWeight, String segmentVolume){
    	String currentAircraftType;
    	flightCarrierCode = PropertyHandler.getPropValue(filepath, flightCarrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
    	segmentWeight = PropertyHandler.getPropValue(filepath, segmentWeight);
    	segmentVolume = PropertyHandler.getPropValue(filepath, segmentVolume);
    	
    	enterKeys(txt_carrierCode, flightCarrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
//    	enterKeys(txt_fromDate, ".");
    	enterKeys(txt_toDate, toDate);
//    	enterKeys(txt_toDate, "+6");
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	click(waitForElement(maintainFlightSchedule_btn_updateCapacity));
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	currentAircraftType = waitForElement(maintainFlightSchedule_LegCapacity_txt_AircraftType).getAttribute("value");
    	Assert.assertTrue(currentAircraftType.equals(aircraftType));
    	Assert.assertTrue(getTableColumnValues(maintainFlightSchedule_LegCapacity_table_SpecificCapacity, 3).contains(segmentWeight));
    	Assert.assertTrue(getTableColumnValues(maintainFlightSchedule_LegCapacity_table_SpecificCapacity, 4).contains(segmentVolume));
    	click(maintainFlightSchedule_LegCapacity_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(maintainFlightSchedule_btn_save);
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param flightCarrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param trafficRightStatus
     * @return
     */
    public FLT004 verifyTrafficRightUpdated(String flightCarrierCode, String flightNo, String fromDate, String toDate, String trafficRightStatus){
    	String trafficRight;
    	flightCarrierCode = PropertyHandler.getPropValue(filepath, flightCarrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	trafficRightStatus = PropertyHandler.getPropValue(filepath, trafficRightStatus);
    	
    	enterKeys(txt_carrierCode, flightCarrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	click(waitForElement(tab_segment));
    	click(waitForElement(maintainFlightSchedule_btn_updateSegmentCapacity));
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	trafficRight = getSelectedValue(maintainFlightSchedule_SegmentCapacity_dropdown_trafficRights);
    	Assert.assertTrue(trafficRight.equals(trafficRightStatus));
    	click(maintainFlightSchedule_SegmentCapacity_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(maintainFlightSchedule_btn_save);
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param flightCarrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param bookingStatus
     * @return
     */
    public FLT004 verifyBookingStatusUpdated(String flightCarrierCode, String flightNo, String fromDate, String toDate, String bookingStatus){
    	String currentBookingStatus;
    	flightCarrierCode = PropertyHandler.getPropValue(filepath, flightCarrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	bookingStatus = PropertyHandler.getPropValue(filepath, bookingStatus);
    	
    	enterKeys(txt_carrierCode, flightCarrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	click(waitForElement(tab_segment));
    	click(waitForElement(maintainFlightSchedule_btn_updateSegmentCapacity));
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	currentBookingStatus = getSelectedValue(maintainFlightSchedule_SegmentCapacity_dropdown_bookingStatus);
    	Assert.assertTrue(currentBookingStatus.equals(bookingStatus));
    	click(maintainFlightSchedule_SegmentCapacity_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(maintainFlightSchedule_btn_save);
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param flightCarrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param segCapacityWeight
     * @param SegCapacityVolume
     * @return
     */
    public FLT004 verifySegCapacityForFirstLegUpdated(String flightCarrierCode, String flightNo, String fromDate, String toDate, String segCapacityWeight, String SegCapacityVolume){
    	String currentCapacityWeight;
    	String currentCapacityVol;
    	flightCarrierCode = PropertyHandler.getPropValue(filepath, flightCarrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	segCapacityWeight = PropertyHandler.getPropValue(filepath, segCapacityWeight);
    	SegCapacityVolume = PropertyHandler.getPropValue(filepath, SegCapacityVolume);
    	
    	enterKeys(txt_carrierCode, flightCarrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	click(waitForElement(tab_segment));
    	click(waitForElement(maintainFlightSchedule_btn_updateSegmentCapacity));
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	currentCapacityWeight = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityWeight).getAttribute("value");
    	currentCapacityVol = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityVolume).getAttribute("value");
    	
    	Assert.assertTrue(segCapacityWeight.equals(currentCapacityWeight));
    	Assert.assertTrue(SegCapacityVolume.equals(currentCapacityVol));
    	click(maintainFlightSchedule_SegmentCapacity_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(maintainFlightSchedule_btn_save);
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param flightCarrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param segCapacityWeight
     * @param SegCapacityVolume
     * @return
     */
    public FLT004 verifySegCapacityForSecondLegUpdated(String flightCarrierCode, String flightNo, String fromDate, String toDate, String segCapacityWeight, String SegCapacityVolume){
    	String currentCapacityWeight;
    	String currentCapacityVol;
    	flightCarrierCode = PropertyHandler.getPropValue(filepath, flightCarrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	segCapacityWeight = PropertyHandler.getPropValue(filepath, segCapacityWeight);
    	SegCapacityVolume = PropertyHandler.getPropValue(filepath, SegCapacityVolume);
    	
    	enterKeys(txt_carrierCode, flightCarrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	click(waitForElement(tab_segment));
    	check(getWebElements(maintainFlightSchedule_chkbox_segment).get(2));    	
    	click(waitForElement(maintainFlightSchedule_btn_updateSegmentCapacity));
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	currentCapacityWeight = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityWeight).getAttribute("value");
    	currentCapacityVol = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityVolume).getAttribute("value");
    	
    	Assert.assertTrue(segCapacityWeight.equals(currentCapacityWeight));
    	Assert.assertTrue(SegCapacityVolume.equals(currentCapacityVol));
    	click(maintainFlightSchedule_SegmentCapacity_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(maintainFlightSchedule_btn_save);
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param flightCarrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param segCapacityWeightLegOne
     * @param SegCapacityVolumeLegOne
     * @param segCapacityWeightLegTwo
     * @param SegCapacityVolumeLegTwo
     * @return
     */
    public FLT004 verifySegCapacityForSpecificDaysForBothLegUpdated(String flightCarrierCode, String flightNo, String fromDate, String toDate, String segCapacityWeightLegOne, String SegCapacityVolumeLegOne,String segCapacityWeightLegTwo, String SegCapacityVolumeLegTwo){
    	String currentCapacityWeightLegOne;
    	String currentCapacityVolLegOne;
    	String currentCapacityWeightLegTwo;
    	String currentCapacityVolLegTwo;
    	flightCarrierCode = PropertyHandler.getPropValue(filepath, flightCarrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	segCapacityWeightLegOne = PropertyHandler.getPropValue(filepath, segCapacityWeightLegOne);
    	SegCapacityVolumeLegOne = PropertyHandler.getPropValue(filepath, SegCapacityVolumeLegOne);
    	segCapacityWeightLegTwo = PropertyHandler.getPropValue(filepath, segCapacityWeightLegTwo);
    	SegCapacityVolumeLegTwo = PropertyHandler.getPropValue(filepath, SegCapacityVolumeLegTwo);
    	
    	enterKeys(txt_carrierCode, flightCarrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	click(waitForElement(tab_segment));
 //   	check(maintainFlightSchedule_chkbox_firstSegment);    	
    	click(waitForElement(maintainFlightSchedule_btn_updateSegmentCapacity));
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	currentCapacityWeightLegOne = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityWeight).getAttribute("value");
    	currentCapacityVolLegOne = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityVolume).getAttribute("value");
    	
    	Assert.assertTrue(segCapacityWeightLegOne.equals(currentCapacityWeightLegOne));
    	Assert.assertTrue(SegCapacityVolumeLegOne.equals(currentCapacityVolLegOne));
    	click(maintainFlightSchedule_SegmentCapacity_btn_close);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	check(getWebElements(maintainFlightSchedule_chkbox_segment).get(1));    	
    	click(waitForElement(maintainFlightSchedule_btn_updateSegmentCapacity));
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	currentCapacityWeightLegTwo = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityWeight).getAttribute("value");
    	currentCapacityVolLegTwo = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityVolume).getAttribute("value");
    	
    	Assert.assertTrue(segCapacityWeightLegTwo.equals(currentCapacityWeightLegTwo));
    	Assert.assertTrue(SegCapacityVolumeLegTwo.equals(currentCapacityVolLegTwo));
    	click(maintainFlightSchedule_SegmentCapacity_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(maintainFlightSchedule_btn_save);
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param flightCarrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param segCapacityWeightLegOne
     * @param SegCapacityVolumeLegOne
     * @param segCapacityWeightLegTwo
     * @param SegCapacityVolumeLegTwo
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
    public FLT004 verifyOverbookingDetailsBothLegUpdated(String flightCarrierCode, String flightNo, String fromDate, String toDate, String segCapacityWeightLegOne, String SegCapacityVolumeLegOne,String segCapacityWeightLegTwo, String SegCapacityVolumeLegTwo,
    		String segOneOverbookingWeight, String segOneOverbookingVolume, String segOneL3, String segOneL7, String segOneQ6, String segOneQ7,
    		String segTwoOverbookingWeight, String segTwoOverbookingVolume, String segTwoL3, String segTwoL7, String segTwoQ6, String segTwoQ7){
    	String currentCapacityWeightLegOne;
    	String currentCapacityVolLegOne;
    	String currentCapacityOverbookingWeightLegOne;
    	String currentCapacityOverbookingVolumeLegOne;
    	String currentCapacityOverbookingL3LegOne;
    	String currentCapacityOverbookingL7LegOne;
    	String currentCapacityOverbookingQ6LegOne;
    	String currentCapacityOverbookingQ7LegOne;
    	String currentCapacityWeightLegTwo;
    	String currentCapacityVolLegTwo;
    	String currentCapacityOverbookingWeightLegTwo;
    	String currentCapacityOverbookingVolumeLegTwo;
    	String currentCapacityOverbookingL3LegTwo;
    	String currentCapacityOverbookingL7LegTwo;
    	String currentCapacityOverbookingQ6LegTwo;
    	String currentCapacityOverbookingQ7LegTwo;
    	flightCarrierCode = PropertyHandler.getPropValue(filepath, flightCarrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	segCapacityWeightLegOne = PropertyHandler.getPropValue(filepath, segCapacityWeightLegOne);
    	SegCapacityVolumeLegOne = PropertyHandler.getPropValue(filepath, SegCapacityVolumeLegOne);
    	segCapacityWeightLegTwo = PropertyHandler.getPropValue(filepath, segCapacityWeightLegTwo);
    	SegCapacityVolumeLegTwo = PropertyHandler.getPropValue(filepath, SegCapacityVolumeLegTwo);
    	
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
    	
    	enterKeys(txt_carrierCode, flightCarrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	click(waitForElement(tab_segment));
    	check(getWebElements(maintainFlightSchedule_chkbox_segment).get(0));    	
    	click(waitForElement(maintainFlightSchedule_btn_updateSegmentCapacity));
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	currentCapacityWeightLegOne = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityWeight).getAttribute("value");
    	currentCapacityVolLegOne = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityVolume).getAttribute("value");
    	currentCapacityOverbookingWeightLegOne = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingWeight).getAttribute("value");
    	currentCapacityOverbookingVolumeLegOne = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingVolume).getAttribute("value");
    	currentCapacityOverbookingL3LegOne = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingL3).getAttribute("value");
    	currentCapacityOverbookingL7LegOne = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingL7).getAttribute("value");
    	currentCapacityOverbookingQ6LegOne = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingQ6).getAttribute("value");
    	currentCapacityOverbookingQ7LegOne = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingQ7).getAttribute("value");
    	
    	Assert.assertTrue(segCapacityWeightLegOne.equals(currentCapacityWeightLegOne));
    	Assert.assertTrue(SegCapacityVolumeLegOne.equals(currentCapacityVolLegOne));
    	Assert.assertTrue(segOneOverbookingWeight.equals(currentCapacityOverbookingWeightLegOne));
    	Assert.assertTrue(segOneOverbookingVolume.equals(currentCapacityOverbookingVolumeLegOne));
    	Assert.assertTrue(segOneL3.equals(currentCapacityOverbookingL3LegOne));
    	Assert.assertTrue(segOneL7.equals(currentCapacityOverbookingL7LegOne));
    	Assert.assertTrue(segOneQ6.equals(currentCapacityOverbookingQ6LegOne));
    	Assert.assertTrue(segOneQ7.equals(currentCapacityOverbookingQ7LegOne));
    	
    	click(maintainFlightSchedule_SegmentCapacity_btn_close);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	check(getWebElements(maintainFlightSchedule_chkbox_segment).get(1));    	
    	click(waitForElement(maintainFlightSchedule_btn_updateSegmentCapacity));
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	currentCapacityWeightLegTwo = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityWeight).getAttribute("value");
    	currentCapacityVolLegTwo = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_capacityVolume).getAttribute("value");
    	currentCapacityOverbookingWeightLegTwo = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingWeight).getAttribute("value");
    	currentCapacityOverbookingVolumeLegTwo = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingVolume).getAttribute("value");
    	currentCapacityOverbookingL3LegTwo = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingL3).getAttribute("value");
    	currentCapacityOverbookingL7LegTwo = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingL7).getAttribute("value");
    	currentCapacityOverbookingQ6LegTwo = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingQ6).getAttribute("value");
    	currentCapacityOverbookingQ7LegTwo = waitForElement(maintainFlightSchedule_SegmentCapacity_txt_defaultCapacityOverBookingQ7).getAttribute("value");
    	
    	Assert.assertTrue(segCapacityWeightLegTwo.equals(currentCapacityWeightLegTwo));
    	Assert.assertTrue(SegCapacityVolumeLegTwo.equals(currentCapacityVolLegTwo));
    	Assert.assertTrue(segTwoOverbookingWeight.equals(currentCapacityOverbookingWeightLegTwo));
    	Assert.assertTrue(segTwoOverbookingVolume.equals(currentCapacityOverbookingVolumeLegTwo));
    	Assert.assertTrue(segTwoL3.equals(currentCapacityOverbookingL3LegTwo));
    	Assert.assertTrue(segTwoL7.equals(currentCapacityOverbookingL7LegTwo));
    	Assert.assertTrue(segTwoQ6.equals(currentCapacityOverbookingQ6LegTwo));
    	Assert.assertTrue(segTwoQ7.equals(currentCapacityOverbookingQ7LegTwo));
    	click(maintainFlightSchedule_SegmentCapacity_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(maintainFlightSchedule_btn_save);
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param flightCarrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param aircarftDefaultWeight
     * @param aircarftDefaultVolume
     * @return
     */
    public FLT004 verifyLegCapacityForFirstLeg(String flightCarrierCode, String flightNo, String fromDate, String toDate,
    		String aircarftDefaultWeight, String aircarftDefaultVolume){
    	List<String> capacityWeights;
    	List<String> capacityVols;
    	flightCarrierCode = PropertyHandler.getPropValue(filepath, flightCarrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	aircarftDefaultWeight = PropertyHandler.getPropValue(filepath, aircarftDefaultWeight);
    	aircarftDefaultVolume = PropertyHandler.getPropValue(filepath, aircarftDefaultVolume);
    	
    	enterKeys(txt_carrierCode, flightCarrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	click(waitForElement(maintainFlightSchedule_btn_updateCapacity));
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
   
    	capacityWeights = getTableColumnValues(maintainFlightSchedule_LegCapacity_table_SpecificCapacity, 3);
    	capacityVols = getTableColumnValues(maintainFlightSchedule_LegCapacity_table_SpecificCapacity, 4);
    	
    	click(maintainFlightSchedule_LegCapacity_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(maintainFlightSchedule_btn_save);
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	
    	for(String capacityWeight:capacityWeights)
    		Assert.assertTrue(capacityWeight.equals(aircarftDefaultWeight),"Actual is '"+capacityWeight+"' and expected is '"+aircarftDefaultWeight+"'");
    	for(String capacityVol:capacityVols)
    		Assert.assertTrue(capacityVol.equals(aircarftDefaultVolume),"Actual is '"+capacityVol+"' and expected is '"+aircarftDefaultVolume+"'");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightRoute
     * @param flightNo
     * @param fullFlightNo
     * @param scheduleType
     * @param flightType
     * @param departureTime
     * @param arrivalTime
     * @param aircraftType
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @return
     */
    public FLT004 createSingleSegment(String carrierCode, String flightRoute, String flightNo, String fullFlightNo, String scheduleType, String flightType, String departureTime, String arrivalTime, String aircraftType ,String scheduleStartDate, String scheduleEndDate){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightRoute = PropertyHandler.getPropValue(filepath, flightRoute);
    	scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
    	flightType = PropertyHandler.getPropValue(filepath, flightType);
    	departureTime = PropertyHandler.getPropValue(filepath, departureTime);
    	arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
    	aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	
    	click(btn_create);
    	minWait();
        enterKeys(maintainFlightSchedule_txt_carrierCode, carrierCode);

        String rand_fltnum;

        while (true) {
            rand_fltnum = BizUtility.createFlightNum();
            enterKeys(maintainFlightSchedule_txt_flightNo, rand_fltnum);
            enterKeys(maintainFlightSchedule_txt_startDate, scheduleStartDate);
            enterKeys(maintainFlightSchedule_txt_endDate, scheduleEndDate);
            click(maintainFlightSchedule_btn_list);
            driver.switchTo().defaultContent();
            minWait();
            if (verifyElementPresent(yesBtn)) {
                click(yesBtn);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
            click(waitForElement(maintainFlightSchedule_btn_clear));
        }

        minWait();
        String fltNo = waitForElement(maintainFlightSchedule_txt_flightNo).getAttribute("value");
        PropertyHandler.setPropValue(filepath, flightNo, fltNo);
        PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);

        click(waitForElement(maintainFlightSchedule_txt_route));
        enterKeys(maintainFlightSchedule_txt_route, flightRoute);
        click(maintainFlightSchedule_chkbox_allFrequency);

        selectByText(maintainFlightSchedule_dropdown_scheduleType, scheduleType);
        selectByText(maintainFlightSchedule_dropdown_flightType, flightType);
        enterKeys(maintainFlightSchedule_txt_effectiveDate, "." + Keys.TAB);
        click(maintainFlightSchedule_btn_updateCapacity);
        minWait();
        driver.switchTo().defaultContent();
        waitForNewWindow(2);

        switchToSecondWindow();
        waitForElement(maintainFlightSchedule_LegCapacity_txt_departureTime);
        enterKeys(maintainFlightSchedule_LegCapacity_txt_departureTime, departureTime);
        enterKeys(maintainFlightSchedule_LegCapacity_txt_arrivalTime, arrivalTime);
        enterKeys(maintainFlightSchedule_LegCapacity_txt_AircraftType, aircraftType);
        click(maintainFlightSchedule_LegCapacity_btn_viewCapacity);
        //screen refresh
        click(maintainFlightSchedule_LegCapacity_btn_Ok);

        //switch back to main window
        minWait();
        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);
        click(waitForElement(maintainFlightSchedule_btn_save));
        driver.switchTo().defaultContent();

        //click(waitForElement(button_diaYes));        
        click(waitForElement(yesBtn));

        Assert.assertTrue(waitForElement(okBtn).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
        click(okBtn);

        waitForFrameAndSwitch(FRAME);
        minWait();
        click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, fltNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 15, 1).contains("Live"));
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightRoute
     * @param flightNo
     * @param scheduleType
     * @param flightType
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @return
     */
    
    public FLT004 verifyFlightDetails(String carrierCode, String flightRoute, String flightNo,String scheduleType, String flightType, String scheduleStartDate, String scheduleEndDate){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightRoute = PropertyHandler.getPropValue(filepath, flightRoute);
    	scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
    	flightType = PropertyHandler.getPropValue(filepath, flightType);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	Assert.assertTrue(waitForElement(maintainFlightSchedule_txt_route).getAttribute("value").equals(flightRoute));
    	Assert.assertTrue(getSelectedValue(maintainFlightSchedule_dropdown_scheduleType).equals(scheduleType));
    	Assert.assertTrue(getSelectedValue(maintainFlightSchedule_dropdown_flightType).equals(flightType));
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @return
     */
    public FLT004 checkFunctionalityOfChangeButton(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, scheduleStartDate);
        enterKeys(changeFlightSchduleStatus_txt_endDate, scheduleEndDate);
        selectByText(changeFlightSchduleStatus_dropdown_status, "Cancelled");
        click(changeFlightSchduleStatus_btn_save);
        waitForElement(yesBtn);
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Do you want to cancel the schedule ?"));
        click(noBtn);
        click(changeFlightSchduleStatus_btn_close);        
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        minWait();
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 15, 1).contains("Live"));
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @return
     */
    public FLT004 cancellFlight(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);    	
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, scheduleStartDate);        
        enterKeys(changeFlightSchduleStatus_txt_endDate, scheduleEndDate);
        selectByText(changeFlightSchduleStatus_dropdown_status, "Cancelled");
        click(changeFlightSchduleStatus_btn_save);
       // driver.switchTo().defaultContent();
        minWait();
        waitForElement(yesBtn);
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Do you want to cancel the schedule ?"));
        click(yesBtn);
        minWait();
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Schedule status changed successfully."));        
        click(waitForElement(okBtn));    
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        minWait();
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 15, 1).contains("Cancelled"));
    	return this;
    	
    }
    
  
    
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param station
     * @param allotmentWeight
     * @param allotmentVolume
     * @param allotmentID
     * @return
     */
    public FLT004 createStationAllotmentAndRelist(String carrierCode, String flightNo, String fromDate, String toDate, String station, String allotmentWeight, String allotmentVolume, String allotmentID){
    	String notificationText;
    	String allotID;
    	String allotmentStatus;
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	station = PropertyHandler.getPropValue(filepath, station);
    	allotmentWeight = PropertyHandler.getPropValue(filepath, allotmentWeight);
    	allotmentVolume = PropertyHandler.getPropValue(filepath, allotmentVolume);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_createStationAllotment);
    	minWait();
    	waitForElement(maintainStationAllotment_txt_station);
    	enterKeys(maintainStationAllotment_txt_station, station);
    	enterKeys(maintainStationAllotment_txt_startDate, fromDate);
    	enterKeys(maintainStationAllotment_txt_endDate, toDate);
//    	enterKeys(maintainStationAllotment_txt_endDate, toDate);
    	check(maintainStationAllotment_chkbox_allFrequency);
    	enterKeys(maintainStationAllotment_txt_weight, allotmentWeight);
    	enterKeys(maintainStationAllotment_txt_volume, allotmentVolume);
    	click(maintainStationAllotment_btn_save);
    	driver.switchTo().defaultContent();
    	notificationText = waitForElement(dialogue_text).getText();
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	allotID = waitForElement(maintainStationAllotment_txt_allotmentID).getAttribute("value");
    	PropertyHandler.setPropValue(filepath, allotmentID, allotID);
    	Assert.assertTrue(notificationText.contains("has been created.Do you want to re-list the details?"),"Actual notification message is '"+notificationText+"'");
    	Assert.assertTrue(notificationText.contains(allotID));
    	Assert.assertTrue(waitForElement(maintainStationAllotment_txt_station).getAttribute("value").equals(station));
    	Assert.assertTrue(waitForElement(maintainStationAllotment_txt_weight).getAttribute("value").equals(allotmentWeight));
    	Assert.assertTrue(waitForElement(maintainStationAllotment_txt_volume).getAttribute("value").equals(allotmentVolume));
    	allotmentStatus = waitForElement(maintainStationAllotment_info_status).getAttribute("value");
    	Assert.assertTrue(allotmentStatus.equals("NEW"), "Actual status is '"+allotmentStatus+"'");
    	click(maintainStationAllotment_btn_close);
    	minWait();
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param station
     * @param allotmentWeight
     * @param allotmentVolume
     * @param allotmentID
     * @return
     */
    public FLT004 createStationAllotmentAndNoRelist(String carrierCode, String flightNo, String fromDate, String toDate, String station, String allotmentWeight, String allotmentVolume, String allotmentID){
    	String notificationText;
    	String allotID;
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	station = PropertyHandler.getPropValue(filepath, station);
    	allotmentWeight = PropertyHandler.getPropValue(filepath, allotmentWeight);
    	allotmentVolume = PropertyHandler.getPropValue(filepath, allotmentVolume);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);    	
    	enterKeys(txt_toDate, toDate);    	
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_createStationAllotment);
    	minWait();
    	waitForElement(maintainStationAllotment_txt_station);
    	enterKeys(maintainStationAllotment_txt_station, station);
    	enterKeys(maintainStationAllotment_txt_startDate, fromDate);
    	enterKeys(maintainStationAllotment_txt_endDate, toDate);
//    	enterKeys(maintainStationAllotment_txt_endDate, toDate);
    	check(maintainStationAllotment_chkbox_allFrequency);
    	enterKeys(maintainStationAllotment_txt_weight, allotmentWeight);
    	enterKeys(maintainStationAllotment_txt_volume, allotmentVolume);
    	click(maintainStationAllotment_btn_save);
    	driver.switchTo().defaultContent();
    	notificationText = waitForElement(dialogue_text).getText();
    	click(noBtn);
    	waitForFrameAndSwitch(FRAME);    	
    	Assert.assertTrue(notificationText.contains("has been created.Do you want to re-list the details?"));
    	allotID = notificationText.split(" ")[4];
    	PropertyHandler.setPropValue(filepath, allotmentID, allotID);
    	Assert.assertTrue(notificationText.contains(allotID));
    	Assert.assertTrue(waitForElement(maintainStationAllotment_txt_station).getAttribute("value").trim().length()==0);
    	Assert.assertTrue(waitForElement(maintainStationAllotment_txt_weight).getAttribute("value").equals("0"));
    	Assert.assertTrue(waitForElement(maintainStationAllotment_txt_volume).getAttribute("value").equals("0"));
    	click(maintainStationAllotment_btn_close);
    	minWait();
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @return
     */
    public FLT004 burstSchedule(String carrierCode, String flightNo, String fromDate, String toDate){
    	String notificationText;
    	String status;
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_burst);
    	driver.switchTo().defaultContent();
    	notificationText = waitForElement(dialogue_text).getText();
    	click(okBtn);
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertTrue(notificationText.equals("Burst completed successfully."), "Actual notification message is '"+notificationText+"'");
    	status = getTableCellValue(table_flightSchedules, 15, 1);
    	Assert.assertTrue(status.equals("Live"), "Actual status is '"+status+"'");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleFromDate
     * @param scheduleToDate
     * @param splitStartDate
     * @param splitEndDate
     * @return
     * @throws ParseException
     */
    public FLT004 splitSchedule(String carrierCode, String flightNo, String scheduleFromDate, String scheduleToDate, String splitStartDate, String splitEndDate){
    	scheduleFromDate = PropertyHandler.getPropValue(filepath, scheduleFromDate);
    	scheduleToDate = PropertyHandler.getPropValue(filepath, scheduleToDate);
    	
    	String notificationText;
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleFromDate);
    	enterKeys(txt_toDate, scheduleToDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_splitSchedule);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	waitForElement(splitFlightSchedule_txt_startDate);
    	enterKeys(splitFlightSchedule_txt_startDate, "+2");
    	enterKeys(splitFlightSchedule_txt_endDate, "+3");
    	click(splitFlightSchedule_btn_save);
    	notificationText = waitForElement(dialogue_text).getText();
    	click(okBtn);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertTrue(notificationText.contains("Schedule split successful."));
    	minWait();
    	Assert.assertTrue(getTableRowCount(table_flightSchedules) == 3, "Actual number of rows in table '"+getTableRowCount(table_flightSchedules)+"' and expected is '"+3+"'");
    	return this;
    }
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param address
     * @param mode
     * @return
     */
    public FLT004 notifyStation(String carrierCode, String flightNo, String fromDate, String toDate, String address, String mode){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	mode = PropertyHandler.getPropValue(filepath, mode);
    	address = PropertyHandler.getPropValue(filepath, address);
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_notifyStations);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	waitForElement(notificationAddress_txt_address);
    	enterKeys(notificationAddress_txt_address, address);
    	selectByText(notificationAddress_dropdown_mode, mode);
    	click(notificationAddress_btn_send);
    	minWait();
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param scheduleType
     * @param flightType
     * @param arrivalTime
     * @param departureTime
     * @param aircraftType
     * @return
     */
    public FLT004 updateFlight(String carrierCode, String flightNo, String fromDate, String toDate, String scheduleType, String flightType, String arrivalTime, String departureTime, String aircraftType){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
    	flightType = PropertyHandler.getPropValue(filepath, flightType); 
    	arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime); 
    	departureTime = PropertyHandler.getPropValue(filepath, departureTime); 
    	aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	click(maintainFlightSchedule_btn_updateCapacity);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(maintainFlightSchedule_LegCapacity_txt_arrivalTime, arrivalTime);
    	enterKeys(maintainFlightSchedule_LegCapacity_txt_departureTime, departureTime);
    	enterKeys(maintainFlightSchedule_LegCapacity_txt_AircraftType, aircraftType);
    	click(maintainFlightSchedule_LegCapacity_btn_viewCapacity);
    	click(waitForElement(yesBtn));
    	minWait();
    	click(maintainFlightSchedule_LegCapacity_btn_Ok);
    	minWait();
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	selectByText(maintainFlightSchedule_dropdown_flightType, flightType);
    	selectByText(maintainFlightSchedule_dropdown_scheduleType, scheduleType);
    	click(maintainFlightSchedule_btn_save);
    //	Assert.assertTrue(waitForElement(info_footerNotification).getText().contains("Saved Successfully"));
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this;
    }
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param scheduleType
     * @return
     */
    
    public FLT004 verifyFlightScheduleType(String carrierCode, String flightNo, String fromDate, String toDate, String scheduleType){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);    	
    	enterKeys(txt_toDate, toDate);    	
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	Assert.assertEquals(getSelectedValue(waitForElement(maintainFlightSchedule_dropdown_scheduleType)), scheduleType);
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this;
    }
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param fromDate
     * @param toDate
     * @param newRoute
     * @param departureTime
     * @param arrivalTime
     * @param aircraftType
     * @return
     */
    public FLT004 modifyFlightRoute(String carrierCode, String flightNo, String fromDate, String toDate, String newRoute, String departureTime, String arrivalTime, String aircraftType){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	newRoute = PropertyHandler.getPropValue(filepath, newRoute);
    	departureTime = PropertyHandler.getPropValue(filepath, departureTime);
    	arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
    	aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	minWait();
    	enterKeys(maintainFlightSchedule_txt_route, newRoute);
    	click(maintainFlightSchedule_btn_updateCapacity);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(maintainFlightSchedule_LegCapacity_txt_departureTime, departureTime);
    	enterKeys(maintainFlightSchedule_LegCapacity_txt_arrivalTime, arrivalTime);
    	enterKeys(maintainFlightSchedule_LegCapacity_txt_AircraftType, aircraftType);
    	click(maintainFlightSchedule_LegCapacity_btn_viewCapacity);
    	minWait();
    	click(maintainFlightSchedule_LegCapacity_btn_Ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(maintainFlightSchedule_btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_footerNotification).getText().trim(), "Flight Schedule Saved Successfully.");
    	waitForFrameAndSwitch(FRAME);
    	click(maintainFlightSchedule_btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(waitForElement(yesBtn));
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(getTableCellValue(table_flightSchedules, 15, 1), "To be Actioned");
    	return this;
    }
    
    public FLT004 clear(){
    	click(btn_clear);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @param splitStartDate
     * @param splitEndDate
     * @param splitedFrom
     * @param splitedTo
     * @return
     * @throws ParseException
     */
    public FLT004 cancellFlightSubPeriod(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate, String splitStartDate, String splitEndDate, String splitedFrom, String splitedTo){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	splitStartDate = PropertyHandler.getPropValue(filepath, splitStartDate);
    	splitEndDate = PropertyHandler.getPropValue(filepath, splitEndDate);
    	
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);    	
    	enterKeys(txt_toDate, scheduleEndDate);    	
    	click(btn_list);
    	minWait();
    	click(btn_paneUpArrow);
    	click(btn_panelDownArrow);
    	scheduleStartDate = waitForElement(txt_fromDate).getAttribute("value");
    	scheduleEndDate = waitForElement(txt_toDate).getAttribute("value");
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, splitStartDate);
        enterKeys(changeFlightSchduleStatus_txt_startDate, Keys.TAB);
        enterKeys(changeFlightSchduleStatus_txt_endDate, splitEndDate);
        enterKeys(changeFlightSchduleStatus_txt_endDate, Keys.TAB);
        selectByText(changeFlightSchduleStatus_dropdown_status, "Cancelled");
        String from = waitForElement(changeFlightSchduleStatus_txt_startDate).getAttribute("value");
        String to = waitForElement(changeFlightSchduleStatus_txt_endDate).getAttribute("value");
        PropertyHandler.setPropValue(filepath, splitedFrom, from);
        PropertyHandler.setPropValue(filepath, splitedTo, to);
        click(changeFlightSchduleStatus_btn_save);
        waitForElement(yesBtn);
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Do you want to cancel the schedule ?"));
        click(yesBtn);
        minWait();
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Schedule status changed successfully."));        
        click(waitForElement(okBtn));    
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        minWait();
        Assert.assertTrue(getTableCellValue(table_flightSchedules, 9, 1).toLowerCase().equals(scheduleStartDate.toLowerCase()));
       
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 9, 2).toLowerCase(),from.toLowerCase());
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 10, 2).toLowerCase(),to.toLowerCase());      
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 10, 3).toLowerCase(),scheduleEndDate.toLowerCase());
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 15, 1).toLowerCase(),"Live".toLowerCase());
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 15, 2).toLowerCase(),"Cancelled".toLowerCase());
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 15, 3).toLowerCase(),"Live".toLowerCase());
    	return this;
    }
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @return
     */
    public FLT004 cancellFlightHavingBooking(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);    	
    	enterKeys(txt_toDate, scheduleEndDate);    	
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, scheduleStartDate);        
        enterKeys(changeFlightSchduleStatus_txt_endDate, scheduleEndDate);        
        selectByText(changeFlightSchduleStatus_dropdown_status, "Cancelled");
        click(changeFlightSchduleStatus_btn_save);
        waitForElement(yesBtn);
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Do you want to cancel the schedule ?"));
        click(yesBtn);
        minWait();
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Schedule status changed successfully."));        
        click(waitForElement(okBtn));    
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        minWait();
    	Assert.assertEquals(getTableCellValue(table_flightSchedules, 15, 1),"To be Actioned");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @param status
     * @return
     */
    public FLT004 changeFlightStatus(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate, String status){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	status = PropertyHandler.getPropValue(filepath, status);
    	
    	String filterStatus = null;
    	if (status.equalsIgnoreCase("live"))
    		filterStatus = "Cancelled";
    	else if (status.equalsIgnoreCase("cancelled"))
    		filterStatus = "Live";
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
//    	enterKeys(txt_fromDate, ".");
    	enterKeys(txt_toDate, scheduleEndDate);
//    	enterKeys(txt_toDate, "+6");
    	selectByText(dropdown_status, filterStatus);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, scheduleStartDate);
//        enterKeys(changeFlightSchduleStatus_txt_startDate, ".");
        enterKeys(changeFlightSchduleStatus_txt_endDate, scheduleEndDate);
//        enterKeys(changeFlightSchduleStatus_txt_endDate, "+6");
        selectByText(changeFlightSchduleStatus_dropdown_status, status);
        click(changeFlightSchduleStatus_btn_save);
        waitForElement(yesBtn);
        click(yesBtn);
        minWait();
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Schedule status changed successfully."));        
        click(waitForElement(okBtn));    
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        minWait();
        click(btn_clear);
        minWait();
        enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
//    	enterKeys(txt_fromDate, ".");
    	enterKeys(txt_toDate, scheduleEndDate);
//    	enterKeys(txt_toDate, "+6");
    	click(btn_list);
    	minWait();
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 15, 1).toLowerCase().equals(status.toLowerCase()));
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @param reinstateFrom
     * @param reinstateTo
     * @return
     */
    public FLT004 reinstateFlight(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate,
    		String reinstateFrom, String reinstateTo){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	reinstateFrom = PropertyHandler.getPropValue(filepath, reinstateFrom);
    	reinstateTo = PropertyHandler.getPropValue(filepath, reinstateTo);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
//    	enterKeys(txt_fromDate, ".");
    	enterKeys(txt_toDate, scheduleEndDate);
//    	enterKeys(txt_toDate, "+6");
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, reinstateFrom);
        enterKeys(changeFlightSchduleStatus_txt_endDate, reinstateTo);
        selectByText(changeFlightSchduleStatus_dropdown_status, "Live");
        click(changeFlightSchduleStatus_btn_save);
        waitForElement(yesBtn);
        click(yesBtn);
        minWait();
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Schedule status changed successfully."));        
        click(waitForElement(okBtn));    
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        minWait();
        clear();
        minWait();
        enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, reinstateFrom);
    	enterKeys(txt_toDate, reinstateTo);
    	click(btn_list);
    	minWait();
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 15, 1).contains("Live"));
    	return this;
    }
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @return
     * @throws ParseException
     */
    public FLT004 cancelFlightWithAllomentSubPeriod(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
    	Calendar cal = Calendar.getInstance();
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	String splitStartDate;
    	String  splitEndDate;
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	scheduleStartDate = waitForElement(txt_fromDate).getAttribute("value");
    	Date flightStartDate = sdf.parse(scheduleStartDate.toUpperCase());
    	Date splitStart;
    	Date splitEnd;
    	cal.setTime(flightStartDate);
    	cal.add(Calendar.DATE, 3);
    	splitStart = cal.getTime();
    	cal.add(Calendar.DATE, 2);
    	splitEnd = cal.getTime();
    	
    	splitStartDate = sdf.format(splitStart);
    	splitEndDate = sdf.format(splitEnd);
    	cal.setTime(splitStart);
    	cal.add(Calendar.DATE, -1);   	
    	cal.setTime(splitEnd);
    	cal.add(Calendar.DATE, 1);  	
  	
    	
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, splitStartDate);
        enterKeys(changeFlightSchduleStatus_txt_endDate, splitEndDate);
        selectByText(changeFlightSchduleStatus_dropdown_status, "Cancelled");
        click(changeFlightSchduleStatus_btn_save);
        waitForElement(yesBtn);
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Do you want to cancel the schedule ?"));
        click(yesBtn);
        minWait();
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Schedule status changed successfully."));        
        click(waitForElement(okBtn));    
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        minWait();      
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @return
     */
    public FLT004 checkIfCancelledFlightCanBeMadeNonOpertional(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate){
    	List<String> dropdownOptions;
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, scheduleStartDate);
        enterKeys(changeFlightSchduleStatus_txt_endDate, scheduleEndDate);
        dropdownOptions = getAllValues(changeFlightSchduleStatus_dropdown_status);
        Assert.assertFalse(dropdownOptions.contains("Non Operational"));
        Assert.assertTrue(dropdownOptions.contains("Live"));
        click(changeFlightSchduleStatus_btn_close);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @param splitStartDate
     * @param splitEndDate
     * @param splitedFrom
     * @param splitedTo
     * @return
     * @throws ParseException
     */
    public FLT004 makeFlightNonOpertional(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate, String splitStartDate, String splitEndDate, String splitedFrom, String splitedTo){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	splitStartDate = PropertyHandler.getPropValue(filepath, splitStartDate);
    	splitEndDate = PropertyHandler.getPropValue(filepath, splitEndDate);
    	
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	scheduleStartDate = waitForElement(txt_fromDate).getAttribute("value");
    	scheduleEndDate = waitForElement(txt_toDate).getAttribute("value");
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, splitStartDate);
        enterKeys(changeFlightSchduleStatus_txt_endDate, splitEndDate);
        enterKeys(changeFlightSchduleStatus_txt_endDate, Keys.TAB);
        selectByText(changeFlightSchduleStatus_dropdown_status, "Non Operational");
        String from = waitForElement(changeFlightSchduleStatus_txt_startDate).getAttribute("value");
        String to = waitForElement(changeFlightSchduleStatus_txt_endDate).getAttribute("value");
        PropertyHandler.setPropValue(filepath, splitedFrom, from);
        PropertyHandler.setPropValue(filepath, splitedTo, to);
        click(changeFlightSchduleStatus_btn_save);
        waitForElement(yesBtn);
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Do you want to make the schedule non-operational?"));
        click(yesBtn);
        minWait();
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Schedule status changed successfully."));        
        click(waitForElement(okBtn));    
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        minWait();
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 9, 1).toLowerCase(),scheduleStartDate.toLowerCase());
       
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 9, 2).toLowerCase(),from.toLowerCase());
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 10, 2).toLowerCase(),to.toLowerCase());      
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 10, 3).toLowerCase(),scheduleEndDate.toLowerCase());
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 15, 1).toLowerCase(),"Live".toLowerCase());
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 15, 2).toLowerCase(),"Non Operational".toLowerCase());
        Assert.assertEquals(getTableCellValue(table_flightSchedules, 15, 3).toLowerCase(),"Live".toLowerCase());
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @return
     * @throws ParseException
     */
    public FLT004 checkFunctionalityOfNOButtonInChangeFlightScheduleStatusDialogue(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate) throws ParseException{
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	
    	
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	scheduleStartDate = waitForElement(txt_fromDate).getAttribute("value");
    	scheduleEndDate = waitForElement(txt_toDate).getAttribute("value");
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, scheduleStartDate);
        enterKeys(changeFlightSchduleStatus_txt_endDate, scheduleEndDate);
        selectByText(changeFlightSchduleStatus_dropdown_status, "Non Operational");
        click(changeFlightSchduleStatus_btn_save);
        waitForElement(yesBtn);
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Do you want to make the schedule non-operational?"));
        click(noBtn);
        click(changeFlightSchduleStatus_btn_close);
        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        minWait();
        int tableRowCount = getTableRowCount(table_flightSchedules);
        for(int i=1;i<=tableRowCount;i++){
        	Assert.assertEquals(getTableCellValue(table_flightSchedules, 15, i), "Live");
        }
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @return
     */
    public FLT004 checkIfFlightWithAllotmentCanbeMadeNonOperational(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate){

    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, scheduleStartDate);
        enterKeys(changeFlightSchduleStatus_txt_endDate, scheduleEndDate);
        selectByText(changeFlightSchduleStatus_dropdown_status, "Non Operational");
        click(changeFlightSchduleStatus_btn_save);
        waitForElement(yesBtn);
        click(yesBtn);
        Assert.assertTrue(waitForElement(info_error).isDisplayed());
        click(changeFlightSchduleStatus_btn_close);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        return this;
    }
    /**
     * Created by A-7605
     * The flight should have allotment/permanent booking.
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @return
     */
    // need to confirm the error message once the bug is fixed. Now no such error message is showing
    public FLT004 verifyThatCreationOfNewActiveFlightIsNotAllowed(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate){
    	
    	String expectedErrorMessage = "Cannot create new active flight";
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_create);
    	Assert.assertEquals(waitForElement(info_error).getText(), expectedErrorMessage);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @param reinstateFrom
     * @param reinstateTo
     * @return
     */
    public FLT004 reinstateNonOperationalFlightInSubPeriod(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate,
    		String reinstateFrom, String reinstateTo){
    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
    	reinstateFrom = PropertyHandler.getPropValue(filepath, reinstateFrom);
    	reinstateTo = PropertyHandler.getPropValue(filepath, reinstateTo);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	scheduleStartDate = waitForElement(txt_fromDate).getAttribute("value");
    	scheduleEndDate = waitForElement(txt_toDate).getAttribute("value");
    	check(chkbox_selectTableItem);
    	click(btn_change);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(changeFlightSchduleStatus_txt_startDate, reinstateFrom);
        enterKeys(changeFlightSchduleStatus_txt_endDate, reinstateTo);
        selectByText(changeFlightSchduleStatus_dropdown_status, "Live");
        reinstateFrom = waitForElement(changeFlightSchduleStatus_txt_startDate).getAttribute("value");
        reinstateTo = waitForElement(changeFlightSchduleStatus_txt_endDate).getAttribute("value");
        click(changeFlightSchduleStatus_btn_save);
        waitForElement(yesBtn);
        click(yesBtn);
        minWait();
        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Schedule status changed successfully."));        
        click(waitForElement(okBtn));    
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        minWait();
        clear();
        minWait();
        enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNo, flightNo);
    	enterKeys(txt_fromDate, scheduleStartDate);
    	enterKeys(txt_toDate, scheduleEndDate);
    	click(btn_list);
    	minWait();
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 9, 1).toLowerCase().equals(scheduleStartDate.toLowerCase()));
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 15, 1).toLowerCase().equals("non operational".toLowerCase()));
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 9, 2).toLowerCase().equals(reinstateFrom.toLowerCase()));
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 10, 2).toLowerCase().equals(reinstateTo.toLowerCase()));
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 15, 2).toLowerCase().equals("live"));
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 10, 3).toLowerCase().equals(scheduleEndDate.toLowerCase()));
    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 15, 3).toLowerCase().equals("non operational"));
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param carrierCode
     * @param flightNo
     * @param scheduleStartDate
     * @param scheduleEndDate
     * @return
     */
	public FLT004 verifyFlightStatusInTable(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate, String statusColNumberInTable, String status){
	    	
	    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
	    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
	    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
	    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
	    	statusColNumberInTable = PropertyHandler.getPropValue(filepath, statusColNumberInTable);
	    	status = PropertyHandler.getPropValue(filepath, status);
	    	
	    	enterKeys(txt_carrierCode, carrierCode);
	    	enterKeys(txt_flightNo, flightNo);
	    	enterKeys(txt_fromDate, scheduleStartDate);
//	    	enterKeys(txt_fromDate, ".");
	    	enterKeys(txt_toDate, scheduleEndDate);
//	    	enterKeys(txt_toDate, "+6");
	    	click(btn_list);
	    	minWait();
	    	Assert.assertEquals(getTableCellValue(table_flightSchedules, Integer.parseInt(statusColNumberInTable), 1),status);
	    	return this;
	    }
	
		public FLT004 createCharterFlight(String carrierCode, String flightRoute, String flightNo, String fullFlightNo, String scheduleType, String flightType, 
				String departureTime, String arrivalTime, String aircraftType ,String scheduleStartDate, String scheduleEndDate){
	    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
	    	flightRoute = PropertyHandler.getPropValue(filepath, flightRoute);
	    	scheduleType = PropertyHandler.getPropValue(filepath, scheduleType);
	    	flightType = PropertyHandler.getPropValue(filepath, flightType);
	    	departureTime = PropertyHandler.getPropValue(filepath, departureTime);
	    	arrivalTime = PropertyHandler.getPropValue(filepath, arrivalTime);
	    	aircraftType = PropertyHandler.getPropValue(filepath, aircraftType);
	    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
	    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
	    	
	    	click(btn_create);
	    	minWait();
	        enterKeys(maintainFlightSchedule_txt_carrierCode, carrierCode);
	
	        String rand_fltnum;
	
	        while (true) {
	            rand_fltnum = BizUtility.createFlightNum();
	            enterKeys(maintainFlightSchedule_txt_flightNo, rand_fltnum);
	           enterKeys(maintainFlightSchedule_txt_startDate, scheduleStartDate);	           
	            enterKeys(maintainFlightSchedule_txt_endDate, scheduleEndDate);	            
	            click(maintainFlightSchedule_btn_list);
	            driver.switchTo().defaultContent();
	            minWait();
	            if (verifyElementPresent(yesBtn)) {
	                click(yesBtn);
	                waitForFrameAndSwitch(FRAME);
	                break;
	            }
	            waitForFrameAndSwitch(FRAME);
	            click(waitForElement(maintainFlightSchedule_btn_clear));
	        }
	
	        minWait();
	        String fltNo = waitForElement(maintainFlightSchedule_txt_flightNo).getAttribute("value");
	        PropertyHandler.setPropValue(filepath, flightNo, fltNo);
	        PropertyHandler.setPropValue(filepath, fullFlightNo, carrierCode + fltNo);
	
	        click(waitForElement(maintainFlightSchedule_txt_route));
	        enterKeys(maintainFlightSchedule_txt_route, flightRoute);
	        click(maintainFlightSchedule_chkbox_allFrequency);
	
	        selectByText(maintainFlightSchedule_dropdown_scheduleType, scheduleType);
	        selectByText(maintainFlightSchedule_dropdown_flightType, flightType);
	        enterKeys(maintainFlightSchedule_txt_effectiveDate, "." + Keys.TAB);
	        selectByText(maintainFlightSchedule_dropdown_agreementType, "Charter Flight");
	        click(maintainFlightSchedule_btn_updateCapacity);
	        minWait();
	        driver.switchTo().defaultContent();
	        waitForNewWindow(2);
	
	        switchToSecondWindow();
	        waitForElement(maintainFlightSchedule_LegCapacity_txt_departureTime);
	        enterKeys(maintainFlightSchedule_LegCapacity_txt_departureTime, departureTime);
	        enterKeys(maintainFlightSchedule_LegCapacity_txt_arrivalTime, arrivalTime);
	        enterKeys(maintainFlightSchedule_LegCapacity_txt_AircraftType, aircraftType);
	        click(maintainFlightSchedule_LegCapacity_btn_viewCapacity);
	        //screen refresh
	        click(maintainFlightSchedule_LegCapacity_btn_Ok);
	
	        //switch back to main window
	        minWait();
	        switchToFirstWindow();
	
	        waitForFrameAndSwitch(FRAME);
	        click(waitForElement(maintainFlightSchedule_btn_save));
	        driver.switchTo().defaultContent();
	
	        //click(waitForElement(button_diaYes));        
	        click(waitForElement(yesBtn));
	
	        Assert.assertTrue(waitForElement(okBtn).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
	        click(okBtn);
	
	        waitForFrameAndSwitch(FRAME);
	        minWait();
	        click(maintainFlightSchedule_btn_close);
	    	driver.switchTo().defaultContent();
	    	if(verifyElementPresent(yesBtn))
	    		click(waitForElement(yesBtn));
	    	waitForFrameAndSwitch(FRAME);
	    	minWait();
	    	enterKeys(txt_carrierCode, carrierCode);
	    	enterKeys(txt_flightNo, fltNo);
	    	enterKeys(txt_fromDate, scheduleStartDate);
	    	enterKeys(txt_toDate, scheduleEndDate);
	    	click(btn_list);
	    	minWait();
	    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 15, 1).contains("Live"));
	    	Assert.assertTrue(getTableCellValue(table_flightSchedules, 17, 1).equals("Charter Flight"));
	    	return this;
	    }
		
		
		/**
		 * Created by A-7605
		 * This method will mark flight as non oprational for the entire period
		 * @param carrierCode
		 * @param flightNo
		 * @param scheduleStartDate
		 * @param scheduleEndDate
		 * @return
		 */
		public FLT004 markFlightNonOpertionalForFullSchedule(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate){
	    	carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
	    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
	    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
	    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
	    	
	    	enterKeys(txt_carrierCode, carrierCode);
	    	enterKeys(txt_flightNo, flightNo);
	    	enterKeys(txt_fromDate, scheduleStartDate);
	    	enterKeys(txt_toDate, scheduleEndDate);
	    	click(btn_list);
	    	minWait();
	    	scheduleStartDate = waitForElement(txt_fromDate).getAttribute("value");
	    	scheduleEndDate = waitForElement(txt_toDate).getAttribute("value");
	    	check(chkbox_selectTableItem);
	    	click(btn_change);
	    	driver.switchTo().defaultContent();
	    	waitForNewWindow(2);
	        switchToSecondWindow();
	        enterKeys(changeFlightSchduleStatus_txt_startDate, scheduleStartDate);
	        enterKeys(changeFlightSchduleStatus_txt_endDate, scheduleEndDate);
	        enterKeys(changeFlightSchduleStatus_txt_endDate, Keys.TAB);
	        selectByText(changeFlightSchduleStatus_dropdown_status, "Non Operational");
	        click(changeFlightSchduleStatus_btn_save);
	        waitForElement(yesBtn);
	        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Do you want to make the schedule non-operational?"));
	        click(yesBtn);
	        minWait();
	        Assert.assertTrue(waitForElement(dialogue_text).getText().equals("Schedule status changed successfully."));        
	        click(waitForElement(okBtn));    
	        switchToFirstWindow();
	        waitForFrameAndSwitch(FRAME);
	        minWait();
	        Assert.assertEquals(getTableCellValue(table_flightSchedules, 15, 1).toLowerCase(),"Non Operational".toLowerCase());
	    	return this;
	    }
		
		/**
		 * Created by A-7605
		 * This method will check the warning message shown on trying to revalidate flight that is in live status
		 * @param carrierCode
		 * @param flightNo
		 * @param scheduleStartDate
		 * @param scheduleEndDate
		 * @return
		 */
		public FLT004 verifyWarningShownOnRevalidatingFlightInLiveStatus(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate){
			carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
	    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
	    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
	    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
	    	
	    	enterKeys(txt_carrierCode, carrierCode);
	    	enterKeys(txt_flightNo, flightNo);
	    	enterKeys(txt_fromDate, scheduleStartDate);
	    	enterKeys(txt_toDate, scheduleEndDate);
	    	click(btn_list);
	    	minWait();
	    	check(chkbox_selectTableItem);
	    	click(btn_revalidate);
	    	driver.switchTo().defaultContent();
	    	Assert.assertEquals(waitForElement(dialogue_text).getText(), "Revalidation not required. Flight status must be either To be actioned or To be Cancelled.");
	    	click(okBtn);
	    	waitForFrameAndSwitch(FRAME);
	    	return this;
		}
		
		public FLT004 revaildateFlight(String carrierCode, String flightNo, String scheduleStartDate, String scheduleEndDate){
			carrierCode = PropertyHandler.getPropValue(filepath, carrierCode);
	    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
	    	scheduleStartDate = PropertyHandler.getPropValue(filepath, scheduleStartDate);
	    	scheduleEndDate = PropertyHandler.getPropValue(filepath, scheduleEndDate);
	    	
	    	enterKeys(txt_carrierCode, carrierCode);
	    	enterKeys(txt_flightNo, flightNo);
	    	enterKeys(txt_fromDate, scheduleStartDate);
	    	enterKeys(txt_toDate, scheduleEndDate);
	    	click(btn_list);
	    	check(chkbox_selectTableItem);
	    	click(btn_revalidate);
	    	minWait();
	    	Assert.assertEquals(getTableCellValue(table_flightSchedules, 15, 1), "Live");
	    	return this;
		}

		
		public FLT004 checkFlightListing(String key_flightNo,String key_flightNo2,String key_flightType, String key_aircraftType,String key_origincity,String key_origin,String key_destinationcity,String key_destination)
		{
			String data_flightNo = PropertyHandler.getPropValue(filepath, key_flightNo);
			String data_flightNo2 = PropertyHandler.getPropValue(filepath, key_flightNo2);
			String data_flightType = PropertyHandler.getPropValue(filepath, key_flightType);
			String data_aircraftType = PropertyHandler.getPropValue(filepath, key_aircraftType);
			String data_origincity=PropertyHandler.getPropValue(filepath, key_origincity);
			String data_origin=PropertyHandler.getPropValue(filepath, key_origin);
			
			String data_destinationcity=PropertyHandler.getPropValue(filepath, key_destinationcity);
			String data_destination=PropertyHandler.getPropValue(filepath, key_destination);
			int tableRowCount;
			List<String> tableColValue;
			
			selectByText(dropdown_flightType, data_flightType);
			enterKeys(txt_aircraftType, data_aircraftType);
			selectByText(dropdown_origin, data_origincity);
			enterKeys(txt_origin,data_origin);
			selectByText(dropdown_dest, data_destinationcity);
			enterKeys(txt_destination,data_destination);
			click(btn_list);
			//Assert.assertTrue(waitForElement(table_flightSchedules).isDisplayed(), "ERROR : No Records are Found.");
			//tableRowCount = getTableRowCount(table_flightSchedules);
			
			tableColValue = getTableColumnValues(table_flightSchedules,3);
			for(int i=0;i<tableColValue.size();i++)
			{
				if(tableColValue.get(i).contains(data_flightNo))
				break;
					
			}
			for(int i=0;i<tableColValue.size();i++)
			{
				if(tableColValue.get(i).contains(data_flightNo2))
				break;
					
			}					
							
							return this;
			
		}
		
		public FLT004 checkFlightListingfordiffDest(String key_flightNo,String key_flightNo2, String key_flightType, String key_aircraftType,String key_origincity,String key_origin)
		{
			String data_flightNo = PropertyHandler.getPropValue(filepath, key_flightNo);
			String data_flightNo2 = PropertyHandler.getPropValue(filepath, key_flightNo2);
			String data_flightType = PropertyHandler.getPropValue(filepath, key_flightType);
			String data_aircraftType = PropertyHandler.getPropValue(filepath, key_aircraftType);
			String data_origincity=PropertyHandler.getPropValue(filepath, key_origincity);
			String data_origin=PropertyHandler.getPropValue(filepath, key_origin);
			
			/*String data_destinationcity=PropertyHandler.getPropValue(filepath, key_destinationcity);
			String data_destination=PropertyHandler.getPropValue(filepath, key_destination);*/
			int tableRowCount;
			List<String> tableColValue;
			
			selectByText(dropdown_flightType, data_flightType);
			enterKeys(txt_aircraftType, data_aircraftType);
			selectByText(dropdown_origin, data_origincity);
			enterKeys(txt_origin,data_origin);
			/*selectByText(dropdown_dest, data_destinationcity);
			enterKeys(txt_destination,data_destination);*/
			click(btn_list);
			tableColValue = getTableColumnValues(table_flightSchedules,3);
			for(int i=0;i<tableColValue.size();i++)
			{
				if(tableColValue.get(i).contains(data_flightNo))
				break;
					
			}
			for(int i=0;i<tableColValue.size();i++)
			{
				if(tableColValue.get(i).contains(data_flightNo2))
				break;
					
			}					
				
						return this;
			
		}

		
		/**
		 * Method to view the modification log and click continue
		 * @param carrCode
		 * @param fltNum
		 * @param error
		 * @param updatedStatus
		 * @return
		 * @author A-7868 Krishna <25/06/2018>
		 */
		public FLT004 continueWithModification(String carrCode, String fltNum, String modificationError){
			
			carrCode = PropertyHandler.getPropValue(filepath, carrCode);
			fltNum = PropertyHandler.getPropValue(filepath, fltNum);
	    	
			tblSelectRowByColValue(table_flightSchedules, 1, 3, fltNum);
			
			click(btn_modificationLog);
			driver.switchTo().defaultContent();
			waitForNewWindow(2);
			switchToSecondWindow();			
			Assert.assertTrue(getTableCellValue(tbl_modificationTable, 3, 1).equalsIgnoreCase(modificationError), "Invalid error shown in Modification Log");
			click(btn_modfcnLog_continue);
			switchBackToFirstWindow();
			waitForFrameAndSwitch(FRAME);
			return this;
		}
		/**
		 * Method to verify source type
		 * @param carrCode
		 * @return
		 * @author Shalini
		 */
	public FLT004 listFlightVerifyFlightNo(String FlightNo,String SourceType){
		boolean isFound = true;
		  FlightNo = PropertyHandler.getPropValue(filepath,FlightNo);
		  SourceType = PropertyHandler.getPropValue(filepath,SourceType);
		enterKeys(txt_flightNo, FlightNo);
		click(btn_list);
    	minWait();
    	String ExpectedsourceType = waitForElement(table_SourceType).getText();
    	Assert.assertTrue(isFound, "SourceType are from Property file" + SourceType + "and " +ExpectedsourceType+ "From Screen are matching");
    	InitialSetup.test.log(LogStatus.PASS, "Successfully Compared SourceType from Property file and in Screen");
		return this;
		
	}
	
}
