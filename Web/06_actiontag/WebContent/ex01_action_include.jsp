<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("request.getCharacterEncoding() : " + request.getCharacterEncoding()); //null
	//한글 패치를 위한 설정
	request.setCharacterEncoding("UTF8"); 
	//이제 파라미터 값 value의 한글 데이터가 인코딩되어 정상적으로 전달된다.
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 include</title>
</head>
<body>
<%-- JSP 액션태그 : JSP 페이지 흐름제어, 데이터 처리
	사용형태 : <jsp:액션명령> </jsp:액션명령> 또는 <jsp:액션명령 /> 
 --%>
 	<h1>디렉티브/액션태그 - include</h1>
 	<hr>
 	<h2>디렉티브(지시어) - include : 복사 & 붙여넣기(정적) = 마치 종이를 오려서 붙인 것 같은</h2>
 	<h3>지시어 include(정적처리) : 포함시킬 내용을 삽입 후 컴파일 처리</h3>
 	<%@ include file="ex01_includee.jsp" %>
 	<p>-------------------------------</p>
 	<%@ include file="ex01_includee2.jspf" %>
 	<hr><hr>
 	
 	
 	<h2>액션태그 - jsp:include 사용시엔 *.jsp를 사용할 것 (jspf는 전체 정보가 출력됨)</h2>
 	<jsp:include page="ex01_includee.jsp"></jsp:include>
 	<p>-------------------------------</p>
 	<jsp:include page="ex01_includee2.jspf" /> <!-- 그럼 jspf는 언제 쓰는 거야?? -->
 	<hr><hr>
 	
 	<%--==============================--%>
 	<h2>액션태그 - jsp:include(파라미터 값 전달)</h2>
 	<h3>액션 include : 실행시 요청 결과를 받아 포함시킴(삽입,추가)</h3>
 	<h3>[주의]액션 include 사용시 request에 UTF-8 설정처리(한글깨짐 방지 처리) </h3>
 	<jsp:include page="ex01_includee3_param.jsp">
 		<jsp:param value="막시무스" name="name"/>
 		<jsp:param value="33" name="age"/>
 		<jsp:param value="" name=""/>
 	</jsp:include>
 	<!--액션태그 jps:include 는 동적인 페이지입니다. (중요!!)
 		현재 태그는 jsp를 불러오는데 액션태그 사이에 홈페이지에 파라미터 값을 보내고 있습니다.
 		param.jsp는 스크립트릿에서 파라미터값을 받아서 코드를 처리하고 있습니다.
 		처리를 마친 param.jsp 페이지를 호출하여 출력합니다. 
 		-->
 	
 	<hr><hr>
 	<%@ include file="ex01_includee3_param.jsp" %>
 	<!-- 디렉티브 include는 정적인 페이지 (차이점!!)
 		파라미터 값이 없기에, 페이지 그대로 값이 null 처리되어 출력된다. -->
 	
 	
 	
</body>
</html>