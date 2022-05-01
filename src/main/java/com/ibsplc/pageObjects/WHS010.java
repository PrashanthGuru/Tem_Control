package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 2/22/2018.
 */
public class WHS010 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS010";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
    tbl_abdnTble,
    btn_save;

    private By btn_genericYes,
    info_genericMsg,
    btn_genericOk;

    public WHS010(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath,"WHS010_btn_close");
        tbl_abdnTble = MiscUtility.getWebElement(objFilepath,"WHS010_tbl_abdnTble");
        btn_save = MiscUtility.getWebElement(objFilepath,"WHS010_btn_save");

        btn_genericYes = MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
        info_genericMsg = MiscUtility.getWebElement(genObjPath,"Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath,"Generic_btn_ok");

    }

    public WHS010 abandonShipmentFromWHS011(String awbNo, String pcs, String wt,String refNo){

        awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
        pcs = PropertyHandler.getPropValue(dataFilePath,pcs);
        wt = PropertyHandler.getPropValue(dataFilePath,wt);

        tblSetListValueByColValue(tbl_abdnTble,9,3,awbNo,"Customs");
        tblsetTextByColValue(tbl_abdnTble,10,3,awbNo,pcs);
        tblsetTextByColValue(tbl_abdnTble,11,3,awbNo,wt);
        tblSetListValueByColValue(tbl_abdnTble,12,3,awbNo,"Auction");
        tblSelectRowByColValue(tbl_abdnTble,1,3,awbNo);

        click(btn_save);

        driver.switchTo().defaultContent();

        String str = waitForElement(info_genericMsg).getText();

        PropertyHandler.setPropValue(dataFilePath,refNo,str.trim().substring(str.length()-5).trim());

        Assert.assertTrue(str.contains("The Selected Shipment has been abandoned. Abandoned referenceNumber is"),"The AWB " + awbNo + " is not abandoned");

        click(btn_genericOk);

        waitForFrameAndSwitch("iCargoContentFrameWHS011");

        return this;
    }

    /**
     * Method to close current page and return to screenWHS011
     * returns the instance of Homepage
     *
     * @return
     * @author Arun A-7681
     */
    public WHS011 closeToWHS011() {
        minWait();
        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes))
            click(btn_genericYes);
        waitForFrameAndSwitch("iCargoContentFrameWHS011");
        return new WHS011(driver, dataFileName);
    }


    /**
     * Method to close current page and return to Homepae
     * returns the instance of Homepage
     *
     * @return
     * @author Arun A-7681
     */
    public HomePage close() {
        minWait();
        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes))
            click(btn_genericYes);
        return new HomePage(driver, dataFileName);
    }
}
