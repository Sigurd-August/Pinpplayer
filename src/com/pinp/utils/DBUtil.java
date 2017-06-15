package com.pinp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static String url = "jdbc:mysql://127.0.0.1:3306/pinp?useUnicode=true&useSSL=false&amp;" +
			"characterEncoding=utf8"; 
	/** name & password*/
	private static String user = "root";
	private static String password = "mzhstc123";
	/** just ignore that*/
	static {
		try {
			// Load driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/** The function of connect to DBMS*/
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// Create a database connection
			conn = DriverManager.getConnection(url, user, password);
			// If successful get the database connection, print a success message
			System.out.println("connect success!"+"user:"+user);
		} catch (SQLException e) {
			System.out.println("connect fail!"+"user:"+user);
			e.printStackTrace();
		}
		return conn;
	}
	/** cut the link of DBMS*/
	public static void closeConnection(Connection conn) {
		try {
			if ((conn != null) && (!conn.isClosed())) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeStatement(Statement st) {
		try {
			if ((st != null) && (!st.isClosed())) {
				st.close();
				st = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeResultSet(ResultSet rs) {
		try {
			if ((rs != null) && (!rs.isClosed())) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
