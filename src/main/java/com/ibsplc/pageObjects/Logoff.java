package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-6545
 */
public class Logoff extends BasePage {

    private WebDriver driver;
    private String browser;
    private String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    
    private By txt_usrname;
    private By txt_password;
    private By txt_cmpnyCod;
    private By btn_login;
    private By logoff_link;
    private By logoff_btn,
    btn_genericYes;
    
    public Logoff(WebDriver driver, String browser, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.browser = browser;
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initPageElements();
    }
    public Logoff(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
       this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initPageElements();
    }
    private void initPageElements(){
    
    	txt_usrname 	= MiscUtility.getWebElement(objFilepath,"login_txt_userName");
    	txt_password 	= MiscUtility.getWebElement(objFilepath,"login_txt_password");
    	txt_cmpnyCod 	= MiscUtility.getWebElement(objFilepath,"login_txt_compCode");
    	btn_login 		= MiscUtility.getWebElement(objFilepath,"login_btn_login");
    	logoff_link 		= MiscUtility.getWebElement(objFilepath,"logoff_link");
    	logoff_btn 		= MiscUtility.getWebElement(objFilepath,"logoff_btn");
    	 btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    }
    
    public HomePage doLogOff( String username){
    	username = PropertyHandler.getPropValue(dataFilePath, username);
      String password = PropertyHandler.getPropValue(dataFilePath, "password");
        String Companycode = PropertyHandler.getPropValue(dataFilePath, "Companycode");
        click(logoff_link);
        minWait();
        click(logoff_btn);
        minWait();
       
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        driver.switchTo().defaultContent();
        minWait();
        enterKeys(txt_usrname,username);
        enterKeys(txt_password,password);
        enterKeys(txt_cmpnyCod,Companycode);
        click(btn_login);
        driver.switchTo().defaultContent();
        return new HomePage(driver,dataFileName);

    }
  
}
