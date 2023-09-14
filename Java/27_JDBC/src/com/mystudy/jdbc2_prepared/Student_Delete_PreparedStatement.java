package com.mystudy.jdbc2_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student_Delete_PreparedStatement {

	public static void main(String[] args) {
		//JDBC 이용한 DB 연동 프로그래밍 작성 절차
		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		//1. JDBC 드라이버 로딩
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		//3. Statement 문 실행(SQL 문 실행)
		//4. SQL 실행 결과에 대한 처리
		//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
		//   - INSERT, UPDATE, DELETE : int 값(건수) 처리
		//5. 클로징 처리에 의한 자원 반납
		//---------------------------
		
		//(실습) ID 일치하는 데이터 삭제 -> WHERE조건에 아이디
		
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		try {
		//1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> 드라이버 로딩 성공");
		
		//2. DB 연결 - Connection 객체 생성 <- DriverManager
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , 
											"MYSTUDY", "mystudypw");
		System.out.println(">> DB 연결 성공");
		
		//3. Statement 문 실행(SQL 문 실행)
		String sql = "DELETE STUDENT WHERE ID = ? ";		
		
		//3-1. SQL문 실행을 위한 준비 (PreparedStatement 객체 생성)
		pstmt = conn.prepareStatement(sql); //준비된 sql문 실행 요청
		
		// 3-2. SQL문장의 ? 위치에 값 설정 (대입)
		String id = "2023012";
		pstmt.setString(1,  id);
		
		//3-3. 준비된 SQL문 실행 요청
		int result = pstmt.executeUpdate();
		
		//4. SQL 실행 결과에 대한 처리
		// - DELETE : int 값 (건수) 처리
		System.out.println("처리건수 : " + result);
 		
		
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (pstmt != null) pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		

	}

}
