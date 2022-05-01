/**
 *
 */
package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author A-6545 on 16/2/2018.
 */

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class SHR122 extends BasePage {

    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    private static String FRAME = "iCargoContentFrameSHR122";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_Close,
            dropDown_authority,
            btn_list,
            btn_addNew,
            dropDown_addNewAuthority,
            txt_addNewNumbers,
            txt_addNewCity,
            txt_expiryDt,
            btn_addNewAdd,
            btn_save;

    private By btn_genericYes,
            info_footerMsg;


    public SHR122(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_Close = MiscUtility.getWebElement(objFilepath, "SHR122_btn_close");
        dropDown_authority = MiscUtility.getWebElement(objFilepath, "SHR122_dropDown_authority");
        btn_list = MiscUtility.getWebElement(objFilepath, "SHR122_btn_list");
        btn_addNew = MiscUtility.getWebElement(objFilepath, "SHR122_btn_addNew");
        dropDown_addNewAuthority = MiscUtility.getWebElement(objFilepath, "SHR122_dropDown_addNewAuthority");
        txt_addNewNumbers = MiscUtility.getWebElement(objFilepath, "SHR122_txt_addNewNumbers");
        txt_addNewCity = MiscUtility.getWebElement(objFilepath, "SHR122_txt_addNewCity");
        txt_expiryDt = MiscUtility.getWebElement(objFilepath, "SHR122_txt_expiryDt");
        btn_addNewAdd = MiscUtility.getWebElement(objFilepath, "SHR122_btn_addNewAdd");
        btn_save = MiscUtility.getWebElement(objFilepath, "SHR122_btn_save");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    }


    public SHR122 addCCSFConfig(String origin, String ccnfNo, boolean expired) {


        click(btn_addNew);
        switchToSecondWindow();

        selectByText(dropDown_addNewAuthority, "CCSF");
        String num = BizUtility.createFlightNum();
        enterKeys(txt_addNewNumbers, num);
        enterKeys(txt_addNewCity, origin);
        if (expired)
            enterKeys(txt_expiryDt, "-2");
        else
            enterKeys(txt_expiryDt, "+4");
        click(btn_addNewAdd);
        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);
        click(btn_save);

        driver.switchTo().defaultContent();

        Assert.assertEquals(waitForElement(info_footerMsg).getText().trim(), "Data Saved Successfully");

        waitForFrameAndSwitch(FRAME);


        return this;
    }

    /**
     * CLose and screen and go to home page
     *
     * @return
     * @author A-7681
     */
    public HomePage close() {

        click(btn_Close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}
