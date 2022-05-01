package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class OPR294 extends BasePage{

    public OPR294(WebDriver driver, String dataFileName) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        initElements();
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
	}
	public static String objectFileName = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private final String FRAME = "iCargoContentFrameOPR294";
    public String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public String dataFileName;
    
    By txt_awbPrefix,
    	txt_awbNo,
    	txt_fromDate,
    	txt_toDate,
    	btn_list,
    	table_deliveryID,
    	btn_cancelDeliveryID,
    	btn_close,
    	btn_dialogueYes,
    	info_dialogueContent,
    	chkbox_selectAllTableItems;
    
    private void initElements(){
    	txt_awbPrefix = MiscUtility.getWebElement(objectFileName, "OPR294_txt_awbPrefix");
    	txt_awbNo = MiscUtility.getWebElement(objectFileName, "OPR294_txt_awbNo");
    	txt_fromDate = MiscUtility.getWebElement(objectFileName, "OPR294_txt_fromDate");
    	txt_toDate = MiscUtility.getWebElement(objectFileName, "OPR294_txt_toDate");
    	btn_list = MiscUtility.getWebElement(objectFileName, "OPR294_btn_list");
    	table_deliveryID = MiscUtility.getWebElement(objectFileName, "OPR294_table_deliveryID");
    	btn_cancelDeliveryID = MiscUtility.getWebElement(objectFileName, "OPR294_btn_cancelDeliveryID");
    	btn_close = MiscUtility.getWebElement(objectFileName, "OPR294_btn_close");
    	chkbox_selectAllTableItems = MiscUtility.getWebElement(objectFileName, "OPR294_chkbox_selectAllTableItems");
    	btn_dialogueYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	info_dialogueContent = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    }
    
    private void list(String awbPrefix, String awbNo, String fromDate, String toDate){
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	if(fromDate != null && fromDate.trim().length()>0)
    		enterKeys(txt_fromDate, fromDate);
    	if(toDate != null && toDate.trim().length()>0)
    		enterKeys(txt_toDate, toDate);
    	click(btn_list);
    	minWait();
    }
    /**
     * Created by A-7605 on 13-4-18
     * This method cancel all delivery ids in the AWB
     * @param awbPrefix
     * @param awbNo
     * @param fromDate
     * @param toDate
     * @param expNoOfDeliveryIDs
     * @return
     */
    public OPR294 cancelAllDeliveryIDs(String awbPrefix, String awbNo, String fromDate, String toDate, int expNoOfDeliveryIDs){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	fromDate = PropertyHandler.getPropValue(dataFilePath, fromDate);
    	toDate = PropertyHandler.getPropValue(dataFilePath, toDate);
    	
    	list(awbPrefix, awbNo, fromDate, toDate);
    	Assert.assertEquals(getTableRowCount(table_deliveryID), expNoOfDeliveryIDs);
    	check(chkbox_selectAllTableItems);
    	click(btn_cancelDeliveryID);
    	driver.switchTo().defaultContent();
    	Assert.assertEquals(waitForElement(info_dialogueContent).getText(), "Group ID will be marked as cancelled. Do you want to continue");
    	click(btn_dialogueYes);
    	waitForFrameAndSwitch(FRAME);
    	Assert.assertTrue(getTableColumnValues(table_deliveryID, 6).contains("Cancelled"));
    	Assert.assertFalse(getTableColumnValues(table_deliveryID, 6).contains("Active"));
    	return this;
    }
    
    public HomePage close(){
         click(btn_close);
         driver.switchTo().defaultContent();
         return new HomePage(driver, dataFileName);
    }
}
