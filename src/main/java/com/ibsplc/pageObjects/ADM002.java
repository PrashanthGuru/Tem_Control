/**
 * 
 */
package com.ibsplc.pageObjects;

/**
 * @author A-8254 on 19/3/2018.
 *
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class ADM002 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
    private static String FRAME = "iCargoContentFrameADM002";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By 
  
    btn_genericYes,
    btn_Close,
    select_privilageCode,
    txt_privilageCode,
    btn_listNewWindow,
    checkbox_result,
    btn_OK_NewWindow,
    btn_list,
    table_privilageDetails;
    
    
    public ADM002(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

    	
    	btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btn_Close = MiscUtility.getWebElement(objFilepath, "ADM002_btn_Close");
    	select_privilageCode = MiscUtility.getWebElement(objFilepath, "ADM002_select_privilageCode");
    	txt_privilageCode = MiscUtility.getWebElement(objFilepath, "ADM002_txt_privilageCode");
    	btn_listNewWindow = MiscUtility.getWebElement(objFilepath, "ADM002_btn_listNewWindow");
    	checkbox_result = MiscUtility.getWebElement(objFilepath, "ADM002_checkbox_result");
    	btn_OK_NewWindow = MiscUtility.getWebElement(objFilepath, "ADM002_btn_OK_NewWindow");
    	btn_list = MiscUtility.getWebElement(objFilepath, "ADM002_btn_list");
    	table_privilageDetails = MiscUtility.getWebElement(objFilepath, "ADM002_table_privilageDetails");
    	
    }
    
   
    
    public HomePage close() {
    	
    	        click(btn_Close);
    	        driver.switchTo().defaultContent();
    	        if (verifyElementPresent(btn_genericYes)) {
    	
    	            click(btn_genericYes);
    	        }
    	        return new HomePage(driver, dataFileName);
    	    }
    	   
    
    
    public ADM002 verifyPrivilagCodeIsPresent(String privilegeCode)
    {
		
    	click(select_privilageCode);
        waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(txt_privilageCode, privilegeCode);
    	click(btn_listNewWindow);
    	click(checkbox_result);
    	click(btn_OK_NewWindow);
    	switchToFirstWindow();
     waitForFrameAndSwitch(FRAME);
    	click(btn_list);
    	boolean flag = false;
   	 List<String> values = getTableColumnValues(table_privilageDetails,2);
   	    for(String value : values){
   	    	//value=value.trim();
   	        if (value.equalsIgnoreCase(privilegeCode))
   	        {
   	            flag = true;
   	            break;
   	        }
   	      
   	    }
   	    Assert.assertTrue(flag,"The privilege not present for this user,need that privilage to check this teat case");
    	
    	
    	
    	
    	return this;
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }

   
     

