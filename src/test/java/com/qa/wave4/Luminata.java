package com.qa.wave4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class Luminata extends CommonMethods {

	/***************************** Test Data *******************/
	
	final String Browser = "IE";
	final String Url = "http://luminata.gilead.com:8080/LUMINATA/#/main";
	
	final String Username = "psonawane";
	private String DecrptPassword;
	
	/***************************** Test Cases *******************************/
	/*
	 * Test case ˜Test Name™ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, TCNumber: Test
	 * case number [Numeric 2-3 digits] i.e, 01, 02,.. TestCategory: Test case
	 * category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB
	 * â€¦] Title: short title of test case based on context of test case ie.,
	 * ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails. Test
	 * method name must be same as test case appended with TM example:
	 */

	@BeforeMethod
	void Setup() {
		try {
			DecrptPassword = decrypt("e19ncVNSmW6OrHZf9mDsAg==");
		} catch (Exception e) {
			e.printStackTrace();
		}
		launchBrowser(Browser, Url);
	}
	
	@Test(priority = 0, enabled = true)
	public void Luminata_S01_Windows_Web_Login_Verfication() {
		TM_Luminata_S01_Windows_Web_Login_Verfication();
	}

	@Test(priority = 0, enabled = true) 
	public void Luminata_S02_Windows_Web_Tab_Verfication() {
		TM_Luminata_S02_Windows_Web_Tab_Verfication();
	}
	
	@AfterMethod
	void Teardouwn() {
		driver.close();
	}
	
	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */

	By ipt_Username = By.cssSelector("#x-auto-0-input");
	By ipt_Password = By.cssSelector("#x-auto-1-input");
	By btn_LogOn = By.cssSelector(".IJAMLQB-b-d.IJAMLQB-b-o");
	By text_Summary_View = By.xpath("//*[@class='gwt-Label' and contains(text(),'Summary View')]");
	By text_Process_Scheme = By.xpath("//*[@class='gwt-Label' and contains(text(),'Process Scheme')]");
	By text_Table_View = By.xpath("//*[@class='gwt-Label' and contains(text(),'Table View')]");
	By text_Compound_View = By.xpath("//*[@class='gwt-Label' and contains(text(),'Compound View')]");
	By text_Batch_Genealogy = By.xpath("//*[@class='gwt-Label' and contains(text(),'Batch Genealogy')]");

	/***************************** Test Case Methods *******************/

	void TM_Luminata_S01_Windows_Web_Login_Verfication() {
		
		Luminata_User_Login();
		String Actual_Text = createWebElementBy(text_Summary_View).getText();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(Actual_Text, "Summary View");
	}

	void TM_Luminata_S02_Windows_Web_Tab_Verfication(){

		Luminata_User_Login();
		String Actual_Summary_Text = createWebElementBy(text_Summary_View).getText();
		Assert.assertEquals(Actual_Summary_Text, "Summary View");
		
		String Actual_Process_Text = createWebElementBy(text_Process_Scheme).getText();
		Assert.assertEquals(Actual_Process_Text, "Process Scheme");
		
		String Actual_Table_Text = createWebElementBy(text_Table_View).getText();
		Assert.assertEquals(Actual_Table_Text, "Table View");
		
		String Actual_Compound_Text = createWebElementBy(text_Compound_View).getText();
		Assert.assertEquals(Actual_Compound_Text, "Compound View");
		
		String Actual_Batch_Text = createWebElementBy(text_Batch_Genealogy).getText();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(Actual_Batch_Text, "Batch Genealogy");
	}
	
	/********************************* Common Methods *************************************/
	
	void Luminata_User_Login() {
		
		createWebElementBy(ipt_Username).sendKeys(Username);
		createWebElementBy(ipt_Password).sendKeys(DecrptPassword);
		createWebElementBy(btn_LogOn).click();
		waitForPageLoaded();
	}
}
