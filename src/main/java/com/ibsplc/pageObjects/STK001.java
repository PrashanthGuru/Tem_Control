package com.ibsplc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-8254 on 17/04/2018.
 */
public class STK001 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK001";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    
    
    By btn_noBtn,
    btn_diaYes,
    info_msg,
    Info_successMessageToast;
   
    
    By btnClose,
    dropdown_DocType,
    dropdown_SubType,
    txt_approver,
    dropdown_stockHolderType,
    txt_stockHolderCode,
    txt_rangeFrom,
    txt_rangeTo,
    txt_NoOfDocs,
    btnList,
    checkbox_selectAll,
    checkbox_selectFirst,
    btn_moveRange,
    checkbox_selectAll_RightSideTable,
    btn_delete,
    table_right;
    
    
    private By  sel_docType,
	sel_subType,	
	sel_stkHolderType,
	txt_stkHldCode,	
	txt_noOfDocs,
	btn_rangeList,
	btn_pushRange,
	btn_save,
	btn_btnClose,
	
	tbl_range,
	lbl_totlDocs
	;
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK001";
     
       
        info_msg= MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btnClose=MiscUtility.getWebElement(objFilepath,"STK001_btnClose");
        dropdown_DocType=MiscUtility.getWebElement(objFilepath,"STK001_dropdown_DocType");
        dropdown_SubType=MiscUtility.getWebElement(objFilepath,"STK001_dropdown_SubType");
        txt_approver=MiscUtility.getWebElement(objFilepath,"STK001_txt_approver");
        dropdown_stockHolderType=MiscUtility.getWebElement(objFilepath,"STK001_dropdown_stockHolderType");
        txt_stockHolderCode=MiscUtility.getWebElement(objFilepath,"STK001_txt_stockHolderCode");
        txt_rangeFrom=MiscUtility.getWebElement(objFilepath,"STK001_txt_rangeFrom");
        txt_rangeTo=MiscUtility.getWebElement(objFilepath,"STK001_txt_rangeTo");
        txt_NoOfDocs=MiscUtility.getWebElement(objFilepath,"STK001_txt_NoOfDocs");
        btnList=MiscUtility.getWebElement(objFilepath,"STK001_btnList");
        checkbox_selectAll=MiscUtility.getWebElement(objFilepath,"STK001_checkbox_selectAll");
        checkbox_selectFirst=MiscUtility.getWebElement(objFilepath,"STK001_checkbox_selectFirst");
        btn_moveRange=MiscUtility.getWebElement(objFilepath,"STK001_btn_moveRange");
        btn_save=MiscUtility.getWebElement(objFilepath,"STK001_btn_save");
        Info_successMessageToast=MiscUtility.getWebElement(genObjPath,"Info_successMessageToast");
        checkbox_selectAll_RightSideTable=MiscUtility.getWebElement(objFilepath,"STK001_checkbox_selectAll_RightSideTable");
        btn_delete=MiscUtility.getWebElement(objFilepath,"STK001_btn_delete");
        table_right=MiscUtility.getWebElement(objFilepath,"STK001_table_right");
        
        
        
        //A-8260
        sel_docType=MiscUtility.getWebElement(objFilepath, "STK001_sel_docType");
    	sel_subType=MiscUtility.getWebElement(objFilepath, "STK001_sel_subType");    	
    	sel_stkHolderType=MiscUtility.getWebElement(objFilepath, "STK001_sel_stkHolderType");
    	txt_stkHldCode=MiscUtility.getWebElement(objFilepath, "STK001_txt_stkHolderCode");    	
    	txt_noOfDocs=MiscUtility.getWebElement(objFilepath, "STK001_txt_noOfDocs");
    	btn_rangeList=MiscUtility.getWebElement(objFilepath, "STK001_btn_rangeList");
    	btn_pushRange=MiscUtility.getWebElement(objFilepath, "STK001_btn_moveRange");    	
    	btn_btnClose = MiscUtility.getWebElement(objFilepath, "STK007_btn_btnClose");
    	 btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
    	 tbl_range= MiscUtility.getWebElement(objFilepath, "STK001_tbl_stock");
    	 lbl_totlDocs=MiscUtility.getWebElement(objFilepath, "STK001_totlDocs");
    }
   

	 public STK001(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	
	
	 public STK001 listAvailableStock(String docType,String subType,String approver,String stockHolderType,String stockHolderCode,String rangeFrom,String RangeTo,String noOfDocs)
	 {
		 
		 docType=PropertyHandler.getPropValue(dataFilePath,docType);
		 subType=PropertyHandler.getPropValue(dataFilePath,subType);
		 approver=PropertyHandler.getPropValue(dataFilePath,approver);
		 stockHolderType=PropertyHandler.getPropValue(dataFilePath,stockHolderType);
		 stockHolderCode=PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
		 rangeFrom=PropertyHandler.getPropValue(dataFilePath,rangeFrom);
		 RangeTo=PropertyHandler.getPropValue(dataFilePath,RangeTo);
		 noOfDocs=PropertyHandler.getPropValue(dataFilePath,noOfDocs);
		 
		 selectByText(dropdown_DocType, docType);
		 selectByText(dropdown_SubType, subType);
		 enterKeys(txt_approver, approver);
		 selectByText(dropdown_stockHolderType, stockHolderType);
		 enterKeys(txt_stockHolderCode, stockHolderCode);
		 enterKeys(txt_rangeFrom,rangeFrom);
		// enterKeys(txt_rangeTo, RangeTo);
		 enterKeys(txt_NoOfDocs, noOfDocs);
		 click(btnList);
		 minWait();
		
		 
		 
		 return this;
	 }
	 
	 
	 public STK001 verifyAvailableStockListed()
	 {
		Assert.assertTrue(waitForElement(checkbox_selectFirst).isDisplayed(),"ERROR:Stock not listed,or no stock"); 
		 
		 return this;
	 }
	 
	 
	 public STK001 selectStockAndSave()
	 {
		check(checkbox_selectAll);
		click(btn_moveRange);
		click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
	    Assert.assertTrue(waitForElement(info_msg).getText().contains("Do you want to allocate the stock?"),"ERROR :MSG- Do you want to allocate the stock? not displayed");
	    minWait();
	    click(btn_noBtn);
	    minWait();
	    waitForFrameAndSwitch(FRAME);
	    click(btn_save);
		minWait();
		driver.switchTo().defaultContent();
		minWait();
		click(btn_diaYes);
		minWait();
	//	Assert.assertTrue(waitForElement(Info_successMessageToast).getText().contains("Save Successful"),"ERROR :MSG- Save Successful not displayed");
		waitForFrameAndSwitch(FRAME);
		 
		 return this;
	 }
	 			
	 public STK001 verifyToAddAndDeleteMultipleStockRange()
	 {
		 check(checkbox_selectAll);
		 click(btn_moveRange);
		 click(btnList);
		 click(btn_moveRange);
		
		 check(checkbox_selectAll_RightSideTable);
		 click(btn_delete);
		
		
		 
		 return this;
	 }
	 
		 public HomePage close() {
	
				        click(btnClose);
				        driver.switchTo().defaultContent();
				        if (verifyElementPresent(btn_diaYes)) {
	
				            click(btn_diaYes);
				        }
				        return new HomePage(driver, dataFileName);
				    }

		/**
		 * @author A-8260 
		 * @param docType
		 * @param subType
		 * @param approver
		 * @param stkHoldrType
		 * @param stkHldrCode
		 * @param rangeFrom
		 * @param noOfDocs
		 * @param totalDocs
		 * @param availableStocks
		 * @return
		 */
		 public STK001 allocateStockRange(String docType,String subType,String approver,String stkHoldrType,String stkHldrCode, String rangeFrom, String noOfDocs, String totalDocs,String availableStocks)
		    {
		    	docType=PropertyHandler.getPropValue(dataFilePath, docType);
		    	subType=PropertyHandler.getPropValue(dataFilePath, subType);
		    	approver=PropertyHandler.getPropValue(dataFilePath, approver);
		    	stkHoldrType=PropertyHandler.getPropValue(dataFilePath, stkHoldrType);
		    	stkHldrCode=PropertyHandler.getPropValue(dataFilePath, stkHldrCode);
		    	rangeFrom=PropertyHandler.getPropValue(dataFilePath, rangeFrom);
		    	noOfDocs=PropertyHandler.getPropValue(dataFilePath, noOfDocs);
		    	availableStocks=PropertyHandler.getPropValue(dataFilePath, availableStocks);
		    	int noOfDocuments;
		    	List<WebElement> doctypeList= getWebElements(sel_docType); 
		    	List<WebElement> subtypeList= getWebElements(sel_subType);
//		    	for(int i=0;i<doctypeList.size();i++)
//		    	{
//		    		if(verifyElementPresent(doctypeList.get(i)))
//		    		{
//		    			selectByText(doctypeList.get(i), docType);
//		    			break;
//		    		}
//		    		
//		    	}
//		    	for(int i=0;i<subtypeList.size();i++)
//		    	{
//		    		if(verifyElementPresent(subtypeList.get(i)))
//		    			selectByText(subtypeList.get(i), subType);
//		    		
//		    	}
		    	selectByText(sel_docType, docType);
		    	selectByText(sel_subType, subType);
		    	enterKeys(txt_approver, approver);
		    	selectByText(sel_stkHolderType, stkHoldrType);
		    	enterKeys(txt_stkHldCode, stkHldrCode);
		    	enterKeys(txt_rangeFrom, rangeFrom);
		    	enterKeys(txt_noOfDocs, noOfDocs);
		    	
		    	click(btn_rangeList);
		    	minWait();
		    	click(btn_pushRange);
		    	minWait();
		    	noOfDocuments=Integer.parseInt(waitForElement(lbl_totlDocs).getAttribute("value"));
		    	int prevNoofDocs=Integer.parseInt(noOfDocs);
		    	int avDocs=Integer.parseInt(availableStocks);
		    	//int avDocs=Integer.parseInt(availableStocks);
		    	System.out.println(prevNoofDocs);
		    	System.out.println(noOfDocuments);
		    	String total= String.valueOf(avDocs+noOfDocuments);
		    	PropertyHandler.setPropValue(dataFilePath, totalDocs, total);
		    	minWait();
		    	click(btn_save);
		    	driver.switchTo().defaultContent();
		    	if(verifyElementEnabled(btn_diaYes))
		    		click(btn_diaYes);
		    	minWait();
		    	waitForFrameAndSwitch(FRAME);
		    	
		    	return this;
		    }
	 
}
