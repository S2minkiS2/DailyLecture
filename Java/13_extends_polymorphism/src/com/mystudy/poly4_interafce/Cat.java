package com.mystudy.poly4_interafce;

public class Cat extends AbstractAnimal {

	public Cat() {
		super("고양이"); //부모클래스에 있는 메서드
	}
	
	@Override
	public void sound() {
		System.out.println(super.getName() + ">> 야옹~ 야옹~");
		//부모타입에 있으면 가져다 쓴다
		//super 생략 가능, 명시적으로 사용해봄
	}

	public void test() {
		System.out.println(">> 테스트용 메소드 실행~~~");
	}
	
}

