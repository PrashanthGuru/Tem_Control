package com.ibsplc.pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP112 extends BasePage{
	
	public String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String FRAME = "iCargoContentFrameCAP112";    
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;
	public CAP112(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }
	
	private By txt_ReqID,
				btn_list,
				btn_Approve,
				btn_Reject,
				txt_rmrks,
				btn_alt_save,
				tbl_req,
				yesBtn,
				btn_close,
				txt_fltNo,
				txt_startDate,
				txt_endDate,
				txt_weight,
				txt_vol,
				btn_PartApprove,
				txt_weightPer,
				txt_volPer,
				btn_Partial_Ok,
				btn_save,
				txt_carrCode;
	
	
	private void initElements()
	{
		txt_ReqID= MiscUtility.getWebElement(objFilepath,"CAP112_txt_reqID");
		btn_list= MiscUtility.getWebElement(objFilepath,"CAP112_btn_list");
		btn_Approve= MiscUtility.getWebElement(objFilepath,"CAP112_btn_Approve");
		btn_Reject= MiscUtility.getWebElement(objFilepath,"CAP112_btn_Reject");
		tbl_req= MiscUtility.getWebElement(objFilepath,"CAP112_tbl_reqs");
		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		btn_close= MiscUtility.getWebElement(objFilepath, "CAP112_btn_close");
		txt_rmrks= MiscUtility.getWebElement(objFilepath, "CAP112_txt_remarks");
		btn_alt_save=MiscUtility.getWebElement(objFilepath, "CAP112_btn_saveRemarks");
		txt_fltNo=MiscUtility.getWebElement(objFilepath, "CAP112_txt_fltNo");
		txt_startDate=MiscUtility.getWebElement(objFilepath, "CAP112_txt_startDate");
		txt_endDate=MiscUtility.getWebElement(objFilepath, "CAP112_txt_endDate");
		txt_weight=MiscUtility.getWebElement(objFilepath, "CAP112_txt_weight");
		txt_vol=MiscUtility.getWebElement(objFilepath, "CAP112_txt_vol");
		btn_PartApprove=MiscUtility.getWebElement(objFilepath, "CAP112_btn_PartApprove");
		txt_weightPer=MiscUtility.getWebElement(objFilepath, "CAP112_txt_weightPer");
		txt_volPer=MiscUtility.getWebElement(objFilepath, "CAP112_txt_volPer");
		btn_Partial_Ok=MiscUtility.getWebElement(objFilepath, "CAP112_btn_partOk");
		btn_save=MiscUtility.getWebElement(objFilepath, "CAP112_btn_save");
		txt_carrCode = MiscUtility.getWebElement(objFilepath, "CAP112_txt_carrCode");
	}
	
	public CAP112 listAndApproveReject(String reqId,boolean statusApprove) 
	{
		reqId= PropertyHandler.getPropValue(dataFilePath, reqId);
		minWait();
		//enterKeys(txt_ReqID, reqId);
		click(btn_list);
		minWait();
		if(verifyElementPresent(tbl_req))
			
			tblClickByColValWithRef(tbl_req, 1, 3, reqId);
			
		if(statusApprove)
		{
			click(btn_Approve);
			driver.switchTo().defaultContent();
			minWait();
			waitForNewWindow(2);
			minWait();
			switchToSecondWindow();
			minWait();
			enterKeys(txt_rmrks, "Approved");
			click(btn_alt_save);
		}
		else
		{
			click(btn_Reject);
			driver.switchTo().defaultContent();
			minWait();
			waitForNewWindow(2);
			minWait();
			switchToSecondWindow();
			minWait();
			enterKeys(txt_rmrks, "Rejected");
			click(btn_alt_save);
		}
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		if(statusApprove)
		{
			String status=tblGetTextByColValue_input(tbl_req, 29, 3, reqId);
			System.out.println(status);
			Assert.assertTrue(status.equalsIgnoreCase("Approved"),"Status should be Approved");
		}
		else
		{
			String status=tblGetTextByColValue_input(tbl_req, 29, 3, reqId);
			System.out.println(status);
			Assert.assertTrue(status.equalsIgnoreCase("Rejected"),"Status should be Rejected");
		}
		return this;
	}
	
	public CAP112 listAndPartiallyApprove(String reqId)
	{
		reqId= PropertyHandler.getPropValue(dataFilePath, reqId);
		click(btn_list);
		minWait();
		if(verifyElementPresent(tbl_req))
			
			tblClickByColValWithRef(tbl_req, 1, 3, reqId);
		
		click(btn_PartApprove);
		driver.switchTo().defaultContent();
		minWait();
		waitForNewWindow(2);
		minWait();
		switchToSecondWindow();
		minWait();
		enterKeys(txt_weightPer, "50");
		enterKeys(txt_volPer, "5");
		scrollToView(txt_rmrks);
		enterKeys(txt_rmrks, "Partially Approved");
		click(btn_Partial_Ok);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		//String status=tblGetTextByColValue_input(tbl_req, 24, 3, reqId);
		String status=tblGetTextByColValue_input(tbl_req, 28, 3, reqId);
		System.out.println(status);
		Assert.assertTrue(status.equalsIgnoreCase("Partially Approved"),"Status should be Approved");
		return this;
	}
	
	public CAP112 verifyAlotmentDetails(String altId, String stn, String fltNo, String startDate, String endDate, String weight, String vol)
	{
		altId= PropertyHandler.getPropValue(dataFilePath, altId);
		stn= PropertyHandler.getPropValue(dataFilePath, stn);
		fltNo= PropertyHandler.getPropValue(dataFilePath, fltNo);
		startDate= PropertyHandler.getPropValue(dataFilePath, startDate);
		endDate= PropertyHandler.getPropValue(dataFilePath, endDate);
		weight= PropertyHandler.getPropValue(dataFilePath, weight);
		vol= PropertyHandler.getPropValue(dataFilePath, vol);
		
		click(btn_list);
		minWait();
		WebElement element=tblClickByColValWithRef(tbl_req, 2, 3, altId);
		doubleClick(element);
		//doubleClick(tblClickByColValWithRef(tbl_req, 2, 3, altId));
		
		Assert.assertTrue(fltNo.equalsIgnoreCase(waitForElement(txt_fltNo).getAttribute("value")), "Flight number should be same as front end");
		Assert.assertTrue(startDate.equalsIgnoreCase(waitForElement(txt_startDate).getAttribute("value")), "Start Date should be same as front end");
		Assert.assertTrue(endDate.equalsIgnoreCase(waitForElement(txt_endDate).getAttribute("value")), "End Date should be same as front end");
		Assert.assertTrue(weight.equalsIgnoreCase(waitForElement(txt_weight).getAttribute("value")), "Weight should be same as front end");
		
		
		
		
		return this;
	}
	
	/**
	 * Method to list a Flight and verify the allotment request present
	 * @param carrCode
	 * @param fltNum
	 * @param allotmentID
	 * @return
	 * @author A-7868 Krishna <15/05/2018>
	 */
	public CAP112 listFltAndVerifyAllotmentReq(String carrCode, String fltNum, String allotmentID){
		
		carrCode= PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNum= PropertyHandler.getPropValue(dataFilePath, fltNum);
		allotmentID= PropertyHandler.getPropValue(dataFilePath, allotmentID);
		
		enterKeys(txt_carrCode, carrCode);
		enterKeys(txt_fltNo, fltNum);
		click(btn_list);
		minWait();
		
		Assert.assertTrue(getTableCellTextValue(tbl_req, 3, 1).contains(allotmentID), "ERROR : Allotment request mismatch.");
		
		return this;
		
	}
	
	public CAP112 modifyAllotmentDetails(String altId, String wt, String vol)
	{
		altId= PropertyHandler.getPropValue(dataFilePath, altId);
		wt= PropertyHandler.getPropValue(dataFilePath, wt);
		vol= PropertyHandler.getPropValue(dataFilePath, vol);
		click(btn_list);
		WebElement element=tblClickByColValWithRef(tbl_req, 2, 3, altId);
		doubleClick(element);
		
		enterKeys(txt_weight,wt);
		enterKeys(txt_vol, vol);
		
		click(btn_save);
		
		
		return this;
	}
	 public HomePage close() {

	      if (verifyElementPresent(btn_close)&&verifyElementVisible(btn_close))    	
	          click(btn_close);
	      else
	    	 minWait();
	  		Actions action = new Actions(driver);
	  		action.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).perform(); 

	      driver.switchTo().defaultContent();
	      if (verifyElementPresent(yesBtn))
	          click(yesBtn);
	      return new HomePage(driver, dataFileName);
	  }
}
