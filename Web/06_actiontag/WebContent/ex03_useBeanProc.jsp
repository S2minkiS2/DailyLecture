<%@page import="com.mystudy.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//한글 처리를 위한 설정 : POST방식 요청시 반드시 설정처리
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03_useBeanProc.jsp</title>
</head>
<body>
	<h1>[ ex03_useBeanProc.jsp ]</h1>
	<h1>스크립트릿 사용방식(로컬:지역변수)</h1>
<%
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
	
	<h2>이름 : <%=name %></h2>
	<h2>나이 : <%=age %></h2>
	<hr>
	
	<h1>액션태그 jsp:useBean 사용</h1>
<%--
<%
	//아래의 jsp:useBean 액션태그의 동작방식(설명)
	//PersonVO타입의 데이터를 가져다가 쓰는데 사용하는 명칭은 person이다. local변수는 person
	PersonVO person = (PersonVO)pageContext.getAttribute("person");
	if (person == null){ //없으면 새로 만들어라
		person = new PersonVO();
		pageContext.setAttribute("person", person); //person이라는 이름으로.
	}
	person.setName(request.getParameter("name"));
%>	
--%>

	<jsp:useBean id="person" class="com.mystudy.PersonVO" scope="page" /> 
	<!-- 페이지 scope에도 저장이 되고, 로컬변수에도 저장이 된다 -->
 	<jsp:setProperty property="*" name="person"/> 
	<!-- 데이터가 몇개이건 간단한 코드 하나로 모두 호출 가능하다. getPrameter()에 비해 편리.  -->

	
<%-- 
	<jsp:setProperty property="name" name="person"/> 
	<!-- name="person" -> jsp:useBean의 id="person" 가져다 쓴다는 의미 -->
	
	<jsp:setProperty property="age" name="person"/> 
--%>	

<%
	System.out.println("> 로컬 person객체 : " + person);
	System.out.println("> page person객체 : " + pageContext.getAttribute("person"));
%>	
	<h2>빈(Bean) 저장값 표시</h2> <!-- 로컬변수 person VO의 속성값 뽑아오기 방법 -->
	<h2>이름(표현식) : <%=person.getName() %></h2>
	<h2>나이(표현식) : <%=person.getAge() %></h2>
	<hr>
	
	<p>아래 방법은 쓰이지 않는다.</p>
	<h2>데이터 읽기 : getProperty 액션태그</h2>
	<h2>이름(액션태그 읽기) : <jsp:getProperty property="name" name="person"/> </h2>
	<h2>나이(액션태그 읽기) : <jsp:getProperty property="age" name="person"/> </h2>
	<hr><hr>
	
	<p>간단한방법</p>
	<h2>EL getter 사용 데이터 출력 (scope상에 데이터가 있어야 사용 가능)</h2>
	<h2>이름(EL) : ${person.getName() }</h2>
	<h2>나이(EL) : ${person.getAge() }</h2>
	<hr>
	<p>더더더 간단한방법</p>
	<h2>이름(EL) : ${person.name }</h2>
	<h2>나이(EL) : ${person.age }</h2>
	
</body>
</html>