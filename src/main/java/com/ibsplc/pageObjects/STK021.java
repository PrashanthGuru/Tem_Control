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
public class STK021 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK021";
    public static String FRAME2 = "iCargoContentFrameSTK014";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    By dropDown_stockHolderType,
    dropDown_docType,text_fromDate,
    btn_btList,text_toDate,
    Tbl_stockDetailsTable,dropDown_subType,
    btn_btnClose;
    
    

    By btn_noBtn,
    btn_diaYes,
    info_msg;
    
    
    
    
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK021";
        dropDown_stockHolderType=MiscUtility.getWebElement(objFilepath,"STK021_dropDown_stockHolderType");
        dropDown_docType=MiscUtility.getWebElement(objFilepath,"STK021_dropDown_docType");
        dropDown_subType=MiscUtility.getWebElement(objFilepath,"STK021_dropDown_subType");
        btn_btList=MiscUtility.getWebElement(objFilepath,"STK021_btn_btList");
        Tbl_stockDetailsTable=MiscUtility.getWebElement(objFilepath,"STK021_Tbl_stockDetailsTable");
        btn_btnClose=MiscUtility.getWebElement(objFilepath,"STK021_btn_btnClose");
        text_fromDate=MiscUtility.getWebElement(objFilepath,"STK021_text_fromDate");
        text_toDate=MiscUtility.getWebElement(objFilepath,"STK021_text_toDate");
        
         	
    }


	 public STK021(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	  public STK021 CheckStockHolderDetails(String stockHolderType,String stockHolderCode,String Doctype,String Subtype){
		  
		 
		  stockHolderCode = PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
		  stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
		  Doctype = PropertyHandler.getPropValue(dataFilePath,Doctype);
		  Subtype = PropertyHandler.getPropValue(dataFilePath,Subtype);
		  selectByText(dropDown_stockHolderType, stockHolderType);
		  selectByText(dropDown_docType, Doctype);
		  selectByText(dropDown_subType, Subtype);
		  enterKeys(text_fromDate, "-15");
		  enterKeys(text_toDate, ".");
		  click(btn_btList);
		  minWait();
		  
		  String OpeningBalance = getTableCellValue(Tbl_stockDetailsTable, 3, 1);
		  String Recievedstock = getTableCellValue(Tbl_stockDetailsTable, 4, 1);
		  String Returnstock = getTableCellValue(Tbl_stockDetailsTable, 6, 1);
		  String UtilizedStock = getTableCellValue(Tbl_stockDetailsTable, 7, 1);
		  String BlacklistedStock = getTableCellValue(Tbl_stockDetailsTable, 8, 1);
		  String ClosingBlanace = getTableCellValue(Tbl_stockDetailsTable, 9, 1);
		  
		  Assert.assertTrue(waitForElement(Tbl_stockDetailsTable).getText().contains(OpeningBalance),"ERROR :Unable to view the stockholder level details");
		  Assert.assertTrue(waitForElement(Tbl_stockDetailsTable).getText().contains(Recievedstock),"ERROR :Unable to view the stockholder level details");
		  Assert.assertTrue(waitForElement(Tbl_stockDetailsTable).getText().contains(Returnstock),"ERROR :Unable to view the stockholder level details");
		  Assert.assertTrue(waitForElement(Tbl_stockDetailsTable).getText().contains(UtilizedStock),"ERROR :Unable to view the stockholder level details");
		  Assert.assertTrue(waitForElement(Tbl_stockDetailsTable).getText().contains(BlacklistedStock),"ERROR :Unable to view the stockholder level details");
		  Assert.assertTrue(waitForElement(Tbl_stockDetailsTable).getText().contains(ClosingBlanace),"ERROR :Unable to view the stockholder level details");
		  
		 return this;
	  }
	
	
					    public HomePage close() {

			        click(btn_btnClose);
			        driver.switchTo().defaultContent();
			        if (verifyElementPresent(btn_diaYes)) {

			            click(btn_diaYes);
			        }
			        return new HomePage(driver, dataFilePath);
			    }

	 
}
