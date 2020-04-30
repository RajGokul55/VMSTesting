package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GVT extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url_dev1= "http://devgvt.gilead.com";
	final String Url_dev2= "http://dev.gvtstat.gilead.com/SplusServer/api/v8/administration/ExtendedServerInfo";
	final String Url_test1= "http://app.spotfire.gilead.com";	
	final String Url_test2= "http://fcbarnapptstn01:8080/SplusServer/api/v8/administration/ExtendedServerInfo"; 
	final String Url_val1= "http://valgvt.gilead.com";	
	final String Url_val2= "http://val.gvtstat.gilead.com/SplusServer/api/v8/administration/ExtendedServerInfo";
	final String Url_prd1= "http://gvt.gilead.com";	
	final String Url_prd2= "http://gvtstat.gilead.com/SplusServer/api/v8/administration/ExtendedServerInfo";
	final String Url_SMPOC1= "http://fccaappsup01.na.gilead.com/";	
	final String Url_SMPOC2= "http://fccaappsup01:8080/SplusServer/api/v8/administration/ExtendedServerInfo";

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

	@Test(priority=0, enabled=true)
	public void GVT_01_Web_ValidateSpotfireServer() {
		TM_GVT_01_Web_ValidateSpotfireServer();
	}

	@Test(priority=1, enabled=true)
	public void GVT_02_Web_ValidateReportAccessiblity() {
		TM_GVT_02_Web_ValidateReportAccessiblity();
	}

	@Test(priority=2, enabled=true)
	public void GVT_03_Web_ValidateTERRServer() {
		TM_GVT_03_Web_ValidateTERRServer();
	}

	@AfterMethod
	public void afterMethod() {
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

	/*****************************Other Environment*********************/
	
	By menu_Details= By.xpath("//pre");
	By menu_View  = By.xpath("(//*[@class='ng-scope' and @viewBox='0 0 14 14'])[6]");
	By menu_It = By.xpath("//*[contains(text(),'IT')]");
	By menu_Users = By.xpath("//*[contains(text(),'Users')]");
	By menu_VMS = By.xpath("//*[contains(text(),'VMS')]");
	By menu_DXPUsageToday = By.xpath("//*[@title='DXPUsageToday']");
	By title_Report = By.xpath("//*[@class='pageTitle']");
			
	/*****************************Test Environment*********************/
	
	By menu_Library = By.xpath("//*[contains(text(),'Browse the library')]");
	By menu_DXPUsageToday_test_POC = By.xpath("(//*[contains(text(),'DXPUsageToday')])[2]");
	
	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn

	void TM_GVT_01_Web_ValidateSpotfireServer() {

		launchBrowser(Browser, Url_dev1);
		wait(2);
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Library – TIBCO Spotfire", "URL is not correct");
		/*Test Env:*/ 
		//Assert.assertEquals(pageTitle, "New analysis – TIBCO Spotfire", "URL is not correct");
	}

	void TM_GVT_02_Web_ValidateReportAccessiblity() {

		launchBrowser(Browser, Url_dev1);
		wait(2);
		
		/*Test Env:*/ 
		//WebElement Library_menu = createWebElementBy(menu_Library);
		//Library_menu.click();
		
		WebElement View_menu = createWebElementBy(menu_View);
		View_menu.click();

		WebElement IT_menu = createWebElementBy(menu_It);
		IT_menu.click();
		
		WebElement Users_menu = createWebElementBy(menu_Users);
		Users_menu.click();
		
		WebElement VMS_menu = createWebElementBy(menu_VMS);
		VMS_menu.click();
		
		WebElement DXPUsage_menu = createWebElementBy(menu_DXPUsageToday);
		DXPUsage_menu.click();
		
		wait(3);
		
		WebElement Report_Title = createWebElementBy(title_Report);
		String report = Report_Title.getText();
		
		Assert.assertEquals(report, "DXP Usage", "Test case is failed");
	}

	void TM_GVT_03_Web_ValidateTERRServer() {

		launchBrowser(Browser, Url_dev2);
		wait(2);
		String currentUrl = driver.getCurrentUrl();
		//Assert.assertEquals(currentUrl, "http://dev.gvtstat.gilead.com/SplusServer/api/v8/administration/ExtendedServerInfo", "URL is not correct");
		
		WebElement Details_menu = createWebElementBy(menu_Details);
		String a = Details_menu.getText();
		System.out.println(a);
		String [] r =  a.split("=");
		String last = (r[1].split("s"))[0];
		String actual =r[0]+"="+last;
		System.out.println(actual);
		
		Assert.assertEquals(actual.trim(), "splus.server.engine.type=TERR", "Test Case Failed");
		

	}

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here
}
