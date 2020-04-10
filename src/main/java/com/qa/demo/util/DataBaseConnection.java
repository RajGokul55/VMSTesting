package com.qa.demo.util;

import java.sql.*;

public class DataBaseConnection {

	public void dataBaseConnection() throws Exception {
		
		String url="jdbc:mysql://localhost:3306/aliens";
		String user = "";
		String password = "";
		String query = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		String name = rs.getString("username");
		System.out.println(name);
		
		st.close();
		con.close();
	}
	
}
