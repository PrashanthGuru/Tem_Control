package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen CRA178
 * Created on 12/03/2018
 *
 * @author a-6784
 */
public class CRA080 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA179";
    public static String screenFrame = "iCargoContentFrameCRA179";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By 
    info_error,
    dropdown_parameterTypeLst,btn_List,txt_parameterCode,txt_parameterDescription,tbl_CRACreditMemo,btn_lnkDelete,btn_btnClear,
    btn_lnkAdd,btn_btnSave,check_checkbox,yesBtn,noBtn,btn_btnClose;
    
    
    
    
   
    public CRA080(WebDriver driver, String dataFileName) {
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

    	dropdown_parameterTypeLst=MiscUtility.getWebElement(objFilepath, "CRA080_dropdown_parameterTypeLst");
    	btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA080_btn_btnClose");
    	btn_List=MiscUtility.getWebElement(objFilepath, "CRA080_btn_List");
    	btn_btnClear=MiscUtility.getWebElement(objFilepath, "CRA080_btn_btnClear");
    	txt_parameterCode=MiscUtility.getWebElement(objFilepath, "CRA080_txt_parameterCode");
    	txt_parameterDescription=MiscUtility.getWebElement(objFilepath, "CRA080_txt_parameterDescription");
    	tbl_CRACreditMemo=MiscUtility.getWebElement(objFilepath, "CRA080_tbl_CRACreditMemo");
    	btn_lnkAdd=MiscUtility.getWebElement(objFilepath, "CRA080_btn_lnkAdd");
    	btn_lnkDelete=MiscUtility.getWebElement(objFilepath, "CRA080_btn_lnkDelete");
    	btn_btnSave=MiscUtility.getWebElement(objFilepath, "CRA080_btn_btnSave");
    	check_checkbox=MiscUtility.getWebElement(objFilepath, "CRA080_check_checkbox");
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
          info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
      
    }

	
public CRA080 VerifyParameterType(){
	
	minWait();
	
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("Accounting Tables"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("Accounting Values"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("Account Code Grouping"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("CCA Reason"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("CRA Billing Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("CRA Credit Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("CRA Rejection Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("MRA Billing Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("MRA Credit Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("MRA Rejection Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("Proration"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("Volume Incentive"));
	
	
	return this;
	

	

}
public CRA080 VerifyParameterCode_descriptionAdd_Delete(String ParameterCode,String ParameterDesp){
	
	minWait();
	
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("Accounting Tables"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("Accounting Values"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("Account Code Grouping"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("CCA Reason"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("CRA Billing Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("CRA Credit Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("CRA Rejection Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("MRA Billing Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("MRA Credit Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("MRA Rejection Memo"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("Proration"));
	Assert.assertTrue(waitForElement(dropdown_parameterTypeLst).getText().contains("Volume Incentive"));
	selectByValue(dropdown_parameterTypeLst, "CRA Credit Memo");
	click(btn_List);
	minWait();
	Assert.assertTrue(waitForElement(txt_parameterCode).getAttribute("value").contains(ParameterCode),"Error: The code is not present");
	Assert.assertTrue(waitForElement(txt_parameterDescription).getAttribute("value").contains(ParameterDesp),"Error: The description is not present");
	int rowcount=getTableRowCount(tbl_CRACreditMemo);
	click(btn_lnkAdd);	
	enterKeys(getWebElements(txt_parameterCode).get(rowcount), "TT");
	enterKeys(getWebElements(txt_parameterDescription).get(rowcount), "Test");
	click(btn_btnSave);
	minWait();
	click(btn_List);
	tblSelectRowByColValue(tbl_CRACreditMemo, 1, 2, "TT");
	click(btn_lnkDelete);
	minWait();
	click(btn_btnSave);
	
	return this;
	

}
public CRA080 View_Reason_CRABillngMemo(String ParameterCode,String ParameterDesp){
	
	minWait();
	
	
	selectByValue(dropdown_parameterTypeLst, "CRA Billing Memo");
	click(btn_List);
	minWait();
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "2A", "BILLING OUTSIDE IATA/ACH TIME LIMIT");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "2B", "ADDITIONAL COLLECTIONS ON AN AWB");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "2C", "10% EXCHANGE RATE VARIATION");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "2D", "ORIGINALLY BILLED TO A WRONG CARRIER");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "2Z", "OTHERS");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "6A", "DEBIT ON AUTHORITY");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "6B", "DEBIT DUE TO NO RESPONSE");
	
	click(btn_btnClear);
	minWait();
	selectByValue(dropdown_parameterTypeLst, "CRA Rejection Memo");
	click(btn_List);
	minWait();
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "01", "RATE ERROR");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "02", "WEIGHT ERROR");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "03", "THIS WAS A PREPAID SHIPMENT");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "04", "THIS WAS A COLLECT SHIPMENT");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "05", "OUT OF IATA/ACH TIME LIMIT");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "06", "OTHER CHARGES ERROR");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "07", "ROUTING ERROR");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "08", "NO REPLY TO OUR NO RECORD NOTIFICATION");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "09", "NO RECORD FOUND");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "10", "MISSING DOCUMENTS (TRM/AWB/CFM/OTHER)");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "11", "VAT ERROR");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "12", "DUPLICATE BILLING");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "13", "DEBIT ON AUTHORITY");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "14", "CURRENCY CONVERSION ERROR");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "15", "IRREGULARITY REPORT/NON DELIVERY");
	
	click(btn_btnClear);
	minWait();
	selectByValue(dropdown_parameterTypeLst, "CRA Credit Memo");
	click(btn_List);
	minWait();
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "3A", "INVOICE CORRECTION");
	tblSelectRowByMultipleColValue(tbl_CRACreditMemo, 1, 2, 3, "3Z", "OTHERS");
	
	
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
