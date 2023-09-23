package com.mystudy.jdbc2_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student_Select_PreparedStatement {

	public static void main(String[] args) {
		//JDBC 이용한 DB 연동 프로그래밍 작성 절차
		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		//1. JDBC 드라이버 로딩 - 빌드패스
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		//3. Statement 문 실행(SQL 문 실행) -- connection 객체로부터 statement 객체 생성
		//4. SQL 실행 결과에 대한 처리
		//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리    // 반드시 전달받은 데이터로 작업처리하기
		//   - INSERT, UPDATE, DELETE : int 값(건수) 처리 // 실행결과가 db에 들어감
		//5. 클로징 처리에 의한 자원 반납
		//----------------------------------

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
		//1. JDBC 드라이버 로딩 - 빌드패스
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println(">> 드라이버 로딩 성공");
		
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
				"MYSTUDY", "mystudypw");
		
		//3. Statement 문 실행(SQL 문 실행) -- connection 객체로부터 statement 객체 생성
		//내가 쓸 sql 문장은 이거니까 준비해주세요
		String sql = "" 
		+ "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG"
		+ " FROM STUDENT"
		+ " WHERE ID = ? "; //? : 데이터 설정 위치 지정
		
		// 3-1. Connection 객체로 부터 preparedStatement 객체를 생성했다.
		pstmt = conn.prepareStatement(sql);
		//사용되는 메소드는 prepareStatement다. 
		//여기서 sql문장을 전달해서 미리 준비시킨다.
		
		//where절 없으면 ?없으니까 
		//3-2. ?(바인드변수) 위치에 값 설정
		String id = "2023012";
		pstmt.setString(1, id);
		
		System.out.println("sql : " + sql);
		rs = pstmt.executeQuery(); //준비되어있는 sql문 실행요청
		
		
//		데이터베이스 연결객체 얻고
//		준비해줘라
//		물음표 줄테니 그 위치에 매칭시켜라
//		준비된거 실행시켜라
//		result set 타입의 객체 전달받는다.
		
		//4. SQL 실행 결과에 대한 처리
		//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리    // 반드시 전달받은 데이터로 작업처리하기
		//   - INSERT, UPDATE, DELETE : int 값(건수) 처리 // 실행결과가 db에 들어감
		if(rs.next()) {
			String str = ""
				+ rs.getString("ID")+ "\t"
				+ rs.getString("NAME") + "\t"
				+ rs.getInt("KOR") + "\t"
				+ rs.getInt("ENG") + "\t"
				+ rs.getInt("MATH") + "\t"
				+ rs.getInt("TOT") + "\t"
				+ rs.getDouble("AVG") + "\t";
			System.out.println(str);
		}
		
//		prepared 메소드 
//		실행한다
//		?등장 
//		물음표 매칭
//		메서드는 또각ㅌ지만 sql문장 요청 필요없다.
//		나머지는 똑같다.
				
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	
	//5. 클로징 처리에 의한 자원 반납
	
	}

}
