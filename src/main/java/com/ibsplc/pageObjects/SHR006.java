package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class SHR006 extends BasePage {

	    public static String FRAME = "iCargoContentFrameSHR006";
	    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
	    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	    WebDriver driver;
	    String screenFrame;
	    String dataFileName;
	    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");


	    By
	    txt_airportCode,
	    btn_List,btn_tab2,
	    btn_parameterDesc,
	    txt_Parameter,text_listingCurrency,
	    btn_save, 
	    list_dropdown_Parametervalue,
	    list_value,
	    btn_Close,
	    chk_value1,
	    chk_value,
	    txt_parameterValue,
	    txt_parameterValue_filter,
	    btn_parameterValue_filter,
	    yesBtn,
	    txt_cityCode,
	    txt_countryCode
	    ;


	    public SHR006(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initPageElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        this.dataFileName = dataFileName;
	    }

	    /**
	     * Method to initialize page objects
	     */
	    private void initPageElements(){

	    	txt_airportCode             = MiscUtility.getWebElement(objFilepath, "SHR006_txt_airportCode");
		    btn_List                    = MiscUtility.getWebElement(objFilepath, "SHR006_btn_List");
		    btn_parameterDesc           = MiscUtility.getWebElement(objFilepath, "SHR006_btn_parameterDesc");
		    txt_Parameter               = MiscUtility.getWebElement(objFilepath, "SHR006_txt_Parameter");
		    btn_save                    = MiscUtility.getWebElement(objFilepath,"SHR006_btn_save");
		    btn_Close                   = MiscUtility.getWebElement(objFilepath, "SHR006_btn_Close");
		    list_dropdown_Parametervalue= MiscUtility.getWebElement(objFilepath, "SHR006_list_dropdown_Parametervalue");
		    txt_parameterValue          =MiscUtility.getWebElement(objFilepath, "SHR006_txt_parameterValue");
		    btn_parameterValue_filter   =MiscUtility.getWebElement(objFilepath, "SHR006_btn_parameterValue_filter");
		    list_value            =MiscUtility.getWebElement(objFilepath, "SHR006_list_value");
		    txt_parameterValue_filter   =MiscUtility.getWebElement(objFilepath, "SHR006_txt_parameterValue_filter");
		    chk_value1        =MiscUtility.getWebElement(objFilepath, "SHR006_chk_value1");
		    chk_value                   =MiscUtility.getWebElement(objFilepath, "SHR006_chk_value");
		    yesBtn			            = MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
		    btn_tab2= MiscUtility.getWebElement(objFilepath,"SHR006_btn_tab2");
		    text_listingCurrency= MiscUtility.getWebElement(objFilepath,"SHR006_text_listingCurrency");
		    txt_cityCode =MiscUtility.getWebElement(objFilepath,"SHR006_txt_cityCode");
		    txt_countryCode =MiscUtility.getWebElement(objFilepath,"SHR006_txt_countryCode");
		    
		    
	    }

	/****
	 * select parameter value from dropdown
	 * @param airportCode
	 * @param paramCode
	 * @param paramValue
	 * @param priorValue TODO
	 * @return
	 * author A-6784
	 * edited A-7868 <14/02/2018> added @param priorValue
	 */

	    public SHR006 changeParameter_dropdown (String airportCode ,String paramCode, String paramValue, String priorValue) {

	    	paramCode 	 = PropertyHandler.getPropValue(dataFilePath, paramCode);
			paramValue 	 = PropertyHandler.getPropValue(dataFilePath, paramValue);
			airportCode  = PropertyHandler.getPropValue(dataFilePath, airportCode);

			enterKeys(txt_airportCode, airportCode);

			click(btn_List);
			minWait();
			click(btn_parameterDesc);
			minWait();
			enterKeys(txt_parameterValue_filter, paramCode);

	        minWait();
	        click(list_dropdown_Parametervalue);
	        String prior = getSelectedValue(list_dropdown_Parametervalue).trim();
	        System.out.println("Prior Value: " + prior);
			if (!priorValue.equals("")) {
				PropertyHandler.setPropValue(dataFilePath, priorValue, prior);
			}
			selectByText(list_dropdown_Parametervalue, paramValue);
	      	click(btn_save);
			return this;
	    }

	    /****
		 * reset parameter value from dropdown
		 * @param airportCode
		 * @param paramCode
		 * @param paramValue
		 * @return
		 * author  A-7868 <14/02/2018>
		 */

	    public SHR006 resetParameter_dropdown (String airportCode ,String paramCode, String paramValue) {

	    	paramCode 	 = PropertyHandler.getPropValue(dataFilePath, paramCode);
			paramValue 	 = PropertyHandler.getPropValue(dataFilePath, paramValue);
			airportCode  = PropertyHandler.getPropValue(dataFilePath, airportCode);

			enterKeys(txt_airportCode, airportCode);

			click(btn_List);
			minWait();
			click(btn_parameterDesc);
			minWait();
			enterKeys(txt_Parameter, paramCode + Keys.TAB);
	        minWait();
	        click(list_dropdown_Parametervalue);
	        selectByText(list_dropdown_Parametervalue, paramValue);
	      	click(btn_save);

			return this;
	    }

	    /****
		 * select parameter value from dropdown
		 * @param AirportCode
		 * @param paramCode
		 * @param paramValue
		 * @return
		 * author A-6784
		 */

		    public SHR006 ChangeParameter_Filter (String AirportCode ,String paramCode,String value) {

		    	paramCode 	 = PropertyHandler.getPropValue(dataFilePath, paramCode);
		        AirportCode  = PropertyHandler.getPropValue(dataFilePath, AirportCode);

				enterKeys(txt_airportCode, AirportCode);
				click(btn_List);
				minWait();
				click(btn_parameterValue_filter);
				minWait();
				enterKeys(txt_parameterValue_filter, paramCode + Keys.TAB);
				minWait();
				click(list_value);
				
				String id = waitForElement(list_value).getAttribute("id");
				By unckAll = By.xpath("//a[contains(@class, 'ui-multiselect-none')]");
				By chkbx = By.xpath("//label/input[contains(@value, '"+value+"']");
				click(unckAll);
				check(chkbx);
				/*if(value.equalsIgnoreCase("ARR"))
				{
					check(chk_value);
				}
				else if(value.equalsIgnoreCase("CLSFLT")) {
					String temp =waitForElement(chk_value).getAttribute("checked");
					System.out.println(temp);
					boolean value1= waitForElement(chk_value).getAttribute("checked").equals("true");

					if(value1)
					{
					unCheck(chk_value);
					}
					check(chk_value1);
				}*/
			minWait();
		     	click(btn_save);


				return this;
		    }
		    
		    /**
		     * Method to add (check) a value to the parameter having list of values (check boxes)
		     * @param AirportCode
		     * @param paramCode
		     * @param value
		     * @return
		     * @author a-7868 Krishna <14/03/2018>
		     */		    
		    public SHR006 changeParameter_checkList_add (String AirportCode ,String paramCode, String value) {

		    	paramCode 	 = PropertyHandler.getPropValue(dataFilePath, paramCode);
		        AirportCode  = PropertyHandler.getPropValue(dataFilePath, AirportCode);

				enterKeys(txt_airportCode, AirportCode);
				click(btn_List);
				minWait();
				click(btn_parameterValue_filter);
				minWait();
				enterKeys(txt_parameterValue_filter, paramCode + Keys.TAB);
				minWait();
				click(list_value);
				
				//By unckAll = By.xpath("//a[contains(@class, 'ui-multiselect-none')]");
				By chkbx = By.xpath("//input[@value='"+value+"']");
				//click(unckAll);
				check(chkbx);
				
				minWait();
		     	click(btn_save);

				return this;
		    }
		    
		    /**
		     * Method to remove (uncheck) a value to the parameter having list of values (check boxes)
		     * @param AirportCode
		     * @param paramCode
		     * @param value
		     * @return
		     * @author a-7868 Krishna <14/03/2018>
		     */
		    public SHR006 changeParameter_checkList_remove (String AirportCode ,String paramCode, String value) {

		    	paramCode 	 = PropertyHandler.getPropValue(dataFilePath, paramCode);
		        AirportCode  = PropertyHandler.getPropValue(dataFilePath, AirportCode);

				enterKeys(txt_airportCode, AirportCode);
				click(btn_List);
				minWait();
				click(btn_parameterValue_filter);
				minWait();
				enterKeys(txt_parameterValue_filter, paramCode + Keys.TAB);
				minWait();
				click(list_value);
				
				By chkbx = By.xpath("//input[@value='"+value+"']");
				unCheck(chkbx);
				
				minWait();
		     	click(btn_save);

				return this;
		    }
		    
	    /****
		 * enter parameter value in txt box
		 * @param AirportCode
		 * @param paramCode
		 * @param paramValue
		 * @return
		 * author A-6784
		 */

 public SHR006 ChangeParametervalue (String AirportCode ,String paramCode, String paramValue) {
		    	
		    	paramCode 	 = PropertyHandler.getPropValue(dataFilePath, paramCode);
				paramValue 	 = PropertyHandler.getPropValue(dataFilePath, paramValue);
				AirportCode  = PropertyHandler.getPropValue(dataFilePath, AirportCode);
				
				enterKeys(txt_airportCode, AirportCode);
				
				click(btn_List);
				
				minWait();
			   click(btn_parameterDesc);
				minWait();
			   enterKeys(txt_Parameter, paramCode + Keys.TAB);
		        minWait();
	          List<WebElement> parameterValues = getWebElements(txt_parameterValue);
	          WebElement txt_param = null;
	          for(WebElement parameterValue:parameterValues){
	        	  if(parameterValue.isDisplayed()){
	        		  txt_param = parameterValue;
	        		  break;
	        	  }
	          }
	          enterKeys(txt_param, paramValue);
		      	click(btn_save);
						
						
				return this;
		    }
	    /**
		 * Method to close current page and return to Homepae
		 * returns the instance of Homepage
		 * @return
		 *
		 */
	    public HomePage close() {

	    	minWait();
	        click(btn_Close);
	        driver.switchTo().defaultContent();
	        if (verifyElementPresent(yesBtn)) {

	            click(yesBtn);
	        }
	        return new HomePage(driver,dataFileName);
	    }
	    
	    /**
	     * @author A-8260
	     * @return
	     */
	    public HomePage closeScreen()
	    {
	    	minWait();
	    	Actions action = new Actions(driver);
	    	action.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).perform();  	 
	    	
	    	driver.switchTo().defaultContent();
	        if (verifyElementPresent(yesBtn)) {

	            click(yesBtn);
	        }
	        return new HomePage(driver,dataFileName);
	    }

	    /**
	     * Created by A-7605 on 9-2-18
	     * enter parameter value in txt box and saves the current parameter value to the datasheet
	     * @param AirportCode
	     * @param paramCode
	     * @param newParamValue
	     * @param currentPrameterValue
	     * @return
	     */
	    public SHR006 ChangeTextFieldParameterValue(String AirportCode ,String paramCode, String newParamValue, String currentPrameterValue) {

	    	paramCode 	 = PropertyHandler.getPropValue(dataFilePath, paramCode);
	    	newParamValue 	 = PropertyHandler.getPropValue(dataFilePath, newParamValue);
			AirportCode  = PropertyHandler.getPropValue(dataFilePath, AirportCode);

			enterKeys(txt_airportCode, AirportCode);

			click(btn_List);
			minWait();
			click(btn_parameterDesc);
			minWait();
			 enterKeys(txt_Parameter, paramCode + Keys.TAB);
	        minWait();
	        List<WebElement> parameterValueFields = getWebElements(txt_parameterValue);
	        WebElement parameterField = null;
	        for (int i=0;i<parameterValueFields.size();i++){
	        	WebElement element = parameterValueFields.get(i);
	        	if(element.isDisplayed()){
	        		parameterField = element;
	        		break;
	        	}
	        }
			if (!currentPrameterValue.equals("")) {
				PropertyHandler.setPropValue(dataFilePath, currentPrameterValue, parameterField.getAttribute("value"));
			}
			enterKeys(parameterField, newParamValue);
	      	click(btn_save);


			return this;
	    }
	    
	    public SHR006 ChangeSelectParameterValue(String AirportCode ,String paramCode, String newParamValue, String currentPrameterValue) {

	    	paramCode 	 = PropertyHandler.getPropValue(dataFilePath, paramCode);
	    	newParamValue 	 = PropertyHandler.getPropValue(dataFilePath, newParamValue);
			AirportCode  = PropertyHandler.getPropValue(dataFilePath, AirportCode);

			enterKeys(txt_airportCode, AirportCode);

			click(btn_List);
			minWait();
			click(btn_parameterDesc);
			minWait();
			 enterKeys(txt_Parameter, paramCode + Keys.TAB);
	        minWait();
	        List<WebElement> parameterValueFields = getWebElements(txt_parameterValue);
	        WebElement parameterField = null;
	        for (int i=0;i<parameterValueFields.size();i++){
	        	WebElement element = parameterValueFields.get(i);
	        	if(element.isDisplayed()){
	        		parameterField = element;
	        		break;
	        	}
	        }
	        PropertyHandler.setPropValue(dataFilePath, currentPrameterValue, parameterField.getAttribute("value"));
	       // enterKeys(parameterField, newParamValue);
	        selectByText(parameterField, newParamValue);
	      	click(btn_save);


			return this;
	    }
	    
	    
	    
	    
	    
	    public SHR006 Get_ListingCurrency(String AirportCode ,String LstCurr) {

	    	
	        AirportCode  = PropertyHandler.getPropValue(dataFilePath, AirportCode);

			enterKeys(txt_airportCode, AirportCode);
			click(btn_List);
			minWait();
			click(btn_tab2);
			minWait();
			 PropertyHandler.setPropValue(dataFilePath, LstCurr, (waitForElement(text_listingCurrency).getAttribute("value")));
			
			return this;
	    }
	   
	    public SHR006 AirportMappingtoCity(String key_AirportCode ,String key_CityCode) {

	    	String data_AirportCode = PropertyHandler.getPropValue(dataFilePath, key_AirportCode);
	       // AirportCode  = PropertyHandler.getPropValue(dataFilePath, AirportCode);
           String data_CityCode     =PropertyHandler.getPropValue(dataFilePath, key_CityCode);
			enterKeys(txt_airportCode, data_AirportCode);
			click(btn_List);
			minWait();
			enterKeys( txt_cityCode,data_CityCode);
			
			
			//click(btn_tab2);
			minWait();
			 //PropertyHandler.setPropValue(dataFilePath, LstCurr, (waitForElement(text_listingCurrency).getAttribute("value")));
			click(btn_save);
			return this;
	    }
	    
	    public SHR006 AirportMappingtoCountry(String key_AirportCode ,String key_CountryCode) {

	    	String data_AirportCode = PropertyHandler.getPropValue(dataFilePath, key_AirportCode);
	       // AirportCode  = PropertyHandler.getPropValue(dataFilePath, AirportCode);
           String data_CountryCode     =PropertyHandler.getPropValue(dataFilePath, key_CountryCode);
			enterKeys(txt_airportCode, data_AirportCode);
			click(btn_List);
			minWait();
			enterKeys( txt_countryCode,data_CountryCode);
			
			
			//click(btn_tab2);
			minWait();
			 //PropertyHandler.setPropValue(dataFilePath, LstCurr, (waitForElement(text_listingCurrency).getAttribute("value")));
			click(btn_save);
			return this;
	    }
}
