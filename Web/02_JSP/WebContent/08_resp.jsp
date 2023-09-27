<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 주문한 내역에 따라서 계산하고 결과를 표시 --%>
<%
	// 주문한 내역에 따라 계산하고 결과를 표시
	// 1. 파라미터 값 추출(확인)
	
	String coffee = request.getParameter("coffee");
	String name;
	int price = 0;
	if (coffee.equalsIgnoreCase("1")){
		name = "아메리카노";
		price = 4500;
	} else if(coffee.equalsIgnoreCase("2")) {
		name = "카페라떼";
		price = 5000;
	} else if(coffee.equalsIgnoreCase("3")) {
		name = "과일쥬스";
		price = 5600;
	} else if(coffee.equalsIgnoreCase("4")) {
		name = "케모마일티";
		price = 4300;
	}
	int orderNum = Integer.parseInt(request.getParameter("su"));
	
	int insertMoney = Integer.parseInt(request.getParameter("money"));

	/* response.sendRedirect 활용하는 방법.
	
	if (coffee == null) {
		System.out.println(">>> 메뉴선택안됨 coffee : " + coffee);
		response.sendRedirect("08_req_coffee.jsp");
		return;
	}
	*/

	// 2. 계산처리 : 구입 금액, 잔액
	
	// 3. 결과 표시
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문결과</title>
<script>

</script>
</head>
<body>
	<h2>주문 계산 결과(응답-08_resp.jsp)</h2>
<%--
	커피종류 : 아메리카노
	단가 : 4500원
	수량 : n개
	구입금액 : 9000원 (단가*수량)
	------------------------
	입금액 : 10000원
	잔액 : 1000원 (입금액 - 구입금액)

 --%>
 <ul>
 	<li>커피종류 :  <%=coffee %></li>
 	<li>단가 :  <%=price %></li>
 	<li>수량 :  <%=orderNum %></li>
 	<li>구입금액 :  <% out.println( price*orderNum ); %></li>
 	<li>---------------------------</li>
 	<li>입금액 :  <%=insertMoney %></li>
 	<li>잔액 :  <% out.println( insertMoney - (price*orderNum) ); %></li>
 </ul>
 
	
</body>
</html>