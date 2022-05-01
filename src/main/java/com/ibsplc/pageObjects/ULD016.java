package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class ULD016 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	
	public static String FRAME = "iCargoContentFrameULD016";
	
	By
	txt_uldNo,
	btn_list,
	tbl_TransactionHistory,
	List_Movements,
	dropDown_mvmnt,
	btn_REC,
	tbl_uldDtls,
	txt_carrierCode,
	txt_flightDate,
	txt_flightNumber,
	chk_dummyMovement,
	txt_pointOfLading,
	txt_pointOfUnLading,
	list_CONTENT,
	CURRENT_STATION,
	btn_SAVE,
	txt_history_uldNo,
	btn_CLOSE_BUTTON,
	btn_HISTORY_BUTTON,
	btn_GENERATE_BUTTON,
	btn_clear,
	btn_close;
	
	
	WebDriver driver;
    String screenFrame;
    String dataFileName;
    
    
    public ULD016(WebDriver driver, String dataFileName) {
    	
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {
    	txt_uldNo 	= MiscUtility.getWebElement(objFilepath,"ULD016_txt_uldNo");
    	btn_list	= MiscUtility.getWebElement(objFilepath,"ULD016_btn_list");
    	btn_close	= MiscUtility.getWebElement(objFilepath,"ULD016_btn_close");
    	List_Movements = MiscUtility.getWebElement(objFilepath,"ULD016_List_Movements");
        btn_clear       = MiscUtility.getWebElement(objFilepath,"ULD016_btn_clear");
        btn_REC= MiscUtility.getWebElement(objFilepath,"ULD016_btn_REC");
   	txt_carrierCode = MiscUtility.getWebElement(objFilepath,"ULD016_txt_carrierCode");
    	txt_flightNumber = MiscUtility.getWebElement(objFilepath,"ULD016_txt_flightNumber");
    	chk_dummyMovement = MiscUtility.getWebElement(objFilepath,"ULD016_chk_dummyMovement");
    	txt_pointOfLading = MiscUtility.getWebElement(objFilepath,"ULD016_txt_pointOfLading");
    	txt_pointOfUnLading = MiscUtility.getWebElement(objFilepath,"ULD016_txt_pointOfUnLading");
    	list_CONTENT = MiscUtility.getWebElement(objFilepath,"ULD016_list_CONTENT");
    	CURRENT_STATION = MiscUtility.getWebElement(objFilepath,"ULD016_CURRENT_STATION");
    	btn_SAVE = MiscUtility.getWebElement(objFilepath,"ULD016_btn_SAVE");
    	txt_flightDate = MiscUtility.getWebElement(objFilepath,"ULD016_txt_flightDate");
    	txt_history_uldNo = MiscUtility.getWebElement(objFilepath,"ULD016_txt_history_uldNo");
    	btn_CLOSE_BUTTON = MiscUtility.getWebElement(objFilepath,"ULD016_btn_CLOSE_BUTTON");
    	btn_HISTORY_BUTTON = MiscUtility.getWebElement(objFilepath,"ULD016_btn_HISTORY_BUTTON");
    	btn_GENERATE_BUTTON = MiscUtility.getWebElement(objFilepath,"ULD016_btn_GENERATE_BUTTON");
    }
    /**ULDMovementHistory
	  * 
	  * Method to verify ULD Movement status(To be Returned)
	  * on 27/12/2017
	  * @param uldNum,status
	  * @return
	  * @author a-6784
	  */
    public ULD016 ULDMovementHistory(String uldNum, String data_movmntType, String status){
    	
    	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
		 status= PropertyHandler.getPropValue(dataFilePath,status);
		 data_movmntType= PropertyHandler.getPropValue(dataFilePath,data_movmntType);
		 
		 list(uldNum);
		 minWait();
		 selectByText(List_Movements, data_movmntType);
		 enterKeys(List_Movements, Keys.TAB);
		minWait();
		 List<String> stat = getTableColumnValues(tbl_TransactionHistory, 2); //Status column = 2 	
		 Assert.assertTrue(stat.contains(status), "ERROR : ULD Status match.");
		click(btn_clear);
		return this;
		 
		 
    }

    /**ULDMovementHistory
  	  * 
  	  * record movements
  	  * on 
  	  * @param uldNum,status
  	  * @return
  	  * @author a-6545
  	  */
      public ULD016 ULDMovementHistory_Record( String carrier_code, String fltNo,String flightStartDate,String uldNum,String origin,String dest){
      	
      	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
      	 carrier_code = PropertyHandler.getPropValue(dataFilePath, carrier_code);
         fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
         flightStartDate = PropertyHandler.getPropValue(dataFilePath, flightStartDate);
         origin = PropertyHandler.getPropValue(dataFilePath, origin);
         dest = PropertyHandler.getPropValue(dataFilePath, dest);
  		 
  		 list(uldNum);
  		 minWait();
  		click(btn_REC);
  		 waitForNewWindow(2);
         switchToSecondWindow();
         enterKeys(txt_carrierCode, carrier_code);
         enterKeys(txt_flightNumber, fltNo);
         enterKeys(txt_flightDate, flightStartDate);
         check(chk_dummyMovement);
         enterKeys(txt_pointOfLading, origin);
         enterKeys(txt_pointOfUnLading, dest);
         selectByText(list_CONTENT,"Empty ULD");

          click(btn_SAVE);
          switchToFirstWindow();
          waitForFrameAndSwitch(FRAME);
      
  		return this;
  		 
  		 
      }
      public ULD016 History_GenerateReport(String uldNum) {
    	  uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
  
    
      	 click(btn_HISTORY_BUTTON);
    	  waitForNewWindow(2);
          switchToSecondWindow();
    	  minWait();
          Assert.assertTrue(waitForElementVisible(txt_history_uldNo).getAttribute("value").equalsIgnoreCase(uldNum));
          click(btn_CLOSE_BUTTON);
          switchToFirstWindow();
          waitForFrameAndSwitch(FRAME);
          minWait();
          click(btn_GENERATE_BUTTON);
          waitForNewWindow(2);
          switchToSecondWindow();
          driver.close();
   		  switchToFirstWindow();
          waitForFrameAndSwitch(FRAME);
          return this;
 	}
      
	private void list(String uldNum) {
		 enterKeys(txt_uldNo, uldNum);
		 click(btn_list);
		
	}
public HomePage close() {    	
        
        click(btn_close);
        driver.switchTo().defaultContent();
        
        return new HomePage(driver,dataFileName);
    }
}
