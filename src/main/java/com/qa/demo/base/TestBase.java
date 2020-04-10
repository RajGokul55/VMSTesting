package com.qa.demo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static FileInputStream ip;
	public static String userDirectory;

	/*
	 * propertyFileInitialization() : This method is used to initialize the property file 
	 * and all element of property file for the respective application.
	 */
	
	public void propertyFileInitialization(String propertyFile) {

		userDirectory = System.getProperty("user.dir");

		System.out.println(userDirectory);
		try {
			prop = new Properties();
			ip = new FileInputStream(new File(userDirectory+"\\src\\main\\java\\com\\qa\\demo\\config\\"+propertyFile+".properties"));
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/*
	 * Initialization() : This method is used for
	 *    1. To initialize the driver server for all browsers
	 *    2. To launch the application. 
	 */
	
	public void initialization() {

		String browser = prop.getProperty("Browser");
		String url = prop.getProperty("URL");
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
}
