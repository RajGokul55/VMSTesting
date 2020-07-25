package com.qa.wave3;

import java.util.ArrayList;
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

public class DVP extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	String pageTitle;
	final String username="dvp_vms_ro";
	final String admin="admin";
	private String DecrptPassword;
	public String EncryptPassword;
	
	// URL for DVP, need to update for below three interfaces url:
	final String url_InformationService = "http://sjdvpappdevg01:9090/information-self-service-tool/Login";
	final String url_SchedulerAdmin="http://sjdvpappdevg01:9090/webadmin/denodo-scheduler-admin";
	final String url_DiagnosticMonitoring="http://sjdvpappdevg01:9090/diagnostic-monitoring-tool/Login";
	
	// run time URLs for verification
	
	
	
	

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

	@BeforeMethod
	public void Initialization() {
		 
		 if(url_InformationService.contains("valg")) {
			 EncryptPassword="28nf36mo3JKJwasYGfrv8w==";
		 }
		 else if (url_InformationService.contains("prdg")) {
			 EncryptPassword= "UtdG7flCIQzskcD/r3/8UA==";
		}
		 else {
			 EncryptPassword = "H6QzhTK2ALgB/Myb1TAIYw==";
		}
		
	}

	@Test(priority = 1, enabled = true)
	public void DVP_S01_Web_VerifyInformationService() {
		TM_DVP_S01_Web_VerifyInformationService();
	}
	@Test(priority = 2, enabled = true)
	public void DVP_S02_Web_ENTDatabaseView() {
		TM_DVP_S02_Web_ENTDatabaseView();
	}
	@Test(priority = 3, enabled = true)
	public void DVP_S03_Web_PDMDatabaseView() {
		TM_DVP_S03_Web_PDMDatabaseView();
	}
	@Test(priority = 4, enabled = true)
	public void DVP_S04_Web_VerifySchedulerWebAdmin() {
		TM_DVP_S04_Web_VerifySchedulerWebAdmin();
	}
	@Test(priority = 5, enabled = true)
	public void DVP_S05_Web_VerifyDiagnosticMontioringTool() {
		TM_DVP_S05_Web_VerifyDiagnosticMontioringTool();
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

	By username_informationService= By.id("userName");
	By password_informationService= By.xpath("//input[@name='password']");
	By btn_loginInformationService=By.cssSelector(".ui-button-text");
	By lnk_databases=By.xpath("(//span[@class='ui-accordion-header-icon'])[1]");
	By database_ENT=By.xpath("//div[@title='ent']");
	By database_PDM=By.xpath("//div[@title='pdm']");
	By databaseTabs=By.cssSelector(".ui-tabs-anchor");
	By businessView=By.xpath("//*[text()='business views']");
	By baseView=By.xpath("//*[text()='base views']");
	By gvault=By.xpath("//*[text()='gvault']");
	By link_gtrack_gplm_supplier_vw=By.linkText("gtrack_gplm_supplier_vw");
	By link_bv_veeva_auth_vw=By.linkText("bv_veeva_auth_vw");
	By view_fieldName=  By.cssSelector(".jtable .jtable-data-row td:nth-child(1)");
	
	//Scheduler
	By verifpage=By.cssSelector("[id='related-box'] h1");
	By admin_username=By.cssSelector("[name='loginInput']");
	By admin_password=By.cssSelector("[name='passwordInput']");
	By admin_accept =By.cssSelector(".action-button");
	By action_connectLink= By.xpath("//span[text()='Connect']");
	
	//Diagnostic Monitoring tool
	By id_Username= By.id("userName");
	By id_password= By.id("password");
	By loginButton=By.cssSelector(".ui-button-text");
	
	
	
	
	


	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	public void loginInformationService() {
		try {
			DecrptPassword = decrypt(EncryptPassword);
			WebElement username_Is = createWebElementBy(username_informationService);
			username_Is.sendKeys(username);
			WebElement password = createWebElementBy(password_informationService);
			password.sendKeys(DecrptPassword);
			
			WebElement signInbutton=createWebElementBy(btn_loginInformationService);
			signInbutton.click();
			waitForPageLoaded();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void loginSchedulerAdmin() {
		try {
			DecrptPassword = decrypt(EncryptPassword);
			WebElement username_scheduler = createWebElementBy(admin_username);
			username_scheduler.sendKeys(username);
			WebElement password = createWebElementBy(admin_password);
			password.sendKeys(DecrptPassword);
			
			WebElement signInbutton=createWebElementBy(admin_accept);
			signInbutton.click();
			waitForPageLoaded();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loginDiagnosticMonitoring() {
		try {
			DecrptPassword = decrypt(EncryptPassword);
			WebElement username_diagnostic = createWebElementBy(id_Username);
			username_diagnostic.sendKeys(username);
			WebElement password = createWebElementBy(id_password);
			password.sendKeys(DecrptPassword);
			
			WebElement signInbutton=createWebElementBy(loginButton);
			signInbutton.click();
			waitForPageLoaded();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	


	public void TM_DVP_S01_Web_VerifyInformationService() {
		launchBrowser(Browser, url_InformationService);
		loginInformationService();
		 pageTitle=getTitle();
		Assert.assertEquals(pageTitle, "Denodo Information Self-Service Tool");
		takeScreenshotAtEndOfTest();
			
	}
	public void TM_DVP_S02_Web_ENTDatabaseView() {
		launchBrowser(Browser, url_InformationService);
		loginInformationService();
		WebElement databases= createWebElementBy(lnk_databases);
		databases.click();
		WebElement entDatabase= createWebElementBy(database_ENT);
		entDatabase.click();
		waitForPageLoaded();
		wait(5);
		List<WebElement> entdatabaseTabs= createWebElementsBy(databaseTabs);
		Assert.assertEquals(entdatabaseTabs.get(0).getText(), "Summary");
		Assert.assertEquals(entdatabaseTabs.get(1).getText(), "Associations");
		Assert.assertEquals(entdatabaseTabs.get(3).getText(), "Metadata Search");
		Assert.assertEquals(entdatabaseTabs.get(5).getText(), "Connect");
		entdatabaseTabs.get(4).click();
		waitForPageLoaded();
		WebElement businessViewEnt= createWebElementBy(businessView);
		doubleClick(businessViewEnt);
		WebElement gtractView= createWebElementBy(link_gtrack_gplm_supplier_vw);
		gtractView.click();
		waitForPageLoaded();
		wait(3);
		List<WebElement> fieldElementsENT= createWebElementsBy(view_fieldName);
		
		waitForPageLoaded();
		Assert.assertEquals(fieldElementsENT.get(0).getText(), "PR_ID");
		Assert.assertEquals(fieldElementsENT.get(1).getText(), "SUPPLIER_NAME");
		Assert.assertEquals(fieldElementsENT.get(2).getText(), "SUPPLIER_RATING");
		Assert.assertEquals(fieldElementsENT.get(3).getText(), "LAST_AUDIT_DATE");
		Assert.assertEquals(fieldElementsENT.get(4).getText(), "SUPP_RAT_CHANGEDON");
		Assert.assertEquals(fieldElementsENT.get(5).getText(), "sourcesystemname");
		takeScreenshotAtEndOfTest();
		
		
		
		
	}
	public void TM_DVP_S03_Web_PDMDatabaseView() {
		launchBrowser(Browser, url_InformationService);
		loginInformationService();
		WebElement databases= createWebElementBy(lnk_databases);
		databases.click();
		WebElement pdmDatabase= createWebElementBy(database_PDM);
		pdmDatabase.click();
		waitForPageLoaded();
		wait(5);
		List<WebElement> pdmdatabaseTabs= createWebElementsBy(databaseTabs);
		Assert.assertEquals(pdmdatabaseTabs.get(0).getText(), "Summary");
		Assert.assertEquals(pdmdatabaseTabs.get(1).getText(), "Associations");
		Assert.assertEquals(pdmdatabaseTabs.get(3).getText(), "Metadata Search");
		Assert.assertEquals(pdmdatabaseTabs.get(5).getText(), "Connect");
		pdmdatabaseTabs.get(4).click();
		waitForPageLoaded();
		WebElement baseviewsEnt= createWebElementBy(baseView);
		doubleClick(baseviewsEnt);
		WebElement gvaultDb= createWebElementBy(gvault);
		doubleClick(gvaultDb);
		WebElement veevaAuthView= createWebElementBy(link_bv_veeva_auth_vw);
		veevaAuthView.click();
		waitForPageLoaded();
		
		List<WebElement> fieldElementsPDM= createWebElementsBy(view_fieldName);
		
		Assert.assertEquals(fieldElementsPDM.get(0).getText(), "responsestatus");
		Assert.assertEquals(fieldElementsPDM.get(1).getText(), "sessionid");
		Assert.assertEquals(fieldElementsPDM.get(2).getText(), "userid");
		Assert.assertEquals(fieldElementsPDM.get(3).getText(), "vaultids");
		Assert.assertEquals(fieldElementsPDM.get(4).getText(), "vaultid");
		
		takeScreenshotAtEndOfTest();	

	}
	
	public void TM_DVP_S04_Web_VerifySchedulerWebAdmin() {
		launchBrowser(Browser, url_SchedulerAdmin);
		pageTitle= driver.getTitle();
		Assert.assertEquals(pageTitle, "Scheduler Administration Tool");
		WebElement page= createWebElementBy(verifpage);
		Assert.assertEquals(page.getText(), "Authentication Page");
		
		WebElement adminUser = createWebElementBy(admin_username);
		adminUser.sendKeys(admin);
		WebElement adminPassword = createWebElementBy(admin_password);
		adminPassword.sendKeys(admin);
		WebElement acceptButton = createWebElementBy(admin_accept);
		acceptButton.click();
		waitForPageLoaded();
		WebElement pageServer= createWebElementBy(verifpage);
		Assert.assertEquals(pageServer.getText(), "Servers list");
		WebElement connectLink=createWebElementBy(action_connectLink);
		IsDisplayed_IsEnabled(connectLink);
		connectLink.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		loginSchedulerAdmin();
		takeScreenshotAtEndOfTest();
		
	}
	public void TM_DVP_S05_Web_VerifyDiagnosticMontioringTool() {
		launchBrowser(Browser, url_DiagnosticMonitoring);
		loginDiagnosticMonitoring();
		takeScreenshotAtEndOfTest();
		
		
		
		
	}
	
	}


	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here


