package com.mystudy.poly1_extends;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("====== Car 클래스 ======"); //조상
		Car car = new Car();
		car.type = "자동차(Car)";
		System.out.println("타입 : " + car.type);
		car.drive();
		car.stop();
		
		System.out.println("====== Ambulance 클래스 ======"); //자식
		Ambulance am = new Ambulance();
		am.type = "구급차(Ambulance)";
		System.out.println("타입 : " + am.type);
		am.drive();
		am.stop();
		am.siren();
		
		System.out.println("====== FireEngine 클래스 ======"); //자식
		FireEngine fe = new FireEngine();
		fe.type = "소방차(FireEngine)";
		System.out.println("타입 : " +fe.type);
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
		
		System.out.println("==== 타입확인 ====");
		Car carTemp = car; // Car <-- Car
		carTemp = am; // Car <-- Ambulance
		carTemp = fe; // Ambulance <-- FireEngine
		System.out.println("자동차 타입: " + carTemp.type);
		System.out.println("--- 타입확인(instanceof) ---");
		if (carTemp instanceof Object) {
			System.out.println("---- Object 타입이다");
		}
		if (carTemp instanceof Car) {
			System.out.println("---- Car 타입이다");
			carTemp.drive();
			carTemp.stop();
		}
		if (carTemp instanceof Ambulance) { // 마지막으로 담긴 값은 am이 아니라 fe여서 아니다. 
			System.out.println("---- Ambulance 타입이다");
			carTemp.drive();
			carTemp.stop();
			((Ambulance) carTemp).siren(); //이클립스에서 자동으로 형변환식 만들어줌
		}
		if (carTemp instanceof FireEngine) { 
			System.out.println("---- FireEngine 타입이다");
			carTemp.drive();
			carTemp.stop();
			((FireEngine) carTemp).siren(); //이클립스에서 자동으로 형변환식 만들어줌
			((FireEngine) carTemp).water(); //이클립스에서 자동으로 형변환식 만들어줌
		}
		
		System.out.println("======================");
		
		System.out.println("---- Car 타입객체 전달시(타입체크) ----");
		typeCheck(car); // Car
		
		System.out.println("---- Ambulance 타입객체 전달시(타입체크) ----");
		typeCheck(am); // Ambulance
		
		System.out.println("---- FireEngine 타입객체 전달시(타입체크) ----");
		typeCheck(fe); // FireEngine

		
		
		
		System.out.println("--- main() 끝 ---");
		
	}
	
	static void typeCheck(Car car) {
		System.out.println("::: Car 타입입니다");
		car.drive();
		car.stop();
		
		// 확인할객체 instanceof 비교할 클래스명(타입명)
		if (car instanceof Ambulance) { 
			System.out.println("---- Ambulance 타입이다");
			car.drive();
			car.stop();
			((Ambulance) car).siren(); //이클립스에서 자동으로 형변환식 만들어줌
		}
		if (car instanceof FireEngine) { 
			System.out.println("---- FireEngine 타입이다");
			car.drive();
			car.stop();
			((FireEngine) car).siren(); //이클립스에서 자동으로 형변환식 만들어줌
			((FireEngine) car).water(); //이클립스에서 자동으로 형변환식 만들어줌
		}
		
	}

}
