<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	function send_go(){
		//alert("send_go()가 실행됩니다");
		//alert("-" + document.frm.username.value + "-");
		if (document.frm.username.value.trim() == ""){ //.trim까지 하면 빈문자열 제거 처리되서 스페이스도 없앨 수 있다.
			alert("이름을 입력하세요")
			document.frm.username.value ="";
			document.frm.username.focus(); //함수호출
			return false; //함수실행 종료 (서버쪽 전송처리 안함)
		}
		
		let vForm = document.frm;
		
		if (vForm.userid.value.trim().length < 1) { //userid가 최소 1글자 이상
			alert("아이디를 입력하세요");
			vForm.userid.value = "";
			vForm.userid.focus();
			return false; //함수실행 종료
		}
		
		if (vForm.pwd.value.trim().length < 1) { //비밀번호가 최소 1글자 이상
			alert("암호를 입력하세요");
			vForm.pwd.value = "";
			vForm.pwd.focus();
			return false; //함수실행 종료
		}
		
		if (vForm.pwd2.value.trim().length < 1) { //확인 비밀번호가 최소 1글자 이상
			alert("확인 암호를 입력하세요");
			vForm.pwd2.value = "";
			vForm.pwd2.focus();
			return false; //함수실행 종료
		} 
		
		if (vForm.pwd.value != vForm.pwd2.value){
			alert("암호가 서로 다릅니다.\n 확인 후 다시 입력하세요");
			vForm.pwd.value = ""; //자동으로 지워주는 거
			vForm.pwd2.value = ""; //자동으로 지워주는 거
			vForm.pwd2.focus();
			return false;
		}
		
		console.log(vForm.gender); //2개가 선택됨.
		
		let genders = vForm.gender;
		let checked = false;
		
		for (let gender of genders){
			console.log(gender.value + " : " + gender.checked);
			if (gender.checked) {
				checked = true;
			}
		}
		
		if (!checked){
			alert("<성별> 확인이 안되었습니다. \n선택해 주세요");
			return;
		}
		
		vForm.action = "07_resp.jsp"
		vForm.submit();
	}
	
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form name="frm" id="signupForm"> 
		<fieldset>
		<legend>회원가입</legend>
		<p>이름 : <input type="text" name="username"></p>
		<p>아이디 : <input type="text" name="userid"></p>
		<p>암호 : <input type="password" name="pwd"></p>
		<p>암호확인 : <input type="password" name="pwd2"></p>
		<p>이메일 : <input type="email" name="email"></p>
		<p>성별 : 
			<input type="radio" name="gender" value="남" class="gender">남 
			<input type="radio" name="gender" value="여" class="gender">여 
		</p>
		
		<p>취미 : 
			<input type="checkbox" name="hobby" value="운동">운동
			<input type="checkbox" name="hobby" value="게임">게임
			<input type="checkbox" name="hobby" value="영화">영화
			<input type="checkbox" name="hobby" value="독서">독서
		</p>
		
		<input type="button" value="회원가입" onclick="send_go()"> 
		<input type="reset" value="초기화">
		</fieldset>
	</form>
</body>
</html>