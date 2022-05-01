package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/22/2017.
 */
public class OPR043 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private static String screenFrame = "iCargoContentFrameOPR043";
    private WebDriver driver;
    private String dataFileName;
    private By txt_awbPre,
            txt_awbNo,
            btn_list,
            btn_clear,
            tbl_deliveryTbl,
            txt_carrcode,
            txt_fltNum,
            txt_fltDt,
            checkbox_checkAll,
            btn_delivery,
            btn_close,
            tableIcon_readyForDelivery;

    private By btn_genericYes;


    public OPR043(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        txt_awbPre = MiscUtility.getWebElement(objFilepath, "OPR043_txt_awbPre");
        txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR043_txt_awbNo");
        txt_carrcode = MiscUtility.getWebElement(objFilepath, "OPR043_txt_carrCode");
        txt_fltNum = MiscUtility.getWebElement(objFilepath, "OPR043_txt_fltNum");
        txt_fltDt = MiscUtility.getWebElement(objFilepath, "OPR043_txt_fltDt");
        checkbox_checkAll = MiscUtility.getWebElement(objFilepath, "OPR043_checkbox_checkAll");
        btn_delivery = MiscUtility.getWebElement(objFilepath, "OPR043_btn_delivery");
        
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR043_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "OPR043_btn_clear");
        tbl_deliveryTbl = MiscUtility.getWebElement(objFilepath, "OPR043_tbl_deliveryTbl");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR043_btn_close");
        tableIcon_readyForDelivery = MiscUtility.getWebElement(objFilepath, "OPR043_tableIcon_readyForDelivery");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    /**
     * lists the awbNo
     *
     * @param awbPre
     * @param awbNo
     * @author Arun A-7681 on 22/12
     */
    private void list(String awbPre, String awbNo) {
        enterKeys(txt_awbPre, awbPre);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        maxWait();
    }

    /**
     * lists the flight
     *
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @author A-7868 Krishna <22/02/2018>
     */
    private void list(String carrCode, String fltNo, String fltDt) {
        
    	enterKeys(txt_carrcode, carrCode);
        enterKeys(txt_fltNum, fltNo);
        enterKeys(txt_fltDt, fltDt);
        click(btn_list);
    }
    
    /**
     * checks the delivery status for the awbNo
     *
     * @param awbPre
     * @param awbNo
     * @return
     * @author Arun A-7681 on 22/12
     */
    public OPR043 checkDeliveryStatus(String awbPre, String awbNo, String deliveryStatus) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        deliveryStatus = PropertyHandler.getPropValue(dataFilePath, deliveryStatus);

        list(awbPre, awbNo);
        minWait();
        String status = tblGetTextByColValue(tbl_deliveryTbl, 24, 2, awbNo);

        System.out.println(status);

        Assert.assertTrue(status.trim().equalsIgnoreCase(deliveryStatus), "The delivery status doesn't match");

        return this;

    }

    /**
     * Method to list a flight, select all shipments, click delivery and 
     * navigate to OPR064 - Deliver Cargo screen
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @return
     * @author A-7868 Krishna <23/02/2018>
     */
    public OPR064 listAndClickDelivery(String carrCode, String fltNo, String fltDt){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
    	fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
    	fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
    	
    	list(carrCode, fltNo, fltDt);
    	minWait();
    	check(checkbox_checkAll);
    	click(btn_delivery);
    	minWait();
    	//waitForFrameAndSwitch("iCargoContentFrameOPR064");
        return new OPR064(driver, dataFileName);
    }
    
   
    /**
     * Method to list a flight, select all shipments, click delivery and 
     * navigate to OPR064 - Deliver Cargo screen
     * @param awbPre
     * @param awbNo
     * @return
     * @author A-7868 Krishna <21/03/2018>
     */
    public OPR064 listAndClickDelivery(String awbPre, String awbNo){
    	
    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	
    	list(awbPre, awbNo);
    	minWait();
    	check(checkbox_checkAll);
    	click(btn_delivery);
    	minWait();
    	//waitForFrameAndSwitch("iCargoContentFrameOPR064");
        return new OPR064(driver, dataFileName);
    }
    
    /**
     * CLose and screen and go to home page
     * @return
     * @author Arun A-7681 21/12
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
    /**
     * Created by A-7605 on 27-4-18
     * This method verify if Ready For Delivery table field is indicated with green tick mark
     * @param awbPrefix
     * @param awbNo
     * @return
     */
    public OPR043 verifyReadyForDeliveryTickMarkDisplayed(String awbPrefix, String awbNo){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	
    	enterKeys(txt_awbPre, awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_list);
    	minWait();
    	Assert.assertTrue(waitForElement(tableIcon_readyForDelivery).getAttribute("src").contains("tick.gif"));
    	return this;
    }
    
    /**
     * Created by A-7605 on 27-4-18
     * This method verify if Ready For Delivery table field is indicated with red cross mark
     * @param awbPrefix
     * @param awbNo
     * @return
     */
    public OPR043 verifyReadyForDeliveryTickMarkNotDisplayed(String awbPrefix, String awbNo){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	
    	enterKeys(txt_awbPre, awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_list);
    	minWait();
    	Assert.assertTrue(waitForElement(tableIcon_readyForDelivery).getAttribute("src").contains("cross.gif"));
    	return this;
    }
    
}
