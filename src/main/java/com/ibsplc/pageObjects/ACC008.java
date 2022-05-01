/**
 *
 */
package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
public class ACC008 extends BasePage {

    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "QMS_ACC.properties");
    private static String FRAME = "iCargoContentFrameACC008";
    private static boolean delReq = false;
    private static boolean addReq = false;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_Close,
    btn_genericYes,
         
  
    txt_customerCode,
    txt_fromDate,
    txt_toDate,
    btn_list,
    table_invoiceList,
    btn_print,
    checkbox_selectAll,
    btn_invoiceDetails;
    
    
    

    public ACC008(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        btn_Close = MiscUtility.getWebElement(objFilepath, "ACC008_btn_Close");
        btn_genericYes= MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        txt_customerCode = MiscUtility.getWebElement(objFilepath, "ACC008_txt_customerCode"); 
        txt_fromDate = MiscUtility.getWebElement(objFilepath, "ACC008_txt_fromDate");
        txt_toDate = MiscUtility.getWebElement(objFilepath, "ACC008_txt_toDate"); 
        btn_list = MiscUtility.getWebElement(objFilepath, "ACC008_btn_list");
        table_invoiceList = MiscUtility.getWebElement(objFilepath, "ACC008_table_invoiceList");
        btn_print=MiscUtility.getWebElement(objFilepath, "ACC008_btn_print");
        checkbox_selectAll=MiscUtility.getWebElement(objFilepath, "ACC008_checkbox_selectAll");
        btn_invoiceDetails=MiscUtility.getWebElement(objFilepath, "ACC008_btn_invoiceDetails");
        
    }
    
    
    public ACC008 listInvoices(String custCode)
    {
    	custCode = PropertyHandler.getPropValue(dataFilePath, custCode);
        enterKeys(txt_fromDate,".");
        String dayToday=waitForElement(txt_fromDate).getAttribute("value");
    	
    	
        String date=BizUtility.getInvoiceFromDate(dayToday, "BiMonthly");
    	String date2=BizUtility.getInvoiceToDate(dayToday, "BiMonthly");
    	enterKeys(txt_customerCode,custCode);
    	enterKeys(txt_fromDate, date);
    	enterKeys(txt_toDate, date2);
    	click(btn_list);
    	minWait();
    	int rows=getTableRowCount(table_invoiceList);
    	Assert.assertTrue(rows>=1, "table result not showing");
    	
    	
    	return this;
    }
    
    
    public ACC008 printList()
    {
 	   
    	minWait();
   
 	Assert.assertTrue(waitForElement(btn_print).isEnabled(),"print button is enabled and present");
 	click(btn_print);
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
    
    
    
    
    public ACC010 clickInvoiceDetails()
    {
    	
    click(checkbox_selectAll);
    click(btn_invoiceDetails);
    minWait();	
    	
    	return new ACC010(driver, dataFileName);
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
