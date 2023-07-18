package com.mystudy.ex04_interface2;

// 인터페이스에는 final 속성값, 추상메서드가 있다.
interface I_Phone { // public 있고, 없고  
	// {} 구현부가 없는 메서드 : 추상메서드 abstract method
	// 인터페이스에 정의된 추상메서드는 모두 public abstract 메서드
	public abstract void view(); //전화정보 확인 
	public void call(); //전화걸기
	void receiveCall(); // 컴파일 때 public abstract 가 자동생성
	void sendSMS(); 
	void receiveSMS();
	
	
	
	
	
	
}
