package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP147 extends BasePage{
	
	 	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
	    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	    
	    private String  screenFrame="iCargoContentFrameCAP147", 
	    				screenFrame2="iCargoContentFrameCAP027";
	    private String dataFileName;
	    private WebDriver driver;
	    
	    public CAP147(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        this.dataFileName = dataFileName;
	    }
	    
	    private By txt_fltNum, txt_fltDt, btn_list, btn_genericYes, btn_close;
	    
	    private void initElements()
	    {
	    	txt_fltNum = MiscUtility.getWebElement(objFilepath, "CAP147_txt_fltNum");
	    	txt_fltDt = MiscUtility.getWebElement(objFilepath, "CAP147_txt_fltDt");
	    	btn_list = MiscUtility.getWebElement(objFilepath, "CAP147_btn_list");
	    	btn_genericYes = MiscUtility.getWebElement(genObjPath,
					"Generic_btn_diaYes");
	    	btn_close = MiscUtility.getWebElement(objFilepath, "CAP147_btn_close");
	    	
	    }
	    
	    //Sharath
	    public CAP147 listFlight(String fltNum, String fltDt)
	    {
	    	/*fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
	    	fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);*/
	    	enterKeys(txt_fltNum,fltNum);
	    	enterKeys(txt_fltDt,fltDt);
//	    	click(btn_list);
	    	enterKeys(btn_list,Keys.F12);
	    	return this;
	    }
	    
	    //Sharath
	    public CAP147 reassignAltFlight(String fltNum, String fltDt, String flt2, String origin, String dest, String pcs, String wt, String awb)
	    {
	    	fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
	    	fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
	    	flt2 = PropertyHandler.getPropValue(dataFilePath, flt2);
	    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
	    	dest = PropertyHandler.getPropValue(dataFilePath, dest);
	    	pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
	    	wt = PropertyHandler.getPropValue(dataFilePath, wt);
	    	awb = PropertyHandler.getPropValue(dataFilePath, awb);
	    	maxWait();
	    	enterKeys(txt_fltNum,fltNum);
	    	enterKeys(txt_fltDt,fltDt);
//	    	click(btn_list);
	    	enterKeys(btn_list,Keys.F12);
	    	maxWait();
	    	maxWait();
//	    	String text = driver.findElement(By.xpath("(//div[@data-id='awbNumber'][strong])[1]")).getText();
	    	String pre = "//div[strong='001 - ";
	    	String suffix = "']/../../../div[1]/input";
//	    	click(By.xpath("//div[strong='001 - 36518554']"));
	    	click(By.xpath(pre+awb+suffix));
//	    	click(By.xpath("(//div[@role='rowgroup']//input[@type='checkbox'][@data-type='row-select'])[1]"));
	    	click(By.xpath("//button[text()='Select']/following-sibling::button"));
	    	click(By.xpath("//button[text()='Reassign']"));
	    	maxWait();
	    	waitForFrameAndSwitch("popupContainerFrame");
//	    	waitForElement(By.xpath("//input[@name='origin']"));
	    	maxWait();
	    	maxWait();
	    	maxWait();
	    	click(By.xpath("//span[text()='View']"));
	    	click(By.xpath("(//i[@class='icon ico-del'])[1]"));
	    	click(By.xpath("//button[text()='Add Flight']"));
	    	enterKeys(By.xpath("(//input[@data-btype='BT_FLIGHT_NUMBER'])[last()]"), flt2);
	    	enterKeys(By.xpath("(//input[@id='CMP_CAPACITY_BOOKING_SELECTFLIGHTS_FLIGHTDETAILS_ORIGIN'])[last()]"),origin);
	    	enterKeys(By.xpath("(//input[@id='CMP_CAPACITY_BOOKING_SELECTFLIGHTS_FLIGHTDETAILS_DESTINATION'])[last()]"),dest);
	    	enterKeys(By.xpath("(//input[@id='CMP_CAPACITY_BOOKING_SELECTFLIGHTS_FLIGHTDETAILS_FLIGHTDATE'])[last()]"),fltDt);
	    	enterKeys(By.xpath("(//input[@id='CMP_CAPACITY_BOOKING_SELECTFLIGHTS_FLIGHTDETAILS_PIECES'])[last()]"),pcs);
	    	enterKeys(By.xpath("(//input[@id='CMP_CAPACITY_BOOKING_SELECTFLIGHTS_FLIGHTDETAILS_WEIGHT'])[last()]"),wt);
	    	enterKeys(By.id("CMP_CAPACITY_BOOKING_SELECTFLIGHTS_FLIGHTDETAILS_ALLOTMENTID"),"FS");
	    	click(By.xpath("//button[text()='OK']"));
	    	maxWait();
	    	//add horizontal scroll
	    	waitForFrameAndSwitch("popupContainerFrame");
	    	maxWait();
	    	enterKeys(By.name("irregularityCode"),"Flight Change");
	    	enterKeys(By.xpath("//input[@name='pieces']"),pcs);
	    	enterKeys(By.xpath("//input[@name='weight']"),wt);
	    	click(By.xpath("(//div[@class='slimScrollArrowUpX'])[1]"));
	    	enterKeys(By.xpath("//textarea[@name='irregularityRemarks']"),"Flight Change");
	    	click(By.name("btnOk"));
	    	return this;
	    }
	    
		public HomePage close() {
			driver.switchTo().defaultContent();
			waitForFrameAndSwitch(screenFrame);
			click(btn_close);
			driver.switchTo().defaultContent();
			if (verifyElementPresent(btn_genericYes)) {

				click(btn_genericYes);
			}
			return new HomePage(driver, dataFileName);
		}

}
