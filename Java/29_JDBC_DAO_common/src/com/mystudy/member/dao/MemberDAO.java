package com.mystudy.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mystudy.common.CommonJDBCUtil;
import com.mystudy.member.vo.MemberVO;

public class MemberDAO {
	
	//클래스마다 공통적으로 갖고있는 것이 있으면 (메서드 내에서 공통적으로 사용한 것)
	// --> 별도로 뽑아내자. : CommonUtil 클래스
//	private static final String DRIVER = "oracle.jdbc.OracleDriver";
//	  //고정시키는 final, 상수화된 변수는 대문자
//	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	private static final String USER = "mystudy";
//	private static final String PASSWORD = "mystudypw";

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs  = null;


	//   클래스명
	//전체 데이터 검색 (찾기) - selectAll() : List<MemberVO>
	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		

		
		
		try {
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = CommonJDBCUtil.getConnection(); //connection 객체 리턴
			//3. Statement 문 실행(SQL 문 실행)
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, NAME, PASSWORD, PHONE, ADDRESS");
			sb.append("  FROM MEMBER ");
			//sb.append(" ORDER BY ID ");
			sb.append(" ORDER BY NAME ");
			
			pstmt = conn.prepareStatement(sb.toString()); //nullpointexception
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<MemberVO>();
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			//   - INSERT, UPDATE, DELETE : int 값(건수) 처리
			
			while (rs.next()) {
				MemberVO vo = new MemberVO(
						rs.getString("ID"),
						rs.getString("NAME"),
						rs.getString("PASSWORD"),
						rs.getString("PHONE"),
						rs.getString("ADDRESS"));
						
					list.add(vo); 
					//vo에 담은걸 list에 담는게 결과에 대한 처리
			}
		
		} catch (Exception e) {
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			
			//CommondJDBCUtil 사용 연결, close 처리
		} CommonJDBCUtil.close(conn,pstmt,rs);
		
		return list;
		
	}
		
		

		//(실습) INSERT : VO 전달받아 데이터 입력 처리 - insert(vo) : int
		
		//2. DB연결 : CommonJDBCUtil에 있는 메서드 사용
		
		public int insert(MemberVO vo) {
			int result = 0;
		
		try {
			conn = CommonJDBCUtil.getConnection();
			
			//3. Statement 문 실행(SQL 문 실행)
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO MEMBER ");
			sb.append("		  (ID, NAME, PASSWORD, PHONE, ADDRESS) ");
			sb.append("VALUES (?, ?, ?, ?, ?) ");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			//? 값 설정
			
			int i = 1;
			//set메소드
			pstmt.setString(i++, vo.getId());
			pstmt.setString(i++, vo.getName());
			pstmt.setString(i++, vo.getPassword());
			pstmt.setString(i++, vo.getPhone());
			pstmt.setString(i++, vo.getAddress());
			
			// 실행요청 : int타입 result에 값을 저장
			result = pstmt.executeUpdate();
		
		} catch (Exception e) {
			result = -1; // (insert된 건수 들어옴)
//			e.printStackTrace();
		} finally {
//			close(conn, pstmt, result);
		}
		
		return result;
		
	}
	
	
	

}
