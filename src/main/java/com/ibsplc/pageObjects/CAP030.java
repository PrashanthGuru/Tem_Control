package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP030 extends BasePage{

	public String dataFilePath;
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public String dataFileName;
    public static String FRAME = "iCargoContentFrameCAP030";
    WebDriver driver;    
    String testDataFile;
    String browser;
    public CAP030(WebDriver driver, String dataFileName) {
		 super(driver);
        this.driver = driver;
        this.testDataFile = dataFileName;
        PageFactory.initElements(this.driver,this);
        dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+dataFileName;
        this.dataFileName=dataFileName;
        initPageElements();
	}
    
    private By 
    			txt_altId,
    			btn_list,
    			btn_close,
    			btn_clear,
    			tbl_altmnts,
    			yesBtn,
    			btn_Create,
    			txt_carrierCode,
    			txt_fltNo,
    			txt_Create_wt,
    			txt_Create_Vol,
    			btn_createList,
    			btn_createSave,
    			sel_shptype,
    			txt_custCode,
    			txt_fltCarCode,
    			txt_flightNumeber;
    private By txt_fromDate;
    private By txt_ToDate;
    
    private void initPageElements()
    {
    	txt_altId   = MiscUtility.getWebElement(objFilepath,"CAP030_txt_altId");
    	btn_list    = MiscUtility.getWebElement(objFilepath,"CAP030_btn_list");
    	btn_close   = MiscUtility.getWebElement(objFilepath,"CAP030_btn_close");
    	btn_clear   = MiscUtility.getWebElement(objFilepath,"CAP030_btn_clr");
    	tbl_altmnts = MiscUtility.getWebElement(objFilepath,"CAP030_tbl_altmnt");
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btn_Create= MiscUtility.getWebElement(objFilepath,"CAP030_btn_create");
    	txt_carrierCode=MiscUtility.getWebElement(objFilepath,"CAP030_txt_carrierCode");
    	txt_fltNo=MiscUtility.getWebElement(objFilepath,"CAP030_txt_fltNO");
    	txt_Create_wt=MiscUtility.getWebElement(objFilepath,"CAP030_txt_createWeight");
    	txt_Create_Vol=MiscUtility.getWebElement(objFilepath,"CAP030_txt_createVol");
    	btn_createSave=MiscUtility.getWebElement(objFilepath,"CAP030_btn_createSave");
    	btn_createList=MiscUtility.getWebElement(objFilepath,"CAP030_btn_listFlt");
    	sel_shptype=MiscUtility.getWebElement(objFilepath,"CAP030_sel_shiptype");
    	txt_custCode=MiscUtility.getWebElement(objFilepath,"CAP030_txt_custcode");
    	txt_flightNumeber=MiscUtility.getWebElement(objFilepath,"CAP030_txt_flightNumber");
    	txt_fltCarCode=MiscUtility.getWebElement(objFilepath,"CAp030_txt_fltCarCode");
    	
    	txt_fromDate=MiscUtility.getWebElement(objFilepath,"CAP030_txt_fromDate");
    	txt_ToDate=MiscUtility.getWebElement(objFilepath,"CAP030_txt_toDate");
    }
    
    public CAP030 listAndVerifyActiveAllotments(String altId,String fltNo, String startDate)
    {
    	fltNo	= PropertyHandler.getPropValue(dataFilePath, fltNo);
    	altId	= PropertyHandler.getPropValue(dataFilePath, altId);
    	startDate	= PropertyHandler.getPropValue(dataFilePath, startDate);
    	
    	enterKeys(txt_altId, altId);
    	click(btn_list);
    	minWait();
    	String flightNumberDate= tblGetTextByColValue_input(tbl_altmnts, 5, 3, altId);
    	Assert.assertTrue(flightNumberDate.contains(fltNo), "Flight Number should be same as in the allotment screen");
    	return this;
    }
    public CAP030 listAndVerifyActiveAllotments_UtilizationAlert(String altId,String fltNo, String startDate)
    {
    	fltNo	= PropertyHandler.getPropValue(dataFilePath, fltNo);
    	altId	= PropertyHandler.getPropValue(dataFilePath, altId);
    	startDate	= PropertyHandler.getPropValue(dataFilePath, startDate);
    	
    	enterKeys(txt_altId, altId);
    	enterKeys(txt_fromDate,".");
    	enterKeys(txt_ToDate,"+1");
    	click(btn_list);
    	minWait();
    	String flightNumberDate= tblGetTextByColValue_input(tbl_altmnts, 5, 3, altId);
    	String utilAlert=tblGetTextByColValue_input(tbl_altmnts, 32, 3, altId);
    	Assert.assertTrue(flightNumberDate.contains(fltNo), "Flight Number should be same as in the allotment screen");
    	Assert.assertEquals(utilAlert.equals("Y"),"Utilization alert should be set as 'Y'");
    	return this;
    }
    public CAP030 listAndVerifyOverBookingDetails(String altId,String fltNo, String startDate,String ovrWt, String ovrVol)
    {
    	fltNo	= PropertyHandler.getPropValue(dataFilePath, fltNo);
    	altId	= PropertyHandler.getPropValue(dataFilePath, altId);
    	startDate	= PropertyHandler.getPropValue(dataFilePath, startDate);
    	
    	enterKeys(txt_altId, altId);
    	enterKeys(txt_fromDate,".");
    	enterKeys(txt_ToDate,"+1");
    	click(btn_list);
    	minWait();
    	String flightNumberDate= tblGetTextByColValue_input(tbl_altmnts, 5, 3, altId);
    	String utilAlert=tblGetTextByColValue_input(tbl_altmnts, 32, 3, altId);
    	String ovrBkWt=tblGetTextByColValue_input(tbl_altmnts, 24, 3, altId);
    	String ovrBkVol=tblGetTextByColValue_input(tbl_altmnts, 25, 3, altId);
    	return this;
    }
    
    
    public CAP030 createStationAllotment(String carrier_code, String fltNO,String wt, String vol,String custCode)
    {
    	carrier_code= PropertyHandler.getPropValue(dataFilePath, carrier_code);
    	fltNO= PropertyHandler.getPropValue(dataFilePath, fltNO);
    	wt= PropertyHandler.getPropValue(dataFilePath, wt);
    	vol= PropertyHandler.getPropValue(dataFilePath, vol);
    	custCode= PropertyHandler.getPropValue(dataFilePath, custCode);
    	minWait();
    	click(btn_Create);
    	minWait();
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(txt_carrierCode, carrier_code);
    	enterKeys(txt_fltNo, fltNO);
    	click(btn_createList);
    	minWait();
    	enterKeys(txt_Create_wt, wt);
    	enterKeys(txt_Create_Vol, vol);
    	selectByIndex(sel_shptype, 2);
    	enterKeys(txt_custCode, custCode);
    	click(btn_createSave);
    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	minWait();
    	minWait();
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);    	
    	enterKeys(txt_fltCarCode, carrier_code);
    	enterKeys(txt_flightNumeber, fltNO);
    	click(btn_list);
    	minWait();
    	waitForElementVisible(tbl_altmnts);
    	//String allotmentId=tblGetTextByColValue(tbl_altmnts, 5, 3, fltNO);
    	tblClickByColValWithRef(tbl_altmnts, 3, 5, fltNO);
    	
    	return this;
    }
    
    public CAP030 modifyOperationalStationAllotment(String carrier_code, String fltNO,String wt, String vol,String custCode)
    {
    	carrier_code= PropertyHandler.getPropValue(dataFilePath, carrier_code);
    	fltNO= PropertyHandler.getPropValue(dataFilePath, fltNO);
    	wt= PropertyHandler.getPropValue(dataFilePath, wt);
    	vol= PropertyHandler.getPropValue(dataFilePath, vol);
    	custCode= PropertyHandler.getPropValue(dataFilePath, custCode);
    	enterKeys(txt_fltCarCode, carrier_code);
    	enterKeys(txt_flightNumeber, fltNO);
    	click(btn_list);
    	minWait();
    	WebElement altId=tblClickByColValWithRef(tbl_altmnts, 3, 5, fltNO);
    	doubleClick(altId);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(txt_Create_wt, wt);
    	enterKeys(txt_Create_Vol, vol);
    	click(btn_createSave);
    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	
    	return this;
    }
    public HomePage close()
	{
		minWait();
    	Actions action = new Actions(driver);
    	action.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).perform();  	 
    	
    	driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver,testDataFile);
	}
}
