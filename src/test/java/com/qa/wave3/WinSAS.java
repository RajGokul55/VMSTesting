package com.qa.wave3;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class WinSAS extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "IE";
	//Prod Url
	//final String Url = "https://gadi2.gilead.com";
	//Dev Url
	final String Url = "https://gadi2dev.gilead.com";
	//Val Url
	//final String Url = "https://gadi2val.gilead.com";

	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\SiKuli\\WinSAS\\";
	final String Username = "psonawane";
	private String DecrptPassword;

	/***************************** Test Cases *******************************/
	/*
	 * Test case ˜Test Name™ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, TCNumber: Test
	 * case number [Numeric 2-3 digits] i.e, 01, 02,.. TestCategory: Test case
	 * category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB
	 * â€¦] Title: short title of test case based on context of test case ie.,
	 * ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails. Test
	 * method name must be same as test case appended with TM example:
	 */

	@BeforeMethod
	void setUp() {
		try {
			DecrptPassword = decrypt("e19ncVNSmW6OrHZf9mDsAg==");
		} catch (Exception e) {
			e.printStackTrace();
		}
		launchBrowser(Browser, Url);
	}

	@Test(priority = 0, enabled = true)
	public void WinSAS_S01_Windows_Web_URL_Verfication() {
		TM_WinSAS_S01_Windows_Web_URL_Verfication();
	}

	@Test(priority = 1,enabled = true) 
	public void WinSAS_S02_Windows_Web_Login_Verfication() {
		TM_WinSAS_S02_Windows_Web_Login_Verfication();
	}

	@Test(priority = 8, enabled = false) 
	public void WinSAS_S03_Windows_Web_Adobe_Verfication() {
		TM_WinSAS_S03_Windows_Web_Adobe_Verfication();
	}

	@Test(priority = 7, enabled = false)
	public void WinSAS_S04_Windows_Web_MS_Word_Verfication() {
		TM_WinSAS_S04_Windows_Web_MS_Word_Verfication();
	}

	@Test(priority = 3, enabled = false)
	public void WinSAS_S05_Windows_Web_MS_Excel_Verfication() {
		TM_WinSAS_S05_Windows_Web_MS_Excel_Verfication();
		driver.quit();
	}

	@Test(priority = 4, enabled = false)
	public void WinSAS_S06_Windows_Web_MS_PowerPoint_Verfication() {
		TM_WinSAS_S06_Windows_Web_MS_PowerPoint_Verfication();
		driver.quit();
	}

	@Test(priority = 5, enabled = false)
	public void WinSAS_S07_Windows_Web_SAS_9v4_Verfication() {
		TM_WinSAS_S07_Windows_Web_SAS_9v4_Verfication();
	}

	@Test(priority = 6, enabled = false)
	public void WinSAS_S08_Windows_Web_SAS_Viewer_Verfication() {
		TM_WinSAS_S08_Windows_Web_SAS_Viewer_Verfication();
	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */

	By ipt_Username = By.cssSelector("#login");
	By ipt_Password = By.cssSelector("#passwd");
	By btn_LogOn = By.cssSelector("#loginBtn");
	By text_User = By.cssSelector(".theme-header-color.user-display-name._ctxstxt_Menu");
	By img_APPS = By.cssSelector("#allAppsBtn");
	By img_Adobe = By.xpath("//*[@class='storeapp-name' and contains(text(), 'Adobe Acrobat DC')]");
	By img_Word = By.xpath("//*[@class='storeapp-name' and contains(text(), 'MS Word')]");
	By img_Excel = By.xpath("//*[@class='storeapp-name' and contains(text(), 'MS Excel')]");
	By img_PowerPoint = By.xpath("//*[@class='storeapp-name' and contains(text(), 'MS PowerPoint')]");
	By img_SAS9v4 = By.xpath("//*[@class='storeapp-name' and contains(text(), 'SAS 9v4')]");
	By img_SAS_Viewer = By.xpath("//*[@class='storeapp-name' and contains(text(), 'SAS Universal Viewer')]");


	String Actual_Title = "GADI2Dev Internal";
	String User = "Pravin Sonawane (Contractor)";

	/***************************** Sikuli *****************************/

	Screen s = new Screen();
	Pattern LoginOK = new Pattern(path + "WinSAS_Login_OK.PNG");
	Pattern Licence_Cancel = new Pattern(path + "WinSAS_Licence_Cancel.PNG");
	Pattern BlankDocument = new Pattern(path + "WinSAS_BlankDocument.PNG");
	Pattern Close_Word = new Pattern(path + "WinSAS_Close_Word.PNG");
	Pattern BlankWorkbook = new Pattern(path + "WinSAS_BlankWorkbook.PNG");
	Pattern Close_Excel = new Pattern(path + "WinSAS_Close_Excel.PNG");
	Pattern BlankPresentation = new Pattern(path + "WinSAS_BlankPresentation1.PNG");
	Pattern Close_PowerPoint = new Pattern(path + "WinSAS_Close_PowerPoint.PNG");
	Pattern Close_SAS9v4 = new Pattern(path + "WinSAS_Close_SAS9v4.PNG");
	Pattern Exit_Alert_SAS9v4 = new Pattern(path + "WinSAS_Close_Alert_SAS9v4.PNG");
	Pattern Close_SAS_Universal = new Pattern(path + "WinSAS_Close_SAS_Universal.PNG");
	Pattern Save_Alert_SAS_Universal = new Pattern(path + "WinSAS_Save_No_SAS_Universal.PNG");

	/***************************** Test Case Methods *******************/

	void TM_WinSAS_S01_Windows_Web_URL_Verfication() {
		waitForPageLoaded();
		String Title = driver.getTitle();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(Title, Actual_Title);
	}

	void TM_WinSAS_S02_Windows_Web_Login_Verfication(){
		WinSAS_User_Login();
		String actual_User = createWebElementBy(text_User).getText();
		takeScreenshotAtEndOfTest();
		Assert.assertEquals(actual_User, User);
	}

	void TM_WinSAS_S03_Windows_Web_Adobe_Verfication() {

		createWebElementBy(img_APPS).click();
		createWebElementBy(img_Adobe).click();

	}

	void TM_WinSAS_S04_Windows_Web_MS_Word_Verfication() {
		WinSAS_MS_Office_Sikuli(img_Word, BlankDocument, Close_Word);
	}

	void TM_WinSAS_S05_Windows_Web_MS_Excel_Verfication() {
		WinSAS_MS_Office_Sikuli(img_Excel, BlankWorkbook, Close_Excel);
	}

	void TM_WinSAS_S06_Windows_Web_MS_PowerPoint_Verfication() {
		WinSAS_MS_Office_Sikuli(img_PowerPoint, BlankPresentation, Close_PowerPoint);
	}

	void TM_WinSAS_S07_Windows_Web_SAS_9v4_Verfication() {
		WinSAS_MS_Office_Sikuli(img_SAS9v4, Exit_Alert_SAS9v4, Close_SAS9v4);
	}

	void TM_WinSAS_S08_Windows_Web_SAS_Viewer_Verfication() {
		WinSAS_MS_Office_Sikuli(img_SAS_Viewer, Save_Alert_SAS_Universal, Close_SAS_Universal);
	}

	/***************************** Common Methods ******************************/

	void WinSAS_User_Login() {
		createWebElementBy(ipt_Username).sendKeys(Username);
		createWebElementBy(ipt_Password).sendKeys(DecrptPassword);;
		createWebElementBy(btn_LogOn).click();
		waitForPageLoaded();
	}

	void WinSAS_MS_Office_Sikuli(By Element, Pattern Blank, Pattern Close) {
		WinSAS_User_Login();
		createWebElementBy(img_APPS).click();
		createWebElementBy(Element).click();
		wait(5);
		windowhandle();
		System.out.println("Window handled");
		wait(5);
		driver.manage().window().maximize();
		wait(10);
		try {
			if(Blank!=BlankDocument) {
				s.click(LoginOK);	
			}
			wait(15);
			if((Blank != Save_Alert_SAS_Universal) || (Blank !=Exit_Alert_SAS9v4)) {
				s.click(Licence_Cancel);
				wait(5);
				s.click(Blank);
				wait(10);
			}
			takeScreenshotAtEndOfTest();
			s.click(Close);
			wait(5);
			if((Blank == Save_Alert_SAS_Universal) || (Blank == Exit_Alert_SAS9v4)) {
				s.click(Blank);
				wait(5);
			}
		} catch (FindFailed e) {
			e.printStackTrace();
		}	
	}


}
