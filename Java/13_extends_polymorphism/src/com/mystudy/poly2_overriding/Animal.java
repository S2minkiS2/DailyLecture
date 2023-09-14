package com.mystudy.poly2_overriding;

class Animal { //(default)
	//명칭은 똑같지만 다르게 동작하게끔 재정의. 새롭게 사용 (상속관계에서)
	
	//필드
	String name; // 이름, 명칭
	int legCnt; // 다리갯수
	
	//메서드
	void eat() {
		System.out.println(">> 먹는다");
	}
	
	void sleep() {
		System.out.println(">> 잠을 잔다");
	}
	void sound() {
		System.out.println(">> Animal 소리없음");
	}
	
}
