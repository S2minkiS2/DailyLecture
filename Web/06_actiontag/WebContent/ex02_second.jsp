<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두번째(second)</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
	<h1>[ ex02_second.jsp]</h1>
	<h2>이름 : <%=name %></h2>
	<h2>나이 : <%=age %></h2>
	<hr>
	
	
<%
	String name2 = request.getParameter("name2");
	String age2 = request.getParameter("age2");
%>	
	<h2>forward에서 추가된 파라미터 값</h2>
	<h2>이름 : <%=name2 %></h2>
	<h2>나이 : <%=age2 %></h2>
	<hr>
</body>
</html>