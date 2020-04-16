package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import com.qa.demo.util.Retry;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Gvault extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sb-gilead-qualitydocs.veevavault.com";
	//final String Url_Dev= "https://sb-gilead-qualitydocs.veevavault.com";
	//final String Url_Test= "https://sb-gilead-it.veevavault.com"
	//final String Url_Val= "https://val-gilead.veevavault.com"
	final String Username ="psonawane@sb-gilead.com";

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

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true, retryAnalyzer = Retry.class)
	public void Gvault_01_Web_ValidateDescribanciesCreation(){
		TM_Gvault_03_Web_ValidateDescribanciesCreation();
	}

	@Test(priority=1, enabled=true, retryAnalyzer = Retry.class)
	public void Gvault_04_Web_ValidateDescribanciesEdit(){
		TM_Gvault_04_Web_ValidateDescribanciesEdit();
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

	By ipt_Username= By.name("j_username");
	By btn_Continue = By.name("continue");
	By menu_Library= By.name("libraries__c"); 
	By menu_ViewAll = By.xpath("//*[@class='viewAllCategories vv_view_all']");
	By menu_MediaFills = By.xpath("//*[@class='categoryTerm docClass vv_doc_class' and contains(text(), 'Media Fills')]");
	By lnk_Doc = By.cssSelector("div[class^='vm_container vv_vm']");
	By menu_Action = By.cssSelector(".doc_info_more_actions_menu.tourTarget.vv_button.vv_button_dropdown.tourTarget.DOCINFO_TOUR.DOCINFO_WKFLOWHIST_V7");
	By menu_ManageD = By.cssSelector(".menuTextTarget.vv_menu_text");
	
	

	/*****************************Test Case Methods 
	 * @throws IOException *******************/
	//For all WebElements may append type Example: Submit_Btn


	void TM_Gvault_03_Web_ValidateDescribanciesCreation(){

		Gvault_CommonFlow();
	}

	void TM_Gvault_04_Web_ValidateDescribanciesEdit() {

		Gvault_CommonFlow();
	}


	/*****************************Application Interaction Methods 
	 * @throws IOException *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here

    void Gvault_CommonFlow() {
    	WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Continue_Btn = createWebElementBy(btn_Continue);
		Continue_Btn.click();

		WebElement Library_menu = createWebElementBy(menu_Library);
		Library_menu.click();

		wait(2);

		WebElement Documents_menu = driver.findElement(lnk_Doc);
		mouseHover(Documents_menu);	
		Documents_menu.click();

		wait(2);

		WebElement ViewAll_menu = createWebElementBy(menu_ViewAll);
		ViewAll_menu.click();

		WebElement MediaFills_menu = createWebElementBy(menu_MediaFills);
		MediaFills_menu.click();
    	
    }
}
