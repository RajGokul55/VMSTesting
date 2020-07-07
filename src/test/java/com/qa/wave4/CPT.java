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

public class CPT extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url = "http://cpt.gilead.com/";


	/***************************** Test Cases *******************/
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Begin Test Execution..");
	}

	@Test(priority = 1, enabled = true)
	public void CPT_S01_Web_Checking_Landingpage() {
		TM_CPT_S01_Web_Checking_Landingpage();
	}

	@AfterMethod(enabled = true)
	public void afterMethod() {
		driver.quit();
	}
	/***************************** Locators *******************/	
	By head_B3P = By.cssSelector("div[class='page-title widget-head'] h3");


	/***************************** Test Methods *******************/

	void TM_CPT_S01_Web_Checking_Landingpage() {
		launchBrowserCPT(Browser, Url);
		takeScreenshotAtSikuli();
		
	}
	
	public void launchBrowserCPT(String browser, String url) {
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
	}

}
