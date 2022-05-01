package com.ibsplc.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP031 extends BasePage{

	
	private final static Logger logger = Logger.getLogger(BasePage.class);	   
	
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameCAP026";
    public static By popupFrame = By.id("popupContainerFrame");
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;
    	
    private By btn_genericYes,
				btn_genericOk,
				Generic_info_msg,
				info_error,
				btn_close,
				btn_list,
				txt_origin,
				txt_dest,
				txt_shpDt,
				btn_clear,
				tbl_fltDetails;
    
    public CAP031(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    
    private void initElements() {
       
    	btn_list = MiscUtility.getWebElement(objFilepath, "CAP031_btn_list");
		txt_origin = MiscUtility.getWebElement(objFilepath, "CAP031_txt_origin");
		txt_dest = MiscUtility.getWebElement(objFilepath, "CAP031_txt_dest");
		txt_shpDt = MiscUtility.getWebElement(objFilepath, "CAP031_txt_shpDt");
		btn_clear = MiscUtility.getWebElement(objFilepath, "CAP031_btn_clear");
		btn_close = MiscUtility.getWebElement(objFilepath, "CAP031_btn_close");
		tbl_fltDetails = MiscUtility.getWebElement(objFilepath, "CAP031_tbl_fltDetails");
		
    	btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        Generic_info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        
    }
    
    private void list(String from, String to, String date){
    	
    	enterKeys(txt_origin, from);
    	enterKeys(txt_dest, to);
    	enterKeys(txt_shpDt, date);
    	click(btn_list);
    	minWait();
    	return;
    }
    
    public CAP031 verifyIfFltCapacityGreen(String origin, String dest, String shpmentDate, String carrCode, String fltNum){
    	
    	list(origin, dest, shpmentDate);
    	
    	String xpath = "//td[contains(text(), '"+carrCode+" "+fltNum+"')/following-sibling::td[10]/img]";
    	Assert.assertTrue(waitForElement(By.xpath(xpath)).getAttribute("src").contains("finished-indicator"), "ERROR: Capacity indicator is not green.");
    	return this;
    }
    /**
     * Closes the screen and go to home screen
     *
     * @return
     * @author A-7868
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}
