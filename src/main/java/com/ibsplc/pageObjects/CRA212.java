package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * 
 * Created on 12/02/2018
 * 
 * @author a-6836
 */
public class CRA212 extends BasePage {

	public static String FRAME = "iCargoContentFrameCRA212";
	public static String screenFrame = "iCargoContentFrameCRA212";
	private static String objFilepath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "CRA_CMT.properties");
	private static String genObjPath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "Generic.properties");
	WebDriver driver;
	String dataFileName;
	private String dataFilePath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "testDataDirectory");
	private By text_shipmentPrefix, text_documentNumber, Popup_Nobtn,
			btn_btnList, text_outBoundFoP, btn_btnAWBRouting,
			text_AWBRoutingflightCarrierCode, text_AWBRoutingflightNumber,
			text_AWBRoutingflightDate, btn_AWBRoutingbtnClose,
			btn_btnRateAudited, btn_btnFinalize, btn_btnClose,
			btn_AWBRoutingbtnSave, txt_inboundFopStatus, txt_outboundCustomer,
			txt_intboundCustomer, tbl_AWBRouting, Lnk_updateRatingLink,
			text_AWBRoutingflightNumber1, info_ppWeightCharges,
			info_valuationChargePP, info_ppOCDA, info_tax, info_ppOCDC,
			info_ppTotal, text_AWBRoutingflightDate1, info_voidedStatusSpan,
			dropDown_paymentType, btn_yesPushbutton, info_additionalCommission,
			info_commission, btn_noPushbutton, yesBtn, noBtn, msg_popup,
			btn_genericOk, info_genericMsg, btn_OKchargePopup, okBtn,
			info_imgfinalised, btn_expandProration, btn_spotSPA,
			dropDown_spaRateBasis, btn_void, btn_voidsub, txt_spaFlatCharge,
			txt_rateingAuditedIataCharge, btn_deleteAWB, btn_spaOK,
			info_prorateMethod, info_prorateNetvalue, info_errorMsg,
			info_error, div_MarketCharge, div_IATACharge,
			info_primaryProratePayReceive, btn_proceedbtn, info_genericErr;

	private By icon_rateAudit;

	private By table_freightCharges;

	private By table_prorationDetails;

	private By tableAwbRoutingDetails;

	private By btn_expand;

	private By table_prorationexpanded;

	private By label_primaryproratedAirline;

	private By label_secondaryProratedAirline;

	public CRA212(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}

	/**
	 * Initializes the page objects required for the class
	 */
	private void initElements() {

		text_shipmentPrefix = MiscUtility.getWebElement(objFilepath,
				"CRA212_text_shipmentPrefix");
		text_documentNumber = MiscUtility.getWebElement(objFilepath,
				"CRA212_text_documentNumber");
		btn_btnList = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_btnList");
		Popup_Nobtn = MiscUtility.getWebElement(objFilepath,
				"CRA212_Popup_Nobtn");
		text_outBoundFoP = MiscUtility.getWebElement(objFilepath,
				"CRA212_text_outBoundFoP");
		btn_btnAWBRouting = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_btnAWBRouting");
		text_AWBRoutingflightCarrierCode = MiscUtility.getWebElement(
				objFilepath, "CRA212_text_AWBRoutingflightCarrierCode");
		text_AWBRoutingflightNumber = MiscUtility.getWebElement(objFilepath,
				"CRA212_text_AWBRoutingflightNumber");
		text_AWBRoutingflightDate = MiscUtility.getWebElement(objFilepath,
				"CRA212_text_AWBRoutingflightDate");
		text_AWBRoutingflightNumber1 = MiscUtility.getWebElement(objFilepath,
				"CRA212_text_AWBRoutingflightNumber1");
		text_AWBRoutingflightDate1 = MiscUtility.getWebElement(objFilepath,
				"CRA212_text_AWBRoutingflightDate1");
		btn_AWBRoutingbtnClose = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_AWBRoutingbtnClose");
		btn_btnRateAudited = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_btnRateAudited");
		btn_btnFinalize = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_btnFinalize");
		info_imgfinalised = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_btnFinalize");
		btn_btnClose = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_btnClose");
		btn_AWBRoutingbtnSave = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_AWBRoutingbtnSave");
		btn_proceedbtn = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_proceedbtn");

		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		msg_popup = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		info_genericMsg = MiscUtility.getWebElement(genObjPath,
				"Generic_info_msg");
		okBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		info_genericErr = MiscUtility.getWebElement(genObjPath,
				"Generic_info_error");

		txt_outboundCustomer = MiscUtility.getWebElement(objFilepath,
				"CRA212_txt_outboundCustomer");
		txt_intboundCustomer = MiscUtility.getWebElement(objFilepath,
				"CRA212_txt_intboundCustomer");
		info_voidedStatusSpan = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_voidedStatusSpan");
		dropDown_paymentType = MiscUtility.getWebElement(objFilepath,
				"CRA212_dropDown_paymentType");
		tbl_AWBRouting = MiscUtility.getWebElement(objFilepath,
				"CRA212_tbl_AWBRouting");
		info_ppWeightCharges = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_ppWeightCharges");
		info_valuationChargePP = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_valuationChargePP");
		info_ppOCDA = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_ppOCDA");
		info_tax = MiscUtility.getWebElement(objFilepath, "CRA212_info_tax");
		info_ppOCDC = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_ppOCDC");
		info_ppTotal = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_ppTotal");
		info_additionalCommission = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_additionalCommission");
		info_commission = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_commission");
		btn_expandProration = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_expandProration");
		btn_spotSPA = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_spotSPA");
		dropDown_spaRateBasis = MiscUtility.getWebElement(objFilepath,
				"CRA212_dropDown_spaRateBasis");
		txt_spaFlatCharge = MiscUtility.getWebElement(objFilepath,
				"CRA212_txt_spaFlatCharge");
		btn_spaOK = MiscUtility.getWebElement(objFilepath, "CRA212_btn_spaOK");
		info_prorateMethod = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_prorateMethod");
		info_prorateNetvalue = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_prorateNetvalue");
		btn_void = MiscUtility.getWebElement(objFilepath, "CRA212_btn_void");
		btn_voidsub = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_voidsub");
		btn_deleteAWB = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_deleteAWB");
		Lnk_updateRatingLink = MiscUtility.getWebElement(objFilepath,
				"CRA073_Lnk_updateRatingLink");
		txt_rateingAuditedIataCharge = MiscUtility.getWebElement(objFilepath,
				"CRA073_txt_rateingAuditedIataCharge");
		btn_OKchargePopup = MiscUtility.getWebElement(objFilepath,
				"CRA212_btn_OKchargePopup");
		txt_inboundFopStatus = MiscUtility.getWebElement(objFilepath,
				"CRA212_txt_inboundFopStatus");
		info_error = MiscUtility
				.getWebElement(genObjPath, "Generic_info_error");
		info_errorMsg = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_errorMsg");
		div_MarketCharge = MiscUtility.getWebElement(objFilepath,
				"CRA212_div_MarketCharge");
		div_IATACharge = MiscUtility.getWebElement(objFilepath,
				"CRA212_div_IATACharge");
		info_primaryProratePayReceive = MiscUtility.getWebElement(objFilepath,
				"CRA212_info_primaryProratePayReceive");

		/*icon_rateAudit = MiscUtility.getWebElement(objFilepath,
				"CRA212_icon_rateAudit");*/
		/*table_freightCharges = MiscUtility.getWebElement(objFilepath,
				"CRA212_table_freightChrg");
		table_prorationDetails = MiscUtility.getWebElement(objFilepath,
				"CRA212_table_freightChrg");
		btn_expand = MiscUtility
				.getWebElement(objFilepath, "CRA212_expandform");
		table_prorationexpanded = MiscUtility.getWebElement(objFilepath,
				"CRA212_table_prorationTable1");
		label_primaryproratedAirline = MiscUtility.getWebElement(objFilepath,
				"CRA212_label_proratedAirline2");
		label_secondaryProratedAirline = MiscUtility.getWebElement(objFilepath,
				"CRA212_label_secorndaryProAirline");*/

	}

	/**
	 * Strore all PP charges
	 * 
	 * @param prefix
	 * @param awbno
	 * @param weightCharge
	 * @param tax
	 * @param OCDA
	 * @param OCDC
	 * @param valuationCharges
	 * @param totalPP
	 * @return
	 */

	public CRA212 storePPValues(String prefix, String awbno,
			String weightCharge, String tax, String OCDA, String OCDC,
			String valuationCharges, String totalPP, String commission,
			String discount) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();

		scrollToView(info_ppWeightCharges);

		weightCharge = waitForElementVisible(info_ppWeightCharges)
				.getAttribute("value");
		tax = waitForElementVisible(info_tax).getAttribute("value");
		OCDA = waitForElementVisible(info_ppOCDA).getAttribute("value");
		OCDC = waitForElementVisible(info_ppOCDC).getAttribute("value");
		valuationCharges = waitForElementVisible(info_valuationChargePP)
				.getAttribute("value");
		totalPP = waitForElementVisible(info_ppTotal).getAttribute("value");
		// commission = waitForElement(info_commission).getAttribute("value");
		// System.out.println(info_commission);
		// discount =
		// waitForElement(info_additionalCommission).getAttribute("value");
		// System.out.println(info_additionalCommission);

		PropertyHandler.setPropValue(dataFilePath, weightCharge, weightCharge);
		PropertyHandler.setPropValue(dataFilePath, tax, tax);
		PropertyHandler.setPropValue(dataFilePath, OCDA, OCDA);
		PropertyHandler.setPropValue(dataFilePath, OCDC, OCDC);
		PropertyHandler.setPropValue(dataFilePath, valuationCharges,
				valuationCharges);
		PropertyHandler.setPropValue(dataFilePath, totalPP, totalPP);
		// PropertyHandler.setPropValue(dataFilePath, commission, commission);
		// PropertyHandler.setPropValue(dataFilePath, discount, discount);

		return this;
	}

	public CRA212 storeMarketCharge(String MarketCharge) {
		minWait();
		scrollToView(div_MarketCharge);
		MarketCharge = waitForElement(div_MarketCharge).getText();
		System.out.println(MarketCharge);

		PropertyHandler.setPropValue(dataFilePath, MarketCharge, MarketCharge);

		return this;
	}

	public CRA212 storeIATACharge(String IATACharge, String IATAChargeAddn) {
		minWait();
		scrollToView(div_IATACharge);
		IATACharge = waitForElement(div_IATACharge).getText();
		System.out.println(IATACharge);

		PropertyHandler.setPropValue(dataFilePath, IATACharge, IATACharge);

		int IATAChrg = Integer.parseInt(IATACharge);
		int IAddn;
		IAddn = IATAChrg + 100;
		String IATAAddn = Integer.toString(IAddn);
		PropertyHandler.setPropValue(dataFilePath, IATAChargeAddn, IATAAddn);

		return this;
	}

	public CRA212 storeWeightChargPP(String prefix, String awbno,
			String WeightCharge) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();

		scrollToView(info_ppWeightCharges);
		scrollToView(info_ppWeightCharges);
		String weightCharge = waitForElementVisible(info_ppWeightCharges)
				.getAttribute("value").replace(",", "");
		System.out.println(weightCharge);
		PropertyHandler.setPropValue(dataFilePath, WeightCharge, weightCharge);
		// weightCharge = PropertyHandler.getPropValue(dataFilePath,
		// WeightCharge);

		return this;

	}

	public CRA212 storeModifiedWeightChargPP_Greater(String prefix,
			String awbno, String WeightCharge, int... extraCharge) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();

		scrollToView(info_ppWeightCharges);

		String weightCharge = waitForElementVisible(info_ppWeightCharges)
				.getAttribute("value").replace(",", "");
		System.out.println(weightCharge);

		float Wchrg = Float.parseFloat(weightCharge);

		if (extraCharge.length != 0) {
			Wchrg += extraCharge[0];
		} else {
			Wchrg = Wchrg + 1000;
		}
		String wtChgNew = Float.toString(Wchrg);
		PropertyHandler.setPropValue(dataFilePath, WeightCharge, wtChgNew);
		// weightCharge = PropertyHandler.getPropValue(dataFilePath,
		// WeightCharge);

		return this;

	}

	public CRA212 storeModifiedWeightChargPP_Lesser(String prefix,
			String awbno, String WeightCharge) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();

		scrollToView(info_ppWeightCharges);

		String weightCharge = waitForElementVisible(info_ppWeightCharges)
				.getAttribute("value").replace(",", "");
		System.out.println(weightCharge);

		float Wchrg = Float.parseFloat(weightCharge);
		Wchrg = Wchrg - 200;
		String wtChgNew = Float.toString(Wchrg);
		PropertyHandler.setPropValue(dataFilePath, WeightCharge, wtChgNew);
		// weightCharge = PropertyHandler.getPropValue(dataFilePath,
		// WeightCharge);

		return this;

	}

	/**
	 * For creating SPA for interline
	 * 
	 * @param prefix
	 * @param AWB
	 * @param flightno
	 * @param fltDate
	 * @param flatCharge
	 * @return
	 */
	public CRA212 createSPA_finalize(String prefix, String AWB,
			String flightno, String fltDate, String flatCharge,
			String carrier_OAL) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		AWB = PropertyHandler.getPropValue(dataFilePath, AWB);
		flightno = PropertyHandler.getPropValue(dataFilePath, flightno);
		fltDate = PropertyHandler.getPropValue(dataFilePath, fltDate);
		flatCharge = PropertyHandler.getPropValue(dataFilePath, flatCharge);
		carrier_OAL = PropertyHandler.getPropValue(dataFilePath, carrier_OAL);
		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, AWB);
		click(btn_btnList);
		minWait();

		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
			// waitForFrameAndSwitch(FRAME);
			minWait();
			driver.switchTo().defaultContent();
			waitForFrameAndSwitch(FRAME);
		}

		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();
		enterKeys(text_AWBRoutingflightCarrierCode, carrier_OAL);
		enterKeys(text_AWBRoutingflightDate, fltDate);

		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();

		scrollToView(btn_expandProration);
		click(btn_expandProration);
		minWait();

		// driver.switchTo().defaultContent();
		// switchToSecondWindow();
		// waitForNewWindow(2);
		scrollToView(btn_spotSPA);
		click(btn_spotSPA);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();

		selectByText(dropDown_spaRateBasis, "Flat Charge Basis");
		enterKeys(txt_spaFlatCharge, flatCharge);
		click(btn_spaOK);
		maxWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		scrollToView(info_prorateMethod);
		System.out.println(waitForElement(info_prorateMethod).getText());
		System.out.println(waitForElement(info_prorateNetvalue).getText());
		Assert.assertTrue(waitForElement(info_prorateMethod).getText()
				.contains("SPT"), "ERROR:Prorate Method is not correct");
		Assert.assertTrue(waitForElement(info_prorateNetvalue).getText()
				.contains(flatCharge), "ERROR: SPA charge is not stamped");

		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_noPushbutton)) {

			List<WebElement> listElement1;
			listElement1 = getWebElements(btn_noPushbutton);
			int count1 = listElement1.size();
			for (int i = 1; i <= count1; i++) {
				click(getWebElements(btn_noPushbutton).get(i));
			}

		}

		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		// Assert.assertFalse(waitForElement(info_imgfinalised).getAttribute("class").equalsIgnoreCase("complete"),"ERROR: AWB not finalized");
		return this;
	}

	public CRA212 createSPA_ManualPRoration(String prefix, String AWB,
			String flightno, String fltDate, String flatCharge,
			String carrier_OAL) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		AWB = PropertyHandler.getPropValue(dataFilePath, AWB);
		flightno = PropertyHandler.getPropValue(dataFilePath, flightno);
		fltDate = PropertyHandler.getPropValue(dataFilePath, fltDate);
		flatCharge = PropertyHandler.getPropValue(dataFilePath, flatCharge);
		carrier_OAL = PropertyHandler.getPropValue(dataFilePath, carrier_OAL);
		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, AWB);
		click(btn_btnList);
		minWait();

		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
			// waitForFrameAndSwitch(FRAME);
			minWait();
			driver.switchTo().defaultContent();
			waitForFrameAndSwitch(FRAME);
		}

		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();
		enterKeys(text_AWBRoutingflightCarrierCode, carrier_OAL);
		enterKeys(text_AWBRoutingflightDate, fltDate);

		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();

		scrollToView(btn_expandProration);
		click(btn_expandProration);
		minWait();

		// driver.switchTo().defaultContent();
		// switchToSecondWindow();
		// waitForNewWindow(2);
		scrollToView(btn_spotSPA);
		click(btn_spotSPA);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();

		selectByText(dropDown_spaRateBasis, "Flat Charge Basis");
		enterKeys(txt_spaFlatCharge, flatCharge);
		click(btn_spaOK);
		maxWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		scrollToView(info_prorateMethod);
		System.out.println(waitForElement(info_prorateMethod).getText());
		System.out.println(waitForElement(info_prorateNetvalue).getText());
		Assert.assertTrue(waitForElement(info_prorateMethod).getText()
				.contains("SPT"), "ERROR:Prorate Method is not correct");
		Assert.assertTrue(waitForElement(info_prorateNetvalue).getText()
				.contains(flatCharge), "ERROR: SPA charge is not stamped");

		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_noPushbutton)) {

			List<WebElement> listElement1;
			listElement1 = getWebElements(btn_noPushbutton);
			int count1 = listElement1.size();
			for (int i = 1; i <= count1; i++) {
				click(getWebElements(btn_noPushbutton).get(i));
			}

		}

		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		// Assert.assertFalse(waitForElement(info_imgfinalised).getAttribute("class").equalsIgnoreCase("complete"),"ERROR: AWB not finalized");
		return this;
	}

	/**
	 * For creating SPA for interline
	 * 
	 * @param prefix
	 * @param AWB
	 * @param flightno
	 * @param fltDate
	 * @param flatCharge
	 * @return
	 */
	public CRA212 createSPA_finalize_NoInwardBilling(String prefix, String AWB,
			String flightno, String fltDate, String flatCharge,
			String carrier_OAL, boolean billed) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		AWB = PropertyHandler.getPropValue(dataFilePath, AWB);
		flightno = PropertyHandler.getPropValue(dataFilePath, flightno);
		fltDate = PropertyHandler.getPropValue(dataFilePath, fltDate);
		flatCharge = PropertyHandler.getPropValue(dataFilePath, flatCharge);
		carrier_OAL = PropertyHandler.getPropValue(dataFilePath, carrier_OAL);
		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, AWB);
		click(btn_btnList);
		minWait();

		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
			// waitForFrameAndSwitch(FRAME);
			minWait();
			driver.switchTo().defaultContent();
			waitForFrameAndSwitch(FRAME);
		}

		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();
		enterKeys(text_AWBRoutingflightCarrierCode, carrier_OAL);
		enterKeys(text_AWBRoutingflightDate, fltDate);

		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();

		scrollToView(btn_expandProration);
		click(btn_expandProration);
		minWait();

		// driver.switchTo().defaultContent();
		// switchToSecondWindow();
		// waitForNewWindow(2);
		scrollToView(btn_spotSPA);
		click(btn_spotSPA);
		minWait();
		waitForNewWindow(2);
		switchToSecondWindow();

		selectByText(dropDown_spaRateBasis, "Flat Charge Basis");
		enterKeys(txt_spaFlatCharge, flatCharge);
		click(btn_spaOK);
		maxWait();
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		scrollToView(info_prorateMethod);
		System.out.println(waitForElement(info_prorateMethod).getText());
		System.out.println(waitForElement(info_prorateNetvalue).getText());
		if (billed)
			Assert.assertTrue(waitForElement(info_prorateMethod).getText()
					.contains("SBT"), "ERROR:Prorate Method is not correct");
		else
			Assert.assertTrue(waitForElement(info_prorateMethod).getText()
					.contains("FBP"), "ERROR:Prorate Method is not correct");
		Assert.assertTrue(waitForElement(info_prorateNetvalue).getText()
				.contains(flatCharge), "ERROR: SPA charge is not stamped");

		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_noPushbutton)) {

			List<WebElement> listElement1;
			listElement1 = getWebElements(btn_noPushbutton);
			int count1 = listElement1.size();
			for (int i = 1; i <= count1; i++) {
				click(getWebElements(btn_noPushbutton).get(i));
			}

		}

		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		// Assert.assertFalse(waitForElement(info_imgfinalised).getAttribute("class").equalsIgnoreCase("complete"),"ERROR: AWB not finalized");
		return this;
	}

	/***
	 * 
	 * @param paymntType
	 * @return
	 */
	public CRA212 verifyPrimaryProration(String paymntType) {

		paymntType = PropertyHandler.getPropValue(dataFilePath, paymntType);

		scrollToView(info_primaryProratePayReceive);
		Assert.assertTrue(waitForElement(info_primaryProratePayReceive)
				.getText().contains(paymntType));

		return this;
	}

	public CRA212 makeVoid(String awbPrefix, String AWBNo) {

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
		enterKeys(text_shipmentPrefix, awbPrefix);
		enterKeys(text_documentNumber, AWBNo);
		click(btn_btnList);
		minWait();

		click(btn_void);
		click(btn_voidsub);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	public CRA212 deleteAWB(String awbPrefix, String AWBNo) {

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
		enterKeys(text_shipmentPrefix, awbPrefix);
		enterKeys(text_documentNumber, AWBNo);
		click(btn_btnList);
		minWait();

		click(btn_void);
		click(btn_deleteAWB);
		minWait();
		driver.switchTo().defaultContent();
		click(yesBtn);
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/***
	 * 
	 * @param prefix
	 * @param awbno
	 * @param OutBoundFop
	 * @param carrier
	 * @param Fltno
	 * @param Fltdate
	 * @param status
	 * @param agentcode
	 * @param customerType
	 * @return
	 */
	public CRA212 MultiRouteRateAuditFinalize(String prefix, String awbno,
			String OutBoundFop, String carrier, String Fltno, String Fltdate,
			String status, String agentcode, String customerType) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		OutBoundFop = PropertyHandler.getPropValue(dataFilePath, OutBoundFop);
		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		Fltno = PropertyHandler.getPropValue(dataFilePath, Fltno);
		Fltdate = PropertyHandler.getPropValue(dataFilePath, Fltdate);
		status = PropertyHandler.getPropValue(dataFilePath, status);
		agentcode = PropertyHandler.getPropValue(dataFilePath, agentcode);
		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
			waitForFrameAndSwitch(FRAME);
			minWait();
			driver.switchTo().defaultContent();
			waitForFrameAndSwitch(FRAME);
		}

		if (customerType.equals("Outbound")) {

			String Fop = waitForElementVisible(text_outBoundFoP).getAttribute(
					"value");
			System.out.println("Outbound Fop=" + Fop);
			// Assert.assertTrue(Fop.contains(OutBoundFop),
			// "ERROR: Outbound Fop mismatch");

			Assert.assertTrue(waitForElement(txt_outboundCustomer)
					.getAttribute("value").contains(agentcode),
					"ERROR: Outbound customer mismatch");
		}

		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();

		enterKeys(text_AWBRoutingflightDate, Fltdate + Keys.TAB);
		enterKeys(text_AWBRoutingflightNumber, Fltno);

		click(text_AWBRoutingflightDate1);
		enterKeys(text_AWBRoutingflightDate1, Fltdate + Keys.TAB);
		// enterKeys(getWebElements(text_AWBRoutingflightDate1).get(1),
		// Fltdate);

		minWait();

		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();

		click(btn_btnFinalize);
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		// Assert.assertFalse(waitForElement(info_imgfinalised).getAttribute("class").equalsIgnoreCase("complete"),"ERROR: AWB not finalized");
		return this;
	}

	/***
	 * 
	 * @param prefix
	 * @param awbno
	 * @param agentcode
	 * @param customerType
	 * @return
	 */
	public CRA212 MultiRouteRateAuditFinalizeWithoutRouting(String prefix,
			String awbno, String agentcode, String customerType) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		agentcode = PropertyHandler.getPropValue(dataFilePath, agentcode);
		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
			waitForFrameAndSwitch(FRAME);
			minWait();
			driver.switchTo().defaultContent();
			waitForFrameAndSwitch(FRAME);
		}

		if (customerType.equals("Outbound")) {

			String Fop = waitForElementVisible(text_outBoundFoP).getAttribute(
					"value");
			System.out.println("Outbound Fop=" + Fop);
			// Assert.assertTrue(Fop.contains(OutBoundFop),
			// "ERROR: Outbound Fop mismatch");

			Assert.assertTrue(waitForElement(txt_outboundCustomer)
					.getAttribute("value").contains(agentcode),
					"ERROR: Outbound customer mismatch");
		}

		// driver.switchTo().defaultContent();
		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();

		waitForElement(info_genericErr);

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();
		minWait();

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();

		click(btn_btnFinalize);
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		// Assert.assertFalse(waitForElement(info_imgfinalised).getAttribute("class").equalsIgnoreCase("complete"),"ERROR: AWB not finalized");
		return this;
	}

	/***
	 * * customerType=Inbound/Outbound
	 * 
	 * @param prefix
	 * @param awbno
	 * @param OutBoundFop
	 * @param carrier
	 * @param Fltno
	 * @param Fltdate
	 * @param status
	 * @param agentcode
	 * @param customerType
	 * @return
	 */
	public CRA212 CheckFopRateAuditFinalize(String prefix, String awbno,
			String OutBoundFop, String carrier, String Fltno, String Fltdate,
			String status, String agentcode, String customerType) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		OutBoundFop = PropertyHandler.getPropValue(dataFilePath, OutBoundFop);
		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		Fltno = PropertyHandler.getPropValue(dataFilePath, Fltno);
		Fltdate = PropertyHandler.getPropValue(dataFilePath, Fltdate);
		status = PropertyHandler.getPropValue(dataFilePath, status);
		agentcode = PropertyHandler.getPropValue(dataFilePath, agentcode);
		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);
		if (customerType.equals("Outbound")) {

			String Fop = waitForElementVisible(text_outBoundFoP).getAttribute(
					"value");
			System.out.println("Outbound Fop=" + Fop);
			// Assert.assertTrue(Fop.contains(OutBoundFop),
			// "ERROR: Outbound Fop mismatch");

			Assert.assertTrue(waitForElement(txt_outboundCustomer)
					.getAttribute("value").contains(agentcode),
					"ERROR: Outbound customer mismatch");
		} else {
			String fop = waitForElement(txt_inboundFopStatus).getAttribute(
					"value");
			Assert.assertTrue(fop.contains(OutBoundFop),
					"ERROR: Inbound Fop mismatch");
			Assert.assertTrue(waitForElement(txt_intboundCustomer)
					.getAttribute("value").contains(agentcode),
					"ERROR: Inbound customer mismatch");

		}
		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();
		enterKeys(text_AWBRoutingflightCarrierCode, carrier);
		enterKeys(text_AWBRoutingflightDate, Fltdate);
		enterKeys(text_AWBRoutingflightNumber, Fltno);
		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_noPushbutton)) {

			List<WebElement> listElement1;
			listElement1 = getWebElements(btn_noPushbutton);
			int count1 = listElement1.size();
			for (int i = 1; i <= count1; i++) {
				click(getWebElements(btn_noPushbutton).get(i));
			}

		}

		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		// Assert.assertFalse(waitForElement(info_imgfinalised).getAttribute("class").equalsIgnoreCase("complete"),"ERROR: AWB not finalized");
		return this;
	}

	public CRA212 CorrectAWBRouting(String prefix, String awbno,
			String carrier, String Fltno, String Fltdate, String status) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		Fltno = PropertyHandler.getPropValue(dataFilePath, Fltno);
		Fltdate = PropertyHandler.getPropValue(dataFilePath, Fltdate);
		status = PropertyHandler.getPropValue(dataFilePath, status);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();

		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();
		enterKeys(text_AWBRoutingflightCarrierCode, carrier);
		enterKeys(text_AWBRoutingflightDate, Fltdate);
		enterKeys(text_AWBRoutingflightNumber, Fltno);
		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();
		Assert.assertFalse(
				waitForElement(info_imgfinalised).getAttribute("class")
						.equalsIgnoreCase("complete"),
				"ERROR: AWB not finalized");
		return this;
	}

	/****
	 * for adding Routing,rate audit,finalize
	 * 
	 * @param prefix
	 * @param awbno
	 * @param carrier
	 * @param Fltno
	 * @param Fltdate
	 * @param status
	 * @return Author:A-6784
	 ***/

	public CRA212 routingRateAuditFinalize(String prefix, String awbno,
			String carrier, String Fltno, String Fltdate, String status) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		Fltno = PropertyHandler.getPropValue(dataFilePath, Fltno);
		Fltdate = PropertyHandler.getPropValue(dataFilePath, Fltdate);
		status = PropertyHandler.getPropValue(dataFilePath, status);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();
		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);

			maxWait();
		}
		waitForFrameAndSwitch(FRAME);
		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();
		enterKeys(text_AWBRoutingflightCarrierCode, carrier);
		enterKeys(text_AWBRoutingflightDate, Fltdate);
		enterKeys(text_AWBRoutingflightNumber, Fltno);
		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_noPushbutton)) {

			List<WebElement> listElement1;
			listElement1 = getWebElements(btn_noPushbutton);
			int count1 = listElement1.size();
			for (int i = 1; i <= count1; i++) {
				click(getWebElements(btn_noPushbutton).get(i));
			}

		}

		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);

		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		// Assert.assertFalse(waitForElement(info_imgfinalised).getAttribute("class").equalsIgnoreCase("complete"),"ERROR: AWB not finalized");
		return this;
	}

	public CRA212 validateRateAudit(String prefix, String awbno,
			boolean complete) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);

			maxWait();
		}
		System.out
				.println(waitForElement(icon_rateAudit).getAttribute("class"));
		if (complete)
			Assert.assertTrue(
					waitForElement(icon_rateAudit).getAttribute("class")
							.contains("complete"), "rate should be audited");
		else
			Assert.assertTrue(
					waitForElement(icon_rateAudit).getAttribute("class")
							.contains("progress"), "rate should NOT be audited");
		return this;
	}

	public CRA212 validateRouting(String prefix, String awbno, String flightNo,
			String carrier, String fltDate) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);
		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		fltDate = PropertyHandler.getPropValue(dataFilePath, fltDate);
		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
			// waitForFrameAndSwitch(FRAME);
			minWait();
			driver.switchTo().defaultContent();
			waitForFrameAndSwitch(FRAME);
		}

		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();
		enterKeys(text_AWBRoutingflightCarrierCode, carrier);
		enterKeys(text_AWBRoutingflightDate, fltDate);

		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();

		scrollToView(btn_expandProration);
		click(btn_expandProration);
		minWait();

		boolean flag = verifyValuePresentInTblColumn(table_freightCharges, 1,
				flightNo);
		Assert.assertTrue(flag, "flight number should be present");

		return this;
	}

	public CRA212 validateProration(String prefix, String awbno, String flightNo) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		flightNo = PropertyHandler.getPropValue(dataFilePath, flightNo);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();
		boolean flag = verifyValuePresentInTblColumn(table_freightCharges, 1,
				flightNo);
		Assert.assertTrue(flag, "flight number should be present");
		// Assert.assertTrue(condition, message);
		minWait();
		return this;
	}

	public CRA212 importAwb(String prefix, String awbno) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
			// waitForFrameAndSwitch(FRAME);
			minWait();
			driver.switchTo().defaultContent();
			waitForFrameAndSwitch(FRAME);
		}
		return this;
	}

	public CRA212 NoroutingRateAuditFinalize(String prefix, String awbno,
			String carrier, String Fltno, String Fltdate, String status) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		Fltno = PropertyHandler.getPropValue(dataFilePath, Fltno);
		Fltdate = PropertyHandler.getPropValue(dataFilePath, Fltdate);
		status = PropertyHandler.getPropValue(dataFilePath, status);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();
		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);

			maxWait();
		}
		waitForFrameAndSwitch(FRAME);
		// click(btn_btnAWBRouting);
		// minWait();
		// //driver.switchTo().defaultContent();
		// enterKeys(text_AWBRoutingflightCarrierCode, carrier);
		// enterKeys(text_AWBRoutingflightDate, Fltdate);
		// enterKeys(text_AWBRoutingflightNumber, Fltno);
		// click(btn_AWBRoutingbtnSave);
		// minWait();
		// driver.switchTo().defaultContent();
		// click(okBtn);
		// waitForFrameAndSwitch(FRAME);
		// click(btn_AWBRoutingbtnClose);
		// minWait();
		// driver.switchTo().defaultContent();
		click(btn_btnRateAudited);
		minWait();
		if (verifyElementPresent(info_error))
			Assert.assertTrue(
					waitForElement(info_error).getText().contains(
							"Reproration Failed"),
					"Reproration failed message should be present");
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_noPushbutton)) {

			List<WebElement> listElement1;
			listElement1 = getWebElements(btn_noPushbutton);
			int count1 = listElement1.size();
			for (int i = 1; i <= count1; i++) {
				click(getWebElements(btn_noPushbutton).get(i));
			}

		}

		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);

		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		// Assert.assertFalse(waitForElement(info_imgfinalised).getAttribute("class").equalsIgnoreCase("complete"),"ERROR: AWB not finalized");
		return this;
	}

	public CRA212 RateAudit(String prefix, String awbno) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
			maxWait();
		}
		waitForFrameAndSwitch(FRAME);
		click(btn_btnAWBRouting);
		minWait();

		// driver.switchTo().defaultContent();
		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_noPushbutton)) {

			List<WebElement> listElement1;
			listElement1 = getWebElements(btn_noPushbutton);
			int count1 = listElement1.size();
			for (int i = 1; i <= count1; i++) {
				click(getWebElements(btn_noPushbutton).get(i));
			}

		}

		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);

		minWait();

		return this;
	}

	public CRA212 finalizewithoutList() {

		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_noPushbutton)) {

			List<WebElement> listElement1;
			listElement1 = getWebElements(btn_noPushbutton);
			int count1 = listElement1.size();
			for (int i = 1; i <= count1; i++) {
				click(getWebElements(btn_noPushbutton).get(i));
			}

		}

		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);

		minWait();

		return this;
	}

	/***
	 * 
	 * @param prefix
	 * @param awbno
	 * @return
	 */

	public CRA212 FinalizeAWB(String prefix, String awbno) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();

		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		// Assert.assertFalse(waitForElement(info_imgfinalised).getAttribute("class").equalsIgnoreCase("complete"),"ERROR: AWB not finalized");
		return this;
	}

	public CRA212 changePaymntType_ErrorCheck(String awbPrefix, String awbNo,
			String paymntType, String carrier, String fltDate, String fltno) {

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		paymntType = PropertyHandler.getPropValue(dataFilePath, paymntType);
		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		fltDate = PropertyHandler.getPropValue(dataFilePath, fltDate);
		fltno = PropertyHandler.getPropValue(dataFilePath, fltno);

		enterKeys(text_shipmentPrefix, awbPrefix);
		enterKeys(text_documentNumber, awbNo);
		click(btn_btnList);
		minWait();

		selectByText(dropDown_paymentType, paymntType);
		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();
		enterKeys(text_AWBRoutingflightCarrierCode, carrier);
		enterKeys(text_AWBRoutingflightDate, fltDate);
		enterKeys(text_AWBRoutingflightNumber, fltno);
		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();

		String tempError = waitForElement(info_errorMsg).getText();
		Assert.assertTrue(tempError
				.contains("Import Payment advice with FoP CREDIT is available for the AWB at the destination station. Please cancel the Payment Advice before changing the Payment Type"));
		return this;

	}

	/***
	 * Change payment type and rate audit the shipment
	 * 
	 * @param prefix
	 * @param awbno
	 * @param carrier
	 * @param Fltno
	 * @param Fltdate
	 * @param status
	 * @return
	 */
	public CRA212 RateAuditFinalizeafterChangePaymentType(String prefix,
			String awbno, String carrier, String Fltno, String Fltdate,
			String status, String paymentType) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		Fltno = PropertyHandler.getPropValue(dataFilePath, Fltno);
		Fltdate = PropertyHandler.getPropValue(dataFilePath, Fltdate);
		status = PropertyHandler.getPropValue(dataFilePath, status);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();

		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
			// waitForFrameAndSwitch(FRAME);
			maxWait();
		}

		selectByValue(dropDown_paymentType, paymentType);

		selectByText(dropDown_paymentType, paymentType);

		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();
		enterKeys(text_AWBRoutingflightCarrierCode, carrier);
		enterKeys(text_AWBRoutingflightDate, Fltdate);
		enterKeys(text_AWBRoutingflightNumber, Fltno);
		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_noPushbutton)) {

			List<WebElement> listElement1;
			listElement1 = getWebElements(btn_noPushbutton);
			int count1 = listElement1.size();
			for (int i = 1; i <= count1; i++) {
				click(getWebElements(btn_noPushbutton).get(i));
			}

		}

		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		Assert.assertFalse(
				waitForElement(info_imgfinalised).getAttribute("class")
						.equalsIgnoreCase("complete"),
				"ERROR: AWB not finalized");
		return this;
	}

	// RateAuditFinalizeafterChangePaymentTypeError

	public CRA212 RateAuditFinalizeafterChangePaymentTypeMulti(String prefix,
			String awbno, String carrier, String Fltno, String Fltdate,
			String status, String paymentType) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		carrier = PropertyHandler.getPropValue(dataFilePath, carrier);
		Fltno = PropertyHandler.getPropValue(dataFilePath, Fltno);
		Fltdate = PropertyHandler.getPropValue(dataFilePath, Fltdate);
		status = PropertyHandler.getPropValue(dataFilePath, status);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();
		selectByValue(dropDown_paymentType, paymentType);
		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();
		enterKeys(text_AWBRoutingflightDate, Fltdate + Keys.TAB);
		enterKeys(text_AWBRoutingflightNumber1, Fltno);

		click(text_AWBRoutingflightDate1);
		enterKeys(text_AWBRoutingflightDate1, Fltdate + Keys.TAB);
		// enterKeys(getWebElements(text_AWBRoutingflightDate1).get(1),
		// Fltdate);
		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_noPushbutton)) {

			List<WebElement> listElement1;
			listElement1 = getWebElements(btn_noPushbutton);
			int count1 = listElement1.size();
			for (int i = 1; i <= count1; i++) {
				click(getWebElements(btn_noPushbutton).get(i));
			}

		}

		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		Assert.assertFalse(
				waitForElement(info_imgfinalised).getAttribute("class")
						.equalsIgnoreCase("complete"),
				"ERROR: AWB not finalized");
		return this;
	}

	/***
	 * 
	 * @param prefix
	 * @param awbno
	 * @return
	 */

	public CRA212 verifyVoided(String prefix, String awbno) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();

		Assert.assertTrue(
				waitForElement(info_voidedStatusSpan).getAttribute("span")
						.contains(" Voided"), "ERROR:Voided Status not stamped");

		return this;
	}

	/****
	 * 
	 * @param prefix
	 * @param awbno
	 * @return
	 */

	public CRA212 changeIATACharge(String prefix, String awbno, String fltDate,
			String carriercode, String flightno) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltDate = PropertyHandler.getPropValue(dataFilePath, fltDate);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		flightno = PropertyHandler.getPropValue(dataFilePath, flightno);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();

		click(Lnk_updateRatingLink);

		driver.switchTo().defaultContent();

		String tmpIATA = waitForElement(txt_rateingAuditedIataCharge)
				.getAttribute("value");
		int iata = Integer.parseInt(tmpIATA);
		iata = iata - 200;

		String itataTmp = new Integer(iata).toString();
		enterKeys(txt_rateingAuditedIataCharge, itataTmp);

		click(btn_OKchargePopup);
		click(btn_btnAWBRouting);
		minWait();
		// driver.switchTo().defaultContent();
		enterKeys(text_AWBRoutingflightCarrierCode, carriercode);
		enterKeys(text_AWBRoutingflightDate, fltDate);
		enterKeys(text_AWBRoutingflightNumber, flightno);
		click(btn_AWBRoutingbtnSave);
		minWait();
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_AWBRoutingbtnClose);
		minWait();
		// driver.switchTo().defaultContent();
		click(btn_btnRateAudited);
		minWait();
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_noPushbutton)) {

			List<WebElement> listElement1;
			listElement1 = getWebElements(btn_noPushbutton);
			int count1 = listElement1.size();
			for (int i = 1; i <= count1; i++) {
				click(getWebElements(btn_noPushbutton).get(i));
			}

		}

		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(btn_proceedbtn)) {

				click(btn_proceedbtn);

			}
			break;
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		// driver.switchTo().defaultContent();
		/*
		 * String
		 * status1=waitForElement(info_imgfinalised).getAttribute("class");
		 * System.out.println("Finalized status:"+status1);
		 */
		Assert.assertFalse(
				waitForElement(info_imgfinalised).getAttribute("class")
						.equalsIgnoreCase("complete"),
				"ERROR: AWB not finalized");

		return this;
	}

	/**
	 * 
	 * @param prefix
	 * @param awbno
	 * @param OutBoundFop
	 * @return
	 */
	public CRA212 CheckOutboundCust(String prefix, String awbno,
			String OutBoundFop) {

		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		OutBoundFop = PropertyHandler.getPropValue(dataFilePath, OutBoundFop);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();
		String Fop = waitForElementVisible(text_outBoundFoP).getAttribute(
				"value");
		System.out.println("Outbound Fop=" + Fop);
		Assert.assertTrue(Fop.contains(OutBoundFop),
				"ERROR: Outbound Fop mismatch");
		return this;
	}

	public CRA212 validatePriamryAndSeccondaryProration(String prefix,
			String awbno, String flightnum) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		flightnum = PropertyHandler.getPropValue(dataFilePath, flightnum);

		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		click(btn_btnList);
		minWait();

		// boolean flag=verifyValuePresentInTblColumn(tableAwbRoutingDetails, 7,
		// flightnum);
		// Assert.assertTrue(flag,
		// "flight number should be the prorated for the AWB");

		click(btn_expand);
		minWait();
		String primaryFltNo = waitForElement(label_primaryproratedAirline)
				.getText();
		String secondaryFltNo = waitForElement(label_secondaryProratedAirline)
				.getText();

		Assert.assertTrue(primaryFltNo.contains(flightnum),
				"primary proration should contain flight number");
		Assert.assertTrue(secondaryFltNo.contains(flightnum),
				"Secondary proration should contain flight number");

		return this;
	}

	public HomePage close() {

		click(btn_btnClose);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		return new HomePage(driver, dataFileName);
	}

	/**
	 * Method to list an AWB, Rate Audit and finalize is done
	 * 
	 * @author Shalini 03/01/2019
	 */
	public CRA212 RateAuditAndFinalize(String prefix, String awbno) {
		InitialSetup.test.log(LogStatus.INFO, "Started with the Rate Audit");
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		enterKeys(text_shipmentPrefix, prefix);
		enterKeys(text_documentNumber, awbno);
		enterKeys(By.name("ownerCode"),"AA");
		maxWait();
		maxWait();
		click(btn_btnList);
//		enterKeys(btn_btnList, Keys.F12);
		InitialSetup.test.log(LogStatus.INFO, "AWB: "+prefix+"-"+awbno+" has been listed");
		maxWait();
		driver.switchTo().defaultContent();
		if(verifyElementVisible(By.xpath("//p[contains(text(),'error')]"))){
			InitialSetup.test.log(LogStatus.FAIL, "The following error occured : "+driver.findElement(By.xpath("//p[contains(text(),'error')]")).getText());
			Assert.fail("The following error occured : "+driver.findElement(By.xpath("//p[contains(text(),'error')]")).getText());
		}
		if(verifyElementVisible(yesBtn))
		{
		click(yesBtn);  //click(generic_Yes); to import AWB in CRA
		}
		waitForFrameAndSwitch(screenFrame);
		maxWait();
		click(btn_btnRateAudited);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(Popup_Nobtn)) 
		{
		click(Popup_Nobtn);
		minWait();
		click(btn_proceedbtn);
		minWait();
		waitForFrameAndSwitch(screenFrame);
		} 
		else
		waitForFrameAndSwitch(screenFrame);
		InitialSetup.test.log(LogStatus.INFO, "Clicked on Rate Audited");
		click(btn_btnFinalize);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(btn_proceedbtn)){
			click(btn_proceedbtn);
		}
		waitForFrameAndSwitch(screenFrame);
		InitialSetup.test.log(LogStatus.INFO, "Clicked on Finalize");
		minWait();
		String actualvalue=driver.findElement(By.xpath("(//div[@id='overviewBar']//ol//li)[3]")).getAttribute("class");
		if(actualvalue.trim().toLowerCase().equals("complete")){
		InitialSetup.test.log(LogStatus.PASS, "Rate Audit passed with status of finalization as : "+actualvalue);
		captureAndAddScreenshot();
		}
		else
		{
		InitialSetup.test.log(LogStatus.FAIL, "Rate Audit failed with status of finalization as : "+actualvalue);
		Assert.fail("Rate Audit failed with status of finalization as : "+actualvalue);
		System.out.println("fail");
		}
		return this;

	}
}
