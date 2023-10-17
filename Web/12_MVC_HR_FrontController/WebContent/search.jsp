<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동적 검색</title>
</head>
<body>
	<h1>동적검색 [search.jsp]</h1>
	<%--post가 아니라 get방식을 쓰면 ?type=search이 무시되고 넘어간다. --%>
	<form action="controller?type=search" type="search" method="post"> 
		<select name="idx"> <%--옵션에 따라 value값이 idx값이 된다. --%>
			<option value="0">사번</option>
			<option value="1">이름</option>
			<option value="2">직종</option>
			<option value="3">부서</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="동적검색">
		<!-- <input type="hidden" name="type" value="search"> -->
	</form>
</body>
</html>