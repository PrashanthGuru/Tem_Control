package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen CRA81
 * Created on 12/03/2018
 *
 * @author a-6784
 */
public class CRA181 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA181";
    public static String screenFrame = "iCargoContentFrameCRA181";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;
    private By
            Generic_btn_ok,
            yesBtn,
            txt_awbPrefix,
            txt_awbNum,
            btn_list, btn_btnDelete,
            chkbx_selectdata,
            btn_close, info_msg,
            tbl_exceptionDetails, btn_ChangeStatusAccept,
            btn_rejectionMemo,
            viewRejectionMemo_txt_wgtChargAccepted,
            viewRejectionMemo_btn_save, text_weightChargeBilled,
            viewRejectionMemo_txt_Remarks, txt_rejectionMemoNo,
            viewRejectionMemo_chkbx_reason, btn_ChangeStatus,
            viewRejectionMemo_btn_RejectionMemoLov,
            viewRejectionMemo_memonumLov_dropdown_Status,
            viewRejectionMemo_memonumLov_btn_list, btn_Reject,
            viewRejectionMemo_memonumLov_btn_OK,
            viewRejectionMemo_memonumLov_chkbx_selctmemo,
            viewRejectionMemo_btn_List, txt_remarks,
            viewRejectionMemo_txt_rejectionMemoNum,
            viewRejectionMemo_txt_rejectedAmount,
            viewRejectionMemo_btn_close,
            info_footerMsg,
            btn_grpAssign,
            txt_grpAssignAssignTo,
            btn_grpAssignAssign,
            btn_save,
            btn_clear,
            dropDown_excpStatus,
            txt_frmDt,
            txt_toDt,
            info_errMsg,
            info_title,
            btn_hold,
            dropDown_transStatus,
            btn_proration,
            btn_prorationClose,
            btn_reRoute,
            btn_Reprocess,
            btn_awbDtls,
            txt_awbDtlsPopUpAwbNo,
            txt_awbDtlsPopUpAgentCode,
            btn_awbDtlsPopUpClose;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");


    public CRA181(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }


    /**
     * Initializes the page objects required for the class
     */
    private void initElements() {

        txt_awbPrefix = MiscUtility.getWebElement(objFilepath, "CRA181_txt_awbPrefix");
        txt_awbNum = MiscUtility.getWebElement(objFilepath, "CRA181_txt_awbNum");
        txt_rejectionMemoNo = MiscUtility.getWebElement(objFilepath, "CRA181_txt_rejectionMemoNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "CRA181_btn_list");
        btn_btnDelete = MiscUtility.getWebElement(objFilepath, "CRA181_btn_btnDelete");
        text_weightChargeBilled = MiscUtility.getWebElement(objFilepath, "CRA181_text_weightChargeBilled");
        btn_close = MiscUtility.getWebElement(objFilepath, "CRA181_btn_close");
        tbl_exceptionDetails = MiscUtility.getWebElement(objFilepath, "CRA181_tbl_exceptionDetails");
        btn_rejectionMemo = MiscUtility.getWebElement(objFilepath, "CRA181_btn_rejectionMemo");
        viewRejectionMemo_txt_wgtChargAccepted = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_txt_wgtChargAccepted");
        viewRejectionMemo_btn_save = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_btn_save");
        viewRejectionMemo_txt_Remarks = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_txt_Remarks");
        viewRejectionMemo_chkbx_reason = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_chkbx_reason");
        viewRejectionMemo_btn_RejectionMemoLov = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_btn_RejectionMemoLov");
        viewRejectionMemo_memonumLov_dropdown_Status = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_memonumLov_dropdown_Status");
        viewRejectionMemo_memonumLov_btn_list = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_memonumLov_btn_list");
        viewRejectionMemo_memonumLov_btn_OK = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_memonumLov_btn_OK");
        viewRejectionMemo_memonumLov_chkbx_selctmemo = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_memonumLov_chkbx_selctmemo");
        viewRejectionMemo_btn_List = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_btn_List");
        viewRejectionMemo_txt_rejectionMemoNum = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_txt_rejectionMemoNum");
        viewRejectionMemo_txt_rejectedAmount = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_txt_rejectedAmount");
        viewRejectionMemo_btn_close = MiscUtility.getWebElement(objFilepath, "CRA181_viewRejectionMemo_btn_close");
        btn_ChangeStatus = MiscUtility.getWebElement(objFilepath, "CRA181_btn_ChangeStatus");
        btn_Reject = MiscUtility.getWebElement(objFilepath, "CRA181_btn_Reject");
        txt_remarks = MiscUtility.getWebElement(objFilepath, "CRA181_txt_remarks");
        btn_ChangeStatusAccept = MiscUtility.getWebElement(objFilepath, "CRA181_btn_ChangeStatusAccept");
        btn_grpAssign = MiscUtility.getWebElement(objFilepath, "CRA181_btn_grpAssign");
        txt_grpAssignAssignTo = MiscUtility.getWebElement(objFilepath, "CRA181_txt_grpAssignAssignTo");
        btn_grpAssignAssign = MiscUtility.getWebElement(objFilepath, "CRA181_btn_grpAssignAssign");
        btn_save = MiscUtility.getWebElement(objFilepath, "CRA181_btn_save");
        btn_clear = MiscUtility.getWebElement(objFilepath, "CRA181_btn_clear");
        dropDown_excpStatus = MiscUtility.getWebElement(objFilepath, "CRA181_dropDown_excpStatus");
        txt_frmDt = MiscUtility.getWebElement(objFilepath, "CRA181_txt_frmDt");
        txt_toDt = MiscUtility.getWebElement(objFilepath, "CRA181_txt_toDt");
        btn_hold = MiscUtility.getWebElement(objFilepath, "CRA181_btn_hold");
        dropDown_transStatus = MiscUtility.getWebElement(objFilepath, "CRA181_dropDown_transStatus");
        btn_proration = MiscUtility.getWebElement(objFilepath, "CRA181_btn_proration");
        btn_prorationClose = MiscUtility.getWebElement(objFilepath, "CRA181_btn_prorationClose");
        btn_reRoute = MiscUtility.getWebElement(objFilepath, "CRA181_btn_reRoute");
        btn_Reprocess = MiscUtility.getWebElement(objFilepath, "CRA181_btn_Reprocess");
        btn_awbDtls = MiscUtility.getWebElement(objFilepath, "CRA181_btn_awbDtls");
        txt_awbDtlsPopUpAwbNo = MiscUtility.getWebElement(objFilepath, "CRA181_txt_awbDtlsPopUpAwbNo");
        txt_awbDtlsPopUpAgentCode = MiscUtility.getWebElement(objFilepath, "CRA181_txt_awbDtlsPopUpAgentCode");
        btn_awbDtlsPopUpClose = MiscUtility.getWebElement(objFilepath, "CRA181_btn_awbDtlsPopUpClose");

        chkbx_selectdata = MiscUtility.getWebElement(objFilepath, "CRA181_chkbx_selectdata");
        Generic_btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        info_errMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        info_title = MiscUtility.getWebElement(genObjPath, "Generic_tabTitle");
    }

    /***
     *
     * @param awbPrefix
     * @param AWBNum
     * @return
     */
    public CRA181 listAndIssueRjectionMemo(String awbPrefix, String AWBNum, String MemoNumbr) {

        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        AWBNum = PropertyHandler.getPropValue(dataFilePath, AWBNum);

        enterKeys(txt_awbPrefix, awbPrefix);
        enterKeys(txt_awbNum, AWBNum);
        click(btn_list);
        minWait();


        check(chkbx_selectdata);
        click(btn_rejectionMemo);
        maxWait();
        String Wtchrg = waitForElement(text_weightChargeBilled).getAttribute("value").replace(",", "");


        float tmpWgtCharg = Float.parseFloat(Wtchrg);
        System.out.println(tmpWgtCharg);
        tmpWgtCharg = tmpWgtCharg - 500;


        String acceptedCharg = Float.toString(tmpWgtCharg);

        enterKeys(viewRejectionMemo_txt_wgtChargAccepted, acceptedCharg);
        scrollToView(viewRejectionMemo_chkbx_reason);
        check(viewRejectionMemo_chkbx_reason);
        enterKeys(viewRejectionMemo_txt_Remarks, "remarks");
        click(viewRejectionMemo_btn_save);
        maxWait();
        driver.switchTo().defaultContent();
        minWait();

        click(Generic_btn_ok);

        waitForFrameAndSwitch(FRAME);

        click(viewRejectionMemo_btn_RejectionMemoLov);
        //driver.switchTo().defaultContent();
        waitForNewWindow(2);

        switchToSecondWindow();

        selectByText(viewRejectionMemo_memonumLov_dropdown_Status, "Outward Billable");

        click(viewRejectionMemo_btn_List);
        minWait();
        check(viewRejectionMemo_memonumLov_chkbx_selctmemo);
        click(viewRejectionMemo_memonumLov_btn_OK);
        //	waitForFrameAndSwitch(FRAME);
        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        click(btn_list);

        String rejectedvalue = waitForElement(viewRejectionMemo_txt_rejectedAmount).getAttribute("value");
        Assert.assertTrue(rejectedvalue.equals("500"));
        String memonumbr = waitForElement(viewRejectionMemo_txt_rejectedAmount).getAttribute("value");
        PropertyHandler.setPropValue(dataFilePath, MemoNumbr, memonumbr);

        return this;
    }

    public CRA181 listAndIssueRjectionMemo_Resolved(String awbPrefix, String AWBNum, String MemoNumbr) {

        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        AWBNum = PropertyHandler.getPropValue(dataFilePath, AWBNum);

        enterKeys(txt_awbPrefix, awbPrefix);
        enterKeys(txt_awbNum, AWBNum);
        click(btn_list);
        minWait();


        check(chkbx_selectdata);
        click(btn_rejectionMemo);
        maxWait();
        String Wtchrg = waitForElement(text_weightChargeBilled).getAttribute("value").replace(",", "");
        enterKeys(viewRejectionMemo_txt_wgtChargAccepted, Wtchrg);
        scrollToView(viewRejectionMemo_chkbx_reason);
        check(viewRejectionMemo_chkbx_reason);
        enterKeys(viewRejectionMemo_txt_Remarks, "remarks");
        click(viewRejectionMemo_btn_save);
        maxWait();
        driver.switchTo().defaultContent();
        minWait();

        click(Generic_btn_ok);

        waitForFrameAndSwitch(FRAME);


        return this;
    }

    public CRA181 issueRejectionError(String awbPre, String awbNo, String error) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        error = PropertyHandler.getPropValue(dataFilePath, error);
        list(awbPre, awbNo);
        click(btn_rejectionMemo);
        minWait();
        String errMsg = waitForElement(info_errMsg).getText().trim();

        Assert.assertTrue(errMsg.toLowerCase().contains(error.toLowerCase()), "The error message displayed is : " + errMsg);
        return this;
    }

    /**
     * Verify navigation to CRA183 screen
     *
     * @param awbPre
     * @param awbNo
     * @return
     * @author a-7681
     */
    public CRA181 verifyNavigationToCRA183(String awbPre, String awbNo) {
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(awbPre, awbNo);
        tblSelectRowByColValue(tbl_exceptionDetails, 1, 6, awbNo);
        click(btn_rejectionMemo);
        minWait();
        String tabTitle = waitForElement(info_title).getText();
        Assert.assertTrue(tabTitle.contains("CRA183"), "The obtained window title is : " + tabTitle);

        click(viewRejectionMemo_btn_close);

        return this;
    }

    /**
     * Verify navigation to CRA048 screen
     *
     * @param awbPre
     * @param awbNo
     * @return
     * @author a-7681
     */
    public CRA181 verifyNavigationToCRA048(String awbPre, String awbNo) {
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(awbPre, awbNo);
        tblSelectRowByColValue(tbl_exceptionDetails, 1, 6, awbNo);
        click(btn_proration);
        minWait();
        String tabTitle = waitForElement(info_title).getText();
        Assert.assertTrue(tabTitle.contains("CRA048"), "The obtained window title is : " + tabTitle);

        click(btn_prorationClose);

        return this;
    }

    /**
     * Reprocess
     *
     * @param awbPre
     * @param awbNo
     * @return
     * @author a-7681
     */
    public CRA181 reProcess(String awbPre, String awbNo) {
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(awbPre, awbNo);
        tblSelectRowByColValue(tbl_exceptionDetails, 1, 6, awbNo);
        click(btn_Reprocess);
        minWait();

        return this;
    }

    /**
     * View AWB Details
     *
     * @param awbPre
     * @param awbNo
     * @return
     * @author a-7681
     */
    public CRA181 viewAWBDtls(String awbPre, String awbNo, String agentCode) {
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

        list(awbPre, awbNo);
        tblSelectRowByColValue(tbl_exceptionDetails, 1, 6, awbNo);
        click(btn_awbDtls);
        switchToSecondWindow();

        Assert.assertEquals(waitForElementVisible(txt_awbDtlsPopUpAwbNo).getText().trim(), awbNo, "The AWB Details doesn't show the AWB number as " + awbNo);
        scrollToView(txt_awbDtlsPopUpAgentCode);
        Assert.assertEquals(waitForElement(txt_awbDtlsPopUpAgentCode).getText().trim().toLowerCase(), agentCode.toLowerCase(), "The AWB Details doesn't show the agent details correctly for AWB No : " + awbNo);
        click(btn_awbDtlsPopUpClose);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    public CRA181 issueRjectionMemoResolved(String MemoNumbr) {

        check(chkbx_selectdata);
        click(btn_rejectionMemo);
        maxWait();
        String Wtchrg = waitForElement(text_weightChargeBilled).getAttribute("value").replace(",", "");
        enterKeys(viewRejectionMemo_txt_wgtChargAccepted, Wtchrg);
        scrollToView(viewRejectionMemo_chkbx_reason);
        check(viewRejectionMemo_chkbx_reason);
        enterKeys(viewRejectionMemo_txt_Remarks, "remarks");
        click(viewRejectionMemo_btn_save);
        maxWait();
        driver.switchTo().defaultContent();
        minWait();

        click(Generic_btn_ok);

        waitForFrameAndSwitch("iCargoContentFrameCRA180");

        return this;
    }

    public CRA181 DeleteIssueRjectionMemo(String MemoNumbr) {

        MemoNumbr = PropertyHandler.getPropValue(dataFilePath, MemoNumbr);


        enterKeys(txt_rejectionMemoNo, MemoNumbr);

        click(btn_list);
        minWait();
        click(btn_btnDelete);
        minWait();
        driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to Delete?"), "Error: Not able to delete the rejection memo");
        click(yesBtn);
        driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(info_msg).getText().contains("Rejection memo deleted successfully"), "Error: Not able to delete the rejection memo");
        click(Generic_btn_ok);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);


        return this;
    }

    public CRA181 Reject_Exception(String awbPrefix, String AWBNum) {

        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        AWBNum = PropertyHandler.getPropValue(dataFilePath, AWBNum);

        enterKeys(txt_awbPrefix, awbPrefix);
        enterKeys(txt_awbNum, AWBNum);
        click(btn_list);
        minWait();


        check(chkbx_selectdata);

        click(btn_ChangeStatus);
        click(btn_ChangeStatus);
        minWait();
        click(btn_Reject);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    public CRA181 holdException(String awbPrefix, String AWBNum) {

        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        AWBNum = PropertyHandler.getPropValue(dataFilePath, AWBNum);

        enterKeys(txt_awbPrefix, awbPrefix);
        enterKeys(txt_awbNum, AWBNum);
        click(btn_list);
        minWait();


        check(chkbx_selectdata);

        click(btn_ChangeStatus);
        click(btn_ChangeStatus);
        minWait();
        click(btn_hold);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    public CRA181 Accept_Exception(String awbPrefix, String AWBNum, String TrnStatus, String ExcpStatus) {

        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        AWBNum = PropertyHandler.getPropValue(dataFilePath, AWBNum);
        TrnStatus = PropertyHandler.getPropValue(dataFilePath, TrnStatus);
        ExcpStatus = PropertyHandler.getPropValue(dataFilePath, ExcpStatus);

        enterKeys(txt_awbPrefix, awbPrefix);
        enterKeys(txt_awbNum, AWBNum);
        click(btn_list);
        minWait();

        enterKeys(txt_remarks, "Accepting");
        check(chkbx_selectdata);

        click(btn_ChangeStatus);
        click(btn_ChangeStatus);
        minWait();
        click(btn_ChangeStatusAccept);
        minWait();

        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 18, 6, AWBNum).trim().toLowerCase(), TrnStatus.toLowerCase(), "The Transaction Status doesn't match for AWB No: " + AWBNum);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 19, 6, AWBNum).trim().toLowerCase(), ExcpStatus.toLowerCase(), "The Exception Status doesn't match for AWB No: " + AWBNum);

        return this;
    }

    public CRA181 acceptException(String awbPrefix, String AWBNum) {

        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        AWBNum = PropertyHandler.getPropValue(dataFilePath, AWBNum);

        enterKeys(txt_awbPrefix, awbPrefix);
        enterKeys(txt_awbNum, AWBNum);
        click(btn_list);
        minWait();

        enterKeys(txt_remarks, "Accepting");
        check(chkbx_selectdata);

        click(btn_ChangeStatus);
        click(btn_ChangeStatus);
        minWait();
        click(btn_ChangeStatusAccept);
        minWait();

        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 19, 6, AWBNum).trim().toLowerCase(), "resolved", "The Exception is not Accepted for AWB No: " + AWBNum);

        return this;
    }

    public CRA181 acceptExceptionWithoutListing(String invNo) {

        invNo = PropertyHandler.getPropValue(dataFilePath, invNo);

        enterKeys(txt_remarks, "Accepting");
        check(chkbx_selectdata);

        click(btn_ChangeStatus);
        click(btn_ChangeStatus);
        minWait();
        click(btn_ChangeStatusAccept);
        minWait();

        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 19, 10, invNo).trim().toLowerCase(), "resolved", "The Exception is not Accepted for Invoice No: " + invNo);

        return this;
    }

    /**
     * Verifies if exception is present for the invoice number
     *
     * @param invNo
     * @return
     * @author A-7681
     */
    public CRA181 verifyExceptionPresentNoListing(String invNo) {
        invNo = PropertyHandler.getPropValue(dataFilePath, invNo);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_exceptionDetails, 10, invNo), "The Exception is not present for Invoice number: " + invNo);

        return this;
    }

    /**
     * Closes to CRA179
     *
     * @return
     * @author A-7681
     */
    public CRA179 closeToCRA179() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch("iCargoContentFrameCRA179");
        return new CRA179(driver, dataFileName);
    }

    /**
     * Verifies exception details present
     *
     * @param awbPre
     * @param awbNo
     * @param invNo
     * @param clearancePeriod
     * @param airlineCode
     * @param expType
     * @param awbDt
     * @param origin
     * @param dest
     * @param expStatus:      not read from data sheet
     * @param assignedTo
     * @return
     * @author A-7681
     */
    public CRA181 verifyExceptionDtlsPresent(String awbPre, String awbNo, String invNo, String clearancePeriod, String airlineCode, String expType, String awbDt, String origin, String dest, String expStatus, String assignedTo) {


        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        invNo = PropertyHandler.getPropValue(dataFilePath, invNo);
        expType = PropertyHandler.getPropValue(dataFilePath, expType);
        airlineCode = PropertyHandler.getPropValue(dataFilePath, airlineCode);
        awbDt = PropertyHandler.getPropValue(dataFilePath, awbDt);
        origin = PropertyHandler.getPropValue(dataFilePath, origin);
        dest = PropertyHandler.getPropValue(dataFilePath, dest);
        assignedTo = PropertyHandler.getPropValue(dataFilePath, assignedTo);

        list(awbPre, awbNo);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_exceptionDetails, 10, invNo), "The Exception is not present for Invoice number: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 2, 10, invNo).trim(), clearancePeriod, "The clearence period doesn't match for Invoice No: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 3, 10, invNo).trim().toUpperCase(), airlineCode.toUpperCase(), "The Airline Code doesn't match for Invoice No: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 4, 10, invNo).trim().toLowerCase(), expType.toLowerCase(), "The Exception type period doesn't match for Invoice No: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 6, 10, invNo).trim(), awbPre + " - " + awbNo, "The AWB No doesn't match for Invoice No: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 7, 10, invNo).trim().toUpperCase(), awbDt.toUpperCase(), "The AWB Date doesn't match for Invoice No: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 8, 10, invNo).trim().toUpperCase(), origin.toUpperCase(), "The AWB Origin doesn't match for Invoice No: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 9, 10, invNo).trim().toUpperCase(), dest.toUpperCase(), "The AWB Destination doesn't match for Invoice No: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 18, 10, invNo).trim().toUpperCase(), "EXCEPTION", "The Transaction Status doesn't match for Invoice No: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 19, 10, invNo).trim().toLowerCase(), expStatus.toLowerCase(), "The Exception status period doesn't match for Invoice No: " + invNo);
        Assert.assertEquals(tblGetTextByColValue_input(tbl_exceptionDetails, 20, 10, invNo).trim().toUpperCase(), assignedTo.toUpperCase(), "The Assigned user doesn't match for Invoice Number: " + invNo);
        Assert.assertEquals(tblGetTextByColValue_input(tbl_exceptionDetails, 21, 10, invNo).trim().toUpperCase(), awbDt.toUpperCase(), "The Assigned Date doesn't match for Invoice Number: " + invNo);

        return this;
    }

    public CRA181 clearAndVerify(String awbPre, String awbNo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(awbPre, awbNo);

        clear();

        Assert.assertEquals(waitForElementVisible(txt_awbNum).getText().trim(), "", "The form is not cleared.");
        return this;
    }

    private void list(String awbPre, String awbNo, String... excpStatus) {
        enterKeys(txt_awbPrefix, awbPre);
        enterKeys(txt_awbNum, awbNo);
        if (excpStatus.length != 0) {
            selectByText(dropDown_excpStatus, excpStatus[0]);
        }
        click(btn_list);
        minWait();
    }

    public CRA181 listInvalidValue() {

        enterKeys(txt_frmDt, ".");
        enterKeys(txt_toDt, ".");
        click(btn_list);
        minWait();

        Assert.assertEquals(waitForElement(info_errMsg).getText().trim().toLowerCase(), "please enter the From Date less than To Date".toLowerCase(), "The error message doesn't match.");


        return this;
    }


    public CRA181 verifyExceptionNotPresent(String awbPre, String awbNo, String invNo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        invNo = PropertyHandler.getPropValue(dataFilePath, invNo);

        list(awbPre, awbNo);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_exceptionDetails, 10, invNo), "The Exception is not present for Invoice number: " + invNo);

        return this;
    }

    /**
     * Assigns the exception to a group
     * @param awbPre
     * @param awbNo
     * @param invNo
     * @param excpAssignTo
     * @return
     * @author a-7681
     */
    public CRA181 assignToGroup(String awbPre, String awbNo, String invNo, String excpAssignTo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        invNo = PropertyHandler.getPropValue(dataFilePath, invNo);
        excpAssignTo = PropertyHandler.getPropValue(dataFilePath, excpAssignTo);

        list(awbPre, awbNo);

        tblSelectRowByColValue(tbl_exceptionDetails, 1, 10, invNo);

        click(btn_grpAssign);

        switchToSecondWindow();
        enterKeys(txt_grpAssignAssignTo, excpAssignTo);
        click(btn_grpAssignAssign);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_save);

        Assert.assertEquals(waitForElement(info_footerMsg).getText().trim().toLowerCase(), "Data Saved Successfully".toLowerCase(), "The Exception details is not saved.");

        return this;
    }

    /**
     * verifies error on clicking group assign button
     * @param awbPre
     * @param awbNo
     * @param error
     * @return
     * @author a-7681
     */
    public CRA181 groupAssignError(String awbPre, String awbNo, String error) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        error = PropertyHandler.getPropValue(dataFilePath, error);

        String transStatus = "--Select--";
        String excpStatus = "--Select--";

        enterKeys(txt_awbPrefix, awbPre);
        enterKeys(txt_awbNum, awbNo);
        selectByText(dropDown_transStatus, transStatus);
        selectByText(dropDown_excpStatus, excpStatus);
        click(btn_list);
        minWait();

        tblSelectRowByColValue(tbl_exceptionDetails, 1, 6, awbNo);

        click(btn_grpAssign);

        Assert.assertEquals(waitForElement(info_errMsg).getText().trim().toLowerCase(), error.toLowerCase(), "The error message on group assign is not as expected for AWB No: " + awbNo);

        return this;
    }

    public CRA181 assignToGroupWithOutListing(String invNo, String excpAssignTo) {

        excpAssignTo = PropertyHandler.getPropValue(dataFilePath, excpAssignTo);

        tblSelectRowByColValue(tbl_exceptionDetails, 1, 10, invNo);

        click(btn_grpAssign);

        switchToSecondWindow();
        enterKeys(txt_grpAssignAssignTo, excpAssignTo);
        click(btn_grpAssignAssign);

        switchToFirstWindow();
        waitForFrameAndSwitch("iCargoContentFrameCRA180");
        click(btn_save);

        Assert.assertEquals(waitForElement(info_footerMsg).getText().trim().toLowerCase(), "Data Saved Successfully".toLowerCase(), "The Exception details is not saved.");

        return this;
    }

    public CRA181 verifyExceptionStatusWithAssignedTo(String awbPre, String awbNo, String invNo, String excpAssignTo, String status) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        invNo = PropertyHandler.getPropValue(dataFilePath, invNo);
        excpAssignTo = PropertyHandler.getPropValue(dataFilePath, excpAssignTo);

        list(awbPre, awbNo, status);

        Assert.assertEquals(tblGetTextByColValue_input(tbl_exceptionDetails, 20, 10, invNo).trim().toUpperCase(), excpAssignTo.toUpperCase(), "The Assigned user doesn't match for Invoice Number: " + invNo);

        return this;
    }

    public CRA181 verifyExceptionType(String awbPre, String awbNo, String invNo, String excpType) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        invNo = PropertyHandler.getPropValue(dataFilePath, invNo);
        excpType = PropertyHandler.getPropValue(dataFilePath, excpType);

        list(awbPre, awbNo);

        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 4, 10, invNo).trim().toLowerCase(), excpType.toLowerCase(), "The Exception Type doesn't match for Invoice number: " + invNo);

        return this;
    }

    public CRA181 clear() {

        click(btn_clear);
        minWait();

        return this;
    }

    /**
     * Verifies the charge
     *
     * @param awbPre
     * @param awbNo
     * @param wtCharge
     * @param diff:    not read from data sheet
     * @return
     * @author A-7681
     */
    public CRA181 verifyCharges(String awbPre, String awbNo, String wtCharge, Object diff) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        wtCharge = PropertyHandler.getPropValue(dataFilePath, wtCharge);
        if (diff instanceof String) {
            diff = Integer.parseInt(PropertyHandler.getPropValue(dataFilePath, (String) diff));
        }

        list(awbPre, awbNo);

        String billedValue = tblGetTextByColValue(tbl_exceptionDetails, 12, 6, awbNo).trim();
        String billedValueBase = tblGetTextByColValue(tbl_exceptionDetails, 13, 6, awbNo).trim();
        String ourValue = tblGetTextByColValue(tbl_exceptionDetails, 14, 6, awbNo).trim();
        String ourValueBase = tblGetTextByColValue(tbl_exceptionDetails, 15, 6, awbNo).trim();
        String diffValue = tblGetTextByColValue(tbl_exceptionDetails, 16, 6, awbNo).trim();
        String diffValueBase = tblGetTextByColValue(tbl_exceptionDetails, 17, 6, awbNo).trim();

        Assert.assertEquals(billedValue, wtCharge, "The billed value doesn't match for AWB No: " + awbNo);
        Assert.assertEquals(billedValueBase, wtCharge, "The billed base value doesn't match for AWB No: " + awbNo);
        Assert.assertEquals(ourValue, String.valueOf(Integer.parseInt(wtCharge) - (int) diff), "The Our value doesn't match for AWB No: " + awbNo);
        Assert.assertEquals(ourValueBase, String.valueOf(Integer.parseInt(wtCharge) - (int) diff), "The Our base value doesn't match for AWB No: " + awbNo);
        Assert.assertEquals(diffValue, String.valueOf(diff), "The difference value doesn't match for AWB No: " + awbNo);
        Assert.assertEquals(diffValueBase, String.valueOf(diff), "The difference base value doesn't match for AWB No: " + awbNo);

        return this;
    }

    public CRA180 closeToCRA180() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch("iCargoContentFrameCRA180");
        return new CRA180(driver, dataFileName);
    }

    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }


    /**
     * list and verfiy AWB present based on the transaction and exception status
     *
     * @param awbPre
     * @param awbNo
     * @param transStatus: give vacant string for default
     * @param excpStatus:  give vacant string for default
     * @return
     * @author a-7681
     */
    public CRA181 listAndVerify(String awbPre, String awbNo, String transStatus, String excpStatus) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        if (!transStatus.equals("")) {
            transStatus = PropertyHandler.getPropValue(dataFilePath, transStatus);
        } else {
            transStatus = "--Select--";
        }
        if (!excpStatus.equals("")) {
            excpStatus = PropertyHandler.getPropValue(dataFilePath, excpStatus);
        } else {
            excpStatus = "--Select--";
        }

        enterKeys(txt_awbPrefix, awbPre);
        enterKeys(txt_awbNum, awbNo);
        selectByText(dropDown_transStatus, transStatus);
        selectByText(dropDown_excpStatus, excpStatus);
        click(btn_list);
        minWait();

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_exceptionDetails, 6, awbNo), "The AWB No : " + awbNo + " is not present in the table.");

        return this;
    }

    /**
     * Verify error on changing status
     *
     * @param awbPre
     * @param awbNo
     * @param error
     * @return
     * @author a-7681
     */
    public CRA181 changeStatusError(String awbPre, String awbNo, String error) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        error = PropertyHandler.getPropValue(dataFilePath, error);
        String transStatus = "--Select--";
        String excpStatus = "--Select--";

        enterKeys(txt_awbPrefix, awbPre);
        enterKeys(txt_awbNum, awbNo);
        selectByText(dropDown_transStatus, transStatus);
        selectByText(dropDown_excpStatus, excpStatus);
        click(btn_list);
        minWait();

        enterKeys(txt_remarks, "Accepting");
        tblSelectRowByColValue(tbl_exceptionDetails,1,6,awbNo);

        click(btn_ChangeStatus);
        click(btn_ChangeStatus);
        minWait();
        click(btn_ChangeStatusAccept);
        minWait();

        driver.switchTo().defaultContent();

        Assert.assertEquals(waitForElement(info_msg).getText().trim().toLowerCase(),error.toLowerCase(), "The error message on change status doesn't match for AWB No: " + awbNo);

        return this;
    }

    public CRA079 navigateToCRA079(String awbPre, String awbNo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(awbPre, awbNo);
        tblSelectRowByColValue(tbl_exceptionDetails, 1, 6, awbNo);
        click(btn_reRoute);

        return new CRA079(driver, dataFilePath);
    }
}
