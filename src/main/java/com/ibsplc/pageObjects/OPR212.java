/**
 * 
 */
package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
public class OPR212 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String FRAME = "iCargoContentFrameOPR212";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By 
    txt_awbPrefix,
    txt_awbNo,
    btn_List,
    btn_Close,
    chk_HandlingDetails,
    btn_DETAIL,
    txt_remarks,
    btn_pymnt_ok,
    btn_finalize,
    txt_pymntAdvice,
    btn_pymnt_close,
    btn_Pay,
    OPR162_btn_Close,
    Generic_info_msg,
    btn_genericYes;

   
    public OPR212(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
    	txt_awbPrefix = MiscUtility.getWebElement(objFilepath, "OPR212_txt_awbPrefix");
    	txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR212_txt_awbNo");
    	chk_HandlingDetails = MiscUtility.getWebElement(objFilepath, "OPR212_chk_HandlingDetails");
    	btn_List = MiscUtility.getWebElement(objFilepath, "OPR212_btn_List");
    	btn_DETAIL = MiscUtility.getWebElement(objFilepath, "OPR212_btn_DETAIL");
    	btn_Pay= MiscUtility.getWebElement(objFilepath, "OPR162_btn_Pay");
    	btn_Close= MiscUtility.getWebElement(objFilepath, "OPR212_btn_Close");
    	 txt_remarks = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_txt_remarks");
         btn_pymnt_ok = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_btn_ok");
         btn_finalize = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_btn_finalize");
         txt_pymntAdvice = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_txt_adviceNo");
         btn_pymnt_close = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_btn_close");
         OPR162_btn_Close= MiscUtility.getWebElement(objFilepath, "OPR162_btn_Close");
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
    public OPR212 Pay(String awbPre,String awbNo) {
    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
   
      
    	enterKeys(txt_awbPrefix, awbPre);
        enterKeys(txt_awbNo, awbNo);
       
         click(btn_List);
         minWait();
         check(chk_HandlingDetails);
         minWait();
          click(btn_DETAIL);
          minWait();
          click(btn_Pay);
          minWait();
          
          enterKeys(txt_remarks, "Payment Remarks");
          click(btn_pymnt_ok);
          click(btn_finalize);
          minWait();
          Assert.assertFalse(waitForElement(txt_pymntAdvice).getAttribute("value").isEmpty(), "ERROR : Payment not successful");
          click(btn_pymnt_close);
          minWait();
          click(OPR162_btn_Close);
          minWait();
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
