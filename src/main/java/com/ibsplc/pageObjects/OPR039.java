package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen OPR040 - Shipper Return Note
 *
 * @author a-7868 Krishna <24/01/2018>
 */
public class OPR039 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameOPR039";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_close,
    txt_awbPre,
    txt_awbNO,
    btn_list,
    tbl_irpDtls;

    private By btn_genericYes,
            info_msg,
            btn_genOk;


    public OPR039(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    /**
     * Method to initialize page objects
     *
     * @author a-7868 Krishna <24/01/2018>
     */
    private void initElements() {

        btn_close = MiscUtility.getWebElement(objFilepath, "OPR039_btn_close");
        txt_awbPre = MiscUtility.getWebElement(objFilepath, "OPR039_txt_awbPre");
                txt_awbNO = MiscUtility.getWebElement(objFilepath, "OPR039_txt_awbNO");
                btn_list = MiscUtility.getWebElement(objFilepath, "OPR039_btn_list");
                tbl_irpDtls = MiscUtility.getWebElement(objFilepath, "OPR039_tbl_irpDtls");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    }

    public OPR039 verifyAWB(String awbPre, String awbNo){

        awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);

        list(awbPre,awbNo);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_irpDtls,3,awbNo),"The shipment is not marked as IRP.");

        return this;
    }

    private void list(String awbPre, String awbNo) {
        enterKeys(txt_awbPre,awbPre);
        enterKeys(txt_awbNO,awbNo);
        click(btn_list);
        minWait();
    }


    /**
     * CLose and screen and go to home page
     *
     * @return
     * @author a-7868 Krishna <24/01/2018>
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
