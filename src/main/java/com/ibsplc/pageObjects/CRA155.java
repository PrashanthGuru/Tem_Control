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
public class CRA155 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA155";
    public static String screenFrame = "iCargoContentFrameCRA155";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String  genObjPath= PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By yesBtn,dropdown_gsaTerritoryType,info_error,
    btn_ok,text_gsaTerritoryCode,
    btn_gsalov,text_gsalovmasterID,btn_gsalovlistButton,
    chkbox_gsalovselectCheckBox,btn_gsalovokButton,
    btn_btnList,tbl_listGSAComTable,btn_btnPrint,
    btn_btnAccept,btn_btnClose;

   
   
    public CRA155(WebDriver driver, String dataFileName) {
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
    	dropdown_gsaTerritoryType = MiscUtility.getWebElement(genObjPath, "CRA155_dropdown_gsaTerritoryType");
    	text_gsaTerritoryCode = MiscUtility.getWebElement(genObjPath, "CRA155_text_gsaTerritoryCode");
    	btn_gsalov = MiscUtility.getWebElement(genObjPath, "CRA155_btn_gsalov");
    	text_gsalovmasterID = MiscUtility.getWebElement(genObjPath, "CRA155_text_gsalovmasterID");
    	btn_gsalovlistButton = MiscUtility.getWebElement(genObjPath, "CRA155_btn_gsalovlistButton");
    	chkbox_gsalovselectCheckBox = MiscUtility.getWebElement(genObjPath, "CRA155_chkbox_gsalovselectCheckBox");
    	btn_gsalovokButton = MiscUtility.getWebElement(genObjPath, "CRA155_btn_gsalovokButton");
    	btn_btnList = MiscUtility.getWebElement(genObjPath, "CRA155_btn_btnList");
    	btn_btnClose = MiscUtility.getWebElement(genObjPath, "CRA155_btn_btnClose");
    	tbl_listGSAComTable = MiscUtility.getWebElement(genObjPath, "CRA155_tbl_listGSAComTable");
    	btn_btnPrint=MiscUtility.getWebElement(genObjPath, "CRA155_btn_btnPrint");
    	
    	
    }
  

public CRA155 ListGSAComm_TerritoryLevel(String incvid,String agent,String Origin){

	incvid = PropertyHandler.getPropValue(dataFilePath, incvid);
	agent = PropertyHandler.getPropValue(dataFilePath, agent);
	Origin = PropertyHandler.getPropValue(dataFilePath, Origin);
click(btn_gsalov);
minWait();
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_gsalovmasterID, incvid);
click(btn_gsalovlistButton);
minWait();
check(chkbox_gsalovselectCheckBox);
click(btn_gsalovokButton);
selectByText(dropdown_gsaTerritoryType, "Station");
enterKeys(text_gsaTerritoryCode, Origin);
minWait();
waitForFrameAndSwitch(FRAME);
click(btn_btnList);
minWait();


tblSelectRowByColValue(tbl_listGSAComTable, 1, 2, agent);


return this;


}
public CRA155 ListGSAComm_Agent(String incvid,String agent,String Origin){

	incvid = PropertyHandler.getPropValue(dataFilePath, incvid);
	agent = PropertyHandler.getPropValue(dataFilePath, agent);
	
click(btn_gsalov);
minWait();
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_gsalovmasterID, incvid);
click(btn_gsalovlistButton);
minWait();
check(chkbox_gsalovselectCheckBox);
click(btn_gsalovokButton);


minWait();
waitForFrameAndSwitch(FRAME);
click(btn_btnList);
minWait();


tblSelectRowByColValue(tbl_listGSAComTable, 1, 2, agent);


return this;


}
public CRA155 CheckGSACommValue(String incvid,String FreightChrg,String GSACmmValue){
	
	incvid = PropertyHandler.getPropValue(dataFilePath, incvid);
	FreightChrg = PropertyHandler.getPropValue(dataFilePath, FreightChrg);
	

enterKeys(text_gsalovmasterID, incvid);
click(btn_gsalovlistButton);
minWait();
check(chkbox_gsalovselectCheckBox);
click(btn_gsalovokButton);


minWait();
waitForFrameAndSwitch(FRAME);
click(btn_btnList);
minWait();

float FC= Float.parseFloat(FreightChrg);
double Commval;
Commval=0.02*FC;
String GSACommValue=String.valueOf(Commval);
PropertyHandler.setPropValue(dataFilePath, GSACmmValue, GSACommValue);
GSACmmValue = PropertyHandler.getPropValue(dataFilePath, GSACmmValue);


tblSelectRowByColValue(tbl_listGSAComTable, 1, 2, GSACmmValue);




return this;
}

public CRA155 CheckPrintBtn_NewAcceptedGSA(String incvid,String agent,String Origin,boolean New){

	incvid = PropertyHandler.getPropValue(dataFilePath, incvid);
	agent = PropertyHandler.getPropValue(dataFilePath, agent);
	
click(btn_gsalov);
minWait();
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_gsalovmasterID, incvid);
click(btn_gsalovlistButton);
minWait();
check(chkbox_gsalovselectCheckBox);
click(btn_gsalovokButton);


minWait();
waitForFrameAndSwitch(FRAME);
click(btn_btnList);
minWait();


if(New){
	
	Assert.assertTrue(waitForElement(btn_btnPrint).isDisplayed(),"Error: The button Print is enabled for GSA commission with New status");
			
}
Assert.assertTrue(waitForElement(btn_btnPrint).isEnabled(),"Error: The button Print is disabled for GSA commission with Accepted status");

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
