package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


/**
 * Screen OPR026 - CAPTURE AWB
 * Created on 21/12/2017
 *
 * @author a-7868
 */
public class CRA074 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA032";
    public static String screenFrame = "iCargoContentFrameCRA032";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By text_shipmentPrefix,
    txt_documentNumber,
    btn_btList,chkbox_isSelectAll,yesBtn,
    btn_btClose,tbl_listCCA,
    txt_agentCode;
   
    public CRA074(WebDriver driver, String dataFileName) {
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

    	text_shipmentPrefix = MiscUtility.getWebElement(objFilepath, "CRA074_txt_shipmentPrefix");
    	txt_documentNumber = MiscUtility.getWebElement(objFilepath, "CRA074_txt_documentNumber");
    	btn_btList = MiscUtility.getWebElement(objFilepath, "CRA074_btn_btList");
    	btn_btClose = MiscUtility.getWebElement(objFilepath, "CRA074_btn_btClose");
    	chkbox_isSelectAll = MiscUtility.getWebElement(objFilepath, "CRA074_chkbox_isSelectAll");
    	tbl_listCCA = MiscUtility.getWebElement(objFilepath, "CRA074_tbl_listCCA");
    	txt_agentCode = MiscUtility.getWebElement(objFilepath, "CRA074_txt_agentCode");
    	
    	 yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
       
    }
    public CRA074 ApproveMultipleCCA(String agent,String fullawbno,String fullawbno2,String fullawbno3){


fullawbno = PropertyHandler.getPropValue(dataFilePath, fullawbno);
fullawbno2 = PropertyHandler.getPropValue(dataFilePath, fullawbno2);
fullawbno3 = PropertyHandler.getPropValue(dataFilePath, fullawbno3);

enterKeys(txt_agentCode, agent);

click(btn_btList);
minWait();

tblSelectRowByColValue(tbl_listCCA, 1, 3, fullawbno);
tblSelectRowByColValue(tbl_listCCA, 1, 3, fullawbno2);
tblSelectRowByColValue(tbl_listCCA, 1, 3, fullawbno3);


return this;

    }

   
    public HomePage close() {

        click(btn_btClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
