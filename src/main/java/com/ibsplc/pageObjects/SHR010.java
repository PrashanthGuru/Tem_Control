/**
 * 
 */
package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * @author A-6545
 *
 */
public class SHR010 extends BasePage {
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	public static String FRAME = "iCargoContentFrameSHR010";


	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	private WebDriver driver;
	private String dataFileName;
	private By 

	btn_clear,
	btn_genericYes,
	Generic_info_msg,
	btn_genericOk,
	Text_stationCode,
	Text_CurrencyCode,
	Listbutton,
	paramDesc,
	tbl,
	Savebutton,
	Text_value,
	Closebutton,
	txt_parameterDescription,
	txt_parameterValue;



	public SHR010(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}

	/**
	 * Initializes the webelements
	 *
	 * @author A-6545
	 */
	private void initElements() {

		Text_stationCode = MiscUtility.getWebElement(objFilepath, "SHR010_Text_stationCode");
		Listbutton = MiscUtility.getWebElement(objFilepath, "SHR010_Listbutton");
		paramDesc = MiscUtility.getWebElement(objFilepath, "SHR010_paramDesc");
		Savebutton = MiscUtility.getWebElement(objFilepath, "SHR010_Savebutton");
		Closebutton = MiscUtility.getWebElement(objFilepath, "SHR010_Closebutton");
		Text_CurrencyCode= MiscUtility.getWebElement(objFilepath, "SHR010_Text_CurrencyCode");
		tbl = MiscUtility.getWebElement(objFilepath, "SHR010_tbl");
		Text_value= MiscUtility.getWebElement(objFilepath, "SHR010_Text_value");
		btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		txt_parameterDescription = MiscUtility.getWebElement(objFilepath, "SHR010_txt_parameterDescription");
		txt_parameterValue = MiscUtility.getWebElement(objFilepath, "SHR010_txt_parameterValue");
	}

	/**
	 * lists a flight with flight number
	 *
	 * @param fltCar
	 * @param fltNo
	 * @param fltDt
	 * @author A-6545
	 * @author A-6545
	 */
	private void Listvalue( String origin) {

		enterKeys(Text_stationCode, origin);

		click(Listbutton);
	}

	private WebElement getParameterValueElement(String parameterDescription){
		List<WebElement> parameterDescriptionFields = getWebElements(txt_parameterDescription);
		int rowNumber = 0;
		for(int i=0; i<parameterDescriptionFields.size(); i++){
			if(parameterDescriptionFields.get(i).getAttribute("value").equals(parameterDescription)){
				rowNumber = i;
				break;
			}
		}
		List<WebElement> parameterValueFields = getWebElements(txt_parameterValue);
		scrollToView(parameterValueFields.get(rowNumber));
		return parameterValueFields.get(rowNumber);
	}
	

public SHR010 Change_DimensionsY(String origin,String Key) {

		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		Listvalue(origin);
		minWait();

		/*//By txt_val = By.xpath("//input[contains(text(),'Dimension information mandatory')]/following::td[1]/input");
		By txt_val = By.xpath("//input[@id='CMP_Shared_Area_Station_MaintainStation_ParamDesc'][contains(text(),'Dimension information mandatory')]/input");
		scrollToView(waitForElement(tbl).findElement(txt_val));
		waitForElement(tbl).findElement(txt_val).clear();
		waitForElement(tbl).findElement(txt_val).sendKeys(Key);
		//tblsetTextByColValue(tbl, 1, 2, "Dimension information mandatory",Key);
		scrollToView(Text_value);
		enterKeys(Text_value, Key);*/
		
		enterKeys(getParameterValueElement("Dimension information mandatory"), Key);

		click(Savebutton);

		return new SHR010(driver, dataFileName);

	}

	public SHR010 Currency_change(String origin,String currency) {

		origin = PropertyHandler.getPropValue(dataFilePath, origin);

		Listvalue(origin);
		minWait();
		enterKeys(Text_CurrencyCode, currency);


		click(Savebutton);

		return new SHR010(driver, dataFileName);

	}
	public HomePage close() {

		click(Closebutton);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {

			click(btn_genericYes);
		}
		return new HomePage(driver, dataFileName);
	}

}