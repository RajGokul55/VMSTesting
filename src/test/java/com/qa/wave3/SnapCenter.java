package com.qa.wave3;


import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class SnapCenter extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sjgscbappprdn01:8146/";
	
	/***************************** Test Cases *******************/
	
	

	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void SC_S01_LoginUrl() {
		TM_SC_S01_LoginUrl();
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
	
	By icn_Snapcenter= By.xpath("//h1[@class='sm-product-name']");
	
	
/*******************Login page****************/
	
	void TM_SC_S01_LoginUrl(){
		WebElement Snapcenter_icn = createWebElementBy(icn_Snapcenter);
		Snapcenter_icn.click();
		takeScreenshotAtEndOfTest();
		waitForPageLoaded();

		
		
		
		}
		
		
	}
	

	