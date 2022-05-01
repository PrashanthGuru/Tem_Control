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
public class CRA203 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA203";
    public static String screenFrame = "iCargoContentFrameCRA203";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String  genObjPath= PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By yesBtn,btn_volumeincentivelov,info_error,
    btn_ok,text_volumeincentivelovvolumeIncentiveId,
    btn_volumeincentivelovlistButton,btn_btnListAccEntries,chk_headChk,
    checkbox_volumeincentivelovselectCheckBox,btn_volumeincentivelovokButton,
    btn_btnList,tbl_listvolumeTable,btn_btnIncentiveDetails,
    tbl_IncentiveDetailslistvolumeTable,btn_IncentiveDetailsbtnClose,dropdown_statusFilter,
    btn_btnAccept,btn_btnClose;

   
   
    public CRA203(WebDriver driver, String dataFileName) {
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
    	info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    	btn_volumeincentivelov=MiscUtility.getWebElement(objFilepath, "CRA203_btn_volumeincentivelov");
    	text_volumeincentivelovvolumeIncentiveId=MiscUtility.getWebElement(objFilepath, "CRA203_text_volumeincentivelovvolumeIncentiveId");
    	btn_volumeincentivelovlistButton=MiscUtility.getWebElement(objFilepath, "CRA203_btn_volumeincentivelovlistButton");
    	checkbox_volumeincentivelovselectCheckBox=MiscUtility.getWebElement(objFilepath, "CRA203_checkbox_volumeincentivelovselectCheckBox");
    	btn_volumeincentivelovokButton=MiscUtility.getWebElement(objFilepath, "CRA203_btn_volumeincentivelovokButton");
    	btn_btnList=MiscUtility.getWebElement(objFilepath, "CRA203_btn_btnList");
    	tbl_listvolumeTable=MiscUtility.getWebElement(objFilepath, "CRA203_tbl_listvolumeTable");
    	btn_btnIncentiveDetails=MiscUtility.getWebElement(objFilepath, "CRA203_btn_btnIncentiveDetails");
    	tbl_IncentiveDetailslistvolumeTable=MiscUtility.getWebElement(objFilepath, "CRA203_tbl_IncentiveDetailslistvolumeTable");
    	btn_IncentiveDetailsbtnClose=MiscUtility.getWebElement(objFilepath, "CRA203_btn_IncentiveDetailsbtnClose");
    	btn_btnAccept=MiscUtility.getWebElement(objFilepath, "CRA203_btn_btnAccept");
    	dropdown_statusFilter=MiscUtility.getWebElement(objFilepath, "CRA203_dropdown_statusFilter");
    	btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA203_btn_btnClose");
    	btn_btnListAccEntries=MiscUtility.getWebElement(objFilepath, "CRA203_btn_btnListAccEntries");
        chk_headChk=MiscUtility.getWebElement(objFilepath, "CRA203_chk_headChk");
    }
  

public CRA203 AcceptVolumeIncentive(String incvid,String agent,String FChargeAddn){

	incvid = PropertyHandler.getPropValue(dataFilePath, incvid);
	agent = PropertyHandler.getPropValue(dataFilePath, agent);
	FChargeAddn = PropertyHandler.getPropValue(dataFilePath, FChargeAddn);
click(btn_volumeincentivelov);
minWait();
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovvolumeIncentiveId, incvid);
click(btn_volumeincentivelovlistButton);
minWait();
check(checkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);

minWait();
switchToFirstWindow();
waitForFrameAndSwitch(FRAME);
click(btn_btnList);
minWait();
String camt=getTableCellValue(tbl_listvolumeTable, 8, 1).replace(",", "");
System.out.println("Incentive Amt is:"+camt);

int CA;
int F = Integer.parseInt(FChargeAddn);
CA=(5/100)*F;
String CommAmt=String.valueOf(CA);
System.out.println("Incentive Amt calculated is:"+CommAmt);
Assert.assertFalse(CommAmt.contains(camt), "ERROR: The Incentive amount is not correct");

tblSelectRowByColValue(tbl_listvolumeTable, 1, 6, incvid);
click(btn_btnIncentiveDetails);
minWait();

String amt=getTableCellValue(tbl_IncentiveDetailslistvolumeTable, 10, 1);
System.out.println("Volume Incentive: "+amt);
Assert.assertFalse(camt.contains(amt), "ERROR: Mismatch in GSA commission value");
click(btn_IncentiveDetailsbtnClose);
minWait();

tblSelectRowByColValue(tbl_listvolumeTable, 1, 2, agent);
click(btn_btnAccept);
minWait();
Assert.assertFalse(waitForElement(info_error).getText().contains("No result found for specified filter criteria"),"EEROR:Acceptance not done");


selectByValue(dropdown_statusFilter,"Accepted");
click(btn_btnList);
tblSelectRowByColValue(tbl_listvolumeTable, 1, 6, incvid);



return this;


}
public CRA203 ListAcctNavigationVerify(String incvid,String agent,String FChargeAddn){

	incvid = PropertyHandler.getPropValue(dataFilePath, incvid);
	agent = PropertyHandler.getPropValue(dataFilePath, agent);
	FChargeAddn = PropertyHandler.getPropValue(dataFilePath, FChargeAddn);
click(btn_volumeincentivelov);
minWait();
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovvolumeIncentiveId, incvid);
click(btn_volumeincentivelovlistButton);
minWait();
check(checkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);
minWait();
waitForFrameAndSwitch(FRAME);
click(btn_btnList);
minWait();
check(chk_headChk);

click(btn_btnListAccEntries);

maxWait();
Assert.assertTrue(driver.getTitle().contains("List Accounting Entries"),"Error: Accounting triggered");

minWait();
return this;
}
public CRA203 VerifySelectionError(String incvid,String agent,String FChargeAddn){

	incvid = PropertyHandler.getPropValue(dataFilePath, incvid);
	agent = PropertyHandler.getPropValue(dataFilePath, agent);
	FChargeAddn = PropertyHandler.getPropValue(dataFilePath, FChargeAddn);
click(btn_volumeincentivelov);
minWait();
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovvolumeIncentiveId, incvid);
click(btn_volumeincentivelovlistButton);
minWait();
check(checkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);
minWait();
waitForFrameAndSwitch(FRAME);
click(btn_btnList);
minWait();
check(chk_headChk);
click(btn_btnListAccEntries);
minWait();
driver.switchTo().defaultContent();
Assert.assertFalse(waitForElement(info_error).getText().contains("Select one row only"),"EEROR:Able to select multiple incentives");
click(btn_ok);
minWait();
waitForFrameAndSwitch(FRAME);



minWait();
return this;
}

public CRA203 VerifyAccountingError(String incvid,String agent,String FChargeAddn){

	incvid = PropertyHandler.getPropValue(dataFilePath, incvid);
	agent = PropertyHandler.getPropValue(dataFilePath, agent);
	FChargeAddn = PropertyHandler.getPropValue(dataFilePath, FChargeAddn);
click(btn_volumeincentivelov);
minWait();
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovvolumeIncentiveId, incvid);
click(btn_volumeincentivelovlistButton);
minWait();
check(checkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);
minWait();
waitForFrameAndSwitch(FRAME);
selectByText(dropdown_statusFilter, "New");
click(btn_btnList);
minWait();
tblSelectRowByColValue(tbl_listvolumeTable, 1, 6, "New");

click(btn_btnListAccEntries);
minWait();
driver.switchTo().defaultContent();
Assert.assertFalse(waitForElement(info_error).getText().contains("The incentive is in New status and has not been accounted"),"ERROR:Accounting triggered for New Volume incentive");
click(btn_ok);
minWait();
waitForFrameAndSwitch(FRAME);



minWait();
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
