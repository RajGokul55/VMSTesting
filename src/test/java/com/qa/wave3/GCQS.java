package com.qa.wave3;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class GCQS extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "IE";
	// Dev Environment URL
	//final String Url = "http://sjiqsapppocn01/iqs310r4";
	final String Url = "http://hkgcqsappprdg01/gcqs";
	// Test Environment URL
	final String Url1 = "http://fciqsappdev02/GCQSTest";
	// Prod Environment URL
	final String Url2 = "http://hkgcqsappprdg01/gcqs";

	/***************************** Test Cases *******************/
	/*
	 * Test case â€˜Test Nameâ€™ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: â€¢ AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, â€¢ TCNumber:
	 * Test case number [Numeric 2-3 digits] i.e, 01, 02,.. â€¢ TestCategory: Test
	 * case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve,
	 * DB â€¦] â€¢ Title: short title of test case based on context of test case
	 * ie., ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails.
	 * 
	 * Test method name must be same as test case appended with TM example:
	 */

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, Url2);
	}

	@Test(priority = 0, enabled = true)
	public void GCQS_S01_Web_verifyIQSscreen() {
		TM_GCQS_S01_Web_verifyIQSScreen();

	}

	@Test(priority = 0, enabled = true)
	public void GCQS_S02_Web_VerifyPreviewReport() {
		TM_GCQS_S02_Web_verifyPreviewReport();

	}
	
	@Test(priority = 0, enabled = true)
	public void GCQS_S03_Web_VerifyQualityRecordBrowserSearch() {
		TM_GCQS_S03_Web_verifyQualityRecordBrowserSearch();

	}
	// Manually we are performing this Test case, since need to download the attachment & verify 
	//@Test(priority = 0, enabled = false)
	//public void GCQS_S04_VerifyRecord_And_Attachment() {
		//TM_GCQS_S04_Web_verifyAttachment_Record();

	//}
	
	@Test(priority = 0, enabled = true)
	public void GCQS_S05_Web_VerifyIQSReportPortal() {
		TM_GCQS_S05_Web_verifyIQSReportPortal();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */
	By btn_qualityRecords = By.xpath("//a[contains(text(),'Quality Records Browser')]");
	By btn_search = By.xpath("//*[@id='ctl00_middleContent_btnSearch']");
	By drp_Draft = By.xpath("//div[@id='ctl00_middleContent_ucSearchBar_ddlRecStatus_c1']");
	By btn_RecordStatus = By.xpath("//*[@id='ctl00_middleContent_ucSearchBar_ddlRecStatus_Input']");
	By btn_myRequest = By.xpath("//*[@id='ctl00_ucSideMenu_lnkMyRequest']");
	By lnk_Report = By.cssSelector("#ctl00_middleContent_rgdQualityRecords_ctl01_ctl04_linkedRecordsReport");
	By txt_LINKEDRECORDSREPORT = By.xpath("//span[contains(text(),'LINKED RECORDS REPORT')]");
	By lnk_reports = By.xpath("//*[@id='ctl00_ucTopbar_lnkReports']");
	By heading_Report = By.cssSelector("td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(1)");
	By btn_doubleClick = By.cssSelector("td.webappTxtH3 div.RadGrid_Default:nth-child(1) div:nth-child(7) table.MasterTable_Default.gridctl00_middleContent_rgdQualityRecords_ctl01:nth-child(1) tbody:nth-child(4) tr.SelectedRow_Default:nth-child(1) > td:nth-child(5)");
	By txt_inDashboard = By.xpath("//*[contains(text(),'Welcome to Dashboards!')]");

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_GCQS_S01_Web_verifyIQSScreen() {

		VerifyGCQSScreen();

	}

	public void TM_GCQS_S02_Web_verifyPreviewReport() {

		VerifyQualityRecordBrowserSearch();
		verifyPreviewReport();

	}

	public void TM_GCQS_S03_Web_verifyQualityRecordBrowserSearch() {

		VerifyQualityRecordBrowserSearch();

	}

	public void TM_GCQS_S04_Web_verifyAttachment_Record() {

		VerifyQualityRecordBrowserSearch();
		//verifyIQSAttachmentRecord();

	}

	public void TM_GCQS_S05_Web_verifyIQSReportPortal() {

		verifyGCQSReportPortal();

	}

	public void VerifyGCQSScreen() {

		waitForPageLoaded();
		wait(2);
		WebElement MyRequest = createWebElementBy(btn_myRequest);
		IsDisplayed_IsEnabled(MyRequest);
		wait(2);
		takeScreenshotAtEndOfTest();
	}

	public void verifyPreviewReport() {
		
		wait(3);
		Set<String> MainTab = driver.getWindowHandles();
		
		Set<String> Tab = driver.getWindowHandles();
		//String MainTab = driver.getWindowHandles();
		System.out.println("Total tabs before clicking = " +Tab.size());
		
		WebElement ReportPreview = createWebElementBy(lnk_Report);
		ReportPreview.click();
		wait(2);
		takeScreenshotAtEndOfTest();
		
		Tab = driver.getWindowHandles();
		System.out.println("Total tabs after clicking = " +Tab.size());
		
		for(String h : Tab)
		{
			if(!h.equals(MainTab)) {
				//switch to new tab
				driver.switchTo().window(h);
				waitForPageLoaded();
				wait(2);
				driver.manage().window().maximize();
				takeScreenshotAtEndOfTest();
			}
		}
		WebElement LINKEDRECORDSREPORTScreen = createWebElementBy(txt_LINKEDRECORDSREPORT);
		IsDisplayed_IsEnabled(LINKEDRECORDSREPORTScreen);
		wait(2);
		System.out.println("Linked Report is displayed");
		takeScreenshotAtEndOfTest();
		driver.quit();
		
	}

	public void VerifyQualityRecordBrowserSearch() {

		waitForPageLoaded();
		wait(2);
		WebElement QualityRecords = createWebElementBy(btn_qualityRecords);
		QualityRecords.click();
		//WebElement RecordStatus = createWebElementBy(btn_RecordStatus);
		//RecordStatus.click();
		wait(1);
		//WebElement Draft = createWebElementBy(drp_Draft);
		//Draft.click();
		wait(2);
		WebElement Search = createWebElementBy(btn_search);
		Search.click();
		wait(5);
		takeScreenshotAtEndOfTest();
	}

	public void verifyGCQSAttachmentRecord() {
		wait(2);
		Actions actions = new Actions(driver);
		WebElement Draft = createWebElementBy(btn_doubleClick);
		actions.doubleClick(Draft).perform();
		wait(3);
		takeScreenshotAtEndOfTest();
	}

	public void verifyGCQSReportPortal() {
		wait(2);
		Set<String> MainTab = driver.getWindowHandles();
		
		Set<String> Tab = driver.getWindowHandles();
		//String MainTab = driver.getWindowHandles();
		System.out.println("Total tabs before clicking = " +Tab.size());
		
		WebElement Reports = createWebElementBy(lnk_reports);
		Reports.click();
		wait(2);
		takeScreenshotAtEndOfTest();
		
		Tab = driver.getWindowHandles();
		System.out.println("Total tabs after clicking = " +Tab.size());
		
		for(String h : Tab)
		{
			if(!h.equals(MainTab)) {
				//switch to new tab
				driver.switchTo().window(h);
				waitForPageLoaded();
				wait(2);
				driver.manage().window().maximize();
				takeScreenshotAtEndOfTest();
			}
		}
		WebElement REPORTPortalScreen = createWebElementBy(heading_Report);
		IsDisplayed_IsEnabled(REPORTPortalScreen);
		wait(2);
		System.out.println("Report portal is displayed");
		takeScreenshotAtEndOfTest();
		driver.quit();
		
	}

}