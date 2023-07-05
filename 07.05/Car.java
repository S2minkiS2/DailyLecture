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
	
	//생성자(기본) ---------------
	Car(){}
	
	//생성자(명시적, 매개변수) ------------
	Car(String name, String model, String color){
		this.name = name;
		this.model = model;
		this.color = color;
	}
	
	//메서드(기능, 동작) ----------
	void run() {
		System.out.println("앞으로 이동합니다");
	}
	void stop() {
		System.out.println("멈춥니다");
	}
	void back() {
		System.out.println("후진합니다.");
	}
	
	
	
}
