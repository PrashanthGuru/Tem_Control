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
public class STK006 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK006";
   // public static String FRAME2 = "iCargoContentFrameSTK014";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    By dropDown_stockHolderType,
    text_stockHolderCode,
    dropDown_docSubType,
    dropDown_docType,
    btn_btList,
    Tbl_listStockHolderTable,
    btn_btClose,btn_btDetails,
    txt_stockHolderCode,
    chkbox_checkStockHolder,
    chkbox_partnerAirline;
    

    By btn_noBtn,
    btn_diaYes,
    info_msg;
    
    
    
    
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK006";
        dropDown_stockHolderType=MiscUtility.getWebElement(objFilepath,"STK006_dropDown_stockHolderType");
        text_stockHolderCode=MiscUtility.getWebElement(objFilepath,"STK006_text_stockHolderCode");
        dropDown_docType=MiscUtility.getWebElement(objFilepath,"STK006_dropDown_docType");
        dropDown_docSubType=MiscUtility.getWebElement(objFilepath,"STK006_dropDown_docSubType");
        btn_btList=MiscUtility.getWebElement(objFilepath,"STK006_btn_btList");
        Tbl_listStockHolderTable=MiscUtility.getWebElement(objFilepath,"STK006_Tbl_listStockHolderTable");
        btn_btClose=MiscUtility.getWebElement(objFilepath,"STK006_btn_btClose");
        btn_btDetails=MiscUtility.getWebElement(objFilepath,"STK006_btn_btDetails");
       	txt_stockHolderCode=	MiscUtility.getWebElement(objFilepath,"STK014_txt_stockHolderCode");	
       	chkbox_checkStockHolder=MiscUtility.getWebElement(objFilepath,"STK006_chkbox_checkStockHolder");
       	chkbox_partnerAirline=MiscUtility.getWebElement(objFilepath,"STK006_chkbox_partnerAirline");
       	
    }


	 public STK006(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	  public STK006 CheckStockHolderDetails(String stockHolderType,String stockHolderCode,String Doctype,String Subtype){
		  
		 
		  stockHolderCode = PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
		  stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
		  Doctype = PropertyHandler.getPropValue(dataFilePath,Doctype);
		  Subtype = PropertyHandler.getPropValue(dataFilePath,Subtype);
		  selectByText(dropDown_stockHolderType, stockHolderType);
		  enterKeys(text_stockHolderCode, stockHolderCode);
		  selectByText(dropDown_docType, Doctype);
		  selectByText(dropDown_docSubType, Subtype);
		  click(btn_btList);
		  minWait();
		
		
		  check(chkbox_checkStockHolder);
		  click(btn_btDetails);
		  minWait();
		 
		  String stockholder = waitForElement(txt_stockHolderCode).getAttribute("value");
		  Assert.assertTrue(waitForElement(txt_stockHolderCode).getAttribute("value").contains(stockHolderCode),"ERROR :Stockholder details not found");
		  Assert.assertTrue(stockholder.contains(stockHolderCode), "ERROR :Stockholder details not found");
		  
		 return this;
	  }
	  public STK006 ListStockHolderPartnerAirline(String stockHolderType,String stockHolderCode,String Doctype,String Subtype){
		  
			 
		  stockHolderCode = PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
		  stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
		  Doctype = PropertyHandler.getPropValue(dataFilePath,Doctype);
		  Subtype = PropertyHandler.getPropValue(dataFilePath,Subtype);
		  selectByText(dropDown_stockHolderType, stockHolderType);
		  enterKeys(text_stockHolderCode, stockHolderCode);
		  selectByText(dropDown_docType, Doctype);
		  selectByText(dropDown_docSubType, Subtype);
		  check(chkbox_partnerAirline);
		  click(btn_btList);
		  minWait();
		  driver.switchTo().defaultContent();
		  minWait();
		  waitForFrameAndSwitch(FRAME);
		  check(chkbox_checkStockHolder);
		  
		 
		  
		  
		 return this;
	  }
	
							        
			        
			        public HomePage close() {

			            click(btn_btClose);
			            driver.switchTo().defaultContent();
			            if (verifyElementPresent(btn_diaYes)) {

			                click(btn_diaYes);
			            }
			            return new HomePage(driver, dataFileName);
			        }

			    

			    }

	 

