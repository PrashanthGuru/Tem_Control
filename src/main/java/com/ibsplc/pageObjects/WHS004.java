package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/8/2018.
 */
public class WHS004 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS004";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            txt_airport,
            dropDown_warehouse,
            txt_strgStr,
            btn_list,
            txt_desc,
            txt_locType,
            txt_zone,
            btn_dimAdd,
            txt_dimension,
            txt_prefix,
            txt_range,
            txt_suffix,
            btn_addLocAdd,
            txt_addLocName,
            btn_save,
            btn_locTypeLOV,
            tbl_locTypeLOVTable,
            btn_locTypeLOVOk,
            btn_delete,
            btn_clear,
            list_txtAddLocName;

    private By btn_genericYes,
            btn_genericOk,
            info_error;

    public WHS004(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "WHS004_btn_close");
        txt_airport = MiscUtility.getWebElement(objFilepath, "WHS004_txt_airport");
        dropDown_warehouse = MiscUtility.getWebElement(objFilepath, "WHS004_dropDown_warehouse");
        txt_strgStr = MiscUtility.getWebElement(objFilepath, "WHS004_txt_strgStr");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS004_btn_list");
        txt_desc = MiscUtility.getWebElement(objFilepath, "WHS004_txt_desc");
        txt_locType = MiscUtility.getWebElement(objFilepath, "WHS004_txt_locType");
        txt_zone = MiscUtility.getWebElement(objFilepath, "WHS004_txt_zone");
        btn_dimAdd = MiscUtility.getWebElement(objFilepath, "WHS004_btn_dimAdd");
        txt_dimension = MiscUtility.getWebElement(objFilepath, "WHS004_txt_dimension");
        txt_prefix = MiscUtility.getWebElement(objFilepath, "WHS004_txt_prefix");
        txt_range = MiscUtility.getWebElement(objFilepath, "WHS004_txt_range");
        txt_suffix = MiscUtility.getWebElement(objFilepath, "WHS004_txt_suffix");
        btn_addLocAdd = MiscUtility.getWebElement(objFilepath, "WHS004_btn_addLocAdd");
        txt_addLocName = MiscUtility.getWebElement(objFilepath, "WHS004_txt_addLocName");
        btn_save = MiscUtility.getWebElement(objFilepath, "WHS004_btn_save");
        btn_locTypeLOV = MiscUtility.getWebElement(objFilepath, "WHS004_btn_locTypeLOV");
        tbl_locTypeLOVTable = MiscUtility.getWebElement(objFilepath, "WHS004_tbl_locTypeLOVTable");
        btn_locTypeLOVOk = MiscUtility.getWebElement(objFilepath, "WHS004_btn_locTypeLOVOk");
        btn_delete = MiscUtility.getWebElement(objFilepath, "WHS004_btn_delete");
        btn_clear = MiscUtility.getWebElement(objFilepath, "WHS004_btn_clear");
        list_txtAddLocName = MiscUtility.getWebElement(objFilepath, "WHS004_list_txtAddLocName");


        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    }

    /**
     * creates a storage structure
     *
     * @param airport
     * @param warehouse
     * @param strgStr
     * @param locType
     * @param zone
     * @return
     * @author Arun A-7681
     */
    public WHS004 createStorageStructure(String airport, String warehouse, String strgStr, String locType, String zone) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
        strgStr = PropertyHandler.getPropValue(dataFilePath, strgStr);
        locType = PropertyHandler.getPropValue(dataFilePath, locType);
        zone = PropertyHandler.getPropValue(dataFilePath, zone);

        list(airport, warehouse, strgStr);

        driver.switchTo().defaultContent();
        click(btn_genericYes);
        waitForFrameAndSwitch(FRAME);

        enterKeys(txt_desc, strgStr + " storage by automation");
//        enterKeys(txt_locType, locType);
        click(btn_locTypeLOV);
        waitForNewWindow(2);
        switchToSecondWindow();

        tblSelectRowByColValue(tbl_locTypeLOVTable, 1, 2, locType);
        click(btn_locTypeLOVOk);
        waitForNewWindow(1);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        enterKeys(txt_zone, zone);
        click(btn_dimAdd);
        enterKeys(txt_dimension, "AISLE");
        enterKeys(txt_prefix, "A");
        enterKeys(txt_range, "1-5");
        enterKeys(txt_suffix, "X");

        click(btn_addLocAdd);
        enterKeys(txt_addLocName, "DEFBDP");

        click(btn_save);

        driver.switchTo().defaultContent();
        click(btn_genericYes);
        waitForFrameAndSwitch(FRAME);

        list(airport, warehouse, strgStr);
        Assert.assertTrue(waitForElement(txt_desc).getAttribute("value").contains("by automation"));

        return this;
    }

    /**
     * creates a storage structure without dimensions
     *
     * @param airport
     * @param warehouse
     * @param strgStr
     * @param locType
     * @param zone
     * @return
     * @author Arun A-7681
     */
    public WHS004 createStrgStrWithoutDim(String airport, String warehouse, String strgStr, String locType, String zone, String loc) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
        locType = PropertyHandler.getPropValue(dataFilePath, locType);
        zone = PropertyHandler.getPropValue(dataFilePath, zone);
//        loc = PropertyHandler.getPropValue(dataFilePath, loc);
//        strgStr = PropertyHandler.getPropValue(dataFilePath, strgStr);

        String lc = null;
        String str = null;
        while (true) {
            str = "ST" + BizUtility.createFlightNum();
            list(airport, warehouse, str);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(btn_genericYes)) {
                click(btn_genericYes);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
            click(btn_clear);
        }
        PropertyHandler.setPropValue(dataFilePath, strgStr, str);

        enterKeys(txt_desc, strgStr + " storage by automation");
        enterKeys(txt_locType, locType);
        /*click(btn_locTypeLOV);
        waitForNewWindow(2);
        switchToSecondWindow();

        tblSelectRowByColValue(tbl_locTypeLOVTable, 1, 2, locType);
        click(btn_locTypeLOVOk);
        waitForNewWindow(1);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);*/

        enterKeys(txt_zone, zone);
//        click(btn_dimAdd);
//        enterKeys(txt_dimension, "AISLE");
//        enterKeys(txt_prefix, "A");
//        enterKeys(txt_range, "1-5");
//        enterKeys(txt_suffix, "X");

        click(btn_addLocAdd);

        while (true) {
            lc = "LC" + BizUtility.createFlightNum();
            enterKeys(txt_addLocName, lc);

            click(btn_save);

            driver.switchTo().defaultContent();
            click(btn_genericYes);
            waitForFrameAndSwitch(FRAME);

            if (!verifyElementPresent(info_error)) {
                break;
            }
        }
        PropertyHandler.setPropValue(dataFilePath, loc, lc);

//
//        list(airport, warehouse, strgStr);
//        Assert.assertTrue(waitForElement(txt_desc).getAttribute("value").contains("by automation"));

        return this;
    }

    /**
     * Verifies the created storage structure
     *
     * @param airport
     * @param warehouse
     * @param strgStr
     * @return
     * @author Arun A-7681
     */
    public WHS004 verifyStorageStructue(String airport, String warehouse, String strgStr) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
        strgStr = PropertyHandler.getPropValue(dataFilePath, strgStr);

        list(airport, warehouse, strgStr);

        Assert.assertEquals(waitForElement(txt_dimension).getAttribute("value").trim(), "AISLE");
        Assert.assertEquals(waitForElement(txt_prefix).getAttribute("value").trim(), "A");
        Assert.assertEquals(waitForElement(txt_range).getAttribute("value").trim(), "1-5");
        Assert.assertEquals(waitForElement(txt_suffix).getAttribute("value").trim(), "X");

        return this;
    }

    /**
     * lists a storage structure
     *
     * @param airport
     * @param warehouse
     * @param strgStr
     * @author Arun A-7681
     */
    private void list(String airport, String warehouse, String strgStr) {
        enterKeys(txt_airport, airport);
        selectByText(dropDown_warehouse, warehouse);
        enterKeys(txt_strgStr, strgStr);

        click(btn_list);
    }

    public WHS004 deleteStrgType(String airport, String warehouse, String strgStr) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
        strgStr = PropertyHandler.getPropValue(dataFilePath, strgStr);

        list(airport, warehouse, strgStr);

        click(btn_delete);
        driver.switchTo().defaultContent();
        click(btn_genericYes);
        click(btn_genericOk);
        waitForFrameAndSwitch(FRAME);


        return this;
    }

    /**
     * Adds a list of predefined locations to a storage type.
     *
     * @param airport
     * @param warehouse
     * @param strgStr
     * @param locs
     * @return
     * @author a-7681
     */
    public WHS004 addMultiLocPredefined(String airport, String warehouse, String strgStr, String... locs) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
        strgStr = PropertyHandler.getPropValue(dataFilePath, strgStr);

        list(airport, warehouse, strgStr);

        int count = 0;

        for (String loc : locs) {
            loc = PropertyHandler.getPropValue(dataFilePath, loc);

            click(btn_addLocAdd);
            enterKeys(getWebElements(list_txtAddLocName).get(count++), loc);

        }
        click(btn_save);

        if (verifyElementPresent(info_error))
            Assert.assertFalse(verifyElementPresent(info_error), "The location is already Present.\n Error message is: " + waitForElement(info_error).getText());

        driver.switchTo().defaultContent();
        click(btn_genericYes);
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

        minWait();
        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }


}
