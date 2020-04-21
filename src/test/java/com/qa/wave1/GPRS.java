

package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class GPRS extends CommonMethods{

	private static final String WebElementDrop = null;
	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sjgprsappuatn01.na.gilead.com/aims/ps/Default.aspx";
	final String Username ="nnereddula";
	private String DecrptPassword;


	/***************************** Test Cases *******************/
	
  	/*Test Name Example: Filkart_03_Web_ValidateCredntails */
	@BeforeSuite(enabled=true)
	void EncriptPassword() throws Exception {
		DecrptPassword = decrypt("MGhWvRKRMdkF0pu8i/E6pA==");
	}

	@BeforeTest(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void GPRS_S03_Web_Testurlaccessible() {
		TM_GPRS_S03_Web_Testurlaccessible();
	}

		
	@Test(priority=1, enabled=true)
	public void GPRS_S16_Web_Passwordchange() {
		TM_GPRS_S16_Web_Passwordchange();
	}

	@Test(priority=2, enabled=true)
	public void GPRS_S17_Web_PasswordReset() {
		TM_GPRS_S17_Web_PasswordReset();
	}

	@Test(priority=3, enabled=true)
	public void GPRS_S18_Web_EnrollmentFunctionality() {
		TM_GPRS_S18_Web_EnrollmentFunctionality();
	}


	@AfterTest(enabled=true)
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
	By drp_Domain = By.xpath("//select[@id='listDomains']");
	By btn_DomainValue = By.xpath("(//option[contains(text(),'QUALNA')]");
	By btn_Agree = By.xpath("(//input[@id='btnTextIAgree'])");
	By img_forgotPWD= By.xpath("(//img[@id='imgForgotPassword']");
	By btn_yesfrgtpwd=By.xpath("//input[@id='ButtonYes']");
	
	By img_ChangePWD=By.xpath("//img[@id='imgChangePassword']");
	By img_enrollment = By.xpath("//input[@id='btnEnroll']");
	By ipt_oldpassword= By.xpath("//input[@id='textOldPassword']");
	By ipt_Newpassword= By.xpath("//input[@id='textNewPassword']");
	By ipt_confirmpassword= By.xpath("//input[@id='textConfirm']");
	By ipt_enrollPwd=By.xpath("//input[@id='txtPassword']");
	By btn_continue= By.xpath("//input[@id='ButtonTextContinue']");
	By btn_cancel= By.xpath("//input[@id='ButtonTextCancel']']");
	By icn_homepage = By.xpath("//div[@class='logo PS']");
	By drp_enrlquestion1 = By.xpath("//select[@id='EnrollQuestions_listQuestion1']");
	By drp_enrlquestion2 = By.xpath("//select[@id='EnrollQuestions_listQuestion2']");
	By drp_enrlquestion3 = By.xpath("//select[@id='EnrollQuestions_listQuestion3']");
	By btn_enrlpassword= By.xpath("//input[@id='txtPassword']");
	
	By ipt_enrlanswer1= By.xpath("input[@id='EnrollQuestions_textAnswer1']");
	By ipt_enrlanswer2= By.xpath("input[@id='EnrollQuestions_textAnswer2']");
	By ipt_enrlanswer3= By.xpath("input[@id='EnrollQuestions_textAnswer3']");

	By btn_Signout = By.xpath("//div[@class='signOutText']");
	
	
	
	/*****************************Test Case Methods *******************/
	@SuppressWarnings("null")
	//For all WebElements may append type Example: Submit_Btn

	
	
/*******************Login page****************/
	
	void TM_GPRS_S03_Web_Testurlaccessible() {
		
		Select dropdown = new Select(driver.findElement(By.id("listDomains")));  
		dropdown.selectByVisibleText("QUALNA");  
		
		
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);
		
		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();
		
		waitForPageLoaded();

	}
		

		/***************** FORGOT PASSWORD ****************************/
		
		void TM_GPRS_S16_Web_Passwordchange() {
			WebElement forgotpwd_img = createWebElementBy(img_forgotPWD);
			forgotpwd_img.click();

			
			WebElement Username_Ipt = createWebElementBy(btn_yesfrgtpwd);
			Username_Ipt.sendKeys(Username);

			WebElement OldPassword_Ipt = createWebElementBy(ipt_oldpassword);
			OldPassword_Ipt.sendKeys(DecrptPassword);
			
			WebElement homepage_icn = createWebElementBy(icn_homepage);
			homepage_icn.click();
			
			
			/*WebElement Newpassword_Ipt = createWebElementBy(ipt_Newpassword);
			Newpassword_Ipt.sendKeys(DecrptPassword);
			
			WebElement ConfirmPassword_Ipt = createWebElementBy(ipt_confirmpassword);
			ConfirmPassword_Ipt.sendKeys(DecrptPassword);
			
			waitForPageLoaded();
			
			WebElement Continue_Btn = createWebElementBy(btn_continue);
			Continue_Btn.click();*/
		}
		
			
		/**********************PASSWORD CHANGE****************************/
			void TM_GPRS_S17_Web_PasswordReset() {
				WebElement changePWD_img = createWebElementBy(img_ChangePWD);
				changePWD_img.click();

				WebElement homepage_icn = createWebElementBy(icn_homepage);
				homepage_icn.click();
				
				/*WebElement OldPassword_Ipt = createWebElementBy(ipt_oldpassword);
				OldPassword_Ipt.sendKeys(DecrptPassword);

				
				WebElement Newpassword_Ipt = createWebElementBy(ipt_Newpassword);
				Newpassword_Ipt.sendKeys(DecrptPassword);
				
				WebElement ConfirmPassword_Ipt = createWebElementBy(ipt_confirmpassword);
				ConfirmPassword_Ipt.sendKeys(DecrptPassword);
				
				waitForPageLoaded();
				
				WebElement Continue_Btn = createWebElementBy(btn_continue);
				Continue_Btn.click();*/
				
			}
/*********************ENROLLMENT FUNCTIONALITY**************************/
				
				void TM_GPRS_S18_Web_EnrollmentFunctionality() {
					WebElement enrollment_img = createWebElementBy(img_enrollment);
					enrollment_img.click();
					
					Select dropdown = new Select(driver.findElement(By.id("EnrollQuestions_listQuestion1")));  
					dropdown.selectByVisibleText("What is the name of your favorite sports team?");  
					
					Select dropdown1 = new Select(driver.findElement(By.id("EnrollQuestions_listQuestion2")));  
					dropdown1.selectByVisibleText("What is the name of your favorite television series?");  
					
					Select dropdown2 = new Select(driver.findElement(By.id("EnrollQuestions_listQuestion3")));  
					dropdown2.selectByVisibleText("What is the name of your favorite restaurant?"); 
					
					WebElement homepage_icn = createWebElementBy(icn_homepage);
					homepage_icn.click();

					/*WebElement enrollpwd_Ipt = createWebElementBy(ipt_enrollPwd);
					enrollpwd_Ipt.sendKeys(DecrptPassword);

					WebElement Continue_Btn = createWebElementBy(btn_continue);
					Continue_Btn.click();
					
					waitForPageLoaded();*/
					
					WebElement signout_Btn = createWebElementBy(btn_Signout);
					signout_Btn.click();
					
				
			}
	

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here
	
	void SelectDropdownValueByIndex(WebElement element, int i) {
		
		int position = i+1;		
		
		String Csspath = "div[class='dijitPopup dijitMenuPopup'] tr:nth-child("+position+")";
		element.click();
		wait(2);
		
	
		WebElement DropValue = driver.findElement(By.cssSelector(Csspath));
		DropValue.click();
		wait(2);
		
	}
	
}
	


