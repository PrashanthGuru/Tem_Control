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
 * Created by A-7681 on 2/5/2018.
 */
public class TRC009 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameTRC009";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            dropDown_queue,
            txt_awbPre,
            txt_awbNo,
            btn_list,
            tbl_tracingLabled,
            btn_clear,
            link_next,
            txt_fromDt,
            txt_toDate,
            dropDown_status,
            dropDown_code,
            btn_TracingDtls;

    private By btn_genericYes,
            info_footerMsg,
            info_genericMsg,
            btn_genericOk;

    public TRC009(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "TRC009_btn_close");
        btn_clear = MiscUtility.getWebElement(objFilepath, "TRC009_btn_clear");
        dropDown_queue = MiscUtility.getWebElement(objFilepath, "TRC009_dropDown_queue");
        txt_awbPre = MiscUtility.getWebElement(objFilepath, "TRC009_txt_awbPre");
        txt_awbNo = MiscUtility.getWebElement(objFilepath, "TRC009_txt_awbNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "TRC009_btn_list");
        tbl_tracingLabled = MiscUtility.getWebElement(objFilepath, "TRC009_tbl_tracingLabled");
        link_next = MiscUtility.getWebElement(objFilepath, "TRC009_link_next");
        txt_fromDt = MiscUtility.getWebElement(objFilepath, "TRC009_txt_fromDt");
        txt_toDate = MiscUtility.getWebElement(objFilepath, "TRC009_txt_toDate");
        dropDown_status = MiscUtility.getWebElement(objFilepath, "TRC009_dropDown_status");
        dropDown_code = MiscUtility.getWebElement(objFilepath, "TRC009_dropDown_code");
        btn_TracingDtls = MiscUtility.getWebElement(objFilepath, "TRC009_btn_TracingDtls");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    }

    /**
     * Verifies the tracing queue for a given awb
     *
     * @param queue: not read from data sheet
     * @param awbPre
     * @param awbNo
     * @return
     * @author a-7681
     */
    public TRC009 verifyTracingQueueListWithAWB(String queue, String awbPre, String awbNo) {


        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        selectByText(dropDown_queue, "ALL");
        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();

        Assert.assertEquals(tblGetTextByColValue(tbl_tracingLabled, 12, 2, awbNo).trim(), queue, "The Tracing queue details doesn't match for AWB No: " + awbNo);
        return this;
    }

    /**
     * Verifies the tracing status for a given awb
     *
     * @param status
     * @param awbPre
     * @param awbNo
     * @return
     * @author a-7681
     */
    public TRC009 verifyTracingStatusListWithAWB(String status, String awbPre, String awbNo) {

        status = PropertyHandler.getPropValue(dataFilePath, status);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        selectByText(dropDown_queue, "ALL");
        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();

        Assert.assertEquals(tblGetTextByColValue(tbl_tracingLabled, 12, 2, awbNo).trim().toUpperCase(), status.toUpperCase(), "The Tracing status details doesn't match for AWB No: " + awbNo);
        return this;
    }

    /**
     * Verifies if awb tracing is listed
     *
     * @param awbPre
     * @param awbNo
     * @return
     * @author a-7681
     */
    public TRC009 verifyAWBPresentListingWithAWB(String awbPre, String awbNo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        selectByText(dropDown_queue, "ALL");
        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_tracingLabled, 2, awbNo), "The Tracing details is not present for AWB No: " + awbNo);
        return this;
    }

    /**
     * Verifies if awb tracing is listed
     *
     * @param awbNo
     * @param filter: not read from datasheet
     * @return
     * @author a-7681
     */
    public TRC009 verifyAWBPresentListingWithTCQueue(String awbNo, String filter) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        boolean flag = false;
        selectByText(dropDown_queue, filter);
        enterKeys(txt_fromDt, "-3");
        enterKeys(txt_toDate, ".");
        click(btn_list);
        minWait();

        while (true) {
            if (verifyValuePresentInTblColumn(tbl_tracingLabled, 2, awbNo)) {
                flag = true;
                break;
            }

            try {
                click(link_next);
            } catch (NoSuchElementException | TimeoutException e1) {
                break;
            }
        }

        Assert.assertTrue(flag, "The Tracing details is not present for AWB No: " + awbNo);
        return this;
    }

    /**
     * Verifies if awb tracing is listed
     *
     * @param awbNo
     * @param filter: not read from datasheet
     * @return
     * @author a-7681
     */
    public TRC009 verifyAWBPresentListingWithTCStatus(String awbNo, String filter) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        boolean flag = false;
        selectByText(dropDown_queue, "ALL");
        selectByText(dropDown_status, filter);
        enterKeys(txt_fromDt, "-3");
        enterKeys(txt_toDate, ".");
        click(btn_list);
        minWait();

        while (true) {
            if (verifyValuePresentInTblColumn(tbl_tracingLabled, 2, awbNo)) {
                flag = true;
                break;
            }

            try {
                click(link_next);
            } catch (NoSuchElementException | TimeoutException e1) {
                break;
            }
        }

        Assert.assertTrue(flag, "The Tracing details is not present for AWB No: " + awbNo);
        return this;
    }

    /**
     * Verifies if awb tracing is listed base of Discp Code
     *
     * @param awbNo
     * @param filter: not read from datasheet
     * @return
     * @author a-7681
     */
    public TRC009 verifyAWBPresentListingWithTCCode(String awbNo, String filter) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        boolean flag = false;
        selectByText(dropDown_queue, "ALL");
        selectByText(dropDown_code, filter);
        enterKeys(txt_fromDt, "-1");
        enterKeys(txt_toDate, ".");
        click(btn_list);
        minWait();

        while (true) {
            if (verifyValuePresentInTblColumn(tbl_tracingLabled, 2, awbNo)) {
                flag = true;
                break;
            }

            try {
                click(link_next);
            } catch (NoSuchElementException | TimeoutException e1) {
                break;
            }
        }

        Assert.assertTrue(flag, "The Tracing details is not present for AWB No: " + awbNo);
        return this;
    }


    public OPR024 navigateToOPR024(String awbPre, String awbNo){

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        selectByText(dropDown_queue, "ALL");
        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();

        tblSelectRowByColValue(tbl_tracingLabled,1,2,awbNo);

        click(btn_TracingDtls);


        return new OPR024(driver,dataFileName);
    }


    /**
     * clears the form
     * @return
     */
    public TRC009 clear() {

        click(btn_clear);
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
