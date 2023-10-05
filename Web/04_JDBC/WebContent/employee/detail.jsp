<%@page import="java.net.URLEncoder"%>
<%@page import="com.mystudy.vo.EmployeeVO"%>
<%@page import="com.mystudy.common.JdbcUtil"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--전달받은 사번(sabun) 데이터 DB 조회해서 화면에 표시 --%>
<%
	//1. 전달받은 사번(sabun) 값 확인(추출)
	int sabun = Integer.parseInt(request.getParameter("sabun"));

	//2. DB 데이터 조회
	/* final String DRIVER = "oracle.jdbc.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "mystudy";
	final String PASSWORD = "mystudypw"; */
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//DB 데이터 저장할 변수 선언
	EmployeeVO vo = null;
	
	try {
		//JDBC 드라이버 로딩
		Class.forName(JdbcUtil.DRIVER);
		
		//DB연결 - Connection 객체 생성 <- DriverManager
		//conn = DriverManager.getConnection(JdbcUtil.URL, JdbcUtil.USER, JdbcUtil.PASSWORD);
		conn = JdbcUtil.getConnection();
		
		String sql = ""; 
		sql += "SELECT SABUN, NAME, REGDATE, PAY ";
		sql += " FROM EMPLOYEE ";
		sql += " WHERE SABUN = ? ";
		
		//Statement 문 실행(SQL 문 실행)
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sabun);
		
		//SQL 실행 결과에 대한 처리
		//SQL 문 실행
		rs = pstmt.executeQuery();
		
		//SQL문 실행 결과에 대한 처리
		//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
		if (rs.next()) {
			vo = new EmployeeVO();
			vo.setSabun(rs.getInt("SABUN"));
			vo.setName(rs.getString("NAME"));
			vo.setRegdate(rs.getDate("REGDATE"));
			vo.setPay(rs.getInt("PAY"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(conn, pstmt, rs);
	}
	//3. 화면 구현
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<h1>사원 상세정보[detail.jsp]</h1>
	<table border>
		<tr>
			<th>사번</th>
			<td><%=sabun %></td>
		</tr>
		<tr>
			<th>성명</th>
			<td><%=vo.getName() %></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td><%=vo.getRegdate()%></td>
		</tr>
		<tr>
			<th>금액</th>
			<td><%=vo.getPay() %></td>
		</tr>
	</table>
	<p>
		<a href="editForm.jsp?sabun=<%=sabun%>&name=<%=vo.getName()%>&pay=<%=vo.getPay()%>">수정</a>
		<a href="delete.jsp?sabun=<%=sabun %>">삭제</a>
		<a href="list.jsp">목록보기</a>
	</p>
	<hr>
	<a href="editForm.jsp?sabun=<%=sabun%>&name=<%=URLEncoder.encode(vo.getName(), "UTF-8") %>&pay=<%=vo.getPay() %>">수정(URLEncode적용)</a>
</body>
</html>