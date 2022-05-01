package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


public class OPR047 extends BasePage{

    public static String FRAME = "iCargoContentFrameOPR047";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String screenFrame;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    
    By
    text_carrierCode,
    text_flightNumber,
    text_flightDate,
    btn_btList,
    tbl_flightdisctable,
    tbl_flightDamageTable,
    btn_btClose;
   


    private By btn_genericYes,
   	info_msg,
   	btn_noBtn,
   	Generic_btn_ok,
   	Generic_info_error;
    
    
    public OPR047(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initPageElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    private void initPageElements(){	
    	
    	text_carrierCode = MiscUtility.getWebElement(objFilepath, "OPR047_text_carrierCode");
    	text_flightNumber= MiscUtility.getWebElement(objFilepath, "OPR047_text_flightNumber"); 
    	text_flightDate = MiscUtility.getWebElement(objFilepath, "OPR047_text_flightDate");
    	btn_btList= MiscUtility.getWebElement(objFilepath, "OPR047_btn_btList");
    	tbl_flightdisctable= MiscUtility.getWebElement(objFilepath, "OPR047_tbl_flightdisctable");
    	tbl_flightDamageTable= MiscUtility.getWebElement(objFilepath, "OPR047_tbl_flightDamageTable");
    	btn_btClose= MiscUtility.getWebElement(objFilepath, "OPR047_btn_btClose");

        btn_genericYes     = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_noBtn 		   = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        info_msg		   = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error") ;
}

  
    
    public OPR047 VerifyDetails(String carrier,String fltNum,String fltDt,String AWBNo,String AWBNo2 ){
    	
   	  carrier= PropertyHandler.getPropValue(dataFilePath,carrier);
	  fltNum = PropertyHandler.getPropValue(dataFilePath,fltNum);
	  fltDt 	= PropertyHandler.getPropValue(dataFilePath,fltDt);
	  AWBNo=PropertyHandler.getPropValue(dataFilePath,AWBNo);
	  AWBNo2=PropertyHandler.getPropValue(dataFilePath,AWBNo2);
     	
	  enterKeys(text_carrierCode, carrier);
	  enterKeys(text_flightNumber, fltNum);
	  enterKeys(text_flightDate, fltDt);
	  click(btn_btList);
	  minWait();
	
	  Assert.assertTrue(verifyValuePresentInTblColumn (tbl_flightdisctable, 2, AWBNo),"ERROR :No data found");
	
	  Assert.assertTrue(verifyValuePresentInTblColumn (tbl_flightdisctable, 2, AWBNo2),"ERROR :No data found");

	 
	  
  	return this;
    
    
}

    /**
     * lists a flight and verifies the details of awb having discrepancy
     * @param carrier
     * @param fltNum
     * @param fltDt
     * @param awbNo
     * @param descPcs
     * @param descWt
     * @param descCode: not read from data sheet
     * @return
     * @author a-7681
     */

    public OPR047 verifyAWBDetails(String carrier,String fltNum,String fltDt,String awbNo,String descPcs, String descWt, String descCode ){

        carrier= PropertyHandler.getPropValue(dataFilePath,carrier);
        fltNum = PropertyHandler.getPropValue(dataFilePath,fltNum);
        fltDt 	= PropertyHandler.getPropValue(dataFilePath,fltDt);
        awbNo=PropertyHandler.getPropValue(dataFilePath,awbNo);
        descPcs=PropertyHandler.getPropValue(dataFilePath,descPcs);
        descWt=PropertyHandler.getPropValue(dataFilePath,descWt);

        list(carrier,fltNum,fltDt);

        Assert.assertTrue(verifyValuePresentInTblColumn (tbl_flightdisctable, 2, awbNo),"The AWB No: " + awbNo + " is not listed in the table");
        Assert.assertEquals(tblGetTextByColValue(tbl_flightdisctable,7,2,awbNo),descPcs,"The discrepancy pieces doesn't match.");
        Assert.assertEquals(tblGetTextByColValue(tbl_flightdisctable,8,2,awbNo),descWt,"The discrepancy weight doesn't match.");
        Assert.assertEquals(tblGetTextByColValue(tbl_flightdisctable,6,2,awbNo),descCode,"The discrepancy code doesn't match.");

        return this;


    }

    /**
     * Verifies AWB not present in discrepancy table
     * @param carrier
     * @param fltNum
     * @param fltDt
     * @param awbNo
     * @return
     * @author a-7681
     */
    public OPR047 verifyAWBnotPresent(String carrier,String fltNum,String fltDt,String awbNo){

        carrier= PropertyHandler.getPropValue(dataFilePath,carrier);
        fltNum = PropertyHandler.getPropValue(dataFilePath,fltNum);
        fltDt 	= PropertyHandler.getPropValue(dataFilePath,fltDt);
        awbNo=PropertyHandler.getPropValue(dataFilePath,awbNo);

        list(carrier,fltNum,fltDt);

        Assert.assertFalse(verifyValuePresentInTblColumn (tbl_flightdisctable, 2, awbNo),"The AWB No: " + awbNo + " is not listed in the table");

        return this;


    }

    private void list(String carrier, String fltNum, String fltDt) {

        enterKeys(text_carrierCode, carrier);
        enterKeys(text_flightNumber, fltNum);
        enterKeys(text_flightDate, fltDt);
        click(btn_btList);
        minWait();

    }

    /**
     * lists and verifies the damage table
     * @param carrier
     * @param fltNum
     * @param fltDt
     * @param awbNo
     * @param damageCode
     * @param damPcs
     * @return
     * @author a-7681
     */
    public OPR047 verifyAWBDamageDetails(String carrier,String fltNum,String fltDt,String awbNo,String damageCode, String damPcs ){

        carrier= PropertyHandler.getPropValue(dataFilePath,carrier);
        fltNum = PropertyHandler.getPropValue(dataFilePath,fltNum);
        fltDt 	= PropertyHandler.getPropValue(dataFilePath,fltDt);
        awbNo=PropertyHandler.getPropValue(dataFilePath,awbNo);
        damageCode=PropertyHandler.getPropValue(dataFilePath,damageCode);
        damPcs=PropertyHandler.getPropValue(dataFilePath,damPcs);

        list(carrier,fltNum,fltDt);

        Assert.assertTrue(verifyValuePresentInTblColumn (tbl_flightDamageTable, 2, awbNo),"The AWB No: " + awbNo + " is not listed in the table");
        Assert.assertEquals(tblGetTextByColValue(tbl_flightDamageTable,5,2,awbNo),damageCode,"The discrepancy pieces doesn't match.");
        Assert.assertEquals(tblGetTextByColValue(tbl_flightDamageTable,6,2,awbNo),damPcs,"The discrepancy weight doesn't match.");

        return this;


    }


    public HomePage close() {

        click(btn_btClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}