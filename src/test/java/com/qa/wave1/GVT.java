package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class GVT extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sb-gilead-it.veevavault.com";
	final String Username ="psonawane";

	/***************************** Test Cases *******************/
	/*
	 * Test case ‘Test Name’ naming convention: <AppName><TCNumber>_<TestCategory>_<Title>
	Definitions of terms:     
•	AppName: short name of Application [String 5 -10 chars] i.e., TstMyApp, 
•	TCNumber: Test case number [Numeric 2-3 digits] i.e, 01, 02,..
•	TestCategory: Test case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB …]
•	Title: short title of test case based on context of test case  ie., ValidateCredntails
  	Test Name Example: Filkart_05_Web_ValidateCredntails.

	 * Test method name must be same as test case appended with TM example: 
	 */

	@BeforeTest
	public void beforeTest() {
		launchbrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void GVT_01_Web_ValidateSpotfireServer() {
		TM_GVT_01_Web_ValidateSpotfireServer();
	}

	@Test(priority=1, enabled=true)
	public void GVT_02_Web_ValidateReportAccessiblity() {
		TM_GVT_02_Web_ValidateReportAccessiblity();
	}
	
	@Test(priority=1, enabled=true)
	public void GVT_03_Web_ValidateTERRServer() {
		TM_GVT_03_Web_ValidateTERRServer();
	}
	
	@Test(priority=1, enabled=true)
	public void GVT_04_Web_ValidityStatisticServer() {
		TM_GVT_04_Web_ValidityStatisticServer();
	}

	@AfterTest
	public void afterTest() {
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
	 */

	By ipt_Username= By.name("j_username");
	By btn_Continue = By.name("continue");
	By menu_Library= By.name("libraries__c");
	By menu_Documents = By.className("children");
	By menu_AllDocuments = By.className("facetGroupLabel");
	By menu_ViewAll = By.className("viewAllCategories vv_view_all");

	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn

	void TM_GVT_01_Web_ValidateSpotfireServer() {

	}

	void TM_GVT_02_Web_ValidateReportAccessiblity() {

	}
	
	void TM_GVT_03_Web_ValidateTERRServer() {

	}

	void TM_GVT_04_Web_ValidityStatisticServer() {

	}


	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here
}
