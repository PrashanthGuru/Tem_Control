package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/26/2017.
 */
public class ULD050 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameULD050";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By txt_airport,
            txt_uldType,
            txt_airline,
            btn_list,
            btn_clear,
            info_currAvailability,
            info_ULDIN,
            btn_LISTEXCESSSTOCK,
            chk_check,
            chk_otherstn,
            btn_ShowFltDet,
            btn_LISTACCESSORYSTOCK_CLOSE,
            info_ULDOUT,
            btn_close;

    private By btn_genericYes;


    public ULD050(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    /**
     * Initializes all the elements
     *
     * @author Arun A-7681 on 26/12
     */
    private void initElements() {

        txt_airport = MiscUtility.getWebElement(objFilepath, "ULD050_txt_airport");
        txt_uldType = MiscUtility.getWebElement(objFilepath, "ULD050_txt_uldType");
        txt_airline = MiscUtility.getWebElement(objFilepath, "ULD050_txt_airline");
        btn_list = MiscUtility.getWebElement(objFilepath, "ULD050_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "ULD050_btn_clear");
        info_currAvailability = MiscUtility.getWebElement(objFilepath, "ULD050_info_currAvailability");
        btn_close = MiscUtility.getWebElement(objFilepath, "ULD050_btn_close");
        info_ULDIN = MiscUtility.getWebElement(objFilepath, "ULD050_info_ULDIN");
        info_ULDOUT = MiscUtility.getWebElement(objFilepath, "ULD050_info_ULDOUT");
        chk_check= MiscUtility.getWebElement(objFilepath, "ULD050_chk_check");
        btn_LISTEXCESSSTOCK= MiscUtility.getWebElement(objFilepath, "ULD050_btn_LISTEXCESSSTOCK");
        chk_otherstn= MiscUtility.getWebElement(objFilepath, "ULD050_chk_otherstn");
        btn_ShowFltDet= MiscUtility.getWebElement(objFilepath, "ULD050_btn_ShowFltDet");
        btn_LISTACCESSORYSTOCK_CLOSE= MiscUtility.getWebElement(objFilepath, "ULD050_btn_LISTACCESSORYSTOCK_CLOSE");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    /**
     * lists the ULD stock based on the parameters
     *
     * @param airport
     * @param uldType
     * @param airline
     * @author Arun A-7681 on 26/12
     */
    private void list(String airport, String uldType, String airline) {

        enterKeys(txt_airport, airport);
        enterKeys(txt_uldType, uldType);
        enterKeys(txt_airline, airline);
        click(btn_list);
    }

    /**
     * Get the count of current available ULDs base on the parameters passed and save it to the datafile
     *
     * @param airport
     * @param uldType
     * @param airline
     * @param uldCurrentAvailability
     * @return
     * @author Arun A-7681 on 26/12
     */
    public ULD050 getCurrentAvailabilityCount(String airport, String uldType, String airline, String uldCurrentAvailability) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        airline = PropertyHandler.getPropValue(dataFilePath, airline);

        list(airport, uldType, airline);
        String count = waitForElement(info_currAvailability).getText().trim();
        PropertyHandler.setPropValue(dataFilePath, uldCurrentAvailability, count);
        return this;
    }

    public ULD050 checkCurrentAvailabilityCount(String airport, String uldType, String airline, String uldPreviousAvailability) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        airline = PropertyHandler.getPropValue(dataFilePath, airline);
        uldPreviousAvailability = PropertyHandler.getPropValue(dataFilePath, uldPreviousAvailability);

        list(airport, uldType, airline);

        String count = waitForElement(info_currAvailability).getText().trim();
        String expCount = String.valueOf(Integer.parseInt(uldPreviousAvailability) + 1);
        Assert.assertTrue(expCount.equals(count), "The ULD count have not been updated");
        return this;
    }
    /**
     * Ability to identify the airport where there is an excess of a particular type of ULD and those airports where there is a shortage of a particular type of ULD
     *
     * @param airport
     * @param uldType
     * @param airline
     * @param 
     * @return
     * @author Arun A-6545 1/2/2018
     */
    public ULD050  Excess_Stock_Airports(String airport, String uldType, String airline, String ULDIN,String ULDOUT) {

        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        airline = PropertyHandler.getPropValue(dataFilePath, airline);

        list(airport, uldType, airline);
        String incount = waitForElement(info_ULDIN).getText().trim();
        String outcount = waitForElement(info_ULDOUT).getText().trim();
        PropertyHandler.setPropValue(dataFilePath, ULDIN, incount);
        PropertyHandler.setPropValue(dataFilePath, ULDOUT, outcount);
        check(chk_check);
        click(btn_LISTEXCESSSTOCK);
        minWait();
        check(chk_otherstn);
        click(btn_ShowFltDet);
        
        minWait();
 
        
        return this;
    }
    /**
     * CLose and screen and go to home page
     *
     * @return
     * @author A-7681 Arun on 26/12
     */
    public HomePage close() {

        click(btn_LISTACCESSORYSTOCK_CLOSE);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}
