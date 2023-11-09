package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtill;
import com.spring.biz.user.UserVO;

public class UserDAO {
	//JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//SQL문
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ? ";
		
	private final String USER_INSERT
		= "INSERT INTO USERS (ID, PASSWORD) "
				+ " VALUES (?, ?) ";
	
	public UserDAO() {
		System.out.println(">> UserDAO() 객체 생성");
		
	}
	
	//회원가입
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC로 insertUser() 실행");
		
		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(conn, stmt, rs);
		}
	}
	
	//유저검색(한명)
	public UserVO getUser(UserVO vo) {
		System.out.println(">> JDBC로 getUser() 실행");
		
		UserVO user = null;
		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtill.close(conn, stmt, rs);
		}
		
		return user;
	}
}
