

package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class DBAM extends CommonMethods{

	private static final String WebElementDrop = null;
	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sjdbamappdevg03.na.gilead.com:8443/#";
	final String Username ="nnereddula";
	private String DecrptPassword;


	/***************************** Test Cases *******************/
	
  	/*Test Name Example: Filkart_05_Web_ValidateCredntails */
	@BeforeSuite(enabled=true)
	void EncriptPassword() throws Exception {
		DecrptPassword = decrypt("ZAzQ3KUtxVu2ss3Wyzp1Ng==");
	}

	@BeforeTest(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void DBAM_01_Web_BuildingReports() {
		TM_DBAM_01_Web_BuildingReports();
	}

		

	@AfterTest(enabled=true)
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

	By ipt_Username= By.xpath("//input[@id='idx_form_TextBox_0']");
	By ipt_Passwrod= By.xpath("//input[@id='idx_app_LoginFrame_0Password']");
	By btn_Login = By.xpath("(//span[contains(text(),'Login')])[1]");
	By btn_reportsmenu= By.xpath("(//span[contains(text(),'Reports')])[1]");
	By btn_realtimereports=By.xpath("(//div[contains(text(),'Real-Time Guardium Operational Reports')])");
	By btn_sqlreports = By.xpath("//div[contains(text(),'-SQLActivity')]");
	By icn_runtimeparameters= By.xpath("//span[contains(@class,'dijitReset dijitInline dijitIcon configureIcon')]");
	By slt_Dropdownreports = By.xpath("//div[@id='idx_widget_Dialog_0']");
	By slt_dropdowndataclick = By.xpath("//table[@id='idx_form_Select_16']");
	By slt_dropdowndatasource = By.xpath("(//span[contains(@class,'dojoxEllipsis')][contains(text(),'sjdbamappdevg01.na.gilead.com')])[5]");
	By btn_datasourceok = By.xpath("//span[contains(text(),'OK')][1]");
	By btn_reviewonly = By.xpath("//span[contains(text(),'review-only')]");
	By btn_Signout = By.cssSelector("dijitReset dijitMenuItemAccelKey");
	
	
	By drp_Dropdown = By.cssSelector("td div[class='dijitInline'] tbody[role='presentation']:nth-child(1)");
	//CssSelector = span[@class='idxDialogActionBarEnd']>span:nth-child(1)
	//div[class='dijitPopup dijitMenuPopup'] tr:nth-child(3)

	/*****************************Test Case Methods *******************/
	@SuppressWarnings("null")
	//For all WebElements may append type Example: Submit_Btn

	
	
/*******************Login page****************/
	
	void TM_DBAM_01_Web_BuildingReports() {
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		
		waitForPageLoaded();

		
		
		/******************building sql reports****************************/
		WebElement reports_Btn = createWebElementBy(btn_reportsmenu);
		reports_Btn.click();

		WebElement Realtimereports_Btn = createWebElementBy(btn_realtimereports);
		Realtimereports_Btn.click();

		waitForPageLoaded();
		
				
		WebElement sqlreports_btn = createWebElementBy(btn_sqlreports);
		sqlreports_btn.click();
				
		
		WebElement runtimeparameters_btn = createWebElementBy(icn_runtimeparameters);
		runtimeparameters_btn.click();
		
		WebElement Dropdown_Drp = createWebElementBy(drp_Dropdown);		
		SelectDropdownValueByIndex(Dropdown_Drp, 2);
		 
		
		//driver.findElement(By.xpath("//span[@id='dijit_form_Button_17_label']")).click();
		
		/*WebElement datasourceok_btn = createWebElementBy(btn_datasourceok);
		datasourceok_btn.click();
		wait(2);*/
		
		runtimeparameters_btn.click();
		

		
		WebElement Dropdown_Drp1 = createWebElementBy(drp_Dropdown);		
		SelectDropdownValueByIndex(Dropdown_Drp1, 3);
		
		
		WebElement datasourceok_btn1 = createWebElementBy(btn_datasourceok);
		datasourceok_btn1.click();
		
		
		 WebElement Reviewonly_Btn = createWebElementBy(btn_reviewonly);
		 Reviewonly_Btn.click();
		  
		  WebElement Signout_Btn = createWebElementBy(btn_Signout);
		 Signout_Btn.click();
		 
		 
		
		
	}
	

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here
	
	void SelectDropdownValueByIndex(WebElement element, int i) {
		
		int position = i+1;		
		
		String Csspath = "div[class='dijitPopup dijitMenuPopup'] tr:nth-child("+position+")";
		element.click();
		wait(2);
		
		WebElement DropValue = driver.findElement(By.cssSelector(Csspath));
		DropValue.click();
		wait(2);
		
	}
	
	
	
}
