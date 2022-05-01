package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Page ULD023 : 
 * 
 * @author a-6545
 *
 */
public class ULD023 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	 
	public static String FRAME = "iCargoContentFrameULD023";
	
	private By   btn_RADIOUCMIN,
	txt_carrierCode,
	txt_flightNo,
	txt_Date,
	addUld,
	btn_SEND,
    btn_List,
    txt_uldNumbers,
	Generic_info_msg,
	Generic_btn_ok,
	Generic_btn_noBtn,
	btn_genericYes,
	addAddrDtls,
	list_INFSYS_COMBO0,
	btn_OK,
	btn_CLOSE;
	
	
	private WebDriver driver;
	private String screenFrame;
	private String dataFileName;
	
	public ULD023(WebDriver driver, String dataFileName) {
		 super(driver);
	     this.driver = driver;
	     initElements();
	     this.dataFilePath = this.dataFilePath + dataFileName;
	     this.dataFileName = dataFileName;
	    }
	
	/**
	 * Method to initialize page objects
	
	 */
	private void initElements() {
		 
		
		btn_RADIOUCMIN = MiscUtility.getWebElement(objFilepath,"ULD023_btn_RADIOUCMIN");
		txt_carrierCode	= MiscUtility.getWebElement(objFilepath,"ULD023_txt_carrierCode");
		txt_flightNo= MiscUtility.getWebElement(objFilepath,"ULD023_txt_flightNo");
		txt_Date	= MiscUtility.getWebElement(objFilepath,"ULD023_txt_Date");	
		btn_List = MiscUtility.getWebElement(objFilepath, "ULD023_btn_List");
		Generic_info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		Generic_btn_noBtn= MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		Generic_btn_ok= MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		btn_genericYes= MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		btn_CLOSE	= MiscUtility.getWebElement(objFilepath,"ULD023_btn_CLOSE");
		addUld	= MiscUtility.getWebElement(objFilepath,"ULD023_addUld");
		btn_SEND = MiscUtility.getWebElement(objFilepath,"ULD023_btn_SEND");
		btn_CLOSE  = MiscUtility.getWebElement(objFilepath,"ULD023_btn_CLOSE");
		txt_uldNumbers= MiscUtility.getWebElement(objFilepath,"ULD023_txt_uldNumbers");
		addAddrDtls = MiscUtility.getWebElement(objFilepath,"ULD002_addAddrDtls");
		list_INFSYS_COMBO0 = MiscUtility.getWebElement(objFilepath,"ULD002_list_INFSYS_COMBO0");
		btn_OK = MiscUtility.getWebElement(objFilepath,"ULD002_btn_OK");
	 }
	
	/**
	 * Method to UCM_OUT
	 * 
	 
	 * @return
	 * @author a-6545
	 */
	public ULD023 UCM_OUT(String carrier_code,String fltNo,String flightStartDate,String UldNo) {
		
		carrier_code	= PropertyHandler.getPropValue(dataFilePath,carrier_code);
		fltNo	= PropertyHandler.getPropValue(dataFilePath,fltNo);
		flightStartDate	= PropertyHandler.getPropValue(dataFilePath,flightStartDate);
		UldNo	= PropertyHandler.getPropValue(dataFilePath,UldNo);
		
		enterKeys(waitForElement(txt_carrierCode), carrier_code);
		enterKeys(txt_flightNo, fltNo);
		enterKeys(txt_Date, flightStartDate);
		click(btn_List);
		minWait();
		click(addUld);
		enterKeys(waitForElement(txt_uldNumbers), UldNo);
		click(btn_SEND);
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
	 * Method to UCM_IN
	 * 
	 
	 * @return
	 * @author a-6545
	 */
	public ULD023 UCM_IN(String carrier_code,String fltNo,String flightStartDate,String UldNo) {
		
		carrier_code	= PropertyHandler.getPropValue(dataFilePath,carrier_code);
		fltNo	= PropertyHandler.getPropValue(dataFilePath,fltNo);
		flightStartDate	= PropertyHandler.getPropValue(dataFilePath,flightStartDate);
		UldNo	= PropertyHandler.getPropValue(dataFilePath,UldNo);
		
		click(btn_RADIOUCMIN);
		enterKeys(waitForElement(txt_carrierCode), carrier_code);
		enterKeys(txt_flightNo, fltNo);
		enterKeys(txt_Date, flightStartDate);
		click(btn_List);
		minWait();
		click(addUld);
		enterKeys(waitForElement(txt_uldNumbers), UldNo);
		click(btn_SEND);
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
