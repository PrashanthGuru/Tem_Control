package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class OPR050 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameOPR050";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;
    By text_awp,
            text_awb,
            txt_carrier,
            txt_flightNo,
            txt_fltDate,
            btn_btnList,
            tbl_listAwbStockHistoryTable,
            btn_btnClose,
            btn_btnPrint,
            dropDown_discCode,
            Btn_List,
            tbl_listdisctable,
            Btn_close,
            text_fromDate,
            text_toDate,
    tab_damage,
    tbl_damageDisTable;
    By btn_noBtn,
            btn_diaYes,
            info_error,
            info_msg;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");


    public OPR050(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;

        this.dataFileName = dataFileName;
    }

    private void initElements() {

        screenFrame = "iCargoContentFrameOPR050";
        text_awp = MiscUtility.getWebElement(objFilepath, "OPR050_text_awp");
        text_awb = MiscUtility.getWebElement(objFilepath, "OPR050_text_awb");
        btn_btnList = MiscUtility.getWebElement(objFilepath, "OPR050_Btn_List");
        info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        dropDown_discCode = MiscUtility.getWebElement(objFilepath, "OPR050_dropDown_discCode");
        Btn_List = MiscUtility.getWebElement(objFilepath, "OPR050_Btn_List");
        tbl_listdisctable = MiscUtility.getWebElement(objFilepath, "OPR050_tbl_listdisctable");
        Btn_close = MiscUtility.getWebElement(objFilepath, "OPR050_Btn_close");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        text_fromDate = MiscUtility.getWebElement(objFilepath, "OPR050_text_fromDate");
        text_toDate = MiscUtility.getWebElement(objFilepath, "OPR050_text_toDate");
        txt_carrier = MiscUtility.getWebElement(objFilepath, "OPR050_txt_carrier");
        txt_flightNo = MiscUtility.getWebElement(objFilepath, "OPR050_txt_flightNo");
        txt_fltDate = MiscUtility.getWebElement(objFilepath, "OPR050_txt_fltDate");
        tab_damage = MiscUtility.getWebElement(objFilepath, "OPR050_tab_damage");
        tbl_damageDisTable = MiscUtility.getWebElement(objFilepath, "OPR050_tbl_damageDisTable");

    }

    public OPR050 CheckDiscrepancy(String AWBprefix, String AWBNo, boolean disccheck2, String DiscCode1, String DiscCode2, String disccode1, String disccode2, String frmdate, String toDate) {

        // String StockRange = generateRandomString();
        //  PropertyHandler.setPropValue(dataFilePath,stockRange1, StockRange);
        AWBprefix = PropertyHandler.getPropValue(dataFilePath, AWBprefix);
        AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
        DiscCode1 = PropertyHandler.getPropValue(dataFilePath, DiscCode1);
        DiscCode2 = PropertyHandler.getPropValue(dataFilePath, DiscCode2);
        disccode1 = PropertyHandler.getPropValue(dataFilePath, disccode1);
        disccode2 = PropertyHandler.getPropValue(dataFilePath, disccode2);
        frmdate = PropertyHandler.getPropValue(dataFilePath, frmdate);
        toDate = PropertyHandler.getPropValue(dataFilePath, toDate);

        enterKeys(text_awp, AWBprefix);
        enterKeys(text_awb, AWBNo);
        enterKeys(text_fromDate, frmdate);
        enterKeys(text_toDate, toDate);

        if (disccheck2 == true) {
            selectByText(dropDown_discCode, DiscCode1);
            click(Btn_List);
            minWait();


            String discrepancy1 = getTableCellValue(tbl_listdisctable, 10, 1);
            System.out.println(discrepancy1);
            Assert.assertTrue(discrepancy1.contains(disccode2), "ERROR :No data found");
        } else {
            selectByText(dropDown_discCode, DiscCode2);
            click(Btn_List);
            minWait();
            //  driver.switchTo().defaultContent();
            String discrepancy = getTableCellValue(tbl_listdisctable, 10, 1);
            System.out.println(discrepancy);
            Assert.assertTrue(discrepancy.contains(disccode1), "ERROR :No data found");
        }
        return new OPR050(driver, dataFileName);


    }

    public OPR050 checkdiscrepancyFlight(String carrierCode, String flightNo, String flightDate, String disccode) {

        carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
        flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
        flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
        enterKeys(txt_carrier, carrierCode);
        enterKeys(txt_flightNo, flightNo);
        enterKeys(txt_fltDate, flightDate);
        click(Btn_List);
        minWait();
        driver.switchTo().defaultContent();
        String discrepancy = getTableCellValue(tbl_listdisctable, 10, 2);
        Assert.assertTrue(discrepancy.contains(disccode), "ERROR :No data found");
        return this;

    }

    public OPR050 noDiscrepancyError(String carrierCode, String flightNo, String flightDate) {

        carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
        flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
        flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);

        enterKeys(txt_carrier, carrierCode);
        enterKeys(txt_flightNo, flightNo);
        enterKeys(txt_fltDate, flightDate);
        click(Btn_List);
        minWait();
        //  driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(info_error).getText().contains("No results found for the specified criteria."), "ERROR :Discrepancy found");
        return this;

    }


    public HomePage close() {

        click(Btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_diaYes)) {

            click(btn_diaYes);
        }
        return new HomePage(driver, dataFileName);
    }


    public OPR050 verifyDescripancy(String awbPrefix, String awbNo, String expectedDescripancyCode, String expectedDescripancyStatus) {
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        expectedDescripancyCode = PropertyHandler.getPropValue(dataFilePath, expectedDescripancyCode);
        expectedDescripancyStatus = PropertyHandler.getPropValue(dataFilePath, expectedDescripancyStatus);

        enterKeys(text_awp, awbPrefix);
        enterKeys(text_awb, awbNo);
        enterKeys(text_fromDate, "");
        enterKeys(text_toDate, "");
        click(Btn_List);
        minWait();
        Assert.assertEquals(getTableCellValue(tbl_listdisctable, 10, 1), expectedDescripancyCode);
        Assert.assertEquals(getTableCellValue(tbl_listdisctable, 13, 1), expectedDescripancyStatus);
        return this;
    }

    /**
     * verifies damage discrepancy
     * @param awbPrefix
     * @param awbNo
     * @param damCode
     * @param damPcs
     * @return
     * @author a-7681
     */
    public OPR050 verifyDamageDtls(String awbPrefix, String awbNo, String damCode, String damPcs) {
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        damCode = PropertyHandler.getPropValue(dataFilePath, damCode);
        damPcs = PropertyHandler.getPropValue(dataFilePath, damPcs);

        enterKeys(text_awp, awbPrefix);
        enterKeys(text_awb, awbNo);
        enterKeys(text_fromDate, "");
        enterKeys(text_toDate, "");
        click(Btn_List);
        minWait();
        click(tab_damage);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_damageDisTable,2,awbNo)," The AWB No: " + awbNo + " is not present in the table.");
        Assert.assertEquals(tblGetTextByColValue(tbl_damageDisTable, 7, 2,awbNo), damCode,"The damage code doesn't match for the AWB No: " + awbNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_damageDisTable, 8, 2,awbNo), damPcs,"The damage pieces doesn't match for the AWB No: " + awbNo);
        return this;
    }

    /**
     * verifies discrepancy detaisl
     * @param awbPrefix
     * @param awbNo
     * @param disCode: not read from dat sheet
     * @param disPcs
     * @param disWt
     * @return
     * @author a-7681
     */
    public OPR050 verifyDiscrepancyDtls(String awbPrefix, String awbNo, String disCode, String disPcs, String disWt) {
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        disPcs = PropertyHandler.getPropValue(dataFilePath, disPcs);
        disWt = PropertyHandler.getPropValue(dataFilePath, disWt);

        enterKeys(text_awp, awbPrefix);
        enterKeys(text_awb, awbNo);
        enterKeys(text_fromDate, "");
        enterKeys(text_toDate, "");
        click(Btn_List);
        minWait();

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_listdisctable,2,awbNo)," The AWB No: " + awbNo + " is not present in the table.");
        Assert.assertEquals(tblGetTextByColValue(tbl_listdisctable, 10, 2,awbNo), disCode,"The discrepancy code doesn't match for the AWB No: " + awbNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_listdisctable, 11, 2,awbNo), disPcs,"The discrepancy pieces doesn't match for the AWB No: " + awbNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_listdisctable, 12, 2,awbNo), disWt,"The discrepancy weight doesn't match for the AWB No: " + awbNo);
        return this;
    }


}
