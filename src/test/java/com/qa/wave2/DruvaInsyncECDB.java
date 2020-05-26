package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class DruvaInsyncECDB extends CommonMethods {


	@Test(enabled = true, priority =1)
	public void DruvaInsyncECDB_PS01_WinServ_SJGCDBWEBPOCN01() {
		verifyWinSerStatus("SJGCDBWEBPOCN01", "Druva inSync AD Connector", "Running", "Auto");
		verifyWinSerStatus("SJGCDBWEBPOCN01", "Druva inSync Client Service", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =2)
	public void DruvaInsyncECDB_PS02_WinServ_SJECDBCONPRDN01() {
		verifyWinSerStatus("sjECDBCONPRDN01", "Druva InSync AD Connector", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =3)
	public void DruvaInsyncECDB_PS03_WinServ_DRECDBCONPRDN01() {
		verifyWinSerStatus("DRECDBCONPRDN01", "Druva inSync AD Connector", "Running", "Auto");
	}
	
}