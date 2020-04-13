package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

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

	@BeforeTest
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void Metasploit_TC01_Web_Verify_Metasploit_Web_console() {
		TM_Metasploit_01_Web_VerifyWebConsole();
		
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

	By field_Username= By.xpath("//input[@id='user_session_username']");
	By field_Password = By.xpath("//input[@id='user_session_password']");
	By login_button= By.xpath("//input[@name='commit']");
	
	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn


	void TM_Metasploit_01_Web_VerifyWebConsole() {

		TM_Metasploit_ApllicationCommonFlow();
	}

	public  boolean isElementExit(By locator) {
		/* 
		 * Author: Balajee Palle
		 * Description: To create web Element by passing locator.
		 * Parameter: Xpath or Css Syntax example: 
		 * Date: April 2020 
		 * 
		 */
		
		try
		{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		boolean element =  driver.findElement(locator).isDisplayed();
		System.out.println(element);
		return true;
	}
		catch (NoSuchElementException ex)
		{
			return false;
		}
	}

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here

	void TM_Metasploit_ApllicationCommonFlow() {

		boolean Username_Field = isElementExit(field_Username);
		System.out.println("Username field is displayed = " +Username_Field);
		
		boolean Password_Field = isElementExit(field_Password);
		System.out.println("Password field is displayed = " +Password_Field);
		
		boolean Login_btn = isElementExit(login_button);
		System.out.println("loginBtn field is displayed = " +Login_btn);
				
	}
}