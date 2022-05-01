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

public class ULD014 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	private String dataFileName;
	public static String FRAME = "iCargoContentFrameULD014";
	
	By
	Text_partyCode,
	Text_fromDate,
	Text_toDate,
	Text_currencyCode,
	Text_uldType,
	Text_station,
	Text_validFrom,
    Text_freeLoanPeriod,
	Text_taxes,
	No_div,
	createlink,
	BUTTON_Savebutton,
	modifylink,
	Okbutton,
	BUTTON_Listbutton,
	BUTTON_PrintAgreementbutton,
	selectedChecks0,
	deletelink,
	Text_agreementNumber,
	BUTTON_Closebutton,
    btn_genericYes,
    Generic_info_error,
	Generic_btn_noBtn,

    btn_genericOk;
	    
	    
	public ULD014(WebDriver driver, String dataFileName) {
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
        Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        Text_partyCode = MiscUtility.getWebElement(objFilepath, "ULD014_Text_partyCode");
        Text_fromDate = MiscUtility.getWebElement(objFilepath, "ULD014_Text_fromDate");
        Text_toDate = MiscUtility.getWebElement(objFilepath, "ULD014_Text_toDate");
        Text_currencyCode = MiscUtility.getWebElement(objFilepath, "ULD014_Text_currencyCode");
        createlink= MiscUtility.getWebElement(objFilepath, "ULD014_createlink");
        Text_uldType	= MiscUtility.getWebElement(objFilepath, "ULD014_Text_uldType");
        Text_station= MiscUtility.getWebElement(objFilepath, "ULD014_Text_station");
        Text_validFrom = MiscUtility.getWebElement(objFilepath, "ULD014_Text_validFrom"); 
        Text_freeLoanPeriod  = MiscUtility.getWebElement(objFilepath, "ULD014_Text_freeLoanPeriod"); 
    	Text_taxes  = MiscUtility.getWebElement(objFilepath, "ULD014_Text_taxes"); 
    	Okbutton  = MiscUtility.getWebElement(objFilepath, "ULD014_Okbutton"); 
    	BUTTON_Savebutton	 = MiscUtility.getWebElement(objFilepath, "ULD014_BUTTON_Savebutton"); 
    	BUTTON_Closebutton	 = MiscUtility.getWebElement(objFilepath, "ULD014_BUTTON_Closebutton"); 
    	No_div = MiscUtility.getWebElement(objFilepath, "ULD014_No_div"); 
    	Text_agreementNumber = MiscUtility.getWebElement(objFilepath, "ULD014_Text_agreementNumber"); 
    	BUTTON_Listbutton = MiscUtility.getWebElement(objFilepath, "ULD014_BUTTON_Listbutton"); 
    	modifylink= MiscUtility.getWebElement(objFilepath, "ULD014_modifylink"); 
    	selectedChecks0= MiscUtility.getWebElement(objFilepath, "ULD014_selectedChecks0"); 
    	deletelink= MiscUtility.getWebElement(objFilepath, "ULD014_deletelink"); 
    	BUTTON_Closebutton= MiscUtility.getWebElement(objFilepath, "ULD014_BUTTON_Closebutton"); 
    	BUTTON_PrintAgreementbutton= MiscUtility.getWebElement(objFilepath, "ULD014_BUTTON_PrintAgreementbutton"); 
	  }
      
        
        public ULD014 Create_Agreement(String flightStartDate,String currency1,String origin,String uldType, String AgreementNo) {

     
        	flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
        	currency1 = PropertyHandler.getPropValue(dataFilePath, currency1);
        	origin = PropertyHandler.getPropValue(dataFilePath, origin);
        	uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        
        	  enterKeys(Text_partyCode, "TK");
        	  enterKeys(Text_fromDate, flightStartDate);
        	  enterKeys(Text_toDate, flightStartDate);
        	  minWait();
        	  enterKeys(Text_currencyCode, currency1);
        	  click(createlink);
        	  waitForNewWindow(2);
        	  switchToSecondWindow();
              enterKeys(Text_uldType, uldType);
              enterKeys(Text_station, origin);
              enterKeys(Text_validFrom, flightStartDate);
              enterKeys(Text_freeLoanPeriod, "1");
              enterKeys(Text_taxes, "1");
             click(Okbutton);
           
             switchToFirstWindow();
             waitForFrameAndSwitch(FRAME);
             minWait();
             
             click(BUTTON_Savebutton);
             if (verifyElementPresent(Generic_info_error))
             {
            	 Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("Agreement already exists"));
             }
             else{
        
           driver.switchTo().defaultContent();
           String value= waitForElement(No_div).getText();
           String[] splitStr = value.split("\\s+");
           System.out.println(value);
           String split_e=splitStr[7];
                        
        System.out.println(split_e);
       PropertyHandler.setPropValue(dataFilePath, AgreementNo, split_e);
      click(btn_genericOk);
      waitForFrameAndSwitch(FRAME);
             }
        	 return new ULD014(driver, dataFileName);

           }
     /// Modify the uld Agreement
        public ULD014 Modify_Agreement( String AgreementNo) {

        
        	AgreementNo = PropertyHandler.getPropValue(dataFilePath, AgreementNo);
          
        	enterKeys(Text_agreementNumber, AgreementNo);
        	click(BUTTON_Listbutton);
        	minWait();
        	
        	check(selectedChecks0);
        	click(modifylink);
        	 waitForNewWindow(2);
       	  switchToSecondWindow();
            enterKeys(Text_freeLoanPeriod, "2");
             enterKeys(Text_taxes, "2");
              click(Okbutton);
              switchToFirstWindow();
              waitForFrameAndSwitch(FRAME);
              minWait();
             click(BUTTON_Savebutton);
           
        	 return new ULD014(driver, dataFileName);

           }
        /// Delete the uld Agreement and Print
        public ULD014 Delete_Agreement( String AgreementNo) {

            
        	AgreementNo = PropertyHandler.getPropValue(dataFilePath, AgreementNo);
          
        	enterKeys(Text_agreementNumber, AgreementNo);
        	click(BUTTON_Listbutton);
        	minWait();
        	
        	check(selectedChecks0);
        	click(deletelink);
        	  driver.switchTo().defaultContent();
        	 click(waitForElement(Generic_btn_noBtn));
        	 waitForFrameAndSwitch(FRAME);
        	 check(selectedChecks0);
        	 click(deletelink);
        	 driver.switchTo().defaultContent();
        	 click(waitForElement(btn_genericYes));
        	 waitForFrameAndSwitch(FRAME);
              minWait();
             click(BUTTON_Savebutton);
             minWait();
             enterKeys(Text_agreementNumber, AgreementNo);
         	click(BUTTON_Listbutton);
         	minWait();
             click(BUTTON_PrintAgreementbutton);
             
           
        	 return new ULD014(driver, dataFileName);

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
