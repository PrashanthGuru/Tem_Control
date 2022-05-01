package com.ibsplc.pageObjects;

//created by a-8254

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class TRF007 extends BasePage{
    
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
	public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","Generic.properties");
	 
	public static String filepath;
	
	public static String FRAME = "iCargoContentFrameTRF007";
	 
	By  txt_spotRateId,
	    btn_list,
	    checkbox_first,
	    btn_viewSpotRate,
	    yesBtn,
	    btn_noBtn,
	    btn_close;
	
	
	
	 WebDriver driver;    
	String testDataFile;

	public  TRF007(WebDriver driver, String testDataFile) {
		 super(driver);
	    this.driver = driver;
	    this.testDataFile = testDataFile;
	    PageFactory.initElements(this.driver,this);
	    filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
	    initPageElements();
	} 


	private void initPageElements() {
		txt_spotRateId                   = MiscUtility.getWebElement(objFilepath, "TRF007_txt_spotRateId");
		btn_list                   = MiscUtility.getWebElement(objFilepath, "TRF007_btn_list");
		checkbox_first                   = MiscUtility.getWebElement(objFilepath, "TRF007_checkbox_first");
		btn_viewSpotRate                   = MiscUtility.getWebElement(objFilepath, "TRF007_btn_viewSpotRate");
		btn_close               = MiscUtility.getWebElement(objFilepath, "TRF017_btn_close");
		yesBtn                            = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
	    btn_noBtn                         = MiscUtility.getWebElement(genFilepath, "Generic_btn_noBtn");
	
	}
	
	public TRF017 listAndViewSpotRate(String SpotRateID)
	{
	
		SpotRateID  = PropertyHandler.getPropValue(filepath, SpotRateID);	
		
		
		
	    enterKeys(txt_spotRateId,SpotRateID);	
		click(btn_list);
		minWait();
		click(checkbox_first);
		click(btn_viewSpotRate);
		
		return new TRF017(driver, testDataFile);
	}
	
	
	
	public HomePage close() {

	    click(btn_close);
	    driver.switchTo().defaultContent();
	    if (verifyElementPresent(yesBtn)) {

	        click(yesBtn);
	    }
	    return new HomePage(driver, testDataFile);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}


