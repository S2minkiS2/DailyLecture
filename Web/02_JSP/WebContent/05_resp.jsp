<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--전달받은 데이터를 사용해서 계산처리 후 결과를 테이블 형태로 작성.
    	데이터 처리: 스크립트릿 (<% %>)
    	데이터 출력: 표현식 (<%= %>) --%>
    	
<%
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor")) ;
	int eng = Integer.parseInt(request.getParameter("eng")) ;
	int math = Integer.parseInt(request.getParameter("math")) ;
	int total = kor + eng + math;
	double avg = total * 100 /3 /100.0;
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적처리결과</title>
<style>
	table {
		border: 2px solid red;
		border-collapse: collapse; 
		text-align: center;
		font-size: 1.5em;
		
	}
	th {
		background-color : azure;
		width : 100px;
	}

	
</style>
</head>
<body>
	<h2>성적처리결과(05_resp.jsp)</h2>
	<table border id="ta">
		<tr>
			<th>이름</th>
			<th><%=name%></th>
		</tr>
		<tr>
			<th>국어</th>
			<th><%=kor %></th>
		</tr>
		<tr>
			<th>영어</th>
			<th><%=eng %></th>
		</tr>
		<tr>
			<th>수학</th>
			<th><%=math %></th>
		</tr>
		<tr>
			<th>총점</th>
			<th><% out.println(kor+eng+math); %></th>
		</tr>
		<tr>
			<th>평균</th>
			<th><% out.println((kor+eng+math) * 100/3/100.0); %></th>
		</tr>
	</table>
	
</body>
</html>