package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
	final String Url_Prod = "https://sjgbasappprdn01.na.gilead.com/CBRApplication/";
	final String Url_Prod_Base = "https://sjgbasappprdn01.na.gilead.com/GBASPortal/Home/";


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
	public void CBR_S01_Windows_Web_Tab_Verfication() {
		TM_CBR_S01_Windows_Web_All_Lot_Tab_Verfication();
	}
	
	@Test(priority = 2, enabled = true) 
	public void CBR_S02_Windows_Web_Tab_Verfication() {
		TM_CBR_S02_Windows_Web_All_open_Lot_Verfication();
	}
	
	@Test(priority = 3, enabled = true) 
	public void CBR_S03_Windows_Web_Edit_AutomatedRecord_SupplyChain() {
		TM_CBR_S03_Windows_Web_Edit_AutomatedRecord_SupplyChain();
	}
	
	@Test(priority = 4, enabled = true) 
	public void CBR_S04_Windows_Web_Edit_AutomatedRecord_Production() {
		TM_CBR_S04_Windows_Web_Edit_AutomatedRecord_Production();
	}
	
	@Test(priority = 5, enabled = true) 
	public void CBR_S05_Windows_Web_Edit_AutomatedRecord_QADisp() {
		TM_CBR_S05_Windows_Web_Edit_AutomatedRecord_QADisp();
	}
	
	@Test(priority = 6, enabled = true) 
	public void CBR_S06_Windows_Web_Edit_ManualRecord_SupplyChain() {
		TM_CBR_S06_Windows_Web_Edit_ManualRecord_SupplyChain();
	}
	
	@Test(priority = 7, enabled = true) 
	public void CBR_S07_Windows_Web_Edit_ManualRecord_Production() {
		TM_CBR_S07_Windows_Web_Edit_ManualRecord_Production();
	}
	
	@Test(priority = 8, enabled = true) 
	public void CBR_S08_Windows_Web_Edit_ManualRecord_QADisp() {
		TM_CBR_S08_Windows_Web_Edit_ManualRecord_QADisp();
	}
	
	@Test(priority = 9, enabled = true) 
	public void CBR_S09_Windows_Web_Settings_All_tab_Verification() {
		TM_CBR_S09_Windows_Web_Settings_All_tab_Verification();
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
	By lnk_MTR = By.cssSelector("#MTRLink");
	By lnk_QP = By.cssSelector("#QPLink");
	By lnk_PrjectManagement = By.cssSelector("#PMLink");
	By txt_contact = By.xpath("//*[@class='labelDiv' and contains(text(),'Contact')]");
	By txt_box_Search = By.cssSelector("#search");
	By btn_Search = By.cssSelector("button[type='submit']");
	By lnk_Manual_FP_Record = By.xpath("((//td[@title='Manual'])[1]//following-sibling::td//a)[1]");
	By lnk_Automatic_FP_Record = By.xpath("((//td[@title='Automatic'])[1]//following-sibling::td//a)[1]");
	By btn_Edit = By.cssSelector("#editButton");
	By btn_Save = By.cssSelector("#saveButton");
	By txt_box_Comments = By.cssSelector(".form-control.comment");
	By txt_VMSTest = By.xpath("(//td[contains(text(),'VMS')])[1]");
	By lnk_Header_MTR = By.xpath("(//a[contains(text(),'MTR #')])[3]");
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
			
	/***************************** Test Case Methods *******************/


	public void TM_CBR_S01_Windows_Web_All_Lot_Tab_Verfication(){

		launchBrowser(Browser, Url_Dev);
		before_Tab_Verification(lnk_All_lots);
		createWebElementBy(lnk_Header_MTR).click();
		waitForPageLoaded();
		createWebElementBy(lnk_Header_MTR).click();
		waitForPageLoaded();
		application_Tab_Verification();
		pageText_Assertion(lnk_MTR, txt_contact, "Contact");
		scrollToBottomOfHTML();
		pageText_Assertion(lnk_QP, txt_contact, "Contact");
	}

	public void TM_CBR_S02_Windows_Web_All_open_Lot_Verfication(){

		before_Tab_Verification(lnk_All_open_lots);
		waitForPageLoaded();
		application_Tab_Verification();
	}
	
	public void TM_CBR_S03_Windows_Web_Edit_AutomatedRecord_SupplyChain() {
		before_Tab_Verification(lnk_All_open_lots);
		edit_Record(lnk_Automatic_FP_Record, lnk_SupplyChain);
	}
	 
	public void TM_CBR_S04_Windows_Web_Edit_AutomatedRecord_Production() {
		edit_Record(lnk_Automatic_FP_Record, lnk_Production);
	}
	
	public void TM_CBR_S05_Windows_Web_Edit_AutomatedRecord_QADisp() {
		edit_Record(lnk_Automatic_FP_Record, lnk_QADisp);
	}
	 
	public void TM_CBR_S06_Windows_Web_Edit_ManualRecord_SupplyChain() {
		edit_Record(lnk_Manual_FP_Record, lnk_SupplyChain);
	}
	 
	public void TM_CBR_S07_Windows_Web_Edit_ManualRecord_Production() {
		edit_Record(lnk_Manual_FP_Record, lnk_Production);
	}
	
	public void TM_CBR_S08_Windows_Web_Edit_ManualRecord_QADisp() {
		edit_Record(lnk_Manual_FP_Record, lnk_QADisp);
	}
	
	public void TM_CBR_S09_Windows_Web_Settings_All_tab_Verification() {
		
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

	public void before_Tab_Verification(By view_Element) {
		
		createWebElementBy(btn_View).click();
		WebElement Type_Of_View = createWebElementBy(view_Element);
		mouseHover(Type_Of_View);
		Type_Of_View.click();
		waitForPageLoaded();
		createWebElementBy(txt_box_Search).sendKeys("FP-");
		createWebElementBy(btn_Search).click();
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

	void edit_Record(By record, By tab) {
		
		createWebElementBy(record).click();
		waitForPageLoaded();
		createWebElementBy(tab).click();
		createWebElementBy(btn_Edit).click();
		createWebElementBy(txt_box_Comments).sendKeys("VMS Test");
		createWebElementBy(btn_Save).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(txt_VMSTest).getText(), "VMS Test");		
	}

}
