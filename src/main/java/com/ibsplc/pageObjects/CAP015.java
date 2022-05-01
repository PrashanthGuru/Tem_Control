package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-8254
 */
public class CAP015 extends BasePage {

	
	
	 	public String dataFilePath;
	    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
	    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	  
	    public static String FRAME = "iCargoContentFrameCAP015";
	    
	    By	txt_UBRNo,
	         btn_list,
	         checkbox_result,
	         btn_details;
	         
		   
	    
	    
	    WebDriver driver;    
	    String testDataFile;
	    String browser;
	    
	    public CAP015(WebDriver driver, String dataFileName) {
			 super(driver);
	         this.driver = driver;
	         this.testDataFile = dataFileName;
	         PageFactory.initElements(this.driver,this);
	         dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+dataFileName;
	         initPageElements();
		}
	    
	    private void initPageElements(){	 
	        
	    	System.out.println("Going to capture all webElements..!");
	    	
	    	txt_UBRNo = MiscUtility.getWebElement(objFilepath,"CAP015_txt_allotId");
	    	btn_list = MiscUtility.getWebElement(objFilepath,"CAP015_btn_list");
	    	checkbox_result = MiscUtility.getWebElement(objFilepath,"CAP015_checkbox_result");
	    	btn_details = MiscUtility.getWebElement(objFilepath,"CAP015_btn_details");
	    }
	    
	    
	    public CAP018 listDetailsWithUBRNumber(String UBRNo)
	    {
	    	UBRNo = PropertyHandler.getPropValue(dataFilePath,UBRNo);
	    	enterKeys(txt_UBRNo, UBRNo);
	    	click(btn_list);
	    	minWait();
	    	click(checkbox_result);
	    	click(btn_details);
	    	minWait();
	    	
	    	return new CAP018(driver,testDataFile);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
 
	   
	   
}
