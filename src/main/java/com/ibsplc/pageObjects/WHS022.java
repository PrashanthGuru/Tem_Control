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
public class WHS022 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS022";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            btn_clear,
            txt_loc,
            btn_list,
            tbl_checkInCheckOut,
            txt_SU,
            txt_staff,
            link_next,
            txt_fromDt,
            txt_toDt;

    private By btn_genericYes,
            info_footerMsg,
            info_error;


    public WHS022(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        btn_close = MiscUtility.getWebElement(objFilepath, "WHS022_btn_close");
        btn_clear = MiscUtility.getWebElement(objFilepath, "WHS022_btn_clear");
        txt_loc = MiscUtility.getWebElement(objFilepath, "WHS022_txt_loc");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS022_btn_list");
        tbl_checkInCheckOut = MiscUtility.getWebElement(objFilepath, "WHS022_tbl_checkInCheckOut");
        txt_SU = MiscUtility.getWebElement(objFilepath, "WHS022_txt_SU");
        txt_staff = MiscUtility.getWebElement(objFilepath, "WHS022_txt_staff");
        link_next = MiscUtility.getWebElement(objFilepath, "WHS022_link_next");
        txt_fromDt = MiscUtility.getWebElement(objFilepath, "WHS022_txt_fromDt");
        txt_toDt = MiscUtility.getWebElement(objFilepath, "WHS022_txt_toDt");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    }

    /**
     * Lists with location and checks for the awb to be present
     *
     * @param loc
     * @param awbNos
     * @return
     * @author a-7681
     */
    public WHS022 verifyAwbPresentListedWithLoc(String loc, String... awbNos) {
        loc = PropertyHandler.getPropValue(dataFilePath, loc);

        enterKeys(txt_loc, loc);
        click(btn_list);
        minWait();

        for (String awbNo : awbNos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_checkInCheckOut, 3, awbNo), "The AWB " + awbNo + " is not present in the table.");
        }

        return this;
    }

    /**
     * Lists with SU and checks for the awb to be present
     *
     * @param su
     * @param awbNos
     * @return
     * @author a-7681
     */
    public WHS022 verifyAwbPresentListedWithSU(String su, String... awbNos) {
        su = PropertyHandler.getPropValue(dataFilePath, su);

        enterKeys(txt_SU, su);
        click(btn_list);

        for (String awbNo : awbNos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_checkInCheckOut, 3, awbNo), "The AWB " + awbNo + " is not present in the table.");
        }

        return this;
    }

    /**
     * Lists with staff and checks for the awb to be present
     *
     * @param staff
     * @param awbNos
     * @return
     * @author a-7681
     */
    public WHS022 verifyAwbPresentListedWithStaff(String staff, String... awbNos) {
        staff = PropertyHandler.getPropValue(dataFilePath, staff);

        boolean flag = false;
        enterKeys(txt_staff, staff);
        click(btn_list);

        for (String awbNo : awbNos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

            while (true) {
                if (verifyValuePresentInTblColumn(tbl_checkInCheckOut, 3, awbNo)) {
                    flag = true;
                    break;
                }

                try {
                    click(link_next);
                } catch (NoSuchElementException | TimeoutException e1) {
                    break;
                }
            }
            Assert.assertTrue(flag, "The AWB " + awbNo + " is not present in the table.");
        }

        return this;
    }


    /**
     * Lists with staff and checks for the awb to be present
     *
     * @param awbNos
     * @return
     * @author a-7681
     */
    public WHS022 verifyAwbPresentListedWithDate(String... awbNos) {

        boolean flag = false;
        enterKeys(txt_fromDt, "-1");
        enterKeys(txt_toDt, ".");
        click(btn_list);

        for (String awbNo : awbNos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

            while (true) {
                if (verifyValuePresentInTblColumn(tbl_checkInCheckOut, 3, awbNo)) {
                    flag = true;
                    break;
                }

                try {
                    click(link_next);
                } catch (NoSuchElementException | TimeoutException e1) {
                    break;
                }
            }
            Assert.assertTrue(flag, "The AWB " + awbNo + " is not present in the table.");
        }

        return this;
    }


    /**
     * clears the form
     *
     * @return
     */
    public WHS022 clear() {

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
