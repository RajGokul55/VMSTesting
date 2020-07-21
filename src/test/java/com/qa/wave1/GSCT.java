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

	@BeforeMethod(enabled = false)
	public void beforeTest() {

	}

	@Test(priority = 0, enabled = true)
	public void GSCT_S01_Web_NA_Prod_UserLogin() throws IOException {
		TM_GSCT_S01_Web_EU_Prod_ServerNodeValidation();

	}

	


	@AfterMethod
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	By ipt_euserverup = By.xpath(
			"//div[@id='ctl00_ctl00_ctl00_BodyContent_ContentPlaceHolder1_MainContentPlaceHolder_nodeResHost_resContainer_rptContainers_ctl00_rptColumn3_ctl00_ctl00_ResourceWrapper_resContent']//td[contains(text(),'Up')]");
	

	/***************************** Test Case Methods *******************/


	public void TM_GSCT_S01_Web_EU_Prod_ServerNodeValidation() throws IOException {
		
		final String Browser = "Chrome";
		final String EUProdURL = "http://gims-eu/Orion/NetPerfMon/NodeDetails.aspx?NetObject=N:3661";
		launchBrowser(Browser, EUProdURL);
		waitForPageLoaded();

		WebElement EUServerStatus_ipt = createWebElementBy(ipt_euserverup);
		String EUServerUp = EUServerStatus_ipt.getText();
		Assert.assertEquals(EUServerUp, "Up");

		takeScreenshotAtEndOfTest();

	}

}
	

	

	
