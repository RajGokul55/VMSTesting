package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SCOM extends CommonMethods {

	

	/***************************** Test Cases *******************/
	
	
	
	@BeforeMethod(enabled=true)
	public void beforeTest() {
		
	}
	
	  @Test(priority = 0, enabled = true) 
	  public void SCOM_S01_Web_POCURL_UserLogin() throws IOException
	  {
		  TM_SCOM_S01_Web_POCenv_Validation(); 
      
	  }
	 

	@AfterMethod
	public void afterEveryTest() {
		driver.quit();
	}
	
	/***************************** Locators *******************/

	By ipt_Monitoring = By.xpath("//input[@id='loginusername']");
	By ipt_Password = By.xpath("//input[@id='loginpassword']");
	By btn_Login = By.xpath("//button[@class='loginbutton button big']");

	/***************************** Test Case Methods *******************/

	public void TM_SCOM_S01_Web_POCenv_Validation() throws IOException {

		final String Browser = "Chrome";
		final String POCURL = "http://SJSCOMWEBPOCN01/OperationsManager"; 
		launchBrowser(Browser, POCURL);
        waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "Operations Manager Web Console",
				"Operations Manager Web Console not displayed");
		takeScreenshotAtEndOfTest();

	}


	
}

