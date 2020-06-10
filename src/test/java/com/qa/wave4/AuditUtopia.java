package com.qa.wave4;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AuditUtopia extends CommonMethods {

	/***************************** Test Cases *******************/

	@BeforeMethod(enabled = true)
	public void BeforeMethod() throws IOException {

	}

	@Test(priority = 0, enabled = true)
	public void AuditUtopia_S01_Web_Produrl_LandingPage() throws IOException {
		TM_AuditUtopia_S01_Web_Produrl_LandingPage();
	}

	@AfterMethod
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	By ipt_AuditUtopia = By.xpath("//form[@name='form']//a[contains(text(),'AuditUtopia')]");

	/***************************** Test Case Methods *******************/

	public void TM_AuditUtopia_S01_Web_Produrl_LandingPage() throws IOException {
		final String Browser = "Chrome";
		final String ProdURL = "http://fcaudappprd01.na.gilead.com/auditutopia";
		final String URL = ProdURL;
		launchBrowser(Browser, URL);
		waitForPageLoaded();
		WebElement AuditUtopia_ipt = createWebElementBy(ipt_AuditUtopia);
		String AU = AuditUtopia_ipt.getText();
		Assert.assertEquals(AU, "AuditUtopia");
		takeScreenshotAtEndOfTest();
	}

}
