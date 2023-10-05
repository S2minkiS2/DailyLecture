package com.mystudy.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "mystudy";
	private static final String PASSWORD = "mystudypw";
	
	//static 초기화 구문
	static { 
		try {
			Class.forName(DRIVER); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 위 코드는 DRIVER 변수에 저장된 드라이버 클래스 이름을 사용하여 해당 드라이버 클래스를 로드하려는 시도를 합니다. 
	 * 드라이버 클래스를 로드하는 이유는 JDBC를 사용하여 데이터베이스와 연결하기 전에 해당 데이터베이스의 드라이버를 등록해야 하기 때문입니다.
	 * 또한 
	 * 드라이버 클래스를 로드할 때 Class.forName 메서드를 사용하고 있으며, 
	 * 이 작업이 실패할 경우 ClassNotFoundException이 발생할 수 있습니다. 
	 * 그래서 예외 처리를 위한 try-catch 블록이 사용되었습니다.
	 * --------------
	 * 즉, 이 코드는 클래스가 로드될 때 Oracle 데이터베이스 드라이버 클래스를 로드하려고 시도하는 것 
	   */
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (Exception e) {}
		
		try {
			if (pstmt != null) pstmt.close();
		} catch (SQLException e) {}
		
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try { 
			if (pstmt != null) pstmt.close();
		} catch (SQLException e) {}
		
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {}
	}
}
