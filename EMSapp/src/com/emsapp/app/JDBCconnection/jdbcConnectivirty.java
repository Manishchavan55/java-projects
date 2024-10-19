package com.emsapp.app.JDBCconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnectivirty {

	public static final String DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/test";
	public static final String USERNAME="root";
	public static final String PASS="root";
	public static  Connection con=null;
	public static Connection getConnection() {
			try {
				Class.forName(DRIVER);
				con=DriverManager.getConnection(URL,USERNAME,PASS);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return con;
		
	}
}
