package com.qa.wave1;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;



public class Gview extends CommonMethods{

	/***************************** Test Data*******************/

	final String Browser= "Chrome";
	final String TstUrl= "http://savante-test.gilead.com";
	final String DevUrl= "http://savante-dev.gilead.com";
	final String PrdUrl = "http://savante.gilead.com";
	final String Username ="graj";
	private String DecrptPassword;



	/***************************** Test Cases *******************/
	/*
	 * Test case â€˜Test Nameâ€™ naming convention: <AppName><TCNumber>_<TestCategory>_<Title>
	Definitions of terms:     
â€¢	AppName: short name of Application [String 5 -10 chars] i.e., TstMyApp, 
â€¢	TCNumber: Test case number [Numeric 2-3 digits] i.e, 01, 02,..
â€¢	TestCategory: Test case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB â€¦]
â€¢	Title: short title of test case based on context of test case  ie., ValidateCredntails
  	Test Name Example: Filkart_05_Web_ValidateCredntails.

	 * Test method name must be same as test case appended with TM example: 
	 */

	String URL = PrdUrl;
	@BeforeSuite(enabled=true)
	void EncriptPassword() throws Exception {
		DecrptPassword = decrypt("uyK8jwlrhC6ELFzIelj5Bw==");
	}

	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, URL);
	}

	@Test(priority=0, enabled=true)
	public void Gview_TC01_Web_Login_Verification() {
		TM_Gview_TC01_Web_Login_Verification();
	}

	@Test(priority=1, enabled=true)
	public void Gview_TC02_Web_Window_Verification() {
		TM_Gview_TC02_Web_Window_Verification();
	}


	@Test(priority=2, enabled=true) 
	public void Gview_TC03_Web_Export_Verification() { 
		TM_Gview_TC03_Web_Export_Verification();

	}

	@Test(priority=3, enabled=true)
	public void Gview_TC04_Web_StringVerification_Verification() {
		TM_Gview_TC04_Web_StringVerification_Verification();

	}

	@Test(priority=4, enabled=true)
	public void Gview_TC05_Web_Tab_Verification() {
		TM_Gview_TC05_Web_Tab_Verification();

	}


	@Test(priority=5, enabled=true)
	public void Gview_TC06_Web_Filter_Verification() {
		TM_Gview_TC06_Web_Filter_Verification();

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

	By ipt_Username= By.xpath("//input[@id='userId']");
	By ipt_Passwrod= By.xpath("//input[@id='password']");
	By btn_Login = By.xpath("//input[@id='submit']");
	By btn_Search = By.xpath("//input[@id='search']");
	By chk_Study = By.xpath("//input[@id='studydata0']");
	By tbl_Study =By.xpath("//div[@class='contentTable']");
	By btn_EditStudy = By.xpath("//td[@class='buttons']//input[1]");
	By tab_TrialSummary = By.xpath("//span[contains(text(),'Trial Summary')]");
	By tab_Groups = By.xpath("//span[contains(text(),'Groups')]");
	By tab_Animals = By.xpath("//span[contains(text(),'Animals')]");

	By tab_TrialElement = By.xpath("//span[contains(text(),'Trial Element')]");
	By tab_TrialArm = By.xpath("//span[contains(text(),'Trial Arm')]");
	By tab_TrialSet = By.xpath("//span[contains(text(),'Trial Set')]");
	By tab_DosingSpecifications = By.xpath("//span[contains(text(),'Dosing Specifications')]");
	By tab_Phase =By.xpath("//span[contains(text(),'Phase')]");

	By tab_StudySetup = By.xpath("//a[contains(text(),'Study Setup')]");
	By tab_SendDataset = By.xpath("//div[@id='sidebar']//a[contains(text(),'SEND')]");
	By btn_Test = By.xpath("//input[@id='test']");
	By btn_Exporttocsv = By.xpath("//table[@class='buttons']//td[1]//input[1]");
	By txt_URL = By.xpath("//input[@id='url']");
	By tab_Output = By.xpath("//a[@class='hasChild']");
	By dpd_SendOutputMapping = By.xpath("//a[contains(text(),'SEND Output Mapping')]");
	By dpd_Domain = By.xpath("//select[@id='domian']");
	By btn_View = By.xpath("//input[@class='button']");
	By tbl_Domain = By.xpath("//tr[3]//td[1]");




	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn

	public void TM_Gview_TC01_Web_Login_Verification() {
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		wait(2);
		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		String title = getTitle();
		System.out.println("title is"+title);
		Assert.assertEquals(title, "Savante - Studies");

		wait(2);
		WebElement Search_Btn = createWebElementBy(btn_Search);
		Search_Btn.click();

		wait(2);
		WebElement Study_Chk = createWebElementBy(chk_Study);
		Study_Chk.click();

		wait(2);
		WebElement Study_Tbl = createWebElementBy(tbl_Study);
		Assert.assertEquals(true,Study_Tbl.isDisplayed());


	}

	public void TM_Gview_TC02_Web_Window_Verification() {
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		wait(2);
		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		String title = getTitle();
		System.out.println("title is"+title);
		Assert.assertEquals(title, "Savante - Studies");

		wait(2);
		WebElement Search_Btn = createWebElementBy(btn_Search);
		Search_Btn.click();

		wait(2);
		WebElement Study_Chk = createWebElementBy(chk_Study);
		Study_Chk.click();

		wait(2);
		WebElement EditStudy_Btn = createWebElementBy(btn_EditStudy);
		EditStudy_Btn.click();

		wait(2);
		String title1 = getTitle();
		System.out.println("title is"+title1);
		Assert.assertEquals(title1, "Savante - Studies - Study Definition");


	}

	public void TM_Gview_TC03_Web_Export_Verification() {

		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		wait(2);
		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		String title = getTitle();
		System.out.println("title is"+title);
		Assert.assertEquals(title, "Savante - Studies");

		wait(2);
		WebElement Search_Btn = createWebElementBy(btn_Search);
		Search_Btn.click();

		wait(2);
		WebElement Study_Chk = createWebElementBy(chk_Study);
		Study_Chk.click();

		wait(2);
		WebElement EditStudy_Btn = createWebElementBy(btn_EditStudy);
		EditStudy_Btn.click();

		wait(2);
		WebElement TrialSummary_Tab = createWebElementBy(tab_TrialSummary);
		TrialSummary_Tab.click();

		wait(2);
		WebElement Export_Btn = createWebElementBy(btn_Exporttocsv);
		Export_Btn.click();

		wait(10);
		String downloadPath = "C:\\Users\\graj\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		Assert.assertTrue(fileName.contains("graj"));

	}


	public void TM_Gview_TC04_Web_StringVerification_Verification() {

		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		wait(2);
		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		String title = getTitle();
		System.out.println("title is"+title);
		Assert.assertEquals(title, "Savante - Studies");



		wait(2);
		WebElement StudySetup_Tab = createWebElementBy(tab_StudySetup);
		StudySetup_Tab.click();

		wait(2);
		WebElement SendDS_Tab = createWebElementBy(tab_SendDataset);
		SendDS_Tab.click();



		wait(2);
		WebElement URL_Txt = createWebElementBy(txt_URL);
		String Text = URL_Txt.getText();


		WebElement Test_Btn = createWebElementBy(btn_Test);
		Test_Btn.click();

		WebElement URL_Txt1 = createWebElementBy(txt_URL);
		String Text1 = URL_Txt1.getText();
		Assert.assertEquals(Text, Text1);


	}

	public void TM_Gview_TC05_Web_Tab_Verification() {

		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		wait(2);
		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		String title = getTitle();
		System.out.println("title is"+title);
		Assert.assertEquals(title, "Savante - Studies");

		wait(2);
		WebElement Search_Btn = createWebElementBy(btn_Search);
		Search_Btn.click();

		wait(2);
		WebElement Study_Chk = createWebElementBy(chk_Study);
		Study_Chk.click();

		wait(2);
		WebElement EditStudy_Btn = createWebElementBy(btn_EditStudy);
		EditStudy_Btn.click();

		wait(2);
		String title1 = getTitle();
		System.out.println("title is"+title1);
		Assert.assertEquals(title1, "Savante - Studies - Study Definition");

		wait(2);
		WebElement TrialSummary_Tab = createWebElementBy(tab_TrialSummary);
		TrialSummary_Tab.click();

		wait(2);
		String title2 = getTitle();
		System.out.println("title is"+title2);
		Assert.assertEquals(title2, "Savante - Studies - Trial Summary Definition");

		wait(2);
		WebElement Groups_Tab = createWebElementBy(tab_Groups);
		Groups_Tab.click();

		wait(2);
		String title3 = getTitle();
		System.out.println("title is"+title3);
		Assert.assertEquals(title3, "Savante - Studies - Group Definition");

		wait(2);
		WebElement Animals_Tab = createWebElementBy(tab_Animals);
		Animals_Tab.click();

		wait(2);
		String title4 = getTitle();
		System.out.println("title is"+title4);
		Assert.assertEquals(title4, "Savante - Studies - Animal Definition");

		wait(2);
		WebElement TrialElement_Tab = createWebElementBy(tab_TrialElement);
		TrialElement_Tab.click();

		wait(2);
		String title5 = getTitle();
		System.out.println("title is"+title5);
		Assert.assertEquals(title5, "Savante - Manual Entry");

		wait(2);
		WebElement TrialSet_Tab = createWebElementBy(tab_TrialSet);
		TrialSet_Tab.click();

		wait(2);
		String title6 = getTitle();
		System.out.println("title is"+title6);
		Assert.assertEquals(title6, "Savante - Manual Entry");

		wait(2);
		WebElement TrialArm_Tab = createWebElementBy(tab_TrialArm);
		TrialArm_Tab.click();

		wait(2);
		String title9 = getTitle();
		System.out.println("title is"+title9);
		Assert.assertEquals(title9, "Savante - Manual Entry");

		wait(2);
		WebElement DosingSpecifications_Tab = createWebElementBy(tab_DosingSpecifications);
		DosingSpecifications_Tab.click();

		wait(2);
		String title7 = getTitle();
		System.out.println("title is"+title7);
		Assert.assertEquals(title7, "Savante - Studies - Dosing specification");

		wait(2);
		WebElement Phase_Tab = createWebElementBy(tab_Phase);
		Phase_Tab.click();

		wait(2);
		String title8 = getTitle();
		System.out.println("title is"+title8);
		Assert.assertEquals(title8, "Savante - Studies - Phase");


	}

	public void  TM_Gview_TC06_Web_Filter_Verification(){

		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		wait(2);
		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();

		WebElement Output_Tab = createWebElementBy(tab_Output);
		mouseHover(Output_Tab);

		wait(2);
		WebElement SendOutputMapping_dpd = createWebElementBy(dpd_SendOutputMapping);
		SendOutputMapping_dpd.click();

		wait(2);
		WebElement Domain_dpd = createWebElementBy(dpd_Domain);
		Domain_dpd.click();
		Domain_dpd.sendKeys("BW");
		Domain_dpd.sendKeys(Keys.ENTER);


		wait(2);
		WebElement View_btn = createWebElementBy(btn_View);
		View_btn.click();

		wait(2);
		WebElement Domain_tbl = createWebElementBy(tbl_Domain);
		String title = Domain_tbl.getText();		
		Assert.assertEquals(title, "BW");


	}

	//	By tab_Output = By.xpath("//a[@class='hasChild select']");	
	//	By tab_Output = By.xpath("//a[@class='hasChild select']");
	//	By dpd_SendOutputMapping = By.xpath("//a[contains(text(),'SEND Output Mapping')]");
	//	By dpd_Domain = By.xpath("//select[@id='domian']");
	//	By btn_View = By.xpath("//input[@class='button']");
	//	By tbl_Domain = By.xpath("//tr[3]//td[1]");




	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here


	private File getLatestFilefromDir(String dirPath){
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	} 

}	
