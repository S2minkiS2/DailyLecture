<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--전달받은 데이터를 <h2>태그에 작성해서 응답처리 --%>
<%
	request.setCharacterEncoding("UTF8"); //응답 받는 곳은 이미 깨진 데이터(한글)을 받는 상황.
	// 그래서 이곳에 적는건 의미가 없다.
	
	//파라미터 값 추출
	String name = request.getParameter("name"); 
	String age = request.getParameter("age");
	
%>

	<h2>이름 = <%=name %></h2>
	<h2>나이 = <%=age %></h2>
<!-- 불필요한 요소는 다 삭제 -->