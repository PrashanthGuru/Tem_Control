package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class TRF006 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");

    public static String filepath;

    public static String FRAME = "iCargoContentFrameTRF006";

    By txt_rateid,
            btn_status,
            ratecard_select,
            dropdown_status,
            btn_save,
            btn_close,
            yesBtn,
            info_Status,
            noBtn,
            btn_clear,
            btn_closeChangeStatuspopup,
            btn_list;

    WebDriver driver;
    String testDataFile;

    public TRF006(WebDriver driver, String testDataFile) {
        super(driver);
        this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver, this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + testDataFile;
        initPageElements();
    }


    private void initPageElements() {
        txt_rateid = MiscUtility.getWebElement(objFilepath, "TRF006_txt_rateid");
        btn_list = MiscUtility.getWebElement(objFilepath, "TRF006_btn_list");
        btn_status = MiscUtility.getWebElement(objFilepath, "TRF006_btn_status");
        ratecard_select = MiscUtility.getWebElement(objFilepath, "TRF006_ratecard_select");
        dropdown_status = MiscUtility.getWebElement(objFilepath, "TRF006_dropdown_status");
        btn_save = MiscUtility.getWebElement(objFilepath, "TRF006_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath, "TRF006_btn_close");
        btn_closeChangeStatuspopup = MiscUtility.getWebElement(objFilepath, "TRF006_btn_closeChangeStatuspopup");
        info_Status = MiscUtility.getWebElement(objFilepath, "TRF006_info_status");
        btn_clear = MiscUtility.getWebElement(objFilepath, "TRF006_btn_clear");
        yesBtn = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
        noBtn = MiscUtility.getWebElement(genFilepath, "Generic_btn_noBtn");

    }


    /***
     *
     * @param rateid
     * @param status (Active/Inactive)
     * @return
     */

    public TRF006 changeStatus(String rateid, String status, boolean isChange)    //,String iata2,String charge2,String chargen)
    {
        String data_rateid = PropertyHandler.getPropValue(filepath, rateid);


        enterKeys(txt_rateid, data_rateid);

        click(btn_list);

        check(ratecard_select);
        click(btn_status);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch(FRAME);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();
        selectByText(dropdown_status, status);
        click(btn_save);
        minWait();

        if (getNumberOfWindows() == 2 && verifyElementPresent(yesBtn)) {
            driver.switchTo().defaultContent();
            if (verifyElementPresent(yesBtn)) {

                if (isChange == true) {

                    click(yesBtn);
                } else {
                    click(noBtn);
                    click(btn_closeChangeStatuspopup);
                    minWait();
                }
            }
        }
        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);

        click(btn_clear);

        minWait();
        return this;

    }

    private int getWindowHandles() {
        // TODO Auto-generated method stub
        return 0;
    }


    public TRF006 cancel(String rateid,String status){
		{
			String rand_rateid = PropertyHandler.getPropValue(filepath,rateid);
			
			//String data_status1 = PropertyHandler.getPropValue(dataFilePath,status1);
			
			
			
			enterKeys(txt_rateid,rand_rateid);
			
			click(btn_list);
		
			check(ratecard_select);
			click(btn_status);
			driver.switchTo().defaultContent();
		    if (verifyElementPresent(yesBtn)) {

		        click(yesBtn);
		    }
			 driver.switchTo().defaultContent();
		    waitForNewWindow(2);
		    switchToSecondWindow();
			selectByText(dropdown_status, "Cancelled");
			click(btn_save);
			 minWait();
			
			 click(yesBtn);
			 
		        switchToFirstWindow();

		        waitForFrameAndSwitch(FRAME);
			
			
			return this;
			
	}
		}


    public TRF006 verifyStatus(String rateid, String status) {

        String rand_rateid = PropertyHandler.getPropValue(filepath, rateid);

        enterKeys(txt_rateid, rand_rateid);

        click(btn_list);
        minWait();
        //Assert.assertTrue(waitForElement(button_diaOk).isDisplayed(), "ERROR : Schedule Burst Successful message not shown.");
        waitForElement(info_Status).getText().contains(status);
        click(btn_clear);
        return this;
    }

    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, testDataFile);
    }
}

