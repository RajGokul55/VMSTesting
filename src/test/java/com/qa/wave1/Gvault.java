package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class Gvault extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sb-gilead-it.veevavault.com";
	final String Username ="psonawane@gvault.gilead.com";

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
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void Gvault_01_Web_ValidateDescribanciesCreation() {
		TM_Gvault_03_Web_ValidateDescribanciesCreation();
	}

	@Test(priority=1, enabled=true)
	public void Gvault_04_Web_ValidateDescribanciesEdit() {
		TM_Gvault_04_Web_ValidateDescribanciesEdit();
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


	void TM_Gvault_03_Web_ValidateDescribanciesCreation() {

		TM_Gvault_ApllicationCommonFlow();
	}

	void TM_Gvault_04_Web_ValidateDescribanciesEdit() {

		TM_Gvault_ApllicationCommonFlow();
	}


	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here

	void TM_Gvault_ApllicationCommonFlow() {

		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Continue_Btn = createWebElementBy(btn_Continue);
		Continue_Btn.click();

		WebElement Library_menu = createWebElementBy(menu_Library);
		Library_menu.click();

		WebElement Documents_menu = createWebElementBy(menu_Documents);
		Documents_menu.click();

		WebElement AllDocuments_menu = createWebElementBy(menu_AllDocuments);
		AllDocuments_menu.click();
	}
}
