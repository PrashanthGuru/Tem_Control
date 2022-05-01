package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen OPR040 - Shipper Return Note
 * 
 * @author a-7868 Krishna <24/01/2018>
 *
 */
public class OPR040 extends BasePage{

	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private static String FRAME = "iCargoContentFrameOPR040";
   
    private WebDriver driver;
    private String dataFileName;
    
    private By txt_awbPre,
            txt_awbNo,
            btn_list,
            btn_clear,
            btn_close,
            txt_SRNNo,
            txt_staffId,
            txt_toDate,
            txt_returnPcs,
            txt_returnWt,
            btn_save,
            dropdown_returnReason,
            btn_pay,
            btn_acquit,
            txt_SRNStatus,
            info_msg,
            txt_remarks,
            btn_pymnt_ok,
            btn_finalize,
            txt_pymntAdvice,
            btn_pymnt_close,
            btn_genOk;

    private By btn_genericYes;


    public OPR040(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    /**
     * Method to initialize page objects
     * @author a-7868 Krishna <24/01/2018>
     */
    private void initElements() {

        txt_awbPre 	= MiscUtility.getWebElement(objFilepath, "OPR040_txt_awbPre");
        txt_awbNo 	= MiscUtility.getWebElement(objFilepath, "OPR040_txt_awbNo");
        btn_list 	= MiscUtility.getWebElement(objFilepath, "OPR040_btn_list");
        btn_clear 	= MiscUtility.getWebElement(objFilepath, "OPR040_btn_clear");
        btn_save 	= MiscUtility.getWebElement(objFilepath, "OPR040_btn_save");
        btn_close 	= MiscUtility.getWebElement(objFilepath, "OPR040_btn_close");

        txt_SRNNo 	= MiscUtility.getWebElement(objFilepath, "OPR040_txt_SRNNo");
        txt_staffId = MiscUtility.getWebElement(objFilepath, "OPR040_txt_staffId");
        txt_toDate 	= MiscUtility.getWebElement(objFilepath, "OPR040_txt_toDate");
        txt_returnPcs = MiscUtility.getWebElement(objFilepath, "OPR040_txt_returnPcs");
        txt_returnWt= MiscUtility.getWebElement(objFilepath, "OPR040_txt_returnWt");
        dropdown_returnReason = MiscUtility.getWebElement(objFilepath, "OPR040_dropdown_returnReason");
        btn_pay 	= MiscUtility.getWebElement(objFilepath, "OPR040_btn_pay");
        btn_acquit 	= MiscUtility.getWebElement(objFilepath, "OPR040_btn_acquit");
        txt_SRNStatus = MiscUtility.getWebElement(objFilepath, "OPR040_txt_SRNStatus");
        
        txt_remarks = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_txt_remarks");
        btn_pymnt_ok = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_btn_ok");
        btn_finalize = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_btn_finalize");
        txt_pymntAdvice = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_txt_adviceNo");
        btn_pymnt_close = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_btn_close");
        
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_genOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    } 
        
   /**
    * Method to list AWB and return shipment pieces
    * @param awbPre
    * @param awbNo
    * @param staffId
    * @param toDate
    * @param pcs
    * @param reasonCode
    * @param SRNNo
    * @return
    * @author a-7868 Krishna <24/01/2018>
    */
    public OPR040 returnShipmentAndSave(String awbPre, String awbNo, String staffId, String toDate, 
    							String pcs, String reasonCode, String SRNNo){
    	
    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	staffId = PropertyHandler.getPropValue(dataFilePath, staffId);
    	toDate = PropertyHandler.getPropValue(dataFilePath, toDate);
    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
    	reasonCode = PropertyHandler.getPropValue(dataFilePath, reasonCode);
    	
    	listAWB(awbPre, awbNo);
    	enterKeys(txt_staffId, staffId);
    	enterKeys(txt_toDate, toDate);
    	enterKeys(txt_returnPcs, pcs);
    	//selectByValue(dropdown_returnReason, reasonCode);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	String[] temp = waitForElement(info_msg).getText().split("-");
    	System.out.println("SRN No. = "+temp[1]);
    	PropertyHandler.setPropValue(dataFilePath, SRNNo, temp[1]);
    	click(btn_genOk);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	
    	return this;
    }

    /**
     * Method to list AWB and return shipment pieces
     * @param pcs
     * @param reasonCode: not read from Data sheet
     * @param SRNNo
     * @return
     * @author a-7868 Krishna <24/01/2018>
     */
    public OPR040 returnShipmentFromOPR335(String pcs, String wt, String reasonCode, String SRNNo){

        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);

        enterKeys(txt_staffId, "STAFFID");
        enterKeys(txt_toDate, "+7");
        enterKeys(txt_returnPcs, pcs);
        enterKeys(txt_returnWt, wt);
        selectByText(dropdown_returnReason, reasonCode);
        click(btn_save);
        driver.switchTo().defaultContent();
        String[] temp = waitForElement(info_msg).getText().split("-");
        System.out.println("SRN No. = "+temp[1]);
        PropertyHandler.setPropValue(dataFilePath, SRNNo, temp[1].trim());
        click(btn_genOk);
        minWait();
        waitForFrameAndSwitch("iCargoContentFrameOPR335");

        return this;
    }
    
    /**
     * Method to pay and deliver returned shipments
     * @param SRNNo
     * @return
     * @author a-7868 Krishna <24/01/2018>
     */
    public OPR040 payAndAcquitSRN(String SRNNo){

		SRNNo = PropertyHandler.getPropValue(dataFilePath, SRNNo);
		
		listSRN(SRNNo);
		try{	
			click(btn_pay);
			//payment
			enterKeys(txt_remarks, "Payment Remarks");
	        click(btn_pymnt_ok);
	        click(btn_finalize);
	        minWait();
	        click(btn_pymnt_close);        
	        minWait();		
	        Assert.assertTrue(waitForElement(txt_SRNStatus).getText().contains("Paid"),"ERROR : Paid status");	
		}catch(TimeoutException e){
			;
		}
		catch(ElementNotSelectableException e){
			;
		}
        click(btn_acquit);
        driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(info_msg).getText().contains("Delivered"),"ERROR : Shipment not delivered");
        click(btn_genOk);
        waitForFrameAndSwitch(FRAME);
        click(btn_clear);
        return this;
}
    /**
     * Method to list with awb no.
     * @param awbPre
     * @param awbNo
     * @author a-7868 Krishna <24/01/2018>
     */
    public void listAWB(String awbPre, String awbNo){
    	
    	enterKeys(txt_awbPre, awbPre);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_list);
    	minWait();
    }
    /**
     * Method to list with SRN No.
     * @param SRNNo
     * @author a-7868 Krishna <24/01/2018>
     */
    public void listSRN(String SRNNo){
    	
    	enterKeys(txt_SRNNo, SRNNo);
    	click(btn_list);
    	minWait();
    }


    /**
     * CLose and screen and go to home page
     * @return
     * @author a-7868 Krishna <24/01/2018>
     */
    public OPR335 closeToOPR335() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        waitForFrameAndSwitch("iCargoContentFrameOPR335");
        return new OPR335(driver, dataFileName);
    }

    /**
     * CLose and screen and go to home page
     * @return
     * @author a-7868 Krishna <24/01/2018>
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
