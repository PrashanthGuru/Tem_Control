package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class OPR001 extends BasePage{

    public static String FRAME = "iCargoContentFrameOPR001";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String screenFrame;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    
    By
    
    txt_carrierCode,
    txt_flightNumber	,
    txt_flightDate,
    txt_origin,
    txt_destination,
    btn_Listbtn,
    btn_Clearbtn	,
    btn_Discrepancybtn,
    btn_FlagFlightbtn,
    btn_CloseFlightbtn,
    btn_Savebtn,
    btn_Closebtn,
    Tbl_listArrivalTable,
    btn_Notify,
    btn_sendFSU_NFD,
    info_notified,
    btn_sendManual,
    btn_okSendFSUpopup,
    txt_manualNotificationRemarks,
    btn_saveNotification,
    btn_Clear,
    chkbox_selectAWB,
    btn_discreOK,
    ChkBox_awbRecievedFlagon;
    
    private By btn_genericYes,
	info_msg,
	btn_noBtn,
	btn_ok,
	info_error;
    
    
    public OPR001(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initPageElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    
    
    private void initPageElements(){	
    	
    	txt_carrierCode                     = MiscUtility.getWebElement(objFilepath, "OPR001_txt_carrierCode");
    	txt_flightNumber                    = MiscUtility.getWebElement(objFilepath, "OPR001_txt_flightNumber"); 
    	txt_flightDate                      = MiscUtility.getWebElement(objFilepath, "OPR001_txt_flightDate");
    	txt_origin                          = MiscUtility.getWebElement(objFilepath, "OPR001_txt_origin");
    	txt_destination                     = MiscUtility.getWebElement(objFilepath, "OPR001_txt_destination");
        btn_Listbtn                         = MiscUtility.getWebElement(objFilepath, "OPR001_btn_Listbtn");
        btn_Clearbtn                        = MiscUtility.getWebElement(objFilepath, "OPR001_btn_Clearbtn");
        btn_Discrepancybtn			        = MiscUtility.getWebElement(objFilepath,  "OPR001_btn_Discrepancybtn");
        btn_FlagFlightbtn                   = MiscUtility.getWebElement(objFilepath, "OPR001_btn_FlagFlightbtn");
        btn_CloseFlightbtn                  = MiscUtility.getWebElement(objFilepath, "OPR001_btn_CloseFlightbtn");
        btn_Savebtn                         = MiscUtility.getWebElement(objFilepath, "OPR001_btn_Savebtn");
        btn_Closebtn			            = MiscUtility.getWebElement(objFilepath, "OPR001_btn_Closebtn");
        ChkBox_awbRecievedFlagon            = MiscUtility.getWebElement(objFilepath, "OPR001_ChkBox_awbRecievedFlagon");
        Tbl_listArrivalTable                = MiscUtility.getWebElement(objFilepath, "OPR001_Tbl_listArrivalTable");
        chkbox_selectAWB                    = MiscUtility.getWebElement(objFilepath, "OPR001_chkbox_selectAWB");
         btn_discreOK                       = MiscUtility.getWebElement(objFilepath, "OPR001_btn_discreOK");
         btn_Notify                           =MiscUtility.getWebElement(objFilepath, "OPR001_btn_Notify");
         btn_sendFSU_NFD                         = MiscUtility.getWebElement(objFilepath, "OPR001_btn_sendFSU_NFD");
        btn_sendManual                     = MiscUtility.getWebElement(objFilepath, "OPR001_btn_sendManual");
        btn_okSendFSUpopup                 = MiscUtility.getWebElement(objFilepath, "OPR001_btn_okSendFSUpopup");
        txt_manualNotificationRemarks      = MiscUtility.getWebElement(objFilepath, "OPR001_txt_manualNotificationRemarks");
        btn_saveNotification               = MiscUtility.getWebElement(objFilepath, "OPR001_btn_saveNotification");
        info_notified                      = MiscUtility.getWebElement(objFilepath, "OPR001_info_notified");
        btn_Clear                          = MiscUtility.getWebElement(objFilepath, "OPR001_btn_Clear");

        
        btn_genericYes     = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_noBtn 		   = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        info_msg		   = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        info_error         = MiscUtility.getWebElement(genObjPath, "Generic_info_error") ;
        btn_ok             = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    }
    
    /**
     * 
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param AWBNo
     * @return
     *A-6784*/
    public OPR001 markShipmntRecieved(String carrierCode, String flightNo , String flightDate , String FullAWBNo , boolean IsATAcaptured){
    	
    	carrierCode        =PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo           =PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate         =PropertyHandler.getPropValue(dataFilePath, flightDate);
    	FullAWBNo              =PropertyHandler.getPropValue(dataFilePath, FullAWBNo);
    	
    	click(btn_Clear);
    	minWait();
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNumber, flightNo);
    	enterKeys(txt_flightDate, flightDate);
    	click(btn_Listbtn);
    	minWait();
    	
    	String tempAWB = getTableCellValue(Tbl_listArrivalTable, 2, 1);
    	System.out.println(tempAWB);
    	System.out.println(tempAWB+" AWB Listed");
    	tempAWB=tempAWB.replaceAll(" ", "-");
    	System.out.println(tempAWB+" AWB Listed");
    	Assert.assertTrue(tempAWB.contains(FullAWBNo), "ERROR : AWB not listed.");
    	
    	    	
    	check(ChkBox_awbRecievedFlagon);
    	click(btn_Savebtn);
    	
    	if(IsATAcaptured == true){
    		
    		minWait();
    	}
    	else{
    		driver.switchTo().defaultContent();
    		System.out.println(waitForElement(info_msg).getText());
    		
    	 Assert.assertTrue(waitForElement(info_msg).getText().equals("Do you want to capture Actual Time of Arrival ?"));
    	
    	 click(btn_noBtn);
    	 waitForFrameAndSwitch(FRAME);
    	 minWait();
    	 
    	}
    	
    	
    	
		return this;
    	
    }
    
public OPR001 relistVerifyRecieved(String carrierCode, String flightNo , String flightDate ){
    	
    	carrierCode        =PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo           =PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate         =PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
       	click(btn_Clear);
    	minWait();
    	
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNumber, flightNo);
    	enterKeys(txt_flightDate, flightDate);
    	click(btn_Listbtn);
    	minWait();
    	
        	Assert.assertTrue(waitForElement(ChkBox_awbRecievedFlagon).isSelected());
        	
        	
    	
    	
		return this;
    	
    }
    
    
    /***
     * for Notify flight (Manual/send NFD)
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param notifyType
     * @return
     */
    public OPR001 notifyFlight(String carrierCode, String flightNo , String flightDate ,String notifyType){
    	
    	carrierCode        =PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo           =PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate         =PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	
       	click(btn_Clear);
    	minWait();
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNumber, flightNo);
    	enterKeys(txt_flightDate, flightDate);
    	click(btn_Listbtn);
    	minWait();
    	check(chkbox_selectAWB);
    	click(btn_Notify);
    	//click(btn_Notify);
    	if(notifyType.contains("Manual")){
    	click(btn_sendManual);
    	minWait();
    	driver.switchTo().defaultContent();
        waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(txt_manualNotificationRemarks, "Notification Remarks");
    	click(btn_saveNotification);
    	minWait();
    	switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);
       minWait();
       click(btn_Clearbtn);
       minWait();
       enterKeys(txt_carrierCode, carrierCode);
   	enterKeys(txt_flightNumber, flightNo);
   	enterKeys(txt_flightDate, flightDate);
   	click(btn_Listbtn);
   	minWait();
       
       isElementPresent(info_notified);
    	}
    	else{
    		
    		click(btn_sendFSU_NFD);
    		minWait();
        	driver.switchTo().defaultContent();
            waitForNewWindow(2);
        	switchToSecondWindow();
        	click(btn_okSendFSUpopup);
        	minWait();
        	switchToFirstWindow();

            waitForFrameAndSwitch(FRAME);
           minWait();
    	}
    	return this;
    	
    }
    
    
    public OPR001 relistVerifyNotified(String carrierCode, String flightNo , String flightDate ,boolean Manual){
    	
    	carrierCode        =PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo           =PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate         =PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	
       	click(btn_Clear);
    	minWait();
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNumber, flightNo);
    	enterKeys(txt_flightDate, flightDate);
    	click(btn_Listbtn);
    	minWait();
    	if(Manual){
        	Assert.assertTrue(waitForElement(info_notified).getAttribute("src").contains("tele-tick"));
        	}
        	else{
        		Assert.assertTrue(waitForElement(info_notified).getAttribute("src").contains("tick"));
        	}
    	
    	
		return this;
    	
    }
    
    public OPR001 verifyFlightntDepartedError(String carrierCode, String flightNo , String flightDate){
    	
    	
    	carrierCode        =PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo           =PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate         =PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
       	click(btn_Clear);
    	minWait();
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNumber, flightNo);
    	enterKeys(txt_flightDate, flightDate);
    	click(btn_Listbtn);
    	minWait();
    	System.out.println(waitForElement(info_error).getText());
    	Assert.assertTrue(waitForElement(info_error).getText().contains("Flight not departed from previous airport."));
    	click(btn_Clearbtn);
		return this;
    	
    }
    
    
    public OPR001 flagFlight(String carrierCode, String flightNo , String flightDate){
    	
    	
    	carrierCode        =PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo           =PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate         =PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
       	click(btn_Clear);
    	minWait();
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNumber, flightNo);
    	enterKeys(txt_flightDate, flightDate);
    	click(btn_Listbtn);
    	minWait();
    	click(btn_FlagFlightbtn);
    	minWait();
    	
    	Assert.assertTrue(waitForElement(info_msg).getText().contains("is flagged"));
    	click(btn_ok);
    	waitForFrameAndSwitch(FRAME);
		return this;
    	
    }
   public OPR001 flagFlightErrorcheck(String carrierCode, String flightNo , String flightDate ,boolean errChk){
	 
		
   	carrierCode        =PropertyHandler.getPropValue(dataFilePath, carrierCode);
   	flightNo           =PropertyHandler.getPropValue(dataFilePath, flightNo);
   	flightDate         =PropertyHandler.getPropValue(dataFilePath, flightDate);
   	
   	click(btn_Clear);
	minWait();
   	enterKeys(txt_carrierCode, carrierCode);
   	enterKeys(txt_flightNumber, flightNo);
   	enterKeys(txt_flightDate, flightDate);
   	click(btn_Listbtn);
   	minWait();
   	click(btn_FlagFlightbtn);
   	minWait();
   	driver.switchTo().defaultContent();
   	System.out.println(waitForElement(info_msg).getText());
   	Assert.assertTrue(waitForElement(info_msg).getText().contains("Missing AWB discrepancies shall be marked for some shipments within the flight. Do you want to continue Flagging the flight?"));
   	click(btn_genericYes);
   	waitForFrameAndSwitch(FRAME);
   	if(errChk){
   	waitForElement(info_error).getText().contains("capture not done for the AWB");
	   
   	}
   	else{
   		
   		driver.switchTo().defaultContent();
   		Assert.assertTrue(waitForElement(info_msg).getText().contains("is flagged"));
    	click(btn_ok);
    	waitForFrameAndSwitch(FRAME);
   	}
	return this;
	   
   }
    /**
     * 
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    
public OPR001 flagFlightNotRecieved(String carrierCode, String flightNo , String flightDate){
    	
    	
    	carrierCode        =PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo           =PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate         =PropertyHandler.getPropValue(dataFilePath, flightDate);
    	minWait();
    	
       	click(btn_Clear);
    	minWait();
    	enterKeys(txt_carrierCode, carrierCode);
    	enterKeys(txt_flightNumber, flightNo);
    	enterKeys(txt_flightDate, flightDate);
    	click(btn_Listbtn);
    	minWait();
    	click(btn_FlagFlightbtn);
    	minWait();
    	driver.switchTo().defaultContent();
    	waitForElement(info_msg).getText().contains("Missing AWB discrepancies shall be marked for some shipments within the flight. Do you want to continue Flagging the flight?");
    	click(btn_genericYes);
    	waitForFrameAndSwitch(FRAME);
    	driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(info_msg).getText().contains("is flagged"));
    	click(btn_ok);
    	waitForFrameAndSwitch(FRAME);
		return this;
    	
    }
/**
 * 
 * @param carrierCode
 * @param flightNo
 * @param flightDate
 * @param isATAcaptured
 * @return
 */
public OPR001 closeFlight(String carrierCode, String flightNo , String flightDate ,boolean isATAcaptured){
	
	
	carrierCode        =PropertyHandler.getPropValue(dataFilePath, carrierCode);
	flightNo           =PropertyHandler.getPropValue(dataFilePath, flightNo);
	flightDate         =PropertyHandler.getPropValue(dataFilePath, flightDate);
	
   	click(btn_Clear);
	minWait();
	enterKeys(txt_carrierCode, carrierCode);
	enterKeys(txt_flightNumber, flightNo);
	enterKeys(txt_flightDate, flightDate);
	click(btn_Listbtn);
	minWait();
	click(btn_CloseFlightbtn);
	minWait();
	if(isATAcaptured){
	driver.switchTo().defaultContent();
	click(btn_ok);
	waitForFrameAndSwitch(FRAME);
	//driver.switchTo().defaultContent();
	minWait();
	waitForNewWindow(2);
	switchToSecondWindow();
	click(btn_discreOK);
	minWait();
	driver.switchTo().defaultContent();
	minWait();
	
	Assert.assertTrue(waitForElement(info_msg).getText().contains("Flight is closed"));
	click(btn_ok);
	waitForFrameAndSwitch(FRAME);
	}
	else{
		
	 //	waitForElement(info_error).getText().contains("Flight not Arrived");
	 	minWait();
	}
	
	
	return this;
	
}

public OPR001 relistVerifyReceived(String carrierCode, String flightNo , String flightDate){
	
	carrierCode        =PropertyHandler.getPropValue(dataFilePath, carrierCode);
	flightNo           =PropertyHandler.getPropValue(dataFilePath, flightNo);
	flightDate         =PropertyHandler.getPropValue(dataFilePath, flightDate);
	
	
	enterKeys(txt_carrierCode, carrierCode);
	enterKeys(txt_flightNumber, flightNo);
	enterKeys(txt_flightDate, flightDate);
	click(btn_Listbtn);
	minWait();
	
	waitForElement(ChkBox_awbRecievedFlagon).isSelected();
	
	return this;
	
}
		
/**
 * 
 * @param carrierCode
 * @param flightNo
 * @param flightDate
 * @param isATAcaptured
 * @return
 */

 public OPR001 relistverifyClosed(String carrierCode, String flightNo , String flightDate){
		
		
		carrierCode        =PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo           =PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate         =PropertyHandler.getPropValue(dataFilePath, flightDate);
		
	   	click(btn_Clear);
    	minWait();
		enterKeys(txt_carrierCode, carrierCode);
		enterKeys(txt_flightNumber, flightNo);
		enterKeys(txt_flightDate, flightDate);
		click(btn_Listbtn);
		minWait();
		driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(info_msg).getText().contains("is closed. Do you want to continue"));
		click(btn_genericYes);
		minWait();
		waitForFrameAndSwitch(FRAME);
		return this;
		
		
 }
 

    /**
     * 
     * @return
     */
    public HomePage close() {

        click(btn_Closebtn);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}
