package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


/**
 * Screen OPR026 - CAPTURE AWB
 * Created on 21/12/2017
 *
 * @author a-7868
 */
public class CRA054 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA054";
    public static String screenFrame = "iCargoContentFrameCRA054";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String  genObjPath= PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By yesBtn,btn_volincLov,text_factor,text_avgTruckCostPerUnit,btn_addLink,
    btn_ok,text_volincLovvolumeIncentiveId,text_destinationCityCode,chk_headChk,
    btn_commissionlovlistButton,dropdown_destLevel,btn_activateButton,tbl_paymentDetails,
    chkbox_volincLovselectCheckBox,txt_originCityCode,btn_btnSave,
    btn_volincLovokButton,dropdown_originDestinationLevel,text_toDate,dropdown_statusFilter,
    btn_btnGenerate,text_destCityCode,btn_btnList,text_fromdate,btn_cancelButton,
    btn_btnClose,text_currencyCode,dropdown_weightUnit;

   
   
    public CRA054(WebDriver driver, String dataFileName) {
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
    	dropdown_originDestinationLevel=MiscUtility.getWebElement(objFilepath, "CRA054_dropdown_originDestinationLevel");
    	txt_originCityCode=MiscUtility.getWebElement(objFilepath, "CRA054_txt_originCityCode");
    	dropdown_destLevel=MiscUtility.getWebElement(objFilepath, "CRA054_dropdown_destLevel");
    	text_destCityCode=MiscUtility.getWebElement(objFilepath, "CRA054_text_destCityCode");
    	btn_btnList=MiscUtility.getWebElement(objFilepath, "CRA054_btn_btnList");
    	text_factor=MiscUtility.getWebElement(objFilepath, "CRA054_text_factor");
    	text_currencyCode=MiscUtility.getWebElement(objFilepath, "CRA054_text_currencyCode");
    	text_destinationCityCode=MiscUtility.getWebElement(objFilepath, "CRA054_text_destinationCityCode");
    	text_avgTruckCostPerUnit=MiscUtility.getWebElement(objFilepath, "CRA054_text_avgTruckCostPerUnit");
    	dropdown_weightUnit=MiscUtility.getWebElement(objFilepath, "CRA054_dropdown_weightUnit");
    	text_fromdate=MiscUtility.getWebElement(objFilepath, "CRA054_text_fromdate");
    	text_toDate=MiscUtility.getWebElement(objFilepath, "CRA054_text_toDate");
    	btn_btnSave=MiscUtility.getWebElement(objFilepath, "CRA054_btn_btnSave");
    	btn_activateButton=MiscUtility.getWebElement(objFilepath, "CRA054_btn_activateButton");
    	chk_headChk=MiscUtility.getWebElement(objFilepath, "CRA054_chk_headChk");
    	btn_addLink=MiscUtility.getWebElement(objFilepath, "CRA054_btn_addLink");
    	btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA054_btn_btnClose");
    	tbl_paymentDetails=MiscUtility.getWebElement(objFilepath, "CRA054_tbl_paymentDetails");
    	btn_cancelButton=MiscUtility.getWebElement(objFilepath, "CRA054_btn_cancelButton");
    	dropdown_statusFilter=MiscUtility.getWebElement(objFilepath, "CRA054_dropdown_statusFilter");
    }
  

public CRA054 Check_Store_CancelProrateDetails(String level,String origin,String dest,String ProrateFactor,String ProrateCurr,String avgTruckCostPerUnit,String weightUnit,String fromdate,String toDate){
	
	level = PropertyHandler.getPropValue(dataFilePath, level);
	origin = PropertyHandler.getPropValue(dataFilePath, origin);
	dest = PropertyHandler.getPropValue(dataFilePath, dest);
selectByText(dropdown_originDestinationLevel, level);
enterKeys(txt_originCityCode, origin);
selectByText(dropdown_destLevel, level);
enterKeys(text_destCityCode, dest);
click(btn_btnList);
minWait();
driver.switchTo().defaultContent();
if (verifyElementPresent(yesBtn)) {
System.out.println("Prorate doesnot exists");
    click(yesBtn);
    minWait();
    driver.switchTo().defaultContent();
 
}
String Pfactor=waitForElement(text_factor).getText();
System.out.println("Prorate Factor stored: "+Pfactor);
String Currency=waitForElement(text_currencyCode).getText();
System.out.println("Currency stored: "+Currency);
String Cost=waitForElement(text_avgTruckCostPerUnit).getText();
System.out.println("Avg truck cost per Unit stored: "+Cost);
String Unit=getSelectedValue(dropdown_weightUnit);
System.out.println("Weight Unit stored: "+Unit);
String Fdate=waitForElement(text_fromdate).getText();
System.out.println("From date stored: "+Fdate);
String Tdate=waitForElement(text_toDate).getText();
System.out.println("To date stored: "+Tdate);
PropertyHandler.setPropValue(dataFilePath, ProrateFactor, Pfactor);
PropertyHandler.setPropValue(dataFilePath, ProrateCurr, Currency);
PropertyHandler.setPropValue(dataFilePath, avgTruckCostPerUnit, Cost);
PropertyHandler.setPropValue(dataFilePath, weightUnit, Unit);
PropertyHandler.setPropValue(dataFilePath, fromdate, Fdate);
PropertyHandler.setPropValue(dataFilePath, toDate, Tdate);
minWait();

check(chk_headChk);
click(btn_cancelButton);
minWait();
tblSelectRowByColValue(tbl_paymentDetails, 1, 8, "Canceled");

return this;


}
public CRA054 CheckThenAddProrateDetailsandActivate(String level,String origin,String dest,String ProrateFactor,String ProrateCurr,String avgTruckCostPerUnit,String weightUnit,String fromdate,String toDate){
	
	level = PropertyHandler.getPropValue(dataFilePath, level);
	origin = PropertyHandler.getPropValue(dataFilePath, origin);
	dest = PropertyHandler.getPropValue(dataFilePath, dest);
	ProrateFactor=PropertyHandler.getPropValue(dataFilePath, ProrateFactor);
	ProrateCurr=PropertyHandler.getPropValue(dataFilePath, ProrateCurr);
	avgTruckCostPerUnit=PropertyHandler.getPropValue(dataFilePath, avgTruckCostPerUnit);
	weightUnit=PropertyHandler.getPropValue(dataFilePath, weightUnit);
	fromdate=PropertyHandler.getPropValue(dataFilePath, fromdate);
	toDate=PropertyHandler.getPropValue(dataFilePath, toDate);

selectByText(dropdown_originDestinationLevel, level);
enterKeys(txt_originCityCode, origin);
selectByText(dropdown_destLevel, level);
enterKeys(text_destCityCode, dest);
click(btn_btnList);
minWait();
driver.switchTo().defaultContent();
if (verifyElementPresent(yesBtn)) {

    click(yesBtn);
    driver.switchTo().defaultContent();

click(btn_addLink);
enterKeys(text_factor, ProrateFactor);
enterKeys(text_currencyCode, ProrateCurr);
enterKeys(text_avgTruckCostPerUnit, avgTruckCostPerUnit);
selectByText(dropdown_weightUnit, weightUnit);
enterKeys(text_fromdate, fromdate);
enterKeys(text_toDate, toDate);
click(btn_btnSave);
minWait();
selectByText(dropdown_originDestinationLevel, level);
enterKeys(txt_originCityCode, origin);
selectByText(dropdown_destLevel, level);
enterKeys(text_destCityCode, dest);
click(btn_btnList);
minWait();
check(chk_headChk);
click(btn_activateButton);
minWait();
tblSelectRowByColValue(tbl_paymentDetails, 1, 8, "Active");
}
tblSelectRowByColValue(tbl_paymentDetails, 1, 8, "Active");
System.out.println("Prorate factor already exists for the route");


return this;


}

public CRA054 AddProrateDetailsandActivate(String level,String origin,String dest,String ProrateFactor,String ProrateCurr,String avgTruckCostPerUnit,String weightUnit,String fromdate,String toDate){
	
	level = PropertyHandler.getPropValue(dataFilePath, level);
	origin = PropertyHandler.getPropValue(dataFilePath, origin);
	dest = PropertyHandler.getPropValue(dataFilePath, dest);
	ProrateFactor=PropertyHandler.getPropValue(dataFilePath, ProrateFactor);
	ProrateCurr=PropertyHandler.getPropValue(dataFilePath, ProrateCurr);
	avgTruckCostPerUnit=PropertyHandler.getPropValue(dataFilePath, avgTruckCostPerUnit);
	weightUnit=PropertyHandler.getPropValue(dataFilePath, weightUnit);
	fromdate=PropertyHandler.getPropValue(dataFilePath, fromdate);
	toDate=PropertyHandler.getPropValue(dataFilePath, toDate);

selectByText(dropdown_originDestinationLevel, level);
enterKeys(txt_originCityCode, origin);
selectByText(dropdown_destLevel, level);
enterKeys(text_destCityCode, dest);
click(btn_btnList);
selectByText(dropdown_statusFilter, "Active");
minWait();
driver.switchTo().defaultContent();
if (verifyElementPresent(yesBtn)) {

    click(yesBtn);
    driver.switchTo().defaultContent();

click(btn_addLink);
enterKeys(text_factor, ProrateFactor);
enterKeys(text_currencyCode, ProrateCurr);
enterKeys(text_avgTruckCostPerUnit, avgTruckCostPerUnit);
selectByText(dropdown_weightUnit, weightUnit);
enterKeys(text_fromdate, fromdate);
enterKeys(text_toDate, toDate);
click(btn_btnSave);
minWait();
selectByText(dropdown_originDestinationLevel, level);
enterKeys(txt_originCityCode, origin);
selectByText(dropdown_destLevel, level);
enterKeys(text_destCityCode, dest);
click(btn_btnList);
minWait();
check(chk_headChk);
click(btn_activateButton);
minWait();
tblSelectRowByColValue(tbl_paymentDetails, 1, 8, "Active");
}

System.out.println("Prorate factor already exists for the route");


return this;


}

public CRA054 CancelProrateFactor(String level,String origin,String dest,String ProrateFactor,String ProrateCurr,String avgTruckCostPerUnit,String weightUnit,String fromdate,String toDate){
	
	level = PropertyHandler.getPropValue(dataFilePath, level);
	origin = PropertyHandler.getPropValue(dataFilePath, origin);
	dest = PropertyHandler.getPropValue(dataFilePath, dest);
	ProrateFactor=PropertyHandler.getPropValue(dataFilePath, ProrateFactor);
	ProrateCurr=PropertyHandler.getPropValue(dataFilePath, ProrateCurr);
	avgTruckCostPerUnit=PropertyHandler.getPropValue(dataFilePath, avgTruckCostPerUnit);
	weightUnit=PropertyHandler.getPropValue(dataFilePath, weightUnit);
	fromdate=PropertyHandler.getPropValue(dataFilePath, fromdate);
	toDate=PropertyHandler.getPropValue(dataFilePath, toDate);

selectByText(dropdown_originDestinationLevel, level);
enterKeys(txt_originCityCode, origin);
selectByText(dropdown_destLevel, level);
enterKeys(text_destCityCode, dest);
click(btn_btnList);
minWait();

check(chk_headChk);
click(btn_cancelButton);
minWait();
tblSelectRowByColValue(tbl_paymentDetails, 1, 8, "Canceled");



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
