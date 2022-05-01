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
public class TRC006 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameTRC006";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
            btn_list,
            btn_clear,
            dropDown_reportType,
            txt_awbPre,
            txt_awbNo,
            txt_statedPcs,
            txt_statedWt,
            txt_irregularityRemarks,
            btn_print,
    tbl_damageSurvey,
    tbl_damage,
    txt_dmgDtls;

    private By btn_genericYes,
            btn_genericNo,
            info_footerMsg,
            info_genericMsg,
            btn_genericOk,
    overlay;

    public TRC006(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
        btn_close = MiscUtility.getWebElement(objFilepath, "TRC006_btn_close");
        btn_clear = MiscUtility.getWebElement(objFilepath, "TRC006_btn_clear");
        btn_list = MiscUtility.getWebElement(objFilepath, "TRC006_btn_list");
        dropDown_reportType = MiscUtility.getWebElement(objFilepath, "TRC006_dropDown_reportType");
        txt_awbPre = MiscUtility.getWebElement(objFilepath, "TRC006_txt_awbPre");
        txt_awbNo = MiscUtility.getWebElement(objFilepath, "TRC006_txt_awbNo");
        txt_statedPcs = MiscUtility.getWebElement(objFilepath, "TRC006_txt_statedPcs");
        txt_statedWt = MiscUtility.getWebElement(objFilepath, "TRC006_txt_statedWt");
        txt_irregularityRemarks = MiscUtility.getWebElement(objFilepath, "TRC006_txt_irregularityRemarks");
        btn_print = MiscUtility.getWebElement(objFilepath, "TRC006_btn_print");
        tbl_damageSurvey = MiscUtility.getWebElement(objFilepath, "TRC006_tbl_damageSurvey");
        tbl_damage = MiscUtility.getWebElement(objFilepath, "TRC006_tbl_damage");
        txt_dmgDtls = MiscUtility.getWebElement(objFilepath, "TRC006_txt_dmgDtls");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_genericNo = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        overlay = MiscUtility.getWebElement(genObjPath, "Generic_overlay");
    }

    public TRC006 printSurveyReport(String awbPre, String awbNo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list("Survey Report", awbPre, awbNo);

        driver.switchTo().defaultContent();

        if (verifyElementPresent(btn_genericNo)){
            click(btn_genericNo);
        }
        waitForFrameAndSwitch(FRAME);

        enterKeys(txt_irregularityRemarks, "Irregularity remarks by automation");

        click(btn_print);
        minWait();
        Assert.assertEquals(getNumberOfWindows(),2,"The report is not generated");

        switchToSecondWindow();
        closeAndmoveToFirstWindow();
        waitForElementInVisible(overlay);
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    public TRC006 printPartShipmentReport(String awbPre, String awbNo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list("Part Shipment Report", awbPre, awbNo);

        driver.switchTo().defaultContent();

        if (verifyElementPresent(btn_genericNo)){
            click(btn_genericNo);
        }
        waitForFrameAndSwitch(FRAME);

        enterKeys(txt_irregularityRemarks, "Irregularity remarks by automation");

        click(btn_print);
        minWait();
        Assert.assertEquals(getNumberOfWindows(),2,"The report is not generated");

        switchToSecondWindow();
        closeAndmoveToFirstWindow();
        waitForElementInVisible(overlay);
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    public TRC006 printDamageSurveyReport(String awbPre, String awbNo, String fltNo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);

        list("Damage Survey", awbPre, awbNo);

        driver.switchTo().defaultContent();

        if (verifyElementPresent(btn_genericNo)){
            click(btn_genericNo);
        }
        waitForFrameAndSwitch(FRAME);

        tblSelectRowByColValue(tbl_damageSurvey,1,2,fltNo);

        click(btn_print);
        minWait();
        Assert.assertEquals(getNumberOfWindows(),2,"The report is not generated");

        switchToSecondWindow();
        closeAndmoveToFirstWindow();
        waitForElementInVisible(overlay);
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    public TRC006 printDamageReport(String awbPre, String awbNo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list("Damage Report", awbPre, awbNo);

        driver.switchTo().defaultContent();

        if (verifyElementPresent(btn_genericNo)){
            click(btn_genericNo);
        }
        waitForFrameAndSwitch(FRAME);

        enterKeys(txt_dmgDtls,"Broken");

        click(btn_print);
        minWait();
        Assert.assertEquals(getNumberOfWindows(),2,"The report is not generated");

        switchToSecondWindow();
        closeAndmoveToFirstWindow();
        waitForElementInVisible(overlay);
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    private void list(String rprtType, String awbPre, String awbNo) {

        selectByText(dropDown_reportType, rprtType);
        minWait();
        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();

    }


    /**
     * clears form
     *
     * @return
     */
    public TRC006 clear() {

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
    
    //A-8680
    public TRC006 damageReport(String awbno, String prefix, String pcs) {
    	
    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);

    	list("Damage Report", prefix, awbno);
    	click(By.name("addDamage"));
    	click(By.xpath("//tbody[@id='tracingDamageReportTableBody']/tr[1]/td[1]/input"));
    	enterKeys(By.xpath("//tbody[@id='tracingDamageReportTableBody']/tr[1]/td[2]/input"),"BRK");
    	enterKeys(By.xpath("//tbody[@id='tracingDamageReportTableBody']/tr[1]/td[3]/input"),pcs);
    	enterKeys(By.xpath("//tbody[@id='tracingDamageReportTableBody']/tr[1]/td[4]/input"),"Broken");
    	click(By.name("btnPrintDamage"));
    	maxWait();
    	switchToSecondWindow();
    	captureAndAddScreenshot();
    	driver.close();
    	switchBackToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
        return this;
    }

}
