<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF8"); 
	//이제 파라미터 값 value의 한글 데이터가 인코딩되어 정상적으로 전달된다.
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(요청시작)액션 forward </title>
</head>
<body>
	<h1>(요청시작)액션 forward 페이지</h1>
	<h2>= [ex02_action_forward.jsp]</h2>
	<form action="ex02_first.jsp" method="post">
		이름 : <input type="text" name="name" value="신raphael"><br>	
		나이 : <input type="text" name="age" value="18"><br>	
		<input type="submit" value="보내기">
	</form>
</body>
</html>