package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class BSKCS extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	
	final String Url1 = "https://dvst.gilead.com/";
	final String Url2 = "https://cat.gilead.com/#/";
	
	/***************************** Test Cases *******************/
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Begin Test Execution..");
	}

	@Test(priority = 1, enabled = true)
	public void BSKCS_TC01_Web_DVST_Checking_Landingpage() {
		TM_BSKCS_TC01_Web_DVST_Checking_Landingpage();
	}
	@Test(priority = 2, enabled = true)
	public void BSKCS_TC02_Web_CAT_Checking_Landingpage() {
		TM_BSKCS_TC02_Web_CAT_Checking_Landingpage();
	}

	@AfterMethod(enabled = true)
	public void afterMethod() {
		driver.quit();
	}
	/***************************** Locators *******************/	
	By Logo = By.cssSelector("a[class= 'navbar-brand app-title']");


	/***************************** Test Methods *******************/
	
	void TM_BSKCS_TC01_Web_DVST_Checking_Landingpage() {
		launchBrowser(Browser, Url1);

		WebElement DVST_Logo = createWebElementBy(Logo);
		IsDisplayed_IsEnabled(DVST_Logo);

		takeScreenshotAtEndOfTest();
		
	}
	
	void TM_BSKCS_TC02_Web_CAT_Checking_Landingpage() {
		launchBrowser(Browser, Url2);
		
		WebElement DVST_Logo = createWebElementBy(Logo);
		IsDisplayed_IsEnabled(DVST_Logo);

		takeScreenshotAtEndOfTest();
		
	}
}
