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


public class CRA188 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA188";
    public static String screenFrame = "iCargoContentFrameCRA188";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By dropdown_classType,
	txt_clearancePeriod,
	btn_btnGenerate,
    yesBtn,btn_btnView,ViewBillingBtn_btnClose,
    info_error,ViewBillingBtn_btnWithdraw,
    chkbx_newInvoicesOnly,
    txt_fileName,
    chkbx_selectIsFile,
    btn_fileNameLov,btn_ISFile,
    btn_fileNamePopupOK,

    btn_ok,
    btn_btnClose,
    lov_clearancePeriod,
    
    //second window clearance period
    txt_clearancePeriod_newWindow,
    btn_list_newWindow,
    checkbox_clearancePeriod_newWindow,
    btn_ok_newWindow,
    
    
    
    btn_clear,
    lov_fileName,
    txt_clearancePeriod_newWindow_filename_LOV,
    btn_list_newWindow_filename_LOV,
    btn_ok_newWindow_filename_LOV,
    info_genericMsg;
    
    
    
    public CRA188(WebDriver driver, String dataFileName) {
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
    	
    	
    	dropdown_classType= MiscUtility.getWebElement(objFilepath,"CRA188_dropdown_classType");
    	txt_clearancePeriod= MiscUtility.getWebElement(objFilepath, "CRA188_txt_clearancePeriod");
    	btn_btnGenerate= MiscUtility.getWebElement(objFilepath, "CRA188_btn_btnGenerate");
    	btn_ISFile= MiscUtility.getWebElement(objFilepath, "CRA188_btn_ISFile");
    	btn_btnClose= MiscUtility.getWebElement(objFilepath, "CRA188_btn_close");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        
        info_error=MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        chkbx_newInvoicesOnly=MiscUtility.getWebElement(objFilepath, "CRA188_chkbx_newInvoicesOnly");
        txt_fileName=MiscUtility.getWebElement(objFilepath, "CRA188_txt_fileName");
        chkbx_selectIsFile=MiscUtility.getWebElement(objFilepath, "CRA188_chkbx_selectIsFile");
        btn_fileNameLov=MiscUtility.getWebElement(objFilepath, "CRA188_chkbx_selectIsFile");
        btn_fileNamePopupOK=MiscUtility.getWebElement(objFilepath, "CRA188_btn_fileNamePopupOK");
        lov_clearancePeriod=MiscUtility.getWebElement(objFilepath, "CRA188_lov_clearancePeriod");
        txt_clearancePeriod_newWindow=MiscUtility.getWebElement(objFilepath, "CRA188_txt_clearancePeriod_newWindow");
        btn_list_newWindow=MiscUtility.getWebElement(objFilepath, "CRA188_btn_list_newWindow");
        checkbox_clearancePeriod_newWindow=MiscUtility.getWebElement(objFilepath, "CRA188_checkbox_clearancePeriod_newWindow");
        btn_ok_newWindow=MiscUtility.getWebElement(objFilepath, "CRA188_btn_ok_newWindow");
        btn_clear=MiscUtility.getWebElement(objFilepath, "CRA188_btn_clear");
        lov_fileName=MiscUtility.getWebElement(objFilepath, "CRA188_lov_fileName");
        txt_clearancePeriod_newWindow_filename_LOV=MiscUtility.getWebElement(objFilepath, "CRA188_txt_clearancePeriod_newWindow_filename_LOV");
        btn_list_newWindow_filename_LOV=MiscUtility.getWebElement(objFilepath, "CRA188_btn_list_newWindow_filename_LOV");
        btn_ok_newWindow_filename_LOV=MiscUtility.getWebElement(objFilepath, "CRA188_btn_ok_newWindow_filename_LOV");
        info_genericMsg=MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    }
    
    /***
     * 
     * @param clearancePeriod
     * @return
     */
   public CRA188 generateIsFile_AlreadyGenerated(){
    
    	
        selectByValue(dropdown_classType, "Cargo");
        
        click(btn_fileNameLov);
        minWait();
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        
        check(chkbx_selectIsFile);
        
        click(btn_fileNamePopupOK);
        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        
        click(btn_btnGenerate);
        minWait();
        click(btn_ok);
		
       
   
        return this;
    }
    /****
     * 
     * @param clearancePeriod
     * @return
     */
    public CRA188 generateIsFile_includeNew(String clearancePeriod){
    	
clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
    
    	
       // selectByValue(dropdown_classType, "Cargo");
        enterKeys(txt_clearancePeriod, clearancePeriod);
        
        check(chkbx_newInvoicesOnly);
        
        while(true)
        {

        click(btn_btnGenerate);
        
       minWait();
        
      if(waitForElement(btn_ISFile).isDisplayed())
      {
    	  break;
      }
        minWait();
        }
        click(btn_ISFile);
     
        minWait();
        driver.switchTo().defaultContent();
        click(yesBtn);
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        click(btn_ok);
        

        waitForFrameAndSwitch(FRAME);
        return this;
    }
/***
 * 
 * @param shipper
 * @param fromdate
 * @param billingfreq
 * @return
 */
    public CRA188 GenerateISfile(String clearancePeriod){

    	
    	clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
    
    	
       // selectByValue(dropdown_classType, "Cargo");
        enterKeys(txt_clearancePeriod, clearancePeriod);
        while(true)
        {

        click(btn_btnGenerate);
        
       minWait();
        
      if(waitForElement(btn_ISFile).isDisplayed())
      {
    	  break;
      }
        minWait();
        }
      //waitForElement(btn_ISFile).click();
     click(btn_ISFile);
        minWait();
        driver.switchTo().defaultContent();
        click(yesBtn);
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        click(btn_ok);
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
        
        
        
        
        
        public CRA188 verifyDropDownClass(){
        	
        	selectByText(dropdown_classType,"Cargo");	
        	selectByText(dropdown_classType, "Miscellaneous-All");
        	selectByText(dropdown_classType, "Miscellaneous-Mail");
        	selectByText(dropdown_classType, "Miscellaneous-Others");
        	selectByText(dropdown_classType, "Miscellaneous-ULD");
        
        	return this;
        }
        
        
 public CRA188 verifyClearancePeriod(String clearancePeriod){
        	
        
	 
	 
	 clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
	 verifyElementPresent(txt_clearancePeriod);
        verifyElementPresent(lov_clearancePeriod);
        enterKeys(txt_clearancePeriod,"180502");
        click(lov_clearancePeriod);
   	waitForNewWindow(2);
   	switchToSecondWindow();
    enterKeys(txt_clearancePeriod_newWindow,clearancePeriod);
    click(btn_list_newWindow);
    check(checkbox_clearancePeriod_newWindow);
    click(btn_ok_newWindow);
    switchToFirstWindow();
	waitForFrameAndSwitch(FRAME);   

   return this;
        }     
        
        
        
 public CRA188 verifyClearButton(){
 	
	 enterKeys(txt_clearancePeriod,"180503");
	 enterKeys(txt_fileName,"180503");
	 check(chkbx_newInvoicesOnly);
	 click(btn_clear);
	 minWait();
	 Assert.assertEquals(waitForElement(txt_clearancePeriod).getText(),"");
	 Assert.assertEquals(waitForElement(txt_fileName).getText(),"");
	 
 
 	return this;
 }
 
 
 
 public CRA188 verifyFileNameAndNewInvoices(String clearancePeriod){
	
	 clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod); 	
	check(chkbx_newInvoicesOnly);
	unCheck(chkbx_newInvoicesOnly);
	enterKeys(txt_fileName,"ABCD");
	click(lov_fileName); 
    waitForNewWindow(2);
	switchToSecondWindow(); 
	   enterKeys(txt_clearancePeriod_newWindow_filename_LOV,clearancePeriod);
	    click(btn_list_newWindow_filename_LOV); 
	check(checkbox_clearancePeriod_newWindow);

	click(btn_ok_newWindow_filename_LOV);
	switchToFirstWindow();
    waitForFrameAndSwitch(FRAME);  
	 
 
 	return this;
 }
  
 
 public CRA188 verifyAcknowledgementMSG(String clearancePeriod)
 {
	 clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);  
	// selectByValue(dropdown_classType, "Cargo");
     enterKeys(txt_clearancePeriod, clearancePeriod);
    
     while(true)
     {

     click(btn_btnGenerate);
     
    minWait();
     
   if(waitForElement(btn_ISFile).isDisplayed())
   {
 	  break;
   }
     minWait();
     }
   //waitForElement(btn_ISFile).click();
  click(btn_ISFile);
     minWait();
     driver.switchTo().defaultContent();
     waitForElement(info_genericMsg).getText().contains("Memo / AWB already available for invoicing. Do you want to generate IS File ?");
     
     
     click(yesBtn);
//     waitForFrameAndSwitch(FRAME);
//     driver.switchTo().defaultContent();
     waitForElement(info_genericMsg).getText().contains("Request sent for IS File Generation. Please check the status in External Interface Log Screen");
     click(btn_ok);
     waitForFrameAndSwitch(FRAME);
     
     return this; 
 }
 
 
 

 public CRA188 verifyClassAndClearancePeriodAutoPopulate(String clearancePeriod){
	
	 clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod); 	
	
	click(lov_fileName); 
    waitForNewWindow(2);
	switchToSecondWindow(); 
	   enterKeys(txt_clearancePeriod_newWindow_filename_LOV,clearancePeriod);
	    click(btn_list_newWindow_filename_LOV); 
	check(checkbox_clearancePeriod_newWindow);

	click(btn_ok_newWindow_filename_LOV);
	switchToFirstWindow();
    waitForFrameAndSwitch(FRAME);  
	Assert.assertEquals(waitForElement(txt_clearancePeriod).getAttribute("value"), clearancePeriod); 
    Assert.assertNotEquals(waitForElement(dropdown_classType).getAttribute("value"),"");
    
    
 
 	return this;
 }
   
 
 
 public CRA188 verifyEnterClerancePeriodMSG(){
		
	 while(true)
     {

     click(btn_btnGenerate);
     
    minWait();
     
   if(waitForElement(btn_ISFile).isDisplayed())
   {
 	  break;
   }
     minWait();
     }
   //waitForElement(btn_ISFile).click();
  click(btn_ISFile);
     minWait();
     Assert.assertEquals(waitForElement(info_error).getText(),"Enter Clearance Period");    
	return this;
 }
 
 
 
 
        
        
        
        
}
