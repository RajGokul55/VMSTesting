package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class Validata extends CommonMethods {
	/***************************** Test Data *******************/
	String Browser = "IE";
	String URL = "https://sjvldapptstn01.na.gilead.com/ecmlogin";
	String username ="vms_automation";
	String password = "automation123";


	/***************************** Test Cases *******************/
	@BeforeTest(enabled = true)
	public void beforeTest() {
		TM_launchandLogin();
	}

	@AfterTest(enabled = true)
	public void afterTest() {
		driver.quit();
	}

	@Test()
	public void RDP_Connection() {
		System.out.println(" Test executed successfully//");

	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields 
	 * btn_: Buttons
	 * lnk_: Links 
	 * rdo_: Radio buttons 
	 * chk_: Check boxes 
	 * tbl_: Tables 
	 * msg_: Messages
	 */
	By ipt_username = By.cssSelector("input[name='username']");
	By ipt_password = By.cssSelector("input[name='password']");
	By btn_LogOn = By.cssSelector("button[name='logon']");



	void TM_launchandLogin() {
		launchBrowser(Browser, URL);
		
		WebElement Username = createWebElementBy(ipt_username);
		Username.sendKeys(username);
		
		WebElement Password = createWebElementBy(ipt_password);
		Password.sendKeys(password);
		
		WebElement LogOn = createWebElementBy(btn_LogOn);
		LogOn.click();
		
		waitForPageLoaded();
		
		takeScreenshotAtEndOfTest();
	}
}
