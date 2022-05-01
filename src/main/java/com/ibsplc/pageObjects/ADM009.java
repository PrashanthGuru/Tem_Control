package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/28/2017.
 */
public class ADM009 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
    private static String FRAME = "iCargoContentFrameADM009";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By dropDown_station,dropDown_selectedStationRoleGroup,
            dropDown_airport,
            btn_ok;


    public ADM009(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        dropDown_station = MiscUtility.getWebElement(objFilepath, "ADM009_dropDown_station");
        dropDown_airport = MiscUtility.getWebElement(objFilepath, "ADM009_dropDown_airport");
        dropDown_selectedStationRoleGroup= MiscUtility.getWebElement(objFilepath, "ADM009_dropDown_selectedStationRoleGroup");
        btn_ok = MiscUtility.getWebElement(objFilepath, "ADM009_btn_ok");
    }
 
    /**
     * Switches to the station and airport passed as parameters
     * @param station
     * @param airport
     * @return
     * @author Arun A-7681 on 28/12
     */
    public HomePage switchRole(String station, String airport) {

        station = PropertyHandler.getPropValue(dataFilePath,station);
        airport = PropertyHandler.getPropValue(dataFilePath,airport);

        selectByText(dropDown_station, station);
        selectByText(dropDown_airport, airport);

      //  selectByText(dropDown_selectedStationRoleGroup,"ICAODMIN");

//      selectByText(dropDown_selectedStationRoleGroup,"GHAADMIN");
        click(btn_ok);
        minWait();
        driver.switchTo().defaultContent();
        return new HomePage(driver, dataFileName);
    }
    /**
     * Created by A-7605 on 10-4-18
     * This method switch to the specified role and station
     * @param station
     * @param airport
     * @param role
     * @return
     */
    public HomePage switchRoleDFW(String station, String airport, String role) {

        station = PropertyHandler.getPropValue(dataFilePath,station);
        airport = PropertyHandler.getPropValue(dataFilePath,airport);
        role = PropertyHandler.getPropValue(dataFilePath,role);
        
//      selectByText(By.xpath("//select[@name='selectedStation']"), station);
//        selectByValue(By.xpath("//select[@name='selectedStation']"), station);
//        selectByText(By.xpath("//select[@name='selectedAirport']"), airport);
        selectByText(By.xpath("//select[@name='selectedStationRoleGroup']"),role);
        click(btn_ok);
        minWait();
        driver.switchTo().defaultContent();
        return new HomePage(driver, dataFileName);
    }
    
    public HomePage switchRole(String station, String airport, String role) {

        station = PropertyHandler.getPropValue(dataFilePath,station);
        airport = PropertyHandler.getPropValue(dataFilePath,airport);
        role = PropertyHandler.getPropValue(dataFilePath,role);
        
        selectByText(By.xpath("//select[@name='selectedStation']"), station);
//      selectByValue(By.xpath("//select[@name='selectedStation']"), station);
//        selectByText(By.xpath("//select[@name='selectedAirport']"), airport);
        selectByText(By.xpath("//select[@name='selectedStationRoleGroup']"),role);
        click(btn_ok);
        minWait();
        driver.switchTo().defaultContent();
        return new HomePage(driver, dataFileName);
    }
}
