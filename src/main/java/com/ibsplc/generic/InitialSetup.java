package com.ibsplc.generic;

import java.net.MalformedURLException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.SkipException;

import com.ibsplc.common.BaseSetup;
import com.ibsplc.common.enums.Browser;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;



public class InitialSetup extends BaseSetup{
	
	
	protected final static Logger logger = Logger.getLogger(BaseSetup.class); 	
	private DesiredCapabilities capabilities;
	public static WebDriver driver;
	String dataFileName;
	public static String propertyFilePath;
	String flag;
	public static boolean skip;
//Sauce lab Credentials (Added by U-1452)
	public static final String USERNAME= "sso-aa-Sharath.Madananth";
	public static final String ACCESS_KEY= "ffa62482-99ff-45c3-8044-557e05d6e503";
	public static final String URL= "https://" + USERNAME + ":" + ACCESS_KEY +"@ondemand.us-west-1.saucelabs.com:443/wd/hub";

	public void flagSetBooking(String PropfilePath)
	{
		 String dataFilePath = PropertyHandler.getPropValue(
				"resources\\EnvSetup.properties", "testDataDirectory");
		 dataFilePath= dataFilePath+PropfilePath;
//		 this.propertyFilePath=dataFilePath;
		PropertyHandler.setPropValue(dataFilePath, "flag","true");
		skip=false;
	}
	
	public void flagCheck(String PropfilePath)
	{
		 String dataFilePath = PropertyHandler.getPropValue(
				"resources\\EnvSetup.properties", "testDataDirectory");
		 dataFilePath= dataFilePath+PropfilePath;
//		 this.propertyFilePath=dataFilePath;
			  flag= PropertyHandler.getPropValue(dataFilePath, "flag");
			  if(!flag.equalsIgnoreCase("false")){
					 PropertyHandler.setPropValue(dataFilePath, "flag", "true");
			  skip=false;
			  }
			  else if(flag.equalsIgnoreCase("false"))
			 {
				  skip=true;
				 throw new SkipException("The previous test failed, hence skipping this test");
			 }
	}

	public WebDriver InitialSetupMethod(String browserName, String url) {

      BaseSetup.browserName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
      Browser browser = Browser.valueOf(BaseSetup.browserName.toUpperCase());
      switch (browser) {
          case FIREFOX:
              String sFF = System.getProperty("user.dir");
              String pathFF = sFF + "\\lib\\geckodriver.exe";
              System.setProperty("webdriver.gecko.driver", pathFF);
              capabilities = DesiredCapabilities.firefox();
              capabilities.setBrowserName("firefox");
              capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
              capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
              capabilities.setCapability("marionette", true);
              capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
              // Below line can be added to avoid full page load.
              // profile.setPreference("webdriver.load.strategy", "unstable");
              driver = new FirefoxDriver(capabilities);
              break;
          case IE:
              capabilities = DesiredCapabilities.internetExplorer();

              String s2 = System.getProperty("user.dir");
              String path = s2 + "\\lib\\IEDriverServer.exe";

              System.setProperty("webdriver.ie.driver", path);
              capabilities.setBrowserName("iexplore");

              capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
              capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
//              capabilities.setCapability("ignoreProtectedModeSettings", true);

              driver = new InternetExplorerDriver(capabilities);
              break;
          case CHROME:
              capabilities = DesiredCapabilities.chrome();
              String sc2 = System.getProperty("user.dir");
              String pathc = sc2 + "\\lib\\chromedriver.exe";

              System.setProperty("webdriver.chrome.driver", pathc);
              ChromeOptions options = new ChromeOptions();
              options.addArguments("--no-sandbox");
  		      options.addArguments("--disable-dev-shm-usage");// Added for checking
              Proxy proxy = new Proxy();// Added for checking for proxy settings
              proxy.setProxyType(Proxy.ProxyType.SYSTEM);// Added for checking for
              // proxy settings
              capabilities.setBrowserName("chrome");
              capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
              capabilities.setCapability("proxy", proxy);// Added for checking for proxy settings
              capabilities.setCapability(ChromeOptions.CAPABILITY, options);// Added
              // for
              // checking
              capabilities.setCapability("chrome.switches",
                      Arrays.asList("--start-maximized"));
              capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
//              capabilities.setCapability("pageLoadStrategy", "eager");
              driver = new ChromeDriver(capabilities);
              break;

      }
      driver.manage().window().maximize();
      driver.get(url);
      //Create and initialize SoftAssert object
      Assertion.setSoftAssert(Assertion.createSoftAssert());
		return driver;
  }
	public WebDriver InitialSetupMethod1() throws MalformedURLException {
//		browserName = PropertyHandler.getPropValue("resources\\TestData\\Base\\ICargo_1.1_Regression.properties","browser");
//		 String url = PropertyHandler.getPropValue("resources\\TestData\\Base\\ICargo_1.1_Regression.properties","iCargoURL");
		BaseSetup.browserName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
		String url = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("portalURL");
		//browserName = PropertyHandler.getPropValue(browser, "browser");
	     //this.browserName = browserName;
	     browserName=String.valueOf(browserName.toUpperCase());
	       //browser = Browser.valueOf(browser.toUpperCase());
	      switch (browserName) {
	          case "FIREFOX":
	              String sFF = System.getProperty("user.dir");
	              String pathFF = sFF + "\\lib\\geckodriver.exe";
	              System.setProperty("webdriver.gecko.driver", pathFF);
	              capabilities = DesiredCapabilities.firefox();
	              capabilities.setBrowserName("firefox");
	              capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
	              capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	              capabilities.setCapability("marionette", true);
	              capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
	              // Below line can be added to avoid full page load.
	              // profile.setPreference("webdriver.load.strategy", "unstable");
	              driver = new FirefoxDriver(capabilities);
	              break;
	          case "IE":
	              capabilities = DesiredCapabilities.internetExplorer();

	              String s2 = System.getProperty("user.dir");
	              String path = s2 + "\\lib\\IEDriverServer.exe";

	              System.setProperty("webdriver.ie.driver", path);
	              
	              //capabilities.setBrowserName("iexplore");

	             // capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
	              //capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
	              //capabilities.setCapability("ignoreProtectedModeSettings", true);

	              driver = new InternetExplorerDriver(capabilities);
	              break;
	          case "CHROME":
	              capabilities = DesiredCapabilities.chrome();
	              String sc2 = System.getProperty("user.dir");
	              String pathc = sc2 + "\\lib\\chromedriver.exe";

	              System.setProperty("webdriver.chrome.driver", pathc);
	              ChromeOptions options = new ChromeOptions();
	              options.addArguments("--no-sandbox");
	  		      options.addArguments("--disable-dev-shm-usage");// Added for checking
	              Proxy proxy = new Proxy();// Added for checking for proxy settings
	              proxy.setProxyType(Proxy.ProxyType.SYSTEM);// Added for checking for
	              // proxy settings
	              capabilities.setBrowserName("chrome");
	              capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
	              capabilities.setCapability("proxy", proxy);// Added for checking for proxy settings
	              capabilities.setCapability(ChromeOptions.CAPABILITY, options);// Added
	              // for
	              // checking
	              capabilities.setCapability("chrome.switches",
	                      Arrays.asList("--start-maximized"));
	              capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
//	              capabilities.setCapability("pageLoadStrategy", "eager");
	              driver = new ChromeDriver(capabilities);
	              break;
	              
		case "CHROME_REMOTE":
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("username", "SAUCE_USERNAME");
			capabilities.setCapability("accessKey", "SAUCE_ACCESS_KEY");
			capabilities.setCapability("platform", "Windows 10");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("version", "latest");
			capabilities.setCapability("name", "Test");
			capabilities.setCapability("screenResolution", "1280x800");
			driver = new RemoteWebDriver(new java.net.URL(URL), capabilities);

			// ChromeOptions chromeOptions = new ChromeOptions();
			// chromeOptions.setCapability("browserVersion", "89");
			// chromeOptions.setCapability("platformName", "Windows 10");
			// driver = new RemoteWebDriver(new java.net.URL(URL),
			// chromeOptions);
			// driver.manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
			break;

	      }
	      driver.manage().window().maximize();
	      driver.get(url);
	      BaseSetup.test.log(LogStatus.PASS, "Started the browser and entered the iCargo url");
	      /*Create and initialize SoftAssert object*/
	      Assertion.setSoftAssert(Assertion.createSoftAssert());
		  return driver;
	  }
}
