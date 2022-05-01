package com.ibsplc.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * @author a-6784
 */

public class CRA033 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String filepath;

    public static String FRAME = "iCargoContentFrameCRA033";
    WebDriver driver;
    String testDataFile;

    
    By
    txt_country,
    txt_station,
    txt_customercode,
    txt_invoiceFromDate,
    txt_invoiceToDate,
    btn_list,
    txt_invoiceNumber,
    yesBtn,
    tbl_invoiceDetails,
    checkbx_selectinvoice,
    btn_invoiceDetails,
    btn_close;
    
    
public CRA033(WebDriver driver, String testDataFile) {
    super(driver);
    this.driver = driver;
    this.testDataFile = testDataFile;
    PageFactory.initElements(this.driver, this);
    filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + testDataFile;
    initPageElements();
}


/**
 * Method to initialize page objects
 */
     private void initPageElements() {
            
     
     
    	    txt_country          = MiscUtility.getWebElement(objFilepath, "CRA033_txt_country");
    	    txt_station          = MiscUtility.getWebElement(objFilepath, "CRA033_txt_station");
    	    txt_customercode     = MiscUtility.getWebElement(objFilepath, "CRA033_txt_customercode");
    	    txt_invoiceFromDate  = MiscUtility.getWebElement(objFilepath, "CRA033_txt_invoiceFromDate");
    	    txt_invoiceToDate    = MiscUtility.getWebElement(objFilepath, "CRA033_txt_invoiceToDate");
    	    btn_list             = MiscUtility.getWebElement(objFilepath, "CRA033_btn_list");
    	    tbl_invoiceDetails   = MiscUtility.getWebElement(objFilepath, "CRA033_tbl_invoiceDetails");
    	    btn_close            = MiscUtility.getWebElement(objFilepath, "CRA033_btn_close");
    	    yesBtn               =MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
    	    txt_invoiceNumber    =MiscUtility.getWebElement(objFilepath, "CRA033_txt_invoiceNumber");
    	    checkbx_selectinvoice=MiscUtility.getWebElement(objFilepath, "CRA033_checkbx_selectinvoice");
    	    btn_invoiceDetails   =MiscUtility.getWebElement(objFilepath, "CRA033_btn_invoiceDetails");
     
     }
     
     
 public CRA033 verifyInvoiceNumber(String country,String customercode,String flightdate,String invoicenum,String billingPeriod){
	
	 country        = PropertyHandler.getPropValue(testDataFile, country);
	 customercode   = PropertyHandler.getPropValue(testDataFile, customercode);
	 flightdate     = PropertyHandler.getPropValue(testDataFile, flightdate);
	 invoicenum     = PropertyHandler.getPropValue(testDataFile, invoicenum);
	 billingPeriod  = PropertyHandler.getPropValue(testDataFile, billingPeriod);
	 
	 enterKeys(txt_country, country);
	 enterKeys(txt_customercode, customercode);
	 String date=BizUtility.getInvoiceFromDate(flightdate, billingPeriod);
	 String date2=BizUtility.getInvoiceToDate(flightdate, billingPeriod);
	 enterKeys(txt_invoiceFromDate, date);
	 enterKeys(txt_invoiceToDate, date2);
	 click(btn_list);
	 minWait();
	 
	String tempInv= getTableCellValue(tbl_invoiceDetails, 2, 1);
	Assert.assertTrue(tempInv.equals(invoicenum), "Error:Invoice not generated");
	
	
	
	 return this;
	
}
 
 public CRA033 verifyAWBs(String invoiceNumber,String flightdate,String billingPeriod){
	 
	 invoiceNumber     = PropertyHandler.getPropValue(testDataFile, invoiceNumber);
	 billingPeriod  = PropertyHandler.getPropValue(testDataFile, billingPeriod);
	 flightdate  = PropertyHandler.getPropValue(testDataFile, flightdate);
	
	 enterKeys(txt_invoiceNumber, invoiceNumber);
	 String date=BizUtility.getInvoiceFromDate(flightdate, billingPeriod);
	 String date2=BizUtility.getInvoiceToDate(flightdate, billingPeriod);
	 enterKeys(txt_invoiceFromDate, date);
	 enterKeys(txt_invoiceToDate, date2);
	 click(btn_list);
	 minWait();
	 check(checkbx_selectinvoice);
	 
	 click(btn_invoiceDetails);
	 
	 /** issue exist**/
	 return this;
 }

 public HomePage close() {

     click(btn_close);
     driver.switchTo().defaultContent();
     if (verifyElementPresent(yesBtn)) {

         click(yesBtn);
     }
     return new HomePage(driver, testDataFile);
 }







}