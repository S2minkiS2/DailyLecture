<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청</title>
</head>
<body>
	<h1>요청(10_req.jsp)</h1>
	<form>
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type= "text" name="pwd"><br>
		
		<input type="button" value="포워딩(forward)" onclick="send_forward(this.form)">
	</form>
	
<script>
	function send_forward(frm) {
		//alert(">> send_forward(frm) 실행 frm객체 : " + frm);
		frm.action = "10_resp_forward.jsp"; //버튼을 누르면 메서드가 실행되서, action값이 설정되고
		frm.submit(); //submit메서드로 데이터를 넘기게 된다.
	}
</script>
</body>
</html>