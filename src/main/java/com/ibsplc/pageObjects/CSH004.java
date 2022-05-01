/**
 * 
 */
package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author A-6545 on 22/2/2018.
 *
 */
import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class CSH004 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "LTE_CSH_CLM.properties");
    private static String FRAME = "iCargoContentFrameCSH004";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By 
    txt_CashierId,
    txt_fromdate,
    txt_todate,
    txt_StationCode,
    list_iCargoMediumComboBox,
   btn_CashDrawLog_Close,
    tbl_cashDrawDetails,
    btn_CashDrawEnquiry_List,
    btn_close,
    tbl_shipmentDetails,
    btn_CashDrawDetails,
    btn_ViewLog,
    chk_checkLog,
    CSH003_btn_CLOSE,
    btn_genericYes;

   
    public CSH004(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
    	
 
    	txt_CashierId = MiscUtility.getWebElement(objFilepath, "CSH004_txt_CashierId");
    	txt_fromdate = MiscUtility.getWebElement(objFilepath, "CSH004_txt_fromdate");
    	txt_todate = MiscUtility.getWebElement(objFilepath, "CSH004_txt_todate"); 
    	txt_StationCode = MiscUtility.getWebElement(objFilepath, "CSH004_txt_StationCode"); 
    	btn_CashDrawEnquiry_List = MiscUtility.getWebElement(objFilepath, "CSH004_btn_CashDrawEnquiry_List");
    	btn_close = MiscUtility.getWebElement(objFilepath, "CSH004_btn_close");
    	list_iCargoMediumComboBox= MiscUtility.getWebElement(objFilepath, "CSH004_list_iCargoMediumComboBox");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        tbl_cashDrawDetails = MiscUtility.getWebElement(objFilepath, "CSH004_tbl_cashDrawDetails");
        btn_CashDrawDetails= MiscUtility.getWebElement(objFilepath, "CSH004_btn_CashDrawDetails");
        btn_ViewLog= MiscUtility.getWebElement(objFilepath, "CSH004_btn_ViewLog");
        chk_checkLog= MiscUtility.getWebElement(objFilepath, "CSH004_chk_checkLog");
        CSH003_btn_CLOSE= MiscUtility.getWebElement(objFilepath, "CSH003_btn_CLOSE");
        tbl_shipmentDetails= MiscUtility.getWebElement(objFilepath, "CSH004_tbl_shipmentDetails");
        btn_CashDrawLog_Close= MiscUtility.getWebElement(objFilepath, "CSH004_btn_CashDrawLog_Close");
    }

    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH004 Cash_Draw_Details(String username ,String flightStartDate,String origin ) {
    	username = PropertyHandler.getPropValue(dataFilePath,username);
    	flightStartDate = PropertyHandler.getPropValue(dataFilePath,flightStartDate);
   
    	origin = PropertyHandler.getPropValue(dataFilePath,origin);
    	
      enterKeys(txt_CashierId, username);
      enterKeys(txt_fromdate, flightStartDate);
      enterKeys(txt_todate, flightStartDate);
      enterKeys(txt_StationCode, origin);
       click(btn_CashDrawEnquiry_List);
       minWait();
       String value=tblGetTextByColValue(tbl_cashDrawDetails, 4, 2, origin);
       System.out.println(value);
       Assert.assertTrue(value.equalsIgnoreCase(username));
       check(chk_checkLog);
       click(btn_CashDrawDetails);
       minWait();
       click( CSH003_btn_CLOSE);
        return this;
    }
    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH004 View_Log(String username ,String flightStartDate,String origin ) {
    	username = PropertyHandler.getPropValue(dataFilePath,username);
    	flightStartDate = PropertyHandler.getPropValue(dataFilePath,flightStartDate);
   
    	origin = PropertyHandler.getPropValue(dataFilePath,origin);
    	
      enterKeys(txt_CashierId, username);
      enterKeys(txt_fromdate, flightStartDate);
      enterKeys(txt_todate, flightStartDate);
      enterKeys(txt_StationCode, origin);
      selectByText(list_iCargoMediumComboBox, "All");
       click(btn_CashDrawEnquiry_List);
       minWait();
       String value=tblGetTextByColValue(tbl_cashDrawDetails, 4, 2, origin);
       System.out.println(value);
       Assert.assertTrue(value.equalsIgnoreCase(username));
       check(chk_checkLog);
       click(btn_ViewLog);
       minWait();
       waitForNewWindow(2);
       switchToSecondWindow();
   
       click(btn_CashDrawLog_Close);
       switchToFirstWindow();
       waitForFrameAndSwitch(FRAME);
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
