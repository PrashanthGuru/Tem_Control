package com.ibsplc.pageObjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-6545 on 22/12/2017.
 */

public class OPR016 extends BasePage {
	private final static Logger logger = Logger.getLogger(OPR016.class);
	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	private static String FRAME = "iCargoContentFrameOPR016";
	private WebDriver driver;
	private String testDataFile;
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	private By btn_list,
	txt_awbNo,
	txt_FlightCarrierCode,
	txt_FlightNo,
	txt_FlightDate,
	Btn_AWB,
	Chkbox_SelectAll,
	Lst_assignToULD,
	Btn_AssignToULD,
	Btn_Savebutton,
	Btn_PrintManifest,
	Btn_PrintManifest_Close,
	Btn_Finalize,
	Btn_AssignULD,
	ATD_txt_FlightTime,
	ATD_txt_FlightTailNumber,
	ATD_Btn_Save,
	Chkbox_SelectAllULD,
	btn_close,
	btn_genericOk,
	Txt_Status,
	Lnk_DownArrow,
	Btn_Offload,
	Table_manifestDetailTable,
	txt_Offload_Pcs,
	txt_Offload_Weight,
	List_Offload_Reason,
	Btn_Offload_Confirm,
	noBtn,
	btn_genericYes,
	btn_assignToFlight,
	tbl_awb,
	tbl_uld,
	btn_uldDtls,
	dropDown_linkageRefNo,
	btn_linkageCnfrmLinkage,
	info_fltStatus,
	btn_clear,
	link_expandAll,
	tbl_shpmntDtls,
	btn_assignULD,
	chkBx_assignULDBarrow,
	txt_assignUldULDNo,
	dropDown_assignUldPOU,
	btn_assignUldList,
	btn_assginUldDelete,
	txt_assignUldAwbPre,
	txt_assignUldAwbNo,
	btn_assignUldAwbList,
	txt_assignUldAwbPcs,
	txt_assignUldAwbWt,
	btn_assignUldOk,
	btn_closeBldUp,
	btn_openBldUp,
	btn_assignULDaddHAWB,
	btn_HAWBOk,
	chkBx_HAWBcheckAll,
	list_txtHousePcs,
	list_txtHouseWt,
	btn_lyingList,
	txt_lyingListFrmDt,
	txt_lyingListToDt,
	txt_lyingListAwbPre,
	txt_lyingListAwbNo,
	btn_lyingList_list,
	chkBx_lyingListAwbSelectAll,
	btn_lyingListOk,
	tab_lyingListULD,
	txt_lyingListUldNo,
	chkBx_lyingListUldSelectAll,
	dropDown_assignULDBrkDwnInst,
	btn_assignULDBrkDwnAdd,
	txt_brkDwnFltCarrCode,
	txt_brkDwnFltNO,
	txt_brkDwnFltDate,
	txt_brkDwnDest,
	btn_unAssign,
	tab_uld,
	btn_splitAndUnAssign,
	txt_splitPcs,
	txt_splitWt,
	btn_splitOk,
	tbl_lyingListUld,
	btn_lyingListClose,
	btn_reassign,
	tbl_reassignAWB,
	txt_reassignULDNo,
	txt_reassignCarrCode,
	txt_reassignfltNo,
	txt_reassignfltDt,
	txt_reassignPOU,
	btn_reassignSave,
	chkBx_reassignULDBarrow,
	chkBx_reassignFullULDReassign,
	txt_reassignPcs,
	btn_reassignClose,
	btn_offload,
	txt_offloadPcs,
	txt_offloadWt,
	dropDown_offloadReason,
	btn_offloadConfirm,
	tbl_offloadHistory,
	btn_offloadClose,
	txt_offloadCarrCode,
	txt_offloadFltNo,
	txt_offloadFltDt,
	txt_offloadPOU,
	btn_reOpen,
	btn_sendFFM,
	btn_sendMsgAdd,
	dropDown_sendMsgInterface,
	dropDown_sendMsgTransmission,
	btn_sendMsgAddress,
	btn_addressOk,
	btn_sendMsgOk,
	tbl_reaasignTable,
	btn_AssignedToFlight,
	btn_sendFUM,
	btn_splitAndAssign,
	btn_preAdvice,
	dropDown_preAdviceSCC,
	dropDown_preAdvicePOU,
	btn_preAdviceList,
	radio_preAdviceFFM,
	radio_preAdviceFFM_FWB,
	txt_preAdviceRemarks,
	btn_preAdviceSend,
	btn_preAdviceClose,
	btn_preAdviceClear,
	chkbox_selectTableItem,
	table_AssignULD_HAWBDetails,
	btn_NOTOC,
	btn_assignULD_OK,
	msg_blk_errors,
	txt_uldDest;

	private By info_genericToastClose,
	info_genericMsg,
	btn_genericErrorClose,
	info_genericErrorMsg,
	info_error,
	lnk_expandShipmentDetailsTable;

	public OPR016(WebDriver driver, String testDataFile) {
		super(driver);
		this.driver = driver;
		initPageElements();

		this.dataFilePath = dataFilePath + testDataFile;
		this.testDataFile = testDataFile;

	}



	private void initPageElements() {
		btn_list = MiscUtility.getWebElement(objFilepath, "OPR016_Btn_List");
		txt_FlightCarrierCode = MiscUtility.getWebElement(objFilepath, "OPR016_txt_FlightCarrierCode");
		txt_FlightNo = MiscUtility.getWebElement(objFilepath, "OPR016_txt_FlightNo");
		txt_FlightDate = MiscUtility.getWebElement(objFilepath, "OPR016_txt_FlightDate");
		Btn_AWB = MiscUtility.getWebElement(objFilepath, "OPR016_Btn_AWB");
		Chkbox_SelectAll = MiscUtility.getWebElement(objFilepath, "OPR016_Chkbox_SelectAll");
		Lst_assignToULD = MiscUtility.getWebElement(objFilepath, "OPR016_Lst_assignToULD");
		Btn_AssignToULD = MiscUtility.getWebElement(objFilepath, "OPR016_Btn_AssignToULD");
		Btn_Savebutton = MiscUtility.getWebElement(objFilepath, "OPR016_Btn_Save");
		Btn_PrintManifest = MiscUtility.getWebElement(objFilepath, "OPR016_Btn_PrintManifest");
		Btn_PrintManifest_Close = MiscUtility.getWebElement(objFilepath, "OPR016_Btn_PrintManifest_Close");
		Btn_Finalize = MiscUtility.getWebElement(objFilepath, "OPR016_Btn_Finalize");
		ATD_txt_FlightTime = MiscUtility.getWebElement(objFilepath, "OPR016_ATD_txt_FlightTime");
		ATD_txt_FlightTailNumber = MiscUtility.getWebElement(objFilepath, "OPR016_ATD_txt_FlightTailNumber");
		Chkbox_SelectAllULD = MiscUtility.getWebElement(objFilepath, "OPR016_Chkbox_SelectAllULD");
		Btn_AssignULD = MiscUtility.getWebElement(objFilepath, "OPR016_Btn_AssignULD");
		ATD_Btn_Save = MiscUtility.getWebElement(objFilepath, "OPR016_ATD_Btn_Save");
		btn_close = MiscUtility.getWebElement(objFilepath, "OPR016_Btn_Close");
		btn_uldDtls = MiscUtility.getWebElement(objFilepath, "OPR016_btn_uldDtls");
		dropDown_linkageRefNo = MiscUtility.getWebElement(objFilepath, "OPR016_dropDown_linkageRefNo");
		btn_linkageCnfrmLinkage = MiscUtility.getWebElement(objFilepath, "OPR016_btn_linkageCnfrmLinkage");
		//  	btn_genericYes			= MiscUtility.getWebElement(objFilepath,"CAP012_btn_yes");
		tbl_awb = MiscUtility.getWebElement(objFilepath, "OPR016_tbl_awb");
		info_fltStatus = MiscUtility.getWebElement(objFilepath, "OPR016_info_fltStatus");
		btn_clear = MiscUtility.getWebElement(objFilepath, "OPR016_btn_clear");
		link_expandAll = MiscUtility.getWebElement(objFilepath, "OPR016_link_expandAll");
		tbl_shpmntDtls = MiscUtility.getWebElement(objFilepath, "OPR016_tbl_shpmntDtls");
		btn_assignULD = MiscUtility.getWebElement(objFilepath, "OPR016_btn_assignULD");
		btn_AssignedToFlight = MiscUtility.getWebElement(objFilepath, "OPR016_btn_AssignedToFlight");
		chkBx_assignULDBarrow = MiscUtility.getWebElement(objFilepath, "OPR016_chkBx_assignULDBarrow");
		txt_assignUldULDNo = MiscUtility.getWebElement(objFilepath, "OPR016_txt_assignUldULDNo");
		dropDown_assignUldPOU = MiscUtility.getWebElement(objFilepath, "OPR016_dropDown_assignUldPOU");
		btn_assignUldList = MiscUtility.getWebElement(objFilepath, "OPR016_btn_assignUldList");
		btn_assginUldDelete = MiscUtility.getWebElement(objFilepath, "OPR016_btn_assginUldDelete");
		txt_assignUldAwbPre = MiscUtility.getWebElement(objFilepath, "OPR016_txt_assignUldAwbPre");
		txt_assignUldAwbNo = MiscUtility.getWebElement(objFilepath, "OPR016_txt_assignUldAwbNo");
		btn_assignUldAwbList = MiscUtility.getWebElement(objFilepath, "OPR016_btn_assignUldAwbList");
		txt_assignUldAwbPcs = MiscUtility.getWebElement(objFilepath, "OPR016_btn_assignUldAwbPcs");
		txt_assignUldAwbWt = MiscUtility.getWebElement(objFilepath, "OPR016_btn_assignUldAwbWt");
		btn_assignUldOk = MiscUtility.getWebElement(objFilepath, "OPR016_btn_assignUldOk");
		btn_closeBldUp = MiscUtility.getWebElement(objFilepath, "OPR016_btn_closeBldUp");
		btn_openBldUp = MiscUtility.getWebElement(objFilepath, "OPR016_btn_openBldUp");
		btn_assignULDaddHAWB = MiscUtility.getWebElement(objFilepath, "OPR016_btn_assignULDaddHAWB");
		btn_HAWBOk = MiscUtility.getWebElement(objFilepath, "OPR016_btn_HAWBOk");
		chkBx_HAWBcheckAll = MiscUtility.getWebElement(objFilepath, "OPR016_chkBx_HAWBcheckAll");
		list_txtHousePcs = MiscUtility.getWebElement(objFilepath, "OPR016_list_txtHousePcs");
		list_txtHouseWt = MiscUtility.getWebElement(objFilepath, "OPR016_list_txtHouseWt");
		btn_lyingList = MiscUtility.getWebElement(objFilepath, "OPR016_btn_lyingList");
		txt_lyingListFrmDt = MiscUtility.getWebElement(objFilepath, "OPR016_txt_lyingListFrmDt");
		txt_lyingListToDt = MiscUtility.getWebElement(objFilepath, "OPR016_txt_lyingListToDt");
		txt_lyingListAwbPre = MiscUtility.getWebElement(objFilepath, "OPR016_txt_lyingListAwbPre");
		txt_lyingListAwbNo = MiscUtility.getWebElement(objFilepath, "OPR016_txt_lyingListAwbNo");
		btn_lyingList_list = MiscUtility.getWebElement(objFilepath, "OPR016_btn_lyingList_list");
		chkBx_lyingListAwbSelectAll = MiscUtility.getWebElement(objFilepath, "OPR016_chkBx_lyingListSelectAll");
		btn_lyingListOk = MiscUtility.getWebElement(objFilepath, "OPR016_btn_lyingListOk");
		tab_lyingListULD = MiscUtility.getWebElement(objFilepath, "OPR016_tab_lyingListULD");
		txt_lyingListUldNo = MiscUtility.getWebElement(objFilepath, "OPR016_txt_lyingListUldNo");
		chkBx_lyingListUldSelectAll = MiscUtility.getWebElement(objFilepath, "OPR016_chkBx_lyingListUldSelectAll");
		dropDown_assignULDBrkDwnInst = MiscUtility.getWebElement(objFilepath, "OPR016_dropDown_assignULDBrkDwnInst");
		btn_assignULDBrkDwnAdd = MiscUtility.getWebElement(objFilepath, "OPR016_btn_assignULDBrkDwnAdd");
		txt_brkDwnFltCarrCode = MiscUtility.getWebElement(objFilepath, "OPR016_txt_brkDwnFltCarrCode");
		txt_brkDwnFltNO = MiscUtility.getWebElement(objFilepath, "OPR016_txt_brkDwnFltNO");
		txt_brkDwnFltDate = MiscUtility.getWebElement(objFilepath, "OPR016_txt_brkDwnFltDate");
		txt_brkDwnDest = MiscUtility.getWebElement(objFilepath, "OPR016_txt_brkDwnDest");
		btn_unAssign = MiscUtility.getWebElement(objFilepath, "OPR016_btn_unAssign");
		tab_uld = MiscUtility.getWebElement(objFilepath, "OPR016_tab_uld");
		tbl_uld = MiscUtility.getWebElement(objFilepath, "OPR016_tbl_uld");
		btn_splitAndUnAssign = MiscUtility.getWebElement(objFilepath, "OPR016_btn_splitAndUnAssign");
		txt_splitPcs = MiscUtility.getWebElement(objFilepath, "OPR016_txt_splitPcs");
		txt_splitWt = MiscUtility.getWebElement(objFilepath, "OPR016_txt_splitWt");
		btn_splitOk = MiscUtility.getWebElement(objFilepath, "OPR016_btn_splitOk");
		tbl_lyingListUld = MiscUtility.getWebElement(objFilepath, "OPR016_tbl_lyingListUld");
		btn_lyingListClose = MiscUtility.getWebElement(objFilepath, "OPR016_btn_lyingListClose");
		btn_reassign = MiscUtility.getWebElement(objFilepath, "OPR016_btn_reassign");
		tbl_reassignAWB = MiscUtility.getWebElement(objFilepath, "OPR016_tbl_reassignAWB");
		txt_reassignULDNo = MiscUtility.getWebElement(objFilepath, "OPR016_txt_reassignULDNo");
		txt_reassignCarrCode = MiscUtility.getWebElement(objFilepath, "OPR016_txt_reassignCarrCode");
		txt_reassignfltNo = MiscUtility.getWebElement(objFilepath, "OPR016_txt_reassignfltNo");
		txt_reassignfltDt = MiscUtility.getWebElement(objFilepath, "OPR016_txt_reassignfltDt");
		txt_reassignPOU = MiscUtility.getWebElement(objFilepath, "OPR016_txt_reassignPOU");
		btn_reassignSave = MiscUtility.getWebElement(objFilepath, "OPR016_btn_reassignSave");
		chkBx_reassignULDBarrow = MiscUtility.getWebElement(objFilepath, "OPR016_chkBx_reassignULDBarrow");
		chkBx_reassignFullULDReassign = MiscUtility.getWebElement(objFilepath, "OPR016_chkBx_reassignFullULDReassign");
		txt_reassignPcs = MiscUtility.getWebElement(objFilepath, "OPR016_txt_reassignPcs");
		btn_reassignClose = MiscUtility.getWebElement(objFilepath, "OPR016_btn_reassignClose");
		btn_offload = MiscUtility.getWebElement(objFilepath, "OPR016_btn_offload");
		txt_offloadPcs = MiscUtility.getWebElement(objFilepath, "OPR016_txt_offloadPcs");
		txt_offloadWt = MiscUtility.getWebElement(objFilepath, "OPR016_txt_offloadWt");
		dropDown_offloadReason = MiscUtility.getWebElement(objFilepath, "OPR016_dropDown_offloadReason");
		btn_offloadConfirm = MiscUtility.getWebElement(objFilepath, "OPR016_btn_offloadConfirm");
		tbl_offloadHistory = MiscUtility.getWebElement(objFilepath, "OPR016_tbl_offloadHistory");
		btn_offloadClose = MiscUtility.getWebElement(objFilepath, "OPR016_btn_offloadClose");
		txt_offloadCarrCode = MiscUtility.getWebElement(objFilepath, "OPR016_txt_offloadCarrCode");
		txt_offloadFltNo = MiscUtility.getWebElement(objFilepath, "OPR016_txt_offloadFltNo");
		txt_offloadFltDt = MiscUtility.getWebElement(objFilepath, "OPR016_txt_offloadFltDt");
		txt_offloadPOU = MiscUtility.getWebElement(objFilepath, "OPR016_txt_offloadPOU");
		btn_reOpen = MiscUtility.getWebElement(objFilepath, "OPR016_btn_reOpen");
		btn_sendFFM = MiscUtility.getWebElement(objFilepath, "OPR016_btn_sendFFM");
		btn_sendMsgAdd = MiscUtility.getWebElement(objFilepath, "OPR016_btn_sendMsgAdd");
		dropDown_sendMsgInterface = MiscUtility.getWebElement(objFilepath, "OPR016_dropDown_sendMsgInterface");
		dropDown_sendMsgTransmission = MiscUtility.getWebElement(objFilepath, "OPR016_dropDown_sendMsgTransmission");
		btn_sendMsgAddress = MiscUtility.getWebElement(objFilepath, "OPR016_btn_sendMsgAddress");
		btn_addressOk = MiscUtility.getWebElement(objFilepath, "OPR016_btn_addressOk");
		btn_sendMsgOk = MiscUtility.getWebElement(objFilepath, "OPR016_btn_sendMsgOk");
		btn_sendFUM = MiscUtility.getWebElement(objFilepath, "OPR016_btn_sendFUM");
		Btn_Offload = MiscUtility.getWebElement(objFilepath, "OPR016_btn_offload");
		txt_Offload_Pcs = MiscUtility.getWebElement(objFilepath, "OPR016_txt_Offload_Pcs");
		txt_Offload_Weight = MiscUtility.getWebElement(objFilepath, "OPR016_txt_Offload_Weight");
		List_Offload_Reason = MiscUtility.getWebElement(objFilepath, "OPR016_List_Offload_Reason");
		Btn_Offload_Confirm = MiscUtility.getWebElement(objFilepath, "OPR016_Btn_Offload_Confirm");
		btn_NOTOC = MiscUtility.getWebElement(objFilepath, "OPR016_btn_NOTOC");

		tbl_reaasignTable = MiscUtility.getWebElement(objFilepath, "OPR016_tbl_reaasignTable");
		btn_splitAndAssign = MiscUtility.getWebElement(objFilepath, "OPR016_btn_splitAndAssign");
		btn_preAdvice = MiscUtility.getWebElement(objFilepath, "OPR016_btn_preAdvice");
		dropDown_preAdviceSCC = MiscUtility.getWebElement(objFilepath, "OPR016_dropDown_preAdviceSCC");
		dropDown_preAdvicePOU = MiscUtility.getWebElement(objFilepath, "OPR016_dropDown_preAdvicePOU");
		btn_preAdviceList = MiscUtility.getWebElement(objFilepath, "OPR016_btn_preAdviceList");
		radio_preAdviceFFM = MiscUtility.getWebElement(objFilepath, "OPR016_radio_preAdviceFFM");
		radio_preAdviceFFM_FWB = MiscUtility.getWebElement(objFilepath, "OPR016_radio_preAdviceFFM_FWB");
		txt_preAdviceRemarks = MiscUtility.getWebElement(objFilepath, "OPR016_txt_preAdviceRemarks");
		btn_preAdviceSend = MiscUtility.getWebElement(objFilepath, "OPR016_btn_preAdviceSend");
		btn_preAdviceClose = MiscUtility.getWebElement(objFilepath, "OPR016_btn_preAdviceClose");
		btn_preAdviceClear = MiscUtility.getWebElement(objFilepath, "OPR016_btn_preAdviceClear");
		btn_assignToFlight = MiscUtility.getWebElement(objFilepath, "OPR016_Btn_AssignToFlight");
		chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath, "OPR016_chkbox_selectTableItem");
		table_AssignULD_HAWBDetails = MiscUtility.getWebElement(objFilepath, "OPR016_table_AssignULD_HAWBDetails");

		btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		info_genericToastClose = MiscUtility.getWebElement(genObjPath, "Generic_info_close1");
		btn_genericErrorClose = MiscUtility.getWebElement(genObjPath, "Generic_error_close");
		info_genericErrorMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
		info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");

		txt_uldDest=MiscUtility.getWebElement(objFilepath,"OPR016_txt_Destn_ULD");
		btn_assignULD_OK=MiscUtility.getWebElement(objFilepath,"OPR016_btn_AssignULD_Ok");
		msg_blk_errors=MiscUtility.getWebElement(genObjPath, "Generic_blk_error");
	//	lnk_expandShipmentDetailsTable = MiscUtility.getWebElement(objFilepath, "OPR016_lnk_expandShipmentDetailsTable");

	}

	public OPR016 BulkAcceptnace(String key_awbNo, String key_FlightCarrierCode, String key_FlightNo,
			String key_FlightDate) {

		String data_awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
		String data_FlightCarrierCode = PropertyHandler.getPropValue(dataFilePath, key_FlightCarrierCode);
		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
		String data_FlightDate = PropertyHandler.getPropValue(dataFilePath, key_FlightDate);

		click(btn_clear);
		minWait();
		enterKeys(txt_FlightCarrierCode, data_FlightCarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_FlightDate);

		click(btn_list);
		//driver.switchTo().defaultContent();
		minWait();

		click(Btn_AWB);
		//check(Chkbox_SelectAll);
		tblSelectRowByColValue(tbl_awb, 1, 5, data_awbNo);
		selectByIndex(Lst_assignToULD, 1);
		minWait();
		click(Btn_AssignToULD);
		minWait();
		maxWait();
		click(Btn_Savebutton);

		return this;
	}


	public OPR016 BulkAcceptnaceMultilg(String key_awbNo, String key_FlightCarrierCode, String key_FlightNo,
			String key_FlightDate) {

		String data_awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
		String data_FlightCarrierCode = PropertyHandler.getPropValue(dataFilePath, key_FlightCarrierCode);
		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
		String data_FlightDate = PropertyHandler.getPropValue(dataFilePath, key_FlightDate);


		enterKeys(txt_FlightCarrierCode, data_FlightCarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_FlightDate);

		click(btn_list);
		minWait();

		click(Btn_AWB);
		tblSelectRowByColValue(tbl_awb, 1, 5, data_awbNo);
		selectByIndex(Lst_assignToULD, 2);
		click(Btn_AssignToULD);
		minWait();
		click(Btn_Savebutton);

		return this;
	}


	public OPR016 UldAcceptnace(String key_awbNo, String key_FlightCarrierCode, String key_FlightNo,
			String key_FlightDate, String key_UldNo) {

		String data_awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
		String data_FlightCarrierCode = PropertyHandler.getPropValue(dataFilePath, key_FlightCarrierCode);
		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
		String data_FlightDate = PropertyHandler.getPropValue(dataFilePath, key_FlightDate);
		String data_UldNo = PropertyHandler.getPropValue(dataFilePath, key_UldNo);


		enterKeys((txt_FlightCarrierCode), data_FlightCarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_FlightDate);

		click(btn_list);
		//	    	driver.switchTo().defaultContent();
		minWait();

		click(tab_uld);

		tblSelectRowByColValue(tbl_uld, 1, 3, data_UldNo);

		click(btn_AssignedToFlight);

		click(Btn_Savebutton);
		//	         driver.switchTo().defaultContent();
		//
		//		    	switchToFirstWindow();
		//		        waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	public OPR016 Bulk_UldAcceptnace(String key_FlightCarrierCode, String key_FlightNo,
			String key_FlightDate) {

		//	String data_awbNo 	= PropertyHandler.getPropValue(dataFilePath, key_awbNo);
		String data_FlightCarrierCode = PropertyHandler.getPropValue(dataFilePath, key_FlightCarrierCode);
		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
		String data_FlightDate = PropertyHandler.getPropValue(dataFilePath, key_FlightDate);


		enterKeys((txt_FlightCarrierCode), data_FlightCarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_FlightDate);

		click(btn_list);
		minWait();
		check(Chkbox_SelectAllULD);
		click(btn_assignToFlight);
		minWait();
		
		click(Btn_AWB);
		check(Chkbox_SelectAll);
		
		String text = waitForElement(Lst_assignToULD).findElement(By.xpath("//option[contains(text(),'BULK')]")).getText().trim();
		selectByText(Lst_assignToULD, text);
		
		click(Btn_AssignToULD);
		minWait();
		click(Btn_Savebutton);
		minWait();
		return this;
	}


	public OPR016 PrintManifest() {
		minWait();
		click(Btn_PrintManifest);
		minWait();
		//        driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();
		waitForElement(Btn_PrintManifest_Close);
		click(Btn_PrintManifest_Close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		return this;

	}

	/**
	 * Print manifest by listing the flight
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 printManifestWithList(String carrCode, String fltNo, String fltDt) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		list(carrCode, fltNo, fltDt);

		click(Btn_PrintManifest);
		//        driver.switchTo().defaultContent();
		waitForNewWindow(2);

		switchToSecondWindow();
		click(Btn_PrintManifest_Close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		return this;

	}

	public OPR016 Offload(String awbNo, String Pcs, String weight) {
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		Pcs = PropertyHandler.getPropValue(dataFilePath, Pcs);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		minWait();

		click(link_expandAll);
		minWait();
		tblSelectRowByColValue(tbl_shpmntDtls, 1, 12, awbNo);
		click(btn_offload);
		//        driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys(txt_Offload_Pcs, Pcs);
		enterKeys(txt_Offload_Weight, weight);
		selectByIndex(List_Offload_Reason, 1);
		click(Btn_Offload_Confirm);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		return this;

	}

	public OPR016 Offload1(String awbNo, String Pcs, String weight) {
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		minWait();

		click(link_expandAll);
		minWait();
		tblSelectRowByColValue(tbl_shpmntDtls, 1, 12, awbNo);
		click(btn_offload);
		//        driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys(txt_Offload_Pcs, Pcs);
		enterKeys(txt_Offload_Weight, weight);
		selectByIndex(List_Offload_Reason, 1);
		click(Btn_Offload_Confirm);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		return this;

	}

	/**
	 * Offload a shipment from a ULD
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param uldNo
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 offloadShipmentFromULD(String carrCode, String fltNo, String fltDt, String awbNo, String uldNo, String offloadPcs, String offloadWt, String offloadReason) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		offloadPcs = PropertyHandler.getPropValue(dataFilePath, offloadPcs);
		offloadWt = PropertyHandler.getPropValue(dataFilePath, offloadWt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		tblExpandRowByColValue(tbl_shpmntDtls, 2, 3, uldNo);
		tblSelectRowByColValue(tbl_shpmntDtls, 1, 12, awbNo);
		click(btn_offload);

		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys(txt_offloadPcs, offloadPcs);
		enterKeys(txt_offloadWt, offloadWt);
		selectByText(dropDown_offloadReason, offloadReason);
		click(btn_offloadConfirm);


		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		save();

		return this;
	}

	/**
	 * Offload a loose shipment
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @param offloadPcs
	 * @param offloadWt
	 * @param offloadReason
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 offloadAWB(String carrCode, String fltNo, String fltDt, String awbNo, String offloadPcs, String offloadWt, String offloadReason) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		offloadPcs = PropertyHandler.getPropValue(dataFilePath, offloadPcs);
		offloadWt = PropertyHandler.getPropValue(dataFilePath, offloadWt);

		list(carrCode, fltNo, fltDt);

		click(link_expandAll);
		tblSelectRowByColValue(tbl_shpmntDtls, 1, 12, awbNo);

		click(btn_offload);

		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys(txt_offloadPcs, offloadPcs);
		enterKeys(txt_offloadWt, offloadWt);
		selectByText(dropDown_offloadReason, offloadReason);
		click(btn_offloadConfirm);


		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		save();

		return this;
	}

	/**
	 * Offload a loose shipment
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 verifyOffloadReasons(String carrCode, String fltNo, String fltDt, String awbNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		List<String> reasonList = null;
		String[] reasons = {"Damaged", "Due Payload", "Due Space", "Due Trim", "Flight Disrupted", "Late Received", "Others", "ULD Missing in CPM"};
		list(carrCode, fltNo, fltDt);

		click(link_expandAll);
		tblSelectRowByColValue(tbl_shpmntDtls, 1, 12, awbNo);

		click(btn_offload);

		waitForNewWindow(2);
		switchToSecondWindow();

		reasonList = getAllValues(dropDown_offloadReason);

		for (String reason : reasons) {
			Assert.assertTrue(reasonList.contains(reason), "The Offload Reason " + reason + " is not present in the list.");
		}

		click(btn_offloadClose);


		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * Offload a loose shipment and reassigns it to other flight
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @param offloadPcs
	 * @param offloadWt
	 * @param offloadReason
	 * @param carrCode2
	 * @param fltNo2
	 * @param fltDt2
	 * @param dest
	 * @return
	 * @author Arun
	 */
	public OPR016 offloadAWBandReassign(String carrCode, String fltNo, String fltDt, String awbNo, String offloadPcs, String offloadWt, String offloadReason, String carrCode2, String fltNo2, String fltDt2, String dest) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		offloadPcs = PropertyHandler.getPropValue(dataFilePath, offloadPcs);
		offloadWt = PropertyHandler.getPropValue(dataFilePath, offloadWt);
		carrCode2 = PropertyHandler.getPropValue(dataFilePath, carrCode2);
		fltNo2 = PropertyHandler.getPropValue(dataFilePath, fltNo2);
		fltDt2 = PropertyHandler.getPropValue(dataFilePath, fltDt2);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);

		list(carrCode, fltNo, fltDt);

		click(link_expandAll);
		tblSelectRowByColValue(tbl_shpmntDtls, 1, 12, awbNo);

		click(btn_offload);

		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys(txt_offloadPcs, offloadPcs);
		enterKeys(txt_offloadWt, offloadWt);
		selectByText(dropDown_offloadReason, offloadReason);
		scrollToView(txt_offloadPOU);
		enterKeys(txt_offloadCarrCode, carrCode2);
		enterKeys(txt_offloadFltNo, fltNo2);
		enterKeys(txt_offloadFltDt, fltDt2);
		enterKeys(txt_offloadPOU, dest);
		click(btn_offloadConfirm);


		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		save();

		return this;
	}

	/**
	 * Offload a ULD
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param uldNo
	 * @param offloadReason
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 offloadULD(String carrCode, String fltNo, String fltDt, String uldNo, String offloadReason) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		tblSelectRowByColValue(tbl_shpmntDtls, 1, 3, uldNo);

		click(btn_offload);

		waitForNewWindow(2);
		switchToSecondWindow();

		selectByText(dropDown_offloadReason, offloadReason);
		click(btn_offloadConfirm);


		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		save();

		return this;
	}


	/**
	 * Verifies the presence of AWBNo in offload history
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @param uldNo
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 verifyOffloadHistory(String carrCode, String fltNo, String fltDt, String awbNo, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		tblSelectRowByColValue(tbl_shpmntDtls, 1, 3, uldNo);
		click(btn_offload);

		waitForNewWindow(2);
		switchToSecondWindow();

		Assert.assertTrue(getTableColumnValues(tbl_offloadHistory, 4).contains((String) awbNo));
		click(btn_offloadClose);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	public OPR016 FinalizeFlight() {

		minWait();
		click(Btn_Finalize);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys((ATD_txt_FlightTime), "-1");
		//enterKeys(ATD_txt_FlightTailNumber, "12");

		waitForElement(ATD_Btn_Save);
		click(ATD_Btn_Save);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		driver.switchTo().defaultContent();
		click(btn_genericOk);

		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;

	}

	public OPR016 FinalizeFlightWithListing(String key_FlightCarrierCode, String key_FlightNo, String key_FlightDate) {

		String data_FlightCarrierCode = PropertyHandler.getPropValue(dataFilePath, key_FlightCarrierCode);
		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
		String data_FlightDate = PropertyHandler.getPropValue(dataFilePath, key_FlightDate);


		list(data_FlightCarrierCode, data_FlightNo, data_FlightDate);

		click(btn_list);
		minWait();

		click(Btn_Finalize);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys(ATD_txt_FlightTime, "-1");

		waitForElement(ATD_Btn_Save);
		click(ATD_Btn_Save);
		switchToFirstWindow();
		driver.switchTo().defaultContent();
		minWait();
		//if (verifyElementPresent(btn_genericOk)) {
			Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("is finalized"), "The flight is not finalized");
			click(btn_genericOk);
		//}
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Confirm Lineage for the ULD
	 *
	 * @return
	 * @author Arun A-7681
	 */

	public OPR016 confirmLinkage(String carrCode, String fltNo, String fltDt, String refNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		list(carrCode, fltNo, fltDt);

		click(btn_uldDtls);
		waitForNewWindow(2);
		switchToSecondWindow();

		selectByText(dropDown_linkageRefNo, refNo);

		click(btn_linkageCnfrmLinkage);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * List a flight in OPR016 screen
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @author A-7681
	 */
	private void list(String carrCode, String fltNo, String fltDt) {
		enterKeys(txt_FlightCarrierCode, carrCode);
		enterKeys(txt_FlightNo, fltNo);
		enterKeys(txt_FlightDate, fltDt);
		click(btn_list);
	}

	/**
	 * List a finalized flight in OPR016 screen
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @author A-7681
	 */
	private void listFinalized(String carrCode, String fltNo, String fltDt) {
		enterKeys(txt_FlightCarrierCode, carrCode);
		enterKeys(txt_FlightNo, fltNo);
		enterKeys(txt_FlightDate, fltDt);
		click(btn_list);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericOk)) {
			Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("is finalized"), "The flight is not finalized");
			click(btn_genericOk);
		}
		waitForFrameAndSwitch(FRAME);
	}

	/**
	 * Verifyies a flight is finalized
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 verifyFinalized(String carrCode, String fltNo, String fltDt) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		listFinalized(carrCode, fltNo, fltDt);

		Assert.assertTrue(waitForElement(btn_reOpen).isEnabled(), "The flight is not finalized");
		//        Assert.assertFalse(driver.findElement(btn_reassign).isEnabled(), "The flight is not finalized");

		return this;
	}


	public OPR016 reopenFlight(String carrCode, String fltNo, String fltDt) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		listFinalized(carrCode, fltNo, fltDt);
		click(btn_reOpen);

		Assert.assertTrue(waitForElement(Btn_Finalize).isEnabled(), "The flight is not reopended.");

		return this;
	}


	/**
	 * Created by A-7605
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @return
	 * @author Arun A-7681
	 */

	public OPR016 finalizeBulkShipment(String carrierCode, String flightNo, String flightDate) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);

		enterKeys((txt_FlightCarrierCode), carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		//enterKeys(txt_FlightDate, flightDate);
		enterKeys(txt_FlightDate, ".");
		click(btn_list);
		minWait();
		click(Btn_AWB);
		check(Chkbox_SelectAll);
		selectByIndex(Lst_assignToULD, 1);
		click(Btn_AssignToULD);
		minWait();
		click(Btn_Savebutton);
		minWait();

		click(Btn_PrintManifest);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		click(Btn_PrintManifest_Close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(Btn_Finalize);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys((ATD_txt_FlightTime), "-1");
		waitForElement(ATD_Btn_Save);
		click(ATD_Btn_Save);
		switchToFirstWindow();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Checks the status of the given flight
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param fltStatus
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 checkfltStatus(String carrCode, String fltNo, String fltDt, String fltStatus) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		if (fltStatus.equalsIgnoreCase("Finalized")) {
			listFinalized(carrCode, fltNo, fltDt);
		} else {
			list(carrCode, fltNo, fltDt);
		}

		Assert.assertTrue(waitForElement(info_fltStatus).getText().trim().equalsIgnoreCase(fltStatus), "The Flight Status is not as expected");

		return this;
	}

	/**
	 * Clears the form
	 *
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 clear() {

		minWait();
		waitForElement(btn_close);
		minWait();
		Actions action = new Actions(driver);
		action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();
		minWait();
		//click(btn_clear);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * Verify if AWB is present in LPRL
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @return
	 * @author A=7681
	 */
	public OPR016 verifyAWBinLPRL(String carrCode, String fltNo, String fltDt, String awbNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		list(carrCode, fltNo, fltDt);

		click(Btn_AWB);
		System.out.println(getTableColumnValues(tbl_awb, 5));

		Assert.assertTrue(verifyValuePresentInTblColumn(tbl_awb, 5, awbNo), "The AWB is not present in LPRL details Table");

		return this;
	}

	/**
	 * Verify if AWB is present in LPRL with wt and pcs
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @return
	 * @author A=7681
	 */
	public OPR016 verifyAWBinLPRLPcsWt(String carrCode, String fltNo, String fltDt, String awbNo, String pcs, String wt) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);

		list(carrCode, fltNo, fltDt);

		click(Btn_AWB);
		Assert.assertTrue(tblGetTextByColValue(tbl_awb, 9, 5, awbNo).trim().equals(pcs), "The number of pieces is not as expected.");
		Assert.assertTrue(tblGetTextByColValue(tbl_awb, 10, 5, awbNo).trim().equals(wt), "The weight is not as expected.");

		return this;
	}

	/**
	 * Verify if ULD is present in LPRL
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param uldNo
	 * @return
	 * @author A-7681
	 */
	public OPR016 verifyULDinLPRL(String carrCode, String fltNo, String fltDt, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		click(tab_uld);
		Assert.assertTrue(getTableColumnValues(tbl_uld, 3).contains((String) uldNo), "The ULD is not present in LPRL details Table");

		return this;
	}

	/**
	 * Verify shipment is successfully Built up
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 verifyAWBBuiltUp(String carrCode, String fltNo, String fltDt, String awbNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		list(carrCode, fltNo, fltDt);

		click(link_expandAll);
		Assert.assertTrue(getTableColumnValues(tbl_shpmntDtls, 12).contains((String) awbNo), "The AWB is not present in Shipment details Table");

		return this;
	}

	/**
	 * Verify shipment is successfully Built up
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 verifyAWBBuiltUpPcsWt(String carrCode, String fltNo, String fltDt, String awbNo, String pcs, String wt) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);

		list(carrCode, fltNo, fltDt);

		click(link_expandAll);
		Assert.assertTrue(getTableColumnValues(tbl_shpmntDtls, 12).contains((String) awbNo), "The AWB is not present in Shipment details Table");
		Assert.assertTrue(tblGetTextByColValue(tbl_shpmntDtls, 14, 12, awbNo).split("\\*")[0].trim().equals(pcs), "The number of pieces is not as expected in shipment details table.");
		Assert.assertTrue(tblGetTextByColValue(tbl_shpmntDtls, 15, 12, awbNo).split("\\*")[0].trim().equals(wt), "The weight is not as expected in shipment details table.");

		return this;
	}

	/**
	 * Verify shipment is not Built up
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 verifyAWBnotBuiltUp(String carrCode, String fltNo, String fltDt, String awbNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		list(carrCode, fltNo, fltDt);

		click(link_expandAll);
		Assert.assertFalse(getTableColumnValues(tbl_shpmntDtls, 12).contains((String) awbNo), "The AWB is present in Shipment details Table");

		return this;
	}

	/**
	 * Verify ULD is not Built up
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param uldNo
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 verifyULDnotBuiltUp(String carrCode, String fltNo, String fltDt, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		click(link_expandAll);
		Assert.assertFalse(getTableColumnValues(tbl_shpmntDtls, 3).contains((String) uldNo), "The ULD is present in Shipment details Table");

		return this;
	}

	public OPR016 assignULDError(String carrCode, String fltNo, String fltDt, String uldNo, String dest) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);


		list(carrCode, fltNo, fltDt);

		click(btn_assignULD);

		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys(txt_assignUldULDNo, uldNo);
		selectByText(dropDown_assignUldPOU, dest);
		click(btn_assignUldList);
		minWait();
		String status = waitForElement(info_error).getText();
		System.out.println(status);
		Assert.assertTrue(waitForElement(info_error).getText().contains("assigned to another flight"), "ERROR");

		minWait();

		return this;
	}

	/**
	 * assigns a new uld to the flight
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbPre
	 * @param awbNo
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param uldNo
	 * @param uldType
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 assignULD(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo, String dest, String pcs, String wt, String uldNo, String uldType) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);

		String tempUldNo = null;

		list(carrCode, fltNo, fltDt);

		minWait();
		click(btn_assignULD);

		waitForNewWindow(2);
		switchToSecondWindow();

		if (uldType.equalsIgnoreCase("Barrow")) {
			check(chkBx_assignULDBarrow);
			tempUldNo = BizUtility.createULDNum("KBA", "AV");
			enterKeys(txt_assignUldULDNo, tempUldNo);
			selectByText(dropDown_assignUldPOU, dest);
			click(btn_assignUldList);
			PropertyHandler.setPropValue(dataFilePath, uldNo, waitForElement(txt_assignUldULDNo).getAttribute("value"));
		} else if (uldType.equalsIgnoreCase("Bulk")) {
			enterKeys(txt_assignUldULDNo, "BULK");
			selectByText(dropDown_assignUldPOU, dest);
			click(btn_assignUldList);
			PropertyHandler.setPropValue(dataFilePath, uldNo, "BULK");
		} else {

			while (true) {
				tempUldNo = BizUtility.createULDNum("AKE", "AV");
				enterKeys(txt_assignUldULDNo, tempUldNo);
				selectByText(dropDown_assignUldPOU, dest);
				click(btn_assignUldList);
				if (verifyElementPresent(btn_genericYes)) {
					click(btn_genericYes);
					break;
				}
				click(btn_assginUldDelete);
			}
			/*** work around due to bug**//*
            tempUldNo = BizUtility.createULDNum("AKE", "AV");
            enterKeys(txt_assignUldULDNo, tempUldNo);
            selectByText(dropDown_assignUldPOU, dest);
            click(btn_assignUldList);*/
			minWait();

			PropertyHandler.setPropValue(dataFilePath, uldNo, waitForElement(txt_assignUldULDNo).getAttribute("value"));
		}

		enterKeys(txt_assignUldAwbPre, awbPre);
		enterKeys(txt_assignUldAwbNo, awbNo);
		click(btn_assignUldAwbList);
		enterKeys(txt_assignUldAwbPcs, pcs);
		enterKeys(txt_assignUldAwbWt, wt);
		click(btn_assignUldOk);
		 driver.switchTo().defaultContent();
		 
        if (verifyElementPresent(btn_genericYes)) {
            click(btn_genericYes);
        }
		
        switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		minWait();
		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * assigns a new uld to the flight with out AWB
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param dest
	 * @param uldNo
	 * @param uldType
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 assignULDwithOutAWB(String carrCode, String fltNo, String fltDt, String dest, String uldNo, String uldType) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);

		String tempUldNo = null;

		list(carrCode, fltNo, fltDt);

		click(btn_assignULD);

		waitForNewWindow(2);
		switchToSecondWindow();

		if (uldType.equalsIgnoreCase("Barrow")) {
			check(chkBx_assignULDBarrow);
			tempUldNo = BizUtility.createULDNum("KBA", "AV");
			enterKeys(txt_assignUldULDNo, tempUldNo);
			selectByText(dropDown_assignUldPOU, dest);
			click(btn_assignUldList);
			PropertyHandler.setPropValue(dataFilePath, uldNo, waitForElement(txt_assignUldULDNo).getAttribute("value"));
		} else if (uldType.equalsIgnoreCase("Bulk")) {
			enterKeys(txt_assignUldULDNo, "BULK");
			selectByText(dropDown_assignUldPOU, dest);
			click(btn_assignUldList);
			PropertyHandler.setPropValue(dataFilePath, uldNo, "BULK");
		} else {

			while (true) {
				tempUldNo = BizUtility.createULDNum("AKE", "AV");
				enterKeys(txt_assignUldULDNo, tempUldNo);
				selectByText(dropDown_assignUldPOU, dest);
				click(btn_assignUldList);
				if (verifyElementPresent(btn_genericYes)) {
					click(btn_genericYes);
					break;
				}
				click(btn_assginUldDelete);
			}
			/** work around due to issue**//*
            tempUldNo = BizUtility.createULDNum("AKE", "AV");
            enterKeys(txt_assignUldULDNo, tempUldNo);
            selectByText(dropDown_assignUldPOU, dest);
            click(btn_assignUldList);*/
			minWait();

			PropertyHandler.setPropValue(dataFilePath, uldNo, waitForElement(txt_assignUldULDNo).getAttribute("value"));
		}


		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		minWait();
		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);

		return this;
	}


	/**
	 * assigns a new uld to the flight
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbPre
	 * @param awbNo
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param uldNo
	 * @param uldType
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 assignULDwithThruBrkDwInst(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo, String dest, String pcs, String wt, String carrCode2, String fltNo2, String fltDt2, String dest2, String uldNo, String uldType) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		carrCode2 = PropertyHandler.getPropValue(dataFilePath, carrCode2);
		fltNo2 = PropertyHandler.getPropValue(dataFilePath, fltNo2);
		fltDt2 = PropertyHandler.getPropValue(dataFilePath, fltDt2);
		dest2 = PropertyHandler.getPropValue(dataFilePath, dest2);

		String tempUldNo = null;

		list(carrCode, fltNo, fltDt);

		click(btn_assignULD);

		waitForNewWindow(2);
		switchToSecondWindow();

		if (uldType.equalsIgnoreCase("Barrow")) {
			check(chkBx_assignULDBarrow);
			tempUldNo = BizUtility.createULDNum("KBA", "AV");
			enterKeys(txt_assignUldULDNo, tempUldNo);
			selectByText(dropDown_assignUldPOU, dest);
			click(btn_assignUldList);
			PropertyHandler.setPropValue(dataFilePath, uldNo, waitForElement(txt_assignUldULDNo).getAttribute("value"));
		} else if (uldType.equalsIgnoreCase("Bulk")) {
			enterKeys(txt_assignUldULDNo, "BULK");
			selectByText(dropDown_assignUldPOU, dest);
			click(btn_assignUldList);
			PropertyHandler.setPropValue(dataFilePath, uldNo, "BULK");
		} else {

			while (true) {
				tempUldNo = BizUtility.createULDNum("AKE", "AV");
				enterKeys(txt_assignUldULDNo, tempUldNo);
				selectByText(dropDown_assignUldPOU, dest);
				click(btn_assignUldList);
				if (verifyElementPresent(btn_genericYes)) {
					click(btn_genericYes);
					break;
				}
				click(btn_assginUldDelete);
			}

			/** work around due to issue**//*
            tempUldNo = BizUtility.createULDNum("AKE", "AV");
            enterKeys(txt_assignUldULDNo, tempUldNo);
            selectByText(dropDown_assignUldPOU, dest);
            click(btn_assignUldList);*/
			minWait();

			PropertyHandler.setPropValue(dataFilePath, uldNo, waitForElement(txt_assignUldULDNo).getAttribute("value"));
		}

		selectByText(dropDown_assignULDBrkDwnInst, "Thru unit");
		click(btn_assignULDBrkDwnAdd);
		enterKeys(txt_brkDwnFltCarrCode, carrCode2);
		enterKeys(txt_brkDwnFltNO, fltNo2);
		enterKeys(txt_brkDwnFltDate, fltDt2);
		enterKeys(txt_brkDwnDest, dest2);

		enterKeys(txt_assignUldAwbPre, awbPre);
		enterKeys(txt_assignUldAwbNo, awbNo);
		click(btn_assignUldAwbList);
		enterKeys(txt_assignUldAwbPcs, pcs);
		enterKeys(txt_assignUldAwbWt, wt);
		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		minWait();
		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * Assigns a ULD to flight with HAWB details
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbPre
	 * @param awbNo
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param house1
	 * @param house2
	 * @param pcs1
	 * @param pcs2
	 * @param wt1
	 * @param wt2
	 * @param uldNo
	 * @param uldType
	 * @return
	 */
	public OPR016 assignULDwithHAWB(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo, String dest, String pcs, String wt, String house1, String house2, String pcs1, String pcs2, String wt1, String wt2, String uldNo, String uldType) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		pcs1 = PropertyHandler.getPropValue(dataFilePath, pcs1);
		pcs2 = PropertyHandler.getPropValue(dataFilePath, pcs2);
		wt1 = PropertyHandler.getPropValue(dataFilePath, wt1);
		wt2 = PropertyHandler.getPropValue(dataFilePath, wt2);

		String tempUldNo = null;

		list(carrCode, fltNo, fltDt);

		click(btn_assignULD);

		waitForNewWindow(2);
		switchToSecondWindow();

		if (uldType.equalsIgnoreCase("Barrow")) {
			check(chkBx_assignULDBarrow);
			tempUldNo = BizUtility.createFlightNum();
			enterKeys(txt_assignUldULDNo, "BULK" + tempUldNo);
			selectByText(dropDown_assignUldPOU, dest);
			click(btn_assignUldList);
			PropertyHandler.setPropValue(dataFilePath, uldNo, waitForElement(txt_assignUldULDNo).getAttribute("value"));
		} else if (uldType.equalsIgnoreCase("Bulk")) {
			enterKeys(txt_assignUldULDNo, "BULK");
			selectByText(dropDown_assignUldPOU, dest);
			click(btn_assignUldList);
			PropertyHandler.setPropValue(dataFilePath, uldNo, "BULK");
		} else {

			while (true) {
				tempUldNo = BizUtility.createULDNum("AKE", "AV");
				enterKeys(txt_assignUldULDNo, tempUldNo);
				selectByText(dropDown_assignUldPOU, dest);
				click(btn_assignUldList);
				if (verifyElementPresent(btn_genericYes)) {
					click(btn_genericYes);
					break;
				}
				click(btn_assginUldDelete);
			}


			/** work around due to issue**//*
        tempUldNo = BizUtility.createULDNum("AKE", "AV");
        enterKeys(txt_assignUldULDNo, tempUldNo);
        selectByText(dropDown_assignUldPOU, dest);
        click(btn_assignUldList);*/
			minWait();

			PropertyHandler.setPropValue(dataFilePath, uldNo, waitForElement(txt_assignUldULDNo).getAttribute("value"));
		}
		enterKeys(txt_assignUldAwbPre, awbPre);
		enterKeys(txt_assignUldAwbNo, awbNo);
		click(btn_assignUldAwbList);
		enterKeys(txt_assignUldAwbPcs, pcs);
		enterKeys(txt_assignUldAwbWt, wt + Keys.TAB);

		//For HAWB
		click(btn_assignULDaddHAWB);
		maxWait();
		waitForNewWindow(3);
		switchToNthWindow(3);

		check(chkBx_HAWBcheckAll);
		click(btn_HAWBOk);

		waitForNewWindow(2);
		switchToSecondWindow();

		List<WebElement> txt_housePcs = getWebElements(list_txtHousePcs);
		List<WebElement> txt_houseWt = getWebElements(list_txtHouseWt);

		scrollToView(txt_houseWt.get(1));
		enterKeys(txt_housePcs.get(0), pcs1);
		enterKeys(txt_houseWt.get(0), wt1);
		enterKeys(txt_housePcs.get(1), pcs2);
		enterKeys(txt_houseWt.get(1), wt2);

		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * Verify the ULD is builtup to the flight
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @param uldNo
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 verifyULDBuiltUp(String carrCode, String fltNo, String fltDt, String awbNo, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		click(link_expandAll);
		Assert.assertTrue(getTableColumnValues(tbl_shpmntDtls, 3).contains((String) uldNo), "The ULD is not present in Shipment details Table");
		Assert.assertTrue(getTableColumnValues(tbl_shpmntDtls, 12).contains((String) awbNo), "The AWB is not present in Shipment details Table");

		return this;
	}

	/**
	 * Verify the ULD is builtup to the flight
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @param uldNo
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 verifyULDOnlyBuiltUp(String carrCode, String fltNo, String fltDt, String awbNo, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		click(link_expandAll);
		Assert.assertTrue(getTableColumnValues(tbl_shpmntDtls, 3).contains((String) uldNo), "The ULD is not present in Shipment details Table");
		//        Assert.assertTrue(getTableColumnValues(tbl_shpmntDtls, 12).contains((String) awbNo), "The AWB is not present in Shipment details Table");

		return this;
	}

	/**
	 * Verify if Thru check is enabled for a ULD
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param uldNo
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 verifyThruEnabled(String carrCode, String fltNo, String fltDt, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		Assert.assertTrue(tblchkBxEnabledByColValue(tbl_shpmntDtls, 20, 3, uldNo), "The Thru checkbox is not enabled");

		return this;
	}

	/**
	 * Verify the ULD is empty
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param uldNo
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 verifyULDEmpty(String carrCode, String fltNo, String fltDt, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		Assert.assertTrue(tblGetTextByColValue(tbl_shpmntDtls, 10, 3, uldNo).contains("Empty"), "The Uld Is not empty");

		return this;
	}

	public OPR016 closeForBuildUp(String carrCode, String fltNo, String fltDt) {
		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		list(carrCode, fltNo, fltDt);

		click(btn_closeBldUp);

		Assert.assertTrue(verifyElementPresent(btn_openBldUp), "The flight is not closed for BuildUp");

		return this;
	}

	/**
	 * Build Up an AWB with flight closed for BuildUp
	 *
	 * @param key_awbNo
	 * @param key_FlightCarrierCode
	 * @param key_FlightNo
	 * @param key_FlightDate
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 BulkAcceptnaceWithWarning(String key_awbNo, String key_FlightCarrierCode, String key_FlightNo,
			String key_FlightDate) {

		String data_awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
		String data_FlightCarrierCode = PropertyHandler.getPropValue(dataFilePath, key_FlightCarrierCode);
		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
		String data_FlightDate = PropertyHandler.getPropValue(dataFilePath, key_FlightDate);


		list(data_FlightCarrierCode, data_FlightNo, data_FlightDate);
		//driver.switchTo().defaultContent();
		minWait();

		click(Btn_AWB);
		//check(Chkbox_SelectAll);
		tblSelectRowByColValue(tbl_awb, 1, 5, data_awbNo);
		selectByIndex(Lst_assignToULD, 1);
		click(Btn_AssignToULD);
		driver.switchTo().defaultContent();

		Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Build up has been closed for the flight"), "The Flight is not closed for build Up while assigning AWB");
		click(btn_genericYes);
		waitForFrameAndSwitch(FRAME);

		click(Btn_Savebutton);

		return this;
	}

	/**
	 * Assign a AWB from lying list to BULK
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 assignAWBFromLyingList(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		list(carrCode, fltNo, fltDt);

		tblSelectRowByColValue(tbl_shpmntDtls, 1, 3, "BULK");
		click(btn_lyingList);
		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys(txt_lyingListFrmDt, "");
		enterKeys(txt_lyingListToDt, "");
		enterKeys(txt_lyingListAwbPre, awbPre);
		enterKeys(txt_lyingListAwbNo, awbNo);
		click(btn_lyingList_list);
		check(chkBx_lyingListAwbSelectAll);
		click(btn_lyingListOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		click(Btn_Savebutton);

		return this;
	}

	/**
	 * Assign a ULD from lying list
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 assignULDFromLyingList(String carrCode, String fltNo, String fltDt, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		click(btn_lyingList);
		waitForNewWindow(2);
		switchToSecondWindow();

		click(tab_lyingListULD);
		enterKeys(txt_lyingListFrmDt, "");
		enterKeys(txt_lyingListToDt, "");
		enterKeys(txt_lyingListUldNo, uldNo);
		click(btn_lyingList_list);
		check(chkBx_lyingListUldSelectAll);
		click(btn_lyingListOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		click(Btn_Savebutton);

		return this;
	}

	/**
	 * Assign a ULD from lying list
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 chkUldPresentInLyingList(String carrCode, String fltNo, String fltDt, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		//        tblSelectRowByColValue(tbl_shpmntDtls, 1, 3, "BULK");
		click(btn_lyingList);
		waitForNewWindow(2);
		switchToSecondWindow();

		click(tab_lyingListULD);
		enterKeys(txt_lyingListFrmDt, "");
		enterKeys(txt_lyingListToDt, "");
		enterKeys(txt_lyingListUldNo, uldNo);
		click(btn_lyingList_list);

		Assert.assertTrue(getTableColumnValues(tbl_lyingListUld, 3).contains((String) uldNo), "The ULD is not present in Lying List.");

		click(btn_lyingListClose);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		//        click(Btn_Savebutton);

		return this;
	}

	/**
	 * Assigning AWB to an ULD
	 *
	 * @param key_awbNo
	 * @param key_FlightCarrierCode
	 * @param key_FlightNo
	 * @param key_FlightDate
	 * @return
	 * @author Arun A-7681
	 */
	public OPR016 assignAWBtoULD(String key_awbNo, String key_FlightCarrierCode, String key_FlightNo,
			String key_FlightDate, String uldNo) {

		String data_awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
		String data_FlightCarrierCode = PropertyHandler.getPropValue(dataFilePath, key_FlightCarrierCode);
		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
		String data_FlightDate = PropertyHandler.getPropValue(dataFilePath, key_FlightDate);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);


		list(data_FlightCarrierCode, data_FlightNo, data_FlightDate);
		//driver.switchTo().defaultContent();
		minWait();

		click(Btn_AWB);
		//check(Chkbox_SelectAll);
		tblSelectRowByColValue(tbl_awb, 1, 5, data_awbNo);
		selectByText(Lst_assignToULD, uldNo);
		click(Btn_AssignToULD);

		click(Btn_Savebutton);
		minWait();

		return this;
	}

	/**
	 * Unassign an AWb from ULD
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @return
	 */
	public OPR016 unassignAWB(String carrCode, String fltNo, String fltDt, String awbNo, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		tblExpandRowByColValue(tbl_shpmntDtls, 2, 3, uldNo);
		tblSelectRowByColValue(tbl_shpmntDtls, 1, 12, awbNo);

		click(btn_unAssign);

		save();

		return this;
	}

	/**
	 * Unassign an AWb from ULD
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @return
	 */
	public OPR016 unassignULD(String carrCode, String fltNo, String fltDt, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);

		tblSelectRowByColValue(tbl_shpmntDtls, 1, 3, uldNo);

		click(btn_unAssign);

		save();

		minWait();
		return this;
	}

	/**
	 * Unassign an AWb from ULD
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbNo
	 * @return
	 */
	public OPR016 splitAndunassignAWB(String carrCode, String fltNo, String fltDt, String awbNo, String pcs, String wt, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);

		list(carrCode, fltNo, fltDt);

		tblExpandRowByColValue(tbl_shpmntDtls, 2, 3, uldNo);
		tblSelectRowByColValue(tbl_shpmntDtls, 1, 12, awbNo);

		click(btn_splitAndUnAssign);

		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(txt_splitPcs, pcs);
		enterKeys(txt_splitWt, wt);
		click(btn_splitOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		save();

		return this;
	}

	/**
	 * Reassigns a shipment to new flight
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param uldNo
	 * @param awbNo
	 * @param carrCode2
	 * @param fltNo2
	 * @param fltDt2
	 * @param pou
	 * @param uldType2
	 * @param uldNo2
	 * @return
	 * @author Arun
	 */
	public OPR016 reassignShipment(String carrCode, String fltNo, String fltDt, String uldNo, String awbNo, String pcs, String carrCode2, String fltNo2, String fltDt2, String pou, String uldType2, String uldNo2) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		carrCode2 = PropertyHandler.getPropValue(dataFilePath, carrCode2);
		fltNo2 = PropertyHandler.getPropValue(dataFilePath, fltNo2);
		fltDt2 = PropertyHandler.getPropValue(dataFilePath, fltDt2);
		pou = PropertyHandler.getPropValue(dataFilePath, pou);
		String tempUldNo = null;

		list(carrCode, fltNo, fltDt);

		tblSelectRowByColValue(tbl_shpmntDtls, 1, 3, uldNo);
		click(btn_reassign);

		waitForNewWindow(2);
		switchToSecondWindow();

		tblSelectRowByColValue(tbl_reassignAWB, 1, 3, awbNo);
		enterKeys(txt_reassignPcs, pcs);
		scrollToView(txt_reassignULDNo);
		enterKeys(txt_reassignCarrCode, carrCode2);
		enterKeys(txt_reassignfltNo, fltNo2);
		enterKeys(txt_reassignfltDt, fltDt2);
		enterKeys(txt_reassignPOU, pou);

		if (uldType2.equalsIgnoreCase("BULK")) {
			enterKeys(txt_reassignULDNo, "BULK");
			tblSelectRowByColValue(tbl_reassignAWB, 1, 3, awbNo);
			click(btn_reassignSave);
			PropertyHandler.setPropValue(dataFilePath, uldNo2, "BULK");
		} else if (uldType2.equalsIgnoreCase("BARROW")) {
			check(chkBx_reassignULDBarrow);
			tempUldNo = BizUtility.createULDNum("KBA", "AV");
			enterKeys(txt_reassignULDNo, tempUldNo);
			PropertyHandler.setPropValue(dataFilePath, uldNo2, tempUldNo);
			tblSelectRowByColValue(tbl_reassignAWB, 1, 3, awbNo);
			click(btn_reassignSave);
		} else {
			while (true) {
				tempUldNo = BizUtility.createULDNum("AKE", "AV");
				enterKeys(txt_reassignULDNo, tempUldNo);
				PropertyHandler.setPropValue(dataFilePath, uldNo2, tempUldNo);
				tblSelectRowByColValue(tbl_reassignAWB, 1, 3, awbNo);
				click(btn_reassignSave);
				if (verifyElementPresent(btn_genericYes)) {
					click(btn_genericYes);
					break;
				}
				click(btn_genericErrorClose);
			}
		}

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		save();

		return this;
	}

	/**
	 * Reassigns a shipment to new flight with same ULD number and validate error
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param uldNo
	 * @param awbNo
	 * @param carrCode2
	 * @param fltNo2
	 * @param fltDt2
	 * @param pou
	 * @return
	 * @author Arun
	 */
	public OPR016 reassignShipmentULDError(String carrCode, String fltNo, String fltDt, String uldNo, String awbNo, String pcs, String carrCode2, String fltNo2, String fltDt2, String pou) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		carrCode2 = PropertyHandler.getPropValue(dataFilePath, carrCode2);
		fltNo2 = PropertyHandler.getPropValue(dataFilePath, fltNo2);
		fltDt2 = PropertyHandler.getPropValue(dataFilePath, fltDt2);
		pou = PropertyHandler.getPropValue(dataFilePath, pou);

		list(carrCode, fltNo, fltDt);

		tblSelectRowByColValue(tbl_shpmntDtls, 1, 3, uldNo);
		click(btn_reassign);

		waitForNewWindow(2);
		switchToSecondWindow();

		tblSelectRowByColValue(tbl_reassignAWB, 1, 3, awbNo);
		enterKeys(txt_reassignPcs, pcs);
		scrollToView(txt_reassignULDNo);
		enterKeys(txt_reassignCarrCode, carrCode2);
		enterKeys(txt_reassignfltNo, fltNo2);
		enterKeys(txt_reassignfltDt, fltDt2);
		enterKeys(txt_reassignPOU, pou);
		enterKeys(txt_reassignULDNo, uldNo);
		tblSelectRowByColValue(tbl_reassignAWB, 1, 3, awbNo);
		click(btn_reassignSave);

		Assert.assertTrue(waitForElement(info_genericErrorMsg).getText().contains("This ULD is already manifested on a different flight"), "The error Message is not as expected.");
		click(btn_genericErrorClose);
		click(btn_reassignClose);

		/* if (uldType2.equalsIgnoreCase("BULK")) {
            enterKeys(txt_reassignULDNo, "BULK");
            click(btn_reassignSave);
            PropertyHandler.setPropValue(dataFilePath, uldNo2, "BULK");
        } else if (uldType2.equalsIgnoreCase("BARROW")) {
            check(chkBx_reassignULDBarrow);
            tempUldNo = BizUtility.createULDNum("KBA", "AV");
            enterKeys(txt_reassignULDNo, tempUldNo);
            PropertyHandler.setPropValue(dataFilePath, uldNo2, tempUldNo);
            click(btn_reassignSave);
        } else {
            while (true) {
                tempUldNo = BizUtility.createULDNum("AKE", "AV");
                enterKeys(txt_reassignULDNo, tempUldNo);
                PropertyHandler.setPropValue(dataFilePath, uldNo2, tempUldNo);
                click(btn_reassignSave);
                if (verifyElementPresent(btn_genericYes)) {
                    click(btn_genericYes);
                    break;
                }
                click(btn_genericErrorClose);
            }
        }*/


		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * Reassigns a ULD/BULK/BARROW to new flight
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param uldNo
	 * @param carrCode2
	 * @param fltNo2
	 * @param fltDt2
	 * @param pou
	 * @return
	 * @author Arun
	 */
	public OPR016 reassignULD(String carrCode, String fltNo, String fltDt, String uldNo, String carrCode2, String fltNo2, String fltDt2, String pou) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		carrCode2 = PropertyHandler.getPropValue(dataFilePath, carrCode2);
		fltNo2 = PropertyHandler.getPropValue(dataFilePath, fltNo2);
		fltDt2 = PropertyHandler.getPropValue(dataFilePath, fltDt2);
		pou = PropertyHandler.getPropValue(dataFilePath, pou);

		String tempUldNo = null;

		list(carrCode, fltNo, fltDt);

		tblSelectRowByColValue(tbl_shpmntDtls, 1, 3, uldNo);

		click(btn_reassign);

		waitForNewWindow(2);
		switchToSecondWindow();

		check(chkBx_reassignFullULDReassign);

		scrollToView(txt_reassignULDNo);
		enterKeys(txt_reassignCarrCode, carrCode2);
		enterKeys(txt_reassignfltNo, fltNo2);
		enterKeys(txt_reassignfltDt, fltDt2);
		enterKeys(txt_reassignPOU, pou);

		click(btn_reassignSave);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		save();

		return this;
	}


	/**
	 * Send FFM message manually
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @return
	 */
	public OPR016 sendFFM(String carrCode, String fltNo, String fltDt) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		list(carrCode, fltNo, fltDt);

		click(btn_sendFFM);
		waitForNewWindow(2);
		switchToSecondWindow();

		click(btn_sendMsgAdd);
		selectByText(dropDown_sendMsgInterface, "NACCS");
		selectByText(dropDown_sendMsgTransmission, "MQ-SERIES");
		click(btn_sendMsgAddress);
		waitForNewWindow(3);
		switchToNthWindow(3);

		click(btn_addressOk);
		waitForNewWindow(2);
		switchToSecondWindow();

		click(btn_sendMsgOk);
		waitForNewWindow(1);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * Send FUM message manually
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @return
	 */
	public OPR016 sendFUM(String carrCode, String fltNo, String fltDt) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		list(carrCode, fltNo, fltDt);

		click(btn_sendFUM);
		waitForNewWindow(2);
		switchToSecondWindow();

		click(btn_sendMsgAdd);
		selectByText(dropDown_sendMsgInterface, "NACCS");
		selectByText(dropDown_sendMsgTransmission, "MQ-SERIES");
		click(btn_sendMsgAddress);
		waitForNewWindow(3);
		switchToNthWindow(3);

		click(btn_addressOk);
		waitForNewWindow(2);
		switchToSecondWindow();

		click(btn_sendMsgOk);
		waitForNewWindow(1);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	public OPR016 splitAndAssignULD(String carrCode, String fltNo, String fltDt, String awbNo, String uldNo, String pcs, String wt) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);

		list(carrCode, fltNo, fltDt);
		click(Btn_AWB);

		tblSelectRowByColValue(tbl_awb, 1, 5, awbNo);
		selectByText(Lst_assignToULD, uldNo);
		click(btn_splitAndAssign);
		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys(txt_splitPcs, pcs);
		enterKeys(txt_splitWt, wt);
		click(btn_splitOk);

		waitForNewWindow(1);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		save();

		return this;
	}

	public OPR016 preadvice(String carrCode, String fltNo, String fltDt, String scc, String dest) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		scc = PropertyHandler.getPropValue(dataFilePath, scc);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);

		list(carrCode, fltNo, fltDt);

		click(btn_preAdvice);
		waitForNewWindow(2);
		switchToSecondWindow();

		selectByText(dropDown_preAdviceSCC, scc);
		selectByText(dropDown_preAdvicePOU, dest);
		click(btn_preAdviceList);
		click(radio_preAdviceFFM);
		enterKeys(txt_preAdviceRemarks, "FFM Remarks");
		click(btn_preAdviceSend);

		Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Message sent successfully"), "The FFM Message was not sent");
		click(btn_genericOk);

		click(btn_preAdviceClear);
		selectByText(dropDown_preAdviceSCC, scc);
		selectByText(dropDown_preAdvicePOU, dest);
		click(btn_preAdviceList);
		click(radio_preAdviceFFM_FWB);
		enterKeys(txt_preAdviceRemarks, "FFM and FWB Remarks");
		click(btn_preAdviceSend);

		Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Message sent successfully"), "The FFM and FWB Message was not sent");
		click(btn_genericOk);

		click(btn_preAdviceClose);
		waitForNewWindow(1);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		return this;
	}


	/**
	 * Saves transaction
	 *
	 * @author Arun
	 */
	private void save() {
		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}
		waitForFrameAndSwitch(FRAME);
	}

	/**
	 * closes the screen and goes back to home page
	 *
	 * @return
	 */
	public HomePage close() {

		click(btn_close);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {

			click(btn_genericYes);
			minWait();
		}
		return new HomePage(driver, testDataFile);
	}

	/**
	 * Created by A-7605
	 * This method will finalize flight that does not contain any shipment
	 *
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @return
	 */
	public OPR016 finalizeFlightWithoutShipment(String carrierCode, String flightNo, String flightDate) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);

		enterKeys((txt_FlightCarrierCode), carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(Btn_Savebutton);
		minWait();

		click(Btn_PrintManifest);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		click(Btn_PrintManifest_Close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(Btn_Finalize);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys((ATD_txt_FlightTime), "-1");
		waitForElement(ATD_Btn_Save);
		click(ATD_Btn_Save);
		switchToFirstWindow();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Created by A-7605
	 * This method finalize flight containing AWB with 2 houses
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param house1
	 * @param house1Pcs
	 * @param house1Weight
	 * @param house2
	 * @param house2Pcs
	 * @param house2Weight
	 * @return
	 */
	public OPR016 finalizeFlightContainingAWBWithTwoHouses(String carrCode, String fltNo, String fltDt, String house1, String house1Pcs,
			String house1Weight, String house2, String house2Pcs, String house2Weight) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house1Pcs = PropertyHandler.getPropValue(dataFilePath, house1Pcs);
		house1Weight = PropertyHandler.getPropValue(dataFilePath, house1Weight);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		house2Pcs = PropertyHandler.getPropValue(dataFilePath, house2Pcs);
		house2Weight = PropertyHandler.getPropValue(dataFilePath, house2Weight);
		list(carrCode, fltNo, fltDt);
		minWait();
		click(tab_uld);
		check(Chkbox_SelectAllULD);
		click(btn_assignToFlight);
		minWait();
		check(chkbox_selectTableItem);
		click(btn_assignULD);
		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_assignULDaddHAWB);
		maxWait();
		waitForNewWindow(3);
		switchToNthWindow(3);

		check(chkBx_HAWBcheckAll);
		click(btn_HAWBOk);

		waitForNewWindow(2);
		minWait();
		switchToSecondWindow();
		waitForElement(table_AssignULD_HAWBDetails);
		scrollToView(table_AssignULD_HAWBDetails);
		int house1Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house1);
		int house2Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house2);
		List<WebElement> txt_housePcs = getWebElements(list_txtHousePcs);
		List<WebElement> txt_houseWt = getWebElements(list_txtHouseWt);
		enterKeys(txt_housePcs.get(house1Row - 1), house1Pcs);
		enterKeys(txt_houseWt.get(house1Row - 1), house1Weight);
		enterKeys(txt_housePcs.get(house2Row - 1), house2Pcs);
		enterKeys(txt_houseWt.get(house2Row - 1), house2Weight);

		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);
		PrintManifest();
		FinalizeFlight();
		return this;
	}


	public OPR016 finalizeULDShipment(String carrierCode, String flightNo, String flightDate) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);

		enterKeys((txt_FlightCarrierCode), carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		//        click(Btn_AWB);
		check(Chkbox_SelectAllULD);
		click(btn_assignToFlight);
		minWait();
		click(Btn_Savebutton);
		maxWait();

		click(Btn_PrintManifest);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		click(Btn_PrintManifest_Close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(Btn_Finalize);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys((ATD_txt_FlightTime), "-1");
		waitForElement(ATD_Btn_Save);
		click(ATD_Btn_Save);
		switchToFirstWindow();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Method to select an existing ULD from the Shipment details table
	 * Click on Assign ULD and Add Houses to that ULD
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param uldNum
	 * @param pcs1
	 * @param wt1
	 * @param pcs2
	 * @param wt2
	 * @return
	 * @author a-7868 Krishna <15/03/2018>
	 */
	public OPR016 addHAWBToULD(String carrCode, String fltNo, String fltDt, String uldNum, 
			String pcs1, String wt1, String pcs2, String wt2){

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		uldNum = PropertyHandler.getPropValue(dataFilePath, uldNum);
		pcs1 = PropertyHandler.getPropValue(dataFilePath, pcs1);
		wt1 = PropertyHandler.getPropValue(dataFilePath, wt1);
		pcs2 = PropertyHandler.getPropValue(dataFilePath, pcs2);
		wt2 = PropertyHandler.getPropValue(dataFilePath, wt2);

		enterKeys(txt_FlightCarrierCode, carrCode);
		enterKeys(txt_FlightNo, fltNo);
		enterKeys(txt_FlightDate, fltDt);
		click(btn_list);
		minWait();

		tblSelectRowByColValue(tbl_shpmntDtls, 1, 3, uldNum);
		click(btn_assignULD);

		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_assignULDaddHAWB);
		maxWait();

		waitForNewWindow(3);
		switchToNthWindow(3);
		check(chkBx_HAWBcheckAll);
		click(btn_HAWBOk);

		waitForNewWindow(2);
		switchToSecondWindow();
		List<WebElement> txt_housePcs = getWebElements(list_txtHousePcs);
		List<WebElement> txt_houseWt = getWebElements(list_txtHouseWt);
		scrollToView(txt_houseWt.get(1));
		enterKeys(txt_housePcs.get(0), pcs1);
		enterKeys(txt_houseWt.get(0), wt1);
		enterKeys(txt_housePcs.get(1), pcs2);
		enterKeys(txt_houseWt.get(1), wt2);
		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Method to click NOTOTC button, navigate to Generate NOTOC page and generate NOTOC message and return to OPR016
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param awbPre
	 * @param awbNo
	 * @return
	 * @author a-7868 Krishna <19/03/2018>
	 */
	public OPR016 navigateToGenerateNOTOC(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo){

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		enterKeys(txt_FlightCarrierCode, carrCode);
		enterKeys(txt_FlightNo, fltNo);
		enterKeys(txt_FlightDate, fltDt);
		click(btn_list);
		minWait();

		click(btn_NOTOC);
		minWait();

		//    	new OPR017(driver, testDataFile).assignUNIDandGenerateNOTOCFromOPR016(carrCode, fltNo, fltDt, awbPre, awbNo).closeToOPR016();
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * @author A-8260
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param dest
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @return
	 */
	public OPR016 assignULDWithOALAWB(String carrCode, String fltNo, String fltDt, String dest,String awbPre, String awbNo,String pcs, String wt ) 
	{
		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		list(carrCode, fltNo, fltDt);  
		click(btn_assignULD);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(txt_assignUldULDNo, "BULK");
		selectByText(dropDown_assignUldPOU, dest);
		enterKeys(txt_uldDest, dest);
		click(btn_assignUldList); 
		enterKeys(txt_assignUldAwbPre, awbPre);
		enterKeys(txt_assignUldAwbNo, awbNo);
		click(btn_assignUldAwbList);
		enterKeys(txt_assignUldAwbPcs, pcs);
		enterKeys(txt_assignUldAwbWt, wt+Keys.TAB);
		click(btn_assignULD_OK);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(Btn_PrintManifest);
		if(verifyElementPresent(msg_blk_errors))
			Assert.assertTrue(waitForElement(msg_blk_errors).getText().contains("Blocked for security reasons"), "Blocked for security reasons message validation successful");

		return this;    	
	}
	/**
	 * Created by A-7605 on 17-4-18
	 * This method finalize flight containing AWB with one house
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param house
	 * @param pieces
	 * @param weight
	 * @return
	 */
	public OPR016 finalizeFlightContainingAWBWithOneHouse_BulkShipment(String carrCode, String fltNo, String fltDt, String house, String pieces,
			String weight) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);

		list(carrCode, fltNo, fltDt);
		minWait();
		click(Btn_AWB);
		check(Chkbox_SelectAll);
		selectByIndex(Lst_assignToULD, 1);
		click(Btn_AssignToULD);
		minWait();
		check(chkbox_selectTableItem);
		click(btn_assignULD);
		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_assignULDaddHAWB);
		maxWait();
		waitForNewWindow(3);
		switchToNthWindow(3);

		check(chkBx_HAWBcheckAll);
		click(btn_HAWBOk);

		waitForNewWindow(2);
		minWait();
		switchToSecondWindow();
		waitForElement(table_AssignULD_HAWBDetails);
		scrollToView(table_AssignULD_HAWBDetails);
		maxWait();
		int house1Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house);
		List<WebElement> txt_housePcs = getWebElements(list_txtHousePcs);
		List<WebElement> txt_houseWt = getWebElements(list_txtHouseWt);
		enterKeys(txt_housePcs.get(house1Row - 1), pieces);
		enterKeys(txt_houseWt.get(house1Row - 1), weight);

		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);
		PrintManifest();
		FinalizeFlight();
		return this;
	}

	/**
	 * Created by A-7605
	 * This method finalize flight containing AWB with 2 houses
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param house1
	 * @param house1Pcs
	 * @param house1Weight
	 * @param house2
	 * @param house2Pcs
	 * @param house2Weight
	 * @return
	 */
	public OPR016 finalizeFlightContainingAWBWithTwoHouses_BulkShipment(String carrCode, String fltNo, String fltDt, String house1, String house1Pcs,
			String house1Weight, String house2, String house2Pcs, String house2Weight) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house1Pcs = PropertyHandler.getPropValue(dataFilePath, house1Pcs);
		house1Weight = PropertyHandler.getPropValue(dataFilePath, house1Weight);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		house2Pcs = PropertyHandler.getPropValue(dataFilePath, house2Pcs);
		house2Weight = PropertyHandler.getPropValue(dataFilePath, house2Weight);
		list(carrCode, fltNo, fltDt);
		click(Btn_AWB);
		check(Chkbox_SelectAll);
		selectByIndex(Lst_assignToULD, 1);
		click(Btn_AssignToULD);
		minWait();
		check(chkbox_selectTableItem);
		click(btn_assignULD);
		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_assignULDaddHAWB);
		maxWait();
		waitForNewWindow(3);
		switchToNthWindow(3);

		check(chkBx_HAWBcheckAll);
		click(btn_HAWBOk);

		waitForNewWindow(2);
		minWait();
		switchToSecondWindow();
		waitForElement(table_AssignULD_HAWBDetails);
		scrollToView(table_AssignULD_HAWBDetails);
		int house1Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house1);
		int house2Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house2);
		List<WebElement> txt_housePcs = getWebElements(list_txtHousePcs);
		List<WebElement> txt_houseWt = getWebElements(list_txtHouseWt);
		enterKeys(txt_housePcs.get(house1Row - 1), house1Pcs);
		enterKeys(txt_houseWt.get(house1Row - 1), house1Weight);
		enterKeys(txt_housePcs.get(house2Row - 1), house2Pcs);
		enterKeys(txt_houseWt.get(house2Row - 1), house2Weight);

		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);
		PrintManifest();
		FinalizeFlight();
		return this;
	}


	/**
	 * Created by A-7605
	 * This method finalize flight containing AWB with 2 houses
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param house1
	 * @param house1Pcs
	 * @param house1Weight
	 * @param house2
	 * @param house2Pcs
	 * @param house2Weight
	 * @return
	 */
	public OPR016 finalizeFlightContainingAWBWithTwoHouses_ULDShipment(String carrCode, String fltNo, String fltDt, String house1, String house1Pcs,
			String house1Weight, String house2, String house2Pcs, String house2Weight,String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house1Pcs = PropertyHandler.getPropValue(dataFilePath, house1Pcs);
		house1Weight = PropertyHandler.getPropValue(dataFilePath, house1Weight);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		house2Pcs = PropertyHandler.getPropValue(dataFilePath, house2Pcs);
		house2Weight = PropertyHandler.getPropValue(dataFilePath, house2Weight);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);
		click(tab_uld);
		tblSelectRowByColValue(tbl_uld, 1, 3, uldNo);
		click(btn_AssignedToFlight);
		minWait();
		check(chkbox_selectTableItem);
		click(btn_assignULD);
		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_assignULDaddHAWB);
		maxWait();
		waitForNewWindow(3);
		switchToNthWindow(3);

		check(chkBx_HAWBcheckAll);
		click(btn_HAWBOk);

		waitForNewWindow(2);
		minWait();
		switchToSecondWindow();
		waitForElement(table_AssignULD_HAWBDetails);
		scrollToView(table_AssignULD_HAWBDetails);
		int house1Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house1);
		int house2Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house2);
		List<WebElement> txt_housePcs = getWebElements(list_txtHousePcs);
		List<WebElement> txt_houseWt = getWebElements(list_txtHouseWt);
		enterKeys(txt_housePcs.get(house1Row - 1), house1Pcs);
		enterKeys(txt_houseWt.get(house1Row - 1), house1Weight);
		enterKeys(txt_housePcs.get(house2Row - 1), house2Pcs);
		enterKeys(txt_houseWt.get(house2Row - 1), house2Weight);

		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);
		PrintManifest();
		FinalizeFlight();
		return this;
	}


	/**
	 * Created by A-7605
	 * This method finalize flight containing AWB with 2 houses, and another awb in ULD
	 *
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param house1
	 * @param house1Pcs
	 * @param house1Weight
	 * @param house2
	 * @param house2Pcs
	 * @param house2Weight
	 * @return
	 */
	public OPR016 finalizeFlightContainingAWBWithTwoHousesInBulkShipment_AndULDShipment(String carrCode, String fltNo, String fltDt, String house1, String house1Pcs,
			String house1Weight, String house2, String house2Pcs, String house2Weight, String uldNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house1Pcs = PropertyHandler.getPropValue(dataFilePath, house1Pcs);
		house1Weight = PropertyHandler.getPropValue(dataFilePath, house1Weight);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		house2Pcs = PropertyHandler.getPropValue(dataFilePath, house2Pcs);
		house2Weight = PropertyHandler.getPropValue(dataFilePath, house2Weight);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		list(carrCode, fltNo, fltDt);
		click(tab_uld);
		tblSelectRowByColValue(tbl_uld, 1, 3, uldNo);
		click(btn_AssignedToFlight);
		minWait();
		click(Btn_AWB);
		check(Chkbox_SelectAll);
		selectByIndex(Lst_assignToULD, 2);
		click(Btn_AssignToULD);
		minWait();
		tblSelectRowByColValue(tbl_shpmntDtls, 1, 3, "BULK");
		click(btn_assignULD);
		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_assignULDaddHAWB);
		maxWait();
		waitForNewWindow(3);
		switchToNthWindow(3);

		check(chkBx_HAWBcheckAll);
		click(btn_HAWBOk);

		waitForNewWindow(2);
		minWait();
		switchToSecondWindow();
		waitForElement(table_AssignULD_HAWBDetails);
		scrollToView(table_AssignULD_HAWBDetails);
		int house1Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house1);
		int house2Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house2);
		List<WebElement> txt_housePcs = getWebElements(list_txtHousePcs);
		List<WebElement> txt_houseWt = getWebElements(list_txtHouseWt);
		enterKeys(txt_housePcs.get(house1Row - 1), house1Pcs);
		enterKeys(txt_houseWt.get(house1Row - 1), house1Weight);
		enterKeys(txt_housePcs.get(house2Row - 1), house2Pcs);
		enterKeys(txt_houseWt.get(house2Row - 1), house2Weight);

		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);
		PrintManifest();
		FinalizeFlight();
		return this;
	}
	/**
	 * Created by A-7605 on 17-5-18
	 * This method finalize flight containing two AWBs, of which one contains 2 houses and other is in bulk
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param house1AwbNo
	 * @param house1
	 * @param house1Pcs
	 * @param house1Weight
	 * @param house2
	 * @param house2Pcs
	 * @param house2Weight
	 * @return
	 */
	public OPR016 finalizeFlightContainingAWBWithTwoHouses_MorethanOneBulkAWBs(String carrCode, String fltNo, String fltDt, String house1AwbNo,String house1, String house1Pcs,
			String house1Weight, String house2, String house2Pcs, String house2Weight) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house1Pcs = PropertyHandler.getPropValue(dataFilePath, house1Pcs);
		house1Weight = PropertyHandler.getPropValue(dataFilePath, house1Weight);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		house2Pcs = PropertyHandler.getPropValue(dataFilePath, house2Pcs);
		house2Weight = PropertyHandler.getPropValue(dataFilePath, house2Weight);
		house1AwbNo = PropertyHandler.getPropValue(dataFilePath, house1AwbNo);
		
		list(carrCode, fltNo, fltDt);
		maxWait();
		click(Btn_AWB);
		tblSelectRowByColValue(tbl_awb, 1, 5, house1AwbNo);
		selectByIndex(Lst_assignToULD, 1);
		click(Btn_AssignToULD);
		minWait();		
		check(chkbox_selectTableItem);
		click(btn_assignULD);
		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_assignULDaddHAWB);
		maxWait();
		waitForNewWindow(3);
		switchToNthWindow(3);

		check(chkBx_HAWBcheckAll);
		click(btn_HAWBOk);

		waitForNewWindow(2);
		minWait();
		switchToSecondWindow();
		waitForElement(table_AssignULD_HAWBDetails);
		scrollToView(table_AssignULD_HAWBDetails);
		int house1Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house1);
		int house2Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house2);
		List<WebElement> txt_housePcs = getWebElements(list_txtHousePcs);
		List<WebElement> txt_houseWt = getWebElements(list_txtHouseWt);
		enterKeys(txt_housePcs.get(house1Row - 1), house1Pcs);
		enterKeys(txt_houseWt.get(house1Row - 1), house1Weight);
		enterKeys(txt_housePcs.get(house2Row - 1), house2Pcs);
		enterKeys(txt_houseWt.get(house2Row - 1), house2Weight);

		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(Btn_AWB);
		check(Chkbox_SelectAll);
		selectByIndex(Lst_assignToULD, 1);
		click(Btn_AssignToULD);
		minWait();		
		
		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);
		PrintManifest();
		FinalizeFlight();
		return this;
	}
	/**
	 * Created by A-7605 on 15-5-18
	 * This method finalize flight containing ULD and Bulk shipments
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @return
	 */
	public OPR016 finalizeBulkAndULDShipment(String carrierCode, String flightNo, String flightDate) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);

		enterKeys((txt_FlightCarrierCode), carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		
		click(tab_uld);
		check(Chkbox_SelectAllULD);
		click(btn_AssignedToFlight);
		minWait();
		click(Btn_AWB);
		check(Chkbox_SelectAll);
		selectByIndex(Lst_assignToULD, getAllValues(Lst_assignToULD).size() - 1);
		click(Btn_AssignToULD);
		minWait();
		
		click(Btn_Savebutton);
		maxWait();

		click(Btn_PrintManifest);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		click(Btn_PrintManifest_Close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(Btn_Finalize);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();

		enterKeys((ATD_txt_FlightTime), "-1");
		waitForElement(ATD_Btn_Save);
		click(ATD_Btn_Save);
		switchToFirstWindow();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	
	
	/**
	 * Created by A-7605 on 17-5-18
	 * This method finalize flight containing two AWBs, of which one contains 1 house and other is in bulk
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param houseAwbNo
	 * @param house
	 * @param housePcs
	 * @param houseWeight
	 * @return
	 */
	public OPR016 finalizeFlightContainingAWBWithOneHouse_MorethanOneBulkAWBs(String carrCode, String fltNo, String fltDt, String houseAwbNo,String house, String housePcs,String houseWeight) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		housePcs = PropertyHandler.getPropValue(dataFilePath, housePcs);
		houseWeight = PropertyHandler.getPropValue(dataFilePath, houseWeight);
		houseAwbNo = PropertyHandler.getPropValue(dataFilePath, houseAwbNo);
		
		list(carrCode, fltNo, fltDt);
		maxWait();
		click(Btn_AWB);
		tblSelectRowByColValue(tbl_awb, 1, 5, houseAwbNo);
		selectByIndex(Lst_assignToULD, 1);
		click(Btn_AssignToULD);
		minWait();		
		check(chkbox_selectTableItem);
		click(btn_assignULD);
		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_assignULDaddHAWB);
		maxWait();
		waitForNewWindow(3);
		switchToNthWindow(3);

		check(chkBx_HAWBcheckAll);
		click(btn_HAWBOk);

		waitForNewWindow(2);
		minWait();
		switchToSecondWindow();
		waitForElement(table_AssignULD_HAWBDetails);
		scrollToView(table_AssignULD_HAWBDetails);
		int house1Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house);
		List<WebElement> txt_housePcs = getWebElements(list_txtHousePcs);
		List<WebElement> txt_houseWt = getWebElements(list_txtHouseWt);
		enterKeys(txt_housePcs.get(house1Row - 1), housePcs);
		enterKeys(txt_houseWt.get(house1Row - 1), houseWeight);
		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(Btn_AWB);
		check(Chkbox_SelectAll);
		selectByIndex(Lst_assignToULD, 1);
		click(Btn_AssignToULD);
		minWait();		
		
		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);
		PrintManifest();
		FinalizeFlight();
		return this;
	}
	
	/**
	 * Created by A-7605 on 17-5-18
	 * This method finalize flight containing two AWBs, of which one contains 1 house and other is in ULD
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param houseAwbNo
	 * @param house
	 * @param housePcs
	 * @param houseWeight
	 * @return
	 */
	public OPR016 finalizeFlightContainingAWBWithOneHouse_MorethanOneULDAWBs(String carrCode, String fltNo, String fltDt, String houseAwbNo,String house, String housePcs,String houseWeight) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		housePcs = PropertyHandler.getPropValue(dataFilePath, housePcs);
		houseWeight = PropertyHandler.getPropValue(dataFilePath, houseWeight);
		houseAwbNo = PropertyHandler.getPropValue(dataFilePath, houseAwbNo);
		
		list(carrCode, fltNo, fltDt);
		minWait();
		click(tab_uld);
		check(Chkbox_SelectAllULD);
		click(btn_AssignedToFlight);
		minWait();	
		click(Btn_AWB);
		tblSelectRowByColValue(tbl_awb, 1, 5, houseAwbNo);
		selectByIndex(Lst_assignToULD, getAllValues(Lst_assignToULD).size() - 1);
		click(Btn_AssignToULD);
		minWait();		
		check(chkbox_selectTableItem);
		click(btn_assignULD);
		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_assignULDaddHAWB);
		maxWait();
		waitForNewWindow(3);
		switchToNthWindow(3);

		check(chkBx_HAWBcheckAll);
		click(btn_HAWBOk);

		waitForNewWindow(2);
		minWait();
		switchToSecondWindow();
		waitForElement(table_AssignULD_HAWBDetails);
		scrollToView(table_AssignULD_HAWBDetails);
		int house1Row = getTableRowNumber(table_AssignULD_HAWBDetails, 2, house);
		List<WebElement> txt_housePcs = getWebElements(list_txtHousePcs);
		List<WebElement> txt_houseWt = getWebElements(list_txtHouseWt);
		enterKeys(txt_housePcs.get(house1Row - 1), housePcs);
		enterKeys(txt_houseWt.get(house1Row - 1), houseWeight);
		click(btn_assignUldOk);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		
		
		
		click(Btn_Savebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}

		waitForFrameAndSwitch(FRAME);
		PrintManifest();
		FinalizeFlight();
		return this;
	}
	
	//A-8680
	
		public OPR016 modifytheFSUMANfile(String awbPre, String awbNo, String org, String dest, String fltNo, String fltDtwithoutYY ) throws IOException{
			awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
			awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
			org = PropertyHandler.getPropValue(dataFilePath, org);
			dest = PropertyHandler.getPropValue(dataFilePath, dest);
			fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
			fltDtwithoutYY = PropertyHandler.getPropValue(dataFilePath, fltDtwithoutYY);			

			String messagefilepath = "./resources/SampleMessages/FSU_MAN.txt";
			File file = new File(messagefilepath);
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String str; 
			String strold="";
			while ((str = br.readLine()) != null) 
			   strold += str;
			
			String split[] = strold.split("/");
			String splitawbdetails[]=split[1].split("-");
			
			int size = split.length;
			
			//modify awbpre
			modifyFile(messagefilepath,splitawbdetails[0].substring(2, 5),awbPre);
			
			//modify awb and org+dest
			modifyFile(messagefilepath,splitawbdetails[1],awbNo+org+dest);
			
			//modify fltno.
			modifyFile(messagefilepath,split[3],fltNo);
			
			//modify date
			modifyFile(messagefilepath,split[4],fltDtwithoutYY);
			
			//modify orgdest
			modifyFile(messagefilepath,split[5],org+dest);

			return this;
			
		}

	
	
	
	
	
	
	
}