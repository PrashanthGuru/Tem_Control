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
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class CSH005 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "LTE_CSH_CLM.properties");
    private static String FRAME = "iCargoContentFrameCSH005";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By 
    txt_Airportcode,
    txt_Cashdrawtype,
    btn_list,
    txt_Maxamount,
    txt_Maxtxnamount,
    txt_Maxamount2,
    txt_Maxtxnamount2,
    txt_Maxamount3,
    txt_Maxtxnamount3,
    addLink,
    txt_cashier,
    txt_cashier2,
    chk_check,
    txt_Cashdrawlimit,
    chk_foreginCurrencyAllowed,
    cashdrawtypelov,
    txt_CASHDRAWTYPELOV_CODE,
    btn_CASHDRAWTYPELOV_LIST,
    chk_selectCheckBox,
    btn_CASHDRAWTYPELOV_OK,
    btn_Save,
    btn_Close,
    btn_genericYes;

   
    public CSH005(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
    	txt_Airportcode = MiscUtility.getWebElement(objFilepath, "CSH005_txt_Airportcode");
    	txt_Cashdrawtype = MiscUtility.getWebElement(objFilepath, "CSH005_txt_Cashdrawtype");
    	btn_list = MiscUtility.getWebElement(objFilepath, "CSH005_btn_list");
    	txt_Maxamount = MiscUtility.getWebElement(objFilepath, "CSH005_txt_Maxamount");
    	txt_Maxtxnamount = MiscUtility.getWebElement(objFilepath, "CSH005_txt_Maxtxnamount");
    	txt_Maxamount2 = MiscUtility.getWebElement(objFilepath, "CSH005_txt_Maxamount2");
    	txt_Maxtxnamount2 = MiscUtility.getWebElement(objFilepath, "CSH005_txt_Maxtxnamount2");
    	txt_Maxamount3 = MiscUtility.getWebElement(objFilepath, "CSH005_txt_Maxamount3");
    	txt_Maxtxnamount3 = MiscUtility.getWebElement(objFilepath, "CSH005_txt_Maxtxnamount3");
    	addLink = MiscUtility.getWebElement(objFilepath, "CSH005_addLink");
    	chk_foreginCurrencyAllowed= MiscUtility.getWebElement(objFilepath, "CSH005_chk_foreginCurrencyAllowed");
    	txt_cashier = MiscUtility.getWebElement(objFilepath, "CSH005_txt_cashier");
    	txt_Cashdrawlimit = MiscUtility.getWebElement(objFilepath, "CSH005_txt_Cashdrawlimit");
    	btn_Save = MiscUtility.getWebElement(objFilepath, "CSH005_btn_Save");
    	btn_Close = MiscUtility.getWebElement(objFilepath, "CSH005_btn_Close");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        txt_cashier2 = MiscUtility.getWebElement(objFilepath, "CSH005_txt_cashier2");
        chk_check= MiscUtility.getWebElement(objFilepath, "CSH005_chk_check");
        cashdrawtypelov = MiscUtility.getWebElement(objFilepath, "CSH005_cashdrawtypelov");
        txt_CASHDRAWTYPELOV_CODE = MiscUtility.getWebElement(objFilepath, "CSH005_txt_CASHDRAWTYPELOV_CODE");
        btn_CASHDRAWTYPELOV_LIST = MiscUtility.getWebElement(objFilepath, "CSH005_btn_CASHDRAWTYPELOV_LIST");
        chk_selectCheckBox = MiscUtility.getWebElement(objFilepath, "CSH005_chk_selectCheckBox");
        btn_CASHDRAWTYPELOV_OK = MiscUtility.getWebElement(objFilepath, "CSH005_btn_CASHDRAWTYPELOV_OK");
    }

    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH005 Save_details(String origin,String Cashiercode,String username ) {

    	origin = PropertyHandler.getPropValue(dataFilePath,origin);
    
    	String cashiercode = BizUtility.generateRandomAlphabets(Integer.parseInt("5"));
    	 PropertyHandler.setPropValue(dataFilePath, Cashiercode, cashiercode);
    	 
        enterKeys(txt_Airportcode, origin);
        enterKeys(txt_Cashdrawtype, cashiercode);
         click(btn_list);
         driver.switchTo().defaultContent();
         if (verifyElementPresent(btn_genericYes)) {

             click(btn_genericYes);
             waitForFrameAndSwitch(FRAME);
         }
        minWait();
        enterKeys(txt_Maxamount, "900000");
        enterKeys(txt_Maxtxnamount, "900000");
        enterKeys(txt_Maxamount2, "9000000");
        enterKeys(txt_Maxtxnamount2, "9000000");
        enterKeys(txt_Maxamount3, "900000");
        enterKeys(txt_Maxtxnamount3, "900000");
        enterKeys(txt_Cashdrawlimit, "90000000000");
        click(addLink);
        enterKeys(txt_cashier, username);
        click(btn_Save);
        minWait();
        return this;
    }
   
    /**
     * List the details 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH005 List_details(String origin,String Cashiercode ) {

    	origin = PropertyHandler.getPropValue(dataFilePath,origin);
    	Cashiercode = PropertyHandler.getPropValue(dataFilePath,Cashiercode);
    	
    	 
        enterKeys(txt_Airportcode, origin);
        enterKeys(txt_Cashdrawtype, Cashiercode);
         click(btn_list);
       minWait();
       click(addLink);
       enterKeys(txt_cashier2, 	"OGSADMIN");
        click(btn_Save);
        minWait();
        return this;
    }
    
    /**
     * List the details 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH005 List_detailsfromlov(String origin,String Cashiercode ) {

    	origin = PropertyHandler.getPropValue(dataFilePath,origin);
    	Cashiercode = PropertyHandler.getPropValue(dataFilePath,Cashiercode);
    	
    	 
        enterKeys(txt_Airportcode, origin);
        click(cashdrawtypelov);
        minWait();
        waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(txt_CASHDRAWTYPELOV_CODE, Cashiercode);
        click(btn_CASHDRAWTYPELOV_LIST);
        check(chk_selectCheckBox);
        click(btn_CASHDRAWTYPELOV_OK);
        switchToFirstWindow();
         waitForFrameAndSwitch(FRAME);
        click(btn_list);
       minWait();
     
        minWait();
        return this;
    }
    /**
     * List the details 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH005 Modification(String origin,String Cashiercode,String value ) {

    	origin = PropertyHandler.getPropValue(dataFilePath,origin);
    	Cashiercode = PropertyHandler.getPropValue(dataFilePath,Cashiercode);
    	
    	 
        enterKeys(txt_Airportcode, origin);
        click(cashdrawtypelov);
        minWait();
        waitForNewWindow(2);
        switchToSecondWindow();
        enterKeys(txt_CASHDRAWTYPELOV_CODE, Cashiercode);
        click(btn_CASHDRAWTYPELOV_LIST);
        check(chk_selectCheckBox);
        click(btn_CASHDRAWTYPELOV_OK);
        switchToFirstWindow();
         waitForFrameAndSwitch(FRAME);
        click(btn_list);
       minWait();
       enterKeys(txt_Maxamount, value);
       enterKeys(txt_Maxtxnamount, value);
       click(btn_Save);
       minWait();
       enterKeys(txt_Airportcode, origin);
       enterKeys(txt_Cashdrawtype, Cashiercode);
        click(btn_list);
      minWait();
      Assert.assertEquals(waitForElement(txt_Maxamount).getAttribute("value").replaceAll(",",""), value);
      
        return this;
    }
    /**
     * List the details 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH005 Modification_afterverifications(String origin,String Cashiercode,String value ) {

    	origin = PropertyHandler.getPropValue(dataFilePath,origin);
    	Cashiercode = PropertyHandler.getPropValue(dataFilePath,Cashiercode);
    	
    	 
         enterKeys(txt_Airportcode, origin);
       enterKeys(txt_Cashdrawtype, Cashiercode);
        click(btn_list);
      minWait();
      Assert.assertEquals(waitForElement(txt_Maxamount).getAttribute("value").replaceAll(",",""), value);
      
        return this;
    }
    /**
     * List the details 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH005 check_inactive(String origin,String Cashiercode,boolean value ) {

    	origin = PropertyHandler.getPropValue(dataFilePath,origin);
    	Cashiercode = PropertyHandler.getPropValue(dataFilePath,Cashiercode);
    	
    	 
        enterKeys(txt_Airportcode, origin);
        enterKeys(txt_Cashdrawtype, Cashiercode);
         click(btn_list);
       minWait();
       if(value){
    	   check(chk_check);
       }
       else{
    	   unCheck(chk_check);
       }
        click(btn_Save);
        minWait();
        return this;
    } /**
     * List the details 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH005 check_foreginCurrencyAllowed(String origin,String Cashiercode,boolean value ) {

    	origin = PropertyHandler.getPropValue(dataFilePath,origin);
    	Cashiercode = PropertyHandler.getPropValue(dataFilePath,Cashiercode);
    	
    	 
        enterKeys(txt_Airportcode, origin);
        enterKeys(txt_Cashdrawtype, Cashiercode);
         click(btn_list);
       minWait();
       if(value){
    	   check(chk_foreginCurrencyAllowed);
       }
       else{
    	   unCheck(chk_foreginCurrencyAllowed);
       }
        click(btn_Save);
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
