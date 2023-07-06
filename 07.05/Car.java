package edu.class2.car;

/*자동차 클래스
 * 속성 : 차량명, 모델명, 차량색상
 * 기능 : 가다, 서다, 후진하다, 차량의정보 확인
 * */
public class Car {
	//필드변수 (속성)---------
	String name = "마이카";
	String model;
	String color;
	final int CAR_LENGTH = 350; //상수는 눈에 띄게 해주자: 대문자+언더바, ctrl + shift + x 
	final int CAR_WIDTH = 200;
	boolean hasAirbag; //에어백 유무, boolean 기본값은 false
	
	//생성자(기본) ---------------
	Car(){
		model = "기본 생성 모델은 드림카";
//		car_length = 400; // final타입이여서 생성자에서도, 객체생성 후에도 수정이 불가하다. 오로지 클래스 멤버에서만 수정이 가능.
		
	}
	
	//생성자(명시적, 매개변수) ------------
	Car(String name, String model, String color){ //기본 생성자는 클래스를 따라가고, 
												//매개변수 생성자는 필드변수에 집어 넣을 값을 미리 설정해서 생성 가능하게끔 세팅된 상태
		
		this.name = name;
		this.model = model;
		this.color = color;
	}
	
	//메서드(기능, 동작) ----------
	void run() {
		System.out.println(">>앞으로 이동합니다");
	}
	void stop() {
		System.out.println(">>멈춥니다");
	}
	void back() {
		System.out.println(">>후진합니다.");
	}
	
	//자동차 속성값 = 정보 확인
	void dispData() {
		System.out.println("---- 자동차 정보 ----");
		System.out.println("자동차명 : " + name);
		System.out.println("모델명 : " + model);
		System.out.println("차량색상 : " + color);
		System.out.println("차량길이 : " + CAR_LENGTH);
		System.out.println("차량폭 : " + CAR_WIDTH);
		System.out.println("에어백유무 : " + hasAirbag);
	}
	
	
	
}
