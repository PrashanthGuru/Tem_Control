/**
 * 
 */
package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author A-6545 on 16/2/2018.
 *
 */
import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class ADM004 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
    private static String FRAME = "iCargoContentFrameADM004";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private WebDriver driver;
    private String dataFileName;

    private By txt_ADMINROLEGROUP,
    list_USRTYP,
    btn_List,
    btn_Save,
    btn_genericYes,
    btn_Close;  


    public ADM004(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

    	txt_ADMINROLEGROUP = MiscUtility.getWebElement(objFilepath, "ADM004_txt_ADMINROLEGROUP");
    	list_USRTYP = MiscUtility.getWebElement(objFilepath, "ADM004_list_USRTYP");
    	btn_List = MiscUtility.getWebElement(objFilepath, "ADM004_btn_List");
    	btn_Save = MiscUtility.getWebElement(objFilepath, "ADM004_btn_Save");
    	btn_Close = MiscUtility.getWebElement(objFilepath, "ADM004_btn_Close");
    	btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }

    /**
     * 

     * @param username
     * @param airport
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public ADM004 RoleGroup_change(String username) {

    	username = PropertyHandler.getPropValue(dataFilePath,username);
     

        enterKeys(txt_ADMINROLEGROUP, username);
   
        click(btn_List);
        minWait();
        if(waitForElement(list_USRTYP).getAttribute("value").equalsIgnoreCase("GHA"))
        {
        	Assert.assertTrue(waitForElement(list_USRTYP).getAttribute("value").equalsIgnoreCase("GHA"));
        }
        else
        {
        selectByText(list_USRTYP, "GHA");
        click(btn_Save);
        }
     
        return this;
    }
    /**
     * CLose and screen and go to home page
     *
     * @return
     * @author A-6545 on 16/2/2018.
     */
    public HomePage close() {

        click(btn_Close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
}
