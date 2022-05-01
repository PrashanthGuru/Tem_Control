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
public class STK019 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK019";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    By text_stockHolderCode,text_startDate,
    btn_btnList,
    tbl_listAwbStockHistoryTable,
    btn_btnClose,
    btn_btnPrint;
    

    By btn_noBtn,
    btn_diaYes,
    info_msg;
    
    
    
    
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK019";
        text_stockHolderCode=MiscUtility.getWebElement(objFilepath,"STK019_text_stockHolderCode");
        btn_btnList=MiscUtility.getWebElement(objFilepath,"STK019_btn_btnList");
        tbl_listAwbStockHistoryTable=MiscUtility.getWebElement(objFilepath,"STK019_tbl_listAwbStockHistoryTable");
        btn_btnClose=MiscUtility.getWebElement(objFilepath,"STK019_btn_btnClose");
        btn_btnPrint=MiscUtility.getWebElement(objFilepath,"STK019_btn_btnPrint");
       text_startDate=MiscUtility.getWebElement(objFilepath,"STK019_text_startDate");
        info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
       
    }
   


	 public STK019(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	  public STK019 ListPrintHistory(String Stockholder){
		 
		 // String StockRange = generateRandomString();
		//  PropertyHandler.setPropValue(dataFilePath,stockRange1, StockRange);
		  Stockholder = PropertyHandler.getPropValue(dataFilePath,Stockholder);
		  
		 
		  enterKeys(text_stockHolderCode, Stockholder);
		  enterKeys(text_startDate, "-30");
		  click(btn_btnList);
		  minWait();
		  
		  
		  
		  
		  String stockholder1 = getTableCellValue(tbl_listAwbStockHistoryTable, 1, 1);
		  Assert.assertTrue(waitForElement(tbl_listAwbStockHistoryTable).getText().contains(Stockholder),"ERROR :No data found");
		  click(btn_btnPrint);
		
		 		 return this;
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
