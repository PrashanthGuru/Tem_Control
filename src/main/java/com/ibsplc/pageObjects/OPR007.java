package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/1/2018.
 */
public class OPR007 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameOPR007";
    private WebDriver driver;
    private String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    private By txt_fromDt,
            txt_toDt,
            btn_list,
            tbl_fltListing,
            link_next,
            btn_close,
            txt_carrCode,
            txt_fltNo,
            chkBx_checkAll,
            btn_flightEnquiry,
            dropDown_loadPlan,
            dropDown_BuildUp,
            dropDown_manifest,
            dropDown_finalise,
            dropDown_dws,
            dropDown_offload;
    private By btn_genericYes;

    public OPR007(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        iniElements();
    }

    private void iniElements() {

        txt_fromDt = MiscUtility.getWebElement(objFilepath, "OPR007_txt_fromDt");
        txt_toDt = MiscUtility.getWebElement(objFilepath, "OPR007_txt_toDt");
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR007_btn_list");
        tbl_fltListing = MiscUtility.getWebElement(objFilepath, "OPR007_tbl_fltListing");
        link_next = MiscUtility.getWebElement(objFilepath, "OPR007_link_next");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR007_btn_close");
        txt_carrCode = MiscUtility.getWebElement(objFilepath, "OPR007_txt_carrCode");
        txt_fltNo = MiscUtility.getWebElement(objFilepath, "OPR007_txt_fltNo");
        chkBx_checkAll = MiscUtility.getWebElement(objFilepath, "OPR007_chkBx_checkAll");
        btn_flightEnquiry = MiscUtility.getWebElement(objFilepath, "OPR007_btn_flightEnquiry");
        dropDown_loadPlan = MiscUtility.getWebElement(objFilepath, "OPR007_dropDown_loadPlan");
        dropDown_BuildUp = MiscUtility.getWebElement(objFilepath, "OPR007_dropDown_BuildUp");
        dropDown_manifest = MiscUtility.getWebElement(objFilepath, "OPR007_dropDown_manifest");
        dropDown_finalise = MiscUtility.getWebElement(objFilepath, "OPR007_dropDown_finalise");
        dropDown_dws = MiscUtility.getWebElement(objFilepath, "OPR007_dropDown_dws");
        dropDown_offload = MiscUtility.getWebElement(objFilepath, "OPR007_dropDown_offload");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    /**
     * lists the flight between the date range
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @return
     */
    public OPR007 verifyFlightBylistWithDates(String carrCode, String fltNo, String fltDt) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        boolean flag = false;

        enterKeys(txt_fromDt, "-1");
        enterKeys(txt_toDt, fltDt);
        click(btn_list);

        while (true) {
            if (getTableColumnValues(tbl_fltListing, 2).contains(carrCode + " " + fltNo)) {
                flag = true;
                break;
            }

            try {
                click(link_next);
            } catch (NoSuchElementException | TimeoutException e1) {
                break;
            }
        }

        Assert.assertTrue(flag, "The flight number " + fltNo + " is not listed in the export flight listing.");

        return this;
    }

    /**
     * lists the flights between the date range and filters applied
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param filters
     * @param filterValue
     * @return
     */
    public OPR007 verifyFlightBylistWithFilters(String carrCode, String fltNo, String fltDt, String filters, String filterValue) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        boolean flag = false;

        enterKeys(txt_fromDt, "-1");
        enterKeys(txt_toDt, fltDt);

        switch (filters.toUpperCase()) {
            case "LOAD PLAN":
                selectByText(dropDown_loadPlan, filterValue);
                break;
            case "BUILD UP":
                selectByText(dropDown_BuildUp, filterValue);
                break;
            case "MANIFEST":
                selectByText(dropDown_manifest, filterValue);
                break;
            case "FINALISE":
                selectByText(dropDown_finalise, filterValue);
                break;
            case "DWS":
                selectByText(dropDown_dws, filterValue);
                break;
            case "OFFLOAD":
                selectByText(dropDown_offload, filterValue);
                break;
        }


        click(btn_list);

        while (true) {
            if (getTableColumnValues(tbl_fltListing, 2).contains(carrCode + " " + fltNo)) {
                flag = true;
                break;
            }

            try {
                click(link_next);
            } catch (NoSuchElementException | TimeoutException e1) {
                break;
            }
        }

        Assert.assertTrue(flag, "The flight number " + fltNo + " is not listed in the export flight listing.");

        return this;
    }

    public OPR006 navigateToFlightEnquiry(String carrCode, String fltNo, String fltDt) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

        list(carrCode, fltNo, fltDt);

        check(chkBx_checkAll);
        click(btn_flightEnquiry);


        return new OPR006(driver, dataFileName);
    }

    /**
     * Lists with flight
     *
     * @param carrCode
     * @param fltNo
     * @author Arun A-7681
     */
    private void list(String carrCode, String fltNo, String fltDt) {
        enterKeys(txt_carrCode, carrCode);
        enterKeys(txt_fltNo, fltNo);
        enterKeys(txt_fromDt, fltDt);
        enterKeys(txt_toDt, fltDt);

        click(btn_list);
    }

    /**
     * Checks the manifest status of the flight
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param status
     * @return
     * @author Arun A-7681
     */
    public OPR007 checkManifestStatus(String carrCode, String fltNo, String fltDt, String status) {
        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

        list(carrCode, fltNo, fltDt);

        Assert.assertTrue(tblGetTextByColValue(tbl_fltListing, 9, 2, fltNo).trim().equalsIgnoreCase(status), "The status doesn't match the value of: " + status);
        return this;
    }


    /**
     * Checks offload status of the flight
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param status
     * @return
     * @author Arun A-7681
     */
    public OPR007 checkOffloadStatus(String carrCode, String fltNo, String fltDt, String status) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

        list(carrCode, fltNo, fltDt);

        if (status.equalsIgnoreCase("offloaded")) {
            Assert.assertTrue(tblchkBxEnabledByColValue(tbl_fltListing, 12, 2, fltNo), "The shipment is not offloaded");
        } else {
            Assert.assertFalse(tblchkBxEnabledByColValue(tbl_fltListing, 12, 2, fltNo), "The shipment is offloaded");
        }
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
