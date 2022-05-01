package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * PAGE OPR286 : AWB Deconsolidation
 *
 * @author A-7605
 */
public class OPR286 extends BasePage{

	public OPR286(WebDriver driver, String dataFileName) {
		super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
	}
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameOPR286";   
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    WebDriver driver;
    String dataFileName;
    By txt_awbPrefix;
    By txt_awbNo;
    By btn_list;
    By btn_clear;
    By table_details;
    By btn_delete;
    By btn_deconsolidationComplete;
    By btn_captureHAWB;
    By btn_save;
    By btn_close;
    By btn_dialogueYes;
    By btn_dialogueNo;
    By info_dialogueContent;
    By info_footerMessage;
    By info_error;
    By txt_storageUnit;
    By txt_location;
    By txt_rcvdPcs;
    By txt_rcvdWgt;
    By chkbox_selectTableItem;
    By icon_splitShipment;
    By splitShipment_txt_splitInto;
    By splitShipment_txt_pcs;
    By splitShipment_txt_weight;
    By splitShipment_txt_su;
    By splitShipment_txt_location;
    By splitShipment_btn_ok;
    By splitShipment_btn_close;
    By info_su;
    By info_location;
    By info_successMessageToast;
    By splitShipment_icon_location;
    By warehouseLocationLov_txt_locationCode;
    By warehouseLocationLov_btn_list;
    By warehouseLocationLov_chkbox_selectTableItem;
    By warehouseLocationLov_btn_ok;
    
    
    private void initElements(){
    	txt_awbPrefix = MiscUtility.getWebElement(objFilepath, "OPR286_txt_awbPrefix");
    	txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR286_txt_awbNo");
    	btn_list = MiscUtility.getWebElement(objFilepath, "OPR286_btn_list");
    	btn_clear = MiscUtility.getWebElement(objFilepath, "OPR286_btn_clear");
    	table_details = MiscUtility.getWebElement(objFilepath, "OPR286_table_details");
    	btn_delete = MiscUtility.getWebElement(objFilepath, "OPR286_btn_delete");
    	btn_deconsolidationComplete = MiscUtility.getWebElement(objFilepath, "OPR286_btn_deconsolidationComplete");
    	btn_captureHAWB = MiscUtility.getWebElement(objFilepath, "OPR286_btn_captureHAWB");
    	btn_save = MiscUtility.getWebElement(objFilepath, "OPR286_btn_save");
    	btn_close = MiscUtility.getWebElement(objFilepath, "OPR286_btn_close");
    	txt_storageUnit = MiscUtility.getWebElement(objFilepath, "OPR286_txt_storageUnit");
        txt_location = MiscUtility.getWebElement(objFilepath, "OPR286_txt_location");
        txt_rcvdPcs = MiscUtility.getWebElement(objFilepath, "OPR286_txt_rcvdPcs");
        txt_rcvdWgt = MiscUtility.getWebElement(objFilepath, "OPR286_txt_rcvdWgt");
        chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath, "OPR286_chkbox_selectTableItem");
        icon_splitShipment = MiscUtility.getWebElement(objFilepath, "OPR286_icon_splitShipment");
        splitShipment_txt_splitInto = MiscUtility.getWebElement(objFilepath, "OPR286_SplitShipment_txt_splitInto");
        splitShipment_txt_pcs = MiscUtility.getWebElement(objFilepath, "OPR286_SplitShipment_txt_pcs");
        splitShipment_txt_weight = MiscUtility.getWebElement(objFilepath, "OPR286_SplitShipment_txt_weight");
        splitShipment_txt_su = MiscUtility.getWebElement(objFilepath, "OPR286_SplitShipment_txt_su");
        splitShipment_txt_location = MiscUtility.getWebElement(objFilepath, "OPR286_SplitShipment_txt_location");
        splitShipment_btn_ok = MiscUtility.getWebElement(objFilepath, "OPR286_SplitShipment_btn_ok");
        splitShipment_btn_close = MiscUtility.getWebElement(objFilepath, "OPR286_SplitShipment_btn_close");
        info_su = MiscUtility.getWebElement(objFilepath, "OPR286_info_su");
        info_location = MiscUtility.getWebElement(objFilepath, "OPR286_info_location");
        
    	btn_dialogueYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btn_dialogueNo = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
    	info_dialogueContent = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    	info_footerMessage = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    	info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    	info_successMessageToast = MiscUtility.getWebElement(genObjPath, "Info_successMessageToast");
    	
    	splitShipment_icon_location = MiscUtility.getWebElement(objFilepath, "OPR286_splitShipment_icon_location");
	    warehouseLocationLov_txt_locationCode = MiscUtility.getWebElement(objFilepath, "OPR286_warehouseLocationLov_txt_locationCode");
	    warehouseLocationLov_btn_list = MiscUtility.getWebElement(objFilepath, "OPR286_warehouseLocationLov_btn_list");
	    warehouseLocationLov_chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath, "OPR286_warehouseLocationLov_chkbox_selectTableItem");
	    warehouseLocationLov_btn_ok = MiscUtility.getWebElement(objFilepath, "OPR286_warehouseLocationLov_btn_ok");
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method clear the fields and verify if AWB No field is cleared and Save button is disabled
     * @return
     */
    public OPR286 clear(){
    	click(btn_clear);
    	minWait();
    	Assert.assertEquals(waitForElementVisible(btn_save).getAttribute("disabled"), "true");
    	Assert.assertEquals(waitForElement(txt_awbNo).getText().trim().length(), 0);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method close the page
     * @return
     */
    public HomePage close(){
    	click(btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_dialogueYes)){
    		click(btn_dialogueYes);
    	}
    	return new HomePage(driver, dataFileName);
    }
    
    private void list(String awbPrefix, String awbNo){
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_list);
    	minWait();
    	return;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method will check the stated pcs/wgt, rcvd pcs/wgt and dlvrd pcs/wgt details of two houses in an AWB
     * @param awbPrefix
     * @param awbNo
     * @param hawb1
     * @param statedPcs1
     * @param statedWeight1
     * @param receivedPcs1
     * @param receivedWeight1
     * @param deliveredPcs1
     * @param deliveredWeight1
     * @param hawb2
     * @param statedPcs2
     * @param statedWeight2
     * @param receivedPcs2
     * @param receivedWeight2
     * @param deliveredPcs2
     * @param deliveredWeight2
     * @return
     */
    public OPR286 verifyPcsAndWeightOfTwoHouses(String awbPrefix, String awbNo,String hawb1, String statedPcs1, String statedWeight1, 
    		String receivedPcs1, String receivedWeight1, String deliveredPcs1, String deliveredWeight1, String hawb2, String statedPcs2, 
    		String statedWeight2, String receivedPcs2, String receivedWeight2, String deliveredPcs2, String deliveredWeight2){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	hawb1 = PropertyHandler.getPropValue(dataFilePath, hawb1);
    	statedPcs1 = PropertyHandler.getPropValue(dataFilePath, statedPcs1);
    	statedWeight1 = PropertyHandler.getPropValue(dataFilePath, statedWeight1);
    	receivedPcs1 = PropertyHandler.getPropValue(dataFilePath, receivedPcs1);
    	receivedWeight1 = PropertyHandler.getPropValue(dataFilePath, receivedWeight1);
    	deliveredPcs1 = PropertyHandler.getPropValue(dataFilePath, deliveredPcs1);
    	deliveredWeight1 = PropertyHandler.getPropValue(dataFilePath, deliveredWeight1);
    	hawb2 = PropertyHandler.getPropValue(dataFilePath, hawb2);
    	statedPcs2 = PropertyHandler.getPropValue(dataFilePath, statedPcs2);
    	statedWeight2 = PropertyHandler.getPropValue(dataFilePath, statedWeight2);
    	receivedPcs2 = PropertyHandler.getPropValue(dataFilePath, receivedPcs2);
    	receivedWeight2 = PropertyHandler.getPropValue(dataFilePath, receivedWeight2);
    	deliveredPcs2 = PropertyHandler.getPropValue(dataFilePath, deliveredPcs2);
    	deliveredWeight2 = PropertyHandler.getPropValue(dataFilePath, deliveredWeight2);
    	
    	list(awbPrefix, awbNo);
    	minWait();
    	Assert.assertEquals(tblGetTextByColValue(table_details, 9, 2, hawb1), statedPcs1+"/"+statedWeight1);
    	Assert.assertEquals(tblGetTextByColValue(table_details, 10, 2, hawb1), receivedPcs1+"/"+receivedWeight1);
    	Assert.assertEquals(tblGetTextByColValue(table_details, 11, 2, hawb1), deliveredPcs1+"/"+deliveredWeight1);
    	
    	Assert.assertEquals(tblGetTextByColValue(table_details, 9, 2, hawb2), statedPcs2+"/"+statedWeight2);
    	Assert.assertEquals(tblGetTextByColValue(table_details, 10, 2, hawb2), receivedPcs2+"/"+receivedWeight2);
    	Assert.assertEquals(tblGetTextByColValue(table_details, 11, 2, hawb2), deliveredPcs2+"/"+deliveredWeight2);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method will check the stated pcs/wgt, rcvd pcs/wgt and dlvrd pcs/wgt details of one house in an AWB
     * @param awbPrefix
     * @param awbNo
     * @param hawb1
     * @param statedPcs1
     * @param statedWeight1
     * @param receivedPcs1
     * @param receivedWeight1
     * @param deliveredPcs1
     * @param deliveredWeight1
     * @return
     */
    public OPR286 verifyPcsAndWeightOfOneHouse(String awbPrefix, String awbNo,String hawb1, String statedPcs1, String statedWeight1, 
    		String receivedPcs1, String receivedWeight1, String deliveredPcs1, String deliveredWeight1){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	hawb1 = PropertyHandler.getPropValue(dataFilePath, hawb1);
    	statedPcs1 = PropertyHandler.getPropValue(dataFilePath, statedPcs1);
    	statedWeight1 = PropertyHandler.getPropValue(dataFilePath, statedWeight1);
    	receivedPcs1 = PropertyHandler.getPropValue(dataFilePath, receivedPcs1);
    	receivedWeight1 = PropertyHandler.getPropValue(dataFilePath, receivedWeight1);
    	deliveredPcs1 = PropertyHandler.getPropValue(dataFilePath, deliveredPcs1);
    	deliveredWeight1 = PropertyHandler.getPropValue(dataFilePath, deliveredWeight1);
    	
    	list(awbPrefix, awbNo);
    	Assert.assertEquals(tblGetTextByColValue(table_details, 9, 2, hawb1), statedPcs1+"/"+statedWeight1);
    	Assert.assertEquals(tblGetTextByColValue(table_details, 10, 2, hawb1), receivedPcs1+"/"+receivedWeight1);
    	Assert.assertEquals(tblGetTextByColValue(table_details, 11, 2, hawb1), deliveredPcs1+"/"+deliveredWeight1);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method save the received pcs and weight of two houses in single AWB
     * @param awbPrefix
     * @param awbNo
     * @param hawb1
     * @param storageUnit1
     * @param location1
     * @param receivedPcs1
     * @param receivedWeight1
     * @param hawb2
     * @param storageUnit2
     * @param location2
     * @param receivedPcs2
     * @param receivedWeight2
     * @return
     */
    public OPR286 saveDetailsOfTwoHouses(String awbPrefix, String awbNo, String hawb1, String storageUnit1, String location1,
    		String receivedPcs1, String receivedWeight1,String hawb2, String storageUnit2, String location2,
    		String receivedPcs2, String receivedWeight2){
    	
    	int hawb1RowNo;
    	int hawb2RowNo;
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	hawb1 = PropertyHandler.getPropValue(dataFilePath, hawb1);
    	storageUnit1 = PropertyHandler.getPropValue(dataFilePath, storageUnit1);
    	location1 = PropertyHandler.getPropValue(dataFilePath, location1);
    	receivedPcs1 = PropertyHandler.getPropValue(dataFilePath, receivedPcs1);
    	receivedWeight1 = PropertyHandler.getPropValue(dataFilePath, receivedWeight1);
    	hawb2 = PropertyHandler.getPropValue(dataFilePath, hawb2);
    	storageUnit2 = PropertyHandler.getPropValue(dataFilePath, storageUnit2);
    	location2 = PropertyHandler.getPropValue(dataFilePath, location2);
    	receivedPcs2 = PropertyHandler.getPropValue(dataFilePath, receivedPcs2);
    	receivedWeight2 = PropertyHandler.getPropValue(dataFilePath, receivedWeight2);
    	
    	list(awbPrefix, awbNo);
    	hawb1RowNo = getTableRowNumber(table_details, 2, hawb1);
    	hawb2RowNo = getTableRowNumber(table_details, 2, hawb2);
    	enterKeys(getWebElements(txt_storageUnit).get(hawb1RowNo-1), storageUnit1);
    	enterKeys(getWebElements(txt_location).get(hawb1RowNo-1), location1);
    	enterKeys(getWebElements(txt_rcvdPcs).get(hawb1RowNo-1), receivedPcs1);
    	enterKeys(getWebElements(txt_rcvdWgt).get(hawb1RowNo-1), receivedWeight1);
    	
    	enterKeys(getWebElements(txt_storageUnit).get(hawb2RowNo-1), storageUnit2);
    	enterKeys(getWebElements(txt_location).get(hawb2RowNo-1), location2);
    	enterKeys(getWebElements(txt_rcvdPcs).get(hawb2RowNo-1), receivedPcs2);
    	enterKeys(getWebElements(txt_rcvdWgt).get(hawb2RowNo-1), receivedWeight2);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	hawb1RowNo = getTableRowNumber(table_details, 2, hawb1);
    	hawb2RowNo = getTableRowNumber(table_details, 2, hawb2);
    	Assert.assertEquals(getWebElements(txt_storageUnit).get(hawb1RowNo-1).getAttribute("value"), storageUnit1);
    	Assert.assertEquals(getWebElements(txt_location).get(hawb1RowNo-1).getAttribute("value"), location1);
    	Assert.assertEquals(getWebElements(txt_rcvdPcs).get(hawb1RowNo-1).getAttribute("value"), receivedPcs1);
    	Assert.assertEquals(getWebElements(txt_rcvdWgt).get(hawb1RowNo-1).getAttribute("value"), receivedWeight1);
    	
    	Assert.assertEquals(getWebElements(txt_storageUnit).get(hawb2RowNo-1).getAttribute("value"), storageUnit2);
    	Assert.assertEquals(getWebElements(txt_location).get(hawb2RowNo-1).getAttribute("value"), location2);
    	Assert.assertEquals(getWebElements(txt_rcvdPcs).get(hawb2RowNo-1).getAttribute("value"), receivedPcs2);
    	Assert.assertEquals(getWebElements(txt_rcvdWgt).get(hawb2RowNo-1).getAttribute("value"), receivedWeight2);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method verifies if the saved pcs, weight, su and location details are showing correctly on relisting
     * @param awbPrefix
     * @param awbNo
     * @param hawb1
     * @param storageUnit1
     * @param location1
     * @param receivedPcs1
     * @param receivedWeight1
     * @param hawb2
     * @param storageUnit2
     * @param location2
     * @param receivedPcs2
     * @param receivedWeight2
     * @return
     */
    public OPR286 verifySavedDetailsOfTwoHouses(String awbPrefix, String awbNo, String hawb1, String storageUnit1, String location1,
    		String receivedPcs1, String receivedWeight1,String hawb2, String storageUnit2, String location2,
    		String receivedPcs2, String receivedWeight2){
    	
    	int hawb1RowNo;
    	int hawb2RowNo;
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	hawb1 = PropertyHandler.getPropValue(dataFilePath, hawb1);
    	storageUnit1 = PropertyHandler.getPropValue(dataFilePath, storageUnit1);
    	location1 = PropertyHandler.getPropValue(dataFilePath, location1);
    	receivedPcs1 = PropertyHandler.getPropValue(dataFilePath, receivedPcs1);
    	receivedWeight1 = PropertyHandler.getPropValue(dataFilePath, receivedWeight1);
    	hawb2 = PropertyHandler.getPropValue(dataFilePath, hawb2);
    	storageUnit2 = PropertyHandler.getPropValue(dataFilePath, storageUnit2);
    	location2 = PropertyHandler.getPropValue(dataFilePath, location2);
    	receivedPcs2 = PropertyHandler.getPropValue(dataFilePath, receivedPcs2);
    	receivedWeight2 = PropertyHandler.getPropValue(dataFilePath, receivedWeight2);
    	
    	list(awbPrefix, awbNo);
    	hawb1RowNo = getTableRowNumber(table_details, 2, hawb1);
    	hawb2RowNo = getTableRowNumber(table_details, 2, hawb2);
    	Assert.assertEquals(getWebElements(txt_storageUnit).get(hawb1RowNo-1).getAttribute("value"), storageUnit1);
    	Assert.assertEquals(getWebElements(txt_location).get(hawb1RowNo-1).getAttribute("value"), location1);
    	Assert.assertEquals(getWebElements(txt_rcvdPcs).get(hawb1RowNo-1).getAttribute("value"), receivedPcs1);
    	Assert.assertEquals(getWebElements(txt_rcvdWgt).get(hawb1RowNo-1).getAttribute("value"), receivedWeight1);
    	
    	Assert.assertEquals(getWebElements(txt_storageUnit).get(hawb2RowNo-1).getAttribute("value"), storageUnit2);
    	Assert.assertEquals(getWebElements(txt_location).get(hawb2RowNo-1).getAttribute("value"), location2);
    	Assert.assertEquals(getWebElements(txt_rcvdPcs).get(hawb2RowNo-1).getAttribute("value"), receivedPcs2);
    	Assert.assertEquals(getWebElements(txt_rcvdWgt).get(hawb2RowNo-1).getAttribute("value"), receivedWeight2);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method receives and saves pcs and weight which is greater than stated pcs and wgt
     * @param awbPrefix
     * @param awbNo
     * @param hawb
     * @param storageUnit
     * @param location
     * @param receivedPcs
     * @param receivedWeight
     * @return
     */
    public OPR286 receivePcsAndWgtGraterThanStated(String awbPrefix, String awbNo, String hawb, String storageUnit, String location,
    		String receivedPcs, String receivedWeight){
    	
    	int hawb1RowNo;
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	hawb = PropertyHandler.getPropValue(dataFilePath, hawb);
    	storageUnit = PropertyHandler.getPropValue(dataFilePath, storageUnit);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	receivedPcs = PropertyHandler.getPropValue(dataFilePath, receivedPcs);
    	receivedWeight = PropertyHandler.getPropValue(dataFilePath, receivedWeight);
    	
    	list(awbPrefix, awbNo);
    	hawb1RowNo = getTableRowNumber(table_details, 2, hawb);
    	enterKeys(getWebElements(txt_storageUnit).get(hawb1RowNo-1), storageUnit);
    	enterKeys(getWebElements(txt_location).get(hawb1RowNo-1), location);
    	enterKeys(getWebElements(txt_rcvdPcs).get(hawb1RowNo-1), receivedPcs);
    	enterKeys(getWebElements(txt_rcvdWgt).get(hawb1RowNo-1), receivedWeight);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Deconsolidated Pcs/Wt is greater than the stated Pcs/Wt of the HAWBs "+hawb+". Do you want to continue?");
    	click(btn_dialogueNo);
    	minWait();
    	waitForFrameAndSwitch(FRAME);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Deconsolidated Pcs/Wt is greater than the stated Pcs/Wt of the HAWBs "+hawb+". Do you want to continue?");
    	click(btn_dialogueYes);
    	minWait();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	hawb1RowNo = getTableRowNumber(table_details, 2, hawb);
    	Assert.assertEquals(getWebElements(txt_storageUnit).get(hawb1RowNo-1).getAttribute("value"), storageUnit);
    	Assert.assertEquals(getWebElements(txt_location).get(hawb1RowNo-1).getAttribute("value"), location);
    	Assert.assertEquals(getWebElements(txt_rcvdPcs).get(hawb1RowNo-1).getAttribute("value"), receivedPcs);
    	Assert.assertEquals(getWebElements(txt_rcvdWgt).get(hawb1RowNo-1).getAttribute("value"), receivedWeight);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method verifies if the saved details showing correctly for single house on relisting the AWB 
     * @param awbPrefix
     * @param awbNo
     * @param hawb1
     * @param storageUnit1
     * @param location1
     * @param receivedPcs1
     * @param receivedWeight1
     * @return
     */
    public OPR286 verifySavedDetailsOfOneHouse(String awbPrefix, String awbNo, String hawb1, String storageUnit1, String location1,
    		String receivedPcs1, String receivedWeight1){
    	
    	int hawb1RowNo;
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	hawb1 = PropertyHandler.getPropValue(dataFilePath, hawb1);
    	storageUnit1 = PropertyHandler.getPropValue(dataFilePath, storageUnit1);
    	location1 = PropertyHandler.getPropValue(dataFilePath, location1);
    	receivedPcs1 = PropertyHandler.getPropValue(dataFilePath, receivedPcs1);
    	receivedWeight1 = PropertyHandler.getPropValue(dataFilePath, receivedWeight1);
    	
    	list(awbPrefix, awbNo);
    	hawb1RowNo = getTableRowNumber(table_details, 2, hawb1);
    	Assert.assertEquals(getWebElements(txt_storageUnit).get(hawb1RowNo-1).getAttribute("value"), storageUnit1);
    	Assert.assertEquals(getWebElements(txt_location).get(hawb1RowNo-1).getAttribute("value"), location1);
    	Assert.assertEquals(getWebElements(txt_rcvdPcs).get(hawb1RowNo-1).getAttribute("value"), receivedPcs1);
    	Assert.assertEquals(getWebElements(txt_rcvdWgt).get(hawb1RowNo-1).getAttribute("value"), receivedWeight1);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method deletes rcvd pcs and wght for single hawb
     * @param awbPrefix
     * @param awbNo
     * @return
     */
    public OPR286 deleteReceivedPcsAndWeightForSingleHAWB(String awbPrefix, String awbNo){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	list(awbPrefix, awbNo);
    	check(chkbox_selectTableItem);
    	click(btn_delete);
    	minWait();
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	Assert.assertEquals(waitForElement(txt_storageUnit).getText().trim().length(), 0);
    	Assert.assertEquals(waitForElement(txt_location).getText().trim().length(), 0);
    	Assert.assertEquals(waitForElement(txt_rcvdPcs).getAttribute("value").trim().length(), 0);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method verifies if pcs and wgt are deleted for a single hawb
     * @param awbPrefix
     * @param awbNo
     * @return
     */
    public OPR286 verifyPcsAndWeightDeleted(String awbPrefix, String awbNo){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	list(awbPrefix, awbNo);
    	Assert.assertEquals(waitForElement(txt_storageUnit).getText().trim().length(), 0);
    	Assert.assertEquals(waitForElement(txt_location).getText().trim().length(), 0);
    	Assert.assertEquals(waitForElement(txt_rcvdPcs).getAttribute("value").trim().length(), 0);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method split the receiving pieces into two locations and save the details
     * @param awbPrefix
     * @param awbNo
     * @param piece1
     * @param weight1
     * @param su1
     * @param location1
     * @param piece2
     * @param weight2
     * @param su2
     * @param location2
     * @return
     */
    public OPR286 splitShipmentsIntoTwoLocations(String awbPrefix, String awbNo, String piece1, String weight1, String su1,
    		String location1, String piece2, String weight2, String su2, String location2){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	piece1 = PropertyHandler.getPropValue(dataFilePath, piece1);
    	weight1 = PropertyHandler.getPropValue(dataFilePath, weight1);
    	su1 = PropertyHandler.getPropValue(dataFilePath, su1);
    	location1 = PropertyHandler.getPropValue(dataFilePath, location1);
    	piece2 = PropertyHandler.getPropValue(dataFilePath, piece2);
    	weight2 = PropertyHandler.getPropValue(dataFilePath, weight2);
    	su2 = PropertyHandler.getPropValue(dataFilePath, su2);
    	location2 = PropertyHandler.getPropValue(dataFilePath, location2);
    	
    	list(awbPrefix, awbNo);
    	click(icon_splitShipment);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(splitShipment_txt_splitInto), "2");
    	enterKeys(splitShipment_txt_splitInto, Keys.TAB);
    	enterKeys(getWebElements(splitShipment_txt_pcs).get(0), piece1);
    	enterKeys(getWebElements(splitShipment_txt_weight).get(0), weight1);
    	enterKeys(getWebElements(splitShipment_txt_su).get(0), su1);
    	selectSplitLocation(1, location1);
//    	enterKeys(getWebElements(splitShipment_txt_location).get(0), location1);
    	
    	enterKeys(getWebElements(splitShipment_txt_pcs).get(1), piece2);
    	enterKeys(getWebElements(splitShipment_txt_weight).get(1), weight2);
    	enterKeys(getWebElements(splitShipment_txt_su).get(1), su2);
    	selectSplitLocation(2, location2);
//    	enterKeys(getWebElements(splitShipment_txt_location).get(1), location2);
    	click(splitShipment_btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	if (su1 != null)
    		Assert.assertTrue(waitForElement(info_su).getText().contains(su1));
    	if (su2 != null)
    		Assert.assertTrue(waitForElement(info_su).getText().contains(su2));
    	Assert.assertTrue(waitForElement(info_location).getText().contains(location1+"("+piece1+"/"+weight1));
    	Assert.assertTrue(waitForElement(info_location).getText().contains(location2+"("+piece2+"/"+weight2));
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
     * Created by A-7605 on 13-2-18
     * This method verifies if the received pcs is splited into two locations
     * @param awbPrefix
     * @param awbNo
     * @param su1
     * @param location1
     * @param piece1
     * @param weight1
     * @param su2
     * @param location2
     * @param piece2
     * @param weight2
     * @return
     */
    public OPR286 verifyLocationSplitted(String awbPrefix, String awbNo, String su1, String location1,String piece1, String weight1,
    		String su2, String location2, String piece2, String weight2){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	piece1 = PropertyHandler.getPropValue(dataFilePath, piece1);
    	weight1 = PropertyHandler.getPropValue(dataFilePath, weight1);
    	su1 = PropertyHandler.getPropValue(dataFilePath, su1);
    	location1 = PropertyHandler.getPropValue(dataFilePath, location1);
    	piece2 = PropertyHandler.getPropValue(dataFilePath, piece2);
    	weight2 = PropertyHandler.getPropValue(dataFilePath, weight2);
    	su2 = PropertyHandler.getPropValue(dataFilePath, su2);
    	location2 = PropertyHandler.getPropValue(dataFilePath, location2);
    	list(awbPrefix, awbNo);
    	Assert.assertTrue(waitForElement(info_su).getText().contains(su1));
    	Assert.assertTrue(waitForElement(info_su).getText().contains(su2));
    	Assert.assertTrue(waitForElement(info_location).getText().contains(location1+"("+piece1+"/"+weight1));
    	Assert.assertTrue(waitForElement(info_location).getText().contains(location2+"("+piece2+"/"+weight2));
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method perform the deconsolidation complete action
     * @param awbPrefix
     * @param awbNo
     * @return
     */
    public OPR286 saveAsDeconsolidationComplete(String awbPrefix, String awbNo){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	
    	list(awbPrefix, awbNo);
    	click(btn_deconsolidationComplete);
    	minWait();
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_footerMessage).getText().trim(), "Deconsolidation complete is done successfully.");
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	waitForElementNotPresent(info_successMessageToast);
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method checks if the deconsolidation completed
     * @param awbPrefix
     * @param awbNo
     * @return
     */
    public OPR286 verifyDeconsolidationCompleted(String awbPrefix, String awbNo){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	
    	list(awbPrefix, awbNo);
    	Assert.assertTrue(getTableRowCount(table_details)>=1);
    	Assert.assertEquals(waitForElementVisible(btn_deconsolidationComplete).getAttribute("disabled"), "true");
    	return this;
    }
    
    /**
     * Created by A-7605 on 13-2-18
     * This method verifies the error message shown on listing the AWB
     * @param awbPrefix
     * @param awbNo
     * @param expectedErrorMessage
     * @return
     */
    public OPR286 checkErrorMessageOnListingAWB(String awbPrefix, String awbNo, String expectedErrorMessage){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	expectedErrorMessage = PropertyHandler.getPropValue(dataFilePath, expectedErrorMessage);
    	
    	list(awbPrefix, awbNo);
    	Assert.assertEquals(waitForElement(info_error).getText(), expectedErrorMessage);
    	return this;
    }
    
    /**
     * Created by A-7605 pn 13-2-18
     * This method will save the received pcs/wgt for one hawb
     * @param awbPrefix
     * @param awbNo
     * @param hawb1
     * @param storageUnit1
     * @param location1
     * @param receivedPcs1
     * @param receivedWeight1
     * @return
     */
    public OPR286 saveDetailsOfOneHouse(String awbPrefix, String awbNo, String hawb1, String storageUnit1, String location1,
    		String receivedPcs1, String receivedWeight1){
    	
    	int hawb1RowNo;
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	hawb1 = PropertyHandler.getPropValue(dataFilePath, hawb1);
    	storageUnit1 = PropertyHandler.getPropValue(dataFilePath, storageUnit1);
    	location1 = PropertyHandler.getPropValue(dataFilePath, location1);
    	receivedPcs1 = PropertyHandler.getPropValue(dataFilePath, receivedPcs1);
    	receivedWeight1 = PropertyHandler.getPropValue(dataFilePath, receivedWeight1);
    	
    	list(awbPrefix, awbNo);
    	hawb1RowNo = getTableRowNumber(table_details, 2, hawb1);
    	enterKeys(getWebElements(txt_storageUnit).get(hawb1RowNo-1), storageUnit1);
    	enterKeys(getWebElements(txt_location).get(hawb1RowNo-1), location1);
    	enterKeys(getWebElements(txt_rcvdPcs).get(hawb1RowNo-1), receivedPcs1);
    	enterKeys(getWebElements(txt_rcvdWgt).get(hawb1RowNo-1), receivedWeight1);

    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	hawb1RowNo = getTableRowNumber(table_details, 2, hawb1);
    	Assert.assertEquals(getWebElements(txt_storageUnit).get(hawb1RowNo-1).getAttribute("value"), storageUnit1);
    	Assert.assertEquals(getWebElements(txt_location).get(hawb1RowNo-1).getAttribute("value"), location1);
    	Assert.assertEquals(getWebElements(txt_rcvdPcs).get(hawb1RowNo-1).getAttribute("value"), receivedPcs1);
    	Assert.assertEquals(getWebElements(txt_rcvdWgt).get(hawb1RowNo-1).getAttribute("value"), receivedWeight1);
    	return this;
    }
    
    /**
     * Created by A-7605 on 7-5-18
     * This method split shipment into two location for each of the two houses in the AWB
     * @param awbPrefix
     * @param awbNo
     * @param house1
     * @param house1Pcs1
     * @param house1Wgt1
     * @param house1Loc1
     * @param house1Pcs2
     * @param house1Wgt2
     * @param house1Loc2
     * @param house2
     * @param house2Pcs1
     * @param house2Wgt1
     * @param house2Loc1
     * @param house2Pcs2
     * @param house2Wgt2
     * @param house2Loc2
     * @return
     */
    public OPR286 splitShipmentsIntoTwoLocations_TwoHouses(String awbPrefix, String awbNo, String house1, String house1Pcs1, String house1Wgt1, String house1Loc1,String house1Pcs2, String house1Wgt2,String house1Loc2,
    		String house2, String house2Pcs1, String house2Wgt1, String house2Loc1,String house2Pcs2, String house2Wgt2,String house2Loc2){
    	
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	house1 = PropertyHandler.getPropValue(dataFilePath, house1);
    	house1Pcs1 = PropertyHandler.getPropValue(dataFilePath, house1Pcs1);
    	house1Wgt1 = PropertyHandler.getPropValue(dataFilePath, house1Wgt1);
    	house1Loc1 = PropertyHandler.getPropValue(dataFilePath, house1Loc1);
    	house1Pcs2 = PropertyHandler.getPropValue(dataFilePath, house1Pcs2);
    	house1Wgt2 = PropertyHandler.getPropValue(dataFilePath, house1Wgt2);
    	house1Loc2 = PropertyHandler.getPropValue(dataFilePath, house1Loc2);
    	house2 = PropertyHandler.getPropValue(dataFilePath, house2);
    	house2Pcs1 = PropertyHandler.getPropValue(dataFilePath, house2Pcs1);
    	house2Wgt1 = PropertyHandler.getPropValue(dataFilePath, house2Wgt1);
    	house2Loc1 = PropertyHandler.getPropValue(dataFilePath, house2Loc1);
    	house2Pcs2 = PropertyHandler.getPropValue(dataFilePath, house2Pcs2);
    	house2Wgt2 = PropertyHandler.getPropValue(dataFilePath, house2Wgt2);
    	house2Loc2 = PropertyHandler.getPropValue(dataFilePath, house2Loc2);
    	
    	list(awbPrefix, awbNo);
    	splitShipmentBasedOnHouse(house1, house1Pcs1, house1Wgt1, "", house1Loc1, house1Pcs2, house1Wgt2, "", house1Loc2);
    	minWait();
    	splitShipmentBasedOnHouse(house2, house2Pcs1, house2Wgt1, "", house2Loc1, house2Pcs2, house1Wgt2, "", house2Loc2);
    	minWait();
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Saved successfully. Do you want to list the saved details?");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    
    private void splitShipmentBasedOnHouse(String house,String pcs1,String wgt1, String su1,String location1,String pcs2, String wgt2,String su2,String location2){
    	int houseRowNumber = getTableRowNumber(table_details, 2, house);
    	click(getWebElements(icon_splitShipment).get(houseRowNumber - 1));
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	minWait();
    	switchToSecondWindow();
    	enterKeys(waitForElement(splitShipment_txt_splitInto), "2");
    	enterKeys(splitShipment_txt_splitInto, Keys.TAB);
    	enterKeys(getWebElements(splitShipment_txt_pcs).get(0), pcs1);
    	enterKeys(getWebElements(splitShipment_txt_weight).get(0), wgt1);
    	if(su1 != null && su1.trim().length()>0)
    		enterKeys(getWebElements(splitShipment_txt_su).get(0), su1);
    	selectSplitLocation(1, location1);
    	enterKeys(getWebElements(splitShipment_txt_pcs).get(1), pcs2);
    	enterKeys(getWebElements(splitShipment_txt_weight).get(1), wgt2);
    	if(su1 != null && su1.trim().length()>0)
    		enterKeys(getWebElements(splitShipment_txt_su).get(1), su2);
    	selectSplitLocation(2, location2);
    	click(splitShipment_btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    }
}
