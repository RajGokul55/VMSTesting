package com.qa.wave4;

import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import junit.framework.Assert;

public class GSHIP extends CommonMethods {
	/***************************** Test Data *******************/
	final String Browser = "IE";
	final String PrdURL = "http://sjaglwebdevn01/agileelite/projects/console.aspx?groupid=1";
	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\SiKuli\\GSHIP\\";
	String ID ="5579985";

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


	String URL = PrdURL;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
	}

	@Test(priority=1, enabled=false)
	public void GSHIP_S01_Web_Validate_URL_Check() {
		TM_S01_Web_Validate_URL_Check();
	}

	@Test(priority=2, enabled=false)
	public void GSHIP_S02_Web_Validate_All_Tabs() throws FindFailed {
		TM_S02_Web_Validate_All_Tabs();
	}

	@Test(priority=3, enabled=false)
	public void GSHIP_S03_Web_Validate_Search_Shipment() throws FindFailed {
		TM_S03_Web_Validate_Search_Shipment();
	}
	
	@Test(priority=4, enabled=true)
	public void GSHIP_S04_Web_Validate_View_Order() throws FindFailed {
		TM_S04_Web_Validate_View_Order();
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



	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn

	public void TM_S01_Web_Validate_URL_Check() {
		wait(10);
		Screen s = new Screen();
		Pattern OK = new Pattern(path + "OK.PNG");
		try {
			s.click(OK);
			wait(2);
		}catch (FindFailed e) {

			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
		Assert.assertEquals("AgileShip", driver.getTitle());
	}

	public void TM_S02_Web_Validate_All_Tabs() throws FindFailed {

		Pattern AgileShipLPN = new Pattern(path + "agileshilplpn.PNG");
		Pattern AgileView = new Pattern(path + "agileview.PNG");
		Pattern ShipConfirmation = new Pattern(path + "shipconfirm.PNG");
		Pattern ShipConfirmationBulk = new Pattern(path + "shipconfirmbulk.PNG");
		Pattern AddressBook = new Pattern(path + "addressbook.PNG");
		Pattern PODReport = new Pattern(path + "podreport.PNG");
		Pattern EndOfDay = new Pattern(path + "endofday.PNG");

		wait(10);
		Screen s = new Screen();
		Pattern OK = new Pattern(path + "OK.PNG");
		wait(5);
		try {
			s.click(OK);
			wait(2);
		}catch (FindFailed e) {

			e.printStackTrace();
		}
		Assert.assertEquals("AgileShip", driver.getTitle());
		takeScreenshotAtSikuli();
		wait(2);
		s.click(AgileShipLPN);
		wait(5);
		try {
			s.click(OK);
			wait(2);
		}catch (FindFailed e) {

			e.printStackTrace();
		}
		Assert.assertEquals("AgileShip - LPN", driver.getTitle());
		takeScreenshotAtSikuli();

		s.click(AgileView);
		wait(5);
		Assert.assertEquals("AgileView", driver.getTitle());
		takeScreenshotAtSikuli();

		s.click(ShipConfirmation);
		wait(5);
		Assert.assertEquals("Ship Confirmation", driver.getTitle());
		takeScreenshotAtSikuli();

		s.click(ShipConfirmationBulk);
		wait(5);
		Assert.assertEquals("Ship Confirmation - BULK", driver.getTitle());
		takeScreenshotAtSikuli();

		s.click(AddressBook);
		wait(5);
		Assert.assertEquals("Address Book", driver.getTitle());
		takeScreenshotAtSikuli();

		s.click(PODReport);
		wait(5);
		Assert.assertEquals("POD Report", driver.getTitle());
		takeScreenshotAtSikuli();

		s.click(EndOfDay);
		wait(5);
		Assert.assertEquals("End of Day", driver.getTitle());
		takeScreenshotAtSikuli();

	}

	public void TM_S03_Web_Validate_Search_Shipment() throws FindFailed{
		wait(10);
		Screen s = new Screen();
		Pattern OK = new Pattern(path + "OK.PNG");
		try {
			s.click(OK);
			wait(2);
		}catch (FindFailed e) {

			e.printStackTrace();
		}

		Pattern AgileView = new Pattern(path + "agileview.PNG");
		Pattern SearchShipments = new Pattern(path + "searchship.PNG");
		Pattern ShipmentNumber = new Pattern(path + "ship1.PNG");
		Pattern VoidComp = new Pattern(path + "voidcomp.PNG"); 
		Pattern Dummy = new Pattern(path + "dummy.PNG"); 

		s.click(AgileView);
		wait(5);

		s.click(SearchShipments);
		wait(5);
		
		s.click(ShipmentNumber);
		wait(5);
		
		s.mouseMove(Dummy);
		s.wheel(Button.WHEEL_DOWN, 2);
		wait(3);
		
		s.click(VoidComp);
		wait(5);
		s.click(OK);
		wait(2);
		s.click(OK);
		wait(2);
		s.wheel(Button.WHEEL_UP, 2);
		wait(2);
		takeScreenshotAtSikuli();
		
	}

	public void TM_S04_Web_Validate_View_Order() throws FindFailed {
		wait(10);
		Screen s = new Screen();
		Pattern OK = new Pattern(path + "OK.PNG");
		try {
			s.click(OK);
			wait(2);
		}catch (FindFailed e) {

			e.printStackTrace();
		}
		
		Pattern AgileView = new Pattern(path + "agileview.PNG");
		Pattern DeliveryID = new Pattern(path + "deliveryid.PNG");
		Pattern SearchShipments = new Pattern(path + "searchship.PNG");
		
		s.click(AgileView);
		wait(5);
		
		s.type(DeliveryID, ID);
		wait(5);
		
		s.click(SearchShipments);
		wait(5);
		
		takeScreenshotAtSikuli();
		
	}

}
