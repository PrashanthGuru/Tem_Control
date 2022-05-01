package com.ibsplc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.common.BaseSetup;
import com.ibsplc.generic.Assertion;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Created by a-7681 on 9/13/2017.
 */
public class HomePage extends BasePage {

    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");

   public static WebDriver driver;
    By txt_screenId,
            header_panel, btn_editIcon, btn_switchRole, btn_station, btn_ok;
    private String dataFileName;
    public String dataFilePath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "testDataDirectory");

    public HomePage(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFileName = dataFileName;
        this.dataFilePath = dataFilePath + dataFileName;
    }

    private void initElements() {
        txt_screenId = MiscUtility.getWebElement(genObjPath, "homeScreen_screenID");
        header_panel = MiscUtility.getWebElement(genObjPath, "homeScreen_headerPanel");
        btn_editIcon = MiscUtility.getWebElement(genObjPath,
				"homeScreen_btn_editIcon");

		btn_switchRole = MiscUtility.getWebElement(genObjPath,
				"homeScreen_btn_switchRole");
		btn_station = MiscUtility.getWebElement(genObjPath,
				"homeScreen_btn_station");
		btn_ok = MiscUtility.getWebElement(genObjPath, "homeScreen_btn_ok");
    }
    


    //    public CUS032 goToCUS032() {
//        minWait();
//        waitForElement(txt_screenId).clear();
//        waitForElement(txt_screenId).sendKeys("CUS032" + Keys.RETURN);
//        waitForElement(header_panel).click();
//        waitForFrameAndSwitch("iCargoContentFrameCUS032");
//        minWait();
//        return new CUS032(driver);
//    }
    public ULD016 goToULD016() {
        tabPress(4);
        enterKeys(txt_screenId, "ULD016" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD016");
        minWait();
        return new ULD016(driver, dataFileName);
    }
    public CAP009 goToCAP009() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP009" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP009");
        minWait();
        return new CAP009(driver, dataFileName);
    }
    
    public CRA079 goToCRA079() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA079" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA079");
        minWait();
        return new CRA079(driver, dataFileName);
    }

    public SHR046 goToSHR046() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR046" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR046");
        minWait();
        return new SHR046(driver, dataFileName);
    }
    public CRA033 goToCRA033() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA033" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA033");
        minWait();
        return new CRA033(driver, dataFileName);
    }
    public CRA174 goToCRA174() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA174" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA174");
        minWait();
        return new CRA174(driver, dataFileName);
    }

    public CRA055 goToCRA055() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA055" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA055");
        minWait();
        return new CRA055(driver, dataFileName);
    }
    public CRA026 goToCRA026() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA026" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA026");
        minWait();
        return new CRA026(driver, dataFileName);
    }
    public CRA178 goToCRA178() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA178" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA178");
        minWait();
        return new CRA178(driver, dataFileName);
    }
    
    public CRA179 goToCRA179() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA179" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA179");
        minWait();
        return new CRA179(driver, dataFileName);
    }
  /*  public CRA048 goToCR048() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA048" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA048");
        minWait();
        return new CRA048(driver, dataFileName);
    }*/

    public CRA180 goToCRA180() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA180" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA180");
        minWait();
        return new CRA180(driver, dataFileName);
    }
    
    public CRA181 goToCRA181() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA181" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA181");
        minWait();
        return new CRA181(driver, dataFileName);
    }
    public CRA183 goToCRA183() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA183" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA183");
        minWait();
        return new CRA183(driver, dataFileName);
    }
    public CRA185 goToCRA185() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA185" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA185");
        minWait();
        return new CRA185(driver, dataFileName);
    }
    public CRA182 goToCRA182() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA182" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA182");
        minWait();
        return new CRA182(driver, dataFileName);
    }
    public CRA184 goToCRA184() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA184" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA184");
        minWait();
        return new CRA184(driver, dataFileName);
    }
    public OPR002 goToOPR002() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR002" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR002");
        minWait();
        return new OPR002(driver, dataFileName);
    }

    public OPR003 goToOPR003() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR003");
        minWait();
        return new OPR003(driver, dataFileName);
    }
    
    public CMT008 goToCMT008() {
        tabPress(4);
        enterKeys(txt_screenId, "CMT008" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCMT008");
        minWait();
        return new CMT008(driver, dataFileName);
    }

    public CRA170 goToCRA170() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA170" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA170");
        minWait();
        return new CRA170(driver, dataFileName);
    }

 
    public CRA041 goToCRA041() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA041" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA041");
        minWait();
        return new CRA041(driver, dataFileName);

  }
 
    public OPR162 goToOPR162() {
        enterKeys(txt_screenId,"OPR162" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR162");
        minWait();
        return new OPR162(driver, dataFileName);
    
    }
   public SHR050 goToSHR050() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR050" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR050");
        minWait();
        return new SHR050(driver, dataFileName);
    }


    public CRA038 goToCRA038() {
        tabPress(4);
        enterKeys(txt_screenId, "CRA038" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA038");
        minWait();
        return new CRA038(driver, dataFileName);
    }

    /*  public OPR003 goToOPR003() {
  tabPress(4);
          enterKeys(txt_screenId,"OPR003" + Keys.RETURN);
          click(header_panel);
          waitForFrameAndSwitch("iCargoContentFrameOPR003");
          minWait();
          return new OPR003(driver, dataFileName);
      }*/
    public OPR059 goToOPR059() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR059" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR059");
        minWait();
        return new OPR059(driver, dataFileName);
    }

    public OPR045 goToOPR045() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR045" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR045");
        minWait();
        return new OPR045(driver, dataFileName);
    }

    public OPR001 goToOPR001() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR001" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR001");
        minWait();
        return new OPR001(driver, dataFileName);
    }

    public CAP110 goToCAP110() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP110" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP110");
        minWait();
        return new CAP110(driver, dataFileName);
    }

    public CAP111 goToCAP111() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP111" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP111");
        minWait();
        return new CAP111(driver, dataFileName);
    }

    public ADM004 goToADM004() {
        tabPress(4);
        enterKeys(txt_screenId, "ADM004" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameADM004");
        minWait();
        return new ADM004(driver, dataFileName);
    }

    public SHR110 goToSHR110() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR110" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR110");
        minWait();
        return new SHR110(driver, dataFileName);
    }

    public SHR112 goToSHR112() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR112" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR112");
        minWait();
        return new SHR112(driver, dataFileName);
    }

    public SHR122 goToSHR122() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR122" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR122");
        minWait();
        return new SHR122(driver, dataFileName);
    }

    public CSH005 goToCSH005() {
        tabPress(4);
        enterKeys(txt_screenId, "CSH005" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCSH005");
        minWait();
        return new CSH005(driver, dataFileName);
    }
    
  public CSH004 goToCSH004() {
        enterKeys(txt_screenId,"CSH004" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCSH004");
        minWait();
        return new CSH004(driver, dataFileName);
    }

    public CSH007 goToCSH007() {
        enterKeys(txt_screenId,"CSH007" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCSH007");
        minWait();
        return new CSH007(driver, dataFileName);
    }
    
    public CSH009 goToCSH009() {
        enterKeys(txt_screenId,"CSH009" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCSH009");
        minWait();
        return new CSH009(driver, dataFileName);
    }
    public CSH013 goToCSH013() {
        enterKeys(txt_screenId,"CSH013" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCSH013");
        minWait();
        return new CSH013(driver, dataFileName);
    }


    public CSH003 goToCSH003() {
tabPress(4);
 enterKeys(txt_screenId,"CSH003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCSH003");
        minWait();
        return new CSH003(driver, dataFileName);
    }
    public ULD012 goToULD012() {
        tabPress(4);
        enterKeys(txt_screenId, "ULD012" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD012");
        minWait();
        return new ULD012(driver, dataFileName);
    }

    public ULD003 goToULD003() {
        tabPress(4);
        enterKeys(txt_screenId, "ULD003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD003");
        minWait();
        return new ULD003(driver, dataFileName);
    }

    public OPR010 goToOPR010() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR010" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR010");
        minWait();
        return new OPR010(driver, dataFileName);
    }

    public OPR007 goToOPR007() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR007" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR007");
        minWait();
        return new OPR007(driver, dataFileName);
    }
 public OPR212 goToOPR212() {
        enterKeys(txt_screenId,"OPR212" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR212");
        minWait();
        return new OPR212(driver, dataFileName);
    }

 public ULD005 goToULD005() {
        tabPress(4);
        enterKeys(txt_screenId, "ULD005" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD005");
        minWait();
        return new ULD005(driver, dataFileName);
    }

    public ULD004 goToULD004() {
        tabPress(4);
        enterKeys(txt_screenId, "ULD004" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD004");
        minWait();
        return new ULD004(driver, dataFileName);
    }

    public ULD008 goToULD008() {
        tabPress(4);
        enterKeys(txt_screenId, "ULD008" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD008");
        minWait();
        return new ULD008(driver, dataFileName);
    }

    public ULD028 goToULD028() {
        tabPress(4);
        enterKeys(txt_screenId, "ULD028" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD028");
        minWait();
        return new ULD028(driver, dataFileName);
    }

    public TRF025 goToTRF025() {
        tabPress(4);
        enterKeys(txt_screenId, "TRF025" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRF025");
        minWait();
        return new TRF025(driver, dataFileName);
    }

    public SHR003 goToSHR003() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR003");
        minWait();
        return new SHR003(driver, dataFileName);
    }

    public SHR006 goToSHR006() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR006" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR006");
        minWait();
        return new SHR006(driver, dataFileName);
    }

    public ULD040 goToULD040() {
        tabPress(4);
        enterKeys(txt_screenId, "ULD040" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD040");
        minWait();
        return new ULD040(driver, dataFileName);
    }

    public OPR015 goToOPR015() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR015" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR015");
        minWait();
        return new OPR015(driver, dataFileName);
    }

    public OPR039 goToOPR039() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR039" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR039");
        minWait();
        return new OPR039(driver, dataFileName);
    }
    
    public OPR276 goToOPR276() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR276" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR276");
        minWait();
        return new OPR276(driver, dataFileName);
    }
    
    public OPR040 goToOPR040() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR040" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR040");
        minWait();
        return new OPR040(driver, dataFileName);
    }

    public ULD015 goTOULD015() {
        enterKeys(txt_screenId, "ULD015" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD015");
        minWait();
        return new ULD015(driver, dataFileName);
    }

    public ULD018 goTOULD018() {
        enterKeys(txt_screenId, "ULD018" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD018");
        minWait();
        return new ULD018(driver, dataFileName);
    }

    public ULD001 goTOULD001() {
        enterKeys(txt_screenId, "ULD001" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD001");
        minWait();
        return new ULD001(driver, dataFileName);
    }

    public ULD025 goTOULD025() {
        enterKeys(txt_screenId, "ULD025" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD025");
        minWait();
        return new ULD025(driver, dataFileName);
    }

    public ULD011 goTOULD011() {
        enterKeys(txt_screenId, "ULD011" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD011");
        minWait();
        return new ULD011(driver, dataFileName);
    }

    public ULD014 goTOULD014() {
        enterKeys(txt_screenId, "ULD014" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD014");
        minWait();
        return new ULD014(driver, dataFileName);
    }

    public ULD007 goTOULD007() {
        enterKeys(txt_screenId, "ULD007" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD007");
        minWait();
        return new ULD007(driver, dataFileName);
    }

    public SHR028 goToSHR028() {
        enterKeys(txt_screenId, "SHR028" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR028");
        minWait();
        return new SHR028(driver, dataFileName);
    }

    public SHR036 goToSHR036() {
        enterKeys(txt_screenId, "SHR036" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR036");
        minWait();
        return new SHR036(driver, dataFileName);
    }

    public REC002 goToREC002() {
        enterKeys(txt_screenId, "REC002" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameREC002");
        minWait();
        return new REC002(driver, dataFileName);
    }

    public CAP018 goToCAP018() {
    	 minWait(); 
//         waitForWhiteScreen();
         waitForElement(txt_screenId).clear();
         waitForElement(txt_screenId).sendKeys("CAP018" + Keys.RETURN);
         waitForElement(header_panel).click();
         waitForFrameAndSwitch("iCargoContentFrameCAP018");
         minWait();  
         BaseSetup.test.log(LogStatus.INFO, "Opened the Booking(CAP018) Screen");
         return new CAP018(driver, dataFileName);
    }
    
    public CAP147 goToCAP147() {
   	 minWait(); 
        waitForWhiteScreen();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("CAP147" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameCAP147");
        minWait();  
        BaseSetup.test.log(LogStatus.INFO, "Opened the Booking(CAP147) Screen");
        return new CAP147(driver, dataFileName);
   }

    public CAP031 goToCAP031() {
        tabPress(4);
       enterKeys(txt_screenId, "CAP031" + Keys.RETURN);
       click(header_panel);
       waitForFrameAndSwitch("iCargoContentFrameCAP031");
       minWait();
       return new CAP031(driver, dataFileName);
   }
    
    public CAP016 goToCAP016() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP016" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP016");
        minWait();
        return new CAP016(driver, dataFileName);
    }
    
    public CAP142 goToCAP142() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP142" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP142");
        minWait();
        return new CAP142(driver, dataFileName);
    }
    
    public CAP145 goToCAP145() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP145" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP145");
        minWait();
        return new CAP145(driver, dataFileName);
    }


    public SHR010 goToSHR010() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR010" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR010");
        minWait();
        return new SHR010(driver, dataFileName);
    }

    public SHR039 goToSHR039() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR039" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR039");
        minWait();
        return new SHR039(driver, dataFileName);
    }

    public CAP027 goToCAP027() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP027" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP027");
        minWait();
        return new CAP027(driver, dataFileName);
    }

    public CAP026 goToCAP026() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP026" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP026");
        minWait();
        return new CAP026(driver, dataFileName);
    }
    
    public REC001 goToREC001() {
        tabPress(4);
        enterKeys(txt_screenId, "REC001" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameREC001");
        minWait();
        return new REC001(driver, dataFileName);
    }
    public CAP003 goToCAP003() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP003");
        minWait();
        return new CAP003(driver, dataFileName);
    }

    public CAP012 goToCAP012() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP012" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP012");
        minWait();
        return new CAP012(driver, dataFileName);
    }
    public CAP112 goToCAP112() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP112" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP112");
        minWait();
        return new CAP112(driver, dataFileName);
    }
    public CAP118 goToCAP118() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP118" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP118");
        minWait();
        return new CAP118(driver, dataFileName);
    }

    public SHR108 goToSHR108() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR108" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR108");
        minWait();
        return new SHR108(driver, dataFileName);
    }

    public SHR109 goToSHR109() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR109" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR109");
        minWait();
        return new SHR109(driver, dataFileName);
    }

    public TRF024 goToTRF024() {
        tabPress(4);
        enterKeys(txt_screenId, "TRF024" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRF024");
        minWait();
        return new TRF024(driver, dataFileName);
    }

    public TRF006 goToTRF006() {
        tabPress(4);
        enterKeys(txt_screenId, "TRF006" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRF006");
        minWait();
        return new TRF006(driver, dataFileName);
    }

    public TRF017 goToTRF017() {
        tabPress(4);
        enterKeys(txt_screenId, "TRF017" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRF017");
        minWait();
        return new TRF017(driver, dataFileName);
    }

    public TRF008 goToTRF008() {
        tabPress(4);
        enterKeys(txt_screenId, "TRF008" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRF008");
        minWait();
        return new TRF008(driver, dataFileName);
    }

    public TRF004 goToTRF004() {
        tabPress(4);
        enterKeys(txt_screenId, "TRF004" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRF004");
        minWait();
        return new TRF004(driver, dataFileName);
    }

    public TRF021 goToTRF021() {
        tabPress(4);
        enterKeys(txt_screenId, "TRF021" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRF021");
        minWait();
        return new TRF021(driver, dataFileName);
    }

    public ADM032 goToADM032() {
        tabPress(4);
        enterKeys(txt_screenId, "ADM032" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameADM032");
        minWait();
        return new ADM032(driver, dataFileName);
    }


    public FLT005 goToFLT005() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "FLT005" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameFLT005");
        minWait();
        return new FLT005(driver, dataFileName);
    }

    public FLT003 goToFLT003() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "FLT003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameFLT003");
        minWait();
        return new FLT003(driver, dataFileName);
    }

    public FLT006 goToFLT006() {
    	 minWait(); 
         waitForWhiteScreen();
         waitForElement(txt_screenId).clear();
         waitForElement(txt_screenId).sendKeys("FLT006" + Keys.RETURN);
         waitForElement(header_panel).click();
         waitForFrameAndSwitch("iCargoContentFrameFLT006");
         minWait();  
         InitialSetup.test.log(LogStatus.PASS, "Opened the Mark Flight Movement (FLT006) Screen");
         return new FLT006(driver, dataFileName);
       /* minWait();
        tabPress(4);
        enterKeys(txt_screenId, "FLT006" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameFLT006");
        minWait();
        return new FLT006(driver, dataFileName);*/
    }

    public FLT010 goToFLT010() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "FLT010" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameFLT010");
        minWait();
        return new FLT010(driver, dataFileName);
    }

    public FLT025 goToFLT025() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "FLT025" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameFLT025");
        minWait();
        return new FLT025(driver, dataFileName);
    }

    public OPR026 goToOPR026() {
    	 minWait(); 
//         waitForWhiteScreen();
         waitForElement(txt_screenId).clear();
         waitForElement(txt_screenId).sendKeys("OPR026" + Keys.RETURN);
         waitForElement(header_panel).click();
         waitForFrameAndSwitch("iCargoContentFrameOPR026");
         minWait();  
         InitialSetup.test.log(LogStatus.INFO, "Opened the capture AWB(OPR026) Screen");
         return new OPR026(driver, dataFileName);
    }
  

    public OPR025 goToOPR025() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR025" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR025");
        minWait();
        return new OPR025(driver, dataFileName);
    }

    public OPR023 goToOPR023() {
        minWait();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("OPR023" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameOPR023");
        minWait();
        return new OPR023(driver, dataFileName);
    }

    public OPR037 goToOPR037() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR037" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR037");
        minWait();
        return new OPR037(driver, dataFileName);
    }
    
    public OPR335 goToOPR335() {
    	 minWait(); 
//         waitForWhiteScreen();
         waitForElement(txt_screenId).clear();
         waitForElement(txt_screenId).sendKeys("OPR335" + Keys.RETURN);
         waitForElement(header_panel).click();
         waitForFrameAndSwitch("iCargoContentFrameOPR335");
         minWait();  
         InitialSetup.test.log(LogStatus.INFO, "Opened the Goods Acceptance Screen(OPR335)");
         return new OPR335(driver, dataFileName);
       }
    
    public OPR350 goToOPR350() {
   	 minWait(); 
//        waitForWhiteScreen();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("OPR350" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameOPR350");
        minWait();  
        InitialSetup.test.log(LogStatus.INFO, "Opened the Goods Acceptance Screen(OPR350)");
        return new OPR350(driver, dataFileName);
      }
    
    public OPR344 goToOPR344() {
   	 minWait(); 
        waitForWhiteScreen();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("OPR344" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameOPR344");
        minWait();  
        InitialSetup.test.log(LogStatus.PASS, "Opened the Export Manifest(OPR344) Screen");
        return new OPR344(driver, dataFileName);
    }
    public OPR022 goToOPR022() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR022" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR022");
        minWait();
        return new OPR022(driver, dataFileName);
    }
    
    public OPR030 goToOPR030() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR030" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR022");
        minWait();
        return new OPR030(driver, dataFileName);
    }
    

    public LTE002 goToLTE002() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "LTE002" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameLTE002");
        minWait();
        return new LTE002(driver, dataFileName);
    }

    public OPR043 goToOPR043() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR043" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR043");
        minWait();
        return new OPR043(driver, dataFileName);
    }

    public OPR328 goToOPR328() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR328" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR328");
        minWait();
        return new OPR328(driver, dataFileName);
    }

    public OPR064 goToOPR064() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR064" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR064");
        minWait();
        return new OPR064(driver, dataFileName);
    }

    public OPR061 goToOPR061() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR061" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR061");
        minWait();
        return new OPR061(driver, dataFileName);
    }

    public OPR029 goToOPR029() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR029" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR029");
        minWait();
        return new OPR029(driver, dataFileName);
    }

    public OPR274 goToOPR274() {
        minWait();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("OPR274" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameOPR274");
        minWait();
        return new OPR274(driver, dataFileName);
    }


    public OPR275 goToOPR275() {
        minWait();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("OPR275" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameOPR275");
        minWait();
        return new OPR275(driver, dataFileName);
    }

    public OPR282 goToOPR282() {
        minWait();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("OPR282" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameOPR282");
        minWait();
        return new OPR282(driver, dataFileName);
    }


    public OPR293 goToOPR293() {
    	 minWait(); 
         waitForWhiteScreen();
         waitForElement(txt_screenId).clear();
         waitForElement(txt_screenId).sendKeys("OPR293" + Keys.RETURN);
         waitForElement(header_panel).click();
         maxWait();
         waitForFrameAndSwitch("iCargoContentFrameOPR293");
         minWait();  
         InitialSetup.test.log(LogStatus.PASS, "Clicked on OPR0293 Screen");
    /*	minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR293" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR293");
        minWait();
        RunTest.test.log(LogStatus.PASS, "Clicked on OPR293 Screen");*/
        return new OPR293(driver, dataFileName);
        
    }

    public TRC006 goToTRC006() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "TRC006" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRC006");
        minWait();
        return new TRC006(driver, dataFileName);
    }

    public TRC007 goToTRC007() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "TRC007" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRC007");
        minWait();
        return new TRC007(driver, dataFileName);
    }

    public TRC008 goToTRC008() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "TRC008" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRC008");
        minWait();
        return new TRC008(driver, dataFileName);
    }

    public TRC009 goToTRC009() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "TRC009" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRC009");
        minWait();
        return new TRC009(driver, dataFileName);
    }

    public WFW003 goToWFW003() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "WFW003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWFW003");
        minWait();
        return new WFW003(driver, dataFileName);
    }

    public WHS011 goToWHS011() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "WHS011" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS011");
        minWait();
        return new WHS011(driver, dataFileName);
    }

    public WHS012 goToWHS012() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "WHS012" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS012");
        minWait();
        return new WHS012(driver, dataFileName);
    }

    public WHS009 goToWHS009() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "WHS009" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS009");
        minWait();
        return new WHS009(driver, dataFileName);
    }

    public WHS001 goToWHS001() {
        tabPress(4);
        enterKeys(txt_screenId, "WHS001" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS001");
        minWait();
        return new WHS001(driver, dataFileName);
    }

    public OPR004 goToOPR004() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR004" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR004");
        minWait();
        return new OPR004(driver, dataFileName);
    }

    public WHS002 goToWHS002() {
        tabPress(4);
        enterKeys(txt_screenId, "WHS002" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS002");
        minWait();
        return new WHS002(driver, dataFileName);
    }

    public WHS003 goToWHS003() {
        tabPress(4);
        enterKeys(txt_screenId, "WHS003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS003");
        minWait();
        return new WHS003(driver, dataFileName);
    }

    public WHS004 goToWHS004() {
        tabPress(4);
        enterKeys(txt_screenId, "WHS004" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS004");
        minWait();
        return new WHS004(driver, dataFileName);
    }

    public WHS013 goToWHS013() {
        tabPress(4);
        enterKeys(txt_screenId, "WHS013" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS013");
        minWait();
        return new WHS013(driver, dataFileName);
    }

    public WHS018 goToWHS018() {
        tabPress(4);
        enterKeys(txt_screenId, "WHS018" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS018");
        minWait();
        return new WHS018(driver, dataFileName);
    }
    
    public WHS019 goToWHS019() {
        tabPress(4);
        enterKeys(txt_screenId, "WHS019" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS019");
        minWait();
        return new WHS019(driver, dataFileName);
    }
    
    public WHS020 goToWHS020() {
        tabPress(4);
        enterKeys(txt_screenId, "WHS020" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS020");
        minWait();
        return new WHS020(driver, dataFileName);
    }

    public WHS021 goToWHS021() {
        tabPress(4);
        enterKeys(txt_screenId, "WHS021" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS021");
        minWait();
        return new WHS021(driver, dataFileName);
    }

    public WHS022 goToWHS022() {
        tabPress(4);
        enterKeys(txt_screenId, "WHS022" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS022");
        minWait();
        return new WHS022(driver, dataFileName);
    }

    public WHS031 goToWHS031() {
        tabPress(4);
        enterKeys(txt_screenId, "WHS031" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS031");
        minWait();
        return new WHS031(driver, dataFileName);
    }

    public ULD006 goToULD006() {
        minWait();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("ULD006" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameULD006");
        minWait();
        return new ULD006(driver, dataFileName);
    }


    public OPR009 goToOPR009() {
        minWait();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("OPR009" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameOPR009");
        minWait();
        return new OPR009(driver, dataFileName);
    }

    public OPR292 goToOPR292() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR292" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR292");
        minWait();
        return new OPR292(driver, dataFileName);
    }

    public OPR263 goToOPR263() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR263" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR263");
        minWait();
        return new OPR263(driver, dataFileName);
    }

    public OPR008 goToOPR008() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR008" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR008");
        minWait();
        return new OPR008(driver, dataFileName);
    }

    public ULD010 goToULD010() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "ULD010" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD010");
        minWait();
        return new ULD010(driver, dataFileName);
    }

    public ULD013 goToULD013() {
    	 minWait(); 
         waitForWhiteScreen();
         waitForElement(txt_screenId).clear();
         waitForElement(txt_screenId).sendKeys("ULD013" + Keys.RETURN);
         waitForElement(header_panel).click();
         waitForFrameAndSwitch("iCargoContentFrameULD013");
         minWait();  
         InitialSetup.test.log(LogStatus.INFO, "Opened the Create ULD(ULD013) Screen");
         return new ULD013(driver, dataFileName);
    }

    public OPR063 goToOPR063() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "OPR063" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR063");
        minWait();
        return new OPR063(driver, dataFileName);
    }

    public ULD050 goToULD050() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "ULD050" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD050");
        minWait();
        return new ULD050(driver, dataFileName);
    }

    public ULD009 goToULD009() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "ULD009" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD009");
        minWait();
        return new ULD009(driver, dataFileName);
    }

    public ULD042 goToULD042() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "ULD042" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD042");
        minWait();
        return new ULD042(driver, dataFileName);
    }

    public ULD002 goToULD002() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "ULD002" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD002");
        minWait();
        return new ULD002(driver, dataFileName);
    }

    public ULD023 goToULD023() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "ULD023" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD023");
        minWait();
        return new ULD023(driver, dataFileName);
    }

    public ADM009 goToADM009() {
    	 minWait(); 
         waitForWhiteScreen();
         waitForElement(txt_screenId).clear();
         waitForElement(txt_screenId).sendKeys("ADM009" + Keys.RETURN);
         waitForElement(header_panel).click();
         waitForFrameAndSwitch("iCargoContentFrameADM009");
         minWait();  
         BaseSetup.test.log(LogStatus.INFO, "Opened the Booking(ADM009) Screen");
         return new ADM009(driver, dataFileName);
    }

    public SHR048 goToSHR048() {
        tabPress(4);
        enterKeys(txt_screenId, "SHR048" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR048");
        minWait();
        return new SHR048(driver, dataFileName);
    }

    public OPR262 goToOPR262() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR262" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR262");
        minWait();
        return new OPR262(driver, dataFileName);
    }


    public MSG005 goToMSG005() {
        minWait(); 
        waitForWhiteScreen();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("MSG005" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameMSG005");
        minWait();  
        InitialSetup.test.log(LogStatus.PASS, "Navigated to Process Messages Screen : MSG005");
        return new MSG005(driver, dataFileName);
    }
    
    public MTK060 goToMTK060() {
        minWait(); 
        waitForWhiteScreen();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("MTK060" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameMTK060");
        minWait();  
        InitialSetup.test.log(LogStatus.PASS, "Navigated to Process Messages Screen : MTK060");
        return new MTK060(driver, dataFileName);
    }
    
    public MTK064 goToMTK064() {
        minWait(); 
        waitForWhiteScreen();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("MTK064" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameMTK064");
        minWait();  
        InitialSetup.test.log(LogStatus.PASS, "Navigated to Process Messages Screen : MTK064");
        return new MTK064(driver, dataFileName);
    }
    
    public LTE001 goToLTE001() {
        minWait(); 
        waitForWhiteScreen();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("LTE001" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameLTE001");
        minWait();  
        InitialSetup.test.log(LogStatus.PASS, "Clicked on LTE001 Screen");
        return new LTE001(driver, dataFileName);
    }
    public LTE003 goToLTE003() {
        minWait(); 
        waitForWhiteScreen();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("LTE003" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameLTE003");
        minWait();  
        InitialSetup.test.log(LogStatus.PASS, "Clicked on LTE003 Screen");
        return new LTE003(driver, dataFileName);
    }
    public MSG004 goToMSG004() {
        minWait();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("MSG004" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameMSG004");
        minWait();
        return new MSG004(driver, dataFileName);
    }
    
    public OPR016 goToOPR016() {
        enterKeys(txt_screenId, "OPR016" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR016");
        minWait();
        return new OPR016(driver, dataFileName);
    }
    

    public OPR036 goToOPR036() {
        enterKeys(txt_screenId, "OPR036" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR036");
        minWait();
        return new OPR036(driver, dataFileName);
    }
    
     public OPR017 goToOPR017() {

        enterKeys(txt_screenId, "OPR017" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR017");
        minWait();
        return new OPR017(driver, dataFileName);
    }
    
    public OPR014 goToOPR014() {
        enterKeys(txt_screenId, "OPR014" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR014");
        minWait();
        return new OPR014(driver, dataFileName);
    }


    public OPR024 goToOPR024() {
        enterKeys(txt_screenId, "OPR024" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR024");
        minWait();
        return new OPR024(driver, dataFileName);
    }
    

    public OPR050 goToOPR050() {
        enterKeys(txt_screenId, "OPR050" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR050");
        minWait();
        return new OPR050(driver, dataFileName);
    }

    public OPR047 goToOPR047() {
        enterKeys(txt_screenId, "OPR047" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR047");
        minWait();
        return new OPR047(driver, dataFileName);
    }

    public FLT004 goToFLT004() {
        enterKeys(txt_screenId, "FLT004" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameFLT004");
        minWait();
        return new FLT004(driver, dataFileName);
    }

    public FLT002 goToFLT002() {
        enterKeys(txt_screenId, "FLT002" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameFLT002");
        minWait();
        return new FLT002(driver, dataFileName);
    }


    public OPR339 goToOPR339() {
        enterKeys(txt_screenId, "OPR339" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR339");
        minWait();
        return new OPR339(driver, dataFileName);
    }

    public ULD017 goToULD017() {
        enterKeys(txt_screenId, "ULD017" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameULD017");
        minWait();
        return new ULD017(driver, dataFileName);
    }

    public STK014 goToSTK014() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK014" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK014");
        minWait();
        return new STK014(driver, dataFileName);
    }

    public STK017 goToSTK017() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK017" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK017");
        minWait();
        return new STK017(driver, dataFileName);
    }

    public STK006 goToSTK006() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK006" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK006");
        minWait();
        return new STK006(driver, dataFileName);
    }

    public STK021 goToSTK021() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK021" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK021");
        minWait();
        return new STK021(driver, dataFileName);
    }

    public STK004 goToSTK004() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK004" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK004");
        minWait();
        return new STK004(driver, dataFileName);
    }
    public STK015 goToSTK015() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK015" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK015");
        minWait();
        return new STK015(driver, dataFileName);
    }

    public STK016 goToSTK016() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK016" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK016");
        minWait();
        return new STK016(driver, dataFileName);
    }
    /*public STK001 goToSTK001() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK001" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK001");
        minWait();
        return new STK001(driver, dataFileName);
    }*/

    public STK002 goToSTK002() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK002" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK002");
        minWait();
        return new STK002(driver, dataFileName);
    }

    public STK007 goToSTK007() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK007" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK007");
        minWait();
        return new STK007(driver, dataFileName);
    }

    public STK019 goToSTK019() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK019" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK019");
        minWait();
        return new STK019(driver, dataFileName);
    }

    public STK003 goToSTK003() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK003");
        minWait();
        return new STK003(driver, dataFileName);
    }

    public STK005 goToSTK005() {
        minWait();
        tabPress(4);
        enterKeys(txt_screenId, "STK005" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK005");
        minWait();
        return new STK005(driver, dataFileName);
    }

    /*  public SHR095 goToSHR095(){
          minWait();
          enterKeys(txt_screenId,"SHR095" + Keys.RETURN);
          click(header_panel);
          waitForFrameAndSwitch("iCargoContentFrameSHR095");

      public SHR011 goToSHR011() {
          minWait();
          return new SHR095(driver, dataFileName);
      }

      public SHR094 goToSHR094(){
          minWait();
          enterKeys(txt_screenId,"SHR094" + Keys.RETURN);
          click(header_panel);
          waitForFrameAndSwitch("iCargoContentFrameSHR094");
          minWait();
          return new SHR094(driver, dataFileName);
      }*/
    public SHR011 goToSHR011() {
        minWait();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("SHR011" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameSHR011");
        minWait();
        return new SHR011(driver, dataFileName);
    }


    public CAP022 goToCAP022() {
        minWait();
        waitForElement(txt_screenId).clear();
        waitForElement(txt_screenId).sendKeys("CAP022" + Keys.RETURN);
        waitForElement(header_panel).click();
        waitForFrameAndSwitch("iCargoContentFrameCAP022");
        minWait();
        return new CAP022(driver, dataFileName);
    }

    public SHR095 goToSHR095() {
        enterKeys(txt_screenId, "SHR095" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR095");
        minWait();
        return new SHR095(driver, dataFileName);
    }

    public SHR094 goToSHR094() {
        enterKeys(txt_screenId, "SHR094" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR094");
        minWait();
        return new SHR094(driver, dataFileName);
    }

    public CRA080 goToCRA080() {
        enterKeys(txt_screenId, "CRA080" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA080");
        minWait();
        return new CRA080(driver, dataFileName);
    }

    public SHR033 goToSHR033() {
        enterKeys(txt_screenId, "SHR033" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR033");
        minWait();
        return new SHR033(driver, dataFileName);
    }

    public WHS016 goToWHS016() {
        enterKeys(txt_screenId, "WHS016" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS016");
        minWait();
        return new WHS016(driver, dataFileName);
    }

    public WHS006 goToWHS006() {
        enterKeys(txt_screenId, "WHS006" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameWHS006");
        minWait();
        return new WHS006(driver, dataFileName);
    }

    public CRA212 goToCRA212() {
       /* enterKeys(txt_screenId, "CRA212" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA212");
        minWait();
        return new CRA212(driver, dataFileName);*/
   	 minWait(); 
     waitForWhiteScreen();
     waitForElement(txt_screenId).clear();
     waitForElement(txt_screenId).sendKeys("CRA212" + Keys.RETURN);
     waitForElement(header_panel).click();
     waitForFrameAndSwitch("iCargoContentFrameCRA212");
     minWait();  
     InitialSetup.test.log(LogStatus.INFO, "Opened the Rate Audit Screen");
     return new CRA212(driver, dataFileName);
    }

    public CRA075 goToCRA075() {
        enterKeys(txt_screenId, "CRA075" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA075");
        minWait();
        return new CRA075(driver, dataFileName);
    }

    public CRA032 goToCRA032() {
        enterKeys(txt_screenId, "CRA032" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA032");
        minWait();
        return new CRA032(driver, dataFileName);
    }
    
    public CRA035 goToCRA035() {
        enterKeys(txt_screenId, "CRA035" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA035");
        minWait();
        return new CRA035(driver, dataFileName);
    }

    public CRA072 goToCRA072() {
        enterKeys(txt_screenId, "CRA072" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA072");
        minWait();
        return new CRA072(driver, dataFileName);
    }

    public OPR286 goToOPR286() {
        enterKeys(txt_screenId, "OPR286" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR286");
        minWait();
        return new OPR286(driver, dataFileName);
    }

    public CRA037 goToCRA037() {
        enterKeys(txt_screenId, "CRA037" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA037");
        minWait();
        return new CRA037(driver, dataFileName);
    }

    public CRA074 goToCRA074() {
        enterKeys(txt_screenId, "CRA074" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA074");
        minWait();
        return new CRA074(driver, dataFileName);
    }

    public CRA143 goToCRA143() {
        enterKeys(txt_screenId, "CRA143" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA143");
        minWait();
        return new CRA143(driver, dataFileName);
    }
       /*public Logoff goToLogOff() {

	       minWait();
	       return new Logoff(driver, dataFileName);
	   }*/


    public CLM003 goToCLM003() {
        enterKeys(txt_screenId, "CLM003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCLM003");
        minWait();
        return new CLM003(driver, dataFileName);
    }

    public CRA175 goToCRA175() {
        enterKeys(txt_screenId, "CRA175" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA175");
        minWait();
        return new CRA175(driver, dataFileName);
    }

    public CRA001 goToCRA001() {
        enterKeys(txt_screenId, "CRA001" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA001");
        minWait();
        return new CRA001(driver, dataFileName);
    }

    public CMT002 goToCMT002() {
        enterKeys(txt_screenId, "CMT002" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCMT002");
        minWait();
        return new CMT002(driver, dataFileName);
    }

    public CRA028 goToCRA028() {
        enterKeys(txt_screenId,"CRA028" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA028");
        minWait();
        return new CRA028(driver, dataFileName);
    }
    public CRA153 goToCRA153() {
        enterKeys(txt_screenId, "CRA153");
        enterKeys(txt_screenId,Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA153");
        minWait();
        return new CRA153(driver, dataFileName);
    }
    
    public CRA154 goToCRA154() {
        enterKeys(txt_screenId, "CRA154" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA154");
        minWait();
        return new CRA154(driver, dataFileName);
    }
    
    public CRA155 goToCRA155() {
        enterKeys(txt_screenId, "CRA155" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA155");
        minWait();
        return new CRA155(driver, dataFileName);
    }

    public CRA054 goToCRA054() {
        enterKeys(txt_screenId, "CRA054" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA054");
        minWait();
        return new CRA054(driver, dataFileName);
    }

    public CRA207 goToCRA207() {
        enterKeys(txt_screenId, "CRA207" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA207");
        minWait();
        return new CRA207(driver, dataFileName);
    } 
    public SHR018 goToSHR018(){
    	enterKeys(txt_screenId, "SHR018" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR018");
        minWait();
        return new SHR018(driver, dataFileName);
    }
    
    public CLM002 goToCLM002(){
    	enterKeys(txt_screenId, "CLM002" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCLM002");
        minWait();
        return new CLM002(driver, dataFileName);
    }
    public CRA205 goToCRA205() {
        enterKeys(txt_screenId, "CRA205" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA205");
        minWait();
        return new CRA205(driver, dataFileName);
    }
    
    public CRA071 goToCRA071() {
        enterKeys(txt_screenId, "CRA071" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA071");
        minWait();
        return new CRA071(driver, dataFileName);
    }
    
    public CRA070 goToCRA070() {
        enterKeys(txt_screenId, "CRA070" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA070");
        minWait();
        return new CRA070(driver, dataFileName);
    }
    public CRA203 goToCRA203() {
        enterKeys(txt_screenId, "CRA203" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA203");
        minWait();
        return new CRA203(driver, dataFileName);
    }
    
    
    public CRA168 goToCRA168() {
        enterKeys(txt_screenId, "CRA168" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA168");
        minWait();
        return new CRA168(driver, dataFileName);
    }
    
    public CRA088 goToCRA088() {
        enterKeys(txt_screenId, "CRA088" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA088");
        minWait();
        return new CRA088(driver, dataFileName);
    }
    
    public CRA169 goToCRA169() {
        enterKeys(txt_screenId, "CRA169" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA169");
        minWait();
        return new CRA169(driver, dataFileName);
    }
    
    public CRA188 goToCRA188() {
        enterKeys(txt_screenId, "CRA188" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCRA188");
        minWait();
        return new CRA188(driver, dataFileName);
    }
    
    public CLM001 goToCLM001() {
        enterKeys(txt_screenId, "CLM001" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCLM001");
        minWait();
        return new CLM001(driver, dataFileName);
    }
    
    public CAP103 goToCAP103() {
        enterKeys(txt_screenId, "CAP103" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP103");
        minWait();
        return new CAP103(driver, dataFileName);
    }
    
    public CAP109 goToCAP109() {
        enterKeys(txt_screenId, "CAP109" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP109");
        minWait();
        return new CAP109(driver, dataFileName);
    }
    
    public STK001 goToSTK001() {
        enterKeys(txt_screenId, "STK001" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSTK001");
        minWait();
        return new STK001(driver, dataFileName);
    }
    

    public ADM002 goToADM002() {
        enterKeys(txt_screenId, "ADM002" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameADM002");
        minWait();
        return new ADM002(driver, dataFileName);
    }   
    
    public CAP015 goToCAP015() {
        // tabPress(4);
        enterKeys(txt_screenId, "CAP015" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP015");
        minWait();
        return new CAP015(driver, dataFileName);
    }
    
    
    public TRF007 goToTRF007() {
        // tabPress(4);
        enterKeys(txt_screenId, "TRF007" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameTRF007");
        minWait();
        return new TRF007(driver, dataFileName);
    } 
    
    public QMS009 goToQMS009() {
         tabPress(4);
        enterKeys(txt_screenId, "QMS009" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameQMS009");
        minWait();
        return new QMS009(driver, dataFileName);
    } 
    
    public void assertAll(){
    	Assertion.softAssert().assertAll();
    }
    
    public OPR294 goToOPR294() {
        enterKeys(txt_screenId, "OPR294" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR294");
        minWait();
        return new OPR294(driver, dataFileName);
    } 
    
    public OPR035 goToOPR035() {
        enterKeys(txt_screenId, "OPR035" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR035");
        minWait();
        return new OPR035(driver, dataFileName);
    } 
    
    public OPR034 goToOPR034() {
        enterKeys(txt_screenId, "OPR034" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR034");
        minWait();
        return new OPR034(driver, dataFileName);
    }
    
  
    public CSH010 goToCSH010() {
        enterKeys(txt_screenId, "CSH010" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCSH010");
        minWait();
        return new CSH010(driver, dataFileName);
    }

     
    
    public ACC008 goToACC008() {
        enterKeys(txt_screenId, "ACC008" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameACC008");
        minWait();
        return new ACC008(driver, dataFileName);
    }  
    
    
    
    public CSH014 goToCSH014() {
        enterKeys(txt_screenId, "CSH014" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCSH014");
        minWait();
        return new CSH014(driver, dataFileName);
    }  
    
    
    
    
    
    
    
    
    


    public ADM001 goToADM001() {
        enterKeys(txt_screenId, "ADM001" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameADM001");
        minWait();
        return new ADM001(driver, dataFileName);
    }   
   /* public CAP112 goToCAP112() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP112" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP112");
        minWait();
        return new CAP112(driver, dataFileName);
    }
    public CAP118 goToCAP118() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP118" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP118");
        minWait();
        return new CAP118(driver, dataFileName);
    }
    public CAP030 goToCAP030() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP030" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP030");
        minWait();
        return new CAP030(driver, dataFileName);
    }*/
    public CAP006 goToCAP006() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP006" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP006");
        minWait();
        return new CAP006(driver, dataFileName);
    }
    
    public CAP116 goToCAP116() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP116" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP116");
        minWait();
        return new CAP116(driver, dataFileName);
    }
    
    public CAP115 goToCAP115() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP115" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP115");
        minWait();
        return new CAP115(driver, dataFileName);
    }
    /*public CAP003 goToCAP003() {
>>>>>>> .r2527
        tabPress(4);
        enterKeys(txt_screenId, "CAP003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP003");
        minWait();
        return new CAP003(driver, dataFileName);
    }
    public CAP112 goToCAP112() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP112" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP112");
        minWait();
        return new CAP112(driver, dataFileName);
    }
    /*public CAP118 goToCAP118() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP118" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP118");
        minWait();
        return new CAP118(driver, dataFileName);
    }*/
    public CAP030 goToCAP030() {
        tabPress(4);
        enterKeys(txt_screenId, "CAP030" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameCAP030");
        minWait();
        return new CAP030(driver, dataFileName);
    }
    
    public OPR013 goToOPR013() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR013" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR013");
        minWait();
        return new OPR013(driver, dataFileName);
    }
    
    public OPR360 goToOPR360() {
        tabPress(4);
        enterKeys(txt_screenId, "OPR360" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameOPR360");
        minWait();
        return new OPR360(driver, dataFileName);
    }
    
   /* public PDS003 gotoPDS003()
    {
    	tabPress(4);
        enterKeys(txt_screenId, "PDS003" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFramePDS003");
        minWait();
        return new PDS003(driver, dataFileName);
    }*/
    
   /* public PDS002 gotoPDS002()
    {
    	tabPress(4);
        enterKeys(txt_screenId, "PDS002" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFramePDS002");
        minWait();
        return new PDS002(driver, dataFileName);
    }*/
    
    public SHR097 goToSHR097(){
        minWait();
        enterKeys(txt_screenId,"SHR097" + Keys.RETURN);
        click(header_panel);
        waitForFrameAndSwitch("iCargoContentFrameSHR097");
        minWait();
        return new SHR097(driver, dataFileName);
    }

	//A-8680
	public HomePage SwitchRoleGroup(String stationCode, String RoleGroup) {
//		stationCode = PropertyHandler.getPropValue(dataFilePath, stationCode);
		driver.switchTo().defaultContent();
		click(btn_editIcon);
		click(btn_switchRole);
//		driver.switchTo().frame("swichRoleiframe");
		waitForFrameAndSwitch("swichRoleiframe");
		click(btn_station);
		selectByText(btn_station, stationCode);
		click(By.xpath("//select[@name='selectedStationRoleGroup']"));
		selectByText(By.xpath("//select[@name='selectedStationRoleGroup']"), RoleGroup);
		minWait();
		click(btn_ok);
		maxWait();
		driver.switchTo().defaultContent();
		return this;
	}
	
	//A-8680
	public HomePage SwitchRoleGroupParameter(String stationCode, String RoleGroup) {
		stationCode = PropertyHandler.getPropValue(dataFilePath, stationCode);
		driver.switchTo().defaultContent();
		click(btn_editIcon);
		click(btn_switchRole);
		driver.switchTo().frame("swichRoleiframe");

		click(btn_station);
		selectByText(btn_station, stationCode);
		click(By.xpath("//select[@name='selectedStationRoleGroup']"));
//		minWait();
		selectByText(By.xpath("//select[@name='selectedStationRoleGroup']"), RoleGroup);
//		minWait();
		click(btn_ok);
		maxWait();
		driver.switchTo().defaultContent();
		return this;
	}
	
	//A-8680
	public HomePage SwitchRoleGroupAllParameter(String stationCode, String RoleGroup) {
		stationCode = PropertyHandler.getPropValue(dataFilePath, stationCode);
		RoleGroup = PropertyHandler.getPropValue(dataFilePath, RoleGroup);
		driver.switchTo().defaultContent();
		click(btn_editIcon);
		click(btn_switchRole);
		driver.switchTo().frame("swichRoleiframe");

		click(btn_station);
		selectByText(btn_station, stationCode);
		click(By.xpath("//select[@name='selectedStationRoleGroup']"));
		selectByText(By.xpath("//select[@name='selectedStationRoleGroup']"), RoleGroup);
		minWait();
		click(btn_ok);
		maxWait();
		driver.switchTo().defaultContent();
		return this;
	}
	
	//Shalini
	 public CUS085 goToCUS085() {
	        minWait(); 
	        waitForWhiteScreen();
	        waitForElement(txt_screenId).clear();
	        waitForElement(txt_screenId).sendKeys("CUS085" + Keys.RETURN);
	        waitForElement(header_panel).click();
	        waitForFrameAndSwitch("iCargoContentFrameCUS085");
	        minWait();  
	        InitialSetup.test.log(LogStatus.PASS, "Clicked on CUS085 Screen");
	        return new CUS085(driver, dataFileName);
	    }
	 
	 //Sharath
	    public OPR352 goToOPR352() {
	    	 minWait(); 
	         waitForWhiteScreen();
	         waitForElement(txt_screenId).clear();
	         waitForElement(txt_screenId).sendKeys("OPR352" + Keys.RETURN);
	         waitForElement(header_panel).click();
	         waitForFrameAndSwitch("iCargoContentFrameOPR352");
	         minWait();  
	         InitialSetup.test.log(LogStatus.INFO, "Opened the Booking(OPR352) Screen");
	         return new OPR352(driver, dataFileName);
	    }
	    
	    
} 
