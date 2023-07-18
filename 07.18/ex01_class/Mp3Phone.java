package com.mystudy.ex01_class;

class Mp3Phone {
	private String type;
	private String phoneNo;

	
	public Mp3Phone() {
	};

	public Mp3Phone(String phoneNo) {
		type = "Mp3Phone 타입";
		this.phoneNo = phoneNo;
	}

	public Mp3Phone(String type, String phoneNo) {
		this.type = type;
		this.phoneNo = phoneNo;
	}

	
	public String getType() {
		return type;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	// 전화걸기 기능
	public void call() {
		System.out.println(">> 전화 걸기!!");
	}

	public void receiveCall() {
		System.out.println(">> 전화 받기~~");
	}

	// 전화정보 확인
	public void view() {
		System.out.print("타입 : " + type);
		System.out.println("\t전화번호 : " + phoneNo);
	}
	//음악플레이 기능
	public void playMusic() {
		System.out.println(">> 음악을 재생합니다.");
	}

}
