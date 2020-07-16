package com.qa.wave3;

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

public class EmailExchange extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	// QUAL - NA Environment URL
	final String Url = "https://webmail.gilead.qual/";
	// Dev - NA Environment URL
	final String Url1 = "https://webmail.devgilead.com/";
	final String username = "Qualna\\vms_na";
	final String username1 = "nadevgilead\\vms_na";
	String EncryptPassword = "oS/IEr+DLbi9e3BgMmZRHA==";
	private String DecrptPassword;
	
	String ToMailID ="VMS_NA@qagilead.com";
	String ToMailID1 ="VMS_NA@devgilead.com";
	String SubjectText ="Test Mail ";

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

	// QUAL Environment
	@Test(priority = 0, enabled = true)
	public void EmailExchange_S01_Web_login_verifyscreen_Qual() {
		TM_EmailExchange_S01_Web_VerifyEmailExchange_Qual();

	}
	
	// DEV Environment
		@Test(priority = 0, enabled = false)
		public void EmailExchange_S01_Web_login_verifyscreen_Dev() {
			TM_EmailExchange_S01_Web_VerifyEmailExchange_Dev();

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
	By ipt_userName = By.xpath("//input[@id='username']");
	By ipt_password = By.xpath("//input[@id='password']");
	By btn_Login = By.xpath("//span[contains(text(),'sign in')]");
	By select_NewMail = By.cssSelector("#_ariaId_39");
	By btn_To = By.cssSelector("body.notIE8.customScrollBar.disableTextSelection.mainWindow.removeFocusOutline:nth-child(2) div._n_X4:nth-child(3) div.conductorContent div._n_p.csimg.image-headerbgmain-png:nth-child(3) div.conductorContent div._n_k2:nth-child(1) div._n_s2 div.allowTextSelection div.conductorContent div._mcp_Y:nth-child(4) div._mcp_Z:nth-child(2) div._mcp_01.ms-bg-color-white.customScrollBar:nth-child(1) div._mcp_81._mcp_b1._mcp_d1.ms-border-color-neutralTertiary:nth-child(3) div._mcp_p1._mcp_r1._mcp_q1._mcp_s1:nth-child(2) div._mcp_O1 div._rw_f._rw_h div._rw_f.allowTextSelection span.findControlWrapper div._fp_u form:nth-child(1) > input._fp_v.ms-font-color-neutralSecondary.textbox.allowTextSelection.ms-font-weight-regular.ms-border-color-neutralTertiary.ms-font-color-neutralPrimary.hideClearButton.placeholderText");
	By btn_Subject = By.cssSelector("body.notIE8.customScrollBar.disableTextSelection.mainWindow.removeFocusOutline:nth-child(2) div._n_X4:nth-child(3) div.conductorContent div._n_p.csimg.image-headerbgmain-png:nth-child(3) div.conductorContent div._n_k2:nth-child(1) div._n_s2 div.allowTextSelection div.conductorContent div._mcp_Y:nth-child(4) div._mcp_Z:nth-child(2) div._mcp_01.ms-bg-color-white.customScrollBar:nth-child(1) div._mcp_81._mcp_91._mcp_d1.ms-border-color-neutralTertiary:nth-child(7) div._mcp_p1._mcp_r1 div._mcp_O1:nth-child(5) > input._mcp_t1._mcp_u1.ms-font-weight-regular.ms-bg-color-white-hover.ms-font-color-neutralPrimary.textbox.allowTextSelection._mcp_r1.ms-border-color-neutralTertiary.placeholderText");
	By clk_Send = By.xpath("//span[contains(text(),'SEND')]");
	By inbox = By.xpath("//*[@id='_ariaId_68.folder']");
	By inboxDev = By.xpath("//*[@id='_ariaId_51.folder']");
	By inboxMail = By.cssSelector("body.notIE8.customScrollBar.disableTextSelection.mainWindow.removeFocusOutline:nth-child(2) div._n_X4:nth-child(3) div.conductorContent div._n_p.csimg.image-headerbgmain-png:nth-child(3) div.conductorContent div._n_k2:nth-child(1) div._n_s2 div._n_s2 div._n_K2:nth-child(6) div.conductorContent div._lv_b1:nth-child(1) div._lv_31.customScrollBar.scrollContainer div._lv_m1 div:nth-child(1) div:nth-child(2) div._lv_q._lv_u._lv_r div._lv_B.ms-font-l.ms-font-weight-semilight > div._lv_C:nth-child(1)");
	By newMail_Subject = By.cssSelector("body.notIE8.customScrollBar.disableTextSelection.mainWindow.removeFocusOutline:nth-child(2) div._n_X4:nth-child(3) div.conductorContent div._n_p.csimg.image-headerbgmain-png:nth-child(3) div.conductorContent div._n_k2:nth-child(1) div._n_s2 div.allowTextSelection div.conductorContent div._rp_e div._rp_e.allowTextSelection div._rp_f.allowTextSelection.customScrollBar.scrollContainer div:nth-child(2) div._rp_g:nth-child(1) div._rp_h.ms-font-color-neutralPrimary.ms-font-l.ms-font-weight-regular > span.rpHighlightAllClass.rpHighlightSubjectClass:nth-child(1)");
	
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	//QUAL
	public void TM_EmailExchange_S01_Web_VerifyEmailExchange_Qual() {

		login_verifyScreen();
		verifyMailBox();
		
	}
	
	//DEV
		public void TM_EmailExchange_S01_Web_VerifyEmailExchange_Dev() {

			login_verifyScreen_Dev();
			verifyMailBox_Dev();
			
		}
	
	

	public void login_verifyScreen() {
		
		waitForPageLoaded();
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
		wait(25);
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
	}
	
public void login_verifyScreen_Dev() {
		
		waitForPageLoaded();
		wait(2);
		WebElement userNameipt = createWebElementBy(ipt_userName);
		userNameipt.sendKeys(username1);

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
		wait(25);
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
	}

	
	public void verifyMailBox() {
		wait(2);
		WebElement NewMail = createWebElementBy(select_NewMail);
		NewMail.click();
		//wait(1);

		WebElement ToButton = createWebElementBy(btn_To);
		ToButton.sendKeys(ToMailID);
		wait(2);
		WebElement Subject = createWebElementBy(btn_Subject);
		Subject.sendKeys(SubjectText);
		takeScreenshotAtEndOfTest();
		WebElement Send = createWebElementBy(clk_Send);
		Send.click();
		takeScreenshotAtEndOfTest();
		wait(3);
		takeScreenshotAtEndOfTest();
		WebElement Inbox = createWebElementBy(inbox);
		Inbox.click();
		wait(2);
		takeScreenshotAtEndOfTest();
		WebElement InboxMail = createWebElementBy(inboxMail);
		InboxMail.click();
		wait(1);
		WebElement NewMail_Subject = createWebElementBy(newMail_Subject);
		IsDisplayed_IsEnabled(NewMail_Subject);
		wait(1);
		takeScreenshotAtEndOfTest();
	}
	
	public void verifyMailBox_Dev() {
		wait(2);
		WebElement NewMail = createWebElementBy(select_NewMail);
		NewMail.click();
		//wait(1);

		WebElement ToButton = createWebElementBy(btn_To);
		ToButton.sendKeys(ToMailID1);
		wait(2);
		WebElement Subject = createWebElementBy(btn_Subject);
		Subject.sendKeys(SubjectText);
		takeScreenshotAtEndOfTest();
		WebElement Send = createWebElementBy(clk_Send);
		Send.click();
		takeScreenshotAtEndOfTest();
		wait(3);
		takeScreenshotAtEndOfTest();
		WebElement Inbox_Dev = createWebElementBy(inboxDev);
		Inbox_Dev.click();
		wait(2);
		takeScreenshotAtEndOfTest();
		WebElement InboxMail = createWebElementBy(inboxMail);
		InboxMail.click();
		wait(1);
		WebElement NewMail_Subject = createWebElementBy(newMail_Subject);
		IsDisplayed_IsEnabled(NewMail_Subject);
		wait(1);
		takeScreenshotAtEndOfTest();
	}
	
}