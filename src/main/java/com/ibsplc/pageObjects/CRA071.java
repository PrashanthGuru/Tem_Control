package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;


/**
 * Screen OPR026 - CAPTURE AWB
 * Created on 21/12/2017
 *
 * @author a-7868
 */
public class CRA071 extends BasePage {

    public static String FRAME = "iCargoContentFrameCRA071";
    public static String screenFrame = "iCargoContentFrameCRA071";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "CRA_CMT.properties");
    private static String  genObjPath= PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private By yesBtn,text_agentCode,btn_btnCreate,btn_btnDelete,
    dropdown_targetPeriodBasis,btn_targetperiodbasislov,info_msg,
    checkbox_targetperiodbasislovcheckBasis8,tbl_chargebasisbasicPopupTable,
    btn_targetperiodbasislovbtOk,text_targetAmount,btn_btnListAccEntries,
    text_currencyCode,text_payoutCurrency,btn_payoutAmountBasis,btn_targetperiodbasislovbtClear,
    chkbox_payoutAmountBasischeckBasis8,btn_payoutAmountBasisbtOk,
    btn_addLinkAmt,text_fromAmount1,text_fromAmount2,div_status,btn_noBtn,
    text_toAmount1,text_applicablePercentageAmount1,text_toAmount2,btn_btnInactive,
    text_applicablePercentageAmount2,btn_btnSave,btn_volumeincentivelov,btn_holdingcodelov,
    text_volumeincentivelovagentCode,btn_volumeincentivelovlistButton,checkbox_targetperiodbasischeckBasis10,
    chkbox_volumeincentivelovselectCheckBox,btn_volumeincentivelovokButton,btn_closetargetperiodbasislov,
    text_volumeIncentiveId,btn_btnList,btn_btnActive,btn_btnClose,dropdown_basisOperator,
    btn_ok,txt_basisValue,text_BasisCode8,text_BasisCode10,text_chargeBasis,info_error,
    chk_holdingcode,btn_holdingcodebtnOk,txt_volumeIncentiveId,btn_delete;
    

   
   
    public CRA071(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    /**
     * Initializes the page objects required for the class
     */
    private void initElements() {
    	
    	yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
    	btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
    	text_agentCode=MiscUtility.getWebElement(objFilepath, "CRA071_text_agentCode");
    	btn_btnCreate=MiscUtility.getWebElement(objFilepath, "CRA071_btn_btnCreate");
    	dropdown_targetPeriodBasis=MiscUtility.getWebElement(objFilepath, "CRA071_dropdown_targetPeriodBasis");
    	btn_targetperiodbasislov=MiscUtility.getWebElement(objFilepath, "CRA071_btn_targetperiodbasislov");
    	checkbox_targetperiodbasislovcheckBasis8=MiscUtility.getWebElement(objFilepath, "CRA071_checkbox_targetperiodbasislovcheckBasis8");
    	btn_targetperiodbasislovbtOk=MiscUtility.getWebElement(objFilepath, "CRA071_btn_targetperiodbasislovbtOk");
    	text_targetAmount=MiscUtility.getWebElement(objFilepath, "CRA071_text_targetAmount");
    	text_currencyCode=MiscUtility.getWebElement(objFilepath, "CRA071_text_currencyCode");
    	text_payoutCurrency=MiscUtility.getWebElement(objFilepath, "CRA071_text_payoutCurrency");
    	btn_payoutAmountBasis=MiscUtility.getWebElement(objFilepath, "CRA071_btn_payoutAmountBasis");
    	chkbox_payoutAmountBasischeckBasis8=MiscUtility.getWebElement(objFilepath, "CRA071_chkbox_payoutAmountBasischeckBasis8");
    	btn_payoutAmountBasisbtOk=MiscUtility.getWebElement(objFilepath, "CRA071_btn_payoutAmountBasisbtOk");
    	btn_addLinkAmt=MiscUtility.getWebElement(objFilepath, "CRA071_btn_addLinkAmt");
    	text_fromAmount1=MiscUtility.getWebElement(objFilepath, "CRA071_text_fromAmount1");
    	text_toAmount1=MiscUtility.getWebElement(objFilepath, "CRA071_text_toAmount1");
    	text_applicablePercentageAmount1=MiscUtility.getWebElement(objFilepath, "CRA071_text_applicablePercentageAmount1");
    	text_fromAmount2=MiscUtility.getWebElement(objFilepath, "CRA071_text_fromAmount2");
        text_toAmount2=MiscUtility.getWebElement(objFilepath, "CRA071_text_toAmount2");
    	text_applicablePercentageAmount2=MiscUtility.getWebElement(objFilepath, "CRA071_text_applicablePercentageAmount2");
    	btn_btnSave=MiscUtility.getWebElement(objFilepath, "CRA071_btn_btnSave");
    	btn_volumeincentivelov=MiscUtility.getWebElement(objFilepath, "CRA071_btn_volumeincentivelov");
    	text_volumeincentivelovagentCode=MiscUtility.getWebElement(objFilepath, "CRA071_text_volumeincentivelovagentCode");
        btn_volumeincentivelovlistButton=MiscUtility.getWebElement(objFilepath, "CRA071_btn_volumeincentivelovlistButton");
    	chkbox_volumeincentivelovselectCheckBox=MiscUtility.getWebElement(objFilepath, "CRA071_chkbox_volumeincentivelovselectCheckBox");
    	btn_volumeincentivelovokButton=MiscUtility.getWebElement(objFilepath, "CRA071_btn_volumeincentivelovokButton");
    	text_volumeIncentiveId=MiscUtility.getWebElement(objFilepath, "CRA071_text_volumeIncentiveId");
    	btn_btnList=MiscUtility.getWebElement(objFilepath, "CRA071_btn_btnList");
    	btn_btnActive=MiscUtility.getWebElement(objFilepath, "CRA071_btn_btnActive");
    	btn_btnClose=MiscUtility.getWebElement(objFilepath, "CRA071_btn_btnClose");
    	checkbox_targetperiodbasischeckBasis10=MiscUtility.getWebElement(objFilepath, "CRA071_checkbox_targetperiodbasischeckBasis10");
    	dropdown_basisOperator=MiscUtility.getWebElement(objFilepath, "CAR071_dropdown_basisOperator");
    	txt_basisValue=MiscUtility.getWebElement(objFilepath, "CAR071_txt_basisValue");
    	text_BasisCode8=MiscUtility.getWebElement(objFilepath, "CAR071_text_BasisCode8");
    	text_BasisCode10=MiscUtility.getWebElement(objFilepath, "CAR071_text_BasisCode10");
    	tbl_chargebasisbasicPopupTable=MiscUtility.getWebElement(objFilepath, "CRA071_tbl_chargebasisbasicPopupTable");
    	text_chargeBasis=MiscUtility.getWebElement(objFilepath, "CAR071_text_chargeBasis");
    	info_error = MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    	btn_closetargetperiodbasislov=MiscUtility.getWebElement(objFilepath, "CAR071_btn_closetargetperiodbasislov");
    	//btn_targetperiodbasislovbtClear=MiscUtility.getWebElement(objFilepath, "btn_targetperiodbasislovbtClear");
    	info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
    	div_status=MiscUtility.getWebElement(objFilepath, "CRA071_div_status");
    	btn_btnInactive=MiscUtility.getWebElement(objFilepath, "CRA071_btn_btnInactive");
    	btn_btnDelete=MiscUtility.getWebElement(objFilepath, "CRA071_btn_btnDelete");
    	btn_holdingcodelov=MiscUtility.getWebElement(objFilepath, "CRA071_btn_holdingcodelov");
    	chk_holdingcode=MiscUtility.getWebElement(objFilepath, "CRA071_chk_holdingcode");
    	btn_holdingcodebtnOk=MiscUtility.getWebElement(objFilepath, "CRA071_btn_holdingcodebtnOk");
    	txt_volumeIncentiveId=MiscUtility.getWebElement(objFilepath, "CRA071_txt_volumeIncentiveId");
    	btn_delete=MiscUtility.getWebElement(objFilepath, "CRA071_btn_delete");
    	btn_btnListAccEntries=MiscUtility.getWebElement(objFilepath, "CRA203_btn_btnListAccEntries");
    }
  

public CRA071 CreateVolumeIncentive(String agentCode_new, String frmdate,String toDate,String currency,String FChargeAddn,String VInc_ID){

agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
frmdate = PropertyHandler.getPropValue(dataFilePath, frmdate);

toDate=PropertyHandler.getPropValue(dataFilePath, toDate);
currency=PropertyHandler.getPropValue(dataFilePath, currency);
FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);

enterKeys(text_agentCode, agentCode_new);
click(btn_btnCreate);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);
minWait();
waitForFrameAndSwitch(screenFrame);
selectByText(dropdown_targetPeriodBasis, "Bi Monthly");
click(btn_targetperiodbasislov);
waitForNewWindow(2);
switchToSecondWindow();
check(checkbox_targetperiodbasislovcheckBasis8);
click(btn_targetperiodbasislovbtOk);
minWait();
switchToFirstWindow();

waitForFrameAndSwitch(screenFrame);


enterKeys(text_targetAmount, "50");
enterKeys(text_currencyCode, currency);
enterKeys(text_payoutCurrency, currency);
click(btn_payoutAmountBasis);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_payoutAmountBasischeckBasis8);
click(btn_payoutAmountBasisbtOk);
minWait();
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
click(btn_addLinkAmt);
minWait();
enterKeys(text_fromAmount1, "0");
enterKeys(text_toAmount1, FChargeAddn);
int FCA = Integer.parseInt(FChargeAddn);
FCA=FCA+1;
String frmrange2=String.valueOf(FCA);
enterKeys(text_applicablePercentageAmount1, "2");
click(btn_addLinkAmt);
minWait();
enterKeys(text_fromAmount2, frmrange2);
enterKeys(text_toAmount2, "0");
enterKeys(text_applicablePercentageAmount2, "5");

click(btn_btnSave);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
waitForFrameAndSwitch(screenFrame);

click(btn_volumeincentivelov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovagentCode,agentCode_new);

click(btn_volumeincentivelovlistButton);
minWait();
check(chkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);
minWait();
switchToFirstWindow();
waitForFrameAndSwitch(screenFrame);
String VolIncID=(waitForElement(text_volumeIncentiveId).getAttribute("value"));
System.out.println("Volume Incentive_ID:"+VolIncID);
FChargeAddn=PropertyHandler.setPropValue(dataFilePath, VInc_ID, VolIncID);
click(btn_btnList);
minWait();
Assert.assertTrue(waitForElement(div_status).getText().contains("New"));
click(btn_btnActive);
minWait();
driver.switchTo().defaultContent();
click(btn_noBtn);
minWait();
waitForFrameAndSwitch(screenFrame);

Assert.assertTrue(waitForElement(div_status).getText().contains("New"));
click(btn_btnActive);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);
//minWait();
//driver.switchTo().defaultContent();

//click(btn_ok);
waitForFrameAndSwitch(screenFrame);
Assert.assertTrue(waitForElement(div_status).getText().contains("Active"));
return this;


}
public CRA071 SaveandModifyVolumeIncentive(String agentCode_new, String frmdate,String toDate,String currency,String FChargeAddn,String VInc_ID){

agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
frmdate = PropertyHandler.getPropValue(dataFilePath, frmdate);

toDate=PropertyHandler.getPropValue(dataFilePath, toDate);
currency=PropertyHandler.getPropValue(dataFilePath, currency);
FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);

enterKeys(text_agentCode, agentCode_new);
click(btn_btnCreate);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);

selectByValue(dropdown_targetPeriodBasis, "Bi-Monthly");
click(btn_targetperiodbasislov);
waitForNewWindow(2);
switchToSecondWindow();
check(checkbox_targetperiodbasislovcheckBasis8);
click(btn_targetperiodbasislovbtOk);

waitForFrameAndSwitch(screenFrame);


enterKeys(text_targetAmount, "50");
enterKeys(text_currencyCode, currency);
enterKeys(text_payoutCurrency, currency);
click(btn_payoutAmountBasis);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_payoutAmountBasischeckBasis8);
click(btn_payoutAmountBasisbtOk);
waitForFrameAndSwitch(screenFrame);
click(btn_addLinkAmt);
minWait();
enterKeys(text_fromAmount1, "0");
enterKeys(text_toAmount1, FChargeAddn);
int FCA = Integer.parseInt(FChargeAddn);
FCA=FCA+1;
String frmrange2=String.valueOf(FCA);
enterKeys(text_applicablePercentageAmount1, "2");
click(btn_addLinkAmt);
minWait();
enterKeys(text_fromAmount2, frmrange2);
enterKeys(text_toAmount2, "0");
enterKeys(text_applicablePercentageAmount2, "5");

click(btn_btnSave);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
waitForFrameAndSwitch(screenFrame);

click(btn_volumeincentivelov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovagentCode,agentCode_new);

click(btn_volumeincentivelovlistButton);
minWait();
check(chkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);

waitForFrameAndSwitch(screenFrame);
String VolIncID=(waitForElement(text_volumeIncentiveId).getAttribute("value"));
System.out.println("Volume Incentive_ID:"+VolIncID);
FChargeAddn=PropertyHandler.setPropValue(dataFileName, VInc_ID, VolIncID);
click(btn_btnList);
minWait();
enterKeys(text_targetAmount, "55");
enterKeys(text_applicablePercentageAmount1, "3");
click(btn_btnSave);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
waitForFrameAndSwitch(screenFrame);
return this;


}

public CRA071 CreateVolumeIncentiveWithHoldingComp(String agentCode_new, String frmdate,String toDate,String currency,String FChargeAddn,String VInc_ID){

agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
frmdate = PropertyHandler.getPropValue(dataFilePath, frmdate);

toDate=PropertyHandler.getPropValue(dataFilePath, toDate);
currency=PropertyHandler.getPropValue(dataFilePath, currency);
FChargeAddn=PropertyHandler.getPropValue(dataFilePath, FChargeAddn);

enterKeys(text_agentCode, agentCode_new);
click(btn_holdingcodelov);
waitForNewWindow(2);
switchToSecondWindow();
check(chk_holdingcode);
click(btn_holdingcodebtnOk);
minWait();
waitForFrameAndSwitch(screenFrame);
click(btn_btnCreate);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);

selectByValue(dropdown_targetPeriodBasis, "Bi-Monthly");
click(btn_targetperiodbasislov);
waitForNewWindow(2);
switchToSecondWindow();
check(checkbox_targetperiodbasislovcheckBasis8);
click(btn_targetperiodbasislovbtOk);

waitForFrameAndSwitch(screenFrame);


enterKeys(text_targetAmount, "50");
enterKeys(text_currencyCode, currency);
enterKeys(text_payoutCurrency, currency);
click(btn_payoutAmountBasis);
waitForNewWindow(2);
switchToSecondWindow();
check(chkbox_payoutAmountBasischeckBasis8);
click(btn_payoutAmountBasisbtOk);
waitForFrameAndSwitch(screenFrame);
click(btn_addLinkAmt);
minWait();
enterKeys(text_fromAmount1, "0");

enterKeys(text_toAmount1, FChargeAddn);
int FCA = Integer.parseInt(FChargeAddn);
FCA=FCA+1;
String frmrange2=String.valueOf(FCA);
enterKeys(text_applicablePercentageAmount1, "2");
click(btn_addLinkAmt);
minWait();
enterKeys(text_fromAmount2, frmrange2);
enterKeys(text_toAmount2, "0");
enterKeys(text_applicablePercentageAmount2, "5");

click(btn_btnSave);
minWait();
driver.switchTo().defaultContent();
click(btn_ok);
waitForFrameAndSwitch(screenFrame);

click(btn_volumeincentivelov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovagentCode,agentCode_new);

click(btn_volumeincentivelovlistButton);
minWait();
check(chkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);

waitForFrameAndSwitch(screenFrame);
String VolIncID=(waitForElement(text_volumeIncentiveId).getAttribute("value"));
System.out.println("Volume Incentive_ID:"+VolIncID);
FChargeAddn=PropertyHandler.setPropValue(dataFileName, VInc_ID, VolIncID);
click(btn_btnList);
minWait();
Assert.assertTrue(waitForElement(div_status).getText().contains("New"));
click(btn_btnActive);
minWait();
driver.switchTo().defaultContent();
click(btn_noBtn);
minWait();
driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(div_status).getText().contains("New"));
click(btn_btnActive);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);
minWait();
driver.switchTo().defaultContent();

click(btn_ok);
waitForFrameAndSwitch(screenFrame);
Assert.assertTrue(waitForElement(div_status).getText().contains("Active"));
return this;


}

public CRA071 InactivateVolumeIncentive(String agentCode_new, String frmdate,String toDate,String currency,String FChargeAddn,String VInc_ID){


	VInc_ID=PropertyHandler.getPropValue(dataFilePath, VInc_ID);

click(btn_volumeincentivelov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovagentCode,agentCode_new);

click(btn_volumeincentivelovlistButton);
minWait();
check(chkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);

waitForFrameAndSwitch(screenFrame);
click(btn_btnList);
minWait();
click(btn_btnInactive);
minWait();
driver.switchTo().defaultContent();
minWait();
driver.switchTo().defaultContent();
click(btn_noBtn);
minWait();
driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(div_status).getText().contains("Active"));
click(btn_btnInactive);
minWait();
driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want change the status to Inactive?"));
click(yesBtn);
minWait();
driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(div_status).getText().contains("Inactive"));
return this;


}
public CRA071 CheckModifyingActiveVolInv(String agentCode_new, String frmdate,String toDate,String VInc_ID){


	VInc_ID=PropertyHandler.getPropValue(dataFilePath, VInc_ID);

click(btn_volumeincentivelov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovagentCode,agentCode_new);

click(btn_volumeincentivelovlistButton);
minWait();
check(chkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);

waitForFrameAndSwitch(screenFrame);
click(btn_btnList);
minWait();
Assert.assertFalse(waitForElement(text_targetAmount).isEnabled(), "Able to modify Active Volume incentive");
return this;


}


public CRA071 DeleteSavedVol_Inv(String agentCode_new, String frmdate,String toDate,String currency,String FChargeAddn,String VInc_ID){


	VInc_ID=PropertyHandler.getPropValue(dataFilePath, VInc_ID);

click(btn_volumeincentivelov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovagentCode,agentCode_new);

click(btn_volumeincentivelovlistButton);
minWait();
check(chkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);

waitForFrameAndSwitch(screenFrame);
click(btn_btnList);
minWait();
click(btn_btnDelete);
minWait();
driver.switchTo().defaultContent();
minWait();
driver.switchTo().defaultContent();
click(btn_noBtn);
minWait();
driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(div_status).getText().contains("Active"));
click(btn_btnInactive);
minWait();
driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want change the status to Inactive?"));
click(yesBtn);
minWait();
driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(div_status).getText().contains("Inactive"));
return this;


}
public CRA071 ActivateInactiveVolInv(String agentCode_new, String frmdate,String toDate,String currency,String FChargeAddn,String VInc_ID){


	VInc_ID=PropertyHandler.getPropValue(dataFilePath, VInc_ID);

click(btn_volumeincentivelov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovagentCode,agentCode_new);

click(btn_volumeincentivelovlistButton);
minWait();
check(chkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);

waitForFrameAndSwitch(screenFrame);
click(btn_btnList);
minWait();
click(btn_btnActive);
minWait();
driver.switchTo().defaultContent();
click(btn_noBtn);
minWait();
driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(div_status).getText().contains("New"));
click(btn_btnActive);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);
minWait();
driver.switchTo().defaultContent();

click(btn_ok);
waitForFrameAndSwitch(screenFrame);
Assert.assertTrue(waitForElement(div_status).getText().contains("Active"));
return this;

}

public CRA071 SelectChargebasis(String agentCode_new){

agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);

enterKeys(text_agentCode, agentCode_new);
click(btn_btnCreate);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);


click(btn_targetperiodbasislov);
waitForNewWindow(2);
switchToSecondWindow();
check(checkbox_targetperiodbasislovcheckBasis8);
tblSetListValueByColValue(tbl_chargebasisbasicPopupTable, 2, 3, "OCDA", "+");
check(checkbox_targetperiodbasischeckBasis10);
minWait();
Assert.assertTrue(waitForElement(txt_basisValue).getText().contains("MKTCHG+OCDA"),"Error: The selected formula not displayed in the bottom");
check(checkbox_targetperiodbasischeckBasis10);
minWait();
Assert.assertTrue(waitForElement(txt_basisValue).getText().contains("MKTCHG"),"Error: The selected formula not changed in the bottom");
click(btn_targetperiodbasislovbtOk);
minWait();
waitForFrameAndSwitch(screenFrame);
Assert.assertTrue(waitForElement(text_chargeBasis).getText().contains("MKTCHG"),"Error: The selected formula not shown in chargeBasis");

return this;


}
public CRA071 SelectChargebasisWithMissingOperand(String agentCode_new){
agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
enterKeys(text_agentCode, agentCode_new);
click(btn_btnCreate);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);
click(btn_targetperiodbasislov);
waitForNewWindow(2);
switchToSecondWindow();
check(checkbox_targetperiodbasislovcheckBasis8);
check(checkbox_targetperiodbasischeckBasis10);
click(btn_targetperiodbasislovbtOk);
minWait();
Assert.assertTrue(waitForElement(info_error).getText().contains("Operand missing.Please select appropriate operand"),"Error: Missing Operand Error not shown");
click(btn_closetargetperiodbasislov);
driver.switchTo().defaultContent();
Assert.assertTrue(waitForElement(info_msg).getText().contains("Unsaved data exists. Do you want to continue?"),"Error: Message not shown");
click(yesBtn);
waitForFrameAndSwitch(screenFrame);

return this;

}

public CRA071 Cleardata(String agentCode_new){
agentCode_new = PropertyHandler.getPropValue(dataFilePath, agentCode_new);
enterKeys(text_agentCode, agentCode_new);
click(btn_btnCreate);
minWait();
driver.switchTo().defaultContent();
click(yesBtn);
click(btn_targetperiodbasislov);
waitForNewWindow(2);
switchToSecondWindow();
check(checkbox_targetperiodbasislovcheckBasis8);
minWait();
Assert.assertTrue(waitForElement(txt_basisValue).getText().contains("MKTCHG"),"Error: The selected formula not changed in the bottom");

click(btn_targetperiodbasislovbtClear);
minWait();
Assert.assertTrue(waitForElement(txt_basisValue).getText().isEmpty(),"Error: The value is not cleared");
waitForFrameAndSwitch(screenFrame);

return this;

}
public CRA071 DeleteVolInv(String agentCode_new,String VInc_ID){


	VInc_ID=PropertyHandler.getPropValue(dataFilePath, VInc_ID);

click(btn_volumeincentivelov);
waitForNewWindow(2);
switchToSecondWindow();
enterKeys(text_volumeincentivelovagentCode,agentCode_new);

click(btn_volumeincentivelovlistButton);
minWait();
check(chkbox_volumeincentivelovselectCheckBox);
click(btn_volumeincentivelovokButton);

waitForFrameAndSwitch(screenFrame);
click(btn_btnList);
minWait();

click(btn_btnListAccEntries);
 if(driver.getTitle().contains("List Accounting Entries"))

minWait();

waitForFrameAndSwitch(screenFrame);

return this;

}



    public HomePage close() {

        click(btn_btnClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
