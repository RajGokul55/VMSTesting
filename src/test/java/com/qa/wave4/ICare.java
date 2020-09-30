package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import junit.framework.Assert;

public class ICare extends CommonMethods {
	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String PrdURL = "http://ccpmcappprdn01/PCARE/Security/SignIn.aspx";
	private String DecrptPassword;

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


	String URL = PrdURL;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
	}
	
	@Test(priority=1, enabled=false)
	public void PB_S01_Web_Validate_HomePage() {
		TM_S01_Web_Validate_HomePage();
	}
	
	@Test(priority=2, enabled=false)
	public void PB_S02_Web_Validate_SiteMap_Dropdown() {
		TM_S02_Web_Validate_SiteMap_Dropdown();
	}
	
	@Test(priority=3, enabled=true)
	public void PB_S03_Web_Validate_MyEHSEvents() {
		TM_S03_Web_Validate_MyEHSEvents();
	}
	
	@Test(priority=4, enabled=false)
	public void PB_S04_Web_Validate_LogOut() {
		TM_S04_Web_Validate_LogOut();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
  	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 * txt_: Text
	 * crd_: Card
	 */
	
	By ipt_username 		=	By.cssSelector("#ctl00_PageContent_UserName");
	By ipt_password			=	By.cssSelector("#ctl00_PageContent_Password");
	By btn_ok				=	By.cssSelector("#ctl00_PageContent_OKButton__Button");
	By lnk_signout			=	By.cssSelector("a[id*='ctl00__PageHeader__'][title*='Sign Out']");
	By txt_signoutmsg		=	By.cssSelector("#ctl00_PageContent_SignOutMessage");
	By drp_sitemap			=	By.id("ctl00_PageContent_INT_SITE_MAP_IDFilter");
	By lnk_myehs			=	By.xpath("//tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/a[1]");
	By lnk_myehsevents		=	By.linkText("My EHS Events");
	By ipt_search			=	By.id("ctl00_PageContent_TBL_ACCIDENTSSearch");
	

	
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	public void TM_S01_Web_Validate_HomePage() {
		login();
		
		Assert.assertEquals("Home", driver.getTitle());
				
		logout();
		
	}
	
	public void TM_S02_Web_Validate_SiteMap_Dropdown() {
		login();
		
		WebElement SiteMap_Drp = createWebElementBy(drp_sitemap);
		selectDropdownValue(SiteMap_Drp, "Manufacturing");
		wait(5);
		takeScreenshotAtEndOfTest();
		
		WebElement SiteMap1_Drp = createWebElementBy(drp_sitemap);
		selectDropdownValue(SiteMap1_Drp, "Packaging");
		wait(5);
		takeScreenshotAtEndOfTest();
		
		logout();
	}
	
	public void TM_S03_Web_Validate_MyEHSEvents() {
		login();
		
		WebElement EHSevents_Lnk = createWebElementBy(lnk_myehs);
		EHSevents_Lnk.click();
		
		WebElement MyEHSEvents_Lnk = createWebElementBy(lnk_myehsevents);
		MyEHSEvents_Lnk.click();
		
		WebElement Search_Ipt = createWebElementBy(ipt_search);
		IsDisplayed_IsEnabled(Search_Ipt);
		
		logout();
	}
	
	public void TM_S04_Web_Validate_LogOut() {
		TM_S01_Web_Validate_HomePage();
	}
	
	
	
	//**********************Generic Test Cases **************************//
	public void login() {
		WebElement Username_Ipt = createWebElementBy(ipt_username);
		Username_Ipt.sendKeys("graj");
		
		try {
			DecrptPassword = decrypt("uyK8jwlrhC6ELFzIelj5Bw==");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement Password_Ipt = createWebElementBy(ipt_password);
		Password_Ipt.sendKeys(DecrptPassword);
		
		WebElement OK_Btn = createWebElementBy(btn_ok);
		OK_Btn.click();
		
		waitForPageLoaded();
		
	}
	
	public void logout() {
		
		WebElement SignOut_Lnk = createWebElementBy(lnk_signout);
		SignOut_Lnk.click();
		WebElement SignOut_Txt = createWebElementBy(txt_signoutmsg);
		IsDisplayed_IsEnabled(SignOut_Txt);
	}
}
