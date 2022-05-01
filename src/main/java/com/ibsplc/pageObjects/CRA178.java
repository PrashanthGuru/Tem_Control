package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen CRA178
 * Created on 12/03/2018
 *
 * @author a-6784
 */
public class CRA178 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA178";


    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By txt_clearanceYear,

    txt_airlineCode,
    txt_invoiceNumber,
    btn_btList,txt_totalWtRateChargesInListingCurrency,
    btn_btSave,text_airlineCode,
    btn_btnInvDetails,
    btn_addLink,btn_btRejectInvoice,
    CaptureInvpopuptext_documentNumber,btn_btnExceptions,
    CaptureInvpopuptext_weightChargesInListingCurrency,
    CaptureInvpopupbtn_btnOk,CaptureInv_btnSave,text_remarks,
    CaptureInvform_Status,text_listingCurrency,
    ViewExceptiontbl_ViewExceptionDetails,
    ViewExceptionbtn_btnRejectionMemo,text_totalVatListingCurrency,
    ViewRejectionMemotext_weightCharge,
	ViewRejectionMemotext_weightChargeRejected,
    CaptureInvbtn_btnProcess,text_netIsCChargesInListingCurrency,
    CaptureInvchk_chk,dropdown_invoiceType,text_totalOtherChargesInListingCurrency,
    ViewRejectionMemotext_weightChargeBilled,
    ViewRejectionMemochk_reasonCheck,checkbox_selectedRow,
    ViewRejectionMemobtn_btnSave,btn_invoicenolovbtnOk,
    ViewRejectionMemotext_remarks,tbl_Form1Details,
    ViewRejectionMemobtn_btnClose,text_totalValuationChargeListingCurrency,
    yesBtn,noBtn,btn_airlinecodelovbtnOk,
    msg_popup,check_airlinecodelovselectCheckBox,text_totalAmountInListingCurrency,
    btn_genericOk,txt_airlineNo,dropdown_billingType,
    info_genericMsg,okBtn,text_filterAirlineNumber,btn_CapInvDetailsClose,
    CaptutreInvpopup_txt_awbPrefix,checkbox_invoicenolovselectCheckBox,
    CaptureInvpopup_info_invoiceStatus,text_noOfAwbs,
    btn_close,info_error,btn_airlinecodelov,btn_invoicenolov,btn_lnkDelete,
    captureInvpopup_txt_awborigin,btn_btnAccDetails,
    captureInvpopup_txt_awbDest,text_invoiceDate,
    captureInvpopup_txt_carrierFrom,
    captureInvpopup_txt_carrierTo,btn_CaptureInvoicebtnSave,
    captureInvDetails_btn_exception,text_billingCurrency,
    exception_btn_close,tbl_CapInvDetailscaptureAWBDetails,
    captureInvDetails_btn_close,
    captureInvDetails_btn_deleteLink,txt_exchangeRate,
    btn_invoiceNumbtLov,
    chkbx_slectInvoiceNum,btn_CaptureInvoicenetbtnClose,CaptureInvbtn_modifyLink,
    btn_ivoiceNumberLovpopup_OK,
    btn_delete,CaptureInvbtn_deleteLink,
    captureInvPopup_txt_flightdate,
    chkbx_slectInvoice,txt_invoicenopopup,chkbox_selectCheckBoxInvpopup,
			btn_clear,btn;

          

    public CRA178(WebDriver driver, String dataFileName) {
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


        txt_clearanceYear = MiscUtility.getWebElement(objFilepath, "CRA178_txt_clearanceYear");
        txt_airlineCode = MiscUtility.getWebElement(objFilepath, "CRA178_txt_airlineCode");
        txt_invoiceNumber = MiscUtility.getWebElement(objFilepath, "CRA178_txt_invoiceNumber");
        btn_btList = MiscUtility.getWebElement(objFilepath, "CRA178_btn_btList");
        btn_clear = MiscUtility.getWebElement(objFilepath, "CRA178_btn_clear");
        txt_totalWtRateChargesInListingCurrency = MiscUtility.getWebElement(objFilepath, "CRA178_txt_totalWtRateChargesInListingCurrency");
        btn_btSave = MiscUtility.getWebElement(objFilepath, "CRA178_btn_btSave");
        btn_btnInvDetails = MiscUtility.getWebElement(objFilepath, "CRA178_btn_btnInvDetails");
        btn_addLink = MiscUtility.getWebElement(objFilepath, "CRA178_btn_addLink");
        CaptureInvbtn_modifyLink = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvbtn_modifyLink");
        CaptureInvpopuptext_documentNumber = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvpopuptext_documentNumber");
        CaptureInvpopuptext_weightChargesInListingCurrency = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvpopuptext_weightChargesInListingCurrency");
        CaptureInvpopupbtn_btnOk = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvpopupbtn_btnOk");
        CaptureInv_btnSave = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInv_btnSave");
        CaptureInvform_Status = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvform_Status");
        CaptureInvbtn_btnProcess = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvbtn_btnProcess");
        text_invoiceDate = MiscUtility.getWebElement(objFilepath, "CRA178_text_invoiceDate");
        text_billingCurrency = MiscUtility.getWebElement(objFilepath, "CRA178_text_billingCurrency");
        txt_exchangeRate = MiscUtility.getWebElement(objFilepath, "CRA178_txt_exchangeRate");
        CaptureInvchk_chk = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvchk_chk");
        ViewExceptiontbl_ViewExceptionDetails = MiscUtility.getWebElement(objFilepath, "CRA178_ViewExceptiontbl_ViewExceptionDetails");
        ViewExceptionbtn_btnRejectionMemo = MiscUtility.getWebElement(objFilepath, "CRA178_ViewExceptionbtn_btnRejectionMemo");
        ViewRejectionMemotext_weightCharge = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemotext_weightCharge");
        ViewRejectionMemotext_weightChargeRejected = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemotext_weightChargeRejected");
        ViewRejectionMemotext_weightChargeBilled = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemotext_weightChargeBilled");
        ViewRejectionMemochk_reasonCheck = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemochk_reasonCheck");
        ViewRejectionMemobtn_btnSave = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemobtn_btnSave");
        ViewRejectionMemotext_remarks = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemotext_remarks");
        ViewRejectionMemobtn_btnClose = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemobtn_btnClose");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        msg_popup = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        okBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        chkbx_slectInvoice = MiscUtility.getWebElement(objFilepath, "CRA178_chkbx_slectInvoice");
        CaptutreInvpopup_txt_awbPrefix = MiscUtility.getWebElement(objFilepath, "CRA178_CaptutreInvpopup_txt_awbPrefix");
        CaptureInvpopup_info_invoiceStatus = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvpopup_info_invoiceStatus");
        btn_close = MiscUtility.getWebElement(objFilepath, "CRA178_btn_close");
        captureInvpopup_txt_awborigin = MiscUtility.getWebElement(objFilepath, "CRA178_captureInvpopup_txt_awborigin");
        captureInvpopup_txt_awbDest = MiscUtility.getWebElement(objFilepath, "CRA178_captureInvpopup_txt_awbDest");
        captureInvpopup_txt_carrierFrom = MiscUtility.getWebElement(objFilepath, "CRA178_captureInvpopup_txt_carrierFrom");
        captureInvpopup_txt_carrierTo = MiscUtility.getWebElement(objFilepath, "CRA178_captureInvpopup_txt_carrierTo");
        captureInvDetails_btn_exception = MiscUtility.getWebElement(objFilepath, "CRA178_captureInvDetails_btn_exception");
        exception_btn_close = MiscUtility.getWebElement(objFilepath, "CRA178_exception_btn_close");
        captureInvDetails_btn_close = MiscUtility.getWebElement(objFilepath, "CRA178_captureInvDetails_btn_close");
        captureInvDetails_btn_deleteLink = MiscUtility.getWebElement(objFilepath, "CRA178_captureInvDetails_btn_deleteLink");
        btn_invoiceNumbtLov = MiscUtility.getWebElement(objFilepath, "CRA178_btn_invoiceNumbtLov");
        chkbx_slectInvoiceNum = MiscUtility.getWebElement(objFilepath, "CRA178_chkbx_slectInvoiceNum");
        btn_ivoiceNumberLovpopup_OK = MiscUtility.getWebElement(objFilepath, "CRA178_btn_ivoiceNumberLovpopup_OK");
        btn_delete = MiscUtility.getWebElement(objFilepath, "CRA178_btn_delete");
        captureInvPopup_txt_flightdate = MiscUtility.getWebElement(objFilepath, "CRA178_captureInvPopup_txt_flightdate");
        txt_clearanceYear = MiscUtility.getWebElement(objFilepath, "CRA178_txt_clearanceYear");
        txt_airlineCode = MiscUtility.getWebElement(objFilepath, "CRA178_txt_airlineCode");
        txt_airlineNo = MiscUtility.getWebElement(objFilepath, "CRA178_txt_airlineNo");
        txt_invoiceNumber = MiscUtility.getWebElement(objFilepath, "CRA178_txt_invoiceNumber");
        btn_btList = MiscUtility.getWebElement(objFilepath, "CRA178_btn_btList");
        txt_totalWtRateChargesInListingCurrency = MiscUtility.getWebElement(objFilepath, "CRA178_txt_totalWtRateChargesInListingCurrency");
        btn_btSave = MiscUtility.getWebElement(objFilepath, "CRA178_btn_btSave");
        btn_CaptureInvoicebtnSave = MiscUtility.getWebElement(objFilepath, "CRA178_btn_CaptureInvoicebtnSave");
        btn_btnInvDetails = MiscUtility.getWebElement(objFilepath, "CRA178_btn_btnInvDetails");
        btn_addLink = MiscUtility.getWebElement(objFilepath, "CRA178_btn_addLink");
        CaptureInvpopuptext_documentNumber = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvpopuptext_documentNumber");
        CaptureInvpopuptext_weightChargesInListingCurrency = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvpopuptext_weightChargesInListingCurrency");
        CaptureInvpopupbtn_btnOk = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvpopupbtn_btnOk");
        btn_CaptureInvoicenetbtnClose = MiscUtility.getWebElement(objFilepath, "CRA178_btn_CaptureInvoicenetbtnClose");
        CaptureInv_btnSave = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInv_btnSave");
        CaptureInvform_Status = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvform_Status");
        CaptureInvbtn_btnProcess = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvbtn_btnProcess");
        CaptureInvchk_chk = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvchk_chk");
        CaptureInvbtn_deleteLink = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvbtn_deleteLink");
        ViewExceptiontbl_ViewExceptionDetails = MiscUtility.getWebElement(objFilepath, "CRA178_ViewExceptiontbl_ViewExceptionDetails");
        ViewExceptionbtn_btnRejectionMemo = MiscUtility.getWebElement(objFilepath, "CRA178_ViewExceptionbtn_btnRejectionMemo");
        ViewRejectionMemotext_weightCharge = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemotext_weightCharge");
        ViewRejectionMemotext_weightChargeRejected = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemotext_weightChargeRejected");
        ViewRejectionMemotext_weightChargeBilled = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemotext_weightChargeBilled");
        ViewRejectionMemochk_reasonCheck = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemochk_reasonCheck");
        ViewRejectionMemobtn_btnSave = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemobtn_btnSave");
        ViewRejectionMemotext_remarks = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemotext_remarks");
        ViewRejectionMemobtn_btnClose = MiscUtility.getWebElement(objFilepath, "CRA178_ViewRejectionMemobtn_btnClose");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        msg_popup = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        okBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        chkbx_slectInvoice = MiscUtility.getWebElement(objFilepath, "CRA178_chkbx_slectInvoice");
        CaptutreInvpopup_txt_awbPrefix = MiscUtility.getWebElement(objFilepath, "CRA178_CaptutreInvpopup_txt_awbPrefix");
        CaptureInvpopup_info_invoiceStatus = MiscUtility.getWebElement(objFilepath, "CRA178_CaptureInvpopup_info_invoiceStatus");
        btn_close = MiscUtility.getWebElement(objFilepath, "CRA178_btn_close");
        tbl_Form1Details = MiscUtility.getWebElement(objFilepath, "CRA178_tbl_Form1Details");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        btn_airlinecodelov = MiscUtility.getWebElement(objFilepath, "CRA178_btn_airlinecodelov");
        text_filterAirlineNumber = MiscUtility.getWebElement(objFilepath, "CRA178_text_filterAirlineNumber");
        check_airlinecodelovselectCheckBox = MiscUtility.getWebElement(objFilepath, "CRA178_check_airlinecodelovselectCheckBox");
        btn_airlinecodelovbtnOk = MiscUtility.getWebElement(objFilepath, "CRA178_btn_airlinecodelovbtnOk");
        btn_invoicenolov = MiscUtility.getWebElement(objFilepath, "CRA178_btn_invoicenolov");
        checkbox_invoicenolovselectCheckBox = MiscUtility.getWebElement(objFilepath, "CRA178_checkbox_invoicenolovselectCheckBox");
        btn_invoicenolovbtnOk = MiscUtility.getWebElement(objFilepath, "CRA178_btn_airlinecodelovbtnOk");
        dropdown_invoiceType = MiscUtility.getWebElement(objFilepath, "CRA178_dropdown_invoiceType");
        text_noOfAwbs = MiscUtility.getWebElement(objFilepath, "CRA178_text_noOfAwbs");
        text_totalValuationChargeListingCurrency = MiscUtility.getWebElement(objFilepath, "CRA178_text_totalValuationChargeListingCurrency");
        text_totalOtherChargesInListingCurrency = MiscUtility.getWebElement(objFilepath, "CRA178_text_totalOtherChargesInListingCurrency");
        text_netIsCChargesInListingCurrency = MiscUtility.getWebElement(objFilepath, "CRA178_text_netIsCChargesInListingCurrency");
        text_totalVatListingCurrency = MiscUtility.getWebElement(objFilepath, "CRA178_text_totalVatListingCurrency");
        text_remarks = MiscUtility.getWebElement(objFilepath, "CRA178_text_remarks");
        text_listingCurrency = MiscUtility.getWebElement(objFilepath, "CRA178_text_listingCurrency");
        btn_lnkDelete = MiscUtility.getWebElement(objFilepath, "CRA178_btn_lnkDelete");
        checkbox_selectedRow = MiscUtility.getWebElement(objFilepath, "CRA178_checkbox_selectedRow");
        text_totalAmountInListingCurrency = MiscUtility.getWebElement(objFilepath, "CRA178_text_totalAmountInListingCurrency");
        dropdown_billingType = MiscUtility.getWebElement(objFilepath, "CRA178_dropdown_billingType");
        btn_CapInvDetailsClose = MiscUtility.getWebElement(objFilepath, "CRA178_btn_CapInvDetailsClose");
        tbl_CapInvDetailscaptureAWBDetails = MiscUtility.getWebElement(objFilepath, "CRA178_tbl_CapInvDetailscaptureAWBDetails");
     //    btn_btnAccDetails=MiscUtility.getWebElement(objFilepath, "CRA178_btn_btnAccDetails");
      //   btn_btnExceptions=MiscUtility.getWebElement(objFilepath, "CRA178_btn_btnExceptions");
        // btn_btRejectInvoice=MiscUtility.getWebElement(objFilepath, "CRA178_btn_btRejectInvoice");
         txt_invoicenopopup=MiscUtility.getWebElement(objFilepath, "CRA178_txt_invoicenopopup");
         chkbox_selectCheckBoxInvpopup=MiscUtility.getWebElement(objFilepath, "CRA178_chkbox_selectCheckBoxInvpopup");
         
    }

    
    
    
    public CRA178 Check_buttons(String Invoiceno,boolean list){

        if(list==true){
    	Invoiceno = PropertyHandler.getPropValue(dataFilePath,Invoiceno);
    	enterKeys(txt_invoiceNumber, Invoiceno);
    	click(btn_invoicenolov);
    	minWait();
    	switchToSecondWindow();
    	check(checkbox_invoicenolovselectCheckBox);
    	click(btn_ivoiceNumberLovpopup_OK);
    	minWait();
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertTrue(waitForElement(btn_btList).isEnabled(),"Error: Button is disabled");
    	Assert.assertTrue(waitForElement(btn_btnInvDetails).isEnabled(),"Error: Button is disabled");
    	Assert.assertTrue(waitForElement(btn_btSave).isEnabled(),"Error: Button is disabled");
    	Assert.assertTrue(waitForElement(btn_btnExceptions).isEnabled(),"Error: Button is disabled");
    	Assert.assertTrue(waitForElement(btn_btRejectInvoice).isEnabled(),"Error: Button is disabled");
    	Assert.assertTrue(waitForElement(btn_close).isEnabled(),"Error: Button is disabled");
    	Assert.assertTrue(waitForElement(btn_clear).isEnabled(),"Error: Button is disabled");
    	click(btn_clear);
    	minWait();
    	Assert.assertTrue(waitForElement(text_airlineCode).getAttribute("value").contains(""),"Error: Value cleared");
        }
        else{
        	Assert.assertTrue(waitForElement(btn_btList).isEnabled(),"Error: Button is disabled");
        	Assert.assertTrue(waitForElement(btn_close).isEnabled(),"Error: Button is disabled");
        	Assert.assertTrue(waitForElement(btn_clear).isEnabled(),"Error: Button is disabled");
        	
        }

    	return this;
    }
  

    public CRA178 UnbalancedBalanced_Modify(String clearancePeriod, String weightCharg, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String awbNum) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
        //billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();


        int TmpWt = Integer.parseInt(weightCharg);
        TmpWt = TmpWt + 200;
        String wtChgNew = Integer.toString(TmpWt);
        enterKeys(txt_totalWtRateChargesInListingCurrency, wtChgNew + Keys.TAB);


        click(btn_btSave);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbNum + Keys.TAB);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum + Keys.TAB);
        minWait();
        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        TmpWt = TmpWt + 400;
        String wtChgNew1 = Integer.toString(TmpWt);
        enterKeys(txt_totalWtRateChargesInListingCurrency, wtChgNew1 + Keys.TAB);
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, wtChgNew1);
        click(CaptureInvpopupbtn_btnOk);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_btSave);
        minWait();
        String status = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status.equals("Unbalanced"));
        click(btn_CapInvDetailsClose);

        minWait();
        enterKeys(txt_totalWtRateChargesInListingCurrency, wtChgNew1);

        return this;
    }


    public CRA178 Edit(String weightCharg) {

    
    	weightCharg=PropertyHandler.getPropValue(dataFilePath, weightCharg);
    	int TmpWt=Integer.parseInt(weightCharg);
    	TmpWt=TmpWt+400;
    	String wtChgNew=Integer.toString(TmpWt);
    	
    click(btn_CapInvDetailsClose);
	
	minWait();
	enterKeys(txt_totalWtRateChargesInListingCurrency, wtChgNew);
	
    return this;
}
    
    public CRA178 Balanced_Modify(String clearancePeriod,String weightCharg, String carriercode,String awbPrefix,String awbNum) {


        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        int TmpWt = Integer.parseInt(weightCharg);
        TmpWt = TmpWt + 400;
        String wtChgNew = Integer.toString(TmpWt);

        click(btn_CapInvDetailsClose);

        minWait();
        enterKeys(txt_totalWtRateChargesInListingCurrency, wtChgNew);

        return this;
    }

    public CRA178 Balanced_Modify(String clearancePeriod, String weightCharg, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String awbNum) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
        //billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();


        int TmpWt = Integer.parseInt(weightCharg);
        TmpWt = TmpWt + 200;
        String wtChgNew = Integer.toString(TmpWt);
        enterKeys(txt_totalWtRateChargesInListingCurrency, wtChgNew + Keys.TAB);


    	clearancePeriod = PropertyHandler.getPropValue(dataFilePath,clearancePeriod);
    	carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
    	
    	//billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);
    	weightCharg=PropertyHandler.getPropValue(dataFilePath, weightCharg);
    	awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNum=PropertyHandler.getPropValue(dataFilePath, awbNum);



        click(btn_btSave);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbNum + Keys.TAB);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum + Keys.TAB);
        minWait();
        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, wtChgNew);
        click(CaptureInvpopupbtn_btnOk);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_btSave);
        minWait();
        String status = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status.equals("Balanced"));
        click(btn_CapInvDetailsClose);
        minWait();

        Assert.assertFalse(waitForElement(txt_totalWtRateChargesInListingCurrency).isEnabled(), "Error: The field is editable");

        return this;
    }




    public CRA178 CreateNew_SaveModify(String clearancePeriod, String carriercode,String awbPrefix){


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
      
        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);
        Assert.assertTrue(waitForElement(txt_airlineNo).getAttribute("value").contains(awbPrefix), "Error: The airline no is not populated");
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();


        driver.switchTo().defaultContent();
        minWait();

        Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Invoice Summary does not exist for the filter criteria. Expecting IS-XML File, Do you want to create ?"), "Error:Message not shown");

        click(yesBtn);
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        enterKeys(text_noOfAwbs, "1");
        enterKeys(txt_totalWtRateChargesInListingCurrency, "100");
        enterKeys(text_totalValuationChargeListingCurrency, "100");
        enterKeys(text_totalOtherChargesInListingCurrency, "10");
        enterKeys(text_netIsCChargesInListingCurrency, "100");
        enterKeys(text_totalVatListingCurrency, "10" + Keys.TAB);

              click(btn_btSave);


        minWait();
        String status = getTableCellValue(tbl_Form1Details, 11, 1);
        Assert.assertTrue(status.contains("New"), "Error: The Status is not matching");
       

        enterKeys(txt_totalWtRateChargesInListingCurrency, "200");
        click(btn_btSave);

        minWait();

        Assert.assertTrue(waitForElement(txt_totalWtRateChargesInListingCurrency).getAttribute("value").contains("200"), "Error: The Value is not matching");

        return this;
    }


    public CRA178 SameBillingType_Error(String clearancePeriod, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
        //billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);

        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);


        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);
        Assert.assertTrue(waitForElement(txt_airlineNo).getAttribute("value").contains(awbPrefix), "Error: The airline no is not populated");
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();

        driver.switchTo().defaultContent();
        minWait();

        Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Invoice Summary does not exist for the filter criteria. Expecting IS-XML File, Do you want to create ?"), "Error:Message not shown");

        click(yesBtn);
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        enterKeys(text_noOfAwbs, "1");
        enterKeys(txt_totalWtRateChargesInListingCurrency, "100");
        enterKeys(text_totalValuationChargeListingCurrency, "100");
        enterKeys(text_totalOtherChargesInListingCurrency, "10");
        enterKeys(text_netIsCChargesInListingCurrency, "100");
        enterKeys(text_totalVatListingCurrency, "10" + Keys.TAB);

        enterKeys(getWebElements(txt_totalWtRateChargesInListingCurrency).get(1), "100");
        enterKeys(getWebElements(text_totalValuationChargeListingCurrency).get(1), "100");
        enterKeys(getWebElements(text_totalOtherChargesInListingCurrency).get(1), "10");
        enterKeys(getWebElements(text_netIsCChargesInListingCurrency).get(1), "100");
        enterKeys(getWebElements(text_totalVatListingCurrency).get(1), "10");


        click(btn_btSave);

        minWait();

        Assert.assertTrue(waitForElement(info_error).getText().contains("Same billing type can't be repeated in a single invoice"), "Error: Same billing type can't be repeated in a single invoice");
        return this;
    }

    /**
     * @param invoiceNum
     * @return
     */
    public CRA178 deleteData(String invoiceNum) {

        invoiceNum = PropertyHandler.getPropValue(dataFilePath, invoiceNum);

        enterKeys(txt_invoiceNumber, invoiceNum);
        click(btn_invoiceNumbtLov);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();


        check(chkbx_slectInvoiceNum);
        click(btn_ivoiceNumberLovpopup_OK);

        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);
        click(btn_btList);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();
        check(CaptureInvchk_chk);

        click(captureInvDetails_btn_deleteLink);
        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        click(btn_btSave);

        minWait();
        return this;
    }


    public CRA178 InvoiceGenaration_balanced_processedError(String clearancePeriod, String weightCharg, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String awbNum) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
//billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();
        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);

        int TmpWt = Integer.parseInt(weightCharg);
        TmpWt = TmpWt + 200;
        String wtChgNew = Integer.toString(TmpWt);
        enterKeys(txt_totalWtRateChargesInListingCurrency, wtChgNew + Keys.TAB);


        click(btn_btSave);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbPrefix + Keys.TAB);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum + Keys.TAB);
        minWait();
        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, wtChgNew);
        click(CaptureInvpopupbtn_btnOk);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_btSave);
        minWait();
        String status = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status.equals("Balanced"));
        check(CaptureInvchk_chk);
        click(CaptureInvbtn_btnProcess);
        minWait();

        String status2 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status2.equals("Processed with error"));


        return this;
    }


    public CRA178 Verify_Invoicetype() {


        Assert.assertTrue(waitForElement(dropdown_invoiceType).getText().contains("Credit Note"), "Error: Value not present");
        Assert.assertTrue(waitForElement(dropdown_invoiceType).getText().contains("Invoice"), "Error: Value not present");
        return this;

    }

    public CRA178 MandatoryField_Error(String carriercode) {


        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        text_airlineCode = MiscUtility.getWebElement(objFilepath, "CRA178_text_airlineCode");
        btn_airlinecodelov = MiscUtility.getWebElement(objFilepath, "CRA178_btn_airlinecodelov");
        text_filterAirlineNumber = MiscUtility.getWebElement(objFilepath, "CRA178_text_filterAirlineNumber");
        check_airlinecodelovselectCheckBox = MiscUtility.getWebElement(objFilepath, "CRA178_check_airlinecodelovselectCheckBox");
        btn_airlinecodelovbtnOk = MiscUtility.getWebElement(objFilepath, "CRA178_btn_airlinecodelovbtnOk");

        enterKeys(text_airlineCode, carriercode);
        click(btn_airlinecodelov);
        minWait();
        switchToSecondWindow();


        check(check_airlinecodelovselectCheckBox);
        click(btn_airlinecodelovbtnOk);

        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);


        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        enterKeys(txt_invoiceNumber, "");
        click(btn_invoicenolov);
        minWait();
        switchToSecondWindow();
        check(checkbox_invoicenolovselectCheckBox);
        click(btn_invoicenolovbtnOk);

        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        enterKeys(txt_clearanceYear, "");
        click(btn_btList);
        minWait();

        Assert.assertTrue(waitForElement(info_error).getText().contains("Clearance Period is mandatory."), "Error:Mandatory error not sown");
        return this;
    }

    public CRA178 Verify_ListingCurrency(String clearancePeriod, String carriercode, String flightStartDate, String flightEndDate, String ListCurr) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
        ListCurr = PropertyHandler.getPropValue(dataFilePath, ListCurr);
//billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);


        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);

        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();

        driver.switchTo().defaultContent();
        minWait();

        Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Invoice Summary does not exist for the filter criteria. Expecting IS-XML File, Do you want to create ?"), "Error:Message not shown");

        click(yesBtn);
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();

        Assert.assertTrue(waitForElement(text_listingCurrency).getAttribute("value").contains(ListCurr), "Error: The listing currency doesnot match with that of airline");
        return this;
    }

    public CRA178 NewInvoice_AndDelete(String clearancePeriod, String carriercode,String awbPrefix,String Invoice) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
     

        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);


        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);
        Assert.assertTrue(waitForElement(txt_airlineNo).getAttribute("value").contains(awbPrefix), "Error: The airline no is not populated");
        String invoice = BizUtility.createInvoiceNumber();
        PropertyHandler.setPropValue(dataFilePath, Invoice, invoice);
        Invoice = PropertyHandler.getPropValue(dataFilePath, Invoice);
        enterKeys(txt_invoiceNumber, Invoice);
        
        click(btn_btList);
        minWait();

        driver.switchTo().defaultContent();
        minWait();

        Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Invoice Summary does not exist for the filter criteria. Expecting IS-XML File, Do you want to create ?"), "Error:Message not shown");

        click(yesBtn);
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        enterKeys(text_noOfAwbs, "1");
        enterKeys(txt_totalWtRateChargesInListingCurrency, "100");
        enterKeys(text_totalValuationChargeListingCurrency, "100");
        enterKeys(text_totalOtherChargesInListingCurrency, "10");
        enterKeys(text_netIsCChargesInListingCurrency, "100");
        enterKeys(text_totalVatListingCurrency, "10" + Keys.TAB);
        Assert.assertTrue(waitForElement(text_totalAmountInListingCurrency).getAttribute("value").contains("320"), "Error: The total value is not correct");


        click(btn_btSave);

        minWait();

        Assert.assertTrue(waitForElement(txt_totalWtRateChargesInListingCurrency).getAttribute("value").contains("100"), "Error: Data is not saved");
        Assert.assertTrue(waitForElement(text_totalValuationChargeListingCurrency).getAttribute("value").contains("100"), "Error: Data is not saved");
        Assert.assertTrue(waitForElement(text_totalOtherChargesInListingCurrency).getAttribute("value").contains("10"), "Error: Data is not saved");
        Assert.assertTrue(waitForElement(text_netIsCChargesInListingCurrency).getAttribute("value").contains("100"), "Error: Data is not saved");
        Assert.assertTrue(waitForElement(text_totalVatListingCurrency).getAttribute("value").contains("10"), "Error: Data is not saved");

        unCheck(checkbox_selectedRow);
        click(btn_lnkDelete);
        minWait();
        driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Please select a row."), "Error: error msg not shown");
        click(okBtn);
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();

        check(checkbox_selectedRow);
        click(btn_lnkDelete);
        minWait();
        click(btn_btSave);
        minWait();
        driver.switchTo().defaultContent();

        click(yesBtn);
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();


        return this;
    }
    
    public CRA178 CheckDeletedInvoice(String Invoice){
    	
    	Invoice = PropertyHandler.getPropValue(dataFilePath, Invoice);
    	click(btn_invoiceNumbtLov);
    	minWait();
    	switchToSecondWindow();
    	enterKeys(txt_invoicenopopup, Invoice);
    	click(btn);
 Assert.assertTrue(waitForElement(chkbox_selectCheckBoxInvpopup).isDisplayed(),"Error: ")   ;
  
    	return this;
    }

    public CRA178 NewInvoice_AndModify(String clearancePeriod, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String AWBNo) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
//billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);

        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);
        Assert.assertTrue(waitForElement(txt_airlineNo).getAttribute("value").contains(awbPrefix), "Error: The airline no is not populated");
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();

        driver.switchTo().defaultContent();
        minWait();

        Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Invoice Summary does not exist for the filter criteria. Expecting IS-XML File, Do you want to create ?"), "Error:Message not shown");

        click(yesBtn);
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        enterKeys(text_noOfAwbs, "1");
        enterKeys(txt_totalWtRateChargesInListingCurrency, "100");
        enterKeys(text_totalValuationChargeListingCurrency, "100");
        enterKeys(text_totalOtherChargesInListingCurrency, "10");
        enterKeys(text_netIsCChargesInListingCurrency, "100");
        enterKeys(text_totalVatListingCurrency, "10" + Keys.TAB);
        Assert.assertTrue(waitForElement(text_totalAmountInListingCurrency).getAttribute("value").contains("320"), "Error: The total value is not correct");


        click(btn_btSave);
        minWait();
        minWait();
        String status = getTableCellValue(tbl_Form1Details, 11, 1);
        Assert.assertTrue(status.contains("New"), "Error: The Status is not matching");

        enterKeys(txt_totalWtRateChargesInListingCurrency, "200");
        enterKeys(text_totalValuationChargeListingCurrency, "100");
        enterKeys(text_totalOtherChargesInListingCurrency, "10");
        enterKeys(text_netIsCChargesInListingCurrency, "100");
        enterKeys(text_totalVatListingCurrency, "10" + Keys.TAB);
        Assert.assertTrue(waitForElement(text_totalAmountInListingCurrency).getAttribute("value").contains("420"), "Error: The total value is not correct");

        click(btn_btSave);
        minWait();
        minWait();
        String status1 = getTableCellValue(tbl_Form1Details, 11, 1);
        Assert.assertTrue(status1.contains("New"), "Error: The Status is not matching");


        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbPrefix + Keys.TAB);
        enterKeys(CaptureInvpopuptext_documentNumber, AWBNo + Keys.TAB);
        minWait();
        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, "420");
        click(CaptureInvpopupbtn_btnOk);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_btSave);
        minWait();
        String status2 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status2.equals("Balanced"));
        tblSelectRowByMultipleColValue(tbl_CapInvDetailscaptureAWBDetails, 1, 10, 21, "420", "Transaction");

        return this;
    }

    public CRA178 NewInvoice_Noclick(String clearancePeriod, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String awbNum) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
//billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);

        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);
        Assert.assertTrue(waitForElement(txt_airlineNo).getAttribute("value").contains(awbPrefix), "Error: The airline no is not populated");
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();

        driver.switchTo().defaultContent();
        minWait();

        Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Invoice Summary does not exist for the filter criteria. Expecting IS-XML File, Do you want to create ?"), "Error:Message not shown");
        click(noBtn);
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();

        Assert.assertTrue(waitForElement(txt_clearanceYear).getAttribute("value").isEmpty(), "Error: The clearence period is blank");
        Assert.assertTrue(waitForElement(txt_airlineCode).getAttribute("value").isEmpty(), "Error: The airline code is blank");
        Assert.assertTrue(waitForElement(txt_invoiceNumber).getAttribute("value").isEmpty(), "Error: The invoice no is blank");
        return this;
    }

    public CRA178 InvoiceGenaration_balanced_processed(String clearancePeriod, String weightCharg, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String awbPrefix_OAL, String awbNum) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
//billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbPrefix_OAL = PropertyHandler.getPropValue(dataFilePath, awbPrefix_OAL);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);
        Assert.assertTrue(waitForElement(txt_airlineNo).getAttribute("value").contains(awbPrefix_OAL), "Error: The airline no is not populated");
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg);
        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg + Keys.TAB);


        click(btn_btSave);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbPrefix);
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbPrefix + Keys.TAB);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum + Keys.TAB);
        minWait();
//driver.switchTo().defaultContent();
//minWait();
/*if (verifyElementPresent(yesBtn)) {
    
    click(yesBtn);
}
waitForFrameAndSwitch(FRAME);*/
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, weightCharg);
        click(CaptureInvpopupbtn_btnOk);
        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_CaptureInvoicebtnSave);
        minWait();
        String status = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status.equals("Balanced"));
        check(CaptureInvchk_chk);
        click(CaptureInvbtn_btnProcess);
        minWait();

        String status2 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status2.equals("Processed"));


        return this;
    }

    public CRA178 StoreInvoiceNo(String InvNo) {

        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        PropertyHandler.setPropValue(dataFilePath, InvNo, invoice);
        InvNo = PropertyHandler.getPropValue(dataFilePath, InvNo);


        return this;
    }

    public CRA178 InvoiceGenaration_balanced_processedWithError(String clearancePeriod, String weightCharg, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String awbNum, String InvNo, String... chargType) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
//billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);

        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);
//Assert.assertTrue(waitForElement(txt_airlineNo).getAttribute("value").contains(awbPrefix),"Error: The airline no is not populated");
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);

        PropertyHandler.setPropValue(dataFilePath, InvNo, invoice);
        click(btn_btList);
        minWait();

        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);

        if (chargType.length != 0) {
            if (chargType[0].equalsIgnoreCase("PP")) {
                selectByText(dropdown_billingType, "Prepaid AirWaybill");
            }

            if (chargType[0].equalsIgnoreCase("CC")) {
                selectByText(dropdown_billingType, "Collect AirWaybill");
            }
        }

        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg);
        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg + Keys.TAB);


        click(btn_btSave);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbPrefix);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum);
        minWait();
//driver.switchTo().defaultContent();
//minWait();
/*if (verifyElementPresent(yesBtn)) {
    
    click(yesBtn);
}
waitForFrameAndSwitch(FRAME);*/
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, weightCharg);
        click(CaptureInvpopupbtn_btnOk);
        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_CaptureInvoicebtnSave);
        minWait();
        String status = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status.equals("Balanced"));
        check(CaptureInvchk_chk);
        click(CaptureInvbtn_btnProcess);
        minWait();

        String status2 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status2.equals("Processed with error"));

        click(btn_CapInvDetailsClose);


        return this;
    }
    
   
    /**
     *@author A-8260
     * @param clearancePeriod
     * @param weightCharg
     * @param carriercode
     * @param flightStartDate
     * @param flightEndDate
     * @param awbPrefix
     * @param awbNum
     * @param InvNo
     * @param chargType
     * @return
     */
    public CRA178 InvoiceGenaration_balanced_processedSuccessful(String clearancePeriod, String weightCharg, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String awbNum, String InvNo, String... chargType) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
//billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);

        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        //enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_clearanceYear, BizUtility.getClearancePeriod());
        enterKeys(txt_airlineCode, carriercode);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);
//Assert.assertTrue(waitForElement(txt_airlineNo).getAttribute("value").contains(awbPrefix),"Error: The airline no is not populated");
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);

        PropertyHandler.setPropValue(dataFilePath, InvNo, invoice);
        click(btn_btList);
        minWait();

        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);

        if (chargType.length != 0) {
            if (chargType[0].equalsIgnoreCase("PP")) {
                selectByText(dropdown_billingType, "Prepaid AirWaybill");
            }

            if (chargType[0].equalsIgnoreCase("CC")) {
                selectByText(dropdown_billingType, "Collect AirWaybill");
            }
        }

        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg);
        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg + Keys.TAB);


        click(btn_btSave);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbPrefix);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum);
        minWait();
//driver.switchTo().defaultContent();
//minWait();
/*if (verifyElementPresent(yesBtn)) {
    
    click(yesBtn);
}
waitForFrameAndSwitch(FRAME);*/
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, weightCharg);
        click(CaptureInvpopupbtn_btnOk);
        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_CaptureInvoicebtnSave);
        minWait();
        String status = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status.equals("Balanced"));
        check(CaptureInvchk_chk);
        click(CaptureInvbtn_btnProcess);
        minWait();

        String status2 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status2.contains("Processed"));

        click(btn_CapInvDetailsClose);


        return this;
    }

    

    public CRA178 InvoiceGenaration_balanced_processedWithErrorWithRoute(String clearancePeriod, String weightCharg, String carriercode, String awbPrefix, String awbNum, String carrFrm, String carrTo, String InvNo, String... chargType) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);
//Assert.assertTrue(waitForElement(txt_airlineNo).getAttribute("value").contains(awbPrefix),"Error: The airline no is not populated");
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);

        PropertyHandler.setPropValue(dataFilePath, InvNo, invoice);
        click(btn_btList);
        minWait();

        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);

        if (chargType.length != 0) {
            if (chargType[0].equalsIgnoreCase("PP")) {
                selectByText(dropdown_billingType, "Prepaid AirWaybill");
            }

            if (chargType[0].equalsIgnoreCase("CC")) {
                selectByText(dropdown_billingType, "Collect AirWaybill");
            }
        }

        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg);
        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg + Keys.TAB);


        click(btn_btSave);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbPrefix);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum);
        minWait();
        enterKeys(captureInvpopup_txt_carrierFrom,carrFrm);
        enterKeys(captureInvpopup_txt_carrierTo,carrTo);
//driver.switchTo().defaultContent();
//minWait();
/*if (verifyElementPresent(yesBtn)) {

    click(yesBtn);
}
waitForFrameAndSwitch(FRAME);*/
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, weightCharg);
        click(CaptureInvpopupbtn_btnOk);
        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_CaptureInvoicebtnSave);
        minWait();
        String status = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status.equals("Balanced"));
        check(CaptureInvchk_chk);
        click(CaptureInvbtn_btnProcess);
        minWait();

        String status2 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status2.equals("Processed with error"));

        click(btn_CapInvDetailsClose);


        return this;
    }


    public CRA178 InvoiceGenaration_balanced_deleteRecord(String clearancePeriod, String weightCharg, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String awbPrefix_OAL, String awbNum, String InvNo) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
//billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbPrefix_OAL = PropertyHandler.getPropValue(dataFilePath, awbPrefix_OAL);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);
//Assert.assertTrue(waitForElement(txt_airlineNo).getAttribute("value").contains(awbPrefix),"Error: The airline no is not populated");
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);

        PropertyHandler.setPropValue(dataFilePath, InvNo, invoice);
        InvNo = PropertyHandler.getPropValue(dataFilePath, InvNo);
        click(btn_btList);
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg);
        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg + Keys.TAB);


        click(btn_btSave);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbPrefix);
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbPrefix + Keys.TAB);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum + Keys.TAB);
        minWait();
//driver.switchTo().defaultContent();
//minWait();
/*if (verifyElementPresent(yesBtn)) {
    
    click(yesBtn);
}
waitForFrameAndSwitch(FRAME);*/
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, weightCharg);
        click(CaptureInvpopupbtn_btnOk);
        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_CaptureInvoicebtnSave);
        minWait();
        String status = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status.equals("Balanced"));
        check(CaptureInvchk_chk);
        click(CaptureInvbtn_deleteLink);
        minWait();
        driver.switchTo().defaultContent();
        click(yesBtn);
        waitForFrameAndSwitch(FRAME);


        return this;
    }

    public CRA178 InvoiceGenaration_balanced_ChkError(String clearancePeriod, String weightCharg, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String awbPrefix_OAL, String awbNum, String InvNo) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
//billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbPrefix_OAL = PropertyHandler.getPropValue(dataFilePath, awbPrefix_OAL);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        enterKeys(txt_airlineCode, carriercode + Keys.TAB);
//Assert.assertTrue(waitForElement(txt_airlineNo).getAttribute("value").contains(awbPrefix),"Error: The airline no is not populated");
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);

        PropertyHandler.setPropValue(dataFilePath, InvNo, invoice);
        InvNo = PropertyHandler.getPropValue(dataFilePath, InvNo);
        click(btn_btList);
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg);
        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg + Keys.TAB);


        click(btn_btSave);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();

        click(CaptureInvpopupbtn_btnOk);

        minWait();

        Assert.assertTrue(waitForElement(info_error).getText().contains("AWB Number Or Memo Number is mandatory."));

        click(btn_CaptureInvoicenetbtnClose);
        return this;
    }

    public CRA178 New_BalancedInvoice(String clearancePeriod, String weightCharg, String carriercode, String awbPrefix, String awbNum, String invNo) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        String invoice = BizUtility.createInvoiceNumber();
        PropertyHandler.setPropValue(dataFilePath, invNo, invoice);
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();

        minWait();
        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);


        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg + Keys.TAB);


        click(btn_btSave);

        minWait();
        String status = getTableCellValue(tbl_Form1Details, 11, 1);
        Assert.assertTrue(status.contains("New"), "Error: The Status is not matching");
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbPrefix + Keys.TAB);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum + Keys.TAB);
        minWait();
/*driver.switchTo().defaultContent();
minWait();
if (verifyElementPresent(yesBtn)) {
    
    click(yesBtn);
}
waitForFrameAndSwitch(FRAME);*/
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, weightCharg);
        click(CaptureInvpopupbtn_btnOk);
        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);
        click(CaptureInv_btnSave);
        minWait();
//tblSelectRowByColValue(tbl_CapInvDetailscaptureAWBDetails, 1, 10, weightCharg);

        String status1 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status1.equals("Balanced"));

        check(CaptureInvchk_chk);
        click(CaptureInvbtn_btnProcess);
        minWait();

        String status2 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status2.equals("Processed"));

        click(btn_CapInvDetailsClose);
        minWait();


        return this;
    }

    public CRA178 CaptureNewInvoice_Verify(String clearancePeriod, String carriercode, String LstCurr_OAL, String BlgCurr_OAL) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        LstCurr_OAL = PropertyHandler.getPropValue(dataFilePath, LstCurr_OAL);
        BlgCurr_OAL = PropertyHandler.getPropValue(dataFilePath, BlgCurr_OAL);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();

        minWait();
        driver.switchTo().defaultContent();
        minWait();

        if (verifyElementPresent(yesBtn)) {
            Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Invoice Summary does not exist for the filter criteria. Expecting IS-XML File, Do you want to create ?"), "Error:The message is not shown");
            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);

        Assert.assertTrue(waitForElement(text_listingCurrency).getAttribute("value").contains(LstCurr_OAL), "Error: Mismatch in currency");
        Assert.assertTrue(waitForElement(text_billingCurrency).getAttribute("value").contains(BlgCurr_OAL), "Error: Mismatch in currency");
        Assert.assertTrue(waitForElement(text_billingCurrency).getAttribute("readonly") == null, "Error: the field is not editable");
        Assert.assertTrue(waitForElement(dropdown_billingType).getText().contains("Billing Memo"), "Error: Value not found");
        Assert.assertTrue(waitForElement(dropdown_billingType).getText().contains("Collect AirWaybill"), "Error: Value not found");
        Assert.assertTrue(waitForElement(dropdown_billingType).getText().contains("Prepaid AirWaybill"), "Error: Value not found");
        Assert.assertTrue(waitForElement(dropdown_billingType).getText().contains("Rejection Memo"), "Error: Value not found");
        Assert.assertFalse(waitForElement(txt_exchangeRate).getText().contains(" "), "Error: The value is present");
        enterKeys(text_invoiceDate, "+1");
        enterKeys(txt_totalWtRateChargesInListingCurrency, "1000" + Keys.TAB);
        click(btn_btSave);
        minWait();
        Assert.assertTrue(waitForElement(info_error).getText().contains("Invoice Date cannot be greater than Current Date."), "Error: The data validation not shown");
        enterKeys(text_invoiceDate, "");

        enterKeys(txt_totalWtRateChargesInListingCurrency, "1000" + Keys.TAB);
        enterKeys(text_totalValuationChargeListingCurrency, "100");
        enterKeys(text_totalOtherChargesInListingCurrency, "100");
        enterKeys(text_netIsCChargesInListingCurrency, "50");
        enterKeys(text_totalVatListingCurrency, "50" + Keys.TAB);
        Assert.assertTrue(waitForElement(text_totalAmountInListingCurrency).getAttribute("value").contains("1300"), "Error: Value mismatch");

        click(btn_btSave);

        minWait();
        String status = getTableCellValue(tbl_Form1Details, 11, 1);
        Assert.assertTrue(status.contains("New"), "Error: The Status is not matching");
        return this;
    }


    public CRA178 New_UnBalancedInvoice(String clearancePeriod, String weightCharg, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String awbNum, String InvoiceNo) {


        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
//billingPeriod= PropertyHandler.getPropValue(dataFilePath, billingPeriod);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        String invoice = BizUtility.createInvoiceNumber();
        PropertyHandler.setPropValue(dataFilePath, InvoiceNo, invoice);
        enterKeys(txt_invoiceNumber, invoice);
        click(btn_btList);
        minWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);

        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg + Keys.TAB);


        click(btn_btSave);

        minWait();
        String status = getTableCellValue(tbl_Form1Details, 11, 1);
        Assert.assertTrue(status.contains("New"), "Error: The Status is not matching");
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbPrefix + Keys.TAB);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum + Keys.TAB);
        minWait();
/*driver.switchTo().defaultContent();
minWait();
if (verifyElementPresent(yesBtn)) {
    
    click(yesBtn);
}
<<<<<<< .mine
waitForFrameAndSwitch(FRAME);
int WChrg = Integer.parseInt(weightCharg);
WChrg=WChrg+500;
System.out.println(WChrg);
String weightCharge=String.valueOf(WChrg);
System.out.println(weightCharge);
enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, weightCharge);
click(CaptureInvpopupbtn_btnOk);
switchToFirstWindow();
waitForFrameAndSwitch(FRAME); 
click(btn_CaptureInvoicebtnSave);
minWait();
String status1=waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
Assert.assertTrue(status1.equals("Unbalanced"));
click(btn_CapInvDetailsClose);
minWait();


waitForFrameAndSwitch(FRAME);*/
        int WChrg = Integer.parseInt(weightCharg);
        WChrg = WChrg + 500;
        String weightCharge = String.valueOf(WChrg);
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, weightCharge);
        click(CaptureInvpopupbtn_btnOk);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_CaptureInvoicebtnSave);
        minWait();
        String status1 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status1.equals("Unbalanced"));
        click(btn_CapInvDetailsClose);
        minWait();




        return this;
    }


    public CRA178 Modify_Details(String weightcharge, String invoiceNo) {



	weightcharge = PropertyHandler.getPropValue(dataFilePath,weightcharge);
	invoiceNo = PropertyHandler.getPropValue(dataFilePath,invoiceNo);
	
	enterKeys(txt_invoiceNumber, invoiceNo);
	click(btn_invoiceNumbtLov);
	minWait();
	switchToSecondWindow();
	check(checkbox_invoicenolovselectCheckBox);
	click(btn_invoicenolovbtnOk);
	minWait();
    switchToFirstWindow();
    waitForFrameAndSwitch(FRAME);
    weightcharge=weightcharge.replace(",","");
    float Wchrg=Float.parseFloat(weightcharge);
    Wchrg=Wchrg-100;
    String WtgChrg=String.valueOf(Wchrg);
    enterKeys(txt_totalWtRateChargesInListingCurrency, WtgChrg);
    click(btn_btSave);
    minWait();
    Assert.assertTrue(waitForElement(txt_totalWtRateChargesInListingCurrency).getAttribute("value").contains(WtgChrg),"Error: Value mismatch");
    
	
return this;
}

public CRA178 Check_Status(String weightcharge,String invoiceNo,String Status){
	


	weightcharge = PropertyHandler.getPropValue(dataFilePath,weightcharge);
	invoiceNo = PropertyHandler.getPropValue(dataFilePath,invoiceNo);
	
	enterKeys(txt_invoiceNumber, invoiceNo);
	click(btn_invoiceNumbtLov);
	minWait();
	switchToSecondWindow();
	check(checkbox_invoicenolovselectCheckBox);
	click(btn_invoicenolovbtnOk);
	minWait();
    switchToFirstWindow();
    waitForFrameAndSwitch(FRAME);
   
    String status1=waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
    Assert.assertTrue(status1.equals(Status));
    
	
return this;
}

/*public CRA178 Create_UnBalancedInvoice(String invoiceNum,String weightCharg,String weightChargAddn,String awbPrefix,String awbNum) {

        weightcharge = PropertyHandler.getPropValue(dataFilePath, weightcharge);
        invoiceNo = PropertyHandler.getPropValue(dataFilePath, invoiceNo);


        enterKeys(txt_invoiceNumber, invoiceNo);
        click(btn_invoiceNumbtLov);
        minWait();
        switchToSecondWindow();
        check(checkbox_invoicenolovselectCheckBox);
        click(btn_invoicenolovbtnOk);
        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        weightcharge = weightcharge.replace(",", "");
        float Wchrg = Float.parseFloat(weightcharge);
        Wchrg = Wchrg - 100;
        String WtgChrg = String.valueOf(Wchrg);
        enterKeys(txt_totalWtRateChargesInListingCurrency, WtgChrg);
        click(btn_btSave);
        minWait();
        Assert.assertTrue(waitForElement(txt_totalWtRateChargesInListingCurrency).getAttribute("value").contains(WtgChrg), "Error: Value mismatch");


        return this;
    }

*/    public CRA178 Create_UnBalancedInvoice(String invoiceNum, String weightCharg, String weightChargAddn, String awbPrefix, String awbNum) {


        invoiceNum = PropertyHandler.getPropValue(dataFilePath, invoiceNum);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);


        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        invoiceNum = PropertyHandler.getPropValue(dataFilePath, invoiceNum);

        enterKeys(txt_invoiceNumber, invoiceNum);
        click(btn_invoiceNumbtLov);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();


        check(chkbx_slectInvoiceNum);
        click(btn_ivoiceNumberLovpopup_OK);

        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);
        click(btn_btList);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();
        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbNum + Keys.TAB);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNum + Keys.TAB);
        minWait();
        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        int WChrg = Integer.parseInt(weightCharg);
        WChrg = WChrg + 500;
        String weightCharge = String.valueOf(WChrg);
        PropertyHandler.setPropValue(dataFilePath, weightChargAddn, weightCharge);
        weightChargAddn = PropertyHandler.getPropValue(dataFilePath, weightChargAddn);
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, weightChargAddn);
        click(CaptureInvpopupbtn_btnOk);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_btSave);
        minWait();
        String status1 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status1.equals("UnBalanced"));


        return this;
    }

    public CRA178 Create_BalancedInvoice(String invoiceNum, String weightChargAddn) {


        invoiceNum = PropertyHandler.getPropValue(dataFilePath, invoiceNum);
        weightChargAddn = PropertyHandler.getPropValue(dataFilePath, weightChargAddn);


        invoiceNum = PropertyHandler.getPropValue(dataFilePath, invoiceNum);

        enterKeys(txt_invoiceNumber, invoiceNum);
        click(btn_invoiceNumbtLov);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();


        check(chkbx_slectInvoiceNum);
        click(btn_ivoiceNumberLovpopup_OK);

        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);
        click(btn_btList);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();
        check(CaptureInvchk_chk);
        click(CaptureInvbtn_modifyLink);
        waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, weightChargAddn);
        click(CaptureInvpopupbtn_btnOk);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_btSave);
        minWait();
        String status1 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status1.equals("Balanced"));


        return this;
    }


    public CRA178 NewInv(String clearancePeriod, String weightCharg, String carriercode, String flightStartDate, String flightEndDate, String awbPrefix, String awbNum, String InvNo) {

        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
        weightCharg = PropertyHandler.getPropValue(dataFilePath, weightCharg);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNum = PropertyHandler.getPropValue(dataFilePath, awbNum);

        enterKeys(txt_clearanceYear, clearancePeriod);
        enterKeys(txt_airlineCode, carriercode);
        String invoice = BizUtility.createInvoiceNumber();
        enterKeys(txt_invoiceNumber, invoice);

        PropertyHandler.setPropValue(dataFilePath, InvNo, invoice);
        InvNo = PropertyHandler.getPropValue(dataFilePath, InvNo);

        enterKeys(txt_invoiceNumber, InvNo);
        click(btn_btList);
        minWait();
        enterKeys(txt_totalWtRateChargesInListingCurrency, weightCharg + Keys.TAB);
        click(btn_btSave);
        minWait();
        String status = getTableCellValue(tbl_Form1Details, 11, 1);
        Assert.assertTrue(status.contains("New"), "Error: The Status is not matching");
        return this;

    }


    /**
     * @param awbprefix
     * @param awbNo
     * @param origin
     * @param destination
     * @param intermediate
     * @param weightcharge
     * @param OALcarrier
     * @return
     */
    public CRA178 captureInvoiceNotInCRAshipmnt(String invoiceNum, String clearnancePeriod, String awbprefix, String awbNo, String origin, String destination, String intermediate, String weightcharge, String OALcarrier) {

        awbprefix = PropertyHandler.getPropValue(dataFilePath, awbprefix);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        origin = PropertyHandler.getPropValue(dataFilePath, origin);
        destination = PropertyHandler.getPropValue(dataFilePath, destination);
        intermediate = PropertyHandler.getPropValue(dataFilePath, intermediate);
        weightcharge = PropertyHandler.getPropValue(dataFilePath, weightcharge);
        OALcarrier = PropertyHandler.getPropValue(dataFilePath, OALcarrier);
        clearnancePeriod = PropertyHandler.getPropValue(dataFilePath, clearnancePeriod);

        enterKeys(txt_clearanceYear, clearnancePeriod);
        enterKeys(txt_airlineCode, OALcarrier);

        String invNumbr = BizUtility.createInvoiceNumber();
        PropertyHandler.setPropValue(dataFilePath, invoiceNum, invNumbr);
        enterKeys(txt_invoiceNumber, invNumbr + Keys.TAB);
        click(btn_btList);


        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);


        enterKeys(txt_totalWtRateChargesInListingCurrency, weightcharge + Keys.TAB);


        click(btn_btSave);

        minWait();
        check(chkbx_slectInvoice);
        click(btn_btnInvDetails);
        maxWait();

        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);


        switchToSecondWindow();
        enterKeys(CaptutreInvpopup_txt_awbPrefix, awbprefix + Keys.TAB);
        enterKeys(CaptureInvpopuptext_documentNumber, awbNo + Keys.TAB);
        minWait();
        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        enterKeys(captureInvPopup_txt_flightdate, ".");
        enterKeys(captureInvpopup_txt_awborigin, origin);
        enterKeys(captureInvpopup_txt_awbDest, destination);
        enterKeys(captureInvpopup_txt_carrierFrom, intermediate);
        enterKeys(captureInvpopup_txt_carrierTo, destination);


        enterKeys(CaptureInvpopuptext_weightChargesInListingCurrency, weightcharge);
        click(CaptureInvpopupbtn_btnOk);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_btSave);
        minWait();
        String status = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status.equals("Balanced"));
        check(CaptureInvchk_chk);
        click(CaptureInvbtn_btnProcess);
        minWait();

        String status2 = waitForElement(CaptureInvpopup_info_invoiceStatus).getText();
        Assert.assertTrue(status2.equals("Processed with error"));

        check(CaptureInvchk_chk);

        click(captureInvDetails_btn_exception);
        maxWait();
        String excpvalue = getTableCellValue(ViewExceptiontbl_ViewExceptionDetails, 4, 1);
        Assert.assertTrue(excpvalue.contains("AWB Details not found in CRA"));

        click(captureInvDetails_btn_close);
        minWait();


        click(exception_btn_close);
        minWait();
        click(captureInvDetails_btn_close);

        return this;
    }

    /**
     * @param prefix
     * @param awbno
     * @param shipper_new
     * @param CCANo
     * @param accept
     * @param UpdateAWBAgentCheck
     * @return
     */

    public CRA178 CCAChangeOutboundCustomer(String prefix, String awbno, String shipper_new, String CCANo, boolean accept, boolean UpdateAWBAgentCheck) {

        prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
        awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
        return this;


        //enterKeys(text_shipmentPrefix, prefix);
        //enterKeys(text_documentNumber, awbno);}
    }


    public HomePage close() {


        click(btn_close);

        //    click(ViewRejectionMemobtn_btnClose);

        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }


    public CRA178 clear() {

        click(btn_clear);
        minWait();
        return this;
    }


}
