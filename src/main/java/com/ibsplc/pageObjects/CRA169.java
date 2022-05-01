package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * 
 * @author A-6836
 *
 */


public class CRA169 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA169";
    public static String screenFrame = "iCargoContentFrameCRA169";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By txt_startingClearancePeriodFltr,
    txt_endingClearancePeriodFltr,
    tbl_listBiledInvoice,ViewBillingTbl_awbDetails, 
    btn_btnList,txt_clearancePeriodFilter,
    yesBtn,btn_btnView,ViewBillingBtn_btnClose,
    info_error,ViewBillingBtn_btnWithdraw,
    btn_listAccountingDetails,
    btn_view,
    viewOutwardBillingInvoice_tbl_awbdetails,
    btn_ok,
    txt_invoiceNumbr,
    lov_invoiceNumbr,
    chkbx_selctInvNumbr,
    btn_lovPopupOK,chkbox_selectCheckBox,
    chkbx_selectInvDetails,
   listAccountingEntries_info_debitvalue,
   vieOutwardBillingInvoice_btn_close,
    listAccountingEntries_info_creditvalue,
    View_btn_listaccountingDetails,
    listAccountingEntries_btn_close,
    view_btn_close,
    menubar,
    MenuRevenueAccounting,
   revenueAcounting_SIS,
   SIS_outwardBilling,
   OutwardBilling_billingGeneration,
    OutwardBilling_Invoice,
   outwardBilling_Invoice_List,
  btn_calendarInvoiceFrom,
   btn_calendarInvoiceTo,
   Generic_info_msg,
   lov_clearancePeriodLOV,
   btn_clearnceperiodPopupClose,
   txt_airlineCode,
   txt_airlineNumber,
   lov_airlineNumber,
   lov_airlineCode,
   btn_CloseAirlineNumbrPopup,
   dropdown_isFlag,
    btn_btnClose;
   
    public CRA169(WebDriver driver, String dataFileName) {
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
    	
    	
    	
    	txt_clearancePeriodFilter= MiscUtility.getWebElement(objFilepath, "CRA169_txt_clearancePeriodFilter");

    	txt_startingClearancePeriodFltr                        = MiscUtility.getWebElement(objFilepath, "CRA169_txt_startingClearancePeriodFltr");
    	txt_endingClearancePeriodFltr                          = MiscUtility.getWebElement(objFilepath, "CRA169_txt_endingClearancePeriodFltr");
    	tbl_listBiledInvoice                                   = MiscUtility.getWebElement(objFilepath, "CRA169_tbl_listBiledInvoice");
    	btn_btnList                                            = MiscUtility.getWebElement(objFilepath, "CRA169_btn_btnList");
    	btn_btnClose                                           = MiscUtility.getWebElement(objFilepath, "CRA169_btn_btnClose");
    	ViewBillingBtn_btnWithdraw                             = MiscUtility.getWebElement(objFilepath, "CRA169_ViewBillingBtn_btnWithdraw");
    	btn_btnView                                            = MiscUtility.getWebElement(objFilepath, "CRA169_btn_btnView");
    	ViewBillingTbl_awbDetails                              = MiscUtility.getWebElement(objFilepath, "CRA169_ViewBillingTbl_awbDetails");
    	ViewBillingBtn_btnClose                                = MiscUtility.getWebElement(objFilepath, "CRA169_ViewBillingBtn_btnClose");
        yesBtn                                                 = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_ok                                                 = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        btn_listAccountingDetails                              = MiscUtility.getWebElement(objFilepath, "CRA169_btn_listAccountingDetails");
        listAccountingEntries_info_debitvalue                  = MiscUtility.getWebElement(objFilepath, "CRA169_listAccountingEntries_info_debitvalue");
        listAccountingEntries_info_creditvalue                 = MiscUtility.getWebElement(objFilepath, "CRA169_listAccountingEntries_info_creditvalue");
        btn_view                                               = MiscUtility.getWebElement(objFilepath, "CRA169_btn_view");
        viewOutwardBillingInvoice_tbl_awbdetails               = MiscUtility.getWebElement(objFilepath, "CRA169_viewOutwardBillingInvoice_tbl_awbdetails");
        info_error                                             = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
       vieOutwardBillingInvoice_btn_close                      = MiscUtility.getWebElement(objFilepath, "CRA169_vieOutwardBillingInvoice_btn_close");
       txt_invoiceNumbr                                        = MiscUtility.getWebElement(objFilepath, "CRA169_txt_invoiceNumbr");
       lov_invoiceNumbr                                        = MiscUtility.getWebElement(objFilepath, "CRA169_lov_invoiceNumbr");
       chkbx_selctInvNumbr                                     = MiscUtility.getWebElement(objFilepath, "CRA169_chkbx_selctInvNumbr");
       btn_lovPopupOK                                          = MiscUtility.getWebElement(objFilepath, "CRA169_btn_lovPopupOK");
       chkbx_selectInvDetails                                  = MiscUtility.getWebElement(objFilepath, "CRA169_chkbx_selectInvDetails");
       View_btn_listaccountingDetails                          = MiscUtility.getWebElement(objFilepath, "CRA169_View_btn_listaccountingDetails");
       listAccountingEntries_btn_close                         = MiscUtility.getWebElement(objFilepath, "CRA169_listAccountingEntries_btn_close");
       view_btn_close                                          = MiscUtility.getWebElement(objFilepath, "CRA169_view_btn_close");
       menubar                                                 = MiscUtility.getWebElement(objFilepath, "homeScreen_menubar");
       MenuRevenueAccounting=MiscUtility.getWebElement(objFilepath, "homescreen_MenuRevenueAccounting");
        revenueAcounting_SIS=MiscUtility.getWebElement(objFilepath, "homescreen_revenueAcounting_SIS");
      SIS_outwardBilling=MiscUtility.getWebElement(objFilepath, "homescreen_SIS_outwardBilling");
       OutwardBilling_billingGeneration=MiscUtility.getWebElement(objFilepath, "homeScreen_OutwardBilling_billingGeneration");
       OutwardBilling_Invoice=MiscUtility.getWebElement(objFilepath, "homeScreen_OutwardBilling_Invoice");
      outwardBilling_Invoice_List=MiscUtility.getWebElement(objFilepath, "homescreen_outwardBilling_Invoice_List");
      btn_calendarInvoiceFrom=MiscUtility.getWebElement(objFilepath, "CRA169_btn_calendarInvoiceFrom");
      btn_calendarInvoiceTo=MiscUtility.getWebElement(objFilepath, "CRA169_btn_calendarInvoiceTo");
      Generic_info_msg=MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
     lov_clearancePeriodLOV=MiscUtility.getWebElement(objFilepath, "CRA169_lov_clearancePeriodLOV");
     btn_clearnceperiodPopupClose=MiscUtility.getWebElement(objFilepath, "CRA169_btn_clearnceperiodPopupClose");
     txt_airlineCode=MiscUtility.getWebElement(objFilepath, "CRA169_txt_airlineCode");
      txt_airlineNumber=MiscUtility.getWebElement(objFilepath, "CRA169_txt_airlineNumber");
     lov_airlineNumber=MiscUtility.getWebElement(objFilepath, "CRA169_lov_airlineNumber");
      lov_airlineCode=MiscUtility.getWebElement(objFilepath, "CRA169_lov_airlineCode");
    btn_CloseAirlineNumbrPopup=MiscUtility.getWebElement(objFilepath, "CRA169_btn_CloseAirlineNumbrPopup");
    dropdown_isFlag=MiscUtility.getWebElement(objFilepath, "CRA169_dropdown_isFlag");
    chkbox_selectCheckBox=MiscUtility.getWebElement(objFilepath, "CRA169_chkbox_selectCheckBox");
        
    }
    
    
    public CRA169 verify_lovFields(){
    	
    	Assert.assertTrue(waitForElement(txt_clearancePeriodFilter).isEnabled());
    	Assert.assertTrue(waitForElement(lov_clearancePeriodLOV).isEnabled());
    	click(lov_clearancePeriodLOV);
    	
    	waitForNewWindow(2);
    	
    	switchToSecondWindow();
    	
    	minWait();
    	click(btn_clearnceperiodPopupClose);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	
    	Assert.assertTrue(waitForElement(txt_airlineNumber).isEnabled());
    	Assert.assertTrue(waitForElement(lov_airlineNumber).isEnabled());
    	
    	click(lov_airlineNumber);
    	
    	waitForNewWindow(2);
    	
    	switchToSecondWindow();
    	
    	minWait();
    	click(btn_CloseAirlineNumbrPopup);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	
    	Assert.assertTrue(waitForElement(txt_airlineCode).isEnabled());
    	Assert.assertTrue(waitForElement(lov_airlineCode).isEnabled());
    	
    	click(lov_airlineCode);
    	
    	waitForNewWindow(2);
    	
    	switchToSecondWindow();
    	
    	minWait();
    	click(btn_CloseAirlineNumbrPopup);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	
    	Assert.assertTrue(waitForElement(dropdown_isFlag).getText().contains("Yes"));
    	Assert.assertTrue(waitForElement(dropdown_isFlag).getText().contains("Not Applicable"));
    	Assert.assertTrue(waitForElement(dropdown_isFlag).getText().contains("No"));
    	
		return this;
    	
    }
    
    /**
     * 
     * @param invNumbr
     * @return
     */
    public CRA169 invoiceListingErrorverification(String invNumbr,String isFileStatus ,boolean isError){
    	
    	
    	invNumbr=PropertyHandler.getPropValue(dataFilePath, invNumbr);
    	
    	enterKeys(txt_invoiceNumbr, invNumbr);
    	click(lov_invoiceNumbr);
    	minWait();

    	driver.switchTo().defaultContent();
       waitForNewWindow(2);
       switchToSecondWindow();
       
       check(chkbx_selctInvNumbr);
       click(btn_lovPopupOK);
       switchToFirstWindow();
       waitForFrameAndSwitch(FRAME);
       
       selectByText(dropdown_isFlag, isFileStatus);
       
       click(btn_btnList);
       
       minWait();
       
	   if(isError==true){
    	Assert.assertTrue(waitForElement(info_error).getText().contains("No Records Found"));
    	
	   }
	   else{
		   
		   
		   String InvFieldvalue=getTableCellValue(tbl_listBiledInvoice, 2, 1);
		   System.out.println("InvoiceNumber : "+InvFieldvalue);
		   Assert.assertTrue(InvFieldvalue.equals(invNumbr));
	   }
		return this;
    	
    	
    }
    /**
     * 
     * @param clearancePeriod
     * @param InvoiceNo
     * @param AWBno
     * @return
     */
    public CRA169 view_Navigation(String clearancePeriod, String InvoiceNo,String AWBno){
    	
    	
    	clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        
    	AWBno= PropertyHandler.getPropValue(dataFilePath, AWBno);

        enterKeys(txt_clearancePeriodFilter, clearancePeriod);
        
        click(btn_btnList);
        minWait();
        
        tblSelectRowByColValue(tbl_listBiledInvoice, 1, 2, InvoiceNo);
        click(btn_btnView);
        maxWait();
       String tblAWB= getTableCellValue(ViewBillingTbl_awbDetails, 3, 1);
        Assert.assertTrue(tblAWB.contains(AWBno));
		
        return this;
    }
    
    /***
     * 
     * @return
     */
    
     public CRA169 UI_ErrorVerification(){
    	 
    	 
    	Assert.assertTrue(waitForElement(btn_calendarInvoiceFrom).isEnabled());
    	 
    	Assert.assertTrue(waitForElement(btn_calendarInvoiceTo).isEnabled());
    	
    	click(btn_btnList);
    	
    	driver.switchTo().defaultContent();
    	
    	Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("Please specify Clearance Period or Invoice Date Range."));
		
    	click(btn_ok);
    	waitForFrameAndSwitch(FRAME);
    	
    	enterKeys(txt_startingClearancePeriodFltr, "+1");
    	enterKeys(txt_endingClearancePeriodFltr, "-2");
    	
    	click(btn_btnList);
    	
    	minWait();
        driver.switchTo().defaultContent();
    	
    	Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("To Date should be greater than the From Date."));
		
    	click(btn_ok);
    	waitForFrameAndSwitch(FRAME);
    	
    	return this;
     }
    /**
     * 
     * @param clearancePeriod
     * @param InvoiceNo
     * @param AWBno
     * @return
     */
    public CRA169 accounting_Navigation(String clearancePeriod, String InvoiceNo,String AWBno){

    	
    	clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
    
    	AWBno= PropertyHandler.getPropValue(dataFilePath, AWBno);

        enterKeys(txt_clearancePeriodFilter, clearancePeriod);
        
        click(btn_btnList);
        minWait();
        
        tblSelectRowByColValue(tbl_listBiledInvoice, 1, 2, InvoiceNo);
        
        click(btn_listAccountingDetails);
        maxWait();
		String debit=waitForElement(listAccountingEntries_info_debitvalue).getText();
		String credit=waitForElement(listAccountingEntries_info_creditvalue).getText();
		Assert.assertTrue(debit.equals(credit));
        click(vieOutwardBillingInvoice_btn_close);
        minWait();
        return this; 
    }
    
    public CRA169 verifyInvoiceDetails_allFields(){
    	
       
       
    	click(lov_invoiceNumbr);
        minWait();
    	driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();
        
        check(chkbx_selctInvNumbr);
        click(btn_lovPopupOK);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_btnList);
        minWait();
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 1, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 2, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 3, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 4, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 5, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 6, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 7, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 8, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 9, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 10, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 11, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 12, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 13, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 14, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 15, 1).isEmpty());
        Assert.assertFalse(getTableCellValue(tbl_listBiledInvoice, 16, 1).isEmpty());
		return this;
      
        
    }
    /***
     * 
     * @param invNum
     * @param AWBnumbr
     * @return
     */
    public CRA169 checkInvoiceDetails(String invNum,String AWBnumbr){
    	
    	
    	invNum = PropertyHandler.getPropValue(dataFilePath, invNum);
    	AWBnumbr = PropertyHandler.getPropValue(dataFilePath, AWBnumbr);
    	
    	enterKeys(txt_invoiceNumbr, invNum);
    	click(lov_invoiceNumbr);
    	minWait();

    	driver.switchTo().defaultContent();
       waitForNewWindow(2);
       switchToSecondWindow();
       
       check(chkbx_selctInvNumbr);
       click(btn_lovPopupOK);
       switchToFirstWindow();
       waitForFrameAndSwitch(FRAME);
       click(btn_btnList);
       minWait();
	   String InvFieldvalue=getTableCellValue(tbl_listBiledInvoice, 2, 1);
	   System.out.println("InvoiceNumber : "+InvFieldvalue);
      
	   Assert.assertTrue(InvFieldvalue.equals(invNum));
       
	  check(chkbx_selectInvDetails);
	  click(btn_btnView);
       minWait();
       click(View_btn_listaccountingDetails);
       minWait();
       click(listAccountingEntries_btn_close);
        minWait();
        click(view_btn_close);
        
       return this;
    }
    /*public CRA169 checkAllDetails(String invNumbr,String invDate,String Clearanceperiod){
    	
    	
    }*/
    public CRA169 menuNavigation(){

      	
    	click(menubar);
    	minWait();
    	click(MenuRevenueAccounting);
        click(MenuRevenueAccounting);
       click(revenueAcounting_SIS);
       click(SIS_outwardBilling);
       click(OutwardBilling_billingGeneration);
        click(OutwardBilling_Invoice);
       click(outwardBilling_Invoice_List);
       minWait();
       waitForElement(txt_invoiceNumbr).isDisplayed();
	return this;

    }
    
    
    
/***
 * 
 * @param shipper
 * @param fromdate
 * @param billingfreq
 * @return
 */


    public CRA169 CheckInvoice_Withdraw(String clearancePeriod, String InvoiceNo,String AWBno){

    	
    	clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
    
    	AWBno= PropertyHandler.getPropValue(dataFilePath, AWBno);
    	InvoiceNo= PropertyHandler.getPropValue(dataFilePath, InvoiceNo);

        enterKeys(txt_clearancePeriodFilter, clearancePeriod);
        
        click(btn_btnList);
        minWait();
        tblSelectRowByColValue(tbl_listBiledInvoice, 1, 2,InvoiceNo);
        click(btn_btnView);
        minWait();
        Assert.assertTrue(waitForElement(ViewBillingTbl_awbDetails).getText().contains(AWBno), "ERROR: AWB no is not found");
        check(chkbox_selectCheckBox);
        click(ViewBillingBtn_btnWithdraw);
        minWait();
        driver.switchTo().defaultContent();
        click(btn_ok);
        waitForFrameAndSwitch(FRAME);
        click(ViewBillingBtn_btnClose);
        
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
