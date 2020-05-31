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

public class Axway extends CommonMethods {

	/***************************** Test Data *******************/
	//  To launch app in Chrome browser Flash player is required. So launching in IE Browser 
	// This app is not related to HTML tag, its based upon Flash player so not able to capture elements. Just launching the URL & taking the screenshot.
	
	final String Browser = "IE";
	// Application name Axway  Env is POC
	final String Url = "https://sjawxappdevg01:8443/trackntraceserver/";
	
	// Application name Axway  Env is SQA
	final String Url1 = "https://fcaxwappsqan01.na.gilead.com:8443/trackntraceserver/";
	
	// Application name Axway  Env is UAT
	final String Url2 = "https://fcaxwappuatn01.na.gilead.com:8443/trackntraceserver/";
	
	// Application name Axway  Env is VAL
	final String Url3 = "https://val.tnt.gilead.com:8443/trackntraceserver";
	
	// Application name Axway  Env is PROD
	final String Url4 = "https://tnt.gilead.com:8443/trackntraceserver";

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
		launchBrowser(Browser, Url1);
	}

	@Test(priority = 0, enabled = true)
	public void Axway_S01_Web_Verify_LogInScreen() {
		TM_Axway_01_Verify_LogInScreen();

	}

	@AfterMethod(enabled = true)
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// This app is not related to HTML tag, its based upon Flash player so not able to capture elements. Just launching the URL & taking the screenshot.
	
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	void TM_Axway_01_Verify_LogInScreen() {

		//WebElement linkContinue = createWebElementBy(continue_btn);
		//linkContinue.click();
		//waitForPageLoaded();
		wait(2);
		takeScreenshotAtEndOfTest();

	}

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
