package com.qa.kite;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class ProcessViewer_QMA extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	String pageUrl;
	final String Username = "bdineshjain";
	private String DecrptPassword;
	// URL for Fc vision:
	final String url = "http://aws01-cm-dev.kite.local:7180/cmf/home";
	

	/***************************** Test Cases *******************/
	/*
	 * Prod: https://aws01-cm-prod.kite.local:7183/cmf/home
	 * 
	 * Test: http://aws01-cm-test.kite.local:7180/cmf/home
	 * 
	 * Dev: http://aws01-cm-dev.kite.local:7180/cmf/home
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

	@BeforeMethod
	void Setup() {
		try {
			DecrptPassword = decrypt("sQqvi6GNDx3JA3VumJLc9g==");
		} catch (Exception e) {
			e.printStackTrace();
		}
		launchBrowser(Browser, url);
	}

	@Test(priority = 0, enabled = false)
	public void ProcessViewer_QMA_S01_Web_UrlVerification() {
		TM_ProcessViewer_QMA_S01_Web_UrlVerification();
	}
	
	@Test(priority = 2, enabled = true)
	public void ProcessViewer_QMA_S02_Web_HealthStatus() {
		
		TM_ProcessViewer_QMA_S02_Web_HealthStatus();
		
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
	By logo = By.xpath("//*[contains(text(),'Welcome to InsightIQ. Please log in.')]");
	By username=By.xpath("//input[@placeholder='Username']");
	By password= By.xpath("//input[@placeholder='Password']");
	By btn_login=By.xpath("//button[@type='submit']");
	By home_tag=By.xpath("//h1/span");
	By lnk_ClouderaManager=By.cssSelector(".navbar-brand");
	
	


	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	
	void UserLogin() {
		WebElement userName= createWebElementBy(username);
		userName.sendKeys(Username);
		WebElement passWord= createWebElementBy(password);
		passWord.sendKeys(DecrptPassword);
		WebElement login= createWebElementBy(btn_login);
		login.click();
		waitForPageLoaded();
	}

	public void TM_ProcessViewer_QMA_S01_Web_UrlVerification() {

		UserLogin();
		WebElement home= createWebElementBy(home_tag);
		Assert.assertEquals(home.getText(), "Home");
		takeScreenshotAtEndOfTest();
		
		
		
	}
	public void TM_ProcessViewer_QMA_S02_Web_HealthStatus() {
		UserLogin();
		String [] cluster= {"HDFS","Hive","Hue","Impala","Oozie","S3 Connector","Sentry","Solr","Spark","Spark 2","Sqoop 1 Client","YARN (MR2 Included)","ZooKeeper"};
		for(int i=0; i<cluster.length;i++) {
			boolean isPresent= true;
			try {
				driver.findElement(By.linkText(cluster[i]));
			}
			catch(NoSuchElementException e) {
				isPresent = false;
			}
			
			if(isPresent) {
				WebElement clusterLinks=driver.findElement(By.linkText(cluster[i]));
				clusterLinks.click();
			waitForPageLoaded();
			String value= driver.findElement(By.cssSelector(".health i")).getAttribute("data-original-title").trim();
			System.out.println("The Health of the cluster "+ cluster[i]+ " is "+ value);
			waitForPageLoaded();
			boolean flag = true;
			if(!"Concerning Health".equals(value) && !"Good Health".equals(value) && !"None".equals(value)) {
				flag= false;
			}
			
			
			/*
			 * System.out.println(value); System.out.println(flag);
			 */
			Assert.assertTrue(flag);
			createWebElementBy(lnk_ClouderaManager).click();
			waitForPageLoaded();
			}
			
			
		}
		
		waitForPageLoaded();
		
		takeScreenshotAtEndOfTest();
		
		
	}
		
		

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here

}
