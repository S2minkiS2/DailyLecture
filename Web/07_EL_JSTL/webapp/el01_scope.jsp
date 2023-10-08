<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<body>
	<%-- EL(Expression Language) : 표현언어 --%>
	<h2>표현식(Expression) 산술연산 결과</h2>
	<ul>
		<li>15 + 7 = <%=15+7 %></li>
		<li>15 - 7 = <%=15-7 %></li>
		<li>15 * 7 = <%=15*7 %></li>
		<li>15 / 7 = <%=15/7 %></li>
		<li>15 % 7 = <%=15%7 %></li>
	</ul>
	<hr>
	
	<h2>EL(Expression Language) 산술연산 결과</h2>
	<ul>
		<li>15 + 7 = ${15 + 7 }</li>
		<li>15 - 7 = ${15 - 7 }</li>
		<li>15 * 7 = ${15 * 7 }</li>
		<li>15 / 7 = ${15 / 7 }</li>
		<li>15 % 7 = ${15 % 7 }</li>
	</ul>
	<hr><hr>
	
	<h2>선언부, 스크립트릿 변수 사용시</h2>
	<P>표현식은 사용 가능하지만, EL에서는 사용 못함</P>
	<%! int globalNum = 10;%>
	<% int localNum = 20; %>
	<ul>
		<li>표현식 globalNum : <%=globalNum %></li>
		<li>표현식 localNum : <%=localNum %></li>
	</ul>
	<ol>
		<li>EL globalNum : -${globalNum }-</li>
		<li>EL localNum : -${localNum }-</li>
	</ol>
	<hr><hr>
	
	<h2>EL에서 사용하려면 스코프(scope)에 속성 정의 후 사용 </h2>
	<%pageContext.setAttribute("p_globalNum", globalNum); %> <!-- globalNum을 페이지에 저장함 -->
	<%pageContext.setAttribute("p_localNum", localNum); %>
	<ol>
		<li>EL globalNum : -${p_globalNum }-</li>
		<li>EL localNum : -${p_localNum }-</li>
	</ol>
	<hr><hr>
	
	<%-- =========================================== --%>
	<h2>동일한 이름의 속성명이 여러 스코프에 존재할 때</h2>
<%
	pageContext.setAttribute("pc", "pageScope-컴퓨터");
	request.setAttribute("pc", "requestScope-컴퓨터2");
	session.setAttribute("pc", "sessionScope-컴퓨터3");
	application.setAttribute("pc", "applicationScope-컴퓨터4");
%>
	<h3>scope 지정없이 데이터 사용</h3>
	<ul>
		<li>scope 지정없이 pc : ${pc} } </li> <!-- 가장 가까운 page에서부터 찾는다. -->
	</ul>
	
	<h3>명시적으로 scope 지정해서 사용</h3>
	<ul>
		<li>pageScope 지정 : ${pageScope.pc }</li>
		<li>requestScope 지정 : ${requestScope.pc }</li>
		<li>sessionScope 지정 : ${sessionScope.pc }</li>
		<li>applicationScope 지정 : ${applicationScope.pc }</li>
		
	</ul>
	
	
	
</body>
</html>