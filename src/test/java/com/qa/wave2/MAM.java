package com.qa.wave2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class MAM extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url = "http://hrappstest/mobileaccessmanagement/StipendApproval.aspx";
	private String url;
	
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

	@BeforeMethod(enabled = true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority = 0, enabled = true)
	public void MAM_S01_Web_Check_Mobile_Access_Management_Page_Loaded() {
		TM_MAM_S01_Web_Check_Mobile_Access_Management_Page_Loaded();
	}

	@Test(priority = 1, enabled = true)
	public void MAM_S02_Web_All_Tabs_Are_Present() {
		TM_MAM_S02_Web_All_Tabs_Are_Present();
	}

	@Test(priority = 2, enabled = true)
	public void MAM_S03_Web_Stipend_Approval_Page_Loaded() {
		TM_MAM_S03_Web_Stipend_Approval_Page_Loaded();
	}
	
	@Test(priority = 3, enabled = true)
	public void MAM_S04_Web_Stipend_Summary_Page_Loaded() {
		TM_MAM_S04_Web_Stipend_Summary_Page_Loaded();
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

	By ipt_Username = By.xpath("//input[@id='username']");
	By ipt_Passwrod = By.xpath("//input[@id='password']");
	By btn_SignIn = By.xpath("//input[@class='btn']");
	By txt_Mam = By.xpath("//h1[@class='M_title text-nowrap']//a//span");
	By txt_Home = By.xpath("//li[1]//a[1]");
	By txt_RequestAccess = By.xpath("//li[2]//a[1]");
	By txt_StipendRequest = By.xpath("//li[3]//a[1]");
	By txt_StipendApproval = By.xpath("//li[4]//a[1]");
	By txt_StipendSummary = By.xpath("//li[5]//a[1]");
	By btn_SelectAll = By.xpath("//div[@class='row']//button[1]");
	By btn_UnselectAll = By.xpath("//body//button[2]");
	By btn_ApproveSelectedRequests = By.xpath("//input[@id='ContentPlaceHolder1_chkApprove1']");
	By btn_RejectSelectedRequests = By.xpath("//div[@class='L_row']//input[2]");
	By lnk_StipendApproval = By.linkText("Stipend Approval");
	By lnk_StipendSummary = By.linkText("Stipend Summary");
	By slt_StipendSummary = By.xpath("//select[@id='ContentPlaceHolder1_dpd']");
		
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_MAM_S01_Web_Check_Mobile_Access_Management_Page_Loaded() {
		
		WebElement Mam= createWebElementBy(txt_Mam);
		Assert.assertEquals(Mam.getText(), "Mobile Access Management");
		takeScreenshotAtEndOfTest();

	}

	public void TM_MAM_S02_Web_All_Tabs_Are_Present() {

		WebElement Home_Txt = createWebElementBy(txt_Home);
		Assert.assertEquals(Home_Txt.getText(), "Home");
		
		WebElement RequestAccess_Txt = createWebElementBy(txt_RequestAccess);
		Assert.assertEquals(RequestAccess_Txt.getText(), "Request Access");
		
		WebElement StipendRequest_Txt = createWebElementBy(txt_StipendRequest);
		Assert.assertEquals(StipendRequest_Txt.getText(), "Stipend Request");
		
		WebElement StipendApproval_Txt = createWebElementBy(txt_StipendApproval);
		Assert.assertEquals(StipendApproval_Txt.getText(), "Stipend Approval");
		
		WebElement StipendSummary_Txt = createWebElementBy(txt_StipendSummary);
		Assert.assertEquals(StipendSummary_Txt.getText(), "Stipend Summary");
		
		takeScreenshotAtEndOfTest();
	
	}

	public void TM_MAM_S03_Web_Stipend_Approval_Page_Loaded() {

		WebElement StipendApproval_Lnk = createWebElementBy(lnk_StipendApproval);
		StipendApproval_Lnk.click();
		waitForPageLoaded();
		
		WebElement SelectAll_Btn = createWebElementBy(btn_SelectAll);
		Assert.assertEquals(SelectAll_Btn.getText(), "Select All");
		
		takeScreenshotAtEndOfTest();
		
		WebElement UnselectAll_Btn = createWebElementBy(btn_UnselectAll);
		Assert.assertEquals(UnselectAll_Btn.getText(), "Unselect All");
		
		takeScreenshotAtEndOfTest();
		
		WebElement ApproveSelectedRequests_Btn = createWebElementBy(btn_ApproveSelectedRequests);
		Assert.assertEquals(ApproveSelectedRequests_Btn.getAttribute("value"), "Approve Selected Requests");
		
		takeScreenshotAtEndOfTest();
		
		WebElement RejectSelectedRequests_Btn = createWebElementBy(btn_RejectSelectedRequests);
		Assert.assertEquals(RejectSelectedRequests_Btn.getAttribute("value"), "Reject Selected Requests");
		
		takeScreenshotAtEndOfTest();

	}
	
	public void TM_MAM_S04_Web_Stipend_Summary_Page_Loaded() {

		WebElement StipendSummary_Lnk = createWebElementBy(lnk_StipendSummary);
		StipendSummary_Lnk.click();
		
		waitForPageLoaded();
		url = getURL();
		Assert.assertTrue(url.contains("StipendSummary.aspx"));
		
		WebElement StipendSummary_Slt = createWebElementBy(slt_StipendSummary);
	    IsDisplayed_IsEnabled(StipendSummary_Slt);
		
		takeScreenshotAtEndOfTest();
		
	}

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
