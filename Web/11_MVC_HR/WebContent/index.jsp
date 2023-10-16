<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작업선택</title>
<script>
	function all_search(){
		// location.href="list.jsp"     -- 고전방식
		location.href="list"; //jsp를 붙이지 않는다. 어노테이션 사용한 곳으로 ㄱㄱ
	}
	
	function dept_search(){
		location.href="dept"; //jsp를 붙이지 않는다. 어노테이션 사용한 곳으로 ㄱㄱ
	}
	
</script>
</head>
<body>
	<h1>작업 선택 [index.jsp]</h1>
	<button onclick="all_search()">전체보기(list)</button>
	<button onclick="dept_search()">부서코드로 검색(dept)</button>
</body>
</html>