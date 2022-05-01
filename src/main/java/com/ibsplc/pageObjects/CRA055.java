package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CRA055 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA055";
   
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    By
    
    
    txt_prefix,
    txt_AWBNo,
    btn_list,
    info_creditValue,
    btn_btnClose,
    yesBtn,
    info_DebitValue;
    
    private By label_flown;

    
    public CRA055(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }


    private void initElements() {
    	
    	
    	txt_prefix=MiscUtility.getWebElement(objFilepath, "CRA055_txt_prefix");
        txt_AWBNo=MiscUtility.getWebElement(objFilepath, "CRA055_txt_AWBNo");
        btn_list=MiscUtility.getWebElement(objFilepath, "CRA055_btn_list");
        info_DebitValue=MiscUtility.getWebElement(objFilepath, "CRA055_info_DebitValue");
        info_creditValue=MiscUtility.getWebElement(objFilepath, "CRA055_info_creditValue");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA055_btn_btnClose");
    }
    
    /***
     * verify whether debit equals credit
     * @param awbprefix
     * @param AWBNo
     * @return
     *A-6784**/
    public CRA055 verifyAccount(String awbprefix,String AWBNo){
    	
    	awbprefix=PropertyHandler.getPropValue(dataFilePath, awbprefix);
    	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	
    	
    	
    	enterKeys(txt_prefix, awbprefix);
    	enterKeys(txt_AWBNo, AWBNo);
    	click(btn_list);
    	minWait();
    	String debitvalue=waitForElement(info_DebitValue).getText();
    	String creditvalue=waitForElement(info_creditValue).getText();
    	
    	Assert.assertTrue(debitvalue.equals(creditvalue));
		return this;
    	
    	
    	
    }
    
    public CRA055 validateFuntionalPoint(String awbPref, String awb)
    {
    	awbPref=PropertyHandler.getPropValue(dataFilePath, awbPref);
    	awb=PropertyHandler.getPropValue(dataFilePath, awb);
    	
    	enterKeys(txt_prefix, awbPref);
    	enterKeys(txt_AWBNo, awb);
    	click(btn_list);
    	
    	String functionPoint=waitForElement(info_DebitValue).getText();
    	Assert.assertTrue(functionPoint.contains("flown"),"function point should be FLOWN!");
    	
    	return this;
    }
    
    
    public HomePage close() {

        click(btn_btnClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
    
    
public CRA055 verifyAccount(){
    
    	String debitvalue=waitForElement(info_DebitValue).getText();
    	String creditvalue=waitForElement(info_creditValue).getText();
    	
    	Assert.assertTrue(debitvalue.equals(creditvalue));
		return this;
    	
    	
    	
    }
      
    
public CRA170 closeToCRA170() {

    click(btn_btnClose);
    return new CRA170(driver, dataFileName);
}  
    
    
    
    
    
    
    
    
    
    
    
}
