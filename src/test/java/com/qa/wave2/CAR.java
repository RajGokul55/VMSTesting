package com.qa.wave2;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import org.testng.annotations.BeforeMethod;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class CAR extends CommonMethods {
	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String TstUrl = "http://gileadappstest/contractapprovalrouting/approverQueue.aspx";
	String EnterName = "Allyson Gunsallus";    //Enter the name that needs to be selected in the dropdown menu
	
	//NOTE : The URL may display "Error you are not authorised" when their is a DB restoration

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


	String URL = TstUrl;
	
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
	}
	
	@Test(priority=1, enabled=true)
	public void CAR_S01_Web_View_Details() {
		TM_S01_Web_View_Details();
	}
	
	@Test(priority=2, enabled=true)
	public void CAR_S02_Web_Validate_Copy() {
		TM_S02_Web_Validate_Copy();
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
	
	By txt_homeText		=	By.xpath("//h1[@class='M_title text-nowrap']");
	By lnk_search		=	By.xpath("//a[contains(text(),'Search')]");
	By txt_search		=	By.xpath("//h1[@class='header-blue']");
	By drp_enterBy		=	By.xpath("//select[@id='enteredby']");	
	By drp_status		=	By.xpath("//select[@id='Status']");
	By btn_search		=	By.cssSelector("#btnSearch");
	By tbl_result		=	By.cssSelector("#slist");
	By txt_supplierName	=	By.xpath("//textarea[@id='otherparty']");
	By lnk_Copy			=	By.xpath("//table[2]/tbody/tr[4]/td[13]/a");
	
	
	
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	public void TM_S01_Web_View_Details() {
		waitForPageLoaded();
		WebElement HomeText_Txt = createWebElementBy(txt_homeText);
		Assert.assertEquals(HomeText_Txt.getText(), "Contract Approval Routing");
		
		WebElement Search_Lnk = createWebElementBy(lnk_search);
		Search_Lnk.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		WebElement Search_Txt = createWebElementBy(txt_search);
		Assert.assertEquals(Search_Txt.getText(), "Search");
		
		WebElement EnterBy_Drp = createWebElementBy(drp_enterBy);
		selectDropdownByText(EnterBy_Drp, EnterName);
		
		WebElement Status_Drp = createWebElementBy(drp_status);
		selectDropdownByText(Status_Drp, "Approved");
		takeScreenshotAtEndOfTest();
		
		WebElement Search_Btn = createWebElementBy(btn_search);
		Search_Btn.click();
		WebElement Result_Tbl = createWebElementBy(tbl_result);
		Assert.assertTrue("The search was unsuccessfull", Result_Tbl.isDisplayed());
		takeScreenshotAtEndOfTest();
	}
	
	public void TM_S02_Web_Validate_Copy() {
		TM_S01_Web_View_Details();
		
		String ContractingParty = driver.findElement(By.xpath("//table[2]/tbody/tr[4]/td[5]")).getText();
		String EnterBy = driver.findElement(By.xpath("//table[2]/tbody/tr[4]/td[6]")).getText();
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		
		if(EnterBy.equalsIgnoreCase(EnterName)) {
			WebElement Copy_Lnk = createWebElementBy(lnk_Copy);
			Copy_Lnk.click();
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
			}
			waitForPageLoaded();
			takeScreenshotAtEndOfTest();
			WebElement Create_Txt = createWebElementBy(txt_search);
			Assert.assertEquals(Create_Txt.getText(), "Create");
			
			WebElement SupplierName_Txt = createWebElementBy(txt_supplierName);
			Assert.assertEquals(ContractingParty, SupplierName_Txt.getText());
			System.out.println("The data is popoulated as per the records");
			takeScreenshotAtEndOfTest();
			
			// Close the new window, if that window no more required
			driver.close();

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
		}else {
			takeScreenshotAtEndOfTest();
			Assert.fail("The search was unsuccessfull");
		}
	}
	
	/*************************************************Methods*****************************************************************/
	public void selectDropdownByText(WebElement locator, String value) {
		Select select = new Select(locator);
		select.selectByVisibleText(value);
	}
	
	public static void selectDropdownByValue(WebElement locator, String value) {
		Select select = new Select(locator);
		select.selectByValue(value);
	}

}
