package com.mystudy.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommonJDBCUtil {
	
	//고정시키는 final, 상수화된 변수는 대문자
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@192.168.18.4:1521:xe";
	private static final String USER = "mystudy";
	private static final String PASSWORD = "mystudypw";

	public static Connection getConnection() { //connection 객체 얻음 : 있으면 쓰고 없으면 null
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (SQLException e) {
			System.out.println("[예외발생] 접속실패 - " + e.getMessage());
		}
		return null;
	}




public static void close(Connection conn, Statement stmt, 
		ResultSet rs) {
	//5. 클로징 처리에 의한 자원 반납
	try {
		if (rs != null) rs.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		if (stmt != null) stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		if (conn != null) conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	close(conn, stmt);
}
	
	public static void close(Connection conn, Statement stmt) {
		//5. 클로징 처리에 의한 자원 반납
		try {
			if (stmt != null) stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}