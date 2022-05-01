package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class ULD012 extends BasePage{
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	
	public static String FRAME = "iCargoContentFrameULD012";
	
	By
	txt_uldNo,
	btn_list,
	addDmgLink,
	chk_checkBxVal,
	chk_checkBxVal2,
	btn_ok,
	btn_save,
	txt_DMGREFNO1,
	Generic_footer_error,
	btn_DMGCLOSE,
	chk_all,
	txt_TOTAMT,
	modDmgLink,
	txt_DMGREFNO,
	txt_MAINTAINDAMAGE_REMARKS,
	txt_REPSTN,
	modRepLink,
	txt_repairDate,
	chk_checkRepAll,
	lov_DMGREFNO,
	btn_genericYes,
	repair_btn_lov_Ok,
	repair_btn_Ok,
	addRepLink,
	tbl_Damage,
	delDmgLink,
	txt_REMARKS,
	txt_REPHEAD,
	btn_CLOSE;
	
	
	WebDriver driver;
    String screenFrame;
    String dataFileName;
    
    
    public ULD012(WebDriver driver, String dataFileName) {
    	
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {
    
    	txt_uldNo= MiscUtility.getWebElement(objFilepath,"ULD012_txt_uldNo");
    	btn_list= MiscUtility.getWebElement(objFilepath,"ULD012_btn_list");
    	addDmgLink= MiscUtility.getWebElement(objFilepath,"ULD012_addDmgLink");
    	addRepLink= MiscUtility.getWebElement(objFilepath,"ULD012_addRepLink");
    	chk_checkBxVal= MiscUtility.getWebElement(objFilepath,"ULD012_chk_checkBxVal");
    	chk_checkBxVal2= MiscUtility.getWebElement(objFilepath,"ULD012_chk_checkBxVal2");
    	btn_ok= MiscUtility.getWebElement(objFilepath,"ULD012_btn_ok");
    	btn_save=MiscUtility.getWebElement(objFilepath,"ULD012_btn_save");
    	btn_CLOSE= MiscUtility.getWebElement(objFilepath,"ULD012_btn_CLOSE");
    	btn_DMGCLOSE= MiscUtility.getWebElement(objFilepath,"ULD012_btn_DMGCLOSE");
    	txt_DMGREFNO1= MiscUtility.getWebElement(objFilepath,"ULD012_txt_DMGREFNO1");
    	chk_all = MiscUtility.getWebElement(objFilepath,"ULD012_chk_all");
    	modDmgLink= MiscUtility.getWebElement(objFilepath,"ULD012_modDmgLink");
    	txt_DMGREFNO= MiscUtility.getWebElement(objFilepath,"ULD012_txt_DMGREFNO");
    	 btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	txt_REPSTN= MiscUtility.getWebElement(objFilepath,"ULD012_txt_REPSTN");
    	delDmgLink= MiscUtility.getWebElement(objFilepath,"ULD012_delDmgLink");
    	txt_repairDate= MiscUtility.getWebElement(objFilepath,"ULD012_txt_repairDate");
    	txt_REPHEAD= MiscUtility.getWebElement(objFilepath,"ULD012_txt_REPHEAD");
    	txt_TOTAMT= MiscUtility.getWebElement(objFilepath,"ULD012_txt_TOTAMT");
    	txt_REMARKS= MiscUtility.getWebElement(objFilepath,"ULD012_txt_REMARKS");
    	repair_btn_Ok= MiscUtility.getWebElement(objFilepath,"ULD012_repair_btn_Ok");
    	modRepLink= MiscUtility.getWebElement(objFilepath,"ULD012_modRepLink");
    	lov_DMGREFNO= MiscUtility.getWebElement(objFilepath,"ULD012_lov_DMGREFNO");
    	repair_btn_lov_Ok= MiscUtility.getWebElement(objFilepath,"ULD012_repair_btn_lov_Ok");
    	chk_checkRepAll= MiscUtility.getWebElement(objFilepath,"ULD012_chk_checkRepAll");
    	tbl_Damage= MiscUtility.getWebElement(objFilepath,"ULD012_tbl_Damage");
    	txt_MAINTAINDAMAGE_REMARKS= MiscUtility.getWebElement(objFilepath,"ULD012_txt_MAINTAINDAMAGE_REMARKS");
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
      public ULD012 Damage_details_save(String uldNum){
      	
      	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
    	 list(uldNum);
  		 minWait();
  		click(addDmgLink);
  		 waitForNewWindow(2);
         switchToSecondWindow();
        check(chk_checkBxVal);
        click(btn_ok);
         minWait();
          switchToFirstWindow();
          waitForFrameAndSwitch(FRAME);
         minWait();
          click(btn_save);
          minWait();
  		return this;
  		 
  		 
      }
      
      public ULD012 Damage_error_check(String uldNum){
        	
       	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
     	 list(uldNum);
   		 minWait();
   		click(addDmgLink);
   		 waitForNewWindow(2);
          switchToSecondWindow();
       	 check(chk_checkBxVal2);
         click(btn_ok);
         Assert.assertTrue(waitForElement(Generic_footer_error).getText().contains("Damage Already Added"));
         click(btn_DMGCLOSE);
         
          minWait();
           switchToFirstWindow();
           waitForFrameAndSwitch(FRAME);
         minWait();
   		return this;
   		 
   		 
       }
      //modifications
      public ULD012 Modify_Damage(String uldNum, String DamageRefNo1){
      	
        uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
      	list(uldNum);
    	minWait();
    	check(chk_all);
   	    click(modDmgLink);
    	waitForNewWindow(2);
        switchToSecondWindow();
        String damageRefNo=waitForElement(txt_DMGREFNO).getAttribute("value");
        PropertyHandler.setPropValue(dataFilePath, DamageRefNo1, damageRefNo);
        check(chk_checkBxVal2);
        click(btn_ok);
        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
     
        minWait();
        click(btn_save);
    		return this;
    		 
    		 
        }
      
      //Delete the damage details
      public ULD012 Delete_Damage(String uldNum){
      	
        uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
      	list(uldNum);
    	minWait();
    	check(chk_all);
   	    click(delDmgLink);
        minWait();
        click(btn_save);
    		return this;
    		 
        }
     
      public ULD012 Repair_details_save(String uldNum,String origin){
      	
        	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
         origin= PropertyHandler.getPropValue(dataFilePath,origin);
    		 minWait();
    	  click(addRepLink);
    	  waitForNewWindow(2);
          switchToSecondWindow();
          selectByText(txt_REPHEAD, "Brazing");
          enterKeys(txt_REPSTN, origin);
          enterKeys(txt_repairDate, ".");
          enterKeys(txt_TOTAMT, "10");
          enterKeys(txt_REMARKS, "Test");
          click(repair_btn_Ok);
           minWait();
           switchToFirstWindow();
           waitForFrameAndSwitch(FRAME);
           scrollToView(txt_MAINTAINDAMAGE_REMARKS);
           enterKeys(txt_MAINTAINDAMAGE_REMARKS, "REMARKS");
           click(btn_save);
            minWait();
    		 return this;
    		 
    		 
        }
      //Repair modifications
      public ULD012 Repair_details_Modification(String uldNum){
        	
       	 uldNum= PropertyHandler.getPropValue(dataFilePath,uldNum);
       	list(uldNum);
   		 minWait();
   		 String DamageRefNo = tblGetTextByColValue(tbl_Damage, 2, 3, "Base - Edge Rail and Corners");
   		 System.out.println(DamageRefNo);
   		 PropertyHandler.setPropValue(dataFilePath, DamageRefNo, DamageRefNo);
   		 check(chk_checkRepAll);
   		 click(modRepLink);
   		 waitForNewWindow(2);
         switchToSecondWindow();
         enterKeys(txt_TOTAMT, "100");
         click(lov_DMGREFNO);
         waitForNewWindow(3);
         switchToNthWindow(3);
         tblSelectRowByColValue(tbl_Damage, 1, 2, DamageRefNo);
         click(repair_btn_lov_Ok);
         switchToNthWindow(2);
        click(repair_btn_Ok);
         minWait();
         switchToFirstWindow();
         waitForFrameAndSwitch(FRAME);
         
         click(btn_save);
           minWait();
   		 return this;
   		 
   		 
       }
      
	private void list(String uldNum) {
		 enterKeys(txt_uldNo, uldNum);
		 click(btn_list);
		
	}
public HomePage close() {    	
        
        click(btn_CLOSE);
     
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver,dataFileName);
    }
}
