package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




public class ILMH extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://ilmh.gilead.com/IdentityManagement/aspx/users/AllPersons.aspx";
	
	/***************************** Test Cases *******************/


	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void ILMH_S02_Web_Postpatching_verification() {
		TM_ILMH_S02_Web_Postpatching_verification();
	}


		
	@AfterMethod(enabled=true)
	public void afterTest() {
		driver.quit();
	}


/***************************** Locators *******************/
//Example syntax:Css Selector: tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 */

By btn_myprofile = By.xpath("//a[contains(text(),'My Profile')]");
By btn_authentication = By.xpath("//a[contains(text(),'Authentication Workflow Registration')]");
By btn_closeprofile = By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']");
By btn_Home = By.xpath("//a[contains(text(),'Home')]");


		
/*******************Login page****************/

void TM_ILMH_S02_Web_Postpatching_verification() {
	takeScreenshotAtEndOfTest();
	WebElement myprofile_btn = createWebElementBy(btn_myprofile);
	myprofile_btn.click();
	takeScreenshotAtEndOfTest();
	wait(2);
	
	WebElement closeprofile_btn = createWebElementBy(btn_closeprofile);
	closeprofile_btn.click();
	wait(2);
	
	WebElement authentication_btn = createWebElementBy(btn_authentication);
	authentication_btn.click();
	takeScreenshotAtEndOfTest();
	wait(2);
	
	WebElement home_btn = createWebElementBy(btn_Home);
	home_btn.click();
	takeScreenshotAtEndOfTest();

}
}

		

		

		
		