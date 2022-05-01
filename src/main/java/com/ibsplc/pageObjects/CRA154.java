package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


/**
 * Screen OPR026 - CAPTURE AWB
 * Created on 21/12/2017
 *
 * @author a-7868
 */
public class CRA154 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA154";
    public static String screenFrame = "iCargoContentFrameCRA154";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String  genObjPath= PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By yesBtn,btn_commissionlov,
    btn_ok,text_commissionmasterID,
    btn_commissionlovlistButton,
    chkbox_commissionlovselectCheckBox,text_toDate,
    btn_commissionlovokButton,text_fromDate,
    btn_btnGenerate,info_error,
    btn_btnClose;

   
   
    public CRA154(WebDriver driver, String dataFileName) {
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
    	
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    	info_error= MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    	btn_commissionlov=MiscUtility.getWebElement(objFilepath, "CRA154_btn_commissionlov");
    	text_commissionmasterID=MiscUtility.getWebElement(objFilepath, "CRA154_text_commissionmasterID");
    	btn_commissionlovlistButton=MiscUtility.getWebElement(objFilepath, "CRA154_btn_commissionlovlistButton");
    	chkbox_commissionlovselectCheckBox=MiscUtility.getWebElement(objFilepath, "CRA154_chkbox_commissionlovselectCheckBox");
    	btn_commissionlovokButton=MiscUtility.getWebElement(objFilepath, "CRA154_btn_commissionlovokButton");
    	btn_btnGenerate=MiscUtility.getWebElement(objFilepath, "CRA154_btn_btnGenerate");
    	btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA154_btn_btnClose");
    	text_toDate=MiscUtility.getWebElement(objFilepath, "CRA154_text_toDate");
        text_fromDate=MiscUtility.getWebElement(objFilepath, "CRA154_text_fromDate");		
    }
  

public CRA154 GenerateGSA(String GSA_ID,String bliingFreq,String fromdate){

GSA_ID = PropertyHandler.getPropValue(dataFilePath, GSA_ID);
bliingFreq = PropertyHandler.getPropValue(dataFilePath, bliingFreq);
fromdate = PropertyHandler.getPropValue(dataFilePath, fromdate);

String invoiceFromDate=BizUtility.getInvoiceFromDate(fromdate, bliingFreq);
String invoiceToDate=BizUtility.getInvoiceToDate(fromdate, bliingFreq);

click(btn_commissionlov);
minWait();
waitForNewWindow(2);
switchToSecondWindow();

enterKeys(text_commissionmasterID, GSA_ID);
click(btn_commissionlovlistButton);

check(chkbox_commissionlovselectCheckBox);
click(btn_commissionlovokButton);
minWait();
switchToFirstWindow();

waitForFrameAndSwitch(screenFrame);



enterKeys(text_fromDate, invoiceFromDate);
enterKeys(text_toDate, invoiceToDate);

click(btn_btnGenerate);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
waitForFrameAndSwitch(screenFrame);

return this;


}
public CRA154 GenerateGSA_Error_NewInactiveGSAs(String GSA_ID){

GSA_ID = PropertyHandler.getPropValue(dataFilePath, GSA_ID);

click(btn_commissionlov);
minWait();

enterKeys(text_commissionmasterID, GSA_ID);
click(btn_commissionlovlistButton);
minWait();
switchToSecondWindow();
check(chkbox_commissionlovselectCheckBox);
click(btn_commissionlovokButton);
minWait();
waitForFrameAndSwitch(screenFrame);

click(btn_btnGenerate);
minWait();
Assert.assertTrue(waitForElement(info_error).getText().contains("New/Inactive GSA Commission IDs cannot participate for calculation"),"Error: The Error message not shown");

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
