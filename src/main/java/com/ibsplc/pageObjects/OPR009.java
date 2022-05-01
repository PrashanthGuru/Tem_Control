package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


public class OPR009 extends BasePage{

    public static String FRAME = "iCargoContentFrameOPR001";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String screenFrame;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    
    By
    
    txt_carrierCode,
    txt_flightNumber,
    txt_flightDate,
    btn_Listbtn,
    btn_Closebtn	,
    ChkBox_documentationStartedon,
    ChkBox_flaggedon	,
    ChkBox_breakdownStartedon,
    ChkBox_finalisedon,
    tbl_importflightlisting;


    private By btn_genericYes,
   	info_msg,
   	btn_noBtn,
   	Generic_btn_ok,
   	Generic_info_error;
    
    
    public OPR009(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initPageElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    private void initPageElements(){	
    	
	txt_carrierCode                         = MiscUtility.getWebElement(objFilepath, "OPR009_txt_carrierCode");
    	txt_flightNumber                    = MiscUtility.getWebElement(objFilepath, "OPR009_txt_flightNumber"); 
    	txt_flightDate                      = MiscUtility.getWebElement(objFilepath, "OPR009_txt_flightDate");
    	btn_Listbtn                         = MiscUtility.getWebElement(objFilepath, "OPR009_btn_Listbtn");
    	btn_Closebtn                        = MiscUtility.getWebElement(objFilepath, "OPR009_btn_Closebtn");
    	ChkBox_documentationStartedon       = MiscUtility.getWebElement(objFilepath, "OPR009_ChkBox_documentationStartedon");
    	ChkBox_flaggedon                        = MiscUtility.getWebElement(objFilepath, "OPR009_ChkBox_flaggedon");
    	ChkBox_breakdownStartedon			        = MiscUtility.getWebElement(objFilepath,  "OPR009_ChkBox_breakdownStartedon");
    	ChkBox_finalisedon                   = MiscUtility.getWebElement(objFilepath, "OPR009_ChkBox_finalisedon");
    	tbl_importflightlisting                  = MiscUtility.getWebElement(objFilepath, "OPR009_tbl_importflightlisting");
        
        
        btn_genericYes     = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_noBtn 		   = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        info_msg		   = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error") ;
}

    public OPR009 checkFalgged(String carrier,String fltNum,String fltDt){
    	
    	carrier= PropertyHandler.getPropValue(dataFilePath,carrier);
  	    fltNum = PropertyHandler.getPropValue(dataFilePath,fltNum);
  	    fltDt 	= PropertyHandler.getPropValue(dataFilePath,fltDt);
       	
  	  enterKeys(txt_carrierCode, carrier);
  	  enterKeys(txt_flightNumber, fltNum);
  	  enterKeys(txt_flightDate, fltDt);
  	  click(btn_Listbtn);
  	  minWait();
  	  driver.switchTo().defaultContent();
    	
    	if(waitForElement(ChkBox_flaggedon).isSelected())
    		System.out.println("Flight is flagged");
    	
		return this;
    	
    }
    
    public OPR009 VerifyDetails(String carrier,String fltNum,String fltDt,String Route,String Mft_ULD,String ULDsArrvd ){
    	
   	  carrier= PropertyHandler.getPropValue(dataFilePath,carrier);
	  fltNum = PropertyHandler.getPropValue(dataFilePath,fltNum);
	  fltDt = PropertyHandler.getPropValue(dataFilePath,fltDt);
	  Route=PropertyHandler.getPropValue(dataFilePath,Route);
	  Mft_ULD=PropertyHandler.getPropValue(dataFilePath,Mft_ULD);
	  ULDsArrvd=PropertyHandler.getPropValue(dataFilePath,ULDsArrvd);
	  enterKeys(txt_carrierCode, carrier);
	  enterKeys(txt_flightNumber, fltNum);
	  enterKeys(txt_flightDate, fltDt);
	  click(btn_Listbtn);
	  minWait();
	//  driver.switchTo().defaultContent();
	  
  String Route1 = getTableCellValue(tbl_importflightlisting, 4, 1);
  System.out.println(Route1);
  Assert.assertTrue(Route1.contains(Route),"ERROR :No data found");
  
  String FlightStatus1 = getTableCellValue(tbl_importflightlisting, 6, 1);
  System.out.println(FlightStatus1);
 Assert.assertTrue(FlightStatus1.contains("Active"),"ERROR :No data found");

String Mft_ULD1 = getTableCellValue(tbl_importflightlisting, 11, 1);
System.out.println(Mft_ULD1);
Assert.assertTrue(Mft_ULD1.contains(Mft_ULD),"ERROR :No data found");

String ULDsArrvd1 = getTableCellValue(tbl_importflightlisting, 12, 1);
System.out.println(ULDsArrvd1);
Assert.assertTrue(ULDsArrvd1.contains(ULDsArrvd),"ERROR :No data found");


Assert.assertEquals(waitForElementVisible(ChkBox_documentationStartedon).getAttribute("checked"),"true");
Assert.assertEquals(waitForElementVisible(ChkBox_flaggedon).isEnabled(), false,"Fail");

Assert.assertEquals(waitForElementVisible(ChkBox_breakdownStartedon).getAttribute("checked"), "true");
Assert.assertEquals(waitForElementVisible(ChkBox_finalisedon).isEnabled(), false,"Fail");

	
	



  	return this;
    
    
}
    public HomePage close() {

        click(btn_Closebtn);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}