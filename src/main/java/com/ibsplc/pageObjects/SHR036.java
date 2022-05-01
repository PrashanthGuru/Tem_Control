/**
 * 
 */
package com.ibsplc.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
/**
 * @author A-6545
 *
 */
public class SHR036 extends BasePage{
	 public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSHR036";

    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;
    private By 
    Text_uldCode,
    BUTTON_Listbutton,
    List_uldTypeStatus,
    btn_genericYes,
    BUTTON_Closebutton,
    Text_baseDimLength,
    IMG_addLink,
    IMG_addfn,
    Text_contourVolume,
    CONTOUR_Okbutton,
    Text_baseDimWidth,
    Text_baseDimHeight,
    Text_structuralWtLmt,
    Text_aircraftType,
    BUTTON_TareWeightbutton,
    Text_positionNum,
    ChkBox_upperdeck,
    BUTTON_DefineContourbutton,
    Text_airlineCode,
    Text_popTareWeight,
    UldTypeSetup_Okbutton,
    Text_aircraftType2,
    Text_positionNum2,
    ChkBox_upperdeck2,
    Generic_info_error,
    add_link,
    Text_uldGroupCode,
    text_maxVolume,
    List_uldType,
    BUTTON_Savebutton,
    Text_tareWt,
    Generic_btn_noBtn,
    Generic_info_msg,
    btn_genericOk;
    
    public SHR036(WebDriver driver, String dataFileName) {
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
         Text_uldCode= MiscUtility.getWebElement(objFilepath, "SHR036_Text_uldCode");
         BUTTON_Listbutton= MiscUtility.getWebElement(objFilepath, "SHR036_BUTTON_Listbutton");
         Text_uldGroupCode= MiscUtility.getWebElement(objFilepath, "SHR036_Text_uldGroupCode");
         List_uldTypeStatus= MiscUtility.getWebElement(objFilepath, "SHR036_List_uldTypeStatus");
         Text_structuralWtLmt= MiscUtility.getWebElement(objFilepath, "SHR036_Text_structuralWtLmt");
         Text_baseDimLength = MiscUtility.getWebElement(objFilepath, "SHR036_Text_baseDimLength");
         Text_baseDimWidth = MiscUtility.getWebElement(objFilepath, "SHR036_Text_baseDimWidth");
         Text_baseDimHeight = MiscUtility.getWebElement(objFilepath, "SHR036_Text_baseDimHeight");
         List_uldType = MiscUtility.getWebElement(objFilepath, "SHR036_List_uldType");
         Text_tareWt = MiscUtility.getWebElement(objFilepath, "SHR036_Text_tareWt");
         BUTTON_Closebutton = MiscUtility.getWebElement(objFilepath, "SHR036_BUTTON_Closebutton");
         BUTTON_Savebutton = MiscUtility.getWebElement(objFilepath, "SHR036_BUTTON_Savebutton");
         text_maxVolume = MiscUtility.getWebElement(objFilepath, "SHR036_text_maxVolume");
         add_link = MiscUtility.getWebElement(objFilepath, "SHR036_add_link");
         Text_aircraftType = MiscUtility.getWebElement(objFilepath, "SHR036_Text_aircraftType");
         Text_positionNum = MiscUtility.getWebElement(objFilepath, "SHR036_Text_positionNum");
         ChkBox_upperdeck = MiscUtility.getWebElement(objFilepath, "SHR036_ChkBox_upperdeck");
         Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
         Text_aircraftType2  = MiscUtility.getWebElement(objFilepath, "SHR036_Text_aircraftType2");
         Text_positionNum2  = MiscUtility.getWebElement(objFilepath, "SHR036_Text_positionNum2");
         ChkBox_upperdeck2  = MiscUtility.getWebElement(objFilepath, "SHR036_ChkBox_upperdeck2");
         BUTTON_DefineContourbutton  = MiscUtility.getWebElement(objFilepath, "SHR036_BUTTON_DefineContourbutton");
         IMG_addfn	= MiscUtility.getWebElement(objFilepath, "SHR036_IMG_addfn");
         IMG_addLink	= MiscUtility.getWebElement(objFilepath, "SHR039_IMG_addLink");
         Text_contourVolume	= MiscUtility.getWebElement(objFilepath, "SHR036_Text_contourVolume");
         CONTOUR_Okbutton	= MiscUtility.getWebElement(objFilepath, "SHR036_CONTOUR_Okbutton");
         BUTTON_TareWeightbutton	= MiscUtility.getWebElement(objFilepath, "SHR036_BUTTON_TareWeightbutton");
         Text_airlineCode 	= MiscUtility.getWebElement(objFilepath, "SHR036_Text_airlineCode");
         Text_popTareWeight 	= MiscUtility.getWebElement(objFilepath, "SHR036_Text_popTareWeight");
         UldTypeSetup_Okbutton 	= MiscUtility.getWebElement(objFilepath, "SHR036_UldTypeSetup_Okbutton");
    }
    /**
     * lists a ULDCode
     *
     * @param fltCar
     * @param fltNo
     * @param fltDt
    
     */
    private void list(String ULDCode1) {

    	 enterKeys((Text_uldCode), ULDCode1);
         click(BUTTON_Listbutton);
         minWait();
    }
    /**
     * 
      * @param ULDCode
       * @param value
       * @return 
     * @return
     * @author A-6545
     */
    public SHR036 ULD_typeCreation(String ULDCode,String value,String ULDCode1) {

   	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
   	 ULDCode1 = BizUtility.generateRandomAlphabets(Integer.parseInt("3"));
   	 list(ULDCode1);
   	 driver.switchTo().defaultContent();
      click(waitForElement(btn_genericYes));
      waitForFrameAndSwitch(FRAME);
      
      enterKeys((Text_uldGroupCode), ULDCode);
      selectByText(List_uldTypeStatus, "Active");
      enterKeys(Text_structuralWtLmt, value);
      enterKeys(Text_baseDimLength, "318");
      enterKeys(Text_baseDimWidth, "153");
      enterKeys(Text_baseDimHeight, "163");
      selectByText(List_uldType, "Container");
      enterKeys(text_maxVolume, value);
     enterKeys(Text_tareWt, value);
      click(BUTTON_Savebutton);
      return new SHR036(driver, dataFileName);

    }
   
	/**
     * 
       * @param ULDCode
       * @param value
       * @return 
     * @return
     * @author A-6545
     */
    public SHR036 ULD_AddCompatibility(String ULDCode,String aircraftType) {

   	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
   	 aircraftType = PropertyHandler.getPropValue(dataFilePath, aircraftType);
        list(ULDCode);
        click(add_link);
        minWait();
        enterKeys(Text_aircraftType, aircraftType);
        enterKeys(Text_positionNum, "1");
        check(ChkBox_upperdeck);
        click(BUTTON_Savebutton);
        minWait();
        return new SHR036(driver, dataFileName);

    }
    /**
     * 
    * @param ULDCode
       * @param value
       * @return 
     * @return
     * @author A-6545
     */
    public SHR036 AddCompatibility_checkError(String ULDCode,String aircraftType) {

   	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
   	 aircraftType = PropertyHandler.getPropValue(dataFilePath, aircraftType);
        
   	 list(ULDCode);
   	 
        click(IMG_addLink);
        
        enterKeys(Text_aircraftType2, aircraftType);
        enterKeys(Text_positionNum2, "1");
        check(ChkBox_upperdeck2);
        click(BUTTON_Savebutton);
       Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("LowerDeck false combination has been duplicated"));
        
        return new SHR036(driver, dataFileName);

    }
    /**
     * 
       * @param ULDCode
       * @param value
       * @return 
     * @return
     * @author A-6545
     */
    public SHR036 Define_Contour(String ULDCode,String aircraftType) {

   	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
   	 aircraftType = PropertyHandler.getPropValue(dataFilePath, aircraftType);
        
   	 list(ULDCode);
       // click(IMG_addLink);
   	click(BUTTON_DefineContourbutton);
   	waitForNewWindow(2);
    switchToSecondWindow();
    click(IMG_addfn);
    enterKeys(Text_contourVolume, "100");
    click(CONTOUR_Okbutton);

    //switch back to main window
    switchToFirstWindow();
    waitForFrameAndSwitch(FRAME);
    
        click(BUTTON_Savebutton);
    
        return new SHR036(driver, dataFileName);

    }
    public SHR036 Tare_wt(String ULDCode) {

      	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
   
           
      	 list(ULDCode);
          // click(IMG_addLink);
      	click(BUTTON_TareWeightbutton);
      	minWait();
      	waitForNewWindow(2);
       switchToSecondWindow();
       click(IMG_addfn);
       minWait();
       enterKeys(Text_airlineCode, "AV");
       enterKeys(Text_popTareWeight, "1000");
       click(UldTypeSetup_Okbutton);

       //switch back to main window
       switchToFirstWindow();
       waitForFrameAndSwitch(FRAME);
       
           click(BUTTON_Savebutton);
       
           return new SHR036(driver, dataFileName);

       }
    
    /**
     * 
       * @param ULDCode
       * @param value
       * @return 
     * @return 
     * @author A-6545
     */
    public SHR036 ULD_Modification(String ULDCode,String value) {

   	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);

        
   	 list(ULDCode);
   	enterKeys(Text_structuralWtLmt, value);
    
        click(BUTTON_Savebutton);
        minWait();
        return new SHR036(driver, dataFileName);

    } 
    /**
     * 
      * @param ULDCode
       * @param value
       * @return 
     * @author A-6545
     */
    public SHR036 ULD_ModificationVerification(String ULDCode,String value) {

   	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
  	 list(ULDCode);
       Assert.assertTrue(waitForElement(Text_structuralWtLmt).getAttribute("value").equals(value));
    
        return new SHR036(driver, dataFileName);

    }
    
    public SHR036 ULD_Modification_InActive(String ULDCode) {

   	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
   	 list(ULDCode);
     selectByText(List_uldTypeStatus,"Inactive");
     click(BUTTON_Savebutton);
        
        return new SHR036(driver, dataFileName);
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