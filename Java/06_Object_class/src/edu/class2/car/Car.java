package edu.class2.car;

/* 자동차 클래스 //여기서 말하는 자동차는 추상적인, 개념적인 자동차 길에 돌아다니는~
 *			 // <-> 실제 굴러다니는 그 자동차 : 객체, 인스턴스, 하나의 개체
	속성 : 차량명, 모델명, 차량색상
	기능 : 가고, 서고, 뒤로가고, 차량정보 확인
 */
public class Car {
	// 필드 변수 (속성) ----------------
	String name = "마이카"; //차량명
	String model; //모델명
	String color; //차량색상
	//String 타입 기본값 : "null"
	
	final int CAR_LENGTH = 350; //차량길이
	//final이 붙으면 상수화된 변수 : 시각적인 구분 위해 전체대문자
	//final 제한자 : 변수의 값이 할당되면 변수의 마지막 값. 수정불가 (상수)
	// final 변수. 마지막 값. 항상 동일한 값
	final int CAR_WIDTH = 200; //차량의 폭(너비)
	
	boolean hasAirbag; //에어백 유무
	
	//생성자 -------------------------
	 Car() {
		 model = "드림카";
		 color = "흰색";
	 } //생성자는 class 이름 가져오기 기본생성자
	// 클래스명() {} : 기본생성자
	// 클래스명 (매개변수-파라미터, ...) {}
	// 주의 : 명시적으로 생성자 선언시 기본생성자 자동생성 안함 (필요시 직접 작성)
	
	Car(String n, String m, String c) {
		name = n;
		model = m;
		color = c;
	}
	
	//메소드(기능, 동작, 함수)--------------
	void run() {
		System.out.println(">>앞으로 이동");
	}
	void stop() {
		System.out.println(">>멈추기");
	}
	void back() {
	System.out.println(">>뒤로가기");
	}
	
	//자동차 속성값 확인
	void dispData() {
		System.out.println("--- 자동차 정보 ---");
		System.out.println("자동차명 : " + name);
		System.out.println("모델명 : " + model);
		System.out.println("색상명 : " + color);
		System.out.println("차량길이 : " + CAR_LENGTH);
		System.out.println("차량폭 : " + CAR_WIDTH);
		System.out.println("에어백 : " + hasAirbag);
		System.out.println("-----------");
	}

}