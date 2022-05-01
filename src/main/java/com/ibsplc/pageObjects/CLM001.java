package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CLM001 extends BasePage{

	public CLM001(WebDriver driver, String testDataFile) {
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
	public static String FRAME = "iCargoContentFrameCLM001";
	
	WebDriver driver;    
    String testDataFile;
    
    By txt_awbPrefix,
    txt_awbNo,
    btn_close,
    btn_list,
    txt_claimRefNo,
    dropdown_approvalCategory,
    txt_amountApproved,
    txt_remarks,
    txt_claimDetails,
    btn_save,
    txt_costCenter,
    btn_CostCenterLOV,
    selectCategory_table_costCenter,
    selectCategory_chkbox_ClaimDept,
    selectCategory_chkbox_Sales,
    selectCategory_chkbox_Station,
    selectCategory_btn_ok,
    info_error,
    btn_dialogueYes,
    btn_dialogueNo,
    btn_dialogueOk,
    info_dialogueContent,
    btn_currencyConverter,
    currancyConverter_txt_fromCurrencyCode,
    currancyConverter_txt_fromValue,
    currancyConverter_txt_toCurrencyCode,
    currancyConverter_txt_toValue,
    currancyConverter_btn_convert,
    currancyConverter_btn_close,
    btn_clear,
    btn_reportsAttached,
    txt_status,
    btn_transferClaim,
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
    btn_approveClaim,
    dropdown_investigationResult,
    btn_actionClaim,
    actionClaims_dropdown_action,
    actionClaims_dropdown_reason,
    actionClaims_txt_amount,
    actionClaims_dropdown_currency,
    actionClaims_txt_remarks,
    actionClaims_btn_save,
    actionClaims_btn_close,
    btn_claimHistory,
    claimHistory_lnk_add,
    claimHistory_lnk_delete,
    claimHistory_table,
    claimHistory_headerTable,
    claimHistory_btn_save,
    claimHistory_btn_close,
    btn_awbDetails,
    AWBEnquiry_txt_awbPrefix,
    AWBEnquiry_txt_awbNo,
    AWBEnquiry_table_Pcs,
    AWBEnquiry_info_agentCode,
    AWBEnquiry_info_statedPcsAndWeight,
    AWBEnquiry_info_acceptedPcsAndWeight,
    AWBEnquiry_info_deliveredPcsAndWeight,
    AWBEnquiry_btn_close,
    claimWarnings_btn_continue,
    dropdown_nature,
    txt_claimantCode;
    
    private void initPageElements(){
    	txt_awbPrefix = MiscUtility.getWebElement(objFilepath,"CLM001_txt_awbPrefix");
    	txt_awbNo = MiscUtility.getWebElement(objFilepath,"CLM001_txt_awbNo");
    	btn_close = MiscUtility.getWebElement(objFilepath,"CLM001_btn_close");
    	btn_list = MiscUtility.getWebElement(objFilepath,"CLM001_btn_list");
    	dropdown_approvalCategory = MiscUtility.getWebElement(objFilepath,"CLM001_dropdown_approvalCategory");
    	txt_amountApproved = MiscUtility.getWebElement(objFilepath,"CLM001_txt_amountApproved");
    	txt_remarks = MiscUtility.getWebElement(objFilepath,"CLM001_txt_remarks");
    	txt_claimDetails = MiscUtility.getWebElement(objFilepath,"CLM001_txt_claimDetails");
    	btn_save = MiscUtility.getWebElement(objFilepath,"CLM001_btn_save");
    	txt_claimRefNo = MiscUtility.getWebElement(objFilepath,"CLM001_txt_claimRefNo");
    	btn_CostCenterLOV = MiscUtility.getWebElement(objFilepath,"CLM001_btn_CostCenterLOV");
    	selectCategory_table_costCenter = MiscUtility.getWebElement(objFilepath,"CLM001_SelectCategory_table_costCenter");
    	selectCategory_chkbox_ClaimDept = MiscUtility.getWebElement(objFilepath,"CLM001_SelectCategory_chkbox_ClaimDept");
    	selectCategory_chkbox_Sales = MiscUtility.getWebElement(objFilepath,"CLM001_SelectCategory_chkbox_Sales");
    	selectCategory_chkbox_Station = MiscUtility.getWebElement(objFilepath,"CLM001_SelectCategory_chkbox_Station");
    	selectCategory_btn_ok = MiscUtility.getWebElement(objFilepath,"CLM001_SelectCategory_btn_ok");
    	txt_costCenter = MiscUtility.getWebElement(objFilepath,"CLM001_txt_costCenter");
    	btn_currencyConverter = MiscUtility.getWebElement(objFilepath,"CLM001_btn_currencyConverter");
        currancyConverter_txt_fromCurrencyCode = MiscUtility.getWebElement(objFilepath,"CLM001_CurrancyConverter_txt_fromCurrencyCode");
        currancyConverter_txt_fromValue = MiscUtility.getWebElement(objFilepath,"CLM001_CurrancyConverter_txt_fromValue");
        currancyConverter_txt_toCurrencyCode = MiscUtility.getWebElement(objFilepath,"CLM001_CurrancyConverter_txt_toCurrencyCode");
        currancyConverter_txt_toValue = MiscUtility.getWebElement(objFilepath,"CLM001_CurrancyConverter_txt_toValue");
        currancyConverter_btn_convert = MiscUtility.getWebElement(objFilepath,"CLM001_CurrancyConverter_btn_convert");
        currancyConverter_btn_close = MiscUtility.getWebElement(objFilepath,"CLM001_CurrancyConverter_btn_close");
        btn_clear = MiscUtility.getWebElement(objFilepath,"CLM001_btn_clear");
        btn_reportsAttached = MiscUtility.getWebElement(objFilepath,"CLM001_btn_reportsAttached");
        txt_status = MiscUtility.getWebElement(objFilepath,"CLM001_txt_status");
        btn_transferClaim = MiscUtility.getWebElement(objFilepath,"CLM001_btn_transferClaim");
        transfer_option_airlineCode = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_option_airlineCode");
        transfer_txt_airlineCode = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_txt_airlineCode");
        transfer_option_stationCode = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_option_stationCode");
        transfer_txt_stationCode = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_txt_stationCode");
        transfer_option_headQuarters = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_option_headQuarters");
        transfer_txt_headQuarters = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_txt_headQuarters");
        transfer_option_insuranceAgent = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_option_insuranceAgent");
        transfer_txt_insuranceAgent = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_txt_insuranceAgent");
        transfer_option_legal = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_option_legal");
        transfer_txt_legal = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_txt_legal");
        transfer_txt_transferDate = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_txt_transferDate");
        transfer_txt_remarks = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_txt_remarks");
        transfer_btn_save = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_btn_save");
        transfer_btn_close = MiscUtility.getWebElement(objFilepath,"CLM001_Transfer_btn_close");
        dropdown_investigationResult = MiscUtility.getWebElement(objFilepath,"CLM001_dropdown_investigationResult");
        btn_approveClaim = MiscUtility.getWebElement(objFilepath,"CLM001_btn_approveClaim");
        btn_actionClaim = MiscUtility.getWebElement(objFilepath,"CLM001_btn_actionClaim");
        actionClaims_dropdown_action = MiscUtility.getWebElement(objFilepath,"CLM001_ActionClaims_dropdown_action");
        actionClaims_dropdown_reason = MiscUtility.getWebElement(objFilepath,"CLM001_ActionClaims_dropdown_reason");
        actionClaims_txt_amount = MiscUtility.getWebElement(objFilepath,"CLM001_ActionClaims_txt_amount");
        actionClaims_dropdown_currency = MiscUtility.getWebElement(objFilepath,"CLM001_ActionClaims_dropdown_currency");
        actionClaims_txt_remarks = MiscUtility.getWebElement(objFilepath,"CLM001_ActionClaims_txt_remarks");
        actionClaims_btn_save = MiscUtility.getWebElement(objFilepath,"CLM001_ActionClaims_btn_save");
        actionClaims_btn_close = MiscUtility.getWebElement(objFilepath,"CLM001_ActionClaims_btn_close");
        btn_claimHistory = MiscUtility.getWebElement(objFilepath,"CLM001_btn_claimHistory");
        claimHistory_lnk_add = MiscUtility.getWebElement(objFilepath,"CLM001_ClaimHistory_lnk_add");
        claimHistory_lnk_delete = MiscUtility.getWebElement(objFilepath,"CLM001_ClaimHistory_lnk_delete");
        claimHistory_table = MiscUtility.getWebElement(objFilepath,"CLM001_ClaimHistory_table");
        claimHistory_headerTable = MiscUtility.getWebElement(objFilepath,"CLM001_ClaimHistory_headerTable");
        claimHistory_btn_save = MiscUtility.getWebElement(objFilepath,"CLM001_ClaimHistory_btn_save");
        claimHistory_btn_close = MiscUtility.getWebElement(objFilepath,"CLM001_ClaimHistory_btn_close");
        btn_awbDetails = MiscUtility.getWebElement(objFilepath,"CLM001_btn_awbDetails");
        AWBEnquiry_txt_awbPrefix = MiscUtility.getWebElement(objFilepath,"CLM001_AWBEnquiry_txt_awbPrefix");
        AWBEnquiry_txt_awbNo = MiscUtility.getWebElement(objFilepath,"CLM001_AWBEnquiry_txt_awbNo");
        AWBEnquiry_table_Pcs = MiscUtility.getWebElement(objFilepath,"CLM001_AWBEnquiry_table_Pcs");
        AWBEnquiry_info_agentCode = MiscUtility.getWebElement(objFilepath,"CLM001_AWBEnquiry_info_agentCode");
        AWBEnquiry_info_statedPcsAndWeight = MiscUtility.getWebElement(objFilepath,"CLM001_AWBEnquiry_info_statedPcsAndWeight");
        AWBEnquiry_info_acceptedPcsAndWeight = MiscUtility.getWebElement(objFilepath,"CLM001_AWBEnquiry_info_acceptedPcsAndWeight");
        AWBEnquiry_info_deliveredPcsAndWeight = MiscUtility.getWebElement(objFilepath,"CLM001_AWBEnquiry_info_deliveredPcsAndWeight");
        AWBEnquiry_btn_close = MiscUtility.getWebElement(objFilepath,"CLM001_AWBEnquiry_btn_close");
        claimWarnings_btn_continue = MiscUtility.getWebElement(objFilepath,"CLM001_claimWarnings_btn_continue");
        dropdown_nature = MiscUtility.getWebElement(objFilepath,"CLM001_dropdown_nature");
        txt_claimantCode = MiscUtility.getWebElement(objFilepath,"CLM001_txt_claimantCode");
    	
    	info_error = MiscUtility.getWebElement(genFilepath,"Generic_info_error");
    	btn_dialogueYes = MiscUtility.getWebElement(genFilepath,"Generic_btn_diaYes");
        btn_dialogueNo = MiscUtility.getWebElement(genFilepath,"Generic_btn_noBtn");
        btn_dialogueOk = MiscUtility.getWebElement(genFilepath,"Generic_btn_ok");
        info_dialogueContent = MiscUtility.getWebElement(genFilepath,"Generic_info_msg");
    }
    /**
     * Created by A-7605 on 5-3-18
     * This method lists with AWB No
     * @param awbPrefix
     * @param awbNo
     */
    private void listWithAWBNo(String awbPrefix, String awbNo){
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_list);
    	minWait();
    }
    /**
     * Created by A-7605 on 5-3-18
     * This method lists with claim ref no
     * @param claimRefNo
     */
    private void listWithClaimRefNo(String claimRefNo){
    	enterKeys(txt_claimRefNo, claimRefNo);
    	click(btn_list);
    	minWait();
    }
    /**
     * Created by A-7605 on 5-3-18
     * This method verifies the error shown on listing with intent claim
     * @param awbPrefix
     * @param awbNo
     * @return
     */
    public CLM001 checkErrorShowingOnListingWithIntentClaim(String claimRefNo){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	listWithClaimRefNo(claimRefNo);
    	Assert.assertEquals(waitForElement(info_error).getText(), "Investigation details cannot be captured for an intent of claim.");
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
     * Created by A-7605 on 5-3-18
     * This method saves details after entering approved category, amount approved, remarks and claim details
     * @param claimRefNo
     * @param approvalCategory
     * @param amountApproved
     * @param claimDetails
     * @param remarks
     * @return
     */
    public CLM001 updateInvestigationDetails(String claimRefNo,String approvalCategory, String amountApproved, String claimDetails, String remarks){
    	
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	approvalCategory = PropertyHandler.getPropValue(filepath, approvalCategory);
    	amountApproved = PropertyHandler.getPropValue(filepath, amountApproved);
    	claimDetails = PropertyHandler.getPropValue(filepath, claimDetails);
    	listWithClaimRefNo(claimRefNo);
    	
    	selectByText(dropdown_approvalCategory, approvalCategory);
    	enterKeys(txt_amountApproved, amountApproved);
    	enterKeys(txt_remarks, remarks);
    	enterKeys(txt_claimDetails, claimDetails);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Investigation Details updated successfully. Do you wish to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(getSelectedValue(waitForElement(dropdown_approvalCategory)), approvalCategory);
    	Assert.assertEquals(waitForElement(txt_amountApproved).getAttribute("value").replaceAll(",", "").toLowerCase(), amountApproved.toLowerCase());
    	Assert.assertEquals(waitForElement(txt_remarks).getAttribute("value").toLowerCase(), remarks.toLowerCase());
    	Assert.assertEquals(waitForElement(txt_claimDetails).getAttribute("value").toLowerCase(), claimDetails.toLowerCase());
    	return this;
    }
    /**
     * Created by A-7605 on 5-3-18
     * This method verify if CostCenter LOV contains the values Claim Dept, Station and Sales and update the details with a cost center
     * @param claimRefNo
     * @param costCenter
     * @return
     */
    public CLM001 updateCostCenter(String claimRefNo, String costCenter){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	costCenter = PropertyHandler.getPropValue(filepath, costCenter);
    	listWithClaimRefNo(claimRefNo);
    	click(btn_CostCenterLOV);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	List<String> colValues = getTableColumnValues(selectCategory_table_costCenter, 2);
    	Assert.assertTrue(colValues.contains("Claim Dept"));
    	Assert.assertTrue(colValues.contains("Station"));
    	Assert.assertTrue(colValues.contains("Sales"));
    	
    	if(costCenter.equals("Claim Dept"))
    		check(selectCategory_chkbox_ClaimDept);
    	else if(costCenter.equals("Sales"))
    		check(selectCategory_chkbox_Sales);
    	else 
    		check(selectCategory_chkbox_Station);
    	click(selectCategory_btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Investigation Details updated successfully. Do you wish to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElementVisible(txt_costCenter).getAttribute("value").toLowerCase(), costCenter.toLowerCase());
    	return this;
    }
    /**
     * Created by A-7605 on 6-3-18
     * This method covert currency from given formCurrencyCode to toCurrencyCode and verify the result
     * @param claimRefNo
     * @param fromCurrencyCode
     * @param toCurrencyCode
     * @param conversionFromVal
     * @param conversionFactor
     * @return
     */
    public CLM001 checkCurrencyConvertFunctionality(String claimRefNo, String fromCurrencyCode, String toCurrencyCode, String conversionFromVal, String conversionFactor){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	fromCurrencyCode = PropertyHandler.getPropValue(filepath, fromCurrencyCode);
    	toCurrencyCode = PropertyHandler.getPropValue(filepath, toCurrencyCode);
    	conversionFromVal = PropertyHandler.getPropValue(filepath, conversionFromVal);
    	conversionFactor = PropertyHandler.getPropValue(filepath, conversionFactor);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_currencyConverter);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(currancyConverter_txt_fromCurrencyCode, fromCurrencyCode);
    	enterKeys(currancyConverter_txt_fromValue, conversionFromVal);
    	enterKeys(currancyConverter_txt_toCurrencyCode, toCurrencyCode);
    	click(currancyConverter_btn_convert);
    	minWait();
    	Double actualValue = Double.parseDouble(waitForElementVisible(currancyConverter_txt_toValue).getAttribute("value"));
    	click(currancyConverter_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	Double expectedValue = Double.parseDouble(conversionFromVal) * Double.parseDouble(conversionFactor);
    	Assert.assertEquals(actualValue, expectedValue);
    	return this;
    }
    /**
     * Created by A-7605 on 6-3-18
     * This method click on clear button and verify claim ref no, awb prefix and awb no fields are cleared and save button is disabled
     * @return
     */
    public CLM001 clear(){
    	click(btn_clear);
    	minWait();
    	Assert.assertEquals(waitForElementVisible(txt_claimRefNo).getText().trim().length(), 0);
    	Assert.assertEquals(waitForElementVisible(txt_awbPrefix).getText().trim().length(), 0);
    	Assert.assertEquals(waitForElementVisible(txt_awbNo).getText().trim().length(), 0);
    	Assert.assertNotNull(waitForElementVisible(btn_save).getAttribute("disabled"));
    	return this;
    }
    /**
     * Created by A-7605 on 6-3-18
     * This method check mandatory field validation for From Value field in Currency Converter popup
     * @param claimRefNo
     * @param fromCurrencyCode
     * @param toCurrencyCode
     * @return
     */
    public CLM001 checkMandatoryFieldValidationInFromValueFieldInCurrencyConverter(String claimRefNo, String fromCurrencyCode, String toCurrencyCode){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	fromCurrencyCode = PropertyHandler.getPropValue(filepath, fromCurrencyCode);
    	toCurrencyCode = PropertyHandler.getPropValue(filepath, toCurrencyCode);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_currencyConverter);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(currancyConverter_txt_fromCurrencyCode, fromCurrencyCode);
    	enterKeys(currancyConverter_txt_toCurrencyCode, toCurrencyCode);
    	click(currancyConverter_btn_convert);
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Either the From CurrencyCode or To CurrencyCode or FromValue is not specified.Please specify it!");
    	click(btn_dialogueOk);
    	click(currancyConverter_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    /**
     * Created by A-7605 on 6-3-18
     * This method attach file to the investigation details
     * @param claimRefNo
     * @param fullFilePath
     * @param uploadedFileName
     * @return
     */
    public CLM001 attachFile(String claimRefNo, String fullFilePath, String uploadedFileName){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	fullFilePath = PropertyHandler.getPropValue(filepath, fullFilePath);
    	uploadedFileName = PropertyHandler.getPropValue(filepath, uploadedFileName);
    	
    	String fileName;
    	try{
    		fileName = fullFilePath.substring(fullFilePath.lastIndexOf("\\")+1,fullFilePath.length());
    	}catch(IndexOutOfBoundsException e){
    		fileName = fullFilePath.substring(fullFilePath.lastIndexOf("/")+1,fullFilePath.length());
    	}
    	PropertyHandler.setPropValue(filepath, uploadedFileName, fileName);
    	listWithClaimRefNo(claimRefNo);
    	waitForElement(btn_reportsAttached).sendKeys(fullFilePath);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Investigation Details updated successfully. Do you wish to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this;
    }
    
    private String getClaimStatus(){
    	return waitForElementVisible(txt_status).getAttribute("value");
    }
    
    /**
     * Created by A-7605 on 7-3-18
     * This method check validation error showing on transferring claim to same airline
     * @param claimRefNo
     * @param airlineCode
     * @param transferDate
     * @return
     */
    public CLM001 checkSameAirlineCodeValidationOnTransferClaim(String claimRefNo, String airlineCode, String transferDate){
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
//    	Assert.assertNotEquals(getClaimStatus().toLowerCase(), "transferred");
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
    public CLM001 transferClaimForAlreadyListedClaim(String airlineCode, String transferDate, String remarks){
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
    public CLM001 transferClaimToOtherStation(String claimRefNo, String stationCode, String transferDate, String remarks){
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
//    	Assert.assertEquals(getClaimStatus().toLowerCase(), "transferred");
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
    public CLM001 transferClaimToHeadQuarters(String claimRefNo, String headQuarters, String transferDate, String remarks){
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
//    	Assert.assertEquals(getClaimStatus().toLowerCase(), "transferred");
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
    public CLM001 transferClaimToInsuranceAgent(String claimRefNo, String insuranceAgent, String transferDate, String remarks){
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
//    	Assert.assertEquals(getClaimStatus().toLowerCase(), "transferred");
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
    public CLM001 transferClaimToLegal(String claimRefNo, String legal, String transferDate, String remarks){
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
//    	Assert.assertEquals(getClaimStatus().toLowerCase(), "transferred");
    	return this;
    }
    /**
     * Created by A-7605 on 7-3-18
     * This method verify the claim status
     * @param claimRefNo
     * @param expectedStatus
     * @return
     */
    public CLM001 verifyClaimStatus(String claimRefNo, String expectedStatus){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	expectedStatus = PropertyHandler.getPropValue(filepath, expectedStatus);
    	listWithClaimRefNo(claimRefNo);
    	Assert.assertEquals(getClaimStatus().toLowerCase(), expectedStatus.toLowerCase());
    	return this;
    }
    /**
     * Created by A-7605 on 7-3-18
     * This method approve a claim in investigated status
     * @param claimRefNo
     * @return
     */
    public CLM001 approveClaim(String claimRefNo){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	
    	listWithClaimRefNo(claimRefNo);
    	selectByText(dropdown_investigationResult, "Approved");
    	selectByIndex(dropdown_approvalCategory, 1);
    	click(btn_approveClaim);
    	minWait();
    	Assert.assertEquals(waitForElementVisible(txt_status).getAttribute("value"), "Approved");
    	return this;
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
    public CLM001 actionClaim(String claimRefNo, String action, String reason, String amount, String currency, String remark){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	action = PropertyHandler.getPropValue(filepath, action);
    	reason = PropertyHandler.getPropValue(filepath, reason);
    	amount = PropertyHandler.getPropValue(filepath, amount);
    	currency = PropertyHandler.getPropValue(filepath, currency);
    	
    	listWithClaimRefNo(claimRefNo);
    	doActionOnClaim(claimRefNo, action, reason, amount, currency, remark);
//    	if(action.equalsIgnoreCase("Release Hold"))
//    		action = "New";
//    	Assert.assertEquals(getClaimStatus(), action);
    	return this;
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
    	waitForFrameAndSwitch(FRAME);
    }
    
    /**
     * Created by A-7605 on 16-3-18
     * This method verify the table fields in the Claims History pop up
     * @param claimRefNo
     * @return
     */
    public CLM001 verifyFieldsInClaimHistory(String claimRefNo){
    	List<String> tableHeaders;
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	
    	listWithClaimRefNo(claimRefNo);
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
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605 on 16-3-18
     * This method check if history details are showing correctly in the table in Claim History pop up, the search is carried out based on the Action hence the method works well only if the action is unique in the table
     * @param claimRefNo
     * @param nature
     * @param status
     * @param action
     * @param doneBy
     * @return
     */
    public CLM001 verifyClaimHistory(String claimRefNo, String nature, String status, String action, String doneBy){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	nature = PropertyHandler.getPropValue(filepath, nature);
    	status = PropertyHandler.getPropValue(filepath, status);
    	action = PropertyHandler.getPropValue(filepath, action);
    	doneBy = PropertyHandler.getPropValue(filepath, doneBy);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_claimHistory);
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
     * Created by A-7605 on 19-3-18
     * This method verifies the AWB details showing in the AWB Enquiry pop up. The awb pcs should be accepted but not manifested
     * @param claimRefNo
     * @param awbPrefix
     * @param awbNo
     * @param agentCode
     * @return
     */
    public CLM001 verifyAWBDetails(String claimRefNo,String awbPrefix, String awbNo, String agentCode){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);    	
    	awbPrefix = PropertyHandler.getPropValue(filepath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(filepath, awbNo);
    	agentCode = PropertyHandler.getPropValue(filepath, agentCode);
    	
    	listWithClaimRefNo(claimRefNo);
    	click(btn_awbDetails);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	Assert.assertEquals(waitForElement(AWBEnquiry_txt_awbPrefix).getAttribute("value"), awbPrefix);
    	Assert.assertEquals(waitForElement(AWBEnquiry_txt_awbNo).getAttribute("value"), awbNo);
    	Assert.assertEquals(waitForElement(AWBEnquiry_info_agentCode).getText(), agentCode);
    	System.out.print((waitForElement(AWBEnquiry_info_statedPcsAndWeight).getText()));
    	Assert.assertTrue(waitForElement(AWBEnquiry_info_statedPcsAndWeight).getText().contains("10 /100"));
    	Assert.assertTrue(waitForElement(AWBEnquiry_info_acceptedPcsAndWeight).getText().contains("10 /100"));
    	Assert.assertTrue(waitForElement(AWBEnquiry_info_deliveredPcsAndWeight).getText().contains("0 /0"));
    	Assert.assertEquals(getTableCellValue(AWBEnquiry_table_Pcs, 2, 1).trim(), "0/0");
    	Assert.assertEquals(getTableCellValue(AWBEnquiry_table_Pcs, 3, 1).trim(), "0/0");
    	Assert.assertEquals(getTableCellValue(AWBEnquiry_table_Pcs, 4, 1).trim(), "0/0");
    	Assert.assertEquals(getTableCellValue(AWBEnquiry_table_Pcs, 5, 1).trim(), "10/100");
    	click(AWBEnquiry_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    /**
     * Created by A-7605 on 19-3-18
     * This method update investigation result and amount approved of the claim
     * @param claimRefNo
     * @param investigationResult
     * @param amountApproved
     * @return
     */
    public CLM001 updateInvestigationResult(String claimRefNo, String investigationResult, String amountApproved, String expectedClaimStatus){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	investigationResult = PropertyHandler.getPropValue(filepath, investigationResult);
    	amountApproved = PropertyHandler.getPropValue(filepath, amountApproved);
    	expectedClaimStatus = PropertyHandler.getPropValue(filepath, amountApproved);
    	
    	listWithClaimRefNo(claimRefNo);
    	selectByText(dropdown_investigationResult, investigationResult);
    	enterKeys(txt_amountApproved, amountApproved);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	minWait();
    	if(investigationResult.equals("Approved") && getNumberOfWindows()==2){
    		switchToSecondWindow();
    		click(claimWarnings_btn_continue); 
    		switchToFirstWindow();
    	}
    	minWait();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Investigation Details updated successfully. Do you wish to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
//    	Assert.assertEquals(waitForElementVisible(txt_status).getAttribute("value"), expectedClaimStatus);
    	Assert.assertEquals(getSelectedValue(dropdown_investigationResult), investigationResult);
    	Assert.assertEquals(waitForElementVisible(txt_amountApproved).getAttribute("value").replaceAll(",", ""), amountApproved);
    	return this;
    }
    /**
     * Created by A-7605 on 19-3-18
     * This method verifies investigation result and amount approved of the claim
     * @param claimRefNo
     * @param investigationResult
     * @param amountApproved
     * @return
     */
    public CLM001 verifyInvestigationResult(String claimRefNo, String investigationResult, String amountApproved, String expectedClaimStatus){
    	claimRefNo = PropertyHandler.getPropValue(filepath, claimRefNo);
    	investigationResult = PropertyHandler.getPropValue(filepath, investigationResult);
    	amountApproved = PropertyHandler.getPropValue(filepath, amountApproved);
    	expectedClaimStatus = PropertyHandler.getPropValue(filepath, expectedClaimStatus);
    	
    	listWithClaimRefNo(claimRefNo);
    	Assert.assertEquals(waitForElementVisible(txt_status).getAttribute("value"),expectedClaimStatus);
    	Assert.assertEquals(getSelectedValue(dropdown_investigationResult), investigationResult);
    	Assert.assertEquals(waitForElementVisible(txt_amountApproved).getAttribute("value").replaceAll(",", ""), amountApproved);
    	return this;
    }
    
    public CLM002 verifyInvestigationDetails(String claimRefNo, String awbPrefix, String awbNo, String investigationResult, String approvalCategory, String status, String nature, String claimantCode){
    	Assert.assertEquals(waitForElementVisible(txt_claimRefNo).getAttribute("value"), claimRefNo);
    	Assert.assertEquals(waitForElementVisible(txt_awbPrefix).getAttribute("value"), awbPrefix);
    	Assert.assertEquals(waitForElementVisible(txt_awbNo).getAttribute("value"), awbNo);
    	Assert.assertEquals(getSelectedValue(dropdown_investigationResult), investigationResult);
    	if(approvalCategory != null && approvalCategory.trim().length()>0)
    		Assert.assertEquals(getSelectedValue(dropdown_approvalCategory), approvalCategory);
    	Assert.assertEquals(getSelectedValue(dropdown_nature), nature);
    	Assert.assertEquals(waitForElementVisible(txt_status).getAttribute("value"), status);
    	Assert.assertEquals(waitForElementVisible(txt_claimantCode).getAttribute("value"), claimantCode);
    	click(btn_close);
    	return new CLM002(driver, testDataFile);
    }
   
}
