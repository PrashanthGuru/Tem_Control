package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/2/2018.
 */
public class OPR006 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameOPR006";
    private WebDriver driver;
    private String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    private By btn_close,
            btn_show,
            chkBx_planned,
            chkBx_buildUp,
            chkBx_manifested,
            chkBx_offloaded,
            tbl_shipments,
            tab_MsgTrans,
            tab_uld,
            tbl_msgTbl,
            tbl_transTbl,
            tbl_uld,
            btn_resend,
            btn_msgAddress,
            btn_addressOk,
            btn_msgSend,
            dropDown_msgInterface,
            dropDown_msgTransMission,
            btn_view;

    private By btn_genericYes;

    public OPR006(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR006_btn_close");
        btn_show = MiscUtility.getWebElement(objFilepath, "OPR006_btn_show");
        chkBx_planned = MiscUtility.getWebElement(objFilepath, "OPR006_chkBx_planned");
        chkBx_buildUp = MiscUtility.getWebElement(objFilepath, "OPR006_chkBx_buildUp");
        chkBx_manifested = MiscUtility.getWebElement(objFilepath, "OPR006_chkBx_manifested");
        chkBx_offloaded = MiscUtility.getWebElement(objFilepath, "OPR006_chkBx_offloaded");
        tbl_shipments = MiscUtility.getWebElement(objFilepath, "OPR006_tbl_shipments");
        tab_MsgTrans = MiscUtility.getWebElement(objFilepath, "OPR006_tab_MsgTrans");
        tab_uld = MiscUtility.getWebElement(objFilepath, "OPR006_tab_uld");
        tbl_msgTbl = MiscUtility.getWebElement(objFilepath, "OPR006_tbl_msgTbl");
        tbl_transTbl = MiscUtility.getWebElement(objFilepath, "OPR006_tbl_transTbl");
        tbl_uld = MiscUtility.getWebElement(objFilepath, "OPR006_tbl_uld");
        btn_resend = MiscUtility.getWebElement(objFilepath, "OPR006_btn_resend");
        btn_msgAddress = MiscUtility.getWebElement(objFilepath, "OPR006_btn_msgAddress");
        btn_addressOk = MiscUtility.getWebElement(objFilepath, "OPR006_btn_addressOk");
        btn_msgSend = MiscUtility.getWebElement(objFilepath, "OPR006_btn_msgSend");
        dropDown_msgInterface = MiscUtility.getWebElement(objFilepath, "OPR006_dropDown_msgInterface");
        dropDown_msgTransMission = MiscUtility.getWebElement(objFilepath, "OPR006_dropDown_msgTransMission");
        btn_view = MiscUtility.getWebElement(objFilepath, "OPR006_btn_view");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }


    /**
     * Verify the AWB details after coming from OPR007 screen
     *
     * @param awbNo
     * @param pcs
     * @param wt
     * @param status
     * @return
     */
    public OPR006 verifyAWBDetails(String awbNo, String pcs, String wt, String status) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);

        switch (status.toUpperCase()) {

            case "PLANNED":
                check(chkBx_planned);
                break;
            case "BUILD UP":
                check(chkBx_buildUp);
                break;
            case "MANIFESTED":
                check(chkBx_manifested);
                break;
            case "OFFLOADED":
                check(chkBx_offloaded);
                break;
        }

        click(btn_show);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_shipments, 2, awbNo), "The AWB " + awbNo + " is not present in the table.");


        switch (status.toUpperCase()) {

            case "PLANNED":
                Assert.assertTrue(tblGetTextByColValue(tbl_shipments, 5, 2, awbNo).trim().equals(pcs), "The pcs doesnt match the expected value");
                Assert.assertTrue(tblGetTextByColValue(tbl_shipments, 6, 2, awbNo).trim().equals(wt), "The wt doesnt match the expected value");
                break;
            case "BUILD UP":
                Assert.assertTrue(tblGetTextByColValue(tbl_shipments, 7, 2, awbNo).trim().equals(pcs), "The pcs doesnt match the expected value");
                Assert.assertTrue(tblGetTextByColValue(tbl_shipments, 8, 2, awbNo).trim().equals(wt), "The wt doesnt match the expected value");
                break;
            case "MANIFESTED":
                Assert.assertTrue(tblGetTextByColValue(tbl_shipments, 9, 2, awbNo).trim().equals(pcs), "The pcs doesnt match the expected value");
                Assert.assertTrue(tblGetTextByColValue(tbl_shipments, 10, 2, awbNo).trim().equals(wt), "The wt doesnt match the expected value");
                break;
            case "OFFLOADED":
                Assert.assertTrue(tblGetTextByColValue(tbl_shipments, 11, 2, awbNo).trim().equals(pcs), "The pcs doesnt match the expected value");
                Assert.assertTrue(tblGetTextByColValue(tbl_shipments, 12, 2, awbNo).trim().equals(wt), "The wt doesnt match the expected value");
                break;
        }

        return this;
    }


    /**
     * Verify the ULD details after coming from OPR007 screen
     *
     * @param uldNo
     * @param pou
     * @param wt
     * @param status
     * @return
     */
    public OPR006 verifyULDDetails(String uldNo, String pou, String wt, String status) {

        uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
        pou = PropertyHandler.getPropValue(dataFilePath, pou);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);

        switch (status.toUpperCase()) {

            case "PLANNED":
                check(chkBx_planned);
                break;
            case "BUILD UP":
                check(chkBx_buildUp);
                break;
            case "MANIFESTED":
                check(chkBx_manifested);
                break;
            case "OFFLOADED":
                check(chkBx_offloaded);
                break;
        }

        click(btn_show);

        click(tab_uld);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_uld, 2, uldNo), "The ULD " + uldNo + " is not present in the table.");
        Assert.assertTrue(tblGetTextByColValue(tbl_uld, 3, 2, uldNo).trim().equals(pou), "The POU doesnt match the expected value");
        Assert.assertTrue(tblGetTextByColValue(tbl_uld, 5, 2, uldNo).trim().equals(wt), "The weight doesnt match the expected value");

        switch (status.toUpperCase()) {

            case "PLANNED":
                Assert.assertTrue(tblchkBxEnabledByColValue(tbl_uld, 9, 2, uldNo), "The Planned checkbox is not checked");
                break;
            case "BUILD UP":
                Assert.assertTrue(tblchkBxEnabledByColValue(tbl_uld, 10, 2, uldNo), "The Build Up checkbox is not checked");
                break;
            case "MANIFESTED":
                Assert.assertTrue(tblchkBxEnabledByColValue(tbl_uld, 11, 2, uldNo), "The Manifested checkbox is not checked");
                break;
            case "OFFLOADED":
                Assert.assertTrue(tblchkBxEnabledByColValue(tbl_uld, 12, 2, uldNo), "The Offloaded checkbox is not checked");
                break;
        }

        return this;
    }

    /**
     * Verifies Messages and Transaction History
     *
     * @param fltDt
     * @return
     * @author Arun A-7681
     */
    public OPR006 verifyMsgAndTrans(String fltDt) {

        click(tab_MsgTrans);

        verifyValuePresentInTblColumn(tbl_msgTbl, 2, "FFM");
        verifyValuePresentInTblColumn(tbl_transTbl, 1, "Build Up");
        verifyValuePresentInTblColumn(tbl_transTbl, 1, "Load Plan");
        verifyValuePresentInTblColumn(tbl_transTbl, 1, "Manifest");
        verifyValuePresentInTblColumn(tbl_transTbl, 2, fltDt);
        return this;
    }

    /**
     * Resends FFM WIP
     *
     * @return
     * @author Arun A-7681
     */
    public OPR006 resendFFM() {

        click(tab_MsgTrans);
        tblSelectRowByColValue(tbl_msgTbl, 1, 2, "FFM");
        click(btn_resend);
        waitForNewWindow(2);
        switchToSecondWindow();

        selectByText(dropDown_msgInterface, "NACCS");
        selectByText(dropDown_msgTransMission, "MQ-SERIES");
        click(btn_msgAddress);
        waitForNewWindow(3);
        switchToNthWindow(3);

        click(btn_addressOk);
        waitForNewWindow(2);
        switchToSecondWindow();

        click(btn_msgSend);

        //TODO

        return this;
    }

    /**
     * Generates Export Flight Enquiry report
     * @return
     * @author Arun A-7681
     */
    public OPR006 generateReport() {

        click(btn_view);
        waitForNewWindow(2);
        switchToSecondWindow();
        closeAndmoveToFirstWindow();
        waitForNewWindow(1);

        waitForFrameAndSwitch("iCargoContentFrameOPR007");
        return this;
    }

    /**
     * closes the screen and goes back to home page
     *
     * @return
     * @author Arun A-7681
     */
    public OPR007 closeToOPR007() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        waitForFrameAndSwitch("iCargoContentFrameOPR007");
        return new OPR007(driver, dataFileName);
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
