package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class DruvaInsyncECDB extends CommonMethods {


	@Test(enabled = false, priority =1, groups = "Dev")
	public void DruvaInsyncECDB_PS01_WinServ_SJGCDBWEBPOCN01() {
		verifyWinSerStatus("SJGCDBWEBPOCN01", "Druva inSync AD Connector", "Running", "Auto");
		verifyWinSerStatus("SJGCDBWEBPOCN01", "Druva inSync Client Service", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =2, groups = "Prod")
	public void DruvaInsyncECDB_PS02_WinServ_SJECDBCONPRDN01() {
		verifyWinSerStatus("sjECDBCONPRDN01", "Druva InSync AD Connector", "Running", "Auto");
	}
	
	@Test(enabled = false, priority =3, groups = "Prod")
	public void DruvaInsyncECDB_PS03_WinServ_DRECDBCONPRDN01() {
		verifyWinSerStatus("DRECDBCONPRDN01", "Druva inSync AD Connector", "Running", "Auto");
	}
	
	
	@Test(enabled = true, priority =2, groups = "Test")
	public void CLM_EOCONAPPPRDN02() {
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Unified", "Running", "Auto");
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Unified2", "Running", "Auto");
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft DNS Trace Log Multiple Server File", "Running", "Auto");
				

	}
	
}