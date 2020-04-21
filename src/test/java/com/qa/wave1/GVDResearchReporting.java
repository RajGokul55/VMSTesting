package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GVDResearchReporting extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String TestURL = "http://fcgvdapptest01/gvd/DataBrowser.aspx";
	final String UAT_Url = "http://fcgvdappuat01/gvd";
	

	/*
	 * final String DevURL = "http://fcgvdappdev01/gvd/"; final String ValURL =
	 * "http://drgvdgs2appval1/gvd/DataBrowser.aspx"; final String ProdURL =
	 * "http://FCGVDGS2APPPRD1/GVD/ ";
	 */

	/***************************** Test Cases *******************/
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

	/***************************** UAT URL *******************/

	@Test(priority = 0, enabled = true)
	public void GVDGS2_S01_Web_UAT_UserLogin() {
		TM_GVDGS2_S01_Web_UAT_UserLogin(UAT_Url);
	}

	/***************************** TestURL *******************/

	@Test(priority = 1, enabled = true)
	public void GVDGS2_S06_Web_Test_UserLogin() {
		TM_GVDGS2_S01_Web_UAT_UserLogin(TestURL);
	}

	/***************************** DevURL *******************/
	/*
	 * 
	 * @Test(priority = 15, enabled = true) public void
	 * GVDGS2_S16_Web_Dev_UserLogin() { TM_GVDGS2_S01_Web_UAT_UserLogin(DevURL); }
	 * 
	 *//***************************** ValURL *******************/
	/*
	 * 
	 * @Test(priority = 10, enabled = true) public void
	 * GVDGS2_S11_Web_Val_UserLogin() { TM_GVDGS2_S01_Web_UAT_UserLogin(ValURL); }
	 * 
	 *//***************************** ProdURL *******************//*
																	 * 
																	 * @Test(priority = 20, enabled = true) public void
																	 * GVDGS2_S21_Web_Prod_UserLogin() {
																	 * TM_GVDGS2_S01_Web_UAT_UserLogin(ProdURL); }
																	 */

	/***************************** Locators *******************/
	/*
	 * // Example syntax:Css Selector: Tag //
	 * name[attribute1:'value1'][attribute2:'value2']
	 * 
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */

	By lnk_Home = By.xpath("//span[contains(text(),'Home')]");
	By lnk_GVDRR = By.xpath("//a[@id='ctl00_hlDWVirology']");
	By lnk_HIV = By.xpath("//div[@class='rtTop']//span[@class='rtIn'][contains(text(),'HIV')]");
	By lnk_FTC = By.xpath("//span[contains(text(),'FTC-102')]");
	By lnk_Patient = By.xpath("//a[contains(text(),'Patient')]");
	

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	void TM_GVDGS2_S01_Web_UAT_UserLogin(String url) {

		launchBrowser(Browser, url);
		WebElement GVDRR_lnk = createWebElementBy(lnk_GVDRR);
		GVDRR_lnk.click();
		
		Assert.assertEquals(driver.getTitle(), "Gilead Virology Database (GVD)");
		
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


