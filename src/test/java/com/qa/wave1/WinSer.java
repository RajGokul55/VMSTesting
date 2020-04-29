package com.qa.wave1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class WinSer extends CommonMethods{

	/***************************** Test Data************************************/

	static final String userDirectory = System.getProperty("user.dir");

	/***************************** Test ************************************/
	@Test(priority=0, enabled=true)
	public void createBatFil() {
		createBatFile("myserver9876", "bpalle");
	}


	/***************************** Test Methods************************************/
	public void createBatFile(String serName, String UserID) {

		String GPVpwd = null;
		//GPVpwd = RSA_Authentication(UserID);

		String  path = userDirectory+"\\AutoFiles\\"; //= userDirectory+"\\AutoFiles";
		String pathFile = path+"Run.bat";

		/*
		 * String commands =
		 * "Welcome User: "+UserID+" with Password: "+GPVpwd+" Server Name: "+serName;
		 * 
		 * File fileObj = new File(pathFile); try { fileObj.createNewFile(); FileWriter
		 * myWriter = new FileWriter(pathFile);
		 * 
		 * myWriter.write("notepad"); myWriter.close();
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		try {
			Runtime.getRuntime().exec("cmd /C start "+pathFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		wait(5);
		
		//fileObj.delete();

	}

	/***************************** Interaction Methods***********************************/

}