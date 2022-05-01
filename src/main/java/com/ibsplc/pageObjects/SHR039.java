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
public class SHR039 extends BasePage {
	 public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
	    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	    public static String FRAME = "iCargoContentFrameSHR039";

	    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	    private WebDriver driver;
	    private String dataFileName;
	    private By 
	    Text_uldCode,
	    BUTTON_Savebutton,
	    Text_aircraftType_v,
	    Text_positionNum_v,
	    BUTTON_Closebutton,
	    BUTTON_Selectbutton,
	    btn_genericYes,
	    Text_structuralWtLmt,
	    Text_baseDimLength,
	    Text_baseDimWidth,
	    Text_baseDimHeight,
	    Text_aircraftType,
	    Text_aircraftType2,
	    List_maxVolumeUnit,
	    List_uldGroupStatus,
	    List_uldType,
	    Text_IATARepCost,
	    ChkBox_upperdeck,
	    ChkBox_upperdeck2,
	     Text_positionNum,
	    IMG_addLink,
	    Text_positionNum2,
	    Text_IATARepCostUnit,
	    Generic_info_error,
        btn_genericOk;
	  
	    public SHR039(WebDriver driver, String dataFileName) {
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
	         btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
	         Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
	         Text_uldCode = MiscUtility.getWebElement(objFilepath, "SHR039_Text_uldCode");
	         BUTTON_Selectbutton= MiscUtility.getWebElement(objFilepath, "SHR039_BUTTON_Selectbutton");
	         List_uldType= MiscUtility.getWebElement(objFilepath, "SHR039_List_uldType");
	         Text_structuralWtLmt= MiscUtility.getWebElement(objFilepath, "SHR039_Text_structuralWtLmt");
	         Text_baseDimLength= MiscUtility.getWebElement(objFilepath, "SHR039_Text_baseDimLength");
	         Text_baseDimWidth= MiscUtility.getWebElement(objFilepath, "SHR039_Text_baseDimWidth");
	         Text_baseDimHeight= MiscUtility.getWebElement(objFilepath, "SHR039_Text_baseDimHeight");
	         List_uldGroupStatus= MiscUtility.getWebElement(objFilepath, "SHR039_List_uldGroupStatus");
	         List_maxVolumeUnit= MiscUtility.getWebElement(objFilepath, "SHR039_List_maxVolumeUnit");
	         Text_IATARepCost= MiscUtility.getWebElement(objFilepath, "SHR039_Text_IATARepCost");
	         Text_IATARepCostUnit= MiscUtility.getWebElement(objFilepath, "SHR039_Text_IATARepCostUnit");
	         BUTTON_Savebutton= MiscUtility.getWebElement(objFilepath, "SHR039_BUTTON_Savebutton");
	         Text_aircraftType_v = MiscUtility.getWebElement(objFilepath, "SHR039_Text_aircraftType_v");
	 	    Text_positionNum_v = MiscUtility.getWebElement(objFilepath, "SHR039_Text_positionNum_v");
	         BUTTON_Closebutton= MiscUtility.getWebElement(objFilepath, "SHR039_BUTTON_Closebutton");
	         Text_aircraftType= MiscUtility.getWebElement(objFilepath, "SHR039_Text_aircraftType");
	         Text_positionNum=MiscUtility.getWebElement(objFilepath, "SHR039_Text_positionNum");
	         ChkBox_upperdeck=MiscUtility.getWebElement(objFilepath, "SHR039_ChkBox_upperdeck");
	         Text_aircraftType2= MiscUtility.getWebElement(objFilepath, "SHR039_Text_aircraftType2");
	         Text_positionNum2=MiscUtility.getWebElement(objFilepath, "SHR039_Text_positionNum2");
	         ChkBox_upperdeck2=MiscUtility.getWebElement(objFilepath, "SHR039_ChkBox_upperdeck2");
	         IMG_addLink=MiscUtility.getWebElement(objFilepath, "SHR039_IMG_addLink");
	    }    
	        
	    /**
	     * lists a ULDCode
	     *
	     * @param fltCar
	     * @param fltNo
	     * @param fltDt
	    
	     */
	    private void list(String ULDCode) {

	    	 enterKeys(Text_uldCode, ULDCode);
             click(BUTTON_Selectbutton);
             minWait();
	    }
	    /**
	          * 
	         * @param ULDCode
	       
	          * @return
	          * @author A-6545
	          */
	         public SHR039 ULD_GroupCreation(String ULDCode) {

	        	 ULDCode = BizUtility.generateRandomAlphabets(Integer.parseInt("3"));
	        	 PropertyHandler.setPropValue(dataFilePath, ULDCode, ULDCode);
	        	 list(ULDCode);

                driver.switchTo().defaultContent();

	             click(waitForElement(btn_genericYes));
	       
	             waitForFrameAndSwitch(FRAME);
	             selectByText(List_uldType,"Container");
	             enterKeys(Text_structuralWtLmt, "100");
	             enterKeys(Text_baseDimLength, "318");
	             enterKeys(Text_baseDimWidth, "153");
	             enterKeys(Text_baseDimHeight, "163");
	             selectByText(List_uldGroupStatus,"Active");
	             enterKeys(List_maxVolumeUnit, "10");
	             enterKeys(Text_IATARepCost, "2160");
	             enterKeys(Text_IATARepCostUnit, "USD");
	             click(BUTTON_Savebutton);
	             
	             return new SHR039(driver, dataFileName);

	         }
	       

	

			/**
	          * 
	        * @param ULDCode
	          * @param aircraftType
	          * @return
	          * @author A-6545
	          */
	         public SHR039 ULD_AddCompatibility(String ULDCode,String aircraftType) {

	        	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
	        	 aircraftType = PropertyHandler.getPropValue(dataFilePath, aircraftType);
	             
	        	 list(ULDCode);
	           
	             enterKeys(Text_aircraftType, aircraftType);
	             enterKeys(Text_positionNum, "1");
	             check(ChkBox_upperdeck);
	             click(BUTTON_Savebutton);
	             minWait();
	             return new SHR039(driver, dataFileName);

	         }
	         /**
	          * 
	          * @param ULDCode
	          * @param aircraftType2
	     
	          * @return 
	          * @author A-6545
	          */
	         public SHR039 ULD_Modification(String ULDCode,String aircraftType2) {

	        	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
	        	 aircraftType2 = PropertyHandler.getPropValue(dataFilePath, aircraftType2);
	             
	        	 list(ULDCode);
	      
	             enterKeys(Text_aircraftType, aircraftType2);
	             enterKeys(Text_positionNum, "20");
	             check(ChkBox_upperdeck);
	             click(BUTTON_Savebutton);
	             minWait();
	             return new SHR039(driver, dataFileName);

	         } 
	         /**
	          * 
	          * @param ULDCode
	          * @param aircraftType2
	   
	          * @return 
	          * @author A-6545
	          */
	         public SHR039 ULD_ModificationVerification(String ULDCode,String aircraftType2) {

	        	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
	        	 aircraftType2 = PropertyHandler.getPropValue(dataFilePath, aircraftType2);
	             
	        	 list(ULDCode);
	        	String value= waitForElement(Text_aircraftType_v).getAttribute("value");
	        	System.out.println(value);
	        	 Assert.assertTrue(waitForElement(Text_aircraftType_v).getAttribute("value").equalsIgnoreCase(aircraftType2));
	        	 Assert.assertTrue(waitForElement(Text_positionNum_v).getAttribute("value").equalsIgnoreCase("20"));
	        
	              
	             return new SHR039(driver, dataFileName);

	         }
	        
	         /**
	          * 
	        * @param ULDCode
	          
	          * @param awbNo
	          * @return 
	          * @author A-6545
	          */
	         public SHR039 ULD_Modification_Inactive(String ULDCode) {

	        	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
            	 list(ULDCode);
                selectByText(List_uldGroupStatus,"Inactive");
	             click(BUTTON_Savebutton);
                 return new SHR039(driver, dataFileName);

	         }
	         public SHR039 ULD_Modification_Active(String ULDCode) {

	        	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
            	 list(ULDCode);
               selectByText(List_uldGroupStatus,"Active");
	             click(BUTTON_Savebutton);
	             
                 return new SHR039(driver, dataFileName);

	         }
	         /**
	          * 
	         * @param ULDCode
	          * @param aircraftType
	          * @return
	          * @author A-6545
	          */
	         public SHR039 AddCompatibility_checkError(String ULDCode,String aircraftType) {

	        	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
	        	 aircraftType = PropertyHandler.getPropValue(dataFilePath, aircraftType);
	             
	        	 list(ULDCode);
	            // click(IMG_addLink);
	             
	             enterKeys(Text_aircraftType2, aircraftType);
	             enterKeys(Text_positionNum2, "1");
	             check(ChkBox_upperdeck2);
	             click(BUTTON_Savebutton);
	            Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("LowerDeck false combination has been duplicated"));
	             
	             return new SHR039(driver, dataFileName);

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
