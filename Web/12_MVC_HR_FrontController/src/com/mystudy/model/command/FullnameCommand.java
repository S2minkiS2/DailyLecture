package com.mystudy.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FullnameCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fullname 요청 모두 처리 (입력폼/직원목록)
		//0. 파라미터 값 확인(추출)
		String name = request.getParameter("name");
		System.out.println(">> FullnameCommand name : " + name);
		
		String path = null;
		if(name == null) {
			path="fullname.jsp";
		} else {
			path = "fullnameList.jsp";
		}
		
		//전달받은 이름으로 DB데이터 조회 후 리스트 페이지로 이동
		
		return path;
	}

	
	
}
