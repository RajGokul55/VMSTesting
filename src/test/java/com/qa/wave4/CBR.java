package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class CBR extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String Url = "https://sjgbasappdevn01.na.gilead.com/GBASApplication";
	final String Url_Dev = "https://sjgbasappdevn01.na.gilead.com/GBASApplication";
	final String Url_UAT = "https://sjgbasappuatn01.na.gilead.com/CBRApplication";
	final String Url_Prod = "https://sjgbasappprdn01.na.gilead.com/GBASPortal/Home/";


	/***************************** Test Cases *******************************/
	/*
	 * Test case ˜Test Name™ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, TCNumber: Test
	 * case number [Numeric 2-3 digits] i.e, 01, 02,.. TestCategory: Test case
	 * category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB
	 * â€¦] Title: short title of test case based on context of test case ie.,
	 * ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails. Test
	 * method name must be same as test case appended with TM example:
	 */

	@BeforeMethod
	void Setup() {
		launchBrowser(Browser, Url);
	}

	@Test(priority = 0, enabled = false)
	public void CBR_S01_Windows_Web_URL_Verfication() {
		TM_CBR_S01_Windows_Web_URL_Verfication();
	}

	@Test(priority = 1, enabled = true) 
	public void CBR_S02_Windows_Web_Tab_Verfication() {
		TM_CBR_S02_Windows_Web_All_Lot_Tab_Verfication();
	}
	
	@Test(priority = 2, enabled = true) 
	public void CBR_S03_Windows_Web_Tab_Verfication() {
		TM_CBR_S03_Windows_Web_All_open_Lot_Verfication();
	}

	@AfterMethod
	void Teardouwn() {
		driver.close();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */

	By btn_Menu = By.cssSelector(".navicon");
	By lnk_All_open_lots = By.cssSelector("#crust1");
	By lnk_SupplyChain_menu = By.cssSelector("#crust2");
	By lnk_All_lots = By.cssSelector("#crust10");
	By lnk_RandomRecord = By.xpath("(//*[contains(text(), 'PC')])[2]");
	By lnk_General = By.cssSelector("#GeneralLink");
	By txt_RecordName = By.xpath("//*[contains(text(),'Record Type')]");
	By lnk_SupplyChain = By.cssSelector("#scLink");
	By txt_JobRequested = By.xpath("//*[contains(text(),'Job Requested')]");
	By lnk_Production = By.cssSelector("#ProductionLink");
	By lnk_Testing = By.cssSelector("#TestingLink");
	By txt_ProductionComp = By.xpath("//*[contains(text(),'Production Comp')]");
	By lnk_Review = By.cssSelector("#ReviewLink");
	By lnk_QADisp = By.cssSelector("#QADispLink");
	By txt_ReviewCompleted = By.xpath("//*[contains(text(),'Review Completed')]");
	By lnk_MTR = By.cssSelector("#MTRLink");
	By lnk_QP = By.cssSelector("#QPLink");
	By lnk_PrjectManagement = By.cssSelector("#PMLink");
	By txt_contact = By.xpath("//*[@class='labelDiv' and contains(text(),'Contact')]");

	/***************************** Test Case Methods *******************/

	void TM_CBR_S01_Windows_Web_URL_Verfication() {

		title_Assertion("CBR App - General");
	}

	public void TM_CBR_S02_Windows_Web_All_Lot_Tab_Verfication(){

		before_Tab_Varificatio(lnk_All_lots);
		application_Tab_Verification();
		Assert.assertTrue(createWebElementBy(lnk_MTR).isEnabled());
		Assert.assertTrue(createWebElementBy(lnk_QP).isEnabled());
	}

	public void TM_CBR_S03_Windows_Web_All_open_Lot_Verfication(){

		before_Tab_Varificatio(lnk_All_open_lots);
		application_Tab_Verification();

	}
	/********************************* Common Methods *************************************/

	public void title_Assertion(String ExpectedTitle) {

		waitForPageLoaded();
		String Title = driver.getTitle();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(Title, ExpectedTitle);		
	}

	public void before_Tab_Varificatio(By menu_Element) {
		
		createWebElementBy(btn_Menu).click();
		WebElement Type_Of_lots = createWebElementBy(menu_Element);
		mouseHover(Type_Of_lots);
		Type_Of_lots.click();
		waitForPageLoaded();
		createWebElementBy(lnk_RandomRecord).click();
		waitForPageLoaded();
	}
	
	public void application_Tab_Verification() {

		pageText_Assertion(lnk_General, txt_RecordName, "Record Type");
		pageText_Assertion(lnk_SupplyChain, txt_JobRequested, "Job Requested");		
		pageText_Assertion(lnk_Production, txt_ProductionComp, "Production Comp");
		pageText_Assertion(lnk_Testing, txt_ProductionComp, "Production Comp");
		pageText_Assertion(lnk_Review, txt_ReviewCompleted, "Review Completed");
		pageText_Assertion(lnk_QADisp, txt_ReviewCompleted, "Review Completed");
		scrollToBottomOfHTML();
		pageText_Assertion(lnk_PrjectManagement, txt_contact, "Contact");
	}

	public void pageText_Assertion(By element_link, By element_txt, String Expected ) {

		createWebElementBy(element_link).click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(createWebElementBy(element_txt).getText(), Expected);
	}




}
