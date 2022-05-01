package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class WHS016 extends BasePage {

	public WHS016(WebDriver driver, String dataFileName) {
		super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
	}
	
	
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameWHS016";
    WebDriver driver;
    String screenFrame;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    By dropdown_warehouse,
    	btn_list,
    	btn_add,
    	addLocation_txt_txnCode,
    	addLocation_txt_strgStruct,
    	addLocation_txt_locType,
    	addLocation_txt_zone,
    	addLocation_btn_addToList,
    	addLocation_btn_ok,
    	btn_delete,
    	btn_save,
    	btn_close,
    	table_transactionDetails,
    	dialogueText,
    	btn_dialogueYes,
    	btn_dialogueOk,
    	addLocation_table_locations;
    
    private void initElements(){
    	
    	dropdown_warehouse = MiscUtility.getWebElement(objFilepath, "WHS016_dropdown_warehouse");
    	btn_list = MiscUtility.getWebElement(objFilepath, "WHS016_btn_list");
    	btn_add = MiscUtility.getWebElement(objFilepath, "WHS016_btn_add");
    	addLocation_txt_txnCode = MiscUtility.getWebElement(objFilepath, "WHS016_addLocation_txt_txnCode");
    	addLocation_txt_strgStruct = MiscUtility.getWebElement(objFilepath, "WHS016_addLocation_txt_strgStruct");
    	addLocation_txt_locType = MiscUtility.getWebElement(objFilepath, "WHS016_addLocation_txt_locType");
    	addLocation_txt_zone = MiscUtility.getWebElement(objFilepath, "WHS016_addLocation_txt_zone");
    	addLocation_btn_addToList = MiscUtility.getWebElement(objFilepath, "WHS016_addLocation_btn_addToList");
    	addLocation_btn_ok = MiscUtility.getWebElement(objFilepath, "WHS016_addLocation_btn_ok");
    	btn_delete = MiscUtility.getWebElement(objFilepath, "WHS016_btn_delete");
    	btn_save = MiscUtility.getWebElement(objFilepath, "WHS016_btn_save");
    	btn_close = MiscUtility.getWebElement(objFilepath, "WHS016_btn_close");
    	table_transactionDetails = MiscUtility.getWebElement(objFilepath, "WHS016_table_transactionDetails");
    	addLocation_table_locations = MiscUtility.getWebElement(objFilepath, "WHS016_addLocation_table_locations");
    	dialogueText = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    	btn_dialogueYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btn_dialogueOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    }
    
    /**
     * Created by A-7605
     * @param transactionCode
     * @param currentLocationValue
     * @return
     */
    public WHS016 deleteTransaction(String warehouse, String transactionCode, String currentLocationValue){
    	
    	transactionCode = PropertyHandler.getPropValue(dataFilePath, transactionCode);
    	warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
    	selectByText(dropdown_warehouse, warehouse);
    	click(btn_list);
    	minWait();
    	String location = null;
    	if(waitForElement(table_transactionDetails).getText().contains(transactionCode))
    		location = tblGetTextByColValue(table_transactionDetails, 3, 2, transactionCode);
    	PropertyHandler.setPropValue(dataFilePath, currentLocationValue, location);
    	tblSelectRowByColValue(table_transactionDetails, 1, 2, transactionCode);
    	click(btn_delete);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(dialogueText).getText(), "Do you want to save the details?");
    	click(btn_dialogueYes);
    	minWait();
    	waitForElement(btn_dialogueOk);
    	Assert.assertEquals(waitForElement(dialogueText).getText(), "Saved Successfully.");
    	click(btn_dialogueOk);
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @return
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_dialogueYes)) {

            click(btn_dialogueYes);
        }
        return new HomePage(driver, dataFileName);
    }
    
    /**
     * Created by A-7605
     * @param warehouse
     * @param transactionCode
     * @param strgStruct
     * @param locType
     * @param zone
     * @param location
     * @return
     */
    public WHS016 addTransaction(String warehouse, String transactionCode, String strgStruct, String locType, String zone, String location){
    	warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
    	transactionCode = PropertyHandler.getPropValue(dataFilePath, transactionCode);
    	strgStruct = PropertyHandler.getPropValue(dataFilePath, strgStruct);
    	locType = PropertyHandler.getPropValue(dataFilePath, locType);
    	zone = PropertyHandler.getPropValue(dataFilePath, zone);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	
    	selectByText(dropdown_warehouse, warehouse);
    	click(btn_list);
    	minWait();
    	click(btn_add);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(waitForElement(addLocation_txt_txnCode), transactionCode);
    	enterKeys(addLocation_txt_strgStruct, strgStruct);
    	enterKeys(addLocation_txt_locType, locType);
    	enterKeys(addLocation_txt_zone, zone);
    	click(addLocation_btn_addToList);
    	minWait();
    	tblSelectRowByColValue(addLocation_table_locations, 1, 2, location);
    	click(addLocation_btn_ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(dialogueText).getText(), "Do you want to save the details?");
    	click(btn_dialogueYes);
    	minWait();
    	waitForElement(btn_dialogueOk);
    	Assert.assertEquals(waitForElement(dialogueText).getText(), "Saved Successfully.");
    	click(btn_dialogueOk);
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Created by A-7605
     * @param warehouse
     * @param transactionCode
     * @param currentLocationValue
     * @return
     */
	public WHS016 getCurrentTransactionLocation(String warehouse, String transactionCode, String currentLocationValue){
	    	
	    	transactionCode = PropertyHandler.getPropValue(dataFilePath, transactionCode);
	    	warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
	    	selectByText(dropdown_warehouse, warehouse);
	    	click(btn_list);
	    	minWait();
	    	String location = null;
	    	if(waitForElement(table_transactionDetails).getText().contains(transactionCode))
	    		location = tblGetTextByColValue(table_transactionDetails, 3, 2, transactionCode);
	    	PropertyHandler.setPropValue(dataFilePath, currentLocationValue, location);
	    	return this;
	    }

}
