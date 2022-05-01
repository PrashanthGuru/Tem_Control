package com.ibsplc.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * 
 * @author A-7868
 *
 */
public class CAP026 extends BasePage {

	private final static Logger logger = Logger.getLogger(BasePage.class);	   
	
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameCAP026";
    public static By popupFrame = By.id("popupContainerFrame");
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;
    
    private By txt_fltCarCode,
    			txt_fltNo,
    			txt_fromDt,
    			txt_toDt,
    			btn_list,
    			btn_clear,
    			btn_close,
    			btn_genericYes,
    			btn_genericOk,
    			Generic_info_msg,
    			info_error,
    			btn_viewCapSmry,
    			tbl_listFlt,
    			btn_viewSmry_close;
    
    public CAP026(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    /**
     * Initializes the webelements
     *
     * @author A-7868
     */
    private void initElements() {
        txt_fltCarCode = MiscUtility.getWebElement(objFilepath, "CAP026_txt_fltCarCode");
        txt_fltNo = MiscUtility.getWebElement(objFilepath, "CAP026_txt_fltNo");
        txt_fromDt = MiscUtility.getWebElement(objFilepath, "CAP026_txt_fromDt");
        txt_toDt = MiscUtility.getWebElement(objFilepath, "CAP026_txt_toDt");
        btn_list = MiscUtility.getWebElement(objFilepath, "CAP026_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "CAP026_btn_clear");
        btn_close = MiscUtility.getWebElement(objFilepath, "CAP026_btn_close");
        tbl_listFlt = MiscUtility.getWebElement(objFilepath, "CAP026_tbl_listFlt");
        btn_viewCapSmry = MiscUtility.getWebElement(objFilepath, "CAP026_btn_viewCapSmry");
        btn_viewSmry_close = MiscUtility.getWebElement(objFilepath, "CAP026_btn_viewSmry_close");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        Generic_info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        
    }
    
    /**
     * Method to list a flight, get the Capacity Utilised perc (wt and vol) for given segment and store it in the parameters (wtPerc, volPerc)
     * @param carrCode
     * @param fltNum
     * @param sDate
     * @param eDate
     * @param segment
     * @param wtPerc (output)
     * @param volPerc (output)
     * @return
     * @author A-7868 Krishna <06/07/2018>
     */
    public CAP026 getCapacityUtilizedPerc(String carrCode, String fltNum, String sDate, String eDate, String segment, String wtPerc, String volPerc){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
    	fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
    	sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
    	eDate = PropertyHandler.getPropValue(dataFilePath, eDate);
    	segment = PropertyHandler.getPropValue(dataFilePath, segment);
    	
    	enterKeys(txt_fltCarCode, carrCode);
        enterKeys(txt_fltNo, fltNum);
        enterKeys(txt_fromDt, sDate);
        enterKeys(txt_toDt, eDate);
        click(btn_list);
        
        minWait();
        String perc = tblGetTextByColValue(tbl_listFlt, 38, 4, segment);
        PropertyHandler.setPropValue(dataFilePath, wtPerc, perc);
        perc = tblGetTextByColValue(tbl_listFlt, 39, 4, segment);
        PropertyHandler.setPropValue(dataFilePath, volPerc, perc);
        
    	return this;
    }
    
    /**
     * Method to get the Capacity Utilised perc (wt and vol) for given segment and store it in the parameters (wtPerc, volPerc)
     * This Method doesn't list the flight. Gets data if already listed
     * @param segment
     * @param wtPerc
     * @param volPerc
     * @return
     * @author A-7868
     */
    public CAP026 getCapacityUtilizedPerc(String segment, String wtPerc, String volPerc){
    	
    	segment = PropertyHandler.getPropValue(dataFilePath, segment);

    	String perc = tblGetTextByColValue(tbl_listFlt, 38, 4, segment);
    	logger.info("Utilised Wt perc for "+segment+"="+perc);
        PropertyHandler.setPropValue(dataFilePath, wtPerc, perc);
        perc = tblGetTextByColValue(tbl_listFlt, 39, 4, segment);
        logger.info("Utilised Vol perc for "+segment+"="+perc);
        PropertyHandler.setPropValue(dataFilePath, volPerc, perc);
        
    	return this;
    }
    
    /**
     * Method to get Confirmed Bkg wt and vol from list flights table
     * This Method doesn't list the flight. Gets data if already listed
     * @param segment
     * @param totBkdWt
     * @param totBkdVol
     * @return
     * @author A-7868
     */
    public CAP026 getSegmentTotalBookedCapacity(String segment, String totBkdWt, String totBkdVol){
    	
    	segment = PropertyHandler.getPropValue(dataFilePath, segment);
    	
    	minWait();
    	String data = tblGetTextByColValue(tbl_listFlt, 9, 4, segment);
    	logger.info("Booked Weight for "+segment+"="+data);
        PropertyHandler.setPropValue(dataFilePath, totBkdWt, data);
        data = tblGetTextByColValue(tbl_listFlt, 10, 4, segment);
        logger.info("Booked Volume for "+segment+"="+data);
        PropertyHandler.setPropValue(dataFilePath, totBkdVol, data);        
    	return this;
    }
    
    /**
     * Method to get the total Wt and vol for a segment using the formula:
     * 
     * Total Weight for that segment should be calculated as: Provided Capacity Weight Sales for that segment+ Total Allotment Weight Capacity for that segment.
     * 
     * Total Volume for that segment should be calculated as: Provided Capacity Volume for that segment+ Total Allotment Volume Capacity for that segment.
     * 
     * and writes the value to parameters totWtforSegment, totVolforSegment
     * 
     * @param carrCode
     * @param fltNum
     * @param sDate
     * @param eDate
     * @param segment
     * @param segmentNum (For AAA-BBB-CCC, AAA-BBB => 1, AAA-CCC => 2, BBB-CCC => 3)
     * @param totWtforSegment (output)
     * @param totVolforSegment (output)
     * @return
     * @author A-7868 Krishna <06/07/2018>
     */
    public CAP026 getTotalWtVolForSegment(String carrCode, String fltNum, String sDate, String eDate, String segment, String segmentNum, String totWtforSegment, String totVolforSegment){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
    	fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
    	sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
    	eDate = PropertyHandler.getPropValue(dataFilePath, eDate);
    	segment = PropertyHandler.getPropValue(dataFilePath, segment);
    	
    	enterKeys(txt_fltCarCode, carrCode);
        enterKeys(txt_fltNo, fltNum);
        enterKeys(txt_fromDt, sDate);
        enterKeys(txt_toDt, eDate);
        click(btn_list);

        minWait();
        tblSelectRowByColValue(tbl_listFlt, 1, 4, segment);
    	click(btn_viewCapSmry);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	
    	String wt1 = driver.findElements(By.xpath("//td[contains(text(),'Provided Capacity - Sales')]/following-sibling::td[1]")).get(Integer.parseInt(segmentNum)-1).getText();
    	String wt2 = driver.findElements(By.xpath("//td[contains(text(),'Total Allotment')]/following-sibling::td[1]")).get(Integer.parseInt(segmentNum)-1).getText();
    	int wt = Integer.parseInt(wt1) + Integer.parseInt(wt2);
    	logger.info(wt1+" + "+wt2+" = "+wt);
    	
    	String vol1 = driver.findElements(By.xpath("//td[contains(text(),'Provided Capacity - Sales')]/following-sibling::td[2]")).get(Integer.parseInt(segmentNum)-1).getText();
    	String vol2 = driver.findElements(By.xpath("//td[contains(text(),'Total Allotment')]/following-sibling::td[2]")).get(Integer.parseInt(segmentNum)-1).getText();
    	int vol = Integer.parseInt(vol1) + Integer.parseInt(vol2);
    	logger.info(vol1+" + "+vol2+" = "+vol);
    	
    	PropertyHandler.setPropValue(dataFilePath, totWtforSegment, String.valueOf(wt));
    	PropertyHandler.setPropValue(dataFilePath, totVolforSegment, String.valueOf(vol));
    	
    	click(btn_viewSmry_close);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	
    	return this;
    }
    
    /**
     * Method to list a flight with sdate and edate
     * @param carrCode
     * @param fltNum
     * @param sDate
     * @param eDate
     * @return
     * @author A-7868
     */
    public CAP026 list(String carrCode, String fltNum, String sDate, String eDate){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
    	fltNum = PropertyHandler.getPropValue(dataFilePath, fltNum);
    	sDate = PropertyHandler.getPropValue(dataFilePath, sDate);
    	eDate = PropertyHandler.getPropValue(dataFilePath, eDate);
    	
    	enterKeys(txt_fltCarCode, carrCode);
        enterKeys(txt_fltNo, fltNum);
        enterKeys(txt_fromDt, sDate);
        enterKeys(txt_toDt, eDate);
        click(btn_list);
        minWait();
        return this;
    }
      
    /**
     * Method to perform the perc calculation and compare the result with passed perc value
     * @param bkd
     * @param total
     * @param utilPerc
     * @return
     * @author A-7868
     */
    public CAP026 calculateAndCompareUtilizedCapacityPerc(String bkd, String total, String utilPerc){
    	
    	bkd = PropertyHandler.getPropValue(dataFilePath, bkd);
    	total = PropertyHandler.getPropValue(dataFilePath, total);
    	utilPerc = PropertyHandler.getPropValue(dataFilePath, utilPerc);
    	
    	double expected =  (double) ( Float.parseFloat(bkd) / Float.parseFloat(total) ) * 100;
    	double actual = (double) Float.parseFloat(utilPerc);
    	logger.info("expected ("+expected+") actual ("+utilPerc+")"); 
    	if(Math.abs(expected-actual) > 0.01)    	
    		Assert.fail("Calculated value not equal to actual value");
    	return this;
    }
    /**
     * Method to clear screen contents
     */
    public CAP026 clear() {

       try{
    	   click(btn_clear);
       }catch(Exception e){
	       click(By.xpath("//*[@id='main_filter_Info_Id']/div/div/div/div/div[2]/a"));
	       click(btn_clear);
       }
        minWait();
        return this;
    }
    
    /**
     * Closes the screen and go to home screen
     *
     * @return
     * @author A-7868
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
    
}