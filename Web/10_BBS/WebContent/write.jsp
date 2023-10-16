<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script>
	function sendData(){
		alert("sendData() 시작");
		let firstForm = document.forms[0];
		alert("form에 있는 요소들(input, textarea 등) 몇개? : "+ firstForm.elements.length)
		for (let i = 0; i < firstForm.elements.length; i++){
			if (firstForm.elements[i].value.trim() == "" ){ //빈 문자열이냐? == null이냐?
				console.log(firstForm.elements[i]);
				if (firstForm.elements[i].getAttribute("type") == "file") continue; //첨부파일은 제외하고.
				alert(firstForm.elements[i].title + "입력하세요");
				firstForm.elements[i].focus();
				return;
				
			}
		}
		
		firstForm.submit();
	}
	
	function list_go(){
		location.href="list.jsp";
	}
</script>
</head>
<body>
<div id="bbs">
	<form action="write_ok.jsp" method="post" enctype="multipart/form-data" id="write">
	<table>
		<caption>게시판 글쓰기</caption>
		<tbody>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="subject" title="제목">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="writer" title="작성자">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" rows="10" cols="50" title="내용"></textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="filename">
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" name="pwd" title="암호">
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" value="저 장" onclick="sendData()">
					<input type="reset" value="리 셋">
					
					<input type="button" value="목록보기" onclick="list_go()">
				</td>
			</tr>
		
		</tfoot>
	</table>
	</form>
</div>	
	
</body>
</html>