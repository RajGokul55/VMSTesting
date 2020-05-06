package com.qa.wave2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class OCUM extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	// URL for OCUM GxP1 :
	final String Url = "https://sjgcsnappprdg01/";
	// URL1 for OCUM GxP2 :
	final String Url1 = "https://sjgcsnappprdg02/#/";
	// URL for OCUM Non-GxP :
	final String Url2 = "https://sjgcsnappprdn01/";

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
	}

	@Test(priority = 0, enabled = true)
	public void OCUM_S01_Verify_GxP1_LogIn() {
		TM_OCUM_S01_Verify_GxP1_LogIn();
	}

	@Test(priority = 1, enabled = true)
	public void OCUM_S02_Verify_GxP2_LogIn() {
		TM_OCUM_S02_Verify_GxP2_LogIn();
	}

	@Test(priority = 2, enabled = true)
	public void OCUM_S02_Verify_NonGxP_LogIn() {
		TM_OCUM_S03_Verify_NonGxP_LogIn();

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

	// GXP 1:
	By logo = By.xpath("//*[@class='nwf-login-banner-logo']");
	By field_Username = By.xpath("//input[@placeholder='Username']");
	By field_Password = By.xpath("//input[@placeholder='Password']");
	By login_button = By.xpath("//*[@id='nwf-login-form']/button");

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_OCUM_S01_Verify_GxP1_LogIn() {

		wait(2);
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

	public void TM_OCUM_S02_Verify_GxP2_LogIn() {

		launchBrowser(Browser, Url1);

		wait(2);
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

	public void TM_OCUM_S03_Verify_NonGxP_LogIn() {

		launchBrowser(Browser, Url2);

		wait(2);
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
