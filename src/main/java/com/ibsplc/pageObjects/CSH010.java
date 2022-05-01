package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author A-8254 on 24/4/2018.
 *
 */
import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * @author A-8254 on 24/4/2018.
 */
public class CSH010 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "LTE_CSH_CLM.properties");
    private static String FRAME = "iCargoContentFrameCSH010";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By 
    dropdown_level,
    dropdown_paymentMode,
    txt_fromDate,
    btn_list,
    table_paymenList,
    btn_Close,
    btn_genericYes,
    btn_print;
    
    
    
    
    
   
    public CSH010(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
    	
 
    	dropdown_level = MiscUtility.getWebElement(objFilepath, "CSH010_dropdown_level");
    	dropdown_paymentMode = MiscUtility.getWebElement(objFilepath, "CSH010_dropdown_paymentMode");
    	txt_fromDate = MiscUtility.getWebElement(objFilepath, "CSH010_txt_fromDate");
    	btn_list = MiscUtility.getWebElement(objFilepath, "CSH010_btn_list");
    	table_paymenList = MiscUtility.getWebElement(objFilepath, "CSH010_table_paymenList");
    	btn_Close= MiscUtility.getWebElement(objFilepath, "CSH010_btn_Close");
    	btn_genericYes=MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btn_print=MiscUtility.getWebElement(objFilepath, "CSH010_btn_print");
       }

   
    public CSH010 listPaymentSummary(String level,String fromDate,String paymentMode)
    {
    	
    	level = PropertyHandler.getPropValue(dataFilePath,level);
    	fromDate = PropertyHandler.getPropValue(dataFilePath,fromDate);
    	paymentMode = PropertyHandler.getPropValue(dataFilePath,paymentMode);
        selectByText(dropdown_level, level);
        selectByText(dropdown_paymentMode, paymentMode);
    	enterKeys(txt_fromDate,fromDate);
    	click(btn_list);
    	minWait();
    	int rows=getTableRowCount(table_paymenList);
    	Assert.assertTrue(rows>=1, "table result not showing");
    	
    	
    	
    	
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
    
    
    public CSH010 printList()
    {
 	   
    	minWait();
   
 	Assert.assertTrue(waitForElement(btn_print).isEnabled(),"print button is enabled and present");
 	click(btn_print);
 	waitForNewWindow(2);
 	switchToSecondWindow();
     closeAndmoveToFirstWindow();
     waitForFrameAndSwitch(FRAME);
 	return this;  
    }
     
    
    
}
