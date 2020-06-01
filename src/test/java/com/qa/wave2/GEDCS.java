package com.qa.wave2;


import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class GEDCS extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "http://sjmerapptstg01/Meridian/Main";
	final String Username ="nnereddula";
	private String DecrptPassword;


	/***************************** Test Cases *******************/
	
	

	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void GEDCS_S01_PostPatch_Testing() {
		TM_GEDCS_S01_PostPatch_Testing();
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

	By icn_Masters= By.xpath("//tr[5]//td[1]//div[1]//a[1]//img[1]");
	By icn_Fostercity= By.xpath("//tr[10]//td[1]//div[1]//a[1]//img[1]");
	By icn_NonIP= By.xpath("//a[contains(@href,'./?Main&amp;vault={3F8B56E9-9FEE-4879-B983-CDBFDCCD4345}&amp;view=Explorer&amp;moment=&amp;\'");
	By icn_commonsiteareas= By.xpath("//tr[25]//td[1]//div[1]//a[1]//img[1]");
	By icn_general_nondis= By.xpath("//tr[30]//td[1]//div[1]//a[1]//img[1]");
	By lnk_drawing= By.xpath("//a[@class='released']");
	By btn_name= By.xpath("//a[contains(text(),'nnereddula (Naga Nereddula)')]");
	By btn_Logout = By.xpath("//a[contains(text(),'Log Off')]");
	


	
/*******************Login page****************/
	
	void TM_GEDCS_S01_PostPatch_Testing() {
		WebElement Masters_icn = createWebElementBy(icn_Masters);
		Masters_icn.click();

		WebElement Fostercity_icn = createWebElementBy(icn_Fostercity);
		Fostercity_icn.click();

		WebElement  Nonip_icn = createWebElementBy(icn_NonIP);
		Nonip_icn.click();
		
		WebElement  Commonsiteareas_icn = createWebElementBy(icn_commonsiteareas);
		Commonsiteareas_icn.click();
		
		WebElement  general_nondis_icn = createWebElementBy(icn_general_nondis);
		takeScreenshotAtEndOfTest();
		general_nondis_icn.click();
		
		WebElement  drawing_icn = createWebElementBy(lnk_drawing);
		takeScreenshotAtEndOfTest();
		drawing_icn.click();
		
		WebElement  name_icn = createWebElementBy(btn_name);
		name_icn.click();
		
		WebElement  logout_icn = createWebElementBy(btn_Logout);
		takeScreenshotAtEndOfTest();
		logout_icn.click();
		
		
		
		}
		
		
	}
	

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here

