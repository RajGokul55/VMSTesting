package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class EDTaskManagementProd extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url = "http://taskedmonton/"; //PROD 
	final String URL1 = "http://sjedtmappsupn01/plantsite/"; //PROD 
	final String Username = "VMS_AUTOMATION";
	private String DecrptPassword;
	String EncryptPassword = "P+5G7eEgf41Aei1xxBoi4QO+HS35SFKWnQLTASkufNE=";
	private String text;
	
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


	/* PROD & DEV */
	@Test(priority = 0, enabled = true)
	public void EDTaskManagement_S01_Web_Check_Login() {
		TM_EDTaskManagement_S01_Web_Check_Login();
	}

	@Test(priority = 2, enabled = true)
	public void EDTaskManagement_S02_Web_Check_Prod_Link_Page_Loaded() {
		TM_EDTaskManagement_S02_Web_Check_Prod_Link_Page_Loaded();
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

	By ipt_Username = By.xpath("//input[@id='login-form-username']");
	By ipt_Passwrod = By.xpath("//input[@id='login-form-password']");
	By btn_Login = By.xpath("//input[@id='login']");
	By txt_Assigned = By.xpath("//h3[@id='gadget-10002-title']");
	By txt_Dashboards = By.xpath("//a[@id='home_link']");
	By txt_Projects = By.xpath("//a[@id='browse_link']");
	By txt_Issues = By.xpath("//a[@id='find_link']");
	By txt_Boards = By.xpath("//a[@id='greenhopper_menu']");
	By txt_Structure = By.xpath("//a[@id='wi-structure-link']");
	By txt_Charts = By.xpath("//a[@id='xchart-web-item']");
	By txt_Create = By.xpath("//a[@id='create_shortcuts']");
	By img_Logo = By.xpath("//img[@class='d-block img-fluid']");
	By txt_QCNotificationPage = By.xpath("//h4[@class='navbar-text text-white mr-auto']");

		
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	public void loginEDTaskManagement() {
		try {
			DecrptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
			WebElement Username_Ipt = createWebElementBy(ipt_Username);
			Username_Ipt.sendKeys(Username);

			WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
			Password_Ipt.sendKeys(DecrptPassword);

			WebElement Login_Btn = createWebElementBy(btn_Login);
			Login_Btn.click();

	}

	public void TM_EDTaskManagement_S01_Web_Check_Login() {

			launchBrowser(Browser, Url);
			loginEDTaskManagement();
			
			waitForPageLoaded();
						
			WebElement Assigned_Txt = createWebElementBy(txt_Assigned);
			text = Assigned_Txt.getText();
			Assert.assertTrue(text.contains("Assigned to Me"));
			
			takeScreenshotAtEndOfTest();
			
	}
		
			 
	public void TM_EDTaskManagement_S02_Web_Check_Prod_Link_Page_Loaded() {

		launchBrowser(Browser, URL1);
		waitForPageLoaded();
		
		WebElement Logo_Img = createWebElementBy(img_Logo);
		IsDisplayed_IsEnabled(Logo_Img);
		
		WebElement QCNotificationPage_Txt = createWebElementBy(txt_QCNotificationPage);
		text = QCNotificationPage_Txt.getText();
		Assert.assertTrue(text.contains("QC Notification Page"));
		
		takeScreenshotAtEndOfTest();

	}
	
	
	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
