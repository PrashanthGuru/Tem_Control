package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class TRF017 extends BasePage{
    
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
	public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","Generic.properties");
	public String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String filepath;
	
	public static String FRAME = "iCargoContentFrameTRF017";
	
	By
	txt_awbNo,
	txt_AWBprefix,
	txt_UBRNo ,
	txt_minChrgWt,
	txt_maxChrgWt,
	txt_reqstdSpot,
	txt_remarks,
	txt_currency,
	btn_SAve,
	btn_approve,
	txt_offrSpot,
	btn_CLose,
	txt_spotRateID,
	btn_NewList,
	txt_origin,
	txt_destination,
	txt_grossWeight,
	txt_grossVolume,
	txt_agentCode,
	Btn_reject,
	Btn_cancel,
	txt_chargeableWt,
	dropdown_SpotCategory,
	btn_AddAWB,
	btn_AddUBR,
	tbl_awbubrdetails,
	btn_close,
	yesBtn,
	info_status,
	txt_AWBNo,
	btn_noBtn,
	btn_clear,
	txt_authorisationRemarks;


	
	
	
	
	WebDriver driver;    
	String testDataFile;

	public TRF017(WebDriver driver, String testDataFile) {
		 super(driver);
	    this.driver = driver;
	    this.testDataFile = testDataFile;
	    PageFactory.initElements(this.driver,this);
	    filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
	    initPageElements();
	} 
	
	private void initPageElements() {
		
		btn_NewList             = MiscUtility.getWebElement(objFilepath, "TRF017_btn_NewList");
		txt_origin              = MiscUtility.getWebElement(objFilepath, "TRF017_txt_origin");
		txt_destination         = MiscUtility.getWebElement(objFilepath, "TRF017_txt_destination");
		txt_awbNo               = MiscUtility.getWebElement(objFilepath, "TRF017_txt_awbNo");
		txt_minChrgWt           = MiscUtility.getWebElement(objFilepath, "TRF017_txt_minChrgWt");
		txt_maxChrgWt           = MiscUtility.getWebElement(objFilepath, "TRF017_txt_maxChrgWt");
		txt_reqstdSpot          = MiscUtility.getWebElement(objFilepath, "TRF017_txt_reqstdSpot");
		txt_remarks             = MiscUtility.getWebElement(objFilepath, "TRF017_txt_remarks");
		txt_currency            = MiscUtility.getWebElement(objFilepath, "TRF017_txt_currency");
		btn_SAve                = MiscUtility.getWebElement(objFilepath, "TRF017_btn_SAve");
		btn_approve             = MiscUtility.getWebElement(objFilepath, "TRF017_btn_approve");
		txt_offrSpot            = MiscUtility.getWebElement(objFilepath, "TRF017_txt_offrSpot");
		btn_CLose               = MiscUtility.getWebElement(objFilepath, "TRF017_btn_CLose");
		txt_spotRateID          = MiscUtility.getWebElement(objFilepath, "TRF017_txt_spotRateID");
		txt_grossWeight         = MiscUtility.getWebElement(objFilepath, "TRF017_txt_grossWeight");
		txt_grossVolume         = MiscUtility.getWebElement(objFilepath, "TRF017_txt_grossVolume");
		txt_agentCode           = MiscUtility.getWebElement(objFilepath, "TRF017_txt_agentCode");
		Btn_reject              = MiscUtility.getWebElement(objFilepath, "TRF017_Btn_reject");
		Btn_cancel              = MiscUtility.getWebElement(objFilepath, "TRF017_Btn_cancel");
		dropdown_SpotCategory   = MiscUtility.getWebElement(objFilepath, "TRF017_dropdown_SpotCategory");
		txt_chargeableWt        = MiscUtility.getWebElement(objFilepath, "TRF027_txt_chargeableWt"); 
	    txt_AWBprefix           = MiscUtility.getWebElement(objFilepath, "TRF017_txt_AWBprefix");
		txt_UBRNo               = MiscUtility.getWebElement(objFilepath, "TRF017_txt_UBRNo");
		btn_AddAWB              = MiscUtility.getWebElement(objFilepath, "TRF017_btn_AddAWB");
		btn_AddUBR              = MiscUtility.getWebElement(objFilepath, "TRF017_btn_AddUBR");
		tbl_awbubrdetails       = MiscUtility.getWebElement(objFilepath,"TRF017_tbl_awbubrdetails");
	    btn_close               = MiscUtility.getWebElement(objFilepath, "TRF017_btn_close");
	    info_status             = MiscUtility.getWebElement(objFilepath, "TRF017_info_status");
	    txt_AWBNo               = MiscUtility.getWebElement(objFilepath, "TRF017_txt_AWBNo");
	    txt_authorisationRemarks=MiscUtility.getWebElement(objFilepath, "TRF017_txt_authorisationRemarks");
	    btn_clear                =MiscUtility.getWebElement(objFilepath, "TRF017_btn_clear");
	    yesBtn                            = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
	    btn_noBtn                         = MiscUtility.getWebElement(genFilepath, "Generic_btn_noBtn");
	}
	
	
	public TRF017 createSpotWithoutAWB(String SpotRateID,String origin,String dest,String wt,String volume,String agentCode,String minchrg,String maxchrg,String reqstdSpotvalue,String currency,String catagory){
		
		
		origin            = PropertyHandler.getPropValue(filepath,origin);
		dest              = PropertyHandler.getPropValue(filepath, dest);
		minchrg           = PropertyHandler.getPropValue(filepath, minchrg);
		maxchrg           = PropertyHandler.getPropValue(filepath, maxchrg);
		reqstdSpotvalue   = PropertyHandler.getPropValue(filepath, reqstdSpotvalue);
		currency          = PropertyHandler.getPropValue(filepath, currency);
		wt                = PropertyHandler.getPropValue(filepath, wt);
		volume            = PropertyHandler.getPropValue(filepath, volume);
		agentCode         = PropertyHandler.getPropValue(filepath, agentCode);
		//offeredSpotvalue  = PropertyHandler.getPropValue(dataFilePath, offeredSpotvalue);
		
		click(btn_NewList);
		enterKeys(txt_origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(txt_grossWeight, wt);
		enterKeys(txt_grossVolume, volume);
		enterKeys(txt_chargeableWt, wt);
		enterKeys(txt_minChrgWt, minchrg);
        enterKeys(txt_maxChrgWt, maxchrg);
        enterKeys(txt_agentCode, agentCode +Keys.TAB);
        if(catagory.equals("SpotCharge")){
        	
        	selectByText(dropdown_SpotCategory, "Spot Charge");
        }
        
        enterKeys(txt_reqstdSpot, reqstdSpotvalue);
        enterKeys(txt_remarks, "Auto Test");
        enterKeys(txt_currency, currency);
        click(btn_SAve);
        minWait();
        maxWait();
        String tempSpot = waitForElement(txt_spotRateID).getAttribute("value");
       
        System.out.println(tempSpot);
        PropertyHandler.setPropValue(filepath, SpotRateID, tempSpot);
        //enterKeys(txt_offrSpot, offeredSpotvalue);
		
		return this;
		
	}
	/**
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param count
	 * @return
	 * A-67484**/
	public TRF017 addAWB(String awbPre,String awbNo,String count){
		
		awbPre    = PropertyHandler.getPropValue(filepath, awbPre);
		awbNo     = PropertyHandler.getPropValue(filepath, awbNo);
		
		enterKeys(txt_AWBprefix, awbPre);
		enterKeys(txt_AWBNo, awbNo);
		click(btn_AddAWB);
		maxWait();
		
		int y = Integer.parseInt(count);
		
		
			
		
		 click(btn_SAve);
	        minWait();
	        
	        String tempAWB = getTableCellValue(tbl_awbubrdetails, 2, y);
			tempAWB=tempAWB.replaceAll(" ", "");
			
			String fulAWB=awbPre+"-"+awbNo;
			Assert.assertTrue(tempAWB.equals(fulAWB), "ERROR : AWB not added.");
			
		return this;
	}
	
	public TRF017 addUBR(String UBRNo,String count){
			
			
		UBRNo     = PropertyHandler.getPropValue(filepath, UBRNo);
			
			enterKeys(txt_UBRNo, UBRNo);
			click(btn_AddUBR);
			
			int y = Integer.parseInt(count);
			
				
				
			
			 click(btn_SAve);
		        minWait();

				 String tempUBR = getTableCellValue(tbl_awbubrdetails, 3, y);	
				 
				 
				 Assert.assertTrue(tempUBR.equals(UBRNo), "ERROR : UBR not added.");
				
			return this;
		}
	
	public TRF017 approveSpot(String SpotRateID,String offeredSpotvalue){
		
		offeredSpotvalue  = PropertyHandler.getPropValue(filepath, offeredSpotvalue);
		SpotRateID=PropertyHandler.getPropValue(filepath, SpotRateID);
		click(btn_clear);
		minWait();
		enterKeys(txt_spotRateID, SpotRateID);
		click(btn_NewList);
		minWait();
		enterKeys(txt_offrSpot, offeredSpotvalue);
		click(btn_approve);
		minWait();
		System.out.println(waitForElement(info_status).getText());
		Assert.assertTrue(waitForElement(info_status).getText().contains("Approved"));
		
		return this;
		
	}
	public TRF017 rejectSpot(String SpotRateID){
		 
		SpotRateID    = PropertyHandler.getPropValue(filepath, SpotRateID);
		
		//enterKeys(txt_spotRateID, SpotRateID);
		//click(btn_NewList);
		minWait();
		click(Btn_reject);
		
		return this;
		
	}
	public TRF017 cancelSpot(String SpotRateID){
		
	SpotRateID    = PropertyHandler.getPropValue(filepath, SpotRateID);
		
		enterKeys(txt_spotRateID, SpotRateID);
		click(btn_NewList);
		minWait();
		
		click(Btn_cancel);
		
		return this;
		
	}
	public HomePage close() {
	
	    click(btn_close);
	    driver.switchTo().defaultContent();
	    if (verifyElementPresent(yesBtn)) {
	
	        click(yesBtn);
	    }
	    return new HomePage(driver, dataFilePath);
	}
	
	//created by a-8254
	
	
	
	public CAP018 createSpotFlowFromCAP018(String minchrg,String maxchrg,String reqstdSpotvalue,String SpotRateID,String offeredSpotvalue)
	{
		minchrg  = PropertyHandler.getPropValue(filepath, minchrg);
		maxchrg  = PropertyHandler.getPropValue(filepath, maxchrg);
		reqstdSpotvalue  = PropertyHandler.getPropValue(filepath, reqstdSpotvalue);
		
		offeredSpotvalue  = PropertyHandler.getPropValue(filepath, offeredSpotvalue);
		 enterKeys(txt_minChrgWt, minchrg);
	   enterKeys(txt_maxChrgWt, maxchrg);
		 enterKeys(txt_reqstdSpot, reqstdSpotvalue);
	   enterKeys(txt_remarks, "Auto Test");
	   click(btn_SAve);
	   minWait();
	   String tempSpot = waitForElement(txt_spotRateID).getAttribute("value");
	   System.out.println(tempSpot);
	   PropertyHandler.setPropValue(filepath,SpotRateID, tempSpot);
	   enterKeys(txt_offrSpot, offeredSpotvalue);
	   enterKeys(txt_authorisationRemarks,"automation");
	   click(btn_approve);
		 minWait();
		 waitForElement(info_status).getText().contains("Approved");
	   click(btn_close);
	   
		
	   return new CAP018(driver, dataFilePath);
	}
	
	
	public TRF007 addAWBAndSave(String awbPre,String awbNo){
		
		awbPre    = PropertyHandler.getPropValue(filepath, awbPre);
		awbNo     = PropertyHandler.getPropValue(filepath, awbNo);
		
		enterKeys(txt_AWBprefix, awbPre);
		enterKeys(txt_AWBNo, awbNo);
		click(btn_AddAWB);
		maxWait();
		click(btn_SAve);
	      minWait();
	  click(btn_close);   
	      
	  return new TRF007(driver, dataFilePath);
	}
	
	public CAP018 saveSpotFlowFromCAP018(String minchrg,String maxchrg,String reqstdSpotvalue,String SpotRateID)
	{
		minchrg  = PropertyHandler.getPropValue(filepath, minchrg);
		maxchrg  = PropertyHandler.getPropValue(filepath, maxchrg);
		reqstdSpotvalue  = PropertyHandler.getPropValue(filepath, reqstdSpotvalue);
		
		
		 enterKeys(txt_minChrgWt, minchrg);
	   enterKeys(txt_maxChrgWt, maxchrg);
		 enterKeys(txt_reqstdSpot, reqstdSpotvalue);
	   enterKeys(txt_remarks, "Auto Test");
	   click(btn_SAve);
	   minWait();
	   String tempSpot = waitForElement(txt_spotRateID).getAttribute("value");
	   System.out.println(tempSpot);
	   PropertyHandler.setPropValue(filepath,SpotRateID, tempSpot);
	 
	   click(btn_close);
	   
		
	   return new CAP018(driver, dataFilePath);
	}
	
	
	
	public TRF007 closeToTRF007() {
	
	  click(btn_close);
	  driver.switchTo().defaultContent();
	  if (verifyElementPresent(yesBtn)) {
	
	      click(yesBtn);
	  }
	  return new TRF007(driver, dataFilePath);
	}	
	
	/*A-8255
	 * 
	 */
	
public TRF017 createSpotWithAWB(String ratingtotalcharge,String offeredSpotvalue,String SpotRateID,String awbNo,String awbPre,String ubrno,String wt,String volume,String agentCode,String minchrg,String maxchrg,String currency,String catagory){
		
		
	    awbNo            = PropertyHandler.getPropValue(filepath,awbNo);
	    awbPre              = PropertyHandler.getPropValue(filepath, awbPre);
	    ubrno        = PropertyHandler.getPropValue(filepath,ubrno);
		minchrg           = PropertyHandler.getPropValue(filepath, minchrg);
		maxchrg           = PropertyHandler.getPropValue(filepath, maxchrg);
		currency          = PropertyHandler.getPropValue(filepath, currency);
		wt                = PropertyHandler.getPropValue(filepath, wt);
		volume            = PropertyHandler.getPropValue(filepath, volume);
		agentCode         = PropertyHandler.getPropValue(filepath, agentCode);
	   ratingtotalcharge = PropertyHandler.getPropValue(filepath, ratingtotalcharge);
	   
	  String reqstdSpotvalue =null;
	  
	  if(ratingtotalcharge.contains(".")){
	  String ratingtotalcharge1[] = ratingtotalcharge.split(".");
	  ratingtotalcharge = ratingtotalcharge1[0];}
	  if(ratingtotalcharge.contains(","))
	  {
		  ratingtotalcharge = ratingtotalcharge.replace(",",""); 
	  }
	   int rcharge = Integer.parseInt(ratingtotalcharge);
	   rcharge=rcharge-300;
	   reqstdSpotvalue = String.valueOf(rcharge);
		
		enterKeys(txt_awbNo,awbNo);
		enterKeys(txt_AWBprefix,awbPre);
		//enterKeys(txt_UBRNo,ubrno);
		
	//	click(btn_NewList);
		
		enterKeys(txt_minChrgWt, minchrg);
        enterKeys(txt_maxChrgWt, maxchrg);
        enterKeys(txt_agentCode, agentCode +Keys.TAB);
        
        if(catagory.equalsIgnoreCase("SpotCharge")){
        	
        	selectByText(dropdown_SpotCategory, "Spot Charge");
        }
        
        enterKeys(txt_reqstdSpot, reqstdSpotvalue);
        enterKeys(txt_remarks, "Auto Test");
        enterKeys(txt_currency, currency);
        click(btn_SAve);
        minWait();
        
        int rofferedSpot = Integer.parseInt(reqstdSpotvalue);
        rofferedSpot=rofferedSpot-200;
        String rofferedSpotvalue = String.valueOf(rofferedSpot);
        
        PropertyHandler.setPropValue(filepath, offeredSpotvalue, offeredSpotvalue);
 	   
        enterKeys(txt_offrSpot, offeredSpotvalue);
        click(btn_SAve);
        minWait();
        
        String tempSpot = waitForElement(txt_spotRateID).getText();
        System.out.println(tempSpot);
        PropertyHandler.setPropValue(filepath, SpotRateID, tempSpot);
        PropertyHandler.setPropValue(filepath, offeredSpotvalue, rofferedSpotvalue);
        //enterKeys(txt_offrSpot, offeredSpotvalue);
		
		return this;
		
	}
}
