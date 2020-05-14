package com.qa.wave1;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class GSID extends CommonMethods {
	/***************************** Test Data*******************/

	final String Browser= "Chrome";
	final String unUrl= "https://gsid.gilead.com/";
	final String naUrl= "https://gsid-na.gilead.com/";
	final String euUrl= "https://gsid-eu.gilead.com/";
	final String apUrl= "https://gsid-ap.gilead.com/";
	final String drUrl= "https://gsid-dr.gilead.com/";
	final String devUrl= "https://gsiddev.gilead.com ";


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
	String URL = devUrl;

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
	}

	@Test(priority=0, enabled=false)
	public void GSID_S01_Web_User_authentication_via_SSO() {
		TM_GSID_S01_Web_User_authentication_via_SSO();
	}

	@Test(priority=1, enabled=false)
	public void GSID_S02_Web_ClusterRegions_verification() {
		TM_GSID_S02_Web_ClusterRegions_verification();
	}

	@Test(priority=2, enabled=false)
	public void GSID_S03_Web_User_authentication_via_SSO() {
		TM_GSID_S03_Web_User_authentication_via_SSO();
	}

	@Test(priority=3, enabled=false)
	public void GSID_S04_Web_Triage_Alerts_Validate() {
		TM_GSID_S04_Web_Triage_Alerts_Validate();
	}

	@Test(priority=4, enabled=false)
	public void GSID_S05_Web_Watchlists_Validate() {
		TM_GSID_S05_Web_Watchlists_Validate();
	}

	@Test(priority=5, enabled=false)
	public void GSID_S06_Web_Search_Binaries_Process_Search_Validate() {
		TM_GSID_S06_Web_Search_Binaries_Process_Search_Validate();
	}

	@Test(priority=6, enabled=false)
	public void GSID_S07_Web_Investigations_Sensors_Validate() {
		TM_GSID_S07_Web_Investigations_Sensors_Validate();
	}


	@Test(priority=7, enabled=false)
	public void GSID_S08_Web_User_authentication_via_SSO_GSIDDevUrl() {
		TM_GSID_S08_Web_User_authentication_via_SSO_GSIDDevUrl();
	}

	@Test(priority=8, enabled=true)
	public void GSID_S09_Web_Tabs_verification_DevURL() {
		TM_GSID_S09_Web_Tabs_verification_DevURL();
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
	By msg_title			=	By.cssSelector("h2.pageTitle");
	By tbl_clusterTable		=	By.xpath("//section[1]/div[2]/table[1]/tbody[1]/tr");
	By btn_triageAlerts		=	By.cssSelector("i[class='Glyph__icon octicon octicon-alert navIcon']");
	By btn_watchlists		=	By.cssSelector("i[class='Glyph__icon octicon octicon-gear navIcon']");
	By btn_processSearch	=	By.cssSelector("i[class='Glyph__icon octicon octicon-search navIcon']");
	By btn_searchBinaries	=	By.cssSelector("i[class='Glyph__icon octicon octicon-file-binary navIcon']");
	By btn_investigations	=	By.cssSelector("i[class='Glyph__icon octicon octicon-tag navIcon']");
	By btn_sensors			=	By.cssSelector("i[class='Glyph__icon octicon octicon-device-desktop navIcon']");
	By tbl_searchStatistics	=	By.cssSelector("div[class='search-statistic row']");
	By tbl_result			=	By.xpath("//div[@class='searchResults']//div[@class='table-and-pagination']");
	By tbl_searchbin		=	By.cssSelector("#search-binaries-rows");
	By img_graph			=	By.cssSelector("canvas[class='flot-overlay']");
	By tbl_sensorList		=	By.cssSelector("div[class='sensors-list']");


	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn


	public void TM_GSID_S01_Web_User_authentication_via_SSO(){
		loginWithSSO();
		WebElement Title_Msg = createWebElementBy(msg_title);
		System.out.println("The Title displayed on the screen is : "+Title_Msg.getText());
		Assert.assertEquals(Title_Msg.getText(), "Cluster Management");
	}

	public void TM_GSID_S02_Web_ClusterRegions_verification() {
		loginWithSSO();
		List<String> expectedConnectionStatus = new ArrayList<String>();
		List<String> expectedConditionStatus = new ArrayList<String>();

		List<String> allClusters = new ArrayList<String>();
		List<String> connectionStatus = new ArrayList<String>();
		List<String> conditionStatus = new ArrayList<String>();

		//To get the Number of Rows in the Clusters displayed on screen
		List<WebElement> allRows = createWebElementsBy(tbl_clusterTable);
		int numberOfRows = allRows.size();
		System.out.println("The Number of rows are :: "+numberOfRows);

		//creating expected connection and condition string for the number of rows
		for(int i = 1;i<=numberOfRows;i++) {
			String result = "Connected";
			String result1 = "Operational";
			expectedConnectionStatus.add(result);
			expectedConditionStatus.add(result1);
		}

		//Getting actual values of cluster status from the rows
		for(int i=1;i<=numberOfRows;i++) {

			String clusterName = driver.findElement(By.xpath("//table[1]/tbody[1]/tr["+i+"]/td[1]/div[1]/div[1]/p[1]")).getText();
			allClusters.add(clusterName);
			String condition = driver.findElement(By.xpath("//table[1]/tbody[1]/tr["+i+"]/td[1]/div[1]/div[1]/p[2]")).getText();
			conditionStatus.add(condition);
			String connection = driver.findElement(By.xpath("//table[1]/tbody[1]/tr["+i+"]/td[1]/div[1]/div[2]/p[2]")).getText();
			connectionStatus.add(connection);

			System.out.println(clusterName +"   "+ condition +"   "+ connection);
		}

		Assert.assertEquals(connectionStatus, expectedConnectionStatus);
		Assert.assertEquals(conditionStatus, expectedConditionStatus);

	}

	public void TM_GSID_S03_Web_User_authentication_via_SSO(){

		loginWithSSO();	
		Assert.assertEquals(driver.getTitle(), "HUD - Cb Response");
	}

	public void TM_GSID_S04_Web_Triage_Alerts_Validate() {

		loginWithSSO();
		WebElement Triage_Btn = createWebElementBy(btn_triageAlerts);
		Triage_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg.getText(), "Triage Alerts");
		WebElement SearchStatistics_Tbl = createWebElementBy(tbl_searchStatistics);
		Assert.assertTrue(SearchStatistics_Tbl.isDisplayed(), "The Search Statistics table was not displayed");

	}

	public void TM_GSID_S05_Web_Watchlists_Validate() {

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

	public void TM_GSID_S06_Web_Search_Binaries_Process_Search_Validate() {

		loginWithSSO();
		WebElement ProcessSearch_Btn = createWebElementBy(btn_processSearch);
		ProcessSearch_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg.getText(), "Process Search");
		takeScreenshotAtEndOfTest();
		WebElement SearchBinaries_Btn = createWebElementBy(btn_searchBinaries);
		SearchBinaries_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg1 = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg1.getText(), "Search Binaries");
		takeScreenshotAtEndOfTest();
		WebElement SearchBinaries_Tbl = createWebElementBy(tbl_searchbin);
		Assert.assertTrue(SearchBinaries_Tbl.isDisplayed(), "The search binary table is not displayed");

	}

	public void TM_GSID_S07_Web_Investigations_Sensors_Validate() {

		loginWithSSO();
		WebElement Investigations_Btn = createWebElementBy(btn_investigations);
		Investigations_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg.getText(), "Investigations");
		takeScreenshotAtEndOfTest();
		WebElement Graph_Img = createWebElementBy(img_graph);
		Assert.assertTrue(Graph_Img.isDisplayed(), "The image graph was not displayed");
		WebElement Sensors_Btn = createWebElementBy(btn_sensors);
		Sensors_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg1 = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg1.getText(), "Sensors");
		takeScreenshotAtEndOfTest();
		WebElement SensorList_Tbl = createWebElementBy(tbl_sensorList);
		Assert.assertTrue(SensorList_Tbl.isDisplayed(), "The sensor table was not displayed");

	}

	public void TM_GSID_S08_Web_User_authentication_via_SSO_GSIDDevUrl(){
		loginWithSSO();	
		Assert.assertEquals(driver.getTitle(), "HUD");
	}

	public void TM_GSID_S09_Web_Tabs_verification_DevURL(){
		loginWithSSO();
		devTabs_verify();
	}

	/******************************* Methods ***************************/
	public void loginWithSSO() {
		WebElement LoginWithSSo_Btn = createWebElementBy(btn_loginWithSSO);
		LoginWithSSo_Btn.click();
		waitForPageLoaded();
	}

	public void devTabs_verify() {
		WebElement Triage_Btn = createWebElementBy(btn_triageAlerts);
		Triage_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg.getText(), "Triage Alerts");
		WebElement SearchStatistics_Tbl = createWebElementBy(tbl_searchStatistics);
		Assert.assertTrue(SearchStatistics_Tbl.isDisplayed(), "The Search Statistics table was not displayed");
		WebElement Watchlists_Btn = createWebElementBy(btn_watchlists);
		Watchlists_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg3 = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg3.getText(), "Watchlists");
		scrollToBottomOfHTML();
		WebElement Result_Tbl = createWebElementBy(tbl_result);
		Assert.assertTrue(Result_Tbl.isDisplayed(), "The result table was not displayed");
		takeScreenshotAtEndOfTest();
		WebElement ProcessSearch_Btn = createWebElementBy(btn_processSearch);
		ProcessSearch_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msga = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msga.getText(), "Process Search");
		takeScreenshotAtEndOfTest();
		WebElement SearchBinaries_Btn = createWebElementBy(btn_searchBinaries);
		SearchBinaries_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg1 = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg1.getText(), "Search Binaries");
		takeScreenshotAtEndOfTest();
		WebElement SearchBinaries_Tbl = createWebElementBy(tbl_searchbin);
		Assert.assertTrue(SearchBinaries_Tbl.isDisplayed(), "The search binary table is not displayed");
		WebElement Investigations_Btn = createWebElementBy(btn_investigations);
		Investigations_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msgb = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msgb.getText(), "Investigations");
		takeScreenshotAtEndOfTest();
		WebElement Graph_Img = createWebElementBy(img_graph);
		Assert.assertTrue(Graph_Img.isDisplayed(), "The image graph was not displayed");
		WebElement Sensors_Btn = createWebElementBy(btn_sensors);
		Sensors_Btn.click();
		waitForPageLoaded();
		WebElement Title_Msg2 = createWebElementBy(msg_title);
		Assert.assertEquals(Title_Msg2.getText(), "Sensors");
		takeScreenshotAtEndOfTest();
		WebElement SensorList_Tbl = createWebElementBy(tbl_sensorList);
		Assert.assertTrue(SensorList_Tbl.isDisplayed(), "The sensor table was not displayed");
	}

}
