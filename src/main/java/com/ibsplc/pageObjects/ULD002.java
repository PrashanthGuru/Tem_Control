package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Page ULD002 : 
 * 
 * @author a-6545
 *
 */
public class ULD002 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	 
	public static String FRAME = "iCargoContentFrameULD002";
	
	private By   txt_AIRLINE,
	btn_list,
	txt_ULDNO,
	btn_STOCKCHECK_LIST,
	btn_SEND_SCM,
	btn_SIGHTED,
	addAddrDtls,
	list_INFSYS_COMBO0,
	btn_OK,
	chk_checkSysStockAll,
	btn_genericYes,
	btn_MARK,
	Generic_info_msg,
	Generic_btn_ok,
	Generic_btn_noBtn,
	btn_CLOSE;
	
	
	private WebDriver driver;
	private String screenFrame;
	private String dataFileName;
	
	public ULD002(WebDriver driver, String dataFileName) {
		 super(driver);
	     this.driver = driver;
	     initElements();
	     this.dataFilePath = this.dataFilePath + dataFileName;
	     this.dataFileName = dataFileName;
	    }
	
	/**
	 * Method to initialize page objects
	 * 27/12/2017
	 * 
	 * @author a-7868
	 */
	private void initElements() {
		 
		
		txt_AIRLINE = MiscUtility.getWebElement(objFilepath,"ULD002_txt_AIRLINE");
		btn_list	= MiscUtility.getWebElement(objFilepath,"ULD002_btn_list");
		txt_ULDNO= MiscUtility.getWebElement(objFilepath,"ULD002_txt_ULDNO");
		btn_STOCKCHECK_LIST	= MiscUtility.getWebElement(objFilepath,"ULD002_btn_STOCKCHECK_LIST");	
		btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		btn_SEND_SCM	= MiscUtility.getWebElement(objFilepath,"ULD002_btn_SEND_SCM");	 
		Generic_info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		Generic_btn_noBtn= MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		Generic_btn_ok= MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		btn_CLOSE	= MiscUtility.getWebElement(objFilepath,"ULD002_btn_CLOSE");
		addAddrDtls = MiscUtility.getWebElement(objFilepath,"ULD002_addAddrDtls");
		list_INFSYS_COMBO0 = MiscUtility.getWebElement(objFilepath,"ULD002_list_INFSYS_COMBO0");
		btn_OK = MiscUtility.getWebElement(objFilepath,"ULD002_btn_OK");
		btn_SIGHTED = MiscUtility.getWebElement(objFilepath,"ULD002_btn_SIGHTED");
		btn_MARK= MiscUtility.getWebElement(objFilepath,"ULD002_btn_MARK");
		chk_checkSysStockAll= MiscUtility.getWebElement(objFilepath,"ULD002_chk_checkSysStockAll");
	 }
	
	/**
	 * Method to send SCM
	 * 
	 
	 * @return
	 * @author a-6545
	 */
	public ULD002 Send_SCM(String airline,String uldNum) {
		
		airline	= PropertyHandler.getPropValue(dataFilePath,airline);
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
		
		enterKeys(waitForElement(txt_AIRLINE), airline);
		click(btn_list);
		minWait();
		enterKeys(txt_ULDNO, uldNum);
		click(btn_STOCKCHECK_LIST);
		click(btn_SEND_SCM);
		  driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("SCM message will be sent to the configured addresses. Do you want to include additional addresses before sending"));
		if (verifyElementPresent(Generic_btn_noBtn)) {

	           click(Generic_btn_noBtn);
	           waitForFrameAndSwitch(FRAME);
	       }
		minWait();
		click(btn_SEND_SCM);
		  driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("SCM message will be sent to the configured addresses. Do you want to include additional addresses before sending"));
		if (verifyElementPresent(btn_genericYes)) {

	           click(btn_genericYes);
	           waitForFrameAndSwitch(FRAME);
	       }
		 waitForNewWindow(2);
         switchToSecondWindow();
         click(addAddrDtls);
         minWait();
         selectByIndex(list_INFSYS_COMBO0,1);
         click(btn_OK);
         switchToFirstWindow();
         waitForFrameAndSwitch(FRAME);
         driver.switchTo().defaultContent();
         click(Generic_btn_ok);
         waitForFrameAndSwitch(FRAME);
         
			return this;
	}
	/**
	 * Method to send SCM diff station
	 * 
	 
	 * @return
	 * @author a-6545
	 */
	public ULD002 Send_SCM_Diff_Stn(String airline,String uldNum,String dest) {
		
		airline	= PropertyHandler.getPropValue(dataFilePath,airline);
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
		dest	= PropertyHandler.getPropValue(dataFilePath,dest);
		
		enterKeys(waitForElement(txt_AIRLINE), airline);
		click(btn_list);
		minWait();
	click(btn_STOCKCHECK_LIST);
		click(btn_SEND_SCM);
		  driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("SCM message will be sent to the configured addresses. Do you want to include additional addresses before sending"));
		if (verifyElementPresent(Generic_btn_noBtn)) {

	           click(Generic_btn_noBtn);
	           waitForFrameAndSwitch(FRAME);
	       }
			return this;
	}
	/**
	 * Method to Mark_as_Sighted
	 * 
	 
	 * @return
	 * @author a-6545
	 */
	public ULD002 Mark_as_Sighted(String airline,String uldNum) {
		
		airline	= PropertyHandler.getPropValue(dataFilePath,airline);
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
		
		enterKeys(waitForElement(txt_AIRLINE), airline);
		click(btn_list);
		minWait();
		enterKeys(txt_ULDNO, uldNum);
		click(btn_STOCKCHECK_LIST);
		check(chk_checkSysStockAll);
		click(btn_SIGHTED);
		  driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("Do you want to mark the selected ULD(s) as Sighted"));
		if (verifyElementPresent(Generic_btn_noBtn)) {

	           click(Generic_btn_noBtn);
	           waitForFrameAndSwitch(FRAME);
	       }
		minWait();
		click(btn_SIGHTED);
		  driver.switchTo().defaultContent();
			Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("Do you want to mark the selected ULD(s) as Sighted"));
			if (verifyElementPresent(btn_genericYes)) {

	           click(btn_genericYes);
	           waitForFrameAndSwitch(FRAME);
	       }
		
			return this;
	}

	/**
	 * Method to mark as Missing
	 * 
	 
	 * @return
	 * @author a-6545
	 */
	public ULD002 Mark_as_Missing(String airline,String uldNum) {
		
		airline	= PropertyHandler.getPropValue(dataFilePath,airline);
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
		
		enterKeys(waitForElement(txt_AIRLINE), airline);
		click(btn_list);
		minWait();
		enterKeys(txt_ULDNO, uldNum);
		click(btn_STOCKCHECK_LIST);
		check(chk_checkSysStockAll);
		click(btn_MARK);
		  driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("Do you want to mark the selected ULD(s) as missing"));
		if (verifyElementPresent(Generic_btn_noBtn)) {

	           click(Generic_btn_noBtn);
	           waitForFrameAndSwitch(FRAME);
	       }
		minWait();
		click(btn_MARK);
		  driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("Do you want to mark the selected ULD(s) as missing"));
		if (verifyElementPresent(btn_genericYes)) {

	           click(btn_genericYes);
	           waitForFrameAndSwitch(FRAME);
	       }
		
		
         
			return this;
	}

	
	
	
	/**
	  * Method to close current page and return to Homepae
	 * returns the instance of Homepage
	 * @return
	 * @author a-6545
		 */
	public HomePage close() {    	
       
       click(btn_CLOSE);
       driver.switchTo().defaultContent();
       if (verifyElementPresent(btn_genericYes)) {

           click(btn_genericYes);
       }
       return new HomePage(driver,dataFileName);
   }
}
