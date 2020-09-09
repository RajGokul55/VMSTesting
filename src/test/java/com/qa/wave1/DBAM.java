

package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class DBAM extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sjdbamappdevg03.na.gilead.com:8443/#";
	final String Username ="psonawane";
	private String DecrptPassword;


	/***************************** Test Cases *******************/


	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void DBAM_S01_Web_BuildingReports() {
		TM_DBAM_S01_Web_BuildingReports();
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

	By ipt_Username= By.xpath("//input[@id='idx_form_TextBox_0']");
	By ipt_Passwrod= By.xpath("//input[@id='idx_app_LoginFrame_0Password']");
	By btn_Login = By.xpath("(//span[contains(text(),'Login')])[1]");
	By btn_reportsmenu= By.xpath("(//span[contains(text(),'Reports')])[1]");
	By btn_realtimereports=By.xpath("(//div[contains(text(),'Real-Time Guardium Operational Reports')])");
	By btn_sqlreports = By.xpath("//div[contains(text(),'-SQLActivity')]");
	By icn_runtimeparameters= By.xpath("//span[@class='dijitReset dijitInline dijitIcon configureIcon']");
	By slt_Dropdownreports = By.xpath("//div[@id='idx_widget_Dialog_0']");

	By slt_dropdowndataclick = By.xpath("//table[@id='idx_form_Select_16']");
	By slt_dropdowndatasource = By.xpath("((//div[contains(@class,'dijitReset dijitArrowButtonChar')])[2]");


		By btn_datasourceok = By.cssSelector("span[class='idxDialogActionBarEnd']>span:nth-child(1)");

	By btn_reviewonly = By.xpath("//span[contains(text(),'review-only')]");
	By btn_Signout = By.cssSelector("dijit_form_DropDownButton_37");
	
	By drp_Dropdown = By.cssSelector("td div[class='dijitInline'] tbody[role='presentation']:nth-child(1)");
	
	

	/*****************************Test Case Methods *******************/
	@SuppressWarnings("null")
	//For all WebElements may append type Example: Submit_Btn

	
	
/*******************Login page****************/
	
	void TM_DBAM_S01_Web_BuildingReports() {
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);
		try {
			DecrptPassword = decrypt("FHAUyqqPlNXn1JBMOnOw9g==");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();

		

		
		/******************building sql reports****************************/
		WebElement reports_Btn = createWebElementBy(btn_reportsmenu);
		reports_Btn.click();

		WebElement Realtimereports_Btn = createWebElementBy(btn_realtimereports);
		Realtimereports_Btn.click();
	
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();

		WebElement sqlreports_btn = createWebElementBy(btn_sqlreports);
		sqlreports_btn.click();
		waitForPageLoaded();
				
		
		WebElement runtimeparameters_btn = createWebElementBy(icn_runtimeparameters);
		runtimeparameters_btn.click();
		takeScreenshotAtEndOfTest();

		WebElement Dropdown_Drp = createWebElementBy(drp_Dropdown);		
		SelectDropdownValueByIndex(Dropdown_Drp, "sjdbamappdevg01.na.gilead.com");
	
		
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		
		WebElement datasourceok_btn = createWebElementBy(btn_datasourceok);
		datasourceok_btn.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		
		runtimeparameters_btn.click();
	
		WebElement Dropdown_Drp1 = createWebElementBy(drp_Dropdown);		
		SelectDropdownValueByIndex(Dropdown_Drp1,"sjdbamappdevg02.na.gilead.com");
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
	
		WebElement datasourceok_btn1 = createWebElementBy(btn_datasourceok);
		datasourceok_btn1.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		
		 
		 WebElement Dropdown_signout = createWebElementBy(btn_reviewonly);		
			SelectDropdownValueByIndex(Dropdown_signout,"Sign Out");
			takeScreenshotAtEndOfTest();
			waitForPageLoaded();

			
			}
	

	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here

	void SelectDropdownValueByIndex(WebElement element,String value) {

		element.click();


		By dropdownvalue = By.cssSelector("div[class='dijitPopup dijitMenuPopup'] tr");

		List<WebElement>  dropvalue= createWebElementsBy(dropdownvalue);

		for (WebElement dropVl: dropvalue) {
			System.out.println("Dropdown valu is : "+ dropVl.getText());
			if(dropVl.getText().equalsIgnoreCase(value)) {
				dropVl.click();	
				break;
			}
		}
	}

}




