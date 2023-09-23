package com.mystudy.innerclass;

public class LocalClass { //지역클래스
	//필드
	int a = 100; 
	
	void print() {
		System.out.println("a : " + a);
	}
	
	void innerTest(int k) {
		int b = 200; //지역변수(Local variable)
		int c = k;
		
		//로컬클래스, 지역클래스 (로컬 영역에 작성된 클래스다)
		//메소드 내에 선언된 클래스
		//선언된 메소드 내부에서만 사용 가능
		//메소드가 실행됐을 때만 코드가 동작하기 때문에!
		class Inner { //메소드 내부에 클래스 선언
			//내부에서 선언된 클래스는 외부에서 사용 불가
			void printData() {
				System.out.println("외부클래스 int a : " + a);
				System.out.println("메소드영역에 작성된 int b : " + b);
				System.out.println("메소드영역 int c : " + c);
				System.out.println("파라미터 int k : " + k);
				
			}
		}
		Inner in = new Inner();
		in.printData();
		
	}
}
