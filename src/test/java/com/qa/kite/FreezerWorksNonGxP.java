package com.qa.kite;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class FreezerWorksNonGxP extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "Chrome";
	final String Url = "http://gadi2dev.gilead.com/";
	String pageTitle;
	private static final String userDirectory = System.getProperty("user.dir");
	private static String imagePath = userDirectory + "\\AutoFiles\\SiKuli\\FreezerWorks\\";
	final String servername = "freezerwks-de.kite.local";
	final String jumpServer = "kdc01-gaks.kite.local";

	final String Username = "ADM_bdineshjain";
	final String password = "%oNpXsWa$90W";
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

	@Test(priority = 1, enabled = false)
	public void FreezerWorksNonGxP_S01_Windows_serverLogin() throws FindFailed {
		TM_FreezerWorksNonGxP_Windows_serverLogin();
	}

	/*
	 * @AfterMethod(enabled = true) void Teardouwn() { driver.quit(); }
	 */

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */

	/*****************************
	 * Test Case Methods
	 * 
	 * @throws FindFailed
	 *******************/
	void TM_FreezerWorksNonGxP_Windows_serverLogin() throws FindFailed {

		RDP_Connection01(servername, Username, password);
		Screen s = new Screen();

		Pattern app = new Pattern(imagePath + "freezerWorks_app.PNG");
		s.wait(app, 10);
		Boolean IsExists = false;

		if (s.exists(app) != null) {
			IsExists = true;

		}
		Assert.assertTrue(IsExists);
		takeScreenshotAtSikuli();

		/*
		 * Pattern startButton = new Pattern(imagePath + "home_icon.PNG");
		 * s.wait(startButton, 10000); s.click();
		 */

		Pattern powerBtn = new Pattern(imagePath + "power_icon");
		s.wait(powerBtn, 7);
		s.click();

		Pattern signout = new Pattern(imagePath + "Disconnect_icon");
		s.wait(signout, 8);
		s.click();

	}

	/*********************************
	 * Common Methods
	 *************************************/
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
