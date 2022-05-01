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
public class WHS020 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS020";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By dropDown_listType,
    btn_list,
            txt_awbPre,
            txt_awbNo,
            txt_destLoc,
            btn_addToList,
            tbl_pickListTbl,
            btn_save,
            btn_close,
            btn_clear,
            txt_srnNo,
            txt_pickID,
            txt_fltCarrCode,
            txt_fltNO,
            txt_fltDt,
            chkBx_allLoc,
            btn_dltLoc,
            btn_multiPrint,
            btn_printLocal;

    private By btn_genericYes,
            info_footerMsg,
            info_error;


    public WHS020(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        dropDown_listType = MiscUtility.getWebElement(objFilepath, "WHS020_dropDown_listType");
        txt_awbPre = MiscUtility.getWebElement(objFilepath, "WHS020_txt_awbPre");
        txt_awbNo = MiscUtility.getWebElement(objFilepath, "WHS020_txt_awbNo");
        txt_destLoc = MiscUtility.getWebElement(objFilepath, "WHS020_txt_destLoc");
        btn_addToList = MiscUtility.getWebElement(objFilepath, "WHS020_btn_addToList");
        tbl_pickListTbl = MiscUtility.getWebElement(objFilepath, "WHS020_tbl_pickListTbl");
        btn_save = MiscUtility.getWebElement(objFilepath, "WHS020_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath, "WHS020_btn_close");
        btn_clear = MiscUtility.getWebElement(objFilepath, "WHS020_btn_clear");
        txt_srnNo = MiscUtility.getWebElement(objFilepath, "WHS020_txt_srnNo");
        txt_pickID = MiscUtility.getWebElement(objFilepath, "WHS020_txt_pickID");
        txt_fltCarrCode = MiscUtility.getWebElement(objFilepath, "WHS020_txt_fltCarrCode");
        txt_fltNO = MiscUtility.getWebElement(objFilepath, "WHS020_txt_fltNO");
        txt_fltDt = MiscUtility.getWebElement(objFilepath, "WHS020_txt_fltDt");
        chkBx_allLoc = MiscUtility.getWebElement(objFilepath, "WHS020_chkBx_allLoc");
        btn_dltLoc = MiscUtility.getWebElement(objFilepath, "WHS020_btn_dltLoc");
        btn_multiPrint = MiscUtility.getWebElement(objFilepath, "WHS020_btn_multiPrint");
        btn_printLocal = MiscUtility.getWebElement(objFilepath, "WHS020_btn_printLocal");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS020_btn_list");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    }

    /**
     * Relocates to a new location
     *
     * @param listType:   not read from data sheet
     * @param awbPre
     * @param awbNo
     * @param newLocation
     * @return
     * @author A-7681 Arun
     */
    public WHS020 warehouseRelocation(String listType, String awbPre, String awbNo, String newLocation, String pickID) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        newLocation = PropertyHandler.getPropValue(dataFilePath, newLocation);

        addToListAWB(listType, awbPre, awbNo);

        enterKeys(txt_destLoc, newLocation);

        tblSelectRowByColValue(tbl_pickListTbl, 24, 2, awbNo);
        click(btn_save);
        minWait();
        String pickId = waitForElementVisible(txt_pickID).getAttribute("value");
        Assert.assertNotEquals(pickId, "", "The pickID is not generated");
        PropertyHandler.setPropValue(dataFilePath, pickID, pickId);

        return this;
    }

    private void addToListAWB(String listType, String awbPre, String awbNo) {

        selectByText(dropDown_listType, listType);
        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);

        click(btn_addToList);

    }

    /**
     * adds one or more AWB to picklist
     *
     * @param listType
     * @param awbPre
     * @param awbNos
     * @return
     * @author Aurun A-7681
     */
    public WHS020 addToListMultiAWB(String listType, String awbPre, String... awbNos) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        selectByText(dropDown_listType, listType);

        for (String awbNo : awbNos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            enterKeys(txt_awbPre, awbPre);
            enterKeys(txt_awbNo, awbNo);
            click(btn_addToList);
            minWait();
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_pickListTbl, 2, awbNo), "The AWB " + awbNo + " is not added to the list");
        }
        return this;
    }

    /**
     * deletes one or more AWB from picklist
     *
     * @param awbNos
     * @return
     * @author Aurun A-7681
     */
    public WHS020 deleteMultiAWB(String... awbNos) {

        for (String awbNo : awbNos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            tblSelectRowByColValue(tbl_pickListTbl, 1, 2, awbNo);
            click(btn_dltLoc);
            minWait();
            Assert.assertFalse(verifyValuePresentInTblColumn(tbl_pickListTbl, 2, awbNo), "The AWB " + awbNo + " is not removed from the list");
        }

        return this;
    }

    public WHS020 enterPickingDtls(String awbNo, String destLoc, String pickPcs, String pickWt) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        destLoc = PropertyHandler.getPropValue(dataFilePath, destLoc);
        pickPcs = PropertyHandler.getPropValue(dataFilePath, pickPcs);
        pickWt = PropertyHandler.getPropValue(dataFilePath, pickWt);

        enterKeys(txt_destLoc, destLoc);

        tblsetTextByColValue(tbl_pickListTbl, 21, 2, awbNo, pickPcs);
        tblsetTextByColValue(tbl_pickListTbl, 22, 2, awbNo, pickWt);

        return this;
    }

    /**
     * Saves the list and generates PIck Ref ID
     *
     * @param awbNos
     * @return
     * @author Arun A-7681
     */
    public WHS020 saveAndGeneratePickList(String pickID, String... awbNos) {

        for (String awbNo : awbNos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            tblSelectRowByColValue(tbl_pickListTbl, 24, 2, awbNo);
        }
        click(btn_save);
        minWait();
        String pickId = waitForElementVisible(txt_pickID).getAttribute("value");
        Assert.assertNotEquals(pickId, "", "The pickID is not generated");
        PropertyHandler.setPropValue(dataFilePath, pickID, pickId);

        return this;
    }

    private void addToListFlight(String listType, String carrCode, String fltNo, String fltDt) {

        selectByText(dropDown_listType, listType);
        enterKeys(txt_fltCarrCode, carrCode);
        enterKeys(txt_fltNO, fltNo);
        enterKeys(txt_fltDt, fltDt);

        check(chkBx_allLoc);

        click(btn_addToList);

    }

    /**
     * @param srnNo
     * @return
     * @author Arun A-7681
     */
    public WHS020 verifyAWBErrorShipperReturn(String srnNo) {

        srnNo = PropertyHandler.getPropValue(dataFilePath, srnNo);

        selectByText(dropDown_listType, "Shipper Return");
        enterKeys(txt_srnNo, srnNo);
        click(btn_addToList);

        Assert.assertEquals(waitForElement(info_error).getText().trim(), "Please Enter AWB code", "The error message is not as expected");


        return this;
    }

    public WHS020 verifyErrorNotRFC(String listType, String carrCode, String fltNo, String fltDt, String awbNo) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        addToListFlight(listType, carrCode, fltNo, fltDt);

        tblSelectRowByColValue(tbl_pickListTbl, 24, 2, awbNo);

        click(btn_save);

        Assert.assertTrue(waitForElement(info_error).getText().contains("cannot be added in the pick list since outstanding checks are pending"), "The error message is not as expected. Actual:\n" + waitForElement(info_error).getText());


        return this;
    }

    /**
     * Relocates to a new location
     *
     * @param listType:   not read from data sheet
     * @param awbPre
     * @param awbNo
     * @param newLocation
     * @return
     * @author A-7681 Arun
     */
    public WHS020 warehouseRelocationWithSrnNo(String listType, String awbPre, String awbNo, String newLocation, String srnNo, String pickID) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        newLocation = PropertyHandler.getPropValue(dataFilePath, newLocation);
        srnNo = PropertyHandler.getPropValue(dataFilePath, srnNo);

        addToListAWB(listType, awbPre, awbNo, srnNo);

        enterKeys(txt_destLoc, newLocation);

        tblSelectRowByColValue(tbl_pickListTbl, 24, 2, awbNo);
        click(btn_save);

        String pickId = waitForElement(txt_pickID).getAttribute("value");
        Assert.assertNotEquals(pickId, "", "The pickID is not generated");
        PropertyHandler.setPropValue(dataFilePath, pickID, pickId);

        return this;
    }

    private void addToListAWB(String listType, String awbPre, String awbNo, String srnNo) {

        selectByText(dropDown_listType, listType);
        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);
        enterKeys(txt_srnNo, srnNo);

        click(btn_addToList);

    }

    public WHS020 clear() {

        click(btn_clear);
        minWait();
        return this;
    }

    public WHS020 verifyDtlsFromWHS021(String pickID) {

        pickID = PropertyHandler.getPropValue(dataFilePath, pickID);

        Assert.assertEquals(waitForElementVisible(txt_pickID).getAttribute("value").trim(), pickID, "The Pick ID doesn't match the selected one.");

        return this;
    }

    /**
     * closes the screen and goes back to home page
     *
     * @return
     * @author Arun A-7681
     */
    public WHS021 closeToWHS021() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        waitForFrameAndSwitch("iCargoContentFrameWHS021");
        return new WHS021(driver, dataFileName);
    }

    /**
     * Prints the Pick ID
     * @return
     * @author a-7681
     */
    public WHS020 printLocal(){

        waitForElement(btn_multiPrint);
        hoverAndClick(waitForElement(btn_multiPrint),waitForElement(btn_printLocal));

//        hover(waitForElement(btn_multiPrint));
        click(btn_multiPrint);
        click(btn_printLocal);
//        hoverAndClick(waitForElement(btn_multiPrint),waitForElement(btn_printLocal));

        Assert.assertEquals(getNumberOfWindows(),2,"The Print pdf is not generated");
        switchToSecondWindow();
        closeAndmoveToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        return this;
    }


    public WHS020 listPickID(String pickID){

        pickID = PropertyHandler.getPropValue(dataFilePath,pickID);

        enterKeys(txt_pickID,pickID);
        click(btn_list);
        minWait();
        return this;
    }

    /**
     * closes the screen and goes back to home page
     *
     * @return
     * @author Arun A-7681
     */
    public OPR293 closeToOPR293() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        waitForFrameAndSwitch("iCargoContentFrameOPR293");
        return new OPR293(driver, dataFileName);
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
