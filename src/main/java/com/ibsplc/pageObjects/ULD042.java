package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Page ULD042 : 
 * 
 * @author a-6545
 *
 */
public class ULD042 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	 
	public static String FRAME = "iCargoContentFrameULD042";
	
	private By   txt_REFNO,
	btn_list,
	tbl_ref,
	btn_genericYes,
	txt_IATA,
	btn_CLOSE;

	private WebDriver driver;
	private String screenFrame;
	private String dataFileName;
	
	public ULD042(WebDriver driver, String dataFileName) {
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
		 
		txt_REFNO = MiscUtility.getWebElement(objFilepath,"ULD042_txt_REFNO");
		btn_list	= MiscUtility.getWebElement(objFilepath,"ULD042_btn_list");
		tbl_ref= MiscUtility.getWebElement(objFilepath,"ULD042_tbl_ref");
		txt_IATA= MiscUtility.getWebElement(objFilepath,"ULD042_txt_IATA");
		btn_CLOSE	= MiscUtility.getWebElement(objFilepath,"ULD042_btn_CLOSE");	
		btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		 
	 }
	
	/**
	 * Method to list a invoice ref no and validate the transaction table details
	 * 
	 * @param uldNum
	 * @param txnType
	 * @param toParty
	 * @param frmParty
	 * @return
	 * @author a-6545
	 */
	public ULD042 MUC_Tracking(String MucRefNo,String uldNum) {
		
		MucRefNo	= PropertyHandler.getPropValue(dataFilePath,MucRefNo);
		uldNum	= PropertyHandler.getPropValue(dataFilePath,uldNum);
		enterKeys(txt_REFNO, MucRefNo);
		click(btn_list);
        waitForElement(tbl_ref);
        Assert.assertEquals(waitForElement(txt_IATA).getAttribute("value"),"Sent");
        
        
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
