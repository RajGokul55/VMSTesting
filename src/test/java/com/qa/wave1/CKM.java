package com.qa.wave1;

import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class CKM extends CommonMethods {


	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\SiKuli\\CKM\\";
		final String username = "rdmst01";
	final String password = "gilead01";

	/***************************** Test Cases *******************/
	@BeforeMethod(enabled = true)
	public void  RDP_Connection () {
		String Password = RSA_Authentication("ADM_nnereddula");
		RDP_Connection("SJCKMAPPPRDN04","ADM_nnereddula",Password);
	}
	
	@Test(enabled = true)
	public void CKM_S01_StatusOfServices() {
		TM_CKM_S01_StatusOfServices();
	}
	@Test(enabled = true)
	public void CKM_S02_Guardingpoints() {
		TM_CKM_S02_Guardingpoints();
	}
	
	
	void TM_RTD_S01_URLAccesibility() {
		Screen s = new Screen();
		Pattern RTDSPSDev = new Pattern(path + "CR_RTD_SPS_Dev.PNG");
		s.exists(RTDSPSDev);
		Reporter.log("Home page got displyed successfully");
		takeScreenshotAtSikuli();
		
	}
	void TM_CKM_S01_StatusOfServices() {
		Screen s = new Screen();
		Pattern homepage = new Pattern(path + "CKM_home.PNG");
		Pattern startbutton = new Pattern(path + "CKM_home2.PNG"); 
		Pattern tools = new Pattern(path + "CKM_tools.PNG"); 
		Pattern taskscheduler = new Pattern(path + "CKM_taskscheduler.PNG"); 
		Pattern taskscheduler2 = new Pattern(path + "CKM_taskscheduler2.PNG"); 
		
		
		try {
			s.click(startbutton);
			wait(2);
			s.doubleClick(tools);
			wait(30);
			s.click(taskscheduler);
			wait(30);
			s.click(taskscheduler2);
			s.exists(taskscheduler2);
			//Reporter.log("I4V Icon displayed on desktop successfully");
				takeScreenshotAtSikuli();
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
			void TM_CKM_S02_Guardingpoints() {
				Screen s = new Screen();
				Pattern hiddenicons = new Pattern(path + "CKM_hiddenicon.PNG"); 
				Pattern view = new Pattern(path + "CKM_view.PNG");
				Pattern filesystem = new Pattern(path + "CKM_filesystem.PNG");
				Pattern guardpoints = new Pattern(path + "CKM_guardpoints.PNG");
				Pattern logout = new Pattern(path + "CKM_disconnect.PNG");
				
				try {
					s.click(hiddenicons);
					//Reporter.log("LorenDocBridge Icon displayed on desktop successfully");
				
			s.click(view);
			wait(30);
			s.click(filesystem);
			wait(30);
			s.click(guardpoints);
			wait(30);
			s.click(logout);
			takeScreenshotAtSikuli();
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
		}
	