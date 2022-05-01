package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class TRF004 extends BasePage{
    
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
	public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","Generic.properties");
	 
	public static String filepath;
	
	public static String FRAME = "iCargoContentFrameTRF004";
	
	By
	txt_AWBPrefix,
	txt_AWBNo,
	Btn_List,
	Tbl_listConstruct,
	txt_UBRNo,
	chkbx_allSelct,
    Btn_Construct;
	
	By
	
	btn_approve,
	txt_Remarks,
	txt_ValidFrom,
	txt_ValidTo;

	
	
	    WebDriver driver;    
		String testDataFile;

		public  TRF004(WebDriver driver, String testDataFile) {
			 super(driver);
		    this.driver = driver;
		    this.testDataFile = testDataFile;
		    PageFactory.initElements(this.driver,this);
		    filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
		    initPageElements();
		} 

		private void initPageElements() {
			
			  txt_AWBPrefix                  = MiscUtility.getWebElement(objFilepath, "TRF004_txt_AWBPrefix");
		      txt_AWBNo                      = MiscUtility.getWebElement(objFilepath, "TRF004_txt_AWBNo");
		      Btn_List                       = MiscUtility.getWebElement(objFilepath, "TRF004_Btn_List");
		      Tbl_listConstruct              = MiscUtility.getWebElement(objFilepath, "TRF004_Tbl_listConstruct");
		      Btn_Construct                  = MiscUtility.getWebElement(objFilepath, "TRF004_Btn_Construct");
		      txt_UBRNo                      = MiscUtility.getWebElement(objFilepath, "TRF004_txt_UBRNo");
		      chkbx_allSelct                 = MiscUtility.getWebElement(objFilepath, "TRF004_chkbx_allSelct");
		      
		      btn_approve                    = MiscUtility.getWebElement(objFilepath, "TRF001_btn_approve");
		  	  txt_Remarks                    = MiscUtility.getWebElement(objFilepath, "TRF001_txt_Remarks");
		  	  txt_ValidFrom                  = MiscUtility.getWebElement(objFilepath, "TRF001_txt_ValidFrom");
		  	  txt_ValidTo                    = MiscUtility.getWebElement(objFilepath, "TRF001_txt_ValidTo");
			
	       
	}
		
		public TRF004 addAndApprove(String UBRNo){
			
			 UBRNo = PropertyHandler.getPropValue(filepath,UBRNo);
			 click(Btn_List);
			 minWait();
			 check(chkbx_allSelct);
			 
			click(Btn_Construct);
			maxWait();
			enterKeys(txt_ValidFrom, ".");
			enterKeys(txt_ValidTo, "+1");
			enterKeys(txt_Remarks, "Remarks");
			
			click(btn_approve);
			return this;
			
		}
		
		public TRF004 verifyRateConstructionRequestListed(String UBRNoOfQueuedConstruct_Rate)
		{
			boolean flag=false;
			UBRNoOfQueuedConstruct_Rate = PropertyHandler.getPropValue(filepath,UBRNoOfQueuedConstruct_Rate);
			enterKeys(txt_UBRNo,UBRNoOfQueuedConstruct_Rate);
			click(Btn_List);
			List<String> listElement;
			
			listElement=getTableColumnValues(Tbl_listConstruct,3);
			int count=listElement.size();
			for(int i=0;i<count;i++)
			{
				String listElement2=listElement.get(i);
				if(listElement2.equalsIgnoreCase(UBRNoOfQueuedConstruct_Rate))
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
