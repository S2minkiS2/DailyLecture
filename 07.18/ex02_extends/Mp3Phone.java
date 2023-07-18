package com.mystudy.ex02_extends;

//Phone 클래스를 상속받아 extends, 확장해서 Mp3Phone 만들겠다.
//Phone 클래스에서 허용된 속성, 기능을 사용 + Mp3Phone 속성, 기능을 추가 사용
class Mp3Phone extends Phone {
	
	public Mp3Phone(String phoneNo) {
		super("Mp3Phone 기본타입", phoneNo); //부모클래스 생성자 호출, String phoneNo 매개변수를 받는 부모의 생성자를 의미.
	}
	public Mp3Phone(String type, String phoneNo) {
		super(type, phoneNo);
	}
	
	//메소드 기능 -----------------------------------
	public void playMusic() {
		System.out.println(">> 음악을 재생합니다");
		
	}
}
