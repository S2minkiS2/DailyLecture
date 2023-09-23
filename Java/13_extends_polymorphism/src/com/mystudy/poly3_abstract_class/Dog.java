package com.mystudy.poly3_abstract_class;

class Dog extends AbstractAnimal {
	
	@Override //메소드 오버라이딩해서 사용하는 메소드임을 컴파일러에게 알리는 주석문(어노테이션)
	void sound() {
		System.out.println(">> 멍멍!!");
	}

}
