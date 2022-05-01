package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


public class SHR024 extends BasePage{

	public static String FRAME = "iCargoContentFrameSHR003";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    WebDriver driver;
    String screenFrame;
    String dataFileName;
        
    By

    txt_scc1,
    txt_scc2,
    dropdown_errorWarning,
    txt_remarks,
    dropdown_level,
    btn_save,
    btn_close;
    
    
    public SHR024(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initPageElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    
    /**
     * Method to initialize page objects
     */
    private void initPageElements(){	
    	
    	txt_scc1=MiscUtility.getWebElement(objFilepath, "SHR024_txt_scc1");
        txt_scc2=MiscUtility.getWebElement(objFilepath, "SHR024_txt_scc2");
        dropdown_errorWarning=MiscUtility.getWebElement(objFilepath, "SHR024_dropdown_errorWarning");
        txt_remarks=MiscUtility.getWebElement(objFilepath, "SHR024_txt_remarks");
        dropdown_level=MiscUtility.getWebElement(objFilepath, "SHR024_dropdown_level");
        btn_save=MiscUtility.getWebElement(objFilepath, "SHR024_btn_save");
        btn_close=MiscUtility.getWebElement(objFilepath, "SHR024_btn_close");
    	
    }

    
    public SHR024 saveSCCIncompatibility(String scc1,String scc2,String type,String level){
    	
    	scc1=PropertyHandler.getPropValue(dataFilePath, scc1);
    	scc2=PropertyHandler.getPropValue(dataFilePath, scc2);
    	level=PropertyHandler.getPropValue(dataFilePath, level);
    	
    	
    	enterKeys(txt_scc1, scc1);
    	enterKeys(txt_scc2, scc2);
    	selectByText(dropdown_errorWarning, type);
    	selectByText(dropdown_level, level);
    	
    	enterKeys(txt_remarks, "RLI and RPB cannot be built up in one ULD");
    	
    	click(btn_save);
    	
    	minWait();
		return this;
    	
    }
    
    
    
    
    
    
    
    
    
}
