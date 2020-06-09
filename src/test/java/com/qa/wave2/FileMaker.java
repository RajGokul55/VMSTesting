package com.qa.wave2;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import org.testng.annotations.BeforeMethod;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class FileMaker extends CommonMethods {
	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String PrdURL = "http://lvfmkappprdn01.na.gilead.com/fmi/xml/FMPXMLRESULT.xml?-dbnames";

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


	String URL = PrdURL;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
	}
	
	@Test(priority=1, enabled=true)
	public void FMP_S01_Web_Validate_Error_Code() {
		TM_S01_Web_Validate_Error_Code();
	}
	
	@Test(priority=2, enabled=true)
	public void FMP_S02_Web_Validate_Data() {
		TM_S02_Web_Validate_Data();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
  	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 * txt_: Text
	 * crd_: Card
	 */
	
	By txt_errorcode 		=	By.cssSelector("div.pretty-print>div>div>div.collapsible-content>div>span.text");
	By txt_data				=	By.cssSelector("div.pretty-print>div>div>div>div.collapsible#collapsible2>div.expanded>div>div>div>div>div.collapsible>div>div.collapsible-content>div>span.text");
	

	
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	public void TM_S01_Web_Validate_Error_Code() {
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		WebElement ErrorCode_Txt = createWebElementBy(txt_errorcode);
		String ErrorCode = ErrorCode_Txt.getText();
		if (ErrorCode.equalsIgnoreCase("0")) {
			System.out.println("Success");
		}else {
			Assert.fail("The error code is other than 0");
		}
		
	}
	public void TM_S02_Web_Validate_Data() {
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		WebElement Data_Txt = createWebElementBy(txt_data);
		String Data = Data_Txt.getText();
		if(Data.equalsIgnoreCase("Technical_Services_Database")){
			System.out.println("Success");
		}else {
			Assert.fail("The error code is other than 0");
		}
	}
	
}