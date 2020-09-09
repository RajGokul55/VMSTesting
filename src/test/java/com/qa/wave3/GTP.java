package com.qa.wave3;


import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class GTP extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String PRODUrl= "https://gtp.gilead.com/t/COE/views/TableauServerPerformance_prd2018_publishedDS/"
			+ "DiskUsage?iframeSizedToWindow=true&%3Aembed=y&%3"
			+ "AshowAppBanner=false&%3Adisplay_count=no&%3AshowVizHome=no#1";

	final String InterworksURL = "https://analytics.gilead.com/user/login";
	final String Username ="psonawane";
	private String DecrptPassword;

	/***************************** Test Cases *******************/


	@Test(priority=0, enabled=true)
	public void GTP_S01_Prod_PostPatch_Testing() {
		TM_GTP_S01_Prod_PostPatch_Testing(PRODUrl);
	}

	@Test(priority=1, enabled=true)
	public void GTP_S02_Interworks_PostPatch_Testing() {
		TM_GTP_S02_Interworks_PostPatch_Testing(InterworksURL);
	}


	@AfterMethod(enabled=true)
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector: tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages          
	 */
	By ipt_Username= By.xpath("//input[@id='user-login']");
	By ipt_Password= By.xpath("//input[@id='user-password']");
	By btn_login= By.xpath("//button[@class='btn btn-default']");
	By icn_HIVSubnational = By.xpath("//h3[contains(text(),'HIV Sub-National Dashboard')]");
	By icn_username=By.xpath("//span[@id='username']");
	By btn_logout= By.xpath("//li[@class='item secondary-item']//a[contains(text(),'Log out')]");

	By icn_CPUusage= By.xpath("//span[@id='tableauTabbedNavigation_tab_1");
	By icn_memoryusage= By.xpath("//span[@id='tableauTabbedNavigation_tab_1']");
	By icn_DiskUsage= By.xpath("//span[@id='tableauTabbedNavigation_tab_2']");


	/*******************Login page****************/

	void TM_GTP_S01_Prod_PostPatch_Testing(String PRODUrl) {
		launchBrowser(Browser,PRODUrl);
		WebElement Memoryusage_icn = createWebElementBy(icn_memoryusage);
		Memoryusage_icn.click();
		takeScreenshotAtEndOfTest();
		waitForPageLoaded();

		WebElement Diskusage_icn = createWebElementBy(icn_DiskUsage);
		Diskusage_icn.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();

	}


	void TM_GTP_S02_Interworks_PostPatch_Testing(String InterworksURL) {
		launchBrowser(Browser,InterworksURL);
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);
		try {
			DecrptPassword = decrypt(" MfpoFri2dPP8Y/JUm6i2jw==");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement Password_Ipt = createWebElementBy(ipt_Password);
		Password_Ipt.sendKeys(DecrptPassword);
		takeScreenshotAtEndOfTest();

		WebElement Login_Btn = createWebElementBy(btn_login);
		Login_Btn.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();


		WebElement HIVSubnational_icn = createWebElementBy(icn_HIVSubnational);
		HIVSubnational_icn.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();


		WebElement username_icn = createWebElementBy(icn_username);
		username_icn.click();

		WebElement logout_btn= createWebElementBy(btn_logout);
		logout_btn.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
	}
}


/*****************************Application Interaction Methods *******************/
// if any code re-usability is there specific to this Application then that should be maintained here


