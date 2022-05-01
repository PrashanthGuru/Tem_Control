package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
public class CRA070 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA070";
    public static String screenFrame = "iCargoContentFrameCRA070";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String  genObjPath= PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By yesBtn,btn_volincLov,
    btn_ok,text_volincLovvolumeIncentiveId,
    btn_commissionlovlistButton,
    chkbox_volincLovselectCheckBox,
    btn_volincLovokButton,text_fromDate,
    btn_btnGenerate,text_toDate,
    btn_btnClose;

   
   
    public CRA070(WebDriver driver, String dataFileName) {
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
    	btn_volincLov=MiscUtility.getWebElement(objFilepath, "CRA070_btn_volincLov");
    	text_volincLovvolumeIncentiveId=MiscUtility.getWebElement(objFilepath, "CRA070_text_volincLovvolumeIncentiveId");
    	chkbox_volincLovselectCheckBox=MiscUtility.getWebElement(objFilepath, "CRA070_chkbox_volincLovselectCheckBox");
        btn_volincLovokButton=MiscUtility.getWebElement(objFilepath, "CRA070_btn_volincLovokButton");
        btn_btnGenerate=MiscUtility.getWebElement(objFilepath, "CRA070_btn_btnGenerate");
        btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA070_btn_btnClose");
        text_toDate=MiscUtility.getWebElement(objFilepath, "CRA070_text_toDate");
        text_fromDate=MiscUtility.getWebElement(objFilepath, "CRA070_text_fromDate");
        btn_commissionlovlistButton=MiscUtility.getWebElement(objFilepath, "CRA154_btn_commissionlovlistButton");
    	
    }
  

public CRA070 GenerateVolInc(String VInc_ID,String fromdate,String billingfreq){
	
VInc_ID = PropertyHandler.getPropValue(dataFilePath, VInc_ID);
fromdate = PropertyHandler.getPropValue(dataFilePath, fromdate);

billingfreq = PropertyHandler.getPropValue(dataFilePath, billingfreq);

String invoiceFromDate=BizUtility.getInvoiceFromDate(fromdate, billingfreq);
String invoiceToDate=BizUtility.getInvoiceToDate(fromdate, billingfreq);
System.out.println("invoiceFromDate "+invoiceFromDate);
System.out.println("invoiceToDate"+invoiceToDate);

click(btn_volincLov);
minWait();
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volincLovvolumeIncentiveId, VInc_ID);
click(btn_commissionlovlistButton);
minWait();
check(chkbox_volincLovselectCheckBox);
click(btn_volincLovokButton);
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

    public HomePage close() {

        click(btn_btnClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
