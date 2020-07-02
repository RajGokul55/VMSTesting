package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;



	public class SDS extends CommonMethods{

		//private static final String Url = null;
		/***************************** Test Data*******************/
		final String Browser= "Chrome";
		final String ValUrl= "http://sjsdswebvalg01/sds/status.aspx";
		final String ProdUrl ="http://sds.gilead.com/sds/status.aspx";
	

		/***************************** Test Cases *******************/
		
	
		
		@Test(priority=0, enabled=true)
		public void SDS_S01_Test_Postpatchtesting() {
			TM_SDS_S01_Test_Postpatchtesting(ValUrl);
		}
		
		@Test(priority=2, enabled=true)
		public void SDS_S02_PROD_Postpatchtesting() {
			TM_SDS_S02_PROD_Postpatchtesting(ProdUrl);
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
		
		
				
	/*******************Login page****************/
		
		
		
		 void TM_SDS_S01_Test_Postpatchtesting(String ValUrl) {

			 launchBrowser(Browser,ValUrl);
			takeScreenshotAtEndOfTest();
			wait(2);
			
		}
			
		 void TM_SDS_S02_PROD_Postpatchtesting(String ProdUrl) {
			 launchBrowser(Browser,ProdUrl);
			takeScreenshotAtEndOfTest();
			wait(2);
			 
			
			
			
			}
			
			 
		}


