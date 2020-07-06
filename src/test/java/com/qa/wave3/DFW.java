package com.qa.wave3;


import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class DFW extends CommonMethods{

	
	/***************************** Test Cases *******************/
	
	

	@BeforeMethod(enabled=true)
	public void beforeTest() {

	}


	@Test(priority=0, enabled=true)
	public void DFW_S01_PostPatch_Testing() throws IOException, InterruptedException {
		TM_DFW_S01_PostPatch_Testing();
	}


	@AfterMethod(enabled = true)
	public void afterEveryTest() {
		driver.quit();
	}

	
	
/*******************Login page****************/
	
	
		public void TM_DFW_S01_PostPatch_Testing() throws IOException, InterruptedException {

			final String Browser = "IE";
			final String URL = "http://gsn:8080/start.html";
			launchBrowser(Browser, URL);
			waitForPageLoaded();
			Thread.sleep(50000);
			takeScreenshotAtEndOfTest();

		}
		}
		
		
	
	

	