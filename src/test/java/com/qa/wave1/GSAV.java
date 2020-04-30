package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class GSAV extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	//Dev Environment
	final String Url= "https://sjgsavappdevn01.na.gilead.com/webapp/login.html"; 
	//Prod Environment
	final String Url1= "https://sjgsavappprdn01.na.gilead.com/WebApp/index.html";
	
	/***************************** Test Cases *******************/
	/*
	 * Test case ‘Test Name’ naming convention: <AppName><TCNumber>_<TestCategory>_<Title>
	Definitions of terms:     
•	AppName: short name of Application [String 5 -10 chars] i.e., TstMyApp, 
•	TCNumber: Test case number [Numeric 2-3 digits] i.e, 01, 02,..
•	TestCategory: Test case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB …]
•	Title: short title of test case based on context of test case  ie., ValidateCredntails
  	Test Name Example: Filkart_05_Web_ValidateCredntails.

	 * Test method name must be same as test case appended with TM example: 
	 */

	@BeforeMethod
	public void beforeTest() {
		launchBrowser(Browser, Url);
		login_verifyScreen();
	}

	@Test(priority=0, enabled=true)
	public void GSAV_S01_Web_VerifyDashboard() throws InterruptedException {
		TM_GSAV_01_Web_verifyDashboadScreen();
	}

	@Test(priority=1, enabled=true)
	public void GSAV_S02_Web_VerifySummary() throws Exception {
		TM_GSAV_002_verifySummaryScreen();
	}
	
	@Test(priority=2, enabled=true)
	public void GSAV_S03_Web_VerifyServerStatus() throws Exception {
		TM_GSAV_003_verifyServerStatus();
	}

	@AfterMethod
	public void afterTest() {
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

	
	By login_button = By.xpath("//*[@id='loginDomainLink']");
	By page_Heading = By.xpath("//div[@class='product_name']");
	By Operation_Center = By.xpath("//*[@id='tab_title_span-1']");
	By OperationCenter_CriticalThreatsText = By.xpath("//*[@id='top-critical-threat']/div[2]/div[1]/div[2]/div[1]");
    By summary_Btn = By.xpath("//*[@id='tab_title_span-2']");
    By SummaryCriticalThreatsText = By.xpath("//*[contains(text(),'Critical Threats')]");
    By productConnectionText = By.xpath("//*[contains(text(),'Product Connection Status')]");
    By viewDetailsText = By.xpath("//*[contains(text(),'View details')]");	
    By table = By.xpath("//div[@class='contentScrollerWrap']");
    By table1 = By.xpath("//div[@class='contentScrollerWrap']//div[@class='grid-row']");
    By Server1Name = By.cssSelector("body.grey:nth-child(2) div.template1:nth-child(1) div.canvas:nth-child(2) div.layout div.layout_row.clearfix:nth-child(2) div.box:nth-child(1) table.widget.modTmcmAppStatusSrv:nth-child(3) tr.bd td.mid div.widgetContent div.boxBD div.window_content div.window1:nth-child(2) div.data_view div.trend-grid.border div.contentScrollerWrap div.content div.grid-row:nth-child(1) > div.cell.modTmcmAppStatusSrv_grid31_ServerName.dd-draggable:nth-child(2)");
    
	/*****************************Test Case Methods 
	 * @throws InterruptedException *******************/
	//For all WebElements may append type Example: Submit_Btn


	void TM_GSAV_01_Web_verifyDashboadScreen() throws InterruptedException {

		takeScreenshotAtEndOfTest();
		navigatingToFrames();
		
		WebElement OperationCenter = createWebElementBy(Operation_Center);
		OperationCenter.click();
		
		boolean CriticalThreatsText = isElementExit(OperationCenter_CriticalThreatsText);
		System.out.println("Critical Threats text is displayed = " +CriticalThreatsText);
		takeScreenshotAtEndOfTest();		
		
	}

	void TM_GSAV_002_verifySummaryScreen()throws Exception {

		takeScreenshotAtEndOfTest();
		navigatingToFrames();
		WebElement Summary_Btn = createWebElementBy(summary_Btn);
		Summary_Btn.click();
		System.out.println("Summary is clicked ");
		waitForPageLoaded();
		
		boolean summarycriticalThreatsText = isElementExit(SummaryCriticalThreatsText);
		System.out.println("Summarry Critical Threats text is displayed = " +summarycriticalThreatsText);
		wait(3);
		scrollToBottomOfHTML();
		System.out.println("Scroll done ");
		wait(5);
		takeScreenshotAtEndOfTest();
		}
	
	void TM_GSAV_003_verifyServerStatus()throws Exception {

		takeScreenshotAtEndOfTest();
		navigatingToFrames();
		wait(3);
		WebElement Summary_Btn = createWebElementBy(summary_Btn);
		Summary_Btn.click();
		System.out.println("Summary is clicked ");
		waitForPageLoaded();
		wait(3);
		scrollToBottomOfHTML();
		System.out.println("Scroll done ");
		wait(5);
		boolean ProductconnectionText = isElementExit(productConnectionText);
		System.out.println("product Connection Text is displayed = " +ProductconnectionText);
		
		boolean ViewdetailsText = isElementExit(viewDetailsText);
		System.out.println("View details text is displayed = " +ViewdetailsText);
		
		WebElement TogetRows = createWebElementBy(table);
		List<WebElement> TotalRowsList = TogetRows.findElements(By.xpath("//*[@class='grid-row']"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
		//Taking count of active & abnormal status
		List<WebElement> TotalAbnormalStatus = TogetRows.findElements(By.xpath("//*[@class='grid-row']//*[@class='statusIcon abnormalIcon']"));
		int CurrentAbnormalStatus = TotalAbnormalStatus.size();
		System.out.println("Total number of Abnormal Status in Production connection status is : "+ CurrentAbnormalStatus);
		Assert.assertEquals(CurrentAbnormalStatus, 1);
		List<WebElement> TotalActiveStatus = TogetRows.findElements(By.xpath("//*[@class='grid-row']//*[@class='statusIcon onlineIcon']"));
		int CurrentActiveStatus = TotalActiveStatus.size();
		System.out.println("Total number of Active Status in Production connection status is : "+ CurrentActiveStatus);
		takeScreenshotAtEndOfTest();
		
		//Pord Env
		/*
		List<WebElement> TotalActiveStatus = TogetRows.findElements(By.xpath("//*[@class='grid-row']//*[@class='statusIcon onlineIcon']"));
		int CurrentActiveStatus = TotalActiveStatus.size();
		System.out.println("Total number of Active Status in Production connection status is : "+ CurrentActiveStatus);
		Assert.assertEquals(CurrentActiveStatus, 1);
		
		/*String status = driver.findElement(By.xpath(prop.getProperty("locatorXpath_Active"))).getText();
		System.out.println("Server Status : "+ status);
		String status1 = driver.findElement(By.xpath(prop.getProperty("locatorXpath_Active1"))).getText();
		System.out.println("Server Status : "+ status1);
		
		int size1 = driver.findElements(By.tagName("iframe")).size();
		System.out.println("size = "+size1); 
		int numRows = TotalRowsList.size();
		//String activeStatus = "statusIcon onlineIcon";
		for (int i=0;i<= numRows;i++)
		{
			WebElement serverstatus = driver.findElement(By.xpath("//*[@id='row_xuebaorp_0']/div[1]/span/text()"));
			System.out.println("serverstatus = "+serverstatus);
					/*if (serverstatus.contains(activeStatus)) {
						System.out.println(" server is active"); 
			              
			           } else {
			        	   System.out.println("not expected"); 
			           }
		}*/
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
		
		WebElement Login_Btn = createWebElementBy(login_button);
		Login_Btn.click();
		waitForPageLoaded();
	}

	public WebElement navigatingToFrames() throws InterruptedException {
		Thread.sleep(2000);
		// switch to  Frame
		WebElement Frame = driver.findElement(By.cssSelector("frame[name ='dow']"));
		driver.switchTo().frame(Frame);
		
		int size1 = driver.findElements(By.tagName("iframe")).size();
		System.out.println("size = "+size1);
		
		// switch to  Frame to iFrame
		WebElement Frame1 = driver.findElement(By.cssSelector("iframe[name ='mainTMCM']"));
		driver.switchTo().frame(Frame1);
		return Frame1;
		
	}
	
		
/*
public void verifyServerStatus() throws InterruptedException {
	Actions action= new Actions(driver);
	Thread.sleep(2000);
	
	//WebElement row = driver.findElement(By.xpath(prop.getProperty("locatorXpath_table")));
	Thread.sleep(2000);
	
	WebElement TogetRows = driver.findElement(By.xpath(prop.getProperty("table")));
	List<WebElement> TotalRowsList = TogetRows.findElements(By.className("grid-row"));
	System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
	
	String status = driver.findElement(By.xpath(prop.getProperty("locatorXpath_Active"))).getText();
	System.out.println("Server Status : "+ status);
	String status1 = driver.findElement(By.xpath(prop.getProperty("locatorXpath_Active1"))).getText();
	System.out.println("Server Status : "+ status1);
	
	/*WebElement Frame = driver.findElement(By.cssSelector("frame[name ='dow']"));
	driver.switchTo().frame(Frame);
	
	int size1 = driver.findElements(By.tagName("iframe")).size();
	System.out.println("size = "+size1); 
	int numRows = TotalRowsList.size();
	//String activeStatus = "statusIcon onlineIcon";
	for (int i=0;i<= numRows;i++)
	{
		WebElement serverstatus = driver.findElement(By.xpath("//*[@id='row_xuebaorp_0']/div[1]/span/text()"));
		System.out.println("serverstatus = "+serverstatus);
				/*if (serverstatus.contains(activeStatus)) {
					System.out.println(" server is active"); 
		              
		           } else {
		        	   System.out.println("not expected"); 
		           }
	}*/
}
	
	
		
		
	


