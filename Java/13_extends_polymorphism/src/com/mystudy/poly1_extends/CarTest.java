package com.mystudy.poly1_extends;

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
		am.type = "구급차(Ambulance)";
		System.out.println("타입 : " + am.type);
		am.drive();
		am.stop();
		
		am.siren();
		
		System.out.println("==== FireEngine 클래스 ===");
		FireEngine fe = new FireEngine();
		fe.type = "소방차(FireEngine)";
		System.out.println("타입 : " + fe.type);
		fe.drive();
		fe.stop();
		
		fe.siren();
		fe.water();
		
		System.out.println("==== 타입확인 ====");
		Car carTemp = car; // Car <--- Car(위에서 만들어둔)
		carTemp = am; // Car <-- Ambulance
		carTemp = fe; // Car <-- FireEngine
		System.out.println("자동차타입 : " + carTemp.type);
		System.out.println("--- 타입 확인(instanceof) ---");
		// 지금은 Car 타입에 fe가 담겨있음
		//Object - car - FireEngine
		
		if (carTemp instanceof Object) {
			System.out.println("----Object 타입이다");
		}
		if (carTemp instanceof Car) { //Car타입의 instance냐?
			System.out.println("----Car 타입이다");
			carTemp.drive();
			carTemp.stop();
		}
		if (carTemp instanceof Ambulance) { //Car타입의 instance냐?
			System.out.println("----Car 타입이다");
			carTemp.drive();
			carTemp.stop();
			((Ambulance) carTemp).siren(); 
			//이클립스에서 자동형변환. 근데 앰뷸런스 아니라 실행안됨
		}
		if (carTemp instanceof FireEngine) { //Car타입의 instance냐?
			System.out.println("----Car 타입이다");
			carTemp.drive();
			carTemp.stop();
			((FireEngine) carTemp).siren(); 
			((FireEngine) carTemp).water();
		}
		//타입체크를 해서 오류 미연 방지
		System.out.println("===============");
		System.out.println("--- Car 타입객체 전달시(타입체크)");
		typeCheck(car); //Car
		
		System.out.println("--- Ambulance 타입객체 전달시(타입체크)");
		typeCheck(am); // Ambulance
		
		System.out.println("--- FireEngine 타입객체 전달시(타입체크)");
		typeCheck(fe); // FireEngine

		//모두 상속관계 있기 때문에 Car 타입에 넣을 수 있다.
		System.out.println("--- main() 끝 ------");
	
	}
	
		static void typeCheck(Car car) { //Car 타입으로 받으면 Car타입이지뭐
			System.out.println("::: Car 타입입니다");
			car.drive();
			car.stop();
		
		
		//확인할 객체 instanceof 비교할 클래스명(타입명)
		if (car instanceof Ambulance) { 
			System.out.println("----Ambulance 타입이다");
			((Ambulance) car).siren();
		}
		if (car instanceof FireEngine) {
			System.out.println("----FireEngine 타입이다");
			((FireEngine) car).siren(); 
			((FireEngine) car).water();
		}
	
	}
	
}

