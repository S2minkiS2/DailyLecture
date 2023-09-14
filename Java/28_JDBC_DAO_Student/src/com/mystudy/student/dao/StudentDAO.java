package com.mystudy.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mystudy.student.vo.StudentVO;

// XxxxDAO, XxxxDao : Data Access Object
	// 데이터베이스(Database)와 연동해서 CRUD를 구현하는 클래스
	// 데이터베이스(Database)와 연동해서 CRUD 작업하는 기능 제공 클래스
	
public class StudentDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
		  //고정시키는 final, 상수화된 변수는 대문자
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "mystudy";
	private static final String PASSWORD = "mystudypw";
	
	//필드에 뽑아낸 변수 : 여기저기 쓰니까~
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
 //static 초기화 구문 : 클래스가 로딩될 때 이 코드가 실행됨
	static {
		//1. JDBC 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> JDBC 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외발생] JDBC 드라이버 로딩 실패!!");
		}
	}	
	//DAO에 CRUD 작업 할 메소드 작성
	
	//SELECT : 데이터 1개 조회(id) = selectOne : StudentVO 타입으로 리턴
	//외부에서도 호출해서 쓸 수 있어야하니 public
	public StudentVO selectOne(String id) { 
		//키 값인 문자열 타입의 id를 전달받아서 찾는다.
		StudentVO vo = null;
		//String으로 넘겨주면 불편하니 vo에 담아서 준다. 
		// 각각의 변수 이름으로 데이터를 사용할 수 있다.
	
		//(할일) DB연결하고 SQL문 실행해서 결과값을 VO 변수에 저장 후 리턴
		//id값을 가지고 아이디 검색해서 vo에 저장 없으면 null
		
		
		
		
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		try { //연결 객체 생성 후 conn에 저장
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
			//3. Statement 문 실행(SQL 문 실행) // preparedStatement 타입으로
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG"); //sb의 문자열 붙이기
			sb.append("	FROM STUDENT ");
			sb.append("	WHERE ID = ? ");
			
			pstmt = conn.prepareStatement(sb.toString()); //sb의 문자열 전달받아 준비
			//전달 받은 sb의 string값 connection 준비, pstmt에 저장
			//준비하기 preparedStatement타입의 객체가 리턴되어지길
			
			pstmt.setString(1, id);
			
			
			rs = pstmt.executeQuery(); //sql문장 준비되어있으니 따로 sql안넣어도 됨
			//? 바인드 문장까지 준비된 sql문
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			//데이터가 있거나 없거나 둘 중 하나니까 if 사용. 
			if(rs.next()) {//물어보고 있으면 사용
				//vo변수에는 순서대로 데이터가 저장된다. 
				//여러개가 검색되면 물어보고 저장 물어보고 저장
				//while문을 쓴다면 각각의 데이터를 저장해야함.
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
		//SELECT : 이름으로 검색 - select : List<StudentVO>
		
		public List<StudentVO> selectAll() { 
			List<StudentVO> list = null;
			
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
			//3. Statement 문 실행(SQL 문 실행)
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG"); //sb의 문자열 붙이기
			sb.append("	FROM STUDENT ");
			sb.append("	 ORDER BY ID ");
			
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			
			list = new ArrayList<StudentVO>();
		
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리    // 반드시 전달받은 데이터로 작업처리하기
			//   - INSERT, UPDATE, DELETE : int 값(건수) 처리 // 실행결과가 db에 들어감
			while(rs.next()) {
				//있냐 물어보고 있으면 사용한다
				StudentVO vo = new StudentVO(
						rs.getString("ID"), 
						rs.getString("NAME"),
						rs.getInt("KOR"),
						rs.getInt("ENG"),
						rs.getInt("MATH"),
						rs.getInt("TOT"),
						rs.getDouble("AVG"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반남
			close(conn, pstmt, rs);
		}
		return list;	
	}
		

		
		
		
		//INSERT : VO 데이터를 받아서 입력 - insert : int
		public int insert(StudentVO vo) {
			int result = 0;
		
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
			//3. Statement 문 실행(SQL 문 실행)
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO STUDENT ");
			sql.append("			(ID, NAME, KOR, ENG, MATH, TOT, AVG) "); //sb의 문자열 붙이기
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString()); //toString 저장된 문자열 가져오기
			
			//? 값 설정
//			pstmt.setString(1, vo.getId());
//			pstmt.setString(2, vo.getName());
//			pstmt.setInt(3, vo.getKor());
//			pstmt.setInt(4, vo.getEng());
//			pstmt.setInt(5, vo.getMath());
//			pstmt.setInt(6, vo.getTot());
//			pstmt.setDouble(7, vo.getAvg());
			
			int i = 1;
			pstmt.setString(i++, vo.getId());
			pstmt.setString(i++, vo.getName());
			pstmt.setInt(i++, vo.getKor());
			pstmt.setInt(i++, vo.getEng());
			pstmt.setInt(i++, vo.getMath());
			pstmt.setInt(i++, vo.getTot());
			pstmt.setDouble(i++, vo.getAvg());	
			
			result = pstmt.executeUpdate(); //준비되었기때문에 실행요청만. 
			//int값 넘어오는데 필요하면 변수에 저장 가능.
		
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("[예외발생] 작업 중 예외가 발생 : " + e.getMessage());
			result = -1;
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			close(conn, pstmt);
		}
		
		return result;
	}

		
		
		
		//UPDATE : VO 데이터를 받아서 수정 - update : int
		//성명, 국어, 영어, 수학, 총점, 평균 바꾸기
		
//		?????여기서 int값을 받는 이유가 뭐지? --> result가 실행갯수임
		public int update(StudentVO vo) {
			int result = 0;
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
				//3. Statement 문 실행(SQL 문 실행)
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE STUDENT ");
				sql.append(  "	SET NAME = ? "); // 1 // ?로 매칭시켜준다
				sql.append(  "	  , KOR = ? ");  // 2
				sql.append(  "	  , ENG = ? ");  // 3
				sql.append(  "	  , MATH = ? "); // 4
				sql.append(  "	  , TOT = ? "); // 5
				sql.append(  "	  , AVG = ? "); // 6
				sql.append(  " WHERE ID = ? ");    // 7
				pstmt = conn.prepareStatement(sql.toString()); //toString 저장된 문자열 가져오기
				
				//? 값 설정
//				pstmt.setString(1, vo.getId());
//				pstmt.setString(2, vo.getName());
//				pstmt.setInt(3, vo.getKor());
//				pstmt.setInt(4, vo.getEng());
//				pstmt.setInt(5, vo.getMath());
//				pstmt.setInt(6, vo.getTot());
//				pstmt.setDouble(7, vo.getAvg());
				
				int i = 1;
				pstmt.setString(i++, vo.getName());
				pstmt.setInt(i++, vo.getKor());
				pstmt.setInt(i++, vo.getEng());
				pstmt.setInt(i++, vo.getMath());
				pstmt.setInt(i++, vo.getTot());
				pstmt.setDouble(i++, vo.getAvg());	
				pstmt.setString(i++, vo.getId());
				
				result = pstmt.executeUpdate(); //준비되었기때문에 실행요청만. 
				//int값 넘어오는데 필요하면 변수에 저장 가능.
			
			} catch (SQLException e) {
//				e.printStackTrace();
				System.out.println("[예외발생] 작업 중 예외가 발생 : " + e.getMessage());
				result = -1;
			} finally {
				//5. 클로징 처리에 의한 자원 반납
				close(conn, pstmt);
			}
			
			return result;
		}
			
		
		
		//DELETE : 키값(id)을 받아서 삭제 - delete : int
		public int delete (String id) {
			int count = 0;
			
			//2. DB연결
			try { //DriverManager에서 커넥션 객체 생성 후 변수에 저장
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println(">> DB 연결 성공");

				//3. Statement문 실행 (SQL)문장 실행
				//StringBuilder에 저장. sql이 StringBuilder임
				//String모음 객체
//				StringBuilder sql = new StringBuilder();
//				sql.append("DELETE STUDENT WHERE ID = ?");
				
				String sql = "DELETE STUDENT WHERE ID = ?";
				
				
				//sql문장을 StringBuilder타입의 sql에 저장 후
				//prepareStatement로 문자열 반환하는 명령을 pstmt변수에 저장
				pstmt = conn.prepareStatement(sql);
				//물음표가 붙으니 값 셋팅작업을 해줘야함
				pstmt.setString(1, id);
				
				count = pstmt.executeUpdate(); //최종실행
				
			} catch (SQLException e) {
				System.out.println("[예외발생] " + e.getMessage());
			} finally {
				close(conn, pstmt);
			}
		return count;
		}
		
		
		//- UPDATE : 이름(name) 받아서 수정 - updateName : int
		//- UPDATE : 국어점수(kor) 수정 - updateKor : int
		//- UPDATE : 총점, 평균 계산처리 - updateTotAvg : int
		//DELETE : VO 객체를 받아서 삭제 - delete : int
	
		


		}




