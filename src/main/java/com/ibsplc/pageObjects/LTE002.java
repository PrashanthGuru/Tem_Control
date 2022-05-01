/**
 * 
 */
package com.ibsplc.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author A-6545  on 16/2/2018.
 *
 */


import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created A-6545  on 16/2/2018.
 */
public class LTE002 extends BasePage {
	private final static Logger logger = Logger.getLogger(LTE002.class);
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "LTE_CSH_CLM.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameLTE002";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By
       
            txt_carrierCode,
            txt_flightNum,
            txt_Fdate,
            btn_list,
            header_planned,
            header_lying,
            header_assignedShipments,
            header_Shipments,
            Generic_btn_noBtn,
            btn_genericOk,
            lnk_flightlink,
            Generic_info_error;

    private By btn_genericYes,
            info_footer;


    public LTE002(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    /**
     * Initializes all the elements
     *
     *Created A-6545  on 16/2/2018.
     */
    private void initElements() {
        btn_list = MiscUtility.getWebElement(objFilepath, "LTE002_btn_list");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
         Generic_btn_noBtn= MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        txt_carrierCode = MiscUtility.getWebElement(objFilepath, "LTE002_txt_carrierCode");
        txt_flightNum = MiscUtility.getWebElement(objFilepath, "LTE002_txt_flightNum");
        lnk_flightlink= MiscUtility.getWebElement(objFilepath, "LTE002_lnk_flightlink");
        txt_Fdate = MiscUtility.getWebElement(objFilepath, "LTE002_txt_Fdate");
        header_planned = MiscUtility.getWebElement(objFilepath, "LTE002_header_planned");
        header_lying = MiscUtility.getWebElement(objFilepath, "LTE002_header_lying");
        header_assignedShipments = MiscUtility.getWebElement(objFilepath, "LTE002_header_assignedShipments");
        header_Shipments= MiscUtility.getWebElement(objFilepath, "LTE002_header_Shipments");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footer = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
         }
  
    /**
     * List with Flight details
     *
     * @param uldType
     * @param compCode
     * @param uldNo
 
     * @return
     * @author A-6545
     */
    
    public LTE002 Verify_Flightdetails(String carriercode, String fltNo, String flightStartDate,String awbNo) {

    	carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
    	fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
    	flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	   
    
        List(carriercode,fltNo,flightStartDate);
        minWait();
        Assert.assertTrue(waitForElement(lnk_flightlink).getText().contains(fltNo));
        Assert.assertTrue(waitForElement(header_planned).getText().contains("PLANNED SHIPMENTS"));
        Assert.assertTrue(waitForElement(header_lying).getText().contains("LYING LIST"));
        Assert.assertTrue(waitForElement(header_assignedShipments).getText().contains("Assigned Shipments"));
        Assert.assertTrue(waitForElement(header_Shipments).getText().contains(awbNo));
        
        return this;
    }
    /**
     * List with Flight details
     *
     * @param carriercode
     * @param fltNo
     * @param flightStartDate
 
     * @return
     * @author A-6545
     */
    
    public LTE002 List(String carriercode, String fltNo, String flightStartDate) {
   
    	
       enterKeys(txt_carrierCode, carriercode);
       enterKeys(txt_flightNum, fltNo); 
       enterKeys(txt_Fdate, flightStartDate); 
    	   
    	click(btn_list);
        minWait();
        return this;
    }
   
    /**
     * CLose and screen and go to home page
     *
     * @return
     * Created A-6545  on 16/2/2018.
     */
    public HomePage close() {

   //     click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
    
   
}
