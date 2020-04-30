package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GEAR_Test extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url_GileadInterface = "https://fcmegapptstn01.na.gilead.com/published";
	final String Url_HopexInterface = "https://fcmegapptstn01.na.gilead.com/hopex/";
	
	//use below url for Prod testing
	final String Url_Gilead_prod= "https://gear.gilead.com/published";
	final String Url_Hopex_prod = "https://gear.gilead.com/hopex/";

	/***************************** Test Cases *******************/
	/*
	 * Url_GileadInterface = "https://fcmegapptstn01.na.gilead.com/published";
	 * Url_HopexInterface = "https://fcmegapptstn01.na.gilead.com/hopex/";
	 * Url_Gilead_prod= "https://gear.gilead.com/published";
	 * Url_Hopex_prod = "https://gear.gilead.com/hopex/";
	 * Test case ‘Test Name’ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: • AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, • TCNumber:
	 * Test case number [Numeric 2-3 digits] i.e, 01, 02,.. • TestCategory: Test
	 * case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve,
	 * DB …] • Title: short title of test case based on context of test case ie.,
	 * ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails.
	 * 
	 * Test method name must be same as test case appended with TM example:
	 */

	@Test(priority = 0, enabled = true)
	public void Gear_S01_Web_HopexInterface_Module_Verification() {
		launchBrowser(Browser, Url_HopexInterface);
		TM_Gear_S01_Web_HopexInterface_Module_Verification();

	}

	@Test(priority = 1, enabled = true)
	public void Gear_S02_Web_HopexInterface_LinksUnderHomeTab_Verification() {
		launchBrowser(Browser, Url_HopexInterface);
		TM_Gear_S02_Web_HopexInterface_LinksUnderHomeTab_Verification();
	}

	@Test(priority = 2, enabled = true)
	public void Gear_S03_Web_GileadInterface_Tab_Availability() {
		launchBrowser(Browser, Url_GileadInterface);
		TM_Gear_TC03_Web_GileadInterface_Tab_Availability();

	}

	@Test(priority = 3, enabled = true)
	public void Gear_S04_Web_GileadInterface_Navigation_Verification() {
		launchBrowser(Browser, Url_GileadInterface);
		TM_Gear_TC04_Web_GileadInterface_Navigation_Verification();
	}

	@AfterMethod(enabled = true)
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */

	By ipt_Username = By.xpath("//input[@class= '_2zrpKA _1dBPDZ']");

	By lnk_tabs = By.xpath("//ul[@id='e_menu']/li/a/b");
	By lnk_systems = By.xpath("(//ul[@id='e_menu']/li/a/b)[4]");
	By frm_frame = By.xpath("//frame[@name='contentframe']");
	By txt_systemList = By.xpath("//span[text()='Systems List']");
	By msg_heading = By.cssSelector(".bg h1");
	By lnk_gear = By.linkText("GEAR");

	By id_submitButton = By.cssSelector("#focusedsubmit");
	By lnk_tiles = By.xpath("//div[contains(text(),'All')]");
	By lnk_hometabs = By.xpath("//span[contains(@id,'header_hd-textEl')]");

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	void TM_Gear_S01_Web_HopexInterface_Module_Verification() {
		
		if (Url_HopexInterface != Url_Hopex_prod) {
			waitForPageLoaded();
			WebElement submitButton = createWebElementBy(id_submitButton);
			submitButton.click();
			wait(10);
			waitForPageLoaded();
		}

		List<WebElement> Items_Menu = createWebElementsBy(lnk_tiles);
		for (int i = 0; i < Items_Menu.size(); i++) {
			scrollToWebElement(Items_Menu.get(i));
			System.out.println("Menu item " + Items_Menu.get(i).getText() + " is displayed");
			IsDisplayed_IsEnabled(Items_Menu.get(i));
		}
		takeScreenshotAtEndOfTest();

	}

	void TM_Gear_S02_Web_HopexInterface_LinksUnderHomeTab_Verification() {
		if (Url_HopexInterface != Url_Hopex_prod) {
			waitForPageLoaded();
			WebElement submitButton = createWebElementBy(id_submitButton);
			submitButton.click();
			wait(10);
			waitForPageLoaded();
		}
		List<WebElement> Home_tabs = createWebElementsBy(lnk_hometabs);
		for (int i = 0; i < 8; i++) {
			System.out.println("Menu item " + Home_tabs.get(i).getText() + " is displayed");
			IsDisplayed_IsEnabled(Home_tabs.get(i));

		}
		takeScreenshotAtEndOfTest();
	}

	void TM_Gear_TC03_Web_GileadInterface_Tab_Availability() {
		WebElement frame = createWebElementBy(frm_frame);
		switchToFrameByLocator(frame);

		List<WebElement> Items_Menu = createWebElementsBy(lnk_tabs);
		for (int i = 0; i < Items_Menu.size(); i++) {
			IsDisplayed_IsEnabled(Items_Menu.get(i));
		}
		takeScreenshotAtEndOfTest();

	}

	void TM_Gear_TC04_Web_GileadInterface_Navigation_Verification() {
		waitForPageLoaded();
		WebElement frame = createWebElementBy(frm_frame);
		switchToFrameByLocator(frame);
		WebElement systemLink = createWebElementBy(lnk_systems);
		WebElement systemList = createWebElementBy(txt_systemList);
		takeScreenshotAtEndOfTest();
		mouseHover(systemLink);
		waitForPageLoaded();
		systemList.click();

		WebElement pageHeading = createWebElementBy(msg_heading);
		Assert.assertEquals(pageHeading.getText(), "Alphabetical list of Systems");
		WebElement gearLink = createWebElementBy(lnk_gear);
		IsDisplayed_IsEnabled(gearLink);
		takeScreenshotAtEndOfTest();
	}

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here
}
