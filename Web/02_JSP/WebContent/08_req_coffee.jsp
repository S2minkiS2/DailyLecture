<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피주문</title>
<script>
	function send_go(){
		alert("send_go()가 실행됩니다");
		
		let vForm = document.frm;
		let coffees = vForm.coffee;
		
		let selectedCoffee = null;
		
		for (let i = 0; i < coffees.length; i++) {
		    if (coffees[i].checked) {
		        selectedCoffee = coffees[i].value;
		        break;
		    }
		}

		if (selectedCoffee == null) {
		    alert("음료를 선택해 주세요");
		    vForm.coffee[0].focus(); // 라디오 버튼 그룹의 첫 번째 버튼에 포커스 설정
		    return false;
		}
		
		if (vForm.su.value < 1 || isNaN(vForm.su.value)){
			alert("정상적인 수량을 입력해 주세요");
			return false;
		}
		
		if (isNaN(vForm.money.value)||vForm.money.value <= 0){
			alert("정상적인 입금액을 입력해 주세요");
			return false;
		}
		
		alert(vForm.money.value);
		let insertMoney =  parseInt(vForm.money.value);
		
		alert(selectedCoffee);
		
		
		
		if (insertMoney <= (selectedCoffee*vForm.su.value) ) {
			alert("입금액이 부족합니다.");
			return false;
		}
		
		vForm.submit(); 
	}
</script>
</head>
<body>
	<h1>커피주문(요청-08_req_coffee.jsp)</h1>
	<form name="frm" action="08_resp.jsp">
		<input type="radio" name="coffee" value="1">아메리카노(4500원)<br>
		<input type="radio" name="coffee" value="2">카페라떼(5000원)<br>
		<input type="radio" name="coffee" value="3">과일쥬스(5600원)<br>
		<input type="radio" name="coffee" value="4">케모마일티(4300원)<br>
		<hr>
		수량 : <input type="number" name="su" value="1"><br>
		입금액 : <input type="number" name="money" value="0"><br>
		
		<input type="button" value="주문처리" onclick="send_go()">
	</form>

</body>
</html>