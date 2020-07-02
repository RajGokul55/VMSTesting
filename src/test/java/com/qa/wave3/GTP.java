package com.qa.wave3;


import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class GTP extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://gtp.gilead.com/t/COE/views/TableauServerPerformance_prd2018_publishedDS/"
			+ "DiskUsage?iframeSizedToWindow=true&%3Aembed=y&%3"
			+ "AshowAppBanner=false&%3Adisplay_count=no&%3AshowVizHome=no#1";
	


	/***************************** Test Cases *******************/
	
	

	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void GTP_S01_PostPatch_Testing() {
		TM_GTP_S01_PostPatch_Testing();
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
	
	By icn_CPUusage= By.xpath("//span[@id='tableauTabbedNavigation_tab_1");
	By icn_memoryusage= By.xpath("//span[@id='tableauTabbedNavigation_tab_1']");
	By icn_DiskUsage= By.xpath("//span[@id='tableauTabbedNavigation_tab_2']");
	
	
/*******************Login page****************/
	
	void TM_GTP_S01_PostPatch_Testing() {
		WebElement Memoryusage_icn = createWebElementBy(icn_memoryusage);
		Memoryusage_icn.click();
		takeScreenshotAtEndOfTest();
		wait(5);

		WebElement Diskusage_icn = createWebElementBy(icn_DiskUsage);
		Diskusage_icn.click();
		wait(5);
		takeScreenshotAtEndOfTest();
		
		
		}
		
		
	}
	

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here

