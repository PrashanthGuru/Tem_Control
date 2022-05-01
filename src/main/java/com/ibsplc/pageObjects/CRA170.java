package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * 
 * @author A-6784
 *
 */

public class CRA170 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA170";
   
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

By
txt_clearanceperiod,
txt_invoicenum,
btn_list,
tbl_awbDetails,
btn_close,
link_addToLink,
btn_closeaddPopup,
btn_chooseAttachmnt,
btn_invoicenumberlov,
chkbox_selectInvoice,
btn_OK,
yesBtn,
btn_attach,
dropdown_attachmentTypeFltr,
btn_search,
chkbx_selectCheck,
btn_print,
btn_printInvoiceSchedule,
tbl_amtsInBillingCurrencyFooter,
btn_printInvoiceSummary,
txt_awbPrefix,
txt_awb,
info_awbNumbr,
listAccountingEntries_btn_close,
btn_listAccountingEntries,
btn_withdraw,
Generic_info_msg,
info_ISFileName,
Generic_btn_ok,
btn_clear,
dropdown_billingType,
txt_airlineCode,
Generic_footer_error,
tbl_result,
txt_totalAmount
;


public CRA170(WebDriver driver, String dataFileName) {
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
	
	
	txt_clearanceperiod          = MiscUtility.getWebElement(objFilepath, "CRA170_txt_clearanceperiod");
	txt_invoicenum               = MiscUtility.getWebElement(objFilepath, "CRA170_txt_invoicenum");
	btn_list                     = MiscUtility.getWebElement(objFilepath, "CRA170_btn_list");
	tbl_awbDetails               = MiscUtility.getWebElement(objFilepath, "CRA170_tbl_awbDetails");
	btn_close                    = MiscUtility.getWebElement(objFilepath, "CRA170_btn_close");
	link_addToLink               = MiscUtility.getWebElement(objFilepath, "CRA170_link_addToLink");
	btn_closeaddPopup            = MiscUtility.getWebElement(objFilepath, "CRA170_btn_closeaddPopup");
	btn_chooseAttachmnt          = MiscUtility.getWebElement(objFilepath, "CRA170_btn_chooseAttachmnt");
	btn_invoicenumberlov         = MiscUtility.getWebElement(objFilepath, "CRA170_btn_invoicenumberlov");
	chkbox_selectInvoice         = MiscUtility.getWebElement(objFilepath, "CRA170_chkbox_selectInvoice");
	btn_OK                       = MiscUtility.getWebElement(objFilepath, "CRA170_btn_OK");
	btn_attach                   = MiscUtility.getWebElement(objFilepath, "CRA170_btn_attach");
	yesBtn                       = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
	dropdown_attachmentTypeFltr  = MiscUtility.getWebElement(objFilepath, "CRA170_dropdown_attachmentTypeFltr");
	btn_search                   = MiscUtility.getWebElement(objFilepath, "CRA170_btn_search");
	chkbx_selectCheck            = MiscUtility.getWebElement(objFilepath, "CRA170_chkbx_selectCheck");
	txt_awbPrefix                = MiscUtility.getWebElement(objFilepath, "CRA170_txt_awbPrefix");
	txt_awb                      = MiscUtility.getWebElement(objFilepath, "CRA170_txt_awb");
	info_awbNumbr                = MiscUtility.getWebElement(objFilepath, "CRA170_info_awbNumbr");
tbl_amtsInBillingCurrencyFooter  = MiscUtility.getWebElement(objFilepath, "CRA170_tbl_amtsInBillingCurrencyFooter");
	btn_print                    = MiscUtility.getWebElement(objFilepath, "CRA170_btn_print");
	btn_printInvoiceSchedule     = MiscUtility.getWebElement(objFilepath, "CRA170_btn_printInvoiceSchedule");
	btn_printInvoiceSummary      = MiscUtility.getWebElement(objFilepath, "CRA170_btn_printInvoiceSummary");
	listAccountingEntries_btn_close= MiscUtility.getWebElement(objFilepath, "CRA170_listAccountingEntries_btn_close");
	btn_listAccountingEntries    = MiscUtility.getWebElement(objFilepath, "CRA170_btn_listAccountingEntries");
	btn_withdraw                 = MiscUtility.getWebElement(objFilepath, "CRA170_btn_withdraw");
	Generic_info_msg             = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
	Generic_btn_ok               = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
	btn_clear                    = MiscUtility.getWebElement(objFilepath, "CRA170_btn_clear");
	info_ISFileName              = MiscUtility.getWebElement(objFilepath, "CRA170_info_ISFileName");
	dropdown_billingType         =MiscUtility.getWebElement(objFilepath, "CRA170_dropdown_billingType");
    txt_airlineCode              =MiscUtility.getWebElement(objFilepath, "CRA170_txt_airlineCode");
    Generic_footer_error         = MiscUtility.getWebElement(genObjPath, "Generic_footer_error");
    tbl_result                   =MiscUtility.getWebElement(objFilepath, "CRA170_tbl_result");
    txt_totalAmount              =MiscUtility.getWebElement(objFilepath, "CRA170_txt_totalAmount");
}
/**
 * 
 * @param invoice
 * @param fullawbNo
 * @return
 */

public CRA170 verifyInvDetails(String invoice,String prefix,String awbNo){
	
	invoice=PropertyHandler.getPropValue(dataFilePath, invoice);
	awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
	prefix=PropertyHandler.getPropValue(dataFilePath, prefix);
	
	
	click(btn_clear);
	minWait();
	enterKeys(txt_invoicenum, invoice);
	click(btn_invoicenumberlov);
	 driver.switchTo().defaultContent();
	waitForNewWindow(2);
	switchToSecondWindow();
	
	check(chkbox_selectInvoice);
	click(btn_OK);
	switchToFirstWindow();
	
	waitForFrameAndSwitch(FRAME);
	click(btn_list);
	minWait();
	String fullawbNo=prefix+"-"+awbNo;
	String fullawb=getTableCellValue(tbl_awbDetails, 3, 1).replace(" ", "-");
	
	Assert.assertTrue(fullawb.endsWith(fullawbNo));
	return this;

}
/**
 * 
 * @param invoice
 * @param attachmntPath
 * @return
 */
    public CRA170 addAttachment(String invoice,String attachmntPath){
    	
    	invoice=PropertyHandler.getPropValue(dataFilePath, invoice);
    	attachmntPath=PropertyHandler.getPropValue(dataFilePath, attachmntPath);
    	
    	click(btn_clear);
    	minWait();
    	enterKeys(txt_invoicenum, invoice);
    	click(btn_invoicenumberlov);
    	 driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	check(chkbox_selectInvoice);
    	click(btn_OK);
    	switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	click(btn_list);
    	minWait();
    	click(link_addToLink);
    	 driver.switchTo().defaultContent();
     	waitForNewWindow(2);
     	switchToSecondWindow();
     	waitForElement(btn_chooseAttachmnt).sendKeys(attachmntPath);
     	click(btn_attach);
     	minWait();
     	switchToFirstWindow();
     	waitForFrameAndSwitch(FRAME);
		return this;
     	
    }
    
    public CRA170 storeIsFileName(String invoicenumbr,String ISFileName){
    	
    	
    	invoicenumbr=PropertyHandler.getPropValue(objFilepath, invoicenumbr);
    	click(btn_clear);
    	minWait();
    	enterKeys(txt_invoicenum, invoicenumbr);
    	click(btn_invoicenumberlov);
    	 driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	check(chkbox_selectInvoice);
    	click(btn_OK);
    	switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	click(btn_list);
    	minWait();
    	
    	String isFileName=waitForElement(info_ISFileName).getAttribute("value");
    	PropertyHandler.setPropValue(dataFilePath, ISFileName, isFileName);
		
    	
    	return this;
    	
    }
   /***
    *  
    * @param invoicenumbr
    * @param ISFileName
    * @return
    */
    public CRA170 verifyIsFileName(String invoicenumbr,String ISFileName){
    	
    	invoicenumbr=PropertyHandler.getPropValue(dataFilePath, invoicenumbr);
    	ISFileName=PropertyHandler.getPropValue(dataFilePath, ISFileName);
		
    	
    	click(btn_clear);
    	minWait();
    	enterKeys(txt_invoicenum, invoicenumbr);
    	click(btn_invoicenumberlov);
    	 driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	check(chkbox_selectInvoice);
    	click(btn_OK);
    	switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	click(btn_list);
    	minWait();
    	
    	String tmpIsFile=waitForElement(info_ISFileName).getAttribute("value");
    	PropertyHandler.setPropValue(dataFilePath, ISFileName, tmpIsFile);
    	
    	
    	return this;
    }
    /**
     * 
     * @param invoicenumbr
     * @return
     */
    
    public CRA170 compareListing_Billing_amts(String invoicenumbr,boolean isSame){
    	
    	invoicenumbr=PropertyHandler.getPropValue(objFilepath, invoicenumbr);
    	click(btn_clear);
    	minWait();
    	enterKeys(txt_invoicenum, invoicenumbr);
    	click(btn_invoicenumberlov);
    	 driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	check(chkbox_selectInvoice);
    	click(btn_OK);
    	switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	click(btn_list);
    	minWait();
		
    	String amtinListingCurrency=getTableCellValue(tbl_awbDetails, 14, 1);
    	String amtinBillingCurr=getTableCellValue(tbl_amtsInBillingCurrencyFooter, 5, 2);
    	if(isSame==true)
    	Assert.assertTrue(amtinListingCurrency.equals(amtinBillingCurr));
    	else
    		Assert.assertFalse(amtinListingCurrency.equals(amtinBillingCurr));
		return this;
    	
    }
    /***
     * 
     * @param invoicenumbr
     * @return
     */
    public CRA170 accounting_Navigation(String invoicenumbr){
    	
    	invoicenumbr=PropertyHandler.getPropValue(objFilepath, invoicenumbr);
    	click(btn_clear);
    	minWait();
    	enterKeys(txt_invoicenum, invoicenumbr);
    	click(btn_invoicenumberlov);
    	 driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	check(chkbox_selectInvoice);
    	click(btn_OK);
    	switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	click(btn_list);
    	minWait();
		
    	check(chkbx_selectCheck);
    	
    	click(btn_listAccountingEntries);
    	maxWait();
    	click(listAccountingEntries_btn_close);
    
    	
    	return this;
    }
    /**
     * 
     * @param invoice
     * @param awbPrefix
     * @param awb
     * @return
     */
    public CRA170 withdraw(String invoiceNum,String awbPrefix,String AWB,boolean isFileGenerated){
    	
    	invoiceNum=PropertyHandler.getPropValue(dataFilePath, invoiceNum);
    	awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWB=PropertyHandler.getPropValue(dataFilePath, AWB);
    	
    	click(btn_clear);
    	minWait();
    	enterKeys(txt_invoicenum, invoiceNum);
    	click(btn_invoicenumberlov);
    	 driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	check(chkbox_selectInvoice);
    	click(btn_OK);
    	switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	click(btn_list);
    	minWait();
		
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_awb, AWB);
    	click(btn_search);
    	minWait();
		
    	
    	check(chkbx_selectCheck);
    	click(btn_withdraw);
    	
    	driver.switchTo().defaultContent();
    	if(isFileGenerated){
    	verifyElementPresent(yesBtn) ;
    	Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("AWB has already been picked up in the IS-File. Do you wish to withdraw the AWB from the invoice?"));
         
            click(yesBtn);
        
    	}
    	waitForFrameAndSwitch(FRAME);
    	
    	driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("AWB withdrawn successfully"));
    	click(Generic_btn_ok);
    	
    	waitForFrameAndSwitch(FRAME);
    	
    	click(btn_search);
    	minWait();
    	 verifyElementPresent(chkbx_selectCheck);
    	 System.out.println("AWB withdrawn successfully");
    	
    	return this;
    }
    /**
     * 
     * @param invoicenumbr
     * @return
     */
    public CRA170 printinvoicesummary(String invoicenumbr){
    	
    	invoicenumbr=PropertyHandler.getPropValue(objFilepath, invoicenumbr);
		check(chkbx_selectCheck);
    	click(btn_print);
    	click(btn_printInvoiceSummary);
    	minWait();
    	driver.switchTo().defaultContent();
    	switchToSecondWindow();
    	  
    	closeAndmoveToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;	
    }
    /***
     * 
     * @param invoicenumbr
     * @return
     */
public CRA170 printinvoiceschedule(String invoicenumbr){
    	
    	invoicenumbr=PropertyHandler.getPropValue(objFilepath, invoicenumbr);
		check(chkbx_selectCheck);
    	click(btn_print);
    	click(btn_printInvoiceSchedule);
    	minWait();
    	driver.switchTo().defaultContent();
    	switchToSecondWindow();
    	  
    	closeAndmoveToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;	
    }
    /***
     * 
     * @param invoiceNumber
     * @param filtrType
     * @return
     */
    public CRA170 listwithvariousFiltr(String invoiceNumber,String filtrType){
    	
    	invoiceNumber=PropertyHandler.getPropValue(dataFilePath, invoiceNumber);
    	filtrType=PropertyHandler.getPropValue(dataFilePath, filtrType);
    	click(btn_clear);
    	minWait();
    	enterKeys(txt_invoicenum, invoiceNumber);
    	click(btn_invoicenumberlov);
    	 driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	check(chkbox_selectInvoice);
    	click(btn_OK);
    	switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	click(btn_list);
    	minWait();
		
    	selectByText(dropdown_attachmentTypeFltr, filtrType);
    	
    	click(btn_search);
    	minWait();
    	
    	 verifyElementPresent(chkbx_selectCheck);

    	      System.out.println("Details corrresponding to the filter is listed");
    	   
    	
    	
    	
    	return this;	
    }
    /***
     * 
     * @param invoiceNum
     * @param awbPrefix
     * @param AWB
     * @return
     */
    public CRA170 searchAWB(String invoiceNum,String awbPrefix,String AWB){
    	
    	invoiceNum=PropertyHandler.getPropValue(dataFilePath, invoiceNum);
    	awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWB=PropertyHandler.getPropValue(dataFilePath, AWB);
    	
    	
    	enterKeys(txt_invoicenum, invoiceNum);
    	click(btn_invoicenumberlov);
    	 driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	check(chkbox_selectInvoice);
    	click(btn_OK);
    	switchToFirstWindow();
    	
    	waitForFrameAndSwitch(FRAME);
    	click(btn_list);
    	minWait();
		
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_awb, AWB);
    	click(btn_search);
    	
    verifyElementPresent(chkbx_selectCheck);
       System.out.println("AWB present in the table is "+waitForElement(info_awbNumbr).getAttribute("value"));   
    Assert.assertTrue(waitForElement(info_awbNumbr).getAttribute("value").contains(AWB)) ;
    
  	 System.out.println("Details corrresponding to the filter is listed");
  	    
  	
		
    	return this;
    }
    public HomePage close() {

    click(btn_close);
    driver.switchTo().defaultContent();
    if (verifyElementPresent(yesBtn)) {

        click(yesBtn);
    }
    return new HomePage(driver, dataFileName);
}
    
    
    
  public CRA170 listResults(String clearancePeriod,String airlineCode,String invoiceNumber,String billingType){
	  
	  clearancePeriod=PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
	  airlineCode=PropertyHandler.getPropValue(dataFilePath, airlineCode);
	  invoiceNumber=PropertyHandler.getPropValue(dataFilePath, invoiceNumber);
	  billingType=PropertyHandler.getPropValue(dataFilePath, billingType);
	  
	  enterKeys(txt_clearanceperiod, clearancePeriod);
	  enterKeys(txt_airlineCode, airlineCode);
	  enterKeys(txt_invoicenum, invoiceNumber);
	  selectByText(dropdown_billingType, billingType);
	  
	  click(btn_list);
	  minWait();
	  minWait();
	  
	  return this;	
    }    
    
    
 public CRA170 verifyWithdrawButtonDisabled(){
	 
	 
	 Assert.assertEquals(waitForElementVisible(btn_withdraw).getAttribute("disabled"),"true"); 
	  return this;	
    }       
    
 public CRA170 verifyWithdrawButtonEnabled(){
	  
		
	 Assert.assertTrue(waitForElement(btn_withdraw).isEnabled(),"Error:withdraw button is disabled"); 
	  return this;	
    }       

    
 public CRA170 selectInvoiceAndWithDraw(){
	  
	 
		
	  check(chkbox_selectInvoice);
	  click(btn_withdraw);
	  driver.switchTo().defaultContent();
	  waitForElement(Generic_info_msg).getText().contains("AWB withdrawn successfully and the Invoice got deleted since it was the last AWB");
      click(Generic_btn_ok);
      waitForFrameAndSwitch(FRAME);
      
      click(btn_list);
      waitForElement(Generic_footer_error).getText().contains("No Records Found.");
      
	 
	 
	 
	 
	
	  return this;	
    }         
    
    
    
 public CRA170 selectInvoiceAndWithDrawOneAWB(String awb1,String awb2){
	 boolean flag=false; 
	 awb1=PropertyHandler.getPropValue(dataFilePath, awb1);
	 awb2=PropertyHandler.getPropValue(dataFilePath, awb2);	
	  
	 check(chkbox_selectInvoice);
	  click(btn_withdraw);
	  driver.switchTo().defaultContent();
	  waitForElement(Generic_info_msg).getText().contains("AWB withdrawn successfully");
      click(Generic_btn_ok);
      waitForFrameAndSwitch(FRAME);
     
      click(btn_list);
      check(chkbox_selectInvoice);
   
	  String AWBNumber=getTableCellValue(tbl_result,3,1);
	  if(AWBNumber.contains(awb2))
	  {
		flag=true;  
	  }


	Assert.assertTrue(flag,"displaying uncorrect awb");
	
	 
	
	  return this;	
   }           
    
    
    
 public CRA170 verifyAWB(String awb1){
	 
	  boolean flag=false; 
	  awb1=PropertyHandler.getPropValue(dataFilePath, awb1);
	  String AWBNumber=getTableCellValue(tbl_result,3,1);
	  if(AWBNumber.contains(awb1))
	  {
		flag=true;  
	  }
      Assert.assertTrue(flag,"displaying uncorrect awb");
	 
 
 
	  return this;
 }
 
 
 
 //to verify table doesn't contains null values
 
 public CRA170 verifyAWBDetailsContainsValue(){
	 
	
	
	  Assert.assertNotEquals(getTableCellValue(tbl_result,2,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,3,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,6,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,7,1),"");
      Assert.assertNotEquals(getTableCellValue(tbl_result,8,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,9,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,10,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,11,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,12,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,13,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,14,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,15,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,16,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,17,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,18,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,19,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,20,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,22,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,23,1),"");
	  Assert.assertNotEquals(getTableCellValue(tbl_result,24,1),"");
	  
	  
	  
	  return this;
} 

 
 
 public CRA170 verifyAWBPresentInColumn(String awb1){
	 awb1=PropertyHandler.getPropValue(dataFilePath, awb1);
	     boolean flag = true;
	 List<String> values = getTableColumnValues(tbl_result,3);
	    for(String value : values){
	    	value=value.trim();
	        if ((value.contains(awb1)))
	        {
	            flag = false;
	            break;
	        }
	        
	    }
	    Assert.assertFalse(flag,"The awb not present");
	 
	 return this;
}
 
 
 
 public CRA170 verifyTotalNetValueDisplayedIsCorrect() {
	 
	 String netValue1=getTableCellValue(tbl_result,20,1).replace(",","");	 
	 String netValue2=getTableCellValue(tbl_result,20,2).replace(",","");
	 double nV1=Double.parseDouble(netValue1); 
	 double nV2=Double.parseDouble(netValue2); 
	 double total=nV1+nV2;
	 String totalAmount=waitForElement(txt_totalAmount).getText().replace(",","");
	 double total2=Double.parseDouble(totalAmount); 
	 Assert.assertEquals(total, total2);
 
 
	 return this;
}
 
 
 
 public CRA170 selectInvoice(){
 
	 check(chkbox_selectInvoice); 
	 
	 return this;
 }
 
 
 
 public CRA055 clickListAccountDetails(){
	 
	click(btn_listAccountingEntries);
	minWait();
	return new CRA055(driver, dataFileName);
 }
 
 
 public CRA170 selectSecondInvoice(){
	 
	 check(getWebElements(chkbox_selectInvoice).get(1)); 
	 
	 return this;
 }
 
 
 
 
  

}
	