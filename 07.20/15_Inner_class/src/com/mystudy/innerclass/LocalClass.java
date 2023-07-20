package com.mystudy.innerclass;

public class LocalClass {
	int a = 100;
	
	void print() {
		System.out.println("a : " + a);
	}
	
	void innerTest(int k) {
		int b = 200; //지역변수(local variable). 메서드 실행시에만 존재하는 멤버들 (지역클래스 포함)
		int c = k;
		
		//선언된 메소드 내부에서만 사용 가능
		class Inner { //로컬 클래스 or 지역 클래스 - 메서드 내에 선언된 클래스~
			void printData() {
				System.out.println("외부클래스 int a : " + a); // 내부에서는 외부 변수들 호출 가능
				System.out.println("메서드 int b : " + b);
				System.out.println("메서드 int c : " + c);
				System.out.println("파라미터 int k : " + k); // 파라미터 역시 지역변수
				
			}
		}
		
		Inner in = new Inner();
		in.printData();
	}

}
