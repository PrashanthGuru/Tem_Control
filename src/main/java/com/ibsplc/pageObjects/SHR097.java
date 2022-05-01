package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * 
 * @author A-7868 Krishna <03/07/2018>
 *
 */
public class SHR097 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
  
    public static String FRAME = "iCargoContentFrameSHR097";
    
    private By 	dropdown_masterType,
    			btn_close,
    			btn_genericYes,
    			tbl_rankTable;
    
    private WebDriver driver;
    private String dataFileName; 
    
    public SHR097(WebDriver driver,String dataFileName){
    	super(driver);
    	this.driver = driver;
    	initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    
    
    private void initElements(){
    	
    	dropdown_masterType = MiscUtility.getWebElement(objFilepath, "SHR097_dropdown_masterType");
    	tbl_rankTable = MiscUtility.getWebElement(objFilepath, "SHR097_tbl_rankTable");
    	btn_close = MiscUtility.getWebElement(objFilepath, "SHR097_btn_close");
    	
    	btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }
    
    /**
     * Method to list the ShipRank Master and get the SCC of given rank
     * @param rank
     * @param sccOfGivenRank
     * @return
     * @author A-7868 Krishna <03/07/2018>
     */
    public SHR097 getSCCfromShpRankMaster(String rank, String sccOfGivenRank){
    
    	rank = PropertyHandler.getPropValue(dataFilePath, rank);
    	
    	selectByText(dropdown_masterType, "ShpRank Master");
    	minWait();
    	waitForElement(tbl_rankTable);
    	String scc = tblGetTextByColValue(tbl_rankTable, 2, 1, rank);
    	PropertyHandler.setPropValue(dataFilePath, sccOfGivenRank, scc);
    	return this;
    }
    
    public HomePage close(){
    	
    	click(btn_close);		
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
             click(btn_genericYes);
         }
		
		return new HomePage(driver,dataFileName);
	}
}
