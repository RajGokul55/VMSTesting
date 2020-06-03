package com.qa.wave2;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LDP extends CommonMethods {
	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String TstUrl = "http://gileadappstest/ldp/ldp/index";

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


	String URL = TstUrl;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
	}
	
	@Test(priority=1, enabled=true)
	public void LDP_S01_Web_Validate_Tabs() {
		TM_S01_Web_Validate_Tabs();
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
	
	By txt_hometext 		=	By.xpath("//h1[@class='M_title']");
	By lnk_erd				=	By.xpath("//a[@class='ERDInstruction']");
	By lnk_currpartpants	=	By.xpath("//a[@class='participants']");
	By lnk_graduates		=	By.xpath("//a[@class='graduates']");
	By lnk_terminates		=	By.xpath("//a[@class='terminated']");
	By lnk_more				=	By.xpath("//a[@class='more']");
	By lnk_clckhere			=	By.xpath("//a[contains(text(),'Click here')]");
	By txt_pageTitle		=	By.xpath("//h2[@class='M_page-title']");
	By lnk_manageaccess		=	By.xpath("//a[contains(text(),'Manage Access')]");
	
	
	
	
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	public void TM_S01_Web_Validate_Tabs() {
		waitForPageLoaded();
		
		WebElement HomeText_Txt = createWebElementBy(txt_hometext);
		String home = "Leadership Development Program";
		Assert.assertTrue(HomeText_Txt.getText().equalsIgnoreCase(home), "The Homepage is not loaded");
		
		WebElement ERD_Lnk = createWebElementBy(lnk_erd);
		ERD_Lnk.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		WebElement ClickHere_Lnk = createWebElementBy(lnk_clckhere);
		Assert.assertTrue(ClickHere_Lnk.isDisplayed(), "The page is not loaded successfully");
		
		WebElement CurrentParticipants_Lnk = createWebElementBy(lnk_currpartpants);
		CurrentParticipants_Lnk.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		String CurrentParticipants_Txt = verify();
		Assert.assertEquals(CurrentParticipants_Txt, "Current Participants");
		
		WebElement Graduates_Lnk = createWebElementBy(lnk_graduates);
		Graduates_Lnk.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		String Graduates_Txt = verify();
		Assert.assertEquals(Graduates_Txt, "Graduates");
		
		WebElement Terminated_Lnk = createWebElementBy(lnk_terminates);
		Terminated_Lnk.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		String Terminated_Txt = verify();
		Assert.assertEquals(Terminated_Txt, "Terminated");
		
		WebElement More_Lnk = createWebElementBy(lnk_more);
		More_Lnk.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		String More_Txt = verify();
		Assert.assertEquals(More_Txt, "More");
		WebElement ManageAccess_Lnk = createWebElementBy(lnk_manageaccess);
		Assert.assertTrue(ManageAccess_Lnk.isDisplayed(), "The Manage tab is not displayed");
		
		
	}
	
	/********************************Generic methods********************************/
	
	public String verify() {
		WebElement PageTitle_Txt = createWebElementBy(txt_pageTitle);
		return PageTitle_Txt.getText();
		
	}

}
