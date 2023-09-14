package com.mystudy.member.dao;

import java.util.List;

import com.mystudy.member.vo.MemberVO;

public class MemberDAO_Test {
                                                                                                                          
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.selectAll();
		
		for (MemberVO vo : list) {
			System.out.println(vo);
		}
		
		System.out.println("===============");
		MemberVO vo = new MemberVO("YJ", "유정", "nyanya", "010-1234-1234", "용인");
		int insertCount = dao.insert(vo); //dao의 insert로 입력. vo를. 
		System.out.println("입력건                                   수 : " + insertCount);

	}

}
