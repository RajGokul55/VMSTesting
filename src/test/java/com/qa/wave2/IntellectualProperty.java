package com.qa.wave2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;
import com.qa.demo.util.WebEventListener;

public class IntellectualProperty extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	String pageTitle;
	private static String downloadPath = "C:\\Users\\abhatt2\\Downloads";
	public String file_orgchar= "IP_ORG_CHART.doc";
	public String file_attorneyAssignment="attorney assignment.pdf";
	// URL for Fc vision:
	public String downloadPath1;
	final String url = "http://gileadappstest/ip/";
	

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

	

	@Test(priority = 0, enabled = true)
	public void IntellectualProperty_S01_Web_OrgChart() {
		TM_IntellectualProperty_S01_Web_OrgChart();
	}
	
	@Test(priority = 0, enabled = true)
	public void IntellectualProperty_S02_Web_APATherapeuticArea() {
		TM_IntellectualProperty_S02_Web_APATherapeuticArea();
	}
	
	@AfterMethod(enabled = true)
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */

	// PROD 1:
	By lnk_IntellectualProperty = By.linkText("Intellectual Property Org Chart");
	By lnk_APATherapeuticArea= By.linkText("Attorney Product/Project assignment by Therapeutic area");
	By autoalertConfirmation=By.xpath("//strong/*[@face=\"Arial\"]");
	
	
	


	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	

	public void TM_IntellectualProperty_S01_Web_OrgChart() {
		launchBrowser(Browser, url);
		 pageTitle=getTitle();
		 Assert.assertEquals(pageTitle, "Intellectual Property - IDS");
		 WebElement IPlink= createWebElementBy(lnk_IntellectualProperty);
		 IPlink.click();
		 wait(7);
		 Assert.assertTrue(isFileDownloaded(downloadPath, file_orgchar));
				
	}
	public void TM_IntellectualProperty_S02_Web_APATherapeuticArea() {
		launchBrowser(Browser, url);
		 pageTitle=getTitle();
		 Assert.assertEquals(pageTitle, "Intellectual Property - IDS");
		 WebElement link= createWebElementBy(lnk_APATherapeuticArea);
		 link.click();
		 wait(7);
		 Assert.assertTrue(isFileDownloaded(downloadPath, file_attorneyAssignment));
				
	}
	/*
	 * public void filePathforUser(String user) { downloadPath1=
	 * "C:\\Users\\"+user+"\\Downloads"; System.out.println(downloadPath1);
	 * Assert.assertTrue(isFileDownloaded(downloadPath1, file_attorneyAssignment));
	 * }
	 */
	
	
	


	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
