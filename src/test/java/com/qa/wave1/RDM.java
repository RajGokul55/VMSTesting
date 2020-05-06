package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

public class RDM extends CommonMethods {
	
	
	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	//Dev Environment URL
	final String Url= "http://sjrdmappdevg03:6003/administrator/";
	final String username = "araj5";
	String EncryptPassword = "cHhqigjkE9lagBcklOFbJw==";
	private String DecrptPassword;
	
		
	/***************************** Test Cases *******************/
	/*
	 * Test case â€˜Test Nameâ€™ naming convention: <AppName><TCNumber>_<TestCategory>_<Title>
	Definitions of terms:     
â€¢	AppName: short name of Application [String 5 -10 chars] i.e., TstMyApp, 
â€¢	TCNumber: Test case number [Numeric 2-3 digits] i.e, 01, 02,..
â€¢	TestCategory: Test case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB â€¦]
â€¢	Title: short title of test case based on context of test case  ie., ValidateCredntails
  	Test Name Example: Filkart_05_Web_ValidateCredntails.

	 * Test method name must be same as test case appended with TM example: 
	 */

		
	@BeforeMethod
	  	public void beforeMethod() {
		launchBrowser(Browser, Url);
	  }	
	
	
	@Test(priority=0, enabled=true)
	public void RDM_S01_Web_login_verifyscreen() {
		TM_RDM_S01_Web_login_verifyScreen();
		
	}

	@Test(priority=1, enabled=true)
	public void RDM_S02_Web_Verify_Integration_services() {
		TM_RDM_S02_Web_Verify_Repository_services();
	}
	
	@Test(priority=2, enabled=true)
	public void RDM_S03_Web_Verify_Repository_services() {
		TM_RDM_S03_Web_Verify_Integration_services();
	}
	
		
	@AfterMethod 
		public void afterMethod() {
		driver.quit();
  }
	
	/***************************** Locators *******************/
	// Example syntax:Css Selector: tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 */
	By ipt_userName      =     By.xpath("//input[@id='username']");
	By ipt_password      =     By.xpath("//input[@name='password']");
	By drp_SecurityDomain =     By.cssSelector("#namespace");
	By btn_Login   		 =     By.cssSelector("#submitButton");
	By btn_Manage      =     By.xpath("//td[contains(text(),'Manage')]");
	By btn_Domain        =     By.cssSelector("#isc_14");
	By click_User      =     By.cssSelector("#isc_K");
	By btn_Logout      =     By.xpath("//div[contains(text(),'Log Out')]");
	By btn_Ok   	   =     By.xpath("//td[contains(text(),'OK')]");
	By popup_Text      =     By.xpath("//td[@class='confirm_box_class']");
	By Powercenter_IntegrationService    =     By.xpath("//div[@id='accordionContentPowerCenterIntegrationServicetype']");
	By txt_ResourceManager  =     By.xpath("//a[contains(text(),'Resource Manager Service')]");
	By txt_RepositoryService  =     By.xpath("//a[contains(text(),'PowerCenter Repository Service')]')]");
	By txt_IntegrationService     =     By.xpath("//a[contains(text(),'PowerCenter Integration Service')]");
	By txt_ModelService     =     By.xpath("//a[contains(text(),'Model Repository Service')]");
	By scroll	 = 	   By.cssSelector("#portletContainer1");
	By getSizeFor_IntergrationService    =     By.xpath("//*[@id='accordionContentPowerCenterIntegrationServicetype']");
	By getSizeFor_RepositoryService    =     By.xpath("//*[@id='accordionContentPowerCenterRepositoryServicetype']");
	By rdo_contentSelect =     By.xpath("//input[@name='value(courseFileName)']");
	By btn_startScan     =     By.cssSelector("#action-start-scan");
	By tbl_policyTable   =     By.xpath("//*[@id=\"policy-table-table\"]/tbody/tr");
	By tbl_disTable      =     By.xpath("//*[@id=\"discoverTargetListTable\"]/tbody/tr");
	By btn_allIncidents  =	   By.xpath("//table[4]/tbody[1]/tr[4]/td[1]/span[1]");
	By msg_saveSuccess   =     By.cssSelector("#web-status-message-155.message-content");

	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn
	
	
	public void TM_RDM_S01_Web_login_verifyScreen() {
		
		login_verifyScreen();
		logout();
	}
	

	
public void TM_RDM_S02_Web_Verify_Repository_services () {
		
		login_verifyScreen();
		WebElement clickManage = createWebElementBy(btn_Manage);
		clickManage.click();
		wait(3);
		WebElement clickDomain = createWebElementBy(btn_Domain);
		clickDomain.click();
		waitForPageLoaded();
		wait(3);
		takeScreenshotAtEndOfTest();
	
		//Switch to frame		
		WebElement Frame1 = driver.findElement(By.cssSelector("#isc_1D"));
		driver.switchTo().frame(Frame1);
		
		//Navigating to Power Center Integration service
		WebElement scrolltoPowerCenter = createWebElementBy(txt_IntegrationService);
		scrollToWebElement(scrolltoPowerCenter );
		System.out.println("power center intergration text is displayed ");
		wait(3);
		takeScreenshotAtEndOfTest();
		WebElement getServiceSize = createWebElementBy(getSizeFor_IntergrationService);
		List<WebElement> TotalIntergrationServiceList = getServiceSize.findElements(By.xpath("//*[@id='accordionContentPowerCenterIntegrationServicetype']/div[@class ='serviceWidgetClass']"));
		System.out.println("Total number of Intergration services present in Powser centerr is : "+ TotalIntergrationServiceList.size());
		wait(5);
		
		//Checking Available services
		List<WebElement> TotalAvailableStatus = getServiceSize.findElements(By.xpath("//*[@id='accordionContentPowerCenterIntegrationServicetype']/div[@class ='serviceWidgetClass']//*[@class = 'status_1']"));
		int CurrentIntergrationAvailableService = TotalAvailableStatus.size();
		System.out.println("Total number of Intergration service are in Available Status in Powser center  : "+ CurrentIntergrationAvailableService);
		Assert.assertEquals(CurrentIntergrationAvailableService, 27);
		//Checking Disable services
		List<WebElement> TotalDisableStatus = getServiceSize.findElements(By.xpath("//*[@id='accordionContentPowerCenterIntegrationServicetype']/div[@class ='serviceWidgetClass']//*[@class = 'status_3']"));
		int CurrentIntergrationDisableService = TotalDisableStatus.size();
		
		System.out.println("Total number of Intergration service arenin disabled service in Powser center : "+ CurrentIntergrationDisableService);
		Assert.assertEquals(CurrentIntergrationDisableService, 1);
		driver.switchTo().defaultContent();
		logout();	
}

	public void TM_RDM_S03_Web_Verify_Integration_services() {
		
		login_verifyScreen();
		wait(5);
		WebElement clickManage = createWebElementBy(btn_Manage);
		clickManage.click();
		wait(3);
		WebElement clickDomain = createWebElementBy(btn_Domain);
		clickDomain.click();
		waitForPageLoaded();
		wait(3);
		takeScreenshotAtEndOfTest();
		
		//Switch to frame		
				WebElement Frame1 = driver.findElement(By.cssSelector("#isc_1D"));
				driver.switchTo().frame(Frame1);
				
				//For getting Repository service
				
				//Navigating to Power Center Integration service
				WebElement scrolltoPowerCenter = createWebElementBy(txt_IntegrationService);
				scrollToWebElement(scrolltoPowerCenter );
				System.out.println("power center intergration text is displayed ");
				wait(3);
				
		
				//Navigating to Model service
				WebElement scrolltoModelService = createWebElementBy(txt_ModelService);
				scrollToWebElement(scrolltoModelService );
				System.out.println("Model Service text is displayed ");
				wait(3);
				takeScreenshotAtEndOfTest();
				/*
				WebElement scrolltoRepositoryService = createWebElementBy(txt_RepositoryService);
				scrollToWebElement(scrolltoRepositoryService );
				System.out.println("power center Repository Service text is displayed ");
				wait(3);
				//scrollToBottomOfHTML();
				//scrollBehaviorByPixels(200,500); 
				 */
				 
				WebElement getRepositoryServiceSize = createWebElementBy(getSizeFor_RepositoryService);
				List<WebElement> TotalRepositoryService = getRepositoryServiceSize.findElements(By.xpath("//*[@id='accordionContentPowerCenterRepositoryServicetype']//*[@class ='serviceWidgetClass']"));
				System.out.println("Total number of Repository Services are present in Powser center is : "+ TotalRepositoryService.size());
				
				//Checking Available Repository Service
						List<WebElement> TotalAvailableRepositoryStatus = getRepositoryServiceSize.findElements(By.xpath("//*[@id='accordionContentPowerCenterRepositoryServicetype']//*[@class ='serviceWidgetClass']//*[@class = 'status_1']"));
						int CurrentRepositoryAvailableService = TotalAvailableRepositoryStatus.size();
						System.out.println("Total number of available service available in Powser centerr is : "+ CurrentRepositoryAvailableService);
						Assert.assertEquals(CurrentRepositoryAvailableService, 6);
					//Checking disable Repository Service
						List<WebElement> TotalDisableRepositoryStatus = getRepositoryServiceSize.findElements(By.xpath("//*[@id='accordionContentPowerCenterRepositoryServicetype']//*[@class ='serviceWidgetClass']//*[@class = 'status_3']"));
						int CurrentRepositoryDisableService = TotalDisableRepositoryStatus.size();
						System.out.println("Total number of disabled service available in Powser centerr is : "+ CurrentRepositoryDisableService);
						Assert.assertEquals(CurrentRepositoryDisableService, 0);
						driver.switchTo().defaultContent();		
						logout();
		
	}
	
	public void logout() {
		
			WebElement clickUser = createWebElementBy(click_User);
			clickUser.click();
			System.out.println("clicked User account");
			wait(5);
			WebElement clickLogout = createWebElementBy(btn_Logout);
			clickLogout.click();
			//waitForPageLoaded();
			wait(3);
			System.out.println("clicked logout");
			boolean PopupText = isElementExit(popup_Text);
			System.out.println("Popup text is displayed = " +PopupText);
			
			WebElement clickOk = createWebElementBy(btn_Ok);
			takeScreenshotAtEndOfTest();
			clickOk.click();
	}
	
	public  boolean isElementExit(By locator) {
		/* 
		 * Author: Arun Raj
		 * Description: To check web Element is displayed by passing locator.
		 * Parameter: Xpath or Css Syntax example: 
		 * Date: April 2020 
		 * 
		 */
		
		try
		{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		boolean element =  driver.findElement(locator).isDisplayed();
		//System.out.println(element);
		return true;
	}
		catch (NoSuchElementException ex)
		{
			return false;
		}
	}
	
public void login_verifyScreen() {
		
		WebElement userNameipt = createWebElementBy(ipt_userName);
		userNameipt.sendKeys(username);
		

		try {
			DecrptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		WebElement passwordipt = createWebElementBy(ipt_password);
		passwordipt.sendKeys(DecrptPassword);
		
		WebElement Domain_Drp = createWebElementBy(drp_SecurityDomain);
		selectDropdownValue(Domain_Drp, "Gilead_LDAP");
		takeScreenshotAtEndOfTest();
		
		WebElement Login_btn = createWebElementBy(btn_Login);
		Login_btn.click();
		waitForPageLoaded();
		wait(25);
		
	}
	}