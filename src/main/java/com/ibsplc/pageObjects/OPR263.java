package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


public class OPR263 extends BasePage{

    public static String FRAME = "iCargoContentFrameOPR001";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String screenFrame;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    
    By
    
    txt_carrierCodeFilter,
    txt_flightNumberFilter,
    txt_flightDateFilter,
    Btn_btnList,
    Btn_btnClose,
    tbl_exportflightlisting;


    private By btn_genericYes,
   	info_msg,
   	btn_noBtn,
   	Generic_btn_ok,
   	Generic_info_error;
    
    
    public OPR263(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initPageElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    private void initPageElements(){	
    	
    	txt_carrierCodeFilter                         = MiscUtility.getWebElement(objFilepath, "OPR263_txt_carrierCodeFilter");
    	txt_flightNumberFilter                    = MiscUtility.getWebElement(objFilepath, "OPR263_txt_flightNumberFilter"); 
    	txt_flightDateFilter                      = MiscUtility.getWebElement(objFilepath, "OPR263_txt_flightDateFilter");
    	Btn_btnList                         = MiscUtility.getWebElement(objFilepath, "OPR263_Btn_btnList");
    
    	tbl_exportflightlisting       = MiscUtility.getWebElement(objFilepath, "OPR263_tbl_exportflightlisting");
    	Btn_btnClose                        = MiscUtility.getWebElement(objFilepath, "OPR263_Btn_btnClose");
    	
        
        
        btn_genericYes     = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_noBtn 		   = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        info_msg		   = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error") ;
}

    public OPR263 checkFalgged(){
    	
    	
    	
    	
    	
		return this;
    	
    }
    
    public OPR263 VerifyDetails(String carrier,String fltNum,String fltDt,String Route,String FlightStatus,String Thru_Unit,String BDN_Unit){
    	
   	  carrier= PropertyHandler.getPropValue(dataFilePath,carrier);
	  fltNum = PropertyHandler.getPropValue(dataFilePath,fltNum);
	  fltDt 	= PropertyHandler.getPropValue(dataFilePath,fltDt);
	  BDN_Unit=	PropertyHandler.getPropValue(dataFilePath,BDN_Unit);
	  Thru_Unit=	PropertyHandler.getPropValue(dataFilePath,Thru_Unit);
	  Route=PropertyHandler.getPropValue(dataFilePath,Route);
	  enterKeys(txt_carrierCodeFilter, carrier);
	  enterKeys(txt_flightNumberFilter, fltNum);
	  enterKeys(txt_flightDateFilter, fltDt);
	  click(Btn_btnList);
	  minWait();
	//  driver.switchTo().defaultContent();
	  String Route1=getTableCellValue(tbl_exportflightlisting, 5, 1);
	  System.out.println(Route1);
	  String thruunits=getTableCellValue(tbl_exportflightlisting, 13, 1);
	  System.out.println(thruunits);
	  String bdnunits=getTableCellValue(tbl_exportflightlisting, 14, 1);
	  System.out.println(bdnunits);
	  Assert.assertTrue(thruunits.contains(Thru_Unit),"ERROR :No data found");
	  Assert.assertTrue(bdnunits.contains(BDN_Unit),"ERROR :No data found");
	  Assert.assertTrue(Route1.contains(Route),"ERROR :No data found");
	
    	
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