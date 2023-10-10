<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<%--JSTL(JSP Standard Tag Labrary)
	0. 라이브러리 구하기(인터넷)
		다운로드 : https://tomcat.apache.org/download-taglibs.cgi
		다운로드 : https://mvnrepository.com/ > jstl 검색
	1. 라이브러리 등록
		WebContent > WEB-INF > lib > jar 파일 등록
	2. JSTL 디렉티브(지시어) taglib 추가
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 --%>	
 
 	<h2>JSTL 사용</h2>
 	<h3>속성(변수) 설정 : set</h3>
 	<c:set var="test" value="Hello JSTL!! - pageScope에 저장된 데이터" scope="page" />
 	<c:set var="test" value="Hello JSTL!! - request에 저장된 데이터" scope="request" />
 	<c:set var="test" value="Hello JSTL!! - session에 저장된 데이터" scope="session" />
<%
	// System.out.println("test : " + test); //컴파일 오류 why? page에 저장되어있기 때문, local변수아님.
	System.out.println("test : " + pageContext.getAttribute("test"));
	out.println(pageContext.getAttribute("test"));

%>
	<hr>
	<h3>속성값 출력 : out</h3>
	참고: out은 잘 안쓰인다. EL 쓰면 되니까.
	<p><c:out value="Hello World~~" /></p>
	<p>page test(c:out) : <c:out value="${pageScope.test }" /></p>
	<p>page test(EL) : ${pageScope.test }</p>
	<p>session test(EL) : ${sessionScope.test }</p>
	
	<p>application test(EL) : ${applicationScope.test }</p>
	<p>application test(c:out) :
		<c:out value="${applicationScope.test }" default="데이터없음!!" />
	</p>
	<hr>
	
	<h3>삭제 : remove</h3>
	<c:remove var="test" scope="page" /> //page에 있던 자료들 삭제
	
	<p>EL(scope 지정 안함) test : ${test}</p>
	<p>page test(EL) : ${pageScope.test}</p>
	<p>request test(EL) : ${requestScope.test}</p>
	<p>session test(EL) : ${sessionScope.test}</p>
	<p>application test(EL) : ${applicationScope.test}</p>
	<hr><hr>
	
	<%-- ====== if문 (else 없다.)======= --%>
	<h2>JSTL 에는 if 태그만 있다. else 태그는 없다</h2>
	<h2>JSTL : if 태그 test 속성</h2>
	<c:if test="${10 > 20 }">
		<p>test 10 > 20 결과 true인 경우 실행되는 문장 (false이면 실행 안됨) </p>
	</c:if>
	<c:if test="${10 <= 20 }">
		<p>test 10 <= 20 결과 true인 경우 실행 문장</p>
	</c:if>
	<hr>
	
	<h3>JSTL : if 태그2</h3>
	<c:set var="n1" value="5" /> <%-- 주의! 문자열 처리됨. 그래서 "5"가 "10"보다 큼 --%>
	<c:set var="n2" value="10" /> <%-- 해결 : Integer.parseInt로 비교하면 된다. --%>
	
	<c:if test="${n1 > n2 }" var="result1">
		<p>if문 결과 ${n1}이 ${n2}보다 큽니다</p>
	</c:if>
	<p>::: 비교결과1 result1 : ${result1 } </p>
	<hr>
	<c:if test="${Integer.parseInt(n1) <= Integer.parseInt(n2) }" var="result2">
		<p>if문 결과 ${n1 }이 ${n2 } 보다 작거나 같습니다</p>
	</c:if>
	<p>:::: 비교결과1 result2 : ${result2 }</p>
	<hr>
	
	<%-- ======= choose ~ when ~ otherwise ======= --%>
	<h2>JSTL : choose ~ when ~ otherwise </h2>
	<p>자바코드의 if ~ else if ~ else if ~ else 처럼 동작</p>
	<c:set var="score" value="55" />
	<c:choose>
		<c:when test="${score >= 90 }">
			<p>판정결과(${score }) : A</p>
		</c:when>
		<c:when test="${score >= 80 }">
			<p>판정결과(${score }) : B</p>
		</c:when>
		<c:when test="${score >= 70 }">
			<p>판정결과(${score }) : C</p>
		</c:when>
		<c:otherwise>
			<p>판정결과(${score }) : D</p>
		</c:otherwise>
	</c:choose>
 	<hr><hr>
 	
 	<%-- ======== JSTL 반복문 c:forEach ========== --%>
	<h2>JSTL 반복문 c:forEach</h2>
	
	<p>1~10 까지의 숫자 출력</p>
	<c:forEach var="i" begin="1" end="10" step="1">
		${i} &nbsp;
	</c:forEach>
	<p>forEach 문 종료 후 \${i} 값 출력 : -${i}- (->for문 내에서만 호출 가능)</p>
	<hr>
	
	<p>1~10 까지의 숫자 중 짝수만 출력 (step="2") 사용</p>
	<c:forEach var="i" begin="2" end="10" step="2">
		${i} 
	</c:forEach>
	<hr>
	
	<p>1~10 까지의 숫자 중 짝수만 출력 (step="1") 사용</p>
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:if test="${ i % 2 == 0 }">
			${i }
		</c:if>
	</c:forEach>
	<hr>
	
	<p>1~10 까지의 합계 구하기(page)</p>
	<c:set var="sum" value="0" scope="page" />
	<c:forEach var="i" begin="1" end="10" step="1" >
		<c:set var="sum" value="${sum+i }" /> <%--연산처리만 --%>
		 <%-- ${sessionScope.sum = Integer.parseInt(sum) + Integer.parseInt(i)} 더 안좋은 코드 --%>
		 <%-- ${sum = sum + i } --%> <%-- 연산과정을 화면에 출력 --%>
		 <%-- ${sum += 1} 은 문자열 붙이기 처리가 된다. (01 02 03 이렇게)--%>
	</c:forEach>
	<h3>sum : ${sum}</h3>
	<hr>
	
	<%-- =========== for문 집합객체 처리 =========== --%>
	
<%
	//로컬변수 이용한 출력 (향상된 for문)
	String[] arr = {"홍길동0", "홍길동1", "홍길동2", "홍길동3", "홍길동4"};
	for (String name : arr){
		out.println(name + " - ");
	}
	
	//JSTL, EL에서 사용하려면 위처럼 로컬변수에 저장하면 쓸 수 없기에, scope에 저장하자. (예로 page) 
	//pageContext.setAttribute("attr_names", arr); 혹은
	request.setAttribute("attr_names", arr);
%>
	<h2>forEach문 집합객체 처리</h2>	
	<h3>배열값 출력 - JSTL forEach</h3>
	<ol>
		<c:forEach var="name" items="${attr_names}"> <%--스코프 변수 이용한 코드 --%>
		<%--혹은 items="<%=name%>"  --%> <%--로컬변수 이용한 코드 --%>
			<li>${name}</li>
		</c:forEach>
	</ol>
	<hr><hr>
	
	<%-- ==== forTokens ====== --%>
	<h2>forTokens 태그 : 문자열 자르기</h2>
	<c:set var="names" value="짬뽕,볶음밥/콜라,싸이다/피자,치킨" />
	<p>문자열데이터 : ${names }</p>
	
	<h3>forTokens 태그사용 / 구분자로 문자열 자르기</h3>
	<c:forTokens var="name" items="${names} " delims=",">
		<p>${name }</p>
	</c:forTokens>
	<hr>
	
	<h3>forTokens 태그사용 / 구분자로 문자열 자르기</h3>
	<c:forTokens var="name" items="${names} " delims="/,">
		<p>${name }</p>
	</c:forTokens>
	
	
</body>
</html>