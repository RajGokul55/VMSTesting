package com.qa.wave2;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class UiPath extends CommonMethods{
	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	// URL for UiPath Prod env
	final String PrdUrl = "https://sjuiptappprdn01.na.gilead.com/";
	private String UserName = "graj";
	private String DecrptPassword;
	String EncryptPassword = "EGEACZoCQaq1AQaR+KTQ6Q==";

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
	

	String URL = PrdUrl;
	
  @BeforeMethod
  public void beforeMethod() {
	  launchBrowser("Chrome", URL);
	  login();
  }

  @Test(priority=1, enabled=true)
  public void UIPATH_S01_Web_Login_Verification() {
	  TM_S01_Web_Login_Verification();
  }
  
  @Test(priority=2, enabled=true)
  public void UIPATH_S02_Web_Monitoring_Tab_Validate() {
	  TM_S02_Web_Monitoring_Tab_Validate();
  }
  
  @Test(priority=3, enabled=true)
  public void UIPATH_S03_Web_Robots_Tab_Validate() {
	  TM_S03_Web_Robots_Tab_Validate();
  }
  
  @Test(priority=4, enabled=true)
  public void UIPATH_S04_Web_Processes_Tab_Validate() {
	  TM_S04_Web_Processes_Tab_Validate();
  }
  
  @Test(priority=5, enabled=true)
  public void UIPATH_S05_Web_Jobs_Tab_Validate() {
	  TM_S05_Web_Jobs_Tab_Validate();
  }
  
  @AfterMethod
  public void afterMethod() {
	  logout();
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

	
	By txt_login		=	By.className("card-title");
	By ipt_usrname		=	By.cssSelector("#mat-input-0");
	By ipt_password		=	By.cssSelector("#mat-input-1");
	By chk_rememberme	=	By.className("mat-checkbox-inner-container");
	By btn_login		=	By.xpath("//span[contains(text(),'Login')]");
	By txt_homeText		=	By.cssSelector("#FullLogo");
	By btn_monitoring	=	By.xpath("//span[contains(text(),'Monitoring')]");
	By lnk_stabText		=	By.xpath("//a[@class='single active']");
	By lnk_dtabText		=	By.xpath("//a[@class='active']");
	By crd_rbtsovrview	=	By.xpath("//ng-component[@class='ui-widget ng-star-inserted']//mat-card[@class='mat-card ng-star-inserted']");
	By txt_rbtsovrview	=	By.xpath("//span[contains(text(),'Robots Overview')]");
	By tbl_gridTable	=	By.xpath("//table[@class='ui-grid-table']");
	By btn_robots 		=	By.xpath("//span[contains(text(),'Robots')]");
	By btn_processes	=	By.xpath("//span[contains(text(),'Processes')]");
	By btn_jobs			=	By.xpath("//span[contains(text(),'Jobs')]");
	By btn_user			=	By.xpath("//button[@title='User']");
	By btn_logOut		=	By.xpath("//a[contains(text(),'Log Out')]");
	
	

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
  
	public void TM_S01_Web_Login_Verification() {
		takeScreenshotAtEndOfTest();
		WebElement HomePageText_Txt = createWebElementBy(txt_homeText);		
		Assert.assertTrue(HomePageText_Txt.isDisplayed(), "Error :: The UiPath web application is not loaded");
	}
	
	public void TM_S02_Web_Monitoring_Tab_Validate() {
		WebElement Monitoring_Btn = createWebElementBy(btn_monitoring);
		Monitoring_Btn.click();
		
		WebElement STabText_Lnk = createWebElementBy(lnk_stabText);
		Assert.assertEquals(STabText_Lnk.getText(), "Monitoring");
		
		takeScreenshotAtEndOfTest();
		
		WebElement RobotsOverview_Crd = createWebElementBy(crd_rbtsovrview);
		Assert.assertTrue(RobotsOverview_Crd.isDisplayed());
		
		WebElement RobotsOverview_Txt = createWebElementBy(txt_rbtsovrview);
		Assert.assertEquals(RobotsOverview_Txt.getText(), "Robots Overview");
	}
	
	public void TM_S03_Web_Robots_Tab_Validate(){
		WebElement Robots_Btn = createWebElementBy(btn_robots);
		Robots_Btn.click();
		
		WebElement DTabText_Lnk = createWebElementBy(lnk_dtabText);
		Assert.assertEquals(DTabText_Lnk.getText(), "Robots");
		
		takeScreenshotAtEndOfTest();
		
		WebElement GridTable_tbl = createWebElementBy(tbl_gridTable);
		Assert.assertTrue(GridTable_tbl.isDisplayed());
	}
	
	public void TM_S04_Web_Processes_Tab_Validate(){
		WebElement Processes_Btn = createWebElementBy(btn_processes);
		Processes_Btn.click();
		
		WebElement DTabText_Lnk = createWebElementBy(lnk_dtabText);
		Assert.assertEquals(DTabText_Lnk.getText(), "Processes");
		
		takeScreenshotAtEndOfTest();
		
		WebElement GridTable_tbl = createWebElementBy(tbl_gridTable);
		Assert.assertTrue(GridTable_tbl.isDisplayed());
	}
	
	public void TM_S05_Web_Jobs_Tab_Validate(){
		WebElement Jobs_Btn = createWebElementBy(btn_jobs);
		Jobs_Btn.click();
		
		WebElement STabText_Lnk = createWebElementBy(lnk_stabText);
		Assert.assertEquals(STabText_Lnk.getText(), "Jobs");
		
		takeScreenshotAtEndOfTest();
		
		WebElement GridTable_tbl = createWebElementBy(tbl_gridTable);
		Assert.assertTrue(GridTable_tbl.isDisplayed());		
	}
	
	/**********************************  Generic Method for this App ****************************/
	public void login() {
		waitForPageLoaded();
		WebElement Login_Txt = createWebElementBy(txt_login);
		Assert.assertEquals(Login_Txt.getText(), "Login");
		
		try {
			DecrptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement UserName_Ipt = createWebElementBy(ipt_usrname);
		UserName_Ipt.sendKeys(UserName);
		WebElement Password_Ipt = createWebElementBy(ipt_password);
		Password_Ipt.sendKeys(DecrptPassword);
		WebElement Login_Btn = createWebElementBy(btn_login);
		Login_Btn.click();
	}
	
	public void logout() {
		WebElement User_Btn = createWebElementBy(btn_user);
		User_Btn.click();
		WebElement LogOut_Btn = createWebElementBy(btn_logOut);
		LogOut_Btn.click();
		waitForPageLoaded();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("login"), "The logout was unsuccessfull");
	}
}
