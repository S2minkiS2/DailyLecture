<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 검색 목록 결과</title>
</head>
<body>
	<h1>직원 목록- 성명검색결과 [ fullnameList.jsp ]</h1>
	<h3>사번, 성명, 직종, 부서코드</h3>
	<ul>
	<%--DeptListCommand.java에서 list를 스코프에 저장하였기에 EL로 사용가능. --%>
	<c:forEach var="vo" items="${list }"> 
		<li>
			${vo.employeeId }, ${vo.firstName }, ${vo.lastName }, ${vo.jobId }, ${vo.departmentId }
		</li>
	</c:forEach>
	</ul>
</body>
</html>