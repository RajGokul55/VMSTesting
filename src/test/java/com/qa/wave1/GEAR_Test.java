
package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

public class GEAR_Test extends CommonMethods {

	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String Url_GileadInterface = "https://gear.gilead.com/published";
	final String Url_HopexInterface = "https://gear.gilead.com/hopex/";

	// use below url for Prod testing
	final String Url_Gilead_prod = "https://gear.gilead.com/published";
	final String Url_Hopex_prod = "https://gear.gilead.com/hopex/";

	private static final String userDirectory = System.getProperty("user.dir");
	private static String imagePath = userDirectory + "\\AutoFiles\\SiKuli\\GEAR\\";

	// This is the server name for runtime
	final String servername = "SJGEARAPPDEVN01";
	final String Username = "ADM_abhatt2";
	final String password = "@oQdLuG25vmM";
	private String DecrptPassword;

	/***************************** Test Cases *******************/
	/*
	 * Url_GileadInterface =
	 * "https://fcmegapptstn01.na.gilead.com/published";SSO-Need access
	 * Url_HopexInterface = "https://fcmegapptstn01.na.gilead.com/hopex/";- SSO-
	 * need access Url_Gilead_prod= "https://gear.gilead.com/published";- No need
	 * Url_Hopex_prod = "https://gear.gilead.com/hopex/";
	 * 
	 * DEv Servers:,SJGEARAPPDEVN01,FCMEGAPPDEVN01
	 * 
	 * 
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

	@Test(priority = 0, enabled = false)
	public void Gear_S01_Web_HopexInterface_Module_Verification() {
		launchBrowser(Browser, Url_HopexInterface);
		TM_Gear_S01_Web_HopexInterface_Module_Verification();

	}

	@Test(priority = 1, enabled = false)
	public void Gear_S02_Web_HopexInterface_LinksUnderHomeTab_Verification() {
		launchBrowser(Browser, Url_HopexInterface);
		TM_Gear_S02_Web_HopexInterface_LinksUnderHomeTab_Verification();
	}

	@Test(priority = 2, enabled = false)
	public void Gear_S03_Web_GileadInterface_Tab_Availability() {
		launchBrowser(Browser, Url_GileadInterface);
		TM_Gear_TC03_Web_GileadInterface_Tab_Availability();

	}

	@Test(priority = 3, enabled = false)
	public void Gear_S04_Web_GileadInterface_Navigation_Verification() {
		launchBrowser(Browser, Url_GileadInterface);
		TM_Gear_TC04_Web_GileadInterface_Navigation_Verification();
	}

	@Test(priority = 4, enabled = true)
	public void GEAR_S05_Windows_serverLogin() throws FindFailed {
		TM_GEAR_S05_Windows_serverLogin();
	}

	@AfterMethod(enabled = false)
	public void afterTest() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages
	 */

	By ipt_Username = By.xpath("//input[@class= '_2zrpKA _1dBPDZ']");

	By lnk_tabs = By.xpath("//ul[@id='e_menu']/li/a/b");
	By lnk_systems = By.xpath("(//ul[@id='e_menu']/li/a/b)[4]");
	By frm_frame = By.xpath("//frame[@name='contentframe']");
	By txt_systemList = By.xpath("//span[text()='Systems List']");
	By msg_heading = By.cssSelector(".bg h1");
	By lnk_gear = By.linkText("GEAR");

	By id_submitButton = By.cssSelector("#focusedsubmit");
	By lnk_tiles = By.xpath("//div[contains(text(),'All')]");
	By lnk_hometabs = By.xpath("//span[contains(@id,'header_hd-textEl')]");

	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	void TM_Gear_S01_Web_HopexInterface_Module_Verification() {

		if (Url_HopexInterface != Url_Hopex_prod) {
			waitForPageLoaded();
			/*
			 * wait(5); WebElement submitButton = createWebElementBy(id_submitButton);
			 * submitButton.click();
			 */
			wait(15);
			waitForPageLoaded();
		}

		List<WebElement> Items_Menu = createWebElementsBy(lnk_tiles);
		for (int i = 0; i < Items_Menu.size(); i++) {
			scrollToWebElement(Items_Menu.get(i));
			System.out.println("Menu item " + Items_Menu.get(i).getText() + " is displayed");
			IsDisplayed_IsEnabled(Items_Menu.get(i));
		}
		takeScreenshotAtEndOfTest();

	}

	void TM_Gear_S02_Web_HopexInterface_LinksUnderHomeTab_Verification() {
		if (Url_HopexInterface != Url_Hopex_prod) {
			waitForPageLoaded();
			/*
			 * WebElement submitButton = createWebElementBy(id_submitButton);
			 * submitButton.click();
			 */
			wait(15);
			waitForPageLoaded();
		}
		List<WebElement> Home_tabs = createWebElementsBy(lnk_hometabs);
		for (int i = 0; i < 8; i++) {
			System.out.println("Menu item " + Home_tabs.get(i).getText() + " is displayed");
			IsDisplayed_IsEnabled(Home_tabs.get(i));

		}
		takeScreenshotAtEndOfTest();
	}

	void TM_Gear_TC03_Web_GileadInterface_Tab_Availability() {
		WebElement frame = createWebElementBy(frm_frame);
		switchToFrameByLocator(frame);

		List<WebElement> Items_Menu = createWebElementsBy(lnk_tabs);
		for (int i = 0; i < Items_Menu.size(); i++) {
			IsDisplayed_IsEnabled(Items_Menu.get(i));
		}
		takeScreenshotAtEndOfTest();

	}

	void TM_Gear_TC04_Web_GileadInterface_Navigation_Verification() {
		waitForPageLoaded();
		WebElement frame = createWebElementBy(frm_frame);
		switchToFrameByLocator(frame);
		WebElement systemLink = createWebElementBy(lnk_systems);
		WebElement systemList = createWebElementBy(txt_systemList);
		takeScreenshotAtEndOfTest();
		mouseHover(systemLink);
		waitForPageLoaded();
		systemList.click();

		WebElement pageHeading = createWebElementBy(msg_heading);
		Assert.assertEquals(pageHeading.getText(), "Alphabetical list of Systems");
		WebElement gearLink = createWebElementBy(lnk_gear);
		IsDisplayed_IsEnabled(gearLink);
		takeScreenshotAtEndOfTest();
	}

	void TM_GEAR_S05_Windows_serverLogin() throws FindFailed {

		if (servername == "SJGEARAPPDEVN01") {
			RDP_Connection01(servername, Username, password);

			Screen s = new Screen();
			Pattern okBtn_legal = new Pattern(imagePath + "SJ_legalOKBtn.PNG");
			s.wait(okBtn_legal, 3);
			s.click();

			Pattern gearApp = new Pattern(imagePath + "gearapp.PNG");
			s.wait(gearApp, 4);
			Boolean IsExists = false;

			if (s.exists(gearApp) != null) {
				IsExists = true;
			}
			Assert.assertTrue(IsExists);
			takeScreenshotAtSikuli();

			Pattern powericon = new Pattern(imagePath + "SJ_powerIcon01.PNG");
			s.wait(powericon, 8);
			s.click();

			Pattern disconnectBtn = new Pattern(imagePath + "SJ_disconnectBtn01.PNG");
			s.wait(disconnectBtn, 8);
			s.click();

		} else {
			RDP_Connection01(servername, Username, password);

			Screen s1 = new Screen();
			Pattern okBtnlegal = new Pattern(imagePath + "FC_legalOkBtn01.PNG");
			s1.wait(okBtnlegal, 3);
			s1.click();

			Pattern gearApp = new Pattern(imagePath + "gearapp.PNG");
			s1.wait(gearApp, 5);
			Boolean IsExists = false;

			if (s1.exists(gearApp) != null) {
				IsExists = true;
			}
			Assert.assertTrue(IsExists);
			takeScreenshotAtSikuli();

			Pattern startBtn = new Pattern(imagePath + "FC_startBtn.PNG");
			s1.wait(startBtn, 8);
			s1.click();

			Pattern logoffBtn = new Pattern(imagePath + "FC_startBtn.PNG");
			s1.wait(logoffBtn, 8);
			s1.click();

		}
	}

	/*****************************
	 * Application Interaction Methods
	 *******************/
	// if any code re-usability is there specific to this Application then that
	// should be maintained here
	public static void RDP_Connection01(String servername, String username, String password) {
		final String userDirectory = System.getProperty("user.dir");
		String path = userDirectory + "\\AutoFiles\\SiKuli\\RDP\\";
		Screen s = new Screen();
		Pattern startBtn = new Pattern(path + "StartButton01.PNG");
		Pattern RDPConnection = new Pattern(path + "RDPtaskbarIcon.PNG");
		Pattern serverName = new Pattern(path + "rdpServerName01.PNG");
		Pattern connectRDPServer = new Pattern(path + "connectBtn01.PNG");
		Pattern useanotherAccount = new Pattern(path + "useAnotherAccount01.PNG");
		Pattern userNameRDP = new Pattern(path + "usernameRDP01.PNG");
		Pattern passwordRDP = new Pattern(path + "userpasswordRDP01.PNG");
		Pattern okButton = new Pattern(path + "oKButtonRDP01.PNG");

		try {

			s.wait(RDPConnection, 2);
			s.click();
			wait(5);

			s.type(org.sikuli.script.Key.BACKSPACE);
			s.wait(serverName, 5);
			s.type(servername);
			s.wait(connectRDPServer, 5);
			s.click();
			s.wait(useanotherAccount, 5);
			s.click();
			s.wait(userNameRDP, 5);
			s.type(userNameRDP, username);
			s.wait(passwordRDP, 5);
			s.type(passwordRDP, password);
			s.wait(okButton, 5);
			s.click();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
