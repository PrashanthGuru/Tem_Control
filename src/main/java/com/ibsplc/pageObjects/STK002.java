package com.ibsplc.pageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/18/2017.
 */
public class STK002 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK002";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    By btn_btnList,
    dropDown_docType,
    dropDown_docSubType,
    text_stockControlFor,
    Tbl_stockTable,
    chkbox_checkbox,
    btn_btnReject,
    btn_btnApprove,
    text_appremarks,
    text_approvedStock,
    btn_btnComplete,
    dropDown_status,
    text_startRange,
    btn_btnAllocate,dropDown_SubType,
    btnClose,btnListRange,
    btn_btnAllocateNew,
    text_stockHolderCode,
    text_rangeFrom,text_numberOfDocs,
    btn_btnlistAllocateNew,
    chckbox_availableRangeNo,btn_btnMoveRange,
    btn_btnSave;
    

    By btn_noBtn,
    btn_diaYes,
    info_msg;
    
    
    
    
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK002";
        btn_btnList=MiscUtility.getWebElement(objFilepath,"STK002_btn_btnList");
        dropDown_docType=MiscUtility.getWebElement(objFilepath,"STK002_dropDown_docType");
        dropDown_docSubType=MiscUtility.getWebElement(objFilepath,"STK002_dropDown_docSubType");
        text_stockControlFor=MiscUtility.getWebElement(objFilepath,"STK002_text_stockControlFor");
        Tbl_stockTable=MiscUtility.getWebElement(objFilepath,"STK002_Tbl_stockTable");
        chkbox_checkbox=MiscUtility.getWebElement(objFilepath,"STK002_chkbox_checkbox");
        btn_btnReject=MiscUtility.getWebElement(objFilepath,"STK002_btn_btnReject");
        btn_btnApprove=MiscUtility.getWebElement(objFilepath,"STK002_btn_btnApprove");
        text_appremarks=MiscUtility.getWebElement(objFilepath,"STK002_text_appremarks");
        text_approvedStock=MiscUtility.getWebElement(objFilepath,"STK002_text_approvedStock");
        btn_btnComplete=MiscUtility.getWebElement(objFilepath,"STK002_btn_btnComplete");
        dropDown_status=MiscUtility.getWebElement(objFilepath,"STK002_dropDown_status");
        text_startRange=MiscUtility.getWebElement(objFilepath,"STK002_text_startRange");
        btn_btnAllocate=MiscUtility.getWebElement(objFilepath,"STK002_btn_btnAllocate");
        btnClose=MiscUtility.getWebElement(objFilepath,"STK002_btn_btnClose");
        info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btnListRange= MiscUtility.getWebElement(objFilepath, "STK002_btn_btnListRange");
        btn_btnAllocateNew= MiscUtility.getWebElement(objFilepath, "STK002_btn_btnAllocateNew");
        text_stockHolderCode=MiscUtility.getWebElement(objFilepath, "STK002_text_stockHolderCode");
        text_rangeFrom=MiscUtility.getWebElement(objFilepath, "STK002_text_rangeFrom");
        text_numberOfDocs=MiscUtility.getWebElement(objFilepath, "STK002_text_numberOfDocs");
        btn_btnlistAllocateNew=MiscUtility.getWebElement(objFilepath, "STK002_btn_btnlistAllocateNew");
        chckbox_availableRangeNo=MiscUtility.getWebElement(objFilepath, "STK002_chckbox_availableRangeNo");
        btn_btnMoveRange=MiscUtility.getWebElement(objFilepath, "STK002_btn_btnMoveRange");
        btn_btnSave=MiscUtility.getWebElement(objFilepath, "STK002_btn_btnSave");
        dropDown_SubType=MiscUtility.getWebElement(objFilepath,"STK002_dropDown_SubType");
    }
    private static final String CHAR_LIST = 
	        "1234567890";
	    private static final int RANDOM_STRING_LENGTH = 7;
	    
	    public String generateRandomString(){
	         
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }
	    private int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }



	 public STK002(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	  public STK002 ListApproveAllocateCompleteRequest(String DocType, String Subtype,String stockControlOf,String status,String ApprovedStock,String stockRange1){
		 
		 // String StockRange = generateRandomString();
		//  PropertyHandler.setPropValue(dataFilePath,stockRange1, StockRange);
		  DocType = PropertyHandler.getPropValue(dataFilePath,DocType);
		  Subtype = PropertyHandler.getPropValue(dataFilePath,Subtype);
		  stockControlOf = PropertyHandler.getPropValue(dataFilePath,stockControlOf);
		  status = PropertyHandler.getPropValue(dataFilePath,status);
		  
		  
		 selectByText(dropDown_docType, DocType);
		  selectByText(dropDown_docSubType, Subtype);
		  enterKeys(text_stockControlFor, stockControlOf);
		  selectByText(dropDown_status, status);
		  click(btn_btnList);
		  minWait();
		
		  enterKeys(text_approvedStock, ApprovedStock);
		  check(chkbox_checkbox);
		  enterKeys(text_appremarks, "Approved");
		  click(btn_btnApprove);
		  
		  minWait();
		  driver.switchTo().defaultContent();
		  click(btn_diaYes);
		  waitForFrameAndSwitch(FRAME);
		  
		  selectByText(dropDown_docType, DocType);
		  selectByText(dropDown_docSubType, Subtype);
		  enterKeys(text_stockControlFor, stockControlOf);
		  selectByText(dropDown_status, "Approved");
		  click(btn_btnList);
		  minWait();
		  String Status1 = getTableCellValue(Tbl_stockTable, 12, 1);
		  Assert.assertTrue(waitForElement(Tbl_stockTable).getText().contains(Status1),"ERROR :Stock not allocated successfully");
		  
		  check(chkbox_checkbox);
		   
		  enterKeys(text_startRange,"1000000");
		  click(btnListRange);
		  minWait();
		 
		  click(btn_btnAllocate);
		  minWait();
		
		  String Status = getTableCellValue(Tbl_stockTable, 12, 1);
		  Assert.assertTrue(waitForElement(Tbl_stockTable).getText().contains(Status),"ERROR :Stock not allocated successfully");
		  
		  click(btn_btnComplete);
		  minWait();
			 driver.switchTo().defaultContent();
			 String status1 = waitForElement(info_msg).getText();
			 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to complete the stock request(s)?"), "ERROR :No Provision to allocate stock.");
		     Assert.assertTrue(status1.contains("Do you want to complete the stock request(s)?"), "ERROR :No Provision to allocate stock.");
		     minWait();
		    
		     click(btn_diaYes);
		     minWait();
		     
		     waitForFrameAndSwitch(FRAME);
		     
		  
		 		 return this;
	  }
	  
	  public STK002 RejectRequest(String DocType, String Subtype,String stockControlOf,String status){
			 
		 
		  DocType = PropertyHandler.getPropValue(dataFilePath,DocType);
		  Subtype = PropertyHandler.getPropValue(dataFilePath,Subtype);
		  stockControlOf = PropertyHandler.getPropValue(dataFilePath,stockControlOf);
		  status = PropertyHandler.getPropValue(dataFilePath,status);
		  
		  selectByText(dropDown_docType, DocType);
		  selectByText(dropDown_docSubType, Subtype);
		  enterKeys(text_stockControlFor, stockControlOf);
		  selectByText(dropDown_status, status);
		  click(btn_btnList);
		  minWait();
		 // driver.switchTo().defaultContent();
		
		  check(chkbox_checkbox);
		  enterKeys(text_appremarks, "Rejected");
		  click(btn_btnReject);
		  
		  minWait();
			 driver.switchTo().defaultContent();
			 String status1 = waitForElement(info_msg).getText();
			 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to reject the stock request(s)?"), "ERROR :No Provision to reject request.");
		     Assert.assertTrue(status1.contains("Do you want to reject the stock request(s)?"), "ERROR :No Provision to reject request.");
		     minWait();
		     click(btn_diaYes);
		     minWait();
		     
		     waitForFrameAndSwitch(FRAME);
		     
		  
		 		 return new STK002(driver,dataFileName);
	  }
	  
	  public STK002 AllocateNewStock(String DocType, String Subtype,String stockControlOf,String Stockholder,String status,String FromRange,String NoDocs){
			 
		 
		  DocType = PropertyHandler.getPropValue(dataFilePath,DocType);
		  Subtype = PropertyHandler.getPropValue(dataFilePath,Subtype);
		  stockControlOf = PropertyHandler.getPropValue(dataFilePath,stockControlOf);
		  status = PropertyHandler.getPropValue(dataFilePath,status);
		  Stockholder=PropertyHandler.getPropValue(dataFilePath,Stockholder);
		  FromRange=PropertyHandler.getPropValue(dataFilePath,FromRange);
		  NoDocs=PropertyHandler.getPropValue(dataFilePath,NoDocs);
		  
		  selectByText(dropDown_docType, DocType);
		  selectByText(dropDown_docSubType, Subtype);
		  enterKeys(text_stockControlFor, stockControlOf);
		  selectByText(dropDown_status, status);
		  click(btn_btnList);
		  minWait();
		 // driver.switchTo().defaultContent();
		  click(btn_btnAllocateNew);
		  minWait();
		 // driver.switchTo().defaultContent();
		  selectByText(dropDown_docType, DocType);
		  selectByText(dropDown_SubType, Subtype);
		  enterKeys(text_stockControlFor, stockControlOf);
		  enterKeys(text_stockHolderCode,Stockholder);
		  enterKeys(text_rangeFrom,FromRange);
		  enterKeys(text_numberOfDocs,NoDocs);
		  click(btn_btnlistAllocateNew);
		  minWait();
		 // driver.switchTo().defaultContent();
		  check(chckbox_availableRangeNo);
		  click(btn_btnMoveRange);
		  minWait();
		  click(btn_btnSave);
		  minWait();
			 driver.switchTo().defaultContent();
			 String status1 = waitForElement(info_msg).getText();
			 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to allocate the stock?"), "ERROR :No Provision to allocate new stock.");
		     Assert.assertTrue(status1.contains("Do you want to allocate the stock?"), "ERROR :No Provision to allocate new stock.");
		     minWait();
		     click(btn_diaYes);
		     minWait();
		     
		     waitForFrameAndSwitch(FRAME);
		     
		  
		  
		  
		 		 return new STK002(driver,dataFileName);
	  }
	
	
					    public HomePage close() {

			        click(btnClose);
			        driver.switchTo().defaultContent();
			        if (verifyElementPresent(btn_diaYes)) {

			            click(btn_diaYes);
			        }
			        return new HomePage(driver, dataFileName);
			    }

	 
}
