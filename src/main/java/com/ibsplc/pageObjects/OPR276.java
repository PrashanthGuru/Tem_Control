package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class OPR276  extends BasePage {
	
	public String dataFilePath;
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    
    public static String FRAME = "iCargoContentFrameOPR276";
      
	WebDriver driver;    
    String testDataFile;
    String browser;
    By
    txt_AWBPrefix,
    txt_AWBNo,
    btn_List,
    btn_Close,
    tbl_HistoryDetails,
    txt_HAWBNo,
    btn_genericYes,
    link_version,
    txt_origin,
    txt_dest,
    txt_scc,
	txt_agentCode,
	txt_commCode,
	txt_commPcs,
    txt_commWt,
    shipperCode,
    consigneeCode,
    txt__currency,
    txt_updatedby,
    txt_updatedsource,
    btn_versionclose,
    btn_chargeTab;
    
	
	 public OPR276(WebDriver driver, String dataFileName) {
		 super(driver);
         this.driver = driver;
         this.testDataFile = dataFileName;
         PageFactory.initElements(this.driver,this);
         dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+dataFileName;
         initPageElements();
	}
    
    private void initPageElements(){	 
        
    	System.out.println("Going to capture all webElements..!");
    	
    	txt_AWBPrefix 	= MiscUtility.getWebElement(objFilepath,"OPR276_txt_AWBPrefix");
    	txt_AWBNo	= MiscUtility.getWebElement(objFilepath,"OPR276_txt_AWBNo");
    	btn_List		= MiscUtility.getWebElement(objFilepath,"OPR276_btn_List");
    	btn_Close		= MiscUtility.getWebElement(objFilepath,"OPR276_btn_Close");
    	tbl_HistoryDetails 	= MiscUtility.getWebElement(objFilepath,"OPR276_tbl_HistoryDetails");
    	txt_HAWBNo= MiscUtility.getWebElement(objFilepath,"OPR276_txt_HAWBNo");
    	btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	link_version =  MiscUtility.getWebElement(objFilepath, "OPR276_link_version");
    	txt_origin=  MiscUtility.getWebElement(objFilepath, "OPR276_txt_origin");
    	txt_dest=  MiscUtility.getWebElement(objFilepath, "OPR276_txt_dest");
    	txt_scc=  MiscUtility.getWebElement(objFilepath, "OPR276_txt_scc");
    	txt_agentCode=  MiscUtility.getWebElement(objFilepath, "OPR276_txt_agentCode");
    	txt_commCode=  MiscUtility.getWebElement(objFilepath, "OPR276_txt_commCode");
    	txt_commPcs=  MiscUtility.getWebElement(objFilepath, "OPR276_txt_commPcs");
        txt_commWt=  MiscUtility.getWebElement(objFilepath, "OPR276_txt_commWt");
        shipperCode=  MiscUtility.getWebElement(objFilepath, "OPR276_shipperCode");
        consigneeCode=  MiscUtility.getWebElement(objFilepath, "OPR276_consigneeCode");
        txt__currency=  MiscUtility.getWebElement(objFilepath, "OPR276_txt_currency");
        txt_updatedby= MiscUtility.getWebElement(objFilepath, "OPR276_txt_updatedby");
        txt_updatedsource= MiscUtility.getWebElement(objFilepath, "OPR276_txt_updatedsource");
        btn_versionclose= MiscUtility.getWebElement(objFilepath, "OPR276_btn_versionclose");
        btn_chargeTab = MiscUtility.getWebElement(objFilepath, "OPR276_btn_chargeTab");
   
    }

    /*
     * A-8255
     */
    
    public OPR276 verifyAWBVersionHistory(boolean withhawb,String hwabno,String source,String username,String prefix,String awbNo,boolean modified,boolean executed,String origin,String dest,String scc,String agentCode,String shipper,String consignee,String pcs,String wt,String currency,String commcode)
    {
    	
    	prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	hwabno= PropertyHandler.getPropValue(dataFilePath, hwabno);
    	if(withhawb == true){
    		
    		enterKeys(txt_HAWBNo,hwabno);
    	}
    		
    	enterKeys(txt_AWBPrefix,prefix);
    	enterKeys(txt_AWBNo,awbNo);
    	
    	click(btn_List);
    	
    		
       click(link_version);
       
       switchToSecondWindow();
       origin = PropertyHandler.getPropValue(dataFilePath, origin);
 	  dest = PropertyHandler.getPropValue(dataFilePath, dest);
 	  agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
 	  shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
 	  consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
 	  pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
 	  wt = PropertyHandler.getPropValue(dataFilePath, wt);
 	  commcode = PropertyHandler.getPropValue(dataFilePath, commcode);
 	  currency= PropertyHandler.getPropValue(dataFilePath, currency);
 	  username=PropertyHandler.getPropValue(dataFilePath, username);
 	  source=PropertyHandler.getPropValue(dataFilePath, source);
 	  
 	  String cOrigin = waitForElementVisible(txt_origin).getAttribute("value");
      String cdest = waitForElementVisible(txt_dest).getAttribute("value");
      String cpcs= waitForElementVisible(txt_commPcs).getAttribute("value");
      String cwt= waitForElementVisible(txt_commWt).getAttribute("value");
      String ctxt_commCode=waitForElementVisible(txt_commCode).getAttribute("value");
      String cagentCode = waitForElementVisible(txt_agentCode).getAttribute("value");
      String cshipper = waitForElementVisible(shipperCode).getText();
      String cconsignee = waitForElementVisible(consigneeCode).getText();
      click(btn_chargeTab);
      String ccurrency =  waitForElementVisible(txt__currency).getText();
     String cupdatedby = waitForElementVisible(txt_updatedby).getText();
     String cupdatedsource=waitForElementVisible(txt_updatedsource).getText();
    
     Assert.assertTrue((cwt.equals(wt) & cpcs.equals(pcs) & ctxt_commCode.equals(commcode) & cupdatedsource.equals(source) & origin.equals(cOrigin) & dest.equals(cdest)  & cupdatedby.equals(username) & cagentCode.equals(agentCode) & cshipper.equals(shipper) & cconsignee.equals(consignee)),"All the details got captured properly.");
     
     click(btn_versionclose);
       
       
     switchToFirstWindow();
    	   
       	waitForFrameAndSwitch(FRAME);
    	return this;
    }
	
    public HomePage close(){
    	
    	click(btn_Close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {
            click(btn_genericYes);
        }
        return new HomePage(driver,testDataFile);
    }
}