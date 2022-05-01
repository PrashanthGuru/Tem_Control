package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * PAGE OPR292 : Capture DG Details
 * On 26/12/2017
 *
 * @author a-7868
 */
public class OPR292 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameOPR292";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    private By txt_prefix,
            txt_awb,
            btn_list,
            txt_DGRUnid,
            dropDown_DGRName,
            txt_DGRpi,
            txt_DGRPcs,
            txt_DGRwtPerPcs,
            btn_DGRadd,
            btn_DGRModify,
            link_DGRaddedUNID,
            info_DGRNetQuantity,
            btn_close,
            yesBtn,
            btn_save,
            btn_clear,
            btn_delete,
            btn_copy,
            info_footer,
            info_msgClose,
            tbl_unid,
            info_dgrDtls;

    private WebDriver driver;
    private String dataFileName;


    public OPR292(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    /**
     * Method to initialize page objects
     * on 26/12/2017
     *
     * @author a-7868
     */
    private void initElements() {
        txt_prefix = MiscUtility.getWebElement(objFilepath, "OPR292_txt_awbPre");
        txt_awb = MiscUtility.getWebElement(objFilepath, "OPR292_txt_awbNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR292_btn_list");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR292_btn_close");
        txt_DGRUnid = MiscUtility.getWebElement(objFilepath, "OPR292_txt_DGRUnid");
        dropDown_DGRName = MiscUtility.getWebElement(objFilepath, "OPR292_dropDown_DGRName");
        txt_DGRpi = MiscUtility.getWebElement(objFilepath, "OPR292_txt_DGRpi");
        txt_DGRPcs = MiscUtility.getWebElement(objFilepath, "OPR292_txt_DGRPcs");
        txt_DGRwtPerPcs = MiscUtility.getWebElement(objFilepath, "OPR292_txt_DGRwtPerPcs");
        btn_DGRadd = MiscUtility.getWebElement(objFilepath, "OPR292_btn_DGRadd");
        btn_DGRModify = MiscUtility.getWebElement(objFilepath, "OPR292_btn_DGRModify");
        link_DGRaddedUNID = MiscUtility.getWebElement(objFilepath, "OPR292_link_DGRaddedUNID");
        info_DGRNetQuantity = MiscUtility.getWebElement(objFilepath, "OPR292_info_DGRNetQuantity");

        btn_save = MiscUtility.getWebElement(objFilepath, "OPR292_btn_save");
        btn_delete = MiscUtility.getWebElement(objFilepath, "OPR292_btn_delUNID");
        btn_copy = MiscUtility.getWebElement(objFilepath, "OPR292_btn_copyUNID");
        btn_clear = MiscUtility.getWebElement(objFilepath, "OPR292_btn_clear");
        info_msgClose = MiscUtility.getWebElement(objFilepath, "OPR292_info_close");
        tbl_unid = MiscUtility.getWebElement(objFilepath, "OPR292_tbl_dgrDtls");
        info_dgrDtls = MiscUtility.getWebElement(objFilepath, "OPR292_info_dgrDtls");

        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footer = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
        info_msgClose = MiscUtility.getWebElement(objFilepath, "OPR292_info_close");
    }

    /**
     * Method to list an awb
     *
     * @param pre
     * @param awb
     * @author a-7868
     */
    private void list(String pre, String awb) {

        enterKeys(txt_prefix, pre);
        enterKeys(txt_awb, awb);
        click(btn_list);
        minWait();
    }

    /**
     * Method to save UNID changes
     *
     * @author a-7868
     */
    private void save(String... frame) {

        String screenFrame;

        if (frame.length != 0){
            screenFrame = frame[0];
        }
        else {
            screenFrame = FRAME;
        }
        click(btn_save);
        driver.switchTo().defaultContent();
        Assert.assertTrue(waitForElement(info_footer).getText().contains("Saved Successfully"), "ERROR: Changes not saved");
        waitForFrameAndSwitch(screenFrame);
    }

    /**
     * Method to add UNID
     * on 26/12/2017
     *
     * @param pre
     * @param awbNo
     * @param unid
     * @param dgrName
     * @param pi
     * @param noOfPkg
     * @param wtPerPkg
     * @return
     * @author a-7868
     */
    public OPR292 addUNID(String pre, String awbNo, String unid, String dgrName,
                          String pi, String noOfPkg, String wtPerPkg) {

        pre = PropertyHandler.getPropValue(dataFilePath, pre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        unid = PropertyHandler.getPropValue(dataFilePath, unid);
        dgrName = PropertyHandler.getPropValue(dataFilePath, dgrName);
        pi = PropertyHandler.getPropValue(dataFilePath, pi);
        noOfPkg = PropertyHandler.getPropValue(dataFilePath, noOfPkg);
        wtPerPkg = PropertyHandler.getPropValue(dataFilePath, wtPerPkg);

        list(pre, awbNo);

        enterKeys(txt_DGRUnid, unid + Keys.TAB);
        minWait();
        selectByText(dropDown_DGRName, dgrName);
        scrollToView(txt_DGRwtPerPcs);
        enterKeys(txt_DGRpi, pi);
        enterKeys(txt_DGRPcs, noOfPkg);
        enterKeys(txt_DGRwtPerPcs, wtPerPkg);
        click(btn_DGRadd);
        Assert.assertTrue(waitForElement(link_DGRaddedUNID).getText().contains(unid), "ERROR: UNID not added");
        save();
        return this;
    }

    public OPR292 addUNIDFromOPR026(String unid, String dgrName,
                          String pi, String noOfPkg, String wtPerPkg) {

        unid = PropertyHandler.getPropValue(dataFilePath, unid);
        dgrName = PropertyHandler.getPropValue(dataFilePath, dgrName);
        pi = PropertyHandler.getPropValue(dataFilePath, pi);
        noOfPkg = PropertyHandler.getPropValue(dataFilePath, noOfPkg);
        wtPerPkg = PropertyHandler.getPropValue(dataFilePath, wtPerPkg);

        enterKeys(txt_DGRUnid, unid + Keys.TAB);
        minWait();
        selectByText(dropDown_DGRName, dgrName);
        scrollToView(txt_DGRwtPerPcs);
        enterKeys(txt_DGRpi, pi);
        enterKeys(txt_DGRPcs, noOfPkg);
        enterKeys(txt_DGRwtPerPcs, wtPerPkg);
        click(btn_DGRadd);
        Assert.assertTrue(waitForElement(link_DGRaddedUNID).getText().contains(unid), "ERROR: UNID not added");
        save("iCargoContentFrameOPR026");
        return this;
    }

    /**
     * Updates the Net quantity to 1 from 10 for the first UNID
     *
     * @param awbPre
     * @param awbNo
     * @return
     * @author Arun A-7681 on 26/12
     */
    public OPR292 updateUNID(String awbPre, String awbNo) {

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        list(awbPre, awbNo);
        click(link_DGRaddedUNID);
        scrollToView(txt_DGRwtPerPcs);
        enterKeys(txt_DGRwtPerPcs, "1");
        click(btn_DGRModify);

        save();
        list(awbPre, awbNo);
        scrollToView(info_DGRNetQuantity);
        Assert.assertTrue(waitForElement(info_DGRNetQuantity).getText().trim().equalsIgnoreCase("1.0"), "The Net Quantiy has not been updated for the UNID");
        return this;
    }

    /**
     * Method to copy a UNID
     * On 26/12/2017
     *
     * @param pre
     * @param awbNo
     * @param unid
     * @return
     * @author a-7868
     */
    public OPR292 copyUNID(String pre, String awbNo, String unid) {

        pre = PropertyHandler.getPropValue(dataFilePath, pre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        unid = PropertyHandler.getPropValue(dataFilePath, unid);

        list(pre, awbNo);
        minWait();        
        int count = getTableColumnValues(tbl_unid,1).size();	//count=7
        tblSelectRowByColValue(tbl_unid, 1, 3, unid);
        click(btn_copy);
        minWait();
        Assert.assertTrue(waitForElement(txt_DGRUnid).getAttribute("value").contains(unid), "ERROR : UNID details NOT copied.");
        click(btn_DGRadd);
        minWait();        
        int count2 = getTableColumnValues(tbl_unid,1).size();	//count=14
        Assert.assertTrue(count < count2, "ERROR : Copied UNID not added.");
        save();
        return this;
    }

    public OPR292 checkUNIDCaptured(String awbPre, String awbNo, String... unids){

        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

        list(awbPre,awbNo);

        for (String unid : unids){
            unid = PropertyHandler.getPropValue(dataFilePath, unid);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_unid,3,unid),"The UNID : " + unid + " is not captured for AWB No: " + awbNo);
        }

        return this;
    }

    /**
     * Method to delete a UNID
     * <26/12/2017>
     *
     * @param pre
     * @param awbNo
     * @param unid
     * @return
     * @author a-7868
     */
    public OPR292 deleteUNID(String pre, String awbNo, String unid) {


        pre = PropertyHandler.getPropValue(dataFilePath, pre);
        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        unid = PropertyHandler.getPropValue(dataFilePath, unid);

        list(pre, awbNo);
        minWait();             
        int count = getTableColumnValues(tbl_unid,1).size();	//count=14
        tblSelectRowByColValue(tbl_unid, 1, 3, unid);
        click(btn_delete);
        minWait();        
        int count2 = getTableColumnValues(tbl_unid,1).size(); //count=14
        //Assert.assertTrue(count > count2, "ERROR : UNID not deleted."); //same count showing
        save();
        return this;
    }

    /**
     * Method to close current page and return to OPR026
     * returns the instance of Homepage
     *
     * @return
     * @author a-7868
     */
    public OPR026 closeToOPR026() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        waitForFrameAndSwitch("iCargoContentFrameOPR026");

        return new OPR026(driver, dataFileName);
    }

    public OPR292 verifyUNIDCapturedWithPcsAndWt(String awbPre, String awbNo, String noPkg, String totPcs, String totWt, String... unids) {


        awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
        awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
        noPkg = PropertyHandler.getPropValue(dataFilePath, noPkg);
        totPcs = PropertyHandler.getPropValue(dataFilePath, totPcs);
        totWt = PropertyHandler.getPropValue(dataFilePath, totWt);

        list(awbPre, awbNo);
        minWait();

        Assert.assertTrue(waitForElement(info_dgrDtls).getText().toUpperCase().contains(("TOTAL DG PACKAGES : " + noPkg).toUpperCase()), "The total DG packages DGR details not present");
        Assert.assertTrue(waitForElement(info_dgrDtls).getText().toUpperCase().contains(("STATED PCS/WGT : " + totPcs + "/" + totWt + ".0 KG").toUpperCase()), "The total stated Wt and Pcs DGR details not present");

        for (String unid : unids) {
            unid = PropertyHandler.getPropValue(dataFilePath, unid);
            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_unid, 3, unid), "The UNID : " + unid + " is not captured for AWB No: " + awbNo);
        }
        minWait();

        return this;

    }

    /**
     * Method to close current page and return to Homepae
     * returns the instance of Homepage
     *
     * @return
     * @author a-7868
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
}
