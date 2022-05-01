package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
/***
 * 
 * @author A-6784
 *
 */
public class CRA088 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA088";
    public static String screenFrame = "iCargoContentFrameCRA088";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    
    By
    
    btn_diaYes,
    dropdown_process,
    Txt_clearancePeriod,
    btn_execute,
    Generic_btn_ok,
    btn_close;

    
    public CRA088(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
   
    /**
     * Initializes the page objects required for the class
     */
    private void initElements() {
    	
    	
    	dropdown_process    = MiscUtility.getWebElement(objFilepath, "CRA088_dropdown_process");
    	Txt_clearancePeriod = MiscUtility.getWebElement(objFilepath, "CRA088_Txt_clearancePeriod");
    	btn_execute         = MiscUtility.getWebElement(objFilepath, "CRA088_btn_execute");
    	btn_close           = MiscUtility.getWebElement(objFilepath, "CRA088_btn_close");
 //   	btn_diaYes          = MiscUtility.getWebElement(objFilepath, "Generic_btn_diaYes");
//    	Generic_btn_ok      = MiscUtility.getWebElement(objFilepath, "Generic_btn_ok");

    }
    
    /**
     * 
     * @param fileType
     * @param clearancePeriod
     * @return
     */
    public CRA088 finalizeFile(String fileType,String clearancePeriod){
    	
    	fileType=PropertyHandler.getPropValue(dataFilePath, fileType);
    	clearancePeriod=PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
    	
    	selectByText(dropdown_process, fileType);
    	enterKeys(Txt_clearancePeriod, clearancePeriod);
    	click(btn_execute);
    	driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_diaYes)) {

            click(btn_diaYes);
        }
        waitForFrameAndSwitch(FRAME);
    	
        driver.switchTo().defaultContent();
        click(Generic_btn_ok);
        waitForFrameAndSwitch(FRAME);
        
    	return this;
    }
    
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_diaYes)) {

            click(btn_diaYes);
        }
        return new HomePage(driver, dataFileName);
    }

}
