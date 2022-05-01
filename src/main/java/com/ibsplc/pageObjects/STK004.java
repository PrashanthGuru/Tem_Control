package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/18/2017.
 */
public class STK004 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK004";
   // public static String FRAME2 = "iCargoContentFrameSTK014";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    By dropDown_subType,
    dropDown_docType,
    text_rangeFrom,
    text_rangeTo,
    text_noOfDocs,
    btn_btclose;
    

    By btn_noBtn,
    btn_diaYes,
    info_msg;
    
    
    
    
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK004";
      
        dropDown_docType=MiscUtility.getWebElement(objFilepath,"STK004_dropDown_docType");
        dropDown_subType=MiscUtility.getWebElement(objFilepath,"STK004_dropDown_subType");
        text_rangeFrom=MiscUtility.getWebElement(objFilepath,"STK004_text_rangeFrom");
        text_rangeTo=MiscUtility.getWebElement(objFilepath,"STK004_text_rangeTo");
        text_noOfDocs=MiscUtility.getWebElement(objFilepath,"STK004_text_noOfDocs");
        btn_btclose=MiscUtility.getWebElement(objFilepath,"STK004_btn_btclose");
        btn_diaYes=MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
       	
    }


	 public STK004(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	  public STK004 CheckFields(){
		  
		  
		  Assert.assertTrue(waitForElement(dropDown_docType).getText().contains("AWB"),"Error: The value not present");
		  //Assert.assertTrue(waitForElement(dropDown_docType).getText().contains("INVOICE"),"Error: The value not present");
		  //Assert.assertTrue(waitForElement(dropDown_docType).getText().contains("ORDINO"),"Error: The value not present");
		  selectByValue(dropDown_docType, "AWB");
		  List<String> s=getAllValues(dropDown_subType);
		  
		 
		  Assert.assertTrue(s.contains("C"),"Error: The value not present");
		  Assert.assertTrue(s.contains("S"),"Error: The value not present");
		  Assert.assertTrue(s.contains("M"),"Error: The value not present");
		  
		  enterKeys(text_rangeFrom, "1000000");
		  enterKeys(text_rangeTo, "1000010");
		  enterKeys(text_rangeFrom, Keys.TAB);
		  minWait();
		  Assert.assertTrue(waitForElement(text_noOfDocs).getAttribute("value").contains("11"),"Error: Total docs not correct");
		  
		 
		 return this;
	  }
	
	
							        
			        
			        public HomePage close() {

			            click(btn_btclose);
			            driver.switchTo().defaultContent();
			            if (verifyElementPresent(btn_diaYes)) {

			                click(btn_diaYes);
			            }
			            return new HomePage(driver, dataFileName);
			        }

			    

			    }

	 

