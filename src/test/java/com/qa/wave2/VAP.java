package com.qa.wave2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class VAP extends CommonMethods {

	/***************************** Test Data *******************/
	
	final String Browser = "IE";
	final String Url = "https://sjvapsqlprdn01/assetexplorer/";
	final String Url_App = "https://sjvapappprdn01/assetexplorer/";
	
	final String Username = "Admin";
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
	
	@Test(priority = 2, enabled = false)
	public void VAP_S01_Windows_Web_Vibration_Analysis_Verfication() {
		TM_VAP_S01_Windows_Web_Vibration_Analysis_Verfication();
	}

	@Test(priority = 1, enabled = true) 
	public void VAP_S02_Windows_Web_Machine_Journal_Verfication() {
		TM_VAP_S02_Windows_Web_Machine_Journal_Verfication();
	}
	
	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */

	By lnk_Continue = By.cssSelector("#overridelink");
	By ipt_Username = By.cssSelector("#Username");
	By ipt_Password = By.cssSelector("#Password");
	By btn_Login = By.cssSelector(".btn.btn-primary.display-loading-on-click");
	By menu_AppMenu = By.cssSelector(".ema-as-icon");
	By opt_Vibration_Analysis = By.xpath("//*[contains(text(),'Vibration Analyzer')]");
	By opt_Machine_Journal = By.xpath("//*[contains(text(),'Machine Journal')]");
	By menu_UserMenu = By.cssSelector(".AccountImage");
	By menu_Logout = By.xpath("//a[@href='/AssetExplorer/Logout']");
	

	/***************************** Test Case Methods *******************/

	void TM_VAP_S01_Windows_Web_Vibration_Analysis_Verfication() {
		
		WebElement Vibration_Analysis = createWebElementBy(opt_Vibration_Analysis);
		mouseHover(Vibration_Analysis);
		Vibration_Analysis.click();
		takeScreenshotAtEndOfTest();
		//Assert.assertEquals("", "");
	}

	void TM_VAP_S02_Windows_Web_Machine_Journal_Verfication(){

		try {
			DecrptPassword = decrypt("jkZ6wa4Z2KM4dVjKyZh9VQ==");
			System.out.println(DecrptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		launchBrowser(Browser, Url);
		createWebElementBy(lnk_Continue).click();
		waitForPageLoaded();
		createWebElementBy(ipt_Username).sendKeys(Username);
		createWebElementBy(ipt_Password).sendKeys(DecrptPassword);
		createWebElementBy(btn_Login).click();
		waitForPageLoaded();
		createWebElementBy(menu_AppMenu).click();
		WebElement Machine_Journal = createWebElementBy(opt_Machine_Journal);
		mouseHover(Machine_Journal);
		Machine_Journal.click();
		windowhandle();
		waitForPageLoaded();
		createWebElementBy(ipt_Username).sendKeys(Username);
		createWebElementBy(ipt_Password).sendKeys(DecrptPassword);
		createWebElementBy(btn_Login).click();
		waitForPageLoaded();
		createWebElementBy(menu_AppMenu).click();
		mouseHover(Machine_Journal);
		Machine_Journal.click();
		windowhandle();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		driver.switchTo().defaultContent();
		
	}
}
