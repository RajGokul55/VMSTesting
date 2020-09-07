package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GVDGS2 extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String DevURL = "http://fcgvdappdev01/gvd/";
	final String TestURL = "http://fcgvdapptest01/gvd/DataBrowser.aspx";
	final String UAT_Url = "http://fcgvdappuat01/gvd";
	final String ValURL = "http://drgvdgs2appval1/gvd/DataBrowser.aspx";
	final String ProdURL ="http://FCGVDGS2APPPRD1/GVD/ ";

	/***************************** Test Cases *******************/
	
	String URL = ProdURL; // Change URl whichever Env you want to execute.
	

	@Test(priority = 0, enabled = true)
	public void GVDGS2_S01_Web_UserLogin() {
		TM_GVDGS2_S01_Web_UserLogin(URL);
	}

	@Test(priority = 1, enabled = true)
	public void GVDGS2_S02_Web_OptionsMenuSystemAccessible() {
		TM_GVDGS2_S02_Web_OptionsMenuSystemAccessible(URL);
	}

	@Test(priority = 2, enabled = true)
	public void GVDGS2_S03_Web_PagesMenuSystemAccessible() {
		TM_GVDGS2_S03_Web_PagesMenuSystemAccessible(URL);
	}

	@Test(priority = 3, enabled = true)
	public void GVDGS2_S04_Web_TabUnderDataBrowserAccessible() {
		TM_GVDGS2_S04_Web_TabUnderDataBrowserAccessible(URL);

	}

	@Test(priority = 4, enabled = true)
	public void GVDGS2_S05_Web_TestvaluesofdifferentTabs() {
		TM_GVDGS2_S05_Web_TestvaluesofdifferentTabs(URL);

	}
	
	@AfterMethod
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	/*
	 * // Example syntax:Css Selector: Tag //
	 * name[attribute1:'value1'][attribute2:'value2']
	 * 
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
	By lnk_Studies = By.xpath("//span[contains(text(),'Studies')]");
	By lnk_FindStudies = By.xpath("//span[contains(text(),'Find Studies')]");
	By lnk_Drugs = By.xpath("//span[@class='rmText'][contains(text(),'Drugs')]");
	By img_DrugsClassesPH = By.xpath("//*[@id='ctl00_masterContentPlaceHolder_rgDrugClass_ctl00_ctl04_gbccolumn']");
	By lnk_DrugID = By.xpath("//a[contains(text(),'DrugID')]");

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	void TM_GVDGS2_S01_Web_UserLogin(String url) {

		launchBrowser(Browser, url);
		takeScreenshotAtEndOfTest();

		Assert.assertEquals(driver.getTitle(), "Gilead Virology Database (GVD)");

	}

	void TM_GVDGS2_S02_Web_OptionsMenuSystemAccessible(String url) {
		launchBrowser(Browser, url);

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

		takeScreenshotAtEndOfTest();
	}

	public void TM_GVDGS2_S03_Web_PagesMenuSystemAccessible(String url) {
		launchBrowser(Browser, url);

		WebElement Reports_lnk = createWebElementBy(lnk_Reports);
		mouseHover(Reports_lnk);

		WebElement SLE_lnk = createWebElementBy(lnk_SLE);
		SLE_lnk.click();

		waitForPageLoaded();
		takeScreenshotAtEndOfTest();

		Assert.assertEquals( driver.getTitle(), "Sample Listing Export Utility", "Sample Listing Export page not displayed");

	}

	public void TM_TC03_Web_Pages_in_Menu_System_Accessible(String url) {
		launchBrowser(Browser, url);
		
		WebElement Reports_lnk = createWebElementBy(lnk_Reports);
		mouseHover(Reports_lnk);

		WebElement SLE_lnk = createWebElementBy(lnk_SLE);
		SLE_lnk.click();

		Assert.assertEquals(driver.getTitle(), "Sample Listing Export Utility", "Sample Listing Export page not displayed");

		WebElement Metadatas_lnk = createWebElementBy(lnk_Metadatas);
		mouseHover(Metadatas_lnk);

		WebElement Studies_lnk = createWebElementBy(lnk_Studies);
		Studies_lnk.click();
		
		takeScreenshotAtEndOfTest();
		

		Assert.assertEquals(driver.getTitle(), "Manage Studies", "Manage Studies page is not displayed");

	}

	public void TM_GVDGS2_S04_Web_TabUnderDataBrowserAccessible(String url) {
		launchBrowser(Browser, url);
		
		WebElement Home_lnk = createWebElementBy(lnk_Home);
		Home_lnk.click();
		
		WebElement FS_lnk = createWebElementBy(lnk_FindStudies);
		mouseHover(FS_lnk);
		
		FS_lnk.click();
		takeScreenshotAtEndOfTest();

	}

	public void TM_GVDGS2_S05_Web_TestvaluesofdifferentTabs(String url) {
		launchBrowser(Browser, url);
		
		WebElement Metadatas_lnk = createWebElementBy(lnk_Metadatas);
		mouseHover(Metadatas_lnk);

		WebElement Drugs_lnk = createWebElementBy(lnk_Drugs);
		Drugs_lnk.click();

		WebElement DrugsClassesPH_img = createWebElementBy(img_DrugsClassesPH);
		DrugsClassesPH_img.click();

		WebElement DrugID_lnk = createWebElementBy(lnk_DrugID);
		String Acttext = DrugID_lnk.getText();
		
		takeScreenshotAtEndOfTest();
		
		Assert.assertEquals(Acttext, "DrugID", "DrugID link is not displayed");

	}
}
