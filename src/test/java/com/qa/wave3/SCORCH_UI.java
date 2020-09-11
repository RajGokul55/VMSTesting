package com.qa.wave3;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;

public class SCORCH_UI extends CommonMethods {
	
	/***************************** Test Data *******************/

	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\SiKuli\\";

	/***************************** Test Cases *******************/

	@BeforeMethod(enabled = true)
	public void BeforeMethod() throws IOException {

	}

	@Test(priority = 0, enabled = false)
	public void SCORCH_Web_Dev_Webportal() throws IOException {
		TM_SCORCH_S01_Web_Dev_Webportal();
	}

	@Test(priority = 1, enabled = true)
	public void SCORCH_Web_Prod_Webportal() throws IOException {
		TM_SCORCH_S02_Web_Prod_Webportal();
	}

	@AfterMethod(enabled = true)
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Test Case Methods *******************/

	public void TM_SCORCH_S01_Web_Dev_Webportal() throws IOException {
		final String Browser = "IE";
		final String DevURL = "http://sjscrhappdevn01:82/";
		final String URL = DevURL;
		launchBrowser(Browser, URL);
		Screen S = new Screen();
		Pattern RunbookServers = new Pattern(path + "SC_RBServers.PNG");
		Pattern Instances= new Pattern(path + "SC_Instances.PNG");
		Pattern Events = new Pattern(path + "SC_Events.PNG");
		Pattern EventDetails= new Pattern(path + "SC_EventDetails.PNG");
		

		try {

			S.doubleClick(RunbookServers);
			wait(10);

			S.exists(Instances);
			Reporter.log("Runbook servers details are displayed");
			takeScreenshotAtSikuli();
			
			S.doubleClick(Events);
			wait(10);

			S.exists(EventDetails);
			Reporter.log("Events details are displayed");
			takeScreenshotAtSikuli();
			
			


		} catch (FindFailed e) {
			e.printStackTrace();
		}

	}

	public void TM_SCORCH_S02_Web_Prod_Webportal() throws IOException {
		
		final String Browser = "IE";
		final String ProdURL = "http://sjscrhappprdn01:82/ ";
		final String URL = ProdURL;
		launchBrowser(Browser, URL);
		Screen S = new Screen();
		Pattern RunbookServers = new Pattern(path + "SC_RBServers.PNG");
		Pattern Instances= new Pattern(path + "SC_Instances.PNG");
		Pattern Events = new Pattern(path + "SC_Events.PNG");
		Pattern EventDetails= new Pattern(path + "SC_EventDetails.PNG");
		

		try {

			S.doubleClick(RunbookServers);
			wait(10);

			S.exists(Instances);
			Reporter.log("Runbook servers details are displayed");
			takeScreenshotAtSikuli();
			
			S.doubleClick(Events);
			wait(10);

			S.exists(EventDetails);
			Reporter.log("Events details are displayed");
			takeScreenshotAtSikuli();
			
			} catch (FindFailed e) {
			e.printStackTrace();
		}

	}

}
