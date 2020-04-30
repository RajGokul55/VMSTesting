package com.qa.wave1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.sl.draw.geom.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class WinSer extends CommonMethods {

	/***************************** Test Data ************************************/

	static final String userDirectory = System.getProperty("user.dir");

	/***************************** Test ************************************/
	@Test(priority = 0, enabled = true)
	public void AppName_TC01_WinServer() {
		TM_AppName_TC01_WinServer();
		
	}

	/***************************** * Test Methods	 ************************************/
	void TM_AppName_TC01_WinServer() {
		String path = userDirectory + "\\AutoFiles\\";
		String resout = path + "Output.txt";
		String runbat = path + "Run.bat";
		
		createNeededFiles("SJCONAPPPRDN02", "arc_druva_insync_flexfolder");
		
		//String password = RSA_Authentication("nnereddula");
		String password = "pjBElwPk$7V*"; 
		
		runWindowsServerCheckBat(runbat);
		sikuliEnterCredentails("ADM_nnereddula", password);
		
		verifyServiceStatus(resout, "arc_druva_insync_flexfolder", "Running");
	}
	
	

		// fileObj.delete();
		// fileObj1.delete();

	
	

	/****************************** Interaction Methods	***********************************/

	void AutomateDesktopApps(String username, String Paswd) throws IOException {
		System.out.println("Welcome to Desktop App Automation");


		String userDirectory = System.getProperty("user.dir");

		WebDriver driver = null;
		String winiumDriverPath =	userDirectory+"\\src\\main\\java\\com\\qa\\demo\\config\\Winium.Desktop.Driver.exe"; 

		DesktopOptions options = new DesktopOptions(); 
		options.setApplicationPath("C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe");
		WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(new
				File(winiumDriverPath)).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
		service.start();

		driver = new WiniumDriver(service, options);
		WebElement window = driver.findElement(By.className("SysCredential"));



		window.findElement(By.name("User name:")).click();
		window.findElement(By.name("User name:")).clear();
		window.findElement(By.name("User name:")).sendKeys(username);
		wait(2);
		window.findElement(By.name("Password:")).sendKeys(Paswd);
		wait(2);
		window.findElement(By.name("OK")).click();

		System.out.println("Entered  valid credentails ");
		driver.quit();

	}


	

	void verifyServiceStatus(String filePath) {
		File file = new File(filePath); 
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

		while(sc.hasNext()) {
			String str = sc.nextLine().toString().trim();
			str= str.replaceAll("\\s", "");
			System.out.println("Result Strings: "+str);
		}
		sc.close();

	}

	
	void advanceReader(String filepath) {
		List<String> lines = Collections.emptyList();

		try {
			lines= Files.readAllLines(Paths.get(filepath),StandardCharsets.UTF_8 );


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(String line: lines) {
			System.out.println("Result: "+line);
		}
	}


}