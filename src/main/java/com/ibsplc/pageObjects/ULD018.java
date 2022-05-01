package com.ibsplc.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class ULD018 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	private String dataFileName;
	public static String FRAME = "iCargoContentFrameULD018";
	
	By
	Text_airlineCode,
	List_levelType,
	Text_levelValue,
    btn_genericYes,
    Generic_info_error,
	Generic_btn_noBtn,
	Text_uldGroupCode,
	BUTTON_Listbutton,
	Text_uldTypeCode,
	chk_check,
	Generic_info_msg,
	TABLE_monitoruldstock,
	BUTTON_Closebutton,
	BUTTON_GENERATEREPORT,
	btn_genericOk;
	    
	    
	public ULD018(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        this.dataFileName = dataFileName;
	    }

	private void initElements() {
   	   btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
   	    Generic_btn_noBtn= MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        Generic_info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        Text_airlineCode = MiscUtility.getWebElement(objFilepath, "ULD018_Text_airlineCode");
        List_levelType= MiscUtility.getWebElement(objFilepath, "ULD018_List_levelType");
        Text_levelValue= MiscUtility.getWebElement(objFilepath, "ULD018_Text_levelValue");
        Text_uldGroupCode= MiscUtility.getWebElement(objFilepath, "ULD018_Text_uldGroupCode");
        Text_uldTypeCode= MiscUtility.getWebElement(objFilepath, "ULD018_Text_uldTypeCode");
        BUTTON_Listbutton= MiscUtility.getWebElement(objFilepath, "ULD018_BUTTON_Listbutton");
        TABLE_monitoruldstock= MiscUtility.getWebElement(objFilepath, "ULD018_TABLE_monitoruldstock");
        BUTTON_Closebutton= MiscUtility.getWebElement(objFilepath, "ULD018_BUTTON_Closebutton");
        BUTTON_GENERATEREPORT= MiscUtility.getWebElement(objFilepath, "ULD018_BUTTON_GENERATEREPORT");
       chk_check= MiscUtility.getWebElement(objFilepath, "ULD018_chk_check");
        
        
	  }
      
        
        public ULD018 ListULD(String compCode,String uldType,String origin) {

        	compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
        	uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        	origin = PropertyHandler.getPropValue(dataFilePath, origin);
        	
        	 enterKeys(Text_airlineCode, compCode);
        	 selectByText(List_levelType, "Airport");
        	 enterKeys(Text_levelValue, origin);
        	 minWait();
        	 enterKeys(Text_uldGroupCode, "LD3");
        	 enterKeys(Text_uldTypeCode, uldType);
        	 click(BUTTON_Listbutton);
        	 Assert.assertEquals(tblGetTextByColValue(TABLE_monitoruldstock,3,2,compCode),origin);
     
       	 
       return new ULD018(driver, dataFileName);

           }
        /**
         * Closes the screen and go to home screen
         *
         * @return
         * @author A-6545
         */
        public ULD018 Generate_report() {
        	
        	check(chk_check);
          click(BUTTON_GENERATEREPORT);
           driver.switchTo().defaultContent();
           waitForNewWindow(2);
      	  switchToSecondWindow();
      	  driver.close();
      	  switchToFirstWindow();
      	waitForFrameAndSwitch(FRAME);
      	  return this;
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
