package com.mystudy.innerclass;

public class StaticClassTest { //외부클래스
	int a = 100;
	private int b = 100;
	static int c = 200;
	
	static int sum = 0;
	static int sNum1 = 20;
	static int sNum2 = 30;
	
	
	static void sum() {
//		sum = sNum1 + sNum2;
		sum = Inner.d + sNum2; //같은 static 변수라 가능
		
	}
		// sum = a + b; // static에서는 인스턴트 변수를 사용할 수 없다.
		//생성 시점이 다르기 때문에.
		//class가 로딩되는 순간 코드 쓰는 순간 static은 클래스 영역에 같이
		// 스태틱 선언이 되어있다. 그 시점에 같이 만들어져있다.
		//스태틱이 붙지 않은 것들은 new를 붙여 객체를 생성할 때 만들어진다.
		// static이 생성될 때는 객체가 없다.
		// static은 static끼리만 쓸 수 있다 (생성 시점이 다르기 때문에)
		// static 안에서 쓰려면 변수가 다 static이어야함.
	
	
	// non static 영역에선 static 사용 불가
	
	//스태틱(static) 내부 클래스
	static class Inner {
		static int d = 1000;
		int e = 2000; //non-static 
		
		void printData() { 
			//메소드 자체는 넌스태틱이지만 소속된 클래스가 스태틱이므로 스태틱.
			//System.out.println("외부 int a : " + a); //넌스태틱 a에 접근불가.
			System.out.println("외부 static int c : " + c);
			System.out.println("내부 static int c : " + d);
			System.out.println("내부 static int e : " + e);
			sum(); //메소드호출
			System.out.println("내부 static int sum : " + sum);
			
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int num = StaticClassTest.c;
		
		//static 내부클래스의 static 필드변수사용
		int innerNum = StaticClassTest.Inner.d;
				
		//static 내부클래스의 객체(인스턴스) 생성 후 printData() 호출(실행)
		StaticClassTest.Inner inner = new StaticClassTest.Inner();
		inner.printData();

	}

}
