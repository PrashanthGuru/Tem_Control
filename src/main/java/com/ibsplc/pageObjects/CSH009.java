/**
 * 
 */
package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author A-6545 on 23/2/2018.
 *
 */
import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class CSH009 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "LTE_CSH_CLM.properties");
    private static String FRAME = "iCargoContentFrameCSH009";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By 
    txt_awbPrefix,
    txt_awbNo,
    btn_List,
    btn_Close,
    tbl_paymentAdviceEnquiry,
    txt_startDate,
    txt_endDate,
    chk_checkAll,
    list_Status,
    btn_Revalidate,
    txt_remarks,
    btn_Cancel,
    btn_pymnt_ok,
    btn_finalize,
    pymnt_btn_Save,
    pymnt_btn_close,
    txt_PaymentAdviceEnquiry_Remarks,
    btn_ReasonCode_Ok,
    btn_Details,
    btn_genericYes,
    txt_servicename,
    txt_servicedetails,
    txt_paymentadviceremarks,
    pymnt_btn_ok,
    btn_print;

   
    public CSH009(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {
    	
 
    	txt_awbPrefix = MiscUtility.getWebElement(objFilepath, "CSH009_txt_awbPrefix");
    	txt_awbNo = MiscUtility.getWebElement(objFilepath, "CSH009_txt_awbNo");
    	btn_List = MiscUtility.getWebElement(objFilepath, "CSH009_btn_List"); 
    	btn_Close = MiscUtility.getWebElement(objFilepath, "CSH009_btn_Close"); 
        txt_startDate = MiscUtility.getWebElement(objFilepath, "CSH009_txt_startDate"); 
        txt_endDate = MiscUtility.getWebElement(objFilepath, "CSH009_txt_endDate"); 
        chk_checkAll= MiscUtility.getWebElement(objFilepath, "CSH009_chk_checkAll"); 
        btn_Details= MiscUtility.getWebElement(objFilepath, "CSH009_btn_Details"); 
       pymnt_btn_close= MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_btn_close"); 
       list_Status= MiscUtility.getWebElement(objFilepath, "CSH009_list_Status"); 
       btn_Revalidate= MiscUtility.getWebElement(objFilepath, "CSH009_btn_Revalidate"); 
       txt_remarks = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_txt_remarks");
       btn_pymnt_ok = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_btn_ok");
       btn_finalize = MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_btn_finalize");
       pymnt_btn_Save= MiscUtility.getWebElement(objFilepath, "OPR026_pymnt_btn_Save");
       btn_Cancel= MiscUtility.getWebElement(objFilepath, "CSH009_btn_Cancel");
       btn_ReasonCode_Ok= MiscUtility.getWebElement(objFilepath, "CSH009_btn_ReasonCode_Ok");
       txt_PaymentAdviceEnquiry_Remarks= MiscUtility.getWebElement(objFilepath, "CSH009_txt_PaymentAdviceEnquiry_Remarks");
    	tbl_paymentAdviceEnquiry = MiscUtility.getWebElement(objFilepath, "CSH009_tbl_paymentAdviceEnquiry");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        
        //A-8255
        txt_servicename = MiscUtility.getWebElement(objFilepath, "CSH009_txt_servicename");
        txt_servicedetails= MiscUtility.getWebElement(objFilepath, "CSH009_txt_servicedetails");
       txt_paymentadviceremarks= MiscUtility.getWebElement(objFilepath, "CSH009_txt_paymentadviceremarks");
        pymnt_btn_ok= MiscUtility.getWebElement(objFilepath, "CSH009_pymnt_btn_ok");
        pymnt_btn_close= MiscUtility.getWebElement(objFilepath, "CSH009_pymnt_btn_close");
        
        btn_print=MiscUtility.getWebElement(objFilepath, "CSH009_btn_print");
       }

    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public CSH009 Cash_Draw_Details(String awbPre ,String awbNo ) {
    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
   	
      enterKeys(txt_awbPrefix, awbPre);
      enterKeys(txt_awbNo, awbNo);
      click(btn_List);
      String value=getTableCellValue(tbl_paymentAdviceEnquiry, 6, 1);
     System.out.println(value);
      Assert.assertTrue(value.contains(awbNo));
       minWait();
        return this;
    }
   
    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 23/2/2018.
     */
    public CSH009 List_Details(String awbPre ,String awbNo ) {
    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
   	
      enterKeys(txt_awbPrefix, awbPre);
      enterKeys(txt_awbNo, awbNo);
      enterKeys(txt_startDate, ".");
      enterKeys(txt_endDate,  ".");
      click(btn_List);
      minWait();
      check(chk_checkAll);
      click(btn_Details);
      minWait();
      click(pymnt_btn_close);
       minWait();
        return this;
    }
    
    
    public CSH009 cancelPayment(String awbPre ,String awbNo){
    	
    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
   	
      enterKeys(txt_awbPrefix, awbPre);
      enterKeys(txt_awbNo, awbNo);
      enterKeys(txt_startDate, ".");
      enterKeys(txt_endDate,  ".");
      click(btn_List);
      minWait();
      check(chk_checkAll);
     click(btn_Cancel);
     minWait();
     driver.switchTo().defaultContent();
     switchToSecondWindow();
     enterKeys(txt_PaymentAdviceEnquiry_Remarks, "Cancel Payment");
     click(btn_ReasonCode_Ok);
     
     switchToFirstWindow();
     waitForFrameAndSwitch(FRAME);
     minWait();
	return this;
     
    	
    	
    }
    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 23/2/2018.
     */
    public CSH009 Revalidate_finalize(String awbPre ,String awbNo ) {
    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
   	
      enterKeys(txt_awbPrefix, awbPre);
      enterKeys(txt_awbNo, awbNo);
      enterKeys(txt_startDate, ".");
      enterKeys(txt_endDate,  ".");
     selectByText(list_Status, "Draft");
     click(btn_List);
     minWait();
      check(chk_checkAll);
      click(btn_Revalidate);
      minWait();
      
      enterKeys(txt_remarks, "Payment Remarks");
         
      click(btn_pymnt_ok);
      click(btn_finalize);
       minWait();
      click(pymnt_btn_close);
      String value=getTableCellValue(tbl_paymentAdviceEnquiry, 5, 1);
      System.out.println(value);
       Assert.assertTrue(value.equalsIgnoreCase("Final"));
        return this;
    }
    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 23/2/2018.
     */
    public CSH009 Revalidate_Voided(String awbPre ,String awbNo ) {
    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
   	
      enterKeys(txt_awbPrefix, awbPre);
      enterKeys(txt_awbNo, awbNo);
      enterKeys(txt_startDate, ".");
      enterKeys(txt_endDate,  ".");
     selectByText(list_Status, "Draft");
     click(btn_List);
     minWait();
      check(chk_checkAll);
      click(btn_Cancel);
      minWait();
      waitForNewWindow(2);
      switchToSecondWindow();
      enterKeys(txt_PaymentAdviceEnquiry_Remarks, "Remarks");
      click(btn_ReasonCode_Ok);
      switchToFirstWindow();
      waitForFrameAndSwitch(FRAME);
      minWait();
      String value=getTableCellValue(tbl_paymentAdviceEnquiry, 5, 1);
      System.out.println(value);
       Assert.assertTrue(value.equalsIgnoreCase("Voided"));
        return this;
    }
    
    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 23/2/2018.
     */
    public CSH009 Revalidate_Canceled(String awbPre ,String awbNo ) {
    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
   	
      enterKeys(txt_awbPrefix, awbPre);
      enterKeys(txt_awbNo, awbNo);
      enterKeys(txt_startDate, ".");
      enterKeys(txt_endDate,  ".");

     click(btn_List);
     minWait();
      check(chk_checkAll);
      click(btn_Cancel);
      minWait();
      waitForNewWindow(2);
      switchToSecondWindow();
      enterKeys(txt_PaymentAdviceEnquiry_Remarks, "Remarks");
      click(btn_ReasonCode_Ok);
      switchToFirstWindow();
      waitForFrameAndSwitch(FRAME);
      minWait();
      enterKeys(txt_remarks, "Payment Remarks");
      click(btn_pymnt_ok);
      click(btn_finalize);
      minWait();
      click(pymnt_btn_close);
      minWait();
      String value=getTableCellValue(tbl_paymentAdviceEnquiry, 5, 1);
      System.out.println(value);
       Assert.assertTrue(value.equalsIgnoreCase("Voided"));
        return this;
    }
    /**
     * 

     * @param 
     * @param 
     * @return
     * @author A-6545 on 23/2/2018.
     */
    public CSH009 Revalidate_SaveAsdraft(String awbPre ,String awbNo ) {
    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
   	
      enterKeys(txt_awbPrefix, awbPre);
      enterKeys(txt_awbNo, awbNo);
      enterKeys(txt_startDate, ".");
      enterKeys(txt_endDate,  ".");
     selectByText(list_Status, "Draft");
     click(btn_List);
     minWait();
      check(chk_checkAll);
      click(btn_Revalidate);
      minWait();
      
      enterKeys(txt_remarks, "Payment Remarks");
         
      click(btn_pymnt_ok);
      click(pymnt_btn_Save);
       minWait();
      click(pymnt_btn_close);
      String value=getTableCellValue(tbl_paymentAdviceEnquiry, 5, 1);
      System.out.println(value);
       Assert.assertTrue(value.equalsIgnoreCase("Draft"));
        return this;
    }
   
      /**
     * CLose and screen and go to home page
     *
     * @return
     * @author A-6545 on 20/2/2018.
     */
    public HomePage close() {

        click(btn_Close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
    
    /*
     * A-8255
     */
    
    public CSH009 cancelPA(String serviceName)
    {
    	
    	serviceName = PropertyHandler.getPropValue(dataFilePath,serviceName);
    	
    	enterKeys(txt_servicename,serviceName);
    	click(btn_List);
    	
    	
   
    	tblSelectRowByColValue(tbl_paymentAdviceEnquiry, 1, 5, "Final");
    	click(btn_Cancel);
    	
    	switchToSecondWindow();
    	
    	enterKeys(txt_PaymentAdviceEnquiry_Remarks,"Remarks");
    	click(btn_ReasonCode_Ok);
    	
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	new WebDriverWait(driver, 60).until(ExpectedConditions.titleContains("Generate Payment Advice"));


    	String serviceDetails=waitForElementVisible(txt_servicedetails).getText();
    	
    	System.out.println(serviceDetails);
    
     	PropertyHandler.setPropValue(dataFilePath, "serviceDetails", serviceDetails);
  
    	enterKeys(txt_paymentadviceremarks,"abcd");
    	
        click(pymnt_btn_ok);
        click(btn_finalize);
        minWait();
         
    
    	Assert.assertTrue(getTableCellValue(tbl_paymentAdviceEnquiry, 5, 1).equalsIgnoreCase("Canceled"));
    	
    	return this;
    }
    /**
     * Created by A-7605
     * This method verifies the details in the Payment Advice Details table
     * @param awbPrefix
     * @param awbNo
     * @param customerCode
     * @param status
     * @param service
     * @return
     */
    public CSH009 verifyPADetails(String awbPrefix, String awbNo, String customerCode, String status, String service){
    	awbPrefix = PropertyHandler.getPropValue(dataFilePath,awbPrefix);
    	awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
    	customerCode = PropertyHandler.getPropValue(dataFilePath,customerCode);
    	status = PropertyHandler.getPropValue(dataFilePath,status);
    	service = PropertyHandler.getPropValue(dataFilePath,service);
    	
    	enterKeys(txt_awbPrefix, awbPrefix);
    	enterKeys(txt_awbNo, awbNo);
    	click(btn_List);
    	minWait();
    	Assert.assertEquals(getTableCellValue(tbl_paymentAdviceEnquiry, 5, 1), status);
    	Assert.assertEquals(getTableCellValue(tbl_paymentAdviceEnquiry, 10, 1), service);
    	Assert.assertEquals(getTableCellValue(tbl_paymentAdviceEnquiry, 11, 1), customerCode);
    	return this;
    }
    
    
    
    /**
     * A-8254
     */
   public CSH009 printList()
   {
	   click(btn_List);
   	minWait();
   // if(waitForElement(btn_List)).isEnabled())
	Assert.assertTrue(waitForElement(btn_print).isEnabled(),"print button is enabled and present");
	click(btn_print);
	waitForNewWindow(2);
	switchToSecondWindow();
    closeAndmoveToFirstWindow();
    waitForFrameAndSwitch(FRAME);
	return this;  
   }
    
    
    
    
    
    
    
    
    
    
}
