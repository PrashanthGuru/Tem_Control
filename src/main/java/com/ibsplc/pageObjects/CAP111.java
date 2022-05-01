package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class CAP111 extends BasePage {

    private static String FRAME = "iCargoContentFrameCAP111";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CAP_MSG.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    private WebDriver driver;
    private String screenFrame = "iCargoContentFrameCAP111";
    private String dataFileName;

    private By
            btn_close,
            dropDown_allotmentType,
            btn_List,
            btn_Delete,
            btn_add,
            chkBx_chkAll,
            dropDown_newAllotType,
            dropDown_newAllotSubType,
            txt_newAllotCat,
            txt_newAllotThresholdWt,
            txt_newAllotThresholdVol,
            chkBx_availForBooking,
            btn_save;

    private By info_footerMsg,
            btn_genericOk,
            yesBtn;

    private By list_altTypes;
    private By list_subTypes;
    private By btn_clr;

    public CAP111(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initPageElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    /**
     * Method to initialize page objects
     */
    private void initPageElements() {

        btn_close = MiscUtility.getWebElement(objFilepath, "CAP111_btn_close");
        dropDown_allotmentType = MiscUtility.getWebElement(objFilepath, "CAP111_dropDown_allotmentType");
        btn_List = MiscUtility.getWebElement(objFilepath, "CAP111_btn_List");
        btn_Delete = MiscUtility.getWebElement(objFilepath, "CAP111_btn_Delete");
        btn_add = MiscUtility.getWebElement(objFilepath, "CAP111_btn_add");
        chkBx_chkAll = MiscUtility.getWebElement(objFilepath, "CAP111_chkBx_chkAll");
        dropDown_newAllotType = MiscUtility.getWebElement(objFilepath, "CAP111_dropDown_newAllotType");
        dropDown_newAllotSubType = MiscUtility.getWebElement(objFilepath, "CAP111_dropDown_newAllotSubType");
        txt_newAllotCat = MiscUtility.getWebElement(objFilepath, "CAP111_txt_newAllotCat");
        txt_newAllotThresholdWt = MiscUtility.getWebElement(objFilepath, "CAP111_txt_newAllotThresholdWt");
        txt_newAllotThresholdVol = MiscUtility.getWebElement(objFilepath, "CAP111_txt_newAllotThresholdVol");
        chkBx_availForBooking = MiscUtility.getWebElement(objFilepath, "CAP111_chkBx_availForBooking");
        btn_save = MiscUtility.getWebElement(objFilepath, "CAP111_btn_save");

        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footerMsg = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        list_altTypes = MiscUtility.getWebElement(objFilepath, "CAP111_list_altType");
        list_subTypes = MiscUtility.getWebElement(objFilepath, "CAP111_list_altSubType");
        btn_clr=MiscUtility.getWebElement(objFilepath, "CAP111_btn_clr");
    }

    /**
     * setup a configuration for allotment
     * @param allotmentType
     * @param allotSubType
     * @param category
     * @param wtThreshold
     * @param volThreshold
     * @return
     */
    public CAP111 configAllotWithUtilThreshold(String allotmentType, String allotSubType, String category, String wtThreshold, String volThreshold) {

        allotmentType = PropertyHandler.getPropValue(dataFilePath,allotmentType);
        allotSubType = PropertyHandler.getPropValue(dataFilePath,allotSubType);
        category = PropertyHandler.getPropValue(dataFilePath,category);

        selectByText(dropDown_allotmentType, allotmentType);
        click(btn_List);

        check(chkBx_chkAll);
        click(btn_Delete);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericOk)) {
            click(btn_genericOk);
        }
        waitForFrameAndSwitch(screenFrame);
        click(btn_save);
        driver.switchTo().defaultContent();
        Assert.assertEquals(waitForElement(info_footerMsg).getText().trim(), "Data Saved Successfully.", "The already present config is not deleted");
        waitForFrameAndSwitch(screenFrame);

        click(btn_add);
        selectByText(dropDown_newAllotType, allotmentType);
        selectByText(dropDown_newAllotSubType, allotSubType);
        enterKeys(txt_newAllotCat, category);
        enterKeys(txt_newAllotThresholdWt, wtThreshold);
        enterKeys(txt_newAllotThresholdVol, volThreshold);

        check(chkBx_availForBooking);

        click(btn_save);
        driver.switchTo().defaultContent();
        Assert.assertEquals(waitForElement(info_footerMsg).getText().trim(), "Data Saved Successfully.", "The configuration is not saved");
        waitForFrameAndSwitch(screenFrame);

        return this;
    }
    //method creation pending
    /**
     * @author A-8260
     * @return
     */
    public CAP111 setUpParametersForAllotmentOverbooking(String altType, String altSubType,String cat, String shipType, String ovbWt, String ovVol, String utThWt,
    		String utThVol,String utAlert, boolean ULD_posChk,boolean availableForBooking)
    {
    	List<WebElement> altTypes=getWebElements(list_altTypes);
    	List<WebElement> altSubTypes=getWebElements(list_subTypes);
    	int size=(altTypes.size())-1;
    	for(int i=0;i<(altTypes.size())-1;i++)
    	{
    		if(altTypes.get(i).getText().equals(altType)&&altSubTypes.get(i).getText().equals(altSubType))
    		{
    			click(btn_clr);
    			break;
    		}
    		
    		else
    		{
    			click(btn_add);
    			
    		}
    				
    	}
    	return new CAP111(driver, dataFileName);
    }
    /**
     * Method to close current page and return to Homepae
     * returns the instance of Homepage
     *
     * @return
     * @author a-7868
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
