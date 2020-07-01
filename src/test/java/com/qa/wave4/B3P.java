package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class B3P extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url1 = "https://b3p.gilead.com/#/";
	final String Url2 = "https://b3p.gilead.com:44310/#/";
	final String Url3 = "https://b3p.gilead.com:44311/#!/";
	final String Url4 = "https://b3p.gilead.com:44315/#/folders/management";


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
		System.out.println("Begin Test Execution..");
	}

	@Test(priority = 1, enabled = true)
	public void B3P_S01_Web_Checking_Landingpage() {
		TM_B3P_S01_Web_Checking_Landingpage();
	}

	@Test(priority = 2, enabled = true)
	public void B3P_S02_Web_BiomarkerTracker_Checking_Landingpage() {
		TM_B3P_S02_Web_BiomarkerTracker_Checking_Landingpage();
	}

	@Test(priority = 3, enabled = true)
	public void B3P_S03_Web_LabTracker_Checking_Landingpage() {
		TM_B3P_S03_Web_LabTracker_Checking_Landingpage();
	}

	@Test(priority = 4, enabled = true)
	public void B3P_S04_Web_FAB_Checking_Landingpage() {
		TM_B3P_S04_Web_FAB_Checking_Landingpage();
	}

	@AfterMethod(enabled = true)
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
	By head_B3P = By.cssSelector("div[class='page-title widget-head'] h3");




	void TM_B3P_S01_Web_Checking_Landingpage() {
		launchBrowser(Browser, Url1);

		WebElement B3P_head = createWebElementBy(head_B3P);
		IsDisplayed_IsEnabled(B3P_head);

		takeScreenshotAtEndOfTest();
	}

	void TM_B3P_S02_Web_BiomarkerTracker_Checking_Landingpage() {
		launchBrowser(Browser, Url2);

		WebElement B3P_head = createWebElementBy(head_B3P);
		IsDisplayed_IsEnabled(B3P_head);

		takeScreenshotAtEndOfTest();
	}

	void TM_B3P_S03_Web_LabTracker_Checking_Landingpage() {
		launchBrowser(Browser, Url3);

		WebElement B3P_head = createWebElementBy(head_B3P);
		IsDisplayed_IsEnabled(B3P_head);

		takeScreenshotAtEndOfTest();
	}

	void TM_B3P_S04_Web_FAB_Checking_Landingpage() {
		launchBrowserB3P(Browser, Url4);
		takeScreenshotAtSikuli();
	}
	
	
	public void launchBrowserB3P(String browser, String url) {
		final String userDirectory = System.getProperty("user.dir");
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					userDirectory + "\\src\\main\\java\\com\\qa\\demo\\config\\chromedriver_v78.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					userDirectory + "\\src\\main\\java\\com\\qa\\demo\\config\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.gecko.driver",
					userDirectory + "\\src\\main\\java\\com\\qa\\demo\\config\\GeckoDriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(url);
		wait(5);
		//driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}


