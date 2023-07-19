package com.mystudy.poly4_interface;

public class TypeTest {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		cat.eat();
		cat.sleep();
		cat.sound();
		
		Pig pig = new Pig();
		pig.sound();
		
		dog.sound();
		System.out.println("===== Animal 타입 사용(Cat 객체) =====");
		Animal animal = new Cat();
		animal.eat();
		animal.sleep();
		animal.sound();
//		animal.getname(); Animal 인터페이스에 정의되어 있는 것만 사용 가능
//		animal.run(); 이것도 마찬가지. 이 메서드는 Cat에만 있고, animal 에는 없기때문
///  	즉! 타입변경시 해당 데이터 타입에 정의된 기능(메소드)만 사용가능
		
		System.out.println("==== 메소드 파라미터 Animal 인터페이스 사용 ====");
		soundPoly(cat);
		soundPoly(dog);
		soundPoly(pig);
		
		
	}
	
	//인터페이스 Animal 타입으로 데이터를 받아서
	//인터페이스 타입에 저장된 데이터에 있는 sound() 를 호출한다.
	//메소드 오버라이딩에 의해서 저장된 객체에 메소드가 호출된다.
	static void soundPoly(Animal animal	) {
		animal.sound();
	}// Animal 클래스에만 정의되어 있는 메서드만 호출 가능.
	
	
//	static void runPoly(Animal animal) {
//		animal.run();
//	} Animal 에는 없기 때문에 호출 불가. run() 은 Cat에만 있음
	

}
