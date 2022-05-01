package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-6545 on 14/2/2018
 *  */
public class OPR063  extends BasePage{
	
	public String dataFilePath;
    public  String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public  String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
  
    public static String FRAME = "iCargoContentFrameOPR063";
   
    By
    txt_FlightPrefix,
    txt_FlightNo,
    txt_FlightDate,
    btn_List,
    msg_footer,
    yesBtn,
    Generic_btn_ok,
    info_error,
    Generic_info_msg,
    btn_save,
    tbl_uldDetails,
    tbl_bulkDetails,
    btn_sendProv,
    btn_sendFinal,
    btn_close,
    noBtn,
    btn_uldTag,
    btn_clear,
    lnk_blkAdd,
	lnk_blkModify,
	lnk_blkDelete,
	lnk_uldAdd,
	lnk_uldModify,
	lnk_uldDelete,
	txt_addModify_uldNo,
	dropdown_addModify_pou,
	btn_addModify_list,
	dropdown_addModify_contour,
	txt_addModify_tareWt,
	txt_addModify_actualWt,
	txt_addModify_netWt,
	btn_addModify_ok,
	btn_addModify_close,
	btn_print;

	WebDriver driver;    
	String testDataFile;
	String browser;
	private String key_awbNo;
	private String key_AWBNo_Prefix;

	public OPR063(WebDriver driver, String testDataFile) {
		 super(driver);
	     this.driver = driver;
	     this.testDataFile = testDataFile;
	     PageFactory.initElements(this.driver,this);
	     dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
	     initPageElements();
	}

	private void initPageElements() {
		// TODO Auto-generated method stub
	
		txt_FlightNo = MiscUtility.getWebElement(objFilepath,"OPR063_txt_FlightNo");
	    txt_FlightDate = MiscUtility.getWebElement(objFilepath,"OPR063_txt_FlightDate");
		btn_save = MiscUtility.getWebElement(objFilepath,"OPR063_btn_save");
		btn_close = MiscUtility.getWebElement(objFilepath,"OPR063_btn_close");
	    btn_List = MiscUtility.getWebElement(objFilepath,"OPR063_btn_List");
	    btn_clear = MiscUtility.getWebElement(objFilepath,"OPR063_btn_clear");
	    tbl_uldDetails = MiscUtility.getWebElement(objFilepath,"OPR063_btl_uldDetails");
	    btn_sendProv = MiscUtility.getWebElement(objFilepath,"OPR063_btn_sendProv");
	    btn_sendFinal = MiscUtility.getWebElement(objFilepath,"OPR063_btn_sendFinal");
	    tbl_bulkDetails= MiscUtility.getWebElement(objFilepath,"OPR063_tbl_bulkDetails");
		txt_FlightPrefix = MiscUtility.getWebElement(objFilepath,"OPR063_txt_FlightPrefix");
		msg_footer = MiscUtility.getWebElement(genObjPath,"Generic_foot_layer");
		btn_uldTag = MiscUtility.getWebElement(objFilepath,"OPR063_btn_uldTag");
		yesBtn = MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
		Generic_btn_ok= MiscUtility.getWebElement(genObjPath,"Generic_btn_ok");
		info_error= MiscUtility.getWebElement(genObjPath,"Generic_footer_error");
		Generic_info_msg= MiscUtility.getWebElement(genObjPath,"Generic_info_msg");
		
		lnk_blkAdd = MiscUtility.getWebElement(objFilepath,"OPR063_lnk_blkAdd");
		lnk_blkModify = MiscUtility.getWebElement(objFilepath,"OPR063_lnk_blkModify");
		lnk_blkDelete = MiscUtility.getWebElement(objFilepath,"OPR063_lnk_blkDelete");
		lnk_uldAdd = MiscUtility.getWebElement(objFilepath,"OPR063_lnk_uldAdd");
		lnk_uldModify = MiscUtility.getWebElement(objFilepath,"OPR063_lnk_uldModify");
		lnk_uldDelete = MiscUtility.getWebElement(objFilepath,"OPR063_lnk_uldDelete");
		txt_addModify_uldNo = MiscUtility.getWebElement(objFilepath,"OPR063_txt_addModify_uldNo");
		dropdown_addModify_pou = MiscUtility.getWebElement(objFilepath,"OPR063_dropdown_addModify_pou");
		btn_addModify_list = MiscUtility.getWebElement(objFilepath,"OPR063_btn_addModify_list");
		dropdown_addModify_contour = MiscUtility.getWebElement(objFilepath,"OPR063_dropdown_addModify_contour");
		txt_addModify_tareWt = MiscUtility.getWebElement(objFilepath,"OPR063_txt_addModify_tareWt");
		txt_addModify_actualWt = MiscUtility.getWebElement(objFilepath,"OPR063_txt_addModify_actualWt");
		txt_addModify_netWt = MiscUtility.getWebElement(objFilepath,"OPR063_txt_addModify_netWt");
		btn_addModify_ok = MiscUtility.getWebElement(objFilepath,"OPR063_btn_addModify_ok");
		btn_addModify_close = MiscUtility.getWebElement(objFilepath,"OPR063_btn_addModify_close");
		btn_print = MiscUtility.getWebElement(objFilepath,"OPR063_btn_print");
		
	}


	/**
	 * Method to list a flight and save the actual weight
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param ULDNo
	 * @return
	 * @author A-7868 Krishna <17/05/2018>
	 */
	public OPR063 savedetails_ULD(String carrierCode, String flightNo, String flightDate, String ULDNo){
	 
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		ULDNo = PropertyHandler.getPropValue(dataFilePath, ULDNo);
		
		list(carrierCode,flightNo,flightDate);
		
		String actualWt = tblGetTextByColValue(tbl_uldDetails, 9, 2, ULDNo);
		try{
			actualWt = String.valueOf(Integer.parseInt(actualWt) + 10);
		}catch(NumberFormatException e){
			actualWt = String.valueOf(Float.parseFloat(actualWt) + 10);
		}
		tblsetTextByColValue(tbl_uldDetails, 10, 2, ULDNo, actualWt); //Sets Actual weight = Gross Weight + 10;
		
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		return this;		      
	}

	
	/**
	 * Method to list a flight and save the actual weight
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @return
	 * @author A-7868 Krishna <17/05/2018>
	 */
	public OPR063 savedetails_BULK(String carrierCode, String flightNo, String flightDate){
	 
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
				
		list(carrierCode,flightNo,flightDate);
		
		String actualWt = tblGetTextByColValue(tbl_bulkDetails, 9, 2, "BULK");
		try{
			actualWt = String.valueOf(Integer.parseInt(actualWt) + 10);
		}catch(NumberFormatException e){
			actualWt = String.valueOf(Float.parseFloat(actualWt) + 10);
		}
		tblsetTextByColValue(tbl_bulkDetails, 10, 2, "BULK", actualWt);
		
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		return this;		      
	}
	
	/**
	 * Method to list a flight and save the actual weight
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @return
	 * @author A-7868 Krishna <17/05/2018>
	 */
	public OPR063 savedetails_BULK(String carrierCode, String flightNo, String flightDate, String barrow){
	 
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		barrow = PropertyHandler.getPropValue(dataFilePath, barrow);
		
		list(carrierCode,flightNo,flightDate);
		
		String actualWt = tblGetTextByColValue(tbl_bulkDetails, 6, 2, barrow);
		try{
			actualWt = String.valueOf(Integer.parseInt(actualWt) + 10);
		}catch(NumberFormatException e){
			actualWt = String.valueOf(Float.parseFloat(actualWt) + 10);
		}
		tblsetTextByColValue(tbl_bulkDetails, 7, 2, barrow, actualWt);
		
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		return this;		      
	}
	
	/**
	 * Method to list a flight and save the actual weight
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param ULDNo
	 * @return
	 * @author A-7868 Krishna <17/05/2018>
	 */
	public OPR063 savedetails_ULDandBULK(String carrierCode, String flightNo, String flightDate, String ULDNo){
	 
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		ULDNo = PropertyHandler.getPropValue(dataFilePath, ULDNo);
		
		list(carrierCode,flightNo,flightDate);
		
		String actualWt = tblGetTextByColValue(tbl_bulkDetails, 9, 2, "BULK");
		try{
			actualWt = String.valueOf(Integer.parseInt(actualWt) + 10);
		}catch(NumberFormatException e){
			actualWt = String.valueOf(Float.parseFloat(actualWt) + 10);
		}
		tblsetTextByColValue(tbl_bulkDetails, 10, 2, "BULK", actualWt);
		
		actualWt = tblGetTextByColValue(tbl_uldDetails, 9, 2, ULDNo);
		try{
			actualWt = String.valueOf(Integer.parseInt(actualWt) + 10);
		}catch(NumberFormatException e){
			actualWt = String.valueOf(Float.parseFloat(actualWt) + 10);
		}
		tblsetTextByColValue(tbl_uldDetails, 10, 2, ULDNo, actualWt);
		
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		return this;		      
	}
	
	/**
	 * Method to short capture a ULD
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param uldType
	 * @param uldNo
	 * @param pOU
	 * @param tareWt
	 * @param actualWt
	 * @param contour
	 * @param errorChk TODO
	 * @param errorMsg TODO
	 * @return
	 * @author A-7868 Krishna <17/05/2018>
	 */
	public OPR063 addNewULD(String carrierCode, String flightNo, String flightDate, String uldType, String uldNo, 
							String pOU, String tareWt, String actualWt, String contour, boolean errorChk, String errorMsg){
		 
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pOU = PropertyHandler.getPropValue(dataFilePath, pOU);
		uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
		tareWt = PropertyHandler.getPropValue(dataFilePath, tareWt);
		actualWt = PropertyHandler.getPropValue(dataFilePath, actualWt);
		contour = PropertyHandler.getPropValue(dataFilePath, contour);
		
		list(carrierCode,flightNo,flightDate);
		
		click(lnk_uldAdd);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		String newUld = BizUtility.createULDNum(uldType, carrierCode);
		enterKeys(txt_addModify_uldNo, newUld);
		try{
			selectByText(dropdown_addModify_pou, pOU);
		}catch(TimeoutException e){
			
		}
		click(btn_addModify_list);
		minWait();
		selectByText(dropdown_addModify_contour, contour);
		enterKeys(txt_addModify_tareWt, tareWt);
		enterKeys(txt_addModify_actualWt, actualWt);
		click(btn_addModify_ok);
		minWait();
		
		if(errorChk){
			Assert.assertTrue(waitForElement(info_error).getText().contains(errorMsg), "ERROR : Invalid Error Message.");
			click(btn_addModify_close);
			minWait();
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);
			return this;
		}
		
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
				
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		Assert.assertTrue(getTableColumnValues(tbl_uldDetails, 2).contains(newUld), "ERROR : ULD not added");
		PropertyHandler.setPropValue(dataFilePath, uldNo, newUld);
		return this;		      
	}
	
	/**
	 * Method to short capture BULK
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param pOU
	 * @param tareWt
	 * @param actualWt
	 * @param contour
	 * @param errorChk
	 * @param errorMsg
	 * @return
	 * @author A-7868 Krishna <25/05/2018>
	 */
	public OPR063 addNewBulk(String carrierCode, String flightNo, String flightDate, String pOU, 
								String actualWt, boolean errorChk, String errorMsg){
		
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pOU = PropertyHandler.getPropValue(dataFilePath, pOU);
		actualWt = PropertyHandler.getPropValue(dataFilePath, actualWt);
		
		list(carrierCode,flightNo,flightDate);
		
		click(lnk_blkAdd);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
				
		try{			
		selectByText(dropdown_addModify_pou, pOU);
		}catch(TimeoutException e){
		
		}
		click(btn_addModify_list);
		minWait();
		enterKeys(txt_addModify_actualWt, actualWt);
		click(btn_addModify_ok);
		minWait();
		
		if(errorChk){
		Assert.assertTrue(waitForElement(info_error).getText().contains(errorMsg), "ERROR : Invalid Error Message.");
		click(btn_addModify_close);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		return this;
		}
		
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);		
		
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
		click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		Assert.assertTrue(getTableColumnValues(tbl_bulkDetails, 2).contains("BULK/"+pOU), "ERROR : BULK not added");
		return this;		      
	}
	
	/**
	 * Metohd to delete a ULD
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param uldNo
	 * @return
	 * @author A-7868 Krishna <25/05/2018>
	 */
	public OPR063 deleteNewULD(String carrierCode, String flightNo, String flightDate, String uldNo){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		
		list(carrierCode,flightNo,flightDate);
		
		tblSelectRowByColValue(tbl_uldDetails, 1, 2, uldNo);
		click(lnk_uldDelete);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		Assert.assertFalse(getTableColumnValues(tbl_uldDetails, 2).contains(uldNo), "ERROR : ULD not deleted");
		return this;
	}
	
	/**
	 * Method to delete BULK
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @return
	 * @author A-7868 Krishna <25/05/2018>
	 */
	public OPR063 deleteNewBulk(String carrierCode, String flightNo, String flightDate, String pOU){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pOU = PropertyHandler.getPropValue(dataFilePath, pOU);
		
		list(carrierCode,flightNo,flightDate);
		
		tblSelectRowByColValue(tbl_bulkDetails, 1, 2, "BULK/"+pOU);
		click(lnk_blkDelete);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		Assert.assertFalse(getTableColumnValues(tbl_bulkDetails, 2).contains("BULK/"+pOU), "ERROR : BULK not deleted");
		return this;
	}
	
	/**
	 * Method to add five Empty ULDs and save
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param contour
	 * @param tareWt
	 * @param uldType
	 * @param uldNo1
	 * @param uldNo2
	 * @param uldNo3
	 * @param uldNo4
	 * @param uldNo5
	 * @return
	 * @author A-7868 Krishna <25/05/2018>
	 */
	public OPR063 addFiveEmptyULD(String carrierCode, String flightNo, String flightDate, String contour, String tareWt, String uldType, 
									String uldNo1, String uldNo2, String uldNo3, String uldNo4, String uldNo5){
		
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		tareWt = PropertyHandler.getPropValue(dataFilePath, tareWt);
		contour = PropertyHandler.getPropValue(dataFilePath, contour);
		uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
		
		list(carrierCode, flightNo, flightDate);
		
		String[] newUld = new String[5];
		
		for(int i=0; i<5;i++){
			
			click(lnk_uldAdd);
			minWait();
			driver.switchTo().defaultContent();
			waitForNewWindow(2);
			switchToSecondWindow();
			
			newUld[i] = BizUtility.createULDNum(uldType, carrierCode);
			enterKeys(txt_addModify_uldNo, newUld[i]);
			click(btn_addModify_list);
			minWait();
			selectByText(dropdown_addModify_contour, contour);
			enterKeys(txt_addModify_tareWt, tareWt);
			enterKeys(txt_addModify_actualWt, tareWt);
			click(btn_addModify_ok);
			minWait();
		
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);			
			Assert.assertTrue(getTableColumnValues(tbl_uldDetails, 2).contains(newUld[i]), "ERROR : ULD "+i+" not added");
		}
		
		PropertyHandler.setPropValue(dataFilePath, uldNo1, newUld[0]);
		PropertyHandler.setPropValue(dataFilePath, uldNo2, newUld[1]);
		PropertyHandler.setPropValue(dataFilePath, uldNo3, newUld[2]);
		PropertyHandler.setPropValue(dataFilePath, uldNo4, newUld[3]);
		PropertyHandler.setPropValue(dataFilePath, uldNo5, newUld[4]);
		
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		
		Assert.assertTrue(getTableColumnValues(tbl_uldDetails, 2).contains(newUld[0]), "ERROR : ULD1 not added");
		Assert.assertTrue(getTableColumnValues(tbl_uldDetails, 2).contains(newUld[1]), "ERROR : ULD2 not added");
		Assert.assertTrue(getTableColumnValues(tbl_uldDetails, 2).contains(newUld[2]), "ERROR : ULD3 not added");
		Assert.assertTrue(getTableColumnValues(tbl_uldDetails, 2).contains(newUld[3]), "ERROR : ULD4 not added");
		Assert.assertTrue(getTableColumnValues(tbl_uldDetails, 2).contains(newUld[4]), "ERROR : ULD5 not added");
		
		return this;
	}
	
	/**
	 * Try adding an existing ULD in the Add/Modify window and check for error message
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param uldNo
	 * @return
	 * @author A-7868 Krishna <23/05/2018>
	 */
	public OPR063 checkErrorOnAddingExistingULD(String carrierCode, String flightNo, String flightDate, String uldNo){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		
		list(carrierCode,flightNo,flightDate);
		
		click(lnk_uldAdd);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		enterKeys(txt_addModify_uldNo, uldNo);		
		click(btn_addModify_list);
		minWait();
		
		Assert.assertTrue(waitForElement(info_error).getText().contains("is already added"), "ERROR : No error message shown.");
		
		click(btn_addModify_close);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		
		return this;
	}
	
	/**
	 * Method to modify an existing ULD details
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param uldNo
	 * @param actualWt
	 * @return
	 * @author A-7868 Krishna <23/05/2018>
	 */
	public OPR063 modifyULD(String carrierCode, String flightNo, String flightDate, String uldNo, String actualWt){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		actualWt = PropertyHandler.getPropValue(dataFilePath, actualWt);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		
		list(carrierCode,flightNo,flightDate);
		
		String tareWt = tblGetTextByColValue(tbl_bulkDetails, 7, 2, uldNo);
		String actWt = tblGetTextByColValue_input(tbl_bulkDetails, 10, 2, uldNo);
		
		tblSelectRowByColValue(tbl_uldDetails, 1, 2, uldNo);
		click(lnk_uldModify);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		Assert.assertTrue(waitForElement(txt_addModify_tareWt).getAttribute("value").equals(tareWt), "ERROR : Tare wt value mismatch in Add/Modify window.");
		Assert.assertTrue(waitForElement(txt_addModify_actualWt).getAttribute("value").equals(actWt), "ERROR : Actual wt value mismatch in Add/Modify window.");
		
		//fields to update
		enterKeys(txt_addModify_actualWt, actualWt);
		
		click(btn_addModify_ok);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
							
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		Assert.assertTrue(tblGetTextByColValue_input(tbl_uldDetails, 10, 2, uldNo).equals(actualWt), "ERROR : Details not updated");
		return this;		      
		}
	
	/**
	 * Method to modify BULK details
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param actualWt
	 * @return
	 * @author A-7868 Krishna <23/05/2018>
	 */
	public OPR063 modifyBulk(String carrierCode, String flightNo, String flightDate, String actualWt){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		actualWt = PropertyHandler.getPropValue(dataFilePath, actualWt);
		
		list(carrierCode,flightNo,flightDate);
		
		String tareWt = tblGetTextByColValue(tbl_bulkDetails, 7, 2, "BULK");
		String actWt = tblGetTextByColValue_input(tbl_bulkDetails, 10, 2, "BULK");
		
		tblSelectRowByColValue(tbl_bulkDetails, 1, 2, "BULK");
		click(lnk_blkModify);
		minWait();
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		
		Assert.assertTrue(waitForElement(txt_addModify_tareWt).getAttribute("value").equals(tareWt), "ERROR : Tare wt value mismatch in Add/Modify window.");
		Assert.assertTrue(waitForElement(txt_addModify_actualWt).getAttribute("value").equals(actWt), "ERROR : Actual wt value mismatch in Add/Modify window.");
		
		//fields to update
		enterKeys(txt_addModify_actualWt, actualWt);
		
		click(btn_addModify_ok);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
					
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		Assert.assertTrue(tblGetTextByColValue_input(tbl_bulkDetails, 10, 2, "BULK").equals(actualWt), "ERROR : Details not updated");
		return this;		      
		}
	
	/**
	 * Method to list a flight and navigate to ULD Tag screen
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @return
	 * @author A-7868 Krishna <17/05/2018>
	 */
	public OPR013 listAndNavigateToULDTag(String carrierCode, String flightNo, String flightDate, String uldNo){
		
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		
		list(carrierCode, flightNo, flightDate);
		tblSelectRowByColValue(tbl_uldDetails, 1, 2, uldNo);
		click(btn_uldTag);
		
		return new OPR013(driver, testDataFile);
	}
	
	/**
	 * Created by a-6545 on 14/02/2018
	 */
	 public OPR063 list(String carrierCode, String flightNo, String flightDate){
							
	    enterKeys(txt_FlightPrefix,carrierCode);
		enterKeys(txt_FlightNo,flightNo);
		enterKeys(txt_FlightDate, flightDate);
    	click(btn_List);
    	minWait();
    	
    	return this;
	}
		
	 /**
	  * Method to list a flight and verify whether the assigned ULD is present in DWS
	  * @param carrCode
	  * @param fltNo
	  * @param uldNo
	  * @return
	  * @author a-7868 Krishna <16/03/2018>
	  */
	 public OPR063 verifyDWSDetails_ULD(String carrCode, String fltNo, String fltDt, String uldNo){
		 
		 carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		 fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		 fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		 uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		 
		 list(carrCode, fltNo, fltDt);
		 minWait();
		 
		 Assert.assertTrue(getTableColumnValues(tbl_uldDetails, 2).contains(uldNo),"ERROR : ULD Not listed in DWS.");
		 return this;
	 }
	 
	 /**
	  * Method to list a flight and verify whether the assigned BULK is present in DWS
	  * @param carrCode
	  * @param fltNo
	  * @param uldNo
	  * @return
	  * @author a-7868 Krishna <16/03/2018>
	  */
	 public OPR063 verifyDWSDetails_BULK(String carrCode, String fltNo, String fltDt){
		 
		 carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		 fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		 fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		 
		 list(carrCode, fltNo, fltDt);
		 minWait();
		 
		 Assert.assertTrue(getTableColumnValues(tbl_uldDetails, 2).contains("BULK"),"ERROR : BULK Not listed in DWS.");
		 return this;
	 }
	 
	 /**
	  * Method to list a flight and click "Send Provisional"
	  * @param carrCode
	  * @param fltNo
	  * @param fltDt
	  * @return
	  * @author a-7868 Krishna <16/03/2018>
	  */
	 public OPR063 sendProvisional(String carrCode, String fltNo, String fltDt){	
		 
		 carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		 fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		 fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		 
		 list(carrCode, fltNo, fltDt);
		 click(btn_sendProv);
		 minWait();
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(waitForElement(msg_footer).getText().contains("Message sent successfully"), "ERROR : Message not sent.");
		 waitForFrameAndSwitch(FRAME);
		 return this;
	}
	 
	 /**
	  * Method to list a flight and click "Send Final"
	  * @param carrCode
	  * @param fltNo
	  * @param fltDt
	  * @return
	  * @author a-7868 Krishna <16/03/2018>
	  */
	 public OPR063 sendFinal(String carrCode, String fltNo, String fltDt){	
		 
		 carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		 fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		 fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		 
		 list(carrCode, fltNo, fltDt);
		 click(btn_sendFinal);
		 minWait();
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(waitForElement(msg_footer).getText().contains("Message sent successfully"), "ERROR : Message not sent.");
		 waitForFrameAndSwitch(FRAME);
		 return this;
	}

	 /**
	  * Method to check Print button functionality (whether a second window appears on print button click)
	  * This doesn't cover the PDF verification
	  * @param carrierCode
	  * @param flightNo
	  * @param flightDate
	  * @return
	  * @author A-7868 Krishna <23/05/2018>
	  */
	 public OPR063 checkPrintBtnFunctionality(String carrierCode, String flightNo, String flightDate){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		
		list(carrierCode,flightNo,flightDate);
		
		click(btn_print);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		closeAndmoveToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		
		return this;
	 }
	 
	 /**
	  * Method to clear the screen contents
	  * @return
	  * @author A-7868 Krishna <18/05/2018>
	  */
	 public OPR063 clear() {
		 
		 click(btn_clear);
		 driver.switchTo().defaultContent();
		 if(verifyElementPresent(yesBtn))
			 click(yesBtn);
		 waitForFrameAndSwitch(FRAME);
		 return this;
	 }
	 
	 public HomePage close() {    	
	 	    
		 minWait();
	     click(btn_close);
	     driver.switchTo().defaultContent();
	     if(verifyElementPresent(yesBtn)){
	        click(yesBtn);
	        waitForFrameAndSwitch(FRAME);
	     }
	     return new HomePage(driver,testDataFile);
	 }
	
}
	