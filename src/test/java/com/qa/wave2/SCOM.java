package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SCOM extends CommonMethods {

	/***************************** Test Cases *******************/

	@BeforeMethod(enabled = true)
	public void beforeTest() {

	}

	@Test(priority = 0, enabled = true)
	public void SCOM_S01_Web_POC_UserValidation() throws IOException {
		TM_SCOM_S01_Web_POCenv_Validation();

	}

	@Test(priority = 1, enabled = true)
	public void SCOM_S02_Web_Dev_UserValidation() throws IOException, InterruptedException {
		TM_SCOM_S02_Web_Devenv_Validation();

	}

	@AfterMethod
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	By ipt_Monitoring = By.xpath("//input[@id='loginusername']");
	By ipt_Password = By.xpath("//input[@id='loginpassword']");
	By btn_Login = By.xpath("//button[@class='loginbutton button big']");
	By lnk_ActiveAlerts = By.xpath("//span[contains(text(),'Active Alerts')]");
	By ipt_ActiveAlertTitle = By.xpath("//span[@id='ResultsTitle_mainTitle']");
	By lnk_WindowsComputers = By.xpath("//span[contains(text(),'Windows Computers')]");

	/***************************** Test Case Methods *******************/

	public void TM_SCOM_S01_Web_POCenv_Validation() throws IOException {

		final String Browser = "Chrome";
		final String POCURL = "http://SJSCOMWEBPOCN01/OperationsManager";
		launchBrowser(Browser, POCURL);
		waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "Operations Manager Web Console",
				"Operations Manager Web Console not displayed");
		WebElement ActiveAlerts_lnk = createWebElementBy(lnk_ActiveAlerts);
		ActiveAlerts_lnk.click();
		driver.switchTo().frame("frame");
		String ActiveAlerts = driver.findElement(By.id("ResultsTitle_mainTitle")).getText();
		Assert.assertEquals(ActiveAlerts, "Active Alerts");
		driver.switchTo().defaultContent();
		WebElement WindowsComputers_lnk = createWebElementBy(lnk_WindowsComputers);
		WindowsComputers_lnk.click();
		driver.switchTo().frame("frame");
		String WindowsComputers = driver.findElement(By.id("ResultsTitle_mainTitle")).getText();
		Assert.assertEquals(WindowsComputers, "Windows Computers");
		takeScreenshotAtEndOfTest();

	}

	public void TM_SCOM_S02_Web_Devenv_Validation() throws IOException, InterruptedException {

		final String Browser = "IE";
		final String DevURL = "http://EUMONAPPDEVN01/OperationsManager";
		launchBrowser(Browser, DevURL);
		waitForPageLoaded();
		Thread.sleep(90000);
		Assert.assertEquals(driver.getTitle(), "Operations Manager Web Console",
				"Operations Manager Web Console not displayed");
		takeScreenshotAtEndOfTest();

	}

}
