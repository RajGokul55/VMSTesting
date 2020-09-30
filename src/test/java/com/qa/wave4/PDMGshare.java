package com.qa.wave4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class PDMGshare extends CommonMethods {
	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String TRURL = "https://sbxcollaborate.gilead.com/pdm/AO/Lists/TravelRequests/NewForm.aspx?Source=https%3A%2F%2Fsbxcollaborate%2Egilead%2Ecom%2Fpdm%2FAO%2FLists%2FTravelRequests%2FAllItems%2Easpx&RootFolder=";
	final String AOURL = "https://testcollaborate.gilead.com/pdm/Pages/Home.aspx";
	final String SPURL = "https://testcollaborate.gilead.com/pdm/LIS/LISLeadershipTeam/Forms/AllItems.aspx";
	final String LOURL = "https://testcollaborate.gilead.com/pdm/LIS/LO/Pages/Home.aspx";
	final String GFURL = "https://testcollaborate.gilead.com/pdm/LIS/GForce/Pages/Home.aspx";
	final String LISURL = "https://testcollaborate.gilead.com/pdm/LIS/Pages/Default.aspx";


	/***************************** Test Cases *******************/
	/*
	 * Test case ‘Test Name’ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: • AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, • TCNumber:
	 * Test case number [Numeric 2-3 digits] i.e, 01, 02,.. • TestCategory: Test
	 * case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve,
	 * DB …] • Title: short title of test case based on context of test case ie.,
	 * ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails.
	 * 
	 * Test method name must be same as test case appended with TM example:
	 */



	@Test(priority=1, enabled=false)
	public void PDMGSHARE_S01_Web_Validate_Travel_Request() {
		TM_S01_Web_Validate_Travel_Request();
	}

	@Test(priority=2, enabled=false)
	public void PDMGSHARE_S02_Web_Validate_PDM_UI() {
		TM_S02_Web_Validate_PDM_UI();
	}

	@Test(priority=3, enabled=false)
	public void PDMGSHARE_S03_Web_Validate_Site_Content() {
		TM_S03_Web_Validate_Site_Content();
	}

	@Test(priority=4, enabled=false)
	public void PDMGSHARE_S04_Web_Validate_Image_Graphs() {
		TM_S04_Web_Validate_Image_Graphs();
	}

	@Test(priority=5, enabled=true)
	public void PDMGSHARE_S05_Web_Validate_Hyperlinks() {
		TM_S05_Web_Validate_Hyperlinks();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 * txt_: Text
	 * crd_: Card
	 */

	By ipt_Requestor		=	By.cssSelector("input[class*='sp-peoplepicker'][title*='Requestor']");
	By ipt_tstartdate		=	By.cssSelector("input[id*='TravelStartDate'][title*='Travel Start Date']");
	By ipt_tenddate			=	By.cssSelector("input[id*='TravelEndDate'][title*='Travel End Date']");
	By drp_traveltype		=	By.cssSelector("select[id*='TripType']");	
	By ipt_destination		=	By.cssSelector("input[id*='Site'][title*='Destination']");
	By ipt_purpose			=	By.cssSelector("textarea[id*='Purpose']");
	By drp_approver			=	By.cssSelector("select[id*='Director'][title*='Primary Approver Required']");
	By btn_submit 			=	By.className("customSaveBtn");
	By msg_error			=	By.cssSelector("#errorMsg");

	By img_pdmmap			=	By.cssSelector("img[alt*='PDMMap']");
	By lnk_keycontacts		=	By.id("_PDMHomePgKeyContacts");
	By lnk_pdmportal		=	By.xpath("//span[contains(text(),'PDM Portal')]");
	By lnk_pdmseminars		=	By.xpath("//a[contains(text(),'PDM Seminars')]");
	By lnk_analytical		=	By.xpath("//span[contains(text(),'Analytical Operations')]");
	By lnk_aoportal			=	By.xpath("//li[contains(text(),'AO Portal')]");
	By lnk_cdmo				=	By.xpath("//span[contains(text(),'Chemical, Development & Manufacturing Operations')]");
	By lnk_cdmoportal		=	By.xpath("//li[contains(text(),'CDMO Portal')]");
	By lnk_gileadevents		=	By.xpath("//a[contains(text(),'Gilead Events')]");
	By txt_upcoming			=	By.xpath("//h2[contains(text(),'Upcoming State of Gilead Meetings')]");

	By lnk_excelsheet		=	By.xpath("//a[contains(text(),'VMS Testing - Excel Sheet')]");
	By lnk_powerpoint		=	By.xpath("//a[contains(text(),'VMS Testing - Post Patch Testing')]");
	By txt_column			=	By.xpath("//div[contains(text(),'Column 1')]");

	By img_graph			=	By.cssSelector("#highcharts-0");
	By img_bannerimg		=	By.xpath("//div[@class='psgTopContainer']//img");

	By lnk_LES				=	By.xpath("//div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/a[1]");
	By txt_LES				=	By.xpath("//h2[contains(text(),'Laboratory Execution System')]");
	By btn_sites			=	By.xpath("//span[@class='menu-item-text'][contains(text(),'Sites')]");
	By lnk_AO				=	By.xpath("//span[contains(text(),'AO Laboratory Operations')]");





	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_S01_Web_Validate_Travel_Request() {
		launchBrowser("chrome", TRURL);
		String Title = driver.getTitle();
		Assert.assertEquals("Travel Requests - New Item", Title);

		WebElement Requestor_Ipt = createWebElementBy(ipt_Requestor);
		Requestor_Ipt.click();
		Requestor_Ipt.sendKeys("Gokul Raj (Contractor)");
		wait(2);
		Requestor_Ipt.sendKeys(Keys.ARROW_DOWN);
		Requestor_Ipt.sendKeys(Keys.ENTER);

		WebElement StartDate_Ipt = createWebElementBy(ipt_tstartdate);
		StartDate_Ipt.sendKeys(currentDate());

		WebElement EndDate_Ipt = createWebElementBy(ipt_tenddate);
		EndDate_Ipt.sendKeys("08/13/2020");

		WebElement TravelType_Drp = createWebElementBy(drp_traveltype);
		selectDropdownValue(TravelType_Drp, "Other");

		WebElement Destination_Ipt = createWebElementBy(ipt_destination);
		Destination_Ipt.sendKeys("Test");

		WebElement Purpose_Ipt = createWebElementBy(ipt_purpose);
		Purpose_Ipt.sendKeys("Post patch Testing - VMS Team....Please reject");

		WebElement Approver_Drp = createWebElementBy(drp_approver);
		selectDropdownValue(Approver_Drp, "Vivek Kothapalli (Contractor)");

		WebElement Submit_Btn = createWebElementBy(btn_submit);
		Submit_Btn.click();
		takeScreenshotAtEndOfTest();

		WebElement Error_Msg = createWebElementBy(msg_error);
		scrollToWebElement(Error_Msg);
		takeScreenshotAtEndOfTest();
		Assert.assertEquals("Start Date is greater than the End Date.", Error_Msg.getText());

		WebElement EndDate1_Ipt = createWebElementBy(ipt_tenddate);
		EndDate1_Ipt.clear();
		EndDate1_Ipt.sendKeys(tomorrowDate());

		WebElement Submit1_Btn = createWebElementBy(btn_submit);
		Submit1_Btn.click();
		takeScreenshotAtEndOfTest();
	}

	public void TM_S02_Web_Validate_PDM_UI() {
		launchBrowser("Chrome", AOURL);
		String Title = driver.getTitle();
		Assert.assertEquals("Pages - PDM", Title);
		takeScreenshotAtEndOfTest();

		WebElement PDMImage_Img = createWebElementBy(img_pdmmap);
		IsDisplayed_IsEnabled(PDMImage_Img);
		takeScreenshotAtEndOfTest();

		WebElement KeyContacts_Lnk = createWebElementBy(lnk_keycontacts);
		IsDisplayed_IsEnabled(KeyContacts_Lnk);
		takeScreenshotAtEndOfTest();

		WebElement PDMPortal = createWebElementBy(lnk_pdmportal);
		PDMPortal.click();

		WebElement PDMSeminars_Lnk = createWebElementBy(lnk_pdmseminars);
		IsDisplayed_IsEnabled(PDMSeminars_Lnk);
		takeScreenshotAtEndOfTest();

		WebElement Analytical_Lnk = createWebElementBy(lnk_analytical);
		Analytical_Lnk.click();

		WebElement AOPortal_Lnk = createWebElementBy(lnk_aoportal);
		IsDisplayed_IsEnabled(AOPortal_Lnk);
		takeScreenshotAtEndOfTest();

		WebElement CDMO_Lnk = createWebElementBy(lnk_cdmo);
		CDMO_Lnk.click();

		WebElement CDMOPortal_Lnk = createWebElementBy(lnk_cdmoportal);
		IsDisplayed_IsEnabled(CDMOPortal_Lnk);
		takeScreenshotAtEndOfTest();

		WebElement GileadEvents_Lnk = createWebElementBy(lnk_gileadevents);
		GileadEvents_Lnk.click();
		waitForPageLoaded();

		WebElement Upcoming_Txt = createWebElementBy(txt_upcoming);
		IsDisplayed_IsEnabled(Upcoming_Txt);
		takeScreenshotAtEndOfTest();
	}

	public void TM_S03_Web_Validate_Site_Content() {
		launchBrowser("Chrome", SPURL);
		String Title = driver.getTitle();
		Assert.assertEquals("LIS Leadership Team - All Documents", Title);
		takeScreenshotAtEndOfTest();

		scrollToBottomOfHTML();
		WebElement ExcelSheet_Lnk = createWebElementBy(lnk_excelsheet);
		ExcelSheet_Lnk.click();
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();

		WebElement Column_Txt = createWebElementBy(txt_column);
		IsDisplayed_IsEnabled(Column_Txt);
		driver.navigate().back();
		scrollToBottomOfHTML();

		WebElement PowerPoint_Lnk = createWebElementBy(lnk_powerpoint);
		PowerPoint_Lnk.click();
		waitForPageLoaded();
		String Title1 = driver.getTitle();
		Assert.assertEquals("VMS Testing - Post Patch Testing.pptx", Title1);

		driver.navigate().back();
		driver.quit();


	}

	public void TM_S04_Web_Validate_Image_Graphs() {
		launchBrowser("Chrome", LOURL);
		String Title = driver.getTitle();
		Assert.assertEquals("AO Laboratory Operations", Title);
		takeScreenshotAtEndOfTest();

		WebElement Graph_Img = createWebElementBy(img_graph);
		scrollToWebElement(Graph_Img);
		IsDisplayed_IsEnabled(Graph_Img);
		takeScreenshotAtEndOfTest();

		driver.get(GFURL);
		waitForPageLoaded();
		String Title1 = driver.getTitle();
		Assert.assertEquals("GForce", Title1);
		takeScreenshotAtEndOfTest();

		WebElement Banner_Img = createWebElementBy(img_bannerimg);
		IsDisplayed_IsEnabled(Banner_Img);
		takeScreenshotAtEndOfTest();

	}

	public void TM_S05_Web_Validate_Hyperlinks() {
		launchBrowser("Chrome", LISURL);
		String Title = driver.getTitle();
		Assert.assertEquals("Laboratory Information Systems", Title);
		takeScreenshotAtEndOfTest();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		WebElement LES_Lnk = createWebElementBy(lnk_LES);
		LES_Lnk.click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		waitForPageLoaded();
		WebElement LES_Txt = createWebElementBy(txt_LES);
		System.out.println(LES_Txt.getText());
		Assert.assertEquals(" Laboratory Execution System", LES_Txt.getText());
		takeScreenshotAtEndOfTest();


		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		WebElement Site_Btn = createWebElementBy(btn_sites);
		Site_Btn.click();
		
		WebElement AO_Lnk = createWebElementBy(lnk_AO);
		AO_Lnk.click();
		Assert.assertEquals("AO Laboratory Operations", driver.getTitle());


	}



	/************************** Generic Test Cases ******************************/
	public String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentdate = dateFormat.format(date);
		return currentdate;
	}
	public String tomorrowDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR,  1);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String tomorrowdate = dateFormat.format(tomorrow);
		return tomorrowdate;
	}
}
