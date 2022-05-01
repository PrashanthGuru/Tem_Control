package com.ibsplc.pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen OPR282 - Capture Irregularity
 * @author a-7868 Krishna <22/01/2018>
 *
 */
public class OPR282 extends BasePage{

	
	 private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	 public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	 public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	 
	 public static String FRAME = "iCargoContentFrameOPR282";
	  
	 By	txt_prefix,
	 	txt_awb,
	 	btn_list,
	 	dropdown_trnsctn,
	 	btn_clear,
	 	btn_close,
	 	txt_irrCode,
	 	txt_carrierCode,
	 	txt_fltNum,
	 	txt_fltDate,
	 	txt_irrPcs,
	 	txt_irrWt,
	 	txt_irrRemarks,
	 	btn_irrSave,
	 	tbl_irrHistory,
	 	btn_addIrr,
	 	yesBtn;
	 
	 WebDriver driver;
	 String screenFrame;
	 String dataFileName;
	   
	 public OPR282(WebDriver driver, String dataFileName) {
		 super(driver);
	     this.driver = driver;
	     initElements();
	     this.dataFilePath = this.dataFilePath + dataFileName;
	     this.dataFileName = dataFileName;
	 }
	 
	 /**
	  * Method to initialize page objects
	  */
	 public void initElements(){
		 
		 txt_prefix 	= MiscUtility.getWebElement(objFilepath,"OPR282_txt_awbPre");
	     txt_awb 		= MiscUtility.getWebElement(objFilepath,"OPR282_txt_awbNo");
	     btn_list 		= MiscUtility.getWebElement(objFilepath,"OPR282_btn_list");
	     btn_clear 		= MiscUtility.getWebElement(objFilepath,"OPR282_btn_clear");	       
	     dropdown_trnsctn = MiscUtility.getWebElement(objFilepath,"OPR282_dropdown_trnsctn");
	     txt_irrCode 	= MiscUtility.getWebElement(objFilepath,"OPR282_txt_irrCode");
	     txt_carrierCode= MiscUtility.getWebElement(objFilepath,"OPR282_txt_carrierCode");
	     txt_fltNum 	= MiscUtility.getWebElement(objFilepath,"OPR282_txt_fltNum");
	     txt_fltDate	= MiscUtility.getWebElement(objFilepath,"OPR282_txt_fltDate");
	     txt_irrPcs 	= MiscUtility.getWebElement(objFilepath,"OPR282_txt_irrPcs");
	     txt_irrWt 		= MiscUtility.getWebElement(objFilepath,"OPR282_txt_irrWt");
	     txt_irrRemarks = MiscUtility.getWebElement(objFilepath,"OPR282_txt_irrRemarks");
	     btn_irrSave 	= MiscUtility.getWebElement(objFilepath,"OPR282_btn_irrSave");
	     tbl_irrHistory = MiscUtility.getWebElement(objFilepath,"OPR282_tbl_irrHistory");	     
	     btn_close		= MiscUtility.getWebElement(objFilepath,"OPR282_btn_close");    
	     btn_addIrr		=MiscUtility.getWebElement(objFilepath,"OPR282_btn_addIrr");
	     yesBtn	= MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
	 }
	 /**
	  * Method to create an irregularity
	  * @param awbPre
	  * @param awbNo
	  * @param transaction
	  * @param irrCode
	  * @param carrierCode
	  * @param fltNum
	  * @param fltDate
	  * @param pcs
	  * @param wt
	  * @param remarks
	  * @return
	  * @author a-7868 Krishna <22/01/2018>
	  */
	 public OPR282 createIrregularity(String awbPre, String awbNo, String transaction, String irrCode,
			 String carrierCode, String fltNum, String fltDate, String pcs, String wt, String remarks){
		 
		awbPre 		= PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo 		= PropertyHandler.getPropValue(dataFilePath, awbNo);
		transaction = PropertyHandler.getPropValue(dataFilePath, transaction);
		irrCode 	= PropertyHandler.getPropValue(dataFilePath, irrCode);
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNum 		= PropertyHandler.getPropValue(dataFilePath, fltNum);
		fltDate 	= PropertyHandler.getPropValue(dataFilePath, fltDate);
		pcs 		= PropertyHandler.getPropValue(dataFilePath, pcs);
		wt 			= PropertyHandler.getPropValue(dataFilePath, wt);
		remarks 	= PropertyHandler.getPropValue(dataFilePath, remarks);
		
		list(awbPre,awbNo);
		click(btn_addIrr);
		
		selectByText(dropdown_trnsctn, transaction);
		enterKeys(txt_irrCode, irrCode);
		enterKeys(txt_carrierCode, carrierCode);
		enterKeys(txt_fltNum, fltNum);
		enterKeys(txt_fltDate, fltDate);
		enterKeys(txt_irrPcs, pcs);
		enterKeys(txt_irrWt, wt);
		enterKeys(txt_irrRemarks, remarks);
		click(btn_irrSave);
		minWait();
		Assert.assertTrue(getTableColumnValues(tbl_irrHistory, 2).contains(irrCode));
		Assert.assertTrue(getTableColumnValues(tbl_irrHistory, 5).contains(transaction));
		Assert.assertTrue(getTableColumnValues(tbl_irrHistory, 8).contains(pcs));
		Assert.assertTrue(getTableColumnValues(tbl_irrHistory, 9).contains(wt));
		
		click(btn_clear);
		return this;
	 }
	 
	 /****
	  * 
	  * @param awbPre
	  * @param awbNo
	  * @param pcs
	  * @param wt
	  * @return
	  */
	 public OPR282 verifyRejectedShpmnt(String awbPre, String awbNo,String pcs, String wt,String username){
		
		 awbPre 		= PropertyHandler.getPropValue(dataFilePath, awbPre);
		 awbNo 		    = PropertyHandler.getPropValue(dataFilePath, awbNo);
		 pcs 		    = PropertyHandler.getPropValue(dataFilePath, pcs);
		 wt 			= PropertyHandler.getPropValue(dataFilePath, wt);
		 username       = PropertyHandler.getPropValue(dataFilePath, username);
		 
		 list(awbPre,awbNo);
		 
		 verifyValuePresentInTblColumn (tbl_irrHistory, 2, "Later acceptance time");
		 verifyValuePresentInTblColumn (tbl_irrHistory, 5, "Transfer Manifest");
		 verifyValuePresentInTblColumn (tbl_irrHistory, 10, username);
		 verifyValuePresentInTblColumn (tbl_irrHistory, 8, pcs);
		 verifyValuePresentInTblColumn (tbl_irrHistory, 9, wt);
		 
		 
		 return this;
		 
	 }
	 /**
	  * method to list the awb
	  * @param awbPre
	  * @param awbNo
	  * @author a-7868 Krishna <22/01/2018>
	  */
	 public void list(String awbPre, String awbNo){
		 
		 enterKeys(txt_prefix, awbPre);
		 enterKeys(txt_awb, awbNo);
		 click(btn_list);
		 minWait();
	 }
	 
	 /**
	 * Method to close current page and return to Homepage
	 * returns the instance of Homepage
	 * @return
	 * @author a-7868 Krishna <22-01-2018>
	 * 
	 */
	public HomePage close() {    	
	
    click(btn_close);
    driver.switchTo().defaultContent();
    if (verifyElementPresent(yesBtn)) 
        click(yesBtn);     
    return new HomePage(driver,dataFileName);
	}
	
	/**
	 * Created by A-7605 on 12-4-18
	 * This method verify already irregularity details captured showing in the irregularity table
	 * @param awbPrefix
	 * @param awbNo
	 * @param irregularity
	 * @param transaction
	 * @param pieces
	 * @param weight
	 * @param remarks
	 * @return
	 */
	public OPR282 verifyIrregularityHistory(String awbPrefix, String awbNo, String irregularity, String transaction, String pieces, String weight, String remarks){
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		irregularity = PropertyHandler.getPropValue(dataFilePath, irregularity);
		transaction = PropertyHandler.getPropValue(dataFilePath, transaction);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		remarks = PropertyHandler.getPropValue(dataFilePath, remarks);

		String fullAWBNo = awbPrefix+"-"+awbNo;
		enterKeys(txt_prefix, awbPrefix);
		enterKeys(txt_awb, awbNo);
		click(btn_list);
		minWait();
		Assert.assertEquals(getTableCellValue(tbl_irrHistory, 2, 1), irregularity);
		Assert.assertEquals(getTableCellValue(tbl_irrHistory, 3, 1).replaceAll(" ", ""), fullAWBNo);
		Assert.assertEquals(getTableCellValue(tbl_irrHistory, 5, 1), transaction);
		Assert.assertEquals(getTableCellValue(tbl_irrHistory, 8, 1), pieces);
		Assert.assertEquals(getTableCellValue(tbl_irrHistory, 9, 1), weight);
		Assert.assertEquals(getTableCellValue(tbl_irrHistory, 12, 1), remarks);
		return this;
	}
}
