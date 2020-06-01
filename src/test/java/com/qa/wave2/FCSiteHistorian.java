package com.qa.wave2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class FCSiteHistorian extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	String pageUrl;
	// URL for Fc vision:
	final String url1 = "https://fcvision.na.gilead.com/PIVision/#/";
	final String url2= "https://sjfcshappprdn05/";

	/***************************** Test Cases *******************/
	/*
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
	public void FCSiteHistorian_S01_Web_HistorianDisplay() {
		launchBrowser(Browser, url1);
		TM_FCSiteHistorian_S01_HistorianDisplay();
	}
	@Test(priority = 1, enabled = true)
	public void FCSiteHistorian_S02_Web_VerifyNewDisplayInterface01() {
		launchBrowser(Browser, url1);
		TM_FCSiteHistorian_S02_VerifyNewDisplayInterface01();
		
	}
	@Test(priority = 2, enabled = true)
	public void FCSiteHistorian_S03_Web_VerifyMyView() {
		launchBrowser(Browser, url2);
		TM_FCSiteHistorian_S03_VerifyMyView();
	}
	@Test(priority=3, enabled= true)
	public void FCSiteHistorian_S04_Web_VerifyNewDisplayInterface02() {
		launchBrowser(Browser, url1);
		TM_FCSiteHistorian_S04_VerifyNewDisplayInterface02();
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

	// PROD 1:
	By logo = By.xpath("//*[contains(text(),'Welcome to InsightIQ. Please log in.')]");
	By field_Username = By.xpath("//input[@id='username']");
	By field_Password = By.xpath("//input[@id='password']");
	By login_button = By.xpath("//input[@id='authform']");
	By lnk_systemOverview= By.xpath("//span[@title='System Health Overview']");
	By btn_newDisplay= By.id("new-display-icon");
	By lnk_gileadBMS= By.xpath("(//div[@class='disclosure-indicator'])[4]");
	By lnk_fosterCity= By.xpath("(//div[@class='disclosure-indicator'][@ng-click])[1]");
	By lnk_system= By.xpath("(//div[@class='disclosure-indicator'][@ng-click])[37]");
	By lnk_piInterface= By.xpath("(//div[@class='disclosure-indicator'][@ng-click])[1]");
	By lnk_modulusInterface= By.xpath("(//span[@class='subhead-text-fill'])[2]");
	By display_container = By.cssSelector(".c-display-container");
	By display_container1=By.id("new-display-text");
	By lnk_interface1= By.xpath("(//span[text()='Interface 1 I/O Rate'])[2]");
	By lnk_interface2= By.xpath("(//span[text()='Interface 2 I/O Rate'])[2]");
	By asset_event = By.xpath("//div[@col-id='Name']");
	By assetAndEvent_status = By.xpath("//span[@class='run-status-no-bar']");
	By graphs=By.cssSelector(".symbol-template-parent svg");
	By btn_duration=By.cssSelector(".duration");
	By btn_month= By.xpath("//button[text()='1mo']");
	


	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions act =new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
	}

	public void TM_FCSiteHistorian_S01_HistorianDisplay() {

		WebElement systemOverview= createWebElementBy(lnk_systemOverview);
		systemOverview.click();
		pageUrl= getURL();
		Assert.assertTrue(pageUrl.contains("System-Health-Overview"));
		List<WebElement> healthGraph= createWebElementsBy(graphs);
		Assert.assertEquals(healthGraph.size(), 7);
		takeScreenshotAtEndOfTest();
		
				
	}
	public void navigateToModbus() {
		waitForPageLoaded();
		WebElement newDisplay= createWebElementBy(btn_newDisplay);
		newDisplay.click();
		waitForPageLoaded();
		WebElement gileadBMS= createWebElementBy(lnk_gileadBMS);
		gileadBMS.click();
		waitForPageLoaded();
		WebElement fosterCity= createWebElementBy(lnk_fosterCity);
		fosterCity.click();
		waitForPageLoaded();
		WebElement system= createWebElementBy(lnk_system);
		system.click();
		waitForPageLoaded();
		WebElement piInterface= createWebElementBy(lnk_piInterface);
		piInterface.click();
		waitForPageLoaded();
		WebElement ModulusInterface= createWebElementBy(lnk_modulusInterface);
		ModulusInterface.click();
		waitForPageLoaded();
		
	}
	public void TM_FCSiteHistorian_S02_VerifyNewDisplayInterface01() {
		navigateToModbus();
		WebElement source1= createWebElementBy(lnk_interface1);
		WebElement target1 = createWebElementBy(display_container1);
		dragAndDrop(source1, target1);
		wait(5);
		WebElement btnDuration= createWebElementBy(btn_duration);
		btnDuration.click();
		waitForPageLoaded();
		WebElement btnmonth=createWebElementBy(btn_month);
		btnmonth.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		
				
				
	}
	public void TM_FCSiteHistorian_S04_VerifyNewDisplayInterface02() {
		navigateToModbus();
		WebElement source1= createWebElementBy(lnk_interface2);
		WebElement target1 = createWebElementBy(display_container1);
		dragAndDrop(source1, target1);
		wait(5);
		WebElement btnDuration= createWebElementBy(btn_duration);
		btnDuration.click();
		waitForPageLoaded();
		WebElement btnmonth=createWebElementBy(btn_month);
		btnmonth.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		closeBrowser();

		
	}
	
	public void TM_FCSiteHistorian_S03_VerifyMyView() {
		waitForPageLoaded();
		wait(5);
		List<WebElement> Items_EventAndAssets= createWebElementsBy(asset_event);
		for (int i = 1; i < Items_EventAndAssets.size(); i++) {
			scrollToWebElement(Items_EventAndAssets.get(i));
			System.out.println("Menu item " + Items_EventAndAssets.get(i).getText() + " is displayed");
			IsDisplayed_IsEnabled(Items_EventAndAssets.get(i));
		}
		List<WebElement> status_EventAndAsset = createWebElementsBy(assetAndEvent_status);
		for (int i = 0; i < status_EventAndAsset.size(); i++) {
			scrollToWebElement(status_EventAndAsset.get(i));
			IsDisplayed_IsEnabled(Items_EventAndAssets.get(i));
			Assert.assertEquals(status_EventAndAsset.get(i).getText(), "Scheduled");
		}
		takeScreenshotAtEndOfTest();
		
	}

	

			
	

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
