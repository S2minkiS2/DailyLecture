package edu.class1.basic;


//클래스 선언부
//클래스 내부에 속하는 내용 : 변수선언, 생성자, 메소드 선언
public class Ex02_class {

	
	// ==========변수 선언 영역================================
	int num = 111; // 자리 제약은 없으나 특별한 경우가 아니며 변수 선언은 첫번째로 한다.
	//필드변수 (인스턴스변수, 멤버변수, 속성-property, 전역변수 -지역변수와 대치되는단어) 
	// (클래스 영역에서 쓰일 수 있는)
	
	//클래스변수, 스태틱변수, 인스턴스(객체)공통변수(의미상)
	static int staticNum = 222;
	
	// ======== 생성자 선언 영역 ==========
	// 호출되어지는것//클래스 이름을 사용한다.
	Ex02_class() {} // 기본생성자 (default constructor) 생략가능

	
	// ======== 메소드 선언 영역 ==========
	// main 메소드
	public static void main(String[] args) {
		// 지역변수 (local vriable)
		
		int num1 = 300;
//		System.out.println("num : " + num); //non-static 접근불가
		System.out.println("staticNum : " + staticNum);
		
		Ex02_class ex02 = new Ex02_class();
		System.out.println("ex02 " + ex02);
		// ex02. => ctrl+space -> 이 객체에 있는 변수 쓸 수 있다
		System.out.println("ex02.staticNum : " + ex02.staticNum);
		System.out.println("-----------");
		
		int result = add(100, 200); //static 영역의 메소드라 오류가 없음. 여기도 static 영역
		System.out.println("add() 결과 : " + result);
	}
	
	static int add(int a, int b) {
		return a + b;
	}
}





