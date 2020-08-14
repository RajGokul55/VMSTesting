package com.qa.wave4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class GVMS extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String Url = "https://sjgbasappdevn01.na.gilead.com/MaterialQuery/";
	final String Url_Dev = "https://sjgbasappdevn01.na.gilead.com/MaterialQuery/";
	final String Url_UAT = "https://sjgbasappuatn01.na.gilead.com/GVMS3/";
	final String Url_Prod = "https://sjgvmsappprdn01.na.gilead.com/GVMS3/";


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
	void setUp() {
		launchBrowser(Browser, Url_Dev);
	}

	@Test(priority = 0, enabled = true, groups = {"Prod", "UAT", "Dev"})
	public void GVMS_S01_Windows_Web_URL_Verfication() {
		TM_GVMS_S01_Windows_Web_URL_Verfication();
	}

	@Test(priority = 1, enabled = true, groups = {"Prod", "UAT", "Dev"}) 
	public void GVMS_S02_Windows_Web_Tab_Verfication() {
		TM_GVMS_S02_Windows_Web_All_Lot_Tab_Verfication();
	}

	@Test(priority = 2, enabled = true, groups = {"Dev"}) 
	public void GVMS_S03_Windows_Web_Setting_Tabs_Verification() {
		TM_GVMS_S03_Windows_Web_Setting_Tabs_Verification();
	}
	
	@Test(priority = 3, enabled = true, groups = {"Dev"}) 
	public void GVMS_S04_Windows_Web_Entry_Search_Verification() {
		TM_GVMS_S04_Windows_Web_Entry_Search_Verification();
	}

	@AfterMethod
	void Teardown() {
		driver.close();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */


	By lnk_Program = By.cssSelector("#Program");
	By lnk_Material = By.cssSelector("#Material");
	By btn_Create = By.cssSelector(".btn.btn-default.btn-cyan");
	By lnk_Supplier = By.cssSelector("#Supplier");
	By lnk_RMNumber = By.xpath("(//*[contains(text(),'RM or IP Number')])[1]");
	By lnk_MaterialAssociations = By.cssSelector("#Prgmassoc");
	By lnk_SupplierAssociations = By.cssSelector("#Siteassoc");
	By lnk_Setting = By.cssSelector("#Setting");
	By lnk_Users = By.cssSelector("a[class='active selected']");
	By txt_TabTitle = By.cssSelector(".titlefontsize.heasertitle");
	By lnk_AssignRoles = By.cssSelector("a[id='UserLink'][data-href='/MaterialQuery/Home/AssignRoles']");
	By lnk_MaintainActivity = By.cssSelector("#acassoc");
	By txt_TabTitleMaintain = By.cssSelector(".titlefontsize.heasertitle.marginpadottom5");
	By lnk_MaintainProgram = By.cssSelector("#activityassoc");	
	By lnk_ManualFPRecord = By.xpath("(//*[@class='hidecol' and contains(text(),'Manual')])[2]//following::a[contains(text(),'FP')][1]");
	By txt_box_ProgramName = By.cssSelector("#PROGRAM_NAME");
	By btn_CreateProgram = By.cssSelector("#createprogram");
	By txt_box_Search = By.cssSelector("input[class='form-control']");
	By btn_Search = By.cssSelector(".glyphicon.glyphicon-search");
	By lnk_SearchVMS = By.xpath("//*[contains(text(),'VMS Test')]");
	By txt_ProgramName = By.xpath("(//a[contains(text(),'Program Name')])[1]");
	By txt_MaterialName = By.xpath("(//a[contains(text(),'Material Name')])[1]");
	By txt_SupplierName = By.xpath("(//a[contains(text(),'Supplier Name')])[1]");
	
	
	/***************************** Test Case Methods *******************/

	void TM_GVMS_S01_Windows_Web_URL_Verfication() {

		waitForPageLoaded();
		String Title = driver.getTitle();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(Title, "GVMS Application - PO");
	}

	public void TM_GVMS_S02_Windows_Web_All_Lot_Tab_Verfication(){

		tab_Assertion(lnk_Program, txt_ProgramName, "Program Name");
		tab_Assertion(lnk_Material, lnk_RMNumber, "RM or IP Number");
		tab_Assertion(lnk_Supplier, txt_SupplierName, "Supplier Name");
		tab_Assertion(lnk_MaterialAssociations, txt_ProgramName, "Program Name");
		tab_Assertion(lnk_SupplierAssociations, txt_ProgramName, "Program Name");
	}

	public void TM_GVMS_S03_Windows_Web_Setting_Tabs_Verification(){

		createWebElementBy(lnk_Setting).click();
		waitForPageLoaded();
		tab_Assertion(lnk_Users, txt_TabTitle, "Add/Delete Users");
		tab_Assertion(lnk_AssignRoles, txt_TabTitle, "Assign Roles");
		tab_Assertion(lnk_MaintainActivity, txt_TabTitleMaintain, "Maintain Activity Category to Activity Associations");
		tab_Assertion(lnk_MaintainProgram, txt_TabTitleMaintain, "Maintain Program-Activity Categories to Activity Associations");
	}
	
	void TM_GVMS_S04_Windows_Web_Entry_Search_Verification() {
		
		createWebElementBy(lnk_Program).click();
		waitForPageLoaded();
		createWebElementBy(txt_box_Search).sendKeys("VMS Test");
		createWebElementBy(btn_Search).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(lnk_SearchVMS).getText(), "VMS Test");
	}
	/********************************* Common Methods *************************************/

	void tab_Assertion(By element1, By element2, String expected_Text) {

		createWebElementBy(element1).click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(createWebElementBy(element2).getText(), expected_Text);
	}

}
