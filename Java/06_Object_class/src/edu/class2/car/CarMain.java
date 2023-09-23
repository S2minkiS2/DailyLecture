package edu.class2.car;

public class CarMain {

	public static void main(String[] args) {
		// Car 클래스 이용해서 Car 타입의 객체(인스턴스) 생성해서 사용
		Car car1 =  new Car();
	//Car타입 /변수  //기본생성자 호출
		car1.color = "검정";
		
		
		System.out.println("자동차명 : " + car1.name);
		System.out.println("모델명 : " + car1.model);
		System.out.println("색상명 : " + car1.color);
		System.out.println("차량길이 : " + car1.CAR_LENGTH);
		System.out.println("차량폭 : " + car1.CAR_WIDTH);
		System.out.println("에어백 : " + car1.hasAirbag);
		System.out.println("-----------");
		car1.name = "처음 가져본 차";
		System.out.println("자동차명 : " + car1.name);
		
		car1.hasAirbag = true;
		System.out.println("에어백 : " + car1.hasAirbag);
		
		//얼마든지 필요에 따라 데이터를 변화시켜줄 수 있다.
		
		System.out.println("======== 기능테스트 =======");
		car1.run();
		car1.stop();
		car1.back(); //정의된 기능만 쓸 수 있다.
	
		System.out.println("===============");
		System.out.println("===car 2 생성 사용============");
		//Car car2 = new Car(); //기본생성자 호출
		Car car2 = new Car("캠핑카", "캠퍼밴", "노랑");
		
		
		car2.dispData();
		
		car2.run();
		car2.stop();
		car2.back();
		
		
		
		
		
	}
	
	
}
