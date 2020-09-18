package com.qa.kite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import junit.framework.Assert;

public class DCEM extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "http://10.110.100.142";
	final String Username= "testuser1";

	/***************************** Test Cases *******************/

	@BeforeMethod
	public void setUp() {
		launchBrowser(Browser,Url); 
	}

	@Test()
	public void DCEM_S01_Windows_URL_UserLogin_Verification() {
		TM_DCEM_S01_Windows_URL_UserLogin_Verification();
	}

	@AfterMethod(enabled=true)
	public void tearDown() {
		driver.quit();
	}

	/***************************** Locators *******************/
	/* Example syntax:Css Selector: tagname[attribute1:'value1'][attribute2:'value2']
	 * ipt_: input fields
	 * btn_: Buttons
	 * msg_: Messages 	
	 */

	By ipt_Username = By.xpath("//*[@type='name']");
	By ipt_Password = By.xpath("//*[@type='password']");
	By btn_Login = By.xpath("//*[@type='submit']");
	By btn_WecomeUser = By.xpath("//*[contains(text(),'Welcome testuser1')]");
	By btn_LogOut = By.xpath("(//a[@ui-sref='login'])[2]");

	/*************************Login page***********************/

	void TM_DCEM_S01_Windows_URL_UserLogin_Verification() {

		String DecrptPassword= "";
		try {
			DecrptPassword = decrypt("xHXUrbxNAsRw3tfv5Ay5bA==");
		} catch (Exception e) {
			e.printStackTrace();
		}
		createWebElementBy(ipt_Username).sendKeys(Username);
		createWebElementBy(ipt_Password).sendKeys(DecrptPassword);
		createWebElementBy(btn_Login).click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals("Welcome testuser1", createWebElementBy(btn_WecomeUser).getText());
		createWebElementBy(btn_LogOut).click();
		waitForPageLoaded();
	}


}


