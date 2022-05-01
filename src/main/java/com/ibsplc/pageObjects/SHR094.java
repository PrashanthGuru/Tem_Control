package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class SHR094 extends BasePage{

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
  
    public static String FRAME = "iCargoContentFrameSHR094";
    private WebDriver driver;
    private String dataFileName; 
    
    By dropdown_transaction,
    	dropdown_awbOrigin,                                                        
    	txt_awbOrigin,
    	dropdown_viaPoint,
    	txt_viaPoint,
    	dropdown_awbDestination,                                                          
    	txt_awbDestination,                                                          
    	txt_scc,                                                          
    	txt_commodity,                                                          
    	btn_list,                                                        
    	btn_create,                                                          
    	dropdown_checksheetConfig_transaction,                                                          
	    checksheetConfig_txt_template,                                                          
	    checksheetConfig_txt_airport,                                                          
	    checksheetConfig_txt_airportGroup,                                                          
	    checksheetConfig_txt_commodity,                                                          
	    checksheetConfig_txt_commodityGroup,                                                          
	    checksheetConfig_txt_scc,                                                          
	    checksheetConfig_txt_sccGroup,                                                          
	    checksheetConfig_dropdown_awbOrigin,                                                          
	    checksheetConfig_txt_awbOrigin,                                                          
	    checksheetConfig_dropdown_awbDestination,                                                          
	    checksheetConfig_txt_awbDestination,                                                          
	    checksheetConfig_dropdown_viaPoint,                                                          
	    checksheetConfig_txt_viaPoint,                                                          
	    checksheetConfig_txt_bookedFlightCarrierCode,                                                          
	    checksheetConfig_txt_bookedFlightNo,                                                          
	    checksheetConfig_chkbox_unknownShipper,                                                          
	    checksheetConfig_txt_shipper,                                                          
	    checksheetConfig_dropdown_minWeight,                                                          
	    checksheetConfig_txt_minWeight,                                            
	    checksheetConfig_dropdown_minVolume,                                                          
	    checksheetConfig_txt_minVolume,                                                          
	    checksheetConfig_txt_aircraftType,                                                      
	    checksheetConfig_txt_product,                                                          
	    checksheetConfig_txt_queueReasonCode,                                                          
	    checksheetConfig_btn_save,                                      
	    checksheetConfig_btn_close,                                                          
	    btn_inactivate,                                                          
	    btn_activate,                                                          
	    btn_close,
	    btnDialog_Ok,
	    btnDialog_Yes,
	    btnDialog_No,
	    dialogueMsg_success,
	    dropdown_status,
	    chkbox_selectAllTableItems,
	    chkbox_selectTableItem,
	    btn_clear,
	    tbl_configDtls;
    
    public SHR094(WebDriver driver, String dataFileName){
    	super(driver);
    	this.driver = driver;
    	initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    
    
    private void initElements(){
    	dropdown_transaction = MiscUtility.getWebElement(objFilepath, "SHR094_dropdown_transaction");
    	dropdown_awbOrigin = MiscUtility.getWebElement(objFilepath, "SHR094_dropdown_awbOrigin");
    	txt_awbOrigin = MiscUtility.getWebElement(objFilepath, "SHR094_txt_awbOrigin");
    	dropdown_viaPoint = MiscUtility.getWebElement(objFilepath, "SHR094_dropdown_viaPoint");
    	txt_viaPoint = MiscUtility.getWebElement(objFilepath, "SHR094_txt_viaPoint");
    	dropdown_awbDestination = MiscUtility.getWebElement(objFilepath, "SHR094_dropdown_awbDestination");
    	txt_awbDestination = MiscUtility.getWebElement(objFilepath, "SHR094_txt_awbDestination");
    	txt_scc = MiscUtility.getWebElement(objFilepath, "SHR094_txt_scc");
    	txt_commodity = MiscUtility.getWebElement(objFilepath, "SHR094_txt_commodity");
    	btn_list = MiscUtility.getWebElement(objFilepath, "SHR094_btn_list");
    	btn_create = MiscUtility.getWebElement(objFilepath, "SHR094_btn_create");
    	dropdown_checksheetConfig_transaction = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_dropdown_transaction");
    	checksheetConfig_txt_template = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_template");
    	checksheetConfig_txt_airport = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_airport");
    	checksheetConfig_txt_airportGroup = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_airportGroup");
    	checksheetConfig_txt_commodity = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_commodity");
    	checksheetConfig_txt_commodityGroup = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_commodityGroup");
    	checksheetConfig_txt_scc = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_scc");
    	checksheetConfig_txt_sccGroup = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_sccGroup");
    	checksheetConfig_dropdown_awbOrigin = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_dropdown_awbOrigin");
    	checksheetConfig_txt_awbOrigin = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_awbOrigin");
    	checksheetConfig_dropdown_awbDestination = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_dropdown_awbDestination");
    	checksheetConfig_txt_awbDestination = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_awbDestination");
    	checksheetConfig_dropdown_viaPoint = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_dropdown_viaPoint");
    	checksheetConfig_txt_viaPoint = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_viaPoint");
    	checksheetConfig_txt_bookedFlightCarrierCode = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_bookedFlightCarrierCode");
    	checksheetConfig_txt_bookedFlightNo = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_bookedFlightNo");
    	checksheetConfig_chkbox_unknownShipper = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_chkbox_unknownShipper");
    	checksheetConfig_txt_shipper = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_shipper");
    	checksheetConfig_dropdown_minWeight = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_dropdown_minWeight");
    	checksheetConfig_txt_minWeight = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_minWeight");
    	checksheetConfig_dropdown_minVolume = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_dropdown_minVolume");
    	checksheetConfig_txt_minVolume = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_minVolume");
    	checksheetConfig_txt_aircraftType = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_aircraftType");
    	checksheetConfig_txt_product = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_product");
    	checksheetConfig_txt_queueReasonCode = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_txt_queueReasonCode");
    	checksheetConfig_btn_save = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_btn_save");
    	checksheetConfig_btn_close = MiscUtility.getWebElement(objFilepath, "SHR094_checksheetConfig_btn_close");
    	btn_inactivate = MiscUtility.getWebElement(objFilepath, "SHR094_btn_inactivate");
    	btn_activate = MiscUtility.getWebElement(objFilepath, "SHR094_btn_activate");
    	btn_close = MiscUtility.getWebElement(objFilepath, "SHR094_btn_close");
    	btnDialog_Yes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btnDialog_Ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    	dialogueMsg_success = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    	btnDialog_No = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
    	dropdown_status = MiscUtility.getWebElement(objFilepath, "SHR094_dropdown_status");
    	chkbox_selectAllTableItems = MiscUtility.getWebElement(objFilepath, "SHR094_chkbox_selectAllTableItems");
    	tbl_configDtls=MiscUtility.getWebElement(objFilepath, "SHR094_tbl_configTable");
    	chkbox_selectTableItem = MiscUtility.getWebElement(objFilepath, "SHR094_chkbox_selectTableItem");
    	btn_clear = MiscUtility.getWebElement(objFilepath, "SHR094_btn_clear");
    }
    
    
    private void listChecksheet(String transaction, String originLevel, String origin, String viaPointLevel, String viaPoint, String destinationLevel, String destination, String scc, String commodity, String status){
    	selectByText(waitForElement(dropdown_transaction), transaction);
    	if(originLevel != null && originLevel.trim().length()>0){
    		selectByText(dropdown_awbOrigin, originLevel);
    		enterKeys(txt_awbOrigin, origin);
    	}
    	if(viaPointLevel != null && viaPointLevel.trim().length()>0){
    		selectByText(dropdown_viaPoint, viaPointLevel);
    		enterKeys(txt_viaPoint, viaPoint);
    	}
    	if(destinationLevel != null && destinationLevel.trim().length()>0){
    		selectByText(dropdown_awbDestination, destinationLevel);
    		enterKeys(txt_awbDestination, destination);
    	}
    	enterKeys(txt_scc, scc);
    	enterKeys(txt_commodity, commodity);
    	if(status != null && status.trim().length()>0)
    		selectByText(dropdown_status, status);
    	click(btn_list);
    	minWait();
    }
    /**
     * Created by a-7605 on 03/01/2017
     * This method activate checksheet config, if already exits and create new on if one do not exist
     * @param transaction
     * @param originLevel
     * @param origin
     * @param viaPointLevel
     * @param viaPoint
     * @param destinationLevel
     * @param destination
     * @param airport
     * @param airportGroup
     * @param scc
     * @param sccGroup
     * @param commodity
     * @param commodityGroup
     * @param templateID
     * @param flightCarrierCode
     * @param flightNo
     * @param isUnknowShipper
     * @param shipper
     * @param minWeight
     * @param minWeightUnit
     * @param minVolume
     * @param minVolumeUnit
     * @param aircraftType
     * @param product
     * @param queueReasonCode
     * @return
     */
    
    public SHR094 createChecksheetConfig(String transaction,String originLevel,String origin,String viaPointLevel, String viaPoint,
    		String destinationLevel, String destination, String airport, String airportGroup,String scc,String sccGroup, String commodity,String commodityGroup, String templateID,
    		String flightCarrierCode, String flightNo, String isUnknowShipper, String shipper, String minWeight, String minWeightUnit,
    		String minVolume, String minVolumeUnit, String aircraftType, String product, String queueReasonCode){
    	
    	
    	transaction = PropertyHandler.getPropValue(dataFilePath, transaction);
    	originLevel = PropertyHandler.getPropValue(dataFilePath, originLevel);
    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
    	viaPointLevel = PropertyHandler.getPropValue(dataFilePath, viaPointLevel);
    	viaPoint = PropertyHandler.getPropValue(dataFilePath, viaPoint);
    	destinationLevel = PropertyHandler.getPropValue(dataFilePath, destinationLevel);
    	destination = PropertyHandler.getPropValue(dataFilePath, destination);
    	airport = PropertyHandler.getPropValue(dataFilePath, airport);
    	scc = PropertyHandler.getPropValue(dataFilePath, scc);
    	sccGroup = PropertyHandler.getPropValue(dataFilePath, sccGroup);
    	commodity = PropertyHandler.getPropValue(dataFilePath, commodity);
    	flightCarrierCode = PropertyHandler.getPropValue(dataFilePath, flightCarrierCode);
    	flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
    	isUnknowShipper = PropertyHandler.getPropValue(dataFilePath, isUnknowShipper);
    	shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
    	minWeight = PropertyHandler.getPropValue(dataFilePath, minWeight);
    	minWeightUnit = PropertyHandler.getPropValue(dataFilePath, minWeightUnit);
    	minVolume = PropertyHandler.getPropValue(dataFilePath, minVolume);
    	minVolumeUnit = PropertyHandler.getPropValue(dataFilePath, minVolumeUnit);
    	aircraftType = PropertyHandler.getPropValue(dataFilePath, aircraftType);
    	product = PropertyHandler.getPropValue(dataFilePath, product);
    	queueReasonCode = PropertyHandler.getPropValue(dataFilePath, queueReasonCode);
    	templateID = PropertyHandler.getPropValue(dataFilePath, templateID);
    	airportGroup = PropertyHandler.getPropValue(dataFilePath, airportGroup);
    	commodityGroup = PropertyHandler.getPropValue(dataFilePath, commodityGroup);
    	
    	String dialogueText;
    	listChecksheet(transaction, originLevel, origin, viaPointLevel, viaPoint, destinationLevel, destination, scc, commodityGroup, "Active");
    	if(getTableRowCount(tbl_configDtls)>0){
    		return this;
    	}
    	click(btn_clear);
    	minWait();
    	listChecksheet(transaction, originLevel, origin, viaPointLevel, viaPoint, destinationLevel, destination, scc, commodityGroup, "All");
    	if(getTableRowCount(tbl_configDtls)>0){
    		check(chkbox_selectTableItem);
    		click(btn_activate);
    		minWait();
    	}else{
    		click(btn_create);
        	driver.switchTo().defaultContent();
        	waitForNewWindow(2);
        	switchToSecondWindow();
        	selectByText(waitForElement(dropdown_checksheetConfig_transaction), transaction);
        	enterKeys(checksheetConfig_txt_template, templateID);
        	enterKeys(checksheetConfig_txt_airport, airport);
        	enterKeys(checksheetConfig_txt_airportGroup, airportGroup);
        	enterKeys(checksheetConfig_txt_commodity, commodity);
        	enterKeys(checksheetConfig_txt_commodityGroup, commodityGroup);
        	enterKeys(checksheetConfig_txt_scc, scc);
        	enterKeys(checksheetConfig_txt_sccGroup, sccGroup);
        	if(originLevel !=null && originLevel.trim().length()>0){
        		selectByText(checksheetConfig_dropdown_awbOrigin, originLevel);
        		enterKeys(checksheetConfig_txt_awbOrigin, origin);
        	}
        	if(destinationLevel !=null && destinationLevel.trim().length()>0){
        		selectByText(checksheetConfig_dropdown_awbDestination, destinationLevel);
        		enterKeys(checksheetConfig_txt_awbDestination, destination);
        	}
        	if(viaPointLevel !=null && viaPointLevel.trim().length()>0){
        		selectByText(checksheetConfig_dropdown_viaPoint, viaPointLevel);
        		enterKeys(checksheetConfig_txt_viaPoint, viaPoint);
        	}
        	enterKeys(checksheetConfig_txt_bookedFlightCarrierCode, flightCarrierCode);
        	enterKeys(checksheetConfig_txt_bookedFlightNo, flightNo);
        	if(isUnknowShipper != null && (isUnknowShipper.equalsIgnoreCase("yes") || isUnknowShipper.equalsIgnoreCase("true")))
        		check(checksheetConfig_chkbox_unknownShipper);
        	enterKeys(checksheetConfig_txt_shipper, shipper);
        	if(minWeight !=null && minWeight.trim().length()>0){
        		enterKeys(checksheetConfig_txt_minWeight, minWeight);
        		enterKeys(checksheetConfig_dropdown_minWeight, minWeightUnit);
        	}
        	if(minVolume !=null && minVolume.trim().length()>0){
        		enterKeys(checksheetConfig_txt_minVolume, minVolume);
        		enterKeys(checksheetConfig_dropdown_minVolume, minVolumeUnit);
        	}
        	enterKeys(checksheetConfig_txt_aircraftType, aircraftType);
        	enterKeys(checksheetConfig_txt_product, product);
        	enterKeys(checksheetConfig_txt_queueReasonCode, queueReasonCode);
        	click(checksheetConfig_btn_save);
        	dialogueText = waitForElement(dialogueMsg_success).getText();
        	Assert.assertTrue(dialogueText.equals("Details saved successfully"));
        	click(btnDialog_Ok);
        	click(waitForElement(checksheetConfig_btn_close));
        	switchToFirstWindow();
        	waitForFrameAndSwitch(FRAME);
    	}    	
    	return this;
    }
    
    /**
	 * Created by a-7605 on 03/01/2017
	 */
    
    public SHR094 inactivateChecksheetConfig(String transaction,String originLevel,String origin,String viaPointLevel, String viaPoint,
    		String destinationLevel, String destination,String scc, String commodity){
    	
    	transaction = PropertyHandler.getPropValue(dataFilePath, transaction);
    	originLevel = PropertyHandler.getPropValue(dataFilePath, originLevel);
    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
    	viaPointLevel = PropertyHandler.getPropValue(dataFilePath, viaPointLevel);
    	viaPoint = PropertyHandler.getPropValue(dataFilePath, viaPoint);
    	destinationLevel = PropertyHandler.getPropValue(dataFilePath, destinationLevel);
    	destination = PropertyHandler.getPropValue(dataFilePath, destination);
    	scc = PropertyHandler.getPropValue(dataFilePath, scc);
    	commodity = PropertyHandler.getPropValue(dataFilePath, commodity);
    	
 	
    	selectByText(waitForElement(dropdown_transaction), transaction);
    	if(originLevel != null && originLevel.trim().length()>0){
    		selectByText(dropdown_awbOrigin, originLevel);
    		enterKeys(txt_awbOrigin, origin);
    	}
    	if(viaPointLevel != null && viaPointLevel.trim().length()>0){
    		selectByText(dropdown_viaPoint, viaPointLevel);
    		enterKeys(txt_viaPoint, viaPoint);
    	}
    	if(destinationLevel != null && destinationLevel.trim().length()>0){
    		selectByText(dropdown_awbDestination, destinationLevel);
    		enterKeys(txt_awbDestination, destination);
    	}
    	enterKeys(txt_scc, scc);
    	enterKeys(txt_commodity, commodity);
    	selectByText(dropdown_status, "Active");
    	click(btn_list);
    	check(waitForElement(chkbox_selectAllTableItems));
    	click(btn_inactivate);
    	return this;
    }
    
    /**
	 * Created by a-7605 on 03/01/2017
	 */
    
    public SHR094 inactivateSpecificChecksheetConfig(String transaction,String originLevel,String origin,String viaPointLevel, String viaPoint,
    		String destinationLevel, String destination,String scc, String commodity, String templateId){
    	
    	transaction = PropertyHandler.getPropValue(dataFilePath, transaction);
    	originLevel = PropertyHandler.getPropValue(dataFilePath, originLevel);
    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
    	viaPointLevel = PropertyHandler.getPropValue(dataFilePath, viaPointLevel);
    	viaPoint = PropertyHandler.getPropValue(dataFilePath, viaPoint);
    	destinationLevel = PropertyHandler.getPropValue(dataFilePath, destinationLevel);
    	destination = PropertyHandler.getPropValue(dataFilePath, destination);
    	scc = PropertyHandler.getPropValue(dataFilePath, scc);
    	commodity = PropertyHandler.getPropValue(dataFilePath, commodity);
    	
 	
    	selectByText(waitForElement(dropdown_transaction), transaction);
    	if(originLevel != null && originLevel.trim().length()>0){
    		selectByText(dropdown_awbOrigin, originLevel);
    		enterKeys(txt_awbOrigin, origin);
    	}
    	if(viaPointLevel != null && viaPointLevel.trim().length()>0){
    		selectByText(dropdown_viaPoint, viaPointLevel);
    		enterKeys(txt_viaPoint, viaPoint);
    	}
    	if(destinationLevel != null && destinationLevel.trim().length()>0){
    		selectByText(dropdown_awbDestination, destinationLevel);
    		enterKeys(txt_awbDestination, destination);
    	}
    	enterKeys(txt_scc, scc);
    	enterKeys(txt_commodity, commodity);
    	selectByText(dropdown_status, "Active");
    	click(btn_list);
    	//check(waitForElement(chkbox_selectAllTableItems));
    	tblSelectRowByColValue(tbl_configDtls, 1, 3, templateId);
    	click(btn_inactivate);
    	return this;
    }
    
    
    public SHR094 activateChecksheetConfig(String transaction,String originLevel,String origin,String viaPointLevel, String viaPoint,
    		String destinationLevel, String destination,String scc, String commodity){
    	
    	transaction = PropertyHandler.getPropValue(dataFilePath, transaction);
    	originLevel = PropertyHandler.getPropValue(dataFilePath, originLevel);
    	origin = PropertyHandler.getPropValue(dataFilePath, origin);
    	viaPointLevel = PropertyHandler.getPropValue(dataFilePath, viaPointLevel);
    	viaPoint = PropertyHandler.getPropValue(dataFilePath, viaPoint);
    	destinationLevel = PropertyHandler.getPropValue(dataFilePath, destinationLevel);
    	destination = PropertyHandler.getPropValue(dataFilePath, destination);
    	scc = PropertyHandler.getPropValue(dataFilePath, scc);
    	commodity = PropertyHandler.getPropValue(dataFilePath, commodity);
    	
    	selectByText(waitForElement(dropdown_transaction), transaction);
    	if(originLevel != null && originLevel.trim().length()>0){
    		selectByText(dropdown_awbOrigin, originLevel);
    		enterKeys(txt_awbOrigin, origin);
    	}
    	if(viaPointLevel != null && viaPointLevel.trim().length()>0){
    		selectByText(dropdown_viaPoint, viaPointLevel);
    		enterKeys(txt_viaPoint, viaPoint);
    	}
    	if(destinationLevel != null && destinationLevel.trim().length()>0){
    		selectByText(dropdown_awbDestination, destinationLevel);
    		enterKeys(txt_awbDestination, destination);
    	} 
    	enterKeys(txt_scc, scc);
    	enterKeys(txt_commodity, commodity);
    	selectByText(dropdown_status, "Inactive");
    	click(btn_list);
    	check(waitForElement(chkbox_selectAllTableItems));
    	click(btn_activate);
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
