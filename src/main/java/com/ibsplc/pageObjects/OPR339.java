package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/****
 *
 * @author A-6784
 *
 */
public class OPR339 extends BasePage {

    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameOPR339";
    private By

            txt_AWBPrefix,
            txt_AWB,
            btn_list,
            dropdown_securityDetails,
            chkbx_dataReviewed,
            drodown_shipmentDetails,
            link_addSCC,
            txt_SCC,
            btn_addResult,
            dropdown_result,
            txt_wt,
            txt_pcs,
            dropdown_screenMethod,
            btn_OK,
            btn_save,
            Generic_btn_ok,
            icon_cloaseTab,
            btn_close,
    link_addAgent,
    dropDown_agentType,
    txt_agentCountryCode,
    txt_agentCode,
    btn_agentAdd;
    private By
            yesBtn,
            noBtn,
            Ok_btn,
            cls_scr,
            sel_methods,
            sel_result,
            tab_secDet,
            tab_shipDet,
            lbl_scc,
            chkbx_dataRvdSucess;
    
    
    private By lbl_scrMethds;
    private By btnAddNew;
    private WebDriver driver;
    private String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

    public OPR339(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }


    private void initElements() {

        txt_AWBPrefix = MiscUtility.getWebElement(objFilepath, "OPR339_txt_AWBPrefix");
        txt_AWB = MiscUtility.getWebElement(objFilepath, "OPR339_txt_AWB");
        icon_cloaseTab = MiscUtility.getWebElement(objFilepath, "OPR339_icon_cloaseTab");
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR339_btn_list");
        dropdown_securityDetails = MiscUtility.getWebElement(objFilepath, "OPR339_dropdown_securityDetails");
        chkbx_dataReviewed = MiscUtility.getWebElement(objFilepath, "OPR339_chkbx_dataReviewed");
        drodown_shipmentDetails = MiscUtility.getWebElement(objFilepath, "OPR339_drodown_shipmentDetails");
        link_addSCC = MiscUtility.getWebElement(objFilepath, "OPR339_link_addSCC");
        txt_SCC = MiscUtility.getWebElement(objFilepath, "OPR339_txt_SCC");
        dropdown_screenMethod= MiscUtility.getWebElement(objFilepath, "OPR339_dropdown_screenMethod");
        txt_pcs=MiscUtility.getWebElement(objFilepath, "OPR339_txt_pcs");
        txt_wt=MiscUtility.getWebElement(objFilepath, "OPR339_txt_wt");
        dropdown_result=MiscUtility.getWebElement(objFilepath, "OPR339_dropdown_result");
        btn_addResult=MiscUtility.getWebElement(objFilepath, "OPR339_btn_addResult");
       		
        btn_OK = MiscUtility.getWebElement(objFilepath, "OPR339_btn_OK");
        btn_save = MiscUtility.getWebElement(objFilepath, "OPR339_btn_save");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR339_btn_close");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        Generic_btn_ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        
        noBtn			=MiscUtility.getWebElement(genObjPath,"Generic_btn_noBtn");	
 	    Ok_btn           = MiscUtility.getWebElement(genObjPath,"Generic_btn_ok");
 	   // cls_scr			= MiscUtility.getWebElement(genObjPath,"Generic_close_Screen");
 	    sel_methods=MiscUtility.getWebElement(objFilepath,"OPR339_sel_method");
 	    sel_result=MiscUtility.getWebElement(objFilepath,"OPR339_sel_result");
 	    tab_secDet=MiscUtility.getWebElement(objFilepath,"OPR339_tab_secDet");
 	    tab_shipDet=MiscUtility.getWebElement(objFilepath,"OPR339_tab_shipDet");
 	    lbl_scc=MiscUtility.getWebElement(objFilepath,"OPR339_lbl_scc");
 	    chkbx_dataRvdSucess=MiscUtility.getWebElement(objFilepath, "OPR339_chkbx_dataReviewedSuccess");
 	    //agent details
        link_addAgent = MiscUtility.getWebElement(objFilepath,"OPR339_link_addAgent");
                dropDown_agentType = MiscUtility.getWebElement(objFilepath,"OPR339_dropDown_agentType");
                txt_agentCountryCode = MiscUtility.getWebElement(objFilepath,"OPR339_txt_agentCountryCode");
                txt_agentCode = MiscUtility.getWebElement(objFilepath,"OPR339_txt_agentCode");
                btn_agentAdd = MiscUtility.getWebElement(objFilepath,"OPR339_btn_agentAdd");
                btnAddNew= MiscUtility.getWebElement(objFilepath,"OPR339_btn_addIdNew");
                
                lbl_scrMethds=MiscUtility.getWebElement(objFilepath, "OPR339_lbl_scrMethds");
    }

   /* public OPR339 captureSecurityScreening(String AWBPrefix, String AWBNo) {

        AWBPrefix = PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
        AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);

        enterKeys(txt_AWBPrefix, AWBPrefix);
        enterKeys(txt_AWB, AWBNo);
        click(btn_list);
        minWait();
        driver.switchTo().defaultContent();
        click(yesBtn);
        minWait();
        //driver.switchTo().defaultContent();
        waitForFrameAndSwitch(FRAME);
        click(dropdown_securityDetails);
        check(chkbx_dataReviewed);
        click(drodown_shipmentDetails);
        click(link_addSCC);
        minWait();
        enterKeys(txt_SCC, "SPX");
        click(btn_OK);
        minWait();        

        click(btn_save);
        minWait();
        driver.switchTo().defaultContent();
        click(Generic_btn_ok);
        waitForFrameAndSwitch(FRAME);
        enterKeys(txt_AWBPrefix, AWBPrefix);
        enterKeys(txt_AWB, AWBNo);
        click(btn_list);
        minWait();
        return this;

    }*/

    /**
     * 
     * @param AWBPrefix
     * @param AWBNo
     * @param pcs
     * @param wt
     * @return
     * @author a-7868 Krishna <12/03/2018>
     */
    public OPR339 captureSecurityScreening(String AWBPrefix, String AWBNo, String pcs, String wt) {

        AWBPrefix = PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
        AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);
        
        enterKeys(txt_AWBPrefix, AWBPrefix);
        enterKeys(txt_AWB, AWBNo);
        click(btn_list);
        minWait();
        driver.switchTo().defaultContent();
        click(yesBtn);
        minWait();
        //driver.switchTo().defaultContent();
        waitForFrameAndSwitch(FRAME);
        click(dropdown_securityDetails);
        check(chkbx_dataReviewed);
        click(drodown_shipmentDetails);
        click(link_addSCC);
        minWait();
        enterKeys(txt_SCC, "SPX");
        click(btn_OK);
        minWait();        

        selectByIndex(dropdown_screenMethod, 1);
        enterKeys(txt_pcs, pcs);
        enterKeys(txt_wt, wt);
        selectByText(dropdown_result, "Pass");
        click(btn_addResult);
        
        click(btn_save);
        minWait();
        driver.switchTo().defaultContent();
        click(Generic_btn_ok);
        waitForFrameAndSwitch(FRAME);
        enterKeys(txt_AWBPrefix, AWBPrefix);
        enterKeys(txt_AWB, AWBNo);
        click(btn_list);
        minWait();
        return this;

    }
    
    public OPR339 captureScreening(String AWBPrefix, String AWBNo, String pcs, String wt) {

        AWBPrefix = PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
        AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);
        
        enterKeys(txt_AWBPrefix, AWBPrefix);
        enterKeys(txt_AWB, AWBNo);
        click(btn_list);
        minWait();
        driver.switchTo().defaultContent();
             
        if (verifyElementPresent(yesBtn)) 
            click(yesBtn); 
        waitForFrameAndSwitch(FRAME);
        selectByIndex(dropdown_screenMethod, 1);
        enterKeys(txt_pcs, pcs);
        enterKeys(txt_wt, wt);
        selectByText(dropdown_result, "Pass");
        minWait();
       // if(verifyElementEnabled(btn_addResult))
        //click(btn_addResult);
        if(verifyElementEnabled(btnAddNew))
        	click(btnAddNew); 
        click(btn_save); 
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) 
            click(yesBtn); 
        waitForFrameAndSwitch(FRAME);
        minWait();
        driver.switchTo().defaultContent();
        click(Generic_btn_ok);
        waitForFrameAndSwitch(FRAME);
        enterKeys(txt_AWBPrefix, AWBPrefix);
        enterKeys(txt_AWB, AWBNo);
        click(btn_list);
        minWait();
        return this;

    }
    public OPR339 captureScreeningScreeningMethods(String AWBPrefix, String AWBNo, String pcs, String wt,Boolean securityData,String...screeningMethod ) {

        AWBPrefix = PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
        AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);
        String scrMethod="";
        enterKeys(txt_AWBPrefix, AWBPrefix);
        enterKeys(txt_AWB, AWBNo);
        click(btn_list);
        minWait();
        driver.switchTo().defaultContent();
             
        if (verifyElementPresent(yesBtn)) 
            click(yesBtn); 
        waitForFrameAndSwitch(FRAME);
        selectByIndex(dropdown_screenMethod, 1);
        scrMethod=new Select(driver.findElement(dropdown_screenMethod)).getFirstSelectedOption().getText();
        if(screeningMethod.length!=0)
        PropertyHandler.setPropValue(dataFilePath, screeningMethod[0], scrMethod);
        enterKeys(txt_pcs, pcs);
        enterKeys(txt_wt, wt);
        selectByText(dropdown_result, "Pass");
        click(btn_addResult);
        if(securityData)
        {
        	click(dropdown_securityDetails);
        	click(chkbx_dataReviewed);
        }
        
        
        
        click(btn_save);
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) 
            click(yesBtn); 
        waitForFrameAndSwitch(FRAME);
        minWait();
        driver.switchTo().defaultContent();
        click(Generic_btn_ok);
        waitForFrameAndSwitch(FRAME);
        enterKeys(txt_AWBPrefix, AWBPrefix);
        enterKeys(txt_AWB, AWBNo);
        click(btn_list);
        minWait();
        if(verifyElementPresent(btn_close))
            click(btn_close);
        return this;

    }
    /**
     * @author A-8260
     * 
     */
    public OPR339 captureScreening_AOM(String AWBPrefix, String AWBNo, String pcs, String wt,Boolean securityData,String screeningMethod1,String screeningMethod2) {

        AWBPrefix = PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
        AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
        pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
        wt = PropertyHandler.getPropValue(dataFilePath, wt);
        String scrMethod1="",scrMethod2="";
        enterKeys(txt_AWBPrefix, AWBPrefix);
        enterKeys(txt_AWB, AWBNo);
        click(btn_list);
        minWait();
        driver.switchTo().defaultContent();
             
        if (verifyElementPresent(yesBtn)) 
            click(yesBtn); 
        waitForFrameAndSwitch(FRAME);
        selectByIndex(dropdown_screenMethod, 1);
        scrMethod1=new Select(driver.findElement(dropdown_screenMethod)).getFirstSelectedOption().getText();
        
        PropertyHandler.setPropValue(dataFilePath, screeningMethod1, scrMethod1);
        enterKeys(txt_pcs, "5");
        enterKeys(txt_wt, "50");
        
        selectByText(dropdown_result, "Pass");
        click(btn_addResult);
        if(securityData)
        {
        	click(dropdown_securityDetails);
        	click(chkbx_dataReviewed);
        }
        
        selectByIndex(dropdown_screenMethod, 2);
        scrMethod2=new Select(driver.findElement(dropdown_screenMethod)).getFirstSelectedOption().getText();
        
        PropertyHandler.setPropValue(dataFilePath, screeningMethod2, scrMethod2);
        enterKeys(txt_pcs, "5");
        enterKeys(txt_wt, "50");
       
        selectByText(dropdown_result, "Pass");
        minWait();
        scrollToView(btn_addResult);
        click(btn_addResult);
        
        click(btn_save);
        minWait();
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) 
            click(yesBtn); 
        waitForFrameAndSwitch(FRAME);
        minWait();
        driver.switchTo().defaultContent();
        click(Generic_btn_ok);
        waitForFrameAndSwitch(FRAME);
        enterKeys(txt_AWBPrefix, AWBPrefix);
        enterKeys(txt_AWB, AWBNo);
        click(btn_list);
        minWait();
        if(verifyElementPresent(btn_close))
            click(btn_close);
        return this;

    }
    
    public HomePage close() {

        driver.switchTo().defaultContent();
        //click(icon_cloaseTab);
        minWait();
        if(verifyElementPresent(btn_close))
            click(btn_close);
       /* else	
        	driver.findElement(By.className("remove ic-ui-icon")).click();
        */
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) 
            click(yesBtn); 
        return new HomePage(driver, dataFileName);
    }
    
    /**
     * close screen methods
     * @author A-8260
     * @return
     */
    public HomePage closeScreen() {

        if (verifyElementPresent(btn_close)&&verifyElementVisible(btn_close))    	
            click(btn_close);
        else
      	 minWait();
    		Actions action = new Actions(driver);
    		action.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).perform(); 

        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn))
            click(yesBtn);
        return new HomePage(driver, dataFileName);
    }
    public HomePage returnHome()
    {
    	return new HomePage(driver, dataFileName);
    }
    /**
     * @author A-8260
     * @param AWBPrefix
     * @param AWBNo
     * @param pcs
     * @param wt
     * @param unScc
     * @return
     */
    public OPR339 captureSecurityScreening(String AWBPrefix,String AWBNo,String pcs, String wt, String... unScc){
    	String unsecuredScc;
    	AWBPrefix=PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
    	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
    	pcs=PropertyHandler.getPropValue(dataFilePath, pcs);
    	wt=PropertyHandler.getPropValue(dataFilePath, wt);
    	if(unScc.length!=0)
    	unsecuredScc=PropertyHandler.getPropValue(dataFilePath, unScc[0]);
    	enterKeys(txt_AWBPrefix, AWBPrefix);
    	enterKeys(txt_AWB, AWBNo);
    	click(btn_list);
    	minWait();
    	driver.switchTo().defaultContent();	
    	click(yesBtn);
    	minWait();
    	//driver.switchTo().defaultContent();	
    	waitForFrameAndSwitch(FRAME);
    	 enterKeys(txt_pcs, pcs);
  	   enterKeys(txt_wt, wt);
  	   selectByIndex(sel_methods, 2);
  	   selectByIndex(sel_result, 2);
    	click(dropdown_securityDetails);
    	check(chkbx_dataReviewed);
    	click(drodown_shipmentDetails);
    	click(link_addSCC);
    	minWait();
    	if(unScc.length!=0)
    	enterKeys(txt_SCC, "GEN");
    	else
    	enterKeys(txt_SCC, "SPX");
    	click(btn_OK);
    	minWait();
    	
    	click(btn_save);
    	minWait();
    	
    	//newly added 09-03-2018 @Author: A-8260
    	driver.switchTo().defaultContent();	
    	click(Ok_btn);
    	//waitForFrameAndSwitch(FRAME);
    	minWait();
    	minWait();
    	//scrollToView(cls_scr);
    	//click(cls_scr);
//    	enterKeys(txt_AWBPrefix, AWBPrefix);
//    	enterKeys(txt_AWB, AWBNo);
//    	click(btn_list);
    	minWait();
		return this;
    	
    }

    /**
     *
     * @param AWBPrefix
     * @param AWBNo
     * @param pcs
     * @param wt
     * @return
     */
    public OPR339 captureSecurityScreeningAgentDtls(String AWBPrefix,String AWBNo,String pcs, String wt, String agentCode){

        AWBPrefix=PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
        AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
        pcs=PropertyHandler.getPropValue(dataFilePath, pcs);
        wt=PropertyHandler.getPropValue(dataFilePath, wt);
        agentCode=PropertyHandler.getPropValue(dataFilePath, agentCode);

        enterKeys(txt_AWBPrefix, AWBPrefix);
        enterKeys(txt_AWB, AWBNo);
        click(btn_list);
        minWait();
        driver.switchTo().defaultContent();
        click(yesBtn);
        minWait();
        //driver.switchTo().defaultContent();
        waitForFrameAndSwitch(FRAME);
        enterKeys(txt_pcs, pcs);
        enterKeys(txt_wt, wt);
        selectByIndex(sel_methods, 2);
        selectByIndex(sel_result, 2);
        click(dropdown_securityDetails);
        check(chkbx_dataReviewed);
        click(drodown_shipmentDetails);
        click(link_addSCC);
        minWait();
        enterKeys(txt_SCC, "SPX");
        click(btn_OK);

        //Agent details
        click(link_addAgent);

        selectByIndex(dropDown_agentType,2);
        enterKeys(txt_agentCountryCode,"IN");
        enterKeys(txt_agentCode,agentCode);
        click(btn_agentAdd);


        minWait();

        click(btn_save);
        minWait();

        //newly added 09-03-2018 @Author: A-8260
        driver.switchTo().defaultContent();
        click(Ok_btn);
        //waitForFrameAndSwitch(FRAME);
        minWait();
        minWait();
        //scrollToView(cls_scr);
        //click(cls_scr);
//    	enterKeys(txt_AWBPrefix, AWBPrefix);
//    	enterKeys(txt_AWB, AWBNo);
//    	click(btn_list);
        minWait();
        return this;

    }

    /**
     * Method to make a capture screening details for secure unsecured scc
     *
     * @param AWBPrefix
     * @param AWBNo
     * @param unScc
     * @return
     * @author A-8260 Abhilash
     */ 
 public OPR339 captureSecurityScreeningUnSecureScc(String AWBPrefix,String AWBNo, String unScc){
     	
     	AWBPrefix=PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
     	AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
     	unScc=PropertyHandler.getPropValue(dataFilePath, unScc);
     	enterKeys(txt_AWBPrefix, AWBPrefix);
     	enterKeys(txt_AWB, AWBNo);
     	click(btn_list);
     	minWait();
     	driver.switchTo().defaultContent();	
     	click(yesBtn);
     	minWait();
     	//driver.switchTo().defaultContent();	
     	waitForFrameAndSwitch(FRAME);
     	click(dropdown_securityDetails);
     	check(chkbx_dataReviewed);
     	click(drodown_shipmentDetails);
     	click(link_addSCC);
     	minWait();
     	
     	enterKeys(txt_SCC, unScc);
     	
     	click(btn_OK);
     	minWait();
     	
     	click(btn_save);
     	minWait();
     	
     	//newly added 09-03-2018 @Author: A-8260
     	driver.switchTo().defaultContent();	
     	click(Ok_btn);
     	//waitForFrameAndSwitch(FRAME);
     	minWait();
     	minWait();
     	//scrollToView(cls_scr);
     	//click(cls_scr);
//     	enterKeys(txt_AWBPrefix, AWBPrefix);
//     	enterKeys(txt_AWB, AWBNo);
//     	click(btn_list);
     	minWait();
 		return this;
     	
     }
 /**
  * Method to make a capture screening details for secure scc
  *
  * @param AWBPrefix
  * @param AWBNo
  * @param pcs
  * @param wt
  * @param location
  * @param scrRelease
  * @return
  * @author A-8260 Abhilash
  */
public OPR339 captureAndReleaseScreening(String AWBPrefix,String AWBNo,String pcs, String wt,boolean scrRelease)
{
	   AWBPrefix=PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
	   AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
	   pcs=PropertyHandler.getPropValue(dataFilePath, pcs);
	   wt=PropertyHandler.getPropValue(dataFilePath, wt);
	   enterKeys(txt_AWBPrefix, AWBPrefix);
	   enterKeys(txt_AWB, AWBNo);
	   click(btn_list);
	   driver.switchTo().defaultContent();
	   //Ok to save changes
	  
	   click(yesBtn);
	   
		waitForFrameAndSwitch(FRAME);
	   enterKeys(txt_pcs, pcs);
	   enterKeys(txt_wt, wt);
	   selectByIndex(sel_methods, 2);
	   selectByIndex(sel_result, 2);
	   
	   click(btn_save);
	   minWait();
	   driver.switchTo().defaultContent();
	   //Ok to save changes
	   click(yesBtn);
	   minWait();	
	   // Release screening
	   if(scrRelease)
	   click(yesBtn);
	   else
		   click(noBtn);
	
	   //confirmation click
	   
	   click(Ok_btn);
	   
	   waitForFrameAndSwitch(FRAME);
	   enterKeys(txt_AWBPrefix, AWBPrefix);
	   enterKeys(txt_AWB, AWBNo);
	   click(btn_list);
	   click(tab_secDet);
	 
	   //Assert.assertTrue(driver.findElement(chkbx_dataReviewed).getText().equalsIgnoreCase("checked"), "Security Data Reviewed is checked");
	   if(scrRelease){
		  Assert.assertTrue(verifyElementPresent(chkbx_dataRvdSucess), "Security Data Reviewed is checked");
	   click(tab_shipDet);
	   System.out.println(driver.findElement(lbl_scc).getText());
	   System.out.println(driver.findElement(lbl_scc).getAttribute("innerText"));
	   System.out.println(driver.findElement(lbl_scc).getAttribute("textContent"));
	
	   Assert.assertTrue(driver.findElement(lbl_scc).getAttribute("innerText").contains("SPX"), "Secure SCC is added successfully");
	   }
	   return this;
}


public OPR339 validateScreeningMehodsxFWB(String AWBPrefix,String AWBNo) throws Exception
{
	String screeningMethods="";
	 AWBPrefix=PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
	   AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
	  
	   enterKeys(txt_AWBPrefix, AWBPrefix);
	   enterKeys(txt_AWB, AWBNo);
	   click(btn_list);
	   minWait();
	  List<WebElement> scrMthods= getWebElements(lbl_scrMethds);
	  for(int i=0;i<scrMthods.size();i++)
	  {
		  scrollToView(scrMthods.get(i));
		  screeningMethods=scrMthods.get(i).getText();
		  Assert.assertTrue(scrMthods.get(0).getText().contains("confirmed awb-success screen"),"Screening method should be as expected");
		  Assert.assertTrue(scrMthods.get(1).getText().contains("Remote explosive scent tracing explosive detection dogs"),"Screening method should be as expected");
		  Assert.assertTrue(scrMthods.get(2).getText().contains("X-ray equipment"),"Screening method should be as expected");
		  
	  }
	  
	return this;
}

public OPR339 validateScreeningMehods(String AWBPrefix,String AWBNo) throws Exception
{
	String screeningMethods="";
	 AWBPrefix=PropertyHandler.getPropValue(dataFilePath, AWBPrefix);
	   AWBNo=PropertyHandler.getPropValue(dataFilePath, AWBNo);
	  
	   enterKeys(txt_AWBPrefix, AWBPrefix);
	   enterKeys(txt_AWB, AWBNo);
	   click(btn_list);
	   minWait();
	  List<WebElement> scrMthods= getWebElements(lbl_scrMethds);
	  for(int i=0;i<scrMthods.size();i++)
	  {
		  scrollToView(scrMthods.get(i));
		  screeningMethods=scrMthods.get(i).getText();
		  Assert.assertTrue(scrMthods.get(0).getText().contains("TRACE DETECTION CONFIRMED AWBS"),"Screening method should be as expected");
		  Assert.assertTrue(scrMthods.get(1).getText().contains("Remote explosive scent tracing explosive detection dogs"),"Screening method should be as expected");
		  Assert.assertTrue(scrMthods.get(2).getText().contains("X-ray equipment"),"Screening method should be as expected");
		  
	  }
	  
	return this;
}
}
