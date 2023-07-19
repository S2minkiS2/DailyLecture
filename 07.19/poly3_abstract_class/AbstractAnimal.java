package com.mystudy.poly3_abstract_class;

// 추상클래스: abstract class
// 클래스에 추상메서드가 1개 이상 있으면 추상클래스로 선언해야 한다.
// 추상클래스는 객체(인스턴스) 생성 할 수 없음
abstract class AbstractAnimal {
	String name; // 이름, 명칭
	int legCnt; // 다리갯수
	
	void eat() {
		System.out.println(">> 먹는다");
	}
	
	void sleep() {
		System.out.println(">> 잠을 잔다");
	}
	
	abstract void sound(); //추상메서드(abstract 메서드)
	
	
}
