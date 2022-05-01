package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-7681 on 1/23/2018.
 */
public class OPR015 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameOPR015";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By txt_fltCarCode,
            txt_fltNo,
            txt_fltDt,
            btn_list,
            btn_clear,
            btn_lyingList,
            txt_lyingListFrmDt,
            txt_lyingListToDt,
            txt_lyingListAwbPre,
            txt_lyingListAwbNo,
            btn_lyingList_list,
            chkBx_lyingListSelectAll,
            btn_lyingListOk,
            btn_save,
            btn_close,
            tbl_loadPlanAWB,
            dropdown_selectPosition,
            btn_assign,
            btn_awbTab,
            btn_uldTab,
            info_msgClose,
            msg_footer,
            link_more,
            btn_configureSegPos,
            txt_segmentPosition_L3,
            txt_segmentPosition_L7,
            txt_segmentPosition_Q6,
            txt_segmentPosition_Q7,
            btn_segmentPosition_Ok,
            btn_chooseULDConfig,
            dropdown_chooseULDConfig_configName,
            btn_chooseULDConfig_list,
            checkbox_chooseULDConfig_checkAll,
            btn_chooseULDConfig_Ok,
            tbl_positionTable,
            btn_preCarriage,
            txt_preCarriage_fltcc,
            txt_preCarriage_fltNo,
            txt_preCarriage_fltDt,
            btn_preCarriage_list,
            checkbox_preCarriage_checkAll,
            btn_preCarriage_Ok,
            checkbox_awbCheckAll,
            btn_printPicLoadAdvice,
            btn_releaseToOps,
            btn_split,
            txt_splitShipment_pcs,
            txt_splitShipment_vol,
            dropdown_splitShipment_position,
            btn_splitShipment_Ok,
            btn_splitShipment_next,
            btn_planForSeg,
            btn_unassign,
            dropdown_segment,
            link_addAWB,
            txt_addAWB_awbPre,
            txt_addAWB_awbNo,
            btn_addAWB_list,
            txt_addAWB_origin,
            txt_addAWB_destn,
            txt_addAWB_stdPcs,
            txt_addAWB_stdWt,
            txt_addAWB_plannedPcs,
            txt_addAWB_plannedWt,
            btn_addAWB_Ok,
            btn_generateFBL,
            btn_sendFBR,
            txt_version;

    private By btn_genericYes,
            btn_genericOk,
            info_msg;


    public OPR015(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        txt_fltCarCode = MiscUtility.getWebElement(objFilepath, "OPR015_txt_fltCarCode");
        txt_fltNo = MiscUtility.getWebElement(objFilepath, "OPR015_txt_fltNo");
        txt_fltDt = MiscUtility.getWebElement(objFilepath, "OPR015_txt_fltDt");
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR015_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "OPR015_btn_clear");
        btn_lyingList = MiscUtility.getWebElement(objFilepath, "OPR015_btn_lyingList");
        txt_lyingListFrmDt = MiscUtility.getWebElement(objFilepath, "OPR015_txt_lyingListFrmDt");
        txt_lyingListToDt = MiscUtility.getWebElement(objFilepath, "OPR015_txt_lyingListToDt");
        txt_lyingListAwbPre = MiscUtility.getWebElement(objFilepath, "OPR015_txt_lyingListAwbPre");
        txt_lyingListAwbNo = MiscUtility.getWebElement(objFilepath, "OPR015_txt_lyingListAwbNo");
        btn_lyingList_list = MiscUtility.getWebElement(objFilepath, "OPR015_btn_lyingList_list");
        chkBx_lyingListSelectAll = MiscUtility.getWebElement(objFilepath, "OPR015_chkBx_lyingListSelectAll");
        btn_lyingListOk = MiscUtility.getWebElement(objFilepath, "OPR015_btn_lyingListOk");
        btn_save = MiscUtility.getWebElement(objFilepath, "OPR015_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR015_btn_close");
        tbl_loadPlanAWB = MiscUtility.getWebElement(objFilepath, "OPR015_tbl_loadPlanAWB");
        dropdown_selectPosition = MiscUtility.getWebElement(objFilepath, "OPR015_dropdown_selectPosition");
        btn_assign = MiscUtility.getWebElement(objFilepath, "OPR015_btn_assign");
        btn_awbTab = MiscUtility.getWebElement(objFilepath, "OPR015_btn_awbTab");
        btn_uldTab = MiscUtility.getWebElement(objFilepath, "OPR015_btn_uldTab");
        link_more = MiscUtility.getWebElement(objFilepath, "OPR015_lnk_more");
        btn_configureSegPos = MiscUtility.getWebElement(objFilepath, "OPR015_btn_configureSegPos");
        txt_segmentPosition_L3 = MiscUtility.getWebElement(objFilepath, "OPR015_txt_segmentPosition_L3");
        txt_segmentPosition_L7 = MiscUtility.getWebElement(objFilepath, "OPR015_txt_segmentPosition_L7");
        txt_segmentPosition_Q6 = MiscUtility.getWebElement(objFilepath, "OPR015_txt_segmentPosition_Q6");
        txt_segmentPosition_Q7 = MiscUtility.getWebElement(objFilepath, "OPR015_txt_segmentPosition_Q7");
        btn_segmentPosition_Ok = MiscUtility.getWebElement(objFilepath, "OPR015_btn_segmentPosition_Ok");
        btn_chooseULDConfig	 = MiscUtility.getWebElement(objFilepath, "OPR015_btn_chooseULDConfig");
        dropdown_chooseULDConfig_configName = MiscUtility.getWebElement(objFilepath, "OPR015_dropdown_chooseULDConfig_configName");
        btn_chooseULDConfig_list = MiscUtility.getWebElement(objFilepath, "OPR015_btn_chooseULDConfig_list");
        checkbox_chooseULDConfig_checkAll = MiscUtility.getWebElement(objFilepath, "OPR015_checkbox_chooseULDConfig_checkAll");
        btn_chooseULDConfig_Ok = MiscUtility.getWebElement(objFilepath, "OPR015_btn_chooseULDConfig_Ok");
        tbl_positionTable = MiscUtility.getWebElement(objFilepath, "OPR015_tbl_positionTable");
        btn_planForSeg = MiscUtility.getWebElement(objFilepath, "OPR015_btn_planForSeg");
        btn_unassign = MiscUtility.getWebElement(objFilepath, "OPR015_btn_unassign");
        dropdown_segment = MiscUtility.getWebElement(objFilepath, "OPR015_dropdown_segment");
        txt_version = MiscUtility.getWebElement(objFilepath, "OPR015_txt_version");
        
        checkbox_awbCheckAll = MiscUtility.getWebElement(objFilepath, "OPR015_checkbox_awbCheckAll");
        btn_releaseToOps = MiscUtility.getWebElement(objFilepath, "OPR015_btn_releaseToOps");
        btn_printPicLoadAdvice = MiscUtility.getWebElement(objFilepath, "OPR015_btn_printPicLoadAdvice");
        btn_split = MiscUtility.getWebElement(objFilepath, "OPR015_btn_split");
        txt_splitShipment_pcs = MiscUtility.getWebElement(objFilepath, "OPR015_txt_splitShipment_pcs");
        txt_splitShipment_vol = MiscUtility.getWebElement(objFilepath, "OPR015_txt_splitShipment_vol");
        dropdown_splitShipment_position = MiscUtility.getWebElement(objFilepath, "OPR015_dropdown_splitShipment_position");
        btn_splitShipment_Ok = MiscUtility.getWebElement(objFilepath, "OPR015_btn_splitShipment_Ok");
        btn_splitShipment_next = MiscUtility.getWebElement(objFilepath, "OPR015_btn_splitShipment_next");
        
        link_addAWB = MiscUtility.getWebElement(objFilepath, "OPR015_link_addAWB");
        txt_addAWB_awbPre = MiscUtility.getWebElement(objFilepath, "OPR015_txt_addAWB_awbPre");
        txt_addAWB_awbNo = MiscUtility.getWebElement(objFilepath, "OPR015_txt_addAWB_awbNo");
        btn_addAWB_list = MiscUtility.getWebElement(objFilepath, "OPR015_btn_addAWB_list");
        txt_addAWB_origin = MiscUtility.getWebElement(objFilepath, "OPR015_txt_addAWB_origin");
        txt_addAWB_destn = MiscUtility.getWebElement(objFilepath, "OPR015_txt_addAWB_destn");
        txt_addAWB_stdPcs = MiscUtility.getWebElement(objFilepath, "OPR015_txt_addAWB_stdPcs");
        txt_addAWB_stdWt = MiscUtility.getWebElement(objFilepath, "OPR015_txt_addAWB_stdWt");
        txt_addAWB_plannedPcs = MiscUtility.getWebElement(objFilepath, "OPR015_txt_addAWB_plannedPcs");
        txt_addAWB_plannedWt = MiscUtility.getWebElement(objFilepath, "OPR015_txt_addAWB_plannedWt");
        btn_addAWB_Ok = MiscUtility.getWebElement(objFilepath, "OPR015_btn_addAWB_Ok");
        
        btn_generateFBL = MiscUtility.getWebElement(objFilepath, "OPR015_btn_generateFBL");
        btn_sendFBR = MiscUtility.getWebElement(objFilepath, "OPR015_btn_sendFBR");
        btn_preCarriage = MiscUtility.getWebElement(objFilepath, "OPR015_btn_preCarriage");
        txt_preCarriage_fltcc = MiscUtility.getWebElement(objFilepath, "OPR015_txt_preCarriage_fltcc");
        txt_preCarriage_fltNo = MiscUtility.getWebElement(objFilepath, "OPR015_txt_preCarriage_fltNo");
        txt_preCarriage_fltDt = MiscUtility.getWebElement(objFilepath, "OPR015_txt_preCarriage_fltDt");
        btn_preCarriage_list = MiscUtility.getWebElement(objFilepath, "OPR015_btn_preCarriage_list");
        checkbox_preCarriage_checkAll = MiscUtility.getWebElement(objFilepath, "OPR015_checkbox_preCarriage_checkAll");
        btn_preCarriage_Ok = MiscUtility.getWebElement(objFilepath, "OPR015_btn_preCarriage_Ok");
        
        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_genericOk = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        info_msgClose = MiscUtility.getWebElement(genObjPath, "Generic_info_close1");
        info_msg	= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
	    msg_footer = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    }

    /**
     * addes an awb from the lying list to the flight
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @return
     * @author Arun A-7681
     */
    public OPR015 addAWBfromLyingList(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo) {

        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(carrCode, fltNo, fltDt);
        maxWait();
        click(btn_lyingList);
        waitForNewWindow(2);
        switchToSecondWindow();

        enterKeys(txt_lyingListFrmDt, "");
        enterKeys(txt_lyingListToDt, "");
        enterKeys(txt_lyingListAwbPre, awbPre);
        enterKeys(txt_lyingListAwbNo, awbNo);
        click(btn_lyingList_list);
        check(chkBx_lyingListSelectAll);
        click(btn_lyingListOk);

        switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        minWait();
        maxWait();
        save();
        maxWait();
        scrollToView(tbl_loadPlanAWB);
        Assert.assertTrue(getTableColumnValues(tbl_loadPlanAWB, 3).contains((String) awbNo));

        return this;
    }

    /**
     * Generates load plan for a flight
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @return
     * @author Arun A-7681
     */
    public OPR015 generateLoadPlan(String carrCode, String fltNo, String fltDt){
        carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

        list(carrCode,fltNo,fltDt);
        minWait();
        click(btn_planForSeg);

        click(btn_save);
        minWait();

        return this;
    }

    /**
     * Method to asign an AWB from AWB tab to specific position
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param position can be null for BULK
     * @param dest <optional> must be present when position is BULK
     * @param version
     * @return
     * @author a-7868 Krishna <01/02/2018>
     */
    public OPR015 assignAWBToPosition(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo, String position, String dest, int version){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        if(dest!=null)	dest = PropertyHandler.getPropValue(dataFilePath, dest);
    	list(carrCode, fltNo, fltDt);
    	minWait();
    	
    	scrollToView(tbl_loadPlanAWB);
    	tblSelectRowByColValue(tbl_loadPlanAWB, 1, 3, awbNo);
    	if(position==null)	selectByText(dropdown_selectPosition, "BLK-"+dest.trim()); //change required
    	else				selectByText(dropdown_selectPosition, position);
    	click(btn_assign);
    	minWait();
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_genericYes))
    		click(btn_genericYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	waitForElement(By.xpath("/html/body/div[14]/div/div/div[1][contains(@class, 'success')]")); //waits for green success message (to handle the orange warning message)
    	Assert.assertTrue(waitForElement(By.xpath("/html/body/div[14]/div/div/p")).getText().contains("version "+version), "ERROR : Invalid message ");
    	 maxWait();
         click(btn_clear);
    	return this;
    }
    
    /**
     * Method to click GenerateFBL button
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @return
     * @author A-7868 Krishna <16/02/2018>
     */
    public OPR015 generateFBL(String carrCode, String fltNo, String fltDt){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        
        list(carrCode, fltNo, fltDt);
    	minWait();
    	
    	click(btn_generateFBL);
    	driver.switchTo().defaultContent();
    	waitForElement(btn_genericOk);
    	click(btn_genericOk);
    	waitForFrameAndSwitch(FRAME);
    	click(btn_clear);
    	return this;
    }
    
    /**
     * Method to click SendFBR button
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @return
     * @author A-7868 Krishna <16/02/2018>
     */
    public OPR015 sendFBR(String carrCode, String fltNo, String fltDt){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        
        list(carrCode, fltNo, fltDt);
    	minWait();
    	
    	click(btn_sendFBR);
    	driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(msg_footer).getText().contains("successfully"), "ERROR : FBR Not sent.");
    	waitForFrameAndSwitch(FRAME);
    	click(btn_clear);
    	return this;
    }
    
    /**
     * Method to asign multiple AWB from AWB tab to specific position
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param position can be null for BULK
     * @param version
     * @return
     * @author a-7868 Krishna <01/02/2018>
     */
    public OPR015 assignMultipleAWBToPosition(String carrCode, String fltNo, String fltDt, int noOfAWBs, String position, int version){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
                
    	list(carrCode, fltNo, fltDt);
    	minWait();
    	scrollToView(tbl_loadPlanAWB);
    	check(checkbox_awbCheckAll);
    	selectByIndex(dropdown_selectPosition, 0);
    	click(btn_assign);
    	minWait();
    	
    	expandPositionTableAccordingly();
    	//validate contents in position table
    	boolean check = verifyValuePresentInTblColumn(tbl_positionTable, 4, String.valueOf(noOfAWBs));
    	check = check & verifyValuePresentInTblColumn(tbl_positionTable, 5, String.valueOf(noOfAWBs*10)); //pcs=10
    	check = check & verifyValuePresentInTblColumn(tbl_positionTable, 6, String.valueOf(noOfAWBs*100)); //wt=100
    	Assert.assertTrue(check, "ERROR : AWB details are incorrect in Position details table");
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_genericYes))
    		click(btn_genericYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	waitForElement(By.xpath("/html/body/div[14]/div/div/div[1][contains(@class, 'success')]")); //waits for green success message (to handle the orange warning message)
    	Assert.assertTrue(waitForElement(By.xpath("/html/body/div[14]/div/div/p")).getText().contains("version "+version), "ERROR : Invalid message ");
    	
    	 maxWait();
         click(btn_clear);
    	return this;
    }
    
    /**
     * Method to add ULD Config position and assign
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param position can be L3, L7, Q6, Q7
     * @param version
     * @return
     * @author a-7868 Krishna <02/02/2018>
     */
    public OPR015 addULDConfigAndAssign(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo, String position, int version){
    	
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        
    	list(carrCode, fltNo, fltDt);
    	
    	//add uld config
    	expandPositionTableAccordingly();
    	click(btn_configureSegPos);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	if(position.equals("L3"))	{ enterKeys(txt_segmentPosition_L3, "1");		position="LDC-01";	}
    	if(position.equals("L7"))	{ enterKeys(txt_segmentPosition_L7, "1");		position="LDP-01";	}
    	if(position.equals("Q6"))	{ enterKeys(txt_segmentPosition_Q6, "1");		position="MDP-01";	}
    	if(position.equals("Q7"))	{ enterKeys(txt_segmentPosition_Q7, "1");		position="Q7-01";	}
    	click(btn_segmentPosition_Ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	collapsePositionTableAccordingly();
    	tblSelectRowByColValue(tbl_loadPlanAWB, 1, 3, awbNo);
    	selectByText(dropdown_selectPosition, position);
    	click(btn_assign);
    	minWait();
    	//add table verification
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(msg_footer).getText().contains("version "+version), "ERROR : Invalid message ");
    	//driver.switchTo().defaultContent();
    	//Assert.assertTrue(waitForElement(msg_footer).getText().contains("version "+version), "ERROR : Invalid message ");
    	Assert.assertTrue(waitForElement(By.xpath("/html/body/div[14]/div/div/p")).getText().contains("version "+version), "ERROR : Invalid message ");
    	
    	 maxWait();
         click(btn_clear);
    	return this;
    }
    
    /**
     * Method to add exisiting ULD Config and assign
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param ULDConfigName
     * @param uldType
     * @param version
     * @return
     * @author a-7868 Krishna <02/02/2018>
     */
    public OPR015 chooseULDConfigAndAssign(String carrCode, String fltNo, String fltDt, String awbPre, 
    		String awbNo, String ULDConfigName, String uldType, int version){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        ULDConfigName = PropertyHandler.getPropValue(dataFilePath, ULDConfigName);
        uldType = PropertyHandler.getPropValue(dataFilePath, uldType);
        
    	list(carrCode, fltNo, fltDt);
    	
    	//add uld config
    	expandPositionTableAccordingly();
    	click(btn_chooseULDConfig);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	selectByText(dropdown_chooseULDConfig_configName, ULDConfigName);
    	click(btn_chooseULDConfig_list);
    	minWait();
    	check(checkbox_chooseULDConfig_checkAll);
    	click(btn_chooseULDConfig_Ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	collapsePositionTableAccordingly();
    	tblSelectRowByColValue(tbl_loadPlanAWB, 1, 3, awbNo);
    	selectByText(dropdown_selectPosition, uldType+"-01");
    	click(btn_assign);
    	minWait();
    	//add table verification
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	//driver.switchTo().defaultContent();
    	Assert.assertTrue(waitForElement(By.xpath("/html/body/div[14]/div/div/p")).getText().contains("version "+version), "ERROR : Invalid message ");
    	 maxWait();
         click(btn_clear);
    	return this;
    }
    
    /**
     * Method to asign an AWB from PreCarriage list
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param frmCarrCode 
     * @param frmFltNo 
     * @param version
     * @param position can be null for BULK
     * @return
     * @author a-7868 Krishna <03/02/2018>
     */
    public OPR015 assignPreCarriageAWBToPosition(String carrCode, String fltNo, String fltDt, 
    		String awbPre, String awbNo, String frmCarrCode, String frmFltNo, String futureDt, 
    		int version){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        futureDt = PropertyHandler.getPropValue(dataFilePath, futureDt);
        frmCarrCode = PropertyHandler.getPropValue(dataFilePath, frmCarrCode);
        frmFltNo = PropertyHandler.getPropValue(dataFilePath, frmFltNo);
        
    	list(carrCode, fltNo, fltDt);
    	
    	click(btn_preCarriage);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(txt_preCarriage_fltcc, frmCarrCode);
    	enterKeys(txt_preCarriage_fltNo, frmFltNo);
    	enterKeys(txt_preCarriage_fltDt, futureDt);
    	click(btn_preCarriage_list);
    	minWait();
    	check(checkbox_preCarriage_checkAll);
    	click(btn_preCarriage_Ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	scrollToView(tbl_loadPlanAWB);
    	tblSelectRowByColValue(tbl_loadPlanAWB, 1, 3, awbNo);
    	selectByIndex(dropdown_selectPosition, 0);
    	click(btn_assign);
    	minWait();
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_genericYes))
    		click(btn_genericYes);
    	waitForFrameAndSwitch(FRAME);
    	click(btn_save);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_genericYes))
    		click(btn_genericYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	//driver.switchTo().defaultContent();
    	waitForElement(By.xpath("/html/body/div[14]/div/div/div[1][contains(@class, 'success')]")); //waits for green success message (to handle the orange warning message)
    	Assert.assertTrue(waitForElement(By.xpath("/html/body/div[14]/div/div/p")).getText().contains("version "+version), "ERROR : Invalid message ");
    	maxWait();
        click(btn_clear);
    	return this;
    }
    
    /**
     * Method to list a flight and click Release to Ops and verify the version number
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param version
     * @return
     * @author a-7868 Krishna <05/02/2018>
     */
    public OPR015 releaseToOPS(String carrCode, String fltNo, String fltDt, int version){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        
        list(carrCode, fltNo, fltDt);
        minWait();
        click(btn_releaseToOps);
        driver.switchTo().defaultContent();
        if(verifyElementPresent(btn_genericYes))
        	click(btn_genericYes);
        waitForFrameAndSwitch(FRAME);
        Assert.assertTrue(waitForElement(By.xpath("/html/body/div[14]/div/div/p")).getText().toLowerCase().contains("version "+version), "ERROR : Invalid message ");
        maxWait();
        click(btn_clear);
    	return this;
    }
    
    /**
     * Method to list a flight and click print pict. load advice
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param version
     * @return
     * @author a-7868 Krishna <05/02/2018>
     */
    public OPR015 printPicLoadAdvice(String carrCode, String fltNo, String fltDt){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        
        list(carrCode, fltNo, fltDt);
        minWait();
        click(btn_printPicLoadAdvice);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();
        closeAndmoveToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        click(btn_clear);
    	return this;
    }
    
    /**
     * Method to split and assign an AWb to two diff positions
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param position1
     * @param position2
     * @param version
     * @return
     * @author a-7868 Krishna <05/02/2018>
     */
    public OPR015 splitAndAssignAWB(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo,
    		String position1, String position2, int version){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
//        position1 = PropertyHandler.getPropValue(dataFilePath, position1);
//        position2 = PropertyHandler.getPropValue(dataFilePath, position2);
        
        
        list(carrCode, fltNo, fltDt);
        minWait();
        
        expandPositionTableAccordingly();
    	click(btn_configureSegPos);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(txt_segmentPosition_L3, "1");
    	enterKeys(txt_segmentPosition_L7, "1");
    	enterKeys(txt_segmentPosition_Q6, "1");
    	enterKeys(txt_segmentPosition_Q7, "1");
    	
    	
    	if(position1.equals("L3"))	position1="LDC-01";
    	if(position1.equals("L7"))	position1="LDP-01";
    	if(position1.equals("Q6"))	position1="MDP-01";
    	if(position1.equals("Q7"))	position1="Q7-01";
    	
    	if(position2.equals("L3"))	position2="LDC-01";
    	if(position2.equals("L7"))	position2="LDP-01";
    	if(position2.equals("Q6"))	position2="MDP-01";
    	if(position2.equals("Q7"))	position2="Q7-01";
    	
    	click(btn_segmentPosition_Ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	collapsePositionTableAccordingly();
    	scrollToView(tbl_loadPlanAWB);
    	tblSelectRowByColValue(tbl_loadPlanAWB, 1, 3, awbNo);
        
    	click(btn_split);
    	driver.switchTo().defaultContent();
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	enterKeys(txt_splitShipment_pcs, "5");
    	enterKeys(txt_splitShipment_vol, "0.005");
    	selectByText(dropdown_splitShipment_position, position1);
    	click(btn_splitShipment_next);
    	minWait();
    	enterKeys(txt_splitShipment_pcs, "5");
    	enterKeys(txt_splitShipment_vol, "0.005");
    	selectByText(dropdown_splitShipment_position, position2);
    	click(btn_splitShipment_Ok);
    	switchToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	
    	expandPositionTableAccordingly();
    	if(!tblGetTextByColValue(tbl_positionTable, 5, 1, position1).trim().equals("5")) //pcs column
    		Assert.fail("ERROR : Position table value mismatch");
    	if(!tblGetTextByColValue(tbl_positionTable, 5, 1, position2).equals("5")) //pcs column
    		Assert.fail("ERROR : Position table value mismatch");
    	
    	click(btn_save);
    	Assert.assertTrue(waitForElement(By.xpath("/html/body/div[14]/div/div/p")).getText().contains("version "+version), "ERROR : Invalid message ");
    	maxWait();
    	click(btn_clear); 
    	return this;
    }
    
    /**
     * Method to expand the more section accordingly
     * @author a-7868 Krishna <12/07/2018>
     */
    private void expandPositionTableAccordingly(){
    	
    	scrollToView(link_more);
    	if(!verifyElementVisible(tbl_positionTable))
    		click(link_more);
    }
    
    /**
     * Method to collapse the more section accordingly
     * @author a-7868 Krishna <12/07/2018>
     */
    private void collapsePositionTableAccordingly(){
    	
    	scrollToView(link_more);
    	if(verifyElementVisible(tbl_positionTable))
    		click(link_more);
    }
    
    /**
     * Method to list a flight, select an AWB, unassign it and save
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param version
     * @return
     * @author A-7868 Krishna <14/02/2018>
     */
    public OPR015 unAssignAWB(String carrCode, String fltNo, String fltDt, 
    							String awbPre, String awbNo, int version){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        
        list(carrCode, fltNo, fltDt);
        minWait();
        
        scrollToView(tbl_loadPlanAWB);
        tblSelectRowByColValue(tbl_loadPlanAWB, 1, 3, awbNo);
        click(btn_unassign);
        minWait();
        click(btn_save);
        
        driver.switchTo().defaultContent();
    	if(verifyElementPresent(btn_genericYes))
    		click(btn_genericYes);
    	waitForFrameAndSwitch(FRAME);
    	minWait();
    	waitForElement(By.xpath("/html/body/div[14]/div/div/div[1][contains(@class, 'success')]")); //waits for green success message (to handle the orange warning message)    	
        Assert.assertTrue(waitForElement(By.xpath("/html/body/div[14]/div/div/p")).getText().contains("version "+version), "ERROR : Invalid version ");
        maxWait();
        click(btn_clear);    	
    	return this;
    }
   
    /**
     * Method to select a specific segment and assign the awb to position
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param origin
     * @param destn
     * @param position
     * @param version
     * @return
     * @author A-7868 Krishna <14/02/2018S>
     */
    public OPR015 segmentAssignAWB(String carrCode, String fltNo, String fltDt, 
    							String awbPre, String awbNo, String origin, 
    							String destn, String position, int version){
    	
    
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        origin = PropertyHandler.getPropValue(dataFilePath, origin);
        destn = PropertyHandler.getPropValue(dataFilePath, destn);
        position = PropertyHandler.getPropValue(dataFilePath, position);
        
        list(carrCode, fltNo, fltDt);
        minWait();
        
        selectByValue(dropdown_segment, origin+"-"+destn);
        click(btn_planForSeg);
        minWait();
        scrollToView(tbl_loadPlanAWB);
        tblSelectRowByColValue(tbl_loadPlanAWB, 1, 3, awbNo);
        minWait();
        selectByValue(dropdown_selectPosition, position);
        
        click(btn_assign);
        click(btn_save);
        driver.switchTo().defaultContent();
        if(verifyElementPresent(btn_genericYes))
        	click(btn_genericYes);
        waitForFrameAndSwitch(FRAME);
        waitForElement(By.xpath("/html/body/div[14]/div/div/div[1][contains(@class, 'success')]")); //waits for green success message (to handle the orange warning message)
    	Assert.assertTrue(waitForElement(By.xpath("/html/body/div[14]/div/div/p")).getText().contains("version "+version), "ERROR : Invalid version ");
        maxWait();
        click(btn_clear);    	
    	return this;
    }
    
    /**
     * Method to list a flight, select a specific segment and validate the Buildup Summary Plan
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param origin
     * @param destn
     * @param position
     * @param version
     * @return
     * @author A-7868 Krishna <16/02/2018>
     */
    public OPR015 checkSegmentBuildupSummaryPlan(String carrCode, String fltNo, String fltDt, 
    							String origin, String destn, String position, int version){
    	
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        origin = PropertyHandler.getPropValue(dataFilePath, origin);
        destn = PropertyHandler.getPropValue(dataFilePath, destn);
        position = PropertyHandler.getPropValue(dataFilePath, position);
        
        list(carrCode, fltNo, fltDt);
        minWait();
        
        selectByValue(dropdown_segment, origin+"-"+destn);
        click(btn_planForSeg);
        minWait();
        expandPositionTableAccordingly();
        Assert.assertTrue(tblGetTextByColValue(tbl_positionTable, 4, 1, position).equals("1"), "ERROR : Value mismatch in Build up summary plan.");
        click(btn_clear);  
        
    	return this;
    }
    
    /**
     * Method to add a new AWB to the AWB tab and then assign it to position
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param origin
     * @param destn
     * @param pcs
     * @param wt
     * @param position
     * @param version
     * @return
     * @author A-7868 Krishna <16/02/2018>
     */
    public OPR015 addNewAWBAndAssignToPosition(String carrCode, String fltNo, String fltDt, 
    							String awbPre, String awbNo, String origin, String destn, 
    							String pcs, String wt, String position, int version){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        origin = PropertyHandler.getPropValue(dataFilePath, origin);
        destn = PropertyHandler.getPropValue(dataFilePath, destn);
        position = PropertyHandler.getPropValue(dataFilePath, position);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);
        
        list(carrCode, fltNo, fltDt);
        minWait();
        
        scrollToView(link_addAWB);
        click(link_addAWB);
        driver.switchTo().defaultContent();
        waitForNewWindow(2);
        switchToSecondWindow();
        
        enterKeys(txt_addAWB_awbPre, awbPre);
        enterKeys(txt_addAWB_awbNo, awbNo);
        click(btn_addAWB_list);
        minWait();
        driver.switchTo().defaultContent();
        waitForElement(btn_genericYes);
        click(btn_genericYes);
        switchToSecondWindow();
        enterKeys(txt_addAWB_origin, origin);
        enterKeys(txt_addAWB_destn, destn);
        enterKeys(txt_addAWB_stdPcs, pcs);
        enterKeys(txt_addAWB_stdWt, wt);
        enterKeys(txt_addAWB_plannedPcs, pcs);
        enterKeys(txt_addAWB_plannedWt, wt);
        click(btn_addAWB_Ok);
        waitForFrameAndSwitch(FRAME);
        
        scrollToView(tbl_loadPlanAWB);
        tblSelectRowByColValue(tbl_loadPlanAWB, 1, 3, awbNo);
        selectByValue(dropdown_selectPosition, position);        
        click(btn_assign);
        if(verifyElementPresent(btn_genericYes))
        	click(btn_genericYes);
        click(btn_save);
        waitForFrameAndSwitch(FRAME);
        Assert.assertTrue(waitForElement(By.xpath("/html/body/div[14]/div/div/p")).getText().contains("version "+version), "ERROR : Invalid version ");
        maxWait();
        click(btn_clear);   
    	return this;
    }
    /**
     * Method to check whether a position is available for a specific segment
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbPre
     * @param awbNo
     * @param origin
     * @param destn
     * @param position
     * @return
     * @author A-7868 Krishna <14/02/2018>
     */
    public OPR015 checkForPositionAvailability(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo,
    							 String origin, String destn, String position){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        origin = PropertyHandler.getPropValue(dataFilePath, origin);
        destn = PropertyHandler.getPropValue(dataFilePath, destn);
        boolean flag;
        
        list(carrCode, fltNo, fltDt);
        minWait();
        
        selectByValue(dropdown_segment, origin+"-"+destn);
        click(btn_planForSeg);
        minWait();
        scrollToView(tbl_loadPlanAWB);
        tblSelectRowByColValue(tbl_loadPlanAWB, 1, 3, awbNo);
        flag=false;
        try{
        	selectByValue(dropdown_selectPosition, position);
        }catch(Exception e){
        	flag=true;
        }
        Assert.assertTrue(flag, "ERROR : Location available for this segment");
        click(btn_clear);
    	return this;
    }
    
    /**
     * Method to list a specific version of the load planS
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param version
     * @return
     * @author A-7868 Krishna <14/02/2018>
     */
    public OPR015 listVersion(String carrCode, String fltNo, String fltDt, int version) {
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
        
        list(carrCode, fltNo, fltDt, String.valueOf(version));
        minWait();
        
        expandPositionTableAccordingly();
        Assert.assertTrue(getTableCellTextValue(tbl_positionTable, 2, 1).trim().equals(String.valueOf(version)), "ERROR : Incorrect version details");
        click(btn_clear);    	
    	return this;
    }
    
    /**
     * Method to edit position table details and save
     * Only these fields are editable: contourVal, POLVal, POUVal, posPriorityVal
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param position
     * @param contourVal (optional : use "")
     * @param POLVal (optional : use "")
     * @param POUVal (optional : use "")
     * @param posPriorityVal (optional : use "")
     * @param version
     * @return
     */
    public OPR015 updatePositionDtls(String carrCode, String fltNo, String fltDt, String position, 
    		String contourVal, String POLVal, String POUVal, String posPriorityVal, int version){
    	
    	carrCode 	= PropertyHandler.getPropValue(dataFilePath, carrCode);
        fltNo 		= PropertyHandler.getPropValue(dataFilePath, fltNo);
        fltDt		= PropertyHandler.getPropValue(dataFilePath, fltDt);
        position 	= PropertyHandler.getPropValue(dataFilePath, position);
        //optional values
        if(!contourVal.equals(""))		contourVal = PropertyHandler.getPropValue(dataFilePath, contourVal);
        if(!POLVal.equals(""))			POLVal = PropertyHandler.getPropValue(dataFilePath, POLVal);
        if(!POUVal.equals(""))			POUVal = PropertyHandler.getPropValue(dataFilePath, POUVal);
        if(!posPriorityVal.equals(""))	posPriorityVal = PropertyHandler.getPropValue(dataFilePath, posPriorityVal);
        
        list(carrCode, fltNo, fltDt);
        minWait();
        
        expandPositionTableAccordingly();
        
        By rowObj = By.xpath(".//td[contains(text(), '"+position+"')]");
        By dropdown_contour = By.xpath(".//td[contains(text(), '"+position+"')]/following-sibling::td[9]/select");
        By dropdown_POL = By.xpath(".//td[contains(text(), '"+position+"')]/following-sibling::td[10]/select");
        By dropdown_POU = By.xpath(".//td[contains(text(), '"+position+"')]/following-sibling::td[11]/select");
        By dropdown_priority = By.xpath(".//td[contains(text(), '"+position+"')]/following-sibling::td[12]/select");
        
        
        scrollToView(rowObj);
        if(!contourVal.equals(""))		selectByText(dropdown_contour, contourVal);
        if(!POLVal.equals(""))			selectByText(dropdown_POL, POLVal);
        if(!POUVal.equals(""))			selectByText(dropdown_POU, POUVal);
        if(!posPriorityVal.equals(""))	selectByText(dropdown_priority, posPriorityVal);
        
        click(btn_save);
        //waitForFrameAndSwitch(FRAME);
        Assert.assertTrue(waitForElement(By.xpath("/html/body/div[14]/div/div/p")).getText().contains("version "+version), "ERROR : Invalid version ");
    	maxWait();
        click(btn_clear); 
    	
    	return this;
    }
    /**
     * lists a flight
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @author Arun A-7681
     */
    private void list(String carrCode, String fltNo, String fltDt, String...version) {
        enterKeys(txt_fltCarCode, carrCode);
        enterKeys(txt_fltNo, fltNo);
        enterKeys(txt_fltDt, fltDt);
        try{
        	enterKeys(txt_version, version[0]);
        }catch(NullPointerException | ArrayIndexOutOfBoundsException ae){
        	;
        }
                
        click(btn_list);
        minWait();
    }

    private void save() {
        click(btn_save);
    }

    /**
     * closes the screen and goes back to home page
     *
     * @return
     * @author Arun A-7681
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
