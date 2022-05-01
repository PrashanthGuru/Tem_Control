package com.ibsplc.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Created by a-7681 on 12/26/2017.
 */
public class ULD013 extends BasePage {
	private final static Logger logger = Logger.getLogger(ULD013.class);
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameULD013";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By
            txtUldNo,
            btn_list,
            btn_clear,
            txt_IATAReplacementCost,
            txt_currency,
            btn_save,
            List_facilityType,
            BUTTON_Deletebutton,
            ChkBox_createMultipleY,
            Text_uldType,
            Text_ownerAirlineCode,
            BUTTON_SpecifyRangebutton,
            txt_Contour,
            Text_startNo,
            Text_noOfUnits,
            BUTTON_Generatebutton,
            BUTTON_Generatebutton_Okbutton,
            Text_tsoNumber,
            Generic_info_msg,
            Text_currentStation,
            List_overallStatus,
            List_cleanlinessStatus,
            List_damageStatus,
            Generic_btn_noBtn,
            Text_ownerStation,
            Text_vendor,
        
            btn_genericOk,
            Generic_info_error,
            btn_close,
            txt_purchaseDate, txt_ULDPrice;

    private By btn_genericYes,
            info_footer;


    public ULD013(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    /**
     * Initializes all the elements
     *
     * @author Arun A-7681 on 26/12
     */
    private void initElements() {
        txtUldNo = MiscUtility.getWebElement(objFilepath, "ULD013_txtUldNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "ULD013_btn_list");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
         Generic_btn_noBtn= MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        btn_clear = MiscUtility.getWebElement(objFilepath, "ULD013_btn_clear");
        txt_IATAReplacementCost = MiscUtility.getWebElement(objFilepath, "ULD013_txt_IATAReplacementCost");
        txt_currency = MiscUtility.getWebElement(objFilepath, "ULD013_txt_currency");
        btn_save = MiscUtility.getWebElement(objFilepath, "ULD013_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath, "ULD013_btn_close");
        txt_Contour= MiscUtility.getWebElement(objFilepath, "ULD013_txt_Contour");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        Text_vendor = MiscUtility.getWebElement(objFilepath, "ULD013_Text_vendor");
        info_footer = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        Text_tsoNumber  = MiscUtility.getWebElement(objFilepath, "ULD013_Text_tsoNumber");
        List_facilityType = MiscUtility.getWebElement(objFilepath, "ULD013_List_facilityType");
        List_overallStatus  = MiscUtility.getWebElement(objFilepath, "ULD013_List_overallStatus");
        List_cleanlinessStatus  = MiscUtility.getWebElement(objFilepath, "ULD013_List_cleanlinessStatus");
        List_damageStatus  = MiscUtility.getWebElement(objFilepath, "ULD013_List_damageStatus");
        Text_ownerStation = MiscUtility.getWebElement(objFilepath, "ULD013_Text_ownerStation");
        ChkBox_createMultipleY = MiscUtility.getWebElement(objFilepath, "ULD013_ChkBox_createMultipleY");
        Text_uldType  = MiscUtility.getWebElement(objFilepath, "ULD013_Text_uldType");
        Text_ownerAirlineCode  = MiscUtility.getWebElement(objFilepath, "ULD013_Text_ownerAirlineCode");
        BUTTON_SpecifyRangebutton= MiscUtility.getWebElement(objFilepath, "ULD013_BUTTON_SpecifyRangebutton");
        Text_startNo	= MiscUtility.getWebElement(objFilepath, "ULD013_Text_startNo");
        Text_noOfUnits= MiscUtility.getWebElement(objFilepath, "ULD013_Text_noOfUnits");
        BUTTON_Generatebutton= MiscUtility.getWebElement(objFilepath, "ULD013_BUTTON_Generatebutton");
        BUTTON_Generatebutton_Okbutton= MiscUtility.getWebElement(objFilepath, "ULD013_BUTTON_Generatebutton_Okbutton");
        Generic_info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        Text_currentStation= MiscUtility.getWebElement(objFilepath, "ULD013_Text_currentStation");
        BUTTON_Deletebutton= MiscUtility.getWebElement(objFilepath, "ULD013_BUTTON_Deletebutton");
//        txt_purchaseDate= MiscUtility.getWebElement(objFilepath, "ULD013_txt_purchaseDate");
//        txt_ULDPrice= MiscUtility.getWebElement(objFilepath, "ULD013_txt_ULDPrice");
        
    }
    /**
     * Creates a new ULD based on the parameters passed
     *
     * @param uldType
     * @param compCode
     * @param uldNo
 
     * @return
     * @author A-6545
     */
    
    public ULD013 createULD1(String uldType, String compCode, String uldNo) {

        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
    
        String tempUld = null;

        while (true) {
            tempUld = BizUtility.createULDNum(uldType, compCode);
            System.out.println(tempUld);
            minWait();
            enterKeys(txtUldNo, tempUld+Keys.TAB);
            click(btn_list);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(btn_genericYes)) {
                click(btn_genericYes);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
            click(btn_clear);
        }
        PropertyHandler.setPropValue(dataFilePath, uldNo, tempUld);
      minWait();
        click(btn_save);

        return this;
    }

    /**
     * Creates a new ULD based on the parameters passed
     *
     * @param uldType
     * @param compCode
     * @param uldNo
     * @param replacementAmnt
     * @param currency
     * @return
     * @author Arun A-7681 on 26/12
     */
    public ULD013 createULD(String uldType, String compCode, String uldNo, String replacementAmnt, String currency) {

        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
        replacementAmnt = PropertyHandler.getPropValue(dataFilePath, replacementAmnt);
        currency = PropertyHandler.getPropValue(dataFilePath, currency);
        String tempUld = null;

        while (true) {
            tempUld = BizUtility.createULDNum(uldType, compCode);
            enterKeys(txtUldNo, tempUld);
            click(btn_list);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(btn_genericYes)) {
                click(btn_genericYes);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
            click(btn_clear);
        }
        PropertyHandler.setPropValue(dataFilePath, uldNo, tempUld);
        try{
        	enterKeys(txt_IATAReplacementCost, replacementAmnt);
        }catch(UnhandledAlertException e){
        	driver.switchTo().alert().accept();
        	enterKeys(txt_IATAReplacementCost, replacementAmnt);
        }
        enterKeys(txt_currency, currency);
        click(btn_save);
        minWait();
        new WebDriverWait(driver, 60).until(ExpectedConditions.attributeToBe(btn_save, "disabled", "true"));
        driver.switchTo().defaultContent();       
        Assert.assertTrue(waitForElement(info_footer).getText().trim().equalsIgnoreCase("Data Saved Successfully"), "The ULD is not successfully created");

        waitForFrameAndSwitch(FRAME);
        logger.info("ULD created : "+tempUld);
        return this;
    }

    /**
     * Creates a new ULD based on the parameters passed
     *
     * @param uldType
     * @param compCode
     * @param uldNo
     * @param replacementAmnt
     * @param currency
     * @return
     * @authorA-6545
     */
    public ULD013 createULD_Oprdet(String uldType, String compCode, String uldNo, String replacementAmnt, String currency, String origin) {

        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
        replacementAmnt = PropertyHandler.getPropValue(dataFilePath, replacementAmnt);
        currency = PropertyHandler.getPropValue(dataFilePath, currency);
        origin= PropertyHandler.getPropValue(dataFilePath, origin);
        String tempUld = null;
       
        tempUld = BizUtility.createULDNum(uldType, compCode);
        enterKeys(txtUldNo, tempUld);
        click(btn_list);
        driver.switchTo().defaultContent();
        minWait();
        if (verifyElementPresent(Generic_btn_noBtn)) {
            click(Generic_btn_noBtn);
            waitForFrameAndSwitch(FRAME);
        }
       while (true) {
            tempUld = BizUtility.createULDNum(uldType, compCode);
            enterKeys(txtUldNo, tempUld);
            click(btn_list);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(btn_genericYes)) {
                click(btn_genericYes);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
            click(btn_clear);
        }
        PropertyHandler.setPropValue(dataFilePath, uldNo, tempUld);
        minWait();
        selectByIndex(txt_Contour,1);
        enterKeys(Text_vendor, "TEST");
        enterKeys(Text_tsoNumber, "12345");
      //  selectByText(List_facilityType,"Cargo");
        selectByText(List_overallStatus,"Operational");
        selectByIndex(List_cleanlinessStatus,1);
        selectByIndex(List_damageStatus,2);
        enterKeys(Text_ownerStation, origin);
        enterKeys(txt_IATAReplacementCost, replacementAmnt);
        enterKeys(txt_currency, currency);
        click(btn_save);

        driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(info_footer).getText().trim().equalsIgnoreCase("Data Saved Successfully"), "The ULD is not successfully created");

        waitForFrameAndSwitch(FRAME);

        return this;
    }
    /**
     * Creates a new ULD based on the parameters passed
     *
     * @param uldType
     * @param compCode
     * @param uldNo
     * @param replacementAmnt
     * @param currency
     * @return 06/02/2018
     * @authorA-6545
     */
    public ULD013 Create_MultipleULD(String uldType, String compCode, String uldNo) {

        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
     String tempUld = null;
       check(ChkBox_createMultipleY);
        enterKeys(Text_uldType,uldType);
        enterKeys(Text_ownerAirlineCode, compCode);
        click(BUTTON_SpecifyRangebutton);
        
        waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(Text_startNo, "1234");
        enterKeys(Text_noOfUnits, "3");
        click(BUTTON_Generatebutton);
        minWait();
        click(BUTTON_Generatebutton_Okbutton);
        
       switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_save);
        driver.switchTo().defaultContent();
 	   click(waitForElement(btn_genericOk));
 	   waitForFrameAndSwitch(FRAME);
            minWait();
           

        return this;
    }
    /**
     * verify multi uld details  based on the parameters passed
     *
     * @param uldType
     * @param compCode
     * @param uldNo
     * @param replacementAmnt
     * @param currency
     * @return 06/02/2018
     * @authorA-6545
     */
    public ULD013 Create_MultipleULD_verify(String uldType, String compCode, String uldNo) {

        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
     String tempUld = null;
       check(ChkBox_createMultipleY);
        enterKeys(Text_uldType,uldType);
        enterKeys(Text_ownerAirlineCode, compCode);
        click(BUTTON_SpecifyRangebutton);
        
        waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(Text_startNo, "1234");
        enterKeys(Text_noOfUnits, "3");
        click(BUTTON_Generatebutton);
        minWait();
        click(BUTTON_Generatebutton_Okbutton);
        
       switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_save);
            minWait();
           driver.switchTo().defaultContent();
        	   click(waitForElement(btn_genericOk));
        	   waitForFrameAndSwitch(FRAME);

        return this;
    }
    /**
     * Creates a new ULD based on the parameters passed
     *
     * @param uldType
     * @param compCode
     * @param uldNo
     * @param replacementAmnt
     * @param currency
     * @return
     * @authorA-6545
     */
public ULD013 Update_ULD(String uldNo, String origin) {

    	
    	uldNo= PropertyHandler.getPropValue(dataFilePath, uldNo);
    	 enterKeys(txtUldNo, uldNo);
         click(btn_list);
       enterKeys(Text_currentStation, origin);
    	
        click(btn_save);
          minWait();
         /* if(waitForElement(Generic_info_error).isDisplayed())
          {
        	   Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("either loaned or borrowed cannot be modified"));
          }*/


        return this;
    }
public ULD013 Update_ULD_error(String uldNo, String origin) {

	
	uldNo= PropertyHandler.getPropValue(dataFilePath, uldNo);
	 enterKeys(txtUldNo, uldNo);
     click(btn_list);
   enterKeys(Text_currentStation, origin);
	
    click(btn_save);
      minWait();
      if(verifyElementPresent(Generic_info_error))
      {
    	   Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("either loaned or borrowed cannot be modified"));
      }


    return this;
}
    /**
     * Creates a new ULD based on the parameters passed
     *
     * @param uldType
     * @param compCode
     * @param uldNo
     * @param replacementAmnt
     * @param currency
     * @return
     * @authorA-6545
     */
    public ULD013 Delete_ULD(String uldNo) {

    	
    	uldNo= PropertyHandler.getPropValue(dataFilePath, uldNo);
    	 enterKeys(txtUldNo, uldNo);
         click(btn_list);
       click(BUTTON_Deletebutton);
         driver.switchTo().defaultContent();
         minWait();
         if (verifyElementPresent(Generic_btn_noBtn)) {
             click(Generic_btn_noBtn);
             waitForFrameAndSwitch(FRAME);
         }
         click(BUTTON_Deletebutton);
         driver.switchTo().defaultContent();
         minWait();
         if (verifyElementPresent(btn_genericYes)) {
             click(btn_genericYes);
             waitForFrameAndSwitch(FRAME);
         }
       
          minWait();
       
        return this;
    }
  
    /**
     * CLose and screen and go to home page
     *
     * @return
     * @author A-7681 Arun on 26/12
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
     * Created by A-7605
     * This method will return a ULD No that is not in the system
     * @param uldType
     * @param compCode
     * @param uldNo
     * @return
     */
    public ULD013 getULDNoThatIsNotInSystem(String uldType, String compCode, String uldNo) {

        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
        String tempUld = null;

        while (true) {
            tempUld = BizUtility.createULDNum(uldType, compCode);
            enterKeys(txtUldNo, tempUld);
            click(btn_list);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(btn_genericYes)) {
                click(btn_genericYes);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
            click(btn_clear);
        }
        PropertyHandler.setPropValue(dataFilePath, uldNo, tempUld);
        minWait();
        return this;
    }
    
    //A-8680
    public ULD013 createULD(String uldType, String CarrierCode, String uldNumber) {

        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        CarrierCode = PropertyHandler.getPropValue(dataFilePath, CarrierCode);
        String tempUld=null;
        String uldNo=null;
            while (true) {
            InitialSetup.test.log(LogStatus.INFO, "Starting with the ULD creation");
            tempUld = PropertyHandler.getPropValue("resources\\TestData\\BASE\\uld.properties","noForUld");
            int uldno = Integer.parseInt(tempUld);
            uldno=uldno+1;
            tempUld = Integer.toString(uldno);
            System.out.println(tempUld);
            minWait();
            uldNo = uldType+tempUld+CarrierCode;
            enterKeys(txtUldNo, uldNo+Keys.TAB);
            click(btn_list);
            driver.switchTo().defaultContent();
            if (verifyElementPresent(btn_genericYes)) {
                click(btn_genericYes);
                PropertyHandler.setPropValue(dataFilePath, uldNumber, uldNo);
                PropertyHandler.setPropValue("resources\\TestData\\BASE\\uld.properties", "noForUld", tempUld);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
            click(btn_clear);
        }
       
        enterKeys(By.xpath("//input[@name='purchaseDate']"),"."+Keys.TAB);
        enterKeys(By.xpath("//input[@name='uldPrice']"),"0");
        click(btn_save);
        minWait();
        if(verifyElementPresent(By.xpath("//td[contains(text(),'Purchase date cannot be greater')]"))){
        	enterKeys(By.xpath("//input[@name='purchaseDate']"),"-1"+Keys.TAB);
            click(btn_save);
        }
        InitialSetup.test.log(LogStatus.INFO, "ULD has been created successfully : "+uldNo);
        return this;
    }
    
    
    //A-8680
    public ULD013 saveULDtodatafile(String uldNo) {
    	String uldNumber = PropertyHandler.getPropValue("resources\\TestData\\BASE\\uld.properties","noForUld");
    	PropertyHandler.setPropValue(dataFilePath, uldNo, uldNumber);
        return this;
    }
    
}
