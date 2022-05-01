package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class OPR034 extends BasePage{

	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	public static String FRAME = "iCargoContentFrameOPR034";
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	private WebDriver driver;
	private String dataFileName;
	
	By txt_dnNo,
		table_dnDetails,
		btn_cancelDN,
		btn_close,
		btn_list,
		chkbox_selectTableItem,
		btn_dialogueYes;
	
	public OPR034(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}
	
	private void initElements(){
		txt_dnNo = MiscUtility.getWebElement(objFilepath, "OPR034_txt_dnNo");
		table_dnDetails = MiscUtility.getWebElement(objFilepath, "OPR034_table_dnDetails");
		btn_cancelDN = MiscUtility.getWebElement(objFilepath, "OPR034_btn_cancelDN");
		btn_close = MiscUtility.getWebElement(objFilepath, "OPR034_btn_close");
		btn_list = MiscUtility.getWebElement(objFilepath, "OPR034_btn_list");
		chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath, "OPR034_chkbox_selectTableItem");
		btn_dialogueYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
	}
	
	private void listWithDNNo(String dnNo){
		enterKeys(txt_dnNo, dnNo);
		click(btn_list);
		minWait();
	}
	/**
	 * Created by A-7605 on 13-4-18
	 * This method cancel DN and check if the status is cancelled
	 * @param dnNo
	 * @return
	 */
	public OPR034 cancelDN(String dnNo){
		dnNo = PropertyHandler.getPropValue(dataFilePath, dnNo);
		
		listWithDNNo(dnNo);
		check(chkbox_selectTableItem);
		click(btn_cancelDN);
		minWait();
		Assert.assertEquals(getTableCellValue(table_dnDetails, 9, 1), "Canceled");
		return this;
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
		if (verifyElementPresent(btn_dialogueYes)) {

			click(btn_dialogueYes);
		}
		return new HomePage(driver, dataFileName);
	}
}
