package com.qa.kite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class SecretServer extends CommonMethods {
	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String PrdURL = "https://itadmins.kite.local/SecretServer/Login.aspx?ReturnUrl=%2fSecretServer%2f.";

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
	public void PB_S01_Web_Validate_Login_Page() {
		TM_S01_Web_Validate_Login_Page();
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
	
	By img_logo 			=	By.xpath("//div[@class='logoImage']");
	By ipt_username			=	By.id("LoginUserControl1_UserNameTextBox");
	By ipt_password			=	By.id("LoginUserControl1_PasswordTextBox");
	By btn_login			=	By.id("LoginUserControl1_LoginButton");
	
	

	
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	public void TM_S01_Web_Validate_Login_Page() {
		WebElement Logo_Img = createWebElementBy(img_logo);
		IsDisplayed_IsEnabled(Logo_Img);
		
		WebElement Username_Ipt = createWebElementBy(ipt_username);
		IsDisplayed_IsEnabled(Username_Ipt);
		
		WebElement Password_Ipt = createWebElementBy(ipt_password);
		IsDisplayed_IsEnabled(Password_Ipt);
		
		WebElement Login_Btn = createWebElementBy(btn_login);
		IsDisplayed_IsEnabled(Login_Btn);
		
		Assert.assertEquals(driver.getTitle(), "Thycotic Secret Server");
	}
}
