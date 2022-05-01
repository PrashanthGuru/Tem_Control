package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.ibsplc.common.BaseSetup;
import com.ibsplc.generic.Generic;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.pageObjects.HomePage;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/**
 * Module : Regression
 * 
 * @author Sharath on 03-01-2019 Description capture and Acceptance
 **/
public class Flow01_TCActiveFlow extends BaseSetup {

	HomePage home = null;
	public static final String messagePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"selenium.sample.message.path");

	@Given("^Login to Application and switch role for TCActiveFow$")
	public void navigateAndLogin() throws Throwable {
		String classname = this.getClass().getName();
		String[] ClassName = classname.split("\\.");
		BaseSetup.test = BaseSetup.extent.startTest(ClassName[1]);
		InitialSetup init = new InitialSetup();
		WebDriver driver = init.InitialSetupMethod1();
		Generic gen = new Generic(driver, browserName, "Flow01.properties");
		String url = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("portalURL");
		if (url.contains("loginFlow") || url.contains("pss")) {
			home = gen.login("00247313");
		} 
		else
		{
			home = gen.login();
		}
	}

	@When("^perform TC Booking for Active in CAP018 screen for TCActiveFow$")
	public void booking() throws Throwable {
		InitialSetup.test.log(LogStatus.INFO, "-----------------------------------Starting test for TC Active Shipment----------------------");
		logger.info("-----------------------------------Starting test for TC Active Shipment----------------------");
	
		InitialSetup.test.log(LogStatus.INFO, "---------------------Started with booking---------------");
		logger.info("-----------------Started with booking-------------");
		
		home.SwitchRoleGroupParameter("origin", "CCOCFULL")
		.goToFLT002()
		.fetchFlightDetails()
		.close();
		
		home.SwitchRoleGroupParameter("origin", "CCOCFULL").goToCAP018()
				.enterInitialBookingDetailsforPropertyfile("origin", "dest", "agentCode", "Product", "pcs", "wt", "vol",
						"fltDt", "ULDType", "ULDwt", "commCode")
				.enterFlightDetailsforPropertyFile("origin", "dest", "fltDt", "carrierCode", "fltNo", 1)
				.captureTCDetailsPcs("wt", "origin", "fltDt", "pcs")
				.saveInCAP018AndVerifyUBRnStatusDirect("awbNo", "commCode")
				.close();
		
		InitialSetup.test.log(LogStatus.INFO, "---------------------Booking has been completed---------------");
		logger.info("-----------------Booking has been completed-------------");
	}

	@And("^perform capture AWB in OPR026 screen for TCActiveFow$")
	public void captureAWB() throws Exception {
		InitialSetup.test.log(LogStatus.INFO, "---------------------Started with capture AWB---------------");
		logger.info("-----------------Started with capture AWB-------------");
		
		home.SwitchRoleGroupParameter("origin", "OCTRAGT").goToOPR026()
		.ProcessExecuteafterBookingWithCheckSheet("prefix", "awbNo", "shipper", "consignee", "commCode")
		.close();
		
		InitialSetup.test.log(LogStatus.INFO, "---------------------Capture AWB has been completed---------------");
		logger.info("-----------------Capture AWB has been completed-------------");
	}
	
	@Then("^goods acceptance works fine for TCActiveFow$")
	public void acceptance() throws Exception {
		InitialSetup.test.log(LogStatus.INFO, "---------------------Started with acceptance---------------");
		logger.info("-----------------Started with acceptance-------------");
		
		home.SwitchRoleGroupParameter("origin", "OMGR")
		.goToOPR335()
		.processGoodsAcceptanceWithCheckSheetULD("prefix", "awbNo", "Location", "pcs", "wt", "screening_method", "commCode","uldNo")
		.close();
		
		InitialSetup.test.log(LogStatus.INFO, "---------------------Acceptance has been completed---------------");
		logger.info("-----------------Acceptance has been completed-------------");
    }
	
	@And("^capture TC details works fine for TCActiveFow$")
	public void captureTCDetails() throws Exception {
		
		InitialSetup.test.log(LogStatus.INFO, "---------------------Started with capturing TC details---------------");
		logger.info("-----------------Started with capturing TC details-------------");
		
		
		home.SwitchRoleGroupParameter("origin", "OMGR").goToOPR360()
		.CaptureTCDetailsULD("prefix", "awbNo", "uldNo")
		.verifyPrintTCDetails("prefix","awbNo",false)
		.close();
		
		InitialSetup.test.log(LogStatus.INFO, "---------------------Capture TC details has been completed---------------");
		logger.info("-----------------Capture TC details has been completed-------------");
    }
	
}