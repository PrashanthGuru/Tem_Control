package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
/***
 *  Created on 23/02/2018
 * @author A-6784
 *
 */

public class CRA035 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA035";
    public static String screenFrame = "iCargoContentFrameCRA035";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    By
    txt_invoiceNumber,
    btn_list,text_settlementCurrency,
    txt_searchAWB,
    btn_search,
    txt_currentSettlement,
    yesBtn,btn_btnClose,
    btn_save;
    
    
    
    
    
    
    
    
    
    public CRA035(WebDriver driver, String dataFileName) {
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
    	
    	 yesBtn               = MiscUtility.getWebElement(genObjPath,  "Generic_btn_diaYes");
    	 txt_invoiceNumber    = MiscUtility.getWebElement(objFilepath, "CRA035_txt_invoiceNumber");
    	 btn_list             = MiscUtility.getWebElement(objFilepath, "CRA035_btn_list");
    	 txt_searchAWB        = MiscUtility.getWebElement(objFilepath, "CRA035_txt_searchAWB");
    	 btn_search           = MiscUtility.getWebElement(objFilepath, "CRA035_btn_search");
    	 txt_currentSettlement= MiscUtility.getWebElement(objFilepath, "CRA035_txt_currentSettlement");
    	 btn_save             = MiscUtility.getWebElement(objFilepath, "CRA035_btn_save");
    	btn_btnClose          = MiscUtility.getWebElement(objFilepath, "CRA035_btn_btnClose");
    	text_settlementCurrency = MiscUtility.getWebElement(objFilepath, "CRA035_text_settlementCurrency");
    }

    
    
    public CRA035 createSettlement(String invoicenumber,String AWBNo,String settlementamount){
    	
    	
    	invoicenumber = PropertyHandler.getPropValue(dataFilePath, invoicenumber);
    	AWBNo         = PropertyHandler.getPropValue(objFilepath, AWBNo);
    	settlementamount=PropertyHandler.getPropValue(objFilepath, settlementamount);
		
    	enterKeys(txt_invoiceNumber, invoicenumber);
    	click(btn_list);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(yesBtn);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	enterKeys(txt_searchAWB, AWBNo);
    	click(btn_search);
    	minWait();
    	enterKeys(text_settlementCurrency, "INR");
    	enterKeys(txt_currentSettlement, settlementamount);
    	
    	click(btn_save);
    	
    	
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
