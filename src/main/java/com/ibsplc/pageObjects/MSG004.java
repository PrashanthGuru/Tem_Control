package com.ibsplc.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class MSG004 extends BasePage {
    private final static Logger logger = Logger.getLogger(MSG005.class);
    public static String objectFileName = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");

    private final String contentFrame = "iCargoContentFrameMSG004";
    public String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public String dataFileName;

    private By drpdown_participantType,
            txt_participant,
            chkbox_autoprocess,
            chkbox_sendFNA,
            chkbox_sendFMA,
            btn_save,
            dialogue_msg,
            btn_genericYes,
            btn_close,
            btn_clear,
            txt_msgType,
            tbl_paramTable,
            dropdown_msgStd;


    private WebDriver driver;


    public MSG004(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        initElements();
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }


    private void initElements() {
        drpdown_participantType = MiscUtility.getWebElement(objectFileName, "MSG004_drpdown_participantType");
        txt_participant = MiscUtility.getWebElement(objectFileName, "MSG004_txt_participant");
        chkbox_autoprocess = MiscUtility.getWebElement(objectFileName, "MSG004_chkbox_autoprocess");
        chkbox_sendFNA = MiscUtility.getWebElement(objectFileName, "MSG004_chkbox_sendFNA");
        btn_save = MiscUtility.getWebElement(objectFileName, "MSG004_btn_save");
        //dialogue_msg                             =  MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_close = MiscUtility.getWebElement(objectFileName, "MSG004_btn_close");
        chkbox_sendFMA = MiscUtility.getWebElement(objectFileName, "MSG004_chkbox_sendFMA");
        btn_clear = MiscUtility.getWebElement(objectFileName, "MSG004_btn_clear");
        txt_msgType = MiscUtility.getWebElement(objectFileName, "MSG004_txt_msgType");
        tbl_paramTable = MiscUtility.getWebElement(objectFileName, "MSG004_tbl_paramTable");
        dropdown_msgStd = MiscUtility.getWebElement(objectFileName, "MSG004_dropdown_msgStd");
    }

    /**
     * checks autoprocess FNA AMA. if the value is false it unchecks
     *
     * @param isSendFNA
     * @param isAutoProcess
     * @param isFMA
     * @return
     */
    public MSG004 checkAutoProcessFNAAMA(boolean isSendFNA, boolean isAutoProcess, boolean isFMA) {
        selectByText(drpdown_participantType, "All");
        //	enterKeys(txt_participant,"All");
        if (isSendFNA)
            check(chkbox_sendFNA);
        else
            unCheck(chkbox_sendFNA);

        if (isAutoProcess)
            check(chkbox_autoprocess);
        else
            unCheck(chkbox_autoprocess);

        if (isFMA)
            check(chkbox_sendFMA);
        else
            unCheck(chkbox_sendFMA);

        minWait();
        click(btn_save);

        driver.switchTo().defaultContent();
        while (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);

        }

        waitForFrameAndSwitch(contentFrame);

        return this;
    }

    /**
     * Changes FHL parameters
     *
     * @param participantType
     * @param participant
     * @param msgStd
     * @param paramDtls:      in the order parameter name, value, currValue
     * @return
     */
    public MSG004 changeFHLParameter(String participantType, String participant, String msgStd, String... paramDtls) {

        participantType = PropertyHandler.getPropValue(dataFilePath, participantType);
        participant = PropertyHandler.getPropValue(dataFilePath, participant);
        msgStd = PropertyHandler.getPropValue(dataFilePath, msgStd);
        String paramName, newValue, currValue;

        selectByText(drpdown_participantType, participantType);
        enterKeys(txt_participant, participant);
        enterKeys(txt_msgType, "FHL");
        selectByText(dropdown_msgStd, msgStd);

        for (int i = 0; i < paramDtls.length; i += 3) {
            PropertyHandler.setPropValue(dataFilePath, paramDtls[i + 2], tblGetListValueByColValue(tbl_paramTable, 2, 1, PropertyHandler.getPropValue(dataFilePath, paramDtls[i])));
            tblSetListValueByColValue(tbl_paramTable, 2, 1, PropertyHandler.getPropValue(dataFilePath, paramDtls[i]), PropertyHandler.getPropValue(dataFilePath, paramDtls[i + 1]));
        }

        click(btn_save);

        driver.switchTo().defaultContent();
        while (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);

        }

        waitForFrameAndSwitch(contentFrame);

        return this;
    }

    /**
     * clears the form
     *
     * @return
     * @author a-7681
     */
    public MSG004 clear() {

        click(btn_clear);
        minWait();
        return this;
    }

    public HomePage close() {

        logger.info("Closing MSG004 screen");
        click(btn_close);
        logger.info("MSG004 screen closed");
        driver.switchTo().defaultContent();

        return new HomePage(driver, dataFileName);
    }

}
