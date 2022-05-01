package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
/****
 * 
 * @author A-6784
 *
 */
public class OPR003 extends BasePage{

    public static String FRAME = "iCargoContentFrameOPR003";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String screenFrame;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    
    By
    txt_AWBPrefix ,
    txt_AWBNo ,
    Tbl_ctmEnquiryTable ,
    Btn_Details,
    Tbl_CTMDetails,
    Btn_List ,
    chkbox_firstRow,
    info_CTMrefNum,
    btn_Close1,
    Btn_Close  ; 
    
    
    
    By btn_genericYes,
   	info_msg,
   	btn_noBtn,
   	btn_ok,
   	info_error;
       
       
       public OPR003(WebDriver driver, String dataFileName) {
           super(driver);
           this.driver = driver;
           initPageElements();
           this.dataFilePath = this.dataFilePath + dataFileName;
           this.dataFileName = dataFileName;
       }
       
       
       private void initPageElements(){
    	       	   
    	   txt_AWBPrefix                  =MiscUtility.getWebElement(objFilepath, "OPR003_txt_AWBPrefix");
    	    txt_AWBNo                     =MiscUtility.getWebElement(objFilepath, "OPR003_txt_AWBNo");
    	    Tbl_ctmEnquiryTable           =MiscUtility.getWebElement(objFilepath, "OPR003_Tbl_ctmEnquiryTable");
    	    Btn_Details                   =MiscUtility.getWebElement(objFilepath, "OPR003_Btn_Details");
    	    Btn_List                      =MiscUtility.getWebElement(objFilepath, "OPR003_Btn_List");
    	    Btn_Close                     =MiscUtility.getWebElement(objFilepath, "OPR003_Btn_Close"); 
    	    Tbl_CTMDetails                =MiscUtility.getWebElement(objFilepath, "OPR002_Tbl_CTMDetails");
    	    chkbox_firstRow = MiscUtility.getWebElement(objFilepath, "OPR003_chkbox_ctmEnquiryTable_firstRow");   
    	    info_CTMrefNum=MiscUtility.getWebElement(objFilepath, "OPR002_info_CTMrefNum");
    	   btn_genericYes     = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
           btn_noBtn 		   = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
           info_msg		   = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
           info_error         = MiscUtility.getWebElement(genObjPath, "Generic_info_error") ;
           btn_ok             = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
           btn_Close1        =MiscUtility.getWebElement(objFilepath, "OPR002_btn_Close");
       }
       
       /****verifyTransfered
        * 
        * @param AWBNoPrefix
        * @param AWBNo
        * @param CTMReferance
        * @param Origin
        * @param Destination
        * @return
        */
       
       public OPR003 verifyTransfered(String AWBNoPrefix,String AWBNo,String CTMReferance,String Origin,String Destination){
		
    	   AWBNoPrefix=PropertyHandler.getPropValue(dataFilePath, AWBNoPrefix);
    	   AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	   CTMReferance=PropertyHandler.getPropValue(dataFilePath, CTMReferance);
    	   Origin=PropertyHandler.getPropValue(dataFilePath, Origin);
    	   Destination=PropertyHandler.getPropValue(dataFilePath, Destination);
    	   
    	   enterKeys(txt_AWBPrefix, AWBNoPrefix);
    	   enterKeys(txt_AWBNo, AWBNo);
    	   click(Btn_List);
    	   minWait();
    	   tblSelectRowByColValue(Tbl_ctmEnquiryTable, 1, 2, CTMReferance);
    	   click(Btn_Details);
    	   minWait();
    	   System.out.println(waitForElement(Tbl_CTMDetails).getText());
    	  Assert.assertTrue( waitForElement(Tbl_CTMDetails).getText().contains("Transferred Out"),"Error: Shipment not transfered");
    	  
    	  Assert.assertTrue( verifyValuePresentInTblColumn (Tbl_CTMDetails, 2, AWBNoPrefix+" "+AWBNo),"Error:Shipemnt not listed");
    	 // Assert.assertTrue( verifyValuePresentInTblColumn (Tbl_CTMDetails, 3, Origin),"Error:Shipemnt not listed");
    	  Assert.assertTrue( verifyValuePresentInTblColumn (Tbl_CTMDetails, 4, Destination),"Error:Shipemnt not listed");
    	  
    	  click(btn_Close1);
    	  minWait();
    	  
    	  minWait();
    	  driver.switchTo().defaultContent();
          if (verifyElementPresent(btn_genericYes)) {

              click(btn_genericYes);
          }
          waitForFrameAndSwitch(FRAME);
          
    	  return this;
    	   
       }
       
       /**
        * Verify shipment transferred
        * when CTMReference is not available
        * @param AWBNoPrefix
        * @param AWBNo
        * @param Origin
        * @param Destination
        * @return
        * @author a-7868 Krishna <08/03/2018>
        */
       public OPR003 verifyTransfered(String AWBNoPrefix,String AWBNo,String Origin,String Destination){
   		
    	   AWBNoPrefix=PropertyHandler.getPropValue(dataFilePath, AWBNoPrefix);
    	   AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	   Origin=PropertyHandler.getPropValue(dataFilePath, Origin);
    	   Destination=PropertyHandler.getPropValue(dataFilePath, Destination);
    	   
    	   enterKeys(txt_AWBPrefix, AWBNoPrefix);
    	   enterKeys(txt_AWBNo, AWBNo);
    	   click(Btn_List);
    	   minWait();
    	   check(chkbox_firstRow);
    	   click(Btn_Details);
    	   minWait();
    	   
    	  Assert.assertTrue( waitForElement(Tbl_CTMDetails).getText().contains("Transferred Out"),"Error: Shipment not transfered");
    	   
    	  Assert.assertTrue( verifyValuePresentInTblColumn (Tbl_CTMDetails, 2, AWBNoPrefix+AWBNo),"Error:Shipemnt not listed");
    	  Assert.assertTrue( verifyValuePresentInTblColumn (Tbl_CTMDetails, 3, Origin),"Error:Shipemnt not listed");
    	  Assert.assertTrue( verifyValuePresentInTblColumn (Tbl_CTMDetails, 4, Destination),"Error:Shipemnt not listed");
    	  click(btn_Close1);
    	  minWait();
    	  driver.switchTo().defaultContent();
          if (verifyElementPresent(btn_genericYes)) {

              click(btn_genericYes);
          }
          waitForFrameAndSwitch(FRAME);
    	  return this;
    	   
       }
       
       
       /***
        * Verify rejected status
        * @param AWBNoPrefix
        * @param AWBNo
        * @param CTMReferance
        * @return
        */
       public OPR003 verifyShipmentRejected(String AWBNoPrefix,String AWBNo){
		
    	   AWBNoPrefix=PropertyHandler.getPropValue(dataFilePath, AWBNoPrefix);
    	   AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	   
    	   
    	   enterKeys(txt_AWBPrefix, AWBNoPrefix);
    	   enterKeys(txt_AWBNo, AWBNo);
    	   click(Btn_List);
    	   minWait();
    	   System.out.println(getTableCellValue(Tbl_ctmEnquiryTable, 9, 1));
    	   tblSelectRowByColValue(Tbl_ctmEnquiryTable, 1, 9, "Shipment Rejected");
    	  
    	   
    	   return this;
    	   
       }
        /**
         * 
         * @param awbprefix
         * @param AWBNo
         * @return
         */
       public OPR003 storeCTMRefValue(String awbprefix,String AWBNo,String CTMref){
    	   
    	   awbprefix=PropertyHandler.getPropValue(dataFilePath, awbprefix);
    	   AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	   
    	   enterKeys(txt_AWBPrefix, awbprefix);
    	   enterKeys(txt_AWBNo, AWBNo);
    	   click(Btn_List);
    	   minWait();
    	   
    	   String tmpRef=waitForElement(info_CTMrefNum).getText();
    	   PropertyHandler.setPropValue(dataFilePath, CTMref, tmpRef);
		
    	   return this;
    	   
    	   
    }
             
       /**Close screen
        * 
        * @return
        */
       
       public HomePage close() {

           click(Btn_Close);
           driver.switchTo().defaultContent();
           if (verifyElementPresent(btn_genericYes)) {

               click(btn_genericYes);
           }
           return new HomePage(driver, dataFileName);
       }
}
