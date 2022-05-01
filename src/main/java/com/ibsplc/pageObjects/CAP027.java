package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/19/2017.
 */
public class CAP027 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameCAP027";
    public static By popupFrame = By.id("popupContainerFrame");
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;
    private By txt_fltCarCode,
            txt_fltNo,
            txt_fltDt,
            btn_list,
            btn_clear,
            lnk_create,
            rb_allotType,
            chk_reject1,
            tables_CapacityTbl,
            chk_reject2,
            LyingListbutton,
            txt_station,
            txt_capWt,
            txt_capVol,
            btn_saveAltmnt,
            table_bookingConfirm,
            btn_createOk,
            table_allotment,
            tbl_confirmedBooking,
            btn_viewBookingDtls,
            GenerateFBLbutton,
            waittbl,
            btn_WaitlistedBook_tab,
            btn_viewCapSumry,
            list_tblCapacityTbl,
            Btn_Rejectbutton,
            btn_capSmryClose,
            MarkPreCarriagebutton_btn,
            MarkPreCarriage_Btn_List,
            MarkPreCarriage_chkbox_shipPreCheckbox,
            MarkPreCarriage_Btn_MoveToListbutton,
            MarkPreCarriage_Select_precarriageType,
            MarkPreCarriage_Btn_Savebutton,
            MarkPreCarriage_Btn_deleteLink,
            MarkPreCarriage_Btn_Closebutton,
            MarkPreCarriage_txt_pref,
            Btn_Reassignbutton,
            MarkPreCarriage_txt_awb,
            ChkBx_CheckAllCnfBookings,
            btn_genericNo,
            Irregularity_Inbx_irregularityCode,
            Irregularity_Inbx_irregularityRemarks,
            Irregularity_Btn_OKbutton,
            MarkPreCarriage_precarriagetable,
            Btn_buttonbt_flightnumber_carrierCode,
            Btn_buttonbt_flightnumber_Cancelbutton,
            Btn_buttonbt_flightnumber_OKbutton,
            Btn_buttonbt_flightScribble_Txt,
            btn_close,
            chkBx_chkAllBookings,
            txt_flightVolume,
            btn_reAssign,
            chkBx_reassignChkAllSelFlt,
            btn_reassignDltSelFlt,
            ckhBx_reassignFirstFlt,
            btn_reassignMoveList,
            btn_reassignOk,
            tbl_bookings,
            btn_lyingList,
            txt_lyingAwbPre,
            txt_lyingAwbNo,
            btn_lyingListAwb,
            chkBx_lyingCheckAll,
            btn_lyingAssignToFlt,
            btn_disruptionList,
            txt_disruptionAwbPre,
            txt_disruptionAwbNo,
            btn_disruptionListAwb,
            chkBx_disruptionCheckAll,
            btn_disruptionAssignToFlt,
            btn_fltControls,
            btn_fltCtrlCloseStation,
            btn_closeStnAdd,
            txt_stationCode,
            Reassign_selectedFlightSelectAllcheckbox,
            Reassign_selectedFlight_delLink,
            btn_stationList,
            chkBx_stationChkAll,
            btn_stationOk,
            btn_closeStnOk,
            btn_fltCtrlClose,
            Reassign_chkbox_shipPreCheckbox,
            chkBx_fltCtrlSegChkAll,
            btn_fltCtrlCloseSeg,
            btn_fltCtrlOpenSeg,
            Btn_Reassign_OKbutton,
            ViewFltFactsbutton,
            flightFactStatus,
            ViewFltListbutton,
            ViewFltdiv,
            ViewFltListClosebutton,
            Connectionflt,
            Connectionflt2,
            Condetails,
            Btn_Reassign_MoveToListbutton,
            Condetails2,
            tab_queuedBooking,
            Color_red,
            Color_green,
            txt_bup,
            Check_Embargo_Btn_Continue,
            tbl_queuedBooking,
            Table_CheckRestriction,
            txt_flightWeight,
            Btn_Queue,
            Btn_OK_NewWindow,
            btn_confirm,
            info_error,
            tbl_reassignFlt,
            btn_reAssign_Close,
            btn_priority;
    private By btn_genericYes,
            Generic_info_msg,
            btn_genericOk,
    link_genericNext;
    
    
    
    
    private By tbl_confirmedBookings,
    			txt_reAssignOrigin,
    			txt_reAssignDest,
    			btn_reAssignList,
    			tbl_reAssignFlights,
    			btn_reAssignOk,
    			tab_queued,
    			table_queuedBooking,
    			txt_rejectWindow_irrCode,
    	        txt_rejectWindow_irrRem,
    	        btn_rejectWindow_irrOk,
    	        btn_rejectWindow_irrClose,
    	        btn_affectedBkg,
    	        dropdown_affLeg,
    	        tbl_affBkg,
    	        btn_affBkg_list,
    	        proprity_tbl_bkgDetails;

    private By txt_fltDate;
    
    private By  radio_global,
    			radio_customer,
    			radio_station,
    			radio_product,
    			Irregularity_Btn_Closebutton;
    
    private By lnk_altId;
    
    private By sel_shipType;
    private By txt_globalCustCode;
    private By btn_createAltOk;
    
    private By txt_ovrBkWt;
    private By txt_ovrBkVol;
    private By btn_windowClose;
    private By dropdown_stnLevel;
    
    public CAP027(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    /**
     * Initializes the webelements
     *
     * @author A-7681
     */
    private void initElements() {
        txt_fltCarCode = MiscUtility.getWebElement(objFilepath, "CAP027_txt_fltCarCode");
        txt_fltNo = MiscUtility.getWebElement(objFilepath, "CAP027_txt_fltNo");
        txt_fltDt = MiscUtility.getWebElement(objFilepath, "CAP027_txt_fltDt");
        btn_list = MiscUtility.getWebElement(objFilepath, "CAP027_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "CAP027_btn_clear");
        tbl_confirmedBooking = MiscUtility.getWebElement(objFilepath, "CAP027_tbl_confirmedBooking");
        btn_viewBookingDtls = MiscUtility.getWebElement(objFilepath, "CAP027_btn_viewBookingDtls");
        btn_close = MiscUtility.getWebElement(objFilepath, "CAP027_btn_close");
        btn_viewCapSumry = MiscUtility.getWebElement(objFilepath, "CAP027_btn_viewCapSumry");
        chkBx_chkAllBookings = MiscUtility.getWebElement(objFilepath, "CAP027_chkBx_chkAllBookings");
        btn_reAssign = MiscUtility.getWebElement(objFilepath, "CAP027_btn_reAssign");
        tbl_bookings = MiscUtility.getWebElement(objFilepath, "CAP027_tbl_bookings");
        btn_lyingList = MiscUtility.getWebElement(objFilepath, "CAP027_btn_lyingList");
        btn_disruptionList = MiscUtility.getWebElement(objFilepath, "CAP027_btn_disruptionList");
        btn_fltControls = MiscUtility.getWebElement(objFilepath, "CAP027_btn_fltControls");
        tab_queuedBooking = MiscUtility.getWebElement(objFilepath, "CAP027_tab_queuedBooking");
        tbl_queuedBooking = MiscUtility.getWebElement(objFilepath, "CAP027_tbl_queuedBooking");
        btn_confirm = MiscUtility.getWebElement(objFilepath, "CAP027_btn_confirm");
        Btn_Reassign_OKbutton = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_Reassign_OKbutton");

        ChkBx_CheckAllCnfBookings = MiscUtility.getWebElement(objFilepath, "CAP027_ChkBx_CheckAllCnfBookings");
        lnk_create = MiscUtility.getWebElement(objFilepath, "CAP027_lnk_createAllot");
        rb_allotType = MiscUtility.getWebElement(objFilepath, "CAP027_Create_rb_AltmntType");
        txt_station = MiscUtility.getWebElement(objFilepath, "CAP027_Create_txt_station");
        txt_capWt = MiscUtility.getWebElement(objFilepath, "CAP027_Create_txt_capWt");
        txt_capVol = MiscUtility.getWebElement(objFilepath, "CAP027_Create_txt_capVol");
        btn_saveAltmnt = MiscUtility.getWebElement(objFilepath, "CAP027_Create_btn_save");
        btn_createOk = MiscUtility.getWebElement(objFilepath, "CAP027_Create_btn_ok");
        table_allotment = MiscUtility.getWebElement(objFilepath, "CAP027_table_allotment");

        Btn_Rejectbutton = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_Rejectbutton");
        list_tblCapacityTbl = MiscUtility.getWebElement(objFilepath, "CAP027_tbl_capacityTbl");
        btn_capSmryClose = MiscUtility.getWebElement(objFilepath, "CAP027_btn_capSmryClose");

        GenerateFBLbutton = MiscUtility.getWebElement(objFilepath, "CAP027_GenerateFBLbutton");
        table_bookingConfirm = MiscUtility.getWebElement(objFilepath, "CAP027_table_bookingConfirm");
        btn_WaitlistedBook_tab = MiscUtility.getWebElement(objFilepath, "CAP027_btn_WaitlistedBook_tab");
        Btn_Reassignbutton = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_Reassignbutton");
        table_bookingConfirm = MiscUtility.getWebElement(objFilepath, "CAP027_table_bookingConfirm");

        btn_WaitlistedBook_tab = MiscUtility.getWebElement(objFilepath, "CAP027_btn_WaitlistedBook_tab");
        Btn_Reassignbutton = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_Reassignbutton");
        Btn_Reassignbutton = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_Reassignbutton");
        list_tblCapacityTbl = MiscUtility.getWebElement(objFilepath, "CAP027_tbl_capacityTbl");
        btn_capSmryClose = MiscUtility.getWebElement(objFilepath, "CAP027_btn_capSmryClose");
        Reassign_chkbox_shipPreCheckbox = MiscUtility.getWebElement(objFilepath, "CAP027_Reassign_chkbox_shipPreCheckbox");
        MarkPreCarriagebutton_btn = MiscUtility.getWebElement(objFilepath, "CAP027_MarkPreCarriagebutton_btn");
        MarkPreCarriage_Btn_List = MiscUtility.getWebElement(objFilepath, "CAP027_MarkPreCarriage_Btn_List");
        MarkPreCarriage_chkbox_shipPreCheckbox = MiscUtility.getWebElement(objFilepath, "CAP027_MarkPreCarriage_chkbox_shipPreCheckbox");
        MarkPreCarriage_Btn_MoveToListbutton = MiscUtility.getWebElement(objFilepath, "CAP027_MarkPreCarriage_Btn_MoveToListbutton");
        MarkPreCarriage_Select_precarriageType = MiscUtility.getWebElement(objFilepath, "CAP027_MarkPreCarriage_Select_precarriageType");
        MarkPreCarriage_Btn_Savebutton = MiscUtility.getWebElement(objFilepath, "CAP027_MarkPreCarriage_Btn_Savebutton");
        MarkPreCarriage_Btn_deleteLink = MiscUtility.getWebElement(objFilepath, "CAP027_MarkPreCarriage_Btn_deleteLink");
        MarkPreCarriage_Btn_Closebutton = MiscUtility.getWebElement(objFilepath, "CAP027_MarkPreCarriage_Btn_Closebutton");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_genericNo = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        Irregularity_Inbx_irregularityCode = MiscUtility.getWebElement(objFilepath, "CAP018_Irregularity_Inbx_irregularityCode");
        Irregularity_Inbx_irregularityRemarks = MiscUtility.getWebElement(objFilepath, "CAP018_Irregularity_Inbx_irregularityRemarks");
        Irregularity_Btn_OKbutton = MiscUtility.getWebElement(objFilepath, "CAP018_Irregularity_Btn_OKbutton");
        Irregularity_Btn_Closebutton = MiscUtility.getWebElement(objFilepath, "CAP018_Irregularity_Btn_Closebutton");
        MarkPreCarriage_txt_pref = MiscUtility.getWebElement(objFilepath, "CAP027_MarkPreCarriage_txt_pref");
        MarkPreCarriage_txt_awb = MiscUtility.getWebElement(objFilepath, "CAP027_MarkPreCarriage_txt_awb");
        MarkPreCarriage_precarriagetable = MiscUtility.getWebElement(objFilepath, "CAP027_MarkPreCarriage_precarriagetable");
        Reassign_selectedFlightSelectAllcheckbox = MiscUtility.getWebElement(objFilepath, "CAP027_Reassign_selectedFlightSelectAllcheckbox");
        Reassign_selectedFlight_delLink = MiscUtility.getWebElement(objFilepath, "CAP027_Reassign_selectedFlight_delLink");
        Btn_Reassign_MoveToListbutton = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_Reassign_MoveToListbutton");
        Table_CheckRestriction = MiscUtility.getWebElement(objFilepath, "CAP027_Table_CheckRestriction");
        Check_Embargo_Btn_Continue = MiscUtility.getWebElement(objFilepath, "CAP027_Check_Embargo_Btn_Continue");
        Btn_buttonbt_flightnumber_carrierCode = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_buttonbt_flightnumber_carrierCode");
        Btn_buttonbt_flightnumber_Cancelbutton = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_buttonbt_flightnumber_Cancelbutton");
        Btn_buttonbt_flightnumber_OKbutton = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_buttonbt_flightnumber_OKbutton");
        Btn_buttonbt_flightScribble_Txt = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_buttonbt_flightScribble_Txt");
        Connectionflt = MiscUtility.getWebElement(objFilepath, "CAP027_Connectionflt");
        Connectionflt2 = MiscUtility.getWebElement(objFilepath, "CAP027_Connectionflt2");
        Condetails = MiscUtility.getWebElement(objFilepath, "CAP027_Condetails");
        Condetails2 = MiscUtility.getWebElement(objFilepath, "CAP027_Condetails2");
        tables_CapacityTbl = MiscUtility.getWebElement(objFilepath, "CAP027_tbl_capacityTbl");

        Color_red = MiscUtility.getWebElement(objFilepath, "CAP027_Color_red");
        Color_green = MiscUtility.getWebElement(objFilepath, "CAP027_Color_green");
        ViewFltFactsbutton = MiscUtility.getWebElement(objFilepath, "CAP027_ViewFltFactsbutton");
        flightFactStatus = MiscUtility.getWebElement(objFilepath, "CAP027_flightFactStatus");
        ViewFltListbutton = MiscUtility.getWebElement(objFilepath, "CAP027_ViewFltListbutton");
        ViewFltdiv = MiscUtility.getWebElement(objFilepath, "CAP027_ViewFltdiv");
        ViewFltListClosebutton = MiscUtility.getWebElement(objFilepath, "CAP027_ViewFltListClosebutton");
        waittbl = MiscUtility.getWebElement(objFilepath, "CAP027_waittbl");
        //reassign screen
        chkBx_reassignChkAllSelFlt = MiscUtility.getWebElement(objFilepath, "CAP027_chkBx_reassignChkAllSelFlt");
        btn_reassignDltSelFlt = MiscUtility.getWebElement(objFilepath, "CAP027_btn_reassignDltSelFlt");
        ckhBx_reassignFirstFlt = MiscUtility.getWebElement(objFilepath, "CAP027_ckhBx_reassignFirstFlt");
        btn_reassignMoveList = MiscUtility.getWebElement(objFilepath, "CAP027_btn_reassignMoveList");
        btn_reassignOk = MiscUtility.getWebElement(objFilepath, "CAP027_btn_reassignOk");
        txt_flightVolume = MiscUtility.getWebElement(objFilepath, "CAP027_txt_flightVolume");
        txt_flightWeight = MiscUtility.getWebElement(objFilepath, "CAP027_txt_flightWeight");
        tbl_reassignFlt = MiscUtility.getWebElement(objFilepath, "CAP027_tbl_reassignFlt");
        //lying list
        LyingListbutton = MiscUtility.getWebElement(objFilepath, "CAP027_LyingListbutton");
        txt_lyingAwbPre = MiscUtility.getWebElement(objFilepath, "CAP027_txt_lyingAwbPre");
        txt_lyingAwbNo = MiscUtility.getWebElement(objFilepath, "CAP027_txt_lyingAwbNo");
        btn_lyingListAwb = MiscUtility.getWebElement(objFilepath, "CAP027_btn_lyingListAwb");
        chkBx_lyingCheckAll = MiscUtility.getWebElement(objFilepath, "CAP027_chkBx_lyingCheckAll");
        btn_lyingAssignToFlt = MiscUtility.getWebElement(objFilepath, "CAP027_btn_lyingAssignToFlt");
        chk_reject2 = MiscUtility.getWebElement(objFilepath, "CAP027_chk_reject2");
        chk_reject1 = MiscUtility.getWebElement(objFilepath, "CAP027_chk_reject1");
        //Disruption List
        txt_disruptionAwbPre = MiscUtility.getWebElement(objFilepath, "CAP027_txt_disruptionAwbPre");
        txt_disruptionAwbNo = MiscUtility.getWebElement(objFilepath, "CAP027_txt_disruptionAwbNo");
        btn_disruptionListAwb = MiscUtility.getWebElement(objFilepath, "CAP027_btn_disruptionListAwb");
        chkBx_disruptionCheckAll = MiscUtility.getWebElement(objFilepath, "CAP027_chkBx_disruptionCheckAll");
        btn_disruptionAssignToFlt = MiscUtility.getWebElement(objFilepath, "CAP027_btn_disruptionAssignToFlt");

        //Close Station
        btn_fltCtrlCloseStation = MiscUtility.getWebElement(objFilepath, "CAP027_btn_fltCtrlCloseStation");
        btn_closeStnAdd = MiscUtility.getWebElement(objFilepath, "CAP027_btn_closeStnAdd");
        txt_stationCode = MiscUtility.getWebElement(objFilepath, "CAP027_txt_stationCode");
        btn_stationList = MiscUtility.getWebElement(objFilepath, "CAP027_btn_stationList");
        chkBx_stationChkAll = MiscUtility.getWebElement(objFilepath, "CAP027_chkBx_stationChkAll");
        btn_stationOk = MiscUtility.getWebElement(objFilepath, "CAP027_btn_stationOk");
        btn_closeStnOk = MiscUtility.getWebElement(objFilepath, "CAP027_btn_closeStnOk");
        btn_fltCtrlClose = MiscUtility.getWebElement(objFilepath, "CAP027_btn_fltCtrlClose");

        //Close segment
        chkBx_fltCtrlSegChkAll = MiscUtility.getWebElement(objFilepath, "CAP027_chkBx_fltCtrlSegChkAll");
        btn_fltCtrlCloseSeg = MiscUtility.getWebElement(objFilepath, "CAP027_btn_fltCtrlCloseSeg");
        btn_fltCtrlOpenSeg = MiscUtility.getWebElement(objFilepath, "CAP027_btn_fltCtrlOpenSeg");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        link_genericNext = MiscUtility.getWebElement(genObjPath, "generic_next");
        Generic_info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        Btn_Queue = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_Queue");
        Btn_OK_NewWindow = MiscUtility.getWebElement(objFilepath, "CAP027_Btn_OK_NewWindow");
        
        //A-8260
        tbl_confirmedBookings = MiscUtility.getWebElement(objFilepath, "CAP027_tbl_confirmedBookings");
        txt_reAssignOrigin= MiscUtility.getWebElement(objFilepath, "CAP027_txt_OriginReassin");
        txt_reAssignDest= MiscUtility.getWebElement(objFilepath, "CAP027_txt_DestReAssign");
        btn_reAssignList= MiscUtility.getWebElement(objFilepath, "CAP027_btn_listReAssign");
        tbl_reAssignFlights= MiscUtility.getWebElement(objFilepath, "CAP027_tbl_ReAssignFlightList");
        btn_reAssignOk= MiscUtility.getWebElement(objFilepath, "CAP027_btn_reAssign_Ok");
        tab_queued=MiscUtility.getWebElement(objFilepath, "CAP027_tab_queued");
        table_queuedBooking=MiscUtility.getWebElement(objFilepath, "CAP027_tbl_queuedBooking");
        btn_reAssign_Close = MiscUtility.getWebElement(objFilepath, "CAP027_btn_reAssign_Close");
        
        txt_fltDate=MiscUtility.getWebElement(objFilepath, "CAP027_txt_fltDate");

        radio_global=MiscUtility.getWebElement(objFilepath, "CAP027_radio_global");
        radio_customer=MiscUtility.getWebElement(objFilepath, "CAP027_radio_customer");
        radio_station=MiscUtility.getWebElement(objFilepath, "CAP027_radio_station");
        radio_product=MiscUtility.getWebElement(objFilepath, "CAP027_radio_product");
        lnk_altId=MiscUtility.getWebElement(objFilepath, "CAP027_link_altId");

        
        txt_rejectWindow_irrCode = MiscUtility.getWebElement(objFilepath, "CAP027_rejectWindow_txt_irrCode");
        txt_rejectWindow_irrRem = MiscUtility.getWebElement(objFilepath, "CAP027_rejectWindow_txt_irrRem");
        btn_rejectWindow_irrOk = MiscUtility.getWebElement(objFilepath, "CAP027_rejectWindow_btn_irrOk");
        btn_rejectWindow_irrClose = MiscUtility.getWebElement(objFilepath, "CAP027_rejectWindow_btn_irrClose");
        btn_affectedBkg = MiscUtility.getWebElement(objFilepath, "CAP027_btn_affectedBkg");
        dropdown_affLeg = MiscUtility.getWebElement(objFilepath, "CAP027_dropdown_affLeg");
        tbl_affBkg = MiscUtility.getWebElement(objFilepath, "CAP027_tbl_affBkg");
        btn_affBkg_list = MiscUtility.getWebElement(objFilepath, "CAP027_btn_affBkg_list");
        
        sel_shipType=MiscUtility.getWebElement(objFilepath, "CAP027_sel_shipType");
        txt_globalCustCode=MiscUtility.getWebElement(objFilepath, "CAP027_txt_CustCode");
        btn_createAltOk=MiscUtility.getWebElement(objFilepath, "CAP027_btn_altCreateOk");
        txt_ovrBkWt=MiscUtility.getWebElement(objFilepath, "CAP027_txt_overbookingWeight");
        txt_ovrBkVol=MiscUtility.getWebElement(objFilepath, "CAP027_txt_overbookingVolume");
        btn_windowClose=MiscUtility.getWebElement(objFilepath, "CAP027_btn_winClose");
        btn_priority=MiscUtility.getWebElement(objFilepath, "CAP027_btn_priority");
        proprity_tbl_bkgDetails =MiscUtility.getWebElement(objFilepath, "CAP027_proprity_tbl_bkgDetails");
        
        dropdown_stnLevel = MiscUtility.getWebElement(objFilepath, "CAP145_dropdown_stnLevel");
    }

    /**
     * lists a flight with flight number
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @author A-7681
     * @author A-7681
     */
    private void list(String fltCar, String fltNo, String fltDt) {

        enterKeys(txt_fltCarCode, fltCar);
        enterKeys(txt_fltNo, fltNo);
        //enterKeys(txt_fltDt, fltDt);
        enterKeys(txt_fltDt, ".");
        click(btn_list);
        minWait();
    }

    /**
     * Navigates to CAP018 screen
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-7681
     */
    public CAP018 getBookingDetails(String fltCar, String fltNo, String fltDt, String awbNo) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(fltCar, fltNo, fltDt);
        minWait();
        tblSelectRowByColValue(tbl_confirmedBooking, 1, 3, awbNo);

        click(btn_viewBookingDtls);

        return new CAP018(driver, dataFileName);

    }

    /**
     * Creates a station group allotment and saves the value to data file
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param stn
     * @param wt
     * @param vol
     * @param allotId
     * @return
     * @author A-7868 Krishna <02/07/2018>
     */
    public CAP027 createStationGroupAllotment(String fltCar, String fltNo, String fltDt, String stnGrp,
                                         String wt, String vol, String allotId) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        stnGrp = PropertyHandler.getPropValue(dataFilePath, stnGrp);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);
        vol = PropertyHandler.getPropValue(dataFilePath, vol);
        
        list(fltCar, fltNo, fltDt);

        click(waitForElement(lnk_create));
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();

        click(getWebElements(rb_allotType).get(2));
        selectByText(dropdown_stnLevel, "Station Group");
        enterKeys(waitForElement(txt_station), stnGrp);
        enterKeys(txt_capWt, wt);
        enterKeys(txt_capVol, vol);
        click(btn_saveAltmnt);

        Assert.assertTrue(waitForElement(btn_createOk).isDisplayed(), "ERROR in Allotment Creation.");
        click(btn_createOk);
       
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
               
        List<String> id = getTableColumnValues(table_allotment, 2); //get values within column2
        PropertyHandler.setPropValue(dataFilePath, allotId, id.get(0));

        Assert.assertEquals(id.get(0).substring(0, 2), stnGrp.substring(0, 2), "First 3 letters of AllotId should be that of Station Group");
        return this;
    }
    
    /**
     * Method to list a flight, select a station group allotment and validate the allotment details
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param stnGrp
     * @param wt
     * @param vol
     * @param allotId
     * @return
     * @author A-7868 Krishna <02/07/2018>
     */
    public CAP027 listAndVerifyStationGroupAllotment(String fltCar, String fltNo, String fltDt, String stnGrp, String allotId) {

		fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		stnGrp = PropertyHandler.getPropValue(dataFilePath, stnGrp);
		allotId = PropertyHandler.getPropValue(dataFilePath, allotId);
		boolean isTextField = true;
		
		list(fltCar, fltNo, fltDt);
		
		waitForElement(table_allotment).findElement(By.xpath("./td[contains(.,'"+allotId+"')]")).click();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();		
		click(getWebElements(rb_allotType).get(2));
		
		Select select = new Select(waitForElement(dropdown_stnLevel));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Station Group", "Mismatch in Station level dropdown");
		Assert.assertEquals(waitForElement(dropdown_stnLevel).getText(), stnGrp, "Mismatch in Station Group name");
		try{
			isTextField = waitForElement(txt_station).isEnabled();
		}catch(Exception e){
			isTextField = false;
		}
		Assert.assertFalse(isTextField, "Station is not Read-only");
						
		closeAndmoveToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		
		return this;
	}
    
    public CAP027 createStationAllotment(String fltCar, String fltNo, String fltDt, String stn,
            String wt, String vol, String allotId) {

		fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		stn = PropertyHandler.getPropValue(dataFilePath, stn);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		
		list(fltCar, fltNo, fltDt);
		
		click(waitForElement(lnk_create));
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		click(getWebElements(rb_allotType).get(2));
		enterKeys(waitForElement(txt_station), stn);
		enterKeys(txt_capWt, wt);
		enterKeys(txt_capVol, vol);
		click(btn_saveAltmnt);
		
		Assert.assertTrue(waitForElement(btn_createOk).isDisplayed(), "ERROR in Allotment Creation.");
		click(btn_createOk);
		
		
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		
		
		List<String> id = getTableColumnValues(table_allotment, 2); //get values within column2
		System.out.println(id.get(0));
		PropertyHandler.setPropValue(dataFilePath, allotId, id.get(0));
		
		//click(waitForElement(btn_close));
		
		return this;
		}
    /**
     * @author A-8260
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param stn
     * @param wt
     * @param vol
     * @param allotId
     * @param altType
     * @return
     */
    public CAP027 createAllotment(String fltCar, String fltNo, String fltDt, String stn,
            String wt, String vol, String allotId, String altType) {

		fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		stn = PropertyHandler.getPropValue(dataFilePath, stn);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		altType=PropertyHandler.getPropValue(dataFilePath, altType);
		list(fltCar, fltNo, fltDt);
		
		click(waitForElement(lnk_create));
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		if(altType.equalsIgnoreCase("Global")&&(waitForElement(radio_global).getAttribute("checked").equals("true")))
		click(radio_global);
		else if(altType.equalsIgnoreCase("Product")&&!(waitForElement(radio_product).getAttribute("checked").equals("true")))
		click(radio_product);
		else if(altType.equalsIgnoreCase("Customer")&&!(waitForElement(radio_customer).getAttribute("checked").equals("true")))
		click(radio_customer);
		else if(altType.equalsIgnoreCase("Station")&&!(waitForElement(radio_station).getAttribute("checked").equals("true")))
		click(radio_station);
		
		//click(getWebElements(rb_allotType).get(2));
		enterKeys(waitForElement(txt_station), stn);
		enterKeys(txt_capWt, wt);
		enterKeys(txt_capVol, vol);
		click(btn_saveAltmnt);
		
		Assert.assertTrue(waitForElement(btn_createOk).isDisplayed(), "ERROR in Allotment Creation.");
		click(btn_createOk);
		minWait();
		
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		
		
		List<String> id = getTableColumnValues(table_allotment, 2); //get values within column2
		System.out.println(id.get(0));
		PropertyHandler.setPropValue(dataFilePath, allotId, id.get(0));
		
		//click(waitForElement(btn_close));
		
		return this;
}
    
    public CAP027 createGlobalCustomerAllotment(String fltCar, String fltNo, String fltDt, String stn,
            String wt, String vol, String allotId,String custcode)
    {
    	fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		stn = PropertyHandler.getPropValue(dataFilePath, stn);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		custcode=PropertyHandler.getPropValue(dataFilePath, custcode);
		list(fltCar, fltNo, fltDt);
		
		click(waitForElement(lnk_create));
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		selectByText(sel_shipType, "Loose");
		enterKeys(txt_globalCustCode, custcode);
		enterKeys(txt_capWt, wt);
		enterKeys(txt_capVol, vol);
		click(btn_saveAltmnt);
		minWait();
		click(btn_createAltOk);		
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
    	return this;
    }
    public CAP027 createGlobalCustomerAllotmentOverbookingWtAndVol(String fltCar, String fltNo, String fltDt, String stn,
            String wt, String vol, String allotId,String custcode)
    {
    	fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		stn = PropertyHandler.getPropValue(dataFilePath, stn);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		custcode=PropertyHandler.getPropValue(dataFilePath, custcode);
		list(fltCar, fltNo, fltDt);
		
		click(waitForElement(lnk_create));
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		selectByText(sel_shipType, "Loose");
		enterKeys(txt_globalCustCode, custcode);
		enterKeys(txt_capWt, wt);
		enterKeys(txt_capVol, vol);
		enterKeys(txt_capWt, wt);
    	enterKeys(txt_capVol, vol);
		click(btn_saveAltmnt);
		minWait();
		click(btn_createAltOk);		
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
    	return this;
    }
    /**
     * @author A-8260
     * @return
     */
    public CAP027 modifyAllotment(String fltCar, String fltNo, String fltDt,String wt, String vol)
    {
    	fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
    	fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
    	fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
    	wt = PropertyHandler.getPropValue(dataFilePath, wt);
    	vol = PropertyHandler.getPropValue(dataFilePath, vol);
    	list(fltCar, fltNo, fltDt);
    	click(lnk_altId);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(txt_capWt, wt);
    	enterKeys(txt_capVol, vol);
    	click(btn_saveAltmnt);
    	if(verifyElementPresent(btn_genericOk))
    		click(btn_genericOk);
    	minWait();
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	
    	return this;
    }
    
	public CAP027 modifyAllotmentOverbookingWtAndVol(String fltCar, String fltNo, String fltDt,String wt, String vol)
    {
    	fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
    	fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
    	fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
    	wt = PropertyHandler.getPropValue(dataFilePath, wt);
    	vol = PropertyHandler.getPropValue(dataFilePath, vol);
    	list(fltCar, fltNo, fltDt);
    	click(lnk_altId);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(txt_ovrBkWt, wt);
    	enterKeys(txt_ovrBkVol, vol);
    	click(btn_saveAltmnt);
    	if(verifyElementPresent(btn_genericOk))
    		click(btn_genericOk);
    	minWait();
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	
    	return this;
    }

	public CAP027 verifyOverbookingWeightAndVolume(String fltCar, String fltNo, String fltDt,String wt, String vol)
	{
		fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
    	fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
    	fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
    	wt = PropertyHandler.getPropValue(dataFilePath, wt);
    	vol = PropertyHandler.getPropValue(dataFilePath, vol);
    	
    	click(lnk_altId);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	Assert.assertTrue(waitForElement(txt_ovrBkWt).getAttribute("value").equals(wt),"Overbooking weight should match the system weight");
    	Assert.assertTrue(waitForElement(txt_ovrBkVol).getAttribute("value").equals(wt),"Overbooking volume should match the system volume");
    	
    	click(btn_windowClose);
    	minWait();
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
		return this;
	}
    
    
    
    /**
     * Checks the flight capacity sales is as per the given parameters
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param expWt
     * @param expVol
     * @return
     * @author Arun A-7681
     */
    public CAP027 checkFlightCpacitySales(String carrCode, String fltNo, String fltDt, String expWt, String expVol) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        expWt = PropertyHandler.getPropValue(dataFilePath, expWt);
        expVol = PropertyHandler.getPropValue(dataFilePath, expVol);

        list(carrCode, fltNo, fltDt);

        click(btn_viewCapSumry);

        waitForNewWindow(2);
        switchToSecondWindow();

        String totWt = tblGetTextByColValue(list_tblCapacityTbl, 2, 1, "Total Capacity - Sales");
        String totVol = tblGetTextByColValue(list_tblCapacityTbl, 3, 1, "Total Capacity - Sales");

        Assert.assertTrue(expWt.equals(totWt.trim()));
        Assert.assertTrue(expVol.equals(totVol.trim()));

        click(btn_capSmryClose);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * Checks the flight capacity sales is as per the given parameters
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param expWt
     * @param expVol
     * @return
     * @author A-6545
     */
    public CAP027 checkviewcapposition(String carrCode, String fltNo, String fltDt) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);


        list(carrCode, fltNo, fltDt);

        click(btn_viewCapSumry);

        waitForNewWindow(2);
        switchToSecondWindow();

        String L3 = tblGetTextByColValue(list_tblCapacityTbl, 4, 1, "Total Capacity - Sales");
        String rem_L3 = tblGetTextByColValue(list_tblCapacityTbl, 4, 1, "RemainingFS Capacity - Sales");
        int value = Integer.parseInt(L3) - 1;
        String temp = String.valueOf(value);
        Assert.assertTrue(rem_L3.equalsIgnoreCase(temp));


        click(btn_capSmryClose);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * Checks the flight capacity sales is as per the given parameters
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param expWt
     * @param expVol
     * @return
     * @author A-6545
     */
    public CAP027 colorindicates(String carrCode, String fltNo, String fltDt, String input1, String input2) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

        list(carrCode, fltNo, fltDt);
        driver.switchTo().defaultContent();
        click(btn_genericOk);
        waitForFrameAndSwitch(FRAME);
        Assert.assertTrue(waitForElement(Color_red).getAttribute("src").contains(input1));
        Assert.assertTrue(waitForElement(Color_green).getAttribute("src").contains(input2));
        return this;
    }

    /**
     * Checks the flight capacity sales is as per the given parameters
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param wtOfChangedSeg
     * @param wtOfOtherSeg
     * @return
     * @author Arun A-7681
     */
    public CAP027 checkFlightProvidedCpacitySalesMultiLeg(String carrCode, String fltNo, String fltDt, String wtOfChangedSeg, String wtOfOtherSeg, String type) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        wtOfChangedSeg = PropertyHandler.getPropValue(dataFilePath, wtOfChangedSeg);
        wtOfOtherSeg = PropertyHandler.getPropValue(dataFilePath, wtOfOtherSeg);
        String providedWt = null;

        list(carrCode, fltNo, fltDt);

        click(btn_viewCapSumry);

        waitForNewWindow(2);
        switchToSecondWindow();

        List<WebElement> tableList = getWebElements(list_tblCapacityTbl);


        providedWt = tblGetTextByColValue(tableList.get(0), 2, 1, "Provided Capacity - Sales");
        Assert.assertEquals(wtOfOtherSeg, providedWt.trim());
        providedWt = tblGetTextByColValue(tableList.get(1), 2, 1, "Provided Capacity - Sales");
        Assert.assertEquals(wtOfChangedSeg, providedWt.trim());
        providedWt = tblGetTextByColValue(tableList.get(2), 2, 1, "Provided Capacity - Sales");
        Assert.assertEquals(wtOfOtherSeg, providedWt.trim());

       /* if (type.equalsIgnoreCase("GSC")) {
            providedWt = tblGetTextByColValue(tableList.get(0),2,1,"Provided Capacity - Sales");
            Assert.assertTrue(wtOfOtherSeg.equals(providedWt.trim()));
            providedWt = tblGetTextByColValue(tableList.get(1),2,1,"Provided Capacity - Sales");
            Assert.assertTrue(wtOfChangedSeg.equals(providedWt.trim()));
            providedWt = tblGetTextByColValue(tableList.get(2),2,1,"Provided Capacity - Sales");
            Assert.assertTrue(wtOfOtherSeg.equals(providedWt.trim()));
        } else if (type.equalsIgnoreCase("SCL"))  {
            providedWt = tblGetTextByColValue(tableList.get(0),2,1,"Provided Capacity - Sales");
            Assert.assertTrue(wtOfChangedSeg.equals(providedWt.trim()));
            providedWt = tblGetTextByColValue(tableList.get(1),2,1,"Provided Capacity - Sales");
            Assert.assertTrue(wtOfOtherSeg.equals(providedWt.trim()));
            providedWt = tblGetTextByColValue(tableList.get(2),2,1,"Provided Capacity - Sales");
            Assert.assertTrue(wtOfChangedSeg.equals(providedWt.trim()));
        }  else {
            providedWt = tblGetTextByColValue(tableList.get(0),2,1,"Provided Capacity - Sales");
            Assert.assertTrue(wtOfChangedSeg.equals(providedWt.trim()));
            providedWt = tblGetTextByColValue(tableList.get(1),2,1,"Provided Capacity - Sales");
            Assert.assertTrue(wtOfOtherSeg.equals(providedWt.trim()));
            providedWt = tblGetTextByColValue(tableList.get(2),2,1,"Provided Capacity - Sales");
            Assert.assertTrue(wtOfChangedSeg.equals(providedWt.trim()));
        }*/

        click(btn_capSmryClose);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * Created by A-7605
     *
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param defaultWeight
     * @param defaultVolume
     * @return
     */
    public CAP027 checkCapacitySummaryAfterOverridingSegmentCapacity(String carrierCode, String flightNo, String flightDate, String defaultWeight, String defaultVolume) {
        carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
        flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
        flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);

        list(carrierCode, flightNo, flightDate);
        click(btn_viewCapSumry);
        waitForNewWindow(2);
        switchToSecondWindow();

        String firstSegmentCapacitySalesWeight = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 2, 1, "Provided Capacity - Sales");
        String firstSegmentCapacitySalesVolume = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 3, 1, "Provided Capacity - Sales");
        String firstSegmentCapacitySalesL3 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 4, 1, "Provided Capacity - Sales");
        String firstSegmentCapacitySalesL7 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 5, 1, "Provided Capacity - Sales");
        String firstSegmentCapacitySalesQ6 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 6, 1, "Provided Capacity - Sales");
        String firstSegmentCapacitySalesQ7 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 7, 1, "Provided Capacity - Sales");

        String firstSegmentCapacityHandlingWeight = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 2, 1, "Provided Capacity - Handling");
        String firstSegmentCapacityHandlingVolume = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 3, 1, "Provided Capacity - Handling");
        String firstSegmentCapacityHandlingL3 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 4, 1, "Provided Capacity - Handling");
        String firstSegmentCapacityHandlingL7 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 5, 1, "Provided Capacity - Handling");
        String firstSegmentCapacityHandlingQ6 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 6, 1, "Provided Capacity - Handling");
        String firstSegmentCapacityHandlingQ7 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 7, 1, "Provided Capacity - Handling");

        Assert.assertTrue(defaultWeight.equals(firstSegmentCapacitySalesWeight));
        Assert.assertTrue(defaultVolume.equals(firstSegmentCapacitySalesVolume));
        Assert.assertTrue("0".equals(firstSegmentCapacitySalesL3));
        Assert.assertTrue("0".equals(firstSegmentCapacitySalesL7));
        Assert.assertTrue("0".equals(firstSegmentCapacitySalesQ6));
        Assert.assertTrue("0".equals(firstSegmentCapacitySalesQ7));

        Assert.assertTrue(defaultWeight.equals(firstSegmentCapacityHandlingWeight));
        Assert.assertTrue(defaultVolume.equals(firstSegmentCapacityHandlingVolume));
        Assert.assertTrue("0".equals(firstSegmentCapacityHandlingL3));
        Assert.assertTrue("0".equals(firstSegmentCapacityHandlingL7));
        Assert.assertTrue("0".equals(firstSegmentCapacityHandlingQ6));
        Assert.assertTrue("0".equals(firstSegmentCapacityHandlingQ7));

        click(btn_capSmryClose);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        return this;
    }


    /**
     * Checks the flight capacity sales is as per the given parameters
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param capacityValue
     * @param capacityType
     * @return
     * @author Arun A-7681
     */
    public CAP027 checkCapacityDetailsSingleLeg(String carrCode, String fltNo, String fltDt, String capacityValue, String capacityType) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        capacityValue = PropertyHandler.getPropValue(dataFilePath, capacityValue);
        String providedWt = null;

        list(carrCode, fltNo, fltDt);

        click(btn_viewCapSumry);

        waitForNewWindow(2);
        switchToSecondWindow();

        providedWt = tblGetTextByColValue(list_tblCapacityTbl, 2, 1, capacityType);
        Assert.assertTrue(capacityValue.equals(providedWt.trim()));

        click(btn_capSmryClose);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * Checks the flight capacity utilization is as per the given parameters
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param shipmntWtUtil
     * @return
     * @author Arun A-7681
     */
    public CAP027 checkCapacityUtilizationWtSingleLeg(String carrCode, String fltNo, String fltDt, String shipmntWtUtil) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        shipmntWtUtil = PropertyHandler.getPropValue(dataFilePath, shipmntWtUtil);
        String providedWt = null;
        String usedWt = null;
        String depletedWt = null;

        list(carrCode, fltNo, fltDt);

        click(btn_viewCapSumry);

        waitForNewWindow(2);
        switchToSecondWindow();

        providedWt = tblGetTextByColValue(list_tblCapacityTbl, 2, 1, "Provided Capacity - Sales");
        usedWt = tblGetTextByColValue(list_tblCapacityTbl, 2, 1, "Total Consumed Capacity");
        depletedWt = String.valueOf(Integer.parseInt(providedWt) - Integer.parseInt(usedWt));
        Assert.assertEquals(shipmntWtUtil, usedWt.trim());
        Assert.assertEquals(depletedWt, tblGetTextByColValue(list_tblCapacityTbl, 2, 1, "RemainingFS Capacity - Sales").trim());

        click(btn_capSmryClose);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    
    /**
     * Method to verify the total consumed weight with given parameter
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param wt
     * @return
     * @author A-7868 Krishna <27/03/2018>
     */
    public CAP027 checkTotalConsumedCapacity(String carrCode, String fltNo, String fltDt, String wt) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);
        

        list(carrCode, fltNo, fltDt);

        click(btn_viewCapSumry);

        waitForNewWindow(2);
        switchToSecondWindow();
        
        Assert.assertTrue(wt.equals(tblGetTextByColValue(list_tblCapacityTbl, 2, 1, "Total Consumed Capacity").trim()));

        click(btn_capSmryClose);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }
    

    /**
     * Checks the flight capacity utilization is as per the given parameters
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @return
     * @author Arun A-7681
     */
    public CAP027 checkCapacityUtilizationULDPosSingleLeg(String carrCode, String fltNo, String fltDt) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        String totPos = null;
        String depletedPos = null;

        list(carrCode, fltNo, fltDt);

        click(btn_viewCapSumry);

        waitForNewWindow(2);
        switchToSecondWindow();

        totPos = tblGetTextByColValue(list_tblCapacityTbl, 4, 1, "Provided Capacity - Sales");
        depletedPos = String.valueOf(Integer.parseInt(totPos) - 1);
        Assert.assertEquals(depletedPos, tblGetTextByColValue(list_tblCapacityTbl, 3, 1, "RemainingFS Capacity - Sales").trim());

        click(btn_capSmryClose);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }


    /**
     * Created by A-7605
     *
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param defaultWeight
     * @param defaultVolume
     * @param gscWeight
     * @param gscVolume
     * @param l3
     * @param l7
     * @param q6
     * @param q7
     * @return
     */
    public CAP027 checkCapacitySummary(String carrierCode, String flightNo, String flightDate, String defaultWeight, String defaultVolume, String gscWeight, String gscVolume,
                                       String l3, String l7, String q6, String q7) {
        carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
        flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
        flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
        defaultWeight = PropertyHandler.getPropValue(dataFilePath, defaultWeight);
        defaultVolume = PropertyHandler.getPropValue(dataFilePath, defaultVolume);
        gscWeight = PropertyHandler.getPropValue(dataFilePath, gscWeight);
        gscVolume = PropertyHandler.getPropValue(dataFilePath, gscVolume);
        l3 = PropertyHandler.getPropValue(dataFilePath, l3);
        l7 = PropertyHandler.getPropValue(dataFilePath, l7);
        q6 = PropertyHandler.getPropValue(dataFilePath, q6);
        q7 = PropertyHandler.getPropValue(dataFilePath, q7);

        list(carrierCode, flightNo, flightDate);
        click(btn_viewCapSumry);
        waitForNewWindow(2);
        switchToSecondWindow();

        String firstSegmentCapacitySalesWeight = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 2, 1, "Provided Capacity - Sales");
        String firstSegmentCapacitySalesVolume = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 3, 1, "Provided Capacity - Sales");
        String firstSegmentCapacitySalesL3 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 4, 1, "Provided Capacity - Sales");
        String firstSegmentCapacitySalesL7 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 5, 1, "Provided Capacity - Sales");
        String firstSegmentCapacitySalesQ6 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 6, 1, "Provided Capacity - Sales");
        String firstSegmentCapacitySalesQ7 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 7, 1, "Provided Capacity - Sales");

        String firstSegmentCapacityHandlingWeight = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 2, 1, "Provided Capacity - Handling");
        String firstSegmentCapacityHandlingVolume = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 3, 1, "Provided Capacity - Handling");
        String firstSegmentCapacityHandlingL3 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 4, 1, "Provided Capacity - Handling");
        String firstSegmentCapacityHandlingL7 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 5, 1, "Provided Capacity - Handling");
        String firstSegmentCapacityHandlingQ6 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 6, 1, "Provided Capacity - Handling");
        String firstSegmentCapacityHandlingQ7 = tblGetTextByColValue(getWebElements(tables_CapacityTbl).get(0), 7, 1, "Provided Capacity - Handling");

        Assert.assertEquals(gscWeight,firstSegmentCapacitySalesWeight);
        Assert.assertEquals(gscVolume,firstSegmentCapacitySalesVolume);
        Assert.assertEquals(l3,firstSegmentCapacitySalesL3);
        Assert.assertEquals(l7,firstSegmentCapacitySalesL7);
        Assert.assertEquals(q6,firstSegmentCapacitySalesQ6);
        Assert.assertEquals(q7,firstSegmentCapacitySalesQ7);

        Assert.assertEquals(gscWeight,firstSegmentCapacityHandlingWeight);
        Assert.assertEquals(gscVolume,firstSegmentCapacityHandlingVolume);
        Assert.assertEquals(l3,firstSegmentCapacityHandlingL3);
        Assert.assertEquals(l7,firstSegmentCapacityHandlingL7);
        Assert.assertEquals(q6,firstSegmentCapacityHandlingQ6);
        Assert.assertEquals(q7,firstSegmentCapacityHandlingQ7);

        click(btn_capSmryClose);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        return this;
    }

    /**
     * Checks the flight capacity utilization volume is as per the given parameters
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param shipmntWtUtil
     * @return
     * @author Arun A-7681
     */
    public CAP027 checkCapacityUtilizationVolSingleLeg(String carrCode, String fltNo, String fltDt, String shipmntWtUtil) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        shipmntWtUtil = PropertyHandler.getPropValue(dataFilePath, shipmntWtUtil);
        String providedWt = null;
        String usedWt = null;
        String depletedWt = null;

        list(carrCode, fltNo, fltDt);

        click(btn_viewCapSumry);

        waitForNewWindow(2);
        switchToSecondWindow();

        providedWt = tblGetTextByColValue(list_tblCapacityTbl, 3, 1, "Provided Capacity - Sales");
        usedWt = tblGetTextByColValue(list_tblCapacityTbl, 3, 1, "Total Consumed Capacity");
        depletedWt = String.valueOf(Integer.parseInt(providedWt) - Integer.parseInt(usedWt));
        Assert.assertTrue(shipmntWtUtil.equals(usedWt.trim()));
        Assert.assertTrue(depletedWt.equals(tblGetTextByColValue(list_tblCapacityTbl, 3, 1, "RemainingFS Capacity - Sales").trim()));

        click(btn_capSmryClose);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * reassigns the bookin in the flight
     *
     * @return
     * @author Arun A-7681
     */
    public CAP027 reassign(String carrCode, String fltNo, String fltDt, String fltNo2, String awbNo) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        fltNo2 = PropertyHandler.getPropValue(dataFilePath, fltNo2);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        boolean flag = false;

        list(carrCode, fltNo, fltDt);

        tblSelectRowByColValue(tbl_bookings, 1, 3, awbNo);
        scrollToView(btn_reAssign);
        click(btn_reAssign);
        waitForNewWindow(2);
        switchToSecondWindow();
        scrollToView(chkBx_reassignChkAllSelFlt);
        check(chkBx_reassignChkAllSelFlt);
        click(btn_reassignDltSelFlt);
        scrollToView(ckhBx_reassignFirstFlt);
        while (true) {
            if (verifyValuePresentInTblColumn(tbl_reassignFlt, 2,fltNo2)) {
                flag = true;
                break;
            }

            try {
                click(link_genericNext);
            } catch (NoSuchElementException | TimeoutException e1) {
                break;
            }
        }

        Assert.assertTrue(flag, "The flight number " + fltNo2 + " is not listed in the export flight listing.");
        tblSelectRowByColValue(tbl_reassignFlt, 1, 2, fltNo2);
        click(btn_reassignMoveList);
        click(btn_reassignOk);

        while (verifyElementPresent(btn_genericYes)) {
            click(btn_genericYes);
        }

        waitForNewWindow(3);
        switchToNthWindow(3);
        if (verifyElementPresent(Irregularity_Inbx_irregularityCode)) {

            enterKeys(waitForElement(Irregularity_Inbx_irregularityCode), "Flight Change");
            enterKeys(Irregularity_Inbx_irregularityRemarks, "Flight Change");
            click(Irregularity_Btn_OKbutton);
        }

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * 
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-7868 Krishna <10/05/2018>
     */
    /**
     * Method to reassign a confirmed booking to a random flight
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @param errorChk
     * @param errMsg (can be "" if error check is false)
     * @return
     */
    public CAP027 reassignToRandomFlight(String carrCode, String fltNo, String fltDt, String awbNo, boolean errorChk, String errMsg) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(carrCode, fltNo, fltDt);

        tblSelectRowByColValue(tbl_bookings, 1, 3, awbNo);
        scrollToView(btn_reAssign);
        click(btn_reAssign);
        waitForNewWindow(2);
        switchToSecondWindow();
        minWait();
        
        scrollToView(chkBx_reassignChkAllSelFlt);
        check(chkBx_reassignChkAllSelFlt);
        click(btn_reassignDltSelFlt);
        scrollToView(ckhBx_reassignFirstFlt);
        
        check(waitForElement(tbl_reassignFlt).findElement(By.xpath("//*[@id='selectFlightDetails']")));
        click(btn_reassignMoveList);
        click(btn_reassignOk);

        while (verifyElementPresent(btn_genericYes)) {
            click(btn_genericYes);
        }

       if(errorChk){
    	   Assert.assertTrue(waitForElement(info_error).getText().contains(errMsg), "Error Message mismatch.");
    	   click(btn_reAssign_Close);
       }
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }
    
    /**
     * clears the form
     *
     * @return
     * @author A-7681 Arun
     */
    public CAP027 clear() {
        click(btn_clear);
        return this;
    }

    /**
     * reassigns the booking in the flight after comming from FLT002 screen
     *
     * @return
     * @author Arun A-7681
     */
    public CAP027 reassignFlightFromFLT002() {

        minWait();
        check(chkBx_chkAllBookings);
        scrollToView(btn_reAssign);
        click(btn_reAssign);
        waitForNewWindow(2);
        switchToSecondWindow();
        scrollToView(chkBx_reassignChkAllSelFlt);
        check(chkBx_reassignChkAllSelFlt);
        click(btn_reassignDltSelFlt);
        scrollToView(ckhBx_reassignFirstFlt);
        check(ckhBx_reassignFirstFlt);
        click(btn_reassignMoveList);
        click(btn_reassignOk);

        while (verifyElementPresent(btn_genericYes)) {
            click(btn_genericYes);
        }
        waitForNewWindow(3);
        switchToNthWindow(3);
        if (verifyElementPresent(Irregularity_Inbx_irregularityCode)) {

            enterKeys(waitForElement(Irregularity_Inbx_irregularityCode), "Flight Change");
            enterKeys(Irregularity_Inbx_irregularityRemarks, "Flight Change");
            click(Irregularity_Btn_OKbutton);
        }
        switchToFirstWindow();
        waitForFrameAndSwitch("iCargoContentFrameFLT002");

        return this;
    }

    /**
     * Assign a shipment from Lying List
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @return
     */
    public CAP027 assignFromLyingList(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(carrCode, fltNo, fltDt);
        click(btn_lyingList);
        enterKeys(txt_lyingAwbPre, awbPre);
        enterKeys(txt_lyingAwbNo, awbNo);
        click(btn_lyingListAwb);
        minWait();
        check(chkBx_lyingCheckAll);
        scrollToView(btn_lyingAssignToFlt);
        click(btn_lyingAssignToFlt);

        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericNo)) {
            click(btn_genericNo);
            waitForFrameAndSwitch(FRAME);
        }
        click(btn_lyingAssignToFlt);
        driver.switchTo().defaultContent();
        while (verifyElementPresent(btn_genericYes)) {
            click(btn_genericYes);
            waitForFrameAndSwitch(FRAME);
        }
        driver.switchTo().defaultContent();
        click(btn_genericOk);

        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * Assign a shipment from Disruption List
     *
     * @param carrCode
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @return
     */
    public CAP027 assignFromDisruptionList(String carrCode, String fltNo2, String fltDt, String awbPre, String awbNo) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo2 = PropertyHandler.getPropValue(dataFilePath, fltNo2);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(carrCode, fltNo2, fltDt);
        click(btn_disruptionList);
        minWait();


        enterKeys(txt_disruptionAwbPre, awbPre);
        enterKeys(txt_disruptionAwbNo, awbNo);
        click(btn_disruptionListAwb);
        check(chkBx_disruptionCheckAll);
        scrollToView(btn_disruptionAssignToFlt);
        click(btn_disruptionAssignToFlt);

        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericNo)) {
            click(btn_genericNo);
        }
        waitForFrameAndSwitch(FRAME);
        click(btn_disruptionAssignToFlt);
        driver.switchTo().defaultContent();
        while (verifyElementPresent(btn_genericYes)) {
            click(btn_genericYes);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        click(btn_genericOk);

        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * Close the specified station for the flight
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param station
     * @return
     * @author Arun A-7681
     */
    public CAP027 closeStation(String carrCode, String fltNo, String fltDt, String station) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        station = PropertyHandler.getPropValue(dataFilePath, station);
        list(carrCode, fltNo, fltDt);

        click(btn_fltControls);

        waitForNewWindow(2);
        switchToSecondWindow();
        click(btn_fltCtrlCloseStation);

        waitForNewWindow(3);
        switchToNthWindow(3);
        click(btn_closeStnAdd);

        waitForNewWindow(4);
        switchToNthWindow(4);
        enterKeys(txt_stationCode, station);
        click(btn_stationList);
        check(chkBx_stationChkAll);
        click(btn_stationOk);

        switchToNthWindow(3);
        click(btn_closeStnOk);

        switchToNthWindow(2);
        click(btn_fltCtrlClose);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }


    /**
     * Close Segemnt for an flight
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @return
     */
    public CAP027 closeSegment(String carrCode, String fltNo, String fltDt) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        list(carrCode, fltNo, fltDt);

        click(btn_fltControls);

        waitForNewWindow(2);
        switchToSecondWindow();
        check(chkBx_fltCtrlSegChkAll);
        click(btn_fltCtrlCloseSeg);
        minWait();
        click(btn_fltCtrlClose);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }


    /**
     * Close Segemnt for an flight
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @return
     */
    public CAP027 openSegment(String carrCode, String fltNo, String fltDt) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        list(carrCode, fltNo, fltDt);

        click(btn_fltControls);

        waitForNewWindow(2);
        switchToSecondWindow();
        check(chkBx_fltCtrlSegChkAll);
        click(btn_fltCtrlOpenSeg);
        minWait();

        while (verifyElementPresent(btn_genericOk)) {

            click(btn_genericOk);
        }
        click(btn_fltCtrlClose);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    public CAP027 confirmQueuedBooking(String carrCode, String fltNo, String fltDt, String awbNo) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        list(carrCode, fltNo, fltDt);

        click(tab_queuedBooking);
        tblSelectRowByColValue(tbl_queuedBooking, 1, 3, awbNo);
        scrollToView(btn_confirm);
        click(btn_confirm);

        return this;
    }

    /**
     * Closes the screen and go to screen FLT002
     *
     * @return
     * @author A-7681
     */
    public FLT002 closeToFLT002() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        waitForFrameAndSwitch("iCargoContentFrameFLT002");
        return new FLT002(driver, dataFileName);
    }

    /**
     * Navigates to CAP018 screen
     * ChkBx_CheckAllCnfBookings
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 MarkPreCarriage(String fltCar, String fltNo, String fltDt, String awbPre, String awbNo, String precarriageType) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);


        list(fltCar, fltNo, fltDt);
        minWait();
        click(MarkPreCarriagebutton_btn);

        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(waitForElement(MarkPreCarriage_txt_pref), awbPre);
        enterKeys(MarkPreCarriage_txt_awb, awbNo);

        click(MarkPreCarriage_Btn_List);
        minWait();
        driver.switchTo().defaultContent();
        minWait();
        click(MarkPreCarriage_chkbox_shipPreCheckbox);
        click(MarkPreCarriage_Btn_MoveToListbutton);
        minWait();
        scrollToView(MarkPreCarriage_Select_precarriageType);
        selectByText(MarkPreCarriage_Select_precarriageType, precarriageType);
        System.out.println(precarriageType);
        click(MarkPreCarriage_Btn_Savebutton);
        click(waitForElement(btn_genericNo));
        minWait();
        click(MarkPreCarriage_Btn_Savebutton);
        click(waitForElement(btn_genericYes));
        driver.switchTo().defaultContent();
        while (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
            waitForNewWindow(2);
        }
        if (precarriageType.equalsIgnoreCase("Update Booking")) {
            waitForNewWindow(3);
            switchToNthWindow(3);
            if (verifyElementPresent(Irregularity_Inbx_irregularityCode)) {

                enterKeys(waitForElement(Irregularity_Inbx_irregularityCode), "Flight Change");
                enterKeys(Irregularity_Inbx_irregularityRemarks, "Flight Change");
                click(Irregularity_Btn_OKbutton);
            }
        }
        //switch back to main window
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return new CAP027(driver, dataFileName);

    }

    /**
     * Navigates to CAP018 screen
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 Multi_Reassign(String fltCar, String fltNo, String fltDt) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);


        list(fltCar, fltNo, fltDt);
        minWait();
        click(ChkBx_CheckAllCnfBookings);
        check(ChkBx_CheckAllCnfBookings);
        scrollToView(Btn_Reassignbutton);
        click(Btn_Reassignbutton);
        minWait();
        waitForNewWindow(2);
        switchToSecondWindow();

        click(Reassign_chkbox_shipPreCheckbox);
        click(Btn_Reassign_MoveToListbutton);
        minWait();
        scrollToView(Reassign_selectedFlightSelectAllcheckbox);
        //    enterKeys(waitForElement(txt_flightVolume), "10");
        //     enterKeys(waitForElement(txt_flightWeight), "100");

        click(Btn_Reassign_OKbutton);

        while (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
            waitForNewWindow(2);
        }
        if (verifyElementPresent(Check_Embargo_Btn_Continue)) {
            waitForNewWindow(2);
            switchToSecondWindow();
            //  	Assert.assertTrue(tblGetTextByColValue(Table_CheckRestriction, 1, 3, "info").contains("info"));
            click(Check_Embargo_Btn_Continue);
            waitForFrameAndSwitch(FRAME);
        }
        waitForNewWindow(3);
        switchToNthWindow(3);
        if (verifyElementPresent(Irregularity_Inbx_irregularityCode)) {

            enterKeys(waitForElement(Irregularity_Inbx_irregularityCode), "Flight Change");
            enterKeys(Irregularity_Inbx_irregularityRemarks, "Flight Change");
            click(Irregularity_Btn_OKbutton);
        }
        //switch back to main window
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);


        return new CAP027(driver, dataFileName);
    }

    /**
     * Navigates to CAP018 screen
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 Generate_FBL(String fltCar, String fltNo, String fltDt) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);


        list(fltCar, fltNo, fltDt);
        minWait();
        check(ChkBx_CheckAllCnfBookings);

        click(GenerateFBLbutton);
        minWait();
        driver.switchTo().defaultContent();
        click(btn_genericOk);
        waitForFrameAndSwitch(FRAME);

        return new CAP027(driver, dataFileName);

    }

    /**
     * Navigates to CAP018 screen
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 Waitlisted(String fltCar, String fltNo, String fltDt, String awbNo) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(fltCar, fltNo, fltDt);
        minWait();
        click(btn_WaitlistedBook_tab);
        minWait();

        Assert.assertTrue(waitForElement(waittbl).getText().contains(awbNo));


        return new CAP027(driver, dataFileName);

    }

    /**
     * Navigates to CAP018 screen
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 Multi_Reject(String fltCar, String fltNo, String fltDt, String FullawbNo, String FullawbNo2) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        FullawbNo = PropertyHandler.getPropValue(dataFilePath, FullawbNo);

        list(fltCar, fltNo, fltDt);
        minWait();
        scrollToView(Btn_Rejectbutton);
        //check(chk_reject1);
        String[] awb = FullawbNo.split("-");
        tblSelectRowByColValue(table_bookingConfirm, 1, 3, awb[0]+" - "+awb[1]);
        click(Btn_Rejectbutton);
        minWait();
        driver.switchTo().defaultContent();
        click(waitForElement(btn_genericYes));
        waitForFrameAndSwitch(FRAME);
       /* waitForNewWindow(2);
        switchToSecondWindow();
        if (verifyElementPresent(Irregularity_Inbx_irregularityCode)) {

            enterKeys(waitForElement(Irregularity_Inbx_irregularityCode), "Booking Reject");
            enterKeys(Irregularity_Inbx_irregularityRemarks, "Booking Reject");
            click(Irregularity_Btn_OKbutton);
        }
        switchToFirstWindow();*/
        saveIrregularityDetailsInCaptureIrregularityPopup("Booking Reject", "Booking Reject");
        check(chk_reject2);//issue
        //  tblSelectRowByColValue(table_bookingConfirm, 1, 3, FullawbNo2);
        click(Btn_Rejectbutton);
        minWait();
        /*driver.switchTo().defaultContent();
        click(waitForElement(btn_genericYes));
        waitForFrameAndSwitch(FRAME);
        waitForNewWindow(2);
        switchToSecondWindow();
        if (verifyElementPresent(Irregularity_Inbx_irregularityCode)) {

            enterKeys(waitForElement(Irregularity_Inbx_irregularityCode), "Flight Change");
            enterKeys(Irregularity_Inbx_irregularityRemarks, "Flight Change");
            click(Irregularity_Btn_OKbutton);
        }
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);*/
        saveIrregularityDetailsInCaptureIrregularityPopup("Booking Reject", "Booking Reject");
        return new CAP027(driver, dataFileName);

    }
    
    private void saveIrregularityDetailsInCaptureIrregularityPopup(String irregularityCode,String irregularityRemark){
    	waitForFrameAndSwitch(waitForElement(popupFrame));
    	enterKeys(waitForElement(Irregularity_Inbx_irregularityCode), irregularityCode);
        enterKeys(Irregularity_Inbx_irregularityRemarks, irregularityRemark);
        click(Irregularity_Btn_OKbutton);
        minWait();
        try{
        	waitForElement(Irregularity_Btn_Closebutton).click();
        }catch(StaleElementReferenceException e){
        	
        }
        driver.switchTo().defaultContent();
        waitForFrameAndSwitch(FRAME);
    }

    /**
     * Navigates to CAP018 screen
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 Lying_List(String fltCar, String fltNo, String fltDt, String FullawbNo, String FullawbNo2) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        FullawbNo = PropertyHandler.getPropValue(dataFilePath, FullawbNo);

        list(fltCar, fltNo, fltDt);
        minWait();

        scrollToView(Btn_Rejectbutton);
        tblSelectRowByColValue(table_bookingConfirm, 1, 3, FullawbNo);
        click(Btn_Rejectbutton);
        minWait();
        driver.switchTo().defaultContent();
        click(waitForElement(btn_genericYes));
        waitForFrameAndSwitch(FRAME);
        tblSelectRowByColValue(table_bookingConfirm, 1, 3, FullawbNo2);
        click(Btn_Rejectbutton);
        minWait();
        driver.switchTo().defaultContent();
        click(waitForElement(btn_genericYes));
        waitForFrameAndSwitch(FRAME);
        return new CAP027(driver, dataFileName);

    }

    /**
     * @param fullFltNo
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 Multi_Reassignview_FltFacts(String fltCar, String fltNo, String fltDt, String fullFltNo) {

        fullFltNo = PropertyHandler.getPropValue(dataFilePath, fullFltNo);
        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        list(fltCar, fltNo, fltDt);
        minWait();

        click(ViewFltFactsbutton);
        minWait();
        waitForNewWindow(2);
        switchToSecondWindow();
        selectByText(flightFactStatus, "Re-routed");
        click(ViewFltListbutton);
        minWait();
        Assert.assertTrue(waitForElement(ViewFltdiv).getText().contains(fullFltNo), "Flight no displayed");
        click(ViewFltListClosebutton);
        minWait();

        //switch back to main window
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return new CAP027(driver, dataFileName);

    }

    /**
     * Navigates to CAP018 screen
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 Scribblepad_create(String fltCar, String fltNo, String fltDt) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);


        list(fltCar, fltNo, fltDt);
        minWait();
        click(Btn_buttonbt_flightnumber_carrierCode);
        minWait();

        enterKeys(waitForElement(Btn_buttonbt_flightScribble_Txt), "Testing");
        click(Btn_buttonbt_flightnumber_Cancelbutton);
        minWait();
        click(Btn_buttonbt_flightnumber_carrierCode);
        minWait();

        enterKeys(waitForElement(Btn_buttonbt_flightScribble_Txt), "Testing");
        click(Btn_buttonbt_flightnumber_OKbutton);

        //switch back to main window
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return new CAP027(driver, dataFileName);

    }

    /**
     * Navigates to CAP018 screen
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 Scribblepad_update(String fltCar, String fltNo, String fltDt) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);


        list(fltCar, fltNo, fltDt);
        minWait();

        click(Btn_buttonbt_flightnumber_carrierCode);
        minWait();

        enterKeys(waitForElement(Btn_buttonbt_flightScribble_Txt), "Automation");
        click(Btn_buttonbt_flightnumber_OKbutton);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        click(Btn_buttonbt_flightnumber_carrierCode);
        minWait();

        Assert.assertTrue(waitForElement(Btn_buttonbt_flightScribble_Txt).getText().equalsIgnoreCase("Automation"));

        click(Btn_buttonbt_flightnumber_OKbutton);

        //switch back to main window


        return new CAP027(driver, dataFileName);

    }

    /**
     * Navigates to CAP018 screen
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 Connection_Flightdetails(String fltCar, String fltNo, String fltDt, String pcs11, String ubr) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        pcs11 = PropertyHandler.getPropValue(dataFilePath, pcs11);
        ubr = PropertyHandler.getPropValue(dataFilePath, ubr);

        list(fltCar, fltNo, fltDt);
        minWait();


        click(Connectionflt);
        System.out.println((waitForElement(Condetails)).getText());

        Assert.assertTrue((waitForElement(Condetails)).getText().contains(fltNo));
        System.out.println((waitForElement(Condetails)).getText());

        Assert.assertTrue((waitForElement(Condetails)).getText().contains(pcs11));
        //   Assert.assertTrue((waitForElement(Condetails)).getText().contains(ubr));
       /* minWait();
        click(Connectionflt2);
        System.out.println((waitForElement(Condetails2)).getText());
        
        Assert.assertTrue((waitForElement(Condetails2)).getText().contains(fltNo));
        Assert.assertTrue((waitForElement(Condetails2)).getText().contains(pcs11));
        */

        return new CAP027(driver, dataFileName);

    }

    /**
     * Navigates to CAP018 screen
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 Connection_multiFlightdetails(String fltCar, String fltNo, String fltNo2, String fltDt) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltNo2 = PropertyHandler.getPropValue(dataFilePath, fltNo2);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);


        list(fltCar, fltNo, fltDt);
        minWait();


        click(Connectionflt);


        Assert.assertTrue((waitForElement(Condetails2)).getText().contains(fltNo2));
        Assert.assertTrue((waitForElement(Condetails)).getText().contains(fltNo));


        return new CAP027(driver, dataFileName);

    }

    /**
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public CAP027 MarkPreCarriage_verifyEmpty(String fltCar, String fltNo, String fltDt, String awbPre, String awbNo) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);

        list(fltCar, fltNo, fltDt);
        minWait();
        click(MarkPreCarriagebutton_btn);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(waitForElement(MarkPreCarriage_txt_pref), awbPre);
        enterKeys(MarkPreCarriage_txt_awb, awbNo);

        click(MarkPreCarriage_Btn_List);
        minWait();
        System.out.println(getTableRowCount(MarkPreCarriage_precarriagetable));
        Assert.assertTrue(getTableRowCount(MarkPreCarriage_precarriagetable) == 0);

        click(MarkPreCarriage_Btn_Closebutton);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return new CAP027(driver, dataFileName);

    }

    /**
     * Closes the screen and go to home screen
     *
     * @return
     * @author A-7681
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }

    /**
     * Created by A-7605
     *
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public CAP027 checkInvalidFlightErrorMessageIsShowing(String carrierCode, String flightNo, String flightDate) {
        carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
        flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
        flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
        list(carrierCode, flightNo, flightDate);
        minWait();
        Assert.assertEquals(waitForElement(info_error).getText(), "Invalid Flight.");
        return this;
    }


// created byA-8254
    

   /* public CAP027 confirmQueuedBooking(String carrCode, String fltNo, String fltDt, String awbNo) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        list(carrCode, fltNo, fltDt);

        click(tab_queuedBooking);
        tblSelectRowByColValue(tbl_queuedBooking, 1, 3, awbNo);
        scrollToView(btn_confirm);
        click(btn_confirm);
  

        return this;
    }*/

    /**
     * created byA-8254
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     */

    public CAP027 changeConfirmedToQueuedBooking(String carrCode, String fltNo, String fltDt, String awbNo) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        list(carrCode, fltNo, fltDt);


        tblSelectRowByColValue(tbl_confirmedBooking, 1, 3, awbNo);
        scrollToView(Btn_Queue);
        click(Btn_Queue);
        waitForNewWindow(2);
        switchToSecondWindow();
        click(Btn_OK_NewWindow);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);


        return this;
    }


    public CAP018 getQueuedBookingDetails(String fltCar, String fltNo, String fltDt, String awbNo) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(fltCar, fltNo, fltDt);
        minWait();
        click(tab_queuedBooking);
        tblSelectRowByColValue(tbl_queuedBooking, 1, 3, awbNo);

        click(getWebElements(btn_viewBookingDtls).get(1));

        return new CAP018(driver, dataFileName);

    }
    
    /**
     * @author A-8260
     * @param fltNum
     * @param flt_sDate
     * @param Origin
     * @param Dest
     * @param fltNum1
     * @return
     */
    public CAP027 reAssignConfirmedBooking(String fltNum, String flt_sDate,String Origin,String Dest, String fltNum1) 
    {
    	fltNum= PropertyHandler.getPropValue(dataFilePath, fltNum);
    	flt_sDate= PropertyHandler.getPropValue(dataFilePath, flt_sDate);
    	Origin= PropertyHandler.getPropValue(dataFilePath, Origin);
    	Dest= PropertyHandler.getPropValue(dataFilePath, Dest);
    	fltNum1= PropertyHandler.getPropValue(dataFilePath, fltNum1);
    	
    	enterKeys(txt_fltNo, fltNum);
    	enterKeys(txt_fltDt, flt_sDate);
    	click(btn_list);
    	minWait();
    	tblClickByColInput(tbl_confirmedBooking, 1);
    	String awbNo="";
    	awbNo=getTableCellValue(tbl_confirmedBooking, 3, 1);
    	//tblSelectRowByColValue(tbl_confirmedBooking, 1, 3, awbNo);
    	click(btn_reAssign);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	enterKeys(txt_reAssignOrigin, Origin);
    	enterKeys(txt_reAssignDest, Dest);
    	click(btn_reAssignList);
    	
    	tblClickByColValWithRef(tbl_reAssignFlights, 1, 2, fltNum1);
    	
    	
    	click(btn_reAssignOk);
    	if(verifyElementPresent(btn_genericYes))
    		click(btn_genericYes);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	click(btn_clear);
    	String awbNumber2="";
    	enterKeys(txt_fltNo, fltNum);
    	enterKeys(txt_fltDt, flt_sDate);
    	click(btn_list);
    	awbNumber2=getTableCellValue_input(tbl_confirmedBooking, 3, 1);
    	Assert.assertTrue(awbNo.equals(awbNumber2),"Air way Bill should be same for the booking");
    	return this;
    }
    
    public CAP027 verifyQueuedBooking(String carrCode, String fltNum,String flt_sDate, String awbNumber)
    {
    	carrCode= PropertyHandler.getPropValue(dataFilePath, fltNum);
    	fltNum= PropertyHandler.getPropValue(dataFilePath, fltNum);
    	flt_sDate= PropertyHandler.getPropValue(dataFilePath, flt_sDate);
    	awbNumber= PropertyHandler.getPropValue(dataFilePath, awbNumber);
    	
    	enterKeys(txt_fltCarCode, carrCode);
    	enterKeys(txt_fltNo, fltNum);
    	enterKeys(txt_fltDt, flt_sDate);
    	click(btn_list);
    	minWait();
    	click(tab_queued);
    	System.out.println(awbNumber);
    	String awbNo="";
    	awbNo=getTableCellValue(table_queuedBooking, 3, 1);
    	System.out.println(awbNo);
    	Assert.assertTrue(awbNo.contains(awbNumber),"Queued booking not present");
    	
    	return this;
    }
    
    public CAP027 verifyConfirmedBooking(String carrCode, String fltNum, String flt_sDate, String awbNumber)
    {
    	carrCode= PropertyHandler.getPropValue(dataFilePath, fltNum);
    	fltNum= PropertyHandler.getPropValue(dataFilePath, fltNum);
    	flt_sDate= PropertyHandler.getPropValue(dataFilePath, flt_sDate);
    	awbNumber= PropertyHandler.getPropValue(dataFilePath, awbNumber);
    	
    	enterKeys(txt_fltCarCode, carrCode);
    	enterKeys(txt_fltNo, fltNum);
    	enterKeys(txt_fltDt, flt_sDate);
    	click(btn_list);
    	minWait();
    	
    	System.out.println(awbNumber);
    	String awbNo="";
    	awbNo=getTableCellValue(table_bookingConfirm, 3, 1);
    	System.out.println(awbNo);
    	Assert.assertTrue(awbNo.contains(awbNumber),"Confirmed booking not present");
    	
    	return this;
    }
    
    public CAP027 createOperationalStationAllotments(String fltNo, String fltDt, String stn,
            String wt, String vol, String allotId)
    {
    	
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        stn = PropertyHandler.getPropValue(dataFilePath, stn);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);
        vol = PropertyHandler.getPropValue(dataFilePath, vol);

       enterKeys(txt_fltNo, fltNo);
       enterKeys(txt_fltDate, fltDt);
       click(btn_list);
       minWait();
        click(waitForElementStaleness(driver.findElement(lnk_create)));
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();

        click(getWebElements(rb_allotType).get(2));
        enterKeys(waitForElement(txt_station), stn);
        enterKeys(txt_capWt, wt);
        enterKeys(txt_capVol, vol);
        click(btn_saveAltmnt);

        Assert.assertTrue(waitForElement(btn_createOk).isDisplayed(), "ERROR in Allotment Creation.");
        click(btn_createOk);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        List<String> id = getTableColumnValues(table_allotment, 2); //get values within column2
        System.out.println(id.get(0));
        PropertyHandler.setPropValue(dataFilePath, allotId, id.get(0));
    	return this;
    }
    
    
    
    
    public CAP027 verifyUNIDCannotCarryInPassengerFlightErrorMSG(String fltCar, String fltNo, String fltDt,String fltNo2) {

        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);


        list(fltCar, fltNo, fltDt);
        minWait();
        click(ChkBx_CheckAllCnfBookings);
        check(ChkBx_CheckAllCnfBookings);
        scrollToView(Btn_Reassignbutton);
        click(Btn_Reassignbutton);
        minWait();
        waitForNewWindow(2);
        switchToSecondWindow();
        
        minWait();
        scrollToView(Reassign_selectedFlightSelectAllcheckbox);
        enterKeys(waitForElement(txt_fltNo),fltNo2);
        click(Btn_Reassign_OKbutton);
        waitForElement(info_error).getText().contains("cannot be carried in Passenger flight");
        
        closeAndmoveToFirstWindow();
       
       
        waitForFrameAndSwitch(FRAME);


        return this;
    }
 
    /**
     * Method to list a flight and reject a specific AWB
     * @param carrCode
     * @param fltNum
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @return
     * @author A-7868 Krishna <09/05/2018>
     */
    public CAP027 rejectBooking(String carrCode, String fltNum, String fltDt, String awbPre, String awbNo){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
    	fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
    	fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(carrCode, fltNum, fltDt);
        minWait();
        
        tblSelectRowByColValue(tbl_confirmedBooking, 1, 3, awbPre+" - "+awbNo);
        scrollToView(Btn_Rejectbutton);
        click(Btn_Rejectbutton);  
        
        driver.switchTo().defaultContent();
        if(verifyElementPresent(btn_genericYes))
        	click(btn_genericYes);
        waitForFrameAndSwitch(FRAME);   
        waitForFrameAndSwitch(driver.findElement(By.id("popupContainerFrame")));  

        enterKeys(txt_rejectWindow_irrCode, "Booking Reject");
        enterKeys(txt_rejectWindow_irrRem, "Remarks");        
        click(btn_rejectWindow_irrOk);
        minWait();
        try{
        	waitForElement(btn_rejectWindow_irrClose).click();
        }catch(StaleElementReferenceException e){;}
        waitForFrameAndSwitch(FRAME);        
        return this;
    }
    
    
    /**
     * Method to list a Flight and verify whether an AWB is present under Affected BookingsS
     * @param carrCode
     * @param fltNum
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param affectedLeg
     * @return
     */
    public CAP027 verifyAffectedBooking(String carrCode, String fltNum, String fltDt, String awbPre, String awbNo, String affectedLeg){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
    	fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
    	fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	affectedLeg = PropertyHandler.getPropValue(dataFilePath, affectedLeg);
    	
    	list(carrCode, fltNum, fltDt);
        minWait();
        
        click(btn_affectedBkg);
        selectByText(dropdown_affLeg, affectedLeg);
        click(btn_affBkg_list);
        minWait();
        Assert.assertTrue(getTableColumnValues(tbl_affBkg, 3).contains(awbPre+" - "+awbNo), "ERROR : AWB not listed under Affected Bkgs.");
        return this;
        
    }
    
    /**
     * Method to verify the priority of a confirmed booking
     * @param carrCode
     * @param fltNum
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param priority
     * @return
     * @author A-7868 Krishna <03/07/2018>
     */
    public CAP027 verifyBookingPriority(String carrCode, String fltNum, String fltDt, String awbPre, String awbNo, String priority){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
    	fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
    	fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	priority = PropertyHandler.getPropValue(dataFilePath, priority);
    	
    	list(carrCode, fltNum, fltDt);
    	
    	Assert.assertTrue(tblGetTextByColValue(tbl_confirmedBooking, 17, 3, awbNo).trim().equals(priority), "Priority mismatch.");
    	tblSelectRowByColValue(tbl_confirmedBooking, 1, 3, awbNo);
    	click(btn_priority);
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	Assert.assertTrue(getTableCellValue_input(proprity_tbl_bkgDetails, 7, 1).trim().equals(priority), "Priority mismatch");
    	closeAndmoveToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
