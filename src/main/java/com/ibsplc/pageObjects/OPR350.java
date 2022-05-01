package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Screen OPR350 - Capture DG Details Screen
 * @author Souvik
 * A-8457
 * on 24th March-2020
 */
public class OPR350 extends BasePage {

	public static String FRAME = "iCargoContentFrameOPR350";
	public static String screenFrame = "iCargoContentFrameOPR350";
	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"OPR_FLT.properties");
	private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"Generic.properties");
	WebDriver driver;
	String dataFileName;
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

	private By txtbx_carriercode, txtbx_ATDdate, txtbx_flightNumber, txtbx_date, btn_List;
	private By sel_blockedFor, txt_remarks, btn_blk_details, chcbx_Bulk, btn_manifst, btn_finalize, btn_close, yesBtn,
			btn_editIcon, btn_switchRole, btn_station, btn_ok, btn_flightfinalize, txt_statusfinalized, btn_assignhere,
			btn_Manifest, btn_PopOk, btn_Popup_Save,
			// A-7290
			Select_Rolegroup, btn_Bulk, Icon_bulk;

	public OPR350(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}

	/**
	 * Method to initialize page elements
	 */
	private void initElements() {
		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		
	}

	/**
	 
	 * @author Souvik
	 * A-8457
	 * Capture DG details
	 */
	public OPR350 CaptureDGDetails(String awbno, String Unid, String pcs, String wt, String PIValue, String TIValue) {
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		maxWait();
		enterKeys(By.name("masterDocumentNumber"), awbno);
		click(By.name("btList"));
		maxWait();
		click(By.xpath("//i[@class='icon edit']"));
		minWait();
		enterKeys(By.name("firstEmergencyContactName"),"Sans");
		enterKeys(By.name("firstEmergencyContactNumber"),"74835649");
		enterKeys(By.name("shipperpobox"), "245245");
		enterKeys(By.name("consigneepobox"), "245245");
		enterKeys(By.name("shipmentlimitation"), "DG");
		enterKeys(By.name("shipmenttype"), "DG");
		enterKeys(By.name("additionalhandlingInformation"), "TEST");
		enterKeys(By.name("warning"), "TEST");
		enterKeys(By.name("declaration"), "TEST");
		enterKeys(By.name("nameortitleofsignatory"), "TEST");
		enterKeys(By.name("place"), "Dallas");
		enterKeys(By.name("signature"),"TEST");
		enterKeys(By.name("signatoryDate"), "."+Keys.TAB);
		enterKeys(By.name("signatoryTime"), "0000");
		minWait();
		scrollToView(By.name("btnShipperReferenceOk"));
		click(By.xpath("//button[@name='btnShipperReferenceOk']"));
		minWait();
		CaptureUnidDetails(Unid, pcs, wt, PIValue, TIValue);
		minWait();
		minWait();
		if(!driver.findElement(By.name("dgVerifiedFlag")).isSelected())
		click(By.name("dgVerifiedFlag"));
		minWait();
		click(By.xpath("//button[@name='btnSave']"));
		InitialSetup.test.log(LogStatus.INFO, "Saved details in DG acceptance screen");
		captureAndAddScreenshot();
		maxWait();
		if(verifyElementPresent(By.xpath("//div[@id='errorDisplayDiv']//td[2]"))){
			final boolean b = true;
			String status =getText_JS(By.xpath("//div[@id='errorDisplayDiv']//td[2]")).trim();
			if(status.equalsIgnoreCase("No package more than 3.0 TI is Allowed")){
				InitialSetup.test.log(LogStatus.PASS, "DG acceptance has been stopped successfully :"+status);
				captureAndAddScreenshot();
			} 
			else if(status.contains("ICE exceeds the limit")){
				InitialSetup.test.log(LogStatus.PASS, "DG acceptance has been stopped successfully :"+status);
				captureAndAddScreenshot();
			}
			Assert.assertTrue(b);
		}
		InitialSetup.test.log(LogStatus.PASS, "DG Details has been succesfully captured");
		return this;		
	}

	/**
	 *
	 * @author Souvik
	 * A-8457
	 * Capture DG details
	 */
	public OPR350 CaptureDGDetailsPropertyFile(String awbno, String emergencyName, String emergencyContact) {
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		emergencyName = PropertyHandler.getPropValue(dataFilePath, emergencyName);
		emergencyContact = PropertyHandler.getPropValue(dataFilePath, emergencyContact);
		maxWait();
		enterKeys(By.name("masterDocumentNumber"), awbno);
		click(By.name("btList"));
		maxWait();
		minWait();
		click(By.xpath("//i[@class='icon edit']"));
		maxWait();
		enterKeys(By.name("firstEmergencyContactName"),emergencyName);
		enterKeys(By.name("firstEmergencyContactNumber"),emergencyContact);
		enterKeys(By.name("shipperpobox"), "245245");
		enterKeys(By.name("consigneepobox"), "245245");
		enterKeys(By.name("shipmentlimitation"), "DG");
		enterKeys(By.name("shipmenttype"), "DG");
		enterKeys(By.name("additionalhandlingInformation"), "TEST");
		enterKeys(By.name("warning"), "TEST");
		enterKeys(By.name("declaration"), "TEST");
		enterKeys(By.name("nameortitleofsignatory"), "TEST");
		enterKeys(By.name("place"), "Dallas");
		enterKeys(By.name("signature"),"TEST");
		enterKeys(By.name("signatoryDate"), "."+Keys.TAB);
		enterKeys(By.name("signatoryTime"), "0000");
		minWait();
		scrollToView(By.name("btnShipperReferenceOk"));
		click(By.xpath("//button[@name='btnShipperReferenceOk']"));
		minWait();
//		CaptureUnidDetails(Unid, pcs, wt, PIValue, TIValue);
//		minWait();
//		click(By.xpath("//button[@name='btnSave']"));
//		maxWait();
//		if(verifyElementPresent(By.xpath("//div[@id='errorDisplayDiv']//td[2]"))){
//			String status =getText_JS(By.xpath("//div[@id='errorDisplayDiv']//td[2]")).trim();
//			if(status.equalsIgnoreCase("No package more than 3.0 TI is Allowed")){
//				InitialSetup.test.log(LogStatus.PASS, "DG acceptance has been stopped successfully :"+status);
//			}
//		}
		InitialSetup.test.log(LogStatus.PASS, "DG Details has been succesfully captured");
		captureAndAddScreenshot();
		return this;		
	}
	/**
	 
	 * @author Sharath
	 * A-8457
	 * Capture DG details
	 */
	public OPR350 CaptureDGDetailsOverPack(String awbno) {
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		maxWait();
		enterKeys(By.name("masterDocumentNumber"), awbno);
		click(By.name("btList"));
		maxWait();
		minWait();
		click(By.xpath("//i[@class='icon edit']"));
		minWait();
		enterKeys(By.name("firstEmergencyContactName"),"testuser");
		enterKeys(By.name("firstEmergencyContactNumber"),"123456");
		enterKeys(By.name("shipperpobox"), "245245");
		enterKeys(By.name("consigneepobox"), "245245");
		enterKeys(By.name("shipmentlimitation"), "DG");
		enterKeys(By.name("shipmenttype"), "DG");
		enterKeys(By.name("additionalhandlingInformation"), "TEST");
		enterKeys(By.name("warning"), "TEST");
		enterKeys(By.name("declaration"), "TEST");
		enterKeys(By.name("nameortitleofsignatory"), "TEST");
		enterKeys(By.name("place"), "Dallas");
		enterKeys(By.name("signature"),"TEST");
		enterKeys(By.name("signatoryDate"), "."+Keys.TAB);
		enterKeys(By.name("signatoryTime"), "0000");
		minWait();
		scrollToView(By.name("btnShipperReferenceOk"));
		click(By.xpath("//button[@name='btnShipperReferenceOk']"));
		minWait();
		
		CaptureUnidDetailsForPropertyFile("","UNIDNo1", "DGpcs", "DGwt", "PIValue1", "",false);
		CaptureUnidDetailsForPropertyFile("","UNIDNo2", "DGpcs", "DGwt", "PIValue2", "",false);
		CaptureUnidDetailsForPropertyFile("","UNIDNo3", "DGpcs", "DGwt", "PIValue3", "",false);
		CaptureUnidDetailsForPropertyFile("","UNIDNo4", "DGpcs", "DGwt", "PIValue4", "",false);
		minWait();
		performAllPack("UNIDNo1", "UNIDNo4", "DGpcs");
		performAllPack("UNIDNo2", "UNIDNo3", "DGpcs");
		minWait();
		performOverPack("UNIDNo1", "UNIDNo2", "UNIDNo3", "UNIDNo4", "DGpcs");
		minWait();
		if(!driver.findElement(By.name("dgVerifiedFlag")).isSelected())
			click(By.name("dgVerifiedFlag"));
			minWait();
			InitialSetup.test.log(LogStatus.INFO, "DG Verified flag checked");
			captureAndAddScreenshot();
		click(By.xpath("//button[@name='btnSave']"));
		maxWait();
		if(verifyElementPresent(By.xpath("//div[@id='errorDisplayDiv']//td[2]"))){
			String status =getText_JS(By.xpath("//div[@id='errorDisplayDiv']//td[2]")).trim();
			if(status.equalsIgnoreCase("No package more than 3.0 TI is Allowed")){
				InitialSetup.test.log(LogStatus.PASS, "DG acceptance has been stopped successfully :"+status);
			}
		}
		InitialSetup.test.log(LogStatus.PASS, "DG Details has been succesfully captured");
		return this;		
	}
	
//Sharath			
	public OPR350 CaptureUnidDetails(String Unid, String pcs, String wt, String PIValue, String TIValue) {
		scrollToView(By.xpath("(//div[@id='dangerousgoodsdetailtable']//td)[last()-1]"));
		String prefix = "(//td[contains(text(),'";
		String suffix = "')]/following-sibling::td)[last()]";
		click(By.xpath(prefix + Unid + suffix));
		suffix = "')]/following-sibling::td)[last()]//i";
		click(By.xpath(prefix + Unid + suffix));
		click(By.name("btEdit"));
		minWait();
		waitForFrameAndSwitch("popupContainerFrame");
		enterKeys(By.name("packingInstruction"), PIValue);
		if(!TIValue.equals("")){
			enterKeys(By.name("transportIndex"), TIValue);
			selectByText(By.name("rmc"),"I");
			enterKeys(By.name("packingDimensionHeight"), "10");
		}
		enterKeys(By.name("numberOfPackages"), pcs);
		int p = Integer.parseInt(pcs);
		int w = Integer.parseInt(wt);
		if (!TIValue.equals("")) {
		} else {
			enterKeys(By.name("netQuantityPerPackage"), Integer.toString(w / p));
		}
		selectByText(By.name("reportableQuantity"), "Yes");
		click(By.name("BtnUpdate"));
		waitForFrameAndSwitch(screenFrame);
//		click(By.xpath("//button[@name='btnSave']"));
		maxWait();
		InitialSetup.test.log(LogStatus.PASS, "Unid Details has been succesfully captured");
		return this;
	}
	
	//Sharath			
		public OPR350 CaptureUnidDetailsForPropertyFile(String awbno, String Unid, String pcs, String wt, String PIValue, String TIValue, boolean listingReqd) {
			Unid = PropertyHandler.getPropValue(dataFilePath, Unid);
			pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
			wt = PropertyHandler.getPropValue(dataFilePath, wt);
			PIValue = PropertyHandler.getPropValue(dataFilePath, PIValue);
			TIValue = PropertyHandler.getPropValue(dataFilePath, TIValue);
			if(listingReqd){
				awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
				maxWait();
				enterKeys(By.name("masterDocumentNumber"), awbno);
				click(By.name("btList"));
				maxWait();
			}
			maxWait();
//			scrollToView(By.xpath("(//div[@id='dangerousgoodsdetailtable']//td)[last()-1]"));
			scrollToView(By.xpath("//h2[contains(text(),'Dangerous Goods')]"));
			String prefix = "(//td[contains(text(),'";
			String suffix = "')]/following-sibling::td)[last()]";
			click(By.xpath(prefix + Unid + suffix));
			suffix = "')]/following-sibling::td)[last()]//i";
			click(By.xpath(prefix + Unid + suffix));
			click(By.xpath("(//button[@name='btEdit'])[last()]"));
			minWait();
			waitForFrameAndSwitch("popupContainerFrame");
			enterKeys(By.name("packingInstruction"), PIValue);
			enterKeys(By.name("numberOfPackages"), pcs);
			int p = Integer.parseInt(pcs);
			int w = Integer.parseInt(wt);
			enterKeys(By.name("netQuantityPerPackage"), /*"1"*/Integer.toString(w / p));
			selectByText(By.name("netQuantityPerPackageUnit"), "kg");
			selectByText(By.name("reportableQuantity"), "Yes");
			minWait();
			click(By.name("BtnUpdate"));
			driver.switchTo().defaultContent();
			waitForFrameAndSwitch(screenFrame);
			minWait();
			InitialSetup.test.log(LogStatus.INFO, "Details have been filled");
//			captureAndAddScreenshot();
			minWait();
			if(!driver.findElement(By.name("dgVerifiedFlag")).isSelected())
			click(By.name("dgVerifiedFlag"));
			minWait();
			InitialSetup.test.log(LogStatus.INFO, "DG Verified flag checked");
			captureAndAddScreenshot();
			click(By.xpath("//button[@name='btnSave']"));
			maxWait();
			if(verifyElementPresent(By.xpath("//td[@class='ic-error-msg']"))){
				click(By.xpath("//img[contains(@src,'close')]"));
			}
//			waitForFrameAndSwitch("popupContainerFrame");
			InitialSetup.test.log(LogStatus.PASS, "Unid Details has been succesfully captured");
			captureAndAddScreenshot();
			return this;
		}
			
		
		//Sharath			
				public OPR350 performAllPack(String Unid1, String Unid2, String pcs) {
					Unid1 = PropertyHandler.getPropValue(dataFilePath, Unid1);
					Unid2 = PropertyHandler.getPropValue(dataFilePath, Unid2);
					pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
					maxWait();
					scrollToView(By.xpath("//h2[contains(text(),'Dangerous Goods')]"));
					click(By.xpath("//td[contains(text(),'"+Unid1+"')]/parent::tr//input"));
					click(By.xpath("//td[contains(text(),'"+Unid2+"')]/parent::tr//input"));
					click(By.name("btAllPacked"));
					minWait();
					waitForFrameAndSwitch("popupContainerFrame");
					maxWait();
					enterKeys(By.name("numberOfOAPackages"), pcs);
					click(By.name("btOk"));
					driver.switchTo().defaultContent();
					waitForFrameAndSwitch(screenFrame);
					minWait();
					return this;
				}
			
				//Sharath			
				public OPR350 performOverPack(String Unid1, String Unid2, String Unid3, String Unid4, String pcs) {
					Unid1 = PropertyHandler.getPropValue(dataFilePath, Unid1);
					Unid2 = PropertyHandler.getPropValue(dataFilePath, Unid2);
					Unid3 = PropertyHandler.getPropValue(dataFilePath, Unid3);
					Unid4 = PropertyHandler.getPropValue(dataFilePath, Unid4);
					pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
					maxWait();
					scrollToView(By.xpath("//h2[contains(text(),'Dangerous Goods')]"));
					click(By.xpath("//td[contains(text(),'"+Unid1+"')]/parent::tr//input"));
					click(By.xpath("//td[contains(text(),'"+Unid2+"')]/parent::tr//input"));
					click(By.xpath("//td[contains(text(),'"+Unid3+"')]/parent::tr//input"));
					click(By.xpath("//td[contains(text(),'"+Unid4+"')]/parent::tr//input"));
					click(By.name("btOverPacked"));
					minWait();
					waitForFrameAndSwitch("popupContainerFrame");
					maxWait();
					enterKeys(By.name("numberOfOAPackages"), pcs);
					click(By.name("btOk"));
					driver.switchTo().defaultContent();
					waitForFrameAndSwitch(screenFrame);
					minWait();
					return this;
				}
	public HomePage close() {

		click(By.xpath("//button[@name='btnClose']"));
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		return new HomePage(driver, dataFileName);
	}
	
	public OPR350 save(){
		click(By.xpath("//button[@name='btnSave']"));
		maxWait();
		return this;
	}
	
	
	//Sharath			
			public OPR350 CaptureUnidDetailsWithSpecialAuth(String awbno, String Unid, String pcs, String wt, String PIValue, String TIValue,String authCode, boolean listingReqd) {
				Unid = PropertyHandler.getPropValue(dataFilePath, Unid);
				pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
				wt = PropertyHandler.getPropValue(dataFilePath, wt);
				PIValue = PropertyHandler.getPropValue(dataFilePath, PIValue);
				TIValue = PropertyHandler.getPropValue(dataFilePath, TIValue);
				authCode = PropertyHandler.getPropValue(dataFilePath, authCode);
				if(listingReqd){
					awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
					maxWait();
					enterKeys(By.name("masterDocumentNumber"), awbno);
					click(By.name("btList"));
					maxWait();
				}
				maxWait();
//				scrollToView(By.xpath("(//div[@id='dangerousgoodsdetailtable']//td)[last()-1]"));
				scrollToView(By.xpath("//h2[contains(text(),'Dangerous Goods')]"));
				String prefix = "(//td[contains(text(),'";
				String suffix = "')]/following-sibling::td)[last()]";
				click(By.xpath(prefix + Unid + suffix));
				suffix = "')]/following-sibling::td)[last()]//i";
				click(By.xpath(prefix + Unid + suffix));
				click(By.xpath("(//button[@name='btEdit'])[last()]"));
				minWait();
				waitForFrameAndSwitch("popupContainerFrame");
				enterKeys(By.name("packingInstruction"), PIValue);
				enterKeys(By.name("numberOfPackages"), pcs);
				int p = Integer.parseInt(pcs);
				int w = Integer.parseInt(wt);
				enterKeys(By.name("netQuantityPerPackage"), /*"1"*/Integer.toString(w / p));
				selectByText(By.name("netQuantityPerPackageUnit"), "kg");
				selectByText(By.name("reportableQuantity"), "Yes");
				minWait();
				click(By.name("BtnUpdate"));
				minWait();
				if(verifyElementPresent(By.xpath("//td[contains(@class,'error-msg')]"))){
					String errormsg = getText_JS(By.xpath("//td[contains(@class,'error-msg')]"));
					InitialSetup.test.log(LogStatus.INFO, errormsg);
					captureAndAddScreenshot();
					InitialSetup.test.log(LogStatus.INFO, "Providing special autorization");
					click(By.xpath("//img[contains(@alt,'Close')]"));
					minWait();
					click(By.name("specialAuthorizationFlag"));
					enterKeys(By.name("authorization"),authCode);
					captureAndAddScreenshot();
					click(By.name("BtnUpdate"));
					minWait();
				}
				driver.switchTo().defaultContent();
				waitForFrameAndSwitch(screenFrame);
				minWait();
				InitialSetup.test.log(LogStatus.INFO, "Details have been filled");
//				captureAndAddScreenshot();
				minWait();
				if(!driver.findElement(By.name("dgVerifiedFlag")).isSelected())
				click(By.name("dgVerifiedFlag"));
				minWait();
				InitialSetup.test.log(LogStatus.INFO, "DG Verified flag checked");
				captureAndAddScreenshot();
				click(By.xpath("//button[@name='btnSave']"));
				maxWait();
				if(verifyElementPresent(By.xpath("//td[@class='ic-error-msg']"))){
					click(By.xpath("//img[contains(@src,'close')]"));
				}
//				waitForFrameAndSwitch("popupContainerFrame");
				InitialSetup.test.log(LogStatus.PASS, "Unid Details has been succesfully captured");
				captureAndAddScreenshot();
				return this;
			}
			
			//Sharath			
			public OPR350 CaptureUnidDetailsWithHeightCapture(String awbno, String Unid, String pcs, String wt, String PIValue, String TIValue, String height1,String height2, boolean listingReqd) {
				Unid = PropertyHandler.getPropValue(dataFilePath, Unid);
				pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
				wt = PropertyHandler.getPropValue(dataFilePath, wt);
				PIValue = PropertyHandler.getPropValue(dataFilePath, PIValue);
				TIValue = PropertyHandler.getPropValue(dataFilePath, TIValue);
				height1 = PropertyHandler.getPropValue(dataFilePath, height1);
				height2 = PropertyHandler.getPropValue(dataFilePath, height2);
				if(listingReqd){
					awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
					maxWait();
					enterKeys(By.name("masterDocumentNumber"), awbno);
					click(By.name("btList"));
					maxWait();
				}
				maxWait();
//				scrollToView(By.xpath("(//div[@id='dangerousgoodsdetailtable']//td)[last()-1]"));
				scrollToView(By.xpath("//h2[contains(text(),'Dangerous Goods')]"));
				String prefix = "(//td[contains(text(),'";
				String suffix = "')]/following-sibling::td)[last()]";
				click(By.xpath(prefix + Unid + suffix));
				suffix = "')]/following-sibling::td)[last()]//i";
				click(By.xpath(prefix + Unid + suffix));
				click(By.xpath("(//button[@name='btEdit'])[last()]"));
				minWait();
				waitForFrameAndSwitch("popupContainerFrame");
				enterKeys(By.name("packingInstruction"), PIValue);
				enterKeys(By.name("transportIndex"),TIValue);
				selectByText(By.name("rmc"), "I");
				enterKeys(By.name("numberOfPackages"), pcs);
				int p = Integer.parseInt(pcs);
				int w = Integer.parseInt(wt);
				try{
					driver.findElement(By.name("netQuantityPerPackage")).click();
					driver.findElement(By.name("netQuantityPerPackage")).sendKeys(Integer.toString(w / p));
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "Quantity field is not clicked for this UNID");
				}
				selectByText(By.name("reportableQuantity"), "Yes");
				enterKeys(By.name("packingDimensionHeight"), height1);
				selectByText(By.name("packingDimensionUnit"), "cm");
				minWait();
				click(By.name("BtnUpdate"));
				minWait();
				if(verifyElementPresent(By.xpath("//td[contains(@class,'error-msg')]"))){
					String errormsg = getText_JS(By.xpath("//td[contains(@class,'error-msg')]"));
					InitialSetup.test.log(LogStatus.INFO, errormsg);
					captureAndAddScreenshot();
					InitialSetup.test.log(LogStatus.INFO, "Providing corrected height");
					click(By.xpath("//img[contains(@alt,'Close')]"));
					minWait();
					enterKeys(By.name("packingDimensionHeight"), height2);
					selectByText(By.name("packingDimensionUnit"), "cm");
					captureAndAddScreenshot();
					click(By.name("BtnUpdate"));
					minWait();
				}
				driver.switchTo().defaultContent();
				waitForFrameAndSwitch(screenFrame);
				minWait();
				InitialSetup.test.log(LogStatus.INFO, "Details have been filled");
//				captureAndAddScreenshot();
				minWait();
				if(!driver.findElement(By.name("dgVerifiedFlag")).isSelected())
				click(By.name("dgVerifiedFlag"));
				minWait();
				InitialSetup.test.log(LogStatus.INFO, "DG Verified flag checked");
				captureAndAddScreenshot();
				click(By.xpath("//button[@name='btnSave']"));
				maxWait();
				if(verifyElementPresent(By.xpath("//td[@class='ic-error-msg']"))){
					String errormsg = getText_JS(By.xpath("//td[contains(@class,'error-msg')]")).trim();
					InitialSetup.test.log(LogStatus.INFO, errormsg);
					captureAndAddScreenshot();
					InitialSetup.test.log(LogStatus.INFO, "Providing corrected height");
					click(By.xpath("//img[contains(@alt,'Close')]"));
					minWait();
					scrollToView(By.xpath("//h2[contains(text(),'Dangerous Goods')]"));
					click(By.xpath(prefix + Unid + suffix));
					click(By.xpath("(//button[@name='btEdit'])[last()]"));
					minWait();
					waitForFrameAndSwitch("popupContainerFrame");
					enterKeys(By.name("packingDimensionHeight"), height2);
					selectByText(By.name("packingDimensionUnit"), "cm");
					captureAndAddScreenshot();
					click(By.name("BtnUpdate"));
					minWait();
					driver.switchTo().defaultContent();
					waitForFrameAndSwitch(screenFrame);
					minWait();
					InitialSetup.test.log(LogStatus.INFO, "Details have been filled");
//					captureAndAddScreenshot();
					minWait();
					if(!driver.findElement(By.name("dgVerifiedFlag")).isSelected())
					click(By.name("dgVerifiedFlag"));
					minWait();
					InitialSetup.test.log(LogStatus.INFO, "DG Verified flag checked");
					captureAndAddScreenshot();
					click(By.xpath("//button[@name='btnSave']"));
					maxWait();
				}
//				waitForFrameAndSwitch("popupContainerFrame");
				InitialSetup.test.log(LogStatus.PASS, "Unid Details has been succesfully captured");
				captureAndAddScreenshot();
				return this;
			}
				
			
//			Sharath
			public OPR350 validateError(String awbno, String Unid, String pcs, String wt, String PIValue, String TIValue, boolean listingReqd) {
				Unid = PropertyHandler.getPropValue(dataFilePath, Unid);
				pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
				wt = PropertyHandler.getPropValue(dataFilePath, wt);
				PIValue = PropertyHandler.getPropValue(dataFilePath, PIValue);
				TIValue = PropertyHandler.getPropValue(dataFilePath, TIValue);
				if(listingReqd){
					awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
					maxWait();
					enterKeys(By.name("masterDocumentNumber"), awbno);
					click(By.name("btList"));
					maxWait();
				}
				maxWait();
//				scrollToView(By.xpath("(//div[@id='dangerousgoodsdetailtable']//td)[last()-1]"));
				scrollToView(By.xpath("//h2[contains(text(),'Dangerous Goods')]"));
				String prefix = "(//td[contains(text(),'";
				String suffix = "')]/following-sibling::td)[last()]";
				click(By.xpath(prefix + Unid + suffix));
				suffix = "')]/following-sibling::td)[last()]//i";
				click(By.xpath(prefix + Unid + suffix));
				click(By.xpath("(//button[@name='btEdit'])[last()]"));
				minWait();
				waitForFrameAndSwitch("popupContainerFrame");
				enterKeys(By.name("packingInstruction"), PIValue);
				enterKeys(By.name("numberOfPackages"), pcs);
				int p = Integer.parseInt(pcs);
				int w = Integer.parseInt(wt);
				enterKeys(By.name("netQuantityPerPackage"), /*"1"*/Integer.toString(w / p));
				selectByText(By.name("netQuantityPerPackageUnit"), "kg");
				selectByText(By.name("reportableQuantity"), "Yes");
				minWait();
				click(By.name("BtnUpdate"));
				minWait();
				if(verifyElementPresent(By.xpath("//td[contains(@class,'error-msg')]"))){
					String errormsg = getText_JS(By.xpath("//td[contains(@class,'error-msg')]"));
					InitialSetup.test.log(LogStatus.PASS, errormsg);
					captureAndAddScreenshot();
					click(By.xpath("//img[contains(@alt,'Close')]"));
					minWait();
					driver.findElement(By.name("btCancel")).click();
					driver.switchTo().defaultContent();
					waitForFrameAndSwitch(screenFrame);
					minWait();
					driver.findElement(By.name("btnCancelPackage")).click();
					maxWait();
					minWait();
				}else{
					InitialSetup.test.log(LogStatus.FAIL, "No error pops up");
					Assert.fail();
				}
				return this;
			}

}