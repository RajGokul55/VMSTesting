package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class WindowsServices extends CommonMethods {


	@Test(enabled = false, priority =1, groups = "Dev")
	public void DruvaInsyncECDB_PS01_WinServ_SJGCDBWEBPOCN01() {
		verifyWinSerStatus("SJGCDBWEBPOCN01", "Druva inSync AD Connector", "Running", "Auto");
		verifyWinSerStatus("SJGCDBWEBPOCN01", "Druva inSync Client Service", "Running", "Auto");
	}
	
	@Test(enabled = false, priority =2, groups = "Prod")
	public void DruvaInsyncECDB_PS02_WinServ_SJECDBCONPRDN01() {
		verifyWinSerStatus("sjECDBCONPRDN01", "Druva InSync AD Connector", "Running", "Auto");
	}
	
	@Test(enabled = false, priority =3, groups = "Prod")
	public void DruvaInsyncECDB_PS03_WinServ_DRECDBCONPRDN01() {
		verifyWinSerStatus("DRECDBCONPRDN01", "Druva inSync AD Connector", "Running", "Auto");
	}
	
	
	@Test(enabled = false, priority =4, groups = {"Test", "CLM"})
	public void CLM_EOCONAPPPRDN02() {
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Unified", "Running", "Auto");
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Unified2", "Running", "Auto");
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft DNS Trace Log Multiple Server File", "Running", "Auto");
	}	
	
	@Test(enabled = false, priority =5, groups = {"GlobalSubmit", "Dev"})
	public void GlobalSubmit_PS01_WinServ_SJGSUBAPPDEVN01() {
		verifyWinSerStatus("SJGSUBAPPDEVN01", "GlobalSubmit Message Listener", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =5, groups = {"InsightForViewingI4V", "Dev"})
	public void InsightForViewingI4V_PS01_WinServ_FCSMSDEVAPPN01() {
		verifyWinSerStatus("FCSMSDEVAPPN01", "Apache Tomcat 9.0 Tomcat9", "Running", "Auto");
		verifyWinSerStatus("FCSMSDEVAPPN01", "Apache Tomcat 9.0 Tomcat9I4VReview", "Running", "Auto"); 
	}
	
	@Test(enabled = true, priority =6, groups = {"VAP", "Dev"})
	public void VAP_PS01_WinServ_SJVAPAPPPRDN01() {
		verifyWinSerStatus("SJVAPAPPPRDN01", "Plant Web Optics OPC UA Server", "Running", "Auto");
		verifyWinSerStatus("SJVAPAPPPRDN01", "RDP services", "Running", "Auto"); 
		verifyWinSerStatus("SJVAPAPPPRDN01", "Ares Watchdog Services", "Running", "Auto"); 
	}
		
}