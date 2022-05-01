package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * SHR109 : Maintain and List Aircraft Restrictions
 * @author A-7868
 * <30/05/2018>
 */
public class SHR109 extends BasePage{

	public static String FRAME = "iCargoContentFrameSHR109";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");

    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;
   
    By filter_txt_aircraftType,
		btn_list,
		tbl_restrictionTable,
		txt_aircraftType,
		dropdown_validationType,
		dropdown_bkgStatus,
		dropdown_rsnCode,
		txt_rmarks,
		lnk_addParameter,
		dropdown_parameterCode,
		txt_weightLimit,
		txt_paramValues,
		btn_addModify,
		btn_close,
		yesBtn,
		txt_refNo,
		btn_inactivate,
		lnk_deleteRstrctn;
    
    public SHR109(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    
    private void initElements() {
    	
    	filter_txt_aircraftType = MiscUtility.getWebElement(objFilepath, "SHR109_filter_txt_aircraftType");
    	btn_list = MiscUtility.getWebElement(objFilepath, "SHR109_btn_list");
    	tbl_restrictionTable = MiscUtility.getWebElement(objFilepath, "SHR109_tbl_restrictionTable");
    	txt_aircraftType = MiscUtility.getWebElement(objFilepath, "SHR109_txt_aircraftType");
    	dropdown_validationType = MiscUtility.getWebElement(objFilepath, "SHR109_dropdown_validationType");
    	dropdown_bkgStatus = MiscUtility.getWebElement(objFilepath, "SHR109_dropdown_bkgStatus");
    	dropdown_rsnCode = MiscUtility.getWebElement(objFilepath, "SHR109_dropdown_rsnCode");
    	txt_rmarks = MiscUtility.getWebElement(objFilepath, "SHR109_txt_rmarks");
    	lnk_addParameter = MiscUtility.getWebElement(objFilepath, "SHR109_lnk_addParameter");
    	dropdown_parameterCode = MiscUtility.getWebElement(objFilepath, "SHR109_dropdown_parameterCode");
    	txt_paramValues = MiscUtility.getWebElement(objFilepath, "SHR109_txt_paramValues");
    	btn_addModify = MiscUtility.getWebElement(objFilepath, "SHR109_btn_addModify");
    	btn_close = MiscUtility.getWebElement(objFilepath, "SHR109_btn_close");
    	txt_refNo = MiscUtility.getWebElement(objFilepath, "SHR109_txt_refNo");
    	btn_inactivate = MiscUtility.getWebElement(objFilepath, "SHR109_btn_inactivate");
    	lnk_deleteRstrctn = MiscUtility.getWebElement(objFilepath, "SHR109_lnk_deleteRstrctn");
    	txt_weightLimit=MiscUtility.getWebElement(objFilepath, "SHR109_txt_weightLimit");
    	
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }
         
    /**
     * Method to create RSTQ restriction for given Aircraft Type
     * @param aircraftType
     * @param scc
     * @param rstId
     * @return
     * @author A-7868 Krishna <30/05/2018>
     */
    public SHR109 createRSTQ(String aircraftType, String scc, String rstId){
    	
    	aircraftType = PropertyHandler.getPropValue(dataFilePath, aircraftType);
    	scc = PropertyHandler.getPropValue(dataFilePath, scc);
    	
    	enterKeys(filter_txt_aircraftType, aircraftType);
    	click(btn_list);
    	minWait();
    	
    	try{
    		if(getTableRowCount(tbl_restrictionTable) > 0)
    			Assert.fail("ERROR : Restriction already exists for "+aircraftType+" with SCC "+scc);
    	}
    	catch(Exception e){
    		;
    	}
    	enterKeys(txt_aircraftType, aircraftType);
    	selectByText(dropdown_validationType, "Warning");
    	selectByText(dropdown_bkgStatus, "Queue");
    	selectByText(dropdown_rsnCode, "RSTQ");
    	enterKeys(txt_rmarks, "Remarks by automation");
    	
    	click(lnk_addParameter);
    	selectByText(dropdown_parameterCode, "SCC");
    	enterKeys(txt_paramValues, scc);
    	scrollToView(btn_addModify);
    	click(btn_addModify);
    	minWait();
    	
    	PropertyHandler.setPropValue(dataFilePath, rstId, getTableCellValue(tbl_restrictionTable, 2, 1));
    	
    	return this;
    	    	
    }
    /**
     * 
     * @param aircraft
     * @param restrictionType
     * @param sccValue
     * @param wgtLimit
     * @param rstId
     * @return
     */
    public SHR109 createRestriction_scc(String aircraft,String restrictionType,String sccValue,String wgtLimit,String rstId){
    	
    	aircraft = PropertyHandler.getPropValue(dataFilePath, aircraft);
    	sccValue = PropertyHandler.getPropValue(dataFilePath, sccValue);
    	wgtLimit = PropertyHandler.getPropValue(dataFilePath, wgtLimit);
    	
    	enterKeys(txt_aircraftType, aircraft);
    	selectByText(dropdown_validationType, restrictionType);

    	enterKeys(txt_rmarks, "Remarks by automation");
    	
    	click(lnk_addParameter);
    	selectByText(dropdown_parameterCode, "SCC");
    	enterKeys(txt_paramValues, sccValue);
    	
    	enterKeys(txt_weightLimit, wgtLimit);
    	scrollToView(btn_addModify);
    	click(btn_addModify);
    	minWait();
    	
    	PropertyHandler.setPropValue(dataFilePath, rstId, getTableCellValue(tbl_restrictionTable, 2, 1));
    	
    	return this;
    	   
    	
    }
    
    
public SHR109 createRestriction_sccGroup(String aircraft,String restrictionType,String sccValue,String wgtLimit,String rstId){
    	
    	aircraft = PropertyHandler.getPropValue(dataFilePath, aircraft);
    	sccValue = PropertyHandler.getPropValue(dataFilePath, sccValue);
    	wgtLimit = PropertyHandler.getPropValue(dataFilePath, wgtLimit);
    	
//    	selectByText(dr, text);
    	enterKeys(txt_aircraftType, aircraft);
    	selectByText(dropdown_validationType, restrictionType);

    	enterKeys(txt_rmarks, "Remarks by automation");
    	
    	click(lnk_addParameter);
    	selectByText(dropdown_parameterCode, "SCC");
    	enterKeys(txt_paramValues, sccValue);
    	
    	enterKeys(txt_weightLimit, wgtLimit);
    	scrollToView(btn_addModify);
    	click(btn_addModify);
    	minWait();
    	
    	PropertyHandler.setPropValue(dataFilePath, rstId, getTableCellValue(tbl_restrictionTable, 2, 1));
    	
    	return this;
    	   
    	
    }
    
    /**
     * Method to inactivate a Restriction
     * @param rstId
     * @return
     * @author A-7868 krishna <30/05/2018>
     */
    public SHR109 deleteRestriction(String rstId){
    	
    	rstId = PropertyHandler.getPropValue(dataFilePath, rstId);
    	
    	enterKeys(txt_refNo, rstId);
    	click(btn_list);
    	minWait();
    	
    	tblSelectRowByColValue(tbl_restrictionTable, 1, 2, rstId);
    	scrollToView(btn_inactivate);
    	click(btn_inactivate);
    	minWait();
    	scrollToView(tbl_restrictionTable);
    	Assert.assertTrue(getTableCellTextValue(tbl_restrictionTable, 8, 1).contains("Inactive"), "ERROR : Restriction not inactivated.");
    	tblSelectRowByColValue(tbl_restrictionTable, 1, 2, rstId);
    	click(lnk_deleteRstrctn);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	
    	return this;
    }
    /**
     * Method to close current page and return to Homepae
     * returns the instance of Homepage
     *
     * @return
     * @author A-7868
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
