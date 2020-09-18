package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class Validata extends CommonMethods {
	/***************************** Test Data *******************/
	String Browser = "IE";
	String URL = "https://sjvldapptstn01.na.gilead.com/ecmlogin";
	String username = "vms_automation";
	String password = "fall2020";

	/***************************** Test Cases *******************/
	@BeforeMethod(enabled = true)
	public void beforeTest() {
		TM_launchandLogin();
	}

	@AfterMethod(enabled = true)
	public void afterTest() {
		driver.quit();
	}

	@Test(priority = 1, enabled = true)
	public void Validata_S01_Web_URL_Accessibility() {
		TM_Validata_S01_Web_URL_Accessibility();
	}

	@Test(priority = 2, enabled = true)
	public void Validata_S02_Web_Validata_URL_Accessibility() {
		TM_Validata_S02_Web_Validata_URL_Accessibility();
	}

	@Test(priority = 3, enabled = true)
	public void Validata_S03_Web_TransDetails() {
		TM_Validata_S03_Web_TransDetails();
	}

	@Test(priority = 4, enabled = true)
	public void Validata_S04_Web_MonitorTabVerification() {
		TM_Validata_S04_Web_Monitor_Tab_Verification();
	}

	@Test(priority = 5, enabled = true)
	public void Validata_S05_Web_MappingSetTabVerification() {
		TM_Validata_S05_Web_MappingSetTabVerification();
	}

	@Test(priority = 6, enabled = true)
	public void Validata_S06_Web_ValidationTabVerification() {
		TM_Validata_S06_Web_ValidationTabVerification();
	}

	@Test(priority = 8, enabled = true)
	public void Validata_S08_Web_SeveritySetTabVerification() {
		TM_Validata_S08_Web_SeveritySetTabVerification();
	}

	@Test(priority = 9, enabled = true)
	public void Validata_S09_Web_DataMangementTabVerification() {
		TM_Validata_S09_Web_DataMangementTabVerification();
	}

	@Test(priority = 11, enabled = true)
	public void Validata_S11_Web_ReportsTabVerification() {
		TM_Validata_S11_Web_ReportsTabVerification();
	}

	// Validata_TC04_Web_Monitor _Tab_Verification
	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */

	By lnk_Flex_Admin = By.cssSelector("div[id='appDiv00'] table tr:nth-child(1) td:nth-child(2)");
	By lnk_Validata = By.cssSelector("div[id='appDiv00'] table tr:nth-child(3) td:nth-child(2)");
	By lnk_Overridelink = By.xpath("//*[@href='https://sjvldapptstn01.na.gilead.com/ecmlogin']");
	By chk_ValFile1 = By.cssSelector("table[id='tbltflTag'] tr:nth-child(1) td:nth-child(1) input[type='checkbox']");
	By lnk_ValFileName = By
			.cssSelector("table[id='tbltflTag'] tr:nth-child(1) td#celltflTag04 div:nth-child(1) span:nth-child(1)");
	By tab_Monitor = By.cssSelector("a[id='monitorList']");
	By tab_MappingSets = By.cssSelector("a[id='mappingSetList']");

	By chk_MappingSet1 = By.cssSelector("table[id='tblmslTag'] tr[id='1'] td:nth-child(1) input");
	By lnk_MappingSetName1 = By.cssSelector("table[id='tblmslTag'] tr[id='1'] td:nth-child(2) span");
	By subtab_Records = By.cssSelector("div[id='tabs0head0']");
	By subtab_Mappings = By.cssSelector("div[id='tabs0head1']");
	By subtab_Conversions = By.cssSelector("div[id='tabs0head2']");

	By tab_ValidationSets = By.cssSelector("a[id='validationSetList']");
	By tab_SeveritySets = By.cssSelector("a[id='severitySetList']");
	By tab_DataManagement = By.cssSelector("a[id='dataManagement']");
	// By tab_DataManagement = By.xpath("//a[@id='dataManagement']");
	// By tab_AberrantQties = By.cssSelector("ul[id='dataManagement']
	// li:nth-child(1) a");
	By tab_AberrantQties = By.xpath("//a[contains(text(),'Aberrant Quantities')]");

	By tab_Reports = By.cssSelector("a[id='reportList']");
	By ipt_username = By.cssSelector("input[name='username']");
	By ipt_password = By.cssSelector("input[name='password']");
	By btn_LogOn = By.cssSelector("button[name='logon']");

	void TM_launchandLogin() {
		launchBrowser(Browser, URL);

		WebElement ContinueLink = createWebElementBy(lnk_Overridelink);
		ContinueLink.click();

		WebElement Username = createWebElementBy(ipt_username);
		Username.sendKeys(username);

		WebElement Password = createWebElementBy(ipt_password);
		Password.sendKeys(password);

		WebElement LogOn = createWebElementBy(btn_LogOn);
		LogOn.click();

		waitForPageLoaded();

		takeScreenshotAtEndOfTest();
	}

	void TM_Validata_S01_Web_URL_Accessibility() {
		WebElement FlexAdmin_Lnk = createWebElementBy(lnk_Flex_Admin);
		IsDisplayed_IsEnabled(FlexAdmin_Lnk);

		FlexAdmin_Lnk.click();
		takeScreenshotAtEndOfTest();

	}

	void TM_Validata_S02_Web_Validata_URL_Accessibility() {
		WebElement Validata_Lnk = createWebElementBy(lnk_Validata);
		IsDisplayed_IsEnabled(Validata_Lnk);

		Validata_Lnk.click();
		takeScreenshotAtEndOfTest();
	}

	void TM_Validata_S03_Web_TransDetails() {
		NavigateToValidata();

		WebElement File1_Checkbox = createWebElementBy(chk_ValFile1);
		File1_Checkbox.click();

		WebElement File1_Name = createWebElementBy(lnk_ValFileName);
		File1_Name.click();

		takeScreenshotAtEndOfTest();
	}

	void TM_Validata_S04_Web_Monitor_Tab_Verification() {
		NavigateToValidata();

		WebElement Monitor_tab = createWebElementBy(tab_Monitor);
		Monitor_tab.click();

		takeScreenshotAtEndOfTest();
	}

	void TM_Validata_S05_Web_MappingSetTabVerification() {
		NavigateToValidata();

		WebElement MappingSets_tab = createWebElementBy(tab_MappingSets);
		MappingSets_tab.click();

		WebElement MappingSet1_Checkbox = createWebElementBy(chk_MappingSet1);
		MappingSet1_Checkbox.click();

		WebElement MappingSet1_Name = createWebElementBy(lnk_MappingSetName1);
		MappingSet1_Name.click();

		WebElement Records_SubTab = createWebElementBy(subtab_Records);
		Records_SubTab.click();
		takeScreenshotAtEndOfTest();

		WebElement Mappings_SubTab = createWebElementBy(subtab_Mappings);
		Mappings_SubTab.click();
		takeScreenshotAtEndOfTest();

		WebElement Conversions_SubTab = createWebElementBy(subtab_Conversions);
		Conversions_SubTab.click();
		takeScreenshotAtEndOfTest();
	}

	void TM_Validata_S06_Web_ValidationTabVerification() {
		NavigateToValidata();

		WebElement ValidationSets_tab = createWebElementBy(tab_ValidationSets);
		ValidationSets_tab.click();

		takeScreenshotAtEndOfTest();
	}

	void TM_Validata_S08_Web_SeveritySetTabVerification() {
		NavigateToValidata();

		WebElement SeveritySets_tab = createWebElementBy(tab_SeveritySets);
		SeveritySets_tab.click();

		takeScreenshotAtEndOfTest();
	}

	void TM_Validata_S09_Web_DataMangementTabVerification() {
		NavigateToValidata();

		WebElement DataMangement_tab = createWebElementBy(tab_DataManagement);
		mouseHover(DataMangement_tab);
		WebElement AberrantQties_tab = createWebElementBy(tab_AberrantQties);
		AberrantQties_tab.click();

		takeScreenshotAtEndOfTest();
	}

	void TM_Validata_S11_Web_ReportsTabVerification() {
		NavigateToValidata();

		WebElement Reports_tab = createWebElementBy(tab_Reports);
		Reports_tab.click();

		takeScreenshotAtEndOfTest();
	}

	/**************************** Page Interactions Methods ***********************/
	void NavigateToValidata() {
		WebElement Validata_Lnk = createWebElementBy(lnk_Validata);
		Validata_Lnk.click();

		waitForPageLoaded();
	}
}
