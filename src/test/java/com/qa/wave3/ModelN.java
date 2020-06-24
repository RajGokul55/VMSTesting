package com.qa.wave3;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ModelN extends CommonMethods {
	/***************************** Test Data *******************/

	final String Browser = "IE";
	final String DevUrl = "http://fcmdnappdevn02/modeln/app/launchPage.html";
	String usrname = "graj";
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


	String URL = DevUrl;
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		launchBrowser(Browser, URL);
		driver.findElement(By.xpath("//button[contains(text(),'Launch Model N')]")).click();
		Thread.sleep(3000);
		System.out.println(driver.getWindowHandle());
		for(String winHandle : driver.getWindowHandles()){
			System.out.println(winHandle); 
			driver.switchTo().window(winHandle); 
		}

		login();	
	}

	@Test(priority=1, enabled=false)
	public void MN_S01_Web_Validate_Homepage() {
		TM_S01_Web_Validate_Homepage();
	}

	@Test(priority=2, enabled=false)
	public void MN_S02_Web_Validate_Customer_Tab() {
		TM_S02_Web_Validate_Customer_Tab();
	}

	@Test(priority=3, enabled=false)
	public void MN_S03_Web_Validate_Products_Tab() throws InterruptedException {
		TM_S03_Web_Validate_Products_Tab();
	}

	@Test(priority=4, enabled=false)
	public void MN_S04_Web_Validate_Pricing_Tab() throws InterruptedException{
		TM_S04_Web_Validate_Pricing_Tab();
	}

	@Test(priority=5, enabled=false)
	public void MN_S05_Web_Validate_Contracts_Tab() throws InterruptedException{
		TM_S05_Web_Validate_Contracts_Tab();
	}

	@Test(priority=6, enabled=false)
	public void MN_S06_Web_Validate_Compliance_Tab() throws InterruptedException{
		TM_S06_Web_Validate_Compliance_Tab();
	}

	@Test(priority=7, enabled=true)
	public void MN_S07_Web_Validate_Sales_Tab() throws InterruptedException{
		TM_S07_Web_Validate_Sales_Tab();
	}

	@Test(priority=8, enabled=true)
	public void MN_S08_Web_Validate_Utilisation_Tab() throws InterruptedException{
		TM_S08_Web_Validate_Utilisation_Tab();
	}

	@Test(priority=9, enabled=true)
	public void MN_S09_Web_Validate_RebateAndFess_Tab() throws InterruptedException{
		TM_S09_Web_Validate_RebateAndFees_Tab();
	}

	@Test(priority=10, enabled=true)
	public void MN_S10_Web_Validate_MedicAid_Tab() throws InterruptedException{
		TM_S10_Web_Validate_MedicAid_Tab();
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

	By ipt_username		=	By.cssSelector("#userName");
	By ipt_password		=	By.cssSelector("#password");
	By btn_login		=	By.xpath("//input[@name='login']");
	By btn_customerMenu	=	By.cssSelector("div[id^='OID'][class^='rightMenu '] button[name*='customersMenu']");
	By btn_accounts		=	By.cssSelector("div[id^='OID'][class^='menu '] a[name*='rightMenu-Accounts']");
	By ipt_customernmf	=	By.cssSelector("td[class^='layoutForceElement'] input[name*='customerName0']");
	By btn_home			=	By.cssSelector("div.navSection div.CMnBrowserControlBarComp.CMnContainerComp:nth-child(1) a.CMnButtonComp.CMnBaseRequestComp.CMnBaseFormComp.CMnBaseWidgetComp:nth-child(7) table:nth-child(1) tr:nth-child(1) td.center > img.icon");
	By btn_file			=	By.name("~123~-globalMenuBar-fileMenu-opener0");
	By btn_logout		=	By.xpath("//a[@id='CMnLogoutLinkComp']");
	By btn_productsMenu	=	By.cssSelector("button[name*='productsMenu-left']");
	By ipt_productsname	=	By.xpath("//tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[3]/a[1]");
	By btn_pricingMenu	=	By.cssSelector("button[name*='pricingMenu-left']");
	By txt_pricelookup 	=	By.xpath("//tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/a[1]");
	By btn_contracts	=	By.cssSelector("button[name*='contractsMenu-left']");
	By txt_contratcs	=	By.xpath("//tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/a[1]");
	By txt_homepage		=	By.xpath("//form[1]/div[2]/div[1]/div[1]/div[1]/span[1]");
	By btn_compliance	=	By.cssSelector("button[name*='complianceMenu-left']");
	By txt_customer		=	By.xpath("//table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/a[1]");
	By btn_sales		=	By.cssSelector("button[name*='salesFlexMenu-left']");

	By btn_utilisation 	=	By.cssSelector("button[name*='mcoMenu-left']");
	By txt_managed		=	By.xpath("//table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/a[1]");
	By btn_rebate		=	By.cssSelector("button[name*='rebatesMenu-left']");
	By txt_payment		=	By.xpath("//table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/a[1]");
	By btn_medicaid		=	By.cssSelector("button[name*='mcdMenu-left']");
	By txt_claims		=	By.xpath("//table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/a[1]");






	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn

	public void TM_S01_Web_Validate_Homepage() {
		System.out.println("Successfully logged in");

		WebElement frame1 = driver.findElement(By.id("documentIFrame"));
		driver.switchTo().frame(frame1);
		wait(2);

		WebElement HomePage_Txt = createWebElementBy(txt_homepage);
		Assert.assertTrue(HomePage_Txt.getText().equalsIgnoreCase("Home Page"), "The Homepage was not loaded successfully");

		takeScreenshotAtEndOfTest();
		logout();
	}

	public void TM_S02_Web_Validate_Customer_Tab() {
		System.out.println("Successfully logged in");

		WebElement CustomerMenu_Btn = createWebElementBy(btn_customerMenu);
		CustomerMenu_Btn.click();

		WebElement Accounts_Btn = createWebElementBy(btn_accounts);
		Accounts_Btn.click();

		WebElement frame1 = driver.findElement(By.id("documentIFrame"));
		driver.switchTo().frame(frame1);
		wait(2);	

		takeScreenshotAtEndOfTest();
		WebElement CustomerName_Ipt = createWebElementBy(ipt_customernmf);
		Assert.assertTrue(CustomerName_Ipt.isDisplayed(), "The page was not loaded");

		logout();		
	}

	public void TM_S03_Web_Validate_Products_Tab() throws InterruptedException {
		System.out.println("Successfully logged in");

		WebElement ProductsMenu_Btn = createWebElementBy(btn_productsMenu);
		ProductsMenu_Btn.click();

		WebElement frame1 = driver.findElement(By.id("documentIFrame"));
		driver.switchTo().frame(frame1);
		wait(2);	

		takeScreenshotAtEndOfTest();
		Thread.sleep(2000);
		WebElement ProductsName_Ipt = createWebElementBy(ipt_productsname);
		Assert.assertTrue(ProductsName_Ipt.isDisplayed(), "The page was not loaded");

		logout();
	}

	public void TM_S04_Web_Validate_Pricing_Tab() throws InterruptedException {
		System.out.println("Successfully logged in");

		WebElement PricingMenu_Btn = createWebElementBy(btn_pricingMenu);
		PricingMenu_Btn.click();

		WebElement frame1 = driver.findElement(By.id("documentIFrame"));
		driver.switchTo().frame(frame1);
		wait(2);	

		takeScreenshotAtEndOfTest();
		Thread.sleep(2000);
		WebElement PriceLookup_Txt = createWebElementBy(txt_pricelookup);
		Assert.assertTrue(PriceLookup_Txt.getText().equalsIgnoreCase("Price Lookup"), "The page was not loaded");

		logout();
	}

	public void TM_S05_Web_Validate_Contracts_Tab() throws InterruptedException {
		System.out.println("Successfully logged in");

		WebElement ContractsMenu_Btn = createWebElementBy(btn_contracts);
		ContractsMenu_Btn.click();

		WebElement frame1 = driver.findElement(By.id("documentIFrame"));
		driver.switchTo().frame(frame1);
		wait(2);	

		takeScreenshotAtEndOfTest();
		Thread.sleep(2000);
		WebElement Contracts_Txt = createWebElementBy(txt_contratcs);
		Assert.assertTrue(Contracts_Txt.getText().equalsIgnoreCase("Contracts"), "The page was not loaded");

		logout();
	}

	public void TM_S06_Web_Validate_Compliance_Tab() throws InterruptedException {
		System.out.println("Successfully logged in");

		WebElement ComplianceMenu_Btn = createWebElementBy(btn_compliance);
		ComplianceMenu_Btn.click();

		WebElement frame1 = driver.findElement(By.id("documentIFrame"));
		driver.switchTo().frame(frame1);
		wait(2);	

		takeScreenshotAtEndOfTest();
		Thread.sleep(2000);
		WebElement Customer_Txt = createWebElementBy(txt_customer);
		Assert.assertTrue(Customer_Txt.getText().equalsIgnoreCase("Customer Commitments"), "The page was not loaded");

		logout();
	}

	public void TM_S07_Web_Validate_Sales_Tab() throws InterruptedException{
		System.out.println("Successfully logged in");

		WebElement SalesMenu_Btn = createWebElementBy(btn_sales);
		SalesMenu_Btn.click();

		WebElement frame1 = driver.findElement(By.id("documentIFrame"));
		driver.switchTo().frame(frame1);
		wait(2);	

		takeScreenshotAtEndOfTest();
		Thread.sleep(2000);

		logout();
	}

	public void TM_S08_Web_Validate_Utilisation_Tab() throws InterruptedException {
		System.out.println("Successfully logged in");

		WebElement UtilisationMenu_Btn = createWebElementBy(btn_utilisation);
		UtilisationMenu_Btn.click();

		WebElement frame1 = driver.findElement(By.id("documentIFrame"));
		driver.switchTo().frame(frame1);
		wait(2);	

		takeScreenshotAtEndOfTest();
		Thread.sleep(2000);
		WebElement Managed_Txt = createWebElementBy(txt_managed);
		Assert.assertTrue(Managed_Txt.getText().equalsIgnoreCase("Managed Care Claims"), "The page was not loaded");

		logout();
	}

	public void TM_S09_Web_Validate_RebateAndFees_Tab() throws InterruptedException {
		System.out.println("Successfully logged in");

		WebElement RebateMenu_Btn = createWebElementBy(btn_rebate);
		RebateMenu_Btn.click();

		WebElement frame1 = driver.findElement(By.id("documentIFrame"));
		driver.switchTo().frame(frame1);
		wait(2);	

		takeScreenshotAtEndOfTest();
		Thread.sleep(2000);
		WebElement Payment_Txt = createWebElementBy(txt_payment);
		Assert.assertTrue(Payment_Txt.getText().equalsIgnoreCase("Payment Packages"), "The page was not loaded");

		logout();
	}

	public void TM_S10_Web_Validate_MedicAid_Tab() throws InterruptedException {
		System.out.println("Successfully logged in");

		WebElement RebateMenu_Btn = createWebElementBy(btn_medicaid);
		RebateMenu_Btn.click();

		WebElement frame1 = driver.findElement(By.id("documentIFrame"));
		driver.switchTo().frame(frame1);
		wait(2);	

		takeScreenshotAtEndOfTest();
		Thread.sleep(2000);
		WebElement Claims_Txt = createWebElementBy(txt_claims);
		Assert.assertTrue(Claims_Txt.getText().equalsIgnoreCase("Claims"), "The page was not loaded");

		logout();
	}


	/************************************* Generic Test Cases ************************************/

	public void login() {
		wait(2);
		WebElement UserName_Ipt = createWebElementBy(ipt_username);
		UserName_Ipt.sendKeys(usrname);
		try {
			DecrptPassword = decrypt("2rZ5V/Mvbk3BcaoyxcwLRg==");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement Password_Ipt = createWebElementBy(ipt_password);
		Password_Ipt.sendKeys(DecrptPassword);

		WebElement Login_Btn = createWebElementBy(btn_login);
		Login_Btn.click();
	}

	public void logout() {

		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		wait(2);
		WebElement Home_Btn = createWebElementBy(btn_home);
		Home_Btn.click();

		WebElement File_Btn = createWebElementBy(btn_file);
		File_Btn.click();

		WebElement LogOut_Btn = createWebElementBy(btn_logout);
		LogOut_Btn.click();
		wait(2);

	}

}
