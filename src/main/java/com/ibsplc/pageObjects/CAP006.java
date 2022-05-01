package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP006 extends BasePage{

	public String dataFilePath;
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public String dataFileName;
    public static String FRAME = "iCargoContentFrameCAP006";
    WebDriver driver;    
    String testDataFile;
    String browser;
    
    public CAP006(WebDriver driver, String dataFileName) {
		 super(driver);
        this.driver = driver;
        this.testDataFile = dataFileName;
        PageFactory.initElements(this.driver,this);
        dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+dataFileName;
        this.dataFileName=dataFileName;
        initPageElements();
	}
    
    
    private By  txt_alotId,  
    			txt_fltNo,
    			txt_custcode,
    			txt_carriercode,
    			txt_origin,
    			txt_dest,
    			txt_startDt,
    			txt_endDt,
    			chk_freq,
    			sel_shipType,
    			txt_weight,
    			txt_volume,
    			btn_save,
    			btn_Close,
    			btn_list,
    			btn_terminateCancel,
    			btn_terminateSave,
    			txt_cancelReason,
    			radio_cancel,
    			radio_terminate,
    			txt_cancelRemarks,
    			yesBtn;
    
    private By txt_category;
    private By sel_subtype;
    
    private By txt_ovrBkWt;
    private By txt_ovrBkVol;
    
    
    private void initPageElements()
    {
    	txt_alotId= MiscUtility.getWebElement(objFilepath,"CAP006_txt_allotmnId");
    	txt_fltNo= MiscUtility.getWebElement(objFilepath,"CAP006_txt_fltNum");
    	txt_custcode= MiscUtility.getWebElement(objFilepath,"CAP006_txt_custCode");
    	txt_carriercode= MiscUtility.getWebElement(objFilepath,"CAP006_txt_carriercode");//-----------------
    	txt_origin= MiscUtility.getWebElement(objFilepath,"CAP006_txt_origin");
    	txt_dest= MiscUtility.getWebElement(objFilepath,"CAP006_txt_dest");
    	txt_startDt= MiscUtility.getWebElement(objFilepath,"CAP006_txt_startDt");
    	txt_endDt= MiscUtility.getWebElement(objFilepath,"CAP006_txt_endDate");
    	chk_freq= MiscUtility.getWebElement(objFilepath,"CAP006_chkbx_frequencyAll");
    	sel_shipType= MiscUtility.getWebElement(objFilepath,"CAP006_dropdown_shipType");
    	txt_weight= MiscUtility.getWebElement(objFilepath,"CAP006_txt_capacityWgt");
    	txt_volume= MiscUtility.getWebElement(objFilepath,"CAP006_txt_CapacityVol");
    	btn_save= MiscUtility.getWebElement(objFilepath,"CAP006_btn_save");
    	btn_Close= MiscUtility.getWebElement(objFilepath,"CAP006_btn_Close");
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btn_list= MiscUtility.getWebElement(objFilepath,"CAP006_btn_List");
    	btn_terminateCancel= MiscUtility.getWebElement(objFilepath,"CAP006_btn_cancelTerminate");
    	btn_terminateSave=MiscUtility.getWebElement(objFilepath,"CAP006_btn_terminateSave");
    	radio_cancel=MiscUtility.getWebElement(objFilepath,"CAP006_radio_cancel");
    	radio_terminate=MiscUtility.getWebElement(objFilepath,"CAP006_radio_terminate");
    	txt_cancelRemarks=MiscUtility.getWebElement(objFilepath,"CAP006_txt_cancelRemarks");
    	txt_category=MiscUtility.getWebElement(objFilepath,"CAP006_txt_category");
    	sel_subtype=MiscUtility.getWebElement(objFilepath,"CAP006_sel_subtype");
    	txt_ovrBkWt=MiscUtility.getWebElement(objFilepath,"CAP006_txt_ovrBkWt");
    	txt_ovrBkVol=MiscUtility.getWebElement(objFilepath,"CAP006_txt_ovrBkVol");
    }
    
    public CAP006 createAllotment(String allotment,String custCode, String carrier_code, String fltNo, String Origin, String dest, String startDate, String endDate, String weight, String volume)
    {
    	
    	custCode=PropertyHandler.getPropValue(dataFilePath, custCode);
    	carrier_code=PropertyHandler.getPropValue(dataFilePath, carrier_code);
    	fltNo=PropertyHandler.getPropValue(dataFilePath, fltNo);
    	Origin=PropertyHandler.getPropValue(dataFilePath, Origin);
    	dest=PropertyHandler.getPropValue(dataFilePath, dest);
    	startDate=PropertyHandler.getPropValue(dataFilePath, startDate);
    	endDate=PropertyHandler.getPropValue(dataFilePath, endDate);
    	weight=PropertyHandler.getPropValue(dataFilePath, weight);
    	volume=PropertyHandler.getPropValue(dataFilePath, volume);
    	
    	enterKeys(txt_custcode, custCode);
    	enterKeys(txt_carriercode,carrier_code);
    	enterKeys(txt_fltNo, fltNo);
    	enterKeys(txt_origin, Origin);
    	enterKeys(txt_dest, dest);
    	enterKeys(txt_startDt, startDate);
    	enterKeys(txt_endDt, endDate);
    	click(chk_freq);
    	selectByIndex(sel_shipType, 2);
    	enterKeys(txt_weight, weight);
    	enterKeys(txt_volume, volume);
    	
    	click(btn_save);
    	minWait();
    	driver.switchTo().defaultContent();

    	

    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	
    
    	minWait();
    	
    	String alotId=waitForElement(txt_alotId).getAttribute("value");
    	System.out.println(alotId);    	   
    	PropertyHandler.setPropValue(dataFilePath, allotment, alotId);    	
    	System.out.println(allotment);
    	return this;
    }
    
    public CAP006 createAllotment_AllotmentSubType(String allotment,String custCode, String carrier_code, String fltNo, String Origin, String dest, String startDate, String endDate, String weight, String volume,String category, String subType)
    {
    	
    	custCode=PropertyHandler.getPropValue(dataFilePath, custCode);
    	carrier_code=PropertyHandler.getPropValue(dataFilePath, carrier_code);
    	fltNo=PropertyHandler.getPropValue(dataFilePath, fltNo);
    	Origin=PropertyHandler.getPropValue(dataFilePath, Origin);
    	dest=PropertyHandler.getPropValue(dataFilePath, dest);
    	startDate=PropertyHandler.getPropValue(dataFilePath, startDate);
    	endDate=PropertyHandler.getPropValue(dataFilePath, endDate);
    	weight=PropertyHandler.getPropValue(dataFilePath, weight);
    	volume=PropertyHandler.getPropValue(dataFilePath, volume);
    	category=PropertyHandler.getPropValue(dataFilePath, category);
    	subType=PropertyHandler.getPropValue(dataFilePath, subType);
    	
    	enterKeys(txt_custcode, custCode);
    	enterKeys(txt_carriercode,carrier_code);
    	enterKeys(txt_fltNo, fltNo);
    	enterKeys(txt_origin, Origin);
    	enterKeys(txt_dest, dest);
    	enterKeys(txt_startDt, startDate);
    	enterKeys(txt_endDt, endDate);
    	click(chk_freq);
    	selectByIndex(sel_shipType, 2);
    	enterKeys(txt_weight, weight);
    	enterKeys(txt_volume, volume);
    	enterKeys(txt_category, category);
    	selectByText(sel_subtype,subType);
    	click(btn_save);
    	minWait();
    	driver.switchTo().defaultContent();

    	

    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	
    
    	minWait();
    	
    	String alotId=waitForElement(txt_alotId).getAttribute("value");
    	System.out.println(alotId);    	   
    	PropertyHandler.setPropValue(dataFilePath, allotment, alotId);    	
    	System.out.println(allotment);
    	return this;
    }
    
    public CAP006 createAllotment_OverBookingWtVol(String allotment,String custCode, String carrier_code, String fltNo, String Origin, String dest, String startDate, String endDate, String weight, String volume,String category, String subType,String ovrWt, String ovrVol)
    {
    	
    	custCode=PropertyHandler.getPropValue(dataFilePath, custCode);
    	carrier_code=PropertyHandler.getPropValue(dataFilePath, carrier_code);
    	fltNo=PropertyHandler.getPropValue(dataFilePath, fltNo);
    	Origin=PropertyHandler.getPropValue(dataFilePath, Origin);
    	dest=PropertyHandler.getPropValue(dataFilePath, dest);
    	startDate=PropertyHandler.getPropValue(dataFilePath, startDate);
    	endDate=PropertyHandler.getPropValue(dataFilePath, endDate);
    	weight=PropertyHandler.getPropValue(dataFilePath, weight);
    	volume=PropertyHandler.getPropValue(dataFilePath, volume);
    	category=PropertyHandler.getPropValue(dataFilePath, category);
    	subType=PropertyHandler.getPropValue(dataFilePath, subType);
//    	ovrWt=PropertyHandler.getPropValue(dataFilePath, ovrWt);
//    	ovrVol=PropertyHandler.getPropValue(dataFilePath, ovrVol);
    	enterKeys(txt_custcode, custCode);
    	enterKeys(txt_carriercode,carrier_code);
    	enterKeys(txt_fltNo, fltNo);
    	enterKeys(txt_origin, Origin);
    	enterKeys(txt_dest, dest);
    	enterKeys(txt_startDt, startDate);
    	enterKeys(txt_endDt, endDate);
    	click(chk_freq);
    	selectByIndex(sel_shipType, 2);
    	enterKeys(txt_weight, weight);
    	enterKeys(txt_volume, volume);
    	enterKeys(txt_category, category);
    	selectByText(sel_subtype,subType);
    	
    	enterKeys(txt_ovrBkWt, weight);
    	enterKeys(txt_ovrBkVol, volume);
    	click(btn_save);
    	minWait();
    	driver.switchTo().defaultContent();

    	

    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	
    
    	minWait();
    	
    	String alotId=waitForElement(txt_alotId).getAttribute("value");
    	System.out.println(alotId);    	   
    	PropertyHandler.setPropValue(dataFilePath, allotment, alotId);    	
    	System.out.println(allotment);
    	return this;
    }
    
    public CAP006 createAllotmentWithMultipleGlobalCustomer(String allotment,String custCode, String carrier_code, String fltNo, String Origin, String dest, String startDate, String endDate, String weight, String volume,String category, String subType,String ovrWt, String ovrVol)
    {
    	custCode=PropertyHandler.getPropValue(dataFilePath, custCode);
    	carrier_code=PropertyHandler.getPropValue(dataFilePath, carrier_code);
    	fltNo=PropertyHandler.getPropValue(dataFilePath, fltNo);
    	Origin=PropertyHandler.getPropValue(dataFilePath, Origin);
    	dest=PropertyHandler.getPropValue(dataFilePath, dest);
    	startDate=PropertyHandler.getPropValue(dataFilePath, startDate);
    	endDate=PropertyHandler.getPropValue(dataFilePath, endDate);
    	weight=PropertyHandler.getPropValue(dataFilePath, weight);
    	volume=PropertyHandler.getPropValue(dataFilePath, volume);
    	category=PropertyHandler.getPropValue(dataFilePath, category);
    	subType=PropertyHandler.getPropValue(dataFilePath, subType);
    	enterKeys(txt_custcode, custCode);
    	enterKeys(txt_carriercode,carrier_code);
    	enterKeys(txt_fltNo, fltNo);
    	enterKeys(txt_origin, Origin);
    	enterKeys(txt_dest, dest);
    	enterKeys(txt_startDt, startDate);
    	enterKeys(txt_endDt, endDate);
    	click(chk_freq);
    	selectByIndex(sel_shipType, 2);
    	enterKeys(txt_weight, weight);
    	enterKeys(txt_volume, volume);
    	enterKeys(txt_category, category);
    	selectByText(sel_subtype,subType);
    	
    	//enterKeys(txt_ovrBkWt, weight);
    	//enterKeys(txt_ovrBkVol, volume);
    	click(btn_save);
    	minWait();
    	driver.switchTo().defaultContent();

    	

    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	
    
    	minWait();
    	
    	String alotId=waitForElement(txt_alotId).getAttribute("value");
    	System.out.println(alotId);    	   
    	PropertyHandler.setPropValue(dataFilePath, allotment, alotId);    	
    	System.out.println(allotment);
    	
    	return this;
    }
    
    
    public CAP006 modifyAllotmentDetails(String allotment,String custCode, String carrier_code, String fltNo, String Origin, String dest, String startDate, String endDate, String weight, String volume)
    {
    	custCode=PropertyHandler.getPropValue(dataFilePath, custCode);
    	carrier_code=PropertyHandler.getPropValue(dataFilePath, carrier_code);
    	fltNo=PropertyHandler.getPropValue(dataFilePath, fltNo);
    	Origin=PropertyHandler.getPropValue(dataFilePath, Origin);
    	dest=PropertyHandler.getPropValue(dataFilePath, dest);
    	startDate=PropertyHandler.getPropValue(dataFilePath, startDate);
    	endDate=PropertyHandler.getPropValue(dataFilePath, endDate);
    	weight=PropertyHandler.getPropValue(dataFilePath, weight);
    	volume=PropertyHandler.getPropValue(dataFilePath, volume);
    	allotment=PropertyHandler.getPropValue(dataFilePath, allotment);
    	enterKeys(txt_alotId, allotment);
    	
    	click(btn_list);
    	minWait();
    	enterKeys(txt_weight, weight);
    	enterKeys(txt_volume, volume);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	
    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	
    	
    	return this;
    }
    
    public CAP006 terminateAllotment(String allotment,boolean terminate)
    {
    	allotment=PropertyHandler.getPropValue(dataFilePath, allotment);
    	enterKeys(txt_alotId, allotment);
    	
    	click(btn_list);
    	minWait();
    	
    	click(btn_terminateCancel);
    	driver.switchTo().defaultContent();
    	
    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	if(terminate)
    		click(radio_terminate);
    	else
    		click(radio_cancel);
    	
    	enterKeys(txt_cancelRemarks, "remarks");
    	
    	click(btn_terminateSave);
    	
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	
    	minWait();
    	return this;
    }
    
    public CAP006 verifyValuesPresent(String allotment,String custCode, String carrier_code, String fltNo, String Origin, String dest, String startDate, String endDate, String weight, String volume) 
    {
    	custCode=PropertyHandler.getPropValue(dataFilePath, custCode);
    	carrier_code=PropertyHandler.getPropValue(dataFilePath, carrier_code);
    	fltNo=PropertyHandler.getPropValue(dataFilePath, fltNo);
    	Origin=PropertyHandler.getPropValue(dataFilePath, Origin);
    	dest=PropertyHandler.getPropValue(dataFilePath, dest);
    	startDate=PropertyHandler.getPropValue(dataFilePath, startDate);
    	endDate=PropertyHandler.getPropValue(dataFilePath, endDate);
    	weight=PropertyHandler.getPropValue(dataFilePath, weight);
    	volume=PropertyHandler.getPropValue(dataFilePath, volume);
    	allotment=PropertyHandler.getPropValue(dataFilePath, allotment);
    	enterKeys(txt_alotId, allotment);
    	
    	click(btn_list);
    	minWait();
    	Assert.assertTrue(waitForElement(txt_weight).getAttribute("value").equals(weight), "Weight should be same as expected");
    	Assert.assertTrue(waitForElement(txt_volume).getAttribute("value").equals(volume), "Volume should be same as expected");
    	return this;
    }
    public HomePage close() {

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
