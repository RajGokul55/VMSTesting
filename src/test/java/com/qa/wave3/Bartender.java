package com.qa.wave3;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class Bartender extends CommonMethods {
	
	@Test(enabled = true, priority =1)
	public void Bartender_ccbartappprdg01() {
		verifyWinSerStatus("ccbartappprdg01","Bartender Licensing Service", "Running", "Auto");
		verifyWinSerStatus("ccbartappprdg01","Bartender System Service", "Running", "Auto");
	}
	
}