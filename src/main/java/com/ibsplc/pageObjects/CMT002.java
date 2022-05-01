package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;



/**
 * 
 * @author A-6784
 *
 */
public class CMT002 extends BasePage {

    public static String FRAME = "iCargoContentFrameCMT002";
    public static String screenFrame = "iCargoContentFrameCMT002";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    
     By
     
     yesBtn,
     noBtn,
     msg_popup,
     btn_genericOk,info_error,
     info_genericMsg;
  By
  dropdown_locationType,
  text_locationValue,
  dropdown_status,
  dropdown_customertype,
  btn_list,btn_btnActivate,
  chkbox_customertypeCC,
  tbl_listCustomerTable,
  btn_inactivate,
  txt_customerCode,
  txt_expiringBefore,
  btn_close;

     
     
     
    public CMT002(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    /**
     * Initializes the page objects required for the class
     */
    private void initElements() {
    	
    	dropdown_locationType=MiscUtility.getWebElement(objFilepath, "CMT002_dropdown_locationType");
    	text_locationValue =MiscUtility.getWebElement(objFilepath, "CMT002_text_locationValue");
    	dropdown_status  =MiscUtility.getWebElement(objFilepath, "CMT002_dropdown_status");
    	dropdown_customertype =MiscUtility.getWebElement(objFilepath, "CMT002_dropdown_customertype");
    	btn_list=MiscUtility.getWebElement(objFilepath, "CMT002_btn_list");
    	chkbox_customertypeCC  =MiscUtility.getWebElement(objFilepath, "CMT002_chkbox_customertypeCC");
    	tbl_listCustomerTable =MiscUtility.getWebElement(objFilepath, "CMT002_tbl_listCustomerTable");
    	btn_close =MiscUtility.getWebElement(objFilepath, "CMT002_btn_close");
    	txt_customerCode=MiscUtility.getWebElement(objFilepath, "CMT002_txt_customerCode");
    	btn_btnActivate=MiscUtility.getWebElement(objFilepath, "CMT002_btn_btnActivate");
    	btn_inactivate=MiscUtility.getWebElement(objFilepath, "CMT002_btn_inactivate");
    	
    	
        yesBtn          = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        noBtn           = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        msg_popup       = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk   = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        txt_expiringBefore=MiscUtility.getWebElement(objFilepath, "CMT002_txt_expiringBefore");

    }
  
    
    public CMT002 inactivate_CC_Collector(String LocType,String locvalue,String CC_collector){
    	
    	LocType=PropertyHandler.getPropValue(dataFilePath, LocType);
    	locvalue=PropertyHandler.getPropValue(dataFilePath, locvalue);
    	CC_collector=PropertyHandler.getPropValue(dataFilePath, CC_collector);
    	
    	selectByValue(dropdown_locationType, LocType);
    	enterKeys(text_locationValue, locvalue);
    	selectByValue(dropdown_status, "Active");
    	enterKeys(txt_customerCode, CC_collector);
    	click(dropdown_customertype);
    	check(chkbox_customertypeCC);
    	click(btn_list);
    	
    	if((waitForElement(info_error).getText().contains("No Records found"))){
			System.out.println("ERROR:Active CC collectors are not present");}
    	else{
    		
    		tblSelectRowByColValue(tbl_listCustomerTable, 1, 9, "Active");
    		click(btn_inactivate);
    		driver.switchTo().defaultContent();
  	      click(yesBtn);
  		minWait();
  		waitForFrameAndSwitch(FRAME);
  		
    	}
		return this;
    	
    	
    }
    
    
/**
 *     
 * @param LocType
 * @param locvalue
 * @param status
 * @param status2
 * @param CC_collector
 * @param customertype
 * @return
 */
public CMT002 Activate_CCCollector(String LocType,String locvalue,String status,String status2,String CC_collector,String customertype){
	
	LocType=PropertyHandler.getPropValue(dataFilePath, LocType);
	locvalue=PropertyHandler.getPropValue(dataFilePath, locvalue);
	status=PropertyHandler.getPropValue(dataFilePath, status);
	status2=PropertyHandler.getPropValue(dataFilePath, status2);
	click(dropdown_locationType);
	minWait();
	selectByText(dropdown_locationType,"Station");
	enterKeys(text_locationValue, locvalue);
	selectByText(dropdown_status, status2);
	click(dropdown_customertype);
	check(chkbox_customertypeCC);
	minWait();
enterKeys(chkbox_customertypeCC, Keys.ESCAPE);
	//click(txt_expiringBefore);
	click(btn_list);
	minWait();

	//System.out.println(waitForElement(info_error).getText());
	if(isElementPresent(info_error)){
	//	if((waitForElement(info_error).getText().contains("No Records Found"))){
			System.out.println("ERROR:Active CC collectors are not present");
		selectByText(dropdown_status, status);
		click(btn_list);
		minWait();
		
		  tblSelectRowByColValue(tbl_listCustomerTable, 1, 2, customertype);
		  String CustomerCode=getTableCellValue(tbl_listCustomerTable, 3, 1);
			System.out.println("Active CC collector Customer Code: "+CustomerCode);
			PropertyHandler.setPropValue(dataFilePath, CC_collector, CustomerCode);
			
		  click(btn_btnActivate);
		  driver.switchTo().defaultContent();
	      click(yesBtn);
		minWait();
		waitForFrameAndSwitch(FRAME);
		
	}
		else{
	String CustomerCode=getTableCellValue(tbl_listCustomerTable, 3, 1);
	System.out.println("Active CC collector Customer Code: "+CustomerCode);
	PropertyHandler.setPropValue(dataFilePath, CC_collector, CustomerCode);
	
	
	
	minWait();
		}
	return this;
	
}

public HomePage close() {

    click(btn_close);
    driver.switchTo().defaultContent();
    if (verifyElementPresent(yesBtn)) {

        click(yesBtn);
    }
    return new HomePage(driver, dataFileName);
}


}
