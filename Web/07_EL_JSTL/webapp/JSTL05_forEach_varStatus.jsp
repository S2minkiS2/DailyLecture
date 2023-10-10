<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach varStatus</title>
</head>
<body>
<%
	List<String> list = new ArrayList<>();
	list.add("조유리1");
	list.add("조유리2");
	list.add("조유리3");
	list.add("조유리4");
	System.out.println("> list" + list);
	System.out.println("> list.size() : " + list.size());
	
	pageContext.setAttribute("alist", list);
%>	
	<h2>forEach List 데이터 표시</h2>	
	<c:forEach var="listData" items="${alist }">
		${listData }
	</c:forEach>
	<hr>
	
	<h2>forEach varStatus 사용</h2>
	<ol>
	<c:forEach var="listData" items="${alist }" varStatus="status"> <%-- status라는 명칭으로 쓰겠다 --%>
		<li>
			status : ${status }<br>
			데이터 : ${status.current }<br> <%--현재 처리중인 데이터 표시 --%>
			status.count : ${status.count }<br> <%--현재 처리되고 있는 데이터의 건수 --%>
			status.index : ${status.index }<br> <%--인덱스 번호 --%>
			status.first : ${status.first }<br> <%--첫번째 데이터냐 true/ false --%>
			status.last : ${status.last }<br> <%--마지막 데이터냐 true/ false --%>
			
			status.begin : ${status.begin }<br>
			status.end : ${status.end }<br>
			status.step : ${status.step }<br>
			
		</li>
	</c:forEach>
	</ol>
	<hr>
	<%--============================================================== --%>
	<ul>
	<c:forEach var="listData" items="${alist }" varStatus="status"
					begin="2" end="${alist.size() -1 }" step="1"> 
		<li>
			status : ${status }<br>
			데이터 : ${status.current }<br> <%--현재 처리중인 데이터 표시 --%>
			status.count : ${status.count }<br> <%--현재 처리되고 있는 데이터의 건수 --%>
			status.index : ${status.index }<br> <%--인덱스 번호 --%>
			status.first : ${status.first }<br> <%--첫번째 데이터냐 true/ false --%>
			status.last : ${status.last }<br> <%--마지막 데이터냐 true/ false --%>
			
			status.begin : ${status.begin }<br>
			status.end : ${status.end }<br>
			status.step : ${status.step }<br>
		</li>
	</c:forEach>
	</ul>
	
	
	
	
</body>
</html>