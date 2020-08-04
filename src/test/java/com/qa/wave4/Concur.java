package com.qa.wave4;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Concur extends CommonMethods {
	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String TstUrl = "https://implementation.concursolutions.com/nui/signin";
	final String UserName = "gokul.raj@gilead.com";
	private String DecrptPassword;
	String repname = "Test";
	String busipurp = "Post patch testing";

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


	String URL = TstUrl;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
		try {
			DecrptPassword = decrypt("ykbNGi34KTuX3FyA/tCB2A==");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WebElement SignIn_Txt = createWebElementBy(txt_signIn);
		//Assert.assertTrue(SignIn_Txt.getText().contains("Sign In"), "The homepage is not loaded");
	}
	
	@Test(priority=1, enabled=true)
	public void CI_S01_Web_Validate_Login() {
		TM_S01_Web_Validate_Login();
	}
	
	@Test(priority=2, enabled=true)
	public void CI_S02_Web_Create_Report() {
		TM_S02_Web_Create_Report();
	}
	
	@Test(priority=3, enabled=true)
	public void CI_S03_Web_Delete_Report() {
		TM_S03_Web_Delete_Report();
	}
	
	@Test(priority=4, enabled=true)
	public void CI_S04_Web_Validate_AppCentre() {
		TM_S04_Web_Validate_AppCentre();
	}
	
	@Test(priority=5, enabled=true)
	public void CI_S05_Web_Validate_Logout() {
		TM_S05_Web_Validate_Logout();
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
	
	By txt_signIn		=	By.xpath("//span[contains(text(),'Sign In')]");
	By ipt_userName		=	By.id("username-input");
	By btn_submit		=	By.id("btnSubmit");
	By ipt_password		=	By.id("password");
	By img_gilead		=	By.cssSelector("#brandinglogo");
	By btn_profile		=	By.xpath("/html/body/div[3]/div/div/nav[2]/div/button/div[1]");
	By btn_signout		=	By.xpath("//div[1]/div[1]/div[1]/div[2]/div[1]/button[1]");
	By btn_expense		=	By.cssSelector("a[data-test^='menu__anchor-expense']");
	By txt_mngexpnse	=	By.xpath("//div[1]/div[1]/div[1]/div[6]/div[1]/span[1]/div[1]");
	By lnk_createrep	=	By.xpath("//a[@class='cnqr-outer']");
	By ipt_repname		=	By.cssSelector("#Report_2411_TRAVELER_ISNEW_Name");
	By ipt_businessp	=	By.cssSelector("#Report_2411_TRAVELER_ISNEW_Purpose");
	By btn_next			=	By.cssSelector("#ext-gen200");
	By txt_repname		=	By.cssSelector("#ReportInfoDivActiveReport");
	By lnk_repname		=	By.xpath("//h3[@class='cnqr-force-wrap']");
	By btn_delrep		=	By.xpath("//table[@id='DeleteReportButtonEdit']");
	By btn_cnfyes		=	By.cssSelector("td.x-toolbar-cell:nth-child(2) table.x-btn.greenBtn.x-btn-noicon tbody.x-btn-small.x-btn-icon-small-left tr:nth-child(2) td.x-btn-mc > em:nth-child(1)");
	By btn_appcentre	=	By.xpath("//a[contains(text(),'App Center')]");
	By txt_noreport		=	By.xpath("//div[@class='cnqr-outer']//div[@class='cnqr-inner']");
	
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn	
	
	public void TM_S01_Web_Validate_Login() {
		login();	
		
		WebElement Gilead_Img = createWebElementBy(img_gilead);
		Assert.assertTrue(Gilead_Img.isDisplayed(), "The login was unsuccessful");
		
		logout();
	}
	
	public void TM_S02_Web_Create_Report() {
		login();
		
		WebElement Expense_Btn = createWebElementBy(btn_expense);
		Expense_Btn.click();
		
		WebElement ManageExpense_Txt = createWebElementBy(txt_mngexpnse);
		Assert.assertTrue(ManageExpense_Txt.getText().contains("Manage Expenses"), "The page was not loaded successfully");
		
		WebElement CreateReport_Lnk = createWebElementBy(lnk_createrep);
		CreateReport_Lnk.click();
		
		WebElement ReportName_Ipt = createWebElementBy(ipt_repname);
		ReportName_Ipt.sendKeys(repname);
		
		WebElement BusinessPurpose_Ipt = createWebElementBy(ipt_businessp);
		BusinessPurpose_Ipt.sendKeys(busipurp);
		
		WebElement Next_Btn = createWebElementBy(btn_next);
		Next_Btn.click();
		
		WebElement RepName_Txt = createWebElementBy(txt_repname);
		Assert.assertTrue(RepName_Txt.getText().equals(repname), "The report is not created");
		
		logout();
	}
	
	public void TM_S03_Web_Delete_Report() {
		login();
		
		WebElement Expense_Btn = createWebElementBy(btn_expense);
		Expense_Btn.click();
		
		WebElement RepName_Lnk = createWebElementBy(lnk_repname);
		
		if(RepName_Lnk.getText().equals(repname)) {
			RepName_Lnk.click();
		}else {
			Assert.fail("The report was not found");
		}
		
		WebElement Delete_Btn = createWebElementBy(btn_delrep);
		Delete_Btn.click();
		
		WebElement CfnYes_Btn = createWebElementBy(btn_cnfyes);
		CfnYes_Btn.click();
		
		WebElement NoReport_Txt = createWebElementBy(txt_noreport);
		Assert.assertTrue(NoReport_Txt.isDisplayed(), "The reports exists still");
		
		logout();
	}
	
	public void TM_S04_Web_Validate_AppCentre() {
		login();
		
		WebElement AppCentre_Btn = createWebElementBy(btn_appcentre);
		AppCentre_Btn.click();
		
		Assert.assertTrue(driver.getTitle().contains("Sorry, we can't find the page you were looking for."), "The page was not loaded as expected");
		
		WebElement Expense_Btn = createWebElementBy(btn_expense);
		Expense_Btn.click();
		
		logout();
	}
	
	public void TM_S05_Web_Validate_Logout() {
		login();
		
		logout();
	}
	
	
	/************************************* Generic Test Cases ***********************************/
	public void login() {
		WebElement UserName_Ipt = createWebElementBy(ipt_userName);
		UserName_Ipt.sendKeys(UserName);
		
		WebElement Next_Btn = createWebElementBy(btn_submit);
		Next_Btn.click();
		
		waitForPageLoaded();
		
		WebElement Password_Ipt = createWebElementBy(ipt_password);
		Password_Ipt.sendKeys(DecrptPassword);
		
		WebElement Submit_Btn = createWebElementBy(btn_submit);
		Submit_Btn.click();
		waitForPageLoaded();
	}
	
	public void logout() {
		WebElement Profile_Btn = createWebElementBy(btn_profile);
		Profile_Btn.click();
		
		WebElement SignOut_Btn = createWebElementBy(btn_signout);
		SignOut_Btn.click();
		
		WebElement SignIn_Txt = createWebElementBy(txt_signIn);
		Assert.assertTrue(SignIn_Txt.getText().contains("Sign In"), "The Sign out was unsuccessful");
		
	}

}
