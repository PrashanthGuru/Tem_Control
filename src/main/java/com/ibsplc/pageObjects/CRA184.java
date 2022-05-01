package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen CRA81
 * Created on 12/03/2018
 *
 * @author a-6784
 */
public class CRA184 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA184";
    public static String screenFrame = "iCargoContentFrameCRA184";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
 
    
    By
    Generic_btn_ok,info_error,
    yesBtn,info_msg,tbl_impactEndurance,
    txt_fromDate,txt_toDate,txt_airlineCode,
    txt_airlineNumber,txt_invoiceNumber,dropdown_impactBasis,
    txt_billingCurrency,txt_awbEndurancePercentage,txt_awbEnduranceValue,
    txt_invoiceEndurancePercentage,txt_invoiceEnduranceValue,
    btn_btnList,btn_btnClear,btn_btnIssueRejectionMemo,text_RejnMemoaccepted,
    btn_btnPrint,btn_RejnMemobtnClose,btn_btnClose;
    
   
    
    public CRA184(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    

    /**
     * Initializes the page objects required for the class
     */
    private void initElements() {
    	
    	
    	txt_fromDate            =  MiscUtility.getWebElement(objFilepath, "CRA184_txt_fromDate");
    	txt_toDate            =  MiscUtility.getWebElement(objFilepath, "CRA184_txt_toDate");
    	txt_airlineCode            =  MiscUtility.getWebElement(objFilepath, "CRA184_txt_airlineCode");
    	txt_airlineNumber            =  MiscUtility.getWebElement(objFilepath, "CRA184_txt_airlineNumber");
    	txt_invoiceNumber            =  MiscUtility.getWebElement(objFilepath, "CRA184_txt_invoiceNumber");
    	dropdown_impactBasis            =  MiscUtility.getWebElement(objFilepath, "CRA184_dropdown_impactBasis");
    	txt_billingCurrency            =  MiscUtility.getWebElement(objFilepath, "CRA184_txt_billingCurrency");
    	txt_awbEndurancePercentage            =  MiscUtility.getWebElement(objFilepath, "CRA184_txt_awbEndurancePercentage");
    	txt_awbEnduranceValue            =  MiscUtility.getWebElement(objFilepath, "CRA184_txt_awbEnduranceValue");
    	txt_invoiceEndurancePercentage            =  MiscUtility.getWebElement(objFilepath, "CRA184_txt_invoiceEndurancePercentage");
    	txt_invoiceEnduranceValue            =  MiscUtility.getWebElement(objFilepath, "CRA184_txt_invoiceEnduranceValue");
    	txt_invoiceEnduranceValue            =  MiscUtility.getWebElement(objFilepath, "CRA184_txt_invoiceEnduranceValue");
    	btn_btnList            =  MiscUtility.getWebElement(objFilepath, "CRA184_btn_btnList");
    	btn_btnClear            =  MiscUtility.getWebElement(objFilepath, "CRA184_btn_btnClear");
    	btn_btnIssueRejectionMemo            =  MiscUtility.getWebElement(objFilepath, "CRA184_btn_btnIssueRejectionMemo");
    	btn_btnPrint            =  MiscUtility.getWebElement(objFilepath, "CRA184_btn_btnPrint");
    	btn_btnClose            =  MiscUtility.getWebElement(objFilepath, "CRA184_btn_btnClose");
    	tbl_impactEndurance            =  MiscUtility.getWebElement(objFilepath, "CRA184_tbl_impactEndurance");
    	text_RejnMemoaccepted=  MiscUtility.getWebElement(objFilepath, "CRA184_text_RejnMemoaccepted");
    	btn_RejnMemobtnClose=  MiscUtility.getWebElement(objFilepath, "CRA184_btn_RejnMemobtnClose");
        
       Generic_btn_ok                           = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
       yesBtn                                   = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
       info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
       info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    }
    
   public CRA184 VerifyMandatoryDetails(){
 	
	   enterKeys(txt_fromDate, "");
	   enterKeys(txt_toDate, "");
	   minWait();
	   click(btn_btnList);
	   Assert.assertTrue(waitForElement(info_error).getText().contains("Please enter Clearance from date"),"Error: The error not shown");
	   Assert.assertTrue(waitForElement(info_error).getText().contains("Please enter Clearance to date"),"Error: The error not shown");
	   Assert.assertTrue(waitForElement(info_error).getText().contains("Please enter Airline Code or Airline Number"),"Error: The error not shown");
	   
	return this;
   }
   
   public CRA184 VerifyButton(){
	   Assert.assertTrue(waitForElement(btn_btnClear).isEnabled(),"Error: The button is enabled");
	   Assert.assertTrue(waitForElement(btn_btnClose).isEnabled(),"Error: The button is enabled");
	   Assert.assertTrue(waitForElement(btn_btnList).isEnabled(),"Error: The button is enabled");
	   
	 
	   click(btn_btnList);
	   
	   Assert.assertFalse(waitForElement(btn_btnClear).isEnabled(),"Error: The button is not enabled");
	   Assert.assertFalse(waitForElement(btn_btnClear).isEnabled(),"Error: The button is not enabled");
	   
	return this;
   }
   
 
	
	  public CRA184 ListDetails_CheckImpactBasis(String Clrfrmdate,String ClrTodate,String airlinecode,String Status){
		 	
		   Clrfrmdate=PropertyHandler.getPropValue(dataFilePath, Clrfrmdate);
		   ClrTodate=PropertyHandler.getPropValue(dataFilePath, ClrTodate);
		   airlinecode=PropertyHandler.getPropValue(dataFilePath, airlinecode);
		   Status=PropertyHandler.getPropValue(dataFilePath, Status);
		   enterKeys(txt_fromDate, Clrfrmdate);
		   enterKeys(txt_toDate, ClrTodate);
		   enterKeys(txt_airlineCode, airlinecode);
		   click(btn_btnList);
		   
		   tblSelectRowByColValue(tbl_impactEndurance, 1, 11, Status);
		   Assert.assertTrue(waitForElement(btn_btnPrint).isEnabled(),"Error: The button is not enabled");
		   Assert.assertTrue(waitForElement(btn_btnIssueRejectionMemo).isEnabled(),"Error: The button is not enabled");
		   
		   
		   
		   
		   
		return this;
   }
	  

	  public CRA184 IssueRejectionMemo_nosave(String Clrfrmdate,String ClrTodate,String airlinecode,String awbno){
		 	
		   Clrfrmdate=PropertyHandler.getPropValue(dataFilePath, Clrfrmdate);
		   ClrTodate=PropertyHandler.getPropValue(dataFilePath, ClrTodate);
		   airlinecode=PropertyHandler.getPropValue(dataFilePath, airlinecode);
		   awbno=PropertyHandler.getPropValue(dataFilePath, awbno);
		   enterKeys(txt_fromDate, Clrfrmdate);
		   enterKeys(txt_toDate, ClrTodate);
		   enterKeys(txt_airlineCode, airlinecode);
		   click(btn_btnList);
		   
		   tblSelectRowByColValue(tbl_impactEndurance, 1, 5, awbno);
		   click(btn_btnIssueRejectionMemo);
		   enterKeys(text_RejnMemoaccepted, "1000");
		   click(btn_RejnMemobtnClose);	   
		   minWait();
		   click(btn_btnIssueRejectionMemo);
		   minWait();
		   driver.switchTo().defaultContent();
		   Assert.assertTrue(waitForElement(info_msg).getText().contains("Please select a row"),"Error: The message is not shown");
		   click(Generic_btn_ok);
		   waitForFrameAndSwitch(FRAME);
		   String BilledVal= getTableCellValue(tbl_impactEndurance, 8, 1).replace(",","");
		   System.out.println("BilledVal"+BilledVal);
		   String OurVal= getTableCellValue(tbl_impactEndurance, 9, 1).replace(",","");
		   System.out.println("OurVal"+OurVal);
		   float BV=Float.parseFloat(BilledVal);
		   float OV=Float.parseFloat(OurVal);
		   float ImpVal=BV-OV;
		   String ImpactValue=String.valueOf(ImpVal);
		   String imV=getTableCellValue(tbl_impactEndurance, 10, 1).replace(",","");
		   Assert.assertTrue(ImpactValue.equals(imV),"Error: Impact Value mismatch");
		   
		   
		   
		   
		   
		   
		
		return this;
   }

	   public HomePage close() {

        click(btn_btnClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFilePath);
    }

    
}
