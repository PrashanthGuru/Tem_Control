package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class TRF025 extends BasePage {


    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameTRF025";
    By

            txt_serviceCode,
            btn_List,
            link_Add,
            txt_ChargeHeadcodePopup,
            txt_ListPopup,
            checkbox_SelectChargeHead,
            Btn_ok,
            Btn_Save,
            txt_ServiceName,
            info_msg,
            btn_Close,
            yesBtn,
            btn_Clear,
            info_infoMsg,
            chkbox_isAmendmendService,
            table_chargeHeads;
    WebDriver driver;
    String screenFrame;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    public TRF025(WebDriver driver, String dataFileName) {

        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {

        info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        txt_serviceCode = MiscUtility.getWebElement(objFilepath, "TRF025_txt_serviceCode");
        btn_List = MiscUtility.getWebElement(objFilepath, "TRF025_btn_List");
        link_Add = MiscUtility.getWebElement(objFilepath, "TRF025_link_Add");
        txt_ChargeHeadcodePopup = MiscUtility.getWebElement(objFilepath, "TRF025_txt_ChargeHeadcodePopup");
        txt_ListPopup = MiscUtility.getWebElement(objFilepath, "TRF025_txt_ListPopup");
        checkbox_SelectChargeHead = MiscUtility.getWebElement(objFilepath, "TRF025_checkbox_SelectChargeHead");
        Btn_ok = MiscUtility.getWebElement(objFilepath, "TRF025_Btn_ok");
        Btn_Save = MiscUtility.getWebElement(objFilepath, "TRF025_Btn_Save");
        txt_ServiceName = MiscUtility.getWebElement(objFilepath, "TRF025_txt_ServiceName");
        btn_Close = MiscUtility.getWebElement(objFilepath, "TRF025_btn_Close");
        btn_Clear = MiscUtility.getWebElement(objFilepath, "TRF025_btn_Clear");
        info_infoMsg = MiscUtility.getWebElement(objFilepath, "TRF025_info_infoMsg");
        //A-8255
        chkbox_isAmendmendService = MiscUtility.getWebElement(objFilepath, "TRF025_chkbox_isAmendmendService");
        
        table_chargeHeads = MiscUtility.getWebElement(objFilepath, "TRF025_table_chargeHeads");

    }

    /**
     * Maintain charge Head if not exist
     * <p>
     * Method to check the charge head and created new if not exist
     * on 05/1/2018
     *
     * @param JobName,status
     * @return A-6784
     */


    public TRF025 createChargeHead2(String serviceCode, String ChargeHeadnumber, String... ChargeHeadCode) {

        serviceCode = PropertyHandler.getPropValue(dataFilePath, serviceCode);
        String count = PropertyHandler.getPropValue(dataFilePath, ChargeHeadnumber);

        enterKeys(txt_serviceCode, serviceCode);
        click(btn_List);
        minWait();
        String temp1 = waitForElement(info_infoMsg).getText();

        System.out.println(temp1);

        if (temp1.contains("does not exist. Do you want to create a new one")) {

            click(yesBtn);
            minWait();

            int y = Integer.parseInt(count);

            for (int i = 1; i <= y; i++) {

                String name = ChargeHeadCode[i];
                String ChargeHeadcode = PropertyHandler.getPropValue(dataFilePath, name);
                click(link_Add);
                minWait();
                driver.switchTo().defaultContent();
                waitForNewWindow(2);

                switchToSecondWindow();
                enterKeys(waitForElement(txt_ChargeHeadcodePopup), ChargeHeadcode);
                click(txt_ListPopup);
                minWait();
                check(checkbox_SelectChargeHead);
                click(Btn_ok);

                minWait();
                switchToFirstWindow();

                waitForFrameAndSwitch(FRAME);

            }


            click(Btn_Save);
            minWait();


        } else {

            click(btn_Clear);
        }

        return this;


    }

    public HomePage close() {

        click(btn_Close);
        driver.switchTo().defaultContent();

        return new HomePage(driver, dataFileName);
    }

    //A-8255
    public TRF025 checkAmendent(String serviceCode) {

        serviceCode = PropertyHandler.getPropValue(dataFilePath, serviceCode);

        enterKeys(txt_serviceCode, serviceCode);
        click(btn_List);
        minWait();

        if (!waitForElement(chkbox_isAmendmendService).isSelected()) {
            check(chkbox_isAmendmendService);
        }

        click(Btn_Save);
        minWait();

        return this;
    }
    /**
     * Created by A-7605 on 14-5-18
     * This method saves all charge head names under the serviceCode into datasheet separated by comma
     * @param serviceCode
     * @param chargeHeadNames
     * @return
     */
    public TRF025 getChargeHeadNames(String serviceCode,String chargeHeadNames){
    	serviceCode = PropertyHandler.getPropValue(dataFilePath, serviceCode);
    	enterKeys(txt_serviceCode, serviceCode);
    	enterKeys(txt_serviceCode, Keys.TAB);
        click(btn_List);
        minWait();
        String headNames = null;
        List<String> chargeHeads = getTableInputColumnValues(table_chargeHeads, 3);
        for(String chargeHead:chargeHeads)
        	if(headNames == null)
        		headNames = chargeHead;
        	else
        	headNames = headNames+","+chargeHead;
        PropertyHandler.setPropValue(dataFilePath, chargeHeadNames, headNames);
        return this;
    }
}
