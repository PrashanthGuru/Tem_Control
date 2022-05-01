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

public class ULD040 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	
	public static String FRAME = "iCargoContentFrameULD040";
	
	By
	list_SECTION_COMBO,
	btn_list,
	chk_eventHeadCheck,
	link_delete,
	link_add,
	list_sec,
	txt_des,
	txt_NOOFPOINTS1,
	txt_des2,
	txt_TOTALPOINTS,
	txt_NOOFPOINTS2,
	btn_save,
	Generic_footer_error,
	btn_CLOSE;
	
	
	WebDriver driver;
    String screenFrame;
    String dataFileName;
    
    
    public ULD040(WebDriver driver, String dataFileName) {
    	
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {
   
    	list_SECTION_COMBO= MiscUtility.getWebElement(objFilepath,"ULD040_list_SECTION_COMBO");
    	btn_list= MiscUtility.getWebElement(objFilepath,"ULD040_btn_list");
    	chk_eventHeadCheck= MiscUtility.getWebElement(objFilepath,"ULD040_chk_eventHeadCheck");
    	link_delete= MiscUtility.getWebElement(objFilepath,"ULD040_link_delete");
    	link_add= MiscUtility.getWebElement(objFilepath,"ULD040_link_add");
    	list_sec= MiscUtility.getWebElement(objFilepath,"ULD040_list_sec");
    	btn_save=MiscUtility.getWebElement(objFilepath,"ULD040_btn_save");
    	btn_CLOSE= MiscUtility.getWebElement(objFilepath,"ULD040_btn_CLOSE");
    	txt_des= MiscUtility.getWebElement(objFilepath,"ULD040_txt_des");
    	txt_NOOFPOINTS1= MiscUtility.getWebElement(objFilepath,"ULD040_txt_NOOFPOINTS1");
    	txt_des2= MiscUtility.getWebElement(objFilepath,"ULD040_txt_des2");
    	txt_NOOFPOINTS2= MiscUtility.getWebElement(objFilepath,"ULD040_txt_NOOFPOINTS2");
    	txt_TOTALPOINTS= MiscUtility.getWebElement(objFilepath,"ULD040_txt_TOTALPOINTS");
    	Generic_footer_error= MiscUtility.getWebElement(genObjPath,"Generic_footer_error");
    }
    /**
  	  * 
  	  * 
  	  * on 
  	  * @param uldNum,status
  	  * @return
  	  * @author a-6545
  	  */
      public ULD040 Damage_checklist_master(String Value){
  
      	 
     	selectByText(list_SECTION_COMBO, Value);
     	 click(btn_list);
  		 minWait();
  		 check(chk_eventHeadCheck);
  		click(link_delete);
  		 minWait();
  		click(link_add); 
  		selectByText(list_sec, Value);
  		enterKeys(txt_des, "Has cracks or holes?");
  		enterKeys(txt_NOOFPOINTS1, "100");
     click(btn_save);
          minWait();
  		return this;
  		 
  		 
      }
      /**
   	  * 
   	  * 
   	  * on 
   	  * @param uldNum,status
   	  * @return
   	  * @author a-6545
   	  */
       public ULD040 Damage_checklist_master_multi(String Value){
   
       	 
      	selectByText(list_SECTION_COMBO, Value);
      	 click(btn_list);
   		 minWait();
   		 check(chk_eventHeadCheck);
   		click(link_delete);
   		 minWait();
   		click(link_add); 
   		selectByText(list_sec, Value);
   		enterKeys(txt_des, "Has cracks or holes?");
   		enterKeys(txt_NOOFPOINTS1, "50");
   		click(link_add); 
   		enterKeys(txt_des2, "Has cracks or holes");
   		enterKeys(txt_NOOFPOINTS2, "50");
      click(btn_save);
      Assert.assertTrue(waitForElement(txt_TOTALPOINTS).getAttribute("value").equalsIgnoreCase("100"));
        minWait();
   		return this;
   		 
   		 
       }
	
public HomePage close() {    	
        
        click(btn_CLOSE);
        driver.switchTo().defaultContent();
        
        return new HomePage(driver,dataFileName);
    }
}
