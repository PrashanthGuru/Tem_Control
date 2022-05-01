package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen CRA178
 * Created on 12/03/2018
 *
 * @author a-6784
 */
public class CRA185 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA185";
    public static String screenFrame = "iCargoContentFrameCRA185";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By 
    info_error,
    txt_startingClearancePeriodFltr,
        yesBtn,noBtn,text_carriageTo,btn_btnClear,info_DebitValue,info_creditValue,
    msg_popup,txt_endingClearancePeriodFltr,txt_airlineCodeFltr,txt_airlineNumberFltr,dropdown_invoiceStatusFltr,
    btn_genericOk,txt_invoiceNumberFltr,dropdown_billingTypeFltr,dropdown_clrHsCodeLst,btn_AccDetailsbtnClose,
    info_genericMsg,okBtn,btn_btnOkpopup,btn_btnPrint,btn_btnAccDetails,btn_btnList,text_CaptureInvtotalWtRateChargesInListingCurrency,
    btn_btnCaptureInvoiceSum,btn_btnExceptions,btn_btnProcess,tbl_listBiledInvoice,chk_allCheck,btn_CaptureInvclose,btn_CaptureInvbtSave,
    btn_btnClose;
    
    
    
    
   
    public CRA185(WebDriver driver, String dataFileName) {
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

    	txt_startingClearancePeriodFltr=MiscUtility.getWebElement(objFilepath, "CRA185_txt_startingClearancePeriodFltr");
    	txt_endingClearancePeriodFltr=MiscUtility.getWebElement(objFilepath, "CRA185_txt_endingClearancePeriodFltr");
    	txt_airlineCodeFltr=MiscUtility.getWebElement(objFilepath, "CRA185_txt_airlineCodeFltr");
    	txt_airlineNumberFltr=MiscUtility.getWebElement(objFilepath, "CRA185_txt_airlineNumberFltr");
    	dropdown_invoiceStatusFltr=MiscUtility.getWebElement(objFilepath, "CRA185_dropdown_invoiceStatusFltr");
    	txt_invoiceNumberFltr=MiscUtility.getWebElement(objFilepath, "CRA185_txt_invoiceNumberFltr");
    	dropdown_billingTypeFltr=MiscUtility.getWebElement(objFilepath, "CRA185_dropdown_billingTypeFltr");
    	dropdown_clrHsCodeLst=MiscUtility.getWebElement(objFilepath, "CRA185_dropdown_clrHsCodeLst");
    	btn_btnList=MiscUtility.getWebElement(objFilepath, "CRA185_btn_btnList");
    	btn_btnClear=MiscUtility.getWebElement(objFilepath, "CRA185_btn_btnClear");
    	btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA185_btn_btnClose");
    	btn_btnPrint=MiscUtility.getWebElement(objFilepath, "CRA185_btn_btnPrint");
    	btn_btnAccDetails=MiscUtility.getWebElement(objFilepath, "CRA185_btn_btnAccDetails");
    	btn_btnCaptureInvoiceSum=MiscUtility.getWebElement(objFilepath, "CRA185_btn_btnCaptureInvoiceSum");
    	btn_btnProcess=MiscUtility.getWebElement(objFilepath, "CRA185_btn_btnProcess");
    	btn_btnExceptions=MiscUtility.getWebElement(objFilepath, "CRA185_btn_btnExceptions");
    	tbl_listBiledInvoice=MiscUtility.getWebElement(objFilepath, "CRA185_tbl_listBiledInvoice");
    	chk_allCheck=MiscUtility.getWebElement(objFilepath, "CRA185_chk_allCheck");
    	text_CaptureInvtotalWtRateChargesInListingCurrency=MiscUtility.getWebElement(objFilepath, "CRA185_text_CaptureInvtotalWtRateChargesInListingCurrency");
    	btn_CaptureInvclose=MiscUtility.getWebElement(objFilepath, "CRA185_btn_CaptureInvclose");
    	btn_CaptureInvbtSave=MiscUtility.getWebElement(objFilepath, "CRA185_btn_CaptureInvbtSave");
    	info_DebitValue=MiscUtility.getWebElement(objFilepath, "CRA185_info_AccountingDebitValue");
    	info_creditValue=MiscUtility.getWebElement(objFilepath, "CRA185_info_AccountingcreditValue");
    	btn_AccDetailsbtnClose=MiscUtility.getWebElement(objFilepath, "CRA185_btn_AccDetailsbtnClose");
    	
    	
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        msg_popup = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        okBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
      
         info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
       
    }

    

    
 
public CRA185  VerifyMandatoryfields(){


	click(btn_btnList);
minWait();
driver.switchTo().defaultContent();

Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Either Clearance Period or Airline Code or Airline Number or Invoice Status is mandatory"),"Error:The error not shown");
click(btn_genericOk);
waitForFrameAndSwitch(FRAME);


return this;
}

public CRA185  VerifyFields(){


Assert.assertTrue(waitForElement(dropdown_invoiceStatusFltr).getText().contains("Balanced"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_invoiceStatusFltr).getText().contains("New"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_invoiceStatusFltr).getText().contains("Processed"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_invoiceStatusFltr).getText().contains("Processed with error"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_invoiceStatusFltr).getText().contains("Rejected"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_invoiceStatusFltr).getText().contains("Resolved"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_invoiceStatusFltr).getText().contains("Unbalanced"),"Error:value not present");
enterKeys(txt_invoiceNumberFltr, "INV1");
enterKeys(txt_invoiceNumberFltr, "INV22");
Assert.assertTrue(waitForElement(dropdown_billingTypeFltr).getText().contains("Billing Memo"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_billingTypeFltr).getText().contains("Collect AirWaybill"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_billingTypeFltr).getText().contains("Credit Memo"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_billingTypeFltr).getText().contains("Prepaid AirWaybill"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_billingTypeFltr).getText().contains("Rejection Memo"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_clrHsCodeLst).getText().contains("Resolved"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_clrHsCodeLst).getText().contains("ACH"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_clrHsCodeLst).getText().contains("ICH"),"Error:value not present");
Assert.assertTrue(waitForElement(dropdown_clrHsCodeLst).getText().contains("Non-ICH"),"Error:value not present");


Assert.assertTrue(waitForElement(btn_btnClear).isEnabled(),"Error: The button is disabled");
Assert.assertTrue(waitForElement(btn_btnList).isEnabled(),"Error: The button is disabled");
Assert.assertTrue(waitForElement(btn_btnClose).isEnabled(),"Error: The button is disabled");

Assert.assertFalse(waitForElement(btn_btnAccDetails).isEnabled(),"Error: the button is enabled");
Assert.assertFalse(waitForElement(btn_btnCaptureInvoiceSum).isEnabled(),"Error: the button is enabled");
Assert.assertFalse(waitForElement(btn_btnExceptions).isEnabled(),"Error: the button is enabled");
Assert.assertFalse(waitForElement(btn_btnPrint).isEnabled(),"Error: the button is enabled");
Assert.assertFalse(waitForElement(btn_btnProcess).isEnabled(),"Error: the button is enabled");

return this;
}

    public CRA185  VerifyInvoice(String airlineCode,String InvoiceNo,String InvStatus){
    airlineCode = PropertyHandler.getPropValue(dataFilePath, airlineCode);
    InvoiceNo = PropertyHandler.getPropValue(dataFilePath, InvoiceNo);
    InvStatus = PropertyHandler.getPropValue(dataFilePath, InvStatus);
    enterKeys(txt_airlineCodeFltr, airlineCode);


	click(btn_btnList);
    minWait();
    
    tblSelectRowByMultipleColValue(tbl_listBiledInvoice, 1, 7, 10, InvoiceNo, InvStatus);

         return this;
     }

    public CRA185  VerifyError_AirlinecodePopulate(){

    enterKeys(txt_startingClearancePeriodFltr, ".");
	enterKeys(txt_endingClearancePeriodFltr, "+1");

    	click(btn_btnList);
    minWait();
    Assert.assertTrue(waitForElement(info_error).getText().contains("No Records Found"),"Error:No error shown");
    enterKeys(txt_endingClearancePeriodFltr, ".");
	enterKeys(txt_startingClearancePeriodFltr, "+1");

    	click(btn_btnList);
    minWait();
    Assert.assertTrue(waitForElement(info_error).getText().contains("From date cannot be greater than To date"),"Error:No error shown");

    enterKeys(txt_airlineCodeFltr, "AA");
    click(btn_btnList);
    Assert.assertTrue(waitForElement(txt_airlineNumberFltr).getAttribute("value").contains("001"),"Error: The Airline number not auto populated");
    return this;
    }

    public CRA185  ListDetails_WithDiffStatusAndNavigateToCAptureInvDetails(String Status,String Invno,String Wchrg){

    	Status = PropertyHandler.getPropValue(dataFilePath, Status);
    	Invno = PropertyHandler.getPropValue(dataFilePath, Invno);
    	Wchrg = PropertyHandler.getPropValue(dataFilePath, Wchrg);
    	if(Status=="New")
    	{
    		selectByText(dropdown_invoiceStatusFltr, "New");
    		click(btn_btnList);
    		tblSelectRowByColValue(tbl_listBiledInvoice, 1, 7, Invno);
    		click(btn_btnCaptureInvoiceSum);
    		minWait();
    		enterKeys(text_CaptureInvtotalWtRateChargesInListingCurrency,Wchrg);
    		click(btn_CaptureInvbtSave);
    		minWait();
    		click(btn_CaptureInvclose);
    		
    	}
    	if(Status=="Balanced")
    	{
    		selectByText(dropdown_invoiceStatusFltr, "Balanced");
    		click(btn_btnList);
    		tblSelectRowByColValue(tbl_listBiledInvoice, 1, 7, Invno);
    		click(btn_btnCaptureInvoiceSum);
    		minWait();
    		Assert.assertFalse(waitForElement(text_CaptureInvtotalWtRateChargesInListingCurrency).isEnabled(),"Error: The field is editable");
    		click(btn_CaptureInvclose);
    	}
    	if(Status=="Unbalanced")
    	{
    		selectByText(dropdown_invoiceStatusFltr, "Unbalanced");
    		click(btn_btnList);
    		tblSelectRowByColValue(tbl_listBiledInvoice, 1, 7, Invno);
    		click(btn_btnCaptureInvoiceSum);
    		minWait();
    		enterKeys(text_CaptureInvtotalWtRateChargesInListingCurrency,Wchrg);
    		click(btn_CaptureInvbtSave);
    		minWait();
    		click(btn_CaptureInvclose);
    		
    	}
    	if(Status=="Rejected")
    	{
    		selectByText(dropdown_invoiceStatusFltr, "Rejected");
    		click(btn_btnList);
    		tblSelectRowByColValue(tbl_listBiledInvoice, 1, 7, Invno);
    		click(btn_btnCaptureInvoiceSum);
    		minWait();
    		Assert.assertFalse(waitForElement(text_CaptureInvtotalWtRateChargesInListingCurrency).isEnabled(),"Error: The field is editable");
    		click(btn_CaptureInvclose);
    	}
    	if(Status=="Processed")
    	{
    		selectByText(dropdown_invoiceStatusFltr, "Processed");
    		click(btn_btnList);
    		tblSelectRowByColValue(tbl_listBiledInvoice, 1, 7, Invno);
    		click(btn_btnCaptureInvoiceSum);
    		minWait();
    		Assert.assertFalse(waitForElement(text_CaptureInvtotalWtRateChargesInListingCurrency).isEnabled(),"Error: The field is editable");
    		click(btn_CaptureInvclose);
    		minWait();
    		click(btn_btnAccDetails);
    		minWait();
    		String debitvalue=waitForElement(info_DebitValue).getText();
        	String creditvalue=waitForElement(info_creditValue).getText();
        	
        	Assert.assertTrue(debitvalue.equals(creditvalue));
        	click(btn_AccDetailsbtnClose);
        	minWait();
    		return this;
        	
    	
    	}
    	if(Status=="Processed with error")
    	{
    		selectByText(dropdown_invoiceStatusFltr, "Processed with error");
    		click(btn_btnList);
    		tblSelectRowByColValue(tbl_listBiledInvoice, 1, 7, Invno);
    		click(btn_btnCaptureInvoiceSum);
    		minWait();
    		Assert.assertFalse(waitForElement(text_CaptureInvtotalWtRateChargesInListingCurrency).isEnabled(),"Error: The field is editable");
    		click(btn_CaptureInvclose);
    	}
    	
    	
        return this;
        }
    
    
    public CRA185  ListDetails_WithClearingHouse(String Status,String Invno,String Wchrg,String ClearingHouse,String ClearancePeriod,String airlineCode){

    	Status = PropertyHandler.getPropValue(dataFilePath, Status);
    	Invno = PropertyHandler.getPropValue(dataFilePath, Invno);
    	Wchrg = PropertyHandler.getPropValue(dataFilePath, Wchrg);
    	airlineCode = PropertyHandler.getPropValue(dataFilePath, airlineCode);
    	ClearingHouse = PropertyHandler.getPropValue(dataFilePath, ClearingHouse);
    	ClearancePeriod = PropertyHandler.getPropValue(dataFilePath, ClearancePeriod);
    	
    	
    		selectByText(dropdown_clrHsCodeLst,ClearingHouse);
    		selectByText(dropdown_invoiceStatusFltr,Status);
    		click(btn_btnList);
    		
    		tblSelectRowByMultipleColValue(tbl_listBiledInvoice, 1, 7, 2, Invno, ClearancePeriod);
    		tblSelectRowByColValue(tbl_listBiledInvoice, 1, 3, ClearingHouse);
    		tblSelectRowByColValue(tbl_listBiledInvoice, 1, 4, airlineCode);
    		click(btn_btnCaptureInvoiceSum);
    		minWait();
    		Assert.assertFalse(waitForElement(text_CaptureInvtotalWtRateChargesInListingCurrency).isEnabled(),"Error: The field is editable");
    		click(btn_CaptureInvclose);
    	
    	
    	return this;
    }
    
    public CRA185  VerifyDetails(String Status,String Invno,String Wchrg,String Blngcode,String ClearingHouse,String ClearancePeriod,String airlineNo,String LstgCurr){

    	Status = PropertyHandler.getPropValue(dataFilePath, Status);
    	Invno = PropertyHandler.getPropValue(dataFilePath, Invno);
    	Wchrg = PropertyHandler.getPropValue(dataFilePath, Wchrg);
    	LstgCurr = PropertyHandler.getPropValue(dataFilePath, Wchrg);
    	airlineNo = PropertyHandler.getPropValue(dataFilePath, airlineNo);
    	Blngcode = PropertyHandler.getPropValue(dataFilePath, Blngcode);
    	ClearingHouse = PropertyHandler.getPropValue(dataFilePath, ClearingHouse);
    	ClearancePeriod = PropertyHandler.getPropValue(dataFilePath, ClearancePeriod);
    	selectByText(dropdown_clrHsCodeLst,ClearingHouse);
    	selectByText(dropdown_invoiceStatusFltr,Status);
    		enterKeys(txt_invoiceNumberFltr, Invno);
    		click(btn_btnList);
    		String AirlineNo=getTableCellValue(tbl_listBiledInvoice, 5, 1);
    		System.out.println("Airline Number:"+AirlineNo);
    		String BillingCode=getTableCellValue(tbl_listBiledInvoice, 6, 1);
    		System.out.println("BillingCode:"+BillingCode);
    		String LstCurr=getTableCellValue(tbl_listBiledInvoice, 8, 1);
    		System.out.println("LstCurr:"+LstCurr);
    		String Inv_Status=getTableCellValue(tbl_listBiledInvoice, 10, 1);
    		System.out.println("Inv_Status:"+LstCurr);
    		String Wtgchrg=getTableCellValue(tbl_listBiledInvoice, 9, 1);
    		System.out.println("Wtgchrg:"+Wtgchrg);
    		
    		Assert.assertTrue((AirlineNo).contains(airlineNo),"Error: The details not shown correctly");
    		Assert.assertTrue((BillingCode).contains(Blngcode),"Error: The details not shown correctly");
    		Assert.assertTrue((LstCurr).contains(LstgCurr),"Error: The details not shown correctly");
    		Assert.assertTrue((Inv_Status).contains(Status),"Error: The details not shown correctly");
    		Assert.assertTrue((Wtgchrg).contains(Wchrg),"Error: The details not shown correctly");
    
    	
    	
    	return this;
    }
    public CRA185  Process_ProcessedInvoiceError(String Invno){

    
    	Invno = PropertyHandler.getPropValue(dataFilePath, Invno);
    	
    	
    	
    		
    		selectByText(dropdown_invoiceStatusFltr, "Processed");
    		click(btn_btnList);
    		tblSelectRowByColValue(tbl_listBiledInvoice, 1, 7, Invno);
    		click(btn_btnProcess);
    		minWait();
    		driver.switchTo().defaultContent();
    		Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Please select invoice with status Balanced or Processed With Error"),"Error:Error message not shown");
    		click(okBtn);
    		switchToFirstWindow();
    		waitForFrameAndSwitch(FRAME);
    	
    	
    	return this;
    }
    public CRA185  Process_ExceptionError(String Invno){

        
    	Invno = PropertyHandler.getPropValue(dataFilePath, Invno);
    	
    	
    	
    		
    		selectByText(dropdown_invoiceStatusFltr, "Processed");
    		click(btn_btnList);
    		tblSelectRowByColValue(tbl_listBiledInvoice, 1, 7, Invno);
    		click(btn_btnExceptions);
    		minWait();
    		driver.switchTo().defaultContent();
    		Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Please select invoice with status Processed with error!"),"Error:Error message not shown");
    		click(okBtn);
    		switchToFirstWindow();
    		waitForFrameAndSwitch(FRAME);
    	
    	
    	return this;
    }
public HomePage close(){
	click(btn_btnClose);
	
	driver.switchTo().defaultContent();
	if (verifyElementPresent(yesBtn)) {

         click(yesBtn);
     }
	
	return new HomePage(driver,dataFileName);
}
}
