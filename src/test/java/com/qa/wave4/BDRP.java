package com.qa.wave4;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;


public class BDRP extends CommonMethods {

	/***************************** Test Data *******************/

	// NO NEED TO ENTER LOGIN DETAILS, BELOW USERS NEED TO LAUNCH THE URL'S, IT WILL
	// DIRECTLY OPEN THE HOME SCREEN(BDRP screen)


	final String Browser = "Chrome";

	// Test Environment URL
	final String Url = "https://bdrp.gilead.com/";


	/***************************** Test Cases *******************/
	/*
	 * Test case â€˜Test Nameâ€™ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: â€¢ AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, â€¢ TCNumber:
	 * Test case number [Numeric 2-3 digits] i.e, 01, 02,.. â€¢ TestCategory: Test
	 * case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve,
	 * DB â€¦] â€¢ Title: short title of test case based on context of test case
	 * ie., ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails.
	 * 
	 * Test method name must be same as test case appended with TM example:
	 */

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, Url);
	}

	@Test(priority = 0, enabled = true)
	public void BDRP_S01_Web_Verifyscreen()
	{ 
		TM_BDRP_S01_Web_VerifySparcScreen();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */

	By heading_Home = By.xpath("//a[contains(text(),'Home')]/span[contains(@class,'home')]");


	/***************************** Test Case Methods *******************/


	public void TM_BDRP_S01_Web_VerifySparcScreen() {

		verifyBDRPScreen();

	}

	public void verifyBDRPScreen() {
		// Main heading
		wait(2);
		WebElement Home = createWebElementBy(heading_Home);
		IsDisplayed_IsEnabled(Home);


		takeScreenshotAtEndOfTest();
	}


}

