/**
 * 
 */
package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class CSH003 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "LTE_CSH_CLM.properties");
    private static String FRAME = "iCargoContentFrameCSH003";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By 
    btn_CLOSECASHDRAW,
  btn_START,
  btn_LOGOFF,
    btn_CLOSE,
    btn_Viewlog,
    btn_ViewlogPrint,
    btn_FORCECLOSE_OK,
    btn_ViewlogClose,
    btn_PRINT,
    btn_SAVE,
    btn_LOGIN,
    div_COLLECTION_SUMMARY,
    tbl_Fop,
    div_CURRENCY_SUMMARY,
    div_CASH_DENOMINATION,
    addLink,
    txt_denominations,
    txt_denominationCounts,
    txt_denominationAmounts,
    txt_actualAmount,
    txt_FORCECLOSE_REMARKS,
    div_FOP_SUMMARY,
    btn_FORCECLOSE,
    lnk_treetableexpand,
    lnk_treetableexpand2,

    tbl_credit,
    Generic_info_msg,
    btn_genericYes;

   
    public CSH003(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
    	btn_CLOSECASHDRAW = MiscUtility.getWebElement(objFilepath, "CSH003_btn_CLOSECASHDRAW");
    	btn_CLOSE = MiscUtility.getWebElement(objFilepath, "CSH003_btn_CLOSE");
    	btn_START = MiscUtility.getWebElement(objFilepath, "CSH003_btn_START");
    	btn_CLOSE = MiscUtility.getWebElement(objFilepath, "CSH003_btn_CLOSE");
    	btn_SAVE = MiscUtility.getWebElement(objFilepath, "CSH003_btn_SAVE");
    	btn_LOGOFF= MiscUtility.getWebElement(objFilepath, "CSH003_btn_LOGOFF");
       btn_LOGIN= MiscUtility.getWebElement(objFilepath, "CSH003_btn_LOGIN");
       btn_Viewlog= MiscUtility.getWebElement(objFilepath, "CSH003_btn_Viewlog");
       btn_ViewlogPrint= MiscUtility.getWebElement(objFilepath, "CSH003_btn_ViewlogPrint");
       btn_ViewlogClose= MiscUtility.getWebElement(objFilepath, "CSH003_btn_ViewlogClose");
        btn_PRINT= MiscUtility.getWebElement(objFilepath, "CSH003_btn_PRINT");
        div_COLLECTION_SUMMARY = MiscUtility.getWebElement(objFilepath, "CSH003_div_COLLECTION_SUMMARY");
        div_CURRENCY_SUMMARY = MiscUtility.getWebElement(objFilepath, "CSH003_div_CURRENCY_SUMMARY");
        div_CASH_DENOMINATION = MiscUtility.getWebElement(objFilepath, "CSH003_div_CASH_DENOMINATION");
        div_FOP_SUMMARY = MiscUtility.getWebElement(objFilepath, "CSH003_div_FOP_SUMMARY");
        addLink = MiscUtility.getWebElement(objFilepath, "CSH003_addLink");
        txt_denominations = MiscUtility.getWebElement(objFilepath, "CSH003_txt_denominations");
        txt_denominationCounts = MiscUtility.getWebElement(objFilepath, "CSH003_txt_denominationCounts");
        txt_denominationAmounts = MiscUtility.getWebElement(objFilepath, "CSH003_txt_denominationAmounts");
        txt_actualAmount = MiscUtility.getWebElement(objFilepath, "CSH003_txt_actualAmount");
        tbl_Fop = MiscUtility.getWebElement(objFilepath, "CSH003_tbl_Fop");
       btn_FORCECLOSE= MiscUtility.getWebElement(objFilepath, "CSH003_btn_FORCECLOSE");
       btn_FORCECLOSE_OK= MiscUtility.getWebElement(objFilepath, "CSH003_btn_FORCECLOSE_OK");
       txt_FORCECLOSE_REMARKS= MiscUtility.getWebElement(objFilepath, "CSH003_txt_FORCECLOSE_REMARKS");
       lnk_treetableexpand = MiscUtility.getWebElement(objFilepath, "CSH003_lnk_treetableexpand");
       lnk_treetableexpand2 = MiscUtility.getWebElement(objFilepath, "CSH003_lnk_treetableexpand2");
       tbl_credit = MiscUtility.getWebElement(objFilepath, "CSH003_tbl_credit");
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
    public CSH003 CLOSECASHDRAW() {

         click(btn_CLOSECASHDRAW);
       minWait();
      
        return this;
    }
    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH003 StartCASHDRAW() {

         click(btn_START);
         minWait();
      
        return this;
    }
    /**
      * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH003 LogOff() {

         click(btn_LOGOFF);
         minWait();
      
        return this;
    }  /**
     * @param 
    * @param  login
    * @return
    * @author A-6545 on 20/2/2018.
    */
   public CSH003 LogIn() {

        click(btn_LOGIN);
        minWait();
     
       return this;
   }
   /**
    * @param 
   * @param  login
   * @return
   * @author A-6545 on 20/2/2018.
   */
   public CSH003 Viewlog(String Currency) {
	
		//   Currency = PropertyHandler.getPropValue(dataFilePath,Currency);
       		
       minWait();
       waitForNewWindow(2);
      switchToSecondWindow();
      click(btn_ViewlogPrint);
      click(btn_ViewlogClose);
      minWait();
      switchToFirstWindow();
      waitForFrameAndSwitch(FRAME);
      click(btn_PRINT);
      waitForNewWindow(2);
      switchToSecondWindow();
      driver.close();
      switchToFirstWindow();
      waitForFrameAndSwitch(FRAME);
      minWait();
      Assert.assertTrue(waitForElement(div_COLLECTION_SUMMARY).getText().contains(Currency));
      Assert.assertTrue(waitForElement(div_CURRENCY_SUMMARY).getText().contains(Currency));
      Assert.assertTrue(waitForElement(div_FOP_SUMMARY).getText().contains(Currency));
      
      return this;
  }
   /**
    * @param 
   * @param  login
   * @return
   * @author A-6545 on 20/2/2018.
   */
   public CSH003 Calc_CASH_DENOMINATION() {
	//   Currency = PropertyHandler.getPropValue(dataFilePath,Currency);
	   click(addLink);
       enterKeys(txt_denominations, "100");
       enterKeys(txt_denominationCounts, "10" + Keys.TAB);
       minWait();
       click(btn_SAVE);
       minWait();
    String value=   tblGetTextByColValue(tbl_Fop, 3, 1, "CASH");
    System.out.println(value);
    String value1=   tblGetTextByColValue_input(tbl_Fop, 4, 1, "CASH");
    System.out.println(value1);
       Assert.assertTrue(waitForElement(txt_denominationAmounts).getAttribute("value").replaceAll(",","").equals("1000.0"));
       Assert.assertEquals(value1.replaceAll(",",""),"1000");
      
      CLOSECASHDRAW(); 
      driver.switchTo().defaultContent();
      if (verifyElementPresent(btn_genericYes)) {
    	  Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("System Calculated amount is different from actual amount"));
          click(btn_genericYes);
          waitForFrameAndSwitch(FRAME);
      }
      return this;
  }
   /**
    * @param 
   * @param  login
   * @return
   * @author A-6545 on 20/2/2018.
   */
   public CSH003 Calc_CASH_same_DENOMINATION() {
	
       minWait();
    String value=   tblGetTextByColValue(tbl_Fop, 3, 1, "CASH");
    System.out.println(value);
  String temp= value.split(" ")[1].replaceAll(",","");
  System.out.println(temp);
  int code= Integer.parseInt(temp);
  int code1=code/2;

  
  enterKeys(txt_denominations, ""+code1);
  enterKeys(txt_denominationCounts, "2" + Keys.TAB);
  minWait();

      minWait();
      CLOSECASHDRAW(); 
    
      return this;
  }
   
   
   public CSH003 FORCECLOSE() {
		
       minWait();
  click( btn_FORCECLOSE); 
  minWait();
  waitForNewWindow(2);
  switchToSecondWindow();
  enterKeys(txt_FORCECLOSE_REMARKS, "REMARKS");
 
  click(btn_FORCECLOSE_OK);
  minWait();
  switchToFirstWindow();
  waitForFrameAndSwitch(FRAME);
      return this;
  }
   //verify the FORCECLOSE status
   
   public CSH003 Verify_FORCECLOSE() {
		
       minWait();
       Assert.assertTrue(waitForElementVisible(btn_FORCECLOSE).isEnabled(),"Start button should be Enabled");

      return this;
  }
   
    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH003 StartCASHDRAW_Verify() {
    	Assert.assertFalse(waitForElementVisible(btn_START).isEnabled(),"Start button should be disabled");

         minWait();
      
        return this;
    }
    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH003 Verify_COLLECTION_SUMMARY() {
    	click(lnk_treetableexpand);
    	Assert.assertTrue(waitForElementVisible(tbl_credit).getText().contains("REMARKS"));
   
    	click(lnk_treetableexpand2);
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

        click(btn_CLOSE);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}
