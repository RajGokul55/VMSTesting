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
import java.util.ArrayList;
import java.util.Arrays;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class WinSer extends CommonMethods {

	/***************************** Test Data ************************************/

	static final String userDirectory = System.getProperty("user.dir");
	
	String path = userDirectory + "\\AutoFiles\\";
	String resout = path + "Output.txt";
	String runbat = path + "Run.bat";
	String ADM_UserID = null;
	String password = null;

	/***************************** Test ************************************/
	@BeforeMethod(enabled = true)
	public void BeforeRunningTest() {
		
		ADM_UserID = "adm_bgambhir";
		//password = RSA_Authentication("bpalle"); //nnereddula
		password = "ZF*Y?48Xh89Q"; 

	}
	
	@Test(priority = 0, enabled = true)
	public void AppName_TC01_WinServer() {
		TM_AppName_TC01_WinServer();

	}

	/***************************** * Test Methods	 ************************************/
	void TM_AppName_TC01_WinServer() {

		String path = userDirectory + "\\AutoFiles\\";
		String resout = path + "Output.txt";
		String runbat = path + "Run.bat";
		
		createNeededFiles("CCCONAPPPRDN01", "wuauserv");
		
		//String password = RSA_Authentication("nnereddula");
		String password = "pjBElwPk$7V*"; 
		


		createPS1HostnameServices(ADM_UserID, password, "SJB9APPDEVN01", "AppReadiness , ParityReporter, ParityServer");

		runWindowsServerCheckBat(runbat);

		verifyServiceStatus(resout, "AppReadiness", "Stopped");
		verifyServiceStatus(resout, "ParityReporter", "Running");
		verifyServiceStatus(resout, "ParityServer", "Running");
	}


	
	public void createPowerShellFile(String username, String password, String serName, String service1) {
		/* 
		 * Author: Balajee Palle
		 * Description: To Create local file for Server and .PS1 file for commands to execute 
		 * Parameter: Server host name and Service name 
		 * Date: May 2020 
		 * 
		 */

		String path = userDirectory + "\\AutoFiles\\";
		String pathFile1 = path + "computers.txt";
		String runps1 = path + "Run.ps1";
		String resout = path + "Output.txt";

		//"$cred = get-Credential -credential administrator \r\n" 
		String pscmds = "$Username = '"+ username +"' \r\n"
				+ "$Password = ConvertTo-SecureString '"+ password +"' -AsPlainText -Force \r\n"
				+ "$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist ($Username, $Password)\r\n"
				+ "$computer = '"+ serName +"' \r\n"
				+ "$servename = '"+ service1 +"' \r\n"
				+ "Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename } | Out-File -FilePath "
				+ resout
				+ "\r\n PAUSE";


		File fileObj1 = new File(runps1);
		try {
			fileObj1.createNewFile();
			FileWriter myWriter = new FileWriter(runps1);

			myWriter.write(pscmds);

			myWriter.close();

		} catch (IOException e) { 
			e.printStackTrace();
		}

		wait(5);
	}

	public void createPowerShellFile(String username, String password, String serName, String service1, String service2, String service3) {
		/* 
		 * Author: Balajee Palle
		 * Description: To Create local file for Server and .PS1 file for commands to execute 
		 * Parameter: Server host name and Service name 
		 * Date: May 2020 
		 * 
		 */

		String path = userDirectory + "\\AutoFiles\\";
		String pathFile1 = path + "computers.txt";
		String runps1 = path + "Run.ps1";
		String resout = path + "Output.txt";

		//"$cred = get-Credential -credential administrator \r\n" 
		String pscmds = "$Username = '"+ username +"' \r\n"
				+ "$Password = ConvertTo-SecureString '"+ password +"' -AsPlainText -Force \r\n"
				+ "$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist ($Username, $Password)\r\n"
				+ "$computer = '"+ serName +"' \r\n"
				+ "$servename1 = '"+ service1 +"' \r\n"
				+ "$servename2 = '"+ service2 +"' \r\n"
				+ "$servename3 = '"+ service3 +"' \r\n"
				+ "Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename1 -or  $_.Name -eq $servename2 -or  $_.Name -eq $servename3  } | Out-File -FilePath "
				+ resout
				+ "\r\n PAUSE";


		File fileObj1 = new File(runps1);
		try {
			fileObj1.createNewFile();
			FileWriter myWriter = new FileWriter(runps1);

			myWriter.write(pscmds);

			myWriter.close();

		} catch (IOException e) { 
			e.printStackTrace();
		}

		wait(5);
	}

	public void createNeededFiles(String serName, String service1) {
		/* 
		 * Author: Balajee Palle
		 * Description: To Create local file for Server and .PS1 file for commands to execute 
		 * Parameter: Server host name and Service name 
		 * Date: May 2020 
		 * 
		 */
		//String service = "'"+service1+"'";
		String path = userDirectory + "\\AutoFiles\\";
		String pathFile1 = path + "computers.txt";
		String runps1 = path + "Run.ps1";
		String resout = path + "Output.txt";

		String pscmds = "$cred = get-Credential -credential administrator \r\n" 
				+"$servename = '"+ service1 +"' \r\n"
				+ "$computer = get-content " + pathFile1 +"\r\n"	
				+ "Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename } | Out-File -FilePath "
				+ resout
				+ "\r\n PAUSE";

		File fileObj = new File(pathFile1);
		try {
			fileObj.createNewFile();
			FileWriter myWriter = new FileWriter(pathFile1);
			myWriter.write(serName);
			myWriter.close();

		} catch (IOException e) { 
			e.printStackTrace();
		}

		File fileObj1 = new File(runps1);
		try {
			fileObj1.createNewFile();
			FileWriter myWriter = new FileWriter(runps1);

			myWriter.write(pscmds);

			myWriter.close();

		} catch (IOException e) { 
			e.printStackTrace();
		}

		wait(5);
	}
	public void createNeededFiles(String serName, String service1, String service2) {
		/* 
		 * Author: Balajee Palle
		 * Description: To Create local file for Server and .PS1 file for commands to execute with 2 services method override 
		 * Parameter: Server host name and Service name, Service name2 
		 * Date: May 2020 
		 * 
		 */
		String path = userDirectory + "\\AutoFiles\\";
		String pathFile1 = path + "computers.txt";
		String runps1 = path + "Run.ps1";
		String resout = path + "Output.txt";

		String pscmds = "$cred = get-Credential -credential administrator \r\n" 
				+"$servename1 = '"+ service1 +"' \r\n"
				+"$servename2 = '"+ service2 +"' \r\n"
				+"$computer = get-content " + pathFile1 +"\r\n"	
				+"Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename1, $servename2 } | Out-File -FilePath "
				+ resout
				+ "\r\n PAUSE";

		File fileObj = new File(pathFile1);
		try {
			fileObj.createNewFile();
			FileWriter myWriter = new FileWriter(pathFile1);
			myWriter.write(serName);
			myWriter.close();

		} catch (IOException e) { 
			e.printStackTrace();
		}

		File fileObj1 = new File(runps1);
		try {
			fileObj1.createNewFile();
			FileWriter myWriter = new FileWriter(runps1);

			myWriter.write(pscmds);

			myWriter.close();

		} catch (IOException e) { 
			e.printStackTrace();
		}

		wait(5);
	}


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

	public void createPS1HostnameServices(String username, String password, String serName, String services) {
		/*
		 * Author: Balajee Palle Description: To PS 1 File with Username , password and
		 * Hostname and with Services to be fetched Parameter: Username, Password,
		 * Hostname, and comma separate Services names Date: May 2020
		 * 
		 */
		String path = userDirectory + "\\AutoFiles\\";
		String runps1 = path + "Run.ps1";
		String pscmds = null;
		String resout = path + "Output.txt";
		String[] values = services.split(",");
		ArrayList<String> list = null; // = new ArrayList<>(Arrays.asList(values));
		int count = list.size();
		String service1 = null;
		String service2 = null;
		String service3 = null;
		String service4 = null;
		String service5 = null;
		String service6 = null;
		String service7 = null;

		switch (count) {
		case 1:
			service1 = list.get(0).trim();
			pscmds = "$Username = '" + username + "' \r\n" + "$Password = ConvertTo-SecureString '" + password
					+ "' -AsPlainText -Force \r\n"
					+ "$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist ($Username, $Password)\r\n"
					+ "$computer = '" + serName + "' \r\n" + "$servename = '" + service1 + "' \r\n"
					+ "Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename } | Out-File -FilePath "
					+ resout;
			break;
		case 2:
			service1 = list.get(0).trim();
			service2 = list.get(1).trim();
			pscmds = "$Username = '" + username + "' \r\n" + "$Password = ConvertTo-SecureString '" + password
					+ "' -AsPlainText -Force \r\n"
					+ "$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist ($Username, $Password)\r\n"
					+ "$computer = '" + serName + "' \r\n" + "$servename1 = '" + service1 + "' \r\n" + "$servename2 = '"
					+ service2 + "' \r\n"
					+ "Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename1 -or  $_.Name -eq $servename2 } | Out-File -FilePath "
					+ resout;
			break;
		case 3:

			service1 = list.get(0).trim();
			service2 = list.get(1).trim();
			service3 = list.get(2).trim();
			pscmds = "$Username = '" + username + "' \r\n" + "$Password = ConvertTo-SecureString '" + password
					+ "' -AsPlainText -Force \r\n"
					+ "$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist ($Username, $Password)\r\n"
					+ "$computer = '" + serName + "' \r\n" + "$servename1 = '" + service1 + "' \r\n" + "$servename2 = '"
					+ service2 + "' \r\n" + "$servename3 = '" + service3 + "' \r\n"
					+ "Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename1 -or  $_.Name -eq $servename2 -or  $_.Name -eq $servename3  } | Out-File -FilePath "
					+ resout;

			break;
		case 4:
			service1 = list.get(0).trim();
			service2 = list.get(1).trim();
			service3 = list.get(2).trim();
			service4 = list.get(3).trim();
			pscmds = "$Username = '" + username + "' \r\n" + "$Password = ConvertTo-SecureString '" + password
					+ "' -AsPlainText -Force \r\n"
					+ "$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist ($Username, $Password)\r\n"
					+ "$computer = '" + serName + "' \r\n" + "$servename1 = '" + service1 + "' \r\n" + "$servename2 = '"
					+ service2 + "' \r\n" + "$servename3 = '" + service3 + "' \r\n" + "$servename4 = '" + service4
					+ "' \r\n"
					+ "Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename1 -or  $_.Name -eq $servename2 -or  $_.Name -eq $servename3 -or  $_.Name -eq $servename4 } | Out-File -FilePath "
					+ resout;

			break;
		case 5:
			service1 = list.get(0).trim();
			service2 = list.get(1).trim();
			service3 = list.get(2).trim();
			service4 = list.get(3).trim();
			service5 = list.get(4).trim();
			pscmds = "$Username = '" + username + "' \r\n" + "$Password = ConvertTo-SecureString '" + password
					+ "' -AsPlainText -Force \r\n"
					+ "$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist ($Username, $Password)\r\n"
					+ "$computer = '" + serName + "' \r\n" + "$servename1 = '" + service1 + "' \r\n" + "$servename2 = '"
					+ service2 + "' \r\n" + "$servename3 = '" + service3 + "' \r\n" + "$servename4 = '" + service4
					+ "' \r\n" + "$servename5 = '" + service5 + "' \r\n"
					+ "Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename1 -or  $_.Name -eq $servename2 -or  $_.Name -eq $servename3 -or  $_.Name -eq $servename4 -or  $_.Name -eq $servename5 } | Out-File -FilePath "
					+ resout;
			break;
		case 6:
			service1 = list.get(0).trim();
			service2 = list.get(1).trim();
			service3 = list.get(2).trim();
			service4 = list.get(3).trim();
			service5 = list.get(4).trim();
			service6 = list.get(5).trim();
			pscmds = "$Username = '" + username + "' \r\n" + "$Password = ConvertTo-SecureString '" + password
					+ "' -AsPlainText -Force \r\n"
					+ "$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist ($Username, $Password)\r\n"
					+ "$computer = '" + serName + "' \r\n" + "$servename1 = '" + service1 + "' \r\n" + "$servename2 = '"
					+ service2 + "' \r\n" + "$servename3 = '" + service3 + "' \r\n" + "$servename4 = '" + service4
					+ "' \r\n" + "$servename5 = '" + service5 + "' \r\n" + "$servename6 = '" + service6 + "' \r\n"
					+ "Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename1 -or  $_.Name -eq $servename2 -or  $_.Name -eq $servename3 -or  $_.Name -eq $servename4 -or  $_.Name -eq $servename5 -or  $_.Name -eq $servename6} | Out-File -FilePath "
					+ resout;
			break;
		case 7:
			service1 = list.get(0).trim();
			service2 = list.get(1).trim();
			service3 = list.get(2).trim();
			service4 = list.get(3).trim();
			service5 = list.get(4).trim();
			service6 = list.get(5).trim();
			service7 = list.get(6).trim();
			pscmds = "$Username = '" + username + "' \r\n" + "$Password = ConvertTo-SecureString '" + password
					+ "' -AsPlainText -Force \r\n"
					+ "$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist ($Username, $Password)\r\n"
					+ "$computer = '" + serName + "' \r\n" + "$servename1 = '" + service1 + "' \r\n" + "$servename2 = '"
					+ service2 + "' \r\n" + "$servename3 = '" + service3 + "' \r\n" + "$servename4 = '" + service4
					+ "' \r\n" + "$servename5 = '" + service5 + "' \r\n" + "$servename6 = '" + service6 + "' \r\n"
					+ "$servename7 = '" + service7 + "' \r\n"
					+ "Get-WMIObject Win32_Service -computer $computer -credential $cred | Where { $_.Name -eq $servename1 -or  $_.Name -eq $servename2 -or  $_.Name -eq $servename3 -or  $_.Name -eq $servename4 -or  $_.Name -eq $servename5 -or  $_.Name -eq $servename6 -or  $_.Name -eq $servename7} | Out-File -FilePath "
					+ resout;
			break;
		default:
			System.out.println("As of now this method can be used maximum 7 Services only per Service.");
		}

		File fileObj1 = new File(runps1);
		try {
			fileObj1.createNewFile();
			FileWriter myWriter = new FileWriter(runps1);

			myWriter.write(pscmds);

			myWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		wait(5);
	}

	// fileObj1.delete();

}