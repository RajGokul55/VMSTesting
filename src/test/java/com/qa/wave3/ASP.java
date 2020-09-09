package com.qa.wave3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;


	public class ASP extends CommonMethods{

		//private static final String Url = null;
		/***************************** Test Data*******************/
		final String Browser= "Chrome";
		final String UATUrl= "https://uat.asp.gilead.com/gallery";
		final String ProdUrl ="https://asp.gilead.com/gallery";
		
		/***************************** Test Cases *******************/
		
	
		
		@Test(priority=0, enabled=true)
		public void ASP_S02_PROD_GalleryCheck() {
			TM_ASP_S02_Prod_GalleryCheck(ProdUrl);
		}


		@Test(priority=1, enabled=true)
		public void ASP_S03_UAT_GalleryCheck() {
			TM_ASP_S03_UAT_GalleryCheck(UATUrl);
		}
		
		@Test(enabled = true, priority =2, groups = "Prod")
		public void ASP_sjaspappprdn01 () {
			verifyWinSerStatus("sjaspappprdn01 ", "Alteryx Scheduler, Queue Management and other services", "Running", "Auto");
			
		}
		
		@Test(enabled = true, priority =3, groups = "Prod")
		public void ASP_sjaspappprdn02 () {
			verifyWinSerStatus("sjaspappprdn02", "Alteryx Scheduler, Queue Management and other services", "Running", "Auto");
			
		}
		
		@Test(enabled = true, priority =4, groups = "UAT")
		public void ASP_sjaspappuatn01() {
			verifyWinSerStatus("sjaspappuatn01  ", "Alteryx Scheduler, Queue Management and other services", "Running", "Auto");
			
		}
		@Test(enabled = true, priority =5, groups = "UAT")
		public void ASP_sjaspappuatn02() {
			verifyWinSerStatus("sjaspappuatn02", "Alteryx Scheduler, Queue Management and other services", "Running", "Auto");
			
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
		By btn_Home= By.xpath("//a[@class='icon-label home center-vertically']");
		By btn_Privatestudio= By.xpath("//span[@class='icon-font icon-private-studio']");
		
				
	/*******************Login page****************/
		
		
		
		 void TM_ASP_S02_Prod_GalleryCheck(String ProdUrl) {

			 launchBrowser(Browser,ProdUrl);
			WebElement Home_btn = createWebElementBy(btn_Home);
			Home_btn.click();
			takeScreenshotAtEndOfTest();
			waitForPageLoaded();
			
			WebElement Privatestudio_btn = createWebElementBy(btn_Privatestudio);
			Privatestudio_btn.click();
			takeScreenshotAtEndOfTest();
			waitForPageLoaded();

			
		}
			
		 void TM_ASP_S03_UAT_GalleryCheck(String UATUrl) {
		
			 launchBrowser(Browser,UATUrl);
			 WebElement Home_btn = createWebElementBy(btn_Home);
				Home_btn.click();
				takeScreenshotAtEndOfTest();
				waitForPageLoaded();
				
				WebElement Privatestudio_btn = createWebElementBy(btn_Privatestudio);
				Privatestudio_btn.click();
				takeScreenshotAtEndOfTest();
				waitForPageLoaded();
			
			
			
			}
			
			 
		}


