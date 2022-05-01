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
public class CRA153 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA153";
    public static String screenFrame = "iCargoContentFrameCRA153";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String  genObjPath= PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By yesBtn,text_agentCode,btn_payOutWeight,
    text_fromDate,btn_btnDelete,btn_btnClear,
    text_toDate,dropdown_gsaTerritoryType,
    btn_btnNew,info_error,text_basisValue,
    dropdown_payOutFrequency,btn_targetAmountRadioButton,dropdown_targetWeightUnit,
    btn_chargeBasisLov,dropdown_targetWeightBasis,
    chkbox_chargebasis,
    btn_Chargebasisok,text_gsaTerritoryCode,
    text_targetAmount,text_targetAmountBasis,
    text_targetCurrency,btn_agentCodelovbtOk,
    text_payOutCurrency,text_payOutAmountBasis,btn_btnInactive,
    btn_chargeBasisLovPayout,text_agentName,dropdown_gsaType,chkbox_chargebasisIATA,
    chkbox_chargebasispayout,chk_agentCodelovcheckbox,tbl_ChargebasisbasicPopupTable,
    btn_Chargebasispayoutok,text_gsaCode,
    btn_addLinkamt,info_msg,dropdown_payoutWeightBasis,
    text_fromAmount1,btn_ok,btn_agentCodelov,chkbox_incAWBSellLoc,
    text_toAmount1,btn_btnDisplay,btn_targetAmountPayOut,
    text_percentage1,btn_gsaCommissionLovokButton,
    text_fromAmount2,chkbox_gsaCommissionLovselectCheckBox,btn_targetWeightRadioButton,
    text_toAmount2,btn_gsaCommissionLovlistButton,tbl_ChargebasisValChrg,tbl_ChargebasisIATAChrg,
    text_percentage2,dropdown_gsaCommissionLovgsaStatus,div_status,chkbox_chargebasisValChrg,
    btn_btnGenerate,text_gsaCommissionLovagentCode,text_targetWeight,tbl_lovListTable,
    btn_btnActive,btn_gsaCommissionLov,text_gsaCommissionId,dropdown_payoutWeightUnit,
    btn_btnClose,tbl_agentCodeDetails,chkbox_chargebasisOCDC,btn_ChargebaisbtnClose;

   
   
    public CRA153(WebDriver driver, String dataFileName) {
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
    	info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    	info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    	text_gsaCommissionId=MiscUtility.getWebElement(objFilepath, "CRA153_text_gsaCommissionId");
    	        text_agentCode=MiscUtility.getWebElement(objFilepath, "CRA153_text_agentCode");
    			text_fromDate=MiscUtility.getWebElement(objFilepath, "CRA153_text_fromDate");
    			text_toDate=MiscUtility.getWebElement(objFilepath, "CRA153_text_toDate");
    			btn_btnNew=MiscUtility.getWebElement(objFilepath, "CRA153_btn_btnNew");
    			btn_btnDisplay=MiscUtility.getWebElement(objFilepath, "CRA153_btn_btnDisplay");
    			dropdown_payOutFrequency=MiscUtility.getWebElement(objFilepath, "CRA153_dropdown_payOutFrequency");
    			btn_chargeBasisLov=MiscUtility.getWebElement(objFilepath, "CRA153_btn_chargeBasisLov");
    			chkbox_chargebasis=MiscUtility.getWebElement(objFilepath, "CRA153_chkbox_chargebasis");
    			btn_Chargebasisok=MiscUtility.getWebElement(objFilepath, "CRA153_btn_Chargebasisok");
    			text_targetAmount=MiscUtility.getWebElement(objFilepath, "CRA153_text_targetAmount");
    			text_targetCurrency=MiscUtility.getWebElement(objFilepath, "CRA153_text_targetCurrency");
    			text_payOutCurrency=MiscUtility.getWebElement(objFilepath, "CRA153_text_payOutCurrency");
    			btn_chargeBasisLovPayout=MiscUtility.getWebElement(objFilepath, "CRA153_btn_chargeBasisLovPayout");
    			chkbox_chargebasispayout=MiscUtility.getWebElement(objFilepath, "CRA153_chkbox_chargebasispayout");
    			btn_Chargebasispayoutok=MiscUtility.getWebElement(objFilepath, "CRA153_btn_Chargebasispayoutok");
    			btn_addLinkamt=MiscUtility.getWebElement(objFilepath, "CRA153_btn_addLinkamt");
    			text_fromAmount1=MiscUtility.getWebElement(objFilepath, "CRA153_text_fromAmount1");
    			text_toAmount1=MiscUtility.getWebElement(objFilepath, "CRA153_text_toAmount1");
    			text_percentage1=MiscUtility.getWebElement(objFilepath, "CRA153_text_percentage1");
    			text_fromAmount2=MiscUtility.getWebElement(objFilepath, "CRA153_text_fromAmount2");
    			text_toAmount2=MiscUtility.getWebElement(objFilepath, "CRA153_text_toAmount2");
    			text_percentage2=MiscUtility.getWebElement(objFilepath, "CRA153_text_percentage2");
    			btn_btnGenerate=MiscUtility.getWebElement(objFilepath, "CRA153_btn_btnGenerate");
    			btn_btnActive=MiscUtility.getWebElement(objFilepath, "CRA153_btn_btnActive");
    			btn_gsaCommissionLov=MiscUtility.getWebElement(objFilepath, "CRA153_btn_gsaCommissionLov");
    			text_gsaCommissionLovagentCode=MiscUtility.getWebElement(objFilepath, "CRA153_text_gsaCommissionLovagentCode");
    			dropdown_gsaCommissionLovgsaStatus=MiscUtility.getWebElement(objFilepath, "CRA153_dropdown_gsaCommissionLovgsaStatus");
    			btn_gsaCommissionLovlistButton=MiscUtility.getWebElement(objFilepath, "CRA153_btn_gsaCommissionLovlistButton");
    			chkbox_gsaCommissionLovselectCheckBox=MiscUtility.getWebElement(objFilepath, "CRA153_chkbox_gsaCommissionLovselectCheckBox");
    			btn_gsaCommissionLovokButton=MiscUtility.getWebElement(objFilepath, "CRA153_btn_gsaCommissionLovokButton");
    	    	btn_btnClose=MiscUtility.getWebElement(objFilepath,"CRA153_btn_btnClose");
    	    	btn_agentCodelov=MiscUtility.getWebElement(objFilepath, "CRA153_btn_agentCodelov");
    	    	tbl_agentCodeDetails=MiscUtility.getWebElement(objFilepath, "CRA153_tbl_agentCodeDetails");
    	    	chk_agentCodelovcheckbox=MiscUtility.getWebElement(objFilepath, "CRA153_chk_agentCodelovcheckbox");
    	    	btn_agentCodelovbtOk=MiscUtility.getWebElement(objFilepath, "CRA153_btn_agentCodelovbtOk");
    	    	text_agentName=MiscUtility.getWebElement(objFilepath, "CRA153_text_agentName");
    	    	text_targetAmountBasis=MiscUtility.getWebElement(objFilepath, "CRA153_text_targetAmountBasis");
    	    	text_payOutAmountBasis=MiscUtility.getWebElement(objFilepath, "CRA153_text_payOutAmountBasis");
    	    	btn_targetAmountRadioButton=MiscUtility.getWebElement(objFilepath, "CRA153_btn_targetAmountRadioButton");
    	    	dropdown_targetWeightBasis=MiscUtility.getWebElement(objFilepath, "CRA153_dropdown_targetWeightBasis");
    	    	dropdown_targetWeightUnit=MiscUtility.getWebElement(objFilepath, "CRA153_dropdown_targetWeightUnit");
    	    	text_targetWeight=MiscUtility.getWebElement(objFilepath, "CRA153_text_targetWeight");
    	    	btn_targetAmountPayOut=MiscUtility.getWebElement(objFilepath, "CRA153_btn_targetAmountPayOut");
    	    	text_payOutCurrency=MiscUtility.getWebElement(objFilepath, "CRA153_text_payOutCurrency");
    	    	dropdown_payoutWeightUnit=MiscUtility.getWebElement(objFilepath, "CRA153_dropdown_payoutWeightUnit");
    	    	dropdown_payoutWeightBasis=MiscUtility.getWebElement(objFilepath, "CRA153_dropdown_payoutWeightBasis");
    	    	chkbox_incAWBSellLoc=MiscUtility.getWebElement(objFilepath, "CRA153_chkbox_incAWBSellLoc");
    	    	dropdown_gsaType=MiscUtility.getWebElement(objFilepath, "CRA153_dropdown_gsaType");
    	    	dropdown_gsaTerritoryType=MiscUtility.getWebElement(objFilepath, "CRA153_dropdown_gsaTerritoryType");
    	    	text_gsaTerritoryCode=MiscUtility.getWebElement(objFilepath, "CRA153_text_gsaTerritoryCode");
    	    	text_gsaCode=MiscUtility.getWebElement(objFilepath, "CRA153_text_gsaCode");
    	    	dropdown_gsaType=MiscUtility.getWebElement(objFilepath, "CRA153_dropdown_gsaType");
    	    	tbl_lovListTable=MiscUtility.getWebElement(objFilepath, "CRA153_tbl_lovListTable");
    	    	btn_btnInactive=MiscUtility.getWebElement(objFilepath, "CRA153_btn_btnInactive");
    	    	div_status=MiscUtility.getWebElement(objFilepath, "CRA153_div_status");
    	    	btn_btnDelete=MiscUtility.getWebElement(objFilepath, "CRA153_btn_btnDelete");
    	    	chkbox_chargebasisOCDC=MiscUtility.getWebElement(objFilepath, "CRA153_chkbox_chargebasisOCDC");
    	    	tbl_ChargebasisbasicPopupTable=MiscUtility.getWebElement(objFilepath, "CRA153_tbl_ChargebasisbasicPopupTable");
    	    	text_basisValue=MiscUtility.getWebElement(objFilepath, "CRA153_text_basisValue");
    	    	btn_ChargebaisbtnClose=MiscUtility.getWebElement(objFilepath, "CRA153_btn_ChargebaisbtnClose");
    	    	btn_btnClear=MiscUtility.getWebElement(objFilepath, "CRA153_btn_btnClear");
    	    	chkbox_chargebasisIATA=MiscUtility.getWebElement(objFilepath, "CRA153_chkbox_chargebasisIATA");
    	    	chkbox_chargebasisValChrg=MiscUtility.getWebElement(objFilepath, "CRA153_chkbox_chargebasisValChrg");
    	    	tbl_ChargebasisValChrg=MiscUtility.getWebElement(objFilepath, "CRA153_tbl_ChargebasisValChrg");
    	    	tbl_ChargebasisIATAChrg=MiscUtility.getWebElement(objFilepath, "CRA153_tbl_ChargebasisIATAChrg");
    	    	btn_targetWeightRadioButton=MiscUtility.getWebElement(objFilepath, "CRA153_btn_targetWeightRadioButton");
    	    	btn_payOutWeight=MiscUtility.getWebElement(objFilepath, "CRA153_btn_payOutWeight");
    	    	
    }
    
    
 public CRA153 Add_RemoveFormulaCheck(String agentCode_new){

    	
	 agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
 	 
 	enterKeys(text_agentCode, agentCode_new);
 	enterKeys(text_fromDate, ".");
/* 	int Tdate = Integer.parseInt(toDate);
 	Tdate=Tdate+30;
 	String ToDate=String.valueOf(Tdate);
*/
 	enterKeys(text_toDate, "+10");
 	click(btn_btnNew);
 	minWait();
 	driver.switchTo().defaultContent();
	Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");
	
	click(yesBtn);
	waitForFrameAndSwitch(screenFrame);
	
	
	click(btn_chargeBasisLov);
	waitForNewWindow(2);
	switchToSecondWindow();
	check(chkbox_chargebasis);
	selectByText(tbl_ChargebasisbasicPopupTable, "+");
	//tblSetListValueByColValue(tbl_ChargebasisbasicPopupTable, 2, 3, "OCDA", "+");
	
	
	check(chkbox_chargebasisOCDC);
	minWait();
	Assert.assertTrue(waitForElement(text_basisValue).getAttribute("value").contains("MKTCHG+OCDC"),"Error: The Charge basis formula is not populated");
	unCheck(chkbox_chargebasisOCDC);
    
	minWait();
	Assert.assertTrue(waitForElement(text_basisValue).getAttribute("value").contains("MKTCHG"),"Error: The Charge basis formula is not removed correctly");
	click(btn_Chargebasisok);
	minWait();
	switchToFirstWindow();
	waitForFrameAndSwitch(screenFrame);
	Assert.assertTrue(waitForElementVisible(text_targetAmountBasis).getAttribute("value").contains("MKTCHG"),"Error: The Chareg basis is not getting correctly populated");
	click(btn_chargeBasisLov);
	waitForNewWindow(2);
	switchToSecondWindow();
	check(chkbox_chargebasis);
	check(chkbox_chargebasisOCDC);
	minWait();
	click(btn_Chargebasisok);
	minWait();
	Assert.assertTrue(waitForElement(info_error).getText().contains("Operand missing.Please select appropriate operand"),"Error: Operand not missing error is not shown");
	
 	click(btn_ChargebaisbtnClose);
 	minWait();
 	switchToFirstWindow();
 	waitForFrameAndSwitch(screenFrame);
 	click(btn_chargeBasisLov);
	waitForNewWindow(2);
	switchToSecondWindow();
	check(chkbox_chargebasis);
	selectByText(tbl_ChargebasisbasicPopupTable, "+");
	//tblSetListValueByColValue(tbl_ChargebasisbasicPopupTable, 2, 3, "OCDA", "+");
	check(chkbox_chargebasisOCDC);
	minWait();
	click(btn_ChargebaisbtnClose);
	minWait();
	driver.switchTo().defaultContent();
	Assert.assertTrue(waitForElement(info_msg).getText().contains("Unsaved data exists. Do you want to continue?"),"Error: No  Unsaved data exists error shown");
	click(yesBtn);
	minWait();
 	switchToFirstWindow();
 	waitForFrameAndSwitch(screenFrame);
 	click(btn_btnClear);
 	minWait();
    return this;
    
    }
    public CRA153 VerifyElementsGSADetails_Territory(){

    	
    	
    	selectByText(dropdown_gsaType, "Territory");
    	minWait();
    	if(verifyElementPresent(chkbox_incAWBSellLoc)){
    	Assert.assertTrue(verifyElementPresent(dropdown_gsaTerritoryType),"Object not found");
    	Assert.assertTrue(verifyElementPresent(text_gsaTerritoryCode),"Object not found");
    	Assert.assertTrue(verifyElementPresent(text_gsaCode),"Object not found");
    	Assert.assertTrue(waitForElement(dropdown_gsaTerritoryType).getText().contains("Country"),"Error: Value not present");
    	Assert.assertTrue(waitForElement(dropdown_gsaTerritoryType).getText().contains("Station"),"Error: Value not present");
    	Assert.assertTrue(waitForElement(dropdown_gsaTerritoryType).getText().contains("Station Group"),"Error: Value not present");
    	}
    	
    	click(btn_btnClear);
    	minWait();
    	return this;
    }
    
    public CRA153 VerifyElements_InTargetPanelWeight(String agentCode_new){

agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
	    
    	enterKeys(text_agentCode, agentCode_new);
    	enterKeys(text_fromDate, ".");
    	/*int Tdate = Integer.parseInt(toDate);
    	Tdate=Tdate+30;
    	String ToDate=String.valueOf(Tdate);*/

    	enterKeys(text_toDate, "+30");
    	click(btn_btnNew);
        minWait();
    	    	        driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");
    	
    	click(yesBtn);
    	waitForFrameAndSwitch(screenFrame);
    	click(btn_targetAmountRadioButton);
    	
    	Assert.assertTrue(verifyElementPresent(dropdown_targetWeightBasis),"Object not found");
    	Assert.assertTrue(verifyElementPresent(dropdown_targetWeightUnit),"Object not found");
    	Assert.assertTrue(verifyElementPresent(text_targetWeight),"Object not found");
    	click(btn_btnClear);
    	minWait();
    	return this;
    }
    
    public CRA153 VerifyElements_PayoutWeight(String agentCode_new){

    	agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
	    
    	enterKeys(text_agentCode, agentCode_new);
    	enterKeys(text_fromDate, ".");
    	/*int Tdate = Integer.parseInt(toDate);
    	Tdate=Tdate+30;
    	String ToDate=String.valueOf(Tdate);*/

    	enterKeys(text_toDate, "+30");
    	click(btn_btnNew);
        minWait();
    	    	
    	
    	driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");
    	
    	click(yesBtn);
    	waitForFrameAndSwitch(screenFrame);
    	click(btn_targetAmountPayOut);
    	
    	Assert.assertTrue(verifyElementPresent(dropdown_payoutWeightUnit),"Object not found");
    	Assert.assertTrue(verifyElementPresent(text_payOutCurrency),"Object not found");
    	Assert.assertTrue(verifyElementPresent(dropdown_payoutWeightBasis),"Object not found");
    	click(btn_btnClear);
    	minWait();
    	return this;
    }
    public CRA153 VerifyElements_InTargetPanel(String agentCode_new){

    	agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
    	    
    	enterKeys(text_agentCode, agentCode_new);
    	enterKeys(text_fromDate, ".");
    	/*int Tdate = Integer.parseInt(toDate);
    	Tdate=Tdate+30;
    	String ToDate=String.valueOf(Tdate);*/

    	enterKeys(text_toDate, "+30");
    	click(btn_btnNew);
        minWait();
    	
    	
    	driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");
    	
    	click(yesBtn);
    	waitForFrameAndSwitch(screenFrame);
    	
    	Assert.assertTrue(verifyElementPresent(text_targetAmountBasis),"Object not found");
    	Assert.assertTrue(verifyElementPresent(text_targetCurrency),"Object not found");
    	Assert.assertTrue(verifyElementPresent(text_targetCurrency),"Object not found");
    	click(btn_btnClear);
    	minWait();
    	return this;
    }
    
    
    public CRA153 VerifyElements_InPayoutPanel(String agentCode_new){

    	agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
    
    	enterKeys(text_agentCode, agentCode_new);
    	enterKeys(text_fromDate, ".");
    	/*int Tdate = Integer.parseInt(toDate);
    	Tdate=Tdate+30;
    	String ToDate=String.valueOf(Tdate);*/

    	enterKeys(text_toDate, "+30");
    	click(btn_btnNew);
        minWait();
        
    	driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");
    	
    	click(yesBtn);
    	waitForFrameAndSwitch(screenFrame);
    	
    	Assert.assertTrue(verifyElementPresent(text_payOutCurrency),"Object not found");
    	Assert.assertTrue(verifyElementPresent(text_payOutAmountBasis),"Object not found");
    	
    	click(btn_btnClear);
    	minWait();
    	return this;
    }
    public CRA153 Agent_MandatoryError(){
    	Assert.assertTrue(verifyElementPresent(chkbox_incAWBSellLoc),"Object not found");
    	click(btn_btnNew);
    	minWait();
    	   driver.switchTo().defaultContent();
    	   Assert.assertTrue(waitForElement(info_msg).getText().contains("Agent Code is mandatory"),"The Agent code is not shown as mandatory field");
           if (verifyElementPresent(btn_ok)) {

               click(btn_ok);
               
           }
           
           waitForFrameAndSwitch(screenFrame);
    return this;	
    }
    
    public CRA153 ValidDates_MandatoryError(){
    	click(btn_agentCodelov);
    	minWait();
    	switchToSecondWindow();
    	String Agentname=getTableCellValue(tbl_agentCodeDetails, 2, 1);
    	System.out.println("Agent Name is: "+Agentname);
    	check(chk_agentCodelovcheckbox);
    	click(btn_agentCodelovbtOk);
    	minWait();
    	switchToFirstWindow();
    	waitForFrameAndSwitch(screenFrame);
    	enterKeys(text_fromDate,"");
    	enterKeys(text_toDate,"");
    	click(btn_btnNew);
    	minWait();
 	   driver.switchTo().defaultContent();
 	   Assert.assertTrue(waitForElement(info_msg).getText().contains("From Date and To Date are mandatory"),"The Valid dates is not shown as mandatory field");
        if (verifyElementPresent(btn_ok)) {

            click(btn_ok);
        }
        waitForFrameAndSwitch(screenFrame);
        click(btn_btnClear);
        minWait();
    return this;	
    }


    public CRA153 CheckAgentNameAutopopulated(){

    	
    	minWait();
click(btn_agentCodelov);
minWait();
switchToSecondWindow();
String Agentname=getTableCellValue(tbl_agentCodeDetails, 2, 1);
System.out.println("Agent Name is: "+Agentname);
check(chk_agentCodelovcheckbox);
click(btn_agentCodelovbtOk);

minWait();
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);

String a=waitForElement(text_agentCode).getAttribute("value");
System.out.println(a);
  	
     Assert.assertTrue(waitForElement(text_agentCode).getAttribute("value").contains(Agentname),"Agent noame is not auto populated");
    
    return this;	
    }
    
    
    public CRA153 CreateGSACommission_TerritoryLevel(String agentCode_new, String Origin,String currency,String FChargeAddn,String GSA_ID){

    	agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
    	Origin = PropertyHandler.getPropValue(dataFilePath, Origin);

    	
    	currency=PropertyHandler.getPropValue(dataFilePath, currency);
    	FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);
    	
    	
    	selectByText(dropdown_gsaType, "Territory");
    	minWait();
    	selectByText(dropdown_gsaTerritoryType, "Station");
    	enterKeys(text_gsaTerritoryCode, Origin);
    	enterKeys(text_gsaCode, agentCode_new);
    	
    	enterKeys(text_fromDate, ".");
    	/*int Tdate = Integer.parseInt(toDate);
    	Tdate=Tdate+30;
    	String ToDate=String.valueOf(Tdate);
*/
    	enterKeys(text_toDate, "+10");
    	click(btn_btnNew);
    	minWait();
    	
    	
    	driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");
    	
    	click(yesBtn);
    	waitForFrameAndSwitch(screenFrame);
    	
    	selectByText(dropdown_payOutFrequency,"Bi-Monthly");
    	click(btn_chargeBasisLov);
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(chkbox_chargebasis);
    	click(btn_Chargebasisok);
        switchToFirstWindow();
    	waitForFrameAndSwitch(screenFrame);


    	enterKeys(text_targetAmount, "50");
    	enterKeys(text_targetCurrency, currency);
    	enterKeys(text_payOutCurrency, currency);
    	click(btn_chargeBasisLovPayout);
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(chkbox_chargebasispayout);
    	click(btn_Chargebasispayoutok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(screenFrame);
    	click(btn_addLinkamt);
    	minWait();
    	enterKeys(text_fromAmount1, "0");
    	enterKeys(text_toAmount1, FChargeAddn);
    	int FCA = Integer.parseInt(FChargeAddn);
    	FCA=FCA+1;
    	String frmrange2=String.valueOf(FCA);
    	enterKeys(text_percentage1, "2");
    	click(btn_addLinkamt);
    	minWait();
    	enterKeys(text_fromAmount2, frmrange2);
    	enterKeys(text_toAmount2, "0");
    	enterKeys(text_percentage2, "5");

    	click(btn_btnGenerate);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(screenFrame);

    	click(btn_gsaCommissionLov);
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(text_gsaCommissionLovagentCode, agentCode_new);
    	selectByText(dropdown_gsaCommissionLovgsaStatus, "New");
    	click(btn_gsaCommissionLovlistButton);
    	minWait();
    	check(chkbox_gsaCommissionLovselectCheckBox);
    	click(btn_gsaCommissionLovokButton);
        switchToFirstWindow();
    	waitForFrameAndSwitch(screenFrame);
    	String GSACommID=(waitForElement(text_gsaCommissionId).getAttribute("value"));
    	System.out.println("GSACommission_ID:"+GSACommID);
    	FChargeAddn=PropertyHandler.setPropValue(dataFilePath, GSA_ID, GSACommID);
    	click(btn_btnDisplay);
    	minWait();
    	Assert.assertTrue(waitForElement(text_targetCurrency).getAttribute("value").contains(currency),"Error: The currency doesnot match");
    	click(btn_btnActive);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(yesBtn);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(screenFrame);
    	Assert.assertTrue(waitForElement(div_status).getText().contains("Status : Active"),"Error: The satus is not Active");
    	click(btn_btnClear);
    	minWait();
    	return this;
    	


    	}
    public CRA153 CreateGSACommission_TargetWeight(String agentCode_new,String currency,String FChargeAddn,String GSA_ID){

    	agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);



    	currency=PropertyHandler.getPropValue(dataFilePath, currency);
    	FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);

    	enterKeys(text_agentCode, agentCode_new);
    	enterKeys(text_fromDate, ".");
    	/*int Tdate = Integer.parseInt(toDate);
    	Tdate=Tdate+30;
    	String ToDate=String.valueOf(Tdate);
    	*/
    	enterKeys(text_toDate, "+10");
    	click(btn_btnNew);
    	minWait();



    	driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");

    	click(yesBtn);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(screenFrame);
    	selectByText(dropdown_payOutFrequency, "Bi-Monthly");
    	click(btn_targetWeightRadioButton);
    	minWait();
    	selectByText(dropdown_targetWeightBasis, "Chargeable Weight");
    	enterKeys(text_targetWeight,"50");
    	

    	click(btn_payOutWeight);
    	minWait();
    	selectByText(dropdown_payoutWeightBasis, "Chargeable Weight");
    	
    	check(chkbox_chargebasispayout);
    	click(btn_Chargebasispayoutok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(screenFrame);
    	click(btn_addLinkamt);
    	minWait();
    	enterKeys(text_fromAmount1, "0");
    	enterKeys(text_toAmount1, FChargeAddn);
    	int FCA = Integer.parseInt(FChargeAddn);
    	FCA=FCA+1;
    	String frmrange2=String.valueOf(FCA);
    	enterKeys(text_percentage1, "2");
    	click(btn_addLinkamt);
    	minWait();
    	enterKeys(text_fromAmount2, frmrange2);
    	enterKeys(text_toAmount2, "0");
    	enterKeys(text_percentage2, "5");

    	click(btn_btnGenerate);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(screenFrame);

    	click(btn_gsaCommissionLov);
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(text_gsaCommissionLovagentCode, agentCode_new);
    	selectByText(dropdown_gsaCommissionLovgsaStatus, "New");
    	click(btn_gsaCommissionLovlistButton);
    	minWait();
    	check(chkbox_gsaCommissionLovselectCheckBox);
    	click(btn_gsaCommissionLovokButton);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(screenFrame);
    	String GSACommID=(waitForElement(text_gsaCommissionId).getAttribute("value"));
    	System.out.println("GSACommission_ID:"+GSACommID);
    	FChargeAddn=PropertyHandler.setPropValue(dataFilePath, GSA_ID, GSACommID);
    	click(btn_btnDisplay);
    	minWait();

    	Assert.assertTrue(waitForElement(div_status).getText().contains("Status : New"),"Error: The satus is not New");

    	click(btn_btnActive);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(yesBtn);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(screenFrame);
    	Assert.assertTrue(waitForElement(div_status).getText().contains("Status : Active"),"Error: The satus is not Active");
    	click(btn_btnClear);
    	minWait();
    	return this;


    	}

public CRA153 CreateGSACommission(String agentCode_new,String currency,String FChargeAddn,String GSA_ID){

agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);



currency=PropertyHandler.getPropValue(dataFilePath, currency);
FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);

enterKeys(text_agentCode, agentCode_new);
enterKeys(text_fromDate, ".");
/*int Tdate = Integer.parseInt(toDate);
Tdate=Tdate+30;
String ToDate=String.valueOf(Tdate);
*/
enterKeys(text_toDate, "+10");
click(btn_btnNew);
minWait();



driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");

click(yesBtn);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
selectByText(dropdown_payOutFrequency, "Bi-Monthly");
click(btn_chargeBasisLov);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_chargebasis);
click(btn_Chargebasisok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);


enterKeys(text_targetAmount, "50");
enterKeys(text_targetCurrency, currency);
enterKeys(text_payOutCurrency, currency);
click(btn_chargeBasisLovPayout);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_chargebasispayout);
click(btn_Chargebasispayoutok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount1, "0");
enterKeys(text_toAmount1, FChargeAddn);
int FCA = Integer.parseInt(FChargeAddn);
FCA=FCA+1;
String frmrange2=String.valueOf(FCA);
enterKeys(text_percentage1, "2");
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount2, frmrange2);
enterKeys(text_toAmount2, "0");
enterKeys(text_percentage2, "5");

click(btn_btnGenerate);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);

click(btn_gsaCommissionLov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_gsaCommissionLovagentCode, agentCode_new);
selectByText(dropdown_gsaCommissionLovgsaStatus, "New");
click(btn_gsaCommissionLovlistButton);
minWait();
check(chkbox_gsaCommissionLovselectCheckBox);
click(btn_gsaCommissionLovokButton);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
String GSACommID=(waitForElement(text_gsaCommissionId).getAttribute("value"));
System.out.println("GSACommission_ID:"+GSACommID);
FChargeAddn=PropertyHandler.setPropValue(dataFilePath, GSA_ID, GSACommID);
click(btn_btnDisplay);
minWait();

Assert.assertTrue(waitForElement(div_status).getText().contains("Status : New"),"Error: The satus is not New");

click(btn_btnActive);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
Assert.assertTrue(waitForElement(div_status).getText().contains("Status : Active"),"Error: The satus is not Active");
click(btn_btnClear);
minWait();
return this;


}


public CRA153 CreateGSACommissionDifferentCases(String agentCode_new,String currency,String FChargeAddn,String GSA_ID,String Case){

agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);



currency=PropertyHandler.getPropValue(dataFilePath, currency);
FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);

enterKeys(text_agentCode, agentCode_new);
enterKeys(text_fromDate, ".");
/*int Tdate = Integer.parseInt(toDate);
Tdate=Tdate+30;
String ToDate=String.valueOf(Tdate);
*/
enterKeys(text_toDate, "+10");
click(btn_btnNew);
minWait();



driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");

click(yesBtn);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
selectByText(dropdown_payOutFrequency, "Bi-Monthly");
click(btn_chargeBasisLov);
waitForNewWindow(2);
switchToSecondWindow();
if(Case=="IATAVal"){
	
	
	check(chkbox_chargebasisIATA);
	selectByText(tbl_ChargebasisValChrg, "+");
	check(chkbox_chargebasisValChrg);
	
}
else if(Case=="MarVal")
{
	
	check(chkbox_chargebasis);
	selectByText(tbl_ChargebasisValChrg, "+");
	check(chkbox_chargebasisValChrg);
	

}
click(btn_Chargebasisok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
enterKeys(text_targetAmount, "50");
enterKeys(text_targetCurrency, currency);
enterKeys(text_payOutCurrency, currency);
click(btn_chargeBasisLovPayout);
waitForNewWindow(2);
switchToSecondWindow();
if(Case=="IATAVal"){
	
	check(chkbox_chargebasisIATA);
	selectByText(tbl_ChargebasisValChrg, "+");
	check(chkbox_chargebasisValChrg);
	

}
if(Case=="IATAVal"){
	
	check(chkbox_chargebasisIATA);
	selectByText(tbl_ChargebasisValChrg, "+");
	check(chkbox_chargebasisValChrg);
	
}



check(chkbox_chargebasispayout);
click(btn_Chargebasispayoutok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount1, "0");
enterKeys(text_toAmount1, FChargeAddn);
int FCA = Integer.parseInt(FChargeAddn);
FCA=FCA+1;
String frmrange2=String.valueOf(FCA);
enterKeys(text_percentage1, "2");
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount2, frmrange2);
enterKeys(text_toAmount2, "0");
enterKeys(text_percentage2, "5");

click(btn_btnGenerate);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);

click(btn_gsaCommissionLov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_gsaCommissionLovagentCode, agentCode_new);
selectByText(dropdown_gsaCommissionLovgsaStatus, "New");
click(btn_gsaCommissionLovlistButton);
minWait();
check(chkbox_gsaCommissionLovselectCheckBox);
click(btn_gsaCommissionLovokButton);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
String GSACommID=(waitForElement(text_gsaCommissionId).getAttribute("value"));
System.out.println("GSACommission_ID:"+GSACommID);
FChargeAddn=PropertyHandler.setPropValue(dataFilePath, GSA_ID, GSACommID);
click(btn_btnDisplay);
minWait();

Assert.assertTrue(waitForElement(div_status).getText().contains("Status : New"),"Error: The satus is not New");

click(btn_btnActive);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
Assert.assertTrue(waitForElement(div_status).getText().contains("Status : Active"),"Error: The satus is not Active");
click(btn_btnClear);
minWait();
return this;


}
public CRA153 CreateGSACommissionDifferentCasesControllingAgent(String agentCode_new,String currency,String FChargeAddn,String GSA_ID,String Case){

agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);



currency=PropertyHandler.getPropValue(dataFilePath, currency);
FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);

enterKeys(text_agentCode, agentCode_new);
enterKeys(text_fromDate, ".");
/*int Tdate = Integer.parseInt(toDate);
Tdate=Tdate+30;
String ToDate=String.valueOf(Tdate);
*/
enterKeys(text_toDate, "+10");
click(btn_btnNew);
minWait();



driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");

click(yesBtn);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
check(chkbox_incAWBSellLoc);
selectByText(dropdown_payOutFrequency, "Bi-Monthly");
click(btn_chargeBasisLov);
waitForNewWindow(2);
switchToSecondWindow();
if(Case=="IATAVal"){
	
	
	check(chkbox_chargebasisIATA);
	selectByText(tbl_ChargebasisValChrg, "+");
	check(chkbox_chargebasisValChrg);
	
}
else if(Case=="MarVal")
{
	
	check(chkbox_chargebasis);
	selectByText(tbl_ChargebasisValChrg, "+");
	check(chkbox_chargebasisValChrg);
	

}
click(btn_Chargebasisok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
enterKeys(text_targetAmount, "50");
enterKeys(text_targetCurrency, currency);
enterKeys(text_payOutCurrency, currency);
click(btn_chargeBasisLovPayout);
waitForNewWindow(2);
switchToSecondWindow();
if(Case=="IATAVal"){
	
	check(chkbox_chargebasisIATA);
	selectByText(tbl_ChargebasisValChrg, "+");
	check(chkbox_chargebasisValChrg);
	

}
if(Case=="IATAVal"){
	
	check(chkbox_chargebasisIATA);
	selectByText(tbl_ChargebasisValChrg, "+");
	check(chkbox_chargebasisValChrg);
	
}



check(chkbox_chargebasispayout);
click(btn_Chargebasispayoutok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount1, "0");
enterKeys(text_toAmount1, FChargeAddn);
int FCA = Integer.parseInt(FChargeAddn);
FCA=FCA+1;
String frmrange2=String.valueOf(FCA);
enterKeys(text_percentage1, "2");
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount2, frmrange2);
enterKeys(text_toAmount2, "0");
enterKeys(text_percentage2, "5");

click(btn_btnGenerate);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);

click(btn_gsaCommissionLov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_gsaCommissionLovagentCode, agentCode_new);
selectByText(dropdown_gsaCommissionLovgsaStatus, "New");
click(btn_gsaCommissionLovlistButton);
minWait();
check(chkbox_gsaCommissionLovselectCheckBox);
click(btn_gsaCommissionLovokButton);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
String GSACommID=(waitForElement(text_gsaCommissionId).getAttribute("value"));
System.out.println("GSACommission_ID:"+GSACommID);
FChargeAddn=PropertyHandler.setPropValue(dataFilePath, GSA_ID, GSACommID);
click(btn_btnDisplay);
minWait();

Assert.assertTrue(waitForElement(div_status).getText().contains("Status : New"),"Error: The satus is not New");

click(btn_btnActive);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
Assert.assertTrue(waitForElement(div_status).getText().contains("Status : Active"),"Error: The satus is not Active");
click(btn_btnClear);
minWait();
return this;


}

public CRA153 CreateGSACommission_ControllingAgent(String Cntrl_Agent,String currency,String FChargeAddn,String GSA_ID){

	Cntrl_Agent = PropertyHandler.getPropValue(dataFilePath, Cntrl_Agent);
currency=PropertyHandler.getPropValue(dataFilePath, currency);
FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);

enterKeys(text_agentCode, Cntrl_Agent);
enterKeys(text_fromDate, ".");
/*int Tdate = Integer.parseInt(toDate);
Tdate=Tdate+30;
String ToDate=String.valueOf(Tdate);
*/
enterKeys(text_toDate, "+10");
click(btn_btnNew);
minWait();



driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");

click(yesBtn);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
check(chkbox_incAWBSellLoc);
selectByText(dropdown_payOutFrequency, "Bi-Monthly");
click(btn_chargeBasisLov);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_chargebasis);
click(btn_Chargebasisok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);


enterKeys(text_targetAmount, "50");
enterKeys(text_targetCurrency, currency);
enterKeys(text_payOutCurrency, currency);
click(btn_chargeBasisLovPayout);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_chargebasispayout);
click(btn_Chargebasispayoutok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount1, "0");
enterKeys(text_toAmount1, FChargeAddn);
int FCA = Integer.parseInt(FChargeAddn);
FCA=FCA+1;
String frmrange2=String.valueOf(FCA);
enterKeys(text_percentage1, "2");
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount2, frmrange2);
enterKeys(text_toAmount2, "0");
enterKeys(text_percentage2, "5");

click(btn_btnGenerate);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);

click(btn_gsaCommissionLov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_gsaCommissionLovagentCode, Cntrl_Agent);
selectByText(dropdown_gsaCommissionLovgsaStatus, "New");
click(btn_gsaCommissionLovlistButton);
minWait();
check(chkbox_gsaCommissionLovselectCheckBox);
click(btn_gsaCommissionLovokButton);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
String GSACommID=(waitForElement(text_gsaCommissionId).getAttribute("value"));
System.out.println("GSACommission_ID:"+GSACommID);
FChargeAddn=PropertyHandler.setPropValue(dataFilePath, GSA_ID, GSACommID);
click(btn_btnDisplay);
minWait();

Assert.assertTrue(waitForElement(div_status).getText().contains("Status : New"),"Error: The satus is not New");

click(btn_btnActive);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
Assert.assertTrue(waitForElement(div_status).getText().contains("Status : Active"),"Error: The satus is not Active");
click(btn_btnClear);
minWait();
return this;


}

public CRA153 GSA_ErrorCntrlAgent_SellingLocnChecked(String agentCode_new,String currency,String FChargeAddn){

	agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
currency=PropertyHandler.getPropValue(dataFilePath, currency);
FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);

enterKeys(text_agentCode, agentCode_new);
enterKeys(text_fromDate, ".");
/*int Tdate = Integer.parseInt(toDate);
Tdate=Tdate+30;
String ToDate=String.valueOf(Tdate);
*/
enterKeys(text_toDate, "+10");
click(btn_btnNew);
minWait();



driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");

click(yesBtn);
waitForFrameAndSwitch(screenFrame);
check(chkbox_incAWBSellLoc);
selectByText(dropdown_payOutFrequency, "Bi-Monthly");
click(btn_chargeBasisLov);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_chargebasis);
click(btn_Chargebasisok);
switchToFirstWindow();

waitForFrameAndSwitch(screenFrame);


enterKeys(text_targetAmount, "50");
enterKeys(text_targetCurrency, currency);
enterKeys(text_payOutCurrency, currency);
click(btn_chargeBasisLovPayout);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_chargebasispayout);
click(btn_Chargebasispayoutok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount1, "0");
enterKeys(text_toAmount1, FChargeAddn);
int FCA = Integer.parseInt(FChargeAddn);
FCA=FCA+1;
String frmrange2=String.valueOf(FCA);
enterKeys(text_percentage1, "2");
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount2, frmrange2);
enterKeys(text_toAmount2, "0");
enterKeys(text_percentage2, "5");

click(btn_btnGenerate);
minWait();

Assert.assertTrue(waitForElement(info_error).getText().contains("The specified agent is not a controlling location"),"Error: The Agent is not a controlling location");

click(btn_btnClear);
minWait();

return this;


}

public CRA153 SaveGSA_Commission(String agentCode_new,String currency,String FChargeAddn,String GSA_ID){

agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
currency=PropertyHandler.getPropValue(dataFilePath, currency);
FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);

enterKeys(text_agentCode, agentCode_new);
enterKeys(text_fromDate, ".");
/*int Tdate = Integer.parseInt(toDate);
Tdate=Tdate+30;
String ToDate=String.valueOf(Tdate);
*/
enterKeys(text_toDate, "+10");
click(btn_btnNew);
minWait();


driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");

click(yesBtn);
waitForFrameAndSwitch(screenFrame);

selectByText(dropdown_payOutFrequency, "Bi-Monthly");
click(btn_chargeBasisLov);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_chargebasis);
click(btn_Chargebasisok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);


enterKeys(text_targetAmount, "50");

enterKeys(text_targetCurrency, currency);
enterKeys(text_payOutCurrency, currency);
click(btn_chargeBasisLovPayout);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_chargebasispayout);
click(btn_Chargebasispayoutok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount1, "0");
enterKeys(text_toAmount1, FChargeAddn);
int FCA = Integer.parseInt(FChargeAddn);
FCA=FCA+1;
String frmrange2=String.valueOf(FCA);
enterKeys(text_percentage1, "2");
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount2, frmrange2);
enterKeys(text_toAmount2, "0");
enterKeys(text_percentage2, "5");

click(btn_btnGenerate);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);

click(btn_gsaCommissionLov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_gsaCommissionLovagentCode, agentCode_new);
selectByText(dropdown_gsaCommissionLovgsaStatus, "New");
click(btn_gsaCommissionLovlistButton);
minWait();
check(chkbox_gsaCommissionLovselectCheckBox);
click(btn_gsaCommissionLovokButton);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
String GSACommID=(waitForElement(text_gsaCommissionId).getAttribute("value"));
System.out.println("GSACommission_ID:"+GSACommID);
PropertyHandler.setPropValue(dataFilePath, GSA_ID, GSACommID);
click(btn_btnDisplay);
minWait();

click(btn_btnClear);
minWait();
return this;


}
public CRA153 SaveDuplicateGSA_Error(String agentCode_new,String currency,String FChargeAddn){

agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
currency=PropertyHandler.getPropValue(dataFilePath, currency);
FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);

enterKeys(text_agentCode, agentCode_new);
enterKeys(text_fromDate, ".");
/*int Tdate = Integer.parseInt(toDate);
Tdate=Tdate+30;
String ToDate=String.valueOf(Tdate);*/

enterKeys(text_toDate, "+10");
click(btn_btnNew);
minWait();


driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to generate new GSA Commission Id?"),"Error: New GSA commission ID");

click(yesBtn);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);

selectByText(dropdown_payOutFrequency, "Bi-Monthly");
click(btn_chargeBasisLov);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_chargebasis);
click(btn_Chargebasisok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);


enterKeys(text_targetAmount, "50");
enterKeys(text_targetCurrency, currency);
enterKeys(text_payOutCurrency, currency);
click(btn_chargeBasisLovPayout);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_chargebasispayout);
click(btn_Chargebasispayoutok);
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount1, "0");
enterKeys(text_toAmount1, FChargeAddn);
int FCA = Integer.parseInt(FChargeAddn);
FCA=FCA+1;
String frmrange2=String.valueOf(FCA);
enterKeys(text_percentage1, "2");
click(btn_addLinkamt);
minWait();
enterKeys(text_fromAmount2, frmrange2);
enterKeys(text_toAmount2, "0");
enterKeys(text_percentage2, "5");

click(btn_btnGenerate);
minWait();

Assert.assertTrue(waitForElement(info_error).getText().contains("Two GSA Commission ID cannot be created/activated for the same agent for overlapping Validity period"),"Error: Two GSA cpmmission with overlapping validity periods can be created");
click(btn_btnClear);
minWait();
return this;


}
public CRA153 CheckActiveGSACommission_Editable(String GSA_ID){

	GSA_ID = PropertyHandler.getPropValue(dataFilePath, GSA_ID);
	click(btn_gsaCommissionLov);
	waitForNewWindow(2);
	switchToSecondWindow();
	selectByText(dropdown_gsaCommissionLovgsaStatus, "Active");
	click(btn_gsaCommissionLovlistButton);
	minWait();
    tblSelectRowByColValue(tbl_lovListTable, 1, 3, GSA_ID);
	
	
	click(btn_gsaCommissionLovokButton);
	switchToFirstWindow();

	waitForFrameAndSwitch(screenFrame);
	
	
	click(btn_btnDisplay);
	minWait();
String p= waitForElementVisible(text_targetAmount).getAttribute("disabled");
System.out.println(p);
Assert.assertTrue(p.contains("true"),"Error: The text field is not disabled for active GSA");
  click(btn_btnClear);
  minWait();
	
return this;
}

public CRA153 Modify_SavedGSA(String GSA_ID){

	GSA_ID = PropertyHandler.getPropValue(dataFilePath, GSA_ID);
	click(btn_gsaCommissionLov);
	waitForNewWindow(2);
	switchToSecondWindow();
	selectByText(dropdown_gsaCommissionLovgsaStatus, "Active");
	click(btn_gsaCommissionLovlistButton);
	minWait();
    tblSelectRowByColValue(tbl_lovListTable, 1, 3, GSA_ID);
	
	
	click(btn_gsaCommissionLovokButton);

	waitForFrameAndSwitch(screenFrame);
	
	
	click(btn_btnDisplay);
	minWait();
    enterKeys(text_targetAmount, "100");
    
    click(btn_btnGenerate);
     minWait();
     driver.switchTo().defaultContent();
     click(btn_ok);
          
     waitForFrameAndSwitch(screenFrame);
	
return this;
}
public CRA153 InactivateGSA_Commission(String GSA_ID){

	GSA_ID = PropertyHandler.getPropValue(dataFilePath, GSA_ID);
	click(btn_gsaCommissionLov);
	waitForNewWindow(2);
	switchToSecondWindow();
	
	selectByText(dropdown_gsaCommissionLovgsaStatus, "Active");
	click(btn_gsaCommissionLovlistButton);
	minWait();
    tblSelectRowByColValue(tbl_lovListTable, 1, 3, GSA_ID);
	
	
	click(btn_gsaCommissionLovokButton);
   switchToFirstWindow();
	waitForFrameAndSwitch(screenFrame);
	
	
	click(btn_btnDisplay);
	minWait();
	
	Assert.assertFalse(driver.findElement(btn_btnActive).isEnabled(),"Error: The Active button is enabled status");

	click(btn_btnInactive);
	minWait();
	 driver.switchTo().defaultContent();
	 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want change the status to Inactive?"),"Error: Not able to inactivate the GSA commission");
     click(yesBtn);
     minWait();
     driver.switchTo().defaultContent();
     click(btn_ok);
     switchToFirstWindow();
     waitForFrameAndSwitch(screenFrame);

     Assert.assertTrue(waitForElement(div_status).getText().contains("Status : Inactive"),"Error: The satus is not Inactive");
	click(btn_btnClear);
	minWait();
return this;
}
public CRA153 Delete_SavedGSA(String GSA_ID){

	GSA_ID = PropertyHandler.getPropValue(dataFilePath, GSA_ID);
	click(btn_gsaCommissionLov);
	waitForNewWindow(2);
	switchToSecondWindow();
	
	selectByText(dropdown_gsaCommissionLovgsaStatus, "New");
	click(btn_gsaCommissionLovlistButton);
	minWait();
	
    tblSelectRowByColValue(tbl_lovListTable, 1, 3, GSA_ID);
	
	
	click(btn_gsaCommissionLovokButton);
	switchToFirstWindow();

	waitForFrameAndSwitch(screenFrame);
	
	
	click(btn_btnDisplay);
	minWait();
	
	

	click(btn_btnDelete);
	 driver.switchTo().defaultContent();
	 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to delete ?"),"Error: Not able to delete the GSA commission");
     click(yesBtn);
     minWait();
     driver.switchTo().defaultContent();
    System.out.println(info_msg);
    
     Assert.assertTrue(waitForElement(info_msg).getText().contains("GSACommission Id "+ GSA_ID+ " deleted successfully"),"Error: The satus is not Inactive");
     click(btn_ok);
     minWait();
     driver.switchTo().defaultContent();
    
     switchToFirstWindow();
     
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
