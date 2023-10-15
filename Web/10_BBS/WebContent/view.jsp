<%@page import="com.mystudy.bbs.vo.CommentVO"%>
<%@page import="java.util.List"%>
<%@page import="com.mystudy.bbs.vo.BbsVO"%>
<%@page import="com.mystudy.bbs.dao.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 전달받은 파라미터 값(bbsIdx) 사용 DB데이터 조회 화면표시
	1. 게시글 조회수 1 증가(실습)
	2. 게시글(bbsIdx) 데이터 조회 후 화면 표시
	3. 게시글(bbsIdx)에 딸린 댓글이 있으면 조회 후 화면 표시
--%>
<%
	//파일미터 값 추출(확인)
	int bbsIdx = Integer.parseInt(request.getParameter("bbsIdx"));
	String cPage = request.getParameter("cPage");
	
	//1. 게시글 조회수 1 증가(개인실습)
	BbsDAO.hitAdd(bbsIdx);
	
	//2. 게시글(bbsIdx) 데이터 조회 후 화면 표시하기 위해 bvo긁어옴.
	BbsVO bvo = BbsDAO.selectOne(bbsIdx);
	System.out.println("bvo : " + bvo);
	
	//3. 게시글(bbsIdx)에 댓글 확인 후 화면 표시 
	List<CommentVO> commList = BbsDAO.getCommList(bbsIdx);
	System.out.println(commList);
	
	//4. ()위 두개의 데이터를 스코프 상에 올려놓고 화면 출력할거임
	pageContext.setAttribute("bvo", bvo);
	pageContext.setAttribute("commList", commList);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<div id="container">
	<h2>방명록 : 상세보기</h2>
	<hr>
	<p><a href="list.jsp">[목록으로 이동]</a></p>
	<table style="border: 2px solid black;">
		<tbody>
			<tr>
				<th>작성자</th>
				<td>${bvo.writer }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${bvo.subject }</td>
			</tr>
			<tr>
				<th>IP</th>
				<td>${bvo.ip }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${bvo.writeDate.substring(0, 10)}</td>
			</tr>
			<tr>
				<th>조회수 </th>
				<td>${bvo.hit}</td>
			</tr>
			<tr>
				<td colspan="2">${bvo.content }</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>	
				<td colspan ="2">
					<input type="button" value="수정" onclick="update_go()">
					<input type="button" value="삭제" onclick="delete_go()">
				</td>
			</tr>
		</tfoot>
	</table>
</div>
<hr><hr>
<div id="comment">
	<table style="border: 1px solid black;">
	<c:choose>
		<c:when test="${empty commList}">
			<tr>
				<td colspan="2">
					현재 등록된 댓글이 없습니다
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="comm" items="${commList }">
				<tr>
					<td>작성번호</td>
					<td>${comm.commentIdx }</td>
				</tr>
				<tr>
					<td>작성자 </td>
					<td>${comm.writer }</td>
				</tr>
				<tr>
					<td>댓글내용 </td>
					<td>${comm.content }</td>
				</tr>
				<tr>
					<td>IP</td>
					<td>${comm.ip }</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>

</div>
	
</body>
</html>