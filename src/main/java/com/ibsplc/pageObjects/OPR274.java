package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**Page OPR274 : Handling Status History
 * 
 * @author a-7868
 *
 */
public class OPR274 extends BasePage {
	
	 private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	 public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	 public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	 
	 public static String FRAME = "iCargoContentFrameOPR274";
	  
	 By	txt_prefix,
	 	txt_awb,
	 	btn_list,
	 	tbl_handling,
	 	btn_clear,
	 	btn_close,
	 	yesBtn;
	 
	 WebDriver driver;
	 String screenFrame;
	 String dataFileName;
	   
	 public OPR274(WebDriver driver, String dataFileName) {
		 super(driver);
	     this.driver = driver;
	     initElements();
	     this.dataFilePath = this.dataFilePath + dataFileName;
	     this.dataFileName = dataFileName;
	    }
	 
	 /**
	  * Initializes the page objects required for the class
	  * a-7868 on 22/12/2017
	  */
	 private void initElements() {
	     txt_prefix 	= MiscUtility.getWebElement(objFilepath,"OPR274_txt_shipmentPrefix");
	     txt_awb 	= MiscUtility.getWebElement(objFilepath,"OPR274_txt_AWBNo");
	     btn_list 	= MiscUtility.getWebElement(objFilepath,"OPR274_btn_list");
	     btn_clear 	= MiscUtility.getWebElement(objFilepath,"OPR274_btn_clear");
	     tbl_handling=MiscUtility.getWebElement(objFilepath,"OPR274_tbl_handling");	     
	     btn_close	= MiscUtility.getWebElement(objFilepath,"OPR274_btn_close");
	     
	     yesBtn	= MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
	 }
	    
	 /**
	  * Method to check status of an awb
	  * Checks whether a specific status is present in the table
	  * a-7868 on 22/12/2017
	  *
	  */
	 public OPR274 checkShipmentStatus(String prefix, String awbno, String... status){
	    	
	 	prefix 		= PropertyHandler.getPropValue(dataFilePath,prefix);
	   	awbno 		= PropertyHandler.getPropValue(dataFilePath,awbno);
	   	
	   	list(prefix, awbno);
	   	List<String> stat_list = getTableColumnValues(tbl_handling, 3);	//Status column = 3 	
	   	
	   	for (String stat : status) {
	   		stat 		= PropertyHandler.getPropValue(dataFilePath,stat);	   	
		   	Assert.assertTrue(stat_list.contains(stat), "ERROR: Mentioned status not present in Handling Status History");
	   	}
	   	
	   	click(btn_clear);	   			
	   	return this;
	 }
	    
	 /**
	  * Method to list an awb
	  * a-7868 on 22/12/2017
	  */
	 public void list(String prefix, String awbno) {
	    	
	   	enterKeys(txt_prefix, prefix);
	   	enterKeys(txt_awb, awbno);
	   	click(btn_list);
	   	minWait();
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
