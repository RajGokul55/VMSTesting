package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class COGs extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String Url = "https://sjgbasappdevn01.na.gilead.com/COGsCal/";
	final String Url_Dev = "https://sjgbasappdevn01.na.gilead.com/COGsCal/";
	final String Url_UAT = "https://sjgbasappuatn01.na.gilead.com/COGsCal/";
	final String Url_Prod = "https://sjcogsappprdn01.na.gilead.com/COGsCal/";
	
	final String Username = "psonawane";
	private String DecrptPassword;

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
	void setup() {
		launchBrowser(Browser, Url_Dev);
		userLogin();
	}

	@Test(priority = 0, enabled = true, groups = {"Prod", "UAT", "Dev"})
	public void COGs_S01_Windows_Web_URL_Verfication() {
		TM_COGs_S01_Windows_Web_URL_Verfication();
	}

	@Test(priority = 1, enabled = true, groups = {"Prod", "UAT", "Dev"}) 
	public void COGs_S02_Windows_Web_Tab_Verfication() {
		TM_COGs_S02_Windows_Web_Tab_Verfication();
	}

	@Test(priority = 2, enabled = true, groups = {"Dev"}) 
	public void COGs_S03_Windows_Web_Project_Creation() {
		TM_COGs_S03_Windows_Web_Project_Creation();
	}
	
	@Test(priority = 3, enabled = true, groups = {"Dev"}) 
	public void COGs_S04_Windows_Web_Project_Modification() {
		TM_COGs_S04_Windows_Web_Project_Modification();
	}

	@AfterMethod
	void teardown() {
		driver.close();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */


	By txt_box_username = By.cssSelector("input[name='username']");
	By txt_box_password = By.cssSelector("input[name='password']");
	By btn_login = By.xpath("//button[contains(text(),'Login')]");
	By lnk_CurrentCostingSheet = By.xpath("//a[contains(text(),'Current Costing Sheet')]");
	By lnk_RawMaterial = By.xpath("//a[contains(text(),'Raw Material')]");
	By txt_Project = By.xpath("//td[contains(text(),'Project')]");
	By txt_RawMaterial = By.xpath("//h4[contains(text(),'Raw Material')]");
	By rdo_Create = By.xpath("//span[contains(text(),'Create')]");
	By txt_box_ProjectName = By.xpath("(//Input[@class='ng-untouched ng-pristine ng-valid'])[1]");
	By txt_box_SheetName = By.xpath("(//Input[@class='ng-untouched ng-pristine ng-valid'])");
	By btn_CreateProject = By.cssSelector(".btn.btn-sm.btn-success");
	By rdo_Modify = By.xpath("//span[contains(text(),'Modify')]");
	By btn_Save = By.xpath("(//*[@class='btn btn-sm btn-success btncolor'])[1]");
	By btn_Delete = By.xpath("(//*[@class='btn btn-sm btn-danger'])[1]");
	By txt_box_Modify_Project = By.xpath("(//*[@class='ng-untouched ng-pristine ng-valid'])[1]");
	By txt_box_Modify_Year = By.xpath("(//*[@class='ng-untouched ng-pristine ng-valid'])[2]");
	By txt_box_Modify_Sheet = By.xpath("(//*[@class='ng-untouched ng-pristine ng-valid'])");
	By btn_Load = By.cssSelector(".btn.btn-sm.btn-success");
	By txt_box_MolarWt = By.xpath("(//*[@class='ng-untouched ng-pristine ng-valid'])[2]");
	By txt_box_StartingMW = By.xpath("(//*[@class='ng-untouched ng-pristine ng-valid'])[3]");
	By btn_Confirmation_Ok = By.cssSelector("#okButton");
	By txt_VMS_Test = By.xpath("//h4[contains(text(),'VMS')]");
	By txt_MW_Ratio = By.xpath("(//input[@class='ng-untouched ng-pristine'])[1]");
	By txt_StartingMW = By.xpath("(//*[@class='ng-untouched ng-pristine ng-valid'])[4]");
	
	/***************************** Test Case Methods *******************/

	void TM_COGs_S01_Windows_Web_URL_Verfication() {

		waitForPageLoaded();
		String Title = driver.getTitle();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(Title, "COGs");
	}

	public void TM_COGs_S02_Windows_Web_Tab_Verfication(){

		tab_Assertion(lnk_CurrentCostingSheet, txt_Project, "Project:");
		waitForPageLoaded();
		tab_Assertion(lnk_RawMaterial, txt_RawMaterial, "Raw Materials");
	}

	public void TM_COGs_S03_Windows_Web_Project_Creation(){

		createWebElementBy(lnk_CurrentCostingSheet).click();
		createWebElementBy(rdo_Create).click();
		waitForPageLoaded();
		WebElement ProjectName = createWebElementBy(txt_box_ProjectName);
		ProjectName.click();
		ProjectName.sendKeys("0000");
		waitForPageLoaded();
		WebElement SheettName = createWebElementBy(txt_box_SheetName);
		SheettName.click();
		SheettName.sendKeys("VMS Test");
		waitForPageLoaded();
		createWebElementBy(btn_CreateProject).click();
		waitForPageLoaded();
		createWebElementBy(btn_Save).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(txt_VMS_Test).getText(), "VMS Test");
		
	}
	
	void TM_COGs_S04_Windows_Web_Project_Modification() {
		
		createWebElementBy(lnk_CurrentCostingSheet).click();
		createWebElementBy(rdo_Modify).click();
		createWebElementBy(txt_box_Modify_Project).sendKeys("0000");
		selectDropdownValue(createWebElementBy(txt_box_Modify_Project), "2020");
		selectDropdownValue(createWebElementBy(txt_box_Modify_Sheet), "Jul - VMS Test");
		createWebElementBy(btn_Load).click();
		waitForPageLoaded();
		WebElement MolarWT = createWebElementBy(txt_box_MolarWt);
		MolarWT.clear();
		MolarWT.sendKeys("23");
		WebElement StartingMW = createWebElementBy(txt_box_StartingMW);
		StartingMW.clear();
		StartingMW.sendKeys("233");
		createWebElementBy(btn_Save).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(txt_StartingMW).getAttribute("ng-reflect-model"), "233");
		createWebElementBy(btn_Delete).click();
		waitForPageLoaded();
		createWebElementBy(btn_Confirmation_Ok).click();
	}
	/********************************* Common Methods *************************************/

	void userLogin() {
		try {
			DecrptPassword = decrypt("e19ncVNSmW6OrHZf9mDsAg==");
		} catch (Exception e) {
			e.printStackTrace();
		}
		createWebElementBy(txt_box_username).sendKeys(Username);
		createWebElementBy(txt_box_password).sendKeys(DecrptPassword);
		createWebElementBy(btn_login).click();;
	}
	
	void tab_Assertion(By element1, By element2, String expected_Text) {

		createWebElementBy(element1).click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(createWebElementBy(element2).getText(), expected_Text);
	}

}
