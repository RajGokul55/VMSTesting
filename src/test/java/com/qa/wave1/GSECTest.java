package com.qa.wave1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;



public class GSECTest extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://gsecdev.gilead.com/";
	final String Url1= "https://gsecval.gilead.com/";
	final String Username ="sgupta27";
	final String PasswordNegative = "hdgd@54";
	private String DecrptPassword;
	String EncryptPassword = "7bkbl6+1a3eQscQR5BmjQA==";
	private String title;
	private String text;
	private int num;


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
	
	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
		try {
			DecrptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=0, enabled=true)
	public void GSEC_S01_Web_Login_GSEC_Application() throws IOException {
		TM_GSEC_S01_Web_Login_GSEC_Application();
	}
	
	  @Test(priority=1, enabled=true)
	  public void GSEC_S02_Web_OER_SystemHealthCheck() throws IOException {
		  TM_GSEC_S02_Web_OER_SystemHealthCheck();
	  	  }
	  
	
	  @Test(priority=2, enabled=true) 
	  public void GSEC_S03_Check_Computers_Tab_functionalities() throws IOException { 
		  TM_GSEC_S03_Check_Computers_Tab_functionalities();
		  
	  }
	 
	  @Test(priority=3, enabled=true)
		public void GSEC_S04_user_Login_using_wrong_credentials() throws IOException {
		  TM_GSEC_S04_user_Login_using_wrong_credentials();
		}
	
	@AfterMethod(enabled=true)
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector: tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 */

	By ipt_Username= By.xpath("//input[@id='password']/../../preceding::div[1]/span[2]/input");
	By ipt_Passwrod= By.xpath("//input[@class= 'password']");
	By btn_Login = By.xpath("//button[@class= ' buttonWithIcon']");
	By icn_Settings = By.xpath("//a[@class= 'topHeaderIcon sf-with-ul']");
	By tab_OER= By.xpath("//a[@href= '#tab-OER']");
	By tab_OERSum = By.xpath("//div[@id='divForA6']");
	By tab_ResourcesOnSql= By.xpath("//div[@id='divForA1']");
	By tab_RAMForSql= By.xpath("//div[@id='divForA5']");
	By tbl_OERSumStatus1 = By.xpath("(//td)[2]");
	By tbl_OERSumStatus2 = By.xpath("(//td)[4]");
	By tbl_OERSumStatus3 = By.xpath("(//td)[6]");
	By tbl_OERSumStatus4 = By.xpath("(//td)[8]");
	By tbl_RAMForSqlStatus1 = By.xpath("//div[@id=\"divFor5\"]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]");
	By tbl_RAMForSqlStatus2 = By.xpath("//div[@id=\"divFor5\"]/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[2]");
	By menu_Assets = By.xpath("//a[text()='Assets']");
	By menu_Computers = By.xpath("//a[text()='Computers']");
	By txt_ComputersConnected = By.xpath("(//div[@class='compOnline']/b)[1]");
	By txt_TotalComputers = By.xpath("(//div[@class='compOnline']/b)[2]");
	By txt_CurrentCLVersion = By.xpath("(//div[@class='compOnline']/b)[3]");
	By txt_CLVersionForUpgrade = By.xpath("(//div[@class='compOnline']/b)[4]");
	By img_ResourcesOnSqlPieChart = By.cssSelector("g[transform='rotate(0)']>path");
	By img_ResourcesOnSqlGraph = By.cssSelector("div>svg>g[transform^='translate']");
	

	/*****************************Test Case Methods 
	 * @throws IOException *******************/
	//For all WebElements may append type Example: Submit_Btn

	
	public void TM_GSEC_S01_Web_Login_GSEC_Application() throws IOException {
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		wait(2);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		title = getTitle();
		Assert.assertEquals(title, "Cb Protection - Dashboard");
		
		wait(5);
		takeScreenshotAtEndOfTest();

	}

	public void TM_GSEC_S02_Web_OER_SystemHealthCheck() throws IOException {
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		wait(2);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();

		WebElement Settings_Icn = createWebElementBy(icn_Settings);
		Settings_Icn.click();

		WebElement OER_Tab = createWebElementBy(tab_OER);
		OER_Tab.click();
		
		wait(5);
		takeScreenshotAtEndOfTest();
		
		WebElement OERSum_Tab = createWebElementBy(tab_OERSum);
		OERSum_Tab.click();
		
		WebElement OERSumStatus1_Tbl = createWebElementBy(tbl_OERSumStatus1);
		text = OERSumStatus1_Tbl.getText();
		Assert.assertTrue(text.contains("OK"));
		
		WebElement OERSumStatus2_Tbl = createWebElementBy(tbl_OERSumStatus2);
		text = OERSumStatus2_Tbl.getText();
		Assert.assertTrue(text.contains("OK"));
		
		WebElement OERSumStatus3_Tbl = createWebElementBy(tbl_OERSumStatus3);
		text = OERSumStatus3_Tbl.getText();
		Assert.assertTrue(text.contains("OK"));
		
		WebElement OERSumStatus4_Tbl = createWebElementBy(tbl_OERSumStatus4);
		text = OERSumStatus4_Tbl.getText();
		Assert.assertTrue(text.contains("OK"));
		
		wait(5);
		takeScreenshotAtEndOfTest();
	
		WebElement ResourcesOnSql_Tab = createWebElementBy(tab_ResourcesOnSql);
		ResourcesOnSql_Tab.click();

		List<WebElement> Icons = createWebElementsBy(img_ResourcesOnSqlPieChart);
		
		IsDisplayed_IsEnabled(Icons.get(0));
		IsDisplayed_IsEnabled(Icons.get(1));
		
		wait(5);
		takeScreenshotAtEndOfTest();

		WebElement RAMForSql_Tab = createWebElementBy(tab_RAMForSql);
		RAMForSql_Tab.click();
		List<WebElement> Icon = createWebElementsBy(img_ResourcesOnSqlGraph);
		
		IsDisplayed_IsEnabled(Icon.get(2));
		
		wait(5);
		takeScreenshotAtEndOfTest();
		
		WebElement RAMForSqlStatus1_Tbl = createWebElementBy(tbl_RAMForSqlStatus1);
		text = RAMForSqlStatus1_Tbl.getText();
		Assert.assertTrue(text.contains("OK"));

		WebElement RAMForSqlStatus2_Tbl = createWebElementBy(tbl_RAMForSqlStatus2);
		text = RAMForSqlStatus2_Tbl.getText();
		Assert.assertTrue(text.contains("OK"));
		
		scrollToBottomOfHTML();
		
		wait(5);
		takeScreenshotAtEndOfTest();

	}

	public void TM_GSEC_S03_Check_Computers_Tab_functionalities() throws IOException {
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		wait(2);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();

		WebElement Assets_Menu = createWebElementBy(menu_Assets);
		mouseHover(Assets_Menu);

		WebElement Computers_Menu = createWebElementBy(menu_Computers);
		mouseHover(Computers_Menu);
		Computers_Menu.click();

		WebElement ComputersConnected_Txt = createWebElementBy(txt_ComputersConnected);
		text = ComputersConnected_Txt.getText();
		num = Integer.parseInt(text);
		Assert.assertTrue(num >= 1);

		WebElement TotalComputers_Txt = createWebElementBy(txt_TotalComputers);
		text = TotalComputers_Txt.getText();
		num = Integer.parseInt(text);
		Assert.assertTrue(num >= 1);

		WebElement CurrentCLVersion_Txt = createWebElementBy(txt_CurrentCLVersion);
		text = CurrentCLVersion_Txt.getText();
		num = Integer.parseInt(text);
		Assert.assertTrue(num >= 1);

		WebElement CLVersionForUpgrade_Txt = createWebElementBy(txt_CLVersionForUpgrade);
		text = CLVersionForUpgrade_Txt.getText();
		num = Integer.parseInt(text);
		Assert.assertTrue(num >= 1);

		wait(5);
		takeScreenshotAtEndOfTest();

	}

	public void TM_GSEC_S04_user_Login_using_wrong_credentials() throws IOException {
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(PasswordNegative);

		wait(2);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		
		wait(5);
		takeScreenshotAtEndOfTest();
		title = getTitle();
		Assert.assertEquals(title, "Cb Protection - Login");

	}

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here
	
	
}	
		