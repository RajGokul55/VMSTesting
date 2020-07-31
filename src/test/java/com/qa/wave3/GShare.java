package com.qa.wave3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class GShare extends CommonMethods {

	/***************************** Test Data *******************/
	String Browser = "IE";
	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\SiKuli\\";
	String username ="NA\\Gnettestse01";
	String password = "gilead01";

	String URL1= "https://drcollaborate.gilead.com/sites/QA/_layouts/closeConnection.aspx?loginasanotheruser=true";
	String URL2= "https://testcollaborate.gilead.com";
	String URL3= "https://sbxcollaborate.gilead.com/sites/QA/_layouts/closeConnection.aspx?loginasanotheruser=true";
	String URL4= "https://dvicollaborate.gilead.com/sites/QA/_layouts/closeConnection.aspx?loginasanotheruser=true";
	String URL5 = "https://drtestgnethome.gilead.com";
	//String URL5 = "https://drtestgnethome.gilead.com/sites/QA/_layouts/closeConnection.aspx?loginasanotheruser=true";
	//String URL2 = "https://testcollaborate.gilead.com/sites/QA/_layouts/closeConnection.aspx?loginasanotheruser=true";	
	String URL= URL2;

	/***************************** Test Cases *******************/

	@BeforeMethod(enabled = true)
	public void BeforeMethod() {
		System.out.println("Before running Test we should manually run and save credentails..!");
		launchBrowser(Browser, URL);
	}

	@Test(priority = 0, enabled = true)
	public void GShare_S01_Web_URL_Accessibility(){
		TM_GShare_S01_Web_URL_Accessibility();
	}

	@Test(priority = 1, enabled = true)
	public void GShare_S02_Web_FolderCreation(){
		TM_GShare_S01_Web_FolderCreation();
	}

	@Test(priority = 2, enabled = true)
	public void GShare_S03_Web_WordCreation(){
		TM_GShare_S03_Web_WordCreation();
	}

	@Test(priority = 4, enabled = true)
	public void GShare_S05_Web_ExcelCreation(){
		TM_GShare_S05_Web_ExcelCreation();
	}

	@Test(priority = 5, enabled = true)
	public void Gshare_S09_Web_Verify_AboutGilead(){
		TM_Gshare_S09_Web_Verify_AboutGilead();
	}
	@Test(priority = 6, enabled = true)
	public void Gshare_S10_Web_VerifyResouceWebElement(){
		TM_Gshare_S10_Web_VerifyResouceWebElement();
	}
	@Test(priority = 7, enabled = true)
	public void Gshare_S11_Web_VerifyFooterWebElement(){
		TM_Gshare_S11_Web_VerifyFooterWebElement();
	}
	@Test(priority = 8, enabled = true)
	public void Gshare_S12_Web_VerifySearchFunctionality(){
		TM_Gshare_S12_Web_VerifySearchFunctionality();
	}
	@Test(priority = 9, enabled = true)
	public void Gshare_S13_VerifyWorldClock(){
		TM_Gshare_S13_VerifyWorldClock();
	}

	@AfterMethod(enabled = true)
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	By icon_Setting = By.cssSelector("span[class='ms-siteactions-imgspan']");
	By menu_List = By.cssSelector("ul[class='ms-core-menu-list'] li"); 
	By icon_Docs = By.cssSelector("div a[title='Documents']");
	By new_Excel = By.cssSelector("h3[id='js-newdocWOPI-divExcel-txt-WPQ2']");  
	By new_Word = By.cssSelector("h3[id='js-newdocWOPI-divWord-txt-WPQ2']");
	By new_PPT = By.cssSelector("h3[id='js-newdocWOPI-divPowerPoint-txt-WPQ2");
	By new_OneNote = By.cssSelector("h3[id='js-newdocWOPI-divOneNote-txt-WPQ2']");
	By new_Folder = By.cssSelector("h3[id='js-newdocWOPI-divFolder-txt-WPQ2']");
	By upload_File = By.cssSelector("span a[class= 'ms-calloutLink ms-calloutLinkEnabled'");
	By add_NewDoc = By.cssSelector("a[title='Add a new item to this list or library.']");
	By ipt_DocName = By.cssSelector("input[title='Document Name'");
	By ipt_FolderName = By.cssSelector("input[title='Name Required Field'");
	By btn_Ok = By.cssSelector("input[type='button'][value='OK']");
	By btn_Save = By.cssSelector("input[type='submit'][value='Save']");

	By form_New = By.cssSelector("iframe[class='ms-dlgFrame']");
	By AboutGilead = By.cssSelector("header[id='minimalHeader'] ul[class='first-level'] li[class='drop-about']:nth-child(3)");
	By Resources = By.cssSelector("header[id='minimalHeader'] ul[class='first-level'] li[class='drop-about']:nth-child(4)");
	By MainSearchIcon = By.cssSelector("a[class='search-btn']");

	By inputSearch = By.cssSelector("input[value='Search All GShare']");
	By iConSearch = By.cssSelector("a[title='Search']");
	By searchResult = By.cssSelector("span[class='document-title'] strong");
	By siteTime = By.cssSelector("div[class='site-time-info']:nth-child(1) div[class='top-section']");
	By Location5 = By.cssSelector("ul[class='collapse collapseLocation locations-ul']>li:nth-child(5)>a>span");
	By Location1 = By.cssSelector("ul[class='collapse collapseLocation locations-ul']>li:nth-child(1)>a>span");
	By drop_Location = By.cssSelector("div[id='currentCity']");
	By locationHour = By.cssSelector("span[id='currentLocationHour']");
	By footerAbout =By.cssSelector("footer[id='mainFooter'] div[class='About']");
	By footerResources = By.cssSelector("footer[id='mainFooter'] div[class='Resources']"); //a

	/***************************** Test Case Methods *******************/

	public void TM_GShare_S01_Web_URL_Accessibility() {
		WebElement setting_Icon = createWebElementBy(icon_Setting);
		IsDisplayed_IsEnabled(setting_Icon);

		takeScreenshotAtEndOfTest();

	}

	void TM_GShare_S01_Web_FolderCreation() {
		NavigatetoAddNewOptions();

		WebElement NewFolder_Create = createWebElementBy(new_Folder);
		NewFolder_Create.click();

		WebElement iframe = createWebElementBy(form_New);
		switchToFrameByLocator(iframe);

		WebElement EnterFolderName = createWebElementBy(ipt_FolderName);
		EnterFolderName.sendKeys("AutoNew");

		WebElement Save_Btn = createWebElementBy(btn_Save);

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Save_Btn);

		takeScreenshotAtEndOfTest();

	}

	void TM_GShare_S03_Web_WordCreation() {
		NavigatetoAddNewOptions();

		WebElement NewWord_Create = createWebElementBy(new_Word);
		NewWord_Create.click();

		WebElement iframe = createWebElementBy(form_New);
		switchToFrameByLocator(iframe);

		WebElement EnterWordName = createWebElementBy(ipt_DocName);
		EnterWordName.sendKeys("AutoNewWord");

		WebElement Ok_Btn = createWebElementBy(btn_Ok);

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Ok_Btn);

		wait(5);
		takeScreenshotAtEndOfTest();

	}

	void TM_GShare_S05_Web_ExcelCreation() {
		NavigatetoAddNewOptions();
		WebElement NewExcel_Create = createWebElementBy(new_Excel);
		NewExcel_Create.click();

		WebElement iframe = createWebElementBy(form_New);
		switchToFrameByLocator(iframe);

		WebElement EnterWordName = createWebElementBy(ipt_DocName);
		EnterWordName.sendKeys("AutoNewExcel");

		WebElement Ok_Btn = createWebElementBy(btn_Ok);

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Ok_Btn);

		wait(5);
		takeScreenshotAtEndOfTest();	
	}

	void TM_Gshare_S09_Web_Verify_AboutGilead() {
		WebElement About_Tab = createWebElementBy(AboutGilead);
		IsDisplayed_IsEnabled(About_Tab);
		mouseHover(About_Tab);

		takeScreenshotAtEndOfTest();	
	}

	void TM_Gshare_S10_Web_VerifyResouceWebElement(){
		WebElement Resources_Tab = createWebElementBy(Resources);
		IsDisplayed_IsEnabled(Resources_Tab);
		mouseHover(Resources_Tab);

		takeScreenshotAtEndOfTest();
	}

	void TM_Gshare_S11_Web_VerifyFooterWebElement(){
		scrollToBottomOfHTML();

		WebElement About_Footer = createWebElementBy(footerAbout);
		IsDisplayed_IsEnabled(About_Footer);

		scrollToWebElement(About_Footer);

		WebElement Resources_Footer = createWebElementBy(footerResources);
		IsDisplayed_IsEnabled(Resources_Footer);

		takeScreenshotAtEndOfTest();
	}

	void TM_Gshare_S12_Web_VerifySearchFunctionality(){
		WebElement Search_Input = createWebElementBy(inputSearch);
		Search_Input.sendKeys("GVault");

		WebElement Search_Icon = createWebElementBy(iConSearch);
		Search_Icon.click();
		
		waitForPageLoaded();
		
		WebElement Search_Result = createWebElementBy(searchResult);
		Assert.assertEquals(Search_Result.getText(), "GVault");

		takeScreenshotAtEndOfTest();
	}

	void TM_Gshare_S13_VerifyWorldClock() {
	
		WebElement Site_Time = createWebElementBy(siteTime);
		Site_Time.click();
		WebElement Location_Dropdown = createWebElementBy(drop_Location);
		Location_Dropdown.click();
		
		WebElement Location_1st = createWebElementBy(Location1);
		Location_1st.click();
		
		WebElement Default_Hour = createWebElementBy(locationHour);
		Default_Hour.getText();
		
		String DefaultHour = Default_Hour.getText();
		
		WebElement Location_Dropdow = createWebElementBy(drop_Location);
		Location_Dropdow.click();
		
		WebElement Location_5th = createWebElementBy(Location5);
		Location_5th.click();
		
		WebElement Updated_Hour = createWebElementBy(locationHour);
		Updated_Hour.getText();
		
		Assert.assertNotEquals(DefaultHour, Updated_Hour.getText());
				
		takeScreenshotAtEndOfTest();
	}
	void NavigatetoAddNewOptions() {

		WebElement setting_Icon = createWebElementBy(icon_Setting);
		setting_Icon.click();

		List<WebElement> MenuList = createWebElementsBy(menu_List);
		for(WebElement menu:MenuList) {
			if(menu.getText().equalsIgnoreCase("Site contents")) {
				menu.click();
				break;
			}
			//System.out.println(menu.getText());
		}

		WebElement Docs_icon = createWebElementBy(icon_Docs);
		Docs_icon.click();
		waitForPageLoaded();

		WebElement NewDoc_Add = createWebElementBy(add_NewDoc);
		NewDoc_Add.click();
	}
}
