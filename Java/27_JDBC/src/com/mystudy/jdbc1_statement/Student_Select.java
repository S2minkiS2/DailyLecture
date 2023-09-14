package com.mystudy.jdbc1_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student_Select {
	public static void main(String[] args) {
		//JDBC 이용한 DB 연동 프로그래밍 작성 절차
		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		//1. JDBC 드라이버 로딩 - 빌드패스
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		//3. Statement 문 실행(SQL 문 실행)
		//4. SQL 실행 결과에 대한 처리
		//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리    // 반드시 전달받은 데이터로 작업처리하기
		//   - INSERT, UPDATE, DELETE : int 값(건수) 처리 // 실행결과가 db에 들어감
		//5. 클로징 처리에 의한 자원 반납
		//----------------------------------
		
		//1. JDBC 드라이버 로딩 // 한번만 로딩하면 계속 사용 가능
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//.하고 다이렉트로 사용-> 스태틱 메소드
			System.out.println(">> 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외발생] 드라이버 로딩 실패");
			//가져다놔도 빌드패스 등록 안하면 사용 실패
			e.printStackTrace();
		}
		
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		Connection conn = null; //catch절 안에서도 사용, close도 해야하니까 선언부를 빼줌
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
		"mystudy", "mystudypw");
			//반드시 connection 타입의 연결객체를 저장해야한다.
			// [jdbc:oracle:thin:]까진 동일, @뒤에는 ip주소를 넣거나 위치, 포트번호 넣기
			//실행하고나면 Connection타입의 데이터 리턴해줌
		System.out.println(">> DB연결 성공 : " + conn);
		} catch (SQLException e) {
			System.out.println("[예외발생] DB연결 실패!! : " + conn);
			e.printStackTrace();
		} 
		
		//3. Statement 문 실행(SQL 문 실행) 
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체로부터 Statement 객체 생성 (Statement타입으로 리턴)
			stmt = conn.createStatement();
			//connection 타입에서 제공하는 메서드를 사용해서 호출
			String sql = ""
						+ "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG"
						+ " FROM STUDENT"
						+ " WHERE NAME LIKE '홍길동%'" //사용했던 SQL 문장 다 사용가능
						+ " ORDER BY ID"; //그냥 갖다 붙기 때문에 space한칸 줘야함
			System.out.println("sql : " + sql);
			rs = stmt.executeQuery(sql);
			//ResultSet타입으로 리턴
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리  
			// SELECT는 반드시 전달받은 데이터 저장 후 작업처리하기
			while (rs.next()) {
				//컬럼명, 위치값 전부 사용 가능 but 컬럼명 사용이 나음
				System.out.print(rs.getString("ID") + "\t");
				System.out.print(rs.getString("NAME") + "\t");
				System.out.print(rs.getInt("KOR") + "\t");
				System.out.print(rs.getInt("ENG") + "\t");
				System.out.print(rs.getInt("MATH") + "\t");
				System.out.print(rs.getInt("TOT") + "\t");
				System.out.println(rs.getDouble("AVG") + "\t");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//5. 클로징 처리에 의한 자원 반납
		//연결 후 작업이 끝나면 연결을 끊어줘야함. DB에는 동시접속자수 제한이 있다.
		//생성 객체 역순으로 CLOSE 
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null) stmt.close();
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
