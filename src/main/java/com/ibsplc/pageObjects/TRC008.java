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
public class TRC008 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameTRC008";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            btn_list,
            btn_clear,
            txt_desc,
            txt_snoozeTime,
            btn_add,
            dropDown_elementType,
            txt_element,
            btn_save,
            chkBx_highPriority,
            txt_sgc;

    private By btn_genericYes,
            info_footerMsg,
            info_genericMsg,
            btn_genericOk;

    public TRC008(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "TRC008_btn_close");
        btn_list = MiscUtility.getWebElement(objFilepath, "TRC008_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "TRC008_btn_clear");
        txt_desc = MiscUtility.getWebElement(objFilepath, "TRC008_txt_desc");
        txt_snoozeTime = MiscUtility.getWebElement(objFilepath, "TRC008_txt_snoozeTime");
        btn_add = MiscUtility.getWebElement(objFilepath, "TRC008_btn_add");
        dropDown_elementType = MiscUtility.getWebElement(objFilepath, "TRC008_dropDown_elementType");
        txt_element = MiscUtility.getWebElement(objFilepath, "TRC008_txt_element");
        btn_save = MiscUtility.getWebElement(objFilepath, "TRC008_btn_save");
        chkBx_highPriority = MiscUtility.getWebElement(objFilepath, "TRC008_chkBx_highPriority");
        txt_sgc = MiscUtility.getWebElement(objFilepath, "TRC008_txt_sgc");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    }

    /**
     * Creates a new SGC and saves it
     *
     * @param sgc:          SGC saved to this valued
     * @param elementType:  not read from data sheet
     * @param element
     * @param highPriority: flag for high priority
     * @return
     */
    public TRC008 createNewSnoozeGrp(String sgc, String elementType, String element, boolean highPriority) {

        element = PropertyHandler.getPropValue(dataFilePath, element);

        String newSGC;
        while (true) {
            newSGC = "SGC" + BizUtility.createFlightNum();
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

        PropertyHandler.setPropValue(dataFilePath,sgc,waitForElement(txt_sgc).getAttribute("value"));

        enterKeys(txt_desc, newSGC + " created by Automation");
        enterKeys(txt_snoozeTime, "30");

        if (highPriority) {
            check(chkBx_highPriority);
        }

        click(btn_add);

        selectByText(dropDown_elementType, elementType);
        enterKeys(txt_element, element);

        click(btn_save);
        driver.switchTo().defaultContent();

        click(btn_genericYes);

        Assert.assertEquals(waitForElement(info_genericMsg).getText(), "Snooze Group Details saved successfully.");

        click(btn_genericOk);

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
