package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP109 extends BasePage{
	public String dataFilePath;
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public String dataFileName;
    public static String FRAME = "iCargoContentFrameCAP109";
    WebDriver driver;    
    String testDataFile;
    String browser;
    public CAP109(WebDriver driver, String dataFileName) {
		 super(driver);
        this.driver = driver;
        this.testDataFile = dataFileName;
        PageFactory.initElements(this.driver,this);
        dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+dataFileName;
        this.dataFileName=dataFileName;
        initPageElements();
	}
    
    private By  txt_alotId,
    			txt_carrierCode,
    			txt_fltNo,
    			txt_origin,
    			txt_dest,
    			txt_startDate,
    			txt_endDate,
    			txt_weight,
    			txt_volume,
    			btn_save,
    			chk_freq,
    			btn_list,
    			btn_clr,
    			btn_cancelTerminate,
    			btn_terminateSave,
    			radio_cancel,
    			radio_terminate,
    			txt_cancelReason,
    			yesBtn;
    
    private void initPageElements()
    {
    	txt_alotId   = MiscUtility.getWebElement(objFilepath,"CAP109_txt_alotId");
    	txt_carrierCode= MiscUtility.getWebElement(objFilepath,"CAP109_txt_carrierCode");
    	txt_fltNo= MiscUtility.getWebElement(objFilepath,"CAP109_txt_fltNo");
    	txt_origin= MiscUtility.getWebElement(objFilepath,"CAP109_txt_origin");
    	txt_dest= MiscUtility.getWebElement(objFilepath,"CAP109_txt_dest");
    	txt_startDate= MiscUtility.getWebElement(objFilepath,"CAP109_txt_sDate");
    	txt_endDate= MiscUtility.getWebElement(objFilepath,"CAP109_txt_eDate");
    	txt_weight= MiscUtility.getWebElement(objFilepath,"CAP109_txt_weight");
    	txt_volume= MiscUtility.getWebElement(objFilepath,"CAP109_txt_volume");
    	btn_save= MiscUtility.getWebElement(objFilepath,"CAP109_btn_save");
    	chk_freq=MiscUtility.getWebElement(objFilepath,"CAP109_chk_freq");
    	btn_list=MiscUtility.getWebElement(objFilepath,"CAP109_btn_list");
    	btn_cancelTerminate=MiscUtility.getWebElement(objFilepath,"CAP109_btn_terminateCancel");
    	txt_cancelReason=MiscUtility.getWebElement(objFilepath,"CAP109_txt_cancelReason");
    	btn_terminateSave=MiscUtility.getWebElement(objFilepath,"CAP109_btn_TerminateSave");
    	radio_terminate=MiscUtility.getWebElement(objFilepath,"CAP109_radio_terminate");
    	radio_cancel=MiscUtility.getWebElement(objFilepath,"CAP109_radio_cancel");
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }
    
    public CAP109 createProductAllotment(String carrierCode, String fltNo, String origin, String dest, String sDate, String eDate, String weight, String volume,String allotmentId)
    {
    	carrierCode= PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	fltNo= PropertyHandler.getPropValue(dataFilePath, fltNo);
    	origin= PropertyHandler.getPropValue(dataFilePath, origin);
    	dest= PropertyHandler.getPropValue(dataFilePath, dest);
    	sDate= PropertyHandler.getPropValue(dataFilePath, sDate);
    	eDate= PropertyHandler.getPropValue(dataFilePath, eDate);
    	weight= PropertyHandler.getPropValue(dataFilePath, weight);
    	volume= PropertyHandler.getPropValue(dataFilePath, volume);
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_fltNo, fltNo);
    	enterKeys(txt_origin, origin);
    	enterKeys(txt_dest, dest);
    	enterKeys(txt_startDate, sDate);
    	enterKeys(txt_endDate, eDate);    	
    	click(chk_freq);
    	enterKeys(txt_weight, weight);
    	enterKeys(txt_volume, volume);
    	
    	click(btn_save);
    	minWait();
    	
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	
    	waitForFrameAndSwitch(FRAME);
    	String alotmentId=waitForElement(txt_alotId).getAttribute("value");
    	PropertyHandler.setPropValue(dataFilePath,allotmentId , alotmentId);
    	
    	return this;
    }
    
    public CAP109 modifyProductAllotment(String carrierCode, String fltNo, String origin, String dest, String sDate, String eDate, String weight, String volume,String allotmentId)
    {
    	carrierCode= PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	fltNo= PropertyHandler.getPropValue(dataFilePath, fltNo);
    	origin= PropertyHandler.getPropValue(dataFilePath, origin);
    	dest= PropertyHandler.getPropValue(dataFilePath, dest);
    	sDate= PropertyHandler.getPropValue(dataFilePath, sDate);
    	eDate= PropertyHandler.getPropValue(dataFilePath, eDate);
    	weight= PropertyHandler.getPropValue(dataFilePath, weight);
    	volume= PropertyHandler.getPropValue(dataFilePath, volume);
    	allotmentId= PropertyHandler.getPropValue(dataFilePath, allotmentId);
    	
    	enterKeys(txt_alotId, allotmentId);
    	enterKeys(txt_carrierCode, carrierCode);
    	
    	enterKeys(txt_weight, weight);
    	enterKeys(txt_volume, volume);
    	
    	click(btn_save);
    	minWait();
    	
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	
    	waitForFrameAndSwitch(FRAME);
    	String alotmentId=waitForElement(txt_alotId).getAttribute("value");
    	PropertyHandler.setPropValue(dataFilePath,allotmentId , alotmentId);
    	
    	return this;
    }
    
    public CAP109 terminateAllotment(String alotId,boolean terminate)
    {
    	alotId= PropertyHandler.getPropValue(dataFilePath, alotId);
    	enterKeys(txt_alotId, alotId);
    	click(btn_list);
    	minWait();
    	click(btn_cancelTerminate);
    	
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	if(terminate)
    	click(radio_terminate);
    	else
    		click(radio_cancel);
    	enterKeys(txt_cancelReason, "You are Terminated..!!!");
    	click(btn_terminateSave);
    	minWait();    	
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
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
