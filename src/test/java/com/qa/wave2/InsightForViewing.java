package com.qa.wave2;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class InsightForViewing extends CommonMethods {
	
	@Test(enabled = true, priority =1)
	public void InsightForViewing_FCSMSDEVAPPN01() {
		verifyWinSerStatus("FCSMSDEVAPPN01","Apache Tomcat 9.0 Tomcat9", "Running", "Auto");
		verifyWinSerStatus("FCSMSDEVAPPN01","Apache Tomcat 9.0 ", "Running", "Auto");
		verifyWinSerStatus("FCSMSDEVAPPN01","Tomcat9I4VRevie", "Running", "Auto");
	}
	
}