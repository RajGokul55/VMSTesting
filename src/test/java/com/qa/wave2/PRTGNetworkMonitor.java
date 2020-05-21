package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PRTGNetworkMonitor extends CommonMethods {


	/***************************** Test Cases  *******************/

	@BeforeMethod(enabled = true)
	public void beforeTest() throws IOException 
	{
	@Test(priority = 0, enabled = true)
	public void PRTGNM_S01_Web_UserLogin() throws IOException {
		GM_PRTGNM_Web_DevURLLogin();
	}

	/*
	 * @Test(priority = 1, enabled = true) public void
	 * PRTGNM_S02_Web_ViewAllSensorsData() throws IOException {
	 * TM_PRTGNM_S02_Web_ViewAllSensorsData(); }
	 */

	@AfterMethod
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	By ipt_Username = By.xpath("//input[@id='loginusername']");
	By ipt_Password = By.xpath("//input[@id='loginpassword']");
	By btn_Login = By.xpath("//button[@class='loginbutton button big']");
	

	/***************************** Test Case Methods *******************/

	/*
	 * public void TM_PRTGNM_S01_Web_UserLogin() throws IOException { WebElement
	 * Username_Ipt = createWebElementBy(ipt_Username); Username_Ipt.clear();
	 * Username_Ipt.sendKeys(Username);
	 * 
	 * WebElement Password_Ipt = createWebElementBy(ipt_Password);
	 * Password_Ipt.clear(); Password_Ipt.sendKeys(DecryptPassword);
	 * 
	 * WebElement Login_Btn = createWebElementBy(btn_Login); Login_Btn.click();
	 * 
	 * 
	 * waitForPageLoaded(); takeScreenshotAtEndOfTest();
	 * //Assert.assertEquals(driver.getTitle(), "");
	 * 
	 * }
	 */
	/*
	 * public void TM_PRTGNM_S02_Web_ViewAllSensorsData() throws IOException {
	 * 
	 * WebElement Username_Ipt = createWebElementBy(ipt_Username);
	 * Username_Ipt.sendKeys(Username);
	 * 
	 * WebElement Password_Ipt = createWebElementBy(ipt_Password);
	 * Password_Ipt.sendKeys(DecryptPassword);
	 * 
	 * 
	 * WebElement Assets_Menu = createWebElementBy(abc); //mouseHover(abc);
	 * 
	 * WebElement Computers_Menu = createWebElementBy(abcd); //mouseHover(abcd);
	 * Computers_Menu.click();
	 * 
	 * 
	 * 
	 * 
	 * waitForPageLoaded(); takeScreenshotAtEndOfTest();
	 * Assert.assertEquals(driver.getTitle(), "");
	 * 
	 * }
	 */

	/***************************** Generic Methods *******************/
	
	public void GM_PRTGNM_Web_DevURLLogin() throws IOException
	{
		
		final String Browser = "Chrome";
		final String DevURL = "http://sjprtgappdevg01/";
		final String Username = "VMS";
		String DecryptPassword = null;
		final String EncryptPassword = "dLYEuUGwlY262xhKocrIUw==";
		final String URL = DevURL; // Change URL whichever Environment you want to execute.
		launchBrowser(Browser, URL);
		try
		{
			DecryptPassword = decrypt(EncryptPassword);
		} catch (Exception e)
		{
			e.printStackTrace();
			
			WebElement Username_Ipt = createWebElementBy(ipt_Username);
			Username_Ipt.clear();
			Username_Ipt.sendKeys(Username);
			
			  WebElement Password_Ipt = createWebElementBy(ipt_Password);
			  Password_Ipt.clear();
			  Password_Ipt.sendKeys(DecryptPassword);
			  
			  WebElement Login_Btn = createWebElementBy(btn_Login); 
			  Login_Btn.click();
			 

			waitForPageLoaded();
			takeScreenshotAtEndOfTest();
			//Assert.assertEquals(driver.getTitle(), "");

		}

		}
	}
	
	
	
	

