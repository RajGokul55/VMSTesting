package com.qa.wave1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class GDST extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	/*
	 * Prod url*/
	   final String Url = "https://gdst.gilead.com:8443/mc#dashboard";
		
	/*
	 * Dev url
	 * final String Url = "https://sjdstappdevn01:8443/login";
	 */
	final String Username = "Bhumika.Dineshjain";
	private String DecrptPassword;

	/***************************** Test Cases *******************/
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

	@BeforeTest(enabled = true)
	void EncriptPassword() throws Exception {
		DecrptPassword = decrypt("bwf9YU4lPwbQsROyCP7V7Q==");
	}

	@BeforeTest
	public void beforeTest() {
		launchBrowser(Browser, Url);
		TM_GDST_login();
	}

	@Test(priority = 0, enabled = true)
	public void GDST_001_Web_VerifyLogin() {
		TM_GDST_001_Web_VerifyLogin();
	}

	@Test(priority = 1, enabled = true)
	public void GDST_002_Web_VerifyCorrectLicense() {
		TM_GDST_002_Web_VerifyCorrectLicense();
	}

	@Test(priority = 2, enabled = true)
	public void GDST_003_Web_VerifyReportGenerated() {
		TM_GDST_003_Web_VerifyReportGenerated();
	}

	@Test(priority = 3, enabled = true)
	public void GDST_005_Web_VerifyAllReport() {
		TM_GDST_005_Web_VerifyAllReport();
	}

	@Test(priority = 4, enabled = true)
	public void GDST_006_Web_VerifyReportEmail() {
		TM_GDST_006_Web_VerifyReportEmail();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */

	By ipt_Username = By.id("login_usernameInput");
	By ipt_Password = By.id("login_passwordInput");
	By btn_Submit = By.id("login_submitButton");
	By txtEraserStatus = By.xpath("//tbody/tr[1]/td[4]/div/span/span");
	By txtDate = By.xpath("//tbody/tr[1]/td[3]/div/span");
	By tab_UsersAndLicenses = By.xpath(".//a[contains(text(), 'Users & licensing')]");
	By tab_Reporting = By.id("view_reportingTab");
	By lnk_AllReports = By.id("reporting_processArea_allReports");
	By lnk_ComputerReports = By.id("reporting_processArea_computerReports");
	By lnk_MobileReports = By.id("reporting_processArea_mobileReports");
	By lnk_LUNReports = By.id("reporting_processArea_lunReports");
	By lnk_FileReports = By.id("reporting_processArea_fileReports");
	By lnk_FlashReports = By.id("reporting_processArea_flashReports");
	By lnk_VirtualReports = By.id("reporting_processArea_virtualReports");
	By lnk_DegausserReport = By.id("reporting_processArea_degausserReports");
	By title_ComputerReport = By.xpath("//div[contains(text(), 'Computer reports')]");
	By title_MobileReport = By.xpath("//div[contains(text(), 'Mobile reports')]");
	By title_LUNReport = By.xpath("//div[contains(text(), 'LUN reports')]");
	By title_FileReport = By.xpath("//div[contains(text(), 'File reports')]");
	By title_FlashReport = By.xpath("//div[contains(text(), 'Flash reports')]");
	By title_VirtualReport = By.xpath("//div[contains(text(), 'Virtual reports')]");
	By title_DegausserReport = By.xpath("//div[contains(text(), 'Degausser reports')]");
	By ipt_EmailAddress = By.id("reporting_dialog_emailDialog_receiverEmailInput");
	By btn_Ok = By.id("reporting_dialog_emailDialog_okButton");
	By btn_Close = By.id("general_infoDialog_closeButton");
	By opt_Email = By.xpath("//a[contains(text(), 'View')]/../ul[1]/li[2]");
	By drp_View = By.xpath("//table/tbody/tr[1]/td[2]/div/div/a[2]");
	By txt_SuccessMsg = By.xpath("//div[contains(text(), 'Email was')]");
	String sEmail_id = "pravin.sonawane@gilead.com";
	String sSuccessMsg = "Email was sent successfully.";
	String sPageTitle = "Blancco Management Console";
	String sErasureStatus = "Successful";

	/***************************** Test Case Methods *******************/

	void TM_GDST_001_Web_VerifyLogin() {
		Assert.assertEquals(TM_GDST_GetPageTitle(), sPageTitle);
		wait(5);
		takeScreenshotAtEndOfTest();
	}

	void TM_GDST_002_Web_VerifyCorrectLicense() {
		createWebElementBy(tab_UsersAndLicenses).click();
		waitForPageLoaded();
		Assert.assertEquals(TM_VerifyCorrectListOfLicenses(), true);
		wait(5);
		takeScreenshotAtEndOfTest();
	}

	void TM_GDST_003_Web_VerifyReportGenerated() {
		createWebElementBy(tab_Reporting).click();
		waitForPageLoaded();
		createWebElementBy(lnk_AllReports).click();
		createWebElementBy(txtEraserStatus);
		Assert.assertEquals(createWebElementBy(txtEraserStatus).getText(), sErasureStatus);
		wait(5);
		takeScreenshotAtEndOfTest();
	}

	void TM_GDST_005_Web_VerifyAllReport() {
		createWebElementBy(tab_Reporting).click();
		waitForPageLoaded();

		/**
		 * Computer Report Verification
		 */
		createWebElementBy(lnk_ComputerReports).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(title_ComputerReport).isDisplayed(), true);
		wait(5);
		takeScreenshotAtEndOfTest();

		/**
		 * Mobile Report Verification
		 */
		createWebElementBy(lnk_MobileReports).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(title_MobileReport).isDisplayed(), true);
		wait(5);
		takeScreenshotAtEndOfTest();

		/**
		 * LUN Report Verification
		 */
		createWebElementBy(lnk_LUNReports).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(title_LUNReport).isDisplayed(), true);
		wait(5);
		takeScreenshotAtEndOfTest();

		/**
		 * File Report Verification
		 */
		createWebElementBy(lnk_FileReports).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(title_FileReport).isDisplayed(), true);
		wait(5);
		takeScreenshotAtEndOfTest();

		/*
		 * Flash Report Verification
		 */
		createWebElementBy(lnk_FlashReports).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(title_FlashReport).isDisplayed(), true);
		wait(5);
		takeScreenshotAtEndOfTest();

		/**
		 * Virtual Report Verification
		 */
		createWebElementBy(lnk_VirtualReports).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(title_VirtualReport).isDisplayed(), true);
		wait(5);
		takeScreenshotAtEndOfTest();

		/**
		 * Degausser Report Verification
		 */
		createWebElementBy(lnk_DegausserReport).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(title_DegausserReport).isDisplayed(), true);
		wait(5);
		takeScreenshotAtEndOfTest();
	}

	void TM_GDST_006_Web_VerifyReportEmail() {
		createWebElementBy(lnk_AllReports).click();
		createWebElementBy(drp_View).click();
		createWebElementBy(opt_Email).click();
		createWebElementBy(ipt_EmailAddress).sendKeys(sEmail_id);
		createWebElementBy(btn_Ok).click();
		createWebElementBy(btn_Close);
		Assert.assertEquals(createWebElementBy(txt_SuccessMsg).isDisplayed(), true);
		Assert.assertEquals(createWebElementBy(txt_SuccessMsg).getText(), sSuccessMsg);
		wait(5);
		takeScreenshotAtEndOfTest();
	}

	/****************************
	 * Methods used within the test method
	 *********************/
	/**
	 * Method to login to the application.
	 */
	void TM_GDST_login() {
		createWebElementBy(ipt_Username).sendKeys(Username);
		createWebElementBy(ipt_Password).sendKeys(DecrptPassword);
		createWebElementBy(btn_Submit).click();
		waitForPageLoaded();
	}

	/**
	 * Method to get title of the page.
	 * 
	 * @return
	 */
	public String TM_GDST_GetPageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	/**
	 * Method to verify the list of licenses
	 */
	public boolean TM_VerifyCorrectListOfLicenses() {

		List<WebElement> actualListOfLicenses = new ArrayList<WebElement>();

		for (int i = 1; i <= 5; i++) {
			WebElement Licenses = createWebElementBy(By.xpath("//table/tbody/tr[" + i + "]/td[1]"));
			actualListOfLicenses.add(Licenses);
		}

		/**
		 * To verify the licenses name
		 */
		String[] expectedListOfLicenses = { "Blancco Drive Eraser - High End Drive (per drive)",
				"Blancco Drive Eraser - PC Edition (per drive)", "Blancco Drive Eraser - Server Edition (per drive)",
				"Blancco Mobile Device Eraser - Erasure", "Blancco Removable Media Eraser (per drive)"};

		Boolean result = false;
		for (WebElement e : actualListOfLicenses) {
			result = false;
			for (int i = 0; i <= 4; i++) {
				if (e.getText().equals(expectedListOfLicenses[i])) {
					result = true;
					break;
				}

			}

		}
		return result;
	}
	
}
