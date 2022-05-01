/**
 * 
 */
package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * @author A-6545 on 19/2/2018.
 *
 */
import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class OPR162 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String FRAME = "iCargoContentFrameOPR162";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By 
    txt_awbPrefix,
    txt_awbNo,
    list_AddlHandlingType,
    btn_List,
    txt_startDate,
    txt_startTime,
    txt_endTime,
    txt_endDate,
    txt_Customer,
   
    list_PAYMNTTYPE,
    btn_Save,
    btn_Close,
    Generic_info_msg,
    btn_genericYes;

   
    public OPR162(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
    	txt_awbPrefix = MiscUtility.getWebElement(objFilepath, "OPR162_txt_awbPrefix");
    	txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR162_txt_awbNo");
    	list_AddlHandlingType = MiscUtility.getWebElement(objFilepath, "OPR162_list_AddlHandlingType");
    	btn_List = MiscUtility.getWebElement(objFilepath, "OPR162_btn_List");
    	txt_startDate = MiscUtility.getWebElement(objFilepath, "OPR162_txt_startDate");
    	txt_endDate= MiscUtility.getWebElement(objFilepath, "OPR162_txt_endDate");
    	txt_Customer= MiscUtility.getWebElement(objFilepath, "OPR162_txt_Customer");
    	list_PAYMNTTYPE= MiscUtility.getWebElement(objFilepath, "OPR162_list_PAYMNTTYPE");
    	btn_Save= MiscUtility.getWebElement(objFilepath, "OPR162_btn_Save");
    	
    	btn_Close= MiscUtility.getWebElement(objFilepath, "OPR162_btn_Close");
        txt_startTime= MiscUtility.getWebElement(objFilepath, "OPR162_txt_startTime");
        txt_endTime= MiscUtility.getWebElement(objFilepath, "OPR162_txt_endTime");
       btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
       Generic_info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    }

    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public OPR162 Save(String awbPre,String awbNo,String agentCodeCash) {
    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
    	agentCodeCash= PropertyHandler.getPropValue(dataFilePath,agentCodeCash);
        enterKeys(txt_awbPrefix, awbPre);
        enterKeys(txt_awbNo, awbNo);
        selectByIndex(list_AddlHandlingType, 1);
         click(btn_List);
       minWait();
       enterKeys(txt_startDate, ".");
       enterKeys(txt_endDate, ".");
       enterKeys(txt_startTime, "0");
       enterKeys(txt_endTime, "12");
  
       selectByIndex(list_PAYMNTTYPE, 1);
       enterKeys(txt_Customer, agentCodeCash +Keys.TAB);
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
