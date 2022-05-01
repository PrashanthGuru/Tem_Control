package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 1/12/2018.
 */
public class FLT025 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameFLT025";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By txt_carrCode,
            txt_fltNo,
            btn_list,
            btn_add,
            txt_configCarrCode,
            txt_configFltNo,
            txt_configHrs,
            txt_configReductions,
            txt_configLFUnder,
            txt_configLFExceed,
            btn_save,
            btn_close;

    private By info_footerMsg,
            btn_genericYes;


    public FLT025(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        txt_carrCode = MiscUtility.getWebElement(objFilepath, "FLT025_txt_carrCode");
        txt_fltNo = MiscUtility.getWebElement(objFilepath, "FLT025_txt_fltNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "FLT025_btn_list");
        btn_add = MiscUtility.getWebElement(objFilepath, "FLT025_btn_add");
        txt_configCarrCode = MiscUtility.getWebElement(objFilepath, "FLT025_txt_configCarrCode");
        txt_configFltNo = MiscUtility.getWebElement(objFilepath, "FLT025_txt_configFltNo");
        txt_configHrs = MiscUtility.getWebElement(objFilepath, "FLT025_txt_configHrs");
        txt_configReductions = MiscUtility.getWebElement(objFilepath, "FLT025_txt_configReductions");
        txt_configLFUnder = MiscUtility.getWebElement(objFilepath, "FLT025_txt_configLFUnder");
        txt_configLFExceed = MiscUtility.getWebElement(objFilepath, "FLT025_txt_configLFExceed");
        btn_save = MiscUtility.getWebElement(objFilepath, "FLT025_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath, "FLT025_btn_close");

        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    }

    /**
     * configures flight control for a flight
     *
     * @param carrCode
     * @param fltNo
     * @param hrs: not read from data sheet
     * @param reduction: not read from data sheet
     * @param LFUnder: not read from data sheet
     * @param LFExceed: not read from data sheet
     * @return
     */
    public FLT025 createFlightCapConfig(String carrCode, String fltNo, String hrs, String reduction, String LFUnder, String LFExceed) {

        carrCode = PropertyHandler.getPropValue(dataFilePath,carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath,fltNo);
        /*hrs = PropertyHandler.getPropValue(dataFilePath,hrs);
        reduction = PropertyHandler.getPropValue(dataFilePath,reduction);
        LFUnder = PropertyHandler.getPropValue(dataFilePath,LFUnder);
        LFExceed = PropertyHandler.getPropValue(dataFilePath,LFExceed);*/

        enterKeys(txt_carrCode, carrCode);
        enterKeys(txt_fltNo, fltNo);
        click(btn_list);
        click(btn_add);
        enterKeys(txt_configCarrCode, carrCode);
        enterKeys(txt_configFltNo, fltNo);
        enterKeys(txt_configHrs, hrs);
        enterKeys(txt_configReductions, reduction);
        enterKeys(txt_configLFUnder, LFUnder);
        enterKeys(txt_configLFExceed, LFExceed);
        click(btn_save);

        driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(info_footerMsg).getText().contains("Saved successfully"));
        waitForFrameAndSwitch(FRAME);
        return this;
    }

    /**
     * CLose and screen and go to home page
     *
     * @return
     * @author A-7681
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
