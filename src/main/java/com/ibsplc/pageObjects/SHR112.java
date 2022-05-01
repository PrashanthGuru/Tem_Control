/**
 * 
 */
package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
public class SHR112 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    private static String FRAME = "iCargoContentFrameSHR112";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By 
    txt_CustomerCode,
    btn_List,
    txt_SettlementAmount,
    btn_Save,
    btn_genericYes,
    btn_Close;

   
    public SHR112(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
    	txt_CustomerCode = MiscUtility.getWebElement(objFilepath, "SHR112_txt_CustomerCode");
    	txt_SettlementAmount = MiscUtility.getWebElement(objFilepath, "SHR112_txt_SettlementAmount");
        btn_List = MiscUtility.getWebElement(objFilepath, "SHR112_btn_List");
    	btn_Save = MiscUtility.getWebElement(objFilepath, "SHR112_btn_Save");
    	btn_Close = MiscUtility.getWebElement(objFilepath, "SHR112_btn_Close");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public SHR112 Save_details(String agentCodeCredit) {

    	agentCodeCredit = PropertyHandler.getPropValue(dataFilePath,agentCodeCredit);
    	
        enterKeys(txt_CustomerCode, agentCodeCredit);
         click(btn_List);
        minWait();
        enterKeys(txt_SettlementAmount, "100");
      
        click(btn_Save);
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
