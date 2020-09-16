package com.qa.wave3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class DFM extends CommonMethods{

	/***************************** Test Data *******************/
	//IE browser
	final String Browser = "IE";
	final String Url = "http://gsn:8080/start.html";
	
	/***************************** Test Cases *******************/
	
	@BeforeMethod(enabled = true)
	public void beforeTest() {
		System.out.println("Test execution begins..!");
	}

	@Test(priority = 0, enabled = true)
	public void OCI_S01_Web_Verify_LogInScreen() {
		DFM_01_Verify_LogInScreen();
	}
	@AfterMethod(enabled = true)
		public void afterTest() {
			driver.quit();
	}
	/***************************** Locators *******************/
	
			
			By field_Username = By.xpath("//label[contains(text(),'User name')]");
			By field_Password = By.xpath("//label[contains(text(),'Password')]");
			By login_btn = By.xpath("//button[contains(@class,'x-btn-text')]");
			
			/***************************** Test Case Methods *******************/

			void DFM_01_Verify_LogInScreen() {
				launchBrowser(Browser, Url);
				wait(2);
				
				WebElement UsernameFld = createWebElementBy(field_Username);
				IsDisplayed_IsEnabled(UsernameFld);

				WebElement PasswordFld = createWebElementBy(field_Password);
				IsDisplayed_IsEnabled(PasswordFld);

				WebElement SignIn_Btn = createWebElementBy(login_btn);
				IsDisplayed_IsEnabled(SignIn_Btn);
				takeScreenshotAtEndOfTest();

			}
	
	}
	

