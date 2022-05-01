package com.ibsplc.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.python.core.exceptions;
import org.testng.Assert;

//created byA-8254

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-8254
 */
public class CAP103 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String screenFrame;
    private String screenFrame2;
    private String screenFrame3;
    private String dataFileName;

    private By txt_awbPrefix,
            txt_awbNo,
            btn_list,
            table_list,
            link_versionNew,
            txt_agentCode,
            txt_shippingDt,
            btn_close,
            btn_clear,
            btn_genericYes,
            link_versionOld,
            tbl_historyDtls;


    public CAP103(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {

        screenFrame = "iCargoContentFrameCAP103";
        screenFrame2 = "iCargoContentFrameCAP018";
        screenFrame3 = "iCargoContentFrameCAP016";
        txt_awbPrefix = MiscUtility.getWebElement(objFilepath, "CAP103_txt_awbNoPrefix");
        txt_awbNo = MiscUtility.getWebElement(objFilepath, "CAP103_txt_awbNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "CAP103_btn_list");
        table_list = MiscUtility.getWebElement(objFilepath, "CAP103_table_list");
        link_versionNew = MiscUtility.getWebElement(objFilepath, "CAP103_link_versionNew");
        txt_agentCode = MiscUtility.getWebElement(objFilepath, "CAP103_txt_agentCode");
        txt_shippingDt = MiscUtility.getWebElement(objFilepath, "CAP103_txt_shippingDt");
        btn_close = MiscUtility.getWebElement(objFilepath, "CAP103_btn_close");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_clear = MiscUtility.getWebElement(objFilepath, "CAP103_btn_clear");
        // btn_newWindowClose = MiscUtility.getWebElement(genObjPath,"CAP103_btn_newWindowClose");
        link_versionOld = MiscUtility.getWebElement(objFilepath, "CAP103_link_versionOld");
        tbl_historyDtls = MiscUtility.getWebElement(objFilepath, "CAP103_tbl_historyDtls");
    }


    public CAP103 verifyBookingHistoryPresent(String awbPre, String awbNo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        try{
        	enterKeys(txt_awbPrefix, awbPre);
        }
        catch(Exception e){}
        
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();
        verifyAWBNoPresent(awbPre, awbNo);

        return this;

    }

    public CAP103 verifyAWBNoPresent(String awbPre, String awbNo) {

        List<String> listElement;
        boolean flag = false;
        listElement = getTableColumnValues(table_list, 3);
        int count = listElement.size();
        for (int i = 0; i < count; i++) {
            String listElement2 = listElement.get(i);
            if (listElement2.contains(awbNo)) {
                System.out.println("the tempate found");
                flag = true;
                if (getTableCellValue(table_list, 1, 1).equals("")) {
                    flag = false;
                }
                break;
            }
        }

        if (flag == false) {
            System.out.println("not found");
            Assert.assertEquals(flag, true,"not found");

        }


        return this;
    }


    public CAP103 verifyBookingHistoryDetails(String awbPre, String awbNo, String agentCode) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);

        try{
        	enterKeys(txt_awbPrefix, awbPre);
        }catch(Exception e) {}
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        verifyAWBNoPresent(awbPre, awbNo);
        click(link_versionNew);
        waitForNewWindow(2);
        switchToSecondWindow();

        String agentCode2 = waitForElement(txt_agentCode).getAttribute("value");
        Assert.assertEquals(agentCode, agentCode2);
        return this;

    }

    public CAP103 verifyBookingHistoryDetails(String awbPre, String awbNo, String agentCode, String shippingDate) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
        shippingDate = PropertyHandler.getPropValue(dataFilePath, shippingDate);
        
        try{
        	enterKeys(txt_awbPrefix, awbPre);
        }catch(Exception e){}
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        verifyAWBNoPresent(awbPre, awbNo);
        click(link_versionNew);
        waitForNewWindow(2);
        switchToSecondWindow();

        String agentCode2 = waitForElement(txt_agentCode).getAttribute("value");
        Assert.assertEquals(agentCode, agentCode2);
        String shippingDate2 = waitForElement(txt_shippingDt).getAttribute("value");
        Assert.assertEquals(shippingDate, shippingDate2);

        return this;
    }

    /**
     * Method to list an awb and verify the shipment pcs/wt for given version
     *
     * @param awbPre
     * @param awbNo
     * @param pcs
     * @param wt
     * @param version
     * @return
     * @author A-7868 Krishna <26/03/2018>
     */
    public CAP103 verifyShipmentPcsWt(String awbPre, String awbNo, String pcs, String wt, int version) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);

        enterKeys(txt_awbPrefix, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();

        String xpath1 = "//tbody/tr/td[contains(.,'" + version + "')][1]/following-sibling::td[9]";
        String xpath2 = "//tbody/tr/td[contains(.,'" + version + "')][1]/following-sibling::td[10]";

        String str_pcs = driver.findElement(By.xpath(xpath1)).getText();
        String str_wt = driver.findElement(By.xpath(xpath2)).getText();

        //String str_pcs = tblGetTextByColValue_input(table_list, 7, 1, String.valueOf(version));
        //String str_wt = tblGetTextByColValue_input(table_list, 8, 1, String.valueOf(version));
        System.out.println("----------" + str_pcs + "--" + str_wt);
        Assert.assertTrue(str_pcs.equals(pcs), "ERROR : Shipment pcs mismatch");
        Assert.assertTrue(str_wt.equals(wt), "ERROR : Shipment wt mismatch");
        return this;
    }

    /**
     * Method to list an awb and verify the booked flight segment pcs/wt for given version
     *
     * @param awbPre
     * @param awbNo
     * @param pcs
     * @param wt
     * @param version
     * @return
     * @author A-7868 Krishna <26/03/2018>
     */
    public CAP103 verifyFlightPcsWt(String awbPre, String awbNo, String pcs, String wt, int version) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);

        enterKeys(txt_awbPrefix, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();

//        String str_pcs = tblGetTextByColValue_input(table_list, 15, 1, String.valueOf(version));
//	    String str_wt = tblGetTextByColValue_input(table_list, 16, 1, String.valueOf(version));

        String xpath1 = "//tbody/tr/td[contains(.,'" + version + "')][1]/following-sibling::td[17]";
        String xpath2 = "//tbody/tr/td[contains(.,'" + version + "')][1]/following-sibling::td[18]";

        String str_pcs = driver.findElement(By.xpath(xpath1)).getText();
        String str_wt = driver.findElement(By.xpath(xpath2)).getText();

        Assert.assertTrue(str_pcs.equals(pcs), "ERROR : Shipment pcs mismatch");
        Assert.assertTrue(str_wt.equals(wt), "ERROR : Shipment wt mismatch");
        click(btn_clear);

        return this;
    }


    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }


    public CAP103 verifyVersionPresentAndClick() {

        waitForElement(link_versionNew);
        //waitForElement(link_versionOld);
        click(link_versionNew);
        waitForNewWindow(2);
        switchToSecondWindow();
        closeAndmoveToFirstWindow();
        //switchToFirstWindow();
        minWait();
        waitForFrameAndSwitch(screenFrame2);
        //  click(btn_newWindowClose);
        return this;
    }


    public CAP103 verifyVersionPresentAndClickCAP016() {

        waitForElement(link_versionNew);
        //waitForElement(link_versionOld);
        click(link_versionNew);
        waitForNewWindow(2);
        switchToSecondWindow();
        closeAndmoveToFirstWindow();
        //switchToFirstWindow();
        minWait();
        waitForFrameAndSwitch(screenFrame3);
        //  click(btn_newWindowClose);
        return this;
    }

    /**
     * @param awbPre
     * @param awbNo
     * @param shipWt
     * @param shipVol
     * @param fltWt
     * @param fltVol
     * @param changeGroup: not read from data sheet
     * @return
     */
    public CAP103 verifyNewVersionWithDtls(String awbPre, String awbNo, String shipWt, String shipVol, String fltWt, String fltVol, String... changeGroups) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        shipWt = PropertyHandler.getPropValue(dataFilePath, shipWt);
        shipVol = PropertyHandler.getPropValue(dataFilePath, shipVol);
        fltWt = PropertyHandler.getPropValue(dataFilePath, fltWt);
        fltVol = PropertyHandler.getPropValue(dataFilePath, fltVol);

        enterKeys(txt_awbPrefix, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();

        Assert.assertEquals(tblGetTextByColValue(tbl_historyDtls, 8, 1, "2").trim(), shipWt, "The shipment weight is not matching for AWBno: " + awbNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_historyDtls, 9, 1, "2").trim(), shipVol, "The shipment volume is not matching for AWBno: " + awbNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_historyDtls, 16, 1, "2").trim(), fltWt, "The flight weight is not matching for AWBno: " + awbNo);
        Assert.assertEquals(tblGetTextByColValue(tbl_historyDtls, 17, 1, "2").trim(), fltVol, "The flight weight is not matching for AWBno: " + awbNo);

        for (String chngGrp : changeGroups) {
            Assert.assertEquals(tblGetTextByColValue(tbl_historyDtls, 31, 1, "2").trim().toUpperCase().contains(changeGroups[0].toUpperCase()), true, "The change group is not matching for AWBno: " + awbNo);
            Assert.assertEquals(tblGetTextByColValue(tbl_historyDtls, 31, 1, "2").trim().toUpperCase().contains(changeGroups[1].toUpperCase()), true, "The change group is not matching for AWBno: " + awbNo);
        }

        return this;
    }


}