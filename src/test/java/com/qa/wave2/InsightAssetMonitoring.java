package com.qa.wave2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class InsightAssetMonitoring extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url = "https://gilead-fc.thermoscientificinsight.com/signin"; //PROD
	final String Username = "sakshi.gupta27@gilead.com";
	String text ="";
	private String DecrptPassword;
	String EncryptPassword = "tYAZwEkYPz68EUeic62TFw==";
	private String url;

	/***************************** Test Cases *******************/

	/*
	 * Test case ‘Test Name’ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: • AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, • TCNumber:
	 * Test case number [Numeric 2-3 digits] i.e, 01, 02,.. • TestCategory: Test
	 * case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve,
	 * DB …] • Title: short title of test case based on context of test case ie.,
	 * ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails.
	 * 
	 * Test method name must be same as test case appended with TM example:
	 */

	@BeforeMethod(enabled = true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
		loginInsightAssetMonitoring();

	}

	@Test(priority = 0, enabled = true)
	public void InsightAssetMonitoring_S01_Web_Login_Verification() {
		TM_InsightAssetMonitoring_S01_Web_Login_Verification();
	}

	@Test(priority = 1, enabled = true)
	public void InsightAssetMonitoring_S02_Web_Links_Verification() {
		TM_InsightAssetMonitoring_S02_Web_Links_Verification();
	}

	@Test(priority = 2, enabled = true)
	public void InsightAssetMonitoring_S03_Web_AssetsTab_Verification() {
		TM_InsightAssetMonitoring_S03_Web_AssetsTab_Verification();
	}
	
	@Test(priority = 3, enabled = true)
	public void InsightAssetMonitoring_S04_Web_AnalyticsTab_Verification() {
		TM_InsightAssetMonitoring_S04_Web_AnalyticsTab_Verification();
	}
	
	@AfterMethod(enabled = true)
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */

	By ipt_Username = By.xpath("//input[@id='username']");
	By ipt_Passwrod = By.xpath("//input[@id='password']");
	By btn_SignIn = By.xpath("//input[@class='btn']");
	By img_InsightAssetMonitoringLogo = By.xpath("//a[@class='logo']//img");
	By txt_Help = By.linkText("Help");
	By lnk_Assets = By.linkText("Assets");
	By lnk_FloorPlans = By.linkText("Floor Plans");
	By img_Globe = By.xpath("//i[@class='icon icon-globe']");
	By lnk_Analytics = By.linkText("Analytics");
	By lnk_Motes = By.linkText("Motes");
	By lnk_More = By.linkText("More");
	By tab_Issues = By.linkText("Issues");
	By tab_Alarms = By.linkText("Alarms");
	By tab_Repairs = By.linkText("Repairs");
	By tab_Replacements = By.linkText("Replacements");
	By tab_Trends = By.linkText("Trends");
	By tab_EnergyUsage = By.linkText("Energy Usage");
	By tab_StudyGroups = By.linkText("Study Groups");
	
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void loginInsightAssetMonitoring() {
		try {
			DecrptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
			WebElement Username_Ipt = createWebElementBy(ipt_Username);
			Username_Ipt.sendKeys(Username);

			WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
			Password_Ipt.sendKeys(DecrptPassword);

			WebElement SignIn_Btn = createWebElementBy(btn_SignIn);
			SignIn_Btn.click();


	}

	public void TM_InsightAssetMonitoring_S01_Web_Login_Verification() {

		WebElement InsightAssetMonitoringLogo = createWebElementBy(img_InsightAssetMonitoringLogo);
		IsDisplayed_IsEnabled(InsightAssetMonitoringLogo);
		
		WebElement Help_Txt = createWebElementBy(txt_Help);
		text = Help_Txt.getText();
		Assert.assertTrue(text.contains("Help"));
		
		takeScreenshotAtEndOfTest();

	}

	public void TM_InsightAssetMonitoring_S02_Web_Links_Verification() {

		WebElement FloorPlans_Lnk = createWebElementBy(lnk_FloorPlans);
		FloorPlans_Lnk.click();
		waitForPageLoaded();
		
		WebElement Globe_Img = createWebElementBy(img_Globe);
		IsDisplayed_IsEnabled(Globe_Img);
		takeScreenshotAtEndOfTest();
		
		WebElement Analytics_Lnk = createWebElementBy(lnk_Analytics);
		Analytics_Lnk.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("analytics/trends"));
		takeScreenshotAtEndOfTest();

		WebElement Motes_Lnk = createWebElementBy(lnk_Motes);
		Motes_Lnk.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("motes"));
		takeScreenshotAtEndOfTest();

		WebElement More_Lnk = createWebElementBy(lnk_More);
		More_Lnk.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("more/users"));
		takeScreenshotAtEndOfTest();

	}

	public void TM_InsightAssetMonitoring_S03_Web_AssetsTab_Verification() {

		WebElement Assets_Lnk = createWebElementBy(lnk_Assets);
		Assets_Lnk.click();
		
		WebElement Issues_Tab = createWebElementBy(tab_Issues);
		Issues_Tab.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("issues"));
		takeScreenshotAtEndOfTest();
		
		WebElement Alarms_Tab = createWebElementBy(tab_Alarms);
		Alarms_Tab.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("alarms"));
		takeScreenshotAtEndOfTest();
		
		WebElement Repairs_Tab = createWebElementBy(tab_Repairs);
		Repairs_Tab.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("repairs"));
		takeScreenshotAtEndOfTest();
		
		WebElement Replacements_Tab = createWebElementBy(tab_Replacements);
		Replacements_Tab.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("replacements"));
		takeScreenshotAtEndOfTest();

	}
	
	public void TM_InsightAssetMonitoring_S04_Web_AnalyticsTab_Verification() {

		WebElement Analytics_Lnk = createWebElementBy(lnk_Analytics);
		Analytics_Lnk.click();
		
		WebElement Trends_Tab = createWebElementBy(tab_Trends);
		Trends_Tab.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("trends"));
		takeScreenshotAtEndOfTest();
		
		WebElement EnergyUsage_Tab = createWebElementBy(tab_EnergyUsage);
		EnergyUsage_Tab.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("energy"));
		takeScreenshotAtEndOfTest();
		
		WebElement StudyGroups_Tab = createWebElementBy(tab_StudyGroups);
		StudyGroups_Tab.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("study_groups"));
		takeScreenshotAtEndOfTest();
		
	}

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
