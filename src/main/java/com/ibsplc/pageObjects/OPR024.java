package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class OPR024 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String filepath;
    public static String FRAME = "iCargoContentFrameOPR024";
    private WebDriver driver;
    private String testDataFile;
    private By table_discrepancyDetails,
            table_damageDiscrepancy,
            btn_close,
            txt_awbPre,
            txt_awbNo,
            btn_list,
            btn_clear,
            btn_assign,
            btn_actionPad,
            txt_actionPadAction,
            btn_actionPadList,
            dropDown_actionPadAlertTime,
            chkBx_actionPadSend,
            txt_actionPadStation,
            txt_actionPadAssignee,
            dropDown_actionPadAssigneeType,
            btn_actionPadOk,
            btn_save,
            tbl_tracingHistory,
            txt_tracingQueue,
            txt_tracingStatus;

    private By btn_genericYes,
            btn_genericNo;

    public OPR024(WebDriver driver, String testDataFile) {
        super(driver);
        this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver, this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + testDataFile;
        initPageElements();
    }
    
    
    private void initPageElements() {
        table_discrepancyDetails = MiscUtility.getWebElement(objFilepath, "OPR024_table_discrepancyDetails");
        table_damageDiscrepancy = MiscUtility.getWebElement(objFilepath, "OPR024_table_damageDiscrepancy");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR024_btn_close");
        txt_awbPre = MiscUtility.getWebElement(objFilepath, "OPR024_txt_awbPre");
        txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR024_txt_awbNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR024_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "OPR024_btn_clear");
        btn_assign = MiscUtility.getWebElement(objFilepath, "OPR024_btn_assign");
        btn_actionPad = MiscUtility.getWebElement(objFilepath, "OPR024_btn_actionPad");
        txt_actionPadAction = MiscUtility.getWebElement(objFilepath, "OPR024_txt_actionPadAction");
        btn_actionPadList = MiscUtility.getWebElement(objFilepath, "OPR024_btn_actionPadList");
        dropDown_actionPadAlertTime = MiscUtility.getWebElement(objFilepath, "OPR024_dropDown_actionPadAlertTime");
        chkBx_actionPadSend = MiscUtility.getWebElement(objFilepath, "OPR024_chkBx_actionPadSend");
        txt_actionPadStation = MiscUtility.getWebElement(objFilepath, "OPR024_txt_actionPadStation");
        txt_actionPadAssignee = MiscUtility.getWebElement(objFilepath, "OPR024_txt_actionPadAssignee");
        dropDown_actionPadAssigneeType = MiscUtility.getWebElement(objFilepath, "OPR024_dropDown_actionPadAssigneeType");
        btn_actionPadOk = MiscUtility.getWebElement(objFilepath, "OPR024_btn_actionPadOk");
        btn_save = MiscUtility.getWebElement(objFilepath, "OPR024_btn_save");
        tbl_tracingHistory = MiscUtility.getWebElement(objFilepath, "OPR024_tbl_tracingHistory");
        txt_tracingQueue = MiscUtility.getWebElement(objFilepath, "OPR024_txt_tracingQueue");
        txt_tracingStatus = MiscUtility.getWebElement(objFilepath, "OPR024_txt_tracingStatus");

        btn_genericYes = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
        btn_genericNo = MiscUtility.getWebElement(genFilepath, "Generic_btn_noBtn");
    }
    
    private void verifyDiscrepancyTableData(String station, String flightNo, String flightDate, String discCode, String discPcs,
    		String discWgt, String mftPcs, String mftWgt, String rcvdPcs, String rcvdWgt, String status){
    	Assert.assertEquals(getTableCellValue(table_discrepancyDetails, 1, 1), station);
    	Assert.assertTrue(getTableCellValue(table_discrepancyDetails, 2, 1).contains(flightNo));
    	Assert.assertEquals(getTableCellValue(table_discrepancyDetails, 3, 1).toLowerCase(), flightDate.toLowerCase());
    	Assert.assertEquals(getTableCellValue(table_discrepancyDetails, 4, 1), discCode);
    	Assert.assertEquals(getTableCellValue(table_discrepancyDetails, 5, 1), discPcs);
    	Assert.assertEquals(getTableCellValue(table_discrepancyDetails, 6, 1), discWgt);
    	Assert.assertEquals(getTableCellValue(table_discrepancyDetails, 7, 1), mftPcs);
    	Assert.assertEquals(getTableCellValue(table_discrepancyDetails, 8, 1), mftWgt);
    	Assert.assertEquals(getTableCellValue(table_discrepancyDetails, 9, 1), rcvdPcs);
    	Assert.assertEquals(getTableCellValue(table_discrepancyDetails, 10, 1), rcvdWgt);
    	Assert.assertEquals(getTableCellValue(table_discrepancyDetails, 11, 1), status);  
    }
    /**
     * Created by A-7605 on 21-3-18
     * This method verify the discrepancy details of the AWB which is navigated from CLM002 screen
     * @param station
     * @param flightNo
     * @param flightDate
     * @param discCode
     * @param discPcs
     * @param discWgt
     * @param mftPcs
     * @param mftWgt
     * @param rcvdPcs
     * @param rcvdWgt
     * @param status
     * @return
     */
    public CLM002 verifyDescripancyDetails_CLM002(String station, String flightNo, String flightDate, String discCode, String discPcs,
    		String discWgt, String mftPcs, String mftWgt, String rcvdPcs, String rcvdWgt, String status){    	
    	
    	verifyDiscrepancyTableData(station, flightNo, flightDate, discCode, discPcs, discWgt, mftPcs, mftWgt, rcvdPcs, rcvdWgt, status);
    	click(btn_close);
    	return new CLM002(driver, testDataFile);
    }
    /**
     * Created by A-7605 on 21-3-18
     * This method verify the discrepancy details of the AWB which is navigated from CLM003 screen
     * @param station
     * @param flightNo
     * @param flightDate
     * @param discCode
     * @param discPcs
     * @param discWgt
     * @param mftPcs
     * @param mftWgt
     * @param rcvdPcs
     * @param rcvdWgt
     * @param status
     * @return
     */
    public CLM003 verifyDescripancyDetailsFromCLM003(String station, String flightNo, String flightDate, String discCode, String discPcs,
                                                     String discWgt, String mftPcs, String mftWgt, String rcvdPcs, String rcvdWgt, String status) {

    	verifyDiscrepancyTableData(station, flightNo, flightDate, discCode, discPcs, discWgt, mftPcs, mftWgt, rcvdPcs, rcvdWgt, status);
        click(btn_close);
        return new CLM003(driver, testDataFile);
    }

    /**
     * Verifies the discripancy details
     *
     * @param awbPre
     * @param awbNo
     * @param fltNo
     * @param descCode: not read from data sheet
     * @param pcs
     * @param wt
     * @return
     * @author a-7681
     */
    public OPR024 verifyDiscrepancyDetails(String awbPre, String awbNo, String fltNo, String descCode, String pcs, String wt) {

        awbPre = PropertyHandler.getPropValue(filepath, awbPre);
        awbNo = PropertyHandler.getPropValue(filepath, awbNo);
        fltNo = PropertyHandler.getPropValue(filepath, fltNo);
        pcs = PropertyHandler.getPropValue(filepath, pcs);
        wt = PropertyHandler.getPropValue(filepath, wt);

        list(awbPre, awbNo);

        Assert.assertTrue(verifyValuePresentInTblColumn(table_discrepancyDetails, 2, fltNo));
        Assert.assertEquals(tblGetTextByColValue(table_discrepancyDetails, 4, 2, fltNo), descCode, "The Discripancy code doesn't match for AWB No: " + awbNo);
        Assert.assertEquals(tblGetTextByColValue(table_discrepancyDetails, 5, 2, fltNo), pcs, "The Pieces code doesn't match for AWB No: " + awbNo);
        Assert.assertEquals(tblGetTextByColValue(table_discrepancyDetails, 6, 2, fltNo), wt, "The Weight code doesn't match for AWB No: " + awbNo);
        return this;
    }

    private void list(String awbPre, String awbNo) {
        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();
    }

    /**
     * Assign and actions a AWB discrpancy
     *
     * @param awbPre
     * @param awbNo
     * @param fltNo
     * @param action
     * @param station
     * @return
     * @author a-7681
     */
    public OPR024 assignAndAction(String awbPre, String awbNo, String fltNo, String action, String station, boolean alertTime/*, boolean successfulClosure*/, String... tracingStatus) {

        awbPre = PropertyHandler.getPropValue(filepath, awbPre);
        awbNo = PropertyHandler.getPropValue(filepath, awbNo);
        fltNo = PropertyHandler.getPropValue(filepath, fltNo);
        action = PropertyHandler.getPropValue(filepath, action);
        station = PropertyHandler.getPropValue(filepath, station);

        list(awbPre, awbNo);

        Assert.assertTrue(verifyValuePresentInTblColumn(table_discrepancyDetails, 2, fltNo));

        if (tracingStatus.length != 0){
            PropertyHandler.setPropValue(filepath,tracingStatus[0],waitForElementVisible(txt_tracingStatus).getText().trim());
        }
        if (verifyElementEnabled(btn_assign)) {
            click(btn_assign);
        }
        waitForElementDisabled(btn_assign);
        click(btn_actionPad);
        switchToSecondWindow();

        enterKeys(txt_actionPadAction, action);
        click(btn_actionPadList);
        if (alertTime) {
            selectByText(dropDown_actionPadAlertTime, "5 min");
        }
        check(chkBx_actionPadSend);
        enterKeys(txt_actionPadStation, station);
        selectByText(dropDown_actionPadAssigneeType, "Role Group");
        enterKeys(txt_actionPadAssignee, "GHAADMIN");
        click(btn_actionPadOk);
        minWait();

        if (getNumberOfWindows() == 2 && verifyElementPresent(btn_genericYes)){
           /* if (successfulClosure) {
                click(btn_genericYes);
            } else {
                click(btn_genericNo);
            }*/
        }

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_save);
        minWait();


        return this;
    }


    /**
     * Assign a AWB discrpancy
     *
     * @param awbPre
     * @param awbNo
     * @param fltNo
     * @return
     * @author a-7681
     */
    public OPR024 assignNoAction(String awbPre, String awbNo, String fltNo) {

        awbPre = PropertyHandler.getPropValue(filepath, awbPre);
        awbNo = PropertyHandler.getPropValue(filepath, awbNo);
        fltNo = PropertyHandler.getPropValue(filepath, fltNo);

        list(awbPre, awbNo);

        Assert.assertTrue(verifyValuePresentInTblColumn(table_discrepancyDetails, 2, fltNo));
        if (verifyElementEnabled(btn_assign)) {
            click(btn_assign);
        }
        waitForElementDisabled(btn_assign);
        minWait();


        return this;
    }
    
//    public CLM003 verifyDescripancyDetails(String station, String flightNo, String flightDate, String discCode, String discPcs,
//    		String discWgt, String mftPcs, String mftWgt, String rcvdPcs, String rcvdWgt, String status){    	
//    	verifyDiscrepancyTableData(station, flightNo, flightDate, discCode, discPcs, discWgt, mftPcs, mftWgt, rcvdPcs, rcvdWgt, status);
//    	click(btn_close);
//    	return new CLM003(driver, testDataFile);
//    }

    /**
     * Veifies the action is present in the tracing history
     *
     * @param awbPre
     * @param awbNo
     * @param action
     * @return
     * @author a-7681
     */
    public OPR024 verifyActionInTracingHistory(String awbPre, String awbNo, String action) {

        awbPre = PropertyHandler.getPropValue(filepath, awbPre);
        awbNo = PropertyHandler.getPropValue(filepath, awbNo);
        action = PropertyHandler.getPropValue(filepath, action);

        list(awbPre, awbNo);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_tracingHistory, 2, action), "The Action is not updated in Tracing history for AWB No: " + awbNo);

        return this;
    }


    /**
     * Veifies the action is present in the tracing history
     *
     * @param action
     * @return
     * @author a-7681
     */
    public OPR024 verifyTracingHistory(String action, String station, String date) {

        action = PropertyHandler.getPropValue(filepath, action);
        station = PropertyHandler.getPropValue(filepath, station);
        date = PropertyHandler.getPropValue(filepath, date);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_tracingHistory, 2, action), "The Action is not updated in Tracing history ");
        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_tracingHistory, 5, "Mail Description by automation"), "The Description is not updated in Tracing ");
        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_tracingHistory, 7, date), "The date is not updated in Tracing history");
        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_tracingHistory, 9, station), "The Station is not updated in Tracing history");

        return this;
    }

    /**
     * Veifies the tracing queue
     *
     * @param awbPre
     * @param awbNo
     * @param queue: not read from data sheet
     * @return
     * @author a-7681
     */
    public OPR024 verifyTracingQueue(String awbPre, String awbNo, String queue) {

        awbPre = PropertyHandler.getPropValue(filepath, awbPre);
        awbNo = PropertyHandler.getPropValue(filepath, awbNo);

        list(awbPre, awbNo);

        Assert.assertEquals(waitForElementVisible(txt_tracingQueue).getAttribute("value").trim(), queue, "The queue value doesn't match for AWB No: " + awbNo);

        return this;
    }

    public OPR024 clear() {

        click(btn_clear);
        minWait();
        return this;
    }


    /**
     * Closes and goes to Home page
     *
     * @return
     * @author a-7681
     */
    public TRC009 closeToTRC009() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new TRC009(driver, testDataFile);
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
        return new HomePage(driver, testDataFile);
    }

}
