package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/***
 * 
 * @author A-6784
 *
 */
public class OPR059 extends BasePage {


    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameOPR059";
    public String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public String dataFileName;
    public String filepath;
    String testDataFile;
    WebDriver driver;
    
    String browser;
    
    By
    
    txt_AWB,
    txt_AWBPrefix,
    btn_List,
    info_NotificationRemarks,
    btn_close,
    
    btn_genericYes;
    
    public OPR059(WebDriver driver, String testDataFile) {
    	super(driver);
        this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver, this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + testDataFile;
        initPageElements();
    }

    /**
     * Method to initialize page objects
     *
     *  @author A-6784
     */
    private void initPageElements() {

        System.out.println("Going to capture all webElements..!");

        txt_AWB = MiscUtility.getWebElement(objFilepath, "OPR059_txt_AWB");
        txt_AWBPrefix = MiscUtility.getWebElement(objFilepath, "OPR059_txt_AWBPrefix");
        btn_List = MiscUtility.getWebElement(objFilepath, "OPR059_btn_List");
        info_NotificationRemarks = MiscUtility.getWebElement(objFilepath, "OPR059_info_NotificationRemarks");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR059_btn_close");
        btn_genericYes=MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");

        
	
	
    }
    
    public OPR059 verifyNotification(String AWBPrefix,String AWBNo){
    	  

        AWBPrefix=PropertyHandler.getPropValue(filepath, AWBPrefix);
    	AWBNo=PropertyHandler.getPropValue(filepath, AWBNo);
    	
    	enterKeys(txt_AWBPrefix, AWBPrefix);
    	enterKeys(txt_AWB, AWBNo);
    	click(btn_List);
    	maxWait();
    	
    	System.out.println("test verify "+waitForElement(info_NotificationRemarks).getAttribute("value"));
    	Assert.assertTrue(waitForElement(info_NotificationRemarks).getAttribute("value").contains("Notification Remarks"));
    	
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
