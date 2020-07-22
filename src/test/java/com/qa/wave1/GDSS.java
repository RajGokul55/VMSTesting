package com.qa.wave1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class GDSS extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	//Prod Url
	//final String Url = "https://admin.docusign.com";

	//Dev Url
	final String Url = "https://account-d.docusign.com";
	final String FirstLevelUsername = "pravin.sonawane@gilead.com";
	final String SecondLevelUsername = "psonawane";
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

	@BeforeSuite(enabled = true)
	void EncriptPassword() throws Exception {
		DecrptPassword = decrypt("e19ncVNSmW6OrHZf9mDsAg==");
	}

	@BeforeTest
	public void beforeTest() {
		launchBrowser(Browser, Url);
		TM_GDSS_login();
	}

	@Test(priority = 0, enabled = true)
	public void GDSS_S01_Web_Application_Launch_Verfication() {
		TM_GDSS_S01_Web_Application_Launch_Verfication();
	}


	@Test(priority = 1, enabled = true) 
	public void GDSS_S02_Web_Upload_Sign_Document() throws Exception {
		TM_GDSS_S02_Web_Upload_Sign_Document();
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

	By ipt_FirstLevelUsername = By.id("username");
	By btn_Continue = By.xpath("//button[@data-qa= 'submit-username']");
	By btn_UseCompanyLogin = By.xpath("//button[@class='btn btn-primary btn-lg']");
	By ipt_SecondLevelUsername = By.id("username");
	By ipt_Password = By.id("password");
	By btn_SignOn = By.xpath("//a[@title = 'Sign On']");
	By btn_New = By.xpath("//button[contains(text(), 'New')]");
	By drp_SignDocument = By.xpath("//button[contains(text(), 'Sign a Document')]");
	By btn_Upload = By.xpath("//label[contains(text(), 'Upload')]");
	By btn_Sign = By.xpath("//button[@data-qa = 'modal-confirm-btn']");
	By btn_ContinuePage = By.xpath("//button[contains(text(), 'Continue')]");
	By lnk_Sign = By.xpath("//button[@tab-type = 'SignHere']");
	By btn_AdobtAndSign = By.xpath("//button[contains(text(), 'Adopt and Sign')]");
	By doc_Page = By.xpath("//div[@class='page-tabs']");
	By btn_Finish = By.id("end-of-document-btn-finish");
	By txt_Status = By.xpath("//table/tbody/tr[1]/td[4]");
	By btn_NoThanks = By.xpath(".//[contains(text(), 'No Thanks']");

	String Status = "Completed";
	String sPageTitle = "Home | DocuSign";

	/***************************** Test Case Methods *******************/

	void TM_GDSS_S01_Web_Application_Launch_Verfication() {
		wait(5);
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(TM_GDSS_GetPageTitle(), sPageTitle);
	}

	void TM_GDSS_S02_Web_Upload_Sign_Document() throws Exception {
		createWebElementBy(btn_New).click();
		createWebElementBy(drp_SignDocument).click();
		createWebElementBy(btn_Upload).click();

		/**
		 * Code to upload document from local drive using Robot class
		 */
		Robot robot = new Robot();

		robot.setAutoDelay(2000);

		StringSelection stringSelection = new StringSelection(
				"C:\\Users\\amamgain\\Desktop\\Upload Sign Validation\\GDSS Test");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		wait(5);
		takeScreenshotAtEndOfTest();

		/**
		 * Code for signing the document
		 */
		/*
		 * createWebElementBy(btn_Sign).click(); waitForPageLoaded();
		 * createWebElementBy(btn_ContinuePage).click();
		 */
		/*
		 * Drag and Drop the sign icon
		 */
		Actions action = new Actions(driver);

		WebElement source = driver.findElement(lnk_Sign);
		WebElement destination = driver.findElement(doc_Page);

		action.dragAndDrop(source, destination).perform();
		createWebElementBy(btn_Finish).click();
		createWebElementBy(btn_NoThanks).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(txt_Status).getText(), sPageTitle);

		wait(5);
		takeScreenshotAtEndOfTest();
	}

	/****************************
	 * Methods used within the test method
	 *********************/
	/**
	 * Method to login to the application.
	 */
	void TM_GDSS_login() {
		createWebElementBy(ipt_FirstLevelUsername).sendKeys(FirstLevelUsername);
		createWebElementBy(btn_Continue).click();
		waitForPageLoaded();
		createWebElementBy(btn_UseCompanyLogin).click();
		waitForPageLoaded();
		createWebElementBy(ipt_SecondLevelUsername).sendKeys(SecondLevelUsername);
		createWebElementBy(ipt_Password).sendKeys(DecrptPassword);
		createWebElementBy(btn_SignOn).click();
		waitForPageLoaded();
		createWebElementBy(ipt_FirstLevelUsername).sendKeys(FirstLevelUsername);
		createWebElementBy(btn_Continue).click();
		waitForPageLoaded();
		createWebElementBy(btn_UseCompanyLogin).click();
		waitForPageLoaded();
		createWebElementBy(ipt_SecondLevelUsername).sendKeys(SecondLevelUsername);
		createWebElementBy(ipt_Password).sendKeys(DecrptPassword);
		createWebElementBy(btn_SignOn).click();
	}

	/**
	 * Method to get title of the page.
	 * 
	 * @return
	 */
	public String TM_GDSS_GetPageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

}
