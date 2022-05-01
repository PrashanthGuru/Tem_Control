package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * CAP142 - LIST BOOKINGS SCREEN
 * 
 * @author A-7868
 *
 */
public class CAP142 extends BasePage{

	
	 private static String FRAME = "iCargoContentFrameCAP142";
	    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
	    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

	    private WebDriver driver;
	    private String dataFileName;

	    private By
	    		txt_awbPre,
	    		txt_awbNo,
	    		btn_list,
	    		btn_clear,
	    		link_moreOption,
	    		tbl_listBkg,
	    		btn_moreOption_details,
	    		btn_moreOption_reject,
	    		btn_moreOption_reopen,
	    		btn_close,
	    		lnk_moreOptions,
	    		dropdown_fltStatus,
	    		chk_fltStatusOptions,
	    		txt_bkgToDate,
		    	txt_bkgFromDate,
	    		link_moreOptions,
	    		txt_reasonCode,
	    		link_expand,
	    		info_reasonCode
	    		;

	    private By info_footerMsg,
	            btn_genericOk,
	            yesBtn;

	    public CAP142(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initPageElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        this.dataFileName = dataFileName;
	    }

	    /**
	     * Method to initialize page objects
	     */
	    private void initPageElements() {

	    	txt_awbPre = MiscUtility.getWebElement(objFilepath, "CAP142_txt_awbPre");
	    	txt_awbNo = MiscUtility.getWebElement(objFilepath, "CAP142_txt_awbNo");
	    	btn_list = MiscUtility.getWebElement(objFilepath, "CAP142_btn_list");
	    	btn_clear = MiscUtility.getWebElement(objFilepath, "CAP142_btn_clear");
	    	link_moreOption = MiscUtility.getWebElement(objFilepath, "CAP142_link_moreOption");
	    	tbl_listBkg = MiscUtility.getWebElement(objFilepath, "CAP142_tbl_listBkg");
	    	btn_moreOption_details = MiscUtility.getWebElement(objFilepath, "CAP142_btn_moreOption_details");
	    	btn_moreOption_reject = MiscUtility.getWebElement(objFilepath, "CAP142_btn_moreOption_reject");
	    	btn_moreOption_reopen = MiscUtility.getWebElement(objFilepath, "CAP142_btn_moreOption_reopen");
	    	btn_close = MiscUtility.getWebElement(objFilepath, "CAP142_btn_close");	
	    	link_expand=MiscUtility.getWebElement(objFilepath, "CAP142_link_expand");
	    	info_reasonCode=MiscUtility.getWebElement(objFilepath, "CAP142_info_reasonCode");

	    	link_moreOptions=MiscUtility.getWebElement(objFilepath, "CAP142_link_moreOptions");
	    	txt_reasonCode=MiscUtility.getWebElement(objFilepath, "CAP142_txt_reasonCode");


	    	lnk_moreOptions = MiscUtility.getWebElement(objFilepath, "CAP142_lnk_moreOptions");
	    	dropdown_fltStatus = MiscUtility.getWebElement(objFilepath, "CAP142_dropdown_fltStatus");
	    	chk_fltStatusOptions = MiscUtility.getWebElement(objFilepath, "CAP142_chk_fltStatusOptions");
	    	txt_bkgToDate = MiscUtility.getWebElement(objFilepath, "CAP142_txt_bkgToDate");
	    	txt_bkgFromDate	= MiscUtility.getWebElement(objFilepath, "CAP142_txt_bkgFromDate");
	    	
	        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
	        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
	        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
	    }
	    
	    /**
	     * Method to list an awb and reject it
	     * @param awbPre
	     * @param awbNo
	     * @return
	     * @author A-7868 Krishna <24/04/2018>
	     */
	    public CAP142 rejectBooking(String awbPre, String awbNo){
	    	
	    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
	    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
	    	
	    	enterKeys(txt_awbPre, awbPre);
	    	enterKeys(txt_awbNo, awbNo);
	    	click(btn_list);
	    	minWait();
	    	
	    	click(link_moreOption);
	    	click(btn_moreOption_reject);
	    	minWait();
	    	
	    	String xpath = "./tbody/tr[1]/child::td[5]/label/em/i"; //red button
	    	Assert.assertTrue(waitForElement(tbl_listBkg).findElement(By.xpath(xpath)).getAttribute("class").equalsIgnoreCase("popover-icon icon rejected "), "ERROR : AWB NOT Rejected");
	    	return this;
	    }

	    /**
	     * Method to list an AWB and click on Details to navigate to CAP018 screen
	     * @param awbPre
	     * @param awbNo
	     * @return
	     * @author A-7868 Krishna <25/04/2018>
	     */
	    public CAP018 gotoDetails(String awbPre, String awbNo){
	    	
	    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
	    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
	    	
	    	enterKeys(txt_awbPre, awbPre);
	    	enterKeys(txt_awbNo, awbNo);
	    	click(btn_list);
	    	minWait();
	    	
	    	click(link_moreOption);
	    	click(btn_moreOption_details);
	    	minWait();
	    	
	    	return new CAP018(driver, dataFileName);
	    }
	    
	    /**
	     * Method to list an AWB , click Reopen button and navigate to CAP018
	     * @param awbPre
	     * @param awbNo
	     * @return
	     * @author A-7868 Krishna <25/04/2018>
	     */
	    public CAP018 reOpenBooking(String awbPre, String awbNo){
	    	
	    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
	    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
	    	
	    	enterKeys(txt_awbPre, awbPre);
	    	enterKeys(txt_awbNo, awbNo);
	    	click(btn_list);
	    	minWait();
	    	
	    	click(link_moreOption);
	    	click(btn_moreOption_reopen);
	    	minWait();
	    		    	
	    	return new CAP018(driver, dataFileName);	    	
	    }
	    /**
	     * Method to check booking status
	     * @param awbPre
	     * @param awbNo
	     * @param status
	     * @return
	     * @author A-7868
	     */
	    public CAP142 checkBookingStatus(String awbPre, String awbNo, String status){
	    	
	    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
	    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
	    	
	    	enterKeys(txt_awbPre, awbPre);
	    	enterKeys(txt_awbNo, awbNo);
	    	click(btn_list);
	    	minWait();
	    	
	    	String xpath = "./tbody/tr[1]/td[8]"; //status field
	    	Assert.assertTrue(waitForElement(tbl_listBkg).findElement(By.xpath(xpath)).getText().equalsIgnoreCase(status), "ERROR : Status mismatch");
	    	    
	    	return this;
	    }
	    /**
	     * 
	     * @param awbPre
	     * @param awbNo
	     * @param reasoncode
	     * @return
	     */
       public CAP142 checkBookingqueuedReason(String awbPre, String awbNo, String filterCode,String reasoncode){
	    	
	    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
	    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
	    	filterCode=PropertyHandler.getPropValue(dataFilePath, filterCode);
	    	
	    	
	    	enterKeys(txt_awbPre, awbPre);
	    	enterKeys(txt_awbNo, awbNo);
	    	
	    	click(link_moreOptions);
	    	minWait();
	    	enterKeys(txt_reasonCode, filterCode);
	    	

	    	click(btn_list);
	    	minWait();
	    	
	    	click(link_expand)   ;
	    	Assert.assertTrue(waitForElement(tbl_listBkg).getText().contains(awbNo));
	    	Assert.assertTrue(waitForElement(info_reasonCode).getText().contains(reasoncode));
	    	
	    	return this;
	    }
 
	    /**
	     * Method to check Booking details
	     * @param awbPre
	     * @param awbNo
	     * @param status
	     * @param reasonCode
	     * @return
	     * @author A-7868 Krishna <30/05/2018>
	     */
	    public CAP142 checkBookingDetails(String awbPre, String awbNo, String status, String reasonCode){
	    	
	    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
	    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
	    	
	    	enterKeys(txt_awbPre, awbPre);
	    	enterKeys(txt_awbNo, awbNo);
	    	click(btn_list);
	    	minWait();
	    	
	    	String xpath = "./tbody/tr[1]/td[8]"; //status field
	    	Assert.assertTrue(waitForElement(tbl_listBkg).findElement(By.xpath(xpath)).getText().equalsIgnoreCase(status), "ERROR : Status mismatch");
	    	//link to expand booking details
	    	xpath = "./tbody/tr[1]/td[1]/a/i";
	    	click(waitForElement(tbl_listBkg).findElement(By.xpath(xpath)));
	    	//ReasonCode label
	    	xpath = "//*[@id='Reason Code']/em";
	    	Assert.assertTrue(driver.findElement(By.xpath(xpath)).getText().trim().equalsIgnoreCase(reasonCode), "ERROR : Reason Code mismatch");
	    	
	    	return this;
	    }

	    /**
	     * Method to check the Flight Status field and its options available
	     * @return
	     * @author A-7868 Krishna <29/06/2018>
	     */
	    public CAP142 checkFlightStatusFieldPresent(){
	    	
	    	click(lnk_moreOptions);
	    	minWait();
	    	click(dropdown_fltStatus);
	    	minWait();
	    	List<WebElement> options = driver.findElements(chk_fltStatusOptions);
	    	String xpath;
	    	xpath = ".//following-sibling::span[contains(.,'Active')]";
	    	Assert.assertTrue(waitForElement(chk_fltStatusOptions).findElement(By.xpath(xpath)).isDisplayed(), "Active status not displayed under Flight Status Filter");
	    	xpath = ".//following-sibling::span[contains(.,'Canceled')]";
	    	Assert.assertTrue(driver.findElements(chk_fltStatusOptions).get(1).findElement(By.xpath(xpath)).isDisplayed(), "Canceled status not displayed under Flight Status Filter");
	    	xpath = ".//following-sibling::span[contains(.,'To be actioned')]";
	    	Assert.assertTrue(driver.findElements(chk_fltStatusOptions).get(2).findElement(By.xpath(xpath)).isDisplayed(), "To be actioned status not displayed under Flight Status Filter");
	    	xpath = ".//following-sibling::span[contains(.,'To be cancelled')]";
	    	Assert.assertTrue(driver.findElements(chk_fltStatusOptions).get(3).findElement(By.xpath(xpath)).isDisplayed(), "To be cancelled status not displayed under Flight Status Filter");
	    	
	    	return this;
	    }
	    
	    /**
	     * Method to list with flight status and check whether a particular flight is listed
	     * @param sDate
	     * @param eDate
	     * @param flightStatus
	     * @param fltNum
	     * @return
	     * @author A-7868 Krishna <29/06/2018>
	     */
	    public CAP142 listWithFlightStatus(String sDate, String eDate, String flightStatus, String fltNum){
	    	
	    	sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
	    	eDate = PropertyHandler.getPropValue(dataFilePath, eDate);
	    	fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
	    	
	    	enterKeys(txt_bkgFromDate, sDate);
	    	enterKeys(txt_bkgToDate, eDate);
	    	click(lnk_moreOptions);
	    	click(dropdown_fltStatus);
	    	String xpath = ".//span[contains(.,'"+flightStatus+"')]/preceding-sibling::input[1]";
	    	click(By.xpath(xpath));
	    	click(btn_list);
	    	maxWait();
	    	boolean flag = false;
	    	
	    	for(String flt : getTableColumnValues(tbl_listBkg, 5)){
	    			
	    		if(flt.contains(fltNum)){
	    			flag = true;
	    			break;
	    		}	    		
	    	}
	    	
	    	Assert.assertTrue(flag, "Flight not listed.");
	    	return this;
	    }
	    
	    /**
	     * Method to clear screen
	     * @return
	     * @author A-7868
	     */
	    public CAP142 clear(){
	    	
	    	click(btn_clear);
	    	minWait();
	    	return this;
	    }
	    
	    /**
	     * Method to close current page and return to Homepae
	     * returns the instance of Homepage
	     *
	     * @return
	     * @author A-7868
	     */
	    public HomePage close() {

	        click(btn_close);
	        driver.switchTo().defaultContent();
	        if (verifyElementPresent(yesBtn)) {

	            click(yesBtn);
	        }
	        return new HomePage(driver, dataFileName);
	    }
}
