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
public class ULD015 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	private String dataFileName;
	public static String FRAME = "iCargoContentFrameULD016";
	
	By
	txt_uldNo,
	btn_list,
	tbl_TransactionHistory,
	List_Movements,
	btn_genericYes,
	dropDown_mvmnt,
	List_uldNature,
	Setupuldblock_Text_uldTypeCode,
	Setupuldblock_Text_minimumQty,
	Setupuldblock_Text_maximumQty,
	tbl_uldDtls,
	Text_airlineCode,
	btn_clear,
	BUTTON_Listbutton,
    btn_close,
    Setupuldblock_Text_remarks,
    Setupuldblock_BUTTON_Savebutton,
    Setupuldblock_modifyLink,
    Setupuldblock_TABLE_fixed_header_table_0,
	createLink,
	Setupuldblock_BUTTON_Closebutton,
	Generic_info_error,
	Generic_btn_noBtn,
	Setupuldblock_chk_check,
	Setupuldblock_BUTTON_Savebuttonsearch,
	Generic_info_msg,
	Text_STATIONCODE,
	btn_genericOk;
	    
	    
	public ULD015(WebDriver driver, String dataFileName) {
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
        Text_airlineCode = MiscUtility.getWebElement(objFilepath, "ULD015_Text_airlineCode");
        BUTTON_Listbutton = MiscUtility.getWebElement(objFilepath, "ULD015_BUTTON_Listbutton");
        createLink = MiscUtility.getWebElement(objFilepath, "ULD015_createLink");
        Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    	List_uldNature = MiscUtility.getWebElement(objFilepath, "ULD015_createLink");
    	Setupuldblock_Text_uldTypeCode = MiscUtility.getWebElement(objFilepath, "ULD015_Setupuldblock_Text_uldTypeCode");
    	Setupuldblock_Text_minimumQty = MiscUtility.getWebElement(objFilepath, "ULD015_Setupuldblock_Text_minimumQty");
    	Setupuldblock_Text_maximumQty = MiscUtility.getWebElement(objFilepath, "ULD015_Setupuldblock_Text_maximumQty");
    	Setupuldblock_BUTTON_Savebutton= MiscUtility.getWebElement(objFilepath, "ULD015_Setupuldblock_BUTTON_Savebutton");
    	Setupuldblock_BUTTON_Closebutton= MiscUtility.getWebElement(objFilepath, "ULD015_Setupuldblock_BUTTON_Closebutton");
    	Setupuldblock_Text_remarks  = MiscUtility.getWebElement(objFilepath, "ULD015_Setupuldblock_Text_remarks");
    	Setupuldblock_modifyLink= MiscUtility.getWebElement(objFilepath, "ULD015_Setupuldblock_modifyLink");
    	Setupuldblock_TABLE_fixed_header_table_0= MiscUtility.getWebElement(objFilepath, "ULD015_Setupuldblock_TABLE_fixed_header_table_0");
    	Setupuldblock_BUTTON_Savebuttonsearch = MiscUtility.getWebElement(objFilepath, "ULD015_Setupuldblock_BUTTON_Savebuttonsearch");
    	Text_STATIONCODE= MiscUtility.getWebElement(objFilepath, "ULD015_Text_STATIONCODE");
    	Setupuldblock_chk_check= MiscUtility.getWebElement(objFilepath, "ULD015_Setupuldblock_chk_check");
	}
        private void list(String compCode,String origin) {
        
        	
        	enterKeys(Text_STATIONCODE, origin);
        	 
       
             click(BUTTON_Listbutton);
             minWait();
        }
       
        
        public ULD015 Setup_uld(String compCode,String uldType,String minimumQty,String maximumQty,String origin) {

        	compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
        	uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        	origin = PropertyHandler.getPropValue(dataFilePath, origin);
         	 list(compCode,origin);
         	 minWait();
         	 click(createLink);
          	waitForNewWindow(2);
            switchToSecondWindow();
            minWait();
         //	 selectByIndex(List_uldNature, 3);
         	 enterKeys(Setupuldblock_Text_uldTypeCode, uldType);
         	 enterKeys(Setupuldblock_Text_minimumQty, maximumQty);
        	 enterKeys(Setupuldblock_Text_maximumQty, minimumQty);
         	 click(Setupuldblock_BUTTON_Savebutton);
         	  Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("Maximum Quantity is less than Minimum Quantity"));
         	 enterKeys(Setupuldblock_Text_minimumQty, minimumQty);
        	 enterKeys(Setupuldblock_Text_maximumQty, maximumQty);
        	 enterKeys(Setupuldblock_Text_remarks, "test");
        	 click(Setupuldblock_BUTTON_Savebutton);
        	  switchToFirstWindow();
        	  waitForFrameAndSwitch(FRAME);
        
        	  
         	 return new ULD015(driver, dataFileName);

           }
        /**
         * 
         *
         * @return
         * Modification of values
         * @author A-6545
         */
        
        public ULD015 Setup_Modifyuld(String compCode,String uldType,String minimumQty,String maximumQty,String origin) {

        	compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
        	uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        	origin = PropertyHandler.getPropValue(dataFilePath, origin);
         	 list(compCode,origin);
         	 minWait();
         	check(Setupuldblock_chk_check);
     //     tblSelectRowByColValue(Setupuldblock_TABLE_fixed_header_table_0, 1, 11, "test");
            click(Setupuldblock_modifyLink);
          	waitForNewWindow(2);
            switchToSecondWindow();
        	 enterKeys(Setupuldblock_Text_minimumQty, maximumQty);
        	 enterKeys(Setupuldblock_Text_maximumQty, minimumQty);
         	 click(Setupuldblock_BUTTON_Savebutton);
         	  Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("Maximum Quantity is less than Minimum Quantity"));
         	 enterKeys(Setupuldblock_Text_minimumQty, minimumQty);
        	 enterKeys(Setupuldblock_Text_maximumQty, maximumQty);
        
        	 click(Setupuldblock_BUTTON_Savebutton);
        	  switchToFirstWindow();
        	  waitForFrameAndSwitch(FRAME);
        	
        	  
         	 return new ULD015(driver, dataFileName);

           }
        /**
         * Closes the screen and go to home screen
         *
         * @return
         * @author A-6545
         */
        public HomePage close() {

            click(Setupuldblock_BUTTON_Closebutton);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(btn_genericYes)) {

                click(btn_genericYes);
            }
            return new HomePage(driver, dataFileName);
        }      
    }
        