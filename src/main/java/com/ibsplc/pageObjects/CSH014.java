package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author A-8254 .
 */

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-8254 
 */
public class CSH014 extends BasePage {

    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "LTE_CSH_CLM.properties");
    private static String FRAME = "iCargoContentFrameCSH014";
    private static boolean delReq = false;
    private static boolean addReq = false;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By 
   
    btn_genericYes,
    txt_fromDate, 
    txt_toDate,
    txt_fromDate_time,
    txt_toDate_time,
    dropdown_cashDrawType,
    btn_generateReport,
    btn_print,
    btn_Close;

    public CSH014(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

    	btn_genericYes=MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	txt_fromDate = MiscUtility.getWebElement(objFilepath, "CSH014_txt_fromDate");
    	txt_toDate= MiscUtility.getWebElement(objFilepath, "CSH014_txt_toDate");
    	txt_fromDate_time = MiscUtility.getWebElement(objFilepath, "CSH014_txt_fromDate_time");
    	txt_toDate_time = MiscUtility.getWebElement(objFilepath, "CSH014_txt_toDate_time");
    	dropdown_cashDrawType = MiscUtility.getWebElement(objFilepath, "CSH014_dropdown_cashDrawType");
    	btn_generateReport = MiscUtility.getWebElement(objFilepath, "CSH014_btn_generateReport");
    	btn_print = MiscUtility.getWebElement(objFilepath, "CSH014_btn_print");
    	btn_Close = MiscUtility.getWebElement(objFilepath, "CSH014_btn_Close");
    }
    
    
   public CSH014 generateReport(String cashDrawType)
   {
	   cashDrawType = PropertyHandler.getPropValue(dataFilePath, cashDrawType);
	   enterKeys(txt_fromDate,".");
       String dayToday=waitForElement(txt_fromDate).getAttribute("value");
   	   String date=BizUtility.getInvoiceFromDate(dayToday, "BiMonthly");
   	  String date2=BizUtility.getInvoiceToDate(dayToday, "BiMonthly");
   	
   	  enterKeys(txt_fromDate, date);
   	  enterKeys(txt_toDate, date2);
	  enterKeys(txt_fromDate_time,"1");
	  enterKeys(txt_toDate_time,"12");
	  selectByText(dropdown_cashDrawType, cashDrawType);
	  click(btn_generateReport);
	  minWait();
   
 	
 	 waitForNewWindow(2);
 	 switchToSecondWindow();
     closeAndmoveToFirstWindow();
     waitForFrameAndSwitch(FRAME);
 	return this;   
	   
	   
	  
   }
  
   public CSH014 print(String cashDrawType)
   {
	   cashDrawType = PropertyHandler.getPropValue(dataFilePath, cashDrawType);
	   enterKeys(txt_fromDate,".");
       String dayToday=waitForElement(txt_fromDate).getAttribute("value");
   	   String date=BizUtility.getInvoiceFromDate(dayToday, "BiMonthly");
   	  String date2=BizUtility.getInvoiceToDate(dayToday, "BiMonthly");
   	
   	  enterKeys(txt_fromDate, date);
   	  enterKeys(txt_toDate, date2);
	  enterKeys(txt_fromDate_time,"1");
	  enterKeys(txt_toDate_time,"12");
	  selectByText(dropdown_cashDrawType, cashDrawType);
	  click(btn_print);
	  minWait();
   
 	
 	 waitForNewWindow(2);
 	 switchToSecondWindow();
     closeAndmoveToFirstWindow();
     waitForFrameAndSwitch(FRAME);
 	return this;   
	   
	   
	  
  
   
   
   } 
    

    

    public HomePage close() {

        click(btn_Close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
    
    
   
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
