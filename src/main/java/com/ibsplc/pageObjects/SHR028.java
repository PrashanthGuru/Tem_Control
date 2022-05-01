/**
 * 
 */
package com.ibsplc.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
/**
 * @author A-6545
 *
 */
public class SHR028 extends BasePage{
	 public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSHR028";

    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;
    private By 
    Text_uldCode,
    BUTTON_Savebutton,
    BUTTON_Closebutton,
    btn_genericYes,
    BUTTON_Activebutton,
    BUTTON_Listbutton,
    Generic_btn_noBtn,
    check,
    Text_uldGroupFilterCode,
    BUTTON_uldGroupCode,
    TABLE_uldGroupDetails,
    BUTTON_InActivebutton,
    Generic_info_msg,
    btn_genericOk;
    public SHR028(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    /**
     * Initializes the webelements
     *
     * @author A-6545
     */
    private void initElements() {
    	 btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	 Generic_btn_noBtn= MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
         btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
         Generic_info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
         Text_uldGroupFilterCode= MiscUtility.getWebElement(objFilepath, "SHR028_Text_uldGroupFilterCode");
         BUTTON_Listbutton= MiscUtility.getWebElement(objFilepath, "SHR028_BUTTON_Listbutton");
         TABLE_uldGroupDetails= MiscUtility.getWebElement(objFilepath, "SHR028_TABLE_uldGroupDetails");
         BUTTON_Activebutton= MiscUtility.getWebElement(objFilepath, "SHR028_BUTTON_Activebutton");
         BUTTON_InActivebutton= MiscUtility.getWebElement(objFilepath, "SHR028_BUTTON_InActivebutton");
        BUTTON_Closebutton =MiscUtility.getWebElement(objFilepath, "SHR028_BUTTON_Closebutton");
        BUTTON_Savebutton =MiscUtility.getWebElement(objFilepath, "SHR028_BUTTON_Savebutton");
        BUTTON_uldGroupCode=MiscUtility.getWebElement(objFilepath, "SHR028_BUTTON_uldGroupCode");
        check=MiscUtility.getWebElement(objFilepath, "SHR028_check");
   
    }
    /**
     * lists a ULDCode
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
    
     */
    private void list(String ULDCode) {

   	    
    	 enterKeys((Text_uldGroupFilterCode), ULDCode);
         click(BUTTON_Listbutton);
         minWait();
    }
    /**
     * 
     * @param fltCar
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author A-6545
     */
    public SHR028 ULD_grpInactive(String ULDCode, String aircraftType2) {

    	aircraftType2 = PropertyHandler.getPropValue(dataFilePath, aircraftType2);
    	ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
   	 list(ULDCode);
   	check(check);
   //	 tblSelectRowByColValue(TABLE_uldGroupDetails, 1, 4, aircraftType2);
   	 click(BUTTON_InActivebutton);
   	driver.switchTo().defaultContent();
   	 click(waitForElement(Generic_btn_noBtn));
   	 waitForFrameAndSwitch(FRAME);
     	click(BUTTON_InActivebutton);
     	driver.switchTo().defaultContent();
     	
  	  click(waitForElement(btn_genericYes));
  	 waitForFrameAndSwitch(FRAME);
       click(BUTTON_Savebutton);
        
        return new SHR028(driver, dataFileName);

    }
    /**
     * 
   
     * @return 
     * @author A-6545
     */
    public SHR028 ULD_grpVerification(String ULDCode) {

    	ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
       	
      	 list(ULDCode);
      	Assert.assertTrue(waitForElement(Text_uldGroupFilterCode).getAttribute("value").equalsIgnoreCase(ULDCode));
      
         return new SHR028(driver, dataFileName);

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

  
    