package com.mystudy.ex01_class;

//public class Phone extends Object {
class Phone {
	//필드변수(속성) -------------------
	private String type; // 전화타입(형태)
	private String phoneNo;
	
	//생성자 -------------------------
	public Phone() {}
	
	public Phone(String phoneNo) {
		this.type = "Apple";
		this.phoneNo = phoneNo;
	}
	
	public Phone(String type, String phoneNo) {
		this.type = type;
		this.phoneNo = phoneNo;
	}

	//메서드 -------------------------
	public String getType() {  // get : 조회만 할 수 있다. 
		return type;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
	
	//전화걸기 기능
	public void call() {
		System.out.println(">> 전화 걸기!!");
	}
	public void receiveCall() {
		System.out.println(">> 전화 받기~~");
	}
	
	//전화정보 확인
	public void view() {
		System.out.print("타입 : " + type);
		System.out.println("\t전화번호 : " + phoneNo);
	}
	
}
