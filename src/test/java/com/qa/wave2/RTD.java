package com.qa.wave2;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class RTD extends CommonMethods {


	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\SiKuli\\";
	final String Browser = "IE";
	final String URL = "https://gadi2dev.gilead.com/logon/LogonPoint/tmindex.html";
	final String username = "rdmst01";
	final String password = "gilead01";

	/***************************** Test Cases *******************/

	@BeforeTest(enabled = true)
	public void LaunchCitrixReceiver() {
		TM_LaunchCitrixReceiver();
	}
	
	@Test(enabled = true)
	public void RTD_S01_URLAccesibility() {
		TM_RTD_S01_URLAccesibility();
	}
	@Test(enabled = true)
	public void RTD_S02_VerifydesktopShortcutIcons() {
		TM_RTD_S02_VerifydesktopShortcutIcons();
	}
	@Test(enabled = true)
	public void RTD_S03_EnsureAppRedirectIEEnterpriseMode() {
		TM_RTD_S03_EnsureAppRedirectIEEnterpriseMode();
	}
	@Test(enabled = true)
	public void RTD_S04_EnsureAppRedirectCorespondingEnv() {
		TM_RTD_S04_EnsureAppRedirectCorespondingEnv();
	}

	@AfterTest(enabled = true)
	public void LogOffCitrixReceiver() {
		TM_LogOffCitrixReceiver();
	}

	void TM_RTD_S01_URLAccesibility() {
		Screen s = new Screen();
		Pattern RTDSPSDev = new Pattern(path + "CR_RTD_SPS_Dev.PNG");
		s.exists(RTDSPSDev);
		Reporter.log("Home page got displyed successfully");
		takeScreenshotAtSikuli();
		
	}
	void TM_RTD_S02_VerifydesktopShortcutIcons() {
		Screen s = new Screen();
		Pattern Open = new Pattern(path + "CR_OpenBtn.PNG");
		Pattern RTDSPSDev = new Pattern(path + "CR_RTD_SPS_Dev.PNG"); 
		Pattern GSIcon = new Pattern(path + "CR_GSIcon.PNG"); 
		Pattern I4VIcon = new Pattern(path + "CR_I4VDevIcon.PNG"); 
		Pattern LorenDocBridge = new Pattern(path + "CR_LORENZDocBridge.PNG"); 
		Pattern LorenEvalidator = new Pattern(path + "CR_LORENeValidator.PNG"); 
		
		try {
			s.click(RTDSPSDev);
			wait(2);
			s.click(Open);
			wait(30);
			s.exists(GSIcon);
			Reporter.log("Global Submit Icon displayed on desktop successfully");
			s.exists(I4VIcon);
			Reporter.log("I4V Icon displayed on desktop successfully");
			s.exists(LorenDocBridge);
			Reporter.log("LorenDocBridge Icon displayed on desktop successfully");
			s.exists(LorenEvalidator);
			Reporter.log("LorenEvalidator Icon displayed on desktop successfully");
			takeScreenshotAtSikuli();
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void TM_RTD_S03_EnsureAppRedirectIEEnterpriseMode() {
		Screen s = new Screen();
		Pattern I4VIcon = new Pattern(path + "CR_I4VDevIcon.PNG");
		Pattern I4VLink = new Pattern(path + "CR_I4VLink.PNG");
		Pattern IEModeIcon = new Pattern(path + "CR_IEMode.PNG");
		try {
			s.doubleClick(I4VIcon);
			wait(10);
			s.click(I4VLink);
			wait(5);
			s.exists(IEModeIcon);
			Reporter.log("Internet Explorer Mode Icon displayed in fornt of URL successfully");
			takeScreenshotAtSikuli();
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void TM_RTD_S04_EnsureAppRedirectCorespondingEnv() {
		Screen s = new Screen();
		Pattern DevURL = new Pattern(path + "CR_DevUrl.PNG");
		s.exists(DevURL);
		Reporter.log("Dev URL displayed successfully");
		takeScreenshotAtSikuli();
	}
	

	void TM_LaunchCitrixReceiver() {		
		Screen s = new Screen();
		Pattern Windows = new Pattern(path + "CR_Windows.PNG");
		Pattern WinSearch = new Pattern(path + "CR_Search.PNG");
		Pattern IEBrowser = new Pattern(path + "CR_iexplore.PNG");
		Pattern EnterURL = new Pattern(path + "CR_EnterURL.PNG"); 
		Pattern Username = new Pattern(path + "CR_Username.PNG");
		Pattern Password = new Pattern(path + "CR_Password.PNG");
		Pattern LogOn = new Pattern(path + "CR_LogOnBtn.PNG"); 
		
		try {
			s.wait(Windows, 20);
			s.click(Windows);
			s.type(WinSearch, "iexplore"); 
			wait(3);
			s.click(IEBrowser);
			wait(10);
		/*	s.type(Key.SPACE, KeyModifier.ALT);
			wait(2);
			s.type("x");
		*/	
			s.type(EnterURL, URL);
			wait(3);
			s.type(Key.ENTER);
			wait(15);
			s.wait(Username, 20);
			s.type(Username,username );
			s.type(Password,password );
			s.click(LogOn);
			wait(3);
			 
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	void TM_LogOffCitrixReceiver(){
		Screen s = new Screen();
		Pattern DevWindows = new Pattern(path + "CR_WindowsIcon.PNG"); 
		Pattern RtdUserAccount = new Pattern(path + "CR_Rdmsto1Account.PNG"); 
		Pattern SignOut = new Pattern(path + "CR_Rtd_SignOut.PNG"); 
		Pattern LoggedUser = new Pattern(path + "CR_LoggedUser.PNG"); 
		Pattern LogOff = new Pattern(path + "CR_Rtd_LogOff.PNG"); 
		try {
			s.wait(DevWindows, 20);
			s.click(DevWindows);
			wait(5);
			s.click(RtdUserAccount);
			s.click(SignOut);
			wait(7);
			s.click(LoggedUser);
			wait(2);
			s.click(LogOff);
			wait(5);
			s.type(Key.SPACE, KeyModifier.ALT);
			wait(2);
			s.type("c");
		} catch (FindFailed e) {
			e.printStackTrace();
		}

	}
}
