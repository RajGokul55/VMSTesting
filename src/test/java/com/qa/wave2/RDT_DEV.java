package com.qa.wave2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;


	public class RDT_DEV extends CommonMethods{

		/***************************** Test Data*******************/
		final String Browser= "Chrome";
		final String Url= "http://gadi2dev.gilead.com";
		final String Username ="rdmst01";
		private String DecrptPassword;
		

		/***************************** Test Cases *******************/
		
		

		@BeforeMethod(enabled=true)
		public void beforeTest() {
			launchBrowser(Browser, Url);
		}

		@Test(priority=0, enabled=true)
		public void RTDDEV_S01_Url_Login() {
			TM_RTDDEV_S01_Url_Login();
		}

		/*@Test(priority=1, enabled=true)
		public void RTDDEV_S02_DesktopIcons() {
			TM_RTDDEV_S02_DesktopIcons();
		}*/

		
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
		By ipt_Username= By.xpath("//input[@id='login']");
		By ipt_Passwrod= By.xpath("//input[@id='passwd']");
		By btn_Login = By.cssSelector("#nsg-x1-logon-button");
		By btn_detectreceiver = By.xpath("//a[contains(text(),'Detect Receiver')]");
		By btn_alreadyinstaleed = By.xpath("//a[contains(text(),'Already installed')]");
		
		By icn_RDTSPSDev= By.cssSelector("li:nth-child(1) a[class='storeapp-details-link'] img");
		By icn_I4VDEV= By.xpath("//span[contains(text(),'I4V Dev')]");
	
		By btn_Logout = By.xpath("//a[contains(text(),'Log Off')]");
				
	/*******************Login page****************/
		
		void TM_RTDDEV_S01_Url_Login() {
			WebElement Username_Ipt = createWebElementBy(ipt_Username);
			Username_Ipt.sendKeys(Username);
			try {
				DecrptPassword = decrypt("0wJNDaXrJwP7JrSMgufTMg==");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
			Password_Ipt.sendKeys(DecrptPassword);

			WebElement Login_Btn = createWebElementBy(btn_Login);
			Login_Btn.click();
			
			WebElement detectreceiver_Btn = createWebElementBy(btn_detectreceiver);
			detectreceiver_Btn.click();
			
			WebElement alreadyinstalled_Btn = createWebElementBy(btn_alreadyinstaleed);
			alreadyinstalled_Btn.click();
			
			WebElement  RDTSPSdev_icn = createWebElementBy(icn_RDTSPSDev);
			RDTSPSdev_icn.click();
			wait(2);
			
			
			
			}
			
			 
		}


