package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen CRA81
 * Created on 12/03/2018
 *
 * @author a-6784
 */
public class CRA183 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA183";
    public static String screenFrame = "iCargoContentFrameCRA183";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
 
    
    By
    Generic_btn_ok,
    yesBtn,
   
    btn_list,btn_btnDelete,
    
    btn_close,info_msg,txt_rejectionMemoNo;
   
    
    public CRA183(WebDriver driver, String dataFileName) {
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
    	
    	
        txt_rejectionMemoNo= MiscUtility.getWebElement(objFilepath, "CRA183_txt_rejectionMemoNo");
        btn_list             = MiscUtility.getWebElement(objFilepath, "CRA183_btn_list");
        btn_btnDelete= MiscUtility.getWebElement(objFilepath, "CRA183_btn_btnDelete");
      
        btn_close            =  MiscUtility.getWebElement(objFilepath, "CRA183_btn_btnClose");
        
       Generic_btn_ok                           = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
       yesBtn                                   = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
       info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    }
    
   public CRA183 DeleteIssueRjectionMemo(String MemoNumbr){
 	
	 MemoNumbr=PropertyHandler.getPropValue(dataFilePath, MemoNumbr);
 	
 	
 	enterKeys(txt_rejectionMemoNo, MemoNumbr);
 	
 	click(btn_list);
 	minWait();
 	click(btn_btnDelete);
 	minWait();
 	driver.switchTo().defaultContent();
 	Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to Delete?"),"Error: Not able to delete the rejection memo");
 	click(yesBtn);
 	driver.switchTo().defaultContent();
 	Assert.assertTrue(waitForElement(info_msg).getText().contains("Rejection memo deleted successfully"),"Error: Not able to delete the rejection memo");
 	click(Generic_btn_ok);
	waitForFrameAndSwitch(FRAME); 
	
 	
 	 	return this;
 }
 
    
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFilePath);
    }

    
}
