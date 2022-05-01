package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * Created by a-7681 on 12/18/2017.
 */
public class STK007 extends BasePage {

    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK007";
    private WebDriver driver;
    private String screenFrame;
    private String dataFileName;
    String Availablestock, RemainStock;
    int count = 0;
    private By dropDown_stockHolderType,
            text_stockHolderCode,
            dropDown_docType,
            dropDown_docSubType,
            btn_btnList,
            Tbl_stockHolderTable,
            btn_btnPrint,
            btn_transfer,
            btn_return,
            btn_btnClose,
            Tbl_monitorStockTable, chckbox_check,
            btn_returnpopup,
            text_modeNumberOfDocuments,
            btn_Ok,
            text_transferTo,
            btn_tansferpopup,
            Tbl_monitorStockTableValue,
            msg_err;
    By btn_noBtn,
            btn_diaYes,
            info_msg;
    
    
    By btn_viewRange,
    	tbl_stk_range,
    	chk_stk_Agent,
    	lbl_available_stock,
    	fromRange,
    	noOfDocs,
    	btn_winClose;
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private String stkFilePath;

    public STK007(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        initElements();
        this.stkFilePath=this.dataFilePath + "stock.properties";
        this.dataFilePath = this.dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
    }

    private void initElements() {

        screenFrame = "iCargoContentFrameSTK007";
        dropDown_stockHolderType = MiscUtility.getWebElement(objFilepath, "STK007_dropDown_stockHolderType");
        text_stockHolderCode = MiscUtility.getWebElement(objFilepath, "STK007_text_stockHolderCode");
        dropDown_docType = MiscUtility.getWebElement(objFilepath, "STK007_dropDown_docType");
        dropDown_docSubType = MiscUtility.getWebElement(objFilepath, "STK007_dropDown_docSubType");
        btn_btnList = MiscUtility.getWebElement(objFilepath, "STK007_btn_btnList");
        btn_btnClose = MiscUtility.getWebElement(objFilepath, "STK007_btn_btnClose");
        chckbox_check = MiscUtility.getWebElement(objFilepath, "STK007_chckbox_check");
        info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
        btn_noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
        btn_diaYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        btn_return = MiscUtility.getWebElement(objFilepath, "STK007_btn_return");
        btn_returnpopup = MiscUtility.getWebElement(objFilepath, "STK007_btn_returnpopup");
        btn_transfer = MiscUtility.getWebElement(objFilepath, "STK007_btn_transfer");
        text_modeNumberOfDocuments = MiscUtility.getWebElement(objFilepath, "STK007_text_modeNumberOfDocuments");
        btn_Ok = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
        text_transferTo = MiscUtility.getWebElement(objFilepath, "STK007_text_transferTo");
        btn_tansferpopup = MiscUtility.getWebElement(objFilepath, "STK007_btn_tansferpopup");
        Tbl_monitorStockTableValue = MiscUtility.getWebElement(objFilepath, "STK007_Tbl_monitorStockTableValue");
        Tbl_stockHolderTable = MiscUtility.getWebElement(objFilepath, "STK007_Tbl_stockHolderTable");
        btn_btnPrint = MiscUtility.getWebElement(objFilepath, "STK007_btn_btnPrint");
        btn_viewRange = MiscUtility.getWebElement(objFilepath, "STK007_btn_viewRange");
        tbl_stk_range = MiscUtility.getWebElement(objFilepath, "STK007_tbl_stkRange");
        chk_stk_Agent = MiscUtility.getWebElement(objFilepath, "STK007_chk_agent");
        fromRange = MiscUtility.getWebElement(objFilepath, "STK007_lbl_frmRnge");
        noOfDocs = MiscUtility.getWebElement(objFilepath, "STK007_lbl_noOfDocs");
        btn_winClose = MiscUtility.getWebElement(objFilepath, "STK007_btn_winClose");
        lbl_available_stock=MiscUtility.getWebElement(objFilepath, "STK007_lbl_availableStock");
        Tbl_stockHolderTable=MiscUtility.getWebElement(objFilepath, "STK007_Tbl_stockHolderTable");
        msg_err=MiscUtility.getWebElement(genObjPath, "Generic_info_error");
    }

    public STK007 ListStockdetails(String StockHoldertype, String DocType, String Subtype, String stockholdercode) {

        // String StockRange = generateRandomString();
        //  PropertyHandler.setPropValue(dataFilePath,stockRange1, StockRange);
        DocType = PropertyHandler.getPropValue(dataFilePath, DocType);
        Subtype = PropertyHandler.getPropValue(dataFilePath, Subtype);
        stockholdercode = PropertyHandler.getPropValue(dataFilePath, stockholdercode);
        StockHoldertype = PropertyHandler.getPropValue(dataFilePath, StockHoldertype);

        selectByText(dropDown_stockHolderType, StockHoldertype);
        enterKeys(text_stockHolderCode, stockholdercode);

        selectByText(dropDown_docType, DocType);
        selectByText(dropDown_docSubType, Subtype);


        click(btn_btnList);
        minWait();
        driver.switchTo().defaultContent();

        String Availablestock = getTableCellValue(Tbl_stockHolderTable, 5, 1);
        String AlloctedStock = getTableCellValue(Tbl_stockHolderTable, 6, 1);

        //Assert.assertTrue(waitForElement(Tbl_stockHolderTable).getText().contains(Status1),"ERROR :Stock not allocated successfully");
        if (Availablestock == null) {
            System.out.println("No data found");
        }

        click(btn_btnPrint);


        return new STK007(driver, dataFileName);
    }

    
    public STK007 listStokeHolderDetails(String StockHoldertype, String DocType, String Subtype, String stockholdercode,String availableStocks)
    {
    	 DocType = PropertyHandler.getPropValue(dataFilePath, DocType);
         Subtype = PropertyHandler.getPropValue(dataFilePath, Subtype);
         stockholdercode = PropertyHandler.getPropValue(dataFilePath, stockholdercode);
         StockHoldertype = PropertyHandler.getPropValue(dataFilePath, StockHoldertype);

         selectByText(dropDown_stockHolderType, StockHoldertype);
         enterKeys(text_stockHolderCode, stockholdercode);

         selectByText(dropDown_docType, DocType);
         selectByText(dropDown_docSubType, Subtype);
        
         click(btn_btnList);
       
         if(verifyElementPresent(msg_err))
        	 Assert.assertTrue(waitForElement(msg_err).getText().contains("Invalid Stock Holder"),"Invalid Stock Holder should be pronted");
         else
         {
        	  String av_stk=getTableCellValue(Tbl_stockHolderTable, 5, 1).trim();
              PropertyHandler.setPropValue(dataFilePath,availableStocks, av_stk);
         }
         minWait();
        
         
         return this;
    }
    
    public STK007 selectStockRange(String stockType,String StockHoldertype, String DocType, String Subtype, String stockholdercode, String frmRange, String noOfDocuments, String availableStocks) 
    {
    	 DocType = PropertyHandler.getPropValue(dataFilePath, DocType);
         Subtype = PropertyHandler.getPropValue(dataFilePath, Subtype);
         stockholdercode = PropertyHandler.getPropValue(dataFilePath, stockholdercode);
         StockHoldertype = PropertyHandler.getPropValue(dataFilePath, StockHoldertype);
         stockType=PropertyHandler.getPropValue(dataFilePath, stockType);
         String rangeFrom="",numberOfDocs="";
         selectByText(dropDown_stockHolderType, StockHoldertype);
         enterKeys(text_stockHolderCode, stockholdercode);

         selectByText(dropDown_docType, DocType);
         selectByText(dropDown_docSubType, Subtype);


         click(btn_btnList);
         minWait();
         //String av_stk=waitForElement(lbl_available_stock).getText();
         
         click(chk_stk_Agent);
         //String av_stk=getTableCellValue(Tbl_stockHolderTable, 5, 1);
         
         
         //System.out.println(av_stk);
         //PropertyHandler.setPropValue(dataFilePath,availableStocks, av_stk);
         
         click(btn_viewRange);
         
         driver.switchTo().defaultContent();
         waitForNewWindow(2);
         switchToSecondWindow();
         minWait();
         rangeFrom=waitForElement(fromRange).getText();
         numberOfDocs=waitForElement(noOfDocs).getText();
         System.out.println(numberOfDocs);
         PropertyHandler.setPropValue(dataFilePath, frmRange, rangeFrom);
         PropertyHandler.setPropValue(dataFilePath, noOfDocuments, numberOfDocs);
         String stockRange=rangeFrom.substring(0, rangeFrom.length() - 1);
         int stkRange=Integer.parseInt(stockRange);
         int numDocs=Integer.parseInt(numberOfDocs);
         PropertyHandler.setPropValue(stkFilePath, stockType+"_range_from", stockRange);
         PropertyHandler.setPropValue(stkFilePath, stockType+"_range_next", stockRange);
         PropertyHandler.setPropValue(stkFilePath, stockType+"_range_to",String.valueOf((stkRange+numDocs)-1));
         
         click(btn_winClose);
         switchToFirstWindow();
         waitForFrameAndSwitch(FRAME);
         
         
        
         
    	return this;
    }
    
    public STK007 validateNumberofDocs(String StockHoldertype, String DocType, String Subtype, String stockholdercode, String totalDocs)
    {
    	DocType = PropertyHandler.getPropValue(dataFilePath, DocType);
        Subtype = PropertyHandler.getPropValue(dataFilePath, Subtype);
        stockholdercode = PropertyHandler.getPropValue(dataFilePath, stockholdercode);
        StockHoldertype = PropertyHandler.getPropValue(dataFilePath, StockHoldertype);
        totalDocs=PropertyHandler.getPropValue(dataFilePath, totalDocs);
        selectByText(dropDown_stockHolderType, StockHoldertype);
        
        enterKeys(text_stockHolderCode, stockholdercode);

        selectByText(dropDown_docType, DocType);
        selectByText(dropDown_docSubType, Subtype);
        click(btn_btnList);
        
        String av_docs=getTableCellValue(Tbl_stockHolderTable, 5, 1).trim();
        System.out.println(av_docs);
        System.out.println(totalDocs);
       Assert.assertTrue(av_docs.equals(totalDocs), "Total no of docs should be equal to the available");
        
        

        click(btn_btnList);
        minWait();
    	return this;
    }
    
    
   /* public STK007 listAndViewRange(String StockHoldertype, String DocType, String Subtype, String stockholdercode,String rangeFrom,String docs)
    {
    	String rangeFrm="",noOfDocs="" ;
    	 DocType = PropertyHandler.getPropValue(dataFilePath, DocType);
         Subtype = PropertyHandler.getPropValue(dataFilePath, Subtype);
         stockholdercode = PropertyHandler.getPropValue(dataFilePath, stockholdercode);
         StockHoldertype = PropertyHandler.getPropValue(dataFilePath, StockHoldertype);

         selectByText(dropDown_stockHolderType, StockHoldertype);
         enterKeys(text_stockHolderCode, stockholdercode);

         selectByText(dropDown_docType, DocType);
         selectByText(dropDown_docSubType, Subtype);


         click(btn_btnList);
         minWait();
         
         tblClickByColValue(Tbl_monitorStockTableValue, 1);
         click(btn_viewRange);
         driver.switchTo().defaultContent();
         waitForNewWindow(2);
         switchToSecondWindow();
         //rangeFrm=
         //noOfDocs=		 
         PropertyHandler.setPropValue(dataFilePath, rangeFrom, rangeFrm);
         PropertyHandler.setPropValue(dataFilePath, docs, noOfDocs);
         
         
    	return this;
    }*/

    public STK007 ListDistributionDetails(String StockHoldertype, String DocType, String Subtype, String stockholdercode, String NoDocs, String stockholdercode2) {

        // String StockRange = generateRandomString();
        //  PropertyHandler.setPropValue(dataFilePath,stockRange1, StockRange);
        DocType = PropertyHandler.getPropValue(dataFilePath, DocType);
        Subtype = PropertyHandler.getPropValue(dataFilePath, Subtype);
        stockholdercode = PropertyHandler.getPropValue(dataFilePath, stockholdercode);
        stockholdercode2 = PropertyHandler.getPropValue(dataFilePath, stockholdercode2);
        NoDocs = PropertyHandler.getPropValue(dataFilePath, NoDocs);
        StockHoldertype = PropertyHandler.getPropValue(dataFilePath, StockHoldertype);
        selectByText(dropDown_stockHolderType, StockHoldertype);
        enterKeys(text_stockHolderCode, stockholdercode);

        selectByText(dropDown_docType, DocType);
        selectByText(dropDown_docSubType, Subtype);


        click(btn_btnList);
        minWait();
        // verifyElementPresent(chckbox_check);
        check(chckbox_check);

        String Availablestock = getTableCellValue(Tbl_monitorStockTableValue, 5, 1);
        String AlloctedStock = getTableCellValue(Tbl_monitorStockTableValue, 6, 1);
        String Stockholdertype1 = getTableCellValue(Tbl_monitorStockTableValue, 2, 1);

        //Assert.assertTrue(waitForElement(Tbl_stockHolderTable).getText().contains(Status1),"ERROR :Stock not allocated successfully");


        //  tblSelectRowByColValue(Tbl_monitorStockTableValue, 1, 1, Stockholdertype1);
        click(btn_return);
        minWait();

        waitForNewWindow(2);

        switchToSecondWindow();
        enterKeys(text_modeNumberOfDocuments, NoDocs);


        click(btn_returnpopup);

        minWait();
        driver.switchTo().defaultContent();

        String status = waitForElement(info_msg).getText();

        Assert.assertTrue(waitForElement(info_msg).getText().contains("Are you sure you want to return?"), "ERROR :No Provision to return stock.");
        Assert.assertTrue(status.contains("Are you sure you want to return?"), "ERROR :No Provision to return stock.");
        minWait();
        click(btn_noBtn);
        minWait();

        click(btn_returnpopup);

        minWait();
        driver.switchTo().defaultContent();

        click(btn_diaYes);
        minWait();
        driver.switchTo().defaultContent();
        String status1 = waitForElement(info_msg).getText();

        Assert.assertTrue(waitForElement(info_msg).getText().contains("Documents Have Been Returned"), "ERROR :No Provision to return stock.");
        Assert.assertTrue(status1.contains("Documents Have Been Returned"), "ERROR :No Provision to return stock.");
        click(btn_Ok);
        minWait();
        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);


        check(Tbl_monitorStockTableValue);
        //*[@id="monitorStockTable"]/tbody/tr[2]/td[4]);
        click(btn_transfer);
        minWait();

        waitForNewWindow(2);

        switchToSecondWindow();
        enterKeys(text_transferTo, stockholdercode2);
        enterKeys(text_modeNumberOfDocuments, NoDocs);


        click(btn_tansferpopup);

        minWait();
        driver.switchTo().defaultContent();
        String status2 = waitForElement(info_msg).getText();

        Assert.assertTrue(waitForElement(info_msg).getText().contains("Are you sure you want to transfer?"), "ERROR :No Provision to transfer stock.");
        Assert.assertTrue(status2.contains("Are you sure you want to transfer?"), "ERROR :No Provision to transfer stock.");
        minWait();
        click(btn_noBtn);
        minWait();

        click(btn_tansferpopup);

        minWait();
        driver.switchTo().defaultContent();

        click(btn_diaYes);
        minWait();
        minWait();
        switchToFirstWindow();

        waitForFrameAndSwitch(FRAME);


        return this;


    }

    public STK007 PrintDetails(String StockHoldertype, String DocType, String Subtype, String stockholdercode) {

        // String StockRange = generateRandomString();
        //  PropertyHandler.setPropValue(dataFilePath,stockRange1, StockRange);
        DocType = PropertyHandler.getPropValue(dataFilePath, DocType);
        Subtype = PropertyHandler.getPropValue(dataFilePath, Subtype);
        stockholdercode = PropertyHandler.getPropValue(dataFilePath, stockholdercode);

        StockHoldertype = PropertyHandler.getPropValue(dataFilePath, StockHoldertype);
        selectByText(dropDown_stockHolderType, StockHoldertype);
        enterKeys(text_stockHolderCode, stockholdercode);

        selectByText(dropDown_docType, DocType);
        selectByText(dropDown_docSubType, Subtype);


        click(btn_btnList);
        minWait();
        click(btn_btnPrint);
        minWait();
        return this;
    }

    public HomePage close() {

        click(btn_btnClose);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(btn_diaYes)) {

            click(btn_diaYes);
        }
        return new HomePage(driver, dataFileName);
    }

    /**
     * Created by a-8255 on 06/02/2018
     */
    public STK007 availableStock(String StockHoldertype, String DocType, String Subtype, String stockholdercode) {

        // String StockRange = generateRandomString();
        //  PropertyHandler.setPropValue(dataFilePath,stockRange1, StockRange);
        StockHoldertype = PropertyHandler.getPropValue(dataFilePath, StockHoldertype);
        DocType = PropertyHandler.getPropValue(dataFilePath, DocType);
        Subtype = PropertyHandler.getPropValue(dataFilePath, Subtype);
        stockholdercode = PropertyHandler.getPropValue(dataFilePath, stockholdercode);


        selectByText(dropDown_stockHolderType, StockHoldertype);
        enterKeys(text_stockHolderCode, stockholdercode);

        selectByText(dropDown_docType, DocType);
        selectByText(dropDown_docSubType, Subtype);


        click(btn_btnList);
        minWait();
        //	driver.switchTo().defaultContent();

        if (count == 0) {
            //count value = 0 means before AWB got generated, count will get increased once

            Availablestock = getTableCellValue(Tbl_stockHolderTable, 5, 1);
            count = count + 1;
        } else if (count > 0) {
            RemainStock = getTableCellValue(Tbl_stockHolderTable, 5, 1);
        }

        //count=count+1;


        return new STK007(driver, dataFileName);
    }

    /**
     * get available stock
     * Created by a-7681
     */
    public STK007 getAvailableStock(String StockHoldertype, String DocType, String Subtype, String stockholdercode, String avlStock) {

        // String StockRange = generateRandomString();
        //  PropertyHandler.setPropValue(dataFilePath,stockRange1, StockRange);
        StockHoldertype = PropertyHandler.getPropValue(dataFilePath, StockHoldertype);
        DocType = PropertyHandler.getPropValue(dataFilePath, DocType);
        Subtype = PropertyHandler.getPropValue(dataFilePath, Subtype);
        stockholdercode = PropertyHandler.getPropValue(dataFilePath, stockholdercode);


        selectByText(dropDown_stockHolderType, StockHoldertype);
        enterKeys(text_stockHolderCode, stockholdercode);

        selectByText(dropDown_docType, DocType);
        selectByText(dropDown_docSubType, Subtype);


        click(btn_btnList);
        minWait();
        //	driver.switchTo().defaultContent();

            PropertyHandler.setPropValue(dataFilePath,avlStock,getTableCellValue(Tbl_stockHolderTable, 5, 1));

        return new STK007(driver, dataFileName);
    }

    /**
     * Ckeck available stock
     * Created by a-7681
     */
    public STK007 checkAvailableStock(String StockHoldertype, String DocType, String Subtype, String stockholdercode, String avlStock) {

        // String StockRange = generateRandomString();
        //  PropertyHandler.setPropValue(dataFilePath,stockRange1, StockRange);
        StockHoldertype = PropertyHandler.getPropValue(dataFilePath, StockHoldertype);
        DocType = PropertyHandler.getPropValue(dataFilePath, DocType);
        Subtype = PropertyHandler.getPropValue(dataFilePath, Subtype);
        stockholdercode = PropertyHandler.getPropValue(dataFilePath, stockholdercode);
        avlStock = PropertyHandler.getPropValue(dataFilePath, avlStock);


        selectByText(dropDown_stockHolderType, StockHoldertype);
        enterKeys(text_stockHolderCode, stockholdercode);

        selectByText(dropDown_docType, DocType);
        selectByText(dropDown_docSubType, Subtype);


        click(btn_btnList);
        minWait();
        //	driver.switchTo().defaultContent();

        Assert.assertEquals(getTableCellValue(Tbl_stockHolderTable, 5, 1).trim(),avlStock,"The available stock doesn't match for stockholder: " + stockholdercode);

        return new STK007(driver, dataFileName);
    }

    /*
     * A-8255
     */
    public STK007 compareAvailStock(boolean isAWBdeleted) {

        if (!isAWBdeleted)
            Assert.assertTrue((Availablestock.equals(RemainStock + 1)), "AWB number has been depleted from stock");

        if (isAWBdeleted)
            Assert.assertTrue((Availablestock.equals(RemainStock)), "AWB number has not been depleted from stock");

        return this;
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * created by A-8254
     * @param string
     * @param string2
     * @param string3
     * @return
     */
    

	public STK007 verifyAvailableStockUpdatedCorrectly(String avlStock,
			String noOfDocs, String avlStock2) {
		
		
		avlStock = PropertyHandler.getPropValue(dataFilePath, avlStock);
		noOfDocs = PropertyHandler.getPropValue(dataFilePath, noOfDocs);	
		avlStock2 = PropertyHandler.getPropValue(dataFilePath, avlStock2);
		int avlStockInt=Integer.parseInt(avlStock);
		int noOfDocsInt=Integer.parseInt(noOfDocs);
		int avlStock2Int=Integer.parseInt(avlStock2);
		
		int avlStockIntnew;
		avlStockIntnew=avlStockInt+noOfDocsInt;
		Assert.assertEquals(avlStockIntnew, avlStock2Int,"Error:Available stock Not updated");
		
		
		return this;
	}
	
	/**
	 * Method to validate agent access restriction error
	 * @param StockHoldertype
	 * @param DocType
	 * @param Subtype
	 * @param stockholdercode
	 * @param availableStocks
	 * @return
	 * @author A-7868 Krishna <04/05/2018>
	 */
	 public STK007 verifyAgentAccessPrivilegeError(String StockHoldertype, String DocType, String Subtype, String stockholdercode)
	    {
	    	 DocType = PropertyHandler.getPropValue(dataFilePath, DocType);
	         Subtype = PropertyHandler.getPropValue(dataFilePath, Subtype);
	         stockholdercode = PropertyHandler.getPropValue(dataFilePath, stockholdercode);
	         StockHoldertype = PropertyHandler.getPropValue(dataFilePath, StockHoldertype);

	         selectByText(dropDown_stockHolderType, StockHoldertype);
	         enterKeys(text_stockHolderCode, stockholdercode);

	         selectByText(dropDown_docType, DocType);
	         selectByText(dropDown_docSubType, Subtype);
	        
	         click(btn_btnList);
	         minWait();
	         
	         Assert.assertTrue(waitForElement(msg_err).getText().contains("privilege"),"Error message mismatch."); //update the message contains() part
	         return this;
	    }
}
