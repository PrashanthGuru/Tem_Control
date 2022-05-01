package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CLM003 extends BasePage{

	
	
	public CLM003(WebDriver driver, String testDataFile) {
		super(driver);
		this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver,this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
        initPageElements();
	}
	
	
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "LTE_CSH_CLM.properties");
	public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","Generic.properties");
	public static String filepath;
	public static String FRAME = "iCargoContentFrameCLM003";
	
	WebDriver driver;    
    String testDataFile;
    
    By txt_claimRefNo,
	txt_awbNoPrefix,
	txt_awbNo,
	txt_hawb,
	btn_list,
	btn_clear,
	dropdown_nature,
	txt_station,
	txt_date,
	txt_claimStatus,
	dropdown_moc,
	table_claimDetails,
	lnk_create,
	lnk_modify,
	lnk_delete,
	txt_docSubmitted,
	txt_totalAmount,
	txt_totalCurrency,
	txt_carriersLiability,
	txt_remarks,
	lnk_addAttachments,
	lnk_deleteAttachments,
	txt_claimantCode,
	txt_name,
	txt_addr1,
	txt_addr2,
	txt_country,
	txt_zip,
	txt_telNo,
	txt_email,
	txt_fax,
	txt_routingDestination1,
	txt_routingCarrier1,
	txt_routingDestination2,
	txt_routingCarrier2,
	txt_routingDestination3,
	txt_routingCarrier3,
	txt_commodityCode,
	txt_scc,
	txt_shptDesc,
	txt_dvCarriage,
	txt_stdPcs,
	txt_stdWgt,
	txt_vol,
	txt_chgWt,
	txt_dlvPcs,
	txt_flightDetails,
	txt_shipperCode,
	txt_shipperName,
	txt_cneeCode,
	txt_cneeName,
	txt_awbCharges,
	btn_reopen,
	btn_checksheet,
	btn_currencyConverter,
	btn_transferClaim,
	btn_awbDiscrepancy,
	btn_claimsHistory,
	btn_actionClaim,
	btn_awbDetails,
	btn_cancelClaim,
	btn_save,
	btn_close,
	btn_dialogueYes,
	btn_dialogueNo,
	btn_dialogueOk,
	info_dialogueText,
	info_error,
	info_footerNotification,
	info_warningToast,
	claimDetails_txt_noOfPieces,
	claimDetails_dropdown_reasonCode,
	claimDetails_dropdown_severity,
	claimDetails_txt_weight,
	claimDetails_dropdown_weightUnit,
	claimDetails_txt_volume,
	claimDetails_dropdown_volumeUnit,
	claimDetails_txt_claimAmount,
	claimDetails_txt_currency,
	claimDetails_txt_commodityCode,
	claimDetails_txt_actPortOfDlvry,
	claimDetails_txt_stnResp,
	claimDetails_txt_remarks,
	claimDetails_btn_ok,
	claimDetails_btn_Close,
	claimDetails_lnk_create,
	claimDetails_lnk_delete,
	chkbox_selectTableItem,
	availableClaims_table_availableClaims,
	availableClaims_btn_ok,
	AWBEnquiry_txt_awbPrefix,
	AWBEnquiry_txt_awbNo,
	AWBEnquiry_info_statedPcsAndWgt,
	AWBEnquiry_info_acceptedPcsAndWgt,
	AWBEnquiry_info_deliveredPcsAndWgt,
	AWBEnquiry_info_agentCode,
	AWBEnquiry_btn_close,
	info_footerMultipleError,
	currencyConverter_txt_fromCurrencyCode,
	currencyConverter_txt_fromValue,
	currencyConverter_txt_toCurrencyCode,
	currencyConverter_txt_toValue,
	currencyConverter_btn_convert,
	currencyConverter_btn_close,
	actionClaims_dropdown_action,
	actionClaims_dropdown_reason,
	actionClaims_txt_amount,
	actionClaims_dropdown_currency,
	actionClaims_txt_remark,
	actionClaims_btn_save,
	claimWarnings_btn_continue,
	transfer_option_airlineCode,
	transfer_txt_airlineCode,
	transfer_txt_transferDate,
	transfer_txt_remarks,
	transfer_btn_save,
	transfer_btn_close,
	transfer_option_stationCode,
	transfer_txt_stationCode,
	transfer_option_headQuarters,
	transfer_txt_headQuarters,
	transfer_option_insuranceAgent,
	transfer_txt_insuranceAgent,
	transfer_option_legal,
	transfer_txt_legal,
	addAttachment_lnk_add,
	addAttachment_lnk_delete,
	addAttachment_btn_select,
	addAttachment_txt_remark,
	addAttachment_btn_ok,
	table_attachments,
	txt_attachmentRemarks,
	txt_attachmentStation,
	txt_attachmentPreviewIcon,
	chkbox_selectAttachmentsTableItem,
	claimHistory_lnk_add,
	claimHistory_lnk_delete,
	claimHistory_headerTable,
	claimHistory_table,
	claimHistory_btn_save,
	claimHistory_btn_close,
	captureCheckSheet_dropdown_transaction,
	captureCheckSheet_btn_list,
	captureCheckSheet_btn_close;

	
    
    private void initPageElements(){
    	txt_claimRefNo = MiscUtility.getWebElement(objFilepath,"CLM003_txt_claimRefNo");
    	txt_awbNoPrefix = MiscUtility.getWebElement(objFilepath,"CLM003_txt_awbNoPrefix");
    	txt_awbNo = MiscUtility.getWebElement(objFilepath,"CLM003_txt_awbNo");
    	txt_hawb = MiscUtility.getWebElement(objFilepath,"CLM003_txt_hawb");
    	btn_list = MiscUtility.getWebElement(objFilepath,"CLM003_btn_list");
    	btn_clear = MiscUtility.getWebElement(objFilepath,"CLM003_btn_clear");
    	dropdown_nature = MiscUtility.getWebElement(objFilepath,"CLM003_dropdown_nature");
    	txt_station = MiscUtility.getWebElement(objFilepath,"CLM003_txt_station");
    	txt_date = MiscUtility.getWebElement(objFilepath,"CLM003_txt_date");
    	txt_claimStatus = MiscUtility.getWebElement(objFilepath,"CLM003_txt_claimStatus");
    	dropdown_moc = MiscUtility.getWebElement(objFilepath,"CLM003_dropdown_moc");
    	table_claimDetails = MiscUtility.getWebElement(objFilepath,"CLM003_table_claimDetails");
    	lnk_create = MiscUtility.getWebElement(objFilepath,"CLM003_lnk_create");
    	lnk_modify = MiscUtility.getWebElement(objFilepath,"CLM003_lnk_modify");
    	lnk_delete = MiscUtility.getWebElement(objFilepath,"CLM003_lnk_delete");
    	txt_docSubmitted = MiscUtility.getWebElement(objFilepath,"CLM003_txt_docSubmitted");
    	txt_totalAmount = MiscUtility.getWebElement(objFilepath,"CLM003_txt_totalAmount");
    	txt_totalCurrency = MiscUtility.getWebElement(objFilepath,"CLM003_txt_totalCurrency");
    	txt_carriersLiability = MiscUtility.getWebElement(objFilepath,"CLM003_txt_carriersLiability");
    	txt_remarks = MiscUtility.getWebElement(objFilepath,"CLM003_txt_remarks");
    	lnk_addAttachments = MiscUtility.getWebElement(objFilepath,"CLM003_lnk_addAttachments");
    	lnk_deleteAttachments = MiscUtility.getWebElement(objFilepath,"CLM003_lnk_deleteAttachments");
    	txt_claimantCode = MiscUtility.getWebElement(objFilepath,"CLM003_txt_claimantCode");
    	txt_name = MiscUtility.getWebElement(objFilepath,"CLM003_txt_name");
    	txt_addr1 = MiscUtility.getWebElement(objFilepath,"CLM003_txt_addr1");
    	txt_addr2 = MiscUtility.getWebElement(objFilepath,"CLM003_txt_addr2");
    	txt_country = MiscUtility.getWebElement(objFilepath,"CLM003_txt_country");
    	txt_zip = MiscUtility.getWebElement(objFilepath,"CLM003_txt_zip");
    	txt_telNo = MiscUtility.getWebElement(objFilepath,"CLM003_txt_telNo");
    	txt_email = MiscUtility.getWebElement(objFilepath,"CLM003_txt_email");
    	txt_fax = MiscUtility.getWebElement(objFilepath,"CLM003_txt_fax");
    	txt_routingDestination1 = MiscUtility.getWebElement(objFilepath,"CLM003_txt_routingDestination1");
    	txt_routingCarrier1 = MiscUtility.getWebElement(objFilepath,"CLM003_txt_routingCarrier1");
    	txt_routingDestination2 = MiscUtility.getWebElement(objFilepath,"CLM003_txt_routingDestination2");
    	txt_routingCarrier2 = MiscUtility.getWebElement(objFilepath,"CLM003_txt_routingCarrier2");
    	txt_routingDestination3 = MiscUtility.getWebElement(objFilepath,"CLM003_txt_routingDestination3");
    	txt_routingCarrier3 = MiscUtility.getWebElement(objFilepath,"CLM003_txt_routingCarrier3");
    	txt_commodityCode = MiscUtility.getWebElement(objFilepath,"CLM003_txt_commodityCode");
    	txt_scc = MiscUtility.getWebElement(objFilepath,"CLM003_txt_scc");
    	txt_shptDesc = MiscUtility.getWebElement(objFilepath,"CLM003_txt_shptDesc");
    	txt_dvCarriage = MiscUtility.getWebElement(objFilepath,"CLM003_txt_dvCarriage");
    	txt_stdPcs = MiscUtility.getWebElement(objFilepath,"CLM003_txt_stdPcs");
    	txt_stdWgt = MiscUtility.getWebElement(objFilepath,"CLM003_txt_stdWgt");
    	txt_vol = MiscUtility.getWebElement(objFilepath,"CLM003_txt_vol");
    	txt_chgWt = MiscUtility.getWebElement(objFilepath,"CLM003_txt_chgWt");
    	txt_dlvPcs = MiscUtility.getWebElement(objFilepath,"CLM003_txt_dlvPcs");
    	txt_flightDetails = MiscUtility.getWebElement(objFilepath,"CLM003_txt_flightDetails");
    	txt_shipperCode = MiscUtility.getWebElement(objFilepath,"CLM003_txt_shipperCode");
    	txt_shipperName = MiscUtility.getWebElement(objFilepath,"CLM003_txt_shipperName");
    	txt_cneeCode = MiscUtility.getWebElement(objFilepath,"CLM003_txt_cneeCode");
    	txt_cneeName = MiscUtility.getWebElement(objFilepath,"CLM003_txt_cneeName");
    	txt_awbCharges = MiscUtility.getWebElement(objFilepath,"CLM003_txt_awbCharges");
    	btn_reopen = MiscUtility.getWebElement(objFilepath,"CLM003_btn_reopen");
    	btn_checksheet = MiscUtility.getWebElement(objFilepath,"CLM003_btn_checksheet");
    	btn_currencyConverter = MiscUtility.getWebElement(objFilepath,"CLM003_btn_currencyConverter");
    	btn_transferClaim = MiscUtility.getWebElement(objFilepath,"CLM003_btn_transferClaim");
    	btn_awbDiscrepancy = MiscUtility.getWebElement(objFilepath,"CLM003_btn_awbDiscrepancy");
    	btn_claimsHistory = MiscUtility.getWebElement(objFilepath,"CLM003_btn_claimsHistory");
    	btn_actionClaim = MiscUtility.getWebElement(objFilepath,"CLM003_btn_actionClaim");
    	btn_awbDetails = MiscUtility.getWebElement(objFilepath,"CLM003_btn_awbDetails");
    	btn_cancelClaim = MiscUtility.getWebElement(objFilepath,"CLM003_btn_cancelClaim");
    	btn_save = MiscUtility.getWebElement(objFilepath,"CLM003_btn_save");
    	btn_close = MiscUtility.getWebElement(objFilepath,"CLM003_btn_close");
    	claimDetails_txt_noOfPieces = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_txt_noOfPieces");
    	claimDetails_dropdown_reasonCode = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_dropdown_reasonCode");
    	claimDetails_dropdown_severity = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_dropdown_severity");
    	claimDetails_txt_weight = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_txt_weight");
    	claimDetails_dropdown_weightUnit = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_dropdown_weightUnit");
    	claimDetails_txt_volume = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_txt_volume");
    	claimDetails_dropdown_volumeUnit = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_dropdown_volumeUnit");
    	claimDetails_txt_claimAmount = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_txt_claimAmount");
    	claimDetails_txt_currency = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_txt_currency");
    	claimDetails_txt_commodityCode = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_txt_commodityCode");
    	claimDetails_txt_actPortOfDlvry = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_txt_actPortOfDlvry");
    	claimDetails_txt_stnResp = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_txt_stnResp");
    	claimDetails_txt_remarks = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_txt_remarks");
    	claimDetails_btn_ok = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_btn_ok");
    	claimDetails_btn_Close = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_btn_Close");
    	claimDetails_lnk_create = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_lnk_create");
    	claimDetails_lnk_delete = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimDetails_lnk_delete");
    	chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath,"CLM003_chkbox_selectTableItem");
    	availableClaims_table_availableClaims = MiscUtility.getWebElement(objFilepath,"CLM003_AvailableClaims_table_availableClaims");
    	availableClaims_btn_ok = MiscUtility.getWebElement(objFilepath,"CLM003_AvailableClaims_btn_ok");
    	AWBEnquiry_txt_awbPrefix = MiscUtility.getWebElement(objFilepath,"CLM003_AWBEnquiry_txt_awbPrefix");
    	AWBEnquiry_txt_awbNo = MiscUtility.getWebElement(objFilepath,"CLM003_AWBEnquiry_txt_awbNo");
    	AWBEnquiry_info_statedPcsAndWgt = MiscUtility.getWebElement(objFilepath,"CLM003_AWBEnquiry_info_statedPcsAndWgt");
    	AWBEnquiry_info_acceptedPcsAndWgt = MiscUtility.getWebElement(objFilepath,"CLM003_AWBEnquiry_info_acceptedPcsAndWgt");
    	AWBEnquiry_info_deliveredPcsAndWgt = MiscUtility.getWebElement(objFilepath,"CLM003_AWBEnquiry_info_deliveredPcsAndWgt");
    	AWBEnquiry_info_agentCode = MiscUtility.getWebElement(objFilepath,"CLM003_AWBEnquiry_info_agentCode");
    	AWBEnquiry_btn_close = MiscUtility.getWebElement(objFilepath,"CLM003_AWBEnquiry_btn_close");
    	info_footerMultipleError = MiscUtility.getWebElement(objFilepath,"CLM003_info_footerError");
    	currencyConverter_txt_fromCurrencyCode = MiscUtility.getWebElement(objFilepath,"CLM003_CurrencyConverter_txt_fromCurrencyCode");
    	currencyConverter_txt_fromValue = MiscUtility.getWebElement(objFilepath,"CLM003_CurrencyConverter_txt_fromValue");
    	currencyConverter_txt_toCurrencyCode = MiscUtility.getWebElement(objFilepath,"CLM003_CurrencyConverter_txt_toCurrencyCode");
    	currencyConverter_txt_toValue = MiscUtility.getWebElement(objFilepath,"CLM003_CurrencyConverter_txt_toValue");
    	currencyConverter_btn_convert = MiscUtility.getWebElement(objFilepath,"CLM003_CurrencyConverter_btn_convert");
    	currencyConverter_btn_close = MiscUtility.getWebElement(objFilepath,"CLM003_CurrencyConverter_btn_close");
    	actionClaims_dropdown_action = MiscUtility.getWebElement(objFilepath,"CLM003_ActionClaims_dropdown_action");
    	actionClaims_dropdown_reason = MiscUtility.getWebElement(objFilepath,"CLM003_ActionClaims_dropdown_reason");
    	actionClaims_txt_amount = MiscUtility.getWebElement(objFilepath,"CLM003_ActionClaims_txt_amount");
    	actionClaims_dropdown_currency = MiscUtility.getWebElement(objFilepath,"CLM003_ActionClaims_dropdown_currency");
    	actionClaims_txt_remark = MiscUtility.getWebElement(objFilepath,"CLM003_ActionClaims_txt_remark");
    	actionClaims_btn_save = MiscUtility.getWebElement(objFilepath,"CLM003_ActionClaims_btn_save");
    	claimWarnings_btn_continue = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimWarnings_btn_continue");
    	transfer_option_airlineCode = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_option_airlineCode");
    	transfer_txt_airlineCode = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_txt_airlineCode");
    	transfer_txt_transferDate = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_txt_transferDate");
    	transfer_txt_remarks = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_txt_remarks");
    	transfer_btn_save = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_btn_save");
    	transfer_btn_close = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_btn_close");
    	transfer_option_stationCode = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_option_stationCode");
    	transfer_txt_stationCode = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_txt_stationCode");
    	transfer_option_headQuarters = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_option_headQuarters");
    	transfer_txt_headQuarters = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_txt_headQuarters");
    	transfer_option_insuranceAgent = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_option_insuranceAgent");
    	transfer_txt_insuranceAgent = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_txt_insuranceAgent");
    	transfer_option_legal = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_option_legal");
    	transfer_txt_legal = MiscUtility.getWebElement(objFilepath,"CLM003_Transfer_txt_legal");
    	addAttachment_lnk_add = MiscUtility.getWebElement(objFilepath,"CLM003_AddAttachment_lnk_add");
    	addAttachment_lnk_delete = MiscUtility.getWebElement(objFilepath,"CLM003_AddAttachment_lnk_delete");
    	addAttachment_btn_select = MiscUtility.getWebElement(objFilepath,"CLM003_AddAttachment_btn_select");
    	addAttachment_txt_remark = MiscUtility.getWebElement(objFilepath,"CLM003_AddAttachment_txt_remark");
    	addAttachment_btn_ok = MiscUtility.getWebElement(objFilepath,"CLM003_AddAttachment_btn_ok");
    	table_attachments = MiscUtility.getWebElement(objFilepath,"CLM003_table_attachments");
    	txt_attachmentRemarks = MiscUtility.getWebElement(objFilepath,"CLM003_txt_attachmentRemarks");
    	txt_attachmentStation = MiscUtility.getWebElement(objFilepath,"CLM003_txt_attachmentStation");
    	txt_attachmentPreviewIcon = MiscUtility.getWebElement(objFilepath,"CLM003_txt_attachmentPreviewIcon");
    	chkbox_selectAttachmentsTableItem = MiscUtility.getWebElement(objFilepath,"CLM003_chkbox_selectAttachmentsTableItem");
    	claimHistory_lnk_add = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimHistory_lnk_add");
    	claimHistory_lnk_delete = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimHistory_lnk_delete");
    	claimHistory_headerTable = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimHistory_headerTable");
    	claimHistory_table = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimHistory_table");
    	claimHistory_btn_save = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimHistory_btn_save");
    	claimHistory_btn_close = MiscUtility.getWebElement(objFilepath,"CLM003_ClaimHistory_btn_close");
    	captureCheckSheet_dropdown_transaction = MiscUtility.getWebElement(objFilepath,"CLM003_CaptureCheckSheet_dropdown_transaction");
    	captureCheckSheet_btn_list = MiscUtility.getWebElement(objFilepath,"CLM003_CaptureCheckSheet_btn_list");
    	captureCheckSheet_btn_close = MiscUtility.getWebElement(objFilepath,"CLM003_CaptureCheckSheet_btn_close");
    	
    	btn_dialogueYes = MiscUtility.getWebElement(genFilepath,"Generic_btn_diaYes");
    	btn_dialogueNo = MiscUtility.getWebElement(genFilepath,"Generic_btn_noBtn");
    	btn_dialogueOk = MiscUtility.getWebElement(genFilepath,"Generic_btn_ok");
    	info_dialogueText = MiscUtility.getWebElement(genFilepath,"Generic_info_msg");
    	info_error = MiscUtility.getWebElement(genFilepath,"Generic_footer_error");
    	info_footerNotification = MiscUtility.getWebElement(genFilepath,"Generic_foot_layer");
    	info_warningToast = MiscUtility.getWebElement(genFilepath,"Info_warningToast");
    }
    
    /**
     * Created by A-7605 on 16-2-18
     * This method closes the current page and return to home page
     * @return
     */
    public HomePage close(){
    	click(btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_dialogueYes))
    		click(btn_dialogueYes);
    	return new HomePage(driver, testDataFile);
    }
    
    /**
     * Created by A-7605 on 16-2-18
     * This method verifies Reopen, Checksheet, Close and Save buttons are enabled at page load and other buttons are disabled
     * @return
     */
    public CLM003 verifyButtonsAreDisabledWhenPageLoad(){
    	minWait();
    	Assert.assertNull(waitForElement(btn_reopen).getAttribute("disabled"));
    	Assert.assertNull(waitForElement(btn_checksheet).getAttribute("disabled"));
    	Assert.assertNull(waitForElement(btn_close).getAttribute("disabled"));
    	Assert.assertNull(waitForElement(btn_save).getAttribute("disabled"));
    	Assert.assertNotNull(waitForElementVisible(btn_currencyConverter).getAttribute("disabled"));
    	Assert.assertNotNull(waitForElementVisible(btn_transferClaim).getAttribute("disabled"));
    	Assert.assertNotNull(waitForElementVisible(btn_awbDiscrepancy).getAttribute("disabled"));
    	Assert.assertNotNull(waitForElementVisible(btn_claimsHistory).getAttribute("disabled"));
    	Assert.assertNotNull(waitForElementVisible(btn_actionClaim).getAttribute("disabled"));
    	Assert.assertNotNull(waitForElementVisible(btn_awbDetails).getAttribute("disabled"));
    	Assert.assertNotNull(waitForElementVisible(btn_cancelClaim).getAttribute("disabled"));
    	return this;
    }
    
    /**
     * Created by A-7605 on 19-2-18
     * This method check the Yes and No buttons functionality, which is showing on listing the awb
     * @param awbPrefix
     * @param awbNo
     * @param nature
     * @param walkinCustomerCode
     * @param loggedInStation
     * @return
     */
    public CLM003 checkFunctionalityOfListingAWB(String awbPrefix, String awbNo, String nature, String walkinCustomerCode, String loggedInStation){
    	awbPrefix = PropertyHandler.getPropValue(filepath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	walkinCustomerCode = PropertyHandler.getPropValue(filepath, walkinCustomerCode);
    	loggedInStation = PropertyHandler.getPropValue(filepath, loggedInStation);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	
    	enterKeys(waitForElement(txt_awbNoPrefix), awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_list);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Do you want to register a new claim?");
    	click(btn_dialogueNo);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElement(txt_awbNoPrefix).getAttribute("value"), awbPrefix);
    	Assert.assertEquals(waitForElement(txt_awbNo).getAttribute("value"), awbNo);
    	waitForElementNotPresent(info_warningToast);
    	click(btn_list);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Do you want to register a new claim?");
    	click(btn_dialogueYes);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	selectByText(waitForElement(dropdown_nature), nature);
    	String date = waitForElement(txt_date).getAttribute("value");
    	enterKeys(txt_date, ".");
    	enterKeys(txt_date, Keys.TAB);
    	Assert.assertEquals(getSelectedValue(dropdown_nature), nature);
    	Assert.assertEquals(waitForElement(txt_date).getAttribute("value"), date);
    	Assert.assertEquals(waitForElement(txt_claimantCode).getAttribute("value"), walkinCustomerCode);
    	Assert.assertEquals(waitForElement(txt_station).getAttribute("value"), loggedInStation);
    	return this;
    }
    
    /**
     * Created by A-7605 on 19-2-18
     * This method list AWB for which claim has not been created yet
     * @param awbPrefix
     * @param awbNo
     * @param nature
     */
    private void list(String awbPrefix, String awbNo, String nature){
    	enterKeys(waitForElement(txt_awbNoPrefix), awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_list);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Do you want to register a new claim?");
    	click(btn_dialogueYes);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	selectByText(dropdown_nature, nature);
    }
    
    /**
     * Created by A-7605 on 21-2-18
     * This method list already created claim and the listing will be based on AWB No
     * @param awbPrefix
     * @param awbNo
     * @param claimRefNo
     */
    private void listClaim(String awbPrefix, String awbNo, String claimRefNo){
    	enterKeys(waitForElement(txt_awbNoPrefix), awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_list);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	tblSelectRowByColValue(availableClaims_table_availableClaims, 1, 2, claimRefNo);
    	click(availableClaims_btn_ok);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    }
    
    /**
     * Created by A-7605 on 19-2-18
     * This method list HAWB for which claim has not been created yet
     * @param awbPrefix
     * @param awbNo
     * @param nature
     * @param houseAWBNo
     */
    private void listWithHouse(String awbPrefix, String awbNo, String nature, String houseAWBNo){
    	enterKeys(waitForElement(txt_awbNoPrefix), awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	enterKeys(txt_hawb, houseAWBNo);
    	click(btn_list);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Do you want to register a new claim?");
    	click(btn_dialogueYes);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	selectByText(dropdown_nature, nature);
    }
    
    /**
     * Created by A-7605 on 19-2-18
     * This method relist claim in terms of AWB
     * @param awbPrefix
     * @param awbNo
     */
    private void reList(String awbPrefix, String awbNo){
    	enterKeys(waitForElement(txt_awbNoPrefix), awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_list);
    	minWait();
    	return;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This check if all buttons in the screen are active on listing with an AWB
     * @param awbPrefix
     * @param awbNo
     * @return
     */
    public CLM003 verifyAllButtonsInScreenAreActiveOnListingAWB(String awbPrefix, String awbNo){
    	awbPrefix = PropertyHandler.getPropValue(filepath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	enterKeys(waitForElement(txt_awbNoPrefix), awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_list);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Do you want to register a new claim?");
    	click(btn_dialogueYes);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertNull(waitForElementVisible(btn_reopen).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_checksheet).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_close).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_save).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_currencyConverter).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_transferClaim).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_awbDiscrepancy).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_claimsHistory).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_actionClaim).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_awbDetails).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_cancelClaim).getAttribute("disabled"));
    	return this;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method verify if all buttons in the screen are active on listing wih HAWB
     * @param awbPrefix
     * @param awbNo
     * @param house
     * @return
     */
    public CLM003 verifyAllButtonsInScreenAreActiveOnListingHAWB(String awbPrefix, String awbNo, String house){
    	awbPrefix = PropertyHandler.getPropValue(filepath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	house = PropertyHandler.getPropValue(filepath, house);
    	enterKeys(waitForElement(txt_awbNoPrefix), awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	enterKeys(txt_hawb, house);
    	click(btn_list);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Do you want to register a new claim?");
    	click(btn_dialogueYes);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertNull(waitForElementVisible(btn_reopen).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_checksheet).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_close).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_save).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_currencyConverter).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_transferClaim).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_awbDiscrepancy).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_claimsHistory).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_actionClaim).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_awbDetails).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_cancelClaim).getAttribute("disabled"));
    	return this;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method click on clear button and check if AWB fields are clered
     * @return
     */
    public CLM003 clear(){
    	click(btn_clear);
    	verifyFieldsAreCleared();
    	return this;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method verify if awb no and awb prefix fields are cleared
     */
    private void verifyFieldsAreCleared(){
    	Assert.assertEquals(waitForElement(txt_awbNoPrefix).getAttribute("value").trim().length(), 0);
    	Assert.assertEquals(waitForElement(txt_awbNo).getAttribute("value").trim().length(), 0);
    }
	
    /**
     * Created by A-7605 on 20-2-18
     * This method create a new claim, provided AWB is already listed
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     */
    private void createClaimDetails(String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp, String remarks){
    	click(lnk_create);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(claimDetails_txt_noOfPieces), pieces);
    	if (reasonCode != null && reasonCode.trim().length()>0)
    		selectByText(claimDetails_dropdown_reasonCode, reasonCode);
    	if (severity != null && severity.trim().length()>0)
    		selectByText(claimDetails_dropdown_severity, severity);
    	enterKeys(waitForElement(claimDetails_txt_weight), weight);
    	if (weightUnit != null && weightUnit.trim().length()>0)
    		selectByText(claimDetails_dropdown_weightUnit, weightUnit);
    	enterKeys(claimDetails_txt_volume, volume);
    	if (volumeUnit != null && volumeUnit.trim().length()>0)
    		selectByText(claimDetails_dropdown_volumeUnit, volumeUnit);
    	enterKeys(claimDetails_txt_claimAmount, claimAmount);
    	enterKeys(claimDetails_txt_currency, currency);
    	enterKeys(claimDetails_txt_commodityCode, commodityCode);
    	if (actPortDlvry != null && actPortDlvry.trim().length()>0)
    		enterKeys(claimDetails_txt_actPortOfDlvry, actPortDlvry);
    	if (stnResp != null && stnResp.trim().length()>0)
    		enterKeys(claimDetails_txt_stnResp, stnResp);
    	if (remarks != null && remarks.trim().length()>0)
    		enterKeys(claimDetails_txt_remarks, remarks);
    	click(claimDetails_btn_ok);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	verifyDataInClaimDetailsTable(1,pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method verify if all values in the claim details table are correct
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     */
    private void verifyDataInClaimDetailsTable(int rowNumber,String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp, String remarks){
    	
    	Assert.assertEquals(getTableCellValue(table_claimDetails, 2, rowNumber), pieces);
    	Assert.assertEquals(getTableCellValue(table_claimDetails, 3, rowNumber), reasonCode);
    	if(severity != null && severity.trim().length()>0)
    		Assert.assertEquals(getTableCellValue(table_claimDetails, 4, rowNumber), severity);
    	Assert.assertEquals(getTableCellValue(table_claimDetails, 5, rowNumber), weight);
//    	if(weightUnit != null && weightUnit.trim().length()>0)
//    		Assert.assertEquals(getTableCellValue(table_claimDetails, 6, rowNumber), weightUnit);
    	if(volume != null && volume.trim().length()>0)
    		Assert.assertEquals(getTableCellValue(table_claimDetails, 7, rowNumber), volume);
//    	if(volumeUnit != null && volumeUnit.trim().length()>0)
//    		Assert.assertEquals(getTableCellValue(table_claimDetails, 8, rowNumber), volumeUnit);
    	Assert.assertEquals(getTableCellValue(table_claimDetails, 9, rowNumber), commodityCode);
//    	Assert.assertEquals(getTableCellValue(table_claimDetails, 10, 1), claimAmount);
    	Assert.assertEquals(getTableCellValue(table_claimDetails, 11, rowNumber), currency);
    	if(actPortDlvry != null && actPortDlvry.trim().length()>0)
    		Assert.assertEquals(getTableCellValue(table_claimDetails, 12, rowNumber), actPortDlvry);
    	if(stnResp != null && stnResp.trim().length()>0)
    		Assert.assertEquals(getTableCellValue(table_claimDetails, 13, rowNumber), stnResp);
    	if(remarks != null && remarks.trim().length()>0)
    		Assert.assertEquals(getTableCellValue(table_claimDetails, 15, rowNumber), remarks);
    	
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method fill the claimant details provided awb already listed
     * @param claimantCode
     * @param name
     * @param addr1
     * @param addr2
     * @param country
     * @param zip
     * @param telNo
     * @param email
     * @param fax
     */
    private void fillClaimantDetails(String claimantCode, String name, String addr1, String addr2, String country, String zip,
    		String telNo, String email, String fax){
    	if(claimantCode != null && claimantCode.trim().length()>0){
    		enterKeys(txt_claimantCode, claimantCode);
    		enterKeys(txt_claimantCode, Keys.TAB);
    	}
    	if(name != null && name.trim().length()>0)
    		enterKeys(txt_name, name);
    	if(addr1 != null && addr1.trim().length()>0)
    		enterKeys(txt_addr1, addr1);
    	if(addr2 != null && addr2.trim().length()>0)
    		enterKeys(txt_addr2, addr2);
    	if(country != null && country.trim().length()>0)
    		enterKeys(txt_country, country);
    	if(zip != null && zip.trim().length()>0)
    		enterKeys(txt_zip, zip);
    	if(telNo != null && telNo.trim().length()>0)
    		enterKeys(txt_telNo, telNo);
    	if(email != null && email.trim().length()>0)
    		enterKeys(txt_email, email);
    	if(fax != null && fax.trim().length()>0)
    		enterKeys(txt_fax, fax);
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method save a new claim details
     * @param nature
     * @param awbNoPrefix
     * @param awbNo
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     * @param claimantCode
     * @param name
     * @param addr1
     * @param addr2
     * @param country
     * @param zip
     * @param telNo
     * @param email
     * @param fax
     * @param claimRefNo
     * @return
     */
    public CLM003 saveClaimDetails(String nature, String awbNoPrefix, String awbNo, String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp,String remarks,String claimantCode,String name, String addr1, String addr2, String country, String zip, String telNo,
    		String email, String fax, String claimRefNo){
    	
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	pieces = PropertyHandler.getPropValue(filepath, pieces);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	weight = PropertyHandler.getPropValue(filepath, weight);
    	weightUnit = PropertyHandler.getPropValue(filepath, weightUnit);
    	volume = PropertyHandler.getPropValue(filepath, volume);
    	volumeUnit = PropertyHandler.getPropValue(filepath, volumeUnit);
    	claimAmount = PropertyHandler.getPropValue(filepath, claimAmount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	commodityCode = PropertyHandler.getPropValue(filepath, commodityCode);
    	actPortDlvry = PropertyHandler.getPropValue(filepath, actPortDlvry);
    	stnResp = PropertyHandler.getPropValue(filepath, stnResp);
    	claimantCode = PropertyHandler.getPropValue(filepath, claimantCode);
    	name = PropertyHandler.getPropValue(filepath, name);
    	addr1 = PropertyHandler.getPropValue(filepath, addr1);
    	addr2 = PropertyHandler.getPropValue(filepath, addr2);
    	country = PropertyHandler.getPropValue(filepath, country);
    	zip = PropertyHandler.getPropValue(filepath, zip);
    	telNo = PropertyHandler.getPropValue(filepath, telNo);
    	email = PropertyHandler.getPropValue(filepath, email);
    	fax = PropertyHandler.getPropValue(filepath, fax);
    	remarks = PropertyHandler.getPropValue(filepath, remarks);
    	
    	list(awbNoPrefix, awbNo,nature);
    	createClaimDetails(pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	fillClaimantDetails(claimantCode, name, addr1, addr2, country, zip, telNo, email, fax);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	String dialogueText = waitForElement(info_dialogueText).getText();
    	if(!nature.equals("Intent") && !nature.equals("Claim")){
//    		Assert.assertEquals(dialogueText, "Do you want to create a claim directly without intent?");
    		click(btn_dialogueYes);
    		minWait();
    	}if (nature.equals("Claim")){
    	
    		Assert.assertEquals(dialogueText, "Claim raised directly without intent.Also the claimed amount is greater than insurace amount.Do you want to capture the claim as insurance claim without raising intent?");
    		click(btn_dialogueYes);
    		minWait();
    	}		
    	dialogueText = waitForElement(info_dialogueText).getText();
    	if(dialogueText.contains("The claimed volume is greater than the stated volume")){
    		click(btn_dialogueYes);
    		minWait();
    		dialogueText = waitForElement(info_dialogueText).getText();
    	}    		
    	String claimRefNumber = dialogueText.split("\\s+")[6];
    	claimRefNumber = claimRefNumber.substring(0,claimRefNumber.length()-1);
    	Assert.assertEquals(dialogueText, "Claim registered successfully with ref no "+claimRefNumber+". Do you wish to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	claimRefNumber = claimRefNumber.replaceAll(",", "");
    	PropertyHandler.setPropValue(filepath, claimRefNo, claimRefNumber);
    	verifyDataInClaimDetailsTable(1,pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	return this;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method save a new claim details but wont relist after save
     * @param nature
     * @param awbNoPrefix
     * @param awbNo
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     * @param claimantCode
     * @param name
     * @param addr1
     * @param addr2
     * @param country
     * @param zip
     * @param telNo
     * @param email
     * @param fax
     * @param claimRefNo
     * @return
     */
    public CLM003 saveClaimDetails_NoRelist(String nature,String awbNoPrefix, String awbNo, String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp,String remarks,String claimantCode,String name, String addr1, String addr2, String country, String zip, String telNo,
    		String email, String fax, String claimRefNo){
    	
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	pieces = PropertyHandler.getPropValue(filepath, pieces);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	weight = PropertyHandler.getPropValue(filepath, weight);
    	weightUnit = PropertyHandler.getPropValue(filepath, weightUnit);
    	volume = PropertyHandler.getPropValue(filepath, volume);
    	volumeUnit = PropertyHandler.getPropValue(filepath, volumeUnit);
    	claimAmount = PropertyHandler.getPropValue(filepath, claimAmount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	commodityCode = PropertyHandler.getPropValue(filepath, commodityCode);
    	actPortDlvry = PropertyHandler.getPropValue(filepath, actPortDlvry);
    	stnResp = PropertyHandler.getPropValue(filepath, stnResp);
    	claimantCode = PropertyHandler.getPropValue(filepath, claimantCode);
    	name = PropertyHandler.getPropValue(filepath, name);
    	addr1 = PropertyHandler.getPropValue(filepath, addr1);
    	addr2 = PropertyHandler.getPropValue(filepath, addr2);
    	country = PropertyHandler.getPropValue(filepath, country);
    	zip = PropertyHandler.getPropValue(filepath, zip);
    	telNo = PropertyHandler.getPropValue(filepath, telNo);
    	email = PropertyHandler.getPropValue(filepath, email);
    	fax = PropertyHandler.getPropValue(filepath, fax);
    	remarks = PropertyHandler.getPropValue(filepath, remarks);
    	
    	list(awbNoPrefix, awbNo,nature);
    	createClaimDetails(pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	fillClaimantDetails(claimantCode, name, addr1, addr2, country, zip, telNo, email, fax);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	String dialogueText = waitForElement(info_dialogueText).getText();
    	String claimRefNumber = dialogueText.split(" ")[6];
    	claimRefNumber = claimRefNumber.substring(0,claimRefNumber.length()-1);
    	Assert.assertEquals(dialogueText, "Claim registered successfully with ref no "+claimRefNumber+". Do you wish to list the saved details?");
    	click(btn_dialogueNo);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	PropertyHandler.setPropValue(filepath, claimRefNo, claimRefNumber);
    	verifyFieldsAreCleared();
    	return this;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method verify the functionality of yes and no button shown on list with HAWB for which claim has not been created yet
     * @param awbPrefix
     * @param awbNo
     * @param house
     * @param nature
     * @param walkinCustomerCode
     * @param loggedInStation
     * @return
     */
    public CLM003 checkFunctionalityOfListingHouse(String awbPrefix, String awbNo,String house, String nature, String walkinCustomerCode, String loggedInStation){
    	awbPrefix = PropertyHandler.getPropValue(filepath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	walkinCustomerCode = PropertyHandler.getPropValue(filepath, walkinCustomerCode);
    	loggedInStation = PropertyHandler.getPropValue(filepath, loggedInStation);
    	house = PropertyHandler.getPropValue(filepath, house);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	
    	enterKeys(waitForElement(txt_awbNoPrefix), awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	enterKeys(txt_hawb, house);
    	click(btn_list);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Do you want to register a new claim?");
    	click(btn_dialogueNo);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElement(txt_awbNoPrefix).getAttribute("value"), awbPrefix);
    	Assert.assertEquals(waitForElement(txt_awbNo).getAttribute("value"), awbNo);
    	waitForElementNotPresent(info_warningToast);
    	click(btn_list);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Do you want to register a new claim?");
    	click(btn_dialogueYes);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	selectByText(waitForElement(dropdown_nature), nature);
    	String date = waitForElement(txt_date).getAttribute("value");
    	enterKeys(txt_date, ".");
    	enterKeys(txt_date, Keys.TAB);
    	Assert.assertEquals(getSelectedValue(dropdown_nature), nature);
    	Assert.assertEquals(waitForElement(txt_date).getAttribute("value"), date);
    	Assert.assertEquals(waitForElement(txt_claimantCode).getAttribute("value"), walkinCustomerCode);
    	Assert.assertEquals(waitForElement(txt_station).getAttribute("value"), loggedInStation);
    	return this;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method save claim details for awb containing house
     * @param nature
     * @param awbNoPrefix
     * @param awbNo
     * @param hawbNo
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     * @param claimantCode
     * @param name
     * @param addr1
     * @param addr2
     * @param country
     * @param zip
     * @param telNo
     * @param email
     * @param fax
     * @param claimRefNo
     * @return
     */
    public CLM003 saveClaimDetailsWithHouse(String nature, String awbNoPrefix, String awbNo,String hawbNo, String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp,String remarks,String claimantCode,String name, String addr1, String addr2, String country, String zip, String telNo,
    		String email, String fax, String claimRefNo){
    	
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	pieces = PropertyHandler.getPropValue(filepath, pieces);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	weight = PropertyHandler.getPropValue(filepath, weight);
    	weightUnit = PropertyHandler.getPropValue(filepath, weightUnit);
    	volume = PropertyHandler.getPropValue(filepath, volume);
    	volumeUnit = PropertyHandler.getPropValue(filepath, volumeUnit);
    	claimAmount = PropertyHandler.getPropValue(filepath, claimAmount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	commodityCode = PropertyHandler.getPropValue(filepath, commodityCode);
    	actPortDlvry = PropertyHandler.getPropValue(filepath, actPortDlvry);
    	stnResp = PropertyHandler.getPropValue(filepath, stnResp);
    	claimantCode = PropertyHandler.getPropValue(filepath, claimantCode);
    	name = PropertyHandler.getPropValue(filepath, name);
    	addr1 = PropertyHandler.getPropValue(filepath, addr1);
    	addr2 = PropertyHandler.getPropValue(filepath, addr2);
    	country = PropertyHandler.getPropValue(filepath, country);
    	zip = PropertyHandler.getPropValue(filepath, zip);
    	telNo = PropertyHandler.getPropValue(filepath, telNo);
    	email = PropertyHandler.getPropValue(filepath, email);
    	fax = PropertyHandler.getPropValue(filepath, fax);
    	hawbNo = PropertyHandler.getPropValue(filepath, hawbNo);
    	remarks = PropertyHandler.getPropValue(filepath, remarks);
    	
    	listWithHouse(awbNoPrefix, awbNo, nature, hawbNo);
    	createClaimDetails(pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	fillClaimantDetails(claimantCode, name, addr1, addr2, country, zip, telNo, email, fax);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	String dialogueText = waitForElement(info_dialogueText).getText();
    	String claimRefNumber = dialogueText.split(" ")[6];
    	claimRefNumber = claimRefNumber.substring(0,claimRefNumber.length()-1);
    	Assert.assertEquals(dialogueText, "Claim registered successfully with ref no "+claimRefNumber+". Do you wish to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	PropertyHandler.setPropValue(filepath, claimRefNo, claimRefNumber);
    	verifyDataInClaimDetailsTable(1,pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	return this;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method save claim details for awb containing house, but not relist after save
     * @param nature
     * @param awbNoPrefix
     * @param awbNo
     * @param hawbNo
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     * @param claimantCode
     * @param name
     * @param addr1
     * @param addr2
     * @param country
     * @param zip
     * @param telNo
     * @param email
     * @param fax
     * @param claimRefNo
     * @return
     */
    public CLM003 saveClaimDetailsWithHouse_NoRelist(String nature,String awbNoPrefix, String awbNo, String hawbNo, String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp,String remarks, String claimantCode,String name, String addr1, String addr2, String country, String zip, String telNo,
    		String email, String fax, String claimRefNo){
    	
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	pieces = PropertyHandler.getPropValue(filepath, pieces);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	weight = PropertyHandler.getPropValue(filepath, weight);
    	weightUnit = PropertyHandler.getPropValue(filepath, weightUnit);
    	volume = PropertyHandler.getPropValue(filepath, volume);
    	volumeUnit = PropertyHandler.getPropValue(filepath, volumeUnit);
    	claimAmount = PropertyHandler.getPropValue(filepath, claimAmount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	commodityCode = PropertyHandler.getPropValue(filepath, commodityCode);
    	actPortDlvry = PropertyHandler.getPropValue(filepath, actPortDlvry);
    	stnResp = PropertyHandler.getPropValue(filepath, stnResp);
    	claimantCode = PropertyHandler.getPropValue(filepath, claimantCode);
    	name = PropertyHandler.getPropValue(filepath, name);
    	addr1 = PropertyHandler.getPropValue(filepath, addr1);
    	addr2 = PropertyHandler.getPropValue(filepath, addr2);
    	country = PropertyHandler.getPropValue(filepath, country);
    	zip = PropertyHandler.getPropValue(filepath, zip);
    	telNo = PropertyHandler.getPropValue(filepath, telNo);
    	email = PropertyHandler.getPropValue(filepath, email);
    	fax = PropertyHandler.getPropValue(filepath, fax);
    	hawbNo = PropertyHandler.getPropValue(filepath, hawbNo);
    	remarks = PropertyHandler.getPropValue(filepath, remarks);
    	
    	listWithHouse(awbNoPrefix, awbNo, nature, hawbNo);
    	createClaimDetails(pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	fillClaimantDetails(claimantCode, name, addr1, addr2, country, zip, telNo, email, fax);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	String dialogueText = waitForElement(info_dialogueText).getText();
    	String claimRefNumber = dialogueText.split(" ")[6];
    	claimRefNumber = claimRefNumber.substring(0,claimRefNumber.length()-1);
    	Assert.assertEquals(dialogueText, "Claim registered successfully with ref no "+claimRefNumber+". Do you wish to list the saved details?");
    	click(btn_dialogueNo);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	PropertyHandler.setPropValue(filepath, claimRefNo, claimRefNumber);
    	verifyFieldsAreCleared();
    	return this;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method list with claim ref no
     * @param claimRefNo
     */
    private void listWithClaimRefNo(String claimRefNo){
    	enterKeys(txt_claimRefNo, claimRefNo);
    	click(btn_list);
    	minWait();
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method verify already created claim details
     * @param rowNumber
     * @param claimRefNo
     * @param nature
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     * @return
     */
    public CLM003 verifyClaimDetails(int rowNumber,String claimRefNo, String nature, String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp, String remarks){
    	
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	pieces = PropertyHandler.getPropValue(filepath, pieces);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	weight = PropertyHandler.getPropValue(filepath, weight);
    	weightUnit = PropertyHandler.getPropValue(filepath, weightUnit);
    	volume = PropertyHandler.getPropValue(filepath, volume);
    	volumeUnit = PropertyHandler.getPropValue(filepath, volumeUnit);
    	claimAmount = PropertyHandler.getPropValue(filepath, claimAmount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	commodityCode = PropertyHandler.getPropValue(filepath, commodityCode);
    	actPortDlvry = PropertyHandler.getPropValue(filepath, actPortDlvry);
    	stnResp = PropertyHandler.getPropValue(filepath, stnResp);
    	remarks = PropertyHandler.getPropValue(filepath, remarks);
    	listWithClaimRefNo(claimRefNo);
    	Assert.assertEquals(getSelectedValue(dropdown_nature), nature);
    	verifyDataInClaimDetailsTable(rowNumber,pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	return this;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method verify claimant details in already created claim
     * @param claimRefNo
     * @param claimantCode
     * @param name
     * @param addr1
     * @param addr2
     * @param country
     * @param zip
     * @param telNo
     * @param email
     * @param fax
     * @return
     */
    public CLM003 verifyClaimantDetails(String claimRefNo, String claimantCode, String name, String addr1, String addr2, String country,
    		String zip, String telNo, String email, String fax){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	claimantCode = PropertyHandler.getPropValue(filepath, claimantCode);
    	name = PropertyHandler.getPropValue(filepath, name);
    	addr1 = PropertyHandler.getPropValue(filepath, addr1);
    	addr2 = PropertyHandler.getPropValue(filepath, addr2);
    	country = PropertyHandler.getPropValue(filepath, country);
    	zip = PropertyHandler.getPropValue(filepath, zip);
    	telNo = PropertyHandler.getPropValue(filepath, telNo);
    	email = PropertyHandler.getPropValue(filepath, email);
    	fax = PropertyHandler.getPropValue(filepath, fax);
    	
    	listWithClaimRefNo(claimRefNo);
    	if(claimantCode != null && claimantCode.trim().length()>0)
    		Assert.assertEquals(waitForElementVisible(txt_claimantCode).getAttribute("value").toLowerCase(), claimantCode.toLowerCase());
    	if(name != null && name.trim().length()>0)
    		Assert.assertEquals(waitForElementVisible(txt_name).getAttribute("value").toLowerCase(), name.toLowerCase());
    	if(addr1 != null && addr1.trim().length()>0)
    		Assert.assertEquals(waitForElementVisible(txt_addr1).getAttribute("value").toLowerCase(), addr1.toLowerCase());
    	if(addr2 != null && addr2.trim().length()>0)
    		Assert.assertEquals(waitForElementVisible(txt_addr2).getAttribute("value").toLowerCase(), addr2.toLowerCase());
    	if(country != null && country.trim().length()>0)
    		Assert.assertEquals(waitForElementVisible(txt_country).getAttribute("value").toLowerCase(), country.toLowerCase());
    	if(zip != null && zip.trim().length()>0)
    		Assert.assertEquals(waitForElementVisible(txt_zip).getAttribute("value").toLowerCase(), zip.toLowerCase());
    	if(telNo != null && telNo.trim().length()>0)
    		Assert.assertEquals(waitForElementVisible(txt_telNo).getAttribute("value").toLowerCase(), telNo.toLowerCase());
    	if(email != null && email.trim().length()>0)
    		Assert.assertEquals(waitForElementVisible(txt_email).getAttribute("value").toLowerCase(), email.toLowerCase());
    	if(fax != null && fax.trim().length()>0)
    		Assert.assertEquals(waitForElementVisible(txt_fax).getAttribute("value").toLowerCase(), fax.toLowerCase());
    	return this;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method update already created claim
     * @param claimRefNo
     * @param nature
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     * @param claimantCode
     * @param name
     * @param addr1
     * @param addr2
     * @param country
     * @param zip
     * @param telNo
     * @param email
     * @param fax
     * @return
     */
    public CLM003 updateClaimDetails(String claimRefNo, String nature,String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp,String remarks,String claimantCode,String name, String addr1, String addr2, String country, String zip, String telNo,
    		String email, String fax){
    	
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	pieces = PropertyHandler.getPropValue(filepath, pieces);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	weight = PropertyHandler.getPropValue(filepath, weight);
    	weightUnit = PropertyHandler.getPropValue(filepath, weightUnit);
    	volume = PropertyHandler.getPropValue(filepath, volume);
    	volumeUnit = PropertyHandler.getPropValue(filepath, volumeUnit);
    	claimAmount = PropertyHandler.getPropValue(filepath, claimAmount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	commodityCode = PropertyHandler.getPropValue(filepath, commodityCode);
    	actPortDlvry = PropertyHandler.getPropValue(filepath, actPortDlvry);
    	stnResp = PropertyHandler.getPropValue(filepath, stnResp);
    	claimantCode = PropertyHandler.getPropValue(filepath, claimantCode);
    	name = PropertyHandler.getPropValue(filepath, name);
    	addr1 = PropertyHandler.getPropValue(filepath, addr1);
    	addr2 = PropertyHandler.getPropValue(filepath, addr2);
    	country = PropertyHandler.getPropValue(filepath, country);
    	zip = PropertyHandler.getPropValue(filepath, zip);
    	telNo = PropertyHandler.getPropValue(filepath, telNo);
    	email = PropertyHandler.getPropValue(filepath, email);
    	fax = PropertyHandler.getPropValue(filepath, fax);
    	remarks = PropertyHandler.getPropValue(filepath, remarks);
    	
    	listWithClaimRefNo(claimRefNo);
    	selectByText(dropdown_nature, nature);
    	updateClaimDetails(1,pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	fillClaimantDetails(claimantCode, name, addr1, addr2, country, zip, telNo, email, fax);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	String dialogueText = waitForElement(info_dialogueText).getText();   	
    	if(!nature.equals("Intent")){
    		Assert.assertEquals(dialogueText, "Do you want to create a claim directly without intent?");
        	click(btn_dialogueYes);
        	minWait();
        	dialogueText = waitForElement(info_dialogueText).getText(); 
    	}
    	Assert.assertEquals(dialogueText, "Claim updated successfully. Do you wish to relist the details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	verifyDataInClaimDetailsTable(1,pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	return this;
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method update already created claim provided claim already listed
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     */
    private void updateClaimDetails(int rowNumber,String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp, String remarks){
    	check(chkbox_selectTableItem);
    	click(lnk_modify);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(claimDetails_txt_noOfPieces), pieces);
    	if (reasonCode != null && reasonCode.trim().length()>0)
    		selectByText(claimDetails_dropdown_reasonCode, reasonCode);
    	if (severity != null && severity.trim().length()>0)
    		selectByText(claimDetails_dropdown_severity, severity);
    	enterKeys(claimDetails_txt_weight, weight);
    	if (weightUnit != null && weightUnit.trim().length()>0)
    		selectByText(claimDetails_dropdown_weightUnit, weightUnit);
    	enterKeys(claimDetails_txt_volume, volume);
    	if (volumeUnit != null && volumeUnit.trim().length()>0)
    		selectByText(claimDetails_dropdown_volumeUnit, volumeUnit);
    	enterKeys(claimDetails_txt_claimAmount, claimAmount);
    	enterKeys(claimDetails_txt_currency, currency);
    	enterKeys(claimDetails_txt_commodityCode, commodityCode);
    	if (actPortDlvry != null && actPortDlvry.trim().length()>0)
    		enterKeys(claimDetails_txt_actPortOfDlvry, actPortDlvry);
    	if (stnResp != null && stnResp.trim().length()>0)
    		enterKeys(claimDetails_txt_stnResp, stnResp);
    	if (remarks != null && remarks.trim().length()>0)
    		enterKeys(claimDetails_txt_remarks, remarks);
    	click(claimDetails_btn_ok);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	verifyDataInClaimDetailsTable(rowNumber,pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    }
    
    /**
     * Created by A-7605 on 20-2-18
     * This method update claim and do not relist after update
     * @param claimRefNo
     * @param nature
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     * @param claimantCode
     * @param name
     * @param addr1
     * @param addr2
     * @param country
     * @param zip
     * @param telNo
     * @param email
     * @param fax
     * @return
     */
    public CLM003 updateClaimDetails_NoRelist(String claimRefNo, String nature,String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp,String remarks,String claimantCode,String name, String addr1, String addr2, String country, String zip, String telNo,
    		String email, String fax){
    	
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	pieces = PropertyHandler.getPropValue(filepath, pieces);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	weight = PropertyHandler.getPropValue(filepath, weight);
    	weightUnit = PropertyHandler.getPropValue(filepath, weightUnit);
    	volume = PropertyHandler.getPropValue(filepath, volume);
    	volumeUnit = PropertyHandler.getPropValue(filepath, volumeUnit);
    	claimAmount = PropertyHandler.getPropValue(filepath, claimAmount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	commodityCode = PropertyHandler.getPropValue(filepath, commodityCode);
    	actPortDlvry = PropertyHandler.getPropValue(filepath, actPortDlvry);
    	stnResp = PropertyHandler.getPropValue(filepath, stnResp);
    	claimantCode = PropertyHandler.getPropValue(filepath, claimantCode);
    	name = PropertyHandler.getPropValue(filepath, name);
    	addr1 = PropertyHandler.getPropValue(filepath, addr1);
    	addr2 = PropertyHandler.getPropValue(filepath, addr2);
    	country = PropertyHandler.getPropValue(filepath, country);
    	zip = PropertyHandler.getPropValue(filepath, zip);
    	telNo = PropertyHandler.getPropValue(filepath, telNo);
    	email = PropertyHandler.getPropValue(filepath, email);
    	fax = PropertyHandler.getPropValue(filepath, fax);
    	remarks = PropertyHandler.getPropValue(filepath, remarks);
    	
    	listWithClaimRefNo(claimRefNo);
    	selectByText(dropdown_nature, nature);
    	updateClaimDetails(1,pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	fillClaimantDetails(claimantCode, name, addr1, addr2, country, zip, telNo, email, fax);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	click(waitForElement(btn_dialogueYes));
    	minWait();
    	String dialogueText = waitForElement(info_dialogueText).getText();
    	Assert.assertEquals(dialogueText, "Claim updated successfully. Do you wish to relist the details?");
    	click(btn_dialogueNo);
    	waitForFrameAndSwitch(FRAME);
    	verifyFieldsAreCleared();
    	return this;
    }
    
    /**
     * Created by A-7605 on 21-2-18
     * This method list claim details based on AWB No and update the claim with new value
     * @param awbNoPrefix
     * @param awbNo
     * @param nature
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     * @param claimantCode
     * @param name
     * @param addr1
     * @param addr2
     * @param country
     * @param zip
     * @param telNo
     * @param email
     * @param fax
     * @return
     */
    public CLM003 updateClaimDetails(int rowNumber,String awbNoPrefix, String awbNo, String claimRefNo,String nature,String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp,String remarks,String claimantCode,String name, String addr1, String addr2, String country, String zip, String telNo,
    		String email, String fax, boolean claimDetailsToBeUpdated, boolean claimantDetailsNeedToBeUpdated){
    	
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	pieces = PropertyHandler.getPropValue(filepath, pieces);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	weight = PropertyHandler.getPropValue(filepath, weight);
    	weightUnit = PropertyHandler.getPropValue(filepath, weightUnit);
    	volume = PropertyHandler.getPropValue(filepath, volume);
    	volumeUnit = PropertyHandler.getPropValue(filepath, volumeUnit);
    	claimAmount = PropertyHandler.getPropValue(filepath, claimAmount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	commodityCode = PropertyHandler.getPropValue(filepath, commodityCode);
    	actPortDlvry = PropertyHandler.getPropValue(filepath, actPortDlvry);
    	stnResp = PropertyHandler.getPropValue(filepath, stnResp);
    	claimantCode = PropertyHandler.getPropValue(filepath, claimantCode);
    	name = PropertyHandler.getPropValue(filepath, name);
    	addr1 = PropertyHandler.getPropValue(filepath, addr1);
    	addr2 = PropertyHandler.getPropValue(filepath, addr2);
    	country = PropertyHandler.getPropValue(filepath, country);
    	zip = PropertyHandler.getPropValue(filepath, zip);
    	telNo = PropertyHandler.getPropValue(filepath, telNo);
    	email = PropertyHandler.getPropValue(filepath, email);
    	fax = PropertyHandler.getPropValue(filepath, fax);
    	remarks = PropertyHandler.getPropValue(filepath, remarks);
    	
    	listClaim(awbNoPrefix, awbNo, claimRefNo);
    	selectByText(dropdown_nature, nature);
    	if(claimDetailsToBeUpdated)
    		updateClaimDetails(rowNumber,pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	if(claimantDetailsNeedToBeUpdated)
    		fillClaimantDetails(claimantCode, name, addr1, addr2, country, zip, telNo, email, fax);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	String dialogueText = waitForElement(info_dialogueText).getText(); 
    	if(!nature.equals("Intent")){
    		Assert.assertEquals(dialogueText, "Do you want to create a claim directly without intent?");
    		click(btn_dialogueYes);
    		minWait();
    		dialogueText = waitForElement(info_dialogueText).getText();
    	}
    	Assert.assertEquals(dialogueText, "Claim updated successfully. Do you wish to relist the details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	verifyDataInClaimDetailsTable(rowNumber,pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	return this;
    }
    
    /**
     * Created by A-7605 on 21-2-18
     * This method saves claim details with the claim details entered in two separate rows
     * @param nature
     * @param awbNoPrefix
     * @param awbNo
     * @param pieces1
     * @param reasonCode1
     * @param severity1
     * @param weight1
     * @param weightUnit1
     * @param volume1
     * @param volumeUnit1
     * @param claimAmount1
     * @param currency1
     * @param commodityCode1
     * @param actPortDlvry1
     * @param stnResp1
     * @param remarks1
     * @param pieces2
     * @param reasonCode2
     * @param severity2
     * @param weight2
     * @param weightUnit2
     * @param volume2
     * @param volumeUnit2
     * @param claimAmount2
     * @param currency2
     * @param commodityCode2
     * @param actPortDlvry2
     * @param stnResp2
     * @param remarks2
     * @param claimantCode
     * @param name
     * @param addr1
     * @param addr2
     * @param country
     * @param zip
     * @param telNo
     * @param email
     * @param fax
     * @param claimRefNo
     * @return
     */
    public CLM003 saveClaimDetails_TwoRows(String nature, String awbNoPrefix, String awbNo, String pieces1, String reasonCode1, String severity1, String weight1, String weightUnit1,
    		String volume1, String volumeUnit1, String claimAmount1, String currency1, String commodityCode1, String actPortDlvry1,
    		String stnResp1,String remarks1,String pieces2, String reasonCode2, String severity2, String weight2, String weightUnit2,
    		String volume2, String volumeUnit2, String claimAmount2, String currency2, String commodityCode2, String actPortDlvry2,
    		String stnResp2,String remarks2,String claimantCode,String name, String addr1, String addr2, String country, String zip, String telNo,
    		String email, String fax, String claimRefNo){
    	
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	pieces1 = PropertyHandler.getPropValue(filepath, pieces1);
    	reasonCode1 = PropertyHandler.getPropValue(filepath, reasonCode1);
    	severity1 = PropertyHandler.getPropValue(filepath, severity1);
    	weight1 = PropertyHandler.getPropValue(filepath, weight1);
    	weightUnit1 = PropertyHandler.getPropValue(filepath, weightUnit1);
    	volume1 = PropertyHandler.getPropValue(filepath, volume1);
    	volumeUnit1 = PropertyHandler.getPropValue(filepath, volumeUnit1);
    	claimAmount1 = PropertyHandler.getPropValue(filepath, claimAmount1);
    	currency1 = PropertyHandler.getPropValue(filepath, currency1);
    	commodityCode1 = PropertyHandler.getPropValue(filepath, commodityCode1);
    	actPortDlvry1 = PropertyHandler.getPropValue(filepath, actPortDlvry1);
    	stnResp1 = PropertyHandler.getPropValue(filepath, stnResp1);
    	pieces2 = PropertyHandler.getPropValue(filepath, pieces2);
    	reasonCode2 = PropertyHandler.getPropValue(filepath, reasonCode2);
    	severity2 = PropertyHandler.getPropValue(filepath, severity2);
    	weight2 = PropertyHandler.getPropValue(filepath, weight2);
    	weightUnit2 = PropertyHandler.getPropValue(filepath, weightUnit2);
    	volume2 = PropertyHandler.getPropValue(filepath, volume2);
    	volumeUnit2 = PropertyHandler.getPropValue(filepath, volumeUnit2);
    	claimAmount2 = PropertyHandler.getPropValue(filepath, claimAmount2);
    	currency2 = PropertyHandler.getPropValue(filepath, currency2);
    	commodityCode2 = PropertyHandler.getPropValue(filepath, commodityCode2);
    	actPortDlvry2 = PropertyHandler.getPropValue(filepath, actPortDlvry2);
    	stnResp2 = PropertyHandler.getPropValue(filepath, stnResp2);
    	claimantCode = PropertyHandler.getPropValue(filepath, claimantCode);
    	name = PropertyHandler.getPropValue(filepath, name);
    	addr1 = PropertyHandler.getPropValue(filepath, addr1);
    	addr2 = PropertyHandler.getPropValue(filepath, addr2);
    	country = PropertyHandler.getPropValue(filepath, country);
    	zip = PropertyHandler.getPropValue(filepath, zip);
    	telNo = PropertyHandler.getPropValue(filepath, telNo);
    	email = PropertyHandler.getPropValue(filepath, email);
    	fax = PropertyHandler.getPropValue(filepath, fax);
    	remarks1 = PropertyHandler.getPropValue(filepath, remarks1);
    	remarks2 = PropertyHandler.getPropValue(filepath, remarks2);
    	
    	list(awbNoPrefix, awbNo,nature);
    	createClaimDetailsTwoRows(pieces1, reasonCode1, severity1, weight1, weightUnit1, volume1, volumeUnit1, claimAmount1, currency1, commodityCode1, actPortDlvry1, stnResp1, remarks1, pieces2, reasonCode2, severity2, weight2, weightUnit2, volume2, volumeUnit2, claimAmount2, currency2, commodityCode2, actPortDlvry2, stnResp2, remarks2);
    	fillClaimantDetails(claimantCode, name, addr1, addr2, country, zip, telNo, email, fax);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	String dialogueText = waitForElement(info_dialogueText).getText();
    	if(!nature.equals("Intent")){
    		Assert.assertEquals(dialogueText, "Do you want to create a claim directly without intent?");
    		click(btn_dialogueYes);
    		minWait();
    	}
    	dialogueText = waitForElement(info_dialogueText).getText();
    	String claimRefNumber = dialogueText.split(" ")[6];
    	claimRefNumber = claimRefNumber.substring(0,claimRefNumber.length()-1);
    	Assert.assertEquals(dialogueText, "Claim registered successfully with ref no "+claimRefNumber+". Do you wish to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	PropertyHandler.setPropValue(filepath, claimRefNo, claimRefNumber);
    	verifyDataInClaimDetailsTable(1,pieces1, reasonCode1, severity1, weight1, weightUnit1, volume1, volumeUnit1, claimAmount1, currency1, commodityCode1, actPortDlvry1, stnResp1, remarks1);
    	verifyDataInClaimDetailsTable(2,pieces2, reasonCode2, severity2, weight2, weightUnit2, volume2, volumeUnit2, claimAmount2, currency2, commodityCode2, actPortDlvry2, stnResp2, remarks2);
    	return this;
    }
    
    /**
     * Created by A-7605 on 21-2-18
     * This method enters the claim details in two seperate rows
     * @param pieces1
     * @param reasonCode1
     * @param severity1
     * @param weight1
     * @param weightUnit1
     * @param volume1
     * @param volumeUnit1
     * @param claimAmount1
     * @param currency1
     * @param commodityCode1
     * @param actPortDlvry1
     * @param stnResp1
     * @param remarks1
     * @param pieces2
     * @param reasonCode2
     * @param severity2
     * @param weight2
     * @param weightUnit2
     * @param volume2
     * @param volumeUnit2
     * @param claimAmount2
     * @param currency2
     * @param commodityCode2
     * @param actPortDlvry2
     * @param stnResp2
     * @param remarks2
     */
    private void createClaimDetailsTwoRows(String pieces1, String reasonCode1, String severity1, String weight1, String weightUnit1,
    		String volume1, String volumeUnit1, String claimAmount1, String currency1, String commodityCode1, String actPortDlvry1,
    		String stnResp1, String remarks1,String pieces2, String reasonCode2, String severity2, String weight2, String weightUnit2,
    		String volume2, String volumeUnit2, String claimAmount2, String currency2, String commodityCode2, String actPortDlvry2,
    		String stnResp2, String remarks2){
    	click(lnk_create);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(claimDetails_txt_noOfPieces), pieces1);
    	if (reasonCode1 != null && reasonCode1.trim().length()>0)
    		selectByText(claimDetails_dropdown_reasonCode, reasonCode1);
    	if (severity1 != null && severity1.trim().length()>0)
    		selectByText(claimDetails_dropdown_severity, severity1);
    	enterKeys(claimDetails_txt_weight, weight1);
    	if (weightUnit1 != null && weightUnit1.trim().length()>0)
    		selectByText(claimDetails_dropdown_weightUnit, weightUnit1);
    	enterKeys(claimDetails_txt_volume, volume1);
    	if (volumeUnit1 != null && volumeUnit1.trim().length()>0)
    		selectByText(claimDetails_dropdown_volumeUnit, volumeUnit1);
    	enterKeys(claimDetails_txt_claimAmount, claimAmount1);
    	enterKeys(claimDetails_txt_currency, currency1);
    	enterKeys(claimDetails_txt_commodityCode, commodityCode1);
    	if (actPortDlvry1 != null && actPortDlvry1.trim().length()>0)
    		enterKeys(claimDetails_txt_actPortOfDlvry, actPortDlvry1);
    	if (stnResp1 != null && stnResp1.trim().length()>0)
    		enterKeys(claimDetails_txt_stnResp, stnResp1);
    	if (remarks1 != null && remarks1.trim().length()>0)
    		enterKeys(claimDetails_txt_remarks, remarks1);
    	click(claimDetails_btn_ok);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	click(lnk_create);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(claimDetails_txt_noOfPieces), pieces2);
    	if (reasonCode2 != null && reasonCode2.trim().length()>0)
    		selectByText(claimDetails_dropdown_reasonCode, reasonCode2);
    	if (severity2 != null && severity2.trim().length()>0)
    		selectByText(claimDetails_dropdown_severity, severity2);
    	enterKeys(claimDetails_txt_weight, weight2);
    	if (weightUnit2 != null && weightUnit2.trim().length()>0)
    		selectByText(claimDetails_dropdown_weightUnit, weightUnit2);
    	enterKeys(claimDetails_txt_volume, volume2);
    	if (volumeUnit2 != null && volumeUnit2.trim().length()>0)
    		selectByText(claimDetails_dropdown_volumeUnit, volumeUnit2);
    	enterKeys(claimDetails_txt_claimAmount, claimAmount2);
    	enterKeys(claimDetails_txt_currency, currency2);
    	enterKeys(claimDetails_txt_commodityCode, commodityCode2);
    	if (actPortDlvry2 != null && actPortDlvry2.trim().length()>0)
    		enterKeys(claimDetails_txt_actPortOfDlvry, actPortDlvry2);
    	if (stnResp2 != null && stnResp2.trim().length()>0)
    		enterKeys(claimDetails_txt_stnResp, stnResp2);
    	if (remarks2 != null && remarks2.trim().length()>0)
    		enterKeys(claimDetails_txt_remarks, remarks2);
    	click(claimDetails_btn_ok);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	verifyDataInClaimDetailsTable(1, pieces1, reasonCode1, severity1, weight1, weightUnit1, volume1, volumeUnit1, claimAmount1, currency1, commodityCode1, actPortDlvry1, stnResp1, remarks1);
    	verifyDataInClaimDetailsTable(2, pieces2, reasonCode2, severity2, weight2, weightUnit2, volume2, volumeUnit2, claimAmount2, currency2, commodityCode2, actPortDlvry2, stnResp2, remarks2);
    }
    
    /**
     * Created by A-7605 on 21-2-18
     * This method will delete claim details
     * @param rowNumber
     * @param awbNoPrefix
     * @param awbNo
     * @param claimRefNo
     * @return
     */
    public CLM003 deleteClaimDetails(int rowNumber,String awbNoPrefix, String awbNo, String claimRefNo){
    	
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);   	
    	int numberOfRowsBeforeDeletion;
    	int numberOfRowsAfterDeletion;
    	
    	listClaim(awbNoPrefix, awbNo, claimRefNo);
    	numberOfRowsBeforeDeletion = getTableRowCount(table_claimDetails);
    	check(getWebElements(chkbox_selectTableItem).get(rowNumber - 1));
    	click(lnk_delete);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	String dialogueText = waitForElement(info_dialogueText).getText(); 
    	Assert.assertEquals(dialogueText, "Claim updated successfully. Do you wish to relist the details?");
    	click(btn_dialogueYes);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	try{
    		numberOfRowsAfterDeletion = getTableRowCount(table_claimDetails);
    	}catch(TimeoutException e){
    		numberOfRowsAfterDeletion = 0;
    	}
    	Assert.assertEquals(numberOfRowsAfterDeletion, numberOfRowsBeforeDeletion - 1);
    	clear();
    	listClaim(awbNoPrefix, awbNo, claimRefNo);
    	minWait();
    	try{
    		numberOfRowsAfterDeletion = getTableRowCount(table_claimDetails);
    	}catch(TimeoutException e){
    		numberOfRowsAfterDeletion = 0;
    	}
    	Assert.assertEquals(numberOfRowsAfterDeletion, numberOfRowsBeforeDeletion - 1);
    	return this;
    }
    
    /**
     * Created by A-7605 on 21-2-18
     * This method check mandatory field validation in claimant fields and save the details after entering correct data
     * @param nature
     * @param awbNoPrefix
     * @param awbNo
     * @param pieces
     * @param reasonCode
     * @param severity
     * @param weight
     * @param weightUnit
     * @param volume
     * @param volumeUnit
     * @param claimAmount
     * @param currency
     * @param commodityCode
     * @param actPortDlvry
     * @param stnResp
     * @param remarks
     * @param claimantCode
     * @param name
     * @param addr1
     * @param addr2
     * @param country
     * @param zip
     * @param telNo
     * @param email
     * @param fax
     * @param claimRefNo
     * @return
     */
    public CLM003 saveClaimDetailsAfterMandatoryFieldValidationInClaimantFields(String nature, String awbNoPrefix, String awbNo, String pieces, String reasonCode, String severity, String weight, String weightUnit,
    		String volume, String volumeUnit, String claimAmount, String currency, String commodityCode, String actPortDlvry,
    		String stnResp,String remarks,String claimantCode,String name, String addr1, String addr2, String country, String zip, String telNo,
    		String email, String fax, String claimRefNo){
    	
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	pieces = PropertyHandler.getPropValue(filepath, pieces);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	weight = PropertyHandler.getPropValue(filepath, weight);
    	weightUnit = PropertyHandler.getPropValue(filepath, weightUnit);
    	volume = PropertyHandler.getPropValue(filepath, volume);
    	volumeUnit = PropertyHandler.getPropValue(filepath, volumeUnit);
    	claimAmount = PropertyHandler.getPropValue(filepath, claimAmount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	commodityCode = PropertyHandler.getPropValue(filepath, commodityCode);
    	actPortDlvry = PropertyHandler.getPropValue(filepath, actPortDlvry);
    	stnResp = PropertyHandler.getPropValue(filepath, stnResp);
    	claimantCode = PropertyHandler.getPropValue(filepath, claimantCode);
    	name = PropertyHandler.getPropValue(filepath, name);
    	addr1 = PropertyHandler.getPropValue(filepath, addr1);
    	addr2 = PropertyHandler.getPropValue(filepath, addr2);
    	country = PropertyHandler.getPropValue(filepath, country);
    	zip = PropertyHandler.getPropValue(filepath, zip);
    	telNo = PropertyHandler.getPropValue(filepath, telNo);
    	email = PropertyHandler.getPropValue(filepath, email);
    	fax = PropertyHandler.getPropValue(filepath, fax);
    	remarks = PropertyHandler.getPropValue(filepath, remarks);
    	
    	list(awbNoPrefix, awbNo,nature);
    	createClaimDetails(pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	click(btn_save);
    	String errorMessages = waitForElement(info_footerMultipleError).getText();
    	String[] errorMessage = errorMessages.split("\n");
    	Assert.assertEquals(errorMessage[0],"Claimant name is mandatory");
    	Assert.assertEquals(errorMessage[1],"Address1 is mandatory");
    	Assert.assertEquals(errorMessage[2],"Telephone number is mandatory");
    	Assert.assertEquals(errorMessage[3],"E-mail id is madatory");
    	enterKeys(info_footerMultipleError, Keys.ESCAPE);
    	fillClaimantDetails(claimantCode, name, addr1, addr2, country, zip, telNo, email, fax);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	String dialogueText = waitForElement(info_dialogueText).getText();
    	if(!nature.equals("Intent")){
    		Assert.assertEquals(dialogueText, "Do you want to create a claim directly without intent?");
    		click(btn_dialogueYes);
    		minWait();
    	}
    	dialogueText = waitForElement(info_dialogueText).getText();
    	String claimRefNumber = dialogueText.split(" ")[6];
    	claimRefNumber = claimRefNumber.substring(0,claimRefNumber.length()-1);
    	Assert.assertEquals(dialogueText, "Claim registered successfully with ref no "+claimRefNumber+". Do you wish to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	PropertyHandler.setPropValue(filepath, claimRefNo, claimRefNumber);
    	verifyDataInClaimDetailsTable(1,pieces, reasonCode, severity, weight, weightUnit, volume, volumeUnit, claimAmount, currency, commodityCode, actPortDlvry, stnResp, remarks);
    	return this;
    }
    
    /**
     * Created by A-7605
     * This method will check the AWB details (accepted, stated and delivered pcs and wgt) details in the AWB 
     * @param awbPrefix
     * @param awbNo
     * @param claimRefNo
     * @param pcs
     * @param weight
     * @param agentCode
     * @return
     */
    public CLM003 checkAWBDetails(String awbPrefix, String awbNo, String claimRefNo, String pcs, String weight, String agentCode){
    	awbPrefix = PropertyHandler.getPropValue(filepath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	pcs = PropertyHandler.getPropValue(filepath, pcs);
    	weight = PropertyHandler.getPropValue(filepath, weight);
    	agentCode = PropertyHandler.getPropValue(filepath, agentCode);
    	
    	listClaim(awbPrefix, awbNo, claimRefNo);
    	click(btn_awbDetails);
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	Assert.assertEquals(waitForElementVisible(AWBEnquiry_txt_awbPrefix).getAttribute("value"), awbPrefix);
    	Assert.assertEquals(waitForElementVisible(AWBEnquiry_txt_awbNo).getAttribute("value"), awbNo);
    	Assert.assertTrue(waitForElementVisible(AWBEnquiry_info_statedPcsAndWgt).getText().contains(pcs+" /"+weight));
    	Assert.assertTrue(waitForElementVisible(AWBEnquiry_info_acceptedPcsAndWgt).getText().contains(pcs+" /"+weight));
    	Assert.assertTrue(waitForElementVisible(AWBEnquiry_info_deliveredPcsAndWgt).getText().contains("0 /0"));
    	Assert.assertEquals(waitForElementVisible(AWBEnquiry_info_agentCode), agentCode);
    	click(AWBEnquiry_btn_close);
    	switchToFirstWindow();
    	return this;
    }
    
    /**
     * Created by A-7605 on 22-2-18
     * This method convert currency after clicking Currency Converter button
     * @param fromCurrencyCode
     * @param toCurrencyCode
     * @param fromValue
     * @return
     */
    private String convertCurrency(String fromCurrencyCode, String toCurrencyCode, String fromValue){
    	click(btn_currencyConverter);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(currencyConverter_txt_fromCurrencyCode), fromCurrencyCode);
    	enterKeys(currencyConverter_txt_fromValue, fromValue);
    	enterKeys(waitForElement(currencyConverter_txt_toCurrencyCode), toCurrencyCode);
    	click(currencyConverter_btn_convert);
    	minWait();
    	String toValue = waitForElement(currencyConverter_txt_toValue).getAttribute("value");
    	click(currencyConverter_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return toValue;
    }
    
    /**
     * Created by A-7605 on 22-2-18
     * This method check functionality of currency converter button
     * @param claimRefNo
     * @param fromCurrencyCode
     * @param toCurrencyCode
     * @param fromValue
     * @return
     */
    public CLM003 checkCurrencyConvertFunctionality(String claimRefNo, String fromCurrencyCode, String toCurrencyCode, String fromValue, String conversionFactor){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	fromCurrencyCode = PropertyHandler.getPropValue(filepath, fromCurrencyCode);
    	toCurrencyCode = PropertyHandler.getPropValue(filepath, toCurrencyCode);
    	fromValue = PropertyHandler.getPropValue(filepath, fromValue);
    	conversionFactor = PropertyHandler.getPropValue(filepath, conversionFactor);
    	listWithClaimRefNo(claimRefNo);
    	Double convertedValue = Double.parseDouble(convertCurrency(fromCurrencyCode, toCurrencyCode, fromValue));
    	Double expectedValue = Double.parseDouble(fromValue) * Double.parseDouble(conversionFactor);
    	Assert.assertEquals(convertedValue, expectedValue);
    	return this;
    }
    
    /**
     * Created by A-7605 on 22-2-18
     * This method check mandatory field validation in From Value field in Currency Converter popup
     * @param claimRefNo
     * @param fromCurrencyCode
     * @param toCurrencyCode
     * @return
     */
    public CLM003 checkMandatoryFieldValidationInFromValueFieldInCurrencyConverter(String claimRefNo, String fromCurrencyCode, String toCurrencyCode){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	fromCurrencyCode = PropertyHandler.getPropValue(filepath, fromCurrencyCode);
    	toCurrencyCode = PropertyHandler.getPropValue(filepath, toCurrencyCode);
    	listWithClaimRefNo(claimRefNo);
    	click(btn_currencyConverter);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(currencyConverter_txt_fromCurrencyCode), fromCurrencyCode);
    	enterKeys(currencyConverter_txt_fromValue, "");
    	enterKeys(waitForElement(currencyConverter_txt_toCurrencyCode), toCurrencyCode);
    	click(currencyConverter_btn_convert);
    	minWait();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Either the From CurrencyCode or To CurrencyCode or FromValue is not specified.Please specify it!");
    	click(btn_dialogueOk);
    	click(currencyConverter_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    private OPR024 viewDiscrepancy(){
    	click(btn_awbDiscrepancy);
    	minWait();
    	return new OPR024(driver, testDataFile);
    }
    public CLM003 checkAWBDiscrepancyDetails(String claimRefNo,String station,String flightNo,String flightDate,String discCode,String discPcs,String discWgt,String mftPcs,String mftWgt,String rcvdPcs,String rcvdWgt,String status){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	station = PropertyHandler.getPropValue(filepath, station);
    	flightNo = PropertyHandler.getPropValue(filepath, flightNo);
    	flightDate = PropertyHandler.getPropValue(filepath, flightDate);
    	discCode = PropertyHandler.getPropValue(filepath, discCode);
    	discPcs = PropertyHandler.getPropValue(filepath, discPcs);
    	discWgt = PropertyHandler.getPropValue(filepath, discWgt);
    	mftPcs = PropertyHandler.getPropValue(filepath, mftPcs);
    	mftWgt = PropertyHandler.getPropValue(filepath, mftWgt);
    	rcvdPcs = PropertyHandler.getPropValue(filepath, rcvdPcs);
    	rcvdWgt = PropertyHandler.getPropValue(filepath, rcvdWgt);
    	status = PropertyHandler.getPropValue(filepath, status);
    	
    	listWithClaimRefNo(claimRefNo);
    	return viewDiscrepancy().verifyDescripancyDetailsFromCLM003(station, flightNo, flightDate, discCode, discPcs, discWgt, mftPcs, mftWgt, rcvdPcs, rcvdWgt, status);
    	
    }
    
    private void doActionOnClaim(String action, String reason, String amount, String currency, String remark){
    	String notification = null;
    	
    	if(action.equals("Investigated")){
    		notification = "Do you want to mark this claim as investigated";
    	}
    	else if(action.equals("Release Hold")){
    		notification = "Do you want to release the hold on this claim";
    	}
    	else if(action.equals("On hold")){
    		notification = "Do you want to hold this claim";
    	}
    	else if(action.equals("Under Investigation")){
    		notification = "Do you want to mark this claim as under investigation";
    	}
    	else if(action.equals("Rejected")){
    		notification = "Do you want to mark this claim as rejected";
    	}
    	else{
    		notification = "Do you want to mark this claim as settled";
    	}
    								
    	click(btn_actionClaim);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	selectByText(actionClaims_dropdown_action, action);
    	if (reason != null && reason.trim().length()>0)
    		selectByText(actionClaims_dropdown_reason, reason);
    	enterKeys(actionClaims_txt_amount, amount);
    	selectByText(actionClaims_dropdown_currency, currency);
    	enterKeys(actionClaims_txt_remark, remark);
    	click(actionClaims_btn_save);
    	minWait();    	
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), notification);
    	click(btn_dialogueYes);
    	if(action.equals("Investigated")){
    		waitForNewWindow(3);
    		switchToNthWindow(3);
    		click(claimWarnings_btn_continue);
    	}

    	switchToFirstWindow();
    	if(action.equals("Rejected")){
    		if(verifyElementPresent(btn_dialogueYes))
    			click(btn_dialogueYes);
    		minWait();
    	}
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    }
    /**
     * Created by A-7605 on 23-1-18
     * This method click on Action Claim button change the status based on the user specified action
     * @param claimRefNo
     * @param action
     * @param reason
     * @param amount
     * @param currency
     * @param remarks
     * @return
     */
    public CLM003 actionClaim(String claimRefNo, String action, String reason, String amount, String currency, String remarks){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	action = PropertyHandler.getPropValue(filepath, action);
    	reason = PropertyHandler.getPropValue(filepath, reason);
    	amount = PropertyHandler.getPropValue(filepath, amount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	
    	listWithClaimRefNo(claimRefNo);
    	doActionOnClaim(action, reason, amount, currency, remarks);
//    	click(btn_save);
//    	driver.switchTo().defaultContent();
//    	if (waitForElement(info_dialogueText).getText().equals("Do you want to create a claim directly without intent?")){
//    		click(btn_dialogueYes);
//    		minWait();
//    	}
//    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Claim updated successfully. Do you wish to relist the details?");
//    	click(btn_dialogueYes);
//    	waitForFrameAndSwitch(FRAME);
//    	minWait();
    	if(action.equalsIgnoreCase("Release Hold"))
    		action = "New";
    	Assert.assertEquals(waitForElementVisible(txt_claimStatus).getAttribute("value"), action);
    	return this;
    }
    /**
     * Created by A-7605 on 2-3-18
     * This method will cancel the claim
     * @param claimRefNo
     * @return
     */
    public CLM003 cancelClaim(String claimRefNo){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	listWithClaimRefNo(claimRefNo);
    	click(btn_cancelClaim);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Do you really want to cancel the claim?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElementVisible(txt_claimStatus).getAttribute("value"), "Canceled");
    	return this;
    }
    
    /**
     * Created by A-7605 on 5-3-18
     * This method will transfer the claim to other airline
     * @param claimRefNo
     * @param airlineCode
     * @param transferDate
     * @param remarks
     * @return
     */
    public CLM003 transferClaimToOtherAirline(String claimRefNo, String airlineCode, String transferDate, String remarks){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	airlineCode = PropertyHandler.getPropValue(filepath, airlineCode);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_transferClaim);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(waitForElement(transfer_option_airlineCode));
    	enterKeys(transfer_txt_airlineCode, airlineCode);
    	enterKeys(transfer_txt_transferDate, transferDate);
    	enterKeys(transfer_txt_transferDate, Keys.TAB);
    	enterKeys(transfer_txt_remarks, remarks);
    	click(transfer_btn_save);
    	click(btn_dialogueYes);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElementVisible(txt_claimStatus).getAttribute("value").toLowerCase(), "transferred");
    	return this;
    }
    
    private void attach(String fullFilePath, String remark){
    	click(lnk_addAttachments);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	getWebElements(addAttachment_btn_select).get(0).sendKeys(fullFilePath);
//    	enterKeys(getWebElements(addAttachment_btn_select).get(0), fullFilePath);
    	enterKeys(addAttachment_txt_remark, remark);
    	click(addAttachment_btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    }
    /**
     * Created by A-7605 on 5-3-18
     * This method add attachment to already created intent claim 
     * @param claimRefNo
     * @param fullFilePath
     * @param remark
     * @param station
     * @param uploadedName
     * @return
     */
    public CLM003 addAttachment(String claimRefNo, String fullFilePath,String remark, String station, String uploadedName){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	fullFilePath = PropertyHandler.getPropValue(filepath, fullFilePath);
    	station = PropertyHandler.getPropValue(filepath, station);
    	remark = PropertyHandler.getPropValue(filepath, remark);
    	String fileName;
    	try{
    		fileName = fullFilePath.substring(fullFilePath.lastIndexOf("\\")+1,fullFilePath.length());
    	}catch(IndexOutOfBoundsException e){
    		fileName = fullFilePath.substring(fullFilePath.lastIndexOf("/")+1,fullFilePath.length());
    	}
    	PropertyHandler.setPropValue(filepath, uploadedName, fileName);
    	listWithClaimRefNo(claimRefNo);
    	attach(fullFilePath, remark);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Claim updated successfully. Do you wish to relist the details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_attachmentRemarks).getAttribute("value").toLowerCase(), remark.toLowerCase());
    	Assert.assertEquals(waitForElement(txt_attachmentStation).getAttribute("value").toLowerCase(), station.toLowerCase());
    	Assert.assertEquals(waitForElement(txt_attachmentPreviewIcon).getText().toLowerCase(), fileName.toLowerCase());
    	return this;
    }
    /**
     * Created by A-7605 on 5-3-18
     * This method delete already attached file
     * @param claimRefNo
     * @return
     */
    public CLM003 deleteAttachment(String claimRefNo){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    
    	listWithClaimRefNo(claimRefNo);    	
    	check(chkbox_selectAttachmentsTableItem);
    	click(lnk_deleteAttachments);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Claim updated successfully. Do you wish to relist the details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(getTableRowCount(table_attachments), 0);
    	return this;
    }
    /**
     * Created by A-7605 on 7-3-18
     * This method check validation error showing on transferring claim to same airline
     * @param claimRefNo
     * @param airlineCode
     * @param transferDate
     * @return
     */
    public CLM003 checkSameAirlineCodeValidationOnTransferClaim(String claimRefNo, String airlineCode, String transferDate){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	airlineCode = PropertyHandler.getPropValue(filepath, airlineCode);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_transferClaim);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(waitForElement(transfer_option_airlineCode));
    	enterKeys(transfer_txt_airlineCode, airlineCode);
    	enterKeys(transfer_txt_transferDate, transferDate);
    	enterKeys(transfer_txt_transferDate, Keys.TAB);
    	click(transfer_btn_save);
    	Assert.assertEquals(waitForElement(info_error).getText(), "A claim cannot be transferred to the same airline");
    	click(transfer_btn_close);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElementVisible(txt_claimStatus).getAttribute("value").toLowerCase(), "new");
    	return this;
    }
    /**
     * Created by A-7605 on 7-3-18
     * This method transfer claim to other airline for already listed claim
     * @param airlineCode
     * @param transferDate
     * @param remarks
     * @return
     */
    public CLM003 transferClaimForAlreadyListedClaim(String airlineCode, String transferDate, String remarks){
    	airlineCode = PropertyHandler.getPropValue(filepath, airlineCode);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	click(btn_transferClaim);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(waitForElement(transfer_option_airlineCode));
    	enterKeys(transfer_txt_airlineCode, airlineCode);
    	enterKeys(transfer_txt_transferDate, transferDate);
    	enterKeys(transfer_txt_transferDate, Keys.TAB);
    	enterKeys(transfer_txt_remarks, remarks);
    	click(transfer_btn_save);
    	click(btn_dialogueYes);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElementVisible(txt_claimStatus).getAttribute("value").toLowerCase(), "transferred");
    	return this;
    }
    
    /**
     * Created by A-7605 on 7-3-18
     * This method will transfer the claim to station
     * @param claimRefNo
     * @param airlineCode
     * @param transferDate
     * @param remarks
     * @return
     */
    public CLM003 transferClaimToOtherStation(String claimRefNo, String stationCode, String transferDate, String remarks){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	stationCode = PropertyHandler.getPropValue(filepath, stationCode);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_transferClaim);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(waitForElement(transfer_option_stationCode));
    	enterKeys(transfer_txt_stationCode, stationCode);
    	enterKeys(transfer_txt_transferDate, transferDate);
    	enterKeys(transfer_txt_transferDate, Keys.TAB);
    	enterKeys(transfer_txt_remarks, remarks);
    	click(transfer_btn_save);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElementVisible(txt_claimStatus).getAttribute("value").toLowerCase(), "transferred");
    	return this;
    }
    
    /**
     * Created by A-7605 on 7-3-18
     * This method will transfer the claim to head quarters
     * @param claimRefNo
     * @param airlineCode
     * @param transferDate
     * @param remarks
     * @return
     */
    public CLM003 transferClaimToHeadQuarters(String claimRefNo, String headQuarters, String transferDate, String remarks){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	headQuarters = PropertyHandler.getPropValue(filepath, headQuarters);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_transferClaim);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(waitForElement(transfer_option_headQuarters));
    	enterKeys(transfer_txt_headQuarters, headQuarters);
    	enterKeys(transfer_txt_transferDate, transferDate);
    	enterKeys(transfer_txt_transferDate, Keys.TAB);
    	enterKeys(transfer_txt_remarks, remarks);
    	click(transfer_btn_save);
    	click(btn_dialogueYes);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElementVisible(txt_claimStatus).getAttribute("value").toLowerCase(), "transferred");
    	return this;
    }
    
    /**
     * Created by A-7605 on 7-3-18
     * This method will transfer the claim to insurance agent
     * @param claimRefNo
     * @param airlineCode
     * @param transferDate
     * @param remarks
     * @return
     */
    public CLM003 transferClaimToInsuranceAgent(String claimRefNo, String insuranceAgent, String transferDate, String remarks){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	insuranceAgent = PropertyHandler.getPropValue(filepath, insuranceAgent);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_transferClaim);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(waitForElement(transfer_option_insuranceAgent));
    	enterKeys(transfer_txt_insuranceAgent, insuranceAgent);
    	enterKeys(transfer_txt_transferDate, transferDate);
    	enterKeys(transfer_txt_transferDate, Keys.TAB);
    	enterKeys(transfer_txt_remarks, remarks);
    	click(transfer_btn_save);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElementVisible(txt_claimStatus).getAttribute("value").toLowerCase(), "transferred");
    	return this;
    }
    
    /**
     * Created by A-7605 on 7-3-18
     * This method will transfer the claim to legal
     * @param claimRefNo
     * @param airlineCode
     * @param transferDate
     * @param remarks
     * @return
     */
    public CLM003 transferClaimToLegal(String claimRefNo, String legal, String transferDate, String remarks){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	legal = PropertyHandler.getPropValue(filepath, legal);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_transferClaim);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(waitForElement(transfer_option_legal));
    	enterKeys(transfer_txt_legal, legal);
    	enterKeys(transfer_txt_transferDate, transferDate);
    	enterKeys(transfer_txt_transferDate, Keys.TAB);
    	enterKeys(transfer_txt_remarks, remarks);
    	click(transfer_btn_save);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElementVisible(txt_claimStatus).getAttribute("value").toLowerCase(), "transferred");
    	return this;
    }
    /**
     * Created by A-7605 on 7-3-18
     * This method verify the claim status
     * @param claimRefNo
     * @param expectedStatus
     * @return
     */
    public CLM003 verifyClaimStatus(String claimRefNo, String expectedStatus){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	expectedStatus = PropertyHandler.getPropValue(filepath, expectedStatus);
    	listWithClaimRefNo(claimRefNo);
    	Assert.assertEquals(waitForElementVisible(txt_claimStatus).getAttribute("value").toLowerCase(), expectedStatus.toLowerCase());
    	return this;
    }
    /**
     * Created by A-7605 on 8-3-18
     * This method reopen already rejected claim
     * @param claimRefNo
     * @return
     */
    public CLM003 reopenClaim(String claimRefNo){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_reopen);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Do you really want to reopen the claim?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElementVisible(txt_claimStatus).getAttribute("value").toLowerCase(), "reopened");
    	return this;
    }
    
    /**
     * Created by A-7605 on 12-3-18
     * This method will cancel the claim
     * @param claimRefNo
     * @return
     */
    public CLM003 checkErrorMessageShownOnancelingClaimOfInvalidStatus(String claimRefNo){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	listWithClaimRefNo(claimRefNo);
    	click(btn_cancelClaim);
    	minWait();
    	Assert.assertEquals(waitForElementVisible(info_error).getText(), "Only claims with status new can be cancelled");
    	return this;
    }
    
    /**
     * Created by A-7605 on 12-3-18
     * This method check if history details are showing correctly in the table in Claim History pop up, the search is carried out based on the Action hence the method works well only if the action is unique in the table
     * @param claimRefNo
     * @param nature
     * @param status
     * @param action
     * @param doneBy
     * @return
     */
    public CLM003 verifyClaimHistory(String claimRefNo, String nature, String status, String action, String doneBy){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	status = PropertyHandler.getPropValue(filepath, status);
    	action = PropertyHandler.getPropValue(filepath, action);
    	doneBy = PropertyHandler.getPropValue(filepath, doneBy);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_claimsHistory);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	Assert.assertEquals(tblGetTextByColValue(claimHistory_table, 2, 4, action), nature);
    	Assert.assertEquals(tblGetTextByColValue(claimHistory_table, 3, 4, action), status);
    	Assert.assertEquals(tblGetTextByColValue(claimHistory_table, 5, 4, action), doneBy);
    	click(claimHistory_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    /**
     * Created by A-7605 on 12-3-18
     * This method verify the table fields in the Claims History pop up
     * @param claimRefNo
     * @return
     */
    public CLM003 verifyFieldsInClaimHistory(String claimRefNo){
    	List<String> tableHeaders;
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_claimsHistory);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	Assert.assertTrue(waitForElement(claimHistory_lnk_add).isDisplayed());
    	Assert.assertTrue(waitForElement(claimHistory_lnk_delete).isDisplayed());
    	tableHeaders = getTableHeaderColNames(claimHistory_headerTable);
    	Assert.assertTrue(tableHeaders.contains("Nature"));
    	Assert.assertTrue(tableHeaders.contains("Status"));
    	Assert.assertTrue(tableHeaders.contains("Action"));
    	Assert.assertTrue(tableHeaders.contains("Done By"));
    	Assert.assertTrue(tableHeaders.contains("Date"));
    	Assert.assertTrue(tableHeaders.contains("Remarks"));
    	click(claimHistory_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    /**
     * Created by A-7605 on 20-3-18
     * This method verify if the checksheet captured in acceptance screen is showing in the checksheet popup (currently not complete due to bug)
     * @param awbNoPrefix
     * @param awbNo
     * @param checksheetResponse
     * @return
     */
    public CLM003 verifyChecksheetDetails(String awbNoPrefix, String awbNo, String checksheetResponse){
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	checksheetResponse = PropertyHandler.getPropValue(filepath, checksheetResponse);
    	
    	enterKeys(waitForElement(txt_awbNoPrefix), awbNoPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_list);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueText).getText(), "Do you want to register a new claim?");
    	click(btn_dialogueYes);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_checksheet);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	selectByText(captureCheckSheet_dropdown_transaction, "Acceptance");
    	/// could not add verification because of bugs in the application. Need to compare the text shown against the checksheetResponse
    	
    	click(captureCheckSheet_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    public CLM003 verifyClaimNoAndAWBDetails(String claimRefNo, String awbPrefix, String awbNo){
    	Assert.assertEquals(waitForElementVisible(txt_claimRefNo).getAttribute("value"), claimRefNo);
    	Assert.assertEquals(waitForElementVisible(txt_awbNoPrefix).getAttribute("value"), awbPrefix);
    	Assert.assertEquals(waitForElementVisible(txt_awbNo).getAttribute("value"), awbNo);
    	click(btn_close);
    	return new CLM003(driver, testDataFile);
    }
}
