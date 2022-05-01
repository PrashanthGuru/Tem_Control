package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


/**
 * Screen CRA032
 * Created on 12/02/2018
 *
 * @author a-6836
 */
public class CRA001 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA001";
    public static String screenFrame = "iCargoContentFrameCRA001";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By text_flightCarrierCode,
    text_flightNumber,chkbox_check,btn_ErrorlogbtnClose,
    text_fromDate,text_toDate,yesBtn,
    tbl_listCRAFlight,btn_btnList,btn_btnAccountDetails,
    btn_btnProcessFlight,btn_btnFltRevenue,tbl_agentSettlementEnquiry,
    btn_btnClose,tbl_flightRevForSegment,btn_btnErrorLog,tbl_ErrorLogpaymentDetails;
   
    public CRA001(WebDriver driver, String dataFileName) {
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
    	
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	text_flightCarrierCode = MiscUtility.getWebElement(objFilepath,"CRA001_text_flightCarrierCode");
    	text_flightNumber = MiscUtility.getWebElement(objFilepath,"CRA001_text_flightNumber");
    	text_fromDate = MiscUtility.getWebElement(objFilepath,"CRA001_text_fromDate");
    	text_toDate = MiscUtility.getWebElement(objFilepath, "CRA001_text_toDate");
    	 
    	btn_btnList = MiscUtility.getWebElement(objFilepath,"CRA001_btn_btnList");
    	tbl_listCRAFlight= MiscUtility.getWebElement(objFilepath,"CRA001_tbl_listCRAFlight");
    	tbl_flightRevForSegment= MiscUtility.getWebElement(objFilepath,"CRA001_tbl_flightRevForSegment");
    	
    	btn_btnProcessFlight= MiscUtility.getWebElement(objFilepath,"CRA001_btn_btnProcessFlight");
    	btn_btnFltRevenue= MiscUtility.getWebElement(objFilepath,"CRA001_btn_btnFltRevenue");
    	chkbox_check= MiscUtility.getWebElement(objFilepath,"CRA001_chkbox_check");
    	btn_btnAccountDetails= MiscUtility.getWebElement(objFilepath,"CRA001FlightRevenue_btn_btnAccountDetails");
    	tbl_agentSettlementEnquiry= MiscUtility.getWebElement(objFilepath,"CRA001ListAcc_tbl_agentSettlementEnquiry");
    	btn_btnClose= MiscUtility.getWebElement(objFilepath,"CRA001_btn_btnClose");
    	btn_ErrorlogbtnClose=MiscUtility.getWebElement(objFilepath,"CRA001_btn_ErrorlogbtnClose");
    	btn_btnErrorLog=MiscUtility.getWebElement(objFilepath,"CRA001_btn_btnErrorLog");		
    	tbl_ErrorLogpaymentDetails=MiscUtility.getWebElement(objFilepath,"CRA001_tbl_ErrorLogpaymentDetails");
    }
    
    public CRA001 Check_ErrorStatus(String carriercode, String fltno, String frmdate,String todate,String ErrorCode){

    	carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
    	fltno = PropertyHandler.getPropValue(dataFilePath,fltno);
    	frmdate = PropertyHandler.getPropValue(dataFilePath,frmdate);
    	todate= PropertyHandler.getPropValue(dataFilePath,todate);
    	ErrorCode=PropertyHandler.getPropValue(dataFilePath,ErrorCode);
    	
    	enterKeys(text_flightCarrierCode, carriercode);
    	enterKeys(text_flightNumber, fltno);
    	enterKeys(text_fromDate, frmdate);
    	enterKeys(text_toDate, todate); 	
    	click(btn_btnList);
    	minWait();
    	check(chkbox_check);
    	click(btn_btnProcessFlight);
    	minWait();
    	tblSelectRowByColValue(tbl_listCRAFlight, 2, 6, "Processed with Error");
    	click(btn_btnErrorLog);
    	minWait();
    	tblSelectRowByColValue(tbl_ErrorLogpaymentDetails, 1, 2,ErrorCode);
    	click(btn_ErrorlogbtnClose);
    	return this;

    	    }  

    
    public CRA001 Check_ProcessStatus(String carriercode, String fltno, String frmdate,String todate){

    	carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
    	fltno = PropertyHandler.getPropValue(dataFilePath,fltno);
    	frmdate = PropertyHandler.getPropValue(dataFilePath,frmdate);
    	todate= PropertyHandler.getPropValue(dataFilePath,todate);
    	
    	enterKeys(text_flightCarrierCode, carriercode);
    	enterKeys(text_flightNumber, fltno);
    	enterKeys(text_fromDate, frmdate);
    	enterKeys(text_toDate, todate); 	
    	click(btn_btnList);
    	minWait();
    	check(chkbox_check);
    	click(btn_btnProcessFlight);
    	minWait();
    	tblSelectRowByColValue(tbl_listCRAFlight, 2, 6, "Processed");
    	
    	return this;

    	    }  
 
    public CRA001 Check_ProcessStatusJob(String carriercode, String fltno, String frmdate,String todate){

    	carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
    	fltno = PropertyHandler.getPropValue(dataFilePath,fltno);
    	frmdate = PropertyHandler.getPropValue(dataFilePath,frmdate);
    	todate= PropertyHandler.getPropValue(dataFilePath,todate);
    	
    	enterKeys(text_flightCarrierCode, carriercode);
    	enterKeys(text_flightNumber, fltno);
    	enterKeys(text_fromDate, frmdate);
    	enterKeys(text_toDate, todate); 	
    	click(btn_btnList);
    	minWait();
    //	check(chkbox_check);
    //	click(btn_btnProcessFlight);
    	minWait();
    	tblSelectRowByColValue(tbl_listCRAFlight, 2, 6, "Processed");
    	
    	return this;

    	    }  
    public CRA001 ProcessFlight_CheckRevenue(String carriercode, String fltno, String frmdate,String todate,String AWB){

    	carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
    	fltno = PropertyHandler.getPropValue(dataFilePath,fltno);
    	frmdate = PropertyHandler.getPropValue(dataFilePath,frmdate);
    	todate= PropertyHandler.getPropValue(dataFilePath,todate);
    	AWB= PropertyHandler.getPropValue(dataFilePath, AWB);

    	enterKeys(text_flightCarrierCode, carriercode);
    	enterKeys(text_flightNumber, fltno);
    	enterKeys(text_fromDate, frmdate);
    	enterKeys(text_toDate, todate); 	
    	click(btn_btnList);
    	minWait();
    	check(chkbox_check);
    	click(btn_btnProcessFlight);
    	minWait();
    	tblSelectRowByColValue(tbl_listCRAFlight, 2, 6, "Processed");
    	click(btn_btnFltRevenue);
    	minWait();
    	
    //	driver.switchTo().defaultContent();
    	
    		
    		String AWBNo=getTableCellValue(tbl_flightRevForSegment, 3, 1);
    		System.out.println("AWB is : "+AWBNo);
    		Assert.assertTrue(AWBNo.contains(AWB), "ERROR: AWB no does not match");
    		
    		String P_PA=getTableCellValue(tbl_flightRevForSegment, 7, 1);
    		System.out.println("Prepaid Charges Prorated Amount:"+P_PA);
    		
    		String P_OCD=getTableCellValue(tbl_flightRevForSegment, 8, 1);
    		System.out.println("Prepaid Charges OCD Carrier:"+P_OCD);
    		
    		String C_CA=getTableCellValue(tbl_flightRevForSegment, 9, 1);
    		System.out.println("Charges Collect Prorated Amount:"+C_CA);
    		
    		String C_OCD=getTableCellValue(tbl_flightRevForSegment, 10, 1);
    		System.out.println("Charges Collect OCD Carrier:"+C_OCD);
    		
    
    		String NetRevenue=getTableCellValue(tbl_flightRevForSegment, 12, 1);
    		System.out.println("Net Revenue:"+NetRevenue);
    		if(NetRevenue==null)
    		{
    			System.out.println("Net revenue not calculated");
    		}
    		tblSelectRowByColValue(tbl_flightRevForSegment, 1, 3,AWB);
            click(btn_btnAccountDetails);
            minWait();
            
        /*	String Debit=getTableCellValue(tbl_agentSettlementEnquiry, 7, 1);
    		System.out.println("Debit: "+Debit);
    		
    		
    		String Credit=getTableCellValue(tbl_agentSettlementEnquiry, 8, 1);
    		System.out.println("Credit: "+Credit);
    		
    	Assert.assertTrue(Debit.contains(Credit), "ERROR:Accounting not Triggered");*/
    		
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
