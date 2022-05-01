package com.ibsplc.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.IInvokedMethod;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ibsplc.generic.InitialSetup;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Created by a-7681 on 12/11/2017.
 */
public class BaseSetup implements ISuiteListener, ITestListener{
	
	protected final static Logger logger = Logger.getLogger(BasePage.class); 	
    public static String browserName;       	
    private static String ScreenShotPath = "reports\\ScreenShots\\";
	private static String TOLRUNREQ = null;
	private static long startMillis;
	private DesiredCapabilities capabilities;
	public static WebDriver driver;
	protected String portalURL = "";
    public static ExtentReports extent;
    public static ExtentTest test;
    
	
	
	public void onStart(ISuite arg0) {	
		
        
	}

	public void onFinish(ISuite arg0) {
		InitialSetup.driver.quit();
	}
	
	public void onTestStart(ITestResult arg0) {
		
	}

	public void onTestFailure(ITestResult arg0) {
		InitialSetup.test.log(LogStatus.FAIL, "The test failed, please refer below screenshot" );
		captureAndAddScreenshot();
		extent.endTest(test);
		InitialSetup.driver.quit();
}


	public void onTestSkipped(ITestResult arg0) {
		extent.endTest(test);
	}

	public void onTestSuccess(ITestResult arg0) {
		extent.endTest(test);
		InitialSetup.driver.quit();
	  }
	
	
	public void onFinish(ITestContext arg0) {
		extent.flush();
	}
	
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
	}
	
	public void onStart(ITestContext arg0) {  
	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    				   LocalDateTime now = LocalDateTime.now();  
	    				   System.out.println(dtf.format(now)); 
	    				   String dateTime = dtf.format(now).toString().replaceAll(" ","")
	    						   .replaceAll("/", ".").replaceAll(":", ""); 
    
		System.out.println(System.getProperty("user.dir"));
//        extent = new ExtentReports(System.getProperty("user.dir")
//                                        + "\\reports\\ExtentReportResults_"+ dateTime+".html");
		 extent = new ExtentReports(System.getProperty("user.dir")
                 + "\\reports\\TC.html");
//		 extent = new ExtentReports(System.getProperty("user.dir")
//               + "\\reports\\DGAutoNotocReports.html", false);
       intializeLogger();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	

	/******************************/
	
	private String checkForError() {
		
	    driver.switchTo().defaultContent();
	    String xpath = "//*[@id='errorDisplayDiv']/table/tbody/tr/td[2]";
	    String text = null;
	    try {
	        text = driver.findElement(By.xpath(xpath)).getText();
	    } catch (NoSuchElementException e) {
	        List<WebElement> frameList = driver.findElements(By.xpath("//iframe[contains(@name,'iCargoContentFrame')]"));
	        driver.switchTo().frame(frameList.get(1));
	        try {
	            text = driver.findElement(By.xpath(xpath)).getText();
	        } catch (NoSuchElementException e1) {
	        }
	    }
	
	    return text;
	}
	
	/**
	 * Created by A-7605
	 */
	protected void intializeLogger() {
	    Properties properties = new Properties();
	
	    try {
	        properties.load(new FileInputStream("log4j.properties"));
	        PropertyConfigurator.configure(properties);
	        
	        logger.info("Logger configured");
	    } catch (IOException e) {
	        e.printStackTrace();
	
	    }
	}
	
	public enum Days {
	    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	}
	    
	/**
	 * Created by A-7605 on 6-3-18
	 * This method is used to associate event handler with the driver
	 * @param driver
	 * @return
	 */
	protected WebDriver registerEvent(WebDriver driver){
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		EventHandler eventListener = new EventHandler();
		eventDriver.register(eventListener);
		driver = eventDriver;
		logger.info("Event handler registered with driver "+driver);
		return driver;    	
	}
	    
	/**
	 * Created by A-7605 on 32-5-18
	 * This method kills already running driver files
	 */
	private void killBrowserDriver(){
		logger.info("Killing driver files");
		String[] commands = new String[]{"taskkill /im chromedriver.exe /f","taskkill /im IEDriverServer.exe /f","taskkill /im geckodriver.exe /f"};
		try {
			for(String command:commands)
				Runtime.getRuntime().exec(command);
			logger.info("Driver files killed");
		} catch (IOException e) {
			logger.info("Error on killing driver files",e);
		}
	}
	
	public void captureAndAddScreenshot(){
		try{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now)); 
        String path = dtf.format(now).toString().replaceAll(" ","").replaceAll("/", ".").replaceAll(":", "")+".png";
        File scrFile = ((TakesScreenshot)InitialSetup.driver).getScreenshotAs(OutputType.FILE);
        org.openqa.selenium.io.FileHandler.copy(scrFile, new File("./Reports/ScreenShots/"+path));     
        System.out.println();
        System.out.println("Screenshot taken");   
        String dir = System.getProperty("user.dir")+"\\Reports\\Screenshots\\";
        InitialSetup.test.log(LogStatus.INFO, test.addScreenCapture(dir+path) );
		}
		catch(Exception e){
         e.printStackTrace();
         System.out.println(e);
		}
	}

	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	public void beforeConfiguration(ITestResult tr) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Author- Sharath 
	 * Purpose: Method to Set all Flag status to No status
	 * Date: 29-03-2019
	 */
		public void writeFlagtoExcelCell(String path, int index, String dataToWrite) throws Exception {  
			try {
	            File f1 = new File(path);
	            FileInputStream ios1 = new FileInputStream(f1);
	            XSSFWorkbook workbook1 = new XSSFWorkbook(ios1);
	            XSSFSheet sheet1 = workbook1.getSheetAt(0);
	            int rows = sheet1.getLastRowNum();
	            Row row1 = sheet1.getRow(index);
	            int cellIndex = row1.getFirstCellNum();
	            Cell cell1 = row1.createCell(cellIndex);
	            cell1.setCellValue(dataToWrite);
	            FileOutputStream out = new FileOutputStream(new File(path));
	            workbook1.write(out);
	            out.close();
	      } catch (Exception e) {
	    	   System.out.println("Setting flags to No failed");
	            e.printStackTrace();
	      }

		}
		
		// Sharath
		public List<Map<String, String>> getRawData(String path) throws IOException {

			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheetAt(0);
			Row headerRow = sh.getRow(0);
			Row dataRow;
			String key, value;
			List<Map<String, String>> mylists = new ArrayList();
			int noOfRows = sh.getLastRowNum();
			int noOfCols = sh.getRow(0).getLastCellNum();
			HashMap<String, String> myMap = null;
			for (int i = 1; i <= noOfRows; i++) {
				myMap = new HashMap();
				dataRow = sh.getRow(i);
				for (int j = 0; j < noOfCols; j++) {
					key = CellUtil.getCell(headerRow, j).getStringCellValue();
					try{
						value = CellUtil.getCell(dataRow, j).getStringCellValue();
						}catch(IllegalStateException e){
							int b = (int) CellUtil.getCell(dataRow, j).getNumericCellValue();
							value = Integer.toString(b);
						}
					myMap.put(key, value);
				}
				mylists.add(myMap);
			}
			fis.close();
			return mylists;
		}

}
