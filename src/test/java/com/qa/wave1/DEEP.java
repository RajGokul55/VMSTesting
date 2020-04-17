package com.qa.wave1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;



public class DEEP extends CommonMethods{

	/***************************** Test Data*******************/
	
	final String Browser= "Chrome";
	//URL for methods service
	final String Url= "http://fcdsqappprdg01:10000/fisherExact/23/42/21/50";
	//URL1 for virus subtyper service
	final String Url1= "http://fcdsqappprdg01:10007/ref_genotype?therapeutic_area_id=HIV&genotype=C";
	//URL for virology outcome service
	final String Url2= "http://fcdsqappprdg01:10001/api/v1.0/study/GS-US-367-1175/subject_filenames";

	


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
	}
	
	@Test(priority=0, enabled=true)
	public void DEEP_TC01_Web_Service() {
		TM_DEEP_TC01_Web_Service();
	}
	
	  @Test(priority=1, enabled=true)
	  public void DEEP_TC02_Web_Service() {
		  TM_DEEP_TC02_Web_Service();
	  	  }
	  
	
	  @Test(priority=2, enabled=true) 
	  public void DEEP_TC03_Web_Service() { 
		  TM_DEEP_TC03_Web_Service();
		  
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

	
	By txt_MethodsService = By.xpath("//body[contains(text(),'0.582318812534')]");
	By txt_VirusSubtyperService = By.xpath("//body[contains(text(),'B')]");
	By txt_VirologyOutcomeService = By.xpath("//pre[contains(text(),'{')]");
	

	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn

	public void TM_DEEP_TC01_Web_Service() {
		
		
		WebElement MethodsService = createWebElementBy(txt_MethodsService);
		String text = MethodsService.getText();
		Assert.assertEquals(text,"0.582318812534");
	}

	public void TM_DEEP_TC02_Web_Service() {
		
		launchBrowser(Browser, Url1);
		
		WebElement VirusSubtyperService = createWebElementBy(txt_VirusSubtyperService);
		String text = VirusSubtyperService.getText();
		Assert.assertEquals(text,"B");		
	}

	public void TM_DEEP_TC03_Web_Service() {
		
		launchBrowser(Browser, Url2);
		
		WebElement VirologyOutcomeService = createWebElementBy(txt_VirologyOutcomeService);
		String text = VirologyOutcomeService.getText();
		Assert.assertTrue(text.contains("GS-US-367-1175"));
		
		
	}

	

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here
	
	
}	
		