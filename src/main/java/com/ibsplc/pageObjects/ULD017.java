/**
 * 
 */
package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * @author A-6545
 *
 */
import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by 6545
 */
public class ULD017 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameULD017";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By 
    txt_carrierCode,
    txt_flightNumber,
    txt_flightDate,
    chk_dummyMovement,
    txt_pol,
    txt_pou,
    list_CONTENT,
    addlink,
    btn_save,
    txt_uld,
     Generic_info_error,
          btn_close;
            
    private By btn_genericNo,
            btn_genericYes,
            info_footer;


    public ULD017(WebDriver driver, String dataFileName) {
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
    	 txt_carrierCode = MiscUtility.getWebElement(objFilepath, "ULD017_txt_carrierCode");
    	    txt_flightNumber = MiscUtility.getWebElement(objFilepath, "ULD017_txt_flightNumber");
    	    txt_flightDate = MiscUtility.getWebElement(objFilepath, "ULD017_txt_flightDate");
    	    chk_dummyMovement= MiscUtility.getWebElement(objFilepath, "ULD017_chk_dummyMovement");
    	    txt_pol = MiscUtility.getWebElement(objFilepath, "ULD017_txt_pol");
    	    txt_pou = MiscUtility.getWebElement(objFilepath, "ULD017_txt_pou");
    	    list_CONTENT = MiscUtility.getWebElement(objFilepath, "ULD017_txt_CONTENT");
    	    addlink = MiscUtility.getWebElement(objFilepath, "ULD017_addlink");
    	    txt_uld = MiscUtility.getWebElement(objFilepath, "ULD017_txt_uld");
    	    btn_save= MiscUtility.getWebElement(objFilepath, "ULD017_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath, "ULD017_btn_CLOSE");
      
        btn_genericNo = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footer = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
     
    }

    /**
     * Performs ULD transaction saving for the specified ULD and for the specified parties
     *
     * @param uldNo
     * @return
     * @author 
     */
    public ULD017 Uld_Movements( String carrier_code, String fltNo,String flightStartDate,String uldNo,String origin,String dest) {

        uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
        carrier_code = PropertyHandler.getPropValue(dataFilePath, carrier_code);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
        origin = PropertyHandler.getPropValue(dataFilePath, origin);
        dest = PropertyHandler.getPropValue(dataFilePath, dest);
        
        enterKeys(txt_carrierCode, carrier_code + Keys.TAB);
        enterKeys(txt_flightNumber, fltNo  + Keys.TAB);
        enterKeys(txt_flightDate, flightStartDate + Keys.TAB);
        check(chk_dummyMovement);
        enterKeys(txt_pol, origin);
        enterKeys(txt_pou, dest);
        selectByText(list_CONTENT,"Empty ULD");
         click(addlink);
         enterKeys(txt_uld, uldNo);
         click(btn_save);
         
       

        return this;
    }
    
   
    /**
     * CLose and screen and go to home page
     *
     * @return
     * @author
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
