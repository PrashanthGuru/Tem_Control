/**
 * 
 */
package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * @author A-6545
 *
 */
public class SHR108 extends BasePage {
	
	  public static String FRAME = "iCargoContentFrameSHR108";
	    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
	    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	
	    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	    private WebDriver driver;
	    private String dataFileName;
	    private By txt_fltCarCode,
	            txt_fltNo,
	            txt_fltsDt,
	            txt_flteDt,
	            btn_list,
	            check_frequency,
	            Btn_validationsetting,
	            Select_RestrictionDetails_validationType,
	            Btn_validationOK,
	            btn_clear,
	            Btn_AddModifybutton,
	            Text_RestrictionDetails_validationMessage,
	            btn_close;
	    private By btn_genericYes;


	    public SHR108(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        this.dataFileName = dataFileName;
	    }

	    /**
	     * Initializes the webelements
	     *
	     * @author A-6545
	     */
	    private void initElements() {
	    
	    	 txt_fltCarCode = MiscUtility.getWebElement(objFilepath, "SHR108_Text_RestrictionDetails_flightCarrierCode");
	         txt_fltNo = MiscUtility.getWebElement(objFilepath, "SHR108_Text_RestrictionDetails_flightNumber");
	         txt_fltsDt = MiscUtility.getWebElement(objFilepath, "SHR108_Text_FlightStartDate");
	         txt_flteDt = MiscUtility.getWebElement(objFilepath, "SHR108_Text_FlightEndDate");
	         check_frequency = MiscUtility.getWebElement(objFilepath, "SHR108_check_frequency");
	         Select_RestrictionDetails_validationType = MiscUtility.getWebElement(objFilepath, "SHR108_Select_RestrictionDetails_validationType");
	         Text_RestrictionDetails_validationMessage= MiscUtility.getWebElement(objFilepath, "SHR108_Text_RestrictionDetails_validationMessage");
	         Btn_AddModifybutton   = MiscUtility.getWebElement(objFilepath, "SHR108_Btn_AddModifybutton");
	         btn_close = MiscUtility.getWebElement(objFilepath, "SHR108_Btn_Close");
	         Btn_validationsetting = MiscUtility.getWebElement(objFilepath, "SHR108_Btn_validationsetting");
	         Btn_validationOK = MiscUtility.getWebElement(objFilepath, "SHR108_Btn_validationOK");
	    }
	    /**
	     * lists a flight with flight number
	     *
	     * @param fltCar
	     * @param fltNo
	     * @param fltDt
	     * @author A-6545
	     *
	     */
	    public SHR108 FlightRestriction(String fltCar, String fltNo, String fltSDt, String fltEDt) {

	        fltCar = PropertyHandler.getPropValue(dataFilePath, fltCar);
	        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
	        fltSDt = PropertyHandler.getPropValue(dataFilePath, fltSDt);
	        fltEDt = PropertyHandler.getPropValue(dataFilePath, fltEDt);
	        
	        enterKeys(txt_fltCarCode, fltCar);
	        enterKeys(txt_fltNo, fltNo);
	        enterKeys(txt_fltsDt, fltSDt);
	        enterKeys(txt_flteDt, fltEDt);
	        check(check_frequency);
	        click(Btn_validationsetting);
	        waitForNewWindow(2);
	        switchToSecondWindow();
	        selectByText(Select_RestrictionDetails_validationType, "Info");
	       
	        click(Btn_validationOK);
	        switchToFirstWindow();
	        waitForFrameAndSwitch(FRAME);
	        minWait();
	        enterKeys(Text_RestrictionDetails_validationMessage, "Info");
	        scrollToView(Btn_AddModifybutton);
	        click(Btn_AddModifybutton);
	        minWait();
	        return new SHR108(driver, dataFileName);
	       
	    }
	        /**
	         * Closes the screen and go to home screen
	         *
	         * @return
	         * @author A-6545
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
