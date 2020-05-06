package com.qa.wave1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;


public class GFAP extends CommonMethods {

	/***************************** Test Data ************************************/

	static final String userDirectory = System.getProperty("user.dir");
	
	String path = userDirectory + "\\AutoFiles\\";
	String resout = path + "Output.txt";
	String runbat = path + "Run.bat";
	String ADM_UserID = null;
	String password = null;

	/***************************** Test ************************************/
	@BeforeMethod(enabled = true)
	public void BeforeRunningTest() {
		
		ADM_UserID = "adm_sgupta27";
		//password = RSA_Authentication("sgupta27"); 
		password = "C7jfIO?C%4Cw"; 
		
		}
	
	@Test(priority = 0, enabled = false)
	public void GFAP_S01_WinSrve_FCGFAMCLNPRDG01() {
		TM_GFAP_S01_WinSrve_FCGFAMCLNPRDG01();		
	}
	
	@Test(priority = 1, enabled = false)
	public void GFAP_S02_WinSrve_FCGFAMCLNPRDG02() {
		TM_GFAP_S02_WinSrve_FCGFAMCLNPRDG02();
	}
	@Test(priority = 2, enabled = false)
	public void GFAP_S03_WinSrve_FCGFAPAPPPRDG01() {
		TM_GFAP_S03_WinSrve_FCGFAPAPPPRDG01();		
	}
	
	@Test(priority = 3, enabled = false) // Server unavailable
	public void GFAP_S04_WinSrve_FCGFAPAPPPRDG02() {
		TM_GFAP_S04_WinSrve_FCGFAPAPPPRDG02();
	}
	@Test(priority = 4, enabled = false)
	public void GFAP_S05_WinSrve_FCGFAPAPPTSTG01() {
		TM_GFAP_S05_WinSrve_FCGFAPAPPTSTG01();		
	}
	
	@Test(priority = 5, enabled = false) // Server unavailable
	public void GFAP_S06_WinSrve_SJGFAPAPPDEVG01() {
		TM_GFAP_S06_WinSrve_SJGFAPAPPDEVG01();
	}
	@Test(priority = 6, enabled = true)
	public void GFAP_S07_WinSrve_SJGFAPAPPTSTG01() {
		TM_GFAP_S07_WinSrve_SJGFAPAPPTSTG01();		
	}
	
	@Test(priority = 7, enabled = false) // Server unavailable
	public void GFAP_S08_WinSrve_SJGFAPAPPVALG01() {
		TM_GFAP_S08_WinSrve_SJGFAPAPPVALG01();
	}
	@Test(priority = 8, enabled = false) // Server unavailable
	public void GFAP_S09_WinSrve_SJGFAPAPPVALG02() {
		TM_GFAP_S09_WinSrve_SJGFAPAPPVALG02();		
	}
	
	

	/***************************** * Test Methods	 ************************************/
	void TM_GFAP_S01_WinSrve_FCGFAMCLNPRDG01() {

		createPS1HostnameServices(ADM_UserID, password, "FCGFAMCLNPRDG01", "DPCommitSrv , vrnsService, SynchronizationService");
		runWindowsServerCheckBat(runbat);

		verifyServiceStatus(resout, "DPCommitSrv", "Stopped");
		verifyServiceStatus(resout, "vrnsService", "Running");
		verifyServiceStatus(resout, "SynchronizationService", "Running");
	}
	
	void TM_GFAP_S02_WinSrve_FCGFAMCLNPRDG02() {

		createPS1HostnameServices(ADM_UserID, password, "FCGFAMCLNPRDG02", "DPCommitSrv , vrnsService, SynchronizationService");
		runWindowsServerCheckBat(runbat);

		verifyServiceStatus(resout, "DPCommitSrv", "Stopped");
		verifyServiceStatus(resout, "vrnsService", "Running");
		verifyServiceStatus(resout, "SynchronizationService", "Running");
	}
	void TM_GFAP_S03_WinSrve_FCGFAPAPPPRDG01() {

		createPS1HostnameServices(ADM_UserID, password, "FCGFAPAPPPRDG01", "DPCommitSrv , vrnsService, SynchronizationService");
		runWindowsServerCheckBat(runbat);

		verifyServiceStatus(resout, "DPCommitSrv", "Stopped");
		verifyServiceStatus(resout, "vrnsService", "Running");
		verifyServiceStatus(resout, "SynchronizationService", "Running");
	}
	void TM_GFAP_S04_WinSrve_FCGFAPAPPPRDG02() {

		createPS1HostnameServices(ADM_UserID, password, "FCGFAPAPPPRDG02", "DPCommitSrv , vrnsService, SynchronizationService");
		runWindowsServerCheckBat(runbat);

		verifyServiceStatus(resout, "DPCommitSrv", "Stopped");
		verifyServiceStatus(resout, "vrnsService", "Running");
		verifyServiceStatus(resout, "SynchronizationService", "Running");
	}
	void TM_GFAP_S05_WinSrve_FCGFAPAPPTSTG01() {

		createPS1HostnameServices(ADM_UserID, password, "FCGFAPAPPTSTG01", "DPCommitSrv , vrnsService, SynchronizationService");
		runWindowsServerCheckBat(runbat);

		verifyServiceStatus(resout, "DPCommitSrv", "Stopped");
		verifyServiceStatus(resout, "vrnsService", "Running");
		verifyServiceStatus(resout, "SynchronizationService", "Running");
	}
	void TM_GFAP_S06_WinSrve_SJGFAPAPPDEVG01() {

		createPS1HostnameServices(ADM_UserID, password, "SJGFAPAPPDEVG01", " vrnsService, SynchronizationService");
		runWindowsServerCheckBat(runbat);

		//verifyServiceStatus(resout, "DPCommitSrv", "Stopped");
		verifyServiceStatus(resout, "vrnsService", "Running");
		verifyServiceStatus(resout, "SynchronizationService", "Running");
	}
	void TM_GFAP_S07_WinSrve_SJGFAPAPPTSTG01() {

		createPS1HostnameServices(ADM_UserID, password, "SJGFAPAPPTSTG01", "DPCommitSrv , vrnsService, SynchronizationService");
		runWindowsServerCheckBat(runbat);

		verifyServiceStatus(resout, "DPCommitSrv", "Stopped");
		verifyServiceStatus(resout, "vrnsService", "Running");
		verifyServiceStatus(resout, "SynchronizationService", "Running");
	}
	void TM_GFAP_S08_WinSrve_SJGFAPAPPVALG01() {

		createPS1HostnameServices(ADM_UserID, password, "SJGFAPAPPVALG01", "DPCommitSrv , vrnsService, SynchronizationService");
		runWindowsServerCheckBat(runbat);

		verifyServiceStatus(resout, "DPCommitSrv", "Stopped");
		verifyServiceStatus(resout, "vrnsService", "Running");
		verifyServiceStatus(resout, "SynchronizationService", "Running");
	}
	void TM_GFAP_S09_WinSrve_SJGFAPAPPVALG02() {

		createPS1HostnameServices(ADM_UserID, password, "SJGFAPAPPVALG02", "DPCommitSrv , vrnsService, SynchronizationService");
		runWindowsServerCheckBat(runbat);

		verifyServiceStatus(resout, "DPCommitSrv", "Stopped");
		verifyServiceStatus(resout, "vrnsService", "Running");
		verifyServiceStatus(resout, "SynchronizationService", "Running");
	}

}
