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
public class CRA180 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA180";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;
    private By btn_close,
            txt_clPeriodFrom,
            txt_clPeriodTo,
            txt_invNo,
            txt_airlineCode,
            tbl_exceptionDetails,
            btn_list,
            btn_viewDtls;

    private By btn_genericOk,
            btn_genericYes,
            info_genericMsg,
            info_footerMsg;


    public CRA180(WebDriver driver, String dataFileName) {
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

        btn_close = MiscUtility.getWebElement(objFilepath, "CRA108_btn_close");
        txt_clPeriodFrom = MiscUtility.getWebElement(objFilepath, "CRA108_txt_clPeriodFrom");
        txt_clPeriodTo = MiscUtility.getWebElement(objFilepath, "CRA108_txt_clPeriodTo");
        txt_invNo = MiscUtility.getWebElement(objFilepath, "CRA108_txt_invNo");
        txt_airlineCode = MiscUtility.getWebElement(objFilepath, "CRA108_txt_airlineCode");
        tbl_exceptionDetails = MiscUtility.getWebElement(objFilepath, "CRA108_tbl_exceptionDetails");
        btn_list = MiscUtility.getWebElement(objFilepath, "CRA108_btn_list");
        btn_viewDtls = MiscUtility.getWebElement(objFilepath, "CRA108_btn_viewDtls");

        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    }

    public CRA180 verifyExceptionDtlsPresent(String clPeriodFrom, String clPeriodTo, String invNo, String airlineCode, String clearancePeriod, String expType, String expStatus, String noOfExp) {

        clPeriodFrom = PropertyHandler.getPropValue(dataFilePath, clPeriodFrom);
        clPeriodTo = PropertyHandler.getPropValue(dataFilePath, clPeriodTo);
        invNo = PropertyHandler.getPropValue(dataFilePath, invNo);
        airlineCode = PropertyHandler.getPropValue(dataFilePath, airlineCode);
        clearancePeriod = PropertyHandler.getPropValue(dataFilePath, clearancePeriod);
        expType = PropertyHandler.getPropValue(dataFilePath, expType);

        list(clPeriodFrom, clPeriodTo, invNo, airlineCode);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_exceptionDetails, 3, invNo), "The Exception is not present for Invoice number: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 2, 3, invNo).trim(), clearancePeriod, "The clearence period doesn't match for Invoice No: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 4, 3, invNo).trim().toLowerCase(), expType.toLowerCase(), "The Exception type period doesn't match for Invoice No: " + invNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 5, 3, invNo).trim().toLowerCase(), noOfExp, "The number of Exception doesn't match for Invoice No: " + invNo);
        int flagCol = 0;
        switch (expStatus.toUpperCase()) {

            case "UNASSIGNED":
                flagCol = 6;
                break;
            case "ASSIGNED":
                flagCol = 7;
                break;
            case "REASSIGNED":
                flagCol = 8;
                break;
            case "RESOLVED":
                flagCol = 9;
                break;
        }

        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, flagCol, 3, invNo).trim().toLowerCase(), "1", "The Exception status period doesn't match for Invoice No: " + invNo);
        return this;
    }

    public CRA180 verifyExceptionNotPresent(String clPeriodFrom, String clPeriodTo, String invNo, String airlineCode) {

        clPeriodFrom = PropertyHandler.getPropValue(dataFilePath, clPeriodFrom);
        clPeriodTo = PropertyHandler.getPropValue(dataFilePath, clPeriodTo);
        invNo = PropertyHandler.getPropValue(dataFilePath, invNo);
        airlineCode = PropertyHandler.getPropValue(dataFilePath, airlineCode);

        list(clPeriodFrom, clPeriodTo, invNo, airlineCode);

        Assert.assertFalse(verifyValuePresentInTblColumn(tbl_exceptionDetails, 3, invNo), "The Exception is present for Invoice number: " + invNo);
        return this;
    }

    private void list(String clPeriodFrom, String clPeriodTo, String invNo, String airlineCode) {

        enterKeys(txt_clPeriodFrom, clPeriodFrom);
        enterKeys(txt_clPeriodTo, clPeriodTo);
        enterKeys(txt_invNo, invNo);
        enterKeys(txt_airlineCode, airlineCode);

        click(btn_list);
        minWait();
    }

    public CRA181 navigateToCRA181(String clPeriodFrom, String clPeriodTo, String invNo, String airlineCode){

        clPeriodFrom = PropertyHandler.getPropValue(dataFilePath, clPeriodFrom);
        clPeriodTo = PropertyHandler.getPropValue(dataFilePath, clPeriodTo);
        invNo = PropertyHandler.getPropValue(dataFilePath, invNo);
        airlineCode = PropertyHandler.getPropValue(dataFilePath, airlineCode);

        list(clPeriodFrom, clPeriodTo, invNo, airlineCode);

        tblSelectRowByColValue(tbl_exceptionDetails,1,3,invNo);

        click(btn_viewDtls);

        return new CRA181(driver,dataFileName);
    }

    public CRA180 verifyExceptonStatusWithoutListing(String invNo, String status, String... excpAssignTo) {

        invNo = PropertyHandler.getPropValue(dataFilePath,invNo);
        int flagCol = 0;
        switch (status.toUpperCase()) {

            case "UNASSIGNED":
                flagCol = 6;
                break;
            case "ASSIGNED":
                flagCol = 7;
                excpAssignTo[0] = PropertyHandler.getPropValue(dataFilePath,excpAssignTo[0]);
                Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 10, 3, invNo).trim().toLowerCase(), excpAssignTo[0].toLowerCase(), "The Assigned to doesn't match for Invoice No: " + invNo);
                break;
            case "REASSIGNED":
                flagCol = 8;
                excpAssignTo[0] = PropertyHandler.getPropValue(dataFilePath,excpAssignTo[0]);
                Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, 10, 3, invNo).trim().toLowerCase(), excpAssignTo[0].toLowerCase(), "The Assigned to doesn't match for Invoice No: " + invNo);
                break;
            case "RESOLVED":
                flagCol = 9;
                break;
        }

        Assert.assertEquals(tblGetTextByColValue(tbl_exceptionDetails, flagCol, 3, invNo).trim().toLowerCase(), "1", "The Exception status period doesn't match for Invoice No: " + invNo);

        return this;
    }

    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}
