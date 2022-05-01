package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


public class TRF021 extends BasePage {

    private static String objFilepath         = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    private static String genObjPath          = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private String dataFilePath               = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    public static String FRAME = "iCargoContentFrameTRF021";
    private String screenFrame;
    private String dataFileName;
    private WebDriver driver;
    
    private By btn_genericYes,
	info_msg,
	btn_noBtn;
    By
    txt_ChargeHead,
    btn_List,
    Tbl_listChargeTable,
    btn_Close;

    
    

	   
	String testDataFile;

	public  TRF021(WebDriver driver, String testDataFile) {
		 super(driver);
	    this.driver = driver;
	    this.testDataFile = testDataFile;
	    PageFactory.initElements(this.driver,this);
	    dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
	    initElements();
	} 
    private void initElements() {
    	
    	txt_ChargeHead        = MiscUtility.getWebElement(objFilepath, "TRF021_txt_ChargeHead");
    	btn_List	          = MiscUtility.getWebElement(objFilepath, "TRF021_btn_List");          
    	Tbl_listChargeTable   = MiscUtility.getWebElement(objFilepath, "TRF021_Tbl_listChargeTable");
    	btn_Close             = MiscUtility.getWebElement(objFilepath, "TRF021_btn_Close");
    	
    }
public TRF021 verifyChargehead(String chargeHead){
    	
    	chargeHead=PropertyHandler.getPropValue(dataFilePath, chargeHead);
    	
    	enterKeys(txt_ChargeHead,chargeHead);
    	click(btn_List);
    	String tmpChrg = getTableCellValue(Tbl_listChargeTable, 2, 1);
    	if(tmpChrg.contains(chargeHead)){
    		System.out.println("Charge Head "+tmpChrg+" Listed successfully");
    	}
    	
		return this;
    }
public HomePage close() {

    click(btn_Close);
    driver.switchTo().defaultContent();
    if (verifyElementPresent(btn_genericYes)) {

        click(btn_genericYes);
    }
    return new HomePage(driver, dataFileName);
} 
    
}
