package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/18/2017.
 */
public class STK003 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK003";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    By dropDown_docType,
    dropDown_docSubType,
    text_stockHolderCode,
    btn_btblacklist,
    btn_btclose,
    btn_Ok,text_rangeFrom,
    text_rangeTo;
    

    By btn_noBtn,
    btn_diaYes,
    info_msg;
    
    
    
    
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK003";
        dropDown_docType=MiscUtility.getWebElement(objFilepath,"STK003_dropDown_docType");
        dropDown_docSubType=MiscUtility.getWebElement(objFilepath,"STK003_dropDown_docSubType");
        text_stockHolderCode=MiscUtility.getWebElement(objFilepath,"STK003_text_stockHolderCode");
        btn_btblacklist=MiscUtility.getWebElement(objFilepath,"STK003_btn_btblacklist");
        btn_btclose=MiscUtility.getWebElement(objFilepath,"STK019_btn_btclose");
        btn_Ok=MiscUtility.getWebElement(genObjPath,"Generic_btn_ok");
        info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        text_rangeFrom=MiscUtility.getWebElement(objFilepath,"STK003_text_rangeFrom");
        text_rangeTo=MiscUtility.getWebElement(objFilepath,"STK003_text_rangeTo");
    }
   


	 public STK003(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	  public STK003 BlacklistStockholder(String doctype,String docsubtype,String Stockholder){
		 
		 // String StockRange = generateRandomString();
		//  PropertyHandler.setPropValue(dataFilePath,stockRange1, StockRange);
		  Stockholder = PropertyHandler.getPropValue(dataFilePath,Stockholder);
		  doctype = PropertyHandler.getPropValue(dataFilePath,doctype);
		  docsubtype = PropertyHandler.getPropValue(dataFilePath,docsubtype);
		  selectByText(dropDown_docType, doctype);
		  selectByText(dropDown_docSubType, docsubtype);
		  enterKeys(text_stockHolderCode, Stockholder);
		  
		  click(btn_btblacklist);
		  minWait();
			 driver.switchTo().defaultContent();
			 String status3 = waitForElement(info_msg).getText();
			 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to blacklist the stock?"), "ERROR :No provision to blacklist");
		     Assert.assertTrue(status3.contains("Do you want to blacklist the stock?"), "ERROR :No provision to blacklist");
		     minWait();
		     click(btn_noBtn);
		     minWait();
		     waitForFrameAndSwitch(FRAME);
		     
		     click(btn_btblacklist);
			  minWait();
				 driver.switchTo().defaultContent();
				// String status4 = waitForElement(info_msg).getText();
				// Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to blacklist the stock?"), "ERROR :No provision to blacklist");
			    // Assert.assertTrue(status4.contains("Do you want to blacklist the stock?"), "ERROR :No provision to blacklist");
			     minWait();
			     click(btn_diaYes);
			     minWait();
			     String status4 = waitForElement(info_msg).getText();
				 Assert.assertTrue(waitForElement(info_msg).getText().contains("BlackListed."), "ERROR :No provision to blacklist");
			     Assert.assertTrue(status4.contains("BlackListed."), "ERROR :No provision to blacklist");
			     minWait();
			     click(btn_Ok);
			     waitForFrameAndSwitch(FRAME);
		  
		 		 return this;
	  }
	  
	  public STK003 BlacklistStockholderWithRange(String doctype,String docsubtype,String Stockholder,String Rangefrm){
			 
			 // String StockRange = generateRandomString();
			//  PropertyHandler.setPropValue(dataFilePath,stockRange1, StockRange);
			  Stockholder = PropertyHandler.getPropValue(dataFilePath,Stockholder);
			  doctype = PropertyHandler.getPropValue(dataFilePath,doctype);
			  docsubtype = PropertyHandler.getPropValue(dataFilePath,docsubtype);
		//	  Rangefrm= PropertyHandler.getPropValue(dataFilePath,Rangefrm);
			  selectByText(dropDown_docType, doctype);
			  selectByText(dropDown_docSubType, docsubtype);
			  enterKeys(text_stockHolderCode, Stockholder);
			  enterKeys(text_rangeFrom, Rangefrm);
			 /* int R = Integer.parseInt(Rangefrm);
			  R=R+10;
			  String Rangeto=String.valueOf(R);
			  System.out.println(Rangeto);
			  PropertyHandler.setPropValue(dataFilePath, BlacklistedRangeTo, Rangeto);
			  BlacklistedRangeTo = PropertyHandler.getPropValue(dataFilePath,BlacklistedRangeTo);
			  System.out.println(BlacklistedRangeTo);*/
			  enterKeys(text_rangeTo,Rangefrm);
			  
			  click(btn_btblacklist);
			  minWait();
				 driver.switchTo().defaultContent();
				 //String status3 = waitForElement(info_msg).getText();
				 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to blacklist the stock?"), "ERROR :No provision to blacklist");
			     //Assert.assertTrue(status3.contains("Do you want to blacklist the stock?"), "ERROR :No provision to blacklist");
			     minWait();
			     click(btn_noBtn);
			     minWait();
			     waitForFrameAndSwitch(FRAME);
			     
			     click(btn_btblacklist);
				  minWait();
					 driver.switchTo().defaultContent();
					// String status4 = waitForElement(info_msg).getText();
					// Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to blacklist the stock?"), "ERROR :No provision to blacklist");
				    // Assert.assertTrue(status4.contains("Do you want to blacklist the stock?"), "ERROR :No provision to blacklist");
				     minWait();
				     click(btn_diaYes);
				     minWait();
				     String status4 = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("BlackListed."), "ERROR :No provision to blacklist");
				     Assert.assertTrue(status4.contains("BlackListed."), "ERROR :No provision to blacklist");
				     minWait();
				     click(btn_Ok);
				     waitForFrameAndSwitch(FRAME);
			  
			 		 return new STK003(driver,dataFileName);
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
