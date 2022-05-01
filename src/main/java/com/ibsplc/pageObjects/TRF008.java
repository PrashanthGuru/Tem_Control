package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

public class TRF008 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "SHR_TRF.properties");
    public static String genFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String filepath;
    public static String FRAME = "iCargoContentFrameTRF008";
    public String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    WebDriver driver;
    String testDataFile;
    private By
            txt_rateid,
            btn_list,
            btn_add,
            txt_rateorigin,
            txt_ratedest,
            txt_M_rate,
            txt_N_rate,
            txt_Q_wgt,
            txt_Q_rate,
            btn_close,
            btn_popok,
            btn_tab1,
            btn_tab2,
            txt_currency,
            btn_save,
            dropdown_rating,
            txt_variance,
            txt_handlingcode,
            txt_commodity,
            txt_rateiddes,
            dropdown_originlevel,
            txt_station,
            txt_description,
            btn_clear,
            chk_ratecard,
            list_txt_ParameterValue,
            chkbox_allInRate,
            dropdown_allInRateAttributes,
            yesBtn,
            btn_noBtn,
            chkbox_IATA,
            dropdown_rateCardType,
            dropdown_FlightType,
            info_msg,
            txt_flightnum,
            txt_parcommodity,
            txt_parstation,
            txt_airline,
            txt_uniqueReference1;

    public TRF008(WebDriver driver, String testDataFile) {
        super(driver);
        this.driver = driver;
        this.testDataFile = testDataFile;
        PageFactory.initElements(this.driver, this);
        filepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory") + testDataFile;
        initPageElements();
    }


    private void initPageElements() {


        txt_description = MiscUtility.getWebElement(objFilepath, "TRF008_txt_description");
        btn_list = MiscUtility.getWebElement(objFilepath, "TRF008_btn_list");
        btn_add = MiscUtility.getWebElement(objFilepath, "TRF008_btn_add");
        txt_rateorigin = MiscUtility.getWebElement(objFilepath, "TRF008_txt_rateorigin");
        txt_ratedest = MiscUtility.getWebElement(objFilepath, "TRF008_txt_dest");
        txt_M_rate = MiscUtility.getWebElement(objFilepath, "TRF008_txt_M_rate");
        txt_N_rate = MiscUtility.getWebElement(objFilepath, "TRF008_txt_N_rate");
        txt_Q_wgt = MiscUtility.getWebElement(objFilepath, "TRF008_txt_Q_wgt");
        txt_Q_rate = MiscUtility.getWebElement(objFilepath, "TRF008_txt_Q_rate");
        btn_popok = MiscUtility.getWebElement(objFilepath, "TRF008_btn_popok");
        btn_tab1 = MiscUtility.getWebElement(objFilepath, "TRF008_btn_tab1");
        btn_tab2 = MiscUtility.getWebElement(objFilepath, "TRF008_btn_tab1");
        txt_currency = MiscUtility.getWebElement(objFilepath, "TRF008_txt_currency");
        btn_save = MiscUtility.getWebElement(objFilepath, "TRF008_btn_save");
        dropdown_rating = MiscUtility.getWebElement(objFilepath, "TRF008_dropdown_rating");
        txt_variance = MiscUtility.getWebElement(objFilepath, "TRF008_txt_variance");
        txt_handlingcode = MiscUtility.getWebElement(objFilepath, "TRF008_txt_handlingcode");
        txt_commodity = MiscUtility.getWebElement(objFilepath, "TRF008_txt_commodity");
        btn_close = MiscUtility.getWebElement(objFilepath, "TRF008_btn_close");
        yesBtn = MiscUtility.getWebElement(objFilepath, "TRF008_yesBtn");
        dropdown_originlevel = MiscUtility.getWebElement(objFilepath, "TRF008_dropdown_originlevel");
        txt_station = MiscUtility.getWebElement(objFilepath, "TRF008_txt_station");
        btn_clear = MiscUtility.getWebElement(objFilepath, "TRF008_btn_clear");
        chk_ratecard = MiscUtility.getWebElement(objFilepath, "TRF008_chk_ratecard");
        list_txt_ParameterValue = MiscUtility.getWebElement(objFilepath, "TRF008_list_txt_ParameterValue");
        yesBtn = MiscUtility.getWebElement(genFilepath, "Generic_btn_diaYes");
        btn_noBtn = MiscUtility.getWebElement(genFilepath, "Generic_btn_noBtn");
        info_msg = MiscUtility.getWebElement(genFilepath, "Generic_info_msg");
        txt_rateid = MiscUtility.getWebElement(objFilepath, "TRF008_txt_rateid");
        chkbox_IATA = MiscUtility.getWebElement(objFilepath, "TRF008_chkbox_IATA");
        chkbox_allInRate = MiscUtility.getWebElement(objFilepath, "TRF008_chkbox_allInRate");
        dropdown_allInRateAttributes = MiscUtility.getWebElement(objFilepath, "TRF008_dropdown_allInRateAttributes");
        dropdown_rateCardType = MiscUtility.getWebElement(objFilepath, "TRF008_dropdown_rateCardType");
        dropdown_FlightType = MiscUtility.getWebElement(objFilepath, "TRF008_dropdown_FlightType");
        //A-8255
        txt_flightnum = MiscUtility.getWebElement(objFilepath, "TRF008_txt_flightnum");
        txt_parcommodity = MiscUtility.getWebElement(objFilepath, "TRF008_txt_parcommodity");
        txt_parstation = MiscUtility.getWebElement(objFilepath, "TRF008_txt_parstation");
    
        /*txt_airline                       =MiscUtility.getWebElement(objFilepath, "TRF008_txt_airline");
        txt_uniqueReference1              =MiscUtility.getWebElement(objFilepath, "TRF008_txt_uniqueReference1");
    */
    
    
    }

    public TRF008 RCardcreate(String rateid) {
        //String data_rateid ;
        String rand_rateid;
        while (true) {
            rand_rateid = BizUtility.createFlightNum();
            enterKeys(txt_rateid, rand_rateid);
            click(btn_list);
            driver.switchTo().defaultContent();
            minWait();
            if (verifyElementPresent(yesBtn)) {
                click(yesBtn);
                waitForFrameAndSwitch(FRAME);
                break;
            }
            waitForFrameAndSwitch(FRAME);

        }
        PropertyHandler.setPropValue(filepath, "rateid", rand_rateid);
        return this;
    }

    /**
     * @param RateCardId
     * @param origin
     * @param dest
     * @param currency
     * @param iscreate
     * @return Author A-6784
     */
    public TRF008 MaintainRateCardNew(String RateCardId, String origin, String dest, String currency, String type, boolean iscreate) {

        origin = PropertyHandler.getPropValue(filepath, origin);


        dest = PropertyHandler.getPropValue(filepath, dest);
        String data_currency = PropertyHandler.getPropValue(filepath, currency);

        String rand_rateid = BizUtility.createFlightNum();
        enterKeys(txt_rateid, rand_rateid);

	
/*if(type.equals("IATA"))	{
	check(chkbox_IATA);
}
	click(btn_add);
	minWait();
	driver.switchTo().defaultContent();
    if (verifyElementPresent(yesBtn)) {

          click(yesBtn);
           }
	 driver.switchTo().defaultContent();
      waitForNewWindow(2);
      switchToSecondWindow();               


      enterKeys(txt_rateorigin,origin);
      enterKeys(txt_ratedest,dest);
	enterKeys(txt_currency,data_currency);
	
	enterKeys(txt_M_rate,"10");
	enterKeys(getWebElements(txt_N_rate).get(1), "10");*/

        click(btn_list);

        minWait();

        driver.switchTo().defaultContent();
        waitForElement(info_msg).getText().contains("Rate card doesn't exist. Do you want to create?");

        if (iscreate) {
            click(yesBtn);
            waitForFrameAndSwitch(FRAME);
minWait();
           
            enterKeys(txt_description, "Automation");


            if (type.equals("IATA")) {
                check(chkbox_IATA);
            }
            click(btn_add);
            minWait();
            driver.switchTo().defaultContent();
            if (verifyElementPresent(yesBtn)) {

                click(yesBtn);
            }
            driver.switchTo().defaultContent();
            waitForNewWindow(2);
            switchToSecondWindow();


            enterKeys(txt_rateorigin, origin);
            enterKeys(txt_ratedest, dest);
            enterKeys(txt_currency, data_currency);

            enterKeys(txt_M_rate, "10");
            enterKeys(getWebElements(txt_N_rate).get(1), "10");
            enterKeys(txt_N_rate, "10");


            //enterKeys(txt_Q_rate,"10");
            //	enterKeys(txt_Q_wgt,"10");
            enterKeys(getWebElements(txt_Q_rate).get(2), "10");
            enterKeys(getWebElements(txt_Q_wgt).get(2), "10");
            click(btn_popok);

            minWait();
            switchToFirstWindow();
            waitForFrameAndSwitch(FRAME);
            check(chk_ratecard);
            
            String rate = waitForElementVisible(txt_rateid).getAttribute("value");
            PropertyHandler.setPropValue(filepath, RateCardId, rate);

            click(btn_save);


            return this;

        } else {
            click(btn_noBtn);

        }
        return this;

    }

    public TRF008 MaintainRateCardTruck(String RateCardId ,String origin,String dest,String currency,String type,String RateCardType){
 	   
    	origin = PropertyHandler.getPropValue(filepath,origin);
    	
    	
    	dest = PropertyHandler.getPropValue(filepath,dest);
        String data_currency = PropertyHandler.getPropValue(filepath,currency);

        String rand_rateid = BizUtility.createFlightNum();
        enterKeys(txt_rateid, rand_rateid);


    	click(btn_list);
    	
    	minWait(); 
    	
       	driver.switchTo().defaultContent();
       	waitForElement(info_msg).getText().contains("Rate card doesn't exist. Do you want to create?");
                         

      	  		click(yesBtn);
                waitForFrameAndSwitch(FRAME);
       
               
                enterKeys(txt_description, "Automation");
    	
    	
    	
    if(type.equals("IATA"))	{
    	check(chkbox_IATA);
    }

     //   selectByText(dropdown_rateCardType, RateCardType);
        
    	click(btn_add);
    	minWait();
    	driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

              click(yesBtn);
               }
    	 driver.switchTo().defaultContent();
          waitForNewWindow(2);
          switchToSecondWindow();               


          enterKeys(txt_rateorigin,origin);
          enterKeys(txt_ratedest,dest);
    	enterKeys(txt_currency,data_currency);
    	
    	enterKeys(txt_M_rate,"10");
    	maxWait();
    	enterKeys(txt_N_rate,"10");
    	
    	
    	
    	enterKeys(txt_Q_rate,"10");
    	enterKeys(txt_Q_wgt,"10");
    	
       scrollToView(dropdown_FlightType);
       selectByText(dropdown_FlightType, "Truck");
    	click(btn_popok);

    	 minWait();
         switchToFirstWindow();
         waitForFrameAndSwitch(FRAME);
         check(chk_ratecard);
         String rate = waitForElement(txt_rateid).getAttribute("value");
         PropertyHandler.setPropValue(filepath, RateCardId, rate);
         
         
    	 click(btn_save);
    	
    	
    	
    		
    	
    	return this;
    	
    }


    public TRF008 MaintainRateCardNewAllinRate(String RateCardId, String origin, String dest, String currency, String type, String allinAttribute) {

        origin = PropertyHandler.getPropValue(filepath, origin);


        dest = PropertyHandler.getPropValue(filepath, dest);
        String data_currency = PropertyHandler.getPropValue(filepath, currency);

        String rand_rateid = BizUtility.createFlightNum();
        enterKeys(txt_rateid, rand_rateid);


        click(btn_list);

        minWait();

        driver.switchTo().defaultContent();
        waitForElement(info_msg).getText().contains("Rate card doesn't exist. Do you want to create?");


        click(yesBtn);
        waitForFrameAndSwitch(FRAME);

        String rate = waitForElement(txt_rateid).getAttribute("value");
        PropertyHandler.setPropValue(filepath, RateCardId, rate);

        enterKeys(txt_description, "Automation");


        if (type.equals("IATA")) {
            check(chkbox_IATA);
        }
        click(btn_add);
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();


        enterKeys(txt_rateorigin, origin);
        enterKeys(txt_ratedest, dest);
        enterKeys(txt_currency, data_currency);
        check(chkbox_allInRate);

        if (allinAttribute.equals("Null")) {
            minWait();
        } else {
            selectByText(dropdown_allInRateAttributes, allinAttribute);
        }

        enterKeys(txt_M_rate, "10");
        enterKeys(getWebElements(txt_Q_rate).get(1), "10");
        //enterKeys(txt_N_rate,"10");


        //enterKeys(txt_Q_rate,"10");
        //	enterKeys(txt_Q_wgt,"10");
        enterKeys(getWebElements(txt_Q_rate).get(2), "10");
        enterKeys(getWebElements(txt_Q_wgt).get(2), "10");
        click(btn_popok);

        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        check(chk_ratecard);
        click(btn_save);

        return this;

    }

    public TRF008 RCard(String ratedes, String level, String origin, String dest, String currency) {

        String data_rateiddes = PropertyHandler.getPropValue(filepath, ratedes);
        String data_level = PropertyHandler.getPropValue(filepath, level);
        String data_origin = PropertyHandler.getPropValue(filepath, origin);

        String data_dest = PropertyHandler.getPropValue(filepath, dest);
        String data_currency = PropertyHandler.getPropValue(filepath, currency);

        //enterKeys(txt_rateid,data_rateid);


        click(btn_list);

        minWait();

        driver.switchTo().defaultContent();
        {

            if (verifyElementPresent(yesBtn))
                click(yesBtn);
            waitForFrameAndSwitch(FRAME);

        }
        enterKeys(txt_rateiddes, data_rateiddes);

        selectByText(dropdown_originlevel, data_level);
        enterKeys(txt_rateorigin, data_origin);

        click(btn_add);
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();


        enterKeys(txt_ratedest, data_dest);
        enterKeys(txt_currency, data_currency);

        return this;

    }

    public TRF008 comm(String commodity1, String station) {
        String data_commodity = PropertyHandler.getPropValue(filepath, commodity1);
        String data_stn = PropertyHandler.getPropValue(filepath, station);

        enterKeys(txt_commodity, data_commodity);
        enterKeys(txt_station, data_stn);
        return this;
    }

    public TRF008 RCard_PC014(String Mrate, String Nrate, String Qwgt, String Qrate) {
        String data_M_rate = PropertyHandler.getPropValue(filepath, Mrate);

        String data_N_rate = PropertyHandler.getPropValue(filepath, Nrate);

        String data_Q_wgt = PropertyHandler.getPropValue(filepath, Qwgt);
        String data_Q_rate = PropertyHandler.getPropValue(filepath, Qrate);
        enterKeys(txt_M_rate, data_M_rate);
        enterKeys(txt_N_rate, data_N_rate);

        //enterKeys(txt_N_rate,Keys.TAB);
        //enterKeys(btn_tab1,Keys.TAB);
        //enterKeys(btn_tab2,Keys.TAB);
        //enterKeys(txt_Q_wgt,Keys.TAB);

        enterKeys(txt_Q_rate, data_Q_rate);
        enterKeys(txt_Q_wgt, data_Q_wgt);
        click(btn_popok);

        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        check(chk_ratecard);
        click(btn_save);

        return this;
    }

    public TRF008 RCard_PC016(String variance, String handlingcode, String commodity) {

        String data_variance = PropertyHandler.getPropValue(filepath, variance);
        String data_handlingcode = PropertyHandler.getPropValue(filepath, handlingcode);
        String data_commodity = PropertyHandler.getPropValue(filepath, commodity);

        selectByIndex(dropdown_rating, 2);
        enterKeys(txt_variance, data_variance);

        enterKeys(txt_handlingcode, data_handlingcode);
        enterKeys(txt_commodity, data_commodity);
        click(btn_popok);


        minWait();
        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        check(chk_ratecard);
        click(btn_save);
        return this;
    }


    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, testDataFile);
    }

    /*
     * A-8255
     */
    public TRF008 MaintainRateCardNewWithRatingBasis(String RatingBasis, String RateCardId, String origin, String dest, String currency, String type, boolean iscreate, String flightnum, String commcode, String station, boolean ratingwithfilghtnum, boolean ratingwithcommandstation) {

        origin = PropertyHandler.getPropValue(filepath, origin);


        dest = PropertyHandler.getPropValue(filepath, dest);
        String data_currency = PropertyHandler.getPropValue(filepath, currency);
        RatingBasis = PropertyHandler.getPropValue(filepath, RatingBasis);
        type = PropertyHandler.getPropValue(filepath, type);

        String rand_rateid = BizUtility.createFlightNum();
        enterKeys(txt_rateid, rand_rateid);


        click(btn_list);

        minWait();

        driver.switchTo().defaultContent();
        waitForElement(info_msg).getText().contains("Rate card doesn't exist. Do you want to create?");

        if (iscreate) {
            click(yesBtn);
            waitForFrameAndSwitch(FRAME);

            String rate = waitForElement(txt_rateid).getAttribute("value");
            PropertyHandler.setPropValue(filepath, RateCardId, rate);

            enterKeys(txt_description, "Automation");


            if (type.equals("IATA")) {
                check(chkbox_IATA);
            }
            click(btn_add);
            minWait();
            driver.switchTo().defaultContent();
            if (verifyElementPresent(yesBtn)) {

                click(yesBtn);
            }
            driver.switchTo().defaultContent();
            switchToSecondWindow();


            enterKeys(txt_rateorigin, origin);
            enterKeys(txt_ratedest, dest);
            enterKeys(txt_currency, data_currency);
            selectByText(dropdown_rating, RatingBasis);

            if (ratingwithfilghtnum) {
                flightnum = PropertyHandler.getPropValue(filepath, flightnum);
                scrollToView(txt_flightnum);
                enterKeys(txt_flightnum, flightnum);
            }

            if (ratingwithcommandstation) {
                commcode = PropertyHandler.getPropValue(filepath, commcode);
                station = PropertyHandler.getPropValue(filepath, station);
                scrollToView(txt_parcommodity);
                enterKeys(txt_parcommodity, commcode);

                scrollToView(txt_parstation);
                enterKeys(txt_parstation, station);

            }

            enterKeys(txt_M_rate, "10");
            enterKeys(getWebElements(txt_N_rate).get(1), "10");
            enterKeys(txt_N_rate, "10");


            //enterKeys(txt_Q_rate,"10");
            //	enterKeys(txt_Q_wgt,"10");
            enterKeys(getWebElements(txt_Q_rate).get(2), "10");
            enterKeys(getWebElements(txt_Q_wgt).get(2), "10");
            click(btn_popok);

            minWait();
            switchToFirstWindow();
            waitForFrameAndSwitch(FRAME);
            check(chk_ratecard);
            click(btn_save);


            return this;

        } else {
            click(btn_noBtn);

        }
        return this;

    }
    
    
    
    public TRF008 changeAirlineAndMaintainRateCardNew(String RateCardId ,String origin,String dest,String currency,String type,boolean iscreate,String airline){
 	   
    	origin = PropertyHandler.getPropValue(filepath,origin);
    	airline = PropertyHandler.getPropValue(filepath,airline);
    	
    	dest = PropertyHandler.getPropValue(filepath,dest);
        String data_currency = PropertyHandler.getPropValue(filepath,currency);

        String rand_rateid = BizUtility.createFlightNum();
        enterKeys(txt_rateid, rand_rateid);


    	click(btn_list);
    	
    	minWait(); 
    	
       	driver.switchTo().defaultContent();
       	waitForElement(info_msg).getText().contains("Rate card doesn't exist. Do you want to create?");
                         
    if(iscreate) {
      	  		click(yesBtn);
                waitForFrameAndSwitch(FRAME);
       
                String rate = waitForElement(txt_rateid).getAttribute("value");
                PropertyHandler.setPropValue(filepath, RateCardId, rate);
                
                enterKeys(txt_description, "Automation");
                enterKeys(txt_airline,airline);
    	
    	
    if(type.equals("IATA"))	{
    	check(chkbox_IATA);
    }
    	click(btn_add);
    	minWait();
    	driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

              click(yesBtn);
               }
    	 driver.switchTo().defaultContent();
          waitForNewWindow(2);
          switchToSecondWindow();               


          enterKeys(txt_rateorigin,origin);
          enterKeys(txt_ratedest,dest);
    	enterKeys(txt_currency,data_currency);
    	
    	enterKeys(txt_M_rate,"10");
    	maxWait();
    	enterKeys(txt_N_rate,"10");
    	
    	
    	
    	enterKeys(txt_Q_rate,"10");
    	enterKeys(txt_Q_wgt,"10");
    	click(btn_popok);

    	 minWait();
         switchToFirstWindow();
         waitForFrameAndSwitch(FRAME);
         check(chk_ratecard);
    	 click(btn_save);
    	
    	
    	return this; 		

    }
                   
    else{
    		click(btn_noBtn);
    		
    	}
    	return this;
    	
    }




    //A-8254 jiljo





   

    public TRF008 MaintainRateCardUniqueReference(String RateCardId ,String origin,String dest,String currency,String type,String uniqueReference1){
    	   
    	origin = PropertyHandler.getPropValue(filepath,origin);
    	uniqueReference1 = PropertyHandler.getPropValue(filepath,uniqueReference1);
    	
    	dest = PropertyHandler.getPropValue(filepath,dest);
        String data_currency = PropertyHandler.getPropValue(filepath,currency);

        String rand_rateid = BizUtility.createFlightNum();
        enterKeys(txt_rateid, rand_rateid);


    	click(btn_list);
    	
    	minWait(); 
    	
       	driver.switchTo().defaultContent();
       	waitForElement(info_msg).getText().contains("Rate card doesn't exist. Do you want to create?");
                         

      	  		click(yesBtn);
                waitForFrameAndSwitch(FRAME);
       
                String rate = waitForElement(txt_rateid).getAttribute("value");
                PropertyHandler.setPropValue(filepath, RateCardId, rate);
                
                enterKeys(txt_description, "Automation");
    	
    	
    	
    if(type.equals("IATA"))	{
    	check(chkbox_IATA);
    }

     
        
    	click(btn_add);
    	minWait();
    	driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

              click(yesBtn);
               }
    	 driver.switchTo().defaultContent();
          waitForNewWindow(2);
          switchToSecondWindow();               


          enterKeys(txt_rateorigin,origin);
          enterKeys(txt_ratedest,dest);
    	enterKeys(txt_currency,data_currency);
    	
    	enterKeys(txt_M_rate,"10");
    	maxWait();
    	enterKeys(txt_N_rate,"10");
    	
    	
    	
    	enterKeys(txt_Q_rate,"10");
    	enterKeys(txt_Q_wgt,"10");
    	
      // scrollToView(dropdown_FlightType);
     //  selectByText(dropdown_FlightType, "Truck");
    	enterKeys(txt_uniqueReference1,uniqueReference1);
    	click(btn_popok);

    	 minWait();
         switchToFirstWindow();
         waitForFrameAndSwitch(FRAME);
         check(chk_ratecard);
    	 click(btn_save);
    	
    	
    	
    		
    	
    	return this;
    	
    }

  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}