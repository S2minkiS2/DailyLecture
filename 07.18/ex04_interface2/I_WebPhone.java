package com.mystudy.ex04_interface2;

// 폰의기능이 다 있음.
// 음악플레이, 웹검색기능 다 있음
// --------------------------
interface I_WebPhone extends I_Mp3Phone, I_Phone {
	
//	public abstract void view(); //전화정보 확인 
//	public void call(); //전화걸기
//	void receiveCall(); // 컴파일 때 public abstract 가 자동생성
//	void sendSMS(); 
//	void receiveSMS();
	
//	void playMusic();
	void webSearch();
	
	
}
