package com.mystudy.ex02_extends;

// 클래스 상속(extends: 확장) 실습
/* Phone 클래스를 상속 확장extends.
WebPhone 작성
- Phone 클래스 상속 확장
생성자 정의
	-PhoneNo 전달받는 생성자
 	-type, PhoneNo 전달받는 생성자
 
기능 : 전화 걸고, 받고, 전화정보보기, 웹검색 기능이 있는 전화기
	웹검색기능: webSearch() : ">> WebPhone - 웹검색" 문구 화면 출력
*/
class WebPhone extends Mp3Phone {
	
	//생성자
	public WebPhone(String phoneNo) {
		super("기본타입", phoneNo);
	}
	public WebPhone(String type, String phoneNo) {
		super(type, phoneNo);
	}
	
	//기능
	public void webSearch() {
		System.out.println(">> WebPhone - 웹검색");
	}
	
	
}
