package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-6545 on 20/12/2017.
 */
public class CAP012 extends BasePage {

	
	
	 	public String dataFilePath;
	    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
	    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	  
	    public static String FRAME = "iCargoContentFrameCAP012";
	    
	    By	txt_allotId,
		    txt_allotStatus,
		    btn_list,
		    btn_clear,
		    txt_station,
		    txt_carrier_code,
		    txt_fltNum,
		    txt_origin,
		    txt_destn,
		    txt_sDate,
		    txt_eDate,
		    chk_freqChckAll,
		    txt_ctgry,
		    list_allotSubType,
		    list_shipType,
		    txt_wt,
		    txt_vol,
		    btn_save,
		    btn_close,
		    chk_freeSale,
		    dropdown_station,
		    tbl_chooseAllotmnt_prdAllotment,
		    btn_chooseAllotmnt_ok,
		    btn_chooseAllotmnt_close,
		    //yesBtn,
		    noBtn,
		    yesBtn,
					chkBx_utilAlertInt,
					chkBx_utilAlertExt,
					txt_utilAlertEmail;
	    
	    private By tbl_alt;
	    
	    private By  btn_cancelTerminate,
	    			btn_createOk,
	    			btn_cancelSave,
	    			txt_cancelRemarks,
	    			radio_cancel,
	    			radio_terminate;
	    			
	    
	    WebDriver driver;    
	    String testDataFile;
	    String browser;
	    
	    public CAP012(WebDriver driver, String dataFileName) {
			 super(driver);
	         this.driver = driver;
	         this.testDataFile = dataFileName;
	         PageFactory.initElements(this.driver,this);
	         dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+dataFileName;
	         initPageElements();
		}
	    
	    private void initPageElements(){	 
	        
	    	System.out.println("Going to capture all webElements..!");
	    	
	    	txt_allotId 	= MiscUtility.getWebElement(objFilepath,"CAP012_txt_allotId");
	    	txt_allotStatus	= MiscUtility.getWebElement(objFilepath,"CAP012_txt_allotStatus");
	    	btn_list		= MiscUtility.getWebElement(objFilepath,"CAP012_btn_list");
	    	btn_clear		= MiscUtility.getWebElement(objFilepath,"CAP012_btn_clear");
	    	txt_station 	= MiscUtility.getWebElement(objFilepath,"CAP012_txt_Station");
	    	txt_carrier_code= MiscUtility.getWebElement(objFilepath,"CAP012_txt_carrier_code");
	    	txt_fltNum		= MiscUtility.getWebElement(objFilepath,"CAP012_txt_FlightNo");
	    	txt_origin		= MiscUtility.getWebElement(objFilepath,"CAP012_txt_Origin");
	    	txt_destn		= MiscUtility.getWebElement(objFilepath,"CAP012_txt_Destination");
	    	txt_sDate		= MiscUtility.getWebElement(objFilepath,"CAP012_txt_StartDate");
	    	txt_eDate		= MiscUtility.getWebElement(objFilepath,"CAP012_txt_EndDate");
	    	chk_freqChckAll	= MiscUtility.getWebElement(objFilepath,"CAP012_chkBox_FrequencyAll");
	    	txt_ctgry		= MiscUtility.getWebElement(objFilepath,"CAP012_txt_Category");
	    	list_allotSubType= MiscUtility.getWebElement(objFilepath,"CAP012_list_AllotmentSubType");
	    	list_shipType	= MiscUtility.getWebElement(objFilepath,"CAP012_list_ShipType");
	    	txt_wt			= MiscUtility.getWebElement(objFilepath,"CAP012_Capacity_txt_Weight");
	    	txt_vol			= MiscUtility.getWebElement(objFilepath,"CAP012_Capacity_txt_Volume");
	    	btn_save		= MiscUtility.getWebElement(objFilepath,"CAP012_btn_Save");
	    	btn_close		= MiscUtility.getWebElement(objFilepath,"CAP012_btn_close");
			chkBx_utilAlertInt		= MiscUtility.getWebElement(objFilepath,"CAP012_chkBx_utilAlertInt");
			chkBx_utilAlertExt		= MiscUtility.getWebElement(objFilepath,"CAP012_chkBx_utilAlertExt");
			txt_utilAlertEmail		= MiscUtility.getWebElement(objFilepath,"CAP012_txt_utilAlertEmail");
			chk_freeSale	=	MiscUtility.getWebElement(objFilepath,"CAP012_chk_freeSale");
			dropdown_station = MiscUtility.getWebElement(objFilepath,"CAP012_dropdown_station");
						
	  		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
	  		
	  		tbl_alt= MiscUtility.getWebElement(objFilepath, "CAP012_tbl_alt");
	  		btn_cancelTerminate= MiscUtility.getWebElement(objFilepath, "CAP012_btn_cacelTerminate");
	  		btn_createOk = MiscUtility.getWebElement(objFilepath, "CAP027_Create_btn_ok");
	  		btn_cancelSave = MiscUtility.getWebElement(objFilepath, "CAP012_cancel_save");
	  		radio_cancel = MiscUtility.getWebElement(objFilepath, "CAP012_radio_cancel");
	  		radio_terminate= MiscUtility.getWebElement(objFilepath, "CAP012_radio_terminate");
	  		txt_cancelRemarks= MiscUtility.getWebElement(objFilepath, "CAP012_cancel_Remarks");
	  		
	    }

	/**
	 * Creates a station alotment
	 * @param key_carrierCode
	 * @param key_fltNum
	 * @param key_sDate
	 * @param key_eDate
	 * @param key_stn
	 * @param key_origin
	 * @param key_destn
	 * @param key_wt
	 * @param key_vol
	 * @param key_allotId
	 * @param utilAlert: not read from data sheet
	 * @return
	 */
	    public CAP012 createAllotment(String key_carrierCode, String key_fltNum, String key_sDate, 
	    		String key_eDate, String key_stn, String key_origin, String key_destn, 
	    		String key_wt, String key_vol, String key_allotId, String... utilAlert){
	    	
	    	String data_carrier_code 	= PropertyHandler.getPropValue(dataFilePath, key_carrierCode);
	    	String data_fltNum 			= PropertyHandler.getPropValue(dataFilePath, key_fltNum);
	    	String data_sDate			= PropertyHandler.getPropValue(dataFilePath, key_sDate);
	    	String data_eDate 			= PropertyHandler.getPropValue(dataFilePath, key_eDate);
	    	String data_stn				= PropertyHandler.getPropValue(dataFilePath, key_stn);
	    	String data_origin			= PropertyHandler.getPropValue(dataFilePath, key_origin);
	    	String data_destn 			= PropertyHandler.getPropValue(dataFilePath, key_destn);
	    	String data_wt 				= PropertyHandler.getPropValue(dataFilePath, key_wt);
	    	String data_vol 			= PropertyHandler.getPropValue(dataFilePath, key_vol);
	    	
	    	
	    	enterKeys(waitForElement(txt_station), data_stn);
	    	enterKeys(txt_carrier_code, data_carrier_code);
	    	enterKeys(txt_fltNum, data_fltNum);
	    	enterKeys(txt_origin, data_origin);
	    	enterKeys(txt_destn, data_destn);
	    	enterKeys(txt_sDate, data_sDate);
	    	enterKeys(txt_eDate, data_eDate);
	    	check(chk_freqChckAll);
	    	enterKeys(txt_wt, data_wt);
	    	enterKeys(txt_vol, data_vol);
	    	if (utilAlert.length != 0){
	    		if (utilAlert[0].equalsIgnoreCase("Internal")){
	    			check(chkBx_utilAlertInt);
	    			unCheck(chkBx_utilAlertExt);
				}
				else {
	    			check(chkBx_utilAlertExt);
	    			unCheck(chkBx_utilAlertInt);
	    			enterKeys(txt_utilAlertEmail,"test@test.com");
				}
			}
	    	click(btn_save);
	    	minWait();
	    	driver.switchTo().defaultContent();
	    	if (verifyElementPresent(yesBtn)) {
	            click(yesBtn);
	        }
	    	waitForFrameAndSwitch(FRAME);
	    	minWait();
	    	String allotId=waitForElement(txt_allotId).getAttribute("value");
	    	Assert.assertFalse(allotId.isEmpty(), "ERROR in Allotment ID creation.");
	    	System.out.println(allotId);
	    	PropertyHandler.setPropValue(dataFilePath, key_allotId, allotId);
	    	click(btn_clear);
	    	return this;
	    } 
	    
	    public CAP012 updateAllotment(String key_wt1, String key_allotId){
	    	
	    	String data_allotId = PropertyHandler.getPropValue(dataFilePath, key_allotId);	    	
	    	String data_wt1 	= PropertyHandler.getPropValue(dataFilePath, key_wt1);   	
	    	
	    	enterKeys(waitForElement(txt_allotId), data_allotId);	    	
	    	click(btn_list);
	    	//driver.switchTo().defaultContent();
	        minWait();	    	
	    	enterKeys(txt_wt, data_wt1);	    		    	
	    	click(btn_save);
	    	driver.switchTo().defaultContent();
	    	
	    	if (verifyElementPresent(yesBtn)) {
	            click(yesBtn);
	        }
	    	switchToFirstWindow();
	        waitForFrameAndSwitch(FRAME);
	    	String allotId=waitForElement(txt_allotId).getAttribute("value");
	    	Assert.assertFalse(allotId.isEmpty(), "ERROR in Allotment ID creation.");
	    	System.out.println(allotId);
	    	return this;
	    }
	    
	    public HomePage close() {

	    	minWait();
	    	Actions action = new Actions(driver);
	    	action.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).perform();  	 
	    	
	    	driver.switchTo().defaultContent();
	        if (verifyElementPresent(yesBtn)) {

	            click(yesBtn);
	        }
	        return new HomePage(driver,testDataFile);
	    }
	    
//********************************Allotment scripting changes ********************//
	    //*****************A-8260***********************************//
	    
	    public CAP012 verifyAllotmentDetails(String altId, String wt, String vol, String fltNo, String stn, String cat, String startDate, String endDate)
	    {
	    	altId=PropertyHandler.getPropValue(dataFilePath, altId);
	    	wt= PropertyHandler.getPropValue(dataFilePath, wt);
	    	vol=PropertyHandler.getPropValue(dataFilePath, vol);
	    	fltNo=PropertyHandler.getPropValue(dataFilePath, fltNo);
	    	stn=PropertyHandler.getPropValue(dataFilePath, stn);
	    	cat=PropertyHandler.getPropValue(dataFilePath, cat);
	    	startDate=PropertyHandler.getPropValue(dataFilePath, startDate);
	    	endDate=PropertyHandler.getPropValue(dataFilePath, endDate);
	    	
	    	enterKeys(waitForElement(txt_allotId), altId);	    	
	    	click(btn_list);
	    	minWait();
	    	System.out.println(waitForElement(txt_sDate).getAttribute("value"));
	    	
	    	Assert.assertTrue(waitForElement(txt_station).getAttribute("value").equals(stn),"station should be matched");
	    	Assert.assertTrue(waitForElement(txt_fltNum).getAttribute("value").equals(fltNo),"flight number should match");
	    	Assert.assertTrue(waitForElement(txt_sDate).getAttribute("value").equalsIgnoreCase(startDate),"start date should match");
	    	Assert.assertTrue(waitForElement(txt_eDate).getAttribute("value").equalsIgnoreCase(endDate),"enda date should match");
	    	Assert.assertTrue(waitForElement(txt_ctgry).getAttribute("value").equals(cat),"category should match");
	    	Assert.assertTrue(waitForElement(txt_wt).getAttribute("value").equals(wt),"weight should match");
	    	Assert.assertTrue(waitForElement(txt_vol).getAttribute("value").equals(vol),"vlolume should match");
	    	
	    	return this;
	    }
	    
	    /**
	     * @author A-8260
	     * Request Allotment script
	     */
	    public CAP012 requestAllotment(String key_carrierCode, String key_fltNum, String key_sDate, 
	    		String key_eDate, String key_stn, String key_origin, String key_destn, 
	    		String key_wt, String key_vol, String key_allotId, String status)
	    {
	    	String data_carrier_code 	= PropertyHandler.getPropValue(dataFilePath, key_carrierCode);
	    	String data_fltNum 			= PropertyHandler.getPropValue(dataFilePath, key_fltNum);
	    	String data_sDate			= PropertyHandler.getPropValue(dataFilePath, key_sDate);
	    	String data_eDate 			= PropertyHandler.getPropValue(dataFilePath, key_eDate);
	    	String data_stn				= PropertyHandler.getPropValue(dataFilePath, key_stn);
	    	String data_origin			= PropertyHandler.getPropValue(dataFilePath, key_origin);
	    	String data_destn 			= PropertyHandler.getPropValue(dataFilePath, key_destn);
	    	String data_wt 				= PropertyHandler.getPropValue(dataFilePath, key_wt);
	    	String data_vol 			= PropertyHandler.getPropValue(dataFilePath, key_vol);
	    	
	    	String tmp_allot			= PropertyHandler.getPropValue(dataFilePath, key_allotId);
	    	
	    	enterKeys(waitForElement(txt_station), data_stn);
	    	enterKeys(txt_carrier_code, data_carrier_code);
	    	enterKeys(txt_fltNum, data_fltNum);
	    	enterKeys(txt_origin, data_origin);
	    	enterKeys(txt_destn, data_destn);
	    	enterKeys(txt_sDate, data_sDate);
	    	enterKeys(txt_eDate, data_eDate);
	    	check(chk_freqChckAll);
	    	enterKeys(txt_wt, data_wt);
	    	enterKeys(txt_vol, data_vol);	    	
	    	click(btn_save);
	    	minWait();
	    	driver.switchTo().defaultContent();
	    	if (verifyElementPresent(yesBtn)) {
	            click(yesBtn);
	        }
	    	waitForFrameAndSwitch(FRAME);
//	    	enterKeys(txt_allotId, tmp_allot);
//	    	click(btn_list);
	    	minWait();
	    	String allotId=waitForElement(txt_allotId).getAttribute("value");
	    	Assert.assertFalse(allotId.isEmpty(), "ERROR in Allotment ID creation.");
	    	//System.out.println(tmp_allot);
	    	//PropertyHandler.setPropValue(dataFilePath, key_allotId, tmp_allot);
	    	PropertyHandler.setPropValue(dataFilePath, key_allotId, allotId);
	    	String stts=tblGetTextByColValue(tbl_alt, 18, 2,allotId);
	    	System.out.println("Allotment id: "+allotId);
	    	//String stts=tblGetTextByColValue(tbl_alt, 18, 2,tmp_allot);
	    	System.out.println(stts);
	    	if(status.equals("pending"))
	    	{
	    		Assert.assertTrue(stts.contains("Pending For Approval"), "Status should be pending for Approval");
	    	}
	    	System.out.println(status);
	    	//click(btn_clear);
	    	return this;
	    }
	    
	    
	    /**
	     * @author A-8260
	     * Modifies the allotment details
	     */
	    public CAP012 modifyAllotment(String altId,String newWt,String newVol)
	    {
	    	altId=PropertyHandler.getPropValue(dataFilePath, altId);
	    	newWt= PropertyHandler.getPropValue(dataFilePath, newWt);
	    	newVol=PropertyHandler.getPropValue(dataFilePath, newVol);
	    	
	    	enterKeys(waitForElement(txt_allotId), altId);	    	
	    	click(btn_list);
	    	enterKeys(txt_wt, newWt);
	    	enterKeys(txt_vol, newVol);
	    	click(btn_save);
	    	minWait();
	    	driver.switchTo().defaultContent();
	    	
	    	if (verifyElementPresent(yesBtn)) {
	            click(yesBtn);
	        }
	    	waitForFrameAndSwitch(FRAME);
	    	minWait();
	    	click(btn_clear);
	    	return this;
	    }
	    
	    
	    public CAP012 terminateAllotment(String altId,boolean terminate)
	    {
	    	altId=PropertyHandler.getPropValue(dataFilePath, altId);
	    	enterKeys(waitForElement(txt_allotId), altId);	    	
	    	click(btn_list);
	    	minWait();
	    	click(btn_cancelTerminate);
	    	driver.switchTo().defaultContent();
	    	if (verifyElementPresent(yesBtn)) 
	            click(yesBtn);
	    	waitForNewWindow(2);
	    	switchToSecondWindow();
	       if(terminate)
	    	   click(radio_terminate);
	       else
	    	   click(radio_cancel);
	       
	       enterKeys(txt_cancelRemarks, "remarks");
	       click(btn_cancelSave);
	       minWait();
	       switchToFirstWindow();
	       waitForFrameAndSwitch(FRAME);
	       
	       
	    	minWait();
	    	return this;
	    }
	    
	    /**
	     * Create station allotment with parameter for free sale enable/disable
	     * @param key_carrierCode
	     * @param key_fltNum
	     * @param key_sDate
	     * @param key_eDate
	     * @param key_stn
	     * @param key_origin
	     * @param key_destn
	     * @param key_wt
	     * @param key_vol
	     * @param key_allotId
	     * @param freeSale
	     * @param utilAlert
	     * @return
	     * @author A-7868 Krishna <04/06/2018>
	     */
	    public CAP012 createAllotment(String key_carrierCode, String key_fltNum, String key_sDate, 
	    		String key_eDate, String key_stn, String key_origin, String key_destn, String key_category,
	    		String key_wt, String key_vol, String key_allotId, boolean freeSale, String... utilAlert){
	    	
	    	String data_carrier_code 	= PropertyHandler.getPropValue(dataFilePath, key_carrierCode);
	    	String data_fltNum 			= PropertyHandler.getPropValue(dataFilePath, key_fltNum);
	    	String data_sDate			= PropertyHandler.getPropValue(dataFilePath, key_sDate);
	    	String data_eDate 			= PropertyHandler.getPropValue(dataFilePath, key_eDate);
	    	String data_stn				= PropertyHandler.getPropValue(dataFilePath, key_stn);
	    	String data_origin			= PropertyHandler.getPropValue(dataFilePath, key_origin);
	    	String data_destn 			= PropertyHandler.getPropValue(dataFilePath, key_destn);
	    	String data_category			= PropertyHandler.getPropValue(dataFilePath, key_category);
	    	String data_wt 				= PropertyHandler.getPropValue(dataFilePath, key_wt);
	    	String data_vol 			= PropertyHandler.getPropValue(dataFilePath, key_vol);
	    	
	    	
	    	enterKeys(waitForElement(txt_station), data_stn);
	    	enterKeys(txt_carrier_code, data_carrier_code);
	    	enterKeys(txt_fltNum, data_fltNum);
	    	enterKeys(txt_origin, data_origin);
	    	enterKeys(txt_destn, data_destn);
	    	enterKeys(txt_sDate, data_sDate);
	    	enterKeys(txt_eDate, data_eDate);
	    	check(chk_freqChckAll);
	    	enterKeys(txt_ctgry, data_category);
	    	enterKeys(txt_wt, data_wt);
	    	enterKeys(txt_vol, data_vol);
	    	if (utilAlert.length != 0){
	    		if (utilAlert[0].equalsIgnoreCase("Internal")){
	    			check(chkBx_utilAlertInt);
	    			unCheck(chkBx_utilAlertExt);
				}
				else {
	    			check(chkBx_utilAlertExt);
	    			unCheck(chkBx_utilAlertInt);
	    			enterKeys(txt_utilAlertEmail,"test@test.com");
				}
			}
	    	
	    	if(freeSale)
	    		check(chk_freeSale);
	    	else
	    		unCheck(chk_freeSale);
	    	
	    	click(btn_save);
	    	minWait();
	    	driver.switchTo().defaultContent();
	    	if (verifyElementPresent(yesBtn)) {
	            click(yesBtn);
	        }
	    	waitForFrameAndSwitch(FRAME);
	    	minWait();
	    	String allotId=waitForElement(txt_allotId).getAttribute("value");
	    	Assert.assertFalse(allotId.isEmpty(), "ERROR in Allotment ID creation.");
	    	System.out.println(allotId);
	    	PropertyHandler.setPropValue(dataFilePath, key_allotId, allotId);
	    	click(btn_clear);
	    	return this;
	    }
	    
	   
	    /**
	     * Method to create a Station Group allotment
	     * @param key_carrierCode
	     * @param key_fltNum
	     * @param key_sDate
	     * @param key_eDate
	     * @param key_stnGroup
	     * @param key_origin
	     * @param key_destn
	     * @param key_category
	     * @param key_wt
	     * @param key_vol
	     * @param key_allotId
	     * @param freeSale
	     * @param utilAlert
	     * @return
	     * @author A-7868 Krishna <04/06/2018>
	     */
	    public CAP012 createStationGroupAllotment(String key_carrierCode, String key_fltNum, String key_sDate, 
	    		String key_eDate, String key_stnGroup, String key_origin, String key_destn, String key_category,
	    		String key_wt, String key_vol, String key_allotId, boolean freeSale, String... utilAlert){
	    	
	    	String data_carrier_code 	= PropertyHandler.getPropValue(dataFilePath, key_carrierCode);
	    	String data_fltNum 			= PropertyHandler.getPropValue(dataFilePath, key_fltNum);
	    	String data_sDate			= PropertyHandler.getPropValue(dataFilePath, key_sDate);
	    	String data_eDate 			= PropertyHandler.getPropValue(dataFilePath, key_eDate);
	    	String data_stnGroup				= PropertyHandler.getPropValue(dataFilePath, key_stnGroup);
	    	String data_origin			= PropertyHandler.getPropValue(dataFilePath, key_origin);
	    	String data_destn 			= PropertyHandler.getPropValue(dataFilePath, key_destn);
	    	String data_category			= PropertyHandler.getPropValue(dataFilePath, key_category);
	    	String data_wt 				= PropertyHandler.getPropValue(dataFilePath, key_wt);
	    	String data_vol 			= PropertyHandler.getPropValue(dataFilePath, key_vol);
	    	
	    	selectByText(dropdown_station, "Station Group");
	    	enterKeys(waitForElement(txt_station), data_stnGroup);
	    	enterKeys(txt_carrier_code, data_carrier_code);
	    	enterKeys(txt_fltNum, data_fltNum);
	    	enterKeys(txt_origin, data_origin);
	    	enterKeys(txt_destn, data_destn);
	    	enterKeys(txt_sDate, data_sDate);
	    	enterKeys(txt_eDate, data_eDate);
	    	check(chk_freqChckAll);
	    	enterKeys(txt_ctgry, data_category);
	    	enterKeys(txt_wt, data_wt);
	    	enterKeys(txt_vol, data_vol);
	    	if (utilAlert.length != 0){
	    		if (utilAlert[0].equalsIgnoreCase("Internal")){
	    			check(chkBx_utilAlertInt);
	    			unCheck(chkBx_utilAlertExt);
				}
				else {
	    			check(chkBx_utilAlertExt);
	    			unCheck(chkBx_utilAlertInt);
	    			enterKeys(txt_utilAlertEmail,"test@test.com");
				}
			}
	    	
	    	if(freeSale)
	    		check(chk_freeSale);
	    	else
	    		unCheck(chk_freeSale);
	    	
	    	click(btn_save);
	    	minWait();
	    	driver.switchTo().defaultContent();
	    	if (verifyElementPresent(yesBtn)) {
	            click(yesBtn);
	        }
	    	waitForFrameAndSwitch(FRAME);
	    	minWait();
	    	String allotId=waitForElement(txt_allotId).getAttribute("value");
	    	Assert.assertFalse(allotId.isEmpty(), "ERROR in Allotment ID creation.");
	    	System.out.println(allotId);
	    	PropertyHandler.setPropValue(dataFilePath, key_allotId, allotId);
	    	click(btn_clear);
	    	return this;
	    } 
	    
	    /**
	     * Method to clear the screen contents
	     * @return
	     * @author A-7868 Krishna <04/06/2018>
	     */
	    public CAP012 clear(){
	    	
	    	click(btn_clear);
	    	minWait();
	    	driver.switchTo().defaultContent();
	    	if(verifyElementPresent(yesBtn))
	    		click(yesBtn);
	    	waitForFrameAndSwitch(FRAME);
	    	return this;
	    }
}


