package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen: Maintain Aircraft Type SHR003
 * 
 * @author a-7868 Krishna <01/02/2018>
 *
 */
public class SHR003 extends BasePage{

	public static String FRAME = "iCargoContentFrameSHR003";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    WebDriver driver;
    String screenFrame;
    String dataFileName;
        
    By
    txt_aircraftType,
    btn_list,
    btn_clear,
    link_uldConfig_add,
    txt_addUldConfig_configName,
    link_addUldConfig_add,
    txt_addUldConfig_unit,
    txt_addUldConfig_num,
    btn_addUldConfig_btnOk,
    btn_save,
    btn_close,
    tbl_uldConfig,
    capacityParameter_txt_wt,
    capacityParameter_txt_vol,
    msg_success,
    info_msgClose,
    yesBtn,
    btn_exceptions,
    txt_exceptions_fromDt,
    txt_exceptions_toDt,
    btn_exceptions_list,
    info_error;
    
    
    public SHR003(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initPageElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    
    /**
     * Method to initialize page objects
     */
    private void initPageElements(){	
    	
    	txt_aircraftType            = MiscUtility.getWebElement(objFilepath, "SHR003_txt_aircraftType");
    	btn_list                    = MiscUtility.getWebElement(objFilepath, "SHR003_btn_list"); 
    	btn_clear           		= MiscUtility.getWebElement(objFilepath, "SHR003_btn_clear");
    	link_uldConfig_add          = MiscUtility.getWebElement(objFilepath, "SHR003_link_uldConfig_add");
    	txt_addUldConfig_configName = MiscUtility.getWebElement(objFilepath, "SHR003_txt_addUldConfig_configName");
    	link_addUldConfig_add       = MiscUtility.getWebElement(objFilepath, "SHR003_link_addUldConfig_add");
    	txt_addUldConfig_unit		= MiscUtility.getWebElement(objFilepath, "SHR003_txt_addUldConfig_unit");
    	txt_addUldConfig_num   		= MiscUtility.getWebElement(objFilepath, "SHR003_txt_addUldConfig_num");
    	btn_addUldConfig_btnOk 		= MiscUtility.getWebElement(objFilepath, "SHR003_btn_addUldConfig_btnOk");
    	btn_save           			= MiscUtility.getWebElement(objFilepath, "SHR003_btn_save");
    	btn_close           		= MiscUtility.getWebElement(objFilepath, "SHR003_btn_close");
    	tbl_uldConfig           	= MiscUtility.getWebElement(objFilepath, "SHR003_tbl_uldConfig");
    	capacityParameter_txt_wt	= MiscUtility.getWebElement(objFilepath, "SHR003_capacityParameter_txt_wt");
    	capacityParameter_txt_vol	= MiscUtility.getWebElement(objFilepath, "SHR003_capacityParameter_txt_vol");
    	btn_exceptions 		= MiscUtility.getWebElement(objFilepath, "SHR003_btn_exceptions");
    	txt_exceptions_fromDt= MiscUtility.getWebElement(objFilepath, "SHR003_txt_exceptions_fromDt");
    	txt_exceptions_toDt 	= MiscUtility.getWebElement(objFilepath, "SHR003_txt_exceptions_toDt");
    	btn_exceptions_list 	= MiscUtility.getWebElement(objFilepath, "SHR003_btn_exceptions_list");

	    yesBtn			            = MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
	    info_msgClose 				= MiscUtility.getWebElement(genObjPath, "Generic_info_close");
	    msg_success 				= MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
	    info_error					= MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    }
    
    public SHR003 addULDConfig(String aircraftType, String ULDConfigName, String ULDUnit, int noOfUnits){
    	
    	aircraftType = PropertyHandler.getPropValue(dataFilePath, aircraftType);
    	ULDConfigName = PropertyHandler.getPropValue(dataFilePath, ULDConfigName);
    	ULDUnit = PropertyHandler.getPropValue(dataFilePath, ULDUnit);
 
    	enterKeys(txt_aircraftType, aircraftType);
    	click(btn_list);
    	minWait();
    	
    	scrollToView(tbl_uldConfig);
    	
    	click(link_uldConfig_add);
    	minWait();
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();
        
        int x = (int)(Math.random()*(100));
        String randStr = String.valueOf(x);
        ULDConfigName += randStr;
        
        enterKeys(txt_addUldConfig_configName, ULDConfigName);
        click(link_addUldConfig_add);
        minWait();
        enterKeys(txt_addUldConfig_unit, ULDUnit);
        enterKeys(txt_addUldConfig_num, String.valueOf(noOfUnits));
        click(btn_addUldConfig_btnOk);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        
        minWait();
        click(btn_save);
        driver.switchTo().defaultContent();
        minWait();
        Assert.assertTrue(waitForElement(msg_success).getText().contains("The data has been successfully saved."), "ERROR : SAVED SUCCESSFULLY message not displayed");

        waitForFrameAndSwitch(FRAME);
        //click(info_msgClose);
        minWait();
    	return this;
    }
    
    /**
     * Method to list an aircraft type and change the Capacity Wt and Vol
     * @param aircraftType
     * @param wt
     * @param vol
     * @param priorWt
     * @param priorVol
     * @return
     * @author A-7868 Krishna <30/05/2018>
     */
    public SHR003 changeCapacityDetails(String aircraftType, String wt, String vol, String priorWt, String priorVol){
    	
    	aircraftType = PropertyHandler.getPropValue(dataFilePath, aircraftType);
    	vol = PropertyHandler.getPropValue(dataFilePath, vol);
    	wt = PropertyHandler.getPropValue(dataFilePath, wt);
    	
    	enterKeys(txt_aircraftType, aircraftType);
    	click(btn_list);
    	minWait();
    	
    	String pWt = waitForElement(capacityParameter_txt_wt).getAttribute("value").trim();
    	String pVol = waitForElement(capacityParameter_txt_vol).getAttribute("value").trim();
    	PropertyHandler.setPropValue(dataFilePath, priorWt, pWt);
    	PropertyHandler.setPropValue(dataFilePath, priorVol, pVol);
    	
    	enterKeys(capacityParameter_txt_wt, wt);
    	enterKeys(capacityParameter_txt_vol, vol);
    	click(btn_save);
    	minWait();
    	driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(msg_success).getText().contains("The data has been successfully saved."), "ERROR : SAVED SUCCESSFULLY message not displayed");
        waitForFrameAndSwitch(FRAME);
    	
        return this;
    }
    
    /**
     * Method to check the error message when the fromDate is greater than toDate in Exception popup
     * @param aircraftType
     * @return
     * @author a-7868 Krishna <19/07/2018>
     */
    public SHR003 checkDateValidationInExceptionPopup(String aircraftType){
    	
    	aircraftType = PropertyHandler.getPropValue(dataFilePath, aircraftType);
    	
    	enterKeys(txt_aircraftType, aircraftType);
    	click(btn_list);
    	minWait();
    	
    	click(btn_exceptions);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(txt_exceptions_fromDt, "+1");
    	enterKeys(txt_exceptions_toDt, ".");
    	click(btn_exceptions_list);
    	minWait();
    	Assert.assertTrue(waitForElement(info_error).getText().contains("Start Date cannot be greater than End Date"), "ERROR: Error message mismatch");
    	return this;
    }
    
    /**
     * Method to close current page and return to Homepae
     * returns the instance of Homepage
     *
     * @return
     * @author a-7868
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
    

}
