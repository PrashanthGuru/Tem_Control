package com.ibsplc.pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/22/2017.
 */
public class OPR064 extends BasePage {

	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	private static String FRAME = "iCargoContentFrameOPR064";
	private static String FRAME_OPR293 = "iCargoContentFrameOPR293";
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	private WebDriver driver;
	private String dataFileName;

	private By txt_awbPre,
	txt_awbNo,
	btn_addToList,
	btn_clear,
	tbl_deliveryDtls,
	txt_pcs,
	txt_wt,
	txt_agentName,
	txt_address,
	txt_remarks,
	btn_save,
	btn_close,
	btn_noBtn,
	txt_consignee,
	table_deliveryDetails,
	checkbox_checkAll,
	btn_genericYes,
	info_footerMessage,
	txt_hawb,
	duplicateAWB_table,
	duplicateAWB_btn_ok,
	txt_deliveredTo,
	icon_splitShipment,
	groupDelivery_txt_pieces,
	groupDelivery_txt_weight,
	groupDelivery_btn_ok,
	groupDelivery_btn_close,
	info_successNotificationToast,
	txt_uld,
	chkbox_doorDelivery,
	info_errorMessage,
	shipmentLocations_table,
	shipmentLocations_txt_pcs,
	shipmentLocations_btn_ok;


	public OPR064(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		this.dataFilePath = dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
		initElements();
	}

	private void initElements() {
		txt_awbPre = MiscUtility.getWebElement(objFilepath, "OPR064_txt_awbPre");
		txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR064_txt_awbNo");
		btn_addToList = MiscUtility.getWebElement(objFilepath, "OPR064_btn_addToList");
		btn_clear = MiscUtility.getWebElement(objFilepath, "OPR064_btn_clear");
		tbl_deliveryDtls = MiscUtility.getWebElement(objFilepath, "OPR064_tbl_deliveryDtls");
		txt_pcs = MiscUtility.getWebElement(objFilepath, "OPR064_txt_pcs");
		txt_wt = MiscUtility.getWebElement(objFilepath, "OPR064_txt_wt");
		btn_save = MiscUtility.getWebElement(objFilepath, "OPR064_btn_save");
		btn_close = MiscUtility.getWebElement(objFilepath, "OPR064_btn_close");
		txt_agentName = MiscUtility.getWebElement(objFilepath, "OPR064_txt_agentName");
		txt_address = MiscUtility.getWebElement(objFilepath, "OPR064_txt_address");
		txt_remarks = MiscUtility.getWebElement(objFilepath, "OPR064_txt_remarks");
		txt_consignee = MiscUtility.getWebElement(objFilepath, "OPR064_txt_consignee");
		table_deliveryDetails = MiscUtility.getWebElement(objFilepath, "OPR064_table_deliveryDetails");
		checkbox_checkAll = MiscUtility.getWebElement(objFilepath, "OPR064_checkbox_checkAll");

		btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		info_footerMessage = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
		txt_hawb = MiscUtility.getWebElement(objFilepath, "OPR064_txt_hawb");
		duplicateAWB_table = MiscUtility.getWebElement(objFilepath, "OPR064_duplicateAWB_table");
		duplicateAWB_btn_ok = MiscUtility.getWebElement(objFilepath, "OPR064_duplicateAWB_btn_ok");
		txt_deliveredTo = MiscUtility.getWebElement(objFilepath, "OPR064_txt_deliveredTo");
		icon_splitShipment = MiscUtility.getWebElement(objFilepath, "OPR064_icon_splitShipment");
		groupDelivery_txt_pieces = MiscUtility.getWebElement(objFilepath, "OPR064_GroupDelivery_txt_pieces");
		groupDelivery_txt_weight = MiscUtility.getWebElement(objFilepath, "OPR064_GroupDelivery_txt_weight");
		groupDelivery_btn_ok = MiscUtility.getWebElement(objFilepath, "OPR064_GroupDelivery_btn_ok");
		groupDelivery_btn_close = MiscUtility.getWebElement(objFilepath, "OPR064_GroupDelivery_btn_close");
		info_successNotificationToast = MiscUtility.getWebElement(genObjPath, "Info_successMessageToast");
		txt_uld = MiscUtility.getWebElement(objFilepath, "OPR064_txt_uld");
		chkbox_doorDelivery = MiscUtility.getWebElement(objFilepath, "OPR064_chkbox_doorDelivery");
		info_errorMessage = MiscUtility.getWebElement(genObjPath, "Generic_footer_error");

		shipmentLocations_table = MiscUtility.getWebElement(objFilepath, "OPR064_ShipmentLocations_table");
		shipmentLocations_txt_pcs = MiscUtility.getWebElement(objFilepath, "OPR064_ShipmentLocations_txt_pcs");
		shipmentLocations_btn_ok = MiscUtility.getWebElement(objFilepath, "OPR064_ShipmentLocations_btn_ok");
	}

	private void list(String awbPre, String awbNo) {
		enterKeys(txt_awbPre, awbPre);
		enterKeys(txt_awbNo, awbNo);
		click(btn_addToList);
		minWait();
	}

	/**
	 * Performs delivery of the given AWB No of specified pcs and wt.
	 *
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param agentName
	 * @return
	 * @author Arun A-7681 on 22/12
	 */
	public OPR064 performDelivery(String awbPre, String awbNo, String pcs, String wt, String agentName) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		agentName = PropertyHandler.getPropValue(dataFilePath, agentName);

		list(awbPre,awbNo);

		enterKeys(txt_pcs,pcs);
		enterKeys(txt_wt,wt);
		enterKeys(txt_agentName,agentName);
		enterKeys(txt_address,"Address");
		enterKeys(txt_remarks,"By automation");
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		click(btn_genericYes);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		closeAndmoveToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		return this;

	}

	/**
	 * Performs delivery of the given AWB No of specified pcs and wt.
	 *
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param agentName
	 * @return
	 * @author A-7868 <23/02/2018>
	 */
	public OPR064 performDeliveryWithoutListing(String awbPre, String awbNo, String pcs, String wt, String agentName) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		agentName = PropertyHandler.getPropValue(dataFilePath, agentName);

		minWait();

		check(checkbox_checkAll);
		/* tblsetTextByColValue(tbl_deliveryDtls, 10, 2, awbPre+" "+awbNo, pcs);
        tblsetTextByColValue(tbl_deliveryDtls, 11, 2, awbPre+" "+awbNo, wt);*/

		enterKeys(txt_agentName,agentName);
		enterKeys(txt_address,"Address");
		enterKeys(txt_remarks,"By automation");
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		try{
			click(btn_genericYes);
			minWait();
			waitForNewWindow(2);
			switchToSecondWindow();
			closeAndmoveToFirstWindow();
		}catch(TimeoutException te){

		}        
		waitForFrameAndSwitch("iCargoContentFrameOPR043");

		return this;

	}

	public OPR064 performDeliveryNo(String awbPre, String awbNo, String pcs11, String wt11, String agentName) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);


		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs11 = PropertyHandler.getPropValue(dataFilePath, pcs11);
		wt11 = PropertyHandler.getPropValue(dataFilePath, wt11);
		agentName = PropertyHandler.getPropValue(dataFilePath, agentName);

		list(awbPre,awbNo);

		enterKeys(txt_pcs,pcs11);
		enterKeys(txt_wt,wt11);
		enterKeys(txt_agentName,agentName);
		enterKeys(txt_address,"Address");
		enterKeys(txt_remarks,"By automation");
		click(btn_save);
		minWait();
		click(btn_noBtn);
		minWait();
		return this;

	}

	/**
	 * Created by a-7605 on 03/01/2017
	 */

	public OPR064 checkDeliveryDetails(String consigneeName,String dID1){
		dID1 = PropertyHandler.getPropValue(dataFilePath, dID1);
		consigneeName = PropertyHandler.getPropValue(dataFilePath, consigneeName);
		enterKeys(txt_consignee, consigneeName);
		click(btn_addToList);
		minWait();
		List<String> colValues = getTableColumnValues(table_deliveryDetails, 9);
		boolean isFound = false;
		for(String colValue:colValues){
			if(colValue.contains(dID1)){
				isFound = true;
				break;
			}
		}
		Assert.assertTrue(isFound);
		return this;
	}

	/**
	 * CLose and screen and go to home page
	 *
	 * @return
	 * @author Arun A-7681 21/12
	 */
	public HomePage close() {

		click(btn_close);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {

			click(btn_genericYes);
		}
		return new HomePage(driver, dataFileName);
	}

	/**
	 * Close the screen and return to OPR043
	 *
	 * @return
	 * @author A-7868 Krishna <23/02/2018>
	 */
	public OPR043 returnToOPR043() {

		click(btn_close);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {

			click(btn_genericYes);
		}
		return new OPR043(driver, dataFileName);
	}
	/**
	 * Created by A-7605 on 14-3-18
	 * This method perform delivery of full pcs and weight
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param agentName
	 * @return
	 */
	public OPR064 deliverFullPcsAndWgt(String awbPre, String awbNo, String pcs, String wt, String agentName) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		agentName = PropertyHandler.getPropValue(dataFilePath, agentName);

		list(awbPre,awbNo);

		enterKeys(txt_pcs,pcs);
		enterKeys(txt_wt,wt);
		enterKeys(txt_agentName,agentName);
		enterKeys(txt_address,"Address");
		enterKeys(txt_remarks,"By automation");
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertEquals(waitForElement(info_footerMessage).getText().trim(), "Saved Succesfully");
		waitForFrameAndSwitch(FRAME);
		return this;

	}

	/**
	 * Method to list an awb and validate the pending pcs/wt to be delivered
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @return
	 * @author A-7868 Krishna <23/03/2018>
	 */
	public OPR064 checkPendingPcs(String awbPre, String awbNo, String pcs, String wt){

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);

		list(awbPre, awbNo);
		Assert.assertTrue(waitForElement(txt_pcs).getAttribute("value").contains(pcs), "ERROR : Pending pcs mismatch.");
		Assert.assertTrue(waitForElement(txt_wt).getAttribute("value").contains(wt), "ERROR : Pending pcs mismatch.");
		return this;

	}
	/**
	 * Created by A-7605 on 13-5-18
	 * This method if specified delivery ids and dn numbers are showing in the delivery details table.
	 * @param activeDeliveryID
	 * @param dnDetails
	 * @return
	 */
	public OPR293 verifyDeliveryIDs(String[] activeDeliveryID, String[] dnDetails){
		for(int i=0;i<activeDeliveryID.length;i++){
			Assert.assertTrue(driver.getTitle().contains("Deliver Cargo"));
			Assert.assertTrue(getTableCellValue(table_deliveryDetails, 10, 2).contains(activeDeliveryID[i]));
			Assert.assertTrue(getTableCellValue(table_deliveryDetails, 11, 2).contains(dnDetails[i]));
		}
		close();
		minWait();
		waitForFrameAndSwitch(FRAME_OPR293);
		return new OPR293(driver, dataFileName);
	}

	private void listWithHouse(String hawb, String awbPrefix, String awbNo){
		enterKeys(txt_hawb, hawb);
		click(btn_addToList);
		minWait();
		driver.switchTo().defaultContent();
		if(getNumberOfWindows() == 2){
			switchToSecondWindow();
			String fullAWBNo = awbPrefix+"-"+awbNo;
			tblSelectRowByColValue(duplicateAWB_table, 1, 2, fullAWBNo);
			click(duplicateAWB_btn_ok);
			switchToFirstWindow();
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
	}
	/**
	 * Created by A-7605 on 17-4-18
	 * This method list with HAWB and perform the delivery
	 * @param houseName
	 * @param awbPrefix
	 * @param awbNo
	 * @param pieces
	 * @param weight
	 * @param agentCode
	 * @param activeDeliveryID
	 * @param dnNo
	 * @return
	 */
	public OPR064 listWithHouseAndDeliverPieces(String houseName, String awbPrefix, String awbNo, String pieces, String weight, String agentCode, String activeDeliveryID, String... dnNo){
		houseName = PropertyHandler.getPropValue(dataFilePath, houseName);
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		activeDeliveryID = PropertyHandler.getPropValue(dataFilePath, activeDeliveryID);
		for(int i=0; i<dnNo.length; i++)
			dnNo[i] = PropertyHandler.getPropValue(dataFilePath, dnNo[i]);

		listWithHouse(houseName, awbPrefix, awbNo);
		Assert.assertTrue(getTableCellValue(table_deliveryDetails, 10, 2).contains(activeDeliveryID));
		for(int i=0; i<dnNo.length; i++)
			Assert.assertTrue(getTableCellValue(table_deliveryDetails, 11, 2).contains(dnNo[i]));
		Assert.assertEquals(waitForElement(txt_pcs).getAttribute("value"), pieces);
		Assert.assertEquals(waitForElement(txt_wt).getAttribute("value"), weight);
		enterKeys(txt_deliveredTo, agentCode);
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_noBtn)){
			click(btn_noBtn);
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	private void listWithAWB(String awbPrefix,String awbNo){
		enterKeys(txt_awbPre, awbPrefix);
		enterKeys(txt_awbNo, awbNo);
		click(btn_addToList);
		minWait();
	}

	/**
	 * Created by A-7605 on 17-4-18
	 * This method list with HAWB and perform the delivery
	 * @param awbPrefix
	 * @param awbNo
	 * @param pieces
	 * @param weight
	 * @param agentCode
	 * @param activeDeliveryID
	 * @param dnNo
	 * @return
	 */
	public OPR064 listWithAWBAndDeliverPieces(String awbPrefix, String awbNo, String pieces, String weight, String agentCode, String activeDeliveryID, String... dnNo){
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		activeDeliveryID = PropertyHandler.getPropValue(dataFilePath, activeDeliveryID);
		for(int i=0; i<dnNo.length; i++)
			dnNo[i] = PropertyHandler.getPropValue(dataFilePath, dnNo[i]);

		listWithAWB(awbPrefix, awbNo);
		Assert.assertTrue(getTableCellValue(table_deliveryDetails, 10, 2).contains(activeDeliveryID));
		for(int i=0; i<dnNo.length; i++)
			Assert.assertTrue(getTableCellValue(table_deliveryDetails, 11, 2).contains(dnNo[i]));
		Assert.assertEquals(waitForElement(txt_pcs).getAttribute("value"), pieces);
		Assert.assertEquals(waitForElement(txt_wt).getAttribute("value"), weight);
		enterKeys(txt_deliveredTo, agentCode);
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_noBtn)){
			click(btn_noBtn);
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Created by A-7605 on 17-4-18 
	 * This method perform partial delivery of pcs using split shipment functionality
	 * @param awbPrefix
	 * @param awbNo
	 * @param totalPcs
	 * @param totalWgt
	 * @param deliverPcs
	 * @param deliverWgt
	 * @param customerCode
	 * @param activeDeliveryID
	 * @param dnNo
	 * @return
	 */
	public OPR064 groupDeliveryForSingleDeliveryID(String awbPrefix, String awbNo, String totalPcs, String totalWgt, String deliverPcs, String deliverWgt, String customerCode, String activeDeliveryID, String... dnNo){
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		totalPcs = PropertyHandler.getPropValue(dataFilePath, totalPcs);
		totalWgt = PropertyHandler.getPropValue(dataFilePath, totalWgt);
		deliverPcs = PropertyHandler.getPropValue(dataFilePath, deliverPcs);
		deliverWgt = PropertyHandler.getPropValue(dataFilePath, deliverWgt);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		activeDeliveryID = PropertyHandler.getPropValue(dataFilePath, activeDeliveryID);
		for(int i=0;i<dnNo.length;i++)
			dnNo[i] = PropertyHandler.getPropValue(dataFilePath, dnNo[i]);
		String remainingPcs = String.valueOf((Integer.parseInt(totalPcs)) - (Integer.parseInt(deliverPcs)));
		String remainingWgt = String.valueOf((Integer.parseInt(totalWgt)) - (Integer.parseInt(deliverWgt)));

		listWithAWB(awbPrefix, awbNo);
		Assert.assertTrue(getTableCellValue(table_deliveryDetails, 10, 2).contains(activeDeliveryID), "Actual is '"+getTableCellValue(table_deliveryDetails, 10, 2)+"' expected is '"+activeDeliveryID+"'");
		for(int i=0;i<dnNo.length;i++)
			Assert.assertTrue(getTableCellValue(table_deliveryDetails, 11, 2).contains(dnNo[i]), "Actual is '"+getTableCellValue(table_deliveryDetails, 11, 2)+"' expected is '"+dnNo[i]+"'");
		Assert.assertEquals(waitForElement(txt_pcs).getAttribute("value"), totalPcs, "Actual is '"+waitForElement(txt_pcs).getAttribute("value")+"' expected is '"+totalPcs+"'");
		Assert.assertEquals(waitForElement(txt_wt).getAttribute("value"), totalWgt, "Actual is '"+waitForElement(txt_wt).getAttribute("value")+"' expected is '"+totalWgt+"'");
		click(icon_splitShipment);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(groupDelivery_txt_pieces), deliverPcs);
		enterKeys(waitForElement(groupDelivery_txt_weight), deliverWgt);
		click(groupDelivery_btn_ok);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		enterKeys(txt_deliveredTo, customerCode);
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_noBtn)){
			click(btn_noBtn);
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		minWait();
		waitForElementNotPresent(info_successNotificationToast);
		minWait();
		click(btn_clear);
		minWait();
		listWithAWB(awbPrefix, awbNo);
		Assert.assertEquals(waitForElement(txt_pcs).getAttribute("value"), remainingPcs);
		Assert.assertEquals(waitForElement(txt_wt).getAttribute("value"), remainingWgt);
		Assert.assertEquals(getTableCellValue(table_deliveryDetails, 12, 2).replaceAll(" ", ""), deliverPcs+"/"+deliverWgt);
		return this;
	}

	/**
	 * Created by A-7605 on 17-4-18 
	 * This method perform partial delivery of pcs using split shipment functionality
	 * @param houseAWB
	 * @param awbPrefix
	 * @param awbNo
	 * @param totalPcs
	 * @param totalWgt
	 * @param deliverPcs
	 * @param deliverWgt
	 * @param customerCode
	 * @param activeDeliveryID
	 * @param dnNo
	 * @return
	 */
	public OPR064 groupDeliveryForSingleDeliveryID_HAWB(String houseAWB, String awbPrefix, String awbNo, String totalPcs, String totalWgt, String deliverPcs, String deliverWgt, String customerCode, String activeDeliveryID, String... dnNo){
		houseAWB = PropertyHandler.getPropValue(dataFilePath, houseAWB);
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		totalPcs = PropertyHandler.getPropValue(dataFilePath, totalPcs);
		totalWgt = PropertyHandler.getPropValue(dataFilePath, totalWgt);
		deliverPcs = PropertyHandler.getPropValue(dataFilePath, deliverPcs);
		deliverWgt = PropertyHandler.getPropValue(dataFilePath, deliverWgt);
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		activeDeliveryID = PropertyHandler.getPropValue(dataFilePath, activeDeliveryID);
		for(int i=0;i<dnNo.length;i++)
			dnNo[i] = PropertyHandler.getPropValue(dataFilePath, dnNo[i]);
		String remainingPcs = String.valueOf((Integer.parseInt(totalPcs)) - (Integer.parseInt(deliverPcs)));
		String remainingWgt = String.valueOf((Integer.parseInt(totalWgt)) - (Integer.parseInt(deliverWgt)));

		listWithHouse(houseAWB, awbPrefix, awbNo);
		Assert.assertTrue(getTableCellValue(table_deliveryDetails, 10, 2).contains(activeDeliveryID), "Actual is '"+getTableCellValue(table_deliveryDetails, 10, 2)+"' expected is '"+activeDeliveryID+"'");
		for(int i=0;i<dnNo.length;i++)
			Assert.assertTrue(getTableCellValue(table_deliveryDetails, 11, 2).contains(dnNo[i]), "Actual is '"+getTableCellValue(table_deliveryDetails, 11, 2)+"' expected is '"+dnNo[i]+"'");
		Assert.assertEquals(waitForElement(txt_pcs).getAttribute("value"), totalPcs, "Actual is '"+waitForElement(txt_pcs).getAttribute("value")+"' expected is '"+totalPcs+"'");
		Assert.assertEquals(waitForElement(txt_wt).getAttribute("value"), totalWgt, "Actual is '"+waitForElement(txt_wt).getAttribute("value")+"' expected is '"+totalWgt+"'");
		click(icon_splitShipment);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(groupDelivery_txt_pieces), deliverPcs);
		enterKeys(waitForElement(groupDelivery_txt_weight), deliverWgt);
		click(groupDelivery_btn_ok);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		enterKeys(txt_deliveredTo, customerCode);
		click(btn_save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_noBtn)){
			click(btn_noBtn);
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		minWait();
		waitForElementNotPresent(info_successNotificationToast);
		minWait();
		click(btn_clear);
		minWait();
		listWithAWB(awbPrefix, awbNo);
		Assert.assertEquals(waitForElement(txt_pcs).getAttribute("value"), remainingPcs);
		Assert.assertEquals(waitForElement(txt_wt).getAttribute("value"), remainingWgt);
		Assert.assertEquals(getTableCellValue(table_deliveryDetails, 12, 2).replaceAll(" ", ""), deliverPcs+"/"+deliverWgt);
		return this;
	}

	private void listWithULDNo(String uldNo){
		enterKeys(txt_uld, uldNo);
		click(btn_addToList);
		maxWait();
	}
	/**
	 * Created by A-7605
	 * This method verify the split delivery icon and Delivery pcs/wgt fields are disabled for shipment with delivery id already generated
	 * @param uldNo
	 * @param totalPieces
	 * @param totalWeight
	 * @param activeDeliveryID
	 * @param dnNo
	 * @return
	 */
	public OPR064 verifySplitDeliveryNotPossible(String uldNo, String totalPieces, String totalWeight, String activeDeliveryID, String... dnNo){
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		totalPieces = PropertyHandler.getPropValue(dataFilePath, totalPieces);
		totalWeight = PropertyHandler.getPropValue(dataFilePath, totalWeight);
		activeDeliveryID = PropertyHandler.getPropValue(dataFilePath, activeDeliveryID);
		if(dnNo.length>0){
			for(int i=0; i<dnNo.length; i++)
				dnNo[i] = PropertyHandler.getPropValue(dataFilePath, dnNo[i]);
		}

		listWithULDNo(uldNo);
		Assert.assertNotNull(waitForElementVisible(txt_pcs).getAttribute("readonly"));
		Assert.assertNotNull(waitForElementVisible(txt_wt).getAttribute("readonly"));
		Assert.assertNull(waitForElementVisible(icon_splitShipment).getAttribute("onclick"));
		Assert.assertEquals(waitForElementVisible(txt_pcs).getAttribute("value"), totalPieces);
		Assert.assertEquals(waitForElementVisible(txt_wt).getAttribute("value"), totalWeight);
		if(activeDeliveryID != null && activeDeliveryID.trim().length()>0)
			Assert.assertTrue(getTableCellValue(table_deliveryDetails, 10, 2).contains(activeDeliveryID), "Actual is '"+getTableCellValue(table_deliveryDetails, 10, 2)+"' expected is '"+activeDeliveryID+"'");
		if(dnNo != null && dnNo.length>0){
			for(int i=0;i<dnNo.length;i++)
				Assert.assertTrue(getTableCellValue(table_deliveryDetails, 11, 2).contains(dnNo[i]), "Actual is '"+getTableCellValue(table_deliveryDetails, 11, 2)+"' expected is '"+dnNo[i]+"'");
		}
		return this;
	}
	/**
	 * Created by A-7605
	 * This method verify the split delivery icon and Delivery pcs/wgt fields are disabled for shipment without delivery id (but have DN)
	 * @param uldNo
	 * @param totalPieces
	 * @param totalWeight
	 * @param dnNo
	 * @return
	 */
	public OPR064 verifySplitDeliveryNotPossible_NoDeliveryID(String uldNo, String totalPieces, String totalWeight, String... dnNo){
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		totalPieces = PropertyHandler.getPropValue(dataFilePath, totalPieces);
		totalWeight = PropertyHandler.getPropValue(dataFilePath, totalWeight);

		if(dnNo.length>0){
			for(int i=0; i<dnNo.length; i++)
				dnNo[i] = PropertyHandler.getPropValue(dataFilePath, dnNo[i]);
		}

		listWithULDNo(uldNo);
		Assert.assertNotNull(waitForElementVisible(txt_pcs).getAttribute("readonly"));
		Assert.assertNotNull(waitForElementVisible(txt_wt).getAttribute("readonly"));
		Assert.assertNull(waitForElementVisible(icon_splitShipment).getAttribute("onclick"));
		Assert.assertEquals(waitForElementVisible(txt_pcs).getAttribute("value"), totalPieces);
		Assert.assertEquals(waitForElementVisible(txt_wt).getAttribute("value"), totalWeight);
		if(dnNo != null && dnNo.length>0){
			for(int i=0;i<dnNo.length;i++)
				Assert.assertTrue(getTableCellValue(table_deliveryDetails, 10, 2).contains(dnNo[i]), "Actual is '"+getTableCellValue(table_deliveryDetails, 10, 2)+"' expected is '"+dnNo[i]+"'");
		}
		return this;
	}
	/**
	 * Created by A-7605 on 20-4-18
	 * This method perform delivery of full pcs
	 * @param awbPre
	 * @param awbNo
	 * @param agentName
	 * @return
	 */
	public OPR064 deliverFullPcs(String awbPre, String awbNo, String agentName) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		agentName = PropertyHandler.getPropValue(dataFilePath, agentName);

		list(awbPre,awbNo);
		minWait();
		/*enterKeys(By.name("pickUpPersonName"), "Test");
        enterKeys(By.name("pickupCompanyName"), "TestCompany");
        click(By.xpath("//div[@id='IDDetails']//img"));
        maxWait();
        selectByText(By.xpath("(//select[@name='customerIDType'])[1]"), "Driving License");
        enterKeys(By.xpath("(//input[@name='customerIDDetailsInfo'])[1]"),"123456");
        enterKeys(By.xpath("(//input[@name='customerIdIssuingState'])[1]"),"US");
        selectByText(By.xpath("(//select[@name='customerPhotoIdVerified'])[1]"), "Yes");
        click(By.xpath("//span[text()='ID Details']/../button"));*/
        maxWait();
		enterKeys(By.xpath("//input[@name='deliveredTo']"),agentName);
		enterKeys(txt_address,"Address");
		enterKeys(txt_remarks,"By automation");
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_noBtn);
			minWait();
		}
		//Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		return this;

	}
	/**
	 * Created by A-7605 on 20-4-18
	 * This method perform delivery of full pcs and check if door delivery checkbox checked
	 * @param awbPre
	 * @param awbNo
	 * @param agentName
	 * @return
	 */
	public OPR064 deliverFullPcs_DoorDelivery(String awbPre, String awbNo, String agentName) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		agentName = PropertyHandler.getPropValue(dataFilePath, agentName);

		list(awbPre,awbNo);
		Assert.assertNotNull(waitForElementVisible(chkbox_doorDelivery).getAttribute("checked"));
		enterKeys(txt_agentName,agentName);
		enterKeys(txt_address,"Address");
		enterKeys(txt_remarks,"By automation");
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		return this;

	}

	/**
	 * Created by A-7605 on 20-4-18
	 * This method perform delivery of full pcs
	 * @param awbPre
	 * @param awbNo
	 * @param agentName
	 * @return
	 */
	public OPR064 deliverFullPcs_ListWithULD(String uldNo, String agentName) {
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		agentName = PropertyHandler.getPropValue(dataFilePath, agentName);

		listWithULDNo(uldNo);

		enterKeys(txt_agentName,agentName);
		enterKeys(txt_address,"Address");
		enterKeys(txt_remarks,"By automation");
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		return this;

	}

	public OPR064 clear(){
		click(btn_clear);
		minWait();
		return this;
	}

	/**
	 * Created by A-7605 on 3-5-18
	 * This method perform delivery of partial pcs for an AWB and two houses in another AWB
	 * @param awbPrefix
	 * @param awbNo
	 * @param awbDeliverPcs
	 * @param awbDeliverWeight
	 * @param awbTotalPcs
	 * @param awbTotalWeight
	 * @param house1
	 * @param awbPrefix1
	 * @param awbNo1
	 * @param house1DeliverPcs
	 * @param house1DeliverWeight
	 * @param house1TotalPcs
	 * @param house1TotalWeight
	 * @param house2
	 * @param awbPrefix2
	 * @param awbNo2
	 * @param house2DeliverPcs
	 * @param house2DeliverWeight
	 * @param house2TotalPcs
	 * @param house2TotalWeight
	 * @param agentCode
	 * @return
	 */
	public OPR064 deliverPartialPcsInShipmentInAWBAndTwoHouses(String awbPrefix, String awbNo, String awbDeliverPcs, String awbDeliverWeight, String awbTotalPcs, String awbTotalWeight,String house1, 
			String awbPrefix1, String awbNo1, String house1DeliverPcs, String house1DeliverWeight, String house1TotalPcs, String house1TotalWeight,
			String house2, String awbPrefix2, String awbNo2, String house2DeliverPcs, String house2DeliverWeight, String house2TotalPcs, String house2TotalWeight, String agentCode){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbDeliverPcs = PropertyHandler.getPropValue(dataFilePath, awbDeliverPcs);
		awbDeliverWeight = PropertyHandler.getPropValue(dataFilePath, awbDeliverWeight);
		awbTotalPcs = PropertyHandler.getPropValue(dataFilePath, awbTotalPcs);
		awbTotalWeight = PropertyHandler.getPropValue(dataFilePath, awbTotalWeight);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		awbPrefix1 = PropertyHandler.getPropValue(dataFilePath, awbPrefix1);
		awbNo1 = PropertyHandler.getPropValue(dataFilePath, awbNo1);
		house1DeliverPcs = PropertyHandler.getPropValue(dataFilePath, house1DeliverPcs);
		house1DeliverWeight = PropertyHandler.getPropValue(dataFilePath, house1DeliverWeight);
		house1TotalPcs = PropertyHandler.getPropValue(dataFilePath, house1TotalPcs);
		house1TotalWeight = PropertyHandler.getPropValue(dataFilePath, house1TotalWeight);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		awbPrefix2 = PropertyHandler.getPropValue(dataFilePath, awbPrefix2);
		awbNo2 = PropertyHandler.getPropValue(dataFilePath, awbNo2);
		house2DeliverPcs = PropertyHandler.getPropValue(dataFilePath, house2DeliverPcs);
		house2DeliverWeight = PropertyHandler.getPropValue(dataFilePath, house2DeliverWeight);
		house2TotalPcs = PropertyHandler.getPropValue(dataFilePath, house2TotalPcs);
		house2TotalWeight = PropertyHandler.getPropValue(dataFilePath, house2TotalWeight);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		String fullAWBNo = awbPrefix+" "+awbNo;

		listWithAWB(awbPrefix, awbNo);
		listWithHouse(house1, awbPrefix1, awbNo1);
		listWithHouse(house2, awbPrefix2, awbNo2);

		tblsetTextByColValue(table_deliveryDetails, 13, 4, fullAWBNo, awbDeliverPcs);
		tblsetTextByColValue(table_deliveryDetails, 14, 4, fullAWBNo, awbDeliverWeight);

		tblsetTextByColValue(table_deliveryDetails, 13, 5, house1, house1DeliverPcs);
		tblsetTextByColValue(table_deliveryDetails, 14, 5, house1, house1DeliverWeight);

		tblsetTextByColValue(table_deliveryDetails, 13, 5, house2, house2DeliverPcs);
		tblsetTextByColValue(table_deliveryDetails, 14, 5, house2, house2DeliverWeight);
		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		clear();
		listWithAWB(awbPrefix, awbNo);
		listWithHouse(house1, awbPrefix1, awbNo1);
		listWithHouse(house2, awbPrefix2, awbNo2);

		String awbRemainingPcs = String.valueOf(Integer.parseInt(awbTotalPcs) - Integer.parseInt(awbDeliverPcs));
		String awbRemainingWgt = String.valueOf(Integer.parseInt(awbTotalWeight) - Integer.parseInt(awbDeliverWeight));

		String house1RemainingPcs = String.valueOf(Integer.parseInt(house1TotalPcs) - Integer.parseInt(house1DeliverPcs));
		String house1RemainingWgt = String.valueOf(Integer.parseInt(house1TotalWeight) - Integer.parseInt(house1DeliverWeight));

		String house2RemainingPcs = String.valueOf(Integer.parseInt(house2TotalPcs) - Integer.parseInt(house2DeliverPcs));
		String house2RemainingWgt = String.valueOf(Integer.parseInt(house2TotalWeight) - Integer.parseInt(house2DeliverWeight));

		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 13, 4, fullAWBNo), awbRemainingPcs);
		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 14, 4, fullAWBNo), awbRemainingWgt);

		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 13, 5, house1), house1RemainingPcs);
		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 14, 5, house1), house1RemainingWgt);

		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 13, 5, house2), house2RemainingPcs);
		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 14, 5, house2), house2RemainingWgt);
		return this;
	}

	/**
	 * Created by A-7605 on 3-5-18
	 * This method perform delivery of full pcs for an AWB and two houses in another AWB
	 * @param awbPrefix
	 * @param awbNo
	 * @param awbTotalPcs
	 * @param awbTotalWeight
	 * @param house1
	 * @param awbPrefix1
	 * @param awbNo1
	 * @param house1TotalPcs
	 * @param house1TotalWeight
	 * @param house2
	 * @param awbPrefix2
	 * @param awbNo2
	 * @param house2TotalPcs
	 * @param house2TotalWeight
	 * @param agentCode
	 * @return
	 */
	public OPR064 deliverFullPcsInShipmentInAWBAndTwoHouses(String awbPrefix, String awbNo, String awbTotalPcs, String awbTotalWeight,String house1, 
			String awbPrefix1, String awbNo1, String house1TotalPcs, String house1TotalWeight,
			String house2, String awbPrefix2, String awbNo2, String house2TotalPcs, String house2TotalWeight, String agentCode){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbTotalPcs = PropertyHandler.getPropValue(dataFilePath, awbTotalPcs);
		awbTotalWeight = PropertyHandler.getPropValue(dataFilePath, awbTotalWeight);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		awbPrefix1 = PropertyHandler.getPropValue(dataFilePath, awbPrefix1);
		awbNo1 = PropertyHandler.getPropValue(dataFilePath, awbNo1);
		house1TotalPcs = PropertyHandler.getPropValue(dataFilePath, house1TotalPcs);
		house1TotalWeight = PropertyHandler.getPropValue(dataFilePath, house1TotalWeight);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		awbPrefix2 = PropertyHandler.getPropValue(dataFilePath, awbPrefix2);
		awbNo2 = PropertyHandler.getPropValue(dataFilePath, awbNo2);
		house2TotalPcs = PropertyHandler.getPropValue(dataFilePath, house2TotalPcs);
		house2TotalWeight = PropertyHandler.getPropValue(dataFilePath, house2TotalWeight);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		String fullAWBNo = awbPrefix+" "+awbNo;

		listWithAWB(awbPrefix, awbNo);
		listWithHouse(house1, awbPrefix1, awbNo1);
		listWithHouse(house2, awbPrefix2, awbNo2);

		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 13, 4, fullAWBNo), awbTotalPcs);
		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 14, 4, fullAWBNo), awbTotalWeight);

		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 13, 5, house1), house1TotalPcs);
		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 14, 5, house1), house1TotalWeight);

		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 13, 5, house2), house2TotalPcs);
		Assert.assertEquals(tblGetEditableTextByColValue(table_deliveryDetails, 14, 5, house2), house2TotalWeight);

		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		clear();
		listWithAWB(awbPrefix, awbNo);

		Assert.assertEquals(waitForElement(info_errorMessage).getText(), "No shipments with Active Delivery IDs exists for the specified search criteria");
		return this;
	}
	/**
	 * Created by A-7605 on 4-5-18
	 * This method check if the included AWB are showing and excluded AWB is not showing in delivery screen when listed with consignee
	 * @param consigneeName
	 * @param awbPrefix
	 * @param exculdedAWB
	 * @param includedAWB
	 * @return
	 */
	public OPR064 verifyConsigneeAWBDetails(String consigneeName, String awbPrefix, String exculdedAWB, String... includedAWB){
		consigneeName = PropertyHandler.getPropValue(dataFilePath, consigneeName);
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		exculdedAWB = PropertyHandler.getPropValue(dataFilePath, exculdedAWB);
		for(int i=0; i<includedAWB.length; i++)
			includedAWB[i] = PropertyHandler.getPropValue(dataFilePath, includedAWB[i]);

		listWithConsignee(consigneeName);
		List<String> listedAWBs = getTableColumnValues(table_deliveryDetails, 4);
		for(int i=0; i<includedAWB.length; i++)
			Assert.assertTrue(listedAWBs.contains(awbPrefix+" "+includedAWB[i]));
		Assert.assertFalse(listedAWBs.contains(awbPrefix+" "+exculdedAWB));
		return this;
	}

	private void listWithConsignee(String consignee){
		enterKeys(txt_consignee, consignee);
		click(btn_addToList);
		maxWait();
	}

	//    private void splitShipmentInDifferentLocations(int rowNumber,String totalPcsInLocation, String totalWeightInLocation,String deliveryPcs, String deliveryWeight){
	//    	click(getWebElements(icon_splitShipment).get(rowNumber-1));
	//    	driver.switchTo().defaultContent();
	//    	waitForNewWindow(2);
	//    	switchToSecondWindow();
	//    	tblsetTextByColValue(groupDelivery_table, 2, 1, "["+totalPcsInLocation+"/"+totalWeightInLocation+" /Paid", deliveryPcs);
	//    	tblsetTextByColValue(groupDelivery_table, 3, 1, "["+totalPcsInLocation+"/"+totalWeightInLocation+" /Paid", deliveryWeight);
	//    	click(groupDelivery_btn_ok);
	//    	minWait();
	//    	waitForFrameAndSwitch(FRAME);
	//    }

	/**
	 * Created by A-7605 on 4-5-18
	 * This method perform the delivery of an AWB and HAWB, for which pcs are break down into different locations
	 * @param awbPrefix
	 * @param awbNo
	 * @param AWBDeliveryPcs1
	 * @param AWBDeliveryWeight1
	 * @param AWBDeliveryPcs2
	 * @param AWBDeliveryWeight2
	 * @param AWBTotalPcsInLocation
	 * @param AWBTotalWeightInLocation
	 * @param house
	 * @param house1AWBNo
	 * @param houseDeliveryPcs1
	 * @param houseDeliveryWeight1
	 * @param houseDeliveryPcs2
	 * @param houseDeliveryWeight2
	 * @param houseTotalPcsInLocation
	 * @param houseTotalotalWeightInLocation
	 * @param agentCode
	 * @return
	 */
	public OPR064 checkSplitDeliveryOfAWBAndHouse(String awbPrefix, String awbNo, String AWBDeliveryPcs1, String AWBDeliveryWeight1,String AWBDeliveryPcs2, String AWBDeliveryWeight2,
			String house, String house1AWBNo,String houseDeliveryPcs1, String houseDeliveryWeight1,String houseDeliveryPcs2, String houseDeliveryWeight2, String agentCode){
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		AWBDeliveryPcs1 = PropertyHandler.getPropValue(dataFilePath, AWBDeliveryPcs1);
		AWBDeliveryWeight1 = PropertyHandler.getPropValue(dataFilePath, AWBDeliveryWeight1);
		AWBDeliveryPcs2 = PropertyHandler.getPropValue(dataFilePath, AWBDeliveryPcs2);
		AWBDeliveryWeight2 = PropertyHandler.getPropValue(dataFilePath, AWBDeliveryWeight2);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		house1AWBNo = PropertyHandler.getPropValue(dataFilePath, house1AWBNo);
		houseDeliveryPcs1 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryPcs1);
		houseDeliveryWeight1 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryWeight1);
		houseDeliveryPcs2 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryPcs2);
		houseDeliveryWeight2 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryWeight2);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		String AWBDeliveryPcs = String.valueOf(Integer.parseInt(AWBDeliveryPcs1) + Integer.parseInt(AWBDeliveryPcs2));
		String AWBDeliveryWeight = String.valueOf(Integer.parseInt(AWBDeliveryWeight1) + Integer.parseInt(AWBDeliveryWeight2));
		String houseDeliveryPcs = String.valueOf(Integer.parseInt(houseDeliveryPcs1) + Integer.parseInt(houseDeliveryPcs2));
		String houseDeliveryWeight = String.valueOf(Integer.parseInt(houseDeliveryWeight1) + Integer.parseInt(houseDeliveryWeight2));

		String fullAWB1 = awbPrefix+" "+awbNo;
		String fullAWB2 = awbPrefix+" "+house1AWBNo;

		listWithAWB(awbPrefix, awbNo);
		listWithHouse(house, awbPrefix, house1AWBNo);
		maxWait();
		tblsetTextByColValue(table_deliveryDetails, 12, 4, fullAWB1, AWBDeliveryPcs);
		tblsetTextByColValue(table_deliveryDetails, 13, 4, fullAWB1, AWBDeliveryWeight);
		tblsetTextByColValue(table_deliveryDetails, 12, 4, fullAWB2, houseDeliveryPcs);
		tblsetTextByColValue(table_deliveryDetails, 13, 4, fullAWB2, houseDeliveryWeight);
		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(getWebElements(shipmentLocations_txt_pcs).get(0), AWBDeliveryPcs1);
		enterKeys(getWebElements(shipmentLocations_txt_pcs).get(1), AWBDeliveryPcs2);
		enterKeys(getWebElements(shipmentLocations_txt_pcs).get(2), houseDeliveryPcs1);
		enterKeys(getWebElements(shipmentLocations_txt_pcs).get(3), houseDeliveryPcs2);

		click(shipmentLocations_btn_ok);
		switchToFirstWindow();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	/**
	 * Created by A-7605 on 7-5-18
	 * This method perform full delivery of one AWB and two houses
	 * @param awbPrefix
	 * @param awbNo
	 * @param house1
	 * @param house1AWB
	 * @param house2
	 * @param house2AWB
	 * @param agentCode
	 * @return
	 */
	public OPR064 deliveryOfOneAWBAndTwoHouses(String awbPrefix, String awbNo, String house1, String house1AWB, String house2, String house2AWB, String agentCode){
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house1AWB = PropertyHandler.getPropValue(dataFilePath, house1AWB);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		house2AWB = PropertyHandler.getPropValue(dataFilePath, house2AWB);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house1, awbPrefix, house1AWB);
		minWait();
		listWithHouse(house2, awbPrefix, house2AWB);
		minWait();
		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	/**
	 * Created by A-7605 on 8-5-18
	 * This method perform split partial delivery of an AWB and an HAWB
	 * @param awbPrefix
	 * @param awbNo
	 * @param awbNoTotalPcs
	 * @param awbNoTotalWgt
	 * @param awbDeliveryPcs1
	 * @param awbDeliveryWgt1
	 * @param awbDeliveryPcs2
	 * @param awbDeliveryWgt2
	 * @param house
	 * @param houseawbNo
	 * @param houseTotalPcs
	 * @param houseTotalWeight
	 * @param houseDeliveryPcs1
	 * @param houseDeliveryWgt1
	 * @param houseDeliveryPcs2
	 * @param houseDeliveryWgt2
	 * @param agentCode
	 * @param awbRemainingPcs
	 * @param awbRemainingWgt
	 * @param houseRemainingPcs
	 * @param houseRemainingWgt
	 * @return
	 */
	public OPR064 performSplitPartialDeliveryOfOneHousesAndOneAWB(String awbPrefix, String awbNo,String awbNoTotalPcs, String awbNoTotalWgt,String awbDeliveryPcs1,String awbDeliveryWgt1,String awbDeliveryPcs2,String awbDeliveryWgt2, String house, String houseawbNo, String houseTotalPcs, String houseTotalWeight,
			String houseDeliveryPcs1, String houseDeliveryWgt1,String houseDeliveryPcs2, String houseDeliveryWgt2, String agentCode,String awbRemainingPcs,String awbRemainingWgt,
			String houseRemainingPcs, String houseRemainingWgt){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbNoTotalPcs = PropertyHandler.getPropValue(dataFilePath, awbNoTotalPcs);
		awbNoTotalWgt = PropertyHandler.getPropValue(dataFilePath, awbNoTotalWgt);
		awbDeliveryPcs1 = PropertyHandler.getPropValue(dataFilePath, awbDeliveryPcs1);
		awbDeliveryWgt1 = PropertyHandler.getPropValue(dataFilePath, awbDeliveryWgt1);
		awbDeliveryPcs2 = PropertyHandler.getPropValue(dataFilePath, awbDeliveryPcs2);
		awbDeliveryWgt2 = PropertyHandler.getPropValue(dataFilePath, awbDeliveryWgt2);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		houseawbNo = PropertyHandler.getPropValue(dataFilePath, houseawbNo);
		houseTotalPcs = PropertyHandler.getPropValue(dataFilePath, houseTotalPcs);
		houseTotalWeight = PropertyHandler.getPropValue(dataFilePath, houseTotalWeight);
		houseDeliveryPcs1 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryPcs1);
		houseDeliveryWgt1 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryWgt1);
		houseDeliveryPcs2 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryPcs2);
		houseDeliveryWgt2 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryWgt2);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house, awbPrefix, houseawbNo);
		minWait();
		int rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		int rowNumberOfHouse = getTableRowNumber(table_deliveryDetails, 5, house);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB - 2).getAttribute("value"), awbNoTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB - 2).getAttribute("value"), awbNoTotalWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse - 2).getAttribute("value"), houseTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse - 2).getAttribute("value"), houseTotalWeight);

		String pendingAWBPcs = String.valueOf(Integer.parseInt(awbNoTotalPcs) - (Integer.parseInt(awbDeliveryPcs1) + Integer.parseInt(awbDeliveryPcs2)));
		String pendingAWBWgt = String.valueOf(Integer.parseInt(awbNoTotalWgt) - (Integer.parseInt(awbDeliveryWgt1) + Integer.parseInt(awbDeliveryWgt2)));
		String pendingHAWBPcs = String.valueOf(Integer.parseInt(houseTotalPcs) - (Integer.parseInt(houseDeliveryPcs1) + Integer.parseInt(houseDeliveryPcs2)));
		String pendingHAWBWgt = String.valueOf(Integer.parseInt(houseTotalWeight) - (Integer.parseInt(houseDeliveryWgt1) + Integer.parseInt(houseDeliveryWgt2)));

		splitPcsToTwo(rowNumberOfAWB, awbDeliveryPcs1, awbDeliveryWgt1, awbDeliveryPcs2, awbDeliveryWgt2);
		minWait();
		splitPcsToTwo(rowNumberOfHouse, awbDeliveryPcs1, awbDeliveryWgt1, awbDeliveryPcs2, awbDeliveryWgt2);
		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);

		PropertyHandler.setPropValue(dataFilePath, awbRemainingPcs, pendingAWBPcs);
		PropertyHandler.setPropValue(dataFilePath, awbRemainingWgt, pendingAWBWgt);
		PropertyHandler.setPropValue(dataFilePath, houseRemainingPcs, pendingHAWBPcs);
		PropertyHandler.setPropValue(dataFilePath, houseRemainingWgt, pendingHAWBWgt);
		return this;
	}

	private void splitPcsToTwo(int rowNum, String splitPcs1,String splitWgt1,String splitPcs2,String splitWgt2){
		click(getWebElements(icon_splitShipment).get(rowNum - 2));
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(getWebElements(groupDelivery_txt_pieces).get(0), splitPcs1);
		enterKeys(getWebElements(groupDelivery_txt_weight).get(0), splitWgt1);
		enterKeys(getWebElements(groupDelivery_txt_pieces).get(1), splitPcs2);
		enterKeys(getWebElements(groupDelivery_txt_weight).get(1), splitWgt2);
		click(groupDelivery_btn_ok);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
	}


	private void splitPc_1DN(int rowNum, String splitPcs,String splitWgt){
		click(getWebElements(icon_splitShipment).get(rowNum - 2));
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(getWebElements(groupDelivery_txt_pieces).get(0), splitPcs);
		enterKeys(getWebElements(groupDelivery_txt_weight).get(0), splitWgt);
		click(groupDelivery_btn_ok);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
	}

	/**
	 * Created by A-7605 on 8-5-18
	 * This method perform full delivery of an AWB and an HAWB
	 * @param awbPrefix
	 * @param awbNo
	 * @param awbNoTotalPcs
	 * @param awbNoTotalWgt
	 * @param house
	 * @param houseawbNo
	 * @param houseTotalPcs
	 * @param houseTotalWeight
	 * @param agentCode
	 * @return
	 */
	public OPR064 performFullDeliveryOfOneHouseAndOneAWB(String awbPrefix, String awbNo,String awbNoTotalPcs, String awbNoTotalWgt, String house, String houseawbNo, String houseTotalPcs, String houseTotalWeight,
			String agentCode){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbNoTotalPcs = PropertyHandler.getPropValue(dataFilePath, awbNoTotalPcs);
		awbNoTotalWgt = PropertyHandler.getPropValue(dataFilePath, awbNoTotalWgt);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		houseawbNo = PropertyHandler.getPropValue(dataFilePath, houseawbNo);
		houseTotalPcs = PropertyHandler.getPropValue(dataFilePath, houseTotalPcs);
		houseTotalWeight = PropertyHandler.getPropValue(dataFilePath, houseTotalWeight);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house, awbPrefix, houseawbNo);
		minWait();
		int rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB - 2).getAttribute("value"), awbNoTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB - 2).getAttribute("value"), awbNoTotalWgt);

		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * Created by A-7605 on 8-5-18
	 * This method check if the remaining pcs/wgt are correct after split partial delivery of an AWB and an HAWB
	 * @param awbPrefix
	 * @param awbNo
	 * @param totalAWBPcs
	 * @param totalAWBWgt
	 * @param remainingAWBPcs
	 * @param remainingAWBWgt
	 * @param house
	 * @param houseAWBNo
	 * @param totalHousePcs
	 * @param totalHouseWgt
	 * @param remainingHousePcs
	 * @param remainingHouseWgt
	 * @return
	 */
	public OPR064 checkRemainingPcsForAWBandHAWB(String awbPrefix, String awbNo,String totalAWBPcs,String totalAWBWgt,String remainingAWBPcs,String remainingAWBWgt,
			String house,String houseAWBNo,String totalHousePcs,String totalHouseWgt,String remainingHousePcs,String remainingHouseWgt){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		totalAWBPcs = PropertyHandler.getPropValue(dataFilePath, totalAWBPcs);
		totalAWBWgt = PropertyHandler.getPropValue(dataFilePath, totalAWBWgt);
		remainingAWBPcs = PropertyHandler.getPropValue(dataFilePath, remainingAWBPcs);
		remainingAWBWgt = PropertyHandler.getPropValue(dataFilePath, remainingAWBWgt);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		houseAWBNo = PropertyHandler.getPropValue(dataFilePath, houseAWBNo);
		totalHousePcs = PropertyHandler.getPropValue(dataFilePath, totalHousePcs);
		totalHouseWgt = PropertyHandler.getPropValue(dataFilePath, totalHouseWgt);
		remainingHousePcs = PropertyHandler.getPropValue(dataFilePath, remainingHousePcs);
		remainingHouseWgt = PropertyHandler.getPropValue(dataFilePath, remainingHouseWgt);

		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house, awbPrefix, houseAWBNo);
		minWait();
		int rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		int rowNumberOfHouse = getTableRowNumber(table_deliveryDetails, 5, house);
		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB - 2).getAttribute("value"), remainingAWBPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB - 2).getAttribute("value"), remainingAWBWgt);
		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse - 2).getAttribute("value"), remainingHousePcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse - 2).getAttribute("value"), remainingHouseWgt);

		return this;
	}
	/**
	 * Created by A-7605 on 8-5-18
	 * This method verify if pcs in AWB already delivered
	 * @param awbPrefix
	 * @param awbNo
	 */
	public OPR064 verifyPcsAlreadyDelivered_AWB(String awbPrefix, String awbNo){
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		listWithAWB(awbPrefix, awbNo);
		try{
			Assert.assertEquals(waitForElement(info_errorMessage).getText(), "No shipments with Active Delivery IDs exists for the specified search criteria");
		}catch(AssertionError e){
			Assert.assertEquals(waitForElement(info_errorMessage).getText(), "No shipments with valid DNs exists for the specified search criteria");
		}
		return this;
	}
	/**
	 * Created by A-7605 on 8-5-18
	 * This method verify if pcs in HAWB already delivered
	 * @param awbPrefix
	 * @param awbNo
	 * @param hawb
	 */
	public OPR064 verifyPcsAlreadyDelivered_HAWB(String awbPrefix, String awbNo,String hawb){
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		hawb = PropertyHandler.getPropValue(dataFilePath, hawb);

		listWithHouse(hawb, awbPrefix, awbNo);
		try{
			Assert.assertEquals(waitForElement(info_errorMessage).getText(), "No shipments with Active Delivery IDs exists for the specified search criteria");
		}catch(AssertionError e){
			Assert.assertEquals(waitForElement(info_errorMessage).getText(), "No shipments with valid DNs exists for the specified search criteria");
		}
		return this;
	}

	/**
	 * Created by A-7605 on 10-5-18
	 * This method perform full delivery of two houses and one AWB
	 * @param awbPrefix
	 * @param awbNo
	 * @param awbNoTotalPcs
	 * @param awbNoTotalWgt
	 * @param house1
	 * @param house1awbNo
	 * @param house1TotalPcs
	 * @param house1TotalWeight
	 * @param house2
	 * @param house2awbNo
	 * @param house2TotalPcs
	 * @param house2TotalWeight
	 * @param agentCode
	 * @return
	 */
	public OPR064 performFullDeliveryOfTwoHousesAndOneAWB(String awbPrefix, String awbNo,String awbNoTotalPcs, String awbNoTotalWgt, String house1, String house1awbNo, String house1TotalPcs, String house1TotalWeight,
			String house2, String house2awbNo, String house2TotalPcs, String house2TotalWeight,String agentCode){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbNoTotalPcs = PropertyHandler.getPropValue(dataFilePath, awbNoTotalPcs);
		awbNoTotalWgt = PropertyHandler.getPropValue(dataFilePath, awbNoTotalWgt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house1awbNo = PropertyHandler.getPropValue(dataFilePath, house1awbNo);
		house1TotalPcs = PropertyHandler.getPropValue(dataFilePath, house1TotalPcs);
		house1TotalWeight = PropertyHandler.getPropValue(dataFilePath, house1TotalWeight);

		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		house2awbNo = PropertyHandler.getPropValue(dataFilePath, house2awbNo);
		house2TotalPcs = PropertyHandler.getPropValue(dataFilePath, house2TotalPcs);
		house2TotalWeight = PropertyHandler.getPropValue(dataFilePath, house2TotalWeight);

		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house1, awbPrefix, house1awbNo);
		minWait();
		listWithHouse(house2, awbPrefix, house2awbNo);
		minWait();
		int rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		int rowNumberOfHouse1 = getTableRowNumber(table_deliveryDetails, 5, house1);
		int rowNumberOfHouse2 = getTableRowNumber(table_deliveryDetails, 5, house2);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB - 2).getAttribute("value"), awbNoTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB - 2).getAttribute("value"), awbNoTotalWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse1 - 2).getAttribute("value"), house1TotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse1 - 2).getAttribute("value"), house1TotalWeight);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse2 - 2).getAttribute("value"), house2TotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse2 - 2).getAttribute("value"), house2TotalWeight);

		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * Created by A-7605 on 10-5-18
	 * This method perform partial delivery of an AWB and two HAWBs
	 * @param awbPrefix
	 * @param awbNo
	 * @param awbNoTotalPcs
	 * @param awbNoTotalWgt
	 * @param awbNoDeliveryPcs
	 * @param awbNoDeliveryWgt
	 * @param house1
	 * @param house1awbNo
	 * @param house1TotalPcs
	 * @param house1TotalWeight
	 * @param house1DeliveryPcs
	 * @param house1DeliveryWeight
	 * @param house2
	 * @param house2awbNo
	 * @param house2TotalPcs
	 * @param house2TotalWeight
	 * @param house2DeliveryPcs
	 * @param house2DeliveryWeight
	 * @param agentCode
	 * @return
	 */
	public OPR064 performPartialDeliveryOfTwoHousesAndOneAWB(String awbPrefix, String awbNo,String awbNoTotalPcs, String awbNoTotalWgt,String awbNoDeliveryPcs,String awbNoDeliveryWgt,String house1, String house1awbNo, String house1TotalPcs, String house1TotalWeight,String house1DeliveryPcs,String house1DeliveryWeight,
			String house2, String house2awbNo, String house2TotalPcs, String house2TotalWeight,String house2DeliveryPcs,String house2DeliveryWeight,String agentCode){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbNoTotalPcs = PropertyHandler.getPropValue(dataFilePath, awbNoTotalPcs);
		awbNoTotalWgt = PropertyHandler.getPropValue(dataFilePath, awbNoTotalWgt);
		awbNoDeliveryPcs = PropertyHandler.getPropValue(dataFilePath, awbNoDeliveryPcs);
		awbNoDeliveryWgt = PropertyHandler.getPropValue(dataFilePath, awbNoDeliveryWgt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house1awbNo = PropertyHandler.getPropValue(dataFilePath, house1awbNo);
		house1TotalPcs = PropertyHandler.getPropValue(dataFilePath, house1TotalPcs);
		house1TotalWeight = PropertyHandler.getPropValue(dataFilePath, house1TotalWeight);
		house1DeliveryPcs = PropertyHandler.getPropValue(dataFilePath, house1DeliveryPcs);
		house1DeliveryWeight = PropertyHandler.getPropValue(dataFilePath, house1DeliveryWeight);

		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		house2awbNo = PropertyHandler.getPropValue(dataFilePath, house2awbNo);
		house2TotalPcs = PropertyHandler.getPropValue(dataFilePath, house2TotalPcs);
		house2TotalWeight = PropertyHandler.getPropValue(dataFilePath, house2TotalWeight);
		house2DeliveryPcs = PropertyHandler.getPropValue(dataFilePath, house2DeliveryPcs);
		house2DeliveryWeight = PropertyHandler.getPropValue(dataFilePath, house2DeliveryWeight);
		String awbRemaningPcs,awbRemainingWgt,house1RemainingPcs,house1RemainingWgt,house2RemainingPcs,house2RemainingWgt;

		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		int rowNumberOfAWB;
		int rowNumberOfHouse1;
		int rowNumberOfHouse2;

		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house1, awbPrefix, house1awbNo);
		minWait();
		listWithHouse(house2, awbPrefix, house2awbNo);
		minWait();
		rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		rowNumberOfHouse1 = getTableRowNumber(table_deliveryDetails, 5, house1);
		rowNumberOfHouse2 = getTableRowNumber(table_deliveryDetails, 5, house2);
		rowNumberOfAWB-=2;
		rowNumberOfHouse1-=2;
		rowNumberOfHouse2-=2;

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB).getAttribute("value"), awbNoTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB).getAttribute("value"), awbNoTotalWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse1).getAttribute("value"), house1TotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse1).getAttribute("value"), house1TotalWeight);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse2).getAttribute("value"), house2TotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse2).getAttribute("value"), house2TotalWeight);

		awbRemaningPcs = String.valueOf(Integer.parseInt(awbNoTotalPcs) - Integer.parseInt(awbNoDeliveryPcs));
		awbRemainingWgt = String.valueOf(Integer.parseInt(awbNoTotalWgt) - Integer.parseInt(awbNoDeliveryWgt));

		house1RemainingPcs = String.valueOf(Integer.parseInt(house1TotalPcs) - Integer.parseInt(house1DeliveryPcs));
		house1RemainingWgt = String.valueOf(Integer.parseInt(house1TotalWeight) - Integer.parseInt(house1DeliveryWeight));

		house2RemainingPcs = String.valueOf(Integer.parseInt(house2TotalPcs) - Integer.parseInt(house2DeliveryPcs));
		house2RemainingWgt = String.valueOf(Integer.parseInt(house2TotalWeight) - Integer.parseInt(house2DeliveryWeight));

		enterKeys(getWebElements(txt_pcs).get(rowNumberOfAWB), awbNoDeliveryPcs);
		enterKeys(getWebElements(txt_wt).get(rowNumberOfAWB), awbNoDeliveryWgt);
		enterKeys(getWebElements(txt_pcs).get(rowNumberOfHouse1), house1DeliveryPcs);
		enterKeys(getWebElements(txt_wt).get(rowNumberOfHouse1), house1DeliveryWeight);
		enterKeys(getWebElements(txt_pcs).get(rowNumberOfHouse2), house2DeliveryPcs);
		enterKeys(getWebElements(txt_wt).get(rowNumberOfHouse2), house2DeliveryWeight);


		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOf(waitForElement(info_successNotificationToast)));
		clear();
		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house1, awbPrefix, house1awbNo);
		minWait();
		listWithHouse(house2, awbPrefix, house2awbNo);
		minWait();
		rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		rowNumberOfHouse1 = getTableRowNumber(table_deliveryDetails, 5, house1);
		rowNumberOfHouse2 = getTableRowNumber(table_deliveryDetails, 5, house2);
		rowNumberOfAWB-=2;
		rowNumberOfHouse1-=2;
		rowNumberOfHouse2-=2;

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB).getAttribute("value"), awbRemaningPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB).getAttribute("value"), awbRemainingWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse1).getAttribute("value"), house1RemainingPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse1).getAttribute("value"), house1RemainingWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse2).getAttribute("value"), house2RemainingPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse2).getAttribute("value"), house2RemainingWgt);

		rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		rowNumberOfHouse1 = getTableRowNumber(table_deliveryDetails, 5, house1);
		rowNumberOfHouse2 = getTableRowNumber(table_deliveryDetails, 5, house2);
		//    	rowNumberOfAWB-=2;
		//    	rowNumberOfHouse1-=2;
		//    	rowNumberOfHouse2-=2;

		Assert.assertEquals(getTableCellValue(table_deliveryDetails, 11, rowNumberOfAWB), awbNoDeliveryPcs+" / "+awbNoDeliveryWgt);    	
		Assert.assertEquals(getTableCellValue(table_deliveryDetails, 11, rowNumberOfHouse1), house1DeliveryPcs+" / "+house1DeliveryWeight);
		Assert.assertEquals(getTableCellValue(table_deliveryDetails, 11, rowNumberOfHouse2), house2DeliveryPcs+" / "+house2DeliveryWeight);


		return this;
	}


	/**
	 * Created by A-7605 on 10-5-18
	 * This method perform partial delivery of an AWB and two HAWBs
	 * @param awbPrefix
	 * @param awbNo
	 * @param awbNoTotalPcs
	 * @param awbNoTotalWgt
	 * @param awbNoDeliveryPcs
	 * @param awbNoDeliveryWgt
	 * @param house1
	 * @param house1awbNo
	 * @param house1TotalPcs
	 * @param house1TotalWeight
	 * @param house1DeliveryPcs
	 * @param house1DeliveryWeight
	 * @param house2
	 * @param house2awbNo
	 * @param house2TotalPcs
	 * @param house2TotalWeight
	 * @param house2DeliveryPcs
	 * @param house2DeliveryWeight
	 * @param agentCode
	 * @return
	 */
	public OPR064 performPartialDeliveryOfTwoHousesAndOneBulkAWB(String awbPrefix, String awbNo,String awbNoTotalPcs, String awbNoTotalWgt,String awbNoDeliveryPcs,String awbNoDeliveryWgt,String house1, String house1awbNo, String house1TotalPcs, String house1TotalWeight,String house1DeliveryPcs,String house1DeliveryWeight,
			String house2, String house2awbNo, String house2TotalPcs, String house2TotalWeight,String house2DeliveryPcs,String house2DeliveryWeight,String agentCode){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbNoTotalPcs = PropertyHandler.getPropValue(dataFilePath, awbNoTotalPcs);
		awbNoTotalWgt = PropertyHandler.getPropValue(dataFilePath, awbNoTotalWgt);
		awbNoDeliveryPcs = PropertyHandler.getPropValue(dataFilePath, awbNoDeliveryPcs);
		awbNoDeliveryWgt = PropertyHandler.getPropValue(dataFilePath, awbNoDeliveryWgt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house1awbNo = PropertyHandler.getPropValue(dataFilePath, house1awbNo);
		house1TotalPcs = PropertyHandler.getPropValue(dataFilePath, house1TotalPcs);
		house1TotalWeight = PropertyHandler.getPropValue(dataFilePath, house1TotalWeight);
		house1DeliveryPcs = PropertyHandler.getPropValue(dataFilePath, house1DeliveryPcs);
		house1DeliveryWeight = PropertyHandler.getPropValue(dataFilePath, house1DeliveryWeight);

		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		house2awbNo = PropertyHandler.getPropValue(dataFilePath, house2awbNo);
		house2TotalPcs = PropertyHandler.getPropValue(dataFilePath, house2TotalPcs);
		house2TotalWeight = PropertyHandler.getPropValue(dataFilePath, house2TotalWeight);
		house2DeliveryPcs = PropertyHandler.getPropValue(dataFilePath, house2DeliveryPcs);
		house2DeliveryWeight = PropertyHandler.getPropValue(dataFilePath, house2DeliveryWeight);
		String awbRemaningPcs,awbRemainingWgt,house1RemainingPcs,house1RemainingWgt,house2RemainingPcs,house2RemainingWgt;

		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		int rowNumberOfAWB;
		int rowNumberOfHouse1;
		int rowNumberOfHouse2;

		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house1, awbPrefix, house1awbNo);
		minWait();
		listWithHouse(house2, awbPrefix, house2awbNo);
		minWait();
		rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		rowNumberOfHouse1 = getTableRowNumber(table_deliveryDetails, 5, house1);
		rowNumberOfHouse2 = getTableRowNumber(table_deliveryDetails, 5, house2);
		rowNumberOfAWB-=2;
		rowNumberOfHouse1-=2;
		rowNumberOfHouse2-=2;

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB).getAttribute("value"), awbNoTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB).getAttribute("value"), awbNoTotalWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse1).getAttribute("value"), house1TotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse1).getAttribute("value"), house1TotalWeight);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse2).getAttribute("value"), house2TotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse2).getAttribute("value"), house2TotalWeight);

		awbRemaningPcs = String.valueOf(Integer.parseInt(awbNoTotalPcs) - Integer.parseInt(awbNoDeliveryPcs));
		awbRemainingWgt = String.valueOf(Integer.parseInt(awbNoTotalWgt) - Integer.parseInt(awbNoDeliveryWgt));

		house1RemainingPcs = String.valueOf(Integer.parseInt(house1TotalPcs) - Integer.parseInt(house1DeliveryPcs));
		house1RemainingWgt = String.valueOf(Integer.parseInt(house1TotalWeight) - Integer.parseInt(house1DeliveryWeight));

		house2RemainingPcs = String.valueOf(Integer.parseInt(house2TotalPcs) - Integer.parseInt(house2DeliveryPcs));
		house2RemainingWgt = String.valueOf(Integer.parseInt(house2TotalWeight) - Integer.parseInt(house2DeliveryWeight));

		enterKeys(getWebElements(txt_pcs).get(rowNumberOfAWB), awbNoDeliveryPcs);
		enterKeys(getWebElements(txt_wt).get(rowNumberOfAWB), awbNoDeliveryWgt);
		enterKeys(getWebElements(txt_pcs).get(rowNumberOfHouse1), house1DeliveryPcs);
		enterKeys(getWebElements(txt_wt).get(rowNumberOfHouse1), house1DeliveryWeight);
		enterKeys(getWebElements(txt_pcs).get(rowNumberOfHouse2), house2DeliveryPcs);
		enterKeys(getWebElements(txt_wt).get(rowNumberOfHouse2), house2DeliveryWeight);


		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOf(waitForElement(info_successNotificationToast)));
		clear();
		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house1, awbPrefix, house1awbNo);
		minWait();
		listWithHouse(house2, awbPrefix, house2awbNo);
		minWait();
		rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		rowNumberOfHouse1 = getTableRowNumber(table_deliveryDetails, 5, house1);
		rowNumberOfHouse2 = getTableRowNumber(table_deliveryDetails, 5, house2);
		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB - 2).getAttribute("value"), awbRemaningPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB - 2).getAttribute("value"), awbRemainingWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse1 - 2).getAttribute("value"), house1RemainingPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse1 - 2).getAttribute("value"), house1RemainingWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse2 - 2).getAttribute("value"), house2RemainingPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse2 - 2).getAttribute("value"), house2RemainingWgt);

		rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		rowNumberOfHouse1 = getTableRowNumber(table_deliveryDetails, 5, house1);
		rowNumberOfHouse2 = getTableRowNumber(table_deliveryDetails, 5, house2);


		Assert.assertEquals(getTableCellValue(table_deliveryDetails, 11, rowNumberOfAWB), awbNoDeliveryPcs+" / "+awbNoDeliveryWgt);    	
		Assert.assertEquals(getTableCellValue(table_deliveryDetails, 11, rowNumberOfHouse1), house1DeliveryPcs+" / "+house1DeliveryWeight);
		Assert.assertEquals(getTableCellValue(table_deliveryDetails, 11, rowNumberOfHouse2), house2DeliveryPcs+" / "+house2DeliveryWeight);


		return this;
	}

	/**
	 * Created by A-7605 on 17-05-18
	 * This method perform partial delivery, by clicking group delivery icon, of one HAWB and one AWB
	 * @param awbPrefix
	 * @param awbNo
	 * @param awbNoTotalPcs
	 * @param awbNoTotalWgt
	 * @param awbNoDeliveryPcs
	 * @param awbNoDeliveryWgt
	 * @param house
	 * @param houseAwbNo
	 * @param houseTotalPcs
	 * @param houseTotalWeight
	 * @param houseDeliveryPcs
	 * @param houseDeliveryWeight
	 * @param agentCode
	 * @return
	 */
	public OPR064 performPartialDeliveryOfOneHouseAndOneBulkAWB(String awbPrefix, String awbNo,String awbNoTotalPcs, String awbNoTotalWgt,String awbNoDeliveryPcs,String awbNoDeliveryWgt,String house, String houseAwbNo, String houseTotalPcs, String houseTotalWeight,String houseDeliveryPcs,String houseDeliveryWeight,String agentCode){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbNoTotalPcs = PropertyHandler.getPropValue(dataFilePath, awbNoTotalPcs);
		awbNoTotalWgt = PropertyHandler.getPropValue(dataFilePath, awbNoTotalWgt);
		awbNoDeliveryPcs = PropertyHandler.getPropValue(dataFilePath, awbNoDeliveryPcs);
		awbNoDeliveryWgt = PropertyHandler.getPropValue(dataFilePath, awbNoDeliveryWgt);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		houseAwbNo = PropertyHandler.getPropValue(dataFilePath, houseAwbNo);
		houseTotalPcs = PropertyHandler.getPropValue(dataFilePath, houseTotalPcs);
		houseTotalWeight = PropertyHandler.getPropValue(dataFilePath, houseTotalWeight);
		houseDeliveryPcs = PropertyHandler.getPropValue(dataFilePath, houseDeliveryPcs);
		houseDeliveryWeight = PropertyHandler.getPropValue(dataFilePath, houseDeliveryWeight);

		String awbRemaningPcs,awbRemainingWgt,house1RemainingPcs,house1RemainingWgt;

		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		int rowNumberOfAWB;
		int rowNumberOfHouse1;


		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house, awbPrefix, houseAwbNo);
		minWait();
		rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		rowNumberOfHouse1 = getTableRowNumber(table_deliveryDetails, 5, house);
		rowNumberOfAWB-=2;
		rowNumberOfHouse1-=2;

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB).getAttribute("value"), awbNoTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB).getAttribute("value"), awbNoTotalWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse1).getAttribute("value"), houseTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse1).getAttribute("value"), houseTotalWeight);


		awbRemaningPcs = String.valueOf(Integer.parseInt(awbNoTotalPcs) - Integer.parseInt(awbNoDeliveryPcs));
		awbRemainingWgt = String.valueOf(Integer.parseInt(awbNoTotalWgt) - Integer.parseInt(awbNoDeliveryWgt));

		house1RemainingPcs = String.valueOf(Integer.parseInt(houseTotalPcs) - Integer.parseInt(houseDeliveryPcs));
		house1RemainingWgt = String.valueOf(Integer.parseInt(houseTotalWeight) - Integer.parseInt(houseDeliveryWeight));


		splitPc_1DN(rowNumberOfAWB+2, awbNoDeliveryPcs, awbNoDeliveryWgt);
		minWait();
		splitPc_1DN(rowNumberOfHouse1+2, houseDeliveryPcs, houseDeliveryWeight);


		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOf(waitForElement(info_successNotificationToast)));
		clear();
		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house, awbPrefix, houseAwbNo);
		minWait();
		rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		rowNumberOfHouse1 = getTableRowNumber(table_deliveryDetails, 5, house);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB - 2).getAttribute("value"), awbRemaningPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB - 2).getAttribute("value"), awbRemainingWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse1 - 2).getAttribute("value"), house1RemainingPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse1 - 2).getAttribute("value"), house1RemainingWgt);

		rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		rowNumberOfHouse1 = getTableRowNumber(table_deliveryDetails, 5, house);   

		Assert.assertEquals(getTableCellValue(table_deliveryDetails, 11, rowNumberOfAWB), awbNoDeliveryPcs+" / "+awbNoDeliveryWgt);    	
		Assert.assertEquals(getTableCellValue(table_deliveryDetails, 11, rowNumberOfHouse1), houseDeliveryPcs+" / "+houseDeliveryWeight);

		return this;
	}

	/**
	 * Created by A-7605 on 17-05-18
	 * This method perform full delivery of one HAWB and one AWB
	 * @param awbPrefix
	 * @param awbNo
	 * @param awbNoTotalPcs
	 * @param awbNoTotalWgt
	 * @param house
	 * @param houseAwbNo
	 * @param houseTotalPcs
	 * @param houseTotalWeight
	 * @param agentCode
	 * @param dnNos
	 * @return
	 */
	public OPR064 performFullDeliveryOfOneHouseAndOneBulkAWB(String awbPrefix, String awbNo,String awbNoTotalPcs, String awbNoTotalWgt,String house, String houseAwbNo, String houseTotalPcs, String houseTotalWeight,String agentCode,String... dnNos){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbNoTotalPcs = PropertyHandler.getPropValue(dataFilePath, awbNoTotalPcs);
		awbNoTotalWgt = PropertyHandler.getPropValue(dataFilePath, awbNoTotalWgt);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		houseAwbNo = PropertyHandler.getPropValue(dataFilePath, houseAwbNo);
		houseTotalPcs = PropertyHandler.getPropValue(dataFilePath, houseTotalPcs);
		houseTotalWeight = PropertyHandler.getPropValue(dataFilePath, houseTotalWeight);
		for(int i=0; i<dnNos.length; i++)
			dnNos[i] = PropertyHandler.getPropValue(dataFilePath, dnNos[i]);

		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		int rowNumberOfAWB;
		int rowNumberOfHouse1;


		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house, awbPrefix, houseAwbNo);
		minWait();
		rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		rowNumberOfHouse1 = getTableRowNumber(table_deliveryDetails, 5, house);
		rowNumberOfAWB-=2;
		rowNumberOfHouse1-=2;

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB).getAttribute("value"), awbNoTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB).getAttribute("value"), awbNoTotalWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse1).getAttribute("value"), houseTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse1).getAttribute("value"), houseTotalWeight);
		
		for(int i=0; i<dnNos.length; i++){
			String[] dnNo;
			if(dnNos[i].contains(","))
				dnNo = dnNos[i].split(",");
			else
				dnNo = new String[]{dnNos[i]};
			for(int j=0; j<dnNo.length; j++)
				Assert.assertTrue(waitForElement(table_deliveryDetails).getText().contains(dnNo[i]));
		}
		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	
	/**
	 * Created by A-7605 on 21-5-18
	 * This method perform split partial delivery of an AWB and an HAWB
	 * @param awbPrefix
	 * @param awbNo
	 * @param awbNoTotalPcs
	 * @param awbNoTotalWgt
	 * @param awbDeliveryPcs1
	 * @param awbDeliveryWgt1
	 * @param awbDeliveryPcs2
	 * @param awbDeliveryWgt2
	 * @param house
	 * @param houseawbNo
	 * @param houseTotalPcs
	 * @param houseTotalWeight
	 * @param houseDeliveryPcs1
	 * @param houseDeliveryWgt1
	 * @param houseDeliveryPcs2
	 * @param houseDeliveryWgt2
	 * @param agentCode
	 * @param awbRemainingPcs
	 * @param awbRemainingWgt
	 * @param houseRemainingPcs
	 * @param houseRemainingWgt
	 * @return
	 */
	public OPR064 performSplitPartialDeliveryOfOneHousesAndOneAWB_2DN(String awbPrefix, String awbNo,String awbNoTotalPcs, String awbNoTotalWgt,String awbDeliveryPcs1,String awbDeliveryWgt1,String awbDeliveryPcs2,String awbDeliveryWgt2, String house, String houseawbNo, String houseTotalPcs, String houseTotalWeight,
			String houseDeliveryPcs1, String houseDeliveryWgt1,String houseDeliveryPcs2, String houseDeliveryWgt2, String agentCode,String awbRemainingPcs,String awbRemainingWgt,
			String houseRemainingPcs, String houseRemainingWgt){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbNoTotalPcs = PropertyHandler.getPropValue(dataFilePath, awbNoTotalPcs);
		awbNoTotalWgt = PropertyHandler.getPropValue(dataFilePath, awbNoTotalWgt);
		awbDeliveryPcs1 = PropertyHandler.getPropValue(dataFilePath, awbDeliveryPcs1);
		awbDeliveryWgt1 = PropertyHandler.getPropValue(dataFilePath, awbDeliveryWgt1);
		awbDeliveryPcs2 = PropertyHandler.getPropValue(dataFilePath, awbDeliveryPcs2);
		awbDeliveryWgt2 = PropertyHandler.getPropValue(dataFilePath, awbDeliveryWgt2);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		houseawbNo = PropertyHandler.getPropValue(dataFilePath, houseawbNo);
		houseTotalPcs = PropertyHandler.getPropValue(dataFilePath, houseTotalPcs);
		houseTotalWeight = PropertyHandler.getPropValue(dataFilePath, houseTotalWeight);
		houseDeliveryPcs1 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryPcs1);
		houseDeliveryWgt1 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryWgt1);
		houseDeliveryPcs2 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryPcs2);
		houseDeliveryWgt2 = PropertyHandler.getPropValue(dataFilePath, houseDeliveryWgt2);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house, awbPrefix, houseawbNo);
		minWait();
		int rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		int rowNumberOfHouse = getTableRowNumber(table_deliveryDetails, 5, house);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB - 2).getAttribute("value"), awbNoTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB - 2).getAttribute("value"), awbNoTotalWgt);

		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse - 2).getAttribute("value"), houseTotalPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse - 2).getAttribute("value"), houseTotalWeight);

		String pendingAWBPcs = String.valueOf(Integer.parseInt(awbNoTotalPcs) - (Integer.parseInt(awbDeliveryPcs1) + Integer.parseInt(awbDeliveryPcs2)));
		String pendingAWBWgt = String.valueOf(Integer.parseInt(awbNoTotalWgt) - (Integer.parseInt(awbDeliveryWgt1) + Integer.parseInt(awbDeliveryWgt2)));
		String pendingHAWBPcs = String.valueOf(Integer.parseInt(houseTotalPcs) - (Integer.parseInt(houseDeliveryPcs1) + Integer.parseInt(houseDeliveryPcs2)));
		String pendingHAWBWgt = String.valueOf(Integer.parseInt(houseTotalWeight) - (Integer.parseInt(houseDeliveryWgt1) + Integer.parseInt(houseDeliveryWgt2)));

		splitPcsToTwo(rowNumberOfAWB, awbDeliveryPcs1, awbDeliveryWgt1, awbDeliveryPcs2, awbDeliveryWgt2);
		minWait();
		splitPcsToTwo(rowNumberOfHouse, awbDeliveryPcs1, awbDeliveryWgt1, awbDeliveryPcs2, awbDeliveryWgt2);
		enterKeys(txt_agentName,agentCode);
		click(btn_save);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(getWebElements(shipmentLocations_txt_pcs).get(0), awbDeliveryPcs1);
		enterKeys(getWebElements(shipmentLocations_txt_pcs).get(1), awbDeliveryPcs2);
		enterKeys(getWebElements(shipmentLocations_txt_pcs).get(2), houseDeliveryPcs1);
		enterKeys(getWebElements(shipmentLocations_txt_pcs).get(3), houseDeliveryPcs2);

		click(shipmentLocations_btn_ok);
		switchToFirstWindow();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);

		PropertyHandler.setPropValue(dataFilePath, awbRemainingPcs, pendingAWBPcs);
		PropertyHandler.setPropValue(dataFilePath, awbRemainingWgt, pendingAWBWgt);
		PropertyHandler.setPropValue(dataFilePath, houseRemainingPcs, pendingHAWBPcs);
		PropertyHandler.setPropValue(dataFilePath, houseRemainingWgt, pendingHAWBWgt);
		return this;
	}
	
	
	/**
	 * Created by A-7605 on 20-4-18
	 * This method perform delivery of full pcs and check if door delivery checkbox checked
	 * @param awbPre
	 * @param awbNo
	 * @param agentName
	 * @return
	 */
	public OPR064 checkDoorDeliveryOfAWBAndHAWB(String awbPre, String awbNo, String hosue,String houseAWBNo,String agentName) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		agentName = PropertyHandler.getPropValue(dataFilePath, agentName);
		hosue = PropertyHandler.getPropValue(dataFilePath, hosue);
		houseAWBNo = PropertyHandler.getPropValue(dataFilePath, houseAWBNo);

		list(awbPre,awbNo);
		minWait();
		listWithHouse(hosue, awbPre, houseAWBNo);
		minWait();
		List<WebElement> doorDeliveryChkboxElements = getWebElements(chkbox_doorDelivery);
		for(WebElement doorDeliveryChkboxElement:doorDeliveryChkboxElements)
			Assert.assertTrue(doorDeliveryChkboxElement.getAttribute("checked") != null);
		enterKeys(txt_agentName,agentName);
		enterKeys(txt_address,"Address");
		enterKeys(txt_remarks,"By automation");
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		return this;

	}
	/**
	 * Created by A-7605 on 21-5-18
	 * This method perform full delivery of 3 AWBs
	 * @param awbPre
	 * @param awbNo1
	 * @param awbNo2
	 * @param awbNo3
	 * @param agentName
	 * @return
	 */
	public OPR064 deliverFullPcs_3AWBs(String awbPre, String awbNo1,String awbNo2,String awbNo3, String agentName) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo1 = PropertyHandler.getPropValue(dataFilePath, awbNo1);
		awbNo2 = PropertyHandler.getPropValue(dataFilePath, awbNo2);
		awbNo3 = PropertyHandler.getPropValue(dataFilePath, awbNo3);
		agentName = PropertyHandler.getPropValue(dataFilePath, agentName);

		list(awbPre,awbNo1);
		minWait();
		list(awbPre,awbNo2);
		minWait();
		list(awbPre,awbNo3);
		minWait();

		enterKeys(txt_agentName,agentName);
		enterKeys(txt_address,"Address");
		enterKeys(txt_remarks,"By automation");
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_genericYes)){
			click(btn_genericYes);
			minWait();
		}
		Assert.assertTrue(waitForElement(info_footerMessage).getText().trim().contains("Saved Succesfully"));
		waitForFrameAndSwitch(FRAME);
		return this;

	}
	
	
	/**
	 * Created by A-7605 on 8-5-18
	 * This method check if the remaining pcs/wgt are correct after split partial delivery of an AWB and an HAWB
	 * @param awbPrefix
	 * @param awbNo
	 * @param totalAWBPcs
	 * @param totalAWBWgt
	 * @param deliveredAWBPcs
	 * @param deliveredAWBWgt
	 * @param house
	 * @param houseAWBNo
	 * @param totalHousePcs
	 * @param totalHouseWgt
	 * @param deliveredHousePcs
	 * @param deliveredHouseWgt
	 * @return
	 */
	public OPR064 checkPendingPcsForAWBandHAWB(String awbPrefix, String awbNo,String totalAWBPcs,String totalAWBWgt,String deliveredAWBPcs,String deliveredAWBWgt,
			String house,String houseAWBNo,String totalHousePcs,String totalHouseWgt,String deliveredHousePcs,String deliveredHouseWgt){

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		totalAWBPcs = PropertyHandler.getPropValue(dataFilePath, totalAWBPcs);
		totalAWBWgt = PropertyHandler.getPropValue(dataFilePath, totalAWBWgt);
		deliveredAWBPcs = PropertyHandler.getPropValue(dataFilePath, deliveredAWBPcs);
		deliveredAWBWgt = PropertyHandler.getPropValue(dataFilePath, deliveredAWBWgt);
		house = PropertyHandler.getPropValue(dataFilePath, house);
		houseAWBNo = PropertyHandler.getPropValue(dataFilePath, houseAWBNo);
		totalHousePcs = PropertyHandler.getPropValue(dataFilePath, totalHousePcs);
		totalHouseWgt = PropertyHandler.getPropValue(dataFilePath, totalHouseWgt);
		deliveredHousePcs = PropertyHandler.getPropValue(dataFilePath, deliveredHousePcs);
		deliveredHouseWgt = PropertyHandler.getPropValue(dataFilePath, deliveredHouseWgt);

		listWithAWB(awbPrefix, awbNo);
		minWait();
		listWithHouse(house, awbPrefix, houseAWBNo);
		minWait();
		int rowNumberOfAWB = getTableRowNumber(table_deliveryDetails, 4, awbPrefix+" "+awbNo);
		int rowNumberOfHouse = getTableRowNumber(table_deliveryDetails, 5, house);
		String remainingAWBPcs = String.valueOf(Integer.parseInt(totalAWBPcs) - Integer.parseInt(deliveredAWBPcs));
		String remainingAWBWgt = String.valueOf(Integer.parseInt(totalAWBWgt) - Integer.parseInt(deliveredAWBWgt));
		String remainingHousePcs = String.valueOf(Integer.parseInt(totalHousePcs) - Integer.parseInt(deliveredHousePcs));
		String remainingHouseWgt = String.valueOf(Integer.parseInt(totalHouseWgt) - Integer.parseInt(deliveredHouseWgt));
		
		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfAWB - 2).getAttribute("value"), remainingAWBPcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfAWB - 2).getAttribute("value"), remainingAWBWgt);
		Assert.assertEquals(getWebElements(txt_pcs).get(rowNumberOfHouse - 2).getAttribute("value"), remainingHousePcs);
		Assert.assertEquals(getWebElements(txt_wt).get(rowNumberOfHouse - 2).getAttribute("value"), remainingHouseWgt);
		
		Assert.assertEquals(tblGetTextByColValue(table_deliveryDetails, 11, 4, awbNo), deliveredAWBPcs+" / "+deliveredAWBWgt);
		Assert.assertEquals(tblGetTextByColValue(table_deliveryDetails, 11, 4, houseAWBNo), deliveredHousePcs+" / "+deliveredHouseWgt);

		return this;
	}
}
