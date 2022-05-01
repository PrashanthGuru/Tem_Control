package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class SHR033 extends BasePage {

	public SHR033(WebDriver driver, String testDataFile) {
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
    
    private By txt_airlineID,
    	txt_alphaCode,
    	btn_list,
    	btn_clear,
    	chkbox_parterAirline,
    	btn_save,txt_billingCurrency,txt_listingCurrency,
    	btn_close,
    	dialogueBtn_yes,
    	btn_billingTab,
    	txt_ISCPerOutward,
    	dropdown_attribute,
    	info_footerNotification,
    	btn_SISTab,
    	chkbx_sisTab_outgoingSelect,
    	link_sisTab_outgoingDelete ,
    	link_sisTab_outgoingAdd,
    	dropdown_sisTab_outtype,
    	radioBtn_sisTab_IsXML,
    	radioBtn_sisTab_ISIDEC,
    	txt_sisTab_validfrom,
    	txt_sisTab_validTo,
    	txt_billingcurrrency,
    	txt_ListingCurrency,

    	// created byA-8254    	
    	btn_parameterDesc,
    	txt_parameterValue_filter,
    	list_dropdown_Parametervalue,
    	btn_genericYes;
    
    
    private void initPageElements(){
    	txt_airlineID = MiscUtility.getWebElement(objFilepath, "SHR033_txt_airlineID");
    	txt_alphaCode = MiscUtility.getWebElement(objFilepath, "SHR033_txt_alphaCode");
    	btn_list = MiscUtility.getWebElement(objFilepath, "SHR033_btn_list");
    	btn_clear = MiscUtility.getWebElement(objFilepath, "SHR033_btn_clear");
    	chkbox_parterAirline = MiscUtility.getWebElement(objFilepath, "SHR033_chkbox_parterAirline");
    	btn_save = MiscUtility.getWebElement(objFilepath, "SHR033_btn_save");
    	btn_close = MiscUtility.getWebElement(objFilepath, "SHR033_btn_close");
    	dialogueBtn_yes = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
    	info_footerNotification = MiscUtility.getWebElement(genFilepath, "Generic_foot_layer");
    	btn_billingTab=MiscUtility.getWebElement(objFilepath, "SHR033_btn_billingTab");
    	txt_ISCPerOutward=MiscUtility.getWebElement(objFilepath, "SHR033_txt_ISCPerOutward");
    	dropdown_attribute=MiscUtility.getWebElement(objFilepath, "SHR033_dropdown_attribute");
    	//a-8254
    	btn_parameterDesc = MiscUtility.getWebElement(objFilepath, "SHR033_btn_parameterDesc");
    	txt_parameterValue_filter = MiscUtility.getWebElement(objFilepath, "SHR033_txt_parameterValue_filter");
    	list_dropdown_Parametervalue = MiscUtility.getWebElement(objFilepath, "SHR033_list_dropdown_Parametervalue");
    	btn_genericYes= MiscUtility.getWebElement(genFilepath,"Generic_btn_diaYes");

    	txt_billingCurrency= MiscUtility.getWebElement(objFilepath, "SHR033_txt_billingCurrency");
    	txt_listingCurrency= MiscUtility.getWebElement(objFilepath, "SHR033_txt_listingCurrency");

    	
    	btn_SISTab=MiscUtility.getWebElement(objFilepath, "SHR033_btn_SISTab");
    	chkbx_sisTab_outgoingSelect=MiscUtility.getWebElement(objFilepath, "SHR033_chkbx_sisTab_outgoingSelect");
    	link_sisTab_outgoingDelete=MiscUtility.getWebElement(objFilepath, "SHR033_link_sisTab_outgoingDelete");
    	link_sisTab_outgoingAdd=MiscUtility.getWebElement(objFilepath, "SHR033_link_sisTab_outgoingAdd");
    	dropdown_sisTab_outtype=MiscUtility.getWebElement(objFilepath, "SHR033_dropdown_sisTab_outtype");
    	radioBtn_sisTab_IsXML=MiscUtility.getWebElement(objFilepath, "SHR033_radioBtn_sisTab_IsXML");
    	radioBtn_sisTab_ISIDEC=MiscUtility.getWebElement(objFilepath, "SHR033_radioBtn_sisTab_ISIDEC");
    	txt_sisTab_validfrom=MiscUtility.getWebElement(objFilepath, "SHR033_txt_sisTab_validfrom");
    	txt_sisTab_validTo=MiscUtility.getWebElement(objFilepath, "SHR033_txt_sisTab_validTo");
    	
    	txt_billingcurrrency=MiscUtility.getWebElement(objFilepath, "SHR033_txt_billingcurrrency");
    	txt_ListingCurrency=MiscUtility.getWebElement(objFilepath, "SHR033_txt_ListingCurrency");


    }
    
   /**
    * 
    * @param alphacarrierCode
    * @param listingCurrency
    * @param billingCurrency
    * @return
    */
    public SHR033 changeCurrency(String alphacarrierCode,String billingCurrency){
    	
    	alphacarrierCode=PropertyHandler.getPropValue(filepath, alphacarrierCode);
    	
    	
    	enterKeys(txt_alphaCode, alphacarrierCode);
    	click(btn_list);
    	minWait();
    	click(btn_billingTab);
    	
    	String Bcurr=waitForElement(txt_billingcurrrency).getAttribute("value");
    	PropertyHandler.setPropValue(filepath, billingCurrency, Bcurr);
    	String Lcurr=waitForElement(txt_ListingCurrency).getAttribute("value");
    	enterKeys(txt_billingcurrrency, Lcurr);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(dialogueBtn_yes)){
    		click(dialogueBtn_yes);
    	}
    	waitForFrameAndSwitch(FRAME);
    	
    	return this;
    }
    
    public SHR033 makeCurrencyDiffrnt(String alpahaCode,String currency1,String currency2,String listingCurr,String BillingCurr){
    	
    	alpahaCode=PropertyHandler.getPropValue(filepath, alpahaCode);
    	currency1=PropertyHandler.getPropValue(filepath, currency1);
    	currency2=PropertyHandler.getPropValue(filepath, currency2);
    			
    		   	enterKeys(txt_alphaCode, alpahaCode);
    	click(btn_list);
    	minWait();
    	click(btn_billingTab);
    	
    	String Bcurr=waitForElement(txt_billingcurrrency).getAttribute("value");
    	PropertyHandler.setPropValue(filepath, BillingCurr, Bcurr);
    	String Lcurr=waitForElement(txt_ListingCurrency).getAttribute("value");
     	PropertyHandler.setPropValue(filepath, listingCurr, Lcurr);
     	
     	enterKeys(txt_billingcurrrency, currency1);
     	enterKeys(txt_billingcurrrency, currency2);
		
     	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(dialogueBtn_yes)){
    		click(dialogueBtn_yes);
    	}
    	waitForFrameAndSwitch(FRAME);
    	
     	return this;
     	
    }
    /**
     * 
     * @param alphaCode
     * @param BillingCurr
     * @param ListingCurr
     * @return
     */
    public SHR033 revertCurrDiff(String alphaCode,String BillingCurr,String ListingCurr){
    	
    	alphaCode=PropertyHandler.getPropValue(filepath, alphaCode);
    	BillingCurr=PropertyHandler.getPropValue(filepath, BillingCurr);
    	ListingCurr=PropertyHandler.getPropValue(filepath, ListingCurr);
		
    	enterKeys(txt_alphaCode, alphaCode);
    	click(btn_list);
    	minWait();
    	click(btn_billingTab);
    	enterKeys(txt_billingCurrency, BillingCurr);
    	enterKeys(txt_listingCurrency, ListingCurr);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(dialogueBtn_yes)){
    		click(dialogueBtn_yes);
    	}
    	waitForFrameAndSwitch(FRAME);
    	
    	return this;
    }
    
    public SHR033 revertCurrency(String alphacarrierCode,String billingCurrency){
    	
    	alphacarrierCode=PropertyHandler.getPropValue(filepath, alphacarrierCode);
    	billingCurrency=PropertyHandler.getPropValue(filepath, billingCurrency);
    	
    	
    	enterKeys(txt_alphaCode, alphacarrierCode);
    	click(btn_list);
    	minWait();
    	click(btn_billingTab);
    	enterKeys(txt_billingcurrrency, billingCurrency);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(dialogueBtn_yes)){
    		click(dialogueBtn_yes);
    	}
    	waitForFrameAndSwitch(FRAME);
    	
    	return this;
    	
    }
    /***
     * 
     * @param alphacarrierCode
     * @param outgoingType
     * @return
     */
    public SHR033 changeSIS_OutgoingType(String alphacarrierCode,String outgoingType){
    	
    	
    	alphacarrierCode=PropertyHandler.getPropValue(filepath, alphacarrierCode);
    	
    	enterKeys(txt_alphaCode, alphacarrierCode);
    	click(btn_list);
    	minWait();
    	
       	
    	click(btn_SISTab);
    	minWait();
    	
    	check(chkbx_sisTab_outgoingSelect);
    	click(link_sisTab_outgoingDelete);
    	click(link_sisTab_outgoingAdd);
    	
    	selectByText(dropdown_sisTab_outtype, "All");
    	
    	if(outgoingType.equals("IS-XML")){
    		
    		check(radioBtn_sisTab_IsXML);
    	}
    	
    	else if(outgoingType.equals("IS-IDEC"))
    		
    		check(radioBtn_sisTab_ISIDEC);
    	
    	enterKeys(txt_sisTab_validfrom, ".");
    	enterKeys(txt_sisTab_validTo, "600");
    	
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(dialogueBtn_yes)){
    		click(dialogueBtn_yes);
    	}
    	waitForFrameAndSwitch(FRAME);
		return this;
    	
    }
    
    /**
     * 
     * @param airlineCode
     * @param attributeValue
     * @return
     */
    public SHR033 changeAttribute(String airlineCode,String attributeValue){
    	
    	
    	airlineCode = PropertyHandler.getPropValue(filepath, airlineCode);
    	
    	enterKeys(txt_alphaCode, airlineCode);
    	click(btn_list);
    	minWait();
    	
    	click(btn_billingTab);
    	minWait();
    	
		selectByText(dropdown_attribute, attributeValue);
		
		click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(dialogueBtn_yes)){
    		click(dialogueBtn_yes);
    	}
    	waitForFrameAndSwitch(FRAME);
		return this;
    	
    }
    
 public SHR033 StoreAndchangeAttribute(String airlineCode,String attributeValue,String old_Value,String StoreVal){
    	
    	
    	airlineCode = PropertyHandler.getPropValue(filepath, airlineCode);
    	attributeValue = PropertyHandler.getPropValue(filepath, attributeValue);
    	enterKeys(txt_alphaCode, airlineCode);
    	click(btn_list);
    	minWait();
    	
    	click(btn_billingTab);
    	minWait();
    	StoreVal=getSelectedValue(dropdown_attribute);
    	PropertyHandler.setPropValue(filepath, old_Value,StoreVal);
  //  	old_Value = PropertyHandler.getPropValue(filepath, old_Value);
		selectByText(dropdown_attribute, attributeValue);
		click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(dialogueBtn_yes)){
    		click(dialogueBtn_yes);
    	}
    	waitForFrameAndSwitch(FRAME);
		return this;
		
		
    	
    }
 
 public SHR033 ResetAttributeValue(String airlineCode,String old_Value){
 	
 	
 	airlineCode = PropertyHandler.getPropValue(filepath, airlineCode);
 	old_Value=PropertyHandler.getPropValue(filepath, old_Value);
 	enterKeys(txt_alphaCode, airlineCode);
 	click(btn_list);
 	minWait();
 	
 	click(btn_billingTab);
 	minWait();
 	selectByText(dropdown_attribute, old_Value);
 	click(btn_save);
	driver.switchTo().defaultContent();
	if(verifyElementPresent(dialogueBtn_yes)){
		click(dialogueBtn_yes);
	}
	waitForFrameAndSwitch(FRAME);
	return this;
 	
 	
 	
 	
		
	
 	
 }
   /***
    *  
    * @param airlineAlphaCode
    * @param ISCPer
    * @return
    */
    public SHR033 setISC_Outward(String airlineAlphaCode,String ISCPer){
    	
    	airlineAlphaCode = PropertyHandler.getPropValue(filepath, airlineAlphaCode);
    	ISCPer=PropertyHandler.getPropValue(filepath, ISCPer);
    	enterKeys(txt_alphaCode, airlineAlphaCode);
    	click(btn_list);
    	minWait();
    	
    	click(btn_billingTab);
    	minWait();
		
    	enterKeys(txt_ISCPerOutward, ISCPer);
    	
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(dialogueBtn_yes)){
    		click(dialogueBtn_yes);
    	}
    	//Assert.assertEquals(waitForElement(info_footerNotification).getText().trim(), "The data has been successfully saved.");
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * 
     * @param airlineAlphaCode
     * @return
     */
   public SHR033 set_BillingListingCurr(String airlineAlphaCode,String BillCurr,String LstCurr,String ProrationCurr){
    	
    	airlineAlphaCode = PropertyHandler.getPropValue(filepath, airlineAlphaCode);
    	ProrationCurr = PropertyHandler.getPropValue(filepath, ProrationCurr);
    	enterKeys(txt_alphaCode, airlineAlphaCode);
    	click(btn_list);
    	minWait();
    	
    	click(btn_billingTab);
    	minWait();
    	String BCurr=waitForElement(txt_billingCurrency).getAttribute("value");
    	System.out.println(BCurr);
    	String LCurr=waitForElement(txt_listingCurrency).getAttribute("value");
    	System.out.println(LCurr);
    	PropertyHandler.setPropValue(filepath, BillCurr, BCurr);
    	PropertyHandler.setPropValue(filepath, LstCurr, LCurr);
    	
    	enterKeys(txt_listingCurrency,ProrationCurr);
    	enterKeys(txt_billingCurrency, ProrationCurr);
    	
    	click(btn_save);
    	minWait();
   // 	Assert.assertEquals(waitForElement(info_footerNotification).getText().trim(), "The data has been successfully saved.");
    
    	return this;
    }
   public SHR033 Reset_BillingListingCurr(String airlineAlphaCode,String BillCurr,String LstCurr){
   	
   	airlineAlphaCode = PropertyHandler.getPropValue(filepath, airlineAlphaCode);

   	enterKeys(txt_alphaCode, airlineAlphaCode);
   	click(btn_list);
   	minWait();
   	
   	click(btn_billingTab);
   	minWait();
   
   	enterKeys(txt_listingCurrency,LstCurr);
   	enterKeys(txt_billingCurrency, BillCurr);
   	
   	click(btn_save);
   	minWait();
   	Assert.assertEquals(waitForElement(info_footerNotification).getText().trim(), "The data has been successfully saved.");
   
   	return this;
   }
   
    
    public SHR033 saveAsPartnerAirline(String airlineAlphaCode, String isPartnerAirlineAlreadyChecked){
    	airlineAlphaCode = PropertyHandler.getPropValue(filepath, airlineAlphaCode);
    	enterKeys(txt_alphaCode, airlineAlphaCode);
    	click(btn_list);
    	minWait();
    	String checkStatus = waitForElement(chkbox_parterAirline).getAttribute("checked");
    	String isChecked;
    	if(checkStatus == null)
    		isChecked = "false";
    	else
    		isChecked = "true";
    	PropertyHandler.setPropValue(filepath, isPartnerAirlineAlreadyChecked, isChecked);
    	check(chkbox_parterAirline);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(dialogueBtn_yes)){
    		click(dialogueBtn_yes);
    	}
    	//Assert.assertEquals(waitForElement(info_footerNotification).getText().trim(), "The data has been successfully saved.");
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Method to uncheck the Partner Airling check box if already checked.
     * And save the current value 
     * @param airlineAlphaCode
     * @param isPartnerAirlineAlreadyChecked
     * @return
     * @author a-7868 Krishna <25/01/2018>
     */
    public SHR033 unCheckPartnerAirline(String airlineAlphaCode, String isPartnerAirlineAlreadyChecked){
    	airlineAlphaCode = PropertyHandler.getPropValue(filepath, airlineAlphaCode);
    	enterKeys(txt_alphaCode, airlineAlphaCode);
    	click(btn_list);
    	minWait();
    	String checkStatus = waitForElement(chkbox_parterAirline).getAttribute("checked");
    	String isChecked;
    	if(checkStatus == null)
    		isChecked = "false";
    	else
    		isChecked = "true";
    	PropertyHandler.setPropValue(filepath, isPartnerAirlineAlreadyChecked, isChecked);
    	unCheck(chkbox_parterAirline);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(dialogueBtn_yes)){
    		click(dialogueBtn_yes);
    	}
    	Assert.assertEquals(waitForElement(info_footerNotification).getText().trim(), "The data has been successfully saved.");
    	waitForFrameAndSwitch(FRAME);
    	
    	return this;
    }
    /***
     * 
     * @param airlineAlphaCode
     * @param isPartnerAirlineAlreadyChecked
     * @return
     */
    public SHR033 resetPartnerAirlineStatus(String airlineAlphaCode, String isPartnerAirlineAlreadyChecked){
    	airlineAlphaCode = PropertyHandler.getPropValue(filepath, airlineAlphaCode);
    	isPartnerAirlineAlreadyChecked = PropertyHandler.getPropValue(filepath, isPartnerAirlineAlreadyChecked);
    	enterKeys(txt_alphaCode, airlineAlphaCode);
    	click(btn_list);
    	minWait();
    	if(isPartnerAirlineAlreadyChecked.equalsIgnoreCase("true"))
    		check(chkbox_parterAirline);
    	else
    		unCheck(chkbox_parterAirline);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(dialogueBtn_yes)){
    		click(dialogueBtn_yes);
    	}
    	Assert.assertEquals(waitForElement(info_footerNotification).getText().trim(), "The data has been successfully saved.");
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    public HomePage close(){
    	click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(dialogueBtn_yes)) {

            click(dialogueBtn_yes);
        }
        return new HomePage(driver, testDataFile);
    }
    
    /**
     *  @author a-8254 jiljo
     */
    
    public SHR033 changeParameter_dropdown (String alphaCode ,String paramCode, String paramValue, String priorValue) {

    	paramCode 	 = PropertyHandler.getPropValue(filepath, paramCode);
		paramValue 	 = PropertyHandler.getPropValue(filepath, paramValue);
		alphaCode  = PropertyHandler.getPropValue(filepath, alphaCode);

		enterKeys(txt_alphaCode, alphaCode);

		click(btn_list);
		minWait();
		click(btn_parameterDesc);
		minWait();
		enterKeys(txt_parameterValue_filter, paramCode + Keys.TAB);
		
        minWait();
        List<WebElement> parameterValuesDropdowns = getWebElements(list_dropdown_Parametervalue);
        WebElement parameterValue = null;
        for(WebElement parameterValuesDropdown:parameterValuesDropdowns)
        	if(parameterValuesDropdown.isDisplayed())
        		parameterValue = parameterValuesDropdown;
        click(parameterValue);
        System.out.println("Prior Value"+waitForElement(parameterValue).getAttribute("value"));
        PropertyHandler.setPropValue(filepath, priorValue, waitForElement(parameterValue).getAttribute("value"));
        selectByText(parameterValue, paramValue);
      	click(btn_save);
      	driver.switchTo().defaultContent();
      	 while(verifyElementPresent(btn_genericYes)){
      	    click(btn_genericYes);
      	    	minWait();
      	    }
      	waitForFrameAndSwitch(FRAME);

		return this;
    }

    /****
	 * reset parameter value from dropdown
	 * @param airportCode
	 * @param paramCode
	 * @param paramValue
	 * @return
	 * author  a-8254 jiljo
	 */

    public SHR033 resetParameter_dropdown (String airportCode ,String paramCode, String paramValue) {

    	paramCode 	 = PropertyHandler.getPropValue(filepath, paramCode);
		paramValue 	 = PropertyHandler.getPropValue(filepath, paramValue);
		airportCode  = PropertyHandler.getPropValue(filepath, airportCode);

		enterKeys(txt_alphaCode, airportCode);

		click(btn_list);
		minWait();
		click(btn_parameterDesc);
		minWait();
		enterKeys(txt_parameterValue_filter, paramCode + Keys.TAB);
        minWait();
        click(list_dropdown_Parametervalue);
        selectByText(list_dropdown_Parametervalue, paramValue);
      	click(btn_save);

		return this;
    } 
}
