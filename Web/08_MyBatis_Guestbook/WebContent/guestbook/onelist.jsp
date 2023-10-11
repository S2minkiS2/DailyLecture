<%@page import="javax.websocket.Session"%>
<%@page import="com.mystudy.mybatis.GuestbookVO"%>
<%@page import="com.mystudy.mybatis.DBService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터(idx)로 DB데이터 조회 후 화면 출력 --%>
<%
	//1. 전달받은 데이터 확인하기
	int idx = Integer.parseInt(request.getParameter("idx"));

	//2. DB연동작업 - idx 값으로 DB데이터 가져오기(select)
	//2-1. SqlSession 객체 생성
	SqlSession ss = DBService.getFactory().openSession();
	
	//2-2. SqlSession 객체 사용 - DB SELECT 작업(idx값 사용)
	GuestbookVO vo = ss.selectOne("guestbook.one", idx); //namespace.id 형태 , 파라미터값
	// 아이디 값으로 
	ss.close();
	
	System.out.println("vo : " + vo);
	
	//3. DB데이터를 브라우저 화면에 표시(html 만들기)
	//3-1. JSTL, EL 사용을 위해 스코프 상에 등록(session에 저장 - 수정, 삭제에서 사용하기 위함)
	//pageContext.setAttribute("guestbookVO", vo);
	session.setAttribute("guestbookVO", vo);
	
	
	//3-2. 화면에 표시 - HTML 태그에 JSTL, EL 사용해서 작성
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 화면 보기</title>

<script>
	function update_go(){
		location.href="update.jsp";	//수정 작업 페이지
		
		// 비밀글 처리 기능 필요시 추가
	}
	
	function delete_go(){
		location.href="delete.jsp";	//삭제 작업 페이지
		
		// 삭제시 비밀번호 확인 과정 필요.
	}

</script>
<style>
	#container {
		width: 512px; margin: auto;
		/* border: 1px solid blue;  */
	}
	#container h2 { text-align: center; }
	#container p { text-align: center; }
	#container table {
		width: 100%;
		border-collapse: collapse; 
	}
	#container th { background-color: #9cf; }
	#container th, #container td {
		border: 1px solid black; height: 1.5em; 
	}
	.center { text-align: center; }
</style>
</head>
<body>
	<div id="container">
		<h2>방명록 : 상세보기</h2>
		<hr>
		<p><a href="list.jsp">[목록으로 이동]</a></p>
		
		<table>
			<tbody>
				<tr>
					<th>작성자</th>
					<td>${guestbookVO.name }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${guestbookVO.subject }</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${guestbookVO.email }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${guestbookVO.content }</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" class="update">
						<input type="button" value="수 정" onclick="update_go()">
						<input type="button" value="삭 제" onclick="delete_go()">					</td>
				</tr>
			</tfoot>
		</table>
		
	</div>
</body>
</html>