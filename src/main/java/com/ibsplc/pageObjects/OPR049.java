package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class OPR049 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String FRAME = "iCargoContentFrameOPR049";
    private WebDriver driver;
    private String dataFileName;
    private By btn_close,
            txt_fsNo;

    private By btn_genericYes,
            info_footerMsg;

    public OPR049(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFileName = dataFileName;
        PageFactory.initElements(this.driver, this);
        dataFilePath = dataFilePath + dataFileName;
        initPageElements();
    }

    private void initPageElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR048_btn_close");
        txt_fsNo = MiscUtility.getWebElement(objFilepath, "OPR048_txt_fsNo");

        btn_genericYes = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genFilepath, "Generic_foot_layer");
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
