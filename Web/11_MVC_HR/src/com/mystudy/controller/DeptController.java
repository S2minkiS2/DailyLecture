package com.mystudy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dept")
public class DeptController extends HttpServlet {
		
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//dept.jsp 페이지로 응답처리(페이지 이동). req, resp 넘김
		req.getRequestDispatcher("dept.jsp").forward(req, resp); //dept.jsp 안만들면 404오류 발생.
		
		//
		
	}
}
