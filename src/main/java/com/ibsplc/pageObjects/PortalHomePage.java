package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Portal Home Page
 * @author A-7868
 * <29/05/2018>
 */
public class PortalHomePage extends BasePage {

	private WebDriver driver;
    private String browser;
    private String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "PORTAL.properties");
    
    By lnk_login,
    	txt_uname,
    	txt_pwd,
    	btn_signIn,
    	lnk_user;
    
    public PortalHomePage(WebDriver driver, String browser, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.browser = browser;
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initPageElements();
    }
    
    /**
     * Method to initialize page elements
     */
    private void initPageElements(){
        
    	lnk_login = MiscUtility.getWebElement(objFilepath, "homepage_lnk_login");
    	txt_uname = MiscUtility.getWebElement(objFilepath, "homepage_txt_username");
    	txt_pwd = MiscUtility.getWebElement(objFilepath, "homepage_txt_password");
    	btn_signIn = MiscUtility.getWebElement(objFilepath, "homepage_btn_signIn");
    	lnk_user = MiscUtility.getWebElement(objFilepath, "homepage_lnk_uname");
    	
    }
    
    /**
     * Method to login with user specified in data file and check whether the user name
     * is displayed in the banner.
     * @return
     * @author A-7868 Krishna <29/05/2018>
     */
    public PortalHomePage login(){
    	
    	String username = PropertyHandler.getPropValue(dataFilePath, "username");
    	String password = PropertyHandler.getPropValue(dataFilePath, "password");
    	
    	click(lnk_login);
    	enterKeys(txt_uname, username);
    	enterKeys(txt_pwd, password);
    	click(btn_signIn);
    	minWait();
    	Assert.assertTrue(waitForElement(lnk_user).getText().trim().toUpperCase().contains(username.toUpperCase()), "ERROR Logging in.");
    	return this;
    }
}
