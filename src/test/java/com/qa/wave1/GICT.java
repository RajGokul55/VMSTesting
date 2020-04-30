package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GICT extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url_Cloudera = "https:/sjsnxappprdn21:7183/cmf/home";
	final String Url_Snypr="https://sjsnxappprdn22.na.gilead.com:8443/Snypr/";
	final String Username_Cloudera = "gilead_vms";
	final String Username_Snypr= "abhatt2";
	private String DecrptPassword;
	String EncryptPassword_Cloudera = "enti+2zt2vW91qI3fooj0Q==";
	String EncryptPassword_Snypr="FkOllRi0iO/rIlftff/AwA==";
	private String title;
	private String url;

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

	@Test(priority = 0, enabled = false)
	public void GICT_S02_Web_Verify_Service_In_ClouderManager() {
		loginCloudera();
		TM_GICT_S02_Web_Verify_Service_In_ClouderManager();
	}

	@Test(priority = 1, enabled = true)
	public void GICT_S05_Web_Verify_Synpr_Application() {
		TM_GICT_S05_Web_Verify_Synpr_Application();
	}

	
	@AfterMethod(enabled = true)
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */

	By txt_Reports= By.cssSelector("#ID_Reports>div:nth-child(1)");
	By id_Username= By.id("username");
	By id_Password= By.id("password");
	By btn_login= By.xpath("//button[@name='submit']");
	By img_cloudera=By.cssSelector(".navbar-brand >img");
	
	By inp_UsernameSnypr= By.xpath("//input[@name='j_username']");
	By inp_PasswordSnypr= By.xpath("//input[@name='j_password']");
	By btn_login1= By.xpath("//input[@type='submit']");
	
	

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void loginCloudera() {
		launchBrowser(Browser, Url_Cloudera);
		try {
			DecrptPassword = decrypt(EncryptPassword_Cloudera);
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebElement userName= createWebElementBy(id_Username);
		WebElement passWord= createWebElementBy(id_Password);
		WebElement loginbtn= createWebElementBy(btn_login);
		userName.sendKeys(Username_Cloudera);
		passWord.sendKeys(DecrptPassword);
		loginbtn.click();
	}
	public void loginSnypr() {
		launchBrowser(Browser, Url_Snypr);
		try {
			DecrptPassword = decrypt(EncryptPassword_Snypr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebElement userName1= createWebElementBy(inp_UsernameSnypr);
		userName1.sendKeys(Username_Snypr);
		WebElement passWord1= createWebElementBy(inp_PasswordSnypr);
		passWord1.sendKeys(DecrptPassword);
		WebElement loginbtn= createWebElementBy(btn_login1);
		loginbtn.click();
		
		
	}

	public void TM_GICT_S02_Web_Verify_Service_In_ClouderManager() {
		WebElement clouderaImage= createWebElementBy(img_cloudera);
		IsDisplayed_IsEnabled(clouderaImage);
		title = getTitle();
		Assert.assertEquals(title, "Home - Cloudera Manager");

	}

	public void TM_GICT_S05_Web_Verify_Synpr_Application() {
		loginSnypr();
		waitForPageLoaded();
		title= getTitle();
		Assert.assertEquals(title, "Security Command Center");

		

	}

	
	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
