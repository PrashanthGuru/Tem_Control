package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/26/2017.
 */
public class ULD010 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameULD010";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By dropDown_partyType,
            txt_fromPartyCode,
            txt_toPartyCode,
            btn_add,
            txt_ULDNo,
            Link_addLinkAcc,
            dropDown_condition,
            btn_save,
            damagedFlag0,
           btn_MAINTAINULDAGRMNT_CLOSE,
            check_uldDetails,
            AgreementReportbutton,
            SendLUCbutton,
            interfacesys,
            acessoryCode,
            txt_ULDNo2,
            accessoryQuantity,
            Generic_info_error,
            check_uld,
            transactionStation,
            interfacesys_addAddrDtls,
            interfacesys_Okbutton,
            transactionNature,
            btn_close;
            
    private By btn_genericNo,
            btn_genericYes,
            info_footer;


    public ULD010(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    /**
     * Initializes all the elements
     *
     * @author Arun A-7681 on 26/12
     */
    private void initElements() {
        dropDown_partyType = MiscUtility.getWebElement(objFilepath, "ULD010_dropDown_partyType");
        txt_fromPartyCode = MiscUtility.getWebElement(objFilepath, "ULD010_txt_fromPartyCode");
        txt_toPartyCode = MiscUtility.getWebElement(objFilepath, "ULD010_txt_toPartyCode");
        Generic_info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        btn_add = MiscUtility.getWebElement(objFilepath, "ULD010_btn_add");
        txt_ULDNo = MiscUtility.getWebElement(objFilepath, "ULD010_txt_ULDNo");
        dropDown_condition = MiscUtility.getWebElement(objFilepath, "ULD010_dropDown_condition");
        btn_save = MiscUtility.getWebElement(objFilepath, "ULD010_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath, "ULD010_btn_close");
        damagedFlag0= MiscUtility.getWebElement(objFilepath, "ULD010_damagedFlag0");
        btn_genericNo = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footer = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        AgreementReportbutton = MiscUtility.getWebElement(objFilepath, "ULD010_AgreementReportbutton");
        transactionNature = MiscUtility.getWebElement(objFilepath, "ULD010_transactionNature");
        SendLUCbutton	= MiscUtility.getWebElement(objFilepath, "ULD010_SendLUCbutton");
        interfacesys_addAddrDtls= MiscUtility.getWebElement(objFilepath, "ULD002_btn_SendSCMbutton_addAddrDtls");
        interfacesys= MiscUtility.getWebElement(objFilepath, "ULD002_btn_SendSCMbutton_interfacesys");
        interfacesys_Okbutton	= MiscUtility.getWebElement(objFilepath, "ULD002_btn_SendSCMbutton_Okbutton");
        acessoryCode 	= MiscUtility.getWebElement(objFilepath, "ULD010_acessoryCode");
        accessoryQuantity 	= MiscUtility.getWebElement(objFilepath, "ULD010_accessoryQuantity");
        transactionStation 	= MiscUtility.getWebElement(objFilepath, "ULD010_transactionStation");
        Link_addLinkAcc 	= MiscUtility.getWebElement(objFilepath, "ULD010_Link_addLinkAcc");
        txt_ULDNo2= MiscUtility.getWebElement(objFilepath, "ULD010_txt_ULDNo2");
        btn_MAINTAINULDAGRMNT_CLOSE= MiscUtility.getWebElement(objFilepath, "ULD010_btn_MAINTAINULDAGRMNT_CLOSE");
        check_uldDetails= MiscUtility.getWebElement(objFilepath, "ULD010_check_uldDetails");
        check_uld= MiscUtility.getWebElement(objFilepath, "ULD010_check_uld");
    }

    /**
     * Performs ULD transaction saving for the specified ULD and for the specified parties
     *
     * @param uldNo
     * @return
     * @author Arun A-7681 on 26/12
     */
    public ULD010 saveULDTrans(String uldNo, String frmParty, String toParty) {

        uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
        frmParty = PropertyHandler.getPropValue(dataFilePath, frmParty);
        toParty = PropertyHandler.getPropValue(dataFilePath, toParty);
        selectByText(dropDown_partyType, "Airline");
        enterKeys(txt_fromPartyCode, frmParty + Keys.TAB);
        enterKeys(txt_toPartyCode, toParty + Keys.TAB);
        click(btn_add);
        enterKeys(txt_ULDNo, uldNo);
//        selectByText(dropDown_condition, "Airline");
        save();

        return this;
    }
    /**
     * Performs ULD transaction saving for the specified ULD and for the specified parties
     *
     * @param uldNo
     * @return
     * @author 6545
     */
    public ULD010 Loan_Agent_AgreementReport_Temporary(String uldNo, String toParty,String frmParty) {

        uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
        frmParty = PropertyHandler.getPropValue(dataFilePath, frmParty);
        toParty = PropertyHandler.getPropValue(dataFilePath, toParty);
        selectByText(dropDown_partyType, "Agent");
        selectByText(transactionNature, "Temporary");
        enterKeys(txt_fromPartyCode, toParty + Keys.TAB);
        enterKeys(txt_toPartyCode, frmParty + Keys.TAB);
        click(btn_add);
        enterKeys(txt_ULDNo, uldNo);
        check(damagedFlag0);
        check(damagedFlag0);
        check(check_uld);
        
        click(AgreementReportbutton);
        minWait();
        click(btn_MAINTAINULDAGRMNT_CLOSE);
        save();
        return this;
    }
    public ULD010 Damage_uld(String uldNo, String toParty,String frmParty) {

        uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
        frmParty = PropertyHandler.getPropValue(dataFilePath, frmParty);
        toParty = PropertyHandler.getPropValue(dataFilePath, toParty);
        selectByText(dropDown_partyType, "Airline");
        enterKeys(txt_fromPartyCode, toParty + Keys.TAB);
        enterKeys(txt_toPartyCode, frmParty + Keys.TAB);
        click(btn_add);
        enterKeys(txt_ULDNo, uldNo);
        minWait();
        click(damagedFlag0);
        check(damagedFlag0);
        minWait();
        check(check_uldDetails);
      
        click(AgreementReportbutton);
        minWait();
        click(btn_MAINTAINULDAGRMNT_CLOSE);
        save();
        
        
        return this;
    }
    /**
     * Performs ULD transaction saving for the specified ULD and for the specified parties
     *
     * @param uldNo
     * @return
     * @author 6545
     */
    public ULD010 Loan_Permanent_SendLUC(String uldNo, String toParty,String frmParty) {

        uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
        frmParty = PropertyHandler.getPropValue(dataFilePath, frmParty);
        toParty = PropertyHandler.getPropValue(dataFilePath, toParty);
        selectByText(dropDown_partyType, "Airline");
        selectByText(transactionNature, "Permanent");
        enterKeys(txt_fromPartyCode, toParty + Keys.TAB);
        enterKeys(txt_toPartyCode, frmParty + Keys.TAB);
        click(btn_add);
        enterKeys(txt_ULDNo, uldNo);
        check(damagedFlag0);
        check(damagedFlag0);
        minWait();
        click(SendLUCbutton);
        waitForNewWindow(2);
  	    switchToSecondWindow();
  	  click(interfacesys_addAddrDtls);
  	selectByText(interfacesys, "NACCS");
  	    click(interfacesys_Okbutton);
  	  switchToFirstWindow();
      waitForFrameAndSwitch(FRAME);
        return this;
    }

    /**
     * Performs ULD transaction saving for the specified ULD and for the specified parties
     *
     * @param uldNo
     * @return
     * @author 6545
     */
    public ULD010 Uld_Accessory(String uldNo, String toParty,String frmParty,String origin) {
  
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
        frmParty = PropertyHandler.getPropValue(dataFilePath, frmParty);
        toParty = PropertyHandler.getPropValue(dataFilePath, toParty);
        origin = PropertyHandler.getPropValue(dataFilePath, origin);
        
        enterKeys(transactionStation, origin);
        selectByText(dropDown_partyType, "Airline");

        enterKeys(txt_fromPartyCode, toParty + Keys.TAB);
        enterKeys(txt_toPartyCode, frmParty + Keys.TAB);
        
        click(Link_addLinkAcc);
        minWait();
        selectByText(acessoryCode, "Net");
        enterKeys(accessoryQuantity, "1");
        save();
        return this;
    }
    /**
     * Performs ULD transaction saving for the specified ULD and for the specified parties
     *
     * @param uldNo
     * @return
     * @author 6545
     */
    public ULD010 Loan_multiULDTransaction(String uldNo, String toParty,String frmParty,String origin,String uldNo2) {
  
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
    	uldNo2 = PropertyHandler.getPropValue(dataFilePath, uldNo2);
        frmParty = PropertyHandler.getPropValue(dataFilePath, frmParty);
        toParty = PropertyHandler.getPropValue(dataFilePath, toParty);

        
        selectByText(dropDown_partyType, "Airline");
        enterKeys(txt_fromPartyCode, frmParty + Keys.TAB);
        enterKeys(txt_toPartyCode, toParty + Keys.TAB);
        click(btn_add);
         enterKeys(txt_ULDNo, uldNo);
         click(btn_add);
         minWait();
         enterKeys(txt_ULDNo2, uldNo2);
        minWait();
   
        save();
        return this;
    }
    /**
     * Performs ULD transaction saving for the specified ULD and for the specified parties
     *
     * @param uldNo
     * @return
     * @author 6545
     */
    public ULD010 Error_check(String uldNo, String toParty,String frmParty,String origin,String uldNo2) {
  
    	uldNo = PropertyHandler.getPropValue(dataFilePath, uldNo);
        frmParty = PropertyHandler.getPropValue(dataFilePath, frmParty);
        toParty = PropertyHandler.getPropValue(dataFilePath, toParty);

        
        selectByText(dropDown_partyType, "Airline");
        enterKeys(txt_fromPartyCode, frmParty + Keys.TAB);
        enterKeys(txt_toPartyCode, toParty + Keys.TAB);
        click(btn_add);
         enterKeys(txt_ULDNo, uldNo);
         click(btn_save);
         minWait();
         Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("A ULD cannot be loaned to its Owner"));
        minWait();
   
        return this;
    }
    /**
     * Performs ULD transaction saving for the specified ULD and for the specified parties
     *
     * @param uldNo
     * @return
     * @author 6545
     */
    public ULD010 Error_check_no_agreement( String toParty,String frmParty,String compCode,String uldType) {
  
    	
        frmParty = PropertyHandler.getPropValue(dataFilePath, frmParty);
        toParty = PropertyHandler.getPropValue(dataFilePath, toParty);
        uldType= PropertyHandler.getPropValue(dataFilePath, uldType);
        compCode= PropertyHandler.getPropValue(dataFilePath, compCode);
        String tempUld = null;
    
        tempUld = BizUtility.createULDNum(uldType, compCode);
        selectByText(dropDown_partyType, "Agent");
         enterKeys(txt_fromPartyCode, frmParty + Keys.TAB);
        enterKeys(txt_toPartyCode, toParty + Keys.TAB);
        click(btn_add);
         enterKeys(txt_ULDNo, tempUld);
         click(btn_save);
         minWait();
         Assert.assertTrue(waitForElement(Generic_info_error).getText().contains("has no agreement"));
        minWait();
   
        return this;
    }
    /**
     * Saves the transaction. (called internally in the class)
     *
     * @author Arun A-7681 on 26/12
     */
    private void save() {
        click(btn_save);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericNo)) {

            click(btn_genericNo);
        }
        maxWait();
        Assert.assertEquals(waitForElement(info_footer).getText().trim(),"Loan Transaction saved successfully");
        waitForFrameAndSwitch(FRAME);
    }

    /**
     * CLose and screen and go to home page
     *
     * @return
     * @author A-7681 Arun on 26/12
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }

	
}
