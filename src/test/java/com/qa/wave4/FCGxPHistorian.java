package com.qa.wave4;

import static org.testng.Assert.assertEquals;

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

public class FCGxPHistorian extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	String pageUrl;
	// URL for Fc vision:
	final String url1 = "https://fcvisiong.na.gilead.com/#/";
	final String url2= "https://fcvisiong.na.gilead.com/piwebapi";

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
	public void FCGxPHistorian_S01_Web_DashboardVerification() {
		launchBrowser(Browser, url1);
		TM_FCGxPHistorian_S01_Web_DashboardVerification();
	}
	
	@Test(priority = 2, enabled = true)
	public void FCGxPHistorian_S02_Web_PiwebapiUrlVerification() {
		launchBrowser(Browser, url2);
		TM_FCGxPHistorian_S02_Web_PiwebapiUrlVerification();
		
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
	By home_icon= By.cssSelector(".home-icon ~span");
	By btn_newDisplay= By.id("new-display-icon");
	By assets_text=By.xpath("(//div[@id='assets-pane']/div)[1]");
	By lnk_event= By.cssSelector("[title='Events']");
	By events_pane=By.xpath("(//div[@id='events-pane']/div)[1]");
	By lnk_graphic= By.cssSelector("[title='Graphic Library']");
	By graphic_pane=By.xpath("(//div[@id='graphic-library-pane']/div)[1]");
	By lnk_Piwebapi= By.xpath("//pre[@id=\"response\"]/a");
	
	
	


	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	

	public void TM_FCGxPHistorian_S01_Web_DashboardVerification() {

		List<WebElement> homeicons= createWebElementsBy(home_icon);
		assertEquals(homeicons.get(0).getText(), "All Displays");
		assertEquals(homeicons.get(1).getText(), "Favorites");
		assertEquals(homeicons.get(2).getText(), "My Displays");
		assertEquals(homeicons.get(3).getText(), "Recent");
		assertEquals(homeicons.get(4).getText(), "Home");
		takeScreenshotAtEndOfTest();
		
		WebElement newDisplay= createWebElementBy(btn_newDisplay);
		newDisplay.click();
		waitForPageLoaded();
		WebElement assets= createWebElementBy(assets_text);
		assertEquals(assets.getText(), "Assets");
		
		WebElement eventLink= createWebElementBy(lnk_event);
		eventLink.click();
		waitForPageLoaded();
		WebElement eventPane= createWebElementBy(events_pane);
		assertEquals(eventPane.getText(), "Events");
				
		WebElement graphicLink= createWebElementBy(lnk_graphic);
		graphicLink.click();
		waitForPageLoaded();
		WebElement graphicPane= createWebElementBy(graphic_pane);
		assertEquals(graphicPane.getText(), "Graphic Library");
		takeScreenshotAtEndOfTest();
	}
	public void TM_FCGxPHistorian_S02_Web_PiwebapiUrlVerification() {
		waitForPageLoaded();
		List<WebElement> PiwebapiUrl= createWebElementsBy(lnk_Piwebapi);
		assertEquals(PiwebapiUrl.get(0).getText(), "https://fcvisiong.na.gilead.com/piwebapi/");
		assertEquals(PiwebapiUrl.get(1).getText(), "https://fcvisiong.na.gilead.com/piwebapi/assetservers");
		assertEquals(PiwebapiUrl.get(2).getText(), "https://fcvisiong.na.gilead.com/piwebapi/dataservers");
		assertEquals(PiwebapiUrl.get(3).getText(), "https://fcvisiong.na.gilead.com/piwebapi/omf");
		assertEquals(PiwebapiUrl.get(4).getText(), "https://fcvisiong.na.gilead.com/piwebapi/search");
		assertEquals(PiwebapiUrl.get(5).getText(), "https://fcvisiong.na.gilead.com/piwebapi/system");
		takeScreenshotAtEndOfTest();
		
		
	}
		
		

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
