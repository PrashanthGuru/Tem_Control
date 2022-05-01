package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/5/2018.
 */
public class WHS002 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS002";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            txt_airport,
            dropDown_warehouse,
            txt_locType,
            btn_list,
            txt_desc,
            dropDown_natureOfStorage,
            chkBx_directStorageShipments,
            chkBx_emptyStorageShipments,
            chkBx_multipleShipments,
            chkBx_multipleStorageShipments,
            txt_maxSKIDS,
            btn_save,
            txt_maxWt,
            btn_addStrgUnit,
            txt_strgUnit,
            btn_delete,
            btn_clear;

    private By btn_genericYes,
            info_footerMsg;

    public WHS002(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "WHS002_btn_close");
        txt_airport = MiscUtility.getWebElement(objFilepath, "WHS002_txt_airport");
        dropDown_warehouse = MiscUtility.getWebElement(objFilepath, "WHS002_dropDown_warehouse");
        txt_locType = MiscUtility.getWebElement(objFilepath, "WHS002_txt_locType");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS002_btn_list");
        txt_desc = MiscUtility.getWebElement(objFilepath, "WHS002_txt_desc");
        dropDown_natureOfStorage = MiscUtility.getWebElement(objFilepath, "WHS002_dropDown_natureOfStorage");
        chkBx_directStorageShipments = MiscUtility.getWebElement(objFilepath, "WHS002_chkBx_directStorageShipments");
        chkBx_emptyStorageShipments = MiscUtility.getWebElement(objFilepath, "WHS002_chkBx_emptyStorageShipments");
        chkBx_multipleShipments = MiscUtility.getWebElement(objFilepath, "WHS002_chkBx_multipleShipments");
        chkBx_multipleStorageShipments = MiscUtility.getWebElement(objFilepath, "WHS002_chkBx_multipleStorageShipments");
        txt_maxSKIDS = MiscUtility.getWebElement(objFilepath, "WHS002_txt_maxSKIDS");
        btn_save = MiscUtility.getWebElement(objFilepath, "WHS002_btn_save");
        txt_maxWt = MiscUtility.getWebElement(objFilepath, "WHS002_txt_maxWt");
        btn_addStrgUnit = MiscUtility.getWebElement(objFilepath, "WHS002_btn_addStrgUnit");
        txt_strgUnit = MiscUtility.getWebElement(objFilepath, "WHS002_txt_strgUnit");
        btn_delete = MiscUtility.getWebElement(objFilepath, "WHS002_btn_delete");
        btn_clear = MiscUtility.getWebElement(objFilepath, "WHS002_btn_clear");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    }

    /**
     * Creates a new location setup for the given airport and warehouse
     *
     * @param airport
     * @param warehouse
     * @param locType
     * @return
     * @author Arun A-7681
     */
    public WHS002 createLocationType(String airport, String warehouse, String locType) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
        locType = PropertyHandler.getPropValue(dataFilePath, locType);

        list(airport, warehouse, locType);
        driver.switchTo().defaultContent();
        click(btn_genericYes);
        waitForFrameAndSwitch(FRAME);

        enterKeys(txt_desc, locType + " location created by automation");
        selectByText(dropDown_natureOfStorage, "Storage");

        check(chkBx_directStorageShipments);
        check(chkBx_emptyStorageShipments);
        check(chkBx_multipleShipments);
        check(chkBx_multipleStorageShipments);

        enterKeys(txt_maxSKIDS, "6");
        enterKeys(txt_maxWt, "1000");

        click(btn_save);
        driver.switchTo().defaultContent();
        click(btn_genericYes);

        Assert.assertTrue(waitForElement(info_footerMsg).getText().trim().contains("Saved Successfully."), "The new warehouse is not created.");
        waitForFrameAndSwitch(FRAME);

        return this;
    }


    /**
     * Creates a new location setup for the given airport and warehouse with the given parameters
     *
     * @param airport
     * @param warehouse
     * @param locType
     * @param directStrg
     * @param emptyStrg
     * @param multiShipments
     * @param multiStrg
     * @param maxSkidID:       Not read from datasheet
     * @param maxWt:           Not read from datasheet
     * @param allowedStrgUnits
     * @param allowedUnit:     Not read from datasheet
     * @return
     * @author Arun A-7681
     */
    public WHS002 createLocationType(String airport, String warehouse, String locType, boolean directStrg, boolean emptyStrg, boolean multiShipments, boolean multiStrg, String maxSkidID, String maxWt, boolean allowedStrgUnits, String allowedUnit) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
//        locType = PropertyHandler.getPropValue(dataFilePath, locType);
        String lt = null;
        while (true) {
            lt = "LT" + BizUtility.createFlightNum();
            list(airport, warehouse, lt);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(btn_genericYes)) {
                click(btn_genericYes);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
            click(btn_clear);
        }
        PropertyHandler.setPropValue(dataFilePath, locType, lt);

        enterKeys(txt_desc, locType + " location created by automation");
        selectByText(dropDown_natureOfStorage, "Storage");

        if (directStrg) {
            check(chkBx_directStorageShipments);
        }
        if (emptyStrg) {
            check(chkBx_emptyStorageShipments);
        }
        if (multiShipments) {
            check(chkBx_multipleShipments);
        }
        if (multiStrg) {
            check(chkBx_multipleStorageShipments);
        }

        if (allowedStrgUnits) {
            click(btn_addStrgUnit);
            enterKeys(txt_strgUnit, allowedUnit);
        }


        enterKeys(txt_maxSKIDS, maxSkidID);
        enterKeys(txt_maxWt, maxWt);

        click(btn_save);
        driver.switchTo().defaultContent();
        click(btn_genericYes);

        Assert.assertTrue(waitForElement(info_footerMsg).getText().trim().contains("Saved Successfully."), "The new warehouse is not created.");
        waitForFrameAndSwitch(FRAME);

        return this;
    }


    /**
     * Verifies the location setup created
     *
     * @param airport
     * @param warehouse
     * @param locType
     * @return
     * @author Arun A-7681
     */
    public WHS002 verifyLocationSetup(String airport, String warehouse, String locType) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
        locType = PropertyHandler.getPropValue(dataFilePath, locType);

        list(airport, warehouse, locType);

        Assert.assertTrue(waitForElement(txt_desc).getAttribute("value").contains("by automation"), "The warehouse location is not listed correctly");

        return this;
    }

    /**
     * lists location setup
     *
     * @param airport
     * @param warehouse
     * @param locType
     * @author Arun A-7681
     */
    private void list(String airport, String warehouse, String locType) {
        enterKeys(txt_airport, airport);
        selectByText(dropDown_warehouse, warehouse);
        enterKeys(txt_locType, locType);
        click(btn_list);
    }

    public WHS002 deleteLocType(String airport, String warehouse, String locType) {
        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
        locType = PropertyHandler.getPropValue(dataFilePath, locType);

        list(airport, warehouse, locType);

        click(btn_delete);
        driver.switchTo().defaultContent();
        click(btn_genericYes);
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * Clears the form
     *
     * @return
     * @author Arun A-7681
     */
    public WHS002 clear() {

        minWait();
        waitForElement(btn_close);
        Actions action = new Actions(driver);
        action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();
        //click(btn_clear);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {
            click(btn_genericYes);
        }

        waitForFrameAndSwitch(FRAME);
        return this;
    }

    /**
     * closes the screen and goes back to home page
     *
     * @return
     * @author Arun A-7681
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
