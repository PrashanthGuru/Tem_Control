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
public class STK017 extends BasePage {

	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties","testDataDirectory");
    public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "STK.properties");
    public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    public static String FRAME = "iCargoContentFrameSTK017";
    WebDriver driver;
    String screenFrame;
    String testDataFile;
    String dataFileName;

    
    By txt_stockHolder,
    btn_btList,
    btn_addRow,
    txt_agents,
    txt_stockHolders,
    btn_btSave,
    btn_btClose;
    

    By btn_noBtn,
    btn_diaYes,
    info_msg;
    
    By txt_Agent,
    tbl_stk,
    msg_err,
    btn_add;
    
    
    
    private void initElements() {

        screenFrame = "iCargoContentFrameSTK017";
        txt_stockHolder=MiscUtility.getWebElement(objFilepath,"STK017_txt_stockHolder");
        btn_btList=MiscUtility.getWebElement(objFilepath,"STK017_btn_btList");
        btn_addRow=MiscUtility.getWebElement(objFilepath,"STK017_btn_addRow");
        txt_agents=MiscUtility.getWebElement(objFilepath,"STK017_txt_agents");
        txt_stockHolders=MiscUtility.getWebElement(objFilepath,"STK017_txt_stockHolders");
        btn_btSave=MiscUtility.getWebElement(objFilepath,"STK017_btn_btSave");
        btn_btClose=MiscUtility.getWebElement(objFilepath,"STK017_btn_btClose");
        
        txt_Agent=MiscUtility.getWebElement(objFilepath,"STK017_txt_agent");
        tbl_stk=MiscUtility.getWebElement(objFilepath,"STK017_tbl_stkTbl");
        msg_err=MiscUtility.getWebElement(genObjPath, "Generic_info_error");
        btn_add=MiscUtility.getWebElement(objFilepath,"STK017_stk_add");
    }


	 public STK017(WebDriver driver, String dataFileName) {
	        super(driver);
	        this.driver = driver;
	        initElements();
	        this.dataFilePath = this.dataFilePath + dataFileName;
	        
	        this.dataFileName = dataFileName;
	    }
	 
	  public STK017 AgentStockHolderMapping(String stockHolderCode,String AgentName){
		  
		 
		  stockHolderCode = PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
		  AgentName = PropertyHandler.getPropValue(dataFilePath,AgentName);
		  
		  enterKeys(txt_stockHolder,stockHolderCode);
		  click(btn_btList);
		  minWait();
	//	  driver.switchTo().defaultContent();
		  minWait();
	//	  waitForFrameAndSwitch(FRAME);
		  click(btn_addRow);
		 
		  if(!(verifyElementPresent(txt_agents))){
			  click(btn_addRow);
		  }
		  minWait();
		  enterKeys(txt_agents, AgentName);
		  enterKeys(txt_stockHolders, stockHolderCode);
		  click(btn_btSave);
		  minWait();
	//	  driver.switchTo().defaultContent();
	//	  minWait();
	//	  waitForFrameAndSwitch(FRAME);
		  enterKeys(txt_stockHolder, stockHolderCode);
		  click(btn_btList);
		  click(btn_btList);
		  minWait();
	//	  driver.switchTo().defaultContent();
	//	  minWait();
	//	  waitForFrameAndSwitch(FRAME);
		  String agent = waitForElement(txt_agents).getAttribute("value");
		  String stockholder = waitForElement(txt_stockHolders).getText();
		  Assert.assertTrue(waitForElement(txt_agents).getAttribute("value").contains(AgentName),"ERROR :Agent stockholder not mapped");
		  Assert.assertTrue(agent.contains(AgentName), "ERROR :Agent stockholder not mapped");
		  
		 return this;
	  }
	
	  
	  /**
	   * @author A-8260
	   * @return
	   */
						        
		public STK017 listStockHolder(String stockHolderCode,String AgentName)
		{
			  stockHolderCode = PropertyHandler.getPropValue(dataFilePath,stockHolderCode);
			  AgentName = PropertyHandler.getPropValue(dataFilePath,AgentName);			  
			  
			  
			  enterKeys(txt_Agent, AgentName);
			  click(btn_btList);
			  minWait();
			  if(verifyElementPresent(msg_err))
				  click(btn_add);
			  minWait();
			  enterKeys(txt_stockHolders, stockHolderCode);
			  enterKeys(txt_agents, AgentName);
			  tblClickByColValue(tbl_stk, 1);
			  click(btn_btSave);
			  
			
			return this;
		}
			        
			        public HomePage close() {

			            click(btn_btClose);
			            driver.switchTo().defaultContent();
			            if (verifyElementPresent(btn_diaYes)) {

			                click(btn_diaYes);
			            }
			            return new HomePage(driver, dataFileName);
			        }

			    }

	 

