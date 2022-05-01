package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


/**
 * Screen OPR026 - CAPTURE AWB
 * Created on 21/12/2017
 *
 * @author a-7868
 */
public class CRA143 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA032";
    public static String screenFrame = "iCargoContentFrameCRA032";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By txt_shipmentPrefix,
    txt_masterDocumentNumber,
    btn_btnList,tbl_ImportBillingEntries,
    yesBtn,
    btn_btnChangeStatus,
   dropdown_ChangeStatus,
    btn_ChangeStatusSave,
    text_ChangeStatusremarks,
    txt_country,
    txt_fromDate,
    chkbx_selectAWB,
    txt_toDate,
    btn_btClose;
   
    public CRA143(WebDriver driver, String dataFileName) {
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
    	
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	txt_shipmentPrefix = MiscUtility.getWebElement(objFilepath,"CRA143_txt_shipmentPrefix");
    	txt_masterDocumentNumber = MiscUtility.getWebElement(objFilepath,"CRA143_txt_masterDocumentNumber");
    	btn_btnList = MiscUtility.getWebElement(objFilepath,"CRA143_btn_btnList");
    	btn_btClose = MiscUtility.getWebElement(objFilepath, "CRA143_btn_btClose");
    	 
    	tbl_ImportBillingEntries = MiscUtility.getWebElement(objFilepath,"CRA143_tbl_ImportBillingEntries");
       btn_btnChangeStatus=MiscUtility.getWebElement(objFilepath, "CRA143_btn_btnChangeStatus");
       dropdown_ChangeStatus=MiscUtility.getWebElement(objFilepath, "CRA143_dropdown_ChangeStatus");
       btn_ChangeStatusSave=MiscUtility.getWebElement(objFilepath, "CRA143_btn_ChangeStatusSave");
       text_ChangeStatusremarks=MiscUtility.getWebElement(objFilepath, "CRA143_text_ChangeStatusremarks");
      txt_country=MiscUtility.getWebElement(objFilepath, "CRA143_txt_country");
       txt_fromDate=MiscUtility.getWebElement(objFilepath, "CRA143_txt_fromDate");
      txt_toDate=MiscUtility.getWebElement(objFilepath, "CRA143_txt_toDate");
      chkbx_selectAWB=MiscUtility.getWebElement(objFilepath, "CRA143_chkbx_selectAWB");

    }
  
    
    
    
    
    public CRA143 changeStatus(String prefix, String awbno,String status ){
    	
    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	
    	
   
    	enterKeys(txt_shipmentPrefix, prefix);
    	enterKeys(txt_masterDocumentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	check(chkbx_selectAWB);
    	
    	click(btn_btnChangeStatus);
    	
    	minWait();
        driver.switchTo().defaultContent();
        waitForNewWindow(2);

        switchToSecondWindow();

    	selectByText(dropdown_ChangeStatus, status);
    	enterKeys(text_ChangeStatusremarks, "Remarks");
    	
    	click(btn_ChangeStatusSave);
    	minWait();
        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);
		
        
    	
    	
        return this;	
    	
    }
/***
 * 
 * @param prefix
 * @param awbno
 * @param count
 * @param shipper_new
 * @param shipper_old
 * @param BillingStatus
 * @return
 */
public CRA143 CheckBillingstatusAfterInvoice_CCAInbndcase(String prefix, String awbno,int count,String shipper_new,String shipper_old,String BillingStatus ) {

prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

shipper_old=PropertyHandler.getPropValue(dataFilePath, shipper_old);
shipper_new=PropertyHandler.getPropValue(dataFilePath, shipper_new);
BillingStatus=PropertyHandler.getPropValue(dataFilePath, BillingStatus);

enterKeys(txt_shipmentPrefix, prefix);
enterKeys(txt_masterDocumentNumber, awbno);
click(btn_btnList);
minWait();




	int noofrows=getTableRowCount(tbl_ImportBillingEntries);
	if(noofrows==count)
	{
		System.out.println("No of rows are correct");
		
		tblSelectRowByMultipleColValue(tbl_ImportBillingEntries, 1, 3, 7,shipper_new, "CCA");
		tblSelectRowByMultipleColValue(tbl_ImportBillingEntries, 1, 7, 24, "CCA", BillingStatus);
		tblSelectRowByMultipleColValue(tbl_ImportBillingEntries, 1, 3, 7, shipper_new, "AWB");
		tblSelectRowByMultipleColValue(tbl_ImportBillingEntries, 1, 7, 24, "CCA", BillingStatus);
		tblSelectRowByMultipleColValue(tbl_ImportBillingEntries, 1, 3, 7, shipper_old,"CCA");
		tblSelectRowByMultipleColValue(tbl_ImportBillingEntries, 1, 7, 24, shipper_old, "Customer Billed");
	}

	

return this;


}
/**
 * 
 * @param prefix
 * @param awbno
 * @param count
 * @param shipper_new
 * @param shipper_old
 * @param BillingStatus
 * @return
 */
public CRA143 CheckBillingstatusBeforeInvoice_WithCCA(String prefix, String awbno,int count,String shipper_new,String shipper_old,String BillingStatus ) {

prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

shipper_old=PropertyHandler.getPropValue(dataFilePath, shipper_old);
shipper_new=PropertyHandler.getPropValue(dataFilePath, shipper_new);
BillingStatus=PropertyHandler.getPropValue(dataFilePath, BillingStatus);

enterKeys(txt_shipmentPrefix, prefix);
enterKeys(txt_masterDocumentNumber, awbno);
click(btn_btnList);
minWait();




	int noofrows=getTableRowCount(tbl_ImportBillingEntries);
	if(noofrows==count)
	{
		System.out.println("No of rows are correct");
		
		tblSelectRowByMultipleColValue(tbl_ImportBillingEntries, 1, 3, 7,shipper_old, "CCA");
		tblSelectRowByMultipleColValue(tbl_ImportBillingEntries, 1, 7, 24, "CCA", BillingStatus);
		tblSelectRowByMultipleColValue(tbl_ImportBillingEntries, 1, 3, 7, shipper_old, "AWB");
		tblSelectRowByMultipleColValue(tbl_ImportBillingEntries, 1, 7, 24, "CCA", BillingStatus);
		
}

	

return this;


}

  public CRA143 checkCCAbilling(String prefix, String awbno,String BillingStatus,String CCAnum){
	  
	  prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
      awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
      BillingStatus = PropertyHandler.getPropValue(dataFilePath, BillingStatus);
      CCAnum=PropertyHandler.getPropValue(dataFilePath, CCAnum);
    		  
	  String tmpCCA=tblGetTextByColValue(tbl_ImportBillingEntries, 8, 6, awbno);
	
	  Assert.assertTrue(tmpCCA.equals(CCAnum));
	  Assert.assertTrue(getTableCellValue(tbl_ImportBillingEntries, 24, 1).contains(BillingStatus));
	  
	  return this; 
	  
  }

/*****
 * 
 * @param prefix
 * @param awbno
 * @param BillingStatus
 * @return
 */
  public CRA143 CheckBillingstatus(String prefix, String awbno,String BillingStatus ) {

         prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
         awbno = PropertyHandler.getPropValue(dataFilePath, awbno);


         BillingStatus=PropertyHandler.getPropValue(dataFilePath, BillingStatus);

         enterKeys(txt_shipmentPrefix, prefix);
        enterKeys(txt_masterDocumentNumber, awbno);
        click(btn_btnList);
         minWait();
   
		Assert.assertTrue(getTableCellValue(tbl_ImportBillingEntries, 24, 1).contains(BillingStatus));
		
	
return this;


}
  /***
   * 
   * @param prefix
   * @param awbno
   * @param inVoiceNum
   * @return
   */
  public CRA143 getInvoiceNum(String prefix, String awbno,String inVoiceNum){
	  
	  
	  prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
      awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

	  
	  
      enterKeys(txt_shipmentPrefix, prefix);
      enterKeys(txt_masterDocumentNumber, awbno);
      click(btn_btnList);
       minWait();
 
	  
	 String invoice=tblGetTextByColValue(tbl_ImportBillingEntries, 11, 6, awbno);
	 PropertyHandler.setPropValue(dataFilePath, inVoiceNum, invoice);
	
	 return this;
	  
  }


/**
 * 
 * @param prefix
 * @param awbno
 * @return
 */

public CRA143 CheckBillingstatusBeforeInvoice(String prefix, String awbno) {

prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
awbno = PropertyHandler.getPropValue(dataFilePath, awbno);




enterKeys(txt_shipmentPrefix, prefix);
enterKeys(txt_masterDocumentNumber, awbno);
click(btn_btnList);
minWait();

tblSelectRowByColValue(tbl_ImportBillingEntries, 1, 24, "Import -Billable");
	
String CC_FCharge=getTableCellValue(tbl_ImportBillingEntries, 15, 1).replace(",","");
System.out.println("CC_Freight Chgs:"+CC_FCharge);

String CC_OCDC=getTableCellValue(tbl_ImportBillingEntries, 17, 1).replace(",","");
System.out.println("CC_OCDC:"+CC_OCDC);

String CC_OCDA=getTableCellValue(tbl_ImportBillingEntries, 18, 1).replace(",","");
System.out.println("CC_OCDA:"+CC_OCDA);

String CC_F=getTableCellValue(tbl_ImportBillingEntries, 22, 1).replace(",","");
System.out.println("CC_Fee:"+CC_F);

String DueAirline=getTableCellValue(tbl_ImportBillingEntries, 23, 1).replace(",","");
System.out.println("Due Airline:"+DueAirline);

int DA;

int F = Integer.parseInt(CC_FCharge);
int OCDC = Integer.parseInt(CC_OCDC);
int OCDA = Integer.parseInt(CC_OCDA);
DA= F+OCDC+OCDA;
String DueAirlineCharge=String.valueOf(DA);
System.out.println("Due Airline calculated is:"+DueAirlineCharge);
Assert.assertTrue(DueAirlineCharge.contains(DueAirline), "ERROR: AWB due airline charge doesnot match");


return this;


}

/***
 * 
 * @param prefix
 * @param awbno
 * @param InvoiceNo
 * @return
 */

public CRA143 CheckBillingstatusAfterInvoice(String prefix, String awbno,String InvoiceNo) {

prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
awbno = PropertyHandler.getPropValue(dataFilePath, awbno);




enterKeys(txt_shipmentPrefix, prefix);
enterKeys(txt_masterDocumentNumber, awbno);
click(btn_btnList);
minWait();

tblSelectRowByColValue(tbl_ImportBillingEntries, 1, 24, "Import -Billed");

String Invoice=getTableCellValue(tbl_ImportBillingEntries, 11, 1).replace(",","");
System.out.println("Invoice no is:"+Invoice);
PropertyHandler.setPropValue(dataFilePath, InvoiceNo, Invoice);
	
String CC_FCharge=getTableCellValue(tbl_ImportBillingEntries, 15, 1).replace(",","");
System.out.println("CC_Freight Chgs:"+CC_FCharge);

String CC_OCDC=getTableCellValue(tbl_ImportBillingEntries, 17, 1).replace(",","");
System.out.println("CC_OCDC:"+CC_OCDC);

String CC_OCDA=getTableCellValue(tbl_ImportBillingEntries, 18, 1).replace(",","");
System.out.println("CC_OCDA:"+CC_OCDA);

String CC_F=getTableCellValue(tbl_ImportBillingEntries, 22, 1).replace(",","");
System.out.println("CC_Fee:"+CC_F);

String DueAirline=getTableCellValue(tbl_ImportBillingEntries, 23, 1).replace(",","");
System.out.println("Due Airline:"+DueAirline);

int DA;

int F = Integer.parseInt(CC_FCharge);
int OCDC = Integer.parseInt(CC_OCDC);
int OCDA = Integer.parseInt(CC_OCDA);
DA= F+OCDC+OCDA;
String DueAirlineCharge=String.valueOf(DA);
System.out.println("Due Airline calculated is:"+DueAirlineCharge);
Assert.assertFalse(DueAirlineCharge.contains(DueAirline), "ERROR: AWB due airline charge doesnot match");


return this;


}

    public HomePage close() {

        click(btn_btClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
