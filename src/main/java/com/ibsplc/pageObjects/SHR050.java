/**
 * 
 */
package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author A-6545 on 16/2/2018.
 *
 */
import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class SHR050 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    private static String FRAME = "iCargoContentFrameSHR050";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By txt_FilterFieldType,
    txt_FieldValue,
    txt_FieldValue2,
    txt_FieldValue3,
    txt_FieldValue4,
    txt_FieldValue5,
    txt_FieldValue6,
    txt_FieldValue7,
    txt_FieldValue8,
    btn_List,
    btn_Save,
    btn_genericYes,
    btn_Close;


    public SHR050(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

    	txt_FilterFieldType = MiscUtility.getWebElement(objFilepath, "SHR050_txt_FilterFieldType");
    	txt_FieldValue = MiscUtility.getWebElement(objFilepath, "SHR050_txt_FieldValue");
    	txt_FieldValue2 = MiscUtility.getWebElement(objFilepath, "SHR050_txt_FieldValue2");
    	 txt_FieldValue3 = MiscUtility.getWebElement(objFilepath, "SHR050_txt_FieldValue3");
    	 txt_FieldValue4 = MiscUtility.getWebElement(objFilepath, "SHR050_txt_FieldValue4");
    	 txt_FieldValue5 = MiscUtility.getWebElement(objFilepath, "SHR050_txt_FieldValue5");
    	 txt_FieldValue6 = MiscUtility.getWebElement(objFilepath, "SHR050_txt_FieldValue6");
    	 txt_FieldValue7 = MiscUtility.getWebElement(objFilepath, "SHR050_txt_FieldValue7");
    	 txt_FieldValue8 = MiscUtility.getWebElement(objFilepath, "SHR050_txt_FieldValue8");
    	btn_List = MiscUtility.getWebElement(objFilepath, "SHR050_btn_List");
    	btn_Save = MiscUtility.getWebElement(objFilepath, "SHR050_btn_Save");
    	btn_Close = MiscUtility.getWebElement(objFilepath, "SHR050_btn_Close");
    	btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    /**
     * 

     * @param username
     * @param airport
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public SHR050 verify_parameter(String paramCode) {

    	paramCode = PropertyHandler.getPropValue(dataFilePath,paramCode);
    	
        enterKeys(txt_FilterFieldType, paramCode);
         click(btn_List);
        minWait();
         System.out.println(waitForElement(txt_FieldValue).getAttribute("value"));
        	Assert.assertTrue(waitForElement(txt_FieldValue).getAttribute("value").contains("BA"));
        	Assert.assertTrue(waitForElement(txt_FieldValue2).getAttribute("value").contains("BG"));
        	Assert.assertTrue(waitForElement(txt_FieldValue3).getAttribute("value").contains("BT"));
        	Assert.assertTrue(waitForElement(txt_FieldValue4).getAttribute("value").contains("SD"));
        	Assert.assertTrue(waitForElement(txt_FieldValue5).getAttribute("value").contains("Barter"));
        	Assert.assertTrue(waitForElement(txt_FieldValue6).getAttribute("value").contains("Bank Guarantee"));
        	Assert.assertTrue(waitForElement(txt_FieldValue7).getAttribute("value").contains("Bank Transation"));
        	Assert.assertTrue(waitForElement(txt_FieldValue8).getAttribute("value").contains("Security Deposit"));
      
        return this;
    }
    /**
     * CLose and screen and go to home page
     *
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public HomePage close() {

        click(btn_Close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}
