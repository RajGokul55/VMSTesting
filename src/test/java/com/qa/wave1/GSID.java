package com.qa.wave1;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class GSID extends CommonMethods {
	/***************************** Test Data*******************/
	
	final String Browser= "Chrome";
	final String Url= "https://gsid.gilead.com/";
	
	
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
  public void GSID_S01_Web_User_authentication_via_SSO() {
	  TM_GSID_S01_Web_User_authentication_via_SSO();
  }
  
  @Test(priority=1, enabled=true)
  public void GSID_S02_Web_ClusterRegions_verification() {
	  TM_GSID_S02_Web_ClusterRegions_verification();
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
	 * clh_: Column Header
	 */

	By btn_loginWithSSO		=	By.cssSelector("a.button.blue-button.expand.sso-link");
	By msg_title			=	By.cssSelector("h2.pageTitle");
	By tbl_clusterTable		=	By.xpath("//section[1]/div[2]/table[1]/tbody[1]/tr");
	
	
	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn
	
	
	public void TM_GSID_S01_Web_User_authentication_via_SSO(){
		loginWithSSO();
		WebElement Title_Msg = createWebElementBy(msg_title);
		System.out.println("The Title displayed on the screen is : "+Title_Msg.getText());
		Assert.assertEquals(Title_Msg.getText(), "Cluster Management");
	}
	
	public void TM_GSID_S02_Web_ClusterRegions_verification() {
		loginWithSSO();
		List<String> expectedConnectionStatus = new ArrayList<String>();
		List<String> expectedConditionStatus = new ArrayList<String>();
		
		List<String> allClusters = new ArrayList<String>();
		List<String> connectionStatus = new ArrayList<String>();
		List<String> conditionStatus = new ArrayList<String>();
		
		//To get the Number of Rows in the Clusters displayed on screen
		List<WebElement> allRows = createWebElementsBy(tbl_clusterTable);
		int numberOfRows = allRows.size();
		System.out.println("The Number of rows are :: "+numberOfRows);

		//creating expected connection and condition string for the number of rows
		for(int i = 1;i<=numberOfRows;i++) {
			String result = "Connected";
			String result1 = "Operational";
			expectedConnectionStatus.add(result);
			expectedConditionStatus.add(result1);
		}

		//Getting actual values of cluster status from the rows
		for(int i=1;i<=numberOfRows;i++) {
			
			String clusterName = driver.findElement(By.xpath("//table[1]/tbody[1]/tr["+i+"]/td[1]/div[1]/div[1]/p[1]")).getText();
			allClusters.add(clusterName);
			String condition = driver.findElement(By.xpath("//table[1]/tbody[1]/tr["+i+"]/td[1]/div[1]/div[1]/p[2]")).getText();
			conditionStatus.add(condition);
			String connection = driver.findElement(By.xpath("//table[1]/tbody[1]/tr["+i+"]/td[1]/div[1]/div[2]/p[2]")).getText();
			connectionStatus.add(connection);
			
			System.out.println(clusterName +"   "+ condition +"   "+ connection);
		}
		
		Assert.assertEquals(connectionStatus, expectedConnectionStatus);
		Assert.assertEquals(conditionStatus, expectedConditionStatus);
		
	}
	
	/******************************* Methods ***************************/
	public void loginWithSSO() {
		WebElement LoginWithSSo_Btn = createWebElementBy(btn_loginWithSSO);
		LoginWithSSo_Btn.click();
		waitForPageLoaded();
	}

}
