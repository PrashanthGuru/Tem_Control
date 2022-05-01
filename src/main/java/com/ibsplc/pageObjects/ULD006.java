package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**Page ULD006 : List ULD
 * 
 * @author a-7868
 * created on 22/12/2017
 *
 */
public class ULD006 extends BasePage{

	 private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	 public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	 public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	 
	 public static String FRAME = "iCargoContentFrameULD006";
	 public static String FRAME1 = "iCargoContentFrameULD002";
	 private By  txt_uldNum,
	 			 btn_close,
				 btn_list,
				 Text_airlineCode,
				 Text_ownerAirline,
				 tbl_uldDtls,
				 img_tic,
				 btn_clear,
				 info_LoanedFromValue,
				 btn_genericOk,
				 Generic_btn_noBtn,
				 btn_SendSCMbutton,
				 btn_SendSCMbutton_addAddrDtls,
				 btn_SendSCMbutton_interfacesys,
				 btn_Closebutton,
				 BUTTON_Deletebutton,
				 btn_SendSCMbutton_Okbutton,
				 BUTTON_GenerateSCMbutton,
				 BUTTON_Printbutton,
				 check_uld,
				 info_LoanedToValue,
				 div_expand,
				 yesBtn;
	 
	 private WebDriver driver;
	 private String screenFrame;
	 private String dataFileName;
	 
	 public ULD006(WebDriver driver, String dataFileName) {
		 super(driver);
	     this.driver = driver;
	     initElements();
	     this.dataFilePath = this.dataFilePath + dataFileName;
	     this.dataFileName = dataFileName;
	    }
	 
	 /**
	  * Method to initialize page objects
	  * 
	  * @author a-7868
	  * <on 22/12/2017>
	  */
	 private void initElements() {
		 
		 txt_uldNum           = MiscUtility.getWebElement(objFilepath,"ULD006_txt_uldNo");
		 btn_list	          = MiscUtility.getWebElement(objFilepath,"ULD006_btn_list");
		 tbl_uldDtls          = MiscUtility.getWebElement(objFilepath,"ULD006_tbl_uldDtls");
		 img_tic	          = MiscUtility.getWebElement(objFilepath,"ULD006_img_tic");
		 btn_close	          = MiscUtility.getWebElement(objFilepath,"ULD006_btn_close");		 
		 btn_clear	          = MiscUtility.getWebElement(objFilepath,"ULD006_btn_clear");
		 info_LoanedFromValue = MiscUtility.getWebElement(objFilepath,"ULD006_info_LoanedFromValue");
		 info_LoanedToValue = MiscUtility.getWebElement(objFilepath,"ULD006_info_LoanedToValue");
		 btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		 yesBtn		          = MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
		 Text_airlineCode = MiscUtility.getWebElement(objFilepath,"ULD006_Text_airlineCode");
		 Text_ownerAirline = MiscUtility.getWebElement(objFilepath,"ULD006_Text_ownerAirline");
		 BUTTON_Deletebutton= MiscUtility.getWebElement(objFilepath,"ULD006_BUTTON_Deletebutton");
		 Generic_btn_noBtn= MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		 BUTTON_Printbutton= MiscUtility.getWebElement(objFilepath,"ULD006_BUTTON_Printbutton");
		 BUTTON_GenerateSCMbutton= MiscUtility.getWebElement(objFilepath,"ULD006_BUTTON_GenerateSCMbutton");
		 btn_SendSCMbutton= MiscUtility.getWebElement(objFilepath,"ULD002_btn_SendSCMbutton");
	     btn_SendSCMbutton_addAddrDtls = MiscUtility.getWebElement(objFilepath,"ULD002_btn_SendSCMbutton_addAddrDtls");
		 btn_SendSCMbutton_interfacesys = MiscUtility.getWebElement(objFilepath,"ULD002_btn_SendSCMbutton_interfacesys");
		 btn_Closebutton = MiscUtility.getWebElement(objFilepath,"ULD002_btn_Closebutton");
		 btn_SendSCMbutton_Okbutton= MiscUtility.getWebElement(objFilepath,"ULD002_btn_SendSCMbutton_Okbutton");
		 div_expand= MiscUtility.getWebElement(objFilepath,"ULD006_div_expand");
		 check_uld= MiscUtility.getWebElement(objFilepath,"ULD006_check_uld");
	
	 }
	 
	 /**
	  * Method to verify ULD status
	  * on 22/12/2017
	  * @param uldNum
	  * @return
	  * @author a-7868
	  */
	 public ULD006 verifyOverallStatus(String uldNum, String status) {
		 
		 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
		 status= PropertyHandler.getPropValue(dataFilePath,status);
		 
		 list(uldNum);
		 List<String> stat = getTableColumnValues(tbl_uldDtls, 8);	  //Status column = 8 		 
		 Assert.assertTrue(stat.contains(status), "ERROR : ULD Status mismatch.");
		 click(btn_clear);
		 return this;
	 }
	 /**
	  * This is a work around to expand search fields
	  */
	 private void refreshPage(){
		 try{
			 enterKeys(btn_close, Keys.F5);
		 }catch(StaleElementReferenceException e){}
	 }
	 /**
	  * Method to verify ULD status
	  * on 22/12/2017
	  * @param uldNum
	  * @return
	  * @author a-6545
	  */
	 public ULD006 verifydetails_Delete(String uldNum,String compCode) {
		 
		 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
		 compCode= PropertyHandler.getPropValue(dataFilePath,compCode);
		
		 enterKeys(Text_airlineCode, compCode);
		 click(btn_list);
		 minWait();
		 Assert.assertTrue(waitForElement(tbl_uldDtls).getText().contains("AV"));
		 refreshPage();
		 minWait();
		 click(btn_clear);
		 minWait();
		 enterKeys(Text_ownerAirline, compCode);
		 click(Text_ownerAirline);
		 click(btn_list);
		 minWait();
		 Assert.assertTrue(waitForElement(tbl_uldDtls).getText().contains("AV"));
		
		 click(BUTTON_Printbutton);
		 waitForNewWindow(2);
	   	  switchToSecondWindow();
		 driver.close();
		 switchToFirstWindow();
         waitForFrameAndSwitch(FRAME);
         refreshPage();
		 minWait();
		 click(btn_clear);
		 minWait();
		 list(uldNum);
		 tblSelectRowByColValue(tbl_uldDtls, 1, 2, uldNum);
		 click(BUTTON_Deletebutton);
		 driver.switchTo().defaultContent();
		 minWait();
		 if (verifyElementPresent(Generic_btn_noBtn)) {
             click(Generic_btn_noBtn);
             waitForFrameAndSwitch(FRAME);
         }
		 click(BUTTON_Deletebutton);
		 driver.switchTo().defaultContent();
		 minWait();
		 if (verifyElementPresent(yesBtn)) {
             click(yesBtn);
             waitForFrameAndSwitch(FRAME);
         }
		 

           return this;
	 }
	 /**
	  * Method to verify ULD status
	  * on 22/12/2017
	  * @param uldNum
	  * @return
	  * @author a-6545
	  */
	 public ULD006 GenerateSCM(String uldNum) {
		 
		 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
    	 list(uldNum);
    	 check(check_uld);
		 click(BUTTON_GenerateSCMbutton);
		 minWait();
		
		 click(btn_SendSCMbutton);
		  driver.switchTo().defaultContent();
		 minWait();
		 if (verifyElementPresent(Generic_btn_noBtn)) {
             click(Generic_btn_noBtn);
             waitForFrameAndSwitch(FRAME);
         }

		 click(btn_SendSCMbutton);
		 driver.switchTo().defaultContent();
		 minWait();
		 if (verifyElementPresent(yesBtn)) {
             click(yesBtn);
             waitForFrameAndSwitch(FRAME);
         }
		 waitForNewWindow(2);
   	  switchToSecondWindow();
		 click(btn_SendSCMbutton_addAddrDtls);
		   selectByIndex(btn_SendSCMbutton_interfacesys, 1);
		   click(btn_SendSCMbutton_Okbutton);
		   switchToFirstWindow();
           waitForFrameAndSwitch(FRAME);
           
		   driver.switchTo().defaultContent();
		   click(btn_genericOk);
		   minWait();
		  // click(btn_Closebutton);
		  // minWait();
		  // click(btn_close);
		   
           return this;
	 }
	 
	 /**
	  * Method to verify ULD Transit status
	  * on 22/12/2017
	  * @param uldNum
	  * @return
	  * @author a-7868
	  */
	 public ULD006 verifyTransitStatus(String uldNum) {
		 
		 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
		 
		 list(uldNum);
		 Assert.assertTrue(waitForElement(img_tic).isDisplayed(), "ERROR : Transit status mismatch.");
		 click(btn_clear);
		 return this;
	 }
	
	 /**VerifyHistoryLoanedToandLoanedFrom
	  * 
	  * Method to verify Loaned to and Loaned from values
	  * on 27/12/2017
	  * @param uldNum
	  * @return
	  * @author a-6784
	  */
	 
	 
public ULD006 VerifyHistoryLoanedToandLoanedFrom(String uldNum ,String Loaned_To_Value ,String Loaned_From_value) {
		 
		 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
		 Loaned_To_Value=PropertyHandler.getPropValue(dataFilePath,Loaned_To_Value);
		 Loaned_From_value=PropertyHandler.getPropValue(dataFilePath,Loaned_From_value);
		 List<WebElement> WebLoanedToval =getWebElements(info_LoanedToValue);
		 List<WebElement> WebLoanedFromval =getWebElements(info_LoanedFromValue);
		 
		 
		 
		 list(uldNum);
		 minWait();
		// Assert.assertTrue(info_LoanedToValue).contains(Loaned_To_Value ,"ERROR : Loaned To Value Match.");
		 //.Assert.assertTrue(info_LoanedToValue).getText().matches(Loaned_To_Value);
		 Assert.assertEquals(WebLoanedToval, Loaned_To_Value);
		 Assert.assertEquals(WebLoanedFromval, Loaned_From_value);
		 click(btn_clear);
		 return this; 
		
	 }
	  
	 
	 
	 
	 /**
	  * Method to list a ULD
	  * on 22/12/2017 
	  * @param uldNum
	  * @author a-7868
	  */
	 public void list(String uldNum) {
		 enterKeys(txt_uldNum, uldNum);
		 click(btn_list);
	 }
	 /**
	  * Method to close current page and return to Homepae
	 * returns the instance of Homepage
	 * @return
	 * @author a-7868
		 */
    public HomePage close() {    	
        
        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver,dataFileName);
    }
}
