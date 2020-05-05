package com.qa.wave1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class CLM extends CommonMethods {

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
		
		ADM_UserID = "adm_bgambhir";
		//password = RSA_Authentication("bpalle"); //nnereddula
		password = "Obo8N@ZEzUiW"; 

	}
	
	@Test(priority = 0, enabled = true)
	public void CLM_S01_WinSrve_EOCONAPPPRDN02() {
		TM_CLM_S01_WinSrve_EOCONAPPPRDN02();
	}
	
	@Test(priority = 1, enabled = true)
	public void CLM_S02_WinSrve_SJCLMAPPPRDN01() {
		TM_CLM_S02_WinSrve_SJCLMAPPPRDN01();
	}
	
	@Test(priority = 2, enabled = true)
	public void CLM_S03_WinSrve_SJCONAPPPRDN02() {
		TM_CLM_S03_WinSrve_SJCONAPPPRDN02();
	}
	 

	/***************************** * Test Methods	 ************************************/
	void TM_CLM_S01_WinSrve_EOCONAPPPRDN02() {
		createPS1HostnameServices(ADM_UserID, password, "EOCONAPPPRDN02", "arc_sjna2_dns_tracelog , arc_sjna2_wuc, arc_sjna2_wuc2");	
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_sjna2_dns_tracelog", "Stopped");
		verifyServiceStatus(resout, "arc_sjna2_wuc", "Running");
		verifyServiceStatus(resout, "arc_sjna2_wuc2", "Running");
	}
	
	void TM_CLM_S02_WinSrve_SJCLMAPPPRDN01() {
		createPS1HostnameServices(ADM_UserID, password, "SJCLMAPPPRDN01", "arc_sjna2_dns_tracelog");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_sjna2_dns_tracelog", "Running");
	}
	
	void TM_CLM_S03_WinSrve_SJCONAPPPRDN02() {
		createPS1HostnameServices(ADM_UserID, password, "SJCLMAPPPRDN01", "arc_sjna2_dns_tracelog");		
		runWindowsServerCheckBat(runbat);
		verifyServiceStatus(resout, "arc_sjna2_dns_tracelog", "Running");
		
	}
	
}
