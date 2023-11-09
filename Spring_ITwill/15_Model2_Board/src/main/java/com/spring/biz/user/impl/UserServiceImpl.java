package com.spring.biz.user.impl;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public UserServiceImpl() {
		System.out.println(">> UserServiceImpl() 객체 생성");
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	
	
	
	
}
