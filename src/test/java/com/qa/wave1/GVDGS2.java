package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GVDGS2 extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url = "http://fcgvdappuat01/gvd";

	/***************************** Test Cases *******************/

	@BeforeTest
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority = 0, enabled = true)
	public void GVD_GS2_TC01_Web_User_Login() {
		TM_TC01_Web_User_Login();
	}

	@Test(priority = 1, enabled = true)
	public void GVD_GS2_TC02_Web_Options_in_Menu_System_Accessible() {
		TM__TC02_Web_Options_in_Menu_System_Accessible();
	}

	
	  @Test(priority=2, enabled=true) 
	  public void GVD_GS2_TC03_Web_Pages_in_Menu_System_Accessible() {
	  TM_TC03_Web_Pages_in_Menu_System_Accessible(); 
	  }
	  
	  
	/*
	 * @Test(priority=3, enabled=true) public void
	 * GVD_GS2_TC04_Web_Tabs_under_Data_Browser_Accessible() {
	 * TM_TC04_Web_Tabs_under_Data_Browser_Accessible(); }
	 * 
	 * 
	 * @Test(priority=4, enabled=true) public void
	 * GVD_GS2_TC05_Web_Filters_applied_for_Tabs_Data_Browser() {
	 * TM_TC05_Web_Filters_applied_for_Tabs_Data_Browser(); }
	 */
	  
	 

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector: Tag
	// name[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */
	By lnk_Home = By.xpath("//span[contains(text(),'Home')]");
	By lnk_Reports = By.xpath("//span[contains(text(),'Reports')]");
	By lnk_Metadatas = By.xpath("//span[contains(text(),'Metadatas')]");
	By lnk_AuditTrail = By.xpath("//span[contains(text(),'Audit Trail')]");
	By lnk_PSV = By.xpath("//span[contains(text(),'Process Status Viewer')]");
	By lnk_Help = By.xpath("//span[contains(text(),'Help')]");
	By lnk_SLE = By.xpath("//span[contains(text(),'Sample Listing Export')]");
	By lnk_Sequences = By.xpath("//span[contains(text(),'Sequences')]");
	

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_TC01_Web_User_Login() {

		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Gilead Virology Database (GVD)";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		if (ActualTitle.equalsIgnoreCase(ExpectedTitle))
			System.out.println("Title matched");
		else
			System.out.println("Title is not matched");

	}

	public void TM__TC02_Web_Options_in_Menu_System_Accessible() {
		  {
	 
	        WebElement Home_lnk = createWebElementBy(lnk_Home);
	        if(Home_lnk.isDisplayed() && Home_lnk.isEnabled())
	        {
	        	System.out.println("Home link is displayed and Enabled");
	        	}
	        else {
	        	System.out.println("Home link is not displayed");
	        }
	        
			
			
			WebElement Reports_lnk = createWebElementBy(lnk_Reports);
			if(Reports_lnk.isDisplayed() && Reports_lnk.isEnabled()) {
				 
			        	System.out.println("Reports link is displayed and Enabled");
			        	}
			        else {
			        	System.out.println("Reports link is not displayed");
			        }
			
			
				
			WebElement Metadatas_lnk = createWebElementBy(lnk_Metadatas);
			if(Metadatas_lnk.isDisplayed() && Metadatas_lnk.isEnabled()) {
				 
			        	System.out.println("Metadatas link is displayed and Enabled");
			        	}
			        else {
			        	System.out.println("Metadatas link is not displayed");
			        }
			
			WebElement AuditTrail_lnk = createWebElementBy(lnk_AuditTrail);
			if(AuditTrail_lnk.isDisplayed() && AuditTrail_lnk.isEnabled()) {
				 
			        	System.out.println("AuditTrail link is displayed and Enabled");
			        	}
			        else {
			        	System.out.println("AuditTrail link is not displayed");
			        }
			WebElement PSV_lnk = createWebElementBy(lnk_PSV);
			if(PSV_lnk.isDisplayed() && PSV_lnk.isEnabled()) {
				 
			        	System.out.println("PSV link is displayed and Enabled");
			        	}
			        else {
			        	System.out.println("PSV link is not displayed");
			        }
			WebElement Help_lnk = createWebElementBy(lnk_Help);
			if(Help_lnk.isDisplayed() && Help_lnk.isEnabled()) {
				 
			        	System.out.println("Help link is displayed and Enabled");
			        	}
			        else {
			        	System.out.println("Help link is not displayed");
			        }
			}
			
	}


  public void TM_TC03_Web_Pages_in_Menu_System_Accessible() 
  {
  
  WebElement Reports_lnk = createWebElementBy(lnk_Reports);
  mouseHover(Reports_lnk);
  
  WebElement SLE_lnk=createWebElementBy(lnk_SLE);
  SLE_lnk.click();
  String ActTitle =driver.getTitle();
  Assert.assertEquals(ActTitle,"Sample Listing Export Utility", "Sample Listing Export page not displayed");
  System.out.println("Sample Listing Export page displayed");
  
  }
  
  {
	  
	  WebElement Reports_lnk = createWebElementBy(lnk_Reports);
	  mouseHover(Reports_lnk);
	  
	  WebElement SLE_lnk=createWebElementBy(lnk_SLE);
	  SLE_lnk.click();
	  String ActTitle =driver.getTitle();
	  Assert.assertEquals(ActTitle,"Sample Listing Export Utility", "Sample Listing Export page not displayed");
	  System.out.println("Sample Listing Export page displayed");
	  
	  }
  
  
  
	/*
	 * public void TM_TC04_Web_Tabs_under_Data_Browser_Accessible() { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * public void TM_TC05_Web_Filters_applied_for_Tabs_Data_Browser() { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */
}

