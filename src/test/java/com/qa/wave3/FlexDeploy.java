package com.qa.wave3;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.testng.Assert;
import org.testng.Reporter;

public class FlexDeploy extends CommonMethods {

	/***************************** Test Data *******************/
	
	
	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\SiKuli\\";
	

	/***************************** Test Cases *******************/
	

	@BeforeMethod
	public void beforeMethod() {
		
	}

	@Test(priority = 0, enabled = false)
	public void FlexDeploy_S01_Web_Dev_UserLogin() throws IOException {
		TM_FlexDeploy_S01_Web_DevUserLogin_ReleasesTab();
	}

	@Test(priority = 1, enabled = false)
	public void FlexDeploy_S02_Web_Dev_() throws IOException {
		TM_FlexDeploy_S02_Web_Dev_Pipelines();
	}

	@Test(priority = 2, enabled = true)
	public void FlexDeploy_S03_Web_VAL_UserLogin() throws IOException {
		TM_FlexDeploy_S03_Web_VALUserLogin_ReleasesTab();
	}

	@Test(priority = 3, enabled = false)
	public void FlexDeploy_S02_Web_VAL_() throws IOException {
		TM_FlexDeploy_S04_Web_VAL_Pipelines();
	}

	@Test(priority = 4, enabled = false)
	public void FlexDeploy_S05_Web_Prod_UserLogin() throws IOException {
		TM_FlexDeploy_S05_Web_ProdUserLogin_ReleasesTab();
	}

	@Test(priority = 5, enabled = false)
	public void FlexDeploy_S06_Web_Prod_() throws IOException {
		TM_FlexDeploy_S06_Web_Prod_Pipelines();
	}

	@AfterMethod
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	
	By ipt_Username = By.xpath("//input[@id='it1::content']");
	By ipt_Password = By.xpath("//input[@id='it2::content']");
	By btn_Login = By.xpath("//span[contains(text(),'Login')]");
	By lnk_StartedRelease = By.xpath("(//span[text()='Started'])[1]/preceding::td[1]");
	By lnk_StartedRelease_VAL = By.xpath("(//span[text()='Started'])[1]/preceding::td[1]/span/a");
	By ipt_Releaseconfiguration = By.xpath("//*[contains(text(),'Release Configuration')]");
	By ipt_ReleaseStartScreen = By.xpath("//*[contains(text(),'Started')]");
	By ipt_PipelineName = By.xpath("//div[contains(text(),'Pipeline Name')]");
	By lnk_Pipeline = By.xpath("(//td[@class='xir'])[3]/span/a");
	By ipt_PLName = By.xpath("//label[contains(text(),'Name')]");

	/***************************** Test Case Methods *******************/

	public void TM_FlexDeploy_S01_Web_DevUserLogin_ReleasesTab() throws IOException {
		final String Browser= "Chrome";
		final String DevUrl= "http://sjfxdpodbdevg01.na.gilead.com:8000/flexdeploy";
		final String Username = "dmarkanti";
		String DecryptPassword = null;
		final String EncryptPassword = "gauEQnlth0rzudo2rv35/A==";
		launchBrowser(Browser, DevUrl);
		try {
			DecryptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.clear();
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Password);
		Password_Ipt.clear();
		Password_Ipt.sendKeys(DecryptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "FlexDeploy - Home", "FlexDeploy Home page is not displayed");

		Screen s = new Screen();
		Pattern StartedRelease = new Pattern(path + "FD_Releases.PNG");
		try {
			s.click(StartedRelease);
			wait(30);

			takeScreenshotAtEndOfTest();
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		waitForPageLoaded();
		WebElement StartedRelease_lnk = createWebElementBy(lnk_StartedRelease);
		StartedRelease_lnk.click();
		
		waitForPageLoaded();
		WebElement StartReleaseScreen_ipt = createWebElementBy(ipt_ReleaseStartScreen);
		String SRS = StartReleaseScreen_ipt.getText();
		Assert.assertEquals(SRS,"Started", "Started is not displayed");
		takeScreenshotAtEndOfTest();
		
	}

	public void TM_FlexDeploy_S02_Web_Dev_Pipelines() throws IOException {
		final String Browser= "Chrome";
		final String DevUrl= "http://sjfxdpodbdevg01.na.gilead.com:8000/flexdeploy";
		final String Username = "dmarkanti";
		String DecryptPassword = null;
		final String EncryptPassword = "gauEQnlth0rzudo2rv35/A==";
		launchBrowser(Browser, DevUrl);
		try {
			DecryptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.clear();
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Password);
		Password_Ipt.clear();
		Password_Ipt.sendKeys(DecryptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "FlexDeploy - Home", "FlexDeploy Home page is not displayed");

		Screen s = new Screen();
		Pattern Pipelines = new Pattern(path + "FD_Pipelines.PNG");
		try {
			s.click(Pipelines);
			wait(30);

			takeScreenshotAtEndOfTest();
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		
		waitForPageLoaded();
		
		WebElement PipelineName_ipt = createWebElementBy(ipt_PipelineName);
		String PLN = PipelineName_ipt.getText();
		Assert.assertEquals(PLN,"Pipeline Name", "Started is not displayed");
		WebElement Link_Pipeline = createWebElementBy(lnk_Pipeline);
		Link_Pipeline.click();
		waitForPageLoaded();
		WebElement PLName_ipt = createWebElementBy(ipt_PLName);
		String PL = PLName_ipt.getText();
		Assert.assertEquals(PL,"Name", "Pipeline Name is not displayed");
		takeScreenshotAtEndOfTest();
		
	}

	public void TM_FlexDeploy_S03_Web_VALUserLogin_ReleasesTab() throws IOException {
		final String Browser= "Chrome";
		final String VALUrl= "http://sjfxdpappvalg01.na.gilead.com:8000/flexdeploy";
		final String Username = "dmarkanti";
		String DecryptPassword = null;
		final String EncryptPassword = "gauEQnlth0rzudo2rv35/A==";
		launchBrowser(Browser, VALUrl);
		try {
			DecryptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.clear();
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Password);
		Password_Ipt.clear();
		Password_Ipt.sendKeys(DecryptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "FlexDeploy - Home", "FlexDeploy Home page is not displayed");

		Screen s = new Screen();
		Pattern StartedRelease = new Pattern(path + "FD_Releases.PNG");
		try {
			s.click(StartedRelease);
			wait(30);

			takeScreenshotAtEndOfTest();
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		waitForPageLoaded();
		WebElement StartedRelease_lnk = createWebElementBy(lnk_StartedRelease_VAL);
		StartedRelease_lnk.click();
		
		waitForPageLoaded();
		WebElement StartReleaseScreen_ipt = createWebElementBy(ipt_ReleaseStartScreen);
		String SRS = StartReleaseScreen_ipt.getText();
		Assert.assertEquals(SRS,"Started", "Started is not displayed");
		takeScreenshotAtEndOfTest();
		
		
	}

	public void TM_FlexDeploy_S04_Web_VAL_Pipelines() throws IOException {
		final String Browser= "Chrome";
		final String DevUrl= "http://sjfxdpappvalg01.na.gilead.com:8000/flexdeploy";
		final String Username = "dmarkanti";
		String DecryptPassword = null;
		final String EncryptPassword = "gauEQnlth0rzudo2rv35/A==";
		launchBrowser(Browser, DevUrl);
		try {
			DecryptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.clear();
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Password);
		Password_Ipt.clear();
		Password_Ipt.sendKeys(DecryptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "FlexDeploy - Home", "FlexDeploy Home page is not displayed");

		Screen s = new Screen();
		Pattern Pipelines = new Pattern(path + "FD_Pipelines.PNG");
		try {
			s.click(Pipelines);
			wait(30);

			takeScreenshotAtEndOfTest();
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		
		waitForPageLoaded();
		
		WebElement PipelineName_ipt = createWebElementBy(ipt_PipelineName);
		String PLN = PipelineName_ipt.getText();
		Assert.assertEquals(PLN,"Pipeline Name", "Started is not displayed");
		WebElement Link_Pipeline = createWebElementBy(lnk_Pipeline);
		Link_Pipeline.click();
		waitForPageLoaded();
		WebElement PLName_ipt = createWebElementBy(ipt_PLName);
		String PL = PLName_ipt.getText();
		Assert.assertEquals(PL,"Name", "Pipeline Name is not displayed");
		takeScreenshotAtEndOfTest();

	}

	public void TM_FlexDeploy_S05_Web_ProdUserLogin_ReleasesTab() throws IOException {
		final String Browser= "Chrome";
		final String ProdUrl= "http://sjfxdpappprdn01.na.gilead.com:8000/flexdeploy";
		final String Username = "dmarkanti";
		String DecryptPassword = null;
		final String EncryptPassword = "gauEQnlth0rzudo2rv35/A==";
		launchBrowser(Browser, ProdUrl);
		try {
			DecryptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.clear();
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Password);
		Password_Ipt.clear();
		Password_Ipt.sendKeys(DecryptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "FlexDeploy - Home", "FlexDeploy Home page is not displayed");

		Screen s = new Screen();
		Pattern StartedRelease = new Pattern(path + "FD_Releases.PNG");
		try {
			s.click(StartedRelease);
			wait(30);

			takeScreenshotAtEndOfTest();
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		waitForPageLoaded();
		WebElement StartedRelease_lnk = createWebElementBy(lnk_StartedRelease);
		StartedRelease_lnk.click();
		
		waitForPageLoaded();
		WebElement StartReleaseScreen_ipt = createWebElementBy(ipt_ReleaseStartScreen);
		String SRS = StartReleaseScreen_ipt.getText();
		Assert.assertEquals(SRS,"Started", "Started is not displayed");
		takeScreenshotAtEndOfTest();
		
		
		}

	public void TM_FlexDeploy_S06_Web_Prod_Pipelines() throws IOException {
		final String Browser= "Chrome";
		final String DevUrl= "http://sjfxdpappprdn01.na.gilead.com:8000/flexdeploy";
		final String Username = "dmarkanti";
		String DecryptPassword = null;
		final String EncryptPassword = "gauEQnlth0rzudo2rv35/A==";
		launchBrowser(Browser, DevUrl);
		try {
			DecryptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.clear();
		Username_Ipt.sendKeys(Username);

		WebElement Password_Ipt = createWebElementBy(ipt_Password);
		Password_Ipt.clear();
		Password_Ipt.sendKeys(DecryptPassword);

		WebElement Login_Btn = createWebElementBy(btn_Login);
		Login_Btn.click();
		waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "FlexDeploy - Home", "FlexDeploy Home page is not displayed");

		Screen s = new Screen();
		Pattern Pipelines = new Pattern(path + "FD_Pipelines.PNG");
		try {
			s.click(Pipelines);
			wait(30);

			takeScreenshotAtEndOfTest();
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		
		waitForPageLoaded();
		
		WebElement PipelineName_ipt = createWebElementBy(ipt_PipelineName);
		String PLN = PipelineName_ipt.getText();
		Assert.assertEquals(PLN,"Pipeline Name", "Started is not displayed");
		WebElement Link_Pipeline = createWebElementBy(lnk_Pipeline);
		Link_Pipeline.click();
		waitForPageLoaded();
		WebElement PLName_ipt = createWebElementBy(ipt_PLName);
		String PL = PLName_ipt.getText();
		Assert.assertEquals(PL,"Name", "Pipeline Name is not displayed");
		takeScreenshotAtEndOfTest();

	}
	
}




