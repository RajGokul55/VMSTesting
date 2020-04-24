

package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




public class GPRS extends CommonMethods{

	//private static final String WebElementDrop = null;
	///***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sjgprsappuatn01.na.gilead.com/aims/ps/Default.aspx";
	final String CorporateUrl= "https://reset.gilead.com/aims/ps/Main.aspx";

	final String Username ="nnereddula";
	private String DecrptPassword;
	String EncryptPwd = "maF92iz73RYQ2imnwwuCsA==";



	/***************************** Test Cases *******************/


	@Test(priority=1, enabled=true)
	public void GPRS_S03_Web_Testurlaccessible() {
		TM_GPRS_S03_Web_Testurlaccessible(Url);
	}

	@Test(priority=2, enabled=true)
	public void GPRS_S18_Web_EnrollmentFunctionality() {
		TM_GPRS_S18_Web_EnrollmentFunctionality(Url);
	}

	@Test(priority=0, enabled=true)
	public void GPRS_S01_Web_Testurlaccessible() {
		TM_GPRS_S01_Web_Testurlaccessible(CorporateUrl);
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

	By ipt_Username= By.xpath("//input[@id='editUserID']");
	By ipt_Passwrod= By.xpath("//input[@id='idx_app_LoginFrame_0Password']");
	By ipt_userid=By.xpath("//input[@id='editUserID']");
	By drp_Domain = By.xpath("//select[@id='listDomains']");
	By btn_DomainValue = By.xpath("(//option[contains(text(),'QUALNA')]");
	By btn_Agree = By.xpath("(//input[@id='btnTextIAgree'])");
	By img_forgotPWD= By.xpath("(//img[@id='imgForgotPassword']");
	By btn_yesfrgtpwd=By.xpath("//input[@id='ButtonYes']");

	By img_ChangePWD=By.xpath("//img[@id='imgChangePassword']");
	By img_enrollment = By.xpath("//input[@id='btnEnroll']");
	By ipt_enrollPwd=By.xpath("//input[@id='txtPassword']");
	By btn_continue= By.xpath("//input[@id='ButtonTextContinue']");
	By btn_cancel= By.xpath("//input[@id='ButtonTextCancel']']");
	By icn_homepage = By.xpath("//div[@class='logo PS']");
	By btn_ChPWDctn = By.xpath("//input[@id='ButtonContinue']");
	By btn_Signout = By.xpath("//div[@class='signOutText']");



	/*****************************Test Case Methods *******************/
	@SuppressWarnings("null")
	//For all WebElements may append type Example: Submit_Btn



	/*******************Login page****************/

	void TM_GPRS_S03_Web_Testurlaccessible(String Url) {
		
		launchBrowser(Browser,Url);

		Select dropdown = new Select(driver.findElement(By.id("listDomains")));  
		dropdown.selectByVisibleText("QUALNA"); 


		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);
		takeScreenshotAtEndOfTest();

		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();


		waitForPageLoaded();
	}


	/*********************ENROLLMENT FUNCTIONALITY**************************/

	void TM_GPRS_S18_Web_EnrollmentFunctionality(String Url) {
		launchBrowser(Browser,Url);
		
		Select dropdown = new Select(driver.findElement(By.id("listDomains")));  
		dropdown.selectByVisibleText("QUALNA"); 


		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);
		takeScreenshotAtEndOfTest();

		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();
		
		WebElement enrollment_img = createWebElementBy(img_enrollment);
		enrollment_img.click();
		waitForPageLoaded();
		
		try {
			DecrptPassword = decrypt(EncryptPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement enroll_Ipt = createWebElementBy(ipt_enrollPwd);
		enroll_Ipt.sendKeys(DecrptPassword);	
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();

		WebElement Continue_Btn = createWebElementBy(btn_continue);
		Continue_Btn.click();

		WebElement homepage_icn = createWebElementBy(icn_homepage);
		takeScreenshotAtEndOfTest();
		homepage_icn.click();



		WebElement signout_Btn = createWebElementBy(btn_Signout);
		takeScreenshotAtEndOfTest();
		signout_Btn.click();



	}

	/************************Login Corporate URL***************************/



	void TM_GPRS_S01_Web_Testurlaccessible(String CroUrl) {

		launchBrowser(Browser,CroUrl );  

		Select dropdown = new Select(driver.findElement(By.id("listDomains")));  
		dropdown.selectByVisibleText("NA");  


		WebElement Username_Ipt = createWebElementBy(ipt_userid);
		Username_Ipt.sendKeys(Username);
		takeScreenshotAtEndOfTest();

		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		takeScreenshotAtEndOfTest();
		Agree_Btn.click();
		waitForPageLoaded();

		WebElement signout_Btn = createWebElementBy(btn_Signout);
		takeScreenshotAtEndOfTest();

		signout_Btn.click();

	}


	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here

}