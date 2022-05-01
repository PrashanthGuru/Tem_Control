package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-6545 on 20/12/2017.
 */
public class SHR011 extends BasePage {


    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameCAP012";
    public String dataFilePath;
    WebDriver driver;
    String testDataFile;
    String browser;
    private By txt_txnFromDate,
            txt_txnToDate,
            dropdown_ModuleName, txt_volIncfiltervalue,
            dropdown_SubModuleName, tbl_auditDetails,
            txt_AWBPrefix,
            txt_AWBNo,
            btn_List,
            btn_Close,
            btn_Clear,
            tbl_TransactionDetails,
            dropdown_transaction,
            btn_genericYes,
            txt_ubrNo;

    public SHR011(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.testDataFile = dataFileName;
        PageFactory.initElements(this.driver, this);
        dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + dataFileName;
        initPageElements();
    }

    private void initPageElements() {

        System.out.println("Going to capture all webElements..!");

        txt_txnFromDate = MiscUtility.getWebElement(objFilepath, "SHR011_txt_txnFromDate");
        txt_txnToDate = MiscUtility.getWebElement(objFilepath, "SHR011_txt_txnToDate");
        dropdown_ModuleName = MiscUtility.getWebElement(objFilepath, "SHR011_dropdown_ModuleName");
        dropdown_SubModuleName = MiscUtility.getWebElement(objFilepath, "SHR011_dropdown_SubModuleName");
        txt_AWBPrefix = MiscUtility.getWebElement(objFilepath, "SHR011_txt_AWBPrefix");
        txt_AWBNo = MiscUtility.getWebElement(objFilepath, "SHR011_txt_AWBNo");
        btn_List = MiscUtility.getWebElement(objFilepath, "SHR011_btn_List");
        btn_Close = MiscUtility.getWebElement(objFilepath, "SHR011_btn_Close");
        btn_Clear = MiscUtility.getWebElement(objFilepath, "SHR011_btn_Clear");
        tbl_TransactionDetails = MiscUtility.getWebElement(objFilepath, "SHR011_tbl_TransactionDetails");
        dropdown_transaction = MiscUtility.getWebElement(objFilepath, "SHR011_dropdown_transaction");
        txt_volIncfiltervalue = MiscUtility.getWebElement(objFilepath, "SHR011_txt_volIncfiltervalue");
        tbl_auditDetails = MiscUtility.getWebElement(objFilepath, "SHR011_tbl_auditDetails");
        txt_ubrNo = MiscUtility.getWebElement(objFilepath, "SHR011_txt_ubrNo");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    public SHR011 CheckAuditHistory(String key_startDate, String key_ModuleName, String key_SubModuleName,
                                    String key_endDate, String awbPre, String awbNo, String key_transaction, String key_triggerpoint,
                                    String key_addlninfo, boolean modified, boolean executed, String key_transaction2, String key_addlninfo2) {

        String data_txnFromDate = PropertyHandler.getPropValue(dataFilePath, key_startDate);
        String data_txnToDate = PropertyHandler.getPropValue(dataFilePath, key_endDate);
        String data_ModuleName = PropertyHandler.getPropValue(dataFilePath, key_ModuleName);
        String data_SubModuleName = PropertyHandler.getPropValue(dataFilePath, key_SubModuleName);
        String data_AWBPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        String data_awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);


        selectByText(dropdown_ModuleName, data_ModuleName);
        selectByText(dropdown_SubModuleName, data_SubModuleName);
        enterKeys(txt_txnFromDate, data_txnFromDate);
        enterKeys(txt_txnToDate, data_txnToDate);
        enterKeys(txt_AWBPrefix, data_AWBPre);
        enterKeys(txt_AWBNo, data_awbNo);

        click(btn_List);

        //driver.switchTo().defaultContent();
        minWait();

        List<String> trans = getTableColumnValues(tbl_TransactionDetails, 1); //Status column = 1
        Assert.assertTrue(trans.contains("Shipment Created"), "ERROR : Transaction matches");
        List<String> trigpt = getTableColumnValues(tbl_TransactionDetails, 6); //Status column = 6
        Assert.assertTrue(trigpt.contains("OPR026"), "ERROR : Trigger point matches.");
        List<String> addlninfo = getTableColumnValues(tbl_TransactionDetails, 4); //Status column = 4
        Assert.assertTrue(addlninfo.contains("Stated Pieces:10"), "ERROR : Additional info matches.");

        if (modified == true) {
            List<String> trans1 = getTableColumnValues(tbl_TransactionDetails, 1); //Status column = 1
            Assert.assertTrue(trans1.contains("AWB Updated"), "ERROR : Transaction matches");
            List<String> addlninfo1 = getTableColumnValues(tbl_TransactionDetails, 4); //Status column = 4
            Assert.assertTrue(addlninfo1.contains("Stated Pieces:20"), "ERROR : Additional info matches.");
        }
        if (executed == true) {
            List<String> trans1 = getTableColumnValues(tbl_TransactionDetails, 1); //Status column = 1
            Assert.assertTrue(trans1.contains("Shipment Executed"), "ERROR : Transaction matches");
        }
        waitForFrameAndSwitch(FRAME);
        minWait();


        click(btn_Clear);
        return this;
    }

    /**
     * Method to check whether a specific transaction is audited in SHR011 screen.
     *
     * @param module
     * @param subModule
     * @param sDate
     * @param awbPre
     * @param awbNo
     * @param transaction
     * @return
     * @author a-7868 Krishna <23/01/2018>
     */
    public SHR011 checkAuditEntry(String module, String subModule, String sDate,
                                  String awbPre, String awbNo, String transaction) {

        module = PropertyHandler.getPropValue(dataFilePath, module);
        subModule = PropertyHandler.getPropValue(dataFilePath, subModule);
        sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        transaction = PropertyHandler.getPropValue(dataFilePath, transaction);

        selectByText(dropdown_ModuleName, module);
        selectByText(dropdown_SubModuleName, subModule);
        enterKeys(txt_txnFromDate, sDate);
        enterKeys(txt_txnToDate, ".");
        enterKeys(txt_AWBPrefix, awbPre);
        enterKeys(txt_AWBNo, awbNo);
        selectByText(dropdown_transaction, transaction);
        click(btn_List);
        maxWait();

        Assert.assertTrue(getTableColumnValues(tbl_TransactionDetails, 1).contains(transaction), "ERROR : Transaction not found in Audit History");
        click(btn_Clear);
        return this;
    }

    public SHR011 checkAuditEntryDetails(String module, String subModule, String sDate,
                                         String VolInc_ID, String transaction) {

        module = PropertyHandler.getPropValue(dataFilePath, module);
        subModule = PropertyHandler.getPropValue(dataFilePath, subModule);
        sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
        VolInc_ID = PropertyHandler.getPropValue(dataFilePath, VolInc_ID);
        transaction = PropertyHandler.getPropValue(dataFilePath, transaction);
        selectByText(dropdown_ModuleName, module);
        selectByText(dropdown_SubModuleName, subModule);
        enterKeys(txt_txnFromDate, sDate);
        enterKeys(txt_txnToDate, ".");
        enterKeys(txt_volIncfiltervalue, VolInc_ID);
        click(btn_List);
        maxWait();

        System.out.println(getTableColumnValues(tbl_TransactionDetails, 1));//Volume Incentive Created
        Assert.assertTrue(getTableColumnValues(tbl_TransactionDetails, 1).contains(transaction), "ERROR : Transaction not found in Audit History");
        Assert.assertTrue(getTableColumnValues(tbl_TransactionDetails, 2).contains("ICOADMIN"), "ERROR : Transaction not found in Audit History");
        click(btn_Clear);
        return this;
    }

    public SHR011 checkAuditEntryDetails_GSACommission(String module, String subModule,
                                                       String GSA_CommID, String transaction) {

        module = PropertyHandler.getPropValue(dataFilePath, module);
        subModule = PropertyHandler.getPropValue(dataFilePath, subModule);

        GSA_CommID = PropertyHandler.getPropValue(dataFilePath, GSA_CommID);

        selectByText(dropdown_ModuleName, module);
        selectByText(dropdown_SubModuleName, subModule);
        enterKeys(txt_txnFromDate, "-1");
        enterKeys(txt_txnToDate, ".");
        minWait();
        enterKeys(txt_volIncfiltervalue, GSA_CommID);
        click(btn_List);
        click(btn_List);
        maxWait();
        if (transaction == "Created") {
            System.out.println(getTableColumnValues(tbl_TransactionDetails, 1));
            Assert.assertTrue(getTableColumnValues(tbl_TransactionDetails, 1).contains("GSA Comm ID Created"), "ERROR : Transaction not found in Audit History");
        }

        if (transaction == "Modify") {
            System.out.println(getTableColumnValues(tbl_TransactionDetails, 1));
            Assert.assertTrue(getTableColumnValues(tbl_TransactionDetails, 1).contains("GSA Comm ID Modified"), "ERROR : Transaction not found in Audit History");
        }
        if (transaction == "Activated") {
            System.out.println(getTableColumnValues(tbl_TransactionDetails, 1));
            Assert.assertTrue(getTableColumnValues(tbl_TransactionDetails, 1).contains("GSA Comm ID Activated"), "ERROR : Transaction not found in Audit History");
        }


        if (transaction == "Deleted") {
            System.out.println(getTableColumnValues(tbl_TransactionDetails, 1));
            Assert.assertTrue(getTableColumnValues(tbl_TransactionDetails, 1).contains("GSA Comm ID Deleted"), "ERROR : Transaction not found in Audit History");
        }

        if (transaction == "Inactivated") {
            System.out.println(getTableColumnValues(tbl_TransactionDetails, 1));
            Assert.assertTrue(getTableColumnValues(tbl_TransactionDetails, 1).contains("GSA Comm ID Inactivated"), "ERROR : Transaction not found in Audit History");
        }

        click(btn_Clear);
        return this;
    }


    public HomePage close() {

        click(btn_Close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {
            click(btn_genericYes);
        }
        return new HomePage(driver, testDataFile);
    }

	    /*
        *A-8255
	     */

    public SHR011 CheckAuditHistry(String key_startDate, String key_ModuleName, String key_SubModuleName,
                                   String key_endDate, String awbPre, String awbNo, String key_transaction, String key_triggerpoint,
                                   String key_addlninfo, boolean modified, boolean executed, String key_transaction2, String key_addlninfo2) {

        String data_txnFromDate = PropertyHandler.getPropValue(dataFilePath, key_startDate);
        String data_txnToDate = PropertyHandler.getPropValue(dataFilePath, key_endDate);
        String data_ModuleName = PropertyHandler.getPropValue(dataFilePath, key_ModuleName);
        String data_SubModuleName = PropertyHandler.getPropValue(dataFilePath, key_SubModuleName);
        String data_AWBPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        String data_awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);


        selectByText(dropdown_ModuleName, data_ModuleName);
        selectByText(dropdown_SubModuleName, data_SubModuleName);
        enterKeys(txt_txnFromDate, data_txnFromDate);
        enterKeys(txt_txnToDate, data_txnToDate);
        enterKeys(txt_AWBPrefix, data_AWBPre);
        enterKeys(txt_AWBNo, data_awbNo);
        String dat = waitForElement(txt_txnFromDate).getAttribute("value");


        click(btn_List);

        //driver.switchTo().defaultContent();
        minWait();

        List<String> trans = getTableColumnValues(tbl_TransactionDetails, 1); //Status column = 1
        Assert.assertTrue(trans.contains("Shipment Created"), "ERROR : Transaction matches");
        List<String> trigpt = getTableColumnValues(tbl_TransactionDetails, 6); //Status column = 6
        Assert.assertTrue(trigpt.contains("OPR026"), "ERROR : Trigger point matches.");
        List<String> user = getTableColumnValues(tbl_TransactionDetails, 2); //Status column = 6
        Assert.assertTrue(user.contains("GHAADMIN"), "ERROR : Trigger point matches.");
        // List<String> date = getTableColumnValues(tbl_TransactionDetails, 3); //Status column = 6
        // Assert.assertTrue((date).contains(dat.toLowerCase()), "ERROR : Trigger point matches.");
        List<String> station = getTableColumnValues(tbl_TransactionDetails, 5); //Status column = 6
        Assert.assertTrue(station.contains("TRV"), "ERROR : Trigger point matches.");

        // if(modified==false)
        // {
        // List<String> addlninfo = getTableColumnValues(tbl_TransactionDetails, 4); //Status column = 4
        // Assert.assertTrue(addlninfo.contains("Stated Pieces:4"), "ERROR : Additional info matches.");
        // }
        if (modified == true) {
            String[] trans1 = getTableColumns(tbl_TransactionDetails, 1); //Status column = 1
            for (int i = 1; i <= trans1.length; i++) {
                if (trans1[i].contains("AWB Updated")) {

                    String addlninfo1 = getTableColumnbyRow(tbl_TransactionDetails, 4, i); //Status column = 4
                    Assert.assertTrue(addlninfo1.contains("Stated Pieces:7"), "ERROR : Additional info matches.");
                    break;
                }
            }

        }

        if (executed == true) {
            List<String> trans2 = getTableColumnValues(tbl_TransactionDetails, 1); //Status column = 1
            Assert.assertTrue(trans2.contains("Shipment Executed"), "ERROR : Transaction matches");
        }
        //waitForFrameAndSwitch(FRAME);
        minWait();


        click(btn_Clear);
        return this;

    }

    /**
     *
     * @param ubrNo
     * @param traDt
     * @param wt
     * @param vol
     * @param source: not read from datasheet
     * @return
     */
    public SHR011 verifyBookingWtVolChange(String ubrNo, String traDt, String wt, String vol, String source){

        ubrNo = PropertyHandler.getPropValue(dataFilePath,ubrNo);
        traDt = PropertyHandler.getPropValue(dataFilePath,traDt);
        wt = PropertyHandler.getPropValue(dataFilePath,wt);
        vol = PropertyHandler.getPropValue(dataFilePath,vol);

        selectByText(dropdown_ModuleName, "Capacity");
        selectByText(dropdown_SubModuleName, "Booking");
        enterKeys(txt_txnFromDate, traDt);
        enterKeys(txt_txnToDate, traDt);

        enterKeys(txt_ubrNo, ubrNo);
        click(btn_List);

        String updatedDtls = getTableCellValue(tbl_TransactionDetails,4,1);
        Assert.assertTrue(updatedDtls.contains("/" + wt), "The updated weight is not present");
        Assert.assertTrue(updatedDtls.contains("/" + vol), "The updated volume is not present");
        Assert.assertTrue(updatedDtls.contains(source), "The source of update is not present");

        return this;
    }
}
