package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * 
 * @author A-6836
 *
 */


public class CRA037 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA037";
    public static String screenFrame = "iCargoContentFrameCRA037";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By text_agentCode,
    dropdown_billingPeriods,
    text_fromDate, 
    text_toDate,
    yesBtn,
    btn_btnGenerate,
    info_error,
    btn_ok,
    btn_btnClose,
   chkbox_biMonthlybillingperiod,
   txt_country,
    chkbox_monthlybillingperiod;

    public CRA037(WebDriver driver, String dataFileName) {
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

    	text_agentCode = MiscUtility.getWebElement(objFilepath, "CRA037_text_agentCode");
    	dropdown_billingPeriods = MiscUtility.getWebElement(objFilepath, "CRA037_dropdown_billingPeriods");
    	text_fromDate = MiscUtility.getWebElement(objFilepath, "CRA037_text_fromDate");
    	text_toDate = MiscUtility.getWebElement(objFilepath, "CRA037_text_toDate");
    	btn_btnGenerate = MiscUtility.getWebElement(objFilepath, "CRA037_btn_btnGenerate");
    	btn_btnClose = MiscUtility.getWebElement(objFilepath, "CRA037_btn_btnClose");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        chkbox_biMonthlybillingperiod=MiscUtility.getWebElement(objFilepath, "CRA037_chkbox_biMonthlybillingperiod");
        chkbox_monthlybillingperiod=MiscUtility.getWebElement(objFilepath, "CRA037_chkbox_monthlybillingperiod");
        txt_country=MiscUtility.getWebElement(objFilepath, "CRA037_txt_country");
        info_error=MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        
    }
/***
 * 
 * @param shipper
 * @param fromdate
 * @param billingfreq
 * @return
 */
    public CRA037 GenerateInvoice(String shipper, String fromdate,String billingfreq){

    	shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
    	fromdate = PropertyHandler.getPropValue(dataFilePath, fromdate);
    
    	billingfreq = PropertyHandler.getPropValue(dataFilePath, billingfreq);

        String invoiceFromDate=BizUtility.getInvoiceFromDate(fromdate, billingfreq);
        String invoiceToDate=BizUtility.getInvoiceToDate(fromdate, billingfreq);
        System.out.println("invoiceFromDate "+invoiceFromDate);
        System.out.println("invoiceToDate"+invoiceToDate);
        enterKeys(text_agentCode, shipper);
        
        click(dropdown_billingPeriods);
        minWait();
        if(billingfreq.contains("BiMonthly")){
        	 
              check(chkbox_biMonthlybillingperiod);
              click(text_fromDate);
        }
        else{
        	check(chkbox_monthlybillingperiod);
        	   click(text_fromDate);
        }
        enterKeys(text_fromDate, invoiceFromDate);
        
        enterKeys(text_toDate, invoiceToDate);
        
        
        click(btn_btnGenerate);
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        } 
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_ok)) {

            click(btn_ok);
        }
        minWait();
       // driver.switchTo().defaultContent();
        waitForFrameAndSwitch(FRAME);
        return this;
    }
    
    public CRA037 generateInvoiceWithoutCustomer(String country,String date,String bliingFreq){
    	
    	country = PropertyHandler.getPropValue(dataFilePath, country);
    	date = PropertyHandler.getPropValue(dataFilePath, date);
    	bliingFreq = PropertyHandler.getPropValue(dataFilePath, bliingFreq);
		
    	
    	  String invoiceFromDate=BizUtility.getInvoiceFromDate(date, bliingFreq);
          String invoiceToDate=BizUtility.getInvoiceToDate(date, bliingFreq);
          enterKeys(txt_country, country);
          enterKeys(text_fromDate, invoiceFromDate);
          enterKeys(text_toDate, invoiceToDate);
          click(dropdown_billingPeriods);
          minWait();
          if(bliingFreq.contains("BiMothly")){
          	 
                check(chkbox_biMonthlybillingperiod);
          }
          else{
          	check(chkbox_monthlybillingperiod);
          }
          
          
          click(btn_btnGenerate);
          minWait();
          driver.switchTo().defaultContent();
          if (verifyElementPresent(yesBtn)) {

              click(yesBtn);
          } 
          minWait();
          driver.switchTo().defaultContent();
          if (verifyElementPresent(btn_ok)) {

              click(btn_ok);
          }
          minWait();
          driver.switchTo().defaultContent();
    	
    	return this;
    	
    }
  /****
   * for checking the error message while creating invoice twice for a billing period
   * @param shipper
   * @param fromdate
   * @param billingfreq
   * @return
   */
    public CRA037 invoiceGenerationErrorCheck(String shipper, String fromdate,String billingfreq){
		
    	
    	shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
    	fromdate = PropertyHandler.getPropValue(dataFilePath, fromdate);
    
    	billingfreq = PropertyHandler.getPropValue(dataFilePath, billingfreq);

        String invoiceFromDate=BizUtility.getInvoiceFromDate(fromdate, billingfreq);
        String invoiceToDate=BizUtility.getInvoiceToDate(fromdate, billingfreq);
        enterKeys(text_agentCode, shipper);
        enterKeys(text_fromDate, invoiceFromDate);
        enterKeys(text_toDate, invoiceToDate);
        click(dropdown_billingPeriods);
        minWait();
        if(billingfreq.contains("BiMothly")){
        	 
              check(chkbox_biMonthlybillingperiod);
        }
        else{
        	check(chkbox_monthlybillingperiod);
        }
        
        
        click(btn_btnGenerate);
        minWait();
       // driver.switchTo().defaultContent();
    	
    	
    	Assert.assertTrue(waitForElement(info_error).getText().contains("Invoice is Already Generated"),"ERROR:Expecting error message,while Invoice generated succssfully");    
    	
    	
    	
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
