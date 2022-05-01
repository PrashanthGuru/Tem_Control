package com.ibsplc.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class OPR029 extends BasePage {

    private final static Logger logger = Logger.getLogger(MSG005.class);
    public static String objectFileName = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String FRAME = "iCargoContentFrameOPR029";
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    String dataFileName;
    private WebDriver driver;
    private By txt_awbPrefix,
            txt_awbNo,
            btn_list,
            tbl_hawbDetails,
            CheckBox_AllHAWB,
            Link_Add,
            txt_HAWBNo,
            ChkBox_Console,
            txt_ShipperCode,
            btn_save,
            btn_close,
            txt_ConsigneeCode,
            yesBtn,
            noBtn,
            txt_Origin,
            txt_Destination,
            txt_Peices,
            txt_Weight,
            txt_ShipmentDesc,
            Btn_OK,
            Btn_NewHouse,
            btn_genericYes,
            div_infoClose,
            info_footer,
            msg_popup;

    public OPR029(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        PageFactory.initElements(driver, this);
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    public void initElements() {

        txt_awbPrefix = MiscUtility.getWebElement(objectFileName, "OPR029_txt_awbPrefix");
        txt_awbNo = MiscUtility.getWebElement(objectFileName, "OPR029_txt_awbNo");
        btn_list = MiscUtility.getWebElement(objectFileName, "OPR029_btn_list");
        tbl_hawbDetails = MiscUtility.getWebElement(objectFileName, "OPR029_tbl_hawbDetails");
        btn_close = MiscUtility.getWebElement(objectFileName, "OPR029_btn_close");
        btn_list = MiscUtility.getWebElement(objectFileName, "OPR029_Btn_List");
        txt_awbNo = MiscUtility.getWebElement(objectFileName, "OPR029_txt_AWBNo");
        CheckBox_AllHAWB = MiscUtility.getWebElement(objectFileName, "OPR029_CheckBox_AllHAWB");
        Link_Add = MiscUtility.getWebElement(objectFileName, "OPR029_Link_Add");
        txt_HAWBNo = MiscUtility.getWebElement(objectFileName, "OPR029_txt_HAWBNo");
        ChkBox_Console = MiscUtility.getWebElement(objectFileName, "OPR029_ChkBox_Console");
        txt_ShipperCode = MiscUtility.getWebElement(objectFileName, "OPR029_txt_ShipperCode");
        txt_ConsigneeCode = MiscUtility.getWebElement(objectFileName, "OPR029_txt_ConsigneeCode");
        txt_Origin = MiscUtility.getWebElement(objectFileName, "OPR029_txt_Origin");
        txt_Destination = MiscUtility.getWebElement(objectFileName, "OPR029_txt_Destination");
        txt_Peices = MiscUtility.getWebElement(objectFileName, "OPR029_txt_Peices");
        txt_Weight = MiscUtility.getWebElement(objectFileName, "OPR029_txt_Weight");
        txt_ShipmentDesc = MiscUtility.getWebElement(objectFileName, "OPR029_txt_ShipmentDesc");
        Btn_OK = MiscUtility.getWebElement(objectFileName, "OPR029_Btn_OK");
        Btn_NewHouse = MiscUtility.getWebElement(objectFileName, "OPR029_Btn_NewHouse");
        btn_save = MiscUtility.getWebElement(objectFileName, "OPR029_Btn_Save");
        btn_close = MiscUtility.getWebElement(objectFileName, "OPR029_Btn_Close");
        div_infoClose = MiscUtility.getWebElement(genObjPath, "Generic_info_close1");
        info_footer = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        msg_popup = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    }

    /**
     * This method verifies if atmost 2 houses are added to an awb, key_houseNo2 should be null if only one house is to be validated
     *
     * @param key_awbNoPrefix
     * @param key_awbNo
     * @param key_houseNo1
     * @param key_houseNo2
     * @return
     */
    public OPR029 verifyIfHousesAdded(String key_awbNoPrefix, String key_awbNo, String key_houseNo1, String key_houseNo2) {
        String awbNoPrefix = PropertyHandler.getPropValue(dataFilePath, key_awbNoPrefix);
        String awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
        String houseNo1 = PropertyHandler.getPropValue(dataFilePath, key_houseNo1);
        String houseNo2 = PropertyHandler.getPropValue(dataFilePath, key_houseNo2);

        enterKeys(txt_awbPrefix, awbNoPrefix);
        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
        minWait();
        Assert.assertTrue(getTableColumnValues(tbl_hawbDetails, 2).contains(houseNo1));
        if (houseNo2 != null && houseNo2.trim().length() > 0) {
            Assert.assertTrue(getTableColumnValues(tbl_hawbDetails, 2).contains(houseNo2));
        }
        return this;
    }

    public OPR029 addHAWB(String key_awbNo, String key_AWBNo_Prefix, String key_ShipperCode,
                          String key_ConsigneeCode, String key_Origin, String key_Destination, String key_No_Pieces_HAWB1, String key_No_Pieces_HAWB2, String key_Weight_HAWB1, String key_Weight_HAWB2, String key_HAWBNo, String key_HAWBNo2) {


        String data_AWBNo_Prefix = PropertyHandler.getPropValue(dataFilePath, key_AWBNo_Prefix);
        String data_awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
        String data_HAWBNo = PropertyHandler.getPropValue(dataFilePath, key_HAWBNo);
        String data_HAWBNo2 = PropertyHandler.getPropValue(dataFilePath, key_HAWBNo2);
        String data_ShipperCode = PropertyHandler.getPropValue(dataFilePath, key_ShipperCode);
        String data_ConsigneeCode = PropertyHandler.getPropValue(dataFilePath, key_ConsigneeCode);
        String data_Origin = PropertyHandler.getPropValue(dataFilePath, key_Origin);
        String data_Destination = PropertyHandler.getPropValue(dataFilePath, key_Destination);
        String data_Weight_HAWB1 = PropertyHandler.getPropValue(dataFilePath, key_Weight_HAWB1);
        String data_No_Pieces_HAWB1 = PropertyHandler.getPropValue(dataFilePath, key_No_Pieces_HAWB1);
        String data_Weight_HAWB2 = PropertyHandler.getPropValue(dataFilePath, key_Weight_HAWB2);
        String data_No_Pieces_HAWB2 = PropertyHandler.getPropValue(dataFilePath, key_No_Pieces_HAWB2);


        enterKeys(txt_awbNo, data_awbNo);
        click(btn_list);
        // click(div_infoClose);

        maxWait();
        minWait();
        driver.switchTo().defaultContent();
        //to handle consol popup
        if (verifyElementPresent(btn_genericYes))
            click(btn_genericYes);
        waitForFrameAndSwitch(FRAME);
        minWait();
        click(Link_Add);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();
        click(txt_HAWBNo);
        enterKeys(txt_HAWBNo, data_HAWBNo + Keys.TAB);
        minWait();
        enterKeys(txt_ShipperCode, data_ShipperCode);
        enterKeys(txt_ConsigneeCode, data_ConsigneeCode);
        enterKeys(txt_Origin, data_Origin);
        enterKeys(txt_Destination, data_Destination);
        enterKeys(txt_Peices, data_No_Pieces_HAWB1);
        enterKeys(txt_Weight, data_Weight_HAWB1);
        enterKeys(txt_Peices, data_No_Pieces_HAWB1);
        enterKeys(txt_ShipmentDesc, "House1");
        click(Btn_NewHouse);

        minWait();
        enterKeys(txt_HAWBNo, data_HAWBNo2 + Keys.TAB);
        minWait();
        enterKeys(txt_ShipperCode, data_ShipperCode);
        enterKeys(txt_ConsigneeCode, data_ConsigneeCode);
        enterKeys(txt_Origin, data_Origin);
        enterKeys(txt_Destination, data_Destination);
        enterKeys(txt_Peices, data_No_Pieces_HAWB2);
        enterKeys(txt_Weight, data_Weight_HAWB2);
        enterKeys(txt_ShipmentDesc, "House2");
        minWait();
        click(Btn_OK);
        //switch back to main window
        minWait();
        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);
        click(btn_save);
        minWait();
        waitForPageLoaded();
        driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(info_footer).getText().contains("HAWB details saved successfully"), "ERROR : Houses not saved.");
        waitForFrameAndSwitch(FRAME);
        return this;
    }

    /**
     * Created by A-7605 on 19-2-18
     * This method will add single house to the AWB
     *
     * @param awbNo
     * @param awbNoPrefix
     * @param shipperCode
     * @param consigneeCode
     * @param origin
     * @param destination
     * @param pieces
     * @param weight
     * @param hawbNo
     * @return
     */
    public OPR029 addOneHAWB(String awbNo, String awbNoPrefix, String shipperCode,
                             String consigneeCode, String origin, String destination, String pieces, String weight, String hawbNo) {


        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        awbNoPrefix = PropertyHandler.getPropValue(dataFilePath, awbNoPrefix);
        shipperCode = PropertyHandler.getPropValue(dataFilePath, shipperCode);
        consigneeCode = PropertyHandler.getPropValue(dataFilePath, consigneeCode);
        origin = PropertyHandler.getPropValue(dataFilePath, origin);
        destination = PropertyHandler.getPropValue(dataFilePath, destination);
        pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
        weight = PropertyHandler.getPropValue(dataFilePath, weight);
        hawbNo = PropertyHandler.getPropValue(dataFilePath, hawbNo);

        enterKeys(txt_awbNo, awbNo);
        click(btn_list);
//        click(div_infoClose);
        minWait();
        click(Link_Add);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();
        click(txt_HAWBNo);
        enterKeys(txt_HAWBNo, hawbNo + Keys.TAB);
        minWait();
        enterKeys(txt_ShipperCode, shipperCode);
        enterKeys(txt_ConsigneeCode, consigneeCode);
        enterKeys(txt_Origin, origin);
        enterKeys(txt_Destination, destination);
        enterKeys(txt_Peices, pieces);
        enterKeys(txt_Weight, weight);
        enterKeys(txt_ShipmentDesc, "House1");
        minWait();
        click(Btn_OK);
        //switch back to main window
        minWait();
        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);
        click(btn_save);
        minWait();
        driver.switchTo().defaultContent();
        try{
        	new WebDriverWait(driver, 30).until(ExpectedConditions.textToBePresentInElement(waitForElement(info_footer), "HAWB details saved successfully"));
        }catch(Exception e){
        	Assert.fail("ERROR : Houses not saved.",e);
        }
//        Assert.assertTrue(waitForElement(info_footer).getText().contains("HAWB details saved successfully"), "ERROR : Houses not saved.");
        waitForFrameAndSwitch(FRAME);
        return this;
    }

    public HomePage close() {
        logger.info("Closing OPR029 screen");
        click(btn_close);
        logger.info("OPR029 screen closed");
        driver.switchTo().defaultContent();

        return new HomePage(driver, dataFileName);
    }
    
    /*
	 * A-8255
	 */
	 
	 public OPR029 addHAWBWithoutConsole(boolean isConsol,String awbNo, String awbNoPrefix, String shipperCode, 
	    		String consigneeCode, String origin,String destination, String pieces,String weight, String hawbNo){
		 
	 
		 awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		 awbNoPrefix = PropertyHandler.getPropValue(dataFilePath, awbNoPrefix);
		 shipperCode = PropertyHandler.getPropValue(dataFilePath, shipperCode);
		 consigneeCode = PropertyHandler.getPropValue(dataFilePath, consigneeCode);
		 origin = PropertyHandler.getPropValue(dataFilePath, origin);
		 destination = PropertyHandler.getPropValue(dataFilePath, destination);
		 pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		 weight = PropertyHandler.getPropValue(dataFilePath, weight);
		 hawbNo = PropertyHandler.getPropValue(dataFilePath, hawbNo);

		 enterKeys(txt_awbNo, awbNo);
		 click(btn_list);
		 click(div_infoClose);
		 minWait();
		 if(!isConsol)
		 {
			 
			 driver.switchTo().defaultContent();
			 waitForElement(msg_popup).getText().contains("Do you want to mark it as consol?");
			  click(yesBtn);
		 }
		 waitForFrameAndSwitch(FRAME);
		 click(Link_Add);
		 driver.switchTo().defaultContent();
		 waitForNewWindow(2);
		 switchToSecondWindow();  
		 click(txt_HAWBNo);
		 enterKeys(txt_HAWBNo, hawbNo +Keys.TAB);
		 minWait();
		 enterKeys(txt_ShipperCode, shipperCode);
		 enterKeys(txt_ConsigneeCode, consigneeCode);
		 enterKeys(txt_Origin, origin);
		 enterKeys(txt_Destination, destination);
		 enterKeys(txt_Peices, pieces);
		 enterKeys(txt_Weight, weight);
		 enterKeys(txt_ShipmentDesc, "House1");
		 minWait();
		 click(Btn_OK);
		 //switch back to main window
		  minWait();
		  switchToFirstWindow();
		
		  waitForFrameAndSwitch(FRAME);
		  click(btn_save);
		  driver.switchTo().defaultContent();
		  Assert.assertTrue(waitForElement(info_footer).getText().contains("HAWB details saved successfully"), "ERROR : Houses not saved.");
		  waitForFrameAndSwitch(FRAME);
		  return this;
	 }
	 
	 //shalini
	 public OPR029 generateHAWB(String key_awbNoPrefix, String key_awbNo, String HouseNo1, String HouseNo2,
			 String shipper,String consignee,String origin,String dest) {
		
	       String awbNoPrefix = PropertyHandler.getPropValue(dataFilePath, key_awbNoPrefix);
	        String awbNo = PropertyHandler.getPropValue(dataFilePath, key_awbNo);
	        HouseNo1 = PropertyHandler.getPropValue(dataFilePath, HouseNo1);
	        HouseNo2 = PropertyHandler.getPropValue(dataFilePath, HouseNo2);
	        shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
	       consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
	       origin = PropertyHandler.getPropValue(dataFilePath, origin);
	       dest = PropertyHandler.getPropValue(dataFilePath, dest);

	         enterKeys(txt_awbPrefix, awbNoPrefix);
	        enterKeys(txt_awbNo, awbNo);
	        click(btn_list);
	        minWait();
	        minWait();	      
	        minWait();
	        driver.switchTo().defaultContent();
	        //to handle consol popup
	        if (verifyElementPresent(btn_genericYes))
	            click(btn_genericYes);
	        waitForFrameAndSwitch(FRAME);
	        minWait();
	        click(Link_Add);
	        driver.switchTo().defaultContent();
	        waitForNewWindow(2);
	        switchToSecondWindow();
	        click(txt_HAWBNo);
	        enterKeys(txt_HAWBNo, HouseNo1);
	        minWait();
	        driver.findElement(By.xpath("(//span[@class='ic-label'])[1]")).click();
	       // click(txt_ShipperCode);
	        enterKeys(txt_ShipperCode, shipper);
	        enterKeys(txt_ConsigneeCode, consignee);
	        enterKeys(txt_Origin, origin);
	        enterKeys(txt_Destination, dest);
	        enterKeys(txt_Peices, "5");
	        enterKeys(txt_Weight, "50");
	        enterKeys(txt_ShipmentDesc, "House1");
	        click(Btn_NewHouse);

	        minWait();
	        enterKeys(txt_HAWBNo,HouseNo2);
	        minWait();
	        driver.findElement(By.xpath("(//span[@class='ic-label'])[1]")).click();
	       // click(txt_ShipperCode);
	        enterKeys(txt_ShipperCode, shipper);
	        enterKeys(txt_ConsigneeCode, consignee);
	        enterKeys(txt_Origin, origin);
	        enterKeys(txt_Destination, dest);
	        enterKeys(txt_Peices, "5");
	        enterKeys(txt_Weight, "50");
	        enterKeys(txt_ShipmentDesc, "House2");
	        minWait();
	        click(Btn_OK);
	        //switch back to main window
	        minWait();
	        switchToFirstWindow();

	        waitForFrameAndSwitch(FRAME);
	        click(btn_save);
	        minWait();
			return this;
	 }
	 
	 
	//Faizan
     public OPR029 generateHAWBTestDataCreation(String key_awbNoPrefix, String key_awbNo, String HouseNo1, String HouseNo2,
                   String house1Shipper, String house1Consignee,
                   String house1Origin, String house1Dest, String house1Pcs, String house1Wt, String house1SlacPcs,
                   String house2Shipper, String house2Consignee,
                   String house2Origin, String house2Dest, String house2Pcs, String house2Wt, String house2SlacPcs) {
            
              enterKeys(txt_awbPrefix, key_awbNoPrefix);
              key_awbNo=PropertyHandler.getPropValue(dataFilePath, key_awbNo);
             enterKeys(txt_awbNo, key_awbNo);
             click(btn_list);
             minWait();
             minWait();        
             minWait();
             driver.switchTo().defaultContent();
             //to handle consol popup
             if (verifyElementPresent(By.xpath("//button[contains(text(),'Yes')]")))
                 //click(btn_genericYes);
                  click(By.xpath("//button[contains(text(),'Yes')]"));
             waitForFrameAndSwitch(FRAME);
             minWait();
             click(Link_Add);
             driver.switchTo().defaultContent();
             waitForNewWindow(2);
             switchToSecondWindow();
             if(!HouseNo1.equals(""))
             {
             click(txt_HAWBNo);
             enterKeys(txt_HAWBNo, HouseNo1);
             minWait();
             driver.findElement(By.xpath("(//span[@class='ic-label'])[1]")).click();
            // click(txt_ShipperCode);
             
             enterKeys(txt_ShipperCode, house1Shipper+Keys.TAB);
             minWait();
             enterKeys(txt_ConsigneeCode, house1Consignee+Keys.TAB);
             minWait();
             enterKeys(txt_Origin, house1Origin);     
             enterKeys(txt_Destination, house1Dest);
             enterKeys(txt_Peices, house1Pcs);    //to Add
             enterKeys(txt_Weight, house1Wt); 
             
             // to Add House1 slac Pcs  
             //input[@name='slacPieces']
             if(!house1SlacPcs.equals(""))
                  enterKeys(By.xpath("//input[@name='slacPieces']"), house1SlacPcs);
             enterKeys(txt_ShipmentDesc, "House1");
             maxWait();
             if(!HouseNo2.equals(""))
             {
             click(Btn_NewHouse);
             minWait();
             enterKeys(txt_HAWBNo,HouseNo2);
             minWait();
             driver.findElement(By.xpath("(//span[@class='ic-label'])[1]")).click();
            // click(txt_ShipperCode);
             enterKeys(txt_ShipperCode, house2Shipper);
             enterKeys(txt_ConsigneeCode, house2Consignee);
             enterKeys(txt_Origin, house2Origin);
             enterKeys(txt_Destination, house2Dest);
             enterKeys(txt_Peices, house2Pcs);
             enterKeys(txt_Weight, house2Wt);
          // to Add House2 slac Pcs
             if(!house2SlacPcs.equals(""))
                  enterKeys(By.xpath("//input[@name='slacPieces']"), house2SlacPcs);
             enterKeys(txt_ShipmentDesc, "House2");
             maxWait();
             }
             }//house1 close
             click(Btn_OK);
             //switch back to main window
             minWait();
             switchToFirstWindow();

             waitForFrameAndSwitch(FRAME);
             click(btn_save);
             minWait();
                   return this;
     }

}
