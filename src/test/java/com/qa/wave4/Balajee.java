package com.qa.wave4;

import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.qa.demo.base.CommonMethods;

public class Balajee extends CommonMethods {

	@Test()
	public void RDP_Connection() {

		TM_RDP_Connection("Hostname", "balajee", "passwrod");
	}

	public static void TM_RDP_Connection(String servername,String username, String password) {
		final String userDirectory = System.getProperty("user.dir");
		String path = userDirectory + "\\AutoFiles\\SiKuli\\RDP\\";
		Screen s = new Screen();
		Pattern startBtn = new Pattern(path + "StartButton.PNG");
		Pattern RDPConnection= new Pattern(path + "remoteConnection.PNG");
		Pattern serverName= new Pattern(path + "RDPServerName.PNG");
		Pattern connectRDPServer= new Pattern(path + "connectButton.PNG");
		Pattern useanotherAccount= new Pattern(path + "useAnotherAccount.PNG");
		Pattern userNameRDP= new Pattern(path + "usernameRDP.PNG");
		Pattern passwordRDP= new Pattern(path + "passwordRDP.PNG");
		Pattern okButton= new Pattern(path + "oKButtonRDP.PNG");


		try {
			s.wait(startBtn, 3000);
			s.click();
			s.wait(RDPConnection, 2000);
			s.click();
			wait(5);
			s.type(Key.BACKSPACE);
			s.wait(serverName, 2000);	
			s.type(servername);
			s.wait(connectRDPServer, 2000);
			s.click();
			s.wait(useanotherAccount, 2000);
			s.click();
			s.wait(userNameRDP, 2000);
			s.type(userNameRDP, username);
			s.wait(passwordRDP, 2000);
			s.type(passwordRDP, password);
			s.wait(okButton, 2000);
			s.click(); 
		}
		catch(Exception e) {
			e.printStackTrace();

		}

	}

}
