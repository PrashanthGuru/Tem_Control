package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class REC002 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
    public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String filepath;

    public static String FRAME = "iCargoContentFrameFLT005";
    WebDriver driver;
    String testDataFile;
    
    By
    txt_origin,
    txt_destination,
    txt_viaPoint,
    txt_refNumber,
    txt_startDate,
    txt_endDate,
    dropdown_parameterCode,
    txt_commodity,
    btn_ListBtn,
    info_RefId,
    btn_CancelBtn,
    btn_CloseBtn,
    dropdown_level,
    dropdown_status,
    dropdown_flightTypeFiltrValue,
    btn_approve,
    tbl_embargoDetails,
    yesBtn;

    public REC002(WebDriver driver, String testDataFile) {
        super(driver);
        this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver, this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + testDataFile;
        initPageElements();
    }
    
    private void initPageElements() {
    	
    	txt_origin                   = MiscUtility.getWebElement(objFilepath, "REC002_txt_origin");
    	txt_destination              = MiscUtility.getWebElement(objFilepath, "REC002_txt_destination");
    	txt_viaPoint                 = MiscUtility.getWebElement(objFilepath, "REC002_txt_viaPoint");
    	txt_refNumber                = MiscUtility.getWebElement(objFilepath, "REC002_txt_refNumber");
    	txt_startDate                = MiscUtility.getWebElement(objFilepath, "REC002_txt_startDate");
    	txt_endDate                  = MiscUtility.getWebElement(objFilepath, "REC002_txt_endDate");
    	dropdown_parameterCode       = MiscUtility.getWebElement(objFilepath, "REC002_dropdown_parameterCode");
    	txt_commodity                = MiscUtility.getWebElement(objFilepath, "REC002_txt_commodity");
    	btn_ListBtn                  = MiscUtility.getWebElement(objFilepath, "REC002_btn_ListBtn");
    	info_RefId                   = MiscUtility.getWebElement(objFilepath, "REC002_info_RefId");
    	btn_CancelBtn                = MiscUtility.getWebElement(objFilepath, "REC002_btn_CancelBtn");
    	btn_CloseBtn                 = MiscUtility.getWebElement(objFilepath, "REC002_btn_CloseBtn");
    	dropdown_level               = MiscUtility.getWebElement(objFilepath, "REC002_dropdown_level");
    	dropdown_status              = MiscUtility.getWebElement(objFilepath, "REC002_dropdown_status");
    	yesBtn                       = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
    	dropdown_flightTypeFiltrValue=MiscUtility.getWebElement(objFilepath, "REC002_dropdown_flightTypeFiltrValue");
    	tbl_embargoDetails           =MiscUtility.getWebElement(objFilepath, "REC002_tbl_embargoDetails");
    	btn_approve       			=MiscUtility.getWebElement(objFilepath, "REC002_btn_approve");
    }
    /***
     * 
     * @param Origin
     * @param destination
     * @param parameterCode
     * @param ParameterValue
     * @return
     *author A-6784**/
    
    public REC002 storeEmbargoRefNo(String Level,String parameterCode,String ParameterValue,String key_RECO_Refnum){
    	
    	
    	
    	parameterCode      = PropertyHandler.getPropValue(filepath, parameterCode);
    	ParameterValue     = PropertyHandler.getPropValue(filepath, ParameterValue);
    	
    	 selectByText(dropdown_level, Level);
    	 selectByText(dropdown_status, "ACTIVE");
    	 enterKeys(txt_startDate, ".");
    	 enterKeys(txt_endDate, "+7");
    	 selectByText(dropdown_parameterCode, parameterCode);
    	 if(parameterCode.equals("Commodity")){
    		 
    		 enterKeys(txt_commodity, ParameterValue);
    	 }
    	 else if(parameterCode.equals("Flight Type")){
    		 
    		 selectByText(dropdown_flightTypeFiltrValue, ParameterValue);
    	 }
    	 click(btn_ListBtn);
    	 minWait();
    	 String tempRefid = waitForElement(info_RefId).getAttribute("value");
    	 PropertyHandler.setPropValue(filepath, key_RECO_Refnum, tempRefid);
    	 
		return this;
    	
    }
    
public REC002 storeEmbargoRefNo_Activate(String Level,String parameterCode,String ParameterValue,String key_RECO_Refnum){
    	
    	
    	
    	parameterCode      = PropertyHandler.getPropValue(filepath, parameterCode);
    	ParameterValue     = PropertyHandler.getPropValue(filepath, ParameterValue);
    	
    	 selectByText(dropdown_level, Level);
    	 selectByText(dropdown_status, "DRAFT");
    	 enterKeys(txt_startDate, ".");
    	 enterKeys(txt_endDate, "+7");
    	 selectByText(dropdown_parameterCode, parameterCode);
    	 if(parameterCode.equals("Commodity")){
    		 
    		 enterKeys(txt_commodity, ParameterValue);
    	 }
    	 else if(parameterCode.equals("Flight Type")){
    		 
    		 selectByText(dropdown_flightTypeFiltrValue, ParameterValue);
    	 }
    	 click(btn_ListBtn);
    	 minWait();
    	 String tempRefid =getTableCellValue(tbl_embargoDetails, 3, 1);
    	 
    	 System.out.println(tempRefid);
    	 PropertyHandler.setPropValue(filepath, key_RECO_Refnum, tempRefid);
    	 tblSelectRowByColValue(tbl_embargoDetails, 1, 3, tempRefid);
    	 
    	click(btn_approve);
    	minWait();
    	selectByText(dropdown_status, "ACTIVE");
   	 click(btn_ListBtn);
	 minWait();
    	
    	String tempStatus =getTableCellValue(tbl_embargoDetails, 14, 1);
    	System.out.println();
    	
    	 Assert.assertTrue(tempStatus.equals("ACTIVE"),"ERROR :No data found");
    
		return this;
    	
    }
    public REC002 CancelEmbargo(String key_RECO_Refnum){
    	
    	enterKeys(txt_refNumber, key_RECO_Refnum);
    	click(btn_ListBtn);
   	 minWait();
   	 click(btn_CancelBtn);
   	minWait();
   	if (verifyElementPresent(yesBtn)) {
        click(yesBtn);
        waitForFrameAndSwitch(FRAME);
        
    }
   	
		return this;
    	
    }
    public HomePage close() {

        click(btn_CloseBtn);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, testDataFile);
    }

}
