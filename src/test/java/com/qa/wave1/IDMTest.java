package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class IDMTest extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url = "https://idm.gilead.com";
	final String Url1 = "https://idm.gilead.com";
	final String Username = "sgupta27";
	private String DecrptPassword;
	String EncryptPassword = "tYAZwEkYPz68EUeic62TFw==";
	private String title;
	private String url;

	/***************************** Test Cases *******************/

	/*
	 * TEST URL: http://sjidmapptstg01.na.gilead.com:8080/identityiq/ 
	 * SQA URL:http://sjidmappqag01.na.gilead.com:8080/identityiq/ 
	 * VAL URL:http://sjidmappvalg02.na.gilead.com:8080/identityiq/ 
	 * DEV URL:http://sjidmappdevg01.na.gilead.com:8080/identityiq/
	 * PROD: https://idm.gilead.com
	 */
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

	@BeforeMethod(enabled = true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
		loginIDM();

	}

	@Test(priority = 0, enabled = true)
	public void IDM_S01_Web_AccessRequest_Verification() {
		TM_IDM_S01_Web_AccessRequest_Verification();
	}

	@Test(priority = 1, enabled = true)
	public void IDM_S02_Web_TrackRequest_Verification() {
		TM_IDM_S02_Web_TrackRequest_Verification();
	}

	@Test(priority = 2, enabled = true)
	public void IDM_S03_Web_Approvals_Verification() {
		TM_IDM_S03_Web_Approvals_Verification();
	}

	@Test(priority = 3, enabled = true)
	public void IDM_S04_Web_Reports_Verification() {
		TM_IDM_S04_Web_Reports_Verification();
	}

	@Test(priority = 4, enabled = true)
	public void IDM_S05_Web_URL_Verification() {
		TM_IDM_S05_Web_URL_Verification();
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

	By ipt_Username = By.xpath("//input[@placeholder='Username']");
	By ipt_Passwrod = By.xpath("//input[@placeholder='Password']");
	By btn_Login = By.xpath("//input[@value='Login']");
	By lnk_EnterpriseAppAccess = By.xpath("(//div[@id='ID_AccessRequest']//li)[1]");
	By lnk_EnterpriseAppApprovals = By.xpath("(//div[@id='ID_Approvals']//li)[1]");
	By lnk_ERPAccess = By.xpath("(//div[@id='ID_AccessRequest']//li)[2]");
	By lnk_ERPApprovals = By.xpath("(//div[@id='ID_Approvals']//li/a)[2]");
	By lnk_PartnerApprovals = By.xpath("(//div[@id='ID_Approvals']//li/a)[3]");
	By lnk_RoleApprovals = By.xpath("(//div[@id='ID_Approvals']//li/a)[4]");
	By lnk_GroupApprovals = By.xpath("(//div[@id='ID_Approvals']//li/a)[5]");
	By lnk_Dashboard = By.xpath("//a[@role='menuitem']");
	By lnk_EnterpriseApplication = By.linkText("Enterprise Applications");
	By lnk_PartnerOrganizationManagement = By.linkText("Partner Organization Management");
	By lnk_RequestGroupMembership = By.linkText("Request Group Membership");
	By lnk_ERP = By.linkText("ERP");
	By lnk_GroupManagement = By.linkText("Group Management");
	By lnk_PartnerUserManagement = By.linkText("Partner User Management");
	By lnk_EnterpriseReports = By.linkText("Enterprise Reports");
	By lnk_GroupManagementReports = By.linkText("Group Management Reports");
	By lnk_PartnerReports = By.linkText("Partner Reports");
	By lnk_TrackEnterpriseRequests = By.linkText("Track Enterprise Requests");
	By lnk_TrackPartnerRequests = By.linkText("Track Partner Requests");
	By lnk_TrackERPRequests = By.linkText("Track ERP Requests");
	By lnk_TrackGroupManagementRequests = By.linkText("Track Group Management Requests");
	By img_IDMlogo = By.cssSelector(".topLeftLogo img");
	By img_Gileadlogo = By.cssSelector(".logoholder img");
	By txt_AccessRequest= By.cssSelector("#ID_AccessRequest>div:nth-child(1)");
	By txt_TrackRequest= By.cssSelector("#ID_TrackRequest>div:nth-child(1)");
	By txt_Approvals= By.cssSelector("#ID_Approvals>div:nth-child(1)");
	By txt_Reports= By.cssSelector("#ID_Reports>div:nth-child(1)");
	

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void loginIDM() {
		try {
			DecrptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (Url != Url1) {
			WebElement Username_Ipt = createWebElementBy(ipt_Username);
			Username_Ipt.sendKeys(Username);

			WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
			Password_Ipt.sendKeys(DecrptPassword);

			WebElement Login_Btn = createWebElementBy(btn_Login);
			Login_Btn.click();

		}

	}

	public void TM_IDM_S01_Web_AccessRequest_Verification() {

		WebElement ERP_Lnk = createWebElementBy(lnk_ERP);
		ERP_Lnk.click();
		title = getTitle();
		Assert.assertEquals(title, "Applications");
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk.click();

		WebElement EnterpriseAppAccess_Lnk = createWebElementBy(lnk_EnterpriseAppAccess);
		EnterpriseAppAccess_Lnk.click();
		title = getTitle();
		Assert.assertEquals(title, "Access Request");
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk1 = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk1.click();

		WebElement PartnerOrganizationManagement_Lnk = createWebElementBy(lnk_PartnerOrganizationManagement);
		PartnerOrganizationManagement_Lnk.click();
		title = getTitle();
		Assert.assertEquals(title, "Partner Organization");
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk2 = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk2.click();

		WebElement PartnerUserManagement_Lnk = createWebElementBy(lnk_PartnerUserManagement);
		PartnerUserManagement_Lnk.click();
		url = getURL();
		Assert.assertTrue(url.contains("partners"));
		waitForPageLoaded();
		WebElement Dashboard_Lnk3 = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		Dashboard_Lnk3.click();

		WebElement GroupManagement_Lnk = createWebElementBy(lnk_GroupManagement);
		GroupManagement_Lnk.click();
		url = getURL();
		Assert.assertTrue(url.contains("groups"));
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk4 = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk4.click();
		
		WebElement RequestGroupMembership_Lnk = createWebElementBy(lnk_RequestGroupMembership);
		RequestGroupMembership_Lnk.click();
		url = getURL();
		Assert.assertTrue(url.contains("groupAccess"));
		takeScreenshotAtEndOfTest();

	}

	public void TM_IDM_S02_Web_TrackRequest_Verification() {

		WebElement TrackEnterpriseRequests_Lnk = createWebElementBy(lnk_TrackEnterpriseRequests);
		TrackEnterpriseRequests_Lnk.click();
		url = getURL();
		Assert.assertTrue(url.contains("trackRequests"));
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk.click();

		WebElement TrackERPRequests_Lnk = createWebElementBy(lnk_TrackERPRequests);
		TrackERPRequests_Lnk.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("identityRequest"));
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk1 = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk1.click();

		WebElement TrackGroupManagementRequests_Lnk = createWebElementBy(lnk_TrackGroupManagementRequests);
		TrackGroupManagementRequests_Lnk.click();
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("groupTrack"));
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk2 = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk2.click();

		WebElement TrackPartnerRequests_Lnk = createWebElementBy(lnk_TrackPartnerRequests);
		TrackPartnerRequests_Lnk.click();
		title = getTitle();
		Assert.assertEquals(title, "Track Request");
		takeScreenshotAtEndOfTest();

	}

	public void TM_IDM_S03_Web_Approvals_Verification() {

		WebElement EnterpriseAppApprovals_Lnk = createWebElementBy(lnk_EnterpriseAppApprovals);
		EnterpriseAppApprovals_Lnk.click();
		url = getURL();
		Assert.assertTrue(url.contains("manageApprovals"));
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk.click();

		wait(5);

		WebElement ERPApprovals_Lnk = createWebElementBy(lnk_ERPApprovals);
		ERPApprovals_Lnk.click();
		url = getURL();
		Assert.assertTrue(url.contains("workitem"));
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk1 = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk1.click();

		WebElement PartnerApprovals_Lnk = createWebElementBy(lnk_PartnerApprovals);
		PartnerApprovals_Lnk.click();
		url = getURL();
		Assert.assertTrue(url.contains("approval"));
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk2 = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk2.click();

		WebElement RoleApprovals_Lnk = createWebElementBy(lnk_RoleApprovals);
		RoleApprovals_Lnk.click();
		url = getURL();
		Assert.assertTrue(url.contains("roleApprovals"));
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk3 = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk3.click();
		
		WebElement GroupApprovals_Lnk = createWebElementBy(lnk_GroupApprovals);
		GroupApprovals_Lnk.click();
		url = getURL();
		Assert.assertTrue(url.contains("groupApproval"));
		takeScreenshotAtEndOfTest();

	}

	public void TM_IDM_S04_Web_Reports_Verification() {

		WebElement EnterpriseReports_Lnk = createWebElementBy(lnk_EnterpriseReports);
		EnterpriseReports_Lnk.click();
		title = getTitle();
		Assert.assertEquals(title, "Application Report");
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk.click();

		WebElement PartnerReports_Lnk = createWebElementBy(lnk_PartnerReports);
		PartnerReports_Lnk.click();
		url = getURL();
		Assert.assertTrue(url.contains("partnerReports"));
		takeScreenshotAtEndOfTest();
		WebElement Dashboard_Lnk1 = createWebElementBy(lnk_Dashboard);
		waitForPageLoaded();
		Dashboard_Lnk1.click();

		WebElement GroupManagementReports_Lnk = createWebElementBy(lnk_GroupManagementReports);
		GroupManagementReports_Lnk.click();
		title = getTitle();
		Assert.assertEquals(title, "Reports");
		takeScreenshotAtEndOfTest();

	}

	public void TM_IDM_S05_Web_URL_Verification() {
		title = getTitle();
		Assert.assertEquals(title, "SailPoint IdentityIQ - Dashboard");
		WebElement idmlogo= createWebElementBy(img_IDMlogo);
		WebElement gileadlogo=createWebElementBy(img_Gileadlogo);
		IsDisplayed_IsEnabled(idmlogo);
		IsDisplayed_IsEnabled(gileadlogo);
		WebElement accessRequest= createWebElementBy(txt_AccessRequest);
		WebElement approvals= createWebElementBy(txt_Approvals);
		WebElement reports= createWebElementBy(txt_Reports);
		WebElement trackRequest= createWebElementBy(txt_TrackRequest);
		
		Assert.assertEquals(accessRequest.getText(), "ACCESS REQUEST");
		Assert.assertEquals(approvals.getText(), "APPROVALS");
		Assert.assertEquals(reports.getText(), "REPORTS");
		Assert.assertEquals(trackRequest.getText(), "TRACK REQUESTS");
		takeScreenshotAtEndOfTest();

	}

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
