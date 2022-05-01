package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen: OPR275 - Goods Acceptance History
 * @author a-7868 Krishna <22/01/2018>
 *
 */
public class OPR275 extends BasePage{

	 private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	 public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	 public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	 
	 public static String FRAME = "iCargoContentFrameOPR275";
	  
	 By	txt_prefix,
	 	txt_awb,
	 	btn_list,
	 	tbl_accHistory,
	 	btn_clear,
	 	btn_close,
	 	yesBtn;
	 
	 WebDriver driver;
	 String screenFrame;
	 String dataFileName;
	   
	 public OPR275(WebDriver driver, String dataFileName) {
		 super(driver);
	     this.driver = driver;
	     initElements();
	     this.dataFilePath = this.dataFilePath + dataFileName;
	     this.dataFileName = dataFileName;
	 }
	 
	 /**
	  * Method to initialize page objects
	  */
	 public void initElements(){
		 
		 txt_prefix 	= MiscUtility.getWebElement(objFilepath,"OPR275_txt_shipmentPrefix");
	     txt_awb 		= MiscUtility.getWebElement(objFilepath,"OPR275_txt_AWBNo");
	     btn_list 		= MiscUtility.getWebElement(objFilepath,"OPR275_btn_list");
	     btn_clear 		= MiscUtility.getWebElement(objFilepath,"OPR275_btn_clear");
	     tbl_accHistory	= MiscUtility.getWebElement(objFilepath,"OPR275_tbl_accHistory");	     
	     btn_close		= MiscUtility.getWebElement(objFilepath,"OPR275_btn_close");
	     
	     yesBtn	= MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
	 }
	 
	 /**
	  * Method to list an awb and verify the details of a specific version number
	  * Parameters are not optional (<""> can be used). 
	  * @param awbPre
	  * @param awbNo
	  * @param version
	  * @param station (optional)
	  * @param loosePcs (optional)
	  * @param looseWt (optional)
	  * @param looseVol (optional)
	  * @param uldNum (optional)
	  * @param uldPcs (optional)
	  * @param uldWt (optional)
	  * @param uldVol (optional)
	  * @return
	  * @author a-7868 Krishna <22/01/2018>
	  */	 
	public OPR275 verifyVersionDetails(String awbPre, String awbNo, int version, String station,
			 							String loosePcs, String looseWt, String looseVol, String uldNum,
			 							String uldPcs, String uldWt, String uldVol){
		 
	 	String xpath;
	 	
		awbPre 	= PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo 	= PropertyHandler.getPropValue(dataFilePath, awbNo);		
		if(!station.equals(""))		station = PropertyHandler.getPropValue(dataFilePath, station);
		if(!loosePcs.equals(""))	loosePcs= PropertyHandler.getPropValue(dataFilePath, loosePcs);
		if(!looseWt.equals(""))		looseWt = PropertyHandler.getPropValue(dataFilePath, looseWt);
		if(!looseVol.equals(""))	looseVol= PropertyHandler.getPropValue(dataFilePath, looseVol);
		if(!uldNum.equals(""))		uldNum 	= PropertyHandler.getPropValue(dataFilePath, uldNum);
		if(!uldPcs.equals(""))		uldPcs 	= PropertyHandler.getPropValue(dataFilePath, uldPcs);
		if(!uldWt.equals(""))		uldWt 	= PropertyHandler.getPropValue(dataFilePath, uldWt);
		if(!uldVol.equals(""))		uldVol 	= PropertyHandler.getPropValue(dataFilePath, uldVol);
		
		String versionNum = String.valueOf(version);
		list(awbPre, awbNo);	
		
		if(!station.equals(""))			
			Assert.assertTrue(tblGetTextByColValue(tbl_accHistory, 2, 1, versionNum).equals(station),"ERROR : station Value mismatch");
		
		if(!loosePcs.equals("")){
			
			xpath = "./tbody/tr/td[1][contains(.,'" + versionNum + "')]/following::table[1]/tbody/tr/td[1]";
			Assert.assertTrue(waitForElement(tbl_accHistory).findElement(By.xpath(xpath)).getText().contains(loosePcs),"ERROR : loosePcs Value mismatch");
		}
		
		if(!looseWt.equals("")){
			
			xpath = "./tbody/tr/td[1][contains(.,'" + versionNum + "')]/following::table[1]/tbody/tr/td[2]";
			Assert.assertTrue(waitForElement(tbl_accHistory).findElement(By.xpath(xpath)).getText().contains(looseWt),"ERROR : looseWt Value mismatch");
		}	
		
		if(!looseVol.equals("")){
			
			xpath = "./tbody/tr/td[1][contains(.,'" + versionNum + "')]/following::table[1]/tbody/tr/td[3]";
			Assert.assertTrue(waitForElement(tbl_accHistory).findElement(By.xpath(xpath)).getText().contains(looseVol),"ERROR : looseVol Value mismatch");
		}
		
		if(!uldNum.equals("")){
			
			xpath = "./tbody/tr/td[1][contains(.,'" + versionNum + "')]/following::table[2]/tbody/tr/td[1]";
			Assert.assertTrue(waitForElement(tbl_accHistory).findElement(By.xpath(xpath)).getText().contains(uldNum),"ERROR : uldNum Value mismatch");
		}			
		
		if(!uldPcs.equals(""))	{
			
			xpath = "./tbody/tr/td[1][contains(.,'" + versionNum + "')]/following::table[2]/tbody/tr/td[2]";
			Assert.assertTrue(waitForElement(tbl_accHistory).findElement(By.xpath(xpath)).getText().contains(uldPcs),"ERROR : uldPcs Value mismatch");
		}		

		if(!uldWt.equals("")){
			
			xpath = "./tbody/tr/td[1][contains(.,'" + versionNum + "')]/following::table[2]/tbody/tr/td[3]";
			Assert.assertTrue(waitForElement(tbl_accHistory).findElement(By.xpath(xpath)).getText().contains(uldWt),"ERROR : uldWt Value mismatch");
		}
		
		if(!uldVol.equals(""))	{
			
			xpath = "./tbody/tr/td[1][contains(.,'" + versionNum + "')]/following::table[2]/tbody/tr/td[4]";
			Assert.assertTrue(waitForElement(tbl_accHistory).findElement(By.xpath(xpath)).getText().contains(uldVol),"ERROR : uldVol Value mismatch");
		}		
		
		click(btn_clear);
		return this;
	 }
	 
	/**
	 * Method to list an awb
	 * @param awbPre
	 * @param awbNo
	 */
	 public void list(String awbPre, String awbNo){
		 
		 enterKeys(txt_prefix, awbPre);
		 enterKeys(txt_awb, awbNo);
		 click(btn_list);
		 maxWait();
	 }
	 
	 /**
	  * Method to close current page and return to Homepaereturns the instance of Homepage
	 * @return
	 * @author a-7868 Krishna <22-01-2018>
	 * 
	 */
	public HomePage close() {    	
	
    click(btn_close);
    driver.switchTo().defaultContent();
    if (verifyElementPresent(yesBtn)) 
        click(yesBtn);     
    return new HomePage(driver,dataFileName);
	}
}
