package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GVDResearchReporting extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String TestURL = "http://fcgvdapptest01/gvd/DataBrowser.aspx";
	final String UAT_Url = "http://fcgvdappuat01/gvd";
	final String DevURL = "http://fcgvdappdev01/gvd/";
	final String ValURL = "http://drgvdgs2appval1/gvd/DataBrowser.aspx";
	final String ProdURL = "http://FCGVDGS2APPPRD1/GVD/ ";

	/***************************** Test Cases *******************/

	String URL = UAT_Url; // Change URl whichever Environment you want to execute.

	@Test(priority = 0, enabled = true)
	public void GVDGS2_S01_Web_UAT_UserLogin() {
		TM_GVDGS2_S01_Web_UAT_UserLogin(URL);
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	By lnk_Home = By.xpath("//span[contains(text(),'Home')]");
	By lnk_GVDRR = By.xpath("//a[@id='ctl00_hlDWVirology']");
	By lnk_HIV = By.xpath("//div[@class='rtTop']//span[@class='rtIn'][contains(text(),'HIV')]");
	By lnk_FTC = By.xpath("//span[contains(text(),'FTC-102')]");
	By lnk_Patient = By.xpath("//a[contains(text(),'Patient')]");

	/***************************** Test Case Methods *******************/

	void TM_GVDGS2_S01_Web_UAT_UserLogin(String url) {

		launchBrowser(Browser, url);
		WebElement GVDRR_lnk = createWebElementBy(lnk_GVDRR);
		GVDRR_lnk.click();

		WebElement HIV_lnk = createWebElementBy(lnk_HIV);
		HIV_lnk.click();

		WebElement FTC_lnk = createWebElementBy(lnk_FTC);
		FTC_lnk.click();

		WebElement Patient_lnk = createWebElementBy(lnk_Patient);
		String Acttext = Patient_lnk.getText();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(Acttext, "Patient", "Patient link is not displayed");

	}

}
