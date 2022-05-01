package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen CRA81
 * Created on 12/03/2018
 *
 * @author a-6784
 */
public class CRA182 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA181";
    public static String screenFrame = "iCargoContentFrameCRA181";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
 
    
    By
    Generic_btn_ok,info_msg,btn_btClear,
    yesBtn,txt_fromDate,txt_toDate,txt_airlineCode,txt_airlineNumber,info_error,
    txt_invoiceNumber,btn_list,btn_invoicelov,txt_invocieNolov,
    dropdown_billingTypeFltrinvoicelov,txt_clearancePeriodinvoicelov,btn_btnListinvocielov,
    btn_btnOkinvocielov,txt_airlineCodeinvoicelov,btn_btnCloseinvoicelov,
    tbl_rejectTxnListing,chkbox_select,btn_btViewRM,btn_btIssueRejectionMemo,
    btn_btClose,chkbox_selectCheckBoxinvoicelov;
    
    public CRA182(WebDriver driver, String dataFileName) {
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
    	
    	txt_fromDate =MiscUtility.getWebElement(objFilepath, "CRA182_txt_fromDate");
    	txt_toDate=MiscUtility.getWebElement(objFilepath, "CRA182_txt_toDate");
    	txt_airlineCode=MiscUtility.getWebElement(objFilepath, "CRA182_txt_airlineCode");
    	txt_airlineNumber=MiscUtility.getWebElement(objFilepath, "CRA182_txt_airlineNumber");
    	txt_invoiceNumber=MiscUtility.getWebElement(objFilepath, "CRA182_txt_invoiceNumber");
    	btn_list=MiscUtility.getWebElement(objFilepath, "CRA182_btn_list");
    	btn_btClear=MiscUtility.getWebElement(objFilepath, "CRA182_btn_btClear");
    	btn_invoicelov=MiscUtility.getWebElement(objFilepath, "CRA182_btn_invoicelov");
        txt_invocieNolov=MiscUtility.getWebElement(objFilepath, "CRA182_txt_invocieNolov");
    	dropdown_billingTypeFltrinvoicelov=MiscUtility.getWebElement(objFilepath, "CRA182_dropdown_billingTypeFltrinvoicelov");
    	txt_clearancePeriodinvoicelov=MiscUtility.getWebElement(objFilepath, "CRA182_txt_clearancePeriodinvoicelov");
    	btn_btnListinvocielov=MiscUtility.getWebElement(objFilepath, "CRA182_btn_btnListinvocielov");
    	btn_btnOkinvocielov=MiscUtility.getWebElement(objFilepath, "CRA182_btn_btnOkinvocielov");
    	txt_airlineCodeinvoicelov=MiscUtility.getWebElement(objFilepath, "CRA182_txt_airlineCodeinvoicelov");
    	btn_btnCloseinvoicelov=MiscUtility.getWebElement(objFilepath, "CRA182_btn_btnCloseinvoicelov");
    	tbl_rejectTxnListing=MiscUtility.getWebElement(objFilepath, "CRA182_tbl_rejectTxnListing");
    	chkbox_select=MiscUtility.getWebElement(objFilepath, "CRA182_chkbox_select");
    	btn_btViewRM=MiscUtility.getWebElement(objFilepath, "CRA182_btn_btViewRM");
    	btn_btIssueRejectionMemo=MiscUtility.getWebElement(objFilepath, "CRA182_btn_btIssueRejectionMemo");
    	btn_btClose=MiscUtility.getWebElement(objFilepath, "CRA182_btn_btClose");
    	chkbox_selectCheckBoxinvoicelov=MiscUtility.getWebElement(objFilepath, "CRA182_chkbox_selectCheckBoxinvoicelov");
        Generic_btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        info_error= MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    }
    public CRA182 ErrorMandatoryDetails(){
     	
   	 
    	click(btn_list);
    	minWait();
    
    	Assert.assertTrue(waitForElement(info_error).getText().contains("Clearance From Date and To Date is mandatory."),"Error:Error not shown");
    	
    	
    	Assert.assertTrue(waitForElement(info_error).getText().contains("Airline Code or Airline Number is mandatory."),"Error:Error not shown");
    	
   click(btn_btClear);
   	
    	
    	 	return this;
    }
    
    public CRA182 VerifyButtons(){
    Assert.assertTrue(isElementPresent(btn_btClear),"Error: The button not present");
    Assert.assertTrue(isElementPresent(btn_btClose),"Error: The button not present");
    Assert.assertTrue(isElementPresent(btn_btIssueRejectionMemo),"Error: The button not present");
    Assert.assertTrue(isElementPresent(btn_btViewRM),"Error: The button not present");
    Assert.assertTrue(isElementPresent(btn_list),"Error: The button not present");
   
    
    	
    	 	return this;
    }
    public CRA182 NoDataError(String airlinecode){
     	
    	airlinecode = PropertyHandler.getPropValue(dataFilePath, airlinecode);
    	enterKeys(txt_fromDate, "+15");
    	enterKeys(txt_toDate, "+30");
    	
      	 enterKeys(txt_airlineCode, airlinecode);
    	click(btn_list);
    	minWait();
    
    	Assert.assertTrue(waitForElement(info_error).getText().contains("No results found for the specified criteria."),"Error:Error not shown");
    	   click(btn_btClear);
	
    	
    	
    	 	return this;
    }
    
    
public CRA182 NoData_ForClearancePeriod(String airlinecode,String Fromdate,String Todate){
     	
    	airlinecode = PropertyHandler.getPropValue(dataFilePath, airlinecode);
    	Fromdate = PropertyHandler.getPropValue(dataFilePath, Fromdate);
    	Todate = PropertyHandler.getPropValue(dataFilePath, Todate);
    	
    	enterKeys(txt_fromDate,Fromdate);
    	enterKeys(txt_toDate,Todate);
    	
      	 enterKeys(txt_airlineCode, airlinecode);
    	click(btn_list);
    	minWait();
    
    	Assert.assertTrue(waitForElement(info_error).getText().contains("No results found for the specified criteria."),"Error:Error not shown");
    	   click(btn_btClear);
	
    	
    	
    	 	return this;
    }
public CRA182 ListInvoice(String airlinecode,String Fromdate,String Todate,String clearanceperiod){
 	
	airlinecode = PropertyHandler.getPropValue(dataFilePath, airlinecode);
	Fromdate = PropertyHandler.getPropValue(dataFilePath, Fromdate);
	Todate = PropertyHandler.getPropValue(dataFilePath, Todate);
	clearanceperiod=PropertyHandler.getPropValue(dataFilePath, clearanceperiod);
	
	enterKeys(txt_fromDate,Fromdate);
	enterKeys(txt_toDate,Todate);
	
  	 enterKeys(txt_airlineCode, airlinecode);
	click(btn_list);
	minWait();

	tblSelectRowByColValue(tbl_rejectTxnListing, 1, 2, clearanceperiod);
	
	
	
	 	return this;
}


public CRA182 Error_AgainIssueRejnMemo(String airlinecode,String Fromdate,String Todate,String clearanceperiod){
 	
	airlinecode = PropertyHandler.getPropValue(dataFilePath, airlinecode);
	Fromdate = PropertyHandler.getPropValue(dataFilePath, Fromdate);
	Todate = PropertyHandler.getPropValue(dataFilePath, Todate);
	clearanceperiod=PropertyHandler.getPropValue(dataFilePath, clearanceperiod);
	
	enterKeys(txt_fromDate,Fromdate);
	enterKeys(txt_toDate,Todate);
	
  	 enterKeys(txt_airlineCode, airlinecode);
	click(btn_list);
	minWait();

	tblSelectRowByColValue(tbl_rejectTxnListing, 1, 10, "Yes");
	click(btn_btIssueRejectionMemo);
	minWait();
	driver.switchTo().defaultContent();
	Assert.assertTrue(waitForElement(info_msg).getText().contains("Rejection Memo is already issued"),"Error: The error message not shown");
	click(Generic_btn_ok);
	waitForFrameAndSwitch(FRAME);
	click(btn_btClear);
	Assert.assertTrue(waitForElement(txt_fromDate).getAttribute("value").contains(""),"Error: The screen is not cleared");
	Assert.assertTrue(waitForElement(txt_airlineCode).getAttribute("value").contains(""),"Error: The screen is not cleared");
	Assert.assertTrue(waitForElement(txt_toDate).getAttribute("value").contains(""),"Error: The screen is not cleared");
	
	
	 	return this;
}

  public CRA182 ClearancePeriodError(String airlinecode){
	  airlinecode = PropertyHandler.getPropValue(dataFilePath, airlinecode);
    	enterKeys(txt_fromDate, "+30");
    	enterKeys(txt_toDate, "+15");
    	
      	 
    	click(btn_list);
    	minWait();
    
    	Assert.assertTrue(waitForElement(info_error).getText().contains("Clearance To Date cannot be earlier than Clearance From Date."),"Error:Error not shown");
    	   click(btn_btClear);

    	
    	
    	 	return this;
    }
    
    
      public HomePage close() {

        click(btn_btClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFilePath);
    }

    
}
