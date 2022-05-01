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
public class WHS018 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS018";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            dropDown_type,
            txt_carrCode,
            txt_fltNo,
            txt_fromDt,
            txt_toDt,
            tbl_uldDtls,
            btn_list,
            btn_clear;

    private By btn_genericYes,
            info_footerMsg,
            info_error;


    public WHS018(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        btn_close = MiscUtility.getWebElement(objFilepath, "WHS018_btn_close");
        dropDown_type = MiscUtility.getWebElement(objFilepath, "WHS018_dropDown_type");
        txt_carrCode = MiscUtility.getWebElement(objFilepath, "WHS018_txt_carrCode");
        txt_fltNo = MiscUtility.getWebElement(objFilepath, "WHS018_txt_fltNo");
        txt_fromDt = MiscUtility.getWebElement(objFilepath, "WHS018_txt_fromDt");
        txt_toDt = MiscUtility.getWebElement(objFilepath, "WHS018_txt_toDt");
        tbl_uldDtls = MiscUtility.getWebElement(objFilepath, "WHS018_tbl_uldDtls");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS018_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "WHS018_btn_clear");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    }

    /**
     * Lists by type
     *
     * @param type: not read from data sheet
     * @return
     * @author a-7681
     */
    public WHS018 listByType(String type) {

        selectByText(dropDown_type, type);
        click(btn_list);
        return this;
    }

    /**
     * List by flight number
     *
     * @param carrCode
     * @param fltNo
     * @return
     * @author a-7681
     */
    public WHS018 listByFltNo(String carrCode, String fltNo) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);

        enterKeys(txt_carrCode, carrCode);
        enterKeys(txt_fltNo, fltNo);
        click(btn_list);
        return this;
    }

    /**
     * list by date
     *
     * @return
     * @author a-7681
     */
    public WHS018 listByDate() {

        enterKeys(txt_fromDt, "-1");
        enterKeys(txt_toDt, ".");
        click(btn_list);
        return this;
    }

    /**
     * verifies the details displayed for the flight number and uldNo
     * @param fltNo
     * @param uldNos
     * @return
     * @author a-7681
     */
    public WHS018 verifyDetailsWithoutListing(String fltNo, String... uldNos) {

        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_uldDtls, 3, fltNo), "The flght Number " + fltNo + " is not listed.");
        for (String uldNo : uldNos) {

            uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_uldDtls, 1, uldNo), "The ULD No " + uldNo + " is not listed.");
        }
        return this;
    }

    /**
     * Clears the form
     * @return
     * @author a-7681
     */
    public WHS018 clear(){

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
