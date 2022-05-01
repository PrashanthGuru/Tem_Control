package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/****
 * 
 * @author A-6784
 *
 */

public class CRA038 extends BasePage {


    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameCRA038";
    public String filepath;
    WebDriver driver;
    String testDataFile;
    String browser;
    
    By
    yesBtn,
    noBtn,
    msg_success,
    info_msgClose,
    info_dialogueContent,
    info_successMessageToast;
    By
    
    txt_country,
    btn_list,
    tbl_viewCassBillingtbl,
    txt_awbPrefix,
    txt_AWBNo,
    info_error,
    okBtn,
    btn_search,
   error_close,
    btn_withdraw,
    link_billingperiodDropdown,
    tbl_billingPerioddropDowntbl,
    btn_close,
    btn_finalize,
    chkbx_selectAWB;

    
    public CRA038(WebDriver driver, String testDataFile) {
        super(driver);
        this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver, this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + testDataFile;
        initPageElements();
    }
    private void initPageElements() {

        System.out.println("Going to capture all webElements..!");
        
        yesBtn                       = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
        noBtn                        = MiscUtility.getWebElement(genFilepath, "Generic_btn_noBtn");
        msg_success                  = MiscUtility.getWebElement(genFilepath, "Generic_foot_layer");
        info_msgClose                = MiscUtility.getWebElement(genFilepath, "Generic_info_close");
   
        info_dialogueContent         = MiscUtility.getWebElement(genFilepath, "Generic_info_msg");
        info_successMessageToast     = MiscUtility.getWebElement(genFilepath, "Info_successMessageToast");

        txt_country                  = MiscUtility.getWebElement(objFilepath, "CRA038_txt_country");
        btn_list                     = MiscUtility.getWebElement(objFilepath, "CRA038_btn_list");
        tbl_viewCassBillingtbl       = MiscUtility.getWebElement(objFilepath, "CRA038_tbl_viewCassBillingtbl");
        txt_awbPrefix                = MiscUtility.getWebElement(objFilepath, "CRA038_txt_awbPrefix");
        txt_AWBNo                    = MiscUtility.getWebElement(objFilepath, "CRA038_txt_AWBNo");
        btn_search                   = MiscUtility.getWebElement(objFilepath, "CRA038_btn_search");
        btn_withdraw                 = MiscUtility.getWebElement(objFilepath, "CRA038_btn_withdraw");
        chkbx_selectAWB              = MiscUtility.getWebElement(objFilepath, "CRA038_chkbx_selectAWB");
        link_billingperiodDropdown   = MiscUtility.getWebElement(objFilepath, "CRA038_link_billingperiodDropdown");
        tbl_billingPerioddropDowntbl = MiscUtility.getWebElement(objFilepath, "CRA038_tbl_billingPerioddropDowntbl");
        okBtn                        = MiscUtility.getWebElement(genFilepath, "Generic_btn_ok");
        btn_close                    = MiscUtility.getWebElement(objFilepath, "CRA038_btn_close");
        btn_finalize                 = MiscUtility.getWebElement(objFilepath, "CRA038_btn_finalize");
        info_error                   = MiscUtility.getWebElement(genFilepath, "Generic_info_error");
        error_close                  = MiscUtility.getWebElement(genFilepath, "Generic_error_close");
      
    } 
    
    public CRA038 withdrawAWB(String awbPrefix,String AWBNo,String flightDate,String country,String billingPeriod){
		
    	awbPrefix     =PropertyHandler.getPropValue(filepath, awbPrefix);
    	AWBNo         =PropertyHandler.getPropValue(filepath, AWBNo);
    	flightDate    =PropertyHandler.getPropValue(filepath, flightDate);
    	country       =PropertyHandler.getPropValue(filepath, country);
    	billingPeriod =PropertyHandler.getPropValue(filepath, billingPeriod);
    	
    	String dat=BizUtility.getInvoiceFromDate(flightDate,billingPeriod);
    	
    	enterKeys(txt_country, country);
    	click(link_billingperiodDropdown);
    	clickTableRowByValue(tbl_billingPerioddropDowntbl,1,dat);
    	click(btn_list);
    	minWait();
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, AWBNo);
    	click(btn_search);
    	minWait();
    	waitForElement(tbl_viewCassBillingtbl);
    	check(chkbx_selectAWB);
    	click(btn_withdraw);
    	driver.switchTo().defaultContent();
        minWait();
        waitForElement(yesBtn);  
        waitForElement(info_dialogueContent).getText().contains("Do you want to withdraw the selected AWB(s)/CCA(s) from the CASS File?");
            click(yesBtn);
            waitForFrameAndSwitch(FRAME);
            minWait();
        
            click(okBtn);
        	
	        waitForFrameAndSwitch(FRAME);
	        minWait();
            
    	return this;
    	
    }
    
    public CRA038 finalizeCassFile(String country,String billingPeriod,String flightDate){
		
    	country          =PropertyHandler.getPropValue(filepath, country);
    	billingPeriod    =PropertyHandler.getPropValue(filepath, billingPeriod);
    	flightDate       =PropertyHandler.getPropValue(filepath, flightDate);
    	
    	click(btn_finalize);
    	minWait();
    	Assert.assertFalse(waitForElement(btn_withdraw).isEnabled(),"Error:Withdraw button enable");
    	
    	
    	return this;	
    }
    
    public CRA038 checkCassFileDeleted(){
		
		Assert.assertTrue(waitForElement(info_error).getText().contains("CASS Billing File not found"),"ERROR: Cass file not deleted");
    	click(error_close);
    	return this;
    }
    public HomePage close() {

	    click(btn_close);
	    driver.switchTo().defaultContent();
	    if (verifyElementPresent(yesBtn)) {

	        click(yesBtn);
	    }
	    return new HomePage(driver, testDataFile);
	}

}
