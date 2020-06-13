package com.qa.wave2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;


	public class Assurenet_Sep12 extends CommonMethods{

		/***************************** Test Data*******************/
		final String Browser= "Chrome";
		final String Url= "http://fcanetwebuat02.na.gilead.com/AssureNETGL/Dashboard/Prepare.aspx";
		final String Username ="smiranda";
		private String DecrptPassword;
		

		/***************************** Test Cases *******************/
		
	
		@BeforeMethod(enabled=true)
		public void beforeTest() {
			launchBrowser(Browser, Url);
		}

		@Test(priority=0, enabled=true)
		public void Assurenet_Sep12_Url_Administrator_XMLinterface() {
			TM_Assurenet_Sep12_Url_Administrator_XMLinterface();
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
		By ipt_Username= By.xpath("//input[@id='loginIdTextBox']");
		By ipt_Passwrod= By.xpath("//input[@id='passwordTextBox']");
		By btn_Login = By.xpath("//input[@id='loginButton']");
		By btn_Administratortab = By.xpath("//a[@class='menu_level2'][contains(text(),'Administration')]");
		By btn_Interfacescheduler = By.xpath("//a[contains(text(),'XML Interface Schedules')]");
		By btn_Interfacelist = By.xpath("btn_Interfacescheduler]");
		By btn_Logout = By.xpath("//a[contains(text(),'Log Out')]");
				
	/*******************Login page****************/
		
		public void TM_Assurenet_Sep12_Url_Administrator_XMLinterface() {
			login_verifyUrl();
			verifyAdministratortab();
			verifyXMLIntefacecluster();
			
			
			
		}
		
		 void login_verifyUrl() {
			WebElement Username_Ipt = createWebElementBy(ipt_Username);
			Username_Ipt.sendKeys(Username);
			try {
				DecrptPassword = decrypt("3BMe4620ClPFqA5HrXVS1Q==");
			} catch (Exception e) {
				e.printStackTrace();
			
			}
			
			WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
			Password_Ipt.sendKeys(DecrptPassword);
			wait(2);

			WebElement Login_Btn = createWebElementBy(btn_Login);
			takeScreenshotAtEndOfTest();
			Login_Btn.click();
			wait(2);
		}
			
		 void verifyAdministratortab() {
			WebElement Administratortab_Btn = createWebElementBy(btn_Administratortab);
			takeScreenshotAtEndOfTest();
			Administratortab_Btn.click();	
			wait(2);
		}		
		
		 void verifyXMLIntefacecluster() {
			WebElement interfacescheduler_Btn = createWebElementBy(btn_Interfacescheduler);
			takeScreenshotAtEndOfTest();
			interfacescheduler_Btn.click();
			wait(2);
			
			WebElement Logout_Btn = createWebElementBy(btn_Logout);
			Logout_Btn.click();
			takeScreenshotAtEndOfTest();
			wait(2);
			
			
			
			}
			
			 
		}


