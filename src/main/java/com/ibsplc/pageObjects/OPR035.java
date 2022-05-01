package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class OPR035 extends BasePage{

	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	public static String FRAME = "iCargoContentFrameOPR035";
	private WebDriver driver;
	private String dataFileName;
	
	By txt_dnNo,
		txt_awbPrefix,
		txt_awbNo,
		btn_list,
		table_warehouseSummary,
		table_fightSummary,
		info_dnStatus,
		btn_close,
		btn_dialogueYes;
	public OPR035(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}
	
	private void initElements(){
		txt_dnNo = MiscUtility.getWebElement(objFilepath, "OPR035_txt_dnNo");
		txt_awbPrefix = MiscUtility.getWebElement(objFilepath, "OPR035_txt_awbPrefix");
		txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR035_txt_awbNo");
		btn_list = MiscUtility.getWebElement(objFilepath, "OPR035_btn_list");
		table_warehouseSummary = MiscUtility.getWebElement(objFilepath, "OPR035_table_warehouseSummary");
		table_fightSummary = MiscUtility.getWebElement(objFilepath, "OPR035_table_fightSummary");
		info_dnStatus = MiscUtility.getWebElement(objFilepath, "OPR035_info_dnStatus");
		btn_close = MiscUtility.getWebElement(objFilepath, "OPR035_btn_close");
		btn_dialogueYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
	}
	
	private void listWithDNNo(String dnNo){
		enterKeys(txt_dnNo, dnNo);
		click(btn_list);
		minWait();
	}
	/**
	 * Created by A-7605 on 13-4-18
	 * This method verify delivery note register details against the information provided
	 * @param dnNo
	 * @param awbPrefix
	 * @param awbNo
	 * @param dnStatus
	 * @param breakdownLoc
	 * @param pieces
	 * @param weight
	 * @return
	 */
	public OPR035 verifyDeliveryNoteRegisterDetails(String dnNo, String awbPrefix, String awbNo, String dnStatus, String breakdownLoc, String pieces, String weight){
		dnNo = PropertyHandler.getPropValue(dataFilePath, dnNo);
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		dnStatus = PropertyHandler.getPropValue(dataFilePath, dnStatus);
		breakdownLoc = PropertyHandler.getPropValue(dataFilePath, breakdownLoc);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		
		listWithDNNo(dnNo);
		Assert.assertEquals(waitForElementVisible(txt_awbPrefix).getAttribute("value"), awbPrefix);
		Assert.assertEquals(waitForElementVisible(txt_awbNo).getAttribute("value"), awbNo);
		Assert.assertTrue(waitForElementVisible(info_dnStatus).getText().contains(dnStatus));
		Assert.assertEquals(getTableCellValue(table_fightSummary, 3, 1), pieces);
		Assert.assertEquals(getTableCellValue(table_fightSummary, 4, 1), weight);
		Assert.assertEquals(getTableCellValue(table_fightSummary, 5, 1), pieces);
		Assert.assertEquals(getTableCellValue(table_fightSummary, 6, 1), weight);
		Assert.assertEquals(getTableCellValue(table_warehouseSummary, 4, 1), breakdownLoc);
		Assert.assertEquals(getTableCellValue(table_warehouseSummary, 5, 1), pieces);
		return this;
	}
	
	/**
	 * Method to close current page and return to Homepae
	 * returns the instance of Homepage
	 *
	 * @return
	 * @author a-7605
	 */
	public HomePage close() {

		click(btn_close);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_dialogueYes)) {

			click(btn_dialogueYes);
		}
		return new HomePage(driver, dataFileName);
	}
}
