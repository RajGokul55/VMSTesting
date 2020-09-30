package com.qa.wave3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class ChinaReporting extends CommonMethods {
	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String PrdURL = "http://commercialreport.gilead.com/";

	/***************************** Test Cases *******************/
	/*
	 * Test case ‘Test Name’ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: • AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, • TCNumber:
	 * Test case number [Numeric 2-3 digits] i.e, 01, 02,.. • TestCategory: Test
	 * case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve,
	 * DB …] • Title: short title of test case based on context of test case ie.,
	 * ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails.
	 * 
	 * Test method name must be same as test case appended with TM example:
	 */


	String URL = PrdURL;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
	}

	@Test(priority=1, enabled=true)
	public void CR_S01_Web_Validate_Homepage() {
		TM_S01_Web_Validate_Homepage();
	}

	@Test(priority=2, enabled=true)
	public void CR_S02_Web_Validate_Dashboards() {
		TM_S02_Web_Validate_Dashboards();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 * txt_: Text
	 * crd_: Card
	 */

	By txt_hptext		=	By.cssSelector("p[class='gilead-index-bgtt']");
	By lnk_myboard		=	By.cssSelector("#myBoard");
	By img_gilead		=	By.xpath("//div[2]/div[1]/div/div[2]/div[14]/div/div/div/div/img");
	By img_graph		=	By.xpath("//div/div[2]/div[37]/div/div/div/div[1]/div[11]/div[1]/div[2]/img");


	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_S01_Web_Validate_Homepage() {
		WebElement HomeText_Txt = createWebElementBy(txt_hptext);
		Assert.assertTrue(HomeText_Txt.isDisplayed(), "The Homepage is not loaded properly");
		takeScreenshotAtEndOfTest();
	}

	public void TM_S02_Web_Validate_Dashboards() {
		WebElement HomeText_Txt = createWebElementBy(txt_hptext);
		Assert.assertTrue(HomeText_Txt.isDisplayed(), "The Homepage is not loaded properly");

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		WebElement MyBoard_Lnk = createWebElementBy(lnk_myboard);
		MyBoard_Lnk.click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		
		/*
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='tableauViz']"));
		driver.switchTo().frame(frame1);
		
		WebElement Gilead_Img = createWebElementBy(img_gilead);
		Assert.assertTrue(Gilead_Img.isDisplayed(), "The page is not loaded successfully");
		
		WebElement Graph_Img = createWebElementBy(img_graph);
		Assert.assertTrue(Graph_Img.isDisplayed(), "The graphs are not displayed as expected");
		takeScreenshotAtEndOfTest();
		*/

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}
}
