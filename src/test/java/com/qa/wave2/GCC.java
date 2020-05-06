package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class GCC extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	// Dev Environment URL
	final String Url = "https://sjgccwebdevg01/ui/login.action";
	// Prod Environment URL
	final String Url1 = "https://sjgccwebprdg01/ui/login.action";
	final String username = "arun.raj5";
	String EncryptPassword = "cHhqigjkE9lagBcklOFbJw==";
	private String DecrptPassword;

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
		launchBrowser(Browser, Url);
	}

	@Test(priority = 0, enabled = true)
	public void GCC_S01_Web_login_verifyscreen() {
		TM_GCC_S01_Web_login_verifyGCCScreen();

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
	By ipt_userName = By.xpath("//input[@id='userName-inputEl']");
	By ipt_password = By.xpath("//input[@id='password-inputEl']");
	By drp_GCCDomain = By.cssSelector("#authSelector-inputEl");
	By btn_Login = By.cssSelector("#loginBtn-btnEl");
	By select_Value = By.xpath("//*[@id='ext-37']");
	By btn_Domain = By.cssSelector("#isc_14");
	By click_User = By.cssSelector("#isc_K");
	By btn_Logout = By.xpath("//div[contains(text(),'Log Out')]");
	By heading_MainPage = By.xpath("//span[contains(text(),'vRealize Operations Manager')]");
	By btn_Dashboard = By.cssSelector("#objectNavigatorToolbarHomeBtn-btnInnerEl");
	By txt_inDashboard = By.xpath("//*[contains(text(),'Welcome to Dashboards!')]");
	By btn_Cluster = By.cssSelector("div:nth-child(2)>Section[class='sidenav-content'] div:nth-child(32)>li>span");
	// By btn_Cluster = By.xpath("//*[@id='ext-element-216']/span");
	By txt_inCluster = By.cssSelector("div[id^='objectcontent'][data-ref='bodyWrap']>div");
	By btn_vDS = By.cssSelector("div:nth-child(2)>Section[class='sidenav-content'] div:nth-child(33)>li>span");
	By txt_invDS = By.cssSelector("div[id^='objectcontent'][data-ref='bodyWrap']>div");
	By btn_ESXi = By.cssSelector("div:nth-child(2)>Section[class='sidenav-content'] div:nth-child(34)>li>span");
	By txt_ESXi = By.cssSelector("div[id^='objectcontent'][data-ref='bodyWrap']>div");
	By getSizeFor_IntergrationService = By.xpath("//*[@id='accordionContentPowerCenterIntegrationServicetype']");
	By getSizeFor_RepositoryService = By.xpath("//*[@id='accordionContentPowerCenterRepositoryServicetype']");
	By rdo_contentSelect = By.xpath("//input[@name='value(courseFileName)']");
	By btn_startScan = By.cssSelector("#action-start-scan");
	By tbl_policyTable = By.xpath("//*[@id=\"policy-table-table\"]/tbody/tr");
	By tbl_disTable = By.xpath("//*[@id=\"discoverTargetListTable\"]/tbody/tr");
	By btn_allIncidents = By.xpath("//table[4]/tbody[1]/tr[4]/td[1]/span[1]");
	By msg_saveSuccess = By.cssSelector("#web-status-message-155.message-content");

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_GCC_S01_Web_login_verifyGCCScreen() {

		login_verifyScreen();
		verifyDashboard();
		verifyCluster();
		verifyvDS();
		verifyESXi();
		// logout();
	}

	public void login_verifyScreen() {
		wait(2);
		WebElement Domain_Drp = createWebElementBy(drp_GCCDomain);
		wait(2);
		Domain_Drp.click();
		driver.findElement(By.xpath("//*[@id='authSelector-picker-listEl']//li[7]")).click();
		wait(2);

		WebElement userNameipt = createWebElementBy(ipt_userName);
		userNameipt.sendKeys(username);

		try {
			DecrptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement passwordipt = createWebElementBy(ipt_password);
		passwordipt.sendKeys(DecrptPassword);
		takeScreenshotAtEndOfTest();
		WebElement Login_btn = createWebElementBy(btn_Login);
		Login_btn.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
	}

	public void verifyDashboard() {
		// Main heading
		WebElement MainHeading = createWebElementBy(heading_MainPage);
		IsDisplayed_IsEnabled(MainHeading);
		takeScreenshotAtEndOfTest();
		// Dashboard screen
		WebElement Dashboard = createWebElementBy(btn_Dashboard);
		Dashboard.click();
		wait(2);
		takeScreenshotAtEndOfTest();

		// Switch to frame

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("size = " + size);
		wait(10);

		WebElement iframeSwitch = driver.findElement(By.xpath("//iframe[contains(@id,'textDisplay')]"));
		driver.switchTo().frame(iframeSwitch);
		System.out.println("Inside frame");

		WebElement DashboardText = createWebElementBy(txt_inDashboard);
		IsDisplayed_IsEnabled(DashboardText);
		driver.switchTo().defaultContent();
		System.out.println("Outside frame");
		takeScreenshotAtEndOfTest();
	}

	public void verifyCluster() {
		wait(2);
		WebElement Cluster = createWebElementBy(btn_Cluster);
		Cluster.click();
		wait(3);

		WebElement ClusterText = createWebElementBy(txt_inCluster);
		IsDisplayed_IsEnabled(ClusterText);
		System.out.println("Cluster screen & text is displayed");
		takeScreenshotAtEndOfTest();
	}

	public void verifyESXi() {

		WebElement ESXi = createWebElementBy(btn_ESXi);
		ESXi.click();
		wait(3);

		WebElement ESXiText = createWebElementBy(txt_ESXi);
		IsDisplayed_IsEnabled(ESXiText);
		System.out.println("ESXi screen & text is displayed");
		takeScreenshotAtEndOfTest();
	}

	public void verifyvDS() {

		WebElement vDS = createWebElementBy(btn_vDS);
		vDS.click();
		wait(2);

		WebElement vDSText = createWebElementBy(txt_invDS);
		IsDisplayed_IsEnabled(vDSText);
		System.out.println("vDS screen & text is displayed");

		takeScreenshotAtEndOfTest();
	}

	public void logout() {

		WebElement clickUser = createWebElementBy(click_User);
		clickUser.click();
		System.out.println("clicked User account");
		wait(5);
		WebElement clickLogout = createWebElementBy(btn_Logout);
		clickLogout.click();
		// waitForPageLoaded();
		wait(3);
		System.out.println("clicked logout");
		// boolean PopupText = isElementExit(popup_Text);
		// System.out.println("Popup text is displayed = " +PopupText);

		// WebElement clickOk = createWebElementBy(btn_Ok);
		takeScreenshotAtEndOfTest();
		// clickOk.click();
	}

}