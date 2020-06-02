package com.qa.wave3;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class WindowsServices extends CommonMethods {


	@Test(enabled = true, priority =1, groups = {"Bartender", "Prod"})
	public void Bartender_PS01_WinServ_ccbartappprdg01() {
		verifyWinSerStatus("ccbartappprdg01", "BarTender Licencing Service", "Running", "Auto");
		verifyWinSerStatus("ccbartappprdg01", "BarTender System Service", "Running", "Auto");
	}
}
