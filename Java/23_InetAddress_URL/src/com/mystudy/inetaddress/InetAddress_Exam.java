package com.mystudy.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_Exam {

	public static void main(String[] args) throws UnknownHostException { //예외는 그냥 던짐
		// InetAddress : IP주소 관련 클래스 // 해당 컴퓨터 고유 주소
		InetAddress iaddr = InetAddress.getLocalHost(); //static메서드 get~ LocalHost는 자기자신
		System.out.println("iaddr : " + iaddr);
		//출력값 : 컴퓨터이름 / 각자 ip주소
		
		System.out.println("호스트명(pc/서버명) : " + iaddr.getHostName());
		System.out.println("호스트명 IP주소 : " + iaddr.getHostAddress());
		
		System.out.println("--- 네이버 주소 검색 ---");
		InetAddress naver = InetAddress.getByName("www.naver.com");
		//리턴타입 InetAddress
		System.out.println("naver : " + naver);
		//도메인명은 외부적, 도메인주소를 DNS서버에가져서 ip주소로 바꿔서 ip주소로 찾아감
		//매칭 정보를 서비스해주는 서버가 DNS서버
		
		System.out.println("--- 네이버 IP 주소들 검색 ---");
		InetAddress[] iaArray = InetAddress.getAllByName("www.naver.com");
		//배열타입이다. 이 배열에 담긴 하나의 데이터 타입이 InetAddress 
		
		for(InetAddress ia : iaArray) {
			System.out.println("호스트명(pc/서버명) : " + naver.getHostName());
			System.out.println("호스트명 IP주소 : " + naver.getHostAddress());
		}
	
	
	
	}

}
