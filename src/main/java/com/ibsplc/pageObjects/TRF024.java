package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class TRF024 extends BasePage {

    private static String objFilepath         = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    private static String genObjPath          = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private String dataFilePath               = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    public static String FRAME = "iCargoContentFrameTRF024";
    private String screenFrame;
    private String dataFileName;
    private WebDriver driver;
    
    private By btn_genericYes,
	info_msg,
	btn_noBtn;
    By
    txt_ChargeHeadCode,
    btn_List,
    txt_ChargeHeadName,
    txt_StartDate,
    txt_EndDate,
    txt_Currency,
    btn_Save,
    txt_PercentageVal,
    txt_ParameterValue,
    Chkbx_AppliedOn,
    btn_Close;

    
    
    public TRF024(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    private void initElements() {

        screenFrame = "iCargoContentFrameTRF024";
        
        txt_ChargeHeadCode            = MiscUtility.getWebElement(objFilepath, "TRF024_txt_ChargeHeadCode");
        btn_List                      = MiscUtility.getWebElement(objFilepath, "TRF024_btn_List");
        txt_ChargeHeadName            = MiscUtility.getWebElement(objFilepath, "TRF024_txt_ChargeHeadName");
        txt_StartDate                 = MiscUtility.getWebElement(objFilepath, "TRF024_txt_StartDate");
        txt_EndDate                   = MiscUtility.getWebElement(objFilepath, "TRF024_txt_EndDate");
        txt_Currency                  = MiscUtility.getWebElement(objFilepath, "TRF024_txt_Currency");
        btn_Save                      = MiscUtility.getWebElement(objFilepath, "TRF024_btn_Save");
        txt_PercentageVal             = MiscUtility.getWebElement(objFilepath, "TRF024_txt_PercentageVal");
        txt_ParameterValue            = MiscUtility.getWebElement(objFilepath, "TRF024_txt_ParameterValue");
        Chkbx_AppliedOn               = MiscUtility.getWebElement(objFilepath, "TRF024_Chkbx_AppliedOn");
        btn_Close                     = MiscUtility.getWebElement(objFilepath, "TRF024_btn_Close");
        info_msg		              = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericYes                = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_noBtn                     = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
    }
    
    public TRF024 maintainChargeHead(String ChargeHead,boolean isMaintain){
    	
    	
    	String rand =/* RandomStringUtils.randomAlphabetic(2)*/"";
    	
    	enterKeys(txt_ChargeHeadCode, rand);
    	click(btn_List);
    	minWait();
    	 driver.switchTo().defaultContent();
    	 System.out.println(waitForElement(info_msg).getText());
    	Assert.assertTrue(waitForElement(info_msg).getText().contains("Specified Chargehead not exists in the system. Do you want to create ratelines for the chargehead?"));
    	if(isMaintain){
    		
    		click(btn_genericYes);
    		minWait();
    		PropertyHandler.setPropValue(dataFilePath, ChargeHead, rand);
    		waitForFrameAndSwitch(FRAME);
    		minWait();
    		enterKeys(txt_ChargeHeadName, "Test Automation");
    		enterKeys(txt_StartDate, ".");
    		enterKeys(txt_EndDate, ".");
    		enterKeys(txt_Currency, "INR");
    		enterKeys(txt_PercentageVal, "10");
    		check(Chkbx_AppliedOn);
    		click(btn_Save);
    		minWait();
    		enterKeys(txt_ChargeHeadCode, rand);
        	click(btn_List);
        	waitForElement(txt_ChargeHeadName).getAttribute("value").equals("Test Automation");
        	
    		
    		}
    	else{
    		click(btn_noBtn);
    		minWait();
    		waitForFrameAndSwitch(FRAME);
    		Assert.assertTrue(waitForElement(txt_ChargeHeadCode).getAttribute("value").equals(""));
    		
            
    		
    	}
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
    
}
