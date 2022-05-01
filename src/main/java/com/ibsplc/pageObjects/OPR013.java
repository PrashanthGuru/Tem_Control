package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * OPR013 - ULD TAG Screen
 * @author A-7868
 *
 */
public class OPR013 extends BasePage {

	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameOPR013";
    private WebDriver driver;
    private String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    private By 	txt_fromDate,
    			btn_genericYes,
    			txt_carrCode,
    	        txt_fltNum,
    	        txt_fltDt,
    	        txt_ULDNo,
    	        btn_list,
    	        btn_clear,
    	        txt_occupancy,
    	        txt_trfPoint,
    	        txt_trfCarrier,
    	        txt_trfFlt,
    	        txt_trfDt,
    	        txt_acftPos,
    	        btn_save,
    	        btn_close,
    	        info_footer;
    
    public OPR013(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
           
        txt_carrCode = MiscUtility.getWebElement(objFilepath, "OPR013_txt_carrCode");
        txt_fltNum = MiscUtility.getWebElement(objFilepath, "OPR013_txt_fltNum");
        txt_fltDt = MiscUtility.getWebElement(objFilepath, "OPR013_txt_fltDt");
        txt_ULDNo = MiscUtility.getWebElement(objFilepath, "OPR013_txt_ULDNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR013_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "OPR013_btn_clear");
        txt_occupancy = MiscUtility.getWebElement(objFilepath, "OPR013_txt_occupancy");
        txt_trfPoint = MiscUtility.getWebElement(objFilepath, "OPR013_txt_trfPoint");
        txt_trfCarrier = MiscUtility.getWebElement(objFilepath, "OPR013_txt_trfCarrier");
        txt_trfFlt = MiscUtility.getWebElement(objFilepath, "OPR013_txt_trfFlt");
        txt_trfDt = MiscUtility.getWebElement(objFilepath, "OPR013_txt_trfDt");
        txt_acftPos = MiscUtility.getWebElement(objFilepath, "OPR013_txt_acftPos");
        btn_save = MiscUtility.getWebElement(objFilepath, "OPR013_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR013_btn_close");
        
        info_footer = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }
    
    /**
     * Method to fill the ULD Tag details (the method doesn't list the flight/ULD.)
     * @param occupancy
     * @param trfPoint
     * @param trfCarrier
     * @param trfFlight
     * @param trfDt
     * @param acftPos
     * @return
     * @author A-7868 Krishna <17/05/2018>
     */
    public OPR013 fillULDTagDetails(String occupancy, String trfPoint, String trfCarrier, String trfFlight, String trfDt, String acftPos){
    	
    	occupancy = PropertyHandler.getPropValue(dataFilePath, occupancy);
    	trfPoint = PropertyHandler.getPropValue(dataFilePath, trfPoint);
    	trfCarrier = PropertyHandler.getPropValue(dataFilePath, trfCarrier);
    	trfFlight = PropertyHandler.getPropValue(dataFilePath, trfFlight);
    	trfDt = PropertyHandler.getPropValue(dataFilePath, trfDt);
    	acftPos = PropertyHandler.getPropValue(dataFilePath, acftPos);
    	
    	enterKeys(txt_occupancy, occupancy);
    	enterKeys(txt_trfPoint, trfPoint);
    	enterKeys(txt_trfCarrier, trfCarrier);
    	enterKeys(txt_trfFlt, trfFlight);
    	enterKeys(txt_trfDt, trfDt);
    	enterKeys(txt_acftPos, acftPos);
    	
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(info_footer).getText().contains("Details Saved Successfully"), "ERROR : Details not saved");
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }

    public OPR013 listAndFillULDTagDetails(String carrCode, String fltNum, String fltDt, String uldNo, 
    								String occupancy, String trfPoint, String trfCarrier, String trfFlight, String trfDt, String acftPos){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
    	fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
    	fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	occupancy = PropertyHandler.getPropValue(dataFilePath, occupancy);
    	trfPoint = PropertyHandler.getPropValue(dataFilePath, trfPoint);
    	trfCarrier = PropertyHandler.getPropValue(dataFilePath, trfCarrier);
    	trfFlight = PropertyHandler.getPropValue(dataFilePath, trfFlight);
    	trfDt = PropertyHandler.getPropValue(dataFilePath, trfDt);
    	acftPos = PropertyHandler.getPropValue(dataFilePath, acftPos);
    	
    	enterKeys(txt_carrCode, carrCode);
    	enterKeys(txt_fltNum, fltNum);
    	enterKeys(txt_fltDt, fltDt);
    	enterKeys(txt_ULDNo, uldNo);
    	click(btn_list);
    	minWait();
    	
    	enterKeys(txt_occupancy, occupancy);
    	enterKeys(txt_trfPoint, trfPoint);
    	enterKeys(txt_trfCarrier, trfCarrier);
    	enterKeys(txt_trfFlt, trfFlight);
    	enterKeys(txt_trfDt, trfDt);
    	enterKeys(txt_acftPos, acftPos);
    	
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(info_footer).getText().contains("Details Saved Successfully"), "ERROR : Details not saved");
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }

    /**
     * Method to close the page and return to OPR063
     * @return
     * @author A-7868 Krishna <17/05/2018>
     */
    public OPR063 closeToOPR063() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        waitForFrameAndSwitch("iCargoContentFrameOPR063");
        return new OPR063(driver, dataFileName);
    }
    
    /**
     * Method to close the page and return to Home page
     * @return
     * @author A-7868 Krishna <17/05/2018>
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
    
}
