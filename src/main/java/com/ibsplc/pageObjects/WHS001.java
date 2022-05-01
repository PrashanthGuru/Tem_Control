package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/5/2018.
 */
public class WHS001 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS001";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            txt_airport,
            txt_warehouse,
            btn_list,
            txt_desc,
            btn_save;

    private By btn_genericYes,
            info_footerMsg;

    public WHS001(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "WHS001_btn_close");
        txt_airport = MiscUtility.getWebElement(objFilepath, "WHS001_txt_airport");
        txt_warehouse = MiscUtility.getWebElement(objFilepath, "WHS001_txt_warehouse");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS001_btn_list");
        txt_desc = MiscUtility.getWebElement(objFilepath, "WHS001_txt_desc");
        btn_save = MiscUtility.getWebElement(objFilepath, "WHS001_btn_save");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    }

    /**
     * Create a new ware house for the given airport
     *
     * @param airport
     * @param warehouse
     * @return
     * @author Arun A-7681
     */
    public WHS001 createWarehouse(String airport, String warehouse) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);

        list(airport, warehouse);

        driver.switchTo().defaultContent();
        click(btn_genericYes);
        waitForFrameAndSwitch(FRAME);

        enterKeys(txt_desc, "This warehouse was created by automation.");

        click(btn_save);

        driver.switchTo().defaultContent();
        click(btn_genericYes);

        Assert.assertTrue(waitForElement(info_footerMsg).getText().trim().contains("Saved Successfully."), "The new warehouse is not created.");
        waitForFrameAndSwitch(FRAME);


        return this;
    }

    public WHS001 verifyWarehouse(String airport, String warehouse) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);

        list(airport, warehouse);

        Assert.assertTrue(waitForElement(txt_desc).getAttribute("value").contains("by automation"),"The warehouse is not listed correctly");

        return this;
    }

    /**
     * Lists a warehouse
     *
     * @param airport
     * @param warehouse
     */
    private void list(String airport, String warehouse) {

        enterKeys(txt_airport, airport);
        enterKeys(txt_warehouse, warehouse);
        click(btn_list);
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
