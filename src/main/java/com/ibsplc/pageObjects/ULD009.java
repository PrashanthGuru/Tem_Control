package com.ibsplc.pageObjects;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Page ULD009 : ULD Transactions Enquiry
 * 
 * @author a-7868
 *<on 27/12/2017>
 *
 */
public class ULD009 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	 
	public static String FRAME = "iCargoContentFrameULD009";
	
	private By   txt_uldNum,
				 btn_close,
				 btn_list,
				 tbl_uldDtls,
				 img_tic,
				 GENINVOICE,
				 btn_clear,
				 RETURN_date,
				 btn_Delete,
				 btn_genericYes,
				 btn_MODIFYTXN,
				 td_txnType,
				 btn_MODIFY_OK,
				 txt_TOTDEMAMT,
				 txt_TxnRemarks,
				 RETURN,
				 check1,
				 SHOWTOTAL,
				 check2,
				 Generic_info_error,
				 btn_genericOk,
				 PRINTALL,
				 td_toParty,
				 PRINT_UCR,
				 btn_INVOICE_GENERATE,
				 TXNTYPE,
				 btn_GENLUC_OK,
				 btn_genericNo,
				 info_footer,
				 Generic_info_msg,
				 btn_GENLUC,
				 btn_GENMUC,
				 td_frmParty;

	private WebDriver driver;
	private String screenFrame;
	private String dataFileName;
	
	public ULD009(WebDriver driver, String dataFileName) {
		 super(driver);
	     this.driver = driver;
	     initElements();
	     this.dataFilePath = this.dataFilePath + dataFileName;
	     this.dataFileName = dataFileName;
	    }
	
	/**
	 * Method to initialize page objects
	 * 27/12/2017
	 * 
	 * @author a-7868
	 */
	private void initElements() {
		 
		 txt_uldNum = MiscUtility.getWebElement(objFilepath,"ULD009_txt_uldNo");
		 btn_list	= MiscUtility.getWebElement(objFilepath,"ULD009_btn_list");
		 tbl_uldDtls= MiscUtility.getWebElement(objFilepath,"ULD009_tbl_uldTransDtls");
		 btn_close	= MiscUtility.getWebElement(objFilepath,"ULD009_btn_close");		 
		 GENINVOICE= MiscUtility.getWebElement(objFilepath,"ULD009_GENINVOICE");	
		 btn_clear	= MiscUtility.getWebElement(objFilepath,"ULD009_btn_clear");
		 btn_Delete= MiscUtility.getWebElement(objFilepath,"ULD009_btn_Delete");
		 RETURN_date= MiscUtility.getWebElement(objFilepath,"ULD009_RETURN_date");
		 td_txnType	= MiscUtility.getWebElement(objFilepath,"ULD009_td_txnType");
		 txt_TOTDEMAMT= MiscUtility.getWebElement(objFilepath,"ULD009_txt_TOTDEMAMT");
		 TXNTYPE= MiscUtility.getWebElement(objFilepath,"ULD009_TXNTYPE");
		 td_toParty	= MiscUtility.getWebElement(objFilepath,"ULD009_td_toParty");
		 btn_INVOICE_GENERATE	= MiscUtility.getWebElement(objFilepath,"ULD009_btn_INVOICE_GENERATE");
		 PRINTALL	= MiscUtility.getWebElement(objFilepath,"ULD009_PRINTALL");
		 td_frmParty= MiscUtility.getWebElement(objFilepath,"ULD009_td_frmParty");
		 SHOWTOTAL= MiscUtility.getWebElement(objFilepath,"ULD009_SHOWTOTAL");
		 PRINT_UCR= MiscUtility.getWebElement(objFilepath,"ULD009_PRINT_UCR");
		 check1= MiscUtility.getWebElement(objFilepath,"ULD009_check1");
		 btn_MODIFY_OK= MiscUtility.getWebElement(objFilepath,"ULD009_btn_MODIFY_OK");
		 check2= MiscUtility.getWebElement(objFilepath,"ULD009_check2");
		 btn_MODIFYTXN= MiscUtility.getWebElement(objFilepath,"ULD009_btn_MODIFYTXN");
		 RETURN= MiscUtility.getWebElement(objFilepath,"ULD009_RETURN");
		 btn_GENLUC= MiscUtility.getWebElement(objFilepath,"ULD009_btn_GENLUC");
		 btn_GENMUC= MiscUtility.getWebElement(objFilepath,"ULD009_btn_GENMUC");
		 btn_GENLUC_OK= MiscUtility.getWebElement(objFilepath,"ULD009_btn_GENLUC_OK");
		 txt_TxnRemarks = MiscUtility.getWebElement(objFilepath,"ULD009_txt_TxnRemarks");
         btn_genericNo = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
	     btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		 info_footer= MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
		 btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		 Generic_info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
	 }
	
	/**
	 * Method to list a ULD and validate the transaction table details
	 * <on 27/12/2017>
	 * @param uldNum
	 * @param txnType
	 * @param toParty
	 * @param frmParty
	 * @return
	 * @author a-7868
	 */
	public ULD009 viewTransactionDetails(String uldNum, String txnType, String toParty, String frmParty) {
		
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
		txnType	= PropertyHandler.getPropValue(dataFilePath,txnType);
		toParty	= PropertyHandler.getPropValue(dataFilePath,toParty);
		frmParty= PropertyHandler.getPropValue(dataFilePath,frmParty);
		
		list(uldNum);
		waitForElement(tbl_uldDtls);
		//using xpaths of table columns (txn type, toParty, fromParty) since unable to handle with generic methods
		//Assumption: single row will be listed always for a sepcific ULDno.
		
		Assert.assertTrue(waitForElement(td_txnType).getText().contains(txnType), "ERROR : Table value (Txn Type) mismatch");
		Assert.assertTrue(waitForElement(td_toParty).getText().contains(toParty), "ERROR : Table value (To Party) mismatch");
		Assert.assertTrue(waitForElement(td_frmParty).getText().contains(frmParty), "ERROR : Table value (From Party) mismatch");
		click(btn_clear);
		return this;
	}
	/**
	 * Method to list a ULD and validate the transaction table details
	 * <on 27/12/2017>
	 * @param uldNum
	 * @param txnType
	 * @param toParty
	 * @param frmParty
	 * @return
	 * @author a-6545
	 */
	public ULD009 Print_UCR(String uldNum){
		
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
	
		
		list(uldNum);
		waitForElement(tbl_uldDtls);
        tblSelectRowByColValue(tbl_uldDtls, 1, 2, uldNum);
      	click(PRINT_UCR);
		return this;
	}
	/**
	 * Method to list a ULD and validate the transaction table details
	 * <on 27/12/2017>
	 * @param uldNum
	 * @param txnType
	 * @param toParty
	 * @param frmParty
	 * @return
	 * @author a-6545
	 */
	public ULD009 Delete(String uldNum){
		
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
	
		
		list(uldNum);
		waitForElement(tbl_uldDtls);
        tblSelectRowByColValue(tbl_uldDtls, 1, 2, uldNum);
      	click(btn_Delete);
        driver.switchTo().defaultContent();
      	 Assert.assertEquals(waitForElement(Generic_info_msg).getText(),"Transaction Cannot be deleted");
      click(btn_genericOk);
         waitForFrameAndSwitch(FRAME);
       return this;
	}
	/**
	 * Method to list a ULD and validate the transaction table details
	 * <on 27/12/2017>
	 * @param uldNum
	 * @param txnType
	 * @param toParty
	 * @param frmParty
	 * @return
	 * @author a-6545
	 */
	public ULD009 Search_ulds_PRINTALL(String uldNum){
		
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
		selectByText(TXNTYPE, "Loan");
		
		click(btn_list);
		waitForElement(tbl_uldDtls);
      String value= getTableCellValue(tbl_uldDtls,2,1);
		Assert.assertTrue(waitForElement(tbl_uldDtls).getText().contains(value));
		  minWait();
		  click(PRINTALL);
		  waitForNewWindow(2);
	  	    switchToSecondWindow();
         driver.close();
         switchToFirstWindow();
         waitForFrameAndSwitch(FRAME);
       return this;
	}
	
	/**
	 * Method to list a ULD and validate the transaction table details
	 * <on 27/12/2017>
	 * @param uldNum
	 * @param txnType
	 * @param toParty
	 * @param frmParty
	 * @return
	 * @author a-6545
	 */
	public ULD009 Return(String uldNum,String origin, boolean value){
		
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
		if(value){
		selectByText(TXNTYPE, "Loan");
		click(btn_list);
		waitForElement(tbl_uldDtls);
		check(check1);
		minWait();
		check(check2);
		click(RETURN);
		driver.switchTo().defaultContent();
		 if (verifyElementPresent(btn_genericNo)) {

	            click(btn_genericNo);
	            waitForFrameAndSwitch(FRAME);
	        }
		 click(RETURN);
		 driver.switchTo().defaultContent();
		 if (verifyElementPresent(btn_genericYes)) {

	            click(btn_genericYes);
	            waitForFrameAndSwitch(FRAME);
	        }
		
		 minWait();
		   Calendar c = Calendar.getInstance();
         Date date=new Date();
         date=c.getTime();
         SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
         
         String currentDate = sdf.format(date);
      
		 Assert.assertTrue(tblGetTextByColValue(tbl_uldDtls,19,2,uldNum).trim().contains(currentDate));
		}
		else
		{
			 enterKeys(txt_uldNum, uldNum);
			 selectByText(TXNTYPE, "Loan");
			 click(btn_list);
			 waitForElement(tbl_uldDtls);
			 tblSelectRowByColValue(tbl_uldDtls, 1, 2, uldNum);
			 click(RETURN);
			 driver.switchTo().defaultContent();
			 if (verifyElementPresent(btn_genericYes)) {

		            click(btn_genericYes);
		            waitForFrameAndSwitch(FRAME);
		        }
	
			 minWait();
		      Calendar c = Calendar.getInstance();
	         Date date=new Date();
	         date=c.getTime();
	         SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	         
	         String currentDate = sdf.format(date);
	         Assert.assertTrue(tblGetTextByColValue(tbl_uldDtls,19,2,uldNum).trim().contains(currentDate));
			 
		}
	
		return this;
	}
	
	/**
	 * Method to list a ULD and validate the transaction table details
	 * <on 27/12/2017>
	 * @param uldNum
	 * @param txnType
	 * @param toParty
	 * @param frmParty
	 * @return
	 * @author a-6545
	 */
	public ULD009 generate_invoice(String uldNum,String uldNum2, boolean temp){
		
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
		uldNum2	= PropertyHandler.getPropValue(dataFilePath,uldNum2);
		 
		selectByText(TXNTYPE, "Loan");	
		click(btn_list);
	 waitForElement(tbl_uldDtls);
	 if (temp){
		 check(check1);
		
		 check(check2);
	 }
	 else{
		 tblSelectRowByColValue(tbl_uldDtls, 1, 2, uldNum);
	 }
	 click(GENINVOICE);
	 waitForNewWindow(2);
	  switchToSecondWindow();
	  
	  click(SHOWTOTAL);
	  minWait();
	//  Assert.assertTrue(waitForElement(txt_TOTDEMAMT).getAttribute("value").equals("0.0"));
	  enterKeys(txt_TOTDEMAMT,"10");
	  click(btn_INVOICE_GENERATE);
	 
	click(waitForElement(btn_genericNo));

	minWait();
	switchToFirstWindow();
	driver.switchTo().defaultContent();
	waitForElement(btn_genericOk);
	
	  String value= waitForElement(Generic_info_msg).getText();
	  System.out.println(value);
      String[] splitStr = value.split("\\s+");
      System.out.println(value);
      String split_e=splitStr[0];
      PropertyHandler.setPropValue(dataFilePath, "invoiceno", split_e);
      click(waitForElement(btn_genericOk));
	
     waitForFrameAndSwitch(FRAME);
    	  minWait();
 return this;
	}
	/**
	 * Method to list a ULD and validate the transaction table details
	 * <on 27/12/2017>
	 * @param uldNum
	 * @param txnType
	 * @param toParty
	 * @param frmParty
	 * @return
	 * @author a-6545
	 */
	public ULD009 Verify_generate_invoice_records(String uldNum){
		
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
	
		list(uldNum);
	 waitForElement(tbl_uldDtls);
	 tblSelectRowByColValue(tbl_uldDtls, 1, 2, uldNum);
	 click(GENINVOICE);
	  driver.switchTo().defaultContent();
	  Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("Invoice already generated"));
	  minWait();
	  click(waitForElement(btn_genericOk));
	  waitForFrameAndSwitch(FRAME);
 return this;
	}
	
	/**
	 * Method to list a ULD and validate the transaction table details
	 * <on 27/12/2017>
	 * @param uldNum
	 * @param txnType
	 * @param toParty
	 * @param frmParty
	 * @return
	 * @author a-6545
	 */
	public ULD009 Modify(String uldNum,String value){
		
	uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
	   list(uldNum);
	   waitForElement(tbl_uldDtls);
	   tblSelectRowByColValue(tbl_uldDtls, 1, 2, uldNum);
	   click(btn_MODIFYTXN);
	   waitForNewWindow(2);
	   switchToSecondWindow();
	   enterKeys(txt_TxnRemarks,value);
       click(btn_MODIFY_OK);
      switchToFirstWindow();
       waitForFrameAndSwitch(FRAME);
       minWait();
   String val= (tblGetTextByColValue(tbl_uldDtls,21,2,uldNum).toString());
	  Assert.assertTrue(tblGetTextByColValue(tbl_uldDtls,21,2,uldNum).trim().equalsIgnoreCase("Remarks"));
	  
      return this;
	}
	/**
	 * Method to list a ULD and validate the transaction table details
	 * <on 27/12/2017>
	 * @param uldNum
	 * @param txnType
	 * @param toParty
	 * @param frmParty
	 * @return
	 * @author a-6545
	 */
	public ULD009 Genarate_LUC(String uldNum){
		
	uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
	   list(uldNum);
	   waitForElement(tbl_uldDtls);
	   tblSelectRowByColValue(tbl_uldDtls, 1, 2, uldNum);
	
	   click(btn_GENMUC);
	  driver.switchTo().defaultContent();
	  waitForElement(btn_genericOk);
		
	  String value= waitForElement(Generic_info_msg).getText();
	  System.out.println(value);
      String[] splitStr = value.split("\\s+");
      System.out.println(value);
      String split_e=splitStr[7];
      PropertyHandler.setPropValue(dataFilePath, "MucRefNo", split_e);
      click(waitForElement(btn_genericOk));
      waitForFrameAndSwitch(FRAME);
      minWait();
      tblSelectRowByColValue(tbl_uldDtls, 1, 2, uldNum);
  	
	   click(btn_GENLUC);
	   waitForNewWindow(2);
	   switchToSecondWindow();
	   click(btn_GENLUC_OK);
	   switchToFirstWindow();
       waitForFrameAndSwitch(FRAME);
      return this;
	}
	/**
	 * Method to list a ULD
	 * @param uldNum
	 */
	public void list(String uldNum){
		enterKeys(txt_uldNum, uldNum);
		click(btn_list);
	}
	
	/**
	  * Method to close current page and return to Homepae
	 * returns the instance of Homepage
	 * @return
	 * @author a-7868
		 */
	public HomePage close() {    	
       
       click(btn_close);
       driver.switchTo().defaultContent();
       if (verifyElementPresent(btn_genericYes)) {

           click(btn_genericYes);
       }
       return new HomePage(driver,dataFileName);
   }
}
