package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class GlobalSubmit extends CommonMethods {
	
	@Test(enabled = true, priority =1)
	public void GlobalSubmit_sjgsubappdevn01() {
		verifyWinSerStatus("sjgsubappdevn01","GlobalSubmit Message Listener", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =2)
	public void GlobalSubmit_sjgsubappprdn01() {
		verifyWinSerStatus("sjgsubappprdn01","GlobalSubmit Message Listener", "Running", "Auto");
	}

}