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
public class CRA205 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA205";
    public static String screenFrame = "iCargoContentFrameCRA205";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String  genObjPath= PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By yesBtn,btn_gsaCommissionLov,info_error,text_agentCodeFilter,
    btn_ok,text_gsaCommissionLovmasterID,dropdown_territoryTypeFilter,
    btn_gsaCommissionLovlistButton,info_msg,btn_listAccountingEntries,text_toDateFilter,
    checkbox_gsaCommissionLovselectCheckBox,btn_gsaCommissionLovokButton,text_fromDateFilter,
    btn_btnDisplay,tbl_gsacommissions,btn_incentiveDetails,text_territoryCodeFilter,
    tbl_GSACommdetailslistGSAComTable,btn_GSACommdetailsbtnClose,dropdown_gsaStatus,
    btn_btnAccept,btn_btnClose;

   
   
    public CRA205(WebDriver driver, String dataFileName) {
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
    	info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    	btn_gsaCommissionLov=MiscUtility.getWebElement(objFilepath, "CRA205_btn_gsaCommissionLov");
    	text_gsaCommissionLovmasterID=MiscUtility.getWebElement(objFilepath, "CRA205_text_gsaCommissionLovmasterID");
    	btn_gsaCommissionLovlistButton=MiscUtility.getWebElement(objFilepath, "CRA205_btn_gsaCommissionLovlistButton");
    	checkbox_gsaCommissionLovselectCheckBox=MiscUtility.getWebElement(objFilepath, "CRA205_checkbox_gsaCommissionLovselectCheckBox");
    	btn_gsaCommissionLovokButton=MiscUtility.getWebElement(objFilepath, "CRA205_btn_gsaCommissionLovokButton");
    	btn_btnDisplay=MiscUtility.getWebElement(objFilepath, "CRA205_btn_btnDisplay");
    	tbl_gsacommissions=MiscUtility.getWebElement(objFilepath, "CRA205_tbl_gsacommissions");
    	btn_incentiveDetails=MiscUtility.getWebElement(objFilepath, "CRA205_btn_incentiveDetails");
    	tbl_GSACommdetailslistGSAComTable=MiscUtility.getWebElement(objFilepath, "CRA205_tbl_GSACommdetailslistGSAComTable");
    	btn_GSACommdetailsbtnClose=MiscUtility.getWebElement(objFilepath, "CRA205_btn_GSACommdetailsbtnClose");
    	btn_btnAccept=MiscUtility.getWebElement(objFilepath, "CRA205_btn_btnAccept");
    	dropdown_gsaStatus=MiscUtility.getWebElement(objFilepath, "CRA205_dropdown_gsaStatus");
    	btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA205_btn_btnClose");
    	dropdown_territoryTypeFilter=MiscUtility.getWebElement(objFilepath, "CRA205_dropdown_territoryTypeFilter");
    	text_territoryCodeFilter=MiscUtility.getWebElement(objFilepath, "CRA205_text_territoryCodeFilter");
    	text_agentCodeFilter=MiscUtility.getWebElement(objFilepath, "CRA205_text_agentCodeFilter");
    	btn_listAccountingEntries=MiscUtility.getWebElement(objFilepath, "CRA205_btn_listAccountingEntries");
    	text_fromDateFilter=MiscUtility.getWebElement(objFilepath, "CRA205_text_fromDateFilter");
    	text_toDateFilter=MiscUtility.getWebElement(objFilepath, "CRA205_text_toDateFilter");
    	
    }
    public CRA055 CheckAccountingDetails(String agent_rare,String commid){

    	commid = PropertyHandler.getPropValue(dataFilePath, commid);
    	
    	
    	agent_rare=PropertyHandler.getPropValue(dataFilePath, agent_rare);
    	enterKeys(text_agentCodeFilter, agent_rare);
    	selectByText(dropdown_gsaStatus, "New");
    	click(btn_btnDisplay);
    	minWait();
    	
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid);
      
        
        
        click(btn_listAccountingEntries);
        minWait();
       return new CRA055(driver, dataFileName);
    }
 
    public CRA205 NewGSA_NotAccountedErrorValidation(String agent_rare,String commid){

    	commid = PropertyHandler.getPropValue(dataFilePath, commid);
    	
    	
    	agent_rare=PropertyHandler.getPropValue(dataFilePath, agent_rare);
    	enterKeys(text_agentCodeFilter, agent_rare);
    	selectByText(dropdown_gsaStatus, "New");
    	click(btn_btnDisplay);
    	minWait();
    	
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid);
      
      
        
        click(btn_listAccountingEntries);
        minWait();
        driver.switchTo().defaultContent();
        Assert.assertFalse(waitForElement(info_error).getText().contains("The incentive is in New status and has not been accounted"),"ERROR:Accounting triggered for New Volume incentive");
        click(btn_ok);
        minWait();
        waitForFrameAndSwitch(FRAME);


      
       return this;


    }


    
    public CRA205 MultipleRowSelection_ErrorValidation(String agent_rare,String commid,String commid2){

    	commid = PropertyHandler.getPropValue(dataFilePath, commid);
    	commid2 = PropertyHandler.getPropValue(dataFilePath, commid2);
    	
    	agent_rare=PropertyHandler.getPropValue(dataFilePath, agent_rare);
    	enterKeys(text_agentCodeFilter, agent_rare);
    	selectByText(dropdown_gsaStatus, "Accepted");
    	click(btn_btnDisplay);
    	minWait();
    	
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid);
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid2);
        
        
        click(btn_incentiveDetails);
        minWait();
        driver.switchTo().defaultContent();
        
        Assert.assertFalse(waitForElement(info_msg).getText().contains("Select one row only"),"EEROR:Multiple row selection not validated");
        click(btn_ok);
        waitForFrameAndSwitch(FRAME);

      
       return this;


    }

    public CRA205 VerifyAlready_AcceptedError(String agent_rare,String commid){

    	commid = PropertyHandler.getPropValue(dataFilePath, commid);
    	
    	agent_rare=PropertyHandler.getPropValue(dataFilePath, agent_rare);
    	enterKeys(text_agentCodeFilter, agent_rare);
    	selectByText(dropdown_gsaStatus, "Accepted");
    	click(btn_btnDisplay);
    	minWait();
    	
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid);
        
        
        click(btn_btnAccept);
        minWait();
        Assert.assertFalse(waitForElement(info_error).getText().contains("Selected records are already accepted"),"EEROR:Acceptance already done error is not shown");


      
       return this;


    }

    public CRA205 ListGSA(String agent_rare,String commid){

    	commid = PropertyHandler.getPropValue(dataFilePath, commid);
    	
    	agent_rare=PropertyHandler.getPropValue(dataFilePath, agent_rare);
    	enterKeys(text_agentCodeFilter, agent_rare);
    	selectByText(dropdown_gsaStatus, "Accepted");
    	click(btn_btnDisplay);
    	minWait();
    	
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid);
        return this;
    }
    public CRA205 ListGSA_WithMandatoryFields(String agent_rare,String commid1,String commid2){

    	commid1 = PropertyHandler.getPropValue(dataFilePath, commid1);
    	commid2 = PropertyHandler.getPropValue(dataFilePath, commid2);
    	
    	agent_rare=PropertyHandler.getPropValue(dataFilePath, agent_rare);
    	enterKeys(text_fromDateFilter, ".");
    	enterKeys(text_toDateFilter, ".");
    	enterKeys(text_agentCodeFilter, agent_rare);
    	selectByText(dropdown_gsaStatus, "Accepted");
    	click(btn_btnDisplay);
    	minWait();
    	
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid1);
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid2);
        return this;
    }

    public CRA205 ListGSACommission_TerritoryLevel(String commid,String agent,String Origin){

    	commid = PropertyHandler.getPropValue(dataFilePath, commid);
    	agent = PropertyHandler.getPropValue(dataFilePath, agent);
    	Origin = PropertyHandler.getPropValue(dataFilePath, Origin);
    click(btn_gsaCommissionLov);
    minWait();
    waitForNewWindow(2);
    switchToSecondWindow();
    enterKeys(text_gsaCommissionLovmasterID, commid);
    click(btn_gsaCommissionLovlistButton);
    minWait();
    check(checkbox_gsaCommissionLovselectCheckBox);
    click(btn_gsaCommissionLovokButton);

    minWait();
    switchToFirstWindow();
    waitForFrameAndSwitch(FRAME);
    selectByText(dropdown_territoryTypeFilter, "Station");
    enterKeys(text_territoryCodeFilter,Origin);
    selectByIndex(dropdown_gsaStatus, 1);
    click(btn_btnDisplay);
    minWait();
    
    tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid);
       return this;


    }

    public CRA205 AcceptMultipleIncentives(String agent_rare,String commid,String commid2){

    	commid = PropertyHandler.getPropValue(dataFilePath, commid);
    	commid2 = PropertyHandler.getPropValue(dataFilePath, commid2);
    	
    	agent_rare=PropertyHandler.getPropValue(dataFilePath, agent_rare);
    	enterKeys(text_agentCodeFilter, agent_rare);
    	selectByText(dropdown_gsaStatus, "New");
    	click(btn_btnDisplay);
    	minWait();
    	
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid);
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid2);
       
        
        click(btn_btnAccept);
        minWait();
        Assert.assertFalse(waitForElement(info_error).getText().contains("No result found for specified filter criteria"),"EEROR:Acceptance not done");


        selectByValue(dropdown_gsaStatus,"Accepted");
        click(btn_btnDisplay);
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid);
        tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid2);
       
       return this;


    }


public CRA205 AcceptGSACommission(String commid,String agent,String FChargeAddn){

	commid = PropertyHandler.getPropValue(dataFilePath, commid);
	agent = PropertyHandler.getPropValue(dataFilePath, agent);
	FChargeAddn = PropertyHandler.getPropValue(dataFilePath, FChargeAddn);
click(btn_gsaCommissionLov);
minWait();
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_gsaCommissionLovmasterID, commid);
click(btn_gsaCommissionLovlistButton);
minWait();
check(checkbox_gsaCommissionLovselectCheckBox);
click(btn_gsaCommissionLovokButton);

minWait();

waitForFrameAndSwitch(FRAME);
switchToFirstWindow();
selectByValue(dropdown_gsaStatus, "New");

click(btn_btnDisplay);
minWait();
String camt=getTableCellValue(tbl_gsacommissions, 8, 1);
System.out.println("Commission Amt is:"+camt);

int CA;
int F = Integer.parseInt(FChargeAddn);
CA=(5/100)*F;
String CommAmt=String.valueOf(CA);
System.out.println("Commission Amt calculated is:"+CommAmt);
Assert.assertFalse(CommAmt.contains(camt), "ERROR: The commission amount is not correct");

tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid);
click(btn_incentiveDetails);
minWait();

String amt=getTableCellValue(tbl_GSACommdetailslistGSAComTable, 10, 1);
System.out.println("GSA Commission: "+amt);
Assert.assertFalse(camt.contains(amt), "ERROR: Mismatch in GSA commission value");
click(btn_GSACommdetailsbtnClose);
minWait();

tblSelectRowByColValue(tbl_gsacommissions, 1, 2, agent);
click(btn_btnAccept);
minWait();
Assert.assertFalse(waitForElement(info_error).getText().contains("No result found for specified filter criteria"),"EEROR:Acceptance not done");


selectByValue(dropdown_gsaStatus,"Accepted");
click(btn_btnDisplay);
tblSelectRowByColValue(tbl_gsacommissions, 1, 5, commid);



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
