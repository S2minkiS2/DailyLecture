<%@page import="com.mystudy.mybatis.DBService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--전달받은 데이터 사용 DB 데이터 수정(UPDATE) 처리 후 화면 전환
	수정성공 : 상세화면으로 이동(또는 전체목록으로 이동) 
	예외발생 : 예외메시지 표시 후 이전화면(수정페이지) 이동 --%>

<%
	//0. 한글처리
	request.setCharacterEncoding("UTF-8");
	
	//1. 파라미터 값 확인(추출) - VO에 저장
%>
	<jsp:useBean id="vo" class="com.mystudy.mybatis.GuestbookVO" />
	<jsp:setProperty property="*" name="vo"/> 
<%
	System.out.println(">update_ok.jsp vo : " + vo);	

	//2. DB 데이터 수정 처리
	//2-1. SqlSession 객체 생성
	SqlSession ss = DBService.getFactory().openSession(true);
	
	//2-2. SqlSession 객체 사용 DB에 입력
	try {
		int result = ss.update("guestbook.update", vo);
		//3. 페이지 전환 : 수정 성공시 페이지 이동(전환)
		System.out.println("result : " + result);
%>
		<script>
			alert("정상 수정되었습니다\n목록페이지로 이동합니다");
			//location.href = "write.jsp";
			location.href = "list.jsp";
		</script>
<%		
	} catch (Exception e) {
		System.out.println(">> [예외발생] 수정실패");
		e.printStackTrace();
%>
		<script>
			alert("[예외발생] 수정작업중 오류발생\n"
					+ "담당자(8282)에게 연락하세요\n"
					+ "이전페이지로 이동합니다");
			history.back();
		</script>
<%		
	} finally {
		ss.close();
	}
%>