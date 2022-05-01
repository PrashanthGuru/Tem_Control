package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Screen OPR026 - AWB CLEARANCE
 * Created on 15/03/2018
 *
 * @author a-7868
 */
public class OPR023 extends BasePage {

    public static String FRAME = "iCargoContentFrameOPR023";
    public static String screenFrame = "iCargoContentFrameOPR023";
    private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    WebDriver driver;
    String dataFileName;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    
    private By txt_prefix,
    			txt_awb,
    			btn_list,
    			btn_clear,
    			tbl_awbClearance,
    			btn_amendBlock,
    			btn_block,
    			btn_release,
    			btn_close,
    			yesBtn,
    			txt_release,
    			btn_win_rls;
    private By sel_blockedFor,
    			txt_remarks,
    			btn_blk_details;
    
    public OPR023(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }
    
    /**
     * Method to initialize page elements
     */
    private void initElements() {

        txt_prefix = MiscUtility.getWebElement(objFilepath, "OPR023_txt_awbPre");
        txt_awb = MiscUtility.getWebElement(objFilepath, "OPR023_txt_awbNo");
        btn_list = MiscUtility.getWebElement(objFilepath, "OPR023_btn_list");
        btn_clear = MiscUtility.getWebElement(objFilepath, "OPR023_btn_clear");
        btn_close = MiscUtility.getWebElement(objFilepath, "OPR023_btn_close");
        tbl_awbClearance = MiscUtility.getWebElement(objFilepath, "OPR023_tbl_awbClearance");
        btn_amendBlock = MiscUtility.getWebElement(objFilepath, "OPR023_btn_amendBlock");
        btn_block = MiscUtility.getWebElement(objFilepath, "OPR023_btn_block");
        btn_release = MiscUtility.getWebElement(objFilepath, "OPR023_btn_release");
        
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
       
    	txt_release=MiscUtility.getWebElement(objFilepath, "OPR023_txt_release");
    	btn_win_rls=MiscUtility.getWebElement(objFilepath, "OPR023_btn_winRelease");
    	
    	sel_blockedFor=MiscUtility.getWebElement(objFilepath, "OPR023_sel_blocked_for");
    	txt_remarks=MiscUtility.getWebElement(objFilepath, "OPR023_txt_remarks");
    	btn_blk_details=MiscUtility.getWebElement(objFilepath, "OPR023_btn_block_Details");
    }
    
    /**
     * Method to list an AWB and verify the Block type and corr. status against a given airport
     * @param awbPre
     * @param awbNo
     * @param airport
     * @param blockType
     * @param status
     * @return
     * @author a-7868 Krishna <15/03/2018>
     */
    public OPR023 checkAWBStatus(String awbPre, String awbNo, String airport, String blockType, String status){
    	
    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	airport = PropertyHandler.getPropValue(dataFilePath, airport);
    	blockType = PropertyHandler.getPropValue(dataFilePath, blockType);
    	
    	enterKeys(txt_prefix, awbPre);
    	enterKeys(txt_awb, awbNo);
    	click(btn_list);
    	minWait();
    	Assert.assertTrue(tblGetTextByColValue(tbl_awbClearance, 4, 2, airport).contains(blockType), "ERROR : Block type mismatch.");
    	Assert.assertTrue(tblGetTextByColValue(tbl_awbClearance, 8, 2, airport).contains(status), "ERROR : Block type mismatch.");
    	click(btn_clear);
    	return this;
    }
    
    //ABHILASH A-8260
    
    public OPR023 validateBlockDetails(String awbPref, String awbNumber, String refCol, String valCol, String Screening, String Security )
    {
    	String blockTypeScreening=null,blockTypeSecurity=null;
    	boolean flag1=true,flag2=true;
    	awbPref=PropertyHandler.getPropValue(dataFilePath, awbPref);
    	awbNumber=PropertyHandler.getPropValue(dataFilePath, awbNumber);
    	refCol=PropertyHandler.getPropValue(dataFilePath, refCol);
    	valCol=PropertyHandler.getPropValue(dataFilePath, valCol);
    	Screening=PropertyHandler.getPropValue(dataFilePath, Screening);
    	Security=PropertyHandler.getPropValue(dataFilePath, Security);
    	
    	
    	enterKeys(txt_prefix, awbPref);
    	enterKeys(txt_awb, awbNumber);
    	click(btn_list);
    	minWait();
    	minWait();
    	maxWait();
    	waitForElement(tbl_awbClearance);
    	int ref= Integer.parseInt(refCol);
    	int valColumn=Integer.parseInt(valCol);
    	
    		if(verifyValuePresentInTblColumn(tbl_awbClearance, ref, "Screening"))
    		{
    			flag1=false;
    		blockTypeScreening=tblGetTextByColValue(tbl_awbClearance, ref, valColumn, Screening);
    		if(blockTypeScreening.equalsIgnoreCase("Blocked"))
    		Assert.assertTrue(blockTypeScreening.contains("Blocked"), "Screening type is blocked");
    		else
    			Assert.assertTrue(blockTypeScreening.contains("Released"), "Screening type is Released");
    		}
    		
    		else 
    			Assert.assertTrue(flag1,"Screening block is not Set");
    			
    		if(verifyValuePresentInTblColumn(tbl_awbClearance, ref, "Security"))
    		{	
    			flag2=false;
    			blockTypeSecurity=tblGetTextByColValue(tbl_awbClearance, ref, valColumn, Security);
    			if(blockTypeSecurity.equalsIgnoreCase("Blocked"))
    			Assert.assertTrue(blockTypeSecurity.contains("Blocked"), "Security type is  blocked");
    			else
    				Assert.assertTrue(blockTypeSecurity.contains("Released"), "Security type is  Released");	
    		}	
    		else
    			Assert.assertTrue(flag2, "Security type block is not set");
    		
    		
    	
    	
    	
    	
    	
    	return this;
    }
    public OPR023 validateBlockRelease(String awbPref, String awbNumber, String refCol, String valCol, String Screening, String Security )
    {
    	String blockTypeScreening=null,blockTypeSecurity=null;
    	boolean flag1=true,flag2=true;
    	awbPref=PropertyHandler.getPropValue(dataFilePath, awbPref);
    	awbNumber=PropertyHandler.getPropValue(dataFilePath, awbNumber);
    	refCol=PropertyHandler.getPropValue(dataFilePath, refCol);
    	valCol=PropertyHandler.getPropValue(dataFilePath, valCol);
    	Screening=PropertyHandler.getPropValue(dataFilePath, Screening);
    	Security=PropertyHandler.getPropValue(dataFilePath, Security);
    	
    	
    	enterKeys(txt_prefix, awbPref);
    	enterKeys(txt_awb, awbNumber);
    	click(btn_list);
    	minWait();
    	minWait();
    	int ref= Integer.parseInt(refCol);
    	int valColumn=Integer.parseInt(valCol);
    	
    		if(verifyValuePresentInTblColumn(tbl_awbClearance, ref, "Screening"))
    		{
    			flag1=false;
    		blockTypeScreening=tblGetTextByColValue(tbl_awbClearance, ref, valColumn, Screening);
    		Assert.assertTrue(blockTypeScreening.contains("Released"), "Screening type is Released");
    		}
    		else 
    			Assert.assertTrue(flag1,"Screening is blocked");
    			
    		if(verifyValuePresentInTblColumn(tbl_awbClearance, ref, "Security"))
    		{	
    			flag2=false;
    			blockTypeSecurity=tblGetTextByColValue(tbl_awbClearance, ref, valColumn, Security);	
    			Assert.assertTrue(blockTypeSecurity.contains("Released"), "Security type is Released");
    		}	
    		else
    			Assert.assertTrue(flag2, "Security type is blocked");
    		 		
    		
    	
    	
    	return this;
    }
    public OPR023 validateBlockDet(String awbPref, String awbNumber, String Screening, String Security,boolean scrBlk, boolean scyBlk)
    {
    	awbPref=PropertyHandler.getPropValue(dataFilePath, awbPref);
    	awbNumber=PropertyHandler.getPropValue(dataFilePath, awbNumber);
    	enterKeys(txt_prefix, awbPref);
    	enterKeys(txt_awb, awbNumber);
    	click(btn_list);
    	minWait();
    	minWait();
    	String blk_Status;
    	if(scrBlk)
    	{
	    	if(verifyValuePresentInTblColumn(tbl_awbClearance, 4, "Screening"))
	    	{
	    		blk_Status=tblGetTextByColValue(tbl_awbClearance, 8, 4, Screening);
	    		System.out.println(blk_Status);
	    		Assert.assertTrue(blk_Status.contains("Blocked"), "Screening type should be Blocked");
	    	}
    	}
    	else
    	{
    		if(verifyValuePresentInTblColumn(tbl_awbClearance, 4, "Screening"))
	    	{
	    		blk_Status=tblGetTextByColValue(tbl_awbClearance, 8, 4, Screening);
	    		System.out.println(blk_Status);
	    		Assert.assertTrue(blk_Status.contains("Released"), "Screening type should be Released");
	    	}
    	}
    	if(scyBlk)
    	{
    		if(verifyValuePresentInTblColumn(tbl_awbClearance, 4, "Security"))
	    	{
    			blk_Status=tblGetTextByColValue(tbl_awbClearance,8, 4, Security);
    			
    			System.out.println(blk_Status);
    			Assert.assertTrue(blk_Status.contains("Blocked"), "Security type should be Blocked");
	    	}
    	}
    	else
    	{
    		if(verifyValuePresentInTblColumn(tbl_awbClearance, 4, "Screening"))
	    	{
	    		blk_Status=tblGetTextByColValue(tbl_awbClearance, 8, 4, Security);
	    		System.out.println(blk_Status);
	    		Assert.assertTrue(blk_Status.contains("Released"), "Security type should be Released");
	    	}
    	}
    	return this;
    }
    public OPR023 manualblockRelease(String awbPref,String awbNo,boolean security, boolean screening)
    {
    	String blk_status;
    	awbPref=PropertyHandler.getPropValue(dataFilePath, awbPref);
    	awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
    	enterKeys(txt_prefix, awbPref);
    	enterKeys(txt_awb, awbNo);
    	click(btn_list);
    	minWait();
    	
    	if(screening)    	
    		tblClickByColValWithRef(tbl_awbClearance, 1, 4, "Screening");
    	if(security)
    		tblClickByColValWithRef(tbl_awbClearance, 1, 4, "Security");
    		click(btn_release);
    		 driver.switchTo().defaultContent();
    	        waitForNewWindow(2);
    	        switchToSecondWindow();
    	        enterKeys(txt_release, "released");
    	        click(btn_win_rls);
    	        switchToFirstWindow();
    	        waitForFrameAndSwitch(FRAME);
    	        minWait();
    	        if(screening)
    	        {
    	        blk_status=tblGetTextByColValue(tbl_awbClearance, 8, 4, "Screening");
    	        Assert.assertTrue(blk_status.contains("Released"), "Screenigng block should be Released");
    	        }
    	        if(security)
    	        {
    	        blk_status=tblGetTextByColValue(tbl_awbClearance, 8, 4, "Security");
    	        Assert.assertTrue(blk_status.contains("Released"), "Security block should be Released");
    	        }
    	
    	
    	return this;
    }

    public OPR023 verifyBlockNotExist(String awbPre, String awbNo){

    	awbPre = PropertyHandler.getPropValue(dataFilePath,awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath,awbNo);
		enterKeys(txt_prefix, awbPre);
		enterKeys(txt_awb, awbNo);
		click(btn_list);
		minWait();

		Assert.assertEquals(getTableColumns(tbl_awbClearance,1).length,0,"Block exist for AWB No: " + awbNo);

    	return this;
	}
    
    /***************/
    
    
    
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
    /**
     * @author A-8260
     * @param awbPref
     * @param awbNo
     * @param security
     * @param screening
     * @return
     */
    public OPR023 invokeBlockManually(String awbPref,String awbNo,boolean security, boolean screening)
    {
    	String blk_Status;
    	awbPref=PropertyHandler.getPropValue(dataFilePath, awbPref);
    	awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
    	enterKeys(txt_prefix, awbPref);
    	enterKeys(txt_awb, awbNo);
    	click(btn_list);
    	
    	click(btn_block);
    	 waitForNewWindow(2);
         switchToSecondWindow();
    	selectByText(sel_blockedFor, "Screening");
    	scrollToView(txt_remarks);
    	inputText_JS(txt_remarks, "Screening Restricted");
    	//enterKeys(txt_remarks, "Screening Restricted");
    	click(btn_blk_details);
    	switchToFirstWindow();
        waitForFrameAndSwitch(FRAME);
        
        if(screening)
    	{
	    	if(verifyValuePresentInTblColumn(tbl_awbClearance, 4, "Screening"))
	    	{
	    		blk_Status=tblGetTextByColValue(tbl_awbClearance, 8, 4, "Screening");
	    		System.out.println(blk_Status);
	    		Assert.assertTrue(blk_Status.contains("Blocked"), "Screening type should be Blocked");
	    	}
    	}
    	else
    	{
    		if(verifyValuePresentInTblColumn(tbl_awbClearance, 4, "Screening"))
	    	{
	    		blk_Status=tblGetTextByColValue(tbl_awbClearance, 8, 4, "Screening");
	    		System.out.println(blk_Status);
	    		Assert.assertTrue(blk_Status.contains("Released"), "Screening type should be Released");
	    	}
    	}
    	if(security)
    	{
    		if(verifyValuePresentInTblColumn(tbl_awbClearance, 4, "Security"))
	    	{
    			blk_Status=tblGetTextByColValue(tbl_awbClearance,8, 4, "Security");
    			
    			System.out.println(blk_Status);
    			Assert.assertTrue(blk_Status.contains("Blocked"), "Security type should be Blocked");
	    	}
    	}
    	else
    	{
    		if(verifyValuePresentInTblColumn(tbl_awbClearance, 4, "Screening"))
	    	{
	    		blk_Status=tblGetTextByColValue(tbl_awbClearance, 8, 4, "Security");
	    		System.out.println(blk_Status);
	    		Assert.assertTrue(blk_Status.contains("Released"), "Security type should be Released");
	    	}
    	}
        	
        
    	
    	return this;
    }
}