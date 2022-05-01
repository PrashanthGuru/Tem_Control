package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/2/2018.
 */
public class OPR262 extends BasePage {


    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameOPR262";
    private WebDriver driver;
    private String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    private By btn_close,
            btn_list,
            tbl_fltProgress,
            txt_carrCode,
            txt_fltNo,
            txt_fltDt,
            txt_fromDt,
            btn_pickList;

    private By btn_genericYes;

    public OPR262(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR262_btn_close");
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR262_btn_list");
        tbl_fltProgress = MiscUtility.getWebElement(objFilepath, "OPR262_tbl_fltProgress");
        txt_carrCode = MiscUtility.getWebElement(objFilepath, "OPR262_txt_carrCode");
        txt_fltNo = MiscUtility.getWebElement(objFilepath, "OPR262_txt_fltNo");
        txt_fltDt = MiscUtility.getWebElement(objFilepath, "OPR262_txt_fltDt");
        txt_fromDt = MiscUtility.getWebElement(objFilepath, "OPR262_txt_fromDt");
        btn_pickList = MiscUtility.getWebElement(objFilepath, "OPR262_btn_pickList");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }


    /**
     * Checks the manifest status of the flight
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param status
     * @return
     * @author Arun A-7681
     */
    public OPR262 checkManifestStatus(String carrCode, String fltNo, String fltDt, String status) {
        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

        list(carrCode, fltNo, fltDt);

        Assert.assertTrue(tblGetTextByColValue(tbl_fltProgress, 14, 2, fltNo).trim().equalsIgnoreCase(status), "The status doesn't match the value of: " + status);
        return this;
    }

    private void list(String carrCode, String fltNo, String fltDt) {
        enterKeys(txt_carrCode, carrCode);
        enterKeys(txt_fltNo, fltNo);
        enterKeys(txt_fltDt, fltDt);
        enterKeys(txt_fromDt, "-2");

        click(btn_list);
    }

    /**
     * Checks offload status of the flight
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param status
     * @return
     * @author Arun A-7681
     */
    public OPR262 checkOffloadStatus(String carrCode, String fltNo, String fltDt, String status) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

        list(carrCode, fltNo, fltDt);

        if (status.equalsIgnoreCase("offloaded")) {
            Assert.assertTrue(tblchkBxEnabledByColValue(tbl_fltProgress, 15, 2, fltNo), "The shipment is not offloaded");
        } else {
            Assert.assertFalse(tblchkBxEnabledByColValue(tbl_fltProgress, 15, 2, fltNo), "The shipment is offloaded");
        }
        return this;
    }

    public WHS020 generatePickList(String carrCode, String fltNo, String fltDt){

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

        list(carrCode, fltNo, fltDt);

        tblSelectRowByColValue(tbl_fltProgress,1,2,fltNo);
        click(btn_pickList);

        return new WHS020(driver,dataFileName);

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
