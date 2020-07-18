

package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




public class GPRS extends CommonMethods{

	//private static final String WebElementDrop = null;
	///***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://sjgprsappuatn01.na.gilead.com/aims/ps/Default.aspx"; //test
	final String CorporateUrl= "https://reset.gilead.com/aims/ps/Main.aspx"; //prod
	final String PartnerUrl = "https://partnersreset.gilead.com/aims/ps"; //prod

	final String Username ="nnereddula";
	private String DecrptPassword;
	String EncryptPwd = "maF92iz73RYQ2imnwwuCsA==";
	String ADM_UserID = null;
	String ADMpassword = null;
	
	final String ParterUsername  = "TESTPRT";
	private String DecrptPartnerPwd;
	String EncryptPtrPwd = "lcStILCoHe77OQVhpMp+/w==";

	
	static final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\";
	String resout = path + "Output.txt";
	String runbat = path + "Run.bat";
	/***************************** Test Cases *******************/

	@Test(priority=1, enabled=true)
	public void GPRS_S03_Web_Testurlaccessible() {
		TM_GPRS_S03_Web_Testurlaccessible(Url);
	}

	@Test(priority=2, enabled=true)
	public void GPRS_S10_Web_EnrollmentFunctionality() {
		TM_GPRS_S10_Web_EnrollmentFunctionality(Url);
	}

	@Test(priority=3, enabled=true)
	public void GPRS_S01_Web_Testurlaccessible() {
		TM_GPRS_S01_Web_Testurlaccessible(CorporateUrl);
	}
	
	@Test(priority=4, enabled=true)
	public void GPRS_S02_Web_PartnerUrlaccessible() {
		TM_GPRS_S02_Web_PartnerUrlaccessible(PartnerUrl);
	}
	
	@Test(priority=5, enabled=true)
	public void GPRS_S04_Web_Password_Chng_Func() {
		TM_GPRS_S04_Web_Password_Chng_Func(CorporateUrl);
	}
	
	@Test(priority=6, enabled=true)
	public void GPRS_S05_Web_Password_reset_Func() {
		TM_GPRS_S05_Web_Password_reset_Func(CorporateUrl);
	}
	
	@Test(priority=7, enabled=true)
	public void GPRS_S06_Web_Password_Chng_Func() {
		TM_GPRS_S06_Web_Password_Chng_Func(PartnerUrl);
	}
	
	@Test(priority=8, enabled=true)
	public void GPRS_S07_Web_Password_reset_Func() {
		TM_GPRS_S07_Web_Password_reset_Func(PartnerUrl);
	}
	
	@Test(priority=9, enabled=true) 
	public void GPRS_S08_Web_Password_Chng_Func() {
		TM_GPRS_S08_Web_Password_Chng_Func(Url);
	}
	
	@Test(priority=10, enabled=true) 
	public void GPRS_S09_Web_Password_reset_Func() {
		TM_GPRS_S09_Web_Password_reset_Func(Url);
	}
	
	
	@AfterMethod(enabled=true)
	public void afterTest() {
		driver.quit();
	}
	
	/***************************** Windows Server Services check *******************/
	@BeforeMethod(enabled=false)
	public void BeforeWindowsServicesTest() {
		ADM_UserID = "QULANA/sgupta26";
		//password = RSA_Authentication("bpalle"); //QULANA\\
		ADMpassword = "Work@123";
	
		 
	}
	
	@Test(priority=4, enabled=false) //Server Unavailable
	public void GPRS_S07_WinSrve_Service_Status() {
		TM_GPRS_S07_WinSrve_Service_Status();
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

	By ipt_Username= By.xpath("//input[@id='editUserID']");
	By ipt_Passwrod= By.xpath("//input[@id='idx_app_LoginFrame_0Password']");
	By ipt_userid=By.xpath("//input[@id='editUserID']");
	By drp_Domain = By.xpath("//select[@id='listDomains']");
	By btn_DomainValue = By.xpath("(//option[contains(text(),'QUALNA')]");
	By btn_Agree = By.xpath("(//input[@id='btnTextIAgree'])");
	By img_forgotPWD= By.xpath("(//img[@id='imgForgotPassword']");
	By btn_yesfrgtpwd=By.xpath("//input[@id='ButtonYes']");

	By img_ChangePWD=By.xpath("//img[@id='imgChangePassword']");
	By img_enrollment = By.xpath("//input[@id='btnEnroll']");
	By ipt_enrollPwd=By.xpath("//input[@id='txtPassword']");
	By btn_continue= By.xpath("//input[@id='ButtonTextContinue']");
	By btn_cancel= By.xpath("//input[@id='ButtonTextCancel']']");
	By icn_homepage = By.xpath("//div[@class='logo PS']");
	By btn_ChPWDctn = By.xpath("//input[@id='ButtonContinue']");
	By btn_Signout = By.xpath("//div[@class='signOutText']");

	By ipt_OldPwd = By.cssSelector("input[name='textOldPassword']");
	By ipt_NewPwd = By.cssSelector("input[name='textNewPassword']");
	By ipt_ConfirmPwd = By.cssSelector("input[name='textConfirm']");
	By btn_Cancel = By.cssSelector("input[value='Cancel']");
	By btn_No = By.cssSelector("input[id='ButtonNo']");
	By img_ForgotPwd = By.cssSelector("img[id='imgForgotPassword']");
	By Ipt_Answer1 = By.cssSelector("input[id='textAnswer1']");
	By Ipt_Password = By.cssSelector("input[id='txtPassword']");
	By lbl_ResetPwd = By.cssSelector("span[id='LabelAction']");
	By btn_Continue = By.cssSelector("input[value='Continue']");
	
	
	/*****************************Test Case Methods *******************/
	@SuppressWarnings("null")
	//For all WebElements may append type Example: Submit_Btn



	/*******************Login page****************/

	void TM_GPRS_S03_Web_Testurlaccessible(String Url) {
		
		launchBrowser(Browser,Url);

		Select dropdown = new Select(driver.findElement(By.id("listDomains")));  
		dropdown.selectByVisibleText("QUALNA"); 

		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);
		takeScreenshotAtEndOfTest();
		
		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();
		waitForPageLoaded();
	}
	
	void TM_GPRS_S02_Web_PartnerUrlaccessible(String PartnerUrl) {
		
		launchBrowser(Browser,PartnerUrl);
		
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(ParterUsername);
			
		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();
			
		takeScreenshotAtEndOfTest();
		
		WebElement signout_Btn = createWebElementBy(btn_Signout);
		takeScreenshotAtEndOfTest();
		signout_Btn.click();
	}


	/*********************ENROLLMENT FUNCTIONALITY**************************/

	void TM_GPRS_S10_Web_EnrollmentFunctionality(String Url) {
		launchBrowser(Browser,Url);
		
		Select dropdown = new Select(driver.findElement(By.id("listDomains")));  
		dropdown.selectByVisibleText("QUALNA"); 


		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);
		takeScreenshotAtEndOfTest();

		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();
		
		WebElement enrollment_img = createWebElementBy(img_enrollment);
		enrollment_img.click();
		waitForPageLoaded();
		
		try {
			DecrptPassword = decrypt(EncryptPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement enroll_Ipt = createWebElementBy(ipt_enrollPwd);
		enroll_Ipt.sendKeys(DecrptPassword);	
		waitForPageLoaded();
		takeScreenshotAtEndOfTest();

		WebElement Continue_Btn = createWebElementBy(btn_continue);
		Continue_Btn.click();

		WebElement homepage_icn = createWebElementBy(icn_homepage);
		takeScreenshotAtEndOfTest();
		homepage_icn.click();


		WebElement signout_Btn = createWebElementBy(btn_Signout);
		takeScreenshotAtEndOfTest();
		signout_Btn.click();



	}

	/************************Login Corporate URL***************************/



	void TM_GPRS_S01_Web_Testurlaccessible(String CroUrl) {

		launchBrowser(Browser,CroUrl );  

		Select dropdown = new Select(driver.findElement(By.id("listDomains")));  
		dropdown.selectByVisibleText("NA");  


		WebElement Username_Ipt = createWebElementBy(ipt_userid);
		Username_Ipt.sendKeys(Username);
		takeScreenshotAtEndOfTest();

		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		takeScreenshotAtEndOfTest();
		Agree_Btn.click();
		waitForPageLoaded();

		WebElement signout_Btn = createWebElementBy(btn_Signout);
		takeScreenshotAtEndOfTest();

		signout_Btn.click();

	}
	
	void TM_GPRS_S04_Web_Password_Chng_Func(String CroUrl) {

		launchBrowser(Browser,CroUrl );  

		Select dropdown = new Select(driver.findElement(By.id("listDomains")));  
		dropdown.selectByVisibleText("NA");  


		WebElement Username_Ipt = createWebElementBy(ipt_userid);
		Username_Ipt.sendKeys(Username);
		takeScreenshotAtEndOfTest();

		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		takeScreenshotAtEndOfTest();
		Agree_Btn.click();
		waitForPageLoaded();
		
		changepassword();
		
		WebElement signout_Btn = createWebElementBy(btn_Signout);
		signout_Btn.click();

	}
	
	void TM_GPRS_S05_Web_Password_reset_Func(String CroUrl) {

		launchBrowser(Browser,CroUrl );  

		Select dropdown = new Select(driver.findElement(By.id("listDomains")));  
		dropdown.selectByVisibleText("NA");  

		WebElement Username_Ipt = createWebElementBy(ipt_userid);
		Username_Ipt.sendKeys(Username);
		
		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();
		waitForPageLoaded();
			
		resetPassword("Vasantha", "Nandyal", "BallBadminton");
		
		WebElement signout_Btn = createWebElementBy(btn_Signout);
		signout_Btn.click();
		
	}
	
	void TM_GPRS_S06_Web_Password_Chng_Func(String PartnerUrl) {
		
		launchBrowser(Browser,PartnerUrl);
		
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(ParterUsername);
				
		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();
		waitForPageLoaded();
		
		changepassword();
			
		WebElement signout_Btn = createWebElementBy(btn_Signout);
		signout_Btn.click();
		
		
	}

	
	void TM_GPRS_S07_Web_Password_reset_Func(String PartnerUrl) {
		
		launchBrowser(Browser,PartnerUrl);
		
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(ParterUsername);
				
		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();
		
		resetPassword("test1", "test2", "test3");
				
		WebElement signout_Btn = createWebElementBy(btn_Signout);
		takeScreenshotAtEndOfTest();
		signout_Btn.click();
	}
	
	void TM_GPRS_S08_Web_Password_Chng_Func(String Url) {

		launchBrowser(Browser,Url );  

		Select dropdown = new Select(driver.findElement(By.id("listDomains")));  
		dropdown.selectByVisibleText("QUALNA");

		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();
		waitForPageLoaded();
		
		changepassword();
		
		WebElement signout_Btn = createWebElementBy(btn_Signout);
		signout_Btn.click();
		
	}
	
	void TM_GPRS_S09_Web_Password_reset_Func(String Url) {

		launchBrowser(Browser,Url );  

		Select dropdown = new Select(driver.findElement(By.id("listDomains")));  
		dropdown.selectByVisibleText("QUALNA"); 


		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);

		WebElement Agree_Btn = createWebElementBy(btn_Agree);
		Agree_Btn.click();
		waitForPageLoaded();
		
		resetPassword("Nandyal","Vasantha","Paul");
		
		WebElement signout_Btn = createWebElementBy(btn_Signout);
		signout_Btn.click();
		
	}

	void TM_GPRS_S07_WinSrve_Service_Status () {
		//createPS1HostnameServices(ADM_UserID, ADMpassword, "sjgprsappuatn01.na.gilead.com", "PBWinSvc , AIMSServiceManaged");	
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "PBWinSvc", "Running");
		verifyServiceStatus(resout, "AIMSServiceManaged", "Running");

	
}
	/*****************************Application Interaction Methods *******************/
	// if any code re-usability is there specific to this Application then that should be maintained here
	
	public void changepassword() {
		WebElement changePwd_Btn = createWebElementBy(img_ChangePWD);
		changePwd_Btn.click();
		waitForPageLoaded();
		
		WebElement OldPwd_Ipt = createWebElementBy(ipt_OldPwd);
		OldPwd_Ipt.sendKeys("ExtingPas");
		
		WebElement NewPwd_Ipt = createWebElementBy(ipt_NewPwd);
		NewPwd_Ipt.sendKeys("NewPassword");
		
		WebElement ConfirmPwd_Ipt = createWebElementBy(ipt_ConfirmPwd);
		ConfirmPwd_Ipt.sendKeys("NewPassword");
		
		WebElement Cancel_Btn = createWebElementBy(btn_Cancel);
		takeScreenshotAtEndOfTest();
		Cancel_Btn.click();
	}
	
	public void resetPassword(String Ans1,String Ans2, String Ans3 ) {
		
		WebElement forgotPwd_Btn = createWebElementBy(img_ForgotPwd);
		forgotPwd_Btn.click();
		waitForPageLoaded();	
		
		WebElement No_Btn = createWebElementBy(btn_No);
		No_Btn.click();
		waitForPageLoaded();
				
		WebElement Continue_Btn = createWebElementBy(btn_Continue);
		Continue_Btn.click();
		waitForPageLoaded();
				
		WebElement Answer1_Ipt = createWebElementBy(Ipt_Answer1);
		Answer1_Ipt.sendKeys(Ans1);
						
		WebElement Continue1_Btn = createWebElementBy(btn_Continue);
		Continue1_Btn.click();
		waitForPageLoaded();
		
		WebElement Answer2_Ipt = createWebElementBy(Ipt_Answer1);
		Answer2_Ipt.sendKeys(Ans2);
		
		WebElement Continue2_Btn = createWebElementBy(btn_Continue);
		Continue2_Btn.click();
		waitForPageLoaded();	
		
		WebElement Answer3_Ipt = createWebElementBy(Ipt_Answer1);
		Answer3_Ipt.sendKeys(Ans3);
		 		 
		WebElement Continue3_Btn = createWebElementBy(btn_Continue);
		Continue3_Btn.click();
		waitForPageLoaded();
		
		WebElement ResetPwd_label = createWebElementBy(lbl_ResetPwd);
		IsDisplayed_IsEnabled(ResetPwd_label);
		
		WebElement Cancel_Btn = createWebElementBy(btn_Cancel);
		takeScreenshotAtEndOfTest();
		Cancel_Btn.click();
		
	}

}
