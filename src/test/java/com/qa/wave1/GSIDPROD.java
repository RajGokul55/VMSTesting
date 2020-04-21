package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class GSIDPROD extends CommonMethods {
	/***************************** Test Data*******************/
	
	final String Browser= "Chrome";
	final String naUrl= "https://gsid-na.gilead.com/";
	final String euUrl= "https://gsid-eu.gilead.com/";
	final String apUrl= "https://gsid-ap.gilead.com/";
	final String drUrl= "https://gsid-dr.gilead.com/";
	
	
	/***************************** Test Cases *******************/
	/*
	 * Test case â€˜Test Nameâ€™ naming convention: <AppName><TCNumber>_<TestCategory>_<Title>
	Definitions of terms:     
â€¢	AppName: short name of Application [String 5 -10 chars] i.e., TstMyApp, 
â€¢	TCNumber: Test case number [Numeric 2-3 digits] i.e, 01, 02,..
â€¢	TestCategory: Test case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB â€¦]
â€¢	Title: short title of test case based on context of test case  ie., ValidateCredntails
  	Test Name Example: Filkart_05_Web_ValidateCredntails.

	 * Test method name must be same as test case appended with TM example: 
	 */
	
  
  @Test(priority=0, enabled=true)
  public void GSID_S01_Web_NA_User_authentication_via_SSO() {
	  TM_GSID_S01_Web_User_authentication_via_SSO(naUrl);
  }
  
  @Test(priority=1, enabled=true)
  public void GSID_S02_Web_NA_Triage_Alerts_Validate() {
	  TM_GSID_S02_Web_Triage_Alerts_Validate(naUrl);
  }
  
  @Test(priority=2, enabled=true)
  public void GSID_S03_Web_NA_Watchlists_Validate() {
	  TM_GSID_S03_Web_Watchlists_Validate(naUrl);
  }
  
  @Test(priority=3, enabled=true)
  public void GSID_S04_Web_NA_Process_Search_Validate() {
	  TM_GSID_S04_Web_Process_Search_Validate(naUrl);
  }
  
  @Test(priority=4, enabled=true)
  public void GSID_S05_Web_NA_Search_Binaries_Validate() {
	  TM_GSID_S05_Web_Search_Binaries_Validate(naUrl);
  }
  
  @Test(priority=5, enabled=true)
  public void GSID_S06_Web_NA_Investigations_Validate() {
	  TM_GSID_S06_Web_Investigations_Validate(naUrl);
  }

  @Test(priority=6, enabled=true)
  public void GSID_S07_Web_NA_Sensors_Validate() {
	  TM_GSID_S07_Web_Sensors_Validate(naUrl);
  }
  
  @Test(priority=7, enabled=true)
  public void GSID_S01_Web_EU_User_authentication_via_SSO() {
	  TM_GSID_S01_Web_User_authentication_via_SSO(euUrl);
  }
  
  @Test(priority=8, enabled=true)
  public void GSID_S02_Web_EU_Triage_Alerts_Validate() {
	  TM_GSID_S02_Web_Triage_Alerts_Validate(euUrl);
  }
  
  @Test(priority=9, enabled=true)
  public void GSID_S03_Web_EU_Watchlists_Validate() {
	  TM_GSID_S03_Web_Watchlists_Validate(euUrl);
  }
  
  @Test(priority=10, enabled=true)
  public void GSID_S04_Web_EU_Process_Search_Validate() {
	  TM_GSID_S04_Web_Process_Search_Validate(euUrl);
  }
  
  @Test(priority=11, enabled=true)
  public void GSID_S05_Web_EU_Search_Binaries_Validate() {
	  TM_GSID_S05_Web_Search_Binaries_Validate(euUrl);
  }
  
  @Test(priority=12, enabled=true)
  public void GSID_S06_Web_EU_Investigations_Validate() {
	  TM_GSID_S06_Web_Investigations_Validate(euUrl);
  }

  @Test(priority=13, enabled=true)
  public void GSID_S07_Web_EU_Sensors_Validate() {
	  TM_GSID_S07_Web_Sensors_Validate(euUrl);
  }
  
  @Test(priority=14, enabled=true)
  public void GSID_S01_Web_AP_User_authentication_via_SSO() {
	  TM_GSID_S01_Web_User_authentication_via_SSO(apUrl);
  }
  
  @Test(priority=15, enabled=true)
  public void GSID_S02_Web_AP_Triage_Alerts_Validate() {
	  TM_GSID_S02_Web_Triage_Alerts_Validate(apUrl);
  }
  
  @Test(priority=16, enabled=true)
  public void GSID_S03_Web_AP_Watchlists_Validate() {
	  TM_GSID_S03_Web_Watchlists_Validate(apUrl);
  }
  
  @Test(priority=17, enabled=true)
  public void GSID_S04_Web_AP_Process_Search_Validate() {
	  TM_GSID_S04_Web_Process_Search_Validate(apUrl);
  }
  
  @Test(priority=18, enabled=true)
  public void GSID_S05_Web_AP_Search_Binaries_Validate() {
	  TM_GSID_S05_Web_Search_Binaries_Validate(apUrl);
  }
  
  @Test(priority=19, enabled=true)
  public void GSID_S06_Web_AP_Investigations_Validate() {
	  TM_GSID_S06_Web_Investigations_Validate(apUrl);
  }

  @Test(priority=20, enabled=true)
  public void GSID_S07_Web_AP_Sensors_Validate() {
	  TM_GSID_S07_Web_Sensors_Validate(apUrl);
  }
  
  @Test(priority=21, enabled=true)
  public void GSID_S01_Web_DR_User_authentication_via_SSO() {
	  TM_GSID_S01_Web_User_authentication_via_SSO(drUrl);
  }
  
  @Test(priority=22, enabled=true)
  public void GSID_S02_Web_DR_Triage_Alerts_Validate() {
	  TM_GSID_S02_Web_Triage_Alerts_Validate(drUrl);
  }
  
  @Test(priority=23, enabled=true)
  public void GSID_S03_Web_DR_Watchlists_Validate() {
	  TM_GSID_S03_Web_Watchlists_Validate(drUrl);
  }
  
  @Test(priority=24, enabled=true)
  public void GSID_S04_Web_DR_Process_Search_Validate() {
	  TM_GSID_S04_Web_Process_Search_Validate(drUrl);
  }
  
  @Test(priority=25, enabled=true)
  public void GSID_S05_Web_DR_Search_Binaries_Validate() {
	  TM_GSID_S05_Web_Search_Binaries_Validate(drUrl);
  }
  
  @Test(priority=26, enabled=true)
  public void GSID_S06_Web_DR_Investigations_Validate() {
	  TM_GSID_S06_Web_Investigations_Validate(drUrl);
  }

  @Test(priority=27, enabled=true)
  public void GSID_S07_Web_DR_Sensors_Validate() {
	  TM_GSID_S07_Web_Sensors_Validate(drUrl);
  }
  
  @AfterMethod
  public void afterMethod() {
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
	 * clh_: Column Header
	 */

	By btn_loginWithSSO		=	By.cssSelector("a.button.blue-button.expand.sso-link");
	By btn_triageAlerts		=	By.cssSelector("i[class='Glyph__icon octicon octicon-alert navIcon']");
	By btn_watchlists		=	By.cssSelector("i[class='Glyph__icon octicon octicon-gear navIcon']");
	By btn_processSearch	=	By.cssSelector("i[class='Glyph__icon octicon octicon-search navIcon']");
	By btn_searchBinaries	=	By.cssSelector("i[class='Glyph__icon octicon octicon-file-binary navIcon']");
	By btn_investigations	=	By.cssSelector("i[class='Glyph__icon octicon octicon-tag navIcon']");
	By btn_sensors			=	By.cssSelector("i[class='Glyph__icon octicon octicon-device-desktop navIcon']");
	By msg_title			=	By.cssSelector("h2.pageTitle");
	By tbl_searchStatistics	=	By.cssSelector("div[class='search-statistic row']");
	By tbl_result			=	By.xpath("//div[@class='searchResults']//div[@class='table-and-pagination']");
	By tbl_searchbin		=	By.cssSelector("#search-binaries-rows");
	By img_graph			=	By.cssSelector("canvas[class='flot-overlay']");
	By tbl_sensorList		=	By.cssSelector("div[class='sensors-list']");
	
	
	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn
	
	
	public void TM_GSID_S01_Web_User_authentication_via_SSO(String Url){
		launchBrowser(Browser, Url);
		loginWithSSO();	
		Assert.assertEquals(driver.getTitle(), "HUD - Cb Response");
	}
	
	public void TM_GSID_S02_Web_Triage_Alerts_Validate(String Url) {
		launchBrowser(Browser, Url);
		loginWithSSO();
		WebElement Triage_Btn = createWebElementBy(btn_triageAlerts);
		Triage_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg.getText(), "Triage Alerts");
		WebElement SearchStatistics_Tbl = createWebElementBy(tbl_searchStatistics);
		Assert.assertTrue(SearchStatistics_Tbl.isDisplayed(), "The Search Statistics table was not displayed");
		
	}
	
	public void TM_GSID_S03_Web_Watchlists_Validate(String Url) {
		launchBrowser(Browser, Url);
		loginWithSSO();
		WebElement Watchlists_Btn = createWebElementBy(btn_watchlists);
		Watchlists_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg.getText(), "Watchlists");
		scrollToBottomOfHTML();
		WebElement Result_Tbl = createWebElementBy(tbl_result);
		Assert.assertTrue(Result_Tbl.isDisplayed(), "The result table was not displayed");
		takeScreenshotAtEndOfTest();
		
	}
	
	public void TM_GSID_S04_Web_Process_Search_Validate(String Url) {
		launchBrowser(Browser, Url);
		loginWithSSO();
		WebElement ProcessSearch_Btn = createWebElementBy(btn_processSearch);
		ProcessSearch_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg.getText(), "Process Search");
		takeScreenshotAtEndOfTest();
		
	}
	
	public void TM_GSID_S05_Web_Search_Binaries_Validate(String Url) {
		launchBrowser(Browser, Url);
		loginWithSSO();
		WebElement SearchBinaries_Btn = createWebElementBy(btn_searchBinaries);
		SearchBinaries_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg.getText(), "Search Binaries");
		takeScreenshotAtEndOfTest();
		WebElement SearchBinaries_Tbl = createWebElementBy(tbl_searchbin);
		Assert.assertTrue(SearchBinaries_Tbl.isDisplayed(), "The search binary table is not displayed");
	}
	
	public void TM_GSID_S06_Web_Investigations_Validate(String Url) {
		launchBrowser(Browser, Url);
		loginWithSSO();
		WebElement Investigations_Btn = createWebElementBy(btn_investigations);
		Investigations_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg.getText(), "Investigations");
		takeScreenshotAtEndOfTest();
		WebElement Graph_Img = createWebElementBy(img_graph);
		Assert.assertTrue(Graph_Img.isDisplayed(), "The image graph was not displayed");
		
	}
	
	public void TM_GSID_S07_Web_Sensors_Validate(String Url) {
		launchBrowser(Browser, Url);
		loginWithSSO();
		WebElement Sensors_Btn = createWebElementBy(btn_sensors);
		Sensors_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg.getText(), "Sensors");
		takeScreenshotAtEndOfTest();
		WebElement SensorList_Tbl = createWebElementBy(tbl_sensorList);
		Assert.assertTrue(SensorList_Tbl.isDisplayed(), "The sensor table was not displayed");
	}
	
	/******************************* Methods ***************************/
	public void loginWithSSO() {
		WebElement LoginWithSSo_Btn = createWebElementBy(btn_loginWithSSO);
		LoginWithSSo_Btn.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
	}

}
