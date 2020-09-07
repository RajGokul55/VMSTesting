package com.qa.wave4;

import org.openqa.selenium.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import junit.framework.Assert;

public class I2E extends CommonMethods {
	/***************************** Test Data *******************/
	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\SiKuli\\I2E\\";
	Screen s = new Screen();
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


	@BeforeMethod
	public void beforeMethod() {
		Pattern Start = new Pattern(path + "start.PNG");
		Pattern Search = new Pattern(path + "search.PNG");
		try {
			s.click(Start);
			wait(2);
			s.type(Search, "I2E" + Key.ENTER);
			wait(2);
			
		}catch (FindFailed e) {

			e.printStackTrace();
		}
	}

	@Test(priority=1, enabled=true)
	public void I2E_S01_Web_Validate_Homepage() throws FindFailed {
		TM_S01_Web_Validate_Homepage();
	}
	
	@Test(priority=2, enabled=true)
	public void I2E_S02_Web_Verify_I2EAdministration() throws FindFailed {
		TM_S02_Web_Verify_I2EAdministration();
	}

	

	@AfterMethod
	public void afterMethod() {
		s.type(Key.F4, Key.ALT);
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



	/***************************** Test Case Methods 
	 * @throws FindFailed *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_S01_Web_Validate_Homepage() throws FindFailed {
		wait(10);
		Pattern Username = new Pattern(path + "username.PNG");
		Pattern Password = new Pattern(path + "password.PNG");
		//Pattern Topbar = new Pattern(path + "topbar.PNG");
		
		s.click(Username);
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type("graj");
		wait(1);
		
		s.type(Password, "indexi2e" + Key.ENTER);
		wait(5);
		
		takeScreenshotAtSikuli();
		
	}
	
	public void TM_S02_Web_Verify_I2EAdministration() throws FindFailed {
		wait(10);
		Pattern Username = new Pattern(path + "username.PNG");
		Pattern Password = new Pattern(path + "password.PNG");
		Pattern Mediline = new Pattern(path + "medi.PNG");
		Pattern Mediline2015 = new Pattern(path + "mediline2015.PNG");
		Pattern View = new Pattern(path + "view.PNG");
		Pattern Manage = new Pattern(path + "manage.PNG");
		Pattern ManageItems = new Pattern(path + "manageitems.PNG");
		Pattern Tasks = new Pattern(path + "tasks.PNG");
		Pattern Name = new Pattern(path + "name.PNG");
		Pattern ServerLog = new Pattern(path + "server.PNG");
		Pattern Message = new Pattern(path + "message.PNG");
		Pattern Preferenes = new Pattern(path + "preferences.PNG");
		Pattern PreferenceItems = new Pattern(path + "preferencesitems.PNG");
		Pattern AccountGroups = new Pattern(path + "accgrps.PNG");
		Pattern AccountItems = new Pattern(path + "accgrpsitems.PNG");
		Pattern Sessions = new Pattern(path + "sessions.PNG");
		Pattern SessionItems = new Pattern(path + "sessionitems.PNG");
		
		s.click(Username);
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
		s.type("graj");
		wait(1);
		
		s.type(Password, "indexi2e" + Key.ENTER);
		wait(5);
		
		s.doubleClick(Mediline);
		wait(3);
		s.click(Mediline2015);
		wait(2);
		
		s.click(View);
		wait(1);
		
		
		
		
		
	}
}
