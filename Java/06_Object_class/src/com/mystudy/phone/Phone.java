package com.mystudy.phone;

public class Phone {
//	2. 속성 (필드변수, 인스턴스변수, 멤버변수) 변수선언 
// 		데이터 저장 공간
	String name = "사과폰";  //모델명  초기값 지정, 바꿀 수 있음
	String type = "스마트폰"; //타입
	int hsize = 10; //가로크기
	int vsize = 20; //세로크기
	boolean hasLCD = true; //LCD유무

//	3. 생성자 선언-------------------------
//	가. 기본생성자
	Phone () {} //

//	★ 나.  //클래스명사용, 모델명과 타입 받기★
//	Phone (String n, String t) { //괄호 안 파라미터(매개변수)
//		name = n;  // 
//		type = t;	// 전달받은 값이 필드로 간다 name에 n 저장; t-type-String type
//	}
	Phone (String name, String type) { //괄호 안 파라미터(매개변수)
		this.name = name;  // this는 현재객체. 인스턴스.
		this.type = type;
	}
	
	
////	다. 
	Phone(String name, String type, boolean hasLCD) {
		this.name = name; // this 현재객체 (인스턴스)
		this.type = type;
		this.hasLCD = hasLCD;
	}


//		-------메소드------------
	void call() {
		System.out.println(">>전화걸기"); //리턴도 없고 전달받는 파라미터도 없음
	}

	void receiveCall() {
		System.out.println("<<전화받기");
	}

	void sendSms(String msg) { //문자열 타입의 데이터를 하나 받는다
		System.out.println("[메시지전송] " + msg );
	}
	String receiveSms(String remsg) {
		//리턴 타입이 String이다.
		System.out.println("[메시지수신] " + remsg); 
		return remsg;  // 전달받은 메세지 호출한 곳으로 돌려줌
		//리턴값을 받아서 쓴다
	}
	
//	view---------------------------
	void view() { //매개변수 없다, 리턴데이터 없다 => 실행만 하고 끝
		//메소드에서 찾아서 없으면 필드로 간다
		System.out.println("--- 전화기 정보 ---");
		System.out.println("모델명 : " + name);
		System.out.println("타입 : " + type);
		System.out.println("가로크기 : " + hsize);
		System.out.println("세로크기 : " + vsize);
		System.out.println(hasLCD);
 
		

	}
	
}
	
			

