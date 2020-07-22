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

public class HPALM extends CommonMethods {

	/***************************** Test Data *******************/

	final String Browser = "IE";
	//Prod Url
	//final String Url = "https://gadi2.gilead.com";
	//Dev Url
	final String Url = "http://sjalmappprdn03:8080/qcbin/start_a.jsp";
	//Val Url
	//final String Url = "https://gadi2val.gilead.com";

	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\SiKuli\\HPALM\\";
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

	@Test(priority = 1,enabled = true) 
	public void HPALM_S01_Windows_Web_Login_Verfication() {
		TM_HPALM_S01_Windows_Web_Login_Verfication();
	}

	@Test(priority = 2, enabled = true)
	public void HPALM_S02_Windows_Web_Cycle_Creation() {
		TM_HPALM_S02_Windows_Web_Cycle_Creation();
	}


	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields btn_: Buttons lnk_: Links rdo_: Radio buttons chk_: Check
	 * boxes tbl_: Tables msg_: Messages txt : text
	 */

	String Actual_Title = "GADI2Dev Internal";
	String User = "Pravin Sonawane (Contractor)";

	/***************************** Sikuli *****************************/

	Screen s = new Screen();
	Pattern HPALM_Username = new Pattern(path + "HPALM_Username.PNG");
	Pattern HPALM_Password = new Pattern(path + "HPALM_Password.PNG");
	Pattern HPALM_Authenticate = new Pattern(path + "HPALM_Authenticate.PNG");
	Pattern HPALM_DomainDropdown = new Pattern(path + "HPALM_DomainDropdown.PNG");
	Pattern HPALM_Domain_Test = new Pattern(path + "HPALM_Domain_Test.PNG");
	Pattern HPALM_Login = new Pattern(path + "HPALM_Login.PNG");
	Pattern HPALM_Management = new Pattern(path + "HPALM_Management.PNG");
	Pattern HPALM_Releases = new Pattern(path + "HPALM_Releases.PNG");
	Pattern HPALM_Release_VMS_Testing = new Pattern(path + "HPALM_Release_VMS Testing.PNG");
	Pattern HPALM_New_VMSCycle = new Pattern(path + "HPALM_New_VMSCycle.PNG");
	Pattern HPALM_NewCycle_Name = new Pattern(path + "HPALM_NewCycle_Name.PNG");
	Pattern HPALM_NewCycle_StartDate = new Pattern(path + "HPALM_NewCycle_StartDate.PNG");
	Pattern HPALM_NewCycle_EndDate = new Pattern(path + "HPALM_NewCycle_EndDate.PNG");
	Pattern HPALM_NewCycle_GIL_ID = new Pattern(path + "HPALM_NewCycle_GIL_ID.PNG");
	Pattern HPALM_OK = new Pattern(path + "HPALM_OK.PNG");

	/***************************** Test Case Methods *******************/

	void TM_HPALM_S01_Windows_Web_Login_Verfication(){
		launchBrowser(Browser, Url);
		wait(10);
		try {
			s.click(HPALM_Username);
			wait(2);
			s.type(Username);
			s.click(HPALM_Password);
			wait(2);
			s.type("Sinhgad@55");
			s.click(HPALM_Authenticate);
			wait(2);
			s.click(HPALM_DomainDropdown);
			wait(1);
			s.click(HPALM_Domain_Test);
			wait(2);
			s.click(HPALM_Login);
			wait(10);

		} catch (FindFailed e) {
			e.printStackTrace();
		}	
		takeScreenshotAtEndOfTest();
	}

	void TM_HPALM_S02_Windows_Web_Cycle_Creation() {
		try {
			s.click(HPALM_Management);
			wait(2);
			s.click(HPALM_Releases);
			wait(2);
			s.click(HPALM_Release_VMS_Testing);
			wait(2);
			s.click(HPALM_New_VMSCycle);
			wait(1);
			s.click(HPALM_NewCycle_Name);
			s.aInput("VMSCycle_Test");
			wait(2);
			s.click(HPALM_NewCycle_StartDate);
			s.aInput("07/07/2020");
			wait(2);
			s.click(HPALM_NewCycle_EndDate);
			s.aInput("07/15/2020");
			wait(2);
			//s.click(HPALM_OK);
			wait(10);

		} catch (FindFailed e) {
			e.printStackTrace();
		}	
		takeScreenshotAtEndOfTest();
	}
}
