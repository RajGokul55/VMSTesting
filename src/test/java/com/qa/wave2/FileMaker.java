package com.qa.wave2;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

import org.testng.annotations.BeforeMethod;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class FileMaker extends CommonMethods {
	/***************************** Test Data *******************/

	final String userDirectory = System.getProperty("user.dir");
	String path = userDirectory + "\\AutoFiles\\FMP.txt";
	final String Browser = "Chrome";
	final String DevURL = "http://lvfmkappprdn01.na.gilead.com/fmi/xml/FMPXMLRESULT.xml?-dbnames";

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


	String URL = DevURL;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser(Browser, URL);
	}
	
	@Test(priority=1, enabled=true)
	public void FMP_S01_Web_Validate_Error_Code() {
		TM_S01_Web_Validate_Error_Code();
	}

	@AfterMethod
	public void afterMethod() {
		//driver.quit();
	}
	
	
	
	
	
	
	
	
	
	/***************************** Test Case Methods *******************/
	// For all WebElements may append type Example: Submit_Btn
	public void TM_S01_Web_Validate_Error_Code() {
		waitForPageLoaded();
		/*try{
		Screen s = new Screen();
		Pattern ErrorCode = new Pattern(path + "FMP_ErrorCode.PNG");
		Pattern Data = new Pattern(path+"FMD_Data.PNG");
		s.wait(ErrorCode, 10);
		String errorcode = s.find(ErrorCode).text();
		String data = s.find(Data).getText();
		System.out.println(errorcode);
		System.out.println(data);
		}catch(FindFailed e) {
			e.printStackTrace();
		}
	}*/
		String text = driver.findElement(By.cssSelector("div.pretty-print")).getText();
		System.out.println(text);
		try {
			FileWriter fw=new FileWriter(path);
	          if(text!=null) {
	            fw.write(text);
	            fw.close();
	          }else {
	        	  Assert.fail("The text was not copied");
	          }
	      } catch(IOException e) {
	          System.out.println(e);
	      }
	    }
	
}