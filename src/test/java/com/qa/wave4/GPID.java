package com.qa.wave4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import junit.framework.Assert;

public class GPID extends CommonMethods {
	/***************************** Test Data *******************/
	final String Browser = "Chrome";
	final String DevURL = "https://dev.gpid.gilead.com/insight/web/login.do";
	final String ProdURL = "https://gpid.na.gilead.com/insight/web/login.do";
	final String TstURL = "https://tst.gpid.gilead.com/insight/web/login.do";
	String usrnme = "graj";
	private String DecrptPassword;

	/***************************** Test Cases *******************/
	/*
	 * Test case ‘Test Name’ naming convention:
	 * <AppName><TCNumber>_<TestCategory>_<Title> Definitions of terms: • AppName:
	 * short name of Application [String 5 -10 chars] i.e., TstMyApp, • TCNumber:
	 * Test case number [Numeric 2-3 digits] i.e, 01, 02,.. • TestCategory: Test
	 * case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve,
	 * DB …] • Title: short title of test case based on context of test case ie.,
	 * ValidateCredntails Test Name Example: Filkart_05_Web_ValidateCredntails.
	 * 
	 * Test method name must be same as test case appended with TM example:
	 */

	String URL = TstURL;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
		login();
	}

	@Test(priority=1, enabled=true)
	public void CR_S01_Web_Verify_Reports() throws InterruptedException {
		TM_S01_Web_Verify_Reports();
	}
	
	@Test(priority=2, enabled=true)
	public void CR_S02_Web_Verify_PDSStructure() throws InterruptedException {
		TM_S02_Web_Verify_PDSStructure();
	}


	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	/***************************** Locators *******************/
	// Example syntax:Css Selector:
	// tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 * txt_: Text
	 * crd_: Card
	 */

	By ipt_username		=	By.cssSelector("#username");
	By ipt_password		=	By.cssSelector("#password");
	By drp_domain		=	By.xpath("//select[@name='domain']");
	By btn_login		=	By.cssSelector("#btnLogin");
	By btn_reports		=	By.cssSelector("#ext-gen110");
	By btn_crystalrep	=	By.cssSelector("a[id*='gen'][class*='x-menu'] img");
	By btn_documents	=	By.xpath("//div/a[contains(text(),'Documents')]");
	By btn_folders		=	By.cssSelector("a[id^='yui'][title='Expand Folders']");
	By btn_expand		=	By.xpath("//li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]");
	By btn_gxprep		=	By.cssSelector("#accordionNavigationView_drawer1_treeView_treeNodeIcon_8");
	By txt_productdist	=	By.cssSelector("#ListingURE_detailView_listColumn_24_0_1");
	By txt_prdname		=	By.xpath("//option[contains(text(),' Capsule, hard')]");
	By btn_rgtarrow		=	By.xpath("//table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]/img[1]");
	By txt_country		=	By.xpath("//option[contains(text(),'United States')]");
	By btn_rgtarrow2	=	By.xpath("//table[2]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]/img[1]");
	By drp_select 		=	By.cssSelector("select[id*='p2SelectValue']");
	By btn_ok			=	By.cssSelector("div[class='pePromptButton'] a[title='OK']");
	By btn_logoff		=	By.xpath("//*[@id=\"logoffLink-button\"]");
	
	By btn_prdfamilies	=	By.xpath("//a[contains(text(),'Product Families')]");
	By lnk_Ambrisentan	=	By.xpath("//a[contains(text(),'Ambrisentan')]");
	By lnk_appnaH		=	By.xpath("//a[contains(text(),'nda022081-PAH')]");
	By btn_prdsetdetail =	By.xpath("//span[contains(text(),'Product Detail Sets')]");
	By lnk_prd10mg		=	By.xpath("//a[contains(text(),'ABS, 10 mg, Tablets, Bottles and Blisters')]");
	By lnk_drugsubs		=	By.xpath("//span[contains(text(),'Drug Substance')]");
	//By lnk_expandtree	=	By.cssSelector("div.x-layer.x-menu:nth-child(12) ul.x-menu-list li.x-menu-list-item:nth-child(2) a.x-menu-item > img.x-menu-item-icon.expandAll");
	By txt_validate		=	By.xpath("//span[contains(text(),'Methanol, 99% (Approved)')]");
	


	/***************************** Test Case Methods 
	 * @throws InterruptedException *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_S01_Web_Verify_Reports() throws InterruptedException {
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		takeScreenshotAtEndOfTest();
		// Perform the click operation that opens new window
		WebElement Reports_Btn = createWebElementBy(btn_reports);
		Reports_Btn.click();

		WebElement CrystalReports_Btn = createWebElementBy(btn_crystalrep);
		CrystalReports_Btn.click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		waitForPageLoaded();
		Assert.assertEquals("BI launch pad", driver.getTitle());
		takeScreenshotAtEndOfTest();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@name='servletBridgeIframe']"));
		driver.switchTo().frame(frame1);

		WebElement ok_btn = driver.findElement(By.cssSelector("#yui-gen1-button"));
		ok_btn.click();

		WebElement Documents_Btn = createWebElementBy(btn_documents);
		Documents_Btn.click();

		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='iframe4431-1200149']"));
		driver.switchTo().frame(frame2);
		WebElement Folders_Btn = createWebElementBy(btn_folders);
		Folders_Btn.click();

		WebElement Expand_Btn = createWebElementBy(btn_expand); 
		Expand_Btn.click();

		WebElement GxpReport_Btn = createWebElementBy(btn_gxprep);
		GxpReport_Btn.click();

		WebElement ProductDistrubution_Txt = createWebElementBy(txt_productdist);
		scrollToWebElement(ProductDistrubution_Txt);
		takeScreenshotAtEndOfTest();
		Actions actions = new Actions(driver);
		actions.doubleClick(ProductDistrubution_Txt).perform();
		
		wait(6);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame1); 
		WebElement frame3 =driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/iframe[1]"));
		driver.switchTo().frame(frame3); 
		wait(2);
		
		WebElement ProductName_Txt = createWebElementBy(txt_prdname);
		ProductName_Txt.click();
		waitForPageLoaded();
		WebElement RightArrow = createWebElementBy(btn_rgtarrow);
		RightArrow.click();
		waitForPageLoaded();
		WebElement Country_Txt = createWebElementBy(txt_country);
		Country_Txt.click();
		waitForPageLoaded();
		WebElement RightArrow2 = createWebElementBy(btn_rgtarrow2);
		RightArrow2.click();
		waitForPageLoaded();
		wait(5);
		takeScreenshotAtEndOfTest();
		WebElement select = createWebElementBy(drp_select);
		selectDropdownValue(select, "20322 App1");
		waitForPageLoaded();
		WebElement OK_Btn = createWebElementBy(btn_ok);
		OK_Btn.click();
		waitForPageLoaded();
		Thread.sleep(2*60000);
		
		WebElement frame4 = driver.findElement(By.xpath("//tbody[1]/tr[4]/td[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/iframe[1]"));
		driver.switchTo().frame(frame4);
		takeScreenshotAtEndOfTest();
		WebElement txt = driver.findElement(By.xpath("//*[@id=\"Text5\"]/p/span/span"));
		Assert.assertEquals("Product Distribution by Country Report", txt.getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame1);
		WebElement LogOff_Btn = createWebElementBy(btn_logoff);
		LogOff_Btn.click();

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

	}

	public void TM_S02_Web_Verify_PDSStructure() {
			
		
		WebElement ProductFamilies_Btn = createWebElementBy(btn_prdfamilies);
		ProductFamilies_Btn.click();
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='homePageLayout_center_mainContent_el']"));
		driver.switchTo().frame(frame1);
		
		waitForPageLoaded();
		WebElement Ambrisentan_Lnk = createWebElementBy(lnk_Ambrisentan);
		Ambrisentan_Lnk.click();
		
		waitForPageLoaded();
		WebElement AppnaH_Lnk = createWebElementBy(lnk_appnaH);
		scrollToWebElement(AppnaH_Lnk);
		AppnaH_Lnk.click();
		
		waitForPageLoaded();
		WebElement ProdSetDetails_Btn = createWebElementBy(btn_prdsetdetail);
		ProdSetDetails_Btn.click();
		
		waitForPageLoaded();
		WebElement Prd10mg_Lnk	=	createWebElementBy(lnk_prd10mg);
		Prd10mg_Lnk.click();
		
		waitForPageLoaded();
		//WebElement DrugSubs_Lnk = createWebElementBy(lnk_drugsubs);
		//IsDisplayed_IsEnabled(DrugSubs_Lnk);
		//Actions actions = new Actions(driver);
		//actions.contextClick(DrugSubs_Lnk).perform();
		
		
		//WebElement ExpandTree_Lnk = createWebElementBy(lnk_expandtree);
		//ExpandTree_Lnk.click();
		
		driver.findElement(By.xpath("//div[1]/ul[1]/div[1]/li[1]/ul[1]/li[1]/div[1]/img[1]")).click();
		waitForPageLoaded();
		driver.findElement(By.xpath("//div[1]/ul[1]/div[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/div[1]/img[1]")).click();
		waitForPageLoaded();
		driver.findElement(By.xpath("//div[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/div[1]/img[1]")).click();
		waitForPageLoaded();
		driver.findElement(By.xpath("//div[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/div[1]/img[1]")).click();
		waitForPageLoaded();
		driver.findElement(By.xpath("//div[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/div[1]/img[1]")).click();
		waitForPageLoaded();
		
		driver.findElement(By.xpath("//li[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/div[1]/img[1]")).click();
			
		waitForPageLoaded();
		WebElement Validate_Txt = createWebElementBy(txt_validate);
		Assert.assertEquals("Methanol, 99% (Approved)", Validate_Txt.getText());	
		
	}



	/******************************************* Generic Methods **********************************/

	public void login() {
		WebElement UserName_Ipt = createWebElementBy(ipt_username);
		UserName_Ipt.clear();
		UserName_Ipt.sendKeys(usrnme);

		try {
			DecrptPassword = decrypt("uyK8jwlrhC6ELFzIelj5Bw==");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement Password_Ipt = createWebElementBy(ipt_password);
		Password_Ipt.sendKeys(DecrptPassword);

		WebElement Domain_Drp = createWebElementBy(drp_domain);
		selectDropdownValue(Domain_Drp, "NA");

		WebElement Login_Btn = createWebElementBy(btn_login);
		Login_Btn.click();

		Assert.assertEquals("LIQUENT InSight", driver.getTitle());
	}

}
