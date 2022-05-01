/**
 *
 */
package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author A-6545 on 23/2/2018.
 *
 */

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class CSH007 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "LTE_CSH_CLM.properties");
    private static String FRAME = "iCargoContentFrameCSH007";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By
            btn_Close,
    info_status,
    txt_awbPre,
    txt_awbNo,
    btn_list,
    btn_clear,
            list_creditChkBx;
    private By btn_genericYes;


    public CSH007(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {


        btn_Close = MiscUtility.getWebElement(objFilepath, "CSH007_btn_Close");
        info_status = MiscUtility.getWebElement(objFilepath, "CSH007_info_status");
        txt_awbPre = MiscUtility.getWebElement(objFilepath, "CSH007_txt_awbPre");
        txt_awbNo = MiscUtility.getWebElement(objFilepath, "CSH007_txt_awbNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "CSH007_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "CSH007_btn_clear");
        list_creditChkBx = MiscUtility.getWebElement(objFilepath, "CSH007_list_creditChkBx");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    /**
     * verifies the status
     * @param awbPre
     * @param awbNo
     * @param status: not read from data sheet
     * @param isCredit: to check checkbox ticked for credit
     * @return
     */
    public CSH007 verifyStatus(String awbPre, String awbNo, String status, boolean isCredit){

        awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);

        list(awbPre, awbNo);

        Assert.assertEquals(waitForElement(info_status).getText().toUpperCase(),status.toUpperCase(),"The Status dowsn't match for the AWB No: " + awbNo);

        if (isCredit){
            for (WebElement element : getWebElements(list_creditChkBx)){
                Assert.assertTrue(element.isSelected(),"The credit checkbox is not checked");
            }

        }


        return this;
    }

    private void list(String awbPre, String awbNo) {

        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();
    }

    /**
     * CLose and screen and go to home page
     *
     * @return
     * @author A-6545 on 20/2/2018.
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
