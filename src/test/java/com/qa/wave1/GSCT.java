package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GSCT extends CommonMethods {

	/***************************** Test Cases *******************/

	@BeforeMethod(enabled = true)
	public void beforeTest() {

	}

	@Test(priority = 0, enabled = true)
	public void GSCT_S01__NA_ServerNodeValidation() throws IOException {
		TM_GSCT_S01_Web_NA_ServerNodeValidation();
		
	}
	
	@Test(priority = 1, enabled = true)
	public void GSCT_S01_Web_EU_ServerNodeValidation() throws IOException {
		TM_GSCT_S01_Web_EU_ServerNodeValidation();
		
	}
	
	@Test(priority = 2, enabled = true)
	public void GSCT_S01_Web_eu_ServerNodeValidation() throws IOException {
		TM_GSCT_S01_Web_eu_ServerNodeValidation();
		
	}
	
	@Test(priority = 3, enabled = true)
	public void GSCT_S01_Web_AP_ServerNodeValidation() throws IOException {
		TM_GSCT_S01_Web_AP_ServerNodeValidation();
		
	}
	
	@AfterMethod(enabled = true)
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	By ipt_NAinterfaces = By.xpath("//a[contains(text(),'All Interfaces on the Selected Node')]");
	By ipt_NAserverup = By.xpath(
			"//div[@id='ctl00_ctl00_ctl00_BodyContent_ContentPlaceHolder1_MainContentPlaceHolder_nodeResHost_resContainer_rptContainers_ctl00_rptColumn3_ctl00_ctl00_ResourceWrapper_resContent']//td[contains(text(),'Up')]");
    By ipt_EUinterfaces = By.xpath("//a[contains(text(),'All Interfaces on the Selected Node')]");
	By ipt_EUserverup = By.xpath(
			"//div[@id='ctl00_ctl00_ctl00_BodyContent_ContentPlaceHolder1_MainContentPlaceHolder_nodeResHost_resContainer_rptContainers_ctl00_rptColumn3_ctl00_ctl00_ResourceWrapper_resContent']//td[contains(text(),'Up')]");
	By ipt_euinterfaces = By.xpath("//a[contains(text(),'All Interfaces on the Selected Node')]");
	By ipt_euserverup = By.xpath(
			"//div[@id='ctl00_ctl00_ctl00_BodyContent_ContentPlaceHolder1_MainContentPlaceHolder_nodeResHost_resContainer_rptContainers_ctl00_rptColumn3_ctl00_ctl00_ResourceWrapper_resContent']//td[contains(text(),'Up')]");
	By ipt_APinterfaces = By.xpath("//a[contains(text(),'All Interfaces on the Selected Node')]");
	By ipt_APserverup = By.xpath("//td[contains(text(),'Up')]");
	 

	/***************************** Test Case Methods *******************/
	
	public void TM_GSCT_S01_Web_NA_ServerNodeValidation() throws IOException {
		
		final String Browser = "Chrome";
		final String NAProdURL = "http://gims-na/Orion/NetPerfMon/NodeDetails.aspx?NetObject=N:3721";
		launchBrowser(Browser, NAProdURL);
		waitForPageLoaded();
		WebElement NAInterfaces_ipt = createWebElementBy(ipt_euinterfaces);
		scrollToWebElement(NAInterfaces_ipt);

		WebElement NAServerStatus_ipt = createWebElementBy(ipt_euserverup);
		String NAServerUp = NAServerStatus_ipt.getText();
		Assert.assertEquals(NAServerUp, "Up");
		takeScreenshotAtEndOfTest();
	}


	public void TM_GSCT_S01_Web_EU_ServerNodeValidation() throws IOException {
		
		final String Browser = "Chrome";
		final String EUProdURL = "http://gims-eu/Orion/NetPerfMon/NodeDetails.aspx?NetObject=N:3661";
		launchBrowser(Browser, EUProdURL);
		waitForPageLoaded();
		WebElement EUInterfaces_ipt = createWebElementBy(ipt_euinterfaces);
		scrollToWebElement(EUInterfaces_ipt);

		WebElement EUServerStatus_ipt = createWebElementBy(ipt_euserverup);
		String EUServerUp = EUServerStatus_ipt.getText();
		Assert.assertEquals(EUServerUp, "Up");
		takeScreenshotAtEndOfTest();

	}
	
	
	  public void TM_GSCT_S01_Web_eu_ServerNodeValidation() throws IOException {
	  
	  final String Browser = "Chrome"; 
	  final String euProdURL = "http://gims-eu/Orion/NetPerfMon/NodeDetails.aspx?NetObject=N:3658";
	  launchBrowser(Browser, euProdURL); 
	  waitForPageLoaded(); 
	  WebElement euInterfaces_ipt = createWebElementBy(ipt_euinterfaces);
	  scrollToWebElement(euInterfaces_ipt);
	  
	  WebElement euServerStatus_ipt = createWebElementBy(ipt_euserverup);
	  String euServerUp = euServerStatus_ipt.getText(); 
	  Assert.assertEquals(euServerUp,"Up"); 
	  takeScreenshotAtEndOfTest();
	  
	  }
	  
	  
	  
	  public void TM_GSCT_S01_Web_AP_ServerNodeValidation() throws IOException
	  {
	  
	  final String Browser = "Chrome"; 
	  final String APProdURL = "http://gims-ap/Orion/NetPerfMon/NodeDetails.aspx?NetObject=N:3656";
	  launchBrowser(Browser, APProdURL); 
	  waitForPageLoaded(); 
	  WebElement APInterfaces_ipt = createWebElementBy(ipt_APinterfaces);
	  scrollToWebElement(APInterfaces_ipt);
	  
	  WebElement APServerStatus_ipt = createWebElementBy(ipt_APserverup); 
	  String APServerUp = APServerStatus_ipt.getText(); 
	  Assert.assertEquals(APServerUp,"Up"); 
	  takeScreenshotAtEndOfTest();
	  
	  }
	 

}
	

	

	
