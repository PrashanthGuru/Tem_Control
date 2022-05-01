package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/5/2018.
 */
public class WHS021 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS021";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By dropDown_listType,
            btn_list,
            tbl_enquiryTbl,
            btn_close,
            btn_clear,
            txt_pickID,
            txt_frmDt,
            txt_toDt,
            btn_details;

    private By btn_genericYes,
            info_footerMsg,
            info_error;


    public WHS021(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        btn_close = MiscUtility.getWebElement(objFilepath, "WHS021_btn_close");
        btn_clear = MiscUtility.getWebElement(objFilepath, "WHS021_btn_clear");
        dropDown_listType = MiscUtility.getWebElement(objFilepath, "WHS021_dropDown_listType");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS021_btn_list");
        tbl_enquiryTbl = MiscUtility.getWebElement(objFilepath, "WHS021_tbl_enquiryTbl");
        txt_pickID = MiscUtility.getWebElement(objFilepath, "WHS021_txt_pickID");
        txt_frmDt = MiscUtility.getWebElement(objFilepath, "WHS021_txt_frmDt");
        txt_toDt = MiscUtility.getWebElement(objFilepath, "WHS021_txt_toDt");
        btn_details = MiscUtility.getWebElement(objFilepath, "WHS021_btn_details");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    }

    /**
     * List the pick IDs w.r.t to the given date range
     *
     * @param pickIDs
     * @return
     * @author Arun A-7681
     */
    public WHS021 listWithDates(String... pickIDs) {

        enterKeys(txt_frmDt, "-1");
        enterKeys(txt_toDt, ".");
        click(btn_list);

        for (String pickID : pickIDs) {
            pickID = PropertyHandler.getPropValue(dataFilePath, pickID);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_enquiryTbl, 3, pickID), "The pick ID " + pickID + " is not present in the table.");
        }

        return this;
    }

    /**
     * List the pick IDs w.r.t to the given pickID
     *
     * @param pickID
     * @return
     * @author Arun A-7681
     */
    public WHS021 listWithPickID(String pickID) {

        pickID = PropertyHandler.getPropValue(dataFilePath, pickID);
        enterKeys(txt_pickID, pickID);
        click(btn_list);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_enquiryTbl, 3, pickID), "The pick ID " + pickID + " is not present in the table.");

        return this;
    }

    /**
     * List the pickID w.r.t the given type
     *
     * @param type:   Not read from data sheet
     * @param pickIDs
     * @return
     * @author Arin A-7681
     */
    public WHS021 listWithType(String type, String... pickIDs) {

        selectByText(dropDown_listType, type);
        click(btn_list);
        for (String pickID : pickIDs) {
            pickID = PropertyHandler.getPropValue(dataFilePath, pickID);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_enquiryTbl, 3, pickID), "The pick ID " + pickID + " is not present in the table.");
        }
        return this;
    }

    public WHS020 viewDetails(String pickID){

        pickID = PropertyHandler.getPropValue(dataFilePath, pickID);

        enterKeys(txt_frmDt, "-8");
        enterKeys(txt_toDt, ".");
        click(btn_list);

        tblSelectRowByColValue(tbl_enquiryTbl,1,3,pickID);

        click(btn_details);

        return new WHS020(driver,dataFileName);
    }

    /**
     * clears the form
     *
     * @return
     */
    public WHS021 clear() {

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
