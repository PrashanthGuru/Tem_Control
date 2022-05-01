package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * @author A-6784
 */


public class OPR045 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameOPR045";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;
    private By
            btn_noBtn,
            btn_diaYes,
            info_error,
            info_msg,
            btn_genericOk;

    private By
            txt_AWBPrefix,
            txt_AWBNo,
            txt_FlightCarrier,
            txt_FlightNo,
            txt_FlightDate,
            txt_Remarks,
            btn_CreateDiscrepancy,
            btn_List,
            btn_Close,
            txt_pieces,
            txt_weight,
            txt_Status,
            txt_airport,
            dropDown_disType,
            dropDown_disCode,
            btn_closeDiscrepancy,
            txt_discPcs,
            txt_discWt;

    public OPR045(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;

        this.dataFileName = dataFileName;
    }

    private void initElements() {

        txt_AWBPrefix = MiscUtility.getWebElement(objFilepath, "OPR045_txt_AWBPrefix");
        txt_AWBNo = MiscUtility.getWebElement(objFilepath, "OPR045_txt_AWBNo");
        txt_FlightCarrier = MiscUtility.getWebElement(objFilepath, "OPR045_txt_FlightCarrier");
        txt_FlightNo = MiscUtility.getWebElement(objFilepath, "OPR045_txt_FlightNo");
        txt_FlightDate = MiscUtility.getWebElement(objFilepath, "OPR045_txt_FlightDate");
        txt_Remarks = MiscUtility.getWebElement(objFilepath, "OPR045_txt_Remarks");
        btn_CreateDiscrepancy = MiscUtility.getWebElement(objFilepath, "OPR045_btn_CreateDiscrepancy");
        btn_List = MiscUtility.getWebElement(objFilepath, "OPR045_btn_List");
        btn_Close = MiscUtility.getWebElement(objFilepath, "OPR045_btn_Close");
        txt_Status = MiscUtility.getWebElement(objFilepath, "OPR045_txt_Status");
        info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        txt_pieces = MiscUtility.getWebElement(objFilepath, "OPR045_txt_pieces");
        txt_weight = MiscUtility.getWebElement(objFilepath, "OPR045_txt_weight");
        txt_airport = MiscUtility.getWebElement(objFilepath, "OPR045_txt_airport");
        dropDown_disType = MiscUtility.getWebElement(objFilepath, "OPR045_dropDown_disType");
        dropDown_disCode = MiscUtility.getWebElement(objFilepath, "OPR045_dropDown_disCode");
        btn_closeDiscrepancy = MiscUtility.getWebElement(objFilepath, "OPR045_btn_closeDiscrepancy");
        txt_discPcs = MiscUtility.getWebElement(objFilepath, "OPR045_txt_discPcs");
        txt_discWt = MiscUtility.getWebElement(objFilepath, "OPR045_txt_discWt");

        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");

    }


    /**
     * checkDiscrepancy
     *
     * @param AWBprefix
     * @param AWBNo
     * @param pieces
     * @param weight
     * @return A-6784
     **/
    public OPR045 checkDiscrepancy(String AWBprefix, String AWBNo, String pieces, String weight) {


        AWBprefix = PropertyHandler.getPropValue(dataFilePath, AWBprefix);
        AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
        pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
        weight = PropertyHandler.getPropValue(dataFilePath, weight);

        enterKeys(txt_AWBPrefix, AWBprefix);
        enterKeys(txt_AWBNo, AWBNo);
        selectByText(dropDown_disType, "DOCDIS");
        click(btn_List);
        minWait();
        System.out.println("remarks" + waitForElement(txt_Remarks).getText());
      /*System.out.println("status"+waitForElement(txt_Status).getText());
      System.out.println("Pieces"+waitForElement(txt_pieces).getAttribute("value"));
	  System.out.println("wt"+waitForElement(txt_weight).getAttribute("value"));*/
        Assert.assertTrue(waitForElement(txt_Remarks).getText().contains("Discrepancy Automatically created on Flag Flight."));
    /*
      Assert.assertTrue(waitForElement(txt_Status).getAttribute("value").equals("Open"));
	  Assert.assertTrue(waitForElement(txt_pieces).getAttribute("value").equals(pieces));
	  Assert.assertTrue(waitForElement(txt_weight).getAttribute("value").equals(weight));*/
        return this;
    }

    /**
     * Creates a discrepancy
     *
     * @param awbPre
     * @param awbNo
     * @param disType
     * @param disCode
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param discDtls: gives discrepancy pcs and wt for WHSDIS
     * @return
     * @author a-7681
     */
    public OPR045 createDiscrepancy(String awbPre, String awbNo, String airport, String disType, String disCode, String carrCode, String fltNo, String fltDt, String... discDtls) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        airport = PropertyHandler.getPropValue(dataFilePath, airport);
        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

        list(awbPre, awbNo, airport, disType);

        driver.switchTo().defaultContent();
        click(btn_diaYes);
        waitForFrameAndSwitch(FRAME);

        selectByText(dropDown_disCode, disCode);
        if (disType.equalsIgnoreCase("WHSDIS")) {
            enterKeys(txt_discPcs, discDtls[0]);
            enterKeys(txt_discWt, discDtls[1]);
        }
        enterKeys(txt_FlightCarrier, carrCode);
        enterKeys(txt_FlightNo, fltNo);
        enterKeys(txt_FlightDate, fltDt);
        enterKeys(txt_Remarks, "Discrepancy created by automation.");

        click(btn_CreateDiscrepancy);
        driver.switchTo().defaultContent();
        Assert.assertEquals(waitForElement(info_msg).getText().trim(), "Document Discrepancy Saved Successfully.Do you want to relist ?", "The discrepancy is not created for AWB No: " + awbNo);
        if (disType.equalsIgnoreCase("WHSDIS")) {
            Assert.assertEquals(waitForElement(info_msg).getText().trim(), "Document Discrepancy Saved Successfully.Do you want to relist ?", "The discrepancy is not created for AWB No: " + awbNo);
        }
        click(btn_diaYes);

        return this;
    }

    /**
     * Closes a discrepancy
     *
     * @param awbPre
     * @param awbNo
     * @param airport
     * @param disType: Not read from data sheet
     * @return
     * @author a-7681
     */
    public OPR045 closeDiscrepancy(String awbPre, String awbNo, String airport, String disType) {


        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        airport = PropertyHandler.getPropValue(dataFilePath, airport);

        list(awbPre, awbNo, airport, disType);

        Assert.assertEquals(waitForElementVisible(txt_Status).getAttribute("value").trim().toUpperCase(), "OPEN", "The discrepancy is not in Open status for AWB No: " + awbNo);

        click(btn_closeDiscrepancy);

        driver.switchTo().defaultContent();
        Assert.assertEquals(waitForElement(info_msg).getText().trim(), "Document Discrepancy Closed Successfully.", "The discrepancy is not closed successfully for AWB No: " + awbNo);
        if (disType.equalsIgnoreCase("WHSDIS")) {
            Assert.assertEquals(waitForElement(info_msg).getText().trim(), "Document Discrepancy Closed Successfully.", "The discrepancy is not closed successfully for AWB No: " + awbNo);
        }
        click(btn_genericOk);
        waitForFrameAndSwitch(FRAME);

        return this;
    }

    /**
     * verifys the status of discrepancy
     *
     * @param awbPre
     * @param awbNo
     * @param airport
     * @param disType: Not read from data sheet
     * @param status:  Not read from data sheet
     * @return
     * @author a-7681
     */
    public OPR045 verifyStatus(String awbPre, String awbNo, String airport, String disType, String status) {


        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        airport = PropertyHandler.getPropValue(dataFilePath, airport);

        list(awbPre, awbNo, airport, disType);

        Assert.assertEquals(waitForElementVisible(txt_Status).getAttribute("value").trim().toUpperCase(), status.toUpperCase(), "The discrepancy is not in Open status for AWB No: " + awbNo);
        return this;
    }

    private void list(String awbPre, String awbNo, String airport, String disType) {

        enterKeys(txt_AWBPrefix, awbPre);
        enterKeys(txt_AWBNo, awbNo);
        enterKeys(txt_airport, airport);
        selectByText(dropDown_disType, disType);
        click(btn_List);
        minWait();
    }

    public HomePage close() {

        click(btn_Close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_diaYes)) {

            click(btn_diaYes);
        }
        return new HomePage(driver, dataFilePath);
    }


}



