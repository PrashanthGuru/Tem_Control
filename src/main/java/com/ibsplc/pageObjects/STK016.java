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
public class STK016 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK016";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    By text_fromDate,
    dropDown_docType,
    dropDown_subType,
    text_toDate,
    Tbl_stkRequestTable,
    text_code,btn_btClose,btn_btList;
    
    
    
    

    By btn_noBtn,
    btn_diaYes,
    info_msg;
    
    
    
    
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK016";
       
        btn_btList = MiscUtility.getWebElement(objFilepath,"STK016_btn_btList"); 
        info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        dropDown_docType=MiscUtility.getWebElement(objFilepath, "STK016_dropDown_docType");
        dropDown_subType	=MiscUtility.getWebElement(objFilepath, "STK016_dropDown_subType");	
        text_fromDate=MiscUtility.getWebElement(objFilepath, "STK016_text_fromDate");
        text_toDate=MiscUtility.getWebElement(objFilepath, "STK016_text_toDate");
        btn_btClose=MiscUtility.getWebElement(objFilepath, "STK016_btn_btClose");
        Tbl_stkRequestTable=MiscUtility.getWebElement(objFilepath, "STK016_Tbl_stkRequestTable");
        text_code=MiscUtility.getWebElement(objFilepath, "STK016_text_code");
        
    }


	 public STK016(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	
	 
	
					    public STK016 ListStockRequest(String DocType, String Subtype,String fromdate,String todate,String StockHolderCode){

					 
					 
					 DocType = PropertyHandler.getPropValue(dataFilePath,DocType);
					 
					 Subtype = PropertyHandler.getPropValue(dataFilePath,Subtype);
					 fromdate = PropertyHandler.getPropValue(dataFilePath,fromdate);
					 todate = PropertyHandler.getPropValue(dataFilePath,todate);
					 StockHolderCode = PropertyHandler.getPropValue(dataFilePath,StockHolderCode);
					 
					
					 selectByText(dropDown_docType, DocType);
					 selectByText(dropDown_subType, Subtype);
					 enterKeys(text_fromDate, fromdate);
					 enterKeys(text_toDate, todate);
					 enterKeys(text_code, StockHolderCode);
					 click(btn_btList);
					 minWait();
					// driver.switchTo().defaultContent();
					
					 String Agentname = getTableCellValue(Tbl_stkRequestTable, 3, 1);
					 Assert.assertTrue(Agentname.contains(StockHolderCode),"ERROR :Unable to view the stockholder level details");
				   //  click(btn_btClose);
				     return this;
				    }
			   			    public HomePage close() {

			        click(btn_btClose);
			        driver.switchTo().defaultContent();
			        if (verifyElementPresent(btn_diaYes)) {

			            click(btn_diaYes);
			        }
			        return new HomePage(driver, dataFileName);
			    }

	 
}
