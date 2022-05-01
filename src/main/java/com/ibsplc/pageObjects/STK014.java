package com.ibsplc.pageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/18/2017.
 */
public class STK014 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK014";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    By txt_stockHolderCode,
    txt_stockHolderName,
    txt_controlPrivilege,
    btn_btList,
    chkBx_checkAll,
    btn_details,
    btn_reject,
    btn_btClose,
    tbl_bookingDtls,
    btn_clear,
    dropDown_stockHolderType,
    txt_approver,
    dropDown_awbPrefix,
    btn_btSave,
    dropDown_docType,
    dropDown_docSubType,
    txt_reorderLevel,
    txt_reorderQuantity,
    chkbox_reorderAlertFlag,
    txt_autoprocessQuantity,
    chkbox_autoRequestFlag,
    lnk_add,
    dropDown_docType1,
    dropDown_docSubType1,txt_autoprocessQuantity1,
    chkbox_autoPopulateFlag,txt_approver1,
    btn_lovapprover,
    btn_btlist,
    chkbox_lovcheckbox,
    btn_btok,chkbox_checkBox,
    lnk_delete;
    

    By btn_noBtn,
    btn_diaYes,
    info_msg;
    
    By stockHolderTable,
    	yesBtn;
    
    
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK014";
        txt_stockHolderCode = MiscUtility.getWebElement(objFilepath,"STK014_txt_stockHolderCode");
        txt_stockHolderName = MiscUtility.getWebElement(objFilepath,"STK014_txt_stockHolderName");
        txt_controlPrivilege= MiscUtility.getWebElement(objFilepath,"STK014_txt_controlPrivilege");
        txt_approver= MiscUtility.getWebElement(objFilepath,"STK014_txt_approver");
        txt_reorderLevel= MiscUtility.getWebElement(objFilepath,"STK014_txt_reorderLevel");
        txt_reorderQuantity= MiscUtility.getWebElement(objFilepath,"STK014_txt_reorderQuantity");
        txt_autoprocessQuantity= MiscUtility.getWebElement(objFilepath,"STK014_txt_autoprocessQuantity");
        dropDown_stockHolderType = MiscUtility.getWebElement(objFilepath,"STK014_dropDown_stockHolderType");
        dropDown_awbPrefix = MiscUtility.getWebElement(objFilepath,"STK014_dropDown_awbPrefix");
        btn_btList = MiscUtility.getWebElement(objFilepath,"STK014_btn_btList"); 
        info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_btClose = MiscUtility.getWebElement(objFilepath, "STK014_btn_btClose");
        btn_btSave= MiscUtility.getWebElement(objFilepath, "STK014_btn_btSave");
        dropDown_docType= MiscUtility.getWebElement(objFilepath,"STK014_dropDown_docType");
        dropDown_docSubType= MiscUtility.getWebElement(objFilepath,"STK014_dropDown_docSubType");
        chkbox_reorderAlertFlag= MiscUtility.getWebElement(objFilepath,"STK014_chkbox_reorderAlertFlag");
        chkbox_autoRequestFlag= MiscUtility.getWebElement(objFilepath,"STK014_chkbox_autoRequestFlag");
        lnk_add=  MiscUtility.getWebElement(objFilepath,"STK014_lnk_add");
        dropDown_docType1=MiscUtility.getWebElement(objFilepath,"STK014_dropDown_docType1");
        dropDown_docSubType1=MiscUtility.getWebElement(objFilepath,"STK014_dropDown_docSubType1");
        chkbox_autoPopulateFlag= MiscUtility.getWebElement(objFilepath,"STK014_chkbox_autoPopulateFlag");
        txt_approver1= MiscUtility.getWebElement(objFilepath,"STK014_txt_approver1");
        btn_lovapprover=MiscUtility.getWebElement(objFilepath,"STK014_btn_lovapprover");
        btn_btlist=MiscUtility.getWebElement(objFilepath,"STK014_btn_btlist");
        chkbox_lovcheckbox=MiscUtility.getWebElement(objFilepath,"STK014_chkbox_lovcheckbox");
        btn_btok=MiscUtility.getWebElement(objFilepath,"STK014_btn_btok");
        chkbox_checkBox	=MiscUtility.getWebElement(objFilepath,"STK014_chkbox_checkbox");	
        lnk_delete=MiscUtility.getWebElement(objFilepath,"STK014_lnk_delete");
        
        stockHolderTable=MiscUtility.getWebElement(objFilepath,"STK014_tbl_stkHldr");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }


	 public STK014(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	
	 
	
		 private static final String CHAR_LIST = 
			        "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			    private static final int RANDOM_STRING_LENGTH = 4;
			    
			    public String generateRandomString(){
			         
			        StringBuffer randStr = new StringBuffer();
			        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
			            int number = getRandomNumber();
			            char ch = CHAR_LIST.charAt(number);
			            randStr.append(ch);
			        }
			        return randStr.toString();
			    }
			    private int getRandomNumber() {
			        int randomInt = 0;
			        Random randomGenerator = new Random();
			        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
			        if (randomInt - 1 == -1) {
			            return randomInt;
			        } else {
			            return randomInt - 1;
			        }
			    }

			    public STK014 NewStockholderlisting(String stockHolderType, String stockHolderCode,String stockHolderName){

					 
					 
			    	stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
			    	
					 String stockHolderCode1 = generateRandomString();
					 stockHolderName=PropertyHandler.setPropValue(dataFilePath,stockHolderName, stockHolderCode1+stockHolderCode1.substring(0,1));
					 stockHolderCode1=PropertyHandler.setPropValue(dataFilePath,stockHolderName, stockHolderCode1+stockHolderCode1.substring(0,1));
					// stockHolderCode1 = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
					// stockHolderName = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
					
					 selectByText(dropDown_stockHolderType, stockHolderType);
					 enterKeys(txt_stockHolderCode, stockHolderCode1);
					 enterKeys(txt_stockHolderName, stockHolderName);
					 click(btn_btList);
					 minWait();
					 driver.switchTo().defaultContent();
					 String status = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("Stock holder code does not exist. Do you want to create a new stock holder?"), "ERROR :No Provision to create new stock holder.");
				     Assert.assertTrue(status.contains("Stock holder code does not exist. Do you want to create a new stock holder?"), "ERROR : No Provision to create new stock holder.");
				     minWait();
				     click(btn_noBtn);
				     minWait();
				     waitForFrameAndSwitch(FRAME);
				   //  click(btn_btClose);
				     return new STK014(driver,dataFileName);
				    }
			    
			    /**
			     * @author A-8260
			     * @param stockHolderType
			     * @param stockHolderCode
			     * @param stockHolderName
			     * @return
			     */
			    public STK014 listOrCreateNewStockHolder(String stockHolderType, String stockHolderCode,String stockHolderName)
			    {
			    	stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
			    	stockHolderCode = PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
			    	stockHolderName = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
					 
					 
					 
					 selectByText(dropDown_stockHolderType, stockHolderType);
					 enterKeys(txt_stockHolderCode, stockHolderCode);
					 enterKeys(txt_stockHolderName, stockHolderName);
					 click(btn_btList);
					 driver.switchTo().defaultContent();
					 if(verifyElementPresent(btn_diaYes))
						 click(btn_diaYes);
					 minWait();
					 waitForFrameAndSwitch(FRAME);
					 tblClickByColValue(stockHolderTable, 1);
					 tblsetTextByColValue(stockHolderTable, 3, 2, "AWB", "HQ");
					 
					 click(btn_btSave);
					 driver.switchTo().defaultContent();
					 minWait();
					 if(verifyElementPresent(btn_diaYes))
						 click(btn_diaYes);
					 minWait();
					 if(verifyElementPresent(btn_btok))
						 click(btn_btok);
					 
					 
			    	return this;
			    }
			    public STK014 CreateNewStockholder(String stockHolderType, String stockHolderCode,String stockHolderName,String Approver,String AWBprefix){

					 
					 
			    	stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
			    	//Doctype = PropertyHandler.getPropValue(dataFilePath,Doctype);
			    	//Subtype=PropertyHandler.getPropValue(dataFilePath,Subtype);
			    	Approver=PropertyHandler.getPropValue(dataFilePath,Approver);
			    	AWBprefix=	PropertyHandler.getPropValue(dataFilePath,AWBprefix);	
					 String stockHolderCode1 = generateRandomString();
					 PropertyHandler.setPropValue(dataFilePath,stockHolderCode, stockHolderCode1);
					 PropertyHandler.setPropValue(dataFilePath,stockHolderName, stockHolderCode1);
					// stockHolderCode1 = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
					// stockHolderName = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
					 
					 selectByText(dropDown_stockHolderType, stockHolderType);
					 enterKeys(txt_stockHolderCode, stockHolderCode1);
					 enterKeys(txt_stockHolderName, stockHolderCode1);
					 click(btn_btList);
					 minWait();
					 driver.switchTo().defaultContent();
					 String status = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("Stock holder code does not exist. Do you want to create a new stock holder?"), "ERROR :No Provision to create new stock holder.");
				     Assert.assertTrue(status.contains("Stock holder code does not exist. Do you want to create a new stock holder?"), "ERROR : No Provision to create new stock holder.");
				     minWait();
				     click(btn_diaYes);
				     minWait();
				     
				     waitForFrameAndSwitch(FRAME);
				     
				   //  selectByText(dropDown_docType,Doctype);
				    // selectByText(dropDown_docSubType,Subtype);
				     enterKeys(txt_approver,Approver);
				     selectByText(dropDown_awbPrefix,AWBprefix);
				     click(btn_btSave);
				     minWait();
				     driver.switchTo().defaultContent();
				     String status1 = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to save the data?"), "ERROR :New stock holder not saved");
				     Assert.assertTrue(status1.contains("Do you want to save the data?"), "ERROR :New stock holder not saved");
				     click(btn_diaYes);
				     minWait();
				     waitForFrameAndSwitch(FRAME);
				     return this;
				    }
			    public STK014 CaptureReorderDetails(String stockHolderType, String stockHolderCode,String stockHolderName,String Approver,String ReorderLevel,String ReorderQuantity){

					 
					 
			    	stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
			    	//Doctype = PropertyHandler.getPropValue(dataFilePath,Doctype);
			    	//Subtype=PropertyHandler.getPropValue(dataFilePath,Subtype);
			    	Approver=PropertyHandler.getPropValue(dataFilePath,Approver);

			    	ReorderLevel=PropertyHandler.getPropValue(dataFilePath,ReorderLevel);
			    	ReorderQuantity=PropertyHandler.getPropValue(dataFilePath,ReorderQuantity);
			    	stockHolderCode = PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
					stockHolderName = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
					 
					 selectByText(dropDown_stockHolderType, stockHolderType);
					 enterKeys(txt_stockHolderCode, stockHolderCode);
					 enterKeys(txt_stockHolderName, stockHolderName);
					 minWait();
					 click(btn_btList);
					 minWait();
					 click(btn_btList);
					 minWait();
					 driver.switchTo().defaultContent();
					 
				     waitForFrameAndSwitch(FRAME);
				     
				   //  selectByText(dropDown_docType,Doctype);
				    // selectByText(dropDown_docSubType,Subtype);
				     enterKeys(txt_reorderLevel,ReorderLevel);
				     enterKeys(txt_reorderQuantity,ReorderQuantity);
				     check(chkbox_reorderAlertFlag);
				     click(btn_btSave);
				     minWait();
				     driver.switchTo().defaultContent();
				     String status1 = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to save the data?"), "ERROR :New stock holder not saved");
				     Assert.assertTrue(status1.contains("Do you want to save the data?"), "ERROR :New stock holder not saved");
				     click(btn_diaYes);
				     minWait();
				     waitForFrameAndSwitch(FRAME);
				     return new STK014(driver,dataFileName);
				    }
			    public STK014 CheckReorderAlert(String stockHolderType, String stockHolderCode,String stockHolderName,String Approver,String ReorderLevel,String ReorderQuantity){

					 
					 
			    	stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
			    	//Doctype = PropertyHandler.getPropValue(dataFilePath,Doctype);
			    	//Subtype=PropertyHandler.getPropValue(dataFilePath,Subtype);
			    	//Approver=PropertyHandler.getPropValue(dataFilePath,Approver);

			    	ReorderLevel=PropertyHandler.getPropValue(dataFilePath,ReorderLevel);
			    //	ReorderQuantity=PropertyHandler.getPropValue(dataFilePath,ReorderQuantity);
			    	stockHolderCode = PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
					stockHolderName = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
					 
					 
					 selectByText(dropDown_stockHolderType, stockHolderType);
					 enterKeys(txt_stockHolderCode, stockHolderCode);
					 enterKeys(txt_stockHolderName, stockHolderName);
					 minWait();
					 click(btn_btList);
					 minWait();
					 click(btn_btList);
					 minWait();
					 driver.switchTo().defaultContent();
					 
				     waitForFrameAndSwitch(FRAME);
				     
				   //  selectByText(dropDown_docType,Doctype);
				    // selectByText(dropDown_docSubType,Subtype);
				     enterKeys(txt_reorderLevel,ReorderLevel);
				   //  enterKeys(txt_reorderQuantity,ReorderQuantity);
				  //   check(chkbox_reorderAlertFlag);
				     click(btn_btSave);
				     minWait();
				     driver.switchTo().defaultContent();
				     String status1 = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to save the data?"), "ERROR :New stock holder not saved");
				     Assert.assertTrue(status1.contains("Do you want to save the data?"), "ERROR :New stock holder not saved");
				     click(btn_diaYes);
				     minWait();
				     waitForFrameAndSwitch(FRAME);
				     return new STK014(driver,dataFileName);
				    }
			    public STK014 AutoStockRequest(String stockHolderType, String stockHolderCode,String stockHolderName,String Approver,String AWBprefix,String autoprocessQuantity){

					 
					 
			    	stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
			    	//Doctype = PropertyHandler.getPropValue(dataFilePath,Doctype);
			    	//Subtype=PropertyHandler.getPropValue(dataFilePath,Subtype);
			    	Approver=PropertyHandler.getPropValue(dataFilePath,Approver);
			    	AWBprefix=	PropertyHandler.getPropValue(dataFilePath,AWBprefix);
			    	autoprocessQuantity=	PropertyHandler.getPropValue(dataFilePath,autoprocessQuantity);
			    	
					 String stockHolderCode1 = generateRandomString();
					 PropertyHandler.setPropValue(dataFilePath,stockHolderCode, stockHolderCode1);
					 PropertyHandler.setPropValue(dataFilePath,stockHolderName, stockHolderCode1);
					// stockHolderCode1 = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
					// stockHolderName = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
					 
					 selectByText(dropDown_stockHolderType, stockHolderType);
					 enterKeys(txt_stockHolderCode, stockHolderCode1);
					 enterKeys(txt_stockHolderName, stockHolderCode1);
					 click(btn_btList);
					 minWait();
					 driver.switchTo().defaultContent();
					 String status = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("Stock holder code does not exist. Do you want to create a new stock holder?"), "ERROR :No Provision to create new stock holder.");
				     Assert.assertTrue(status.contains("Stock holder code does not exist. Do you want to create a new stock holder?"), "ERROR : No Provision to create new stock holder.");
				     minWait();
				     click(btn_diaYes);
				     minWait();
				     
				     waitForFrameAndSwitch(FRAME);
				     
				   //  selectByText(dropDown_docType,Doctype);
				    // selectByText(dropDown_docSubType,Subtype);
				     enterKeys(txt_approver1,Approver);
				     selectByText(dropDown_awbPrefix,AWBprefix);
				     enterKeys(txt_autoprocessQuantity,autoprocessQuantity);
				     check(chkbox_autoRequestFlag);
				     click(btn_btSave);
				     minWait();
				     driver.switchTo().defaultContent();
				     String status1 = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to save the data?"), "ERROR :New stock holder not saved");
				     Assert.assertTrue(status1.contains("Do you want to save the data?"), "ERROR :New stock holder not saved");
				     click(btn_diaYes);
				     minWait();
				     waitForFrameAndSwitch(FRAME);
				     return new STK014(driver,dataFileName);
				    }
			    public STK014 Addnewrecord(String stockHolderType, String stockHolderCode,String stockHolderName,String Doctype,String Subtype,String Approver){

					 
					 
			    	stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
			    	Doctype = PropertyHandler.getPropValue(dataFilePath,Doctype);
			    	Subtype=PropertyHandler.getPropValue(dataFilePath,Subtype);
			    	Approver=PropertyHandler.getPropValue(dataFilePath,Approver);
			    	//AWBprefix=	PropertyHandler.getPropValue(dataFilePath,AWBprefix);
			    	//autoprocessQuantity=	PropertyHandler.getPropValue(dataFilePath,autoprocessQuantity);
			    	
					// String stockHolderCode1 = generateRandomString();
					// PropertyHandler.setPropValue(dataFilePath,stockHolderCode, stockHolderCode1);
					// PropertyHandler.setPropValue(dataFilePath,stockHolderName, stockHolderCode1);
			    	stockHolderCode = PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
					stockHolderName = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
					 
					 selectByText(dropDown_stockHolderType, stockHolderType);
					 enterKeys(txt_stockHolderCode, stockHolderCode);
					 enterKeys(txt_stockHolderName, stockHolderName);
					 click(btn_btList);
					 minWait();
					 driver.switchTo().defaultContent();
					 
				     minWait();
				     
				     waitForFrameAndSwitch(FRAME);
				     click(lnk_add);
				     //  selectByText(dropDown_docType,Doctype);
				    // selectByText(dropDown_docSubType,Subtype);
				     minWait();
				   //  driver.switchTo().defaultContent();
				    
				     selectByText(dropDown_docType1,Doctype);
				     selectByText(dropDown_docSubType1,Subtype);
				     minWait();
				     
				    // enterKeys(txt_approver,Approver);
				    // enterKeys(txt_autoprocessQuantity,autoprocessQuantity);
				     /*click(btn_lovapprover);
				    
				     minWait();
				     
                       switchToSecondWindow();
				        waitForNewWindow(2);
				        enterKeys(txt_approver,Approver);
				        click(btn_btlist);
				        minWait();
				        check(chkbox_lovcheckbox);
				        click(btn_btok);
				        
				        minWait();
					     switchToFirstWindow();
					     waitForFrameAndSwitch(FRAME);
					*/  
				     
				     enterKeys(getWebElements(txt_approver1).get(1), Approver);
				     check(chkbox_autoPopulateFlag);
				     click(btn_btSave);
				     minWait();
				     driver.switchTo().defaultContent();
				     String status1 = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to save the data?"), "ERROR :Record not added to stockholder");
				     Assert.assertTrue(status1.contains("Do you want to save the data?"), "ERROR :Record not added to stockholder");
				     click(btn_diaYes);
				     minWait();
				     waitForFrameAndSwitch(FRAME);
				     return new STK014(driver,dataFileName);
				    }
			    public STK014 DeleteRecord(String stockHolderType, String stockHolderCode,String stockHolderName){

					 
					 
			    	stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
			    //	Doctype = PropertyHandler.getPropValue(dataFilePath,Doctype);
			    //	Subtype=PropertyHandler.getPropValue(dataFilePath,Subtype);
			    //	Approver=PropertyHandler.getPropValue(dataFilePath,Approver);
			    	//AWBprefix=	PropertyHandler.getPropValue(dataFilePath,AWBprefix);
			    	//autoprocessQuantity=	PropertyHandler.getPropValue(dataFilePath,autoprocessQuantity);
			    	
					// String stockHolderCode1 = generateRandomString();
					// PropertyHandler.setPropValue(dataFilePath,stockHolderCode, stockHolderCode1);
					// PropertyHandler.setPropValue(dataFilePath,stockHolderName, stockHolderCode1);
			    	stockHolderCode = PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
					stockHolderName = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
					 
					 selectByText(dropDown_stockHolderType, stockHolderType);
					 enterKeys(txt_stockHolderCode, stockHolderCode);
					 enterKeys(txt_stockHolderName, stockHolderName);
					 click(btn_btList);
				
					 
				     minWait();
				     
				  
				    check(chkbox_checkBox);
				    click(lnk_delete);
				     minWait();
				
				    
				   //  selectByText(dropDown_docType1,Doctype);
				  //   selectByText(dropDown_docSubType1,Subtype);
				    // enterKeys(txt_approver,Approver);
				    // enterKeys(txt_autoprocessQuantity,autoprocessQuantity);
				    				        
				   //     minWait();
					     
					//     waitForFrameAndSwitch(FRAME);
					  
				     check(chkbox_autoPopulateFlag);
				     click(btn_btSave);
				     minWait();
				     driver.switchTo().defaultContent();
				     String status1 = waitForElement(info_msg).getText();
					 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to save the data?"), "ERROR :Record not added to stockholder");
				     Assert.assertTrue(status1.contains("Do you want to save the data?"), "ERROR :Record not added to stockholder");
				     click(btn_diaYes);
				     minWait();
				     waitForFrameAndSwitch(FRAME);
				     return new STK014(driver,dataFileName);
				    }

			   			        
			        
			        public HomePage close() {

			        	minWait();
			        	Actions action = new Actions(driver);
			        	action.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).perform();  	 
			        	
			        	driver.switchTo().defaultContent();
			            if (verifyElementPresent(yesBtn)) {

			                click(yesBtn);
			            }
			            return new HomePage(driver, dataFileName);
			        }
			        
			        public STK014 AddnewrecordSubtypeM(String stockHolderType, String stockHolderCode,String stockHolderName,String Doctype,String Subtype,String Approver){

						 
						 
				    	stockHolderType = PropertyHandler.getPropValue(dataFilePath,stockHolderType);
				    	Doctype = PropertyHandler.getPropValue(dataFilePath,Doctype);
				    	Subtype=PropertyHandler.getPropValue(dataFilePath,Subtype);
				    	Approver=PropertyHandler.getPropValue(dataFilePath,Approver);
				    	//AWBprefix=	PropertyHandler.getPropValue(dataFilePath,AWBprefix);
				    	//autoprocessQuantity=	PropertyHandler.getPropValue(dataFilePath,autoprocessQuantity);
				    	
						// String stockHolderCode1 = generateRandomString();
						// PropertyHandler.setPropValue(dataFilePath,stockHolderCode, stockHolderCode1);
						// PropertyHandler.setPropValue(dataFilePath,stockHolderName, stockHolderCode1);
				    	stockHolderCode = PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
						stockHolderName = PropertyHandler.getPropValue(dataFilePath,stockHolderName);
						 
						 selectByText(dropDown_stockHolderType, stockHolderType);
						 enterKeys(txt_stockHolderCode, stockHolderCode);
						 enterKeys(txt_stockHolderName, stockHolderName);
						 click(btn_btList);
						 minWait();
						 driver.switchTo().defaultContent();
						 
					     minWait();
					     
					     waitForFrameAndSwitch(FRAME);
					     if(!(waitForElement(dropDown_docType).getAttribute("value").equalsIgnoreCase(Subtype)))
					     {
					     click(lnk_add);
					     //  selectByText(dropDown_docType,Doctype);
					    // selectByText(dropDown_docSubType,Subtype);
					     minWait();
					   //  driver.switchTo().defaultContent();
					    
					     selectByText(dropDown_docType1,Doctype);
					     selectByText(dropDown_docSubType1,Subtype);
					     minWait();
					     
					    // enterKeys(txt_approver,Approver);
					    // enterKeys(txt_autoprocessQuantity,autoprocessQuantity);
					     /*click(btn_lovapprover);
					    
					     minWait();
					     
	                       switchToSecondWindow();
					        waitForNewWindow(2);
					        enterKeys(txt_approver,Approver);
					        click(btn_btlist);
					        minWait();
					        check(chkbox_lovcheckbox);
					        click(btn_btok);
					        
					        minWait();
						     switchToFirstWindow();
						     waitForFrameAndSwitch(FRAME);
						*/  
					     
					     enterKeys(getWebElements(txt_approver1).get(1), Approver);
					     check(chkbox_autoPopulateFlag);
					     click(btn_btSave);
					     minWait();
					     driver.switchTo().defaultContent();
					     String status1 = waitForElement(info_msg).getText();
						 Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to save the data?"), "ERROR :Record not added to stockholder");
					     Assert.assertTrue(status1.contains("Do you want to save the data?"), "ERROR :Record not added to stockholder");
					     click(btn_diaYes);
					     minWait();
					     waitForFrameAndSwitch(FRAME);
					     }
					     return new STK014(driver,dataFileName);
					    }
			    

	 
}
