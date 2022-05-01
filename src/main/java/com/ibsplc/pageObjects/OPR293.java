package com.ibsplc.pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Created by a-6545 on 27/12/2017. Page OPR293 : Delivery Documentation
 * 
 * @author a-7868 Krishna <27/12/2017>
 */

public class OPR293 extends BasePage {
	private final static Logger logger = Logger.getLogger(OPR293.class);
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"OPR_FLT.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"Generic.properties");
	public static String FRAME = "iCargoContentFrameOPR293";
	List<WebElement> td_allDnDetails;
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	private By txt_prefix, txt_awb, btn_list, link_Cashmode, txt_billableName, txt_billableRemark, btn_clear,
			txt_dlvryId, txt_customer, txt_agentCode, txt_pcs, txt_wt, tbl_dlvryDtls, chk_checkAll, checkFirstTableItem,
			td_dnDetails, txt_remarks, btn_pymntOk, info_cash, btn_accept, txt_amount, btn_generateId, td_dlvryId,
			yesBtn, noBtn, okBtn, btn_chargeCollectPopup_Close, btn_detachShipment, btn_close, btn_checksheet,
			captureChecksheet_info_transactionName, captureChecksheet_txt_question1, captureChecksheet_txt_answer1,
			captureChecksheet_btn_save, captureChecksheet_btn_close, txt_dnID, link_expandAll, btn_generatePickID,
			chkbx_verifyPaymnt, chkbx_credit, div_cash, txt_customerCode, icon_warehouseInfo, info_dialogueText,
			table_locationDetails, table_details, chkbox_verifyBeforePayment, dropdown_idType, txt_idDetails,
			txt_deliveryGate, txt_flightCarrierCode, txt_flightNo, txt_flightDate, lnk_delete, btn_captureIrregularity,
			captureIrregularity_txt_irregularity, captureIrregularity_txt_pieces, captureIrregularity_txt_weight,
			captureIrregularity_txt_remark, captureIrregularity_btn_save, captureIrregularity_btn_close,
			captureIrregularity_table_irregularityHistory, btn_captureHandoverDetails, documentHandover_txt_handOverTo,
			documentHandover_txt_handOverDate, documentHandover_txt_remarks, documentHandover_btn_save,
			documentHandover_btn_close, img_documentHandOver, btn_captureDelivery, btn_printReceipt, txt_deliveryID,
			info_errorMessage, txt_hawb, duplicateAWB_table, duplicateAWB_btn_ok, shipmentLocations_table,
			shipmentLocations_btn_ok, chargesCollectPopup_table_chargeLevelSummary, txt_uld, txt_awbNo;

	private WebDriver driver;
	private String screenFrame;
	private String dataFileName;

	public OPR293(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}

	/**
	 * Method to initialize page objects on 27/12/2017
	 * 
	 * @author a-7868 Krishna <27/12/2017>
	 */
	private void initElements() {

		txt_prefix = MiscUtility.getWebElement(objFilepath, "OPR293_txt_awbPre");
		txt_awb = MiscUtility.getWebElement(objFilepath, "OPR293_txt_awbNo");
		btn_list = MiscUtility.getWebElement(objFilepath, "OPR293_btn_addToList");
		link_Cashmode = MiscUtility.getWebElement(objFilepath, "OPR293_link_Cashmode");
		txt_billableName = MiscUtility.getWebElement(objFilepath, "OPR293_txt_billableName");
		txt_billableRemark = MiscUtility.getWebElement(objFilepath, "OPR293_txt_billableRemark");

		btn_clear = MiscUtility.getWebElement(objFilepath, "OPR293_btn_clear");
		btn_close = MiscUtility.getWebElement(objFilepath, "OPR293_btn_close");
		txt_dlvryId = MiscUtility.getWebElement(objFilepath, "OPR293_txt_deliveryId");
		btn_generateId = MiscUtility.getWebElement(objFilepath, "OPR293_btn_generateId");
		txt_customer = MiscUtility.getWebElement(objFilepath, "OPR293_txt_custName");
		txt_pcs = MiscUtility.getWebElement(objFilepath, "OPR293_td_pcs");
		txt_wt = MiscUtility.getWebElement(objFilepath, "OPR293_td_wt");
		tbl_dlvryDtls = MiscUtility.getWebElement(objFilepath, "OPR293_tbl_dlvryDtls");
		td_dnDetails = MiscUtility.getWebElement(objFilepath, "OPR293_td_DNDetails");
		// td_allDnDetails= MiscUtility.getWebElements(driver, objFilepath,
		// "OPR293_td_DNDetails");
		td_dlvryId = MiscUtility.getWebElement(objFilepath, "OPR293_td_deliveryId");
		chk_checkAll = MiscUtility.getWebElement(objFilepath, "OPR293_chk_checkAll");

		txt_remarks = MiscUtility.getWebElement(objFilepath, "OPR293_pymnt_txt_remarks");
		btn_pymntOk = MiscUtility.getWebElement(objFilepath, "OPR293_pymnt_btn_ok");
		info_cash = MiscUtility.getWebElement(objFilepath, "OPR293_pymnt_info_cash");
		btn_accept = MiscUtility.getWebElement(objFilepath, "OPR293_pymnt_btn_acceptPymnt");
		btn_chargeCollectPopup_Close = MiscUtility.getWebElement(objFilepath, "OPR293_pymnt_btn_close");
		txt_amount = MiscUtility.getWebElement(objFilepath, "OPR293_pymnt_txt_amount");
		btn_checksheet = MiscUtility.getWebElement(objFilepath, "OPR293_btn_checksheet");
		captureChecksheet_info_transactionName = MiscUtility.getWebElement(objFilepath,
				"OPR293_captureChecksheet_info_transactionName");
		captureChecksheet_txt_question1 = MiscUtility.getWebElement(objFilepath,
				"OPR293_captureChecksheet_txt_question1");
		captureChecksheet_txt_answer1 = MiscUtility.getWebElement(objFilepath, "OPR293_captureChecksheet_txt_answer1");
		captureChecksheet_btn_save = MiscUtility.getWebElement(objFilepath, "OPR293_captureChecksheet_btn_save");
		captureChecksheet_btn_close = MiscUtility.getWebElement(objFilepath, "OPR293_captureChecksheet_btn_close");
		checkFirstTableItem = MiscUtility.getWebElement(objFilepath, "OPR293_chk_checkFirstTableItem");
		txt_agentCode = MiscUtility.getWebElement(objFilepath, "OPR293_txt_agentCode");
		txt_dnID = MiscUtility.getWebElement(objFilepath, "OPR293_txt_dnID");
		link_expandAll = MiscUtility.getWebElement(objFilepath, "OPR293_link_expandAll");
		btn_generatePickID = MiscUtility.getWebElement(objFilepath, "OPR293_btn_generatePickID");

		chkbx_verifyPaymnt = MiscUtility.getWebElement(objFilepath, "OPR293_chkbx_verifyPaymnt");

		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		okBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		txt_customerCode = MiscUtility.getWebElement(objFilepath, "OPR293_txt_customerCode");
		chkbx_credit = MiscUtility.getWebElement(objFilepath, "OPR293_chkbx_credit");
		div_cash = MiscUtility.getWebElement(objFilepath, "OPR293_div_cash");
		icon_warehouseInfo = MiscUtility.getWebElement(objFilepath, "OPR293_icon_warehouseInfo");
		table_locationDetails = MiscUtility.getWebElement(objFilepath, "OPR293_table_locationDetails");
		info_dialogueText = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		table_details = MiscUtility.getWebElement(objFilepath, "OPR293_table_details");
		chkbox_verifyBeforePayment = MiscUtility.getWebElement(objFilepath, "OPR293_chkbox_verifyBeforePayment");
		dropdown_idType = MiscUtility.getWebElement(objFilepath, "OPR293_dropdown_idType");
		txt_idDetails = MiscUtility.getWebElement(objFilepath, "OPR293_txt_idDetails");
		txt_deliveryGate = MiscUtility.getWebElement(objFilepath, "OPR293_txt_deliveryGate");
		txt_flightCarrierCode = MiscUtility.getWebElement(objFilepath, "OPR293_txt_flightCarrierCode");
		txt_flightNo = MiscUtility.getWebElement(objFilepath, "OPR293_txt_flightNo");
		txt_flightDate = MiscUtility.getWebElement(objFilepath, "OPR293_txt_flightDate");
		lnk_delete = MiscUtility.getWebElement(objFilepath, "OPR293_lnk_delete");
		btn_captureIrregularity = MiscUtility.getWebElement(objFilepath, "OPR293_btn_captureIrregularity");
		captureIrregularity_txt_irregularity = MiscUtility.getWebElement(objFilepath,
				"OPR293_CaptureIrregularity_txt_irregularity");
		captureIrregularity_txt_pieces = MiscUtility.getWebElement(objFilepath,
				"OPR293_CaptureIrregularity_txt_pieces");
		captureIrregularity_txt_weight = MiscUtility.getWebElement(objFilepath,
				"OPR293_CaptureIrregularity_txt_weight");
		captureIrregularity_txt_remark = MiscUtility.getWebElement(objFilepath,
				"OPR293_CaptureIrregularity_txt_remark");
		captureIrregularity_btn_save = MiscUtility.getWebElement(objFilepath, "OPR293_CaptureIrregularity_btn_save");
		captureIrregularity_btn_close = MiscUtility.getWebElement(objFilepath, "OPR293_CaptureIrregularity_btn_close");
		captureIrregularity_table_irregularityHistory = MiscUtility.getWebElement(objFilepath,
				"OPR293_CaptureIrregularity_table_irregularityHistory");
		btn_captureHandoverDetails = MiscUtility.getWebElement(objFilepath, "OPR293_btn_captureHandoverDetails");
		documentHandover_txt_handOverTo = MiscUtility.getWebElement(objFilepath,
				"OPR293_DocumentHandover_txt_handOverTo");
		documentHandover_txt_handOverDate = MiscUtility.getWebElement(objFilepath,
				"OPR293_DocumentHandover_txt_handOverDate");
		documentHandover_txt_remarks = MiscUtility.getWebElement(objFilepath, "OPR293_DocumentHandover_txt_remarks");
		documentHandover_btn_save = MiscUtility.getWebElement(objFilepath, "OPR293_DocumentHandover_btn_save");
		documentHandover_btn_close = MiscUtility.getWebElement(objFilepath, "OPR293_DocumentHandover_btn_close");
		img_documentHandOver = MiscUtility.getWebElement(objFilepath, "OPR293_img_documentHandOver");
		btn_captureDelivery = MiscUtility.getWebElement(objFilepath, "OPR293_btn_captureDelivery");
		btn_printReceipt = MiscUtility.getWebElement(objFilepath, "OPR293_btn_printReceipt");
		txt_deliveryID = MiscUtility.getWebElement(objFilepath, "OPR293_txt_deliveryID");
		info_errorMessage = MiscUtility.getWebElement(genObjPath, "Generic_footer_error");
		btn_detachShipment = MiscUtility.getWebElement(objFilepath, "OPR293_btn_detachShipment");
		txt_hawb = MiscUtility.getWebElement(objFilepath, "OPR293_txt_hawb");
		duplicateAWB_table = MiscUtility.getWebElement(objFilepath, "OPR293_duplicateAWB_table");
		duplicateAWB_btn_ok = MiscUtility.getWebElement(objFilepath, "OPR293_duplicateAWB_btn_ok");
		shipmentLocations_table = MiscUtility.getWebElement(objFilepath, "OPR293_shipmentLocations_table");
		shipmentLocations_btn_ok = MiscUtility.getWebElement(objFilepath, "OPR293_shipmentLocations_btn_ok");
		chargesCollectPopup_table_chargeLevelSummary = MiscUtility.getWebElement(objFilepath,
				"OPR293_ChargesCollectPopup_table_chargeLevelSummary");
		txt_uld = MiscUtility.getWebElement(objFilepath, "OPR293_txt_uld");
		txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR293_txt_awbNo");
	}

	/**
	 * Method to generate delivery IDs for all pcs of shipment
	 * 
	 * @param prefix
	 * @param awbNo
	 * @return
	 * @author a-7868 Krishna <27/12/2017>
	 */
	public OPR293 generateIdForAllPcs(String prefix, String awbNo, String dId, String dnId) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		// enterKeys(txt_customer, "Customer"); //hardcoded value - customer
		// name
		click(btn_generateId);

		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();

		String amount = waitForElement(txt_amount).getAttribute("value");
		enterKeys(txt_remarks, "Payment Remarks");
		click(btn_pymntOk);
		minWait();
		Assert.assertTrue(waitForElement(info_cash).getText().contains(amount),
				"ERROR : Amount mismatch on clicking OK");
		click(btn_accept);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		waitForElement(btn_clear);
		minWait();
		String temp_dId = waitForElement(txt_dlvryId).getAttribute("value");
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String temp_dnStatus = waitForElement(td_dnDetails).getText().split("\\[")[1];
		System.out.println(temp_dId + "----" + temp_dnId);
		Assert.assertFalse(temp_dId.isEmpty(), "ERROR : Delivery ID field is Empty");
		Assert.assertFalse(temp_dnId.isEmpty(), "ERROR : DN ID field is Empty");
		Assert.assertTrue(temp_dnStatus.contains("Paid"), "Error actual DN status is " + temp_dnStatus);

		PropertyHandler.setPropValue(dataFilePath, dId, temp_dId);
		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);

		click(btn_clear);
		return this;
	}

	/**
	 * Method to verify Delivery Id and DN Id for a given AWB
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param deliveryId
	 * @param dnId
	 * @return
	 * @author a-7868 Krishna <27/12/2017>
	 */
	public OPR293 verifyDeliveryId(String prefix, String awbNo, String deliveryId, String dnId) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		deliveryId = PropertyHandler.getPropValue(dataFilePath, deliveryId);
		dnId = PropertyHandler.getPropValue(dataFilePath, dnId);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		System.out.println(waitForElement(txt_dlvryId).getAttribute("value"));
		Assert.assertTrue(waitForElement(td_dlvryId).getText().split("\\[")[0].equals(deliveryId),
				"ERROR : Delivery ID mismatch.");
		Assert.assertTrue(waitForElement(td_dnDetails).getText().split("\\[")[0].equals(dnId),
				"ERROR : DN ID mismatch.");
		click(btn_clear);
		return this;
	}

	/**
	 * Created by a-7605 on 03/01/2017
	 */
	public OPR293 generateDeliveryDNForPartialPcs(String prefix, String awbNo, String pcs, String wgt, String agentCode,
			String dnId) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_pcs, pcs);
		enterKeys(txt_wt, wgt);
		enterKeys(txt_agentCode, agentCode);
		enterKeys(txt_agentCode, Keys.TAB);
		check(chk_checkAll);
		click(btn_generateId);

		driver.switchTo().defaultContent();
		try {
			click(noBtn);
		} catch (Exception e) {

		}
		waitForNewWindow(2);
		switchToSecondWindow();
		minWait();
		waitForElement(btn_chargeCollectPopup_Close);
		click(btn_chargeCollectPopup_Close);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		waitForElement(btn_clear);
		minWait();
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String temp_dnStatus = waitForElement(td_dnDetails).getText().split("\\[")[1];
		Assert.assertFalse(temp_dnId.isEmpty(), "ERROR : DN ID field is Empty");
		Assert.assertTrue(temp_dnStatus.contains("Issued"), "Error actual DN status is " + temp_dnStatus);

		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		click(btn_clear);
		return this;
	}

	/**
	 * Created by a-7605 on 03/01/2017
	 */
	public OPR293 generateDeliveryIdForRemainingPcs(String prefix, String awbNo, String agentCode, String dnId) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_agentCode, agentCode);
		enterKeys(txt_agentCode, Keys.TAB);
		check(chk_checkAll);
		click(btn_generateId);

		driver.switchTo().defaultContent();
		try {
			click(yesBtn);
		} catch (Exception e) {

		}
		waitForNewWindow(2);
		switchToSecondWindow();
		minWait();
		waitForElement(btn_chargeCollectPopup_Close);
		click(btn_chargeCollectPopup_Close);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		waitForElement(btn_clear);
		minWait();
		String temp_dnId = waitForElement(td_allDnDetails.get(1)).getText().split("\\[")[0];
		String temp_dnStatus = waitForElement(td_dnDetails).getText().split("\\[")[1];
		Assert.assertFalse(temp_dnId.isEmpty(), "ERROR : DN ID field is Empty");
		Assert.assertTrue(temp_dnStatus.contains("Issued"), "Error actual DN status is " + temp_dnStatus);

		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		click(btn_clear);
		return this;
	}

	/**
	 * Created by a-7605 on 03/01/2017
	 */

	public OPR293 generateDNForExistingDeliveryIDs(String prefix, String awbNo, String agentCode, String dnId) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_agentCode, agentCode);
		enterKeys(txt_agentCode, Keys.TAB);
		check(chk_checkAll);
		click(btn_generateId);

		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();

		String amount = waitForElement(txt_amount).getAttribute("value");
		enterKeys(txt_remarks, "Payment Remarks");
		click(btn_pymntOk);
		minWait();
		Assert.assertTrue(waitForElement(info_cash).getText().contains(amount),
				"ERROR : Amount mismatch on clicking OK");
		click(btn_accept);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		waitForElement(btn_clear);
		minWait();
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String temp_dnStatus = waitForElement(td_dnDetails).getText().split("\\[")[1];
		Assert.assertFalse(temp_dnId.isEmpty(), "ERROR : DN ID field is Empty");
		Assert.assertTrue(temp_dnStatus.contains("Paid"), "Error actual DN status is " + temp_dnStatus);

		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);

		click(btn_clear);
		return this;
	}

	// this method is not complete due to bug in the application
	public OPR293 detachShipments(String prefix, String awbNo) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		click(btn_detachShipment);
		return this;
	}

	/**
	 * Method to list an awb
	 * 
	 * @param prefix
	 * @param awbNo
	 * @author a-7868 Krishna <27/12/2017>
	 */
	private void list(String prefix, String awbNo) {

		enterKeys(txt_prefix, prefix);
		enterKeys(txt_awb, awbNo);
		click(btn_list);
		maxWait();
	}

	/**
	 * Created by a-7605 on 03/01/2017
	 */

	public OPR293 captureCheckseet(String prefix, String awbNo, String checksheetQuestion) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		checksheetQuestion = PropertyHandler.getPropValue(dataFilePath, checksheetQuestion);

		String transactionName;
		String checksheetQuestionText;
		String checksheetAnswerText = "Checksheet captured";
		list(prefix, awbNo);
		waitForElement(table_details);
		check(checkFirstTableItem);
		click(btn_checksheet);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		transactionName = waitForElement(captureChecksheet_info_transactionName).getText();
		Assert.assertTrue(transactionName.contains("DELIVERY CHECK SHEET"));
		enterKeys(captureChecksheet_txt_answer1, checksheetAnswerText);
		checksheetQuestionText = waitForElement(captureChecksheet_txt_question1).getText();
		Assert.assertTrue(checksheetQuestionText.contains(checksheetQuestion));
		click(captureChecksheet_btn_save);
		click(okBtn);
		click(captureChecksheet_btn_close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		check(chk_checkAll);
		click(btn_checksheet);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		Assert.assertTrue(
				waitForElement(captureChecksheet_txt_answer1).getAttribute("value").equals(checksheetAnswerText));
		click(captureChecksheet_btn_close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		return this;
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
	 * Created by A-7605 on 5-2-18 This method will generate Delivery ID for all
	 * shipments
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param dnId
	 * @return
	 */
	public OPR293 generateDeliveryIDForAllPcs(String prefix, String awbNo, String customerCode, String dnId) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		minWait();
		if (getNumberOfWindows() == 2) {
			switchToSecondWindow();
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		minWait();
		// String temp_dId = waitForElement(txt_dlvryId).getAttribute("value");
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		// String temp_dnStatus =
		// waitForElement(td_dnDetails).getText().split("\\[")[1];
		// logger.info("Generated Delivery ID is "+temp_dId+" and DN ID is
		// "+temp_dnId);
		// System.out.println(temp_dId+"----"+temp_dnId);
		// Assert.assertFalse(temp_dId.isEmpty(),
		// "ERROR : Delivery ID field is Empty");
		// Assert.assertFalse(temp_dnId.isEmpty(),
		// "ERROR : DN ID field is Empty");
		// Assert.assertTrue(temp_dnStatus.contains("Paid"),
		// "Error actual DN status is "+temp_dnStatus);
		//
		// PropertyHandler.setPropValue(dataFilePath, dId, temp_dId);
		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains("Paid"));

		click(btn_clear);
		return this;
	}

	/**
	 * lists a DnID and navigates to Pick List screen
	 * 
	 * @param dnID
	 * @param awbNo
	 * @return
	 * @author a-7681
	 */
	public WHS020 generatePickID(String dnID, String awbNo) {

		dnID = PropertyHandler.getPropValue(dataFilePath, dnID);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		enterKeys(txt_dnID, dnID);
		click(btn_list);

		// click(link_expandAll);
		tblSelectRowByColValue(tbl_dlvryDtls, 1, 4, awbNo);

		click(btn_generatePickID);

		return new WHS020(driver, dataFileName);
	}

	public OPR293 clear() {

		try {
			click(btn_clear);
		} catch (Exception e) {
			Actions action = new Actions(driver);
			action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();
		}
		minWait();

		return this;
	}

	public OPR293 cashPaymentForCredit(String prefix, String AWBNo) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);

		list(prefix, AWBNo);

		check(chk_checkAll);
		check(chkbx_verifyPaymnt);

		click(btn_generateId);
		driver.switchTo().defaultContent();

		try {
			waitForNewWindow(2);
			switchToSecondWindow();

			List<WebElement> listElement1;

			listElement1 = getWebElements(chkbx_credit);

			int count1 = listElement1.size() + 1;

			unCheck(getWebElements(chkbx_credit).get(count1));
			click(div_cash);
			enterKeys(txt_remarks, "Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();

			maxWait();
		} catch (TimeoutException e) {

		}

		return this;
	}

	public OPR293 paymntNavigation_Credit(String prefix, String AWBNo, String dnId, String accountNumbr) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
		accountNumbr = PropertyHandler.getPropValue(dataFilePath, accountNumbr);

		list(prefix, AWBNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		check(chkbx_verifyPaymnt);
		click(btn_generateId);
		driver.switchTo().defaultContent();

		try {
			waitForNewWindow(2);
			switchToSecondWindow();
			enterKeys(txt_remarks, accountNumbr);
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		} catch (TimeoutException e) {

		}
		return this;
	}

	private void listWithAWB(String awbPrefix, String awbNo) {
		enterKeys(txt_prefix, awbPrefix);
		enterKeys(txt_awb, awbNo);
		click(btn_list);
		minWait();
	}

	/**
	 * Created by A-7605 on 11-04-18 This method verify if pcs and wgt accepted
	 * from Breakdown screen
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param location1
	 * @param pcs1
	 * @param weight1
	 * @param location2
	 * @param pcs2
	 * @param weight2
	 * @return
	 */
	public OPR293 verifyLocationDetails(String awbPrefix, String awbNo, String location1, String pcs1, String weight1,
			String location2, String pcs2, String weight2) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		location1 = PropertyHandler.getPropValue(dataFilePath, location1);
		pcs1 = PropertyHandler.getPropValue(dataFilePath, pcs1);
		weight1 = PropertyHandler.getPropValue(dataFilePath, weight1);
		location2 = PropertyHandler.getPropValue(dataFilePath, location2);
		pcs2 = PropertyHandler.getPropValue(dataFilePath, pcs2);
		weight2 = PropertyHandler.getPropValue(dataFilePath, weight2);

		listWithAWB(awbPrefix, awbNo);
		click(icon_warehouseInfo);
		Assert.assertEquals(tblGetTextByColValue(table_locationDetails, 4, 3, location1), pcs1);
		Assert.assertEquals(tblGetTextByColValue(table_locationDetails, 5, 3, location1), weight1);
		Assert.assertEquals(tblGetTextByColValue(table_locationDetails, 4, 3, location2), pcs2);
		Assert.assertEquals(tblGetTextByColValue(table_locationDetails, 5, 3, location2), weight2);
		return this;
	}

	/**
	 * Created by A-7605 This method generate DN for all pcs. Charge Collect pop
	 * up is expected during DN generation
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param pieces
	 * @param weight
	 * @param dnId
	 * @param deliveryID
	 * @param idType
	 * @param idDetails
	 * @param deliveryGate
	 * @param checkVerifyBeforePaymentCheckbox
	 * @return
	 */
	public OPR293 generateDNForAllPcs_ChargeCollectPopup(String prefix, String awbNo, String customerCode,
			String pieces, String weight, String dnId, String deliveryID, String idType, String idDetails,
			String deliveryGate, boolean checkVerifyBeforePaymentCheckbox) {

		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		idType = PropertyHandler.getPropValue(dataFilePath, idType);
		idDetails = PropertyHandler.getPropValue(dataFilePath, idDetails);
		deliveryGate = PropertyHandler.getPropValue(dataFilePath, deliveryGate);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		if (idType != null && idType.trim().length() > 0) {
			selectByText(dropdown_idType, idType);
		}
		if (idDetails != null && idDetails.trim().length() > 0) {
			enterKeys(txt_idDetails, idDetails);
		}
		if (deliveryGate != null && deliveryGate.trim().length() > 0) {
			enterKeys(txt_deliveryGate, deliveryGate);
		}
		if (checkVerifyBeforePaymentCheckbox)
			check(chkbox_verifyBeforePayment);
		else
			unCheck(chkbox_verifyBeforePayment);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(txt_remarks, "Payment Remarks");
		click(btn_pymntOk);
		minWait();
		click(btn_accept);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		minWait();
		String dnID = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(pieces + "/" + weight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, dnId, dnID);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains(pieces + "/" + weight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 This method generate DN for partial pcs. Charge Collect
	 * pop up is expected during DN generation
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param pieces
	 * @param weight
	 * @param customerCode
	 * @param dnId
	 * @param deliveryID
	 * @return
	 */
	public OPR293 generateDNForPartialPcs_ChargeCollectPopup(String prefix, String awbNo, String pieces, String weight,
			String customerCode, String dnId, String deliveryID) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		unCheck(chkbox_verifyBeforePayment);
		check(chk_checkAll);
		enterKeys(txt_pcs, pieces);
		enterKeys(txt_wt, weight);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		Assert.assertEquals(waitForElement(info_dialogueText).getText(),
				"Do you want to issue DN for all Pending Pieces?");
		click(noBtn);
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(txt_remarks, "Payment Remarks");
		click(btn_pymntOk);
		minWait();
		click(btn_accept);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		minWait();
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(pieces + "/" + weight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains(pieces + "/" + weight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	private void listWithDeliveryID(String deliveryID) {
		enterKeys(txt_dlvryId, deliveryID);
		click(btn_list);
		minWait();
	}

	/**
	 * Created by A-7605 This method verify DN Details
	 * 
	 * @param deliveryID
	 * @param pieces
	 * @param weight
	 * @param status
	 * @return
	 */
	public OPR293 verifyDNDetails(String deliveryID, String pieces, String weight, String status) {
		deliveryID = PropertyHandler.getPropValue(dataFilePath, deliveryID);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		status = PropertyHandler.getPropValue(dataFilePath, status);

		listWithDeliveryID(deliveryID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains(pieces + "/" + weight + "/" + status));
		return this;
	}

	/**
	 * Created by A-7605 This method verify if delivery gate details is retained
	 * 
	 * @param deliveryID
	 * @param deliveryGate
	 * @return
	 */
	public OPR293 verifyDeliveryGate(String deliveryID, String deliveryGate) {
		deliveryID = PropertyHandler.getPropValue(dataFilePath, deliveryID);
		deliveryGate = PropertyHandler.getPropValue(dataFilePath, deliveryGate);

		listWithDeliveryID(deliveryID);
		Assert.assertEquals(waitForElementVisible(txt_deliveryGate).getAttribute("value"), deliveryGate);
		return this;
	}

	/**
	 * Created by A-7605 This method generate DN for remaining pcs (SD should be
	 * already generated for some pcs)
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param remainingPcs
	 * @param remainingWeight
	 * @param customerCode
	 * @param dnId
	 * @param deliveryID
	 * @return
	 */
	public OPR293 generateDNForRemainingPcs(String prefix, String awbNo, String remainingPcs, String remainingWeight,
			String customerCode, String dnId, String deliveryID) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		remainingPcs = PropertyHandler.getPropValue(dataFilePath, remainingPcs);
		remainingWeight = PropertyHandler.getPropValue(dataFilePath, remainingWeight);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		enterKeys(txt_pcs, remainingPcs);
		enterKeys(txt_wt, remainingWeight);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		maxWait();
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(remainingPcs + "/" + remainingWeight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(
				waitForElement(td_dnDetails).getText().contains(remainingPcs + "/" + remainingWeight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 This method generate DN for full pcs. Charge Collect
	 * pop up is not expected during DN generation
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param pieces
	 * @param weight
	 * @param dnId
	 * @param deliveryID
	 * @param verifyBeforePayment
	 * @return
	 */
	public OPR293 generateDNForAllPcs_NoChargeCollectPopup(String prefix, String awbNo, String customerCode,
			String pieces, String weight, String dnId, String deliveryID, boolean verifyBeforePayment) {

		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		if (verifyElementPresent(chkbox_verifyBeforePayment)) {
			if (!verifyBeforePayment)
				unCheck(chkbox_verifyBeforePayment);
		}
		if (verifyBeforePayment)
			check(chkbox_verifyBeforePayment);

		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		maxWait();
		String dnID = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(pieces + "/" + weight));
		delID = delID.split("\\[")[0];

		PropertyHandler.setPropValue(dataFilePath, dnId, dnID);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains(pieces + "/" + weight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 This method generate DN for partial pcs. Charge Collect
	 * pop up is expected during DN generation
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param pieces
	 * @param weight
	 * @param customerCode
	 * @param dnId
	 * @param deliveryID
	 * @return
	 */
	public OPR293 generateDNForPartialPcs_ChargeCollectPopupWithVerifyPaymentOption(String prefix, String awbNo,
			String pieces, String weight, String customerCode, String dnId, String deliveryID) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chkbox_verifyBeforePayment);
		unCheck(chkbox_verifyBeforePayment);
		check(chk_checkAll);
		enterKeys(txt_pcs, pieces);
		enterKeys(txt_wt, weight);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		Assert.assertEquals(waitForElement(info_dialogueText).getText(),
				"Do you want to issue DN for all Pending Pieces?");
		click(noBtn);
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(txt_remarks, "Payment Remarks");
		click(btn_pymntOk);
		minWait();
		click(btn_accept);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		minWait();
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(pieces + "/" + weight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains(pieces + "/" + weight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 This method verify the remaining pcs for which DN is to
	 * be generated
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param remainingPieces
	 * @param remainingWeight
	 * @return
	 */
	public OPR293 checkRemainingPcs(String awbPrefix, String awbNo, String remainingPieces, String remainingWeight) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		remainingPieces = PropertyHandler.getPropValue(dataFilePath, remainingPieces);
		remainingWeight = PropertyHandler.getPropValue(dataFilePath, remainingWeight);

		listWithAWB(awbPrefix, awbNo);
		Assert.assertEquals(waitForElementVisible(txt_pcs).getAttribute("value"), remainingPieces);
		Assert.assertEquals(waitForElementVisible(txt_wt).getAttribute("value"), remainingWeight);
		return this;
	}

	private void listWithFlight(String carrierCode, String flightNo, String flightDate) {
		enterKeys(txt_flightCarrierCode, carrierCode);
		enterKeys(txt_flightNo, flightNo);
		enterKeys(txt_flightDate, flightDate);
		click(btn_list);
		minWait();
	}

	/**
	 * Created by A-7605 This method delete one awb and generate DN for
	 * remaining AWBs
	 * 
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param awbToBeDeleted
	 * @param agentCode
	 * @param deliveryID
	 * @return
	 */
	public OPR293 deleteOneShipmentAndGenerateDNForRemaining(String carrierCode, String flightNo, String flightDate,
			String awbToBeDeleted, String agentCode, String deliveryID) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		awbToBeDeleted = PropertyHandler.getPropValue(dataFilePath, awbToBeDeleted);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		listWithFlight(carrierCode, flightNo, flightDate);
		tblSelectRowByColValue(table_details, 1, 4, awbToBeDeleted);
		click(lnk_delete);
		minWait();
		check(chk_checkAll);
		enterKeys(txt_customerCode, agentCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(txt_remarks, "Payment Remarks");
		click(btn_pymntOk);
		minWait();
		click(btn_accept);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		minWait();
		String dnId1 = getWebElements(td_dnDetails).get(0).getText();
		String dnId2 = getWebElements(td_dnDetails).get(1).getText();
		Assert.assertTrue(dnId1.contains("Paid"));
		Assert.assertTrue(dnId2.contains("Paid"));
		String delID = getTableCellValue(table_details, 10, 2);
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 This method verify DN not generated for the AWB
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param shipmentPcs
	 * @param shipmentWeight
	 * @return
	 */
	public OPR293 verifyDNNotGenerated(String awbPrefix, String awbNo, String shipmentPcs, String shipmentWeight) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		shipmentPcs = PropertyHandler.getPropValue(dataFilePath, shipmentPcs);
		shipmentWeight = PropertyHandler.getPropValue(dataFilePath, shipmentWeight);

		listWithAWB(awbPrefix, awbNo);
		Assert.assertEquals(waitForElement(txt_pcs).getAttribute("value"), shipmentPcs);
		Assert.assertEquals(waitForElement(txt_wt).getAttribute("value"), shipmentWeight);
		Assert.assertEquals(getWebElements(td_dnDetails).size(), 0);
		Assert.assertEquals(getTableCellValue(table_details, 10, 2).trim().length(), 0);
		return this;
	}

	/**
	 * Created by A-7605 This method capture irregularity details
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param irregularity
	 * @param pieces
	 * @param weight
	 * @param remark
	 * @return
	 */
	public OPR293 captureIrregularity(String awbPrefix, String awbNo, String irregularity, String pieces, String weight,
			String remark) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		irregularity = PropertyHandler.getPropValue(dataFilePath, irregularity);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		remark = PropertyHandler.getPropValue(dataFilePath, remark);

		listWithAWB(awbPrefix, awbNo);

		check(checkFirstTableItem);
		click(btn_captureIrregularity);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(captureIrregularity_txt_irregularity, irregularity);
		enterKeys(captureIrregularity_txt_pieces, pieces);
		enterKeys(captureIrregularity_txt_weight, weight);
		enterKeys(captureIrregularity_txt_remark, remark);
		click(captureIrregularity_btn_save);
		minWait();
		Assert.assertEquals(getTableCellValue(captureIrregularity_table_irregularityHistory, 2, 1), irregularity);
		Assert.assertEquals(getTableCellValue(captureIrregularity_table_irregularityHistory, 3, 1).replaceAll(" ", ""),
				awbPrefix + "-" + awbNo);
		Assert.assertEquals(getTableCellValue(captureIrregularity_table_irregularityHistory, 5, 1), "Delivery");
		Assert.assertEquals(getTableCellValue(captureIrregularity_table_irregularityHistory, 8, 1), pieces);
		Assert.assertEquals(getTableCellValue(captureIrregularity_table_irregularityHistory, 9, 1), weight);
		Assert.assertEquals(getTableCellValue(captureIrregularity_table_irregularityHistory, 12, 1), remark);
		click(captureIrregularity_btn_close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Created by A-7605 This method save document handover details
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param handOverTo
	 * @param handOverDate
	 * @return
	 */
	public OPR293 saveDocumentHandOverDetails(String awbPrefix, String awbNo, String handOverTo, String handOverDate) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		handOverTo = PropertyHandler.getPropValue(dataFilePath, handOverTo);
		handOverDate = PropertyHandler.getPropValue(dataFilePath, handOverDate);

		listWithAWB(awbPrefix, awbNo);
		check(checkFirstTableItem);
		click(btn_captureHandoverDetails);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(documentHandover_txt_handOverTo, handOverTo);
		enterKeys(documentHandover_txt_handOverDate, handOverDate);
		enterKeys(documentHandover_txt_remarks, "Handed over");
		click(documentHandover_btn_save);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		Assert.assertTrue(waitForElementVisible(img_documentHandOver).getAttribute("src").contains("tick.gif"));
		return this;
	}

	/**
	 * Created by A-7605 This method generate delivery id for partial pcs
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param pcs
	 * @param wgt
	 * @param agentCode
	 * @param dnId
	 * @return
	 */
	public OPR293 generateDeliveryIDForPartialPcs(String prefix, String awbNo, String pcs, String wgt, String agentCode,
			String dnId, String deliveryID) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_pcs, pcs);
		enterKeys(txt_wt, wgt);
		enterKeys(txt_agentCode, agentCode);
		enterKeys(txt_agentCode, Keys.TAB);
		check(chk_checkAll);
		click(btn_generateId);

		driver.switchTo().defaultContent();
		try {
			click(noBtn);
		} catch (Exception e) {

		}
		waitForNewWindow(2);
		switchToSecondWindow();
		minWait();
		waitForElement(btn_chargeCollectPopup_Close);
		enterKeys(txt_remarks, "Payment Remarks");
		click(btn_pymntOk);
		minWait();
		click(btn_accept);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		waitForElement(btn_clear);
		minWait();
		String tempDeliveryID = getTableCellValue(table_details, 10, 2);
		tempDeliveryID = tempDeliveryID.split("\\[")[0];
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String temp_dnStatus = waitForElement(td_dnDetails).getText().split("\\[")[1];
		Assert.assertFalse(temp_dnId.isEmpty(), "ERROR : DN ID field is Empty");
		Assert.assertTrue(temp_dnStatus.contains("Paid"), "Error actual DN status is " + temp_dnStatus);

		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, tempDeliveryID);
		click(btn_clear);
		return this;
	}

	/**
	 * Created by A-7605 This method generate DN is issued status
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param dnId
	 * @return
	 */
	public OPR293 generateDNInIssuedStatus(String prefix, String awbNo, String customerCode, String dnId) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		minWait();
		switchToSecondWindow();
		click(waitForElement(btn_chargeCollectPopup_Close));
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		minWait();
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains("Issued"));

		click(btn_clear);
		return this;
	}

	/**
	 * Created by A-7605 This method check navigation to Deliver Cargo screen
	 * for a shipment with 3 delivery ids
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param DN1
	 * @param DN2
	 * @param DN3
	 * @return
	 */
	public OPR293 checkDeliverCargoPageNavigationForShipmentWithThreeDeliveryIDs(String prefix, String awbNo,
			String DN1, String DN2, String DN3) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		DN1 = PropertyHandler.getPropValue(dataFilePath, DN1);
		DN2 = PropertyHandler.getPropValue(dataFilePath, DN2);
		DN3 = PropertyHandler.getPropValue(dataFilePath, DN3);
		String[] deliveryIDs;

		list(prefix, awbNo);
		String delID = getTableCellValue(table_details, 10, 2);
		deliveryIDs = delID.split("\n");
		for (int i = 0; i < deliveryIDs.length; i++) {
			deliveryIDs[i] = deliveryIDs[i].split("\\[")[0];
		}
		check(chk_checkAll);
		click(btn_captureDelivery);
		minWait();
		return new OPR064(driver, dataFileName).verifyDeliveryIDs(deliveryIDs, new String[] { DN1, DN2, DN3 });
	}

	/**
	 * Created by A-7605 This method check error showing printing receipt for DN
	 * in issued status
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @return
	 */
	public OPR293 checkErrorMessageOnPrintingReceiptForIssuedDN(String awbPrefix, String awbNo) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		String fullAWBNo = awbPrefix + " " + awbNo;

		listWithAWB(awbPrefix, awbNo);
		check(checkFirstTableItem);
		click(btn_printReceipt);
		driver.switchTo().defaultContent();
		Assert.assertEquals(waitForElement(info_dialogueText).getText(),
				"Payment advice doesnt exist for the AWB(s) [" + fullAWBNo + "]");
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Created by A-7605 This method generate DN for selected AWBs only
	 * 
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param awbPrefix
	 * @param awbNo
	 * @param agentCode
	 * @param deliveryID
	 * @return
	 */
	public OPR293 generateDNForSelectedAWBsOnly(String carrierCode, String flightNo, String flightDate,
			String awbPrefix, String awbNo, String agentCode, String deliveryID, boolean isChargeCollectPopupExpected) {
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		String fullAWBNo = awbPrefix + " " + awbNo;

		listWithFlight(carrierCode, flightNo, flightDate);
		tblSelectRowByColValue(table_details, 1, 4, awbNo);
		enterKeys(txt_customerCode, agentCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);

		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);
		}
		maxWait();
		waitForElement(btn_clear);

		String delID = waitForElement(txt_deliveryID).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertEquals(getTableCellValue(table_details, 4, 2), fullAWBNo);
		return this;
	}

	/**
	 * Created by A-7605 This method generate DN for partial pcs
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param pcs
	 * @param wgt
	 * @param agentCode
	 * @param dnId
	 * @return
	 */
	public OPR293 generateDNForPartialPcs(String prefix, String awbNo, String pcs, String wgt, String agentCode,
			String dnId) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_pcs, pcs);
		enterKeys(txt_wt, wgt);
		enterKeys(txt_agentCode, agentCode);
		enterKeys(txt_agentCode, Keys.TAB);
		check(chk_checkAll);
		click(btn_generateId);

		driver.switchTo().defaultContent();
		try {
			click(noBtn);
		} catch (Exception e) {

		}
		waitForNewWindow(2);
		switchToSecondWindow();
		minWait();
		waitForElement(btn_chargeCollectPopup_Close);
		minWait();
		click(btn_chargeCollectPopup_Close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		waitForElement(btn_clear);
		minWait();
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String temp_dnStatus = waitForElement(td_dnDetails).getText().split("\\[")[1];
		Assert.assertFalse(temp_dnId.isEmpty(), "ERROR : DN ID field is Empty");
		Assert.assertTrue(temp_dnStatus.contains("Issued"), "Error actual DN status is " + temp_dnStatus);

		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		click(btn_clear);
		return this;
	}

	/**
	 * Created by A-7605 This method returns delivery ID of already delivery id
	 * generated shipment
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param deliveryID
	 * @return
	 */
	public OPR293 getActiveDeliveryID(String awbPrefix, String awbNo, String deliveryID) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		listWithAWB(awbPrefix, awbNo);
		String delID = getTableCellValue(table_details, 10, 2).split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		return this;
	}

	/**
	 * Created by A-7605 This method generate DN for all houses in a AWB
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param dnId
	 * @param deliveryID
	 * @param verifyBeforePayment
	 * @return
	 */
	public OPR293 generateDNForAllHousesInAWB_NoChargeCollectPopup(String prefix, String awbNo, String customerCode,
			String dnId, String deliveryID, boolean verifyBeforePayment) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);

		if (verifyElementPresent(chkbox_verifyBeforePayment)) {
			if (verifyBeforePayment)
				check(chkbox_verifyBeforePayment);
			else
				unCheck(chkbox_verifyBeforePayment);
		}
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		maxWait();
		String dnID = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		delID = delID.split("\\[")[0];

		PropertyHandler.setPropValue(dataFilePath, dnId, dnID);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains("/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 This method detaches delivery id from AWB
	 * 
	 * @param deliveryID
	 * @return
	 */
	public OPR293 detachDeliveryID(String deliveryID) {
		deliveryID = PropertyHandler.getPropValue(dataFilePath, deliveryID);

		listWithDeliveryID(deliveryID);

		check(checkFirstTableItem);
		click(btn_detachShipment);
		minWait();
		click(btn_clear);
		minWait();
		listWithDeliveryID(deliveryID);
		Assert.assertEquals(waitForElement(info_errorMessage).getText(), "Specified Delivery ID is invalid.");
		return this;
	}

	/**
	 * Created by A-7605 This method verify delivery id detached from AWB
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param detachedDeliveryID
	 * @return
	 */
	public OPR293 verifyDeliveryIDIsDetached(String awbPrefix, String awbNo, String detachedDeliveryID) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		detachedDeliveryID = PropertyHandler.getPropValue(dataFilePath, detachedDeliveryID);
		listWithAWB(awbPrefix, awbNo);
		Assert.assertFalse(getTableCellValue(table_details, 10, 2).contains(detachedDeliveryID));
		return this;
	}

	/**
	 * Created by A-7605 This method verify delivery id detached from AWB
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param attachedDeliveryID
	 * @return
	 */
	public OPR293 verifyDeliveryIDIsAttached(String awbPrefix, String awbNo, String attachedDeliveryID) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		attachedDeliveryID = PropertyHandler.getPropValue(dataFilePath, attachedDeliveryID);
		listWithAWB(awbPrefix, awbNo);
		Assert.assertTrue(getTableCellValue(table_details, 10, 2).contains(attachedDeliveryID));
		return this;
	}

	/**
	 * Created by A-7605 on 30-4-18 This method verify that delivery id is
	 * already generated for the shipment and no further id can be generated
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param customerCode
	 * @return
	 */
	public OPR293 verifyDeliveryIDAreadyGeneratedForShipment(String awbPrefix, String awbNo, String customerCode) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		listWithAWB(awbPrefix, awbNo);
		Assert.assertEquals(waitForElementVisible(txt_pcs).getAttribute("value"), "0");
		Assert.assertEquals(waitForElementVisible(txt_wt).getAttribute("value"), "0");
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		Assert.assertEquals(waitForElement(info_errorMessage).getText(),
				"To be delivered Pcs/Wt should be greater than 0.");
		return this;
	}

	/**
	 * Created by A-7605 on 30-4-18 This method generate Delivery id for partial
	 * pcs and DN for full pcs
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param customerCode
	 * @param deliveryPcs
	 * @param deliveryWeight
	 * @param totalPcs
	 * @param totalWeight
	 * @param deliveryID
	 * @param DNId
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDeliveryIDForPartialPiecesAndDNForFullPcs(String awbPrefix, String awbNo, String customerCode,
			String deliveryPcs, String deliveryWeight, String totalPcs, String totalWeight, String deliveryID,
			String DNId, boolean isChargeCollectPopupExpected) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		deliveryPcs = PropertyHandler.getPropValue(dataFilePath, deliveryPcs);
		deliveryWeight = PropertyHandler.getPropValue(dataFilePath, deliveryWeight);
		totalPcs = PropertyHandler.getPropValue(dataFilePath, totalPcs);
		totalWeight = PropertyHandler.getPropValue(dataFilePath, totalWeight);

		listWithAWB(awbPrefix, awbNo);
		enterKeys(txt_pcs, deliveryPcs);
		enterKeys(txt_wt, deliveryWeight);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		click(waitForElement(yesBtn));
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		waitForElement(btn_clear);
		minWait();

		String dnID = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(deliveryPcs + "/" + deliveryWeight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, DNId, dnID);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains(totalPcs + "/" + totalWeight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 on 30-4-18 This method generate Delivery id for partial
	 * pcs for shipment having DN already generated
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param customerCode
	 * @param deliveryPcs
	 * @param deliveryWeight
	 * @param totalPcs
	 * @param totalWeight
	 * @param deliveryID
	 * @param DNId
	 * @param isChargeCollectPopupExpected
	 * @param previouseDeliveryID
	 * @return
	 */
	public OPR293 generateDeliveryIDForPartialPiecesForShipmentWithDNAlreadyGenerated(String awbPrefix, String awbNo,
			String customerCode, String deliveryPcs, String deliveryWeight, String totalPcs, String totalWeight,
			String deliveryID, String DNId, boolean isChargeCollectPopupExpected, String... previouseDeliveryID) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		deliveryPcs = PropertyHandler.getPropValue(dataFilePath, deliveryPcs);
		deliveryWeight = PropertyHandler.getPropValue(dataFilePath, deliveryWeight);
		totalPcs = PropertyHandler.getPropValue(dataFilePath, totalPcs);
		totalWeight = PropertyHandler.getPropValue(dataFilePath, totalWeight);

		for (int i = 0; i < previouseDeliveryID.length; i++)
			previouseDeliveryID[i] = PropertyHandler.getPropValue(dataFilePath, previouseDeliveryID[i]);

		listWithAWB(awbPrefix, awbNo);
		minWait();
		String currentDeliveryID = getTableCellValue(table_details, 10, 2);
		for (int i = 0; i < previouseDeliveryID.length; i++)
			Assert.assertTrue(currentDeliveryID.contains(previouseDeliveryID[i]));
		enterKeys(txt_pcs, deliveryPcs);
		enterKeys(txt_wt, deliveryWeight);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		if (isChargeCollectPopupExpected) {
			driver.switchTo().defaultContent();
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);
		}

		minWait();
		waitForElement(btn_clear);
		minWait();

		String dnID = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(deliveryPcs + "/" + deliveryWeight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, DNId, dnID);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains(totalPcs + "/" + totalWeight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 on 30-4-18 This method generate Delivery id for
	 * remaining pcs for shipment having DN already generated
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param customerCode
	 * @param remainingPcs
	 * @param remainingWeight
	 * @param totalPcs
	 * @param totalWeight
	 * @param deliveryID
	 * @param DNId
	 * @param isChargeCollectPopupExpected
	 * @param previouseDeliveryID
	 * @return
	 */
	public OPR293 generateDeliveryIDForRemainingPiecesForShipmentWithDNAlreadyGenerated(String awbPrefix, String awbNo,
			String customerCode, String remainingPcs, String remainingWeight, String totalPcs, String totalWeight,
			String deliveryID, String DNId, boolean isChargeCollectPopupExpected, String... previouseDeliveryID) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		remainingPcs = PropertyHandler.getPropValue(dataFilePath, remainingPcs);
		remainingWeight = PropertyHandler.getPropValue(dataFilePath, remainingWeight);
		totalPcs = PropertyHandler.getPropValue(dataFilePath, totalPcs);
		totalWeight = PropertyHandler.getPropValue(dataFilePath, totalWeight);

		for (int i = 0; i < previouseDeliveryID.length; i++)
			previouseDeliveryID[i] = PropertyHandler.getPropValue(dataFilePath, previouseDeliveryID[i]);

		listWithAWB(awbPrefix, awbNo);
		minWait();
		String currentDeliveryID = getTableCellValue(table_details, 10, 2);
		for (int i = 0; i < previouseDeliveryID.length; i++)
			Assert.assertTrue(currentDeliveryID.contains(previouseDeliveryID[i]));
		Assert.assertEquals(waitForElementVisible(txt_pcs).getAttribute("value"), remainingPcs);
		Assert.assertEquals(waitForElementVisible(txt_wt).getAttribute("value"), remainingWeight);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		if (isChargeCollectPopupExpected) {
			driver.switchTo().defaultContent();
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);
		}

		minWait();
		waitForElement(btn_clear);
		minWait();

		String dnID = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(remainingPcs + "/" + remainingWeight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, DNId, dnID);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains(totalPcs + "/" + totalWeight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 This method generate DN for full pcs. Charge Collect
	 * pop up is not expected during DN generation
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param pieces
	 * @param weight
	 * @param dnId
	 * @param deliveryID
	 * @param verifyBeforePayment
	 * @return
	 */
	public OPR293 generateDNForAllPcs_TwoHousesAndOneAWB_NoChargeCollectPopup(String awbPrefix, String awbNo,
			String house1, String awbPrefix1, String awbNo1, String house2, String awbPrefix2, String awbNo2,
			String customerCode, String deliveryID, String dn1, String dn2, String dn3) {

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		awbPrefix1 = PropertyHandler.getPropValue(dataFilePath, awbPrefix1);
		awbNo1 = PropertyHandler.getPropValue(dataFilePath, awbNo1);
		awbPrefix2 = PropertyHandler.getPropValue(dataFilePath, awbPrefix2);
		awbNo2 = PropertyHandler.getPropValue(dataFilePath, awbNo2);

		list(awbPrefix, awbNo);
		listWithHouse(house1, awbPrefix1, awbNo1);
		listWithHouse(house2, awbPrefix2, awbNo2);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		maxWait();
		String dnID1 = getWebElements(td_dnDetails).get(0).getText();
		String dnID2 = getWebElements(td_dnDetails).get(1).getText();
		String dnID3 = getWebElements(td_dnDetails).get(2).getText();
		Assert.assertTrue(dnID1.contains("/Paid"), "Actual dn number is '" + dnID1 + "'");
		Assert.assertTrue(dnID2.contains("/Paid"), "Actual dn number is '" + dnID2 + "'");
		Assert.assertTrue(dnID3.contains("/Paid"), "Actual dn number is '" + dnID3 + "'");
		dnID1 = dnID1.split("\\[")[0];
		dnID2 = dnID2.split("\\[")[0];
		dnID3 = dnID3.split("\\[")[0];

		String delID1 = getTableCellValue(table_details, 10, 2);
		String delID2 = getTableCellValue(table_details, 10, 3);
		String delID3 = getTableCellValue(table_details, 10, 4);
		delID1 = delID1.split("\\[")[0];
		delID2 = delID2.split("\\[")[0];
		delID3 = delID3.split("\\[")[0];
		Assert.assertTrue(delID1.equals(delID2) && delID1.equals(delID3));

		PropertyHandler.setPropValue(dataFilePath, dn1, dnID1);
		PropertyHandler.setPropValue(dataFilePath, dn2, dnID2);
		PropertyHandler.setPropValue(dataFilePath, dn3, dnID3);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID1);
		Assert.assertTrue(delID1.trim().length() > 0);
		return this;
	}

	private void listWithHouse(String house, String awbPrefix, String awbNo) {
		String fullAWBNo = awbPrefix + "-" + awbNo;

		enterKeys(txt_hawb, house);
		click(btn_list);
		driver.switchTo().defaultContent();
		if (getNumberOfWindows() == 2) {
			switchToSecondWindow();
			tblSelectRowByColValue(duplicateAWB_table, 1, 2, fullAWBNo);
			click(duplicateAWB_btn_ok);
			switchToFirstWindow();
		}
		minWait();
		if (verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		maxWait();
		return;
	}

	/**
	 * Created by A-7605 on 30-4-18 This method generate Delivery id and DN for
	 * partial pcs
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param customerCode
	 * @param deliveryPcs
	 * @param deliveryWeight
	 * @param totalPcs
	 * @param totalWeight
	 * @param deliveryID
	 * @param DNId
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDeliveryIDAndDNForPartialPieces(String awbPrefix, String awbNo, String customerCode,
			String deliveryPcs, String deliveryWeight, String totalPcs, String totalWeight, String deliveryID,
			String DNId, boolean isChargeCollectPopupExpected) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		deliveryPcs = PropertyHandler.getPropValue(dataFilePath, deliveryPcs);
		deliveryWeight = PropertyHandler.getPropValue(dataFilePath, deliveryWeight);
		totalPcs = PropertyHandler.getPropValue(dataFilePath, totalPcs);
		totalWeight = PropertyHandler.getPropValue(dataFilePath, totalWeight);

		listWithAWB(awbPrefix, awbNo);
		enterKeys(txt_pcs, deliveryPcs);
		enterKeys(txt_wt, deliveryWeight);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		click(waitForElement(noBtn));
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		waitForElement(btn_clear);
		minWait();

		String dnDetails = getWebElements(td_dnDetails).get(getWebElements(td_dnDetails).size() - 1).getText();
		String dnID = dnDetails.split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(deliveryPcs + "/" + deliveryWeight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, DNId, dnID);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(dnDetails.contains(deliveryPcs + "/" + deliveryWeight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 on 30-4-18 This method generate Delivery id and DN for
	 * remaining pcs
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param customerCode
	 * @param remainingPcs
	 * @param remainingWeight
	 * @param totalPcs
	 * @param totalWeight
	 * @param deliveryID
	 * @param DNId
	 * @param isChargeCollectPopupExpected
	 * @param previouseDeliveryID
	 * @return
	 */
	public OPR293 generateDeliveryIDAndDNForRemainingPieces(String awbPrefix, String awbNo, String customerCode,
			String remainingPcs, String remainingWeight, String deliveryID, String DNId,
			boolean isChargeCollectPopupExpected) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		remainingPcs = PropertyHandler.getPropValue(dataFilePath, remainingPcs);
		remainingWeight = PropertyHandler.getPropValue(dataFilePath, remainingWeight);

		listWithAWB(awbPrefix, awbNo);
		minWait();
		Assert.assertEquals(waitForElementVisible(txt_pcs).getAttribute("value"), remainingPcs);
		Assert.assertEquals(waitForElementVisible(txt_wt).getAttribute("value"), remainingWeight);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		if (isChargeCollectPopupExpected) {
			driver.switchTo().defaultContent();
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);
		}

		minWait();
		waitForElement(btn_clear);
		minWait();

		String dnDetails = getWebElements(td_dnDetails).get(getWebElements(td_dnDetails).size() - 1).getText();
		String dnID = dnDetails.split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(remainingPcs + "/" + remainingWeight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, DNId, dnID);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(dnDetails.contains(remainingPcs + "/" + remainingWeight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 on 4-5-18 This method generate DN and Delivery ID for
	 * partial pcs, for which the shipment is break down to multiple locations
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param customerCode
	 * @param deliveryPcs
	 * @param deliveryWeight
	 * @param location
	 * @param deliveryID
	 * @param DNId
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDNForPartialPcs_MultipleLocations(String awbPrefix, String awbNo, String customerCode,
			String deliveryPcs, String deliveryWeight, String location, String deliveryID, String DNId,
			boolean isChargeCollectPopupExpected) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		deliveryPcs = PropertyHandler.getPropValue(dataFilePath, deliveryPcs);
		deliveryWeight = PropertyHandler.getPropValue(dataFilePath, deliveryWeight);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		listWithAWB(awbPrefix, awbNo);
		enterKeys(txt_pcs, deliveryPcs);
		enterKeys(txt_wt, deliveryWeight);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		click(waitForElement(noBtn));
		selectPicPcsFromShipmentLocations(location, deliveryPcs);
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		waitForElement(btn_clear);
		minWait();

		String dnDetails = getWebElements(td_dnDetails).get(getWebElements(td_dnDetails).size() - 1).getText();
		String dnID = dnDetails.split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(deliveryPcs + "/" + deliveryWeight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, DNId, dnID);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(dnDetails.contains(deliveryPcs + "/" + deliveryWeight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	private void selectPicPcsFromShipmentLocations(String location, String pickedPcs) {
		waitForNewWindow(2);
		switchToSecondWindow();
		tblsetTextByColValue(shipmentLocations_table, 5, 2, location, pickedPcs);
		click(shipmentLocations_btn_ok);
		switchToFirstWindow();
	}

	/**
	 * Created by A-7605 on 5-4-18 This method generated delivery id for
	 * shipment for which delivery id alredy generated for some pcs
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param agentCode
	 * @param dnId
	 * @return
	 */
	public OPR293 generateDeliveryIdForRemainingPcs_NoChargeCollectPopup(String prefix, String awbNo, String agentCode,
			String dnId) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_agentCode, agentCode);
		enterKeys(txt_agentCode, Keys.TAB);
		check(chk_checkAll);
		click(btn_generateId);

		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
			minWait();
		}
		waitForFrameAndSwitch(FRAME);

		waitForElement(btn_clear);
		minWait();
		String temp_dnId = getWebElements(td_dnDetails).get(1).getText().split("\\[")[0];
		String temp_dnStatus = getWebElements(td_dnDetails).get(1).getText().split("\\[")[1];
		Assert.assertFalse(temp_dnId.isEmpty(), "ERROR : DN ID field is Empty");
		Assert.assertTrue(temp_dnStatus.contains("Paid"), "Error actual DN status is " + temp_dnStatus);

		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		click(btn_clear);
		return this;
	}

	/**
	 * Created by A-7605 on 7-5-18 This method generate Delivery for partial pcs
	 * for HAWB
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param house
	 * @param pcs
	 * @param wgt
	 * @param agentCode
	 * @param dnId
	 * @param deliveryID
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDeliveryIDForPartialPcsInMultipleLoc_HAWB(String prefix, String awbNo, String house,
			String pcs, String wgt, String location, String agentCode, String dnId, String deliveryID,
			boolean isChargeCollectPopupExpected) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		listWithHouse(house, prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_pcs, pcs);
		enterKeys(txt_wt, wgt);
		enterKeys(txt_agentCode, agentCode);
		enterKeys(txt_agentCode, Keys.TAB);
		check(chk_checkAll);
		click(btn_generateId);

		driver.switchTo().defaultContent();

		click(waitForElement(noBtn));
		selectPicPcsFromShipmentLocations(location, pcs);
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			minWait();
			switchToFirstWindow();
		}
		maxWait();
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		minWait();
		String tempDeliveryID = getTableCellValue(table_details, 10, 2);
		tempDeliveryID = tempDeliveryID.split("\\[")[0];
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String temp_dnStatus = waitForElement(td_dnDetails).getText().split("\\[")[1];
		Assert.assertFalse(temp_dnId.isEmpty(), "ERROR : DN ID field is Empty");
		Assert.assertTrue(temp_dnStatus.contains("Paid"), "Error actual DN status is " + temp_dnStatus);

		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, tempDeliveryID);
		click(btn_clear);
		return this;
	}

	/**
	 * Created by A-7605 on 7-5-18 This method generate Delivery for remaining
	 * pcs for HAWB
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param house
	 * @param agentCode
	 * @param dnId
	 * @param deliveryID
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDeliveryIDForRemainingPcs_HAWB(String prefix, String awbNo, String house, String agentCode,
			String dnId, String deliveryID, boolean isChargeCollectPopupExpected) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		house = PropertyHandler.getPropValue(dataFilePath, house);

		listWithHouse(house, prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_agentCode, agentCode);
		enterKeys(txt_agentCode, Keys.TAB);
		check(chk_checkAll);
		click(btn_generateId);

		driver.switchTo().defaultContent();
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			minWait();
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);

		waitForElement(btn_clear);
		minWait();
		String tempDeliveryID = getTableCellValue(table_details, 10, 2);
		tempDeliveryID = tempDeliveryID.split("\\[")[0];
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String temp_dnStatus = waitForElement(td_dnDetails).getText().split("\\[")[1];
		Assert.assertFalse(temp_dnId.isEmpty(), "ERROR : DN ID field is Empty");
		Assert.assertTrue(temp_dnStatus.contains("Paid"), "Error actual DN status is " + temp_dnStatus);

		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, tempDeliveryID);
		click(btn_clear);
		return this;
	}

	/**
	 * Created by A-7605 on 7-5-18 This method generate DN and Delivery ID for
	 * HAWB
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param hawb
	 * @param customerCode
	 * @param deliveryPcs
	 * @param deliveryWeight
	 * @param totalPcs
	 * @param totalWeight
	 * @param deliveryID
	 * @param DNId
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDeliveryIDAndDNForPartialPieces_HAWB(String awbPrefix, String awbNo, String hawb,
			String customerCode, String deliveryPcs, String deliveryWeight, String totalPcs, String totalWeight,
			String deliveryID, String DNId, boolean isChargeCollectPopupExpected) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		deliveryPcs = PropertyHandler.getPropValue(dataFilePath, deliveryPcs);
		deliveryWeight = PropertyHandler.getPropValue(dataFilePath, deliveryWeight);
		totalPcs = PropertyHandler.getPropValue(dataFilePath, totalPcs);
		totalWeight = PropertyHandler.getPropValue(dataFilePath, totalWeight);
		hawb = PropertyHandler.getPropValue(dataFilePath, hawb);

		listWithHouse(hawb, awbPrefix, awbNo);
		enterKeys(txt_pcs, deliveryPcs);
		enterKeys(txt_wt, deliveryWeight);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		click(waitForElement(noBtn));
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		waitForElement(btn_clear);
		minWait();

		String dnDetails = getWebElements(td_dnDetails).get(getWebElements(td_dnDetails).size() - 1).getText();
		String dnID = dnDetails.split("\\[")[0];
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(deliveryPcs + "/" + deliveryWeight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, DNId, dnID);
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(dnDetails.contains(deliveryPcs + "/" + deliveryWeight + "/Paid"));
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 on 9-5-18 This method generate DN for more than on AWBs
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param customerCode
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDNForMoreThanOneShipments(String awbPrefix, String[] awbNo, String customerCode,
			boolean isChargeCollectPopupExpected) {

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		for (int i = 0; i < awbNo.length; i++)
			awbNo[i] = PropertyHandler.getPropValue(dataFilePath, awbNo[i]);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		for (int i = 0; i < awbNo.length; i++) {
			listWithAWB(awbPrefix, awbNo[i]);
		}

		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_generateId);
		minWait();
		for (int i = 0; i < awbNo.length; i++) {
			Assert.assertTrue(getTableCellValue(table_details, 10, i + 1).trim().length() > 0);
			Assert.assertEquals(getTableCellValue(table_details, 11, i + 1).trim(), "0");
			Assert.assertEquals(getTableCellValue(table_details, 12, i + 1).trim(), "0");
		}
		return this;
	}

	/**
	 * Created by A-7605 on 9-5-18 This method generate delivery id for pcs (dn
	 * wont be verified)
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param pieces
	 * @param weight
	 * @param deliveryID
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDeliveryID_DNNotMandatory(String prefix, String awbNo, String customerCode, String pieces,
			String weight, String deliveryID, boolean isChargeCollectPopupExpected) {

		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_pcs, pieces);
		enterKeys(txt_wt, weight);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		maxWait();
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(pieces + "/" + weight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 on 9-5-18 This method generate delivery id for all
	 * remaining pcs for multiple AWBs(dn wont be verified)
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param deliveryID
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDeliveryIDForMultipleAWB_DNNotMandatory(String prefix, String[] awbNo, String customerCode,
			String deliveryID[], boolean isChargeCollectPopupExpected) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		for (int i = 0; i < awbNo.length; i++)
			awbNo[i] = PropertyHandler.getPropValue(dataFilePath, awbNo[i]);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		for (int i = 0; i < awbNo.length; i++) {
			list(prefix, awbNo[i]);
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn))
				click(yesBtn);
			waitForFrameAndSwitch(FRAME);
			minWait();
		}
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		maxWait();
		for (int i = 0; i < awbNo.length; i++) {
			String delID = getTableCellValue(table_details, 10, i + 2);
			delID = delID.split("\\[")[0];
			PropertyHandler.setPropValue(dataFilePath, deliveryID[i], delID);
			Assert.assertTrue(delID.trim().length() > 0);
		}
		return this;
	}

	/**
	 * Created by A-7605 on 10-5-18 This method generate Delivery for intact
	 * shipment (DN Not mandatory)
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param deliveryID
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDeliveryIDForIntactShipment_DNNotMandatory(String prefix, String awbNo, String customerCode,
			String deliveryID, boolean isChargeCollectPopupExpected) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		Assert.assertNotNull(waitForElementVisible(txt_pcs).getAttribute("readonly"));
		Assert.assertNotNull(waitForElementVisible(txt_wt).getAttribute("readonly"));
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		maxWait();
		String delID = getTableCellValue(table_details, 10, 2);
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	public OPR293 generateDNForPartialPcs_MultipleLocations_DNNotMandatory(String awbPrefix, String awbNo,
			String customerCode, String deliveryPcs, String deliveryWeight, String location, String deliveryID,
			boolean isChargeCollectPopupExpected) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		deliveryPcs = PropertyHandler.getPropValue(dataFilePath, deliveryPcs);
		deliveryWeight = PropertyHandler.getPropValue(dataFilePath, deliveryWeight);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		listWithAWB(awbPrefix, awbNo);
		enterKeys(txt_pcs, deliveryPcs);
		enterKeys(txt_wt, deliveryWeight);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		// selectPicPcsFromShipmentLocations(location, deliveryPcs);
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		waitForElement(btn_clear);
		minWait();
		String delID = getTableCellValue(table_details, 10, 2);
		Assert.assertTrue(delID.contains(deliveryPcs + "/" + deliveryWeight));
		delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, deliveryID, delID);
		Assert.assertTrue(delID.trim().length() > 0);
		return this;
	}

	/**
	 * Created by A-7605 on 14-5-18 This method generate DN in Issued status for
	 * an AWB, HAWB and Intact AWB for partial pcs and then for remaining pcs
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param awbTotalPcs
	 * @param awbTotalWgt
	 * @param awbPartialPcs
	 * @param awbPartialWeight
	 * @param house
	 * @param hawb
	 * @param houseTotalPcs
	 * @param houseTotalWgt
	 * @param hawbPartialPcs
	 * @param hawbPartialWeight
	 * @param intactAWB
	 * @param intactAWBTotalPcs
	 * @param intactAWBTotalWgt
	 * @param customerCode
	 * @return
	 */
	public OPR293 generateDNForPartialShipments_1AWB_1HAWB_1intact(String awbPrefix, String awbNo, String awbTotalPcs,
			String awbTotalWgt, String awbPartialPcs, String awbPartialWeight, String house, String hawb,
			String houseTotalPcs, String houseTotalWgt, String hawbPartialPcs, String hawbPartialWeight,
			String intactAWB, String intactAWBTotalPcs, String intactAWBTotalWgt, String customerCode) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbTotalPcs = PropertyHandler.getPropValue(dataFilePath, awbTotalPcs);
		awbTotalWgt = PropertyHandler.getPropValue(dataFilePath, awbTotalWgt);
		awbPartialPcs = PropertyHandler.getPropValue(dataFilePath, awbPartialPcs);
		awbPartialWeight = PropertyHandler.getPropValue(dataFilePath, awbPartialWeight);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		hawb = PropertyHandler.getPropValue(dataFilePath, hawb);
		houseTotalPcs = PropertyHandler.getPropValue(dataFilePath, houseTotalPcs);
		houseTotalWgt = PropertyHandler.getPropValue(dataFilePath, houseTotalWgt);
		hawbPartialPcs = PropertyHandler.getPropValue(dataFilePath, hawbPartialPcs);
		hawbPartialWeight = PropertyHandler.getPropValue(dataFilePath, hawbPartialWeight);
		intactAWB = PropertyHandler.getPropValue(dataFilePath, intactAWB);
		intactAWBTotalPcs = PropertyHandler.getPropValue(dataFilePath, intactAWBTotalPcs);
		intactAWBTotalWgt = PropertyHandler.getPropValue(dataFilePath, intactAWBTotalWgt);

		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		String fullAWBNo = awbNo;
		String fullHAWBNo = hawb;
		String fullIntactAWBNo = intactAWB;

		listWithAWB(awbPrefix, awbNo);
		listWithHouse(house, awbPrefix, hawb);
		listWithAWB(awbPrefix, intactAWB);
		minWait();

		tblsetTextByColValue(table_details, 12, 4, fullAWBNo, awbPartialPcs);
		tblsetTextByColValue(table_details, 13, 4, fullAWBNo, awbPartialWeight);

		tblsetTextByColValue(table_details, 12, 4, fullHAWBNo, hawbPartialPcs);
		tblsetTextByColValue(table_details, 13, 4, fullHAWBNo, hawbPartialWeight);

		try {
			tblsetTextByColValue(table_details, 12, 4, fullIntactAWBNo, hawbPartialPcs);
			Assert.fail("Intact AWB pieces field is editable");
		} catch (Exception e) {

		}
		try {
			tblsetTextByColValue(table_details, 13, 4, fullIntactAWBNo, hawbPartialWeight);
			Assert.fail("Intact AWB pieces field is editable");
		} catch (Exception e) {

		}
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		click(waitForElement(noBtn));
		waitForNewWindow(2);
		switchToSecondWindow();
		minWait();
		waitForElement(btn_chargeCollectPopup_Close);
		minWait();
		click(btn_chargeCollectPopup_Close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		Assert.assertTrue(tblGetTextByColValue(table_details, 15, 4, fullAWBNo).contains("Issued"));
		Assert.assertTrue(tblGetTextByColValue(table_details, 15, 4, fullHAWBNo).contains("Issued"));
		Assert.assertTrue(tblGetTextByColValue(table_details, 15, 4, fullIntactAWBNo).contains("Issued"));

		String remainingAWBPcs = String.valueOf(Integer.parseInt(awbTotalPcs) - Integer.valueOf(awbPartialPcs));
		String remainingAWBWgt = String.valueOf(Integer.parseInt(awbTotalWgt) - Integer.valueOf(awbPartialWeight));

		String remainingHAWBPcs = String.valueOf(Integer.parseInt(houseTotalPcs) - Integer.valueOf(hawbPartialPcs));
		String remainingHAWBWgt = String.valueOf(Integer.parseInt(houseTotalWgt) - Integer.valueOf(hawbPartialWeight));

		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 12, 4, fullAWBNo), remainingAWBPcs);
		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 13, 4, fullAWBNo), remainingAWBWgt);

		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 12, 4, fullHAWBNo), remainingHAWBPcs);
		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 13, 4, fullHAWBNo), remainingHAWBWgt);

		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 12, 4, fullIntactAWBNo), "0");
		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 13, 4, fullIntactAWBNo), "0");

		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		minWait();
		waitForElement(btn_chargeCollectPopup_Close);
		minWait();
		click(btn_chargeCollectPopup_Close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();

		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 12, 4, fullAWBNo), "0");
		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 13, 4, fullAWBNo), "0");

		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 12, 4, fullHAWBNo), "0");
		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 13, 4, fullHAWBNo), "0");

		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 12, 4, fullIntactAWBNo), "0");
		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 13, 4, fullIntactAWBNo), "0");
		return this;
	}

	/**
	 * Created by A-7605 on 14-5-18 This method generate DN in Issued status for
	 * an AWB, HAWB and Intact AWB for full pcs
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param house
	 * @param hawb
	 * @param intactAWB
	 * @param customerCode
	 * @return
	 */
	public OPR293 generateDNForFullShipments_1AWB_1HAWB_1intact(String awbPrefix, String awbNo, String house,
			String hawb, String intactAWB, String customerCode) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		hawb = PropertyHandler.getPropValue(dataFilePath, hawb);
		intactAWB = PropertyHandler.getPropValue(dataFilePath, intactAWB);

		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		String fullAWBNo = awbNo;
		String fullHAWBNo = hawb;
		String fullIntactAWBNo = intactAWB;

		listWithAWB(awbPrefix, awbNo);
		listWithHouse(house, awbPrefix, hawb);
		listWithAWB(awbPrefix, intactAWB);
		minWait();

		try {
			tblsetTextByColValue(table_details, 12, 4, fullIntactAWBNo, "0");
			Assert.fail("Intact AWB pieces field is editable");
		} catch (Exception e) {

		}
		try {
			tblsetTextByColValue(table_details, 13, 4, fullIntactAWBNo, "0");
			Assert.fail("Intact AWB pieces field is editable");
		} catch (Exception e) {

		}
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		minWait();
		waitForElement(btn_chargeCollectPopup_Close);
		minWait();
		click(btn_chargeCollectPopup_Close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		Assert.assertTrue(tblGetTextByColValue(table_details, 15, 4, fullAWBNo).contains("Issued"));
		Assert.assertTrue(tblGetTextByColValue(table_details, 15, 4, fullHAWBNo).contains("Issued"));
		Assert.assertTrue(tblGetTextByColValue(table_details, 15, 4, fullIntactAWBNo).contains("Issued"));

		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 12, 4, fullAWBNo), "0");
		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 13, 4, fullAWBNo), "0");

		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 12, 4, fullHAWBNo), "0");
		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 13, 4, fullHAWBNo), "0");

		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 12, 4, fullIntactAWBNo), "0");
		Assert.assertEquals(tblGetFieldValueByColValue(table_details, 13, 4, fullIntactAWBNo), "0");
		return this;
	}

	/**
	 * Created by A-7605 on 14-5-18 This method generate DN in Issued status for
	 * full pcs in AWB
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param dnId
	 * @param checkVerifyBeforePaymentCheckbox
	 * @return
	 */
	public OPR293 generateDNInIssuedStatus_ChargeCollectPopup(String prefix, String awbNo, String customerCode,
			String dnId, boolean checkVerifyBeforePaymentCheckbox, String serviceName, String chargeNames) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		serviceName = PropertyHandler.getPropValue(dataFilePath, serviceName);
		chargeNames = PropertyHandler.getPropValue(dataFilePath, chargeNames);
		String[] charges = chargeNames.split(",");

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);

		if (checkVerifyBeforePaymentCheckbox)
			check(chkbox_verifyBeforePayment);
		else if (verifyElementPresent(chkbox_verifyBeforePayment))
			unCheck(chkbox_verifyBeforePayment);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		waitForElement(btn_chargeCollectPopup_Close);
		minWait();
		String service = getTableCellValue(chargesCollectPopup_table_chargeLevelSummary, 1, 1);
		Assert.assertEquals(service, serviceName);
		List<String> actualCharges = getTableColumnValues(chargesCollectPopup_table_chargeLevelSummary, 2);
		for (String actualCharge : actualCharges)
			Assert.assertTrue((Arrays.asList(charges)).contains(actualCharge));
		click(btn_chargeCollectPopup_Close);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		minWait();
		String dnID = waitForElement(td_dnDetails).getText().split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, dnId, dnID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains("Issued"));
		return this;
	}

	/**
	 * Created by A-7605 This method generate DN for full pcs. Charge Collect
	 * pop up is not expected during DN generation
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param pieces
	 * @param weight
	 * @param dnId
	 * @param verifyBeforePayment
	 * @return
	 */
	public OPR293 generateDNForAllPcs_NoChargeCollectPopup_NoDeliveryID(String prefix, String awbNo,
			String customerCode, String pieces, String weight, String dnId, boolean verifyBeforePayment) {

		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		if (verifyElementPresent(chkbox_verifyBeforePayment)) {
			if (!verifyBeforePayment)
				unCheck(chkbox_verifyBeforePayment);
		}
		if (verifyBeforePayment)
			check(chkbox_verifyBeforePayment);

		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		maxWait();
		String dnID = waitForElement(td_dnDetails).getText().split("\\[")[0];

		PropertyHandler.setPropValue(dataFilePath, dnId, dnID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains(pieces + "/" + weight + "/Paid"));
		return this;
	}

	/**
	 * Created by A-7605 on 14-5-18 This method generate DN in Paid status for
	 * full pcs in AWB
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param dnId
	 * @param checkVerifyBeforePaymentCheckbox
	 * @param serviceName
	 * @param chargeNames
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDNInPaidStatus_NoDeliveryID(String prefix, String awbNo, String customerCode, String dnId,
			boolean checkVerifyBeforePaymentCheckbox, String serviceName, String chargeNames,
			boolean isChargeCollectPopupExpected) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		serviceName = PropertyHandler.getPropValue(dataFilePath, serviceName);
		chargeNames = PropertyHandler.getPropValue(dataFilePath, chargeNames);
		String[] charges = null;
		if (chargeNames != null && chargeNames.trim().length() > 0)
			charges = chargeNames.split(",");
		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);

		if (checkVerifyBeforePaymentCheckbox)
			check(chkbox_verifyBeforePayment);
		else if (verifyElementPresent(chkbox_verifyBeforePayment))
			unCheck(chkbox_verifyBeforePayment);
		click(btn_generateId);
		if (isChargeCollectPopupExpected) {
			driver.switchTo().defaultContent();
			waitForNewWindow(2);
			switchToSecondWindow();
			waitForElement(btn_chargeCollectPopup_Close);
			minWait();
			String service = getTableCellValue(chargesCollectPopup_table_chargeLevelSummary, 1, 1);
			if (serviceName != null && serviceName.trim().length() > 0)
				Assert.assertEquals(service, serviceName);
			if (chargeNames != null && chargeNames.trim().length() > 0) {
				List<String> actualCharges = getTableColumnValues(chargesCollectPopup_table_chargeLevelSummary, 2);
				for (String actualCharge : actualCharges)
					Assert.assertTrue((Arrays.asList(charges)).contains(actualCharge));
			}

			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
			maxWait();
			waitForFrameAndSwitch(FRAME);
		}
		maxWait();
		waitForElement(btn_clear);
		minWait();
		String dnID = waitForElement(td_dnDetails).getText().split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, dnId, dnID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains("Paid"));
		return this;
	}

	private void listWithULD(String uldNo, String awbPrefix, String awbNo) {
		enterKeys(txt_uld, uldNo);
		enterKeys(txt_prefix, awbPrefix);
		enterKeys(txt_awb, awbNo);
		click(btn_list);
		maxWait();
	}

	private String verifyDN(String pcs, String wgt, String status) {
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains(pcs + "/" + wgt + "/" + status));
		return waitForElement(td_dnDetails).getText().split("\\[")[0];
	}

	/**
	 * Created by A-7605 on 15-5-18 This method generate DN in paid status for 3
	 * intact ULDs and 1Bulk in a single AWB
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param uldNo1
	 * @param uldNo2
	 * @param uldNo3
	 * @param totalULDPcs
	 * @param totalULDWgt
	 * @param customerCode
	 * @param dnId
	 * @return
	 */
	public OPR293 generateDNInPaidStatus_3ULDsAnd1BulkInSingleAWB(String prefix, String awbNo, String uldNo1,
			String uldNo2, String uldNo3, String totalULDPcs, String totalULDWgt, String customerCode, String dnId) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		uldNo1 = PropertyHandler.getPropValue(dataFilePath, uldNo1);
		uldNo2 = PropertyHandler.getPropValue(dataFilePath, uldNo2);
		uldNo3 = PropertyHandler.getPropValue(dataFilePath, uldNo3);
		totalULDPcs = PropertyHandler.getPropValue(dataFilePath, totalULDPcs);
		totalULDWgt = PropertyHandler.getPropValue(dataFilePath, totalULDWgt);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);

		click(btn_generateId);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		waitForElement(btn_chargeCollectPopup_Close);
		minWait();
		String storageCharge = getTableCellValue(chargesCollectPopup_table_chargeLevelSummary, 1, 1);
		enterKeys(txt_remarks, "Payment Remarks");
		click(btn_pymntOk);
		minWait();
		click(btn_accept);
		switchToFirstWindow();
		maxWait();
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		maxWait();
		clear();
		maxWait();
		listWithULD(uldNo1, prefix, awbNo);
		verifyDN(totalULDPcs, totalULDWgt, "Paid");
		clear();
		maxWait();
		listWithULD(uldNo2, prefix, awbNo);
		verifyDN(totalULDPcs, totalULDWgt, "Paid");
		clear();
		maxWait();
		listWithULD(uldNo3, prefix, awbNo);
		String dn = verifyDN(totalULDPcs, totalULDWgt, "Paid");
		clear();
		maxWait();
		listWithULD("BULK", prefix, awbNo);
		Assert.assertFalse(waitForElement(td_dnDetails).getText().split("\\[")[0].equals(dn));
		clear();
		maxWait();
		return this;
	}

	/**
	 * Created by A-7605 on 15-4-18 This method generate DN in Paid status for
	 * partial shipments
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param pcs
	 * @param wgt
	 * @param agentCode
	 * @param dnId
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDNForPartialPcs_PaidStatus(String prefix, String awbNo, String pcs, String wgt,
			String agentCode, String dnId, boolean isChargeCollectPopupExpected) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_pcs, pcs);
		enterKeys(txt_wt, wgt);
		enterKeys(txt_agentCode, agentCode);
		enterKeys(txt_agentCode, Keys.TAB);
		check(chk_checkAll);
		click(btn_generateId);

		driver.switchTo().defaultContent();
		try {
			click(noBtn);
		} catch (Exception e) {

		}
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			minWait();
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
			maxWait();
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		waitForElement(btn_clear);
		minWait();
		WebElement recentDN = getWebElements(td_dnDetails).get(0);
		String temp_dnId = waitForElement(recentDN).getText().split("\\[")[0];
		String temp_dnStatus = waitForElement(recentDN).getText().split("\\[")[1];
		Assert.assertFalse(temp_dnId.isEmpty(), "ERROR : DN ID field is Empty");
		Assert.assertTrue(temp_dnStatus.contains("Paid"), "Error actual DN status is " + temp_dnStatus);
		temp_dnId = null;
		for (int i = 0; i < getWebElements(td_dnDetails).size(); i++) {
			String dnID = getWebElements(td_dnDetails).get(i).getText().split("\\[")[0];
			if (temp_dnId == null)
				temp_dnId = dnID;
			else
				temp_dnId = temp_dnId + "," + dnID;
		}
		temp_dnId = sortDN(temp_dnId);
		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		click(btn_clear);
		return this;
	}

	private String sortDN(String dnNumberSeperatedByComma) {
		String[] dnNumbers = dnNumberSeperatedByComma.split(",");
		String sortedDN = null;

		for (int i = 0; i < dnNumbers.length - 1; i++) {
			for (int j = 0; j < dnNumbers.length - 1; j++) {
				if (Integer.parseInt(dnNumbers[j].split("N")[1]) > Integer.parseInt(dnNumbers[j + 1].split("N")[1])) {
					String temp = dnNumbers[j];
					dnNumbers[j] = dnNumbers[j + 1];
					dnNumbers[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < dnNumbers.length; i++) {
			if (sortedDN == null)
				sortedDN = dnNumbers[i];
			else
				sortedDN = sortedDN + "," + dnNumbers[i];
		}

		return sortedDN;
	}

	/**
	 * Created by A-7605 on 15-5-18 This method verify all DN related to an AWB
	 * are listed in the table when listing with any of the DN
	 * 
	 * @param dnNo
	 * @param relatedDNs
	 * @return
	 */
	public OPR293 verifyAllDNsAssociatedWithAWBArelistedOnListingWithSingleDN(String dnNo, String relatedDNs) {
		dnNo = PropertyHandler.getPropValue(dataFilePath, dnNo);
		relatedDNs = PropertyHandler.getPropValue(dataFilePath, relatedDNs);
		String[] dns = relatedDNs.split(",");

		enterKeys(txt_dnID, dnNo.split(",")[0]);
		click(btn_list);
		maxWait();
		List<WebElement> dnNumberElements = getWebElements(td_dnDetails);
		List<String> dnNumbers = new ArrayList<>();
		for (WebElement dnNumberElement : dnNumberElements)
			dnNumbers.add(dnNumberElement.getText().split("\\[")[0]);
		for (String dn : dns) {
			Assert.assertTrue(dnNumbers.contains(dn), "The DN " + dn + " not in the table");
		}
		return this;
	}

	/**
	 * Created by A-7605 on 16-5-18 This method generate DN in paid status for
	 * two houses in a single AWB
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param house1
	 * @param house2
	 * @param customerCode
	 * @param dnId
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDNInPaidStatus_TwoHAWBInSingleAWB(String prefix, String awbNo, String house1, String house2,
			String customerCode, String dnId, boolean isChargeCollectPopupExpected) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		listWithHouse(house1, prefix, awbNo);
		minWait();
		listWithHouse(house2, prefix, awbNo);
		minWait();
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		if (isChargeCollectPopupExpected) {
			driver.switchTo().defaultContent();
			waitForNewWindow(2);
			switchToSecondWindow();
			waitForElement(btn_chargeCollectPopup_Close);
			minWait();
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
			maxWait();
			waitForFrameAndSwitch(FRAME);
		}
		waitForElement(btn_clear);
		minWait();
		String dnID = null;
		List<WebElement> dnNumbers = getWebElements(td_dnDetails);
		for (WebElement dnNumber : dnNumbers) {
			String dn = dnNumber.getText().split("\\[")[0];
			if (dnID == null)
				dnID = dn;
			else
				dnID = dnID + "," + dn;
		}
		PropertyHandler.setPropValue(dataFilePath, dnId, dnID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains("Paid"));
		return this;
	}

	/**
	 * Created by A-7605 on 17-5-18 This method generate DN and Delivery ID for
	 * partial pcs, for which the shipment is break down to multiple locations
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param customerCode
	 * @param deliveryPcs
	 * @param deliveryWeight
	 * @param location
	 * @param DNId
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDNForPartialPcs_MultipleLocations_NoDeliveryID(String awbPrefix, String awbNo,
			String customerCode, String deliveryPcs, String deliveryWeight, String location, String DNId,
			boolean isChargeCollectPopupExpected) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		deliveryPcs = PropertyHandler.getPropValue(dataFilePath, deliveryPcs);
		deliveryWeight = PropertyHandler.getPropValue(dataFilePath, deliveryWeight);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		listWithAWB(awbPrefix, awbNo);
		enterKeys(txt_pcs, deliveryPcs);
		enterKeys(txt_wt, deliveryWeight);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		click(waitForElement(noBtn));
		selectPicPcsFromShipmentLocations(location, deliveryPcs);
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		waitForElement(btn_clear);
		minWait();

		String dnDetails = getWebElements(td_dnDetails).get(getWebElements(td_dnDetails).size() - 1).getText();
		String dnID = dnDetails.split("\\[")[0];
		// String delID = getTableCellValue(table_details, 10, 2);
		// Assert.assertTrue(delID.contains(deliveryPcs+"/"+deliveryWeight));
		// delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, DNId, dnID);
		Assert.assertTrue(dnDetails.contains(deliveryPcs + "/" + deliveryWeight + "/Paid"));
		// Assert.assertTrue(delID.trim().length()>0);
		return this;
	}

	/**
	 * Created by A-7605 on 7-5-18 This method generate DN for partial pcs for
	 * HAWB (no delivery ID)
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param house
	 * @param pcs
	 * @param wgt
	 * @param agentCode
	 * @param dnId
	 * @param deliveryID
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDeliveryIDForPartialPcsInMultipleLoc_HAWB_NoDeliveryID(String prefix, String awbNo,
			String house, String pcs, String wgt, String location, String agentCode, String dnId,
			boolean isChargeCollectPopupExpected) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		listWithHouse(house, prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_pcs, pcs);
		enterKeys(txt_wt, wgt);
		enterKeys(txt_agentCode, agentCode);
		enterKeys(txt_agentCode, Keys.TAB);
		check(chk_checkAll);
		click(btn_generateId);

		driver.switchTo().defaultContent();

		click(waitForElement(noBtn));
		selectPicPcsFromShipmentLocations(location, pcs);
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			minWait();
			switchToFirstWindow();
		}
		maxWait();
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		minWait();
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		String temp_dnStatus = waitForElement(td_dnDetails).getText().split("\\[")[1];
		Assert.assertFalse(temp_dnId.isEmpty(), "ERROR : DN ID field is Empty");
		Assert.assertTrue(temp_dnStatus.contains("Paid"), "Error actual DN status is " + temp_dnStatus);

		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		click(btn_clear);
		return this;
	}

	/**
	 * Created by A-7605 on 21-5-18 This method generate DN for 3 AWBs, charge
	 * collect pop up is expected
	 * 
	 * @param prefix
	 * @param awbNo1
	 * @param awbNo2
	 * @param awbNo3
	 * @param customerCode
	 * @param dnId
	 * @param checkVerifyBeforePaymentCheckbox
	 * @param serviceName
	 * @param chargeNames
	 * @return
	 */
	public OPR293 generateDNInPaidStatus_3AWBs_ChargeCollectPopup(String prefix, String awbNo1, String awbNo2,
			String awbNo3, String customerCode, String dnId, boolean checkVerifyBeforePaymentCheckbox,
			String serviceName, String chargeNames) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo1 = PropertyHandler.getPropValue(dataFilePath, awbNo1);
		awbNo2 = PropertyHandler.getPropValue(dataFilePath, awbNo2);
		awbNo3 = PropertyHandler.getPropValue(dataFilePath, awbNo3);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		serviceName = PropertyHandler.getPropValue(dataFilePath, serviceName);
		chargeNames = PropertyHandler.getPropValue(dataFilePath, chargeNames);
		String[] charges = null;
		if (chargeNames != null && chargeNames.trim().length() > 0)
			charges = chargeNames.split(",");
		list(prefix, awbNo1);
		minWait();
		list(prefix, awbNo2);
		minWait();
		list(prefix, awbNo3);
		minWait();
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);

		if (checkVerifyBeforePaymentCheckbox)
			check(chkbox_verifyBeforePayment);
		else if (verifyElementPresent(chkbox_verifyBeforePayment))
			unCheck(chkbox_verifyBeforePayment);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		waitForElement(btn_chargeCollectPopup_Close);
		minWait();
		String service = getTableCellValue(chargesCollectPopup_table_chargeLevelSummary, 1, 1);
		if (serviceName != null && serviceName.trim().length() > 0)
			Assert.assertEquals(service, serviceName);
		if (chargeNames != null && chargeNames.trim().length() > 0) {
			List<String> actualCharges = getTableColumnValues(chargesCollectPopup_table_chargeLevelSummary, 2);
			for (String actualCharge : actualCharges)
				Assert.assertTrue((Arrays.asList(charges)).contains(actualCharge));
		}

		enterKeys(txt_remarks, "Payment Remarks");
		click(btn_pymntOk);
		minWait();
		click(btn_accept);
		switchToFirstWindow();
		maxWait();
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		minWait();
		List<WebElement> dnElements = getWebElements(td_dnDetails);
		String dnID = null;
		for (WebElement dnElement : dnElements) {
			String currentDN = dnElement.getText().split("\\[")[0];
			if (dnID == null)
				dnID = currentDN;
			else
				dnID = dnID + "," + currentDN;
		}
		dnID = sortDN(dnID);
		PropertyHandler.setPropValue(dataFilePath, dnId, dnID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains("Paid"));
		return this;
	}

	/**
	 * Created by A-7605 on 22-5-18 This method generate DN in Paid status for
	 * partial shipment. Delivery ID is not expected
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param deliveryPcs
	 * @param deliveryWgt
	 * @param customerCode
	 * @param dnId
	 * @param checkVerifyBeforePaymentCheckbox
	 * @param serviceName
	 * @param chargeNames
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDNForPartialPcsInPaidStatus_NoDeliveryID(String prefix, String awbNo, String deliveryPcs,
			String deliveryWgt, String totalPcs, String totalWgt, String customerCode, String dnId,
			boolean checkVerifyBeforePaymentCheckbox, String serviceName, String chargeNames,
			boolean isChargeCollectPopupExpected) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		deliveryPcs = PropertyHandler.getPropValue(dataFilePath, deliveryPcs);
		deliveryWgt = PropertyHandler.getPropValue(dataFilePath, deliveryWgt);
		chargeNames = PropertyHandler.getPropValue(dataFilePath, chargeNames);
		serviceName = PropertyHandler.getPropValue(dataFilePath, serviceName);
		totalPcs = PropertyHandler.getPropValue(dataFilePath, totalPcs);
		totalWgt = PropertyHandler.getPropValue(dataFilePath, totalWgt);
		String[] charges = null;
		if (chargeNames != null && chargeNames.trim().length() > 0)
			charges = chargeNames.split(",");
		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);

		if (checkVerifyBeforePaymentCheckbox)
			check(chkbox_verifyBeforePayment);
		else if (verifyElementPresent(chkbox_verifyBeforePayment))
			unCheck(chkbox_verifyBeforePayment);
		enterKeys(txt_pcs, deliveryPcs);
		enterKeys(txt_wt, deliveryWgt);
		check(chk_checkAll);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		click(waitForElement(noBtn));
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			waitForElement(btn_chargeCollectPopup_Close);
			minWait();
			String service = getTableCellValue(chargesCollectPopup_table_chargeLevelSummary, 1, 1);
			if (serviceName != null && serviceName.trim().length() > 0)
				Assert.assertEquals(service, serviceName);
			if (chargeNames != null && chargeNames.trim().length() > 0) {
				List<String> actualCharges = getTableColumnValues(chargesCollectPopup_table_chargeLevelSummary, 2);
				for (String actualCharge : actualCharges)
					Assert.assertTrue((Arrays.asList(charges)).contains(actualCharge));
			}

			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
			maxWait();
		}
		waitForFrameAndSwitch(FRAME);
		maxWait();
		waitForElement(btn_clear);
		minWait();
		String dnID = waitForElement(td_dnDetails).getText().split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, dnId, dnID);
		Assert.assertTrue(
				waitForElement(td_dnDetails).getText().contains(deliveryPcs + "/" + deliveryWgt + "/" + "Paid"));
		Assert.assertEquals(waitForElementVisible(txt_pcs).getAttribute("value"),
				String.valueOf(Integer.parseInt(totalPcs) - Integer.parseInt(deliveryPcs)));
		Assert.assertEquals(waitForElementVisible(txt_wt).getAttribute("value"),
				String.valueOf(Integer.parseInt(totalWgt) - Integer.parseInt(deliveryWgt)));
		return this;
	}

	/**
	 * Created by A-7605 on 9-5-18 This method generate DN for more than on AWBs
	 * (for normal DN)
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param customerCode
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDNForMoreThanOneShipments_NoDeliveryID(String awbPrefix, String[] awbNo, String customerCode,
			boolean isChargeCollectPopupExpected) {

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		for (int i = 0; i < awbNo.length; i++)
			awbNo[i] = PropertyHandler.getPropValue(dataFilePath, awbNo[i]);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		for (int i = 0; i < awbNo.length; i++) {
			listWithAWB(awbPrefix, awbNo[i]);
		}

		check(chk_checkAll);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		click(btn_generateId);
		driver.switchTo().defaultContent();
		if (isChargeCollectPopupExpected) {
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			waitForElement(btn_chargeCollectPopup_Close);
			enterKeys(txt_remarks, "Payment Remarks");
			click(btn_pymntOk);
			minWait();
			click(btn_accept);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_generateId);
		minWait();
		for (int i = 0; i < awbNo.length; i++) {
			Assert.assertEquals(tblGetTextByColValue(table_details, 10, 4, awbNo[i]), "0");
			Assert.assertEquals(tblGetTextByColValue(table_details, 11, 4, awbNo[i]), "0");
		}
		return this;
	}

	/**
	 * Created by Shalini on 9-12-2019 This method generate DNID
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param customerCode
	 * @param isChargeCollectPopupExpected
	 * @return
	 */
	public OPR293 generateDNIDonFlightDetails(String carrierwithFlightno, String fltDt) {
		carrierwithFlightno = PropertyHandler.getPropValue(dataFilePath, carrierwithFlightno);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		String FlightNo = carrierwithFlightno.replaceAll("[^0-9]", "");
		String carrierCode = carrierwithFlightno.replaceAll("[^a-z,A-z]", "");
		enterKeys(txt_flightCarrierCode, carrierCode);
		enterKeys(txt_flightNo, FlightNo);
		enterKeys(txt_flightDate, fltDt);
		// click(btn_list);
		enterKeys(btn_list, Keys.F12);
		maxWait();
		click(checkFirstTableItem);
		click(btn_generateId);
		maxWait();
		maxWait();
		InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on Generate DN ID button in OPR93 screen");

		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		click(link_Cashmode);
		enterKeys(txt_billableName, "Cargo");
		enterKeys(txt_billableRemark, "Acceptance Testing");
		click(btn_pymntOk);
		minWait();
		click(btn_accept);
		driver.switchTo().frame("iCargoContentFrameOPR293");
		String DeliveryID = driver.findElement(By.xpath("//input[@name='deliveryID']")).getAttribute("value");
		InitialSetup.test.log(LogStatus.PASS, "Successfully shipped to a customer with :" + DeliveryID + "delivery ID");
		return this;
	}

	/**
	 * Created by Sharath on 04-03-2019 This method generate DNID
	 * 
	 * @param awbNo
	 * @return
	 */
	public OPR293 generateDNIDonFlightDetails(String awbNo) {
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		click(By.name("clearingAgent"));
		enterKeys(txt_awbNo, awbNo);
		// click(btn_list);
		enterKeys(btn_list, Keys.F12);
		maxWait();
		// added on 6thSept, pick up person details mandatory
		enterKeys(By.name("pickUpPersonName"), "Test");
		enterKeys(By.name("pickupCompanyName"), "TestCompany");
		click(By.xpath("//div[@id='IDDetails']//img"));
		maxWait();
		selectByText(By.xpath("(//select[@name='customerIDType'])[1]"), "Driving License");
		enterKeys(By.xpath("(//input[@name='customerIDDetailsInfo'])[1]"), "123456");
		enterKeys(By.xpath("(//input[@name='customerIdIssuingState'])[1]"), "US");
		selectByText(By.xpath("(//select[@name='customerPhotoIdVerified'])[1]"), "Yes");
		click(By.xpath("//span[text()='ID Details']/../button"));
		maxWait();
		// added till here
		click(checkFirstTableItem);
		click(btn_generateId);
		minWait();
		InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on Generate DN ID button in OPR93 screen");
		try {
			driver.switchTo().defaultContent();
			if (verifyElementPresent(By.xpath("//p[contains(text(),'No Active Cash draw exists')]"))) {
				click(By.xpath("//button[text()='Yes']"));
				minWait();
			}
			waitForNewWindow(2);
			switchToSecondWindow();
			minWait();
			try {
				// click(driver.findElement(By.xpath("//input[@type='checkbox'
				// and @value='0']")));
				// Not available since 3rd June2019
				if (driver.findElement(By.xpath("//input[@type='checkbox' and @value='1']")).isSelected()) {
					click(By.xpath("//h2[contains(text(),'CREDIT')]"));
					maxWait();
					maxWait();
					// maxWait();
					waitForElementStaleness(btn_pymntOk);
					click(btn_pymntOk);
					// enterKeys(By.name("paymentModeAttributeValues"),"Test");
					// click(btn_pymntOk);
				} else {
					click(link_Cashmode);
					enterKeys(txt_billableName, "Cargo");
					// enterKeys(txt_billableRemark, "Acceptance Testing");
					maxWait();
					maxWait();
					maxWait();
					// waitForElementStaleness(btn_pymntOk);
					click(btn_pymntOk);
				}
			} catch (Exception e) {
				InitialSetup.test.log(LogStatus.INFO, "No amount added automatically");
				logger.info("No amount added automatically");
			}
			minWait();
			click(btn_accept);
			if (verifyElementPresent(By.xpath("//img[@alt='Error Message']"))) {
				String errormessage = driver
						.findElement(By.xpath("//img[@alt='Error Message']/parent::td/following-sibling::td")).getText()
						.trim();
				InitialSetup.test.log(LogStatus.FAIL, "Payment acceptance failed due to error : " + errormessage);
				captureAndAddScreenshot();
				Assert.fail("Payment acceptance failed due to error : " + errormessage);
			}
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);
			String DeliveryID = driver.findElement(By.xpath("//input[@name='deliveryID']")).getAttribute("value");
			InitialSetup.test.log(LogStatus.PASS,
					"Successfully shipped to a customer with : " + DeliveryID + " delivery ID");
			captureAndAddScreenshot();
		} catch (Exception e) {
			waitForFrameAndSwitch("iCargoContentFrameOPR293");
			String DeliveryID = driver.findElement(By.xpath("//input[@name='deliveryID']")).getAttribute("value");
			InitialSetup.test.log(LogStatus.INFO,
					"Successfully shipped to a customer with : " + DeliveryID + " delivery ID");
			InitialSetup.test.log(LogStatus.FAIL, "Payment Screen didn't appear");
			captureAndAddScreenshot();
			Assert.fail("Payment Screen didn't appear");
		}
		deliverCargo();
		return this;
	}

	// Sharath
	public OPR293 deliverCargo() {
		click(By.name("btnCaptureDelivery"));
		click(By.xpath("(//td[@class='iCargoTableDataTd']//input)[2]"));
		// enterKeys(By.name("deliveredTo"), "Test Person");
		click(By.name("btnSave"));
		driver.switchTo().defaultContent();
		if (verifyElementPresent(By.xpath("//p[contains(text(),'Delivery Save completed')]"))) {
			InitialSetup.test.log(LogStatus.PASS, "Shipment has been delivered");
			captureAndAddScreenshot();
			click(By.xpath("//button[text()='No']"));
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Shipment hasn't been delivered");
		}
		waitForFrameAndSwitch(FRAME);
		click(By.name("btnClose"));
		return this;
	}

	// Sharath
	public OPR293 checkCustomsStatus() {
		if (driver.findElement(By.xpath("//*[@fill]")).getAttribute("fill").equalsIgnoreCase("#008000")) {
			InitialSetup.test.log(LogStatus.PASS, "Customs has been cleared");
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Customs hasn't been cleared");
		}

		return this;
	}

	/**
	 * Created by A-8457(Souvik) This method generate DN for all pcs. Charge
	 * Collect pop up is expected during DN generation
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param pieces
	 * @param weight
	 * @param dnId
	 * @param deliveryID
	 * @param idType
	 * @param idDetails
	 * @param deliveryGate
	 * @param checkVerifyBeforePaymentCheckbox
	 * @return
	 */
	public OPR293 generateDNForAllPcsWithChargeCollectPopup(String prefix, String awbNo, String customerCode,
			String pieces, String weight, String dnId) {

		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);

		minWait();
		click(By.name("clearingAgent"));
		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		minWait();
		maxWait();
		enterKeys(By.name("pickUpPersonName"), "Test");
		enterKeys(By.name("pickupCompanyName"), "TestCompany");
		click(By.xpath("//div[@id='IDDetails']//img"));
		maxWait();
		selectByText(By.xpath("(//select[@name='customerIDType'])[1]"), "Driving License");
		enterKeys(By.xpath("(//input[@name='customerIDDetailsInfo'])[1]"), "123456");
		enterKeys(By.xpath("(//input[@name='customerIdIssuingState'])[1]"), "US");
		selectByText(By.xpath("(//select[@name='customerPhotoIdVerified'])[1]"), "Yes");
		click(By.xpath("//span[text()='ID Details']/../button"));
		maxWait();
		click(btn_generateId);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		// enterKeys(txt_remarks, "Payment Remarks");
		click(btn_pymntOk);
		minWait();
		click(btn_accept);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		waitForElement(btn_clear);
		minWait();
		String dnID = waitForElement(By.xpath("(//td[@class='iCargoTableDataTd'])[11]")).getText().split("\\[")[0];
		// String delID = getTableCellValue(table_details, 10, 2);
		// delID = delID.split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, dnId, dnID);
		Assert.assertTrue(waitForElement(td_dnDetails).getText().contains(pieces + "/" + weight + "/Paid"));
		return this;
	}

	/**
	 * Created by A-8457 Souvik on 19-6-19 This method will generate Delivery ID
	 * for all shipments with check
	 * 
	 * @param prefix
	 * @param awbNo
	 * @param customerCode
	 * @param dnId
	 * @return
	 */
	public OPR293 generateDeliveryIDForAllPcsWithCheckPayment(String prefix, String awbNo, String customerCode,
			String dnId) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		list(prefix, awbNo);
		waitForElement(tbl_dlvryDtls);
		check(chk_checkAll);
		minWait();
		maxWait();
		enterKeys(By.name("pickUpPersonName"), "Test");
		enterKeys(By.name("pickupCompanyName"), "TestCompany");
		click(By.xpath("//div[@id='IDDetails']//img"));
		maxWait();
		selectByText(By.xpath("(//select[@name='customerIDType'])[1]"), "Driving License");
		enterKeys(By.xpath("(//input[@name='customerIDDetailsInfo'])[1]"), "123456");
		enterKeys(By.xpath("(//input[@name='customerIdIssuingState'])[1]"), "US");
		selectByText(By.xpath("(//select[@name='customerPhotoIdVerified'])[1]"), "Yes");
		click(By.xpath("//span[text()='ID Details']/../button"));
		maxWait();
		click(btn_generateId);
		maxWait();
		driver.switchTo().defaultContent();
		minWait();

		switchToSecondWindow();
		maxWait();
		unCheck(By.xpath("//div/div/h2[contains(text(),'CHECK')]/../.."));
		minWait();
		enterKeys(By.name("paymentModeAttributeValues"), "Wells Fargo");
		enterKeys(By.name("chequeDateAttribute"), "." + Keys.TAB);
		enterKeys(By.id("CSH_Cashiering_Defaults_ChargeCollect_PaymentAttribute"), "123456");
		click(By.xpath("//button[@name='btOK']"));
		minWait();
		click(btn_accept);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		waitForElement(btn_clear);
		minWait();
		String temp_dnId = waitForElement(td_dnDetails).getText().split("\\[")[0];
		PropertyHandler.setPropValue(dataFilePath, dnId, temp_dnId);
		click(btn_clear);
		return this;
	}

}
