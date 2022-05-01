package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * iCargo_RD_ST_OPS_Warehouse Shipment Enquiry Screen : WHS011
 *
 * @author a-7868 on 19/01/2018
 */
public class WHS011 extends BasePage {


    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "WHS_TRC.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameWHS011";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By txt_awbPre,
            txt_awbNo,
            txt_location,
            btn_list,
            tbl_shipmentDtls,
            btn_close,
            btn_clear,
            yesBtn,
            dropdown_flightDirection,
            txt_flightCarrierCode,
            txt_flightNo,
            txt_flightDate,
            dropdown_warehouse,
            lnk_nextPage,
            txt_fromDate,
            txt_toDate,
            dropDown_shipType,
            txt_dwellTimeMin,
            btn_shipRelocation,
            btn_grpRelocation,
            txt_grpRelocateLoc,
            btn_grpRelocateOk,
            btn_grpRelocateClose,
            btn_SURelocation,
            txt_SURelocateLoc,
            btn_SURelocateSave,
            btn_SURelocateClose,
            btn_abandonShipment,
            btn_whLock,
            chkbx_selctData,
            txt_whLockRemarks,
            btn_whLockOk,
            btn_markIRP,
            chkbx_allowEmptySU,
            txt_hawb;

    private By info_error,
            btn_genericOk;

    public WHS011(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    /**
     * Method to initialize page objects
     * 19/01/2018
     *
     * @author a-7868 Krishna
     */
    private void initElements() {

        txt_location = MiscUtility.getWebElement(objFilepath, "WHS011_txt_location");
        txt_awbPre = MiscUtility.getWebElement(objFilepath, "WHS011_txt_awbPre");
        txt_awbNo = MiscUtility.getWebElement(objFilepath, "WHS011_txt_awbNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "WHS011_btn_list");
        btn_close = MiscUtility.getWebElement(objFilepath, "WHS011_btn_close");
        btn_clear = MiscUtility.getWebElement(objFilepath, "WHS011_btn_clear");
        tbl_shipmentDtls = MiscUtility.getWebElement(objFilepath, "WHS011_tbl_shipmentDtls");
        txt_fromDate = MiscUtility.getWebElement(objFilepath, "WHS011_txt_fromDate");
        txt_toDate = MiscUtility.getWebElement(objFilepath, "WHS011_txt_toDate");
        dropDown_shipType = MiscUtility.getWebElement(objFilepath, "WHS011_dropDown_shipType");
        txt_dwellTimeMin = MiscUtility.getWebElement(objFilepath, "WHS011_txt_dwellTimeMin");
        btn_shipRelocation = MiscUtility.getWebElement(objFilepath, "WHS011_btn_shipRelocation");
        btn_grpRelocation = MiscUtility.getWebElement(objFilepath, "WHS011_btn_grpRelocation");
        txt_grpRelocateLoc = MiscUtility.getWebElement(objFilepath, "WHS011_txt_grpRelocateLoc");
        btn_grpRelocateOk = MiscUtility.getWebElement(objFilepath, "WHS011_btn_grpRelocateOk");
        btn_grpRelocateClose = MiscUtility.getWebElement(objFilepath, "WHS011_btn_grpRelocateClose");
        btn_SURelocation = MiscUtility.getWebElement(objFilepath, "WHS011_btn_SURelocation");
        txt_SURelocateLoc = MiscUtility.getWebElement(objFilepath, "WHS011_txt_SURelocateLoc");
        btn_SURelocateSave = MiscUtility.getWebElement(objFilepath, "WHS011_btn_SURelocateSave");
        btn_SURelocateClose = MiscUtility.getWebElement(objFilepath, "WHS011_btn_SURelocateClose");
        btn_abandonShipment = MiscUtility.getWebElement(objFilepath, "WHS011_btn_abandonShipment");
        btn_whLock = MiscUtility.getWebElement(objFilepath, "WHS011_btn_whLock");
        txt_whLockRemarks = MiscUtility.getWebElement(objFilepath, "WHS011_txt_whLockRemarks");
        btn_whLockOk = MiscUtility.getWebElement(objFilepath, "WHS011_btn_whLockOk");
        btn_markIRP = MiscUtility.getWebElement(objFilepath, "WHS011_btn_markIRP");
        chkbx_allowEmptySU = MiscUtility.getWebElement(objFilepath, "WHS011_chkbx_allowEmptySU");
        chkbx_selctData=MiscUtility.getWebElement(objFilepath, "WHS011_chkbx_selctData");

        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        dropdown_flightDirection = MiscUtility.getWebElement(objFilepath, "WHS011_dropdown_flightDirection");
        txt_flightCarrierCode = MiscUtility.getWebElement(objFilepath, "WHS011_txt_flightCarrierCode");
        txt_flightNo = MiscUtility.getWebElement(objFilepath, "WHS011_txt_flightNo");
        txt_flightDate = MiscUtility.getWebElement(objFilepath, "WHS011_txt_flightDate");
        dropdown_warehouse = MiscUtility.getWebElement(objFilepath, "WHS011_dropdown_warehouse");
        lnk_nextPage = MiscUtility.getWebElement(objFilepath, "WHS011_lnk_nextPage");
        txt_hawb = MiscUtility.getWebElement(objFilepath, "WHS011_txt_hawb");
    }

    /**
     * Method to list a specific AWB using AWB and Location
     *
     * @param loc
     * @param awbPre
     * @param awbNo
     * @author a-7868 Krishna <19/01/2018>
     */
    private void listAWB(String loc, String awbPre, String awbNo) {
        if (loc != null && loc.trim().length() > 0)
          //  enterKeys(txt_location, loc);
        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();

    }

    /**
     * Method to list a specific AWB and check whether the corresponding details are present in iCargo_RD_ST_OPS_Warehouse
     *
     * @param location
     * @param awbPre
     * @param awbNo
     * @param pcs
     * @param wt
     * @param sUnit    (value can be <uld number> or <""> while calling the method)
     * @param chkBoth  (should be true when both loose and uld is present for an awb in same location)
     * @author a-7868 Krishna <19/01/2018>
     */
    public WHS011 verifyShipmentInWarehouse(String location, String awbPre, String awbNo, String pcs, String wt, String sUnit, boolean chkBoth) {

        location = PropertyHandler.getPropValue(dataFilePath, location);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        if (!pcs.equals(""))
            pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        if (!wt.equals(""))
            wt = PropertyHandler.getPropValue(dataFilePath, wt);
        if (sUnit.equals(""))
            sUnit = "DEFAULT";
        else
            sUnit = PropertyHandler.getPropValue(dataFilePath, sUnit);

        listAWB(location, awbPre, awbNo);

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_shipmentDtls, 5, awbNo), "ERROR : AWB not listed in WHS011");
        
        int total=0;
        if (!pcs.equals("")){
        	List<String> totPcs = getTableColumnValues(tbl_shipmentDtls, 8);
        	for(String temp : totPcs)
        		total += Integer.parseInt(temp);        	
        	Assert.assertTrue(String.valueOf(total).equals(pcs), "ERROR : Incorrect shipment pcs listed in WHS011");
        }
        
        total = 0;
        if (!wt.equals("")){
        	List<String> totWt = getTableColumnValues(tbl_shipmentDtls, 9);
        	for(String temp : totWt)
        		total += Integer.parseInt(temp);  
        	Assert.assertTrue(String.valueOf(total).equals(wt), "ERROR : Incorrect shipment wt listed in WHS011");
        }
           

        if (chkBoth) {
            Assert.assertTrue(getTableColumnValues(tbl_shipmentDtls, 4).contains(sUnit), "ERROR : ULD not listed");
            Assert.assertTrue(getTableColumnValues(tbl_shipmentDtls, 4).contains("DEFAULT"), "ERROR : LOOSE acc not listed");
        } else
            Assert.assertTrue(getTableCellValue(tbl_shipmentDtls, 4, 1).contains(sUnit), "ERROR : Incorrect shipment SU listed in WHS011");

//		click(btn_clear);

        return this;
    }

    /***
     * Checking the error msg while listing AWB
     * @param location
     * @param awbPre
     * @param awbNo
     * @return
     *A-6784**/
    public WHS011 verifyErrorNoRecord(String location, String awbPre, String awbNo) {
    	
    	location=PropertyHandler.getPropValue(dataFilePath, location);
    	awbPre=PropertyHandler.getPropValue(dataFilePath, awbPre);
    	awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);

        listAWB(location, awbPre, awbNo);
        minWait();
        Assert.assertFalse(isElementPresent(chkbx_selctData));
        Assert.assertEquals(getTableRowCount(tbl_shipmentDtls), 0);
        minWait();
        return this;

    }

    /**
     * This method will verify pcs and weight in the wharehouse of an AWB
     *
     * @param flightDirection:  Not read from data sheet
     * @param flightCarrierCode
     * @param flightNo
     * @param flightDate
     * @param awbPrefix
     * @param awbNo
     * @param pieces
     * @param weight
     * @return
     */
    public WHS011 verifyShipmentInWarehouseBasedOnFlight(String flightDirection, String flightCarrierCode, String flightNo, String flightDate,
                                                         String awbPrefix, String awbNo, String pieces, String weight) {

        flightCarrierCode = PropertyHandler.getPropValue(dataFilePath, flightCarrierCode);
        flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
        flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
        weight = PropertyHandler.getPropValue(dataFilePath, weight);

        String fullAWBNo = awbPrefix + " - " + awbNo;
        selectByText(waitForElement(dropdown_flightDirection), flightDirection);
        enterKeys(txt_flightCarrierCode, flightCarrierCode);
        enterKeys(txt_flightNo, flightNo);
        enterKeys(txt_flightDate, flightDate);
        click(btn_list);
        minWait();
        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_shipmentDtls, 5, awbNo), "The shipment " + awbNo + " is not present in the table.");
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 8, 5, fullAWBNo).trim(), pieces);
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 9, 5, fullAWBNo).trim(), weight);
        return this;
    }

    /**
     * Created by A-7605
     * This method will clear the user selected values
     *
     * @return
     */
    public WHS011 clear() {
        waitForElement(btn_close);
        minWait();
        Actions action = new Actions(driver);
        action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();
        minWait();

        return this;
    }

    /**
     * Created by A-7605 on 12-2-18
     * This method filter result based on warehouse and verify pcs and weight in the warehouse of the given awb
     *
     * @param warehouse
     * @param awbPrefix
     * @param awbNo
     * @param pieces
     * @param weight
     * @return
     */
    public WHS011 verifyShipmentInWarehouseBasedOnWarehouse(String warehouse, String awbPrefix, String awbNo, String pieces, String weight) {
        boolean isFound = false;
        boolean isLastPage = false;
        warehouse = PropertyHandler.getPropValue(dataFilePath, warehouse);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
        weight = PropertyHandler.getPropValue(dataFilePath, weight);
        String fullAWBNo = awbPrefix + " - " + awbNo;
        selectByText(waitForElement(dropdown_warehouse), warehouse);
        click(btn_list);
        minWait();
        do {
            if (verifyElementPresent(lnk_nextPage))
                isLastPage = true;
            if (verifyValuePresentInTblColumn(tbl_shipmentDtls, 5, fullAWBNo)) {
                Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 8, 5, fullAWBNo), pieces);
                Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 9, 5, fullAWBNo), weight);
                isFound = true;
            }
            if (isFound || isLastPage)
                break;
            click(lnk_nextPage);
            minWait();
        } while (isLastPage);
        Assert.assertTrue(isFound);
        return this;
    }

    /**
     * Verifies shipment present in the date range
     *
     * @param loc
     * @param awbNos: can be more than one awbNo
     * @return
     * @author Arun A-7681
     */
    public WHS011 verifyShipmentBasedOnDate(String loc, String... awbNos) {

        loc = PropertyHandler.getPropValue(dataFilePath, loc);

        enterKeys(txt_location, loc);
        enterKeys(txt_fromDate, ".");
        enterKeys(txt_toDate, ".");
        click(btn_list);
        minWait();
        for (String awbNo : awbNos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_shipmentDtls, 5, awbNo), "The shipment " + awbNo + " is not present in the table.");
        }

        return this;
    }

    /**
     * relocates one or more awbs from a location
     *
     * @param loc
     * @param awbnos can be one or more awbNos
     * @return
     * @author Arun A-7681
     */
    public WHS011 grpRelocateAWBsFromLoc(String loc, String newLoc, boolean errChk, String error, String... awbnos) {

        loc = PropertyHandler.getPropValue(dataFilePath, loc);
        newLoc = PropertyHandler.getPropValue(dataFilePath, newLoc);
        if (!error.equals("")) {
            error = PropertyHandler.getPropValue(dataFilePath, error);
        }

        enterKeys(txt_location, loc);
        enterKeys(txt_fromDate, ".");
        enterKeys(txt_toDate, ".");
        click(btn_list);
        minWait();

        for (String awbNo : awbnos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            tblSelectRowByColValue(tbl_shipmentDtls, 1, 5, awbNo);
        }

        click(btn_grpRelocation);
        switchToSecondWindow();

        enterKeys(txt_grpRelocateLoc, newLoc);

        click(btn_grpRelocateOk);
        if (errChk) {
            Assert.assertTrue(waitForElement(info_error).getText().contains(error), "The error is not displayed");
            click(btn_grpRelocateClose);
        }
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        return this;

    }


    /**
     * Checks error when trying to relocate a AWB without SU
     *
     * @param loc
     * @param awbnos can be one or more awbNos
     * @return
     * @author Arun A-7681
     */
    public WHS011 SURelocateAWBsFromLocError(String loc, String... awbnos) {

        loc = PropertyHandler.getPropValue(dataFilePath, loc);

        enterKeys(txt_location, loc);
        enterKeys(txt_fromDate, ".");
        enterKeys(txt_toDate, ".");
        click(btn_list);
        minWait();

        for (String awbNo : awbnos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            tblSelectRowByColValue(tbl_shipmentDtls, 1, 5, awbNo);
        }

        click(btn_SURelocation);

        Assert.assertTrue(waitForElement(info_error).getText().contains("No Storage Units for relocation"), "The SU error is not displayed");

        return this;

    }

    /**
     * relocates one or more awbs from a location
     *
     * @param loc
     * @param awbnos can be one or more awbNos
     * @return
     * @author Arun A-7681
     */
    public WHS011 SURelocateAWBsFromLoc(String loc, String newLoc, boolean errChk, String error, String... awbnos) {

        loc = PropertyHandler.getPropValue(dataFilePath, loc);
        newLoc = PropertyHandler.getPropValue(dataFilePath, newLoc);
        if (!error.equals("")) {
            error = PropertyHandler.getPropValue(dataFilePath, error);
        }

        enterKeys(txt_location, loc);
        enterKeys(txt_fromDate, ".");
        enterKeys(txt_toDate, ".");
        click(btn_list);
        minWait();

        for (String awbNo : awbnos) {
            awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
            tblSelectRowByColValue(tbl_shipmentDtls, 1, 5, awbNo);
        }

        click(btn_SURelocation);
        switchToSecondWindow();

        enterKeys(txt_SURelocateLoc, newLoc);

        click(btn_SURelocateSave);
        if (errChk) {
            Assert.assertTrue(waitForElement(info_error).getText().contains(error), "The error is not displayed");
            click(btn_SURelocateClose);
        } else {
            click(btn_genericOk);
        }
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        return this;

    }

    /**
     * Verifies shipment present by sipment type
     *
     * @param awbNo
     * @param loc
     * @param shipType: Not read from Property file
     * @return
     * @author Arun A-7681
     */
    public WHS011 verifyShipmentBasedShipmentType(String awbNo, String loc, String shipType) {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        loc = PropertyHandler.getPropValue(dataFilePath, loc);

        enterKeys(txt_location, loc);
        enterKeys(txt_fromDate, ".");
        enterKeys(txt_toDate, ".");
        selectByText(dropDown_shipType, shipType);
        click(btn_list);
        minWait();
        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_shipmentDtls, 5, awbNo), "The shipment " + awbNo + " is not present in the table.");

        return this;
    }

    /**
     * Verifies shipment present by dwell time on two min
     *
     * @param awbNo
     * @param loc
     * @return
     * @author Arun A-7681
     */
    public WHS011 verifyShipmentBasedOnDwellTime(String awbNo, String loc) throws InterruptedException {

        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        loc = PropertyHandler.getPropValue(dataFilePath, loc);

        enterKeys(txt_location, loc);
        enterKeys(txt_fromDate, ".");
        enterKeys(txt_toDate, ".");
        enterKeys(txt_dwellTimeMin, "2");
        click(btn_list);
        minWait();
        Assert.assertFalse(verifyValuePresentInTblColumn(tbl_shipmentDtls, 5, awbNo), "The shipment " + awbNo + " is present in the table before dwell time of 2 min.");

        Thread.sleep(130000);
        Actions action = new Actions(driver);
        action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();
        minWait();

        enterKeys(txt_location, loc);
        enterKeys(txt_fromDate, ".");
        enterKeys(txt_toDate, ".");
        enterKeys(txt_dwellTimeMin, "2");
        click(btn_list);
        minWait();
        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_shipmentDtls, 5, awbNo), "The shipment " + awbNo + " is not present in the table after dwell time of 2 min.");

        return this;
    }

    public WHS011 markAsWHLock(String awbPre, String awbNo, String location) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        location = PropertyHandler.getPropValue(dataFilePath, location);

        listAWB(location, awbPre, awbNo);

        tblSelectRowByMultipleColValue(tbl_shipmentDtls, 1, 3, 5, location, awbNo);
        click(btn_whLock);

        switchToSecondWindow();
        enterKeys(txt_whLockRemarks, "By automation");
        click(btn_whLockOk);
        switchToFirstWindow();

        return this;
    }

    /**
     * Relocates a shipment by navigating to Screen WHS009
     *
     * @param awbPre
     * @param awbNo
     * @param location
     * @return
     * @author A-7681 Arun
     */
    public WHS009 shipmentRelocation(String awbPre, String awbNo, String location) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        location = PropertyHandler.getPropValue(dataFilePath, location);

        listAWB(location, awbPre, awbNo);

        tblSelectRowByMultipleColValue(tbl_shipmentDtls, 1, 3, 5, location, awbNo);
        click(btn_shipRelocation);

        return new WHS009(driver, dataFileName);
    }


    /**
     * lists empty SUs
     *
     * @return
     * @author A-7681 Arun
     */
    public WHS011 listEmptySUs() {

        check(chkbx_allowEmptySU);
        click(btn_list);
        minWait();

        Assert.assertTrue(tblGetTextByColValue(tbl_shipmentDtls,5,2,"TRVWHS").trim().isEmpty(),"The result is not showing empty SUs");

        return this;
    }



    /**
     * Abandons a shipment by navigating to Screen WHS010
     *
     * @param awbPre
     * @param awbNo
     * @param location
     * @return
     * @A-7681 Arun
     */
    public WHS010 abandonShipment(String awbPre, String awbNo, String location) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        location = PropertyHandler.getPropValue(dataFilePath, location);

        listAWB(location, awbPre, awbNo);

        tblSelectRowByMultipleColValue(tbl_shipmentDtls, 1, 3, 5, location, awbNo);
        click(btn_abandonShipment);

        return new WHS010(driver, dataFileName);
    }

    public WHS011 markIRP(String awbPre, String awbNo, String location) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        location = PropertyHandler.getPropValue(dataFilePath, location);

        listAWB(location, awbPre, awbNo);

        tblSelectRowByMultipleColValue(tbl_shipmentDtls, 1, 3, 5, location, awbNo);
        click(btn_markIRP);

        return this;
    }

    /**
     * Method to close current page and return to Homepae
     * returns the instance of Homepage
     *
     * @return
     * @author a-7868 Krishna <19-01-2018>
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn))
            click(yesBtn);
        return new HomePage(driver, dataFileName);
    }
    
  /**
   * Checking the error msg while listing AWB
   * @param location
   * @param awbPre
   * @param awbNo
   * @param hawb
   * @return
   */
    public WHS011 verifyErrorNoRecord_HAWB(String location, String awbPre, String awbNo, String hawb) {
    	
    	location=PropertyHandler.getPropValue(dataFilePath, location);
    	awbPre=PropertyHandler.getPropValue(dataFilePath, awbPre);
    	awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
    	hawb=PropertyHandler.getPropValue(dataFilePath, hawb);

    	if (location != null && location.trim().length() > 0)
            //  enterKeys(txt_location, loc);
          enterKeys(txt_awbPre, awbPre);
          enterKeys(txt_awbNo, awbNo);
          enterKeys(txt_hawb, hawb);
          click(btn_list);
          minWait();
        Assert.assertFalse(isElementPresent(chkbx_selctData));
        Assert.assertEquals(getTableRowCount(tbl_shipmentDtls), 0);
        minWait();
        return this;

    }
    
    /**
     * Method to list a specific AWB and check whether the corresponding details are present in iCargo_RD_ST_OPS_Warehouse
     *
     *	@param hawb
     * @param location
     * @param awbPre
     * @param awbNo
     * @param pcs
     * @param wt
     * @param sUnit    (value can be <uld number> or <""> while calling the method)
     * @param chkBoth  (should be true when both loose and uld is present for an awb in same location)
     * @author a-7605
     */
    public WHS011 verifyShipmentInWarehouse_HAWB(String hawb,String location, String awbPre, String awbNo, String pcs, String wt, String sUnit, boolean chkBoth) {

        location = PropertyHandler.getPropValue(dataFilePath, location);
        hawb = PropertyHandler.getPropValue(dataFilePath, hawb);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        if (!pcs.equals(""))
            pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        if (!wt.equals(""))
            wt = PropertyHandler.getPropValue(dataFilePath, wt);
        if (sUnit.equals(""))
            sUnit = "DEFAULT";
        else
            sUnit = PropertyHandler.getPropValue(dataFilePath, sUnit);

        if (location != null && location.trim().length() > 0)
            //  enterKeys(txt_location, loc);
          enterKeys(txt_awbPre, awbPre);
          enterKeys(txt_awbNo, awbNo);
          enterKeys(txt_hawb, hawb);
          click(btn_list);
          minWait();

        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_shipmentDtls, 5, awbNo), "ERROR : AWB not listed in WHS011");
        if (!pcs.equals(""))
            Assert.assertTrue(getTableCellValue(tbl_shipmentDtls, 8, 1).contains(pcs), "ERROR : Incorrect shipment pcs listed in WHS011");
        if (!wt.equals(""))
            Assert.assertTrue(getTableCellValue(tbl_shipmentDtls, 9, 1).contains(wt), "ERROR : Incorrect shipment wt listed in WHS011");

        if (chkBoth) {
            Assert.assertTrue(getTableColumnValues(tbl_shipmentDtls, 4).contains(sUnit), "ERROR : ULD not listed");
            Assert.assertTrue(getTableColumnValues(tbl_shipmentDtls, 4).contains("DEFAULT"), "ERROR : LOOSE acc not listed");
        } else
            Assert.assertTrue(getTableCellValue(tbl_shipmentDtls, 4, 1).contains(sUnit), "ERROR : Incorrect shipment SU listed in WHS011");

//		click(btn_clear);

        return this;
    }
    
    /**
     * Created by A-7605 on 27-4-18
     * This method filter result based on AWB and verify pcs and weight in the warehouse of the given awb
     *
     * @param awbPrefix
     * @param awbNo
     * @param pieces
     * @param weight
     * @return
     */
    public WHS011 verifyShipmentInWarehouseBasedOnAWB(String awbPrefix, String awbNo, String pieces, String weight, String location) {
        boolean isFound = false;
        boolean isLastPage = false;
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
        weight = PropertyHandler.getPropValue(dataFilePath, weight);
        location = PropertyHandler.getPropValue(dataFilePath, location);
        String fullAWBNo = awbPrefix + " - " + awbNo;
        
        enterKeys(txt_awbPre, awbPrefix);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();
        do {
            if (verifyElementPresent(lnk_nextPage))
                isLastPage = true;
            if (verifyValuePresentInTblColumn(tbl_shipmentDtls, 5, fullAWBNo)) {
                Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 8, 5, fullAWBNo), pieces);
                Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 9, 5, fullAWBNo), weight);
                Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 3, 5, fullAWBNo), location);
                isFound = true;
            }
            if (isFound || isLastPage)
                break;
            click(lnk_nextPage);
            minWait();
        } while (isLastPage);
        Assert.assertTrue(isFound);
        return this;
    }
    /**
     * Created by A-7605 on 27-4-18
     * This method filter result based on AWB and verify pcs and weight in the warehouse of the given awb that contains 3 ULDs
     * @param awbPrefix
     * @param awbNo
     * @param pieces1
     * @param weight1
     * @param location1
     * @param storageUnit1
     * @param pieces2
     * @param weight2
     * @param location2
     * @param storageUnit2
     * @param pieces3
     * @param weight3
     * @param location3
     * @param storageUnit3
     * @return
     */
    public WHS011 verifyShipmentInWarehouseBasedOnAWBContainingThreeULDs(String awbPrefix, String awbNo, String pieces1, String weight1, String location1, String storageUnit1,
    		String pieces2, String weight2, String location2, String storageUnit2,String pieces3, String weight3, String location3, String storageUnit3) {

        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        pieces1 = PropertyHandler.getPropValue(dataFilePath, pieces1);
        weight1 = PropertyHandler.getPropValue(dataFilePath, weight1);
        location1 = PropertyHandler.getPropValue(dataFilePath, location1);
        storageUnit1 = PropertyHandler.getPropValue(dataFilePath, storageUnit1);
        
        pieces2 = PropertyHandler.getPropValue(dataFilePath, pieces2);
        weight2 = PropertyHandler.getPropValue(dataFilePath, weight2);
        location2 = PropertyHandler.getPropValue(dataFilePath, location2);
        storageUnit2 = PropertyHandler.getPropValue(dataFilePath, storageUnit2);
        
        pieces3 = PropertyHandler.getPropValue(dataFilePath, pieces3);
        weight3 = PropertyHandler.getPropValue(dataFilePath, weight3);
        location3 = PropertyHandler.getPropValue(dataFilePath, location3);
        storageUnit3 = PropertyHandler.getPropValue(dataFilePath, storageUnit3);
        
        String fullAWBNo = awbPrefix + " - " + awbNo;
        
        enterKeys(txt_awbPre, awbPrefix);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();

        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 8, 4, storageUnit1), pieces1);
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 9, 4, storageUnit1), weight1);
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 3, 4, storageUnit1), location1);
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 5, 4, storageUnit1), fullAWBNo);
        
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 8, 4, storageUnit2), pieces2);
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 9, 4, storageUnit2), weight2);
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 3, 4, storageUnit2), location2);
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 5, 4, storageUnit2), fullAWBNo);
        
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 8, 4, storageUnit3), pieces3);
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 9, 4, storageUnit3), weight3);
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 3, 4, storageUnit3), location3);
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 5, 4, storageUnit3), fullAWBNo);
        return this;
    }

    /**
     * Created by A-7605 on 4-5-18
     * This method verify the remaining pcs/wgt in the warehouse after partial delivery
     * @param awbPrefix
     * @param awbNo
     * @param house
     * @param location
     * @param totalPcsBeforeDelivery
     * @param totalWeightBeforeDelivery
     * @param deliveredPcs
     * @param deliveredWeight
     * @param fromDate
     * @param toDate
     * @return
     */
    public WHS011 verifyRemainingPcsInWarehouseLocation(String awbPrefix, String awbNo, String house, String location, String totalPcsBeforeDelivery, String totalWeightBeforeDelivery,
    		String deliveredPcs, String deliveredWeight,String fromDate,String toDate){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	totalPcsBeforeDelivery = PropertyHandler.getPropValue(dataFilePath, totalPcsBeforeDelivery);
    	totalWeightBeforeDelivery = PropertyHandler.getPropValue(dataFilePath, totalWeightBeforeDelivery);
    	deliveredPcs = PropertyHandler.getPropValue(dataFilePath, deliveredPcs);
    	deliveredWeight = PropertyHandler.getPropValue(dataFilePath, deliveredWeight);
    	house = PropertyHandler.getPropValue(dataFilePath, house);
    	fromDate = PropertyHandler.getPropValue(dataFilePath, fromDate);
    	toDate = PropertyHandler.getPropValue(dataFilePath, toDate);
    	
    	enterKeys(txt_awbPre, awbPrefix);
        enterKeys(txt_awbNo, awbNo);
        enterKeys(txt_location, location);
        enterKeys(txt_fromDate, fromDate);
        enterKeys(txt_toDate, toDate);
        if (house != null && house.trim().length()>0)
        	enterKeys(txt_hawb, house);
        click(btn_list);
        minWait();
        String expectedPcsInLocation = String.valueOf(Integer.parseInt(totalPcsBeforeDelivery) - Integer.parseInt(deliveredPcs));
        String expectedWgtInLocation = String.valueOf(Integer.parseInt(totalWeightBeforeDelivery) - Integer.parseInt(deliveredWeight));
        
        Assert.assertEquals(getTableCellValue(tbl_shipmentDtls, 8, 1), expectedPcsInLocation);
        Assert.assertEquals(getTableCellValue(tbl_shipmentDtls, 9, 1), expectedWgtInLocation);
        return this;
    }
    
    /**
     * Created by A-7605 on 22-5-18
     * This method verify pcs and weight in warehouse location against each ULD/SU
     * @param location
     * @param awbPrefix
     * @param awbNo
     * @param uldNo1
     * @param pieces1
     * @param weight1
     * @param uldNo2
     * @param pieces2
     * @param weight2
     * @param uldNo3
     * @param pieces3
     * @param weight3
     * @return
     */
    public WHS011 verifyShipmentInWarehouse_3ULDsInSingleAWB(String location, String awbPrefix, String awbNo,String uldNo1, String pieces1, String weight1,String uldNo2, String pieces2, String weight2,String uldNo3, String pieces3, String weight3) {

        location = PropertyHandler.getPropValue(dataFilePath, location);
        awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        uldNo1 = PropertyHandler.getPropValue(dataFilePath, uldNo1);
        pieces1 = PropertyHandler.getPropValue(dataFilePath, pieces1);
        weight1 = PropertyHandler.getPropValue(dataFilePath, weight1);
        uldNo2 = PropertyHandler.getPropValue(dataFilePath, uldNo2);
        pieces2 = PropertyHandler.getPropValue(dataFilePath, pieces2);
        weight2 = PropertyHandler.getPropValue(dataFilePath, weight2);
        uldNo3 = PropertyHandler.getPropValue(dataFilePath, uldNo3);
        pieces3 = PropertyHandler.getPropValue(dataFilePath, pieces3);
        weight3 = PropertyHandler.getPropValue(dataFilePath, weight3);

        listAWB(location, awbPrefix, awbNo);
        
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 8, 4, uldNo1), pieces1,"Actual pieces in warehouse is '"+tblGetTextByColValue(tbl_shipmentDtls, 8, 4, uldNo1)+"' and expected is '"+pieces1+"'");
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 9, 4, uldNo1), weight1,"Actual weight in warehouse is '"+tblGetTextByColValue(tbl_shipmentDtls, 9, 4, uldNo1)+"' and expected is '"+weight1+"'");
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 8, 4, uldNo2), pieces2,"Actual pieces in warehouse is '"+tblGetTextByColValue(tbl_shipmentDtls, 8, 4, uldNo2)+"' and expected is '"+pieces2+"'");
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 9, 4, uldNo2), weight2,"Actual weight in warehouse is '"+tblGetTextByColValue(tbl_shipmentDtls, 9, 4, uldNo2)+"' and expected is '"+weight2+"'");
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 8, 4, uldNo3), pieces3,"Actual pieces in warehouse is '"+tblGetTextByColValue(tbl_shipmentDtls, 8, 4, uldNo3)+"' and expected is '"+pieces3+"'");
        Assert.assertEquals(tblGetTextByColValue(tbl_shipmentDtls, 9, 4, uldNo3), weight3,"Actual weight in warehouse is '"+tblGetTextByColValue(tbl_shipmentDtls, 9, 4, uldNo3)+"' and expected is '"+weight3+"'");       
        return this;
    }
}
