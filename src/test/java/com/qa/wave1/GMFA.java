package com.qa.wave1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class GMFA extends CommonMethods {

	/***************************** Test Data*******************/
	final String Browser= "IE";
	final String Dev= "https://mfa.gildpoc.com/mfaportals";
	final String Test= "https://mfatst.gilead.com/mfaportal";
	final String Qual= "https://gmfaval.gilead.com/mfaportal/";
	final String Prod= "https://mfa.gilead.com/mfaportal/";
	private String DecrptPassword;
	
	final String Username ="bpalle";
	String EncryptPassword = "+9Q+HzaPN/at3O6AnqDdgQ==";


	/***************************** Test Cases *******************/
	/*
	 * Test case ‘Test Name’ naming convention: <AppName><TCNumber>_<TestCategory>_<Title>
	Definitions of terms:     
•	AppName: short name of Application [String 5 -10 chars] i.e., TstMyApp, 
•	TCNumber: Test case number [Numeric 2-3 digits] i.e, 01, 02,..
•	TestCategory: Test case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB …]
•	Title: short title of test case based on context of test case  ie., ValidateCredntails
  	Test Name Example: Filkart_05_Web_ValidateCredntails.

	 * Test method name must be same as test case appended with TM example: 
	 */

	//Test, Prod, Qual are Up  But Dev is down
	
	String URL = Test;
	
	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, URL);
	}

	@Test(priority=0, enabled=true)
	public void GMFA_S01_Web_ValidateCredntails() {
		TM_GMFA_S01_Web_ValidateCredntails();
	}

	@AfterMethod(enabled=true)
	public void afterTest() {
		driver.quit();
	}
	
	
	/***************************** Locators**************************************/
	
	By ipt_UserName = By.cssSelector("input[id$='_txtUsername']"); //pageContent
	By ipt_Password = By.cssSelector("input[id$='_txtPassword']");
	By btn_SignIn = By.cssSelector("input[id$='_btnLogin']");
	
	
	void TM_GMFA_S01_Web_ValidateCredntails() {
		WebElement Username_Ipt = createWebElementBy(ipt_UserName);
		Username_Ipt.sendKeys(Username);
		
		try {
			DecrptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement Password_Ipt = createWebElementBy(ipt_Password);
		Password_Ipt.sendKeys(DecrptPassword);
		
		
		WebElement SignIn_Btn = createWebElementBy(btn_SignIn);
		SignIn_Btn.click();
		
		takeScreenshotAtEndOfTest();
		
		
	}
	
	
}
