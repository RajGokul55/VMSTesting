package com.qa.wave1;


import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class Inova extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sjinvappdevn01/inova-partner/ctx/auth/home";
	final String Username ="nnereddula";
	String DecrptPassword;
	final String EncrptPassword = "Am9YI5J0dBK0RW1AK2utqw==";


	/***************************** Test Cases *******************/
	/*
	 * Test case \u2018Test Name\u2019 naming convention: <AppName><TCNumber>_<TestCategory>_<Title>
	Definitions of terms:     
\u2022	AppName: short name of Application [String 5 -10 chars] i.e., TstMyApp, 
\u2022	TCNumber: Test case number [Numeric 2-3 digits] i.e, 01, 02,..
\u2022	TestCategory: Test case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB \u2026]
\u2022	Title: short title of test case based on context of test case  ie., ValidateCredntails
  	Test Name Example: Filkart_05_Web_ValidateCredntails.

	 * Test method name must be same as test case appended with TM example: 
	 */

	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=1, enabled=true)
	public void Inova_03_PostPatch_Testing() {
		TM_Inova_03_PostPatch_Testing();
	}


	@AfterMethod(enabled=true)
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector: tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 */

	By ipt_Username= By.xpath("//input[@name='j_username']");
	By ipt_Passwrod= By.xpath("//input[@name='j_password']");
	By btn_Login = By.xpath("//span[@class='ui-button-text']");
	
	By btn_PopupOK = By.xpath("//span[contains(text(),'Ok')]");
	By btn_PopupHome = By.xpath("//table[@class='main_page_layout']//a[1]");
	By btn_Home = By.xpath("//a[contains(text(),'Home')]");
	
	By img_Alliances= By.xpath("(//span[@id='groupImage_alliances']");
	By icn_Alliances= By.xpath("//span[@class='icon main-menu-icon icon-alliance']");

	By icn_Products=By.xpath("//span[@class='icon main-menu-icon icon-product']");
	By btn_NewProducts=By.xpath("//span[contains(text(),'New Product')]");
	By btn_Save=By.xpath("(//span[@class='ui-button-text'][contains(text(),'Save')])[1]");
	
	By btn_Companies = By.xpath("//span[contains(text(),'Companies')]");
	By btn_NewCompany=By.xpath("//span[contains(text(),'New Company')]");
	
	By btn_parentCompany=By.xpath("//div[@id='inova_qc_0']");
	By btn_Cancel=By.xpath("(//span[@class='ui-button-text'][contains(text(),'Cancel')])[1]");
	By btn_Contacts = By.xpath("//span[contains(text(),'Contacts')]");
	
	By btn_editContacts = By.xpath("(//span[@class='ui-button-text'][contains(text(),'Edit Page')])[1]");
	By btn_Logout = By.xpath("//a[contains(text(),'Logout')]");

	/*****************************Test Case Methods *******************/
	@SuppressWarnings("null")
	//For all WebElements may append type Example: Submit_Btn

	
	
/*******************Login page****************/
	
	void TM_Inova_03_PostPatch_Testing() {
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		try {
			DecrptPassword = decrypt(EncrptPassword); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		
		WebElement PopupOk_Btn = createWebElementBy(btn_PopupOK);
		PopupOk_Btn.click();
		
		WebElement PopupHome_Btn = createWebElementBy(btn_PopupHome);
		PopupHome_Btn.click();
		
		
		/******************validating tabs****************************/
		/*WebElement alliances_icn = createWebElementBy(img_Alliances);
		alliances_icn.click();*/

		WebElement alliances_btn = createWebElementBy(icn_Alliances);
		alliances_btn.click();

		WebElement Home_btn = createWebElementBy(btn_Home);
		Home_btn.click();

		
		WebElement products_icn = createWebElementBy(icn_Products);
		products_icn.click();
				
		
		WebElement NewProducts_btn = createWebElementBy(btn_NewProducts);
		NewProducts_btn.click();
		
		
		WebElement cancel_btn = createWebElementBy(btn_Cancel);
		cancel_btn.click();
		
		wait(3);
		
		WebElement Home_btn1 = createWebElementBy(btn_Home);
		Home_btn1.click();
		
		
		WebElement companies_btn = createWebElementBy(btn_Companies);
		companies_btn.click();
		
		WebElement NewCompany_btn = createWebElementBy(btn_NewCompany);
		NewCompany_btn.click();
		WebElement cancel_btn1 = createWebElementBy(btn_Cancel);
		cancel_btn1.click();
		
		WebElement Home_btn2 = createWebElementBy(btn_Home);
		Home_btn2.click();
		
		WebElement contacts_btn = createWebElementBy(btn_Contacts);
		contacts_btn.click();
		
		WebElement editcontacts_btn = createWebElementBy(btn_editContacts);
		editcontacts_btn.click();
		
		WebElement cancel_btn2 = createWebElementBy(btn_Cancel);
		cancel_btn2.click();
		WebElement Home_btn3 = createWebElementBy(btn_Home);
		Home_btn3.click();
		
			
		WebElement Logout_Btn = createWebElementBy(btn_Logout);
		Logout_Btn.click();
		
	}
	

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here
}
