package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/*****
 * 
 * @author A-6784
 *
 */
public class OPR002 extends BasePage{

    private static final WebElement Btn_OKPopup = null;
	public static String FRAME = "iCargoContentFrameOPR002";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String screenFrame;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    
   By
   txt_incomingCarrier,
   txt_incomingFlight,
   txt_incomingFlightDate,
   txt_outgoingCarrier ,
   txt_outgoingFlight,
   txt_outgoingFlightDate ,
   btn_List ,
   btn_Retrieveshpmnt ,
   chkbx_SelectShpmt,
   btn_Retrievebtn2,
   txt_documentNumber ,
   btn_OKPopup,
   Chkbx_SelectRetrievedData ,
   Lnk_AddLink ,
   txt_awbPrefix  ,
   txt_awbNumber,
   btn_ListAwb,
   txt_actPcs ,
   txt_actWt ,
   btn_OK ,
   btnSave  ,
   dropdown_CTMType ,
   btn_TransferEnd ,
   txt_actDate ,
   txt_actTime,
   btn_Save ,
   btn_Close ,
   btn_Reject  ,
   dropdown_ReasonForRejection,
   txt_Remarks ,
   btn_saverejection ,
   btn_clear,
   Tbl_CTMDetails  ,
   txt_RefNo  ,
   txt_CTMpiecesPopup,
   chkbx_selctCTMdetails,
   btn_popupSave,
   btn_ULDLevelCTM;

      
   By btn_genericYes,
	info_msg,
	btn_noBtn,
	btn_ok,
	info_error;
    
    
    public OPR002(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initPageElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    
    
    private void initPageElements(){	
    	
    	
    	  txt_incomingCarrier                    =MiscUtility.getWebElement(objFilepath, "OPR002_txt_incomingCarrier");
    	   txt_incomingFlight                    =MiscUtility.getWebElement(objFilepath, "OPR002_txt_incomingFlight");
    	   txt_incomingFlightDate                =MiscUtility.getWebElement(objFilepath, "OPR002_txt_incomingFlightDate");
    	   txt_outgoingCarrier                   =MiscUtility.getWebElement(objFilepath, "OPR002_txt_outgoingCarrier");
    	   txt_outgoingFlight                    =MiscUtility.getWebElement(objFilepath, "OPR002_txt_outgoingFlight");
    	   txt_outgoingFlightDate                =MiscUtility.getWebElement(objFilepath, "OPR002_txt_outgoingFlightDate");
    	   btn_List                              =MiscUtility.getWebElement(objFilepath, "OPR002_btn_List");
    	   chkbx_selctCTMdetails                 = MiscUtility.getWebElement(objFilepath, "OPR002_chkbx_selctCTMdetails");
    	   btn_Retrieveshpmnt                    =MiscUtility.getWebElement(objFilepath, "OPR002_btn_Retrieveshpmnt");
    	   chkbx_SelectShpmt                     =MiscUtility.getWebElement(objFilepath, "OPR002_chkbx_SelectShpmt");
    	   btn_Retrievebtn2                      =MiscUtility.getWebElement(objFilepath, "OPR002_btn_Retrievebtn2");
    	   txt_documentNumber                    =MiscUtility.getWebElement(objFilepath, "OPR002_txt_documentNumber");
    	   btn_OKPopup                           =MiscUtility.getWebElement(objFilepath, "OPR002_btn_OKPopup");
    	   Chkbx_SelectRetrievedData             =MiscUtility.getWebElement(objFilepath, "OPR002_Chkbx_SelectRetrievedData");
    	   Lnk_AddLink                           =MiscUtility.getWebElement(objFilepath, "OPR002_Lnk_AddLink");
    	   txt_awbPrefix                         =MiscUtility.getWebElement(objFilepath, "OPR002_txt_awbPrefix");
    	   txt_awbNumber                         =MiscUtility.getWebElement(objFilepath, "OPR002_txt_awbNumber");
    	   btn_ListAwb                           =MiscUtility.getWebElement(objFilepath, "OPR002_btn_ListAwb");
    	   txt_actPcs                            =MiscUtility.getWebElement(objFilepath, "OPR002_txt_actPcs");
    	   txt_actWt                             =MiscUtility.getWebElement(objFilepath, "OPR002_txt_actWt");
    	   btn_OK                                =MiscUtility.getWebElement(objFilepath, "OPR002_btn_OK");
    	   btnSave                               =MiscUtility.getWebElement(objFilepath, "OPR002_btnSave");
    	   dropdown_CTMType                      =MiscUtility.getWebElement(objFilepath, "OPR002_dropdown_CTMType");
    	   btn_TransferEnd                       =MiscUtility.getWebElement(objFilepath, "OPR002_btn_TransferEnd");
    	   txt_actDate                           =MiscUtility.getWebElement(objFilepath, "OPR002_txt_actDate");
    	   txt_actTime                           =MiscUtility.getWebElement(objFilepath, "OPR002_txt_actTime");
    	   btn_Save                              =MiscUtility.getWebElement(objFilepath, "OPR002_btn_Save");
    	   btn_Close                             =MiscUtility.getWebElement(objFilepath, "OPR002_btn_Close");
    	   btn_Reject                            =MiscUtility.getWebElement(objFilepath, "OPR002_btn_Reject");
    	   dropdown_ReasonForRejection           =MiscUtility.getWebElement(objFilepath, "OPR002_dropdown_ReasonForRejection");
    	   txt_Remarks                           =MiscUtility.getWebElement(objFilepath, "OPR002_txt_Remarks");
    	   btn_saverejection                     =MiscUtility.getWebElement(objFilepath, "OPR002_btn_saverejection");
    	   btn_clear                             =MiscUtility.getWebElement(objFilepath, "OPR002_btn_clear");
    	   Tbl_CTMDetails                        =MiscUtility.getWebElement(objFilepath, "OPR002_Tbl_CTMDetails");
    	   txt_RefNo                             =MiscUtility.getWebElement(objFilepath, "OPR002_txt_RefNo");
    	   btn_ULDLevelCTM                       =MiscUtility.getWebElement(objFilepath, "OPR002_btn_ULDLevelCTM");
    	   txt_CTMpiecesPopup                    =MiscUtility.getWebElement(objFilepath, "OPR002_txt_CTMpiecesPopup");
    	   btn_popupSave                         =MiscUtility.getWebElement(objFilepath, "OPR002_btn_popupSave");
    	
    	btn_genericYes     = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_noBtn 		   = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        info_msg		   = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        info_error         = MiscUtility.getWebElement(genObjPath, "Generic_info_error") ;
        btn_ok             = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
}

  public OPR002 saveCTM(String AWBPrefix, String AWBNo,String Carrier_Code,String FlightNo,String FlightStartDate,String OAL_Carrier,String FlightNo2,String Pcs,String Wgt,String CTMRefNo){
	
	  
	  
	  AWBPrefix           =PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
	  AWBNo               =PropertyHandler.getPropValue(dataFilePath, AWBNo);
	  Carrier_Code        =PropertyHandler.getPropValue(dataFilePath, Carrier_Code);
	  FlightNo            =PropertyHandler.getPropValue(dataFilePath, FlightNo);
	  FlightStartDate     =PropertyHandler.getPropValue(dataFilePath, FlightStartDate);
	  OAL_Carrier         =PropertyHandler.getPropValue(dataFilePath, OAL_Carrier);
	  FlightNo2           =PropertyHandler.getPropValue(dataFilePath, FlightNo2);
	  Pcs                 =PropertyHandler.getPropValue(dataFilePath, Pcs);
	  Wgt                 =PropertyHandler.getPropValue(dataFilePath, Wgt);
	  CTMRefNo            =PropertyHandler.getPropValue(dataFilePath, CTMRefNo);
	  
	  
	  enterKeys(txt_incomingCarrier, Carrier_Code);
	  enterKeys(txt_incomingFlight, FlightNo);
	  enterKeys(txt_incomingFlightDate, FlightStartDate);
	  enterKeys(txt_outgoingCarrier, OAL_Carrier);
	  enterKeys(txt_outgoingFlight, FlightNo2);
	  enterKeys(txt_outgoingFlightDate, FlightStartDate);
	  click(btn_List);
	  minWait();
	  click(Lnk_AddLink);
	  minWait();
	  waitForNewWindow(2);
	  switchToSecondWindow();
	  enterKeys(txt_awbPrefix, AWBPrefix);
	  enterKeys(txt_awbNumber, AWBNo);
	  click(btn_ListAwb);
	  minWait();
	  enterKeys(txt_actPcs, Pcs);
	  enterKeys(txt_actWt, Wgt);
	  click(btn_OK);
	  minWait();
	  switchToFirstWindow();
	  waitForFrameAndSwitch(FRAME);
	  click(btn_Save);
	  minWait();
	  driver.switchTo().defaultContent();
	  String tmprefdata=waitForElement(info_msg).getText();
	   System.out.println(tmprefdata);
	 
	   
	  click(btn_noBtn);
	  waitForFrameAndSwitch(FRAME);
	  verifyValuePresentInTblColumn (Tbl_CTMDetails, 2,AWBNo);
	  
	  
	  return this;  
	  
  }
    
  public OPR002 captureCTM(String AWBPrefix, String AWBNo,String Carrier_Code,String FlightNo,String FlightStartDate,String OAL_Carrier,String FlightNo2,String Pcs,String Wgt,String CTMRefNo){
	
  
	  AWBPrefix           =PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
	  AWBNo               =PropertyHandler.getPropValue(dataFilePath, AWBNo);
	  Carrier_Code        =PropertyHandler.getPropValue(dataFilePath, Carrier_Code);
	  FlightNo            =PropertyHandler.getPropValue(dataFilePath, FlightNo);
	  FlightStartDate     =PropertyHandler.getPropValue(dataFilePath, FlightStartDate);
	  OAL_Carrier         =PropertyHandler.getPropValue(dataFilePath, OAL_Carrier);
	  FlightNo2           =PropertyHandler.getPropValue(dataFilePath, FlightNo2);
	  Pcs                 =PropertyHandler.getPropValue(dataFilePath, Pcs);
	  Wgt                 =PropertyHandler.getPropValue(dataFilePath, Wgt);
	  //CTMRefNo            =PropertyHandler.getPropValue(dataFilePath, CTMRefNo);
	  
	  click(btn_List);
	  minWait();
	  enterKeys(txt_incomingCarrier, Carrier_Code);
	  enterKeys(txt_incomingFlight, FlightNo);
	  enterKeys(txt_incomingFlightDate, FlightStartDate);
	  enterKeys(txt_outgoingCarrier, OAL_Carrier);
	  enterKeys(txt_outgoingFlight, FlightNo2);
	  enterKeys(txt_outgoingFlightDate, FlightStartDate);
	
	  click(btn_Retrieveshpmnt);
  	  minWait();
	    waitForNewWindow(2);
	    switchToSecondWindow();
	    check(chkbx_SelectShpmt);
	    click(btn_Retrievebtn2);
	    minWait();
	    Assert.assertTrue(waitForElement(txt_documentNumber).getAttribute("value").contains(AWBNo),"Error : AWB not Listed");
	    check(Chkbx_SelectRetrievedData);
	    minWait();
	    click(btn_OKPopup);
	    
	    minWait();
	    switchToFirstWindow();
	    waitForFrameAndSwitch(FRAME);
	    click(btn_Save);
	  minWait();
	  driver.switchTo().defaultContent();
  

	  
	  waitForElement(info_msg).getText().contains("saved successfully. Do you want to Print the Transfer Manifest?");
    	 click(btn_genericYes);
   	  waitForFrameAndSwitch(FRAME);
   	  waitForNewWindow(2);
   	  switchToSecondWindow();
   	  closeAndmoveToFirstWindow();
   	waitForFrameAndSwitch(FRAME);
    	tblSelectRowByColValue(Tbl_CTMDetails, 1, 2, AWBNo);
    	System.out.println(waitForElementVisible(txt_RefNo).getAttribute("value"));
    	PropertyHandler.setPropValue(dataFilePath, CTMRefNo, waitForElementVisible(txt_RefNo).getAttribute("value"));
    	click(btn_clear);
    	return this;
    
	
  }
  
  /**
   * capture Inbound case
   * @param CTMref
   * @param awbprefix
   * @param awb
   * @param pieces
   * @param oalCarrier
   * @param ownCarrier
   * @param flightNumbr
   * @return
   */
  public OPR002 captureInboundCTM(String CTMref,String awbprefix,String awb,String pieces,String oalCarrier,String ownCarrier,String flightdate){
	  
	  
	  awbprefix=PropertyHandler.getPropValue(objFilepath, awbprefix);
	  awb=PropertyHandler.getPropValue(objFilepath, awb);
	  pieces=PropertyHandler.getPropValue(objFilepath, pieces);
	  oalCarrier=PropertyHandler.getPropValue(objFilepath, oalCarrier);
	  ownCarrier=PropertyHandler.getPropValue(objFilepath, ownCarrier);
	  flightdate=PropertyHandler.getPropValue(objFilepath, flightdate);
	  
	  
	 String  rand_CTMRef = BizUtility.createFlightNum();
	 
	  enterKeys(txt_RefNo, rand_CTMRef);
	  
	  selectByText(dropdown_CTMType, "Inbound");
	  click(btn_List);
	  PropertyHandler.setPropValue(dataFilePath, CTMref, rand_CTMRef);
	  minWait();
	  
	  driver.switchTo().defaultContent();
	  
	  if (verifyElementPresent(btn_genericYes)) {

          click(btn_genericYes);
      }
	  
	  waitForFrameAndSwitch(FRAME);
	  enterKeys(txt_incomingCarrier, oalCarrier);
	  enterKeys(txt_incomingFlightDate,flightdate );
	  enterKeys(txt_outgoingCarrier, ownCarrier);
	  enterKeys(txt_outgoingFlightDate, flightdate);
	  click(Lnk_AddLink);
	  
	  minWait();
	  driver.switchTo().defaultContent();
	  waitForNewWindow(2);
	  switchToSecondWindow();
	  
	  enterKeys(txt_awbPrefix, awbprefix);
	  enterKeys(txt_awbNumber, awb);
	  click(btn_ListAwb);
	  minWait();
	  enterKeys(txt_CTMpiecesPopup, pieces+Keys.TAB);
	  click(btn_OKPopup);
	  switchToFirstWindow();
	  waitForFrameAndSwitch(FRAME);
	  
	  minWait();
	  click(btn_Save);
	  
	  driver.switchTo().defaultContent();
	  click(btn_noBtn);
	  waitForFrameAndSwitch(FRAME);
	  return this;
	  
  }
    
    public OPR002 transferEnd(String CTMRefeNo,boolean errorChk){
		
    	CTMRefeNo=PropertyHandler.getPropValue(dataFilePath, CTMRefeNo);
    	
    	click(btn_clear);
		
		minWait();
		enterKeys(txt_RefNo, CTMRefeNo);
		click(btn_List);
		minWait();
		check(chkbx_selctCTMdetails);
    	click(btn_TransferEnd);
    	driver.switchTo().defaultContent();
    	if(errorChk){    		
    		waitForElement(info_msg).getText().contains("is/are rejected. Cannot be Transfer.");
    		click(btn_ok);  
    		waitForFrameAndSwitch(FRAME);
    	}
    	else{
    	waitForNewWindow(2);
        switchToSecondWindow();
    	enterKeys(txt_actDate, ".");
    	enterKeys(txt_actTime, "1");    
    	click(btn_popupSave);
    	switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
    	}
    	return this;
    }
    
    public OPR002 rejectCTM(String AWBNo){
    	
    	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	click(btn_List);
    	minWait();
    	waitForElement(btn_Retrieveshpmnt).isEnabled();
    	click(btn_Retrieveshpmnt);
    	minWait();
  	    waitForNewWindow(2);
  	    switchToSecondWindow();
  	    check(chkbx_SelectShpmt);
  	    click(btn_Retrievebtn2);
  	    minWait();
  	  check(Chkbx_SelectRetrievedData);
  	    click(btn_OKPopup);
  	    
  	    minWait();
	    switchToFirstWindow();
	    waitForFrameAndSwitch(FRAME);
  	 
  	    /*check(Chkbx_SelectRetrievedData);
  	    minWait();
  	    
  	    
  	    click(btn_Save);
  	  minWait();
	  driver.switchTo().defaultContent();
    	*//*** save refNo step on hold due to bug***//*
	  
	  waitForElement(info_msg).getText().contains("saved successfully. Do you want to Print the Transfer Manifest?");
    	 click(btn_noBtn);
   	  waitForFrameAndSwitch(FRAME);
    	
    	minWait();*/
    	 tblSelectRowByColValue(Tbl_CTMDetails, 1, 2, AWBNo);
    	click(btn_Reject);
    	minWait();
    	waitForNewWindow(2);
  	    switchToSecondWindow();
  	   // waitForFrameAndSwitch(FRAME);
  	    selectByIndex(dropdown_ReasonForRejection, 1);
  	    enterKeys(txt_Remarks, "Shipment Rejected");
    	click(btn_saverejection);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this; 	
    }
   
    public OPR002 retreiveShipment(String AWBPrefix,String AWBNo){
    	
    	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	AWBPrefix=PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
    	click(btn_List);
    	minWait();
    	waitForElement(btn_Retrieveshpmnt).isEnabled();
    	click(btn_Retrieveshpmnt);
    	minWait();
    	 driver.switchTo().defaultContent();
  	    waitForNewWindow(2);
  	    switchToSecondWindow();
  	    check(chkbx_SelectShpmt);
  	    click(btn_Retrievebtn2);
  	    System.out.println(waitForElementVisible(txt_documentNumber).getAttribute("value"));
  	    Assert.assertTrue(waitForElementVisible(txt_documentNumber).getAttribute("value").contains(AWBNo),"Error : AWB Listed");
  	    check(Chkbx_SelectRetrievedData);
  	    click(btn_OKPopup);
  	    
  	    minWait();
	    switchToFirstWindow();
	    waitForFrameAndSwitch(FRAME);
  	    click(btn_Save);
  	  minWait();
	  driver.switchTo().defaultContent();
    
	  
	  waitForElement(info_msg).getText().contains("saved successfully. Do you want to Print the Transfer Manifest?");
    	 click(btn_noBtn);
   	  waitForFrameAndSwitch(FRAME);
    	//tblSelectRowByColValue(Tbl_CTMDetails, 1, 2, AWBNo);
    	
    	return this;
    	
    }
    
    
    
    
    
    
    public HomePage close() {

        click(btn_Close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}