package com.qa.wave3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class GSFN extends CommonMethods{
	
	
	/***************************** Test Data *******************/
	final String Browser = "IE";
	final String Url = "https://sjgsfnappprdn01/";
	
	/***************************** Test Cases *******************/
	
	@BeforeMethod(enabled = true)
	public void beforeTest() {
		System.out.println("Test execution begins..!");
	}

	@Test(priority = 0, enabled = true)
	public void OCI_S01_Web_Verify_LogInScreen() {
		GSFN_01_Verify_LogInScreen();
	}
	@AfterMethod(enabled = true)
		public void afterTest() {
			driver.quit();
	}
	/***************************** Locators *******************/
	
	        By continue_btn = By.xpath("//*[@id='overridelink']");
			By servername= By.xpath("//span[contains(text(),'sjgsfnappprdn01')]");
			//By logo= By.xpath("//*[@id=\"loginForm\"]/div[2]/div[1]");
			
			By field_Username = By.xpath("//*[@id=\"loginForm:key\"]");
			By field_Password = By.xpath("//*[@id=\"loginForm:value\"]");
			By login_arrow = By.xpath("//img[@id='loginForm:j_idt27']");
			
			/***************************** Test Case Methods *******************/

			void GSFN_01_Verify_LogInScreen() {
				
				
				launchBrowser(Browser, Url);
				wait(2);
				WebElement linkContinue = createWebElementBy(continue_btn);
				linkContinue.click();
				wait(2);
				WebElement serverdetail = createWebElementBy(servername);
				IsDisplayed_IsEnabled(serverdetail);
				
//				WebElement Logo = createWebElementBy(logo);
//				IsDisplayed_IsEnabled(Logo);

				WebElement UsernameFld = createWebElementBy(field_Username);
				IsDisplayed_IsEnabled(UsernameFld);

				WebElement PasswordFld = createWebElementBy(field_Password);
				IsDisplayed_IsEnabled(PasswordFld);

				WebElement LoginBtn = createWebElementBy(login_arrow);
				IsDisplayed_IsEnabled(LoginBtn);
				takeScreenshotAtEndOfTest();

			}
	
	}

