package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CLM002 extends BasePage{

	public CLM002(WebDriver driver, String testDataFile) {
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
	public static String FRAME_OPR024 = "iCargoContentFrameOPR024";
	public static String FRAME_CLM002 = "iCargoContentFrameCLM002";
	
	WebDriver driver;    
    String testDataFile;
    
    By txt_claimRefNo,
    txt_awbNoPrefix,
    txt_AWBNo,
    txt_HAWBNo,
    txt_claimantCode,
    txt_fromDate,
    txt_toDate,
    txt_station,
    txt_region,
    dropdown_nature,
    dropdown_status,
    dropdown_severity,
    btn_list,
    btn_clear,
    table_details,
    chkbox_selectTableItem,
    btn_details,
    btn_print,
    btn_transferClaim,
    btn_actionClaim,
    btn_claimHistory,
    btn_awbDsicrepancy,
    btn_reopen,
    btn_investigationDetails,
    btn_acknowledgeIntent,
    btn_viewReports,
    btn_serviceRecoveryMech,
    btn_close,
    lnk_next,
    btn_dialogueYes,
    btn_dialogueNo,
    btn_dialogueOk,
    info_dialogueContent,
    serviceRecoveryMachanisms_dropdown_ServiceRecMach,
    serviceRecoveryMachanisms_txt_amountInvolved,
    serviceRecoveryMachanisms_dropdown_currency,
    serviceRecoveryMachanisms_dropdown_modeOfSettlement,
    serviceRecoveryMachanisms_txt_remarks,
    serviceRecoveryMachanisms_btn_save,
    serviceRecoveryMachanisms_btn_close,
    icon_attachment,
    addAttachment_lnk_attachedFileName,
    addAttachment_txt_remark,
    addAttachment_btn_close,
    acknowledgeClaim_txt_email,
    acknowledgeClaim_btn_save,
    transfer_option_airlineCode,
    transfer_txt_airlineCode,
    transfer_option_stationCode,
    transfer_txt_stationCode,
    transfer_option_headQuarters,
    transfer_txt_headQuarters,
    transfer_option_insuranceAgent,
    transfer_txt_insuranceAgent,
    transfer_option_legal,
    transfer_txt_legal,
    transfer_txt_transferDate,
    transfer_txt_remarks,
    transfer_btn_save,
    transfer_btn_close,
    info_error,
    actionClaims_dropdown_action,
    actionClaims_dropdown_reason,
    actionClaims_txt_amount,
    actionClaims_dropdown_currency,
    actionClaims_txt_remarks,
    actionClaims_btn_save,
    actionClaims_btn_close,
    claimHistory_lnk_delete,
    claimHistory_lnk_add,
    claimHistory_table,
    claimHistory_headerTable,
    claimHistory_btn_save,
    claimHistory_btn_close,
    icon_claimReferenceNoLov,
    claimReferenceNoLov_txt_claimRefNo,
    claimReferenceNoLov_btn_list,
    claimReferenceNoLov_lnk_next,
    claimReferenceNoLov_table,
    claimReferenceNoLov_chkbox_selectTableItem,
    claimReferenceNoLov_btn_ok,
    icon_selectRegion,
    selectRegion_txt_regionCode,
    selectRegion_btn_list,
    selectRegion_chkbox_selectTableItem,
    selectRegion_btn_ok,
    btn_awbDiscrepancy;
    
    private void initPageElements(){
    	txt_claimRefNo = MiscUtility.getWebElement(objFilepath,"CLM002_txt_claimRefNo");
        txt_awbNoPrefix = MiscUtility.getWebElement(objFilepath,"CLM002_txt_awbNoPrefix");
        txt_AWBNo = MiscUtility.getWebElement(objFilepath,"CLM002_txt_AWBNo");
        txt_HAWBNo = MiscUtility.getWebElement(objFilepath,"CLM002_txt_HAWBNo");
        txt_claimantCode = MiscUtility.getWebElement(objFilepath,"CLM002_txt_claimantCode");
        txt_fromDate = MiscUtility.getWebElement(objFilepath,"CLM002_txt_fromDate");
        txt_toDate = MiscUtility.getWebElement(objFilepath,"CLM002_txt_toDate");
        txt_station = MiscUtility.getWebElement(objFilepath,"CLM002_txt_station");
        txt_region = MiscUtility.getWebElement(objFilepath,"CLM002_txt_region");
        dropdown_nature = MiscUtility.getWebElement(objFilepath,"CLM002_dropdown_nature");
        dropdown_status = MiscUtility.getWebElement(objFilepath,"CLM002_dropdown_status");
        dropdown_severity = MiscUtility.getWebElement(objFilepath,"CLM002_dropdown_severity");
        btn_list = MiscUtility.getWebElement(objFilepath,"CLM002_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath,"CLM002_btn_clear");
        table_details = MiscUtility.getWebElement(objFilepath,"CLM002_table_details");
        chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath,"CLM002_chkbox_selectTableItem");
        btn_details = MiscUtility.getWebElement(objFilepath,"CLM002_btn_details");
        btn_print = MiscUtility.getWebElement(objFilepath,"CLM002_btn_print");
        btn_transferClaim = MiscUtility.getWebElement(objFilepath,"CLM002_btn_transferClaim");
        btn_actionClaim = MiscUtility.getWebElement(objFilepath,"CLM002_btn_actionClaim");
        btn_claimHistory = MiscUtility.getWebElement(objFilepath,"CLM002_btn_claimHistory");
        btn_awbDsicrepancy = MiscUtility.getWebElement(objFilepath,"CLM002_btn_awbDsicrepancy");
        btn_reopen = MiscUtility.getWebElement(objFilepath,"CLM002_btn_reopen");
        btn_investigationDetails = MiscUtility.getWebElement(objFilepath,"CLM002_btn_investigationDetails");
        btn_acknowledgeIntent = MiscUtility.getWebElement(objFilepath,"CLM002_btn_acknowledgeIntent");
        btn_viewReports = MiscUtility.getWebElement(objFilepath,"CLM002_btn_viewReports");
        btn_serviceRecoveryMech = MiscUtility.getWebElement(objFilepath,"CLM002_btn_serviceRecoveryMech");
        btn_close = MiscUtility.getWebElement(objFilepath,"CLM002_btn_close");
        lnk_next = MiscUtility.getWebElement(objFilepath,"CLM002_lnk_next");
        serviceRecoveryMachanisms_dropdown_ServiceRecMach = MiscUtility.getWebElement(objFilepath,"CLM002_ServiceRecoveryMachanisms_dropdown_ServiceRecMach");
        serviceRecoveryMachanisms_txt_amountInvolved = MiscUtility.getWebElement(objFilepath,"CLM002_ServiceRecoveryMachanisms_txt_amountInvolved");
        serviceRecoveryMachanisms_dropdown_currency = MiscUtility.getWebElement(objFilepath,"CLM002_ServiceRecoveryMachanisms_dropdown_currency");
        serviceRecoveryMachanisms_dropdown_modeOfSettlement = MiscUtility.getWebElement(objFilepath,"CLM002_ServiceRecoveryMachanisms_dropdown_modeOfSettlement");
        serviceRecoveryMachanisms_txt_remarks = MiscUtility.getWebElement(objFilepath,"CLM002_ServiceRecoveryMachanisms_txt_remarks");
        serviceRecoveryMachanisms_btn_save = MiscUtility.getWebElement(objFilepath,"CLM002_ServiceRecoveryMachanisms_btn_save");
        serviceRecoveryMachanisms_btn_close = MiscUtility.getWebElement(objFilepath,"CLM002_ServiceRecoveryMachanisms_btn_close");
        icon_attachment = MiscUtility.getWebElement(objFilepath,"CLM002_icon_attachment");
        addAttachment_lnk_attachedFileName = MiscUtility.getWebElement(objFilepath,"CLM002_AddAttachment_lnk_attachedFileName");
        addAttachment_txt_remark = MiscUtility.getWebElement(objFilepath,"CLM002_AddAttachment_txt_remark");
        addAttachment_btn_close = MiscUtility.getWebElement(objFilepath,"CLM002_AddAttachment_btn_close");
        acknowledgeClaim_txt_email = MiscUtility.getWebElement(objFilepath,"CLM002_AcknowledgeClaim_txt_email");
        acknowledgeClaim_btn_save = MiscUtility.getWebElement(objFilepath,"CLM002_AcknowledgeClaim_btn_save");
        transfer_option_airlineCode = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_option_airlineCode");
        transfer_txt_airlineCode = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_txt_airlineCode");
        transfer_option_stationCode = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_option_stationCode");
        transfer_txt_stationCode = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_txt_stationCode");
        transfer_option_headQuarters = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_option_headQuarters");
        transfer_txt_headQuarters = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_txt_headQuarters");
        transfer_option_insuranceAgent = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_option_insuranceAgent");
        transfer_txt_insuranceAgent = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_txt_insuranceAgent");
        transfer_option_legal = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_option_legal");
        transfer_txt_legal = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_txt_legal");
        transfer_txt_transferDate = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_txt_transferDate");
        transfer_txt_remarks = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_txt_remarks");
        transfer_btn_save = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_btn_save");
        transfer_btn_close = MiscUtility.getWebElement(objFilepath,"CLM002_Transfer_btn_close");
        actionClaims_dropdown_action = MiscUtility.getWebElement(objFilepath,"CLM002_ActionClaims_dropdown_action");
        actionClaims_dropdown_reason = MiscUtility.getWebElement(objFilepath,"CLM002_ActionClaims_dropdown_reason");
        actionClaims_txt_amount = MiscUtility.getWebElement(objFilepath,"CLM002_ActionClaims_txt_amount");
        actionClaims_dropdown_currency = MiscUtility.getWebElement(objFilepath,"CLM002_ActionClaims_dropdown_currency");
        actionClaims_txt_remarks = MiscUtility.getWebElement(objFilepath,"CLM002_ActionClaims_txt_remarks");
        actionClaims_btn_save = MiscUtility.getWebElement(objFilepath,"CLM002_ActionClaims_btn_save");
        actionClaims_btn_close = MiscUtility.getWebElement(objFilepath,"CLM002_ActionClaims_btn_close");
        btn_claimHistory = MiscUtility.getWebElement(objFilepath,"CLM002_btn_claimHistory");
        claimHistory_lnk_delete = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimHistory_lnk_delete");
        claimHistory_lnk_add = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimHistory_lnk_add");
        claimHistory_table = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimHistory_table");
        claimHistory_headerTable = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimHistory_headerTable");
        claimHistory_btn_save = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimHistory_btn_save");
        claimHistory_btn_close = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimHistory_btn_close");
        icon_claimReferenceNoLov = MiscUtility.getWebElement(objFilepath,"CLM002_icon_claimReferenceNoLov");
        claimReferenceNoLov_txt_claimRefNo = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimReferenceNoLov_txt_claimRefNo");
        claimReferenceNoLov_btn_list = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimReferenceNoLov_btn_list");
        claimReferenceNoLov_lnk_next = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimReferenceNoLov_lnk_next");
        claimReferenceNoLov_table = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimReferenceNoLov_table");
        claimReferenceNoLov_chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimReferenceNoLov_chkbox_selectTableItem");
        claimReferenceNoLov_btn_ok = MiscUtility.getWebElement(objFilepath,"CLM002_ClaimReferenceNoLov_btn_ok");
        icon_selectRegion = MiscUtility.getWebElement(objFilepath,"CLM002_icon_selectRegion");
        selectRegion_txt_regionCode = MiscUtility.getWebElement(objFilepath,"CLM002_SelectRegion_txt_regionCode");
        selectRegion_btn_list = MiscUtility.getWebElement(objFilepath,"CLM002_SelectRegion_btn_list");
        selectRegion_chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath,"CLM002_SelectRegion_chkbox_selectTableItem");
        selectRegion_btn_ok = MiscUtility.getWebElement(objFilepath,"CLM002_SelectRegion_btn_ok");
        btn_awbDiscrepancy = MiscUtility.getWebElement(objFilepath,"CLM002_btn_awbDiscrepancy");
        
        btn_dialogueYes = MiscUtility.getWebElement(genFilepath,"Generic_btn_diaYes");
        btn_dialogueNo = MiscUtility.getWebElement(genFilepath,"Generic_btn_noBtn");
        info_dialogueContent = MiscUtility.getWebElement(genFilepath,"Generic_info_msg");
        btn_dialogueOk = MiscUtility.getWebElement(genFilepath,"Generic_btn_ok");
        info_error = MiscUtility.getWebElement(genFilepath,"Generic_info_error");
    }
    
    /**
     * Created by A-7605 on 23-2-18
     * This method check if the specified data contains in the table, even if the table contains pagination
     * @param data
     * @param column
     * @return
     */
    private boolean isDataContainsInTable(String data, int column){
    	boolean isFound = false;
    	loop:
    	while (true){
    		int rowCount = getTableRowCount(table_details);
    		for(int i=1; i<=rowCount; i++){
    			String currentCellVal = getTableCellValue(table_details, column, i);
    			if(currentCellVal.equals(data)){
    				isFound = true;
    				break loop;
    			}
    		}
    		if(verifyElementPresent(lnk_next)){
    			click(lnk_next);
    			maxWait();
    		}else
    			break;
    	}
    	return isFound;
    }
    
    /**
     * Created by A-7605 on 23-2-18
     * This method verify the claim details after filtering based on claimRefNo
     * @param claimRefNo
     * @param awbNo
     * @param nature
     * @param reasonCode
     * @param severity
     * @return
     */
    public CLM002 verifyClaimDetailsBasedOnClaimRefNo(String claimRefNo, String awbNo, String nature, String reasonCode, String severity){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	
    	enterKeys(txt_claimRefNo, claimRefNo);
    	click(btn_list);
    	minWait();
    	Assert.assertEquals(getTableCellValue(table_details, 4, 1), awbNo);
    	Assert.assertEquals(getTableCellValue(table_details, 9, 1), nature);
    	Assert.assertEquals(getTableCellValue(table_details, 10, 1), reasonCode);
    	Assert.assertEquals(getTableCellValue(table_details, 11, 1), severity);
    	return this;
    }
    
    /**
     * Created by A-7605 on 23-2-18
     * This method verify the claim details after filtering based on AWB No
     * @param awbNoPrefix
     * @param awbNo
     * @param claimRefNo
     * @param nature
     * @param reasonCode
     * @param severity
     * @return
     */
    public CLM002 verifyClaimDetailsBasesOnAWBNo(String awbNoPrefix,String awbNo, String claimRefNo, String nature, String reasonCode, String severity){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	
    	enterKeys(txt_awbNoPrefix, awbNoPrefix);
    	enterKeys(txt_AWBNo, awbNo);
    	click(btn_list);
    	minWait();
    	Assert.assertEquals(getTableCellValue(table_details, 4, 1), awbNo);
    	Assert.assertEquals(getTableCellValue(table_details, 9, 1), nature);
    	Assert.assertEquals(getTableCellValue(table_details, 10, 1), reasonCode);
    	Assert.assertEquals(getTableCellValue(table_details, 11, 1), severity);
    	return this;
    }
    
    /**
     * Created by A-7605 on 23-2-18
     * This method verify the claim details after filtering based on date range
     * @param fromDate
     * @param toDate
     * @param claimRefNo
     * @param awbNo
     * @param nature
     * @param reasonCode
     * @param severity
     * @return
     */
    public CLM002 verifyClaimDetailsBasesOnDateRange(String fromDate, String toDate,String claimRefNo, String awbNo, String nature, String reasonCode, String severity){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	fromDate = PropertyHandler.getPropValue(filepath, fromDate);
    	toDate = PropertyHandler.getPropValue(filepath, toDate);
    	
    	enterKeys(txt_fromDate, fromDate);
    	enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    	if(isDataContainsInTable(claimRefNo, 2)){
    		int rowNumber = getTableRowNumber(table_details, 2, claimRefNo);
    		Assert.assertEquals(getTableCellValue(table_details, 4, rowNumber), awbNo);
    		Assert.assertEquals(getTableCellValue(table_details, 9, rowNumber), nature);
    		Assert.assertEquals(getTableCellValue(table_details, 10, rowNumber), reasonCode);
    		Assert.assertEquals(getTableCellValue(table_details, 11, rowNumber), severity);
    	}
    	return this;
    }
    
    /**
     * Created by A-7605 on 23-2-18
     * This method verify the claim details after filtering based on region
     * @param region
     * @param claimRefNo
     * @param awbNo
     * @param nature
     * @param reasonCode
     * @param severity
     * @return
     */
    public CLM002 verifyClaimDetailsBasesOnRegion(String region,String claimRefNo, String awbNo, String nature, String reasonCode, String severity){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	region = PropertyHandler.getPropValue(filepath, region);
    	
    	enterKeys(txt_region, region);
    	click(btn_list);
    	minWait();
    	if(isDataContainsInTable(claimRefNo, 2)){
    		int rowNumber = getTableRowNumber(table_details, 2, claimRefNo);
    		Assert.assertEquals(getTableCellValue(table_details, 4, rowNumber), awbNo);
    		Assert.assertEquals(getTableCellValue(table_details, 9, rowNumber), nature);
    		Assert.assertEquals(getTableCellValue(table_details, 10, rowNumber), reasonCode);
    		Assert.assertEquals(getTableCellValue(table_details, 11, rowNumber), severity);
    	}
    	return this;
    }
    
    /**
     * Created by A-7605 on 23-2-18
     * This method verify the claim details after filtering based on nature
     * @param nature
     * @param claimRefNo
     * @param awbNo
     * @param reasonCode
     * @param severity
     * @return
     */
    public CLM002 verifyClaimDetailsBasesOnNature(String nature,String claimRefNo, String awbNo, String reasonCode, String severity){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	
    	selectByText(dropdown_nature, nature);
    	click(btn_list);
    	minWait();
    	if(isDataContainsInTable(claimRefNo, 2)){
    		int rowNumber = getTableRowNumber(table_details, 2, claimRefNo);
    		Assert.assertEquals(getTableCellValue(table_details, 4, rowNumber), awbNo);
    		Assert.assertEquals(getTableCellValue(table_details, 9, rowNumber), nature);
    		Assert.assertEquals(getTableCellValue(table_details, 10, rowNumber), reasonCode);
    		Assert.assertEquals(getTableCellValue(table_details, 11, rowNumber), severity);
    	}
    	return this;
    }
    
    /**
     * Created by A-7605 on 23-2-18
     * This method verify the claim details after filtering based on status
     * @param status
     * @param claimRefNo
     * @param awbNo
     * @param nature
     * @param reasonCode
     * @param severity
     * @return
     */
    public CLM002 verifyClaimDetailsBasesOnStatus(String status,String claimRefNo, String awbNo, String nature, String reasonCode, String severity){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	status = PropertyHandler.getPropValue(filepath, status);
    	
    	selectByText(dropdown_status, status);
    	waitForElement(txt_station).clear();
    	click(btn_list);
    	minWait();
    	if(isDataContainsInTable(claimRefNo, 2)){
    		int rowNumber = getTableRowNumber(table_details, 2, claimRefNo);
    		Assert.assertEquals(getTableCellValue(table_details, 4, rowNumber), awbNo);
    		Assert.assertEquals(getTableCellValue(table_details, 9, rowNumber), nature);
    		Assert.assertEquals(getTableCellValue(table_details, 10, rowNumber), reasonCode);
    		Assert.assertEquals(getTableCellValue(table_details, 11, rowNumber), severity);
    	}
    	return this;
    }
    
    /**
     * Created by A-7605 on 23-2-18
     * This method verify the claim details after filtering based on severity
     * @param severity
     * @param claimRefNo
     * @param awbNo
     * @param nature
     * @param reasonCode
     * @return
     */
    public CLM002 verifyClaimDetailsBasesOnSeverity( String severity,String claimRefNo, String awbNo, String nature, String reasonCode){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	
    	selectByText(dropdown_severity, severity);
    	click(btn_list);
    	minWait();
    	if(isDataContainsInTable(claimRefNo, 2)){
    		int rowNumber = getTableRowNumber(table_details, 2, claimRefNo);
    		Assert.assertEquals(getTableCellValue(table_details, 4, rowNumber), awbNo);
    		Assert.assertEquals(getTableCellValue(table_details, 9, rowNumber), nature);
    		Assert.assertEquals(getTableCellValue(table_details, 10, rowNumber), reasonCode);
    		Assert.assertEquals(getTableCellValue(table_details, 11, rowNumber), severity);
    	}
    	return this;
    }
    /**
     * Created by A-7605 on 23-2-18
     * This method verify the claim details without applying any filter
     * @param claimRefNo
     * @param awbNo
     * @param nature
     * @param reasonCode
     * @param severity
     * @return
     */
    public CLM002 verifyClaimDetailsWithoutApplyingAnyFilter(String claimRefNo, String awbNo, String nature, String reasonCode,String severity){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	
    	click(btn_list);
    	minWait();
    	if(isDataContainsInTable(claimRefNo, 2)){
    		int rowNumber = getTableRowNumber(table_details, 2, claimRefNo);
    		Assert.assertEquals(getTableCellValue(table_details, 4, rowNumber), awbNo);
    		Assert.assertEquals(getTableCellValue(table_details, 9, rowNumber), nature);
    		Assert.assertEquals(getTableCellValue(table_details, 10, rowNumber), reasonCode);
    		Assert.assertEquals(getTableCellValue(table_details, 11, rowNumber), severity);
    	}else
    		throw new AssertionError("The claim with Ref No: "+claimRefNo+" not found in the table");
    	return this;
    }
    /**
     * Created by A-7605 on 23-2-18
     * This method click on clear button and verify if all fields are cleared
     * @return
     */
    public CLM002 clear(){
    	click(btn_clear);
    	minWait();
    	Assert.assertEquals(getTableRowCount(table_details), 0);
    	Assert.assertEquals(waitForElementVisible(txt_claimRefNo).getAttribute("value").trim().length(), 0);
    	Assert.assertEquals(waitForElementVisible(txt_awbNoPrefix).getAttribute("value").trim().length(), 0);
    	Assert.assertEquals(waitForElementVisible(txt_AWBNo).getAttribute("value").trim().length(), 0);
    	Assert.assertEquals(waitForElementVisible(txt_HAWBNo).getAttribute("value").trim().length(), 0);
    	Assert.assertEquals(waitForElementVisible(txt_claimantCode).getAttribute("value").trim().length(), 0);
    	Assert.assertEquals(waitForElementVisible(txt_fromDate).getAttribute("value").trim().length(), 0);
    	Assert.assertEquals(waitForElementVisible(txt_toDate).getAttribute("value").trim().length(), 0);
    	Assert.assertEquals(waitForElementVisible(txt_region).getAttribute("value").trim().length(), 0);
    	return this;
    }
    
    /**
     * Created by A-7605 on 23-2-18
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
     * Created by A-7605 on 23-2-18
     * This method verifies if list, clear and close button are enabled, and 
     * @param loggedInStation
     * @return
     */
    public CLM002 checkBehaviourOnScreenLoad(String loggedInStation){
    	loggedInStation = PropertyHandler.getPropValue(filepath, loggedInStation);
    	
    	click(btn_list);
    	minWait();
    	Assert.assertEquals(waitForElementVisible(txt_station).getAttribute("value"), loggedInStation);
    	Assert.assertNull(waitForElementVisible(btn_list).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_clear).getAttribute("disabled"));
    	Assert.assertNull(waitForElementVisible(btn_close).getAttribute("disabled"));
    	return this;
    }
    
    /**
     * Created by A-7605 on 2-3-18
     * This method will check the error showing on clicking investigation details button for claims other than in new, acknowledged, under investigation and investigated
     * @param awbNoPrefix
     * @param awbNo
     * @return
     */
    public CLM002 checkErrorOnClickingInvestigationDetailsButtonForClaimsInInvalidStatus(String awbNoPrefix, String awbNo){
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	
    	enterKeys(txt_awbNoPrefix, awbNoPrefix);
    	enterKeys(txt_AWBNo, awbNo);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_investigationDetails);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Investigation details can be captured only for claims with status new or acknowledged or under investigation or investigated.");
    	click(btn_dialogueOk);
    	waitForFrameAndSwitch(FRAME_CLM002);
    	return this;
    }
    /**
     * Created by A-7605 on 5-3-18
     * This method will capture the recovery machanisam details
     * @param awbPrefix
     * @param awbNo
     * @param serviceRecMech
     * @param amount
     * @param currency
     * @param modeOfSettlement
     * @param remarks
     * @return
     */
    public CLM002 captureServiceRecoveryMechanisms(String awbPrefix, String awbNo, String serviceRecMech, String amount, String currency, String modeOfSettlement, String remarks){
    	awbPrefix = PropertyHandler.getPropValue(filepath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	serviceRecMech = PropertyHandler.getPropValue(filepath, serviceRecMech);
    	amount = PropertyHandler.getPropValue(filepath, amount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	modeOfSettlement = PropertyHandler.getPropValue(filepath, modeOfSettlement);
    	
    	enterKeys(txt_awbNoPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, awbNo);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_serviceRecoveryMech);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	selectByText(serviceRecoveryMachanisms_dropdown_ServiceRecMach, serviceRecMech);
    	enterKeys(serviceRecoveryMachanisms_txt_amountInvolved, amount);
    	selectByText(serviceRecoveryMachanisms_dropdown_currency, currency);
    	selectByText(serviceRecoveryMachanisms_dropdown_modeOfSettlement, modeOfSettlement);
    	enterKeys(serviceRecoveryMachanisms_txt_remarks, remarks);
    	click(serviceRecoveryMachanisms_btn_save);
    	minWait();
    	Assert.assertEquals(getNumberOfWindows(), 1);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME_CLM002);
    	return this;
    }
    
    /**
     * Created by A-7605 on 5-3-18
     * This method checks the error showing on trying to save service rec machanisam for claims other than in rejected status
     * @param awbPrefix
     * @param awbNo
     * @return
     */
    public CLM002 checkErrorOnClikingServiceRecMechButton(String awbPrefix, String awbNo){
    	awbPrefix = PropertyHandler.getPropValue(filepath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);

    	enterKeys(txt_awbNoPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, awbNo);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_serviceRecoveryMech);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Only claims with status Rejected can be Selected");
    	click(btn_dialogueOk);
    	waitForFrameAndSwitch(FRAME_CLM002);
    	return this;
    }
    /**
     * Created by A-7605 on 5-3-18
     * This method checkes close button functionality in Service Recovery Mechanisms popup
     * @param awbPrefix
     * @param awbNo
     * @return
     */
    public CLM002 checkCloseButtonFunctionalityInServiceRecoveryMachanismsPopup(String awbPrefix, String awbNo){
    	awbPrefix = PropertyHandler.getPropValue(filepath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	
    	enterKeys(txt_awbNoPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, awbNo);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_serviceRecoveryMech);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	click(serviceRecoveryMachanisms_btn_close);
    	minWait();
    	Assert.assertEquals(getNumberOfWindows(), 1);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME_CLM002);
    	return this;
    }
    /**
     * Created by A-7605 on 6-3-18
     * This method verify the attachment name and remark of a claim
     * @param awbPrefix
     * @param awbNo
     * @param fileName
     * @param remark
     * @return
     */
    public CLM002 verifyAttachmentDetails(String awbPrefix, String awbNo, String fileName, String remark){
    	awbPrefix = PropertyHandler.getPropValue(filepath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	fileName = PropertyHandler.getPropValue(filepath, fileName);
    	remark = PropertyHandler.getPropValue(filepath, remark);
    	
    	enterKeys(txt_awbNoPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, awbNo);
    	click(btn_list);
    	minWait();
    	click(icon_attachment);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	Assert.assertEquals(waitForElement(addAttachment_lnk_attachedFileName).getText().toLowerCase(), fileName.toLowerCase());
    	if(remark != null && remark.trim().length()>0)
    		Assert.assertEquals(waitForElement(addAttachment_txt_remark).getAttribute("value").toLowerCase(), remark.toLowerCase());
    	click(addAttachment_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME_CLM002);
    	return this;
    }
    /**
     * Created by A-7605 on 7-3-18
     * This method click on acknowledge claim/intent button and save the details
     * @param claimRefNo
     * @param emailID
     * @return
     */
    public CLM002 acknowledgeClaim(String claimRefNo,String emailID){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	emailID = PropertyHandler.getPropValue(filepath, emailID);
    	
    	enterKeys(txt_claimRefNo, claimRefNo);
    	click(btn_list);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_acknowledgeIntent);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(acknowledgeClaim_txt_email), emailID);
    	click(acknowledgeClaim_btn_save);
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Do you want to mark the Claim as Acknowledged");
    	click(btn_dialogueYes);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME_CLM002);
    	Assert.assertEquals(getClaimStatus(), "Acknowledged");
    	return this;
    }
    /**
     * Created by A-7605 on 7-3-18
     * This method verify the acknowledge status
     * @param claimRefNo
     * @param status
     * @return
     */
    public CLM002 checkAcknowlegeStatus(String claimRefNo,String status){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	status = PropertyHandler.getPropValue(filepath, status);
    	enterKeys(txt_claimRefNo, claimRefNo);
    	click(btn_list);
    	minWait();
    	Assert.assertEquals(getClaimStatus(), status);
    	return this;
    }
    
    private String getClaimStatus(){
    	return getTableCellValue(table_details, 14, 1);
    }
    
    
    
    private void listWithClaimRefNo(String claimRefNo){
    	enterKeys(txt_claimRefNo, claimRefNo);
    	click(btn_list);
    	minWait();
    }
    /**
     * Created by A-7605 on 7-3-18
     * This method check validation error showing on transferring claim to same airline
     * @param claimRefNo
     * @param airlineCode
     * @param transferDate
     * @return
     */
    public CLM002 checkSameAirlineCodeValidationOnTransferClaim(String claimRefNo, String airlineCode, String transferDate){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	airlineCode = PropertyHandler.getPropValue(filepath, airlineCode);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	waitForElement(txt_station).clear();
    	listWithClaimRefNo(claimRefNo);
    	check(chkbox_selectTableItem);
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
    	waitForFrameAndSwitch(FRAME_CLM002);
    	Assert.assertNotEquals(getClaimStatus().toLowerCase(), "transferred");
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
    public CLM002 transferClaimForAlreadyListedClaim(String airlineCode, String transferDate, String remarks){
    	airlineCode = PropertyHandler.getPropValue(filepath, airlineCode);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	click(btn_transferClaim);
    	check(chkbox_selectTableItem);
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
    	waitForFrameAndSwitch(FRAME_CLM002);
    	Assert.assertEquals(getClaimStatus().toLowerCase(), "transferred");
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
    public CLM002 transferClaimToOtherStation(String claimRefNo, String stationCode, String transferDate, String remarks){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	stationCode = PropertyHandler.getPropValue(filepath, stationCode);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	waitForElement(txt_station).clear();
    	listWithClaimRefNo(claimRefNo);
    	check(chkbox_selectTableItem);
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
    	waitForFrameAndSwitch(FRAME_CLM002);
    	Assert.assertEquals(getClaimStatus().toLowerCase(), "transferred");
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
    public CLM002 transferClaimToHeadQuarters(String claimRefNo, String headQuarters, String transferDate, String remarks){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	headQuarters = PropertyHandler.getPropValue(filepath, headQuarters);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	waitForElement(txt_station).clear();
    	listWithClaimRefNo(claimRefNo);
    	check(chkbox_selectTableItem);
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
    	waitForFrameAndSwitch(FRAME_CLM002);
    	Assert.assertEquals(getClaimStatus().toLowerCase(), "transferred");
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
    public CLM002 transferClaimToInsuranceAgent(String claimRefNo, String insuranceAgent, String transferDate, String remarks){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	insuranceAgent = PropertyHandler.getPropValue(filepath, insuranceAgent);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	waitForElement(txt_station).clear();
    	listWithClaimRefNo(claimRefNo);
    	check(chkbox_selectTableItem);
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
    	waitForFrameAndSwitch(FRAME_CLM002);
    	Assert.assertEquals(getClaimStatus().toLowerCase(), "transferred");
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
    public CLM002 transferClaimToLegal(String claimRefNo, String legal, String transferDate, String remarks){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	legal = PropertyHandler.getPropValue(filepath, legal);
    	transferDate = PropertyHandler.getPropValue(filepath, transferDate);
    	
    	waitForElement(txt_station).clear();
    	listWithClaimRefNo(claimRefNo);
    	check(chkbox_selectTableItem);
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
    	waitForFrameAndSwitch(FRAME_CLM002);
    	Assert.assertEquals(getClaimStatus().toLowerCase(), "transferred");
    	return this;
    }
    /**
     * Created by A-7605 on 7-3-18
     * This method verify the claim status
     * @param claimRefNo
     * @param expectedStatus
     * @return
     */
    public CLM002 verifyClaimStatus(String claimRefNo, String expectedStatus){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	expectedStatus = PropertyHandler.getPropValue(filepath, expectedStatus);
    	
    	waitForElement(txt_station).clear();
    	listWithClaimRefNo(claimRefNo);
    	verifyClaimStatusFromTable(expectedStatus);
    	return this;
    }
    
    private void verifyClaimStatusFromTable(String expectedStatus){
    	Assert.assertEquals(getClaimStatus().toLowerCase(), expectedStatus.toLowerCase());
    }
    private void doActionOnClaim(String claimRefNo, String action, String reason, String amount, String currency, String remark){
    	String warningMessage;
    	if(action.equals("Investigated")){
    		warningMessage = "Do you want to mark this claim as investigated";
    	}
    	else if(action.equals("Release Hold")){
    		warningMessage = "Do you want to release the hold on this claim";
    	}
    	else if(action.equals("On hold")){
    		warningMessage = "Do you want to hold this claim";
    	}
    	else if(action.equals("Under Investigation")){
    		warningMessage = "Do you want to mark this claim as under investigation";
    	}
    	else if(action.equals("Rejected")){
    		warningMessage = "Do you want to mark this claim as rejected";
    	}
    	else{
    		warningMessage = "Do you want to mark this claim as settled";
    	}
    	check(chkbox_selectTableItem);
    	click(btn_actionClaim);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	selectByText(waitForElement(actionClaims_dropdown_action), action);
    	if(reason != null && reason.trim().length()>0)
    		selectByText(actionClaims_dropdown_reason, reason);
    	enterKeys(actionClaims_txt_amount, amount);
    	selectByText(actionClaims_dropdown_currency, currency);
    	enterKeys(actionClaims_txt_remarks, remark);
    	click(actionClaims_btn_save);
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), warningMessage);
    	click(btn_dialogueYes);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME_CLM002);
    }
    /**
     * Created by A-7605 on9-3-18
     * This method click on the action claim button and change the status accordingly
     * @param claimRefNo
     * @param action
     * @param reason
     * @param amount
     * @param currency
     * @param remark
     * @return
     */
    public CLM002 actionClaim(String claimRefNo, String action, String reason, String amount, String currency, String remark){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	action = PropertyHandler.getPropValue(filepath, action);
    	reason = PropertyHandler.getPropValue(filepath, reason);
    	amount = PropertyHandler.getPropValue(filepath, amount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	
    	listWithClaimRefNo(claimRefNo);
    	doActionOnClaim(claimRefNo, action, reason, amount, currency, remark);
    	if(action.equalsIgnoreCase("Release Hold"))
    		action = "New";
    	verifyClaimStatusFromTable(action);
    	return this;
    }
    
    /**
     * Created by A-7605 on 15-3-18
     * This method verify the table fields in the Claims History pop up
     * @param claimRefNo
     * @return
     */
    public CLM002 verifyFieldsInClaimHistory(String claimRefNo){
    	List<String> tableHeaders;
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	
    	listWithClaimRefNo(claimRefNo);
    	check(chkbox_selectTableItem);
    	click(btn_claimHistory);
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
    	waitForFrameAndSwitch(FRAME_CLM002);
    	return this;
    }
    
    /**
     * Created by A-7605 on 15-3-18
     * This method check if history details are showing correctly in the table in Claim History pop up, the search is carried out based on the Action hence the method works well only if the action is unique in the table
     * @param claimRefNo
     * @param nature
     * @param status
     * @param action
     * @param doneBy
     * @return
     */
    public CLM002 verifyClaimHistory(String claimRefNo, String nature, String status, String action, String doneBy){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	status = PropertyHandler.getPropValue(filepath, status);
    	action = PropertyHandler.getPropValue(filepath, action);
    	doneBy = PropertyHandler.getPropValue(filepath, doneBy);
    	
    	listWithClaimRefNo(claimRefNo);
    	check(chkbox_selectTableItem);
    	click(btn_claimHistory);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	Assert.assertEquals(tblGetTextByColValue(claimHistory_table, 2, 4, action), nature);
    	Assert.assertEquals(tblGetTextByColValue(claimHistory_table, 3, 4, action), status);
    	Assert.assertEquals(tblGetTextByColValue(claimHistory_table, 5, 4, action), doneBy);
    	click(claimHistory_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME_CLM002);
    	return this;
    }
    
    
    /**
     * Created by A-7605 on 20-3-18
     * This method verify the claim details after selecting the claim from LOV
     * @param claimRefNo
     * @param awbNo
     * @param nature
     * @param reasonCode
     * @param severity
     * @return
     */
    public CLM002 verifyClaimDetailsBySelectingFromLOV(String claimRefNo, String awbNo, String nature, String reasonCode,String severity){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);

    	click(icon_claimReferenceNoLov);
    	waitForNewWindow(2);
    	driver.switchTo().defaultContent();
    	switchToSecondWindow();
    	enterKeys(waitForElement(claimReferenceNoLov_txt_claimRefNo), claimRefNo);
    	click(claimReferenceNoLov_btn_list);
    	minWait();
    	check(claimReferenceNoLov_chkbox_selectTableItem);
    	click(claimReferenceNoLov_btn_ok);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME_CLM002);
    	click(btn_list);
    	minWait();
    	if(isDataContainsInTable(claimRefNo, 2)){
    		int rowNumber = getTableRowNumber(table_details, 2, claimRefNo);
    		Assert.assertEquals(getTableCellValue(table_details, 4, rowNumber), awbNo);
    		Assert.assertEquals(getTableCellValue(table_details, 9, rowNumber), nature);
    		Assert.assertEquals(getTableCellValue(table_details, 10, rowNumber), reasonCode);
    		Assert.assertEquals(getTableCellValue(table_details, 11, rowNumber), severity);
    	}else
    		throw new AssertionError("The claim with Ref No: "+claimRefNo+" not found in the table");
    	return this;
    }
    /**
     * Created by A-7605 on 20-3-18
     * This method verify the claim details after listing with region
     * @param region
     * @param claimRefNo
     * @param awbNo
     * @param nature
     * @param reasonCode
     * @param severity
     * @return
     */
    public CLM002 verifyClaimDetailsBasedOnRegion(String region,String claimRefNo, String awbNo, String nature, String reasonCode,String severity){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	reasonCode = PropertyHandler.getPropValue(filepath, reasonCode);
    	severity = PropertyHandler.getPropValue(filepath, severity);
    	region = PropertyHandler.getPropValue(filepath, region);

    	click(icon_selectRegion);
    	waitForNewWindow(2);
    	driver.switchTo().defaultContent();
    	switchToSecondWindow();
    	enterKeys(waitForElement(selectRegion_txt_regionCode), region);
    	click(selectRegion_btn_list);
    	minWait();
    	check(selectRegion_chkbox_selectTableItem);
    	click(selectRegion_btn_ok);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME_CLM002);
    	click(btn_list);
    	minWait();
    	if(isDataContainsInTable(claimRefNo, 2)){
    		int rowNumber = getTableRowNumber(table_details, 2, claimRefNo);
    		Assert.assertEquals(getTableCellValue(table_details, 4, rowNumber), awbNo);
    		Assert.assertEquals(getTableCellValue(table_details, 9, rowNumber), nature);
    		Assert.assertEquals(getTableCellValue(table_details, 10, rowNumber), reasonCode);
    		Assert.assertEquals(getTableCellValue(table_details, 11, rowNumber), severity);
    	}else
    		throw new AssertionError("The claim with Ref No: "+claimRefNo+" not found in the table");
    	return this;
    }
    /**
     * Created by A-7605 on 21-3-18
     * This method verify the discrepancy details in an AWB from CLM002 screen
     * @param claimRefNo
     * @param station
     * @param flightNo
     * @param flightDate
     * @param discCode
     * @param discPcs
     * @param discWgt
     * @param mftPcs
     * @param mftWgt
     * @param rcvdPcs
     * @param rcvdWgt
     * @param status
     * @return
     */
    public CLM002 checkAWBDiscrepancyDetails(String claimRefNo,String station,String flightNo,String flightDate,String discCode,String discPcs,String discWgt,String mftPcs,String mftWgt,String rcvdPcs,String rcvdWgt,String status){
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
    	return viewDiscrepancy().verifyDescripancyDetails_CLM002(station, flightNo, flightDate, discCode, discPcs, discWgt, mftPcs, mftWgt, rcvdPcs, rcvdWgt, status);
    	
    }
    
    private OPR024 viewDiscrepancy(){
    	check(chkbox_selectTableItem);
    	click(btn_awbDiscrepancy);
    	minWait();
    	return new OPR024(driver, testDataFile);
    }
    
    private void listWithAWBNo(String awbPrefix, String awbNo){
    	enterKeys(txt_awbNoPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, awbNo);
    	click(btn_list);
    	minWait();
    }
    /**
     * Created by A-7605 on 21-3-18
     * This method verifies browser navigating into CLM003 screen on clicking details button
     * @param awbPrefix
     * @param awbNo
     * @param claimRefNo
     * @return
     */
    public CLM002 checkFunctionalityOfDetailsButton(String awbPrefix, String awbNo, String claimRefNo){
    	awbPrefix = PropertyHandler.getPropValue(filepath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	
    	listWithAWBNo(awbPrefix, awbNo);
    	check(chkbox_selectTableItem);
    	click(btn_details);
    	new WebDriverWait(driver, 60).until(ExpectedConditions.titleContains("Register Claim"));
    	new CLM003(driver, testDataFile).verifyClaimNoAndAWBDetails(claimRefNo, awbPrefix, awbNo);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_dialogueYes))
    		click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME_CLM002);
    	return this;
    }
    /**
     * Created by A-7605 on 21-3-18
     * This method click on investigation details button and verify the investigation result and status
     * @param claimRefNo
     * @param awbNoPrefix
     * @param awbNo
     * @param investigationResult
     * @param approvalCategory
     * @param status
     * @return
     */
    public CLM002 verifyInvestigationDetails(String claimRefNo, String awbNoPrefix, String awbNo, String investigationResult, String approvalCategory, String status, String nature, String claimantCode){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	awbNoPrefix = PropertyHandler.getPropValue(filepath, awbNoPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	investigationResult = PropertyHandler.getPropValue(filepath, investigationResult);
    	approvalCategory = PropertyHandler.getPropValue(filepath, approvalCategory);
    	status = PropertyHandler.getPropValue(filepath, status);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	claimantCode = PropertyHandler.getPropValue(filepath, claimantCode);
    	
    	listWithClaimRefNo(claimRefNo);
    	Assert.assertEquals(getTableCellValue(table_details, 14, 1), status);
    	check(chkbox_selectTableItem);
    	click(btn_investigationDetails);
    	new CLM001(driver, testDataFile).verifyInvestigationDetails(claimRefNo, awbNoPrefix, awbNo, investigationResult, approvalCategory, status, nature, claimantCode);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_dialogueYes))
    		click(btn_dialogueYes);   	
    	waitForFrameAndSwitch(FRAME_CLM002);
    	return this;
    }
}
