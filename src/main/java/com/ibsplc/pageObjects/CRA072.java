package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;



/**

 * 
 * @author A-6784
 *
 */
public class CRA072 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA072";
    public static String screenFrame = "iCargoContentFrameCRA072";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
  
    
    
    By
    txt_AWBprefix,
    txt_masterDocumentNumber,
    btn_btnList,
    tbl_Flights,
    btn_btnClose;

    By
    
    yesBtn,
    noBtn,
    msg_popup,
    btn_genericOk,
    info_genericMsg;
    
    public CRA072(WebDriver driver, String dataFileName) {
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
                
                txt_AWBprefix           =MiscUtility.getWebElement(objFilepath, "CRA072_txt_AWBprefix");
                txt_masterDocumentNumber=MiscUtility.getWebElement(objFilepath, "CRA072_txt_masterDocumentNumber");
                btn_btnList             =MiscUtility.getWebElement(objFilepath, "CRA072_btn_btnList");
                tbl_Flights             =MiscUtility.getWebElement(objFilepath, "CRA072_tbl_Flights");
                btn_btnClose            =MiscUtility.getWebElement(objFilepath, "CRA072_btn_btnClose");
                
                
                
        yesBtn          = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        noBtn           = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        msg_popup       = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genericOk   = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        info_genericMsg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    

    }
    /***
     * customertype=Inbound/Outbound
     * for checking the inbound/outbound customer
     * @param awbPrefix
     * @param AWBNo
     * @param customertype
     * @return
     */
    public CRA072 checkCustomer(String awbPrefix,String AWBNo,String agentCode,String customertype){
                
                awbPrefix=PropertyHandler.getPropValue(dataFilePath, awbPrefix);
                AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
                agentCode=PropertyHandler.getPropValue(dataFilePath, agentCode);
                
                
                enterKeys(txt_AWBprefix, awbPrefix);
                enterKeys(txt_masterDocumentNumber, AWBNo);
                click(btn_btnList);
                minWait();
                if(customertype.equalsIgnoreCase("inbound")){
                                String status=getTableCellValue(tbl_Flights, 14, 1);
                System.out.println("Billing Status:"+status);
                Assert.assertFalse(waitForElement(tbl_Flights).getAttribute("value").contains(agentCode),"ERROR: agent type not matches");
                
                }
                else{
                String status=getTableCellValue(tbl_Flights, 12, 1);
                System.out.println("Billing Status:"+status);
                Assert.assertTrue(status.contains(agentCode),"ERROR: agent type not matches");
                }
                
                                
                
                minWait();
                return this;         
    }
    
    public HomePage close() {

        click(btn_btnClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }

}
