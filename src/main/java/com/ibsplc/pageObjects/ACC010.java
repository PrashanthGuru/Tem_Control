package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author A-8254 .
 */

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-8254 
 */
public class ACC010 extends BasePage {

    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "QMS_ACC.properties");
    private static String FRAME = "iCargoContentFrameACC010";
    private static boolean delReq = false;
    private static boolean addReq = false;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By 
    btn_print,
    btn_Close,
    btn_genericYes;
    

    public ACC010(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

    	btn_print = MiscUtility.getWebElement(objFilepath, "ACC010_btn_print");    
    	btn_Close = MiscUtility.getWebElement(objFilepath, "ACC010_btn_Close");
    	btn_genericYes=MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        
    }
    
    
    public ACC010 printList()
    {
 	   
    	minWait();
   
 	Assert.assertTrue(waitForElement(btn_print).isEnabled(),"print button is enabled and present");
 	click(btn_print);
 	waitForNewWindow(2);
 	switchToSecondWindow();
     closeAndmoveToFirstWindow();
     waitForFrameAndSwitch(FRAME);
 	return this;  
    }  
  
    
   
    
    

    

    public HomePage close() {

        click(btn_Close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
    
    
    public ACC008 closeToACC008() {

        click(btn_Close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new ACC008(driver, dataFileName);
    }  
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
