package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;


	public class CisPro_GS2 extends CommonMethods{

		//private static final String Url = null;
		/***************************** Test Data*******************/
		final String Browser= "Chrome";
		final String TestUrl= "http://sjcpr2apptstn01.na.gilead.com/cispro";
		final String ProdUrl ="http://sjcpr2appprdn01.na.gilead.com/cispro";
		final String CustomerId ="gilead2";
		final String Username ="nnereddula";
		private String DecrptPassword;

		/***************************** Test Cases *******************/
		
	
		
		@Test(priority=0, enabled=true)
		public void CisProGs2_S01_Test_Postpatchtesting() {
			TM_CisProGs2_S01_Test_Postpatchtesting(TestUrl);
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
		By ipt_customerid= By.xpath("//input[@id='form1table1row2col2input1']");
		By ipt_Username= By.xpath("//input[@id='form1table1row3col2input1']");
		By ipt_Password= By.xpath("//input[@id='form1table1row4col2input1']");
		By btn_Login = By.xpath("//span[contains(text(),'Login')]");
		By img_home = By.xpath("//img[@id='LogoImage']");
		By btn_logout = By.xpath("//span[contains(text(),'Logout')]");
		
				
	/*******************Login page****************/
		
		
		
		 void TM_CisProGs2_S01_Test_Postpatchtesting(String TestUrl) {

			 launchBrowser(Browser,TestUrl);
			 WebElement customer_id = createWebElementBy(ipt_customerid);
			 customer_id.sendKeys(CustomerId);
			 
			 WebElement Username_Ipt = createWebElementBy(ipt_Username);
				Username_Ipt.sendKeys(Username);
				try {
					DecrptPassword = decrypt("H6QzhTK2ALgB/Myb1TAIYw==");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				WebElement Password_Ipt = createWebElementBy(ipt_Password);
				Password_Ipt.sendKeys(DecrptPassword);

				WebElement Login_Btn = createWebElementBy(btn_Login);
				Login_Btn.click();
				waitForPageLoaded();
			takeScreenshotAtEndOfTest();
			
			WebElement home_img = createWebElementBy(img_home);
			home_img.click();
		takeScreenshotAtEndOfTest();
			

			WebElement Logout_Btn = createWebElementBy(btn_logout);
			Logout_Btn.click();
		takeScreenshotAtEndOfTest();
		
			
			
			

		}			 
		}


