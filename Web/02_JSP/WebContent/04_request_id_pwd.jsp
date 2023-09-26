<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청페이지</title>
</head>
<body>
	<h2>(요청)아이디와 패스워드 값을 서버측으로 전달</h2>
	<form action="04_resp_id_pwd.jsp" method="post">
		<h3>아이디 : <input type="text" name="id" value="shin"></h3>
		<h3>패스워드 : <input type="password" name="pwd" value="0000"></h3>
		<input type="submit" value="서버로 전송">
	</form>
</body>
</html>