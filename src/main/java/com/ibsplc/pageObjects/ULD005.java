/**
 * 
 */
package com.ibsplc.pageObjects;

/**
 * @author A-6545
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class ULD005 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	
	public static String FRAME = "iCargoContentFrameULD005";
	
	By
	txt_uldNo,
  BUTTON_Close,
  btn_list,
	tbl_reporttable,
    btn_GENINVOICE,
	lov_airlinelov,
	txt_AirlineLov_Code,
	btn_AirlineLov_List,
	chk_selectCheckBox,
	btn_btnOk,
	btn_GENERATE,
	BUTTON_CLEAR,
	btn_genericYes,
	btn_CLOSE,
	btn_genericOk,
	Generic_info_msg,
	txt_uldTypeCode;
 
	
	
	WebDriver driver;
    String screenFrame;
    String dataFileName;
    
    
    public ULD005(WebDriver driver, String dataFileName) {
    	
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {
    
    	txt_uldNo= MiscUtility.getWebElement(objFilepath,"ULD005_txt_uldNo");
    	btn_list= MiscUtility.getWebElement(objFilepath,"ULD005_btn_list");
    tbl_reporttable= MiscUtility.getWebElement(objFilepath,"ULD005_tbl_reporttable");
    	btn_GENINVOICE= MiscUtility.getWebElement(objFilepath,"ULD005_btn_GENINVOICE");
        btn_CLOSE= MiscUtility.getWebElement(objFilepath,"ULD005_BUTTON_Close");
        lov_airlinelov= MiscUtility.getWebElement(objFilepath,"ULD005_lov_airlinelov");
        txt_AirlineLov_Code= MiscUtility.getWebElement(objFilepath,"ULD005_txt_AirlineLov_Code");
        txt_uldTypeCode= MiscUtility.getWebElement(objFilepath,"ULD005_txt_uldTypeCode");
        btn_AirlineLov_List= MiscUtility.getWebElement(objFilepath,"ULD005_btn_AirlineLov_List");
        chk_selectCheckBox= MiscUtility.getWebElement(objFilepath,"ULD005_chk_selectCheckBox");
        btn_btnOk= MiscUtility.getWebElement(objFilepath,"ULD005_btn_btnOk");
        btn_GENERATE= MiscUtility.getWebElement(objFilepath,"ULD005_btn_GENERATE");
        BUTTON_CLEAR= MiscUtility.getWebElement(objFilepath,"ULD005_BUTTON_CLEAR");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		 Generic_info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		 btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    
    }
    /**ULDMovementHistory
  	  * 
  	  * record movements
  	  * on 
  	  * @param uldNum,status
  	  * @return
  	  * @author a-6545
  	  */
      public ULD005 List_Repair_Reports(String uldNum,String uldType2,String valuetemp){
      	
      	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
     
      	uldType2= PropertyHandler.getPropValue(dataFilePath,uldType2);
      
    	 list(valuetemp,uldNum,uldType2);
  		 minWait();
  		 tblSelectRowByColValue(tbl_reporttable, 1, 2, uldNum);
  		click(btn_GENINVOICE);
  		waitForNewWindow(2);
        switchToSecondWindow();
        click(lov_airlinelov);
        waitForNewWindow(3);
        switchToNthWindow(3);
        enterKeys(txt_AirlineLov_Code, "AV");
        click(btn_AirlineLov_List);
        minWait();
        check(chk_selectCheckBox);
        click(btn_btnOk);
        switchToNthWindow(2);
        click(btn_GENERATE);
        minWait();
        switchToFirstWindow();
        driver.switchTo().defaultContent();
    	waitForElement(btn_genericOk);
    	minWait();
    	String value= waitForElement(Generic_info_msg).getText();
  	  System.out.println(value);
        String[] splitStr = value.split("\\s+");
        System.out.println(value);
        String split_e=splitStr[2];
        PropertyHandler.setPropValue(dataFilePath, "invoiceno", split_e);
        click(waitForElement(btn_genericOk));
  	
       waitForFrameAndSwitch(FRAME);
      	  minWait();
        click(BUTTON_CLEAR);
  		return this;
  		 
  		 
      }
     
   
	private void list(String valuetemp,String uldNum,String uldType2) {
		if(valuetemp.equalsIgnoreCase("UldNo"))
		{
	    
		enterKeys(txt_uldNo, uldNum);
		 click(btn_list);
		}
		
		else if(valuetemp.equalsIgnoreCase("uldType2"))
		{
			enterKeys(txt_uldTypeCode, uldType2);
			 click(btn_list);
		}
		
	}
	
public HomePage close() {    	
	
	 
	minWait();
        click(btn_CLOSE);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        } 
        return new HomePage(driver,dataFileName);
    }
}
