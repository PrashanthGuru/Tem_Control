package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 1/12/2018.
 */
public class WFW003 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWFW003";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By txt_msgType,
            btn_reference,
            txt_refFltNo,
            txt_msgSub,
            btn_list,
            tbl_msgDtls,
            btn_close;

    private By btn_genericYes;

    public WFW003(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        txt_msgType = MiscUtility.getWebElement(objFilepath, "WFW003_txt_msgType");
        btn_reference = MiscUtility.getWebElement(objFilepath, "WFW003_btn_reference");
        txt_refFltNo = MiscUtility.getWebElement(objFilepath, "WFW003_txt_refFltNo");
        txt_msgSub = MiscUtility.getWebElement(objFilepath, "WFW003_txt_msgSub");
        btn_list = MiscUtility.getWebElement(objFilepath, "WFW003_btn_list");
        tbl_msgDtls = MiscUtility.getWebElement(objFilepath, "WFW003_tbl_msgDtls");
        btn_close = MiscUtility.getWebElement(objFilepath, "WFW003_btn_close");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    }

    /**
     * CHecks if alert is sent
     * @param msgType: not read from data sheet
     * @param fltNo: can be "" if referance not required
     * @param awbNo: can be "" if referance not required
     * @return
     */
    public WFW003 checkMsgTriggered(String msgType, String fltNo, String awbNo) {

//        msgType = PropertyHandler.getPropValue(dataFilePath, msgType);

        enterKeys(txt_msgType, msgType);
        click(btn_reference);
        if (!fltNo.equals("")) {
            fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
            scrollToView(txt_refFltNo);
            enterKeys(txt_refFltNo, fltNo);
        }
        if (!awbNo.equals("")) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            scrollToView(txt_msgSub);
            enterKeys(txt_msgSub, awbNo);
        }
        click(btn_list);


        Assert.assertTrue((getTableColumnValues(tbl_msgDtls, 2).size() >= 1), "The " + msgType + " is not triggered.");
        return this;
    }

    /**
     * CLose and screen and go to home page
     *
     * @return
     * @author A-7681
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
