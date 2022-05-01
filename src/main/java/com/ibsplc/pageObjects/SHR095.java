package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class SHR095 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
  
    public static String FRAME = "iCargoContentFrameSHR095";
    
    private By txt_templateID,
    	btn_list,
    	btnDialog_Yes,
    	btnDialog_Ok,
    	dialogueMsg_success,
    	txt_templateName,
    	txt_templateDescription,
    	btn_add,
    	txt_text,
    	dropdown_device,
    	dropdown_responseType,
    	chkbox_mandatory,
    	dropdown_obligatoryAnswer,
    	txt_dependsOn,
    	btn_save,
    	btn_clear,
    	txt_options,
    	btn_close;
    
    private WebDriver driver;
    private String dataFileName; 
    
    public SHR095(WebDriver driver,String dataFileName){
    	super(driver);
    	this.driver = driver;
    	initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    
    
    private void initElements(){
    	txt_templateID = MiscUtility.getWebElement(objFilepath, "SHR095_txt_templateID");
    	txt_templateDescription = MiscUtility.getWebElement(objFilepath, "SHR095_txt_templateDescription");
    	btn_list = MiscUtility.getWebElement(objFilepath, "SHR095_btn_list");
    	btnDialog_Yes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btnDialog_Ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    	dialogueMsg_success = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    	txt_templateName = MiscUtility.getWebElement(objFilepath, "SHR095_txt_templateName");
    	btn_add = MiscUtility.getWebElement(objFilepath, "SHR095_btn_add");
    	txt_text = MiscUtility.getWebElement(objFilepath, "SHR095_txt_text");
    	dropdown_device = MiscUtility.getWebElement(objFilepath, "SHR095_dropdown_device");
    	dropdown_responseType = MiscUtility.getWebElement(objFilepath, "SHR095_dropdown_responseType");
    	chkbox_mandatory = MiscUtility.getWebElement(objFilepath, "SHR095_chkbox_mandatory");
    	dropdown_obligatoryAnswer = MiscUtility.getWebElement(objFilepath, "SHR095_dropdown_obligatoryAnswer");
    	txt_dependsOn = MiscUtility.getWebElement(objFilepath, "SHR095_txt_dependsOn");
    	btn_save = MiscUtility.getWebElement(objFilepath, "SHR095_btn_save");
    	btn_close = MiscUtility.getWebElement(objFilepath, "SHR095_btn_close");
    	btn_clear = MiscUtility.getWebElement(objFilepath, "SHR095_btn_clear");   	
    	txt_options = MiscUtility.getWebElement(objFilepath, "SHR095_txt_options");
    }
    
    
    /**
	 * Created by a-7605 on 03/01/2017
	 */
    
    public SHR095 createTemplate(String templateID, String templateName,String templateDescription,String text,String device,String responseType,String options,String isMandatory,String obligatoryAnswer,String dependsOn){

    	templateName = PropertyHandler.getPropValue(dataFilePath, templateName);
    	templateDescription = PropertyHandler.getPropValue(dataFilePath, templateDescription);
    	text = PropertyHandler.getPropValue(dataFilePath, text);
    	device = PropertyHandler.getPropValue(dataFilePath, device);
    	responseType = PropertyHandler.getPropValue(dataFilePath, responseType);
    	options = PropertyHandler.getPropValue(dataFilePath, options);
    	isMandatory = PropertyHandler.getPropValue(dataFilePath, isMandatory);
    	obligatoryAnswer = PropertyHandler.getPropValue(dataFilePath, obligatoryAnswer);
    	dependsOn = PropertyHandler.getPropValue(dataFilePath, dependsOn);
    	String successMessage;
    	String id = null;
    	
    	while(true){
    		id = BizUtility.generateRandomAlphaNumericValue(5);
    		enterKeys(txt_templateID, id);
        	click(btn_list);
        	driver.switchTo().defaultContent();
        	if (verifyElementPresent(btnDialog_Yes)) {
                click(btnDialog_Yes);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);
            click(waitForElement(btn_clear));
    	}
    	PropertyHandler.setPropValue(dataFilePath, templateID, id);
    	enterKeys(txt_templateName, templateName);
    	enterKeys(txt_templateDescription, templateDescription);
    	click(waitForElement(btn_add));
    	enterKeys(txt_text, text);
    	selectByText(dropdown_device, device);
    	selectByText(dropdown_responseType, responseType);
    	if(options != null && options.trim().length()>0)
    		enterKeys(txt_options, options);
    	if(isMandatory!=null && (isMandatory.equalsIgnoreCase("yes") || isMandatory.equalsIgnoreCase("true")))
    		check(chkbox_mandatory);
    	if(obligatoryAnswer != null && obligatoryAnswer.trim().length()>0)
    		selectByText(dropdown_obligatoryAnswer, obligatoryAnswer);   	
    	if(dependsOn != null && dependsOn.trim().length()>0)
    		enterKeys(txt_dependsOn, dependsOn);
    	
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	click(waitForElement(btnDialog_Yes));
    	successMessage = waitForElement(dialogueMsg_success).getText();
    	click(btnDialog_Ok);
    	Assert.assertTrue(successMessage.equals("Successfully saved"),"Original notification message is '"+successMessage+"'");
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    public HomePage close(){
    	click(btn_close);
		
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btnDialog_Yes)) {

             click(btnDialog_Yes);
         }
		
		return new HomePage(driver,dataFileName);
	}
}
