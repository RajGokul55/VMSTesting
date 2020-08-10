package com.qa.wave2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;


public class AssureNet extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "http://fcanetwebuat02.na.gilead.com/AssureNETGL/Dashboard/Prepare.aspx";
	final String Username ="psonawane";
	private String DecrptPassword;

	/***************************** Test Cases *******************/

	@BeforeMethod(enabled=true)
	public void beforeTest() {
		try {
			DecrptPassword = decrypt("e19ncVNSmW6OrHZf9mDsAg==");
		} catch (Exception e) {
			e.printStackTrace();
		}
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void Assurenet_Windows_Web_HealthCheck() {
		TM_Assurenet_Windows_Web_HealthCheck();
	}

	@AfterMethod(enabled=true)
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

	By ipt_Username= By.xpath("//input[@id='loginIdTextBox']");
	By ipt_Passwrod= By.xpath("//input[@id='passwordTextBox']");
	By btn_Login = By.xpath("//input[@id='loginButton']");
	By txt_User = By.cssSelector(".userLabel");
	By Menu_tab_Administrator = By.cssSelector(".menu_tab_sel");
	By btn_Administratortab = By.xpath("//a[@class='menu_level2'][contains(text(),'Administration')]");
	By btn_Maintainancetab = By.xpath("//a[@class='menu_level2'][contains(text(),'Maintenance')]");
	By btn_Interfacescheduler = By.xpath("//a[contains(text(),'XML Interface Schedules')]");
	By txt_InterfaceList = By.cssSelector(".dashBoxTitleText");
	By txt_Success = By.xpath("(//*[contains(text(),'Success')])[1]");
	By lnk_AcountList = By.xpath("//a[contains(text(),'Account List')]");
	By btn_Interfacelist = By.xpath("btn_Interfacescheduler]");
	By btn_Logout = By.xpath("//a[contains(text(),'Log Out')]");
	By img_Expand = By.cssSelector("img[src='http://fcanetwebuat02.na.gilead.com/AssureNETGL/images/toolbar/expand2.gif']");
	By txt_box_LegalEntity = By.cssSelector("#ucAccFilter_accountSegmentsDataList_ctl01_cbAccountSegment_Input");
	By btn_Apply = By.xpath("//span[contains(text(),'Apply')]");
	By txt_LERecord = By.xpath("(//td[contains(text(),'001')])[1]");

	/*******************Login page****************/

	void TM_Assurenet_Windows_Web_HealthCheck() {

		verifyUserLogin();
		verifyAdministratortab();
		verifyXMLIntefaceCluster();	
		verifyLegalEntitySearch();
	}

	void verifyUserLogin() {

		createWebElementBy(ipt_Username).sendKeys(Username);
		createWebElementBy(ipt_Passwrod).sendKeys(DecrptPassword);
		createWebElementBy(btn_Login).click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(createWebElementBy(txt_User).getText(), "Logged In: Pravin Sonawane");
	}

	void verifyAdministratortab() {

		createWebElementBy(Menu_tab_Administrator).click();
		waitForPageLoaded();
		Assert.assertEquals(createWebElementBy(btn_Administratortab).getText(), "Administration");
	}		

	void verifyXMLIntefaceCluster() {

		createWebElementBy(btn_Administratortab).click();
		createWebElementBy(btn_Interfacescheduler).click();
		waitForPageLoaded();	
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(createWebElementBy(txt_InterfaceList).getText(), "Interface List");
		Assert.assertEquals(createWebElementBy(txt_Success).getText(), "Success");
	}

	void verifyLegalEntitySearch() {

		createWebElementBy(btn_Maintainancetab).click();
		createWebElementBy(lnk_AcountList).click();
		waitForPageLoaded();
		createWebElementBy(img_Expand).click();
		waitForPageLoaded();
		createWebElementBy(txt_box_LegalEntity).sendKeys("001");
		createWebElementBy(btn_Apply).click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(createWebElementBy(txt_LERecord).getText(), "001");
		createWebElementBy(btn_Logout).click();			
	} 
}


