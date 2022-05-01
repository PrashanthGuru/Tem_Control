package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP145 extends BasePage{
	
	 	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
	    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	    
	    private String  screenFrame="iCargoContentFrameCAP145", 
	    				screenFrame2="iCargoContentFrameCAP027";
	    private String dataFileName;
	    private WebDriver driver;
	    
	    public CAP145(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        this.dataFileName = dataFileName;
	    }
	    
	    private By txt_fltNum,
	    			txt_fltStartDate,
	    			txt_fltEndDate,
	    			label_MoreOpt,
	    			btn_list,
	    			list_flights,
	    			btn_reAssign,
	    			tbl_confirmedBooking,
	    			txt_reAssignOrigin,
	    			txt_reAssignDest,
	    			btn_reAssignList,
	    			tbl_reAssignFlights,
	    			btn_reAssignOk,
	    			btn_genericYes,
	    			btn_CAP027clear,
	    			txt_fltNoCAP027,
	    			txt_fltDtCAP027,
	    			btn_CAP027list;
	    
	    private void initElements()
	    {
	    	txt_fltNum=MiscUtility.getWebElement(objFilepath, "CAP145_txt_fltNum");
	    	txt_fltStartDate=MiscUtility.getWebElement(objFilepath, "CAP145_txt_fltFromDate");
	    	txt_fltEndDate=MiscUtility.getWebElement(objFilepath, "CAP145_txt_fltToDate");
	    	label_MoreOpt=MiscUtility.getWebElement(objFilepath, "CAP145_label_moreOption");
	    	btn_list=MiscUtility.getWebElement(objFilepath, "CAP145_btn_list");
	    	list_flights=MiscUtility.getWebElement(objFilepath, "CAP145_list_fligts");
	    	btn_reAssign=MiscUtility.getWebElement(objFilepath, "CAP145_btn_reAssignCAP027");
	    	tbl_confirmedBooking = MiscUtility.getWebElement(objFilepath, "CAP145_tbl_confirmedBooking");
	    	 txt_reAssignOrigin= MiscUtility.getWebElement(objFilepath, "CAP027_txt_OriginReassin");
	         txt_reAssignDest= MiscUtility.getWebElement(objFilepath, "CAP145_txt_DestReAssign");
	         btn_reAssignList= MiscUtility.getWebElement(objFilepath, "CAP145_btn_listReAssign");
	         tbl_reAssignFlights= MiscUtility.getWebElement(objFilepath, "CAP145_tbl_ReAssignFlightList");
	         btn_reAssignOk= MiscUtility.getWebElement(objFilepath, "CAP145_btn_reAssign_Ok");
	         btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
	         btn_CAP027clear=MiscUtility.getWebElement(objFilepath, "CAP145_btn_CAP027Clear");
	         txt_fltNoCAP027=MiscUtility.getWebElement(objFilepath, "CAP145_txt_fltNoCAP027");
	         txt_fltDtCAP027=MiscUtility.getWebElement(objFilepath, "CAP145_txt_fltDtCAP027");
	         btn_CAP027list=MiscUtility.getWebElement(objFilepath, "CAP145_btn_CAP027List");
	    	
	    }
	    
	    public CAP145 listFlight(String fltNum, String flt_startDate,String flt_eDate, String fltNum2)
	    {
	    	fltNum=PropertyHandler.getPropValue(dataFilePath, fltNum);
	    	flt_startDate=PropertyHandler.getPropValue(dataFilePath, flt_startDate);
	    	fltNum2=PropertyHandler.getPropValue(dataFilePath, fltNum2);
	    	flt_eDate=PropertyHandler.getPropValue(dataFilePath, flt_eDate);
	    	
	    	enterKeys(txt_fltStartDate, flt_startDate);
	    	enterKeys(txt_fltEndDate, flt_eDate);
	    	click(label_MoreOpt);
	    	minWait();
	    	enterKeys(txt_fltNum, fltNum);
	    	click(btn_list);
	    	minWait();
	    	List<WebElement> flights= getWebElements(list_flights);
	    	for(int i=0;i<flights.size();i++)
	    	{
	    		if(flights.get(i).getText().contains(fltNum))
	    		{
	    			flights.get(i).click();
	    			break;
	    		}
	    	}
	    	
	    	
	    	waitForElement(btn_reAssign);
	    	String awbNo="";
	    	awbNo=getTableCellTextValue(tbl_confirmedBooking, 3, 1);
	    	tblClickByColInput(tbl_confirmedBooking, 1);
	    	click(btn_reAssign);
	    	driver.switchTo().defaultContent();
	    	waitForNewWindow(2);
	    	switchToSecondWindow();
	    	tblClickByColValWithRef(tbl_reAssignFlights, 1, 2, fltNum);
	    	
	    	
	    	click(btn_reAssignOk);
	    	if(verifyElementPresent(btn_genericYes))
	    		click(btn_genericYes);
	    	switchToFirstWindow();
	    	waitForFrameAndSwitch(screenFrame);
	    	click(btn_CAP027clear);
	    	enterKeys(txt_fltNoCAP027, fltNum2);
	    	enterKeys(txt_fltDtCAP027, flt_startDate);
	    	click(btn_CAP027list);
	    	String awbNumber2=getTableCellTextValue(tbl_confirmedBooking, 3, 1);
	    	Assert.assertTrue(awbNo.equals(awbNumber2),"Air way Bill should be same for the booking");
	    	
	    	return this;
	    }

}
