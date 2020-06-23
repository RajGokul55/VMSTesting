package com.qa.wave3;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class WinSAS extends CommonMethods {

	/***************************** Test Data *******************/
	
	final String Browser = "IE";
	//Prod Url
	//final String Url = "https://gadi2.gilead.com";
	//Dev Url
	final String Url = "https://gadi2dev.gilead.com";
	//Val Url
	//final String Url = "https://gadi2val.gilead.com";
	
	final String Username = "psonawane";
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

	@BeforeSuite(enabled = true)
	void EncriptPassword() throws Exception {
		DecrptPassword = decrypt("e19ncVNSmW6OrHZf9mDsAg==");
	
	}

	@Test(priority = 0, enabled = true)
	public void WinSAS_S01_Windows_Web_URL_Verfication() {
		TM_WinSAS_S01_Windows_Web_URL_Verfication();
	}

	@Test(dependsOnMethods = {"WinSAS_S01_Windows_Web_URL_Verfication"}, enabled = true) 
	public void WinSAS_S02_Windows_Web_Login_Verfication() {
		TM_WinSAS_S02_Windows_Web_Login_Verfication();
	}

	@Test(dependsOnMethods = {"WinSAS_S02_Windows_Web_Login_Verfication"}, enabled = true) 
	public void WinSAS_S03_Windows_Web_Adobe_Verfication() {
		TM_WinSAS_S03_Windows_Web_Adobe_Verfication();
	}


	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */

	By ipt_Username = By.cssSelector("#login");
	By ipt_Password = By.cssSelector("#passwd");
	By btn_LogOn = By.cssSelector("#loginBtn");
	By text_User = By.cssSelector(".theme-header-color.user-display-name._ctxstxt_Menu");
	By img_APPS = By.cssSelector("#allAppsBtn");
	By img_Adobe = By.xpath("//*[@class='storeapp-name' and contains(text(), 'Adobe Acrobat DC')]");
	By img_IE_Winsas = By.xpath("//*[@class='storeapp-name' and contains(text(), 'IE-Winsas')]");
	By img_Word = By.xpath("//*[@class='storeapp-name' and contains(text(), 'Adobe Acrobat DC')]");
	By img_Excel = By.xpath("//*[@class='storeapp-name' and contains(text(), 'Adobe Acrobat DC')]");
	By img_PowerPoint = By.xpath("//*[@class='storeapp-name' and contains(text(), 'Adobe Acrobat DC')]");
	By img_SAS9v4 = By.xpath("//*[@class='storeapp-name' and contains(text(), 'Adobe Acrobat DC')]");
	By img_SAS_Viewer = By.xpath("//*[@class='storeapp-name' and contains(text(), 'Adobe Acrobat DC')]");


	String Actual_Title = "GADI2Dev Internal";
	String User = "Pravin Sonawane (Contractor)";
	/***************************** Test Case Methods *******************/

	void TM_WinSAS_S01_Windows_Web_URL_Verfication() {
		launchBrowser(Browser, Url);
		wait(2);
		String Title = driver.getTitle();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(Title, Actual_Title);
	}

	void TM_WinSAS_S02_Windows_Web_Login_Verfication(){
		createWebElementBy(ipt_Username).sendKeys(Username);
		createWebElementBy(ipt_Password).sendKeys(DecrptPassword);;
		createWebElementBy(btn_LogOn).click();
		wait(2);
		String actual_User = createWebElementBy(text_User).getText();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(actual_User, User);
	}
	
	void TM_WinSAS_S03_Windows_Web_Adobe_Verfication() {
		createWebElementBy(img_APPS).click();
		createWebElementBy(img_Adobe).click();
	}

}
