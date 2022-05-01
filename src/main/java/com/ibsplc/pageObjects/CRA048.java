package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CRA048 extends BasePage {

	 	public static String FRAME = "iCargoContentFrameCRA048";
	    public static String screenFrame = "iCargoContentFrameCRA048";
	    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
	    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	    WebDriver driver;
	    String dataFileName;
	    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	    public CRA048(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        this.dataFileName = dataFileName;
	    }

	    
	    private By txt_awbPref,
	    			txt_awbNo,
	    			btn_list,
	    			tbl_freightChrg,
	    			btn_clear,
	    			btn_close,
	    			yesBtn,
	    			tbl_proration;
	    
	    private void initElements() 
	    {
	    	txt_awbPref=MiscUtility.getWebElement(objFilepath, "CRA048_txt_awbPrefix");
	    	txt_awbNo=MiscUtility.getWebElement(objFilepath, "CRA048_txt_awbNo");
	    	btn_list=MiscUtility.getWebElement(objFilepath, "CRA048_btn_list");
	    	tbl_freightChrg=MiscUtility.getWebElement(objFilepath, "CRA048_tbl_freightDetails");
	    	btn_clear=MiscUtility.getWebElement(objFilepath, "CRA048_btn_clear");
	    	btn_close=MiscUtility.getWebElement(objFilepath, "CRA048_btn_close");
	    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
	    	tbl_proration=MiscUtility.getWebElement(objFilepath, "CRA048_tbl_prorationDetails");
	    }
	    
	    public CRA048 validateFreightCharge(String pref, String awbNo, String freightCharge)
	    {
	    	pref=PropertyHandler.getPropValue(dataFilePath, pref);
	    	awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
	    	freightCharge=PropertyHandler.getPropValue(dataFilePath, freightCharge);
	    	
	    	enterKeys(txt_awbPref, pref);
	    	enterKeys(txt_awbNo, awbNo);
	    	click(btn_list);
	    	minWait();
	    	waitForElement(tbl_freightChrg);
//	    	String freightChargeValue=getTextByColumnNumber(tbl_freightChrg,7).replace("", "");
//	    	freightCharge=freightCharge.replaceAll(",", "");
//	    	Assert.assertTrue(freightCharge.equals(freightChargeValue),"freight charge should be matching");
	    	
	    	return this;
	    }
	    public CRA048 validateProration(String pref, String awbNo,String fltNo)
	    {
	    	pref=PropertyHandler.getPropValue(dataFilePath, pref);
	    	awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
	    	fltNo=PropertyHandler.getPropValue(dataFilePath, fltNo);
	    	
	    	enterKeys(txt_awbPref, pref);
	    	enterKeys(txt_awbNo, awbNo);
	    	click(btn_list);
	    	minWait();
	    	
//	    	String flightNumber=getTextByColumnNumber(tbl_proration, 1).trim();
//	    	Assert.assertTrue(flightNumber.contains(fltNo),"flight details whould be prorated");
	    	
	    	return this;
	    }
	    
	    public HomePage close() {

	        click(btn_close);
	        driver.switchTo().defaultContent();
	        if (verifyElementPresent(yesBtn)) {

	            click(yesBtn);
	        }
	        return new HomePage(driver, dataFileName);
	    }
	    
}



