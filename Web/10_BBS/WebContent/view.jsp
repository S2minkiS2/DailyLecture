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
	
	//1-2. 조회수 뒤로가기 해도 반영된는 코드
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
	//2. 게시글(bbsIdx) 데이터 조회 후 화면 표시하기 위해 bvo긁어옴.
	BbsVO bvo = BbsDAO.selectOne(bbsIdx);
	System.out.println("bvo : " + bvo);
	
	//3. 게시글(bbsIdx)에 댓글 확인 후 화면 표시 
	List<CommentVO> commList = BbsDAO.getCommList(bbsIdx);
	System.out.println(commList);
	
	//4. ()위 두개의 데이터를 스코프 상에 올려놓고 화면 출력할거임
	session.setAttribute("bvo", bvo); //게시글 데이터
	session.setAttribute("cPage", cPage); //
	pageContext.setAttribute("commList", commList); //댓글목록
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<style>
	#bbs table {
		width: 500px;
		margin-left: 10px;
		border-collapse: collapse;
		font-size: 16px;
	}
	
	#bbs table caption {
		font-size: 24px;
		font-weight: bold;
		margin-bottom: 10px;
	}
	
	#bbs th {
		border: 1px solid black;
		padding: 4px 10px;
		text-align: center;
		width: 30%;
		background-color: lightsteelblue;
	}
	
	#bbs td {
		border: 1px solid black;
		padding: 4px 10px;
		text-align: left;
		width: 30%;
	}
	
	/*** 페이지 표시 영역 스타일(시작) */
	.paging {list-style: none;}
	.paging li{
		float: left;
		margin-right: 8px;
	}
	.paging li a {
		text-decoration: none;
		display: block;
		padding: 3px 7px;
		border: 1px solid #00b3dc;
		font-weight: bold;
		color: black;
	}
	.paging .disable {
		border: 1px solid silver;
		padding: 3px 7px;
		color: silver;
	}
	.paging .now {
	border: 1px solid #ff4aa5;
	padding: 3px 7px;
	background-color: #ff4aa5;
	}
	
	/*** 페이지 표시 영역 스타일(끝) ***/

</style>
<script>
	function modify_go(){
		location.href = "modify.jsp";
	}
	
	function delete_go(){
		location.href = "delete.jsp";
	}
	
	function list_go(){
		location.href = "list.jsp?cPage=${cPage}"; 
		//파라미터 값 설정해서 원래있던 페이지로 돌아가게끔. 안그러면 무조건 1로 가게됨
	}
</script>
</head>
<body>

<div id="bbs">
	<%--게시글 내용 표시 --%>
	<table style="border: 2px solid black;">
		<caption>상세보기</caption>
		<tbody>
			<tr>
				<th>제목</th>
				<td>${bvo.subject }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${bvo.writer }</td>
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
				<th>첨부파일 </th>
				<td>
					<c:if test="${empty bvo.fileName }">
						::첨부파일 없음
					</c:if>
					<c:if test="${not empty bvo.fileName }">
						<a href="download.jsp?fileName=${bvo.fileName}">${bvo.fileName }</a>
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2">${bvo.content }</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>	
				<td colspan ="2">
					<input type="button" value="수 정(개인실습)" onclick="modify_go()">
					<input type="button" value="삭 제(개인실습)" onclick="delete_go()">
					<input type="button" value="목록보기" onclick="list_go()">
				</td>
			</tr>
		</tfoot>
	</table>
</div>
<hr><hr>
	
	<%--게시글에 대한 댓글 작성 영역  --%>
	<form action="comm_write_ok.jsp" method="get">
		<p>
			작성자 : <input type="text" name="writer">
			비밀번호 : <input type="password" name="pwd">
		</p>
		<p>내용 : <textarea name="content" rows="4" cols="55"></textarea> </p>
		<input type="submit" value="댓글 저장">
		
		<input type="hidden" name="bbsIdx" value="${bvo.bbsIdx }"> 
		<!-- get방식에서 파라미터 값을 안보이게 하면서 동시에 쓰기위해서 -->
	</form>
	
	
	<%--게시글에 딸린 댓글 조회 --%>
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
			<c:forEach var="comm" items="${commList}">
				<div class="comment">
					<form action="comm_del.jsp" method="get">
						<p>작성자 : ${comm.writer } &nbsp;&nbsp; 작성일 : ${comm.writeDate}</p>
						<p>내용 : ${comm.content }</p>
						<input type="submit" value="댓글삭제">
						<input type="hidden" name="commentIdx" value="${comm.commentIdx}">
						<%--hidden: 어떤 댓글 삭제할 건지 파라미터 값으로 commentIdx 값 넘기기 위한 코드 --%>
						
						<!-- 만약 위에서 세션 스코프에 게시글데이터, 페이지번호를 저장하지 않았다면 아래처럼 코드를 추가해야함. -->
						<%-- 
						<input type="hidden" name="bbsIdx" value="${comm.bbsIdx}">
						<input type="hidden" name="cPage" value="${cPage}">
						--%>
					</form>
				</div>
				<hr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>

</div>
	
</body>
</html>