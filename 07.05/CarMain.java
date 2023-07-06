package edu.class2.car;

//패키지는 
//학교에서 반의 개념.
//클래스는 학생들

public class CarMain {

	public static void main(String[] args) {
		//Car 클래스를 이용해서 Car 타입의 객체(인스턴스) 생성 사용
		
		Car car1= new Car();
		
		car1.color = "노란색";
				
		System.out.println("자동차명 : " + car1.name);
		System.out.println("모델명 : " + car1.model);
		System.out.println("차량색상 : " + car1.color);
		System.out.println("차량길이 : " + car1.CAR_LENGTH);
		System.out.println("차량폭 : " + car1.CAR_WIDTH);
		System.out.println("에어백유무 : " + car1.hasAirbag);
		System.out.println("-------------- 멤버값 수정 ----------------");
		
		
		car1.name = "처음 가져본 차";
		System.out.println("객체 생성 후에 변수값 수정, 자동차명 : " + car1.name);
		
		System.out.println("========기능 테스트=========");
		car1.run();
		car1.stop();
		car1.back();
		
		System.out.println("------------------------");
		System.out.println("======= car2 생성 =======");
		
		Car car2 = new Car("마실용차 ", "아우디", "블랙");
		car2.hasAirbag = true;
		car2.dispData();
		car2.run();
		car2.stop();
		car2.back();
		
		System.out.println("------------------------");
		
		
		
		
		
	}

}
