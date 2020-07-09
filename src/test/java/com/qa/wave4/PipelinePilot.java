package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;


	public class PipelinePilot extends CommonMethods{

		//private static final String Url = null;
		/***************************** Test Data*******************/
		final String Browser= "Chrome";
		final String ProdUrl= "http://sjppappprdn01:9944/";
		
		
		/***************************** Test Cases *******************/
		
	
		
		@Test(priority=0, enabled=true)
		public void PipelinePilot_S01_Test_Postpatchtesting() {
			TM_PipelinePilot_S01_Test_Postpatchtesting(ProdUrl);
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
		By img_home = By.xpath("//img[@class='logo']");
		
		
				
	/*******************Login page****************/
		
		
		
		 void TM_PipelinePilot_S01_Test_Postpatchtesting(String ProdUrl) {

			 launchBrowser(Browser,ProdUrl);
			 waitForPageLoaded();
			 takeScreenshotAtEndOfTest();
			 WebElement home_img = createWebElementBy(img_home);
				home_img.click();
			takeScreenshotAtEndOfTest();
			waitForPageLoaded();
		
			 
			
			
			
			}
			
			 
		}


