package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OCI extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url = "https://fcocinappprdn01/";

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
	public void OCI_S01_Web_Verify_LogInScreen() {
		TM_OCI_01_Verify_LogInScreen();

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

	By logo = By.xpath("//h3[contains(text(),'OnCommand Insight')]");
	By field_Username = By.xpath("//*[@id='username']");
	By field_Password = By.xpath("//*[@id='password']");
	By login_button = By.xpath("//*[@id='login-submit']");

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	void TM_OCI_01_Verify_LogInScreen() {

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
