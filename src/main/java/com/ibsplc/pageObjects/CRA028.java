package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * 
 * @author A-6836
 *
 */


public class CRA028 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA028";
    public static String screenFrame = "iCargoContentFrameCRA028";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By text_country,
    dropdown_billingParty,
    text_ccCollectorCode, 
    dropdown_Billinfreq,
    yesBtn,
    text_fromDate,
    info_error,
    btn_ok,btn_btnClose,
    text_toDate,chkbox_biMonthlybillingperiod,
    btn_btnGenerate,
    chkbox_monthlybillingperiod;

    public CRA028(WebDriver driver, String dataFileName) {
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

    	text_country = MiscUtility.getWebElement(objFilepath, "CRA028_text_country");
    	dropdown_billingParty = MiscUtility.getWebElement(objFilepath, "CRA028_dropdown_billingParty");
    	text_ccCollectorCode = MiscUtility.getWebElement(objFilepath, "CRA028_text_ccCollectorCode");
    	dropdown_Billinfreq = MiscUtility.getWebElement(objFilepath, "CRA028_dropdown_Billinfreq");
    	chkbox_biMonthlybillingperiod= MiscUtility.getWebElement(objFilepath, "CRA028_chkbox_biMonthlybillingperiod");
    	text_fromDate = MiscUtility.getWebElement(objFilepath, "CRA028_text_fromDate");
    	text_toDate = MiscUtility.getWebElement(objFilepath, "CRA028_text_toDate");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        btn_btnGenerate=MiscUtility.getWebElement(objFilepath, "CRA028_btn_btnGenerate");
        btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA028_btn_btnClose");
        
        
    }
    /***
     * 
     * @param Country
     * @param fromdate
     * @param BillingParty
     * @param billingfreq
     * @return
     */
    public CRA028 withoutCC_Collector(String Country, String fromdate,String BillingParty,String billingfreq){
    	
    	
    	Country = PropertyHandler.getPropValue(dataFilePath, Country);
    	fromdate = PropertyHandler.getPropValue(dataFilePath, fromdate);
    	BillingParty= PropertyHandler.getPropValue(dataFilePath, fromdate);
    	billingfreq = PropertyHandler.getPropValue(dataFilePath, billingfreq);
    	
    	
    	String invoiceFromDate=BizUtility.getInvoiceFromDate(fromdate, billingfreq);
         String invoiceToDate=BizUtility.getInvoiceToDate(fromdate, billingfreq);
         
         enterKeys(text_country, Country);
         selectByText(dropdown_billingParty, BillingParty);
        
         click(dropdown_Billinfreq);
         
         minWait();
         if(billingfreq.contains("BiMothly")){
         	 
               check(chkbox_biMonthlybillingperiod);
         }
         else{
         	check(chkbox_monthlybillingperiod);
         }
         
         enterKeys(text_fromDate, invoiceFromDate);
         enterKeys(text_fromDate, invoiceToDate);
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
/***
 * 
 * @param shipper
 * @param fromdate
 * @param billingfreq
 * @return
 */
    public CRA028 GenerateInvoice(String Country, String fromdate,String BillingParty,String CC_collector,String billingfreq){

    	Country = PropertyHandler.getPropValue(dataFilePath, Country);
    	fromdate = PropertyHandler.getPropValue(dataFilePath, fromdate);
    	BillingParty= PropertyHandler.getPropValue(dataFilePath, fromdate);
    	billingfreq = PropertyHandler.getPropValue(dataFilePath, billingfreq);
    	CC_collector=PropertyHandler.getPropValue(dataFilePath, CC_collector);

        String invoiceFromDate=BizUtility.getInvoiceFromDate(fromdate, billingfreq);
        String invoiceToDate=BizUtility.getInvoiceToDate(fromdate, billingfreq);
        enterKeys(text_country, Country);
        enterKeys(text_ccCollectorCode, CC_collector);
        click(dropdown_Billinfreq);
        
        minWait();
        if(billingfreq.contains("BiMonthly")){
        	 
              check(chkbox_biMonthlybillingperiod);
        }
        else{
        	check(chkbox_monthlybillingperiod);
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
        driver.switchTo().defaultContent();

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
