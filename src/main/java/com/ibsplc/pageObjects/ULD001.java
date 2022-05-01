package com.ibsplc.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class ULD001 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	private String dataFileName;
	public static String FRAME = "iCargoContentFrameULD001";
	
	By
	txt_AIRPORTCODE,
	txt_facilityType,
	btn_list,
   chk_selectedrowsAll,
	delRowLink,
	addRowLink,
	list_facilitytype,
	txt_loccode,
	txt_des,
	txt_des1,
	list_content,
	btn_SAVE,
	btn_genericYes,
	btn_CLOSE;
	    
	    
	public ULD001(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        this.dataFileName = dataFileName;
	    }

	private void initElements() {
		txt_AIRPORTCODE  = MiscUtility.getWebElement(objFilepath, "ULD001_txt_AIRPORTCODE");
		txt_facilityType = MiscUtility.getWebElement(objFilepath, "ULD001_txt_facilityType");
		btn_list = MiscUtility.getWebElement(objFilepath, "ULD001_btn_list");
	    chk_selectedrowsAll = MiscUtility.getWebElement(objFilepath, "ULD001_chk_selectedrowsAll");
		delRowLink = MiscUtility.getWebElement(objFilepath, "ULD001_delRowLink");
		addRowLink = MiscUtility.getWebElement(objFilepath, "ULD001_addRowLink");
		list_facilitytype = MiscUtility.getWebElement(objFilepath, "ULD001_list_facilitytype");
		txt_loccode= MiscUtility.getWebElement(objFilepath, "ULD001_txt_loccode");
		txt_des= MiscUtility.getWebElement(objFilepath, "ULD001_txt_des");
		list_content= MiscUtility.getWebElement(objFilepath, "ULD001_list_content");
		btn_SAVE= MiscUtility.getWebElement(objFilepath, "ULD001_btn_SAVE");
		btn_CLOSE= MiscUtility.getWebElement(objFilepath, "ULD001_btn_CLOSE");
		btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		txt_des1= MiscUtility.getWebElement(objFilepath, "ULD001_txt_des1");
        
        
	  }
      
        
        public ULD001 Airport_facility_master(String origin) {

        
        	origin = PropertyHandler.getPropValue(dataFilePath, origin);
        	
        	 enterKeys(waitForElement(txt_AIRPORTCODE), origin);
        	 selectByText(txt_facilityType, "Cargo");
        	 click(btn_list);
        	 minWait();
        	 check(chk_selectedrowsAll);
        	 click(delRowLink);
        	 minWait();
        	 click(addRowLink);
        	 minWait();
        	 selectByText(list_facilitytype, "Cargo");
        	 enterKeys(txt_loccode, "WHS");
        	 enterKeys(txt_des, "TESTING");
        	 selectByText(list_content, "A");
        	 click(btn_SAVE);
        
        return new ULD001(driver, dataFileName);

           }
        /// Relist 
        public ULD001 List_Airport_facility_master(String origin) {

            
        	origin = PropertyHandler.getPropValue(dataFilePath, origin);
        	
        	 enterKeys(waitForElement(txt_AIRPORTCODE), origin);
        	 selectByText(txt_facilityType, "Cargo");
        	 click(btn_list);
        	 minWait();
        	 System.out.println(waitForElement(txt_des1).getAttribute("value"));
        	// Assert.assertEquals(waitForElement(txt_des1).getAttribute("value").contains("WAREHOUSE"),"Error");
        	 enterKeys(txt_des1, "WAREHOUSE");
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
