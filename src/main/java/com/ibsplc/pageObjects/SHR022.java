package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class SHR022 extends BasePage{
	

	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");

    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    private WebDriver driver;
    private String dataFileName; 
    
    private By txt_messageType,
    btn_list,
    tbl_msgtable,
    btn_save,
    btn_close,
    btn_genericYes;
    
    public SHR022(WebDriver driver,String dataFileName){
    	super(driver);
    	this.driver = driver;
    	initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    
    
    private void initElements(){
    	txt_messageType = MiscUtility.getWebElement(objFilepath, "SHR022_txt_messageType");
    	btn_list = MiscUtility.getWebElement(objFilepath, "SHR022_btn_list");
    	tbl_msgtable = MiscUtility.getWebElement(objFilepath, "SHR022_tbl_msgtable");
    	btn_save = MiscUtility.getWebElement(objFilepath, "SHR022_btn_save");
    	btn_close = MiscUtility.getWebElement(objFilepath, "SHR022_btn_close");
    	 btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }
    
    
    public SHR022 checkFWRMessage(String messageType)
    {
    	messageType = PropertyHandler.getPropValue(dataFilePath, messageType);
    	
    	enterKeys(txt_messageType,messageType);
    	click(btn_list);
    	
    	tblSelectRowByColValue(tbl_msgtable, 1, 3, "FWR");
    	click(btn_save);
    	
    	click(btn_close);
    	
    	
    	return this;
    }
    
    
    public HomePage close() {


        click(btn_close);
        
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}
