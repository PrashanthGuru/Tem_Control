package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class QMS009 extends BasePage{

	public QMS009(WebDriver driver, String testDataFile) {
		super(driver);
		this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver,this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
        initPageElements();
	}
	
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "QMS_ACC.properties");
	public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","Generic.properties");
	public static String filepath;
	public final static String FRAME = "iCargoContentFrameQMS009";
	
	WebDriver driver;    
    String testDataFile;
    
    By btn_dialogueYes,
    btn_dialogueNo,
    btn_dialogueOk,
    info_dialogueContent,
    info_footerNotification,
    dropdown_transactionCode,
    dropdown_event,
    btn_list,
    btn_clear,
    btn_add,
    btn_delete,
    tableField_dropdown_transactionCode,
    tableField_dropdown_event,
    tableField_btn_notifyToDetails,
    notifyTo_txt_templateId,
    notifyTo_btn_addDefaultRecipient,
    notifyTo_dropdown_recipient,
    notifyTo_dropdown_type,
    notifyTo_btn_ok,
    notifyTo_btn_close,
    btn_save,
    btn_close,
    chkbox_selectTableItem;
    
    private void initPageElements(){
    	
    	btn_dialogueYes = MiscUtility.getWebElement(genFilepath,"Generic_btn_diaYes");
        btn_dialogueNo = MiscUtility.getWebElement(genFilepath,"Generic_btn_noBtn");
        btn_dialogueOk = MiscUtility.getWebElement(genFilepath,"Generic_btn_ok");
        info_dialogueContent = MiscUtility.getWebElement(genFilepath,"Generic_info_msg");
        info_footerNotification = MiscUtility.getWebElement(genFilepath,"Generic_foot_layer");
        
        dropdown_transactionCode = MiscUtility.getWebElement(objFilepath,"QMS009_dropdown_transactionCode");
        dropdown_event = MiscUtility.getWebElement(objFilepath,"QMS009_dropdown_event");
        btn_list = MiscUtility.getWebElement(objFilepath,"QMS009_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath,"QMS009_btn_clear");
        btn_add = MiscUtility.getWebElement(objFilepath,"QMS009_btn_add");
        btn_delete = MiscUtility.getWebElement(objFilepath,"QMS009_btn_delete");
        tableField_dropdown_transactionCode = MiscUtility.getWebElement(objFilepath,"QMS009_tableField_dropdown_transactionCode");
        tableField_dropdown_event = MiscUtility.getWebElement(objFilepath,"QMS009_tableField_dropdown_event");
        tableField_btn_notifyToDetails = MiscUtility.getWebElement(objFilepath,"QMS009_tableField_btn_notifyToDetails");
        notifyTo_txt_templateId = MiscUtility.getWebElement(objFilepath,"QMS009_NotifyTo_txt_templateId");
        notifyTo_btn_addDefaultRecipient = MiscUtility.getWebElement(objFilepath,"QMS009_NotifyTo_btn_addDefaultRecipient");
        notifyTo_dropdown_recipient = MiscUtility.getWebElement(objFilepath,"QMS009_NotifyTo_dropdown_recipient");
        notifyTo_dropdown_type = MiscUtility.getWebElement(objFilepath,"QMS009_NotifyTo_dropdown_type");
        notifyTo_btn_ok = MiscUtility.getWebElement(objFilepath,"QMS009_NotifyTo_btn_ok");
        notifyTo_btn_close = MiscUtility.getWebElement(objFilepath,"QMS009_NotifyTo_btn_close");
        btn_save = MiscUtility.getWebElement(objFilepath,"QMS009_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath,"QMS009_btn_close");
        chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath,"QMS009_chkbox_selectTableItem");
    }
    
    private void list(String transactionCode, String event){
    	selectByText(waitForElement(dropdown_transactionCode), transactionCode);
    	selectByText(dropdown_event, event);
    	click(btn_list);
    }
    /**
     * Created by A-7605 on 23-3-18
     * This method create new notification, if none exists
     * @param transactionCode
     * @param event
     * @param defaultRecipient
     * @param type
     * @param templateId
     * @return
     */
    public QMS009 createNotification(String transactionCode, String event, String defaultRecipient, String type, String templateId){
    	transactionCode = PropertyHandler.getPropValue(filepath, transactionCode);
    	event = PropertyHandler.getPropValue(filepath, event);
    	defaultRecipient = PropertyHandler.getPropValue(filepath, defaultRecipient);
    	type = PropertyHandler.getPropValue(filepath, type);
    	templateId = PropertyHandler.getPropValue(filepath, templateId);
    	
    	list(transactionCode, event);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_dialogueYes)){
    		click(btn_dialogueYes);
    		waitForFrameAndSwitch(FRAME);
    		click(btn_add);
    		minWait();
    		selectByText(tableField_dropdown_transactionCode, transactionCode);
//    		enterKeys(tableField_dropdown_transactionCode, Keys.TAB);
    		minWait();
    		selectByText(tableField_dropdown_event, event);
    		click(tableField_btn_notifyToDetails);
    		driver.switchTo().defaultContent();
    		waitForNewWindow(2);
    		switchToSecondWindow();
    		enterKeys(waitForElement(notifyTo_txt_templateId), templateId);
    		click(notifyTo_btn_addDefaultRecipient);
    		selectByText(waitForElement(notifyTo_dropdown_recipient), defaultRecipient);
    		selectByText(notifyTo_dropdown_type, type);
    		click(notifyTo_btn_ok);
    		switchToFirstWindow();
    		waitForFrameAndSwitch(FRAME);
    		click(btn_save);
    		driver.switchTo().defaultContent();
    		Assert.assertTrue(waitForElement(info_footerNotification).getText().contains("saved successfully"));   		
    	}
    		waitForFrameAndSwitch(FRAME);
    	return this;
    }
    /**
     * Created by A-7605 on 23-3-18
     * This method close the current page and return to home page
     * @return
     */
    public HomePage close(){
    	click(btn_close);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_dialogueYes))
    		click(btn_dialogueYes);
    	return new HomePage(driver, testDataFile);
    }
    /**
     * Created by A-7605 on 3-4-18
     * @param transactionCode
     * @param event
     * @return
     */
    public QMS009 deleteNotification(String transactionCode, String event){
    	transactionCode = PropertyHandler.getPropValue(filepath, transactionCode);
    	event = PropertyHandler.getPropValue(filepath, event);
    	
    	list(transactionCode, event);
    	check(chkbox_selectTableItem);
    	click(btn_delete);
    	click(btn_save);
		driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(info_footerNotification).getText().contains("saved successfully")); 
		click(waitForElement(btn_dialogueNo));
		minWait();
		waitForFrameAndSwitch(FRAME);
    	return this; 
    }

}
