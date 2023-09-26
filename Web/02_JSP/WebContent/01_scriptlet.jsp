<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //자바코드를 쓸 수있다.
	int a = 100;
	int b = 200;
	System.out.println(">> 자바창에 쓴 것은 콘솔창에 출력된다");
	System.out.println("a + b : " + (a+b));
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 스크립트릿(scriptlet)</title>
</head>
<body>
	<h1>JSP 스크립트릿(scriptlet)</h1>
	<h3>자바코드를 작성하는 용도로 사용</h3>
	<hr>
	
	<h3>JSP에서 제공하는 내장객체 out 객체</h3>
<%
	out.println("<hr>"); //JSP에 이미 선언되어 있기에 따로 변수선언 하지 않아도 사용 가능.
	out.println("<p>JSP에서 제공하는 out 객체로 출력하는 내용</p>");
	out.print("<h2> a + b : " + (a+b) + "</h2>");
%>
</body>
</html>