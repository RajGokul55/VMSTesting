package com.qa.wave3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class GAPPWEB extends CommonMethods {

	/***************************** Test Data *******************/
	String Browser = "Chrome";
	
	String FileroomProd =					"http://sdgnetapps/fileroom/Login.aspx";
	String DailyShipDashboardsProd =	 	"http://sdgnetapps/dailyshipdata/default.aspx";
	String SiteTrainingProd =				"http://sdgnetapps/sd/sd/sts/STS/STSMainframe.htm?Refresh='Yes'";
	String SiteEventRegistrationProd = 		"http://sdgnetapps/sd/sd/tickets/STS/STSMainframe.htm";
	String DailyOperationsDashboardProd =	"http://sdgnetapps/dashboardstest/WorkFlowChecklistSD.aspx#SD_Other";
	String ProductionScheduleProd = 		"http://sdgnetapps/sd/sd/ps/PS/PSMainframe.htm";
	String GILeadProd = 					"http://sdgnetapps/G-I_lead/";
	String BatchRecordErrorProd	= 			"http://sdgnetapps/BRE/";
	String ManufacturingDataProd =			"http://sdgnetapps/ManufacturingData/";
	String SiteTrainingDev =				"http://lvgappwebdevn01/sd/sd/sts/STS/STSMainframe.htm?Refresh='Yes'";
	String SiteEventRegistrationDev = 		"http://lvgappwebdevn01/sd/sd/tickets/STS/STSMainframe.htm";
	String DailyOperationsDashboardDev =	"http://lvgappwebdevn01/dashboardstest/WorkFlowChecklistSD.aspx#SD_Other";
	String ProductionScheduleDev =			"http://lvgappwebdevn01/sd/sd/ps/PS/PSMainframe.htm";
	String ManufacturingDataDev =			"http://lvgappwebdevn01/ManufacturingData/";
	
	/***************************** Test Cases *******************/
	
	/***************************** Locators *******************/
	// Example syntax:Css Selector: tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttonsc
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 */

	By lbe_SearchMode= By.cssSelector("span[id='ContentPlaceHolder4_lbl_note']");
	By lbe_Naviagte= By.cssSelector("div h1");
	By lbe_NetworkError= By.cssSelector("big");
	By lbe_NoAccess= By.cssSelector("body");
	By frm_LeftMenu= By.cssSelector("frame[id='LeftFrame']");
	By lbe_Shipping = By.cssSelector("div[id='accordion'] div:nth-child(1) a");
	By tbl_WorkFlow= By.cssSelector("div[id='accordion']");
	By lbl_LogOff= By.cssSelector("div[onclick='closeAll()']");
	By lbl_GILogo= By.cssSelector("div[class='LogoHead'] img");
	
			
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
	@AfterMethod(enabled = true)
	public void afterTest() {
		driver.quit();
	}
// Prod Test cases 
	@Test(priority = 1, enabled = true)
	public void GAPPWEB_S01_Web_FileroomProd() {
		launchBrowser(Browser, FileroomProd);
		EnsureAppLaunched(lbe_Naviagte);
	}	
	@Test(priority = 2, enabled = true)
	public void GAPPWEB_S02_Web_DailyShipDashboardsProd() {
		launchBrowser(Browser, DailyShipDashboardsProd);
		EnsureAppLaunched(lbe_Shipping);
	}
	@Test(priority = 3, enabled = true) // Network Error (dns_server_failure)
	public void GAPPWEB_S03_Web_SiteTrainingProd() {
		launchBrowser(Browser, SiteTrainingProd);
		WebElement LefttFrame = createWebElementBy(frm_LeftMenu);
		switchToFrameByLocator(LefttFrame);
		EnsureAppLaunched(lbe_NetworkError);
	}
	@Test(priority = 4, enabled = true) // No Access
	public void GAPPWEB_S04_Web_SiteEventRegistrationProd() {
		launchBrowser(Browser, SiteEventRegistrationProd);
		WebElement LefttFrame = createWebElementBy(frm_LeftMenu);
		switchToFrameByLocator(LefttFrame);
		EnsureAppLaunched(lbe_NoAccess);
	}
	@Test(priority = 5, enabled = true)
	public void GAPPWEB_S05_Web_DailyOperationsDashboardProd() {
		launchBrowser(Browser, DailyOperationsDashboardProd);
		EnsureAppLaunched(tbl_WorkFlow);
	}
	@Test(priority = 6, enabled = true)
	public void GAPPWEB_S06_Web_ProductionScheduleProd() {
		launchBrowser(Browser, ProductionScheduleProd);
		WebElement LefttFrame = createWebElementBy(frm_LeftMenu);
		switchToFrameByLocator(LefttFrame);
		EnsureAppLaunched(lbl_LogOff);
	}
	@Test(priority = 7, enabled = true)
	public void GAPPWEB_S07_Web_GILeadProd() {
		launchBrowser(Browser, GILeadProd);
		EnsureAppLaunched(lbl_GILogo);
	}
	@Test(priority = 8, enabled = true)
	public void GAPPWEB_S08_Web_BatchRecordErrorProd() {
		launchBrowser(Browser, BatchRecordErrorProd);
		EnsureAppLaunched(lbe_SearchMode);
	}
	@Test(priority = 9, enabled = true)
	public void GAPPWEB_S09_Web_ManufacturingDataProd() {
		launchBrowser(Browser, ManufacturingDataProd);
		EnsureAppLaunched(lbe_Naviagte);
	}
	
	
	// Dev Test cases 
	@Test(priority = 10, enabled = true) // Network Error (dns_server_failure)
	public void GAPPWEB_S10_Web_SiteTrainingDev() {
		launchBrowser(Browser, SiteTrainingDev);
		WebElement LefttFrame = createWebElementBy(frm_LeftMenu);
		switchToFrameByLocator(LefttFrame);
		EnsureAppLaunched(lbe_NetworkError);
	}	
	@Test(priority = 11, enabled = true)
	public void GAPPWEB_S11_Web_SiteEventRegistrationDev() {
		launchBrowser(Browser, DailyShipDashboardsProd);
		EnsureAppLaunched(lbe_Shipping);
	}
	@Test(priority = 12, enabled = true)
	public void GAPPWEB_S12_Web_DailyOperationsDashboardDev() {
		launchBrowser(Browser, DailyOperationsDashboardDev);
		EnsureAppLaunched(tbl_WorkFlow);
	}
	@Test(priority = 13, enabled = true)
	public void GAPPWEB_S13_Web_ProductionScheduleDev() {
		launchBrowser(Browser, ProductionScheduleDev);
		WebElement LefttFrame = createWebElementBy(frm_LeftMenu);
		switchToFrameByLocator(LefttFrame);
		EnsureAppLaunched(lbl_LogOff);
	}
	@Test(priority = 14, enabled = true)
	public void GAPPWEB_S14_Web_ManufacturingDataDev() {
		launchBrowser(Browser, ManufacturingDataDev);
		EnsureAppLaunched(lbe_Naviagte);
	}

	
	// Page Interaction Methods
	
			void EnsureAppLaunched(By locator) {
				WebElement searchMode = createWebElementBy(locator);  
				IsDisplayed_IsEnabled(searchMode);
				takeScreenshotAtEndOfTest();
			}
			
			

	
	
}
