package com.mystudy.generic;

class BoxT<T> {
	T obj;
	
	T getObj() {
		return obj;
	}
	
	void setObj(T obj) {
		this.obj = obj;
	}
}

public class GenericWildcardExam {

	public static void main(String[] args) {
		// 제네릭(Generic)의 대표문자(wildcard)
	    // 1. <?> : 모든 타입(객체) 자료형에 대한 대표문자를 의미
	    // 2. <? extends 자료형> : 자료형을 상속받은 자녀(sub) 클래스 타입 사용
	    // 3. <? super 자료형> : 자료형의 부모(super) 타입 사용           
		//-------------------------------------------------------
		
		BoxT<String> box1 = new BoxT<String>();
		box1.setObj("문자열");
		
		BoxT<Integer> box2 = new BoxT<>();
		box2.setObj(1000); //Integer 타입 저장
		
		System.out.println("------------------------------------");
		//<?> 모든 것을 담을 수 있는 형태
		BoxT<?> box3 = new BoxT<String>();
		box3 = new BoxT<Integer>();
		box3 = new BoxT<StringBuilder>();
		
		
		//<? extends 자료형> : 자료형을 상속받은 자녀(sub) 클래스 타입 사용 (아래로만 사용 가능)		
		BoxT<? extends Number> box4 = null;
		box4 = new BoxT<Number>(); //자기자신도 가능하다
		box4 = new BoxT<Integer>();
		box4 = new BoxT<Double>();
		
//		[컴파일오류] Character 가 Number타입을 상속(extends)받지 않음
//		box4 = new BoxT<Character>();
		
//		==========================================================
//		<? super 자료형> : 자료형의 부모(super) 타입 사용 (위로만 사용 가능)      
		BoxT<? super Number> box5 = null;
		box5 = new BoxT<Number>();
		box5 = new BoxT<Object>();
//		box5 = new BoxT<Integer>();  //자녀타입은 안된다. 컴파일 오류 발생
		
		
		
		
		
		
		
		

	}

}
