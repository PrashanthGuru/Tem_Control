/**
 * 
 */
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

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class ULD028 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	
	public static String FRAME = "iCargoContentFrameULD028";
	
	By
	txt_uld,
	list_DISCCOD,
	txt_discrepancyDate,
	txt_REPORTINGSTATION,
	btn_SAVE,
	btn_genericYes,
	btn_CLOSE;
 
	
	
	WebDriver driver;
    String screenFrame;
    String dataFileName;
    
    
    public ULD028(WebDriver driver, String dataFileName) {
    	
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {
  
    	txt_uld= MiscUtility.getWebElement(objFilepath,"ULD028_txt_uld");
    	list_DISCCOD= MiscUtility.getWebElement(objFilepath,"ULD028_list_DISCCODE");
    	txt_discrepancyDate= MiscUtility.getWebElement(objFilepath,"ULD028_txt_discrepancyDate");
    	txt_REPORTINGSTATION= MiscUtility.getWebElement(objFilepath,"ULD028_txt_REPORTINGSTATION");
    	btn_SAVE= MiscUtility.getWebElement(objFilepath,"ULD028_btn_SAVE");
    	btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btn_CLOSE= MiscUtility.getWebElement(objFilepath,"ULD028_btn_CLOSE");
    	
    
    }
    /**
  	  * 
  	  * record movements
  	  * on 
  	  * @param uldNum,status
  	  * @return
  	  * @author a-6545
  	  */
      public ULD028 Create_Discrepancy(String uldNum,String origin,String flightStartDate){
      	
      	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
      	origin= PropertyHandler.getPropValue(dataFilePath,origin);
     	 flightStartDate= PropertyHandler.getPropValue(dataFilePath,flightStartDate);
     	
     	 enterKeys(waitForElement(txt_uld), uldNum);
     	selectByText(list_DISCCOD, "Found");
     	 enterKeys(txt_discrepancyDate, flightStartDate);
     	 enterKeys(txt_REPORTINGSTATION, origin);
     	 click(btn_SAVE);
  		
        return this;
  		 
  		 
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
