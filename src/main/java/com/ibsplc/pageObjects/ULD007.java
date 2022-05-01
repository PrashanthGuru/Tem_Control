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

public class ULD007 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	private String dataFileName;
	public static String FRAME = "iCargoContentFrameULD007";
	
	By
	TABLE_listULDTable,
	Text_agreementNumber,
	BUTTON_Listbutton,
	BUTTON_PrintAgreementbutton,
	selectedChecks0,
	deletelink,
BUTTON_Closebutton,
BUTTON_Deletebutton,
BUTTON_Inactivatebutton,
BUTTON_Activatebutton,
BUTTON_Printbutton,

    btn_genericYes,
    Generic_info_msg,
    Generic_info_error,
	Generic_btn_noBtn,

    btn_genericOk;
	    
	    
	public ULD007(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        this.dataFileName = dataFileName;
	    }

	private void initElements() {
   	   btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
   	    Generic_btn_noBtn= MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
   	 Generic_info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        TABLE_listULDTable = MiscUtility.getWebElement(objFilepath, "ULD007_TABLE_listULDTable");
        Text_agreementNumber = MiscUtility.getWebElement(objFilepath, "ULD007_Text_agreementNumber");
        BUTTON_Listbutton = MiscUtility.getWebElement(objFilepath, "ULD007_BUTTON_Listbutton"); 
       BUTTON_Closebutton= MiscUtility.getWebElement(objFilepath, "ULD007_BUTTON_Closebutton"); 
       BUTTON_Deletebutton= MiscUtility.getWebElement(objFilepath, "ULD007_BUTTON_Deletebutton"); 
      BUTTON_Inactivatebutton= MiscUtility.getWebElement(objFilepath, "ULD007_BUTTON_Inactivatebutton"); 
      BUTTON_Activatebutton= MiscUtility.getWebElement(objFilepath, "ULD007_BUTTON_Activatebutton");
      BUTTON_Printbutton= MiscUtility.getWebElement(objFilepath, "ULD007_BUTTON_Printbutton");
      BUTTON_Closebutton= MiscUtility.getWebElement(objFilepath, "ULD007_BUTTON_Closebutton");
       
	  }
      
        
        public ULD007 Delete_Inactivate_activate_Agreement(String AgreementNo) {
 
        	AgreementNo = PropertyHandler.getPropValue(dataFilePath, AgreementNo);
          
        	enterKeys(Text_agreementNumber, AgreementNo);
        	click(BUTTON_Listbutton);
        	minWait();
        	tblSelectRowByColValue(TABLE_listULDTable, 1, 2, AgreementNo);
        	click(BUTTON_Deletebutton);
        	  driver.switchTo().defaultContent();
        	  Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("cannot be deleted"));
        	  click(btn_genericOk);
        	  waitForFrameAndSwitch(FRAME);
        	  minWait();
        	 // tblSelectRowByColValue(TABLE_listULDTable, 1, 2, AgreementNo);
        	  click(BUTTON_Inactivatebutton);
        	  driver.switchTo().defaultContent();
        	  click(waitForElement(Generic_btn_noBtn));
        	  waitForFrameAndSwitch(FRAME);
        	  click(BUTTON_Inactivatebutton);
        	  driver.switchTo().defaultContent();
        	  click(waitForElement(btn_genericYes));
        	  waitForFrameAndSwitch(FRAME);
        	  minWait();
        	  tblSelectRowByColValue(TABLE_listULDTable, 1, 2, AgreementNo);
        	  click(BUTTON_Activatebutton);
        	  driver.switchTo().defaultContent();
        	  click(waitForElement(Generic_btn_noBtn));
        	  waitForFrameAndSwitch(FRAME);
        	  click(BUTTON_Activatebutton);
        	  driver.switchTo().defaultContent();
        	  click(waitForElement(btn_genericYes));
        	  waitForFrameAndSwitch(FRAME);
        	  tblSelectRowByColValue(TABLE_listULDTable, 1, 2, AgreementNo);
        	  Assert.assertTrue(waitForElement(TABLE_listULDTable).getText().contains("Active"));
        	  
        	  click(BUTTON_Printbutton);
        	  waitForNewWindow(2);
        	  switchToSecondWindow();
        	  driver.close();
        	  switchToFirstWindow();
              waitForFrameAndSwitch(FRAME);
              
        	 return new ULD007(driver, dataFileName);

           }

		/**
         * Closes the screen and go to home screen
         *
         * @return
         * @author A-6545
         */
        public HomePage close() {

            click(BUTTON_Closebutton);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(btn_genericYes)) {

                click(btn_genericYes);
            }
            return new HomePage(driver, dataFileName);
        }      
    }
