package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class OPR030 extends BasePage{
	public static String FRAME = "iCargoContentFrameOPR030";
    public static String screenFrame = "iCargoContentFrameOPR030";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    private By
    			txt_awb_pref,
    			txt_awb_no,
    			btn_list, 
    			tbl_exp_ship,
    			lbl_rsn_rfc,
    			btn_close,
    			yesBtn;
    
    public OPR030(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    private void initElements()
    {
    	txt_awb_pref= MiscUtility.getWebElement(objFilepath, "OPR030_txt_awbpref");
    	txt_awb_no=MiscUtility.getWebElement(objFilepath, "OPR030_txt_awbNo");
    	btn_list=MiscUtility.getWebElement(objFilepath, "OPR030_btn_list");
    	tbl_exp_ship=MiscUtility.getWebElement(objFilepath, "OPR030_tbl_expship");
    	lbl_rsn_rfc=MiscUtility.getWebElement(objFilepath, "OPR030_rsn_rfcmsg");
    	btn_close=MiscUtility.getWebElement(objFilepath, "OPR030_btn_close");
    	
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }
    
    
    public OPR030 verifyReadyforCarriageShipment(String awbPref, String awbNo)
    {
    	awbPref=PropertyHandler.getPropValue(dataFilePath, awbPref);
    	awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
    	String status;
    	enterKeys(txt_awb_pref, awbPref);
    	enterKeys(txt_awb_no, awbNo);
    	click(btn_list);
    	if(verifyElementPresent(tbl_exp_ship))
    	{
    		tblClickByColValue(tbl_exp_ship, 21);
    		Assert.assertTrue(waitForElement(lbl_rsn_rfc).getText().contains("Blocked for Screening"));
    		
    	}
    	return this;
    }
    
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
