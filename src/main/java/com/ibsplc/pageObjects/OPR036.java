package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * OPR036 - Delivery Return Screen
 * 
 * @author A-7868 Krishna <21/03/2018>
 *
 */
public class OPR036 extends BasePage {

	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	private static String FRAME = "iCargoContentFrameOPR036";
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	private WebDriver driver;
	private String dataFileName;

	private By txt_awbPre,
	txt_awbNo,
	btn_list,
	btn_clear,
	link_returnAdd,
	txt_returnDtls_pcs,
	txt_returnDtls_wt,
	txt_returnDtls_su,
	dropdown_reason,
	btn_save,
	btn_close,
	btn_genericYes,
	info_footerMsg,
	txt_hawb,
	txt_location,
	table_shipmentDetails;

	public OPR036(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		this.dataFilePath = dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
		initElements();
	}

	/**
	 * Method to initialize page objects
	 *
	 * @author a-7868 Krishna <21/03/2018>
	 */
	private void initElements() {

		txt_awbPre = MiscUtility.getWebElement(objFilepath, "OPR036_txt_awbPre");
		txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR036_txt_awbNo");
		btn_list = MiscUtility.getWebElement(objFilepath, "OPR036_btn_list");
		btn_clear = MiscUtility.getWebElement(objFilepath, "OPR036_btn_clear");
		link_returnAdd = MiscUtility.getWebElement(objFilepath, "OPR036_link_returnAdd");
		txt_returnDtls_pcs = MiscUtility.getWebElement(objFilepath, "OPR036_txt_returnDtls_pcs");
		txt_returnDtls_wt = MiscUtility.getWebElement(objFilepath, "OPR036_txt_returnDtls_wt");
		txt_returnDtls_su = MiscUtility.getWebElement(objFilepath, "OPR036_txt_returnDtls_su");
		dropdown_reason = MiscUtility.getWebElement(objFilepath, "OPR036_dropdown_reason");
		btn_save = MiscUtility.getWebElement(objFilepath, "OPR036_btn_save");
		btn_close = MiscUtility.getWebElement(objFilepath, "OPR036_btn_close");
		txt_hawb = MiscUtility.getWebElement(objFilepath, "OPR036_txt_hawb");
		txt_location = MiscUtility.getWebElement(objFilepath, "OPR036_txt_location");
		table_shipmentDetails = MiscUtility.getWebElement(objFilepath, "OPR036_table_shipmentDetails");

		info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
		btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
	}


	private void list(String awbPre, String awbNo){

		enterKeys(txt_awbPre, awbPre);
		enterKeys(txt_awbNo, awbNo);
		click(btn_list);
		minWait();
	}

	/**
	 * Method to list an awb
	 * and enter the return pcs, select a reason and save
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param uldNo Optional <can be "">
	 * @param reason 
	 * @return
	 * @author A-7868 Krishna <22/03/2018>
	 */
	public OPR036 returnDeliveredPcs(String awbPre, String awbNo, String pcs, String wt, String uldNo, String...reason){

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		if(!uldNo.equals(""))
			uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		try{
			reason[0] = PropertyHandler.getPropValue(dataFilePath, reason[0]);
		}catch(NullPointerException ne){}

		list(awbPre, awbNo);
		//    	click(link_returnAdd);
		minWait();
		enterKeys(txt_returnDtls_pcs, pcs);
		enterKeys(txt_returnDtls_wt, wt);
		if(!uldNo.equals(""))
			enterKeys(txt_returnDtls_su, uldNo);
		try{
			selectByText(dropdown_reason, reason[0]);
		}catch(NullPointerException ne){
			selectByIndex(dropdown_reason, 1);
		}

		click(btn_save);
		maxWait();
		driver.switchTo().defaultContent();
		try{
			new WebDriverWait(driver, 30).until(ExpectedConditions.textToBePresentInElement(waitForElement(info_footerMsg), "Data saved successfully"));
		}catch(Exception e){
			Assert.fail("ERROR : Data not saved",e);
		}
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * CLose and screen and go to home page
	 *
	 * @return
	 * @author a-7868 Krishna <21/03/2018>
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
	 * Method to list an awb
	 * and enter the return pcs, select a reason and save
	 * 
	 * @param hawb
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param uldNo Optional <can be "">
	 * @param reason 
	 * @return
	 * @author A-7605 <20/04/2018>
	 */
	public OPR036 returnDeliveredPcs_HAWB(String hawb,String awbPre, String awbNo, String pcs, String wt, String uldNo, String...reason){

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		hawb = PropertyHandler.getPropValue(dataFilePath, hawb);
		if(!uldNo.equals(""))
			uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		try{
			reason[0] = PropertyHandler.getPropValue(dataFilePath, reason[0]);
		}catch(NullPointerException ne){}

		enterKeys(txt_awbPre, awbPre);
		enterKeys(txt_awbNo, awbNo);
		enterKeys(txt_hawb, hawb);
		click(btn_list);

		minWait();
		enterKeys(txt_returnDtls_pcs, pcs);
		enterKeys(txt_returnDtls_wt, wt);
		if(!uldNo.equals(""))
			enterKeys(txt_returnDtls_su, uldNo);
		try{
			selectByText(dropdown_reason, reason[0]);
		}catch(NullPointerException ne){
			selectByIndex(dropdown_reason, 1);
		}

		click(btn_save);
		maxWait();
		driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(info_footerMsg).getText().contains("Data saved successfully"),"ERROR : Data not saved");
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	/**
	 * Created by A-7605 on 27-4-18
	 * This method performs delivery return
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param uldNo
	 * @param location
	 * @param reason
	 * @return
	 */
	public OPR036 deliveryReturn(String awbPre, String awbNo, String pcs, String wt, String uldNo, String location,String reason){

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		if(!uldNo.equals(""))
			uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		reason = PropertyHandler.getPropValue(dataFilePath, reason);
		if(!location.equals(""))
			location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		minWait();
		enterKeys(txt_returnDtls_pcs, pcs);
		enterKeys(txt_returnDtls_wt, wt);
		if(!uldNo.equals(""))
			enterKeys(txt_returnDtls_su, uldNo);
		if(!location.equals(""))
			enterKeys(txt_location, location);
		try{
			selectByText(dropdown_reason, reason);
		}catch(NullPointerException ne){
			selectByIndex(dropdown_reason, 1);
		}

		click(btn_save);
		maxWait();
		driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(info_footerMsg).getText().contains("Data saved successfully"),"ERROR : Data not saved");
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	
	/**
	 * Created by A-7605 on 27-4-18
	 * This method performs delivery return of shipments containing 3 ULDs
	 * @param awbPre
	 * @param awbNo
	 * @param pcs1
	 * @param wt1
	 * @param uldNo1
	 * @param location1
	 * @param pcs2
	 * @param wt2
	 * @param uldNo2
	 * @param location2
	 * @param pcs3
	 * @param wt3
	 * @param uldNo3
	 * @param location3
	 * @param reason
	 * @return
	 */
	public OPR036 deliveryReturn_ThreeULDs(String awbPre, String awbNo, String pcs1, String wt1, String uldNo1, String location1, String pcs2, String wt2, String uldNo2, String location2, String pcs3, String wt3, String uldNo3, String location3,String reason){

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs1 = PropertyHandler.getPropValue(dataFilePath, pcs1);
		wt1 = PropertyHandler.getPropValue(dataFilePath, wt1);
		uldNo1 = PropertyHandler.getPropValue(dataFilePath, uldNo1);		
		location1 = PropertyHandler.getPropValue(dataFilePath, location1);
		pcs2 = PropertyHandler.getPropValue(dataFilePath, pcs2);
		wt2 = PropertyHandler.getPropValue(dataFilePath, wt2);
		uldNo2 = PropertyHandler.getPropValue(dataFilePath, uldNo2);		
		location2 = PropertyHandler.getPropValue(dataFilePath, location2);
		pcs3 = PropertyHandler.getPropValue(dataFilePath, pcs3);
		wt3 = PropertyHandler.getPropValue(dataFilePath, wt3);
		uldNo3 = PropertyHandler.getPropValue(dataFilePath, uldNo3);		
		location3 = PropertyHandler.getPropValue(dataFilePath, location3);
		reason = PropertyHandler.getPropValue(dataFilePath, reason);

		list(awbPre, awbNo);
		minWait();
		Assert.assertTrue(getTableCellTextValue(table_shipmentDetails, 7, 1).contains(uldNo1));
		Assert.assertTrue(getTableCellTextValue(table_shipmentDetails, 7, 1).contains(uldNo2));
		Assert.assertTrue(getTableCellTextValue(table_shipmentDetails, 7, 1).contains(uldNo3));
		enterKeys(getWebElements(txt_returnDtls_pcs).get(0), pcs1);
		enterKeys(getWebElements(txt_returnDtls_wt).get(0), wt1);
		enterKeys(getWebElements(txt_returnDtls_su).get(0), uldNo1);
		enterKeys(getWebElements(txt_location).get(0), location1);
		click(link_returnAdd);
		enterKeys(getWebElements(txt_returnDtls_pcs).get(1), pcs2);
		enterKeys(getWebElements(txt_returnDtls_wt).get(1), wt2);
		enterKeys(getWebElements(txt_returnDtls_su).get(1), uldNo2);
		enterKeys(getWebElements(txt_location).get(1), location2);
		click(link_returnAdd);
		enterKeys(getWebElements(txt_returnDtls_pcs).get(2), pcs3);
		enterKeys(getWebElements(txt_returnDtls_wt).get(2), wt3);
		enterKeys(getWebElements(txt_returnDtls_su).get(2), uldNo3);
		enterKeys(getWebElements(txt_location).get(2), location3);
		try{
			selectByText(dropdown_reason, reason);
		}catch(NullPointerException ne){
			selectByIndex(dropdown_reason, 1);
		}

		click(btn_save);
		maxWait();
		driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(info_footerMsg).getText().contains("Data saved successfully"),"ERROR : Data not saved");
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	
}
