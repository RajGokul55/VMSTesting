package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class CBT extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String Url = "https://sjgbasappdevn01.na.gilead.com/CommercialBT";
	final String Url_Dev = "https://sjgbasappdevn01.na.gilead.com/CommercialBT";
	final String Url_UAT = "https://sjgbasappuatn01.na.gilead.com/CommercialBT";
	final String Url_Prod = "https://sjcogsappprdn01.na.gilead.com/CommercialBT/";
	final String Url_Prod_Base = "https://sjgbasappprdn01.na.gilead.com/GBASPortal/Home/Index";

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

	@Test(priority = 1, enabled = true) 
	public void CBT_S01_Windows_Web_All_Lots_Tab_Verfication() {
		TM_CBT_S01_Windows_Web_All_Lot_Tab_Verfication();
	}

	@Test(priority = 2, enabled = true) 
	public void CBT_S02_Windows_Web_All_Open_Lots_Tab_Verfication() {
		TM_CBT_S02_Windows_Web_All_open_Lot_Verfication();
	}

	@Test(priority = 3, enabled = false) 
	public void CBT_S03_Windows_Web_Edit_AutomatedRecord_SupplyChain() {
		TM_CBT_S03_Windows_Web_Edit_AutomatedRecord_SupplyChain();
	}

	@Test(priority = 4, enabled = false) 
	public void CBT_S04_Windows_Web_Edit_AutomatedRecord_Production() {
		TM_CBT_S04_Windows_Web_Edit_AutomatedRecord_Production();
	}

	@Test(priority = 5, enabled = false) 
	public void CBT_S05_Windows_Web_Edit_AutomatedRecord_QADisp() {
		TM_CBT_S05_Windows_Web_Edit_AutomatedRecord_QADisp();
	}

	@Test(priority = 6, enabled = false) 
	public void CBT_S06_Windows_Web_Settings_All_tab_Verification() {
		TM_CBT_S06_Windows_Web_Settings_All_tab_Verification();
	}

	@AfterClass
	void Teardouwn() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */

	By btn_View = By.cssSelector(".navicon");
	By lnk_All_open_lots = By.cssSelector("#crust1");
	By lnk_All_lots = By.cssSelector("#crust10");
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
	By lnk_PrjectManagement = By.cssSelector("#PMLink");
	By txt_contact = By.xpath("//*[@class='labelDiv' and contains(text(),'Contact')]");
	By btn_Edit = By.cssSelector("#editButton");
	By btn_Save = By.cssSelector("#saveButton");
	By txt_box_Comments = By.cssSelector(".form-control.comment");
	By txt_VMSTest = By.xpath("(//td[contains(text(),'VMS')])[1]");
	By lnk_Setting = By.cssSelector("span[class='glyphicon glyphicon-cog']");
	By lnk_User = By.cssSelector("#UserLink");
	By txt_User = By.xpath("//*[contains(text(),'Users without access')]");
	By lnk_AssignRoles = By.cssSelector("#RoleassignedLink");
	By txt_AssignRoles = By.xpath("//b[contains(text(),'Assign Roles')]");
	By lnk_AddProduct = By.cssSelector("#ProductLink");
	By txt_ProductName = By.xpath("//*[contains(text(),'Product Names not Added')]");
	By lnk_Target = By.cssSelector("#CTTLink");
	By txt_MaintainTarget = By.xpath("//*[contains(text(),'Maintain Target & Tolerance')]");
	By lnk_Metadata = By.cssSelector("#MetadataLink");
	By txt_MaintainMetadata = By.xpath("//strong[contains(text(),'Maintain MetaData')]");
	By lnk_Countries = By.cssSelector("#RegionsLink");
	By txt_AssignCountries = By.xpath("//b[contains(text(),'Assign Countries')]");
	By lnk_SCT = By.cssSelector("#SCTLink");
	By txt_ListOfIndication = By.xpath("//*[contains(text(),' List of Indication Codes and GSREF #s')]");
	By Img_CBT = By.cssSelector("img[src='../images/CBT.png']");

	/***************************** Test Case Methods *******************/


	public void TM_CBT_S01_Windows_Web_All_Lot_Tab_Verfication(){

		launchBrowser(Browser, Url_Dev);
		waitForPageLoaded();
		//Prod
		//		createWebElementBy(Img_CBT).click();
		//		windowhandle();
		//		driver.manage().window().maximize();
		//		waitForPageLoaded();
		createWebElementBy(btn_View).click();
		createWebElementBy(lnk_All_lots).click();
		waitForPageLoaded();
		application_Tab_Verification();
	}

	public void TM_CBT_S02_Windows_Web_All_open_Lot_Verfication(){

		createWebElementBy(btn_View).click();
		createWebElementBy(lnk_All_open_lots).click();
		waitForPageLoaded();
		application_Tab_Verification();
	}

	public void TM_CBT_S03_Windows_Web_Edit_AutomatedRecord_SupplyChain() {
		edit_Record(lnk_SupplyChain);
	}

	public void TM_CBT_S04_Windows_Web_Edit_AutomatedRecord_Production() {
		edit_Record(lnk_Production);
	}

	public void TM_CBT_S05_Windows_Web_Edit_AutomatedRecord_QADisp() {
		edit_Record(lnk_QADisp);
	}

	public void TM_CBT_S06_Windows_Web_Settings_All_tab_Verification() {

		createWebElementBy(lnk_Setting).click();
		waitForPageLoaded();
		pageText_Assertion(lnk_User, txt_User, "Users without access");
		pageText_Assertion(lnk_AssignRoles, txt_AssignRoles, "Assign Roles");
		pageText_Assertion(lnk_AddProduct, txt_ProductName, "Product Names not Added");
		pageText_Assertion(lnk_Target, txt_MaintainTarget, "Maintain Target & Tolerance");
		pageText_Assertion(lnk_Metadata, txt_MaintainMetadata, "Maintain MetaData");
		pageText_Assertion(lnk_Countries, txt_AssignCountries, "Assign Countries");
		pageText_Assertion(lnk_SCT, txt_ListOfIndication, "List of Indication Codes and GSREF #s");
	}

	/********************************* Common Methods *************************************/

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

	void edit_Record(By tab) {

		createWebElementBy(tab).click();
		createWebElementBy(btn_Edit).click();
		createWebElementBy(txt_box_Comments).sendKeys("VMS Test");
		createWebElementBy(btn_Save).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(txt_VMSTest).getText(), "VMS Test");		
	}

}