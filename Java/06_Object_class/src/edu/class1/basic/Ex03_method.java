package edu.class1.basic;

public class Ex03_method {
	
	Ex03_method() {} //기본 생성자 작성

	public static void main(String[] args) { //메인메소드가 static
		//static 변수는 필요에 따라 붙는다. 통상적으론 non-static을 더 많이 사용
		int num1 = 500;
		int num2 = 200;
		int sum = 0;
		
		sum = add(num1, num2); //메소드 실행 (호출) - int 타입, 갯수 일치
		//돌려받은 데이터를 sum에 저장
		System.out.println("sum : " + sum);
		
		
		//static영역에서 non-static영역 접근시 객체(인스턴스)를 통해서 사용
		//인스턴스(객체)를 사용하면 static, non-static 변수, 메소드 모두 사용가능
		Ex03_method ex03 = new Ex03_method(); //해당 데이터타입 객체를 만든다
							 //------------- 생성자 호출
		ex03.sub(num1, num2); 
		System.out.println("sub : " + ex03.sub(num1, num2));
		System.out.println("mul : " + ex03.mul(num1, num2));
		System.out.println("div : " + ex03.div(num1, num2));
	}
	
	//메소드 선언 (static)
	static int add(int a, int b) { //add메소드
		return a + b;
	} //클래스 영역에 작성해야함
	
	// 메소드 선언 (non-static)
	// 메소드 : 기능, 동작
	int sub(int a, int b) {
		return a - b;
	}
	
	int  mul(int a, int b) {
		return a * b;
	}
	
	int div(int a, int b) {
		return a / b;
	}
	
	
	//리턴타입 : 있다(무한대)-모든데이터타입 / 없다(void)
	
	//메소드 형태 : 파라미터 값 유무, 리턴값 유무
	void method1() {
	//실행하고끝-받는것도주는것도없음 
		System.out.println("파라미터값 X, return 값 X");
	}
	
	void method2(String param) { //뭔가 전달받아서 작업처리 해야하는경우
		System.out.println("파라미터값 O, return 값 X");
	}
	
	String method3()//메소드 선언부,정의부  
						{ //메소드 실행부
		System.out.println("파라미터값 X, return 값 O");
		return "파라미터값 X, return 값 O";
	}
	
	String method4(String param) {
		System.out.println("파라미터값 O, return 값 O");
		return "파라미터값 O, return 값 O";
		
	}

}
