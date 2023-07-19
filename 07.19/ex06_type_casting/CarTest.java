package com.mystudy.ex06_type_casting;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("====== Car 클래스 ======"); //조상
		Car car = new Car();
		car.type = "자동차";
		System.out.println("타입 : " + car.type);
		car.drive();
		car.stop();
		
		System.out.println("====== Ambulance 클래스 ======"); //자식
		Ambulance am = new Ambulance();
		am.type = "구급차";
		System.out.println("타입 : " + am.type);
		am.drive();
		am.stop();
		am.siren();
		
		System.out.println("====== FireEngine 클래스 ======"); //자식
		FireEngine fe = new FireEngine();
		fe.type = "소방차";
		System.out.println("타입 : " +fe.type);
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
		
		
		System.out.println("====== 자동 형변환 (조상 <-- 자식) ======");
		Car newCar = fe; // 부모클래스 참조변수에 자식클래스 인스턴스를 대입 = 자동형변환
		newCar.drive();
		newCar.stop();
//		newCar.siren(); 인스턴스에 메서드는 있지만, 참조변수가 부모클래스여서 접근할 방법이 없다.
		((FireEngine)newCar).water(); // 부모클래스의 newCar참조변수를 다시 자식클래스로 형변환 해주고 메서드 실행시 정상작동
		
		
		System.out.println("====== 강제 형변환 (자식 <-- 조상) ======");
//		Car carTemp = new Car(); //부모클래스의 객체를 하나 생성하여,
//		FireEngine fireNewCar = (FireEngine)carTemp; //강제형변환 문법적으로 가능하나 실행시 오류발생 : ClassCastException
//		fireNewCar.drive();
//		fireNewCar.stop();
//		fireNewCar.siren(); // 코드에는 문제 없지만, 애초에 newCar2가 가리키는 인스턴스는 부모클래스의 인스턴스로 만들어 졌기에..
//		fireNewCar.water(); // 컴파일시 오류 undefined : Car 타입 객체에는 siren(), water() 가 없다.
		
		
		System.out.println("====== 자동 형변환 (자식 <-- 조상 <-- 자식) ======");
		FireEngine fireNewCar2 = new FireEngine();
		fireNewCar2 = (FireEngine)newCar; // 위의 newCar 를 가져옴
		
		fireNewCar2.drive();
		fireNewCar2.stop();
		fireNewCar2.siren(); 
		fireNewCar2.water(); 
		// FireEngine 인스턴스를 참조하던 부모클래스 변수 newCar를 강제형변환 시키고, 
		// 다시 FireEngine 클래스의 참조변수 fireNewCar2 에 주소값을 대입하니 정삭작동.
		
		
		
	}

}
