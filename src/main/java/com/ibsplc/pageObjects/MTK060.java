	package com.ibsplc.pageObjects;



import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Screen MTK060 - Mail OutBound
 * 
 * @author A-8457
 * 		Souvik
 * 
 * Date - 05Feb,2020
 */
public class MTK060 extends BasePage {

	public static String FRAME = "iCargoContentFrameMTK060";
	public static String screenFrame = "iCargoContentFrameMTK060";
	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"MTK.properties");
	private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"Generic.properties");
	WebDriver driver;
	String dataFileName;
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	private By yesBtn , noBtn  , btn_genericOk , okBtn;

	

	public MTK060(WebDriver driver, String dataFileName) {
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
		noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		okBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
	}

	/*****
	 * 
	 * List And Do Carrier Acceptance
	 * Author - A-8457  Souvik
	 * @param Consignment Number
	 * @param PA
	 */

	public MTK060 ListMailbagCarrier(String Destination) {

		Destination = PropertyHandler.getPropValue(dataFilePath, Destination);
		minWait();
		click(By.xpath("//*[@type='radio'][@value='C']"));
		enterKeys(By.xpath("//input[@name='destination']"), Destination);
		click(By.xpath("//button[contains(text(),'List')]"));
		minWait();
		check(By.xpath("(//input[@type='checkbox'][@data-index='0'])[1]"));
		maxWait();
		return this;
	}


	/*****
	 * 
	 * Addition of a Container
	 * Author - A-8457  Souvik
	 * @param  Origin ,Destination
	 * @param BarrowNo
	 */

	public MTK060 AddContainer(String Origin,String Destination,String BarrowNoOrULD, boolean barrow) {

		Destination = PropertyHandler.getPropValue(dataFilePath, Destination);
		Origin = PropertyHandler.getPropValue(dataFilePath, Origin);
		BarrowNoOrULD = PropertyHandler.getPropValue(dataFilePath, BarrowNoOrULD);
		minWait();
		click(By.xpath("(//button[@class='btn secondary btn-secondary btn btn-secondary'])[1]"));
		minWait();
		if(barrow){
		check(By.xpath("//input[@name='barrowFlag']"));
		}
		enterKeys(By.xpath("//input[@name='containerNumber']"), BarrowNoOrULD );
		enterKeys(By.xpath("//input[@name='destination']"), Destination);
		click(By.xpath("//button[@formname='addcontainerForm'][contains(text(),'List')]"));
		click(By.xpath("//button[text()='Save']"));
		InitialSetup.test.log(LogStatus.PASS, "A Container has been added succesfully");
		minWait();
		return this;
	}

	
	
	/*****
	 * 
	 * To Filter a Consignmnet and add to container
	 * Author - A-8457  Souvik
	 * @param  Origin ,Destination
	 * @param BarrowNo
	 */

	public MTK060 ToFliterAMailbagAndAddToContainer(String ConsignmentNo,String FromDate , String ToDate) {

		ConsignmentNo = PropertyHandler.getPropValue(dataFilePath, ConsignmentNo);
		FromDate = PropertyHandler.getPropValue(dataFilePath, FromDate);
		ToDate = PropertyHandler.getPropValue(dataFilePath, ToDate);
		minWait();
		click(By.xpath("(//h4[text()='Carriers']/..//i)[last()]"));
		minWait();
		click(By.xpath("(//div[@class='d-flex']//i[@class='icon ico-filter'])[1]"));
		minWait();
		enterKeys(By.xpath("//input[@name='conDocNo']"), ConsignmentNo);
		enterKeys(By.xpath("//input[@name='fromDate']"), FromDate);
		enterKeys(By.xpath("//input[@name='toDate']"), ToDate);
		click(By.xpath("//button[@class='btn btn-primary'][text()='Apply']"));
		minWait();
		click(By.xpath("//button[@data-tab='LIST_VIEW']"));
		String wt=driver.findElement(By.xpath("//div[@class='row']/div[@class='col']/div[@class='pad-b-3xs']")).getText();
		PropertyHandler.setPropValue(dataFilePath, "MailBagWt", wt);
		check(By.xpath("//input[@name='carditlisttable-select']"));
		minWait();
		click(By.xpath("//button[@class='btn secondary btn-secondary container-assign-btn btn btn-secondary']"));
		
		InitialSetup.test.log(LogStatus.PASS, "A Mailbag is Filtered and added in a Container");
		minWait();
		return this;
	}
	
	
	/*****
	 * 
	 *Add a Mailbag to a container
	 * Author Sharath
	 * @throws AWTException 
	 */

	public MTK060 AddaMailbagToContainer(String ConsignmentNo,String Container,String flightNo, String flightDt) throws AWTException {

		ConsignmentNo = PropertyHandler.getPropValue(dataFilePath, ConsignmentNo);
		Container = PropertyHandler.getPropValue(dataFilePath, Container);
		flightDt = PropertyHandler.getPropValue(dataFilePath, flightDt);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		
		String prefix= "//div[contains(text(),'";
		String suffix1="')]/../preceding-sibling::div[2]/input";
		String suffix2= "')]/../following-sibling::div[1]//button";

		minWait();
		click(By.xpath("(//h4[text()='Carriers']/..//i)[last()]"));
		minWait();
		click(By.xpath("//div[@id='carditgrouptable-datafilter']"));
		minWait();
		enterKeys(By.name("conDocNo"),ConsignmentNo);
		enterKeys(By.name("fromDate"), flightDt);
		enterKeys(By.name("toDate"), flightDt+Keys.TAB);
		minWait();
		click(By.xpath("//button[text()='Apply']"));
		click(By.xpath("//button[text()='List View ']"));
		maxWait();
		click(By.xpath("(//input[@type='checkbox'][@data-type='row-select'])[1]"));
		maxWait();
		click(By.xpath(prefix+Container+suffix1));
		minWait();
		click(By.xpath(prefix+Container+suffix2));
		maxWait();
		maxWait(); 
		maxWait();
		captureAndAddScreenshot();
		prefix = "//div[text()='";
		suffix1 = "']/../..//i[contains(@class,'ellipsis')]";
		click(By.xpath(prefix+Container+suffix1));
//		maxWait();
		minWait();
		click(By.xpath("(//button[text()='Reassign to Flight'])[last()]"));
		maxWait(); 
		maxWait(); 
//		maxWait(); 
		waitForElementEnabled(By.name("flightnumber.flightNumber"));
		minWait();
		enterKeys(By.name("flightnumber.flightNumber"), flightNo.substring(2, 6));
		enterKeys(By.id("flightnumber_dateField"), flightDt+Keys.TAB);
		maxWait();
		click(By.xpath("//button[text()='List']"));
		maxWait();
		click(By.xpath("//div[@aria-label='Flight Details']/../following-sibling::div//input[@type='checkbox']"));
		maxWait();
		captureAndAddScreenshot();
		click(By.xpath("//button[@formname='reassignContainerToFlight'][text()='Save']"));
		maxWait();
		/*WebElement btnSave = driver.findElement(By.xpath("(//button[text()='Save'])[1]"));
		Actions a = new Actions(driver);
		minWait();
		a.moveToElement(btnSave).doubleClick().build().perform();*/
//		click(By.xpath("//button[text()='Save']"));
		return this;
	}
	
	
	/*****
	 * 
	 *Assign a container To flight
	 * Author - A-8457  Souvik
	 * @param  ConsignmentNo
	 * @param Container
	 */

	public MTK060 AssignAContainerToFlight(String Container, String flightNo,String flightDt, boolean listingReqd) {
		Container = PropertyHandler.getPropValue(dataFilePath, Container);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDt = PropertyHandler.getPropValue(dataFilePath, flightDt);
	/*	
		if(listingReqd){
			click(By.xpath("//i[contains(@class,'ico-pencil-rounded-orange')]"));
			click(By.xpath("//input[@value='F']"));
		}else{
			click(By.xpath("//input[@value='F']"));
		}

		enterKeys(By.name("flightnumber.flightNumber"), flightNo);
		enterKeys(By.name("flightnumber.flightDate"), flightDt);
		click(By.xpath("//button[text()='List']"));
		*/
		minWait();
		String prefix = "//div[text()='";
		String suffix = "]/../following-sibling::div[2]//button";
		click(By.xpath(prefix+Container+suffix));
		minWait();
		click(By.xpath("(//button[text()='Reassign to Flight'])[last()]"));
		maxWait();
		enterKeys(By.name("flightnumber.flightNumber"),flightNo);
		enterKeys(By.name("flightnumber.flightDate"),flightDt);
		click(By.xpath("//button[text()='List']"));
		click(By.xpath("//div[@name='datadisplay']/../../div[1]/input"));
		click(By.xpath("//button[text()='Save']"));
	/*	
		
		String tempwt="(//div[@class='pad-b-3xs'][text()='"+Container+"']/../..//div[@class='col-auto']/div)[last()]";
		int wt=Integer.parseInt(driver.findElement(By.xpath(tempwt)).getText());
		String tempcontainer="//div[@class='pad-b-3xs'][text()='"+Container+"']/../..//i[@class='icon ico-v-ellipsis']";
		click(By.xpath(tempcontainer));
		click(By.xpath("//button[contains(text(),'Reassign to Flight')]"));
		maxWait();
		driver.switchTo().defaultContent();
		
		
		List<WebElement> mailCapaticities = driver.findElements(By.xpath("//div[@aria-describedby='capacityDetails']//div[1]/div/div[1]"));
		for(WebElement mailCapacity : mailCapaticities){
			String capacity = mailCapacity.getText();
			String reqdValue[] = capacity.split(" /");
			int cap1 = Integer.parseInt(reqdValue[0]);
			int cap2 = Integer.parseInt(reqdValue[1]);
			if(cap1-cap2>=wt){
				click(mailCapacity);
				break;
			}
		}
		driver.switchTo().frame("iCargoContentFrameMTK060");*/
		InitialSetup.test.log(LogStatus.PASS, "A Container is Assigned to a flight");
		minWait();
		return this;
	}
	
	public HomePage close() {
		click(By.xpath("//button[@class='btn default btn-default btn btn-default'][contains(text(),'Close')]"));
		logger.info("MTK060 screen closed");
		driver.switchTo().defaultContent();
		return new HomePage(driver, dataFileName);
	}

}
