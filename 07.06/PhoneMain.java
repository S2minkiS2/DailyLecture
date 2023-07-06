package com.mystudy.phone;

public class PhoneMain {

	// 필드변수
	String name = "2023 애플폰";
	String type = "샤프한 디자인";
	int hsize = 80;
	int vsize = 250;
	boolean hasLCD = true;
	String phoneNumber; //핸드폰 번호는 보통 String

	// 생성자 
	PhoneMain() {
	}

	PhoneMain(String name, String type) {
		this.name = name;
		this.type = type;
	}

	PhoneMain(String name, String type, boolean hasLCD, String phonNumber) {
		this.name = name;
		this.type = type;
		this.hasLCD = hasLCD;
		this.phoneNumber = phonNumber;
	}

	// 메서드 (문자열은 return값을 써서 해보시오)
	void call() {
		System.out.println("화면출력");
	}

	void receiveCall() {
		System.out.println("전화받기");
	}

	public String sendSms(String ms) { //메서드 인자에 Strig타입의 문자열을 입력하면, 그 값을 return
		return ms;
	}

	public String receiveSms(String ms) {
		return ms;
	}

	public String numCall(String ms) {
		return ms;
	}

	public void spamSms(String ms) { //문자열은 이렇게 하는게 맞는 방법. 설정과 실행은 서로 다른 java파일에 하도록. 유지보수 쉽게.
		if (ms.contains("대출")) { //특정문자열 감지= equals() ,contains(), matches() 등등 더 알아볼 것
			System.out.println("부적절한 단어가 감지되어 수신을 거부합니다");
		} else {
			System.out.println("[메시지 수신]: " + ms);
		}
	}

	void view() {
		System.out.println("모델명: " + name);
		System.out.println("타입: " + type);
		System.out.println("가로크기: " + hsize);
		System.out.println("세로크기: " + vsize);
		System.out.println("LCD유무: " + hasLCD);
		System.out.println("전화번호: " + phoneNumber);
	}

}
