
package com.ibsplc.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class SHR046 extends BasePage {

	public SHR046(WebDriver driver, String testDataFile) {
		super(driver);
        this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver, this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + testDataFile;
        initPageElements();
	}
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String filepath;
    public static String FRAME = "iCargoContentFrameSHR033";
    WebDriver driver;
    String testDataFile;
    
    By
    dropdown_groupType,
	txt_groupName,
	dropdown_categor,
	btn_list,
	selectAirCraftPopup_txt_aircraft,
	selectAirCraftPopup_btn_list,
	selectAirCraftPopup_chkbx_selectaircraft,
	selectAirCraftPopup_btn_OK,
	selectAirCraftPopup_btn_clear,
	btn_close,
	btn_save,
	txt_restrictionIdFilter,
	btn_listmain,
	chkbx_selectData,
	btn_inactivate
;
By
yesBtn;
    
    
    private void initPageElements(){
        
    	dropdown_groupType=MiscUtility.getWebElement(objFilepath, "SHR046_dropdown_groupType");
    	txt_groupName=MiscUtility.getWebElement(objFilepath, "SHR046_txt_groupName");
    	dropdown_categor=MiscUtility.getWebElement(objFilepath, "SHR046_dropdown_categor");
    	btn_list=MiscUtility.getWebElement(objFilepath, "SHR046_btn_list");
    	selectAirCraftPopup_txt_aircraft=MiscUtility.getWebElement(objFilepath, "SHR046_selectAirCraftPopup_txt_aircraft");
    	selectAirCraftPopup_btn_list=MiscUtility.getWebElement(objFilepath, "SHR046_selectAirCraftPopup_btn_list");
    	selectAirCraftPopup_chkbx_selectaircraft=MiscUtility.getWebElement(objFilepath, "SHR046_selectAirCraftPopup_chkbx_selectaircraft");
    	selectAirCraftPopup_btn_OK=MiscUtility.getWebElement(objFilepath, "SHR046_selectAirCraftPopup_btn_OK");
    	selectAirCraftPopup_btn_clear=MiscUtility.getWebElement(objFilepath, "SHR046_selectAirCraftPopup_btn_clear");
    	btn_save=MiscUtility.getWebElement(objFilepath, "SHR046_btn_save");
    	btn_close=MiscUtility.getWebElement(objFilepath, "SHR046_btn_close");
    	yesBtn = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
    	txt_restrictionIdFilter=MiscUtility.getWebElement(objFilepath, "SHR046_txt_restrictionIdFilter");
    	btn_listmain=MiscUtility.getWebElement(objFilepath, "SHR046_btn_listmain");
    	chkbx_selectData=MiscUtility.getWebElement(objFilepath, "SHR046_chkbx_selectData");
    	btn_inactivate=MiscUtility.getWebElement(objFilepath, "SHR046_btn_inactivate");
    }
    
    
    
    public SHR046 createnewparameterGrp(String parameterGropType,String parameterGrpname,String... SCC){
    	
    	parameterGropType=PropertyHandler.getPropValue(filepath, parameterGropType);
    	parameterGrpname=PropertyHandler.getPropValue(filepath, parameterGrpname);
    	
    	
    	selectByText(dropdown_groupType, parameterGropType);
    	enterKeys(txt_groupName, parameterGrpname);
    	selectByText(dropdown_categor, "General");
    	
    	click(btn_list);
    	
    	driver.switchTo().defaultContent();
    	
    	if(verifyElementPresent(yesBtn)){
    		
    		
    		
    		click(yesBtn);
    		minWait();
    		
    		waitForNewWindow(2);
    		switchToSecondWindow();
    		
    		int sccNumb=SCC.length;
    	for(int i=0;i<=sccNumb;i++){
    		
    		//msgSuperSubType[0]
    		
    		enterKeys(selectAirCraftPopup_txt_aircraft, SCC[i]);
    		click(selectAirCraftPopup_btn_list);
    		check(selectAirCraftPopup_chkbx_selectaircraft);
    		
    	}
    		click(selectAirCraftPopup_btn_OK);
    		
    		switchToFirstWindow();
    		
    		click(btn_save);
    		
    		
    	}
    	
    return this;
    	
    }

    public SHR046 InactivateRestriction(String restrictionId){
    	
    	restrictionId=PropertyHandler.getPropValue(filepath, restrictionId);
		
    	
    	enterKeys(txt_restrictionIdFilter, restrictionId);
    	
    	click(btn_listmain);
    	minWait();
    	
    	check(chkbx_selectData);
    	scrollToView(btn_inactivate);
    	click(btn_inactivate);
    	minWait();
    	
    By table=By.id("restrictionTable");
    
    	Assert.assertTrue(getTableCellTextValue(table, 8, 1).equals("Inactive"));
    	
    	return this;
    	
    }
    
    
    public HomePage close(){
    	click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, testDataFile);
    }
    
    
    
    
    
    
    
}
