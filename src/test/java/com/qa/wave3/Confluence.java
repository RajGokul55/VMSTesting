package com.qa.wave3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import junit.framework.Assert;

public class Confluence extends CommonMethods {
	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String PrdURL = "https://wiki.gilead.com";

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


	String URL = PrdURL;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
	}
	
	@Test(priority=1, enabled=true)
	public void BSKCS_S01_Web_Validate_Homepage() {
		TM_S01_Web_Validate_Homepage();
	}
	
	@Test(priority=2, enabled=true)
	public void BSCKS_S02_Web_Validate_Edit_Space() {
		TM_S02_Web_Validate_Edit_Space();
	}
	
	@Test(priority=3, enabled=true)
	public void BSCKS_S03_Web_Validate_People() {
		TM_S02_Web_Validate_People();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
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
	 * txt_: Text
	 * crd_: Card
	 */
	
	By btn_logo			=	By.xpath("//span[@class='aui-header-logo-device']");
	By lnk_spaces		=	By.xpath("//a[@id='space-menu-link']");
	By lnk_allspaces	=	By.xpath("//a[@id='view-all-spaces-link']");
	By lnk_ittesting	=	By.cssSelector("a[title*='IT Testing']");
	By btn_edit			=	By.xpath("//div[1]/ul[1]/li[1]/a[1]/span[1]/span[1]");
	By txt_type			=	By.xpath("//p[@class='auto-cursor-target']");
	By btn_update		=	By.cssSelector("#edag-update-button");
	By btn_people		=	By.xpath("//span[contains(text(),'People')]");
	
	
	

	
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	public void TM_S01_Web_Validate_Homepage() {
		WebElement Logo_Btn = createWebElementBy(btn_logo);
		IsDisplayed_IsEnabled(Logo_Btn);
	}
	
	public void TM_S02_Web_Validate_Edit_Space() {
		WebElement Spaces_Lnk = createWebElementBy(lnk_spaces);
		Spaces_Lnk.click();
		
		WebElement AllSpaces_Lnk = createWebElementBy(lnk_allspaces);
		AllSpaces_Lnk.click();
		
		WebElement ITTesting_Lnk = createWebElementBy(lnk_ittesting);
		ITTesting_Lnk.click();
		
		WebElement Edit_Btn = createWebElementBy(btn_edit);
		Edit_Btn.click();
		
		WebElement Frame1 = driver.findElement(By.xpath("//iframe[@id='wysiwygTextarea_ifr']"));
		driver.switchTo().frame(Frame1);
		
		WebElement Type_Txt = createWebElementBy(txt_type);
		Type_Txt.clear();
		Type_Txt.sendKeys("Post Patch Testing VMS");
		
		driver.switchTo().defaultContent();
		
		WebElement Update_Btn = createWebElementBy(btn_update);
		Update_Btn.click();	
		
	}
	
	public void TM_S02_Web_Validate_People() {
		WebElement People_Btn = createWebElementBy(btn_people);
		People_Btn.click();
		
		Assert.assertEquals("People Directory - Gilead Wiki", driver.getTitle());
	}
}
