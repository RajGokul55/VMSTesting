package com.qa.kite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import junit.framework.Assert;

public class EMSBMS04 extends CommonMethods {
	/***************************** Test Data *******************/
	final String Browser = "IE";
	final String PrdURL = "http://10.110.30.68/";
	final String PrdURL1 = "http://10.110.31.212/";

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


	@Test(priority=1, enabled=true)
	public void BMS_S01_Web_Validate_BMS_TCManager() {
		TM_S01_Web_Validate_BMS_TCManager();
	}
	
	@Test(priority=2, enabled=true)
	public void BMS_S02_Web_Validate_BMS_TCManager() {
		TM_S02_Web_Validate_BMS_TCManager();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	/************************************ Test Cases *******************************************/
	
	public void TM_S01_Web_Validate_BMS_TCManager() {
		launchBrowser(Browser, PrdURL);
		wait(20);
		Assert.assertEquals("TC Manager - KITE", driver.getTitle());
	}
	
	public void TM_S02_Web_Validate_BMS_TCManager() {
		launchBrowser(Browser, PrdURL1);
		wait(20);
		Assert.assertEquals("TC Manager - SEGROPAA", driver.getTitle());
	}
}
