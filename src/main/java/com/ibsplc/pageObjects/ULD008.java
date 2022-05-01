
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

public class ULD008 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	
	public static String FRAME = "iCargoContentFrameULD008";
	
	By
	txt_uld,
	btn_list,
	tbl_ulddiscrepencies,
	btn_CLOSEDISCREPANCY,
	yesBtn,
	chk_masterRowId,
	noBtn,
	btn_CLOSE;
 
	
	
	WebDriver driver;
    String screenFrame;
    String dataFileName;
    
    
    public ULD008(WebDriver driver, String dataFileName) {
    	
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {
  
    	txt_uld= MiscUtility.getWebElement(objFilepath,"ULD008_txt_uld");
    	btn_list= MiscUtility.getWebElement(objFilepath,"ULD008_btn_list");
    	tbl_ulddiscrepencies= MiscUtility.getWebElement(objFilepath,"ULD008_tbl_ulddiscrepencies");
    	btn_CLOSE= MiscUtility.getWebElement(objFilepath,"ULD008_btn_CLOSE");
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_CLOSEDISCREPANCY= MiscUtility.getWebElement(objFilepath,"ULD008_btn_CLOSEDISCREPANCY");
        chk_masterRowId= MiscUtility.getWebElement(objFilepath,"ULD008_chk_masterRowId");
    }
    /**
  	  * 
  	  * record movements
  	  * on 
  	  * @param uldNum,status
  	  * @return
  	  * @author a-6545
  	  */
      public ULD008 LIst_ULD_Discrepancy(String uldNum,String origin ){
      	
      	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
      	 origin= PropertyHandler.getPropValue(dataFilePath,origin);
     	
     	
     	 enterKeys(waitForElement(txt_uld), uldNum);
     	 click(btn_list);
     	 Assert.assertTrue(tblGetTextByColValue(tbl_ulddiscrepencies,2,5,origin).contains(uldNum));
     	check(chk_masterRowId);
     	 minWait();
     	 click(btn_CLOSEDISCREPANCY);
     	driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(noBtn)) {
            click(noBtn);
            waitForFrameAndSwitch(FRAME);
        }
        minWait();
        click(btn_CLOSEDISCREPANCY);
     	driver.switchTo().defaultContent();
     	 if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
            waitForFrameAndSwitch(FRAME);
           
        }
  		
        return this;
  		 
  		 
      }
     
   
	
public HomePage close() {    	
	    minWait();
        click(btn_CLOSE);
        driver.switchTo().defaultContent();
        
        return new HomePage(driver,dataFileName);
    }
}
