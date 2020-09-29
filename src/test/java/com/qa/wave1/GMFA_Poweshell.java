package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class GMFA_Poweshell extends CommonMethods {
	
	@Test(enabled = true, priority =1)
	public void GMFA_sjmfaappprdn01() {
		verifyWinSerStatus("sjmfaappprdn01.na.gilead.com","IIS Admin Service", "Running", "Auto");
		verifyWinSerStatus("sjmfaappprdn01.na.gilead.com", "MultifactorAuth", "Running", "Auto");
		verifyWinSerStatus("sjmfaappprdn01.na.gilead.com","MultifactorAuthAdSync", "Running", "Auto");
		verifyWinSerStatus("sjmfaappprdn01.na.gilead.com","MultiFactorAuthRadius World Wide Web Publishing Service", "Running", "Auto");
	}

}