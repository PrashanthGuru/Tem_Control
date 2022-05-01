package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP009 extends BasePage {
	
	
	public String dataFilePath;
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
  
    public static String FRAME = "iCargoContentFrameCAP009";
    
	By
	
	btn_list,
	chkbx_selectData,
	btn_Copy,
	info_error,
	txt_Station,
	txt_Origin,
	yesBtn,
	btn_close;
	
	
	
	WebDriver driver;    
    String testDataFile;
    String browser;
    
    public CAP009(WebDriver driver, String dataFileName) {
		 super(driver);
         this.driver = driver;
         this.testDataFile = dataFileName;
         PageFactory.initElements(this.driver,this);
         dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+dataFileName;
         initPageElements();
	}
    
    private void initPageElements(){	 
        
    	System.out.println("Going to capture all webElements..!");
    	
    	
    	btn_list=MiscUtility.getWebElement(objFilepath, "CAP009_btn_list");
    	chkbx_selectData=MiscUtility.getWebElement(objFilepath, "CAP009_chkbx_selectData");
    	btn_Copy=MiscUtility.getWebElement(objFilepath, "CAP009_btn_Copy");
    	btn_close=MiscUtility.getWebElement(objFilepath, "CAP009_btn_close");
    	info_error=MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    	txt_Station=MiscUtility.getWebElement(objFilepath, "CAP012_txt_Station");
    	txt_Origin=MiscUtility.getWebElement(objFilepath, "CAP012_txt_Origin");
    	
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    
    public CAP009 listAllotments(String Origin){
    	
    	Origin=PropertyHandler.getPropValue(dataFilePath, Origin);
    	
    	click(btn_list);
    	minWait();
    	/*waitForElement(chkbx_selectData);*/
    	if(waitForElement(info_error).getText().contains("No results found for the specified criteria.")){
    		
    		System.out.println("No results found for the specified criteria.");
    	}
    	
    	check(chkbx_selectData);
    	click(btn_Copy);
    	minWait();
    	
    	verifyElementPresent(txt_Station);
    Assert.assertTrue(waitForElement(txt_Station).getAttribute("value").equals(Origin));
    Assert.assertTrue(waitForElement(txt_Origin).getAttribute("value").equals(Origin));
	return this;
    	
    }
    
    public HomePage close(){
    	
    	click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }
        return new HomePage(driver,testDataFile);
    }
    
    
    
}
