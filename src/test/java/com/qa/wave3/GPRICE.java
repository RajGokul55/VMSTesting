package com.qa.wave3;
import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GPRICE extends CommonMethods {

	/***************************** Test Cases *******************/

	@BeforeMethod(enabled = false)
	public void BeforeMethod() throws IOException {

	}

	@Test(priority = 0, enabled = true)
	public void GPRICE_S01_Web_Devurl_UserLogin_dasboard() throws IOException {
		TM_GPRICE_S01_Web_Devurl_UserLogin_dasboard();
	}

	@Test(priority = 1, enabled = true)
	public void GPRICE_S02_Web_Devurl_Simulation_Report() throws IOException {
		TM_GPRICE_S02_Web_Devurl_Simulation_Report();
	}

	@Test(priority = 2, enabled = true)
	public void GPRICE_S03_Web_Produrl_UserLogin_dashboard() throws IOException {
		TM_GPRICE_S03_Web_Produrl_UserLogin_dasboard();
	}
	
	@Test(priority = 1, enabled = true)
	public void GPRICE_S04_Web_Produrl_Simulation_Report() throws IOException {
		TM_GPRICE_S04_Web_Produrl_Simulation_Report();
	}

	
	@AfterMethod
	public void afterEveryTest() {
		driver.quit();
	}

	/***************************** Locators *******************/

	By ipt_Username = By.xpath("//input[@id='MainContent_txtEmail']");
	By ipt_Password = By.xpath("//input[@id='MainContent_txtPassword']");
	By btn_Login = By.xpath("//input[@id='MainContent_btnLogin']");
	By btn_Simulation = By.xpath("//span[contains(text(),'Simulation')]");
	By ipt_SimulationOverview = By.xpath("//h3[@class='main_hd']");
	By btn_Report = By.xpath("//span[contains(text(),'Report')]");
	By lnk_CountryMatrix = By.xpath("//a[contains(text(),'Country Matrix')]");
	By ipt_CountryMatrixHeader = By.xpath("//h3[@class='main_hd']");

	/***************************** Test Case Methods *******************/
	
	public void TM_GPRICE_S01_Web_Devurl_UserLogin_dasboard() throws IOException {
		GM_GPRICE_Web_DevURLLogin();
		waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "Pricing 360-IRP","Pricing 360-IRP is not displayed");
	    takeScreenshotAtEndOfTest();
	}
		
	public void TM_GPRICE_S02_Web_Devurl_Simulation_Report() throws IOException {
		GM_GPRICE_Web_DevURLLogin();
		WebElement Simulation_btn = createWebElementBy(btn_Simulation);
		Simulation_btn.click();
		WebElement SimulationOverview_ipt = createWebElementBy(ipt_SimulationOverview);
		String SO = SimulationOverview_ipt.getText();
		Assert.assertEquals(SO, "SIMULATION - OVERVIEW","SIMULATION - OVERVIEW is not displayed");
		takeScreenshotAtEndOfTest();
		WebElement Report_btn = createWebElementBy(btn_Report);
		Report_btn.click();
		WebElement CountryMatrix_lnk = createWebElementBy(lnk_CountryMatrix);
		CountryMatrix_lnk.click();
		WebElement CountryMatrixHeader_ipt = createWebElementBy(ipt_CountryMatrixHeader);
		String CMH = CountryMatrixHeader_ipt.getText();
		Assert.assertEquals(CMH, "COUNTRY MATRIX","COUNTRY MATRIX is not displayed");
	    takeScreenshotAtEndOfTest();
	}
	
	public void TM_GPRICE_S03_Web_Produrl_UserLogin_dasboard() throws IOException {
		GM_GPRICE_Web_ProdURLLogin();
		waitForPageLoaded();
		Assert.assertEquals(driver.getTitle(), "Pricing 360-IRP","Pricing 360-IRP is not displayed");
	    takeScreenshotAtEndOfTest();
		 
	}

	public void TM_GPRICE_S04_Web_Produrl_Simulation_Report() throws IOException {
        GM_GPRICE_Web_ProdURLLogin();
        WebElement Simulation_btn = createWebElementBy(btn_Simulation);
		Simulation_btn.click();
		WebElement SimulationOverview_ipt = createWebElementBy(ipt_SimulationOverview);
		String SO = SimulationOverview_ipt.getText();
		Assert.assertEquals(SO, "SIMULATION - OVERVIEW","SIMULATION - OVERVIEW is not displayed");
		takeScreenshotAtEndOfTest();
		WebElement Report_btn = createWebElementBy(btn_Report);
		Report_btn.click();
		WebElement CountryMatrix_lnk = createWebElementBy(lnk_CountryMatrix);
		CountryMatrix_lnk.click();
		WebElement CountryMatrixHeader_ipt = createWebElementBy(ipt_CountryMatrixHeader);
		String CMH = CountryMatrixHeader_ipt.getText();
		Assert.assertEquals(CMH, "COUNTRY MATRIX","COUNTRY MATRIX is not displayed");
	    takeScreenshotAtEndOfTest();

	}

	/***************************** Generic Methods *******************/

	public void GM_GPRICE_Web_DevURLLogin() throws IOException {

		final String Browser = "Chrome";
		final String DevURL = "https://dev.gprice.gilead.com/";
		final String Username = "testdev@gilead.com";
		String DecryptPassword = null;
		final String EncryptPassword = "gy8t1sFmjkMhJOnuYOL++w==";
		final String URL = DevURL; 
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

		waitForPageLoaded();
	
	}

	public void GM_GPRICE_Web_ProdURLLogin() throws IOException {

		final String Browser = "Chrome";
		final String ProdURL = "https://gprice.gilead.com/";
		final String Username = "test@gilead.com";
		String DecryptPassword = null;
		final String EncryptPassword = "CStC2XW5/JYOmPh4R/cPrg==";
		final String URL = ProdURL;
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

		waitForPageLoaded();
		

	}
}

