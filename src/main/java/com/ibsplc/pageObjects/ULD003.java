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
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class ULD003 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	
	public static String FRAME = "iCargoContentFrameULD003";
	
	By
	txt_uldNo,
	txt_DAMAGEREFNO,
	btn_list,
	BUTTON_Close,
	txt_uldTypeCode,
	Generic_footer_error,
	tbl_damagereporttable,
	txt_currentStn,
	list_uldDamageStatus,
	list_ULDSTATUS,
	btn_btClear,
	list_PARTYTYPE,
	list_FACILITYTYPE,
	txt_frmDate,
	BUTTON_PRINT,
	btn_save,
    btn_CLOSE;
	
	
	WebDriver driver;
    String screenFrame;
    String dataFileName;
    
    
    public ULD003(WebDriver driver, String dataFileName) {
    	
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {
    
    	txt_uldNo= MiscUtility.getWebElement(objFilepath,"ULD003_txt_uldNo");
    	btn_list= MiscUtility.getWebElement(objFilepath,"ULD003_btn_list");
    	txt_DAMAGEREFNO= MiscUtility.getWebElement(objFilepath,"ULD003_txt_DAMAGEREFNO");
    btn_CLOSE= MiscUtility.getWebElement(objFilepath,"ULD003_BUTTON_Close");
    	tbl_damagereporttable= MiscUtility.getWebElement(objFilepath,"ULD003_tbl_damagereporttable");
    	btn_btClear= MiscUtility.getWebElement(objFilepath,"ULD003_btn_btClear");
    	txt_uldTypeCode= MiscUtility.getWebElement(objFilepath,"ULD003_txt_uldTypeCode");
    	list_ULDSTATUS= MiscUtility.getWebElement(objFilepath,"ULD003_list_ULDSTATUS");
    	txt_currentStn= MiscUtility.getWebElement(objFilepath,"ULD003_txt_currentStn");
    	list_uldDamageStatus= MiscUtility.getWebElement(objFilepath,"ULD003_list_uldDamageStatus");
    	list_PARTYTYPE= MiscUtility.getWebElement(objFilepath,"ULD003_list_PARTYTYPE");
    	list_FACILITYTYPE = MiscUtility.getWebElement(objFilepath,"ULD003_list_FACILITYTYPE");
    	txt_frmDate = MiscUtility.getWebElement(objFilepath,"ULD003_txt_frmDate");
    	BUTTON_PRINT= MiscUtility.getWebElement(objFilepath,"ULD003_BUTTON_PRINT");
    	Generic_footer_error= MiscUtility.getWebElement(genObjPath,"Generic_footer_error");
    }
    /**ULDMovementHistory
  	  * 
  	  * record movements
  	  * on 
  	  * @param uldNum,status
  	  * @return
  	  * @author a-6545
  	  */
      public ULD003 List_Damage_Reports(String uldNum,String DamageRefNo,String uldType,String dest,String ULDSTATUS,String Damaged, String PARTYTYPE,String FACILITYTYPE,String flightStartDate,String valuetemp){
      	
      	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
      	DamageRefNo= PropertyHandler.getPropValue(dataFilePath,DamageRefNo);
      	uldType= PropertyHandler.getPropValue(dataFilePath,uldType);
      	dest= PropertyHandler.getPropValue(dataFilePath,dest);
      	flightStartDate= PropertyHandler.getPropValue(dataFilePath,flightStartDate);
    	 list(valuetemp,uldNum,uldType,DamageRefNo,dest,ULDSTATUS,Damaged,PARTYTYPE,FACILITYTYPE,flightStartDate);
  		 minWait();
  		Assert.assertTrue(waitForElement(tbl_damagereporttable).getText().contains(uldNum));
  		//Assert.assertTrue(tblGetTextByColValue(tbl_damagereporttable,2,3,DamageRefNo).trim().equalsIgnoreCase(uldNum));
  		 click(btn_btClear);
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
       public ULD003 Damage_Reports(String uldNum){
       	
       	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
       	enterKeys(txt_uldNo, uldNum);
		 click(btn_list);
     	
   		 minWait();
   		click(BUTTON_PRINT);
   		waitForNewWindow(2);
        switchToSecondWindow();
        driver.close();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
   		return this;
   		 
   		 
       }
   
	private void list(String valuetemp,String uldNum,String uldType,String DamageRefNo,String dest,String ULDSTATUS,String Damaged,String PARTYTYPE,String FACILITYTYPE,String flightStartDate) {
		if(valuetemp.equalsIgnoreCase("UldNo"))
		{
	    
		enterKeys(txt_uldNo, uldNum);
		 click(btn_list);
		}
		else if(valuetemp.equalsIgnoreCase("DamageRefNo"))
		{
			enterKeys(txt_DAMAGEREFNO, DamageRefNo);
			 click(btn_list);
		}
		else if(valuetemp.equalsIgnoreCase("uldType"))
		{
			enterKeys(txt_uldTypeCode, uldType);
			 click(btn_list);
		}
		else if(valuetemp.equalsIgnoreCase("dest"))
		{
			enterKeys(txt_currentStn, dest);
			 click(btn_list);
		}
		else if(valuetemp.equalsIgnoreCase("Non Operational"))
		{
			selectByText(list_ULDSTATUS, ULDSTATUS);
			 click(btn_list);
		}
		else if(valuetemp.equalsIgnoreCase("Damaged"))
		{
			selectByText(list_uldDamageStatus, Damaged);
			 click(btn_list);
		}
		else if(valuetemp.equalsIgnoreCase("PARTYTYPE"))
		{
			selectByText(list_PARTYTYPE, PARTYTYPE);
			 click(btn_list);
		}
		else if(valuetemp.equalsIgnoreCase("FACILITYTYPE"))
		{
			selectByText(list_FACILITYTYPE, FACILITYTYPE);
			 click(btn_list);
		}
		else if(valuetemp.equalsIgnoreCase("flightStartDate"))
		{
			enterKeys(txt_frmDate, flightStartDate);
			 click(btn_list);
		}
	}
	
public HomePage close() {    	
	
	 
	minWait();
        click(btn_CLOSE);
        driver.switchTo().defaultContent();
        
        return new HomePage(driver,dataFileName);
    }
}
