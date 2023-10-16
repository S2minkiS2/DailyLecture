package com.mystudy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.model.dao.EmployeeDAO;
import com.mystudy.model.vo.EmployeeVO;

@WebServlet("/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> Listcontroller - doGet() 시작");
		
		System.out.println(">>> doGet 업무처리 ~~~~~");
		//DB에서 데이터 가져와서 list.jsp페이지에서 사용토록 전달 
		//1. DB연결하고 데이터 가져오기
		List<EmployeeVO> list = EmployeeDAO.getList();
		
		//2. 응답페이지 (list.jsp)에 전달한다
		request.setAttribute("list", list); //session에 해도 되지만, 자원점유율 문제로 request에 저장.
		
		//3.페이지 전환 - 응답할 페이지 (list.jsp)로 포워딩(위임)
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		
		System.out.println("> Listcontroller - doGet() 끝");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> Listcontroller - doPost() 시작");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		System.out.println("> Listcontroller - doPost() 끝");
	}

}
