package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GIMS extends CommonMethods {

	/***************************** Test Cases *******************/

	@BeforeMethod(enabled = true)
	public void beforeTest() {

	}

	@Test(priority = 0, enabled = true)
	public void GIMS_S01_Web_NA_Dev_UserLogin() throws IOException {
		TM_GIMS_S01_Web_NA_Dev_UserLogin();

	}

	@Test(priority = 1, enabled = true)
	public void GIMS_S02_Web_NA_Dev_ServerNodeValidation() throws IOException {
		TM_GIMS_S02_Web_NA_Dev_ServerNodeValidation();

	}

	@Test(priority = 2, enabled = true)

	public void GIMS_S03_Web_NA_Prod_UserLogin() throws IOException {
		TM_GIMS_S03_Web_NA_Prod_UserLogin();

	}

	@Test(priority = 3, enabled = true)

	public void GIMS_S04_Web_NA_Prod_ServerNodeValidation() throws IOException {
		TM_GIMS_S04_Web_NA_Prod_ServerNodeValidation();

	}

	@Test(priority = 4, enabled = true)
	public void GIMS_S05_Web_EU_Prod_UserLogin() throws IOException {
		TM_GIMS_S05_Web_EU_Prod_UserLogin();

	}

	@Test(priority = 5, enabled = true)
	public void GIMS_S06_Web_EU_Prod_ServerNodeValidation() throws IOException {
		TM_GIMS_S06_Web_EU_Prod_ServerNodeValidation();

	}

	@Test(priority = 6, enabled = true)
	public void GIMS_S07_Web_AP_Prod_UserLogin() throws IOException {
		TM_GIMS_S07_Web_AP_Prod_UserLogin();

	}

	@Test(priority = 7, enabled = true)
	public void GIMS_S08_Web_AP_Prod_ServerNodeValidation() throws IOException {
		TM_GIMS_S08_Web_AP_Prod_ServerNodeValidation();

	}

	@Test(priority = 8, enabled = true)
	public void GIMS_S09_Web_Kite_Prod_UserLogin() throws IOException {
		TM_GIMS_S09_Web_Kite_Prod_UserLogin();

	}

	@Test(priority = 9, enabled = true)
	public void GIMS_S10_Web_Kite_Prod_ServerNodeValidation() throws IOException, InterruptedException {
		TM_GIMS_S10_Web_Kite_Prod_ServerNodeValidation();

	}

	@AfterMethod
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	By ipt_Find = By.xpath(
			"//input[@id='ctl00_ctl00_ctl00_BodyContent_ContentPlaceHolder1_MainContentPlaceHolder_ResourceHostControl1_resContainer_rptContainers_ctl00_rptColumn1_ctl00_ctl01_Wrapper_txtSearchString']");
	By btn_Search = By.xpath("//span[contains(text(),'Search')]");
	By lnk_ActiveAlerts = By.xpath("//span[contains(text(),'Active Alerts')]");
	By lnk_NAProdServerDetails = By.xpath("//a[contains(text(),'sjmonappprdg01.na.gilead.com')]");
	By lnk_NADevServerDetails = By.xpath("//a[contains(text(),'sjgimsappdevn01.na.gilead.com')]");
	By lnk_EUProdServerDetails = By.xpath("//a[contains(text(),'eumonappprdg01.eu.gilead.com')]");
	By lnk_APProdServerDetails = By.xpath("//a[contains(text(),'tymonappprdg01.ap.gilead.com')]");
	By lnk_KiteServerDetails = By.xpath("//a[contains(text(),'drgimsappprdn89')]");
	By lnk_NAProdSummary = By.xpath("//span[contains(text(),'Summary')]");
	By lnk_NADevSummary = By.xpath("//a[@class='sw-widget__title'][contains(text(),'Management')]");
	By lnk_EUProdSummary = By.xpath("//span[contains(text(),'Summary')]");
	By lnk_APProdSummary = By.xpath("//span[contains(text(),'Summary')]");
	By lnk_KiteSummary = By.xpath("//a[@class='sw-widget__title'][contains(text(),'Management')]");
	By ipt_kitelogin = By.xpath("//input[@id='ctl00_BodyContent_Username']");
	By ipt_kitepwd = By.xpath("//input[@id='ctl00_BodyContent_Password']");
	By btn_kiteloginbtn = By.xpath("//span[@class='sw-btn-t']");

	/***************************** Test Case Methods *******************/

	public void TM_GIMS_S01_Web_NA_Dev_UserLogin() throws IOException {

		TM_GIMS_Web_NA_Dev_GenericMethod();

		Assert.assertEquals(driver.getTitle(), "Network System View - Summary",
				"Network System View - Summary is not displayed");
		takeScreenshotAtEndOfTest();
	}

	public void TM_GIMS_S02_Web_NA_Dev_ServerNodeValidation() throws IOException {

		TM_GIMS_Web_NA_Dev_GenericMethod();
		WebElement Find_ipt = createWebElementBy(ipt_Find);
		Find_ipt.sendKeys("sjgimsappdevn01.na.gilead.com");

		WebElement Search_btn = createWebElementBy(btn_Search);
		Search_btn.click();

		WebElement NADevServerDetails_lnk = createWebElementBy(lnk_NADevServerDetails);
		NADevServerDetails_lnk.click();

		WebElement NADevSummary_lnk = createWebElementBy(lnk_NADevSummary);
		String Manage = NADevSummary_lnk.getText();
		Assert.assertEquals(Manage, "Management");

		takeScreenshotAtEndOfTest();

	}

	public void TM_GIMS_S03_Web_NA_Prod_UserLogin() throws IOException {

		TM_GIMS__Web_NA_Prod_GenericMethod();

		Assert.assertEquals(driver.getTitle(), "Network System View", "Network System View is not displayed");
		takeScreenshotAtEndOfTest();

	}

	public void TM_GIMS_S04_Web_NA_Prod_ServerNodeValidation() throws IOException {

		TM_GIMS__Web_NA_Prod_GenericMethod();
		WebElement Find_ipt = createWebElementBy(ipt_Find);
		Find_ipt.sendKeys("sjmonappprdg01.na.gilead.com");

		WebElement Search_btn = createWebElementBy(btn_Search);
		Search_btn.click();

		WebElement NAProdServerDetails_lnk = createWebElementBy(lnk_NAProdServerDetails);
		NAProdServerDetails_lnk.click();

		WebElement NAProdSummary_lnk = createWebElementBy(lnk_NAProdSummary);
		String summ = NAProdSummary_lnk.getText();
		Assert.assertEquals(summ, "Summary");
		takeScreenshotAtEndOfTest();

	}

	public void TM_GIMS_S05_Web_EU_Prod_UserLogin() throws IOException {

		TM_GIMS_Web_EU_Prod_GenericMethod();
		Assert.assertEquals(driver.getTitle(), "Network System View", "Network System View is not displayed");
		takeScreenshotAtEndOfTest();

	}

	public void TM_GIMS_S06_Web_EU_Prod_ServerNodeValidation() throws IOException {
		TM_GIMS_Web_EU_Prod_GenericMethod();
		WebElement Find_ipt = createWebElementBy(ipt_Find);
		Find_ipt.sendKeys("eumonappprdg01.eu.gilead.com");

		WebElement Search_btn = createWebElementBy(btn_Search);
		Search_btn.click();

		WebElement EUProdServerDetails_lnk = createWebElementBy(lnk_EUProdServerDetails);
		EUProdServerDetails_lnk.click();

		WebElement EUProdSummary_lnk = createWebElementBy(lnk_EUProdSummary);
		String EUSummary = EUProdSummary_lnk.getText();
		Assert.assertEquals(EUSummary, "Summary");

		takeScreenshotAtEndOfTest();

	}

	public void TM_GIMS_S07_Web_AP_Prod_UserLogin() throws IOException {

		TM_GIMS_Web_AP_Prod_GenericMethod();
		Assert.assertEquals(driver.getTitle(), "Network System View", "Network System View is not displayed");
		takeScreenshotAtEndOfTest();

	}

	public void TM_GIMS_S08_Web_AP_Prod_ServerNodeValidation() throws IOException {
		TM_GIMS_Web_AP_Prod_GenericMethod();
		WebElement Find_ipt = createWebElementBy(ipt_Find);
		Find_ipt.sendKeys("tymonappprdg01.ap.gilead.com");

		WebElement Search_btn = createWebElementBy(btn_Search);
		Search_btn.click();

		WebElement APProdServerDetails_lnk = createWebElementBy(lnk_APProdServerDetails);
		APProdServerDetails_lnk.click();

		WebElement APProdSummary_lnk = createWebElementBy(lnk_APProdSummary);
		String APSummary = APProdSummary_lnk.getText();
		Assert.assertEquals(APSummary, "Summary");

		takeScreenshotAtEndOfTest();

	}

	public void TM_GIMS_S09_Web_Kite_Prod_UserLogin() throws IOException {

		TM_GIMS__Web_Kite_GenericMethod();

		Assert.assertEquals(driver.getTitle(), "Orion Summary Home - Summary",
				"Orion Summary Home - Summary is not displayed");
		takeScreenshotAtEndOfTest();

	}

	public void TM_GIMS_S10_Web_Kite_Prod_ServerNodeValidation() throws IOException, InterruptedException {
		TM_GIMS__Web_Kite_GenericMethod();
		WebElement Find_ipt = createWebElementBy(ipt_Find);
		Find_ipt.sendKeys("DRGIMSAPPPRDN89");

		WebElement Search_btn = createWebElementBy(btn_Search);
		Search_btn.click();

		WebElement KiteServerDetails_lnk = createWebElementBy(lnk_KiteServerDetails);
		KiteServerDetails_lnk.click();
		wait(90);

		WebElement KiteSummary_lnk = createWebElementBy(lnk_KiteSummary);
		String KiteManage = KiteSummary_lnk.getText();
		Assert.assertEquals(KiteManage, "Management");

		takeScreenshotAtEndOfTest();

	}

	/***************************** Generic Methods *******************/

	public void TM_GIMS_Web_NA_Dev_GenericMethod() throws IOException {

		final String Browser = "Chrome";
		final String NADevURL = "http://gims-dev";
		launchBrowser(Browser, NADevURL);
		waitForPageLoaded();
	}

	public void TM_GIMS__Web_NA_Prod_GenericMethod() throws IOException {

		final String Browser = "Chrome";
		final String NAProdURL = "http://gims-na";
		launchBrowser(Browser, NAProdURL);
		waitForPageLoaded();
	}

	public void TM_GIMS_Web_EU_Prod_GenericMethod() throws IOException {

		final String Browser = "Chrome";
		final String EUProdURL = "http://gims-eu";
		launchBrowser(Browser, EUProdURL);
		waitForPageLoaded();
	}

	public void TM_GIMS_Web_AP_Prod_GenericMethod() throws IOException {

		final String Browser = "Chrome";
		final String APProdURL = "http://gims-ap";
		launchBrowser(Browser, APProdURL);
		waitForPageLoaded();
	}

	public void TM_GIMS__Web_Kite_GenericMethod() throws IOException {

		final String Browser = "Chrome";
		final String KiteURL = "http://kite-solar";
		String DecryptPassword = null;
		final String EncryptPassword = "gauEQnlth0rzudo2rv35/A==";
		final String URL = KiteURL;
		launchBrowser(Browser, URL);
		try {
			DecryptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebElement Username_Ipt = createWebElementBy(ipt_kitelogin);
		Username_Ipt.sendKeys("NA\\dmarkanti");

		WebElement Password_Ipt = createWebElementBy(ipt_kitepwd);
		Password_Ipt.sendKeys(DecryptPassword);

		WebElement Login_Btn = createWebElementBy(btn_kiteloginbtn);
		Login_Btn.click();

		waitForPageLoaded();

	}

}
