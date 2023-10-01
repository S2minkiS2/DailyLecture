<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 세션 초기화(무효화) --%>
<%
	//세션 초기화(무효화)
	session.invalidate();

	//재요청 처리
	response.sendRedirect("ex01_session.jsp"); //sendRedirect를 해야 초기화면 유지 가능(귀찮아지잖아)
	
	
%>