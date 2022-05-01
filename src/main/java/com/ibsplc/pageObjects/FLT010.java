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
public class FLT010 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameFLT010";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By txt_mappingCarrCode,
            txt_mappingFltNo,
            txt_mappingStation,
            txt_mappingOffice,
            btn_save,
            btn_close,
            btn_add;

    private By info_footerMsg,
            btn_genericYes;


    public FLT010(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        txt_mappingCarrCode = MiscUtility.getWebElement(objFilepath, "FLT010_txt_mappingCarrCode");
        txt_mappingFltNo = MiscUtility.getWebElement(objFilepath, "FLT010_txt_mappingFltNo");
        txt_mappingStation = MiscUtility.getWebElement(objFilepath, "FLT010_txt_mappingStation");
        txt_mappingOffice = MiscUtility.getWebElement(objFilepath, "FLT010_txt_mappingOffice");
        btn_save = MiscUtility.getWebElement(objFilepath, "FLT010_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath, "FLT010_btn_close");
        btn_add = MiscUtility.getWebElement(objFilepath, "FLT010_btn_add");

        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    /**
     * configures flight control for a flight
     *
     * @param carrCode
     * @param fltNo
     * @param station
     * @param office
     * @return
     */
    public FLT010 configureFlightControls(String carrCode, String fltNo, String station, String office) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        station = PropertyHandler.getPropValue(dataFilePath, station);
        office = PropertyHandler.getPropValue(dataFilePath, office);
        click(btn_add);
        enterKeys(txt_mappingCarrCode, carrCode);
        enterKeys(txt_mappingFltNo, fltNo);
        enterKeys(txt_mappingStation, station);
        enterKeys(txt_mappingOffice, office);
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
