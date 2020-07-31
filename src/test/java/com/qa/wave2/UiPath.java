package com.qa.wave2;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import org.testng.annotations.BeforeMethod;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class UiPath extends CommonMethods{
	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	// URL for UiPath Prod env
	final String PrdUrl = "https://sjuiptappprdn01.na.gilead.com/";
	private String UserName = "graj";
	private String DecrptPassword;
	String EncryptPassword = "EGEACZoCQaq1AQaR+KTQ6Q==";

	/***************************** Test Cases *******************/
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
	

	String URL = PrdUrl;
	
  @BeforeMethod
  public void beforeMethod() {
	  launchBrowser("Chrome", URL);
	  login();
  }

  @Test(priority=1, enabled=true)
  public void UIPATH_S01_Web_Login_Verification() {
	  TM_S01_Web_Login_Verification();
  }
  
  @Test(priority=2, enabled=true)
  public void UIPATH_S02_Web_Monitoring_Tab_Validate() {
	  TM_S02_Web_Monitoring_Tab_Validate();
  }
  
  @Test(priority=3, enabled=true)
  public void UIPATH_S03_Web_Robots_Tab_Validate() {
	  TM_S03_Web_Robots_Tab_Validate();
  }
  
  @Test(priority=4, enabled=true)
  public void UIPATH_S04_Web_Processes_Tab_Validate() {
	  TM_S04_Web_Processes_Tab_Validate();
  }
  
  @Test(priority=5, enabled=true)
  public void UIPATH_S05_Web_Jobs_Tab_Validate() {
	  TM_S05_Web_Jobs_Tab_Validate();
  }
  
  @Test(priority=6, enabled=false)
  public void UIPATH_S06_Web_Run_Dummy_Job() {
	  TM_S06_Web_Run_Dummy_Job();
  }
  
  @AfterMethod
  public void afterMethod() {
	  //logout();
	  //driver.quit();
  }

  /***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
  	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 * txt_: Text
	 * crd_: Card
	 */

	
	By txt_login		=	By.className("card-title");
	By ipt_usrname		=	By.cssSelector("#mat-input-0");
	By ipt_password		=	By.cssSelector("#mat-input-1");
	By chk_rememberme	=	By.className("mat-checkbox-inner-container");
	By btn_login		=	By.xpath("//span[contains(text(),'Login')]");
	By txt_homeText		=	By.cssSelector("#FullLogo");
	By btn_monitoring	=	By.xpath("//span[contains(text(),'Monitoring')]");
	By lnk_stabText		=	By.xpath("//a[@class='single active']");
	By lnk_dtabText		=	By.xpath("//a[@class='active']");
	By crd_rbtsovrview	=	By.xpath("//ng-component[@class='ui-widget ng-star-inserted']//mat-card[@class='mat-card ng-star-inserted']");
	By txt_rbtsovrview	=	By.xpath("//span[contains(text(),'Robots Overview')]");
	By tbl_gridTable	=	By.xpath("//table[@class='ui-grid-table']");
	By btn_robots 		=	By.xpath("//span[contains(text(),'Robots')]");
	By btn_processes	=	By.xpath("//span[contains(text(),'Processes')]");
	By btn_jobs			=	By.xpath("//span[contains(text(),'Jobs')]");
	By btn_user			=	By.xpath("//button[@title='User']");
	By btn_logOut		=	By.xpath("//a[contains(text(),'Log Out')]");
	By btn_startRun		=	By.xpath("//button[@class='btn btn-primary mat-mini-fab mat-accent ng-star-inserted']");
	By ipt_process		=	By.xpath("//div[@class='display-container text-ellipsis']");
	By tbl_robotsTable	=	By.xpath("//ui-process-robots-grid[1]/ui-grid[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr");
	By ipt_processName	=	By.xpath("//ui-suggest[1]/div[1]/div[2]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]");
	By btn_start		=	By.xpath("//span[@class='mat-button-wrapper'][contains(text(),'Start')]");
	By tbl_jobRows		=	By.xpath("//tbody//tr");
	
		
	

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
  
	public void TM_S01_Web_Login_Verification() {
		takeScreenshotAtEndOfTest();
		WebElement HomePageText_Txt = createWebElementBy(txt_homeText);		
		Assert.assertTrue(HomePageText_Txt.isDisplayed(), "Error :: The UiPath web application is not loaded");
	}
	
	public void TM_S02_Web_Monitoring_Tab_Validate() {
		WebElement Monitoring_Btn = createWebElementBy(btn_monitoring);
		Monitoring_Btn.click();
		
		WebElement STabText_Lnk = createWebElementBy(lnk_stabText);
		Assert.assertEquals(STabText_Lnk.getText(), "Monitoring");
		
		takeScreenshotAtEndOfTest();
		
		WebElement RobotsOverview_Crd = createWebElementBy(crd_rbtsovrview);
		Assert.assertTrue(RobotsOverview_Crd.isDisplayed());
		
		WebElement RobotsOverview_Txt = createWebElementBy(txt_rbtsovrview);
		Assert.assertEquals(RobotsOverview_Txt.getText(), "Robots Overview");
	}
	
	public void TM_S03_Web_Robots_Tab_Validate(){
		WebElement Robots_Btn = createWebElementBy(btn_robots);
		Robots_Btn.click();
		
		WebElement DTabText_Lnk = createWebElementBy(lnk_dtabText);
		Assert.assertEquals(DTabText_Lnk.getText(), "Robots");
		
		takeScreenshotAtEndOfTest();
		
		WebElement GridTable_tbl = createWebElementBy(tbl_gridTable);
		Assert.assertTrue(GridTable_tbl.isDisplayed());
	}
	
	public void TM_S04_Web_Processes_Tab_Validate(){
		WebElement Processes_Btn = createWebElementBy(btn_processes);
		Processes_Btn.click();
		
		WebElement DTabText_Lnk = createWebElementBy(lnk_dtabText);
		Assert.assertEquals(DTabText_Lnk.getText(), "Processes");
		
		takeScreenshotAtEndOfTest();
		
		WebElement GridTable_tbl = createWebElementBy(tbl_gridTable);
		Assert.assertTrue(GridTable_tbl.isDisplayed());
	}
	
	public void TM_S05_Web_Jobs_Tab_Validate(){
		WebElement Jobs_Btn = createWebElementBy(btn_jobs);
		Jobs_Btn.click();
		
		WebElement STabText_Lnk = createWebElementBy(lnk_stabText);
		Assert.assertEquals(STabText_Lnk.getText(), "Jobs");
		
		takeScreenshotAtEndOfTest();
		
		WebElement GridTable_tbl = createWebElementBy(tbl_gridTable);
		Assert.assertTrue(GridTable_tbl.isDisplayed());		
	}
	
	public void TM_S06_Web_Run_Dummy_Job() {
		WebElement Jobs_Btn = createWebElementBy(btn_jobs);
		Jobs_Btn.click();
		
		WebElement STabText_Lnk = createWebElementBy(lnk_stabText);
		Assert.assertEquals(STabText_Lnk.getText(), "Jobs");
		
		startJob();
		/*driver.findElement(By.xpath("//ui-grid-pager[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'50')]")).click();
		
		
		List<WebElement> jobRows = createWebElementsBy(tbl_jobRows);
		int numberOfRows = jobRows.size();
		
    	for (int i=1;i<=numberOfRows;i++) {
			String processName = driver.findElement(By.xpath("//tbody//tr["+i+"]/td[2]")).getText();
			String processStatus = driver.findElement(By.xpath("//tbody//tr["+i+"]/td[3]")).getText();
			if(processName.equalsIgnoreCase("UploadToCMWF-Generic") && processStatus.equalsIgnoreCase("Successful")) {
				System.out.println("The robot successfully ran the job "+processName);
				break;
			}else {
				continue;
			}
		} */
		
		
	}
	
	/**********************************  Generic Method for this App ****************************/
	public void login() {
		waitForPageLoaded();
		WebElement Login_Txt = createWebElementBy(txt_login);
		Assert.assertEquals(Login_Txt.getText(), "Login");
		
		try {
			DecrptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement UserName_Ipt = createWebElementBy(ipt_usrname);
		UserName_Ipt.sendKeys(UserName);
		WebElement Password_Ipt = createWebElementBy(ipt_password);
		Password_Ipt.sendKeys(DecrptPassword);
		WebElement Login_Btn = createWebElementBy(btn_login);
		Login_Btn.click();
	}
	
	public void logout() {
		WebElement User_Btn = createWebElementBy(btn_user);
		User_Btn.click();
		WebElement LogOut_Btn = createWebElementBy(btn_logOut);
		LogOut_Btn.click();
		waitForPageLoaded();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("login"), "The logout was unsuccessfull");
	}
	
	public void startJob() {
		WebElement StartRun_Btn = createWebElementBy(btn_startRun);
		StartRun_Btn.click();
		
		WebElement Process_Ipt = createWebElementBy(ipt_process);
		Process_Ipt.click();
		
		WebElement ProcessName_Ipt = createWebElementBy(ipt_processName);
		ProcessName_Ipt.sendKeys("DummyProcess_Test");
		wait(2);
		driver.findElement(By.xpath("//div[@class='text-label text-ellipsis']")).click();
		
		
		List<WebElement> allRows = createWebElementsBy(tbl_robotsTable);
		int numberOfRows = allRows.size();
		
		String serverName = "SJUIPTAPPPRDN02";
		 
		for(int i=1;i<=numberOfRows;i++) {
			WebElement names = driver.findElement(By.xpath("//ui-process-robots-grid[1]/ui-grid[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[3]"));
			WebElement status = driver.findElement(By.xpath("//ui-process-robots-grid[1]/ui-grid[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[4]"));
			if(names.getText().equalsIgnoreCase(serverName) && status.getText().equalsIgnoreCase("Available")) {
				System.out.println("The Machine found is "+names.getText());
				driver.findElement(By.xpath("//ui-process-robots-grid[1]/ui-grid[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[1]")).click();;
				WebElement Start_Btn = createWebElementBy(btn_start);
				Start_Btn.click();
			}else {
				continue;
			}
		}
	}
	
	public void selectDropdownByText(WebElement locator, String value) {
		Select select = new Select(locator);
		select.selectByVisibleText(value);
	}
}
