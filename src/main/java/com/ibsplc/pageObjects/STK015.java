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
public class STK015 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK015";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    By text_dateOfReq,
    btn_btList,dropDown_docType,
    dropDown_subType,
    text_reqStock,
    dropDown_stockHolderType,
    img_displayStockHolderLov,
    chkbox_stationChecked,
    btn_btOk,
    btn_btnSave,text_code,
    btn_btnClose;
    

    By btn_noBtn,
    btn_diaYes,
    info_msg;
    
    
    
    
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK015";
       
        btn_btList = MiscUtility.getWebElement(objFilepath,"STK015_btn_btList"); 
        info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        text_dateOfReq=MiscUtility.getWebElement(objFilepath, "STK015_text_dateOfReq");
        dropDown_docType	=MiscUtility.getWebElement(objFilepath, "STK015_dropDown_docType");	
        dropDown_subType=MiscUtility.getWebElement(objFilepath, "STK015_dropDown_subType");
        text_reqStock=MiscUtility.getWebElement(objFilepath, "STK015_text_reqStock");
        dropDown_stockHolderType=MiscUtility.getWebElement(objFilepath, "STK015_dropDown_stockHolderType");
        img_displayStockHolderLov=MiscUtility.getWebElement(objFilepath, "STK015_img_displayStockHolderLov");
        chkbox_stationChecked=MiscUtility.getWebElement(objFilepath, "STK015_chkbox_stationChecked");
        btn_btOk=MiscUtility.getWebElement(objFilepath, "STK015_btn_btOk");
        btn_btnSave=MiscUtility.getWebElement(objFilepath, "STK015_btn_btnSave");
        btn_btnClose=MiscUtility.getWebElement(objFilepath, "STK015_btn_btnClose");
        text_code=MiscUtility.getWebElement(objFilepath, "STK015_text_code");
    }


	 public STK015(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	
	 
	
					    public STK015 StockRequest(String DocType, String Subtype,String ReqQty,String StockHoldertype,String StockHolderCode){

					 
					 
					 DocType = PropertyHandler.getPropValue(dataFilePath,DocType);
					 
					 Subtype = PropertyHandler.getPropValue(dataFilePath,Subtype);
					 ReqQty = PropertyHandler.getPropValue(dataFilePath,ReqQty);
					 StockHoldertype = PropertyHandler.getPropValue(dataFilePath,StockHoldertype);
					 StockHolderCode = PropertyHandler.getPropValue(dataFilePath,StockHolderCode);
					 
					 click(btn_btList);
					 minWait();
					 driver.switchTo().defaultContent();
					 String status = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("No records exists. Do you want to create?"), "ERROR :No Provision to create new request.");
				     Assert.assertTrue(status.contains("No records exists. Do you want to create?"), "ERROR :No Provision to create new request.");
				     minWait();
				     click(btn_noBtn);
				     minWait();
				     waitForFrameAndSwitch(FRAME);
				     click(btn_btList);
					 minWait();
					 driver.switchTo().defaultContent();
					 String status1 = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("No records exists. Do you want to create?"), "ERROR :No Provision to create new request.");
				     Assert.assertTrue(status.contains("No records exists. Do you want to create?"), "ERROR :No Provision to create new request.");
				     minWait();
				     driver.switchTo().defaultContent();
				     click(btn_diaYes);
				     minWait();
				    
				     waitForFrameAndSwitch(FRAME);
					 selectByText(dropDown_docType, DocType);
					 selectByText(dropDown_subType, Subtype);
					 enterKeys(text_reqStock, ReqQty);
					 selectByText(dropDown_stockHolderType, StockHoldertype);
					 enterKeys(text_code, StockHolderCode);
					 click(btn_btnSave);
					 minWait();
					 driver.switchTo().defaultContent();
					 String status3 = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to save the data?"), "ERROR :No data saved");
				     //Assert.assertTrue(status3.contains("Do you want to save the data?"), "ERROR :No data saved");
				     minWait();
				     click(btn_noBtn);
				     minWait();
				     waitForFrameAndSwitch(FRAME);
				     
				     click(btn_btList);
					 minWait();
					 driver.switchTo().defaultContent();
					 String status4 = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("No records exists. Do you want to create?"), "ERROR :No Provision to create new request.");
				    // Assert.assertTrue(status.contains("No records exists. Do you want to create?"), "ERROR :No Provision to create new request.");
				     minWait();
				     driver.switchTo().defaultContent();
				     click(btn_diaYes);
				     minWait();
				     waitForFrameAndSwitch(FRAME);
				     
					 selectByText(dropDown_docType, DocType);
					 selectByText(dropDown_subType, Subtype);
					 enterKeys(text_reqStock, ReqQty);
					 selectByText(dropDown_stockHolderType, StockHoldertype);
					 enterKeys(text_code, StockHolderCode);
					 click(btn_btnSave);
					 minWait();
					 driver.switchTo().defaultContent();
					 String status5 = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to save the data?"), "ERROR :No data saved");
				   //  Assert.assertTrue(status.contains("Do you want to save the data?"), "ERROR :No data saved");
				     minWait();
				     click(btn_diaYes);
				     minWait();
				     waitForFrameAndSwitch(FRAME);
				     
					 
					 
					
				   //  click(btn_btClose);
				     return this;
				    }
			   			    public HomePage close() {

			        click(btn_btnClose);
			        driver.switchTo().defaultContent();
			        if (verifyElementPresent(btn_diaYes)) {

			            click(btn_diaYes);
			        }
			        return new HomePage(driver, dataFileName);
			    }

	 
}
