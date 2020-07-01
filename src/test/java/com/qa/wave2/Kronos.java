package com.qa.wave2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class Kronos extends CommonMethods {
	/***************************** Test Data *******************/

	final String Browser = "Firefox";
	final String DevUrl = "https://fckronwebdev01.na.gilead.com/wfc/applications/suitenav/navigation.do";
	String usrname = "graj";
	private String DecrptPassword;
	String name = "Testing3";
	String entermessage = "Testing Kronos";
	String Open = "Testing3";

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


	String URL = DevUrl;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
	}

	@Test(priority=1, enabled=false)
	public void KRN_S01_Web_Validate_Homepage() {
		TM_S01_Web_Validate_Homepage();
	}

	@Test(priority=2, enabled=true)
	public void KRN_S02_Web_New_Message() {
		TM_S02_Web_New_Message();
	}

	@Test(priority=3, enabled=true)
	public void KRN_S03_Web_Open_Message() {
		TM_S03_Web_Open_Message();
	}
	
	@Test(priority=4, enabled=true)
	public void KRN_S06_Web_Validate_LogOff() {
		TM_S04_Web_Validate_LogOff();
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

	By ipt_username 		=	By.cssSelector("input[id='username']");
	By ipt_password			=	By.cssSelector("input[id='password']");
	By btn_login			=	By.cssSelector("input[class='btnLogin']");
	By img_kronoslogo		=	By.cssSelector("#logoimg");
	By lnk_logoff			=	By.cssSelector("div[id^='globalLinks'] a[href*='logoff']");
	By btn_new				=	By.cssSelector("#emsMenuTop_0_ACTION_LINK");
	By btn_open				=	By.cssSelector("#emsMenuTop_1_ACTION_LINK");
	By txt_toarea			=	By.cssSelector("#toArea");
	By txt_subject			=	By.cssSelector("#subjectInput");
	By txt_messagearea 		=	By.cssSelector("#messageArea");
	By btn_send				=	By.cssSelector("#sendBut");
	By xpt_frame			= 	By.xpath("//iframe[@id='contentPane']");
	By txt_message			=	By.xpath("//table[1]/tbody[1]/tr[4]/td");
	By btn_close			=	By.cssSelector("#closeBut");


	public void TM_S01_Web_Validate_Homepage() {
		login();
		WebElement KronosLog_Img = createWebElementBy(img_kronoslogo);
		Assert.assertTrue(KronosLog_Img.isDisplayed(), "The login was unsuccessfull");

		String loggedin = driver.getCurrentUrl();
		Assert.assertTrue(loggedin.contains("applications"), "The login was unsuccessfull");

		logoff();

	}

	public void TM_S02_Web_New_Message() {
		login();
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		WebElement frame1 = driver.findElement(xpt_frame);
		driver.switchTo().frame(frame1);

		WebElement New_Btn = createWebElementBy(btn_new);
		New_Btn.click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		WebElement ToArea_Txt = createWebElementBy(txt_toarea);
		ToArea_Txt.sendKeys("gokul.raj@gilead.com");

		driver.findElement(By.cssSelector("#sendSelfCK")).click();

		WebElement Subject_Txt = createWebElementBy(txt_subject);
		Subject_Txt.sendKeys(name);

		WebElement MessageArea_Txt = createWebElementBy(txt_messagearea);
		MessageArea_Txt.sendKeys(entermessage);

		WebElement Send_Btn = createWebElementBy(btn_send);
		Send_Btn.click();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		wait(3);
		validate();
		driver.switchTo().defaultContent();

		logoff();
	}

	public void TM_S03_Web_Open_Message() {
		login();
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		WebElement frame1 = driver.findElement(xpt_frame);
		driver.switchTo().frame(frame1);

		select(Open);

		WebElement Open_Btn = createWebElementBy(btn_open);
		Open_Btn.click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		WebElement Message_Txt = createWebElementBy(txt_message);
		Assert.assertTrue(Message_Txt.getText().equalsIgnoreCase(entermessage), "The message opened is different");
		System.out.println(Message_Txt.getText());

		WebElement Close_Btn = createWebElementBy(btn_close);
		Close_Btn.click();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		wait(3);
		driver.switchTo().defaultContent();

		logoff();
	}

	public void TM_S04_Web_Validate_LogOff() {
		login();
		WebElement KronosLog_Img = createWebElementBy(img_kronoslogo);
		Assert.assertTrue(KronosLog_Img.isDisplayed(), "The login was unsuccessfull");

		String loggedin = driver.getCurrentUrl();
		Assert.assertTrue(loggedin.contains("applications"), "The login was unsuccessfull");
		logoff();
		
		String webUrl = driver.getCurrentUrl();
		Assert.assertTrue(webUrl.contains("logon"), "The log off was unsuccessfull");
		
	}


	/************************* Generic test cases ********************************/
	public void login() {

		driver.switchTo().frame("frmContent");

		WebElement UserName_Ipt = createWebElementBy(ipt_username);
		UserName_Ipt.sendKeys(usrname);
		try {
			DecrptPassword = decrypt("FtLW0yalDtJoAYohAIMxZw==");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		WebElement Password_Ipt = createWebElementBy(ipt_password);
		Password_Ipt.sendKeys(DecrptPassword);

		WebElement Login_Btn = createWebElementBy(btn_login);
		Login_Btn.click();
		driver.switchTo().parentFrame();
	}

	public void logoff () {
		WebElement LogOff_Lnk = createWebElementBy(lnk_logoff);
		LogOff_Lnk.click();

		String webUrl = driver.getCurrentUrl();
		Assert.assertTrue(webUrl.contains("logon"), "The log off was unsuccessfull");
	}

	public void validate() {

		List<WebElement> allRows = driver.findElements(By.xpath("//tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr"));
		int numberOfRows = allRows.size();
		System.out.println("The Number of rows are:: "+numberOfRows);


		for(int i=1;i<=numberOfRows;i++) {
			WebElement subname = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr["+i+"]/td[2]"));
			if(subname.getText().equalsIgnoreCase(name)) {
				System.out.println("The Subject found is "+subname.getText());
				break;
			}else {
				continue;
			}
		}
	}

	public void select(String openmsg) {
		List<WebElement> allRows = driver.findElements(By.xpath("//tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr"));
		int numberOfRows = allRows.size();
		System.out.println("The Number of rows are:: "+numberOfRows);


		for(int i=1;i<=numberOfRows;i++) {
			WebElement subname = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr["+i+"]/td[2]"));
			if(subname.getText().equalsIgnoreCase(openmsg)) {
				System.out.println("The Subject found is "+subname.getText());
				subname.click();
				break;
			}else {
				continue;
			}
		}
	}
}
