package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/5/2018.
 */
public class TRC007 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameTRC007";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            txt_action,
            btn_list,
            btn_clear,
            txt_subject,
            txt_desc,
            dropDown_queue,
            chkBx_alertTime,
            chkBx_privUser,
            btn_save;

    private By btn_genericYes,
            info_footerMsg,
            info_genericMsg,
            btn_genericOk;

    public TRC007(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "TRC007_btn_close");
        txt_action = MiscUtility.getWebElement(objFilepath, "TRC007_txt_action");
        btn_list = MiscUtility.getWebElement(objFilepath, "TRC007_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "TRC007_btn_clear");
        txt_subject = MiscUtility.getWebElement(objFilepath, "TRC007_txt_subject");
        txt_desc = MiscUtility.getWebElement(objFilepath, "TRC007_txt_desc");
        dropDown_queue = MiscUtility.getWebElement(objFilepath, "TRC007_dropDown_queue");
        chkBx_alertTime = MiscUtility.getWebElement(objFilepath, "TRC007_chkBx_alertTime");
        chkBx_privUser = MiscUtility.getWebElement(objFilepath, "TRC007_chkBx_privUser");
        btn_save = MiscUtility.getWebElement(objFilepath, "TRC007_btn_save");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    }

    public TRC007 createNewAction(String act, String queue, boolean alertTime, boolean privUser) {

        String action;
        while (true) {
            action = "ACT" + BizUtility.createFlightNum();
            enterKeys(txt_action,action);
            click(btn_list);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(btn_genericYes)) {
                click(btn_genericYes);
                break;
            }
            waitForFrameAndSwitch(FRAME);
            click(btn_clear);
        }
        waitForFrameAndSwitch(FRAME);

        PropertyHandler.setPropValue(dataFilePath, act, waitForElementVisible(txt_action).getAttribute("value"));

        enterKeys(txt_subject, "Mail Subject");
        enterKeys(txt_desc, "Mail Description by automation.");
        if (!(queue.isEmpty())) {
            selectByText(dropDown_queue, queue);
        }
        if (alertTime) {
            check(chkBx_alertTime);
        }
        if (privUser) {
            check(chkBx_privUser);
        }

        click(btn_save);

        driver.switchTo().defaultContent();

        Assert.assertEquals(waitForElement(info_footerMsg).getText().trim(), "Data saved successfully.", "The action is not saved successfully");
        waitForFrameAndSwitch(FRAME);
        return this;
    }

    public TRC007 clear(){

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
