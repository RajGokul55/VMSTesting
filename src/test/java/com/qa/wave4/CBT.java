package com.qa.wave4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CBT extends CBR {

	/***************************** Test Data *******************/
	
	final String Browser = "Chrome";
	final String Url = "https://sjgbasappdevn01.na.gilead.com/CommercialBT";
	final String Url_Dev = "https://sjgbasappdevn01.na.gilead.com/CommercialBT";
	final String Url_UAT = "https://sjgbasappuatn01.na.gilead.com/CommercialBT";
	final String Url_Prod = "https://sjgbasappprdn01.na.gilead.com/GBASPortal/Home/Index";
	
	
	/***************************** Test Cases *******************************/
	/*
	 * Test case ˜Test Name™ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, TCNumber: Test
	 * case number [Numeric 2-3 digits] i.e, 01, 02,.. TestCategory: Test case
	 * category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB
	 * â€¦] Title: short title of test case based on context of test case ie.,
	 * ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails. Test
	 * method name must be same as test case appended with TM example:
	 */

	@BeforeMethod
	void Setup() {
		launchBrowser(Browser, Url);
	}
	
	@Test(priority = 0, enabled = true)
	public void CBT_S01_Windows_Web_URL_Verfication() {
		title_Assertion("Commercial BT - General");
	}

	@Test(priority = 1, enabled = true) 
	public void CBT_S02_Windows_Web_Tab_Verfication() {
		TM_CBR_S02_Windows_Web_All_Lot_Tab_Verfication();
	}
	
	@Test(priority = 2, enabled = true) 
	public void CBT_S03_Windows_Web_Tab_Verfication() {
		TM_CBR_S03_Windows_Web_All_open_Lot_Verfication();
	}
	
	@AfterMethod
	void Teardouwn() {
		driver.close();
	}
}
