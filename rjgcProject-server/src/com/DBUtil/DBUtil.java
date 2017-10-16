package com.DBUtil;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

//import com.mysql.jdbc.Connection;

public class DBUtil {

	private static String url="jdbc:mysql://localhost:3306/rjgcdatabase";
	private static String driverClass="com.mysql.jdbc.Driver";
	private static String username="root";
	private static String password="root";
	private static Connection conn;
	
	static{
		try{
			Class.forName(driverClass);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try{
			conn=DriverManager.getConnection(url, username, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args){
		Connection conn=DBUtil.getConnection();
		if(conn==null){
			System.out.println("连接数据库失败");
		}
	}
	
	public static void Close(){
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
