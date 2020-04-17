

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
	By drp_DomainValue = By.xpath("(//option[contains(text(),'QUALNA')]");
	By btn_Agree = By.xpath("(//input[@id='btnTextIAgree'])");
	By btn_forgotPWD= By.xpath("(//img[@id='imgForgotPassword']");
	By btn_ChangePWD=By.xpath("//img[@id='imgChangePassword']");
	By btn_enrollment = By.xpath("//input[@id='btnEnroll']");
	By ipt_oldpassword= By.xpath("//input[@id='textOldPassword']");
	By ipt_Newpassword= By.xpath("//input[@id='textNewPassword']");
	By ipt_confirmpassword= By.xpath("//input[@id='textConfirm']");
	By btn_continue= By.xpath("//input[@id='ButtonTextContinue']");
	By btn_cancel= By.xpath("//input[@id='ButtonTextCancel']']");
	
	By btn_enrlpassword= By.xpath("//input[@id='txtPassword']");
	
	By btn_Signout = By.xpath("//div[@class='signOutText']");
	
	
	
	/*****************************Test Case Methods *******************/
	@SuppressWarnings("null")
	//For all WebElements may append type Example: Submit_Btn

	
	
/*******************Login page****************/
	
	void TM_GPRS_S03_Web_Testurlaccessible() {
		WebElement drp_domain = createWebElementBy(drp_Domain);
		SelectDropdownValueByIndex(drp_domain, 2);
		
		WebElement drp_domainvalue = createWebElementBy(drp_DomainValue);
		drp_domainvalue.click();
		
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();
		
		waitForPageLoaded();

	}
		
		/*****************PASSWORD CHANGE****************************/
		
		void TM_GPRS_S16_Web_Passwordchange() {
			WebElement drp_domain = createWebElementBy(drp_Domain);
		//	SelectDropdownValueByIndex(drp_domain, 2);

			
			WebElement Username_Ipt = createWebElementBy(ipt_Username);
			Username_Ipt.sendKeys(Username);

			WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
			Password_Ipt.sendKeys(DecrptPassword);

			WebElement Agree_Btn = createWebElementBy(btn_Agree);
			Agree_Btn.click();
			
			waitForPageLoaded();
		}
			
			void TM_GPRS_S17_Web_PasswordReset() {
				WebElement drp_domain = createWebElementBy(drp_Domain);
				//SelectDropdownValueByIndex(drp_domain, 2);

				
				WebElement Username_Ipt = createWebElementBy(ipt_Username);
				Username_Ipt.sendKeys(Username);

				WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
				Password_Ipt.sendKeys(DecrptPassword);

				WebElement Agree_Btn = createWebElementBy(btn_Agree);
				Agree_Btn.click();
				
				waitForPageLoaded();
				
			}

				
				void TM_GPRS_S18_Web_EnrollmentFunctionality() {
					WebElement drp_domain = createWebElementBy(drp_Domain);
					//SelectDropdownValueByIndex(drp_domain, 2);

					
					WebElement Username_Ipt = createWebElementBy(ipt_Username);
					Username_Ipt.sendKeys(Username);

					WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
					Password_Ipt.sendKeys(DecrptPassword);

					WebElement Agree_Btn = createWebElementBy(btn_Agree);
					Agree_Btn.click();
					
					waitForPageLoaded();

				
		/*WebElement reports_Btn = createWebElementBy(btn_reportsmenu);
		 
		reports_Btn.click();

		WebElement Realtimereports_Btn = createWebElementBy(btn_realtimereports);
		Realtimereports_Btn.click();

		waitForPageLoaded();
		
				
		WebElement sqlreports_btn = createWebElementBy(btn_sqlreports);
		sqlreports_btn.click();
				
		
		WebElement runtimeparameters_btn = createWebElementBy(icn_runtimeparameters);
		runtimeparameters_btn.click();
		
		WebElement Dropdown_Drp = createWebElementBy(drp_Dropdown);		
		SelectDropdownValueByIndex(Dropdown_Drp, 2);
		
		driver.findElement(By.xpath("//span[@id='dijit_form_Button_17_label']")).click();
		
		/*WebElement datasourceok_btn = createWebElementBy(btn_datasourceok);
		datasourceok_btn.click();
		wait(2);*/
		
		/*runtimeparameters_btn.click();
		

		
		WebElement Dropdown_Drp1 = createWebElementBy(drp_Dropdown);		
		SelectDropdownValueByIndex(Dropdown_Drp1, 3);
		
		
		WebElement datasourceok_btn1 = createWebElementBy(btn_datasourceok);
		datasourceok_btn1.click();
		
		
		 WebElement Reviewonly_Btn = createWebElementBy(btn_reviewonly);
		 Reviewonly_Btn.click();
		  
		  WebElement Signout_Btn = createWebElementBy(btn_Signout);
		 Signout_Btn.click();*/
		 
		 
		
		
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
