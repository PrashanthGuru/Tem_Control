package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


/**
 * Screen OPR026 - CAPTURE AWB
 * Created on 21/12/2017
 *
 * @author a-7868
 */
public class CRA175 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA032";
    public static String screenFrame = "iCargoContentFrameCRA032";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By text_fromDate,
    text_toDate,text_shipmentPrefix,text_documentNumber,
    btn_btnList,tbl_listInterlineEntries,yesBtn,
    dropdown_billingType,
    chkbx_selectawb,
    btn_issueBillingMemo,
    Generic_info_error,
    Generic_info_error2,
    btn_ViewProration,
    chargeMemo_btn_close,
    btn_CCA,
    viewProration_btn_close,
     btn_changeStatus,
     dropdown_selectStatusPopup,
     btn_closeChangeStatusPopup,
    txt_RemarksChangeStatus,
     btn_saveChangeStatusPopup,
     dropdown_MOP,
     dropdown_AWBStatus,
     txt_sectorFrom,
     txt_sectorTo,
     chkbx_SPAInclude,
     chkbx_provisoReqstInclude,
     txt_SPANumbr,
     btn_sectorFromlov,
     btn_sectorTolov,
     btn_calendarFromDate,
     btn_calendarToDate,
     chkbx_sectorSelect,
     btn_sectrClose,
     txt_airline,
     Generic_info_msg,
    btn_clear,
    CCA_btn_close,
    btn_SPAlov,
    btn_CloseSPAlov,
    btn_provisoLov,
    btn_closeProvisoLov,
    btn_print,
    btn_viewProration,
    txt_dateRangeFrom,
    txt_dateRangeTo,
    btn_awbEnquiry,
    btn_airlineLov,
   viewProration_info_pay,
   viewProration_info_payReceive,
    btn_closeAirlineLov,

    btn_btnClose;
   
    public CRA175(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    /**
     * Initializes the page objects required for the class
     */
    private void initElements() {
    	
    	yesBtn                     = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	text_fromDate              = MiscUtility.getWebElement(objFilepath,"CRA175_text_fromDate");
    	text_toDate                = MiscUtility.getWebElement(objFilepath,"CRA175_text_toDate");
    	text_shipmentPrefix        = MiscUtility.getWebElement(objFilepath,"CRA175_text_shipmentPrefix");
    	text_documentNumber        = MiscUtility.getWebElement(objFilepath, "CRA175_text_documentNumber");
    	 
    	btn_btnList                = MiscUtility.getWebElement(objFilepath,"CRA175_btn_btnList");
    	tbl_listInterlineEntries   = MiscUtility.getWebElement(objFilepath,"CRA175_tbl_listInterlineEntries");
    	btn_btnClose               = MiscUtility.getWebElement(objFilepath,"CRA175_btn_btnClose");
    	dropdown_billingType       = MiscUtility.getWebElement(objFilepath, "CRA175_dropdown_billingType");
    	btn_issueBillingMemo       = MiscUtility.getWebElement(objFilepath, "CRA175_btn_issueBillingMemo");
    	chkbx_selectawb            = MiscUtility.getWebElement(objFilepath, "CRA175_chkbx_selectawb");
    	chargeMemo_btn_close       = MiscUtility.getWebElement(objFilepath, "CRA175_chargeMemo_btn_close");
    	Generic_info_error         = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    	Generic_info_error2        = MiscUtility.getWebElement(genObjPath, "Generic_info_error2");
    	//Generic_info_error2        = MiscUtility.getWebElement(objFilepath, "Generic_info_error2");
    	btn_ViewProration          = MiscUtility.getWebElement(objFilepath, "CRA175_btn_ViewProration");
    	btn_CCA                    = MiscUtility.getWebElement(objFilepath, "CRA175_btn_CCA");
    	viewProration_btn_close    = MiscUtility.getWebElement(objFilepath, "CRA175_viewProration_btn_close");
    	CCA_btn_close              = MiscUtility.getWebElement(objFilepath, "CRA175_CCA_btn_close");
    	btn_clear                  = MiscUtility.getWebElement(objFilepath, "CRA175_btn_clear");
    	btn_changeStatus           = MiscUtility.getWebElement(objFilepath, "CRA175_btn_changeStatus");
    	dropdown_selectStatusPopup = MiscUtility.getWebElement(objFilepath, "CRA175_dropdown_selectStatusPopup");
    	txt_RemarksChangeStatus    = MiscUtility.getWebElement(objFilepath, "CRA175_txt_RemarksChangeStatus");
    	btn_saveChangeStatusPopup  = MiscUtility.getWebElement(objFilepath, "CRA175_btn_saveChangeStatusPopup");
    	btn_closeChangeStatusPopup = MiscUtility.getWebElement(objFilepath, "CRA175_btn_closeChangeStatusPopup");
    	dropdown_MOP               = MiscUtility.getWebElement(objFilepath, "CRA175_dropdown_MOP");
        dropdown_AWBStatus         = MiscUtility.getWebElement(objFilepath, "CRA175_dropdown_AWBStatus");
        txt_sectorFrom             = MiscUtility.getWebElement(objFilepath, "CRA175_txt_sectorFrom");
        txt_sectorTo               = MiscUtility.getWebElement(objFilepath, "CRA175_txt_sectorTo");
        chkbx_SPAInclude           = MiscUtility.getWebElement(objFilepath, "CRA175_chkbx_SPAInclude");
        chkbx_provisoReqstInclude  = MiscUtility.getWebElement(objFilepath, "CRA175_chkbx_provisoReqstInclude");
        txt_SPANumbr               = MiscUtility.getWebElement(objFilepath, "CRA175_txt_SPANumbr");
        btn_sectorFromlov          = MiscUtility.getWebElement(objFilepath, "CRA175_btn_sectorFromlov");
        btn_sectorTolov            = MiscUtility.getWebElement(objFilepath, "CRA175_btn_sectorTolov");
        btn_calendarFromDate       = MiscUtility.getWebElement(objFilepath, "CRA175_btn_calendarFromDate");
        btn_calendarToDate         = MiscUtility.getWebElement(objFilepath, "CRA175_btn_calendarToDate");
        chkbx_sectorSelect         = MiscUtility.getWebElement(objFilepath, "CRA175_chkbx_sectorSelect");
        btn_sectrClose             = MiscUtility.getWebElement(objFilepath, "CRA175_btn_sectrClose");
        txt_airline                = MiscUtility.getWebElement(objFilepath, "CRA175_txt_airline");
        btn_SPAlov                 = MiscUtility.getWebElement(objFilepath, "CRA175_btn_SPAlov");
        btn_CloseSPAlov            = MiscUtility.getWebElement(objFilepath, "CRA175_btn_CloseSPAlov");
        btn_provisoLov             = MiscUtility.getWebElement(objFilepath, "CRA175_btn_provisoLov");
        btn_closeProvisoLov        = MiscUtility.getWebElement(objFilepath, "CRA175_btn_closeProvisoLov");
        btn_print                  = MiscUtility.getWebElement(objFilepath, "CRA175_btn_print");
        btn_viewProration          = MiscUtility.getWebElement(objFilepath, "CRA175_btn_viewProration");
        btn_awbEnquiry             = MiscUtility.getWebElement(objFilepath, "CRA175_btn_awbEnquiry");
        txt_dateRangeFrom          = MiscUtility.getWebElement(objFilepath, "CRA175_txt_dateRangeFrom");
        txt_dateRangeTo            = MiscUtility.getWebElement(objFilepath, "CRA175_txt_dateRangeTo");
        btn_airlineLov             = MiscUtility.getWebElement(objFilepath, "CRA175_btn_airlineLov");
        btn_closeAirlineLov        = MiscUtility.getWebElement(objFilepath, "CRA175_btn_closeAirlineLov");
        Generic_info_msg           = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        viewProration_info_payReceive     = MiscUtility.getWebElement(objFilepath, "CRA175_viewProration_info_payReceive");
            // viewProration_info_pay     = MiscUtility.getWebElement(objFilepath, "CRA175_viewProration_info_pay");

    }
    public  CRA175 UIverification(){
    	
    	verifyElementPresent(dropdown_MOP);
    	verifyElementPresent(dropdown_AWBStatus);
    	verifyElementPresent(txt_sectorFrom);
    	verifyElementPresent(txt_sectorTo);
    	verifyElementPresent(btn_sectorFromlov);
    	verifyElementPresent(btn_sectorTolov);
    	verifyElementPresent(chkbx_SPAInclude);
    	verifyElementPresent(chkbx_provisoReqstInclude);
    	verifyElementPresent(txt_SPANumbr);
    	verifyElementPresent(dropdown_billingType);
		verifyElementVisible(btn_calendarFromDate);
		verifyElementVisible(btn_calendarToDate);
    	verifyElementPresent(txt_airline);
		click(btn_btnList);
		Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("From Date is mandatory"));
		Assert.assertTrue(waitForElement(Generic_info_error2).getText().contains("To Date is mandatory"));
    	
		Assert.assertTrue(waitForElement(dropdown_billingType).getText().contains("Inward Billing"),"Error: Value not present");
		Assert.assertTrue(waitForElement(dropdown_billingType).getText().contains("Outward Billing"),"Error: Value not present");
		Assert.assertTrue(waitForElement(dropdown_MOP).getText().contains("CC"),"Error: Value not present");
		Assert.assertTrue(waitForElement(dropdown_MOP).getText().contains("PP"),"Error: Value not present");
		Assert.assertTrue(waitForElement(dropdown_MOP).getText().contains("PC"),"Error: Value not present");
		Assert.assertTrue(waitForElement(dropdown_MOP).getText().contains("CP"),"Error: Value not present");
		click(btn_sectorFromlov);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		verifyElementPresent(chkbx_sectorSelect);
		click(btn_sectrClose);
		switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	
    	click(btn_sectorTolov);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		verifyElementPresent(chkbx_sectorSelect);
		click(btn_sectrClose);
		switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	
    	
    	Assert.assertTrue(waitForElement(dropdown_AWBStatus).getText().contains("HV Billable"),"Error: Value not present");
    	Assert.assertTrue(waitForElement(dropdown_AWBStatus).getText().contains("Outward Billable "),"Error: Value not present");
    	Assert.assertTrue(waitForElement(dropdown_AWBStatus).getText().contains("Outward Billed"),"Error: Value not present");
    	Assert.assertTrue(waitForElement(dropdown_AWBStatus).getText().contains("Inward Billed"),"Error: Value not present");
    	Assert.assertTrue(waitForElement(dropdown_AWBStatus).getText().contains("To be Inward Billed"),"Error: Value not present");
    	Assert.assertTrue(waitForElement(dropdown_AWBStatus).getText().contains("Withdrwan"),"Error: Value not present");
    	Assert.assertTrue(waitForElement(dropdown_AWBStatus).getText().contains("Pending"),"Error: Value not present");
    	
    	
    	return this;
    }
    /**
     * UI verification
     * @return
     */
    public CRA175 SPA_UIverification(){
    	
    	
    	check(chkbx_SPAInclude);
    	unCheck(chkbx_SPAInclude);
    	
    	click(btn_SPAlov);
    	minWait();
    	
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
		
    	click(btn_CloseSPAlov);
    	
switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	minWait();
		
    	
    	return this;	
    	
    }
    
    /**
     * UI verification
     * @return
     */
    public CRA175 airline_UIverification(){
    	
    	
   
    	click(btn_airlineLov);
    	minWait();
    	
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
		
    	click(btn_closeAirlineLov);
    	
switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	minWait();
		
    	
    	return this;	
    	
    }
    
    /**
     * UI verification
     * @return
     */
public CRA175 proviso_UIverification(){
    	
    	
    	check(chkbx_provisoReqstInclude);
    	unCheck(chkbx_provisoReqstInclude);
    	
    	click(btn_provisoLov);
    	minWait();
    	
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
		
    	click(btn_closeProvisoLov);
    	
switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	minWait();
		
    	
    	return this;	
    	
    }
    
    /***
     * 
     * @param prefix
     * @param awbno
     * @param status
     * @return
     */
    public CRA175 changeStatus(String prefix,String awbno,String status){
    	
    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	
    	check(chkbx_selectawb);
    	
    	click(btn_changeStatus);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	selectByText(dropdown_selectStatusPopup, status);
    	enterKeys(txt_RemarksChangeStatus, "Remarks");
    	click(btn_saveChangeStatusPopup);
    	switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	minWait();
		
    	String Bstatus=getTableCellValue(tbl_listInterlineEntries, 21, 1);
    	System.out.println("Billingstatus:"+Bstatus);
    	Assert.assertFalse(status.contains(Bstatus), "ERROR: Billing Status not matches");

    	return this;
    	
    }
    /***
     * verify buttons enable
     * @return
     */
    public CRA175 verifyButtons(){
    	
    	Assert.assertTrue(waitForElement(btn_btnList).isEnabled());
    	Assert.assertTrue(waitForElement(btn_clear).isEnabled());
    	Assert.assertTrue(waitForElement(btn_btnClose).isEnabled());
    	
    	Assert.assertFalse(waitForElement(btn_changeStatus).isEnabled());
    	Assert.assertFalse(waitForElement(btn_print).isEnabled());
    	Assert.assertFalse(waitForElement(btn_CCA).isEnabled());
    	Assert.assertFalse(waitForElement(btn_viewProration).isEnabled());
    	Assert.assertFalse(waitForElement(btn_awbEnquiry).isEnabled());
    	
         
    	enterKeys(txt_dateRangeFrom, "-15");
        enterKeys(txt_dateRangeTo, ".");
    	click(btn_btnList);
    	minWait();
    	
    	Assert.assertTrue(waitForElement(btn_changeStatus).isEnabled());
    	Assert.assertTrue(waitForElement(btn_print).isEnabled());
    	Assert.assertTrue(waitForElement(btn_CCA).isEnabled());
    	Assert.assertTrue(waitForElement(btn_viewProration).isEnabled());
    	Assert.assertTrue(waitForElement(btn_awbEnquiry).isEnabled());
    	
    	click(btn_clear);
    	minWait();
    	
    	Assert.assertTrue(waitForElement(txt_dateRangeFrom).getAttribute("value").equals(""));
    	Assert.assertTrue(waitForElement(txt_dateRangeTo).getAttribute("value").equals(""));
    	
    	return this;
    }
    /**
     * 
     * @param awbStatus
     * @param status2
     * @return
     */
    public CRA175 verifyListedValue(String awbStatus,String status2){
    	
    	awbStatus = PropertyHandler.getPropValue(dataFilePath, awbStatus);
    	status2   = PropertyHandler.getPropValue(dataFilePath, status2);

    	enterKeys(txt_dateRangeFrom, "-15");
        enterKeys(txt_dateRangeTo, ".");
        selectByText(dropdown_AWBStatus, awbStatus);
    	click(btn_btnList);
    	minWait();
       
    	List<String> awbStats = getTableColumnValues(tbl_listInterlineEntries, 12);
    	
    	Assert.assertTrue(awbStats.contains(awbStatus));
    	Assert.assertFalse(awbStats.contains(status2),"Fail:Listed with filter condition failed");
    	click(btn_clear);
    	minWait();
    	
    	

    	enterKeys(txt_dateRangeFrom, "-15");
        enterKeys(txt_dateRangeTo, ".");
    	click(btn_btnList);
    	minWait();
       
    	List<String> awbStats2 = getTableColumnValues(tbl_listInterlineEntries, 12);
    	
    	Assert.assertTrue(awbStats2.contains(awbStatus));
    	
    	Assert.assertTrue(awbStats2.contains(status2));
    	
    	
    	
    	return this;
    }
    /***
     * 
     * @param MOPvalue
     * @return
     */
    public CRA175 MOP_FilterVerification(String MOPvalue,String MOPvalue2){
    	
    	MOPvalue = PropertyHandler.getPropValue(dataFilePath, MOPvalue);
    	MOPvalue2 = PropertyHandler.getPropValue(dataFilePath, MOPvalue2);
    	
    	enterKeys(txt_dateRangeFrom, "-15");
        enterKeys(txt_dateRangeTo, ".");
        selectByText(dropdown_MOP, MOPvalue);
    	click(btn_btnList);
    	minWait();
    	List<String> awbStats = getTableColumnValues(tbl_listInterlineEntries, 9);
    	Assert.assertTrue(awbStats.contains(MOPvalue));
    	Assert.assertFalse(awbStats.contains(MOPvalue2),"Fail:Listed with filter condition failed");
    	
    	click(btn_clear);
    	minWait();
    	
    	

    	enterKeys(txt_dateRangeFrom, "-15");
        enterKeys(txt_dateRangeTo, ".");
    	click(btn_btnList);
    	minWait();
       
    
    	List<String> awbStats2 = getTableColumnValues(tbl_listInterlineEntries, 9);
    	
    	
      Assert.assertTrue(awbStats2.contains(MOPvalue));
    	
    	Assert.assertTrue(awbStats2.contains(MOPvalue2));
    	
    	
    	
    	
    	
    	
    	return this;	
    }
    /****
     * 
     * @param prefix
     * @param awbno
     * @param memoNum
     * @param billingType
     * @param status
     * @return
     */
    
    public CRA175 checkBillingMemo(String prefix, String awbno,String memoNum,String billingType,String status){
    	
    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	memoNum=PropertyHandler.getPropValue(dataFilePath, memoNum);
    	billingType=PropertyHandler.getPropValue(dataFilePath, billingType);
    	status=PropertyHandler.getPropValue(dataFilePath, status);
    	
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	selectByText(dropdown_billingType,billingType);
    	click(btn_btnList);
    	minWait();
    	
    	String Bmemo=getTableCellValue(tbl_listInterlineEntries, 4, 2);
    	System.out.println("BillingMemo:"+Bmemo);
    	Assert.assertTrue(memoNum.contains(Bmemo), "ERROR: BillingMemo not matches");
		
    	String Bstatus=getTableCellValue(tbl_listInterlineEntries, 21, 2);
    	System.out.println("Billingstatus:"+Bstatus);
    	Assert.assertTrue(status.contains(Bstatus), "ERROR: Billing Status not matches");

      
    	return this;	
    }
    
    
    
    /**
     * 
     * @return
     */
    
    public CRA175 changeBillingstatusInwardErrorChk(){
    	
    	
    	enterKeys(txt_dateRangeFrom, "-15");
        enterKeys(txt_dateRangeTo, ".");
        selectByText(dropdown_AWBStatus, "To be Inward Billed");
    	click(btn_btnList);
    	minWait();
       
    
    	check(chkbx_selectawb);
    	click(btn_changeStatus);
    	
    	
    	minWait();
    	Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("Cannot Change Status for Inward entries"));
    	  	
    	
    	return this;
    }
    /***
     * 
     * @param prefix
     * @param awbno
     * @return
     */
    public CRA175 verifyBtnDisabled(String prefix, String awbno){
    	
    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
Assert.assertFalse(waitForElement(btn_issueBillingMemo).isEnabled());
return this;

    	
    }
    
    /***
     * 
     * @param awbPrefix
     * @param AWBNo
     * @return
     */
    public CRA175 billingMemo_Navigation(String awbPrefix,String AWBNo){
    	
    	
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	
    	enterKeys(text_shipmentPrefix, awbPrefix);
    	enterKeys(text_documentNumber, AWBNo);
    	click(btn_btnList);
    	minWait();
    	
    	check(chkbx_selectawb);
    	click(btn_issueBillingMemo);
    	maxWait();
    	
    	click(chargeMemo_btn_close);
    	minWait();
    	
		
    	return this;
    	
    }
    /***
     * 
     * @param awbPrefix
     * @param AWBNo
     * @return
     */
 public CRA175 viewProration_Navigation(String awbPrefix,String AWBNo,String typeofBilling){
    	
    	
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	typeofBilling=PropertyHandler.getPropValue(dataFilePath, typeofBilling);
    	
    	
    	enterKeys(text_shipmentPrefix, awbPrefix);
    	enterKeys(text_documentNumber, AWBNo);
    	click(btn_btnList);
    	minWait();
    	
    	check(chkbx_selectawb);
    	click(btn_ViewProration);
    	maxWait();
    	
    	
    	Assert.assertTrue(waitForElement(viewProration_info_pay).getAttribute("value").contains(typeofBilling));
    	
    	click(viewProration_btn_close);
    	minWait();
    	
		
    	return this;
    	
    }
    /**
     * 
     * @param awbPrefix
     * @param AWBNo
     * @return
     */
 public CRA175 CC_Navigation(String awbPrefix,String AWBNo){
    	
    	
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	
    	enterKeys(text_shipmentPrefix, awbPrefix);
    	enterKeys(text_documentNumber, AWBNo);
    	click(btn_btnList);
    	minWait();
    	
    	check(chkbx_selectawb);
    	click(btn_CCA);
    	maxWait();
    	minWait();
    	driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("CCA doesnot exist,Do you want to create a new CCA?"), "Expected popup did not come");
            
            click(yesBtn);
        
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	click(CCA_btn_close);
    	minWait();
    	
		
    	return this;
    	
    }
    
 /**
  * 
  * @param awbPrefix
  * @param AWBNo
  * @return
  */
 
 public CRA175 billingMemo_errorcheck(String awbPrefix,String AWBNo){
    	
    	
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	
    	click(btn_clear);
    	minWait();
    	
    	enterKeys(text_shipmentPrefix, awbPrefix);
    	enterKeys(text_documentNumber, AWBNo);
    	click(btn_btnList);
    	minWait();
    	
    	check(chkbx_selectawb);
    	click(btn_issueBillingMemo);
    	maxWait();
         System.out.println("Error table Contains "+waitForElement(Generic_info_error).getText());
        Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("Cannot issue billing memos to AWBs other than High value Billable status"));
		return this;
 }
    	
  /**
   * 
   * @param prefix
   * @param awbno
   * @param frmdate
   * @param todate
   * @param Billingstatus
   * @param BillingType
   * @return
   */

public CRA175 CheckStatus(String prefix, String awbno,String frmdate,String todate,String Billingstatus,String BillingType){

prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
frmdate = PropertyHandler.getPropValue(dataFilePath, frmdate);
todate = PropertyHandler.getPropValue(dataFilePath, todate);
Billingstatus= PropertyHandler.getPropValue(dataFilePath, Billingstatus);
BillingType= PropertyHandler.getPropValue(dataFilePath, BillingType);

enterKeys(text_shipmentPrefix, prefix);
enterKeys(text_documentNumber, awbno);
click(btn_btnList);
minWait();

String BType=getTableCellValue(tbl_listInterlineEntries, 12, 1);
System.out.println("BillingType:"+BType);
Assert.assertTrue(BillingType.contains(BType), "ERROR: Billing type not matches");


String Bstatus=getTableCellValue(tbl_listInterlineEntries, 21, 1);
System.out.println("Billingstatus:"+Bstatus);
Assert.assertTrue(Billingstatus.contains(Bstatus), "ERROR: Billing Status not matches");

return this;


}
/***
 * 
 * @param prefix
 * @param awbno
 * @return
 */
public CRA175 errorCheck_billed(String prefix, String awbno){
	
	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
	
	check(chkbx_selectawb);
	
	click(btn_changeStatus);
	
	System.out.println(waitForElement(Generic_info_error).getText());
	Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("Invoice already Billed.Cannot change status"));
	
	
	return this;
}
/****
 * 
 * @param prefix
 * @param awbno
 * @param status
 * @param errorMsg
 * @return
 */
public CRA175 changeStatusErrorCheck(String prefix, String awbno,String status,String errorMsg){
	
	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
	errorMsg=PropertyHandler.getPropValue(dataFilePath, errorMsg);

	enterKeys(text_shipmentPrefix, prefix);
	enterKeys(text_documentNumber, awbno);
	click(btn_btnList);
	minWait();
   
	check(chkbx_selectawb);
	
	click(btn_changeStatus);
	driver.switchTo().defaultContent();
	waitForNewWindow(2);
	switchToSecondWindow();
	
	selectByText(dropdown_selectStatusPopup, status);
	enterKeys(txt_RemarksChangeStatus, "Remarks");
	click(btn_saveChangeStatusPopup);
    
	System.out.println(waitForElement(Generic_info_error).getText());
	Assert.assertTrue(waitForElement(Generic_info_error).getText().contains(errorMsg));
	
	click(btn_closeChangeStatusPopup);
	switchToFirstWindow();
	waitForFrameAndSwitch(FRAME);
	minWait();
	return this;
	
	
}
/**
 * 
 * @param prefix
 * @param awbno
 * @param InvoiceOutward
 * @return
 */
public CRA175 GetInvoice(String prefix, String awbno,String InvoiceOutward){

prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
awbno = PropertyHandler.getPropValue(dataFilePath, awbno);


enterKeys(text_shipmentPrefix, prefix);
enterKeys(text_documentNumber, awbno);
click(btn_btnList);
minWait();

String InvNo=getTableCellValue(tbl_listInterlineEntries, 11, 1);
System.out.println("Invoice no:"+InvNo);

PropertyHandler.setPropValue(dataFilePath, InvoiceOutward, InvNo);

return this;


}

public CRA175 clear() {

    click(btn_clear);
    minWait();
    return this;
}
    

public HomePage close() {

        click(btn_btnClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}

