package com.spring.biz.user;

import com.spring.biz.user.impl.UserDAO;

public class UserTest {

	public static void main(String[] args) {
		UserVO vo = new UserVO();
		vo.setId("testId");
		vo.setPassword("testPwd");
		
		UserDAO dao = new UserDAO();
		
		dao.insertUser(vo);
		
		UserVO one = dao.getUser(vo);
		System.out.println("one : " + one);
		
	}

}
