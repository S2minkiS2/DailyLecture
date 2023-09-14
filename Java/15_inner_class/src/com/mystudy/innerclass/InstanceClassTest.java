package com.mystudy.innerclass;

public class InstanceClassTest {
	int a = 100;
	private int b = 10;
	static int c = 200;
	int sum = 0;
	
	void sum() {
		sum = a + b;
	}
	
	//내부 클래스 : 인스턴스 클래스
	class Inner { //static이 안붙었으므로 객체 생성을 해야함
		int in = 100;
		void printData() {
			//내부에서는 외부에 있는 것들 사용가능 (private, static변수 포함)
			System.out.println("외부 int a: " + a);
			System.out.println("외부 private int b: " + b);
			System.out.println("외부 static int a: " + a);
			sum();
			System.out.println("sum : " + sum);
			
			System.out.println("내부 클래스 필드 in : " + in);
		}
	}
	
	
	//static
	public static void main(String[] args) {
		InstanceClassTest out = new InstanceClassTest();
		System.out.println("필드변수 a : " + out.a);
		
		
		System.out.println("--- 내부 인스턴스 클래스 사용 ---");
		// 내부 클래스 타입 : 외부클래스명.내부클래스명
		// 외부클래스명$내부클래스명.class
		//외부 클래스에 있는 inner 타입
		// 인스턴스 클래스의 객체(인스턴스) 생성하기 위해서는외부 클래스 객체를 통해서 생성할 수 없다.
		InstanceClassTest.Inner inner = new InstanceClassTest().new Inner();
		//InstanceClassTest.Inner inner = out.new Inner();
		inner.printData();
		
		
		
		
	}

}
