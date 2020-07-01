package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class CustomApp_LiteratureResources extends CommonMethods {

	/***************************** Test Data *******************/

	// NO NEED TO ENTER LOGIN DETAILS, BELOW USERS NEED TO LAUNCH THE URL'S, IT WILL
	// DIRECTLY OPEN THE HOME SCREEN(Gilead Sparc)
	

	final String Browser = "Chrome";

	// Test Environment URL
	final String Url = "http://gileadappstest/literatureresources";
		
	// Prod Environment URL
	final String Url1 = "http://gileadapps/literatureresources";

	
	/***************************** Test Cases *******************/
	/*
	 * Test case â€˜Test Nameâ€™ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: â€¢ AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, â€¢ TCNumber:
	 * Test case number [Numeric 2-3 digits] i.e, 01, 02,.. â€¢ TestCategory: Test
	 * case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve,
	 * DB â€¦] â€¢ Title: short title of test case based on context of test case
	 * ie., ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails.
	 * 
	 * Test method name must be same as test case appended with TM example:
	 */

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, Url);
	}

	  @Test(priority = 0, enabled = true)
	  public void LiteratureResources_S01_Web_Verifyscreen()
	  { 
		  TM_LiteratureResources_S01_Web_VerifySparcScreen();
	  
	  }
	 
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */
	
	By heading_Logo = By.xpath("//div[contains(@class,'cms_header_logo')]");
	By txt_LibraryInfo = By.xpath("//span[contains(text(),'Library Information Services')]");
	By txt_Sparc = By.xpath("//*[contains(text(),'My SPARC')]");
	By txt_Description = By.xpath("//span[contains(text(),'Short Description')]");
	By btn_OrderNow = By.xpath("//*[@id='oi_order_now_button']");
	
	/***************************** Test Case Methods *******************/
	
	
	public void TM_LiteratureResources_S01_Web_VerifySparcScreen() {

		verifySparcScreen();
		
	}

	public void verifySparcScreen() {
		// Main heading
		wait(2);
		WebElement MainLogo = createWebElementBy(heading_Logo);
		IsDisplayed_IsEnabled(MainLogo);
		
		WebElement SparcText = createWebElementBy(txt_Sparc);
		IsDisplayed_IsEnabled(SparcText);
		
		SwitchtoFrame();
		
		WebElement LibraryText = createWebElementBy(txt_LibraryInfo);
		IsDisplayed_IsEnabled(LibraryText);
		
		WebElement DescriptionText = createWebElementBy(txt_Description);
		IsDisplayed_IsEnabled(DescriptionText);
		
		WebElement OrderNowBtn = createWebElementBy(btn_OrderNow);
		IsDisplayed_IsEnabled(OrderNowBtn);
		
		takeScreenshotAtEndOfTest();
	}
	
public void SwitchtoFrame()
{
	int size = driver.findElements(By.tagName("iframe")).size();
	System.out.println("size = " + size);
	wait(10);

	WebElement iframeSwitch = driver.findElement(By.xpath("//iframe[contains(@id,'generic_request_iframe')]"));
	driver.switchTo().frame(iframeSwitch);
	System.out.println("Inside frame");

	//driver.switchTo().defaultContent();
	//System.out.println("Outside frame");
	
}
	}