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
public class WHS003 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS003";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            txt_airport,
            dropDown_warehouse,
            txt_zone,
            btn_list,
            txt_desc,
            txt_zoneType,
            btn_save;

    private By btn_genericYes,
            info_footerMsg;


    public WHS003(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "WHS003_btn_close");
        txt_airport = MiscUtility.getWebElement(objFilepath, "WHS003_txt_airport");
        dropDown_warehouse = MiscUtility.getWebElement(objFilepath, "WHS003_dropDown_warehouse");
        txt_zone = MiscUtility.getWebElement(objFilepath, "WHS003_txt_zone");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS003_btn_list");
        txt_desc = MiscUtility.getWebElement(objFilepath, "WHS003_txt_desc");
        txt_zoneType = MiscUtility.getWebElement(objFilepath, "WHS003_txt_zoneType");
        btn_save = MiscUtility.getWebElement(objFilepath, "WHS003_btn_save");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    }


    public WHS003 createZone(String airport, String warehouse, String zone, String zoneType) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
        zone = PropertyHandler.getPropValue(dataFilePath, zone);
        zoneType = PropertyHandler.getPropValue(dataFilePath, zoneType);

        list(airport, warehouse, zone);

        driver.switchTo().defaultContent();
        click(btn_genericYes);
        waitForFrameAndSwitch(FRAME);

        enterKeys(txt_desc, zone + " by automation");
        enterKeys(txt_zoneType, zoneType);

        click(btn_save);

        driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(info_footerMsg).getText().trim().contains("Saved Successfully."), "The new warehouse is not created.");
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * list a zone
     *
     * @param airport
     * @param warehouse
     * @param zone
     * @author Arun A-7681
     */
    private void list(String airport, String warehouse, String zone) {

        enterKeys(txt_airport, airport);
        selectByText(dropDown_warehouse, warehouse);
        enterKeys(txt_zone, zone);

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
