package edu.class2.car;

public class CarMain {

	public static void main(String[] args) {
		//Car 클래스를 이용해서 Car 타입의 객체(인스턴스) 생성 사용
		
		Car car1= new Car();
		car1.model = "G8";
		car1.color = "검정";
		
		System.out.println("자동차명 : " + car1.name);
		System.out.println("모델명 : " + car1.model);
		System.out.println("차량색상 : " + car1.color);
		
		car1.name = "처음 가져본 차";
		System.out.println("자동차명 : " + car1.name);
		
		System.out.println("========기능 테스트=========");
		car1.run();
		car1.stop();
		car1.back();
		
		
	}

}
