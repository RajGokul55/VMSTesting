package com.qa.demo.base;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
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
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CommonMethods {
	private static final String userDirectory = System.getProperty("user.dir");
	public static WebDriver driver;

	public void launchBrowser(String browser, String url) {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					userDirectory + "\\src\\main\\java\\com\\qa\\demo\\config\\chromedriver_v78.exe");
			driver = new ChromeDriver();
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
	}

	public WebElement createWebElementBy(By locator) {
		/*
		 * Author: Balajee Palle Description: To create web Element by passing locator.
		 * Parameter: Xpath or Css Syntax example: Date: April 2020
		 * 
		 */
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		Reporter.log("Mouse Control is on " + locator.toString() + " on Web App URL: " + driver.getCurrentUrl());
		highLightElement(element);
		return element;
	}

	public List<WebElement> createWebElementsBy(By locator) {
		/*
		 * Author: Balajee Palle Description: To create web Elements by passing locator.
		 * Parameter: Xpath or Css Syntax example: Date: April 2020
		 * 
		 */
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		List<WebElement> elements = driver.findElements(locator);
		return elements;
	}

	public void highLightElement(WebElement element) {
		/*
		 * Author: Balajee Palle Description: To highlight the web Element Parameter:
		 * WebElement Date: April 2020
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px red')", element);
		wait(1);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);
	}

	public static void wait(int sec) {
		/*
		 * Author: Balajee Palle Description: Hard wait Parameter: Time in seconds but
		 * never use >5 Date: April 2020
		 * 
		 */
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForPageLoaded() {
		/*
		 * Author: Balajee Palle Description: Waits for page load Parameter: Date: April
		 * 2020
		 * 
		 */
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
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
		 * Author: Balajee Palle Description: to do mouse hover on element Parameter:
		 * WebElement Date: April 2020
		 * 
		 */
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void domClick(WebElement element) {
		/*
		 * Author: Balajee Palle Description: to do safe click on element Parameter:
		 * WebElement Date: April 2020
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
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace());
		}
	}

	/*************************************************************************/
	/*
	 * Author: Balajee Palle Description: To Encrypt passwords to be used in Project
	 * Parameter: Date: April 2020
	 * 
	 * 
	 * private static final byte[] keyValue = new byte[] { 'w', 'F', 'h', 'D', 'u',
	 * 'e', 'T', 'o', 'c', 'O', 'v', 'i', 'D', '1', '9', '*' }; private static final
	 * String Golf = "AES";
	 * 
	 * public static String decrypt(String encryptedData) throws Exception { Key key
	 * = generateKey(); Cipher c = Cipher.getInstance(Golf);
	 * c.init(Cipher.DECRYPT_MODE, key);
	 * 
	 * @SuppressWarnings("restriction") byte[] decordedValue = new
	 * BASE64Decoder().decodeBuffer(encryptedData); byte[] decValue =
	 * c.doFinal(decordedValue); String decryptedValue = new String(decValue);
	 * return decryptedValue; }
	 * 
	 * private static Key generateKey() throws Exception { Key key = new
	 * SecretKeySpec(keyValue, Golf); return key; }
	 * 
	 * public static String encrypt(String Data) throws Exception { Key key =
	 * generateKey(); Cipher c = Cipher.getInstance(Golf);
	 * c.init(Cipher.ENCRYPT_MODE, key); byte[] encVal = c.doFinal(Data.getBytes());
	 * 
	 * @SuppressWarnings("restriction") String encryptedValue = new
	 * BASE64Encoder().encode(encVal); return encryptedValue; }
	 */

	/*******************************************************************************************/

	public void scrollBehaviorByPixels(int X_Pixels, int Y_Pixels) {
		/*
		 * Author: Balajee Palle Description: To move horizontally or Vertically within
		 * HTML page Parameter: X_Pixels and Y_Pixels example 0, 250 to vertically down
		 * and -250 to scroll up. Date: April 2020
		 * 
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(" + X_Pixels + "," + Y_Pixels + ")");
	}

	public void scrollToWebElement(WebElement element) {
		/*
		 * Author: Balajee Palle Description: To move to WebElement within HTML page
		 * Parameter: WebElement Date: April 2020
		 * 
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToBottomOfHTML() {
		/*
		 * Author: Balajee Palle Description: to move to Bottom of HTML page Parameter:
		 * Date: April 2020
		 * 
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}

	public void scrollWithinWebElement(String CssSelector, int Pixels) {
		/*
		 * Author: Balajee Palle Description: to scroll within WebElement say Div
		 * section, webTable or any sub section Parameter: Css selector of section to be
		 * scrolled. Date: April 2020
		 * 
		 */
		String syntx = "document.querySelector(" + "'" + CssSelector + "'" + ").scrollTop=" + Pixels + "";
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
		// eventFiringWebDriver.executeScript("document.querySelector("+"'"+ CssSelector
		// +"'"+").scrollTop="+Pixels+"");
		eventFiringWebDriver.executeScript(syntx);
	}

	public void selectDropdownValue(WebElement element, String value) {
		/*
		 * Author: Balajee Palle Description: To select Dropdown value, locator has to
		 * be with 'Select' tag. Parameter: WebElement Date: April 2020
		 */
		element.click();
		wait(2);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void selectDropdownValueByWebElements(WebElement dropdown, WebElement value) {
		/*
		 * Author: Balajee Palle Description: To Drop down value by Javascript
		 * Parameter: drop down WebElement and value WebElement Date: April 2020
		 * 
		 */
		dropdown.click();
		wait(3);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", value);
		value.click();

	}

	public void switchToFrameByLocator(WebElement element) {
		/*
		 * Author: Abhishek Bhatt Description: To switch control to frame in the UI
		 * Parameter: frame webelement Date: April 2020
		 * 
		 */
		driver.switchTo().frame(element);
	}

	public void IsDisplayed_IsEnabled(WebElement element) {
		/*
		 * Author: Abhishek Bhatt, Balajee Palle Description: To verify that element is
		 * displayed and is enabled in the UI and added Reporter.log after assertion
		 * Parameter:Webelement Date: April 2020
		 * 
		 */

		boolean actual = element.isDisplayed() && element.isEnabled();
		Assert.assertEquals(actual, true);
		Reporter.log("Is WebElement  " + element.getText() + " is displayed: " + actual);
		// return element.isDisplayed() && element.isEnabled();

	}

	public String getTitle() {
		/*
		 * Author: Sakshi Gupta Description: To Get the Title of the page Parameter:
		 * Date: April 2020
		 * 
		 */
		return driver.getTitle();
	}

	public String getURL() {
		/*
		 * Author: Sakshi Gupta Description: To Get the Current URL of the page
		 * Parameter: Date: April 2020
		 * 
		 */
		return driver.getCurrentUrl();
	}

	public static void takeScreenshotAtEndOfTest() {
		/*
		 * Author: Pravin Sonawane, Balajee Palle Description: To Take screenshot of
		 * page, Screenshot added to Reporter.log, Added steps to save image into
		 * Reporter. Parameter: Date: April 2020
		 * 
		 */

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenShotName = new File(userDirectory + "/screenshots/" + System.currentTimeMillis() + ".png");
		try {
			FileUtils.copyFile(scrFile, screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Reporter.log("<br><img src='"+screenShotName.toString()+"' height='300'
		// width='500'/><br>");

		FileInputStream fTptStrm = null;
		String encodedBase64 = null;

		try {
			fTptStrm = new FileInputStream(screenShotName);
			byte[] bytes = new byte[(int) screenShotName.length()];
			fTptStrm.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = "data:image/png;base64, " + encodedBase64;

		Reporter.log("<br><img src='" + result + "' height='300' width='500'/><br>");

	}

	public void selectRadio(List<WebElement> locator, String exvalue) {
		/*
		 * Author: Pravin Sonawane Description: To Select radio button. Parameter:
		 * Locator for radio and value for selection Date: April 2020
		 * 
		 */
		for (WebElement temp : locator) {
			if (temp.getAttribute("value").equalsIgnoreCase(exvalue)) {
				temp.click();
			}
		}
	}

	public static void windowhandle() {
		/*
		 * Author: Pravin Sonawane Description: To switch to child window Parameter:
		 * Locator for radio and value for selection Date: April 2020
		 */
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> it = allwindow.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		/*
		 * Author: Gokul Raj Description: To validate the file is downloaded or not
		 * Parameter: download path and the expected download file name Usage : add a
		 * assert.assertrue statement and call this method Date: 16th April 2020
		 */
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	public static String getAlphaNumericString(int n) {
		/*
		 * Author: Balajee Palle Description: To generate AlphaNumaric String with
		 * numbers. Parameter: Integer with number of characters Date: April 2020
		 */

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	public String RSA_Authentication(String UserID) {
		/*
		 * Author: Balajee Palle Description: To generate GPV Password by Entering
		 * Gilead ID & RSA Token. Parameter: Gilead ID Date: April 2020
		 */

		launchBrowser("Chrome", "https://gpv.gilead.com/");

		By btn_Go = By.cssSelector("input[type='submit']");
		WebElement Go_Btn = createWebElementBy(btn_Go);
		Go_Btn.click();

		By ipt_Username = By.cssSelector("input[id$='_ctrlLogon_txtUsername']");
		WebElement UserID_Ipt = createWebElementBy(ipt_Username);
		UserID_Ipt.sendKeys(UserID);

		String inputRSACode;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter or Copy Paste RSA Token Code Here: ");
		inputRSACode = scanner.nextLine();

		By ipt_Passcode = By.cssSelector("input[id$='_ctrlLogon_txtPassword']");
		WebElement PassCode_Ipt = createWebElementBy(ipt_Passcode);
		PassCode_Ipt.sendKeys(inputRSACode);

		By btn_SignIn = By.cssSelector("input[id$='_ctrlLogon_btnLogon']");
		WebElement SignIn_Btn = createWebElementBy(btn_SignIn);
		SignIn_Btn.click();

		By btn_ShowPwd = By.cssSelector("div[id='Recently'] img[title='Show password']");
		WebElement ShowPwd_Btn = createWebElementBy(btn_ShowPwd);
		ShowPwd_Btn.click();

		By Fld_Password = By.cssSelector("label[class^= ' account-password-display']");
		WebElement Pwd_Fld = createWebElementBy(Fld_Password);
		String password = Pwd_Fld.getText();

		System.out.println("Entered RSA Token Code : " + inputRSACode + " Fectched Password: " + password);
		driver.close();

		return password;
	}

	public void runWindowsServerCheckBat(String batfile) {
		/*
		 * Author: Balajee Palle Description: To run .bat file Parameter: bat file path
		 * Date: May 2020
		 * 
		 */
		try {
			Runtime.getRuntime().exec("cmd /C start " + batfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait(4);
	}

	public void sikuliEnterCredentails(String username, String Pasword) {
		/*
		 * Author: Balajee Palle Description: To enter user name and password on windows
		 * powershell using Sikuli Parameter: ADM account and password Date: May 2020
		 * 
		 */
		String path = userDirectory + "\\AutoFiles\\SiKuli\\";

		Screen s = new Screen();
		Pattern UserNameInput = new Pattern(path + "Username.PNG");
		Pattern PasswordInput = new Pattern(path + "Password.PNG");
		Pattern openButton = new Pattern(path + "OkButton.PNG");

		try {
			s.wait(UserNameInput, 20);
			s.type(UserNameInput, username);
			s.type(PasswordInput, Pasword);
			s.click(openButton);
		} catch (FindFailed e) {
			e.printStackTrace();
		}

	}

	public void verifyServiceStatus(String filePath, String service, String Status) {
		/*
		 * Author: Balajee Palle Description: To Validate Service name and its status
		 * Parameter: Result file path, service name and expected status Date: May 2020
		 * 
		 */
		BufferedReader br = null;
		String line = null;
		String expected = "State     : " + Status;
		boolean flag = false;
		try {
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-16"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			try {
				line = br.readLine();
				while (line != null) {
					if (line.endsWith(service)) {
						line = br.readLine();
						line = br.readLine();
						System.out.println("The service: " + service + " displayed as " + line);
						Reporter.log("The service: " + service + " displayed as " + line);
						line = br.readLine();
						System.out.println("The service: " + service + " displayed as " + line);
						Reporter.log("The service: " + service + " displayed as " + line);
						Assert.assertTrue(line.equalsIgnoreCase(expected));
						flag = true;
						break;
					}
					line = br.readLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(flag);

	}

	/*
	 * Author: DeepakKumarMarkanti Description: To Accept Alert Parameter: No
	 * Parameter Date: May 2020
	 * 
	 */

	public void acceptAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			System.out.println(text);
			alert.accept();

		} catch (NoAlertPresentException e) {
			System.out.println("No Alert present");

		}
	}

	/*
	 * Author: DeepakKumarMarkanti Description: To Dismiss Alert Parameter: No
	 * Parameter Date: May 2020
	 * 
	 */

	public void dismissAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			System.out.println(text);
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			System.out.println("No Alert present");
		}

	}

	/*
	 * Author: DeepakKumarMarkanti Description: To close current Browser Parameter:
	 * No Parameter Date: May 2020
	 * 
	 */

	public void closeBrowser() {
		try {
			driver.close();

		} catch (Exception e) {
			System.out.println("Unexpected error occured in Browser");

		}
	}

	/*
	 * Author: DeepakKumarMarkanti Description: To close all the opened Browsers
	 * Parameter: No Parameter Date: May 2020
	 * 
	 */

	public void closeAllBrowsers() {
		try {
			driver.quit();

		} catch (Exception e) {
			System.out.println("Unexpected error occured in Browser");
		}
	}

	public static void verifyWinSerStatus(String hostname, String servicename, String SerState, String SerMode) {
		/*
		 * Author: Balajee Palle Description: To search Service and verify its State and
		 * Mode. Parameter: Host name, Service name, State and Mode Date: May 2020
		 * 
		 */
		Scanner x;
		final String filepath = System.getProperty("user.dir") + "\\AutoFiles\\" + "August-std.txt";
		boolean found = false;
		String SystemName = "";
		String DisplayName = "";
		String State = "";
		String Mode = "";
		try {
			x = new Scanner(new File(filepath));
			x.useDelimiter("[\t\n]");
			while (x.hasNext() && !found) {
				SystemName = x.next();
				DisplayName = x.next();
				State = x.next();
				Mode = x.next();
				// System.out.println("Result Record with Hostname: "+SystemName + " Service:
				// "+DisplayName+" State: "+ State );
				if (DisplayName.trim().equalsIgnoreCase(servicename.trim())
						&& SystemName.trim().equalsIgnoreCase(hostname.trim())) {
					found = true;
				}
			}
			if (found) {
				System.out.println("Hostname: " + SystemName + " with  Service: " + servicename + " State: " + State
						+ " Mode: " + Mode);
				Reporter.log("Hostname: " + hostname + " with Service: " + servicename + " is displayed");
				Assert.assertEquals(State.trim(), SerState.trim(), "State of Service is incorrect");
				Assert.assertEquals(Mode.trim(), SerMode.trim(), "Mode of Service is incorrect");
				Reporter.log("The above service's State: " + State + " & Mode: " + Mode + " is displayed");
			} else {
				System.out.println("Hostname: " + hostname + "with Service: " + servicename + " is NOT found in file");
				Reporter.log("Hostname: " + hostname + " with Service: " + servicename + " is NOT found in file");
				Assert.assertTrue(false,
						"Hostname: " + hostname + " with Service: " + servicename + " is NOT found in file");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found ");
			Reporter.log("File not found ");
			Assert.assertTrue(false, "File NOT found");
		}
	}

	public static void takeScreenshotAtSikuli() {
		/*
		 * Author: Balajee Palle Description: To Take screenshot of page, Screenshot
		 * added to Reporter.log, Added steps to save image into Reporter. Parameter:
		 * Date: April 2020
		 * 
		 */

		try {
			Thread.sleep(20);
			Robot r = new Robot();
			String path = userDirectory + "/screenshots/" + System.currentTimeMillis() + ".png";
			Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage Image = r.createScreenCapture(capture);
			ImageIO.write(Image, "png", new File(path));
			// System.out.println("Screenshot saved");
			// Reporter.log("<br><img src='" + path + "' height='300' width='500'/><br>");

			BufferedImage bImage = null;
			File screenShotName = null;

			try {
				File initialImage = new File(path);
				bImage = ImageIO.read(initialImage);
				screenShotName = new File(userDirectory + "/screenshots/" + System.currentTimeMillis() + ".png");
				try {
					FileUtils.copyFile(initialImage, screenShotName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				System.out.println("Exception occured :" + e.getMessage());
			}

			FileInputStream fTptStrm = null;
			String encodedBase64 = null;

			try {
				fTptStrm = new FileInputStream(screenShotName);
				byte[] bytes = new byte[(int) screenShotName.length()];
				fTptStrm.read(bytes);
				encodedBase64 = new String(Base64.encodeBase64(bytes));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result = "data:image/png;base64, " + encodedBase64;

			Reporter.log("<br><img src='" + result + "' height='300' width='500'/><br>");

		} catch (AWTException | IOException | InterruptedException ex) {
			System.out.println(ex);
		}
	}

	/*
	 * Author: Abhishek Bhatt Description: To drap one object from one location to
	 * another Parameter: WebElement Date: June 2020
	 */
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
	}

	/*
	 * Author: Abhishek Bhatt Description: To double click on element Parameter:
	 * WebElement Date: June 2020
	 */
	public void doubleClick(WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).build().perform();
	}

	public static void TM_connectToDB_RunQuery(String Url, String User, String Pass, String Query) {
		/*
		 * Author: Balajee Palle Description: To establish DB connection and to run
		 * query Parameter: Date: July 2020
		 */
		// Connection object
		Connection con = null;
		// Statement object
		Statement stmt;
		try {
			// Get connection to DB
			con = DriverManager.getConnection(Url, User, Pass);
			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(Query);
			// Print the result untill all the records are printed
			// res.next() returns true if there is any next record else returns false
			while (res.next()) {
				System.out.println("Count of records found : " + res.getInt(1) + " for Query:" + Query + '\n'
						+ "on this Database: " + Url + '\n');
				Reporter.log("Count of records found : " + res.getInt(1) + " for Query:" + Query + '\n'
						+ "on this Database: " + Url + '\n');
				Assert.assertTrue(res.getInt(1) >= 0);

				/*
				 * System.out.print(res.getString(1)); System.out.print("\t" +
				 * res.getString(2)); System.out.print("\t" + res.getString(3));
				 * System.out.println("\t" + res.getString(4));
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void RDP_Connection(String servername, String username, String password) {
		final String userDirectory = System.getProperty("user.dir");
		String path = userDirectory + "\\AutoFiles\\SiKuli\\RDP\\";
		Screen s = new Screen();
		Pattern startBtn = new Pattern(path + "StartButton.PNG");
		Pattern RDPConnection = new Pattern(path + "remoteConnection.PNG");
		Pattern serverName = new Pattern(path + "RDPServerName.PNG");
		Pattern connectRDPServer = new Pattern(path + "connectButton.PNG");
		Pattern useanotherAccount = new Pattern(path + "useAnotherAccount.PNG");
		Pattern userNameRDP = new Pattern(path + "usernameRDP.PNG");
		Pattern passwordRDP = new Pattern(path + "passwordRDP.PNG");
		Pattern okButton = new Pattern(path + "oKButtonRDP.PNG");

		try {
			s.wait(startBtn, 3000);
			s.click();
			s.wait(RDPConnection, 2000);
			s.click();
			wait(5);
			s.type(org.sikuli.script.Key.BACKSPACE);
			s.wait(serverName, 2000);
			s.type(servername);
			s.wait(connectRDPServer, 2000);
			s.click();
			s.wait(useanotherAccount, 2000);
			s.click();
			s.wait(userNameRDP, 2000);
			s.type(userNameRDP, username);
			s.wait(passwordRDP, 2000);
			s.type(passwordRDP, password);
			s.wait(okButton, 2000);
			s.click();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
