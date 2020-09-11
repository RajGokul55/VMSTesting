package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WFA extends CommonMethods {

	/***************************** Test Data *******************/
	// To launch app in Chrome browser Flash player is required. So launching in IE Browser
	// This app is not related to HTML tag, its based upon Flash player so not able to capture elements. Just launching the URL & taking the screenshot.
	
	final String Browser = "IE";
	final String Browser1 = "Chrome";
	// Application name WFA - Work Flow Automation Env is Prod
	final String Url = "https://gwas/";
	
	// Application name WFA - Work Flow Automation Env is Dev
		final String Url1 = "https://sjgcsnwfaprdn04/#/login";

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
		//launchBrowser(Browser, Url1);
	}

	//Only for Prod URL Run with Prod URL = Url
	@Test(priority = 0, enabled = true)
	public void WFA_S01_Web_Verify_LogInScreen() {
		launchBrowser(Browser, Url);
		TM_WFA_01_Verify_LogInScreen();

	}
	
	//Only for Dev URL Run with Dev URL = Url1
	@Test(priority = 0, enabled = true)
	public void WFA_S02_Web_Verify_LogInScreen() {
		launchBrowser(Browser1, Url1);
		TM_WFA_02_Verify_LogInScreen();

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
	By continue_btn = By.xpath("//*[@id='overridelink']");
	By logo = By.xpath("//h2[@class='nwf-login-dialog-title-primary']");
	By field_Username = By.xpath("//input[@placeholder='Username']");
	By field_Password = By.xpath("//input[@placeholder='Password']");
	By login_button = By.xpath("//div[contains(text(),'Sign In')]");

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	//For Prod URL
	void TM_WFA_01_Verify_LogInScreen() {

		WebElement linkContinue = createWebElementBy(continue_btn);
		linkContinue.click();
		waitForPageLoaded();
		wait(2);
		takeScreenshotAtEndOfTest();

	}
	// For Dev URL
	void TM_WFA_02_Verify_LogInScreen() {

		//WebElement linkContinue1 = createWebElementBy(continue_btn);
		//linkContinue1.click();
		waitForPageLoaded();
		wait(10);
		WebElement Logo = createWebElementBy(logo);
		IsDisplayed_IsEnabled(Logo);

		WebElement UsernameFld = createWebElementBy(field_Username);
		IsDisplayed_IsEnabled(UsernameFld);

		WebElement PasswordFld = createWebElementBy(field_Password);
		IsDisplayed_IsEnabled(PasswordFld);

		WebElement LoginBtn = createWebElementBy(login_button);
		IsDisplayed_IsEnabled(LoginBtn);
		takeScreenshotAtEndOfTest();

	}

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
