/**
 * 
 */
package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author A-6545 on 16/2/2018.
 *
 */
import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class SHR110 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    private static String FRAME = "iCargoContentFrameSHR110";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By txt_CustCode,
    btn_List,
    btn_Save,
    lnk_add,
    txt_RefCode,
    txt_Amount,
    txt_validTillCalendar,
    list_GuaranteeType,
    txt_Guarantee_Amount,
     txt_Remarks, 
     txt_RefCodelist2,
     txt_Amountlist2,
     txt_validTillCalendarlist2,
     list_GuaranteeTypelist2,
     txt_Guarantee_Amountlist2,
     txt_AmtToBeRptd,
      txt_Remarkslist2,  
     txt_RefCode2,
     txt_Amount2,
     txt_BalanceAvailable,
     txt_validTillCalendar2,
     list_GuaranteeType2,
     txt_Guarantee_Amount2,
      txt_Remarks2, 
      txt_RefCode1,
      txt_Amount1,
      txt_validTillCalendar1,
      list_GuaranteeType1,
      txt_Guarantee_Amount1,
       txt_Remarks1, 
      txt_RefCode3,
      txt_Amount3,
      txt_validTillCalendar3,
      list_GuaranteeType3,
      txt_Guarantee_Amount3,
       txt_Remarks3, 
       txt_RefCode4,
       txt_Amount4,
       txt_validTillCalendar4,
       list_GuaranteeType4,
       txt_Guarantee_Amount4,
        txt_Remarks4, 
        txt_RefCode5,
        txt_Amount5,
        txt_validTillCalendar5,
        list_GuaranteeType5,
        txt_Guarantee_Amount5,
         txt_Remarks5,  
     chk_check ,
     chk_depleteForAwbChgs, 
     chk_depleteForNonAwbChgs,
     lnk_delete,
    btn_genericYes,
    dropdown_GuaranteeType,
    btn_Close,
    info_dailogmsg,
    btn_dialog;

   
    public SHR110(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

    	txt_CustCode = MiscUtility.getWebElement(objFilepath, "SHR110_txt_CustCode");
        btn_List = MiscUtility.getWebElement(objFilepath, "SHR110_btn_List");
    	btn_Save = MiscUtility.getWebElement(objFilepath, "SHR110_btn_Save");
    	btn_Close = MiscUtility.getWebElement(objFilepath, "SHR110_btn_Close");
    	lnk_add = MiscUtility.getWebElement(objFilepath, "SHR110_lnk_add");
        txt_RefCode= MiscUtility.getWebElement(objFilepath, "SHR110_txt_RefCode");
        txt_Amount= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Amount");
        txt_validTillCalendar= MiscUtility.getWebElement(objFilepath, "SHR110_txt_validTillCalendar");
        list_GuaranteeType= MiscUtility.getWebElement(objFilepath, "SHR110_list_GuaranteeType");
        txt_Guarantee_Amount= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Guarantee_Amount");
        txt_Remarks= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Remarks"); 
        txt_RefCodelist2= MiscUtility.getWebElement(objFilepath, "SHR110_txt_RefCodelist2");
        txt_Amountlist2= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Amountlist2");
        txt_validTillCalendarlist2= MiscUtility.getWebElement(objFilepath, "SHR110_txt_validTillCalendarlist2");
        list_GuaranteeTypelist2= MiscUtility.getWebElement(objFilepath, "SHR110_list_GuaranteeTypelist2");
        txt_Guarantee_Amountlist2= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Guarantee_Amountlist2");
        txt_Remarkslist2= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Remarkslist2"); 
        txt_RefCode2= MiscUtility.getWebElement(objFilepath, "SHR110_txt_RefCode2");
        txt_Amount2= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Amount2");
        txt_validTillCalendar2= MiscUtility.getWebElement(objFilepath, "SHR110_txt_validTillCalendar2");
        list_GuaranteeType2= MiscUtility.getWebElement(objFilepath, "SHR110_list_GuaranteeType2");
        txt_Guarantee_Amount2= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Guarantee_Amount2");
        txt_Remarks2= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Remarks2"); 
        txt_RefCode3= MiscUtility.getWebElement(objFilepath, "SHR110_txt_RefCode3");
        txt_Amount1= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Amount1");
        txt_validTillCalendar1= MiscUtility.getWebElement(objFilepath, "SHR110_txt_validTillCalendar1");
        list_GuaranteeType1= MiscUtility.getWebElement(objFilepath, "SHR110_list_GuaranteeType1");
        txt_Guarantee_Amount1= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Guarantee_Amount1");
        txt_Remarks1= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Remarks1"); 
     txt_RefCode1= MiscUtility.getWebElement(objFilepath, "SHR110_txt_RefCode1");
        txt_Amount3= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Amount3");
        txt_validTillCalendar3= MiscUtility.getWebElement(objFilepath, "SHR110_txt_validTillCalendar3");
        list_GuaranteeType3= MiscUtility.getWebElement(objFilepath, "SHR110_list_GuaranteeType3");
        txt_Guarantee_Amount3= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Guarantee_Amount3");
        txt_Remarks3= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Remarks3"); 
        txt_RefCode4= MiscUtility.getWebElement(objFilepath, "SHR110_txt_RefCode4");
        txt_Amount4= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Amount4");
        txt_validTillCalendar4= MiscUtility.getWebElement(objFilepath, "SHR110_txt_validTillCalendar4");
        list_GuaranteeType4= MiscUtility.getWebElement(objFilepath, "SHR110_list_GuaranteeType4");
        txt_Guarantee_Amount4= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Guarantee_Amount4");
        txt_Remarks4= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Remarks4"); 
        txt_RefCode5= MiscUtility.getWebElement(objFilepath, "SHR110_txt_RefCode5");
        txt_Amount5= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Amount5");
        txt_validTillCalendar5= MiscUtility.getWebElement(objFilepath, "SHR110_txt_validTillCalendar5");
        list_GuaranteeType5= MiscUtility.getWebElement(objFilepath, "SHR110_list_GuaranteeType5");
        txt_Guarantee_Amount5= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Guarantee_Amount5");
        txt_Remarks5= MiscUtility.getWebElement(objFilepath, "SHR110_txt_Remarks5"); 
         chk_check= MiscUtility.getWebElement(objFilepath, "SHR110_chk_check"); 
        chk_depleteForAwbChgs= MiscUtility.getWebElement(objFilepath, "SHR110_chk_depleteForAwbChgs"); 
        chk_depleteForNonAwbChgs= MiscUtility.getWebElement(objFilepath, "SHR110_chk_depleteForNonAwbChgs");
        txt_AmtToBeRptd= MiscUtility.getWebElement(objFilepath, "SHR110_txt_AmtToBeRptd");
        txt_BalanceAvailable= MiscUtility.getWebElement(objFilepath, "SHR110_txt_BalanceAvailable");
        dropdown_GuaranteeType=MiscUtility.getWebElement(objFilepath, "SHR110_dropdown_GuaranteeType");
        lnk_delete= MiscUtility.getWebElement(objFilepath, "SHR110_lnk_delete"); 
    	btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	
    	//A-8255
    	info_dailogmsg = MiscUtility.getWebElement(objFilepath,"SHR110_info_dailogmsg");
    	btn_dialog = MiscUtility.getWebElement(objFilepath,"SHR110_btn_dialog");
    }

    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public SHR110 Save_details(String agentCodeCredit) {

    	agentCodeCredit = PropertyHandler.getPropValue(dataFilePath,agentCodeCredit);
    	
        enterKeys(txt_CustCode, agentCodeCredit);
         click(btn_List);
        minWait();
        click(lnk_add);
        enterKeys(txt_RefCode, agentCodeCredit);
        enterKeys(txt_Amount, "5000");
        minWait();
        try{
        enterKeys(txt_validTillCalendar, "+365");
        }
        catch(UnhandledAlertException e){
        	enterKeys(txt_validTillCalendar, "+365");
   }
        minWait();
        selectByText(list_GuaranteeType, "Security Deposit");
        enterKeys(txt_Guarantee_Amount, "5000");
        try{
        enterKeys(txt_Remarks, "Credit customer"); 
        }
        catch(UnhandledAlertException e){
        	 enterKeys(txt_Remarks, "Credit customer");
   }
        click(btn_Save);
        return this;
    }
    /***
     * 
     * @param agentcode
     * @param guaranteeType
     * @return
     */
   public SHR110 changeGuaranteeType(String agentcode,String guaranteeType){
		
	   agentcode = PropertyHandler.getPropValue(dataFilePath,agentcode);
	 
	   
	   enterKeys(txt_CustCode, agentcode);
	   click(btn_List);
	   minWait();
	   
	   
	   selectByValue(dropdown_GuaranteeType,guaranteeType);
	   click(btn_Save);	
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
    public SHR110 Savemultivalue_details(String agentCodeCredit,String refcodevalue,String refcodevalue2) {

    	agentCodeCredit = PropertyHandler.getPropValue(dataFilePath,agentCodeCredit);
    	String refcode = BizUtility.generateRandomAlphabets(Integer.parseInt("3"));
    	String refcode2 = BizUtility.generateRandomAlphabets(Integer.parseInt("3"));
    	 PropertyHandler.setPropValue(dataFilePath, refcodevalue, refcode);
    	 PropertyHandler.setPropValue(dataFilePath, refcodevalue2, refcode2);
        enterKeys(txt_CustCode, agentCodeCredit);
         click(btn_List);
        minWait();
        check(chk_check);
        click(lnk_delete);
        minWait();
        click(lnk_add);
        enterKeys(txt_RefCode2, refcode);
        enterKeys(txt_Amount2, "13000");
        minWait();
        try{
        enterKeys(txt_validTillCalendar2, "+365");
        }
        catch(UnhandledAlertException e){
        	enterKeys(txt_validTillCalendar2, "+365");
   }
        minWait();
        selectByText(list_GuaranteeType2, "Bank Guarantee");
        enterKeys(txt_Guarantee_Amount2, "13000");
        minWait();
        try{
        enterKeys(txt_Remarks2, "Credit customer"); 
        }
        catch(UnhandledAlertException e){
        	 enterKeys(txt_Remarks2, "Credit customer"); 
   }
        minWait();
        click(lnk_add);
        enterKeys(txt_RefCode3, refcode2);
        enterKeys(txt_Amount3, "15000");
        minWait();
        try{
        enterKeys(txt_validTillCalendar3, "+365");
        }
        catch(UnhandledAlertException e){
        	 enterKeys(txt_validTillCalendar3, "+365");
   }
        minWait();
        selectByText(list_GuaranteeType3, "Barter");
        enterKeys(txt_Guarantee_Amount3, "15000");
        try{
        enterKeys(txt_Remarks3, "Credit customer"); 
        }
        catch(UnhandledAlertException e){
        	  enterKeys(txt_Remarks3, "Credit customer"); 
   }
        click(btn_Save);
        return this;
    }
    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public SHR110 Savemultivalue_SD_BG_BA(String agentCodeCredit,String refcodevalue,String refcodevalue2,String refcodevalue3,String amountreported) {

    	agentCodeCredit = PropertyHandler.getPropValue(dataFilePath,agentCodeCredit);
    
    	String refcode = BizUtility.generateRandomAlphabets(Integer.parseInt("3"));
    	String refcode2 = BizUtility.generateRandomAlphabets(Integer.parseInt("3"));
    	String refcode3 = BizUtility.generateRandomAlphabets(Integer.parseInt("3"));
    	 PropertyHandler.setPropValue(dataFilePath, refcodevalue, refcode);
    	 PropertyHandler.setPropValue(dataFilePath, refcodevalue2, refcode2);
    	 PropertyHandler.setPropValue(dataFilePath, refcodevalue2, refcode3);
        enterKeys(txt_CustCode, agentCodeCredit);
         click(btn_List);
        minWait();
        enterKeys(txt_AmtToBeRptd, amountreported);
       
        check(chk_check);
        click(lnk_delete);
        minWait();
        click(lnk_add);
        enterKeys(txt_RefCode3, refcode);
        enterKeys(txt_Amount3, "10000");
        minWait();
        try{
        enterKeys(txt_validTillCalendar3, "+15");
        }
        catch(UnhandledAlertException e){
        	enterKeys(txt_validTillCalendar3, "+15");
   }
        minWait();
        selectByText(list_GuaranteeType3, "Security Deposit");
        enterKeys(txt_Guarantee_Amount3, "10000");
        minWait();
        try{
        enterKeys(txt_Remarks3, "Credit customer"); 
        }
        catch(UnhandledAlertException e){
        	 enterKeys(txt_Remarks3, "Credit customer"); 
   }
        minWait();
        click(lnk_add);
        enterKeys(txt_RefCode4, refcode2);
        enterKeys(txt_Amount4, "13000");
        minWait();
        try{
        enterKeys(txt_validTillCalendar4, "+10");
        }
        catch(UnhandledAlertException e){
        	 enterKeys(txt_validTillCalendar4, "+10");
   }
        minWait();
        selectByText(list_GuaranteeType4, "Bank Guarantee");
        enterKeys(txt_Guarantee_Amount4, "13000");
        try{
        enterKeys(txt_Remarks4, "Credit customer"); 
        }
        catch(UnhandledAlertException e){
        	  enterKeys(txt_Remarks4, "Credit customer"); 
   } 
        
    minWait();
   click(lnk_add);
   enterKeys(txt_RefCode5, refcode3);
   enterKeys(txt_Amount5, "15000");
   minWait();
   try{
   enterKeys(txt_validTillCalendar5, "+15");
   }
   catch(UnhandledAlertException e){
   	 enterKeys(txt_validTillCalendar5, "+15");
}
   minWait();
   selectByText(list_GuaranteeType5, "Barter");
   enterKeys(txt_Guarantee_Amount5, "15000");
   try{
   enterKeys(txt_Remarks5, "Credit customer"); 
   }
   catch(UnhandledAlertException e){
   	  enterKeys(txt_Remarks5, "Credit customer"); 
}
        click(btn_Save);
        return this;
    }
    
    /**
     * checking the credit limit after execution
     * @param agentcode
     * @param balanceAmt
     * @return
     */
    public SHR110 verifyBalanceDepleted(String agentcode,String balanceAmt){
    	
    	agentcode = PropertyHandler.getPropValue(dataFilePath,agentcode);
    	balanceAmt = PropertyHandler.getPropValue(dataFilePath,balanceAmt);
		
    	  enterKeys(txt_CustCode, agentcode);
          click(btn_List);
          minWait();
          String tempamt=waitForElement(txt_BalanceAvailable).getAttribute("value");
          int currntbal = Integer.parseInt(tempamt);
          int prevBal= Integer.parseInt(balanceAmt);
          
          
          System.out.println("Checking Credit Limit depletion");
        	  Assert.assertTrue(currntbal<prevBal, "Credit Limit not depleted");
        	  
         
    	
    	
    	
    	return this;
    }
   /**
    *  
    * @param agentcode
    * @param balanceAmt
    * @return
    */
    public SHR110 checkCreditLimitDepletionFlag(String agentcode,String balanceAmt){
		
    	agentcode = PropertyHandler.getPropValue(dataFilePath,agentcode);
    	
    	
        enterKeys(txt_CustCode, agentcode);
        click(btn_List);
        minWait();
       
       check(chk_depleteForAwbChgs);
       String tempamt=waitForElement(txt_BalanceAvailable).getAttribute("value");
       
       PropertyHandler.setPropValue(dataFilePath, balanceAmt, tempamt);
       click(btn_Save);
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
    public SHR110 Savemultivalue_SD_BA(String agentCodeCredit,String refcodevalue,String refcodevalue2,String refcodevalue3,String amountreported) {

    	agentCodeCredit = PropertyHandler.getPropValue(dataFilePath,agentCodeCredit);
    
    	String refcode = BizUtility.generateRandomAlphabets(Integer.parseInt("3"));
    	String refcode2 = BizUtility.generateRandomAlphabets(Integer.parseInt("3"));
    	String refcode3 = BizUtility.generateRandomAlphabets(Integer.parseInt("3"));
    	 PropertyHandler.setPropValue(dataFilePath, refcodevalue, refcode);
    	 PropertyHandler.setPropValue(dataFilePath, refcodevalue2, refcode2);
    	 PropertyHandler.setPropValue(dataFilePath, refcodevalue2, refcode3);
        enterKeys(txt_CustCode, agentCodeCredit);
         click(btn_List);
        minWait();
        enterKeys(txt_AmtToBeRptd, amountreported);
       
       /*check(chk_check);
    click(lnk_delete);
        click(btn_Save);
        minWait();
        enterKeys(txt_CustCode, agentCodeCredit);
        maxWait();
        click(btn_List);
        maxWait();*/
        click(lnk_add);
        enterKeys(txt_RefCode1, refcode);
        enterKeys(txt_Amount1, "10000");
        minWait();
        try{
        enterKeys(txt_validTillCalendar1, "+15");
        }
        catch(UnhandledAlertException e){
        	enterKeys(txt_validTillCalendar1, "+15");
   }
        minWait();
        selectByText(list_GuaranteeType1, "Security Deposit");
        enterKeys(txt_Guarantee_Amount1, "10000");
        minWait();
        try{
        enterKeys(txt_Remarks1, "Credit customer"); 
        }
        catch(UnhandledAlertException e){
        	 enterKeys(txt_Remarks1, "Credit customer"); 
   }
        minWait();
        click(lnk_add);
        enterKeys(txt_RefCode2, refcode2);
        enterKeys(txt_Amount2, "15000");
        minWait();
        try{
        enterKeys(txt_validTillCalendar2, "+15");
        }
        catch(UnhandledAlertException e){
        	 enterKeys(txt_validTillCalendar2, "+15");
   }
        minWait();
        selectByText(list_GuaranteeType2, "Barter");
        enterKeys(txt_Guarantee_Amount2, "15000");
        try{
        enterKeys(txt_Remarks2, "Credit customer"); 
        }
        catch(UnhandledAlertException e){
        	  enterKeys(txt_Remarks2, "Credit customer"); 
   } 
        
   
        click(btn_Save);
        return this;
    }
    
    /**
     * 
     * @param agent
     * @param amountToBeReported
     * @return
     */
    public SHR110 storeAmntTobeReported(String agent,String amountToBeReported,String balance){
    	
    	
    	agent =PropertyHandler.getPropValue(dataFilePath, agent);
		
    	
        enterKeys(txt_CustCode, agent);
        click(btn_List);
         minWait();
    	String tmpData=waitForElement(txt_AmtToBeRptd).getAttribute("value");
    	PropertyHandler.setPropValue(dataFilePath, amountToBeReported, tmpData);
    	String tmpbal=waitForElement(txt_BalanceAvailable).getAttribute("value");
    	PropertyHandler.setPropValue(dataFilePath, balance, tmpbal);
    	
    	return this;	
    }
    
    public SHR110 checkbalanceIncrement(String agent,String balance){
    	
    	agent =PropertyHandler.getPropValue(dataFilePath, agent);
    	balance =PropertyHandler.getPropValue(dataFilePath, balance);
    	
    	
        enterKeys(txt_CustCode, agent);
        click(btn_List);
        minWait();
        
        String tmpData=waitForElement(txt_BalanceAvailable).getAttribute("value");
		 int tmpvalue=Integer.parseInt(tmpData);
		 int balamnt=Integer.parseInt(balance);
		 
		 Assert.assertTrue(tmpvalue>balamnt, "ERROR:balance not replenished correctly");
		 return this; 
    	
    }
    /***
     * 
     * @param agent
     * @param amountToBeReported
     * @return
     */
    public SHR110 verifyamntToBeReportedDepletion(String agent,String amountToBeReported){
    	
    	
    	agent =PropertyHandler.getPropValue(dataFilePath, agent);
    	amountToBeReported =PropertyHandler.getPropValue(dataFilePath, amountToBeReported);
    	
        enterKeys(txt_CustCode, agent);
        click(btn_List);
        minWait();
    	
        String tmpData=waitForElement(txt_AmtToBeRptd).getAttribute("value");
		 int tmpvalue=Integer.parseInt(tmpData);
		 int amnt=Integer.parseInt(amountToBeReported);
		 
		 int currentvalue=amnt-200;
        
        Assert.assertTrue(currentvalue==tmpvalue, "ERROR:Amount not depleted");
        
        return this;   
    }
  
  // @author A-6545 on 16/2/2018.
 
   public SHR110 List_details(String agentCodeCredit,String value,String GuaranteeTypevalue) {

   	agentCodeCredit = PropertyHandler.getPropValue(dataFilePath,agentCodeCredit);
 
       enterKeys(txt_CustCode, agentCodeCredit);
        click(btn_List);
       minWait();
       Assert.assertTrue(waitForElement(txt_RefCode).getAttribute("value").equalsIgnoreCase(agentCodeCredit));
       Assert.assertEquals(waitForElement(txt_Amount).getAttribute("value"),value);
      Assert.assertEquals(waitForElement(list_GuaranteeType).getAttribute("value"),GuaranteeTypevalue);
      Assert.assertEquals(waitForElement(txt_Guarantee_Amount).getAttribute("value"),value);
      Assert.assertEquals(waitForElement(txt_Remarks).getAttribute("value"),"Credit customer");
      
       return this;
   }
   // @author A-6545 on 16/2/2018.
   
   public SHR110 List_multivalues(String agentCodeCredit,String value,String GuaranteeTypevalue,String value2,String GuaranteeTypevalue2,String refcodevalue,String refcodevalue2,String BalanceAvailable) {

   	agentCodeCredit = PropertyHandler.getPropValue(dataFilePath,agentCodeCredit);
  	refcodevalue = PropertyHandler.getPropValue(dataFilePath,refcodevalue);
   	refcodevalue2 = PropertyHandler.getPropValue(dataFilePath,refcodevalue2);
   	
       enterKeys(txt_CustCode, agentCodeCredit);
        click(btn_List);
       minWait();
       check(chk_depleteForAwbChgs);
       check(chk_depleteForNonAwbChgs);
       String temp=waitForElement(txt_BalanceAvailable).getAttribute("value");
       PropertyHandler.setPropValue(dataFilePath, BalanceAvailable, temp);
       
       Assert.assertTrue(waitForElement(txt_RefCode).getAttribute("value").equalsIgnoreCase(refcodevalue));
       Assert.assertEquals(waitForElement(txt_Amount).getAttribute("value"),value);
      Assert.assertEquals(waitForElement(list_GuaranteeType).getAttribute("value"),GuaranteeTypevalue);
      Assert.assertEquals(waitForElement(txt_Guarantee_Amount).getAttribute("value"),value);
      Assert.assertEquals(waitForElement(txt_Remarks).getAttribute("value"),"Credit customer");
      Assert.assertTrue(waitForElement(txt_RefCodelist2).getAttribute("value").equalsIgnoreCase(refcodevalue2));
      Assert.assertEquals(waitForElement(txt_Amountlist2).getAttribute("value"),value2);
     Assert.assertEquals(waitForElement(list_GuaranteeTypelist2).getAttribute("value"),GuaranteeTypevalue2);
     Assert.assertEquals(waitForElement(txt_Guarantee_Amountlist2).getAttribute("value"),value2);
     Assert.assertEquals(waitForElement(txt_Remarkslist2).getAttribute("value"),"Credit customer");
     click(btn_Save);
     return this;
   }
 // @author A-6545 on 16/2/2018.
   
   public SHR110 List_multivalues_savebalance(String agentCodeCredit,String value,String GuaranteeTypevalue,String value2,String GuaranteeTypevalue2,String refcodevalue,String refcodevalue2,String BalanceAvailable) {

   	agentCodeCredit = PropertyHandler.getPropValue(dataFilePath,agentCodeCredit);
  	refcodevalue = PropertyHandler.getPropValue(dataFilePath,refcodevalue);
   	refcodevalue2 = PropertyHandler.getPropValue(dataFilePath,refcodevalue2);
   	
       enterKeys(txt_CustCode, agentCodeCredit);
        click(btn_List);
       minWait();
       
       String temp=waitForElement(txt_BalanceAvailable).getAttribute("value");
       PropertyHandler.setPropValue(dataFilePath, BalanceAvailable, temp);
       
    
     return this;
   }
   
   // @author A-6545 on 17/2/2018.
   
   public SHR110 chk_Amttobereported(String agentCodeCredit,String Amttobereported) {

   	agentCodeCredit = PropertyHandler.getPropValue(dataFilePath,agentCodeCredit);
   Amttobereported= PropertyHandler.getPropValue(dataFilePath,Amttobereported);
       enterKeys(txt_CustCode, agentCodeCredit);
        click(btn_List);
       minWait();
       String Amttobereported1=Amttobereported.replaceAll(",","");
    
       int value1=Integer.parseInt(Amttobereported1);
     
       int temp=value1-100;
       String tempvalue2=String.valueOf(temp);
     //  Assert.assertEquals(waitForElement(txt_AmtToBeRptd).getAttribute("value").replaceAll(",",""),temp);
       Assert.assertTrue(waitForElement(txt_AmtToBeRptd).getAttribute("value").replaceAll(",","").equalsIgnoreCase(tempvalue2));
       return this;
   }
   
   public SHR110 Balance_amount(String agentCodeCredit,String ActualAmount,String BalanceAvailable,String tvalue) {

	   	agentCodeCredit = PropertyHandler.getPropValue(dataFilePath,agentCodeCredit);
	   	ActualAmount = PropertyHandler.getPropValue(dataFilePath,ActualAmount);
	   	BalanceAvailable = PropertyHandler.getPropValue(dataFilePath,BalanceAvailable);
	
	       enterKeys(txt_CustCode, agentCodeCredit);
	        click(btn_List);
	       minWait();
	       String ActualAmount1=ActualAmount.replaceAll(",","");
	       String BalanceAvailable1=BalanceAvailable.replaceAll(",","");
	       int value1=Integer.parseInt(ActualAmount1);
	       int tvalue2=Integer.parseInt(tvalue);
	       int temp=tvalue2+value1;
	       int value2=Integer.parseInt(BalanceAvailable1);
	       int temp2=value2-value1;
	       String tempvalue2=String.valueOf(temp2);
	       String tempvalue=String.valueOf(temp);
	       
	       Assert.assertEquals(waitForElement(txt_AmtToBeRptd).getAttribute("value").replaceAll(",",""),tempvalue);
	       Assert.assertEquals(waitForElement(txt_BalanceAvailable).getAttribute("value").replaceAll(",",""),tempvalue2);
	       
	      
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
    
    /*
     * * @author A-8255
     */
     
    public SHR110 verifyCust_Cash_Credit(String Customercode)
    {
    	
    	Customercode= PropertyHandler.getPropValue(dataFilePath,Customercode);
    	enterKeys(txt_CustCode, Customercode);
    	 click(btn_List);
    	 minWait();
    	 driver.switchTo().defaultContent();
    	 
    	 if(verifyElementPresent(info_dailogmsg))
    	 {
    	 Assert.assertTrue(waitForElement(info_dailogmsg).getText().contains("Credit code does not exist"),"Customer should be CREDIT Customer");
           
    	// click(btn_dialog);
    	
    	 }
    	 driver.switchTo().frame(FRAME);
    	 return this;
    }
    
    
    
public SHR110 checkBalanceAvailableLessThanZero(String agent){
    	
    	agent =PropertyHandler.getPropValue(dataFilePath, agent);
    	
    	
    	
        enterKeys(txt_CustCode, agent);
        click(btn_List);
        minWait();
        
        String tmpData=waitForElement(txt_BalanceAvailable).getAttribute("value");
        char tmpvalue=tmpData.charAt(0);
		
		 
		 Assert.assertEquals(tmpvalue,'-',"Error:To run this testcase,balance available must be less than zero");
		 return this; 
    	
    } 
    
    
    
    
    
    
    
    
    
    
    
    
}
