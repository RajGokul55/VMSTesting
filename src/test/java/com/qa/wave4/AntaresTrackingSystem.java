package com.qa.wave4;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class AntaresTrackingSystem extends CommonMethods {


	@Test(enabled = true, priority =1, groups = "Dev")
	public void AntaresTrackingSystem_CCATSAPPDEVN01() {
		verifyWinSerStatus("CCATSAPPDEVN01", "ITS Antares Tracking System Service", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =2,groups = "SQA")
	public void AntaresTrackingSystem_CCATSAPPSQAN01() {
		verifyWinSerStatus("CCATSAPPSQAN01", "ITS Antares Tracking System Service", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =3,groups = "UAT")
	public void AntaresTrackingSystem_CCATSAPPUATN01() {
		verifyWinSerStatus("CCATSAPPUATN01", "ITS Antares Tracking System Service", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =4,groups = "Prod")
	public void AntaresTrackingSystem_CCATSAPPPRDG01() {
		verifyWinSerStatus("CCATSAPPPRDG01", "ITS Antares Tracking System Service", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =5,groups = "Dev")
	public void AntaresTrackingSystem_CCATSSQLDEVN01() {
		verifyWinSerStatus("CCATSSQLDEVN01", "SQL Server(MSSQLSERVER)", "Running", "Auto");
		verifyWinSerStatus("CCATSSQLDEVN01", "SQL Server Agent", "Running", "Auto");
		verifyWinSerStatus("CCATSSQLDEVN01", "SQL Server VSS Writer", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =6,groups = "SQA")
	public void AntaresTrackingSystem_CCATSSQLSQAN01() {
		verifyWinSerStatus("CCATSSQLSQAN01", "SQL Server(MSSQLSERVER)", "Running", "Auto");
		verifyWinSerStatus("CCATSSQLSQAN01", "SQL Server Agent", "Running", "Auto");
		verifyWinSerStatus("CCATSSQLSQAN01", "SQL Server VSS Writer", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =7,groups = "UAT")
	public void AntaresTrackingSystem_CCATSSQLUATN01() {
		verifyWinSerStatus("CCATSSQLUATN01", "SQL Server(MSSQLSERVER)", "Running", "Auto");
		verifyWinSerStatus("CCATSSQLUATN01", "SQL Server Agent", "Running", "Auto");
		verifyWinSerStatus("CCATSSQLUATN01", "SQL Server VSS Writer", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =8,groups = "Prod")
	public void AntaresTrackingSystem_CCSQLCLNPRDG04() {
		verifyWinSerStatus("CCSQLCLNPRDG04", "SQL Server(MSSQLSERVER)", "Running", "Auto");
		verifyWinSerStatus("CCSQLCLNPRDG04", "SQL Server Agent", "Running", "Auto");
		verifyWinSerStatus("CCSQLCLNPRDG04", "SQL Server VSS Writer", "Running", "Auto");
	}
	
}