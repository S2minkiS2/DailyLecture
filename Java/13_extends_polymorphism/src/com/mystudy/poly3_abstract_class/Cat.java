package com.mystudy.poly3_abstract_class;

class Cat extends AbstractAnimal {
	// 자녀(하위) 클래스에 공통으로 있는 메소드를 정의
	// 자녀(하위) 클래스에서 필요에 따라 재정의해서 사용하도록 함
	//오버라이드 : interface에 있는 것 혹은 부모요소에 있는걸 재정의함
	
	//부모클래스(Animal)의 sound() 메소드와 동일하게 선언하고 
	//기능은 다르게 구현(메소드의 재정의 - method overriding)
	// 메소드 재정의 시 기본적으로 메소드 선언부를 동일하게 작성
	//단, 메소드 접근제한자의 범위를 부모와 동일하거나 더 크게(넓게) 정의가능
	// 지금의 default 보다 좁은 private은 안된다.
	// 		(부모가 허용한 것보다 좁게 설정할 수 없다)

	
	@Override //메소드 오버라이딩해서 사용하는 메소드임을 컴파일러에게 알리는 주석문(어노테이션)
	void sound() {
		System.out.println(">> 먀~옹먀옹먛먛");
	} //재정의
	
	
	
	
}
