package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class GSEC_Powershell extends CommonMethods {
	
	@Test(enabled = true, priority =1)
	public void GSEC_sjgfapappvalg01() {
		verifyWinSerStatus("sjgfapappvalg01","Cb Protection Server", "Running", "Auto");
		verifyWinSerStatus("sjgfapappvalg01","Cb Protection Reporter", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =2)
	public void GSEC_sjgfapappdevg01() {
		verifyWinSerStatus("sjgfapappdevg01","Cb Protection Server", "Running", "Auto");
		verifyWinSerStatus("sjgfapappdevg01","Cb Protection Reporter", "Running", "Auto");
	}
	
}