package com.mystudy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.model.command.Command;
import com.mystudy.model.command.DeptCommand;
import com.mystudy.model.command.DeptListCommand;
import com.mystudy.model.command.FullnameCommand;
import com.mystudy.model.command.ListCommand;
import com.mystudy.model.dao.EmployeeDAO;
import com.mystudy.model.vo.EmployeeVO;

@WebServlet("/controller")
public class FrontControllerCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">> FrontControllerCommand doPGet() 실행----");
		String type = request.getParameter("type");
		System.out.println("> type : " + type);
		
		
		Command command = null; //인터페이스인 Command 부모타입으로 선언하면 밑에서 모두 사용 가능.
		if ("list".equals(type)) {
			//ListCommand command = new ListCommand();
			command = new ListCommand();
		}
		
		if("dept".equals(type)) {
			//DeptCommand command = new DeptCommand();
			command = new DeptCommand();
		}
		
		if("deptList".equals(type)) {
			command = new DeptListCommand();
		}
		
		if("fullname".equals(type)) {
			command = new FullnameCommand();
			
			
		}
		
		String path = command.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> FrontControllerCommand doPost() 실행----");
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
	
	
}
