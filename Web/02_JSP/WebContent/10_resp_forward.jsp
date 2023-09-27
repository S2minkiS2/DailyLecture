<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답(10_resp_forward.jsp)</title>
</head>
<body>
	<h1>응답(10_resp_forward.jsp)</h1>
	<h2>ID = <%=id %></h2>
	<h2>PW = <%=pwd %></h2>
</body>
</html>

<% 
	//포워딩 처리(위임/전가 처리) - 최초 요청페이지에서 다른 페이지에게 전가시킨다.
	//RequestDispatcher rd = request.getRequestDispatcher("10_resp_forward-2.jsp");
	//rd.forward(request, response);
	// 대신에 -->
	request.getRequestDispatcher("10_resp_forward-2.jsp").forward(request, response);
	
%>