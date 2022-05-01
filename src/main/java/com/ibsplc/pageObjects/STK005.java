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
public class STK005 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK005";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    By dropDown_docType,
    dropDown_subType,
    btn_btnList,
    tbl_blklistedStockTable,
    checkbox_blacklistCheck,
    btn_btnRevoke,
    btn_btnClose,
    btn_btrevoke,btn_CloseRevokepopup,
    btn_Ok,
    text_rangeFrom,
    text_rangeTo;
    

    By btn_noBtn,
    btn_diaYes,
    info_msg;
    
    
    
    
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK005";
        dropDown_docType=MiscUtility.getWebElement(objFilepath,"STK005_dropDown_docType");
        dropDown_subType=MiscUtility.getWebElement(objFilepath,"STK005_dropDown_subType");
        btn_btnList=MiscUtility.getWebElement(objFilepath,"STK005_btn_btnList");
        tbl_blklistedStockTable=MiscUtility.getWebElement(objFilepath,"STK005_tbl_blklistedStockTable");
        checkbox_blacklistCheck=MiscUtility.getWebElement(objFilepath,"STK005_checkbox_blacklistCheck");
        btn_btnRevoke=MiscUtility.getWebElement(objFilepath,"STK005_btn_btnRevoke");
        btn_btnClose=MiscUtility.getWebElement(objFilepath,"STK005_btn_btnClose");
        info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
       btn_btrevoke=MiscUtility.getWebElement(objFilepath,"STK005_btn_btrevoke");
       btn_Ok=MiscUtility.getWebElement(genObjPath,"Generic_btn_ok");
       text_rangeFrom=MiscUtility.getWebElement(objFilepath,"STK005_text_rangeFrom");
       text_rangeTo=MiscUtility.getWebElement(objFilepath,"STK005_text_rangeTo");
       btn_CloseRevokepopup=MiscUtility.getWebElement(objFilepath,"STK005_btn_CloseRevokepopup");
    }
   


	 public STK005(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	  public STK005 ListRevoke(String doctype,String docsubtype,String awbno,String RangeFrm){
		 
		
		  doctype = PropertyHandler.getPropValue(dataFilePath,doctype);
		  docsubtype = PropertyHandler.getPropValue(dataFilePath,docsubtype);
		  selectByText(dropDown_docType, doctype);
		  selectByText(dropDown_subType, docsubtype);
		  
		  
		  click(btn_btnList);
		  minWait();
			
			
			  String Range = getTableCellValue(tbl_blklistedStockTable, 8, 1);
			  PropertyHandler.setPropValue(dataFilePath, RangeFrm, Range);
			 int R = Integer.parseInt(Range);
			 
			 int mod 	= 	R % 7;
			int	awb_no 	=	R * 10;
				awb_no 	+= 	mod;
				
			 String AWB=String.valueOf(awb_no);
			 PropertyHandler.setPropValue(dataFilePath, awbno, AWB);
			 
			
				System.out.println("Blacklisted data listed");
				check(checkbox_blacklistCheck);
				click(btn_btnRevoke);
				minWait();
				 driver.switchTo().defaultContent();
			        waitForNewWindow(2);

			        switchToSecondWindow();
			        
			        click(btn_btrevoke);
			     
			       
			        minWait();
				     driver.switchTo().defaultContent();
					 String status1 = waitForElement(info_msg).getText();
					 
				     Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to revoke the blacklisted stock?"), "ERROR :No Provision to revoke blacklisted stock.");
				     Assert.assertTrue(status1.contains("Do you want to revoke the blacklisted stock?"), "ERROR :No Provision to revoke blacklisted stock.");
				     click(btn_noBtn);
				     minWait();
				     
				     click(btn_btrevoke);
				     
				  
				        minWait();
					     driver.switchTo().defaultContent();
						click(btn_diaYes);
					     minWait();
					     click(btn_CloseRevokepopup);
					     minWait();
					        
					        
					    
	/* String status2 = waitForElement(info_msg).getText();
						 
					     Assert.assertTrue(waitForElement(info_msg).getText().contains("Revoke Successful."), "ERROR :Revoke not Successful..");
					     Assert.assertTrue(status2.contains("Revoke Successful."), "ERROR :Revoke not Successful..");
					     click(btn_Ok);
					     minWait();
					     */
				   
			               switchToFirstWindow();

			               waitForFrameAndSwitch(FRAME);
			    		
			 
			 
			 
			 
		 		 return this;
	  }
	  
	  public STK005 ListRevokeRange(String doctype,String docsubtype,String blacklistfrmrng){
			 
			
		  doctype = PropertyHandler.getPropValue(dataFilePath,doctype);
		  docsubtype = PropertyHandler.getPropValue(dataFilePath,docsubtype);
		  blacklistfrmrng = PropertyHandler.getPropValue(dataFilePath,blacklistfrmrng);
		  //blacklisttorng = PropertyHandler.getPropValue(dataFilePath,blacklisttorng);
		  selectByText(dropDown_docType, doctype);
		  selectByText(dropDown_subType, docsubtype);
		  enterKeys(text_rangeFrom, blacklistfrmrng);
		  enterKeys(text_rangeTo, blacklistfrmrng);
		  
		  click(btn_btnList);
		  minWait();
			
			
			// String Doc = getTableCellValue(tbl_blklistedStockTable, 2, 1);
		  check(checkbox_blacklistCheck);
			click(btn_btnRevoke);
			minWait();
			 driver.switchTo().defaultContent();
		        waitForNewWindow(2);

		        switchToSecondWindow();
		        
		        click(btn_btrevoke);
		     
		       
		        minWait();
			     driver.switchTo().defaultContent();
				 String status1 = waitForElement(info_msg).getText();
				 
			     Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to revoke the blacklisted stock?"), "ERROR :No Provision to revoke blacklisted stock.");
			     Assert.assertTrue(status1.contains("Do you want to revoke the blacklisted stock?"), "ERROR :No Provision to revoke blacklisted stock.");
			     click(btn_noBtn);
			     minWait();
			     
			     click(btn_btrevoke);
			     
			  
			        minWait();
				     driver.switchTo().defaultContent();
					click(btn_diaYes);
				     minWait();
				     click(btn_CloseRevokepopup);
				     minWait();
				        
				        
				    
/* String status2 = waitForElement(info_msg).getText();
					 
				     Assert.assertTrue(waitForElement(info_msg).getText().contains("Revoke Successful."), "ERROR :Revoke not Successful..");
				     Assert.assertTrue(status2.contains("Revoke Successful."), "ERROR :Revoke not Successful..");
				     click(btn_Ok);
				     minWait();
				     */
			   
		               switchToFirstWindow();

		               waitForFrameAndSwitch(FRAME);
		    		
		 
		 
		 
		 
	 		 return this;
}
	  
	
	  public STK005 GetBlacklistedRange(String doctype,String docsubtype,String BlacklistedAWB,String BlacklistedRangefrm,String BlacklistedRangeto){
		  	 
			
		  doctype = PropertyHandler.getPropValue(dataFilePath,doctype);
		  docsubtype = PropertyHandler.getPropValue(dataFilePath,docsubtype);
		  selectByText(dropDown_docType, doctype);
		  selectByText(dropDown_docType, docsubtype);
		  
		  
		  click(btn_btnList);
		  minWait();
			 driver.switchTo().defaultContent();
			
			 String Doc = getTableCellValue(tbl_blklistedStockTable, 8, 1);
			 System.out.println(Doc);
			 String Doc1 = getTableCellValue(tbl_blklistedStockTable, 9, 1);
			 System.out.println(Doc1);
			int awb_no;
			String str_awb;
			int mod_value = 7;
			int range = Integer.parseInt(Doc);
			
			int mod;
			mod 	= 	range % mod_value;
			awb_no 	=	range * 10;
			awb_no 	+= 	mod;
			str_awb = String.valueOf(awb_no);
		       		
			 PropertyHandler.setPropValue(dataFilePath, BlacklistedAWB, str_awb);
			 PropertyHandler.setPropValue(dataFilePath, BlacklistedRangefrm, Doc);
			 PropertyHandler.setPropValue(dataFilePath, BlacklistedRangeto, Doc1);
			 
			 
		 		 return new STK005(driver,dataFileName);
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
