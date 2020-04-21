package com.qa.demo.base;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.Reporter;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CommonMethods {
	private static final String userDirectory = System.getProperty("user.dir");;
	public static WebDriver driver;



	public void launchBrowser(String browser, String url) {

		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",userDirectory+"\\src\\main\\java\\com\\qa\\demo\\config\\chromedriver_v78.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver",userDirectory+"\\src\\main\\java\\com\\qa\\demo\\config\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else {
			System.setProperty("webdriver.gecko.driver",userDirectory+"\\src\\main\\java\\com\\qa\\demo\\config\\GeckoDriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}




	public  WebElement createWebElementBy(By locator) {
		/* 
		 * Author: Balajee Palle
		 * Description: To create web Element by passing locator.
		 * Parameter: Xpath or Css Syntax example: 
		 * Date: April 2020 
		 * 
		 */
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element =  driver.findElement(locator);
		Reporter.log("Mouse Control is on "+locator.toString() +" on Web App URL: "+driver.getCurrentUrl() );
		highLightElement(element);
		return element;
	}

	public  List<WebElement> createWebElementsBy(By locator) {
		/* 
		 * Author: Balajee Palle
		 * Description: To create web Elements by passing locator.
		 * Parameter: Xpath or Css Syntax example: 
		 * Date: April 2020 
		 * 
		 */
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		List<WebElement> elements =  driver.findElements(locator);
		return elements;
	}

	public void highLightElement(WebElement element){
		/* 
		 * Author: Balajee Palle
		 * Description: To highlight the web Element
		 * Parameter: WebElement
		 * Date: April 2020
		 */
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px red')", element); 
		wait(1);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element); 
	}

	public void wait(int sec) {
		/* 
		 * Author: Balajee Palle
		 * Description: Hard wait
		 * Parameter: Time in seconds but never use >5 
		 * Date: April 2020 
		 * 
		 */
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForPageLoaded() {
		/* 
		 * Author: Balajee Palle
		 * Description: Waits for page load
		 * Parameter: 
		 * Date: April 2020 
		 * 
		 */
		ExpectedCondition<Boolean> expectation = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		try {
			wait(2);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}


	public void mouseHover(WebElement element) {
		/* 
		 * Author: Balajee Palle
		 * Description: to do mouse hover on element
		 * Parameter: WebElement
		 * Date: April 2020 
		 * 
		 */
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void domClick(WebElement element){
		/* 
		 * Author: Balajee Palle
		 * Description: to do safe click on element
		 * Parameter: WebElement
		 * Date: April 2020 
		 * 
		 */
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
	/*************************************************************************/
	/* 
	 * Author: Balajee Palle
	 * Description: To Encrypt passwords to be used in Project
	 * Parameter: 
	 * Date: April 2020 
	 * 
	 */	 
	private static final byte[] keyValue = new byte[] { 'w', 'F', 'h', 'D',
			'u', 'e', 'T', 'o', 'c', 'O', 'v', 'i', 'D', '1', '9', '*' };
	private static final String Golf = "AES";		 
	public static String decrypt(String encryptedData) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(Golf);
		c.init(Cipher.DECRYPT_MODE, key);
		@SuppressWarnings("restriction")
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, Golf);
		return key;
	}

	public static String encrypt(String Data) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(Golf);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		@SuppressWarnings("restriction")
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}

	/*******************************************************************************************/

	public void scrollBehaviorByPixels(int X_Pixels, int Y_Pixels) {
		/* 
		 * Author: Balajee Palle
		 * Description: To move horizontally or Vertically within  HTML page 
		 * Parameter: X_Pixels and Y_Pixels example 0, 250 to vertically down and -250 to scroll up.
		 * Date: April 2020 
		 * 
		 */
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll("+X_Pixels+","+Y_Pixels+")");
	}

	public void scrollToWebElement(WebElement element) {
		/* 
		 * Author: Balajee Palle
		 * Description: To move to WebElement within  HTML page 
		 * Parameter: WebElement
		 * Date: April 2020 
		 * 
		 */
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element );
	}

	public void scrollToBottomOfHTML() {
		/* 
		 * Author: Balajee Palle
		 * Description: to move to Bottom of  HTML page 
		 * Parameter: 
		 * Date: April 2020 
		 * 
		 */
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}

	public void scrollWithinWebElement(String CssSelector, int Pixels) {
		/* 
		 * Author: Balajee Palle
		 * Description: to scroll within WebElement say Div section, webTable or any sub section
		 * Parameter: Css selector of section to be scrolled.
		 * Date: April 2020 
		 * 
		 */
		String syntx= "document.querySelector("+"'"+ CssSelector +"'"+").scrollTop="+Pixels+"";
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
		//eventFiringWebDriver.executeScript("document.querySelector("+"'"+ CssSelector +"'"+").scrollTop="+Pixels+"");
		eventFiringWebDriver.executeScript(syntx);
	}

	public void selectDropdownValue(WebElement element, String value) {
		/* 
		 * Author: Balajee Palle
		 * Description: To select Dropdown value, locator has to be with 'Select' tag.
		 * Parameter: WebElement
		 * Date: April 2020 
		 */
		element.click();
		wait(2);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void selectDropdownValueByWebElements(WebElement dropdown, WebElement value) {
		/* 
		 * Author: Balajee Palle
		 * Description: To Drop down value by Javascript
		 * Parameter: drop down WebElement and value WebElement
		 * Date: April 2020 
		 * 
		 */
		dropdown.click();	
		wait(3);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", value);
		value.click();

	}

	public void switchToFrameByLocator(WebElement element) {
		/* 
		 * Author: Abhishek Bhatt
		 * Description: To switch control to frame in the UI
		 * Parameter: frame webelement
		 * Date: April 2020 
		 * 
		 */
		driver.switchTo().frame(element);
	}

	public void IsDisplayed_IsEnabled(WebElement element){
		/* 
		 * Author: Abhishek Bhatt, Balajee Palle
		 * Description: To verify that element is displayed and is enabled in the UI and added Reporter.log after assertion 
		 * Parameter:Webelement
		 * Date: April 2020 
		 * 
		 */
		
		boolean actual = element.isDisplayed() && element.isEnabled();
		Assert.assertEquals(actual, true);
		Reporter.log("Is WebElement  " +element.getText()+" is displayed: "+actual);
		//return element.isDisplayed() && element.isEnabled();

	}


	public String getTitle() {
		/* 
		 * Author: Sakshi Gupta
		 * Description: To Get the Title of the page
		 * Parameter: 
		 * Date: April 2020 
		 * 
		 */
		return driver.getTitle();
	}

	public String getURL() {
		/* 
		 * Author: Sakshi Gupta
		 * Description: To Get the Current URL of the page
		 * Parameter: 
		 * Date: April 2020 
		 * 
		 */
		return driver.getCurrentUrl();
	}	
	

	public static void takeScreenshotAtEndOfTest()  {
		/* 
		 * Author: Pravin Sonawane, Balajee Palle
		 * Description: To Take screenshot of page, Screenshot added to Reporter.log
		 * Parameter: 
		 * Date: April 2020 
		 * 
		 */
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenShotName = new File(userDirectory + "/screenshots/" + System.currentTimeMillis() + ".png");
		try {
			FileUtils.copyFile(scrFile,screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Reporter.log("<br><img src='"+screenShotName+"' height='300' width='300'/><br>");  
		  	
	}
	
	public void selectRadio(List<WebElement> locator,String exvalue) {
		/* 
		 * Author: Pravin Sonawane
		 * Description: To Select radio button.
		 * Parameter: Locator for radio and value for selection
		 * Date: April 2020 
		 * 
		 */
		for(WebElement temp : locator) {
			if(temp.getAttribute("value").equalsIgnoreCase(exvalue)) {
				temp.click();
			}
		}
	}
	
	public static void windowhandle() {
		/* 
		 * Author: Pravin Sonawane
		 * Description: To switch to child window
		 * Parameter: Locator for radio and value for selection
		 * Date: April 2020 
		 */
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> it = allwindow.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		/* 
		 * Author: Gokul Raj
		 * Description: To validate the file is downloaded or not 
		 * Parameter: download path and the expected download file name
		 * Usage : add a assert.assertrue statement and call this method
		 * Date: 16th April 2020 
		 */
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag=true;
		}

		return flag;
	}
	
	public static String getAlphaNumericString(int n) { 
		/* 
		 * Author: Balajee Palle
		 * Description: To generate AlphaNumaric String with numbers.
		 * Parameter: Integer with number of characters
		 * Date: April 2020 
		 */

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz"; 
		StringBuilder sb = new StringBuilder(n); 

		for (int i = 0; i < n; i++) { 
			int index = (int)(AlphaNumericString.length() * Math.random()); 
			sb.append(AlphaNumericString.charAt(index)); 
		} 

		return sb.toString(); 
	} 
}


