package com.star.utils;

import java.sql.*;

public class JDBCUtil {
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BOOK";
	private static String username = "sa";
	private static String password = "root";
	
	private static Connection con = null;	
	private static Statement stat = null;
	
	static{
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			stat = con.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		return con;
	}
	public static Statement getStatement(){
		return stat;
	}
	
	public static void close(Connection con, Statement stat){
		if(con != null){
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
		if(stat != null){
			try{
				stat.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
