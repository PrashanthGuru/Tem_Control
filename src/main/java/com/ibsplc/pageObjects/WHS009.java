package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/14/2018.
 */
public class WHS009 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS009";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            tbl_current,
            btn_fullRelocate,
            txt_rlocateLoc,
            btn_relocateOk,
            tbl_new,
            btn_save,
            btn_splitRelocate,
            txt_rlocatePcs,
            txt_rlocateWt,
            btn_rlocateNext,
            btn_relocateClose,
            chkBx_reserveLoc,
            txt_loc,
            btn_list;

    private By btn_genericYes,
            info_error,
            overlay;

    public WHS009(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        btn_close = MiscUtility.getWebElement(objFilepath, "WHS009_btn_close");
        tbl_current = MiscUtility.getWebElement(objFilepath, "WHS009_tbl_current");
        btn_fullRelocate = MiscUtility.getWebElement(objFilepath, "WHS009_btn_fullRelocate");
        txt_rlocateLoc = MiscUtility.getWebElement(objFilepath, "WHS009_txt_rlocateLoc");
        btn_relocateOk = MiscUtility.getWebElement(objFilepath, "WHS009_btn_relocateOk");
        tbl_new = MiscUtility.getWebElement(objFilepath, "WHS009_tbl_new");
        btn_save = MiscUtility.getWebElement(objFilepath, "WHS009_btn_save");
        btn_splitRelocate = MiscUtility.getWebElement(objFilepath, "WHS009_btn_splitRelocate");
        txt_rlocatePcs = MiscUtility.getWebElement(objFilepath, "WHS009_txt_rlocatePcs");
        txt_rlocateWt = MiscUtility.getWebElement(objFilepath, "WHS009_txt_rlocateWt");
        btn_rlocateNext = MiscUtility.getWebElement(objFilepath, "WHS009_btn_rlocateNext");
        btn_relocateClose = MiscUtility.getWebElement(objFilepath, "WHS009_btn_relocateClose");
        chkBx_reserveLoc = MiscUtility.getWebElement(objFilepath, "WHS009_chkBx_reserveLoc");
        txt_loc = MiscUtility.getWebElement(objFilepath, "WHS009_txt_loc");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS009_btn_list");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        overlay = MiscUtility.getWebElement(genObjPath, "Generic_overlay");

    }

    /**
     * Fully relocates a shipment to new location
     *
     * @param awbNo
     * @param newLoc
     * @param reserveLoc: true if the original location is reserved
     * @return
     * @author Arun A-7681
     */
    public WHS009 fullRelocateNavigatingFromWHS011(String awbNo, String newLoc, boolean reserveLoc, boolean errChk, String error) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        newLoc = PropertyHandler.getPropValue(dataFilePath, newLoc);
        if (!error.equals("")) {
            error = PropertyHandler.getPropValue(dataFilePath, error);
        }

        tblSelectRowByColValue(tbl_current, 1, 3, awbNo);
        click(btn_fullRelocate);

        switchToSecondWindow();
        enterKeys(txt_rlocateLoc, newLoc);
        if (reserveLoc) {
            check(chkBx_reserveLoc);
        }

        Assert.assertNotNull(waitForElementVisible(txt_rlocatePcs).getAttribute("readonly"), "The relocate pieces field is editable");
        Assert.assertNotNull(waitForElementVisible(txt_rlocateWt).getAttribute("readonly"), "The relocate weight field is editable");

        click(btn_relocateOk);

        if (errChk) {
            Assert.assertTrue(waitForElement(info_error).getText().contains(error), "The error is not displayed");
            click(btn_relocateClose);
            switchToFirstWindow();
            waitForFrameAndSwitch("iCargoContentFrameWHS011");
            return this;
        }

        switchToFirstWindow();
        waitForFrameAndSwitch("iCargoContentFrameWHS011");
        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_new, 3, awbNo), "The awb " + awbNo + " is not relocated");
        Assert.assertEquals(tblGetTextByColValue(tbl_new, 7, 3, awbNo).trim(), newLoc, "The relocated location is not as the given new location.");

        waitForElementInVisible(overlay);
        click(btn_save);
        return this;
    }

    /**
     * Fully relocates a shipment to new location
     *
     * @param newLoc
     * @param reserveLoc: true if the original location is reserved
     * @param errChk: true if need to check error
     * @param error: error msg to check. if errChk is flase set it as ""
     * @param awbNos:     can be more than one awb
     * @return
     * @author Arun A-7681
     */
    public WHS009 fullRelocateAWBsNavigatingFromWHS011(String newLoc, boolean reserveLoc, boolean errChk, String error, String... awbNos) {

        newLoc = PropertyHandler.getPropValue(dataFilePath, newLoc);

        if (!error.equals("")) {
            error = PropertyHandler.getPropValue(dataFilePath, error);
        }

        for (String awbNo : awbNos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            tblSelectRowByColValue(tbl_current, 1, 3, awbNo);
        }
        click(btn_fullRelocate);

        switchToSecondWindow();
        enterKeys(txt_rlocateLoc, newLoc);
        if (reserveLoc) {
            check(chkBx_reserveLoc);
        }

        Assert.assertNotNull(waitForElementVisible(txt_rlocatePcs).getAttribute("readonly"), "The relocate pieces field is editable");
        Assert.assertNotNull(waitForElementVisible(txt_rlocateWt).getAttribute("readonly"), "The relocate weight field is editable");

        click(btn_relocateOk);

        if (errChk) {
            Assert.assertTrue(waitForElement(info_error).getText().contains(error), "The error for location full is not displayed\n Expected: " + error + "\n Actual: " + waitForElement(info_error).getText());
            click(btn_relocateClose);
            switchToFirstWindow();
            waitForFrameAndSwitch("iCargoContentFrameWHS011");
            return this;
        }

        switchToFirstWindow();
        waitForFrameAndSwitch("iCargoContentFrameWHS011");

        waitForElementInVisible(overlay);
        click(btn_save);
        return this;
    }

    /**
     * Fully relocates a shipment to new location
     *
     * @param newLoc
     * @param reserveLoc: true if the original location is reserved
     * @param errChk: true if need to check error
     * @param error: error msg to check. if errChk is flase set it as ""
     * @param awbNos:     can be more than one awb
     * @return
     * @author Arun A-7681
     */
    public WHS009 fullRelocateAWBs(String loc, String newLoc, boolean reserveLoc, boolean errChk,String error, String... awbNos) {

        loc = PropertyHandler.getPropValue(dataFilePath, loc);
        if (!error.equals("")) {
            error = PropertyHandler.getPropValue(dataFilePath, error);
        }
        enterKeys(txt_loc, loc);
        click(btn_list);
        minWait();

        newLoc = PropertyHandler.getPropValue(dataFilePath, newLoc);

        for (String awbNo : awbNos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            tblSelectRowByColValue(tbl_current, 1, 3, awbNo);
        }
        click(btn_fullRelocate);

        switchToSecondWindow();
        enterKeys(txt_rlocateLoc, newLoc);
        if (reserveLoc) {
            check(chkBx_reserveLoc);
        }

        Assert.assertNotNull(waitForElementVisible(txt_rlocatePcs).getAttribute("readonly"), "The relocate pieces field is editable");
        Assert.assertNotNull(waitForElementVisible(txt_rlocateWt).getAttribute("readonly"), "The relocate weight field is editable");

        click(btn_relocateOk);

        if (errChk) {
            Assert.assertTrue(waitForElement(info_error).getText().contains(error), "The error is not displayed");
            click(btn_relocateClose);
            switchToFirstWindow();
            waitForFrameAndSwitch(FRAME);
            return this;
        }

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        waitForElementInVisible(overlay);
        click(btn_save);
        return this;
    }

    /**
     * Split and relocates an shipment
     *
     * @param awbNo
     * @param newLoc
     * @param pcs1
     * @param wt1
     * @param relocateRemaining: true to relocate the remaining pieces
     * @param errChk:            true if needed to check no remaining pieces error
     * @param remainingDtls:     enter in the order location, pcs, wt
     * @return
     * @author Arun A-7681
     */

    public WHS009 partialRelocateNavigatingFromWHS011(String awbNo, String newLoc, String pcs1, String wt1, boolean relocateRemaining, boolean errChk, String error,  String... remainingDtls) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        newLoc = PropertyHandler.getPropValue(dataFilePath, newLoc);
        pcs1 = PropertyHandler.getPropValue(dataFilePath, pcs1);
        wt1 = PropertyHandler.getPropValue(dataFilePath, wt1);

        if (!error.equals("")) {
            error = PropertyHandler.getPropValue(dataFilePath, error);
        }

        tblSelectRowByColValue(tbl_current, 1, 3, awbNo);
        click(btn_splitRelocate);

        switchToSecondWindow();
        enterKeys(txt_rlocateLoc, newLoc);
        enterKeys(txt_rlocatePcs, pcs1);
        enterKeys(txt_rlocateWt, wt1);
        if (relocateRemaining) {
            click(btn_rlocateNext);
            enterKeys(txt_rlocateLoc, PropertyHandler.getPropValue(dataFilePath, remainingDtls[0]));
            enterKeys(txt_rlocatePcs, PropertyHandler.getPropValue(dataFilePath, remainingDtls[1]));
            enterKeys(txt_rlocateWt, PropertyHandler.getPropValue(dataFilePath, remainingDtls[2]));
        }
        if (errChk) {
            click(btn_rlocateNext);
            Assert.assertTrue(waitForElement(info_error).getText().contains(error), "The error for no pieces to relocate not displayed");
            click(btn_relocateClose);
            switchToFirstWindow();
            waitForFrameAndSwitch("iCargoContentFrameWHS011");
            return this;
        }
        click(btn_relocateOk);

        switchToFirstWindow();
        waitForFrameAndSwitch("iCargoContentFrameWHS011");

        waitForElementInVisible(overlay);
        click(btn_save);
        minWait();
        return this;
    }

    public WHS009 relocationErrorFromWHS011(String awbNo, String newLoc, String pcs, String wt) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        newLoc = PropertyHandler.getPropValue(dataFilePath, newLoc);

        tblSelectRowByColValue(tbl_current, 1, 3, awbNo);

        click(btn_fullRelocate);

        switchToSecondWindow();
        enterKeys(txt_rlocateLoc, newLoc);
        click(btn_relocateOk);

        switchToFirstWindow();
        waitForFrameAndSwitch("iCargoContentFrameWHS011");

        waitForElementInVisible(overlay);
        click(btn_save);

        Assert.assertTrue(waitForElement(info_error).getText().contains("iCargo_RD_ST_OPS_Warehouse lock present"), "The error message doesn't match. Actual: " + waitForElement(info_error).getText());

        return this;
    }

    /**
     * Method to close current page and return to screen WHS011
     *
     * @return
     * @author Arun A-7681
     */
    public WHS011 closeToWHS011() {
        minWait();
        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes))
            click(btn_genericYes);
        waitForFrameAndSwitch("iCargoContentFrameWHS011");
        return new WHS011(driver, dataFileName);
    }


    /**
     * Method to close current page and return to Homepae
     * returns the instance of Homepage
     *
     * @return
     * @author Arun A-7681
     */
    public HomePage close() {
        minWait();
        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes))
            click(btn_genericYes);
        return new HomePage(driver, dataFileName);
    }
}
