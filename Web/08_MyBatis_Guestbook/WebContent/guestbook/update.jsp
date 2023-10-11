<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 VO 데이터를 화면에 표시하고 수정데이터 작성 --%>
<%
	//0. 전달받은 VO데이터 확인
	System.out.println("update.jsp session guestbookVO : " +
						session.getAttribute("guestbookVO"));
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 수정</title>
<link rel="stylesheet" type="text/css" href="../css/guestbook.css">
<script>
	function save_go(frm){
		// alert('save_go(frm) 실행 ' + frm);
		//비밀번호 확인 후 일치하면 수정 요청 처리
		let pwdNew = frm.pwd.value; // 지금 입력한 암호
		let pwdOld = "${guestbookVO.pwd}"; // DB에 저장된 암호(소스코드에 노출됨: 하지마)
		//alert("pwdNew : " + pwdNew + ", pwdOld : " + pwdOld);
		
		if (pwdNew !== pwdOld) {
			alert("암호 불일치. 자바스크립트는 소스가 다 노출되니 민감한 정보는 적지 마요.네즈");
			frm.pwd.value = "";
			frm.pwd.focus();
			return false;
		} else {
			// frm.action = "update_ok.jsp";  이미 적혀있으니 주석처리
			frm.submit();
		}
		
	}


</script>
</head>
<body>
	guestbookVO : ${guestbookVO }
	<h1>방명록 수정 [update.jsp]</h1>
	
	<div id="container">
	<h2>방명록 : 입력화면</h2>
	<hr>
	<p><a href="list.jsp">[목록으로 이동]</a></p>
	
	<form action="update_ok.jsp" method="get" id="formId">
	<table>
		<tbody>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" value="${guestbookVO.name }" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="${guestbookVO.subject }"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="${guestbookVO.email }"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="pwd" ></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="content" rows="5" cols="60" >"${guestbookVO.content }"</textarea>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" value="수 정" onclick="save_go(this.form)">
					<input type="reset" value="취 소">
					<input type="hidden" name="idx" value="${guestbookVO.idx }">
					<!-- 눈에 보이지 않게 파라미터 값으로 넘기기 위해서(get일 때) type을 hidden으로-->
				</td>
			</tr>
		</tfoot>
	</table>
	</form>
</div>
</body>
</html>