package com.mystudy.ex01_class;

public class PhoneTest {

	public static void main(String[] args) {
		// Phone 객체 인스턴스 생성 후, 기능 테스트
		
		System.out.println("=== Phone ===");
		Phone ph1 = new Phone("010-2736-6119");
		ph1.view();
		ph1.call();
		ph1.receiveCall();
		String ph2_2 = ph1.getPhoneNo();
		System.out.println(ph2_2);
		
		System.out.println("--------------");
		Phone ph2 = new Phone("Samsung", "010-1111-2222");
		ph2.view();
		ph2.call();
		ph2.receiveCall();
		String ph2_3 = ph2.getPhoneNo();
		System.out.println(ph2_3);
		
		System.out.println("=== Mp3Phone ===");
		Mp3Phone mp3ph = new Mp3Phone("010-1234-5678");
		mp3ph.view();
		mp3ph.call();
		mp3ph.receiveCall();
		mp3ph.playMusic();
		
		
	}

}
