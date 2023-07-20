package com.mystudy.innerclass;

public class StaticClassTest {

	int a = 100;
	private int b = 100;
	static int c = 200;

	static int sum = 0;
	static int sNum1 = 20;
	static int sNum2 = 30;

	static void sum() { // static 메서드는 위 필드변수 중에서 static 변수만 쓸 수 있다.
//			sum = a + b; (a와 b는 static이 아니어서 호출 불가)
//			sum = sNum1 + sNum2;
		sum = Inner.d + sNum2;
	}

	static class Inner { // 클래스 자체가 static이어서 non-static 변수에 접근 불가
		static int d = 1000;
		int e = 2000; // non-static

		void printData() { // non-static //메소드는 non-static이지만 소속되어있는 클래스가 static이어서... ㅇ??
//				System.out.println("외부 int a : " + a); // 클래스 자체가 static이어서 non-static 변수에 접근 불가
			System.out.println("외부 static int c : " + c); // c는 외부 static, 오류 안나요
			System.out.println("내부 static int d : " + d); // d도 내부 static, 오류 안나요
			System.out.println("내부 int e : " + e); // 내부니까 당연히 사용 가능.
			sum();
			System.out.println("외부 static int sum : " + sum);
		}

	}

	

	public static void main(String[] args) {
		int num = StaticClassTest.c;

		// static 내부클래스의 static필드변수 사용
		int innerNum = StaticClassTest.Inner.d;

		// static 내부클래스의 객체(인스턴스) 생성 후 printData() 호출
		StaticClassTest.Inner inner = new StaticClassTest.Inner();
		inner.printData();
	}

}
