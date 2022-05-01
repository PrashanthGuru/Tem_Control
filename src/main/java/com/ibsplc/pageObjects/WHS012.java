package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 2/23/2018.
 */
public class WHS012 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS012";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            dropDown_docType,
            txt_fromDt,
            txt_refNo,
            btn_list,
            tbl_abandonShipment,
            btn_returnShipment,
            txt_rtrnShipLoc,
            txt_rtrnShipPcs,
            txt_rtrnShipWt,
            btn_rtrnShipOk,
            btn_clear;

    private By btn_genericYes;

    public WHS012(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "WHS012_btn_close");
        dropDown_docType = MiscUtility.getWebElement(objFilepath, "WHS012_dropDown_docType");
        txt_fromDt = MiscUtility.getWebElement(objFilepath, "WHS012_txt_fromDt");
        txt_refNo = MiscUtility.getWebElement(objFilepath, "WHS012_txt_refNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS012_btn_list");
        tbl_abandonShipment = MiscUtility.getWebElement(objFilepath, "WHS012_tbl_abandonShipment");
        btn_returnShipment = MiscUtility.getWebElement(objFilepath, "WHS012_btn_returnShipment");
        txt_rtrnShipLoc = MiscUtility.getWebElement(objFilepath, "WHS012_txt_rtrnShipLoc");
        txt_rtrnShipPcs = MiscUtility.getWebElement(objFilepath, "WHS012_txt_rtrnShipPcs");
        txt_rtrnShipWt = MiscUtility.getWebElement(objFilepath, "WHS012_txt_rtrnShipWt");
        btn_rtrnShipOk = MiscUtility.getWebElement(objFilepath, "WHS012_btn_rtrnShipOk");
        btn_clear = MiscUtility.getWebElement(objFilepath, "WHS012_btn_clear");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    /**
     * Lists an abandoned shipment using the reference number
     *
     * @param awbNo
     * @param refNo
     * @return
     * @author Arun A-7681
     */
    public WHS012 viewAbandonedShipment(String awbNo, String refNo) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        refNo = PropertyHandler.getPropValue(dataFilePath, refNo);

        listAWBwithRefNo(refNo);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_abandonShipment, 3, awbNo), "The AWB No " + awbNo + " is not listed for the ref No " + refNo);

        return this;
    }

    /**
     * returns a shipment to the warehouse
     *
     * @param awbNo
     * @param refNo
     * @param loc
     * @param pcs
     * @param wt
     * @return
     * @author Arun A-7681
     */
    public WHS012 returnShipment(String awbNo, String refNo, String loc, String pcs, String wt) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        refNo = PropertyHandler.getPropValue(dataFilePath, refNo);
        loc = PropertyHandler.getPropValue(dataFilePath, loc);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);

        listAWBwithRefNo(refNo);

        tblSelectRowByColValue(tbl_abandonShipment, 1, 3, awbNo);

        click(btn_returnShipment);
        switchToSecondWindow();

        enterKeys(txt_rtrnShipLoc, loc);
        enterKeys(txt_rtrnShipPcs, pcs);
        enterKeys(txt_rtrnShipWt, wt);
        click(btn_rtrnShipOk);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    public WHS012 clear() {

        minWait();
        click(btn_clear);
        return this;
    }

    private void listAWBwithRefNo(String refNo) {
        selectByText(dropDown_docType, "AWB");
        enterKeys(txt_fromDt, "");
        enterKeys(txt_refNo, refNo);
        click(btn_list);
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
