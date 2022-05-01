package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP110 extends BasePage {

	public static String FRAME = "iCargoContentFrameCAP110";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    WebDriver driver;
    String screenFrame;
    String dataFileName;
        
    By
	    btn_list,
	    btn_clear,
	    btn_save,
	    btn_close,
	    txt_bkgDtls_origin,
	    txt_bkgDtls_destn,
	    link_uldDtls_add,
	    txt_uldDtls_uldType,
	    txt_uldDtls_noOfUlds,
	    dropdown_uldDtls_contour,
	    btn_getShipments,
	    txt_getShipments_awbPre,
	    txt_getShipments_awbNo,
	    txt_getShipments_fltFrmDate,
	    txt_getShipments_fltToDate,
	    txt_getShipments_origin,
	    btn_getShipments_list,
	    checkBox_getShipments_selectAll,
	    btn_getShipments_btnOk,
	    btn_validate,
	    dropdown_bookingType,
	    txt_bookingId,
	    msg_success,
	    info_msgClose,
	    yesBtn;
    
    
    public CAP110(WebDriver driver, String dataFileName) {
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
    	
    	btn_list            		= MiscUtility.getWebElement(objFilepath, "CAP110_btn_list");
    	btn_clear                   = MiscUtility.getWebElement(objFilepath, "CAP110_btn_clear"); 
    	txt_bkgDtls_origin          = MiscUtility.getWebElement(objFilepath, "CAP110_txt_bkgDtls_origin");
    	txt_bkgDtls_destn           = MiscUtility.getWebElement(objFilepath, "CAP110_txt_bkgDtls_destn");
    	link_uldDtls_add 			= MiscUtility.getWebElement(objFilepath, "CAP110_link_uldDtls_add");
    	txt_uldDtls_uldType       	= MiscUtility.getWebElement(objFilepath, "CAP110_txt_uldDtls_uldType");
    	txt_uldDtls_noOfUlds		= MiscUtility.getWebElement(objFilepath, "CAP110_txt_uldDtls_noOfUlds");
    	dropdown_uldDtls_contour   	= MiscUtility.getWebElement(objFilepath, "CAP110_dropdown_uldDtls_contour");
    	btn_getShipments 			= MiscUtility.getWebElement(objFilepath, "CAP110_btn_getShipments");
    	btn_save           			= MiscUtility.getWebElement(objFilepath, "CAP110_btn_save");
    	btn_close           		= MiscUtility.getWebElement(objFilepath, "CAP110_btn_close");
    	txt_getShipments_awbPre     = MiscUtility.getWebElement(objFilepath, "CAP110_txt_getShipments_awbPre");
    	txt_getShipments_awbNo      = MiscUtility.getWebElement(objFilepath, "CAP110_txt_getShipments_awbNo");
    	txt_getShipments_fltFrmDate = MiscUtility.getWebElement(objFilepath, "CAP110_txt_getShipments_fltFrmDate");
    	txt_getShipments_fltToDate	= MiscUtility.getWebElement(objFilepath, "CAP110_txt_getShipments_fltToDate");
    	txt_getShipments_origin     = MiscUtility.getWebElement(objFilepath, "CAP110_txt_getShipments_origin");
    	btn_getShipments_list  		= MiscUtility.getWebElement(objFilepath, "CAP110_btn_getShipments_list");
    	checkBox_getShipments_selectAll	= MiscUtility.getWebElement(objFilepath, "CAP110_checkBox_getShipments_selectAll");
    	btn_getShipments_btnOk 		= MiscUtility.getWebElement(objFilepath, "CAP110_btn_getShipments_btnOk");
    	btn_validate           		= MiscUtility.getWebElement(objFilepath, "CAP110_btn_validate");
    	dropdown_bookingType  		= MiscUtility.getWebElement(objFilepath, "CAP110_dropdown_bookingType");
    	txt_bookingId          		= MiscUtility.getWebElement(objFilepath, "CAP110_txt_bookingId");
    	
	    yesBtn			            = MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
	    info_msgClose 				= MiscUtility.getWebElement(genObjPath, "Generic_info_close");
	    msg_success 				= MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    }
    
    /**
     * Method to create a ULDBooking
     * 
     * @param origin
     * @param dest
     * @param uldType
     * @param noOfUlds
     * @param awbPre
     * @param awbNo
     * @param fromDate
     * @param toDate
     * @param bookingType
     * @param ULDBookingId
     * @return
     * 
     * @author a-7868 Krishna <01/02/2018>
     */
    public CAP110 createULDBookingId(String origin, String dest, String uldType, int noOfUlds, String awbPre,
    						String awbNo, String fromDate, String toDate, String bookingType, String ULDBookingId){
    	
    	
    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
    	dest = PropertyHandler.getPropValue(dataFilePath, dest);
    	uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	fromDate = PropertyHandler.getPropValue(dataFilePath, fromDate);
    	toDate = PropertyHandler.getPropValue(dataFilePath, toDate);
    	bookingType = PropertyHandler.getPropValue(dataFilePath, bookingType);
    	ULDBookingId = PropertyHandler.getPropValue(dataFilePath, ULDBookingId);
    	    	
    	click(btn_list);
    	minWait();
    	driver.switchTo().defaultContent();
    	click(yesBtn);
    	waitForFrameAndSwitch(FRAME);
    	
    	enterKeys(txt_bkgDtls_origin, origin);
    	enterKeys(txt_bkgDtls_destn, dest);
    	click(link_uldDtls_add);
    	enterKeys(txt_uldDtls_uldType, uldType);
    	enterKeys(txt_uldDtls_noOfUlds, String.valueOf(noOfUlds));
    	selectByIndex(dropdown_uldDtls_contour, 1);
    	click(btn_getShipments);
    	minWait();
    	//driver.switchTo().defaultContent();
     //   waitForNewWindow(2);
     //   switchToSecondWindow();
    	waitForFrameAndSwitch("popupContainerFrame");

        enterKeys(txt_getShipments_awbPre, awbPre);
        enterKeys(txt_getShipments_awbNo, awbNo);
        enterKeys(txt_getShipments_origin, origin);
        enterKeys(txt_getShipments_fltFrmDate, fromDate);
        enterKeys(txt_getShipments_fltToDate, toDate);
        click(btn_getShipments_list);
        minWait();
        check(checkBox_getShipments_selectAll);
        click(btn_getShipments_btnOk);
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        
        selectByText(dropdown_bookingType, bookingType);
        click(btn_validate);
        driver.switchTo().defaultContent();
        if(verifyElementPresent(yesBtn))
        		click(yesBtn);
        waitForFrameAndSwitch(FRAME);
        click(btn_save);
        minWait();
       String id = driver.findElement(txt_bookingId).getAttribute("value");
        Assert.assertFalse(id.isEmpty(), "ERROR : Booking ID NULL");
        PropertyHandler.setPropValue(dataFilePath, ULDBookingId, id);
    	
        click(btn_clear);
        return this;
    }
    
    /**
     * Method to close current page and return to Homepae
     * returns the instance of Homepage
     *
     * @return
     * @author a-7868
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
