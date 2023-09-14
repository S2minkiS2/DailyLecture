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
		
		System.out.println("--- 메소드 오버로딩(overloading) 방식");
		//하나의 클래스 내에서 이름만 같은 , 과적 
		sound_overloading(cat);
		sound_overloading(dog); //이건머야언더바????
		sound_overloading(pig);
		
		System.out.println("--- instanceof 타입 체크 방식");
		sound_instanceof(cat);
		sound_instanceof(dog);
		sound_instanceof(pig);
		
		System.out.println("--- 메소드 오버라이딩(overloading) 방식");
		sound(cat); //타입은 Animal이나, 실제는 Cat타입의 데이터이다.
		//Cat타입의 데이터타입 만들어질 때 실제론 Animal도 만들어진다.
		// 호출되는 건 animal에 있는 sound이지만
		// 실제 여기에 연결되어있는, 동일하게 같은 메소드가 재정의되어있으면
		// 흘러내려서 마지막에 정의된 걸 사용한다.
		//마지막에 정의된 메서드가 호출되어진다.
		sound(dog); 
		sound(an);
		sound(pig);
		
	}
		
	// 메소드 오버라이딩(overriding) 사용===========
	//부모요소에 있는 메서드를 가지고 재정의해서 쓰게되면
	//계속 뭔가가 추가돼도 코드수정 없이
	//그냥 호출하면 해당 객체 (담겨져 있는게 뭐냐에 따라서)
	// 형태는 하나인데(animal.sound()) 여러방식으로 동작함.
	// 이 안에 담긴 객체에 따라 ! 다양한 형태로 사용되어진다. => 다형성
	// 상위타입에 담아 호출했을 때 담긴 객체가 뭐냐에 따라
	// 개를 줬을 때 멍멍할 수 있는 것. 
	static void sound(Animal animal) {
		animal.sound();
	} //

	
	// instanceof 사용 타입 확인하는 패턴===========
	static void sound_instanceof(Animal animal) {
		if (animal instanceof Cat) {
			((Cat) animal).sound(); // 부모타입에 메서드가 없어서 형변환해서 사용했음
		} else if (animal instanceof Dog) {
			((Dog) animal).sound();
		} 
	}

	// 메소드 오버로딩(overloading) 방식 =========
	static void sound_overloading(Cat cat) {
		cat.sound();
	} // 같은 이름의 메소드를 써서 전달받는 파라미터의 갯수, 순서 달리해서~~

	static void sound_overloading(Dog dog) {
		dog.sound();
	}
	
	static void sound_overloading(Pig pig) {
		pig.sound();
	}

}
