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
public class SHR029 extends BasePage {
	 public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
	    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	    public static String FRAME = "iCargoContentFrameSHR029";

	    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	    private WebDriver driver;
	    private String dataFileName;
	    private By 
	   
	    BUTTON_Savebutton,
	    BUTTON_Closebutton,
	    Text_uldTypeFilterCode,
	    TABLE_uldTypeDetails,
	    btn_genericYes,
	    Generic_btn_noBtn,
	    BUTTON_UldTypeCode,
	    BUTTON_Listbutton,
	    Generic_info_error,
	    BUTTON_InActivebutton,
     btn_genericOk;
	  
	    public SHR029(WebDriver driver, String dataFileName) {
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
	         Generic_btn_noBtn= MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
	         Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
	         Text_uldTypeFilterCode = MiscUtility.getWebElement(objFilepath, "SHR029_Text_uldTypeFilterCode");
	         BUTTON_Listbutton= MiscUtility.getWebElement(objFilepath, "SHR029_BUTTON_Listbutton");
	         TABLE_uldTypeDetails= MiscUtility.getWebElement(objFilepath, "SHR029_TABLE_uldTypeDetails");
	         BUTTON_InActivebutton= MiscUtility.getWebElement(objFilepath, "SHR029_BUTTON_InActivebutton");
	         BUTTON_UldTypeCode= MiscUtility.getWebElement(objFilepath, "SHR029_BUTTON_UldTypeCode");
	         BUTTON_Closebutton= MiscUtility.getWebElement(objFilepath, "SHR029_BUTTON_close");
	         
	    }    
	        
	    /**
	     * lists a ULDCode
	     *
	     * @param fltCar
	     * @param fltNo
	     * @param fltDt
	    
	     */
	    private void list(String ULDCode) {

	    	 enterKeys((Text_uldTypeFilterCode), ULDCode);
          click(BUTTON_Listbutton);
          minWait();
	    }
	    /**
	          * 
	         * @param ULDCode
	       
	          * @return
	          * @author A-6545
	          */
	         public SHR029 ULD_GroupCreation(String ULDCode) {

	        	 ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
	        	
	        	 list(ULDCode);

	        	 tblSelectRowByColValue(TABLE_uldTypeDetails, 1, 2, ULDCode);
	        	 
	           	 click(BUTTON_InActivebutton);
	           	 driver.switchTo().defaultContent();
	           	 click(waitForElement(Generic_btn_noBtn));
	           	 
	             	click(BUTTON_InActivebutton);
	             	 driver.switchTo().defaultContent();
	          	  click(waitForElement(btn_genericYes));
	               click(BUTTON_Savebutton);
	               
	             return new SHR029(driver, dataFileName);

	         }
	       
	         /**
	          * 
	         * @return 
	         * @author A-6545
	         */
	        public SHR029 ULD_grpVerification(String ULDCode) {

	        	ULDCode = PropertyHandler.getPropValue(dataFilePath, ULDCode);
	           	
	          	 list(ULDCode);
	          	Assert.assertTrue(waitForElement(BUTTON_UldTypeCode).getText().equalsIgnoreCase(ULDCode)); 
	       
	             return new SHR029(driver, dataFileName);

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
