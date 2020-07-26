package com.qa.wave3;

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

public class GDV extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String username = "abhatt2";
	String pageTitle;
	private String DecrptPassword;
	String EncryptPassword = "nUwyGJG2cT7AgFQqaNE29g==";
	// String EncryptPassword = "FkOllRi0iO/rIlftff/AwA==";
	// URL for Fc vision:
	final String catalog_url = "http://sjgdvappprdn01:9100/denodo-data-catalog/Login";
	final String scheduler_url = "http://sjgdvappprdn01:9100/webadmin/denodo-scheduler-admin";

	/***************************** Test Cases *******************/

	/*
	 * URLs- Catalog 
	 * DEV http://sjgdvappdevn01:9090/denodo-data-catalog/Login
	 * SQA http://sjgdvappsqan01:9090/denodo-data-catalog/Login
	 * UAT http://sjgdvappuatn01:9100/denodo-data-catalog/Login
	 * UAT http://sjgdvappuatn02:9100/denodo-data-catalog/Login
	 * PRD http://sjgdvappprdn01:9100/denodo-data-catalog/Login
	 * PRD http://sjgdvappprdn02:9100/denodo-data-catalog/Login
	 */
	/*
	 * Scheduler urls
	 *  DEV http://sjgdvappdevn01:9090/webadmin/denodo-scheduler-admin
	 * SQA http://sjgdvappsqan01:9090/webadmin/denodo-scheduler-admin
	 * UAT http://sjgdvappuatn01:9100/webadmin/denodo-scheduler-admin 
	 * UAT http://sjgdvappuatn02:9100/webadmin/denodo-scheduler-admin
	 * PRD http://sjgdvappprdn01:9100/webadmin/denodo-scheduler-admin 
	 * PRD http://sjgdvappprdn02:9100/webadmin/denodo-scheduler-admin
	 */

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

	@Test(priority = 1, enabled = true)
	public void GDV_S01_Web_VerifyDataCatalog() {
		logincatalog();
		TM_GDV_S01_Web_VerifyDataCatalog();
	}

	@Test(priority = 2, enabled = true)
	public void GDV_S02_Web_VerifyENTDatabasequery() {
		logincatalog();
		TM_GDV_S02_Web_VerifyENTDatabasequery();
	}

	@Test(priority = 3, enabled = true)
	public void GDV_S03_Web_VerifySchedulerServerList() {
		TM_GDV_S03_Web_VerifySchedulerServerList();
	}

	@Test(priority = 4, enabled = true)
	public void GDV_S04_Web_VerifySchedulerJobsPage() {
		TM_GDV_S04_Web_VerifySchedulerJobsPage();
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
	By welcome_message = By.xpath("(//span[contains(@class,'caption-subject')])[1]");
	By id_SearchInputBox = By.id("isst-homesearch-input");
	By autoalertConfirmation = By.xpath("//strong/*[@face=\"Arial\"]");
	By id_username = By.id("userName");
	By id_password = By.cssSelector("[name='password']");
	By id_databaseServer = By.id("server-select");
	By database_ENT = By.xpath("//option[contains(text(),'ENT') or contains(text(),'ent')]");
	By btn_catalogLogin = By.cssSelector(".button-login");
	By drpdown_browse = By.xpath("(//span[@class='sub-arrow'])[1]");
	By dbFolder = By.cssSelector("[id='browseDBFoldersSection'] a");
	By input_searchDB = By.id("isst-dbfolders-search-input");
	By btn_searchDBbutton = By.cssSelector("[id='isst-dbfolders-search-button'] svg");
	By currencyExchangeDB = By.cssSelector("[title='currency_exchange_rate_vw']");
	By lnk_query = By.linkText("Query");
	By fromCurrency = By.cssSelector("[title='from_currency']");
	By toCurrency = By.cssSelector("[title='to_currency']");
	By conversionType = By.cssSelector("[title='conversion_type']");
	By numberOfRecords = By.cssSelector("[title='NUMBER_OF_RECORDS']");
	By outputColumn = By.id("view-query-right-component-outputs-list");
	By runQuery = By.id("new-query-button");
	By queryResultColumn1 = By.cssSelector(".view-query-table thead tr th:nth-child(2)");
	By queryResultColumn2 = By.cssSelector(".view-query-table thead tr th:nth-child(3)");
	By queryResultColumn3 = By.cssSelector(".view-query-table thead tr th:nth-child(4)");
	By queryResultColumn4 = By.cssSelector(".view-query-table thead tr th:nth-child(5)");

	// Scheduler
	By serverName = By.xpath("(//td[@class='table-text'])[2]");
	By hostName = By.xpath("(//td[@class='table-text'])[3]");
	By portNumber = By.xpath("(//td[@class='table-text'])[4]");
	By lnk_connect = By.cssSelector(".navigation-link div");
	By username_scheduler = By.xpath("//input[@name='loginInput']");
	By Password_scheduler = By.xpath("//input[@name='passwordInput']");
	By loginButton_scheduler = By.xpath("//input[@value='Accept']");

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void logincatalog() {
		launchBrowser(Browser, catalog_url);
		try {
			DecrptPassword = decrypt(EncryptPassword);

			WebElement username_catlog = createWebElementBy(id_username);
			username_catlog.sendKeys(username);
			WebElement password = createWebElementBy(id_password);
			password.sendKeys(DecrptPassword);
			WebElement database = createWebElementBy(id_databaseServer);
			database.click();
			WebElement entDatabase = createWebElementBy(database_ENT);
			entDatabase.click();

			WebElement signInbutton = createWebElementBy(btn_catalogLogin);
			signInbutton.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void loginScheduler() {
		try {
			DecrptPassword = decrypt(EncryptPassword);
			WebElement usernamescheduler = createWebElementBy(username_scheduler);
			usernamescheduler.sendKeys(username);
			WebElement password = createWebElementBy(Password_scheduler);
			password.sendKeys(DecrptPassword);
			WebElement loginInbutton = createWebElementBy(loginButton_scheduler);
			loginInbutton.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void TM_GDV_S02_Web_VerifyENTDatabasequery() {

		WebElement hoverBrowse = createWebElementBy(drpdown_browse);
		mouseHover(hoverBrowse);
		waitForPageLoaded();
		WebElement dBFolder = createWebElementBy(dbFolder);
		dBFolder.click();
		waitForPageLoaded();
		WebElement inputDbname = createWebElementBy(input_searchDB);
		inputDbname.sendKeys("Currency");
		WebElement searchButton = createWebElementBy(btn_searchDBbutton);
		searchButton.click();
		waitForPageLoaded();
		WebElement currencyExchangeDb = createWebElementBy(currencyExchangeDB);
		currencyExchangeDb.click();
		waitForPageLoaded();
		WebElement query = createWebElementBy(lnk_query);
		query.click();

		WebElement fromm_currency = createWebElementBy(fromCurrency);
		WebElement target = createWebElementBy(outputColumn);
		dragAndDrop(fromm_currency, target);

		WebElement to_currency = createWebElementBy(toCurrency);
		dragAndDrop(to_currency, target);

		WebElement conversion_type = createWebElementBy(conversionType);
		dragAndDrop(conversion_type, target);

		WebElement numberOf_records = createWebElementBy(numberOfRecords);
		dragAndDrop(numberOf_records, target);
		waitForPageLoaded();

		WebElement runQueryButton = createWebElementBy(runQuery);
		runQueryButton.click();
		waitForPageLoaded();

		WebElement queryFirstColumn = createWebElementBy(queryResultColumn1);
		WebElement querySecondColumn = createWebElementBy(queryResultColumn2);
		WebElement queryThirdColumn = createWebElementBy(queryResultColumn3);
		WebElement queryFourthColumn = createWebElementBy(queryResultColumn4);

		Assert.assertEquals(queryFirstColumn.getText(), "from_currency");
		Assert.assertEquals(querySecondColumn.getText(), "to_currency");
		Assert.assertEquals(queryThirdColumn.getText(), "conversion_type");
		Assert.assertEquals(queryFourthColumn.getText(), "NUMBER_OF_RECORDS");
		takeScreenshotAtEndOfTest();

	}

	public void TM_GDV_S01_Web_VerifyDataCatalog() {
		pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Denodo Data Catalog");
		WebElement welcomeMessage = createWebElementBy(welcome_message);
		Assert.assertEquals(welcomeMessage.getText(), "WELCOME TO DENODO DATA CATALOG");
		WebElement searchTextBox = createWebElementBy(id_SearchInputBox);
		IsDisplayed_IsEnabled(searchTextBox);
		takeScreenshotAtEndOfTest();

	}

	public void TM_GDV_S03_Web_VerifySchedulerServerList() {
		launchBrowser(Browser, scheduler_url);
		String servername = createWebElementBy(serverName).getText();
		String hostname = createWebElementBy(hostName).getText();
		String portnumber = createWebElementBy(portNumber).getText();
		Assert.assertEquals(servername, "SCHEDULER SERVER");
		Assert.assertEquals(hostname, "localhost");
		Assert.assertEquals(portnumber, "8000");
		takeScreenshotAtEndOfTest();

	}

	public void TM_GDV_S04_Web_VerifySchedulerJobsPage() {
		launchBrowser(Browser, scheduler_url);
		waitForPageLoaded();
		WebElement connectButton = createWebElementBy(lnk_connect);
		connectButton.click();
		waitForPageLoaded();
		loginScheduler();
		takeScreenshotAtEndOfTest();

	}

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
