package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Page SHR048 : Maintain and List System Parameters
 *
 * @author a-7868 Krishna <28/12/2017>
 */
public class SHR048 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSHR048";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By txt_paramCode,
            btn_list,
            tbl_paramList,
            txt_paramVal,
            txt_tbl_paramCode,
            btn_save,
            btn_close,
            btn_clear,
            yesBtn,
            msg_success,
            btn_divClose;

    private WebDriver driver;
    private String screenFrame;
    private String dataFileName;

    public SHR048(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    /**
     * Method to initialize page objects
     * 28/12/2017
     *
     * @author a-7868 Krishna
     */
    private void initElements() {

        txt_paramCode = MiscUtility.getWebElement(objFilepath, "SHR048_txt_paramCode");
        btn_list = MiscUtility.getWebElement(objFilepath, "SHR048_btn_list");
        tbl_paramList = MiscUtility.getWebElement(objFilepath, "SHR048_tbl_paramList");
        txt_paramVal = MiscUtility.getWebElement(objFilepath, "SHR048_tbl_txt_paramValue");
        txt_tbl_paramCode = MiscUtility.getWebElement(objFilepath, "SHR048_tbl_txt_paramCode");
        btn_save = MiscUtility.getWebElement(objFilepath, "SHR048_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath, "SHR048_btn_close");
        btn_clear = MiscUtility.getWebElement(objFilepath, "SHR048_btn_clear");

        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        msg_success = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        btn_divClose = MiscUtility.getWebElement(genObjPath, "Generic_info_close1");
    }

    /**
     * Method to set parameter value
     * While reverting, the parameter "currnt_paramValue" can be "" (Empty)
     *
     * @param paramCode
     * @param paramValue
     * @param currnt_paramValue
     * @return
     * @author a-7868 Krishna <28/12/2017>
     */
    public SHR048 setParameter(String paramCode, String paramValue, String currnt_paramValue) {

        paramCode = PropertyHandler.getPropValue(dataFilePath, paramCode);
        paramValue = PropertyHandler.getPropValue(dataFilePath, paramValue);

        enterKeys(txt_paramCode, paramCode);
        click(btn_list);

        waitForElement(txt_tbl_paramCode);
        String txt_paramCode_old = waitForElement(txt_paramVal).getAttribute("value");
        //while reverting, no need to store current value
        if (!currnt_paramValue.equals(""))
            PropertyHandler.setPropValue(dataFilePath, currnt_paramValue, txt_paramCode_old);
        enterKeys(txt_paramVal, paramValue); 
        click(btn_save);
        driver.switchTo().defaultContent();
        //	Assert.assertTrue(waitForElement(msg_success).getText().contains("The data has been successfully saved."), "ERROR : Parameter change unsuccessful.");
        waitForFrameAndSwitch(FRAME);
//		click(btn_divClose);
        return this;
    }

    /**
     * Method to set parameter value
     * While reverting, the parameter "currnt_paramValue" can be "" (Empty)
     *
     * @param paramCode
     * @param paramValue
     * @param currnt_paramValue
     * @return
     * @author a-7868 Krishna <28/12/2017>
     */
    public SHR048 setParameter_value(String paramCode, String paramValue, String currnt_paramValue) {


        enterKeys(txt_paramCode, paramCode);
        click(btn_list);

        waitForElement(txt_tbl_paramCode);
        String txt_paramCode_old = waitForElement(txt_paramVal).getAttribute("value");
        //while reverting, no need to store current value
        if (!currnt_paramValue.equals(""))
            PropertyHandler.setPropValue(dataFilePath, currnt_paramValue, txt_paramCode_old);
        enterKeys(txt_paramVal, paramValue);
        click(btn_save);
        driver.switchTo().defaultContent();
//	Assert.assertTrue(waitForElement(msg_success).getText().contains("The data has been successfully saved."), "ERROR : Parameter change unsuccessful.");
        waitForFrameAndSwitch(FRAME);
        click(btn_divClose);
        return this;
    }

    public SHR048 verifyParamaterAndValue(String paramCode, String paramValue) {

        paramCode = PropertyHandler.getPropValue(dataFilePath, paramCode);
//        paramValue = PropertyHandler.getPropValue(dataFilePath, paramValue);

        enterKeys(txt_paramCode, paramCode);
        click(btn_list);

        waitForElement(txt_tbl_paramCode);
        String txt_paramCode_old = waitForElement(txt_paramVal).getAttribute("value");
        //while reverting, no need to store current value
        enterKeys(txt_paramVal, paramValue);
        click(btn_save);
        driver.switchTo().defaultContent();
//	Assert.assertTrue(waitForElement(msg_success).getText().contains("The data has been successfully saved."), "ERROR : Parameter change unsuccessful.");
        waitForFrameAndSwitch(FRAME);
        click(btn_divClose);
        return this;
    }

    /**
     * Method to close current page and return to Homepae
     * returns the instance of Homepage
     *
     * @return
     * @author a-7868 Krishna <28/12/2017>
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
