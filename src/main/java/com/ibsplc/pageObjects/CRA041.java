package com.ibsplc.pageObjects;

import static com.ibsplc.utils.BizUtility.getInvoiceFromDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * 
 * @author A-6784
 *
 */
public class CRA041 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA041";
    public static String screenFrame = "iCargoContentFrameCRA041";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
     By 
     
     
      yesBtn,
      txt_country,
      txt_fromdate,
      txt_toDate,
      btn_generate,
      btn_close,
      chkbx_adjustmnt,
      btn_genericOk,
      tbl_billingperiodDropdowntbl,
      link_billingperioddropdown,
      info_error,
      chkbx_includeNew
    ;
   
    public CRA041(WebDriver driver, String dataFileName) {
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

    	txt_country = MiscUtility.getWebElement(objFilepath, "CRA041_txt_country");
    	txt_fromdate = MiscUtility.getWebElement(objFilepath, "CRA41_txt_fromdate");
    	btn_generate = MiscUtility.getWebElement(objFilepath, "CRA041_btn_generate");
    	txt_toDate   = MiscUtility.getWebElement(objFilepath, "CRA041_txt_toDate");
    	btn_close = MiscUtility.getWebElement(objFilepath, "CRA041_btn_close");
    	chkbx_adjustmnt = MiscUtility.getWebElement(objFilepath, "CRA041_chkbx_adjustmnt");
    	chkbx_includeNew=MiscUtility.getWebElement(objFilepath, "CRA041_chkbx_includeNew");
    	 yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	 btn_genericOk   = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    	 info_error =MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    	 tbl_billingperiodDropdowntbl=MiscUtility.getWebElement(objFilepath, "CRA041_tbl_billingperiodDropdowntbl");
    	 link_billingperioddropdown=MiscUtility.getWebElement(objFilepath, "CRA041_link_billingperioddropdown");
       
    }
    
  public CRA041 cassFileGeneration(String country,String flightDate,String billingPeriod){
	  
	  country=PropertyHandler.getPropValue(dataFilePath, country);
	  flightDate=PropertyHandler.getPropValue(dataFilePath, flightDate);
	  
	  enterKeys(txt_country, country);
	  String dat= BizUtility.getInvoiceFromDate_CASS(flightDate,billingPeriod);
	  /*enterKeys(txt_fromdate, dat);
	  
	  String toDate=getInvoiceToDate(flightDate);
	  enterKeys(txt_toDate, toDate);
	  */
	  click(link_billingperioddropdown);
	  clickTableRowByValue(tbl_billingperiodDropdowntbl,1,dat);
	  
	  click(btn_generate);
	  minWait();
	  driver.switchTo().defaultContent();
	  click(btn_genericOk);
	  minWait();
	  waitForFrameAndSwitch(FRAME);
	return this;  

}
  
  
public CRA041 cassFileGeneration_Adjstmnt(String country,String flightDate,String billingPeriod){
	  
	  country=PropertyHandler.getPropValue(dataFilePath, country);
	  flightDate=PropertyHandler.getPropValue(dataFilePath, flightDate);
	  
	  enterKeys(txt_country, country);
	  String dat=getInvoiceFromDate(flightDate,billingPeriod);
	  /*enterKeys(txt_fromdate, dat);
	  
	  String toDate=getInvoiceToDate(flightDate);
	  enterKeys(txt_toDate, toDate);
	  */
	  click(link_billingperioddropdown);
	  clickTableRowByValue(tbl_billingperiodDropdowntbl,1,dat);
	  check(chkbx_adjustmnt);
	  click(btn_generate);
	  minWait();
	  driver.switchTo().defaultContent();
	  click(btn_genericOk);
	  minWait();
	  waitForFrameAndSwitch(FRAME);
	return this;  

}
public CRA041 cassFileGeneration_ErrorVerification(String country,String flightDate,String billingPeriod,String parameterValue){
	  
	  country=PropertyHandler.getPropValue(dataFilePath, country);
	  flightDate=PropertyHandler.getPropValue(dataFilePath, flightDate);
	  
	  enterKeys(txt_country, country);
	  String dat=getInvoiceFromDate(flightDate,billingPeriod);
	  /*enterKeys(txt_fromdate, dat);
	  
	  String toDate=getInvoiceToDate(flightDate);
	  enterKeys(txt_toDate, toDate);
	  */
	  click(link_billingperioddropdown);
	  clickTableRowByValue(tbl_billingperiodDropdowntbl,1,dat);
	  
	  click(btn_generate);
	  minWait();
	  if(parameterValue.contains("Error")){
		  waitForElement(info_error).getText().contains("Prime cass bill for this period is not finalized");
	  }
	  else{
		  /** hold**/
	  }
	  driver.switchTo().defaultContent();
	  click(btn_genericOk);
	  minWait();
	  waitForFrameAndSwitch(FRAME);
	return this;  

}
  
  
  public HomePage close() {

	    click(btn_close);
	    driver.switchTo().defaultContent();
	    if (verifyElementPresent(yesBtn)) {

	        click(yesBtn);
	    }
	    return new HomePage(driver, dataFileName);
	}

}