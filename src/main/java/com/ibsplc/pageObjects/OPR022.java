package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-6545 on 21/12/2017.
 */
public class OPR022 extends BasePage {


    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameOPR022";
    public String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    By

            btn_list,
            txt_awbNo,
            txt_awbPrefix,
            List_looseShipmentWarehous,
            txt_looseShipmentLocation,
            txt_looseShipmentPieces,
            txt_looseShipmentWeight,
            Checkbox_AllpartsReceived,
            Btn_Savebutton,
            btn_save,
            btn_close,
            info_FinalizedStatus,
            yesBtn,
            noBtn,
            txt_ULDShipmentULDNo,
            List_ULDShipmentWarehouse,
            txt_ULDShipmentLocation,
            txt_ULDShipmentPieces,
            txt_ULDShipmentWeight,
            Btn_SecurityAndScreening,
            SecurityAndScreening_ShipmentDetails_Inbx_SCC,
            SecurityAndScreening_Btn_Ok,
            Btn_EnterHAWBDetails,
            HAWBDetails_Btn_Add,
            HAWBDetails_txt_HAWB1,
            HAWBDetails_txt_StatedPcs1,
            HAWBDetails_txt_StatedWgt1,
            HAWBDetails_txt_Pcs1,
            HAWBDetails_txt_Wgt1,
            HAWBDetails_txt_HAWB2,
            HAWBDetails_txt_StatedPcs2,
            HAWBDetails_txt_StatedWgt2,
            HAWBDetails_txt_Pcs2,
            HAWBDetails_txt_Wgt2,
            HAWBDetails_Btn_Ok,
            btn_genericYes,
            msg_popup,
            chkBx_givenSecStatus,
            btn_addRow,
            dropDown_screenMethod,
            txt_screeningPcs,
            txt_screeningWt,
            dropDown_result,
    btn_clear;


    WebDriver driver;
    String testDataFile;
    String browser;

    public OPR022(WebDriver driver, String testDataFile) {
        super(driver);
        this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver, this);
        this.dataFilePath = dataFilePath + testDataFile;
        initPageElements();
    }

    private void initPageElements() {
        // TODO Auto-generated method stub
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR022_Btn_List");
        txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR022_txt_AWBNo");
        List_looseShipmentWarehous = MiscUtility.getWebElement(objFilepath, "OPR022_List_looseShipmentWarehouse");
        txt_looseShipmentLocation = MiscUtility.getWebElement(objFilepath, "OPR022_txt_looseShipmentLocation");
        txt_looseShipmentPieces = MiscUtility.getWebElement(objFilepath, "OPR022_txt_looseShipmentPieces");
        txt_looseShipmentWeight = MiscUtility.getWebElement(objFilepath, "OPR022_txt_looseShipmentWeight");
        Checkbox_AllpartsReceived = MiscUtility.getWebElement(objFilepath, "OPR022_Checkbox_AllpartsReceived");
        btn_save = MiscUtility.getWebElement(objFilepath, "OPR022_Btn_Savebutton");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR022_Btn_Close");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");//MiscUtility.getWebElement(objFilepath,"CAP012_btn_yes");
        msg_popup = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_FinalizedStatus = MiscUtility.getWebElement(objFilepath, "OPR022_info_FinalizedStatus");
        txt_ULDShipmentULDNo = MiscUtility.getWebElement(objFilepath, "OPR022_txt_ULDShipmentULDNo");
        List_ULDShipmentWarehouse = MiscUtility.getWebElement(objFilepath, "OPR022_List_ULDShipmentWarehouse");
        txt_ULDShipmentLocation = MiscUtility.getWebElement(objFilepath, "OPR022_txt_ULDShipmentLocation");
        txt_ULDShipmentPieces = MiscUtility.getWebElement(objFilepath, "OPR022_txt_ULDShipmentPieces");
        txt_ULDShipmentWeight = MiscUtility.getWebElement(objFilepath, "OPR022_txt_ULDShipmentWeight");
        Btn_SecurityAndScreening = MiscUtility.getWebElement(objFilepath, "OPR022_Btn_SecurityAndScreening");
        SecurityAndScreening_ShipmentDetails_Inbx_SCC = MiscUtility.getWebElement(objFilepath, "OPR022_SecurityAndScreening_ShipmentDetails_txt_SCC");
        SecurityAndScreening_Btn_Ok = MiscUtility.getWebElement(objFilepath, "OPR022_SecurityAndScreening_Btn_Ok");
        Btn_EnterHAWBDetails = MiscUtility.getWebElement(objFilepath, "OPR022_Btn_EnterHAWBDetails");
        chkBx_givenSecStatus = MiscUtility.getWebElement(objFilepath, "OPR022_chkBx_givenSecStatus");
        btn_clear = MiscUtility.getWebElement(objFilepath, "OPR022_btn_clear");

        HAWBDetails_Btn_Add = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_Btn_Add");
        HAWBDetails_txt_HAWB1 = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_txt_HAWB1");
        HAWBDetails_txt_StatedPcs1 = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_txt_StatedPcs1");
        HAWBDetails_txt_StatedWgt1 = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_txt_StatedWgt1");
        HAWBDetails_txt_Pcs1 = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_txt_Pcs1");
        HAWBDetails_txt_Wgt1 = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_txt_Wgt1");
        HAWBDetails_txt_HAWB2 = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_txt_HAWB2");
        HAWBDetails_txt_StatedPcs2 = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_txt_StatedPcs2");
        HAWBDetails_txt_StatedWgt2 = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_txt_StatedWgt2");
        HAWBDetails_txt_Pcs2 = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_txt_Pcs2");
        HAWBDetails_txt_Wgt2 = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_txt_Wgt2");
        HAWBDetails_Btn_Ok = MiscUtility.getWebElement(objFilepath, "OPR022_HAWBDetails_Btn_Ok");

        btn_addRow	=	MiscUtility.getWebElement(objFilepath, "OPR022_btn_screening_addRow");
        dropDown_screenMethod=	MiscUtility.getWebElement(objFilepath, "OPR022_dropDown_screenMethod");
        txt_screeningPcs	=	MiscUtility.getWebElement(objFilepath, "OPR022_txt_screeningPcs");
        txt_screeningWt	=	MiscUtility.getWebElement(objFilepath, "OPR022_txt_screeningWt");
        dropDown_result	=	MiscUtility.getWebElement(objFilepath, "OPR022_dropDown_result");
        txt_awbPrefix	=	MiscUtility.getWebElement(objFilepath, "OPR022_txt_awbPrefix");
    }

    public OPR022 LooseAcceptance(String key_awbNo, String key_looseShipmentWarehous, String key_looseShipmentLocation,
                                  String key_looseShipmentPieces, String key_looseShipmentWeight, boolean finalizedcheck  ) {

        String data_awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
        String data_looseShipmentWarehous = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentWarehous);
        String data_looseShipmentLocation = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentLocation);
        String data_looseShipmentPieces = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentPieces);
        String data_looseShipmentWeight = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentWeight);



        enterKeys((txt_awbNo), data_awbNo);
        click(btn_list);
        minWait();
        selectByText(List_looseShipmentWarehous, data_looseShipmentWarehous);
        enterKeys(txt_looseShipmentLocation, data_looseShipmentLocation);
        enterKeys(txt_looseShipmentPieces, data_looseShipmentPieces);
        enterKeys(txt_looseShipmentWeight, data_looseShipmentWeight);
        check(Checkbox_AllpartsReceived);


        click(btn_save);
        driver.switchTo().defaultContent();
        //LAT popup
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }
        //saved popup
        if (verifyElementPresent(yesBtn)) {
        	Assert.assertTrue(waitForElement(msg_popup).getText().contains("has been successfully saved"), "ERROR : Save Acceptance Failed");
            click(yesBtn);
        }
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);

        if(finalizedcheck)
	        Assert.assertTrue(verifyElementPresent(info_FinalizedStatus), "ERROR : Finalized Status");
	        
        return this;
    }

    public OPR022 HouseAcceptance(String key_awbNo, String key_looseShipmentWarehous, String key_looseShipmentLocation,
                                  String key_looseShipmentPieces, String key_looseShipmentWeight, String key_No_Pieces_HAWB1, String key_No_Pieces_HAWB2, String key_Weight_HAWB1, String key_Weight_HAWB2, String key_HAWBNo, String key_HAWBNo2) {

        String data_awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
        String data_looseShipmentWarehous = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentWarehous);
        String data_looseShipmentLocation = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentLocation);
        String data_looseShipmentPieces = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentPieces);
        String data_looseShipmentWeight = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentWeight);
        String data_Weight_HAWB1 = PropertyHandler.getPropValue(dataFilePath, key_Weight_HAWB1);
        String data_No_Pieces_HAWB1 = PropertyHandler.getPropValue(dataFilePath, key_No_Pieces_HAWB1);
        String data_Weight_HAWB2 = PropertyHandler.getPropValue(dataFilePath, key_Weight_HAWB2);
        String data_No_Pieces_HAWB2 = PropertyHandler.getPropValue(dataFilePath, key_No_Pieces_HAWB2);
        String data_HAWBNo = PropertyHandler.getPropValue(dataFilePath, key_HAWBNo);
        String data_HAWBNo2 = PropertyHandler.getPropValue(dataFilePath, key_HAWBNo2);

        enterKeys((txt_awbNo), data_awbNo);
        click(btn_list);
        driver.switchTo().defaultContent();
        minWait();
        selectByText(List_looseShipmentWarehous, data_looseShipmentWarehous);
        enterKeys(txt_looseShipmentLocation, data_looseShipmentLocation);
        enterKeys(txt_looseShipmentPieces, data_looseShipmentPieces);
        enterKeys(txt_looseShipmentWeight, data_looseShipmentWeight);
        click(Btn_EnterHAWBDetails);
        minWait();
        driver.switchTo().defaultContent();
        waitForNewWindow(2);

        switchToSecondWindow();
        click(HAWBDetails_Btn_Add);
        minWait();
        enterKeys(HAWBDetails_txt_HAWB1, data_looseShipmentLocation);
        enterKeys(HAWBDetails_txt_StatedPcs1, data_looseShipmentLocation);
        enterKeys(HAWBDetails_txt_StatedWgt1, data_looseShipmentLocation);
        enterKeys(HAWBDetails_txt_Pcs1, data_looseShipmentLocation);
        enterKeys(HAWBDetails_txt_Wgt1, data_looseShipmentLocation);
        click(HAWBDetails_Btn_Add);
        minWait();
        enterKeys(HAWBDetails_txt_HAWB2, data_looseShipmentLocation);
        enterKeys(HAWBDetails_txt_StatedPcs2, data_looseShipmentLocation);
        enterKeys(HAWBDetails_txt_StatedWgt2, data_looseShipmentLocation);
        enterKeys(HAWBDetails_txt_Pcs2, data_looseShipmentLocation);
        enterKeys(HAWBDetails_txt_Wgt2, data_looseShipmentLocation);
        click(HAWBDetails_Btn_Ok);
        //switch back to main window
        minWait();
        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);
        check(Checkbox_AllpartsReceived);


        click(btn_save);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        Assert.assertTrue(verifyElementPresent(info_FinalizedStatus), "ERROR : Finalized Status");
//	        Assert.assertFalse(waitForElementVisible(info_FinalizedStatus).getText().contains("Not Finalized"), "ERROR : Finalized Status");

        //	Assert.assertNull(info_FinalizedStatus, "Finalized");
        return this;
    }

    public OPR022 Bulk_UldAcceptance(String key_awbNo, String key_looseShipmentWarehous, String key_looseShipmentLocation,
                                     String key_looseShipmentPieces, String key_looseShipmentWeight, String key_looseShipmentPieces2, String key_looseShipmentWeight2, String key_ULDtype, String key_Compcode, String key_UldNo) {

        String data_awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
        String data_looseShipmentWarehous = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentWarehous);
        String data_looseShipmentLocation = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentLocation);
        String data_looseShipmentPieces = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentPieces);
        String data_looseShipmentWeight = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentWeight);

        String data_looseShipmentPieces2 = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentPieces2);
        String data_looseShipmentWeight2 = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentWeight2);
        String data_ULDtype = PropertyHandler.getPropValue(dataFilePath, key_ULDtype);
        String data_Compcode = PropertyHandler.getPropValue(dataFilePath, key_Compcode);

        String UldNo ;
//        PropertyHandler.setPropValue(dataFilePath, key_UldNo, UldNo);

        enterKeys((txt_awbNo), data_awbNo);
        click(btn_list);

        selectByText(List_looseShipmentWarehous, data_looseShipmentWarehous);
        enterKeys(txt_looseShipmentLocation, data_looseShipmentLocation);
        enterKeys(txt_looseShipmentPieces, data_looseShipmentPieces);
        enterKeys(txt_looseShipmentWeight, data_looseShipmentWeight);
        //enterKeys(waitForElement(txt_awbNo), data_awbNo);

        minWait();
//        enterKeys(txt_ULDShipmentULDNo, UldNo);
//        enterKeys(txt_ULDShipmentULDNo, Keys.TAB);
//        driver.switchTo().defaultContent();
//        if (verifyElementPresent(yesBtn)) {
//            click(yesBtn);
//            //waitForFrameAndSwitch(FRAME);
//        }
        
        while (true) {
            UldNo = BizUtility.createULDNum(data_ULDtype, data_Compcode);

            enterKeys(txt_ULDShipmentULDNo, UldNo);
            // ((WebElement) txt_ULDShipmentULDNo).sendKeys("."+Keys.TAB);

            enterKeys(txt_ULDShipmentULDNo, Keys.TAB);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(yesBtn)) {
                click(yesBtn);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
        }
        PropertyHandler.setPropValue(dataFilePath, key_UldNo, UldNo);
        
        //waitForFrameAndSwitch(FRAME);
        selectByText(List_ULDShipmentWarehouse, data_looseShipmentWarehous);
        enterKeys(txt_ULDShipmentLocation, data_looseShipmentLocation);
        enterKeys(txt_ULDShipmentPieces, data_looseShipmentPieces2);
        enterKeys(txt_ULDShipmentWeight, data_looseShipmentWeight2);
        check(Checkbox_AllpartsReceived);

        click(btn_save);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }

        if (verifyElementPresent(yesBtn)) {

            Assert.assertTrue(waitForElementVisible(msg_popup).getText().contains("Blocked for Screening"), "ERROR : Screening required Popup");
            click(yesBtn);
            waitForFrameAndSwitch(FRAME);
        }
        String pcs = String.valueOf(Integer.parseInt(data_looseShipmentPieces) + Integer.parseInt(data_looseShipmentPieces2));
        String wt = String.valueOf(Integer.parseInt(data_looseShipmentWeight) + Integer.parseInt(data_looseShipmentWeight2));
        
        securityScreening(pcs,wt);
        click(btn_save);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        Assert.assertTrue(verifyElementPresent(info_FinalizedStatus), "ERROR : Finalized Status");
//	        Assert.assertFalse(waitForElementVisible(info_FinalizedStatus).getText().contains("Not Finalized"), "ERROR : Finalized Status");
        //Assert.assertNull(info_FinalizedStatus, "Finalized");
        return this;
    }

    public OPR022 UldAcceptance(String key_awbNo, String key_looseShipmentWarehous, String key_looseShipmentLocation,
                                String key_looseShipmentPieces, String key_looseShipmentWeight, String key_ULDtype, String key_Compcode, String key_UldNo) {

        String data_awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
        String data_looseShipmentWarehous = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentWarehous);
        String data_looseShipmentLocation = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentLocation);
        String data_looseShipmentPieces = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentPieces);
        String data_looseShipmentWeight = PropertyHandler.getPropValue(dataFilePath, key_looseShipmentWeight);
        String data_ULDtype = PropertyHandler.getPropValue(dataFilePath, key_ULDtype);
        String data_Compcode = PropertyHandler.getPropValue(dataFilePath, key_Compcode);
        String UldNo = null;

        enterKeys((txt_awbNo), data_awbNo);
        click(btn_list);
        minWait();

        while (true) {
            UldNo = BizUtility.createULDNum(data_ULDtype, data_Compcode);

            enterKeys(txt_ULDShipmentULDNo, UldNo);

            enterKeys(txt_ULDShipmentULDNo, Keys.TAB);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(yesBtn)) {
                click(yesBtn);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
        }

        PropertyHandler.setPropValue(dataFilePath, key_UldNo, UldNo);


//        switchToFirstWindow();
//        waitForFrameAndSwitch(FRAME);

        selectByText(List_ULDShipmentWarehouse, data_looseShipmentWarehous);
        enterKeys(txt_ULDShipmentLocation, data_looseShipmentLocation);
        enterKeys(txt_ULDShipmentPieces, data_looseShipmentPieces);
        enterKeys(txt_ULDShipmentWeight, data_looseShipmentWeight);
        check(Checkbox_AllpartsReceived);
        click(btn_save);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);

//       securityScreening(data_looseShipmentPieces, data_looseShipmentWeight);

        click(btn_save);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }
        //switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        Assert.assertTrue(verifyElementPresent(info_FinalizedStatus), "ERROR : Finalized Status");
//	        Assert.assertFalse(waitForElementVisible(info_FinalizedStatus).getText().contains("Not Finalized"), "ERROR : Finalized Status");
        //Assert.assertNull(info_FinalizedStatus, "Finalized");
        return this;
    }

    /*	##############Security and screening*/
    public void securityScreening(String pcs, String wt) {

        click(Btn_SecurityAndScreening);
        waitForNewWindow(2);
        switchToSecondWindow();

        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }

//        enterKeys(SecurityAndScreening_ShipmentDetails_Inbx_SCC, "GEN,SPX");
//        check(chkBx_givenSecStatus);
        click(btn_addRow);
        selectByText(dropDown_screenMethod, "Explosive detection system");
        enterKeys(txt_screeningPcs, pcs);
        enterKeys(txt_screeningWt, wt);
        selectByText(dropDown_result, "Pass");
        click(SecurityAndScreening_Btn_Ok);

        maxWait();
        switchToFirstWindow();
        minWait();
        waitForFrameAndSwitch(FRAME);
    }

    /**
     * Clears the form
     * @return
     * @author Arun A-7681
     */
    public OPR022 clear(){
        minWait();
        click(btn_clear);
        return this;
    }

    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, testDataFile);
    }
    /**
     * Created by A-7605
     * This method will accept pcs and weight to 2 houses
     * @param awbPrefix
     * @param awbNo
     * @param companyCode
     * @param uldType
     * @param uldNo
     * @param location
     * @param pieces
     * @param weight
     * @param house1
     * @param house1Pcs
     * @param house1Weight
     * @param house2
     * @param house2Pcs
     * @param house2Weight
     * @return
     */
    
    public OPR022 acceptanceWithTwoHouses(String awbPrefix, String awbNo, String companyCode, String uldType, String uldNo, String 	location, String pieces, String weight,
    		String house1, String house1Pcs, String house1Weight,String house2, String house2Pcs, String house2Weight) {

    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
    	weight = PropertyHandler.getPropValue(dataFilePath, weight);
    	house1 = PropertyHandler.getPropValue(dataFilePath, house1);
    	house1Pcs = PropertyHandler.getPropValue(dataFilePath, house1Pcs);
    	house1Weight = PropertyHandler.getPropValue(dataFilePath, house1Weight);
    	house2 = PropertyHandler.getPropValue(dataFilePath, house2);
    	house2Pcs = PropertyHandler.getPropValue(dataFilePath, house2Pcs);
    	house2Weight = PropertyHandler.getPropValue(dataFilePath, house2Weight);
    	companyCode = PropertyHandler.getPropValue(dataFilePath, companyCode);
    	uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
		
		enterKeys(waitForElement(txt_awbPrefix), awbPrefix);
		enterKeys(waitForElement(txt_awbNo), awbNo);
		click(btn_list);
		minWait();
		//due to a bug, create new uld popup not shown, as a workaround added tryCount
		int maxTryCount = 5;
		int tryCount = 1;
		String uldNum;
		while(true){
			uldNum = BizUtility.createULDNum(uldType, companyCode);
			enterKeys(txt_ULDShipmentULDNo, uldNum);
			enterKeys(txt_ULDShipmentULDNo, Keys.TAB);
			driver.switchTo().defaultContent();
			minWait();
			if(verifyElementPresent(yesBtn)){
				click(yesBtn);				
				break;
			}else if (tryCount == maxTryCount){
				break;
			}
			waitForFrameAndSwitch(FRAME);
			tryCount++;
		}
		waitForFrameAndSwitch(FRAME);
		PropertyHandler.setPropValue(dataFilePath, uldNo, uldNum);
		enterKeys(txt_ULDShipmentLocation, location);
		enterKeys(txt_ULDShipmentPieces, pieces);
		enterKeys(txt_ULDShipmentWeight, weight);
		click(Btn_EnterHAWBDetails);
		minWait();
		click(waitForElement(HAWBDetails_Btn_Add));
		minWait();
		enterKeys(waitForElement(HAWBDetails_txt_HAWB1), house1);
		enterKeys(HAWBDetails_txt_StatedPcs1, house1Pcs);
		enterKeys(HAWBDetails_txt_StatedWgt1, house1Weight);
		enterKeys(HAWBDetails_txt_StatedWgt1, Keys.TAB);
//		enterKeys(HAWBDetails_txt_Pcs1, house1Pcs);
//		enterKeys(HAWBDetails_txt_Wgt1, house1Weight);
//		enterKeys(HAWBDetails_txt_Wgt1, Keys.TAB);
		click(HAWBDetails_Btn_Add);
		minWait();
		enterKeys(waitForElement(getWebElements(HAWBDetails_txt_HAWB1).get(1)), house2);
		enterKeys(getWebElements(HAWBDetails_txt_StatedPcs1).get(1), house2Pcs);
		enterKeys(getWebElements(HAWBDetails_txt_StatedWgt1).get(1), house2Weight);
		enterKeys(getWebElements(HAWBDetails_txt_StatedWgt1).get(1), Keys.TAB);
//		enterKeys(getWebElements(HAWBDetails_txt_Pcs1).get(1), house2Pcs);
//		enterKeys(getWebElements(HAWBDetails_txt_Wgt1).get(1), house2Weight);
//		enterKeys(getWebElements(HAWBDetails_txt_Wgt1).get(1), Keys.TAB);
		click(HAWBDetails_Btn_Ok);
		check(Checkbox_AllpartsReceived);	
		click(btn_save);
		driver.switchTo().defaultContent();
		while (verifyElementPresent(yesBtn)){
			click(yesBtn);
			minWait();
		}
		waitForFrameAndSwitch(FRAME);
		Assert.assertTrue(verifyElementPresent(info_FinalizedStatus), "ERROR : Finalized Status");
		return this;
    }
    
    
    public OPR022 acceptance_ULD(String awbPrefix, String awbNo, String companyCode, String uldType, String uldNo, String 	location, String pieces, String weight) {

    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
    	weight = PropertyHandler.getPropValue(dataFilePath, weight);
    	companyCode = PropertyHandler.getPropValue(dataFilePath, companyCode);
    	uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
		
		enterKeys(waitForElement(txt_awbPrefix), awbPrefix);
		enterKeys(waitForElement(txt_awbNo), awbNo);
		click(btn_list);
		minWait();
		//due to a bug, create new uld popup not shown, as a workaround added tryCount
		int maxTryCount = 5;
		int tryCount = 1;
		String uldNum;
		while(true){
			uldNum = BizUtility.createULDNum(uldType, companyCode);
			enterKeys(txt_ULDShipmentULDNo, uldNum);
			enterKeys(txt_ULDShipmentULDNo, Keys.TAB);
			driver.switchTo().defaultContent();
			minWait();
			if(verifyElementPresent(yesBtn)){
				click(yesBtn);
				break;
			}else if (tryCount == maxTryCount){
				break;
			}
			waitForFrameAndSwitch(FRAME);
			tryCount++;
		}
		waitForFrameAndSwitch(FRAME);
		PropertyHandler.setPropValue(dataFilePath, uldNo, uldNum);
		enterKeys(txt_ULDShipmentLocation, location);
		enterKeys(txt_ULDShipmentPieces, pieces);
		enterKeys(txt_ULDShipmentWeight, weight);		
		check(Checkbox_AllpartsReceived);	
		click(btn_save);
		driver.switchTo().defaultContent();
		while (verifyElementPresent(yesBtn)){
			click(yesBtn);
			minWait();
		}
		waitForFrameAndSwitch(FRAME);
		Assert.assertTrue(verifyElementPresent(info_FinalizedStatus), "ERROR : Finalized Status");
		return this;
    }
    
    /**
     * Created by A-7605
     * This method will accept pcs and weight to 1 house
     * @param awbPrefix
     * @param awbNo
     * @param companyCode
     * @param uldType
     * @param uldNo
     * @param location
     * @param pieces
     * @param weight
     * @param house
     * @return
     */
    public OPR022 acceptanceWithOneHouses(String awbPrefix, String awbNo, String companyCode, String uldType, String uldNo, String 	location, String pieces, String weight,
    		String house) {

    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	location = PropertyHandler.getPropValue(dataFilePath, location);
    	pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
    	weight = PropertyHandler.getPropValue(dataFilePath, weight);
    	house = PropertyHandler.getPropValue(dataFilePath, house);
    	companyCode = PropertyHandler.getPropValue(dataFilePath, companyCode);
    	uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
		
		enterKeys(waitForElement(txt_awbPrefix), awbPrefix);
		enterKeys(waitForElement(txt_awbNo), awbNo);
		click(btn_list);
		minWait();
		//due to a bug, create new uld popup not shown, as a workaround added tryCount
		int maxTryCount = 5;
		int tryCount = 1;
		String uldNum;
		while(true){
			uldNum = BizUtility.createULDNum(uldType, companyCode);
			enterKeys(txt_ULDShipmentULDNo, uldNum);
			enterKeys(txt_ULDShipmentULDNo, Keys.TAB);
			driver.switchTo().defaultContent();
			minWait();
			if(verifyElementPresent(yesBtn)){
				click(yesBtn);				
				break;
			}else if (tryCount == maxTryCount){
				break;
			}
			waitForFrameAndSwitch(FRAME);
			tryCount++;
		}
		waitForFrameAndSwitch(FRAME);
		PropertyHandler.setPropValue(dataFilePath, uldNo, uldNum);
		enterKeys(txt_ULDShipmentLocation, location);
		enterKeys(txt_ULDShipmentPieces, pieces);
		enterKeys(txt_ULDShipmentWeight, weight);
		click(Btn_EnterHAWBDetails);
		minWait();
		click(waitForElement(HAWBDetails_Btn_Add));
		minWait();
		enterKeys(waitForElement(HAWBDetails_txt_HAWB1), house);
		enterKeys(HAWBDetails_txt_StatedPcs1, pieces);
		enterKeys(HAWBDetails_txt_StatedWgt1, weight);
		enterKeys(HAWBDetails_txt_StatedWgt1, Keys.TAB);
//		enterKeys(HAWBDetails_txt_Pcs1, house1Pcs);
//		enterKeys(HAWBDetails_txt_Wgt1, house1Weight);
//		enterKeys(HAWBDetails_txt_Wgt1, Keys.TAB);
		click(HAWBDetails_Btn_Ok);
		check(Checkbox_AllpartsReceived);	
		click(btn_save);
		driver.switchTo().defaultContent();
		while (verifyElementPresent(yesBtn)){
			click(yesBtn);
			minWait();
		}
		waitForFrameAndSwitch(FRAME);
		Assert.assertTrue(verifyElementPresent(info_FinalizedStatus), "ERROR : Finalized Status");
		return this;
    }
}

