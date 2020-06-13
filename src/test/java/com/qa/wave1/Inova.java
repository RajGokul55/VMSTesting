package com.qa.wave1;


import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class Inova extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sjinvappdevn01/inova-partner/ctx/auth/home";
	final String Username ="nnereddula";
	private String DecrptPassword;


	/***************************** Test Cases *******************/
	
	

	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void Inova_S03_PostPatch_Testing() {
		TM_Inova_S03_PostPatch_Testing();
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
	By btn_Companies = By.xpath("//span[@class='icon-label'][contains(text(),'Companies')]");
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
	
	void TM_Inova_S03_PostPatch_Testing() {
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);
		try {
			DecrptPassword = decrypt("Am9YI5J0dBK0RW1AK2utqw==");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		
		
		WebElement PopupOk_Btn = createWebElementBy(btn_PopupOK);
		takeScreenshotAtEndOfTest();
		PopupOk_Btn.click();
		
		
		WebElement PopupHome_Btn = createWebElementBy(btn_PopupHome);
		takeScreenshotAtEndOfTest();
		PopupHome_Btn.click();
		
		
		
		/******************validating tabs****************************/
		
		WebElement alliances_btn = createWebElementBy(icn_Alliances);
		alliances_btn.click();
		wait(3);

		takeScreenshotAtEndOfTest();
		WebElement Home_btn = createWebElementBy(btn_Home);
		Home_btn.click();
		wait(3);

		
		WebElement products_icn = createWebElementBy(icn_Products);
		products_icn.click();
		takeScreenshotAtEndOfTest();
				
		
		WebElement NewProducts_btn = createWebElementBy(btn_NewProducts);
		NewProducts_btn.click();
		wait(3);
		takeScreenshotAtEndOfTest();
		
		WebElement cancel_btn = createWebElementBy(btn_Cancel);
		cancel_btn.click();
		wait(2);
		
	
		
		WebElement companies_btn = createWebElementBy(btn_Companies);
		companies_btn.click();
		takeScreenshotAtEndOfTest();
		WebElement NewCompany_btn = createWebElementBy(btn_NewCompany);
		NewCompany_btn.click();
		wait(3);
		takeScreenshotAtEndOfTest();
		WebElement cancel_btn1 = createWebElementBy(btn_Cancel);
		cancel_btn1.click();
		wait(3);
		
		WebElement contacts_btn = createWebElementBy(btn_Contacts);
		contacts_btn.click();
		takeScreenshotAtEndOfTest();
		WebElement editcontacts_btn = createWebElementBy(btn_editContacts);
		editcontacts_btn.click();
		wait(3);
		takeScreenshotAtEndOfTest();
		WebElement cancel_btn2 = createWebElementBy(btn_Cancel);
		cancel_btn2.click();
		wait(3);
		
		
			
		WebElement Logout_Btn = createWebElementBy(btn_Logout);
		Logout_Btn.click();
		
	}
	

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here
}
