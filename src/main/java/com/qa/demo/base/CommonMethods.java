package com.qa.demo.base;

import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CommonMethods {
	private static final String userDirectory = System.getProperty("user.dir");;
	public static WebDriver driver;



	public void launchbrowser(String browser, String url) {

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
	 * Date: Apirl 2020 
	 * 
	 */	 
	private static final byte[] keyValue = new byte[] { 'w', 'F', 'h', 'D',
			'u', 'e', 'T', 'o', 'c', 'O', 'v', 'i', 'D', '1', '9', '*' };
	private static final String Golf = "AES";		 
	public static String decrypt(String encryptedData) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(Golf);
		c.init(Cipher.DECRYPT_MODE, key);
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
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}

	/*******************************************************************************************/
}


