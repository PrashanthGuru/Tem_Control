package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class OPR037 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String dataFilePath;
    public static String FRAME = "iCargoContentFrameOPR037";
    private WebDriver driver;
    private String dataFileName;
    private By btn_close,
            txt_fsNo,
            btn_generate,
            txt_uldNo,
            txt_flightCarrCode,
            txt_flightNo,
            txt_fltDt,
            txt_pcs,
            txt_wt,
            txt_origin,
            txt_dest,
            txt_consignee,
            txt_shipper,
            txt_addMark,
            txt_remarks,
            btn_addLoc,
            txt_locDtlsLoc,
            txt_locDtlsPcs,
            txt_locDtlsWt,
            btn_locDtlsOk,
            btn_addDim,
            txt_length,
            txt_width,
            txt_height,
            txt_dimPcs,
            txt_dimWt,
            btn_addDamage,
            txt_damageCode,
            txt_damPcs,
            btn_save;

    private By btn_genericYes,
            info_footerMsg;

    public OPR037(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFileName = dataFileName;
        PageFactory.initElements(this.driver, this);
        dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + dataFileName;
        initPageElements();
    }

    private void initPageElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR037_btn_close");
        txt_fsNo = MiscUtility.getWebElement(objFilepath, "OPR037_txt_fsNo");
        btn_generate = MiscUtility.getWebElement(objFilepath, "OPR037_btn_generate");
        txt_uldNo = MiscUtility.getWebElement(objFilepath, "OPR037_txt_uldNo");
        txt_flightCarrCode = MiscUtility.getWebElement(objFilepath, "OPR037_txt_flightCarrCode");
        txt_flightNo = MiscUtility.getWebElement(objFilepath, "OPR037_txt_flightNo");
        txt_fltDt = MiscUtility.getWebElement(objFilepath, "OPR037_txt_fltDt");
        txt_pcs = MiscUtility.getWebElement(objFilepath, "OPR037_txt_pcs");
        txt_wt = MiscUtility.getWebElement(objFilepath, "OPR037_txt_wt");
        txt_origin = MiscUtility.getWebElement(objFilepath, "OPR037_txt_origin");
        txt_dest = MiscUtility.getWebElement(objFilepath, "OPR037_txt_dest");
        txt_consignee = MiscUtility.getWebElement(objFilepath, "OPR037_txt_consignee");
        txt_shipper = MiscUtility.getWebElement(objFilepath, "OPR037_txt_shipper");
        txt_addMark = MiscUtility.getWebElement(objFilepath, "OPR037_txt_addMark");
        txt_remarks = MiscUtility.getWebElement(objFilepath, "OPR037_txt_remarks");
        btn_addLoc = MiscUtility.getWebElement(objFilepath, "OPR037_btn_addLoc");
        txt_locDtlsLoc = MiscUtility.getWebElement(objFilepath, "OPR037_txt_locDtlsLoc");
        txt_locDtlsPcs = MiscUtility.getWebElement(objFilepath, "OPR037_txt_locDtlsPcs");
        txt_locDtlsWt = MiscUtility.getWebElement(objFilepath, "OPR037_txt_locDtlsWt");
        btn_locDtlsOk = MiscUtility.getWebElement(objFilepath, "OPR037_btn_locDtlsOk");
        btn_addDim = MiscUtility.getWebElement(objFilepath, "OPR037_btn_addDim");
        txt_length = MiscUtility.getWebElement(objFilepath, "OPR037_txt_length");
        txt_width = MiscUtility.getWebElement(objFilepath, "OPR037_txt_width");
        txt_height = MiscUtility.getWebElement(objFilepath, "OPR037_txt_height");
        txt_dimPcs = MiscUtility.getWebElement(objFilepath, "OPR037_txt_dimPcs");
        txt_dimWt = MiscUtility.getWebElement(objFilepath, "OPR037_txt_dimWt");
        btn_addDamage = MiscUtility.getWebElement(objFilepath, "OPR037_btn_addDamage");
        txt_damageCode = MiscUtility.getWebElement(objFilepath, "OPR037_txt_damageCode");
        txt_damPcs = MiscUtility.getWebElement(objFilepath, "OPR037_txt_damPcs");
        btn_save = MiscUtility.getWebElement(objFilepath, "OPR037_btn_save");

        btn_genericYes = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genFilepath, "Generic_foot_layer");
    }

    /**
     * generates FS number
     *
     * @param fsNo
     * @param uldType
     * @param compCode
     * @param uldNo
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param pcs
     * @param wt
     * @param origin
     * @param dest
     * @param consignee
     * @param shipper
     * @param loc
     * @param damageCode
     * @param damPcs
     * @return
     * @author a-7681
     */
    public OPR037 generateFSNo(String fsNo, String uldType, String compCode, String uldNo, String carrCode, String fltNo, String fltDt,
                               String pcs, String wt, String origin, String dest, String consignee, String shipper, String loc, String damageCode, String damPcs) {

        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);
        origin = PropertyHandler.getPropValue(dataFilePath, origin);
        dest = PropertyHandler.getPropValue(dataFilePath, dest);
        consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
        shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
        loc = PropertyHandler.getPropValue(dataFilePath, loc);
        damageCode = PropertyHandler.getPropValue(dataFilePath, damageCode);
        damPcs = PropertyHandler.getPropValue(dataFilePath, damPcs);


        click(btn_generate);
        minWait();
        PropertyHandler.setPropValue(dataFilePath, fsNo, waitForElementVisible(txt_fsNo).getAttribute("value"));
        String uld = BizUtility.createULDNum(uldType, compCode);
        enterKeys(txt_uldNo, uld);
        PropertyHandler.setPropValue(dataFilePath, uldNo, uld);
        enterKeys(txt_flightCarrCode, carrCode);
        enterKeys(txt_flightNo, fltNo);
        enterKeys(txt_fltDt, fltDt);
        enterKeys(txt_pcs, pcs);
        enterKeys(txt_wt, wt);
        enterKeys(txt_origin, origin);
        enterKeys(txt_dest, dest);
        enterKeys(txt_consignee, consignee);
        enterKeys(txt_shipper, shipper);
        enterKeys(txt_addMark, "Additional markings by automation.");
        enterKeys(txt_remarks, "Remarks by automation.");

        click(btn_addLoc);
        switchToSecondWindow();

        enterKeys(txt_locDtlsLoc, loc);
        enterKeys(txt_locDtlsPcs, pcs);
        enterKeys(txt_locDtlsWt, wt);
        click(btn_locDtlsOk);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        click(btn_addDim);
        enterKeys(txt_length, "10");
        enterKeys(txt_width, "10");
        enterKeys(txt_height, "10");
        enterKeys(txt_dimPcs, pcs);
        enterKeys(txt_dimWt, wt);

        click(btn_addDamage);
        enterKeys(txt_damageCode, damageCode);
        enterKeys(txt_damPcs, damPcs);

        click(btn_save);

        driver.switchTo().defaultContent();

        Assert.assertTrue(waitForElement(info_footerMsg).getText().contains("successfully"),"The FS numer is not generated successfuly");

        waitForFrameAndSwitch(FRAME);

        return this;
    }


    /**
     * generates FS number
     *
     * @param fsNo
     * @param uldType
     * @param compCode
     * @param uldNo
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param pcs
     * @param wt
     * @param origin
     * @param dest
     * @param consignee
     * @param shipper
     * @param loc
     * @return
     * @author a-7681
     */
    public OPR037 generateFSNoOnlyLoc(String fsNo, String uldType, String compCode, String uldNo, String carrCode, String fltNo, String fltDt,
                               String pcs, String wt, String origin, String dest, String consignee, String shipper, String loc) {

        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);
        origin = PropertyHandler.getPropValue(dataFilePath, origin);
        dest = PropertyHandler.getPropValue(dataFilePath, dest);
        consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
        shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
        loc = PropertyHandler.getPropValue(dataFilePath, loc);


        click(btn_generate);
        minWait();
        PropertyHandler.setPropValue(dataFilePath, fsNo, waitForElementVisible(txt_fsNo).getAttribute("value"));
        String uld = BizUtility.createULDNum(uldType, compCode);
        enterKeys(txt_uldNo, uld);
        PropertyHandler.setPropValue(dataFilePath, uldNo, uld);
        enterKeys(txt_flightCarrCode, carrCode);
        enterKeys(txt_flightNo, fltNo);
        enterKeys(txt_fltDt, fltDt);
        enterKeys(txt_pcs, pcs);
        enterKeys(txt_wt, wt);
        enterKeys(txt_origin, origin);
        enterKeys(txt_dest, dest);
        enterKeys(txt_consignee, consignee);
        enterKeys(txt_shipper, shipper);
        enterKeys(txt_addMark, "Additional markings by automation.");
        enterKeys(txt_remarks, "Remarks by automation.");

        click(btn_addLoc);
        switchToSecondWindow();

        enterKeys(txt_locDtlsLoc, loc);
        enterKeys(txt_locDtlsPcs, pcs);
        enterKeys(txt_locDtlsWt, wt);
        click(btn_locDtlsOk);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        click(btn_addDim);
        enterKeys(txt_length, "10");
        enterKeys(txt_width, "10");
        enterKeys(txt_height, "10");
        enterKeys(txt_dimPcs, pcs);
        enterKeys(txt_dimWt, wt);

        click(btn_save);

        driver.switchTo().defaultContent();

        Assert.assertTrue(waitForElement(info_footerMsg).getText().contains("successfully"),"The FS numer is not generated successfuly");

        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * Closes and goes to Home page
     *
     * @return
     * @author a-7681
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
