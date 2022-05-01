package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/18/2017.
 */
public class CAP016 extends BasePage {

    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");


    WebDriver driver;
    String screenFrame;
    String dataFileName;

    By txt_awbPrefix,
    txt_awbNo,
    btn_list,
    chkBx_checkAll,
    btn_details,
    btn_reject,
    btn_close,
    tbl_bookingDtls,
    btn_clear,
    dropDown_status,
    // created byA-8254
    btn_cancel,
    Irregularity_Inbx_irregularityCode,
    Irregularity_Btn_OKbutton,
    Irregularity_Inbx_irregularityRemarks,
    info_error,
    btn_bookingHistory,
    txt_origin,
    txt_bookingFrom,
    txt_bookingTo,
    chkBox_checkFirst,
    btn_reOpen,
    txt_flightNumber,
    txt_flightFrom,
    txt_flightTo;
    
    By btn_genericYes;

    public CAP016(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {

        screenFrame = "iCargoContentFrameCAP016";
        txt_awbPrefix = MiscUtility.getWebElement(objFilepath,"CAP016_txt_awbNoPrefix");
        txt_awbNo = MiscUtility.getWebElement(objFilepath,"CAP016_txt_awbNo");
        btn_list = MiscUtility.getWebElement(objFilepath,"CAP016_btn_list");
        chkBx_checkAll = MiscUtility.getWebElement(objFilepath,"CAP016_chkBox_checkAll");
        btn_details = MiscUtility.getWebElement(objFilepath,"CAP016_btn_details");
        btn_reject = MiscUtility.getWebElement(objFilepath,"CAP016_btn_reject");
        btn_close = MiscUtility.getWebElement(objFilepath,"CAP016_btn_close");
        tbl_bookingDtls = MiscUtility.getWebElement(objFilepath,"CAP016_tbl_bookingDtls");
        btn_clear = MiscUtility.getWebElement(objFilepath,"CAP016_btn_clear");
        dropDown_status = MiscUtility.getWebElement(objFilepath,"CAP016_dropDown_status");

        // created byA-8254
        btn_cancel = MiscUtility.getWebElement(objFilepath, "CAP016_btn_cancel");
        Irregularity_Inbx_irregularityCode = MiscUtility.getWebElement(objFilepath, "CAP016_Irregularity_Inbx_irregularityCode");
        Irregularity_Btn_OKbutton = MiscUtility.getWebElement(objFilepath, "CAP016_Irregularity_Btn_OKbutton");
        Irregularity_Inbx_irregularityRemarks = MiscUtility.getWebElement(objFilepath, "CAP016_Irregularity_Inbx_irregularityRemarks");
        info_error=MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        btn_bookingHistory=MiscUtility.getWebElement(objFilepath, "CAP016_btn_bookingHistory");
        txt_origin=MiscUtility.getWebElement(objFilepath, "CAP016_txt_origin");
        txt_bookingFrom=MiscUtility.getWebElement(objFilepath, "CAP016_txt_bookingFrom");
        txt_bookingTo=MiscUtility.getWebElement(objFilepath, "CAP016_txt_bookingTo");
        chkBox_checkFirst=MiscUtility.getWebElement(objFilepath, "CAP016_chkBox_checkFirst");
        btn_reOpen=MiscUtility.getWebElement(objFilepath, "CAP016_btn_reOpen");
        txt_flightNumber=MiscUtility.getWebElement(objFilepath, "CAP016_txt_flightNumber");
        txt_flightFrom=MiscUtility.getWebElement(objFilepath, "CAP016_txt_flightFrom");
        txt_flightTo=MiscUtility.getWebElement(objFilepath, "CAP016_txt_flightTo");
        
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    /**
     * lists an AWB
     * @param awbPre
     * @param awbNo
     * @author A-7681
     */
    private void list(String awbPre, String awbNo){

        enterKeys(txt_awbPrefix,awbPre);
        enterKeys(txt_awbNo,awbNo);
        click(btn_list);
        minWait();
    }

    /**
     * Navigate to the CAP018 screen
     * @param awbPre
     * @param awbNo
     * @return
     * @author A-7681
     */
    public CAP018 getBookingDetails(String awbPre, String awbNo){

        awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);

        list(awbPre,awbNo);
        check(chkBx_checkAll);
        click(btn_details);

        return new CAP018(driver,dataFileName);
    }

    /**
     * Rejects a booking
     * @param awbPre
     * @param awbNo
     * @return
     * @author A-7681
     */
    public CAP016 reject(String awbPre, String awbNo){
        awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);

        list(awbPre,awbNo);
        boolean flag = false;
        check(chkBx_checkAll);
        click(btn_reject);
        minWait();
		waitForNewWindow(2);
		switchToNthWindow(2);
		if (verifyElementPresent(Irregularity_Inbx_irregularityCode)) {

			enterKeys(waitForElement(Irregularity_Inbx_irregularityCode), "Booking Reject");
			enterKeys(Irregularity_Inbx_irregularityRemarks, "Booking Reject");
			click(Irregularity_Btn_OKbutton);
		}
		switchToFirstWindow();
		waitForFrameAndSwitch(screenFrame);
		minWait();
		click(btn_clear);
		selectByText(dropDown_status,"Rejected");


        list(awbPre,awbNo);
        Assert.assertTrue(verifyValuePresentInTblColumn(tbl_bookingDtls,3,awbNo),"The AWB is not rejected");

        return this;
    }

    /**
     * Closes and go to the home page
     * @return
     * @author A-7681
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver,dataFileName);
    }
    
    //A-8254    
    
    public CAP016 cancelBookingListedAllAndVerify(String awbPre,String awbNo){

    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
        enterKeys(txt_origin,"");
        list(awbPre, awbNo);
    	check(chkBx_checkAll);
    	click(btn_cancel);
        driver.switchTo().defaultContent();
        click(btn_genericYes);
        waitForFrameAndSwitch(screenFrame);
        waitForNewWindow(2);
        switchToSecondWindow();
      
        
        
        enterKeys(waitForElement(Irregularity_Inbx_irregularityCode),"Booking Cancel");
    
        enterKeys(Irregularity_Inbx_irregularityRemarks, "Others");
        click(Irregularity_Btn_OKbutton);
        switchToFirstWindow();
        waitForFrameAndSwitch(screenFrame);
          minWait();
          
          enterKeys(txt_awbPrefix,awbPre);
          enterKeys(txt_awbNo,awbNo);
          click(btn_list);
          waitForElement(info_error).getText().contains("Booking does not exist or you are not authorised to view this booking");
          
          
          
       //   Assert.assertTrue(waitForElementVisible(info_bookingStatus).getAttribute("value").equalsIgnoreCase("CANCELLED"), "The AWB is not in the cancel state");
    	
    	return this;
    }  
    
    
    public CAP103 goToBookingHistoryScreen() 
    {
    	
    	
         minWait();
         check(chkBx_checkAll);
    	 click(btn_bookingHistory);
    	 

    	
    return new CAP103(driver, dataFileName);
    }
    
    
	public CAP016  listByClearingOrigin(String awbPre, String awbNo){
	    	
	    	
	    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
	        awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
	        enterKeys(txt_awbPrefix,awbPre);
	        enterKeys(txt_awbNo,awbNo);
	        enterKeys(txt_origin,"");
	        click(btn_list);
	        
	        return this; 
	    } 
	    
	    
	public CAP018  listCanceledRecordAndReOpen(){
		
		enterKeys(txt_bookingFrom,".");
		enterKeys(txt_bookingTo,".");
		enterKeys(txt_origin,"");
		selectByText(dropDown_status,"Cancelled");
		click(btn_list);
		minWait();
		click(chkBox_checkFirst);
		click(btn_reOpen);
		
		return new CAP018(driver, dataFileName); 
	}     
	    
	 
	public CAP016  listByFlightNumberAndVerifyAWBNumberPresent(String key_fltNum,String awbNo){
		
		
		awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
		key_fltNum = PropertyHandler.getPropValue(dataFilePath,key_fltNum);
		enterKeys(txt_bookingFrom,".");
		enterKeys(txt_bookingTo,".");
		enterKeys(txt_origin,"");
		enterKeys(txt_flightNumber,key_fltNum);
		click(btn_list);
		
		boolean flag=false;
		List<String> listElement;
		listElement=getTableColumnValues(tbl_bookingDtls,3);
		int count=listElement.size();
		for(int i=0;i<count;i++)
		{
			String listElement2=listElement.get(i);
			if(listElement2.contains(awbNo))
			{
				System.out.println("the tempate found");
				flag=true;
				break;
			}
		}
			
		if(flag==false)
		{
			System.out.println("not found");
			Assert.assertEquals(flag,true);
			
		}
				
		
	return this;
	}     
	
	
	public CAP018 rejectAWBAndVerify(String awbPre, String awbNo){
	    awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
	    awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
	
	   
	    enterKeys(txt_awbPrefix,awbPre);
	    enterKeys(txt_awbNo,awbNo);
	    enterKeys(txt_origin,"");
	    click(btn_list);
	    boolean flag = false;
	    check(chkBx_checkAll);
	    click(btn_reject);
	    minWait();
	    waitForNewWindow(2);
	    switchToSecondWindow();
	  
	    enterKeys(waitForElement(Irregularity_Inbx_irregularityCode),"Booking Reject");
	    enterKeys(Irregularity_Inbx_irregularityRemarks, "Others");
	    click(Irregularity_Btn_OKbutton);
	    switchToFirstWindow();
	    waitForFrameAndSwitch(screenFrame);
	    minWait();
	    
	    selectByText(dropDown_status,"Rejected");
	    click(btn_list);
	
	    List<String> values = getTableColumnValues(tbl_bookingDtls,3);
	    for(String value : values){
	        if (value.contains(awbNo)){
	            flag = true;
	            break;
	        }
	    }
	    Assert.assertTrue(flag,"The AWB is not rejected");
	    check(chkBx_checkAll);
	   click(btn_details);
	    
	    
	
	   return new CAP018(driver, dataFileName);
	}
	
	
	
	public CAP016 verifyFlightsOfCorrectDatesAreDisplayed()
	{
		enterKeys(txt_flightFrom,".");
		enterKeys(txt_flightTo,".");
		String flightDate=waitForElement(txt_flightFrom).getAttribute("value");
		click(btn_list);
		boolean flag = false;
		 List<String> values = getTableColumnValues(tbl_bookingDtls,9);
		    for(String value : values){
		    	value=value.trim();
		        if ((value.equalsIgnoreCase(flightDate))||(value.equalsIgnoreCase("")))
		        {
		            flag = false;
		            
		        }
		        else{
		        	flag=true;
		        	break;
		        }
		    }
		    Assert.assertFalse(flag,"The search results are wrong,mismatch in dates searched");
		
		
		
		
		return this;
	}
	
	
	
	public CAP016 verifyErrorMSGList(String flightFrom,String flightTo)
	{
		enterKeys(txt_flightFrom,flightFrom);
		enterKeys(txt_flightTo,flightTo);
		click(btn_list);
		 waitForElement(info_error).getText().contains("Please enter a valid UBR No. or AWB No. or the booking From and To date.");
		
		
		
		return this;
	}
	
	/**
	 * Method to list an AWB and compare the booked pcs/wt
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @return
	 * @author A-7868 Krishna <27/03/2018>
	 */
	 public CAP016 verifyPcsWt(String awbPre, String awbNo, String pcs, String wt){

        awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
        pcs = PropertyHandler.getPropValue(dataFilePath,pcs);
        wt = PropertyHandler.getPropValue(dataFilePath,wt);
        
        list(awbPre,awbNo);
        
        Assert.assertTrue(tblGetTextByColValue(tbl_bookingDtls, 14, 3, awbNo).trim().equals(pcs),"ERROR : Pcs mismatch.");
        Assert.assertTrue(tblGetTextByColValue(tbl_bookingDtls, 15, 3, awbNo).trim().equals(wt),"ERROR : Wt mismatch.");
        		    
        return this;
     }

	 /**
	  * Method to list an AWB and verify the reason code
	  * @param awbPre
	  * @param awbNo
	  * @param reasonCode
	  * @return
	  * @author A-7868 Krishna <04/04/2018>
	  */
	 public CAP016 verifyReasonCode(String awbPre, String awbNo, String reasonCode){
		 
		 awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
	     awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
		 if (!reasonCode.equals("")) {
			 reasonCode = PropertyHandler.getPropValue(dataFilePath,reasonCode);
		 }

		 list(awbPre,awbNo);
	     
//	     System.out.println(tblGetTextByColValue(tbl_bookingDtls, 21, 3, awbNo).trim());
	     Assert.assertEquals(tblGetTextByColValue(tbl_bookingDtls, 21, 3, awbNo).trim().toUpperCase(),reasonCode.toUpperCase(),"ERROR : Reason mismatch.");
	     
		 return this;
	 }
	 
	 
	 
	 
	 
	 public CAP016  verifyWaitListedAWBNumberPresent(String awbNo){
			
			
			awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
			//key_fltNum = PropertyHandler.getPropValue(dataFilePath,key_fltNum);
			enterKeys(txt_bookingFrom,".");
			enterKeys(txt_bookingTo,".");
			enterKeys(txt_origin,"");
			 selectByText(dropDown_status,"Waitlisted");
			//enterKeys(txt_flightNumber,key_fltNum);
			click(btn_list);
			
			boolean flag=false;
			List<String> listElement;
			listElement=getTableColumnValues(tbl_bookingDtls,3);
			int count=listElement.size();
			for(int i=0;i<count;i++)
			{
				String listElement2=listElement.get(i);
				if(listElement2.contains(awbNo))
				{
					System.out.println("the tempate found");
					flag=true;
					break;
				}
			}
				
			if(flag==false)
			{
				System.out.println("not found");
				Assert.assertEquals(flag,true);
				
			}
					
			
		return this;
		}     



 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
