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

public class BAS extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String ProdUrl1 = "https://sur.gilead.com/";
	final String ValUrl1 = "https://surval.gilead.com/";
	final String ProdUrl2 = "http://cdap.gilead.com/#/";
	final String ValUrl2 = " http://cdapval.gilead.com/";


	/***************************** Test Cases *******************/
	

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Begin Test Execution..");
	}

	@Test(priority = 1, enabled = true)
	public void BAS_TC01_Web_SUR_Prod_Checking_Landingpage() {
		TM_BAS_TC01_Web_SUR_Prod_Checking_Landingpage();
	}

	@Test(priority = 2, enabled = true)
	public void BAS_TC02_Web_SUR_Val_Checking_Landingpage() {
		TM_BAS_TC02_Web_SUR_Val_Checking_Landingpage();
	}

	@Test(priority = 3, enabled = true)
	public void BAS_TC03_Web_CDAP_PROD_Checking_Landingpage() {
		TM_BAS_TC03_Web_CDAP_PROD_Checking_Landingpage();
	}

	@Test(priority = 4, enabled = true)
	public void BAS_TC04_Web_CDAP_VAL_Checking_Landingpage() {
		TM_BAS_TC04_Web_CDAP_VAL_Checking_Landingpage();
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
	By UnAuthorized = By.cssSelector("div[class='jumbotron ng-scope'] h1");




	void TM_BAS_TC01_Web_SUR_Prod_Checking_Landingpage() {
		launchBrowser(Browser, ProdUrl1);

		WebElement B3P_head = createWebElementBy(head_B3P);
		IsDisplayed_IsEnabled(B3P_head);

		takeScreenshotAtEndOfTest();
	}

	void TM_BAS_TC02_Web_SUR_Val_Checking_Landingpage() {
		launchBrowser(Browser, ValUrl1);

		WebElement B3P_head = createWebElementBy(head_B3P);
		IsDisplayed_IsEnabled(B3P_head);

		takeScreenshotAtEndOfTest();
	}

	void TM_BAS_TC03_Web_CDAP_PROD_Checking_Landingpage() {
		launchBrowser(Browser, ProdUrl2);

		WebElement lbl_Unauthorized = createWebElementBy(UnAuthorized);
		IsDisplayed_IsEnabled(lbl_Unauthorized);

		takeScreenshotAtEndOfTest();
	}

	void TM_BAS_TC04_Web_CDAP_VAL_Checking_Landingpage() {
		launchBrowser(Browser, ValUrl2);

		WebElement lbl_Unauthorized = createWebElementBy(UnAuthorized);
		IsDisplayed_IsEnabled(lbl_Unauthorized);
		
		takeScreenshotAtEndOfTest();
	}
	
	
	

}


