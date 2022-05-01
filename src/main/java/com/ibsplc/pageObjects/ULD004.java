/**
 * 
 */
package com.ibsplc.pageObjects;

/**
 * @author A-6545
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class ULD004 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	
	public static String FRAME = "iCargoContentFrameULD004";
	
	By
	txt_INVOICEREFNO,
  BUTTON_Close,
  btn_list,
  txt_invoicefromdate,
  BUTTON_PRINT,
    btn_GENINVOICE,
    btn_genericYes,
    chk_selectedRows,
	btn_CLOSE,
	BUTTON_VIEW,
	txt_invoiceRefNo,
	BUTTON_REPAIRINVOICE_CLOSE,
	txt_uldTypeCode;
 
	
	
	WebDriver driver;
    String screenFrame;
    String dataFileName;
    
    
    public ULD004(WebDriver driver, String dataFileName) {
    	
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {
    
    	txt_INVOICEREFNO= MiscUtility.getWebElement(objFilepath,"ULD004_txt_INVOICEREFNO");
    	btn_list= MiscUtility.getWebElement(objFilepath,"ULD004_btn_list");
    	txt_invoicefromdate= MiscUtility.getWebElement(objFilepath,"ULD004_txt_invoicefromdate");
    	chk_selectedRows= MiscUtility.getWebElement(objFilepath,"ULD004_chk_selectedRows");
    	BUTTON_PRINT= MiscUtility.getWebElement(objFilepath,"ULD004_BUTTON_PRINT");
    	btn_CLOSE= MiscUtility.getWebElement(objFilepath,"ULD004_BUTTON_Close");
    	BUTTON_VIEW = MiscUtility.getWebElement(objFilepath,"ULD004_BUTTON_VIEW");
    	txt_invoiceRefNo = MiscUtility.getWebElement(objFilepath,"ULD004_txt_invoiceRefNo");
    	BUTTON_REPAIRINVOICE_CLOSE = MiscUtility.getWebElement(objFilepath,"ULD004_BUTTON_REPAIRINVOICE_CLOSE");
    	 btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    
    }
    /**ULDMovementHistory
  	  * 
  	  * record movements
  	  * on 
  	  * @param uldNum,status
  	  * @return
  	  * @author a-6545
  	  */
      public ULD004 List_Invoice(String uldNum,String invoiceno,String flightStartDate){
      	
      	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
     	 invoiceno= PropertyHandler.getPropValue(dataFilePath,invoiceno);
     	 flightStartDate= PropertyHandler.getPropValue(dataFilePath,flightStartDate);
    	
     	 list(uldNum,invoiceno,flightStartDate);
  		 minWait();
  		 check(chk_selectedRows);
  		 click(BUTTON_PRINT);
  		 minWait();
  		 waitForNewWindow(2);
         switchToSecondWindow();
  		 driver.close();
  		 switchToFirstWindow();
         waitForFrameAndSwitch(FRAME);
         click(BUTTON_VIEW);
         minWait();
        Assert.assertTrue(waitForElementVisible(txt_invoiceRefNo).getAttribute("value").equalsIgnoreCase(invoiceno));
         click(BUTTON_REPAIRINVOICE_CLOSE);
        return this;
  		 
  		 
      }
     
   
	private void list(String uldNum,String invoiceno,String flightStartDate) {
		
		enterKeys(txt_INVOICEREFNO, invoiceno);
		enterKeys(txt_invoicefromdate, flightStartDate);
		
		 click(btn_list);
	}
	
public HomePage close() {    	
	    minWait();
        click(btn_CLOSE);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver,dataFileName);
    }
}
