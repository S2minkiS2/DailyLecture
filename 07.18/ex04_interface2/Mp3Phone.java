package com.mystudy.ex04_interface2;

public class Mp3Phone extends Phone implements I_Mp3Phone {
	
	public Mp3Phone (String phoneNo) {
		super("Mp3Phone타입", phoneNo);
	}
	
	@Override
	public void playMusic() {
		System.out.println(">> 음악을 재생합니다.");
		
	}
	
}
