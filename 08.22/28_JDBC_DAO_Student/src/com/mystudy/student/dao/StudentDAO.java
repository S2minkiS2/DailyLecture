package com.mystudy.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mystudy.student.vo.StudentVO;

// XxxxDAO, XxxxDao : Data Access Object
// 데이터베이스(Database)와 연동해서 CRUD를 구현하는 클래스
// 데이터베이스(Database)와 연동해서 CRUD를 작업을 할 수 있는 기능을 제공하는 클래스
public class StudentDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "mystudy";
	private static final String PASSWORD = "mystudypw";

	// static 초기화 구문
	static {
		//1. JDBC 드라이버 로딩
		try {
			Class.forName(DRIVER);
			System.out.println(">> JDBC 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외발생] JDBC 드라이버 로딩 실패!!!");
		}
	}
	
	//SELECT : 데이터 1개 조회(id) - selectOne : StudentVO
	public StudentVO selectOne(String id) {
		StudentVO vo = null;
		
		//(할일) DB연결하고 SQL문 실행해서 결과값을 vo 변수에 저장하고 리턴
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//3. Statement 문 실행(SQL 문 실행)
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sb.append("  FROM STUDENT ");
			sb.append(" WHERE ID = ? ");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			if (rs.next()) {
				vo = new StudentVO(
						rs.getString("ID"),
						rs.getString("NAME"), 
						rs.getInt("KOR"), 
						rs.getInt("ENG"), 
						rs.getInt("MATH"),
						rs.getInt("TOT"),
						rs.getDouble("AVG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	//SELECT : 데이터 1개 조회(VO) - selectOne : StudentVO
	public StudentVO selectOne(StudentVO student) {
		return selectOne(student.getId());		
	}
	
	private void close(Connection conn, PreparedStatement pstmt, 
			ResultSet rs) {
		//5. 클로징 처리에 의한 자원 반납
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close(Connection conn, PreparedStatement pstmt) {
		//5. 클로징 처리에 의한 자원 반납
		try {
			if (pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//SELECT : 테이블 전체 데이터 조회 - selectAll : List<StudentVO>
	public List<StudentVO> selectAll() {
		List<StudentVO> list = null;
		
		
		return list;
	}
	
	//SELECT : 이름으로 검색 - select : List<StudentVO>
	
	//INSERT : VO 데이터를 받아서 입력 - insert : int
	public int insert(StudentVO vo) {
		int result = 0;
		
		return result;
	}
	
	//UPDATE : VO 데이터를 받아서 수정 - update : int
	//- UPDATE : 이름(name) 받아서 수정 - updateName : int
	//- UPDATE : 국어점수(kor) 수정 - updateKor : int
	//- UPDATE : 총점, 평균 계산처리 - updateTotAvg : int
	//DELETE : VO 객체를 받아서 삭제 - delete : int
	//DELETE : 키값(id)을 받아서 삭제 - delete : int
	
}

/*
스태틱 블록(static block)은 클래스가 로드될 때 실행되는 코드 블록입니다. 위 코드에서 스태틱 블록은 다음과 같이 구현되어 있습니다.

```java
static {
    try {
        Class.forName(DRIVER);
        System.out.println(">> JDBC 드라이버 로딩 성공");
    } catch (ClassNotFoundException e) {
        System.out.println("[예외발생] JDBC 드라이버 로딩 실패!!!");
    }
}
```

이 스태틱 블록의 주요 목적은 JDBC 드라이버를 로드하는 것입니다. JDBC(Java Database Connectivity)는 자바 언어를 사용하여 데이터베이스와 연동하는 데 사용되는 API입니다. 데이터베이스와 연동하려면 해당 데이터베이스의 JDBC 드라이버를 로드해야 합니다.

스태틱 블록을 사용하는 이유는 다음과 같습니다:

1. **드라이버 로드:** JDBC 드라이버를 로드해야만 데이터베이스와 연결 및 작업을 수행할 수 있습니다. 스태틱 블록은 클래스가 로드될 때 실행되므로, 클래스를 사용하기 전에 반드시 드라이버를 로드할 수 있도록 보장합니다.

2. **한 번만 실행:** 스태틱 블록 안의 코드는 클래스가 처음 로드될 때만 한 번 실행됩니다. 따라서 드라이버를 중복으로 로드하는 것을 방지하고, 코드 중복을 줄여줍니다.

3. **예외 처리:** 드라이버 로드 시 발생할 수 있는 ClassNotFoundException과 같은 예외를 처리할 수 있습니다. 스태틱 블록 안에서 예외 처리를 수행하고, 필요한 조치를 취하여 로딩에 실패한 경우에 대응할 수 있습니다.

결론적으로, 스태틱 블록을 사용하여 클래스 로드 시 초기화 작업을 수행하고, 데이터베이스 연동을 위해 필요한 드라이버 로딩 작업을 처리할 수 있습니다.
*/