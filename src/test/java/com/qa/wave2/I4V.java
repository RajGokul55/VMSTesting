package com.qa.wave2;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class I4V extends CommonMethods {


	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\SiKuli\\";
	final String Browser = "IE";
	final String DevURL = "http://fcsmsdevappn01/i4v-final/";
	final String username = "rdmst01";
	String DecrptPassword = null;
	String EncryptPassword = "0wJNDaXrJwP7JrSMgufTMg==";

	/***************************** Test Cases *******************/

	@BeforeMethod(enabled = true)
	public void LaunchLoginI4V() {
		LaunchandLoginI4V();
	}

	@Test(enabled = true)
	public void I4V_S01_App_URL_Accessibility() {
		TM_I4V_S01_App_URL_Accessibility();
	}

	@Test(enabled = true)
	public void I4V_S02_Check_Modules() {
		TM_I4V_S02_Check_Modules();
	}

	@Test(enabled = true)
	public void I4V_TC03_Check_Add_Application() {
		TM_TC03_Check_Add_Application();
	}

	@AfterMethod(enabled = true)
	public void AfterTest() {
		LogOutandQuit();
	}

	void TM_I4V_S01_App_URL_Accessibility(){
		Screen s = new Screen();
		Pattern AppGroups = new Pattern(path + "I4V_AppGroups.PNG");
		Pattern GroupName = new Pattern(path + "I4V_GroupName.PNG");
		Pattern AppGroupClose = new Pattern(path + "I4V_AppGroupCloseBtn.PNG");
		try {
			s.wait(AppGroups, 20);
			s.click(AppGroups);
			wait(2);
			s.wait(GroupName, 20);
			s.exists(GroupName);
			takeScreenshotAtEndOfTest();
			
			s.click(AppGroupClose);
			

		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	void TM_I4V_S02_Check_Modules(){
		Screen s = new Screen();
		Pattern Navigator = new Pattern(path + "I4V_Navigator.PNG");
		Pattern AppName = new Pattern(path + "I4V_AppName.PNG"); //
		Pattern Module = new Pattern(path + "I4V_Module.PNG");
		Pattern pdfFile = new Pattern(path + "I4V_PDF.PNG"); 
		try {
			s.wait(Navigator, 20);
			s.click(Navigator);

			s.wait(AppName, 20);
			s.click(AppName);
			wait(3);
			s.wait(Module, 20);
			s.click(Module);
			wait(3);
			
			s.exists(pdfFile);
			takeScreenshotAtEndOfTest();

		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	void TM_TC03_Check_Add_Application(){
		Screen s = new Screen();
		Pattern AppGroups = new Pattern(path + "I4V_AppGroups.PNG");
		Pattern AddAppBtn = new Pattern(path + "I4V_AddBtn.PNG");
		Pattern AddAppDetail = new Pattern(path + "I4V_AddApp.PNG");
		Pattern AddAppClose = new Pattern(path + "I4V_AddAppCloseBtn.PNG");
		Pattern AppGroupClose = new Pattern(path + "I4V_AppGroupCloseBtn.PNG");
		//
		try {
			s.wait(AppGroups, 20);
			s.click(AppGroups);

			s.wait(AddAppBtn, 20);
			s.click(AddAppBtn);
			
			s.wait(AddAppDetail, 20);
			s.exists(AddAppDetail);
			
			takeScreenshotAtEndOfTest();
			
			s.click(AddAppClose);
			
			s.wait(AppGroupClose, 20);
			s.click(AppGroupClose);

		} catch (FindFailed e) {
			e.printStackTrace();
		}

	}




	void LaunchandLoginI4V() {
		launchBrowser(Browser, DevURL);
		waitForPageLoaded();
		try {
			DecrptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {

			e.printStackTrace();
		}
		Screen s = new Screen();
		Pattern UserNameInput = new Pattern(path + "I4V_Username1.PNG");
		Pattern PasswordInput = new Pattern(path + "I4V_Password.PNG");
		Pattern LogInButton = new Pattern(path + "I4V_LoginBtn.PNG");
		Pattern WelcomeLbl = new Pattern(path + "I4VWelcomeLbl.PNG"); 
		try {
			s.wait(UserNameInput, 20);
			s.click(UserNameInput);
			s.type(Key.BACKSPACE);
			s.type(UserNameInput, username);
			s.type(PasswordInput, DecrptPassword);
			wait(3);
			s.wait(LogInButton, 20);
			s.click(LogInButton);

			s.wait(WelcomeLbl, 20);
			s.exists(WelcomeLbl);


			wait(5);
			takeScreenshotAtEndOfTest();

		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	void LogOutandQuit() {		
		Screen s = new Screen();	
		Pattern LogoutBtn = new Pattern(path + "I4V_Logout.PNG");
		try {
			s.click(LogoutBtn);
			driver.navigate().refresh();

		} catch (FindFailed e) {
			e.printStackTrace();
		}	
		driver.quit();
	}
}
