package com.ibsplc.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class ULD011 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	private String dataFileName;
	public static String FRAME = "iCargoContentFrameULD011";
	
	By
	List_accessoryCode,
	Text_stationCode,
	BUTTON_Listbutton,
	Text_available,
	BUTTON_Savebutton,
	BUTTON_Closebutton,
	Text_minimumQuantity,
    btn_genericYes,
    Generic_info_error,
	Generic_btn_noBtn,
	Generic_info_msg,
   btn_genericOk;
	    
	    
	public ULD011(WebDriver driver, String dataFileName) {
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
        List_accessoryCode = MiscUtility.getWebElement(objFilepath, "ULD011_List_accessoryCode");
        Text_stationCode= MiscUtility.getWebElement(objFilepath, "ULD011_Text_stationCode");
        BUTTON_Listbutton= MiscUtility.getWebElement(objFilepath, "ULD011_BUTTON_Listbutton");
        Text_minimumQuantity= MiscUtility.getWebElement(objFilepath, "ULD011_Text_minimumQuantity");
        Text_available= MiscUtility.getWebElement(objFilepath, "ULD011_Text_available");
    	BUTTON_Savebutton= MiscUtility.getWebElement(objFilepath, "ULD011_BUTTON_Savebutton");
    	BUTTON_Closebutton= MiscUtility.getWebElement(objFilepath, "ULD011_BUTTON_Closebutton");
      
        
	  }
      
        
        public ULD011 SaveULD(String compCode,String uldType,String origin, String minimumQuantity) {

        	compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
        	uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        	origin = PropertyHandler.getPropValue(dataFilePath, origin);
        
        	selectByText(List_accessoryCode, "Net");
        	  enterKeys(Text_stationCode, origin);
        	  minWait();
        	  click(BUTTON_Listbutton);
        	  driver.switchTo().defaultContent();
        	  if (verifyElementPresent(btn_genericYes)) {

                  click(btn_genericYes);
              }
        	  waitForFrameAndSwitch(FRAME);
        	  enterKeys(Text_minimumQuantity, minimumQuantity);
        	  enterKeys(Text_available, "100");
        	  
        	    click(BUTTON_Savebutton);
       	   

      
        	  
         	 return new ULD011(driver, dataFileName);

           }
        public ULD011 Modify_Details(String compCode,String uldType,String origin, String minimumQuantity) {

        	compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
        	uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        	origin = PropertyHandler.getPropValue(dataFilePath, origin);
        
        	selectByText(List_accessoryCode, "Net");
        	  enterKeys(Text_stationCode, origin);
        	  minWait();
        	  click(BUTTON_Listbutton);
              enterKeys(Text_minimumQuantity, minimumQuantity);
              click(BUTTON_Savebutton);
       	   return new ULD011(driver, dataFileName);

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
