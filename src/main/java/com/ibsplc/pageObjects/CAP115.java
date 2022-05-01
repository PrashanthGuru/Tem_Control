package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP115 extends BasePage{

	public String dataFilePath;
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public String dataFileName;
    public static String FRAME = "iCargoContentFrameCAP116";
    WebDriver driver;    
    String testDataFile;
    String browser;
    
    public CAP115(WebDriver driver, String dataFileName) {
		 super(driver);
        this.driver = driver;
        this.testDataFile = dataFileName;
        PageFactory.initElements(this.driver,this);
        dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+dataFileName;
        this.dataFileName=dataFileName;
        initPageElements();
	}    
    
    private By  tbl_allotmnt,  
    			txt_fltNo,
    			txt_carrCode,
    			btn_list,
    			btn_close,
    			yesBtn;
    
    private void initPageElements()
    {
    	txt_carrCode= MiscUtility.getWebElement(objFilepath,"CAP115_txt_carrCode");
    	txt_fltNo= MiscUtility.getWebElement(objFilepath,"CAP115_txt_fltNo");
    	tbl_allotmnt= MiscUtility.getWebElement(objFilepath,"CAP115_tbl_allotmnt");    	
    	btn_list= MiscUtility.getWebElement(objFilepath,"CAP115_btn_list");
    	btn_close = MiscUtility.getWebElement(objFilepath,"CAP115_btn_close");
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");    	
    }
    
    /**
     * Method to list a flight and verify whether the given Allotment ID is mapped to the flight
     * @param carrCode
     * @param fltNum
     * @param allotId
     * @return
     * @author A-7868 Krishna <08/05/2018>
     */
    public CAP115 listFlightAndVerifyAllotment(String carrCode, String fltNum, String allotId){
    	
    	carrCode=PropertyHandler.getPropValue(dataFilePath, carrCode);
    	fltNum=PropertyHandler.getPropValue(dataFilePath, fltNum);
    	allotId=PropertyHandler.getPropValue(dataFilePath, allotId);
    	
    	enterKeys(txt_carrCode, carrCode);
    	enterKeys(txt_fltNo, fltNum);
    	click(btn_list);
    	minWait();
    	
    	Assert.assertTrue(getTableColumnValues(tbl_allotmnt, 2).contains(allotId), "ERROR : Allotment ID not present under Flight");
    	return this;
    }
    
      
    /**
     * Method to close the screen and return Home page instance
     * @return
     * @author A-7868 Krishna
     */
    public HomePage close() {

    	click(btn_close);
    	driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {
            click(yesBtn);
        }
        return new HomePage(driver,testDataFile);
    }
}
