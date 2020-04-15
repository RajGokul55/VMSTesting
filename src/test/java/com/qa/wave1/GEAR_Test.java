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
import org.testng.Reporter;

public class GEAR_Test extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url_GileadInterface = "https://fcmegapptstn01.na.gilead.com/published";

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

	@BeforeMethod
	public void beforeTest() {
		launchBrowser(Browser, Url_GileadInterface);
	}

	@Test(priority = 0, enabled = true)
	public void Gear_TC03_Web_GileadInterface_Tab_Availability() {
		TM_Gear_TC03_Web_GileadInterface_Tab_Availability();
	
	}
	
	@Test(priority = 1, enabled= true)
	public void Gear_TC04_Web_GileadInterface_Navigation_Verification() {
		
		TM_Gear_TC04_Web_GileadInterface_Navigation_Verification();
	}

	@AfterMethod(enabled=true)
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
	By txt_systemList= By.xpath("//span[text()='Systems List']");
	By msg_heading = By.cssSelector(".bg h1");
	By lnk_gear = By.linkText("GEAR");


	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	void TM_Gear_TC03_Web_GileadInterface_Tab_Availability() {
		WebElement frame = createWebElementBy(frm_frame);
		switchToFrameByLocator(frame);

		  List<WebElement> Items_Menu = createWebElementsBy(lnk_tabs);
		  for(int i=0;i<Items_Menu.size(); i++) {
		  Reporter.log("Menu item "+Items_Menu.get(i).getText()+" is displayed"); 
		  //Assert.assertTrue(IsDisplayed_IsEnabled(Items_Menu.get(i)));
		  IsDisplayed_IsEnabled(Items_Menu.get(i));
		  
		  }

	}
	void TM_Gear_TC04_Web_GileadInterface_Navigation_Verification() {
		waitForPageLoaded();
		WebElement frame = createWebElementBy(frm_frame);
		switchToFrameByLocator(frame);
		WebElement systemLink= createWebElementBy(lnk_systems);
		WebElement systemList= createWebElementBy(txt_systemList);
		
		mouseHover(systemLink);
		waitForPageLoaded();
		systemList.click();
		
		WebElement pageHeading = createWebElementBy(msg_heading);
		Assert.assertEquals(pageHeading.getText(), "Alphabetical list of Systems");
		
		WebElement gearLink= createWebElementBy(lnk_gear);
		IsDisplayed_IsEnabled(gearLink);
		//Assert.assertTrue(IsDisplayed_IsEnabled(gearLink));

	}


	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here
}
