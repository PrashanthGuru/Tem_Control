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
public class CMT008 extends BasePage {

	public static String FRAME = "iCargoContentFrameCMT008";
	public static String screenFrame = "iCargoContentFrameCMT008";
	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
	private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	WebDriver driver;
	String dataFileName;
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");


	By

	yesBtn,
	noBtn,
	msg_popup,
	btn_genericOk,
	info_genericMsg;
	By
	txt_agentCode,
	btn_list,
	btn_tabBillingdetails,
	chkbox_OWNsales,
	txt_SEETLCURRENCY,
	btn_clear,
	btn_save,
	txt_controllingLocation_customerCode,
	chkbx_controllingInvoiceClubbingfalg,
	dropDown_controllingBillTo,
	dropdown_FOP,
	chkbox_creditFOP,
	btn_addclearingAgent,
	txt_clearingAgentStation,
	txt_clearagentCode,
	btn_tabAgent,
	chkbx_selctClearingagent,
	btn_deleteClearingAgnt,
	chkbx_invoiceClubbingIndicator,
	txt_airlineCodeOfCCCollcr,chkbox_controllingLocation,
	chkbx_billThrough,txt_billingCode,
	btn_close,
	tab_customerDetails,
	dropdown_defaultNofiyValue,
	btn_addCustomer,
	table_customerDetails,
	txt_fistName,
	txt_lastName,
	dropdown_type;

private By chk_globalCust,	

dropdown_restrictedFoPs,
	checkbox_restrictedFoPs_credit;

	public CMT008(WebDriver driver, String dataFileName) {
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

		txt_agentCode          =MiscUtility.getWebElement(objFilepath, "CMT008_txt_agentCode");
		btn_list               =MiscUtility.getWebElement(objFilepath, "CMT008_btn_list");
		btn_tabBillingdetails  =MiscUtility.getWebElement(objFilepath, "CMT008_btn_tabBillingdetails");
		chkbox_OWNsales        =MiscUtility.getWebElement(objFilepath, "CMT008_chkbox_OWNsales");
		btn_clear              =MiscUtility.getWebElement(objFilepath, "CMT008_btn_clear");
		btn_save               =MiscUtility.getWebElement(objFilepath, "CMT008_btn_save");
		btn_close              =MiscUtility.getWebElement(objFilepath, "CMT008_btn_close");
		txt_SEETLCURRENCY         =MiscUtility.getWebElement(objFilepath, "CMT008_txt_SEETLCURRENCY");
		txt_billingCode  =MiscUtility.getWebElement(objFilepath, "CMT008_txt_billingCode");
		btn_addclearingAgent      =MiscUtility.getWebElement(objFilepath, "CMT008_btn_addclearingAgent");
		txt_clearingAgentStation  =MiscUtility.getWebElement(objFilepath, "CMT008_txt_clearingAgentStation");
		txt_clearagentCode        =MiscUtility.getWebElement(objFilepath, "CMT008_txt_clearagentCode");
		chkbox_controllingLocation=MiscUtility.getWebElement(objFilepath, "CMT008_chkbox_controllingLocation");

		yesBtn          = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		noBtn           = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		msg_popup       = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		btn_genericOk   = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		info_genericMsg                     = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		txt_controllingLocation_customerCode= MiscUtility.getWebElement(objFilepath, "CMT008_txt_controllingLocation_customerCode");
		chkbx_controllingInvoiceClubbingfalg= MiscUtility.getWebElement(objFilepath, "CMT008_chkbx_controllingInvoiceClubbingfalg");
		dropDown_controllingBillTo          = MiscUtility.getWebElement(objFilepath, "CMT008_dropDown_controllingBillTo");
		dropdown_FOP                        = MiscUtility.getWebElement(objFilepath, "CMT008_dropdown_FOP");
		btn_tabAgent                        = MiscUtility.getWebElement(objFilepath, "CMT008_btn_tabAgent");
		chkbx_selctClearingagent            = MiscUtility.getWebElement(objFilepath, "CMT008_chkbx_selctClearingagent");
		btn_deleteClearingAgnt              =MiscUtility.getWebElement(objFilepath, "CMT008_btn_deleteClearingAgnt");
		txt_airlineCodeOfCCCollcr=MiscUtility.getWebElement(objFilepath, "CMT008_txt_airlineCodeOfCCCollcr");

		chkbx_billThrough=MiscUtility.getWebElement(objFilepath, "CMT008_chkbx_billThrough");
		tab_customerDetails = MiscUtility.getWebElement(objFilepath, "CMT008_tab_customerDetails");
		dropdown_defaultNofiyValue = MiscUtility.getWebElement(objFilepath, "CMT008_dropdown_defaultNofiyValue");
		btn_addCustomer = MiscUtility.getWebElement(objFilepath, "CMT008_btn_addCustomer");
		table_customerDetails = MiscUtility.getWebElement(objFilepath, "CMT008_table_customerDetails");
		txt_fistName = MiscUtility.getWebElement(objFilepath, "CMT008_txt_fistName");
		txt_lastName = MiscUtility.getWebElement(objFilepath, "CMT008_txt_lastName");
		dropdown_type = MiscUtility.getWebElement(objFilepath, "CMT008_dropdown_type");
		
		
		
		chk_globalCust=MiscUtility.getWebElement(objFilepath, "CMT008_global_cust_chk");
		 dropdown_restrictedFoPs      =MiscUtility.getWebElement(objFilepath, "CMT008_dropdown_restrictedFoPs");    
	        checkbox_restrictedFoPs_credit      =MiscUtility.getWebElement(objFilepath, "CMT008_checkbox_restrictedFoPs_credit");
	}


	/**
	 * For adding clearing agent to customer
	 * @param agentCode
	 * @param agent2
	 * @param station
	 * @return
	 *A-6784**/
	public CMT008 setClearingAgent(String agentCode,String agent2,String station){


		agentCode=PropertyHandler.getPropValue(dataFilePath, agentCode);
		agent2=PropertyHandler.getPropValue(dataFilePath, agent2);
		station=PropertyHandler.getPropValue(dataFilePath, station);


		enterKeys(txt_agentCode, agentCode);
		click(btn_list);
		minWait();
		click(btn_tabAgent);
		click(btn_addclearingAgent);
		enterKeys(txt_clearingAgentStation, station);
		enterKeys(txt_clearagentCode, agent2);


		click(btn_save);
		maxWait();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		minWait();

		return this;





	}
	public CMT008 set_BillingCurr(String agentCode,String Prorationcurr){
		
		agentCode=PropertyHandler.getPropValue(dataFilePath,agentCode);
		Prorationcurr=PropertyHandler.getPropValue(dataFilePath,Prorationcurr);
		enterKeys(txt_agentCode,agentCode);
		click(btn_list);
		minWait();
		click(btn_tabBillingdetails);
		enterKeys(txt_billingCode, Prorationcurr);
		
		click(btn_save);
		maxWait();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		minWait();

		return this;





	}

	public CMT008 setBillthroughChk(String ccCollectr,String airlineCode){

		ccCollectr=PropertyHandler.getPropValue(dataFilePath, ccCollectr);
		airlineCode=PropertyHandler.getPropValue(dataFilePath, airlineCode);

		enterKeys(txt_agentCode, ccCollectr);
		click(btn_list);
		minWait();

		click(btn_tabBillingdetails);

		enterKeys(txt_airlineCodeOfCCCollcr, airlineCode);
		check(chkbx_billThrough);



		click(btn_save);
		maxWait();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		minWait();

		return this;


	}



	/***
	 * 
	 * @param agentcode
	 * @return
	 */
	public CMT008 deleteClearingAgent(String agentcode){

		agentcode=PropertyHandler.getPropValue(dataFilePath, agentcode);
		enterKeys(txt_agentCode, agentcode);
		click(btn_list);
		minWait();
		click(btn_tabAgent);
		check(chkbx_selctClearingagent);


		click(btn_deleteClearingAgnt);

		click(btn_save);
		maxWait();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		minWait();

		return this;
	}
	/**
	 * Enable/Disable OWN sales checkflag
	 * @param agentcode
	 * @param isEnable
	 * @return
	 */
	public CMT008 setOWNSales(String agentcode,boolean isEnable){

		agentcode=PropertyHandler.getPropValue(dataFilePath, agentcode);

		enterKeys(txt_agentCode, agentcode);
		click(btn_list);
		minWait();

		click(btn_tabBillingdetails);
		if(isEnable){
			check(chkbox_OWNsales);
		}
		else
			unCheck(chkbox_OWNsales);

		click(btn_save);
		maxWait();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		minWait();

		return this;

	}


	/**
	 * billto:Controlling Location/Selling Location
	 * @param agentcode1
	 * @param agentcode2
	 * @param billto
	 * @return
	 */
	public CMT008 setControllingLocationBillTo(String agentcode1, String agentcode2,String billto){

		agentcode1=PropertyHandler.getPropValue(dataFilePath, agentcode1);
		agentcode2=PropertyHandler.getPropValue(dataFilePath, agentcode2);

		enterKeys(txt_agentCode, agentcode1);
		click(btn_list);
		minWait();
		click(btn_tabBillingdetails);
		enterKeys(txt_controllingLocation_customerCode, agentcode2);


		selectByValue(dropDown_controllingBillTo, billto);
		click(btn_save);

		maxWait();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		minWait();

		return this;
	}
	/***
	 * 
	 * @param agentcode1
	 * @param agentcode2
	 * @param IsClubbingFlag
	 * @return
	 */
	public CMT008 setControllingLocation(String agentcode1, String agentcode2,boolean IsClubbingFlag){

		agentcode1=PropertyHandler.getPropValue(dataFilePath, agentcode1);
		agentcode2=PropertyHandler.getPropValue(dataFilePath, agentcode2);

		enterKeys(txt_agentCode, agentcode1);
		click(btn_list);
		minWait();
		click(btn_tabBillingdetails);
		enterKeys(txt_controllingLocation_customerCode, agentcode2);

		if(IsClubbingFlag){
			check(chkbx_controllingInvoiceClubbingfalg);
		}
		else
			unCheck(chkbx_controllingInvoiceClubbingfalg);
		click(btn_save);

		maxWait();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		minWait();

		return this;
	}
	public CMT008 setControllingLocationCheckCtrlLoc(String Cntrl_Agent,String agentcode2){

		Cntrl_Agent=PropertyHandler.getPropValue(dataFilePath, Cntrl_Agent);

		agentcode2=PropertyHandler.getPropValue(dataFilePath, agentcode2);
		enterKeys(txt_agentCode, Cntrl_Agent);
		click(btn_list);
		minWait();
		click(btn_tabBillingdetails);
		System.out.println(waitForElement(chkbox_controllingLocation).getAttribute("checked"));
		//String attVal=waitForElement(chkbox_controllingLocation).getAttribute("checked");
		if(waitForElement(chkbox_controllingLocation).getAttribute("checked")==null)
		{
			check(chkbox_controllingLocation);
		}
		enterKeys(txt_controllingLocation_customerCode, agentcode2);
		selectByText(dropDown_controllingBillTo, "Controlling Location");
		click(btn_save);

		maxWait();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		minWait();

		return this;
	}

	public CMT008 ResetControllingLoc(String Cntrl_Agent){

		Cntrl_Agent=PropertyHandler.getPropValue(dataFilePath, Cntrl_Agent);


		enterKeys(txt_agentCode, Cntrl_Agent);
		click(btn_list);
		minWait();
		click(btn_tabBillingdetails);
		System.out.println(waitForElement(chkbox_controllingLocation).getAttribute("checked"));
		//String attVal=waitForElement(chkbox_controllingLocation).getAttribute("checked");
		unCheck(chkbox_controllingLocation);

		enterKeys(txt_controllingLocation_customerCode, "");

		selectByIndex(dropDown_controllingBillTo, 0);
		click(btn_save);

		maxWait();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		minWait();

		return this;
	}

	public CMT008 updateFOP(String agentcode,String FOPType){

		agentcode=PropertyHandler.getPropValue(dataFilePath, agentcode);

		enterKeys(txt_agentCode, agentcode);
		click(btn_list);
		minWait();

		if(FOPType.equals("CREDIT")){

			check(chkbox_creditFOP);
		}

		click(btn_save);
		return this;


	}

	public CMT008 uncheckUpdateFOP(String agentcode,String FOPType){

		agentcode=PropertyHandler.getPropValue(dataFilePath, agentcode);

		enterKeys(txt_agentCode, agentcode);
		click(btn_list);
		minWait();

		if(FOPType.equals("CREDIT")){

			unCheck(chkbox_creditFOP);
		}

		click(btn_save);
		return this;


	}
	/***
	 * 
	 * @param agentcode
	 * @param currency
	 * @return
	 */
	public CMT008 Currency_change(String agentcode,String currency) {

		agentcode=PropertyHandler.getPropValue(dataFilePath, agentcode);

		enterKeys(txt_agentCode, agentcode);
		click(btn_list);
		minWait();
		click(btn_tabBillingdetails);
		enterKeys(txt_SEETLCURRENCY, currency);

		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		minWait();
		return new CMT008(driver, dataFileName);

	}
	/***
	 * 
	 * @param agentcode
	 * @return
	 */
	public CMT008 uncheckInvoiceClubbing(String agentcode){

		click(btn_clear);
		minWait();
		enterKeys(txt_agentCode, agentcode);
		click(btn_list);
		minWait();
		click(btn_tabBillingdetails);
		unCheck(chkbx_invoiceClubbingIndicator);
		return this;


	}
	public HomePage close() {

		click(btn_close);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		return new HomePage(driver, dataFileName);
	}
	/**
	 * Created by A-7605 on 27-3-18
	 * This method add customer details to an existing customer
	 * @param customerCode
	 * @param defaultNotifyValue
	 * @param firstName
	 * @param lastName
	 * @param type
	 * @return
	 */
	public CMT008 addCustomerDetails(String customerCode, String defaultNotifyValue,String firstName, String lastName, String type){
		customerCode = PropertyHandler.getPropValue(dataFilePath, customerCode);
		defaultNotifyValue = PropertyHandler.getPropValue(dataFilePath, defaultNotifyValue);
		firstName = PropertyHandler.getPropValue(dataFilePath, firstName);
		lastName = PropertyHandler.getPropValue(dataFilePath, lastName);
		type = PropertyHandler.getPropValue(dataFilePath, type);
		
		enterKeys(waitForElement(txt_agentCode), customerCode);
		click(btn_list);
		minWait();
		click(tab_customerDetails);
		scrollToView(txt_fistName);
		selectByText(dropdown_defaultNofiyValue, defaultNotifyValue);
		click(btn_addCustomer);
		scrollToView(txt_fistName);
		enterKeys(waitForElement(txt_fistName), firstName);
		enterKeys(waitForElement(txt_lastName), lastName);
		selectByText(dropdown_type, type);
		click(btn_save);
		driver.switchTo().defaultContent();
		Assert.assertEquals(waitForElement(msg_popup).getText(), "The data has been successfully saved.");
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	
	public CMT008 checkGlobalCustomer(String agentCode)
	{
		agentCode=PropertyHandler.getPropValue(dataFilePath, agentCode);
		enterKeys(txt_agentCode, agentCode);
		click(btn_list);
		
		if(waitForElement(chk_globalCust).isSelected())
			click(btn_clear);
		else{
			click(chk_globalCust);
			click(btn_save);
			minWait();
			driver.switchTo().defaultContent();
			click(btn_genericOk);
			waitForFrameAndSwitch(FRAME);
			minWait();
		}
		
		return this;
		
	}
	
	
	
	public CMT008 selectRestrictedFoPsCredit(String agentcode){
		
		agentcode=PropertyHandler.getPropValue(dataFilePath, agentcode);

		enterKeys(txt_agentCode, agentcode);
		click(btn_list);
		minWait();
		click(dropdown_restrictedFoPs);
		click(checkbox_restrictedFoPs_credit);
		
		click(btn_save);
		maxWait();
		driver.switchTo().defaultContent();
		click(btn_genericOk);
		waitForFrameAndSwitch(FRAME);
		minWait();
		
		return this;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
