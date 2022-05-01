package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


/**
 * Created by a-6545 on 21/12/2017.
 */

public class OPR025 extends BasePage{

	public String dataFilePath;
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");

	public static String FRAME = "iCargoContentFrameOPR025";

	By

	btn_list,
	txt_awbNo,
	Btn_Savebutton,
	btn_save,
	btn_close,
	btn_genericYes,
	Txt_Status,
	yesBtn,
	txt_PcsWgtDetails,
	tbl_enquiryDtls,
	noBtn,
	dropdown_awbEnquiryPanel,
	table_deliveryDetails,
	txt_awbPrefix,
	txt_hawb;

	WebDriver driver;    
	String testDataFile;
	String browser;

	public OPR025(WebDriver driver, String testDataFile) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.testDataFile = testDataFile;
		PageFactory.initElements(this.driver,this);
		dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
		initPageElements();

	}

	private void initPageElements() {
		// TODO Auto-generated method stub
		btn_list		= MiscUtility.getWebElement(objFilepath,"OPR025_Btn_List");
		txt_awbNo 		= MiscUtility.getWebElement(objFilepath,"OPR025_txt_AWBNo");
		btn_close		= MiscUtility.getWebElement(objFilepath,"OPR025_Btn_Close");	    	
		//yesBtn			= MiscUtility.getWebElement(objFilepath,"CAP012_btn_yes");
		txt_PcsWgtDetails= MiscUtility.getWebElement(objFilepath,"OPR025_txt_PcsWgtDetails");	
		tbl_enquiryDtls	= MiscUtility.getWebElement(objFilepath,"OPR025_tbl_pcsWtDetails");

		yesBtn			= MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
		btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		
		dropdown_awbEnquiryPanel = MiscUtility.getWebElement(objFilepath,"OPR025_dropdown_awbEnquiryPanel");
		table_deliveryDetails = MiscUtility.getWebElement(objFilepath,"OPR025_table_deliveryDetails");
		txt_awbPrefix = MiscUtility.getWebElement(objFilepath,"OPR025_txt_awbPrefix");
		txt_hawb = MiscUtility.getWebElement(objFilepath,"OPR025_txt_hawb");
	}

	public OPR025 AwbEnquiry(String awbNo, String pcs, String wt, String colNum){

		awbNo	= PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs	= PropertyHandler.getPropValue(dataFilePath, pcs);
		wt	= PropertyHandler.getPropValue(dataFilePath, wt);
		colNum	= PropertyHandler.getPropValue(dataFilePath, colNum);

		enterKeys((txt_awbNo), awbNo);

		click(btn_list);
		minWait();

		//Assert.assertEquals(waitForElementVisible(txt_PcsWgtDetails).getText().contains("Accepted Pcs/Wgt : 100 /10"), "Accepted Pcs/Wgt : 100 /10");
		Assert.assertTrue(getTableColumnValues(tbl_enquiryDtls, Integer.parseInt(colNum)).contains(pcs+"/"+wt), "ERROR : Pcs/Wt mismatch.");
		return this;
	}

	public OPR025 HAwbEnquiry(String key_awbNo){

		String data_awbNo 	= PropertyHandler.getPropValue(dataFilePath, key_awbNo);

		enterKeys((txt_awbNo), data_awbNo);
		click(btn_list);
		driver.switchTo().defaultContent();
		minWait();
		//  Assert.assertEquals(waitForElementVisible(txt_PcsWgtDetails).getText().contains("Accepted Pcs/Wgt : 0 /0"), "Accepted Pcs/Wgt : 0 /0");
		Assert.assertTrue(waitForElementVisible(txt_PcsWgtDetails).getText().contains("Accepted Pcs/Wgt : 0 /0"));


		return this;
	}

	public HomePage close(){

		click(btn_close);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {

			click(btn_genericYes);
		}
		return new HomePage(driver,testDataFile);
	}
	
	private void listWithHAWB(String awbPrefix,String awbNo,String house){
		enterKeys(txt_awbPrefix, awbPrefix);
		enterKeys(txt_awbNo, awbNo);
		enterKeys(txt_hawb, house);
		click(btn_list);
		minWait();
	}
	
	private void listWithAWB(String awbPrefix,String awbNo){
		enterKeys(txt_awbPrefix, awbPrefix);
		enterKeys(txt_awbNo, awbNo);
		click(btn_list);
		minWait();
	}
	/**
	 * Created by A-7605 on 16-5-18
	 * This method check delivery details of an HAWB. If the DN number key in datasheet stores multiple dn numbers seperated by comma, then dnIndex should specifiy the index of the dn to be used (index starting from 0). If the DN number key in the datasheet store single DN then dnIndex should be 0
	 * @param awbPrefix
	 * @param awbNo
	 * @param house
	 * @param dnNo
	 * @param dnIndex
	 * @param deliveredPcs
	 * @param deliveredWgt
	 * @return
	 */
	public  OPR025 checkDeliveryDetails_HAWB(String awbPrefix,String awbNo,String house,String dnNo,int dnIndex,String deliveredPcs,String deliveredWgt){
		awbPrefix 	= PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo 	= PropertyHandler.getPropValue(dataFilePath, awbNo);
		house 	= PropertyHandler.getPropValue(dataFilePath, house);
		dnNo 	= PropertyHandler.getPropValue(dataFilePath, dnNo);
		deliveredPcs 	= PropertyHandler.getPropValue(dataFilePath, deliveredPcs);
		deliveredWgt 	= PropertyHandler.getPropValue(dataFilePath, deliveredWgt);
		if(dnIndex != 0)
			dnNo = dnNo.split(",")[dnIndex - 1];
		
		listWithHAWB(awbPrefix, awbNo, house);
		selectByText(dropdown_awbEnquiryPanel, "Delivery Details");
		enterKeys(dropdown_awbEnquiryPanel, Keys.TAB);
		minWait();
		Assert.assertEquals(tblGetTextByColValue(table_deliveryDetails, 4, 1, dnNo), deliveredPcs+"/ "+deliveredWgt);
		return this;
	}
	
	/**
	 * Created by A-7605 on 16-5-18
	 * This method check delivery details of an HAWB. If the DN number key in datasheet stores multiple dn numbers seperated by comma, then dnIndex should specifiy the index of the dn to be used (index starting from 0). If the DN number key in the datasheet store single DN then dnIndex should be 0
	 * @param awbPrefix
	 * @param awbNo
	 * @param dnNo
	 * @param dnIndex
	 * @param deliveredPcs
	 * @param deliveredWgt
	 * @return
	 */
	public  OPR025 checkDeliveryDetails_AWB(String awbPrefix,String awbNo,String dnNo,int dnIndex,String deliveredPcs,String deliveredWgt){
		awbPrefix 	= PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo 	= PropertyHandler.getPropValue(dataFilePath, awbNo);
		dnNo 	= PropertyHandler.getPropValue(dataFilePath, dnNo);
		deliveredPcs 	= PropertyHandler.getPropValue(dataFilePath, deliveredPcs);
		deliveredWgt 	= PropertyHandler.getPropValue(dataFilePath, deliveredWgt);
		if(dnIndex != 0)
			dnNo = dnNo.split(",")[dnIndex - 1];
		
		listWithAWB(awbPrefix, awbNo);
		selectByText(dropdown_awbEnquiryPanel, "Delivery Details");
		enterKeys(dropdown_awbEnquiryPanel, Keys.TAB);
		minWait();
		Assert.assertEquals(tblGetTextByColValue(table_deliveryDetails, 4, 1, dnNo), deliveredPcs+"/ "+deliveredWgt);
		return this;
	}
	
}

