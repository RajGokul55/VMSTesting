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

public class ACD extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String Url = "http://gadi2dev.gilead.com/";
	String pageTitle;
	private static final String userDirectory = System.getProperty("user.dir");
	private static String imagePath = userDirectory + "\\AutoFiles\\SiKuli\\ACD\\";

	final String Username = "abhatt2";
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

	@BeforeMethod
	void Setup() {
		try {
			DecrptPassword = decrypt("FkOllRi0iO/rIlftff/AwA==");
		} catch (Exception e) {
			e.printStackTrace();
		}
		launchBrowser(Browser, Url);
	}

	@Test(priority = 1, enabled = false)
	public void ACD_S01_Windows_Web_LCSimulatorVerification() throws FindFailed {
		TM_ACD_S01_Windows_Web_LCSimulatorVerification();
	}

	@Test(priority = 2, enabled = true)
	public void ACD_S02_Windows_Web_PerceptaVerification() throws FindFailed {
		TM_ACD_S02_Windows_Web_PerceptaVerification();
	}

	@Test(priority = 4, enabled = false)
	public void ACD_S04_Windows_Web_NameAppVerification() throws FindFailed {
		TM_ACD_S04_Windows_Web_NameAppVerification();
	}

	@Test(priority = 5, enabled = false)
	public void ACD_S05_Windows_Web_GCSimulatorVerification() throws FindFailed {
		TM_ACD_S05_Windows_Web_GCSimulatorVerification();
	}

	@AfterMethod(enabled = false)
	void Teardouwn() {
		driver.close();
	}

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
	void TM_ACD_S01_Windows_Web_LCSimulatorVerification() throws FindFailed {

		ACD_User_Login();
		WebElement lnk = createWebElementBy(lnk_lightversion);
		lnk.click();
		waitForPageLoaded();
		WebElement appsLink = createWebElementBy(apps);
		appsLink.click();
		waitForPageLoaded();
		String parentwindow = driver.getWindowHandle();
		WebElement lcsimulator = createWebElementBy(lcSimulator);
		lcsimulator.click();
		wait(5);
		Set<String> str = driver.getWindowHandles();
		for (String str1 : str) {

			if (!str1.equalsIgnoreCase(parentwindow)) {
				System.out.println(str1);
				waitForPageLoaded();
				driver.switchTo().window(str1);
				pageTitle = driver.getTitle();
				Assert.assertEquals(pageTitle, "LC Simulator");
				Screen s1 = new Screen();
				try {

					Pattern notNow = new Pattern(imagePath + "notNow.PNG");
					s1.wait(notNow, 2000);
					s1.click();
					wait(5);
					Pattern fileImg = new Pattern(imagePath + "GC_File");
					Boolean IsExists = false;

					if (s1.exists(fileImg) != null) {
						IsExists = true;

					}
					Assert.assertTrue(IsExists);
				}

				catch (Exception e) {
					e.printStackTrace();

				} finally {
					wait(5);

					Pattern crossBtn = new Pattern(imagePath + "crossBtn.PNG");
					s1.wait(crossBtn, 5000);
					s1.click();

				}

			}

		}

	}

	void TM_ACD_S02_Windows_Web_PerceptaVerification() throws FindFailed {

		ACD_User_Login();
		WebElement lnk = createWebElementBy(lnk_lightversion);
		lnk.click();
		waitForPageLoaded();
		WebElement appsLink = createWebElementBy(apps);
		appsLink.click();
		waitForPageLoaded();
		String parentwindow = driver.getWindowHandle();
		WebElement perceptaApp = createWebElementBy(percepta);
		perceptaApp.click();
		wait(5);
		Set<String> str = driver.getWindowHandles();
		for (String str1 : str) {

			if (!str1.equalsIgnoreCase(parentwindow)) {
				System.out.println(str1);
				waitForPageLoaded();
				driver.switchTo().window(str1);
				pageTitle = driver.getTitle();
				Assert.assertEquals(pageTitle, "Percepta");
				Screen s1 = new Screen();
				try {

					Pattern notNow = new Pattern(imagePath + "notNow.PNG");
					s1.wait(notNow, 5000);
					s1.click();
					wait(7);

					Pattern fileImg = new Pattern(imagePath + "historyTab.PNG");
					Boolean IsExists = false;

					if (s1.exists(fileImg) != null) {
						IsExists = true;

					}
					Assert.assertTrue(IsExists);

				}

				catch (Exception e) {
					e.printStackTrace();

				} finally {
					wait(5);

					Pattern crossBtn = new Pattern(imagePath + "crossBtn.PNG");
					s1.wait(crossBtn, 5000);				
					s1.click();

				}

			}

		}

	}

	void TM_ACD_S04_Windows_Web_NameAppVerification() throws FindFailed {

		ACD_User_Login();
		WebElement lnk = createWebElementBy(lnk_lightversion);
		lnk.click();
		waitForPageLoaded();
		WebElement appsLink = createWebElementBy(apps);
		appsLink.click();
		waitForPageLoaded();
		String parentwindow = driver.getWindowHandle();
		WebElement name = createWebElementBy(nameApp);
		name.click();
		wait(5);
		Set<String> str = driver.getWindowHandles();
		for (String str1 : str) {

			if (!str1.equalsIgnoreCase(parentwindow)) {
				System.out.println(str1);
				waitForPageLoaded();
				driver.switchTo().window(str1);
				pageTitle = driver.getTitle();
				Assert.assertEquals(pageTitle, "NAME");
				Screen s1 = new Screen();
				try {

					Pattern notNow = new Pattern(imagePath + "notNow.PNG");
					s1.wait(notNow, 2000);
					s1.click();
					wait(5);
					Pattern cancelbtn = new Pattern(imagePath + "cancelBtn");
					s1.wait(cancelbtn, 2000);
					s1.click();

					Pattern fileImg = new Pattern(imagePath + "GC_File");
					Boolean IsExists = false;

					if (s1.exists(fileImg) != null) {
						IsExists = true;

					}
					Assert.assertTrue(IsExists);
				}

				catch (Exception e) {
					e.printStackTrace();

				} finally {
					wait(5);

					Pattern crossBtn = new Pattern(imagePath + "crossBtn.PNG");
					s1.wait(crossBtn, 5000);
					s1.click();

				}

			}

		}

	}

	void TM_ACD_S05_Windows_Web_GCSimulatorVerification() throws FindFailed {

		ACD_User_Login();
		WebElement lnk = createWebElementBy(lnk_lightversion);
		lnk.click();
		waitForPageLoaded();
		WebElement appsLink = createWebElementBy(apps);
		appsLink.click();
		waitForPageLoaded();
		String parentwindow = driver.getWindowHandle();
		WebElement gcSimulatorDev = createWebElementBy(gcSimulator);
		gcSimulatorDev.click();
		wait(5);
		Set<String> str = driver.getWindowHandles();
		for (String str1 : str) {

			if (!str1.equalsIgnoreCase(parentwindow)) {
				System.out.println(str1);
				waitForPageLoaded();
				driver.switchTo().window(str1);
				pageTitle = driver.getTitle();
				Assert.assertEquals(pageTitle, "GC Simulator_DEV");
				Screen s1 = new Screen();
				try {

					Pattern notNow = new Pattern(imagePath + "notNow.PNG");
					s1.wait(notNow, 2000);
					s1.click();
					wait(5);
					Pattern fileImg = new Pattern(imagePath + "GC_File");
					Boolean IsExists = false;

					if (s1.exists(fileImg) != null) {
						IsExists = true;

					}
					Assert.assertTrue(IsExists);
				}

				catch (Exception e) {
					e.printStackTrace();

				} finally {
					wait(5);

					Pattern crossBtn = new Pattern(imagePath + "crossBtn.PNG");
					s1.wait(crossBtn, 5000);
					s1.click();

				}

			}

		}

	}

	/*********************************
	 * Common Methods
	 *************************************/

	void ACD_User_Login() {

		createWebElementBy(ipt_Username).sendKeys(Username);
		createWebElementBy(ipt_Password).sendKeys(DecrptPassword);
		createWebElementBy(btn_LogOn).click();
		waitForPageLoaded();
	}
}
