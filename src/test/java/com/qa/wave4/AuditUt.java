package com.qa.wave4;

import org.testng.annotations.Test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AuditUt 
{

private static final String userDirectory = System.getProperty("user.dir");
public static WebDriver driver;



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
		
		WebElement AuditUtopia_ipt = createWebElementBy(ipt_AuditUtopia);
		String AU = AuditUtopia_ipt.getText();
		Assert.assertEquals(AU, "AuditUtopia");
	}
		public void launchBrowser(String browser, String url) {

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
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

		public WebElement createWebElementBy(By locator) {
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			WebElement element = driver.findElement(locator);
			Reporter.log("Mouse Control is on " + locator.toString() + " on Web App URL: " + driver.getCurrentUrl());
			
			return element;
		}
		
	}


