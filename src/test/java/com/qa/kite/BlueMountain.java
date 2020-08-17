package com.qa.kite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class BlueMountain extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "IE";
	
	final String DevUrl = "http://bmram-dev.kite.local/ram/";
	final String ProdUrl = "http://bmram-ap-prod.kite.local/ram/";
	final String TestUrl = "http://bmram-ap-test.kite.local/ram/";
	final String username = "graj";
	final String password = "Acn@123890";
	

	//"jdbc:oracle:thin:@fcbaamdbdev01.na.gilead.com:1521/INTGDEV"; 
	String DevServerURL = "Dev-bmram-dev";
	String ProdServerURL = "Prod- bmram-ap-prod Kite";
	String TestServerURL = "Test-bmram-ap-test,bmram-db-test";
	
	String ADM_Username = "";
	String ADM_Password = "";
	
	String Query = "";
	

	
	/***************************** Test Cases *******************/
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Begin Test Execution..");
	}

	@Test(priority = 1, enabled = true)
	public void BlueMountain_S01_Web_Check_UrlLandingpage() {
		TM_BlueMountain_S01_Web_Checking_Landingpage(DevUrl);
		TM_BlueMountain_S01_Web_Checking_Landingpage(ProdUrl);
		TM_BlueMountain_S01_Web_Checking_Landingpage(TestUrl);
	}
	@Test(priority = 2, enabled = false)
	public void BlueMountain_S02_Web_Check_Server() {
		TM_BlueMountain_S02_Web_Check_Server();
	}

	@AfterMethod(enabled = false)
	public void afterMethod() {
		driver.quit();
	}
	/***************************** Locators *******************/	
	By drop_Source = By.cssSelector("select[id='lstAuthType']");
	By ipt_Username = By.cssSelector("input[id='txtUserName']");
	By ipt_Password = By.cssSelector("input[id='txtPassword']");
	By btn_Login = By.cssSelector("span[id='lblButtonbtnLogin']");
	By btn_LogOff = By.cssSelector("span[id='lblButtonbtnLogoff']");
	

	/***************************** Test Methods *******************/
	
	void TM_BlueMountain_S01_Web_Checking_Landingpage(String URL) {
		launchBrowser(Browser, URL);

		Select SourceDrop = new Select(driver.findElement(drop_Source));
		SourceDrop.selectByVisibleText("GILEAD (TCF03)"); //selectByIndex(4);

		WebElement username_input = createWebElementBy(ipt_Username);
		username_input.sendKeys(username);
		
		WebElement password_input = createWebElementBy(ipt_Password);
		password_input.sendKeys(password);
		
		WebElement Login_button = createWebElementBy(btn_Login);
		Login_button.click();
		
		waitForPageLoaded();
		
		WebElement LogOff_button = createWebElementBy(btn_Login);
		IsDisplayed_IsEnabled(LogOff_button);
		
		takeScreenshotAtEndOfTest();
		
	}
	
	void TM_BlueMountain_S02_Web_Check_Server() {
		
		
		TM_connectToDB_RunQuery(DevServerURL, ADM_Username, ADM_Password,Query);
		
		
		
		takeScreenshotAtEndOfTest();
		
	}
}
