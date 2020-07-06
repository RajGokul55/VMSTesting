package com.qa.wave4;

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

public class Fusion extends CommonMethods {

	/***************************** Test Data *******************/

	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\SiKuli\\";
	final String FusionUserID = "VMStest";
	final String FusionPassword = "VMStest1";

	/***************************** Test Cases *******************/

	@BeforeMethod(enabled = true)
	public void BeforeMethod() throws IOException {

	}

	@Test(priority = 0, enabled = true)
	public void FUSION_S01_Web_GADI_UserLogin() throws IOException {
		TM_FUSION_S01_Web_GADI_UserLogin();
	}

	@AfterMethod(enabled = true)
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	By ipt_Username = By.xpath("//input[@id='login']");
	By ipt_Password = By.xpath("//input[@id='passwd']");
	By btn_Login = By.xpath("//a[@id='nsg-x1-logon-button']");
	By lnk_AllApps = By.xpath("//a[@id='allAppsBtn']//div[@class='view-sprite']");
	By lnk_Fusion = By.xpath("//li[@class='storeapp available']//img[contains(@class,'storeapp-icon')]");
	By lnk_dropdownicon = By.xpath("//div[@class='settings-button-arrow view-sprite']");
	By lnk_Logout = By.xpath("//a[@id='menuLogOffBtn']");

	/***************************** Test Case Methods *******************/

	public void TM_FUSION_S01_Web_GADI_UserLogin() throws IOException {
		final String Browser = "Chrome";
		final String GADIURL = "https://gadi2.gilead.com/";
		final String Username = "dmarkanti";
		String DecryptPassword = null;
		final String EncryptPassword = "gauEQnlth0rzudo2rv35/A==";
		final String URL = GADIURL;
		launchBrowser(Browser, URL);
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
		wait(10);
		Screen s = new Screen();
		Pattern GADILV = new Pattern(path + "FU_GADILighterVersion.PNG");
		try {
			s.click(GADILV);
			wait(10);

			
		} catch (FindFailed e) {

			e.printStackTrace();
		}

		wait(10);
		WebElement AllApps_lnk = createWebElementBy(lnk_AllApps);
		AllApps_lnk.click();

		WebElement Fusion_lnk = createWebElementBy(lnk_Fusion);
		Fusion_lnk.click();
		waitForPageLoaded();
		Screen S = new Screen();
		Pattern FusionLogin = new Pattern(path + "FU_Username.PNG");
		Pattern FusionPW = new Pattern(path + "FU_Password.PNG");
		Pattern FusionOK = new Pattern(path + "FU_OK.PNG");
		Pattern VMSTesting = new Pattern(path + "FU_1VMSTesting.PNG");
		Pattern DesignReport = new Pattern(path + "FU_DesignReport.PNG");
		Pattern ExistingFile = new Pattern(path + "FU_ExistingFile.PNG");
		Pattern Openbutton = new Pattern(path + "FU_Openbtn.PNG");
		Pattern SelectProject = new Pattern(path + "FU_SelectProject.PNG");
		Pattern zzAdmin = new Pattern(path + "FU_zzAdmin.PNG");
		Pattern TestFile = new Pattern(path + "FU_TestFile.PNG");
		Pattern SMatrix = new Pattern(path + "FU_SMatrix.PNG");
		Pattern Close = new Pattern(path + "FU_Close.PNG");
		Pattern RBNo = new Pattern(path + "FU_RBNo.PNG");
		Pattern License = new Pattern(path + "FU_LicNo.PNG");
		try {
			wait(20);

			S.type(FusionLogin, FusionUserID);
			wait(10);
			S.type(FusionPW, FusionPassword);
			wait(10);
			S.click(FusionOK);
			wait(10);
			S.click(License);
			wait(20);

			S.click(ExistingFile);
			wait(10);
			S.click(SelectProject);
			wait(10);
			S.doubleClick(zzAdmin);
			wait(10);
			S.doubleClick(VMSTesting);
			wait(10);
			S.click(TestFile);
			wait(10);
			S.click(Openbutton);
			wait(10);
			S.click(DesignReport);
			wait(10);
			s.exists(SMatrix);
			Reporter.log("SMatrix is displayed successfully");
			takeScreenshotAtSikuli();
			S.click(Close);
			wait(10);
			S.click(RBNo);
			wait(10);
			WebElement dropdownicon_lnk = createWebElementBy(lnk_dropdownicon);
			dropdownicon_lnk.click();
			WebElement Logout_lnk = createWebElementBy(lnk_Logout);
			Logout_lnk.click();

		} catch (FindFailed e) {
			e.printStackTrace();
		}
		
		

	}

}
