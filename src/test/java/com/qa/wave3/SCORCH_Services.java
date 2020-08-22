package com.qa.wave3;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class SCORCH_Services extends CommonMethods {


	@Test(enabled = true, priority =1, groups = "Dev")
	public void SCORCH_Dev_ManagementServer_sjscrhappdevn01() {
		verifyWinSerStatus("sjscrhappdevn01.na.gilead.com", "Orchestrator Management Service", "Running","Auto");
		verifyWinSerStatus("sjscrhappdevn01.na.gilead.com", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappdevn01.na.gilead.com", "Orchestrator Runbook Server Monitor", "Running","Auto");
		verifyWinSerStatus("sjscrhappdevn01.na.gilead.com", "Orchestrator Runbook Service", "Running","Auto");
		
	}
	
	@Test(enabled = false, priority =2, groups = "Dev")
	public void SCORCH_Dev_RunbookServer_sjscrhappdevn02() {
		verifyWinSerStatus("sjscrhappdevn02.na.gilead.com", "Orchestrator Management Service", "Running","Auto");
		verifyWinSerStatus("sjscrhappdevn02.na.gilead.com", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappdevn02.na.gilead.com", "Orchestrator Runbook Service", "Running", "Auto");
		
	}
	
	@Test(enabled = false, priority =3, groups = "Prod")
	public void SCORCH_Prod_ManagementServer_sjscrhappprdn01() {
		verifyWinSerStatus("sjscrhappprdn01.na.gilead.com", "Orchestrator Management Service", "Running","Auto");
		verifyWinSerStatus("sjscrhappprdn01.na.gilead.com", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappprdn01.na.gilead.com", "Orchestrator Runbook Service", "Running", "Auto");
		
	}
	
	@Test(enabled = false, priority =4, groups = "Prod")
	public void SCORCH_Prod_RunbookServer_sjscrhappprdn02() {
		verifyWinSerStatus("sjscrhappprdn02.na.gilead.com", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappprdn02.na.gilead.com", "Orchestrator Runbook Service", "Running", "Auto");
		
	}
	
	@Test(enabled = false, priority =5, groups = "Prod")
	public void SCORCH_Prod_RunbookServer_sjscrhappprdn03() {
		verifyWinSerStatus("sjscrhappprdn03.na.gilead.com", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappprdn03.na.gilead.com", "Orchestrator Runbook Service", "Running", "Auto");
		
	}
	
	@Test(enabled = false, priority =6, groups = "Prod")
	public void SCORCH_Prod_RunbookDesignerServer_sjscrhappprdn04() {
		verifyWinSerStatus("sjscrhappprdn04.na.gilead.com", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappprdn04.na.gilead.com", "Orchestrator Runbook Service", "Running", "Auto");
		
	}
	
	@Test(enabled = false, priority =7, groups = "DR")
	public void SCORCH_DR_RunbookManagementServer_drscrhappprdn01() {
		verifyWinSerStatus("drscrhappprdn01.na.gilead.com", "Orchestrator Management Service", "Running","Auto");
		verifyWinSerStatus("drscrhappprdn01.na.gilead.com", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("drscrhappprdn01.na.gilead.com", "Orchestrator Runbook Service", "Running", "Auto");
		
	}
	
	
}