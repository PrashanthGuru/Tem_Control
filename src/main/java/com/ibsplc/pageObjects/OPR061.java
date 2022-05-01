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
 * Created by a-6545 on 27/12/2017.
 *  */
public class OPR061  extends BasePage{
	public String dataFilePath;
	public  String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
	public  String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");

	public static String FRAME = "iCargoContentFrameOPR061";

	By
	btn_list,
	txt_FlightPrefix,
	txt_FlightNo,
	txt_FlightDate,
	txt_ReceivedPieces,
	txt_ReceivedPiecesWeight,
	txt_Remarks,
	Btn_List,
	Lnk_DisplayDetails2,
	btn_save,
	btn_close,

	btn_closeFlight,
	Btn_CloseFlight_Okbutton,
	tbl_arrivalDtls,
	Lnk_DisplayDetails,
	Lnk_DisplayAll,
	yesBtn,
	txt_rcvdPcs1,
	txt_rcvdW3,
	txt_rcvdWt1,
	txt_rcvdPcs2,
	txt_shipmentDescription,
	Lnk_DisplayDetails3,
	Lnk_DisplayDetails4,
	txt_rcvdWt2,
	txt_rcvdPcs3,
	txt_rcvdWt3,
	txt_rcvdPcs4,
	txt_rcvdWt4,
	lnk_Modify,
	btn_AddHawb,
	chk_uldid,
	lnk_add,
	txt_uld,
	chk_custChk,
	chk_secChk,
	btn_list_uld,
	lnk_create,
	txt_pre,
	txt_rcvdPc3,

	txt_awb,
	btn_list_awb,
	txt_RcvdPcs,
	txt_RcvdWt,
	chk_verify_thruUnit,
	btn_HouseMismatch_ok,
	txt_origin,
	txt_Dest,
	btn_OK_ULD,
	txt_HAWB,
	txt_HAWB_pieces,
	txt_HAWB_weight,
	txt_HAWB_stdPieces,
	txt_HAWB_stdWeight,
	txt_HAWB_desc,
	chk_thruUnit,
	msg_footer,
	Generic_info_msg,
	btn_autoArrive,
	chk_customsClearanceRequired,
	chk_securityClearanceRequired,
	btn_reassign,
	txt_reassign_FltNo,
	txt_reassign_Fltdate,
	txt_reassign_uld,
	txt_reassign_POU,
	btn_reassign_Save,
	Btn_CloseFlight_yes,
	chk_selectedAWBs,
	chk_FullULDTransfer,
	btn_reassignclose,
	chk_uldid1,
	Generic_footer_error,
	tbl_discrepancyTable,
	Generic_btn_ok,
	txt_ArriveDone,
	btn_bDelete,
	noBtn,
	btn_clear;

	WebDriver driver;    
	String testDataFile;
	String browser;
	private String key_awbNo;
	private String key_AWBNo_Prefix;

	public OPR061(WebDriver driver, String testDataFile) {
		super(driver);
		this.driver = driver;
		this.testDataFile = testDataFile;
		PageFactory.initElements(this.driver,this);
		dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory")+testDataFile;
		initPageElements();
	}

	private void initPageElements() {
		// TODO Auto-generated method stub

		txt_FlightNo 	    = MiscUtility.getWebElement(objFilepath,"OPR061_txt_FlightNo");
		Btn_List     	    = MiscUtility.getWebElement(objFilepath,"OPR061_Btn_List");
		txt_FlightDate 	    = MiscUtility.getWebElement(objFilepath,"OPR061_txt_FlightDate");
		btn_save 	        = MiscUtility.getWebElement(objFilepath,"OPR061_Btn_Save");
		btn_close 	        = MiscUtility.getWebElement(objFilepath,"OPR061_Btn_btnClose");
		btn_clear			= MiscUtility.getWebElement(objFilepath,"OPR061_Btn_Clear");			
		btn_closeFlight 	= MiscUtility.getWebElement(objFilepath,"OPR061_Btn_CloseFlight");
		Lnk_DisplayDetails  = MiscUtility.getWebElement(objFilepath,"OPR061_Lnk_DisplayDetails");
		tbl_arrivalDtls		= MiscUtility.getWebElement(objFilepath,"OPR061_tbl_arrivalDtls");	
		Btn_CloseFlight_Okbutton  = MiscUtility.getWebElement(objFilepath,"OPR061_Btn_CloseFlight_Okbutton");
		btn_list  = MiscUtility.getWebElement(objFilepath,"OPR061_Btn_List");
		txt_FlightPrefix = MiscUtility.getWebElement(objFilepath,"OPR061_txt_FlightPrefix");
		txt_ReceivedPiecesWeight = MiscUtility.getWebElement(objFilepath,"OPR061_txt_ReceivedPieces");
		msg_footer = MiscUtility.getWebElement(genObjPath,"Generic_foot_layer");
		yesBtn = MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
		Generic_btn_ok= MiscUtility.getWebElement(genObjPath,"Generic_btn_ok");
		Generic_footer_error= MiscUtility.getWebElement(genObjPath,"Generic_footer_error");
		Generic_info_msg= MiscUtility.getWebElement(genObjPath,"Generic_info_msg");
		txt_rcvdPcs1 = MiscUtility.getWebElement(objFilepath,"OPR061_txt_ReceivedPiece1");
		txt_rcvdWt1 = MiscUtility.getWebElement(objFilepath,"OPR061_txt_ReceivedWeight1");
		txt_rcvdPcs2 = MiscUtility.getWebElement(objFilepath,"OPR061_txt_ReceivedPiece2");
		txt_rcvdWt2 = MiscUtility.getWebElement(objFilepath,"OPR061_txt_ReceivedWeight2");
		txt_rcvdPcs2 = MiscUtility.getWebElement(objFilepath,"OPR061_txt_ReceivedPiece2");
		txt_rcvdWt2 = MiscUtility.getWebElement(objFilepath,"OPR061_txt_ReceivedWeight2");
		txt_rcvdPcs4 = MiscUtility.getWebElement(objFilepath,"OPR061_txt_ReceivedPc4");
		txt_rcvdWt4 = MiscUtility.getWebElement(objFilepath,"OPR061_txt_ReceivedWt4");
		txt_rcvdPc3 = MiscUtility.getWebElement(objFilepath,"OPR061_txt_ReceivedPc3");
		txt_rcvdW3 = MiscUtility.getWebElement(objFilepath,"OPR061_txt_ReceivedWt3");
		lnk_add= MiscUtility.getWebElement(objFilepath,"OPR061_lnk_add");
		txt_uld= MiscUtility.getWebElement(objFilepath,"OPR061_txt_uld");
		btn_list_uld= MiscUtility.getWebElement(objFilepath,"OPR061_btn_list_uld");
		lnk_create= MiscUtility.getWebElement(objFilepath,"OPR061_lnk_create");
		txt_pre= MiscUtility.getWebElement(objFilepath,"OPR061_txt_pre");
		txt_awb= MiscUtility.getWebElement(objFilepath,"OPR061_txt_awb");
		btn_list_awb= MiscUtility.getWebElement(objFilepath,"OPR061_btn_list_awb");
		txt_RcvdPcs= MiscUtility.getWebElement(objFilepath,"OPR061_txt_RcvdPcs");
		txt_RcvdWt= MiscUtility.getWebElement(objFilepath,"OPR061_txt_RcvdWt");
		txt_origin= MiscUtility.getWebElement(objFilepath,"OPR061_txt_origin");
		txt_Dest= MiscUtility.getWebElement(objFilepath,"OPR061_txt_Dest");
		btn_OK_ULD= MiscUtility.getWebElement(objFilepath,"OPR061_btn_OK_ULD");
		btn_AddHawb= MiscUtility.getWebElement(objFilepath,"OPR061_btn_AddHawb");
		txt_HAWB= MiscUtility.getWebElement(objFilepath,"OPR061_txt_HAWB");
		txt_HAWB_pieces= MiscUtility.getWebElement(objFilepath,"OPR061_btn_AddHawb");
		txt_HAWB_weight= MiscUtility.getWebElement(objFilepath,"OPR061_txt_HAWB_pieces");
		txt_HAWB_stdPieces= MiscUtility.getWebElement(objFilepath,"OPR061_txt_HAWB_stdPieces");
		txt_HAWB_stdWeight= MiscUtility.getWebElement(objFilepath,"OPR061_txt_HAWB_stdWeight");
		txt_HAWB_desc= MiscUtility.getWebElement(objFilepath,"OPR061_txt_HAWB_desc");
		txt_shipmentDescription= MiscUtility.getWebElement(objFilepath,"OPR061_txt_shipmentDescription");
		btn_HouseMismatch_ok= MiscUtility.getWebElement(objFilepath,"OPR061_btn_HouseMismatch_ok");
		Lnk_DisplayAll= MiscUtility.getWebElement(objFilepath,"OPR061_Lnk_DisplayAll");
		Lnk_DisplayDetails2= MiscUtility.getWebElement(objFilepath,"OPR061_Lnk_DisplayDetails2");
		Lnk_DisplayDetails3= MiscUtility.getWebElement(objFilepath,"OPR061_Lnk_DisplayDetails3");
		Lnk_DisplayDetails4= MiscUtility.getWebElement(objFilepath,"OPR061_Lnk_DisplayDetails4");
		lnk_Modify= MiscUtility.getWebElement(objFilepath,"OPR061_lnk_Modify");
		chk_thruUnit= MiscUtility.getWebElement(objFilepath,"OPR061_chk_thruUnit");
		chk_verify_thruUnit= MiscUtility.getWebElement(objFilepath,"OPR061_chk_verify_thruUnit");
		chk_uldid= MiscUtility.getWebElement(objFilepath,"OPR061_chk_uldid");
		chk_uldid1= MiscUtility.getWebElement(objFilepath,"OPR061_chk_uldid1");
		chk_custChk= MiscUtility.getWebElement(objFilepath,"OPR061_chk_custChk");
		chk_secChk= MiscUtility.getWebElement(objFilepath,"OPR061_chk_secChk");
		btn_autoArrive= MiscUtility.getWebElement(objFilepath,"OPR061_btn_autoArrive");
		chk_securityClearanceRequired= MiscUtility.getWebElement(objFilepath,"OPR061_chk_securityClearanceRequired");
		chk_customsClearanceRequired= MiscUtility.getWebElement(objFilepath,"OPR061_chk_customsClearanceRequired");
		btn_reassign= MiscUtility.getWebElement(objFilepath,"OPR061_btn_reassign");
		txt_reassign_FltNo= MiscUtility.getWebElement(objFilepath,"OPR061_txt_reassign_FltNo");
		txt_reassign_Fltdate= MiscUtility.getWebElement(objFilepath,"OPR061_txt_reassign_Fltdate");
		txt_reassign_uld= MiscUtility.getWebElement(objFilepath,"OPR061_txt_reassign_uld");
		txt_reassign_POU= MiscUtility.getWebElement(objFilepath,"OPR061_txt_reassign_POU");
		btn_reassign_Save= MiscUtility.getWebElement(objFilepath,"OPR061_btn_reassign_Save");
		chk_selectedAWBs= MiscUtility.getWebElement(objFilepath,"OPR061_chk_selectedAWBs");
		chk_FullULDTransfer= MiscUtility.getWebElement(objFilepath,"OPR061_chk_FullULDTransfer");
		btn_reassignclose= MiscUtility.getWebElement(objFilepath,"OPR061_btn_reassignclose");
		txt_ArriveDone= MiscUtility.getWebElement(objFilepath,"OPR061_txt_ArriveDone");
		btn_bDelete= MiscUtility.getWebElement(objFilepath,"OPR061_btn_bDelete");
		tbl_discrepancyTable= MiscUtility.getWebElement(objFilepath,"OPR061_tbl_discrepancyTable");
		Btn_CloseFlight_yes= MiscUtility.getWebElement(objFilepath,"OPR061_Btn_CloseFlight_yes");
	}
	public OPR061 Savedetails(String key_FlightNo, String key_sDate, String key_awbNoPrefix, String key_awbNo
			,String key_No_Pieces ,String key_Weight , String key_Origin,String key_Destination){


		String data_FlightNo            			= PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
		String data_sDate 	                        = PropertyHandler.getPropValue(dataFilePath, key_sDate);
		String data_awbNoPrefix 	                 = PropertyHandler.getPropValue(dataFilePath, key_awbNoPrefix);
		String data_awbNo	                        = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
		String data_No_Pieces	                    = PropertyHandler.getPropValue(dataFilePath, key_No_Pieces);
		String data_Weight	                        = PropertyHandler.getPropValue(dataFilePath, key_Weight);
		String data_Origin	                        = PropertyHandler.getPropValue(dataFilePath, key_Origin);
		String data_Destination                      = PropertyHandler.getPropValue(dataFilePath, key_Destination);

		enterKeys((txt_FlightNo),data_FlightNo );
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();
		//driver.switchTo().defaultContent();
		//tblSelectRowByColValue(tbl_arrivalDtls, 2, 3, "BULK");
		click(Lnk_DisplayDetails);

		txt_ReceivedPieces = By.xpath("//td[contains(text(),'"+data_awbNo+"')]/following-sibling::td[6]/input");
		txt_ReceivedPiecesWeight = By.xpath("//td[contains(text(),'"+data_awbNo+"')]/following-sibling::td[7]/input");
		txt_Remarks = By.xpath("//td[contains(text(),'"+data_awbNo+"')]/following-sibling::td[18]/input");

		enterKeys(txt_ReceivedPieces, data_No_Pieces);
		enterKeys(txt_ReceivedPiecesWeight, data_Weight);
		enterKeys(txt_ReceivedPiecesWeight, data_Weight);
		enterKeys(txt_Remarks, "Remarks");
		click(btn_save);
		driver.switchTo().defaultContent();

		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		Assert.assertTrue(waitForElement(msg_footer).getText().contains("Data Saved Successfully."), "ERROR : Changes not saved");
		waitForFrameAndSwitch(FRAME);
		return this;

	}
	public OPR061 CloseFlight(String key_FlightNo, String key_sDate, String key_awbNoPrefix, String key_awbNo
			,String key_No_Pieces ,String key_Weight , String key_Origin,String key_Destination){


		String data_FlightNo            			= PropertyHandler.getPropValue(dataFilePath, key_FlightNo);
		String data_sDate 	                        = PropertyHandler.getPropValue(dataFilePath, key_sDate);
		String data_awbNoPrefix 	                 = PropertyHandler.getPropValue(dataFilePath, key_awbNoPrefix);
		String data_awbNo	                        = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
		String data_No_Pieces	                    = PropertyHandler.getPropValue(dataFilePath, key_No_Pieces);
		String data_Weight	                        = PropertyHandler.getPropValue(dataFilePath, key_Weight);
		String data_Origin	                        = PropertyHandler.getPropValue(dataFilePath, key_Origin);
		String data_Destination                      = PropertyHandler.getPropValue(dataFilePath, key_Destination);

		enterKeys((txt_FlightNo),data_FlightNo );
		enterKeys(txt_FlightDate, data_sDate);
		click(btn_list);
		minWait();	         
		click(btn_closeFlight);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		if (verifyElementPresent(Btn_CloseFlight_Okbutton))
			click(Btn_CloseFlight_Okbutton);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		return this;

	}

	/**
	 * Created by a-7605 on 03/01/2017
	 */

	public OPR061 acceptPcsAndWeightForThreeShipments(String carrierCode, String flightNo, String flightDate, String pieces, String weight){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		enterKeys(txt_rcvdPcs1, pieces);
		enterKeys(txt_rcvdPcs1, Keys.TAB);
		enterKeys(txt_rcvdWt1, weight);
		enterKeys(txt_rcvdWt1, Keys.TAB);
		enterKeys(txt_rcvdPcs2, pieces);
		enterKeys(txt_rcvdPcs2, Keys.TAB);
		enterKeys(txt_rcvdWt2, weight);
		enterKeys(txt_rcvdWt2, Keys.TAB);
		enterKeys(txt_rcvdPcs3, pieces);
		enterKeys(txt_rcvdPcs3, Keys.TAB);
		enterKeys(txt_rcvdWt3, weight);
		enterKeys(txt_rcvdWt3, Keys.TAB);
		click(btn_save);
		minWait();
		return this;
	}
	public HomePage close(){
		minWait();
		click(btn_close);

		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}

		return new HomePage(driver,testDataFile);
	}


	/**
	 * Created by a-6545 on 02/02/2018
	 */
	public OPR061 acceptPcsAndWeight(String carrierCode, String flightNo, String flightDate, String pieces, String weight){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		enterKeys(txt_rcvdPcs1, pieces);
		enterKeys(txt_rcvdPcs1, Keys.TAB);

		enterKeys(txt_rcvdWt1, weight);

		enterKeys(txt_rcvdWt1, Keys.TAB);


		click(btn_save);
		minWait();
		return this;
	}

	/**
	 * Created by a-6545 on 14/02/2018
	 */
	public OPR061 OneBulk_3Ulds(String carrierCode, String flightNo, String flightDate, String pieces, String weight){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		enterKeys(txt_rcvdPcs1, pieces);
		enterKeys(txt_rcvdPcs1, Keys.TAB);
		enterKeys(txt_rcvdWt1, weight);
		enterKeys(txt_rcvdWt1, Keys.TAB);
		minWait();
		click(waitForElement(Lnk_DisplayDetails2));
		minWait();
		enterKeys(txt_rcvdPcs2, pieces);
		enterKeys(txt_rcvdPcs2, Keys.TAB);
		enterKeys(txt_rcvdWt2, weight);
		enterKeys(txt_rcvdWt2, Keys.TAB);
		click(waitForElement(Lnk_DisplayDetails3));
		minWait();
		enterKeys(txt_rcvdPc3, pieces);
		enterKeys(txt_rcvdPc3, Keys.TAB);
		enterKeys(txt_rcvdW3, weight);
		enterKeys(txt_rcvdW3, Keys.TAB);
		minWait();
		click(waitForElement(Lnk_DisplayDetails4));
		minWait();
		enterKeys(txt_rcvdPcs4, pieces);
		enterKeys(txt_rcvdPcs4, Keys.TAB);
		enterKeys(txt_rcvdWt4, weight);
		enterKeys(txt_rcvdWt4, Keys.TAB);
		minWait();
		click(btn_save);
		minWait();
		return this;
	}

	/**
	 * Created by a-6545 on 02/02/2018
	 */
	public OPR061 acceptPcsAndWeight_ULD(String carrierCode, String flightNo, String flightDate, String pieces, String weight, String... awbNo ){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		String awbNum = PropertyHandler.getPropValue(dataFilePath, awbNo[0]);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayAll));
		minWait();

		By txt_pcs = By.xpath("//td[contains(text(),'"+awbNum+"')]/following-sibling::td[6]/input");
		By txt_wt = By.xpath("//td[contains(text(),'"+awbNum+"')]/following-sibling::td[7]/input");
		enterKeys(txt_pcs, pieces);
		enterKeys(txt_pcs, Keys.TAB);
		enterKeys(txt_wt, weight);
		enterKeys(txt_wt, Keys.TAB);

		click(btn_save);
		minWait();
		return this;
	}

	/**
	 * Method to accept pcs and weight of specific AWB
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param awbNo
	 * @param pieces
	 * @param weight
	 * @return
	 * @author A-7868 Krishna <23/02/2018>
	 */
	public OPR061 acceptPcsAndWeight_AWB(String carrierCode, String flightNo, String flightDate, String awbNo, String pieces, String weight){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(waitForElement(Lnk_DisplayAll));
		minWait();

		By txt_pcs = By.xpath("//td[contains(text(),'"+awbNo+"')]/following-sibling::td[6]/input");
		By txt_wt = By.xpath("//td[contains(text(),'"+awbNo+"')]/following-sibling::td[7]/input");


		enterKeys(txt_pcs, pieces);
		enterKeys(txt_pcs, Keys.TAB);
		enterKeys(txt_wt, weight);
		enterKeys(txt_wt, Keys.TAB);
		click(btn_save);
		minWait();
		return this;
	}

	/**Check the manifest pcs and wt
	 * Created by a-6545 on 02/02/2018
	 */
	public OPR061 Check_If_Manifested_Shipment_Details_Are_Displayed_Correctly_Under_Arrival_Details_Section(String carrierCode, String flightNo, String flightDate, String pieces, String weight,String origin,String awbNo){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		Assert.assertTrue(tblGetTextByColValue(tbl_arrivalDtls,11,7,awbNo).trim().equalsIgnoreCase(pieces));
		Assert.assertTrue(tblGetTextByColValue(tbl_arrivalDtls,12,15,origin).trim().equalsIgnoreCase(weight));

		return this;
	}

	/**Check the manifest pcs and wt
	 * Created by a-6545 on 02/02/2018
	 */
	public OPR061 Check_If_Rcv_Shipment_Details_Under_Arrival_Details_Section(String carrierCode, String flightNo, String flightDate, String pieces, String weight,String origin,String awbNo){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();

		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		Assert.assertTrue(waitForElement(txt_rcvdPcs1).getAttribute("value").equalsIgnoreCase(pieces));


		return this;
	}



	/**Mark thru
	 * Created by a-6545 on 05/02/2018
	 */


	public OPR061 Mark_Thru(String carrierCode, String flightNo, String flightDate, String ULDNo, boolean value,String pieces){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		ULDNo = PropertyHandler.getPropValue(dataFilePath, ULDNo);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		if (value)
		{
			check(chk_uldid);
			click(lnk_Modify);
			minWait();
			waitForNewWindow(2);
			switchToSecondWindow();
			check(chk_thruUnit);
			click(btn_OK_ULD);

			minWait();
			switchToFirstWindow();
			driver.switchTo().defaultContent();
			if(verifyElementPresent(yesBtn))
				click(yesBtn);
			waitForFrameAndSwitch(FRAME);
			click(btn_save);
			minWait();
			enterKeys((txt_FlightPrefix),carrierCode);
			enterKeys((txt_FlightNo),flightNo);
			enterKeys(txt_FlightDate, flightDate);
			click(btn_list);
			minWait();
		}
		Assert.assertEquals(waitForElementVisible(chk_verify_thruUnit).getAttribute("checked"),"true");
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		Assert.assertTrue(waitForElement(txt_rcvdPcs1).getAttribute("value").equalsIgnoreCase(pieces));
		enterKeys(txt_rcvdPcs1, "20");
		enterKeys(txt_rcvdPcs1, Keys.TAB);
		enterKeys(txt_rcvdWt1, "200");
		enterKeys(txt_rcvdWt1, Keys.TAB);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		while(verifyElementPresent(yesBtn))
		{
			click(yesBtn);
			waitForFrameAndSwitch(FRAME);
		}
		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		check(chk_uldid);
		click(btn_bDelete);
		Assert.assertTrue(waitForElementVisible(Generic_footer_error).getText().contains("Partial Delete not allowed for Thru"));
				click(btn_save);
				minWait();
				return this;
	}    

	/**Security check
	 * Created by a-6545 on 05/02/2018
	 */
	public OPR061 Security_Customs_Check (String carrierCode, String flightNo, String flightDate){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);



		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		check(chk_uldid);
		click(lnk_Modify);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(chk_custChk);
		check(chk_secChk);
		click(btn_OK_ULD);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		click(btn_save);
		minWait();
		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails2));
		Assert.assertNotNull(waitForElementVisible(chk_securityClearanceRequired).getAttribute("checked"));
		Assert.assertNotNull(waitForElementVisible(chk_customsClearanceRequired).getAttribute("checked"));

		return this;
	}

	/**Auto_Arrive 
	 * Created by a-6545 on 05/02/2018
	 */
	public OPR061 Auto_Arrive (String carrierCode, String flightNo, String flightDate,String pieces,String wt){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);


		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		check(chk_uldid);
		click(btn_autoArrive);
		minWait();
		click(btn_save);
		minWait();

		click(btn_clear);
		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayAll));
		Assert.assertTrue(waitForElement(txt_rcvdPcs1).getAttribute("value").equalsIgnoreCase(pieces));
		Assert.assertTrue(waitForElement(txt_rcvdWt1).getAttribute("value").equalsIgnoreCase(wt));
		return this;
	}
	/**Reassign
	 * Created by a-6545 on 05/02/2018
	 */
	public OPR061 Reassign (String carrierCode, String flightNo, String flightDate,String flightNo2,String dest){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);

		flightNo2 = PropertyHandler.getPropValue(dataFilePath, flightNo2);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		check(chk_uldid1);
		click(btn_reassign);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(chk_selectedAWBs);
		scrollToView(txt_reassign_FltNo);
		enterKeys((txt_reassign_FltNo),flightNo2);
		enterKeys(txt_reassign_Fltdate,flightDate);
		enterKeys(txt_reassign_uld,"BULK");
		enterKeys(txt_reassign_POU,dest);
		click(btn_reassign_Save);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(btn_save);
		minWait();
		return this;
	}
	/**Reassign_FullULD
	 * Created by a-6545 on 05/02/2018
	 * @param uldNum TODO
	 */
	public OPR061 Reassign_FullULD (String carrierCode, String flightNo, String flightDate,String flightNo2,String dest, String uldNum){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		uldNum = PropertyHandler.getPropValue(dataFilePath, uldNum);

		flightNo2 = PropertyHandler.getPropValue(dataFilePath, flightNo2);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		check(chk_uldid1);
		click(btn_reassign);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(chk_FullULDTransfer);
		scrollToView(txt_reassign_FltNo);
		enterKeys((txt_reassign_FltNo),flightNo2);
		enterKeys(txt_reassign_Fltdate,flightDate);

		enterKeys(txt_reassign_POU,dest);
		click(btn_reassign_Save);
		minWait();
		driver.switchTo().defaultContent();
		click(yesBtn);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(btn_save);
		minWait();
		return this;
	}

	/**Reassign same uld
	 * Created by a-6545 on 05/02/2018
	 */
	public OPR061 Reassign_SameULD (String carrierCode, String flightNo, String flightDate,String flightNo2,String dest,String UldNo){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		UldNo= PropertyHandler.getPropValue(dataFilePath, UldNo);
		flightNo2 = PropertyHandler.getPropValue(dataFilePath, flightNo2);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		check(chk_uldid1);
		click(btn_reassign);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(chk_selectedAWBs);
		scrollToView(txt_reassign_FltNo);
		enterKeys((txt_reassign_FltNo),flightNo2);
		enterKeys(txt_reassign_Fltdate,flightDate);
		enterKeys(txt_reassign_uld,UldNo);
		enterKeys(txt_reassign_POU,dest);
		click(btn_reassign_Save);
		driver.switchTo().defaultContent();
		if(verifyElementPresent(yesBtn))
			click(yesBtn);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(btn_save);
		minWait();
		return this;
	}
	/**Reassign_invlaidFlt
	 * Created by a-6545 on 05/02/2018
	 */
	public OPR061 Reassign_invlaidFlt (String carrierCode, String flightNo, String flightDate,String dest,String UldNo){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		UldNo= PropertyHandler.getPropValue(dataFilePath, UldNo);


		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		check(chk_uldid1);
		click(btn_reassign);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		check(chk_selectedAWBs);
		scrollToView(txt_reassign_FltNo);
		enterKeys((txt_reassign_FltNo),"2345l");
		enterKeys(txt_reassign_Fltdate,flightDate);
		enterKeys(txt_reassign_uld,UldNo);
		enterKeys(txt_reassign_POU,dest);
		click(btn_reassign_Save);
		Assert.assertTrue(waitForElement(Generic_footer_error).getText().contains("is invalid"));
		click(btn_reassignclose);

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(btn_save);
		minWait();
		return this;
	}

	/**
	 * Created by A-6545 on 05/02/2018
	 * This method will close flight having no discrepancy
	 * @param flightNo
	 * @param flightDate
	 * @return
	 */
	public OPR061 Close_Flt (String carrierCode, String flightNo, String flightDate){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);


		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		Assert.assertEquals(waitForElementVisible(txt_ArriveDone).getText(),"Arrival Done");

		click(btn_closeFlight);

		return this;
	}
	/**
	 * Created by A-6545 on 14/02/2018
	 * This method will verify the close flight details
	 * @param flightNo
	 * @param flightDate
	 * @return
	 */
	public OPR061 Verify_Close_Flt (String carrierCode, String flightNo, String flightDate){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);


		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		driver.switchTo().defaultContent();
		click(yesBtn);
		waitForFrameAndSwitch(FRAME); 
		Assert.assertEquals(waitForElementVisible(txt_ArriveDone).getText(),"Closed");
		return this;
	}
	/**
	 * Created by A-6545 on 05/02/2018
	 * This method will close flight having with discrepancy
	 * @param flightNo
	 * @param flightDate
	 * @return
	 */
	public OPR061 Close_Flt_discrepancy (String carrierCode, String flightNo, String flightDate){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);


		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(btn_closeFlight);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();
		if (verifyElementPresent(Btn_CloseFlight_Okbutton))
			Assert.assertTrue(waitForElement(tbl_discrepancyTable).getText().contains("MSCA"));
		click(Btn_CloseFlight_Okbutton);
		minWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		return this;
	}
	/**Short_capture_AWB
	 * Created by a-6545 on 02/02/2018
	 */
	public OPR061 Short_capture_AWB(String carrierCode, String flightNo, String flightDate, String pieces, String weight,String origin,String awbNo,String ULDNo,String awbPre,String awbNo3,String pcs, String wt, String dest){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo3 = PropertyHandler.getPropValue(dataFilePath, awbNo3);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);


		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		Assert.assertTrue(tblGetTextByColValue(tbl_arrivalDtls,11,7,awbNo).trim().equalsIgnoreCase(pieces));
		click(lnk_add);
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys((txt_uld),ULDNo);
		click(btn_list_uld);
		click(lnk_create);
		enterKeys((txt_pre),awbPre);
		enterKeys(txt_awb,awbNo3);  
		click(btn_list_awb);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}

		waitForNewWindow(2);
		enterKeys((txt_RcvdPcs),pcs);
		enterKeys(txt_RcvdWt,wt);  
		enterKeys(txt_origin,origin);  
		enterKeys(txt_Dest,dest);  
		enterKeys(txt_shipmentDescription,"remark"); 
		click(btn_OK_ULD);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		minWait();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
			minWait();
		}

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(btn_save);
		driver.switchTo().defaultContent();

		if(verifyElementPresent(yesBtn))
		{
			click(yesBtn);
		}

		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}
	/**Short_capture_AWB
	 * Created by a-6545 on 05/02/2018
	 */
	public OPR061 Short_capture_Existing_AWB(String carrierCode, String flightNo, String flightDate, String pieces, String weight,String awbNo,String ULDNo,String awbPre,String awbNo3,String pcs, String wt ){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);

		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo3 = PropertyHandler.getPropValue(dataFilePath, awbNo3);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);



		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		Assert.assertTrue(tblGetTextByColValue(tbl_arrivalDtls,11,7,awbNo).trim().equalsIgnoreCase(pieces));
		click(lnk_add);
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys((txt_uld),ULDNo);
		click(btn_list_uld);
		click(lnk_create);
		enterKeys((txt_pre),awbPre);
		enterKeys(txt_awb,awbNo3);  
		click(btn_list_awb);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}

		waitForNewWindow(2);
		enterKeys((txt_RcvdPcs),pcs);
		enterKeys(txt_RcvdWt,wt);  
		click(btn_OK_ULD);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		minWait();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
			minWait();
		}

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(btn_save);
		minWait();
		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		Assert.assertTrue(tblGetTextByColValue(tbl_arrivalDtls,17,7,awbNo3).trim().equalsIgnoreCase(pcs));
		return this;
	}

	/**Short_capture_AWB
	 * Created by a-6545 on 05/02/2018
	 */
	public OPR061 Short_capture_Existing_AWB(String carrierCode, String flightNo, String flightDate, String ULDNo,String awbPre,String awbNo,String pcs, String wt ){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		ULDNo = PropertyHandler.getPropValue(dataFilePath, ULDNo);


		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(lnk_add);
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys((txt_uld),ULDNo);
		click(btn_list_uld);
		click(lnk_create);
		enterKeys((txt_pre),awbPre);
		enterKeys(txt_awb,awbNo);  
		click(btn_list_awb);
		enterKeys((txt_RcvdPcs),pcs);
		enterKeys(txt_RcvdWt,wt);  
		click(btn_OK_ULD);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		minWait();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
			minWait();
		}

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(btn_save);
		minWait();
		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		Assert.assertTrue(tblGetTextByColValue(tbl_arrivalDtls,17,7,awbNo).trim().equalsIgnoreCase(pcs));
		return this;
	}

	/**
	 * 
	 * @param carrierCode
	 * @param flightNo
	 * @param flightDate
	 * @param pieces
	 * @param weight
	 * @param awbNo
	 * @param ULDNo
	 * @param AWBprefix
	 * @return
	 */
	public OPR061 Short_capture_BULK_sinleAWB(String carrierCode, String flightNo, String flightDate, String pieces, String weight,String awbNo,String AWBprefix){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);

		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		AWBprefix = PropertyHandler.getPropValue(dataFilePath, AWBprefix);


		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		Assert.assertTrue(tblGetTextByColValue(tbl_arrivalDtls,11,7,awbNo).trim().equalsIgnoreCase(pieces));
		click(lnk_add);
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys((txt_uld),"BULK");
		click(btn_list_uld);

		click(lnk_create);
		enterKeys((txt_pre),AWBprefix);
		enterKeys(txt_awb,awbNo);  
		click(btn_list_awb);


		waitForNewWindow(2);
		enterKeys((txt_RcvdPcs),pieces);
		enterKeys(txt_RcvdWt,weight);  

		enterKeys(txt_shipmentDescription,"remark"); 
		click(btn_OK_ULD);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		minWait();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
			minWait();
		}

		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(btn_save);
		driver.switchTo().defaultContent();

		if(verifyElementPresent(yesBtn))
		{
			click(yesBtn);
		}

		waitForFrameAndSwitch(FRAME);
		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_HouseMismatch_ok);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/**Short_capture_AWB with capture House details
	 * Created by a-6545 on 02/02/2018
	 */
	public OPR061 Short_capture_HAWB(String carrierCode, String flightNo, String flightDate, String pieces, String weight,String origin,String awbNo,String ULDNo,String awbPre,String awbNo3,String pcs, String wt, String dest,String HAWB1){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo3 = PropertyHandler.getPropValue(dataFilePath, awbNo3);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);


		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		Assert.assertTrue(tblGetTextByColValue(tbl_arrivalDtls,11,7,awbNo).trim().equalsIgnoreCase(pieces));
		click(lnk_add);
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys((txt_uld),ULDNo);
		click(btn_list_uld);
		click(lnk_create);
		enterKeys((txt_pre),awbPre);
		enterKeys(txt_awb,awbNo3);  
		click(btn_list_awb);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}

		waitForNewWindow(2);
		enterKeys((txt_RcvdPcs),pcs);
		enterKeys(txt_RcvdWt,wt);  
		enterKeys(txt_origin,origin);  
		enterKeys(txt_Dest,dest);  

		enterKeys(txt_shipmentDescription,"remark");  

		click(btn_AddHawb);
		driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("AWB is not a consol.Do you want to mark as consol")); 
		click(yesBtn);
		waitForNewWindow(2);
		enterKeys((txt_HAWB),HAWB1 + Keys.TAB+pcs+Keys.TAB+ wt);
		enterKeys((txt_HAWB_stdPieces),pcs); 
		enterKeys((txt_HAWB_stdWeight),wt);  
		enterKeys((txt_HAWB_desc),HAWB1); 
		click(btn_OK_ULD);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		minWait();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
			minWait();
		}
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(btn_save);
		driver.switchTo().defaultContent();
		Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("New shipments found.Do you want to mark as truckarrival")); 

		if(verifyElementPresent(yesBtn))
		{
			click(yesBtn);
		}

		waitForFrameAndSwitch(FRAME);
		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_HouseMismatch_ok);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}
	/**Check the manifest pcs and wt
	 * Created by a-6545 on 02/02/2018
	 */
	public OPR061 Check_If_Manifested_Shipment_Details_Arrival_Details_Section(String carrierCode, String flightNo, String flightDate, String pieces, String weight,String origin,String awbNo3){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		awbNo3 = PropertyHandler.getPropValue(dataFilePath, awbNo3);

		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(Lnk_DisplayAll);
		minWait();
		Assert.assertTrue(tblGetTextByColValue(tbl_arrivalDtls,11,7,awbNo3).trim().equalsIgnoreCase(pieces));


		return this;
	}
	/**Short_capture_AWB
	 * Created by a-6545 on 02/02/2018
	 */
	public OPR061 Short_capture_warning_check(String carrierCode, String flightNo, String flightDate, String pieces, String weight,String origin,String awbNo,String ULDNo,String awbPre,String awbNo3,String pcs, String wt, String dest){

		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo3 = PropertyHandler.getPropValue(dataFilePath, awbNo3);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);


		enterKeys((txt_FlightPrefix),carrierCode);
		enterKeys((txt_FlightNo),flightNo);
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();
		click(waitForElement(Lnk_DisplayDetails));
		minWait();
		Assert.assertTrue(tblGetTextByColValue(tbl_arrivalDtls,11,7,awbNo).trim().equalsIgnoreCase(pieces));
		click(lnk_add);
		waitForNewWindow(2);
		switchToSecondWindow();
		enterKeys((txt_uld),ULDNo);
		click(btn_list_uld);
		click(lnk_create);
		enterKeys((txt_pre),awbPre);
		enterKeys(txt_awb,awbNo3);  
		click(btn_list_awb);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}

		waitForNewWindow(2);
		enterKeys((txt_RcvdPcs),pcs);
		enterKeys(txt_RcvdWt,wt);  
		enterKeys(txt_origin,origin);  
		enterKeys(txt_Dest,dest); 
		enterKeys(txt_shipmentDescription,"remark"); 
		enterKeys(txt_RcvdPcs,"100");
		enterKeys(txt_RcvdWt,"1000");
		click(btn_OK_ULD);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			minWait();
			Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("Received pieces is greater than the Stated pieces")); 

			click(yesBtn);
		}
		minWait();
		if (verifyElementPresent(yesBtn)) {
			minWait();
			Assert.assertTrue(waitForElement(Generic_info_msg).getText().contains("Received weight is greater than the Stated weight")); 

			click(yesBtn);
			minWait();
		}
		if (verifyElementPresent(yesBtn)) {
			minWait();
			click(yesBtn);
			minWait();
		}
		if (verifyElementPresent(yesBtn)) {
			minWait();

			click(yesBtn);
			minWait();
		}
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(btn_save);
		driver.switchTo().defaultContent();

		if(verifyElementPresent(yesBtn))
		{
			click(yesBtn);
		}

		waitForFrameAndSwitch(FRAME);
		waitForNewWindow(2);
		switchToSecondWindow();
		click(btn_HouseMismatch_ok);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);
		minWait();
		return this;
	}

	/**
	 * Created by A-7605 on 7-02-18
	 * This method will close flight having no discrepancy
	 * @param flightNo
	 * @param flightDate
	 * @return
	 */
	public OPR061 CloseFlight_NoDiscrepancy(String flightNo, String flightDate){


		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		flightDate = PropertyHandler.getPropValue(dataFilePath, flightDate);

		enterKeys((txt_FlightNo),flightNo );
		enterKeys(txt_FlightDate, flightDate);
		click(btn_list);
		minWait();	         
		click(btn_closeFlight);
		minWait();
		return this;

	}
	

}
