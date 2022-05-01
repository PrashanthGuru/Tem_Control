package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class CRA179 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA179";
    public static String screenFrame = "iCargoContentFrameCRA179";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By 
    info_error,
    dropdown_billingCode,
        yesBtn,noBtn,text_carriageTo,btn_btnClear,tbl_clearanceperiodlov,btn_btnCloseclearanceperiodlov,
    msg_popup,dropdown_invoiceType,text_carriageFrom,btn_btnAccDetails,info_invoiceStatus,
    btn_genericOk,text_awbOriginpopup,text_awbDestpopup,btn_btnSave,btn_clrperiodlov,
    info_genericMsg,okBtn,btn_btnOkpopup,btn_btnExceptions,btn_btnProcess,
    text_invNopopup,btn_btnListpopup,btn_addLink,btn_btnAWBDetails,btn_modifyLink,btn_ViewExceptionclose,
    btn_btnClose,text_invoiceNo,btn_btnList,chkbx_selectCheckBoxpopup,tbl_ViewExceptionexceptionDetails,
    text_awbPrefix,text_awbNumber,btn_invNolov,btn_close;
    
    
    
    
   
    public CRA179(WebDriver driver, String dataFileName) {
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

    	text_awbPrefix=MiscUtility.getWebElement(objFilepath, "CRA179_text_awbPrefix");
    	text_awbNumber=MiscUtility.getWebElement(objFilepath, "CRA179_text_awbNumber");
        btn_btnList=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnList");
        btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnClose");
        btn_btnClear=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnClear");
    	btn_invNolov=MiscUtility.getWebElement(objFilepath, "CRA179_btn_invNolov");
    	text_invNopopup=MiscUtility.getWebElement(objFilepath, "CRA179_text_invNopopup");
    	btn_btnListpopup=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnListpopup");
    	chkbx_selectCheckBoxpopup=MiscUtility.getWebElement(objFilepath, "CRA179_chkbx_selectCheckBoxpopup");
    	btn_btnOkpopup=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnOkpopup");
    	btn_addLink=MiscUtility.getWebElement(objFilepath,"CRA179_btn_addLink");
    	btn_modifyLink=MiscUtility.getWebElement(objFilepath,"CRA179_btn_modifyLink");
    	text_awbOriginpopup=MiscUtility.getWebElement(objFilepath, "CRA179_text_awbOriginpopup");
    	text_awbDestpopup=MiscUtility.getWebElement(objFilepath, "CRA179_text_awbDestpopup");
    	btn_close=MiscUtility.getWebElement(objFilepath, "CRA179_btn_close");
    	text_carriageFrom=MiscUtility.getWebElement(objFilepath, "CRA179_text_carriageFrom");
    	text_carriageTo=MiscUtility.getWebElement(objFilepath, "CRA179_text_carriageTo");
    	btn_btnClear=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnClear");
    	btn_btnAccDetails=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnAccDetails");
    	btn_btnAWBDetails=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnAWBDetails");
    	btn_btnExceptions=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnExceptions");
    	btn_btnProcess=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnProcess");
    	btn_btnSave=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnSave");
    	tbl_ViewExceptionexceptionDetails=MiscUtility.getWebElement(objFilepath, "CRA179_tbl_ViewExceptionexceptionDetails");
    	btn_ViewExceptionclose=MiscUtility.getWebElement(objFilepath, "CRA179_btn_ViewExceptionclose");
    	info_invoiceStatus=MiscUtility.getWebElement(objFilepath, "CRA179_info_invoiceStatus");
    	btn_clrperiodlov=MiscUtility.getWebElement(objFilepath, "CRA179_btn_clrperiodlov");
    	tbl_clearanceperiodlov=MiscUtility.getWebElement(objFilepath, "CRA179_tbl_clearanceperiodlov");
    	btn_btnCloseclearanceperiodlov=MiscUtility.getWebElement(objFilepath, "CRA179_btn_btnCloseclearanceperiodlov");
    	
    	
    	
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        msg_popup = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        okBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
      
         info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
         dropdown_invoiceType=MiscUtility.getWebElement(objFilepath, "CRA179_dropdown_invoiceType");
         dropdown_billingCode=MiscUtility.getWebElement(objFilepath, "CRA179_dropdown_billingCode");
         text_invoiceNo=MiscUtility.getWebElement(objFilepath, "CRA179_text_invoiceNo");
    }

    

    
 
public CRA179  VerifyAWBDetails(String InvoiceNo,String awbPrefix,String awbNum,String origin,String destination){


	InvoiceNo = PropertyHandler.getPropValue(dataFilePath,InvoiceNo);

awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
awbNum=PropertyHandler.getPropValue(dataFilePath, awbNum);
origin=PropertyHandler.getPropValue(dataFilePath, origin);
destination=PropertyHandler.getPropValue(dataFilePath, destination);

click(btn_invNolov);
minWait();
switchToSecondWindow();
waitForNewWindow(2);
enterKeys(text_invNopopup, InvoiceNo);
click(btn_btnListpopup);
minWait();
check(chkbx_selectCheckBoxpopup);
click(btn_btnOkpopup);

switchToFirstWindow();
waitForFrameAndSwitch(FRAME);

click(btn_btnList);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);
waitForFrameAndSwitch(FRAME);

waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_awbPrefix, awbPrefix);
enterKeys(text_awbNumber, "1234567890");
enterKeys(text_awbNumber, "1234567890" +Keys.TAB);
minWait();
driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(info_genericMsg).getText().contains("Non standard AWB. Do you want to capture?"),"Error: No error shown");
click(yesBtn);
waitForNewWindow(2);
switchToSecondWindow();

enterKeys(text_awbPrefix, awbPrefix);
enterKeys(text_awbNumber, awbNum);
enterKeys(text_awbNumber, awbNum +Keys.TAB);

minWait();
Assert.assertTrue(waitForElement(text_awbOriginpopup).getAttribute("value").contains(origin));
Assert.assertTrue(waitForElement(text_awbDestpopup).getAttribute("value").contains(destination));
Assert.assertTrue(waitForElement(text_carriageFrom).getAttribute("value").contains(origin));
Assert.assertTrue(waitForElement(text_carriageTo).getAttribute("value").contains(destination));
click(btn_btnClose);

minWait();
driver.switchTo().defaultContent();
click(yesBtn);
waitForFrameAndSwitch(FRAME);

return this;
}

public CRA179  GetClearancePeriod(String InvoiceNo,String Frmdate,String Todate ){


	InvoiceNo = PropertyHandler.getPropValue(dataFilePath,InvoiceNo);




click(btn_invNolov);
minWait();
switchToSecondWindow();
waitForNewWindow(2);
enterKeys(text_invNopopup, InvoiceNo);
click(btn_btnListpopup);
minWait();
check(chkbx_selectCheckBoxpopup);
click(btn_btnOkpopup);

switchToFirstWindow();
waitForFrameAndSwitch(FRAME);
click(btn_clrperiodlov);
minWait();
switchToSecondWindow();
waitForNewWindow(2);
String frmdate=getTableCellValue(tbl_clearanceperiodlov, 3, 1);
System.out.println("Ciearance from date"+frmdate);
PropertyHandler.setPropValue(dataFilePath, Frmdate, frmdate);
String todate= getTableCellValue(tbl_clearanceperiodlov, 4, 1);
System.out.println("Ciearance to date"+todate);
PropertyHandler.setPropValue(dataFilePath, Todate, todate);
click(btn_btnCloseclearanceperiodlov);
switchToFirstWindow();
waitForFrameAndSwitch(FRAME);
return this;
}

public CRA179  VerifyButton_Unbalanced(String InvoiceNo,String awbPrefix,String awbNum,String origin,String destination){


	InvoiceNo = PropertyHandler.getPropValue(dataFilePath,InvoiceNo);

awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
awbNum=PropertyHandler.getPropValue(dataFilePath, awbNum);
origin=PropertyHandler.getPropValue(dataFilePath, origin);
destination=PropertyHandler.getPropValue(dataFilePath, destination);

click(btn_invNolov);
minWait();
switchToSecondWindow();
waitForNewWindow(2);
enterKeys(text_invNopopup, InvoiceNo);
click(btn_btnListpopup);
minWait();
check(chkbx_selectCheckBoxpopup);
click(btn_btnOkpopup);

switchToFirstWindow();
waitForFrameAndSwitch(FRAME);


click(btn_btnList);
minWait();
Assert.assertTrue(waitForElement(btn_btnList).isEnabled(),"Error:Button is disabled");
Assert.assertTrue(waitForElement(btn_btnClose).isEnabled(),"Error:Button is disabled");
Assert.assertTrue(waitForElement(btn_btnClear).isEnabled(),"Error:Button is disabled");
Assert.assertTrue(waitForElement(btn_btnAccDetails).isEnabled(),"Error:Button is disabled");
Assert.assertTrue(waitForElement(btn_btnAWBDetails).isEnabled(),"Error:Button is disabled");
Assert.assertFalse(waitForElement(btn_btnExceptions).isEnabled(),"Error: Button is enabled");
Assert.assertFalse(waitForElement(btn_btnProcess).isEnabled(),"Error: Button is enabled");
Assert.assertTrue(waitForElement(btn_btnSave).isEnabled(),"Error:Button is disabled");
return this;
}


public CRA179  VerifyButton_Unbalanced1(String InvoiceNo,String awbPrefix,String awbNum,String origin,String destination){


	InvoiceNo = PropertyHandler.getPropValue(dataFilePath,InvoiceNo);

awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
awbNum=PropertyHandler.getPropValue(dataFilePath, awbNum);
origin=PropertyHandler.getPropValue(dataFilePath, origin);
destination=PropertyHandler.getPropValue(dataFilePath, destination);

click(btn_invNolov);
minWait();
switchToSecondWindow();
waitForNewWindow(2);
enterKeys(text_invNopopup, InvoiceNo);
click(btn_btnListpopup);
minWait();
check(chkbx_selectCheckBoxpopup);
click(btn_btnOkpopup);
switchToFirstWindow();
waitForFrameAndSwitch(FRAME);
click(btn_btnList);
minWait();
//click()
return this;
}
public CRA179  VerifyButton_balanced(String InvoiceNo,String awbPrefix,String awbNum,String origin,String destination){


	InvoiceNo = PropertyHandler.getPropValue(dataFilePath,InvoiceNo);

awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
awbNum=PropertyHandler.getPropValue(dataFilePath, awbNum);
origin=PropertyHandler.getPropValue(dataFilePath, origin);
destination=PropertyHandler.getPropValue(dataFilePath, destination);

click(btn_invNolov);
minWait();
switchToSecondWindow();
waitForNewWindow(2);
enterKeys(text_invNopopup, InvoiceNo);
click(btn_btnListpopup);
minWait();
check(chkbx_selectCheckBoxpopup);
click(btn_btnOkpopup);

switchToFirstWindow();
waitForFrameAndSwitch(FRAME);

click(btn_btnList);
minWait();
Assert.assertTrue(waitForElement(btn_btnList).isEnabled(),"Error:Button is disabled");
Assert.assertTrue(waitForElement(btn_btnClose).isEnabled(),"Error:Button is disabled");
Assert.assertTrue(waitForElement(btn_btnClear).isEnabled(),"Error:Button is disabled");
Assert.assertTrue(waitForElement(btn_btnAccDetails).isEnabled(),"Error:Button is disabled");
Assert.assertTrue(waitForElement(btn_btnAWBDetails).isEnabled(),"Error:Button is disabled");
Assert.assertFalse(waitForElement(btn_btnExceptions).isEnabled(),"Error: Button is enabled");
Assert.assertTrue(waitForElement(btn_btnProcess).isEnabled(),"Error:Button is disabled");
Assert.assertTrue(waitForElement(btn_btnSave).isEnabled(),"Error:Button is disabled");
return this;
}
public CRA179  Verify_Expection(String InvoiceNo,String ExceptionValue){


	InvoiceNo = PropertyHandler.getPropValue(dataFilePath,InvoiceNo);

	ExceptionValue= PropertyHandler.getPropValue(dataFilePath,ExceptionValue);

click(btn_invNolov);
minWait();
switchToSecondWindow();
waitForNewWindow(2);
enterKeys(text_invNopopup, InvoiceNo);
click(btn_btnListpopup);
minWait();
check(chkbx_selectCheckBoxpopup);
click(btn_btnOkpopup);

switchToFirstWindow();
waitForFrameAndSwitch(FRAME);

click(btn_btnList);
minWait();

click(btn_btnExceptions);
minWait();
tblSelectRowByColValue(tbl_ViewExceptionexceptionDetails, 1, 4, ExceptionValue);
click(btn_ViewExceptionclose);



return this;
}


public CRA179 VerifyButtons(){
	Assert.assertTrue(waitForElement(btn_btnList).isEnabled(),"Error:Button is disabled");
	Assert.assertTrue(waitForElement(btn_btnClose).isEnabled(),"Error:Button is disabled");
	Assert.assertTrue(waitForElement(btn_btnClear).isEnabled(),"Error:Button is disabled");
	Assert.assertFalse(waitForElement(btn_btnAccDetails).isEnabled(),"Error: Button is enabled");
	Assert.assertFalse(waitForElement(btn_btnAWBDetails).isEnabled(),"Error: Button is enabled");
	Assert.assertFalse(waitForElement(btn_btnExceptions).isEnabled(),"Error: Button is enabled");
	Assert.assertFalse(waitForElement(btn_btnProcess).isEnabled(),"Error: Button is enabled");
	Assert.assertFalse(waitForElement(btn_btnSave).isEnabled(),"Error: Button is enabled");
	return this;
}

public CRA179 MandatoryFieldsCheck(){
	click(btn_btnList);
	minWait();
	Assert.assertTrue(waitForElement(info_error).getText().contains("Clearance Period is mandatory."));
	Assert.assertTrue(waitForElement(info_error).getText().contains("Airline Code or Airline Number is mandatory."));
	Assert.assertTrue(waitForElement(info_error).getText().contains("Invoice Number is mandatory."));
	Assert.assertTrue(waitForElement(info_error).getText().contains("Invoice Type is mandatory."));
	Assert.assertTrue(waitForElement(dropdown_invoiceType).getText().contains("Credit Note"));
	Assert.assertTrue(waitForElement(dropdown_invoiceType).getText().contains("Invoice"));
	Assert.assertTrue(waitForElement(dropdown_billingCode).getText().contains("Billing Memo"));
	Assert.assertTrue(waitForElement(dropdown_billingCode).getText().contains("Collect AirWaybill"));
	Assert.assertTrue(waitForElement(dropdown_billingCode).getText().contains("Credit Memo"));
	Assert.assertTrue(waitForElement(dropdown_billingCode).getText().contains("Prepaid AirWaybill"));
	Assert.assertTrue(waitForElement(dropdown_billingCode).getText().contains("Rejection Memo"));
	
	
	return this;
	

	

}

public CRA179  Verify_Status(String InvoiceNo,String status){


	InvoiceNo = PropertyHandler.getPropValue(dataFilePath,InvoiceNo);

	status=PropertyHandler.getPropValue(dataFilePath, status);

click(btn_invNolov);
minWait();
switchToSecondWindow();
waitForNewWindow(2);
enterKeys(text_invNopopup, InvoiceNo);
click(btn_btnListpopup);
minWait();
check(chkbx_selectCheckBoxpopup);
click(btn_btnOkpopup);

switchToFirstWindow();
waitForFrameAndSwitch(FRAME);

click(btn_btnList);
minWait();

String status1=waitForElement(info_invoiceStatus).getText();

Assert.assertTrue(status1.contains(status));

return this;
}

public CRA179  Create_ProcessedWithErrorStatus(String InvoiceNo){
	
InvoiceNo = PropertyHandler.getPropValue(dataFilePath,InvoiceNo);
click(btn_invNolov);
minWait();
switchToSecondWindow();
waitForNewWindow(2);
enterKeys(text_invNopopup, InvoiceNo);
click(btn_btnListpopup);
minWait();
check(chkbx_selectCheckBoxpopup);
click(btn_btnOkpopup);

switchToFirstWindow();
waitForFrameAndSwitch(FRAME);

click(btn_btnList);

click(btn_btnProcess);
minWait();
Assert.assertTrue(waitForElement(info_invoiceStatus).getText().contains("Processed with error"),"Error: The status is not correct");
return this;

}
/**
 *
 * @param prefix
 * @param awbno
 * @param shipper_new
 * @param CCANo
 * @param accept
 * @param UpdateAWBAgentCheck
 * @return
 */

    public CRA179 CCAChangeOutboundCustomer(String prefix, String awbno,String shipper_new,String CCANo,boolean accept,boolean UpdateAWBAgentCheck) {

    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		return this;




    	//enterKeys(text_shipmentPrefix, prefix);
    	//enterKeys(text_documentNumber, awbno);}
    }



	public CRA181 listAndViewExceptionDetails(String invNo) {

    	invNo = PropertyHandler.getPropValue(dataFilePath,invNo);

		click(btn_invNolov);
		minWait();
		switchToSecondWindow();
		waitForNewWindow(2);
		enterKeys(text_invNopopup, invNo);
		click(btn_btnListpopup);
		minWait();
		check(chkbx_selectCheckBoxpopup);
		click(btn_btnOkpopup);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		click(btn_btnList);

		click(btn_btnExceptions);

    	return new CRA181(driver,dataFileName);
	}


    public HomePage close() {


        click(btn_close);



        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
