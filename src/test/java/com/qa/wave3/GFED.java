package com.qa.wave3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class GFED extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url = "https://keyrecovery.gilead.com/helpdesk/";
	private String url;
	
	/***************************** Test Cases *******************/

	/*
	 * Test case â€˜Test Nameâ€™ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: â€¢ AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, â€¢ TCNumber:
	 * Test case number [Numeric 2-3 digits] i.e, 01, 02,.. â€¢ TestCategory: Test
	 * case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve,
	 * DB â€¦] â€¢ Title: short title of test case based on context of test case ie.,
	 * ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails.
	 * 
	 * Test method name must be same as test case appended with TM example:
	 */

	@BeforeMethod(enabled = true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority = 0, enabled = true)
	public void GFED_S01_Web_Check_GFED_Page_Loaded() {
		TM_GFED_S01_Web_GFED_Page_Loaded();
	}

	@Test(priority = 1, enabled = true)
	public void GFED_S02_Web_System_Overview_Page_Loaded() {
		TM_GFED_S02_Web_System_Overview_Page_Loaded();
	}

	@Test(priority = 2, enabled = true)
	public void GFED_S03_Web_Drive_Recovery_Page_Loaded() {
		TM_GFED_S03_Web_Drive_Recovery_Page_Loaded();
	}
	
	@Test(priority = 3, enabled = true)
	public void GFED_S04_Web_Manage_TPM_Page_Loaded() {
		TM_GFED_S04_Web_Manage_TPM_Page_Loaded();
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

	By txt_GFEDLogo = By.xpath("//img[@id='logo']");
	By txt_Welcome = By.xpath("//span[@id='WelcomeText']");
	By tab_SystemOverview = By.xpath("//a[@id='systemLinkAnchor']//span");
	By txt_SystemOverview = By.xpath("//td[@class='formTitle']");
	By ipt_DomainName = By.xpath("//input[@id='DomainNameTextBox']");
	By ipt_UserID = By.xpath("//input[@id='UserNameTextBox']");
	By ipt_KeyID = By.xpath("//input[@id='KeyIdTextBox']");
	By slt_DriveUnlock = By.xpath("//select[@id='ReasonCodeSelect']");
	By tab_DriveRecovery = By.xpath("//a[@id='keyRecoveryLinkAnchor']//span");
	By txt_DriveRecovery = By.xpath("///td[@class='formTitle']");
	By tab_ManageTPM = By.xpath("//a[@id='tpmRecoveryLinkAnchor']//span");
	By txt_ManageTPM = By.xpath("//td[@class='formTitle']");
	By ipt_ComputerDomain = By.xpath("//input[@id='ComputerDomainTextBox']");
	By ipt_ComputerName = By.xpath("//input[@id='ComputerNameTextBox']");
	By ipt_UserDomain = By.xpath("//input[@id='UserDomainTextBox']");
	By ipt_ManageUserId = By.xpath(" //input[@id='UserNameTextBox']");
	By slt_ReasonCode = By.xpath("//select[@id='ReasonCodeSelect']");
		
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_GFED_S01_Web_GFED_Page_Loaded() {
		
		WebElement GFEDLogo_Txt = createWebElementBy(txt_GFEDLogo);
		IsDisplayed_IsEnabled(GFEDLogo_Txt);
		
		WebElement Welcome_Txt = createWebElementBy(txt_Welcome);
		Assert.assertTrue((Welcome_Txt).getText().contains("Welcome"));
		
		takeScreenshotAtEndOfTest();

	}

	public void TM_GFED_S02_Web_System_Overview_Page_Loaded() {

		WebElement SystemOverview_Tab = createWebElementBy(tab_SystemOverview);
		SystemOverview_Tab.click();
		
		WebElement SystemOverview_Txt = createWebElementBy(txt_SystemOverview);
		Assert.assertEquals(SystemOverview_Txt.getText(), "System Overview");
			
		takeScreenshotAtEndOfTest();
	
	}

	public void TM_GFED_S03_Web_Drive_Recovery_Page_Loaded() {

		WebElement DriveRecovery_Tab = createWebElementBy(tab_DriveRecovery);
		DriveRecovery_Tab.click();
		
		WebElement DomainName_Ipt = createWebElementBy(ipt_DomainName);
		IsDisplayed_IsEnabled(DomainName_Ipt);
		
		WebElement UserID_Ipt = createWebElementBy(ipt_UserID);
		IsDisplayed_IsEnabled(UserID_Ipt);
		
		WebElement KeyID_Ipt = createWebElementBy(ipt_KeyID);
		IsDisplayed_IsEnabled(KeyID_Ipt);
		
		WebElement DriveUnlock_Slt = createWebElementBy(slt_DriveUnlock);
		IsDisplayed_IsEnabled(DriveUnlock_Slt);
		
		url=getURL();
		Assert.assertTrue(url.contains("KeyRecoveryPage"));
		
		takeScreenshotAtEndOfTest();

	}
	
	public void TM_GFED_S04_Web_Manage_TPM_Page_Loaded() {

		WebElement ManageTPM_Tab = createWebElementBy(tab_ManageTPM);
		ManageTPM_Tab.click();
		
		WebElement ManageTPM_Txt = createWebElementBy(txt_ManageTPM);
		Assert.assertEquals(ManageTPM_Txt.getText(), "Manage TPM");
		
		WebElement ComputerDomain_Ipt = createWebElementBy(ipt_ComputerDomain);
		IsDisplayed_IsEnabled(ComputerDomain_Ipt);
		
		WebElement ComputerName_Ipt = createWebElementBy(ipt_ComputerName);
		IsDisplayed_IsEnabled(ComputerName_Ipt);
		
		WebElement UserDomain_Ipt = createWebElementBy(ipt_UserDomain);
		IsDisplayed_IsEnabled(UserDomain_Ipt);
		
		WebElement ManageUserId_Ipt = createWebElementBy(ipt_ManageUserId);
		IsDisplayed_IsEnabled(ManageUserId_Ipt);
		
		WebElement ReasonCode_Slt = createWebElementBy(slt_ReasonCode);
		IsDisplayed_IsEnabled(ReasonCode_Slt);
			
		takeScreenshotAtEndOfTest();
		
	}

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
