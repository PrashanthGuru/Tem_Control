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
 * Created by A-7681 on 1/31/2018.
 */
public class OPR010 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameOPR010";
    private WebDriver driver;
    private String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    private By txt_fromDate,
            txt_toDate,
            tbl_shipment,
            tbl_uld,
            tab_uld,
            txt_awbPre,
            txt_awbNo,
            txt_uldNo,
            btn_printAWB,
            btn_printULD,
            btn_list,
            btn_close,
            btn_clear,
            link_sortElapsedTime,
            link_next;

    private By btn_genericYes;


    public OPR010(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        txt_fromDate = MiscUtility.getWebElement(objFilepath, "OPR010_txt_fromDate");
        txt_toDate = MiscUtility.getWebElement(objFilepath, "OPR010_txt_toDate");
        tbl_shipment = MiscUtility.getWebElement(objFilepath, "OPR010_tbl_shipment");
        tbl_uld = MiscUtility.getWebElement(objFilepath, "OPR010_tbl_uld");
        tab_uld = MiscUtility.getWebElement(objFilepath, "OPR010_tab_uld");
        txt_awbPre = MiscUtility.getWebElement(objFilepath, "OPR010_txt_awbPre");
        txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR010_txt_awbNo");
        txt_uldNo = MiscUtility.getWebElement(objFilepath, "OPR010_txt_uldNo");
        btn_printAWB = MiscUtility.getWebElement(objFilepath, "OPR010_btn_printAWB");
        btn_printULD = MiscUtility.getWebElement(objFilepath, "OPR010_btn_printULD");
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR010_btn_list");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR010_btn_close");
        btn_clear = MiscUtility.getWebElement(objFilepath, "OPR010_btn_clear");
        link_sortElapsedTime = MiscUtility.getWebElement(objFilepath, "OPR010_link_sortElapsedTime");
        link_next = MiscUtility.getWebElement(objFilepath, "OPR010_link_next");


        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    public OPR010 verifyAWBandULDwithDateFilters(String awbNo, String uldNo, String awbPcs, String awbWt, String awbOrigin, String awbDest, String uldPcs, String uldWt) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
        awbPcs = PropertyHandler.getPropValue(dataFilePath, awbPcs);
        awbWt = PropertyHandler.getPropValue(dataFilePath, awbWt);
        awbOrigin = PropertyHandler.getPropValue(dataFilePath, awbOrigin);
        awbDest = PropertyHandler.getPropValue(dataFilePath, awbDest);
        uldPcs = PropertyHandler.getPropValue(dataFilePath, uldPcs);
        uldWt = PropertyHandler.getPropValue(dataFilePath, uldWt);

        boolean flag = false;
        enterKeys(txt_fromDate, "-1");
        enterKeys(txt_toDate, ".");

        click(btn_list);
        minWait();
//        click(link_sortElapsedTime);

        while (true) {
            if (verifyValuePresentInTblColumn(tbl_shipment, 2,awbNo)) {
                flag = true;
                break;
            }
            try {
                click(link_next);
            } catch (NoSuchElementException | TimeoutException e1) {
                break;
            }
        }
        Assert.assertTrue(flag, "The awb No " + awbNo + " is not present in the lying list");
        verifyAWBDetails(awbNo, awbPcs, awbWt, awbOrigin, awbDest);

        click(tab_uld);

        flag = false;
        while (true) {
            if (verifyValuePresentInTblColumn(tbl_uld, 3,uldNo)) {
                flag = true;
                break;
            }
            try {
                click(link_next);
            } catch (NoSuchElementException | TimeoutException e1) {
                break;
            }
        }

        Assert.assertTrue(flag, "The ULD No " + uldNo + " is not present in the lying list");
        verifyULDDetails(uldNo, uldPcs, uldWt);

        return this;
    }

    private void verifyULDDetails(String uldNo, String uldPcs, String uldWt) {

        Assert.assertTrue(tblGetTextByColValue(tbl_uld, 6, 3, uldNo).trim().equals(uldPcs));
        Assert.assertTrue(tblGetTextByColValue(tbl_uld, 7, 3, uldNo).trim().equals(uldWt));

    }

    private void verifyAWBDetails(String awbNo, String awbPcs, String awbWt, String awbOrigin, String awbDest) {

        Assert.assertTrue(tblGetTextByColValue(tbl_shipment, 4, 2, awbNo).trim().equals(awbPcs));
        Assert.assertTrue(tblGetTextByColValue(tbl_shipment, 5, 2, awbNo).trim().equals(awbWt));
        Assert.assertTrue(tblGetTextByColValue(tbl_shipment, 7, 2, awbNo).trim().equals(awbOrigin));
        Assert.assertTrue(tblGetTextByColValue(tbl_shipment, 8, 2, awbNo).trim().equals(awbDest));
    }

    public OPR010 verifyAWBpresent(String awbPre, String awbNo, String awbPcs, String awbWt, String awbOrigin, String awbDest) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        awbPcs = PropertyHandler.getPropValue(dataFilePath, awbPcs);
        awbWt = PropertyHandler.getPropValue(dataFilePath, awbWt);
        awbOrigin = PropertyHandler.getPropValue(dataFilePath, awbOrigin);
        awbDest = PropertyHandler.getPropValue(dataFilePath, awbDest);

        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);

        click(btn_list);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_shipment, 2,awbNo), "The awb No " + awbNo + " is not present in the lying list");
        verifyAWBDetails(awbNo, awbPcs, awbWt, awbOrigin, awbDest);

        return this;
    }

    public OPR010 verifyULD(String uldNo, String uldPcs, String uldWt) {

        uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
        uldPcs = PropertyHandler.getPropValue(dataFilePath, uldPcs);
        uldWt = PropertyHandler.getPropValue(dataFilePath, uldWt);

        enterKeys(txt_uldNo, uldNo);
        click(btn_list);
        click(tab_uld);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_uld, 3,uldNo), "The ULD No " + uldNo + " is not present in the lying list");
        verifyULDDetails(uldNo, uldPcs, uldWt);

        return this;
    }

    public OPR010 printAWB(String awbPre, String awbNo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);

        tblSelectRowByColValue(tbl_shipment, 1, 2, awbNo);
        click(btn_printAWB);

        waitForNewWindow(2);
        switchToSecondWindow();

        closeAndmoveToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    public OPR010 printULD(String uldNo) {

        uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);

        enterKeys(txt_uldNo, uldNo);
        click(btn_list);

        click(tab_uld);

        tblSelectRowByColValue(tbl_uld, 1, 3, uldNo);
        click(btn_printULD);

        waitForNewWindow(2);
        switchToSecondWindow();

        closeAndmoveToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    public OPR010 clear(){

        click(btn_clear);
        return this;
    }

    /**
     * closes the screen and goes back to home page
     *
     * @return
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
