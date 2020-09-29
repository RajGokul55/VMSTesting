package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class GEP_Powershell extends CommonMethods {
	
	@Test(enabled = true, priority =1)
	public void GEP_SJGEPAPPPRDN01() {
		verifyWinSerStatus("SJGEPAPPPRDN01","Symantec EndPoint Protection", "Running", "Auto");
		verifyWinSerStatus("SJGEPAPPPRDN01","Symantec EndPoint Protection Local Proxy Services", "Running", "Auto");
		verifyWinSerStatus("SJGEPAPPPRDN01","Symantec EndPoint Protection WSC Service", "Running", "Auto");
	}

}