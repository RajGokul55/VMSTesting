package com.qa.wave3;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class SCORCH_Services extends CommonMethods {


	@Test(enabled = false, priority =1, groups = "Dev")
	public void SCORCH_Dev_ManagementServer_sjscrhappdevn01() {
		verifyWinSerStatus("sjscrhappdevn01", "Orchestrator Management Service", "Running","Auto");
		verifyWinSerStatus("sjscrhappdevn01", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappdevn01", "Orchestrator Runbook Server Monitor", "Running","Auto");
		verifyWinSerStatus("sjscrhappdevn01", "Orchestrator Runbook Service", "Running","Auto");
		
	}
	
	@Test(enabled = false, priority =2, groups = "Dev")
	public void SCORCH_Dev_RunbookServer_sjscrhappdevn02() {
		verifyWinSerStatus("sjscrhappdevn02", "Orchestrator Management Service", "Running","Auto");
		verifyWinSerStatus("sjscrhappdevn02", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappdevn02", "Orchestrator Runbook Service", "Running", "Auto");
		
	}
	
	@Test(enabled = true, priority =3, groups = "Prod")
	public void SCORCH_Prod_ManagementServer_sjscrhappprdn01() {
		verifyWinSerStatus("sjscrhappprdn01", "Orchestrator Management Service", "Running","Auto");
		verifyWinSerStatus("sjscrhappprdn01", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappprdn01", "Orchestrator Runbook Service", "Running", "Auto");
		
		
	}
	
	@Test(enabled = true, priority =4, groups = "Prod")
	public void SCORCH_Prod_RunbookServer_sjscrhappprdn02() {
		verifyWinSerStatus("sjscrhappprdn02", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappprdn02", "Orchestrator Runbook Service", "Running", "Auto");
		
	}
	
	@Test(enabled = true, priority =5, groups = "Prod")
	public void SCORCH_Prod_RunbookServer_sjscrhappprdn03() {
		verifyWinSerStatus("sjscrhappprdn03", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappprdn03", "Orchestrator Runbook Service", "Running", "Auto");
		
	}
	
	@Test(enabled = true, priority =6, groups = "Prod")
	public void SCORCH_Prod_RunbookDesignerServer_sjscrhappprdn04() {
		verifyWinSerStatus("sjscrhappprdn04", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("sjscrhappprdn04", "Orchestrator Runbook Service", "Running", "Auto");
		
	}
	
	@Test(enabled = false, priority =7, groups = "DR")
	public void SCORCH_DR_RunbookManagementServer_drscrhappprdn01() {
		verifyWinSerStatus("drscrhappprdn01", "Orchestrator Management Service", "Running","Auto");
		verifyWinSerStatus("drscrhappprdn01", "Orchestrator Remoting Service", "Running", "Auto");
		verifyWinSerStatus("drscrhappprdn01", "Orchestrator Runbook Service", "Running", "Auto");
		
	}
	
	
}