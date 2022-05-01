package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Screen OPR360 - Capture DG Details Screen
 * @author Souvik
 * A-8457
 * on 24th March-2020
 */
public class OPR360 extends BasePage {

	public static String FRAME = "iCargoContentFrameOPR360";
	public static String screenFrame = "iCargoContentFrameOPR360";
	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"OPR_FLT.properties");
	private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"Generic.properties");
	WebDriver driver;
	String dataFileName;
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

	private By txtbx_carriercode, txtbx_ATDdate, txtbx_flightNumber, txtbx_date, btn_List;
	private By sel_blockedFor, txt_remarks, btn_blk_details, chcbx_Bulk, btn_manifst, btn_finalize, btn_close, yesBtn,
			btn_editIcon, btn_switchRole, btn_station, btn_ok, btn_flightfinalize, txt_statusfinalized, btn_assignhere,
			btn_Manifest, btn_PopOk, btn_Popup_Save,
			// A-7290
			Select_Rolegroup, btn_Bulk, Icon_bulk;

	public OPR360(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}

	/**
	 * Method to initialize page elements
	 */
	private void initElements() {
		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		
	}

	/**
	 * @author Sharath
	 * A-8680
	 * Capture TC details
	 */
	public OPR360 CaptureTCDetailsULD(String prefix, String awbNo, String uldNo) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
		enterKeys(By.name("shipmentPrefix"),prefix);
		enterKeys(By.name("masterDocumentNumber"),awbNo);
		click(By.name("btnList"));
		maxWait();
//		Monitoring Details
		click(By.xpath("//h4[text()='Monitoring Details']/../preceding-sibling::span"));
		minWait();
		selectByText(By.xpath("//select[@name='uldNumber']"), uldNo);
		selectByText(By.xpath("//select[@name='chkType']"), "Are there re-icing instructions for the unit?");
		minWait();
		selectByText(By.xpath("//select[@name='value']"), "Yes");
		enterKeys(By.xpath("//textarea[@name='remarks']"), "AutTest");
		minWait();
		click(By.name("BtnMonitoringAdd"));
		captureAndAddScreenshot();
		InitialSetup.test.log(LogStatus.INFO, "Added all the TC details");
		minWait();
		click(By.xpath("//button[@name='btnSave']"));
		maxWait();
		InitialSetup.test.log(LogStatus.PASS, "TC Details has been succesfully captured");
		return this;		
	}

	/**
	 * @author Sharath
	 * A-8680
	 * Capture TC details
	 */
	public OPR360 CaptureTCDetailsPcs(String prefix, String awbNo, String pcs) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		enterKeys(By.name("shipmentPrefix"),prefix);
		enterKeys(By.name("masterDocumentNumber"),awbNo);
		click(By.name("btnList"));
		maxWait();
//		Monitoring Details
		click(By.xpath("//h4[text()='Monitoring Details']/../preceding-sibling::span"));
		minWait();
		click(By.xpath("//input[@value='pcs']"));
		minWait();
		enterKeys(By.name("pieces"),pcs);
		selectByText(By.xpath("//select[@name='chkType']"), "Are there re-icing instructions for the unit?");
		minWait();
		selectByText(By.xpath("//select[@name='value']"), "Yes");
		enterKeys(By.xpath("//textarea[@name='remarks']"), "AutTest");
		minWait();
		click(By.name("BtnMonitoringAdd"));
		captureAndAddScreenshot();
		InitialSetup.test.log(LogStatus.INFO, "Added all the TC details");
		minWait();
		click(By.xpath("//button[@name='btnSave']"));
		maxWait();
		InitialSetup.test.log(LogStatus.PASS, "TC Details has been succesfully captured");
		return this;		
	}

	public OPR360 verifyPrintTCDetails(String prefix, String awbNo, boolean listingReqd){
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		if (listingReqd) {
			enterKeys(By.name("shipmentPrefix"), prefix);
			enterKeys(By.name("masterDocumentNumber"), awbNo);
			click(By.name("btnList"));
			maxWait();
		}
		click(By.name("btnPrint"));
		maxWait();
		if(getNumberOfWindows()>1){
			switchToSecondWindow();
			maxWait();
			waitForFrameAndSwitch("ReportContainerFrame");
			if(verifyElementPresent(By.xpath("//span[contains(text(),'AWB')]/ancestor::div[2]/following-sibling::div//span[contains(text(),'"+awbNo+"')]"))){
				InitialSetup.test.log(LogStatus.PASS, "TC Details has been succesfully printed");
				captureAndAddScreenshot();
			}
			else{
				InitialSetup.test.log(LogStatus.FAIL, "TC Details has not been succesfully printed");
			}
		driver.switchTo().defaultContent();
		driver.close();
		switchBackToFirstWindow();
		waitForFrameAndSwitch(screenFrame);
		}
		return this;
	}
	
	
	/**
	 * @author Sharath
	 * A-8680
	 * Capture TC details
	 */
	public OPR360 performCorrectiveActions(String prefix, String awbNo, boolean listingReqd) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		if (listingReqd) {
			enterKeys(By.name("shipmentPrefix"), prefix);
			enterKeys(By.name("masterDocumentNumber"), awbNo);
			click(By.name("btnList"));
			maxWait();
		}
		InitialSetup.test.log(LogStatus.INFO, "Performing corrective actions");
//		Monitoring Details
		click(By.xpath("//h4[text()='Monitoring Details']/../preceding-sibling::span"));
		minWait();
		scrollToView(By.xpath("//div[@id='monitoringDetailsTabletop']//td[1]"));
		minWait();
		click(By.xpath("(//i[contains(@class,'ellipsis')])[1]"));
		minWait();
		click(By.xpath("(//a[contains(text(),'Edit Corrective Action')])[last()]"));
		minWait();
		waitForFrameAndSwitch("popupContainerFrame");
		click(By.xpath("//input[@value='Confirm Paperwork']"));
		click(By.name("btnUseSelected"));
		driver.switchTo().defaultContent();
		waitForFrameAndSwitch(screenFrame);
		click(By.xpath("//span[text()='Corrective Actions']/..//button[@title='Close']"));
		if(verifyElementPresent(By.xpath("(//div[contains(text(),'Corrective Actions Taken')])[1]"))){
			InitialSetup.test.log(LogStatus.PASS, "Corrective Actions Taken");
			captureAndAddScreenshot();
		}else{
			InitialSetup.test.log(LogStatus.FAIL, "Corrective Actions Failed");
		}
		return this;
	}
	
	public HomePage close() {

		click(By.xpath("//button[@name='btnClose']"));
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		return new HomePage(driver, dataFileName);
	}
	
	

}