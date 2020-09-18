package com.qa.wave3;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class GNet extends CommonMethods {

	/***************************** Test Data *******************/
	//Browser Chrome
	final String Browser = "Chrome";
	// Prod Environment URL
	final String Url = "https://gnethome.gilead.com";
	// Prod Dr Environment URL
	final String Url1 = "https://drgnethome.gilead.com";
	
	// Test Environment URL
	final String Url2 = "https://testgnethome.gilead.com";
	// Test Dr Environment URL
	final String Url3 = "https://drtestgnethome.gilead.com";

	// Sandbox UAT Environment URL
	final String Url4 = "https://sbxgnethome.gilead.com";
	// Dev Environment URL
	final String Url5 = "https://dvignethome.gilead.com";

	/***************************** Test Cases *******************/
	/*
	 * Test case â€˜Test Nameâ€™ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: â€¢ AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, â€¢ TCNumber:
	 * Test case number [Numeric 2-3 digits] i.e, 01, 02,.. â€¢ TestCategory: Test
	 * case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve,
	 * DB â€¦] â€¢ Title: short title of test case based on context of test case
	 * ie., ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails.
	 * 
	 * Test method name must be same as test case appended with TM example:
	 */

	@BeforeMethod(enabled = true)
	public void beforeMethod() {
		launchBrowser(Browser, Url);
	}

	@Test(priority = 0, enabled = false)
	public void GNet_S01_Web_GNet_verifyHomeScreen() {
		TM_GNet_S01_Web_GNet_verifyHomeScreen();

	}
	
	@Test(priority = 1, enabled = true)
	public void GNet_S02_Web_Gnet_Menu_Accesiblity() {
		TM_GCC_S02_Web_GNet_MenuAccesiblity();

	}
	
	@Test(priority = 2, enabled = false)
	public void GNet_S03_Web_Gnet_Menu_Resources() {
		TM_GCC_S03_Web_GNet_Resources();

	}
	
	@Test(priority = 3, enabled = false)
	public void GNet_S04_Web_Gnet_PredictiveSearch() {
		TM_GCC_S04_Web_GNet_PredictiveSearch();

	}
	
	@Test(priority = 4, enabled = true)
	public void GNet_S05_Web_Gnet_CompanyDashboard() {
		TM_GCC_S05_Web_GNet_CompanyDashboard();

	}
	
	@Test(priority = 5, enabled = true)
	public void GNet_S06_Web_Gnet_PressRelease() {
		TM_GCC_S06_Web_GNet_PressRelease();

	}
	@AfterMethod(enabled = true)
	public void afterMethod() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */
	By welcome_Screen = By.xpath("//*[@id='quickLinksSliderContentOuter']");
	By close_popup = By.xpath("//div[@id='quick-start-popup']//a[@class='close'][contains(text(),'Close')]");
	By checkbox_popup = By.xpath("//label[@class='bold']");
	By home = By.xpath("//*[@id='gnetLogoId']");
	By btn_Menu = By.xpath("//*[@id='gnetMainMenu']/a");
	By lnk_BoardDirector = By.xpath("//a[contains(text(),'Board of Directors')]");
	By txt_BoardDirector = By.xpath("//a[contains(text(),'Board of Directors')]");
	
	By lnk_CompanyTimeline = By.xpath("//a[contains(text(),'Company Timeline')]");
	By txt_CompanyTimeline = By.xpath("//div[@class='content-box-in']//div//h2[contains(text(),'Company Timeline')]");
	
	By lnk_CoreValueMission = By.xpath("//a[contains(text(),'Core Values & Mission')]");
	By txt_CoreValueMission = By.cssSelector("div[class$='Content-title'] h1");
	
	By lnk_Departments = By.xpath("//a[contains(text(),'Departments')]");
	By txt_Departments = By.xpath("//h1[contains(text(),'Departments')]");
	
	By lnk_GileadEvents = By.xpath("//a[contains(text(),'Gilead Events')]");
	By txt_GileadEvents = By.xpath("//h1[contains(text(),'Gilead Events')]");
	
	By lnk_GileadOfficeDirectory = By.xpath("//a[contains(text(),'Gilead Office Directory')]");
	By txt_GileadOfficeDirectory = By.xpath("//strong[contains(text(),'Name and Address')]");
	
	By lnk_GileadVPDirectory = By.xpath("//a[contains(text(),'Gilead VP Directory')]");
	By txt_GileadVPDirectory = By.xpath("//h2[contains(text(),'Gilead VP')]");
	
	By lnk_KiteNet = By.xpath("//a[contains(text(),'KiteNet')]");
	By txt_KiteNet = By.xpath("//*[@id='kite_header']");
	
	//By lnk_Leadershipperspective = By.xpath("//div[@class='About']//div//a[contains(text(),'Departments')]");
	//By txt_Leadershipperspective = By.xpath("//div[@class='ERContent-title']//h1[contains(text(),'Gilead Departments')]");
	
	By lnk_Pipeline = By.xpath("//a[contains(text(),'Pipeline')]");
	By txt_Pipeline = By.xpath("//h1[contains(text(),'Pipeline')]");
	
	By lnk_Policies = By.xpath("//a[contains(text(),'Policies')]");
	By txt_Policies = By.xpath("//h1[contains(text(),'Policies Page')]");
	
	By lnk_Products = By.xpath("//a[contains(text(),'Products')]");
	By txt_Products = By.xpath("//span[contains(text(),'Science & Medicine')]");
	
	By lnk_SeniorLeadership = By.xpath("//a[contains(text(),'Senior Leadership')]");
	By txt_SeniorLeadership = By.xpath("//h1[contains(text(),'Leadership')]");
	
	By lnk_Corporatematerial = By.xpath("//a[contains(text(),'Corporate Materials')]");
	By txt_Corporatematerial = By.xpath("//*[@id='ctl00_PlaceHolderMain_Sitemappath1']/span[3]");
	
	By lnk_EmployeeResources = By.xpath("//a[contains(text(),'Employee Resources')]");
	By txt_EmployeeResources = By.xpath("//h2[contains(text(),'Employee Resources Directory')]");
	
	By lnk_EmployeeResourceGroups = By.xpath("//a[contains(text(),'Employee Resource Groups')]");
	By txt_EmployeeResourceGroups = By.xpath("//h1[contains(text(),'Employee Resource Groups')]");
	
	By lnk_GivingTogether = By.xpath("//a[contains(text(),'Giving Together')]");
	By txt_GivingTogether = By.xpath("//div[@class='medical-title']");
	
	//By lnk_Corporatematerial = By.xpath("//div[@class='About']//div//a[contains(text(),'Departments')]");
	//By txt_Corporatematerial = By.xpath("//div[@class='ERContent-title']//h1[contains(text(),'Gilead Departments')]");
	
	By lnk_Search = By.cssSelector("#ctl00_ctl27_SmallSearchInputBox1_csr_sbox");
	By txt_ViewAll = By.xpath("//a[contains(text(),'View All')]");
	By txt_SearchResult = By.xpath("//h2[@class='search-results-title-desktop']//span[contains(text(),'Search Results')]");
	
	By lnk_Ethics = By.xpath("//p[contains(text(),'Ethics & Compliance')]");
	By lnk_Dashboard = By.xpath("//h2[contains(text(),'Company Dashboard')]");
	By txt_Ethics = By.xpath("//div[@class='medical-title']//h1[contains(text(),'Ethics & Compliance')]");
	
	By lnk_PressReleases = By.xpath("//span[contains(text(),'Press Releases')]");
	By lnk_PressReleases1 = By.xpath("//div[@class='gnet-home-cards_list press-releases']//div[1]//div[2]//div[1]//div[1]//span[1]");
	By lnk_Archive = By.xpath("//span[contains(text(),'Archive')]");
	By txt_PressReleases = By.xpath("//span[contains(text(),'News and Press')]");
	

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	
	public void TM_GNet_S01_Web_GNet_verifyHomeScreen() {

		VerifyWelcomePopup();
		VerifyHomeScreen();
		
	}
	
	
	public void TM_GCC_S02_Web_GNet_MenuAccesiblity() {

		VerifyWelcomePopup();
		verifyBoardDirectorScreen();
		verifyCompanyTimeline();
		verifyCoreValueMission();
		verifyDepartments();
		verifyGileadEvents();
		verifyGileadOfficeDirectory();
		verifyGileadVPDirectory();
		//verifyKiteNet(); 
		verifyPipeline(); 
		verifyPolicies();
		verifyProducts();
	}
	
	public void TM_GCC_S03_Web_GNet_Resources() {
		
		VerifyWelcomePopup();
		verifyCorporatematerial();
		verifyEmployeeResources();
		verifyEmployeeResourceGroups();
	}
	
public void TM_GCC_S04_Web_GNet_PredictiveSearch() {
		
		VerifyWelcomePopup();
		VerifyPredictiveSearch();
		
	}

public void TM_GCC_S05_Web_GNet_CompanyDashboard() {
	
	VerifyWelcomePopup();
	VerifyEthics();
	
}
public void TM_GCC_S06_Web_GNet_PressRelease() {
	
	VerifyWelcomePopup();
	VerifyPressReleases();
	
}
//------------------------------------------------------------
	public void VerifyWelcomePopup() {
		waitForPageLoaded();
		wait(5);
		// Closing Welcome popup
		takeScreenshotAtEndOfTest();
		WebElement Welcome_Popup = createWebElementBy(welcome_Screen);
		
		if(Welcome_Popup.isDisplayed())
		{
			WebElement ClickCheckboxPopup = createWebElementBy(checkbox_popup);
			ClickCheckboxPopup.click();
			WebElement ClosePopup = createWebElementBy(close_popup);
			ClosePopup.click();
			wait(3);
			System.out.println("Welcome popup is closed");
		}
		
		else
		{
			System.out.println("Welcome popup is not displayed");
			
		}
		takeScreenshotAtEndOfTest();
		
	}
	
	
	public void VerifyHomeScreen() {
		waitForPageLoaded();
		wait(2);
		WebElement Logo_Home = createWebElementBy(home);
		IsDisplayed_IsEnabled(Logo_Home);
		takeScreenshotAtEndOfTest();
	}

	public void verifyBoardDirectorScreen() {
		
		waitForPageLoaded();
		//scrollToBottomOfHTML();
		WebElement MenuButton = createWebElementBy(btn_Menu);
		MenuButton.click();
		wait(2);
		WebElement BoardDirector = createWebElementBy(lnk_BoardDirector);
		BoardDirector.click();
		waitForPageLoaded();
		wait(2);
		WebElement BoardDirectorScreen = createWebElementBy(txt_BoardDirector);
		IsDisplayed_IsEnabled(BoardDirectorScreen);
		takeScreenshotAtEndOfTest();
		driver.navigate().back();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
	}
public void verifyCompanyTimeline() {
		
		waitForPageLoaded();
		WebElement MenuButton = createWebElementBy(btn_Menu);
		MenuButton.click();
		wait(2);
		WebElement CompanyTimeline = createWebElementBy(lnk_CompanyTimeline);
		CompanyTimeline.click();
		waitForPageLoaded();
		wait(2);
		WebElement CompanyTimelineScreen = createWebElementBy(txt_CompanyTimeline);
		IsDisplayed_IsEnabled(CompanyTimelineScreen);
		takeScreenshotAtEndOfTest();
		driver.navigate().back();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
	}

public void verifyCoreValueMission() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement CoreValueMission = createWebElementBy(lnk_CoreValueMission);
	CoreValueMission.click();
	waitForPageLoaded();
	wait(2);
	WebElement CoreValueMissionScreen = createWebElementBy(txt_CoreValueMission);
	IsDisplayed_IsEnabled(CoreValueMissionScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}

public void verifyDepartments() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement Departments = createWebElementBy(lnk_Departments);
	Departments.click();
	waitForPageLoaded();
	wait(3);
	WebElement DepartmentsScreen = createWebElementBy(txt_Departments);
	IsDisplayed_IsEnabled(DepartmentsScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}

public void verifyGileadVPDirectory() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement GileadVPDirectory = createWebElementBy(lnk_GileadVPDirectory);
	GileadVPDirectory.click();
	waitForPageLoaded();
	wait(2);
	//WebElement GileadVPDirectoryScreen = createWebElementBy(txt_GileadVPDirectory);
	//IsDisplayed_IsEnabled(GileadVPDirectoryScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}

public void verifyGileadOfficeDirectory() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement GileadOfficeDirectory = createWebElementBy(lnk_GileadOfficeDirectory);
	GileadOfficeDirectory.click();
	waitForPageLoaded();
	wait(2);
	WebElement GileadOfficeDirectoryScreen = createWebElementBy(txt_GileadOfficeDirectory);
	IsDisplayed_IsEnabled(GileadOfficeDirectoryScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}

public void verifyGileadEvents() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement GileadEvents = createWebElementBy(lnk_GileadEvents);
	GileadEvents.click();
	waitForPageLoaded();
	wait(2);
	WebElement GileadEventsScreen = createWebElementBy(txt_GileadEvents);
	IsDisplayed_IsEnabled(GileadEventsScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}	

public void verifyKiteNet() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement KiteNet = createWebElementBy(lnk_KiteNet);
	KiteNet.click();
	waitForPageLoaded();
	wait(2);
	WebElement KiteNetScreen = createWebElementBy(txt_KiteNet);
	IsDisplayed_IsEnabled(KiteNetScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}

public void verifyPipeline() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement Pipeline = createWebElementBy(lnk_Pipeline);
	Pipeline.click();
	waitForPageLoaded();
	wait(2);
	WebElement PipelineScreen = createWebElementBy(txt_Pipeline);
	IsDisplayed_IsEnabled(PipelineScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}

public void verifyPolicies() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement Policies = createWebElementBy(lnk_Policies);
	Policies.click();
	waitForPageLoaded();
	wait(2);
	WebElement PoliciesScreen = createWebElementBy(txt_Policies);
	IsDisplayed_IsEnabled(PoliciesScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}

public void verifyProducts() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement Products = createWebElementBy(lnk_Products);
	Products.click();
	waitForPageLoaded();
	wait(2);
	WebElement ProductsScreen = createWebElementBy(txt_Products);
	IsDisplayed_IsEnabled(ProductsScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}

public void verifyCorporatematerial() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement Corporatematerial = createWebElementBy(lnk_Corporatematerial);
	Corporatematerial.click();
	waitForPageLoaded();
	wait(2);
	WebElement CorporatematerialScreen = createWebElementBy(txt_Corporatematerial);
	IsDisplayed_IsEnabled(CorporatematerialScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}

public void verifyEmployeeResources() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement EmployeeResources = createWebElementBy(lnk_EmployeeResources);
	EmployeeResources.click();
	waitForPageLoaded();
	wait(2);
	WebElement EmployeeResourcesScreen = createWebElementBy(txt_EmployeeResources);
	IsDisplayed_IsEnabled(EmployeeResourcesScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}

public void verifyEmployeeResourceGroups() {
	
	waitForPageLoaded();
	WebElement MenuButton = createWebElementBy(btn_Menu);
	MenuButton.click();
	wait(2);
	WebElement EmployeeResourceGroups = createWebElementBy(lnk_EmployeeResourceGroups);
	EmployeeResourceGroups.click();
	waitForPageLoaded();
	wait(2);
	WebElement EmployeeResourceGroupsScreen = createWebElementBy(txt_EmployeeResourceGroups);
	IsDisplayed_IsEnabled(EmployeeResourceGroupsScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}
//Search Result
public void VerifyPredictiveSearch() {
	
	waitForPageLoaded();
	wait(3);
	WebElement Search = createWebElementBy(lnk_Search);
	Search.click();
	wait(2);
	Search.sendKeys("gnet");
	wait(2);
	takeScreenshotAtEndOfTest();
	WebElement ViewAll = createWebElementBy(txt_ViewAll);
	wait(2);
	ViewAll.click();
	wait(2);
	WebElement EmployeeResourceGroupsScreen = createWebElementBy(txt_SearchResult);
	IsDisplayed_IsEnabled(EmployeeResourceGroupsScreen);
	takeScreenshotAtEndOfTest();
	driver.navigate().back();
	waitForPageLoaded();
	takeScreenshotAtEndOfTest();
}
//Dashboard -> CLicking Ethics link 
public void VerifyEthics() {
	
	wait(3);
	Set<String> MainTab = driver.getWindowHandles();
	
	Set<String> Tab = driver.getWindowHandles();
	//String MainTab = driver.getWindowHandles();
	System.out.println("Total tabs before clicking = " +Tab.size());
	
	WebElement Dashboard = createWebElementBy(lnk_Dashboard);
	scrollToWebElement(Dashboard);
	wait(2);
	WebElement Ethics = createWebElementBy(lnk_Ethics);
	Ethics.click();
	takeScreenshotAtEndOfTest();
	
	Tab = driver.getWindowHandles();
	System.out.println("Total tabs after clicking = " +Tab.size());
	
	for(String h : Tab)
	{
		if(!h.equals(MainTab)) {
			//switch to new tab
			driver.switchTo().window(h);
			wait(2);
			takeScreenshotAtEndOfTest();
		}
	}
	WebElement EthicsScreen = createWebElementBy(txt_Ethics);
	IsDisplayed_IsEnabled(EthicsScreen);
	wait(2);
	takeScreenshotAtEndOfTest();
	driver.quit();
	
}
//Veifying Press Release
public void VerifyPressReleases() {
	
	waitForPageLoaded();
	wait(2);
	WebElement PressRelease = createWebElementBy(lnk_PressReleases);
	scrollToWebElement(PressRelease);
	WebElement Pressrelease = createWebElementBy(lnk_PressReleases);
	Pressrelease.click();
	wait(2);
	takeScreenshotAtEndOfTest();
	WebElement PressRelease1 = createWebElementBy(lnk_PressReleases1);
	PressRelease1.click();
	//WebElement Archive = createWebElementBy(lnk_Archive);
	//Archive.click();
	wait(3);
	WebElement PressReleasesScreen = createWebElementBy(txt_PressReleases);
	IsDisplayed_IsEnabled(PressReleasesScreen);
	takeScreenshotAtEndOfTest();
	
}
}