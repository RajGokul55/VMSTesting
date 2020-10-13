package com.qa.wave2;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PRTGNetworkMonitor extends CommonMethods2 {

	public PRTGNetworkMonitor() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***************************** Test Cases *******************/

	@BeforeMethod(enabled = true)
	public void BeforeMethod() throws IOException {

	}

	@Test(priority = 0, enabled = false)
	public void PRTGNM_S01_Web_Devurl_UserLogin() throws IOException {
		GM_PRTGNM_Web_DevURLLogin();
	}

	@Test(priority = 1, enabled = false)
	public void PRTGNM_S02_Web_DevurlViewAllSensorsData() throws IOException {
		TM_PRTGNM_S02_Web_Devurl_ViewAllSensorsData();
	}

	@Test(priority = 2, enabled = true)
	public void PRTGNM_S03_Web_Produrl_UserLogin() throws IOException {
		GM_PRTGNM_Web_ProdURLLogin();
	}

	@Test(priority = 3, enabled = true)
	public void PRTGNM_S04_Web_Produrl_ViewAllSensorsData() throws IOException {
		TM_PRTGNM_S04_Web_Produrl_ViewAllSensorsData();
	}

	@AfterMethod
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	By ipt_Username = By.xpath("//input[@id='loginusername']");
	By ipt_Password = By.xpath("//input[@id='loginpassword']");
	By btn_Login = By.xpath("//button[@class='loginbutton button big']");

	/***************************** Test Case Methods *******************/

	public void TM_PRTGNM_S02_Web_Devurl_ViewAllSensorsData() throws IOException {
		GM_PRTGNM_Web_DevURLLogin();
		waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "Welcome | PRTG Network Monitor (SJPRTGAPPDEVG01)",
				"PRTG Network Monitor Home page not displayed");
		takeScreenshotAtEndOfTest();
	}

	public void TM_PRTGNM_S04_Web_Produrl_ViewAllSensorsData() throws IOException {

		GM_PRTGNM_Web_ProdURLLogin();
		waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "Welcome | PRTG Network Monitor (SJPRTGAPPPRDN01)",
				"PRTG Network Monitor Home page not displayed");
		takeScreenshotAtEndOfTest();

	}

	/***************************** Generic Methods *******************/

	public void GM_PRTGNM_Web_DevURLLogin() throws IOException {

		final String Browser = "Chrome";
		final String DevURL = "http://sjprtgappdevg01/";
		final String Username = "VMS";
		String DecryptPassword = null;
		final String EncryptPassword = "dLYEuUGwlY262xhKocrIUw==";
		final String URL = DevURL; 
		launchBrowser(Browser, URL);
		try {
			DecryptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.clear();
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Password);
		Password_Ipt.clear();
		Password_Ipt.sendKeys(DecryptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();

		waitForPageLoaded();
		takeScreenshotAtEndOfTest();

	}

	public void GM_PRTGNM_Web_ProdURLLogin() throws IOException {

		final String Browser = "Chrome";
		final String ProdURL = "http://sjprtgappprdn01/";
		final String Username = "dmarkanti";
		String DecryptPassword = null;
		final String EncryptPassword = "VzDCe2EN7hqyJ8BpFa82nQ==";
		final String URL = ProdURL;
		launchBrowser(Browser, URL);
		try {
			DecryptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.clear();
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Password);
		Password_Ipt.clear();
		Password_Ipt.sendKeys(DecryptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();

		waitForPageLoaded();
		takeScreenshotAtEndOfTest();

	}
}
