package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


/**
 * Screen CRA032
 * Created on 12/02/2018
 *
 * @author a-6836
 */
public class CRA032 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA032";
    public static String screenFrame = "iCargoContentFrameCRA032";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By text_shipmentPrefix,
    text_masterDocumentNumber,
    btn_btnList,
    tbl_billingEntries,
    yesBtn,
    chkbx_selectAWB,
    btn_changeBillingStatus,
    dropDown_selectStatus,
    btn_void,
    txt_remarks,
    btn_saveStatus,
   info_billingStatus,
    info_msg,
    btn_btnClose;
   
    public CRA032(WebDriver driver, String dataFileName) {
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
    	
    	yesBtn                    = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	text_masterDocumentNumber = MiscUtility.getWebElement(objFilepath,"CRA032_text_masterDocumentNumber");
    	btn_btnList               = MiscUtility.getWebElement(objFilepath,"CRA032_btn_btnList");
    	tbl_billingEntries        = MiscUtility.getWebElement(objFilepath,"CRA032_tbl_billingEntries");
    	btn_btnClose              = MiscUtility.getWebElement(objFilepath, "CRA032_btn_btnClose");
    	 
    	text_shipmentPrefix       = MiscUtility.getWebElement(objFilepath,"CRA032_text_shipmentPrefix");
    	chkbx_selectAWB           = MiscUtility.getWebElement(objFilepath, "CRA032_chkbx_selectAWB");
        btn_changeBillingStatus   = MiscUtility.getWebElement(objFilepath, "CRA032_btn_changeBillingStatus");
        dropDown_selectStatus     = MiscUtility.getWebElement(objFilepath, "CRA032_dropDown_selectStatus");
        txt_remarks               = MiscUtility.getWebElement(objFilepath, "CRA032_txt_remarks");
        btn_saveStatus            = MiscUtility.getWebElement(objFilepath, "CRA032_btn_saveStatus");
        btn_void                  = MiscUtility.getWebElement(objFilepath, "CRA032_btn_void");
        info_msg                  = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        info_billingStatus        = MiscUtility.getWebElement(objFilepath, "CRA032_info_billingStatus");
       
    }
    

    /***
     * 
     * @param prefix
     * @param awbno
     * @param BillingStatus
     * @param count
     * @param Charge
     * @param shipper_new
     * @return
     */

    
    public CRA032 VerifyCharges_Status(String prefix, String awbno, String BillingStatus){

    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	BillingStatus=PropertyHandler.getPropValue(dataFilePath, BillingStatus);
    


    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_masterDocumentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	
    	String fullAWB=prefix+" - "+awbno;
    	   
    		
    		String PP_FCharge=getTableCellValue(tbl_billingEntries, 20, 1).replace(",","");
    		System.out.println("PP_Freight Chgs:"+PP_FCharge);
    		
    		String PP_OCDC=getTableCellValue(tbl_billingEntries, 21, 1).replace(",","");
    		System.out.println("PP_OCDC:"+PP_OCDC);
    		
    		String PP_OCDA=getTableCellValue(tbl_billingEntries, 22, 1).replace(",","");
    		System.out.println("PP_OCDA:"+PP_OCDA);
    		
    	
    		
    		
    		System.out.println("--"+getTableColumnValues(tbl_billingEntries, 23)+"--");
    		
    		
    		String CC_OCDC=tblGetTextByColValue(tbl_billingEntries, 20, 5, "AWB");
    		System.out.println("CC_OCDC:"+CC_OCDC);
    		
    		/******************krishna**********************/
    		String td = ".//td[contains(text(),'AWB')]/following::td[14]";
    		String str = waitForElement(tbl_billingEntries).findElement(By.xpath(td)).getText();
    		/***************************************************/
    		System.out.println("------------"+str);
    		String CC_FCharge=tblGetTextByColValue(tbl_billingEntries, 19, 5, "AWB");//.replace(",","");
    		System.out.println("CC_Freight Chgs:"+CC_FCharge);
    		
    		String CC_OCDA=tblGetTextByColValue(tbl_billingEntries, 21, 5, "AWB");
    		System.out.println("CC_OCDA:"+CC_OCDA);
    		System.out.println(getTableCellValue(tbl_billingEntries, 5, 1).replace(",",""));
    	//	String Tax=tblGetTextByColValue(tbl_billingEntries, 23, 5, "AWB");

    		
    	//	System.out.println("Tax:"+Tax);
    		
    		
    		String Comm=tblGetTextByColValue(tbl_billingEntries, 24, 5, "AWB").replace(",","");
    		System.out.println("Commission:"+Comm);
    		String Discount=tblGetTextByColValue(tbl_billingEntries, 25, 5, "AWB").replace(",","");
    		
    		System.out.println("Discount:"+Discount);
    		String DueAirlineCharge=tblGetTextByColValue(tbl_billingEntries, 26, 5, "AWB").replace(",","");
    		//String DueAirlineCharge=tblGetTextByColValue(tbl_billingEntries, 29,  9, "AWB");
    		/*String DueAirlineCharge=getTableCellValue(tbl_billingEntries, 29, 1).replace(",","");*/
    		System.out.println("DueAirlineCharge:"+DueAirlineCharge);
    		
    	   	    int DA;
    			
    			int F = Integer.parseInt(PP_FCharge);
    			int OCDC = Integer.parseInt(PP_OCDC);
    			int OCDA = Integer.parseInt(CC_OCDA);
    		//	int T = Integer.parseInt(Tax);
    			int C = Integer.parseInt(Comm);
    			int Dis = Integer.parseInt(Discount);
    		//	DA=  F+OCDC-OCDA-C-Dis+T;
    			DA=  F+OCDC-OCDA-C-Dis;
    			String DueAirline=String.valueOf(DA);
    		    System.out.println("Due Airline calculated is:"+DueAirline);
    		    Assert.assertTrue(DueAirline.equals(DueAirlineCharge), "ERROR: AWB due airline charge doesnot match");
    		       		   
    		    String status=tblGetTextByColValue(tbl_billingEntries, 28, 5, "AWB");
        		System.out.println("Billing Status:"+status);
        		Assert.assertTrue(status.contains(BillingStatus),"ERROR: Billing status not matches");
        		
    		
    	return this;

    	    }  
    
    
    
    public CRA032 verifyTax(String prefix, String awbno,String taxper){
    	
    	
    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	taxper=PropertyHandler.getPropValue(dataFilePath, taxper);

    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_masterDocumentNumber, awbno);
    	click(btn_btnList);
    	minWait();	
    	
    	String tax=getTableCellValue(tbl_billingEntries, 23, 1);
		System.out.println("Tax:"+tax);
		
		String PP_FCharge=getTableCellValue(tbl_billingEntries, 20, 1);
		System.out.println("PP_Freight Chgs:"+PP_FCharge);
		
    	int fCharg=Integer.parseInt(PP_FCharge);
    	int taxPerTmp=Integer.parseInt(taxper);
    	int taxCurnt=Integer.parseInt(tax);
    	int tmpTax=fCharg*taxPerTmp;
    	Assert.assertEquals(taxCurnt, tmpTax);
    	
		return this;	
    }
    public CRA032 verifyDueAirlineCassBilling(String prefix, String awbno, String BillingStatus){
    	
    	
    	
    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	
    	BillingStatus= PropertyHandler.getPropValue(dataFilePath, BillingStatus);
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_masterDocumentNumber, awbno);
    	click(btn_btnList);
    	minWait();	
    	
    	
		String PP_FCharge=getTableCellValue(tbl_billingEntries, 20, 1).replace(",","");
		System.out.println("PP_Freight Chgs:"+PP_FCharge);
		
		String PP_OCDC=getTableCellValue(tbl_billingEntries, 21, 1).replace(",","");
		System.out.println("PP_OCDC:"+PP_OCDC);
		
		String Comm=getTableCellValue(tbl_billingEntries, 30, 1).replace(",","");
		System.out.println("Commission:"+Comm);
		
		String CC_OCDC=getTableCellValue(tbl_billingEntries, 24, 1).replace(",","");
		System.out.println("CC_OCDC:"+CC_OCDC);
		
		String Discount=getTableCellValue(tbl_billingEntries, 31, 1).replace(",","");
		System.out.println("Discount:"+Discount);
		
		
		String DueAirlineCharge=getTableCellValue(tbl_billingEntries, 32, 1).replace(",","");
		System.out.println("DueAirlineCharge:"+DueAirlineCharge);
		
		float DA;
		
		float F = Float.parseFloat(PP_FCharge);
		float OCDC = Float.parseFloat(PP_OCDC);
		float ccOCDC=Float.parseFloat(CC_OCDC);
		
		float C = Float.parseFloat(Comm);
		float Dis = Float.parseFloat(Discount);
		
    	DA=F+OCDC-ccOCDC-C-Dis;
        System.out.println("Calculated Value:"+DA);
       
    	String status=getTableCellValue(tbl_billingEntries, 34, 1);
		System.out.println("Billing Status:"+status);
		Assert.assertTrue(status.contains(BillingStatus),"ERROR: Billing status not matches");
		String DA1=String.valueOf(DA);
    	
    	Assert.assertTrue(DueAirlineCharge.contains(DA1), "Error:Incorrect DueAirline calculation");
    	
    	return this;
    }
    
    public CRA032 GetFreightCharge(String prefix, String awbno, String FreightCharge,String FChargeAddn){

    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
  
    


    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_masterDocumentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	
    	
    	
    		
    		String PP_FCharge=getTableCellValue(tbl_billingEntries, 20, 1).replace(",","");
    		System.out.println("PP_Freight Chgs:"+PP_FCharge);
    		PropertyHandler.setPropValue(dataFilePath, FreightCharge,PP_FCharge);
    		String FC=PP_FCharge.replace(",","");
    		int FreightChargeExtra;
    		int F = Integer.parseInt(FC);
    		FreightChargeExtra=F+1000;
    		String FChargeExtra=String.valueOf(FreightChargeExtra);
    		PropertyHandler.setPropValue(dataFilePath, FChargeAddn, FChargeExtra);
    		return this;
	
    		
    }
    
   
    public CRA032 CheckBillingstatus(String prefix, String awbno, String BillingStatus,int count,String Charge,String shipper_new) {

prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
BillingStatus = PropertyHandler.getPropValue(dataFilePath, BillingStatus);
Charge= PropertyHandler.getPropValue(dataFilePath, Charge);


enterKeys(text_shipmentPrefix, prefix);
enterKeys(text_masterDocumentNumber, awbno);
click(btn_btnList);
minWait();
int noofrows=getTableRowCount(tbl_billingEntries);
if(noofrows==count)
{
	System.out.println("No of rows are correct");
	String status=getTableCellValue(tbl_billingEntries, 28, 1);
	System.out.println("Billing Status:"+status);
	Assert.assertFalse(waitForElement(tbl_billingEntries).getAttribute("value").contains(BillingStatus),"ERROR: Billing status not matches");
	
	String cca=getTableCellValue(tbl_billingEntries, 5, 1);
	System.out.println("Billing Status:"+cca);
	Assert.assertFalse(waitForElement(tbl_billingEntries).getAttribute("value").equals("CCA"),"ERROR: CCA status not matches");
	
	if(Charge!=null){
	String charges=getTableCellValue(tbl_billingEntries, 27, 1);
	System.out.println("Billing Charges:"+charges);
	}
	Assert.assertFalse(waitForElement(tbl_billingEntries).getAttribute("value").contains(Charge),"ERROR: Billing charges not matches");
	String custname=getTableCellValue(tbl_billingEntries, 8, 1);
	System.out.println("Billing Customer:"+custname);
	Assert.assertFalse(waitForElement(tbl_billingEntries).getAttribute("value").contains(shipper_new),"ERROR: Billing customer not matches");
	
}

return this;

    }
  /***
   * 
   * @param prefix
   * @param awbno
   * @param BillingStatus
   * @return
   */

    
    public CRA032 verifyStatus(String prefix, String awbno, String BillingStatus) {

    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	BillingStatus = PropertyHandler.getPropValue(dataFilePath, BillingStatus);
    


    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_masterDocumentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	
    	
    	
    		
    		String status=tblGetTextByColValue(tbl_billingEntries, 28, 5, "AWB");
    		System.out.println("Billing Status:"+status);
    		Assert.assertTrue(status.equals(BillingStatus),"ERROR: Billing status not matches");
    		
    		
    	

    	return this;

    	    }  
    
    public CRA032 changeBillingStatus(String prefix, String awbno,String status){
    	
    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	status=PropertyHandler.getPropValue(dataFilePath, status);
		
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_masterDocumentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	
       check(chkbx_selectAWB);
       click(btn_changeBillingStatus);
       driver.switchTo().defaultContent();
       waitForNewWindow(2);
       switchToSecondWindow();
        minWait();
       
        selectByText(dropDown_selectStatus, status);
    	enterKeys(txt_remarks, "Remarks");
    	click(btn_saveStatus);
    	switchToFirstWindow();
    
    	waitForFrameAndSwitch(FRAME);
    	
    	minWait();
    	String tmpStatus=tblGetTextByColValue(tbl_billingEntries, 28, 5, "AWB");
    	System.out.println("Status"+tblGetTextByColValue(tbl_billingEntries, 28, 5, "AWB"));
		Assert.assertTrue(tmpStatus.equals(status),"ERROR: Billing status not matches");
		
    	return this;
    	
    }
    
    /**
     * For storing invoice number 
     * @param prefix
     * @param awbno
     * @return
     *A-6784**/
    
     public CRA032 stroreInvoiceNumber(String prefix, String awbno,String invoiceNumber)  {
    	 
    	 
    	 prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	 awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		  
    	 
    	 enterKeys(text_shipmentPrefix, prefix);
    	 enterKeys(text_masterDocumentNumber, awbno);
    	 click(btn_btnList);
    	 minWait();
    	 
    	 
    	 String invoiceno=getTableCellValue(tbl_billingEntries, 16, 1);
    	 System.out.println("Billing InvoiceNo:"+invoiceno);
    	 PropertyHandler.setPropValue(dataFilePath, invoiceNumber, invoiceno);
    	 
    	 return this; 
     }
    
     
    
      
     
     
   /**
    * 
    * @param prefix
    * @param awbno
    * @param BillingStatus
    * @param dueAirlineCharge
    * @return
    */
   public CRA032 shipmentVoid(String prefix, String awbno, String BillingStatus,String dueAirlineCharge) {
	
	   
	   prefix=PropertyHandler.getPropValue(dataFilePath, prefix);
	   awbno=PropertyHandler.getPropValue(dataFilePath, awbno);
	   BillingStatus=PropertyHandler.getPropValue(dataFilePath, BillingStatus);
	   
	   
	   
	   enterKeys(text_shipmentPrefix, prefix);
	   enterKeys(text_masterDocumentNumber, awbno);
	   click(btn_btnList);
	   minWait();

	   
	   check(chkbx_selectAWB);
	   
	   click(btn_void);
	   driver.switchTo().defaultContent();
	   Assert.assertTrue(getTableCellValue(tbl_billingEntries, 28, 1).contains(BillingStatus), "ERROR:Incorrect AWB Status");
		 
	   Assert.assertTrue(waitForElement(info_msg).getText().contains("The AWB will be made Void. Do you want to continue?"), "ERROR:Unable to make Void");
	   click(yesBtn);
	   waitForFrameAndSwitch(FRAME);
	   minWait();
	   click(btn_btnList);
	   minWait();
	   Assert.assertTrue(getTableCellValue(tbl_billingEntries, 6, 1).contains("VD"),"ERROR:speacial indicator not flagged");
	  dueAirlineCharge=getTableCellValue(tbl_billingEntries, 26, 1);
	  PropertyHandler.setPropValue(dataFilePath, dueAirlineCharge, dueAirlineCharge);
	  Assert.assertTrue(getTableCellValue(tbl_billingEntries, 5, 2).contains("CCA"),"ERROR:CCA not generated");
	  Assert.assertTrue(getTableCellValue(tbl_billingEntries, 27, 2).contains(dueAirlineCharge),"ERROR:Wrong CCA calculation");
	   return this;
	   
   }
     
     
     
     
     
     
     
     
     
   /***
    *  
    * @param prefix
    * @param awbno
    * @param BillingStatus
    * @param count
    * @param Charge
    * @param shipper_new
    * @return
    */
    
public CRA032 CheckBillingstatusAfterInvoice(String prefix, String awbno, String BillingStatus,int count,String Charge,String shipper_new) {

prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
BillingStatus = PropertyHandler.getPropValue(dataFilePath, BillingStatus);
Charge= PropertyHandler.getPropValue(dataFilePath, Charge);


enterKeys(text_shipmentPrefix, prefix);
enterKeys(text_masterDocumentNumber, awbno);
click(btn_btnList);
minWait();


String invoiceno=getTableCellValue(tbl_billingEntries, 12, 1);
System.out.println("Billing InvoiceNo:"+invoiceno);
while(invoiceno.trim().isEmpty())
{
	int noofrows=getTableRowCount(tbl_billingEntries);
	if(noofrows==count)
	{
		System.out.println("No of rows are correct");
		
		String status=getTableCellValue(tbl_billingEntries, 28, 1);
		System.out.println("Billing Status:"+status);
		Assert.assertFalse(waitForElement(tbl_billingEntries).getAttribute("value").contains(BillingStatus),"ERROR: Billing status not matches");
		String charges=getTableCellValue(tbl_billingEntries, 27, 1);
		System.out.println("Billing Charges:"+charges);
		Assert.assertFalse(waitForElement(tbl_billingEntries).getAttribute("value").contains(Charge),"ERROR: Billing charges not matches");
		String custname=getTableCellValue(tbl_billingEntries, 8, 1);
		System.out.println("Billing Customer:"+custname);
		Assert.assertFalse(waitForElement(tbl_billingEntries).getAttribute("value").contains(shipper_new),"ERROR: Billing customer not matches");
		
	}
	System.out.println("Invoice not generated successfully");
	break;
}


return this;


}

public CRA032 CheckBillingstatusAfterInvoice_CCAOutbndcase(String prefix, String awbno,int count,String shipper_new,String shipper_old,String BillingStatus ) {

prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

shipper_old=PropertyHandler.getPropValue(dataFilePath, shipper_old);
shipper_new=PropertyHandler.getPropValue(dataFilePath, shipper_new);
BillingStatus=PropertyHandler.getPropValue(dataFilePath, BillingStatus);

enterKeys(text_shipmentPrefix, prefix);
enterKeys(text_masterDocumentNumber, awbno);
click(btn_btnList);
minWait();


String invoiceno=getTableCellValue(tbl_billingEntries, 12, 1);
System.out.println("Billing InvoiceNo:"+invoiceno);

	int noofrows=getTableRowCount(tbl_billingEntries);
	if(noofrows==count)
	{
		System.out.println("No of rows are correct");
		
		tblSelectRowByMultipleColValue(tbl_billingEntries, 1, 9, 12, "CCA", shipper_new);
		tblSelectRowByMultipleColValue(tbl_billingEntries, 1, 9, 34, "CCA", BillingStatus);
		tblSelectRowByMultipleColValue(tbl_billingEntries, 1, 9, 12, "AWB", shipper_new);
		tblSelectRowByMultipleColValue(tbl_billingEntries, 1, 9, 34, "AWB", BillingStatus);
		tblSelectRowByMultipleColValue(tbl_billingEntries, 1, 9, 12, "CCA", shipper_old);
		tblSelectRowByMultipleColValue(tbl_billingEntries, 1, 12, 34, shipper_old, "Customer Billed");
	}

	

return this;


}

    public HomePage close() {

        click(btn_btnClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
