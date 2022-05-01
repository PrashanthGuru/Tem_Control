package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP118 extends BasePage{
	public String dataFilePath;
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
  
    public static String FRAME = "iCargoContentFrameCAP118";
    WebDriver driver;    
    String testDataFile;
    String browser;
    public CAP118(WebDriver driver, String dataFileName) {
		 super(driver);
        this.driver = driver;
        this.testDataFile = dataFileName;
        PageFactory.initElements(this.driver,this);
        dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+dataFileName;
        initPageElements();
	}
    
    private By txt_fltNo,
    			btn_list,
    			btn_close,
    			btn_clr,
    			tbl_altmnts,
    			yesBtn
    			;
    
    private void initPageElements()
    {
    	txt_fltNo 	= MiscUtility.getWebElement(objFilepath,"CAP118_txt_fltNo");
    	btn_list 	= MiscUtility.getWebElement(objFilepath,"CAP118_btn_list");
    	btn_close 	= MiscUtility.getWebElement(objFilepath,"CAP118_btn_close");
    	btn_clr		= MiscUtility.getWebElement(objFilepath,"CAP118_btn_clear");
    	tbl_altmnts	= MiscUtility.getWebElement(objFilepath,"CAP118_tbl_Allotments");
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }
    
    public CAP118 listScheduleAllotments(String fltNo,String carrier_code, String altId, String startDate, String endDate, String weight, String volume) 
    {
    	fltNo	= PropertyHandler.getPropValue(dataFilePath, fltNo);
    	startDate	= PropertyHandler.getPropValue(dataFilePath, startDate);
    	endDate	= PropertyHandler.getPropValue(dataFilePath, endDate);
    	weight	= PropertyHandler.getPropValue(dataFilePath, weight);
    	volume	= PropertyHandler.getPropValue(dataFilePath, volume);
    	altId=PropertyHandler.getPropValue(dataFilePath, altId);
    	carrier_code=PropertyHandler.getPropValue(dataFilePath, carrier_code);
    	enterKeys(txt_fltNo, fltNo);
    	click(btn_list);
    	System.out.println(altId);
    	minWait();
    	String altId_app=tblGetTextByColValue_input(tbl_altmnts, 3, 4, fltNo);
    	System.out.println(altId_app);
//    	String strtDt=tblGetTextByColValue_input(tbl_altmnts, 10, 4, fltNo);
//    	String endDt=tblGetTextByColValue_input(tbl_altmnts, 11, 4, fltNo);
//    	String wt=tblGetTextByColValue_input(tbl_altmnts, 12, 4, fltNo);
//    	String vol=tblGetTextByColValue_input(tbl_altmnts, 13, 4,fltNo);
    	
    	Assert.assertTrue(altId.equals(altId_app), "Allotment Id should be same as expected");
//    	Assert.assertTrue(strtDt.equalsIgnoreCase(startDate), "Start Date should be same as expected");
//    	Assert.assertTrue(endDt.equalsIgnoreCase(endDate), "End date should be same as expected");
//    	Assert.assertTrue(wt.equals(weight), "weight should be same as expected");
//    	Assert.assertTrue(vol.equals(volume), "Volume should be same as expected");
    	
    	
    	return this;
    }
    
   
     
    
    public HomePage close()
	{
		minWait();
    	Actions action = new Actions(driver);
    	action.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).perform();  	 
    	
    	driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver,testDataFile);
	}
}
