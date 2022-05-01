package com.ibsplc.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-6545 on 27/12/2017.
 */
public class OPR328 extends BasePage{
	
	public String dataFilePath;
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
  
    public static String FRAME = "iCargoContentFrameOPR328";
   
    By
    btn_list,
    txt_StartDate,
    txt_FlightNo,
    txt_AircraftRegistration,
    txt_LoadController,
    txt_PreparedBy,
    ChkBox_Console,
    Chk_SelectDG,
    btn_save,
   Link_Unassign,
    btn_close,
    Link_GroupModify,
    GroupModify_txt_ULDNo1,
    GroupModify_txt_ULDNo2,
    GroupModify_txt_NoOfInnerPkgs1,
    GroupModify_txt_NoOfInnerPkgs2,
    GroupModify_txt_CargoHold1,
    GroupModify_txt_CargoHold2,
    GroupModify_txt_POS1,
    GroupModify_txt_POS2,
    GroupModify_Btn_Ok,
    yesBtn,
    noBtn,
   Link_Modify,
   Modify_txt_POU,
   Modify_txt_NQTYPerPkg,
   Modify_txt_ULDNo,
   Modify_txt_CargoHold,
   Modify_txt_POS,
   Modify_Btn_Ok,
   Link_ModifyOtherSpecialLoad,
   ModifyOtherSpecialLoad_txt_POU,
   ModifyOtherSpecialLoad_txt_AWBPrefix,
   ModifyOtherSpecialLoad_txt_AWBNo,
   ModifyOtherSpecialLoad_txt_Contents,
   ModifyOtherSpecialLoad_txt_NoOfPkgs,
   ModifyOtherSpecialLoad_txt_Quantity,
   ModifyOtherSpecialLoad_List_Unit,
   ModifyOtherSpecialLoad_txt_SupplimentaryInformation,
   ModifyOtherSpecialLoad_txt_SCC,
   ModifyOtherSpecialLoad_txt_ULDNo,
   ModifyOtherSpecialLoad_txt_NoOfInnerPkgs,
   ModifyOtherSpecialLoad_txt_CargoHold,
   ModifyOtherSpecialLoad_txt_POS,
   ModifyOtherSpecialLoad_Btn_Ok,
   Btn_SplitUNID,
   SplitUNID_Link_Add,
   SplitUNID_txt_ULDNo2,
   SplitUNID_txt_NoOfInnerPckgs2,
   SplitUNID_txt_CargoHold2,
   SplitUNID_txt_POS2,
   SplitUNID_Btn_Ok,
   Dialogue_NotocSaved_Btn_Ok,
   Dialogue_NotocSaved_SuccessMessage,
   Btn_SendNOTOC,
   SendNOTOCPopup_Link_Add,
   SendNOTOCPopup_List_IntefaceSystem,
   SendNOTOCPopup_List_TransmissionMode,
   SendNOTOCPopup_Btn_Ok,
   MessageSentNotification,
    btn_genericYes;
    
    
    
    
    WebDriver driver;    
    String testDataFile;
    String browser;
	private String key_awbNo;
	private String key_AWBNo_Prefix;
	
    public OPR328(WebDriver driver, String testDataFile) {
		 super(driver);
         this.driver = driver;
         this.testDataFile = testDataFile;
         PageFactory.initElements(this.driver,this);
         dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
         initPageElements();
	}

	private void initPageElements() {
		// TODO Auto-generated method stub
		btn_list		= MiscUtility.getWebElement(objFilepath,"OPR328_Btn_List");
		txt_FlightNo 	    = MiscUtility.getWebElement(objFilepath,"OPR328_txt_FlightNo");
		txt_StartDate 	    = MiscUtility.getWebElement(objFilepath,"OPR328_txt_Date");
		txt_AircraftRegistration 	= MiscUtility.getWebElement(objFilepath,"OPR328_txt_AircraftRegistration");
		txt_PreparedBy 	= MiscUtility.getWebElement(objFilepath,"OPR328_txt_PreparedBy");
		txt_LoadController 	= MiscUtility.getWebElement(objFilepath,"OPR328_txt_LoadController");
		Chk_SelectDG 	= MiscUtility.getWebElement(objFilepath,"OPR328_Chk_SelectDG");
	    Link_GroupModify 	= MiscUtility.getWebElement(objFilepath,"OPR328_Link_GroupModify");
	    GroupModify_txt_ULDNo1 = MiscUtility.getWebElement(objFilepath,"OPR328_GroupModify_txt_ULDNo1");
	    GroupModify_txt_ULDNo2 = MiscUtility.getWebElement(objFilepath,"OPR328_GroupModify_txt_ULDNo2");
	    GroupModify_txt_NoOfInnerPkgs1 = MiscUtility.getWebElement(objFilepath,"OPR328_GroupModify_txt_NoOfInnerPkgs1");
	    GroupModify_txt_NoOfInnerPkgs2 = MiscUtility.getWebElement(objFilepath,"OPR328_GroupModify_txt_NoOfInnerPkgs2");
	    GroupModify_txt_CargoHold1 = MiscUtility.getWebElement(objFilepath,"OPR328_GroupModify_txt_CargoHold1");
	    GroupModify_txt_CargoHold2 = MiscUtility.getWebElement(objFilepath,"OPR328_GroupModify_txt_CargoHold2");
	    GroupModify_txt_POS1 = MiscUtility.getWebElement(objFilepath,"OPR328_GroupModify_txt_POS1");
	    GroupModify_txt_POS2 = MiscUtility.getWebElement(objFilepath,"OPR328_GroupModify_txt_POS2");
	    GroupModify_Btn_Ok = MiscUtility.getWebElement(objFilepath,"OPR328_GroupModify_Btn_Ok");
	    Link_Modify  = MiscUtility.getWebElement(objFilepath,"OPR328_Link_Modify");
	    Modify_txt_POU = MiscUtility.getWebElement(objFilepath,"OPR328_Modify_txt_POU");
	    Modify_txt_NQTYPerPkg = MiscUtility.getWebElement(objFilepath,"OPR328_Link_Modify");
	    Modify_txt_ULDNo = MiscUtility.getWebElement(objFilepath,"OPR328_Modify_txt_ULDNo");
	    Modify_txt_CargoHold = MiscUtility.getWebElement(objFilepath,"OPR328_Modify_txt_CargoHold");
	    Modify_txt_POS = MiscUtility.getWebElement(objFilepath,"OPR328_Modify_txt_POS");
	    Modify_Btn_Ok = MiscUtility.getWebElement(objFilepath,"OPR328_Modify_Btn_Ok");
	    Link_ModifyOtherSpecialLoad = MiscUtility.getWebElement(objFilepath,"OPR328_Modify_Btn_Ok");
	    ModifyOtherSpecialLoad_txt_POU  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_POU");
	    ModifyOtherSpecialLoad_txt_AWBPrefix  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_AWBPrefix");
	    ModifyOtherSpecialLoad_txt_AWBNo  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_AWBNo");
	    ModifyOtherSpecialLoad_txt_Contents  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_Contents");
	    ModifyOtherSpecialLoad_txt_NoOfPkgs  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_NoOfPkgs");
	    ModifyOtherSpecialLoad_txt_Quantity  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_Quantity");
	    ModifyOtherSpecialLoad_List_Unit  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_List_Unit");
	    ModifyOtherSpecialLoad_txt_SupplimentaryInformation  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_SupplimentaryInformation");
	    ModifyOtherSpecialLoad_txt_SCC  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_SCC");
	    ModifyOtherSpecialLoad_txt_ULDNo  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_ULDNo");
	    ModifyOtherSpecialLoad_txt_NoOfInnerPkgs  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_NoOfInnerPkgs");
	    ModifyOtherSpecialLoad_txt_CargoHold  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_CargoHold");
	    ModifyOtherSpecialLoad_txt_POS  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_txt_POS");
	    ModifyOtherSpecialLoad_Btn_Ok  =MiscUtility.getWebElement(objFilepath,"OPR328_ModifyOtherSpecialLoad_Btn_Ok");
	    Btn_SplitUNID  =MiscUtility.getWebElement(objFilepath,"OPR328_Btn_SplitUNID");
	    SplitUNID_Link_Add  =MiscUtility.getWebElement(objFilepath,"OPR328_SplitUNID_Link_Add");
	    SplitUNID_txt_ULDNo2  =MiscUtility.getWebElement(objFilepath,"OPR328_SplitUNID_txt_ULDNo2");
	    SplitUNID_txt_NoOfInnerPckgs2  =MiscUtility.getWebElement(objFilepath,"OPR328_SplitUNID_txt_NoOfInnerPckgs2");
	    SplitUNID_txt_CargoHold2  =MiscUtility.getWebElement(objFilepath,"OPR328_SplitUNID_txt_CargoHold2");
	    SplitUNID_txt_POS2  =MiscUtility.getWebElement(objFilepath,"OPR328_SplitUNID_txt_POS2");
	    SplitUNID_Btn_Ok  =MiscUtility.getWebElement(objFilepath,"OPR328_SplitUNID_Btn_Ok");
	    btn_save  =MiscUtility.getWebElement(objFilepath,"OPR328_Btn_Save");
	    btn_close  =MiscUtility.getWebElement(objFilepath,"OPR328_Btn_Close");
	  Dialogue_NotocSaved_Btn_Ok  =MiscUtility.getWebElement(objFilepath,"OPR328_Dialogue_NotocSaved_Btn_Ok");
	  Dialogue_NotocSaved_SuccessMessage =MiscUtility.getWebElement(objFilepath,"OPR328_Dialogue_NotocSaved_SuccessMessage");
	  Link_Unassign =MiscUtility.getWebElement(objFilepath,"OPR328_Link_Unassign");
	  Btn_SendNOTOC =MiscUtility.getWebElement(objFilepath,"OPR328_Btn_SendNOTOC");
	  SendNOTOCPopup_Link_Add  =MiscUtility.getWebElement(objFilepath,"OPR328_SendNOTOCPopup_Link_Add");
	  SendNOTOCPopup_List_IntefaceSystem  =MiscUtility.getWebElement(objFilepath,"OPR328_SendNOTOCPopup_List_IntefaceSystem");
	  SendNOTOCPopup_List_TransmissionMode	 =MiscUtility.getWebElement(objFilepath,"OPR328_SendNOTOCPopup_List_TransmissionMode");
	  SendNOTOCPopup_Btn_Ok	 =MiscUtility.getWebElement(objFilepath,"OPR328_SendNOTOCPopup_Btn_Ok");
	  MessageSentNotification	 =MiscUtility.getWebElement(objFilepath,"OPR328_MessageSentNotification");
	  
	  yesBtn = MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
	    
	    
		
	}
	 public OPR328 SaveNotoc(String key_FlightNo, String key_sDate, String key_awbNoPrefix, String key_awbNo){
		 
	 
	        String data_FlightNo            			= PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
			String data_sDate 	                        = PropertyHandler.getPropValue(dataFilePath, key_sDate);
			String data_awbNoPrefix 	                        = PropertyHandler.getPropValue(dataFilePath, key_awbNoPrefix);
			String data_awbNo	                        = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
			
			
			enterKeys((txt_FlightNo), data_FlightNo);
	    	enterKeys(txt_StartDate, data_sDate);
	    	 click(btn_list);
	         minWait();
	         //driver.switchTo().defaultContent();
	         enterKeys(txt_AircraftRegistration, "JA8545GH");
	         enterKeys(txt_PreparedBy, "TEST");
	         enterKeys(txt_LoadController, "NBG");
	         click(Chk_SelectDG);
	         click(Link_GroupModify);
	         driver.switchTo().defaultContent();
	         waitForNewWindow(2);
	         switchToSecondWindow();
	         
	         enterKeys(GroupModify_txt_ULDNo1, "AMD98878NH");
	         enterKeys(GroupModify_txt_NoOfInnerPkgs1, "1");
	         enterKeys(GroupModify_txt_CargoHold1, "KJAD");
	         enterKeys(GroupModify_txt_POS1, "PI1");
	         enterKeys(GroupModify_txt_ULDNo2, "AMD98887NH");
	         enterKeys(GroupModify_txt_NoOfInnerPkgs2, "1");
	         enterKeys(GroupModify_txt_CargoHold2, "FDG");
	         enterKeys(GroupModify_txt_POS2, "LFT1");
	 	    
	         click(GroupModify_Btn_Ok);
			//switch back to main window
		     minWait();
		     switchToFirstWindow();
		     waitForFrameAndSwitch(FRAME);
		     click(Link_Modify);
		     
		     driver.switchTo().defaultContent();
	         waitForNewWindow(2);
	         switchToSecondWindow();
	         enterKeys(Modify_txt_POU, "KIX");
	         enterKeys(Modify_txt_NQTYPerPkg, "1");
	         enterKeys(Modify_txt_ULDNo, "AMD0090NH");
	         enterKeys(Modify_txt_CargoHold, "P1");
	         enterKeys(Modify_txt_POS, "LFT");
	         click(GroupModify_Btn_Ok);
				//switch back to main window
			     minWait();
			     switchToFirstWindow();
			     waitForFrameAndSwitch(FRAME);
			     click(Link_ModifyOtherSpecialLoad);
			     minWait();
			     driver.switchTo().defaultContent();
		         waitForNewWindow(2);
		         switchToSecondWindow();
		         enterKeys(ModifyOtherSpecialLoad_txt_POU, "KIX");
		         enterKeys(ModifyOtherSpecialLoad_txt_AWBPrefix, data_awbNoPrefix); 
		         enterKeys(ModifyOtherSpecialLoad_txt_AWBNo, data_awbNo); 
		         enterKeys(ModifyOtherSpecialLoad_txt_Contents, "MNNHSDAD"); 
		         enterKeys(ModifyOtherSpecialLoad_txt_NoOfPkgs, "10"); 
		         enterKeys(ModifyOtherSpecialLoad_txt_Quantity, "100");
		         selectByText(ModifyOtherSpecialLoad_List_Unit, "Kg");
		         enterKeys(ModifyOtherSpecialLoad_txt_SupplimentaryInformation, "ASDDAD");
		         enterKeys(ModifyOtherSpecialLoad_txt_SCC, "ICE");
		         enterKeys(ModifyOtherSpecialLoad_txt_ULDNo, "PMC97766NH");
		         enterKeys(ModifyOtherSpecialLoad_txt_NoOfInnerPkgs, "9");
		         enterKeys(ModifyOtherSpecialLoad_txt_CargoHold, "PSDS");
		         enterKeys(ModifyOtherSpecialLoad_txt_POS, "LFT");
		         click(ModifyOtherSpecialLoad_Btn_Ok);
					//switch back to main window
				     minWait();
				     switchToFirstWindow();
				     waitForFrameAndSwitch(FRAME);
				     click(Chk_SelectDG);
				     minWait();
				     click(Btn_SplitUNID);
				     minWait();
				     driver.switchTo().defaultContent();
			         waitForNewWindow(2);
			         switchToSecondWindow();
			         enterKeys(SplitUNID_txt_ULDNo2, "AMD98873NH");
			         enterKeys(SplitUNID_txt_NoOfInnerPckgs2, "2");
			         enterKeys(SplitUNID_txt_CargoHold2, "LODQ");
			         enterKeys(SplitUNID_txt_POS2, "PI2");
		         
			         click(SplitUNID_Btn_Ok);
						//switch back to main window
					     minWait();
					     switchToFirstWindow();
					     waitForFrameAndSwitch(FRAME);
					     click(btn_save);
					     minWait();
					     
					  
					     click(Dialogue_NotocSaved_Btn_Ok);
					     minWait();
					    
					     return this;
	 }
	 
	
	 public OPR328 UnassignNotoc(String key_FlightNo, String key_sDate){
		 
		 
	        String data_FlightNo            			= PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
			String data_sDate 	                        = PropertyHandler.getPropValue(dataFilePath, key_sDate);
		
			enterKeys((txt_FlightNo), data_FlightNo);
	    	enterKeys(txt_StartDate, data_sDate);
	    	click(btn_list);
	         minWait();
	         //driver.switchTo().defaultContent();
	         click(Chk_SelectDG);
	         click(Link_Unassign);
	         minWait();
	         click(btn_save);
		     minWait();
		     
		     driver.switchTo().defaultContent();
		     click(Dialogue_NotocSaved_Btn_Ok);
		     minWait();
		     waitForFrameAndSwitch(FRAME);
			
			 return this;
	 }
		
	 public OPR328 SendNOTOC(String key_FlightNo, String key_sDate){
		 
		 
	        String data_FlightNo            			= PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
			String data_sDate 	                        = PropertyHandler.getPropValue(dataFilePath, key_sDate);
			
			enterKeys((txt_FlightNo), data_FlightNo);
	    	enterKeys(txt_StartDate, data_sDate);
	    	click(btn_list);
	         minWait();
	         //driver.switchTo().defaultContent();
	         click(Btn_SendNOTOC);
	         driver.switchTo().defaultContent();
	         if(verifyElementPresent(yesBtn))
	        	 click(yesBtn);
	         
	         minWait();
	         driver.switchTo().defaultContent();
	         waitForNewWindow(2);
	         switchToSecondWindow();
	         click(SendNOTOCPopup_Link_Add);
		     selectByIndex(SendNOTOCPopup_List_IntefaceSystem, 1);
		     selectByText(SendNOTOCPopup_List_TransmissionMode, "FILE");
		     driver.switchTo().defaultContent();
		     click(SendNOTOCPopup_Btn_Ok);
	         minWait();
	         switchToFirstWindow();
	         waitForFrameAndSwitch(FRAME);
	         click(btn_save);
		     minWait();
		     driver.switchTo().defaultContent();		  
		     Assert.assertTrue(waitForElement(Dialogue_NotocSaved_Btn_Ok).isDisplayed(),"ERROR : NOTOC not sent.");
		     click(Dialogue_NotocSaved_Btn_Ok);
		     minWait();
		     waitForFrameAndSwitch(FRAME);
			
			 return this;
	 }
		public HomePage close(){
	
			click(btn_close);
			
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {

	             click(yesBtn);
	         }
			
			return new HomePage(driver,testDataFile);
		}
	}
					     
	         
	    	
	    	
	    	