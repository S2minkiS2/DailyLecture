<%@page import="com.mystudy.PersonVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL forEach</title>
</head>
<body>
	<h1>JSTL forEach : Array, List, Set, Map</h1>
	
	<%-- ============== Array 출력 ================= --%>
	<h2>Array 출력 ==========================</h2>
	<p>출력대상 : {"꿔", "꿔바", "꿔바로", "꿔바로우"} </p>
<%
	String[] strs = {"꿔", "꿔바", "꿔바로", "꿔바로우"}; //로컬변수에 저장
	pageContext.setAttribute("arr", strs); //스코프에 저장
%>
	<p>배열데이터 : <%=strs %></p>
	<p>배열데이터 : <%=Arrays.toString(strs)%></p>
	<hr>
	
	<c:forEach var="str" items="${arr }">
		<p>${str }</p>
	</c:forEach>
	<hr>
	
	<h3>배열(Array) 일부 데이터만 사용(2, 3번째 : 1,2번 인덱스)</h3>
	<h3>forEach var="str" items="\${arr }" begin="1" end="2"</h3>
	<ul>
		<c:forEach var="str" items="${arr }" begin="1" end="2">
			<li>${str }</li>
		</c:forEach>
	</ul>
	<hr><hr>
	
	<%-- ============== List 출력 (순서 O)================= --%>
	<h2>List 출력 ============</h2>
<%
	List<Integer> list = new ArrayList<Integer>();
	list.add(123);
	list.add(45);
	list.add(678);
	list.add(90);
	
	//스코프에 저장
	pageContext.setAttribute("alist", list);
%>
	<ul>
	<c:forEach var="listItem" items="${alist }">
		<li>${listItem }</li>
	</c:forEach>
	</ul>	
	<hr><hr>
	
	<%-- ============== Set 출력 (순서개념 x, 같은 값은 하나만 저장) ================= --%>
	<h2>Set 사용 ==============</h2>
<%
	Set<String> set = new HashSet<>();

	set.add("디지몬");
	set.add("아구몬");
	set.add("엔젤몬");
	set.add("데빌몬");
	set.add("데빌몬");
	System.out.println("set: " + set);
	System.out.println("set.size(): " + set.size());
	System.out.println("set.contains(\"엔젤몬\"): " + set.contains("엔젤몬"));
	
	pageContext.setAttribute("hset", set);
%>	
	<p>hset : ${hset }</p>
	<p>hset.size() : ${hset.size() }</p>
	<p>hset.contains("엔젤몬") : ${hset.contains("엔젤몬") }</p>
	<p>hset.toString : ${hset.toString() }</p>
	
	<ul>
	<c:forEach var="name" items="${hset }"> <%--혹은 items="<%=set%>" --%>
		<li>${name }</li>
	</c:forEach>
	</ul>
	
	<ol>
	<c:forEach var="name" items="${hset }" begin="1" end="2"> <%--혹은 items="<%=set%>" --%>
		<li>${name }</li>
	</c:forEach>
	</ol>
	
	<%-- ============== Map key-value 데이터 출력 (순서 x) ================= --%>
	<h2>Map 사용 ==============</h2>
<%
	Map<String, String> map = new HashMap(){};
	map.put("key1", "value1a");
	map.put("key4", "value4d");
	map.put("key3", "value3c");
	map.put("key2", "value2bfirst"); //무시됨
	map.put("key2", "value2bsecond");
	System.out.println(map);
	
	pageContext.setAttribute("hmap", map);
%>
	<p> --- Map 특정 데이터를 key 값으로 조회하기 ---</p>
	\${hmap.key2 } : ${hmap.key2 } <br>
	\${hmap.key4 } : ${hmap.key4 } <br>
	\${hmap["key4"] } : ${hmap["key4"] } <br> 
	\${hmap['key4'] } : ${hmap['key4'] } <br>
	
	<p>============= Map 전체 데이터 조회 =============== </p>
	<c:forEach var="mapData" items="${hmap }">
		<p>
		\${mapData } : ${mapData }<br>
		\${mapData.key } : ${mapData.key }<br>
		\${mapData.value } : ${mapData.value }
		</p>
	</c:forEach>
	
	<p>----------------------------------------------</p>
	<p>hmap.keySet() 사용 key값 확인</p>
	<c:forEach var="key" items="${hmap.keySet() }">
		<p>${key }</p>
	</c:forEach>
	
	
	<%-- ============== VO담긴 List 출력 ================= --%>
	<h1>VO가 담긴 List 사용========</h1>
<%
	List<PersonVO> listBean = new ArrayList<>();
	listBean.add(new PersonVO("피카츄", "333"));
	listBean.add(new PersonVO("라이츄", "444"));
	listBean.add(new PersonVO("파이리", "555"));
	listBean.add(new PersonVO("꼬부기", "666"));
	// listBean이라는 List타입의 객체에 PersonVO 생성 객체들이 담겨있다. 
	
	System.out.println("listBean : " + listBean);
	
	pageContext.setAttribute("persons", listBean); //EL에서 쓰기위해 scope에 저장
%>	

	<%--(실습) persons에 있는 PersonVO 객체의 이름, 나이 화면 출력 --%>
	\${persons } : ${persons }<br>
	\${empty persons } : ${empty persons }<br>
	<c:if  test="${empty persons }">
		데이터가 없습니다. \${empty persons } : ${empty persons }
	</c:if>
	
	<p>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
	<c:forEach var="person" items="${persons }">
		<p>객체 : ${voList }</p>
		<ul>
			<li>이름 : ${person.getName() }</li>
			<li>이름 : ${person.name }</li>
			<li>나이 : ${person.getAge() }</li>
			<li>나이 : ${person.age }</li>
		</ul>
		<p>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
	</c:forEach>
	
	
	
</body>
</html>