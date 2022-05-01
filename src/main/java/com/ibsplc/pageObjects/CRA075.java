package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class CRA075 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA075";
    public static String screenFrame = "iCargoContentFrameCRA075";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By text_shipmentPrefix,
    text_documentNumber,
    btn_btnList,
    dropdown_revisedFrtChgPayType,
    btn_btSave,
    btn_btAccept,
    check_CCApopupselect,
    btn_CCApopupbtnOk,
    btn_btClose,
    text_ccaRefNumber,
    btn_customerlov,
    yesBtn,
    noBtn,
    msg_popup,
    btn_genericOk,
    info_genericMsg,
    okBtn,
    text_customerlovcode,
    btn_customerlovList,
    chkbox_customerlovselectCheckBox,
    btn_customerlovbtnOk,
    info_error,
    div_CCAStatus,
    text_revisedOutboundCusCode,
    btn_customerlovbtnClear,
    chkbox_UpdateAWBAgentCheck,
    text_revisedWeightCharge,
    text_revisedDiscount,
    text_revisedTax,
    text_revisedValuationCharge,
    text_revisedOriginCode,
    text_revisedDestinationCode,
    btn_customerlovInbound,
    text_revisedOcdc,
    text_revisedInboundCusCode,
    text_OtherCharrgerevisedOcda,
    lnk_otherChargeLink,
    div_totalOtherCharge,
    text_OtherChargesrevisedOtherCharge,
    btn_OtherChargesbtOk,
    tbl_OtherChargesdueCarrierTd,
    tbl_OtherChargesdueAgentTd,
    lnk_OtherChargeslnkAdd,
    lnk_OtherChargeslnkDelete,
    chkbox_OtherChargesdueCarrierCheck,
    chkbox_OtherChargesdueAgentObjCheck,
    tbl_otherChargesTableBody,
    btn_chargeHeadlov,
    btn_ChargeHeadpopupbtList,
    text_ChargeHeadpopupchargeHeadCode,
    chkbox_ChargeHeadpopupchargeheadcode,
    btn_ChargeHeadpopupbtnOk,
    text_revisedPieces,
    text_revisedCommodityCode,
    lov_productlov,
    check_ProductpopupproductChecked,
    btn_Productpopupbtok,
    btn_ProductpopupshipmAndDimsLink,
    text_ShipDimpopupdimCommodities,
    text_ShipDimpopupdimPieces,
    text_ShipDimpopupdimWeight,
    text_ShipDimpopupdimLength,
    text_ShipDimpopupdimWidth,
    text_ShipDimpopupdimHeight,
    btn_ShipDimpopupbtnCalculate,
     txt_IATAchargeRevised,
    txt_remarks,
    check_reason;
    
   
    public CRA075(WebDriver driver, String dataFileName) {
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

    	text_shipmentPrefix = MiscUtility.getWebElement(objFilepath, "CRA075_text_shipmentPrefix");
    	text_documentNumber = MiscUtility.getWebElement(objFilepath, "CRA075_text_documentNumber");
    	btn_btnList = MiscUtility.getWebElement(objFilepath, "CRA075_btn_btnList");
    	dropdown_revisedFrtChgPayType = MiscUtility.getWebElement(objFilepath, "CRA075_dropdown_revisedFrtChgPayType");
    	btn_btSave = MiscUtility.getWebElement(objFilepath, "CRA075_btn_btSave");
    	btn_btAccept= MiscUtility.getWebElement(objFilepath, "CRA075_btn_btAccept");
    	check_CCApopupselect= MiscUtility.getWebElement(objFilepath, "CRA075_check_CCApopupselect");
    	btn_CCApopupbtnOk= MiscUtility.getWebElement(objFilepath, "CRA075_btn_CCApopupbtnOk");
    	btn_btClose= MiscUtility.getWebElement(objFilepath, "CRA075_btn_btClose");
    	text_ccaRefNumber= MiscUtility.getWebElement(objFilepath, "CRA075_text_ccaRefNumber");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        msg_popup = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        okBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        btn_customerlov= MiscUtility.getWebElement(objFilepath, "CRA075_btn_customerlov");
        text_customerlovcode= MiscUtility.getWebElement(objFilepath, "CRA075customerlovpopup_text_code");
        btn_customerlovList= MiscUtility.getWebElement(objFilepath, "CRA075customerlovpopup_btn_list");
        chkbox_customerlovselectCheckBox= MiscUtility.getWebElement(objFilepath, "CRA075customerlovpopup_chkbox_selectCheckBox");
        btn_customerlovbtnOk= MiscUtility.getWebElement(objFilepath, "CRA075customerlovpopup_btn_btnOk");
        div_CCAStatus= MiscUtility.getWebElement(objFilepath, "CRA075_div_CCAStatus");
        text_revisedOutboundCusCode= MiscUtility.getWebElement(objFilepath, "CRA075_text_revisedOutboundCusCode");
        btn_customerlovbtnClear= MiscUtility.getWebElement(objFilepath, "CRA075customerlovpopup_btn_btnClear");
        chkbox_UpdateAWBAgentCheck=MiscUtility.getWebElement(objFilepath, "CRA075_check_UpdateAWBAgentCheckCCApopupselect");
        text_revisedWeightCharge=MiscUtility.getWebElement(objFilepath, "CRA075_text_revisedWeightCharge");
        text_revisedDiscount=MiscUtility.getWebElement(objFilepath, "CRA075_text_revisedDiscount");
        text_revisedTax=MiscUtility.getWebElement(objFilepath, "CRA075_text_revisedTax");
        text_revisedValuationCharge=MiscUtility.getWebElement(objFilepath, "CRA075_text_revisedValuationCharge");
        text_revisedOriginCode=MiscUtility.getWebElement(objFilepath, "CRA075_text_revisedOriginCode");
        text_revisedDestinationCode=MiscUtility.getWebElement(objFilepath, "CRA075_text_revisedDestinationCode");
        btn_customerlovInbound=MiscUtility.getWebElement(objFilepath, "CRA075_btn_customerlovInbound");
        text_revisedInboundCusCode=MiscUtility.getWebElement(objFilepath, "CRA075_text_revisedInboundCusCode");
        info_error=MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        lnk_otherChargeLink=MiscUtility.getWebElement(objFilepath, "CRA075_lnk_otherChargeLink");
        text_OtherChargesrevisedOtherCharge=MiscUtility.getWebElement(objFilepath, "CRA075OtherCharges_text_revisedOtherCharge");
      btn_OtherChargesbtOk=MiscUtility.getWebElement(objFilepath, "CRA075OtherCharges_btn_btOk");
        tbl_OtherChargesdueCarrierTd=MiscUtility.getWebElement(objFilepath, "CRA075OtherCharges_tbl_dueCarrierTd");
      tbl_OtherChargesdueAgentTd=MiscUtility.getWebElement(objFilepath, "CRA075OtherCharge_tbl_dueAgentTd");
        lnk_OtherChargeslnkAdd=MiscUtility.getWebElement(objFilepath, "CRA075OtherCharge_lnk_lnkAdd");
     lnk_OtherChargeslnkDelete=MiscUtility.getWebElement(objFilepath, "CRA075OtherCharge_lnk_lnkDelete");
   chkbox_OtherChargesdueCarrierCheck=MiscUtility.getWebElement(objFilepath, "CRA075OtherCharge_chkbox_dueCarrierCheck");
    chkbox_OtherChargesdueAgentObjCheck=MiscUtility.getWebElement(objFilepath, "CRA075OtherCharge_chkbox_dueAgentObjCheck");
    text_OtherCharrgerevisedOcda=MiscUtility.getWebElement(objFilepath, "CRA075OtherCharge_text_revisedOcda");
    	    text_revisedOcdc=MiscUtility.getWebElement(objFilepath, "CRA075OtherCharge_text_revisedOcdc");
   div_totalOtherCharge=MiscUtility.getWebElement(objFilepath, "CRA075_div_totalOtherCharge");
   tbl_otherChargesTableBody=MiscUtility.getWebElement(objFilepath, "CRA075_tbl_otherChargesTableBody");
   btn_chargeHeadlov=MiscUtility.getWebElement(objFilepath, "CRA075_btn_chargeHeadlov");
  btn_ChargeHeadpopupbtList=MiscUtility.getWebElement(objFilepath, "CRA075ChargeHeadpopup_btn_btList");
   text_ChargeHeadpopupchargeHeadCode=MiscUtility.getWebElement(objFilepath, "CRA075ChargeHeadpopup_text_chargeHeadCode");
  chkbox_ChargeHeadpopupchargeheadcode=MiscUtility.getWebElement(objFilepath, "CRA075ChargeHeadpopup_chkbox_chargeheadcode");
   btn_ChargeHeadpopupbtnOk=MiscUtility.getWebElement(objFilepath, "CRA075ChargeHeadpopup_btn_btnOk");
   text_revisedPieces=MiscUtility.getWebElement(objFilepath, "CRA075_text_revisedPieces");
   text_revisedCommodityCode=MiscUtility.getWebElement(objFilepath, "CRA075_text_revisedCommodityCode");
   lov_productlov=MiscUtility.getWebElement(objFilepath, "CRA075_lov_productlov");
   check_ProductpopupproductChecked=MiscUtility.getWebElement(objFilepath, "CRA075Productpopup_check_productChecked");
   btn_Productpopupbtok=MiscUtility.getWebElement(objFilepath, "CRA075Productpopup_btn_btok");
   btn_ProductpopupshipmAndDimsLink=MiscUtility.getWebElement(objFilepath, "CRA075_btn_shipmAndDimsLink");
   text_ShipDimpopupdimCommodities=MiscUtility.getWebElement(objFilepath, "CRA075ShipDimpopup_text_dimCommodities");
   text_ShipDimpopupdimPieces=MiscUtility.getWebElement(objFilepath, "CRA075ShipDimpopup_text_dimPieces");
   text_ShipDimpopupdimWeight=MiscUtility.getWebElement(objFilepath, "CRA075ShipDimpopup_text_dimWeight");
   text_ShipDimpopupdimLength=MiscUtility.getWebElement(objFilepath, "CRA075ShipDimpopup_text_dimLength");
   text_ShipDimpopupdimWidth=MiscUtility.getWebElement(objFilepath, "CRA075ShipDimpopup_text_dimWidth");
   text_ShipDimpopupdimHeight=MiscUtility.getWebElement(objFilepath, "CRA075ShipDimpopup_text_dimHeight");
   btn_ShipDimpopupbtnCalculate=MiscUtility.getWebElement(objFilepath, "CRA075ShipDimpopup_btn_btnCalculate");
   check_reason=MiscUtility.getWebElement(objFilepath, "CRA075_check_reason");
   txt_remarks=MiscUtility.getWebElement(objFilepath, "CRA075_txt_remarks");
   txt_IATAchargeRevised=MiscUtility.getWebElement(objFilepath, "CRA075_txt_IATAchargeRevised");

    }

    
    /***
     * 
     * @param prefix
     * @param awbno
     * @param Revisedvalue
     * @param shipper
     * @param CCANo
     * @param accept
     * @return
     */
    
    
 
    public CRA075 ApproveCCA(String prefix, String awbno, String Revisedvalue,String shipper,String CCANo,boolean accept,boolean newcca) {


prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
Revisedvalue = PropertyHandler.getPropValue(dataFilePath, Revisedvalue);

shipper=PropertyHandler.getPropValue(dataFilePath, shipper);

enterKeys(text_shipmentPrefix, prefix);
enterKeys(text_documentNumber, awbno);
click(btn_btnList);
minWait();
selectByText(dropdown_revisedFrtChgPayType, Revisedvalue);
click(btn_customerlov);
minWait();
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_customerlovcode,shipper);
click(btn_customerlovList);
minWait(); 
check(chkbox_customerlovselectCheckBox);
click(btn_customerlovbtnOk);
minWait();
waitForFrameAndSwitch(FRAME);
click(btn_btSave);
minWait();
driver.switchTo().defaultContent();
click(okBtn);
waitForFrameAndSwitch(FRAME);
enterKeys(text_shipmentPrefix, prefix);
enterKeys(text_documentNumber, awbno);
click(btn_btnList);
minWait();
waitForNewWindow(2);
switchToSecondWindow();
check(check_CCApopupselect);
click(btn_CCApopupbtnOk);
waitForFrameAndSwitch(FRAME);
String CCANo1=waitForElement(text_ccaRefNumber).getAttribute("value");
System.out.println("CCA No:"+CCANo1);
PropertyHandler.setPropValue(dataFilePath, CCANo, CCANo1);
CCANo=PropertyHandler.getPropValue(dataFilePath, CCANo);
Assert.assertFalse(waitForElement(dropdown_revisedFrtChgPayType).getAttribute("value").contains(Revisedvalue),"ERROR: CCA not saved successfully");
if(newcca)
{
if(accept)
{
click(btn_btAccept);
minWait();
driver.switchTo().defaultContent();
click(okBtn);
waitForFrameAndSwitch(FRAME);
Assert.assertFalse(waitForElement(div_CCAStatus).getText().contains("Approved"),"ERROR: CCA not Approved");
}
else
{
	Assert.assertFalse(waitForElement(div_CCAStatus).getText().contains("Approved"),"ERROR: CCA not Approved");
}
}
return this;
}
    /***
     * 
     * @param prefix
     * @param awbno
     * @param CCANum
     * @return
     */
    public CRA075 relistApprove(String prefix, String awbno,String CCANum){
    	
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(check_CCApopupselect);
    	click(btn_CCApopupbtnOk);
    	waitForFrameAndSwitch(FRAME);
    	String CCANo1=waitForElement(text_ccaRefNumber).getAttribute("value");
    	System.out.println("CCA No:"+CCANo1);
    	PropertyHandler.setPropValue(dataFilePath, CCANum, CCANo1);
    	

    	click(btn_btAccept);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(okBtn);
    	waitForFrameAndSwitch(FRAME);
		

    	
    	return this;
    	
    }
    
    
    /***
     * 
     * @param prefix
     * @param awbno
     * @return
     */
    public CRA075 approveCCA_ErrorChecking(String prefix, String awbno){
    	
    	
    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
		
    	minWait();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(check_CCApopupselect);
    	click(btn_CCApopupbtnOk);
    	waitForFrameAndSwitch(FRAME);

    	click(btn_btAccept);
    	minWait();
    	
    	minWait();
    	Assert.assertTrue(waitForElement(info_error).getText().contains("error"));
	return this;
   
 
    }
/**
 * 
 * @param prefix
 * @param awbno
 * @param Revisedvalue
 * @param shipper_new
 * @param CCANo
 * @param accept
 * @param UpdateAWBAgentCheck
 * @return
 */
    
    public CRA075 CCAChangeOutboundCustomer(String prefix, String awbno,String shipper_new,String CCANo,boolean accept,boolean UpdateAWBAgentCheck) {

    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	

    	

    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	if(UpdateAWBAgentCheck)
    	{
    		check(chkbox_UpdateAWBAgentCheck);
    	}
    	click(btn_customerlov);
    	minWait();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	click(btn_customerlovbtnClear);
    	minWait();
    	click(btn_customerlovList);
    	minWait();
    	
    	check(chkbox_customerlovselectCheckBox);
    	click(btn_customerlovbtnOk);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	String custname=waitForElement(text_revisedOutboundCusCode).getAttribute("value");
    	System.out.println("New Outbound Customer"+custname);
    	PropertyHandler.setPropValue(dataFilePath, shipper_new, custname);
    	shipper_new=PropertyHandler.getPropValue(dataFilePath, shipper_new);
    	
    	click(btn_btSave);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(okBtn);
    	waitForFrameAndSwitch(FRAME);
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(check_CCApopupselect);
    	click(btn_CCApopupbtnOk);
    	waitForFrameAndSwitch(FRAME);
    	String CCANo1=waitForElement(text_ccaRefNumber).getAttribute("value");
    	System.out.println("CCA No:"+CCANo1);
    	String custname1=waitForElement(text_revisedOutboundCusCode).getAttribute("value");
    	System.out.println("New Outbound Customer"+custname1);
    	
    	Assert.assertFalse(waitForElement(text_revisedOutboundCusCode).getAttribute("value").contains(shipper_new),"ERROR: CCA not saved successfully");
    	
    	
    	if(accept)
    	{
    	click(btn_btAccept);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(okBtn);
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertFalse(waitForElement(div_CCAStatus).getText().contains("Approved"),"ERROR: CCA not Approved");
    	}
    	else
    	{
    		Assert.assertFalse(waitForElement(div_CCAStatus).getText().contains("Approved"),"ERROR: CCA not Approved");
    	}
    	    	return this;
    	}
  
   /*** for verifying the remarks and also store the CCA num**/
    
    
     public CRA075 verifyAutoGeneratedCCA(String prefix, String awbno,String CCANo){
		
    	 
    	 prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
     	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
     	

     	

     	enterKeys(text_shipmentPrefix, prefix);
     	enterKeys(text_documentNumber, awbno);
     	click(btn_btnList);
     	minWait();
    	 
     	String tempcca=waitForElement(text_ccaRefNumber).getAttribute("value");
     	PropertyHandler.setPropValue(dataFilePath, CCANo, tempcca);
    	
    	Assert.assertTrue(waitForElement(txt_remarks).getText().contains("Approved Auto CCA as part of Voiding process"));
    	 
    	 return this;	 
     }
     
     
      
    public CRA075 CCAChangeInboundCustomer(String prefix, String awbno,String shipper_new,String CCANo,boolean accept,boolean UpdateAWBAgentCheck) {

    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	

    	

    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	if(UpdateAWBAgentCheck)
    	{
    		check(chkbox_UpdateAWBAgentCheck);
    	}
    	click(btn_customerlovInbound);
    	minWait();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	click(btn_customerlovbtnClear);
    	minWait();
    	click(btn_customerlovList);
    	minWait();
    	
    	check(chkbox_customerlovselectCheckBox);
    	click(btn_customerlovbtnOk);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	String custname=waitForElement(text_revisedInboundCusCode).getAttribute("value");
    	System.out.println("New Inbound Customer"+custname);
    	PropertyHandler.setPropValue(dataFilePath, shipper_new, custname);
    	shipper_new=PropertyHandler.getPropValue(dataFilePath, shipper_new);
    	
    	click(btn_btSave);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(okBtn);
    	waitForFrameAndSwitch(FRAME);
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(check_CCApopupselect);
    	click(btn_CCApopupbtnOk);
    	waitForFrameAndSwitch(FRAME);
    	String CCANo1=waitForElement(text_ccaRefNumber).getAttribute("value");
    	System.out.println("CCA No:"+CCANo1);
    	String custname1=waitForElement(text_revisedInboundCusCode).getAttribute("value");
    	System.out.println("New Inbound Customer"+custname1);
    	
    	Assert.assertFalse(waitForElement(text_revisedInboundCusCode).getAttribute("value").contains(shipper_new),"ERROR: CCA not saved successfully");
    	
    	
    	if(accept)
    	{
    	click(btn_btAccept);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(okBtn);
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertFalse(waitForElement(div_CCAStatus).getText().contains("Approved"),"ERROR: CCA not Approved");
    	}
    	else
    	{
    		Assert.assertFalse(waitForElement(div_CCAStatus).getText().contains("Approved"),"ERROR: CCA not Approved");
    	}
    	    	return this;
    	}
    public CRA075 AcceptCCA(String awbPrefix,String awb,String CCA){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awb = PropertyHandler.getPropValue(dataFilePath, awb);
    	enterKeys(text_shipmentPrefix, awbPrefix);
    	enterKeys(text_documentNumber, awb);
    	click(btn_btnList);
    	minWait();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(check_CCApopupselect);
    	click(btn_CCApopupbtnOk);
    	minWait();
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	String CCANo1=waitForElement(text_ccaRefNumber).getAttribute("value");
    	System.out.println("CCA No:"+CCANo1);
    	PropertyHandler.setPropValue(dataFilePath, CCA, CCANo1);
 	    click(btn_btAccept);
	   minWait();
	   driver.switchTo().defaultContent();
	  click(okBtn);
	  waitForFrameAndSwitch(FRAME);
    	System.out.println(waitForElement(div_CCAStatus).getText());
	Assert.assertTrue(waitForElement(div_CCAStatus).getText().contains("CCA Status : Approved"),"ERROR: CCA not Approved");
	return this;
}
    public CRA075 IATAchargeWithinTolerance(String awbPrefix,String awb){
    	
    	
    	awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awb=PropertyHandler.getPropValue(dataFilePath, awb);
    	
    	
    	
    
    
    	enterKeys(text_shipmentPrefix, awbPrefix);
    	enterKeys(text_documentNumber, awb);
    	click(btn_btnList);
    	minWait();
    	
       
    
    	driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
    
    
        waitForFrameAndSwitch(FRAME);
    
    
    String curntIATA=waitForElement(txt_IATAchargeRevised).getAttribute("value").replace(",","");
    int iataTmp=Integer.parseInt(curntIATA);
    
    iataTmp=iataTmp+5;
    
    
    String tmpIATA=Integer.toString(iataTmp);
    enterKeys(txt_IATAchargeRevised, tmpIATA);
	
	
	click(btn_btSave);
	minWait();
	driver.switchTo().defaultContent();
	click(okBtn);
	waitForFrameAndSwitch(FRAME);
	
	
	enterKeys(text_shipmentPrefix, awbPrefix);
	enterKeys(text_documentNumber, awb);
	click(btn_btnList);
	minWait();
	waitForNewWindow(2);
	switchToSecondWindow();
	check(check_CCApopupselect);
	click(btn_CCApopupbtnOk);
	waitForFrameAndSwitch(FRAME);
	String CCANo1=waitForElement(text_ccaRefNumber).getAttribute("value");
	System.out.println("CCA No:"+CCANo1);
	

	click(btn_btAccept);
	minWait();
	driver.switchTo().defaultContent();
	click(okBtn);
	waitForFrameAndSwitch(FRAME);
	return this;
	
	
	
	}
    
    
     
    public CRA075 CCA_DiffParameters(String prefix, String awbno, String parameter,String destn_new,String Discount_new,String ValChrg_new){

    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	destn_new=PropertyHandler.getPropValue(dataFilePath, destn_new);
    	
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	  driver.switchTo().defaultContent();
          if (verifyElementPresent(yesBtn)) {

              click(yesBtn);
          }
waitForFrameAndSwitch(FRAME);
    	
    	if(parameter=="FreightCharge"){
    	
    	String FCharge=waitForElement(text_revisedWeightCharge).getAttribute("value").replace(",","");
    	System.out.println("Before CCA freight charge is"+FCharge);
    	String Dis=waitForElementVisible(text_revisedDiscount).getAttribute("value");
    	System.out.println("Before CCA discount is"+Dis);
    	 int WC = Integer.parseInt(FCharge);
    	 WC=WC+200;
    	 String Freightcharge=String.valueOf(WC);
    	
    	
    	enterKeys(text_revisedWeightCharge, Freightcharge);
    	enterKeys(text_revisedWeightCharge, Keys.TAB);
    	minWait();
    	String Dis_CCA=waitForElement(text_revisedDiscount).getAttribute("value");
    	System.out.println("After CCA discount is"+Dis_CCA);
        PropertyHandler.setPropValue(dataFilePath, Discount_new, Dis_CCA);
    	Discount_new=PropertyHandler.getPropValue(dataFilePath, Discount_new);
    	
    	if(Dis==Dis_CCA){
    		System.out.println("Discount not recalculated as per the change in the Freight charge");
    		
    	}
    	}
    	else if(parameter=="Destination"){
    		String Org=waitForElement(text_revisedOriginCode).getAttribute("value");
        	System.out.println("Before CCA Origin is"+Org);
        	String Dest=waitForElement(text_revisedDestinationCode).getAttribute("value");
        	System.out.println("Before CCA Destination is"+Dest);
        	
        	enterKeys(text_revisedDestinationCode,destn_new);
                 		
    	}
    	
    	else if(parameter=="ValCharge"){
    		String ValChrg=waitForElement(text_revisedValuationCharge).getAttribute("value");
        	System.out.println("Before CCA Valuation charge is"+ValChrg);
        	 int VC = Integer.parseInt(ValChrg);
        	 VC=VC+200;
        	 String ValC=String.valueOf(VC);
        	
        	System.out.println("After CCA valuation charge is"+ValC);
        	PropertyHandler.setPropValue(dataFilePath, ValChrg_new, ValC);
        	ValChrg_new=PropertyHandler.getPropValue(dataFilePath, ValChrg_new);
        	
        	enterKeys(text_revisedValuationCharge,ValC);
        	
    	}
    	else
    	{
    		System.out.println("Parameter not found");
    	}
    	click(btn_btSave);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(okBtn);
    	waitForFrameAndSwitch(FRAME);
    	return this;
    	}
   
    
     
    public CRA075 maintainCCAErrorChecking(String prefix,String awbno){
    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	
    	String FCharge=waitForElement(text_revisedWeightCharge).getAttribute("value");
    	System.out.println("Before CCA freight charge is"+FCharge);
    	String Dis=waitForElement(text_revisedDiscount).getAttribute("value");
    	System.out.println("Before CCA discount is"+Dis);
    	String Freightcharge=FCharge+200;
    	enterKeys(text_revisedWeightCharge, Freightcharge);
    	enterKeys(text_revisedWeightCharge, Keys.TAB);
    	minWait();
    	
    	click(btn_btSave);
    	minWait();
    	Assert.assertTrue(waitForElement(info_error).getText().contains("AWB or related CCA(s) are in Withdrawn status"));
	return this;
   
    }

    public CRA075 CCA_VerifyApprovedDetails(String prefix, String awbno, String check,String destn_new,String Discount_new,String ValChrg_new){

    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	destn_new=PropertyHandler.getPropValue(dataFilePath, destn_new);
    	Discount_new=PropertyHandler.getPropValue(dataFilePath, Discount_new);
    	ValChrg_new=PropertyHandler.getPropValue(dataFilePath, ValChrg_new);
    			
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	
    	if(check=="CCA_Discount")
    	{
    		String Dis_CCA=waitForElement(text_revisedDiscount).getAttribute("value");
        	System.out.println("After CCA discount is"+Dis_CCA);
        	Assert.assertFalse(Dis_CCA.contains(Discount_new),"Discount not recalculated as per the change in the Freight charge");
        	
    		
    	}
    	else if(check=="CCA_Destn"){
    		String Dest_CCA=waitForElement(text_revisedDestinationCode).getAttribute("value");
        	System.out.println("After CCA discount is"+Dest_CCA);
        	Assert.assertFalse(Dest_CCA.contains(destn_new),"ERROR: Destination not changed as per CCA");
        	
              	}
    	else if(check=="CCA_ValChrg"){
    		String ValChg_CCA=waitForElement(text_revisedValuationCharge).getAttribute("value");
        	System.out.println("After CCA discount is"+ValChg_CCA);
        	Assert.assertFalse(ValChg_CCA.contains(ValChrg_new),"ERROR: Valuation charge not changed as per CCA");
        	
              	}
    	else{
    		System.out.println("Value to be checked is not found");
    	}
    	return this;
    }
    
    public CRA075 CCA_OtherCharges(String prefix, String awbno, String parameter,String RevisedCharge,String SubTotOCDC,String SubTotOCDA,String SubTotOCDC2,String SubTotOCDA2){

    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	
    	RevisedCharge=PropertyHandler.getPropValue(dataFilePath, RevisedCharge);
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	
    	if(parameter=="EditOtherCharges"){
    	click(lnk_otherChargeLink);
    	minWait();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(text_OtherChargesrevisedOtherCharge, RevisedCharge+Keys.TAB);
    	minWait();
    	String SubTolOCDC=waitForElement(tbl_OtherChargesdueCarrierTd).getText();
    	System.out.println("SubTolOCDC from popup:"+SubTolOCDC);
    	String SubTolOCDA=waitForElement(tbl_OtherChargesdueAgentTd).getText();
    	System.out.println("SubTolOCDA from popup:"+SubTolOCDA);
    	PropertyHandler.setPropValue(dataFilePath, SubTotOCDC, SubTolOCDC);
    	PropertyHandler.setPropValue(dataFilePath, SubTotOCDA, SubTolOCDA);
    	click(btn_OtherChargesbtOk);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	String Toc=waitForElement(div_totalOtherCharge).getText();
    	System.out.println("Total other charges from screen"+Toc);
    	int Ocdc = Integer.parseInt(SubTolOCDC);
    	int Ocda = Integer.parseInt(SubTolOCDA);
    	int totOtherChrg=Ocdc+Ocda;
    	System.out.println("Calculated total other charge:"+totOtherChrg);
    	String TOtherChrg=String.valueOf(totOtherChrg);
    	if(TOtherChrg==Toc){
    		System.out.println("Total Other Charges matches...");
    		click(btn_btSave);
        	minWait();
        	driver.switchTo().defaultContent();
        	click(okBtn);
        	waitForFrameAndSwitch(FRAME);
    		
    	}
    	}
    	else if(parameter=="AddOtherCharges"){
    		click(lnk_otherChargeLink);
        	minWait();
        	waitForNewWindow(2);
        	switchToSecondWindow();
        	click(lnk_OtherChargeslnkAdd);
        	minWait();
        	///click(lov);--> Need to write custom fn***//
        	
        	  List<WebElement> listElement;

              listElement = getWebElements(btn_chargeHeadlov);

        	int count = listElement.size()-1;
        	
        	click(getWebElements(btn_chargeHeadlov).get(count));
        	
        	
        	waitForNewWindow(3);
        	switchToNthWindow(3);
        	enterKeys(text_ChargeHeadpopupchargeHeadCode, "SRNI");
        	click(btn_ChargeHeadpopupbtList);
        	check(chkbox_ChargeHeadpopupchargeheadcode);
        	click(btn_ChargeHeadpopupbtnOk);
        	minWait();
        	waitForNewWindow(2);
        	switchToSecondWindow();
        	  List<WebElement> listElement1;

              listElement1 = getWebElements(chkbox_OtherChargesdueCarrierCheck);

        	int count1 = listElement1.size()+1;
        	
        	check(getWebElements(chkbox_OtherChargesdueCarrierCheck).get(count1));
        	
        	 List<WebElement> listElement2;

             listElement2 = getWebElements(text_OtherChargesrevisedOtherCharge);

       	int count2 = listElement2.size()-1;
       	
       	enterKeys(getWebElements(text_OtherChargesrevisedOtherCharge).get(count2),"150"+Keys.TAB);
       	minWait();
    	String SubTolOCDC2=waitForElement(tbl_OtherChargesdueCarrierTd).getText();
    	System.out.println("SubTolOCDC from popup:"+SubTolOCDC2);
    	String SubTolOCDA2=waitForElement(tbl_OtherChargesdueAgentTd).getText();
    	System.out.println("SubTolOCDA from popup:"+SubTolOCDA2);
    	PropertyHandler.setPropValue(dataFilePath, SubTotOCDC2, SubTolOCDC2);
    	PropertyHandler.setPropValue(dataFilePath, SubTotOCDA2, SubTolOCDA2);
    	click(btn_OtherChargesbtOk);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	String Toc2=waitForElement(div_totalOtherCharge).getText();
    	System.out.println("Total other charges from screen"+Toc2);
    	int Ocdc2 = Integer.parseInt(SubTolOCDC2);
    	int Ocda2 = Integer.parseInt(SubTolOCDA2);
    	int totOtherChrg2=Ocdc2+Ocda2;
    	System.out.println("Calculated total other charge:"+totOtherChrg2);
    	String TOtherChrg2=String.valueOf(totOtherChrg2);
    	if(TOtherChrg2==Toc2){
    		System.out.println("Total Other Charges matches...");
    		click(btn_btSave);
        	minWait();
        	driver.switchTo().defaultContent();
        	click(okBtn);
        	waitForFrameAndSwitch(FRAME);
    		
    	}
        	
    		
     
        	
    	
    	}
		return this;	
    }
    public CRA075 Change_PcsCommPdtDim(String prefix, String awbno, String RevisedPcs,String RevisedComm,boolean accept){

    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	
    	RevisedPcs=PropertyHandler.getPropValue(dataFilePath, RevisedPcs);
    	RevisedComm=PropertyHandler.getPropValue(dataFilePath, RevisedComm);
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	enterKeys(text_revisedPieces, RevisedPcs);
    	enterKeys(text_revisedCommodityCode, RevisedComm);
    	click(lov_productlov);
    	minWait();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(check_ProductpopupproductChecked);
    	click(btn_Productpopupbtok);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_ProductpopupshipmAndDimsLink);
    	minWait();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(text_ShipDimpopupdimCommodities, RevisedComm);
    	enterKeys(text_ShipDimpopupdimPieces, RevisedPcs);
    	enterKeys(text_ShipDimpopupdimWeight, "50");
    	enterKeys(text_ShipDimpopupdimLength, "50");
    	enterKeys(text_ShipDimpopupdimWidth, "50");
    	enterKeys(text_ShipDimpopupdimHeight, "50");
    	click(btn_ShipDimpopupbtnCalculate);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	check(check_reason);
    	
    	click(btn_btSave);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(okBtn);
    	waitForFrameAndSwitch(FRAME);
    	
    	
    	
    	enterKeys(text_shipmentPrefix, prefix);
    	enterKeys(text_documentNumber, awbno);
    	click(btn_btnList);
    	minWait();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	check(check_CCApopupselect);
    	click(btn_CCApopupbtnOk);
    	waitForFrameAndSwitch(FRAME);
    	String CCANo1=waitForElement(text_ccaRefNumber).getAttribute("value");
    	System.out.println("CCA No:"+CCANo1);
    	String RPcs=waitForElement(text_revisedPieces).getAttribute("value");
    	System.out.println("Revised pcs:"+RPcs);
    	String RComm=waitForElement(text_revisedPieces).getAttribute("value");
    	System.out.println("Revised commodity:"+RComm);
    	
    	Assert.assertFalse(RPcs.contains(RevisedPcs),"ERROR: CCA not saved successfully");
    	Assert.assertFalse(RComm.contains(RevisedComm),"ERROR: CCA not saved successfully");
    	
    	
    	
    	
    	if(accept)
    	{
    	click(btn_btAccept);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(okBtn);
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertFalse(waitForElement(div_CCAStatus).getText().contains("Approved"),"ERROR: CCA not Approved");
    	}
    	else
    	{
    		Assert.assertFalse(waitForElement(div_CCAStatus).getText().contains("Approved"),"ERROR: CCA not Approved");
    	}
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
