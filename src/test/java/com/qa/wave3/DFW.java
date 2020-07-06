package com.qa.wave3;


import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class DFW extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "http://gsn:8080/start.html";
	


	/***************************** Test Cases *******************/
	
	

	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void DFW_S01_PostPatch_Testing() {
		TM_DFW_S01_PostPatch_Testing();
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
	
	
	
	
/*******************Login page****************/
	
	void TM_DFW_S01_PostPatch_Testing() {
		takeScreenshotAtEndOfTest();
		wait(5);

		//WebElement Diskusage_icn = createWebElementBy(icn_DiskUsage);
		//Diskusage_icn.click();
		wait(5);
		takeScreenshotAtEndOfTest();
		
		
		}
		
		
	}
	

	