package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import com.qa.demo.util.Retry;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Gvault extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sb-gilead-qualitydocs.veevavault.com";
	//final String Url_Dev= "https://sb-gilead-qualitydocs.veevavault.com";
	//final String Url_Test= "https://sb-gilead-it.veevavault.com"
	//final String Url_Val= "https://val-gilead.veevavault.com"
	//final String Url_Val= "https://val-gilead.com"
	
	final String Username ="psonawane@sb-gilead.com";

	/***************************** Test Cases *******************/
	/*
	 * Test case ‘Test Name’ naming convention: <AppName><TCNumber>_<TestCategory>_<Title>
	Definitions of terms:     
•	AppName: short name of Application [String 5 -10 chars] i.e., TstMyApp, 
•	TCNumber: Test case number [Numeric 2-3 digits] i.e, 01, 02,..
•	TestCategory: Test case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB …]
•	Title: short title of test case based on context of test case  ie., ValidateCredntails
  	Test Name Example: Filkart_05_Web_ValidateCredntails.

	 * Test method name must be same as test case appended with TM example: 
	 */

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true, retryAnalyzer = Retry.class)
	public void Gvault_TC03_Web_Create_Discrepancy(){
		TM_Gvault_TC03_Web_Create_Discrepancy();
	}

	@Test(priority=1, enabled=true, retryAnalyzer = Retry.class)
	public void Gvault_TC04_Web_Edit_Discrepancy(){
		TM_Gvault_TC04_Web_Edit_Discrepancy();
	}
	
	@Test(priority=1, enabled=false, retryAnalyzer = Retry.class)
	public void Gvault_TC05_Web_verifyValUrl(){
		TM_Gvault_TC05_Web_verifyValUrl();
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
	 */

	By ipt_Username= By.name("j_username");
	By btn_Continue = By.name("continue");
	By menu_Library= By.name("libraries__c"); 
	By lnk_Doc = By.cssSelector("div[class^='vm_container vv_vm']");
	By menu_AllDucuments = By.xpath("(//*[@class='viewLink label vv_secondary_nav_link'])[5]");

	By menu_ViewAll = By.xpath("//*[@class='viewAllCategories vv_view_all']");
	By menu_MediaFills = By.xpath("//*[@class='categoryTerm docClass vv_doc_class' and contains(text(), 'Media Fills')]");
	By menu_InFinalApproval_Doc = By.xpath("((//*[@class='docStatus vv_doc_status v_truncate_text' and contains(text(), "
			+ "'In Final Approval')])[1]//parent::div//preceding-sibling::div[@class='vv_doc_detail_body vv_col']//following::"
			+ "a[@class='docLink doc_link_large vv_doc_title_link'])[1]");
	By menu_Action = By.cssSelector(".doc_info_more_actions_menu.tourTarget.vv_button.vv_button_dropdown.tourTarget.DOCINFO_TOUR.DOCINFO_WKFLOWHIST_V7");
	By menu_ManageD = By.xpath("(//*[@class='menuTextTarget vv_menu_text' and contains(text(), 'Manage Discrepancies')])[2]");
	By menu_Add = By.xpath("//*[@class='vv_button_text' and contains(text(), 'Add')]");
	By ipt_Date = By.cssSelector("input.form-control");
	By ipt_DiscepancyDetails = By.cssSelector("textarea.form-control");
	By btn_Save = By.xpath("//*[@type='button' and contains(text(), 'Save')]");
	By btn_Expand = By.cssSelector(".vv_button_text.icon-plus");
	By btn_Edit = By.cssSelector("button#edit-button-1");
	By text_DiscrepancyDetails = By.xpath("//*[@class='control-label-read-only' and contains(text(),'Test')]");
	By btn_Delete = By.xpath("//*[@type='button' and contains(text(), 'Delete')]");
	By btn_DeletePopUp = By.cssSelector("button#delete");
	By text_MyVault = By.cssSelector(".Seleniumn-View-Title.viewTitle");
	
	/*****************************Test Case Methods 
	 * @throws IOException *******************/
	//For all WebElements may append type Example: Submit_Btn


	void TM_Gvault_TC03_Web_Create_Discrepancy(){

		Gvault_CommonFlow();

		WebElement Add_menu = createWebElementBy(menu_Add);
		Add_menu.click();
		
		WebElement Date_ipt= createWebElementBy(ipt_Date);
		Date_ipt.sendKeys("04/20/2020");
		
		WebElement DiscepancyDetails_ipt= createWebElementBy(ipt_DiscepancyDetails);
		DiscepancyDetails_ipt.sendKeys("Test_Added");
		
		WebElement Save_btn = createWebElementBy(btn_Save);
		Save_btn.click();
		
		WebElement DiscrepancyDetails_text = createWebElementBy(text_DiscrepancyDetails);
		String DDetails = DiscrepancyDetails_text.getText();
		
		wait(2);
		Assert.assertEquals(DDetails, "Test_Added", "Discrepancy not added successfully");
		
	}

	void TM_Gvault_TC04_Web_Edit_Discrepancy() {

		Gvault_CommonFlow();
		
		WebElement Expand_btn = createWebElementBy(btn_Expand);
		Expand_btn.click();
		
		wait(2);
		
		WebElement Edit_btn = createWebElementBy(btn_Edit);
		Edit_btn.click();
		
		WebElement DiscepancyDetails_ipt= createWebElementBy(ipt_DiscepancyDetails);
		DiscepancyDetails_ipt.clear();
		DiscepancyDetails_ipt.sendKeys("Test_Edited");
		
		WebElement Save_btn = createWebElementBy(btn_Save);
		Save_btn.click();
		
		WebElement DiscrepancyDetails_text = createWebElementBy(text_DiscrepancyDetails);
		String DDetails = DiscrepancyDetails_text.getText();
		
		wait(2);
		Assert.assertEquals(DDetails, "Test_Edited", "Discrepancy not added successfully");
		
		WebElement Delete_btn = createWebElementBy(btn_Delete);
		Delete_btn.click();
		
		WebElement Delete_PopUp = createWebElementBy(btn_DeletePopUp);
		Delete_PopUp.click();
		wait(3);
	}
	
	public void TM_Gvault_TC05_Web_verifyValUrl() {
		
		WebElement MyVault_text = createWebElementBy(text_MyVault);
		String MyVaultText = MyVault_text.getText();
		
		Assert.assertEquals(MyVaultText, "My Vaults", "Test case failed");
	}


	/*****************************Application Interaction Methods 
	 * @throws IOException *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here

	void Gvault_CommonFlow() {
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Continue_Btn = createWebElementBy(btn_Continue);
		Continue_Btn.click();

		WebElement Library_menu = createWebElementBy(menu_Library);
		Library_menu.click();

		wait(2);

		WebElement Documents_menu = driver.findElement(lnk_Doc);
		mouseHover(Documents_menu);	
		Documents_menu.click();

		wait(2);
		WebElement AllDucuments_menu = createWebElementBy(menu_AllDucuments);
		AllDucuments_menu.click();

		wait(2);

		WebElement InFinalApproval_Doc = createWebElementBy(menu_InFinalApproval_Doc);
		mouseHover(InFinalApproval_Doc);
		wait(2);
		InFinalApproval_Doc.click();

		wait(2);

		WebElement Action_menu = createWebElementBy(menu_Action);
		Action_menu.click();
		wait(2);
		WebElement ManageD_menu = createWebElementBy(menu_ManageD);
		mouseHover(ManageD_menu);
		wait(2);
		ManageD_menu.click();

		windowhandle();

	}

}
