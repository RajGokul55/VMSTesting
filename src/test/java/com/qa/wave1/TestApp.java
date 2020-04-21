package com.qa.wave1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;



public class TestApp extends CommonMethods{

	/***************************** Test Data*******************/
	final String Browser= "Chrome";
	final String Url= "https://www.flipkart.com/";
	final String Username ="987654321";
	private String DecrptPassword;
	String EncryptPassword = "MGhWvRKRMdkF0pu8i/E6pA==";


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


	@BeforeMethod(enabled=true)
	public void beforeTest() {
		launchBrowser(Browser, Url);
	}

	@Test(priority=0, enabled=true)
	public void Filkart_05_Web_ValidateCredntails() {
		TM_Filkart_05_Web_ValidateCredntails();
	}

	@Test(priority=1, enabled=true)
	public void Filkart_03_Web_ValidatemenuItems() {
		TM_Filkart_03_Web_ValidatemenuItems();
	}
	
	@Test(priority=2, enabled=true)
	public void Amazon_01_Web_Validatedropdown() {
		TM_Amazon_01_Web_Validatedropdown();
	}

	@Test(priority=3, enabled = false)
	public void RandomNumber() {
	TM_RandomNumber();	
	}
	
	@Test(priority=4, enabled = false)
	public void ExcelReadandWrite() {
	TM_ExcelReadandWrite();	
	}
	
	@AfterMethod(enabled=true)
	public void afterTest() {
		driver.quit();
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

	By ipt_Username= By.xpath("//input[@class= '_2zrpKA _1dBPDZ']");
	By ipt_Passwrod= By.cssSelector("input[class='_2zrpKA _3v41xv _1dBPDZ']");
	By btn_Submit = By.cssSelector("button[class= '_2AkmmA _1LctnI _7UHT_c']");
	By msg_Warning = By.cssSelector("span[class='ZAtlA-']>span");
	By menu_Items= By.cssSelector("ul[class='_114Zhd']>li");
	By btn_Close = By.cssSelector("button[class='_2AkmmA _29YdH8']");
	By menu_TVAppliance= By.cssSelector("li:nth-child(2)>span[class='_1QZ6fC _3Lgyp8']");
	By lnk_Samsung= By.cssSelector("a[title='Samsung'][href^='/televisions/pr']");
	By img_Help = By.cssSelector("img[alt='Buying Guide']");
	By slt_Dropdown = By.cssSelector("select[aria-describedby='searchDropdownDescription']");
	By slt_dropwn = By.cssSelector("div[id='nav-search-dropdown-card']");
	By opt_AmazonFresh = By.cssSelector("select[title='Search in']>option[value$='amazonfresh']");
	By id_amazontab= By.cssSelector("#1234s");
	

	/*****************************Test Case Methods *******************/
	//For all WebElements may append type Example: Submit_Btn

	void TM_Filkart_05_Web_ValidateCredntails() {

		WebElement Username_Ipt = createWebElementBy(ipt_Username);
		Username_Ipt.sendKeys(Username);
		
		try {
			DecrptPassword = decrypt(EncryptPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement Password_Ipt = createWebElementBy(ipt_Passwrod);
		Password_Ipt.sendKeys(DecrptPassword);

		WebElement Submit_Btn = createWebElementBy(btn_Submit);
		Submit_Btn.click();

		WebElement Error_Msg = createWebElementBy(msg_Warning);
		Assert.assertEquals(Error_Msg.getText(), "Please enter valid Email ID/Mobile number");
		
		takeScreenshotAtEndOfTest();

	}

	void TM_Filkart_03_Web_ValidatemenuItems() {

		WebElement Close_Btn = createWebElementBy(btn_Close);
		Close_Btn.click();

		List<WebElement> Items_Menu = createWebElementsBy(menu_Items);
		for(int i=0; i<Items_Menu.size(); i++) {
			System.out.println("Menu item "+Items_Menu.get(i).getText()+" is displayed" );
		}

		WebElement TV_Menu = createWebElementBy(menu_TVAppliance);
		mouseHover(TV_Menu);

		WebElement Samsung_lnk = createWebElementBy(lnk_Samsung);
		//Samsung_lnk.click();
		domClick(Samsung_lnk);
		
		waitForPageLoaded();
		
		WebElement Help_Img = createWebElementBy(img_Help);
		scrollToWebElement(Help_Img);
		
		scrollBehaviorByPixels(0, -400);
		
		wait(2);
		
		Help_Img.click();
		
		waitForPageLoaded();
		
		scrollToBottomOfHTML();
		
		takeScreenshotAtEndOfTest();

	}
	
	void TM_Amazon_01_Web_Validatedropdown(){
		launchBrowser(Browser, "https://www.amazon.com/");
		
		wait(4);
				
		//WebElement Dropwn_Slt = createWebElementBy(slt_dropwn);
		//Dropwn_Slt.click();
		WebElement Dropdown_Slt = createWebElementBy(slt_Dropdown);
		selectDropdownValue(Dropdown_Slt, "Amazon Fresh");
		
		driver.navigate().refresh();
		
		wait(4);
		
		WebElement AmazonFresh_Opt = createWebElementBy(opt_AmazonFresh);
		selectDropdownValueByWebElements(Dropdown_Slt, AmazonFresh_Opt);
		
		takeScreenshotAtEndOfTest();
		
		
	}
	
	void TM_RandomNumber(){
		String  rndNo = getAlphaNumericString(10);
		System.out.println("AlphaNumaric Random number: "+ rndNo);
		
	}


	void TM_ExcelReadandWrite() {
		//readExcel("C:\\Users\\bpalle\\Documents", "EmpData.xls", "sheet1");
		writeExcel("C:\\Users\\bpalle\\Documents", "EmpData.xls", "sheet1");
		
	}
	/*****************************Application Interaction Methods *********************/
	// if any code re-usability is there specific to this Application then that should be maintained here
	
	public void readExcel(String filePath, String fileName, String sheetName) {
		File file= new File(filePath+"\\"+fileName);
		Workbook myWorkBook = null;
		try {
			FileInputStream inputStream = new FileInputStream(file);
			myWorkBook = new HSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet mySheet = myWorkBook.getSheet(sheetName);

		int rowno = 1;
		int colno = 2;
		Row rowNo = mySheet.getRow(rowno);
		int rowCount = mySheet.getLastRowNum()- mySheet.getFirstRowNum();
		System.out.println("Excel sheet cell value :" +rowNo.getCell(colno).getStringCellValue()+" with no of rows: "+rowCount);
		
	}
		 
	

	public void writeExcel(String filePath, String fileName, String sheetName) {
		File file= new File(filePath+"\\"+fileName);
		Workbook myWorkBook = null;
		try {
			FileInputStream inputStream = new FileInputStream(file);
			myWorkBook = new HSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Sheet mySheet = myWorkBook.getSheet(sheetName);

		int rowNo = 1;
		int colNo = 1;

	    Row newRow = mySheet.createRow(rowNo);
	    Cell cell = newRow.createCell(colNo);

        cell.setCellValue("Welcome");

		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(file);
			//write data in the excel file

			try {
				myWorkBook.write(outputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	
	


	
}