package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class TestApp extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://www.flipkart.com/";
	final String Username ="8805485782";
	final String InvalidPassword = "hdgd@54";


	/***************************** Test Cases *******************/
	/*
	 * Test case ‘Test Name’ naming convention: <AppName><TCNumber>_<TestCategory>_<Title>
	Definitions of terms:     
•	AppName: short name of Application [String 5 -10 chars] i.e., TstMyApp, 
•	TCNumber: Test case number [Numeric 2-3 digits] i.e, 01, 02,..
•	TestCategory: Test case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB …]
•	Title: short title of test case based on context of test case  ie., ValidateCredntails
  	Test Name Example: Filkart_05_Web_ValidateCredntails.

	 * Test method name must be same as test case appended with TM example: 
	 */

	@BeforeTest
	public void beforeTest() {
		launchbrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void Filkart_05_Web_ValidateCredntails() {
		TM_Filkart_05_Web_ValidateCredntails();
	}

	@Test(priority=1, enabled=true)
	public void Filkart_03_Web_ValidatemenuItems() {
		TM_Filkart_03_Web_ValidatemenuItems();
	}

	@AfterTest
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

	By ipt_Username= By.xpath("//input[@class= '_2zrpKA _1dBPDZ']");
	By ipt_Passwrod= By.cssSelector("input[class='_2zrpKA _3v41xv _1dBPDZ']");
	By btn_Submit = By.cssSelector("button[class= '_2AkmmA _1LctnI _7UHT_c']");
	By msg_Warning = By.cssSelector("span[class='ZAtlA-']>span");
	By menu_Items= By.cssSelector("ul[class='_114Zhd']>li");
	By btn_Close = By.cssSelector("button[class='_2AkmmA _29YdH8']");
	By menu_TVAppliance= By.cssSelector("li:nth-child(2)>span[class='_1QZ6fC _3Lgyp8']");
	By lnk_Samsung= By.cssSelector("a[title='Samsung'][href^='/televisions/pr']");

	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn

	void TM_Filkart_05_Web_ValidateCredntails() {

		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(InvalidPassword);

		WebElement Submit_Btn = createWebElementBy(btn_Submit);
		Submit_Btn.click();

		WebElement Error_Msg = createWebElementBy(msg_Warning);
		Assert.assertEquals(Error_Msg.getText(), "Your username or password is incorrect");

	}

	void TM_Filkart_03_Web_ValidatemenuItems() {

		WebElement Close_Btn = createWebElementBy(btn_Close);
		Close_Btn.click();

		List<WebElement> Items_Menu = createWebElementsBy(menu_Items);
		for(int i=0; i<Items_Menu.size(); i++) {
			System.out.println("Menu item "+Items_Menu.get(i).getText()+" is displayed" );
		}

		WebElement TV_Menu = createWebElementBy(menu_TVAppliance);
		mouseHover(TV_Menu);

		WebElement Samsung_lnk = createWebElementBy(lnk_Samsung);
		//Samsung_lnk.click();
		domClick(Samsung_lnk);

		waitForPageLoaded();

	}


	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here
}
