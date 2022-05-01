package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class SHR018 extends BasePage{

	public SHR018(WebDriver driver, String testDataFile) {
		super(driver);
		this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver,this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
        initPageElements();
	}
	
	
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
	public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","Generic.properties");
	public static String filepath;
	public static String FRAME = "iCargoContentFrameSHR018";
	
	WebDriver driver;    
    String testDataFile;
    
    By txt_fromCurrencyCode,
    txt_toCurrencyCode,
    dropdown_currencyBasis,
    txt_conversionFactor,
    btn_list,
    btn_close,
    btn_dialogueYes;
    private void initPageElements(){
    	txt_fromCurrencyCode = MiscUtility.getWebElement(objFilepath,"SHR018_txt_fromCurrencyCode");
    	txt_toCurrencyCode = MiscUtility.getWebElement(objFilepath,"SHR018_txt_toCurrencyCode");
    	dropdown_currencyBasis = MiscUtility.getWebElement(objFilepath,"SHR018_dropdown_currencyBasis");
    	txt_conversionFactor = MiscUtility.getWebElement(objFilepath,"SHR018_txt_conversionFactor");
    	btn_close = MiscUtility.getWebElement(objFilepath,"SHR018_btn_close");
    	btn_list = MiscUtility.getWebElement(objFilepath,"SHR018_btn_list");
    	
    	btn_dialogueYes = MiscUtility.getWebElement(genFilepath,"Generic_btn_diaYes");
    }
    
    /**
     * Created by A-7605 on 22-2-18
     * This method save the conversion factor to the datasheet
     * @param fromCurrencyCode
     * @param toCurrencyCode
     * @param currencyBasis
     * @param conversionFactor
     * @return
     */
    public SHR018 getConversionFactor(String fromCurrencyCode, String toCurrencyCode, String currencyBasis, String conversionFactor){
    	fromCurrencyCode = PropertyHandler.getPropValue(filepath, fromCurrencyCode);
    	toCurrencyCode = PropertyHandler.getPropValue(filepath, toCurrencyCode);
    	currencyBasis = PropertyHandler.getPropValue(filepath, currencyBasis);

    	enterKeys(waitForElement(txt_fromCurrencyCode), fromCurrencyCode);
    	enterKeys(txt_toCurrencyCode, toCurrencyCode);
    	selectByText(dropdown_currencyBasis, currencyBasis);
    	click(btn_list);
    	minWait();
    	String convFactor = waitForElement(txt_conversionFactor).getAttribute("value");
    	PropertyHandler.setPropValue(filepath, conversionFactor, convFactor);
    	return this;
    }
    
    /**
     * This method closes the current page and return to the home page
     * @return
     */
    public HomePage close(){
    	click(btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_dialogueYes))
    		click(btn_dialogueYes);
    	return new HomePage(driver, testDataFile);
    }

}
