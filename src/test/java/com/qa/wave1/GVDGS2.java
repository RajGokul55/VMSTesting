package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GVDGS2 extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String UAT_Url = "http://fcgvdappuat01/gvd";
	final String TestURL ="http://fcgvdapptest01/gvd/DataBrowser.aspx";
	final String ValURL ="http://drgvdgs2appval1/gvd/DataBrowser.aspx";
	final String DevURL ="http://fcgvdappdev01/gvd/";
	final String ProdURL ="http://FCGVDGS2APPPRD1/GVD/ ";

	/***************************** Test Cases *******************/
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	
	/*****************************UAT Url*******************/
	@Test(priority = 0, enabled = true)
	public void GVDGS2_S01_Web_UAT_UserLogin() {
		TM_GVDGS2_S01_Web_UAT_UserLogin(UAT_Url);
	}

	@Test(priority = 1, enabled = true)
	public void GVDGS2_S02_Web_UAT_OptionsMenuSystemAccessible() {
		TM_GVDGS2_S02_Web_UAT_OptionsMenuSystemAccessible(UAT_Url);
	}

	@Test(priority=2, enabled=true) 
	public void GVDGS2_S03_Web_UAT_PagesMenuSystemAccessible() {
		TM_GVDGS2_S03_Web_UAT_PagesMenuSystemAccessible(UAT_Url); 
	}

	@Test(priority=3, enabled=true) 
	public void GVDGS2_S04_Web_UAT_TabUnderDataBrowserAccessible() {
		//TM_GVDGS2_S04_Web_UAT_TabUnderDataBrowserAccessible(UAT_Url); 

	}

	@Test(priority=4, enabled=true) 
	public void GVDGS2_S05_Web_UAT_FiltersAppliedTabsDataBrowser() {
		//TM_GVDGS2_S05_Web_UAT_FiltersAppliedTabsDataBrowser(UAT_Url); 

	}

	/*****************************TestURL *******************/
	@Test(priority = 5, enabled = true)
	public void GVDGS2_S06_Web_UAT_UserLogin() {
		TM_GVDGS2_S01_Web_UAT_UserLogin(TestURL);
	}

	@Test(priority = 6, enabled = true)
	public void GVDGS2_S07_Web_UAT_OptionsMenuSystemAccessible() {
		TM_GVDGS2_S02_Web_UAT_OptionsMenuSystemAccessible(TestURL);
	}

	@Test(priority=7, enabled=true) 
	public void GVDGS2_S08_Web_UAT_PagesMenuSystemAccessible() {
		TM_GVDGS2_S03_Web_UAT_PagesMenuSystemAccessible(TestURL); 
	}

	@Test(priority=8, enabled=true) 
	public void GVDGS2_S09_Web_UAT_TabUnderDataBrowserAccessible() {
		//TM_GVDGS2_S04_Web_UAT_TabUnderDataBrowserAccessible(TestURL); 

	}

	@Test(priority=9, enabled=true) 
	public void GVDGS2_S10_Web_UAT_FiltersAppliedTabsDataBrowser() {
		//TM_GVDGS2_S05_Web_UAT_FiltersAppliedTabsDataBrowser(TestURL); 

	}

	/*****************************ValURL *******************/
	@Test(priority = 10, enabled = true)
	public void GVDGS2_S11_Web_UAT_UserLogin() {
		TM_GVDGS2_S01_Web_UAT_UserLogin(ValURL);
	}

	@Test(priority = 11, enabled = true)
	public void GVDGS2_S12_Web_UAT_OptionsMenuSystemAccessible() {
		TM_GVDGS2_S02_Web_UAT_OptionsMenuSystemAccessible(ValURL);
	}

	@Test(priority=12, enabled=true) 
	public void GVDGS2_S13_Web_UAT_PagesMenuSystemAccessible() {
		TM_GVDGS2_S03_Web_UAT_PagesMenuSystemAccessible(ValURL); 
	}

	@Test(priority=13, enabled=true) 
	public void GVDGS2_S14_Web_UAT_TabUnderDataBrowserAccessible() {
		//TM_GVDGS2_S04_Web_UAT_TabUnderDataBrowserAccessible(ValURL); 

	}

	@Test(priority=14, enabled=true) 
	public void GVDGS2_S15_Web_UAT_FiltersAppliedTabsDataBrowser() {
		//TM_GVDGS2_S05_Web_UAT_FiltersAppliedTabsDataBrowser(ValURL); 

	}
	
	/*****************************DevURL *******************/
	@Test(priority = 15, enabled = true)
	public void GVDGS2_S16_Web_UAT_UserLogin() {
		TM_GVDGS2_S01_Web_UAT_UserLogin(DevURL);
	}

	@Test(priority = 16, enabled = true)
	public void GVDGS2_S17_Web_UAT_OptionsMenuSystemAccessible() {
		TM_GVDGS2_S02_Web_UAT_OptionsMenuSystemAccessible(DevURL);
	}

	@Test(priority=17, enabled=true) 
	public void GVDGS2_S18_Web_UAT_PagesMenuSystemAccessible() {
		TM_GVDGS2_S03_Web_UAT_PagesMenuSystemAccessible(DevURL); 
	}

	@Test(priority=18, enabled=true) 
	public void GVDGS2_S19_Web_UAT_TabUnderDataBrowserAccessible() {
		//TM_GVDGS2_S04_Web_UAT_TabUnderDataBrowserAccessible(DevURL); 

	}

	@Test(priority=19, enabled=true) 
	public void GVDGS2_S20_Web_UAT_FiltersAppliedTabsDataBrowser() {
		//TM_GVDGS2_S05_Web_UAT_FiltersAppliedTabsDataBrowser(DevURL); 

	}
	
	/*****************************ProdURL *******************/
	@Test(priority = 20, enabled = true)
	public void GVDGS2_S21_Web_UAT_UserLogin() {
		TM_GVDGS2_S01_Web_UAT_UserLogin(ProdURL);
	}

	@Test(priority = 21, enabled = true)
	public void GVDGS2_S22_Web_UAT_OptionsMenuSystemAccessible() {
		TM_GVDGS2_S02_Web_UAT_OptionsMenuSystemAccessible(ProdURL);
	}

	@Test(priority=22, enabled=true) 
	public void GVDGS2_S23_Web_UAT_PagesMenuSystemAccessible() {
		TM_GVDGS2_S03_Web_UAT_PagesMenuSystemAccessible(ProdURL); 
	}

	@Test(priority=23, enabled=true) 
	public void GVDGS2_S24_Web_UAT_TabUnderDataBrowserAccessible() {
		//TM_GVDGS2_S04_Web_UAT_TabUnderDataBrowserAccessible(ProdURL); 

	}

	@Test(priority=24, enabled=true) 
	public void GVDGS2_S25_Web_UAT_FiltersAppliedTabsDataBrowser() {
		//TM_GVDGS2_S05_Web_UAT_FiltersAppliedTabsDataBrowser(ProdURL); 

	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector: Tag
	// name[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */
	By lnk_Home = By.xpath("//span[contains(text(),'Home')]");
	By lnk_Reports = By.xpath("//span[contains(text(),'Reports')]");
	By lnk_Metadatas = By.xpath("//span[contains(text(),'Metadatas')]");
	By lnk_AuditTrail = By.xpath("//span[contains(text(),'Audit Trail')]");
	By lnk_PSV = By.xpath("//span[contains(text(),'Process Status Viewer')]");
	By lnk_Help = By.xpath("//span[contains(text(),'Help')]");
	By lnk_SLE = By.xpath("//span[contains(text(),'Sample Listing Export')]");
	By lnk_Sequences = By.xpath("//span[contains(text(),'Sequences')]");


	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	void TM_GVDGS2_S01_Web_UAT_UserLogin(String url) {

		launchBrowser(Browser, url);

		Assert.assertEquals(driver.getTitle(), "Gilead Virology Database (GVD)");
	}

	void TM_GVDGS2_S02_Web_UAT_OptionsMenuSystemAccessible(String url) {
		launchBrowser(Browser,url );

		WebElement Home_lnk = createWebElementBy(lnk_Home);
		IsDisplayed_IsEnabled(Home_lnk);

		WebElement Reports_lnk = createWebElementBy(lnk_Reports);
		IsDisplayed_IsEnabled(Reports_lnk);


		WebElement Metadatas_lnk = createWebElementBy(lnk_Metadatas);
		IsDisplayed_IsEnabled(Metadatas_lnk);

		WebElement AuditTrail_lnk = createWebElementBy(lnk_AuditTrail);
		IsDisplayed_IsEnabled(AuditTrail_lnk);

		WebElement PSV_lnk = createWebElementBy(lnk_PSV);
		IsDisplayed_IsEnabled(PSV_lnk);

		WebElement Help_lnk = createWebElementBy(lnk_Help);
		IsDisplayed_IsEnabled(Help_lnk);

	}


	public void TM_GVDGS2_S03_Web_UAT_PagesMenuSystemAccessible(String url) { 
		launchBrowser(Browser, url);
		
		WebElement Reports_lnk = createWebElementBy(lnk_Reports);
		mouseHover(Reports_lnk);

		WebElement SLE_lnk=createWebElementBy(lnk_SLE);
		SLE_lnk.click();
		
		waitForPageLoaded();
		
		String ActTitle =driver.getTitle();
		Assert.assertEquals(ActTitle,"Sample Listing Export Utility", "Sample Listing Export page not displayed");

	}

	


	
}

