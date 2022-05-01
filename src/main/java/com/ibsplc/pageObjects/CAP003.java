package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP003 extends BasePage {
	public String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String FRAME = "iCargoContentFrameCAP003";    
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;
	public CAP003(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }
	
	private By  txt_stAltid,
				txt_custAltId,
			    txt_weight,
			    txt_volume,
			    txt_sDate,
			    txt_eDate,
			    chk_freq,
			    txt_custCode,
			    btn_list,
			    btn_displayalt,
			    btn_clr,
			    btn_save,
			    yesBtn;
	
	private void initElements()
	{
		txt_stAltid=MiscUtility.getWebElement(objFilepath, "CAP003_txt_stationAltId");
		txt_custAltId=MiscUtility.getWebElement(objFilepath, "CAP003_txt_custAltId");
		txt_weight=MiscUtility.getWebElement(objFilepath, "CAP003_txt_weight");
		txt_volume=MiscUtility.getWebElement(objFilepath, "CAP003_txt_volume");
		btn_list=MiscUtility.getWebElement(objFilepath, "CAP003_btn_list");
		btn_displayalt=MiscUtility.getWebElement(objFilepath, "CAP003_btn_pressButton");
		btn_clr=MiscUtility.getWebElement(objFilepath, "CAP003_txt_custAltId");
		btn_save=MiscUtility.getWebElement(objFilepath, "CAP003_btn_save");
		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		txt_custCode=MiscUtility.getWebElement(objFilepath, "CAP003_txt_custCode");
		txt_sDate=MiscUtility.getWebElement(objFilepath, "CAP003_txt_startDate");
		txt_eDate=MiscUtility.getWebElement(objFilepath, "CAP003_txt_endDate");
		chk_freq=MiscUtility.getWebElement(objFilepath, "CAP003_chk_freqAll");
		
	}
	
	public CAP003 createCustomerAllotment(String stAltId, String custCode, String sDate, String eDate, String weight, String voulme, String custAltId)
	{
		stAltId=PropertyHandler.getPropValue(dataFilePath, stAltId);
		weight=PropertyHandler.getPropValue(dataFilePath, weight);
		voulme=PropertyHandler.getPropValue(dataFilePath, voulme);
		custCode=PropertyHandler.getPropValue(dataFilePath, custCode);
		sDate=PropertyHandler.getPropValue(dataFilePath, sDate);
		eDate=PropertyHandler.getPropValue(dataFilePath, eDate);
		enterKeys(txt_stAltid, stAltId);
		click(btn_displayalt);
		minWait();
		enterKeys(txt_custCode, custCode);
		enterKeys(txt_sDate, sDate);
		enterKeys(txt_eDate, eDate);
		click(chk_freq);
		enterKeys(txt_weight, weight);
		enterKeys(txt_volume, voulme);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		 if (verifyElementPresent(yesBtn)) {

	            click(yesBtn);
	        }
		 
		 minWait();
		 waitForFrameAndSwitch(FRAME);
		 minWait();
		String altId=waitForElement(txt_custAltId).getAttribute("value");
		
		PropertyHandler.setPropValue(dataFilePath, altId, custAltId);
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
        return new HomePage(driver,dataFileName);
	}
}
