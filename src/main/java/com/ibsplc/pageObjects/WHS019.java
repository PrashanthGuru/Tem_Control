package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/5/2018.
 */
public class WHS019 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS019";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            radio_inbound,
            radio_outbound,
            txt_carrCode,
            txt_fltNo,
            txt_fltDt,
            btn_list,
            btn_clear,
            btn_add,
            txt_addUldNo,
            txt_addcarrCode,
            txt_addfltNo,
            txt_addfltDt,
            dropDown_POU,
            btn_addList,
            btn_addOk,
            btn_save,
            tbl_rampHandling;

    private By btn_genericYes,
            info_footerMsg,
            info_error;


    public WHS019(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        btn_close = MiscUtility.getWebElement(objFilepath, "WHS019_btn_close");
        radio_inbound = MiscUtility.getWebElement(objFilepath, "WHS019_radio_inbound");
        radio_outbound = MiscUtility.getWebElement(objFilepath, "WHS019_radio_outbound");
        txt_carrCode = MiscUtility.getWebElement(objFilepath, "WHS019_txt_carrCode");
        txt_fltNo = MiscUtility.getWebElement(objFilepath, "WHS019_txt_fltNo");
        txt_fltDt = MiscUtility.getWebElement(objFilepath, "WHS019_txt_fltDt");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS019_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "WHS019_btn_clear");
        btn_add = MiscUtility.getWebElement(objFilepath, "WHS019_btn_add");
        txt_addUldNo = MiscUtility.getWebElement(objFilepath, "WHS019_txt_addUldNo");
        txt_addcarrCode = MiscUtility.getWebElement(objFilepath, "WHS019_txt_addcarrCode");
        txt_addfltNo = MiscUtility.getWebElement(objFilepath, "WHS019_txt_addfltNo");
        txt_addfltDt = MiscUtility.getWebElement(objFilepath, "WHS019_txt_addfltDt");
        dropDown_POU = MiscUtility.getWebElement(objFilepath, "WHS019_dropDown_POU");
        btn_addList = MiscUtility.getWebElement(objFilepath, "WHS019_btn_addList");
        btn_addOk = MiscUtility.getWebElement(objFilepath, "WHS019_btn_addOk");
        btn_save = MiscUtility.getWebElement(objFilepath, "WHS019_btn_save");
        tbl_rampHandling = MiscUtility.getWebElement(objFilepath, "WHS019_tbl_rampHandling");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    }


    /**
     * lists a flight and adds a uld to it
     *
     * @param type:       not read from data sheet
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param dest
     * @param uldType
     * @param uldCompCode
     * @param uldNo
     * @return
     * @arun
     */
    public WHS019 listAndAddULD(String type, String carrCode, String fltNo, String fltDt, String dest, String uldType, String uldCompCode, String uldNo) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        dest = PropertyHandler.getPropValue(dataFilePath, dest);
        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        uldCompCode = PropertyHandler.getPropValue(dataFilePath, uldCompCode);

        list(type, carrCode, fltNo, fltDt);

        click(btn_add);

        switchToSecondWindow();
        String uld = BizUtility.createULDNum(uldType, uldCompCode);
        PropertyHandler.setPropValue(dataFilePath, uldNo, uld);
        enterKeys(txt_addUldNo, uld);
//        enterKeys(txt_addcarrCode, carrCode);
//        enterKeys(txt_addfltNo, fltNo);
//        enterKeys(txt_addfltDt, fltDt);
        selectByText(dropDown_POU, dest);
        click(btn_addList);
        minWait();
        click(btn_addOk);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_save);
        driver.switchTo().defaultContent();
        Assert.assertEquals(waitForElement(info_footerMsg).getText().trim(), "Saved Successfully", "The Ramp handling is not saved");
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    private void list(String type, String carrCode, String fltNo, String fltDt) {

        if (type.equalsIgnoreCase("Inbound")) {
            click(radio_inbound);
        }
        if (type.equalsIgnoreCase("Outbound")) {
            click(radio_outbound);
        }

        enterKeys(txt_carrCode, carrCode);
        enterKeys(txt_fltNo, fltNo);
        enterKeys(txt_fltDt, fltDt);

        click(btn_list);
        minWait();
    }

    /**
     * List a flight resulting in error
     * @param type: not read from data sheet
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param error
     * @return
     * @author a-7681
     */
    public WHS019 listWithError(String type, String carrCode, String fltNo, String fltDt, String error) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        error = PropertyHandler.getPropValue(dataFilePath, error);

        list(type, carrCode, fltNo, fltDt);

        Assert.assertEquals(waitForElement(info_error).getText().trim(), error, "The error message is not as expected.");

        return this;
    }

    /**
     * Saves by checking the Rcvd/Hand checkbox
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param uldNos
     * @param loc
     * @return
     * @author a-7681
     */
    public WHS019 chkRcvdHandOver(String type, String carrCode, String fltNo, String fltDt, String loc, String... uldNos){

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        loc = PropertyHandler.getPropValue(dataFilePath, loc);

        list(type,carrCode, fltNo, fltDt);

        for (String uldNo : uldNos) {
            uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
            tblSelectRowByColValue(tbl_rampHandling,16,3,uldNo);
            tblsetTextByColValue(tbl_rampHandling,20,3, uldNo,loc);
        }

        click(btn_save);
        driver.switchTo().defaultContent();
        Assert.assertEquals(waitForElement(info_footerMsg).getText().trim(), "Saved Successfully", "The Ramp handling is not saved");
        waitForFrameAndSwitch(FRAME);


        return this;
    }

    public WHS019 verifyRcvdChecked(String type,String carrCode, String fltNo, String fltDt, String loc, String... uldNos){

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        loc = PropertyHandler.getPropValue(dataFilePath, loc);

        list(type, carrCode, fltNo, fltDt);

        for (String uldNo : uldNos) {
            uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
            Assert.assertTrue(tblchkBxEnabledByColValue(tbl_rampHandling,16,3,uldNo),"The Rvcd/Hand Over check box is not enabled");
            Assert.assertEquals(tblGetTextByColValue_input(tbl_rampHandling,20,3, uldNo).trim(),loc,"The Forward location doesn't match.");
        }

        return this;
    }

    /**
     * clears the form
     *
     * @author a-7681
     */
    public WHS019 clear() {

        try {
            waitForElement(btn_clear);
        } catch (Exception e) {
            Actions action = new Actions(driver);
            action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();
        }
        return this;
    }

    /***
     * saves the transaction
     * @author a-7681
     */
    public WHS019 save() {

        minWait();
        click(btn_save);
        driver.switchTo().defaultContent();
        Assert.assertEquals(waitForElement(info_footerMsg).getText().trim(), "Saved Successfully", "The Ramp handling is not saved");
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * verifys the uld listed for a flight
     *
     * @param type:    not read from data sheet
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param uldNos
     * @return
     * @author Arun A-7681
     */
    public WHS019 verifyULDsListed(String type, String carrCode, String fltNo, String fltDt, String... uldNos) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

        list(type, carrCode, fltNo, fltDt);


        for (String uldNo : uldNos) {
            uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_rampHandling, 3, uldNo), "The ULD No: " + uldNo + " is not present in the list");
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
