/**
 * 
 */
package com.ibsplc.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


public class REC001 extends BasePage {

	private String dataFilePath        = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
	public static String objFilepath   = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
	public static String genObjPath    = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
	
	public static String FRAME = "iCargoContentFrameREC001";
	
	By  

	  txt_refNumber,                   
	  btn_ListBtn,              
	  txt_status ,                        
	  txt_startDate ,                    
	  txt_endDate  ,                       
	  txt_geographicLevelValues  ,              
	  dropDown_ApplicableTransactions,        
	  List_Chkbox_Transaction,               
	  dropDown_embargoLevel ,                
	  Link_AddTemplateRow  ,                  
	  List_dropdown_geographicLevel,
	  List_dropdown_geographicLevelType ,    
	  List_dropdown_geographicLevelApplicableOn,
	  List_txt_geographicLevelValues,
	  ChkBox_daysOfOperationalltrue,          
	  drodown_Applicableon ,                
	  Link_AddembargoDetails ,               
	  txt_Remarks,                              
	  Txt_Description ,                        
	  drodown_parameterCode   ,                 
	  dropdown_ParameterApplicable  , 
	  Chkbx_transaction1,
	  Chkbox_Transaction4,
	  txt_CommodityValue ,                     
	  btn_SaveBtn,
	  txt_SCCValue,
	  info_embargoId,
	  dropdown_category,
	  btn_constructDesc,
	  btn_Clear,
	  btn_approve,
	  yesBtn,
	  dropdown_complianceType,
	  dropdown_flightTypeParameterValues,
	  Chkbox_TransactionBKG,
	  Chkbox_Transaction2,
	  Chkbox_Transaction3,
	  btn_Close;
	
	WebDriver driver;
    String screenFrame;
    String dataFileName;
    
public REC001(WebDriver driver, String dataFileName) {
    	
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
private void initElements() {
	  
	  btn_ListBtn                                  = MiscUtility.getWebElement(objFilepath ,"REC001_btn_ListBtn");
	  txt_status                                   = MiscUtility.getWebElement(objFilepath ,"REC001_txt_status"); 
	  txt_startDate                                = MiscUtility.getWebElement(objFilepath ,"REC001_txt_startDate"); 
	  txt_endDate                                  = MiscUtility.getWebElement(objFilepath ,"REC001_txt_endDate"); 
	  txt_geographicLevelValues                    = MiscUtility.getWebElement(objFilepath ,"REC001_txt_geographicLevelValues");
	  dropDown_ApplicableTransactions              = MiscUtility.getWebElement (objFilepath ,"REC001_dropDown_ApplicableTransactions");
	  List_Chkbox_Transaction                      = MiscUtility.getWebElement(objFilepath ,"REC001_List_Chkbox_Transaction"); 
	  dropDown_embargoLevel                        = MiscUtility.getWebElement (objFilepath ,"REC001_dropDown_embargoLevel");
	  Link_AddTemplateRow                          = MiscUtility.getWebElement(objFilepath ,"REC001_Link_AddTemplateRow"); 
	  List_dropdown_geographicLevel	               = MiscUtility.getWebElement (objFilepath ,"REC001_List_dropdown_geographicLevel");
	  List_dropdown_geographicLevelType            = MiscUtility.getWebElement (objFilepath ,"REC001_List_dropdown_geographicLevelType");
	  List_dropdown_geographicLevelApplicableOn    = MiscUtility.getWebElement (objFilepath ,"REC001_List_dropdown_geographicLevelApplicableOn");
	  List_txt_geographicLevelValues	           = MiscUtility.getWebElement (objFilepath ,"REC001_List_txt_geographicLevelValues");
	  ChkBox_daysOfOperationalltrue                = MiscUtility.getWebElement (objFilepath ,"REC001_ChkBox_daysOfOperationalltrue");
	  drodown_Applicableon                         = MiscUtility.getWebElement (objFilepath ,"REC001_drodown_Applicableon");
	  Link_AddembargoDetails                       = MiscUtility.getWebElement (objFilepath ,"REC001_Link_AddembargoDetails"); 
	  txt_Remarks                                  = MiscUtility.getWebElement (objFilepath ,"REC001_txt_Remarks");
	  Txt_Description                              = MiscUtility.getWebElement (objFilepath ,"REC001_Txt_Description");
	  drodown_parameterCode                        = MiscUtility.getWebElement (objFilepath ,"REC001_drodown_parameterCode");
	  dropdown_ParameterApplicable                 = MiscUtility.getWebElement (objFilepath ,"REC001_dropdown_ParameterApplicable");
	  txt_CommodityValue                           = MiscUtility.getWebElement (objFilepath ,"REC001_txt_CommodityValue");
	  txt_SCCValue                                 = MiscUtility.getWebElement(objFilepath, "REC001_txt_SCCValue") ;
	  btn_SaveBtn                                  = MiscUtility.getWebElement (objFilepath ,"REC001_btn_SaveBtn");
	  btn_Close							           = MiscUtility.getWebElement (objFilepath ,"REC001_btn_Close");
	  yesBtn                                       = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes"); 
	  btn_Clear                                    = MiscUtility.getWebElement(objFilepath, "REC001_btn_Clear");
	  info_embargoId                               = MiscUtility.getWebElement(objFilepath, "REC001_info_EmbargoID");
	  Chkbox_Transaction2                          = MiscUtility.getWebElement(objFilepath, "REC001_Chkbox_Transaction2");
	  Chkbox_Transaction3                          = MiscUtility.getWebElement(objFilepath, "REC001_Chkbox_Transaction3");
	  txt_refNumber                                = MiscUtility.getWebElement(objFilepath ,"REC001_txt_refNumber");
	  Chkbox_Transaction4                          = MiscUtility.getWebElement(objFilepath, "REC001_Chkbox_Transaction4");
	  dropdown_complianceType                      = MiscUtility.getWebElement(objFilepath, "REC001_dropdown_complianceType");
	  dropdown_category                            = MiscUtility.getWebElement(objFilepath, "REC001_dropdown_category");
	  dropdown_flightTypeParameterValues           = MiscUtility.getWebElement(objFilepath, "REC001_dropdown_flightTypeParameterValues");
	  btn_constructDesc                            = MiscUtility.getWebElement(objFilepath, "REC001_btn_constructDesc");
	  Chkbox_TransactionBKG                        = MiscUtility.getWebElement(objFilepath, "REC001_Chkbox_TransactionBKG");
	  Chkbx_transaction1                           = MiscUtility.getWebElement(objFilepath, "REC001_Chkbx_transaction1");
	  btn_approve                                  = MiscUtility.getWebElement(objFilepath, "REC001_btn_approve");


}

/**
 * Method to create Reco Embargo
 * @param key_RECO_Refnum
 * @param key_startDate
 * @param key_endDate
 * @param key_geographicLevelValues
 * @param Key_geographicLevelType
 * @param key_ApplicableValues
 * @param key_geographicValue
 * @param key_Parameter
 * @param key_Parametervalue
 * @param key_ParameterApplicable
 * @param applicableTrancation
 * @return
 
 * @author a-6784
 */
enum range2 {AWB_Execution,AWB_save,AWB_save_Execution,AWB_save_Execution_GAC};
public REC001 createEmbargo_LH (
		
		  String	key_RECO_Refnum,                                            
		                                             
		  String	key_startDate,                     
		  String	key_endDate,                         
		  String	key_EmbargoLevel,           	         
		  String	key_geographicLevelValues,                                
		  String	Key_geographicLevelType,                              
		  String	key_ApplicableValues,                         
		  String	key_geographicValue,                    
		  String	key_ApplicableOn,             
		  String	key_Parameter,
		  String    applicableTrancation,
		  String    key_Parametervalue,
		  String    key_ParameterApplicable
		  
)throws InterruptedException, IOException {
	 
	  String ApplicableValue          = PropertyHandler.getPropValue(dataFilePath, applicableTrancation);
	 // String embargoLevel             = PropertyHandler.getPropValue(dataFilePath, key_EmbargoLevel);
	  String geoLevel                 = PropertyHandler.getPropValue(dataFilePath, key_geographicLevelValues);
	  String geoLevelType             = PropertyHandler.getPropValue(dataFilePath, Key_geographicLevelType);
	  String applicableLevelValues    = PropertyHandler.getPropValue(dataFilePath, key_ApplicableValues);
	  String geoValues                = PropertyHandler.getPropValue(dataFilePath, key_geographicValue);
	  String applicableOn             = PropertyHandler.getPropValue(dataFilePath, key_ApplicableOn);
	  String parameter                = PropertyHandler.getPropValue(dataFilePath, key_Parameter);
	  String parameterApplicable      = PropertyHandler.getPropValue(dataFilePath, key_ParameterApplicable);
	  String parametervalue           = PropertyHandler.getPropValue(dataFilePath, key_Parametervalue);

  	  
  	 
    click(waitForElement(btn_Clear));
	 
        selectByText(dropdown_category, "Others");
	    click(dropDown_ApplicableTransactions);

	    
	 switch (range2.valueOf(ApplicableValue)){
	
		 case AWB_Execution: 
			
			check(Chkbox_Transaction2);
			
			 break;
		 case AWB_save :
			 
			 check(Chkbox_Transaction3);
			 break;
        case AWB_save_Execution :
			 
        	check(Chkbox_Transaction2);
        	check(Chkbox_Transaction3);
        	break;
        case 	AWB_save_Execution_GAC :
        	
        	check(Chkbox_Transaction2);
        	//check(Chkbox_Transaction3);
        	unCheck(Chkbox_TransactionBKG);
        	scrollToView(Chkbox_Transaction4);
        	minWait();
        	check(Chkbox_Transaction4);
			 break;
	 }
	 
	 
	click(dropDown_embargoLevel);
	 selectByText(dropDown_embargoLevel, key_EmbargoLevel);
	 enterKeys(txt_startDate, ".");
     enterKeys(txt_endDate, "+7");
     
   String strtDate    = waitForElement(txt_startDate).getAttribute("value");
   String endDate     = waitForElement(txt_endDate).getAttribute("value");
   
   PropertyHandler.setPropValue(dataFileName, key_startDate, strtDate);
   PropertyHandler.setPropValue(dataFileName, key_endDate, endDate);
   selectByText(dropdown_complianceType, "Embargo");
     click(Link_AddTemplateRow);
     minWait();
   
   
  selectByText(List_dropdown_geographicLevel, geoLevel);
  selectByText(List_dropdown_geographicLevelType, geoLevelType);
  selectByText(List_dropdown_geographicLevelApplicableOn, applicableLevelValues);
     enterKeys(List_txt_geographicLevelValues,geoValues);
   
     check(ChkBox_daysOfOperationalltrue);
     selectByText(drodown_Applicableon,applicableOn);
     
     enterKeys(txt_Remarks, "Created By Automation");
     click(Link_AddembargoDetails);
     minWait();
     selectByText(drodown_parameterCode, parameter);
  // selectByText(dropdown_ParameterApplicable,parameterApplicable);
   
   if(parameter.equals("Commodity")){
	   
  	 enterKeys(txt_CommodityValue, parametervalue);
   }
   else if(parameter.equals("SCC")){
	   
  	 enterKeys(txt_SCCValue, parametervalue);
   }
   else if (parameter.equals("Flight Type")){
	   
	   selectByText(dropdown_flightTypeParameterValues, parametervalue);
   }
   click(btn_constructDesc);
     click(btn_SaveBtn);
     driver.switchTo().defaultContent();
  String temp_EmbId	 = waitForElement(info_embargoId).getText().split("The Embargo with reference number ")[1];
      temp_EmbId	 = waitForElement(info_embargoId).getText().split(" has been saved successfully")[0];
      waitForFrameAndSwitch(FRAME); 
      PropertyHandler.setPropValue(dataFileName, key_RECO_Refnum, temp_EmbId);
   
 

return this;

}
/***
 * 
 * @param embargoId
 * @param ExcludeTransaction
 * @return
 */
public REC001 unCheckApplicableTransaction(String embargoId,String ExcludeTransaction){
	
	embargoId=PropertyHandler.getPropValue(dataFilePath, embargoId);
	
	enterKeys(txt_refNumber, embargoId);
	click(btn_ListBtn);
	minWait();
	
	click(dropDown_ApplicableTransactions);
	
	if(ExcludeTransaction.equals("AWBSave")){
		
		unCheck(Chkbox_Transaction2);
	}
	else if(ExcludeTransaction.equals("awbExecute")){
		
		unCheck(Chkbx_transaction1);
	}
	
	click(btn_SaveBtn);
	minWait();
	enterKeys(txt_refNumber, embargoId);
	click(btn_ListBtn);
	minWait();
	
	click(btn_approve);
	return this;
	
}

/**
 * Method to create Reco Embargo
 * @param key_RECO_Refnum
 * @param key_startDate
 * @param key_endDate
 * @param key_geographicLevelValues
 * @param Key_geographicLevelType
 * @param key_ApplicableValues
 * @param key_geographicValue
 * @param key_Parameter
 * @param key_Parametervalue
 * @param key_ParameterApplicable
 * @param applicableTrancation
 * @return
 
 * @author a-6784
 */
enum range {AWB_Execution,AWB_save,AWB_save_Execution,AWB_save_Execution_GAC};
public REC001 createEmbargo (
		
		  String	key_RECO_Refnum,                                            
		                                             
		  String	key_startDate,                     
		  String	key_endDate,                         
		  String	key_EmbargoLevel,           	         
		  String	key_geographicLevelValues,                                
		  String	Key_geographicLevelType,                              
		  String	key_ApplicableValues,                         
		  String	key_geographicValue,                    
		  String	key_ApplicableOn,             
		  String	key_Parameter,
		  String    applicableTrancation,
		  String    key_Parametervalue,
		  String    key_ParameterApplicable
		  
)throws InterruptedException, IOException {
	 
	  String ApplicableValue          = PropertyHandler.getPropValue(dataFilePath, applicableTrancation);
	 // String embargoLevel             = PropertyHandler.getPropValue(dataFilePath, key_EmbargoLevel);
	  String geoLevel                 = PropertyHandler.getPropValue(dataFilePath, key_geographicLevelValues);
	  String geoLevelType             = PropertyHandler.getPropValue(dataFilePath, Key_geographicLevelType);
	  String applicableLevelValues    = PropertyHandler.getPropValue(dataFilePath, key_ApplicableValues);
	  String geoValues                = PropertyHandler.getPropValue(dataFilePath, key_geographicValue);
	  String applicableOn             = PropertyHandler.getPropValue(dataFilePath, key_ApplicableOn);
	  String parameter                = PropertyHandler.getPropValue(dataFilePath, key_Parameter);
	  String parameterApplicable      = PropertyHandler.getPropValue(dataFilePath, key_ParameterApplicable);
	  String parametervalue           = PropertyHandler.getPropValue(dataFilePath, key_Parametervalue);
	  
	  String refNumb;  
	  while (true) {
	  refNumb= BizUtility.createFlightNum();
	  enterKeys(txt_refNumber, refNumb);
	  click(btn_ListBtn); 
	  driver.switchTo().defaultContent();
    minWait();
    if (verifyElementPresent(yesBtn)) {
        click(yesBtn);
        waitForFrameAndSwitch(FRAME);
     break;
    }
    
  	  
  	  waitForFrameAndSwitch(FRAME);
    click(waitForElement(btn_Clear));
	  }
	  minWait();
      String Refnum = waitForElementVisible(txt_refNumber).getAttribute("value");
      PropertyHandler.setPropValue(dataFileName, key_RECO_Refnum, Refnum); 
	  
	    click(dropDown_ApplicableTransactions);

	    
	 switch (range.valueOf(ApplicableValue)){
	
		 case AWB_Execution: 
			
			check(Chkbox_Transaction2);
			
			 break;
		 case AWB_save :
			 
			 check(Chkbox_Transaction3);
			 break;
        case AWB_save_Execution :
			 
        	check(Chkbox_Transaction2);
        	check(Chkbox_Transaction3);
        	break;
        case 	AWB_save_Execution_GAC :
        	
        	unCheck(Chkbox_TransactionBKG);
        	check(Chkbox_Transaction2);
        	check(Chkbox_Transaction4);
        	
			 break;
	 }
	 
	 
	
	 selectByText(dropDown_embargoLevel, key_EmbargoLevel);
	 enterKeys(txt_startDate, ".");
     enterKeys(txt_endDate, "+7");
     
   String strtDate    = waitForElement(txt_startDate).getAttribute("value");
   String endDate     = waitForElement(txt_endDate).getAttribute("value");
   
   PropertyHandler.setPropValue(dataFileName, key_startDate, strtDate);
   PropertyHandler.setPropValue(dataFileName, key_endDate, endDate);
   
     click(Link_AddTemplateRow);
     minWait();
   
   
  selectByText(List_dropdown_geographicLevel, geoLevel);
  selectByText(List_dropdown_geographicLevelType, geoLevelType);
  selectByText(List_dropdown_geographicLevelApplicableOn, applicableLevelValues);
     enterKeys(List_txt_geographicLevelValues,geoValues);
   
     check(ChkBox_daysOfOperationalltrue);
     selectByText(drodown_Applicableon,applicableOn);
     enterKeys(Txt_Description, "Created By Automation");
     enterKeys(txt_Remarks, "Created By Automation");
     click(Link_AddembargoDetails);
     minWait();
     selectByText(drodown_parameterCode, parameter);
  // selectByText(dropdown_ParameterApplicable,parameterApplicable);
   
   if(parameter.equals("Commodity")){
	   
  	 enterKeys(txt_CommodityValue, parametervalue);
   }
   else if(parameter.equals("SCC")){
	   
  	 enterKeys(txt_SCCValue, parametervalue);
   }
  
     click(btn_SaveBtn);
 // String Ta = waitForElement(txt_endDate).getAttribute("value");
  // String temp_EmbId	= waitForElement(info_embargoId).getText();
 //  System.out.println(temp_EmbId);
     driver.switchTo().defaultContent();
  String temp_EmbId	 = waitForElement(info_embargoId).getText().split("The Embargo with reference number ")[1];
      temp_EmbId	 = waitForElement(info_embargoId).getText().split(" has been saved successfully")[0];
      waitForFrameAndSwitch(FRAME); 
      PropertyHandler.setPropValue(dataFileName, key_RECO_Refnum, temp_EmbId);
   
 
/* System.out.println(waitForElement(info_embargoId).getText());
 String temp_EmbId	 = waitForElement(info_embargoId).getText().split("The Embargo with reference number ")[1].toString().split(" has been saved successfully")[0].toString();
    System.out.println(temp_EmbId);

      PropertyHandler.setPropValue(dataFileName, key_RECO_Refnum, temp_EmbId);
   */
return this;

}
public HomePage close() {    	
      
      click(btn_Close);
      driver.switchTo().defaultContent();
      if (verifyElementPresent(yesBtn)) {

          click(yesBtn);
      }          
      return new HomePage(driver,dataFileName);
  }
}
