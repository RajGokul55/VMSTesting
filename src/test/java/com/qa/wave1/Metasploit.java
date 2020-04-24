package com.qa.wave1;

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

public class Metasploit extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://fcvmmappprdn01.na.gilead.com:3790/login";
	
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

	
	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void Metasploit_S01_Web_Verify_Metasploit_Web_console() {
		TM_Metasploit_01_Web_VerifyWebConsole();
		
	}

	
	@AfterMethod(enabled=true)
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

	By field_Username= By.xpath("//input[@id='user_session_username']");
	By field_Password = By.xpath("//input[@id='user_session_password']");
	By login_button= By.xpath("//input[@name='commit']");
	
	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn


	void TM_Metasploit_01_Web_VerifyWebConsole() {

		
		WebElement UsernameFld = createWebElementBy(field_Username);
		IsDisplayed_IsEnabled(UsernameFld);
		
		WebElement PasswordFld = createWebElementBy(field_Password);
		IsDisplayed_IsEnabled(PasswordFld);
		
		WebElement LoginBtn = createWebElementBy(login_button);
		IsDisplayed_IsEnabled(LoginBtn);
			
	}

	

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here

	
}