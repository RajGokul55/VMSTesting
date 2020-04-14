/*package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class GSAV extends CommonMethods{

	/***************************** Test Data*******************/
//	final String Browser= "Chrome";
//	final String Url= "https://sjgsavappdevn01.na.gilead.com/WebApp/index.html";
	
	/***************************** Test Cases *******************/
	/*
	 * Test case ‘Test Name’ naming convention: <AppName><TCNumber>_<TestCategory>_<Title>
	Definitions of terms:     
•	AppName: short name of Application [String 5 -10 chars] i.e., TstMyApp, 
•	TCNumber: Test case number [Numeric 2-3 digits] i.e, 01, 02,..
•	TestCategory: Test case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB …]
•	Title: short title of test case based on context of test case  ie., ValidateCredntails
  	Test Name Example: Filkart_05_Web_ValidateCredntails.

	 * Test method name must be same as test case appended with TM example: 
	 */
/*
	@BeforeTest
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void GSAV_01_Web_VerifyURL() {
		TM_GSAV_01_Web_VerifyURL();
	}

	@Test(priority=1, enabled=true)
	public void GSAV_02_Web_VerifyDashboard() {
		TM_GSAV_002_verifyDashboadSummaryScreen();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector: tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 */
/*
	By ipt_Username= By.name("j_username");
	By btn_Continue = By.name("continue");
	By menu_Library= By.name("libraries__c");
	By menu_Documents = By.className("children");
	By menu_AllDocuments = By.className("facetGroupLabel");
	By menu_ViewAll = By.className("viewAllCategories vv_view_all");
	
	By login_button = By.xpath(//*[@id='loginDomainLink']);
	By Operation_Center = By.xpath(//*[@id='tab_title_span-1']);
	By OperationCenter_CriticalThreatsText = By.xpath(//*[@id='top-critical-threat']/div[2]/div[1]/div[2]/div[1]);
    By Summary_btn = By.xpath(//*[@id='tab_title_span-2']);
			locatorXpath_SummaryCriticalThreatsText = //*[@id="top-critical-threat"]/div[2]
			locatorXpath_ProductConnectionText = //*[@id="widget_hd31"]/td[2]/div[3]
			locatorXpath_table = //div[@class='contentScrollerWrap']
			locatorXpath_Active = //div[contains(text(),'_PortalProtect')]
			locatorXpath_Active1 = //*[@id='row_xuebaorp_0']/div[1]/span/text()
			locatorXpath_ServerStatus = //div[@id='row_rmwtqgmg_0']//div[@class='cell modTmcmAppStatusSrv_grid31_ConnectionStatus']
	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn

/*
	void TM_GSAV_01_Web_VerifyURL() {

		TM_GSAV_ApllicationCommonFlow();
	}

	void TM_GSAV_002_verifyDashboadSummaryScreen()throws Exception {

		TM_Gvault_ApllicationCommonFlow();
		
			 login.loggingWithDomainCredentials();
			 login.navigatingToFrames();
			 
			 if(login.verifyOperationCenterScreen())
			 {
				 Assert.assertTrue(true);
			 }
			 else
			 {
				 Assert.assertTrue(false);
			 }
			 
			 if(login.verifySummary())
			 {
				 Assert.assertTrue(true);
			 }
			 else
			 {
				 Assert.assertTrue(false);
			 }
			 
			 if(login.verifySummaryText())
			 {
				 Assert.assertTrue(true);
			 }
			 else
			 {
				 Assert.assertTrue(false);
			 }
			 
			 
			 login.scrollDown();
			 Thread.sleep(2000);
			 
			 if(login.verifyProductConnectionText())
			 {
				 Assert.assertTrue(true);
			 }
			 else
			 {
				 Assert.assertTrue(false);
			 }
				
		
		}
	}


	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here
/*
	void TM_GSAV_ApllicationCommonFlow() {

		WebElement Login_Btn = createWebElementBy(login_button);
		Login_Btn.click();s

		WebElement Continue_Btn = createWebElementBy(btn_Continue);
		Continue_Btn.click();

		WebElement Library_menu = createWebElementBy(menu_Library);
		Library_menu.click();

		WebElement Documents_menu = createWebElementBy(menu_Documents);
		Documents_menu.click();

		WebElement AllDocuments_menu = createWebElementBy(menu_AllDocuments);
		AllDocuments_menu.click();
	}
}*/
