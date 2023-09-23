package com.mystudy.phone;

public class PhoneMain {

	public static void main(String[] args) {

		Phone phone1 = new Phone(); //사용하는 곳에서 객체 생성 (객체의 용도는 사용)
		
		phone1.hsize = 12;
		
		//기본 데이터 타입에는 값이 저장됨
		//phone1이라는 곳에는 주소가 저장됨 (참조변수 - 참조형 데이터타입)
		System.out.println("phone1 : " + phone1); //변수에 저장된 데이터가 있다 아 ㄹ수 있음
		phone1.view(); //기본값을 알 수 있음
		phone1.call(); //그냥 call()만 적는 건 내가 갖고있는 걸 호출
		
		phone1.sendSms("ㅎㅇ"); //이 문자열이 메서드로 전달 void~~
		//ㅎㅇ가 sendSms메서드로 전달 - 출력 - 실행
		//
		String receiveMsg = phone1.receiveSms("gggggg");
		System.out.println("::받은메시지: " + receiveMsg);
		//리턴값을 받아서 쓴다
		
		phone1.receiveSms("ㅎㅎㅎㅎㅎㅎ"); // 
		
		
//		=========================================
		System.out.println("====phone2 =============");
		Phone ph2 = new Phone("마이폰", "아이폰");
		System.out.println("ph2 : " + ph2);
		
		System.out.println("모델명 : " + phone1.name);
		System.out.println("타입 : " + phone1.type);
		System.out.println("가로크기 : " + phone1.hsize);
		System.out.println("세로크기 : " + phone1.vsize);
		System.out.println(phone1.hasLCD);


	
	}

}
