package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class GFAP_Poweshell extends CommonMethods {
	
	@Test(enabled = true, priority =1)
	public void GFAP_sjb9appdevn01() {
		verifyWinSerStatus("sjb9appdevn01","Varonis Data Privilege Commit Service", "Running", "Auto");
		verifyWinSerStatus("sjb9appdevn01","Varonis Data Privilege Scheduler Service", "Running", "Auto");
		verifyWinSerStatus("sjb9appdevn01","VaronisData Privileged synchronization Service", "Running", "Auto");
	}
	
}