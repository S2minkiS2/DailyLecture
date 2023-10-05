<%@page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--(실습) 전달받은 데이터를 DB에 입력처리 
	정상입력 : list.jsp 페이지로 이동(입력건수 0보다 크면 list.jsp 재요청처리)
	예외발생 : 현재페이지에 오류메시지 보여주기
--%>
<%
	//1. 파라미터 값 추출(sabun, name, pay)
	int sabun = Integer.parseInt(request.getParameter("sabun"));
	String name = request.getParameter("name");
	int pay = Integer.parseInt(request.getParameter("pay"));
	
	//2. DB 입력작업 
	final String DRIVER = "oracle.jdbc.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "mystudy";
	final String PASSWORD = "mystudypw";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	int result = 0;
	try{
		//1. JDBC 드라이버 로딩
		Class.forName(DRIVER);
		
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		/*
		선생님 코드++
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO EMPLOYEE");
		sql.append(" (SABUN, NAME, REGDATE, PAY) ");
		sql.append("VALUES (?, ?, SYSDATE, ?) ");
		*/
		String sql = "";
				sql += "INSERT INTO EMPLOYEE ";
				sql += "       (SABUN, NAME, REGDATE, PAY) ";
				sql += "VALUES (?, ?, SYSDATE, ?) ";
				
		//3. Statement 문 실행(SQL 문 실행)
		/* 
		선생님 코드++
		pstmt = conn.prepareStatement(sql.toString);
		*/
		pstmt = conn.prepareStatement(sql);
		
		//3-2. 바인드변수
			pstmt.setInt(1, sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
		
		//4. SQL 실행 결과에 대한 처리
		result = pstmt.executeUpdate();
		
		//4-2. SQL 실행결과에 대한 처리
		if (result > 0){
			response.sendRedirect("list.jsp");
		} 
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		//5. 클로징 처리에 의한 자원 반납
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch(Exception e) {}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외발생</title>
</head>
<body>
	<h1>사원 등록 실패</h1>
	<p>입력처리를 하지 못했습니다<br>
	담당자(8282)에게 연락하세요</p>
	
	<a href="addForm.jsp">입력페이지로 이동</a>
	<a href="list.jsp">전체목록 보기</a>
</body>
</html>