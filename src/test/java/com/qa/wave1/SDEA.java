package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SDEA extends CommonMethods {
	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String devUrl= "http://fcsgrappdev01/sdea/default.aspx";
	final String prdUrl = "http://fcsgrappprod01/agreementrepository/default.aspx";
	final String ActiveWinThirdPartyText = "Active Third Party Agreements";
	final String ActiveClinicalText = "Active Clinical Trial Safety Reporting Procedures";

	// input the values for the filter to search
	final String orgText = "A";
	final String typeText = "C";
	final String productText = "V";
	final String countryText = "Al";
	final String protocolText= "G";


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
	
	 String URL = devUrl;
	
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
	}

	@Test(priority=0, enabled=true)
	public void SDEA_S01_Web_Sort_Pharmacovigilance_Agreements() {
		TM_SDEA_S01_Web_Sort_Pharmacovigilance_Agreements();
	}

	@Test(priority=1, enabled=true)
	public void SDEA_S02_Web_Sort_Clinical_Trail_Safety() {
		TM_SDEA_S02_Web_Sort_Clinical_Trail_Safety();
	}

	@Test(priority=2, enabled=true)
	public void SDEA_S03_Web_Third_Party_Agreements() {
		TM_SDEA_S03_Web_Third_Party_Agreements();
	}

	@Test(priority=3, enabled=true)
	public void SDEA_S04_Web_Clinical_Trail_Safety() {
		TM_SDEA_S04_Web_Clinical_Trail_Safety();
	}

	@Test(priority=4, enabled=true)
	public void SDEA_S05_Web_Export_Options_Clinical_Trail_Safety() {
		TM_SDEA_S05_Web_Export_Options_Clinical_Trail_Safety();
		
	}
	

	@AfterMethod
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
	 * clh_: Column Header
	 */

	By lnk_pharmaAgreements		=	By.xpath("//span[@class='rtIn'][contains(text(),'Pharmacovigilance Agreements')]");
	By lnk_clinicalTrail		=	By.xpath("//span[@class='rtIn'][contains(text(),'Clinical Trial Safety Reporting Procedure')]");
	By msg_validText			=	By.cssSelector("#ctl00_mcph_lblTitle");
	By clh_organization			=	By.xpath("//a[contains(text(),'Organization')]");
	By btn_ascSort				=	By.className("rgSortAsc");
	By btn_descSort				=	By.className("rgSortDesc");
	By clh_type					=	By.xpath("//a[contains(text(),'Type')]");
	By clh_version				=	By.xpath("//a[contains(text(),'Version')]");
	By clh_effectivedate		=	By.xpath("//a[contains(text(),'Effective Date')]");
	By clh_protocol				=	By.xpath("//a[contains(text(),'Protocol')]");
	By btn_reports				=	By.cssSelector("#ctl00_ctlHeader_mainMenu_m2");
	By btn_thirdPartAgree		=	By.cssSelector("#ctl00_ctlHeader_mainMenu_m2_m0");
	By ipt_orgTextFilter		=	By.cssSelector("#rg_ctl00_ctl02_ctl02_FilterTextBox_Organization");
	By btn_orgFilter			=	By.cssSelector("#rg_ctl00_ctl02_ctl02_Filter_Organization");
	By msg_actThirdPartAgree	=	By.xpath("//b[contains(text(),'Active Third Party Agreements')]");
	By btn_noFilter				=	By.xpath("//span[contains(text(),'NoFilter')]");
	By btn_startsWith			=	By.xpath("//span[contains(text(),'StartsWith')]");
	By ipt_typeTextFilter		=	By.cssSelector("#rg_ctl00_ctl02_ctl02_FilterTextBox_Type");
	By btn_typeFilter			=	By.cssSelector("#rg_ctl00_ctl02_ctl02_Filter_Type");
	By ipt_productTextFilter	=	By.cssSelector("#rg_ctl00_ctl02_ctl02_FilterTextBox_ProductList");
	By btn_productFilter		=	By.cssSelector("#rg_ctl00_ctl02_ctl02_Filter_ProductList");
	By ipt_countryTextFilter	=	By.cssSelector("#rg_ctl00_ctl02_ctl02_FilterTextBox_CountryList");
	By btn_countryFilter		=	By.cssSelector("#rg_ctl00_ctl02_ctl02_Filter_CountryList");
	By msg_actClinicalProc		=	By.xpath("//b[contains(text(),'Active Clinical Trial Safety Reporting Procedures')]");
	By btn_clinicalTrail		=	By.cssSelector("#ctl00_ctlHeader_mainMenu_m2_m1");
	By ipt_protocolTextFilter	=	By.cssSelector("#rg_ctl00_ctl02_ctl02_FilterTextBox_Protocol");
	By btn_protocolFilter		=	By.cssSelector("#rg_ctl00_ctl02_ctl02_Filter_Protocol");
	By lnk_excelLink			=	By.cssSelector("#btnExcel");
	By lnk_pdfLink				=	By.cssSelector("#btnPDF");


	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn

	public void TM_SDEA_S01_Web_Sort_Pharmacovigilance_Agreements() {
		
		WebElement PharmaAgreements_Msg = createWebElementBy(msg_validText);
		String text = "Showing All Active Pharmacovigilance Agreements";
		Assert.assertEquals(PharmaAgreements_Msg.getText(), text);

		WebElement Organization_Clh = createWebElementBy(clh_organization);
		Assert.assertTrue(Organization_Clh.isDisplayed(), "The page is not loaded");
		//Organization_Clh.click();
		//sortTest();

		WebElement Type_Clh = createWebElementBy(clh_type);
		Assert.assertTrue(Type_Clh.isDisplayed(), "The page is not loaded");
		//Type_Clh.click();
		//sortTest();

		WebElement Version_Clh = createWebElementBy(clh_version);
		Assert.assertTrue(Version_Clh.isDisplayed(), "The page is not loaded");
		//Version_Clh.click();
		//sortTest();

		WebElement EffecDate_Clh = createWebElementBy(clh_effectivedate);
		Assert.assertTrue(EffecDate_Clh.isDisplayed(), "The page is not loaded");
		//EffecDate_Clh.click();
		//sortTest();

	}

	public void TM_SDEA_S02_Web_Sort_Clinical_Trail_Safety() {
		
		WebElement ClinicalTrail_Lnk = createWebElementBy(lnk_clinicalTrail);
		ClinicalTrail_Lnk.click();
		waitForPageLoaded();

		WebElement ClinicalTrail_Msg = createWebElementBy(msg_validText);
		String text = "Showing All Active Clinical Trial Safety Reporting Procedures";
		Assert.assertEquals(ClinicalTrail_Msg.getText(), text);

		WebElement Organization_Clh = createWebElementBy(clh_organization);
		Organization_Clh.click();
		sortTest();

		WebElement Protocol_Clh = createWebElementBy(clh_protocol);
		Protocol_Clh.click();
		sortTest();

		WebElement Version_Clh = createWebElementBy(clh_version);
		Version_Clh.click();
		sortTest();

		WebElement EffecDate_Clh = createWebElementBy(clh_effectivedate);
		EffecDate_Clh.click();
		sortTest();

	}

	public void TM_SDEA_S03_Web_Third_Party_Agreements() {
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		WebElement Reports_Btn = createWebElementBy(btn_reports);
		mouseHover(Reports_Btn);
		WebElement ThirdPartyAgree_Btn = createWebElementBy(btn_thirdPartAgree);
		mouseHover(ThirdPartyAgree_Btn);
		ThirdPartyAgree_Btn.click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		
		takeScreenshotAtEndOfTest();
		WebElement ActiveThirdParty_Msg = createWebElementBy(msg_actThirdPartAgree);
		Assert.assertEquals(ActiveThirdParty_Msg.getText(), ActiveWinThirdPartyText);

		WebElement OrgText_Ipt = createWebElementBy(ipt_orgTextFilter);
		OrgText_Ipt.sendKeys(orgText);
		orgFilter();


		WebElement TypeText_Ipt	= createWebElementBy(ipt_typeTextFilter);
		TypeText_Ipt.sendKeys(typeText);
		typeFilter();


		WebElement Products_Ipt = createWebElementBy(ipt_productTextFilter);
		Products_Ipt.sendKeys(productText);
		productFilter();


		WebElement Countries_Ipt = createWebElementBy(ipt_countryTextFilter);
		Countries_Ipt.sendKeys(countryText);
		countriesFilter();

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}

	public void TM_SDEA_S04_Web_Clinical_Trail_Safety() {
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		WebElement Reports_Btn = createWebElementBy(btn_reports);
		mouseHover(Reports_Btn);
		WebElement ClinicalTrail_Btn = createWebElementBy(btn_clinicalTrail);
		mouseHover(ClinicalTrail_Btn);
		ClinicalTrail_Btn.click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		takeScreenshotAtEndOfTest();
		WebElement ActiveClinicalProc_Msg = createWebElementBy(msg_actClinicalProc);
		Assert.assertEquals(ActiveClinicalProc_Msg.getText(), ActiveClinicalText);

		WebElement OrgText_Ipt = createWebElementBy(ipt_orgTextFilter);
		OrgText_Ipt.sendKeys(orgText);
		orgFilter();


		WebElement Products_Ipt = createWebElementBy(ipt_productTextFilter);
		Products_Ipt.sendKeys(productText);
		productFilter();


		WebElement Countries_Ipt = createWebElementBy(ipt_countryTextFilter);
		Countries_Ipt.sendKeys(countryText);
		countriesFilter();


		WebElement Protocol_Ipt = createWebElementBy(ipt_protocolTextFilter);
		Protocol_Ipt.sendKeys(protocolText);
		protocolFilter();

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}

	public void TM_SDEA_S05_Web_Export_Options_Clinical_Trail_Safety() {
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		WebElement Reports_Btn = createWebElementBy(btn_reports);
		mouseHover(Reports_Btn);
		WebElement ClinicalTrail_Btn = createWebElementBy(btn_clinicalTrail);
		mouseHover(ClinicalTrail_Btn);
		ClinicalTrail_Btn.click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		
		takeScreenshotAtEndOfTest();
		
		WebElement ExcelDownload_Lnk = createWebElementBy(lnk_excelLink);
		Assert.assertTrue(ExcelDownload_Lnk.isDisplayed(), "The Excel option is not available");
		
		WebElement PDFDownload_Lnk = createWebElementBy(lnk_pdfLink);
		Assert.assertTrue(PDFDownload_Lnk.isDisplayed(), "The PDF option is not available");
		
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

	}


	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here

	public void sortTest() {
		waitForPageLoaded();
		WebElement AscSort_Btn = createWebElementBy(btn_ascSort);
		AscSort_Btn.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
		WebElement DescSort_Btn = createWebElementBy(btn_descSort);
		DescSort_Btn.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();
	}

	public void orgFilter() {
		WebElement OrgFilter_Btn = createWebElementBy(btn_orgFilter);
		OrgFilter_Btn.click();
		WebElement StartsWith_Btn = createWebElementBy(btn_startsWith);
		mouseHover(StartsWith_Btn);
		StartsWith_Btn.click();
		WebElement OrgFilter1_Btn = createWebElementBy(btn_orgFilter);
		OrgFilter1_Btn.click();
		takeScreenshotAtEndOfTest();
		WebElement NoFilter_Btn = createWebElementBy(btn_noFilter);
		mouseHover(NoFilter_Btn);
		NoFilter_Btn.click();
	}

	public void typeFilter() {
		WebElement TypeFilter_Btn = createWebElementBy(btn_typeFilter);
		TypeFilter_Btn.click();
		WebElement StartsWith_Btn = createWebElementBy(btn_startsWith);
		mouseHover(StartsWith_Btn);
		StartsWith_Btn.click();
		WebElement TypeFilter1_Btn = createWebElementBy(btn_typeFilter);
		TypeFilter1_Btn.click();
		takeScreenshotAtEndOfTest();
		WebElement NoFilter_Btn = createWebElementBy(btn_noFilter);
		mouseHover(NoFilter_Btn);
		NoFilter_Btn.click();
	}

	public void productFilter() {
		WebElement ProductFilter_Btn = createWebElementBy(btn_productFilter);
		ProductFilter_Btn.click();
		WebElement StartsWith_Btn = createWebElementBy(btn_startsWith);
		mouseHover(StartsWith_Btn);
		StartsWith_Btn.click();
		WebElement ProductFilter1_Btn = createWebElementBy(btn_productFilter);
		ProductFilter1_Btn.click();
		takeScreenshotAtEndOfTest();
		WebElement NoFilter_Btn = createWebElementBy(btn_noFilter);
		mouseHover(NoFilter_Btn);
		NoFilter_Btn.click();
	}

	public void countriesFilter() {
		WebElement CountryFilter_Btn = createWebElementBy(btn_countryFilter);
		CountryFilter_Btn.click();
		WebElement StartsWith_Btn = createWebElementBy(btn_startsWith);
		mouseHover(StartsWith_Btn);
		StartsWith_Btn.click();
		WebElement CountryFilter1_Btn = createWebElementBy(btn_countryFilter);
		CountryFilter1_Btn.click();
		takeScreenshotAtEndOfTest();
		WebElement NoFilter_Btn = createWebElementBy(btn_noFilter);
		mouseHover(NoFilter_Btn);
		NoFilter_Btn.click();
	}

	public void protocolFilter() {
		WebElement ProtocolFilter_Btn = createWebElementBy(btn_protocolFilter);
		ProtocolFilter_Btn.click();
		WebElement StartsWith_Btn = createWebElementBy(btn_startsWith);
		mouseHover(StartsWith_Btn);
		StartsWith_Btn.click();
		WebElement ProtocolFilter1_Btn = createWebElementBy(btn_protocolFilter);
		ProtocolFilter1_Btn.click();
		takeScreenshotAtEndOfTest();
		WebElement NoFilter_Btn = createWebElementBy(btn_noFilter);
		mouseHover(NoFilter_Btn);
		NoFilter_Btn.click();
	}

}
