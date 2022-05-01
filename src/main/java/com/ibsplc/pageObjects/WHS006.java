package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class WHS006 extends BasePage {
	
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameWHS006";
    WebDriver driver;
    String screenFrame;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

	public WHS006(WebDriver driver, String dataFileName) {
		super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
	}
	
	
	By txt_suType,
		btn_list,
		btn_createSU,
		createSU_txt_suType,
		createSU_btn_add,
		createSU_txt_prefix,
		createSU_txt_start,
		createSU_txt_end,
		createSU_txt_suffix,
		createSU_btn_create,
		btn_close,
		btn_clear,
		yesBtn,
		txt_suCode,
		table_storageUnitDetails;
	
	private void initElements(){
		txt_suType = MiscUtility.getWebElement(objFilepath, "WHS006_txt_suType");
		btn_list = MiscUtility.getWebElement(objFilepath, "WHS006_btn_list");
		btn_createSU = MiscUtility.getWebElement(objFilepath, "WHS006_btn_createSU");
		createSU_txt_suType = MiscUtility.getWebElement(objFilepath, "WHS006_createSU_txt_suType");
		createSU_btn_add = MiscUtility.getWebElement(objFilepath, "WHS006_createSU_btn_add");
		createSU_txt_prefix = MiscUtility.getWebElement(objFilepath, "WHS006_createSU_txt_prefix");
		createSU_txt_start = MiscUtility.getWebElement(objFilepath, "WHS006_createSU_txt_start");
		createSU_txt_end = MiscUtility.getWebElement(objFilepath, "WHS006_createSU_txt_end");
		createSU_txt_suffix = MiscUtility.getWebElement(objFilepath, "WHS006_createSU_txt_suffix");
		createSU_btn_create = MiscUtility.getWebElement(objFilepath, "WHS006_createSU_btn_create");
		btn_close = MiscUtility.getWebElement(objFilepath, "WHS006_btn_close");
		btn_clear = MiscUtility.getWebElement(objFilepath, "WHS006_btn_clear");
		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		txt_suCode = MiscUtility.getWebElement(objFilepath, "WHS006_txt_suCode");
		table_storageUnitDetails = MiscUtility.getWebElement(objFilepath, "WHS006_table_storageUnitDetails");
	}
	
	/**
	 * Created by A-7605
	 * This method will create storage units, where number of storage units created will be equal to the number of suCode arguments passed to the method. Difference between start and end should be equal to the number of storage units to be created
	 * @param suType
	 * @param start
	 * @param end
	 * @param suffixCharLength
	 * @param prefixCharLegth
	 * @param suCode
	 * @return
	 */
	public WHS006 createSU(String suType, String start, String end,String suffixCharLength,String prefixCharLegth,String... suCode){
		suffixCharLength = PropertyHandler.getPropValue(dataFilePath, suffixCharLength);
		prefixCharLegth = PropertyHandler.getPropValue(dataFilePath, prefixCharLegth);
		String suffix = BizUtility.generateRandomAlphabets(Integer.parseInt(suffixCharLength));
		String prefix = BizUtility.generateRandomAlphabets(Integer.parseInt(prefixCharLegth));
		suType = PropertyHandler.getPropValue(dataFilePath, suType);
		start = PropertyHandler.getPropValue(dataFilePath, start);
		end = PropertyHandler.getPropValue(dataFilePath, end);
		
		enterKeys(waitForElement(txt_suType), suType);
		click(btn_list);
		minWait();
		click(btn_createSU);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys(waitForElement(createSU_txt_suType), suType);
		click(createSU_btn_add);
		enterKeys(waitForElement(createSU_txt_prefix), prefix);
		enterKeys(createSU_txt_start, start);
		enterKeys(createSU_txt_end, end);
		enterKeys(createSU_txt_suffix, suffix);
		click(createSU_btn_create);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		int from = Integer.parseInt(start);
		int to = Integer.parseInt(end);
		int j=0;
		for(int i=from;i<to;i++){
			String suLoc = prefix+i+suffix;
			PropertyHandler.setPropValue(dataFilePath, suCode[j], suLoc);
			j++;
		}
		minWait();
		return this;
	}
	
	public WHS006 clear(){
		click(btn_clear);
		return this;
	}
	
	
	public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
	
	/**
	 * Created by A-7605 0n 05-02-18
	 * This method will verify if the expected occupancy status is same as that of actual
	 * @param suType
	 * @param suCode
	 * @param occupancyStatus
	 * @return
	 */
	public WHS006 verifyOccupancyStatus(String suType, String suCode, String occupancyStatus){
		suType = PropertyHandler.getPropValue(dataFilePath, suType);
		suCode = PropertyHandler.getPropValue(dataFilePath, suCode);
		occupancyStatus = PropertyHandler.getPropValue(dataFilePath, occupancyStatus);
		
		enterKeys(txt_suType, suType);
		enterKeys(txt_suCode, suCode);
		click(btn_list);
		minWait();
		Assert.assertEquals(getTableCellValue(table_storageUnitDetails, 4, 1), occupancyStatus);
		return this;
	}
}
