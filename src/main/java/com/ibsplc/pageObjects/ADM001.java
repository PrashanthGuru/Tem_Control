
package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

/**
 * @author A-8254 on 19/3/2018.
 */

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by A-6545 on 16/2/2018.
 */
public class ADM001 extends BasePage {

    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "MRA_ULD_ADM_REC_WFW.properties");
    private static String FRAME = "iCargoContentFrameADM001";
    private static boolean delReq = false;
    private static boolean addReq = false;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;

    private By btn_Close,
            txt_roleGrp,
            txt_privCode,
            btn_list,
            tbl_privDtls,
            btn_addByRoleGrp,
            txt_addPrivPrivCode,
            txt_addPrivRoleGrp,
            btn_addPrivList,
            tbl_rolGrpDtls,
            btn_addPrivAssign,
            btn_clear,
            btn_unassign;

    private By btn_genericYes;

	private By 	txt_RoleGP,
	txt_pvg_code,
	txt_pvg_gp,
	txt_stn,
	txt_scr,				
	btn_clr,
	
	err_msg,
	btn_cls,
	chk_all,
	btn_unAssign,
	yesBtn,
	tblLocator,
	btn_addRlGP,
	txt_addRole,
	txt_addPrevCode,
	tbl_rolGPDet,
	btn_listRoleGp,
	btn_assignRoleGp;




    public ADM001(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }

    private void initElements() {

        btn_Close = MiscUtility.getWebElement(objFilepath, "ADM001_btn_Close");
        txt_roleGrp = MiscUtility.getWebElement(objFilepath, "ADM001_txt_roleGrp");
        txt_privCode = MiscUtility.getWebElement(objFilepath, "ADM001_txt_privCode");
        btn_list = MiscUtility.getWebElement(objFilepath, "ADM001_btn_list");
        tbl_privDtls = MiscUtility.getWebElement(objFilepath, "ADM001_tbl_privDtls");
        btn_addByRoleGrp = MiscUtility.getWebElement(objFilepath, "ADM001_btn_addByRoleGrp");
        txt_addPrivPrivCode = MiscUtility.getWebElement(objFilepath, "ADM001_txt_addPrivPrivCode");
        txt_addPrivRoleGrp = MiscUtility.getWebElement(objFilepath, "ADM001_txt_addPrivRoleGrp");
        btn_addPrivList = MiscUtility.getWebElement(objFilepath, "ADM001_btn_addPrivList");
        tbl_rolGrpDtls = MiscUtility.getWebElement(objFilepath, "ADM001_tbl_rolGrpDtls");
        btn_addPrivAssign = MiscUtility.getWebElement(objFilepath, "ADM001_btn_addPrivAssign");
        btn_clear = MiscUtility.getWebElement(objFilepath, "ADM001_btn_clear");
        btn_unassign = MiscUtility.getWebElement(objFilepath, "ADM001_btn_unassign");

        btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        
        txt_RoleGP		=MiscUtility.getWebElement(objFilepath, "ADM001_txt_rolegp");
        txt_pvg_code	=MiscUtility.getWebElement(objFilepath, "ADM001_txt_pvgCode");
        txt_pvg_gp      =MiscUtility.getWebElement(objFilepath, "ADM001_txt_pvggp");
        txt_stn			=MiscUtility.getWebElement(objFilepath, "ADM001_txt_stn");
        txt_scr			=MiscUtility.getWebElement(objFilepath, "ADM001_txt_scr");
        btn_clr			=MiscUtility.getWebElement(objFilepath, "ADM001_btn_clr");
        btn_list		=MiscUtility.getWebElement(objFilepath, "ADM001_btn_list");
        err_msg			=MiscUtility.getWebElement(genObjPath, "Generic_blk_error");
        btn_cls			=MiscUtility.getWebElement(objFilepath, "ADM001_btn_close");
        chk_all			=MiscUtility.getWebElement(objFilepath, "ADM001_chk_all");
        btn_unAssign	=MiscUtility.getWebElement(objFilepath, "ADM001_btn_unAssign");
        yesBtn			            = MiscUtility.getWebElement(genObjPath,"Generic_btn_diaYes");
        tblLocator		=MiscUtility.getWebElement(objFilepath, "ADM001_tbl");
        btn_addRlGP		=MiscUtility.getWebElement(objFilepath, "ADM001_btn_addByRoleGroup");
        txt_addRole		=MiscUtility.getWebElement(objFilepath, "ADM001_txt_addRole");
        txt_addPrevCode =MiscUtility.getWebElement(objFilepath, "ADM001_txt_addprevCode");
        tbl_rolGPDet	=MiscUtility.getWebElement(objFilepath, "ADM001_tbl_roleGPDet");
        btn_listRoleGp  =MiscUtility.getWebElement(objFilepath, "ADM001_btn_listRoleGp");
        btn_assignRoleGp =MiscUtility.getWebElement(objFilepath, "ADM001_btn_assignRoleGp");
    }

    /**
     * assigns a privilage to an rolegroup
     *
     * @param roleGroup
     * @param privilageCode
     * @return
     */
    public ADM001 assignPrivilage(String roleGroup, String privilageCode) {

        roleGroup = PropertyHandler.getPropValue(dataFilePath, roleGroup);
        privilageCode = PropertyHandler.getPropValue(dataFilePath, privilageCode);
        list(roleGroup, privilageCode);

        if (!verifyValuePresentInTblColumn(tbl_privDtls, 2, roleGroup)) {
            click(btn_addByRoleGrp);
            switchToSecondWindow();

            enterKeys(txt_addPrivPrivCode, privilageCode);
            enterKeys(txt_addPrivRoleGrp, roleGroup);
            click(btn_addPrivList);
            tblSelectRowByColValue(tbl_rolGrpDtls, 1, 2, roleGroup);
            click(btn_addPrivAssign);

            switchToFirstWindow();
            waitForFrameAndSwitch(FRAME);
            minWait();
            click(btn_clear);
            minWait();
            list(roleGroup, privilageCode);

            Assert.assertTrue(verifyValuePresentInTblColumn(tbl_privDtls, 2, roleGroup), "The privilage : " + privilageCode + " is not assigned to the role group " + roleGroup);
            if (!addReq) {
                delReq = true;
            }

        }

        return this;
    }


    public ADM001 deletePrivilage(String roleGroup, String privilageCode){

        roleGroup = PropertyHandler.getPropValue(dataFilePath, roleGroup);
        privilageCode = PropertyHandler.getPropValue(dataFilePath, privilageCode);
        list(roleGroup, privilageCode);

        if (verifyValuePresentInTblColumn(tbl_privDtls, 2, roleGroup)){
            tblSelectRowByColValue(tbl_privDtls,1,2,roleGroup);
            click(btn_unassign);
            minWait();
            click(btn_clear);

            list(roleGroup, privilageCode);
            Assert.assertFalse(verifyValuePresentInTblColumn(tbl_privDtls, 2, roleGroup), "The privilage : " + privilageCode + " is still assigned to the role group " + roleGroup);
            if (!delReq){
                addReq = true;
            }
        }

        return this;
    }

    public ADM001 revertPrivilage(String roleGroup, String privilageCode){

        if(delReq){
            deletePrivilage(roleGroup,privilageCode);
            delReq = false;
        }
        if (addReq){
            assignPrivilage(roleGroup,privilageCode);
            addReq = false;
        }

        return this;
    }

    private void list(String roleGroup, String privilageCode) {
        enterKeys(txt_roleGrp, roleGroup);
        enterKeys(txt_privCode, privilageCode);
        click(btn_list);
        minWait();
    }


    public HomePage close() {
    	try{
        click(btn_Close);
    	}
    	catch(WebDriverException we)
    	{
    		Actions action = new Actions(driver);
        	action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform(); 
    	}
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_genericYes)) {

            click(btn_genericYes);
        }
        return new HomePage(driver, dataFileName);
    }
    
    public ADM001 unAssignRoleGroup(String roleGroup, String pvgCode, String pvgGp, String stn, String scr) 
	{
		roleGroup=PropertyHandler.getPropValue(dataFilePath,roleGroup);
		pvgCode=PropertyHandler.getPropValue(dataFilePath,pvgCode);
		
		if(pvgGp!="") 	pvgGp=PropertyHandler.getPropValue(dataFilePath,pvgGp);
		if(stn!="") 	stn=PropertyHandler.getPropValue(dataFilePath,stn);
		if(scr!="") 	scr=PropertyHandler.getPropValue(dataFilePath,scr);
		
		
		enterKeys(txt_RoleGP, roleGroup);
		enterKeys(txt_pvg_code, pvgCode);
		enterKeys(txt_pvg_gp, pvgGp);
		enterKeys(txt_stn, stn);
		enterKeys(txt_scr, scr);
		
		click(btn_list);
		minWait();
		if(verifyElementEnabled(err_msg))
			click(btn_clr);
		else
		{
			//click(chk_all);
			tblClickByColValue(tblLocator, 1);
			click(btn_unAssign);
			minWait();
		}
			
		
		return this;
	}
    public ADM001 assignPrevilegeByRoleGroup(String roleGroup, String pvgCode ) 
	{
		roleGroup=PropertyHandler.getPropValue(dataFilePath,roleGroup);
		pvgCode=PropertyHandler.getPropValue(dataFilePath,pvgCode);
//		enterKeys(txt_RoleGP, roleGroup);
		enterKeys(txt_pvg_code, pvgCode);
		click(btn_list);
		minWait();
		if(verifyValuePresentInTblColumn(tblLocator, 2, roleGroup))
		{
			click(btn_clear);
			minWait();
		}
		else
		{
			click(btn_addRlGP);
			driver.switchTo().defaultContent();
			waitForNewWindow(2);
			switchToSecondWindow();
			enterKeys(txt_addRole, roleGroup);
			click(btn_listRoleGp);
			tblClickByColValue(tbl_rolGPDet, 1);
			enterKeys(txt_addPrevCode, pvgCode);
			click(btn_assignRoleGp);
			minWait();
			minWait();
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);
		}
		
		return this;
	}
    

}

   
     


