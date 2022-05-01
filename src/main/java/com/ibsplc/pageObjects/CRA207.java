package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


/**
 * Screen OPR026 - CAPTURE AWB
 * Created on 21/12/2017
 *
 * @author a-7868
 */
public class CRA207 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA153";
    public static String screenFrame = "iCargoContentFrameCRA153";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String  genObjPath= PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By yesBtn,dropdown_subsystem,
    btn_ok,dropdown_invoiceType,
    text_fromDate,
    text_toDate,
    btn_btList,
    tbl_invoicelogdetails,
    btn_btClose;

   
   
    public CRA207(WebDriver driver, String dataFileName) {
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
    	dropdown_subsystem=MiscUtility.getWebElement(objFilepath, "CRA207_dropdown_subsystem");
    	dropdown_invoiceType=MiscUtility.getWebElement(objFilepath, "CRA207_dropdown_invoiceType");
    	text_fromDate=MiscUtility.getWebElement(objFilepath, "CRA207_text_fromDate");
    	text_toDate=MiscUtility.getWebElement(objFilepath, "CRA207_text_toDate");
    	btn_btList=MiscUtility.getWebElement(objFilepath, "CRA207_btn_btList");
    	tbl_invoicelogdetails=MiscUtility.getWebElement(objFilepath, "CRA207_tbl_invoicelogdetails");
    	btn_btClose=MiscUtility.getWebElement(objFilepath, "CRA154_btn_btClose");
    }
  

public CRA207 CheckStatus(String subsystem, String invoicetype,String fromDate,String toDate){

subsystem = PropertyHandler.getPropValue(dataFilePath, subsystem);
invoicetype = PropertyHandler.getPropValue(dataFilePath, invoicetype);
fromDate= PropertyHandler.getPropValue(dataFilePath, fromDate);
toDate=PropertyHandler.getPropValue(dataFilePath, toDate);

selectByText(dropdown_subsystem, subsystem);
selectByText(dropdown_invoiceType, invoicetype);
enterKeys(text_fromDate, fromDate);
enterKeys(text_toDate, toDate);
click(btn_btList);
minWait();

String Status=getTableCellValue(tbl_invoicelogdetails, 6, 1);
Assert.assertFalse(Status.contains("Completed"), "ERROR: The invoice generation is not successful");
driver.switchTo().defaultContent();
click(btn_ok);
waitForFrameAndSwitch(screenFrame);


return this;


}

    public HomePage close() {

        click(btn_btClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
