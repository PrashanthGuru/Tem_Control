/**
 * 
 */
package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author A-6545 on 20/2/2018.
 *
 */
import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class CSH013 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "LTE_CSH_CLM.properties");
    private static String FRAME = "iCargoContentFrameCSH013";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By 
    txt_cashierId,
    btn_list,
    btn_start,
    btn_close,
    btn_genericYes;

   
    public CSH013(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
    	txt_cashierId = MiscUtility.getWebElement(objFilepath, "CSH013_txt_cashierId");
    	btn_start = MiscUtility.getWebElement(objFilepath, "CSH013_btn_start");
    	btn_list = MiscUtility.getWebElement(objFilepath, "CSH013_btn_list");
    	btn_close = MiscUtility.getWebElement(objFilepath, "CSH013_btn_close");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
           }

    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH013 Start(String Cashiercode ) {

      enterKeys(txt_cashierId, Cashiercode);
       click(btn_list);
       minWait();
     
        click(btn_start);
        minWait();
        return this;
    }
   
 
    
      /**
     * CLose and screen and go to home page
     *
     * @return
     * @author A-6545 on 20/2/2018.
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
