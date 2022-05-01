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
public class WHS031 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS031";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            btn_add,
            txt_tblCode,
            txt_tblDesc,
            dropDown_tblZoneTypeCat,
            txt_tblAirport,
            btn_save,
            txt_zoneType,
            txt_airport,
            btn_list;

    private By btn_genericYes,
            info_footerMsg;

    public WHS031(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        btn_close = MiscUtility.getWebElement(objFilepath, "WHS031_btn_close");
        btn_add = MiscUtility.getWebElement(objFilepath, "WHS031_btn_add");
        txt_tblCode = MiscUtility.getWebElement(objFilepath, "WHS031_txt_tblCode");
        txt_tblDesc = MiscUtility.getWebElement(objFilepath, "WHS031_txt_tblDesc");
        dropDown_tblZoneTypeCat = MiscUtility.getWebElement(objFilepath, "WHS031_dropDown_tblZoneTypeCat");
        txt_tblAirport = MiscUtility.getWebElement(objFilepath, "WHS031_txt_tblAirport");
        btn_save = MiscUtility.getWebElement(objFilepath, "WHS031_btn_save");
        txt_zoneType = MiscUtility.getWebElement(objFilepath, "WHS031_txt_zoneType");
        txt_airport = MiscUtility.getWebElement(objFilepath, "WHS031_txt_airport");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS031_btn_list");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    }

    /**
     * Adds a new zone type
     * @param airport
     * @param zoneType
     * @param zoneTypeCat
     * @return
     * @author Arun A-7681
     */
    public WHS031 addZoneType(String airport, String zoneType, String zoneTypeCat) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        zoneType = PropertyHandler.getPropValue(dataFilePath, zoneType);
        zoneTypeCat = PropertyHandler.getPropValue(dataFilePath, zoneTypeCat);

        click(btn_add);
        enterKeys(txt_tblCode, zoneType);
        enterKeys(txt_tblDesc, zoneType + " created by automation");
        selectByText(dropDown_tblZoneTypeCat, zoneTypeCat);
        enterKeys(txt_tblAirport, airport);

        click(btn_save);

        driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(info_footerMsg).getText().trim().contains("Saved successfully."), "The new warehouse is not created.");
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * Verifies created zone type
     * @param airport
     * @param zoneType
     * @return
     * @author Arun A-7681
     */
    public WHS031 verifyZoneType(String airport, String zoneType) {
        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        zoneType = PropertyHandler.getPropValue(dataFilePath, zoneType);

        enterKeys(txt_zoneType, zoneType);
        enterKeys(txt_airport, airport);
        click(btn_list);

        Assert.assertTrue(waitForElement(txt_tblDesc).getAttribute("value").contains("by automation"), "The listed zone type is not present.");
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
