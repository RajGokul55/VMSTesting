package com.qa.demo.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IClass;
import org.testng.ITestResult;

import com.qa.demo.base.TestBase;

public class TestUtil extends TestBase{

	public static long Page_Load_Timeout = 20;
	public static long Implicitly_Wait = 10;
	public static ITestResult result;
	private static WebDriverWait wait;
	
	//Drop-down value
	public void selectDropdown(WebElement locator, String value) {
		Select select = new Select(locator);
		select.selectByVisibleText(value);
	}
	
	//Radio value
	public void selectRadio(List<WebElement> locator,String exvalue) {
		for(WebElement temp : locator) {
			if(temp.getAttribute("value").equalsIgnoreCase(exvalue)) {
				temp.click();
			}
		}
	}
	
	//Mouse hover
	public static void mousehover(WebElement locator) {
		Actions action = new Actions(driver);
		action.moveToElement(locator).click().build().perform();
	}
	
	//Window Handle
	public static void windowhandle() {
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> it = allwindow.iterator();
		String ParentWindow = it.next();
		String ChiledWindow = it.next();
		driver.switchTo().window(ChiledWindow);
	}
	
	//Screenshot
	public static void takeScreenshotAtEndOfTest(String method, IClass testClass) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(userDirectory + "/screenshots/" + "/"+testClass+"/"+ method + System.currentTimeMillis() + ".png"));	
	}
	
	//Explicit Wait
	public static void explicitWait(By locator) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
}
