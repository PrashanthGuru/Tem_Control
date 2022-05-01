package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


public class OPR008 extends BasePage{

    public static String FRAME = "iCargoContentFrameOPR008";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String screenFrame;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    
    By
    
    txt_carrierCode,
    txt_flightNumberFilter,
    txt_flightDate,
    Btn_btnList,
    tbl_importFlightEnquiryTable,
    tbl_transactionSummaryTable,
    Btn_btnClose;
   


    private By btn_genericYes,
   	info_msg,
   	btn_noBtn,
   	Generic_btn_ok,
   	Generic_info_error;
    
    
    public OPR008(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initPageElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    private void initPageElements(){	
    	
    	txt_carrierCode                     = MiscUtility.getWebElement(objFilepath, "OPR008_txt_carrierCode");
    	txt_flightNumberFilter                    = MiscUtility.getWebElement(objFilepath, "OPR008_txt_flightNumberFilter"); 
    	txt_flightDate                      = MiscUtility.getWebElement(objFilepath, "OPR008_txt_flightDate");
    	Btn_btnList                         = MiscUtility.getWebElement(objFilepath, "OPR008_Btn_btnList");
    	tbl_importFlightEnquiryTable         = MiscUtility.getWebElement(objFilepath, "OPR008_tbl_importFlightEnquiryTable");
    	tbl_transactionSummaryTable       = MiscUtility.getWebElement(objFilepath, "OPR008_tbl_transactionSummaryTable");
    	Btn_btnClose                    = MiscUtility.getWebElement(objFilepath, "OPR263_Btn_btnClose");
    	
        
        
        btn_genericYes     = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_noBtn 		   = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        info_msg		   = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error") ;
}

  
    
    public OPR008 VerifyDetails(String carrier,String fltNum,String fltDt,String ULDNo2,String ULDNo4 ){
    	
   	  carrier= PropertyHandler.getPropValue(dataFilePath,carrier);
	  fltNum = PropertyHandler.getPropValue(dataFilePath,fltNum);
	  fltDt 	= PropertyHandler.getPropValue(dataFilePath,fltDt);
	  ULDNo2=PropertyHandler.getPropValue(dataFilePath,ULDNo2);
	  ULDNo4=PropertyHandler.getPropValue(dataFilePath,ULDNo4);
     	
	  enterKeys(txt_carrierCode, carrier);
	  enterKeys(txt_flightNumberFilter, fltNum);
	  enterKeys(txt_flightDate, fltDt);
	  click(Btn_btnList);
	  minWait();
	
	  
	 
	  
	  Assert.assertTrue(getTableColumnValues(tbl_importFlightEnquiryTable, 2).contains((String) ULDNo2),"ERROR :No data found");
	  
	  Assert.assertTrue(getTableColumnValues(tbl_importFlightEnquiryTable, 2).contains((String) ULDNo4),"ERROR :No data found");
	  Assert.assertTrue(getTableColumnValues(tbl_transactionSummaryTable, 1).contains("Manifest"),"ERROR :No data found");
	  Assert.assertTrue(getTableColumnValues(tbl_transactionSummaryTable, 1).contains("Break Down"),"ERROR :No data found");
	  


	 
	  
  	return this;
    
    
}
    public HomePage close() {

        click(Btn_btnClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}