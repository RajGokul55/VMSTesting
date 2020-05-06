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

public class GSSN extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	// URL for GSSN PROD 1 :
	final String Url = "https://sjiiqappdevn01/login";
	// URL for GSSN PROD 2 :
	final String Url1 = "http://sjgssnappprdn02/";
	// URL for GSSN PROD 3 :
	final String Url2 = "https://sjgssnappprdn01.na.gilead.com:9443/";

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
	public void GSSN_S01_Verify_LogIn() {
		TM_GSSN_S01_LogIn();
	}

	@Test(priority = 1, enabled = true)
	public void GSSN_S02_Verify_LogIn() {
		TM_GSSN_S02_LogIn();
	}

	@Test(priority = 2, enabled = true)
	public void GSSN_S03_Verify_LogIn() {
		TM_GSSN_S03_LogIn();

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

	// PROD 1:
	By logo = By.xpath("//*[contains(text(),'Welcome to InsightIQ. Please log in.')]");
	By field_Username = By.xpath("//input[@id='username']");
	By field_Password = By.xpath("//input[@id='password']");
	By login_button = By.xpath("//input[@id='authform']");
	// PROD 2:
	By logo2 = By.xpath("//*[@id='loginPanel']/div[1]/div");
	By field_Username2 = By.xpath("//input[@id='username']");
	By field_Password2 = By.xpath("//input[@id='password']");
	By login_button2 = By.xpath("//*[@id='LoginScreen.login_button']");
	// PROD 3:
	By logo3 = By.xpath("//img[@class='emc-logo']");
	By field_Domain = By.xpath("//*[contains(text(),'Domain:')]");
	By field_Username3 = By.xpath("//input[@id='user']");
	By field_Password3 = By.xpath("//input[@id='password']");
	By login_button3 = By.xpath("//a[@id='login']");
	By login_button4 = By.xpath("//*[@id='login_btn']");

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_GSSN_S01_LogIn() {

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

	public void TM_GSSN_S02_LogIn() {

		launchBrowser(Browser, Url1);

		wait(2);
		WebElement Logo = createWebElementBy(logo2);
		IsDisplayed_IsEnabled(Logo);

		WebElement UsernameFld = createWebElementBy(field_Username2);
		IsDisplayed_IsEnabled(UsernameFld);

		WebElement PasswordFld = createWebElementBy(field_Password2);
		IsDisplayed_IsEnabled(PasswordFld);

		WebElement LoginBtn = createWebElementBy(login_button2);
		IsDisplayed_IsEnabled(LoginBtn);
		takeScreenshotAtEndOfTest();
		
	}

	public void TM_GSSN_S03_LogIn() {

		launchBrowser(Browser, Url2);

		wait(2);
		WebElement Logo = createWebElementBy(logo3);
		IsDisplayed_IsEnabled(Logo);
		
		WebElement Login1 = createWebElementBy(login_button3);
		Login1.click();
		
		WebElement Logo1 = createWebElementBy(logo3);
		IsDisplayed_IsEnabled(Logo1);
		
		WebElement Domain = createWebElementBy(field_Domain);
		IsDisplayed_IsEnabled(Domain);

		WebElement UsernameFld = createWebElementBy(field_Username3);
		IsDisplayed_IsEnabled(UsernameFld);

		WebElement PasswordFld = createWebElementBy(field_Password3);
		IsDisplayed_IsEnabled(PasswordFld);

		WebElement LoginBtn = createWebElementBy(login_button4);
		IsDisplayed_IsEnabled(LoginBtn);
		takeScreenshotAtEndOfTest();
		
	}

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
