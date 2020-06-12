package com.qa.wave2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;
import com.qa.demo.util.WebEventListener;

public class DLManager extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	String pageTitle;
	// URL for Fc vision:
	final String url = "http://gileadappstest/DLManager ";
	

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
	public void DLManager_S01_Web_AutoAlert() {
		TM_DLManager_S01_Web_AutoAlert();
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
	By btn_subscribe = By.id("body_btnSubscribe");
	By autoalertConfirmation=By.xpath("//strong/*[@face=\"Arial\"]");
	
	
	


	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	

	public void TM_DLManager_S01_Web_AutoAlert() {
		launchBrowser(Browser, url);
		 pageTitle=getTitle();
		Assert.assertEquals(pageTitle, "DL Manager");
		
		//select autoalert for Library & Information  Newsletter
		selectCheckBox("Library & Information  Newsletter");
		
		//Select autolert for HIV NRTIs and NNRTIs
		selectCheckBox("NRTIs");
		selectCheckBox("NNRTIs");
		
		//select autoalert for Lever Hepatitis C 
		selectCheckBox("Hepatitis C");
		//select autoalert for  cardiovascular Ranexa
		selectCheckBox("Ranexa");
		
		//select autoalert for fungal Ambisome
		selectCheckBox("Ambisome");
		
		//unselect CD19 and select Autoalert for Asthma
		selectCheckBox("CD 19");
		selectCheckBox("Asthma");
		
		WebElement submit= createWebElementBy(btn_subscribe);
		submit.click();
		
		List<WebElement> confirmationMessage = createWebElementsBy(autoalertConfirmation);
		for (int i = 0; i < confirmationMessage.size(); i++) {
			System.out.println("Message " + confirmationMessage.get(i).getText() + " is displayed");
			
		}
		
			
	}
	public void selectCheckBox(String Autoalertcheckbox) {
		WebElement  checkbox = driver.findElement(By.xpath("//label[text()='"+Autoalertcheckbox+"']/preceding-sibling::input"));
		scrollToWebElement(checkbox);
		checkbox.click();
	}


	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
