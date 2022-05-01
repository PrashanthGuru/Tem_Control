package com.ibsplc.pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CRA079 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameCRA079";
    By

    txt_awbPrefix,
    txt_AWBNo,
    btn_list,
    txt_flightNo,
    txt_flightDate,
    txt_flightNo2,
    txt_flightdate2,
    yesBtn,
    Generic_btn_ok,
    btn_close,
    btn_save,
			info_msg;

    
    
    private By txt_origin,
    		   txt_dest,
    		   table_awbRouting,
    		   btn_add,
    		   txt_origin1,
    		   txt_dest1,
    		   txt_carrier1;
    
    private By txt_fltDate1;
    private By txt_carrier;
    
    private By chk_truck;
    private By btn_clear;
    
    private By tableAwbRoutingDetails;
    private WebDriver driver;
    private String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    private By txt_fltNo;
    
    
    private By txt_pc1,
    			txt_wt1,
    			txt_carr;
    
    private By btn_expand;
    private By secflightNo;
    			
    public CRA079(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }


    private void initElements() {
    	
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        Generic_btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");

        txt_awbPrefix       = MiscUtility.getWebElement(objFilepath, "CRA079_txt_awbPrefix");
        txt_AWBNo           = MiscUtility.getWebElement(objFilepath, "CRA079_txt_AWBNo");
        btn_list            = MiscUtility.getWebElement(objFilepath, "CRA079_btn_list");
        txt_flightNo        = MiscUtility.getWebElement(objFilepath, "CRA079_txt_flightNo");
        txt_flightDate      = MiscUtility.getWebElement(objFilepath, "CRA079_txt_flightDate");
        btn_save            = MiscUtility.getWebElement(objFilepath, "CRA079_btn_save");
        btn_close           = MiscUtility.getWebElement(objFilepath, "CRA079_btn_close");
        txt_flightNo2       = MiscUtility.getWebElement(objFilepath, "CRA079_txt_flightNo2");
        txt_flightdate2     = MiscUtility.getWebElement(objFilepath, "CRA079_txt_flightdate2");
    	
        txt_origin			= MiscUtility.getWebElement(objFilepath, "CRA079_txt_origin");
        txt_dest			= MiscUtility.getWebElement(objFilepath, "CRA079_txt_dest");
        table_awbRouting	= MiscUtility.getWebElement(objFilepath, "CRA079_table_awbRouting");
        btn_add				= MiscUtility.getWebElement(objFilepath, "CRA079_btn_add");
        txt_origin1			= MiscUtility.getWebElement(objFilepath, "CRA079_txt_origin1");
        txt_dest1			= MiscUtility.getWebElement(objFilepath, "CRA079_txt_dest1");
        txt_carrier1		=MiscUtility.getWebElement(objFilepath, "CRA079_txt_carrier1");
        txt_carrier			=MiscUtility.getWebElement(objFilepath, "CRA079_txt_carrierCode");
        
        tableAwbRoutingDetails=MiscUtility.getWebElement(objFilepath, "CRA079_table_awbRoutingDet");
        chk_truck=MiscUtility.getWebElement(objFilepath, "CRA079_check_truck");
        btn_clear=MiscUtility.getWebElement(objFilepath, "CRA079_btn_clear");
        txt_fltNo=MiscUtility.getWebElement(objFilepath, "CRA079_txt_fltNO");
        
        txt_pc1=MiscUtility.getWebElement(objFilepath, "CRA079_txt_pc1");
        txt_wt1=MiscUtility.getWebElement(objFilepath, "CRA079_txt_wt1");
        txt_carr=MiscUtility.getWebElement(objFilepath, "CRA079_txt_carrier1");
        txt_fltDate1=MiscUtility.getWebElement(objFilepath, "CRA079_txt_fltdate1");
        
        btn_expand=MiscUtility.getWebElement(objFilepath, "CRA079_txt_fltdate1");
        secflightNo=MiscUtility.getWebElement(objFilepath, "CRA073_txt_rateingAuditedMarketCharge");
    }
    /***
     * multi flight routing
     * @param awbPrefix
     * @param AWBNo
     * @param flightnum
     * @param fltDate
     * @return
     */
    public CRA079 captureMultiRouting(String awbPrefix,String AWBNo,String flightnum,String fltDate){
		
    	
    	awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	flightnum=PropertyHandler.getPropValue(dataFilePath, flightnum);
    	fltDate=PropertyHandler.getPropValue(dataFileName, fltDate);
    	
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, AWBNo);
    	
    	click(btn_list);
    	minWait();
    	enterKeys(txt_flightNo2, flightnum);
    	enterKeys(txt_flightdate2, fltDate);
    	click(btn_save);
		
    	minWait();
        driver.switchTo().defaultContent();
        click(Generic_btn_ok);
        waitForFrameAndSwitch(FRAME);
       
    	
    	
    	
    	return this;	
    }
/***
 * 
 * @param awbPrefix
 * @param AWBNo
 * @param flightnum
 * @param fltDate
 * @return
 */
    public CRA079 captureRouting(String awbPrefix,String AWBNo,String flightnum,String fltDate, String origin,String origin1,String carrierCode1,String dest1){
    	
    	
    	awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	flightnum=PropertyHandler.getPropValue(dataFilePath, flightnum);
    	fltDate=PropertyHandler.getPropValue(dataFilePath, fltDate);
    	origin=PropertyHandler.getPropValue(dataFilePath, origin);
    	origin1=PropertyHandler.getPropValue(dataFilePath, origin1);
    	dest1=PropertyHandler.getPropValue(dataFilePath, dest1);
    	carrierCode1=PropertyHandler.getPropValue(dataFilePath, carrierCode1);
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, AWBNo);
    	click(btn_list);
    	minWait();
    	
    	enterKeys(txt_origin, origin);
    	enterKeys(txt_dest, origin1);
    	enterKeys(txt_flightNo, flightnum);
    	enterKeys(txt_flightDate, fltDate);
    	tblClickByColInput(table_awbRouting,1);
    	click(btn_add);
    	enterKeys(txt_origin1, origin1);
    	enterKeys(txt_dest1, dest1);
    	enterKeys(txt_carrier1, carrierCode1);
    	click(btn_save);
		
    	minWait();
        driver.switchTo().defaultContent();
        click(Generic_btn_ok);
        waitForFrameAndSwitch(FRAME);
        return this;
    	
    }
    public CRA079 updateMultiRoutingAwb(String awbPrefix,String AWBNo,String flightnum,String fltDate, String origin,String origin1,String carrierCode1,String dest1)
    {
    	awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	flightnum=PropertyHandler.getPropValue(dataFilePath, flightnum);
    	fltDate=PropertyHandler.getPropValue(dataFilePath, fltDate);
    	origin=PropertyHandler.getPropValue(dataFilePath, origin);
    	origin1=PropertyHandler.getPropValue(dataFilePath, origin1);
    	dest1=PropertyHandler.getPropValue(dataFilePath, dest1);
    	carrierCode1=PropertyHandler.getPropValue(dataFilePath, carrierCode1);
    	
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, AWBNo);
    	click(btn_list);
    	minWait();
    	
    	enterKeys(txt_origin, origin);
    	enterKeys(txt_dest, origin1);
    	enterKeys(txt_flightNo, flightnum);
    	enterKeys(txt_flightDate, fltDate);
//    	tblClickByColInput(table_awbRouting,1);
//    	click(btn_add);
    	enterKeys(txt_origin1, origin1);
    	enterKeys(txt_dest1, dest1);
    	enterKeys(txt_carrier1, carrierCode1);
    	enterKeys(txt_flightdate2, fltDate);    	
    	enterKeys(txt_pc1, "10");
    	enterKeys(txt_wt1, "100");
    	click(btn_save);
		
    	minWait();
        driver.switchTo().defaultContent();
        click(Generic_btn_ok);
        waitForFrameAndSwitch(FRAME);
    	
    	
    	
    	
    	return this;
    }
    
  public CRA079 changeRouting(String awbPrefix,String AWBNo,String flightnum,String fltDate, String origin, String dest){
    	
    	
    	awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	flightnum=PropertyHandler.getPropValue(dataFilePath, flightnum);
    	fltDate=PropertyHandler.getPropValue(dataFileName, fltDate);
    	
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, AWBNo);
    	
    	click(btn_list);
    	minWait();
    	enterKeys(txt_flightNo, flightnum);
    	enterKeys(txt_flightDate, fltDate);
    	enterKeys(txt_origin, origin);
    	enterKeys(txt_dest, dest);
    	click(btn_save);
		
    	minWait();
        driver.switchTo().defaultContent();
        click(Generic_btn_ok);
        waitForFrameAndSwitch(FRAME);
        return this;
    	
    }

	/**
	 * Changes the OAL carrier for a multiroute and saves.
	 * @param carrier
	 * @return
	 * @author a-7681
	 */
	public CRA079 changeCarrierWithoutListing(String carrier){

  		carrier = PropertyHandler.getPropValue(dataFilePath,carrier);

		enterKeys(txt_carrier1, carrier);
		click(btn_save);

		minWait();
		driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(info_msg).getText().contains("Route is modifed and it is reprorated"), "The routing is not updated.");
		click(Generic_btn_ok);
		waitForFrameAndSwitch(FRAME);
		return this;

	}
  
  public CRA079 validateRouting(String awbPrefix,String AWBNo,String flightnum,boolean multibooked,boolean truck)
  {
	    awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
  		AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
  		flightnum=PropertyHandler.getPropValue(dataFilePath, flightnum);
  		enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, AWBNo);
    	
    	click(btn_list);
  		minWait();
  		
  		
  		boolean flag=verifyValuePresentInTblColumn(tableAwbRoutingDetails, 7, flightnum);
  		Assert.assertTrue(flag, "flight number should be the prorated for the AWB");
  		
  		if(multibooked)
  		{
  			Assert.assertTrue(waitForElement(txt_carrier1).getAttribute("value").equalsIgnoreCase("YY"), "Proration should not be stamped for this flight");
  		}
  		if(truck)
  		{
  			Assert.assertTrue(driver.findElement(chk_truck).isSelected(),"the selected flight should be of type TRUCK");
  		}
  		
  		minWait();
  		click(btn_clear);
  		
  		return this;
  }
  
  public CRA079 validatePriamryAndSeccondaryProration(String awbPrefix,String AWBNo,String flightnum) 
  {
	  	awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
		flightnum=PropertyHandler.getPropValue(dataFilePath, flightnum);
		enterKeys(txt_awbPrefix, awbPrefix);
		enterKeys(txt_AWBNo, AWBNo);
  	
  		click(btn_list);
		minWait();		
		
		boolean flag=verifyValuePresentInTblColumn(tableAwbRoutingDetails, 7, flightnum);
		Assert.assertTrue(flag, "flight number should be the prorated for the AWB");
		
		click(btn_expand);
		minWait();
		Assert.assertTrue(waitForElement(secflightNo).getText().contains(flightnum), "Secondary proration should contain flight number");
		
		
	  return this;
  }
  
  	public CRA079 manualRoutingUpdate(String awbPrefix,String AWBNo,String flightnum,String fltDate, String origin,String origin1,String carrierCode1,String dest1) 
  	{
  		awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	flightnum=PropertyHandler.getPropValue(dataFilePath, flightnum);
    	fltDate=PropertyHandler.getPropValue(dataFilePath, fltDate);
    	origin=PropertyHandler.getPropValue(dataFilePath, origin);
    	origin1=PropertyHandler.getPropValue(dataFilePath, origin1);
    	dest1=PropertyHandler.getPropValue(dataFilePath, dest1);
    	carrierCode1=PropertyHandler.getPropValue(dataFilePath, carrierCode1);
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, AWBNo);
    	
    	
    	click(btn_list);
    	enterKeys(txt_origin, origin);
    	enterKeys(txt_dest, origin1);
    	enterKeys(txt_flightNo, flightnum);
    	enterKeys(txt_flightDate, fltDate);
    	tblClickByColInput(table_awbRouting,1);
    	click(btn_add);
    	enterKeys(txt_origin1, origin1);
    	enterKeys(txt_dest1, dest1);
    	enterKeys(txt_carrier1, carrierCode1);
    	enterKeys(txt_fltDate1, fltDate);
    	enterKeys(txt_pc1, "10");
    	enterKeys(txt_wt1, "100");
    	//enterKeys(txt_carr, carrierCode1);    	
    	click(btn_save);
		
    	minWait();
        driver.switchTo().defaultContent();
        click(Generic_btn_ok);
        waitForFrameAndSwitch(FRAME);
        return this;
    	
    	 		
  		  	}
  	
  	public CRA079 updateProrationRoutng(String awbPrefix,String AWBNo,String carrierCode,String flightnum,String fltDate, String origin,String dest)
  	{
  		awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	flightnum=PropertyHandler.getPropValue(dataFilePath, flightnum);
    	fltDate=PropertyHandler.getPropValue(dataFileName, fltDate);
    	origin=PropertyHandler.getPropValue(dataFileName, origin);
    	
    	dest=PropertyHandler.getPropValue(dataFileName, dest);
    	carrierCode=PropertyHandler.getPropValue(dataFileName, carrierCode);
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, AWBNo);
    	click(btn_list);
    	minWait();
    	enterKeys(txt_carrier, carrierCode);
    	
    	enterKeys(txt_origin, origin);
    	enterKeys(txt_dest, dest);
    	click(btn_save);
    	 driver.switchTo().defaultContent();
    	 if(verifyElementPresent(Generic_btn_ok))
         click(Generic_btn_ok);
         waitForFrameAndSwitch(FRAME);
    	
    	
    	
  		return this;
  	}
  	public CRA079 updateProrationRoutngOwn(String awbPrefix,String AWBNo,String carrierCode,String flightnum,String fltDate, String origin,String dest)
  	{
  		awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
    	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	flightnum=PropertyHandler.getPropValue(dataFilePath, flightnum);
    	fltDate=PropertyHandler.getPropValue(dataFilePath, fltDate);
    	origin=PropertyHandler.getPropValue(dataFilePath, origin);
    	
    	dest=PropertyHandler.getPropValue(dataFilePath, dest);
    	carrierCode=PropertyHandler.getPropValue(dataFilePath, carrierCode);
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_AWBNo, AWBNo);
    	click(btn_list);
    	minWait();
    	enterKeys(txt_carrier, carrierCode);
    	enterKeys(txt_flightDate, fltDate);
    	enterKeys(txt_fltNo, flightnum);
    	enterKeys(txt_origin, origin);
    	enterKeys(txt_dest, dest);
    	click(btn_save);
    	 driver.switchTo().defaultContent();
    	 if(verifyElementPresent(Generic_btn_ok))
         click(Generic_btn_ok);
         waitForFrameAndSwitch(FRAME);
    	
    	
    	
  		return this;
  	}
    public HomePage close(){
    	click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }


	public CRA181 closeToCRA181() {

		click(btn_close);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		waitForFrameAndSwitch("iCargoContentFrameCRA181");
		return new CRA181(driver, dataFilePath);
	}
}







