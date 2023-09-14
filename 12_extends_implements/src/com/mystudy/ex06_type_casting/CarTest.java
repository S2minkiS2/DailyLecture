package com.mystudy.ex06_type_casting;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("==== Car 클래스 ====");
		Car car = new Car();
		car.type = "자동차";
		System.out.println("타입 : " + car.type);
		car.drive();
		car.stop();
		
		System.out.println("==== Ambulace 클래스 ===");
		Ambulance am = new Ambulance();
		am.type = "구급차";
		System.out.println("타입 : " + am.type);
		am.drive();
		am.stop();
		
		am.siren();
		
		System.out.println("==== FireEngine 클래스 ===");
		FireEngine fe = new FireEngine();
		fe.type = "소방차";
		System.out.println("타입 : " + fe.type);
		fe.drive();
		fe.stop();
		
		fe.siren();
		fe.water();
		
		System.out.println("=====형변환=====");
		// Car, Ambulance, FireEngine
		Car car2 = new Car(); // Car <-- Car
		car2.type = "자동차";
		System.out.println("type : " + car2.type);
		car2.drive();
		car2.stop();
		
//		car2.siren(); //컴파일 오류 undefined : Car 타입에는 siren() 없음
		System.out.println("--- Car <-- Ambulance 저장 ---");
		//자녀타입 데이터를 부모 타입에, 서브타입 데이터를 수퍼타입에, 상위데이터에 저장
		//부모(상위)클래스에 자녀(하위)클래스를 저장 : 자동형변환
		car2 = am; // Car <-- Ambulance : 자동형변환 된다
		System.out.println("type : " + car2.type);
		car2.drive();
		car2.stop();
		
		//앰뷸런스 고유기능 siren() 사용하려면 Ambulance 타입이 되어야 함
		//지금은 line44에서 car2가 되어버림. car 타입이 됨.
		((Ambulance)car2).siren(); 
		// Ambulance로 바꾼 후에 형변환 해야함. 묶어줘야함
		//안그러면 뒤에 .부터 실행됨
		
		//=========================
		System.out.println("--- Ambulance <-- Car <-- Ambulance ---");
		System.out.println("car2 type : " + car2.type);
//		Ambulance am2 = car2; // 상위타입에 넣는 것은 그냥은 안됨
		Ambulance am2 = (Ambulance) car2; 
		// Car 타입에 저장되었던 Ambulance 타입 가능
		am2.drive();
		am2.stop();
		am2.siren();
		
		//생성시 해당 객체(인스턴스)가 중요하다
		// 자녀(하위)클래스에 부모(상위)클래스를 저장
		System.out.println("--- Ambulance <-- Car ---");
		Car carTemp = new Car();
		carTemp.type = "일반자동차"; // 실체!
//		Ambulance am2 = (Ambulance) carTemp; //강제형변환
		System.out.println("carTemp type : " + carTemp.type);
		//Car타입을 가져다 Am하위타입에 넣을 때
		//아무리 형변환을 해도 문법적으로는 가능하다 실행시 오류 : ClassCastException
		// 사용 시점에 car를 amb로 바꿀 수는 없다. 
		
		//부모타입을 자녀 타입에 넣어 쓸 수 있는 케이스
//		하위 -> 상위 저장해서 사용가능, 형변환 하면.
		
		
		
		
		
		
		
		
	}

}
