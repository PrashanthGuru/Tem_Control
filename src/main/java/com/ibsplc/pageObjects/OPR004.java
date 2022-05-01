package com.ibsplc.pageObjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * PAGE OPR004 : Breakdown Flight
 *
 * @author a-7868
 */
public class OPR004 extends BasePage {
	
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameOPR004";
    WebDriver driver;
    String screenFrame="iCargoContentFrameOPR004";
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By txt_uldNum,
            txt_carrier,
            txt_fltNum,
            txt_date,
            btn_list,
            tbl_bdwn,
            txt_whLoc,
            txt_pcs,
            txt_wt,
            chk_thru,
            btn_save,
            btn_bdCmplt,
            btn_close,
            msg_saved,
            yesBtn,
            noBtn,
            info_erroMessage,
            table_breakdownDetails,
            txt_breakdownLoc,
            txt_dialogueContent,
		    icon_splitShipment,
		    splitShipment_txt_splitInto,
		    splitShipment_btn_ok,
		    splitShipment_btn_close,
    		splitShipment_txt_pieces,
	    	splitShipment_txt_weight,
	    	splitShipment_txt_su,
	    	splitShipment_txt_location,
	    	btn_clear,
	    	info_bdnLocn,
	    	chkbox_intact,
	    	info_manifestedPcs,
	    	info_manifestedWgt,
	    	btn_breakdownComplete,
		    btn_captureDamage,
		    addDamageDesc_txt_date,
		    addDamageDesc_txt_damageCode,
		    addDamageDesc_txt_damagePcs,
		    addDamageDesc_btn_ok,
		    addDamageDesc_btn_close,
		    chkbox_selectTableItem,
		    lnk_add,
		    addBreakdownDetails_txt_prefix,
		    addBreakdownDetails_txt_awbNo,
		    addBreakdownDetails_btn_list,
		    addBreakdownDetails_txt_origin,
		    addBreakdownDetails_txt_destination,
		    addBreakdownDetails_txt_stdPcs,
		    addBreakdownDetails_txt_stdWt,
		    addBreakdownDetails_txt_rcvdPcs,
		    addBreakdownDetails_txt_rcvdWt,
		    addBreakdownDetails_txt_loc,
		    addBreakdownDetails_btn_ok,
		    addBreakdownDetails_btn_close,
		    addBreakdownDetails_btn_delete,
		    txt_rcvdPcs,
		    txt_rcvdWgt,
		    lnk_delete,
		    info_msg,
		    info_breakdownCompleted,
		    txt_storageUnit,
		    info_su,
		    splitShipment_icon_location,
		    warehouseLocationLov_txt_locationCode,
		    warehouseLocationLov_btn_list,
		    warehouseLocationLov_chkbox_selectTableItem,
		    warehouseLocationLov_btn_ok;


    public OPR004(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    /**
     * Method to initialize page objects
     * on 26/12/2017
     *
     * @author a-7868
     */
    private void initElements() {
        txt_uldNum = MiscUtility.getWebElement(objFilepath, "OPR004_txt_uldNum");
        txt_carrier = MiscUtility.getWebElement(objFilepath, "OPR004_txt_carrierCode");
        txt_fltNum = MiscUtility.getWebElement(objFilepath, "OPR004_txt_fltNum");
        txt_date = MiscUtility.getWebElement(objFilepath, "OPR004_txt_date");
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR004_btn_list");
        tbl_bdwn = MiscUtility.getWebElement(objFilepath, "OPR004_tbl_bdDtls");
        txt_whLoc = MiscUtility.getWebElement(objFilepath, "OPR004_txt_whLoc0");
        txt_pcs = MiscUtility.getWebElement(objFilepath, "OPR004_txt_rcvdPcs0");
        txt_wt = MiscUtility.getWebElement(objFilepath, "OPR004_txt_rcvdWt0");
        chk_thru = MiscUtility.getWebElement(objFilepath, "OPR004_chk_thru");
        btn_save = MiscUtility.getWebElement(objFilepath, "OPR004_btn_save");
        btn_bdCmplt = MiscUtility.getWebElement(objFilepath, "OPR004_btn_bdComplete");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR004_btn_close");
        msg_saved = MiscUtility.getWebElement(objFilepath, "OPR004_msg_saved");
        info_msg =  MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        info_erroMessage = MiscUtility.getWebElement(genObjPath, "Generic_footer_error");
        table_breakdownDetails = MiscUtility.getWebElement(objFilepath, "OPR004_table_breakdownDetails");
        txt_breakdownLoc = MiscUtility.getWebElement(objFilepath, "OPR004_txt_breakdownLoc");
        txt_dialogueContent = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        icon_splitShipment = MiscUtility.getWebElement(objFilepath, "OPR004_icon_splitShipment");
        splitShipment_txt_splitInto = MiscUtility.getWebElement(objFilepath, "OPR004_SplitShipment_txt_splitInto");     
        splitShipment_txt_pieces = MiscUtility.getWebElement(objFilepath, "OPR004_SplitShipment_txt_pieces");
        splitShipment_txt_weight = MiscUtility.getWebElement(objFilepath, "OPR004_SplitShipment_txt_weight");
        splitShipment_txt_su = MiscUtility.getWebElement(objFilepath, "OPR004_SplitShipment_txt_su");
        splitShipment_txt_location = MiscUtility.getWebElement(objFilepath, "OPR004_SplitShipment_txt_location");
        splitShipment_btn_ok = MiscUtility.getWebElement(objFilepath, "OPR004_SplitShipment_btn_ok");
        splitShipment_btn_close = MiscUtility.getWebElement(objFilepath, "OPR004_SplitShipment_btn_close");
        btn_clear = MiscUtility.getWebElement(objFilepath, "OPR004_btn_clear");
        info_bdnLocn = MiscUtility.getWebElement(objFilepath, "OPR004_info_bdnLocn");
        chkbox_intact = MiscUtility.getWebElement(objFilepath, "OPR004_chkbox_intact");
        info_manifestedPcs = MiscUtility.getWebElement(objFilepath, "OPR004_info_manifestedPcs");
        info_manifestedWgt = MiscUtility.getWebElement(objFilepath, "OPR004_info_manifestedWgt");
        btn_breakdownComplete = MiscUtility.getWebElement(objFilepath, "OPR004_btn_breakdownComplete");
        btn_captureDamage = MiscUtility.getWebElement(objFilepath, "OPR004_btn_captureDamage");
        addDamageDesc_txt_date = MiscUtility.getWebElement(objFilepath, "OPR004_AddDamageDesc_txt_date");
        addDamageDesc_txt_damageCode = MiscUtility.getWebElement(objFilepath, "OPR004_AddDamageDesc_txt_damageCode");
        addDamageDesc_txt_damagePcs = MiscUtility.getWebElement(objFilepath, "OPR004_AddDamageDesc_txt_damagePcs");
        addDamageDesc_btn_ok = MiscUtility.getWebElement(objFilepath, "OPR004_AddDamageDesc_btn_ok");
        addDamageDesc_btn_close = MiscUtility.getWebElement(objFilepath, "OPR004_AddDamageDesc_btn_close");
        chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath, "OPR004_chkbox_selectTableItem");
        lnk_add = MiscUtility.getWebElement(objFilepath, "OPR004_lnk_add");
	    addBreakdownDetails_txt_prefix = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_txt_prefix");
	    addBreakdownDetails_txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_txt_awbNo");
	    addBreakdownDetails_btn_list = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_btn_list");
	    addBreakdownDetails_txt_origin = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_txt_origin");
	    addBreakdownDetails_txt_destination = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_txt_destination");
	    addBreakdownDetails_txt_stdPcs = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_txt_stdPcs");
	    addBreakdownDetails_txt_stdWt = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_txt_stdWt");
	    addBreakdownDetails_txt_rcvdPcs = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_txt_rcvdPcs");
	    addBreakdownDetails_txt_rcvdWt = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_txt_rcvdWt");
	    addBreakdownDetails_txt_loc = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_txt_loc");
	    addBreakdownDetails_btn_ok = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_btn_ok");
	    addBreakdownDetails_btn_close = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_btn_close");
	    addBreakdownDetails_btn_delete = MiscUtility.getWebElement(objFilepath, "OPR004_AddBreakdownDetails_btn_delete");
	    txt_rcvdPcs = MiscUtility.getWebElement(objFilepath, "OPR004_txt_rcvdPcs");
	    txt_rcvdWgt = MiscUtility.getWebElement(objFilepath, "OPR004_txt_rcvdWgt");
	    lnk_delete = MiscUtility.getWebElement(objFilepath, "OPR004_lnk_delete");
	    info_breakdownCompleted = MiscUtility.getWebElement(objFilepath, "OPR004_info_breakdownCompleted");
	    txt_storageUnit = MiscUtility.getWebElement(objFilepath, "OPR004_txt_storageUnit");
	    info_su = MiscUtility.getWebElement(objFilepath, "OPR004_info_su");
	    
	    splitShipment_icon_location = MiscUtility.getWebElement(objFilepath, "OPR004_splitShipment_icon_location");
	    warehouseLocationLov_txt_locationCode = MiscUtility.getWebElement(objFilepath, "OPR004_warehouseLocationLov_txt_locationCode");
	    warehouseLocationLov_btn_list = MiscUtility.getWebElement(objFilepath, "OPR004_warehouseLocationLov_btn_list");
	    warehouseLocationLov_chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath, "OPR004_warehouseLocationLov_chkbox_selectTableItem");
	    warehouseLocationLov_btn_ok = MiscUtility.getWebElement(objFilepath, "OPR004_warehouseLocationLov_btn_ok");
    }

    /**
     * Method to breakdown ULD with given pcs and wt, save and complete breakdown
     * on 26/12/2017
     *
     * @param uldNum
     * @param carrier
     * @param fltNum
     * @param date
     * @param whLoc
     * @param pcs
     * @param wt
     * @return
     * @author a-7868 A-7681(added thru flag)
     */
    public OPR004 breakdownFlt(String uldNum, String carrier, String fltNum, String date,
                               String whLoc, String pcs, String wt, boolean thru) {

        uldNum = PropertyHandler.getPropValue(dataFilePath, uldNum);
        carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
        fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
        date = PropertyHandler.getPropValue(dataFilePath, date);
        whLoc = PropertyHandler.getPropValue(dataFilePath, whLoc);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);

        list(uldNum, carrier, fltNum, date);
        Assert.assertTrue(verifyElementPresent(tbl_bdwn), "ERROR : Breakdown details table not listed.");

        enterKeys(txt_whLoc, whLoc);
        enterKeys(txt_pcs, pcs);
        enterKeys(txt_wt, wt);

        if (thru && !uldNum.equalsIgnoreCase("BULK")) {
            check(chk_thru);
        }

        click(btn_save);
        driver.switchTo().defaultContent();
        minWait();
        
        
     //   Assert.assertTrue(waitForElement(info_msg).getText().contains("Saved successfully"), "ERROR : In saving Breakdown details.");

        click(yesBtn);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        
        waitForFrameAndSwitch(FRAME);
        //click(btn_bdCmplt);
        //Assert.assertTrue(verifyElementPresent(btn_close), "ERROR : In Breakdown complete.");

        return this;
    }

    
	public OPR004 breakdownFltTestData(String uldNum, String carrier, String fltNum, String date, String whLoc,
			String pcs, String wt, boolean thru) {


		list(uldNum, carrier, fltNum, date);
		Assert.assertTrue(verifyElementPresent(tbl_bdwn), "ERROR : Breakdown details table not listed.");

		enterKeys(txt_whLoc, whLoc);
		enterKeys(txt_pcs, pcs);
		enterKeys(txt_wt, wt);

		if (thru && !uldNum.equalsIgnoreCase("BULK")) {
			check(chk_thru);
		}

		click(btn_save);
		driver.switchTo().defaultContent();
		minWait();

		// Assert.assertTrue(waitForElement(info_msg).getText().contains("Saved
		// successfully"), "ERROR : In saving Breakdown details.");

		click(yesBtn);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}

		waitForFrameAndSwitch(FRAME);
		// click(btn_bdCmplt);
		// Assert.assertTrue(verifyElementPresent(btn_close), "ERROR : In
		// Breakdown complete.");

		return this;
	}
    /**
     * Method to list the breakdown details
     * on 26/12/2017
     *
     * @param uldNum
     * @param carrier
     * @param fltNum
     * @param date
     * @author a-7868
     */
    public void list(String uldNum, String carrier, String fltNum, String date) {

        enterKeys(txt_uldNum, uldNum);
        enterKeys(txt_carrier, carrier);
        enterKeys(txt_fltNum, fltNum);
        enterKeys(txt_date, date+Keys.TAB);
        click(btn_list);
    }

    /**
     * Method to close current page and return to Homepae
     * returns the instance of Homepage
     *
     * @return
     * @author a-7868
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param expectedErrorMessage
     * @return
     */
    public OPR004 breakdownScreenErroMessage(String uldNo,String carrierCode, String flightNo, String flightDate, String expectedErrorMessage){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	expectedErrorMessage = PropertyHandler.getPropValue(dataFilePath, expectedErrorMessage);
    	try{
    		list(uldNo, carrierCode, flightNo, flightDate);
    	}catch(Exception e){
    		
    	}
    	minWait();
    	Assert.assertEquals(waitForElement(info_erroMessage).getText(), expectedErrorMessage);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbNo
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 checkShipementDetails(String uldNo,String carrierCode, String flightNo, String flightDate, String awbNo, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 11, 3, awbNo), pcs);
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 12, 3, awbNo), wgt);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbNo
     * @param breakdownLoc
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 saveAndRelist(String uldNo,String carrierCode, String flightNo, String flightDate, String awbNo, String breakdownLoc, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	int awbRowNum = getTableRowNumber(table_breakdownDetails, 3, awbNo);
    	awbRowNum--;
    	enterKeys(getWebElements(txt_breakdownLoc).get(awbRowNum), breakdownLoc);
    	enterKeys(getWebElements(txt_rcvdPcs).get(awbRowNum), pcs);
    	enterKeys(getWebElements(txt_rcvdWgt).get(awbRowNum), wgt);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 11, 3, awbNo), pcs);
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 12, 3, awbNo), wgt);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbNo
     * @param breakdownLoc
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 saveAndNoRelist(String uldNo,String carrierCode, String flightNo, String flightDate, String awbNo, String breakdownLoc, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	enterKeys(txt_breakdownLoc, breakdownLoc);
    	enterKeys(txt_pcs, pcs);
    	enterKeys(txt_wt, wgt);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(noBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertFalse(isElementPresent(txt_pcs));
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param splitInto
     * @return
     */
    public OPR004 checkFunctionalityOfSplitIntoField(String uldNo, String carrierCode, String flightNo, String flightDate, String splitInto){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	splitInto = PropertyHandler.getPropValue(dataFilePath, splitInto);
    	
    	enterKeys(waitForElement(txt_uldNum), uldNo);
    	enterKeys(txt_carrier, carrierCode);
    	enterKeys(txt_fltNum, flightNo);
    	enterKeys(txt_date, flightDate);
    	click(btn_list);
    	minWait();
    	click(icon_splitShipment);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(splitShipment_txt_splitInto), splitInto);
    	enterKeys(splitShipment_txt_splitInto, Keys.TAB);
    	minWait();
    	Assert.assertTrue(getWebElements(splitShipment_txt_pieces).get(Integer.parseInt(splitInto)-1).isDisplayed());
    	click(splitShipment_btn_close);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);   	
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param splitPiece1
     * @param splitWeight1
     * @param location1
     * @param splitPiece2
     * @param splitWeight2
     * @return
     */
    public OPR004 checkInvalidLocationValidationInSplitShipmentPopup(String uldNo, String carrierCode, String flightNo, String flightDate, String splitPiece1, String splitWeight1, String location1, String splitPiece2, String splitWeight2){
    	String invalidLocation = "INV_L";
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	splitPiece1 = PropertyHandler.getPropValue(dataFilePath, splitPiece1);
    	splitWeight1 = PropertyHandler.getPropValue(dataFilePath, splitWeight1);
    	location1 = PropertyHandler.getPropValue(dataFilePath, location1);
    	splitWeight2 = PropertyHandler.getPropValue(dataFilePath, splitWeight2);
    	splitPiece2 = PropertyHandler.getPropValue(dataFilePath, splitPiece2);
    	
    	enterKeys(waitForElement(txt_uldNum), uldNo);
    	enterKeys(txt_carrier, carrierCode);
    	enterKeys(txt_fltNum, flightNo);
    	enterKeys(txt_date, flightDate);
    	click(btn_list);
    	minWait();
    	click(icon_splitShipment);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(splitShipment_txt_splitInto), "2");
    	enterKeys(splitShipment_txt_splitInto, Keys.TAB);
    	minWait();
    	enterKeys(getWebElements(splitShipment_txt_pieces).get(0), splitPiece1);
    	enterKeys(getWebElements(splitShipment_txt_weight).get(0), splitWeight1);
    	enterKeys(getWebElements(splitShipment_txt_location).get(0), location1);
    	enterKeys(getWebElements(splitShipment_txt_pieces).get(1), splitPiece2);
    	enterKeys(getWebElements(splitShipment_txt_weight).get(1), splitWeight2);
    	enterKeys(getWebElements(splitShipment_txt_location).get(1), invalidLocation);
    	click(splitShipment_btn_ok);
    	Assert.assertEquals(waitForElement(info_erroMessage).getText(),"Invalid Location(s) "+invalidLocation);
    	click(splitShipment_btn_close);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);   	
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param splitPiece1
     * @param splitWeight1
     * @param location1
     * @param splitPiece2
     * @param splitWeight2
     * @return
     */
    public OPR004 checkDuplicateLocationValidationInSplitShipmentPopup(String uldNo, String carrierCode, String flightNo, String flightDate, String splitPiece1, String splitWeight1, String location1, String splitPiece2, String splitWeight2){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	splitPiece1 = PropertyHandler.getPropValue(dataFilePath, splitPiece1);
    	splitWeight1 = PropertyHandler.getPropValue(dataFilePath, splitWeight1);
    	location1 = PropertyHandler.getPropValue(dataFilePath, location1);
    	splitWeight2 = PropertyHandler.getPropValue(dataFilePath, splitWeight2);
    	splitPiece2 = PropertyHandler.getPropValue(dataFilePath, splitPiece2);
    	
    	enterKeys(waitForElement(txt_uldNum), uldNo);
    	enterKeys(txt_carrier, carrierCode);
    	enterKeys(txt_fltNum, flightNo);
    	enterKeys(txt_date, flightDate);
    	click(btn_list);
    	minWait();
    	click(icon_splitShipment);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(splitShipment_txt_splitInto), "2");
    	enterKeys(splitShipment_txt_splitInto, Keys.TAB);
    	minWait();
    	enterKeys(getWebElements(splitShipment_txt_pieces).get(0), splitPiece1);
    	enterKeys(getWebElements(splitShipment_txt_weight).get(0), splitWeight1);
    	enterKeys(getWebElements(splitShipment_txt_location).get(0), location1);
    	enterKeys(getWebElements(splitShipment_txt_pieces).get(1), splitPiece2);
    	enterKeys(getWebElements(splitShipment_txt_weight).get(1), splitWeight2);
    	enterKeys(getWebElements(splitShipment_txt_location).get(1), location1);
    	click(splitShipment_btn_ok);
    	Assert.assertEquals(waitForElement(info_erroMessage).getText(),"Duplicate Location(s) specified");
    	click(splitShipment_btn_close);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);   	
    	return this;
    }
    
    /**
     * Created by A-7605
     * @return
     */
    public OPR004 clear(){
    	minWait();
    	click(btn_clear);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        return this;
    }
    
    /**
     * Created by A-7605
     * @return
     */
    public OPR004 checkIfFieldsAreCleared(){
    	Assert.assertEquals(waitForElement(txt_uldNum).getAttribute("value").trim().length(), 0);
    	Assert.assertEquals(waitForElement(txt_carrier).getAttribute("value").trim().length(), 0);
    	Assert.assertEquals(waitForElement(txt_fltNum).getAttribute("value").trim().length(), 0);
    	Assert.assertEquals(waitForElement(txt_date).getAttribute("value").trim().length(), 0);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param splitPiece1
     * @param splitWeight1
     * @param splitLocation1
     * @param splitPiece2
     * @param splitWeight2
     * @param splitLocation2
     * @return
     */ 
    public OPR004 splitPiecesIntoTwoLocations(String uldNo, String carrierCode, String flightNo, String flightDate, String splitPiece1, String splitWeight1, String storageUnit1, String splitLocation1, String splitPiece2, String splitWeight2,String storageUnit2, String splitLocation2){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	splitPiece1 = PropertyHandler.getPropValue(dataFilePath, splitPiece1);
    	splitWeight1 = PropertyHandler.getPropValue(dataFilePath, splitWeight1);
    	splitLocation1 = PropertyHandler.getPropValue(dataFilePath, splitLocation1);
    	splitWeight2 = PropertyHandler.getPropValue(dataFilePath, splitWeight2);
    	splitPiece2 = PropertyHandler.getPropValue(dataFilePath, splitPiece2);
    	splitLocation2 = PropertyHandler.getPropValue(dataFilePath, splitLocation2);
    	storageUnit1 = PropertyHandler.getPropValue(dataFilePath, storageUnit1);
    	storageUnit2 = PropertyHandler.getPropValue(dataFilePath, storageUnit2);
    	
    	enterKeys(waitForElement(txt_uldNum), uldNo);
    	enterKeys(txt_carrier, carrierCode);
    	enterKeys(txt_fltNum, flightNo);
    	enterKeys(txt_date, flightDate);
    	click(btn_list);
    	minWait();
    	click(icon_splitShipment);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(splitShipment_txt_splitInto), "2");
    	enterKeys(splitShipment_txt_splitInto, Keys.TAB);
    	minWait();
    	enterKeys(getWebElements(splitShipment_txt_pieces).get(0), splitPiece1);
    	enterKeys(getWebElements(splitShipment_txt_weight).get(0), splitWeight1);
    	if(storageUnit1 != null && storageUnit1.trim().length()>0)
    		enterKeys(getWebElements(splitShipment_txt_su).get(0), storageUnit1);
    	selectSplitLocation(1, splitLocation1);
//    	enterKeys(getWebElements(splitShipment_txt_location).get(0), splitLocation1);
    	enterKeys(getWebElements(splitShipment_txt_pieces).get(1), splitPiece2);
    	enterKeys(getWebElements(splitShipment_txt_weight).get(1), splitWeight2);
    	if(storageUnit2 != null && storageUnit2.trim().length()>0)
    		enterKeys(getWebElements(splitShipment_txt_su).get(1), storageUnit2);
    	selectSplitLocation(2, splitLocation2);
//    	enterKeys(getWebElements(splitShipment_txt_location).get(1), splitLocation2);
    	click(splitShipment_btn_ok);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertTrue(waitForElement(info_bdnLocn).getText().contains(splitLocation1+"("+splitPiece1+"/"+splitWeight1+".0)"));
    	Assert.assertTrue(waitForElement(info_bdnLocn).getText().contains(splitLocation2+"("+splitPiece2+"/"+splitWeight2+".0"));
    	return this;
    }
    
    private void selectSplitLocation(int rowNumber, String location){
    	click(getWebElements(splitShipment_icon_location).get(rowNumber-1));
    	waitForNewWindow(3);
    	switchToNthWindow(3);
    	enterKeys(warehouseLocationLov_txt_locationCode, location);
    	click(warehouseLocationLov_btn_list);
    	check(warehouseLocationLov_chkbox_selectTableItem);
    	click(warehouseLocationLov_btn_ok);
    	switchToSecondWindow();
    	return;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param breakdownLocation
     * @param recvdPcs
     * @param recvdWeight
     * @return
     */
    public OPR004 saveULDAsIntact(String uldNo, String carrierCode, String flightNo, String flightDate,
    		String breakdownLocation, String recvdPcs, String recvdWeight){
    	
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	breakdownLocation = PropertyHandler.getPropValue(dataFilePath, breakdownLocation);
    	recvdPcs = PropertyHandler.getPropValue(dataFilePath, recvdPcs);
    	recvdWeight = PropertyHandler.getPropValue(dataFilePath, recvdWeight);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	enterKeys(txt_breakdownLoc, breakdownLocation);
    	enterKeys(txt_pcs, recvdPcs);
    	enterKeys(txt_wt, recvdWeight);
    	minWait();
    	try{
    		check(chkbox_intact);
    	}catch(StaleElementReferenceException e){}
    	minWait();
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElementVisible(chkbox_intact).getAttribute("checked"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @return
     */
    public OPR004 verifyIntactCheckboxDisabled(){
    	Assert.assertEquals(waitForElementVisible(chkbox_intact).getAttribute("disabled"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNum
     * @param carrier
     * @param fltNum
     * @param date
     * @return
     */
    public OPR004 reList(String uldNum, String carrier, String fltNum, String date) {
    	uldNum = PropertyHandler.getPropValue(dataFilePath, uldNum);
    	carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
    	fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
    	date = PropertyHandler.getPropValue(dataFilePath, date);
    	list(uldNum, carrier, fltNum, date);
        return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param manifestedPcs
     * @param manifestedWgt
     * @return
     */
    public OPR004 checkValidationOnClickingThruCheckboxIfAWBDestinationSameAsLoggedInStation(String uldNo, String carrierCode, String flightNo, String flightDate, String manifestedPcs, String manifestedWgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	manifestedPcs = PropertyHandler.getPropValue(dataFilePath, manifestedPcs);
    	manifestedWgt = PropertyHandler.getPropValue(dataFilePath, manifestedWgt);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	Assert.assertEquals(waitForElement(info_manifestedPcs).getText(), manifestedPcs);
    	Assert.assertEquals(waitForElement(info_manifestedWgt).getText(), manifestedWgt);
    	try{
    		check(chk_thru);
    	}catch(StaleElementReferenceException e){}
    	minWait();
    	Assert.assertEquals(waitForElement(info_erroMessage).getText(), "Cannot mark the ULD as Thru since there are terminating shipments in it.");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param manifestedPcs
     * @param manifestedWgt
     * @return
     */
    public OPR004 checkValidationOnClickingIntactCheckboxIfAWBDestinationDifferentFromLoggedInStation(String uldNo, String carrierCode, String flightNo, String flightDate, String manifestedPcs, String manifestedWgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	manifestedPcs = PropertyHandler.getPropValue(dataFilePath, manifestedPcs);
    	manifestedWgt = PropertyHandler.getPropValue(dataFilePath, manifestedWgt);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	Assert.assertEquals(waitForElement(info_manifestedPcs).getText(), manifestedPcs);
    	Assert.assertEquals(waitForElement(info_manifestedWgt).getText(), manifestedWgt);
    	try{
    		check(chkbox_intact);
    	}catch(StaleElementReferenceException e){}
    	Assert.assertEquals(waitForElement(info_erroMessage).getText(), "The ULD has transhipment AWBs associated with it.");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param breakdownLocation
     * @param recvdPcs
     * @param recvdWeight
     * @return
     */
    public OPR004 saveULDAsThru(String uldNo, String carrierCode, String flightNo, String flightDate,
    		String breakdownLocation, String recvdPcs, String recvdWeight){
    	
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	breakdownLocation = PropertyHandler.getPropValue(dataFilePath, breakdownLocation);
    	recvdPcs = PropertyHandler.getPropValue(dataFilePath, recvdPcs);
    	recvdWeight = PropertyHandler.getPropValue(dataFilePath, recvdWeight);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	enterKeys(txt_breakdownLoc, breakdownLocation);
    	enterKeys(txt_pcs, recvdPcs);
    	enterKeys(txt_wt, recvdWeight);
    	minWait();
    	try{
    		check(chk_thru);
    	}catch(StaleElementReferenceException e){}
    	minWait();
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElementVisible(chk_thru).getAttribute("checked"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @return
     */
    public OPR004 verifyThruCheckboxDisabled(){
    	Assert.assertEquals(waitForElementVisible(chk_thru).getAttribute("disabled"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbNo
     * @param bdnLocn
     * @param rcvdPcs
     * @param rcvdWeight
     * @param mftPcs
     * @param mftWeight
     * @return
     */
    public OPR004 verifyBreakdownDetails(String uldNo, String carrierCode, String flightNo, String flightDate, String awbNo, String bdnLocn, String rcvdPcs, String rcvdWeight,
    		String mftPcs, String mftWeight){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	bdnLocn = PropertyHandler.getPropValue(dataFilePath, bdnLocn);
    	rcvdPcs = PropertyHandler.getPropValue(dataFilePath, rcvdPcs);
    	rcvdWeight = PropertyHandler.getPropValue(dataFilePath, rcvdWeight);
    	mftPcs = PropertyHandler.getPropValue(dataFilePath, mftPcs);
    	mftWeight = PropertyHandler.getPropValue(dataFilePath, mftWeight);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 11, 3, awbNo), mftPcs);
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 12, 3, awbNo), mftWeight);
    	Assert.assertEquals(waitForElement(txt_breakdownLoc).getAttribute("value"), bdnLocn);
    	Assert.assertEquals(waitForElement(txt_pcs).getAttribute("value"), rcvdPcs);
    	Assert.assertEquals(waitForElement(txt_wt).getAttribute("value"), rcvdWeight);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param breakdownLoc
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 saveDetails(String uldNo,String carrierCode, String flightNo, String flightDate, String breakdownLoc, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	enterKeys(txt_breakdownLoc, breakdownLoc);
    	enterKeys(txt_pcs, pcs);
    	enterKeys(txt_wt, wgt);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 markShipmentAsThru(String uldNo, String carrierCode, String flightNo, String flightDate){
    	
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	try{
    		check(chk_thru);
    	}catch(StaleElementReferenceException e){}
    	minWait();
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElementVisible(chk_thru).getAttribute("checked"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 markShipmentAsIntact(String uldNo, String carrierCode, String flightNo, String flightDate){
    	
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	try{
    		check(chkbox_intact);
    	}catch(StaleElementReferenceException e){}
    	minWait();
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElementVisible(chkbox_intact).getAttribute("checked"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @return
     */
    public OPR004 verifyIntactCheckboxChecked(){
    	Assert.assertEquals(waitForElementVisible(chkbox_intact).getAttribute("checked"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @return
     */
    public OPR004 verifyThruCheckboxChecked(){
    	Assert.assertEquals(waitForElementVisible(chk_thru).getAttribute("checked"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param manifestedPcs
     * @param manifestedWgt
     * @return
     */
    public OPR004 checkValidationOnClickingThruCheckboxForBulkShipment(String uldNo, String carrierCode, String flightNo, String flightDate, String manifestedPcs, String manifestedWgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	manifestedPcs = PropertyHandler.getPropValue(dataFilePath, manifestedPcs);
    	manifestedWgt = PropertyHandler.getPropValue(dataFilePath, manifestedWgt);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	Assert.assertEquals(waitForElement(info_manifestedPcs).getText(), manifestedPcs);
    	Assert.assertEquals(waitForElement(info_manifestedWgt).getText(), manifestedWgt);
    	try{
    		check(chk_thru);
    	}catch(StaleElementReferenceException e){}
    	minWait();
    	Assert.assertEquals(waitForElement(info_erroMessage).getText(), "Cannot mark Bulk as Thru");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param manifestedPcs
     * @param manifestedWgt
     * @return
     */
    public OPR004 checkValidationOnClickingIntactCheckboxForBulkShipment(String uldNo, String carrierCode, String flightNo, String flightDate, String manifestedPcs, String manifestedWgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	manifestedPcs = PropertyHandler.getPropValue(dataFilePath, manifestedPcs);
    	manifestedWgt = PropertyHandler.getPropValue(dataFilePath, manifestedWgt);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	Assert.assertEquals(waitForElement(info_manifestedPcs).getText(), manifestedPcs);
    	Assert.assertEquals(waitForElement(info_manifestedWgt).getText(), manifestedWgt);
    	try{
    		check(chkbox_intact);
    	}catch(StaleElementReferenceException e){}
    	minWait();
    	Assert.assertEquals(waitForElement(info_erroMessage).getText(), "Cannot mark Bulk as Intact");
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param breakdownLoc
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 BreakdownComplete(String uldNo,String carrierCode, String flightNo, String flightDate, String storageUnit, String breakdownLoc, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
//    	storageUnit = PropertyHandler.getPropValue(dataFilePath, storageUnit);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	maxWait();
    	try{
    		handleAlert("Accept", "OPR004");
    		waitForFrameAndSwitch(screenFrame);
    	}catch(Exception e){
    		waitForFrameAndSwitch(screenFrame);
    	}
    /*	if(storageUnit != null && storageUnit.trim().length()>0)
    		enterKeys(txt_storageUnit, storageUnit);*/
    try{
    	driver.findElement(txt_breakdownLoc).click();
//    	driver.findElement(txt_breakdownLoc).clear();
//    	enterKeys(txt_breakdownLoc, breakdownLoc);
    	driver.findElement(txt_breakdownLoc).sendKeys(breakdownLoc);
    	driver.findElement(txt_pcs).sendKeys(pcs);
    	driver.findElement(txt_wt).sendKeys(wgt);
    	/*enterKeys(txt_pcs, pcs);
    	enterKeys(txt_wt, wgt);*/
    	}catch(Exception e){
    		logger.info("Locator locked to enter data");
    	}
    	click(btn_breakdownComplete);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_uldNum).getAttribute("value").trim().length(), 0);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param damageDate
     * @param damageCode
     * @param damagePcs
     * @return
     */
    public OPR004 captureDamage(String uldNo,String carrierCode, String flightNo, String flightDate, String damageDate, String damageCode, String damagePcs){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	damageDate = PropertyHandler.getPropValue(dataFilePath, damageDate);
    	damageCode = PropertyHandler.getPropValue(dataFilePath, damageCode);
    	damagePcs = PropertyHandler.getPropValue(dataFilePath, damagePcs);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(btn_captureDamage);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(addDamageDesc_txt_date), damageDate);
    	enterKeys(waitForElement(addDamageDesc_txt_damageCode), damageCode);
    	enterKeys(waitForElement(addDamageDesc_txt_damagePcs), damagePcs);
    	click(addDamageDesc_btn_ok);
    	switchToFirstWindow();
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(getTableCellValue(table_breakdownDetails, 13, 1), "Y");
    	return this;
    }


	/**
	 * Created by A-7681
	 * @param awbNo
	 * @param damageDate
	 * @param damageCode
	 * @param damagePcs
	 * @return
	 */
	public OPR004 captureDamageFromOPR014(String awbNo, String damageDate, String damageCode, String damagePcs){
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		damageDate = PropertyHandler.getPropValue(dataFilePath, damageDate);
		damageCode = PropertyHandler.getPropValue(dataFilePath, damageCode);
		damagePcs = PropertyHandler.getPropValue(dataFilePath, damagePcs);

		minWait();
//		check(chkbox_selectTableItem);
		tblSelectRowByColValue(table_breakdownDetails,1,3,awbNo);
		click(btn_captureDamage);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(addDamageDesc_txt_date, damageDate);
		enterKeys(addDamageDesc_txt_damageCode, damageCode);
		enterKeys(addDamageDesc_txt_damagePcs, damagePcs);
		click(addDamageDesc_btn_ok);
		switchToFirstWindow();
		minWait();
		waitForFrameAndSwitch("iCargoContentFrameOPR014");
		click(btn_save);
		driver.switchTo().defaultContent();
		Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
		click(yesBtn);
		waitForFrameAndSwitch("iCargoContentFrameOPR014");
		minWait();
		Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 13, 3,awbNo), "Y","The Damage is not captured for AWB No: " + awbNo);
		return this;
	}

	/**
	 * Method to close current page and return to OPR014
	 *
	 * @return
	 * @author a-7681
	 */
	public OPR014 closeToOPR014() {

		click(btn_close);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		waitForFrameAndSwitch("iCargoContentFrameOPR014");
		return new OPR014(driver, dataFileName);
	}


    /**
     * Created by A-7605 on 31-01-18
     * This method is used to short capture a new AWB
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbPrefix
     * @param awbNo
     * @param origin
     * @param destination
     * @param pcs
     * @param weight
     * @param location
     * @return
     */
    public OPR004 shortCaptureAWB(String uldNo, String carrierCode, String flightNo, String flightDate, String awbPrefix, String awbNo,
    		String origin, String destination, String pcs, String weight, String location){
    	
    	
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
    	destination = PropertyHandler.getPropValue(dataFilePath, destination);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	weight = PropertyHandler.getPropValue(dataFilePath, weight);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	click(lnk_add);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(addBreakdownDetails_txt_prefix), awbPrefix);
    	enterKeys(addBreakdownDetails_txt_awbNo, awbNo);
    	click(addBreakdownDetails_btn_list);
    	click(waitForElement(yesBtn));
    	enterKeys(addBreakdownDetails_txt_origin, origin);
    	enterKeys(addBreakdownDetails_txt_destination, destination);
    	enterKeys(addBreakdownDetails_txt_stdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_stdWt, weight);
    	enterKeys(addBreakdownDetails_txt_rcvdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_rcvdWt, weight);
    	enterKeys(addBreakdownDetails_txt_loc, location);
    	click(addBreakdownDetails_btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 11, 3, awbNo), "0 *");
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 12, 3, awbNo), "0");
    	return this;
    }
    
    
    /**
     * Created by A-7605 on 31-01-18
     * This method verify the manifested piece and weight in a single AWB
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbNo
     * @param manifestedPcs
     * @param manifestedWgt
     * @return
     */
    public OPR004 verifyManifestDetails(String uldNo, String carrierCode, String flightNo, String flightDate,String awbNo, String manifestedPcs, String manifestedWgt){
    	
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	manifestedPcs = PropertyHandler.getPropValue(dataFilePath, manifestedPcs);
    	manifestedWgt = PropertyHandler.getPropValue(dataFilePath, manifestedWgt);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 11, 3, awbNo), manifestedPcs);
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 12, 3, awbNo), manifestedWgt);
    	return this;
    }
    
    
    /**
     * Created by A-7605 on 31-01-18
     * This method save the received piece and weight of two shipments in a single ULD/BULK
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param breakdownLoc
     * @param recvPcs
     * @param recvWgt
     * @return
     */
    public OPR004 saveBreakdownDetailsForTwoShipments(String uldNo, String carrierCode, String flightNo, String flightDate,
    		String storageUnit, String breakdownLoc, String recvPcs, String recvWgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
    	recvPcs = PropertyHandler.getPropValue(dataFilePath, recvPcs);
    	recvWgt = PropertyHandler.getPropValue(dataFilePath, recvWgt);
    	storageUnit = PropertyHandler.getPropValue(dataFilePath, storageUnit);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	if(storageUnit != null && storageUnit.trim().length()>0)
    		enterKeys(getWebElements(txt_storageUnit).get(0), storageUnit);
    	enterKeys(getWebElements(txt_breakdownLoc).get(0), breakdownLoc);
    	enterKeys(getWebElements(txt_rcvdPcs).get(0), recvPcs);
    	enterKeys(getWebElements(txt_rcvdWgt).get(0), recvWgt);
    	
    	if(storageUnit != null && storageUnit.trim().length()>0)
    		enterKeys(getWebElements(txt_storageUnit).get(1), storageUnit);
    	enterKeys(getWebElements(txt_breakdownLoc).get(1), breakdownLoc);
    	enterKeys(getWebElements(txt_rcvdPcs).get(1), recvPcs);
    	enterKeys(getWebElements(txt_rcvdWgt).get(1), recvWgt);
    	
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this;
    }
    
    
    /**
     * Created by A-7605 on 31-01-18
     * This method is used check different error message showing while entering AWB No in the short capture pop up
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbPrefix
     * @param awbNo
     * @param expectedErrorMessage
     * @return
     */
    public OPR004 checkAWBValidationsOnShortCapture(String uldNo, String carrierCode, String flightNo, String flightDate, String awbPrefix, String awbNo, String expectedErrorMessage){
    	
    	
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	expectedErrorMessage = PropertyHandler.getPropValue(dataFilePath, expectedErrorMessage);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	click(lnk_add);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(addBreakdownDetails_txt_prefix), awbPrefix);
    	enterKeys(addBreakdownDetails_txt_awbNo, awbNo);
    	click(addBreakdownDetails_btn_list);
    	Assert.assertEquals(waitForElement(info_erroMessage).getText(), expectedErrorMessage);
    	click(addBreakdownDetails_btn_delete);
    	minWait();
    	Assert.assertEquals(waitForElement(addBreakdownDetails_txt_awbNo).getText().trim().length(), 0);
    	click(addBreakdownDetails_btn_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605 on 01-02-18
     * This method will check if ULD / BULK not maifested message is showing while listing flight that is not manifested yet
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 checkNotificationShowingOnListingFlightThatIsNotManifested(String uldNo, String carrierCode, String flightNo, String flightDate){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD/BULK is not manifested, Do you want to continue?");
    	click(noBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElement(lnk_add).getAttribute("disabled"), "true");
    	Assert.assertEquals(waitForElement(lnk_delete).getAttribute("disabled"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605 on 01-02-18
     * This method will short capture an AWB for a flight that is not manifested yet
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbPrefix
     * @param awbNo
     * @param origin
     * @param destination
     * @param pcs
     * @param weight
     * @param location
     * @return
     */
    public OPR004 shortCaptureAWBForFlightWhichIsNotManifested(String uldNo, String carrierCode, String flightNo, String flightDate,
    		String awbPrefix, String awbNo, String origin, String destination, String pcs, String weight, String location){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
    	destination = PropertyHandler.getPropValue(dataFilePath, destination);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	weight = PropertyHandler.getPropValue(dataFilePath, weight);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD/BULK is not manifested, Do you want to continue?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertNull(waitForElement(lnk_add).getAttribute("disabled"));
    	Assert.assertNull(waitForElement(lnk_delete).getAttribute("disabled"));
    	click(lnk_add);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(addBreakdownDetails_txt_prefix), awbPrefix);
    	enterKeys(addBreakdownDetails_txt_awbNo, awbNo);
    	click(addBreakdownDetails_btn_list);
    	click(waitForElement(yesBtn));
    	enterKeys(addBreakdownDetails_txt_origin, origin);
    	enterKeys(addBreakdownDetails_txt_destination, destination);
    	enterKeys(addBreakdownDetails_txt_stdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_stdWt, weight);
    	enterKeys(addBreakdownDetails_txt_rcvdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_rcvdWt, weight);
    	enterKeys(addBreakdownDetails_txt_loc, location);
    	click(addBreakdownDetails_btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 11, 3, awbNo), "0 *");
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 12, 3, awbNo), "0");
    	
    	return this;
    }
    
    /**
     * Created by A-7605 on 1-2-18
     * This method checks the functionality of No button in the 'AWB does not exist.Do you want to capture?' dialogue showing while short capture
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 checkNoButtonFunctionalityInCaptureNewAWBDialogue(String uldNo, String carrierCode, String flightNo, String flightDate,
    		String awbPrefix, String awbNo){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD/BULK is not manifested, Do you want to continue?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	click(lnk_add);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(addBreakdownDetails_txt_prefix), awbPrefix);
    	enterKeys(addBreakdownDetails_txt_awbNo, awbNo);
    	click(addBreakdownDetails_btn_list);
    	click(waitForElement(noBtn));
    	Assert.assertEquals(waitForElementVisible(addBreakdownDetails_txt_origin).getAttribute("disabled"), "true");
    	Assert.assertEquals(waitForElementVisible(addBreakdownDetails_txt_destination).getAttribute("disabled"), "true");
    	click(addBreakdownDetails_btn_close);
    	if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this;
    }
    
    /**
     * Created by A-7605 on 1-02-18
     * This method checks the notification message showing on listing closed flight that is not manifested
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 checkNotificationShowingOnListingFlightThatIsNotManifestedAndClosed(String uldNo, String carrierCode, String flightNo, String flightDate){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	driver.switchTo().defaultContent(); 	
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Flight is closed. Do you want to continue?");
    	click(yesBtn);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD/BULK is not manifested, Do you want to continue?");
    	click(noBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElement(lnk_add).getAttribute("disabled"), "true");
    	Assert.assertEquals(waitForElement(lnk_delete).getAttribute("disabled"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605 on 01-02-18
     * This method will short capture AWB for closed flight that is not manifested yet
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbPrefix
     * @param awbNo
     * @param origin
     * @param destination
     * @param pcs
     * @param weight
     * @param location
     * @return
     */
    public OPR004 shortCaptureAWBForClosedFlight(String uldNo, String carrierCode, String flightNo, String flightDate, String awbPrefix, String awbNo,
    		String origin, String destination, String pcs, String weight, String location){
    	
    	
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
    	destination = PropertyHandler.getPropValue(dataFilePath, destination);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	weight = PropertyHandler.getPropValue(dataFilePath, weight);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	driver.switchTo().defaultContent(); 	
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Flight is closed. Do you want to continue?");
    	click(yesBtn);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD/BULK is not manifested, Do you want to continue?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	click(lnk_add);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(addBreakdownDetails_txt_prefix), awbPrefix);
    	enterKeys(addBreakdownDetails_txt_awbNo, awbNo);
    	click(addBreakdownDetails_btn_list);
    	click(waitForElement(yesBtn));
    	enterKeys(addBreakdownDetails_txt_origin, origin);
    	enterKeys(addBreakdownDetails_txt_destination, destination);
    	enterKeys(addBreakdownDetails_txt_stdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_stdWt, weight);
    	enterKeys(addBreakdownDetails_txt_rcvdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_rcvdWt, weight);
    	enterKeys(addBreakdownDetails_txt_loc, location);
    	click(addBreakdownDetails_btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Flight is closed. Do you want to continue?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 11, 3, awbNo), "0 *");
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 12, 3, awbNo), "0");
    	return this;
    }
    
    
    /**
     * Created by A-7605 on 1-02-18
     * This method checks the notification message showing on listing nil flight that is not manifested
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 checkNotificationShowingOnListingFlightThatIsNotManifestedAndNil(String uldNo, String carrierCode, String flightNo, String flightDate){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	driver.switchTo().defaultContent(); 	
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "The flight entered is a nil manifest flight. Do you want to continue?");
    	click(yesBtn);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD/BULK is not manifested, Do you want to continue?");
    	click(noBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElement(lnk_add).getAttribute("disabled"), "true");
    	Assert.assertEquals(waitForElement(lnk_delete).getAttribute("disabled"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605 on 01-02-18
     * This method will short capture AWB for nil flight that is not manifested yet
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbPrefix
     * @param awbNo
     * @param origin
     * @param destination
     * @param pcs
     * @param weight
     * @param location
     * @return
     */
    public OPR004 shortCaptureAWBForNilFlight(String uldNo, String carrierCode, String flightNo, String flightDate, String awbPrefix, String awbNo,
    		String origin, String destination, String pcs, String weight, String location){
    	
    	
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
    	destination = PropertyHandler.getPropValue(dataFilePath, destination);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	weight = PropertyHandler.getPropValue(dataFilePath, weight);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	driver.switchTo().defaultContent(); 	
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "The flight entered is a nil manifest flight. Do you want to continue?");
    	click(yesBtn);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD/BULK is not manifested, Do you want to continue?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	click(lnk_add);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(addBreakdownDetails_txt_prefix), awbPrefix);
    	enterKeys(addBreakdownDetails_txt_awbNo, awbNo);
    	click(addBreakdownDetails_btn_list);
    	click(waitForElement(yesBtn));
    	enterKeys(addBreakdownDetails_txt_origin, origin);
    	enterKeys(addBreakdownDetails_txt_destination, destination);
    	enterKeys(addBreakdownDetails_txt_stdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_stdWt, weight);
    	enterKeys(addBreakdownDetails_txt_rcvdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_rcvdWt, weight);
    	enterKeys(addBreakdownDetails_txt_loc, location);
    	click(addBreakdownDetails_btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "The flight entered is a nil manifest flight. Do you want to continue?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 11, 3, awbNo), "0 *");
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 12, 3, awbNo), "0");
    	return this;
    }
    
    /**
     *  Created by A-7605 on 01-02-18
     *  This method will short capture awb for an OAL ULD
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbPrefix
     * @param awbNo
     * @param origin
     * @param destination
     * @param pcs
     * @param weight
     * @param location
     * @return
     */
    public OPR004 shortCaptureAWBforOAL_ULD(String uldNo, String carrierCode, String flightNo, String flightDate, String awbPrefix, String awbNo,
    		String origin, String destination, String pcs, String weight, String location){
    	
    	
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
    	destination = PropertyHandler.getPropValue(dataFilePath, destination);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	weight = PropertyHandler.getPropValue(dataFilePath, weight);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	driver.switchTo().defaultContent(); 	
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD not in  stock do you want to continue");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertNull(waitForElement(lnk_delete).getAttribute("disabled"));
    	click(lnk_add);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(addBreakdownDetails_txt_prefix), awbPrefix);
    	enterKeys(addBreakdownDetails_txt_awbNo, awbNo);
    	click(addBreakdownDetails_btn_list);
    	click(waitForElement(yesBtn));
    	enterKeys(addBreakdownDetails_txt_origin, origin);
    	enterKeys(addBreakdownDetails_txt_destination, destination);
    	enterKeys(addBreakdownDetails_txt_stdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_stdWt, weight);
    	enterKeys(addBreakdownDetails_txt_rcvdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_rcvdWt, weight);
    	enterKeys(addBreakdownDetails_txt_loc, location);
    	click(addBreakdownDetails_btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD not in  stock do you want to continue");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 11, 3, awbNo), "0 *");
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 12, 3, awbNo), "0");
    	return this;
    }
    
    /**
     *  Created by A-7605 on 01-02-18
     *  This method will save pcs and weight for a awb in OAL ULD
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param breakdownLoc
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 saveOALULD(String uldNo,String carrierCode, String flightNo, String flightDate,  String breakdownLoc, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	driver.switchTo().defaultContent(); 	
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD not in  stock do you want to continue");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	enterKeys(txt_breakdownLoc, breakdownLoc);
    	enterKeys(txt_pcs, pcs);
    	enterKeys(txt_wt, wgt);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(noBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this;
    }
    
    /**
     * Created by A-7605 on 1-2-18
     * This method will perform breakdown complete action for shipment in OAL ULD with expected descripency
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbPrefix
     * @param awbNoWithDescripency
     * @return
     */
    public OPR004 breakdownCompleteForOALULDWithDescripency(String uldNo,String carrierCode, String flightNo, String flightDate, String awbPrefix, String awbNoWithDescripency){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNoWithDescripency = PropertyHandler.getPropValue(dataFilePath, awbNoWithDescripency);
    	String fullAWBNo = awbPrefix+"-"+awbNoWithDescripency;
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	driver.switchTo().defaultContent(); 	
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD not in  stock do you want to continue");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	click(btn_breakdownComplete);
    	driver.switchTo().defaultContent(); 	
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Unconfirmed Discrepancies will be stamped for the following AWBs,"+fullAWBNo+". Do you wish to mark Breakdown Complete for this ULD?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605 on 02-02-18
     * This method will check if the Breakdown Completed label is showing while listing
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 verifyBreakdownCompleted(String uldNo,String carrierCode, String flightNo, String flightDate){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	Assert.assertEquals(waitForElement(info_breakdownCompleted).getText(), "Breakdown Completed");
    	return this;
    }
    
    
    /**
     * Created by A-7605
     * This method will perform breakdown complete action with expected discrepancy shipment
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbPrefix
     * @param awbNo
     * @param breakdownLoc
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 BreakdownCompleteWithDescripencies(String uldNo,String carrierCode, String flightNo, String flightDate, String breakdownLoc, String awbPrefix, String awbNo, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	String fullAWBNo = awbPrefix+"-"+awbNo;
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	enterKeys(txt_breakdownLoc, breakdownLoc);
    	enterKeys(txt_pcs, pcs);
    	enterKeys(txt_wt, wgt);
    	click(btn_breakdownComplete);
    	driver.switchTo().defaultContent(); 	
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Unconfirmed Discrepancies will be stamped for the following AWBs,"+fullAWBNo+". Do you wish to mark Breakdown Complete for this ULD?");
    	click(yesBtn);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertEquals(waitForElement(txt_uldNum).getAttribute("value").trim().length(), 0);
    	return this;
    }
    
    /**
     * Created by A-7605
     * This method will update received pcs and weight of AWB for which breakdown already done
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 updateReceivedPiecesAndWeight(String uldNo,String carrierCode, String flightNo, String flightDate, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	enterKeys(txt_pcs, pcs);
    	enterKeys(txt_wt, wgt);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_fltNum).getAttribute("value"), flightNo);
    	return this;
    }
    
    /**
     * Created by A-6705 on 02-02-18
     * This message check if the received pcs and weight showing while relisting the AWB is correct
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbNo
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 verifyReceivedPcsAndWeight(String uldNo,String carrierCode, String flightNo, String flightDate, String awbNo, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_rcvdPcs).getAttribute("value"), pcs);
    	Assert.assertEquals(waitForElement(txt_rcvdWgt).getAttribute("value"), wgt);
    	return this;
    }
    
    /**
     * Created by A-7605
     * This method will update received pcs and weight of AWB for which breakdown already done and the saved result are not relisted
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 updateReceivedPiecesAndWeightNoRelist(String uldNo,String carrierCode, String flightNo, String flightDate, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	enterKeys(txt_pcs, pcs);
    	enterKeys(txt_wt, wgt);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(noBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this;
    }
    
    /**
     * Created by
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param storageUnit
     * @param breakdownLoc
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 saveToStorageUnit(String uldNo,String carrierCode, String flightNo, String flightDate, String storageUnit, String breakdownLoc, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
    	storageUnit = PropertyHandler.getPropValue(dataFilePath, storageUnit);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	enterKeys(txt_storageUnit, storageUnit);
    	enterKeys(txt_breakdownLoc, breakdownLoc);
    	enterKeys(txt_pcs, pcs);
    	enterKeys(txt_wt, wgt);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this;
    }
    
    /**
     * Created by A-7605 on 2-2-18
     * This method will verify if the storage unit field is disabled
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 verifyStorageUnitFieldIsDisabled(String uldNo,String carrierCode, String flightNo, String flightDate){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	Assert.assertEquals(waitForElementVisible(txt_storageUnit).getAttribute("disabled"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605 created on 2-2-18
     * This method will delete breakdown details of the shipment
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 deleteBreakdownDetails(String uldNo,String carrierCode, String flightNo, String flightDate){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(lnk_delete);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertTrue(waitForElement(txt_rcvdPcs).getAttribute("value").equals("0") ||  waitForElement(txt_rcvdPcs).getAttribute("value").trim().length()==0);
    	Assert.assertTrue(waitForElement(txt_rcvdWgt).getAttribute("value").equals("0") ||  waitForElement(txt_rcvdWgt).getAttribute("value").trim().length()==0);
    	return this;
    }
    
    public OPR004 receivePcsAndWgtGreaterThanStated(String uldNo, String carrierCode, String flightNo, String flightDate, String whareHouseLocation, String pieces, String weight, String awbPrefix, String awbNo){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
    	weight = PropertyHandler.getPropValue(dataFilePath, weight);
    	whareHouseLocation = PropertyHandler.getPropValue(dataFilePath, whareHouseLocation);
    	String fullAWBNo = awbPrefix+"-"+awbNo;
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	enterKeys(txt_whLoc, whareHouseLocation);
    	enterKeys(txt_rcvdPcs, pieces);
    	enterKeys(txt_rcvdWgt, weight);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Total Received Pcs/Wt is greater than the stated Pcs/Wt for the AWB(s) "+fullAWBNo+" . Do you want to continue ?");
    	click(noBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_whLoc).getAttribute("value"), whareHouseLocation);
    	Assert.assertEquals(waitForElement(txt_rcvdPcs).getAttribute("value"), pieces);
    	Assert.assertEquals(waitForElement(txt_rcvdWgt).getAttribute("value"), weight);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Total Received Pcs/Wt is greater than the stated Pcs/Wt for the AWB(s) "+fullAWBNo+" . Do you want to continue ?");
    	click(yesBtn);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_rcvdPcs).getAttribute("value"), pieces);
    	Assert.assertEquals(waitForElement(txt_rcvdWgt).getAttribute("value"), weight);
    	return this;
    }
    
    /**
     * Created by A-7605 on 05-02-18
     * This method will  check if the specified SU is showing in the SU field in the breakdown details table
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param storageUnit1
     * @param storageUnit2
     * @return
     */
    public OPR004 verifySUUpdated(String uldNo, String carrierCode, String flightNo, String flightDate, String storageUnit1, String storageUnit2){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	storageUnit1 = PropertyHandler.getPropValue(dataFilePath, storageUnit1);
    	storageUnit2 = PropertyHandler.getPropValue(dataFilePath, storageUnit2);
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	Assert.assertTrue(waitForElementVisible(info_su).getText().contains(storageUnit1));
    	Assert.assertTrue(waitForElementVisible(info_su).getText().contains(storageUnit2));
    	return this;
    }
    
    /**
     * Created by A-7605 on 5-2-18
     * This method will complete breakdown for shipments for which breakdown already started
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 completeBreakdownForBreakdownAlreadyStartedShipment(String uldNo,String carrierCode, String flightNo, String flightDate){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	click(btn_breakdownComplete);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_uldNum).getAttribute("value").trim().length(), 0);
    	return this;
    }
    
    /**
     * Created by A-7605 on 5-2-18
     * This method will check for error message on trying to delete shipment for which delivery id already generated
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 checkErrorMessageOnDeletingShipmentsWithDeliveryID(String uldNo,String carrierCode, String flightNo, String flightDate){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	check(chkbox_selectTableItem);
    	click(lnk_delete);
    	minWait();
    	click(btn_save);
    	Assert.assertEquals(waitForElement(info_erroMessage).getText(), "Pieces not available in the airport");
    	clear();
    	minWait();list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	check(getWebElements(chkbox_selectTableItem).get(1));
    	click(lnk_delete);
    	minWait();
    	click(btn_save);
    	Assert.assertEquals(waitForElement(info_erroMessage).getText(), "Pieces not available in the airport");
    	return this;
    }
    
    /**
     * Created by A-7605 on 9-2-18
     * This method will save breakdown details for a uld that contains 4 AWBs
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbNo1
     * @param breakdownLoc1
     * @param pcs1
     * @param wgt1
     * @param awbNo2
     * @param breakdownLoc2
     * @param pcs2
     * @param wgt2
     * @param awbNo3
     * @param breakdownLoc3
     * @param pcs3
     * @param wgt3
     * @param awbNo4
     * @param breakdownLoc4
     * @param pcs4
     * @param wgt4
     * @return
     */
    public OPR004 breakdownFourAWBs(String uldNo,String carrierCode, String flightNo, String flightDate, String awbNo1, String breakdownLoc1, String pcs1, String wgt1,
    		String awbNo2, String breakdownLoc2, String pcs2, String wgt2,String awbNo3, String breakdownLoc3, String pcs3, String wgt3,String awbNo4, String breakdownLoc4, String pcs4, String wgt4){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbNo1 = PropertyHandler.getPropValue(dataFilePath, awbNo1);
    	pcs1 = PropertyHandler.getPropValue(dataFilePath, pcs1);
    	wgt1 = PropertyHandler.getPropValue(dataFilePath, wgt1);
    	breakdownLoc1 = PropertyHandler.getPropValue(dataFilePath, breakdownLoc1);
    	awbNo2 = PropertyHandler.getPropValue(dataFilePath, awbNo2);
    	pcs2 = PropertyHandler.getPropValue(dataFilePath, pcs2);
    	wgt2 = PropertyHandler.getPropValue(dataFilePath, wgt2);
    	breakdownLoc2 = PropertyHandler.getPropValue(dataFilePath, breakdownLoc2);
    	awbNo3 = PropertyHandler.getPropValue(dataFilePath, awbNo3);
    	pcs3 = PropertyHandler.getPropValue(dataFilePath, pcs3);
    	wgt3 = PropertyHandler.getPropValue(dataFilePath, wgt3);
    	breakdownLoc3 = PropertyHandler.getPropValue(dataFilePath, breakdownLoc3);
    	awbNo4 = PropertyHandler.getPropValue(dataFilePath, awbNo4);
    	pcs4 = PropertyHandler.getPropValue(dataFilePath, pcs4);
    	wgt4 = PropertyHandler.getPropValue(dataFilePath, wgt4);
    	breakdownLoc4 = PropertyHandler.getPropValue(dataFilePath, breakdownLoc4);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	int awb1RowNo = getTableRowNumber(table_breakdownDetails, 3, awbNo1);
    	int awb2RowNo = getTableRowNumber(table_breakdownDetails, 3, awbNo2);
    	int awb3RowNo = getTableRowNumber(table_breakdownDetails, 3, awbNo3);
    	int awb4RowNo = getTableRowNumber(table_breakdownDetails, 3, awbNo4);
    	enterKeys(getWebElements(txt_breakdownLoc).get(awb1RowNo-1), breakdownLoc1);
    	enterKeys(getWebElements(txt_rcvdPcs).get(awb1RowNo-1), pcs1);
    	enterKeys(getWebElements(txt_rcvdWgt).get(awb1RowNo-1), wgt1);
    	enterKeys(getWebElements(txt_breakdownLoc).get(awb2RowNo-1), breakdownLoc2);
    	enterKeys(getWebElements(txt_rcvdPcs).get(awb2RowNo-1), pcs2);
    	enterKeys(getWebElements(txt_rcvdWgt).get(awb2RowNo-1), wgt2);
    	enterKeys(getWebElements(txt_breakdownLoc).get(awb3RowNo-1), breakdownLoc3);
    	enterKeys(getWebElements(txt_rcvdPcs).get(awb3RowNo-1), pcs3);
    	enterKeys(getWebElements(txt_rcvdWgt).get(awb3RowNo-1), wgt3);
    	enterKeys(getWebElements(txt_breakdownLoc).get(awb4RowNo-1), breakdownLoc4);
    	enterKeys(getWebElements(txt_rcvdPcs).get(awb4RowNo-1), pcs4);
    	enterKeys(getWebElements(txt_rcvdWgt).get(awb4RowNo-1), wgt4);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(noBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertFalse(isElementPresent(txt_rcvdPcs));
    	return this;
    }
    
    
    /**
     * Created by A-7605 on 9-2-18
     * This method will update piece and weight of shipment for which breakdown already started
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbNo
     * @param pieces
     * @param weight
     * @return
     */
    public OPR004 updatePcsAndWeight(String uldNo,String carrierCode, String flightNo, String flightDate, String awbNo, String pieces, String weight){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
    	weight = PropertyHandler.getPropValue(dataFilePath, weight);
    	
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	int awbRowNo = getTableRowNumber(table_breakdownDetails, 3, awbNo);
    	enterKeys(getWebElements(txt_rcvdPcs).get(awbRowNo-1), pieces);
    	enterKeys(getWebElements(txt_rcvdWgt).get(awbRowNo-1), weight);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(noBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertFalse(isElementPresent(txt_rcvdPcs));
    	return this;
    }
    
    /**
     * Created by A-7605 on 12-2-18
     * This method will complete breakdown for shipments with discrepancy for which breakdown already started
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @return
     */
    public OPR004 completeBreakdownWithDiscrepancyForBreakdownAlreadyStartedShipment(String uldNo,String carrierCode, String flightNo, String flightDate){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	click(btn_breakdownComplete);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_uldNum).getAttribute("value").trim().length(), 0);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method will complete breakdown of the AWB containing any discrepancy
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param storageUnit
     * @param breakdownLoc
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 BreakdownCompleteWithDiscrepancy(String uldNo,String carrierCode, String flightNo, String flightDate, String storageUnit, String breakdownLoc, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
    	storageUnit = PropertyHandler.getPropValue(dataFilePath, storageUnit);
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	if(storageUnit != null && storageUnit.trim().length()>0)
    		enterKeys(txt_storageUnit, storageUnit);
    	enterKeys(txt_breakdownLoc, breakdownLoc);
    	enterKeys(txt_pcs, pcs);
    	enterKeys(txt_wt, wgt);
    	click(btn_breakdownComplete);
    	driver.switchTo().defaultContent(); 	
    	Assert.assertTrue(waitForElement(txt_dialogueContent).getText().contains("Unconfirmed Discrepancies will be stamped for the following AWBs"));
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_uldNum).getAttribute("value").trim().length(), 0);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method will complete breakdown of the AWB, receiving pcs/wgt grater than manifested
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param storageUnit
     * @param breakdownLoc
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 BreakdownCompletePcsGraterthanManifested(String uldNo,String carrierCode, String flightNo, String flightDate, String storageUnit, String breakdownLoc, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
    	storageUnit = PropertyHandler.getPropValue(dataFilePath, storageUnit);
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	if(storageUnit != null && storageUnit.trim().length()>0)
    		enterKeys(txt_storageUnit, storageUnit);
    	enterKeys(txt_breakdownLoc, breakdownLoc);
    	enterKeys(txt_pcs, pcs);
    	enterKeys(txt_wt, wgt);
    	click(btn_breakdownComplete);
    	driver.switchTo().defaultContent();
    	click(waitForElement(yesBtn));
    	minWait();
    	Assert.assertTrue(waitForElement(txt_dialogueContent).getText().contains("Unconfirmed Discrepancies will be stamped for the following AWBs"));
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_uldNum).getAttribute("value").trim().length(), 0);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbNo
     * @param breakdownLoc
     * @param pcs
     * @param wgt
     * @return
     */
    public OPR004 receivePcsAndWgt(String uldNo,String carrierCode, String flightNo, String flightDate, String awbNo, String breakdownLoc, String pcs, String wgt){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
    	breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	enterKeys(txt_breakdownLoc, breakdownLoc);
    	enterKeys(txt_pcs, pcs);
    	enterKeys(txt_wt, wgt);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	return this;
    }
    
    /**
     * Created by A-7605 on 15-2-18
     * This method will verify received pcs and weight fields are disabled for master awb
     * @param uldNo
     * @param carrierCode
     * @param flightNo
     * @param flightDate
     * @param awbNo
     * @return
     */
    public OPR004 verifyMasterLevelBreakdownNotPossible(String uldNo,String carrierCode, String flightNo, String flightDate, String awbNo){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	
    	list(uldNo, carrierCode, flightNo, flightDate);
    	minWait();
    	int rowNumber = getTableRowNumber(table_breakdownDetails, 3, awbNo);
    	rowNumber--;
    	Assert.assertEquals(getWebElements(txt_rcvdPcs).get(rowNumber).getAttribute("disabled"), "true");
    	Assert.assertEquals(getWebElements(txt_rcvdWgt).get(rowNumber).getAttribute("disabled"), "true");
    	return this;
    }
    /**
     * Created by Shalini P
     * @param uldNo
     * @param carrierCode
     * @param flightNo   
     * @return
     */
    public OPR004 ProcessBreakdownComplete(String uldNo, String carrierCode, String flightNo, String flightDate, 
    		String awbPrefix, String awbNo,String origin, String destination, 
    		String pcs, String weight, String location){
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
    	destination = PropertyHandler.getPropValue(dataFilePath, destination);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	weight = PropertyHandler.getPropValue(dataFilePath, weight);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	String FlightNumber = flightNo.replaceAll("[^0-9]", "");
    
    	list(uldNo, carrierCode, FlightNumber, flightDate);
    	InitialSetup.test.log(LogStatus.PASS, "Successfully entered:"+FlightNumber+"Number and click cliked on  list button");
    	driver.switchTo().defaultContent(); 	
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD not in  stock do you want to continue");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertNull(waitForElement(lnk_delete).getAttribute("disabled"));
    	click(lnk_add);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(addBreakdownDetails_txt_prefix), awbPrefix);
    	enterKeys(addBreakdownDetails_txt_awbNo, awbNo);
    	click(addBreakdownDetails_btn_list);
    	click(waitForElement(yesBtn));
    	enterKeys(addBreakdownDetails_txt_origin, origin);
    	enterKeys(addBreakdownDetails_txt_destination, destination);
    	enterKeys(addBreakdownDetails_txt_stdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_stdWt, weight);
    	enterKeys(addBreakdownDetails_txt_rcvdPcs, pcs);
    	enterKeys(addBreakdownDetails_txt_rcvdWt, weight);
    	enterKeys(addBreakdownDetails_txt_loc, location);
    	click(addBreakdownDetails_btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(txt_dialogueContent).getText(), "ULD not in  stock do you want to continue");
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 11, 3, awbNo), "0 *");
    	Assert.assertEquals(tblGetTextByColValue(table_breakdownDetails, 12, 3, awbNo), "0");
    	InitialSetup.test.log(LogStatus.PASS, "Successfully done with breakdown procedure");
    	return this;    	
    }
    /**
	 * Description... Handles an alert with options getText/Accept/Dismiss/Close
	 * 
	 * @param alertOps
	 * @param ScreenName
	 */
	public void handleAlert(String alertOps, String ScreenName) {
		driver.switchTo().defaultContent();
		String AlertText = "";

		try {
			AlertText = driver.findElement(By.xpath("//div[@role='dialog']//p"))
					.getText();
			switch (alertOps.valueOf(alertOps)) {
			case "getText":
				 InitialSetup.test.log(LogStatus.PASS, "Accepted Alert text "+AlertText+ScreenName);
				break;

			case "Accept":
				driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[1]")).click();
				 InitialSetup.test.log(LogStatus.PASS, "Accepted Alert with text "+ScreenName);

				break;
			case "Dismiss":
				driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[2]")).click();
				InitialSetup.test.log(LogStatus.PASS,"Clicked on Dismiss button"+ScreenName);
				break;
			case "Close":
				driver.findElement(By.xpath("(//button[@title='Close'])[2]|//button[@name='btClose']")).click();
				InitialSetup.test.log(LogStatus.PASS,"Clicked on Close button"+ScreenName);
				break;
			}

		} catch (Exception e) {
			InitialSetup.test.log(LogStatus.INFO,"Not able to handle Alert"+ScreenName);

		}
	}
	public OPR004 modifyFSU_RCF(String prefix, String awbNo, String org,
            String dest, String carrierwithFlightno, String fltDtwithoutYY, String path,String pieces,String wt)
                         throws IOException {
     prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
     awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
     org = PropertyHandler.getPropValue(dataFilePath, org);
     dest = PropertyHandler.getPropValue(dataFilePath, dest);
     carrierwithFlightno = PropertyHandler.getPropValue(dataFilePath, carrierwithFlightno);
     fltDtwithoutYY = PropertyHandler.getPropValue(dataFilePath,
                  fltDtwithoutYY);
     // to be added

     String StdArrTime = PropertyHandler.getPropValue(dataFilePath, "StdArrTime");

     String messagefilepath = path;
     File file = new File(messagefilepath);
     BufferedReader br = new BufferedReader(new FileReader(file));
     String str;
     String strold = "";
     while ((str = br.readLine()) != null)
            strold += str;

     String split[] = strold.split("/");
     String splitawbdetails[] = split[1].split("-");

     int size = split.length;

     // modify awbpre
     modifyFile(messagefilepath, splitawbdetails[0].substring(2, 5), prefix);

     // modify awb and org+dest
     modifyFile(messagefilepath, splitawbdetails[1], awbNo + org + dest);

     // modify pieces and wt
     String splitpieces[] =split[2].split("K");
     pieces = splitpieces[0].replace(splitpieces[0].substring(1),pieces);
     wt = splitpieces[1].replace(splitpieces[1].substring(0,(splitpieces[1].length()-3)),wt);
     modifyFile(messagefilepath, split[2], pieces+wt);

     // modify fltno.
     modifyFile(messagefilepath, split[3], carrierwithFlightno);

     // modify date
     modifyFile(messagefilepath, split[4], fltDtwithoutYY+StdArrTime);

     // modify orgdest
     modifyFile(messagefilepath, split[5],dest);

     modifyFile(messagefilepath, split[6], pieces+wt.substring(0,wt.length()-3));


     return this;

}

// A-8452 Faizan Tarique

public OPR004 modifyFSU_NFD(String prefix, String awbNo, String org,
            String dest, String carrierwithFlightno, String fltDtwithoutYY, String path,String pieces,String wt)
                         throws IOException {
     prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
     awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
     org = PropertyHandler.getPropValue(dataFilePath, org);
     dest = PropertyHandler.getPropValue(dataFilePath, dest);
     carrierwithFlightno = PropertyHandler.getPropValue(dataFilePath, carrierwithFlightno);
     fltDtwithoutYY = PropertyHandler.getPropValue(dataFilePath,
                  fltDtwithoutYY);
     pieces = PropertyHandler.getPropValue(dataFilePath,
                  pieces);
     wt = PropertyHandler.getPropValue(dataFilePath,
                  wt);
     // to be added

     //String StdArrTime = PropertyHandler.getPropValue(dataFilePath, "StdArrTime");

     String messagefilepath = path;
     File file = new File(messagefilepath);
     BufferedReader br = new BufferedReader(new FileReader(file));
     String str;
     String strold = "";
     while ((str = br.readLine()) != null)
            strold += str;

     String split[] = strold.split("/");
     String splitawbdetails[] = split[1].split("-");

     int size = split.length;

     // modify awbpre
     modifyFile(messagefilepath, splitawbdetails[0].substring(2, 5), prefix);

     // modify awb and org+dest
     modifyFile(messagefilepath, splitawbdetails[1], awbNo + org + dest);

     // modify pieces and wt
     String splitpieces[] =split[2].split("K");
     pieces = splitpieces[0].replace(splitpieces[0].substring(1),pieces);
     wt = splitpieces[1].replace(splitpieces[1].substring(0,(splitpieces[1].length()-3)),wt);
     modifyFile(messagefilepath, split[2], pieces+wt);


     // modify dest
     modifyFile(messagefilepath, split[4],dest);

     // modify pieces and wt
     modifyFile(messagefilepath, split[5], pieces+wt.substring(0,wt.length()-3));


     return this;

}

}
