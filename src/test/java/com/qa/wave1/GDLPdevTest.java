package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;
import com.qa.demo.util.TestUtil;

import org.testng.annotations.BeforeTest;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class GDLPdevTest extends CommonMethods {
	
	
	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://gdlp-dev.gilead.com";
	final String username = "NA\\graj";
	final String pass = "";
	
	/************Fields for which inputs are required to run Test case 2************/
	String name = "VMS Test policy"; //give new name every time for creating a new policy
	String ruleName = "VMS rule";
	String descriptionText = "Testing for creating new policy";
	String policyGroup = "VMS Testing Group";
	/*-----------------------------------------------------------------------------*/
	
	/*************Fields for which inputs are required to run Test case 3***********/
	String editRuleName = "VMS rule1";  //use the value of ruleName and suffix it with any integer
	int rule = 2; // Use Rule 1 or 2 
	String text_Area = "Testing";
	/*-----------------------------------------------------------------------------*/
	
	/*************Fields for which inputs are required to run Test case 4***********/
	String targetName = "VMS Target"; //Set target name
	String pathFile = "P:\\\\DLPTest\\\\Confidential\\\\Confidential_High_Test2.txt"; // Update the file path accordingly
	/*-----------------------------------------------------------------------------*/
	
	/***************************** Test Cases *******************/
	/*
	 * Test case ‘Test Name’ naming convention: <AppName><TCNumber>_<TestCategory>_<Title>
	Definitions of terms:     
•	AppName: short name of Application [String 5 -10 chars] i.e., TstMyApp, 
•	TCNumber: Test case number [Numeric 2-3 digits] i.e, 01, 02,..
•	TestCategory: Test case category [Predefined as per prior analysis] i.e, [Web, WinSrve, LnxSrve, DB …]
•	Title: short title of test case based on context of test case  ie., ValidateCredntails
  	Test Name Example: Filkart_05_Web_ValidateCredntails.

	 * Test method name must be same as test case appended with TM example: 
	 */

	@BeforeTest
	  	public void beforeMethod() {
		launchBrowser(Browser, Url);
	  }	
	
	
	@Test(priority=0, enabled=false)
	public void GDLP_TC01_Web_login_verifyserver() {
		TM_GDLP_TC01_Web_login_verifyserver();
	}

	@Test(priority=1, enabled=true)
	public void GDLP_TC02_Web_create_policy() {
		TM_GDLP_TC02_Web_create_policy();
	}
	
	@Test(priority=2, enabled=true)
	public void GDLP_TC03_Web_edit_rule() {
		TM_GDLP_TC03_Web_edit_rule();
	}
	
	@Test(priority=3, enabled=true)
	public void GDLP_TC04_Web_create_target() {
		TM_GDLP_TC04_Web_create_target();
	}
	
	@AfterTest
		public void afterMethod() {
  }
	
	/***************************** Locators *******************/
	// Example syntax:Css Selector: tagname[attribute1:'value1'][attribute2:'value2']
	/*
	 * ipt_: input fields
	 * btn_: Buttons
	 * lnk_: Links
	 * rdo_: Radio buttons
	 * chk_: Check boxes
	 * tbl_: Tables
	 * msg_: Messages
	 */
	
	By btn_system        =     By.cssSelector("#system");
	By btn_overndsvrs    =     By.cssSelector("#report_group_servers");
	By btn_overview      =     By.cssSelector("#system_overview");
	By btn_manage        =     By.cssSelector("#manage");
	By btn_policies      =     By.cssSelector("#report_group_manage_policies");
	By btn_policyList    =     By.cssSelector("#policies");
	By btn_dicoveryScan  =     By.cssSelector("#report_group_storage_scanning");
	By btn_distarget     =     By.cssSelector("#scanConfiguration");
	By btn_incidents	 = 	   By.cssSelector("#incidents");
	By btn_allReports    =     By.cssSelector("#report_group_my_report_list");
	By tbl_servers       =     By.xpath("//*[@id=\"table-content\"]/div/div[1]/table/tbody/tr");
	By btn_new           =     By.cssSelector("#new-policy-button");
	By rdo_selectPolicy  =     By.xpath("//*[@id=\"template\" and @value=\"506\"]");
	By ipt_policyName    =     By.xpath("//*[@id=\"policyNameInput\"]");
	By itp_description   =     By.xpath("//*[@id=\"table-content\"]/div/table/tbody/tr[3]/td[2]/input");
	By itp_policyGroup   =     By.xpath("//*[@id=\"policyLabel\"]");
	By drp_policyGroup   =     By.cssSelector("#policyGroup");
	By btn_save          =     By.cssSelector("#btn_save");
	By btn_addRule       =     By.cssSelector("#btn_add_rule");
	By rdo_selectRule1   =     By.xpath("//*/table/tbody/tr[4]/td[1]/input");
	By rdo_selectRule2   =     By.xpath("//*/table/tbody/tr[5]/td[1]/input");
	By ipt_textArea      =     By.cssSelector("#keyword");
	By ipt_ruleName      =     By.xpath("//input[@name='value(name)']");
	By drp_selectSeverity =    By.xpath("//select[@name='value(defaultSeverity)']");
	By lnk_selectAll     =     By.cssSelector("tbody:nth-child(1) tr:nth-child(13) td.value div:nth-child(1) > a:nth-child(1)");
	By btn_ok            =     By.cssSelector("#btn_ok");
	By btn_next          =     By.cssSelector("#btn_next");
	By rdo_ruleTitle     =     By.xpath("//span[@class='ruleTitle']");
	By btn_newTarget     =     By.xpath("//span[@class='menubar-text']");
	By btn_fileSys       =     By.xpath("//li[@id='create-filesystem-target-menu-item']//span[contains(@class,'menu-text')][contains(text(),'File System')]");
	By ipt_targetName    =     By.xpath("//input[@id='scanAssignmentName']");
	By rdo_policyCDP     =     By.cssSelector("#policyGroupSelection_0");
	By rdo_policyDPG     =     By.cssSelector("#policyGroupSelection_1");
	By btn_targetTab     =     By.cssSelector("#ui-id-2");
	By rdo_serverTarget  =     By.xpath("//*[@id=\"monitorSelection_0\"]");
	By btn_scannedConTab =     By.cssSelector("#ui-id-3");
	By rdo_fromFile      =     By.cssSelector("#fromFile");
	By btn_uploadFile    =     By.xpath("//span[contains(text(),'Upload File')]");
	By btn_upload        =     By.xpath("//span[@class='ui-button-text'][contains(text(),'Upload File')]");
	By btn_chooseFile    =     By.xpath("//input[@id='file']");
	By rdo_manualUser    =     By.xpath("//input[@id='defaultCredentialTypeManual']");
	By ipt_userName      =     By.cssSelector("#defaultUsername");
	By ipt_password      =     By.cssSelector("#defaultPassword");
	By ipt_cnfpassword   =     By.cssSelector("#passwordAgain");
	By rdo_contentSelect =     By.xpath("//input[@name='value(courseFileName)']");
	By btn_startScan     =     By.cssSelector("#action-start-scan");
	By tbl_policyTable   =     By.xpath("//*[@id=\"policy-table-table\"]/tbody/tr");
	By tbl_disTable      =     By.xpath("//*[@id=\"discoverTargetListTable\"]/tbody/tr");
	By btn_allIncidents  =	   By.xpath("//table[4]/tbody[1]/tr[4]/td[1]/span[1]");

	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn
	
	
	public void TM_GDLP_TC01_Web_login_verifyserver() {
		
		WebElement System_btn = createWebElementBy(btn_system);
		mouseHover(System_btn);
		
		WebElement OverViewAndServers_btn = createWebElementBy(btn_overndsvrs);
		mouseHover(OverViewAndServers_btn);
		
		WebElement Overview_btn = createWebElementBy(btn_overview);
		mouseHover(Overview_btn);
		Overview_btn.click();
		
		waitForPageLoaded();
		
		List<String> expectedresult = new ArrayList<String>();
		List<String> allservers = new ArrayList<String>();
		List<String> servers = new ArrayList<String>();
		
		//To get the Number of Rows in the serverList displayed on screen
		List<WebElement> allRows = createWebElementsBy(tbl_servers);
		int numberOfRows = allRows.size();
		System.out.println("The Number of rows are:: "+numberOfRows);

		//creating string "Running" for all the number rows
		for(int i = 1;i<numberOfRows;i++) {
			String result = "Running";
			expectedresult.add(result);
		}

		//Getting actual values of server status from the rows
		for(int i=2;i<=numberOfRows;i++) {
			String serverstatus = driver.findElement(By.xpath("//*[@id=\"table-content\"]/div/div[1]/table/tbody/tr["+i+"]/td[1]")).getText(); // need to update
			allservers.add(serverstatus);
			String serverName = driver.findElement(By.xpath("//table[1]/tbody[1]/tr["+i+"]/td[2]/div[1]/a[1]")).getText();
			servers.add(serverName);
			System.out.println(serverstatus +"   "+ serverName);
		}
		
		//validating 
		Assert.assertEquals(allservers, expectedresult); 
		
	}
	
public void TM_GDLP_TC02_Web_create_policy() {
		
		
		WebElement managebtn = createWebElementBy(btn_manage);
		mouseHover(managebtn);
		WebElement policiesbtn = createWebElementBy(btn_policies);
		mouseHover(policiesbtn);
		WebElement policyListbtn = createWebElementBy(btn_policyList);
		mouseHover(policyListbtn);
		policyListbtn.click();
		
		WebElement newbtn = createWebElementBy(btn_new);
		newbtn.click();
		WebElement nextbtn = createWebElementBy(btn_next);
		nextbtn.click();
		WebElement policyNameipt = createWebElementBy(ipt_policyName);
		policyNameipt.clear();
		policyNameipt.sendKeys(name);
		WebElement descriptionipt = createWebElementBy(itp_description);
		descriptionipt.clear();
		descriptionipt.sendKeys(descriptionText);
		WebElement policyGroupipt = createWebElementBy(itp_policyGroup);		
		policyGroupipt.clear();
		policyGroupipt.sendKeys(policyGroup);

		WebElement policydropdown = createWebElementBy(drp_policyGroup);
		selectDropdownByText(policydropdown, "Default Policy Group" );
		
		WebElement addRulebtn = createWebElementBy(btn_addRule);
		addRulebtn.click();
		
		
		
		if (rule == 1) {
			WebElement selectRule1rdo = createWebElementBy(rdo_selectRule1);
			selectRule1rdo.click();
			WebElement nextbtn1 = createWebElementBy(btn_next);
			nextbtn1.click();
			WebElement ruleNameipt = createWebElementBy(ipt_ruleName);
			ruleNameipt.sendKeys(ruleName);

			WebElement severitydrp = createWebElementBy(drp_selectSeverity);
			selectDropdownByValue(severitydrp, "3");
			WebElement selectAlllnk = createWebElementBy(lnk_selectAll);
			selectAlllnk.click();
			WebElement okbtn = createWebElementBy(btn_ok);
			okbtn.click();
		}else if(rule == 2) {
			WebElement selectRule1rdo = createWebElementBy(rdo_selectRule2);
			selectRule1rdo.click();
			WebElement nextbtn1 = createWebElementBy(btn_next);
			nextbtn1.click();
			WebElement ruleNameipt = createWebElementBy(ipt_ruleName);
			ruleNameipt.sendKeys(ruleName);

			WebElement severitydrp = createWebElementBy(drp_selectSeverity);
			selectDropdownByValue(severitydrp, "3");
			WebElement textAreaipt = createWebElementBy(ipt_textArea);
			textAreaipt.sendKeys(text_Area);
			WebElement okbtn = createWebElementBy(btn_ok);
			okbtn.click();
		}
		
		WebElement savebtn = createWebElementBy(btn_save);
		savebtn.click();
		
		//Get the number of rows of policy list		
		List<WebElement> allRows = createWebElementsBy(tbl_policyTable);
		int numberOfRows = allRows.size(); 
		System.out.println("The Number of rows are:: "+numberOfRows);

		List<String> allPolicyNames = new ArrayList<String>();	
		
		// Obtain all the Policy List name and add it to the allPolicyNames
		for(int i=1;i<=numberOfRows;i++) {
			String policyNames = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/a")).getText(); // need to update
			allPolicyNames.add(policyNames);
		}

		Boolean result = allPolicyNames.contains(name);
		if (result) 
			System.out.println("The new policy is created and policy name is: "+name);
		else
			System.out.println("The new policy name was not found");

		
	}

	public void TM_GDLP_TC03_Web_edit_rule() {
		
		WebElement managebtn = createWebElementBy(btn_manage);
		mouseHover(managebtn);
		WebElement policiesbtn = createWebElementBy(btn_policies);
		mouseHover(policiesbtn);
		WebElement policyListbtn = createWebElementBy(btn_policyList);
		mouseHover(policyListbtn);
		policyListbtn.click();
		waitForPageLoaded();
		
		List<WebElement> allRows = createWebElementsBy(tbl_policyTable);
		int numberOfRows = allRows.size();

		List<WebElement> policyNames = new ArrayList<WebElement>();
		
		// Obtain all the policy names
		for(int i=1;i<=numberOfRows;i++) {
			WebElement names = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/a")); // Xpath of the policy names
			policyNames.add(names);
		}
		
		//Select the policy list based on the String in name field, so that no other policies are edited
		for(int j=0;j<policyNames.size();j++) {
			String verify = policyNames.get(j).getText();
			if(verify.equals(name)) {
				System.out.println(verify);
				policyNames.get(j).click();
				break;
			}
		}
		
		WebElement ruleNamerdo = createWebElementBy(rdo_ruleTitle);
		ruleNamerdo.click();
		WebElement ruleNameipt = createWebElementBy(ipt_ruleName);
		ruleNameipt.sendKeys(editRuleName);

		WebElement severitydrp = createWebElementBy(drp_selectSeverity);
		selectDropdownByValue(severitydrp, "2");
		WebElement okbtn = createWebElementBy(btn_ok);
		okbtn.click();
		System.out.println(ruleNamerdo.getText());
		WebElement savebtn = createWebElementBy(btn_save);
		savebtn.click();
		
	}
	
	public void TM_GDLP_TC04_Web_create_target() {
		
		WebElement managebtn = createWebElementBy(btn_manage);
		mouseHover(managebtn);
		WebElement discoverScanbtn = createWebElementBy(btn_dicoveryScan);
		mouseHover(discoverScanbtn);
		WebElement disTargetbtn = createWebElementBy(btn_distarget);
		mouseHover(disTargetbtn);
		disTargetbtn.click();
		
		waitForPageLoaded();
		
		WebElement newTargetbtn = createWebElementBy(btn_newTarget);
		mouseHover(newTargetbtn);
		WebElement fileSystembtn = createWebElementBy(btn_fileSys);
		mouseHover(fileSystembtn);
		fileSystembtn.click();
		
		waitForPageLoaded();
		WebElement targetNameipt = createWebElementBy(ipt_targetName);
		targetNameipt.sendKeys(targetName);
		WebElement policyCDPrdo = createWebElementBy(rdo_policyCDP);
		policyCDPrdo.click();
		WebElement policyDPGrdo = createWebElementBy(rdo_policyDPG);
		policyDPGrdo.click();
		WebElement svrTargetrdo = createWebElementBy(rdo_serverTarget);
		svrTargetrdo.click();
		WebElement scannedContentbtn = createWebElementBy(btn_scannedConTab);
		scannedContentbtn.click();
		
		WebElement manualUserrdo = createWebElementBy(rdo_manualUser);
		if(manualUserrdo.isSelected()) {
			WebElement userNameipt = createWebElementBy(ipt_userName);
			userNameipt.sendKeys(username);
			WebElement passwordipt = createWebElementBy(ipt_password);
			passwordipt.sendKeys(pass);
			WebElement cnfpasswordipt = createWebElementBy(ipt_cnfpassword);
			cnfpasswordipt.sendKeys(pass);
		}else {
			WebElement userNameipt = createWebElementBy(ipt_userName);
			userNameipt.sendKeys(username);
			WebElement passwordipt = createWebElementBy(ipt_password);
			passwordipt.sendKeys(pass);
			WebElement cnfpasswordipt = createWebElementBy(ipt_cnfpassword);
			cnfpasswordipt.sendKeys(pass);
		}
		
		WebElement filePathrdo = createWebElementBy(rdo_fromFile);
		filePathrdo.click();
		wait(2);
		WebElement uploadFilebtn = createWebElementBy(btn_uploadFile);
		uploadFilebtn.click();
		WebElement chooseFilebtn = createWebElementBy(btn_chooseFile);
		chooseFilebtn.sendKeys(pathFile);
		WebElement uploadbtn = createWebElementBy(btn_upload);
		uploadbtn.click();
		wait(1);
		scannedContentbtn.click();
		WebElement savebtn = createWebElementBy(btn_save);
		savebtn.click();
	}
	
	public void TM_GDLP_TC05_Web_scan_target() {
		
		WebElement managebtn = createWebElementBy(btn_manage);
		mouseHover(managebtn);
		WebElement discoverScanbtn = createWebElementBy(btn_dicoveryScan);
		mouseHover(discoverScanbtn);
		WebElement disTargetbtn = createWebElementBy(btn_distarget);
		mouseHover(disTargetbtn);
		disTargetbtn.click();
		waitForPageLoaded();
		
		WebElement selectNumberOfEntries = driver.findElement(By.xpath("//form[1]/div[2]/div[1]/div[4]/label[1]/select"));
		selectDropdownByValue(selectNumberOfEntries, "50" );		

		List<WebElement> allRows = createWebElementsBy(tbl_disTable);
		int numberOfRows = allRows.size();
		System.out.println(numberOfRows);

		List<WebElement> targetNames = new ArrayList<WebElement>();
		
		//Get the number of rows from the table 
		for(int i=1;i<=numberOfRows;i++) {
			WebElement names = driver.findElement(By.xpath("//tbody[1]/tr["+i+"]/td[2]/a[1]/span[1]")); // need to update
			targetNames.add(names);
		}

		
		//Created a loop so that the Target created by the VMS is the only element selected and not any other target
		//the targetName field is the input for the validation 
		for(int j=0;j<targetNames.size();) {
			String verify = targetNames.get(j).getText();
			if(verify.equals(targetName)) {
				System.out.println(verify);
				j++;
				System.out.println(j);
				driver.findElement(By.xpath("//table[1]/tbody[1]/tr["+j+"]/td[1]/input[1]")).click();  
				break; 
			}
			j++;
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;            
		js.executeScript("window.scrollBy(0,-500)", "");

		driver.findElement(By.xpath("//*[@id=\"discover_targets.learn_more.message\"]")).click();
		WebElement startScanbtn = createWebElementBy(btn_startScan);
		Assert.assertTrue(startScanbtn.isEnabled());
		startScanbtn.click();
		wait(2);
		
		//After the scan is started the elements are changed therefore created a loop to update and use for validating the status of scan
		List<WebElement> targetNames1 = new ArrayList<WebElement>();
		for(int i=1;i<=numberOfRows;i++) {
			WebElement names = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]/a/span")); // need to update
			targetNames1.add(names);
		}

		//Validating the scan status of the target, here input is targetName to validate
		for(int j=0;j<targetNames1.size();) { 
			String verify = targetNames1.get(j).getText(); 
			if(verify.equalsIgnoreCase(targetName)) {
				System.out.println(verify);
				System.out.println(targetNames1.get(j).getText());
				j++;
				String status = driver.findElement(By.xpath("//table[1]/tbody[1]/tr["+j+"]/td[7]/span[1]/a[1]")).getText();
				System.out.println(status);
				if(!(status.equalsIgnoreCase("Ready"))) {
					System.out.println(status);
					break;
				}else {
					System.out.println("The status is not changed or the start scan is not successfully executed");
					throw new AssertionError();
				}
			}
			j++;
		}
	}
	
	public void TM_GDLP_TC06_Web_view_incidents() {
		
		WebElement incidentsbtn = createWebElementBy(btn_incidents);
		mouseHover(incidentsbtn);
		WebElement allReportsbtn = createWebElementBy(btn_allReports);
		mouseHover(allReportsbtn);
		allReportsbtn.click();
		waitForPageLoaded();
		WebElement allIncidentsbtn = createWebElementBy(btn_allIncidents);
		allIncidentsbtn.click();
		String verify = driver.findElement(By.partialLinkText("Incidents - All")).getText();
		Assert.assertEquals(verify, "Incidents - All");
	}
	
	
	/*************************************************Methods*****************************************************************/
	public void selectDropdownByText(WebElement locator, String value) {
		Select select = new Select(locator);
		select.selectByVisibleText(value);
	}
	
	public static void selectDropdownByValue(WebElement locator, String value) {
		Select select = new Select(locator);
		select.selectByValue(value);
	}

}
