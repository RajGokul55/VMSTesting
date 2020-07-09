package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class GILDA2 extends CommonMethods {

	/***************************** Test Data *******************/

	// NO NEED TO ENTER LOGIN DETAILS, BELOW USERS NEED TO LAUNCH THE URL'S, IT WILL
	// DIRECTLY OPEN THE HOME SCREEN
	// Arun Raj – araj5, Jayshri Raykar -Jraykar, Balajee Palle - Bpalle

	final String Browser = "Chrome";

	// EPR Test Environment URL
	final String Url = "http://erptest.gilda.gilead.com/eclinical_sso/";

	// Training Environment URL
	final String Url1 = "http://train.gilda.gilead.com/eclinical_sso/";

	// UAT Environment URL
	final String Url2 = "http://uat.gilda.gilead.com/eclinical_sso/";

	// Dev Environment URL
	final String Url3 = "http://dev.gilda.gilead.com/eclinical_sso/";

	// Val Environment URL
	final String Url4 = "http://val.gilda.gilead.com/eclinical_sso/";

	// Prod Environment URL
	final String Url5 = "https://gilda.gilead.com/eclinical_sso/";

	final String username = "arun.raj5";
	String EncryptPassword = "cHhqigjkE9lagBcklOFbJw==";
	private String DecrptPassword;

	/***************************** Test Cases *******************/
	/*
	 * Test case â€˜Test Nameâ€™ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: â€¢ AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, â€¢ TCNumber:
	 * Test case number [Numeric 2-3 digits] i.e, 01, 02,.. â€¢ TestCategory: Test
	 * case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve,
	 * DB â€¦] â€¢ Title: short title of test case based on context of test case
	 * ie., ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails.
	 * 
	 * Test method name must be same as test case appended with TM example:
	 */

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, Url1);
	}

	/*
	 * @Test(priority = 0, enabled = true) public void
	 * GILDA2_S01_Web_Verify_LogInScreen() { TM_GILDA2_01_Verify_LogInScreen();
	 * 
	 * }
	 */
	
	  @Test(priority = 0, enabled = true)
	  public void GILDA2_S01_Web_Verifyscreen()
	  { 
		  TM_GILDA2_S01_Web_VerifyGILDAScreen();
	  
	  }
	 
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */
	By logo = By.xpath("//div[@id='loginLogo']");
	By field_Username = By.xpath("//*[@name='SWEUserName']");
	By field_Password = By.xpath("//*[@name='SWEPassword']");
	By login_button = By.xpath("//*[@class='siebui-login-btn']");
	By server_Name = By.xpath("//*[@class='siebui-login-title']");
	
	By heading_Logo = By.xpath("//div[@class='siebui-logo']");
	By btn_Home = By.xpath("//*[@class='ui-tabs-anchor']/span[contains(@class, 'home_icon')]");
	By txt_Home = By.xpath("//div[contains(@class, 'Welcome')]");
	By btn_Contacts = By.xpath("//*[@class='ui-tabs-anchor']/span[contains(@class, 'contacts')]");
	By txt_Contacts = By.xpath("//*[@id='s_sctrl_tabView']/ul/li[1]//*[@class='ui-tabs-anchor']");
	By btn_Accounts = By.xpath("//*[@class='ui-tabs-anchor']/span[contains(@class, 'accounts')]");
	By txt_Accounts = By.xpath("//*[@id='s_sctrl_tabView']/ul/li[1]//*[@class='ui-tabs-anchor']");
	By btn_Activities = By.xpath("//*[@class='ui-tabs-anchor']/span[contains(@class, 'activities')]");
	By txt_Activities = By.xpath("//*[@id='s_sctrl_tabView']/ul/li[1]//*[@class='ui-tabs-anchor']");
	By btn_Proposals = By.xpath("//*[@class='ui-tabs-anchor']/span[@class = 'siebui-icon-screentab_icon']");
	By btn_Proposals1 = By.xpath("//*[@class='ui-tabs-anchor']/span[contains(@class, 'home_icon')]");
	By txt_Proposals = By.xpath("//*[@id='s_sctrl_tabView']/ul/li[1]//*[@class='ui-tabs-anchor']");
	By btn_Protocols = By.xpath("//*[@class='ui-tabs-anchor']/span[contains(@class, 'home_icon')]");
	By txt_Protocols = By.xpath("//*[@id='s_sctrl_tabView']");
	By btn_SiteManagement = By.xpath("//*[@class='ui-tabs-anchor']/span[contains(@class, 'home_icon')]");
	By txt_SiteManagement = By.xpath("//*[@id='s_sctrl_tabView']/ul/li[1]//*[@class='ui-tabs-anchor']");
	By btn_DrugLots = By.xpath("//*[@class='ui-tabs-anchor']/span[contains(@class, 'home_icon')]");
	By txt_DrugLots = By.xpath("//*[@id='s_sctrl_tabView']/ul/li[1]//*[@class='ui-tabs-anchor']");

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	/*
	 * public void TM_GILDA2_01_Verify_LogInScreen() {
	 * 
	 * wait(2); WebElement Logo = createWebElementBy(logo);
	 * IsDisplayed_IsEnabled(Logo);
	 * 
	 * WebElement UsernameFld = createWebElementBy(field_Username);
	 * IsDisplayed_IsEnabled(UsernameFld);
	 * 
	 * WebElement PasswordFld = createWebElementBy(field_Password);
	 * IsDisplayed_IsEnabled(PasswordFld);
	 * 
	 * WebElement LoginBtn = createWebElementBy(login_button);
	 * IsDisplayed_IsEnabled(LoginBtn);
	 * 
	 * WebElement ServerName = createWebElementBy(server_Name);
	 * IsDisplayed_IsEnabled(ServerName); takeScreenshotAtEndOfTest();
	 * 
	 * }
	 */

	
	
	
	public void TM_GILDA2_S01_Web_VerifyGILDAScreen() {

		verifyHomeScreen();
		
	}

	public void verifyHomeScreen() {
		// Main heading
		WebElement MainLogo = createWebElementBy(heading_Logo);
		IsDisplayed_IsEnabled(MainLogo);
		
		WebElement Home = createWebElementBy(btn_Home);
		IsDisplayed_IsEnabled(Home);
		
		WebElement Contacts = createWebElementBy(btn_Contacts);
		IsDisplayed_IsEnabled(Contacts);
		
		WebElement Accounts = createWebElementBy(btn_Accounts);
		IsDisplayed_IsEnabled(Accounts);
		
		WebElement Activities = createWebElementBy(btn_Activities);
		IsDisplayed_IsEnabled(Activities);
		
		WebElement Proposals = createWebElementBy(btn_Proposals);
		IsDisplayed_IsEnabled(Proposals);
		
		WebElement TextProtocols = createWebElementBy(txt_Protocols);
		IsDisplayed_IsEnabled(TextProtocols);
		
		takeScreenshotAtEndOfTest();
	}
	

	}