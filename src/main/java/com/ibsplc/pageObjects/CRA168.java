package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * 
 * @author A-6836
 *
 */


public class CRA168 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA168";
    public static String screenFrame = "iCargoContentFrameCRA168";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By dropdown_clearingHouse,
    text_clearancePeriod,
    text_airlineCode, 
    btn_btnGenInvoice,
    yesBtn,
    btn_btnGenerate,
    radioBtn_exclude,
    info_error,
    btn_ok,
    btn_GenerateSupplBilling,
    txt_airlineNumber,
    lov_clearancePeriod,
    chkbx_selctPeriod,
    btn_closePeriodpopup,
    lov_airlineCode,
    chkbx_selctAirline,
    btn_closeAirlinepopup,
    lov_airlineNumbr,
    info_msg,
    menubar,
    MenuRevenueAccounting,
    revenueAcounting_SIS,
    SIS_outwardBilling,
    OutwardBilling_billingGeneration,

    btn_btnClose;
   
    public CRA168(WebDriver driver, String dataFileName) {
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

    	dropdown_clearingHouse= MiscUtility.getWebElement(objFilepath, "CRA168_dropdown_clearingHouse");
    	text_clearancePeriod= MiscUtility.getWebElement(objFilepath, "CRA168_text_clearancePeriod");
    	text_airlineCode= MiscUtility.getWebElement(objFilepath, "CRA168_text_airlineCode");
    	btn_btnGenInvoice= MiscUtility.getWebElement(objFilepath, "CRA168_btn_btnGenInvoice");
        btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA168_btn_btnClose");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        radioBtn_exclude=MiscUtility.getWebElement(objFilepath, "CRA168_radioBtn_exclude");
        info_error=MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        btn_GenerateSupplBilling=MiscUtility.getWebElement(objFilepath, "CRA168_btn_GenerateSupplBilling");
        txt_airlineNumber=MiscUtility.getWebElement(objFilepath, "CRA168_txt_airlineNumber");
        lov_clearancePeriod=MiscUtility.getWebElement(objFilepath, "CRA168_lov_clearancePeriod");
        chkbx_selctPeriod=MiscUtility.getWebElement(objFilepath, "CRA168_chkbx_selctPeriod");
        btn_closePeriodpopup=MiscUtility.getWebElement(objFilepath, "CRA168_btn_closePeriodpopup");
        lov_airlineCode=MiscUtility.getWebElement(objFilepath, "CRA168_lov_airlineCode");
        chkbx_selctAirline=MiscUtility.getWebElement(objFilepath, "CRA168_chkbx_selctAirline");
        btn_closeAirlinepopup=MiscUtility.getWebElement(objFilepath, "CRA168_btn_closeAirlinepopup");
        lov_airlineNumbr=MiscUtility.getWebElement(objFilepath, "CRA168_lov_airlineNumbr");
        menubar=MiscUtility.getWebElement(objFilepath, "homeScreen_menubar");
        MenuRevenueAccounting=MiscUtility.getWebElement(objFilepath, "homescreen_MenuRevenueAccounting");
        revenueAcounting_SIS=MiscUtility.getWebElement(objFilepath, "homescreen_revenueAcounting_SIS");
        SIS_outwardBilling=MiscUtility.getWebElement(objFilepath, "homescreen_SIS_outwardBilling");
        OutwardBilling_billingGeneration=MiscUtility.getWebElement(objFilepath, "homeScreen_OutwardBilling_billingGeneration");
        info_msg=MiscUtility.getWebElement(genObjPath, "Generic_info_msg");


        
    }
    
    public CRA168 menubarNavigation(){
    	
    	click(menubar);
    	minWait();
    	click(MenuRevenueAccounting);
    	click(revenueAcounting_SIS);
    	
    	click(SIS_outwardBilling);
    	minWait();
    	
    	Assert.assertTrue(verifyElementPresent(btn_GenerateSupplBilling));
		return this;
    	
    	
    }
    
    /**
     * 
     * @return
     */
    public CRA168 verify_AirlineLov(){
    	
    	click(lov_airlineCode);
    	
    	 driver.switchTo().defaultContent();
    	 
    	 waitForNewWindow(2);
    	 switchToSecondWindow();
    	 
    	 check(chkbx_selctAirline);
    	 click(btn_closeAirlinepopup);
    	 
    	 switchToFirstWindow();
    	 waitForFrameAndSwitch(FRAME);
    	 
    	 Assert.assertTrue(waitForElement(lov_airlineNumbr).isEnabled());
		return this;
    	
    }
    /**
     * 
     * @param clearingHouse
     * @param clearancePeriod
     * @param airlineCode
     * @return
     */
    public CRA168 generateInvoice_Exclude(String clearingHouse, String clearancePeriod,String airlineCode){

    	clearingHouse = PropertyHandler.getPropValue(dataFilePath, clearingHouse);
    	clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
    
    	airlineCode = PropertyHandler.getPropValue(dataFilePath, airlineCode);

     
        
        selectByValue(dropdown_clearingHouse, clearingHouse);
        
        enterKeys(text_clearancePeriod, clearancePeriod);
        enterKeys(text_airlineCode, airlineCode);
        click(radioBtn_exclude);
        click(btn_btnGenInvoice);
                minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        } 
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_ok)) {

            click(btn_ok);
        }
        minWait();
     //   driver.switchTo().defaultContent();
        waitForFrameAndSwitch(FRAME);
        return this;
    }
    
    public CRA168 errorVerification(){
    	
    	
    	click(btn_btnGenInvoice);
    	
    	driver.switchTo().defaultContent();
    	
    	Assert.assertTrue(waitForElement(info_msg).getText().contains("Please enter Clearance Period"));
    	click(btn_ok);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	enterKeys(text_clearancePeriod, "1234");
    	click(btn_btnGenInvoice);
       Assert.assertTrue(waitForElement(info_error).getText().contains("Entered Clearance Period is invalid"));
		return this;
    	
    }
    /**
     * 
     * @param clearingHouse
     * @param clearancePeriod
     * @return
     */
    public CRA168 generateInvoiceWithoutAirline(String clearingHouse, String clearancePeriod){
    	
    	clearingHouse = PropertyHandler.getPropValue(dataFilePath, clearingHouse);
    	clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
    	
        selectByValue(dropdown_clearingHouse, clearingHouse);
        
        enterKeys(text_clearancePeriod, clearancePeriod);
        click(btn_btnGenInvoice);
        minWait();
     driver.switchTo().defaultContent();
      if (verifyElementPresent(yesBtn)) {

     click(yesBtn);
        } 
       minWait();
        driver.switchTo().defaultContent();
     if (verifyElementPresent(btn_ok)) {
     Assert.assertTrue(waitForElement(info_msg).getText().contains("Request sent for invoice generation in progress. Please check the status in invoice status log screen- CRA 207"));
     click(btn_ok);
      }
        minWait();
     driver.switchTo().defaultContent();

        return this;
    	
    }
/***
 * 
 * @param shipper
 * @param fromdate
 * @param billingfreq
 * @return
 */
    public CRA168 GenerateInvoice(String clearingHouse, String clearancePeriod,String airlineCode){

    	clearingHouse = PropertyHandler.getPropValue(dataFilePath, clearingHouse);
    	clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
    
    	airlineCode = PropertyHandler.getPropValue(dataFilePath, airlineCode);

     
        
        selectByText(dropdown_clearingHouse, clearingHouse);
        
        enterKeys(text_clearancePeriod, clearancePeriod);
        enterKeys(text_airlineCode, airlineCode);
        click(btn_btnGenInvoice);
                minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        } 
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_ok)) {

            click(btn_ok);
        }
        minWait();
      //  driver.switchTo().defaultContent();
   waitForFrameAndSwitch(FRAME);
        return this;
    }
    
    
    public CRA168 UI_verification(){
    	
    	Assert.assertTrue(verifyElementPresent(btn_btnGenInvoice));
    	
    	Assert.assertTrue(verifyElementPresent(btn_GenerateSupplBilling));
    	Assert.assertTrue(verifyElementPresent(txt_airlineNumber));
    	Assert.assertTrue(verifyElementPresent(txt_airlineNumber));
    	Assert.assertTrue(verifyElementPresent(dropdown_clearingHouse));
    	Assert.assertTrue(verifyElementPresent(text_airlineCode));
    	Assert.assertTrue(verifyElementPresent(btn_btnClose));
    	
    	
    	
    	return this;
    	
    }
    /***
     * 
     * @return
     */
    public CRA168 verify_clearinghouseField(){
    	
    	Assert.assertTrue(waitForElement(dropdown_clearingHouse).getText().contains("ICH"),"Error: Value not present");
    	Assert.assertTrue(waitForElement(dropdown_clearingHouse).getText().contains("ACH"),"Error: Value not present");
    	Assert.assertTrue(waitForElement(dropdown_clearingHouse).getText().contains("Non-ICH"),"Error: Value not present");
		
    	 click(lov_clearancePeriod);
    	 driver.switchTo().defaultContent();
    	 
    	 waitForNewWindow(2);
    	 switchToSecondWindow();
    	 
    	 check(chkbx_selctPeriod);
    	 click(btn_closePeriodpopup);
    	 
    	 switchToFirstWindow();
    	 waitForFrameAndSwitch(FRAME);
    	 
    	 
    	 
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
}
