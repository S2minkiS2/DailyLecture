package com.mystudy.innerclass;

public class InstanceClassTest {
	int a = 100; //인스턴스 변수
	private int b = 10;
	static int c = 200;
	int sum = 0;
	
	void sum() { //인스턴스 메서드
		sum = a +b;
	}
	// 내부 클래스가 옵니다. 메인메서드가 실행되기 전에..
	// 내부 클래스 : 인스턴스 클래스
	class Inner{ //인스턴스 클래스
		int in = 100;
		void printData() {
			//내부에서 외부클래스의 멤버를 가져와 쓸 수 있다.
			System.out.println("외부 int a : " + a);
			System.out.println("외부 private int b : " + b); // private이지만 같은 클래스 안에 있으므로 가능.
			System.out.println("외부 static int c : " + c);
			sum(); // 외부 메서드 호출
			System.out.println("sum : " + sum);
			
			System.out.println("내부클래스 필드변수 int in : " + in);
			
		}
	}
	
	

	public static void main(String[] args) {
		InstanceClassTest out = new InstanceClassTest();
		System.out.println("필드변수 a : " + out.a);
		
		
		System.out.println("----- 내부 인스턴스 클래스 사용 -----");
		//내부클래스 타입 : 외부클래스명.내부클래스명
		//인스턴스 클래스의 객체생성하기 위해서는 외부클래스 객체(위의 out)를 통해서 생성할 수 있다.
		InstanceClassTest.Inner inner01 = out.new Inner(); 
		//만들어놓은 외부클래스 객체가 없다면,
		InstanceClassTest.Inner inner02 = new InstanceClassTest().new Inner(); //만들고. 또 만들어
		
		inner01.printData();
		inner02.printData();
		
		
		
		
	}

}
