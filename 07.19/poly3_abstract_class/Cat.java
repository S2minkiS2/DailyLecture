package com.mystudy.poly3_abstract_class;

class Cat extends AbstractAnimal {
	
	// 부모클래스(Animal)의 sound()와 동일하게 선언하고
	// 기능은 다르게 구현(메소드의 재정의 - method overriding)
	// 메소드 재정의시 기본적으로 메소드 선언부를 동일하게 작성한다.
	// 단, 메소드 접근제한자의 범위를 부모와 동일하거나, 더 크게(넓게) 정의 가능 
	//		(== 부모가 쓸수 있게 해놓은 범위를 더 좁게 수정은 불가능)
	
	@Override // 메소드 오버라이딩해서 사용하는 메소드임을 컴파일러에게(to computer) 알리는 어노테이션(주석) = 오류를 방지해준다.
	void sound() {//		@Override 한 덕에, 부모클래스에서 메서드에 변경이 일어날 경우, 에러메세지를 표출해준다.
		System.out.println(">> 야옹야옹");
	}
	
	
}
