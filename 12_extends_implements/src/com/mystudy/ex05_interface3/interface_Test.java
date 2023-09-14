package com.mystudy.ex05_interface3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class interface_Test implements MemberCRUD {

	@Override
    public MemberVO selectOne(String id) {
        for (MemberVO member : memberList) {
            if (member.getId().equals(id)) {
                return member; 
            }
        }
        return null; 
    }
	
	
	@Override
	public boolean insert(MemberVO vo) {
	    for (MemberVO member : memberList) {
	        if (member.getId().equals(vo.getId())) {
	        	System.out.println("중복된 id입니다.");
	            return false; 
	        }
	    }

	    
	    memberList.add(vo);
	    return true; 
	}



	@Override
	public boolean update(MemberVO vo) {
	    for (int i = 0; i < memberList.size(); i++) {
	        MemberVO member = memberList.get(i);
	        if (member.getId().equals(vo.getId())) {
	            // 아이디가 일치하는 회원 정보를 찾았을 경우 정보 수정
	            memberList.set(i, vo);
	            return true; // 회원 정보 수정 성공
	        }
	    }
	    return false; // 아이디에 해당하는 회원을 찾지 못해 수정 실패
	}


	@Override
	public boolean delete(String id) {
	    for (MemberVO member : memberList) {
	        if (member.getId().equals(id)) {
	            // 아이디가 일치하는 회원을 찾았을 경우 삭제
	            memberList.remove(member);
	            return true; // 회원 정보 삭제 성공
	        }
	    }
	    return false; // 아이디에 해당하는 회원을 찾지 못해 삭제 실패
	}


	@Override
	 public List<MemberVO> selectList() {
        List<MemberVO> allMembers = new ArrayList<>();
        allMembers.addAll(memberList); 
        return allMembers;
    }

}
