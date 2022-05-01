package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CRA026 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA026";
    
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");




By

yesBtn,
dropdown_billingParty,
txt_customerCode,
btn_list,
tbl_invoicetable,
btn_close;







public CRA026(WebDriver driver, String dataFileName) {
    super(driver);
    this.driver = driver;
    initElements();
    this.dataFilePath = this.dataFilePath + dataFileName;
    this.dataFileName = dataFileName;
}

private void  initElements(){
	yesBtn                    = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
	
	dropdown_billingParty    = MiscUtility.getWebElement(objFilepath, "CRA026_dropdown_billingParty");
	txt_customerCode         = MiscUtility.getWebElement(objFilepath, "CRA026_txt_customerCode");
	btn_list                 = MiscUtility.getWebElement(objFilepath, "CRA026_btn_list");
	tbl_invoicetable         = MiscUtility.getWebElement(objFilepath, "CRA026_tbl_invoicetable");
	btn_close                = MiscUtility.getWebElement(objFilepath, "CRA026_btn_close");
}
/***
 * 
 * @param billingParty
 * @param customerCode
 * @param invoiceNum
 * @return
 */
    public CRA026 verifyInvoice(String billingParty,String customerCode,String invoiceNum){
    	
    	billingParty=PropertyHandler.getPropValue(dataFilePath, billingParty);
    	customerCode=PropertyHandler.getPropValue(dataFilePath,customerCode);
    	invoiceNum=PropertyHandler.getPropValue(dataFilePath, invoiceNum);
    	
    	
    	selectByText(dropdown_billingParty, billingParty);
    	enterKeys(txt_customerCode, customerCode);
    	click(btn_list);
    	minWait();
		
    	tblSelectRowByMultipleColValue(tbl_invoicetable, 1, 2, 7, invoiceNum, customerCode);
    	
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
