package com.mystudy.poly2_overriding;

public class Pig extends Animal {
	
	@Override //컴파일러가 컴파일 시점에 체크할 수 있도록
	void sound() {
		System.out.println(">> 꿀~");
	}
	
	

}
