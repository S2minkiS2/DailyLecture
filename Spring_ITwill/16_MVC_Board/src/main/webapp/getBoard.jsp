<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<style>
	#container { width: 700px; margin: auto; }
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: orange; }
	.center { text-align: center; }
	
	.border-none, .border-none td { border: none; }
</style>
</head>
<body>
\${board } : ${board }
<div id="container">
	<h1>글상세 [getBoard.jsp]</h1>
	<p><a href="logout.do">로그아웃</a></p>
	
	<form action="updateBoard.do" method="post">
	<input type="hidden" name="seq" value="${board.seq}"><!-- 글번호를 넘겨야 where조건으로 넣어서 데이터를 수정할수 있는거죠 -->
		<table>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" value="${board.title }">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="writer" value="${board.writer }">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" rows="10" cols="40">${board.content }</textarea>
				</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.regdate }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.cnt }</td>
			</tr>
			<tr>
				<td colspan="2" class="center">
					<input type="submit" value="글수정">
				</td>	
			</tr>
		</table>
	</form>
	<p>
		<a href="insertBoard.jsp">글등록</a>
		<a href="deleteBoard.do?seq=${board.seq}">삭제</a> <!-- 페이지 이동이아니라 데이터 처리 요청이라서 .do / seq넘겨서 삭제해야 하므로-->
		<a href="getBoardList.do">글목록</a> <!-- 데이터 다시 조회해야 하므로. 누군가 글을 동시에 적었을 테니까. -->
	</p>
</div>

</body>
</html>