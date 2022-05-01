package runner;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ibsplc.common.BaseSetup;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
* @author Sharath
* 
 */

@CucumberOptions(features = { "src/test/java/features" }, glue = { "stepdefinitions" }, plugin = {
                                "pretty", "html:target/cucumber", "json:target/cucumber.json" },
                                tags = {"@Flow02"}
)
@Test
public class Flow02 extends AbstractTestNGCucumberTests {
                protected final static Logger logger = Logger.getLogger(BaseSetup.class);
                public static String browserName;
                public static WebDriver driver;
}