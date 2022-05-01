package com.ibsplc.pageObjects;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.common.enums.StockType;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Created by a-6545 on 27/12/2017.
 */

public class OPR014 extends BasePage {
	public static String objFilepath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "OPR_FLT.properties");
	public static String genObjPath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "Generic.properties");
	public static String FRAME = "iCargoContentFrameOPR014";
	public String dataFilePath;
	private By btn_list, txt_FlightPrefix, txt_FlightNo, txt_FlightDate,
			Icon_Expand, chckbx_Bulk, btn_popUpOK,txtbx_WarehsceLocatn,
			ManifestDetailsTable_DownArrow, Table_ManifestDetails, Link_Add,
			btn_btnCloseFlight, AddManifestDetails_txt_ULDNo,
			AddManifestDetails_Btn_ListULD, AddManifestDetails_txt_AWBPrefix,
			AddManifestDetails_txt_AWBNo, AddManifestDetails_Btn_ListAWB,
			AddManifestDetails_txt_MftPcs, AddManifestDetails_txt_MftWt,
			AddManifestDetails_txt_Origin, AddManifestDetails_txt_Destination,
			AddManifestDetails_txt_StdPcs, AddManifestDetails_txt_StdWgt,
			AddManifestDetails_txt_SCC, AddManifestDetails_Link_CustomerInfo,
			AddManifestDetails_List_SCI, AddManifestDetails_Btn_Ok, Btn_List,
			btn_save, noBtn, info_error, txt_uldNo, btn_breakdown,
			chkbox_selectTableItem, brekdown_txt_su, brekdown_txt_breakdownLoc,
			brekdown_txt_recvdPcs, brekdown_txt_rcvd_Wt, brekdown_btn_save,
			brekdown_btn_close, brekdown_btn_clear, brekdown_txt_flightNo,
			brekdown_txt_flightDate, brekdown_txt_carrierCode,
			brekdown_chkbox_inTact, info_msgfootlayer, dialogueText, Btn_Close,
			btn_clear, yesBtn, info_msg, btn_noBtn, btn_list2, chkbox_nil,
			text_shipmentDescription, btn_btnDelete, btn_btnModify, text_uld,
			dropdown_pointOfLading, text_awbPrefix, text_awbNumber,
			text_originFilter, text_destinationFilter, text_sccFilter,
			btn_btnListTwo, dropdown_ULDBreakdownInstruction,
			brekdown_chkbox_thru, btn_ok, btn_btnFlagFlight,
			btn_btnULDNumberCorrection, text_correctedUldNumber,
			btn_correctULDbtOK, btn_btnAddHawb, AddManifestDetails_text_hawb,
			AddManifestDetails_text_pieces, AddManifestDetails_text_weight,
			AddManifestDetails_text_stdPieces,
			AddManifestDetails_text_stdWeight, AddManifestDetails_text_desc,
			AddManifestDetails_check_consol, AddManifestDetails_check_deconsol,
			AddManifestDetails_btn_btnDeleteHawb, checkbox_consol,
			checkbox_DeconsolReceived, checkbox_awrReceivedFlag,
			btn_btnCheckSheet, checkbox_awbRcvd, tbl_hawbDetailsTable,
			btn_btnRampTransfer, chkbox_chkAll, RampTransfer_btnRampTransfer,
			Lst_outboundUldContour, text_outboundCarrierCode,
			text_outboundFlightNumber, text_outboundFlightDate, text_pou,
			error_close, btn_btnSave, ramp_btnClose, Ramptransfer_DownArrow,
			Table_ramptransfer, ramptransferpopup_DownArrow, text_transferPcs,
			text_transferWtg, chkbox_DuplicateAWBpopup,
			Btn_DuplicateAWBpopupOk, Breakdown_btnBreakdownComplete, txt_awbNo,
			txt_awbNoPrefix, btn_shipmntDtlsAdd, tbl_brkDownTbl,
			info_fltStatus;

	private WebDriver driver;
	private String testDataFile;
	private String key_awbNo;
	private String key_AWBNo_Prefix;

	public OPR014(WebDriver driver, String testDataFile) {
		super(driver);
		this.driver = driver;
		this.testDataFile = testDataFile;
		dataFilePath = PropertyHandler.getPropValue(
				"resources\\EnvSetup.properties", "testDataDirectory")
				+ testDataFile;
		initPageElements();
	}

	private void initPageElements() {
		btn_list = MiscUtility.getWebElement(objFilepath, "OPR014_Btn_List");
		txt_FlightNo = MiscUtility.getWebElement(objFilepath,
				"OPR014_txt_FlightNo");
		txt_FlightDate = MiscUtility.getWebElement(objFilepath,
				"OPR014_txt_FlightDate");
		txt_FlightPrefix = MiscUtility.getWebElement(objFilepath,
				"OPR014_txt_FlightPrefix");
		ManifestDetailsTable_DownArrow = MiscUtility.getWebElement(objFilepath,
				"OPR014_ManifestDetailsTable_DownArrow");
		Table_ManifestDetails = MiscUtility.getWebElement(objFilepath,
				"OPR014_Table_ManifestDetails");
		txtbx_WarehsceLocatn=MiscUtility.getWebElement(objFilepath,
				"OPR014_txtbx_WarehsceLocatn");
		btn_save = MiscUtility.getWebElement(objFilepath,
				"OPR014_Btn_Savebutton");
		Btn_Close = MiscUtility.getWebElement(objFilepath, "OPR014_Btn_Close");
		btn_clear = MiscUtility.getWebElement(objFilepath, "OPR014_Btn_Clear");
		Icon_Expand = MiscUtility.getWebElement(objFilepath,
				"OPR014_Icon_Expand");
		chckbx_Bulk = MiscUtility.getWebElement(objFilepath,
				"OPR014_chckbx_Bulk");
		Link_Add = MiscUtility.getWebElement(objFilepath, "OPR014_Link_Add");
		btn_popUpOK = MiscUtility.getWebElement(objFilepath,
				"OPR014_btn_popUpOK");
		AddManifestDetails_txt_ULDNo = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_txt_ULDNo");
		AddManifestDetails_Btn_ListULD = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_Btn_ListULD");
		AddManifestDetails_txt_AWBPrefix = MiscUtility.getWebElement(
				objFilepath, "OPR014_AddManifestDetails_txt_AWBPrefix");
		AddManifestDetails_txt_AWBNo = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_txt_AWBNo");
		AddManifestDetails_Btn_ListAWB = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_Btn_ListAWB");
		AddManifestDetails_txt_MftPcs = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_txt_MftPcs");
		AddManifestDetails_txt_MftWt = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_txt_MftWt");
		AddManifestDetails_txt_Origin = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_txt_Origin");
		AddManifestDetails_txt_Destination = MiscUtility.getWebElement(
				objFilepath, "OPR014_AddManifestDetails_txt_Destination");
		AddManifestDetails_txt_StdPcs = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_txt_StdPcs");
		AddManifestDetails_txt_StdWgt = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_txt_StdWgt");
		AddManifestDetails_txt_SCC = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_txt_SCC");
		AddManifestDetails_Link_CustomerInfo = MiscUtility.getWebElement(
				objFilepath, "OPR014_AddManifestDetails_Link_CustomerInfo");
		AddManifestDetails_List_SCI = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_List_SCI");
		AddManifestDetails_Btn_Ok = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_Btn_Ok");
		btn_btnCloseFlight = MiscUtility.getWebElement(objFilepath,
				"OPR014_Btn_CloseFlight");
		dropdown_ULDBreakdownInstruction = MiscUtility.getWebElement(
				objFilepath, "OPR014_dropdown_ULDBreakdownInstruction");
		brekdown_chkbox_inTact = MiscUtility.getWebElement(objFilepath,
				"OPR014_chkbox_inTact");
		brekdown_chkbox_thru = MiscUtility.getWebElement(objFilepath,
				"OPR014_chkbox_thru");
		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		info_error = MiscUtility
				.getWebElement(genObjPath, "Generic_info_error");
		text_shipmentDescription = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_text_shipmentDescription");
		txt_uldNo = MiscUtility.getWebElement(objFilepath, "OPR014_txt_uldNo");
		btn_breakdown = MiscUtility.getWebElement(objFilepath,
				"OPR014_btn_breakdown");
		chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath,
				"OPR014_chkbox_selectTableItem");
		brekdown_txt_su = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_txt_su");
		brekdown_txt_breakdownLoc = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_txt_breakdownLoc");
		brekdown_txt_recvdPcs = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_txt_recvdPcs");
		brekdown_txt_rcvd_Wt = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_txt_rcvd_Wt");
		brekdown_btn_save = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_btn_save");
		brekdown_btn_close = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_btn_close");
		dialogueText = MiscUtility
				.getWebElement(genObjPath, "Generic_info_msg");
		brekdown_btn_clear = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_btn_clear");
		brekdown_txt_flightNo = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_txt_flightNo");
		brekdown_txt_carrierCode = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_txt_carrierCode");
		brekdown_txt_flightDate = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_txt_flightDate");
		info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		error_close = MiscUtility.getWebElement(genObjPath,
				"Generic_error_close");
		info_msgfootlayer = MiscUtility.getWebElement(genObjPath,
				"Generic_foot_layer");
		btn_btnDelete = MiscUtility.getWebElement(objFilepath,
				"OPR014_DeleteManifestDetails_btn_btnDelete");
		// btn_list2 =MiscUtility.getWebElement(objFilepath,"OPR014_btn_list2");
		chkbox_nil = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_chkbox_nil");
		btn_btnModify = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_btn_btnModify");
		text_uld = MiscUtility.getWebElement(objFilepath, "OPR014_text_uld");
		dropdown_pointOfLading = MiscUtility.getWebElement(objFilepath,
				"OPR014_dropdown_pointOfLading");
		text_awbPrefix = MiscUtility.getWebElement(objFilepath,
				"OPR014_text_awbPrefix");
		text_awbNumber = MiscUtility.getWebElement(objFilepath,
				"OPR014_text_awbNumber");
		text_originFilter = MiscUtility.getWebElement(objFilepath,
				"OPR014_text_originFilter");
		text_destinationFilter = MiscUtility.getWebElement(objFilepath,
				"OPR014_text_destinationFilter");
		text_sccFilter = MiscUtility.getWebElement(objFilepath,
				"OPR014_text_sccFilter");
		btn_btnListTwo = MiscUtility.getWebElement(objFilepath,
				"OPR014_btn_btnListTwo");
		btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		btn_btnFlagFlight = MiscUtility.getWebElement(objFilepath,
				"OPR014_brekdown_btn_btnFlagFlight");
		btn_btnULDNumberCorrection = MiscUtility.getWebElement(objFilepath,
				"OPR014_btn_btnULDNumberCorrection");
		text_correctedUldNumber = MiscUtility.getWebElement(objFilepath,
				"OPR014_text_correctedUldNumber");
		btn_correctULDbtOK = MiscUtility.getWebElement(objFilepath,
				"OPR014_CorrectULDbtn_btOK");
		btn_btnAddHawb = MiscUtility.getWebElement(objFilepath,
				"OPR014_btn_btnAddHawb");
		AddManifestDetails_text_hawb = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_text_hawb");
		AddManifestDetails_text_pieces = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_text_pieces");
		AddManifestDetails_text_weight = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_text_weight");
		AddManifestDetails_text_stdPieces = MiscUtility.getWebElement(
				objFilepath, "OPR014_AddManifestDetails_text_stdPieces");
		AddManifestDetails_text_stdWeight = MiscUtility.getWebElement(
				objFilepath, "OPR014_AddManifestDetails_text_stdWeight");
		AddManifestDetails_text_desc = MiscUtility.getWebElement(objFilepath,
				"OPR014_AddManifestDetails_text_desc");
		AddManifestDetails_check_consol = MiscUtility.getWebElement(
				objFilepath, "OPR014_AddManifestDetails_check_consol");
		AddManifestDetails_check_deconsol = MiscUtility.getWebElement(
				objFilepath, "OPR014_AddManifestDetails_check_deconsol");
		AddManifestDetails_btn_btnDeleteHawb = MiscUtility.getWebElement(
				objFilepath, "OPR014_AddManifestDetails_btn_btnDeleteHawb");
		checkbox_consol = MiscUtility.getWebElement(objFilepath,
				"OPR014_checkbox_consol");
		checkbox_DeconsolReceived = MiscUtility.getWebElement(objFilepath,
				"OPR014_checkbox_DeconsolReceived");
		checkbox_awrReceivedFlag = MiscUtility.getWebElement(objFilepath,
				"OPR014_checkbox_awrReceivedFlag");
		checkbox_awbRcvd = MiscUtility.getWebElement(objFilepath,
				"OPR014_checkbox_awbRcvd");
		tbl_hawbDetailsTable = MiscUtility.getWebElement(objFilepath,
				"OPR014_tbl_hawbDetailsTable");
		btn_btnCheckSheet = MiscUtility.getWebElement(objFilepath,
				"OPR014_btn_btnCheckSheet");
		btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		btn_btnRampTransfer = MiscUtility.getWebElement(objFilepath,
				"OPR014_btn_btnRampTransfer");
		chkbox_chkAll = MiscUtility.getWebElement(objFilepath,
				"OPR014_chkbox_chkAll");
		RampTransfer_btnRampTransfer = MiscUtility.getWebElement(objFilepath,
				"OPR014_RampTransfer_btnRampTransfer");
		Lst_outboundUldContour = MiscUtility.getWebElement(objFilepath,
				"OPR014_Lst_outboundUldContour");
		text_outboundCarrierCode = MiscUtility.getWebElement(objFilepath,
				"OPR014_text_outboundCarrierCode");
		text_outboundFlightNumber = MiscUtility.getWebElement(objFilepath,
				"OPR014_text_outboundFlightNumber");
		text_outboundFlightDate = MiscUtility.getWebElement(objFilepath,
				"OPR014_text_outboundFlightDate");
		text_pou = MiscUtility.getWebElement(objFilepath, "OPR014_text_pou");
		btn_btnSave = MiscUtility.getWebElement(objFilepath,
				"OPR014_btn_btnSave");
		ramp_btnClose = MiscUtility.getWebElement(objFilepath,
				"OPR014_ramp_btnClose");
		Ramptransfer_DownArrow = MiscUtility.getWebElement(objFilepath,
				"OPR014_Ramptransfer_DownArrow");
		Table_ramptransfer = MiscUtility.getWebElement(objFilepath,
				"OPR014_Table_ramptransfer");
		ramptransferpopup_DownArrow = MiscUtility.getWebElement(objFilepath,
				"OPR014_ramptransferpopup_DownArrow");
		text_transferPcs = MiscUtility.getWebElement(objFilepath,
				"OPR014_text_transferPcs");
		text_transferWtg = MiscUtility.getWebElement(objFilepath,
				"OPR014_text_transferWtg");
		Btn_DuplicateAWBpopupOk = MiscUtility.getWebElement(objFilepath,
				"OPR014_Btn_DuplicateAWBpopupOk");
		chkbox_DuplicateAWBpopup = MiscUtility.getWebElement(objFilepath,
				"OPR014_chkbox_DuplicateAWBpopup");
		Breakdown_btnBreakdownComplete = MiscUtility.getWebElement(objFilepath,
				"OPR014_Breakdown_btnBreakdownComplete");
		txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR014_txt_awbNo");
		txt_awbNoPrefix = MiscUtility.getWebElement(objFilepath,
				"OPR014_txt_awbNoPrefix");
		btn_list2 = MiscUtility.getWebElement(objFilepath, "OPR014_btn_list2");
		btn_shipmntDtlsAdd = MiscUtility.getWebElement(objFilepath,
				"OPR014_btn_shipmntDtlsAdd");
		tbl_brkDownTbl = MiscUtility.getWebElement(objFilepath,
				"OPR014_tbl_brkDownTbl");
		info_fltStatus = MiscUtility.getWebElement(objFilepath,
				"OPR014_info_fltStatus");
	}

	public OPR014 ShortCaptureBlacklistedShipment(String key_FlightNo,
			String key_sDate, String key_CarrierCode, String key_awbNoPrefix,
			String key_awbNo, String key_No_Pieces, String key_Weight,
			String key_Origin, String stockType, String key_Destination,
			String key_UldNo, String key_ULDtype, String key_Compcode) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String data_awbNoPrefix = PropertyHandler.getPropValue(dataFilePath,
				key_awbNoPrefix);
		String data_No_Pieces = PropertyHandler.getPropValue(dataFilePath,
				key_No_Pieces);
		String data_Weight = PropertyHandler.getPropValue(dataFilePath,
				key_Weight);
		String data_Origin = PropertyHandler.getPropValue(dataFilePath,
				key_Origin);
		String data_Destination = PropertyHandler.getPropValue(dataFilePath,
				key_Destination);
		String data_ULDtype = PropertyHandler.getPropValue(dataFilePath,
				key_ULDtype);
		String data_Compcode = PropertyHandler.getPropValue(dataFilePath,
				key_Compcode);
		String data_stockType = PropertyHandler.getPropValue(dataFilePath,
				stockType);

		minWait();

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		// enterKeys(waitForElement(txt_FlightPrefix),data_CarrierCode );
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		click(Link_Add);

		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		String UldNo = BizUtility.createULDNum(data_ULDtype, data_Compcode);
		PropertyHandler.setPropValue(dataFilePath, key_UldNo, UldNo);

		enterKeys(waitForElement(AddManifestDetails_txt_ULDNo), UldNo);
		click(AddManifestDetails_Btn_ListULD);
		driver.switchTo().defaultContent();
		minWait();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}

		StockType stock = StockType.valueOf(data_stockType.toUpperCase());
		String awbno = BizUtility.createAWBNum(stock);
		PropertyHandler.setPropValue(dataFilePath, key_awbNo, awbno);

		enterKeys(AddManifestDetails_txt_AWBPrefix, data_awbNoPrefix);
		enterKeys(AddManifestDetails_txt_AWBNo, awbno);
		click(AddManifestDetails_Btn_ListAWB);

		minWait();

		minWait();
		String status = waitForElement(info_error).getText();
		System.out.println(status);
		Assert.assertTrue(
				waitForElement(info_error).getText().contains("Blacklisted"),
				"ERROR :Data saved successfully");
		Assert.assertTrue(status.contains("Blacklisted"),
				"ERROR :Data saved successfully");
		minWait();
		return this;
	}

	public OPR014 breakdownComplete(String carrierCode, String flightNo,
			String flightDate, String bdnLoc, String rcvdPcs, String rcvdWt,
			String... uldNos) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		bdnLoc = PropertyHandler.getPropValue(dataFilePath, bdnLoc);
		rcvdPcs = PropertyHandler.getPropValue(dataFilePath, rcvdPcs);
		rcvdWt = PropertyHandler.getPropValue(dataFilePath, rcvdWt);

		enterKeys(txt_FlightPrefix, carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(ManifestDetailsTable_DownArrow);
		if (uldNos.length > 0) {
			for (String uldNo : uldNos) {
				if (!uldNo.isEmpty()) {
					uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
				} else {
					uldNo = "BULK";
				}
				tblSelectRowByColValue(Table_ManifestDetails, 1, 3, uldNo);
			}
		} else {
			check(chkbox_selectTableItem);
		}
		click(btn_breakdown);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		minWait();
		waitForFrameAndSwitch(FRAME);

		enterKeys(waitForElement(brekdown_txt_breakdownLoc), bdnLoc);
		enterKeys(waitForElement(brekdown_txt_recvdPcs), rcvdPcs);
		enterKeys(brekdown_txt_recvdPcs, Keys.TAB);
		enterKeys(waitForElement(brekdown_txt_rcvd_Wt), rcvdWt);
		click(brekdown_btn_save);
		driver.switchTo().defaultContent();
		// Assert.assertEquals(waitForElement(dialogueText).getText(),
		// "Saved successfully. Do you want to list the saved details?");
		while (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);
		click(Breakdown_btnBreakdownComplete);

		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * Navigates to breakdown screen
	 * 
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @return
	 * @author a-7681
	 */
	public OPR004 navigateToBreakdown(String carrierCode, String flightNo,
			String flightDate, String uldNo) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		enterKeys(txt_FlightPrefix, carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(ManifestDetailsTable_DownArrow);
		tblSelectRowByColValue(Table_ManifestDetails, 1, 3, uldNo);
		click(btn_breakdown);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		minWait();
		waitForFrameAndSwitch(FRAME);

		return new OPR004(driver, testDataFile);
	}

	public OPR014 breakdownUpdatePcsAndWt(String carrierCode, String flightNo,
			String flightDate, String rcvdPcs, String rcvdWt, boolean closed,
			String... uldNos) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		rcvdPcs = PropertyHandler.getPropValue(dataFilePath, rcvdPcs);
		rcvdWt = PropertyHandler.getPropValue(dataFilePath, rcvdWt);

		enterKeys(txt_FlightPrefix, carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);

		minWait();
		if (closed) {
			driver.switchTo().defaultContent();
			click(yesBtn);
			waitForFrameAndSwitch(FRAME);
		}
		click(ManifestDetailsTable_DownArrow);
		if (uldNos.length > 0) {
			for (String uldNo : uldNos) {
				if (!uldNo.isEmpty()) {
					uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
				} else {
					uldNo = "BULK";
				}
				tblSelectRowByColValue(Table_ManifestDetails, 1, 3, uldNo);
			}
		} else {
			check(chkbox_selectTableItem);
		}
		click(btn_breakdown);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		minWait();
		waitForFrameAndSwitch(FRAME);

		enterKeys(waitForElement(brekdown_txt_recvdPcs), rcvdPcs);
		enterKeys(brekdown_txt_recvdPcs, Keys.TAB);
		enterKeys(waitForElement(brekdown_txt_rcvd_Wt), rcvdWt);
		click(brekdown_btn_save);
		driver.switchTo().defaultContent();
		// Assert.assertEquals(waitForElement(dialogueText).getText(),
		// "Saved successfully. Do you want to list the saved details?");
		while (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * break down specific awbs given as argument
	 * 
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param bdnLoc
	 * @param rcvdPcs
	 * @param rcvdWt
	 * @param awbDtls
	 *            : pass in the order awbNo,bdnLoc,rcvdPcs, rcvdWt.
	 * @return
	 */
	public OPR014 breakdownAWBs(String carrierCode, String flightNo,
			String flightDate, String uldNo, String awbNo, String bdnLoc,
			String rcvdPcs, String rcvdWt, String... awbDtls) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		bdnLoc = PropertyHandler.getPropValue(dataFilePath, bdnLoc);
		rcvdPcs = PropertyHandler.getPropValue(dataFilePath, rcvdPcs);
		rcvdWt = PropertyHandler.getPropValue(dataFilePath, rcvdWt);

		enterKeys(txt_FlightPrefix, carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(ManifestDetailsTable_DownArrow);
		tblSelectRowByColValue(Table_ManifestDetails, 1, 3, uldNo);
		click(btn_breakdown);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		minWait();
		waitForFrameAndSwitch(FRAME);

		tblsetTextByColValue(tbl_brkDownTbl, 7, 3, awbNo, bdnLoc);
		tblsetTextByColValue(tbl_brkDownTbl, 8, 3, awbNo, rcvdPcs);
		tblsetTextByColValue(tbl_brkDownTbl, 9, 3, awbNo, rcvdWt);

		if (!(awbDtls.length == 0)) {
			for (int i = 0; i < awbDtls.length; i = i + 4) {
				awbNo = PropertyHandler.getPropValue(dataFilePath, awbDtls[i]);
				bdnLoc = PropertyHandler.getPropValue(dataFilePath,
						awbDtls[i + 1]);
				rcvdPcs = PropertyHandler.getPropValue(dataFilePath,
						awbDtls[i + 2]);
				rcvdWt = PropertyHandler.getPropValue(dataFilePath,
						awbDtls[i + 3]);

				tblsetTextByColValue(tbl_brkDownTbl, 7, 3, awbNo, bdnLoc);
				tblsetTextByColValue(tbl_brkDownTbl, 8, 3, awbNo, rcvdPcs);
				tblsetTextByColValue(tbl_brkDownTbl, 9, 3, awbNo, rcvdWt);
			}
		}

		click(brekdown_btn_save);
		driver.switchTo().defaultContent();
		// Assert.assertEquals(waitForElement(dialogueText).getText(),
		// "Saved successfully. Do you want to list the saved details?");
		while (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);
		click(Breakdown_btnBreakdownComplete);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	public OPR014 ShortCaptureDuplicateShipment(String key_FlightNo,
			String key_sDate, String key_CarrierCode, String key_awbNoPrefix,
			String key_awbNo, String key_No_Pieces, String key_Weight,
			String key_UldNo, String key_ULDtype, String key_Compcode) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String data_awbNoPrefix = PropertyHandler.getPropValue(dataFilePath,
				key_awbNoPrefix);
		String data_awbNo = PropertyHandler.getPropValue(dataFilePath,
				key_awbNo);
		String data_No_Pieces = PropertyHandler.getPropValue(dataFilePath,
				key_No_Pieces);
		String data_Weight = PropertyHandler.getPropValue(dataFilePath,
				key_Weight);

		String data_ULDtype = PropertyHandler.getPropValue(dataFilePath,
				key_ULDtype);
		String data_Compcode = PropertyHandler.getPropValue(dataFilePath,
				key_Compcode);

		minWait();

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		// enterKeys(waitForElement(txt_FlightPrefix),data_CarrierCode );
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		click(Link_Add);

		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		String UldNo = BizUtility.createULDNum(data_ULDtype, data_Compcode);
		PropertyHandler.setPropValue(dataFilePath, key_UldNo, UldNo);

		enterKeys(waitForElement(AddManifestDetails_txt_ULDNo), UldNo);
		click(AddManifestDetails_Btn_ListULD);
		driver.switchTo().defaultContent();
		minWait();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}

		PropertyHandler.setPropValue(dataFilePath, key_awbNo, data_awbNo);

		enterKeys(AddManifestDetails_txt_AWBPrefix, data_awbNoPrefix);
		enterKeys(AddManifestDetails_txt_AWBNo, data_awbNo);
		click(AddManifestDetails_Btn_ListAWB);
		/*
		 * driver.switchTo().defaultContent(); minWait(); if
		 * (verifyElementPresent(yesBtn)) {
		 * 
		 * click(yesBtn); }
		 */

		maxWait();
		waitForNewWindow(3);
		switchToNthWindow(3);
		check(chkbox_DuplicateAWBpopup);
		click(Btn_DuplicateAWBpopupOk);

		minWait();
		maxWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		System.out.println(AddManifestDetails_txt_StdPcs);
		System.out.println(AddManifestDetails_txt_StdWgt);
		Assert.assertTrue(waitForElementVisible(AddManifestDetails_txt_StdPcs)
				.getAttribute("value").contains(data_No_Pieces),
				"ERROR :Details not auto populated for existing duplicate shipment");
		Assert.assertTrue(waitForElementVisible(AddManifestDetails_txt_StdWgt)
				.getAttribute("value").contains(data_Weight),
				"ERROR :Details not auto populated for existing duplicate shipment");
		enterKeys(AddManifestDetails_txt_MftPcs, data_No_Pieces);
		enterKeys(AddManifestDetails_txt_MftWt, data_Weight);

		click(AddManifestDetails_Link_CustomerInfo);
		selectByText(AddManifestDetails_List_SCI, "T1");

		enterKeys(AddManifestDetails_List_SCI, Keys.ESCAPE);
		click(AddManifestDetails_Btn_Ok);
		// switch back to main window

		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_save);
		minWait();

		return this;
	}

	public OPR014 Ramptransferuld(String carrierCode, String fltNum,
			String fltNum2, String sDate, String pou) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
		pou = PropertyHandler.getPropValue(dataFilePath, pou);
		fltNum2 = PropertyHandler.getPropValue(dataFilePath, fltNum2);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		check(chkbox_selectTableItem);
		click(btn_btnRampTransfer);
		driver.switchTo().defaultContent();
		minWait();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		minWait();
		driver.switchTo().defaultContent();

		check(chkbox_chkAll);

		click(RampTransfer_btnRampTransfer);
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(text_outboundCarrierCode, carrierCode);

		selectByIndex(Lst_outboundUldContour, 1);

		enterKeys(text_outboundFlightNumber, fltNum2);
		enterKeys(text_outboundFlightDate, sDate);
		enterKeys(text_pou, pou);
		click(btn_btnSave);

		minWait();
		driver.switchTo().defaultContent();

		click(ramp_btnClose);

		return this;
	}

	public OPR014 RamptransferShipment(String carrierCode, String fltNum,
			String fltNum2, String sDate, String pou, String pcs_partial,
			String wt_partial) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
		pou = PropertyHandler.getPropValue(dataFilePath, pou);
		fltNum2 = PropertyHandler.getPropValue(dataFilePath, fltNum2);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		click(ManifestDetailsTable_DownArrow);
		minWait();

		tblSelectRowByColValue(Table_ManifestDetails, 1, 20, pou);
		click(btn_btnRampTransfer);
		driver.switchTo().defaultContent();
		minWait();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		minWait();
		driver.switchTo().defaultContent();

		click(Ramptransfer_DownArrow);
		minWait();
		tblSelectRowByColValue(Table_ramptransfer, 1, 20, pou);

		click(RampTransfer_btnRampTransfer);

		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();

		click(ramptransferpopup_DownArrow);
		enterKeys(text_transferPcs, pcs_partial);
		enterKeys(text_transferPcs, wt_partial);
		enterKeys(text_outboundCarrierCode, carrierCode);
		enterKeys(text_outboundFlightNumber, fltNum);
		enterKeys(text_outboundFlightDate, sDate);
		enterKeys(text_pou, pou);
		click(btn_btnSave);

		minWait();
		driver.switchTo().defaultContent();

		click(ramp_btnClose);

		return this;
	}

	public OPR014 checksheeterror(String carrierCode, String fltNum,
			String sDate, String ULDNo, String ULDNo2) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
		ULDNo = PropertyHandler.getPropValue(dataFilePath, ULDNo);
		ULDNo2 = PropertyHandler.getPropValue(dataFilePath, ULDNo2);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();

		tblSelectRowByColValue(Table_ManifestDetails, 1, 3, ULDNo);
		tblSelectRowByColValue(Table_ManifestDetails, 1, 3, ULDNo2);
		// driver.switchTo().defaultContent();
		click(btn_btnCheckSheet);
		minWait();
		driver.switchTo().defaultContent();
		String status = waitForElement(info_msg).getText();
		Assert.assertTrue(
				waitForElement(info_msg).getText().contains(
						"Please select a row"), "ERROR :Row error not shown");
		Assert.assertTrue(status.contains("Please select a row"),
				"ERROR :Row error not shown");
		driver.switchTo().defaultContent();
		click(btn_ok);
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	public OPR014 DeleteHAWB(String key_FlightNo, String key_sDate,
			String key_CarrierCode, String HAWBNo) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);

		HAWBNo = PropertyHandler.getPropValue(dataFilePath, HAWBNo);

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();

		check(chkbox_selectTableItem);
		click(btn_btnModify);

		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();

		tblSelectRowByColValue(tbl_hawbDetailsTable, 1, 2, HAWBNo);
		click(AddManifestDetails_btn_btnDeleteHawb);
		click(AddManifestDetails_Btn_Ok);

		// switch back to main window
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();

		check(chkbox_selectTableItem);
		click(btn_btnModify);

		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		Assert.assertFalse(
				verifyValuePresentInTblColumn(tbl_hawbDetailsTable, 2, HAWBNo),
				"Error: HAWB found after deletion");

		click(AddManifestDetails_Btn_Ok);

		// switch back to main window
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(btn_save);
		minWait();

		return this;
	}

	public OPR014 VerifyHAWB(String key_FlightNo, String key_sDate,
			String key_CarrierCode, String HAWBNo, String HAWBNo2) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);

		HAWBNo = PropertyHandler.getPropValue(dataFilePath, HAWBNo);
		HAWBNo2 = PropertyHandler.getPropValue(dataFilePath, HAWBNo2);

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();

		check(chkbox_selectTableItem);
		click(btn_btnModify);

		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();

		Assert.assertEquals(waitForElementVisible(AddManifestDetails_text_hawb)
				.getAttribute("value").contains(HAWBNo),
				"ERROR :HAWB not found");
		Assert.assertEquals(waitForElementVisible(AddManifestDetails_text_hawb)
				.getAttribute("value").contains(HAWBNo2),
				"ERROR :HAWB not found");
		click(AddManifestDetails_Btn_Ok);
		// switch back to main window
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(btn_save);
		minWait();

		return this;
	}

	public OPR014 VerifyChecks(String key_FlightNo, String key_sDate,
			String key_CarrierCode, String Tocheck) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();

		click(ManifestDetailsTable_DownArrow);

		minWait();
		if (Tocheck == "Consol") {
			Assert.assertEquals(waitForElementVisible(checkbox_consol)
					.getAttribute("checked"), "true", "Error:Not checked");
		} else if (Tocheck == "docrcvd") {
			scrollToView(checkbox_awrReceivedFlag);
			Assert.assertEquals(waitForElement(checkbox_awrReceivedFlag)
					.getAttribute("checked"), "true", "Error:Not checked");
		} else if (Tocheck == "deConsol") {
			Assert.assertEquals(waitForElement(checkbox_DeconsolReceived)
					.getAttribute("checked"), "true", "Error:Not checked");
		}

		return this;
	}

	public OPR014 CaptureHouseDetails(String key_FlightNo, String key_sDate,
			String key_CarrierCode, String hawbpcsmft, String hawbwtgmft,
			String hawbpcsstd, String hawbwtgstd, boolean Errorchkpcs,
			String hawbpcsmft_err, String hawbwtgmft_err) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);

		hawbpcsstd = PropertyHandler.getPropValue(dataFilePath, hawbpcsstd);
		hawbwtgstd = PropertyHandler.getPropValue(dataFilePath, hawbwtgstd);
		hawbpcsmft = PropertyHandler.getPropValue(dataFilePath, hawbpcsmft);
		hawbwtgmft = PropertyHandler.getPropValue(dataFilePath, hawbwtgmft);
		hawbpcsmft_err = PropertyHandler.getPropValue(dataFilePath,
				hawbpcsmft_err);
		hawbwtgmft_err = PropertyHandler.getPropValue(dataFilePath,
				hawbwtgmft_err);

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();

		check(chkbox_selectTableItem);
		click(btn_btnModify);

		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(checkbox_awbRcvd);
		click(btn_btnAddHawb);

		minWait();
		driver.switchTo().defaultContent();
		String status1 = waitForElement(info_msg).getText();
		Assert.assertTrue(
				waitForElement(info_msg).getText().contains(
						"AWB is not a consol.Do you want to mark as consol?"),
				"ERROR :Shipment not marked as consol");
		Assert.assertTrue(
				status1.contains("AWB is not a consol.Do you want to mark as consol?"),
				"ERROR :Shipment not marked as consol");
		minWait();
		click(yesBtn);
		minWait();
		driver.switchTo().defaultContent();

		Assert.assertEquals(
				waitForElementVisible(AddManifestDetails_check_consol)
						.getAttribute("checked"), "true", "Error:Not checked");
		Assert.assertEquals(
				waitForElementVisible(AddManifestDetails_check_deconsol)
						.getAttribute("checked"), "true", "Error:Not checked");
		if (Errorchkpcs) {

			enterKeys(AddManifestDetails_text_hawb, "H1");
			enterKeys(AddManifestDetails_text_pieces, hawbpcsmft_err);
			enterKeys(AddManifestDetails_text_weight, hawbwtgmft_err);
			enterKeys(AddManifestDetails_text_stdPieces, hawbpcsstd);
			enterKeys(AddManifestDetails_text_stdWeight, hawbwtgstd);
			enterKeys(AddManifestDetails_text_desc, "House1 created");

			click(AddManifestDetails_Btn_Ok);
			// switch back to main window
			minWait();
			String status = waitForElement(info_error).getText();
			System.out.println(status);
			Assert.assertTrue(
					waitForElement(info_error)
							.getText()
							.contains(
									"Manifested pieces mismatch between totals of HAWB and Master AWB"),
					"ERROR :Data saved successfully");
			// Assert.assertTrue(status.contains("Manifested pieces greater than Stated pieces."),
			// "ERROR :Data saved successfully");

			click(error_close);
			minWait();
			enterKeys(AddManifestDetails_text_pieces, hawbpcsmft);
			enterKeys(AddManifestDetails_text_weight, hawbwtgmft);
			click(AddManifestDetails_Btn_Ok);
			// switch back to main window
			minWait();
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);
			click(btn_save);
			minWait();
		}
		return this;
	}

	public OPR014 ManifestedStatedDetailsMismatch(String key_FlightNo,
			String key_sDate, String key_CarrierCode, String key_awbNoPrefix,
			String key_awbNo, String key_No_Pieces, String key_Weight,
			String key_Origin, String stockType, String key_Destination,
			String key_UldNo, String key_ULDtype, String key_Compcode,
			boolean Errorchkpcs, String key_No_Pieceserr, boolean Errorchkwtg,
			String key_Weighterr) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String data_awbNoPrefix = PropertyHandler.getPropValue(dataFilePath,
				key_awbNoPrefix);
		String data_awbNo = PropertyHandler.getPropValue(dataFilePath,
				key_awbNo);
		String data_No_Pieces = PropertyHandler.getPropValue(dataFilePath,
				key_No_Pieces);
		String data_Weight = PropertyHandler.getPropValue(dataFilePath,
				key_Weighterr);
		String data_Weighterr = PropertyHandler.getPropValue(dataFilePath,
				key_Weight);
		String data_Origin = PropertyHandler.getPropValue(dataFilePath,
				key_Origin);
		String data_Destination = PropertyHandler.getPropValue(dataFilePath,
				key_Destination);
		String data_ULDtype = PropertyHandler.getPropValue(dataFilePath,
				key_ULDtype);
		String data_Compcode = PropertyHandler.getPropValue(dataFilePath,
				key_Compcode);
		String data_stockType = PropertyHandler.getPropValue(dataFilePath,
				stockType);
		String data_No_Pieceserr = PropertyHandler.getPropValue(dataFilePath,
				key_No_Pieceserr);
		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		click(Link_Add);

		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		String UldNo = BizUtility.createULDNum(data_ULDtype, data_Compcode);
		PropertyHandler.setPropValue(dataFilePath, key_UldNo, UldNo);

		enterKeys(waitForElement(AddManifestDetails_txt_ULDNo), UldNo);
		click(AddManifestDetails_Btn_ListULD);
		driver.switchTo().defaultContent();
		minWait();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}

		StockType stock = StockType.valueOf(data_stockType.toUpperCase());
		String awbno = BizUtility.createAWBNum(stock);
		PropertyHandler.setPropValue(dataFilePath, key_awbNo, awbno);

		enterKeys(AddManifestDetails_txt_AWBPrefix, data_awbNoPrefix);
		enterKeys(AddManifestDetails_txt_AWBNo, awbno);
		click(AddManifestDetails_Btn_ListAWB);
		driver.switchTo().defaultContent();
		minWait();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		minWait();
		switchToSecondWindow();

		if (Errorchkpcs) {
			enterKeys(AddManifestDetails_txt_MftPcs, data_No_Pieces);
			enterKeys(AddManifestDetails_txt_MftWt, data_Weight);
			enterKeys(AddManifestDetails_txt_Origin, data_Origin);
			enterKeys(AddManifestDetails_txt_Destination, data_Destination);
			enterKeys(AddManifestDetails_txt_StdPcs, data_No_Pieceserr);
			enterKeys(AddManifestDetails_txt_StdWgt, data_Weight);
			enterKeys(AddManifestDetails_txt_SCC, "GEN");
			enterKeys(text_shipmentDescription, "Added Shipment");
			click(AddManifestDetails_Link_CustomerInfo);
			selectByText(AddManifestDetails_List_SCI, "T1");

			enterKeys(AddManifestDetails_List_SCI, Keys.ESCAPE);
			click(AddManifestDetails_Btn_Ok);

			minWait();
			String status = waitForElement(info_error).getText();
			System.out.println(status);
			Assert.assertTrue(
					waitForElement(info_error).getText().contains(
							"Manifested pieces greater than Stated pieces."),
					"ERROR :Data saved successfully");
			Assert.assertTrue(status
					.contains("Manifested pieces greater than Stated pieces."),
					"ERROR :Data saved successfully");
			minWait();
			enterKeys(AddManifestDetails_txt_MftPcs, data_No_Pieceserr);
			click(AddManifestDetails_Btn_Ok);
			// switch back to main window
			minWait();
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);
			click(btn_save);
			minWait();

		}
		if (Errorchkwtg) {
			enterKeys(AddManifestDetails_txt_MftPcs, data_No_Pieces);
			enterKeys(AddManifestDetails_txt_MftWt, data_Weight);
			enterKeys(AddManifestDetails_txt_Origin, data_Origin);
			enterKeys(AddManifestDetails_txt_Destination, data_Destination);
			enterKeys(AddManifestDetails_txt_StdPcs, data_No_Pieces);
			enterKeys(AddManifestDetails_txt_StdWgt, data_Weighterr);
			enterKeys(AddManifestDetails_txt_SCC, "GEN");
			enterKeys(text_shipmentDescription, "Added Shipment");
			click(AddManifestDetails_Link_CustomerInfo);
			selectByText(AddManifestDetails_List_SCI, "T1");

			enterKeys(AddManifestDetails_List_SCI, Keys.ESCAPE);
			click(AddManifestDetails_Btn_Ok);

			minWait();
			String status = waitForElement(info_error).getText();
			System.out.println(status);
			Assert.assertTrue(
					waitForElement(info_error).getText().contains(
							"Manifested weight greater than Stated weight."),
					"ERROR :Data saved successfully");
			Assert.assertTrue(status
					.contains("Manifested weight greater than Stated weight."),
					"ERROR :Data saved successfully");
			minWait();
			enterKeys(AddManifestDetails_txt_MftWt, data_Weighterr);
			click(AddManifestDetails_Btn_Ok);
			// switch back to main window
			minWait();
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);
			click(btn_save);
			minWait();

		}

		return this;
	}

	public OPR014 CorrectULDNo(String carrierCode, String fltNum, String sDate,
			boolean error_check, String key_ULDtype, String key_Compcode,
			String key_UldNo, String key_Origin, String key_Destination) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
		String data_ULDtype = PropertyHandler.getPropValue(dataFilePath,
				key_ULDtype);
		String data_Compcode = PropertyHandler.getPropValue(dataFilePath,
				key_Compcode);
		String data_UldNo = PropertyHandler.getPropValue(dataFilePath,
				key_UldNo);

		String data_Origin = PropertyHandler.getPropValue(dataFilePath,
				key_Origin);
		String data_Destination = PropertyHandler.getPropValue(dataFilePath,
				key_Destination);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		check(chkbox_selectTableItem);
		click(btn_btnULDNumberCorrection);
		minWait();

		if (error_check) {
			String status = waitForElement(info_error).getText();
			Assert.assertTrue(
					waitForElement(info_error)
							.getText()
							.contains(
									"ULD number correction not allowed. Breakdown started for the ULD"),
					"ERROR :ULD correction allowed for breakdown completed ULDs.");
			Assert.assertTrue(
					status.contains("ULD number correction not allowed. Breakdown started for the ULD"),
					"ERROR :ULD correction allowed for breakdown completed ULDs.");
			minWait();
		} else {
			driver.switchTo().defaultContent();
			waitForNewWindow(2);
			switchToSecondWindow();
			String UldNo = BizUtility.createULDNum(data_ULDtype, data_Compcode);
			PropertyHandler.setPropValue(dataFilePath, key_UldNo, UldNo);

			enterKeys(waitForElement(text_correctedUldNumber), UldNo);
			System.out.println("New ULD no:" + UldNo);
			// Click yes button ToDO
			click(btn_correctULDbtOK);
			minWait();
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {

				click(yesBtn);
			}

			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);
			click(btn_save);
			minWait();
			enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
			enterKeys(txt_FlightNo, fltNum);
			enterKeys(txt_FlightDate, sDate);
			click(btn_list);
			minWait();
			click(ManifestDetailsTable_DownArrow);
			minWait();
			// String uldnew = tblGetTextByColValue(Table_ManifestDetails, 3, 3,
			// UldNo);

			// System.out.println("Updated ULD:" + uldnew);
			Assert.assertTrue(
					verifyValuePresentInTblColumn(Table_ManifestDetails, 3,
							UldNo), "The ULD is not changed");
			click(ManifestDetailsTable_DownArrow);
			minWait();
			check(chkbox_selectTableItem);
			click(btn_btnModify);
			minWait();
			// driver.switchTo().defaultContent();
			waitForNewWindow(2);
			switchToSecondWindow();
			String status1 = waitForElementVisible(
					AddManifestDetails_txt_Origin).getAttribute("value");
			System.out.println(status1);
			String status2 = waitForElementVisible(
					AddManifestDetails_txt_Destination).getAttribute("value");
			System.out.println(status2);
			Assert.assertTrue(status1.equals(data_Origin),
					"ERROR :POL not correct on correcting ULDNo");
			Assert.assertTrue(status2.equals(data_Destination),
					"ERROR :POU not correct on correcting ULDNo");

			click(AddManifestDetails_Btn_Ok);
			// switch back to main window
			minWait();
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);

			click(btn_clear);
		}

		return this;
	}

	public OPR014 FlagFlight(String carrierCode, String fltNum, String sDate,
			boolean error_check) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		click(btn_btnFlagFlight);
		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		// driver.switchTo().defaultContent();
		minWait();
		waitForFrameAndSwitch(FRAME);
		if (error_check) {
			String status = waitForElement(info_error).getText().trim()
					.substring(0, 33);
			System.out.println(status);
			Assert.assertTrue(
					status.contains("Data capture not done for the AWB"),
					"ERROR :Flag flight successful.");

			minWait();
		}

		return this;
	}

	public OPR014 ViewManifestedDetails(String key_FlightNo, String key_sDate,
			String key_CarrierCode, String key_awbNoPrefix, String key_awbNo,
			String key_No_Pieces, String key_Weight, String key_Origin,
			String key_Destination) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String data_awbNoPrefix = PropertyHandler.getPropValue(dataFilePath,
				key_awbNoPrefix);
		String data_awbNo = PropertyHandler.getPropValue(dataFilePath,
				key_awbNo);
		String data_No_Pieces = PropertyHandler.getPropValue(dataFilePath,
				key_No_Pieces);
		String data_Weight = PropertyHandler.getPropValue(dataFilePath,
				key_Weight);
		String data_Origin = PropertyHandler.getPropValue(dataFilePath,
				key_Origin);
		String data_Destination = PropertyHandler.getPropValue(dataFilePath,
				key_Destination);

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		click(ManifestDetailsTable_DownArrow);

		Assert.assertTrue(tblGetTextByColValue(Table_ManifestDetails, 11, 8,
				data_awbNo).contains(data_No_Pieces));
		Assert.assertTrue(tblGetTextByColValue(Table_ManifestDetails, 12, 8,
				data_awbNo).contains(data_Weight));
		Assert.assertTrue(tblGetTextByColValue(Table_ManifestDetails, 15, 8,
				data_awbNo).contains(data_Origin));
		Assert.assertTrue(tblGetTextByColValue(Table_ManifestDetails, 16, 8,
				data_awbNo).contains(data_Destination));

		click(btn_clear);
		return this;
	}

	public OPR014 ViewManifestedDetailsMultiAWB(String carrCode, String fltNo,
			String fltDt, String pcs, String wt, String origin, String dest,
			String... key_awbNo) {

		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);

		enterKeys(waitForElement(txt_FlightPrefix), carrCode);
		enterKeys(txt_FlightNo, fltNo);
		enterKeys(txt_FlightDate, fltDt);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		click(ManifestDetailsTable_DownArrow);

		for (String awbNo : key_awbNo) {
			String data_awbNo = PropertyHandler.getPropValue(dataFilePath,
					awbNo);
			Assert.assertTrue(tblGetTextByColValue(Table_ManifestDetails, 11,
					8, data_awbNo).contains(pcs));
			Assert.assertTrue(tblGetTextByColValue(Table_ManifestDetails, 12,
					8, data_awbNo).contains(wt));
			Assert.assertTrue(tblGetTextByColValue(Table_ManifestDetails, 15,
					8, data_awbNo).contains(origin));
			Assert.assertTrue(tblGetTextByColValue(Table_ManifestDetails, 16,
					8, data_awbNo).contains(dest));
		}

		click(btn_clear);
		return this;
	}

	public OPR014 ViewULDChar(String key_FlightNo, String key_sDate,
			String key_CarrierCode, String key_awbNoPrefix, String key_awbNo,
			String key_No_Pieces, String key_Weight, String key_Origin,
			String key_Destination, String ULDchar) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String data_awbNoPrefix = PropertyHandler.getPropValue(dataFilePath,
				key_awbNoPrefix);
		String data_awbNo = PropertyHandler.getPropValue(dataFilePath,
				key_awbNo);
		String data_No_Pieces = PropertyHandler.getPropValue(dataFilePath,
				key_No_Pieces);
		String data_Weight = PropertyHandler.getPropValue(dataFilePath,
				key_Weight);
		String data_Origin = PropertyHandler.getPropValue(dataFilePath,
				key_Origin);
		String data_Destination = PropertyHandler.getPropValue(dataFilePath,
				key_Destination);
		ULDchar = PropertyHandler.getPropValue(dataFilePath, ULDchar);

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		click(ManifestDetailsTable_DownArrow);

		Assert.assertTrue(tblGetTextByColValue(Table_ManifestDetails, 22, 8,
				data_awbNo).contains(ULDchar));

		click(btn_clear);
		return this;
	}

	public OPR014 VerifyOnwardflightdetails(String key_FlightNo,
			String key_sDate, String key_CarrierCode, String key_awbNoPrefix,
			String key_awbNo, String key_No_Pieces, String key_Weight,
			String key_Origin, String key_Destination, String key_FlightNo2) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_FlightNo2 = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo2);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String data_awbNoPrefix = PropertyHandler.getPropValue(dataFilePath,
				key_awbNoPrefix);
		String data_awbNo = PropertyHandler.getPropValue(dataFilePath,
				key_awbNo);
		String data_No_Pieces = PropertyHandler.getPropValue(dataFilePath,
				key_No_Pieces);
		String data_Weight = PropertyHandler.getPropValue(dataFilePath,
				key_Weight);
		String data_Origin = PropertyHandler.getPropValue(dataFilePath,
				key_Origin);
		String data_Destination = PropertyHandler.getPropValue(dataFilePath,
				key_Destination);

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		click(ManifestDetailsTable_DownArrow);

		Assert.assertTrue(tblGetTextByColValue(Table_ManifestDetails, 23, 8,
				data_awbNo).contains(data_FlightNo2));
		click(btn_clear);
		return this;
	}

	public OPR014 ShortCaptureAWB(String key_FlightNo, String key_sDate,
			String key_CarrierCode, String key_awbNoPrefix, String key_awbNo,
			String key_No_Pieces, String key_Weight, String key_Origin,
			String stockType, String key_Destination, String key_UldNo) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String data_awbNoPrefix = PropertyHandler.getPropValue(dataFilePath,
				key_awbNoPrefix);
		String data_No_Pieces = PropertyHandler.getPropValue(dataFilePath,
				key_No_Pieces);
		String data_Weight = PropertyHandler.getPropValue(dataFilePath,
				key_Weight);
		String data_Origin = PropertyHandler.getPropValue(dataFilePath,
				key_Origin);
		String data_Destination = PropertyHandler.getPropValue(dataFilePath,
				key_Destination);
		String uldNo = PropertyHandler.getPropValue(dataFilePath, key_UldNo);
		String data_stockType = PropertyHandler.getPropValue(dataFilePath,
				stockType);

		minWait();

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		// enterKeys(waitForElement(txt_FlightPrefix),data_CarrierCode );
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		click(Link_Add);

		minWait();
		// driver.switchTo().defaultContent();
		switchToSecondWindow();
		waitForNewWindow(2);

		enterKeys(waitForElement(AddManifestDetails_txt_ULDNo), uldNo);
		click(AddManifestDetails_Btn_ListULD);
		driver.switchTo().defaultContent();
		minWait();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		switchToSecondWindow();
		waitForNewWindow(2);
		while (true) {
			StockType stock = StockType.valueOf(data_stockType.toUpperCase());
			String awbno = BizUtility.createAWBNum(stock);
			PropertyHandler.setPropValue(dataFilePath, key_awbNo, awbno);

			enterKeys(AddManifestDetails_txt_AWBPrefix, data_awbNoPrefix);
			enterKeys(AddManifestDetails_txt_AWBNo, awbno);
			click(AddManifestDetails_Btn_ListAWB);
			driver.switchTo().defaultContent();
			minWait();
			/*
			 * if (verifyElementPresent(yesBtn)) {
			 * 
			 * click(yesBtn); }
			 */
			/*** newly added **/
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);

				waitForNewWindow(2);

				break;
			}
			waitForNewWindow(2);
			click(waitForElement(AddManifestDetails_Btn_ListULD));
		}

		/*** newly added **/

		minWait();
		switchToSecondWindow();
		enterKeys(AddManifestDetails_txt_MftPcs, data_No_Pieces);
		enterKeys(AddManifestDetails_txt_MftWt, data_Weight);
		enterKeys(AddManifestDetails_txt_Origin, data_Origin);
		enterKeys(AddManifestDetails_txt_Destination, data_Destination);
		enterKeys(AddManifestDetails_txt_StdPcs, data_No_Pieces);
		enterKeys(AddManifestDetails_txt_StdWgt, data_Weight);
		enterKeys(AddManifestDetails_txt_SCC, "GEN");
		// enterKeys(text_shipmentDescription, "Added Shipment");
		// click(AddManifestDetails_Link_CustomerInfo);
		// selectByText(AddManifestDetails_List_SCI, "T1");

		// enterKeys(AddManifestDetails_List_SCI, Keys.ESCAPE);
		click(AddManifestDetails_Btn_Ok);
		// switch back to main window
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_save);
		minWait();

		return this;
	}

	/**
	 * Method to short capture an AWB and check whether an error message is
	 * thrown on listing the AWB
	 * 
	 * @param key_FlightNo
	 * @param key_sDate
	 * @param key_CarrierCode
	 * @param key_awbNoPrefix
	 * @param key_awbNo
	 * @param stockType
	 * @param errorMsg
	 * @return
	 * @author a-7868 Krishna <23/07/2018>
	 */
	public OPR014 ShortCaptureAWBwithError(String key_FlightNo,
			String key_sDate, String key_CarrierCode, String key_awbNoPrefix,
			String key_awbNo, String stockType, String errorMsg) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String data_awbNoPrefix = PropertyHandler.getPropValue(dataFilePath,
				key_awbNoPrefix);
		String data_stockType = PropertyHandler.getPropValue(dataFilePath,
				stockType);
		errorMsg = PropertyHandler.getPropValue(dataFilePath, errorMsg);

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		click(Link_Add);

		minWait();
		switchToSecondWindow();
		waitForNewWindow(2);

		enterKeys(waitForElement(AddManifestDetails_txt_ULDNo), "BULK");
		click(AddManifestDetails_Btn_ListULD);
		driver.switchTo().defaultContent();
		minWait();
		if (verifyElementPresent(yesBtn))
			click(yesBtn);

		switchToSecondWindow();
		waitForNewWindow(2);
		while (true) {
			StockType stock = StockType.valueOf(data_stockType.toUpperCase());
			String awbno = BizUtility.createAWBNum(stock);
			PropertyHandler.setPropValue(dataFilePath, key_awbNo, awbno);

			enterKeys(AddManifestDetails_txt_AWBPrefix, data_awbNoPrefix);
			enterKeys(AddManifestDetails_txt_AWBNo, awbno);
			click(AddManifestDetails_Btn_ListAWB);
			driver.switchTo().defaultContent();
			minWait();

			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForNewWindow(2);
				break;
			}
			waitForNewWindow(2);
			click(waitForElement(AddManifestDetails_Btn_ListULD));
		}

		minWait();
		Assert.assertTrue(
				waitForElement(info_error).getText().contains(errorMsg),
				"ERROR : Error message validation failed");
		closeAndmoveToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	public OPR014 ShortCaptureAWBinListedULD(String key_FlightNo,
			String key_sDate, String key_CarrierCode, String key_awbNoPrefix,
			String key_awbNo, String key_No_Pieces, String key_Weight,
			String key_Origin, String stockType, String key_Destination,
			String key_UldNo) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String data_awbNoPrefix = PropertyHandler.getPropValue(dataFilePath,
				key_awbNoPrefix);
		String data_No_Pieces = PropertyHandler.getPropValue(dataFilePath,
				key_No_Pieces);
		String data_Weight = PropertyHandler.getPropValue(dataFilePath,
				key_Weight);
		String data_Origin = PropertyHandler.getPropValue(dataFilePath,
				key_Origin);
		String data_Destination = PropertyHandler.getPropValue(dataFilePath,
				key_Destination);
		String uldNo = PropertyHandler.getPropValue(dataFilePath, key_UldNo);
		String data_stockType = PropertyHandler.getPropValue(dataFilePath,
				stockType);

		minWait();

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		// enterKeys(waitForElement(txt_FlightPrefix),data_CarrierCode );
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		tblSelectRowByColValue(Table_ManifestDetails, 1, 3, uldNo);

		click(btn_btnModify);

		minWait();
		driver.switchTo().defaultContent();
		switchToSecondWindow();

		click(btn_shipmntDtlsAdd);

		while (true) {
			StockType stock = StockType.valueOf(data_stockType.toUpperCase());
			String awbno = BizUtility.createAWBNum(stock);
			PropertyHandler.setPropValue(dataFilePath, key_awbNo, awbno);

			enterKeys(AddManifestDetails_txt_AWBPrefix, data_awbNoPrefix);
			enterKeys(AddManifestDetails_txt_AWBNo, awbno);
			click(AddManifestDetails_Btn_ListAWB);
			driver.switchTo().defaultContent();
			minWait();
			/*
			 * if (verifyElementPresent(yesBtn)) {
			 * 
			 * click(yesBtn); }
			 */
			/*** newly added **/
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);

				waitForNewWindow(2);

				break;
			}
			waitForNewWindow(2);
			click(waitForElement(AddManifestDetails_Btn_ListULD));
		}

		/*** newly added **/

		minWait();
		switchToSecondWindow();
		enterKeys(AddManifestDetails_txt_MftPcs, data_No_Pieces);
		enterKeys(AddManifestDetails_txt_MftWt, data_Weight);
		enterKeys(AddManifestDetails_txt_Origin, data_Origin);
		enterKeys(AddManifestDetails_txt_Destination, data_Destination);
		enterKeys(AddManifestDetails_txt_StdPcs, data_No_Pieces);
		enterKeys(AddManifestDetails_txt_StdWgt, data_Weight);
		enterKeys(AddManifestDetails_txt_SCC, "GEN");
		enterKeys(text_shipmentDescription, "Added Shipment");
		click(AddManifestDetails_Link_CustomerInfo);
		selectByText(AddManifestDetails_List_SCI, "T1");

		enterKeys(AddManifestDetails_List_SCI, Keys.ESCAPE);
		click(AddManifestDetails_Btn_Ok);
		// switch back to main window
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_save);
		minWait();

		return this;
	}

	/**
	 * Adds a uld without awb
	 * 
	 * @param key_FlightNo
	 * @param key_sDate
	 * @param key_CarrierCode
	 * @param key_UldNo
	 * @return
	 * @author a-7681
	 */
	public OPR014 addUldWithoutAWB(String key_CarrierCode, String key_FlightNo,
			String key_sDate, String key_UldNo) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String uldNo = PropertyHandler.getPropValue(dataFilePath, key_UldNo);

		minWait();

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		// enterKeys(waitForElement(txt_FlightPrefix),data_CarrierCode );
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		click(Link_Add);

		minWait();
		driver.switchTo().defaultContent();
		switchToSecondWindow();

		enterKeys(waitForElement(AddManifestDetails_txt_ULDNo), uldNo);
		click(AddManifestDetails_Btn_ListULD);

		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}

		minWait();
		click(AddManifestDetails_Btn_Ok);
		// switch back to main window
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_save);
		minWait();

		return this;
	}

	public OPR014 ShortCaptureBookedAWB(String key_FlightNo, String key_sDate,
			String key_CarrierCode, String key_awbNoPrefix, String key_awbNo,
			String key_No_Pieces, String key_Weight, String key_UldNo,
			String key_ULDtype, String key_Compcode) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String data_awbNoPrefix = PropertyHandler.getPropValue(dataFilePath,
				key_awbNoPrefix);
		String data_awbNo = PropertyHandler.getPropValue(dataFilePath,
				key_awbNo);
		String data_No_Pieces = PropertyHandler.getPropValue(dataFilePath,
				key_No_Pieces);
		String data_Weight = PropertyHandler.getPropValue(dataFilePath,
				key_Weight);

		String data_ULDtype = PropertyHandler.getPropValue(dataFilePath,
				key_ULDtype);
		String data_Compcode = PropertyHandler.getPropValue(dataFilePath,
				key_Compcode);

		minWait();

		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		// enterKeys(waitForElement(txt_FlightPrefix),data_CarrierCode );
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		click(Link_Add);

		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		String UldNo = BizUtility.createULDNum(data_ULDtype, data_Compcode);
		PropertyHandler.setPropValue(dataFilePath, key_UldNo, UldNo);

		enterKeys(waitForElement(AddManifestDetails_txt_ULDNo), UldNo);
		click(AddManifestDetails_Btn_ListULD);
		driver.switchTo().defaultContent();
		minWait();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}

		PropertyHandler.setPropValue(dataFilePath, key_awbNo, data_awbNo);

		enterKeys(AddManifestDetails_txt_AWBPrefix, data_awbNoPrefix);
		enterKeys(AddManifestDetails_txt_AWBNo, data_awbNo);
		click(AddManifestDetails_Btn_ListAWB);
		/*
		 * driver.switchTo().defaultContent(); minWait(); if
		 * (verifyElementPresent(yesBtn)) {
		 * 
		 * click(yesBtn); }
		 */
		minWait();
		maxWait();
		switchToSecondWindow();
		enterKeys(AddManifestDetails_txt_MftPcs, data_No_Pieces);
		enterKeys(AddManifestDetails_txt_MftWt, data_Weight);

		click(AddManifestDetails_Link_CustomerInfo);
		selectByText(AddManifestDetails_List_SCI, "T1");

		enterKeys(AddManifestDetails_List_SCI, Keys.ESCAPE);
		click(AddManifestDetails_Btn_Ok);
		// switch back to main window

		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_save);
		minWait();

		return this;
	}

	public OPR014 saveImportManifest(String carrierCode, String fltNum,
			String sDate) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate+Keys.TAB);
		click(btn_list);
		minWait();
		click(btn_save);
		minWait();

		return this;
	}

	public OPR014 CloseFlighterror(String carrierCode, String fltNum,
			String sDate) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		click(btn_btnCloseFlight);
		minWait();
		// driver.switchTo().defaultContent();
		String status = waitForElement(info_error).getText();
		Assert.assertTrue(
				waitForElement(info_error).getText().contains(
						"Flight not Arrived"), "ERROR :Flight is arrived.");
		Assert.assertTrue(status.contains("Flight not Arrived"),
				"ERROR :Flight is arrived.");
		minWait();

		return this;
	}

	public OPR014 CloseFlight(String carrierCode, String fltNum, String sDate) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		click(btn_btnCloseFlight);
		minWait();
		driver.switchTo().defaultContent();
		// String status1 = waitForElement(info_msg).getText();
		// Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to close the flight?"),
		// "ERROR :Flight not closed");
		minWait();
		click(yesBtn);
		minWait();
		waitForFrameAndSwitch(FRAME);
		Assert.assertEquals(waitForElement(info_fltStatus).getText().trim(),
				"Closed", "The flight " + fltNum + " is not closed.");

		return this;

	}

	public OPR014 CloseFlightDiscrepancyWarning(String carrierCode,
			String fltNum, String sDate) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		click(btn_btnCloseFlight);

		driver.switchTo().defaultContent();
		minWait();
		String status = waitForElement(info_msg).getText();
		System.out.println(status);
		Assert.assertTrue(
				waitForElement(info_msg)
						.getText()
						.contains(
								"Confirmed discrepancies shall be marked for some shipments within the flight. Do you want to continue closing the flight?"),
				"ERROR :Discrepancy warning not shown.");
		Assert.assertTrue(
				status.contains("Confirmed discrepancies shall be marked for some shipments within the flight. Do you want to continue closing the flight?"),
				"ERROR :Discrepancy warning not shown.");
		minWait();
		click(btn_noBtn);

		minWait();
		driver.switchTo().defaultContent();
		waitForFrameAndSwitch(FRAME);
		String flightno = waitForElement(txt_FlightNo).getAttribute("value");
		Assert.assertTrue(waitForElement(txt_FlightNo).getAttribute("value")
				.contains(fltNum), "ERROR :Details not found.");
		click(btn_btnCloseFlight);
		minWait();
		driver.switchTo().defaultContent();
		String status1 = waitForElement(info_msg).getText();
		Assert.assertTrue(
				waitForElement(info_msg)
						.getText()
						.contains(
								"Confirmed discrepancies shall be marked for some shipments within the flight. Do you want to continue closing the flight?"),
				"ERROR :Discrepancy warning not shown.");
		Assert.assertTrue(
				status1.contains("Confirmed discrepancies shall be marked for some shipments within the flight. Do you want to continue closing the flight?"),
				"ERROR :Discrepancy warning not shown.");
		minWait();
		click(yesBtn);

		driver.switchTo().defaultContent();
		minWait();
		waitForFrameAndSwitch(FRAME);
		/*
		 * String status2 = waitForElement(info_msgfootlayer).getText();
		 * System.out.println(status2);
		 * Assert.assertTrue(waitForElement(info_msgfootlayer
		 * ).getText().contains("Flight is closed"),
		 * "ERROR :Flight not closed");
		 * Assert.assertTrue(status2.contains("Flight is closed"),
		 * "ERROR :Flight not closed"); minWait();
		 */
		return this;

	}

	public OPR014 CreateNilManifest(String carrierCode, String fltNum,
			String sDate) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		check(chkbox_nil);
		click(btn_save);
		minWait();

		return this;
	}

	public OPR014 NilflightError(String carrierCode, String fltNum, String sDate) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		check(chkbox_nil);
		click(Link_Add);
		minWait();
		driver.switchTo().defaultContent();
		String status1 = waitForElement(info_msg).getText();
		Assert.assertTrue(
				waitForElement(info_msg).getText().contains("Flight is nill."),
				"ERROR :Flight not nill");
		Assert.assertTrue(status1.contains("Flight is nill."),
				"ERROR :Flight not nill");
		minWait();
		click(btn_ok);
		minWait();
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	public OPR014 FlightinfonotfoundError(String carrierCode, String fltNum,
			String sDate) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		// driver.switchTo().defaultContent();
		String status = waitForElement(info_error).getText();
		System.out.println(status);
		Assert.assertTrue(
				waitForElement(info_error).getText().contains(
						"Flight Information Not Available."),
				"ERROR :Flight is available.");
		Assert.assertTrue(status.contains("Flight Information Not Available."),
				"ERROR :Flight is available.");
		minWait();
		// driver.switchTo().defaultContent();

		return this;
	}

	/**
	 * Clears the form
	 * 
	 * @author a-7681
	 */
	public OPR014 clear() {
		try {
			click(btn_clear);
		} catch (Exception e) {
			Actions action = new Actions(driver);
			action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();
		}
		minWait();
		return this;
	}

	public OPR014 checkIfWeightIsProratedCorrectly(String carrierCode,
			String flightNo, String flightDate, String uldNo, String su,
			String bdnLoc, String rcvdPcs, String rcvdWt, String actualWt) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		su = PropertyHandler.getPropValue(dataFilePath, su);
		bdnLoc = PropertyHandler.getPropValue(dataFilePath, bdnLoc);
		rcvdPcs = PropertyHandler.getPropValue(dataFilePath, rcvdPcs);
		rcvdWt = PropertyHandler.getPropValue(dataFilePath, rcvdWt);
		actualWt = PropertyHandler.getPropValue(dataFilePath, actualWt);

		enterKeys(txt_FlightPrefix, carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		enterKeys(txt_uldNo, uldNo);
		click(btn_list2);
		check(chkbox_selectTableItem);
		click(btn_breakdown);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		minWait();
		waitForFrameAndSwitch(FRAME);
		enterKeys(waitForElement(brekdown_txt_su), su);
		enterKeys(waitForElement(brekdown_txt_breakdownLoc), bdnLoc);
		enterKeys(waitForElement(brekdown_txt_recvdPcs), rcvdPcs);
		enterKeys(brekdown_txt_recvdPcs, Keys.TAB);
		Assert.assertEquals(
				waitForElement(brekdown_txt_rcvd_Wt).getAttribute("value"),
				actualWt);
		return this;
	}

	public OPR014 breakdownULDShipment(String carrierCode, String flightNo,
			String flightDate, String uldNo, String su, String bdnLoc,
			String rcvdPcs, String rcvdWt, String actualWt) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		su = PropertyHandler.getPropValue(dataFilePath, su);
		bdnLoc = PropertyHandler.getPropValue(dataFilePath, bdnLoc);
		rcvdPcs = PropertyHandler.getPropValue(dataFilePath, rcvdPcs);
		rcvdWt = PropertyHandler.getPropValue(dataFilePath, rcvdWt);
		actualWt = PropertyHandler.getPropValue(dataFilePath, actualWt);

		enterKeys(txt_FlightPrefix, carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		enterKeys(txt_uldNo, uldNo);
		click(btn_list2);
		check(chkbox_selectTableItem);
		click(btn_breakdown);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		minWait();
		waitForFrameAndSwitch(FRAME);
		enterKeys(waitForElement(brekdown_txt_su), su);
		enterKeys(waitForElement(brekdown_txt_breakdownLoc), bdnLoc);
		enterKeys(waitForElement(brekdown_txt_recvdPcs), rcvdPcs);
		enterKeys(brekdown_txt_recvdPcs, Keys.TAB);
		enterKeys(waitForElement(brekdown_txt_rcvd_Wt), rcvdWt);
		click(brekdown_btn_save);
		driver.switchTo().defaultContent();
		Assert.assertEquals(waitForElement(dialogueText).getText(),
				"Saved successfully. Do you want to list the saved details?");
		click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		click(brekdown_btn_clear);
		Assert.assertEquals(waitForElement(brekdown_txt_carrierCode)
				.getAttribute("value").trim().length(), 0);
		Assert.assertEquals(
				waitForElement(brekdown_txt_flightNo).getAttribute("value")
						.trim().length(), 0);
		Assert.assertEquals(waitForElement(brekdown_txt_flightDate)
				.getAttribute("value").trim().length(), 0);
		return this;
	}

	public OPR014 DeleteShipment(String carrierCode, String fltNum, String sDate) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		check(chkbox_selectTableItem);
		click(btn_btnDelete);
		minWait();
		driver.switchTo().defaultContent();
		String status1 = waitForElement(info_msg).getText();
		Assert.assertTrue(
				waitForElement(info_msg)
						.getText()
						.contains(
								"Do you want to delete the selected ULD(s)/AWB(s) from manifest?"),
				"ERROR :Flight not closed");
		Assert.assertTrue(
				status1.contains("Do you want to delete the selected ULD(s)/AWB(s) from manifest?"),
				"ERROR :Flight not closed");
		minWait();
		click(yesBtn);
		minWait();
		driver.switchTo().defaultContent();
		waitForFrameAndSwitch(FRAME);
		click(btn_save);
		minWait();
		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		Assert.assertTrue(verifyElementPresent(Table_ManifestDetails),
				"AWB not deleted");
		minWait();
		return this;

	}

	public OPR014 ModifyShipment(String carrierCode, String fltNum,
			String sDate, String data_No_Pieces, String data_Weight) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
		data_No_Pieces = PropertyHandler.getPropValue(dataFilePath,
				data_No_Pieces);
		data_Weight = PropertyHandler.getPropValue(dataFilePath, data_Weight);
		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		check(chkbox_selectTableItem);
		click(btn_btnModify);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(AddManifestDetails_txt_MftPcs, data_No_Pieces);
		enterKeys(AddManifestDetails_txt_MftWt, data_Weight);
		click(AddManifestDetails_Btn_Ok);
		// switch back to main window
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(btn_save);
		minWait();
		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		check(chkbox_selectTableItem);
		click(btn_btnModify);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		Assert.assertTrue(waitForElement(AddManifestDetails_txt_MftPcs)
				.getAttribute("value").contains(data_No_Pieces));

		Assert.assertTrue(waitForElement(AddManifestDetails_txt_MftWt)
				.getAttribute("value").contains(data_Weight));
		click(AddManifestDetails_Btn_Ok);
		// switch back to main window
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(btn_save);
		minWait();
		return this;

	}

	public OPR014 ListWithDiffDetailsSingleAWB(String key_FlightNo,
			String key_sDate, String key_CarrierCode, String key_awbNoPrefix,
			String key_awbNo, String key_No_Pieces, String key_Weight,
			String key_Origin, String key_Destination, String searchby,
			String ULDNo, String POU, String SCC) {

		String data_FlightNo = PropertyHandler.getPropValue(dataFilePath,
				key_FlightNo);
		String data_sDate = PropertyHandler.getPropValue(dataFilePath,
				key_sDate);
		String data_CarrierCode = PropertyHandler.getPropValue(dataFilePath,
				key_CarrierCode);
		String data_awbNoPrefix = PropertyHandler.getPropValue(dataFilePath,
				key_awbNoPrefix);
		String data_awbNo = PropertyHandler.getPropValue(dataFilePath,
				key_awbNo);
		String data_No_Pieces = PropertyHandler.getPropValue(dataFilePath,
				key_No_Pieces);
		String data_Weight = PropertyHandler.getPropValue(dataFilePath,
				key_Weight);
		String data_Origin = PropertyHandler.getPropValue(dataFilePath,
				key_Origin);
		String data_Destination = PropertyHandler.getPropValue(dataFilePath,
				key_Destination);
		ULDNo = PropertyHandler.getPropValue(dataFilePath, ULDNo);
		POU = PropertyHandler.getPropValue(dataFilePath, POU);
		SCC = PropertyHandler.getPropValue(dataFilePath, SCC);
		enterKeys(waitForElement(txt_FlightPrefix), data_CarrierCode);
		enterKeys(txt_FlightNo, data_FlightNo);
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();

		if (searchby == "ULDDetails") {
			enterKeys(text_uld, ULDNo);
			click(btn_btnListTwo);
			minWait();
			// driver.switchTo().defaultContent();
			click(ManifestDetailsTable_DownArrow);
			minWait();

			String value = getTableCellValue(Table_ManifestDetails, 3, 1);
			System.out.println("Result:" + value);
			Assert.assertTrue(value.contains(ULDNo), "Error:Details not found");
		} else if (searchby == "POUDetails") {
			selectByText(dropdown_pointOfLading, data_Origin);
			click(btn_btnListTwo);
			minWait();
			// driver.switchTo().defaultContent();
			click(ManifestDetailsTable_DownArrow);
			minWait();
			String value = getTableCellValue(Table_ManifestDetails, 15, 2);
			System.out.println("Result:" + value);
			Assert.assertTrue(getTableCellValue(Table_ManifestDetails, 15, 2)
					.contains(data_Origin), "Error:Details not found");
			Assert.assertTrue(getTableCellValue(Table_ManifestDetails, 3, 1)
					.contains(ULDNo), "Error:Details not found");
		} else if (searchby == "RouteDetails") {
			enterKeys(text_originFilter, data_Origin);
			enterKeys(text_destinationFilter, data_Destination);
			click(btn_btnListTwo);
			minWait();
			// driver.switchTo().defaultContent();
			click(ManifestDetailsTable_DownArrow);
			minWait();
			Assert.assertTrue(getTableCellValue(Table_ManifestDetails, 15, 2)
					.contains(data_Origin), "Error:Details not found");
			Assert.assertTrue(getTableCellValue(Table_ManifestDetails, 16, 2)
					.contains(data_Destination), "Error:Details not found");
			Assert.assertTrue(getTableCellValue(Table_ManifestDetails, 3, 1)
					.contains(ULDNo), "Error:Details not found");
		} else if (searchby == "SCCdetails") {
			enterKeys(text_sccFilter, SCC);

			click(btn_btnListTwo);
			minWait();
			// driver.switchTo().defaultContent();
			click(ManifestDetailsTable_DownArrow);
			minWait();
			Assert.assertTrue(getTableCellValue(Table_ManifestDetails, 15, 2)
					.contains(data_Origin), "Error:Details not found");
			Assert.assertTrue(getTableCellValue(Table_ManifestDetails, 16, 2)
					.contains(data_Destination), "Error:Details not found");
			Assert.assertTrue(getTableCellValue(Table_ManifestDetails, 3, 1)
					.contains(ULDNo), "Error:Details not found");
		} else if (searchby == "AWBdetails") {
			enterKeys(text_awbPrefix, data_awbNoPrefix);
			enterKeys(text_awbNumber, data_awbNo);

			click(btn_btnListTwo);
			minWait();
			// driver.switchTo().defaultContent();
			click(ManifestDetailsTable_DownArrow);
			minWait();
			Assert.assertTrue(getTableCellValue(Table_ManifestDetails, 15, 2)
					.contains(data_Origin), "Error:Details not found");
			Assert.assertTrue(getTableCellValue(Table_ManifestDetails, 16, 2)
					.contains(data_Destination), "Error:Details not found");
			Assert.assertTrue(getTableCellValue(Table_ManifestDetails, 3, 1)
					.contains(ULDNo), "Error:Details not found");
		} else {
			System.out.println("Search specified is wrong");
		}
		click(btn_clear);
		return this;
	}

	public OPR014 GiveBreakdowninstruction(String carrierCode, String fltNum,
			String sDate, String BreakdownInstruction, String pcs, String wtg,
			String bdnloc) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wtg = PropertyHandler.getPropValue(dataFilePath, wtg);
		bdnloc = PropertyHandler.getPropValue(dataFilePath, bdnloc);

		minWait();
		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		click(ManifestDetailsTable_DownArrow);
		scrollToView(dropdown_ULDBreakdownInstruction);
		if (BreakdownInstruction == "Intact") {

			selectByText(dropdown_ULDBreakdownInstruction, "Intact Unit");
			click(btn_save);
			minWait();

			enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
			enterKeys(txt_FlightNo, fltNum);
			enterKeys(txt_FlightDate, sDate);
			click(btn_list);
			minWait();
			check(chkbox_selectTableItem);
			click(btn_breakdown);

			minWait();
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {

				click(yesBtn);
			}
			minWait();
			waitForFrameAndSwitch(FRAME);
			Assert.assertEquals(waitForElementVisible(brekdown_chkbox_inTact)
					.getAttribute("checked"), "true");
			Assert.assertTrue(waitForElement(brekdown_txt_recvdPcs)
					.getAttribute("value").contains(pcs),
					"ERROR :Intact breakdown not done");
			Assert.assertTrue(waitForElement(brekdown_txt_rcvd_Wt)
					.getAttribute("value").contains(wtg),
					"ERROR :Intact breakdown not done");
			click(brekdown_btn_close);
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {

				click(yesBtn);
			}
			waitForFrameAndSwitch(FRAME);
		} else if (BreakdownInstruction == "Thru") {
			selectByText(dropdown_ULDBreakdownInstruction, "Thru unit");
			click(btn_save);
			minWait();

			enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
			enterKeys(txt_FlightNo, fltNum);
			enterKeys(txt_FlightDate, sDate);
			click(btn_list);
			minWait();
			check(chkbox_selectTableItem);
			click(btn_breakdown);

			minWait();
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {

				click(yesBtn);
			}
			minWait();
			waitForFrameAndSwitch(FRAME);
			Assert.assertEquals(waitForElementVisible(brekdown_chkbox_thru)
					.getAttribute("checked"), "true");
			Assert.assertTrue(waitForElement(brekdown_txt_recvdPcs)
					.getAttribute("value").contains(pcs),
					"ERROR :Intact breakdown not done");
			Assert.assertTrue(waitForElement(brekdown_txt_rcvd_Wt)
					.getAttribute("value").contains(wtg),
					"ERROR :Intact breakdown not done");
			click(brekdown_btn_close);
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {

				click(yesBtn);
			}
			waitForFrameAndSwitch(FRAME);
		} else if (BreakdownInstruction == "Breakdown") {
			selectByText(dropdown_ULDBreakdownInstruction, "Breakdown");
			click(btn_save);
			minWait();

			enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
			enterKeys(txt_FlightNo, fltNum);
			enterKeys(txt_FlightDate, sDate);
			click(btn_list);
			minWait();
			check(chkbox_selectTableItem);
			click(btn_breakdown);

			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {

				click(yesBtn);
			}
			minWait();
			waitForFrameAndSwitch(FRAME);

			enterKeys(waitForElement(brekdown_txt_breakdownLoc), bdnloc);
			enterKeys(waitForElement(brekdown_txt_recvdPcs), pcs);
			enterKeys(brekdown_txt_recvdPcs, Keys.TAB);
			enterKeys(waitForElement(brekdown_txt_rcvd_Wt), wtg);
			click(brekdown_btn_save);
			driver.switchTo().defaultContent();
			Assert.assertEquals(waitForElement(dialogueText).getText(),
					"Saved successfully. Do you want to list the saved details?");
			click(yesBtn);
			waitForFrameAndSwitch(FRAME);
			click(brekdown_btn_clear);
			minWait();
			click(brekdown_btn_close);

		}
		return this;

	}

	public OPR014 closeBreakdownPage() {
		click(brekdown_btn_close);

		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	public OPR014 markFlightAsNil(String carrierCode, String flightNo,
			String flightDate) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		check(chkbox_nil);
		click(btn_save);
		driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElementVisible(info_msgfootlayer).getText()
				.contains("Saved Successfully."));
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Created by A-7605 This method will enable awb document received option
	 * for two AWBs
	 * 
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param awbNo1
	 * @param awbNo2
	 * @param uldNo
	 * @return
	 */
	public OPR014 markAWBDocumentReceivedForAWB1AndAWB2(String carrierCode,
			String flightNo, String flightDate, String awbNo1, String awbNo2,
			String uldNo) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		awbNo1 = PropertyHandler.getPropValue(dataFilePath, awbNo1);
		awbNo2 = PropertyHandler.getPropValue(dataFilePath, awbNo2);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		tblExpandRowByColValue(Table_ManifestDetails, 2, 3, uldNo);
		tblSelectRowByColValue(Table_ManifestDetails, 27, 8, awbNo1);
		tblSelectRowByColValue(Table_ManifestDetails, 27, 8, awbNo2);
		click(btn_save);
		driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElementVisible(info_msgfootlayer).getText()
				.contains("Saved Successfully."));
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	public OPR014 markAWBDocumentReceivedForSingleAWB(String carrierCode,
			String flightNo, String flightDate, String awbNo1, String uldNo) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		awbNo1 = PropertyHandler.getPropValue(dataFilePath, awbNo1);

		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		tblExpandRowByColValue(Table_ManifestDetails, 2, 3, uldNo);
		minWait();
		tblSelectRowByColValue(Table_ManifestDetails, 27, 8, awbNo1);

		click(btn_save);
		driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElementVisible(info_msgfootlayer).getText()
				.contains("Saved Successfully."));
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Created by A-7605 on 14-02-18 This method save the import manifest
	 * details after checking/unchecking deconsole checkbox based on the
	 * isDeconsol is true or false
	 * 
	 * @param carrierCode
	 * @param fltNum
	 * @param sDate
	 * @param uldNo
	 * @param isDeconsole
	 * @param awbNoPrefix
	 * @param awbNo
	 * @return
	 */
	public OPR014 saveDetails(String carrierCode, String fltNum, String sDate,
			String uldNo, boolean isDeconsole, String awbNoPrefix, String awbNo) {

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
		sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		awbNoPrefix = PropertyHandler.getPropValue(dataFilePath, awbNoPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, fltNum);
		enterKeys(txt_FlightDate, sDate);
		click(btn_list);
		minWait();
		enterKeys(txt_awbNoPrefix, awbNoPrefix);
		enterKeys(txt_awbNo, awbNo);
		enterKeys(txt_uldNo, uldNo);
		click(btn_list2);
		minWait();
		try {
			tblExpandRowByColValue(Table_ManifestDetails, 2, 3, uldNo);
		} catch (StaleElementReferenceException e) {
			minWait();
			tblExpandRowByColValue(Table_ManifestDetails, 2, 3, uldNo);

		}
		scrollToView(checkbox_DeconsolReceived);
		if (waitForElementVisible(checkbox_DeconsolReceived).getAttribute(
				"disabled") == null) {

			if (isDeconsole)
				check(checkbox_DeconsolReceived);
			else
				unCheck(checkbox_DeconsolReceived);
		}
		click(btn_save);
		minWait();

		return this;
	}

	/**
	 * Created by-7605 This method short capture awb containing single house
	 * 
	 * @param flightNo
	 * @param flightStartDate
	 * @param carrierCode
	 * @param awbNoPrefix
	 * @param awbNo
	 * @param pieces
	 * @param weight
	 * @param origin
	 * @param stockType
	 * @param destination
	 * @param uldNo
	 * @param uLDtype
	 * @param compcode
	 * @param house
	 * @return
	 */
	public OPR014 ShortCaptureAWBWithOneHouse(String flightNo,
			String flightStartDate, String carrierCode, String awbNoPrefix,
			String awbNo, String pieces, String weight, String origin,
			String stockType, String destination, String uldNo, String uLDtype,
			String compcode, String house) {

		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightStartDate = PropertyHandler.getPropValue(dataFilePath,
				flightStartDate);
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		awbNoPrefix = PropertyHandler.getPropValue(dataFilePath, awbNoPrefix);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		stockType = PropertyHandler.getPropValue(dataFilePath, stockType);
		destination = PropertyHandler.getPropValue(dataFilePath, destination);
		uLDtype = PropertyHandler.getPropValue(dataFilePath, uLDtype);
		compcode = PropertyHandler.getPropValue(dataFilePath, compcode);
		house = PropertyHandler.getPropValue(dataFilePath, house);

		minWait();

		enterKeys(waitForElement(txt_FlightPrefix), carrierCode);
		enterKeys(txt_FlightNo, flightNo);
		enterKeys(txt_FlightDate, flightStartDate);
		click(btn_list);
		minWait();
		click(Link_Add);

		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		String UldNo = BizUtility.createULDNum(uLDtype, compcode);
		PropertyHandler.setPropValue(dataFilePath, uldNo, UldNo);

		enterKeys(waitForElement(AddManifestDetails_txt_ULDNo), UldNo);
		click(AddManifestDetails_Btn_ListULD);
		driver.switchTo().defaultContent();
		minWait();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		while (true) {
			StockType stock = StockType.valueOf(stockType.toUpperCase());
			String awbno = BizUtility.createAWBNum(stock);
			PropertyHandler.setPropValue(dataFilePath, awbNo, awbno);

			enterKeys(AddManifestDetails_txt_AWBPrefix, awbNoPrefix);
			enterKeys(AddManifestDetails_txt_AWBNo, awbno);
			click(AddManifestDetails_Btn_ListAWB);
			driver.switchTo().defaultContent();
			minWait();
			/*
			 * if (verifyElementPresent(yesBtn)) {
			 * 
			 * click(yesBtn); }
			 */
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);

				waitForNewWindow(2);

				break;
			}
			waitForNewWindow(2);
			click(waitForElement(AddManifestDetails_Btn_ListULD));
		}

		minWait();
		switchToSecondWindow();
		enterKeys(AddManifestDetails_txt_MftPcs, pieces);
		enterKeys(AddManifestDetails_txt_MftWt, weight);
		enterKeys(AddManifestDetails_txt_Origin, origin);
		enterKeys(AddManifestDetails_txt_Destination, destination);
		enterKeys(AddManifestDetails_txt_StdPcs, pieces);
		enterKeys(AddManifestDetails_txt_StdWgt, weight);
		enterKeys(AddManifestDetails_txt_SCC, "GEN");
		enterKeys(text_shipmentDescription, "Added Shipment");
		click(AddManifestDetails_Link_CustomerInfo);
		selectByText(AddManifestDetails_List_SCI, "T1");

		enterKeys(AddManifestDetails_List_SCI, Keys.ESCAPE);
		click(btn_btnAddHawb);
		click(waitForElement(yesBtn));
		minWait();
		enterKeys(waitForElement(AddManifestDetails_text_hawb), house);
		enterKeys(waitForElement(AddManifestDetails_text_pieces), pieces);
		enterKeys(waitForElement(AddManifestDetails_text_weight), weight);
		enterKeys(waitForElement(AddManifestDetails_text_stdPieces), pieces);
		enterKeys(waitForElement(AddManifestDetails_text_stdWeight), weight);
		enterKeys(waitForElement(AddManifestDetails_text_desc), "Selenium");
		click(AddManifestDetails_Btn_Ok);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(btn_save);
		minWait();

		return this;
	}

	public HomePage close() {

		click(Btn_Close);

		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}

		return new HomePage(driver, testDataFile);
	}

	public OPR014 ProcessImportManifstThroughMsg(String Path, String prefix,
			String awbno, String origin, String dest,
			String carrierwithFlightno, String pcs, String wt,
			String fltDtwithoutYY) throws IOException {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);

		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

		origin = PropertyHandler.getPropValue(dataFilePath, origin);

		dest = PropertyHandler.getPropValue(dataFilePath, dest);

		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);

		wt = PropertyHandler.getPropValue(dataFilePath, wt);

		carrierwithFlightno = PropertyHandler.getPropValue(dataFilePath,
				carrierwithFlightno);
		fltDtwithoutYY = PropertyHandler.getPropValue(dataFilePath,
				fltDtwithoutYY);

		String ArrivalT = PropertyHandler.getPropValue(dataFilePath,
				"ArrivalTime");

		FSU_ARR_format(Path, prefix, awbno, origin, dest, pcs, wt,
				carrierwithFlightno, fltDtwithoutYY, ArrivalT);
		return this;
	}

	private void FSU_ARR_format(String Path, String prefix, String aWB,
			String ori, String des, String pcs, String weight,
			String flightNumber, String date, String arrivalT)
			throws IOException {

		String FSU_ARR = "FSU/11" + "\n" + prefix + "-" + aWB + ori + des
				+ "/T" + pcs + "K" + weight + "\n" + "ARR/" + flightNumber
				+ "/" + date + "/" + des + "/" + "/T" + pcs + "K" + weight
				+ "/A" + arrivalT;
		FileWriter fileWriter = new FileWriter(Path);
		fileWriter.write(FSU_ARR);
		fileWriter.close();

	}
	/**
	 * Created by-7605 Method Process Import Manifest screen and Save the data.
	 * 
	 * @param CarrierCode
	 * @param FlightNo
	 * @param fltDt	 
	 * @return
	 */
	public OPR014 processImportManifest(String CarrierCode, String FlightNo,
			String fltDt) {
		CarrierCode = PropertyHandler.getPropValue(dataFilePath, CarrierCode);
		FlightNo = PropertyHandler.getPropValue(dataFilePath, FlightNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		minWait();

		enterKeys(waitForElement(txt_FlightPrefix), CarrierCode);
		enterKeys(txt_FlightNo, FlightNo);
		enterKeys(txt_FlightDate, fltDt);
		click(btn_list);
		maxWait();
		click(chckbx_Bulk);
		click(Icon_Expand);
		click(checkbox_awrReceivedFlag);
		click(Breakdown_btnBreakdownComplete);
		minWait();
		switchToSecondWindow();
		click(btn_popUpOK);
		switchToFirstWindow();
		maxWait();
		InitialSetup.test.log(LogStatus.PASS, "Data saved successfully");
		return this;
	}
	/**
	 * Created by-7605 Method Process breakdown in Breakdown screen and verifies the status
	 * 
	 * @param CarrierCode
	 * @param FlightNo
	 * @param fltDt	,Location ,pcs,wt
	 * @return
	 */
	public OPR014 processBreakthroughOPR014(String CarrierCode, String FlightNo,
			String fltDt,String Location,String pcs,String wt){
		click(chkbox_DuplicateAWBpopup);
		enterKeys(brekdown_txt_breakdownLoc, Location);
		enterKeys(brekdown_txt_recvdPcs, pcs);
		enterKeys(brekdown_txt_rcvd_Wt, wt);
		enterKeys(txtbx_WarehsceLocatn, Location);
		click(Breakdown_btnBreakdownComplete);
		maxWait();
		enterKeys(txt_FlightPrefix, CarrierCode);
		enterKeys(txt_FlightNo, FlightNo);
		enterKeys(txt_FlightDate, fltDt);
		click(btn_list);
		minWait();
		String actualValue = driver.findElement(By.xpath("//b[contains(text(),'Breakdown Completed')]")).getText();
		if(actualValue.equalsIgnoreCase("Breakdown Completed")){
			InitialSetup.test.log(LogStatus.PASS, "Breakdown is Successful");
		} else {
			Assert.fail("Error in Message");
			InitialSetup.test.log(LogStatus.FAIL, "Breakdown is not Successful");
		
		}
		return this;
	}
	
}
