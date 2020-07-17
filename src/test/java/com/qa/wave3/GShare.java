package com.qa.wave3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
	//String URL5 = "https://drtestgnethome.gilead.com/home/_layouts/closeConnection.aspx?loginasanotheruser=true";
	String URL= URL5;
	
	/***************************** Test Cases *******************/

	@BeforeMethod(enabled = true)
	public void Beforetest() {
		System.out.println("Before running Test we should manually run and save credentails..!");
		
	}

	@Test(priority = 0, enabled = true)
	public void GShare_S01_Web_URL_Accessibility(){
		TM_GShare_S01_Web_URL_Accessibility();
	}

	@Test(priority = 1, enabled = true)
	public void GShare_S01_Web_FolderCreation(){
		TM_GShare_S01_Web_FolderCreation();
	}
	
		
	@AfterTest(enabled = true)
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	By icon_Setting = By.cssSelector("span[class='ms-siteactions-imgspan']");
	By menu_List = By.cssSelector("ul[class='ms-core-menu-list'] li"); 
	By icon_Docs = By.cssSelector("div a[title='Documents']");
	

	/***************************** Test Case Methods *******************/
	
	public void TM_GShare_S01_Web_URL_Accessibility() {
		//EnterCredentails();
		launchBrowser(Browser, URL);
		takeScreenshotAtEndOfTest();
	/*	driver.quit();
		
		launchBrowser(Browser, URL2);
		takeScreenshotAtEndOfTest();
		driver.quit();
		
		launchBrowser(Browser, URL3);
		takeScreenshotAtEndOfTest();
		driver.quit();
		
		launchBrowser(Browser, URL4);
		takeScreenshotAtEndOfTest();
		driver.quit();
		
		launchBrowser(Browser, URL5);
		takeScreenshotAtEndOfTest();
		driver.quit();
		*/
	}
		
	void TM_GShare_S01_Web_FolderCreation() {
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
		
		takeScreenshotAtEndOfTest();
		
	}

	public void launchBrowserInCognito(String browser, String url) {
		final String userDirectory = System.getProperty("user.dir");

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					userDirectory + "\\src\\main\\java\\com\\qa\\demo\\config\\chromedriver_v78.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(options);
			
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					userDirectory + "\\src\\main\\java\\com\\qa\\demo\\config\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.gecko.driver",
					userDirectory + "\\src\\main\\java\\com\\qa\\demo\\config\\GeckoDriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().alert();

		//Selenium-WebDriver Java Code for entering Username & Password as below:
		driver.switchTo().alert();
		driver.findElement(By.id("username")).sendKeys("userName");
		driver.findElement(By.id("password")).sendKeys("myPassword");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	
	
void EnterCredentails() {
	Screen s = new Screen();
	Pattern IEBrowser = new Pattern(path + "CR_IEBrowserIcon.PNG");
	Pattern EnterURL = new Pattern(path + "CR_EnterURL.PNG"); 
	Pattern FileUsername = new Pattern(path + "GS_Username.PNG");
	Pattern FiledPassword = new Pattern(path + "GS_Password.PNG"); 
	Pattern OkButton = new Pattern(path + "GS_OkBtn.PNG");
	
	try {
		s.type("d", Key.WIN);
		wait(3);
		
		s.wait(IEBrowser, 20);
		
		s.doubleClick(IEBrowser);
		wait(3);
		s.type(Key.SPACE, KeyModifier.ALT);
		wait(2);
		s.type("x");
		wait(3);
		s.type(EnterURL, URL2);
		wait(3);
		s.type(Key.ENTER);
		wait(15);
				
		s.wait(FileUsername, 20);
		s.type(FileUsername, username);
		wait(3);
		s.type(FiledPassword, password);
		wait(3);
		s.type(Key.ENTER);
		
		s.click(OkButton);
		wait(3);
		 
	} catch (FindFailed e) {
		e.printStackTrace();
	}

}
protected boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
