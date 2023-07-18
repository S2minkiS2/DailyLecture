package com.mystudy.ex02_extends;

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
		// 위 세가지 메서드가 Mp3Phone클래스에 없음에도 extends로 가져왔기에 사용 가능.
		mp3ph.playMusic();
		
		
		System.out.println("=== WebPhone 01 ===");
		WebPhone webPh1 = new WebPhone("010-2222-4444");
		webPh1.view(); 
		
		webPh1.call();
		webPh1.receiveCall();
//		webPh1.playMusic();
		webPh1.webSearch();
		
		System.out.println("=== WebPhone 02 ===");
		WebPhone webPh2 = new WebPhone("Cooool", "010-3333-5555");
		webPh2.view();
		webPh2.call();
		webPh2.receiveCall();
		webPh2.webSearch();
		
		
		System.out.println("=== 커스텀마이징 폰 ===");
		MyNewPhone myPhone = new MyNewPhone("최신기종", "000-0000-0000");
		myPhone.view();
		myPhone.call();
		myPhone.receiveCall();
		myPhone.webSearch();
		myPhone.playMusic();
		
	}

}
