/**
 * 
 */
package com.ibsplc.pageObjects;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Created Shalini on 26/2/2019.
 */
public class LTE003 extends BasePage {
	private final static Logger logger = Logger.getLogger(LTE003.class);
	public static String objFilepath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "LTE_CSH_CLM.properties");
	public static String genObjPath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "Generic.properties");
	public static String FRAME = "iCargoContentFrameLTE001";
	public static String screenFrame= "iCargoContentFrameLTE003";
	private String dataFilePath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "testDataDirectory");
	private WebDriver driver;
	private String dataFileName;

	private By txt_FromDate,txt_ToDate,txt_FlightCarrierCode,txt_FlightNumber,txt_Prefix,
	txt_AwbNumber,button_List,button_Arrived,btn_arrive,btn_Delivery,text_Remarks,btn_PayDelivery

	;
	private By btn_genericYes, info_footer;

	public LTE003(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		this.dataFilePath = dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
		initElements();
	}

	/**
	 * Initializes all the elements
	 * 
	 * Created Shalini on 27/12/2019.
	 */
	private void initElements() {
		
		txt_FromDate = MiscUtility.getWebElement(objFilepath, "LTE003_txt_FromDate");
		txt_ToDate = MiscUtility.getWebElement(objFilepath, "LTE003_txt_ToDate");
		
		txt_FlightCarrierCode = MiscUtility.getWebElement(objFilepath, "LTE003_txt_FlightCarrierCode");
		txt_FlightNumber = MiscUtility.getWebElement(objFilepath, "LTE003_txt_FlightNumber");
		txt_Prefix = MiscUtility.getWebElement(objFilepath, "LTE003_txt_Prefix");
		txt_AwbNumber = MiscUtility.getWebElement(objFilepath, "LTE003_txt_AwbNumber");
		
		button_List = MiscUtility.getWebElement(objFilepath, "LTE003_button_List");
		button_Arrived = MiscUtility.getWebElement(objFilepath, "LTE003_button_Arrived");
		btn_arrive = MiscUtility.getWebElement(objFilepath, "LTE003_btn_arrive");
		btn_Delivery = MiscUtility.getWebElement(objFilepath, "LTE003_btn_Delivery");
		text_Remarks = MiscUtility.getWebElement(objFilepath, "LTE003_text_Remarks");
		btn_PayDelivery = MiscUtility.getWebElement(objFilepath, "LTE003_btn_PayDelivery");
	}

	
	

	/**
	 * CLose and screen and go to home page
	 * 
	 * @return Created A-6545 on 16/2/2018.
	 */
	public HomePage close() {

		click(By.xpath("//*[@name='btnClose']"));
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {

			click(btn_genericYes);
		}
		return new HomePage(driver, dataFileName);
	}
	
	/**
	 * Created by Shalini
	 * 
	 * @param carriercode
	 * @param fltNo etc, To list the flight and do the Breakdown and Delivery
	 * @return
	 */

	public LTE003 ProcessDelivery(String carriercode,String prefix, String awbno,
			String fltNo, String fltDt) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt=PropertyHandler.getPropValue(dataFilePath, fltDt);
		enterKeys(txt_FromDate, fltDt+Keys.TAB);
		enterKeys(txt_ToDate, fltDt+Keys.TAB);
		enterKeys(By.xpath("//input[@name='shipmentPrefix']"), "001");
		enterKeys(By.xpath("//input[@name='documentNumber']"), awbno);
		click(button_List);
		InitialSetup.test.log(LogStatus.PASS,
				"Successfully entertered Prefix and AWB No:" + prefix
						+ "-" + awbno);
		maxWait();
		click(By.xpath("(//a[@class='inputbox cmpedittog '])[1]"));
		click(By.xpath("(//button[@class='btn btn-default m-0'])[1]"));
		minWait();
		String PaymentMode=PropertyHandler.getPropValue(dataFilePath, "PaymentMode");
		click(By.xpath("//button[@name='btndelivery']"));
		driver.switchTo().frame("popupContainerFrame");
		maxWait();
		maxWait();
		enterKeys(By.xpath("//textarea[@name='remarks']"), "Testing");
		/*selectByText(By.xpath("//select[@name='paymentMode']"),"CHECK");
		click(By.xpath("//button[@name='btnPayDeliver']"));
		driver.switchTo().defaultContent();
		
		if(verifyElementPresent(By.xpath("//button[@class='ui-button ui-corner-all ui-widget'][contains(text(),'OK')]")))
			click(By.xpath("//button[@class='ui-button ui-corner-all ui-widget'][contains(text(),'OK')]"));
		
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE003");
		driver.switchTo().frame("popupContainerFrame");
		minWait();
		click(By.xpath("//button[@name='btnPopClose']"));
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE003");
		InitialSetup.test.log(LogStatus.PASS,"Successfully Delivered the shipment with AWB No:" + prefix+ "-" + awbno);
		return this;*/
		try{
			if(PaymentMode.equals("CHECK")){
				selectByText(By.xpath("//select[@name='paymentMode']"), PaymentMode);
			enterKeys(text_Remarks, "Check payment");
			}}catch(Exception e){
			}
			//selectByText(sel_paymentMode, PaymentMode);    //CCARD,CASH,CHEQUE,CREDIT,GBL 
			click(btn_PayDelivery);
			captureAndAddScreenshot();
			//CreditCard in Another Window
			try{
			if(!PaymentMode.equals(null) && PaymentMode.equalsIgnoreCase("CCARD"))
					{
						//login Details
						maxWait();
						/*maxWait();
						switchToSecondWindow();
						maxWait();
						maxWait();
						*//**codes of second window
						 * 
						 * 			
						 *//*
						click(By.xpath("//a[text()='Enter Manually']"));
						maxWait();
						maxWait();
						enterKeys(By.xpath("//input[@name='creditCardNo1']"), "4443");
						enterKeys(By.xpath("//input[@name='creditCardNo2']"), "9457");
						enterKeys(By.xpath("//input[@name='creditCardNo3']"), "5863");
						enterKeys(By.xpath("//input[@name='creditCardNo4']"), "6719");
						selectByText(By.xpath("//select[@name='expMonth']"), "01");
						selectByText(By.xpath("//select[@name='expYear']"), "22");
						enterKeys(By.xpath("//input[@name='cidNumber']"), "278");
						enterKeys(By.xpath("//input[@name='zipNumber']"), "75063");
						click(By.xpath("//input[@name='manualSubmitButton']"));
						maxWait();
						captureAndAddScreenshot();
						switchBackToFirstWindow();*/
					}
			}catch(Exception e){
				InitialSetup.test.log(LogStatus.FAIL, "Payment failed at delivery due top : "+e);
			}
		/*	driver.switchTo().defaultContent();
			if(verifyElementPresent(By.xpath("//*[contains(text(),'OK')]")))
			{
				click(By.xpath("//*[contains(text(),'OK')]"));
			}
			maxWait();
//			switchToSecondWindow();
//			driver.close();
//			switchToFirstWindow();
			waitForFrameAndSwitch("iCargoContentFrameLTE003");
			minWait();
			String status =  driver.findElement(By.xpath("//div[@name='flipArrivalDelDivTrigger']//span")).getText().trim();
			if(status.equalsIgnoreCase("Delivered")){
				InitialSetup.test.log(LogStatus.PASS, "Successfully delivered");
			}else{
				InitialSetup.test.log(LogStatus.FAIL, "Delivery is failed");
			}
			waitForFrameAndSwitch("popupContainerFrame");
			click(By.xpath("//button[@name='btnPopClose']"));
			minWait();
			waitForFrameAndSwitch("iCargoContentFrameLTE003");
			InitialSetup.test.log(LogStatus.PASS, "Successfully delivered the shipment");
			captureAndAddScreenshot();
			return this;*/
		       driver.switchTo().defaultContent();
	              if(verifyElementPresent(By.xpath("//*[contains(text(),'OK')]")))
	              {
	                     click(By.xpath("//*[contains(text(),'OK')]"));
	              }
	              driver.switchTo().frame("iCargoContentFrameLTE003");
	              minWait();
	              driver.switchTo().frame("popupContainerFrame");
	              click(By.xpath("//button[@name='btnPopClose']"));
	              minWait();
	              driver.switchTo().frame("iCargoContentFrameLTE003");
	              InitialSetup.test.log(LogStatus.PASS, "Successfully delivered the shipment");
	              captureAndAddScreenshot();
	              return this;
		}

	
	
	/**
	 * Created by Souvik (A-8457)
	 * 10-04-2019
	 * @param carriercode
	 * @param fltNo etc, to do Arrival of flight and group delivery of the awbs
	 * @return
	 */

	public LTE003 FlightArrivalAndGroupDelivery(String carriercode,String prefix, String awbno,
			String fltNo, String fltDt) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt=PropertyHandler.getPropValue(dataFilePath, fltDt);
		enterKeys(txt_FromDate, fltDt+Keys.TAB);
		enterKeys(txt_ToDate, fltDt+Keys.TAB);
		enterKeys(txt_FlightCarrierCode, carriercode);
		enterKeys(txt_FlightNumber, fltNo);
		click(button_List);
		InitialSetup.test.log(LogStatus.PASS,"Successfully Listed the Flight in LTE003 screen");
		maxWait();
		click(By.xpath("(//a[@class='inputbox cmpedittog '])[1]"));
		minWait();
		click(By.xpath("(//button[@class='btn btn-default m-0'])[1]"));
		click(By.xpath("(//a[@class='inputbox cmpedittog '])[2]"));
		minWait();
		click(By.xpath("(//button[@class='btn btn-default m-0'])[2]"));
		InitialSetup.test.log(LogStatus.PASS,"Successfully Marked the arrival of the flight with stated number of pieces and weight");
		maxWait();
		check(By.xpath("//input[@class='form-check-input align-middle mt-0']"));
		check(By.xpath("(//input[@class='checkboxType_true'])[1]"));
		check(By.xpath("(//input[@class='checkboxType_true'])[2]"));
		click(By.xpath("//button[@name='btnGroupdeliver']"));
		maxWait();
		waitForFrameAndSwitch("popupContainerFrame"); 
		selectByText(By.xpath("//select[@name='paymentMode']"),"CHECK");
		enterKeys(By.xpath("//textarea[@name='remarks']"),"Group delivery through check");
		click(By.xpath("//button[@name='btnPayDeliver']"));
		driver.switchTo().defaultContent();
		waitForFrameAndSwitch(screenFrame); // to check
		// blocker, after this code has to be written
		return this;
   }
	
	/**
	 * Created by Souvik (A-8457)
	 * 24-04-2019
	 * @param carriercode
	 * @param fltNo etc, to do Arrival of flight and for breakdown
	 * @return
	 */

	public LTE003 FlightArrivalAndBreakdownWithDiscrepancy(String carriercode,String prefix, String awbno,
			String fltNo, String fltDt,String arrpcs1,String arrwt1,String arrpcs2,String arrwt2) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt=PropertyHandler.getPropValue(dataFilePath, fltDt);
		arrpcs1=PropertyHandler.getPropValue(dataFilePath, arrpcs1);
		arrwt1=PropertyHandler.getPropValue(dataFilePath, arrwt1);
		arrpcs2=PropertyHandler.getPropValue(dataFilePath, arrpcs2);
		arrwt2=PropertyHandler.getPropValue(dataFilePath, arrwt2);
		
		enterKeys(txt_FromDate, fltDt+Keys.TAB);
		enterKeys(txt_ToDate, fltDt+Keys.TAB);
		enterKeys(txt_FlightCarrierCode, carriercode);
		enterKeys(txt_FlightNumber, fltNo);
		click(button_List);
		InitialSetup.test.log(LogStatus.PASS,"Successfully Listed the Flight in LTE003 screen");
		maxWait();
		click(By.xpath("(//a[@class='inputbox cmpedittog '])[1]"));
		minWait();
		enterKeys(By.xpath("(//input)[39]"), arrpcs1);
		enterKeys(By.xpath("(//input)[40]"), arrwt1);
		click(By.xpath("(//button[@class='btn btn-default m-0'])[1]"));
		maxWait();
		
		click(By.xpath("(//a[@class='inputbox cmpedittog '])[2]"));
		minWait();
		enterKeys(By.xpath("(//input)[43]"), arrpcs2);
		enterKeys(By.xpath("(//input)[44]"), arrwt2);
		click(By.xpath("(//button[@class='btn btn-default m-0'])[2]"));
		InitialSetup.test.log(LogStatus.PASS,"Successfully Marked the arrival of the flight with stated number of pieces and weight");
		maxWait();
	
		return this;
}
	
	
	/**
	 * @author A-8452 Faizan
	 * @param carriercode
	 * @param prefix
	 * @param awbno
	 * @param fltNo
	 * @param fltDt
	 * @return
	 */
	public LTE003 ImportFlight(String carriercode,String prefix, String awbno,
			String fltNo, String fltDt) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt=PropertyHandler.getPropValue(dataFilePath, fltDt);
		enterKeys(txt_FromDate, fltDt+Keys.TAB);
		enterKeys(txt_ToDate, fltDt+Keys.TAB);
		enterKeys(txt_Prefix, prefix);
		enterKeys(txt_AwbNumber, awbno);
		click(button_List);
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entertered Prefix and AWB No:" + prefix
						+ "-" + awbno);
		maxWait();
		
		click(button_Arrived);
		click(btn_arrive);
		maxWait();
		InitialSetup.test.log(LogStatus.PASS,
				"Flight successfully arrived at Destination");
		captureAndAddScreenshot();
		return this;
}
	
	
	public LTE003 ImportFlightTestData(String carriercode,String prefix, String awbno,
			String fltNo, String fltDt) {
		minWait();
		enterKeys(txt_FromDate, fltDt+Keys.TAB);
		enterKeys(txt_ToDate, fltDt+Keys.TAB);
		enterKeys(txt_Prefix, prefix);
		enterKeys(txt_AwbNumber, awbno);
		click(button_List);
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entertered Prefix and AWB No:" + prefix
						+ "-" + awbno);
		maxWait();
		
		click(button_Arrived);
		click(btn_arrive);
		maxWait();
		InitialSetup.test.log(LogStatus.PASS,
				"Flight successfully arrived at Destination");
		captureAndAddScreenshot();
		return this;
}
	
	
	/**
	 * @author A-8452 Faizan
	 * @param needListing
	 * @param prefix
	 * @param awbno
	 * @param fltDt
	 * @param PaymentMode
	 * @return
	 */
	public LTE003 Delivery(boolean needListing,String prefix, String awbno,
			String fltDt, String PaymentMode)
	{
		minWait();
		if(needListing==true)
		{
			prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
			awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
			fltDt=PropertyHandler.getPropValue(dataFilePath, fltDt);
			
			enterKeys(txt_FromDate, fltDt+Keys.TAB);
			enterKeys(txt_ToDate, fltDt+Keys.TAB);
			enterKeys(txt_Prefix, prefix);
			enterKeys(txt_AwbNumber, awbno);
			click(button_List);
			maxWait();
		}
		PaymentMode=PropertyHandler.getPropValue(dataFilePath, PaymentMode);
		click(btn_Delivery);
		maxWait();
		waitForFrameAndSwitch("popupContainerFrame");
		maxWait();
		enterKeys(text_Remarks, "Testing");
		enterKeys(By.name("pickUpPerson"),"test person");
		enterKeys(By.name("companyName"), "test company");
		selectByText(By.name("customerIDType"), "Driving License");
		enterKeys(By.name("customerIDDetailsInfo"), "12345");
		enterKeys(By.name("customerIdIssuingState"), "US");
		selectByText(By.name("customerPhotoIdVerified"), "Yes");
		try{
		if(PaymentMode.equals("CHECK")){
			selectByText(By.xpath("//select[@name='paymentMode']"), PaymentMode);
		enterKeys(text_Remarks, "Check payment");
		}}catch(Exception e){
		}
		click(btn_PayDelivery);
		minWait();
		captureAndAddScreenshot();
		handleAlert("Dismiss", "LTE003");
		waitForFrameAndSwitch(screenFrame);
		 driver.switchTo().defaultContent();
         if(verifyElementPresent(By.xpath("//*[contains(text(),'OK')]")))
         {
                click(By.xpath("//*[contains(text(),'OK')]"));
         }
         driver.switchTo().frame("iCargoContentFrameLTE003");
         minWait();
         driver.switchTo().frame("popupContainerFrame");
         click(By.xpath("//button[@name='btnPopClose']"));
         maxWait();
         driver.switchTo().defaultContent();
         driver.switchTo().frame("iCargoContentFrameLTE003");
         try{
         String status = getText_JS(By.xpath("//div[@class='deliverd-area']//*[contains(text(),'Delivered')]")).trim();
          if(status.contains("Delivered")){
             InitialSetup.test.log(LogStatus.PASS, "Successfully delivered the shipment with status"+status);
            }
            else{
            	 InitialSetup.test.log(LogStatus.FAIL, "Delivery failed with status: "+status);
            }
         }catch(Exception e){
        	 InitialSetup.test.log(LogStatus.FAIL,"Status isn't fetched");
         }
        
         captureAndAddScreenshot();
		return this;
	}
	
	public LTE003 DeliveryTestData(boolean needListing,String prefix, String awbno,
			String fltDt, String PaymentMode)
	{
		minWait();
		if(needListing==true)
		{
			prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
			awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
			fltDt=PropertyHandler.getPropValue(dataFilePath, fltDt);
			
			enterKeys(txt_FromDate, fltDt+Keys.TAB);
			enterKeys(txt_ToDate, fltDt+Keys.TAB);
			enterKeys(txt_Prefix, prefix);
			enterKeys(txt_AwbNumber, awbno);
			click(button_List);
			maxWait();
		}
		PaymentMode=PropertyHandler.getPropValue(dataFilePath, PaymentMode);
//		PaymentMode="CASH";
		click(btn_Delivery);
		maxWait();
		waitForFrameAndSwitch("popupContainerFrame");
		maxWait();
		enterKeys(text_Remarks, "Testing");
		enterKeys(By.name("pickUpPerson"),"test person");
		enterKeys(By.name("companyName"), "test company");
		selectByText(By.name("customerIDType"), "Driving License");
		enterKeys(By.name("customerIDDetailsInfo"), "12345");
		enterKeys(By.name("customerIdIssuingState"), "US");
		selectByText(By.name("customerPhotoIdVerified"), "Yes");
		selectByText(By.xpath("//select[@name='paymentMode']"), "CHECK");
		enterKeys(text_Remarks, "Check payment");
		/*try{
		if(PaymentMode.equals("CHECK")){
			selectByText(By.xpath("//select[@name='paymentMode']"), PaymentMode);
		enterKeys(text_Remarks, "Check payment");
		}}catch(Exception e){
		}*/
		//selectByText(sel_paymentMode, PaymentMode);    //CCARD,CASH,CHEQUE,CREDIT,GBL 
		click(btn_PayDelivery);
		minWait();
		captureAndAddScreenshot();
		handleAlert("Dismiss", "LTE003");
		waitForFrameAndSwitch(screenFrame);
		//CreditCard in Another Window
		/*try{
		
		if(!PaymentMode.equals(null) && PaymentMode.equalsIgnoreCase("CCARD"))
				{
					//login Details
					
					maxWait();
					maxWait();
					switchToSecondWindow();
					maxWait();
					maxWait();
					click(By.xpath("//a[text()='Enter Manually']"));
					maxWait();
					maxWait();
					enterKeys(By.xpath("//input[@name='creditCardNo1']"), "4443");
					enterKeys(By.xpath("//input[@name='creditCardNo2']"), "9457");
					enterKeys(By.xpath("//input[@name='creditCardNo3']"), "5863");
					enterKeys(By.xpath("//input[@name='creditCardNo4']"), "6719");
					selectByText(By.xpath("//select[@name='expMonth']"), "01");
					selectByText(By.xpath("//select[@name='expYear']"), "22");
					enterKeys(By.xpath("//input[@name='cidNumber']"), "278");
					enterKeys(By.xpath("//input[@name='zipNumber']"), "75063");
					click(By.xpath("//input[@name='manualSubmitButton']"));
					maxWait();
					captureAndAddScreenshot();
					switchBackToFirstWindow();
				}
		
		
		}catch(Exception e){
//			InitialSetup.test.log(LogStatus.INFO, "Payment failed at delivery due top : "+e);
		}*/
/*//		driver.switchTo().defaultContent();
		if(verifyElementPresent(By.xpath("//*[contains(text(),'No')]")))
		{
			click(By.xpath("//*[contains(text(),'No')]"));
			
		}
		click(By.name("btnPopClose"));
		maxWait();
//		switchToSecondWindow();
//		driver.close();
//		switchToFirstWindow();
		driver.switchTo().defaultContent();
		waitForFrameAndSwitch("iCargoContentFrameLTE003");
		minWait();
		String status =  driver.findElement(By.xpath("//div[@name='flipArrivalDelDivTrigger']//span")).getText().trim();
		if(status.equalsIgnoreCase("Delivered")){
			InitialSetup.test.log(LogStatus.PASS, "Successfully delivered");
		}else{
			InitialSetup.test.log(LogStatus.FAIL, "Delivery is failed");
		}
		waitForFrameAndSwitch("popupContainerFrame");
		click(By.xpath("//button[@name='btnPopClose']"));
		minWait();
//		waitForFrameAndSwitch("iCargoContentFrameLTE003");
		InitialSetup.test.log(LogStatus.PASS, "Successfully delivered the shipment");
		captureAndAddScreenshot();*/
		 driver.switchTo().defaultContent();
         if(verifyElementPresent(By.xpath("//*[contains(text(),'OK')]")))
         {
                click(By.xpath("//*[contains(text(),'OK')]"));
         }
         driver.switchTo().frame("iCargoContentFrameLTE003");
         minWait();
         driver.switchTo().frame("popupContainerFrame");
         click(By.xpath("//button[@name='btnPopClose']"));
         minWait();
         driver.switchTo().defaultContent();
         driver.switchTo().frame("iCargoContentFrameLTE003");
         String status = getText_JS(By.xpath("(//div[@class='deliverd-area']/span//span)[1]"));
        if(status.contains("Delivered")){
         InitialSetup.test.log(LogStatus.PASS, "Successfully delivered the shipment");
        }
        else{
        	 InitialSetup.test.log(LogStatus.FAIL, "Delivery failed");
        }
         captureAndAddScreenshot();
		return this;
	}
	
	
//	Sharath
	public LTE003 flightArrival(String carriercode,String prefix, String awbno,
			String fltNo, String fltDt) {
		maxWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt=PropertyHandler.getPropValue(dataFilePath, fltDt);
		enterKeys(txt_FromDate, fltDt+Keys.TAB);
		enterKeys(txt_ToDate, fltDt+Keys.TAB);
		enterKeys(txt_FlightCarrierCode, carriercode);
		enterKeys(txt_FlightNumber, fltNo);
		click(button_List);
		InitialSetup.test.log(LogStatus.INFO,"Successfully Listed the Flight in LTE003 screen");
		maxWait();
		try{
		click(By.xpath("//span[contains(text(),'Arrived')]/.."));
		minWait();
		click(By.xpath("//button[text()='Arrive']"));
		maxWait();
		maxWait();
		maxWait();
		WebElement arrStatus = driver.findElement(By.xpath("//div[@name='flipArrivalDelDivTrigger']//span[contains(text(),'Arrive')]"));
		waitForElementVisible(By.xpath("//div[@name='flipArrivalDelDivTrigger']//span[contains(text(),'Arrive')]"));
		String arrivalStatus = arrStatus.getText();
		if(arrivalStatus.equalsIgnoreCase("Arrived")){
			InitialSetup.test.log(LogStatus.PASS,"Successfully Marked the arrival of the flight with stated number of pieces and weight");
			captureAndAddScreenshot();
		}else{
			InitialSetup.test.log(LogStatus.FAIL,"Didn't mark the arrival of the flight with stated number of pieces and weight");	
			captureAndAddScreenshot();
		}
		}
		catch(Exception e){
			InitialSetup.test.log(LogStatus.FAIL,"Flight arrival failed due to : "+e);
			Assert.fail("Flight arrival failed due to : "+e);
		}
		return this;
   }
	
	/**
	 * Description... Handles an alert with options getText/Accept/Dismiss/Close
	 * 
	 * @param alertOps
	 * @param ScreenName
	 */
	public void handleAlert(String alertOps, String ScreenName) {
		driver.switchTo().defaultContent();
		String AlertText = "";

		try {
			AlertText = driver
					.findElement(By.xpath("//div[@role='dialog']//p"))
					.getText();
			switch (alertOps.valueOf(alertOps)) {
			case "getText":
				InitialSetup.test.log(LogStatus.PASS, "Accepted Alert text "
						+ AlertText + ScreenName);
				break;

			case "Accept":
				driver.findElement(
						By.xpath("//div[@class='ui-dialog-buttonset']//button[1]"))
						.click();
				InitialSetup.test.log(LogStatus.PASS, "Accepted Alert with text "
						+ ScreenName);

				break;
			case "Dismiss":
				driver.findElement(
						By.xpath("//div[@class='ui-dialog-buttonset']//button[2]"))
						.click();
				InitialSetup.test.log(LogStatus.PASS, "Clicked on Dismiss button"
						+ ScreenName);
				break;
			case "Close":
				driver.findElement(
						By.xpath("(//button[@title='Close'])[2]|//button[@name='btClose']"))
						.click();
				InitialSetup.test.log(LogStatus.PASS, "Clicked on Close button "
						+ ScreenName);
				break;
			}

		} catch (Exception e) {
			InitialSetup.test.log(LogStatus.INFO, "Not able to handle Alert "
					+ ScreenName);

		}
	}

	/**
	 * @author A-8452 Faizan
	 * @param carriercode
	 * @param prefix
	 * @param awbno
	 * @param fltNo
	 * @param fltDt
	 * @return
	 */
	public LTE003 ImportFlight2ULDs(String carriercode,String prefix, String awbno,
			String fltNo, String fltDt) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt=PropertyHandler.getPropValue(dataFilePath, fltDt);
		enterKeys(txt_FromDate, fltDt+Keys.TAB);
		enterKeys(txt_ToDate, fltDt+Keys.TAB);
		enterKeys(txt_Prefix, prefix);
		enterKeys(txt_AwbNumber, awbno);
		click(button_List);
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entertered Prefix and AWB No:" + prefix
						+ "-" + awbno);
		maxWait();
		click(By.xpath("//span[contains(text(),'Arrived')]"));
		click(getWebElements(By.xpath("//td//button[contains(text(),'Arrive')]")).get(0));
		maxWait();
		click(By.xpath("//span[contains(text(),'Arrived')]"));
		click(getWebElements(By.xpath("//td//button[contains(text(),'Arrive')]")).get(1));
		maxWait();
		InitialSetup.test.log(LogStatus.PASS,
				"Flight successfully arrived at Destination");
		captureAndAddScreenshot();
		return this;
}
	
}
