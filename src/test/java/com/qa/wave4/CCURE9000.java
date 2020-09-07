package com.qa.wave4;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class CCURE9000 extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String Url = "http://gadi2dev.gilead.com/";
	String pageTitle;
	private static final String userDirectory = System.getProperty("user.dir");
	private static String imagePath = userDirectory + "\\AutoFiles\\SiKuli\\CCURE\\";
	final String servername = "edccurappprdn01";
	final String Username = "ADM_abhatt2";
	final String password = "Az@isha4Oc_!";
	private String DecrptPassword;

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

	@Test(priority = 1, enabled = true)
	public void CCURE_S01_Windows_serverLogin() throws FindFailed {
		TM_CCURE_S01_Windows_serverLogin();
	}
	@Test(priority = 2, enabled = true)
	public void CCURE_S02_Windows_applicationLoginVerification() throws FindFailed {
		TM_CCURE_S02_Windows_applicationLoginVerification();
	}
	/*
	 * @AfterMethod(enabled = true) void Teardouwn() { driver.quit(); }
	 */

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */

	By ipt_Username = By.id("login");
	By ipt_Password = By.id("passwd");
	By btn_LogOn = By.id("loginBtn");
	By lnk_lightversion = By.linkText("Use light version");
	By apps = By.cssSelector("[id='allAppsBtn'] div");
	By gcSimulator = By.xpath("//p[@class=\"storeapp-name\"][text()='GC Simulator_DEV']");
	By lcSimulator = By.xpath("//p[@class=\"storeapp-name\"][text()='LC Simulator']");
	By percepta = By.xpath("//p[@class=\"storeapp-name\"][text()='Percepta']");
	By nameApp = By.xpath("//p[@class=\"storeapp-name\"][text()='NAME']");

	/*****************************
	 * Test Case Methods
	 * 
	 * @throws FindFailed
	 *******************/
	void TM_CCURE_S01_Windows_serverLogin() throws FindFailed {

		RDP_Connection(servername, Username, password);
		Screen s = new Screen();
		Pattern close = new Pattern(imagePath + "crossBtn1.PNG");
		s.wait(close, 8000);
		s.click();
		
		
		Pattern ccureapp = new Pattern(imagePath + "Ccure_app.PNG");
		s.wait(ccureapp, 15000);
		Boolean IsExists = false;

		if (s.exists(ccureapp) != null) {
			IsExists = true;

		}
		Assert.assertTrue(IsExists);
		takeScreenshotAtSikuli();
		
		
		Pattern startButton = new Pattern(imagePath + "ccure_startBtn.PNG");
		s.wait(startButton, 10000);
		s.click();
		
		Pattern userAccount= new Pattern(imagePath + "user_account");
		s.wait(userAccount, 5000);
		s.click();
		
		Pattern signout= new Pattern(imagePath + "ccure_signout");
		s.wait(signout, 5000);
		s.click();
		
			}

	void TM_CCURE_S02_Windows_applicationLoginVerification() throws FindFailed {

		RDP_Connection(servername, Username, password);

		Screen s = new Screen();
		Pattern close = new Pattern(imagePath + "crossBtn1.PNG");
		s.wait(close, 2000);
		s.click();
		takeScreenshotAtSikuli();
		Pattern ccureapp = new Pattern(imagePath + "Ccure_app.PNG");
		s.wait(ccureapp, 10000);
		s.doubleClick();
		Pattern administrator = new Pattern(imagePath + "ccure_administrator.PNG");
		s.wait(administrator, 5000);
		s.click();
		Pattern personnel = new Pattern(imagePath + "ccure_personnel.PNG");
		s.wait(personnel, 5000);
		s.click();
		wait(7);
		Pattern searchBtn = new Pattern(imagePath + "ccure_search.PNG");
		s.wait(searchBtn, 5000);
		s.click();
		wait(7);
		takeScreenshotAtSikuli();

		Pattern startButton = new Pattern(imagePath + "ccure_startBtn.PNG");
		s.wait(startButton, 5000);
		s.click();
		
		Pattern userAccount= new Pattern(imagePath + "user_account");
		s.wait(userAccount, 5000);
		s.click();
		takeScreenshotAtSikuli();
		
		Pattern signout= new Pattern(imagePath + "ccure_signout");
		s.wait(signout, 5000);
		s.click();

	}

	/*********************************
	 * Common Methods
	 *************************************/

	
}
