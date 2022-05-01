package com.ibsplc.pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


public class ADM032 extends BasePage {
    private final static Logger logger = Logger.getLogger(ADM032.class);
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameADM032";
    By

            dropdown_JobName,
            txt_dateFrom,
            txt_dateTo,
            dropdown_schedulestatus,
            Tbl_JobScheduleDetails,
            btn_List,
            info_jobStatus,
            chkbox_SelectSchedule,
            btn_Stop,
            btn_close,
            txt_nextOccuranceDate,
            btn_Modify,
            txt_NextOccuranceTime,
            info_Status,
            btn_saveModify,
            btn_CloseModify,
            btn_clear;
    WebDriver driver;
    String screenFrame;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    public ADM032(WebDriver driver, String dataFileName) {

        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {
        dropdown_JobName = MiscUtility.getWebElement(objFilepath, "ADM032_dropdown_JobName");
        txt_dateFrom = MiscUtility.getWebElement(objFilepath, "ADM032_txt_dateFrom");
        txt_dateTo = MiscUtility.getWebElement(objFilepath, "ADM032_txt_dateTo");
        btn_List = MiscUtility.getWebElement(objFilepath, "ADM032_btn_List");
        info_jobStatus = MiscUtility.getWebElement(objFilepath, "ADM032_info_jobStatus");
        btn_close = MiscUtility.getWebElement(objFilepath, "ADM032_btn_close");
        btn_clear = MiscUtility.getWebElement(objFilepath, "ADM032_btn_clear");
        Tbl_JobScheduleDetails = MiscUtility.getWebElement(objFilepath, "ADM032_Tbl_JobScheduleDetails");
        dropdown_schedulestatus = MiscUtility.getWebElement(objFilepath, "ADM032_dropdown_schedulestatus");
        btn_Stop = MiscUtility.getWebElement(objFilepath, "ADM032_btn_Stop");
        chkbox_SelectSchedule = MiscUtility.getWebElement(objFilepath, "ADM032_chkbox_SelectSchedule");
        btn_Modify = MiscUtility.getWebElement(objFilepath, "ADM032_btn_Modify");
        txt_nextOccuranceDate = MiscUtility.getWebElement(objFilepath, "ADM032_txt_nextOccuranceDate");
        txt_NextOccuranceTime = MiscUtility.getWebElement(objFilepath, "ADM032_txt_NextOccuranceTime");
        info_Status = MiscUtility.getWebElement(objFilepath, "ADM032_info_Status");
        btn_saveModify = MiscUtility.getWebElement(objFilepath, "ADM032_btn_saveModify");
        btn_CloseModify = MiscUtility.getWebElement(objFilepath, "ADM032_btn_CloseModify");


    }

    /**
     * CheckStatus Active and wait until completed
     * <p>
     * Method to check status Active and wait until completed
     * on 03/1/2018
     *
     * @param JobName,status
     * @return Author A-6784
     **/

    public ADM032 CheckStatusAndWait(String key_jobName) {

        String jobName = PropertyHandler.getPropValue(dataFilePath, key_jobName);
        selectByText(dropdown_JobName, jobName);
        minWait();
        enterKeys(txt_dateFrom, ".");
        enterKeys(txt_dateTo, "." + Keys.TAB);
        selectByText(dropdown_schedulestatus, "Active");
        click(btn_List);
        minWait();
        // driver.switchTo().defaultContent();
        String status = waitForElement(info_jobStatus).getAttribute("value");
        while (true) {
            if (status.equals("COMPLETED")) {
                break;
            }
            maxWait();
        }
        return this;


    }

    /****
     * Force complete the job
     * @param key_jobName
     * @return
     * Author:A-6784
     */
    public ADM032 ChangeJobTime(String key_jobName) {

        String jobName = PropertyHandler.getPropValue(dataFilePath, key_jobName);
        selectByText(dropdown_JobName, jobName);
        minWait();
        enterKeys(txt_dateFrom, ".");
        enterKeys(txt_dateTo, "." + Keys.TAB);
        selectByText(dropdown_schedulestatus, "Active");
        click(btn_List);
        minWait();
        try {

            while (waitForElement(Tbl_JobScheduleDetails).getText().contains("ACTIVE")) {


                check(chkbox_SelectSchedule);
                click(btn_Stop);
                click(btn_List);
                minWait();

            }
            selectByText(dropdown_schedulestatus, "Stopped");
            click(btn_List);
            minWait();

            while (waitForElement(Tbl_JobScheduleDetails).getText().contains("STOPPED")) {
                check(chkbox_SelectSchedule);
                click(btn_Modify);
                minWait();
                enterKeys(txt_nextOccuranceDate, "." + Keys.TAB);
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String calendarTime = "";


                System.out.println("Current Hour in 24 hour format is : " + calendar.get(Calendar.HOUR_OF_DAY));
                System.out.println(sdf.format(calendar.getTime()));


                calendar.add(Calendar.MINUTE, +1);

                calendarTime = sdf.format(calendar.getTime());
                System.out.println(sdf.format(calendar.getTime()));
                String value = calendarTime.substring(0, 5);

                System.out.println(value);
                enterKeys(txt_NextOccuranceTime, value);
                click(btn_saveModify);
                minWait();

                click(btn_CloseModify);

                minWait();
                click(btn_List);
                minWait();

            }

        } catch (NoSuchElementException e) {
            logger.warn("Exception occured " + e);
        }
        logger.info("job is completed");

        maxWait();
        maxWait();
        return this;

    }

    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        return new HomePage(driver, dataFileName);
    }
}
