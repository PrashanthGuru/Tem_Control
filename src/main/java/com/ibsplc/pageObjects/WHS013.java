package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/13/2018.
 */
public class WHS013 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS013";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            txt_locType,
            btn_list,
            tbl_locDetails,
            btn_block,
            txt_blockUntil,
            txt_blockRemarks,
            btn_blockOk,
            btn_unBlock,
            link_next,
            chkBx_blocked,
            btn_damageInfo,
            dropDown_damageCode,
            txt_damageRemarks,
            btn_damageOk,
            btn_damageDelete,
            chkBx_damaged,
            chkBx_reserved,
            btn_clear,
            btn_cancelRes;

    private By btn_genericYes;


    public WHS013(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "WHS013_btn_close");
        txt_locType = MiscUtility.getWebElement(objFilepath, "WHS013_txt_locType");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS013_btn_list");
        tbl_locDetails = MiscUtility.getWebElement(objFilepath, "WHS013_tbl_locDetails");
        btn_block = MiscUtility.getWebElement(objFilepath, "WHS013_btn_block");
        btn_unBlock = MiscUtility.getWebElement(objFilepath, "WHS013_btn_unBlock");
        txt_blockUntil = MiscUtility.getWebElement(objFilepath, "WHS013_txt_blockUntil");
        txt_blockRemarks = MiscUtility.getWebElement(objFilepath, "WHS013_txt_blockRemarks");
        btn_blockOk = MiscUtility.getWebElement(objFilepath, "WHS013_btn_blockOk");
        link_next = MiscUtility.getWebElement(objFilepath, "WHS013_link_next");
        chkBx_blocked = MiscUtility.getWebElement(objFilepath, "WHS013_chkBx_blocked");
        btn_damageInfo = MiscUtility.getWebElement(objFilepath, "WHS013_btn_damageInfo");
        dropDown_damageCode = MiscUtility.getWebElement(objFilepath, "WHS013_dropDown_damageCode");
        txt_damageRemarks = MiscUtility.getWebElement(objFilepath, "WHS013_txt_damageRemarks");
        btn_damageOk = MiscUtility.getWebElement(objFilepath, "WHS013_btn_damageOk");
        btn_damageDelete = MiscUtility.getWebElement(objFilepath, "WHS013_btn_damageDelete");
        chkBx_damaged = MiscUtility.getWebElement(objFilepath, "WHS013_chkBx_damaged");
        chkBx_reserved = MiscUtility.getWebElement(objFilepath, "WHS013_chkBx_reserved");
        btn_clear = MiscUtility.getWebElement(objFilepath, "WHS013_btn_clear");
        btn_cancelRes = MiscUtility.getWebElement(objFilepath, "WHS013_btn_cancelRes");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    /**
     * Bolocks a location
     *
     * @param locType
     * @param location
     * @param username
     * @param occupancy: Not read from data sheet
     * @return
     * @author Arun A-7681
     */
    public WHS013 blockLocation(String locType, String location, String username, String occupancy) {

        locType = PropertyHandler.getPropValue(dataFilePath, locType);
        username = PropertyHandler.getPropValue(dataFilePath, username);
        String loc = null;

        enterKeys(txt_locType, locType);
        click(btn_list);
        minWait();

        loc = tblGetTextByColValue(tbl_locDetails, 2, 7, occupancy).trim();
        PropertyHandler.setPropValue(dataFilePath, location, loc);
        tblSelectRowByColValue(tbl_locDetails, 1, 2, loc);

        click(btn_block);
        driver.switchTo().defaultContent();
        click(btn_genericYes);

        switchToSecondWindow();
        enterKeys(txt_blockUntil, "+1");
        enterKeys(txt_blockRemarks, "REMARKS");
        click(btn_blockOk);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        Assert.assertEquals(tblGetTextByColValue(tbl_locDetails, 9, 2, loc).trim().toUpperCase(), username.toUpperCase());
        Assert.assertEquals(tblGetTextByColValue(tbl_locDetails, 10, 2, loc).trim().toUpperCase(), "BLOCKED");
        Assert.assertEquals(tblGetTextByColValue(tbl_locDetails, 11, 2, loc).trim().toUpperCase(), "REMARKS");


        return this;
    }

    /**
     * Bolocks a  gienv location
     *
     * @param locType
     * @param loc
     * @param username
     * @return
     * @author Arun A-7681
     */
    public WHS013 blockGivenLocation(String locType, String loc, String username) {

        locType = PropertyHandler.getPropValue(dataFilePath, locType);
        username = PropertyHandler.getPropValue(dataFilePath, username);
        loc = PropertyHandler.getPropValue(dataFilePath, loc);

        enterKeys(txt_locType, locType);
        click(btn_list);
        minWait();

        tblSelectRowByColValue(tbl_locDetails, 1, 2, loc);

        click(btn_block);
        driver.switchTo().defaultContent();
        click(btn_genericYes);

        switchToSecondWindow();
        enterKeys(txt_blockUntil, "+1");
        enterKeys(txt_blockRemarks, "REMARKS");
        click(btn_blockOk);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        Assert.assertEquals(tblGetTextByColValue(tbl_locDetails, 9, 2, loc).trim().toUpperCase(), username.toUpperCase());
        Assert.assertEquals(tblGetTextByColValue(tbl_locDetails, 10, 2, loc).trim().toUpperCase(), "BLOCKED");
        Assert.assertEquals(tblGetTextByColValue(tbl_locDetails, 11, 2, loc).trim().toUpperCase(), "REMARKS");


        return this;
    }

    /**
     * Un-Bolocks a location
     *
     * @param locType
     * @param location
     * @return
     * @author Arun A-7681
     */
    public WHS013 unBlockLocation(String locType, String location) {

        locType = PropertyHandler.getPropValue(dataFilePath, locType);
        location = PropertyHandler.getPropValue(dataFilePath, location);

        enterKeys(txt_locType, locType);
        click(btn_list);
        minWait();
        boolean flag = false;

        while (true) {
            if (verifyValuePresentInTblColumn(tbl_locDetails, 2, location)) {
                tblSelectRowByColValue(tbl_locDetails, 1, 2, location);
                flag = true;
                break;
            }
            try {
                click(link_next);
            } catch (NoSuchElementException | TimeoutException e) {
                break;
            }
        }

        Assert.assertTrue(flag, "There is no location " + location + " for the location type " + locType);

        click(btn_unBlock);
        minWait();
        Assert.assertEquals(tblGetTextByColValue(tbl_locDetails, 9, 2, location).trim().toUpperCase(), "");
        Assert.assertEquals(tblGetTextByColValue(tbl_locDetails, 10, 2, location).trim().toUpperCase(), "");
        Assert.assertEquals(tblGetTextByColValue(tbl_locDetails, 11, 2, location).trim().toUpperCase(), "");


        return this;
    }

    /**
     * Lists all the blocked locatons and checks if the argument locations are present in the list
     *
     * @param locType
     * @param locations can be more than one
     * @return
     * @author Arun A-7681
     *//*
    public WHS013 listBlockedLoc(String locType, String... locations) {

        locType = PropertyHandler.getPropValue(dataFilePath, locType);
        enterKeys(txt_locType, locType);
        check(chkBx_blocked);
        click(btn_list);
        minWait();

        for (String loc : locations) {
            loc = PropertyHandler.getPropValue(dataFilePath, loc);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_locDetails, 2, loc), "The location " + loc + " is not present in the blocked list.");
        }

        return this;
    }*/

    /**
     * Captures damage information for an empty location
     * @param locType
     * @param location
     * @return
     * @author Arun A-7681
     */
    public WHS013 damageLocation(String locType, String location) {

        locType = PropertyHandler.getPropValue(dataFilePath, locType);
        String loc = null;

        enterKeys(txt_locType, locType);
        click(btn_list);
        minWait();

        loc = tblGetTextByColValue(tbl_locDetails, 2, 7, "Empty").trim();
        PropertyHandler.setPropValue(dataFilePath, location, loc);
        tblSelectRowByColValue(tbl_locDetails, 1, 2, loc);

        click(btn_damageInfo);

        switchToSecondWindow();
        selectByText(dropDown_damageCode, "Corroded");
        enterKeys(txt_damageRemarks, "REMARKS");
        click(btn_damageOk);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        Assert.assertEquals(tblchkBxEnabledByColValue(tbl_locDetails, 13, 2, loc), true, "The Damage to the location is not recorded");
        Assert.assertEquals(tblGetTextByColValue(tbl_locDetails, 14, 2, loc).trim().toUpperCase(), "CORRODED");
        Assert.assertEquals(tblGetTextByColValue(tbl_locDetails, 15, 2, loc).trim().toUpperCase(), "REMARKS");

        return this;
    }

    /**
     * Captures damage information for an empty location
     * @param locType
     * @param location
     * @return
     * @author Arun A-7681
     */
    public WHS013 deleteLocDamage(String locType, String location) {

        locType = PropertyHandler.getPropValue(dataFilePath, locType);
        location = PropertyHandler.getPropValue(dataFilePath, location);
        String loc = null;

        enterKeys(txt_locType, locType);
        click(btn_list);
        minWait();

        loc = tblGetTextByColValue(tbl_locDetails, 2, 7, "Empty").trim();
        PropertyHandler.setPropValue(dataFilePath, location, loc);
        tblSelectRowByColValue(tbl_locDetails, 1, 2, loc);

        click(btn_damageInfo);

        switchToSecondWindow();
        click(btn_damageDelete);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        Assert.assertEquals(tblchkBxEnabledByColValue(tbl_locDetails, 13, 2, loc), false, "The Damage to the location is still recorded");

        return this;
    }

    /**
     * Lists all the damaged locatons and checks if the argument locations are present in the list
     *
     * @param locType
     * @param locations can be more than one
     * @return
     * @author Arun A-7681
     *//*
    public WHS013 listDamagedLoc(String locType, String... locations) {

        locType = PropertyHandler.getPropValue(dataFilePath, locType);
        enterKeys(txt_locType, locType);
        check(chkBx_damaged);
        click(btn_list);
        minWait();

        for (String loc : locations) {
            loc = PropertyHandler.getPropValue(dataFilePath, loc);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_locDetails, 2, loc), "The location " + loc + " is not present in the damaged list.");
        }

        return this;
    }*/

    /**
     * Lists all the damaged locatons and checks if the argument locations are present in the list
     *
     * @param locType
     * @param filter: Not read from data sheet
     * @param locations can be more than one
     * @return
     * @author Arun A-7681
     */
    public WHS013 listLocWithFilter(String locType, String filter, String... locations) {

        locType = PropertyHandler.getPropValue(dataFilePath, locType);
        enterKeys(txt_locType, locType);
        if (filter.equalsIgnoreCase("Damaged")) {
            check(chkBx_damaged);
        }
        if (filter.equalsIgnoreCase("Blocked")) {
            check(chkBx_blocked);
        }
        if (filter.equalsIgnoreCase("Reserved")) {
            check(chkBx_reserved);
        }
        click(btn_list);
        minWait();

        for (String loc : locations) {
            loc = PropertyHandler.getPropValue(dataFilePath, loc);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_locDetails, 2, loc), "The location " + loc + " is not present in the damaged list.");
        }

        return this;
    }

    /**
     * Unreserves a location
     * @param locType
     * @param location
     * @return
     * @author a-7681
     */
    public WHS013 unreserveLocation(String locType, String location){

        locType = PropertyHandler.getPropValue(dataFilePath,locType);
        location = PropertyHandler.getPropValue(dataFilePath,location);

        enterKeys(txt_locType,locType);
        click(btn_list);
        minWait();

        tblSelectRowByColValue(tbl_locDetails,1,2,location);

        click(btn_cancelRes);
        minWait();
        String resDtls = tblGetTextByColValue(tbl_locDetails,8,2,location).trim();

        Assert.assertEquals(resDtls,"","The reservation details are still present.");

        return this;
    }

    public WHS013 clear(){
        try{
            click(btn_clear);
        }
        catch (Exception e){
            Actions action = new Actions(driver);
            action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();
        }
        minWait();
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
