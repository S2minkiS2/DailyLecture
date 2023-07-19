package com.mystudy.poly2_overriding;

public class TypeTest {

	public static void main(String[] args) {
		Animal an = new Animal();
		Cat cat = new Cat();
		Dog dog = new Dog();
		Pig pig = new Pig();
		
		cat.sound();
		dog.sound();
		pig.sound();
		
		System.out.println("==== 메소드 오버로딩 사용 ====");
		sound_overloading(cat);
		sound_overloading(dog);
		sound_overloading(pig);
		
		
		System.out.println("--- instanceof 타입체크 ---");
		sound_instanceof(cat);
		sound_instanceof(dog);
		sound_instanceof(pig);
		
		
		System.out.println("==== 메소드 오버라이딩 사용 ====");
		sound(cat);
		sound(dog);
		sound(pig);
		sound(an);
		
		
	}
	
	
	// 메소드 오버라이딩(overriding) 사용 (제일 간단하네? instaceof, 메서드 오버라이딩보다.. 유지보수에서 좋다.)
	static void sound(Animal animal) { // 다형성
		animal.sound(); // 마지막에 정의되어 있는 메소드가 (마지막 : 실제 만들어지는 인스턴스 객체{자기 자신과 그 조상들에 한해서})호출 되어진다?
	}
	
	//instanceof 사용 타입 확인하는 패턴
	static void sound_instanceof(Animal animal) {
		if (animal instanceof Cat) {
			((Cat)animal).sound();
		} else if (animal instanceof Dog) {
			((Dog)animal).sound();
		} 
			else if (animal instanceof Pig) {
			((Pig)animal).sound();
		}
	}
	
	
	//메서드 오버로딩 방식 ============ 같은 이름의 메서드, 같은 기능, but 다른 파라미터
	static void sound_overloading(Cat cat) {
		cat.sound();
	}
	
	static void sound_overloading(Dog dog) {
		dog.sound();
	}
	
	static void sound_overloading(Pig pig) {
		pig.sound();
	}
	
}
