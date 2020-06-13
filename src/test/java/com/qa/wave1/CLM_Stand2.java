package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class CLM_Stand2 extends CommonMethods {


	@Test(enabled = true, priority =1, groups = "Prod")
	public void CLM_SECONAPPPRDN02() {
		verifyWinSerStatus("SECONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Native", "Running", "Auto");
		verifyWinSerStatus("SECONAPPPRDN02", "ArcSight Microsoft DNS Trace Log Multiple Server File", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =2,groups = "Prod")
	public void CLM_LDCONAPPPRDN02() {
		verifyWinSerStatus("LDCONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Unified", "Running", "Auto");
		verifyWinSerStatus("LDCONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Unified2", "Running", "Auto");
		verifyWinSerStatus("LDCONAPPPRDN02", "ArcSight Microsoft DNS Trace Log Multiple Server File", "Running", "Auto");
	}
}