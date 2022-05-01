package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP022 extends BasePage{

	
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameCAP022";
    public String filepath;
    WebDriver driver;
    String testDataFile;
    String browser;
    By txt_pbrNo,
    	btn_list,
    	btn_clear,
    	txt_origin,
    	txt_destination,
    	txt_agentCode,
    	txt_customerCode,
    	txt_startDate,
    	txt_endDate,
    	chkbox_frequencyAll,
    	txt_commodityCode,
    	txt_pieces,
    	txt_wt,
    	txt_vol,
    	txt_flightOrigin,
    	txt_flightDestination,
    	txt_flightNo,
    	btn_save,
    	btn_close,
    	dialogueBtn_yes,
    	dialogueBtn_Ok,
    	dialogueTxt;
    
	public CAP022(WebDriver driver, String testDataFile) {
		super(driver);
        this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver, this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + testDataFile;
        initPageElements();
	}
	
	public void initPageElements(){
		txt_pbrNo = MiscUtility.getWebElement(objFilepath, "CAP022_txt_pbrNo");
		btn_list = MiscUtility.getWebElement(objFilepath, "CAP022_btn_list");
		btn_clear = MiscUtility.getWebElement(objFilepath, "CAP022_btn_clear");
		txt_origin = MiscUtility.getWebElement(objFilepath, "CAP022_txt_origin");
		txt_destination = MiscUtility.getWebElement(objFilepath, "CAP022_txt_destination");
		txt_agentCode = MiscUtility.getWebElement(objFilepath, "CAP022_txt_agentCode");
		txt_customerCode = MiscUtility.getWebElement(objFilepath, "CAP022_txt_customerCode");
		txt_startDate = MiscUtility.getWebElement(objFilepath, "CAP022_txt_startDate");
		txt_endDate = MiscUtility.getWebElement(objFilepath, "CAP022_txt_endDate");
		chkbox_frequencyAll = MiscUtility.getWebElement(objFilepath, "CAP022_chkbox_frequencyAll");
		txt_commodityCode = MiscUtility.getWebElement(objFilepath, "CAP022_txt_commodityCode");
		txt_pieces = MiscUtility.getWebElement(objFilepath, "CAP022_txt_pieces");
		txt_wt = MiscUtility.getWebElement(objFilepath, "CAP022_txt_wt");
		txt_vol = MiscUtility.getWebElement(objFilepath, "CAP022_txt_vol");
		txt_flightOrigin = MiscUtility.getWebElement(objFilepath, "CAP022_txt_flightOrigin");
		txt_flightDestination = MiscUtility.getWebElement(objFilepath, "CAP022_txt_flightDestination");
		txt_flightNo = MiscUtility.getWebElement(objFilepath, "CAP022_txt_flightNo");
		btn_save = MiscUtility.getWebElement(objFilepath, "CAP022_btn_save");
		btn_close = MiscUtility.getWebElement(objFilepath, "CAP022_btn_close");
		
		dialogueBtn_yes = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
		dialogueBtn_Ok = MiscUtility.getWebElement(genFilepath, "Generic_btn_ok");
		dialogueTxt = MiscUtility.getWebElement(genFilepath, "Generic_info_msg");
	}

	public CAP022 createPermanentBooking(String pbrNo, String origin, String destination, String agentCode, String customerCode,
			String startDate, String endDate, String commodityCode, String pieces, String weight, String volume, String fullFlightNo){
		
		String dialogueContent;
		origin = PropertyHandler.getPropValue(filepath, origin);
		destination = PropertyHandler.getPropValue(filepath, destination);
		agentCode = PropertyHandler.getPropValue(filepath, agentCode);
		customerCode = PropertyHandler.getPropValue(filepath, customerCode);
		startDate = PropertyHandler.getPropValue(filepath, startDate);
		endDate = PropertyHandler.getPropValue(filepath, endDate);
		commodityCode = PropertyHandler.getPropValue(filepath, commodityCode);
		pieces = PropertyHandler.getPropValue(filepath, pieces);
		weight = PropertyHandler.getPropValue(filepath, weight);
		volume = PropertyHandler.getPropValue(filepath, volume);
		fullFlightNo = PropertyHandler.getPropValue(filepath, fullFlightNo);
		String randomPbrNo;
		while (true) {
			randomPbrNo = BizUtility.createFlightNum();
			enterKeys(txt_pbrNo, randomPbrNo);
			click(btn_list);
            driver.switchTo().defaultContent();
            minWait();
            if (verifyElementPresent(dialogueBtn_Ok)) {
                click(dialogueBtn_Ok);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
            click(waitForElement(btn_clear));
        }
		enterKeys(txt_origin, origin);
		enterKeys(txt_destination, destination);
		enterKeys(txt_agentCode, agentCode);
		enterKeys(txt_agentCode, Keys.TAB);
		enterKeys(txt_customerCode, customerCode);
		enterKeys(txt_customerCode, Keys.TAB);
		enterKeys(txt_startDate, startDate);		
		enterKeys(txt_endDate, endDate);		
		check(chkbox_frequencyAll);
		enterKeys(txt_commodityCode, commodityCode);
		enterKeys(txt_commodityCode, Keys.TAB);
		enterKeys(txt_pieces, pieces);
		enterKeys(txt_wt, weight);
		enterKeys(txt_vol, volume);
		enterKeys(txt_flightOrigin, origin);
		enterKeys(txt_flightDestination, destination);
		enterKeys(txt_flightNo, fullFlightNo);
		click(btn_save);
		driver.switchTo().defaultContent();
		dialogueContent = waitForElement(dialogueTxt).getText();
		click(dialogueBtn_Ok);
		Assert.assertTrue(dialogueContent.contains("has been created"));
		randomPbrNo = dialogueContent.split(" ")[6];
		PropertyHandler.setPropValue(filepath, pbrNo, randomPbrNo);
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	
	
	public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(dialogueBtn_yes)) {

            click(dialogueBtn_yes);
        }
        return new HomePage(driver, testDataFile);
    }
}
