package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CRA174 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA174";
   
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    By
    yesBtn,
    
    txt_toAirline,
    txt_awbPrefix,
    txt_AWBNo,
    btn_create,
    btn_save,
    btn_weightChargeAcccodelov,
    chkbx_slectAccountNum,
    btn_okAccouncodePopup,
    btn_othersAccountCode,
    btn_iscamtAcccodelov,
    txt_remarks,
    chkbox_reasonCheck,
    btn_dropbtnSelctFlightSeg,
    tbl_selctFlightsegmnt,
    btn_chargeMemoLov,
    btn_creationDate,
    chkbx_selctMemo,
    btn_okChrgMemoPopup,
    btn_list,
    txt_chargeMemoNum,
    btn_ok,
    txt_weightCharg,
    dropdown_chargeMemoType,
    tbl_memoDetails,
    Generic_info_error,
    btn_delete,
    btn_clear,
    btn_print,
    btn_listAccountingEntries,
    listAccountingEntries_btn_close,

    btn_close,
    
    txt_3A,
    txt_invoiceCorrection,
    checkbox_3A,
    txt_3Z,
    txt_others,
    checkbox_3Z,
    txt_2A,
    txt_2B,
    txt_2C,
    txt_2D,
	txt_2Z, 
	txt_6A, 
	txt_6B,
	txt_billingOutsideIATA,
	txt_AdditionalCollectionsOnAnAWB,
	txt_10PERCExchangeRateVariation,
	txt_originalBilledToAWrongCarrier,
	txt_others2,
	txt_debitOnAuthority,
	txt_debitDueToNoResponse,
    checkbox_2A,
    checkbox_2B, 
    checkbox_2C, 
    checkbox_2D, 
    checkbox_2Z, 
    checkbox_6A, 
    checkbox_6B,
    info_msg,
    txt_weightChargeAcccode,
	txt_total_accountCode;
	
	

    
    public CRA174(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

private void initElements() {
    	
    	    yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	
    	    txt_toAirline              = MiscUtility.getWebElement(objFilepath, "CRA174_txt_toAirline");
    	    txt_awbPrefix              = MiscUtility.getWebElement(objFilepath, "CRA174_txt_awbPrefix");
    	    txt_AWBNo                  = MiscUtility.getWebElement(objFilepath, "CRA174_txt_AWBNo");
    	    btn_create                 = MiscUtility.getWebElement(objFilepath, "CRA174_btn_create");
    	    btn_save                   = MiscUtility.getWebElement(objFilepath, "CRA174_btn_save");
    	    btn_weightChargeAcccodelov = MiscUtility.getWebElement(objFilepath, "CRA174_btn_weightChargeAcccodelov");
    	    chkbx_slectAccountNum      = MiscUtility.getWebElement(objFilepath, "CRA174_chkbx_slectAccountNum");
    	    btn_okAccouncodePopup      = MiscUtility.getWebElement(objFilepath, "CRA174_btn_okAccouncodePopup");
    	    btn_othersAccountCode      = MiscUtility.getWebElement(objFilepath, "CRA174_btn_othersAccountCode");
    	    btn_iscamtAcccodelov       = MiscUtility.getWebElement(objFilepath, "CRA174_btn_iscamtAcccodelov");
    	    txt_remarks                = MiscUtility.getWebElement(objFilepath, "CRA174_txt_remarks");
    	    chkbox_reasonCheck         = MiscUtility.getWebElement(objFilepath, "CRA174_chkbox_reasonCheck");
    	    btn_dropbtnSelctFlightSeg  = MiscUtility.getWebElement(objFilepath, "CRA174_btn_dropbtnSelctFlightSeg");
    	    tbl_selctFlightsegmnt      = MiscUtility.getWebElement(objFilepath, "CRA174_tbl_selctFlightsegmnt");
    	    btn_chargeMemoLov          = MiscUtility.getWebElement(objFilepath, "CRA174_btn_chargeMemoLov");
    	    btn_creationDate           = MiscUtility.getWebElement(objFilepath, "CRA174_btn_creationDate");
    	    chkbx_selctMemo            = MiscUtility.getWebElement(objFilepath, "CRA174_chkbx_selctMemo");
    	    btn_okChrgMemoPopup        = MiscUtility.getWebElement(objFilepath, "CRA174_btn_okChrgMemoPopup");
    	    btn_list                   = MiscUtility.getWebElement(objFilepath, "CRA174_btn_list");
    	    txt_chargeMemoNum          = MiscUtility.getWebElement(objFilepath, "CRA174_txt_chargeMemoNum");
    	    btn_close                  = MiscUtility.getWebElement(objFilepath, "CRA174_btn_close");
    	    txt_weightCharg            = MiscUtility.getWebElement(objFilepath, "CRA174_txt_weightCharg");
    	    btn_ok                     = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    	    dropdown_chargeMemoType    = MiscUtility.getWebElement(objFilepath, "CRA174_dropdown_chargeMemoType");
    	    tbl_memoDetails            = MiscUtility.getWebElement(objFilepath, "CRA174_tbl_memoDetails");
    	    Generic_info_error         = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    	    btn_delete                 = MiscUtility.getWebElement(objFilepath, "CRA174_btn_delete");
    	    btn_clear                  = MiscUtility.getWebElement(objFilepath, "CRA174_btn_clear");
    	    btn_print                  = MiscUtility.getWebElement(objFilepath, "CRA174_btn_print");
    	    btn_listAccountingEntries  = MiscUtility.getWebElement(objFilepath, "CRA174_btn_listAccountingEntries");
    	    listAccountingEntries_btn_close =MiscUtility.getWebElement(objFilepath, "CRA174_listAccountingEntries_btn_close");
    	    txt_3A =MiscUtility.getWebElement(objFilepath, "CRA174_txt_3A");
    	    txt_invoiceCorrection =MiscUtility.getWebElement(objFilepath, "CRA174_txt_invoiceCorrection");
    	    checkbox_3A =MiscUtility.getWebElement(objFilepath, "CRA174_checkbox_3A");
    	    txt_3Z =MiscUtility.getWebElement(objFilepath, "CRA174_txt_3Z");
    	    txt_others =MiscUtility.getWebElement(objFilepath, "CRA174_txt_others");
    	    checkbox_3Z =MiscUtility.getWebElement(objFilepath, "CRA174_checkbox_3Z");
    	    txt_2A =MiscUtility.getWebElement(objFilepath, "CRA174_txt_2A");
    	    txt_2B =MiscUtility.getWebElement(objFilepath, "CRA174_txt_2B");
    	    txt_2C =MiscUtility.getWebElement(objFilepath, "CRA174_txt_2C");
    	    txt_2D =MiscUtility.getWebElement(objFilepath, "CRA174_txt_2D");
    	    txt_2Z =MiscUtility.getWebElement(objFilepath, "CRA174_txt_2Z");
    	    txt_6A =MiscUtility.getWebElement(objFilepath, "CRA174_txt_6A");
    	    txt_6B =MiscUtility.getWebElement(objFilepath, "CRA174_txt_6B");
    	    txt_billingOutsideIATA =MiscUtility.getWebElement(objFilepath, "CRA174_txt_billingOutsideIATA");
    	    txt_AdditionalCollectionsOnAnAWB =MiscUtility.getWebElement(objFilepath, "CRA174_txt_AdditionalCollectionsOnAnAWB");
    	    txt_10PERCExchangeRateVariation =MiscUtility.getWebElement(objFilepath, "CRA174_txt_10PERCExchangeRateVariation");
    	    txt_originalBilledToAWrongCarrier =MiscUtility.getWebElement(objFilepath, "CRA174_txt_originalBilledToAWrongCarrier");
    	    txt_others2 =MiscUtility.getWebElement(objFilepath, "CRA174_txt_others2");
    	    txt_debitOnAuthority =MiscUtility.getWebElement(objFilepath, "CRA174_txt_debitOnAuthority");
    	    txt_debitDueToNoResponse =MiscUtility.getWebElement(objFilepath, "CRA174_txt_debitDueToNoResponse");
    	    checkbox_2A =MiscUtility.getWebElement(objFilepath, "CRA174_checkbox_2A");
    	    checkbox_2B =MiscUtility.getWebElement(objFilepath, "CRA174_checkbox_2B");
    	    checkbox_2C =MiscUtility.getWebElement(objFilepath, "CRA174_checkbox_2C");
    	    checkbox_2D =MiscUtility.getWebElement(objFilepath, "CRA174_checkbox_2D");
    	    checkbox_2Z =MiscUtility.getWebElement(objFilepath, "CRA174_checkbox_2Z");
    	    checkbox_6A =MiscUtility.getWebElement(objFilepath, "CRA174_checkbox_6A");
    	    checkbox_6B =MiscUtility.getWebElement(objFilepath, "CRA174_checkbox_6B");
    	    info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    	    txt_weightChargeAcccode = MiscUtility.getWebElement(objFilepath, "CRA174_txt_weightChargeAcccode");
    	    txt_total_accountCode=MiscUtility.getWebElement(objFilepath, "CRA174_txt_total_accountCode");
    	    
    	 
}


   public CRA174 accountingNavigation(String memoNumbr){
	   
	   memoNumbr=PropertyHandler.getPropValue(dataFilePath, memoNumbr);
	   
	   click(btn_clear);
		  minWait();
		  click(btn_chargeMemoLov);
		  
		  
	    driver.switchTo().defaultContent();
	      waitForNewWindow(2);
	      switchToSecondWindow();
	   tblSelectRowByColValue(tbl_memoDetails, 1, 2, memoNumbr);
	   click(btn_okChrgMemoPopup);
	   
	   switchToFirstWindow();
	   waitForFrameAndSwitch(FRAME);
	   click(btn_list);
	   minWait();
	   
	   click(btn_listAccountingEntries);
	   minWait();
	   click(listAccountingEntries_btn_close);
	   
	   minWait();
	return this;
	   
   }
/***
 * 
 * @param memoNumbr
 * @return
 */
   public CRA174 printMemo(String memoNumbr){
	   
	   memoNumbr=PropertyHandler.getPropValue(dataFilePath, memoNumbr);
	   
	   click(btn_clear);
		  minWait();
		  click(btn_chargeMemoLov);
		  
		  
	    driver.switchTo().defaultContent();
	      waitForNewWindow(2);
	      switchToSecondWindow();
	   tblSelectRowByColValue(tbl_memoDetails, 1, 2, memoNumbr);
	   click(btn_okChrgMemoPopup);
	   
	   switchToFirstWindow();
	   waitForFrameAndSwitch(FRAME);
	   click(btn_list);
	   minWait();

	   click(btn_print);
	   minWait();
	   
	   driver.switchTo().defaultContent();
	      waitForNewWindow(2);
	      switchToSecondWindow();
	   
	   closeAndmoveToFirstWindow();
	
	   
	   
	   return this;   
   }
    
/****
 * 
 * @param carrierCode
 * @param awbPrefix
 * @param awbNum
 * @param memoNum
 * @param chargeMemoType
 * @return
 */


  public CRA174 createBillingMemo(String carrierCode,String awbPrefix,String awbNum,String memoNum,String chargeMemoType){
	  
	  carrierCode=PropertyHandler.getPropValue(dataFilePath, carrierCode);
	  awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
	  awbNum=PropertyHandler.getPropValue(dataFilePath, awbNum);
	  chargeMemoType=PropertyHandler.getPropValue(dataFilePath, chargeMemoType);
	  
	  click(btn_clear);
	  minWait();
	  selectByText(dropdown_chargeMemoType, chargeMemoType);
	  minWait();
	  enterKeys(txt_toAirline, carrierCode);
	  enterKeys(txt_awbPrefix, awbPrefix);
	  enterKeys(txt_AWBNo, awbNum);
	  
	  
	  click(btn_create);
	  
	  driver.switchTo().defaultContent();
      if (verifyElementPresent(yesBtn)) {

          click(yesBtn);
      }
      waitForFrameAndSwitch(FRAME);
      
      String tmpWtcharg=waitForElement(txt_weightCharg).getAttribute("value").replace(",","");
      System.out.println(tmpWtcharg);
      int wtChrgCurnt=Integer.parseInt(tmpWtcharg);
      wtChrgCurnt=wtChrgCurnt+500;
      String wtChrgNxt = new Integer(wtChrgCurnt).toString();
      enterKeys(txt_weightCharg, wtChrgNxt);
      click(btn_weightChargeAcccodelov);
      
      driver.switchTo().defaultContent();
      
      switchToSecondWindow();
      
	  check(chkbx_slectAccountNum);
	  click(btn_okAccouncodePopup);
	  switchToFirstWindow();
	  waitForFrameAndSwitch(FRAME);
	
	  click(btn_othersAccountCode);
	  
      driver.switchTo().defaultContent();
      
      switchToSecondWindow();
      check(chkbx_slectAccountNum);
	  click(btn_okAccouncodePopup);
	  switchToFirstWindow();
	  waitForFrameAndSwitch(FRAME);
	
	  click(btn_iscamtAcccodelov);
	  
      driver.switchTo().defaultContent();
      
      switchToSecondWindow();
      
	  check(chkbx_slectAccountNum);
	  click(btn_okAccouncodePopup);
	  switchToFirstWindow();
	  waitForFrameAndSwitch(FRAME);
	
	   check(chkbox_reasonCheck);
	   enterKeys(txt_remarks, "Remarks") ;
	   click(btn_save);
	  
	   driver.switchTo().defaultContent();
	      
	   click(btn_ok);
	  minWait();
	  
	  click(btn_chargeMemoLov);
    driver.switchTo().defaultContent();
      
      switchToSecondWindow();
      
      
      check(chkbx_selctMemo);
      click(btn_okChrgMemoPopup);
      switchToFirstWindow();
	  waitForFrameAndSwitch(FRAME);
	  
	  String tmpMemo=waitForElement(txt_chargeMemoNum).getAttribute("value");
	  PropertyHandler.setPropValue(dataFilePath, memoNum, tmpMemo);
	  
	  
	  return this;  
	  
  }
  /**
   * 
   * @param chargeMemo
   * @return
   */
  public CRA174 deleteAWB(String chargeMemo,boolean IsError){
	  
	  chargeMemo=PropertyHandler.getPropValue(dataFilePath, chargeMemo);
	  click(btn_clear);
	  minWait();
	  click(btn_chargeMemoLov);
	  
	  
    driver.switchTo().defaultContent();
      waitForNewWindow(2);
      switchToSecondWindow();
   tblSelectRowByColValue(tbl_memoDetails, 1, 2, chargeMemo);
   click(btn_okChrgMemoPopup);
   
   switchToFirstWindow();
   waitForFrameAndSwitch(FRAME);
   click(btn_list);
   minWait();

   
   click(btn_delete);
   
   driver.switchTo().defaultContent();
   minWait();
   click(yesBtn);
   waitForFrameAndSwitch(FRAME);
   if(IsError==true){
	   
	  String errorinfo= waitForElement(Generic_info_error).getText();
	   System.out.println(errorinfo);
	   Assert.assertTrue(errorinfo.contains("Charge Memo with status Billed cannot be deleted"));
	   
   }
   else{
	   

	   driver.switchTo().defaultContent();
	   minWait();
	   click(btn_ok);
	   waitForFrameAndSwitch(FRAME); 
   }
   
   return this;  
  }
  
  
/***
 * 
 * @param chargeMemo
 * @return
 */
  public CRA174 modifyBilledMemo_errorcheck(String chargeMemo){
	  
	  chargeMemo=PropertyHandler.getPropValue(dataFilePath, chargeMemo);
	  
	  click(btn_chargeMemoLov);
	  
	  
    driver.switchTo().defaultContent();
      waitForNewWindow(2);
      switchToSecondWindow();
   tblSelectRowByColValue(tbl_memoDetails, 1, 2, chargeMemo);
   click(btn_okChrgMemoPopup);
   
   switchToFirstWindow();
   waitForFrameAndSwitch(FRAME);
   click(btn_list);
   minWait();

   enterKeys(txt_weightCharg, "10000");
   
   click(btn_save);
   System.out.println(waitForElement(Generic_info_error).getText());
   Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("Charge Memo with status Billed cannot be modified"));
   
   
   return this;  
  }
  /***
   * 
   * @param chargeMemo
   * @return
   */
   public CRA174 modifyChargeMemo(String chargeMemo){
	   
	   chargeMemo=PropertyHandler.getPropValue(dataFilePath, chargeMemo);
	   
	   click(btn_chargeMemoLov);
		  
		  
	    driver.switchTo().defaultContent();
	      waitForNewWindow(2);
	      switchToSecondWindow();
	   tblSelectRowByColValue(tbl_memoDetails, 1, 2, chargeMemo);
	   click(btn_okChrgMemoPopup);
	   
	   switchToFirstWindow();
	   waitForFrameAndSwitch(FRAME);
	   click(btn_list);
	   minWait();

	   enterKeys(txt_weightCharg, "10000");
	   
	   
	
	   check(chkbox_reasonCheck);
	   enterKeys(txt_remarks, "Remarks") ;
	   click(btn_save);
	  
	   driver.switchTo().defaultContent();
	      
	   click(btn_ok);
	  minWait();
	  
	  click(btn_chargeMemoLov);
	driver.switchTo().defaultContent();
	  
	  switchToSecondWindow();
	  
	  
	  check(chkbx_selctMemo);
	  click(btn_okChrgMemoPopup);
	  switchToFirstWindow();
	  waitForFrameAndSwitch(FRAME);
	 
	  Assert.assertTrue(waitForElement(txt_weightCharg).getAttribute("value").equals("10000"));
		  
	   
	   
	   return this;   
   }

  public HomePage close() {

      click(btn_close);
      driver.switchTo().defaultContent();
      if (verifyElementPresent(yesBtn)) {

          click(yesBtn);
      }
      return new HomePage(driver, dataFileName);
  }
  
  
  

/**
 * created by A-8254
 * @param chargeMemoType
 * @return
 */

  public CRA174 verifyReasonsUnderCredit(String chargeMemoType){
  
	  
		  
		  chargeMemoType=PropertyHandler.getPropValue(dataFilePath, chargeMemoType);
		  minWait();
		  selectByText(dropdown_chargeMemoType, chargeMemoType);
		  minWait();
		  verifyElementPresent(txt_3A);
		  Assert.assertEquals(waitForElement(txt_invoiceCorrection).getText(),"INVOICE CORRECTION");
		  check(checkbox_3A);
		  unCheck(checkbox_3A);
		  verifyElementPresent(txt_3Z);
		  Assert.assertEquals(waitForElement(txt_others).getText(),"OTHERS");
		  check(checkbox_3Z);
		  unCheck(checkbox_3Z);
		  
		  
		  
		  return this;
	   
  }
  
  
  /**
   * created byA-8254
   * @param chargeMemoType
   * @return
   */
  
  
  public CRA174 verifyReasonsUnderBilling(String chargeMemoType){
	  
	  
	  
	  chargeMemoType=PropertyHandler.getPropValue(dataFilePath, chargeMemoType);
	  minWait();
	  selectByText(dropdown_chargeMemoType, chargeMemoType);
	  minWait();
	  verifyElementPresent(txt_2A);
	  verifyElementPresent(txt_2B);
	  verifyElementPresent(txt_2C);
	  verifyElementPresent(txt_2D);
	  verifyElementPresent(txt_2Z);
	  verifyElementPresent(txt_6A);
	  verifyElementPresent(txt_6B);
	  Assert.assertEquals(waitForElement(txt_billingOutsideIATA).getText(),"BILLING OUTSIDE IATA/ACH TIME LIMIT");
	  Assert.assertEquals(waitForElement(txt_AdditionalCollectionsOnAnAWB).getText(),"ADDITIONAL COLLECTIONS ON AN AWB");
	  Assert.assertEquals(waitForElement(txt_10PERCExchangeRateVariation).getText(),"10% EXCHANGE RATE VARIATION");
	  Assert.assertEquals(waitForElement(txt_originalBilledToAWrongCarrier).getText(),"ORIGINALLY BILLED TO A WRONG CARRIER");
	  Assert.assertEquals(waitForElement(txt_others2).getText(),"OTHERS");
	  Assert.assertEquals(waitForElement(txt_debitOnAuthority).getText(),"DEBIT ON AUTHORITY");
	  Assert.assertEquals(waitForElement(txt_debitDueToNoResponse).getText(),"DEBIT DUE TO NO RESPONSE");
	  check(checkbox_2A);
	  unCheck(checkbox_2A);
	  check(checkbox_2B);
	  unCheck(checkbox_2B);
	  check(checkbox_2C);
	  unCheck(checkbox_2C);
	  check(checkbox_2D);
	  unCheck(checkbox_2D);
	  check(checkbox_2Z);
	  unCheck(checkbox_2Z);
	  check(checkbox_6A);
	  unCheck(checkbox_6A);
	  check(checkbox_6B);
	  unCheck(checkbox_6B);
	  
	
	  
	  
	  
	  return this;
   
} 
  
	
	
  public CRA174 verifyChargesAccountCodeCannotBeEmptyMSG(String ToAirline,String weightCharge){
	  
	  ToAirline=PropertyHandler.getPropValue(dataFilePath, ToAirline);
	  weightCharge=PropertyHandler.getPropValue(dataFilePath,weightCharge);
	  enterKeys(txt_toAirline,ToAirline +Keys.TAB);
	  click(btn_create);
	  minWait();
	  driver.switchTo().defaultContent();
	  minWait();
	  click(yesBtn);
	  waitForFrameAndSwitch(FRAME);
	  enterKeys(txt_weightCharg,weightCharge);
	  click(btn_save);
	  minWait();
	  driver.switchTo().defaultContent();
	  waitForElement(info_msg).getText().contains("Weight Charges Account Code cannot be empty");
	  click(btn_ok);
	  minWait();
	  waitForFrameAndSwitch(FRAME);
	  
	  return this;
   
}
  
  
  
  
public CRA174 verifyTotalAmountAccountCodeCannotBeEmptyMSG(String ToAirline,String weightCharge,String accountCode){
	
	accountCode=PropertyHandler.getPropValue(dataFilePath, accountCode);
	  ToAirline=PropertyHandler.getPropValue(dataFilePath, ToAirline);
	  weightCharge=PropertyHandler.getPropValue(dataFilePath,weightCharge);
	  enterKeys(txt_toAirline,ToAirline +Keys.TAB);
	  click(btn_create);
	  minWait();
	  driver.switchTo().defaultContent();
	  minWait();
	  click(yesBtn);
	  waitForFrameAndSwitch(FRAME);
	  
	  enterKeys(txt_weightCharg,weightCharge);
	  enterKeys(txt_weightChargeAcccode,accountCode);
	  enterKeys(txt_total_accountCode,"");
	  
	  click(btn_save);
	  minWait();
	  driver.switchTo().defaultContent();
	  waitForElement(info_msg).getText().contains("Total Amount Account Code cannot be empty");
	  click(btn_ok);
	  minWait();
	  waitForFrameAndSwitch(FRAME);
	  
	  return this;
   
} 
  


public CRA174 verifyMemoCantIssueForOwnAirlineMSG(String ToAirline){
	

	  ToAirline=PropertyHandler.getPropValue(dataFilePath, ToAirline);
	
	  enterKeys(txt_toAirline,ToAirline +Keys.TAB);
	  click(btn_create);
	  minWait();
	  Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("Charge Memo cannot be issued against Own Airline"));
	  return this;
   
} 



public CRA174 verifyAWBNotFinalizedeMSG(String ToAirline,String awbPre,String awb){
	

	  ToAirline=PropertyHandler.getPropValue(dataFilePath, ToAirline);
	  awbPre=PropertyHandler.getPropValue(dataFilePath, awbPre);
	  awb=PropertyHandler.getPropValue(dataFilePath, awb);
	  
	  enterKeys(txt_toAirline,ToAirline +Keys.TAB);
	  enterKeys(txt_awbPrefix,awbPre);
	  enterKeys(txt_AWBNo,awb);
	  
	  click(btn_create);
	  minWait();
	  Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("AWB is not finalized"));
	  return this;
 
} 















}
