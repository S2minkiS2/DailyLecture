package com.mystudy.ex05_interface3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.CommonJDBCUtil;
import vo.MovieVO;

interface MemberCRUD {
	
	
//	List<MemberVO> selectList();
	MemberVO selectOne(String id);
	boolean insert(MemberVO vo);
	boolean update(MemberVO vo);
	boolean delete(String id);
	
	public static List<MemberVO> selectList() {
		String sql = "SELECT * FROM MEMBER ";
		List<MemberVO> memList = new ArrayList<>();

		try {
			conn = CommonJDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
				memList.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CommonJDBCUtil.close(conn, pstmt, rs);
		}
		return memList;
	}

}
