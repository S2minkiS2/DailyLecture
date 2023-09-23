package com.mystudy.ex04_interface2;

/* Mp3Phone 기능 구현(반드시 I_Phone, I_Mp3Phone 구현해라)
전화정보확인, 전화걸고, 받고, 문자 주고, 받고
음악플레이
*/
class Mp3Phone extends Phone implements I_Mp3Phone {

	public Mp3Phone(String phoneNo) {
		super("Mp3Phone 타입", phoneNo);
	}
	
	public Mp3Phone(String type, String phoneNo) {
		super(type, phoneNo);
	}

	@Override
	public void playMusic() {
		System.out.println(">> 음악플레이~~~~~");
	}


}
