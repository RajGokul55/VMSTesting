package com.qa.demo.applicationTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.agiletestware.bumblebee.annotations.Bumblebee;
import com.qa.demo.base.TestBase;
import com.qa.demo.commonMethods.IDMApp;

public class IDMTest extends TestBase{
	IDMApp idmlogin;
	public static String propertyFile = "IDM";
	String title;
	String url;
	@Bumblebee(testplan = "Subject\\Phase1-Applications", testlab = "Root\\webdriver", testset = "class annotations")
	
	@BeforeMethod
	public void setUp() {
		idmlogin= new IDMApp();
		propertyFileInitialization(propertyFile);
		initilization();
	}
	@Test(priority=-1, enabled=true)
	public void IDM_TC01_Web_AccessRequest_Verification() throws InterruptedException {
		idmlogin.loggingIn(prop.getProperty("Username"), prop.getProperty("Password"));
		title =idmlogin.getTitle();
		Assert.assertEquals(title, "SailPoint IdentityIQ - Dashboard");
		
	}
	
	@Test(priority =0 ,enabled = false)
	public void verifyAccessRequestTab() throws InterruptedException {
		idmlogin.loggingIn(prop.getProperty("Username"), prop.getProperty("Password"));
		
		idmlogin.clickLink(prop.getProperty("ERP"));
		 title =idmlogin.getTitle(); 
		 Assert.assertEquals(title, "Applications");
		  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));;
		
		  idmlogin.locatorXpath(prop.getProperty("locatorXpath_EnterpriseAppAccess"));
		  Thread.sleep(5000); 
		  title = idmlogin.getTitle(); 
		  Assert.assertEquals(title,"Access Request"); 
		  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));;
		 		
		idmlogin.clickLink(prop.getProperty("PartnerOrganizationManagement"));
		title = idmlogin.getTitle();
		Assert.assertEquals(title, "Partner Organization");
		idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));;
		
		
		idmlogin.clickLink(prop.getProperty("PartnerUserManagement"));
		url = idmlogin.getURL();
		Assert.assertTrue(url.contains("partners"));
		idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));;
		
		idmlogin.clickLink(prop.getProperty("GroupManagement"));
		String url1 = idmlogin.getURL();
		Assert.assertTrue(url1.contains("groups"));
		idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));
		
		idmlogin.clickLink(prop.getProperty("RequestGroupMembership"));
		String url2 = idmlogin.getURL();
		Assert.assertTrue(url2.contains("groupAccess"));
		idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));
		
		}
	
	
	  @Test(priority =1, enabled = false)
	  public void verifyApprovals() throws InterruptedException{ 
	  idmlogin.loggingIn(prop.getProperty("Username"), prop.getProperty("Password"));
	  
	  
		 idmlogin.locatorXpath(prop.getProperty("locatorXpath_EnterpriseAppApprovals"));
		 url = idmlogin.getURL();
	      Assert.assertTrue(url.contains("manageApprovals"));
	      idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));
	  
	      Thread.sleep(5000);
		  idmlogin.locatorXpath(prop.getProperty("locatorXpath_ERPApprovals"));
		  url = idmlogin.getURL();
	      Assert.assertTrue(url.contains("workitem"));
		  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));
		  
		  idmlogin.locatorXpath(prop.getProperty("locatorXpath_PartnerApprovals"));
		  url = idmlogin.getURL();
		  Assert.assertTrue(url.contains("approval"));
		  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));
		  
		  
		  idmlogin.locatorXpath(prop.getProperty("locatorXpath_RoleApprovals"));
		  url = idmlogin.getURL();
		  Assert.assertTrue(url.contains("roleApprovals"));
		  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));
		  
		  idmlogin.locatorXpath(prop.getProperty("locatorXpath_GroupApprovals"));
		  url = idmlogin.getURL();
		  Assert.assertTrue(url.contains("groupApproval"));
		  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));
	  
	  }
	  
	  @Test(priority =2 , enabled= false) 
	  public void trackRequests() throws InterruptedException {
	  idmlogin.loggingIn(prop.getProperty("Username"), prop.getProperty("Password"));
	  
	  idmlogin.clickLink(prop.getProperty("TrackEnterpriseRequests")); 
	  url = idmlogin.getURL();
	  Assert.assertTrue(url.contains("trackRequests"));
	  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));
	 
	  
	  idmlogin.clickLink(prop.getProperty("TrackERPRequests")); 
	  url = idmlogin.getURL();
	  Assert.assertTrue(url.contains("identityRequest"));
	  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));;
	  
	  idmlogin.clickLink(prop.getProperty("TrackGroupManagementRequests"));
	  url = idmlogin.getURL();
	  Assert.assertTrue(url.contains("groupTrack"));
	  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));;
	  
	  idmlogin.clickLink(prop.getProperty("TrackPartnerRequests")); 
	  title = idmlogin.getTitle();; 
	  Assert.assertEquals(title, "Track Request");
	  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));;
	  
	  }
	  
	  @Test(priority =3, enabled =false) 
	  public void verifyReports() throws InterruptedException {
	  idmlogin.loggingIn(prop.getProperty("Username"), prop.getProperty("Password"));
	  
	  idmlogin.clickLink(prop.getProperty("EnterpriseReports"));
	  title = idmlogin.getTitle(); 
	  Assert.assertEquals(title, "Application Report");
	  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));;
	  
	  idmlogin.clickLink(prop.getProperty("PartnerReports")); 
	  url = idmlogin.getURL();
	  Assert.assertTrue(url.contains("partnerReports"));
	  idmlogin.locatorXpath(prop.getProperty("locatorXpath_Dashboard"));;
	  
	  idmlogin.clickLink(prop.getProperty("GroupManagementReports"));
	  title = idmlogin.getTitle(); 
	  Assert.assertEquals(title, "Reports");
	  
	  
	  }
	  
	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */
	 
	
	

}
