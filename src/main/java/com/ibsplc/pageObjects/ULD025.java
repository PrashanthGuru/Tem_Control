package com.ibsplc.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class ULD025 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	private String dataFileName;
	public static String FRAME = "iCargoContentFrameULD025";
	
	By
	txt_AIRLINE1,
	btn_LIST,
	addPoollink,
	txt_airlineOne,
	txt_airlineTwo,
	txt_airport,
	chk_chkall,
	deletePoollink,
	addUld,
	txt_Origin,
	txt_Dest,
	btn_Ok,
	txt_remarks,
	btn_SAVE,
	btn_SEGMENTEXCEPTION,
	btn_CLOSE,
	btn_genericYes;

	    
	public ULD025(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        this.dataFileName = dataFileName;
	    }

	private void initElements() {
		txt_AIRLINE1  = MiscUtility.getWebElement(objFilepath, "ULD025_txt_AIRLINE1");
		btn_LIST = MiscUtility.getWebElement(objFilepath, "ULD025_btn_LIST");
		addPoollink = MiscUtility.getWebElement(objFilepath, "ULD025_addPoollink");
		txt_airlineOne = MiscUtility.getWebElement(objFilepath, "ULD025_txt_airlineOne");
		txt_airlineTwo = MiscUtility.getWebElement(objFilepath, "ULD025_txt_airlineTwo");
		txt_airport = MiscUtility.getWebElement(objFilepath, "ULD025_txt_airport");
		txt_remarks = MiscUtility.getWebElement(objFilepath, "ULD025_txt_remarks");
		btn_SAVE= MiscUtility.getWebElement(objFilepath, "ULD025_btn_SAVE");
		btn_CLOSE= MiscUtility.getWebElement(objFilepath, "ULD025_btn_CLOSE");
		chk_chkall= MiscUtility.getWebElement(objFilepath, "ULD025_chk_chkall");
		deletePoollink= MiscUtility.getWebElement(objFilepath, "ULD025_deletePoollink");
		btn_SEGMENTEXCEPTION= MiscUtility.getWebElement(objFilepath, "ULD025_btn_SEGMENTEXCEPTION");
		addUld = MiscUtility.getWebElement(objFilepath, "ULD025_addUld");
		txt_Origin = MiscUtility.getWebElement(objFilepath, "ULD025_txt_Origin");
		txt_Dest = MiscUtility.getWebElement(objFilepath, "ULD025_txt_Dest");
		btn_Ok = MiscUtility.getWebElement(objFilepath, "ULD025_btn_Ok");
		btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
   	  
        
        
	  }
      
        
        public ULD025 ULD_Pool_Owners(String Companycode,String origin,String dest) {

        
        	Companycode = PropertyHandler.getPropValue(dataFilePath, Companycode);
        	origin = PropertyHandler.getPropValue(dataFilePath, origin);
        	dest = PropertyHandler.getPropValue(dataFilePath, dest);
        	
        	 enterKeys(waitForElement(txt_AIRLINE1), Companycode);
        	 click(btn_LIST);
        	 minWait();
        	 click(addPoollink);
        	 minWait();
        	 enterKeys(txt_airlineOne, "YY");
        	 enterKeys(txt_airlineTwo, "PG");
        	 enterKeys(txt_airport, origin);
        	 enterKeys(txt_remarks, "Remark");
        	 check(chk_chkall);
        	 click(btn_SEGMENTEXCEPTION);
        	  waitForNewWindow(2);
        	  switchToSecondWindow();
        	  click(addUld);
        	  enterKeys(waitForElement(txt_Origin), origin);
        	  enterKeys(txt_Dest, dest);
        	  click(btn_Ok);
        	  switchToFirstWindow();
              waitForFrameAndSwitch(FRAME);
             click(btn_SAVE);
        
        return new ULD025(driver, dataFileName);

           }
        /// Relist 
        public ULD001 List_ULD_Pool_Owners(String Companycode) {

            
        	Companycode = PropertyHandler.getPropValue(dataFilePath, Companycode);
        	
        	 enterKeys(waitForElement(txt_AIRLINE1), Companycode);
             click(btn_LIST);
        	 minWait();
        	 Assert.assertEquals(waitForElement(txt_airlineOne).getAttribute("value"),"YY");
        	 enterKeys(txt_airlineTwo, "TK");
             click(btn_SAVE);
              return new ULD001(driver, dataFileName);

           }
        /// Delete
        public ULD001 Delete_ULD_Pool_Owners(String Companycode) {

            
        	Companycode = PropertyHandler.getPropValue(dataFilePath, Companycode);
        	
        	 enterKeys(waitForElement(txt_AIRLINE1), Companycode);
             click(btn_LIST);
        	 minWait();
        	 check(chk_chkall);
        	 click(deletePoollink);
        	 
             click(btn_SAVE);
              return new ULD001(driver, dataFileName);

           }
        /**
         * Closes the screen and go to home screen
         *
         * @return
         * @author A-6545
         */
        public HomePage close() {

            click(btn_CLOSE);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(btn_genericYes)) {

                click(btn_genericYes);
            }
            return new HomePage(driver, dataFileName);
        }      
    }
