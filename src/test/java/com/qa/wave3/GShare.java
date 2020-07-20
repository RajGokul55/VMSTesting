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
	

	@AfterMethod(enabled = false)
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
