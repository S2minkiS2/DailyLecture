package com.mystudy.ex04_interface2;
/* Mp3Phone 기능 구현 (반드시 I_Phone, I_Mp3Phone 구현해라)
전화정보확인, 걸고, 받고, 문자 보내고, 문자 받고
음악플레이기능
*/
class Mp3PhoneImpl implements I_Mp3Phone, I_Phone {
	// 필드변수(속성) -------------------
	private String type; // 전화타입(형태)
	private String phoneNo;

	// 생성자 -------------------------
	public Mp3PhoneImpl() {
	}

	public Mp3PhoneImpl(String phoneNo) {
		this.type = "Apple";
		this.phoneNo = phoneNo;
	}

	public Mp3PhoneImpl(String type, String phoneNo) {
		this.type = type;
		this.phoneNo = phoneNo;
	}

	// 메서드 -------------------------
	public String getType() { // get : 조회만 할 수 있다.
		return type;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
	
	
	@Override
	public void view() {
		System.out.print("타입 : " + type);
		System.out.println("\t전화번호 : " + phoneNo);
		
	}

	@Override
	public void call() {
		System.out.println(">> 전화 걸기!!");
		
	}

	@Override
	public void receiveCall() {
		System.out.println(">> 전화 받기~~");
		
	}

	@Override
	public void sendSMS() {
		System.out.println(">> 메세지 보내기");
		
	}

	@Override
	public void receiveSMS() {
		System.out.println(">> 메세지 받기");
		
	}

	@Override
	public void playMusic() {
		System.out.println(">> 음악을 재생합니다.");
		
	}
	
}
