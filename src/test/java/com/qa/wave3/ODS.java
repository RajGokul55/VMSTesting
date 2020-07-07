package com.qa.wave3;


import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ODS {
	// Connection object
	static Connection con = null;
	// Statement object
	private static Statement stmt;
	// Constant for Database URL
	public static String DB_URL = "jdbc:oracle:thin:@fcracodbtstge-scan.na.gilead.com:1521/INTGUAT";  
	//jdbc:mysql://localhost:3306/user";   
	// Constant for Database Username
	public static String DB_USER = "INTGRO";
	// Constant for Database Password
	public static String DB_PASSWORD = "Gilead123";

	@BeforeTest
	public void setUp() throws Exception {
		try{
			// Make the database connection
			String dbClass = "oracle.jdbc.driver.OracleDriver";
			Class.forName(dbClass).newInstance();
			// Get connection to DB
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		try{
			String query = "SELECT COUNT(*) FROM GDHODS.ACCOUNT";
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(query);
			// Print the result untill all the records are printed
			// res.next() returns true if there is any next record else returns false
			while (res.next())
			{
				System.out.println("No of records found : "+ res.getInt(1));
				Reporter.log("No of records found : "+ res.getInt(1));
				Assert.assertTrue(res.getInt(1)>1);

				/*
              System.out.print(res.getString(1));
              System.out.print("\t" + res.getString(2));
              System.out.print("\t" + res.getString(3));
              System.out.println("\t" + res.getString(4));
				 */
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 

	}

	@AfterTest
	public void tearDown() throws Exception {
		// Close DB connection
		if (con != null) {
			con.close();
		}
	}





}